data class Student(var name: String, var id: Int)

class Model {
    // Dummy model which just has one object.
    // Model is supposed to interact with the database.
    var st = Student("Harry", 1)

    fun setData(name: String, id: Int) {
        println("Model: Set data : $name $id")
        st.name = name
        st.id = id
    }

    fun getData(): Student {
        println("Model: Get data.")
        return st
    }
}

class View {
    // Dummy view which prints some data to standard output.
    // View is supposed to interact with the UI.
    fun update(name: String, id: Int) {
        println("View: Student Info : $name $id")
    }
}

class Presenter {
    private val model = Model()
    private val view = View()

    fun setData(name: String, id: Int) {
        println("Presenter: Receive data from the client.")
        model.setData(name, id)
    }

    fun updateView() {
        println("Presenter: Receive update from the client.")
        val data = model.getData()
        view.update(data.name, data.id)
    }
}

fun main() {
    val presenter = Presenter()
    presenter.updateView()

    presenter.setData("Jack", 2)
    presenter.updateView()
}

/*
Presenter: Receive update from the client.
Model: Get data.
View: Student Info : Harry 1
Presenter: Receive data from the client.
Model: Set data : Jack 2
Presenter: Receive update from the client.
Model: Get data.
View: Student Info : Jack 2
*/