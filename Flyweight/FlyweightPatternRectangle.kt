import java.util.*

interface Shape {
    fun draw(x1: Int, y1: Int, x2: Int, y2: Int)
}

// Rectangle class implementing Shape
open class Rectangle(private val colour: String) : Shape {
    override fun draw(x1: Int, y1: Int, x2: Int, y2: Int) {
        println("Draw rectangle color: $colour topleft: ($x1,$y1) rightBottom: ($x2,$y2)")

    }
}

// RectangleFactory class
class RectangleFactory {
    private val shapes: MutableMap<String, Shape> = HashMap()

    fun getRectangle(colour: String): Shape? {
        if (!shapes.containsKey(colour)) {
            shapes[colour] = Rectangle(colour)
        }
        return shapes[colour]
    }

    val count: Int
        get() = shapes.size
}

// Client code
fun main() {
    val factory = RectangleFactory()
    val random = Random()

    for (i in 0..99) {
        val rectangle = factory.getRectangle(random.nextInt(1000).toString())
        rectangle!!.draw(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100))
    }
    println(factory.count)
}
