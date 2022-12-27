import kotlin.random.Random

class MediumTruck : Truck() {
    override val cargo: Stack<Cargo?> = Stack()
    override val loadCapacity = 400

    fun info() {
        println("capacity: $loadCapacity, cargo items: ${cargo.toString()}")
    }
}