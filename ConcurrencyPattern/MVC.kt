import java.util.*

class Model {
    var data: String? = null
        get() {
            println("Model : Get data.")
            return field
        }
        set(data) {
            println("Model : Set data.")
            field = data
            notifyObservers()
        }
    private val observers: MutableList<Observer> = ArrayList()

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        println("Model : Notify observers.")
        for (observer in observers) {
            observer.update()
        }
    }
}

// View
class View(private val model: Model, private val controller: Controller) : Observer {
    init {
        model.addObserver(this)
    }

    override fun update() {
        println("View : Update.")
        val data = model.data
        println("Data: $data")
    }

    val userInput: Unit
        get() {
            Scanner(System.`in`).use { scanner ->
                print("View : Enter user input: ")
                //String userInput = "hello, world!";
                //System.out.println(userInput);
                val userInput = scanner.nextLine()
                controller.handleUserInput(userInput)
            }
        }
}

// Controller
class Controller(private val model: Model) {
    private var view: View? = null

    fun handleUserInput(userInput: String?) {
        println("Controller : Handle user input.")
        model.data = userInput
        // Can inform view about action.
    }

    fun setView(v: View?) {
        this.view = v
    }
}

// Observer interface
interface Observer {
    fun update()
}

// Main class
object MVC {
    @JvmStatic
    fun main() {
        val model = Model()
        val controller = Controller(model) // The Controller sets itself as the observer in this case
        val view = View(model, controller)
        controller.setView(view)
        view.userInput
    }
} /*
View : Enter user input: hello, world!
Controller : Handle user input.
Model : Set data.
Model : Notify observers.
View : Update.
Model : Get data.
Data: hello, world!
 */

