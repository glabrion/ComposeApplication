package ru.sulatskov.composeapplication.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import ru.sulatskov.composeapplication.base.LiveCoroutinesViewModel
import ru.sulatskov.composeapplication.model.network.dto.Photo
import ru.sulatskov.composeapplication.repository.MainRepository


class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) :
    LiveCoroutinesViewModel() {

    private var _photosList: MutableLiveData<Boolean> = MutableLiveData(true)
    val photosList: LiveData<List<Photo>>

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _toast: MutableLiveData<String> = MutableLiveData()
    val toast: LiveData<String> get() = _toast

    init {
        photosList = _photosList.switchMap {
            _isLoading.postValue(true)
            launchOnViewModelScope {
                this.mainRepository.loadPhotos(
                    onSuccess = { _isLoading.postValue(false) }
                ).asLiveData()
            }
        }
    }
}