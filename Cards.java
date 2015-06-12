import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

 
class Cards extends JFrame
{
	ImageIcon[] icon = new ImageIcon[21];
	JButton[] btn = new JButton[20];
	Listener listen  = new Listener();
	Label lab = new Label();
	int[] random =  new int[20];
	int count = 0;
	int press1 = 23;
	int press2 = 23;
	int time = 0;
	boolean b;
    public static void main(String[] args){
	Cards frame = new Cards();
        frame.setTitle("Cards Game");
        frame.setSize(950,900);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);



	}

    public Cards(){
	for(int i = 0;i < 20;i++){
		b = true;
		while(b){
		b = false;
		random[i] = (int)(Math.random()*20+1);
		for(int j = 0;j < i;j++){
			if(random[i] == random[j]){
				b = true;
			}
		}
	}
  	
}
	setLayout(null);
 	
 
	icon[0] = new ImageIcon((getClass().getResource("card/" + "b1fv.png")));
 
	for(int i = 1;i <= 10;i++){
	    icon[i] = new ImageIcon((getClass().getResource("card/"+ i +".png")));
	    icon[10 + i] = new ImageIcon((getClass().getResource("card/"+ i +".png")));
	}
	
	for(int i = 0;i < 4;i++){
	    for(int j = 0;j < 5;j++)
	    {
	        btn[count] = new JButton(icon[0]);
		btn[count].setBounds(j * 180 + 20,i * 220 + 20,180,180);
	        add(btn[count]);
		btn[count].addMouseListener(listen);
		count++;
	    }
	}
        

 
        
}
 
 
class Listener extends MouseAdapter{
    @Override
    public void mouseClicked(MouseEvent e){
	if(press1 != 23){
	    if(e.getSource() == btn[press1]){	
		return;
	    }
}
	if(press2 != 23){
	    if(e.getSource() == btn[press2]){	
		return;
	    }
}

	for(int i = 0;i < 20;i++){
	    if(btn[i].isEnabled()){
		if(e.getSource() == btn[i]){
		    time ++; 
 		 
 
		    if(time > 2){	
		        btn[press1].setIcon(icon[0]);
		        btn[press2].setIcon(icon[0]);
 
			press1 = 23;
		        press2 = 23;
		        time = 1;
		    }	    
			btn[i].setIcon(icon[random[i]]);
 
			if(time == 1)
				press1 = i;
			if(time == 2)
				press2 = i;
		    }
 
		if(press1 != 23 && press2 != 23){
		    if(Math.abs(random[press1] - random[press2]) == 10){
		        btn[press1].setEnabled(false);
		        btn[press2].setEnabled(false);
 
			press1 = 23;
		        press2 = 23;
		        time = 0;
		
		    }
		}
		
	    }   
	}
    }
}
 
 }   
