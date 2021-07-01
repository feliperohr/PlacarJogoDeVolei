import ui.MainUI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MainUI ui = new MainUI();
        JPanel mainPanel = ui.getMainPanel();
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
