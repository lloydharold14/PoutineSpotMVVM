package com.tkhtech.favoritepoutinespotmapscompose.presentation

import com.google.android.gms.maps.model.LatLng
import com.tkhtech.favoritepoutinespotmapscompose.domain.model.FavoritePoutineSpot

sealed class MapEvent {
    object Togglefalloutmap : MapEvent()
    data class onMapLongClick(val latlng: LatLng) : MapEvent()
    data class onIinfoWindowLongClick(val spot: FavoritePoutineSpot): MapEvent()
}