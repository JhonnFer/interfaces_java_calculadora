import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JTextField numero1;
    private JTextField numero2;
    private JLabel resultado;

    public Calculadora() {
        JFrame frame = new JFrame("Calculadora Básica");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        numero1 = new JTextField();
        numero1.setBounds(50, 20, 100, 30);
        frame.add(numero1);

        numero2 = new JTextField();
        numero2.setBounds(50, 60, 100, 30);
        frame.add(numero2);

        JButton suma = new JButton("+");
        suma.setBounds(160, 20, 50, 30);
        suma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("+");
            }
        });
        frame.add(suma);

        JButton resta = new JButton("-");
        resta.setBounds(160, 60, 50, 30);
        resta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("-");
            }
        });
        frame.add(resta);

        JButton multiplicacion = new JButton("*");
        multiplicacion.setBounds(220, 20, 50, 30);
        multiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("*");
            }
        });
        frame.add(multiplicacion);

        JButton division = new JButton("/");
        division.setBounds(220, 60, 50, 30);
        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("/");
            }
        });
        frame.add(division);

        resultado = new JLabel("Resultado:");
        resultado.setBounds(50, 100, 200, 30);
        frame.add(resultado);

        frame.setVisible(true);
    }

    private void realizarOperacion(String operacion) {
        try {
            double num1 = Double.parseDouble(numero1.getText());
            double num2 = Double.parseDouble(numero2.getText());
            double res = 0;
            switch (operacion) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        res = num1 / num2;
                    } else {
                        resultado.setText("Error: División por cero");
                        return;
                    }
                    break;
            }
            resultado.setText("Resultado: " + res);
        } catch (NumberFormatException e) {
            resultado.setText("Error: Entrada inválida");
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}