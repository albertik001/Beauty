package com.geektech.beauty.presentation.models

import com.geektech.beauty.core.base.BaseDiffModel

data class CategoryUI(
    val imageBanner: String,
    override val nameService: String
) : BaseDiffModel<String>
