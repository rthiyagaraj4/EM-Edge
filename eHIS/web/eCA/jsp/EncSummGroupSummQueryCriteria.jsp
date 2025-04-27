<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description 
-------------------------------------------------------------------------------------------------------------------------------------
03/09/2013     		1   		Sethuraman      Created for Searching encounter Summary code
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,eCA.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
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

StringBuffer oHistType = new StringBuffer();

EncSummGroupSummBean sSummGroupSummBean = new EncSummGroupSummBean();
EncSummGroup summGrpDetails = new EncSummGroup();

int nListSize = 0;

Connection con=null ;

try
	{

		
		con  =  ConnectionManager.getConnection(request);		
		
		ArrayList finAr = new ArrayList();
		
		ArrayList firstItem  = new ArrayList();
		firstItem.add("Text");   //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
		firstItem.add("es_summ_code");//name
		firstItem.add("8"); // SIZE
		firstItem.add("8"); //LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr		

		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));    // label
		secondItem.add("es_summ_desc");  //name of field
		secondItem.add("64");   // SIZE
		secondItem.add("64");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr	
		
		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");          //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Title.label","ca_labels"));    // label
		thirdItem.add("es_summ_title");  //name of field
		thirdItem.add("64");   // SIZE
		thirdItem.add("64");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr	

		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");   //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fourthItem.add("es_summ_status");//name
		fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");		
		finAr.add(fourthItem); //add to ArrayList obj finAr

		String[] orderByCols = null;
		String[] orderByColVals = null;
		
		orderByCols = new String[3];
		orderByColVals = new String[3];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Title.label","ca_labels");		

		orderByColVals[0] = "es_summ_code";
		orderByColVals[1] = "es_summ_desc";
		orderByColVals[2] = "es_summ_title";
			
		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels"),"../../eCA/jsp/EncSummGroupSummQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ,orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();		
} 

catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

