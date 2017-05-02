package gui;

import jade.gui.GuiEvent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui extends JFrame{
	GuiAgent agent;
	JButton bt;
	JTextArea ta;
	public Gui() {
		super("AgentGUI");
		agent=new GuiAgent();
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel p=new JPanel(new FlowLayout());
		bt=new JButton("Test");
		p.add(bt);
		add(p,BorderLayout.NORTH);
		ta=new JTextArea();
		add(ta,BorderLayout.CENTER);
		setVisible(true);
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiEvent ge=new GuiEvent(this, 1);
				agent.postGuiEvent(ge);		
			}
		});
		
	}
	
	public void showMessage(Object sender, String msg, boolean append){
		if(append)
			ta.append(msg);
		else
			ta.setText(msg);
	}
	
}
