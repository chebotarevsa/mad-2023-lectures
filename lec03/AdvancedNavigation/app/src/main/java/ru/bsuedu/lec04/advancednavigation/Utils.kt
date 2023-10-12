package ru.bsuedu.lec04.advancednavigation

import android.app.ActivityManager
import android.util.Log

object Utils {
    fun printTaskInfo(am: ActivityManager, tag: String = "TASK") {
        val runningTask = am.getRunningTasks(100)
        runningTask.forEach {
            Log.d(tag, "------------------");
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                Log.d(tag, "Task description: ${it.taskDescription}")
            } else {
                Log.d(tag, "Task description: ---- ")
            }
            Log.d(tag, "Task: ${it.toString()}")
            Log.d(tag, "Count: " + it.numActivities);
            Log.d(tag, "Root: " + it.baseActivity?.flattenToShortString())
            Log.d(tag, "Top: " + it.topActivity?.flattenToShortString())
        }
    }

}