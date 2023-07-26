package the.guardian.api.kotlin.http.singleItem

class SingleItemResponseWrapper {
    private var response: SingleItemResponse? = null

    fun getResponse(): SingleItemResponse? {
        return response
    }

    fun setResponse(response: SingleItemResponse?) {
        this.response = response
    }
}