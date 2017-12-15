import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	String wordToGuess;
	Stack<String> randomWord = new Stack<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	
public static void main(String[] args) {
	JOptionPane.showMessageDialog(null, "This is a Java Hang Man.");
HangMan HHangman = new HangMan();	
HHangman.hangManChosing();
}
//Making the frame and printing the 
 HangMan() {
	frame.add(panel);
	panel.add(label);
	wordToGuess = " ";
	label.setText(""+ wordToGuess);
	frame.setSize(300, 300);
	frame.addKeyListener(this);
	frame.setVisible(true);
}
//Making random variable
public void hangManChosing() {
	randomWord.push("main method");
	randomWord.push("method");
	randomWord.push("string");
	randomWord.push("integer");
	randomWord.push("boolean");
	randomWord.push("class");
	randomWord.push("doubble");
	randomWord.push("for loop");
	randomWord.push("float");
	randomWord.push("if statement");
	randomWord.push("eclipse");
	randomWord.push("stack");
	randomWord.push("array lists");
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
//Making the key pressed to print the variable when key is pressed
public void keyPressed(KeyEvent e) {
	String letterAmount = "";
	// TODO Auto-generated method stub
	wordToGuess = randomWord.pop();
	for (int i = 0; i < wordToGuess.length(); i++) {
		letterAmount += "_";
	}
	label.setText(""+ letterAmount);
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
