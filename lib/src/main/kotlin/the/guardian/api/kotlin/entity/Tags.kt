package the.guardian.api.kotlin.entity

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.HttpRequest
import the.guardian.api.kotlin.http.AbstractResponse
import the.guardian.api.kotlin.http.tags.TagsResponseWrapper

/**
 *
 */
class Tags(_apiUrl: String): PageAndReferenceApiEntity(_apiUrl) {
// query term
    var webTitle: String = ""
    // filters
    var type: String = ""

    /**
     * Sets `web-title`: free text every fetched tag will start from
     * @param string webTitle String every tag in results should start from
     * @return self
     */
    public fun setWebTitle(webTitle: String): Tags
    {
        this.webTitle = webTitle
        return this
    }

    /**
     * Sets tag type. Only tags of this type will be fetched
     * @param string type Tag type
     * @return self
     */
    public fun setType(type: String): Tags
    {
        this.type = type
        return this
    }

    /**
     * Sets the `query` attribute for this API entity
     * @param string query Free text to search for
     * @return self The object this was set on
     */
    fun setQuery(query: String): Tags
    {
        this.query = query
        return this
    }

    override fun buildUrl()
    {
        this.appendToBaseUrl("page", this.page.toString())
        .appendToBaseUrl("page-size", this.pageSize.toString())
        .appendToBaseUrl("q", this.query)
        .appendToBaseUrl("web-title", this.webTitle)
        .appendToBaseUrl("type", this.type)
        .appendToBaseUrl("section", this.section)
        .appendToBaseUrl("reference", this.reference)
        .appendToBaseUrl("reference-type", this.referenceType)
        .appendToBaseUrl("show-references", this.showReferences);
    }

    override fun fetch(): AbstractResponse? {
        this.buildUrl()
        val url = this.baseUrl
        println("baseUrl ".plus(url))
        val request: HttpRequest = Unirest.get(url).header("accept", "application/json")

        val response: HttpResponse<TagsResponseWrapper> = request.asObject(TagsResponseWrapper::class.java)
        val results = response.body.getResponse()

        println("responsey ".plus(results))

        return response.body.getResponse()
    }
}