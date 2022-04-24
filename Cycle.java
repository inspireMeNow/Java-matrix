import java.awt.event.*;
import javax.swing.*;
public class Cycle implements ActionListener{
    public void actionPerformed(ActionEvent e){
        FlowLayoutWindow window=new FlowLayoutWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("矩阵运算");
        window.pack();
        window.setVisible(true);
        window.setSize(500,250);
    }

}