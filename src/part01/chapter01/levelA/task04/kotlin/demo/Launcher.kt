package part01.chapter01.levelA.task04.kotlin.demo

fun main(args: Array<String>) {

    if (args.isNotEmpty()) {
        val correctPassword = args[0]
        val enteredPassword = readLine()
        print(correctPassword == enteredPassword)
    }

}