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

public class BTUnitCheckServlet extends javax.servlet.http.HttpServlet
{


public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out;


		eBT.MasterXMLParse masterXMLParse;
		masterXMLParse=new MasterXMLParse();

		//debug("Entering="+ (System.currentTimeMillis()) );
		//eBT.LogFile.log("QADebugger","Entering", this);

		Hashtable genHashElement=null,dataHashElement=null;

		
//		HttpSession session=req.getSession(false);

	//	res.setContentType("text/html");
		out=res.getWriter();

		//eBT.LogFile.log("QADebugger","Parser constructed successfully", this);




		//p = (java.util.Properties) session.getValue( "jdbc" ) ;		
		

		Connection con = ConnectionManager.getConnection(req);		

		try 
		{
	        InputSource inputSource=new InputSource(req.getReader());
			Vector vector=new Vector(1);		
	try{
		genHashElement=masterXMLParse.parseXMLData(inputSource,null,vector);	
		//eBT.LogFile.log("QADebugger","successfully parsed", this);
	  	}
		catch(Exception ee)
		{
		//eBT.LogFile.log("QADebugger",""+ee, this);
		}

			


			  Set set = genHashElement.keySet();
			  Iterator itr = set.iterator();

				while(itr.hasNext()){
					String key  = (String) itr.next();
					Object obj=genHashElement.get(key);
					if(obj instanceof Hashtable)
					dataHashElement = (Hashtable) genHashElement.get(key);
						}


			String strPatientId,strFacilityId,strSpecimenNo,strProductCode,strUnitNo,strExtTrans;//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			String strStat="",strErr="";


			
			strPatientId=""+dataHashElement.get("PATIENT_ID");
			strFacilityId=""+dataHashElement.get("OPERATING_FACILITY_ID");
			strSpecimenNo=""+dataHashElement.get("SPECIMEN_NO");
			strProductCode=""+dataHashElement.get("PRODUCT_CODE");
			strUnitNo=""+dataHashElement.get("UNIT_NO");
			strExtTrans=""+dataHashElement.get("EXTERNAL_TRANSFER"); //Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589


			out = res.getWriter();
				
			//eBT.LogFile.log("QADebugger","Process Starting",this);
 


		    String strxMatchResult	=	"N";
			PreparedStatement pst	=	null;
			ResultSet rsParam		=	null;

			try
			{
				pst		=	con.prepareStatement("SELECT nvl(XMATCH_RESULT_BEFORE_TRANS_YN,'N') From BT_Param");
				rsParam =	pst.executeQuery();

				if(rsParam != null && rsParam.next())
					strxMatchResult	=	rsParam.getString(1);
			}
			catch (Exception e22)
			{
				e22.printStackTrace(System.err);
				System.out.println( " Error from Getting BT Param " + e22.getMessage());
			}
			finally
			{
				if(rsParam != null) rsParam.close();
				if(pst != null) pst.close();
			}
		




				CallableStatement callableStatement=null;				

				//eBT.LogFile.log("QADebugger","Before",this);


				//if(strxMatchResult.equals("Y") ) //Modified by Ashwini on 22-May-2018 for ML-MMOH-CRF-0589
			//{
			
				//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
				if(("ExternalTransfer").equals(strExtTrans))
				{
					callableStatement=con.prepareCall("{ call BT_TRANSFER_COMMIT.BT_TRANSFER_UNIT_CHECK(?,?,?,?,?,?,?)}");
				}
				else if(("Y").equals(strxMatchResult))
				{
					callableStatement=con.prepareCall("{ call BT_TRANSFUSE_COMMIT.BT_TRANSFUSE_UNIT_CHECK(?,?,?,?,?,?,?)}");
				}

				if((("ExternalTransfer").equals(strExtTrans)) || (("Y").equals(strxMatchResult)))
				{

				callableStatement.setString(1,strFacilityId);
				callableStatement.setString(2,strPatientId);
				callableStatement.setString(3,strSpecimenNo);
				callableStatement.setString(4,strUnitNo);
				callableStatement.setString(5,strProductCode);
				
				//eBT.LogFile.log("QADebugger","INTER"+strFacilityId+"and"+strPatientId+"and"+strSpecimenNo+"and"+strUnitNo+"and"+strProductCode,this);

				callableStatement.registerOutParameter(6,Types.VARCHAR);
				callableStatement.registerOutParameter(7,Types.VARCHAR);				

				callableStatement.execute();

				//eBT.LogFile.log("QADebugger","After",this);

	
		     strStat= callableStatement.getString(6);
			 strErr=callableStatement.getString(7);

			 if(strStat==null||strStat.equalsIgnoreCase("null"))		  strStat=" ";
				
			if(strErr==null||strErr.equalsIgnoreCase("null"))		  strErr=" ";

	

			//eBT.LogFile.log("QADebugger","Stat value"+strStat,this);
			//eBT.LogFile.log("QADebugger","Err value"+strErr,this);


			if(strStat!=null )    out.print(strStat+"||"+strErr);
			

	

		//	eBT.BTDBDisConnectAdapter.closeCursor(callableStatement);			
		callableStatement.close();
			//eBT.LogFile.log("QADebugger","<------------closed---------->", this);
	
			//eBT.LogFile.log("QADebugger","%%%%@@@@@@connectionreturned@@@@@%%%%%%", this);
			}
		//}
		}
		catch(Exception e)
		{
			//debug(e+"");;

				//eBT.LogFile.log("QADebugger",""+e, this);
				out.print("0");
		}
		finally
		{
			try
			{
			
				ConnectionManager.returnConnection(con, req);
			}
			catch(Exception er)
			{
			}
		}
	}

}

