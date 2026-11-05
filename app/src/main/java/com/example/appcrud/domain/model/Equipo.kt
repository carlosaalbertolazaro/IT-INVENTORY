package com.example.appcrud.domain.model

data class Equipo(
    val id: String = "",
    val numeroSerie: String = "",
    val marca: String = "",
    val modelo: String = "",
    val fechaAdquisicion: String = "",
    val estado: EquipoEstado = EquipoEstado.DISPONIBLE,
    val numeroInventario: Int = 0,
    val ubicacion: String = ""
)
