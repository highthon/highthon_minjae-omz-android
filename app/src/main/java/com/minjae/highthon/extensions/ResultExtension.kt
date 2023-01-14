package com.minjae.highthon.extensions

import com.minjae.highthon.base.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

fun <T> Flow<Result<T>>.onSuccess(action: suspend (T) -> Unit) = onEach { result ->
    (result as? Result.Success)?.let { action.invoke(it.value) }
}

fun <T> Flow<Result<T>>.onLoading(action: suspend () -> Unit) = onEach {
    (it as? Result.Loading)?.let { action.invoke() }
}

fun <T> Flow<Result<T>>.onFailure(action: suspend (Throwable) -> Unit) = onEach {
    (it as? Result.Failure)?.let { action.invoke(it.throwable) }
}
