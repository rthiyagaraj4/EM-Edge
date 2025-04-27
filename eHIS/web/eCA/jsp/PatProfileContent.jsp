<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/PatProfileContent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function loadmsgframe(){
				parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";				
			}
		</script>
	</head>
	<%
	Connection conn				= null;
	PreparedStatement pstmt	= null;
	ResultSet rs					= null;

	int rowCount			= 0;
	String sql_sel_query			= "";
	String classval					= "";
	String content_id				= "";
	String content_sys_def_desc = "";
	String content_user_def_desc= "";
	String order_seq_no			= "";
	String include_yn				= "";
	String strChecked = "";

	sql_sel_query	="select content_id, CONTENT_SYS_DEF_DESC,CONTENT_USER_DEF_DESC,ORDER_SEQ_NO,INCLUDE_YN  from ca_patient_profile_content";

	try{
		conn	= ConnectionManager.getConnection();
		pstmt	= conn.prepareStatement(sql_sel_query);
		rs		= pstmt.executeQuery();
	%>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="formPatProfileContent" id="formPatProfileContent" action="" method="post">
<br><br><br><br><br><br>
<div style="display: flex; justify-content: center;" >
<table  width='80%' class='grid'  >
<td class='COLUMNHEADERCENTER' width='35%'><fmt:message key="Common.SystemDescription.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='35%'><fmt:message key="eCA.UserDefinedDescription.label" bundle="${ca_labels}"/></td>	
<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></td>	
<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>	
<% 
	while(rs.next())
	{
		strChecked="";
		rowCount++;
		classval = ((rowCount%2)==0 )? "gridData" : "gridData";
		content_id				= rs.getString("content_id");
		content_sys_def_desc	= rs.getString("content_sys_def_desc");
		content_user_def_desc	= rs.getString("content_user_def_desc");
		order_seq_no			= rs.getString("order_seq_no")==null?"":rs.getString("order_seq_no");
		include_yn				= rs.getString("include_yn");
		if (include_yn.equals("Y"))
			strChecked=" checked ";
		if(content_user_def_desc == null || content_user_def_desc.equals("null"))
			content_user_def_desc="";
	%> 	
		<tr>	
			<td class='<%=classval%>' width='35%'>
				<input type="hidden" name="content_sys_def_desc<%=content_id%>" id="content_sys_def_desc<%=content_id%>" value="<%=content_sys_def_desc%>">	
				<%=content_sys_def_desc%>
			</td>
			<td class='<%=classval%>' width='35%' >
				<input type="text" name="content_user_def_desc<%=content_id%>" id="content_user_def_desc<%=content_id%>" value="<%=content_user_def_desc%>" maxLength=40 size=40 onclick="loadmsgframe()">	
			</td>
			<td class='<%=classval%>' width='20%' >
				<input type="text" name="order_seq_no<%=rowCount%>" id="order_seq_no<%=rowCount%>" value="<%=order_seq_no%>" size=6 onkeypress=" return allowValidNumber(order_seq_no<%=rowCount%>,event,3,0)" OnBlur='checkSequence(this)' maxLength=3 onclick="loadmsgframe()">	
			</td>
			<td class='<%=classval%>'  width='10%'>
				<input type="checkbox" name="include_yn<%=content_id%>" id="include_yn<%=content_id%>" <%=strChecked%> onclick="loadmsgframe()">
			</td>
		</tr>
	<input type='hidden' name ='content_id<%=rowCount%>' value ='<%=content_id%>'>
	<%		
	}	%>
	</table>
	</div>
	<input type='hidden' name='rowCnt' id='rowCnt'  value="<%=rowCount%>"> </input>
<%

if(rs!=null) rs.close();
if(pstmt!=null) pstmt.close();							
}
catch(Exception e)
{
//out.println("Exception in try of PatProfileContent.jsp:"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
}
finally
{

if(conn!=null) ConnectionManager.returnConnection(conn,request);
}	
%>

</form> 
</body>
</html>

