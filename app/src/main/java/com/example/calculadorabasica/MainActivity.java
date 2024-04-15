package com.example.calculadorabasica;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView lblMensaje;
    EditText txtNum1;
    EditText txtNum2;
    Spinner spiOperaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        spiOperaciones = findViewById(R.id.spiOperaciones);
        lblMensaje = findViewById(R.id.lblMensaje);

        String[] opciones = {"Suma", "Resta", "Multiplicación", "División"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiOperaciones.setAdapter(adapter);

    }

    public void btn_CalculateOnClick(View view){
        if(txtNum1.getText().toString().isEmpty() || txtNum2.getText().toString().isEmpty()){
            return;
        }
        double num1 = Double.parseDouble(txtNum1.getText().toString());
        double num2 = Double.parseDouble(txtNum2.getText().toString());
        String operacionSeleccionada = spiOperaciones.getSelectedItem().toString();
        double resultado;

        switch (operacionSeleccionada) {
            case "Suma":
                resultado = num1 + num2;
                break;
            case "Resta":
                resultado = num1 - num2;
                break;
            case "Multiplicación":
                resultado = num1 * num2;
                break;
            case "División":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    lblMensaje.setText("Error: No se puede dividir por cero");
                    return;
                }
                break;
            default:
                resultado = 0;
                break;
        }

        String formatResultado =String.format("%.2f", resultado);

        lblMensaje.setText(operacionSeleccionada + ": " + formatResultado);
    }
}