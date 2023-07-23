package the.guardian.api.kotlin.http

class ContentResponseWrapper {
    private var response: ContentResponse? = null

    fun getResponse(): ContentResponse? {
        return response
    }

    fun setResponse(response: ContentResponse?) {
        this.response = response
    }
}