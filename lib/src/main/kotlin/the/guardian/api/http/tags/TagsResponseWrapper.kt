package the.guardian.api.http.tags

class TagsResponseWrapper {
    private var response: TagsResponse? = null

    fun getResponse(): TagsResponse? {
        return response
    }

    fun setResponse(response: TagsResponse?) {
        this.response = response
    }
}