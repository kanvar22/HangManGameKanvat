import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	String wordToGuess;
	Stack<String> randomWord = new Stack<String>();
	ArrayList<JLabel> boxes = new ArrayList<JLabel>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label3 = new JLabel();
	JLabel lives = new JLabel();
	int numberOfLives = 9  ;
	
	
public static void main(String[] args) {
	JOptionPane.showMessageDialog(null, "This is a Java Hang Man.");
	JOptionPane.showMessageDialog(null, "If you are done with the word early then click enter until you go to the next word!!");
HangMan HHangman = new HangMan();


}
//Making the frame and printing the 
 HangMan() {
	frame.add(panel);
	panel.add(label);
	panel.add(lives);
	lives.setText("" + numberOfLives);
	hangManChosing();
	wordToGuess = " ";
	label.setText(""+ wordToGuess);
	frame.setSize(1000, 100);
	frame.addKeyListener(this);
	frame.setVisible(true);
	
	wordToGuess = randomWord.pop();
	createBoxes();
	System.out.println(wordToGuess);
	frame.pack();
	
}
 private String getCurrentAnswer() {
		StringBuffer answer = new StringBuffer();
		for (JLabel textBox : boxes) {
			answer.append(textBox.getText());
		}
		return answer.toString();
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
private void updateSpacesWithUserInput(char keyChar) {
	for (int i = 0; i < wordToGuess.length(); i++) {
		if (wordToGuess.charAt(i) == keyChar) {
			boxes.get(i).setText("" + keyChar);
		}
	}
}
private void loadNextPuzzle() {
	removeBoxes();
	
	wordToGuess = randomWord.pop();
	System.out.println("puzzle is now " + wordToGuess);
	createBoxes();
	JOptionPane.showMessageDialog(null, "Press enter to resent your lives.");
	frame.pack();
	
	
	
}
public void createBoxes() {
	for (int i = 0; i < wordToGuess.length(); i++) {
		JLabel label3 = new JLabel(); 
		label3.setText(" _ ");
		panel.add(label3);
		boxes.add(label3);
		
		
	}
}
public void removeBoxes( ){
	for (int i = 0; i < wordToGuess.length(); i++) {
		
		label3 = boxes.remove(0);
		panel.remove(label3);
		
	}
	
	
		
		
	
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
	

	//label.setText(""+ letterAmount);
	if (wordToGuess.indexOf(e.getKeyChar()) >= 0) {
		System.out.println("yay");
		letterAmount += "";
		updateSpacesWithUserInput(e.getKeyChar());
	}
	else {
		numberOfLives = numberOfLives - 1;
		lives.setText("" + numberOfLives);
		
	}
	
	if (numberOfLives == 0) {
		JOptionPane.showMessageDialog(null, "Better luck next time!!!!!");
		System.exit(0);
	}
	
	String correctAnswer = getCurrentAnswer();
	if (correctAnswer.equals(wordToGuess)) {
		JOptionPane.showMessageDialog(null, "You got it correct");
		
			
			loadNextPuzzle();
			numberOfLives = 9 + 1;
		
	}

}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
