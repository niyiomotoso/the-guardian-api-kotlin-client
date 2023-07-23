package the.guardian.api.kotlin.http

import the.guardian.api.kotlin.entity.ContentItem

class ContentResponse: AbstractResponse() {
        var status: String? = null
        var userTier: String? = null
        var total = 0
        var startIndex = 0
        var pageSize = 0
        var currentPage = 0
        var pages = 0
        var orderBy: String? = null
        var results: Array<ContentItem>? = null


        override fun toString(): String {
                return "Response(status=$status, userTier=$userTier, total=$total, startIndex=$startIndex, pageSize=$pageSize, currentPage=$currentPage, pages=$pages, orderBy=$orderBy, results=${results.contentToString()})"
        }


}