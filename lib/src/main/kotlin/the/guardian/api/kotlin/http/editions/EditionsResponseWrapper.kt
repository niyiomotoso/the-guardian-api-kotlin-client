package the.guardian.api.kotlin.http.editions

class EditionsResponseWrapper {
    private var response: EditionsResponse? = null

    fun getResponse(): EditionsResponse? {
        return response
    }

    fun setResponse(response: EditionsResponse?) {
        this.response = response
    }
}