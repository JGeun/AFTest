package com.jgeun.aftest.domain.vo

data class CategoryVO(
    val cateName: String,
    val cateNo: String,
    val child: List<CategoryVO>?
)
