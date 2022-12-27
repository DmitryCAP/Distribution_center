import kotlin.random.Random

sealed class MidSized : Cargo() {
    object Textbook : MidSized() {
        override val weight: Int = Random.nextInt(1, 10)
        override val loadingTime: Int = 4
    }

    object Notebook : MidSized() {
        override val weight: Int = Random.nextInt(1, 10)
        override val loadingTime: Int = 4
    }
}
