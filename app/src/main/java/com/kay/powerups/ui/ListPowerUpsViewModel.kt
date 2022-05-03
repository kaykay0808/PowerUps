package com.kay.powerups.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.powerups.data.PowerUpsRepository
import kotlinx.coroutines.launch

class ListPowerUpsViewModel(private val repo: PowerUpsRepository/*asking repository for uiModel*/) :
    ViewModel() {

    val liveData = MutableLiveData<List<PowerUpListItem>>()
    var errorLiveData = MutableLiveData<String?>()

    fun getInfo() {
        viewModelScope.launch {
            try {
                val powerUps = repo.getData()
                val listItems = buildList {
                    // Add a header
                    add(PowerUpListItem.Header("Active"))
                    // Add all active header
                    if (powerUps != null) {
                        addAll(powerUps.filter { it.connected })
                    }
                    // Add second header
                    add(PowerUpListItem.Header("Inactive"))
                    // add all inactive header
                    if (powerUps != null) {
                        addAll(powerUps.filter { !it.connected })
                    }
                }
                liveData.postValue(listItems)
                errorLiveData.postValue(null)
            } catch (e: Exception) {
                errorLiveData.postValue("error")
            }
        }
    }
}
/* fun getData() : List<PowerUpListItem>{
val powerUps = repository.getData()
return buildList{
add(Header("Active"))
addAll(powerUps.filter{it.connected})
add(Header("Inactive"))
addAll(powerUps.filter{!it.connected})
}
}
return buildList {
            add(PowerUpListItem.Header("Active"))
            addAll(powerUps.filter{it.connected})
        }*/
