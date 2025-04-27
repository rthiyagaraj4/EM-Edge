<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
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
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));     // label
	firstItem.add("patclass");   //name of field
    //firstItem.add("Select pract_type, nvl(desc_userdef,desc_sysdef) pract_type_desc from am_pract_type where eff_status ='E' order by seq_no");
	firstItem.add("Select pract_type, nvl(desc_userdef,desc_sysdef) pract_type_desc from am_pract_type_lang_vw where eff_status ='E' and language_id ='"+locale+"' order by seq_no");
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
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));  // label
	thirdItem.add("pctr");//name
	thirdItem.add("20");
	thirdItem.add("20");
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FlowSheet.label","ca_labels"));  // label
	fourthItem.add("lookup");//name
	fourthItem.add("20");
	fourthItem.add("20");
	
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String[] orderByCols = null;
	String[] orderByColVals = null;
	
	orderByCols = new String[4];
	orderByColVals = new String[4];
	
	orderByCols[0]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");  
	orderByCols[1]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");     
	orderByCols[2]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	orderByCols[3]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FlowSheet.label","ca_labels");      
	
	orderByColVals[0] = "B.DESC_USERDEF";
	orderByColVals[1] = "D.LONG_DESC";
	orderByColVals[2] = "C.PRACTITIONER_NAME";
	orderByColVals[3] = "E.LONG_DESC";
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/FlowSheetApplicabilityQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	
	out.println(strbuff.toString());
 
    finAr.clear();
    firstItem.clear();
    secondItem.clear();
    thirdItem.clear();
    fourthItem.clear();


	} catch (Exception e) {
		//out.println("Exception in FlowSheetApplicabilityQueryCriteria.jsp:"+e.toString());//common-icn-0181
	        e.printStackTrace();//COMMON-ICN-0181
	}finally{

		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

