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
        }
}

// ViewModel
class ViewModel(private val model: Model) {
    var data: String? = null
        private set

    init {
        updateData()
    }

    fun updateModel(data: String?) {
        println("ViewModel: Update data.")
        model.data = data
        updateData()
    }

    fun updateData() {
        println("ViewModel: Fetch data.")
        data = model.data
    }
}

// View
class View(private val viewModel: ViewModel) {
    fun displayData() {
        println("Display Data: " + viewModel.data)
    }

    val userInput: Unit
        get() {
            val scanner = Scanner(System.`in`)
            print("View: Enter user input: ")
            /* 
        String userInput = "hello, world!";
        System.out.println(userInput);
        */
            val userInput = scanner.nextLine()
            viewModel.updateModel(userInput)
        }
}

// Client code
object MVVM {
    @JvmStatic
    fun main() {
        val model = Model()
        val viewModel = ViewModel(model)
        val view = View(viewModel)

        // Display initial data
        view.displayData()

        // Get user input and update data
        view.userInput

        // Display updated data
        view.displayData()
    }
} /*
ViewModel: Fetch data.
Model: Get data.
Display Data: null
View: Enter user input: hello, world!
ViewModel: Update data.
Model: Set data.
ViewModel: Fetch data.
Model: Get data.
Display Data: hello, world!
*/



