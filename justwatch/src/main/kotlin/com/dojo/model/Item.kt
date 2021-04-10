package com.dojo.model

data class Item (

    val jw_entity_id : String,
    val id : Int,
    val title : String,
    val full_path : String,
    val full_paths : LinkApiCompleto,
    val poster : String,
    val poster_blur_hash : String,
    val original_release_year : Int,
    val object_type : String,
    val offers : List<Offers>,
    val scoring : List<Scoring>
)