package com.evgeny_m.navigator_api

import androidx.lifecycle.LiveData
import ru.ar2code.mutableliveevent.EventArgs

interface AppNavigator {
    val navigationDestination: LiveData<EventArgs<ModuleNavInfo>>
    val navData: LiveData<Any>
    val navigationResDestination: LiveData<EventArgs<Int>>

    fun<T> navigateTo(
        moduleNavInfo: Class<T>
    ) where T: ModuleNavInfo

    fun<T> navigateTo(
        moduleNavInfo: Class<T>, data: Any
    ) where T: ModuleNavInfo

    fun navigateTo (destination: Int)

    fun<T> resolveModule (moduleNavInfo: Class<T>) : ModuleNavInfo? where T: ModuleNavInfo

    fun <T> isCanNavigateTo(moduleNavInfo: Class<T>): Boolean where T : ModuleNavInfo

    //fun setData(data : String)


}