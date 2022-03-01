package com.tkhtech.favoritepoutinespotmapscompose.data

import com.tkhtech.favoritepoutinespotmapscompose.domain.model.FavoritePoutineSpot
import com.tkhtech.favoritepoutinespotmapscompose.domain.repository.FavoritePoutineSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class FavoritePoutineSpotRepositoryImpl(
    private val dao: FavoritePoutineSpotDao
) : FavoritePoutineSpotRepository {
    override suspend fun insertFavoritePoutineSpot(spot: FavoritePoutineSpot) {
        dao.insertFavoritePoutineSpot(spot.toFavoritePoutineSpotEntity())
    }

    override suspend fun deleteFavoritePoutineSpot(spot: FavoritePoutineSpot) {
        dao.deleteFavoritePoutineSpot(spot.toFavoritePoutineSpotEntity())
    }

    override fun getFavoritePoutineSpots(): Flow<List<FavoritePoutineSpot>> {
        return dao.getFavoritePoutineSpots().map { spots ->
            spots.map { it.toFavoritePoutineSpot() }

        }
    }
}