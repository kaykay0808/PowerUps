package com.kay.powerups.ui

import android.graphics.Insets.add
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.powerups.data.PowerUpsRepository
import kotlinx.coroutines.launch
import java.util.Collections.addAll

class ListPowerUpsViewModel(private val repo: PowerUpsRepository) : ViewModel() {

    private val liveData = MutableLiveData<List<PowerUpListItem>>()
    val _liveData: LiveData<List<Resource<PowerUpListItem>>>
    get() = liveData
    var errorLiveData = MutableLiveData<String?>()

    fun getInfo() : List<PowerUpListItem>{
        viewModelScope.launch {
            try {
                val powerUps = repo.getData()
                liveData.postValue(powerUps!!)
                errorLiveData.postValue(null)
            } catch (e: Exception) {
                errorLiveData.postValue("error")
            }
        } return buildList {
            add(PowerUpListItem.Header("Active"))
            addAll(powerUps.filter{it.connected})
        }
    }
}
