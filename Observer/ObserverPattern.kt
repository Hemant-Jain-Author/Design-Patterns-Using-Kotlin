import java.util.ArrayList

// Subject interface
interface Subject {
    fun attach(observer: Observer)
    fun detach(observer: Observer)
    fun notifyObservers(newState: String?)
}

// ConcreteSubject class
class ConcreteSubject : Subject {
    private var state: String? = null
    private val observers: MutableList<Observer> = ArrayList()

    fun getState(): String? {
        return state
    }

    fun setState(arg: String) {
        state = arg
        notifyObservers(arg)
    }

    override fun attach(observer: Observer) {
        observer.subject = this
        observers.add(observer)
    }

    override fun detach(observer: Observer) {
        observer.subject = null
        observers.remove(observer)
    }

    override fun notifyObservers(newState: String?) {
        for (observer in observers) {
            observer.update(newState)
        }
    }
}

// Observer interface
interface Observer {
    var subject: Subject?
    fun update(newState: String?)
}

// ConcreteObserver classes
class ConcreteObserver1 : Observer {
    override var subject: Subject? = null

    init {
        subject?.attach(this)
    }

    override fun update(newState: String?) {
        println("$newState notified to Observer1")
    }
}

class ConcreteObserver2 : Observer {
    override var subject: Subject? = null

    init {
        subject?.attach(this)
    }

    override fun update(newState: String?) {
        println("$newState notified to Observer2")
    }
}

fun main() {
    // Client Code
    val subject = ConcreteSubject()
    val observer1 = ConcreteObserver1()
    val observer2 = ConcreteObserver2()

    subject.attach(observer1)
    subject.attach(observer2)

    subject.setState("First state")
    subject.setState("Second state")
}

/*
First state notified to Observer1
First state notified to Observer2
Second state notified to Observer1
Second state notified to Observer2
*/