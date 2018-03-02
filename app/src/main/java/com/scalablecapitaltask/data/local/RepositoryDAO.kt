package com.scalablecapitaltask.data.local

import android.arch.persistence.room.*
import com.scalablecapitaltask.constants.DataBaseConstants
import com.scalablecapitaltask.data.models.RepositoryEntity

/**
 * Created by ziadgholmish on 3/1/18.
 */
@Dao
interface RepositoryDAO {

    @Query("SELECT * FROM ${DataBaseConstants.REPOSITORY_TABLE_NAME}")
    fun getRepositories(): List<RepositoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepository(repository: RepositoryEntity)

    @Update
    fun updateRepository(repository: RepositoryEntity): Int

    @Query("DELETE FROM ${DataBaseConstants.REPOSITORY_TABLE_NAME}")
    fun deleteTasks()

}
