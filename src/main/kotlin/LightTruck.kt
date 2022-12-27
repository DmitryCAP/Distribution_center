import kotlin.random.Random

class LightTruck : Truck() {
    override val cargo: Stack<Cargo?> = Stack()
    override val loadCapacity = 300

    fun info() {
        println("capacity: $loadCapacity, cargo items: ${cargo.toString()}")
    }

}