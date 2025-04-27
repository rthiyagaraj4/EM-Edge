/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
/*import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eCommon.Common.*;
import eOT.*;*/

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import eST.OTTransactionBean;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;



public class PickListReviewServlet extends javax.servlet.http.HttpServlet{

public void init(ServletConfig config) throws ServletException{
		super.init(config);
}


	public String checkForNull(String value){
		if( value ==null|| value.equals("null")||value.length()==0)
			return "";
		else   
			return value;
	}

public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
Connection conn=null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
PreparedStatement pstmt2=null;
PreparedStatement pstmt_doc_type=null;
PreparedStatement pstmt_patclass_encid=null;
PreparedStatement pstmt_mmitem=null;
ResultSet rset=null;
ResultSet rset_patclass_encid=null;
ResultSet rset_mmitem=null;



try	{
req.setCharacterEncoding("UTF-8");
res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
PrintWriter out=res.getWriter();
conn = ConnectionManager.getConnection(req);
String strFacilityId="";
String strClientAddress="";
String login_user="";
String locale="";
String err_text= "";
	String err_desc= "";
String strPatientId="";
String strSurgeryDate="";
String strSurgeonCode="";
String strBookingNo="";
String strOperCode="";
String strItemType="";
String strItemId="";
String strNoOfUnits="";
String strStatus="";//Added by MuthuN
String strRequestNo="";//Added by MuthuN
String strrequeststore="";
String strissuing_store="";
String strreserve_qty="";
String strrequest_qty="";
String strFinalizedYN="";
String strDbMode="";
String sql1="";
String sql="";
String sql2="";
String strfrom_val="";
String St_module_install="";
String st_interface_flag="";
String st_doc_type_rti="";
String st_doc_type_sli="";
String doc_creation_for="";
String patient_class="";
String encounter_id="";
String sal_trn_type="";
String mm_item_code="";
String doc_no="";
String req_doc_no="";
String req_doc_no1="";

strPatientId=checkForNull(req.getParameter("patient_id"));
strSurgeryDate=checkForNull(req.getParameter("surgery_date"));
strSurgeonCode=checkForNull(req.getParameter("surgeoncode"));
strBookingNo=checkForNull(req.getParameter("booking_no"));
strOperCode=checkForNull(req.getParameter("oper_code"));
strfrom_val=checkForNull(req.getParameter("from_val"));
St_module_install=checkForNull(req.getParameter("St_module_install"));
st_interface_flag=checkForNull(req.getParameter("st_interface_flag"));



int cou=0;

eOT.MasterXMLParse masterParse=null;
InputSource inputSource=null;
HashMap hashElement=null;
ArrayList tabData=null;
boolean result=true;
String msg ="";

HttpSession session=req.getSession(true);
strFacilityId=""+session.getAttribute("facility_id");
Properties p=(Properties)session.getAttribute("jdbc");
strClientAddress=""+p.getProperty("client_ip_address");
login_user=""+p.getProperty("login_user");
locale = p.getProperty("LOCALE");


 masterParse=new MasterXMLParse();
 inputSource=new InputSource(req.getReader());
 hashElement=masterParse.parseXMLData(inputSource,null,null,eOT.MasterXMLParse.DETAIL_ONLY);	
 tabData=(ArrayList)hashElement.get("SEARCH");




if(strfrom_val.equals("PI") && st_interface_flag.equals("Y"))
	{
		
	}else
	{
		//sql=" INSERT INTO OT_PICK_LISTS (OPERATING_FACILITY_ID, PATIENT_ID, SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM,OPER_CODE, ITEM_TYPE,ITEM_ID,NO_OF_UNITS,FINALIZED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?, ?,SYSDATE,?,?,?,SYSDATE,?,?)";
		//CSSD_REQUEST_NO & CSSD_STATUS is added Newly for CRF-268
		sql=" INSERT INTO OT_PICK_LISTS (OPERATING_FACILITY_ID, PATIENT_ID, SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM,OPER_CODE, ITEM_TYPE,ITEM_ID,NO_OF_UNITS,CSSD_STATUS,CSSD_REQUEST_NO,FINALIZED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
	}

sql1="update  OT_PICK_LISTS set FINALIZED_YN='Y' WHERE 	OPERATING_FACILITY_ID 	= ? AND  OPER_CODE = ? AND	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";

/* Below Query is Modified by MuthuN against CRF-268 - Updating CSSD_STATUS & CSSD_REQUEST_NO */
sql1="update  OT_PICK_LISTS set FINALIZED_YN='Y', CSSD_STATUS=?, CSSD_REQUEST_NO=?  WHERE 	OPERATING_FACILITY_ID 	= ? AND  OPER_CODE = ? AND	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";


	if(strfrom_val.equals("PI") && st_interface_flag.equals("Y"))
	{
String sql_doc_type="SELECT ST_DOC_TYPE_RTI,ST_DOC_TYPE_SLI  FROM ot_param_for_facility WHERE OPERATING_FACILITY_ID='"+strFacilityId+"'";

pstmt_doc_type=conn.prepareCall(sql_doc_type);
rset=pstmt_doc_type.executeQuery();

if(rset !=null && rset.next())
{
	st_doc_type_rti =rset.getString("ST_DOC_TYPE_RTI");
	st_doc_type_sli=rset.getString("ST_DOC_TYPE_SLI");
}

String sql_patclass_encid="select PATIENT_CLASS ,ENCOUNTER_ID from ot_booking_hdr where BOOKING_NUM='"+strBookingNo+"' and OPERATING_FACILITY_ID='"+strFacilityId+"'";
pstmt_patclass_encid=conn.prepareCall(sql_patclass_encid);
rset_patclass_encid=pstmt_patclass_encid.executeQuery();

if(rset_patclass_encid !=null && rset_patclass_encid.next())
{
	patient_class =rset_patclass_encid.getString("PATIENT_CLASS");
	encounter_id=rset_patclass_encid.getString("ENCOUNTER_ID");
}


String sql_mmitem="SELECT MM_ITEM_CODE FROM OT_PROSTHESIS WHERE PROSTHESIS_CODE=?";
pstmt_mmitem=conn.prepareCall(sql_mmitem);

if(patient_class.equals("IP"))
{
	sal_trn_type="I";
}else if(patient_class.equals("OP"))
{
sal_trn_type="O";
}else if(patient_class.equals("EM"))
{
sal_trn_type="E";
}else if(patient_class.equals("DC"))
{
sal_trn_type="D";
}else if(patient_class.equals("XT"))
{
sal_trn_type="R";
}

	}

		HashMap hm =new HashMap();	
		HashMap hmData =new HashMap();	
		HashMap hmHdrData =new HashMap();	
		HashMap alReqHdrData =new HashMap();	
		HashMap alDtlRecords =new HashMap();	
	
		String bean_id 				    = "ottransactionbean";
		String bean_name 			    = "eST.OTTransactionBean";

		eST.OTTransactionBean reqBean = (eST.OTTransactionBean) 
		com.ehis.persist.PersistenceHelper.getBeanObject(bean_id, bean_name, req);
		reqBean.setLanguageId(locale);


pstmt1=conn.prepareCall(sql1);
			
HashMap hashDtl;

for( cou=0;cou<tabData.size();cou++)
	{
hashDtl=(HashMap)tabData.get(cou);
strItemType=checkForNull(""+hashDtl.get("item_type"));
strItemId=checkForNull(""+hashDtl.get("item_id"));
strNoOfUnits=checkForNull(""+hashDtl.get("no_units"));
strStatus=checkForNull(""+hashDtl.get("status"));//Added Muthu
strRequestNo=checkForNull(""+hashDtl.get("request_no"));//Added Muthu

if(strItemType.equals("I") ||  strItemType.equals("P"))
	strFinalizedYN=(strStatus.equals("F")?"Y":"N");
else
	strFinalizedYN=checkForNull(""+hashDtl.get("finalize_yn"));
strDbMode=checkForNull(""+hashDtl.get("db_mode"));
strrequeststore=checkForNull(""+hashDtl.get("requeststore"));
strissuing_store=checkForNull(""+hashDtl.get("issuing_store"));
strreserve_qty=checkForNull(""+hashDtl.get("reserve_qty"));
strrequest_qty=checkForNull(""+hashDtl.get("request_qty"));

if(strDbMode.equals("NW"))
		{
	if(strfrom_val.equals("PI") && st_interface_flag.equals("Y"))
	{
	pstmt_mmitem.setString(1,strItemId);
	rset_mmitem=pstmt_mmitem.executeQuery();
if(rset_mmitem !=null && rset_mmitem.next())
{
	mm_item_code =rset_mmitem.getString("MM_ITEM_CODE");
}


	if(!strreserve_qty.equals("") && !strrequest_qty.equals(""))
	{
		doc_creation_for="B";
	}else if(!strreserve_qty.equals("") && strrequest_qty.equals(""))
	{
		doc_creation_for="S";
	}else if(!strrequest_qty.equals("") && strreserve_qty.equals(""))
	{
		doc_creation_for="R";
	}


if(!strFinalizedYN.equals("Y"))
		{
sql=" INSERT INTO OT_PICK_LISTS (OPERATING_FACILITY_ID, PATIENT_ID, SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM,OPER_CODE, ITEM_TYPE,ITEM_ID,NO_OF_UNITS,FINALIZED_YN,  REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		}else
		{
if(doc_creation_for.equals("B"))
		{
sql=" INSERT INTO OT_PICK_LISTS (OPERATING_FACILITY_ID, PATIENT_ID, SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM,OPER_CODE, ITEM_TYPE,ITEM_ID,NO_OF_UNITS,FINALIZED_YN,  REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY,SALE_DOCUMENT_TYPE,SALE_DOCUMENT_NO,REQ_DOCUMENT_TYPE,REQ_DOCUMENT_NO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		}else if(doc_creation_for.equals("S"))
		{
sql=" INSERT INTO OT_PICK_LISTS (OPERATING_FACILITY_ID, PATIENT_ID, SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM,OPER_CODE, ITEM_TYPE,ITEM_ID,NO_OF_UNITS,FINALIZED_YN,  REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY,SALE_DOCUMENT_TYPE,SALE_DOCUMENT_NO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		}else if(doc_creation_for.equals("R"))
		{
sql=" INSERT INTO OT_PICK_LISTS (OPERATING_FACILITY_ID, PATIENT_ID, SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM,OPER_CODE, ITEM_TYPE,ITEM_ID,NO_OF_UNITS,FINALIZED_YN,  REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY,REQ_DOCUMENT_TYPE,REQ_DOCUMENT_NO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		}else 
		{
			sql=" INSERT INTO OT_PICK_LISTS (OPERATING_FACILITY_ID, PATIENT_ID, SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM,OPER_CODE, ITEM_TYPE,ITEM_ID,NO_OF_UNITS,FINALIZED_YN,  REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		}
		}


pstmt=conn.prepareCall(sql);


if(!strFinalizedYN.equals("Y"))
{
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strPatientId);
		pstmt.setString(3,strSurgeryDate);
		pstmt.setString(4,strSurgeonCode);
		pstmt.setString(5,strBookingNo);
		pstmt.setString(6,strOperCode);


		//Hashtable
		pstmt.setString(7,strItemType);
		pstmt.setString(8,strItemId);
		pstmt.setString(9,strNoOfUnits);
		pstmt.setString(10,strFinalizedYN);
		pstmt.setString(11,strrequeststore);
		pstmt.setString(12,strissuing_store);
		pstmt.setString(13,strreserve_qty);
		pstmt.setString(14,strrequest_qty);
		//Normal
		pstmt.setString(15,login_user);
		pstmt.setString(16,strClientAddress);
		pstmt.setString(17,strFacilityId);
		pstmt.setString(18,login_user);
		pstmt.setString(19,strClientAddress);
		pstmt.setString(20,strFacilityId);

}else 
{
		ArrayList alReqHdrData1		= new ArrayList();
		ArrayList alDtlRecords1		= new ArrayList();
try
{
	

		hmHdrData.put("MODE","I");
		hmHdrData.put("SAL_DOC_TYPE_CODE",st_doc_type_sli);
		hmHdrData.put("REQUEST_BY_STORE",strrequeststore);
		hmHdrData.put("PATIENT_ID",strPatientId);
		hmHdrData.put("ENCOUNTER_ID",encounter_id);
		hmHdrData.put("SAL_TRN_TYPE",sal_trn_type);
		hmHdrData.put("DOC_CREATION_FOR",doc_creation_for);


		alReqHdrData.put("REQ_DOC_TYPE_CODE",st_doc_type_rti);
		alReqHdrData.put("REQUEST_BY_STORE",strrequeststore);
		alReqHdrData.put("REQUEST_ON_STORE",strissuing_store);
		alReqHdrData1.add(alReqHdrData);


		alDtlRecords.put("UOM_CODE","");
		alDtlRecords.put("RESERVE_QTY",strreserve_qty);
		alDtlRecords.put("ITEM_UNIT_COST","");
		alDtlRecords.put("ITEM_CODE", mm_item_code);
		alDtlRecords.put("REQUEST_QTY",strrequest_qty);
		alDtlRecords.put("REQUEST_ON_STORE",strissuing_store);
		alDtlRecords1.add(alDtlRecords);


		hmData.put("REQ_HDR_DATA",alReqHdrData1);
		hmData.put("SAL_HDR_DATA",hmHdrData);
		hmData.put("DTL_DATA",alDtlRecords1);



		hm = reqBean.requestForOT(hmData,conn);

 req_doc_no=CommonBean.checkForNull(((String)hm.get("req_doc_no")));

 result=((Boolean) hm.get("result"));

	 err_text += CommonBean.checkForNull(((String) hm.get("msgid")));
err_text += CommonBean.checkForNull(((String) hm.get("message")));

 msg = CommonBean.checkForNull(((String) hm.get("msgid")));
 if(hm.containsKey("doc_no")){
 doc_no= CommonBean.checkForNull(((String)((ArrayList)hm.get("doc_no")).get(0)).toString());
 }
}
catch (Exception e)
{
	e.printStackTrace();
				//System.err.println("msg in else part result false=="+msg);
				result=false;
}



if(result==true)
	{


	if(!req_doc_no.equals(""))
	{
		int len=req_doc_no.length();
		req_doc_no=req_doc_no.substring(0,len-1);
	}

	if(doc_creation_for.equals("B"))
	{
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strPatientId);
		pstmt.setString(3,strSurgeryDate);
		pstmt.setString(4,strSurgeonCode);
		pstmt.setString(5,strBookingNo);
		pstmt.setString(6,strOperCode);
		//Hashtable
		pstmt.setString(7,strItemType);
		pstmt.setString(8,strItemId);
		pstmt.setString(9,strNoOfUnits);
		pstmt.setString(10,strFinalizedYN);
		pstmt.setString(11,strrequeststore);
		pstmt.setString(12,strissuing_store);
		pstmt.setString(13,strreserve_qty);
		pstmt.setString(14,strrequest_qty);
		//St values
		pstmt.setString(15,st_doc_type_sli);
		pstmt.setString(16,doc_no);
		pstmt.setString(17,st_doc_type_rti);
		pstmt.setString(18,req_doc_no);
		//Normal
		pstmt.setString(19,login_user);
		pstmt.setString(20,strClientAddress);
		pstmt.setString(21,strFacilityId);
		pstmt.setString(22,login_user);
		pstmt.setString(23,strClientAddress);
		pstmt.setString(24,strFacilityId);
	}else if(doc_creation_for.equals("S"))
	{
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strPatientId);
		pstmt.setString(3,strSurgeryDate);
		pstmt.setString(4,strSurgeonCode);
		pstmt.setString(5,strBookingNo);
		pstmt.setString(6,strOperCode);
		//Hashtable
		pstmt.setString(7,strItemType);
		pstmt.setString(8,strItemId);
		pstmt.setString(9,strNoOfUnits);
		pstmt.setString(10,strFinalizedYN);
		pstmt.setString(11,strrequeststore);
		pstmt.setString(12,strissuing_store);
		pstmt.setString(13,strreserve_qty);
		pstmt.setString(14,strrequest_qty);
		//St values
		pstmt.setString(15,st_doc_type_sli);
		pstmt.setString(16,doc_no);
		//Normal
		pstmt.setString(17,login_user);
		pstmt.setString(18,strClientAddress);
		pstmt.setString(19,strFacilityId);
		pstmt.setString(20,login_user);
		pstmt.setString(21,strClientAddress);
		pstmt.setString(22,strFacilityId);
	}else if(doc_creation_for.equals("R"))
	{
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strPatientId);
		pstmt.setString(3,strSurgeryDate);
		pstmt.setString(4,strSurgeonCode);
		pstmt.setString(5,strBookingNo);
		pstmt.setString(6,strOperCode);
		//Hashtable
		pstmt.setString(7,strItemType);
		pstmt.setString(8,strItemId);
		pstmt.setString(9,strNoOfUnits);
		pstmt.setString(10,strFinalizedYN);
		pstmt.setString(11,strrequeststore);
		pstmt.setString(12,strissuing_store);
		pstmt.setString(13,strreserve_qty);
		pstmt.setString(14,strrequest_qty);
		//St values
		pstmt.setString(15,st_doc_type_rti);
		pstmt.setString(16,req_doc_no);
		//Normal
		pstmt.setString(17,login_user);
		pstmt.setString(18,strClientAddress);
		pstmt.setString(19,strFacilityId);
		pstmt.setString(20,login_user);
		pstmt.setString(21,strClientAddress);
		pstmt.setString(22,strFacilityId);


	}else
	{

		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strPatientId);
		pstmt.setString(3,strSurgeryDate);
		pstmt.setString(4,strSurgeonCode);
		pstmt.setString(5,strBookingNo);
		pstmt.setString(6,strOperCode);


		//Hashtable
		pstmt.setString(7,strItemType);
		pstmt.setString(8,strItemId);
		pstmt.setString(9,strNoOfUnits);
		pstmt.setString(10,strFinalizedYN);
		pstmt.setString(11,strrequeststore);
		pstmt.setString(12,strissuing_store);
		pstmt.setString(13,strreserve_qty);
		pstmt.setString(14,strrequest_qty);
		//Normal
		pstmt.setString(15,login_user);
		pstmt.setString(16,strClientAddress);
		pstmt.setString(17,strFacilityId);
		pstmt.setString(18,login_user);
		pstmt.setString(19,strClientAddress);
		pstmt.setString(20,strFacilityId);

	}

	}
}

if(result==true)
	{
				pstmt.execute();

	}else
	{
				err_desc+=getMessag(msg);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
			//	con.rollback();
				
				out.println(err_desc);
		
		
		//con.rollback();
		//out.println(msg);

	}

	}else
	{
pstmt=conn.prepareCall(sql);

pstmt.setString(1,strFacilityId);
pstmt.setString(2,strPatientId);
pstmt.setString(3,strSurgeryDate);
pstmt.setString(4,strSurgeonCode);
pstmt.setString(5,strBookingNo);
pstmt.setString(6,strOperCode);
//Hashtable
pstmt.setString(7,strItemType);
pstmt.setString(8,strItemId);
pstmt.setString(9,strNoOfUnits);
pstmt.setString(10,strStatus);//Added By MuthuN CSSD_STATUS
pstmt.setString(11,strRequestNo);//Added By MuthuN CSSD_REQUEST_NO
pstmt.setString(12,strFinalizedYN);

//Normal
pstmt.setString(13,login_user);
pstmt.setString(14,strClientAddress);
pstmt.setString(15,strFacilityId);
pstmt.setString(16,login_user);
pstmt.setString(17,strClientAddress);
pstmt.setString(18,strFacilityId);
pstmt.execute();

	}
	}
	else
if(strDbMode.equals("DB"))
	{
		/*pstmt1.setString(1,strFacilityId);
		pstmt1.setString(2,strOperCode);
		pstmt1.setString(3,strItemType);
		pstmt1.setString(4,strItemId);
		pstmt1.setString(5,strBookingNo);*/

		pstmt1.setString(1,strStatus);//Added By MuthuN
		pstmt1.setString(2,strRequestNo);//Added By MuthuN
		pstmt1.setString(3,strFacilityId);
		pstmt1.setString(4,strOperCode);
		pstmt1.setString(5,strItemType);
		pstmt1.setString(6,strItemId);
		pstmt1.setString(7,strBookingNo);
		pstmt1.execute();
   }
  else if(strDbMode.equals("DBU"))
{

	  if(strfrom_val.equals("PI") && st_interface_flag.equals("Y"))
	{
	

	if(rset_mmitem !=null) rset_mmitem.close();
	if(pstmt !=null) pstmt.close();
		  if(!strFinalizedYN.equals("Y"))
		{
			sql2="update  OT_PICK_LISTS set FINALIZED_YN=?,NO_OF_UNITS=?,REQ_STORE_CODE=?,REQ_ON_STORE_CODE=?,RESERVED_QTY=?,REQUESTED_QTY=? WHERE  OPERATING_FACILITY_ID 	= ? AND  OPER_CODE = ? AND 	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";
		}else
		{
			pstmt_mmitem.setString(1,strItemId);
			rset_mmitem=pstmt_mmitem.executeQuery();
		if(rset_mmitem !=null && rset_mmitem.next())
		{
			mm_item_code =rset_mmitem.getString("MM_ITEM_CODE");
		}
			if(!strreserve_qty.equals("") && !strrequest_qty.equals(""))
			{
				doc_creation_for="B";
			}else if(!strreserve_qty.equals("") && strrequest_qty.equals(""))
			{
				doc_creation_for="S";
			}else if(!strrequest_qty.equals("") && strreserve_qty.equals(""))
			{
				doc_creation_for="R";
			}

		if(doc_creation_for.equals("B"))
			{

			sql2="update  OT_PICK_LISTS set FINALIZED_YN=?,NO_OF_UNITS=?,REQ_STORE_CODE=?,REQ_ON_STORE_CODE=?,RESERVED_QTY=?,REQUESTED_QTY=?,SALE_DOCUMENT_TYPE=?,SALE_DOCUMENT_NO=?,REQ_DOCUMENT_TYPE=?,REQ_DOCUMENT_NO=? WHERE  OPERATING_FACILITY_ID 	= ? AND  OPER_CODE = ? AND 	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";
			}else if(doc_creation_for.equals("S"))
			{
			sql2="update  OT_PICK_LISTS set FINALIZED_YN=?,NO_OF_UNITS=?,REQ_STORE_CODE=?,REQ_ON_STORE_CODE=?,RESERVED_QTY=?,REQUESTED_QTY=?,SALE_DOCUMENT_TYPE=?, SALE_DOCUMENT_NO=? WHERE  OPERATING_FACILITY_ID 	= ? AND  OPER_CODE = ? AND 	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";
			}else if(doc_creation_for.equals("R"))
			{
			sql2="update  OT_PICK_LISTS set FINALIZED_YN=?,NO_OF_UNITS=?,REQ_STORE_CODE=?,REQ_ON_STORE_CODE=?,RESERVED_QTY=?,REQUESTED_QTY=?,REQ_DOCUMENT_TYPE=?,REQ_DOCUMENT_NO=? WHERE  OPERATING_FACILITY_ID 	= ? AND  OPER_CODE = ? AND 	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";
			}

		}
		  pstmt2=conn.prepareCall(sql2);



		  if(!strFinalizedYN.equals("Y"))
		{
	    pstmt2.setString(1,strFinalizedYN);
	    pstmt2.setString(2,strNoOfUnits);
	    pstmt2.setString(3,strrequeststore);
	    pstmt2.setString(4,strissuing_store);
	    pstmt2.setString(5,strreserve_qty);
	    pstmt2.setString(6,strrequest_qty);
	  	pstmt2.setString(7,strFacilityId);
		pstmt2.setString(8,strOperCode);
		pstmt2.setString(9,strItemType);
		pstmt2.setString(10,strItemId);
		pstmt2.setString(11,strBookingNo);
		}else
		{
				ArrayList alReqHdrData1		= new ArrayList();
		ArrayList alDtlRecords1		= new ArrayList();
		try
		{
			hmHdrData.put("MODE","I");
			hmHdrData.put("SAL_DOC_TYPE_CODE",st_doc_type_sli);
			hmHdrData.put("REQUEST_BY_STORE",strrequeststore);
			hmHdrData.put("PATIENT_ID",strPatientId);
			hmHdrData.put("ENCOUNTER_ID",encounter_id);
			hmHdrData.put("SAL_TRN_TYPE",sal_trn_type);
			hmHdrData.put("DOC_CREATION_FOR",doc_creation_for);

			alReqHdrData.put("REQ_DOC_TYPE_CODE",st_doc_type_rti);
			alReqHdrData.put("REQUEST_BY_STORE",strrequeststore);
			alReqHdrData.put("REQUEST_ON_STORE",strissuing_store);
			alReqHdrData1.add(alReqHdrData);

			alDtlRecords.put("UOM_CODE","");
			alDtlRecords.put("RESERVE_QTY",strreserve_qty);
			alDtlRecords.put("ITEM_UNIT_COST","");
			alDtlRecords.put("ITEM_CODE", mm_item_code);
			alDtlRecords.put("REQUEST_QTY",strrequest_qty);
			alDtlRecords.put("REQUEST_ON_STORE",strissuing_store);
			alDtlRecords1.add(alDtlRecords);

			hmData.put("REQ_HDR_DATA",alReqHdrData1);
			hmData.put("SAL_HDR_DATA",hmHdrData);
			hmData.put("DTL_DATA",alDtlRecords1);
			hm = reqBean.requestForOT(hmData,conn);


 req_doc_no=CommonBean.checkForNull(((String)hm.get("req_doc_no")));
 if(!req_doc_no.equals("")){

req_doc_no1=req_doc_no.substring(0,req_doc_no.length()-1);
 }

 result=((Boolean) hm.get("result"));
 err_text += CommonBean.checkForNull(((String) hm.get("msgid")));
err_text += CommonBean.checkForNull(((String) hm.get("message")));

 msg = CommonBean.checkForNull(((String) hm.get("msgid")));

if(hm.containsKey("doc_no")){
 doc_no=CommonBean.checkForNull(((String)((ArrayList)hm.get("doc_no")).get(0)).toString());

}

  }
catch (Exception e)
{
	e.printStackTrace();
	//System.err.println("msg in else part result false=="+e);
				result=false;
}

if(result==true)
	{

	



			if(doc_creation_for.equals("B"))
			{
				pstmt2.setString(1,strFinalizedYN);
				pstmt2.setString(2,strNoOfUnits);
				pstmt2.setString(3,strrequeststore);
				pstmt2.setString(4,strissuing_store);
				pstmt2.setString(5,strreserve_qty);
				pstmt2.setString(6,strrequest_qty);
				//ST VALUES
				pstmt2.setString(7,st_doc_type_sli);
				pstmt2.setString(8,doc_no);
				pstmt2.setString(9,st_doc_type_rti);
				pstmt2.setString(10,req_doc_no1);

				pstmt2.setString(11,strFacilityId);
				pstmt2.setString(12,strOperCode);
				pstmt2.setString(13,strItemType);
				pstmt2.setString(14,strItemId);
				pstmt2.setString(15,strBookingNo);




			}else if(doc_creation_for.equals("S"))
			{
				pstmt2.setString(1,strFinalizedYN);
				pstmt2.setString(2,strNoOfUnits);
				pstmt2.setString(3,strrequeststore);
				pstmt2.setString(4,strissuing_store);
				pstmt2.setString(5,strreserve_qty);
				pstmt2.setString(6,strrequest_qty);
				//ST VALUES
				pstmt2.setString(7,st_doc_type_sli);
				pstmt2.setString(8,doc_no);

				pstmt2.setString(9,strFacilityId);
				pstmt2.setString(10,strOperCode);
				pstmt2.setString(11,strItemType);
				pstmt2.setString(12,strItemId);
				pstmt2.setString(13,strBookingNo);
			}else if(doc_creation_for.equals("R"))
			{
			    pstmt2.setString(1,strFinalizedYN);
				pstmt2.setString(2,strNoOfUnits);
				pstmt2.setString(3,strrequeststore);
				pstmt2.setString(4,strissuing_store);
				pstmt2.setString(5,strreserve_qty);
				pstmt2.setString(6,strrequest_qty);
				//ST VALUES
				pstmt2.setString(7,st_doc_type_rti);
				pstmt2.setString(8,req_doc_no);

				pstmt2.setString(9,strFacilityId);
				pstmt2.setString(10,strOperCode);
				pstmt2.setString(11,strItemType);
				pstmt2.setString(12,strItemId);
				pstmt2.setString(13,strBookingNo);
			}
		}

	}
		 if(result==true)
	{
					pstmt2.execute();
				
	}else
	{
				err_desc+=getMessag(msg);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
			//	con.rollback();
				
				out.println(err_desc);

	}

	}else
	{


	//sql2="update  OT_PICK_LISTS set FINALIZED_YN=?,NO_OF_UNITS=? WHERE  OPERATING_FACILITY_ID 	= ? AND  OPER_CODE = ? AND	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";
	/*Below Query Changed by MuthuN against CRF-268 for CSSD_STATUS Value Update */
	sql2="update  OT_PICK_LISTS set FINALIZED_YN=?,NO_OF_UNITS=?, CSSD_STATUS=?, CSSD_REQUEST_NO =? WHERE OPERATING_FACILITY_ID	= ? AND  OPER_CODE = ? AND	ITEM_TYPE = ? AND ITEM_ID = ? AND BOOKING_NUM=?";

		pstmt2=conn.prepareCall(sql2);
		pstmt2.setString(1,strFinalizedYN);
	    pstmt2.setString(2,strNoOfUnits);
		pstmt2.setString(3,strStatus);//Added By MuthuN
		pstmt2.setString(4,strRequestNo);//Added By MuthuN
	  	pstmt2.setString(5,strFacilityId);
		pstmt2.setString(6,strOperCode);
		pstmt2.setString(7,strItemType);
		pstmt2.setString(8,strItemId);
		pstmt2.setString(9,strBookingNo);
		pstmt2.execute();
	}
		}
		
}

if(result==true)
	{
conn.commit();
out.println("Finalised Successfully");
	}


if(pstmt_doc_type!=null)pstmt_doc_type.close();
if(rset!=null)rset.close();
if(pstmt_patclass_encid!=null)pstmt_patclass_encid.close();
if(rset_patclass_encid!=null)rset_patclass_encid.close();
if(pstmt_mmitem!=null)pstmt_mmitem.close();
if(rset_mmitem!=null)rset_mmitem.close();
if(pstmt!=null)pstmt.close();
if(pstmt1!=null)pstmt1.close();
if(pstmt2!=null)pstmt2.close();

}catch(Exception ee)
	{
		ee.printStackTrace();
	//System.err.println(ee);
//eOT.LogFile.log("OTDebugger","Exception in Update"+ee,this);
try
		{
	conn.rollback();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
finally
		{
	if(conn!=null)
			ConnectionManager.returnConnection(conn, req);
		}
}

public  String getMessag(String msgid){
		Connection con = null;
		StringBuilder sbr = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String err_desc = "";
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
		con = ConnectionManager.getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,msgid);
		rst = pstmt.executeQuery();
		while(rst.next()){
		err_desc=CommonBean.checkForNull(rst.getString(1));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		try{
		sbr.setLength(0);
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		//con.close();
		if(con!=null)
		ConnectionManager.returnConnection(con); //Common-ICN-0052
		}catch(Exception e){e.printStackTrace();}
		}
		return err_desc;
   }

}
