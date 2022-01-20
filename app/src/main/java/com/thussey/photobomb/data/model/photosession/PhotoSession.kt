package com.thussey.photobomb.data.model.photosession

import java.util.*

/**
 * Data class that represents a photo session. A photo session links to several photos.
 */
data class PhotoSession(val photoSessionId : String = "-1",
                        val title : String = "PhotoSession",
                        val date : Date = Date(),
                        val thumbnail : String = "")
