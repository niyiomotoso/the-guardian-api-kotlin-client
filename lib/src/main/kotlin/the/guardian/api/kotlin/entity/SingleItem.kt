package the.guardian.api.kotlin.entity

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.HttpRequest
import the.guardian.api.kotlin.http.AbstractResponse
import the.guardian.api.kotlin.http.content.ContentResponseWrapper
import the.guardian.api.kotlin.http.singleItem.SingleItemResponseWrapper

class SingleItem(_baseUrl: String, _apiKey: String): ContentApiEntity(_baseUrl)
{
    // query term
    var id: String = ""

    // additional information
    var showStoryPackage: String = ""
    var showEditorsPicks: String = ""
    var showMostViewed: String = ""
    var showRelated: String = ""
    var apiKey: String = ""

    init {
        this.apiKey = _apiKey
    }
    
    /**
     * Set the ID for the content to fetch.
     * The ID for an item, such as a piece of content, is the path to
     * that item on the guardian site.
     * @param string id Item ID string of relative path to the item on the website including the initial `/`
     * valid value: `/sport/2022/oct/07/cricket-jos-buttler-primed-for-england-comeback-while-phil-salt-stays-focused`
     */
    fun setId(id: String): SingleItem
    {
        this.id = id
        return this
    }

    /**
     * Choose to show story package
     * When `true` display a list of content that has been identified as being
     * about the same story as the requested content item.
     */
    fun setShowStoryPackage(showStoryPackage: Boolean): SingleItem
    {
        if (showStoryPackage)
            this.showStoryPackage = "true"
        else
            this.showStoryPackage = "false"

        return this
    }

    /**
     * Choose to show editors' picks
     * When `true` display a list of content that is chosen by editors on tags,
     * sections and the home page.
     */
    fun setShowEditorsPicks(showEditorsPicks: Boolean): SingleItem
    {
        if (showEditorsPicks)
            this.showEditorsPicks = "true"
        else
            this.showEditorsPicks = "false"

        return this
    }

    /**
     * Choose to show most viewed
     * When `true` display most viewed content.
     * @param bool showMostViewed
     */
    fun setShowMostViewed(showMostViewed: Boolean): SingleItem
    {
        if (showMostViewed)
            this.showMostViewed = "true"
        else
            this.showMostViewed = "false"

        return this
    }

    /**
     * Choose to show related content
     * Content items can show a set of 'related' content.
     * When `true`, returns content items related to the main content item
     * @param bool showRelated
     */
    fun setShowRelated(showRelated: Boolean): SingleItem
    {
        if (showRelated)
            this.showRelated = "true"
        else
            this.showRelated = "false"

        return this
    }

    override fun buildUrl()
    {
        this.baseUrl =  this.baseUrl.plus(this.id).plus("?api-key=").plus(this.apiKey)
        super.buildUrl()
        this.appendToBaseUrl("show-story-package", this.showStoryPackage)
        .appendToBaseUrl("show-editors-picks", this.showEditorsPicks)
        .appendToBaseUrl("show-most-viewed", this.showMostViewed)
        .appendToBaseUrl("show-related", this.showRelated)
    }

    override fun fetch(): AbstractResponse? {
        this.buildUrl()
        val url = this.baseUrl
        println("baseUrl ".plus(url))
        val request: HttpRequest = Unirest.get(url).header("accept", "application/json")

        val response: HttpResponse<SingleItemResponseWrapper> = request.asObject(SingleItemResponseWrapper::class.java)
        val results = response.body.getResponse()

        println("responsey ".plus(results))

        return response.body.getResponse()
    }
}