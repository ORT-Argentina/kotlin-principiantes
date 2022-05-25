package ar.edu.ort.requestexamples.entities

import ar.edu.ort.requestexamples.data.Thumbnail
import com.google.gson.annotations.SerializedName

data class MarvelHereo(
        /*var id: Number,
        var name: String,
        var description: String,
        var modified: String,
        var thumbnail: Thumbnail*/
        @field:SerializedName("id") val id: Number,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String,
        @field:SerializedName("modified") val modified: String,
        @field:SerializedName("thumbnail") val thumbnail: Thumbnail
)