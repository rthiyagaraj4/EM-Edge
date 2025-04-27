package eCA.Common ;

import eCommon.Common.* ;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;

public class CaAdapter extends CommonAdapter implements Serializable 
{
	private ArrayList<String> siteSpecificDtls = new ArrayList<String>();
	
	public boolean isSiteSpecific(String functionId)
	{
		if(siteSpecificDtls.contains(functionId))
			return true;

		return false;
	}

	public void clearAll()
	{
		siteSpecificDtls = new ArrayList();
	}

	public void setSiteSpecific(ArrayList<String> functionIds, String moduleId)
	{
		Connection connection	= null ;
		PreparedStatement siteSpecPrepStmt = null;
		ResultSet siteSpecRs = null;		
		StringBuilder siteSpecSelectQry = new StringBuilder();
		String res = "";

		try
		{
			connection = getConnection();			

			for(String r : functionIds)
			{
				if(!res.equals(""))
					res = res +",";
				res += "'"+ r + "'";
			}

			siteSpecSelectQry.append("SELECT FUNCTIONALITY_ID FROM SM_FUNCTION_CONTROL A, SM_SITE_PARAM B WHERE  A.FUNCTIONALITY_ID IN (");
			siteSpecSelectQry.append(res);
			siteSpecSelectQry.append(") AND A.MODULE_ID = ? AND A.SITE_ID = B.CUSTOMER_ID");;
						
			siteSpecPrepStmt = connection.prepareStatement(siteSpecSelectQry.toString());
			siteSpecPrepStmt.setString(1,moduleId);

			siteSpecRs = siteSpecPrepStmt.executeQuery();

			while(siteSpecRs.next())
			{
				siteSpecificDtls.add(siteSpecRs.getString("FUNCTIONALITY_ID")) ;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(siteSpecRs);
				closeStatement(siteSpecPrepStmt);
				closeConnection(connection);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
	}
}