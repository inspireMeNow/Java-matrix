import java.awt.event.*;
import javax.swing.*;
public class Cheng implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Scan sc=new Scan();
        if(sc.ju1[0]==sc.ju2[1]){
            int c[][] = new int[sc.zhen1.length][sc.zhen2[0].length];
            int x,i,j;
            for(i = 0;i<sc.zhen1.length ;i++)
            {
                for(j = 0;j<sc.zhen2[0].length;j++)
                {
                    int temp = 0;
                    for(x = 0;x<sc.zhen2.length;x++)
                    {
                        temp+=sc.zhen1[i][x]*sc.zhen2[x][j];
                        
                    }
                    c[i][j] = temp;
                }
            }
            sc.Printf(c, sc.zhen1.length, sc.zhen2[0].length);
            sc.Show("*",sc.zhen1,sc.zhen2,c, sc.ju1[0], sc.ju1[1],sc.ju2[0],sc.ju2[1]);
        }
        else{
            JOptionPane.showMessageDialog(null,"输入错误，请重新输入","警告",JOptionPane.WARNING_MESSAGE);
        }
    }
}

