import java.util.*

interface Shape {
    fun draw(x1: Int, y1: Int, x2: Int, y2: Int)
}

// Rectangle class implementing Shape with Intrinsic State
class RectangleIntrinsic(private val color: String) : Shape {
    override fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {

        println("Draw rectangle color: $color topleft: ($x1,$y1) rightBottom: ($x2,$y2)")

    }
}

// RectangleFactory class for managing Flyweight objects
class RectangleFactory {
    private val shapes: MutableMap<String, Shape> = HashMap()

    fun getRectangle(color: String): Shape? {
        if (!shapes.containsKey(color)) {
            shapes[color] = RectangleIntrinsic(color)
        }
        return shapes[color]
    }
}

// Rectangle class without Flyweight
class RectangleWithoutFlyweight(private val color: String) {
    fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        System.out.printf("Draw rectangle color: %s topleft: (%s,%s) rightBottom: (%s,%s)%n",
                this.color, x1, y1, x2, y2)
    }
}

// Client code
fun main() {
    val factory = RectangleFactory()
    val random = Random()

    var startTime = System.currentTimeMillis()
    for (i in 0..99) {
        val rectangle = factory.getRectangle(random.nextInt(10).toString())
        rectangle!!.draw(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100))
    }
    var endTime = System.currentTimeMillis()

    println("Flyweight Time: " + (endTime - startTime) + " ms")

    startTime = System.currentTimeMillis()
    for (i in 0..9999) {
        val rectangle = RectangleWithoutFlyweight(random.nextInt(10).toString())
        rectangle.draw(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100))
    }
    endTime = System.currentTimeMillis()

    println("Without Flyweight Time: " + (endTime - startTime) + " ms")
}

