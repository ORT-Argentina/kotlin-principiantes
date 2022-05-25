package ar.edu.ort.requestexamples.data

import ar.edu.ort.requestexamples.entities.MarvelHereo
import com.google.gson.annotations.SerializedName

data class CharacterResponse (
    @field:SerializedName("count") val count: Int,
    @field:SerializedName("results") val results: List<MarvelHereo>
)