package com.shf.demo9;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class TestSum{
    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum);
    }
}

public class Sum extends JFrame implements ActionListener {
    JButton plus;
    JButton subtract;
    JButton multiply;
    JButton divide;
    JTextField TextFieldOne;
    JTextField TextFieldTwo;
    JTextField TextFieldThree;
    JLabel label;

    public Sum() {
        init();
        setVisible(true);
        setResizable(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        setLayout(new FlowLayout());
        setSize(500, 320);
        setTitle("加减乘除计算器");
        plus = new JButton("加Plus");
        subtract = new JButton("减Subtract");
        multiply = new JButton("乘Multiple");
        divide = new JButton("除Divide");

        TextFieldOne = new JTextField("请输入第一个数字",10);
        TextFieldOne.setHorizontalAlignment(JTextField.CENTER);

        TextFieldTwo = new JTextField("请输入第二个数字",10);
        TextFieldTwo.setHorizontalAlignment(JTextField.CENTER);

        TextFieldThree = new JTextField("计算结果(点击下方任一按钮)",20);
        TextFieldThree.setHorizontalAlignment(JTextField.CENTER);

        label = new JLabel(" ", JLabel.CENTER);
        label.setBackground(Color.green);

        add(TextFieldOne);
        add(label);
        add(TextFieldTwo);
        add(TextFieldThree);
        add(plus);
        add(subtract);
        add(multiply);
        add(divide);
        setBackground(Color.gray);

//        添加动作事件监听
        plus.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double n;
        if (e.getSource() == plus) {
            double n1, n2;
            try {
                n1 = Double.parseDouble(TextFieldOne.getText());
                n2 = Double.parseDouble(TextFieldTwo.getText());
                n = n1 + n2;
                TextFieldThree.setText(String.valueOf(n));
                label.setText("+");
            } catch (NumberFormatException ee) {
                TextFieldThree.setText("请输入数字字符");
            }
        } else if (e.getSource() == subtract) {
            double n1, n2;
            try {
                n1 = Double.parseDouble(TextFieldOne.getText());
                n2 = Double.parseDouble(TextFieldTwo.getText());
                n = n1 - n2;
                TextFieldThree.setText(String.valueOf(n));
                label.setText("-");
            } catch (NumberFormatException ee) {
                TextFieldThree.setText("请输入数字字符");
            }
        } else if (e.getSource() == multiply) {
            double n1, n2;
            try {
                n1 = Double.parseDouble(TextFieldOne.getText());
                n2 = Double.parseDouble(TextFieldTwo.getText());
                n = n1 * n2;
                TextFieldThree.setText(String.valueOf(n));
                label.setText("*");
            } catch (NumberFormatException ee) {
                TextFieldThree.setText("请输入数字字符");
            }
        } else if (e.getSource() == divide) {
            double n1, n2;
            try {
                n1 = Double.parseDouble(TextFieldOne.getText());
                n2 = Double.parseDouble(TextFieldTwo.getText());
                n = n1 / n2;
                TextFieldThree.setText(String.valueOf(n));
                label.setText("/");
            } catch (NumberFormatException ee) {
                TextFieldThree.setText("请输入数字字符");
            }
        }
        validate();
    }
}