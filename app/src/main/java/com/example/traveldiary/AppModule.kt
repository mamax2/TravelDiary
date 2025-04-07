package com.example.traveldiary

import android.content.Context
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val Context.dataStore
        by preferencesDataStore("settings")
val appModule = module {
    single { get<Context>().dataStore }
    single { SettingsRepository(get()) }
    single { AddTravelViewModel(get()) }
    viewModel { SettingsViewModel(get()) }
}