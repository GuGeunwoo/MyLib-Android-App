package com.gunu.mylib

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gunu.mylib.data.remote.BookApi
import com.gunu.mylib.domain.Book
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.json.JSONObject
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception
import java.net.URL

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testHttpResponseParsing() {
        val response = "{\"error\":\"0\",\"total\":\"20\",\"books\":[{\"title\":\"TypeScript Notes for Professionals\",\"subtitle\":\"\",\"isbn13\":\"1001622115721\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001622115721.png\",\"url\":\"https://itbook.store/books/1001622115721\"},{\"title\":\"Python Notes for Professionals\",\"subtitle\":\"\",\"isbn13\":\"1001621860589\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001621860589.png\",\"url\":\"https://itbook.store/books/1001621860589\"},{\"title\":\"Seeing Theory\",\"subtitle\":\"A Visual Introduction to Probability and Statistics\",\"isbn13\":\"1001620981541\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001620981541.png\",\"url\":\"https://itbook.store/books/1001620981541\"},{\"title\":\"MySQL Notes for Professionals\",\"subtitle\":\"\",\"isbn13\":\"1001620983366\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001620983366.png\",\"url\":\"https://itbook.store/books/1001620983366\"},{\"title\":\"The Vue.js Handbook\",\"subtitle\":\"\",\"isbn13\":\"1001615902053\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001615902053.png\",\"url\":\"https://itbook.store/books/1001615902053\"},{\"title\":\"The Node.js Handbook\",\"subtitle\":\"\",\"isbn13\":\"1001614599609\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001614599609.png\",\"url\":\"https://itbook.store/books/1001614599609\"},{\"title\":\"Azure Tips and Tricks\",\"subtitle\":\"\",\"isbn13\":\"9781732704121\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/9781732704121.png\",\"url\":\"https://itbook.store/books/9781732704121\"},{\"title\":\"Learn Programming\",\"subtitle\":\"Your Guided Tour Through the Programming Jungle\",\"isbn13\":\"9781722834920\",\"price\":\"\$16.83\",\"image\":\"https://itbook.store/img/books/9781722834920.png\",\"url\":\"https://itbook.store/books/9781722834920\"},{\"title\":\"Graph Databases For Beginners\",\"subtitle\":\"The #1 Platform for Connected Data\",\"isbn13\":\"1001606307637\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001606307637.png\",\"url\":\"https://itbook.store/books/1001606307637\"},{\"title\":\"Elementary Algorithms\",\"subtitle\":\"\",\"isbn13\":\"1001606307729\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001606307729.png\",\"url\":\"https://itbook.store/books/1001606307729\"},{\"title\":\"Windows PowerShell Networking Guide\",\"subtitle\":\"\",\"isbn13\":\"1001606307964\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001606307964.png\",\"url\":\"https://itbook.store/books/1001606307964\"},{\"title\":\"Operating Systems: From 0 to 1\",\"subtitle\":\"\",\"isbn13\":\"1001606140658\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001606140658.png\",\"url\":\"https://itbook.store/books/1001606140658\"},{\"title\":\"Java Web Scraping Handbook\",\"subtitle\":\"Learn advanced Web Scraping techniques\",\"isbn13\":\"1001606140805\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001606140805.png\",\"url\":\"https://itbook.store/books/1001606140805\"},{\"title\":\"Coffee Break Python Slicing\",\"subtitle\":\"24 Workouts to Master Slicing in Python, Once and for All\",\"isbn13\":\"1001605784161\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001605784161.png\",\"url\":\"https://itbook.store/books/1001605784161\"},{\"title\":\"The Basics of User Experience Design\",\"subtitle\":\"\",\"isbn13\":\"1001601301730\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001601301730.png\",\"url\":\"https://itbook.store/books/1001601301730\"},{\"title\":\"3D Game Development with LWJGL 3\",\"subtitle\":\"Learn the main concepts involved in writing 3D games using the Lighweight Java Gaming Library\",\"isbn13\":\"1001601302020\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001601302020.png\",\"url\":\"https://itbook.store/books/1001601302020\"},{\"title\":\"DevOps: WTF?\",\"subtitle\":\"\",\"isbn13\":\"1001592565453\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001592565453.png\",\"url\":\"https://itbook.store/books/1001592565453\"},{\"title\":\"Full Speed Python\",\"subtitle\":\"\",\"isbn13\":\"1001592395975\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/1001592395975.png\",\"url\":\"https://itbook.store/books/1001592395975\"},{\"title\":\"How To Code in Python 3\",\"subtitle\":\"\",\"isbn13\":\"9780999773017\",\"price\":\"\$0.00\",\"image\":\"https://itbook.store/img/books/9780999773017.png\",\"url\":\"https://itbook.store/books/9780999773017\"},{\"title\":\"Operating System Concepts, 10th Edition\",\"subtitle\":\"\",\"isbn13\":\"9781119456339\",\"price\":\"\$90.08\",\"image\":\"https://itbook.store/img/books/9781119456339.png\",\"url\":\"https://itbook.store/books/9781119456339\"}]}"

        try {
            val jsonObject = JSONObject(response)
            val bookList = Gson().fromJson<List<Book>>(jsonObject.getJSONArray("books").toString(), object : TypeToken<List<Book>>(){}.type)

        } catch (e: Exception) {

        }

        Thread.sleep(3_000)
    }

    @Test
    fun retrofitTest() {
        runBlocking {
            try {
                val books = BookApi.retrofitService.getBooks()
                println(books)
            } catch (e: Exception) {
                fail()
            }
        }
    }
}