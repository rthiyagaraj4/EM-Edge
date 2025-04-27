<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
03/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<head>
	<%  request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
		con =ConnectionManager.getConnection(request); 
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));     // label
		firstItem.add("patientClass");   //name of field
		firstItem.add("Select '*A' PATIENT_CLASS,'ALL' SHORT_DESC from dual union all select  PATIENT_CLASS, SHORT_DESC from AM_PATIENT_CLASS order by SHORT_DESC");
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels"));    // label
		secondItem.add("speciality");  //name of field
		secondItem.add("20");   // SIZE
		secondItem.add("20");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr
		
		ArrayList thirdItem = new ArrayList();		
		thirdItem.add("Text");          //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));    // label
		thirdItem.add("practType");  //name of field
		thirdItem.add("20");   // SIZE
		thirdItem.add("20");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr
		
		ArrayList fourthItem = new ArrayList();		
		fourthItem.add("Text");          //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));    // label
		fourthItem.add("practitionerId");  //name of field
		fourthItem.add("20");   // SIZE
		fourthItem.add("20");   //LENGTH
		finAr.add(fourthItem);    //add to ArrayList obj finAr

		ArrayList fifthItem = new ArrayList();		
		fifthItem.add("Text");          //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels"));    // label
		fifthItem.add("ageGrp");  //name of field
		fifthItem.add("20");   // SIZE
		fifthItem.add("20");   //LENGTH
		finAr.add(fifthItem);    //add to ArrayList obj finAr	
		
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Text");          //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels"));    // label
		sixthItem.add("summary");  //name of field
		sixthItem.add("20");   // SIZE
		sixthItem.add("20");   //LENGTH
		finAr.add(sixthItem);    //add to ArrayList obj finAr	

		String[] orderByCols =  new String[6];
		String[] orderByColVals =  new String[6];
		orderByCols[0]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"); 
		orderByCols[1]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels");
		orderByCols[2]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
		orderByCols[3]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		orderByCols[4]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels");
		orderByCols[5]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels");

		orderByColVals[0] = "PATIENT_CLASS_SHORT_DESC";
		orderByColVals[1] = "SPECIALITY_SHORT_DESC";	
		orderByColVals[2] = "PRACT_TYPE_DESC";
		orderByColVals[3] = "PRACTITIONER_NAME";
		orderByColVals[4] = "AGE_GROUP_SHORT_DESC";
		orderByColVals[5] = "SUMM_SHORT_DESC";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Chart","../../eCA/jsp/EncSummApplicabilityQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
		
		out.println(strbuff.toString());	

		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();	
		fifthItem.clear();
		sixthItem.clear();
	}
	catch(Exception ee)
	{
		//out.println("Exception in EncSummApplicabilityQueryCriteria Block : "+ee.toString());//COMMON-ICN-0181
                 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con); 
	}
%>

