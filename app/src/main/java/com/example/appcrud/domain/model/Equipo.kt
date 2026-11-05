package com.example.appcrud.domain.model

/**
 * Equipo: modelo de dominio (entidad principal del CRUD).
 * Requisitos de la rúbrica:
 *   - identificador (id)
 *   - al menos 5 atributos propios
 *   - al menos 1 numérico, 1 de fecha o booleano, 1 de texto
 *   - al menos 2 atributos con reglas de validación
 *
 * Ejemplo de atributos:
 *   id: String
 *   numeroSerie: String
 *   marca: String
 *   modelo: String
 *   fechaAdquisicion: String (fecha ISO)
 *   estado: EquipoEstado (enum)
 *   numeroInventario: Int (numérico)
 *   ubicacion: String
 */
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
