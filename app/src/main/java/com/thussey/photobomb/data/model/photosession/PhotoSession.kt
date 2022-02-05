package com.thussey.photobomb.data.model.photosession

import java.util.*

/**
 * Data class that represents a photo session. A photo session links to several photos.
 */
data class PhotoSession(val photoSessionId : String = UUID.randomUUID().toString(),
                        val userId : String = "",
                        val title : String = "Default Title",
                        val date : Date = Date(),
                        val expired : Boolean = false,
                        val thumbnailPhotoId : String = "")
