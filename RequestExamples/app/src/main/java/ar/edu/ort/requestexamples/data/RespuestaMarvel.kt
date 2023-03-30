package ar.edu.ort.requestexamples.data

import com.google.gson.annotations.SerializedName

data class RespuestaMarvel<Tdata>(
    @field:SerializedName("code") val code: Number,
    @field:SerializedName("status") val status: String,
    @field:SerializedName("data") val data: PaginacionMarvel<Tdata>
)
