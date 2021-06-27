package com.ae.acronymapp.common.resource

import retrofit2.HttpException

/**
 * Class to handler errors of service with coroutines
 */
object ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> Resource.error(ErrorType.HTTP_EXCEPTION, null)
            else -> Resource.error(ErrorType.GENERAL_ERROR, null)
        }
    }
}
