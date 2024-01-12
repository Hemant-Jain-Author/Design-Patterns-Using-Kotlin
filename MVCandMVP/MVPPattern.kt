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

class View {
    fun update(data: String) {
        println("View: Updating the view with data: $data")
    }
}

class Presenter {
    private val model = Model()
    private val view = View()

    fun setData(data: String) {
        println("Presenter: Receive data from client.")
        model.setData(data)
    }

    fun updateView() {
        println("Presenter: Receive update view from client.")
        val data = model.getData()
        view.update(data)
    }
}

fun main() {
    println("Client: Pass trigger to Presenter.")
    val presenter = Presenter()
    presenter.updateView()

    presenter.setData("Hello, Students!")
    presenter.updateView()
}

/*
Client: Pass trigger to Presenter.
Presenter: Receive update view from client.
Model: Get data: Hello, World!
View: Updating the view with data: Hello, World!
Presenter: Receive data from client.
Model: Set data : Hello, Students!
Presenter: Receive update view from client.
Model: Get data: Hello, Students!
View: Updating the view with data: Hello, Students!
*/

