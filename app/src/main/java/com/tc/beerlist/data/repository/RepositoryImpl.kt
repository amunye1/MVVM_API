package com.tc.beerlist.data.repository

import com.tc.beerlist.data.model.beer.BeerListItemModel
import com.tc.beerlist.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor (val api: ApiRequest) : Repository {

    override suspend fun getBeers():List<BeerListItemModel> {
        return api.getBeers()
    }

    /*
    * if return type is obvious we can do override suspend fun getBeers
    * override suspend fun getBeers() = api.getBeers()
    * */


    override suspend fun getBeerItem( id:Int): List<BeerListItemModel>{
        return api.getBeerItem(id)
    }
}