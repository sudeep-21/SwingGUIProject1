package engineManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class WindowManager {
    final int WIDTH = 500, HEIGHT = 500;

    JFrame frame = new JFrame("Ip Finder");

    JPanel panel = new JPanel();
    LayoutManager layout = new GroupLayout(panel);

    JTextField inputBox = new JTextField();
    JButton submitbtn = new JButton("Submit");
    JOptionPane output = new JOptionPane();
    JTextField link = new JTextField();

    public void editAction() {
        submitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = inputBox.getText();
                try {
                    InetAddress ia=InetAddress.getByName(url);
                    String ip=ia.getHostAddress();
                    JOptionPane.showMessageDialog(frame, ip, "The IP", JOptionPane.INFORMATION_MESSAGE);
                } catch (UnknownHostException e1) {
                    JOptionPane.showMessageDialog(frame, "Invalid Domain Name", "Error!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                link.setText("https://github.com/Sudeep-Sharma0-0");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                link.setText("\uF059 Github Page");
            }
        });
    }

    public void editComponents() {
        inputBox.setBounds(10, 20, WIDTH - 30, 50);
        inputBox.setFont(new Font("Monospace", Font.PLAIN, 25));
        inputBox.setToolTipText("Domain name");
        inputBox.setHorizontalAlignment(JTextField.CENTER);
        
        submitbtn.setBounds(WIDTH/2 - 75, inputBox.getY() + 80, 150, 50);
        submitbtn.setFont(new Font("Monospace", Font.PLAIN, 20));
        submitbtn.setForeground(new Color(0xFFFFFFF));
        submitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitbtn.setBackground(new Color(0x000000));

        link.setText("\uF059 Github Page");
        link.setFont(new Font("Monospace", Font.PLAIN, 22));
        link.setBounds(25, HEIGHT - 70, WIDTH-50, 30);
        link.setForeground(Color.WHITE);
        link.setBackground(null);
        link.setBorder(null);
        link.setCursor(new Cursor(Cursor.TEXT_CURSOR));
    }

    public void editLayout() {
        panel.add(inputBox);
        panel.add(submitbtn);
        panel.add(output);
        panel.add(link);
        panel.setLayout(layout);
        panel.setBackground(new Color(0x7a3ac9));
    }

    public void editFrame() {
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public WindowManager() {
        editAction();
        editComponents();
        editLayout();
        editFrame();
    }
}
