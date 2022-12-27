import kotlin.random.Random

sealed class Compact : Cargo() {
    object Nails : Compact() {
        override val weight: Int = Random.nextInt(1, 10)
        override val loadingTime: Int = 6
    }

    object Screws : Compact() {
        override val weight: Int = Random.nextInt(1, 10)
        override val loadingTime: Int = 6
    }
}
