package ru.FLDev.calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frame extends JFrame{

	private static final long serialVersionUID = -478426856938995L;
	
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	JButton plus, minus, equal, mult, pt, quot, symbol, backspace, clear;
	JLabel event, result, value1, value2;
	JPanel p1, p2, p3, p4, p5, p6;
	
	double a, b, res;
		
	handler hand = new handler();
	handler2 hand2 = new handler2();	
	
	public frame(String s){
		
		super(s);
		setLayout(new GridBagLayout());	
		
		Font font = new Font("COMIC SANS MS", Font.PLAIN, 10);
		
		b0 = new JButton("0"); 	b1 = new JButton("1"); 	b2 = new JButton("2"); 	
		b3 = new JButton("3");	b4 = new JButton("4"); 	b5 = new JButton("5"); 
		b6 = new JButton("6"); 	b7 = new JButton("7");	b8 = new JButton("8"); 	
		b9 = new JButton("9");
		
		plus = new JButton("+");   minus = new JButton("—");     equal = new JButton("="); 	
		mult = new JButton("x");   quot = new JButton("÷"); 	 pt = new JButton(".");
		symbol = new JButton("±"); backspace = new JButton("←"); clear = new JButton("Clear");
		
		event = new JLabel(""); result = new JLabel(""); value1 = new JLabel(""); value2 = new JLabel("");
		
		p1 = new JPanel(); p2 = new JPanel(); 
		p3 = new JPanel(); p4 = new JPanel(); 
		p5 = new JPanel(); p6 = new JPanel();
		
		add(p1, new GridBagConstraints(0, 0, 5, 3, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets (1, 1, 1, 1), 2, 2));
		add(p2, new GridBagConstraints(0, 4, 5, 4, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets (1, 1, 1, 2), 0, 0));
		
		p1.setLayout(new GridLayout(2, 1));
		p2.setLayout(new GridBagLayout());
		p4.setLayout(new GridLayout(1, 2, 10, 10));		
		
		p1.add(p3); p1.add(p4);
				
		p2.add(p5, new GridBagConstraints(0, 0, 3, 4, 1, 1,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets (5, 5, 5, 5), 0, 0)); 
		p2.add(p6, new GridBagConstraints(4, 0, 2, 3, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.VERTICAL,
				new Insets (5, 5, 5, 5), 0, 0));
		
		p5.setLayout(new GridLayout(4,3,7,7));
		
		p6.setLayout(new GridBagLayout());		
		
		p3.setBackground(new Color(236, 236, 236));
		p4.setBackground(new Color(208, 208, 208));
		p5.setBackground(new Color(208, 208, 208));
		p6.setBackground(new Color(208, 207, 218));
		
		p3.add(value1); p3.add(event); p3.add(value2); p3.add(result);		
	
		event.setForeground(Color.RED);
		result.setForeground(Color.BLUE);
		
		value1.setFont(font);
		event.setFont(font);
		value2.setFont(font);
		result.setFont(font);
		
		p4.add(clear); p4.add(backspace); 
		
		p5.add(b0); p5.add(b1); p5.add(b2); p5.add(b3); p5.add(b4);
		p5.add(b5); p5.add(b6); p5.add(b7); p5.add(b8); p5.add(b9);
		p5.add(pt); p5.add(symbol);
		
		p6.add(plus, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets (5, 5, 1, 3), 0, 0)); 
		p6.add(minus, new GridBagConstraints(1, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets (5, 5, 1, 7), 0, 0)); 
		p6.add(mult, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets (1, 5, 1, 3), 0, 0)); 
		p6.add(quot, new GridBagConstraints(1, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets (1, 5, 1, 7), 0, 0)); 
		p6.add(equal, new GridBagConstraints(0, 3, 2, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets (1, 10, 1, 10), 0, 0)); 
		
		b0.addActionListener(hand);
		b1.addActionListener(hand);
		b2.addActionListener(hand);
		b3.addActionListener(hand);
		b4.addActionListener(hand);
		b5.addActionListener(hand);
		b6.addActionListener(hand);
		b7.addActionListener(hand);
		b8.addActionListener(hand);
		b9.addActionListener(hand);
		plus.addActionListener(hand);
		minus.addActionListener(hand);
		mult.addActionListener(hand);
		quot.addActionListener(hand);
		backspace.addActionListener(hand);
		equal.addActionListener(hand2);
		clear.addActionListener(hand2);
		symbol.addActionListener(hand);
		pt.addActionListener(hand);
		
		
	}
	
	public class handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {			
			
			if(event.getText().equals("")){
				
				if(e.getSource() == b0) value1.setText(value1.getText()+"0");
				if(e.getSource() == b1) value1.setText(value1.getText()+"1");
				if(e.getSource() == b2) value1.setText(value1.getText()+"2");
				if(e.getSource() == b3) value1.setText(value1.getText()+"3");
				if(e.getSource() == b4) value1.setText(value1.getText()+"4");
				if(e.getSource() == b5) value1.setText(value1.getText()+"5");
				if(e.getSource() == b6) value1.setText(value1.getText()+"6");
				if(e.getSource() == b7) value1.setText(value1.getText()+"7");
				if(e.getSource() == b8) value1.setText(value1.getText()+"8");
				if(e.getSource() == b9) value1.setText(value1.getText()+"9");
				
				if(!(value1.getText().equals(""))){
					
					if(e.getSource() == pt){
						if(!(value1.getText().contains("."))){
						value1.setText(value1.getText()+".");
						}
					}
					
					if(e.getSource() == backspace){						
						value1.setText(value1.getText().substring(0,value1.getText().length()-1));					
					}
					
					if(e.getSource() == symbol){
						a = Double.parseDouble(value1.getText());
						a *= -1;
						value1.setText(Double.toString(a));
					}
				}
			}
			
			if(!(event.getText().equals(""))){
				
				if(result.getText().equals("")){
					
					if(e.getSource() == b0) value2.setText(value2.getText()+"0");
					if(e.getSource() == b1) value2.setText(value2.getText()+"1");
					if(e.getSource() == b2) value2.setText(value2.getText()+"2");
					if(e.getSource() == b3) value2.setText(value2.getText()+"3");
					if(e.getSource() == b4) value2.setText(value2.getText()+"4");
					if(e.getSource() == b5) value2.setText(value2.getText()+"5");
					if(e.getSource() == b6) value2.setText(value2.getText()+"6");
					if(e.getSource() == b7) value2.setText(value2.getText()+"7");
					if(e.getSource() == b8) value2.setText(value2.getText()+"8");
					if(e.getSource() == b9) value2.setText(value2.getText()+"9");				
				
					if(!(value2.getText().equals(""))){
						
						if(!(value2.getText().contains("."))){							
							if(e.getSource() == pt) value2.setText(value2.getText()+".");
						}
						
						if(e.getSource() == backspace){
							value2.setText(value2.getText().substring(0,value2.getText().length()-1));					
					}
						
						if(e.getSource() == symbol){
							a = Double.parseDouble(value2.getText());
							a *= -1;
							value2.setText(Double.toString(a));
					}
					
				}				
				
			}				
				
		}
			
			if(!(value1.getText().equals(""))){
				
				if(e.getSource() == plus){
					event.setText("");
					event.setText(event.getText()+"+");
				}
				if(e.getSource() == minus){
					event.setText("");
					event.setText(event.getText()+"—");
				}
				if(e.getSource() == mult){
					event.setText("");
					event.setText(event.getText()+"x");
				}
				if(e.getSource() == quot){
					event.setText("");
					event.setText(event.getText()+"÷");
				}
			
			}
			
		}
		
	}
	
	public class handler2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(!(value1.getText().equals(""))){
				if(!(value2.getText().equals(""))){
					if(e.getSource() == equal) {
				
						a = Double.parseDouble(value1.getText());
						b = Double.parseDouble(value2.getText());
				
						if("+".equals(event.getText())){					
							res = a + b;
							result.setText("=  " + res);
						}
				
						if("—".equals(event.getText())){					
							res = a - b;
							result.setText("=  " + res);
						}
				
						if("x".equals(event.getText())){					
							res = a * b;
							result.setText("=  " + res);
						}
				
						if("÷".equals(event.getText())){					
							res = a / b;
							result.setText("=  " + res);
						}
					}
				}
			}
			
			if(e.getSource() == clear){
				value1.setText("");
				event.setText("");
				value2.setText("");
				result.setText("");
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		frame frame = new frame("Калькулятор");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		

	}
	
}
