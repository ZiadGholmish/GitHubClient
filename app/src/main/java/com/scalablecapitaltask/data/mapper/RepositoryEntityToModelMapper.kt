package com.scalablecapitaltask.data.mapper

import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.domain.models.RepositoryModel
import java.util.ArrayList

/**
 * Created by ziadgholmish on 3/2/18.
 */
class RepositoryEntityToModelMapper {
    companion object {
        /**
         * transfer repository entity that come from data layer to the domain model
         * and format data required
         */
        fun transform(repositoryEntity: RepositoryEntity): RepositoryModel {
            val desc = repositoryEntity.description ?: ""
            var repositoryModel = RepositoryModel(
                    repositoryEntity.name,
                    repositoryEntity.full_name,
                    desc,
                    repositoryEntity.language,
                    repositoryEntity.fork,
                    repositoryEntity.url,
                    repositoryEntity.created_at,
                    repositoryEntity.updated_at,
                    repositoryEntity.pushed_at,
                    repositoryEntity.owner.login,
                    repositoryEntity.owner.avatar_url,
                    repositoryEntity.owner.gravatar_id,
                    repositoryEntity.owner.url,
                    repositoryEntity.owner.repos_url
                    , null)
            return repositoryModel
        }
    }
}