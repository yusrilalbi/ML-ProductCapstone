package com.example.fv_classification.data

import com.example.fv_classification.api.Api
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class linkPassing {
    val myJson = """
    {
      "apple": [
        "https://www.tokopedia.com/search?st=product&q=apple",
        "https://shopee.co.id/search?keyword=apple",
        "https://www.lazada.co.id/catalog/?q=apple&_keyori=ss&from=input"
      ],
      "banana": [
        "https://www.tokopedia.com/search?st=product&q=banana",
        "https://shopee.co.id/search?keyword=banana",
        "https://www.lazada.co.id/catalog/?q=banana&_keyori=ss&from=input"
      ],
      "beetroot": [
        "https://www.tokopedia.com/search?st=product&q=beetroot",
        "https://shopee.co.id/search?keyword=beetroot",
        "https://www.lazada.co.id/catalog/?q=beetroot&_keyori=ss&from=input"
      ],
      "bell_pepper": [
        "https://www.tokopedia.com/search?st=product&q=bell pepper",
        "https://shopee.co.id/search?keyword=bell pepper",
        "https://www.lazada.co.id/catalog/?q=bell pepper&_keyori=ss&from=input"
      ],
      "cabbage": [
        "https://www.tokopedia.com/search?st=product&q=cabbage",
        "https://shopee.co.id/search?keyword=cabbage",
        "https://www.lazada.co.id/catalog/?q=cabbage&_keyori=ss&from=input"
      ],
      "capsicum": [
        "https://www.tokopedia.com/search?st=product&q=capsicum",
        "https://shopee.co.id/search?keyword=capsicum",
        "https://www.lazada.co.id/catalog/?q=capsicum&_keyori=ss&from=input"
      ],
      "carrot": [
        "https://www.tokopedia.com/search?st=product&q=carrot",
        "https://shopee.co.id/search?keyword=carrot",
        "https://www.lazada.co.id/catalog/?q=carrot&_keyori=ss&from=input"
      ],
      "cauliflower": [
        "https://www.tokopedia.com/search?st=product&q=cauliflower",
        "https://shopee.co.id/search?keyword=cauliflower",
        "https://www.lazada.co.id/catalog/?q=cauliflower&_keyori=ss&from=input"
      ],
      "chilli_pepper": [
        "https://www.tokopedia.com/search?st=product&q=chilli pepper",
        "https://shopee.co.id/search?keyword=chilli pepper",
        "https://www.lazada.co.id/catalog/?q=chilli pepper&_keyori=ss&from=input"
      ],
      "corn": [
        "https://www.tokopedia.com/search?st=product&q=corn",
        "https://shopee.co.id/search?keyword=corn",
        "https://www.lazada.co.id/catalog/?q=corn&_keyori=ss&from=input"
      ],
      "cucumber": [
        "https://www.tokopedia.com/search?st=product&q=cucumber",
        "https://shopee.co.id/search?keyword=cucumber",
        "https://www.lazada.co.id/catalog/?q=cucumber&_keyori=ss&from=input"
      ],
      "eggplant": [
        "https://www.tokopedia.com/search?st=product&q=eggplant",
        "https://shopee.co.id/search?keyword=eggplant",
        "https://www.lazada.co.id/catalog/?q=eggplant&_keyori=ss&from=input"
      ],
      "garlic": [
        "https://www.tokopedia.com/search?st=product&q=garlic",
        "https://shopee.co.id/search?keyword=garlic",
        "https://www.lazada.co.id/catalog/?q=garlic&_keyori=ss&from=input"
      ],
      "ginger": [
        "https://www.tokopedia.com/search?st=product&q=ginger",
        "https://shopee.co.id/search?keyword=ginger",
        "https://www.lazada.co.id/catalog/?q=ginger&_keyori=ss&from=input"
      ],
      "grapes": [
        "https://www.tokopedia.com/search?st=product&q=grapes",
        "https://shopee.co.id/search?keyword=grapes",
        "https://www.lazada.co.id/catalog/?q=grapes&_keyori=ss&from=input"
      ],
      "jalepeno": [
        "https://www.tokopedia.com/search?st=product&q=jalepeno",
        "https://shopee.co.id/search?keyword=jalepeno",
        "https://www.lazada.co.id/catalog/?q=jalepeno&_keyori=ss&from=input"
      ],
      "kiwi": [
        "https://www.tokopedia.com/search?st=product&q=kiwi",
        "https://shopee.co.id/search?keyword=kiwi",
        "https://www.lazada.co.id/catalog/?q=kiwi&_keyori=ss&from=input"
      ],
      "lemon": [
        "https://www.tokopedia.com/search?st=product&q=lemon",
        "https://shopee.co.id/search?keyword=lemon",
        "https://www.lazada.co.id/catalog/?q=lemon&_keyori=ss&from=input"
      ],
      "lettuce": [
        "https://www.tokopedia.com/search?st=product&q=lettuce",
        "https://shopee.co.id/search?keyword=lettuce",
        "https://www.lazada.co.id/catalog/?q=lettuce&_keyori=ss&from=input"
      ],
      "mango": [
        "https://www.tokopedia.com/search?st=product&q=mango",
        "https://shopee.co.id/search?keyword=mango",
        "https://www.lazada.co.id/catalog/?q=mango&_keyori=ss&from=input"
      ],
      "onion": [
        "https://www.tokopedia.com/search?st=product&q=onion",
        "https://shopee.co.id/search?keyword=onion",
        "https://www.lazada.co.id/catalog/?q=onion&_keyori=ss&from=input"
      ],
      "orange": [
        "https://www.tokopedia.com/search?st=product&q=orange",
        "https://shopee.co.id/search?keyword=orange",
        "https://www.lazada.co.id/catalog/?q=orange&_keyori=ss&from=input"
      ],
      "paprika": [
        "https://www.tokopedia.com/search?st=product&q=paprika",
        "https://shopee.co.id/search?keyword=paprika",
        "https://www.lazada.co.id/catalog/?q=paprika&_keyori=ss&from=input"
      ],
      "pear": [
        "https://www.tokopedia.com/search?st=product&q=pear",
        "https://shopee.co.id/search?keyword=pear",
        "https://www.lazada.co.id/catalog/?q=pear&_keyori=ss&from=input"
      ],
      "peas": [
        "https://www.tokopedia.com/search?st=product&q=peas",
        "https://shopee.co.id/search?keyword=peas",
        "https://www.lazada.co.id/catalog/?q=peas&_keyori=ss&from=input"
      ],
      "pineapple": [
        "https://www.tokopedia.com/search?st=product&q=pineapple",
        "https://shopee.co.id/search?keyword=pineapple",
        "https://www.lazada.co.id/catalog/?q=pineapple&_keyori=ss&from=input"
      ],
      "pomegranate": [
        "https://www.tokopedia.com/search?st=product&q=pomegranate",
        "https://shopee.co.id/search?keyword=pomegranate",
        "https://www.lazada.co.id/catalog/?q=pomegranate&_keyori=ss&from=input"
      ],
      "potato": [
        "https://www.tokopedia.com/search?st=product&q=potato",
        "https://shopee.co.id/search?keyword=potato",
        "https://www.lazada.co.id/catalog/?q=potato&_keyori=ss&from=input"
      ],
      "raddish": [
        "https://www.tokopedia.com/search?st=product&q=raddish",
        "https://shopee.co.id/search?keyword=raddish",
        "https://www.lazada.co.id/catalog/?q=raddish&_keyori=ss&from=input"
      ],
      "soy_beans": [
        "https://www.tokopedia.com/search?st=product&q=soy beans",
        "https://shopee.co.id/search?keyword=soy beans",
        "https://www.lazada.co.id/catalog/?q=soy beans&_keyori=ss&from=input"
      ],
      "spinach": [
        "https://www.tokopedia.com/search?st=product&q=spinach",
        "https://shopee.co.id/search?keyword=spinach",
        "https://www.lazada.co.id/catalog/?q=spinach&_keyori=ss&from=input"
      ],
      "sweetcorn": [
        "https://www.tokopedia.com/search?st=product&q=sweetcorn",
        "https://shopee.co.id/search?keyword=sweetcorn",
        "https://www.lazada.co.id/catalog/?q=sweetcorn&_keyori=ss&from=input"
      ],
      "sweetpotato": [
        "https://www.tokopedia.com/search?st=product&q=sweetpotato",
        "https://shopee.co.id/search?keyword=sweetpotato",
        "https://www.lazada.co.id/catalog/?q=sweetpotato&_keyori=ss&from=input"
      ],
      "tomato": [
        "https://www.tokopedia.com/search?st=product&q=tomato",
        "https://shopee.co.id/search?keyword=tomato",
        "https://www.lazada.co.id/catalog/?q=tomato&_keyori=ss&from=input"
      ],
      "turnip": [
        "https://www.tokopedia.com/search?st=product&q=turnip",
        "https://shopee.co.id/search?keyword=turnip",
        "https://www.lazada.co.id/catalog/?q=turnip&_keyori=ss&from=input"
      ],
      "watermelon": [
        "https://www.tokopedia.com/search?st=product&q=watermelon",
        "https://shopee.co.id/search?keyword=watermelon",
        "https://www.lazada.co.id/catalog/?q=watermelon&_keyori=ss&from=input"
      ]
    }
    """.trimIndent()

    val gson = Gson()
    var mLink = gson.fromJson(myJson, linkData::class.java)


}