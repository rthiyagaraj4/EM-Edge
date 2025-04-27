<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%//@page contentType="text/html;charset=" import="java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@page  import= "java.util.ArrayList,eOT.*, eOT.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<%
	String bean_id		= "@OTCommonBean";
	String bean_name	= "eOT.OTCommonBean";
	String min_max_val="Y";
	String view_by = request.getParameter("view_by");
	//IN055102 start
	String ot_sch_dtls_flag=request.getParameter("ot_sch_dtls_flag");
	String ot_unsch_dtls_flag=request.getParameter("ot_unsch_dtls_flag");
	//IN055102 end
	OTCommonBean bean= (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	ArrayList color_array = bean.getOTStatusColors();
%>

<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/Slate.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
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
	<form name="SlateOrderColorIndForm" id="SlateOrderColorIndForm">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img align="center" id = "img_src" src='../../eOT/images/gripper.gif' onclick="expandColorInd()" >
		<table cellpadding="3" id='moreCriteria' name='moreCriteria' id='moreCriteria' style='visible:hidden;display:none' cellspacing="0" width="100%" align="center" border="1">
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
					<td class='<%=(String)color_array.get(i)%>' width='1%'></td>
					<td class='white' nowrap>
						<label nowrap style="font-size:9;font-weight:bold"><%=(String)color_array.get(i+1)%></label>
					</td>
		<%
				if(column_count==6){
					column_count=0;
		%>
			</tr>
		<%
				}
			  }
			}
		%>
			
	</table>
	
	<input type="hidden" name="min_max_val" id="min_max_val" value="<%=min_max_val%>">
	<input type="hidden" name="search_page_view_by" id="search_page_view_by" value="<%=view_by%>">
	<input type="hidden" name="ot_sch_dtls_flag" id="ot_sch_dtls_flag" value="<%=ot_sch_dtls_flag%>"><!--IN055102-->
	<input type="hidden" name="ot_unsch_dtls_flag" id="ot_unsch_dtls_flag" value="<%=ot_unsch_dtls_flag%>"><!--IN055102-->
	</form>
</body>
</html>

