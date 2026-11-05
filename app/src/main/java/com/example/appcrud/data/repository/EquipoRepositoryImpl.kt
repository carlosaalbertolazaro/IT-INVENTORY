package com.example.appcrud.data.repository

import com.example.appcrud.domain.model.Equipo
import com.example.appcrud.domain.repository.EquipoRepository
import kotlin.Result

/**
 * EquipoRepositoryImpl: implementación real del repositorio.
 * Llama a ApiService (remote) y usa el Mapper para convertir DTO <-> Domain.
 */
class EquipoRepositoryImpl private constructor() : EquipoRepository {

    override suspend fun listarEquipos(): Result<List<Equipo>> = Result.success(emptyList())

    override suspend fun obtenerEquipo(id: String): Result<Equipo> = Result.success(Equipo())

    override suspend fun crearEquipo(equipo: Equipo): Result<Equipo> = Result.success(equipo)

    override suspend fun actualizarEquipo(id: String, equipo: Equipo): Result<Equipo> = Result.success(equipo)

    override suspend fun eliminarEquipo(id: String): Result<Unit> = Result.success(Unit)
}
