<!DOCTYPE html>
<!--Created by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>

<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../js/ClaimantType.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8");
   String code = "";
   String short_desc = "";
   String long_desc = "";
   String effstatus = "";
   String codeTextAttribute = "";
   String checkBoxAttribute = "";
   String eventFunctionForCase = "";
   String enblOthrs = "";
   String disableAllFld = "";
   boolean newcomplaint = false;
   StringBuffer sql = new  StringBuffer();
   code = request.getParameter("claimant_type_mstr_code");
	
	if(code == null)
	{
		code = "";
		long_desc = "";
		short_desc = "";
		effstatus = "E";
		codeTextAttribute = "";
		checkBoxAttribute = "CHECKED";
		newcomplaint = true;
		eventFunctionForCase = "OnBlur='ChangeUpperCase(this)'";
	}else
	{
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try
		{
			sql.setLength(0);
			sql.append("select CLAIMANT_TYPE_MSTR_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS from MO_CLAIMANT_TYPE_MSTR where CLAIMANT_TYPE_MSTR_CODE=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,code);
			rset = pstmt.executeQuery();
			rset.next();
			code = rset.getString("CLAIMANT_TYPE_MSTR_CODE");

			if(("K").equals(code) || ("E").equals(code) || ("F").equals(code))
			{
				disableAllFld = "DISABLED";
			}else
			{
				disableAllFld = "ENABLED";
			}

			long_desc = rset.getString("LONG_DESC");
			short_desc = rset.getString("SHORT_DESC");
			effstatus = rset.getString("EFF_STATUS");
			
			if(effstatus.equals("D"))
			{
				checkBoxAttribute = "";
				enblOthrs = "READONLY";
			}else
			{
				checkBoxAttribute = "CHECKED";
			}
			sql.setLength(0);
		}
		catch(Exception e)
		{
			e.toString();
		}
		finally
		{
			if(rset!=null) 	rset.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}

		codeTextAttribute = "READONLY";
		newcomplaint = false;
		eventFunctionForCase = "";
	}
%>

<form name="claimant_type_mstr_form" id="claimant_type_mstr_form"  action='../../servlet/eMO.MOClaimantTypeMstrServlet' method='post' target='messageFrame'>

<br><br><br><br><br><br><br><br><br><br>

	<table cellspacing=0 cellpadding=5 align="center" width="80%" border="0">
	
		<tr>
			<td class="label" width="40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="claimant_type_mstr_code" id="claimant_type_mstr_code" size="2" maxlength="2" value="<%=code%>" <%=disableAllFld%> onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>>
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="long_desc" id="long_desc" size="60" maxlength="60" value="<%=long_desc%>" <%=enblOthrs%> <%=disableAllFld%> onBlur="makeValidString(this);">
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="short_desc" id="short_desc" size="30" maxlength="30" value="<%=short_desc%>" <%=enblOthrs%> <%=disableAllFld%> onBlur="makeValidString(this);">
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> <%=disableAllFld%> onClick="change()"></td>
		</tr>
	
	</table>

<%if(newcomplaint){%>
	<input type='hidden' name='function' id='function' value='insert'>
	<input type='hidden' name='function_name' id='function_name' value='insert'>
<%}else{%>
	<input type='hidden' name='function' id='function' value='modify'>
	<input type='hidden' name='function_name' id='function_name' value='modify'>
<%}%>

</form>
</body>
</html>

