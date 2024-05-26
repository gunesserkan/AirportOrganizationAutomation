package View;

import Business.AccountManager;
import Core.Helper;
import Entity.Account;

import javax.swing.*;

/**
 * Author: gunes
 * Project: AirportOrganizationAutomation
 * E-mail: gunesserkan883@gmail.com
 * Creation Date: 4/2/2024 9:28 PM
 */
public class LoginUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField fld_user_name;
    private JButton btn_login;
    private JLabel lnl_user_name;
    private JLabel lbl_pwd;
    private JPasswordField fld_pwd;
    private JComboBox cmb_user_type;
    private JLabel lbl_account_type;
    private AccountManager accountManager;
    public LoginUI() {
        this.accountManager=new AccountManager();
        this.add(wrapper);
        setSize(600, 600);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Helper.PROJECT_TITLE);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_name)||Helper.isFieldEmpty(fld_pwd)||cmb_user_type.getSelectedIndex()==0){
                Helper.showMessage("Lütfen boş alanları doldurun!");
            }else {
                Account account=accountManager.findByLogin(fld_user_name.getText(),fld_pwd.getText(),cmb_user_type.getSelectedIndex());
                if(account==null){
                    Helper.showMessage("Kullanıcı Bulunamadı !");
                }else {
                    new DashBoard(account);
                    this.dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginUI loginUI = new LoginUI();
    }
}
