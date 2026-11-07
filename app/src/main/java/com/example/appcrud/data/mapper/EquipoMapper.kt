package com.example.appcrud.data.mapper

import com.example.appcrud.data.dto.EquipoDto
import com.example.appcrud.domain.model.Equipo
import com.example.appcrud.domain.model.EquipoEstado

object EquipoMapper {
    fun toDomain(dto: EquipoDto): Equipo {
        return Equipo(
            id = dto.id ?: "",
            numeroSerie = dto.numeroSerie ?: "",
            marca = dto.marca ?: "",
            modelo = dto.modelo ?: "",
            fechaAdquisicion = dto.fechaAdquisicion ?: "",
            estado = dto.estado?.let { EquipoEstado.valueOf(it) } ?: EquipoEstado.DISPONIBLE,
            numeroInventario = dto.numeroInventario ?: 0,
            ubicacion = dto.ubicacion ?: ""
        )
    }

    fun toDto(equipo: Equipo): EquipoDto {
        return EquipoDto(
            id = equipo.id.takeIf { it.isNotBlank() } ?: null,
            numeroSerie = equipo.numeroSerie.takeIf { it.isNotBlank() } ?: null,
            marca = equipo.marca.takeIf { it.isNotBlank() } ?: null,
            modelo = equipo.modelo.takeIf { it.isNotBlank() } ?: null,
            fechaAdquisicion = equipo.fechaAdquisicion.takeIf { it.isNotBlank() } ?: null,
            estado = equipo.estado.name,
            numeroInventario = equipo.numeroInventario.takeIf { it > 0 } ?: null,
            ubicacion = equipo.ubicacion.takeIf { it.isNotBlank() } ?: null
        )
    }
}