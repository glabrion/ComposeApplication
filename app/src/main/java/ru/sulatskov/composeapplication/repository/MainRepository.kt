package ru.sulatskov.composeapplication.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.sulatskov.composeapplication.model.network.ApiInterface
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiInterface
) : Repository {

    @WorkerThread
    suspend fun loadPhotos(onError: () -> Unit) = flow {
        try {
            apiService.getListPhotos(1).apply {
                emit(this)
            }
        } catch (t: Throwable) {
            t.printStackTrace()
            onError.invoke()
        }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    suspend fun loadPhoto(
        onError: () -> Unit,
        id: String
    ) = flow {
        try {
            apiService.getPhoto(id = id).apply {
                emit(this)
            }
        } catch (t: Throwable) {
            t.printStackTrace()
            onError.invoke()
        }
    }.flowOn(Dispatchers.IO)
}
