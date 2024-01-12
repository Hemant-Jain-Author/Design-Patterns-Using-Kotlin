open class Student(var name: String, var id: Int)

class Model {
    private val student = Student("Harry", 1)

    fun setData(name: String, id: Int) {
        println("Model: Set data : $name $id")
        student.name = name
        student.id = id
    }

    val data: Student
        get() {
            println("Model: Get data.")
            return student
        }
}

class View(private val model: Model) {
    fun update() {
        val student = model.data
        println("View: Student Info, Name: " + student.name + " Id: " + student.id)
    }
}

class Controller {
    private val model = Model()
    private val view = View(model)

    fun setData(name: String, id: Int) {
        println("Controller: Receive data from client.")
        model.setData(name, id)
    }

    fun updateView() {
        println("Controller: Receive update view from client.")
        view.update()
    }
}

fun main() {
    val controller = Controller()
    controller.updateView()

    controller.setData("Jack", 2)
    controller.updateView()
}


/*
Controller: Receive update view from client.
Model: Get data.
View: Student Info, Name: Harry Id: 1
Controller: Receive data from client.
Model: Set data : Jack 2
Controller: Receive update view from client.
Model: Get data.
View: Student Info, Name: Jack Id: 2
*/

