package com.scalablecapitaltask.data.local

import android.arch.persistence.room.*
import com.scalablecapitaltask.constants.DataBaseConstants
import com.scalablecapitaltask.data.models.RepositoryEntity

/**
 * Created by ziadgholmish on 3/1/18.
 */
@Dao
interface RepositoryDAO {

    /**
     * query the list of available repositories from the database
     */
    @Query("SELECT * FROM ${DataBaseConstants.REPOSITORY_TABLE_NAME} ORDER BY id ASC")
    fun getRepositories(): List<RepositoryEntity>

    /**
     * insert new row or update current one
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepository(repository: RepositoryEntity)

    @Update
    fun updateRepository(repository: RepositoryEntity): Int

    /**
     * drop the all repositories
     */
    @Query("DELETE FROM ${DataBaseConstants.REPOSITORY_TABLE_NAME}")
    fun deleteRepositories()

}
