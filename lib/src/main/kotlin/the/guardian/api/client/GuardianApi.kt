package the.guardian.api.client

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
    fun content(): the.guardian.api.entity.Content {
        val apiUrl = "http://content.guardianapis.com/search?api-key=".plus(apiKey)

        return the.guardian.api.entity.Content(apiUrl)
    }

    /**
     * Object factory for class Entity\Tags to fetch tags
     */
    fun tags(): Tags {
        val apiUrl = "http://content.guardianapis.com/tags?api-key=".plus(apiKey)

        return Tags(apiUrl)
    }

    /**
     * Object factory for class Entity\Sections to fetch sections
     */
    fun sections(): Sections {
        val apiUrl = "http://content.guardianapis.com/sections?api-key=".plus(apiKey)

        return Sections(apiUrl)
    }

    /**
     * Object factory for class Entity\Editions to fetch editions
     */
    fun editions(): Editions {
        val apiUrl = "http://content.guardianapis.com/sections?api-key=".plus(apiKey)

        return Editions(apiUrl)
    }


    /**
     * Object factory for class Entity\SingleItem to fetch a single item
     */
    fun singleItem(): SingleItem {
        val apiUrl = "http://content.guardianapis.com"

        return SingleItem(apiUrl, apiKey!!)
    }
}