package com.fjbg.todo.di

import android.content.Context
import androidx.room.Room
import com.fjbg.todo.data.TaskDao
import com.fjbg.todo.data.TaskDatabase
import com.fjbg.todo.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TaskDatabase {
        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "task.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.taskDao()
    }
}


@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(database: TaskDatabase): TaskRepository {
        return TaskRepository(database)
    }
}