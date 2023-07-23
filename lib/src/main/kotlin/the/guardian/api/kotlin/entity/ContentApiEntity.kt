package the.guardian.api.kotlin.entity

import the.guardian.api.kotlin.http.AbstractResponse
import java.net.URLEncoder
import java.text.SimpleDateFormat

/**
 *
 */
abstract class ContentApiEntity(_apiUrl: String): PageAndReferenceApiEntity(_apiUrl)
{
    /**
     * Filters
     */
    protected var tag: String? = ""
    protected var rights: String? = ""
    protected var ids: String? = ""
    protected var productionOffice: String? = ""
    protected var lang: String? = ""
    protected var starRating: String? = ""
    // Date options
    protected var fromDate: String? = ""
    protected  var toDate: String? = ""
    protected var useDate: String? = ""
    // ordering
    protected var orderBy: String? = ""
    protected var orderDate: String? = ""
    // additional information
    protected var showFields: String? = ""
    protected var showTags: String? = ""
    protected var showSection: String? = ""
    protected var showBlocks: String? = ""
    protected var showElements: String? = ""
    protected var showRights: String? = ""

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    /**
     * To set tags. Only content with the tags will be fetched
     * The `tag` attribute supports boolean operators
     */
    public fun setTag(tag: String): ContentApiEntity {
        this.tag = tag
        return this
    }

    /**
     * To set rights. Only content with the rights will be fetched
     * The `rights` attribute doesn't support boolean operators
     */
    public fun setRights(rights: String): ContentApiEntity {
        this.rights = rights
        return this
    }

    /**
     * To set ids. Only content with the ids will be fetched
     * The `ids` attribute doesn't support boolean operators
     */
    public fun setIds(ids: String): ContentApiEntity {
        this.ids = ids
        return this
    }

    /**
     * To set production offices. Only content with the production offices
     * will be fetched.
     * The `production-office` attribute supports boolean operators
     */
    public fun setProductionOffice(productionOffice: String): ContentApiEntity {
        this.productionOffice = productionOffice
        return this
    }

    /**
     * To set language(s) to return content for
     * The `lang` attribute supports boolean operators
     */
    public fun setLang(lang: String): ContentApiEntity {
        this.lang = lang
        return this
    }

    /**
     * To set the star-rating for contents to be retrieved.
     * The `star-rating` attribute doesn't support boolean operators
     */
    public fun setStarRating(starRating: String): ContentApiEntity {
        this.starRating = starRating
        return this
    }

    /**
     * Set `from-date`. Only content on or after `from-date` will be fetched
     */
    public fun setFromDate(fromDate: String): ContentApiEntity {
        this.fromDate = fromDate
        return this
    }

    /**
     * Set `to-date`. Only content on or before `to-date` will be fetched
     */
    public fun setToDate(toDate: String): ContentApiEntity {
        this.toDate = toDate
        return this
    }

    /**
     * Set `use-date` to filter the results
     * @param string useDate Date type to filter results. See https://open-platform.theguardian.com/documentation/search
     */
    public fun setUseDate(useDate: String): ContentApiEntity {
        this.useDate = useDate
        return this
    }

    /**
     * Set `order-by` to return results in the specified order
     * @param string orderBy One of `newest`, `oldest`, or `relevance`. See the docs
     */
    public fun setOrderBy(orderBy: String): ContentApiEntity {
        this.orderBy = orderBy
        return this
    }

    /**
     * Set `order-date` to choose the type of date to be used to order the results
     * @param string orderDate One of `published`, `newspaper-edition`, or `last-modified`. See the docs
     */
    public fun setOrderDate(orderDate: String): ContentApiEntity {
        this.orderDate = orderDate
        return this
    }

    /**
     * Set `show-fields` to choose the fields to be added to the content
     * @param string showFields String list of desired fields. See the docs
     */
    public fun setShowFields(showFields: String): ContentApiEntity {
        this.showFields = showFields
        return this
    }

    /**
     * Set `show-tags` to add associated metadata tags
     * @param string showTags String list of desired metadata tags. See the docs
     */
    public fun setShowTags(showTags: String): ContentApiEntity {
        this.showTags = showTags
        return this
    }

    /**
     * Set `show-section` to add associated metadata section
     * @param string showSection Boolean string - 'true'. See the docs
     */
    public fun setShowSection(showSection: String): ContentApiEntity {
        this.showSection = showSection
        return this
    }

    /**
     * Set `show-blocks` to add associated blocks
     * @param string showBlocks String list of blocks. See the docs
     */
    public fun setShowBlocks(showBlocks: String): ContentApiEntity {
        this.showBlocks = showBlocks
        return this
    }

    /**
     * Set `show-elements` to add media elements like images and audio.
     * Accepted elements - `audio`, `image`, `video`, `all`
     * @param string showElements String list of elements. See the docs
     */
    public fun setShowElements(showElements: String): ContentApiEntity {
        this.showElements = showElements
        return this
    }

    /**
     * Set `show-rights` to add associated rights.
     * Accepted values - `syndicatable`, `subscription-databases`, `all`
     * @param string showRights String list of rights. See the docs
     */
    public fun setShowRights(showElements: String): ContentApiEntity {
        this.showElements = showElements
        return this
    }
    /**
     * Helps to build request URLs. Appends set request parameters to the URL
     * @param string $attributeName Request parameter according to the guardian API docs
     * @param mixed $attributeValue Value the parameter is set to. This is typically an int or a string
     */
    fun  appendToBaseUrl(attributeName: String, attributeValue: String): ContentApiEntity
    {
        if (attributeValue != "") {
            val encodedValue = URLEncoder.encode(attributeValue, "UTF-8")
            val url = "&".plus(attributeName).plus("=").plus(encodedValue)
            this.baseUrl = this.baseUrl.plus(url)
        }

        return this
    }
    override fun buildUrl()
    {
        this.appendToBaseUrl("tag", this.tag!!)
            .appendToBaseUrl("rights", this.rights!!)
            .appendToBaseUrl("ids", this.ids!!)
        .appendToBaseUrl("production-office", this.productionOffice!!)
        .appendToBaseUrl("lang", this.lang!!)
        .appendToBaseUrl("star-rating", this.starRating!!)
        .appendToBaseUrl("from-date", this.fromDate!!)
        .appendToBaseUrl("to-date", this.toDate!!)
        .appendToBaseUrl("use-date", this.useDate!!)
        .appendToBaseUrl("order-by", this.orderBy!!)
        .appendToBaseUrl("order-date", this.orderDate!!)
        .appendToBaseUrl("show-fields", this.showFields!!)
        .appendToBaseUrl("show-tags", this.showTags!!)
        .appendToBaseUrl("show-section", this.showSection!!)
        .appendToBaseUrl("show-blocks", this.showSection!!)
        .appendToBaseUrl("show-elements", this.showElements!!)
        .appendToBaseUrl("show-rights", this.showRights!!)
        .appendToBaseUrl("page", (this.page.toString()))
        .appendToBaseUrl("page-size", this.pageSize.toString())
        .appendToBaseUrl("section", this.section)
        .appendToBaseUrl("reference", this.reference)
        .appendToBaseUrl("reference-type", this.referenceType)
        .appendToBaseUrl("show-references", this.showReferences)
    }
}