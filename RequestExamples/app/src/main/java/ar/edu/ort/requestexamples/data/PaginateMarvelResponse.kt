package ar.edu.ort.requestexamples.data

import com.google.gson.annotations.SerializedName

data class PaginateMarvelResponse<Tdata> (
    @field:SerializedName("count") val count: Int,
    @field:SerializedName("results") val results: List<Tdata?>
)