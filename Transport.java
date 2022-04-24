import java.awt.event.*;
public class Transport implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Scan sc=new Scan();
            float g[][]=new float[1][1];
            float f[][]=new float[1][1];
            int c[][] = new int[sc.ju1[1]][sc.ju1[0]];
            int d[][] = new int[sc.ju2[1]][sc.ju2[0]];
            Trans(sc.zhen1, c, sc.ju1[0], sc.ju1[1]);
            Trans(sc.zhen2, d, sc.ju2[0], sc.ju2[1]);
            sc.Printf(c, sc.zhen1[0].length, sc.zhen1.length);
            sc.Printf(d, sc.zhen2[0].length, sc.zhen2.length);
            sc.Show("转置",g,f,sc.zhen1, sc.zhen2, c, d, sc.ju1[0], sc.ju1[1], sc.ju2[0], sc.ju2[1]);
        }
        public void Trans(int c[][],int d[][],int a,int b){
            for(int i = 0;i<a ;i++)
            {
                for(int j = 0;j<b;j++)
                {
                   d[j][i]=c[i][j];
                }
            }
        }
    }
