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


            for (i in 1..2) {

                val n = Random.nextInt(0, 4)
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


                channel.send(randomTruck!!) // produce next
                delay(1000) // wait


            }


        }
        repeat(2) {
            println("receive..${channel.receive()}..cargo- ${randomTruck?.cargo.toString()}")

            val producer = produceTruckCargo()
            repeat(distributionCenter.numberOfUnloading) { launchProcessor(it, producer) }
//            val time = 2 //randomTruck.
//            delay(time)

            producer.cancel()
        }


    }
    distributionCenter.info()
}

fun CoroutineScope.produceTruckCargo() = produce<Cargo> {

//    randomTruck?.cargo?.pop() {
//
//        send() // produce next
//
//        val time = randomTruck.loadCapacity
//
//        delay(time.toLong())
//    }
    println("eject product")

}

//
//
//
fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Cargo>) = launch {
    for (msg in channel) {
        println("Processor #$id received $msg")
        distributionCenter.cargoArray(msg)
    }
}










