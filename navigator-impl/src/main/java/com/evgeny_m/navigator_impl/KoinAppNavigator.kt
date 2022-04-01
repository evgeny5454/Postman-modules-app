package com.evgeny_m.navigator_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evgeny_m.navigator_api.AppNavigator
import com.evgeny_m.navigator_api.ModuleNavInfo
import org.koin.java.KoinJavaComponent
import ru.ar2code.mutableliveevent.EventArgs
import ru.ar2code.mutableliveevent.MutableLiveEvent
import java.lang.Exception

class KoinAppNavigator() : AppNavigator {
    private val navigationDestinationInternal = MutableLiveEvent<EventArgs<ModuleNavInfo>>()
    override val navigationDestination =
        navigationDestinationInternal as LiveData<EventArgs<ModuleNavInfo>>

    private val navDataInternal = MutableLiveData<Any>()
    override val navData = navDataInternal as LiveData<Any>

    private val navigationIntDestinationInternal = MutableLiveEvent<EventArgs<Int>>()
    override val navigationResDestination: LiveData<EventArgs<Int>>
        get() = navigationIntDestinationInternal


    override fun <T : ModuleNavInfo> navigateTo(moduleNavInfo: Class<T>) {
        val destination = KoinJavaComponent.get(moduleNavInfo) as ModuleNavInfo
        navigationDestinationInternal.postValue(EventArgs(destination))
    }

    override fun <T : ModuleNavInfo> navigateTo(moduleNavInfo: Class<T>, data: Any) {
        navDataInternal.postValue(data)
        val destination = KoinJavaComponent.get(moduleNavInfo) as ModuleNavInfo
        navigationDestinationInternal.postValue(EventArgs(destination))
    }

    override fun navigateTo(destination: Int) {
        navigationIntDestinationInternal.postValue(EventArgs(destination))
    }

    override fun <T : ModuleNavInfo> resolveModule(moduleNavInfo: Class<T>): ModuleNavInfo? {
        return try {
            KoinJavaComponent.get(moduleNavInfo)
        } catch (e: Exception) {
            null
        }
    }

    override fun <T : ModuleNavInfo> isCanNavigateTo(moduleNavInfo: Class<T>): Boolean {
        return resolveModule(moduleNavInfo) != null
    }

    /*override fun setData(data: String) {
        navDataInternal.postValue(data)
    }*/
}