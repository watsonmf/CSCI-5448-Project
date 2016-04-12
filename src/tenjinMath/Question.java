package tenjinMath;

public abstract class Question
{
	protected String shortQuestion;
	protected String longQuestion;
	protected String helpQuestion;
	
	public abstract boolean checkAnswer(String answer);

	/**
	 * @return the shortQuestion
	 */
	public String getShortQuestion()
	{
		return shortQuestion;
	}

	/**
	 * @param shortQuestion the shortQuestion to set
	 */
	public void setShortQuestion(String shortQuestion)
	{
		this.shortQuestion = shortQuestion;
	}

	/**
	 * @return the longQuestion
	 */
	public String getLongQuestion()
	{
		return longQuestion;
	}

	/**
	 * @param longQuestion the longQuestion to set
	 */
	public void setLongQuestion(String longQuestion)
	{
		this.longQuestion = longQuestion;
	}
	

}
