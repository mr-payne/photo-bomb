package com.thussey.photobomb.data.model.photo

import java.util.*

data class Photo(val id : String = UUID.randomUUID().toString(),
                 val photoSessionId  : String = "",
                 val name : String = "",
                 val url : String = "",
                 val isThumbnail : Boolean = false,
                 val isFavorite : Boolean = false)
