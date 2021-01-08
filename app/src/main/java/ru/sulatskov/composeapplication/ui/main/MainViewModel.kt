package ru.sulatskov.composeapplication.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import ru.sulatskov.composeapplication.model.network.dto.Photo
import ru.sulatskov.composeapplication.repository.MainRepository


class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    private val coroutineContext = viewModelScope.coroutineContext + Dispatchers.IO

    val photosList: LiveData<List<Photo>> =
        try {
            liveData(coroutineContext) {
                emitSource(
                    mainRepository.loadPhotos().asLiveData()
                )
            }

        } catch (t: Throwable) {
            t.printStackTrace()
            MutableLiveData()
        }

    lateinit var photo: LiveData<Photo>

    fun getPhoto(id: String) {
        photo = try {
            liveData(coroutineContext) {
                emitSource(
                    mainRepository.loadPhoto(id = id).asLiveData()
                )
            }
        } catch (t: Throwable) {
            t.printStackTrace()
            MutableLiveData()
        }
    }

}