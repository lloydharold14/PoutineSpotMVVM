package com.tkhtech.favoritepoutinespotmapscompose.data

import com.tkhtech.favoritepoutinespotmapscompose.domain.model.FavoritePoutineSpot

fun FavoritePoutineSpotEntity.toFavoritePoutineSpot(): FavoritePoutineSpot {
    return FavoritePoutineSpot(
        lat = lat,
        lng = lng,
        id = id
    )
}

fun FavoritePoutineSpot.toFavoritePoutineSpotEntity(): FavoritePoutineSpotEntity {
    return FavoritePoutineSpotEntity(
        lat = lat,
        lng = lng,
        id = id

    )
}