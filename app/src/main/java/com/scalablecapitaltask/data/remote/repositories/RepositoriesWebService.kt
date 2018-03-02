package com.scalablecapitaltask.data.remote.repositories

import android.os.AsyncTask
import com.scalablecapitaltask.constants.APIConstants
import java.net.HttpURLConnection
import java.net.URL
import com.google.gson.Gson
import com.scalablecapitaltask.data.models.RepositoryEntity
import java.io.*
import com.google.gson.reflect.TypeToken
import com.scalablecapitaltask.data.LoadRepositoriesCallback


/**
 * Created by ziadgholmish on 3/1/18.
 */
class RepositoriesWebService(private val callback: LoadRepositoriesCallback) : AsyncTask<String, Void, List<RepositoryEntity>>() {

    private val json = Gson()

    override fun doInBackground(vararg p0: String?): List<RepositoryEntity>? {
        val url = URL("${APIConstants.BASE_URL}${APIConstants.PROVINCES_PREFIX}")
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val inputStream = BufferedInputStream(urlConnection.inputStream)
            val repositoriesJsonArray = readStream(inputStream as InputStream)
            return convertJsonToDataClass(repositoriesJsonArray)
        } catch (ex: FileNotFoundException) {
            ex.printStackTrace()
        } finally {
            urlConnection.disconnect()
        }
        return null
    }

    override fun onPostExecute(result: List<RepositoryEntity>?) {
        super.onPostExecute(result)
        if (result != null && !result.isEmpty()) {
            callback.onRepositoriesLoaded(result)
        } else {
            callback.onDataNotAvailable()
        }
    }

    private fun readStream(inputStream: InputStream): String {
        return inputStream.bufferedReader().use(BufferedReader::readText)
    }

    private fun convertJsonToDataClass(response: String): List<RepositoryEntity> {
        val repositoryListType = object : TypeToken<ArrayList<RepositoryEntity>>() {}.type
        return json.fromJson(response, repositoryListType)
    }
}