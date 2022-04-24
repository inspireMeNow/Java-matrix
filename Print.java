import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
public class Print extends JFrame{
    public Print(String str,int a[][],int c[][],int b[][],int m,int n,int p,int q){
    setLayout(new FlowLayout());
    //JTextArea tf=new JTextArea();
    JTextArea tf1=new JTextArea();
    JTextArea tf2=new JTextArea();
    JTextArea tf3=new JTextArea();
    add(new JLabel("运算结果为："));
    if(str=="*"){
    Display(tf1,a,m,n);
    Display(tf2,c,p,q);
    Display(tf3,b,m,q);
    }
    else{
    Display(tf1,a,m,n);
    Display(tf2,c,m,n);
    Display(tf3,b,m,n);
    }
    add(tf1);
    add(new JLabel(str));
    add(tf2);
    add(new JLabel("="));
    add(tf3);
    JButton button=new JButton("重新开始");
    add(button);
    button.addActionListener(new Cycle());
}
public Print(String str,float e[][],float f[][],int a[][],int b[][],int c[][],int d[][],int m,int n,int p,int q){
    setLayout(new FlowLayout());
    JTextArea tf1=new JTextArea();
    JTextArea tf2=new JTextArea();
    JTextArea tf3=new JTextArea();
    JTextArea tf4=new JTextArea();
    Display(tf1, a, m, n);
    Display(tf2, b, p, q);
    if(str=="转置"){
    Display(tf3, c, n, m);
    Display(tf4, d, q, p);
    }
    else{
    Display(tf3, e, m, n);
    Display(tf4, f, p, q);
    }
    add(new JLabel("矩阵一的原矩阵为："));
    add(tf1);
    add(new JLabel("矩阵一的"+str+"矩阵为："));
    add(tf3);
    add(new JLabel("矩阵二的原矩阵为："));
    add(tf2);
    add(new JLabel("矩阵二的"+str+"矩阵为："));
    add(tf4);
    JButton button=new JButton("重新开始");
    add(button);
    button.addActionListener(new Cycle());
}
public void Display(JTextArea tf,int b[][],int m,int n){
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
          tf.append(Integer.toString(b[i][j])+" ");
      }
      if(i!=m-1)
      tf.append("\n");
  }
}
public void Display(JTextArea tf,float b[][],int m,int n){
    DecimalFormat dec= new  DecimalFormat( "0.00" ); //构造方法的字符格式这里如果小数不足2位,会以0补足.
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
          tf.append(new String(dec.format(b[i][j])+" "));
      }
      if(i!=m-1)
      tf.append("\n");
  }
}    
} 