package tenjinMath;

public interface Module 
{
	public static Module getInstance() { return null;}
	public Lesson getLesson();
	public String getSavedData();
	public void loadSavedData(String savedData);
	public void updateProgress(Lesson currentLesson);
}
