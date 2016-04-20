package additionModule;

import tenjinMath.Question;

public class AdditionQuestion extends tenjinMath.Question
{
	private int[] possibleAnswers;
	private int[] operands;
	private char[] operators;
	
	public AdditionQuestion(int[] operands, char[] operators, int[] possibleAnswers)
	{
		this.operands = operands;
		this.operators = operators;
		this.possibleAnswers = possibleAnswers;
		
		int numberOfOperands = operands.length;
		
		super.shortQuestion = "" + operands[0];
		super.longQuestion = "\t" + operands[0] + "\n";
		
		for (int i = 1; i < numberOfOperands; i++)
		{
			super.shortQuestion += " " + operators[i - 1] + " " + operands[i];
			super.longQuestion += operators[i - 1] + "\t" + operands[i] + "\n";
		}
		
		super.shortQuestion += " = ";
		super.longQuestion += "-------\n";
	}
	
	@Override
	public boolean checkAnswer()
	{
		// TODO Auto-generated method stub
		
		int studentAnswerInteger = Integer.parseInt(studentAnswer);
		
		for (int i = 0; i < possibleAnswers.length; i++ )
		{
			if (studentAnswerInteger == possibleAnswers[i])
			{
				return true; 
			}
		}
		
		return false;
	}

}
