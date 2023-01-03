import kotlin.random.Random

class MediumTruck : Truck() {
    override val cargo: MutableList<Cargo?> = mutableListOf()
    override val loadCapacity = 400
init {
    loadCargo()
}
    private fun loadCargo() {
        val n = Random.nextInt(1, 3)
        when (n) {
            1 -> {
                cargo.add(Food.Milk)
                cargo.add(Food.Bread)
                cargo.add(Food.Potato)
            }

            2 -> {
                cargo.add(Compact.Nails)
                cargo.add(Compact.Screws)
                cargo.add(MidSized.Notebook)
                cargo.add(MidSized.Textbook)
                cargo.add(Oversized.Fridge)
                cargo.add(Oversized.WashingMachine)
            }
        }
    }

    fun info() {
        println("capacity: $loadCapacity, cargo items: ${cargo.toString()}")
    }
}