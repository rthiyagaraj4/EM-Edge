/*Created by Ashwini on 08-May-2018 for ML-MMOH-CRF-0589*/
package eBT;

import java.sql.ResultSet;
import java.sql.Types;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eBT.*;

public class BTTransferServlet extends javax.servlet.http.HttpServlet
{

public void init(ServletConfig config) throws ServletException {
		super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException {

	String transferRemarks = "";
	PrintWriter out;
	String locale = "";
	String strErr = "";
	String strOut = "";
	String login_user = "";
    String query = "";
	String strClientIpAddress = "";
	boolean result = false;

	Hashtable hashElement = null,masterHashElement = null;
	Vector detailVector = new Vector(10,2);
	eBT.MasterXMLParse masterXMLParse;
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");	
	HttpSession session = req.getSession(false);
	out = res.getWriter();
	masterXMLParse = new MasterXMLParse();
	java.util.Properties p = null;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;		
	login_user = p.getProperty( "login_user" ) ;
	strClientIpAddress = p.getProperty("client_ip_address");	
	locale = ((String)session.getAttribute("LOCALE"));
	Connection con = ConnectionManager.getConnection(req);		
	CallableStatement callableStatement=null;				

	try 
	{
		out = res.getWriter();
				
        InputSource inputSource = new InputSource(req.getReader());
		Vector vector = new Vector(1);		

		try{
			hashElement=masterXMLParse.parseXMLData(inputSource,null,vector);	
	  	}catch(Exception ee)
		{
		}
			Set set = hashElement.keySet();
			Iterator itr = set.iterator();

				while(itr.hasNext())
				{
					String key  = (String) itr.next();
					Object obj=hashElement.get(key);
					if(obj instanceof Vector)
					detailVector = (Vector) hashElement.get(key);
					else
					masterHashElement = (Hashtable) hashElement.get(key);
				}

				if (detailVector == null)
				{
					detailVector = null;
				}
				masterHashElement.put("login_user",login_user);		

				query="{call BT_TRANSFER_COMMIT.UPDATE_BT_UNIT_REQUEST_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			    callableStatement=con.prepareCall(query);

				callableStatement.setString(1,""+masterHashElement.get("OPERATING_FACILITY_ID"));

				callableStatement.setString(2,""+masterHashElement.get("SPECIMEN_NO"));

				callableStatement.setString(3,""+masterHashElement.get("PATIENT_ID"));

				callableStatement.setString(4,""+masterHashElement.get("UNIT_NO"));

				callableStatement.setString(5,""+masterHashElement.get("PRODUCT_CODE"));

				callableStatement.setString(6,strClientIpAddress);

				callableStatement.setString(7,login_user);

				callableStatement.setString(8,""+masterHashElement.get("transfer_by_id"));
				
				callableStatement.setString(9,com.ehis.util.DateUtils.convertDate(""+masterHashElement.get("transfer_date_time"),"DMYHM",locale,"en"));

				transferRemarks = ""+masterHashElement.get("TRANSFER_REMARKS");

				transferRemarks = transferRemarks.replace('\"','\n');

				transferRemarks = transferRemarks.replace('^','\n');

				callableStatement.setString(10,transferRemarks);		

				callableStatement.setString(11,""+masterHashElement.get("transfer_to_code"));

				callableStatement.registerOutParameter(12,Types.VARCHAR);
				
				callableStatement.registerOutParameter(13,Types.VARCHAR);

				callableStatement.setString(14,""+masterHashElement.get("transfer_reason_code"));
				
				callableStatement.executeQuery();

				strErr=callableStatement.getString(12);

				strOut=callableStatement.getString(13);

				callableStatement.close();

				con.commit();					

				if(strErr!= null && strErr.length() >0 && strErr.charAt(0) == 'E')
				{
					result = false;
					out.print(strOut);
				}
				else
				{
					result = true;
				}

				if(result)
				{

				query="{call BT_TRANSFER_COMMIT.main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			    callableStatement=con.prepareCall(query);

				callableStatement.setString(1,""+masterHashElement.get("OPERATING_FACILITY_ID"));

				callableStatement.setString(2,""+masterHashElement.get("SPECIMEN_NO"));

				callableStatement.setString(3,""+masterHashElement.get("PATIENT_ID"));

				callableStatement.setString(4,""+masterHashElement.get("UNIT_NO"));

				callableStatement.setString(5,""+masterHashElement.get("PRODUCT_CODE"));

				callableStatement.setString(6,strClientIpAddress);

				callableStatement.setString(7,login_user);

				callableStatement.setString(8,""+masterHashElement.get("transfer_by_id"));
				
				callableStatement.setString(9,com.ehis.util.DateUtils.convertDate(""+masterHashElement.get("transfer_date_time"),"DMYHM",locale,"en"));

				callableStatement.setString(10,""+masterHashElement.get("CURRENT_VOLUME"));

				transferRemarks = ""+masterHashElement.get("TRANSFER_REMARKS");

				transferRemarks = transferRemarks.replace('\"','\n');

				transferRemarks = transferRemarks.replace('^','\n');

				callableStatement.setString(11,transferRemarks);		

				callableStatement.setString(12,""+masterHashElement.get("STORAGE_LOC_CODE"));

				callableStatement.registerOutParameter(13,Types.VARCHAR);
				
				callableStatement.registerOutParameter(14,Types.VARCHAR);

				callableStatement.setString(15,""+masterHashElement.get("transfer_reason_code"));
				
				callableStatement.executeQuery();

				strErr=callableStatement.getString(13);

				strOut=callableStatement.getString(14);

				callableStatement.close();

				con.commit();					

				if(strErr!= null && strErr.length() >0 && strErr.charAt(0) == 'E')
				{
					out.print(strOut);
				}
				else
				{
					out.print("1");	
				}
				}

	}
	catch(Exception e)
	{	
		e.printStackTrace();
		out.println("0");
	}
	finally{
		eBT.BTDBDisConnectAdapter.closeCursor(callableStatement);
		ConnectionManager.returnConnection(con, req);
	}
}

}