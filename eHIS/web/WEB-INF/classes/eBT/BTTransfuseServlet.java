/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
---------------------------------------------------------------------------------------------
SNo		Version				TFS ID					CRF/SCF     			Developer Name
---------------------------------------------------------------------------------------------
1      	V210705/V210708		21185/21186			MMS-DM-SCF-0767-TF			MuthukumarN
---------------------------------------------------------------------------------------------
*/
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

//import oracle.aurora.jndi.sess_iiop.ServiceCtx;

public class BTTransfuseServlet extends javax.servlet.http.HttpServlet
{


public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

public void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	
	String transfuseRemarks="";
	PrintWriter out;
	String locale="";
	String strErr ="";
	String strOut ="";
	String p_error_text ="";//Added for MMs-DM-CRF-0157.3
	Hashtable hashElement=null,masterHashElement=null;

	Vector detailVector=new Vector(10,2);




	//eBT.MasterXMLParse masterXMLParse;
	eBT.MasterXMLParse masterXMLParse;





	//debug("Entering="+ (System.currentTimeMillis()) );
	//eBT.LogFile.log("QADebugger","Entering", this);

	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");


	
	HttpSession session=req.getSession(false);

//	res.setContentType("text/html");
	out=res.getWriter();
	//masterXMLParse=new eBT.MasterXMLParse();
	//out.print('1');

	masterXMLParse=new MasterXMLParse();
	//eBT.LogFile.log("QADebugger","Parser constructed successfully", this);





	String login_user="";


	String query="";
	String strClientIpAddress="";


	java.util.Properties p = null;

	p = (java.util.Properties) session.getValue( "jdbc" ) ;		
	login_user = p.getProperty( "login_user" ) ;
	strClientIpAddress=p.getProperty("client_ip_address");	
	locale = ((String)session.getAttribute("LOCALE"));
	Connection con = ConnectionManager.getConnection(req);		
	CallableStatement callableStatement=null;
	CallableStatement cs = null;//Addded for MMS-DM-CRF-0157.3	

