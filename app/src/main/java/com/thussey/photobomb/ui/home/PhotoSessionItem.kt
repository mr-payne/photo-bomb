package com.thussey.photobomb.ui.home

import java.io.Serializable
import java.util.*

data class PhotoSessionItem(val photoSessionId : UUID = UUID.randomUUID(),
                            val thumbnailUrl : String = "",
                            val title : String = "",
                            val date : String = "") : Serializable