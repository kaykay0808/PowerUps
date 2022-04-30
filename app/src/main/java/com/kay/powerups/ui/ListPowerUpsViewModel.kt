package com.kay.powerups.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.powerups.data.PowerUpsRepository
import kotlinx.coroutines.launch

class ListPowerUpsViewModel(private val repo: PowerUpsRepository) : ViewModel() {
    var liveData = MutableLiveData<List<PowerUpsUiModel>>()
    var errorLiveData = MutableLiveData<String?>()

    fun getInfo() {
        viewModelScope.launch {
            try {
                val list = repo.getData()
                liveData.postValue(list!!)
                errorLiveData.postValue(null)
            } catch (e: Exception) {
                errorLiveData.postValue("error")
            }
        }
    }
}
