package the.guardian.api.kotlin.http.sections

class SectionsResponseWrapper {
    private var response: SectionsResponse? = null

    fun getResponse(): SectionsResponse? {
        return response
    }

    fun setResponse(response: SectionsResponse?) {
        this.response = response
    }
}