	try 
	{
		out = res.getWriter();
			
		//eBT.LogFile.log("QADebugger","Process Starting", this);


		InputSource inputSource=new InputSource(req.getReader());
		Vector vector=new Vector(1);		

try{

		hashElement=masterXMLParse.parseXMLData(inputSource,null,vector);	
		//eBT.LogFile.log("QADebugger","successfully parsed", this);
	}catch(Exception ee)
		{
			ee.printStackTrace();
				//eBT.LogFile.log("QADebugger",""+ee, this);
		}
		
		//debugging code 
		  Set set = hashElement.keySet();
		  Iterator itr = set.iterator();

			while(itr.hasNext()){
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

			String barcode_scan_count_site_yn =""+masterHashElement.get("BARCODE_SCAN_COUNT_YN");//Added for MMs-DM-CRF-0157.3
			String entry_type =""+masterHashElement.get("ENTRY_TYPE");//Added for MMs-DM-CRF-0157.3
			System.err.println("147,entry_type==>"+entry_type);
			//Added against V210705/V210708
			//if(entry_type.equals(""))//Added for MMS-KH-SCF-100
			if(!entry_type.equals("S") || entry_type == null || entry_type.equals(""))
				entry_type ="M";
			System.err.println("152,entry_type==>"+entry_type);
			//Added against V210705/V210708
			String scan_count_required_yn =""+masterHashElement.get("SCAN_COUNT_REQUIRED_YN");//Added for MMs-DM-CRF-0170.2
//				query=eBT.BTMasterTableList.frameMasterInsertQuery("update",masterHashElement,null);

			query="{call BT_TRANSFUSE_COMMIT.main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			//eBT.LogFile.log("QADebugger","Query="+query, this);

			callableStatement=con.prepareCall(query);

			callableStatement.setString(1,""+masterHashElement.get("FACILITY_ID"));
			//eBT.LogFile.log("QADebugger","Facility"+masterHashElement.get("FACILITY_ID"), this);				

			callableStatement.setString(2,""+masterHashElement.get("SPECIMEN_NO"));
			//eBT.LogFile.log("QADebugger","Specimen_no"+masterHashElement.get("SPECIMEN_NO"), this);

			callableStatement.setString(3,""+masterHashElement.get("PATIENT_ID"));
			//eBT.LogFile.log("QADebugger","PATIENT_ID"+masterHashElement.get("PATIENT_ID"), this); 				

			callableStatement.setString(4,""+masterHashElement.get("UNIT_NO"));
			//eBT.LogFile.log("QADebugger","UNIT_NO"+masterHashElement.get("UNIT_NO"), this);

			callableStatement.setString(5,""+masterHashElement.get("PRODUCT_CODE"));
			//eBT.LogFile.log("QADebugger","PRODUCT_CODE"+masterHashElement.get("PRODUCT_CODE"), this);

			callableStatement.setString(6,strClientIpAddress);
			//eBT.LogFile.log("QADebugger","Address"+strClientIpAddress, this);

			callableStatement.setString(7,login_user);
			//eBT.LogFile.log("QADebugger","login_user"+login_user, this);

			callableStatement.setString(8,""+masterHashElement.get("TRANSFUSE_PRACT_ID"));
			//eBT.LogFile.log("QADebugger","TRANSFUSE_PRACT_ID"+masterHashElement.get("TRANSFUSE_PRACT_ID"), this);

			callableStatement.setString(9,""+masterHashElement.get("TRANSFUSE_PRACT_ID_2"));
			//eBT.LogFile.log("QADebugger","TRANSFUSE_PRACT_ID_2"+masterHashElement.get("TRANSFUSE_PRACT_ID_2"), this);

			callableStatement.setString(10,""+masterHashElement.get("CHECK_PRACT_ID"));
			//eBT.LogFile.log("QADebugger","TRANSFUSE_PRACT_ID_2"+masterHashElement.get("TRANSFUSE_PRACT_ID_2"), this);

			//			callableStatement.setString(11,""+masterHashElement.get("TRANSFUSE_ST_DATE_TIME"));
			//eBT.LogFile.log("QADebugger","startDate"+masterHashElement.get("TRANSFUSE_ST_DATE_TIME"), this);

			callableStatement.setString(11,com.ehis.util.DateUtils.convertDate(""+masterHashElement.get("TRANSFUSE_ST_DATE_TIME"),"DMYHM",locale,"en"));

			//callableStatement.setString(12,""+masterHashElement.get("TRANSFUSE_EN_DATE_TIME"));
			
			 callableStatement.setString(12,com.ehis.util.DateUtils.convertDate(""+masterHashElement.get("TRANSFUSE_EN_DATE_TIME"),"DMYHM",locale,"en"));

			//eBT.LogFile.log("QADebugger","endDate"+masterHashElement.get("TRANSFUSE_EN_DATE_TIME"), this);

			callableStatement.setString(13,""+masterHashElement.get("CURRENT_VOLUME"));
			//eBT.LogFile.log("QADebugger","CURRENT_VOLUME"+masterHashElement.get("CURRENT_VOLUME"), this);

			callableStatement.setString(14,""+masterHashElement.get("REACTION_CODE"));			
			//eBT.LogFile.log("QADebugger","REACTION_CODE"+masterHashElement.get("REACTION_CODE"), this);

			transfuseRemarks=""+masterHashElement.get("TRANSFUSION_REMARKS");
			transfuseRemarks = transfuseRemarks.replace('\"','\n');
			transfuseRemarks = transfuseRemarks.replace('^','\n'); 
			
			transfuseRemarks = transfuseRemarks.replace('\'','\n'); // Added by Niveditha for Blood Unit Consumption on 16/03/2020
			//System.out.println("transfuseRemarks---"+transfuseRemarks);			
			
			callableStatement.setString(15,transfuseRemarks);
			//eBT.LogFile.log("QADebugger","TRANSFUSION_REMARKS"+masterHashElement.get("TRANSFUSION_REMARKS"), this);

			callableStatement.setString(16,""+masterHashElement.get("LOCATION_CODE"));
			//eBT.LogFile.log("QADebugger","LOCATION_CODE"+masterHashElement.get("LOCATION_CODE"), this);

			callableStatement.registerOutParameter(17,Types.VARCHAR);
			callableStatement.registerOutParameter(18,Types.VARCHAR);
			callableStatement.setString(19,""+masterHashElement.get("DISC_CHECK"));
			callableStatement.setString(20,""+masterHashElement.get("TRANS_CODE"));

			callableStatement.executeQuery();

			strErr=callableStatement.getString(17);
			strOut=callableStatement.getString(18);
			callableStatement.close();

			con.commit();		

			if(strErr!= null && strErr.length() >0 && strErr.charAt(0) == 'E')
			{
				out.print(strOut);
			}	
		else if(barcode_scan_count_site_yn != null && barcode_scan_count_site_yn.equals("Y") && scan_count_required_yn.equals("Y")) {//Adding start for MMs-DM-CRF-0157.3//Added scan_count_required_yn  for MMs-DM-CRF-0170.2				
			cs = con.prepareCall("{call PR_INS_PR_BARCODE_SCAN_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?,?) }");
			cs.setString(1,""+masterHashElement.get("FACILITY_ID"));
			cs.setString(2,""+masterHashElement.get("MODULE_ID"));
			cs.setString(3,""+masterHashElement.get("MENU_ID"));
			cs.setString(4,"");
			cs.setString(5,""+masterHashElement.get("PATIENT_ID"));
			cs.setString(6,""+masterHashElement.get("ENCOUNTER_ID"));
			cs.setString(7,"");
			cs.setString(8,""+masterHashElement.get("PATIENT_CLASS"));//Passes patient class for MMS-DM-CRF-0170.2
			cs.setString(9,"");
			cs.setString(10,"");
			cs.setString(11,"");
			cs.setString(12,"");
			cs.setString(13,""+masterHashElement.get("UNIT_NO"));
			cs.setString(14,""+masterHashElement.get("SPECIMEN_NO"));
			//cs.setString(15,""+masterHashElement.get("ENTRY_TYPE"));//Commented against V210705/V210708
			cs.setString(15,""+entry_type);//Added against V210705/V210708
			System.err.println("261,entry_type==>"+entry_type);
			if(entry_type.equals("M")){
				cs.setString(16,""+masterHashElement.get("REASON_CODE"));
				cs.setString(17,""+masterHashElement.get("REASON_DESC"));
			}else{
				cs.setString(16,"");
				cs.setString(17,"");
			}
				cs.setString(18,login_user);
				cs.setString(19,strClientIpAddress);
				cs.setString(20,""+masterHashElement.get("FACILITY_ID"));
				cs.setString(21,login_user);
				cs.setString(22,strClientIpAddress);
				cs.setString(23,""+masterHashElement.get("FACILITY_ID"));
				cs.registerOutParameter(24,java.sql.Types.VARCHAR);
				cs.execute();

				p_error_text = cs.getString(24);
			if(p_error_text!= null && p_error_text.length() >0)
			{
				out.print(p_error_text);
			}else
				out.print("1");
		}else//Adding end for MMs-DM-CRF-0157.3
			out.print("1");
		//eBT.LogFile.log("QADebugger","<------------closed---------->", this);
		//eBT.LogFile.log("QADebugger","%%%%@@@@@@connectionreturned@@@@@%%%%%%", this);	
		}
		catch(Exception e)
		{
			//debug(e+"");;
			//eBT.LogFile.log("QADebugger",""+e, this);
			out.println("0");
			e.printStackTrace();
		}
		finally{
					eBT.BTDBDisConnectAdapter.closeCursor(callableStatement);
					ConnectionManager.returnConnection(con, req);
			}
	}
}
