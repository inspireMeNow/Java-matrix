import java.awt.event.*;
import javax.swing.*;
public class Jian implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Scan sc=new Scan();
        if(sc.ju1[0]==sc.ju2[0]&&sc.ju1[1]==sc.ju2[1]){
            int c[][] = new int[sc.ju1[0]][sc.ju1[1]];
            int i,j;
            for(i = 0;i<sc.ju1[0] ;i++)
            {
                for(j = 0;j<sc.ju1[1];j++)
                {
                   c[i][j]=sc.zhen1[i][j]-sc.zhen2[i][j];
                }
            }
            sc.Printf(c, sc.zhen1.length, sc.zhen2[0].length);
            sc.Show("-",sc.zhen1,sc.zhen2,c, sc.zhen1.length, sc.zhen2[0].length,0,0);
        }
        else{
            JOptionPane.showMessageDialog(null,"输入错误，请重新输入","警告",JOptionPane.WARNING_MESSAGE);
        }
    }

}

