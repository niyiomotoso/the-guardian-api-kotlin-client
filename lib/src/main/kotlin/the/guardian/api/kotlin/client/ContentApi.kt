package the.guardian.api.kotlin.client

import the.guardian.api.kotlin.entity.Content

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


}
