<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<head>
	<%  request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
		con =ConnectionManager.getConnection(request); 
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QuickLinkType.label","ca_labels"));     // label
		firstItem.add("ql_type");   //name of field
		firstItem.add("'',------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------------,QF,Query Filter,AF,Actual Function,EX,External Application,AM,Adaptive Menu");
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels"));    // label
		secondItem.add("function_name");  //name of field
		secondItem.add("30");   // SIZE
		secondItem.add("60");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");          //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));    // label
		thirdItem.add("desc");  //name of field
		thirdItem.add("30");   // SIZE
		thirdItem.add("60");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr	
		
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");          //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Scope.label","common_labels"));    // label
		fourthItem.add("scope");  //name of field
		fourthItem.add("*,Both,F,Function Specific,G,Global");   // SIZE
		finAr.add(fourthItem);    //add to ArrayList obj finAr	

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifthItem.add("eff_status");//name
		fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(fifthItem); //add to ArrayList obj finAr
									
		String[] orderByCols =  new String[3];
		String[] orderByColVals =  new String[3];
		orderByCols[0]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels"); 
		orderByCols[1]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QuickLinkType.label","ca_labels");  
		orderByCols[2]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

		orderByColVals[0] = "SYS_OPTION_DESC";
		orderByColVals[1] = "QUICK_LINK_TYPE";
		orderByColVals[2] = "QUICK_LINK_DESCRIPTION";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Chart","../../eCA/jsp/DefineQuickLinksQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
		
		out.println(strbuff.toString());	

		finAr.clear();
       firstItem.clear();
       secondItem.clear();
       thirdItem.clear();
       fourthItem.clear(); 
       fifthItem.clear();


	}
	catch(Exception ee)
	{
		//out.println("Exception in ChartApplicabilityQueryCriteria Block of Chart Applicability : "+ee.toString());//common-icn-0181
                 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
       

		if(con != null)ConnectionManager.returnConnection(con); 
	}
%>

