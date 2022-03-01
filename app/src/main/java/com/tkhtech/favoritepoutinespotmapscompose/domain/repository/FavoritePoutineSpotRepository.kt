package com.tkhtech.favoritepoutinespotmapscompose.domain.repository

import com.tkhtech.favoritepoutinespotmapscompose.domain.model.FavoritePoutineSpot
import kotlinx.coroutines.flow.Flow

interface FavoritePoutineSpotRepository {

    suspend fun insertFavoritePoutineSpot(spot: FavoritePoutineSpot)

    suspend fun deleteFavoritePoutineSpot(spot: FavoritePoutineSpot)

    fun getFavoritePoutineSpots(): Flow<List<FavoritePoutineSpot>>
}