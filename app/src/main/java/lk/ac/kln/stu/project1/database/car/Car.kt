package lk.ac.kln.stu.project1.database.car

import com.squareup.moshi.Json

data class Car(
    val id: Int,
    val car: String,
    @Json(name = "car_model") val carModel: String,
    @Json(name = "car_color") val carColor: String,
    @Json(name = "car_model_year") val carModelYear: String,
    @Json(name = "car_vin") val carVin: String,
    val price: String,
    val availability: Boolean
)
