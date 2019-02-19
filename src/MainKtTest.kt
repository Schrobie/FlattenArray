import org.testng.Assert
import org.testng.annotations.Test

import org.testng.Assert.*

class MainKtTest {

    @Test
    fun testGivenCase() {
        val testData = arrayOf(arrayOf(1, 2, arrayOf("foo")),4, arrayOf(1, "hello"))
        val orderedList = traverseArr(testData)
        val array = arrayOfNulls<Any>(orderedList.size)
        orderedList.toArray(array)

        Assert.assertEquals(array, arrayOf(1,2,"foo", 4, 1, "hello"))
    }

    @Test
    fun testEmptyCase() {
        val testData = arrayOf("")
        val orderedList = traverseArr(testData)
        val array = arrayOfNulls<Any>(orderedList.size)
        orderedList.toArray(array)

        Assert.assertEquals(array, arrayOf(""))
    }

    @Test
    fun testReallyNestedCase() {
        val testData = arrayOf(arrayOf(arrayOf(arrayOf(arrayOf(arrayOf(1, 2, arrayOf("foo")),4, arrayOf(1, "hello"))))))
        val orderedList = traverseArr(testData)
        val array = arrayOfNulls<Any>(orderedList.size)
        orderedList.toArray(array)

        Assert.assertEquals(array, arrayOf(1,2,"foo", 4, 1, "hello"))
    }

    @Test
    fun testBooleanCase() {
        val testData = arrayOf(arrayOf(false, arrayOf(true)),true, arrayOf(false))
        val orderedList = traverseArr(testData)
        val array = arrayOfNulls<Any>(orderedList.size)
        orderedList.toArray(array)

        Assert.assertEquals(array, arrayOf(false, true, true, false))
    }

    @Test
    fun testIntCase() {
        val testData = arrayOf(arrayOf(1, 2, arrayOf(3, arrayOf(4,5,6))),7, arrayOf(8, arrayOf(9,10)))
        val orderedList = traverseArr(testData)
        val array = arrayOfNulls<Any>(orderedList.size)
        orderedList.toArray(array)

        Assert.assertEquals(array, arrayOf(1,2,3,4,5,6,7,8,9,10))
    }
}