<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
08/07/2020     IN072994          Chandrashekar raju                 Modified for MMS-DM-CRF-0170.1
--------------------------------------------------------------------------------------------------------------------------------
--> 

<%@ page import="java.sql.*,webbeans.eCommon.*, eOR.* , ePH.* " contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eOR/js/BarCodeManualEntryReason.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%

	Connection con = null;
	CallableStatement cs = null;	

	String facility_id = (String)session.getValue( "facility_id" );//GHL-CRF-0458
	System.err.println("facility_id@@@@==="+facility_id);
	Properties properties			= (Properties) session.getValue( "jdbc" );
	Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				  = (Hashtable)hash.get( "SEARCH" ) ;
		
	String bean_id       = (String)hash.get("bean_id")==null?"":(String)hash.get("bean_id");
	String bean_name     = (String)hash.get("bean_name")==null?"":(String)hash.get("bean_name");
	String patient_id    = (String)hash.get("patient_id")==null?"":(String)hash.get("patient_id");
	String encounter_id  = (String)hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");
	String menu_id       = (String)hash.get("menu_id")==null?"":(String)hash.get("menu_id");
	String sub_menu_id   = (String)hash.get("sub_menu_id")==null?"":(String)hash.get("sub_menu_id");
	String module_id     = (String)hash.get("module_id")==null?"":(String)hash.get("module_id");
	String reason_code   = (String)hash.get("reason_code")==null?"":(String)hash.get("reason_code");
	String reason_desc   = (String)hash.get("reason_desc")==null?"":(String)hash.get("reason_desc");
	String entry_type    = (String)hash.get("entry_type")==null?"":(String)hash.get("entry_type");
	String order_id      = (String)hash.get("order_id")==null?"":(String)hash.get("order_id");
	String order_line_no = (String)hash.get("order_line_no")==null?"":(String)hash.get("order_line_no");
	String item_code     = (String)hash.get("item_code")==null?"":(String)hash.get("item_code");
	String batch_id      = (String)hash.get("batch_id")==null?"":(String)hash.get("batch_id");
	String login_user    = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user");//IN061891
	String ws_no         =  properties.getProperty("client_ip_address");
	String patient_class = (String)hash.get("patient_class")==null?"":(String)hash.get("patient_class");
	String speciality    = (String)hash.get("speciality")==null?"":(String)hash.get("speciality");
	


if(reason_desc!=null && !reason_desc.equals(""))
	reason_desc = java.net.URLDecoder.decode(reason_desc,"UTF-8");
	System.err.println("reason_desc@@@@==="+reason_desc+"entry_type=="+entry_type);

	
	try
	{
		if(bean_id.equals("")){
		con = ConnectionManager.getConnection(request);
		cs = con.prepareCall("{call PR_INS_PR_BARCODE_SCAN_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?,?) }");
		cs.setString(1,facility_id);
		cs.setString(2,module_id);
		cs.setString(3,menu_id);
		cs.setString(4,sub_menu_id);
		cs.setString(5,patient_id);
		cs.setString(6,encounter_id);
		cs.setString(7,speciality);
		cs.setString(8,patient_class);
		cs.setString(9,"");
		cs.setString(10,"");
		cs.setString(11,"");
		cs.setString(12,"");
		cs.setString(13,"");
		cs.setString(14,"");
		cs.setString(15,entry_type);
		cs.setString(16,reason_code);
		cs.setString(17,reason_desc);
		cs.setString(18,login_user);
		cs.setString(19,ws_no);
		cs.setString(20,facility_id);
		cs.setString(21,login_user);
		cs.setString(22,ws_no);
		cs.setString(23,facility_id);
		cs.registerOutParameter(24,java.sql.Types.VARCHAR);
		cs.execute();

		String p_error_text = cs.getString(24);
		System.err.println("p_error_text@@@==="+p_error_text);
			
		if(cs!=null) cs.close();
		}
		else{
			System.err.println("bean_id@@@@@====="+bean_id);
			HashMap values	= new HashMap();
				values.put("patient_id" , patient_id);
				values.put("encounter_id" , encounter_id);							
				values.put("menu_id" , menu_id);
				values.put("sub_menu_id" , sub_menu_id);
				values.put("module_id" , module_id);
				values.put("resone_code" , reason_code);
				values.put("resone_desc" , reason_desc);
				values.put("entry_type",entry_type);
				values.put("order_id",order_id);
				values.put("order_line_no",order_line_no);
				values.put("item_code",item_code);
				values.put("batch_id",batch_id);
				values.put("patient_class",patient_class);
             if(bean_id.equals("Or_SpecimenOrder")){
	             SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id,  bean_name, request ) ;	
                  bean.setManualBarcodeRemarks(values);
			      putObjectInBean(bean_id,bean,request);
			 }
			if(bean_id.equals("MedicationAdministrationFTBean")){
				 MedicationAdministrationFTBean bean =(MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;
				  bean.setManualBarcodeRemarks(values);
			      putObjectInBean(bean_id,bean,request);
			 }
			 if(bean_id.equals("DispMedicationBean")){
				 DispMedicationBean bean =(DispMedicationBean)getBeanObject( bean_id,  bean_name, request ) ;
				  bean.setManualBarcodeRemarks(values);
				  System.err.println(bean.getManualBarcodeRemarks());
			      putObjectInBean(bean_id,bean,request);
			 }

		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		
    }
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</html>

