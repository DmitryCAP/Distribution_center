import kotlin.random.Random

abstract class Truck() {
    abstract val cargo: Stack<Cargo?>
    abstract val loadCapacity: Int
   init {

       fun loadCargo() {
           val n = Random.nextInt(1, 3)
           when (n) {
               1 -> {
                   cargo.push(Food.Milk)
                   cargo.push(Food.Bread)
                   cargo.push(Food.Potato)
               }

               2 -> {
                   cargo.push(Compact.Nails)
                   cargo.push(Compact.Screws)
                   cargo.push(MidSized.Notebook)
                   cargo.push(MidSized.Textbook)
                   cargo.push(Oversized.Fridge)
                   cargo.push(Oversized.WashingMachine)
               }
           }
       }
   }

}


