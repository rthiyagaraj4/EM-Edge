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
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eBT.*;


//import oracle.aurora.jndi.sess_iiop.ServiceCtx;

public class BTRRUpdateServlet extends javax.servlet.http.HttpServlet
{

public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		Hashtable hashElement=null,masterHashElement=null,subHashElement=null;

		Vector detailVector=new Vector(10,2);

		StringTokenizer strTokenizer;
		String rec_id,rowid;

		//eBT.MasterXMLParse masterXMLParse;
		eBT.MasterXMLParse masterXMLParse;

		Hashtable commonData=new Hashtable();



		//debug("Entering="+ (System.currentTimeMillis()) );
		//eBT.LogFile.log("QADebugger","Entering", this);
		
		HttpSession session=req.getSession(false);

	//	res.setContentType("text/html");
		//out=res.getWriter();
		
		masterXMLParse=new MasterXMLParse();
		//eBT.LogFile.log("QADebugger","Parser constructed successfully", this);

		String login_user="";
		String facility_id = "";
		String patient_id = "";
        String query="";
		String strSessionId="";
		String strFrmDate="";
		String strPrintMode="";
		String llogin_user="";
		String strFID="";
		String locale="";

		java.util.Properties p = null;
		PreparedStatement pstmt = null;		
		p = (java.util.Properties) session.getValue( "jdbc" ) ;	
		locale = ((String)session.getAttribute("LOCALE"));
		login_user = p.getProperty( "login_user" ) ;

           llogin_user=""+session.getValue( "login_user" ) ;	
		Connection con = ConnectionManager.getConnection(req);		

		try 
		{
			//out = res.getWriter();
				
			//eBT.LogFile.log("QADebugger","Process Starting", this);
 

            InputSource inputSource=new InputSource(req.getReader());
			Vector vector=new Vector(1);		

	try{

			hashElement=masterXMLParse.parseXMLData(inputSource,null,vector);	
			//eBT.LogFile.log("QADebugger","successfully parsed", this);



	  	}catch(Exception ee)
			{
					//eBT.LogFile.log("QADebugger",""+ee, this);
			}
			
			//debugging code 
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

							
						rec_id=""+masterHashElement.get("CHECKBOX_SEL");
						facility_id=""+masterHashElement.get("FACILITY_ID");
						patient_id=""+masterHashElement.get("PATIENT_ID");
						strPrintMode=""+masterHashElement.get("PRINT_MODE");
						strFID=""+masterHashElement.get("FID");
// System.out.println("EBT :  REC ID"+rec_id+"  facility "+facility_id+" patient_id "+patient_id);

//Depend on Request and Reprint mode access this if loop condition
		if(strPrintMode.equals("REQUEST")==true)
			{

						strTokenizer=new StringTokenizer(rec_id,",");
						query="update BT_UNIT_REQUEST_DTL set REQUEST_FOR_ISSUE_BY =?,REQUEST_FOR_ISSUE_DATE=SYSDATE where rowid=?";
						//query="update BT_UNIT_REQUEST_DTL set REQUEST_FOR_ISSUE_DATE=SYSDATE, REQUEST_FOR_ISSUE_BY=? where rowid=?";
						pstmt=con.prepareCall(query);

	

						while(strTokenizer.hasMoreTokens())
					{
							
						rowid=strTokenizer.nextToken();

						pstmt.setString(1,login_user);
						pstmt.setString(2,rowid);

						//eBT.LogFile.log("QADebugger",""+query+" login_user"+login_user+"  rowid "+rowid, this);
						pstmt.executeUpdate();
					}
						pstmt.close();
						pstmt=null;

			}
	
				strSessionId=getSessionId(con);
				strFrmDate=getFormatDate(con);

					
					commonData.put("PGM_ID","BTRCOLRQ");
					commonData.put("SESSION_ID",strSessionId);
					commonData.put("PGM_DATE",strFrmDate);
					commonData.put("PARAM1",facility_id);
					commonData.put("PARAM2",patient_id);
					commonData.put("PARAM3",llogin_user);
					commonData.put("PARAM4",strFID);

		//System.out.println("EBT  pgm_Date"+strFrmDate+"  session_id "+strSessionId+" facility_id  "+facility_id);

			//		System.out.println("EBT value Appllogin user"+login_user+"Data base user "+llogin_user);
				PreparedStatement prepareStatement=null;				

				for(int i=0;i<detailVector.size();i++)
				{
					subHashElement=(Hashtable)detailVector.get(i);

					query=eBT.BTMasterTableList.frameMasterInsertQuery("query",commonData,subHashElement);

					//eBT.LogFile.log("QADebugger","Query="+query, this);
			         prepareStatement=con.prepareCall(query);
					prepareStatement.executeUpdate();
					prepareStatement.close();
				}

				con.commit();			
				
			eBT.BTReportServlet ebtr=new eBT.BTReportServlet();		

			ebtr.callReport(req,res,facility_id,strFrmDate,strSessionId,locale);


			eBT.BTDBDisConnectAdapter.closeCursor(prepareStatement);
			//eBT.LogFile.log("QADebugger","<------------closed---------->", this);
			


	ConnectionManager.returnConnection(con, req);
	//eBT.LogFile.log("QADebugger","%%%%@@@@@@connectionreturned@@@@@%%%%%%", this);
	
		}
	catch(Exception e)
	{
			//debug(e+"");;


				//eBT.LogFile.log("QADebugger",""+e, this);
	}
	finally
	{
				
		ConnectionManager.returnConnection(con, req);
	}
				
	}


	private String getSessionId(Connection con)throws Exception
	{
	String sessionId="";
	PreparedStatement pstmt=con.prepareCall("select USERENV('SESSIONID') from dual");
	ResultSet rs=pstmt.executeQuery();
			while(rs.next())
				{
			sessionId=rs.getString(1);
				}
				rs.close();
				pstmt.close();
				pstmt=null;
	return sessionId;
	}
	
private String getFormatDate(Connection con)throws Exception
	{
	String frmDate="";
	PreparedStatement pstmt=con.prepareCall("select to_char(SYSDATE,'DDMMYYHH24MISS') from dual");
	ResultSet rs=pstmt.executeQuery();
			while(rs.next())
				{
			frmDate=rs.getString(1);
				}
				rs.close();
				pstmt.close();
				pstmt=null;
	return frmDate;
	}
	


}
