package tuvan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TestProgram {
	public static final int MAX_OUTPUT = 2;

	public static void main(String[] args) {
            try {
                String line;
                line = JOptionPane.showInputDialog(null, "nhap gia thiet ban dau", "Input", JOptionPane.QUESTION_MESSAGE);
                ModulSuyDien.napGiaThiet("rule.txt", line);
                ModulSuyDien obj1 = new ModulSuyDien();
                obj1.displayInfor();
                System.out.println("\npress any key to continue___  ");
                Scanner s = new Scanner(System.in);
                String press = s.nextLine();

                Excute subObj1 = new Excute();
                ArrayList<String> result = subObj1.excuteBackTract(0);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                String temp = "                                        ";
                ModulSuyDien.napGiaThiet("rule.txt", temp);
            }
	}

}
