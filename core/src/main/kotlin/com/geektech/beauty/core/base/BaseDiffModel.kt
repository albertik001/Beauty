package com.geektech.beauty.core.base

interface BaseDiffModel<T> {
    val nameService: T?
    override fun equals(other: Any?): Boolean
}