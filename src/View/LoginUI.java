package View;

import Helper.Config;
import Helper.Helper;

import javax.swing.*;

/**
 * Author: gunes
 * Project: AirportOrganizationAutomation
 * E-mail: gunesserkan883@gmail.com
 * Creation Date: 4/2/2024 9:28 PM
 */
public class LoginUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_welcome;
    private JTextField fld_user_name;
    private JTextField fld_password;
    private JButton btn_login;
    private JLabel lbl_user_name;
    private JLabel lbl_password;

    public LoginUI() {
        this.add(wrapper);
        setSize(600, 600);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginUI loginUI = new LoginUI();
    }
}
