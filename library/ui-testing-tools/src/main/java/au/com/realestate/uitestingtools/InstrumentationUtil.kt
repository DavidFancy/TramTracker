package au.com.realestate.uitestingtools

import android.app.Activity
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage.RESUMED
import java.util.concurrent.atomic.AtomicReference

fun currentActivity(): Activity? {
    val currentActivityReference = AtomicReference<Activity>()
    getInstrumentation().runOnMainSync {
        val resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED)
        if (resumedActivities.iterator().hasNext()) {
            currentActivityReference.set(resumedActivities.iterator().next() as Activity)
        }
    }

    return currentActivityReference.get()
}
