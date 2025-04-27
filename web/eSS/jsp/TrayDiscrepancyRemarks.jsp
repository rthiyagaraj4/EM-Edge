<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
24/12/2021			TFS:26499				Shazana				24/12/2021	   		 Shazana			ML-MMOH-SCF-1947
-------------------------------------------------------------------------------------------------------------------------------------------- 
*/
%>
 
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%> 

<html>
	<head>
		<title><fmt:message key="eSS.TrayDiscrepancyRemarks.label" bundle="${ss_labels}"/></title>
		
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle				 =		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/SSAcknowledgement.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body onload="window.scrollTo(0,0)">
<%

	String group_code			=		request.getParameter( "group_code" ) ; 
	String group_desc			=		request.getParameter( "group_desc" ) ;
	String tray_no				=		request.getParameter( "tray_no" ) ;
	
	String checklist_code 		= 		"";
	String bean_id 				= "SSAcknowledgementBean" ;
	String bean_name 			= "eSS.SSAcknowledgementBean";

	SSAcknowledgementBean bean = (SSAcknowledgementBean)getBeanObject( bean_id,  bean_name,request );
		
try{
	String classvalue				=		"";
	ArrayList alRecords	= new ArrayList();
	HashMap	  hmResult =  new HashMap();
	ArrayList alParameters = new ArrayList();

	
	group_code					=		CommonBean.checkForNull( group_code );
	group_desc					=		CommonBean.checkForNull( group_desc );
	tray_no						=		CommonBean.checkForNull( tray_no );

	
	alParameters.add(locale);
	alParameters.add(locale);
	alParameters.add(group_code);
	alParameters.add(tray_no);
	
	alRecords = (ArrayList)bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_DISCREPANCY_DTL_SELECT"),alParameters);
	
	System.out.println("alRecords"+alRecords);
	
	if( alRecords.size()>0) {
	%>
	<form name="GroupItemDetailForm" id="GroupItemDetailForm">
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
           <td align="right" class="label" ><fmt:message key="Common.Group.label" bundle="${common_labels}"/>:<b><%=group_desc%></b></td>
           <td align="right" class="label" ><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/>:<b><%=tray_no%></b></td>
		 </tr>
		 </table>
		<br>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr> <!-- 26499 -->
		<th ><fmt:message key="eSS.Instrument.label" bundle="${ss_labels}"/></th>
		<th ><fmt:message key="eSS.DiscrepancyQty.label" bundle="${ss_labels}"/></th>
		<th width='10%'><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		</tr>

	<%
		for( int i=0; i<alRecords.size();i++) {

			hmResult = (HashMap) alRecords.get(i);
			
					
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
			<tr>
				<td class="<%=classvalue%>" onclick="disableClick(event);" width='40%'><%=CommonBean.checkForNull((String)hmResult.get("SHORT_DESC"),"&nbsp;")%></td>
				<td class="<%=classvalue%>" align='center' width='10%' style="TEXT-ALIGN:right"><%=CommonBean.checkForNull((String)hmResult.get("DISCREPANCY_QTY"),"&nbsp;")%></td>
				<td class="<%=classvalue%>" align='center' width='20%'><%=CommonBean.checkForNull((String)hmResult.get("REASON_DESC"),"&nbsp;")%></td>
				<td class="<%=classvalue%>" align='center' ><%=CommonBean.checkForNull((String)hmResult.get("REMARKS"),"&nbsp;")%></td>
				
			</tr> 
	<%
		} 
	%> 
</table>
	</form>	
		
	<%
		out.flush();
	} else{
	%>
		 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/jsp/error.jsp";
		</script>
	<%
	}
	
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
<table align = right cellpadding=0 cellspacing=0  width="100%" align="center">
		<tr>
		<td valign=bottom align = right>
		<input type="button" align = right value="Close" name="close" id="close" class="BUTTON" onClick='window.close()'>
		</td>
		</tr>
		</table>
		
<%
putObjectInBean(bean_id,bean,request); 
%>
</body>
</html>
   

