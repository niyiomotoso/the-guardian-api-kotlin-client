package the.guardian.api.kotlin.entity

import the.guardian.api.kotlin.http.AbstractResponse

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
     *
     * @return string The url to be queried
     */
    override fun buildUrl()
    {
        this.appendToBaseUrl("q", this.query)
    }

    override fun fetch(): AbstractResponse? {
        TODO("Not yet implemented")
    }
}