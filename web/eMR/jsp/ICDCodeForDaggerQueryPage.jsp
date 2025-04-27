<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Asterisk Codes for Dagger Codes 
/// Developer		:	SRIDHAR R
/// Created On		:	2 DEC 2004
/// Function 		:   Used to build the query page...
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try 
{
	con=ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList secondItem1=new ArrayList();
		secondItem1.add("Text");  //Type of item
		secondItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DaggerCode.label","mr_labels"));  // label
		secondItem1.add("dagger_code");   //name of field
		secondItem1.add("10");	// SIZE
		secondItem1.add("10");	//LENGTH
	finAr.add(secondItem1); //add to ArrayList obj finAr

	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Dagger.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));	  // label
		firstItem.add("dagger_desc");	//name of field
		firstItem.add("20");	// SIZE
		firstItem.add("70");	//LENGTH 
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AsteriskCode.label","mr_labels"));  // label
		secondItem.add("astk_code");   //name of field
		secondItem.add("10");	// SIZE
		secondItem.add("10");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));  // label
		thirdItem.add("astk_desc");   //name of field
		thirdItem.add("20");
		thirdItem.add("70");	//LENGTH
	finAr.add(thirdItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DaggerCode.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Dagger.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AsteriskCode.label","mr_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");

	orderByColVals[0] = "DAG_DIAG_CODE";
	orderByColVals[1] = "DAG_SHORT_DESC";
	orderByColVals[2] = "ASTK_DIAG_CODE";
	orderByColVals[3] = "ASTK_SHORT_DESC";


	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AsteriskCodeforDaggerCode.label","mr_labels"),"../jsp/ICDCodeForDaggerQueryPageResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

} catch (Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}

%>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

