package junghoon.jetpack.sample.hilt_di_sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import junghoon.jetpack.sample.hilt_di_sample.di.qualifier.ActivityHash

@Module
@InstallIn(ActivityComponent::class)
object ApplicationModule {

    @ActivityHash
    @Provides
    fun provideHash() = hashCode().toString()
}