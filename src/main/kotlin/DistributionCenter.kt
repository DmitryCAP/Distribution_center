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
}