<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
07/05/2014		IN048464		Karthi L			07/05/2014		Ramesh			History added for clinical comments																		
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";

	String orderId = request.getParameter("orderId");
	String max_seq = request.getParameter("max_seq");
	//System.out.println("max_seq="+max_seq);
	if(max_seq==null) max_seq="";
	String max_action_seq_num = max_seq;
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;

	String max_num = "0";
	String which_review = request.getParameter("num");
	HashMap clinicalHistoryMap = null; //IN048464
	String comments_added = ""; //IN048464
	String added_date = ""; //IN048464
	
	if(which_review == null){
		if(max_action_seq_num.equals(""))
		max_action_seq_num		= bean.getMaxCount(orderId);
		if(max_action_seq_num == null)
			max_action_seq_num = "";
		else 
			max_action_seq_num = max_action_seq_num.trim();
		
		max_num = max_action_seq_num;

	}else{
		max_num = which_review;
	}
	//IN048464
	if(max_num != null && max_num != "") { 
		clinicalHistoryMap = bean.getClinicalCommentsHistory(orderId, Integer.parseInt(max_num), localeName);
		comments_added = (String)clinicalHistoryMap.get("CLINICIAN_NAME");
		added_date = (String)clinicalHistoryMap.get("ADDED_DATE_TIME");
		added_date = com.ehis.util.DateUtils.convertDate(added_date,"DMYHM","en",localeName);
	}
	//IN048464
	String comments =  bean.getComments(orderId,max_num);
	
%>
<FORM METHOD=POST ACTION="">
<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%" align=center>
<tr><td class='fields' colspan = '2'><TEXTAREA NAME="" ROWS="6" COLS="60" readonly><%=comments%></TEXTAREA></td></tr> <!-- colspan added for IN048464-->
<!-- IN048464 - Start -->
<tr>
	<td  class='LABEL'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.modifiedby.label","common_labels")%> : <%=comments_added %></td>
	</tr><tr>
		 <td class='LABEL'> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.modifieddatetime.label","common_labels")%> : <%=added_date%></td>
</tr>
<!-- IN048464 - End -->
<!-- <td class='button' ><INPUT TYPE="button"  class='Button' name='Ok' id='Ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td>  commented for IN048464-->
<td class='button' colspan='2' align = 'right'><INPUT TYPE="button"  class='Button' name='Ok' id='Ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='const dialogTag = parent.parent.document.getElementById("dialog_tag");dialogTag.close();'></td> <!-- IN048464 -->

</table>
</FORM>
</BODY>
</HTML>


<%
		putObjectInBean(bean_id,bean,request);
%>

