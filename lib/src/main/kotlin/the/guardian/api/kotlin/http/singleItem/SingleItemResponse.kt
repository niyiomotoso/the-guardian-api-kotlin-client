package the.guardian.api.kotlin.http.singleItem

import the.guardian.api.kotlin.http.AbstractResponse

class SingleItemResponse: AbstractResponse() {
        var status: String? = null
        var userTier: String? = null
        var total = 0
        var content: SingleItem? = null

        override fun toString(): String {
                return "SingleItemResponse(status=$status, userTier=$userTier, total=$total, content=$content)"
        }
}