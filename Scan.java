import javax.swing.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
public class Scan{
    public int [][]zhen1;
    public int [][]zhen2;
    public float [][]zhen3;
    public float [][]zhen4;
    public int []ju1;
    public int []ju2;
    public Scan(){
        String inputValue1=JOptionPane.showInputDialog("请输入第一个矩阵的行数列数");
        int a[]=new int[2];
        Convert(inputValue1,2, a);
        int b[]=new int[a[0]*a[1]];
        int c[][]=new int[a[0]][a[1]];
        //JOptionPane.showMessageDialog(null,Integer.toString(a[0]),"提示",JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null,Integer.toString(a[1]),"提示",JOptionPane.INFORMATION_MESSAGE);
        String input1=JOptionPane.showInputDialog("请输入第一个矩阵的每个元素");
        Convert(input1, a[0]*a[1],b);
        ConvertN(b, c, a[0], a[1]);
        //Printf(c,a[0],a[1]);
        String inputValue2=JOptionPane.showInputDialog("请输入第二个矩阵的行数列数");
        int d[]=new int[2];
        Convert(inputValue2,2, d);
        int f[]=new int[d[0]*d[1]];
        int g[][]=new int[d[0]][d[1]];
        String input2=JOptionPane.showInputDialog("请输入第二个矩阵的每个元素");
        Convert(input2, d[0]*d[1],f);
        ConvertN(f, g, d[0], d[1]);
        //Printf(g,d[0],d[1]);
        this.ju1=a;
        this.ju2=d;
        this.zhen1=c;
        this.zhen2=g;
    }
    public void ConvertN(int b[],int a[][],int m,int n){
        int j=0,k=0;
        for(int i=0;i<m*n;i++){
        a[j][k]=b[i];
        k++;
        if((i+1)%n==0){
            k=0;
            j++;
        }
    }
    }
    public void Printf(int b[][],int m,int n){
        FileWriter fw = null;
        try {
            fw = new FileWriter("Result.txt", true);
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                fw.write(+b[i][j]+" ");
                }
                fw.write("\n");
            }
                fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        JOptionPane.showMessageDialog(null,"文件写入完成！","提示",JOptionPane.INFORMATION_MESSAGE);
    }
    public void Printf(float b[][],int m,int n){
        FileWriter fw = null;
        DecimalFormat dec= new  DecimalFormat( "0.00" );
        try {
            fw = new FileWriter("Result.txt", true);
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                fw.write(dec.format(b[i][j])+" ");
                }
                fw.write("\n");
            }
                fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        JOptionPane.showMessageDialog(null,"文件写入完成！","提示",JOptionPane.INFORMATION_MESSAGE);
    }
    public void Show(String s,int a[][],int c[][],int b[][],int m,int n,int p,int q){
        Print window=new Print(s,a,c,b,m,n,p,q);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("运算结果");
        window.pack();
        window.setVisible(true);
        window.setSize(500,250);
    }
    public void Show(String s,float [][]e,float f[][],int a[][],int b[][],int c[][],int d[][],int m,int n,int p,int q){
        Print window=new Print(s,e,f,a,b,c,d,m,n,p,q);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("运算结果");
        window.pack();
        window.setVisible(true);
        window.setSize(500,300);
    }
    public void Convert(String inputValue,int n,int a[]){
        int j=0;
        String integer = "";
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < inputValue.length(); i++) {
            if (Character.isDigit(inputValue.charAt(i))) {
                integer += inputValue.charAt(i);
                if (i == inputValue.length() - 1) {
                    numList.add(Integer.parseInt(integer));
                }
            }else if (!integer.isEmpty()) {
                numList.add(Integer.parseInt(integer));
                integer = "";
            }
        }
        for (int each : numList) {
            a[j]=each;
            j++;
        }
    }
}