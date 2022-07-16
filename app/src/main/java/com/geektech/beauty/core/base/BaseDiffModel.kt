package com.geektech.beauty.core.base

interface BaseDiffModel<T> {
    val phoneNumber: T?
    override fun equals(other: Any?): Boolean
}