package the.guardian.api.entity

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.HttpRequest
import the.guardian.api.http.AbstractResponse
import the.guardian.api.http.content.ContentResponseWrapper
import java.util.*

/**
 * Class Content
 * The content guardian API entity
 */
class Content(_apiUrl: String): the.guardian.api.entity.ContentApiEntity(_apiUrl)
{
    /**
     * Query term
     */
    var queryFields: String = ""

    /**
     * Sets the `query` attribute for this API entity
     * @param string query Free text to search for
     */
    public fun setQuery(query: String): the.guardian.api.entity.Content
    {
        this.query = query
        return this
    }

    public fun setQueryFields(queryFields: String): the.guardian.api.entity.Content
    {
        this.queryFields = queryFields
        return this
    }

    override fun buildUrl()
    {
        super.buildUrl()
        this.appendToBaseUrl("q", this.query)
        .appendToBaseUrl("query-fields", this.queryFields)
    }

    /**
     *
     */
    override fun fetch(): AbstractResponse?
    {
        this.buildUrl()
        val url = this.baseUrl
        val request: HttpRequest = Unirest.get(url).header("accept", "application/json")
        val response: HttpResponse<ContentResponseWrapper> = request.asObject(ContentResponseWrapper::class.java)

        return response.body.getResponse()
    }
}