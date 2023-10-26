import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)

    val b: String? = null
    val bLength: Int = b?.length ?: 0

    println(bLength)
    println(gr(b ?: "null"))

    val names = arrayOf("Sergei", "Pasha", "Alesha", "Artur")

    val namess = names.filter { name -> name[0] == 'A' }

    for (i in 0..namess.size - 1) println(namess[i])

    val sayHello = { println("HELLO ANDROID ACADEMY") }

    sayHello()

    val growth: (Int) -> Int = {s -> s * 2}

    println(growth(500))

    names.forEach { i ->
        print("$i ")
    }
    println()
//
//    val iceCream = IceCream("Vanill")
//    println(iceCream.isVanilla)

    val iceCreamm = IceCream("Chocolate")
    println("${iceCreamm.flavor}, ${iceCreamm.isVanilla}")
    iceCreamm.isVanilla = true
    println("${iceCreamm.flavor}, ${iceCreamm.isVanilla}")


    val myOrder = Order(1, "Vanilla")

    println(myOrder)

    val n = myOrder.copy(flavor = "Chocalette")

    val (o, v) = myOrder
    println("$o + $v")
}

fun gr(name: String): String {
    return "Hello + $name"
}

class IceCream(var flavor: String = "Vanilla", val cone: Boolean = true) {
    var isVanilla
        get() = this.flavor == "Vanilla"
        set(value) {
            if(value) flavor = "Vanilla"
        }

}

data class Order(val orderNum: Int, val flavor: String)
