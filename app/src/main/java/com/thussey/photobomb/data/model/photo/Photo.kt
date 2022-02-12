package com.thussey.photobomb.data.model.photo

import java.io.Serializable
import java.util.*

data class Photo(val id : UUID = UUID.randomUUID(),
                 val photoSessionId  : UUID = UUID.randomUUID(),
                 val name : String = "",
                 val url : String = "",
                 val isThumbnail : Boolean = false,
                 val isFavorite : Boolean = false) : Serializable
