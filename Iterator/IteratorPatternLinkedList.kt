class LinkedList : Iterable<Int?> {
    inner class Node(var value: Int, var next: Node?)

    var head: Node? = null
    var tail: Node? = null
    var size: Int = 0

    fun addHead(value: Int) {
        val newNode: Node = Node(value, head)
        if (head == null) {
            tail = newNode
        }
        head = newNode
        size++
    }

    override fun iterator(): MutableIterator<Int> {
        return LinkedListIterator(this)
    }
}

class LinkedListIterator(var aggregate: LinkedList) : MutableIterator<Int> {
    var current: LinkedList.Node?
    var previous: LinkedList.Node? = null

    init {
        this.current = aggregate.head
    }

    override fun hasNext(): Boolean {
        return current != null
    }

    override fun next(): Int {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val value = current!!.value
        previous = current
        current = current!!.next
        return value
    }

    override fun remove() {
        if (previous == null) {
            throw IllegalStateException("next() must be called before remove()")
        }
        aggregate.size--
        if (previous == null) {
            aggregate.head = current
        } else {
            previous!!.next = current
        }
    }
}

fun main() {
    val aggregate = LinkedList()
    for (i in 0..4) {
        aggregate.addHead(i)
    }

    for (`val` in aggregate) {
        print("$`val` ")
    }
}

/*
4 3 2 1 0 
*/