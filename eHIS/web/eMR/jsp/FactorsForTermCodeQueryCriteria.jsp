<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	to get the query criteria
*	Created By		:	Vinay
*	Created On		:	03 May 05
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eMR.*,eCommon.Common.*,com.ehis.eslp.* " %><!---->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;
StringBuffer strbuff;
//String orderCatValues = "";


try {
	con = ServiceLocator.getInstance().getConnection(request);
	//HttpSession ss = request.getSession(false);
	ArrayList StageValues = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSet.label","common_labels"));	  // label
	firstItem.add("term_set");	//name of field
	firstItem.add("select term_set_id,term_set_desc from mr_term_set where eff_status='E' order by term_set_desc");
	StageValues.add(firstItem); 
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels"));	 // label
	secondItem.add("term_code");	 //name of field
	secondItem.add("20");			 // SIZE
	secondItem.add("20");			 //LENGTH
	StageValues.add(secondItem);	
	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");   		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCodeDescription.label","common_labels"));        // label
	thirdItem.add("term_code_desc");   	 	 //name
	thirdItem.add("40");			 // SIZE
	thirdItem.add("40");			 //LENGTH
	StageValues.add(thirdItem); 			 //add to ArrayList obj finAr
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorCode.label","mr_labels"));  	 //label
	fourthItem.add("factor_code");  	 //name
	fourthItem.add("20");		         //SIZE 
	fourthItem.add("20");  			 //LENGTH
	StageValues.add(fourthItem);			 //add to ArrayList obj finAr
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorDescription.label","mr_labels"));  	 //label
	fifthItem.add("factor_desc");  	 //name
	fifthItem.add("40");		         //SIZE 
	fifthItem.add("40");  			 //LENGTH
	StageValues.add(fifthItem);			 //add to ArrayList obj finAr
	String orderByCols[] 	= new String[5];
	String orderByColVals[] = new String[5];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSet.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCodeDescription.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorCode.label","mr_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorDescription.label","mr_labels");
	orderByColVals[0] = "term_set";
	orderByColVals[1] = "term_code";
	orderByColVals[2] = "term_code_desc";
	orderByColVals[3] = "factor_code";
	orderByColVals[4] = "factor_desc";
	strbuff = qrypg.getQueryPage(con,StageValues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorsforTerminologyCode.label","mr_labels"),"../jsp/FactorsForTermCodeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
    out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( fifthItem != null )  fifthItem.clear();
	if ( StageValues != null )  StageValues.clear();

}
catch ( Exception e )	
{
	e.printStackTrace() ;
		throw e ;
}
finally 
{
	ServiceLocator.getInstance().returnConnection(con,request);
}
%>
