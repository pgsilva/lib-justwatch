package com.dojo.resource

import com.dojo.model.Item
import com.dojo.model.Pesquisa
import com.dojo.model.Resultado
import com.dojo.util.JUST_WATCH_API_IMAGE_URI
import com.dojo.util.JUST_WATCH_API_LOCALE
import com.dojo.util.JUST_WATCH_API_URI
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson

class JustWatchPesquisaResource {

    private val gson: Gson = Gson()

    fun pesquisarFilmesEShows(keyword: String?): Resultado? {
        val pesquisa: Pesquisa =
            Pesquisa(query = keyword, page = 1, page_size = 30, content_types = listOf("show", "movie"))

        val (_, response, result) = Fuel.post(
            "$JUST_WATCH_API_URI/content/titles/$JUST_WATCH_API_LOCALE/popular?language=pt"
        ).body(gson.toJson(pesquisa)).responseString()

        if (response.statusCode != 200) {
            throw Exception("Ocorreu um erro ao consultar a Api:\n ${response.responseMessage}")
        }

        return gson.fromJson(result.get(), Resultado::class.java)

    }


    fun recuperarUrlPoster(item: Item): String {
        return "$JUST_WATCH_API_IMAGE_URI${item.poster?.replace("{profile}", "s718")}/${
            item.full_path?.split("/")?.last()
        }.webp"

    }

}