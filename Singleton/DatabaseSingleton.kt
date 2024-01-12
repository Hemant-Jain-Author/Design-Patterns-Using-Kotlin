import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

class Database private constructor() {
    companion object {
        private var instance: Database? = null
        val connection: Connection
        val statement: Statement

        init {
            instance = Database()
            println("Database created")
            connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3")
            statement = connection.createStatement()
        }

        fun getInstance(): Database {
            return instance ?: throw IllegalStateException("Database not initialized")
        }
    }

    fun createTable() {
        statement.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT);")
    }

    fun addData(id: Int, name: String) {
        val query = "INSERT INTO students (id, name) VALUES ($id, '$name');"
        statement.execute(query)
    }

    fun display() {
        val resultSet = statement.executeQuery("SELECT * FROM students;")
        while (resultSet.next()) {
            val id = resultSet.getInt("id")
            val name = resultSet.getString("name")
            println("id: $id, name: $name")
        }
    }
}

fun main() {
    val db1 = Database.getInstance()
    val db2 = Database.getInstance()

    println("Database Objects DB1: $db1")
    println("Database Objects DB2: $db2")

    db1.createTable()
    db1.addData(1, "john")
    db2.addData(2, "smith")

    db1.display()
}
