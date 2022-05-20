package ru.netology


// класс attachment, 5 видов
abstract class Attachment(val type: String)

data class AudioAttachment(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val audioInfo: Audio,
    val date: Int,
    val noSearch: Boolean,
    val isHQ: Boolean

) : Attachment("audio")

data class Audio(
    val artist: String,
    val title: String,
    val duration: Int,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int
)

data class GraffitiAttachment(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
) : Attachment("graffiti")

data class PhotoAttachment(
    val id: Int,
    val ownerId: Int,
    val albumId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<PhotoCopy>,
    val width: Int,
    val height: Int
) : Attachment("photo")

data class PhotoCopy(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)

data class StickerAttachment(
    val productId: Int,
    val stickerId: Int,
    val images: Array<ImageSticker>,
    val imagesWithBackground: Array<ImageSticker>
) : Attachment("sticker")

data class ImageSticker(
    val url: String,
    val width: Int,
    val height: Int
)

data class AlbumAttachment(
    val id: Int,
    val thumb: PhotoAttachment,
    val ownerId: Int,
    val title: String,
    val description: String,
    val created: Int,
    val updated: Int,
    val size: Int
) : Attachment("album")

fun ownerIdReturn (attachment: Attachment): Int? {
    return when (attachment.type) {

        "audio" -> (attachment as AudioAttachment).ownerId
        "photo" -> (attachment as PhotoAttachment).ownerId
        "graffiti" ->  (attachment as GraffitiAttachment).ownerId
        "album" ->  (attachment as AlbumAttachment).ownerId
        else -> null
    }

}
