package com.proyecto.hellofx;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

    private float data = 0f; //creamos un dato con decimales, un float
    private String operation = ""; //creamos un String de la operacion

    private Button etiquetaResultado;
    @FXML
    private Button etiqueta7;
    @FXML
    private Button etiqueta8;
    @FXML
    private Button etiqueta9;
    @FXML
    private Button etiquetaSuma;
    @FXML
    private Button etiqueta4;
    @FXML
    private Button etiqueta5;
    @FXML
    private Button etiqueta6;
    @FXML
    private Button etiquetaResta;
    @FXML
    private Button etiqueta1;
    @FXML
    private Button etiqueta2;
    @FXML
    private Button etiqueta3;
    @FXML
    private Button etiquetaMultiplicacion;
    @FXML
    private Button etiqueta0;
    @FXML
    private Button etiquetaComa;
    @FXML
    private Button etiquetaDivision;
    @FXML
    private Button etiquetaBorrar;
    @FXML
    private Button etiquetaIgual;
    @FXML
    private Text operaciones; //es la caja de texto donde se muestra la operacion que estamos haciendo
    @FXML
    private TextField resultado; //la caja donde se ve el resultado

    @FXML
    private void alPulsar(ActionEvent event) {
        Button botonPulsado = (Button) event.getSource(); //ayuda a determinar qué componente disparó un evento.
        String numero = botonPulsado.getText(); //recogemos el texto del boton pulsado
        resultado.setText(resultado.getText() + numero);//En resultado, ponemos (el texto que hay escrito, lo concatena con el siguiente número)
        operaciones.setText((operaciones.getText() + numero));
    }

    public void recogerDatos(String operacion) { //creamos un metodo que recoge datos, y le pasamos un string con la operacion
        data = Float.parseFloat(resultado.getText()); //pasamos el String del resultado a float
        operation = operacion; //igualamos la operacion a operation
        operaciones.setText(operaciones.getText() + operation);//En la caja de operaciones, ponemos (la operacion que hay escrita, lo concatena con la siguiente operacion)
        resultado.setText("");//aqui pondremos la operacion que se le haya pasado

    }

    @FXML
    private void suma(ActionEvent event) {
        recogerDatos("+");
    }

    @FXML
    private void resta(ActionEvent event) {
        recogerDatos("-");
    }

    @FXML
    private void multiplicacion(ActionEvent event) {
        recogerDatos("*");
    }

    @FXML
    private void coma(ActionEvent event) {
        resultado.appendText(".");//el appendText(".") lo que hace es añadir texto al que ya hay, no lo sustituye.

    }

    @FXML
    private void division(ActionEvent event) {
        recogerDatos("/");
    }

    @FXML
    private void Borrar(ActionEvent event) {
        operaciones.setText(""); //asi borrará el recuadro de operaciones
        resultado.setText("");//asi borrará el recuadro de resultado
        operation = ""; //asi borra la variable de operation
    }

    @FXML
    private void igual(ActionEvent event) {
        Float secondOperand; //añadimos un segundo operador.

        try {
            secondOperand = Float.parseFloat(resultado.getText());//Convertimos el String del resultado en Float para poder hacer las operaciones.
            switch (operation) {  //paramos operation por un switch
                //EN FUNCION DE LO QUE LE PASEMOS, HARA UNA OPERACION:
                case "+": //Suma.
                    Float resulFloat = data + secondOperand; //suma los dos datos
                    resultado.setText(String.valueOf(resulFloat));//Pasamos el resultado de ambos datos a un String de nuevo.
                    break;
                case "-":
                    resulFloat = data - secondOperand; //resta los dos datos
                    resultado.setText(String.valueOf(resulFloat));//Pasamos el resultado de ambos datos a un String de nuevo.
                    break;
                case "*":
                    resulFloat = data * secondOperand; //multiplica los dos datos
                    resultado.setText(String.valueOf(resulFloat));//Pasamos el resultado de ambos datos a un String de nuevo.                    break;
                case "/":
                    resulFloat = 0f;
                    try {
                        resulFloat = data / secondOperand; //divide los dos datos
                    } catch (Exception e) {
                        resultado.setText("ERROR"); //en caso de que algo vaya mal, indicamos error
                    }
                    resultado.setText(String.valueOf(resulFloat));//Pasamos el resultado de ambos datos a un String de nuevo.
                    break;
                default:
                    throw new AssertionError();

            }
            operaciones.setText(""); //una vez pasado por el twitch, seteamos en operaciones.
        } catch (Exception e) {
             secondOperand = 0.0f; //si algo falla
        }

    }
}
