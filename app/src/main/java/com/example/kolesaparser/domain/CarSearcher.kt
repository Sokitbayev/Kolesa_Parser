package com.example.kolesaparser.domain

import com.example.kolesaparser.domain.models.Car
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class CarSearcher {
    //URL
//document.getElementsByClass("row vw-item list-item yellow a-elem").get(0).childNodes().get(0).attributes().get("href")
    //Price
    //document.getElementsByClass("row vw-item list-item yellow a-elem").get(0).getElementsByClass("price")
    private val yellowElementClassName = "row vw-item list-item yellow a-elem"
    private val blueElementClassName = "row vw-item list-item blue a-elem"
    private val defaultElementClassName = "row vw-item list-item a-elem"

    private lateinit var document: Document

    fun getCarList(url: String): ArrayList<Car> {
        document = Jsoup.connect(url).get()
        val cars = arrayListOf<Car>()
        cars.addAll(getCarListByClassName(yellowElementClassName))
        cars.addAll(getCarListByClassName(blueElementClassName))
        cars.addAll(getCarListByClassName(defaultElementClassName))

        return cars
    }

    private fun getCarListByClassName(className: String): List<Car> {
        val cars = arrayListOf<Car>()
        document.getElementsByClass(className).forEach {
            val url = it.childNodes().get(0).attributes().get("href")
            val price = it.getElementsByClass(className).get(0)
                .getElementsByClass("price")
            cars.add(Car(url = url, price = formatPrice(price.text())))
        }

        return cars
    }

    private fun formatPrice(price: String): Int {
        return price.filter {
            it.isDigit()
        }.toInt()
    }
}