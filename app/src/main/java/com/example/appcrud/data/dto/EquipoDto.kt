package com.example.appcrud.data.dto

data class EquipoDto(
    val id: String? = null,
    val numeroSerie: String? = null,
    val marca: String? = null,
    val modelo: String? = null,
    val fechaAdquisicion: String? = null,
    val estado: String? = null,
    val numeroInventario: Int? = null,
    val ubicacion: String? = null
)
