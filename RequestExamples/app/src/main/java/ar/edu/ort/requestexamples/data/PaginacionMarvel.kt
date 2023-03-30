package ar.edu.ort.requestexamples.data

import com.google.gson.annotations.SerializedName

data class PaginacionMarvel<Tdata>(
    @field:SerializedName("total") val total: Number,
    @field:SerializedName("count") val count: Number,
    @field:SerializedName("results") val results: List<Tdata>
)
