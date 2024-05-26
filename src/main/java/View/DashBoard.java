package View;

import Business.AccountManager;
import Core.Helper;
import Entity.Account;

import javax.swing.*;

public class DashBoard extends JFrame{
    private AccountManager accountManager;
    private Account account;
    private JPanel container;
    private JTabbedPane menu;
    private JPanel pnl_selected_account;
    private JTable table1;
    private JPanel pnl_actions_menu;
    private JLabel lbl_id;
    private JTextField fld_user_name;
    private JLabel lbl_user_name;
    private JTextField fld_password;
    private JLabel lbl_password;
    private JTextField fld_email;
    private JLabel lbl_email;
    private JTextField textField5;
    private JLabel fld_account_type;
    private JTextField textField6;
    private JLabel fld_created_date;
    private JTextField fld_id;
    private JButton btn_delete;
    private JButton güncelleButton;

    public DashBoard(Account account) {
        this.account=account;
        this.accountManager=new AccountManager();
        this.add(container);
        setSize(1200, 750);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Helper.PROJECT_TITLE);
        setVisible(true);
    }
}
