class Stack<T>() {
    private val stack: MutableList<T> = mutableListOf()

    fun push(item: T) {
        stack.add(0, item)
    }

    fun pop(): T? {

        return stack.removeFirstOrNull()
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()

//fun iterator(cargo: Stack<T>): Iterator<T>{
//    return cargo.iterator()



}
    fun info(): Int {
        println("magazine include of: ${stack.size}")
        println(stack.toString())
        return stack.size
    }


}