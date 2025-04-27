<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name       	Rev.Date	Rev.Name   Description
--------------------------------------------------------------------------------------------------------------
?             	100          	  ?         	?  			?		   created
30/04/2013		IN036126		  Chowminya G	 					   Reject details wrong in audit trail
16/01/2014		IN045048		  Nijitha S	  	16/01/2014	Nijitha	   ML-BRU-SCF-1137	
28/06/2018    	IN065341	    Prakash C		29/06/2018		Ramesh G 		MMS-DM-CRF-0115
---------------------------------------------------------------------------------------------------------------

-->

<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>


<%
	request.setCharacterEncoding("UTF-8");

	String bean_id			= request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name");
	String order_id			= request.getParameter("order_id");
 	String action_seq_num   = request.getParameter("action_seq_num");
 	//String order_line_num   = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");commented for checkstyle
	String field_value_txt	= "";		
	String action_user_name="";
	String RepDb="";	//IN065341	
	ArrayList<String> action_remarks = new ArrayList<String>();
	
	 ViewOrder bean		= (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	 bean.setLanguageId(localeName);
	//IN065341 starts
		 RepDb		= request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
		//action_remarks	= bean.getRemarks(order_id, action_seq_num);
		  action_remarks	= bean.getRemarks(order_id, action_seq_num,RepDb);
	//IN065341 ends	  
	if(action_remarks != null && action_remarks.size()>0)
	{
		action_user_name = action_remarks.get(0);
		field_value_txt = action_remarks.get(1);
		if(field_value_txt==null)
			field_value_txt = "";
	}

String key = "";
String value = "";
String strToken = ""; 
String remarksText = "";

java.util.HashMap remarksHash = remarksHash = new java.util.HashMap<String,String>();
java.util.StringTokenizer remarksTokens = new java.util.StringTokenizer(field_value_txt,"\n");
int index = 0;
while(remarksTokens.hasMoreTokens() )
{
	strToken = remarksTokens.nextToken();
	if(strToken.indexOf(":")!=-1)
	{
		key = strToken.substring(0,strToken.indexOf(":"));
		value = strToken.substring(strToken.indexOf(":")+1, strToken.length());
		if(value.equals("null")||value.equals(null)) value = "";
			remarksHash.put(key,value);
	}
	else
	{
		remarksHash.put(key,remarksHash.get(key)+"\n"+strToken);		
	}
	index++;
		
}	


if(remarksHash.containsKey("Cancelled at "))
{
	remarksText = "Cancelled at"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Cancelled at ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Cancelled by"+" : "+ action_user_name;
	remarksText = remarksText + "\n"+"Cancelled Reason"+" : "+ remarksHash.get("Cancelled Reason ");
}
else if(remarksHash.containsKey("Holded at "))
{
	remarksText = "Holded at"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Holded at ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Holded by"+" : "+action_user_name;
	remarksText = remarksText + "\n"+"Hold Reason"+" : "+ remarksHash.get("Hold Reason ");
}
else if(remarksHash.containsKey("Discontinued at "))
{
	remarksText = "Discontinued at"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Discontinued at ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Discontinued by"+" : "+action_user_name;
	remarksText = remarksText + "\n"+"Discontinued Reason"+" : "+ remarksHash.get("Discontinued Reason ");
}
else if(remarksHash.containsKey("Rejected at "))
{
	remarksText = "Rejected at"+" : "+  com.ehis.util.DateUtils.convertDate(remarksHash.get("Rejected at ").toString(),"DMYHM","en",localeName);
	//remarksText = remarksText + "\n"+"Rejected by"+" : "+action_user_name; //IN036126
	remarksText = remarksText + "\n"+"Rejected by"+" : "+remarksHash.get("Rejected by ");//IN036126
	//remarksText = remarksText + "\n"+"Rejected Reason"+" : "+ remarksHash.get("Reason ");//IN036126
	remarksText = remarksText + "\n"+"Rejected Reason"+" : "+ remarksHash.get("Rejected Reason ");//IN045048
}
else if(remarksHash.containsKey("Completed  at "))
{
	remarksText = "Completed  at"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Completed  at ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Completed Reason"+" : "+ remarksHash.get("Completed Reason ");
//remarksText = remarksText + "\nCancelled Reason : "+ remarksHash.get("Cancelled Reason ");
}
else if(remarksHash.containsKey("Resumed at "))
{
	remarksText = "Resumed at"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Resumed at ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Resumed by"+" : "+ action_user_name;
//remarksText = remarksText + "\nCancelled Reason : "+ remarksHash.get("Cancelled Reason ");
}
else if(remarksHash.containsKey("Consented At "))
{
	remarksText = "Consented At"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Consented At ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Consent Taken By"+" : "+ action_user_name;
//remarksText = remarksText + "\nCancelled Reason : "+ remarksHash.get("Cancelled Reason ");
}
else if(remarksHash.containsKey("Authorized At "))
{
	remarksText = "Authorized At"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Authorized At ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Authorized by"+" : "+action_user_name;
//remarksText = remarksText + "\nCancelled Reason : "+ remarksHash.get("Cancelled Reason ");
}
else if(remarksHash.containsKey("Special Approved At "))
{
	remarksText = "Special Approved At"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Special Approved At ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Approved by"+" : "+ action_user_name;
//remarksText = remarksText + "\nCancelled Reason : "+ remarksHash.get("Cancelled Reason ");
} 
else if(remarksHash.containsKey("Collected at "))
{
	remarksText = "Collected at"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Collected at ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Specimen Collected By"+" : "+ action_user_name;
	remarksText = remarksText + "\n"+"Remarks"+" : "+ remarksHash.get(" Remarks  ");
}
else if(remarksHash.containsKey("Specimen Dispatched By "))
{
	
	remarksText = "Specimen Dispatched By "+" : "+ action_user_name;
	remarksText = remarksText + "\n"+"Dispatched at"+" : "+ com.ehis.util.DateUtils.convertDate(remarksHash.get("Dispatched at ").toString(),"DMYHM","en",localeName);
	remarksText = remarksText + "\n"+"Dispatched Mode "+" : "+ remarksHash.get("Dispatched Mode ");
	remarksText = remarksText + "\n"+"Remarks"+" : "+ remarksHash.get(" Remarks  ");
}
else
	remarksText = field_value_txt	;


			
	
%>
<html>
<head>
	<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
textarea {
  resize: none;
}
</style>
</head> 
<script type="text/javascript">
	function toClose(){
		//parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
		parent.document.getElementById('dialog_tag').close();
	}
</script>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="">
	<table cellpadding=3 cellspacing=0 border=0 align=center width='100%' height='100%'>
		<tr><td class='fields'><TEXTAREA NAME="" ROWS="6" COLS="60" readonly><%=remarksText%></TEXTAREA></td></tr>
		<tr align="right"><td class='button'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="toClose();"></td></tr>
	</table>
</FORM>
</BODY>
</HTML>


<%
	//putObjectInBean(bean_id,bean,request);
%>

