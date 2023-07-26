package the.guardian.api.kotlin.entity

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.HttpRequest
import the.guardian.api.kotlin.http.AbstractResponse
import the.guardian.api.kotlin.http.editions.EditionsResponseWrapper

/**
 * Class Editions
 *
 * The editions guardian API entity
 */
class Editions(_apiUrl: String): ApiEntity(_apiUrl) {
    /**
     * Sets the `query` attribute for this API entity
     * @param string query Free text to search for
     */
    fun setQuery(query: String): Editions
    {
        this.query = query
        
        return this
    }

    /**
     * builds URL depending on set fields to fetch editions.
     * The editions endpoint accepts a query term and a format.
     * `format` defaults to 'json' when no format is specified.
     * When no query term is specified, all editions are fetched
     */
    override fun buildUrl()
    {
        this.appendToBaseUrl("q", this.query)
    }

    override fun fetch(): AbstractResponse? {
        this.buildUrl()
        val url = this.baseUrl
        val request: HttpRequest = Unirest.get(url).header("accept", "application/json")
        val response: HttpResponse<EditionsResponseWrapper> = request.asObject(EditionsResponseWrapper::class.java)

        return response.body.getResponse()
    }
}