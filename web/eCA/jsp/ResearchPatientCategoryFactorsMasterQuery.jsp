<!DOCTYPE html>
 <%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
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
	firstItem.add("Text");										// Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ResearchCategoryFactorCode.label","ca_labels"));					// label
	firstItem.add("RESEARCH_CATEG_FACT_ID");						// name of field
	firstItem.add("10");											// SIZE
	firstItem.add("10");											// LENGTH
	finAr.add(firstItem);											// add to ArrayList obj finAr
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");									// Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ResearchCategoryFactorDescription.label","ca_labels"));	 // label
	secondItem.add("RESEARCH_CATEG_FACT_DESC");				// name of field
	secondItem.add("30");										// SIZE
	secondItem.add("30");										// LENGTH
	finAr.add(secondItem);										// add to ArrayList obj finAr
	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");										//	Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels"));									//	label
	thirdItem.add("EFF_STATUS");								//	name
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");		//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(thirdItem);											//	add to ArrayList obj finAr

	String[] orderByCols = null; 
	String[] orderByColVals = null;
	orderByCols = new String[2];
	orderByColVals = new String[2];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ResearchCategoryFactorCode.label","ca_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ResearchCategoryFactorDescription.label","ca_labels");
	orderByColVals[0] = "RESEARCH_CATEG_FACT_ID";
	orderByColVals[1] = "RESEARCH_CATEG_FACT_DESC";
	strbuff = qrypg.getQueryPage(con,finAr,"CA Menu","../../eCA/jsp/ResearchPatientCategoryFactorsMasterResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();

}//end of try
catch (Exception e) 
{
	//out.println("Exception in try of ResearchPatientCategoryFactorsMasterQuery.jsp: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181  
}
finally	
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

