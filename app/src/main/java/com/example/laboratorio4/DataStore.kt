package com.example.laboratorio4

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class Data(private val context: Context) {

    // to make sure there's only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userEmail")
        val USER_ESCUELA_KEY = stringPreferencesKey("user_escuela")
        val USER_PERIODO_KEY = stringPreferencesKey("user_periodo")
        val USER_CODIGO_KEY = stringPreferencesKey("user_codigo")
        val USER_NOMBRE_KEY = stringPreferencesKey("user_nombre")
        val USER_SEMESTRE_KEY = stringPreferencesKey("user_semestre")
        val USER_DURACION_KEY = stringPreferencesKey("user_duracion")
        val USER_TEXTSIZE_KEY = intPreferencesKey("user_size")
    }

    //get the saved Escuela
    val getEscuela: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_ESCUELA_KEY] ?: "FirstLast@gmail.com"
        }

    //save Escuela into datastore
    suspend fun saveEscuela(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_ESCUELA_KEY] = name
        }
    }
    //get the saved Periodo
    val getPeriodo: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_PERIODO_KEY] ?: "FirstLast@gmail.com"
        }

    //save Periodo into datastore
    suspend fun savePeriodo(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_PERIODO_KEY] = name
        }
    }
    //get the saved Codigo
    val getCodigo: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_CODIGO_KEY] ?: "FirstLast@gmail.com"
        }

    //save Codigo into datastore
    suspend fun saveCodigo(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_CODIGO_KEY] = name
        }
    }
    //get the saved Size
    val getSize: Flow<Int> = context.dataStore.data
        .map { preferences ->
            // No type safety.
            preferences[USER_TEXTSIZE_KEY] ?: 12
        }
    //save Size into datastore
    suspend fun saveSize(data: Int) {
        context.dataStore.edit { preferences ->
            preferences[USER_TEXTSIZE_KEY] = data
        }
    }

    //get the saved Nombre
    val getNombre: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_NOMBRE_KEY] ?: "FirstLast@gmail.com"
        }

    //save Nombre into datastore
    suspend fun saveNombre(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NOMBRE_KEY] = name
        }
    }

    //get the saved Semestre
    val getSemestre: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_SEMESTRE_KEY] ?: "FirstLast@gmail.com"
        }

    //save Semestre into datastore
    suspend fun saveSemestre(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_SEMESTRE_KEY] = name
        }
    }

    //get the saved Duracion
    val getDuracion: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_DURACION_KEY] ?: "FirstLast@gmail.com"
        }

    //save Duracion into datastore
    suspend fun saveDuracion(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_DURACION_KEY] = name
        }
    }


}