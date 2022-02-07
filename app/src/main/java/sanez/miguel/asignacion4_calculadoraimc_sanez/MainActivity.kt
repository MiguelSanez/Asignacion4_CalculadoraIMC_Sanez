package sanez.miguel.asignacion4_calculadoraimc_sanez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var valorImc: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight: EditText = findViewById(R.id.weight)
        var height: EditText = findViewById(R.id.height)
        var imc: TextView = findViewById(R.id.imc)
        var range: TextView = findViewById(R.id.range)
        val calcular: Button = findViewById(R.id.calcular)

        calcular.setOnClickListener {
            imc.setText(calcularIMC().toString())
            if(valorImc < 18.5){
                range.setText("Bajo peso")
                range.setBackgroundResource(R.color.colorGreenish)
            }else if (valorImc in 18.5..24.9){
                range.setText("Normal")
                range.setBackgroundResource(R.color.colorGreen)
            }else if (valorImc in 25.0..29.9){
                range.setText("Sobrepeso")
                range.setBackgroundResource(R.color.colorYellow)
            } else if (valorImc in 30.0..34.9){
                range.setText("Obesidad grado 1")
                range.setBackgroundResource(R.color.colorOrange)
            }else if (valorImc in 35.0..39.9){
                range.setText("Obesidad grado 2")
                range.setBackgroundResource(R.color.colorRed)
            }else if (valorImc >= 40.0){
                range.setText("Obesidad grado 3")
                range.setBackgroundResource(R.color.colorBrown)
            }
        }

    }

    fun calcularIMC(): Float{
        var weight: EditText = findViewById(R.id.weight)
        var height: EditText = findViewById(R.id.height)
        valorImc = (weight.text.toString().toFloat()) / (height.text.toString().toFloat() * height.text.toString().toFloat())
        return valorImc
    }
}