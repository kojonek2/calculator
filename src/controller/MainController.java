package controller;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import calculator.Calculator;
import enums.ArithmeticOperation;
import enums.TrigonometricFunction;
import listeners.JFormatedTextUpdateListener;
import model.Model;
import views.MainFrame;

public class MainController {
	
	private MainFrame view;
	private Model model;

	public MainController(MainFrame view, Model model) {
		this.view = view;
		this.model = model;
		
		initializeArithmeticListeners();
		initializeTrigonometricListeners();
		initializeOtherListeners();
	}
	
	private void initializeArithmeticListeners() {
		view.addAdditionButtonActionListener(e -> { 
			view.setArithmeticOutputValue(null);
			view.setArithmeticOperationLabelText("+");
			model.setArithmeticOperator(ArithmeticOperation.ADDITION);
		});
		
		view.addSubstractionButtonActionListener(e -> { 
			view.setArithmeticOutputValue(null);
			view.setArithmeticOperationLabelText("-");
			model.setArithmeticOperator(ArithmeticOperation.SUBSTRACTION);
		});
		
		view.addMultiplicationButtonActionListener(e -> { 
			view.setArithmeticOutputValue(null);
			view.setArithmeticOperationLabelText("*");
			model.setArithmeticOperator(ArithmeticOperation.MULTIPLICATION);
		});
		
		view.addQuotientButtonActionListener(e -> { 
			view.setArithmeticOutputValue(null);
			view.setArithmeticOperationLabelText("/");
			model.setArithmeticOperator(ArithmeticOperation.QUOTIENT);
		});
		
		view.addArithmeticInput1DocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setArithmeticOutputValue(null);
		}));
		view.addArithmeticInput2DocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setArithmeticOutputValue(null);
		}));
		
		view.addArithmeticCalculateButtonActionListener(e -> {
			double input1 = view.getArithmeticInput1Value();
			double input2 = view.getArithmeticInput2Value();
			
			double result = model.calculateArithmeticResult(input1, input2);
			view.setArithmeticOutputValue(result);
		});
	}
	
	private void initializeTrigonometricListeners() {
		view.addSinButtonActionListener(e -> {
			view.setTrigonometricOutputValue(null);
			view.setTrigonometricFunctionLabelText("Sin(");
			model.setTrigonometricFunction(TrigonometricFunction.SIN);
		});
		
		view.addCosButtonActionListener(e -> {
			view.setTrigonometricOutputValue(null);
			view.setTrigonometricFunctionLabelText("Cos(");
			model.setTrigonometricFunction(TrigonometricFunction.COS);
		});
		
		view.addTanButtonActionListener(e -> {
			view.setTrigonometricOutputValue(null);
			view.setTrigonometricFunctionLabelText("Tan(");
			model.setTrigonometricFunction(TrigonometricFunction.TAN);
		});
		
		view.addCotButtonActionListener(e -> {
			view.setTrigonometricOutputValue(null);
			view.setTrigonometricFunctionLabelText("Cot(");
			model.setTrigonometricFunction(TrigonometricFunction.COT);
		});
		
		view.addTrigonometricInputDocumentListener(new JFormatedTextUpdateListener(() ->  {
			view.setTrigonometricOutputValue(null);
		}));
		
		view.addTrigonometricCalculateButtonActionListener(e -> {
			double input = view.getTrigonometricInputValue();
			
			double result = model.calculateTrigonometricResult(input);
			view.setTrigonometricOutputValue(result);
		});
	}
	
	private void initializeOtherListeners() {
		view.addNaturalLogarithmInputDocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setNaturalLogarithmOutputValue(null);
		}));
		
		view.addNaturalLogarithmCalculateButtonActionListener(e -> {
			double input = view.getNaturalLogarithmInputValue();
			
			double result = Math.log(input);
			view.setNaturalLogarithmOutputValue(result);
		});
		
		//===================================================================
		
		view.addSquareRootInputDocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setSquareRootOutputValue(null);
		}));
		
		view.addSquareRootCalculateButtonActionListener(e -> {
			double input = view.getSquareRootInputValue();
			
			double result = Math.sqrt(input);
			view.setSquareRootOutputValue(result);
		});
		
		//===================================================================
		
		view.addPowerInput1DocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setPowerOutputValue(null);
		}));
		view.addPowerInput2DocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setPowerOutputValue(null);
		}));
		
		view.addPowerCalculateButtonActionListener(e -> {
			double input1 = view.getPowerInput1Value();
			double input2 = view.getPowerInput2Value();
			
			double result = Math.pow(input1, input2);
			view.setPowerOutputValue(result);
		});
		
		//===================================================================
		view.addQuadraticEquationATermDocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setQuadraticEquationRootOutput1Value(null);
			view.setQuadraticEquationRootOutput2Value(null);
		}));
		view.addQuadraticEquationBTermDocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setQuadraticEquationRootOutput1Value(null);
			view.setQuadraticEquationRootOutput2Value(null);
		}));
		view.addQuadraticEquationCTermDocumentListener(new JFormatedTextUpdateListener(() -> {
			view.setQuadraticEquationRootOutput1Value(null);
			view.setQuadraticEquationRootOutput2Value(null);
		}));
		
		view.addQuadraticEquationCalculateButtonActionListener(e -> {
			double a = view.getQuadraticEquationATerm1Value();
			double b = view.getQuadraticEquationBTerm1Value();
			double c = view.getQuadraticEquationCTerm1Value();
			
			if (a == 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(view, "A nie mo¿e byæ równe 0", "B³¹d", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			double[] roots = Calculator.squareRootsOfQuadraticEquation(a, b, c);
			if (roots.length >= 1)
				view.setQuadraticEquationRootOutput1Value(roots[0]);
			if (roots.length >= 2)
				view.setQuadraticEquationRootOutput2Value(roots[1]);
		});
	}
}
