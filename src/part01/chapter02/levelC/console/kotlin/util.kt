package part01.chapter02.levelC.console.kotlin

fun readInt(): Int {
    val result = readLine()?.toInt()
    return result ?: readInt()
}

fun readDouble(): Double {
    val result = readLine()?.toDouble()
    return result ?: readDouble()
}