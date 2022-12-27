import kotlin.random.Random

sealed class Oversized : Cargo() {
    object WashingMachine : Oversized() {
        override val weight: Int = Random.nextInt(10, 30)
        override val loadingTime: Int = 10
    }

    object Fridge : Oversized() {
        override val weight: Int = Random.nextInt(10, 30)
        override val loadingTime: Int = 15

    }
}
