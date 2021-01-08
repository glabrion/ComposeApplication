package ru.sulatskov.composeapplication.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.sulatskov.composeapplication.model.network.ApiInterface
import ru.sulatskov.composeapplication.model.network.dto.Photo
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiInterface
) : Repository {

    @WorkerThread
    suspend fun loadPhotos() = flow {
        val photos: List<Photo> = emptyList()
        apiService.getListPhotos(1).apply {
            emit(this)
        }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    suspend fun loadPhoto(
        id: String
    ) = flow {
        apiService.getPhoto(id = id).apply {
            emit(this)
        }
    }.flowOn(Dispatchers.IO)
}
