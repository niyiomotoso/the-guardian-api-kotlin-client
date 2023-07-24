package the.guardian.api.kotlin.http.tags

import the.guardian.api.kotlin.entity.TagItem
import the.guardian.api.kotlin.http.AbstractResponse

class TagsResponse: AbstractResponse() {
        var status: String? = null
        var userTier: String? = null
        var total = 0
        var startIndex = 0
        var pageSize = 0
        var currentPage = 0
        var pages = 0
        var results: Array<TagItem>? = null


        override fun toString(): String {
                return "Response(status=$status, userTier=$userTier, total=$total, startIndex=$startIndex, pageSize=$pageSize, currentPage=$currentPage, pages=$pages, results=${results.contentToString()})"
        }


}