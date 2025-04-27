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

try 
{
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	

	firstItem.add("Text");									// Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));		// label
	firstItem.add("user_id");								// name of field
	firstItem.add("20");										// SIZE
	firstItem.add("30");										// LENGTH
	finAr.add(firstItem);										// add to ArrayList obj finAr


	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");								
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));				
	secondItem.add("appl_user_name");						
	secondItem.add("30");									
	secondItem.add("60");									
	finAr.add(secondItem);
	
	
	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");									
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DesktopId.label","ph_labels"));						
	thirdItem.add("desktop_id");					
	thirdItem.add("20");
	thirdItem.add("10");	
	finAr.add(thirdItem);									


	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");										
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));									//	label
	fourthItem.add("desktop_desc");							
	fourthItem.add("30");		
	fourthItem.add("20");		
	finAr.add(fourthItem);							

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");							
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));		
	fifthItem.add("eff_status");							
	fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");	
	finAr.add(fifthItem);										


	String[] orderByCols = null;
	String[] orderByColVals = null;
	orderByCols = new String[4];
	orderByColVals = new String[4];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DesktopId.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","ph_labels");

	orderByColVals[0] = "user_id";
	orderByColVals[1] = "user_name";
	orderByColVals[2] = "desktop_id";
	orderByColVals[3] = "desktop_desc";
 
	strbuff = qrypg.getQueryPage(null,finAr,"Pharmacist Menu","../../ePH/jsp/PHDefineMenuQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());


	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();

}
catch (Exception e) 
{
	out.println("Exception in PHDefineMenuQueryCriteria.jsp:"+e.toString());
}
%>

