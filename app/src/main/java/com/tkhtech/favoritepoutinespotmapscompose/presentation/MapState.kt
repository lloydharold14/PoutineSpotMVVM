package com.tkhtech.favoritepoutinespotmapscompose.presentation

import com.google.maps.android.compose.MapProperties
import com.tkhtech.favoritepoutinespotmapscompose.domain.model.FavoritePoutineSpot

data class MapState(
    val properties: MapProperties = MapProperties(),
    val favoritePoutineSpots: List<FavoritePoutineSpot> = emptyList(),
    val isFalloutMap: Boolean = false
) {
}