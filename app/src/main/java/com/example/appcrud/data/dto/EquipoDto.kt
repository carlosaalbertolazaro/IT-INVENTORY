package com.example.appcrud.data.dto

/**
 * EquipoDto: Data Transfer Object. Es la representación que entiende la API (JSON).
 * Debe coincidir con los campos que envía/recibe el backend.
 */
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
