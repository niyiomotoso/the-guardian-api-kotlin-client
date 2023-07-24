package the.guardian.api.kotlin.client

import the.guardian.api.kotlin.entity.Content
import the.guardian.api.kotlin.entity.Sections
import the.guardian.api.kotlin.entity.Tags

/**
 *
 */
class ContentApi(_apiKey: String) {
    private var apiKey: String? = null

    init {
        this.apiKey = _apiKey
    }

    /**
     * Object factory for class Entity\Content to fetch contents
     */
    fun content(): Content {
        val baseUrl = "http://content.guardianapis.com/search?api-key=".plus(apiKey)

        return Content(baseUrl)
    }

    /**
     * Object factory for class Entity\Tags to fetch tags
     */
    fun tags(): Tags {
        val baseUrl = "http://content.guardianapis.com/tags?api-key=".plus(apiKey)

        return Tags(baseUrl)
    }

    /**
     * Object factory for class Entity\Sections to fetch tags
     */
    fun sections(): Sections {
        val baseUrl = "http://content.guardianapis.com/sections?api-key=".plus(apiKey)

        return Sections(baseUrl)
    }


}
