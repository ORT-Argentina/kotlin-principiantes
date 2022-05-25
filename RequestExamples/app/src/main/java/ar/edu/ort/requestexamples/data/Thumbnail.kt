package ar.edu.ort.requestexamples.data

import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @field:SerializedName("path") val small: String,
    @field:SerializedName("extension") val extension: String
)