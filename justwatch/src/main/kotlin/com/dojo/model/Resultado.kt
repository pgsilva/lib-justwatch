package com.dojo.model


data class Resultado(

    val page: Int,
    val page_size: Int,
    val total_pages: Int,
    val total_results: Int,
    val items: List<Item>
)