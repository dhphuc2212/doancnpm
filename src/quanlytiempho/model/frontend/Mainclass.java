/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.frontend;

/**
 *
 * @author Acer
 */
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import quanlytiempho.model.frontend.LoginForm;
public class Mainclass {
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
        
        new LoginForm().setVisible(true);
    }
}
