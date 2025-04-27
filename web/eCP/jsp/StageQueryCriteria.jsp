<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	Hema Malini B
*	Created On		:	30th Dec 2004
-->

<!--StageQueryCriteria.jsp-->

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCP.*" contentType="text/html; charset=UTF-8" %>
<%-- Mandatory declarations start --%>
	<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>

 -->
  <head>
<% 
 request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
 String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>

<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<% ecis.utils.CommonQueryPage querypage= new ecis.utils.CommonQueryPage();
StringBuffer strbuf;

Connection con=null;

try{
	con=ConnectionManager.getConnection(request);
	String stg_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StageCode.label","common_labels");
	String stg_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.StageDescription.label","cp_labels");
	String stg_indicator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.StageIndicator.label","cp_labels");
	String all=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	String pre_admit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PreAdmit.label","cp_labels");
	String post_admit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PostAdmit.label","cp_labels");
	String discharge=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
	String post_discharge=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PostDischarge.label","cp_labels");
	String stage_indic_list="%,"+all+",01,"+pre_admit+",02,"+post_admit+",03,"+discharge+",04,"+post_discharge;
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
    String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String find_stage=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindStage.label","cp_labels");
	ArrayList finalArray=new ArrayList();
	ArrayList firstItem=new ArrayList();
	firstItem.add("Text"); //Type of item
	firstItem.add(stg_code); // label
	firstItem.add("stage_code"); //name
	firstItem.add("10");  //size
    firstItem.add("10");   //Length
	finalArray.add(firstItem);

    ArrayList secondItem=new ArrayList();
	secondItem.add("Text"); //Type of item
	secondItem.add(stg_desc); // label
	secondItem.add("stage_description"); //name
	secondItem.add("30");  //size
    secondItem.add("30");   //Length
	finalArray.add(secondItem);

	ArrayList ThirdItem=new ArrayList();
	ThirdItem.add("List"); //Type of item
	ThirdItem.add(stg_indicator); // label
	ThirdItem.add("stage_indicator"); //name
	ThirdItem.add(stage_indic_list);//Values to be passed
   	finalArray.add(ThirdItem);

	ArrayList FourthItem=new ArrayList();
	FourthItem.add("List"); //Type of item
	FourthItem.add(Nature); // label
	FourthItem.add("eff_status"); //name
	FourthItem.add(Nature_List);  //values to be passed

	finalArray.add(FourthItem);

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0]	= stg_code;
	orderByCols[1]	= stg_desc;
	
	orderByColVals[0] = "stage_code";
	orderByColVals[1] = "long_desc";


   strbuf = querypage.getQueryPage(con,finalArray,find_stage,"../jsp/StageQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

   out.println(strbuf.toString());

}catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
