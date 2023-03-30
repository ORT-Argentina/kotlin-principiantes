package ar.edu.ort.requestexamples.entities

import ar.edu.ort.requestexamples.data.Thumbnail
import com.google.gson.annotations.SerializedName

data class MarvelComic(
    @field:SerializedName("id") val id: Number,
    @field:SerializedName("title") val Title: String,
    @field:SerializedName("thumbnail") val thumbnail: Thumbnail
)