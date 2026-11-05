package com.example.appcrud.domain.repository

import com.example.appcrud.domain.model.Equipo
import kotlin.Result

/**
 * EquipoRepository: interfaz del dominio. Define las operaciones CRUD sin saber
 * cómo se implementan (puede ser API remote, local, o ambos).
 */
interface EquipoRepository {
    suspend fun listarEquipos(): Result<List<Equipo>>
    suspend fun obtenerEquipo(id: String): Result<Equipo>
    suspend fun crearEquipo(equipo: Equipo): Result<Equipo>
    suspend fun actualizarEquipo(id: String, equipo: Equipo): Result<Equipo>
    suspend fun eliminarEquipo(id: String): Result<Unit>
}
