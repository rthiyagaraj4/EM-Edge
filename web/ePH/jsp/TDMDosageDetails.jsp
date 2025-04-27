<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../ePH/js/TDMGuidLinesView.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<title>Administered Details</title>
</HEAD>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
   String bean_id	= "TDMGuidLinesView";
   String bean_name = "ePH.TDMGuidLinesView";

  TDMGuidLinesView bean	 =	(TDMGuidLinesView)getBeanObject( bean_id,bean_name, request ) ;	
  String ord_id = "";
  String pat_id = "";
  String drgcde = "";
  String time   = request.getParameter("time");
  ArrayList showAdminDetls=bean.getDetails();
  if(showAdminDetls.size()!=0) { 
		         ord_id     =  (String)showAdminDetls.get(0);	 
			     pat_id	    =  (String)showAdminDetls.get(1);
				 drgcde     =  (String)showAdminDetls.get(2);
				
   }
 ArrayList showAdminDtl=bean.getAdminDetails(ord_id,pat_id,drgcde,time);
    String admin_yn	 ="";	
	String desc		 ="";
    String admtime   ="";    
    String admby	 ="";	
    String admrmrks  ="";   
	String batchdtls ="";    
	if(showAdminDtl.size()!=0) { 
		         admin_yn     =  (String)showAdminDtl.get(0);	 
			     desc	      =  (String)showAdminDtl.get(1);
				 admtime      =  (String)showAdminDtl.get(3);
                 admby        =  (String)showAdminDtl.get(4);
			 	 admrmrks     =  (String)showAdminDtl.get(9);
			     batchdtls    =  (String)showAdminDtl.get(10);
			   }
	
%> 
<table align="center"  border="0" width="100%" cellspacing="0"   cellpadding="0">
<tr width="102%"> 
        <td  align= "left" class="label">&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administered&nbsp;<b><%=admin_yn%></b>
		</tr>
		<tr >
        <td>&nbsp;</td>
		</tr>
		<tr>
		<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administered   At&nbsp;<b><%=desc%></b>
        </tr> 
	    <tr >
        <td >&nbsp;&nbsp;</td>
		</tr>
		<tr>
		<td  class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administered Date&nbsp;<b><%=admtime%></b>
        </tr> 
		<tr >
        <td >&nbsp;&nbsp;</td>
		</tr>
		<tr>
		<td  class="label" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administered By&nbsp;<b><%=admby%></b>
        </tr>
		<tr >
        <td>&nbsp;&nbsp;</td>
		</tr>
		<tr>
		<td  class="label" nowrap>&nbsp;&nbsp;&nbsp;Administered Remarks&nbsp;<b><%=admrmrks%></b>
        </tr> 
		<tr >
        <td >&nbsp;&nbsp;</td>
		</tr>
		<tr>
		<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Batch Details	<b><%=batchdtls%></b>
        </tr> 
		<tr >
        <td colspan=4>&nbsp;&nbsp;</td>
		</tr>
		<tr >
        <td colspan=4>&nbsp;&nbsp;</td>
		</tr>
		
		
</table>
<br><br>
<HTML>

