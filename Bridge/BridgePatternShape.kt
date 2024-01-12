interface Shape {
    fun draw()
}

// Rectangle class
open class Rectangle(private val imp: Color) : Shape {
    override fun draw() {
        println("Drawing Rectangle with color " + imp.fill())
    }
}

// Circle class
class Circle(private val imp: Color) : Shape {
    override fun draw() {
        println("Drawing Circle with color " + imp.fill())
    }
}

// Implementor interface
interface Color {
    fun fill(): String
}

// Red class
class Red : Color {
    override fun fill(): String {
        return "Red"
    }
}

// Green class
class Green : Color {
    override fun fill(): String {
        return "Green"
    }
}

// Client code
fun main() {
    val c1 = Red()
    val abstraction: Shape = Circle(c1)
    abstraction.draw()

    val c2 = Green()
    val abstraction2: Shape = Rectangle(c2)
    abstraction2.draw()
}

/*
Drawing Circle with color Red
Drawing Rectangle with color Green
*/
