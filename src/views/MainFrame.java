package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	//===================================================================
	
	private JRadioButton additionButton;
	private JRadioButton substractionButton;
	private JRadioButton multiplicationButton;
	private JRadioButton quotientButton;
	
	private JFormattedTextField arithmeticInput1;
	private JFormattedTextField arithmeticInput2;
	private JFormattedTextField arithmeticOutput;
	
	private JLabel arithmeticOperatorLabel;
	private JButton arithmeticCalculateButton;
	
	//===================================================================
	
	private JRadioButton sinButton;
	private JRadioButton cosButton;
	private JRadioButton tanButton;
	private JRadioButton cotButton;
	
	private JFormattedTextField trigonometricInput;
	private JFormattedTextField trigonometricOutput;
	
	private JLabel trigonometricFunctionLabel;
	private JButton trigonometricCalculateButton;
	
	//===================================================================
	
	private JFormattedTextField squareRootInput;
	private JFormattedTextField squareRootOutput;
	
	private JButton squareRootCalculateButton;
	
	//===================================================================
	
	private JFormattedTextField naturalLogarithmInput;
	private JFormattedTextField naturalLogarithmOutput;
	
	private JButton naturalLogartihmCalculateButton;
	
	//===================================================================
	
	private JFormattedTextField powerInput1;
	private JFormattedTextField powerInput2;
	private JFormattedTextField powerOutput;
	
	private JButton powerCalculateButton;
	
	//===================================================================
	
	private JFormattedTextField quadraticEquationATermInput;
	private JFormattedTextField quadraticEquationBTermInput;
	private JFormattedTextField quadraticEquationCTermInput;
	
	private JFormattedTextField quadraticEquationRootOutput1;
	private JFormattedTextField quadraticEquationRootOutput2;
	
	private JButton quadraticEquationCalculateButton;
	
	//===================================================================

	public MainFrame() {
		super();
		
		setTitle("Kalkulator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		createArithmeticCompontens();
		createTrigonometricComponents();
		createOtherComponents();
		createQuadraticEquationComponents();
		
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	private void createArithmeticCompontens() {
		JPanel arithmeticPanel = new JPanel();
		arithmeticPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 5, 0, 0);
		arithmeticPanel.add(new JLabel("Dzia³ania arytmetyczne"), c);
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		additionButton = new JRadioButton("Dodawanie");
		additionButton.setSelected(true);
		arithmeticPanel.add(additionButton, c);
		
		c.gridy = 2;
		c.gridx = 0;
		substractionButton = new JRadioButton("Odejmowanie");
		arithmeticPanel.add(substractionButton, c);
		
		c.gridy = 1;
		c.gridx = 1;
		multiplicationButton = new JRadioButton("Mno¿enie");
		arithmeticPanel.add(multiplicationButton, c);
		
		c.gridy = 2;
		c.gridx = 1;
		quotientButton = new JRadioButton("Dzielenie");
		arithmeticPanel.add(quotientButton, c);
		
		ButtonGroup arithmeticGroup = new ButtonGroup();
		arithmeticGroup.add(additionButton);
		arithmeticGroup.add(substractionButton);
		arithmeticGroup.add(multiplicationButton);
		arithmeticGroup.add(quotientButton);
		
		c.gridy = 1;
		c.gridx = 2;
		arithmeticInput1 = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		arithmeticInput1.setValue(0);
		arithmeticInput1.setPreferredSize(new Dimension(100, 20));
		arithmeticPanel.add(arithmeticInput1, c);
		
		c.gridy = 1;
		c.gridx = 3;
		c.insets = new Insets(0, 5, 0, 5);
		arithmeticOperatorLabel = new JLabel("+");
		arithmeticPanel.add(arithmeticOperatorLabel, c);
		
		c.gridy = 1;
		c.gridx = 4;
		c.insets = new Insets(0, 0, 0, 0);
		arithmeticInput2 = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		arithmeticInput2.setValue(0);
		arithmeticInput2.setPreferredSize(new Dimension(100, 20));
		arithmeticPanel.add(arithmeticInput2, c);
		
		c.gridy = 1;
		c.gridx = 5;
		c.insets = new Insets(0, 5, 0, 5);
		arithmeticPanel.add(new JLabel("="), c);
		
		c.gridy = 1;
		c.gridx = 6;
		c.insets = new Insets(0, 0, 0, 0);
		arithmeticOutput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		arithmeticOutput.setPreferredSize(new Dimension(100, 20));
		arithmeticOutput.setEditable(false);
		arithmeticPanel.add(arithmeticOutput, c);
		
		
		
		c.gridy = 2;
		c.gridx = 4;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.CENTER;
		arithmeticCalculateButton = new JButton("Oblicz");
		arithmeticPanel.add(arithmeticCalculateButton, c);
		
		//to align to left
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(arithmeticPanel);
		getContentPane().add(panel);
	}
	
	private void createTrigonometricComponents() {
		JPanel trigonometricPanel = new JPanel();
		trigonometricPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 5, 0, 0);
		trigonometricPanel.add(new JLabel("Dzia³ania trygonometryczne"), c);
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		sinButton = new JRadioButton("Sin");
		sinButton.setSelected(true);
		trigonometricPanel.add(sinButton, c);
		
		c.gridy = 2;
		c.gridx = 0;
		cosButton = new JRadioButton("Cos");
		trigonometricPanel.add(cosButton, c);
		
		c.gridy = 1;
		c.gridx = 1;
		tanButton = new JRadioButton("Tan");
		trigonometricPanel.add(tanButton, c);
		
		c.gridy = 2;
		c.gridx = 1;
		cotButton = new JRadioButton("Cot");
		trigonometricPanel.add(cotButton, c);
		
		ButtonGroup trigonometricGroup = new ButtonGroup();
		trigonometricGroup.add(sinButton);
		trigonometricGroup.add(cosButton);
		trigonometricGroup.add(tanButton);
		trigonometricGroup.add(cotButton);
		
		c.gridy = 1;
		c.gridx = 2;
		c.insets = new Insets(0, 20, 0, 0);
		trigonometricFunctionLabel = new JLabel("Sin(");
		trigonometricPanel.add(trigonometricFunctionLabel, c);
		
		c.gridy = 1;
		c.gridx = 3;
		c.insets = new Insets(0, 0, 0, 0);
		trigonometricInput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		trigonometricInput.setPreferredSize(new Dimension(100, 20));
		trigonometricInput.setValue(0);
		trigonometricPanel.add(trigonometricInput, c);
		
		c.gridy = 1;
		c.gridx = 4;
		trigonometricPanel.add(new JLabel(") = "), c);
		
		c.gridy = 1;
		c.gridx = 5;
		trigonometricOutput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		trigonometricOutput.setPreferredSize(new Dimension(100, 20));
		trigonometricOutput.setEditable(false);
		trigonometricPanel.add(trigonometricOutput, c);
		
		c.gridy = 2;
		c.gridx = 3;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.CENTER;
		trigonometricCalculateButton = new JButton("Oblicz");
		trigonometricPanel.add(trigonometricCalculateButton, c);
		
		//to align to left
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(trigonometricPanel);
		getContentPane().add(panel);
	}
	
	private void createOtherComponents() {
		JPanel otherPanel = new JPanel();
		otherPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 5, 0, 0);
		otherPanel.add(new JLabel("Pozosta³e dzia³ania"), c);
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		otherPanel.add(new JLabel("Pierwiastek kwadratowy z :"), c);
		
		c.gridy = 1;
		c.gridx = 1;
		squareRootInput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		squareRootInput.setPreferredSize(new Dimension(100, 20));
		squareRootInput.setValue(0);
		otherPanel.add(squareRootInput, c);
		
		c.gridy = 1;
		c.gridx = 2;
		otherPanel.add(new JLabel("="), c);
		
		c.gridy = 1;
		c.gridx = 3;
		squareRootOutput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		squareRootOutput.setPreferredSize(new Dimension(100, 20));
		squareRootOutput.setEditable(false);
		otherPanel.add(squareRootOutput, c);
		
		c.gridy = 1;
		c.gridx = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		squareRootCalculateButton = new JButton("Oblicz");
		otherPanel.add(squareRootCalculateButton, c);
		
		//===================================================================
		
		c.gridy = 2;
		c.gridx = 0;
		otherPanel.add(new JLabel("Logarytm naturalny z :"), c);
		
		c.gridy = 2;
		c.gridx = 1;
		naturalLogarithmInput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		naturalLogarithmInput.setPreferredSize(new Dimension(100, 20));
		naturalLogarithmInput.setValue(0);
		otherPanel.add(naturalLogarithmInput, c);
		
		c.gridy = 2;
		c.gridx = 2;
		otherPanel.add(new JLabel("="), c);
		
		c.gridy = 2;
		c.gridx = 3;
		naturalLogarithmOutput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		naturalLogarithmOutput.setPreferredSize(new Dimension(100, 20));
		naturalLogarithmOutput.setEditable(false);
		otherPanel.add(naturalLogarithmOutput, c);
		
		c.gridy = 2;
		c.gridx = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		naturalLogartihmCalculateButton = new JButton("Oblicz");
		otherPanel.add(naturalLogartihmCalculateButton, c);
		
		//===================================================================
		
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 1;
		otherPanel.add(new JLabel("Potêgowanie: "), c);
		
		c.gridy = 3;
		c.gridx = 1;
		powerInput1 = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		powerInput1.setPreferredSize(new Dimension(100, 20));
		powerInput1.setValue(0);
		otherPanel.add(powerInput1, c);
		
		c.gridy = 3;
		c.gridx = 2;
		otherPanel.add(new JLabel("^"), c);
		
		c.gridy = 3;
		c.gridx = 3;
		powerInput2 = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		powerInput2.setPreferredSize(new Dimension(100, 20));
		powerInput2.setValue(0);
		otherPanel.add(powerInput2, c);
		
		c.gridy = 3;
		c.gridx = 4;
		otherPanel.add(new JLabel("="), c);
		
		c.gridy = 3;
		c.gridx = 5;
		powerOutput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		powerOutput.setPreferredSize(new Dimension(100, 20));
		powerOutput.setEditable(false);
		otherPanel.add(powerOutput, c);
		
		c.gridy = 4;
		c.gridx = 3;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.CENTER;
		powerCalculateButton = new JButton("Oblicz");
		otherPanel.add(powerCalculateButton, c);
		
		//===================================================================
		
		//to align to left
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(otherPanel);
		getContentPane().add(panel);
	}
	
	private void createQuadraticEquationComponents() {
		JPanel quadraticEquationPanel = new JPanel();
		quadraticEquationPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 5, 0, 0);
		quadraticEquationPanel.add(new JLabel("Rozwiazywanie równania kwadratowego ax^2 + bx + c"), c);
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		quadraticEquationPanel.add(new JLabel("a: "), c);
		
		c.gridy = 1;
		c.gridx = 1;
		quadraticEquationATermInput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		quadraticEquationATermInput.setPreferredSize(new Dimension(100, 20));
		quadraticEquationATermInput.setValue(0);
		quadraticEquationPanel.add(quadraticEquationATermInput, c);
		
		c.gridy = 2;
		c.gridx = 0;
		quadraticEquationPanel.add(new JLabel("b: "), c);
		
		c.gridy = 2;
		c.gridx = 1;
		quadraticEquationBTermInput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		quadraticEquationBTermInput.setPreferredSize(new Dimension(100, 20));
		quadraticEquationBTermInput.setValue(0);
		quadraticEquationPanel.add(quadraticEquationBTermInput, c);
		
		c.gridy = 3;
		c.gridx = 0;
		quadraticEquationPanel.add(new JLabel("c: "), c);
		
		c.gridy = 3;
		c.gridx = 1;
		quadraticEquationCTermInput = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		quadraticEquationCTermInput.setPreferredSize(new Dimension(100, 20));
		quadraticEquationCTermInput.setValue(0);
		quadraticEquationPanel.add(quadraticEquationCTermInput, c);
		
		c.gridy = 3;
		c.gridx = 2;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.CENTER;
		quadraticEquationCalculateButton = new JButton("Oblicz");
		quadraticEquationPanel.add(quadraticEquationCalculateButton, c);
		
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 2;
		quadraticEquationPanel.add(new JLabel("Pierwiastki równania: "), c);
		
		c.gridy = 4;
		c.gridx = 2;
		c.gridwidth = 1;
		quadraticEquationRootOutput1 = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		quadraticEquationRootOutput1.setPreferredSize(new Dimension(100, 20));
		quadraticEquationRootOutput1.setEditable(false);
		quadraticEquationPanel.add(quadraticEquationRootOutput1, c);
		
		c.gridy = 4;
		c.gridx = 3;
		quadraticEquationRootOutput2 = new JFormattedTextField(NumberFormat.getNumberInstance(getLocale()));
		quadraticEquationRootOutput2.setPreferredSize(new Dimension(100, 20));
		quadraticEquationRootOutput2.setEditable(false);
		quadraticEquationPanel.add(quadraticEquationRootOutput2, c);
		
		//to align to left
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(quadraticEquationPanel);
		getContentPane().add(panel);
	}
	
	//===================================================================
	
	public void addAdditionButtonActionListener(ActionListener l) {
		additionButton.addActionListener(l);
	}
	
	public void addSubstractionButtonActionListener(ActionListener l) {
		substractionButton.addActionListener(l);
	}
	
	public void addMultiplicationButtonActionListener(ActionListener l) {
		multiplicationButton.addActionListener(l);
	}
	
	public void addQuotientButtonActionListener(ActionListener l) {
		quotientButton.addActionListener(l);
	}
	
	public void addArithmeticInput1DocumentListener(DocumentListener l) {
		arithmeticInput1.getDocument().addDocumentListener(l);
	}
	
	public double getArithmeticInput1Value() {
		Number number = (Number)arithmeticInput1.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void addArithmeticInput2DocumentListener(DocumentListener l) {
		arithmeticInput2.getDocument().addDocumentListener(l);
	}
	
	public double getArithmeticInput2Value() {
		Number number = (Number)arithmeticInput2.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void setArithmeticOutputValue(Double value) {
		arithmeticOutput.setValue(value);
	}
	
	public void setArithmeticOperationLabelText(String text) {
		arithmeticOperatorLabel.setText(text);
	}
	
	public void addArithmeticCalculateButtonActionListener(ActionListener l) {
		arithmeticCalculateButton.addActionListener(l);
	}
	
	//===================================================================
	
	public void addSinButtonActionListener(ActionListener l) {
		sinButton.addActionListener(l);
	}
	
	public void addCosButtonActionListener(ActionListener l) {
		cosButton.addActionListener(l);
	}
	
	public void addTanButtonActionListener(ActionListener l) {
		tanButton.addActionListener(l);
	}
	
	public void addCotButtonActionListener(ActionListener l) {
		cotButton.addActionListener(l);
	}
	
	public void addTrigonometricInputDocumentListener(DocumentListener l) {
		trigonometricInput.getDocument().addDocumentListener(l);
	}
	
	public double getTrigonometricInputValue() {
		Number number = (Number)trigonometricInput.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void setTrigonometricOutputValue(Double value) {
		trigonometricOutput.setValue(value);
	}
	
	public void setTrigonometricFunctionLabelText(String text) {
		trigonometricFunctionLabel.setText(text);
	}
	
	public void addTrigonometricCalculateButtonActionListener(ActionListener l) {
		trigonometricCalculateButton.addActionListener(l);
	}
	
	//===================================================================
	
	public void addSquareRootInputDocumentListener(DocumentListener l) {
		squareRootInput.getDocument().addDocumentListener(l);
	}
	
	public double getSquareRootInputValue() {
		Number number = (Number)squareRootInput.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void setSquareRootOutputValue(Double value) {
		squareRootOutput.setValue(value);
	}
	
	public void addSquareRootCalculateButtonActionListener(ActionListener l) {
		squareRootCalculateButton.addActionListener(l);
	}
	
	//===================================================================
	
	public void addNaturalLogarithmInputDocumentListener(DocumentListener l) {
		naturalLogarithmInput.getDocument().addDocumentListener(l);
	}
	
	public double getNaturalLogarithmInputValue() {
		Number number = (Number)naturalLogarithmInput.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void setNaturalLogarithmOutputValue(Double value) {
		naturalLogarithmOutput.setValue(value);
	}
	
	public void addNaturalLogarithmCalculateButtonActionListener(ActionListener l) {
		naturalLogartihmCalculateButton.addActionListener(l);
	}
	
	//===================================================================
	
	public void addPowerInput1DocumentListener(DocumentListener l) {
		powerInput1.getDocument().addDocumentListener(l);
	}
	
	public double getPowerInput1Value() {
		Number number = (Number)powerInput1.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void addPowerInput2DocumentListener(DocumentListener l) {
		powerInput2.getDocument().addDocumentListener(l);
	}
	
	public double getPowerInput2Value() {
		Number number = (Number)powerInput2.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void setPowerOutputValue(Double value) {
		powerOutput.setValue(value);
	}
	
	public void addPowerCalculateButtonActionListener(ActionListener l) {
		powerCalculateButton.addActionListener(l);
	}
	
	//===================================================================
	
	public void addQuadraticEquationATermDocumentListener(DocumentListener l) {
		quadraticEquationATermInput.getDocument().addDocumentListener(l);
	}
	
	public double getQuadraticEquationATerm1Value() {
		Number number = (Number)quadraticEquationATermInput.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void addQuadraticEquationBTermDocumentListener(DocumentListener l) {
		quadraticEquationBTermInput.getDocument().addDocumentListener(l);
	}
	
	public double getQuadraticEquationBTerm1Value() {
		Number number = (Number)quadraticEquationBTermInput.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void addQuadraticEquationCTermDocumentListener(DocumentListener l) {
		quadraticEquationCTermInput.getDocument().addDocumentListener(l);
	}
	
	public double getQuadraticEquationCTerm1Value() {
		Number number = (Number)quadraticEquationCTermInput.getValue();
		if (number == null)
			return Double.NaN;
		return number.doubleValue();
	}
	
	public void setQuadraticEquationRootOutput1Value(Double value) {
		quadraticEquationRootOutput1.setValue(value);
	}
	
	public void setQuadraticEquationRootOutput2Value(Double value) {
		quadraticEquationRootOutput2.setValue(value);
	}
	
	public void addQuadraticEquationCalculateButtonActionListener(ActionListener l) {
		quadraticEquationCalculateButton.addActionListener(l);
	}
}
