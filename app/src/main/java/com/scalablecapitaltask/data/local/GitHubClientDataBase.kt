package com.scalablecapitaltask.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.scalablecapitaltask.constants.DataBaseConstants
import com.scalablecapitaltask.data.models.Repository

/**
 * Created by ziadgholmish on 3/1/18.
 */
@Database(entities = [Repository::class], version = 1)
@TypeConverters(OwnerTypeConverter::class)
abstract class GitHubClientDataBase : RoomDatabase() {
    abstract fun repositoryDAO(): RepositoryDAO
    companion object {
        var instance: GitHubClientDataBase? = null
        fun getInstance(context: Context): GitHubClientDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        GitHubClientDataBase::class.java, DataBaseConstants.GIT_HUB_DATA_BASE_NAME)
                        .build()
            }
            return instance as GitHubClientDataBase
        }
    }
}