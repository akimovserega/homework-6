package ru.netology


// класс attachment, 5 видов
abstract class Attachment(open val type: String = "non-type")

data class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio
) : Attachment()

data class GraffitiAttachment(
    override val type: String = "graffiti",
    val graffiti: Graffiti
) : Attachment()

data class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
) : Attachment()

data class StickerAttachment(
    override val type: String = "sticker",
    val sticker: Sticker
) : Attachment()

data class AlbumAttachment(
    override val type: String = "album",
    val album: Album
) : Attachment()


data class Audio(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val date: Int,
    val noSearch: Boolean,
    val isHQ: Boolean,
    val artist: String,
    val title: String,
    val duration: Int,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int
)

data class Graffiti(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
)

data class Photo(
    val id: Int,
    val ownerId: Int,
    val albumId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<PhotoCopy>,
    val width: Int,
    val height: Int
)

data class PhotoCopy(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)

data class Sticker(
    val productId: Int,
    val stickerId: Int,
    val images: Array<ImageSticker>,
    val imagesWithBackground: Array<ImageSticker>
)

data class ImageSticker(
    val url: String,
    val width: Int,
    val height: Int
)

data class Album(
    val id: Int,
    val thumb: PhotoAttachment,
    val ownerId: Int,
    val title: String,
    val description: String,
    val created: Int,
    val updated: Int,
    val size: Int
)


fun ownerIdReturn(attachment: Attachment): Int? {

    return when (attachment.type) {

        "audio" -> (attachment as AudioAttachment).audio.ownerId
        "photo" -> (attachment as PhotoAttachment).photo.ownerId
        "graffiti" -> (attachment as GraffitiAttachment).graffiti.ownerId
        "album" -> (attachment as AlbumAttachment).album.ownerId
        else -> null
    }

}
