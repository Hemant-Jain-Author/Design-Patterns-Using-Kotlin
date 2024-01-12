import java.util.*

class Model {
    var data: String? = null
        get() {
            println("Model: Get data.")
            return field
        }
        set(data) {
            println("Model: Set data.")
            field = data
            presenter!!.modelUpdateEvent()
        }
    private var presenter: Presenter? = null

    fun setPresenter(presenter: Presenter?) {
        this.presenter = presenter
    }
}

// Presenter
class Presenter(private val model: Model, private val view: View) {
    fun handleUserInput(userInput: String?) {
        println("Presenter: Handle user input.")
        model.data = userInput
    }

    fun modelUpdateEvent() {
        println("Presenter: Model update event.")
        view.update(model.data)
    }
}

// View
class View {
    private var presenter: Presenter? = null

    fun update(data: String?) {
        println("View: Update UI.")
        println("Data: $data")
    }

    fun setPresenter(presenter: Presenter?) {
        this.presenter = presenter
    }

    val userInput: Unit
        get() {
            print("View: Enter user input: ")
            val userInput = "hello, world!"
            println(userInput)
            //val scanner = Scanner(System.`in`)
            //String userInput = scanner.nextLine();
            presenter!!.handleUserInput(userInput)
        }
}

// Client code
object MVP {
    @JvmStatic
    fun main() {
        val model = Model()
        val view = View()
        val presenter = Presenter(model, view)

        model.setPresenter(presenter)
        view.setPresenter(presenter)

        view.userInput
    }
} /*
View: Enter user input: hello, world!
Presenter: Handle user input.
Model: Set data.
Presenter: Model update event.
Model: Get data.
View: Update UI.
Data: hello, world! 
 */

