<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// added by Arvind @  08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCA/js/QuickLinksForResp.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "";
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='' onKeyDown="lockKey()">
	<form name="QuickLink_Form" id="QuickLink_Form">
		<table border=0 cellspacing=0 cellpadding='3' width='90%' align='center'>
			<tr>
				<td class=label><fmt:message key="eCA.LinkType.label" bundle="${ca_labels}"/></td>
				<td class='fields'>
					<select name='ql_type' id='ql_type' onchange='showFields(this)'>
						<option value = ''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<option value = 'Q'><fmt:message key="eCA.Global.label" bundle="${ca_labels}"/></option>
						<option value = 'F'><fmt:message key="eCA.Filter.label" bundle="${ca_labels}"/></option>
					</select><img src="../../eCommon/images/mandatory.gif">
				</td>
			</tr>
			<tr>
				<td class=label><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type='text' name="function_name" id="function_name" value="" size='30' maxlength='60' onBlur="getFunction1(this)"><input type='button' class='button' value='?' name='search_ref' id='search_ref' onClick="getFunction()">
					<input type="hidden" name="function_id" id="function_id" value=''><img src="../../eCommon/images/mandatory.gif" style="display:none" id='mand_fun'>
				</td>
			</tr>
			
			<tr>
				<td class=label><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name='resp' id='resp' onchange='loadDesc(this)'>
						<option value = ''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
	<%
				try
				{
					con = ConnectionManager.getConnection(request);

					sql = "select a.resp_name description, a.resp_id code from sm_resp a where a.eff_status='E' order by upper(a.resp_name)";

					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
	%>
						<option value = '<%=rs.getString("code")%>'><%=rs.getString("description")%></option>
	<%
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
				finally
				{
					if(con != null)ConnectionManager.returnConnection(con,request);
				}
	%>			
					</select><img src="../../eCommon/images/mandatory.gif">
				</td>
			</tr>
			<tr>
				<td colspan="2" align='right'>
					<input type='button' class='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick = "showResult()">
				</td>
			</tr>
			
		</table>
		<!-- added by arvind @ 08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
	</form>
</body>
</html>

