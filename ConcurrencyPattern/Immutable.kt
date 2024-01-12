class ImmutablePerson(val name: String, val age: Int, val gender: String)

object Immutable {
    @JvmStatic
    fun main() {
        val person = ImmutablePerson("John Doe", 30, "Male")
        val newPerson = ImmutablePerson("John Doe", 31, "Male")

        println(person)
        println(newPerson)
        /* 
        person.age = 32;
        Immutable.java:32: error: age has private access in ImmutablePerson
    */
    }
}
