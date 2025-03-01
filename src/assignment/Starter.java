/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

// Dylan Denny TP074879

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


// TO WHOEVER ACCESS MY SOURCE CODE, BY READING THIS YOU AGREE TO NOT STEAL ANY OF MY SOURCE CODE.
// I HAVE GO THROUGH MY WAYS AND STAY UP 4AM JUST TO UNDERSTAND HOW JAVA PROGRAMMING WORKS, PLEASE DON'T QUESTION MY SANITY.
// HONESTLY WHOEVER READS MY CODE ENJOY HAVING BUNCH OF COMMENTS BECAUSE THIS IS HOW I CODE.
// BEST OF LUCK TO ALL MY FRIENDS THIS SEMESTER.
// CODE MAY BE REDUNDANT AND NOT FLEXIBLE FOR OTHER TEAMMATE CODE, HOWEVER MY CODE IS PROBABLY ONLY FLEXIBLE WITHIN MY RANGE.

public class Starter {
    public static void main(String[] args) {
        try {
            // Set the Nimbus look and feel (or you can choose another if you prefer)
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        
        Login WindowFrame = new Login();
        WindowFrame.setVisible(true);
    }
}
