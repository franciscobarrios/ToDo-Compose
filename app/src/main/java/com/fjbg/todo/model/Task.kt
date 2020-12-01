package com.fjbg.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int,
    val taskTitle: String,
    val taskContent: String?,
    val taskCompleted: Boolean
)