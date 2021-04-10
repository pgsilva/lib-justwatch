# Lib justwatch.com 
*Não Oficial*

[![Kotlin](https://img.shields.io/badge/kotlin-1.4.32-blue.svg?logo=kotlin&style=flat-square)](http://kotlinlang.org)
[![Miles Morales](https://img.shields.io/badge/dev-miles%20morales-blueviolet?style=flat-square)](https://github.com/pgsilva)
[![Git Hub Stars](https://img.shields.io/github/stars/pgsilva?logo=github&style=flat-square)](https://github.com/pgsilva/api-spodfy-kotlin)
[![Gradle](https://img.shields.io/badge/Gradle-v6.8.3-brightgreen?logo=gradle&style=flat-square)](https://gradle.org/releases/)


## Objetivo
- Biblioteca Kotlin que consiga acessar a justwatch.com e consultar seus serviços 
- Boas praticas e Clean Code


## Solução
Uma aplicação que consome a API justwatch.com e permite que o usuário faça pesquisas e identifique em qual serviço de stream está disponivel no Brasil.

## Instalação 
Apenas adicionar a lib (**.jar**) como referência do projeto.

## Exemplos de Uso
````kotlin
    val justWatch: JustWatchPesquisaResource = JustWatchPesquisaResource()
    val showsAndMovies =
        listOf<String>("Spiderverse", "the Office", "Rick And Morty", "Bojack Hoserman", "Mr Robot", "The Boys")

    //Exemplo de busca por filmes
    showsAndMovies.forEach { s: String ->
        println(justWatch.pesquisarFilmesEShows(s))
    }

    //Exemplo de como recuperar a url do poster
    showsAndMovies.forEach { s: String ->
        val resultado: Resultado? = justWatch.pesquisarFilmesEShows(s)
        resultado.let {
            println(it)
            it?.items?.forEach { item: Item ->
                println(justWatch.recuperarUrlPoster(item))
            }
        }
    }
 
```  
