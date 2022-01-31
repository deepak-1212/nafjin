package com.kintree.helper

class Constants {

    companion object {
        const val domainName = "magicrelations"
//        const val domainName = "kintree"

        const val domainUrl = "https://www.magicrelations.com/staging/"
//         const val domainUrl = "https://www.kintree.com/"
        const val url: String = domainUrl + "services/user/"
        const val url_profile: String = domainUrl + "services/profile/"
        const val url_tree: String = domainUrl + "services/tree/viewmembertree"
        const val url_member: String = domainUrl + "services/member/"
        const val url_album: String = domainUrl + "services/album/"
        const val url_post: String = domainUrl + "services/post/"
        const val location: String = "https://maps.googleapis.com/maps/api/place/autocomplete/"
        const val tenorApi: String = "https://g.tenor.com/v1/"
    }
}