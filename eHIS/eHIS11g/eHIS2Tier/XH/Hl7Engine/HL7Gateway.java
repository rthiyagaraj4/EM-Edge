/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/

public class HL7Gateway
{
	public static void main(String s[])
	{
		try
		{
			Runtime runtime = Runtime.getRuntime();
		//	Process process = 
			runtime.exec(s[0]);
			System.out.println(" Process Created");
		}
		catch(Exception exception)
		{
			System.out.println(" Err"+exception);
		}
	}
}

