import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

var randomTruck: Truck? = null
val distributionCenter = DistributionCenter()
 fun main() {

     runBlocking {

        val channel = Channel<Truck>()

        launch {

            repeat(2) {
                val producer = produceTruckCargo()
                repeat(distributionCenter.numberOfUnloading) { launchProcessor(it, producer) }
                println("receive..${channel.receive()}..cargo- ${randomTruck?.cargo.toString()}")
                distributionCenter.info()
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
        var n = Random.nextInt(0, 4)
        when (n) {
            1 -> {
                randomTruck = LightTruck()

            }

            2 -> {
                randomTruck = MediumTruck()
            }

            3 -> {
                randomTruck = HeavyTruck()
            }

            else -> randomTruck = LightTruck()
        }

        send(randomTruck!!) // produce next
        println("send Truck")
        //  val time = randomTruck.loadCapacity

        // delay(time.toLong())
        delay(1000)

    }


}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Truck>) = launch {
    for (msg in channel) {

        println("Processor #$id received $msg")

          


        distributionCenter.cargoEject = distributionCenter.cargoArray(msg.cargo)

        println("pazgruzka tracka.Distribution center include: ${distributionCenter.info()}")
distributionCenter.sortedCargo()
        yield()
    }

}










