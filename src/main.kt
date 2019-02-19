import java.util.*

fun main(args: Array<String>) {
    val deepArray = arrayOf(arrayOf(1, 2, arrayOf("foo")),4, arrayOf(1, "hello"))
    val orderedList = traverseArr(deepArray)
    val array = arrayOfNulls<Any>(orderedList.size)
    orderedList.toArray(array)

    println(Arrays.toString(array))
}

fun traverseArr(array: Array<*>): ArrayList<Any>{
    val orderedList = arrayListOf<Any>()
    for (item in array){
        if (item is Array<*>){
             orderedList.addAll(if(orderedList.size == 0){0}else{orderedList.size}, traverseArr(item))
        } else {
            orderedList.add(item ?: continue)
        }
    }
    return orderedList
}