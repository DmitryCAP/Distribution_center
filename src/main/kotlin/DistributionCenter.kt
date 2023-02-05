import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DistributionCenter {
    val numberOfUnloading = 2
    val numberOfDownload = 2

    var cargoEject = mutableListOf<Cargo?>()
    val milkList = mutableListOf<Cargo?>()
    val breadList = mutableListOf<Cargo?>()
    val potatoList = mutableListOf<Cargo?>()
    val nailsList = mutableListOf<Cargo?>()
    val screwsList = mutableListOf<Cargo?>()
    val notebookList = mutableListOf<Cargo?>()
    val textbookList = mutableListOf<Cargo?>()
    val fridgeList = mutableListOf<Cargo?>()
    val washingMachineList = mutableListOf<Cargo?>()

    fun info() {
        println(
            "distribution center include: Unsorted cargo: ${cargoEject.size}" + "\n" +
                    " Milk-${milkList.size}" + "\n" +
                    " Bread-${breadList.size}" + "\n" +
                    " Potato-${potatoList.size}" + "\n" +
                    " Nails-${nailsList.size}" + "\n" +
                    " Screws-${screwsList.size}" + "\n" +
                    " Notebook-${notebookList.size}" + "\n" +
                    " Textbook-${textbookList.size}" + "\n" +
                    " Fridge-${fridgeList.size}" + "\n" +
                    " WashingMachine-${washingMachineList.size}."
        )
    }

    fun cargoArray(cargo: MutableList<Cargo?>): MutableList<Cargo?> {


        randomTruck?.cargo?.onEachIndexed { _, cargo -> cargoEject.add(cargo) }

        return cargoEject

    }

    fun sortedCargo() {         // сортировка - функция извлечения из общего списка товаров, чтобы не загрузить в разные грузовики один товар

        if (cargoEject.size > 0) {
            cargoEject.forEach {

                when (it) {
                    is Food.Milk -> milkList.add(it)
                    is Food.Bread -> breadList.add(it)
                    is Food.Potato -> potatoList.add(it)
                    is Compact.Nails -> nailsList.add(it)
                    is Compact.Screws -> screwsList.add(it)
                    is MidSized.Notebook -> notebookList.add(it)
                    is MidSized.Textbook -> textbookList.add(it)
                    is Oversized.Fridge -> fridgeList.add(it)
                    is Oversized.WashingMachine -> washingMachineList.add(it)

                }
                println("Cargo sorted: $it")
                // cargoEject.remove(it) // удалить этот элемент из списка cargoEject
            }

        }
    }
}

fun addingProduct() {                                             //добавления товаров, чтобы не добавить разные товары в одну ячейку

}
// mutex.withLock{
//    for (it in cargo.indices){
//        repeat(1) {i ->
//            delay(cargo[i].loadingTime)

//    suspend fun getElementFromStorage(): Cargo {
//
//        mutex.withLock {
//     cargoEject.forEach()      //код по получению элементов из хранилища
//
//            return Cargo()
//
//        }
//
//    }

