package part02.chapter10.levelA.task08.kotlin.model

class CustomSetOfIntegers(override val size: Int) : MutableSet<Int> {

    private val elements = ArrayList<Int>(size)

    constructor(vararg elements: Int): this(elements.size) {
        elements.forEach { element -> add(element) }
    }

    constructor(collection: Collection<Int>): this(collection.size) {
        collection.forEach { element -> add(element) }
    }

    override fun add(element: Int): Boolean = if (!contains(element)) add(element) else false

    override fun addAll(elements: Collection<Int>): Boolean {
        var wasModified = false
        elements.forEach { element -> if (add(element)) wasModified = true }
        return wasModified
    }

    override fun clear() = elements.clear()

    override fun iterator(): MutableIterator<Int> = elements.iterator()

    override fun remove(element: Int): Boolean = elements.remove(element)

    override fun removeAll(elements: Collection<Int>): Boolean = this.elements.removeAll(elements)

    override fun retainAll(elements: Collection<Int>): Boolean = this.elements.removeAll(elements)

    override fun contains(element: Int): Boolean = elements.contains(element)

    override fun containsAll(elements: Collection<Int>): Boolean = this.elements.containsAll(elements)

    override fun isEmpty(): Boolean = elements.isEmpty()

    fun obtainIntersect(other: CustomSetOfIntegers): CustomSetOfIntegers {
        val result = CustomSetOfIntegers()
        elements.forEach { element -> if (other.contains(element)) result.add(element) }
        return result
    }

    fun unify(other: CustomSetOfIntegers): CustomSetOfIntegers {
        val result = CustomSetOfIntegers(elements)
        other.forEach { element -> result.add(element) }
        return result
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder("CustomSetOfIntegers{")
        for (i in elements.indices) {
            stringBuilder.append(if (i != elements.lastIndex) "${elements[i]}, " else elements[i])
        }
        stringBuilder.append("}")
        return stringBuilder.toString()
    }
}