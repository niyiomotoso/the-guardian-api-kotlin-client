package the.guardian.api.client

import the.guardian.api.config.UrlMap
import the.guardian.api.entity.*

/**
 *
 */
class GuardianApi(_apiKey: String) {
    private var apiKey: String? = null

    init {
        this.apiKey = _apiKey
    }

    /**
     * Object factory for class Entity\Content to fetch contents
     */
    fun content(): Content {
        val apiUrl = UrlMap().CONTENT.plus("?api-key=").plus(apiKey)

        return Content(apiUrl)
    }

    /**
     * Object factory for class Entity\Tags to fetch tags
     */
    fun tags(): Tags {
        val apiUrl = UrlMap().TAGS.plus("?api-key=").plus(apiKey)

        return Tags(apiUrl)
    }

    /**
     * Object factory for class Entity\Sections to fetch sections
     */
    fun sections(): Sections {
        val apiUrl = UrlMap().SECTIONS.plus("?api-key=").plus(apiKey)

        return Sections(apiUrl)
    }

    /**
     * Object factory for class Entity\Editions to fetch editions
     */
    fun editions(): Editions {
        val apiUrl = UrlMap().EDITIONS.plus("?api-key=").plus(apiKey)

        return Editions(apiUrl)
    }


    /**
     * Object factory for class Entity\SingleItem to fetch a single item
     */
    fun singleItem(): SingleItem {
        val apiUrl = UrlMap().BASE

        return SingleItem(apiUrl, apiKey!!)
    }
}
