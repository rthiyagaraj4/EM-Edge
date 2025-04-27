<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
06/08/2013		IN036733		Nijitha			Bru-HIMS-CRF-328
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

try 
{
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	
	//IN036733 Starts
	ArrayList facilityItem = new ArrayList();
	
	facilityItem.add("List");
	facilityItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));		 // label
	facilityItem.add("facility_id");		 // name of field
	facilityItem.add("SELECT '*A' FACILITY_ID,'ALL' FACILITY_NAME FROM dual union all SELECT FACILITY_ID,FACILITY_NAME from SM_FACILITY_PARAM WHERE STATUS='E'");			
	finAr.add(facilityItem);   
	//IN036733 Ends
	ArrayList firstItem = new ArrayList();

	firstItem.add("List");           // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));		 // label
	firstItem.add("patient_class");		 // name of field
	firstItem.add("Select '*A' PATIENT_CLASS,'ALL' SHORT_DESC from dual union all SELECT patient_class,short_desc FROM am_patient_class order by short_desc");			
	finAr.add(firstItem);            // add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");           // Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));			  // label
	secondItem.add("pract_type");	  // name of field
	secondItem.add("Select '*A' PATIENT_CLASS,'ALL' SHORT_DESC from dual union all select PRACT_TYPE, nvl(DESC_USERDEF, DESC_SYSDEF) pract_type_desc from am_pract_type where  EFF_STATUS ='E' order by 2");			  
	finAr.add(secondItem);            // add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");           // Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));		  // label
	thirdItem.add("practitioner_name");	  // name of field
	thirdItem.add("20");			  // SIZE
	thirdItem.add("20");             // LENGTH
	finAr.add(thirdItem);			//	add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");			//	Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.menu.label","common_labels"));		//	label
	fourthItem.add("menu_id");	//	name
	fourthItem.add("select menu_id,short_desc from ca_menu_header order by  short_desc");        
	finAr.add(fourthItem);			//	add to ArrayList obj finAr


	String[] orderByCols = null;
	String[] orderByColVals = null;

	//IN036733 Starts 
	//orderByCols = new String[4];
	//orderByColVals = new String[4];
	orderByCols = new String[5];
	orderByColVals = new String[5];
	//IN036733 Ends

	//IN036733 Starts
	/*orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.menu.label","common_labels");*/
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels");//
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.menu.label","common_labels");
	//IN036733 Ends

	//IN036733 Starts
	/*orderByColVals[0] = "patient_class_name";
	orderByColVals[1] = "pract_type_name";
	orderByColVals[2] = "pract_name";
	orderByColVals[3] = "menu_desc ";*/
	
	orderByColVals[0] = "facility_name";
	orderByColVals[1] = "patient_class_name";
	orderByColVals[2] = "pract_type_name";
	orderByColVals[3] = "pract_name";
	orderByColVals[4] = "menu_desc ";
	//IN036733 Ends

	strbuff = qrypg.getQueryPage(con,finAr,"AssignCA Menu","../../eCA/jsp/AssignCAMenuResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
}//end of try
catch (Exception e) 
{
	e.printStackTrace();
}
finally	
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

