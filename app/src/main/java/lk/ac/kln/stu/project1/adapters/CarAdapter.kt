package lk.ac.kln.stu.project1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lk.ac.kln.stu.project1.R
import lk.ac.kln.stu.project1.database.car.Car

class CarAdapter(
    private val cars: List<Car>
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textviewCar: TextView = view.findViewById(R.id.textview_car)
        val textviewCarModel: TextView = view.findViewById(R.id.textview_car_model)
        val textviewCarColor: TextView = view.findViewById(R.id.textview_car_color)
        val textviewCarModelYear: TextView = view.findViewById(R.id.textview_car_model_year)
        val textviewCarVin: TextView = view.findViewById(R.id.textview_car_vin)
        val textviewPrice: TextView = view.findViewById(R.id.textview_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val adapter = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_car, parent, false)

        return CarViewHolder(adapter)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]

        holder.textviewCar.text = car.car
        holder.textviewCarModel.text = car.carModel
        holder.textviewCarColor.text = car.carColor
        holder.textviewCarModelYear.text = car.carModelYear
        holder.textviewCarVin.text = car.carVin
        holder.textviewPrice.text = car.price
    }

    override fun getItemCount() = cars.size
}