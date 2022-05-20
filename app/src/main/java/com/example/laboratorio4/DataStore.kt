package com.example.laboratorio4

import android.content.Context
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class Data(private val context: Context) {

    // to make sure there's only one instance
    companion object {
        private val Context.dataStoree: DataStore<Preferences> by preferencesDataStore("userEmail")
        val USER_ESCUELA_KEY = stringPreferencesKey("user_escuela")
        val USER_PERIODO_KEY = stringPreferencesKey("user_periodo")
        val USER_CODIGO_KEY = stringPreferencesKey("user_codigo")
        val USER_TEXTSIZE_KEY = stringPreferencesKey("user_textSize")

    }


    //get the saved email
    val getEscuela: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[USER_ESCUELA_KEY] ?: "FirstLast@gmail.com"
        }

    //save email into datastore
    suspend fun saveEscuela(name: String) {
        context.dataStoree.edit { preferences ->
            preferences[USER_ESCUELA_KEY] = name
        }
    }
    //get the saved email
    val getPeriodo: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[USER_PERIODO_KEY] ?: "FirstLast@gmail.com"
        }

    //save email into datastore
    suspend fun savePeriodo(name: String) {
        context.dataStoree.edit { preferences ->
            preferences[USER_PERIODO_KEY] = name
        }
    }
    //get the saved email
    val getCodigo: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[USER_CODIGO_KEY] ?: "FirstLast@gmail.com"
        }

    //save email into datastore
    suspend fun saveCodigo(name: String) {
        context.dataStoree.edit { preferences ->
            preferences[USER_CODIGO_KEY] = name
        }
    }
    //get the saved email
    val getSize: Flow<Float?> = context.dataStoree.data
        .map { preferences ->
            (preferences[USER_TEXTSIZE_KEY] ?: 12 as Float) as Float
        }

    //save email into datastore
    suspend fun saveSize(data: Float) {
        context.dataStoree.edit { preferences ->
            preferences[USER_TEXTSIZE_KEY] = data.toString()
        }
    }
}