package com.scalablecapitaltask.data.remote.commits

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scalablecapitaltask.constants.APIConstants
import com.scalablecapitaltask.data.LoadCommitsCallback
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.CommitEntity
import com.scalablecapitaltask.data.models.RepositoryEntity
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by ziadgholmish on 3/2/18.
 */
class CommitWebService(private val callback: LoadCommitsCallback, private val userName: String,
                       private val repoName: String) : AsyncTask<String, Void, List<CommitEntity>>() {

    private val json = Gson()

    override fun doInBackground(vararg p0: String?): List<CommitEntity>? {
        val url = URL("https://api.github.com/repos/$userName/$repoName/commits")
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val inputStream = BufferedInputStream(urlConnection.inputStream)
            val repositoriesJsonArray = readStream(inputStream as InputStream)
            return convertJsonToDataClass(repositoriesJsonArray)
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            urlConnection.disconnect()
        }
        return null
    }

    override fun onPostExecute(result: List<CommitEntity>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (!result.isEmpty()) {
                callback.onCommitsLoaded(result)
            } else {
                callback.onDataNotAvailable()
            }
        }
    }

    private fun readStream(inputStream: InputStream): String {
        return inputStream.bufferedReader().use(BufferedReader::readText)
    }

    private fun convertJsonToDataClass(response: String): List<CommitEntity> {
        val commitsListType = object : TypeToken<ArrayList<CommitEntity>>() {}.type
        return json.fromJson(response, commitsListType)
    }
}