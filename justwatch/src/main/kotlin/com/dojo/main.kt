package com.dojo

import com.dojo.resource.JustWatchPesquisaResource

fun main(){
    val justWatch: JustWatchPesquisaResource = JustWatchPesquisaResource()
    println(justWatch.pesquisarFilmesEShows(null))
}
