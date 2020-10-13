package com.fjbg.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [Task::class]
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}