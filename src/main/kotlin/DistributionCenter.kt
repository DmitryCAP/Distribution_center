import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DistributionCenter {
    val numberOfUnloading = 2
    val numberOfDownload = 2
    var cargoEject = mutableListOf<Cargo?>()
    fun info() {
        println("distribution center include: ${cargoEject.size}")
    }

    fun cargoArray(cargo: MutableList<Cargo?>): MutableList<Cargo?> {


        randomTruck?.cargo?.onEachIndexed { _, cargo -> cargoEject.add(cargo)}

            return cargoEject

        }
    private val mutex = Mutex()

//    suspend fun getElementFromStorage(): Cargo {
//
//        mutex.withLock {
//cargoEject.forEach()
//            //код по получению элементов из хранилища
//
//            return Cargo()
//
//        }
//
//    }
}