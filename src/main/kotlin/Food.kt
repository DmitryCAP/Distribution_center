import kotlin.random.Random

sealed class Food : Cargo() {
    object Potato : Food() {
        override val weight: Int = Random.nextInt(1, 10)
        override val loadingTime: Int = 5
    }

    object Milk : Food() {
        override val weight: Int = Random.nextInt(1, 10)
        override val loadingTime: Int = 3

    }

    object Bread : Food() {
        override val weight: Int = Random.nextInt(1, 10)
        override val loadingTime: Int = 2
    }

}
