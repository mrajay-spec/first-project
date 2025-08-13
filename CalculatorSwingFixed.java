import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class CalculatorSwingFixed extends JFrame implements ActionListener {
    private final JTextField display = new JTextField();
    private StringBuilder current = new StringBuilder();

    public CalculatorSwingFixed() {
        setTitle("CalculatorMadeBy-AJAY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(6, 6));

        display.setFont(new Font("SansSerif", Font.BOLD, 28));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 6, 6));
        String[] buttons = {
                "C", "(", ")", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "%", "="
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("SansSerif", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "C":
                current.setLength(0);
                display.setText("");
                break;
            case "=":
                try {
                    double result = evaluate(current.toString());
                    display.setText(removeTrailingZero(result));
                    current.setLength(0);
                    current.append(display.getText());
                } catch (Exception ex) {
                    display.setText("Error");
                    current.setLength(0);
                }
                break;
            default:
                current.append(cmd);
                display.setText(current.toString());
        }
    }

    private String removeTrailingZero(double num) {
        if (num == (long) num)
            return String.valueOf((long) num);
        else
            return String.valueOf(num);
    }

    // Basic expression evaluator (supports +, -, *, /, %, (), decimals)
    private double evaluate(String expression) {
        return evaluatePostfix(infixToPostfix(expression));
    }

    private String infixToPostfix(String expr) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = expr.toCharArray();
        boolean lastWasDigit = false;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c) || c == '.') {
                result.append(c);
                lastWasDigit = true;
            } else if (c == '(') {
                stack.push(c);
                if (lastWasDigit) result.append(' ');
                lastWasDigit = false;
            } else if (c == ')') {
                if (lastWasDigit) result.append(' ');
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty()) stack.pop();
                lastWasDigit = false;
            } else if (isOperator(c)) {
                if (lastWasDigit) result.append(' ');
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(c);
                lastWasDigit = false;
            }
        }
        if (lastWasDigit) result.append(' ');
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(' ');
        }
        return result.toString().trim();
    }

    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix.trim().split("\\s+")) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0)) && token.length() == 1) {
                if (stack.size() < 2) throw new IllegalArgumentException("Invalid Expression");
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                    case '%': stack.push(a % b); break;
                }
            }
        }
        if (stack.size() != 1) throw new IllegalArgumentException("Invalid Expression");
        return stack.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/':
            case '%': return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorSwingFixed::new);
    }
}