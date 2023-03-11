import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

var randomTruck: Truck? = null
val distributionCenter = DistributionCenter()
fun main() {

    runBlocking {

        val channel = Channel<Truck>(4)

        launch {

            repeat(2) {
                val producer = produceTruckCargo()
                repeat(distributionCenter.numberOfUnloading) { launchProcessor(it, producer) }
                println("receive..${channel.receive()}..cargo- ${randomTruck?.cargo.toString()}")
                distributionCenter.info()
            }

        }
        launch {

            repeat(2) {
                val producer2 = produceTruckCargoWithoutLoad()
                repeat(distributionCenter.numberOfDownload) { launchProcessor(it, producer2) }
                println("receive..${channel.receive()}")

            }

        }
    }


//     val coldFlow = flow {      //холодный Flow . Начинает создание канала (погрузку грузовика) когда появляется подписчик
//         while (isActive) {
//             emit(nextEvent)
//         }
//     }
}

fun CoroutineScope.produceTruckCargo() = produce<Truck> {

    while (true) {
        val n = Random.nextInt(0, 3)
        randomTruck = when (n) {
            1 -> {
                HeavyTruck()
            }

            2 -> {
                MediumTruck()
            }

            else -> LightTruck()
        }
        randomTruck!!.loadCargo()
        send(randomTruck!!) // produce next
        println("send Truck")
        yield()
    }
}

fun CoroutineScope.produceTruckCargoWithoutLoad() = produce<Truck> {

    while (true) {
        val n = Random.nextInt(0, 3)
        randomTruck = when (n) {
            1 -> {
                HeavyTruck()
            }

            2 -> {
                MediumTruck()
            }

            else -> LightTruck()
        }

        send(randomTruck!!) // produce next
        println("send TruckWithoutLoad")
        yield()
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Truck>) = launch {
    for (msg in channel) {

        println("Processor #$id received $msg")




        distributionCenter.cargoEject = distributionCenter.cargoArray(msg.cargo)

        println("Truck.Distribution center include: ${distributionCenter.info()}")
        repeat(1) {
            distributionCenter.sortedCargo()
        }
       distributionCenter.info()

    }

}










