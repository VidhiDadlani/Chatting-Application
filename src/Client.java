import javax.swing.*;

import java.awt.event.*;

import java.awt.*;
import java.io.*;
import java.net.*;
public class Client extends JFrame implements ActionListener
{
	JPanel p1;
	JTextField t1 = new JTextField();
	JButton b1 = new JButton("Send");
	static JTextArea a1;
	
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	Client()
	{
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7 , 94 , 84));
		p1.setBounds(0 , 0 , 450 , 70);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30 , 30 , Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5 , 17 , 30 , 30);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent ae)
			{
				System.exit(0);
			}
		});
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
		Image i5 = i4.getImage().getScaledInstance(60 , 60 , Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5); 
		JLabel l2 = new JLabel(i6);
		l2.setBounds(40 , 8 , 60 , 60);
		p1.add(l2);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(30 , 30 , Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8); 
		JLabel l3 = new JLabel(i9);
		l3.setBounds(290 , 20 , 30 , 30);
		p1.add(l3);
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
		Image i11 = i10.getImage().getScaledInstance(35 , 30 , Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11); 
		JLabel l4 = new JLabel(i12);
		l4.setBounds(350 , 20 , 35 , 30);
		p1.add(l4);
		
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
		Image i14 = i13.getImage().getScaledInstance(13 , 25 , Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14); 
		JLabel l5 = new JLabel(i15);
		l5.setBounds(410 , 20 , 13 , 25);
		p1.add(l5);
		
		JLabel l6 = new JLabel("Client");
		l6.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		l6.setForeground(Color.WHITE);
		l6.setBounds(110 , 20 , 100 ,18);
		p1.add(l6);
		
		JLabel l7 = new JLabel("Active now");
		l7.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
		l7.setForeground(Color.WHITE);
		l7.setBounds(110 , 40 , 100 ,20);
		p1.add(l7);
		
		a1 = new JTextArea();
		a1.setBounds(5 , 75 , 440 , 570);
		a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);
		
		
		t1.setBounds(5 , 650 , 310 , 40);
		t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(t1);
		
		b1.setBounds(320 , 650 , 123 , 40);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF", Font.PLAIN,16));
		b1.setBackground(new Color(7 , 94, 84));
		b1.addActionListener(this);
		add(b1);
		
		setLayout(null);
		setSize(450 , 700);
		setLocation(1100 , 200);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			String out = t1.getText();
			a1.setText(a1.getText()+"\n\t\t\t"+out);
			dout.writeUTF(out);
			t1.setText("");
		}catch(Exception e){}
	}
	
	public static void main(String[] args) throws Exception
	{
		new Client().setVisible(true);
		
		try
		{
			s = new Socket("127.0.0.1",6001);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			String msginput = "";
			
			msginput = din.readUTF();
			a1.setText(a1.getText()+"\n"+msginput);
		}catch(Exception e){}
	}

}
