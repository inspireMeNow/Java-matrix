import java.awt.*;
import javax.swing.*;
public class FlowLayoutWindow extends JFrame{
public FlowLayoutWindow(){
  setLayout(new FlowLayout());
  JButton a=new JButton("相乘");
  add(a);
  a.addActionListener(new Cheng());
  JButton b=new JButton("相加");
  add(b);
  b.addActionListener(new Add());
  JButton c=new JButton("转置");
  add(c);
  c.addActionListener(new Transport());
  JButton d=new JButton("相减");
  add(d);
  d.addActionListener(new Jian());
  JButton e=new JButton("求逆");
  add(e);
  e.addActionListener(new Inverse());
}    
}
