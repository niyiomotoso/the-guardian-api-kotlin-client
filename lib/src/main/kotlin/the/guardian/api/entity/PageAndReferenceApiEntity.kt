package the.guardian.api.entity

/**
 * * Class PageAndReferenceAPIEntity
 *
 * Base class for guardian API entities that have page & reference attributes
 */
abstract class PageAndReferenceApiEntity(_apiUrl: String): the.guardian.api.entity.ApiEntity(_apiUrl) {
    // page options
    var page: Int = 1
    var pageSize: Int = 20
    // Filters
    var section: String = ""
    var reference: String = ""
    var referenceType: String = ""

    // additional information
    var showReferences: String = ""

    /**
     * Sets the page index results should be fetched for.
     * If `page` is not set, it defaults to 1
     * @param int $page Page index to be set
     */
    fun setPage(page: Int): PageAndReferenceApiEntity
    {
        if(page < 1) {
            // throw InvalidArgumentException("Page cannot be negative or zero")
        }
        this.page = page

        return this
    }

    /**
     * Sets the number of items displayed per page.
     * If `pageSize` is not set, it defaults to 20
     * @param int $pageSize Number of items per page
     */
    fun setPageSize(pageSize: Int): PageAndReferenceApiEntity
    {
        if(pageSize < 1) {
        // throw InvalidArgumentException("Page size cannot be negative or zero")
    }
        this.pageSize = pageSize
        return this
    }

    /**
     * Sets `section(s)` to return only tags in the sections.
     * `section` supports boolean operators - ',' for AND. '|' for OR. '-' for NOT.
     * Valid section strings: "business,sports", "business", "business|sports"
     */
    fun setSection(section: String) : PageAndReferenceApiEntity
    {
        this.section = section
        return this
    }

    /**
     * Sets `reference(s)` to return only tags with those references
     * `reference` supports boolean operators - ',' for AND. '|' for OR. '-' for NOT.
     * Valid reference strings: "isbn/9780349108391", "isbn/9780349108391,isbn/9780XXXXXXX"
     */
    fun setReference(reference: String): PageAndReferenceApiEntity
    {
        this.reference = reference

        return this
    }

    /**
     * Sets `reference-type(s)` to return only tags with references of those types
     * `reference` supports boolean operators - ',' for AND. '|' for OR. '-' for NOT.
     */
    fun setReferenceType(referenceType: String): PageAndReferenceApiEntity
    {
        this.referenceType = referenceType
        return this
    }

    /**
     * Sets `show-references` field to specify if the associated reference data like ISBNs
     * for the fetched tags is to be shown.
     * `show-references` is a string list.
     * See https://open-platform.theguardian.com/documentation/tag
     * for valid entries for this list
     */
    fun setShowReferences(showReferences: String): PageAndReferenceApiEntity
    {
        this.showReferences = showReferences

        return this
    }
}