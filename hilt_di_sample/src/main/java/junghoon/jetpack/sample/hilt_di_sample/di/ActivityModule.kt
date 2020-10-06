package junghoon.jetpack.sample.hilt_di_sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import junghoon.jetpack.sample.hilt_di_sample.di.qualifier.AppHash

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @AppHash
    @Provides
    fun provideHash() = hashCode().toString()
}