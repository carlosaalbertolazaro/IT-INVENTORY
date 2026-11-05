package com.example.appcrud.di

/**
 * AppContainer: Inyección de Dependencias manual (sin Hilt, Dagger ni Koin).
 * Aquí instancias Repository, ViewModelFactory, ApiService, etc.
 * Ejemplo:
 * class AppContainer {
 *     val apiService: ApiService by lazy { ... }
 *     val repository: EquipoRepository by lazy { EquipoRepositoryImpl(apiService) }
 * }
 */
