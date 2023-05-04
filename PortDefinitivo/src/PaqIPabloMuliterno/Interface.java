package PaqIPabloMuliterno;

//Pablo Sánchez-Muliterno Guerrero
/*continue generating the code in the container class from this question i asked you previously
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Interface extends JFrame {
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
    private JButton checkButton;
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
                    JOptionPane.showMessageDialog(null, "Error. There are properties missing.");
                    return;
                }

                if (Button1.isSelected()) priority = 1;
                else if (Button2.isSelected()) priority = 2;
                else if (Button3.isSelected()) priority = 3;
                try {
                    Hub.stack(new Container(Integer.parseInt(id.getText()), Integer.parseInt(weight.getText()), priority, Objects.requireNonNull(country.getSelectedItem()).toString(), description.getText(), CompanyOrigin.getText(), CompanyDestination.getText(), customs.isSelected()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
                Planupdate();
            }
        });

        unpile.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (columnNumber.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error. Enter the column you want to remove the container from.");
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

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get the weight and hub number from the text boxes
                int Weight = Integer.parseInt(weight.getText());
                int hNumber = Integer.parseInt(Plan.getText());


                String containerInfo = Hub.checkContainers(hNumber, Weight);


                JFrame containerFrame = new JFrame("Container Information");
                containerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                containerFrame.setSize(400, 300);


                JLabel containerLabel = new JLabel(containerInfo);
                containerLabel.setHorizontalAlignment(JLabel.CENTER);
                containerLabel.setVerticalAlignment(JLabel.TOP);
                containerFrame.getContentPane().add(containerLabel);


                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = 0;
                int y = screenSize.height - containerFrame.getHeight();
                containerFrame.setLocation(x, y);


                containerFrame.setVisible(true);
            }
        });

    }


    public static void main(String[] args) {
        Interface myFrame = new Interface();
    }
}