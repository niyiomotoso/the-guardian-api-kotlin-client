package the.guardian.api.entity

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.HttpRequest
import the.guardian.api.http.AbstractResponse
import the.guardian.api.http.sections.SectionsResponseWrapper

/**
 * Class Sections
 * The sections guardian API entity
 */
class Sections(_apiUrl: String): ApiEntity(_apiUrl) {
    /**
     * Sets the `query` attribute for this API entity
     * @param string query Free text to search for
     */
    fun setQuery(query: String): Sections
    {
        this.query = query
        return this
    }

    /**
     * builds URL depending on set fields to fetch sections.
     * The sections endpoint accepts a query term and a format.
     * `format` defaults to 'json' when no format is specified.
     * When no query term is specified, all sections are fetched
     */
     override fun buildUrl()
    {
        this.appendToBaseUrl("q", this.query)
    }

    override fun fetch(): AbstractResponse? {
        this.buildUrl()
        val url = this.baseUrl
        val request: HttpRequest = Unirest.get(url).header("accept", "application/json")
        val response: HttpResponse<SectionsResponseWrapper> = request.asObject(SectionsResponseWrapper::class.java)

        return response.body.getResponse()
    }
}