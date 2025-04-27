

<%@ page import="java.sql.*,java.util.*, webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con= null;
	
%>

<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		 
		 String report_id = request.getParameter("report_id")==null?"":request.getParameter("report_id");
		 String func_id = request.getParameter("func_id")==null?"":request.getParameter("func_id");
		 String module_id = request.getParameter("module_id")==null?"MP":request.getParameter("module_id");
		 String report_desc = request.getParameter("report_desc")==null?"":request.getParameter("report_desc");
		 String module_name = request.getParameter("module_name")==null?"":request.getParameter("module_name");

		 String func_name = request.getParameter("func_name")==null?"":request.getParameter("func_name");
		 String dflt_online_print_yn = "";
		 String checkedYN="";

   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eSM/js/DefaultOnlinePrint.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function setValueForDfltPrint(obj){
	if(obj.checked==true){
		document.forms[0].dflt_chk_yn.value='Y';
	}else{
		document.forms[0].dflt_chk_yn.value='N';
	}
}

</script>
</head>
<body  onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()" >
<form name="dflt_online_print_form" id="dflt_online_print_form" action="../../servlet/eSM.DefaultOnlinePrintServlet'" method="post"  target="messageFrame">
<!-- <table width="100%" align="center">
<tr>
		<td width="100%" > -->
		<div align='center'>
					<br><br><br><br><br><br><br><br><br><br>
				<center>
<table border='0' cellpadding='6' cellspacing='0' width='60%'>
				
				<tr>
					<td class="label"   ><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
					<td  class='fields' ><input type="text" name ="Module_name" value="<%=module_name%>" size="30" readonly/> 
					<input type='hidden' name="Module" id="Module" value="<%=module_id%>" />
					</td>
				</tr>
				<tr>
				<td class="label"  ><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
				<td  class='fields' ><input type="text" name ="Function_name" value="<%=func_name%>" size="30" readonly>
				<input type='hidden' name="Function" id="Function" value="<%=func_id%>" /></td></tr>
				<tr>
				<td class="label" ><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
				<td  class='fields'  ><input type="text" name ="Report_name" value="<%=report_desc%>"  size="30" readonly>
				<input type='hidden' name="Report" id="Report" value="<%=report_id%>" /></td></tr>
				<tr>
				<td class="label"  ><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
				<%
				try{
					con=ConnectionManager.getConnection(request);
					//String dfl_chk_sql="select DFLT_ONLINE_PRINT_YN from sm_dflt_online_print where module_id='"+module_id+"' and report_id='"+report_id+"' and function_id='"+func_id+"'";
					String dfl_chk_sql="select DFLT_ONLINE_PRINT_YN from sm_dflt_online_print where module_id=? and report_id=? and function_id=?";
					PreparedStatement pstmt=con.prepareStatement(dfl_chk_sql);
					pstmt.setString	(	1,	module_id		);
					pstmt.setString	(	2,	report_id		);
					pstmt.setString	(	3,	func_id		);
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()){
						dflt_online_print_yn=rs.getString(1)==null?"N":rs.getString(1);
					}
					if(dflt_online_print_yn.equals("Y")){
						 checkedYN="checked";
					 }else{
						 checkedYN="";
					 }
					 if (rs!=null) rs.close();
					 if(pstmt!=null) pstmt.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					if(con != null)
						ConnectionManager.returnConnection(con,request);
				}
				%>
				<td  class='fields'  ><input type="checkbox" name="dfltPrint" id="dfltPrint" onChange="setValueForDfltPrint(this);"  <%=checkedYN%> /> </td>
				</tr>
	</table>
<input type='hidden' name='dflt_chk_yn' id='dflt_chk_yn' value='<%=dflt_online_print_yn%>' />

</form>
</body>

</html>

