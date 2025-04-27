<!DOCTYPE html>
<!--
*	Copyright © iSoft Solutions (P) Ltd. 
*	Created By		:	Ajay Hatwate
*	Created On		:	22 Dec 2022
-->


<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*,eMR.*,eCommon.Common.*,com.ehis.eslp.* " %>
<%
String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

try
{
	request.setCharacterEncoding("UTF-8");
	String locale=(String)session.getAttribute("LOCALE");
	Connection conn=null ;
	conn = ConnectionManager.getConnection(request);

	ArrayList Terminologyvalues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  	
	
	  
	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisCategory.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","mr_labels"));	  
	firstItem.add("DIAG_CATG_CODE");	
	firstItem.add("10"); 
	firstItem.add("10"); 
	Terminologyvalues.add(firstItem); 

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   
	
	
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisCategory.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","mr_labels"));
	
	secondItem.add("LONG_DESC");
	secondItem.add("30"); 
	secondItem.add("60");  
	Terminologyvalues.add(secondItem); 

	
ArrayList thirdItem = new ArrayList();
thirdItem.add("List"); 
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  
thirdItem.add("nature");   
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
thirdItem.add("4");
Terminologyvalues.add(thirdItem);


	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisCategory.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","mr_labels");
	

	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisCategory.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","mr_labels");
	


	orderByColVals[0] = "DIAG_CATG_CODE";
	orderByColVals[1] = "LONG_DESC";


	
	strbuff = qrypg.getQueryPage(conn,Terminologyvalues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels"),"../jsp/DiagnosisCategoryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	
	Terminologyvalues.clear();
	if ( conn != null ) ConnectionManager.returnConnection(conn,request);
}
catch (Exception e) 
{
	//out.println(e.toString());
	e.printStackTrace();
}

finally
{
}
%>
