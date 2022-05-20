package ru.netology

fun main() {


}

data class Post(
    val id: Long,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes?,
    val reposts: Repost,
    val views: Views,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int,
    val geo: Geo?,
    val postSource: PostSource?,
    val copyHistory: Array<Repost>?,
    val attachment: Attachment?
)

data class PostSource(
    val type: String,
    val platform: String,
    val data: String,
    val url: String
)

data class Geo(
    val type: String,
    val coordinates: String,
    val place: Place
)

data class Place(
    val id: Int,
    val title: String,
    val latitude: Int,
    val longitude: Int,
    val created: Int,
    val icon: String,
    val checkins: Int,
    val updated: Int,
    val type: Int,
    val country: Int,
    val city: Int,
    val address: String
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeHolder: PlaceHolder,
    val canPublishFreeCopy: Boolean,
    val editMode: String
)

class PlaceHolder {

}

data class Views(
    val count: Int
)

data class Repost(
    val count: Int,
    val userReposted: Boolean
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean

)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId: Long = 0;

    fun add(post: Post): Post {
        nextId++
        posts += post.copy(id = nextId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postSearch) in posts.withIndex()) {
            if (postSearch.id == post.id) {
                // меняем всё, кроме id владельца (ownerId) и даты создания (date)
                posts[index] = post.copy(ownerId = postSearch.ownerId, date = postSearch.date)
                return true
            }
        }
        return false
    }

    fun addLikes(post: Post): Boolean {
        for ((index, postSearch) in posts.withIndex()) {
            if (postSearch.id == post.id) {
                // добавляем like при каждом вызове
                val likes = postSearch.likes?.count ?: 0
                posts[index] = post.copy(likes = Likes(likes + 1, true, true, true))
                return true
            }
        }
        return false
    }


    fun removeAll() {
        posts = emptyArray<Post>()
        nextId = 0
    }
}