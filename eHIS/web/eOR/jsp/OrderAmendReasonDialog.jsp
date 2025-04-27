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
16/09/2014		IN051127		Karthi L			16/09/2014		Ramesh			View Audit trail->All the text of entered reason is displayed in same line		
18/09/2014		IN051106		Karthi L			18/09/2014		Ramesh			Selected Amend reason is not displaying for recent Amend Audit.
19/9/2014		IN051255		Karthi L			19/09/2014		Ramesh			Amend Reason window displayed as blank while view Audit history
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page language="java" import ="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eOR.amendreason.label" bundle="${or_labels}"/></title>

		<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE1")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	  	<script language='javascript' src='../../eCommon/js/common.js'></script>
     	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

     	<script>
			function doClose()
			{
				window.close();
			}	
		</script>
		<%
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String order_id = request.getParameter("order_id") == null?"":request.getParameter("order_id");
		String action_sequ = (request.getParameter("act_seq_num")==null)?"":request.getParameter("act_seq_num");
		String amend_reason = "";
		String amd_rson_sql = "";
		int action_seq_num = 0;
		if(action_sequ != null && action_sequ != ""){
			action_seq_num = Integer.parseInt(action_sequ);
			//action_seq_num = action_seq_num -1;//IN051106 - Commented for IN051255
		}
		try
		{
			amd_rson_sql = "SELECT A.ORDER_AMEND_REASON  AMEND_REASON FROM   OR_ORDER_AMEND_REASON A  WHERE A.ORDER_ID = ? AND A.ACTION_SEQ_NUM = ?"; 
			con	= ConnectionManager.getConnection();
			stmt = con.prepareStatement(amd_rson_sql);
			stmt.setString(1, order_id);
			stmt.setInt(2, action_seq_num);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				amend_reason= rs.getString("AMEND_REASON")==null?"":rs.getString("AMEND_REASON");
			}
		%>
			</head>
			<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
				<form>
					<br>
					<table border=0 cellpadding=3 cellspacing=0 align=center>
						<tr><td>
							<table width='50%' border='0' cellspacing='0' cellpadding='3' align=center>
								<tr>
									<td colspan=2></td>
								</tr>
								<tr>
									<td><textarea name='remarks' value="" rows="17" cols="54" value=''  readonly ><%=amend_reason%></textarea></td>
								</tr>
								<tr>
									<td colspan=2></td>
								</tr>
								<tr>
									<td align='right'><input type='Button' class='Button' name='close' id='close' value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>   ' onclick='doClose()'></td>
								</tr>
								<tr>
									<td colspan=2></td>
								</tr>
							</table>
						</td></tr>
					</table>
		<%	
		
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception in try of ResearchPatientRemarksDialog.jsp:"+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}	
			%>
			</form>
		</body>
</html>

