package PaqIPabloMuliterno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Interface extends JFrame{
    private JTextField id;
    private JComboBox country;
    private JTextField weight;
    private JTextArea description;
    private JTextArea Plan;
    private JTextField CompanyOrigin;
    private JTextField CompanyDestination;
    private JCheckBox customs;
    private JButton pile;
    private JButton unpile;
    private JTextField columnNumber;
    private JButton showDescriptionButton;
    private JButton numberContainersButton;
    private JComboBox country2;
    private JPanel Panel;
    private JRadioButton Button1;
    private JRadioButton Button2;
    private JRadioButton Button3;
    private JLabel numberPerCountry;
    private int priority;
    public void Planupdate() {
        Plan.setText(Hub.getPlan());
    }

    public boolean Missing() {
        return id.getText().isEmpty() || weight.getText().isEmpty() || CompanyOrigin.getText().isEmpty() || description.getText().isEmpty() || CompanyDestination.getText().isEmpty() || (!Button1.isSelected() && !Button2.isSelected() && !Button3.isSelected());
    }

    public Interface() {
        setContentPane(Panel);
        setTitle("Port Management");
        setSize(1000, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        pile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Missing()) {
                    JOptionPane.showMessageDialog(null, "Error. There is one or more properties missing.");
                    return;
                }

                if (Button1.isSelected()) priority = 1;
                else if (Button2.isSelected()) priority = 2;
                else if (Button3.isSelected()) priority = 3;

                Hub.stack(new Container(Integer.parseInt(id.getText()), Integer.parseInt(weight.getText()), priority, Objects.requireNonNull(country.getSelectedItem()).toString(), description.getText(), CompanyOrigin.getText(), CompanyDestination.getText(), customs.isSelected()));

                Planupdate();
            }
        });

        unpile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (columnNumber.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error. Enter the column from where you want to remove the top container.");
                    return;
                }

                Hub.remove(Integer.parseInt(columnNumber.getText()) - 1);

                Planupdate();
            }
        });

        showDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Hub.Data(Integer.parseInt(id.getText())));
            }
        });

        numberContainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPerCountry.setText(String.valueOf(Hub.getNumberContainers(Objects.requireNonNull(country2.getSelectedItem()).toString())));
            }
        });
    }

    public static void main(String[] args) {
        Interface myFrame = new Interface();
    }
}