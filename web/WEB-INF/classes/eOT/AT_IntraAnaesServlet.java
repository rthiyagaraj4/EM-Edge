/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import com.ehis.eslp.ServiceLocator;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.InputSource;
import eOT.IntraAnaesthesia.*;
import eCommon.XSSRequestWrapper;
import eOT.*;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx;

public class AT_IntraAnaesServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		//Added Against MMS Vulnerability Issue - Starts
        req= new XSSRequestWrapper(req);
        res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends

		String anesthesia_srl_no  = req.getParameter("anesthesia_srl_no")==null?"":req.getParameter("anesthesia_srl_no");
		//String preop_asse_done_yn  = req.getParameter("preop_asse_done_yn")==null?"":req.getParameter("preop_asse_done_yn");

		//String preop_compl = ""
		String accession_num  = req.getParameter("accession_num")==null?"":req.getParameter("accession_num");
		//if("Y".equals(preop_asse_done_yn.equals) )
			//preop_compl = "SYSDATE";
		
		//String dtl_db_mode  = req.getParameter("dtl_db_mode")==null?"":req.getParameter("dtl_db_mode");

		String client_ip_address  ="";
		String login_user		  ="";
		String facility_id		  = "";

		java.util.Properties prop = null;
		PrintWriter out;
		HashMap sqlMap			  = new HashMap();
		HashMap CommonData		  =new HashMap();
		HashMap hashElement		  =null;

		HttpSession session=req.getSession(false);
		res.setContentType("text/html");
		out=res.getWriter();

		facility_id				= (String)session.getValue( "facility_id" ) ;
		prop					= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address		= prop.getProperty( "client_ip_address" );
		login_user				= prop.getProperty( "login_user" );
		
		eOT.MasterXMLParse masterXMLParse;
		masterXMLParse=new eOT.MasterXMLParse();
			
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("anesthesia_srl_no",anesthesia_srl_no);
		CommonData.put("accession_num",accession_num);

		try
		{
			ArrayList arrList= new ArrayList();

		/*	if(dtl_db_mode.equalsIgnoreCase("I"))
			{
				CommonData.put("AT_INTRA_OPER_DTLS","INSERT INTO AT_INTRA_OPER_DTLS(OPERATING_FACILITY_ID,ANAESTHESIA_SERIAL_NUM,ACCESSION_NUM,ECG_YN,NBP_YN,ABP_YN,CVP_YN,SAO2_YN,ETC02_YN, TEMP_C,TEMP_P,FIO2_YN, NO2_YN,AGENT_YN,BL_SUGAR_YN,URINE_OUT_PUT_YN,ABGA_YN,BLOCK_TYPE_CODE,RA_LEVEL,AIRWAY_CODE,LOSCOPIC_CODE,TUBE_CODE,CUFFED_YN,FIBREOPTIC_INTUBATION_YN,AWAKE_YN,SEDUCTION_YN,TRACH_LIGHT_YN,BLOOD_LOSS_MS,URINE_OUTPUT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ( ?,?,'2',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,? )");
				
			}
			else if(dtl_db_mode.equalsIgnoreCase("U"))
			{
				sqlMap.put("MONITOR_DTLS_I","UPDATE AT_INTRA_OPER_DTLS SET ECG_YN=?,NBP_YN=?,ABP_YN=?,CVP_YN=?,SAO2_YN=?,ETC02_YN=?, TEMP_C=?,TEMP_P=?,FIO2_YN=?, NO2_YN=?,AGENT_YN=?,BL_SUGAR_YN=?,URINE_OUT_PUT_YN=?,ABGA_YN=?,MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND ANAESTHESIA_SERIAL_NUM=?");
			
				sqlMap.put("BLOCK_TYPE_DTL_I","UPDATE AT_INTRA_OPER_DTLS SET BLOCK_TYPE_CODE=?,RA_LEVEL=?,MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND ANAESTHESIA_SERIAL_NUM=?");

				sqlMap.put("GENERAL_DETAIL_I","UPDATE AT_INTRA_OPER_DTLS SET AIRWAY_CODE=?,LOSCOPIC_CODE=?,TUBE_CODE=?,CUFFED_YN=?,FIBREOPTIC_INTUBATION_YN=?,AWAKE_YN=?, SEDUCTION_YN=?,TRACH_LIGHT_YN=?,MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND ANAESTHESIA_SERIAL_NUM=?");

				sqlMap.put("BLOOD_DTL_I","UPDATE AT_INTRA_OPER_DTLS SET BLOOD_LOSS_MS=?,URINE_OUTPUT=?,MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND ANAESTHESIA_SERIAL_NUM=?");

			}
			*/

			sqlMap.put("AT_ANAESTHESIA_RECORD_HDR_U","UPDATE AT_ANAESTHESIA_RECORD_HDR SET WEIGHT=?,HEIGHT=?,BSA=?,BMI=?,ANAESTHESIA_CODE=?,ANAESTHETIST1_CODE=?,ANAESTHETIST2_CODE=?,START_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), END_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') ,INTRAOP_DONE_YN=?, STATUS=?,MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ACCESSION_NUM=? WHERE OPERATING_FACILITY_ID=? AND ANAESTHESIA_SERIAL_NUM=?");

			/*sqlMap.put("OT_POST_OPER_HDR_U","UPDATE OT_POST_OPER_HDR SET ANESTHESIA_CODE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ANAESTHETIST_DOC_COMP_YN=?,ANAESTHETIST_DOC_COMP_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?");

			sqlMap.put("OT_QUEUE_U","UPDATE OT_QUEUE SET ANAESTHESIA_DOC_COMP_YN='Y'  WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?");*/

			sqlMap.put("OT_POST_OPER_PERSONNEL_I","INSERT INTO OT_POST_OPER_PERSONNEL(OPERATING_FACILITY_ID,OPER_NUM,SPECIALITY_CODE,ROLE_ID,ROLE_TYPE,PRACTITIONER_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ( ?,?,'*ALL',?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,? )");
			
			sqlMap.put("OT_POST_OPER_PERSONNEL_DUP","SELECT * FROM OT_POST_OPER_PERSONNEL WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM = ?        AND PRACTITIONER_ID = ?");

			sqlMap.put("AT_PERSONNEL_I","INSERT INTO AT_PERSONNEL(OPERATING_FACILITY_ID,ANAESTHESIA_SERIAL_NUM,PRACT_TYPE,ROLE_ID,PRACTITIONER_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ( ?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,? )");
			
			sqlMap.put("AT_PERSONNEL_D","DELETE FROM AT_PERSONNEL WHERE OPERATING_FACILITY_ID=? AND ANAESTHESIA_SERIAL_NUM=? AND PRACTITIONER_ID=? ");
			
			InputSource inputSource=new InputSource(req.getReader());
			hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);
			ArrayList tabData =(ArrayList) hashElement.get("SEARCH");

				boolean local_ejbs=isLocalEJB();

			//Lookup the Home Object using the Service locator pattern
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IntraAnaesthesia",IntraAnaesHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			Object busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
			//Create an object array, which will be passed as argument to the method call
			Object argArray[]  = new Object[4];
				   argArray[0] = tabData;				   
				   argArray[1] = sqlMap;
				   argArray[2] = CommonData;
				   argArray[3] = prop;

			//Create a class array, containing the class types of the arguments passed
			Class [] paramArray	   = new Class[4];
					 paramArray[0] = tabData.getClass();
					 paramArray[1] = sqlMap.getClass();
					 paramArray[2] = CommonData.getClass();
					 paramArray[3] = prop.getClass();

			//Invoke the business method on the EJB using the argument array, class	array and reflection
			String result =(String)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			//Call to remove the EJB
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			//Nullify the class and the object arrays
			argArray = null;
			paramArray = null;

			//Now Clean up the containers passed to the EJB
			tabData.clear();
			sqlMap.clear();
			CommonData.clear();
			out.println(result);
		 }catch(Exception ee){
			 System.err.println("Err in AT_IntraAnaesServlet"+ee.getMessage());
	 }
   }
	boolean isLocalEJB(){
        ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		return false;
	}
}



