<!DOCTYPE html>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<%-- JSP Page specific attributes start --%>
<% //"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@page  import="eOT.*, eOT.Common.*, eCommon.Common.*" import="java.util.ArrayList"  %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<%
	String bean_id		= "OTCommonBean";
	String bean_name	= "eOT.OTCommonBean";
	OTCommonBean bean= (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	ArrayList color_array = bean.getOTStatusColors();
%>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/Slate.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
<%
	for(int i =0;i<color_array.size();i+=3){	
%>
		TD.<%=(String)color_array.get(i)%>{
		BACKGROUND-COLOR:<%=(String)color_array.get(i+2)%>;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
<%
	}
%>
</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="SurgeryHistoryColorIndForm" id="SurgeryHistoryColorIndForm">
		<table class='grid'cellpadding="3" cellspacing="0" width="100%" align="center" border="1">
		<%
			int column_count = 0;
			for(int i =0;i<color_array.size();i+=3){	
			  if((color_array.get(i+2))!=null){
				column_count++;
				if(column_count==1){
		%>
				<tr>
		<%
				}
		%>
				<td class='<%=(String)color_array.get(i)%>' style="background-color: <%=(String)color_array.get(i+2)%>;" width='2%'>&nbsp;</td>
				<td class='white' nowrap>&nbsp;
				<label nowrap 												  						style="font-size:9;font-weight:bold"><%=(String)color_array.get(i+1)%>&nbsp;</label>
				</td>
		<%
				if(column_count==5){
					column_count=0;
		%>
			</tr>
		<%
				}
			  }
			}
		%>
			
	</table>
	</form>
</body>
</html>

