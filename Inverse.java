import java.awt.event.*;
import javax.swing.*;
public class Inverse implements ActionListener{
    public float[][] getConfactor(float[][] data, int h, int v) {
        int H = data.length;
        int V = data[0].length;
        float[][] newdata = new float[H-1][V-1];
        for(int i=0; i<newdata.length; i++) {
            if(i < h-1) {
                for(int j=0; j<newdata[i].length; j++) {
                    if(j < v-1) {
                        newdata[i][j] = data[i][j];
                    }else {
                        newdata[i][j] = data[i][j+1];
                    }
                }
            }else {
                for(int j=0; j<newdata[i].length; j++) {
                    if(j < v-1) {
                        newdata[i][j] = data[i+1][j];
                    }else {
                        newdata[i][j] = data[i+1][j+1];
                    }
                }
            }
        }
        return newdata;
    }
    public float getMartrixResult(float[][] data) {
        if(data.length == 2) {
            return data[0][0]*data[1][1] - data[0][1]*data[1][0];
        }
        float result = 0;
        int num = data.length;
        float[] nums = new float[num];
        for(int i=0; i<data.length; i++) {
            if(i%2 == 0) {
                nums[i] = data[0][i] * getMartrixResult(getConfactor(data, 1, i+1));
            }else {
                nums[i] = -data[0][i] * getMartrixResult(getConfactor(data, 1, i+1));
            }
        }
        for(int i=0; i<data.length; i++) {
            result += nums[i];
        }

//      System.out.println(result);
        return result;
    }
    public float[][] getReverseMartrix(float[][] data) {
        float[][] newdata = new float[data.length][data[0].length];
        float A = getMartrixResult(data);
        if(A==0){
            JOptionPane.showMessageDialog(null,"可逆矩阵不存在，程序终止!","警告",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
//      System.out.println(A);
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {
                if((i+j)%2 == 0) {
                    newdata[i][j] = getMartrixResult(getConfactor(data, i+1, j+1)) / A;
                }else {
                    newdata[i][j] = -getMartrixResult(getConfactor(data, i+1, j+1)) / A;
                }

            }
        }
        newdata = trans(newdata);
        return newdata;
    }
    private float[][] trans(float[][] newdata) {
        float[][] newdata2 = new float[newdata[0].length][newdata.length];
        for(int i=0; i<newdata.length; i++) 
            for(int j=0; j<newdata[0].length; j++) {
                newdata2[j][i] = newdata[i][j];
            }
        return newdata2;
    }
    public void actionPerformed(ActionEvent e){
        Scan sc=new Scan();
        int c[][]=new int[1][1];
        int ds[][]=new int[1][1];
        sc.zhen3=getReverseMartrix(Convert(sc.zhen1, sc.ju1[0], sc.ju1[1]));
        sc.zhen4=getReverseMartrix(Convert(sc.zhen2, sc.ju2[0], sc.ju2[1]));
        sc.Printf(sc.zhen3, sc.zhen3.length, sc.zhen3[0].length);
        sc.Printf(sc.zhen4, sc.zhen4.length, sc.zhen4[0].length);
        sc.Show("逆", sc.zhen3,sc.zhen4 ,sc.zhen1, sc.zhen2, c, ds, sc.ju1[0], sc.ju1[1], sc.ju2[0], sc.ju2[1]);
    }
    public float[][] Convert(int [][]d,int m,int n){
    float [][]data=new float[m][n];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            data[i][j]=(float)d[i][j];
        }
    }
    return data;
    }
}
