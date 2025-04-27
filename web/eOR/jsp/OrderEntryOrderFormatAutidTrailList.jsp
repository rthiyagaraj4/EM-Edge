<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
12/09/2014	IN051106		Karthi L	12/9/2014		Akbar				Amended Practitioner details displayed  as Blank at Audit trail									
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<html>
<head>
 <script language="javascript" src="../../eCommon/js/common.js"></script>
 <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
 <script language="javascript" src="../../eOR/js/ViewOrder.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<title>Audit Trail for Order Entry Format</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%	
String order_id	  = request.getParameter("orderId");
String lineId = request.getParameter("lineId")==null?"":request.getParameter("lineId" ) ;
String action_seq_num="";
%>

<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="OrderEntryFormatAuditTrailList" id="OrderEntryFormatAuditTrailList">
		<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' id="auditTrailList">	
			<tr>
				<th class='columnHeadercenter' rowspan=2 width='10%'>S.No</th>
				<th class='columnHeadercenter' colspan=2 width='40%'>Modified</th>
				<th class='columnHeadercenter' rowspan=2 width='50%'>Reason</th>
			</tr>
			<tr>
				
				<th class='columnHeadercenter' widht='15%'>Date</th>
				<th class='columnHeadercenter' widht='25%'>Practitioner Name</th>
			</tr>
			<%
			Connection conn  = null;
			PreparedStatement pstmt;
			ResultSet rs = null;
			String tempTable = "OR_ORDER_FIELD_VALUES_ACTION";
			if(!"".equals(lineId)){
				tempTable = "OR_ORDER_LINE_FLD_VAL_ACTION";
			}
			
			//String strsql1="SELECT DISTINCT A.ACTION_SEQ_NUM,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG WHERE PRACTITIONER_ID=A.ADDED_BY_ID AND LANGUAGE_ID=?) PRACTITIONER_NAME,SM_CONVERT_DATETIME_2T(A.ADDED_DATE,?) ADDED_DATE, A.ORDER_AMEND_REASON FROM OR_ORDER_AMEND_REASON A INNER JOIN "+tempTable+" B ON A.ACTION_SEQ_NUM = B.ACTION_SEQ_NUM AND A.ORDER_ID = B.ORDER_ID WHERE A.ORDER_ID = ? ORDER BY ADDED_DATE DESC"; - Commented for IN051106
				String strsql1="SELECT DISTINCT A.ACTION_SEQ_NUM,AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID), ?, '1') PRACTITIONER_NAME,SM_CONVERT_DATETIME_2T(A.ADDED_DATE,?) ADDED_DATE, A.ORDER_AMEND_REASON FROM OR_ORDER_AMEND_REASON A INNER JOIN "+tempTable+" B ON A.ACTION_SEQ_NUM = B.ACTION_SEQ_NUM AND A.ORDER_ID = B.ORDER_ID WHERE A.ORDER_ID = ? ORDER BY ADDED_DATE DESC"; // modified for IN051106
			try
			{
				conn 	= ConnectionManager.getConnection(request);
				pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				pstmt.setString(1,localeName);
				pstmt.setString(2,localeName);
				pstmt.setString(3,order_id);
				rs		= pstmt.executeQuery();
				int i=0;
				int j=1;
				while(rs.next())
				{
					if(i==0){
						action_seq_num = ((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM"));
						i++;
					}
					String amendRson=rs.getString("ORDER_AMEND_REASON")==null?"":rs.getString("ORDER_AMEND_REASON");					
						
					%>
					<tr onclick="viewOrderFormatAuditTrail('<%=order_id %>','<%=((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM")) %>','<%=lineId %>');" id="<%=((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM")) %>">
						<td class='gridData'><%=j %></td>
						<td class='gridData'><%=((rs.getString("ADDED_DATE")==null)?"":rs.getString("ADDED_DATE")) %></td>
						<td class='gridData'><%=((rs.getString("PRACTITIONER_NAME")==null)?"":rs.getString("PRACTITIONER_NAME")) %></td>
						<td class='gridData'>
						<%if((amendRson.length())>30){%>
							<a class="gridLink" href="javascript:ShowComments('<%=order_id %>','<%=((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM")) %>')"><%=amendRson.substring(0,29)%>...</td>
						<%}else{ %>
							<%=amendRson %>
						<%}%>
						</td>
					</tr>
					<%
					j++;
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}catch(Exception e){
				//out.println("Exception : "+e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();	
			}finally{
				if (conn != null) 
					ConnectionManager.returnConnection(conn,request);
			}
			
			%>
			
		</table>
		<script>
			viewOrderFormatAuditTrail("<%=order_id %>","<%=action_seq_num %>","<%=lineId%>");		
		</script>
 	</form>
</body>
</html>

