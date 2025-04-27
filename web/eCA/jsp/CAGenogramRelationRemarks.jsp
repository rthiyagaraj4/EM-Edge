<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
19/09/2013	IN043568		Ramesh G		Add Social/Emotional/Interpersonal Relationships and Add Medical History 
											In Remarks there is no wrapping of text entered
 
--------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html> 
<head> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
	

	String fromRelationId	= request.getParameter("fromRelationId");
	String toRelationId		= request.getParameter("toRelationId");
	String val				= request.getParameter("val");
	String query			= "";
	String remarks 			= "";
	if("ESI".equals(val)){
		query="SELECT RELATION_REMARKS FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID IN(SELECT RELTN_ID FROM CA_GENO_RELTN_MAST WHERE reltn_type_id = 'ESI') AND FROM_GENOID=? AND TO_GENOID=?";
	}else if("MH".equals(val)){
		query = "SELECT RELATION_REMARKS FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID ='MH' AND FROM_GENOID=? AND RELATION_ID=?";
	}
	
	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	
	try {
		con =	ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, fromRelationId);		
		pstmt.setString(2, toRelationId);
	
		rs	= pstmt.executeQuery() ;
		if(rs.next()){
			remarks = (rs.getString("RELATION_REMARKS")==null?"":(String)rs.getString("RELATION_REMARKS"));
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
	}catch(Exception e){
		e.printStackTrace() ;
	}finally{
		if (con!= null)
		ConnectionManager.returnConnection(con,request);
	} 

%>
<title>"Remarks"</title>
</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<center>
	<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
		<tr><td>
			<table width='50%' border='0' cellspacing='0' cellpadding='3' align=center>
				<tr>
					<td colspan=2></td>
				</tr>
				<tr>
					<td class='fields'><textarea name="comments" rows="17" cols="54" readOnly><%=remarks%></textarea></td>
					
				</tr>
				<tr>
					<td colspan=2></td>
				</tr>
				<tr>
					<td align='right'><input type='Button' class='Button' name='Ok' id='Ok' value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>   ' onclick='doClose()'></td>
				</tr>
				<tr>
					<td colspan=2></td>
				</tr>
			</table>
		</td></tr>
	</table>
</center>
</body>
</html>

