abstract class Handler(successor: Handler?) {
    protected var successor: Handler? = successor

    abstract fun handleRequest()
}

class ConcreteHandler1(successor: Handler?) : Handler(successor) {
    override fun handleRequest() {
        if (true) {  // Can handle request.
            println("Finally handled by ConcreteHandler1")
        } else if (successor != null) {
            println("Message passed to next in chain by ConcreteHandler1")
            successor!!.handleRequest()
        }
    }
}

class ConcreteHandler2(successor: Handler?) : Handler(successor) {
    override fun handleRequest() {
        if (false) {  // Can't handle request.
            println("Finally handled by ConcreteHandler2")
        } else if (successor != null) {
            println("Message passed to next in chain by ConcreteHandler2")
            successor!!.handleRequest()
        }
    }
}

fun main() {
    val ch1 = ConcreteHandler1(null)
    val ch2 = ConcreteHandler2(ch1)
    ch2.handleRequest()
}

/*
Message passed to next in chain by ConcreteHandler2
Finally handled by ConcreteHandler1
*/