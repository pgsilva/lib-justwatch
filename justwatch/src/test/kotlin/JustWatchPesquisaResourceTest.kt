import com.dojo.model.Item
import com.dojo.model.Resultado
import com.dojo.resource.JustWatchPesquisaResource
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.assertThat
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class JustWatchPesquisaResourceTest {

    val justWatch: JustWatchPesquisaResource = JustWatchPesquisaResource()
    val showsAndMovies =
        listOf<String>("Spiderverse", "the Office", "Rick And Morty", "Bojack Hoserman", "Mr Robot", "The Boys")

    @Test
    fun testaPesquisarFilmesEShows() {
        showsAndMovies.forEach { s: String ->
            assertNotNull(justWatch.pesquisarFilmesEShows(s))
            assertThat(justWatch.pesquisarFilmesEShows(s), instanceOf(Resultado::class.java))
        }
    }

    @Test
    fun testaRecuperarUrlPoster() {
        showsAndMovies.forEach { s: String ->
            val resultado: Resultado? = justWatch.pesquisarFilmesEShows(s)
            resultado.let {
                println(it)
                it?.items?.forEach { item: Item ->
                    assertNotNull(justWatch.recuperarUrlPoster(item))
                    assertThat(justWatch.recuperarUrlPoster(item), instanceOf(String::class.java))
                }
            }
        }
    }

    @Test
    fun testaRecuperarUrlPosterAssertMrRobot() {
        val resultado: Resultado? = justWatch.pesquisarFilmesEShows(showsAndMovies[4])
        assertEquals("https://images.justwatch.com/poster/8635336/s718/mr-robot.webp",
            resultado?.items?.let { justWatch.recuperarUrlPoster(it.first()) })

    }


}