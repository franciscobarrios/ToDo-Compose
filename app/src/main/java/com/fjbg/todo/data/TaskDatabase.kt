package com.fjbg.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjbg.todo.model.Task

@Database(version = 5, entities = [Task::class], exportSchema = true)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}