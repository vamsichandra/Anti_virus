//*************************************** $E-Security$ *****************************************************************************
//
//
//								Author-Pravin H. Rane
//********************************************************************************************************************************





import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.applet.AppletContext.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import  java.awt.image.ImageConsumer ;
import java.awt.image.ImageObserver; 
import   java.applet.AudioClip;
import javax.swing.filechooser.FileView;
import java.net.*;
import javax.swing.plaf.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.applet.AppletContext.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import  java.awt.image.ImageConsumer ;
import java.awt.image.ImageObserver; 
import   java.applet.AudioClip;
import javax.swing.filechooser.FileView;
import java.net.*;
import java.util.zip.*; 

class driveDetail extends JWindow
{
JLabel j1,j2,j3,j4,j5;
JFrame jf;
	
JPanel p1,p2,p3,p4;
String drive="";
JButton b1,b2;
JComboBox c1;
Container cp;

	driveDetail(String str)
	{
	drive=str;
	cp=getContentPane();
	cp.setLayout(null);

	
	Color c=new Color(117,125,166);
	p1=new JPanel(null,true);
	p1.setBackground(c);		 
	
	JLabel ll=new JLabel(new ImageIcon("Image/driveIcon.jpg"));
	ll.setBounds(10,0,40,40);
	p1.add(ll);

	j1=new JLabel("Drive "+drive);
	j1.setForeground(Color.white);
	j1.setFont(new Font("Arial",Font.BOLD,16));
	j1.setBackground(c);
	j1.setBounds(50,0,400,40);
	p1.add(j1);


	p2=new JPanel(null,true);
	p2.setBackground(Color.white);
	
	File f=new File(drive+"");
	j2=new JLabel("Volume Name          : "+f.getName());
	j2.setFont(new Font("Arial",Font.BOLD,14));
	j2.setBounds(20,10,150,30);
	p2.add(j2);

	c1=new JComboBox();
	c1.setBounds(180,10,150,30);
	p2.add(c1);
         File f2=new File("c:/'.'");
   
    	 File strRoot[]=f2.listRoots();
     	 for(int k=0;k<strRoot.length;k++)
	 {
	    	
	    c1.addItem(strRoot[k]+"");
	    c1.setSelectedItem(strRoot[k]+"");
	 }	
	
	long total=f.getTotalSpace();
	long total1=((total/1024)/1024);
	j2=new JLabel("Volume Total Space  : "+total1+" Mb  ("+( (double) total1/1024)+" GB)");
	j2.setFont(new Font("Arial",Font.BOLD,14));
	j2.setBounds(20,40,360,30);
	p2.add(j2);

	long use=f.getUsableSpace();
	long use1=(use/1024)/1024;
	j3=new JLabel("Volume Free Space : "+use1+" Mb   ("+( (double) use1/1024)+" GB)");
	j3.setFont(new Font("Arial",Font.BOLD,14));
	j3.setBounds(20,70,360,30);
	p2.add(j3);

	long free=total-use;
	free=(free/1024)/1024;
	j4=new JLabel("Volume Used Space  : "+free+" Mb   ("+( (double) free/1024)+" GB)");
	j4.setFont(new Font("Arial",Font.BOLD,14));
	j4.setBounds(20,100,360,30);
	p2.add(j4);


	b1=new JButton("Scan Now");
	b1.setBounds(40,150,100,30);
	p2.add(b1);	

	b2=new JButton("Don't Scan");
	b2.setBounds(170,150,100,30);
	p2.add(b2);

	p2.setBounds(05,40,390,205);
	p1.add(p2);
	
	p1.setBounds(0,0,400,235);
	//p1.setVisible(true);
	//p1.setSize(395,210);
	//p1.setLocation(150,100);
	cp.add(p1);

	b2.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent d)
	{
		setVisible(false);
	}
	});
	
	b1.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent d)
	{
		try{
		FileWriter fr;
		fr=new FileWriter("drive.cab");
		fr.write( (String)c1.getSelectedItem()+"" );
		fr.close();
		
		fr=new FileWriter("Command.cab");
		fr.write(3+"");
		fr.close();
		}catch(Exception df){}

		setVisible(false);
	}
	});	

	c1.addItemListener(new ItemListener()
	{
	public void itemStateChanged(ItemEvent e)
	{
		try{
		String str=(String)c1.getSelectedItem();
		File fg=new File(str+"");
		
		long total=fg.getTotalSpace();
		long total1=((total/1024)/1024);
		j2.setText("Volume Total Space  : "+total1+" Mb  ("+( (double) total1/1024)+" GB)");
		 

		long use=fg.getUsableSpace();
		long use1=(use/1024)/1024;
		j3.setText("Volume  Free Space : "+use1+" Mb   ("+( (double) use1/1024)+" GB)");

		
		long free=total-use;
		free=(free/1024)/1024;
		j4.setText("Volume Used Space  : "+free+" Mb   ("+( (double) free/1024)+" GB)");

		j1.setText("Drive "+str);

		}catch(Exception de){ System.out.println(de); }

	}

	
	});
	

}
}	  