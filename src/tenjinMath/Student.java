package tenjinMath;

public class Student extends User
{
	private String studentName;
	private int gradeLevel;
	private int[] studentData;
	
	@Override
	public boolean checkLoginInfo()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public String getStudentName()
	{
		return studentName;
	}

	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}

	public int getGradeLevel()
	{
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel)
	{
		this.gradeLevel = gradeLevel;
	}

	public int[] getStudentData()
	{
		return studentData;
	}

	public void setStudentData(int[] studentData)
	{
		this.studentData = studentData;
	}

}
