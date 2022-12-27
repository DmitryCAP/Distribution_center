class DistributionCenter {
    val numberOfUnloading = 2
    val numberOfDownload = 2
    private val cargoEject = mutableListOf<Cargo>()
fun info(){
    println("distribution center include: ${cargoEject.size}")
}
    fun cargoArray(cargo: Cargo): MutableList<Cargo> {

        cargoEject.add(cargo)
        return cargoEject
    }
}