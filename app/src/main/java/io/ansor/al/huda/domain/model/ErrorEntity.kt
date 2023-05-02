package io.ansor.al.huda.domain.model

sealed class ErrorEntity : Throwable() {
    object Connection : ErrorEntity()
    object Unknown : ErrorEntity()
}