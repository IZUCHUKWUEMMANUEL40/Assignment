import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

    JFrame window = new JFrame("Physics");

    JTextField tfMass = new JTextField();
    JTextField tfAcceleration = new JTextField();
    JButton btnCalculate = new JButton("Calculate");

    void drawUI() {
        window.setLayout(new GridLayout(3, 1)); // Set layout before adding components

        window.add(new JLabel("Enter Mass:")); // Add a label for better UI
        window.add(tfMass);
        window.add(new JLabel("Acceleration:")); // Add a label for better UI
        window.add(tfAcceleration);
        window.add(btnCalculate);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Physics physics = new Physics();

                try {
                    float mass = Float.valueOf(tfMass.getText());
                    float acceleration = Float.valueOf(tfAcceleration.getText());

                    JOptionPane.showMessageDialog(null,
                            "Force: " + physics.calculateForce(mass, acceleration));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null,
                            "Enter only numeric values");
                    nfe.printStackTrace();
                } catch (Exception ex) { // This is to catch all kinds of exceptions
                    JOptionPane.showMessageDialog(null,
                            "Something strange has happened");
                }
            }
        });

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(200, 250);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI().drawUI();
            }
        });
    }
}