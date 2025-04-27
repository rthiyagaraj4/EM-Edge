<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:
*	Created By		:	Hema Malini B
*	Created On		:	27th Dec 2004
-->

<!--FactorQueryCriteria.jsp-->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.Common.* " %>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%-- Mandatory declarations start --%>
	<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<% 
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage querypage= new ecis.utils.CommonQueryPage();
StringBuffer strbuf;

Connection con=null;
//String function_id=request.getParameter("function_id");

try{
	con=ConnectionManager.getConnection(request);
	
	ArrayList finalArray=new ArrayList();

	ArrayList firstItem=new ArrayList();
	firstItem.add("Text"); //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorCode.label","mr_labels")); // label
	firstItem.add("factor_code"); //name
	firstItem.add("10");  //size
    firstItem.add("10");   //Length
	finalArray.add(firstItem);

    ArrayList secondItem=new ArrayList();
	secondItem.add("Text"); //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorDescription.label","mr_labels")); // label
	secondItem.add("factor_description"); //name
	secondItem.add("30");  //size
    secondItem.add("30");   //Length
	finalArray.add(secondItem);

	ArrayList ThirdItem=new ArrayList();
	ThirdItem.add("List"); //Type of item
	ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorTypes.label","mr_labels")); // label
	ThirdItem.add("factor_type"); //name
	ThirdItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DefiningCharacteristics.label","mr_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Related.label","mr_labels")+",K,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Risk.label","mr_labels"));  //Values to be passed
   	finalArray.add(ThirdItem);

	ArrayList FourthItem=new ArrayList();
	FourthItem.add("List"); //Type of item
	FourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); // label
	FourthItem.add("eff_status"); //name
	FourthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));  //values to be passed

	finalArray.add(FourthItem);

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorCode.label","mr_labels");
	orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorDescription.label","mr_labels");
	
	orderByColVals[0] = "factor_code";
	orderByColVals[1] = "long_desc";


   strbuf = querypage.getQueryPage(con,finalArray,"factor","../jsp/FactorQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
   out.println(strbuf.toString());

	if ( firstItem != null ) firstItem.clear(); 
	if ( secondItem != null ) secondItem.clear(); 
	if ( ThirdItem != null ) ThirdItem.clear(); 
	if ( FourthItem != null ) FourthItem.clear(); 
	if ( finalArray != null ) finalArray.clear(); 

}catch(Exception e)
{/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	if(con != null)
		ConnectionManager.returnConnection(con,request);
}


%>

