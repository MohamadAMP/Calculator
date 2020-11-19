package cmps252.hw05.calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculator extends JFrame {

	private JFrame GUI;
	protected JTextField textField;
	private JButton MemoryClear; 
	private JButton MemoryRecall;
	private JButton MemoryStore;
	private JButton MemoryMinus;
	private JButton MemoryPlus;
	private JButton Delete;
	private JButton Clear;
	private JButton Parenthesis1;
	private JButton Parenthesis2;
	private JButton Equal;
	private JButton One;
	private JButton Two;
	private JButton Three;
	private JButton Four;
	private JButton Five;
	private JButton Six;
	private JButton Seven;
	private JButton Eight;
	private JButton Nine;
	private JButton Zero;
	private JButton Divide;
	private JButton Multiply;
	private JButton Plus;
	private JButton Minus;
	private JButton Point;
	private String Memory; 
	
	public Calculator() {
		initialize();
		GUI.setBounds(100, 100, 400, 400);
		GUI.setTitle("Calculator");
		this.frame().setVisible(true);
	}
	
	public JFrame frame() {
		return GUI;
	}
	
	private void initialize() {
		GUI = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 364, 38);
		GUI.getContentPane().add(textField);
		textField.setColumns(10);
		
		MemoryClear = new JButton("MC");
		MemoryClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Memory = "0";
			}
		});
		MemoryClear.setBounds(10, 60, 65, 38);
		GUI.getContentPane().add(MemoryClear);
		
		MemoryRecall = new JButton("MR");
		MemoryRecall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(Memory);
			}
		});
		MemoryRecall.setBounds(85, 60, 65, 38);
		GUI.getContentPane().add(MemoryRecall);
		
		MemoryStore = new JButton("MS");
		MemoryStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Memory = textField.getText();
			}
		});
		MemoryStore.setBounds(160, 60, 65, 38);
		GUI.getContentPane().add(MemoryStore);
		
		MemoryMinus = new JButton("M-");
		MemoryMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				int i = Integer.valueOf(Memory) - Integer.valueOf(s);
				Memory = Integer.toString(i);
			}
		});
		MemoryMinus.setBounds(309, 60, 65, 38);
		GUI.getContentPane().add(MemoryMinus);
		
		MemoryPlus = new JButton("M+");
		MemoryPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				int i = Integer.valueOf(Memory) + Integer.valueOf(s);
				Memory = Integer.toString(i);
			}
		});
		MemoryPlus.setBounds(234, 60, 65, 38);
		GUI.getContentPane().add(MemoryPlus);
		
		Delete = new JButton("DEL");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().charAt(textField.getText().length()-1) == ' ') {
					textField.setText(""+textField.getText().substring(0, textField.getText ().length() - 2));
				}
				else {
					textField.setText(""+textField.getText().substring(0, textField.getText ().length() - 1));
				}	
			}
		});
		Delete.setBounds(10, 109, 140, 38);
		GUI.getContentPane().add(Delete);

		Clear = new JButton("C");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
			}
		});
		Clear.setBounds(160, 109, 65, 38);
		GUI.getContentPane().add(Clear);
		
		Parenthesis1 = new JButton("(");
		Parenthesis1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Parenthesis1.getText() + " ");
			}
		});
		Parenthesis1.setBounds(234, 109, 65, 38);
		GUI.getContentPane().add(Parenthesis1);
		
		
		Parenthesis2 = new JButton(")");
		Parenthesis2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText()  + " " + Parenthesis2.getText());
			}
		});
		Parenthesis2.setBounds(309, 109, 65, 38);
		GUI.getContentPane().add(Parenthesis2);
		
		Equal = new JButton("=");
		Equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String s = textField.getText();
					String conv = Conversion.InfixToPost(s);
					String eval = Evaluation.evaluatePostfix(conv);
					textField.setText(eval);
					
			}
			});
		Equal.setBounds(309, 158, 65, 185);
		GUI.getContentPane().add(Equal);
		
		Seven = new JButton("7");
		Seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Seven.getText());
			}
		});
		Seven.setBounds(10, 158, 65, 38);
		GUI.getContentPane().add(Seven);
		
		Eight = new JButton("8");
		Eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Eight.getText());
			}
		});
		Eight.setBounds(85, 158, 65, 38);
		GUI.getContentPane().add(Eight);
		
		Nine = new JButton("9");
		Nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Nine.getText());
			}
		});
		Nine.setBounds(160, 158, 65, 38);
		GUI.getContentPane().add(Nine);
		
		Divide = new JButton("/");
		Divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText()  + " " + Divide.getText() + " ");
			}
		});
		Divide.setBounds(234, 158, 65, 38);
		GUI.getContentPane().add(Divide);
		
		Four = new JButton("4");
		Four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Four.getText());
			}
		});
		Four.setBounds(10, 207, 65, 38);
		GUI.getContentPane().add(Four);
		
		Five = new JButton("5");
		Five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Five.getText());
			}
		});
		Five.setBounds(85, 207, 65, 38);
		GUI.getContentPane().add(Five);
		
		Six = new JButton("6");
		Six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Six.getText());
			}
		});
		Six.setBounds(160, 207, 65, 38);
		GUI.getContentPane().add(Six);
		
		Multiply = new JButton("*");
		Multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + " " + Multiply.getText() + " ");
			}
		});
		Multiply.setBounds(234, 207, 65, 38);
		GUI.getContentPane().add(Multiply);
		
		Minus = new JButton("-");
		Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText()  + " " + Minus.getText() + " ");
			}
		});
		Minus.setBounds(234, 256, 65, 38);
		GUI.getContentPane().add(Minus);
		
		Three = new JButton("3");
		Three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Three.getText());
			}
		});
		Three.setBounds(160, 256, 65, 38);
		GUI.getContentPane().add(Three);
		
		Two = new JButton("2");
		Two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Two.getText());
			}
		});
		Two.setBounds(85, 256, 65, 38);
		GUI.getContentPane().add(Two);
		
		One = new JButton("1");
		One.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + One.getText());
			}
		});
		One.setBounds(10, 256, 65, 38);
		GUI.getContentPane().add(One);
		
		Zero = new JButton("0");
		Zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText() + Zero.getText());
			}
		});
		Zero.setBounds(10, 305, 140, 38);
		GUI.getContentPane().add(Zero);
		
		Point = new JButton(".");
		Point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + Point.getText());
			}
		});
		Point.setBounds(160, 305, 65, 38);
		GUI.getContentPane().add(Point);
		
		Plus = new JButton("+");
		Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("0")) {
					textField.setText("");
				}
				textField.setText(textField.getText()  + " " + Plus.getText() + " ");
			}
		});
		Plus.setBounds(234, 305, 65, 38);
		GUI.getContentPane().add(Plus);
	}
}
