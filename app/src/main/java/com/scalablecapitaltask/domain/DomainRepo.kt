package com.scalablecapitaltask.domain

import com.scalablecapitaltask.data.LoadRepositoriesCallback

/**
 * Created by ziadgholmish on 3/2/18.
 */

interface DomainRepo{

    fun getRepositories(callback: FetchRepositoriesCallback)

}