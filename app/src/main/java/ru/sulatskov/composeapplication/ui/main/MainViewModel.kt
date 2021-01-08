package ru.sulatskov.composeapplication.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import ru.sulatskov.composeapplication.model.network.dto.Photo
import ru.sulatskov.composeapplication.repository.MainRepository


class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    val photosList: LiveData<List<Photo>> =
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(
                mainRepository.loadPhotos().asLiveData()
            )
        }
    lateinit var photo: LiveData<Photo>

    fun getPhoto(id: String) {
        try {
            val currentPhoto =
                liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
                    emitSource(
                        mainRepository.loadPhoto(id = id).asLiveData()
                    )
                }
            photo = currentPhoto
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

}