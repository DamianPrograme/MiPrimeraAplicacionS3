package com.example.miprimeraaplicacion.ApiSeleccion

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


data class AlumnoInsertRequest(
    val nombre: String,
    val apellido: String,
    val grupo: String,
    val seccion: String,
    val archivo: String
)

data class InsertResponse(
    val success: Boolean,
    val message: String?
)

interface ApiDuocService {
    @GET("apiduoc/cosulta.php")
    suspend fun getAlumno(): List<Alumno>
    @POST("apiduoc/insert.php")
    suspend fun insertAlumno(@Body request: AlumnoInsertRequest): InsertResponse
}