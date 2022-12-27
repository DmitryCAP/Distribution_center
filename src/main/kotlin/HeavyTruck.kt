import kotlin.random.Random

class HeavyTruck : Truck() {
    override val cargo: Stack<Cargo?> = Stack()
    override val loadCapacity = 500

    fun info() {
        println("capacity: $loadCapacity, cargo items: ${cargo.toString()}")
    }

}