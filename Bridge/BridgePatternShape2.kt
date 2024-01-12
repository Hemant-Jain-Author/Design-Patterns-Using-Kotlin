 abstract class Shape(protected var implementation: DrawingAPI) {
    abstract fun draw()
}

// Concrete Abstraction
class Square(implementation: DrawingAPI) : Shape(implementation) {
    override fun draw() {
        implementation.drawSquare()
    }
}

class Circle(implementation: DrawingAPI) : Shape(implementation) {
    override fun draw() {
        implementation.drawCircle()
    }
}

// Implementation
interface DrawingAPI {
    fun drawSquare()
    fun drawCircle()
}

// Concrete Implementation
class WindowsAPI : DrawingAPI {
    override fun drawSquare() {
        println("Drawing a square on Windows.")
    }

    override fun drawCircle() {
        println("Drawing a circle on Windows.")
    }
}

class MacAPI : DrawingAPI {
    override fun drawSquare() {
        println("Drawing a square on Mac.")
    }

    override fun drawCircle() {
        println("Drawing a circle on Mac.")
    }
}

// Usage
fun main() {
    val windowsAPI: DrawingAPI = WindowsAPI()
    val macAPI: DrawingAPI = MacAPI()

    val square: Shape = Square(windowsAPI)
    square.draw()

    val circle: Shape = Circle(macAPI)
    circle.draw()
}

/*
Drawing a square on Windows.
Drawing a circle on Mac.
*/