/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eBT.*;


//import oracle.aurora.jndi.sess_iiop.ServiceCtx;

public class BTStorageLocation extends javax.servlet.http.HttpServlet
{


public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		
		PrintWriter out;


		String strFacilityId="";
		String strStat="";
		String strErr="";



		String	strSpecimenNo="";
		String 	strProductCode="";
	//	String 	strUnitNo="";
		String	strFlag="";
		String strLocationCode="";
		String strRhesusCode="";
		String strBloodGroup="";
		String strSourceType="";
		String strSourceCode="";
	
		//eBT.LogFile.log("QADebugger","Entering", this);

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");


		HttpSession session=req.getSession(false);

		strFacilityId=""+session.getAttribute("facility_id");


		//res.setContentType("text/html");
		out=res.getWriter();

		//eBT.LogFile.log("QADebugger","Enter successfully", this);


		//java.util.Properties p = null;

		//p = (java.util.Properties) session.getValue( "jdbc" ) ;		
		


		Connection con = ConnectionManager.getConnection(req);		
		CallableStatement callableStatement=null;


		try 
		{
			
			strSpecimenNo=""+req.getParameter("SPECIMEN_NO");
			strProductCode=""+req.getParameter("PRODUCT_CODE");
			strBloodGroup=""+req.getParameter("BLOOD_GROUP");
			strRhesusCode=""+req.getParameter("RHESUS_CODE");
			strLocationCode=""+req.getParameter("LOCATION_CODE");
			strSourceType=""+req.getParameter("SOURCE_TYPE");
			strSourceCode=""+req.getParameter("SOURCE_CODE");
		//	strUnitNo=""+req.getParameter("UNIT_NO");
			strFlag=""+req.getParameter("FLAG");



			out = res.getWriter();
				
			//eBT.LogFile.log("QADebugger","Process Starting",this);
 
			

				//eBT.LogFile.log("QADebugger","Before",this);

				

if(strFlag.equals("1")==true)
			{

			    callableStatement=con.prepareCall("{ call BT_TRANSFUSE_COMMIT.GET_DEFAULT_STORAGE_LOC_CODE(?,?,?,?,?,?,?,?,?)}");

				callableStatement.setString(1,strFacilityId);
				//eBT.LogFile.log("QADebugger","INTER strFacilityId="+strFacilityId,this);

				callableStatement.setString(2,strSpecimenNo);
				//eBT.LogFile.log("QADebugger","INTER strSpecimenNo="+strSpecimenNo,this);

				callableStatement.setString(3,strProductCode);
				//eBT.LogFile.log("QADebugger","INTER strProductCode="+strProductCode,this);

				callableStatement.setString(4,strBloodGroup);
				//eBT.LogFile.log("QADebugger","INTER strBloodGroup="+strBloodGroup,this);

				callableStatement.setString(5,strRhesusCode);
				//eBT.LogFile.log("QADebugger","INTER strRhesusCode="+strRhesusCode,this);

				callableStatement.setString(6,strSourceType);

				callableStatement.setString(7,strSourceCode);


				callableStatement.setString(8,"UT");
				callableStatement.registerOutParameter(9,Types.VARCHAR);

	
				


				callableStatement.execute();

			 strLocationCode=callableStatement.getString(9);	

			out.println(strLocationCode);

			//eBT.LogFile.log("QADebugger","Stat value"+strLocationCode,this);

	
			//eBT.LogFile.log("QADebugger","<------------closed---------->", this);
	
			//eBT.LogFile.log("QADebugger","%%%%@@@@@@connectionreturned@@@@@%%%%%%", this);
			callableStatement.close();
			}
else
			{



			    callableStatement=con.prepareCall("{ call BT_TRANSFUSE_COMMIT.GET_STORAGE_LOC_CODE(?,?,?,?,?,?,?,?,?,?,?)}");

				callableStatement.setString(1,strFacilityId);
				//eBT.LogFile.log("QADebugger","INTER strFacilityId="+strFacilityId,this);

				callableStatement.setString(2,strSpecimenNo);
				//eBT.LogFile.log("QADebugger","INTER strSpecimenNo="+strSpecimenNo,this);

				callableStatement.setString(3,strProductCode);
				//eBT.LogFile.log("QADebugger","INTER strProductCode="+strProductCode,this);

				callableStatement.setString(4,strBloodGroup);
				//eBT.LogFile.log("QADebugger","INTER strBloodGroup="+strBloodGroup,this);

				callableStatement.setString(5,strRhesusCode);
				//eBT.LogFile.log("QADebugger","INTER strRhesusCode="+strRhesusCode,this);

//				callableStatement.setString(5,null);
//				callableStatement.setString(6,null);

				callableStatement.setString(6,strSourceType);

				callableStatement.setString(7,strSourceCode);


				callableStatement.setString(8,"UT");
				callableStatement.setString(9,strLocationCode);
								//eBT.LogFile.log("QADebugger","INTER strFacilityId="+strLocationCode,this);


				callableStatement.registerOutParameter(10,Types.VARCHAR);
				callableStatement.registerOutParameter(11,Types.VARCHAR);

				callableStatement.execute();

			  strStat= callableStatement.getString(10);
			 strErr=callableStatement.getString(11);

			 if(strStat==null||strStat.equalsIgnoreCase("null"))		  strStat=" ";
				
			if(strErr==null||strErr.equalsIgnoreCase("null"))		  strErr=" ";

	

			//eBT.LogFile.log("QADebugger","Stat value"+strStat,this);
			//eBT.LogFile.log("QADebugger","Err value"+strErr,this);


			if(strStat!=null )    out.print(strStat+"||"+strErr);
		

		

//		eBT.BTDBDisConnectAdapter.closeCursor(callableStatement);					
			//eBT.LogFile.log("QADebugger","<------------closed---------->", this);
	
			//eBT.LogFile.log("QADebugger","%%%%@@@@@@connectionreturned@@@@@%%%%%%", this);
	
			callableStatement.close();
			}
			
		}
		catch(Exception e)
		{
			//debug(e+"");;

				//eBT.LogFile.log("QADebugger",""+e, this);
				out.print("0");
		}
		finally
		{
			if(callableStatement!=null)
			eBT.BTDBDisConnectAdapter.closeCursor(callableStatement);		
			ConnectionManager.returnConnection(con, req);
		}
	}

}
