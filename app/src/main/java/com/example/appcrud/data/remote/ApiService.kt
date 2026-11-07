package com.example.appcrud.data.remote

import com.example.appcrud.data.dto.EquipoDto
import com.example.appcrud.domain.model.Equipo
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

data class AuthResponse(
    val accessToken: String,
    val user: AuthUser

)

data class AuthUser(
    val email: String?,
    val id: String?
)

interface ApiService {
    @GET("equipos")
    suspend fun listarEquipos(): retrofit2.Response<List<EquipoDto>>

    @GET("equipos/{id}")
    suspend fun obtenerEquipo(@Path("id") id: String): retrofit2.Response<EquipoDto>

    @POST("equipos")
    suspend fun crearEquipo(@Body equipo: EquipoDto): retrofit2.Response<EquipoDto>

    @PATCH("equipos/{id}")
    suspend fun actualizarEquipo(@Path("id") id: String, @Body equipo: EquipoDto): retrofit2.Response<EquipoDto>

    @DELETE("equipos/{id}")
    suspend fun eliminarEquipo(@Path("id") id: String): retrofit2.Response<Void>

    //Autenticacion

    @FormUrlEncoded
    @POST("registe")
    suspend fun register(
        @Field("email") email : String,
        @Field("password") password: String
    ): retrofit2.Response<Void>

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password : String

    ) : retrofit2.Response<AuthResponse>

}
