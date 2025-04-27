<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<head>
<% 	request.setCharacterEncoding("UTF-8");	%>
	<%
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
try {
   con  =  ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("List");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));     // label
	firstItem.add("patclass");   //name of field
    firstItem.add("Select '*A' PATIENT_CLASS,'ALL' SHORT_DESC from dual union all select distinct PATIENT_CLASS,SHORT_DESC from AM_PATIENT_CLASS order by SHORT_DESC");
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));    // label
	secondItem.add("speciality");  //name of field
	secondItem.add("20");   // SIZE
	secondItem.add("20");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));  // label
	thirdItem.add("pctr");//name
	thirdItem.add("20");
	thirdItem.add("20");
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  // label
	fourthItem.add("pctrname");//name
	fourthItem.add("20");
	fourthItem.add("20");
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels"));  // label
	fifthItem.add("summary");//name
	fifthItem.add("select distinct SUMMARY_ID,SUMMARY_DESC from CA_CHART_SUMM_HEADER order by SUMMARY_DESC");
	finAr.add(fifthItem); //add to ArrayList obj finAr

	String[] orderByCols = null;
	String[] orderByColVals = null;

	orderByCols = new String[5];
	orderByColVals = new String[5];

	orderByCols[0]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"); 
	orderByCols[1]  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");     
	orderByCols[2]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"); 
	orderByCols[3]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"); 
	orderByCols[4]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels");          

	orderByColVals[0] = "PATIENT_CLASS_SHORT_DESC";
	orderByColVals[1] = "SPECIALITY_SHORT_DESC";
	orderByColVals[2] = "PRACTITIONER_ID";
	orderByColVals[3] = "PRACTITIONER_SHORT_NAME";
	orderByColVals[4] = "SUMMARY_DESC";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/AssignChartSummResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
	} catch (Exception e) {
		//out.println("Exception in AssignChartSummCriteria.jsp:"+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}finally{

		

		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

