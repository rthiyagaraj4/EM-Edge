package em.xh.remoteserver;

import java.io.StringWriter;
import java.io.PrintWriter;
import HL7Engine.Common.CommonUtil;

public class RemoteObjUtil
{
	public static String portInUseError(String expStr)
	{
		String errStr = "Unable to start Remote Server!!!";
		boolean isPortInUse = CommonUtil.isSubstringExists(expStr, "Port already in use");
		if(isPortInUse) errStr = errStr + "\n" + expStr.substring(0, expStr.indexOf(";"));

		return errStr;
	}

	// Method sends the stack trace of passed exception in string format.
	static public String getStringStackTrace(Exception exp)
	{
		String expStr = exp.getMessage();
		try
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			exp.printStackTrace(pw);
			expStr = sw.toString();
		}
		catch(Exception cexp)
		{}
		return expStr;
	}
}