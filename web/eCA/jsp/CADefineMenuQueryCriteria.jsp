<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

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
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");									// Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));										// label
	firstItem.add("menu_id");								// name of field
	firstItem.add("10");										// SIZE
	firstItem.add("10");										// LENGTH
	finAr.add(firstItem);										// add to ArrayList obj finAr
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");								// Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));				// label
	secondItem.add("short_desc");						// name of field
	secondItem.add("30");									// SIZE
	secondItem.add("30");									// LENGTH
	finAr.add(secondItem);									// add to ArrayList obj finAr
	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");									// Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));					// label
	thirdItem.add("long_desc");							// name of field
	thirdItem.add("40");										// SIZE
	thirdItem.add("40");										// LENGTH
	finAr.add(thirdItem);										// add to ArrayList obj finAr
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");									// Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RootMenu.label","common_labels"));							// label
	fourthItem.add("root_menu_yn");					// name of field
	fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");				//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
	finAr.add(fourthItem);									//	add to ArrayList obj finAr
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");										//	Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));									//	label
	fifthItem.add("eff_status");							//	name
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");		//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(fifthItem);										//	add to ArrayList obj finAr
	ArrayList sixthItem = new ArrayList();
	sixthItem.add("List");									//	Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Desktop.label","ca_labels"));								//	label
	sixthItem.add("desktop_yn");							//	name
	sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");	//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(sixthItem);										//	add to ArrayList obj finAr
	ArrayList seventhItem = new ArrayList();
	seventhItem.add("List");								//	Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientchart.label","common_labels"));					//	label
	seventhItem.add("patient_chart_yn");				//	name
	seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(seventhItem);								//	add to ArrayList obj finAr

	String[] orderByCols = null;
	String[] orderByColVals = null;
	orderByCols = new String[3];
	orderByColVals = new String[3];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	orderByCols[2] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
	orderByColVals[0] = "menu_id";
	orderByColVals[1] = "short_desc";
	orderByColVals[2] = "long_desc";
	strbuff = qrypg.getQueryPage(con,finAr,"CA Menu","../../eCA/jsp/CADefineMenuQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());


	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();

}//end of try
catch (Exception e) 
{
	//out.println("Exception in CADefineMenuQueryCriteria.jsp:"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally	
{

	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

