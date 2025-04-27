<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper "%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
		<title></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			
			<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
</style>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	</head>
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	//String bean_id				= "Or_OrderingRulebyPatientClass" ;
//	String bean_name			= "eOR.OrderingRulebyPatientClass";

	//OrderingRulebyPatientClass bean = (OrderingRulebyPatientClass)mh.getBeanObject( bean_id, request, bean_name ) ;

	//String valSource[]  ={"HAA","HAD","DAA","DAD"} ;
	//String descsource[]={"Hour After Adm.Vist","Hour After Discharge","Day After Adm/vist","Day After Discharge"} ;

	String valYesNo[]  ={"Y","N"} ;
	String desYesNo[]={"Yes","No"} ;


String order_category		= CommonBean.checkForNull((request.getParameter("order_category").trim()));
String pre_select_ord_type	= CommonBean.checkForNull((request.getParameter("pre_select_ord_type").trim()));
String time_based_rule		= CommonBean.checkForNull((request.getParameter("time_based_rule").trim()));
boolean searched			= request.getParameter( "searched" ) == null? false : true  ;

String sql = OrRepository.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PATIENT_CLASS_QRY_RSLT");

try{
	String classvalue			= "";

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData",sql);

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "order_category_desc" );
	displayFields.add( "patient_class_desc" );
	displayFields.add( "preselect_order_type_code_yn" );
	displayFields.add( "place_order_expiry_rule" );
	displayFields.add( "place_order_expiry_period" );
	displayFields.add( "future_order_period" );
	displayFields.add( "future_order_period_unit" );
	displayFields.add( "floor_to_start_day_yn" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add(order_category+"%");
	chkFields.add(pre_select_ord_type+"%");
	chkFields.add(time_based_rule+"%");

	// Adding function related array list into the HashMap
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);



	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table border="0" cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
				</td></tr>
		</table>

		<table cellspacing=0 width="100%" border="0" style="border-top: 1.5px solid #333; border-right: 1.5px solid #333; border-bottom: 1.5px solid #333; border-left: 1.5px solid #333;">
		<tr>
			<th class=columnheader width="15%" align="left"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
			<th class=columnheader width="15%" align="left"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
			<th class=columnheader width="12%" align="left"><fmt:message key="eOR.Pre-selectOrderType.label" bundle="${or_labels}"/></th>
			<th class=columnheader width="10%" align="left"><fmt:message key="eOR.TimeBasedRule.label" bundle="${or_labels}"/></th>
			<th class=columnheader width="10%" align="left"><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/></th>
			<th class=columnheader width="25%" colspan='2' align="left"><fmt:message key="eOR.FutureOrderRule.label" bundle="${or_labels}"/></th>
			<th class=columnheader width="18%" align="left"><fmt:message key="eOR.RoundOffStartTime.label" bundle="${or_labels}"/></th>
		</tr>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String str ="";
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="Modify(this);" >
	<%


		  records=(ArrayList) result.get( recCount );

		  for(int colCount=0; colCount<records.size(); colCount++){

		str = (String)records.get(colCount);


			if(colCount ==2)//to display Source type
   			str=eHISFormatter.chkReturn(valYesNo,str,desYesNo,"&nbsp;");
			if(colCount ==3)//to display Source type
				if(str == null)
					str = "&nbsp;";
   		//	str=eHISFormatter.chkReturn(valSource,str,descsource,"&nbsp;");
			if(colCount ==4)//to display Source type
				if(str == null)
					str = "&nbsp;";
			if(colCount ==5)//to display Source type
				if(str == null)
					str = "&nbsp;";
			if(colCount ==6){//to display Source type
				if(str == null)
					str = "&nbsp;";
				if(str.equals("M")){str="Minutes";}
				else if(str.equals("H")){str="Hours";}
				else if(str.equals("W")){str="Weeks";}
				else if(str.equals("m")){str="Months";}
				else if(str.equals("Y")){str="Years";}
				else if(str.equals("D")){str="Days";}
			}
			if(colCount ==7)//to display Source type
   			str=eHISFormatter.chkReturn(valYesNo,str,desYesNo,"&nbsp;");
			%>

			<td class="<%=classvalue%>" onclick="disableClick(event);">
			<%=str%></td>
			<%
		 }%>

		</tr>
		<%}%>
	</table>
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"OrderingRulebyPatientClassQueryResult.jsp", searched));


}catch(Exception e){System.out.println("exception in jsp="+e);
}


	/*
public static final String ORDERING_RULE_BY_PATIENT_CLASS_QRY_RSLT = "SELECT a.short_desc order_category_desc ,b.short_desc patient_class_desc, c.patient_class patient_class, c.preselect_order_type_code_yn preselect_order_type_code_yn, c.place_order_expiry_rule place_order_expiry_rule, c.place_order_expiry_period place_order_expiry_period FROM or_order_category a,	am_patient_class b, or_param_by_category_ptcl c WHERE upper(a.order_category) = upper(c.order_category) AND 	upper(b.patient_class) = upper(c.patient_class) AND 	upper(c.order_category) like upper(?) AND 	upper(c.preselect_order_type_code_yn) like upper(?) AND 	upper(c.place_order_expiry_rule) like upper(?) ";
*/



%>

</body>
</html>

