import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JTextField miniField;
    private JButton percentButton, clearButton, clear_EButton, backButton, fractionButton, squaredButton, sqrtButton, divideButton, multiButton, subtractButton, addButton, equalButton, pointButton, veButton;
    private JButton memoryclear, memoryrecall, memoryplus, memorysub, memorystore, memoryop;
    private JButton[] functionButtons;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] memoryButtons;
    private JLabel textFieldContainer;


    UI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(335,510);
        frame.setResizable(false);
        frame.setBackground(Color.decode("#202020"));
        frame.setLayout(null);


        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font memoryFont = new Font("Arial", Font.PLAIN, 14);
        Font textFont = new Font("Arial", Font.BOLD, 48);
        Font miniFont = new Font("Arial", Font.PLAIN, 14);
        Dimension buttonSize = new Dimension(65,65);

        JPanel header = new JPanel();
        header.setBounds(0,0,335,75);
        header.setBackground(Color.decode("#202020"));


        textField = new JTextField();
        textField.setBounds(0,75,323,75);
        textField.setText("0");
        textField.setFont(textFont);
        textField.setForeground(Color.white);
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setBackground(Color.decode("#202020"));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        Border whiteline = BorderFactory.createLineBorder(Color.WHITE, 3, true);
        textField.setBorder(whiteline);


        miniField = new JTextField();
        miniField.setBounds(0,55,323,5);
        miniField.setFont(miniFont);
        miniField.setForeground(Color.decode("#A4A6AB"));
        miniField.setText("8 x 8 + 5");
        miniField.setEditable(false);
        miniField.setFocusable(false);
        miniField.setBackground(Color.decode("#202020"));
        miniField.setBorder(BorderFactory.createEmptyBorder());
        miniField.setHorizontalAlignment(JTextField.RIGHT);

        textFieldContainer = new JLabel();
        textFieldContainer.setBackground(Color.decode("#202020"));
        textFieldContainer.setLayout(new GridLayout(2,1));
        textFieldContainer.add(miniField);
        textFieldContainer.add(textField);
        textFieldContainer.setBounds(0,70,323, 80);

        JPanel mem_panel = new JPanel(new GridLayout(1, 6));
        mem_panel.setBounds(0, 150, 335, 25);
        mem_panel.setBackground(Color.decode("#202020"));

        JPanel panel = new JPanel(new GridLayout(7,5,3,3));
        panel.setBounds(0,175,335,370);
        panel.setBackground(Color.decode("#202020"));


        percentButton = new JButton("%");
        clear_EButton = new JButton("CE");
        clearButton = new JButton("C");
        backButton = new JButton("<-");
        fractionButton = new JButton("1/x");
        squaredButton = new JButton("x^2");
        sqrtButton = new JButton("1/x^-1");
        divideButton = new JButton("/");
        multiButton = new JButton("x");
        subtractButton = new JButton("-");
        addButton = new JButton("+");
        equalButton = new JButton("=");
        pointButton = new JButton(".");
        veButton = new JButton("+/-");

        memoryclear = new JButton("MC");
        memoryrecall = new JButton("MR");
        memoryplus = new JButton("M+");
        memorysub = new JButton("M-");
        memorystore = new JButton("MS");
        memoryop = new JButton("M v");

        functionButtons = new JButton[]{
                percentButton, clearButton, clear_EButton, backButton, fractionButton,
                squaredButton, sqrtButton, divideButton, multiButton, subtractButton,
                addButton, equalButton, pointButton, veButton
        };

        memoryButtons = new JButton[]{memoryclear, memoryrecall, memoryplus, memorysub, memorystore, memoryop};

        for (JButton button : functionButtons) {
            if (button.equals(veButton) || button.equals(pointButton)) {
                button.setBackground(Color.decode("#3B3B3B"));
                button.setForeground(Color.white);
            } else if (button.equals(equalButton)) {
                button.setBackground(Color.decode("#DB9EE5"));
            } else {
                button.setBackground(Color.decode("#323232"));
                button.setForeground(Color.white);
            }

            button.setFocusable(false);
            button.setFont(buttonFont);
            button.setPreferredSize(buttonSize);
            button.setBorder(BorderFactory.createEmptyBorder());
            button.addActionListener(this);
        }

        for (int i = 0 ; i <= 9 ; i++) {
            JButton numButton = new JButton(Integer.toString(i));
            numberButtons[i] = numButton;
            numButton.setFocusable(false);
            numButton.setFont(buttonFont);
            numButton.setPreferredSize(buttonSize);
            numButton.setBackground(Color.decode("#3B3B3B"));
            numButton.setForeground(Color.white);
            numButton.setBorder(BorderFactory.createEmptyBorder());
            numButton.addActionListener(this);
        }

        for (JButton button : memoryButtons) {
            button.setFocusable(false);
            button.setFont(memoryFont);
            button.setForeground(Color.white);
            button.setBackground(Color.decode("#202020"));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.addActionListener(this);
            mem_panel.add(button);
        }

        panel.add(percentButton);
        panel.add(clear_EButton);
        panel.add(clearButton);
        panel.add(backButton);
        panel.add(fractionButton);
        panel.add(squaredButton);
        panel.add(sqrtButton);
        panel.add(divideButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(veButton);
        panel.add(numberButtons[0]);
        panel.add(pointButton);
        panel.add(equalButton);

        frame.add(textFieldContainer);
        frame.add(header);
        frame.add(mem_panel);
        frame.add(panel);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UI Calc = new UI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setBorder(BorderFactory.createEmptyBorder());

        for (int i = 0 ; i <= 9 ; i++) {
            if (e.getSource() == numberButtons[i] && textField.getText().equals("0")) {
                textField.setText(String.valueOf(i));
            } else if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat((String.valueOf(i))));
            }
        }

        if (e.getSource() == pointButton && !textField.getText().contains(".")) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == clear_EButton) {
            textField.setText("0");
        }

        if (e.getSource() == clearButton) {
            textField.setText("0");
        }
        }

}
