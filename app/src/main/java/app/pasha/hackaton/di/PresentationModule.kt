package app.pasha.hackaton.di

import app.pasha.hackaton.core.navigation.Screen
import app.pasha.hackaton.presentation.home.HomeScreen
import app.pasha.hackaton.presentation.second.SecondScreen
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface PresentationModule {

    @Binds
    @Singleton
    @IntoSet
    fun bindHomeScreen(impl: HomeScreen): Screen

    @Binds
    @Singleton
    @IntoSet
    fun bindSecondScreen(impl: SecondScreen): Screen
}
