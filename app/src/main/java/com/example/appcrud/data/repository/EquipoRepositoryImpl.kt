package com.example.appcrud.data.repository

import com.example.appcrud.data.dto.EquipoDto
import com.example.appcrud.data.mapper.EquipoMapper
import com.example.appcrud.data.remote.ApiService
import com.example.appcrud.domain.model.Equipo
import com.example.appcrud.domain.repository.EquipoRepository
import kotlin.Result
import retrofit2.Response

class EquipoRepositoryImpl private constructor(
    private val apiService: ApiService
) : EquipoRepository {

    override suspend fun listarEquipos(): Result<List<Equipo>> {
        return try {
            val response: Response<List<EquipoDto>> = apiService.listarEquipos()
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()?.map { EquipoMapper.toDomain(it) } ?: emptyList())
            } else {
                Result.success(emptyList())
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun obtenerEquipo(id: String): Result<Equipo> {
        return try {
            val response: Response<EquipoDto> = apiService.obtenerEquipo(id)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.success(EquipoMapper.toDomain(body))
            } else {
                Result.failure(Exception("Equipo no encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun crearEquipo(equipo: Equipo): Result<Equipo> {
        return try {
            val dto = EquipoMapper.toDto(equipo)
            val response: Response<EquipoDto> = apiService.crearEquipo(dto)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.success(EquipoMapper.toDomain(body))
            } else {
                Result.failure(Exception("Error al crear equipo"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun actualizarEquipo(id: String, equipo: Equipo): Result<Equipo> {
        return try {
            val dto = EquipoMapper.toDto(equipo)
            val response: Response<EquipoDto> = apiService.actualizarEquipo(id, dto)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.success(EquipoMapper.toDomain(body))
            } else {
                Result.failure(Exception("Error al actualizar equipo"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun eliminarEquipo(id: String): Result<Unit> {
        return try {
            val response: Response<Void> = apiService.eliminarEquipo(id)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Error al eliminar equipo"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}