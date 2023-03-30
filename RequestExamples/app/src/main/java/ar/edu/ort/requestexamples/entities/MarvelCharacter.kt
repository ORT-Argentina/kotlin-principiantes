package ar.edu.ort.requestexamples.entities

import ar.edu.ort.requestexamples.data.Thumbnail
import com.google.gson.annotations.SerializedName

data class MarvelCharacter(
    @field:SerializedName("id") val id: Number,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("description") val description: String,
    @field:SerializedName("thumbnail") var thumbnail: Thumbnail
)
