package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calcButton = findViewById(R.id.btnCalcular);
        final TextView apresentarResult = findViewById(R.id.text_resultado);
        final TextView imcResultado = findViewById(R.id.resultado);
        final EditText i_peso = findViewById(R.id.i_peso);
        final EditText i_altura = findViewById(R.id.i_altura);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implement call to calcular()
                double altura = Double.parseDouble(i_altura.getText().toString());
                double peso = Double.parseDouble(i_peso.getText().toString());

                Log.d("CalculadoraIMC","O peso é " + peso);
                Log.d("CalculadoraIMC", "A altura é " + altura);

                double imc = CalcularIMC(altura,peso);
                Log.d("CalculadoraIMC", "O IMC calculado é: " + imc);

                apresentarResult.setText(R.string.resultado);
                String imcToText = String.valueOf(imc);
                imcResultado.setText(imcToText);

                apresentarResult.setVisibility(View.VISIBLE);
                imcResultado.setVisibility(View.VISIBLE);



            }
        });

    }

    private static double CalcularIMC(double altura, double peso){
        Log.d("CalcuadoraIMC", "Entrou na calculadora!");
        double imc = peso/(Math.pow(altura,2));
        Log.d("CalculadoraIMC", "Calculou!");
        return imc;

    }
}
