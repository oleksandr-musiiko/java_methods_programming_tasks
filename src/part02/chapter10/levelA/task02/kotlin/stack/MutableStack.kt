package part02.chapter10.levelA.task02.kotlin.stack

class MutableStack<E>(vararg items: E) {

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek() = elements.last()

    fun pop() = elements.removeAt(elements.lastIndex)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString(): String = "MutableStack{${elements.joinToString(", ")}}"
}