class Model {
    private var data = "Hello, World!"

    fun setData(data: String) {
        println("Model: Set data : $data")
        this.data = data
    }

    fun getData(): String {
        println("Model: Get data: $data")
        return data
    }
}

// View class
class View(private val model: Model) {
    // In classic MVC, the view interacts with the model to get data.
    fun update() {
        val data = model.getData()
        println("View: Updating the view with data : $data")
    }
}

// Controller class
class Controller {
    private val model = Model()
    private val view = View(model)

    fun setData(data: String) {
        println("Controller: Receive data from client.")
        model.setData(data)
    }

    fun updateView() {
        println("Controller: Receive update view from client.")
        view.update()
    }
}

// Main class (Client code)
fun main() {
    val controller = Controller()
    controller.updateView()

    controller.setData("Hello, Students!")
    controller.updateView()
}


/*
Controller: Receive update view from client.
Model: Get data: Hello, World!
View: Updating the view with data : Hello, World!
Controller: Receive data from client.
Model: Set data : Hello, Students!
Controller: Receive update view from client.
Model: Get data: Hello, Students!
View: Updating the view with data : Hello, Students!
*/

