package com.scalablecapitaltask.data.local

import android.arch.persistence.room.*
import com.scalablecapitaltask.constants.DataBaseConstants
import com.scalablecapitaltask.data.models.Repository
import io.reactivex.Flowable

/**
 * Created by ziadgholmish on 3/1/18.
 */
@Dao
interface RepositoryDAO {

    @Query("SELECT * FROM ${DataBaseConstants.REPOSITORY_TABLE_NAME}")
    fun getRepositories(): List<Repository>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepository(repository: Repository)

    @Update
    fun updateRepository(repository: Repository): Int

    @Query("DELETE FROM ${DataBaseConstants.REPOSITORY_TABLE_NAME}")
    fun deleteTasks()

}
