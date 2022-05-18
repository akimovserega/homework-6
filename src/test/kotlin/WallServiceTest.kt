import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.*

class WallServiceTest {
    @Before
    fun prepareData() {
        val newPost = Post(
            0, 15555, 165, 1, 1235, "post #1",
            1561, 56544543, false,
            Comments(0, true, true, true, true),
            Copyright(7575, "https://..ru", "ссылка", "type"),
            Likes(0, true, true, true),
            Repost(0, false),
            Views(0), "type", 45654, true,
            true, true, false, false, false,
            Donut(false, 32423, PlaceHolder(), true, "edit_mode"),
            4545
        )


        val post = WallService.add(newPost)
    }


    @After
    fun deleteData() {
        WallService.removeAll()
    }


    @Test
    fun check_id_after_add() {


        val newPost = Post(
            0, 99888, 331312, 1, 7451, "post #1",
            1561, 56544543, false,
            Comments(0, true, true, true, true),
            Copyright(7575, "https://..ru", "ссылка", "type"),
            Likes(0, true, true, true),
            Repost(0, false),
            Views(0), "type", 45654, true,
            true, true, false, false, false,
            Donut(false, 32423, PlaceHolder(), true, "edit_mode"),
            4545
        )
        val post = WallService.add(newPost)


        assertTrue(post.id > 0)
    }

    @Test
    fun check_update_existing_post() {

        // создаём информацию об обновлении
        val updatePost = Post(
            1, 15555, 165, 1, 1235, "post #1",
            1561, 56544543, false,
            Comments(1, true, true, true, true),
            Copyright(7575, "https://..ru", "ссылка", "type"),
            Likes(1, true, true, true),
            Repost(0, false),
            Views(0), "type", 45654, true,
            true, true, false, false, false,
            Donut(false, 32423, PlaceHolder(), true, "edit_mode"),
            4545
        )
        // выполняем целевое действие
        val result = WallService.update(updatePost)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun check_update_nonexisting_post() {

        // создаём информацию об обновлении
        val updatePost = Post(
            77777, 15555, 165, 1, 1235, "post #1",
            1561, 56544543, true,
            Comments(0, true, true, true, true),
            Copyright(7575, "https://..ru", "ссылка", "type"),
            Likes(0, true, true, true),
            Repost(0, false),
            Views(0), "type", 45654, true,
            true, true, false, false, false,
            Donut(false, 32423, PlaceHolder(), true, "edit_mode"),
            4545
        )
        // выполняем целевое действие
        val result = WallService.update(updatePost)

        assertFalse(result)
    }
}