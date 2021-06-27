package com.ae.acronymapp.common.resource

data class Resource<out T>(val status: Status, val data: T?, val type: ErrorType?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(type: ErrorType, data: T?): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                type
            )
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }
    }
}
