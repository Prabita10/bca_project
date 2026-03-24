package org.swsc.com.view;

import org.swsc.com.DTO.Student;
import org.swsc.com.model.StudentModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FormWithTable {
    public void studentForm() {

        JFrame f;

        JLabel lblname, lblemail, lblgender, lblcourse, lblskills, lbladdress;
        JTextField txtname, txtemail, txtaddress;
        JRadioButton male, female;
        ButtonGroup bg;
        JButton submit, reset;
        JComboBox<String> course;
        JCheckBox java, python, web;

        JTable table;
        DefaultTableModel defaultTableModel;

        f = new JFrame("Student Form with Table");

        f.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));

        lblname = new JLabel("Student Name");
        txtname = new JTextField();

        lblemail = new JLabel("Email");
        txtemail = new JTextField();

        lblgender = new JLabel("Gender");
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        genderPanel.add(male);
        genderPanel.add(female);

        lblcourse = new JLabel("Course");
        String faculty[] = {"BCA", "BBA", "BSW"};
        course = new JComboBox<>(faculty);

        lblskills = new JLabel("Skills");
        JPanel skillPanel = new JPanel();
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        web = new JCheckBox("Web");

        skillPanel.add(java);
        skillPanel.add(python);
        skillPanel.add(web);

        lbladdress = new JLabel("Address");
        txtaddress = new JTextField();

        submit = new JButton("Submit");
        reset = new JButton("Reset");

        // ➕ Add components to form panel
        formPanel.add(lblname);
        formPanel.add(txtname);

        formPanel.add(lblemail);
        formPanel.add(txtemail);

        formPanel.add(lblgender);
        formPanel.add(genderPanel);

        formPanel.add(lblcourse);
        formPanel.add(course);

        formPanel.add(lblskills);
        formPanel.add(skillPanel);

        formPanel.add(lbladdress);
        formPanel.add(txtaddress);

        formPanel.add(submit);
        formPanel.add(reset);

        String[] columns = {"Name", "Email", "Gender", "Course", "Address"};
        defaultTableModel = new DefaultTableModel(columns, 0);
        table = new JTable(defaultTableModel);

        JScrollPane tableScroll = new JScrollPane(table);

        f.add(formPanel, BorderLayout.NORTH);
        f.add(tableScroll, BorderLayout.CENTER);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = txtname.getText();
                String email = txtemail.getText();
                String gender = male.isSelected() ? "Male" : "Female";
                String courseVal = course.getSelectedItem().toString();
                String address = txtaddress.getText();
                Student student = new Student();
                student.setName(name);
                student.setGender(gender);
                student.setAddress(address);
                StudentModel  studentModel = new StudentModel();
                studentModel.insert(student);

                defaultTableModel.addRow(new Object[]{
                        name, email, gender, courseVal, address
                });

                JOptionPane.showMessageDialog(f, "Inserted into table!");
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtname.setText("");
                txtemail.setText("");
                txtaddress.setText("");
                bg.clearSelection();
            }
        });

        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}