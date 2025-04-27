<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		Connection con=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String record_exits_YN = "N";
		try {
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String spec_no_frmt_code = request.getParameter("spec_no_frmt_code") == null ? "" : request.getParameter("spec_no_frmt_code");
			
			String description = request.getParameter("description") == null ? "" : request.getParameter("description");
			String spec_no_format = request.getParameter("spec_no_format") == null ? "" : request.getParameter("spec_no_format");
			String mode = request.getParameter("mode") == null ? "I" : request.getParameter("mode");

			con = ConnectionManager.getConnection();
			String sql = "SELECT 'Y' FROM OR_CURRENT_SPEC_SEQ_VAL WHERE SPEC_NO_FRMT_CODE=?";			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1,spec_no_frmt_code);
			rs = stmt.executeQuery();

			if(rs.next()){
				record_exits_YN = rs.getString(1);				
			}
			if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();	
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../../eOR/js/ORSpecimenFmt.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="SpecFmtConstFrm" id="SpecFmtConstFrm">
			<table width='100%' align='center' cellpadding='0'>
				<tr>
						<td colspan="2">
							&nbsp;
						</td>						
				</tr>
				<tr>
						<td bordercolor='blue' width='10%' class="label">
							<fmt:message key="Common.code.label" bundle="${common_labels}"/>
						</td>
						<td bordercolor='blue' width='35%' align='left'>
							<input type="text"  size="30" maxLength="10" value='<%=spec_no_frmt_code%>' name="spec_no_frmt_code"    id="spec_no_frmt_code"  onkeypress="return CheckForSpecChars(event)" <%if(mode.equals("M")){%>disabled<%}%>><img src="../../eCommon/images/mandatory.gif" align=center></img>							
						</td>	
				</tr>
				<tr>
						<td bordercolor='blue' width='10%' class="label">
							<fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</td>
						<td bordercolor='blue' width='35%' align='left'>
							<input type="text"  size="30" maxLength="50" value="<%=description%>" name="description" id="description" onKeyPress="return  allowAlphaNumeric(event)" onBlur=" CheckSpecialChars(this)"><img src="../../eCommon/images/mandatory.gif" align=center></img>
						</td>	
				</tr>
				<tr>
						<td bordercolor='blue' width='35%' align='left' colspan="2">
							<br><b><fmt:message key="eCA.Constant.label" bundle="${ca_labels}"/></b><br>
							<input type="text"  size="30" maxLength="4" value='' id="constVal" name="constVal" onkeypress='return chkTildeAndGA()' onBlur='CheckSpecialChars1(this)'>&nbsp;&nbsp;
							<input type="button" class="button" value='Insert' name="insVal" id="insVal" size="10" onClick="newTextInt(document.forms[0].constVal);clearVal();">
						</td>	
				</tr>
				<tr> 
					<td colspan="3" wrap><fmt:message key="eOR.SpecimenNoFormat.label" bundle="${or_labels}"/></td> 
				</tr>
				<tr id="t"  width='100%'> 
					<td colspan="3" wrap> <div id="f"></div> </td> 
				</tr>
				<tr> 
					<td colspan="3" wrap> &nbsp;</td> 
				</tr>
				<tr>
						<td bordercolor='blue' class='label' width='40%' height='100%' colspan="2">  
							<b><fmt:message key="eCA.PlacingOption.label" bundle="${ca_labels}"/></b>							<input type="radio" class="radio" value='R' name="replaceOpt"  id="replaceOpt" > <a onclick=radioCheck(document.getElementById("replaceOpt"));> <fmt:message key="Common.Replace.label" bundle="${common_labels}"/> </a> &nbsp;&nbsp;
							<input type="radio" class="radio" value='IL' name="replaceLefOpt"  id="replaceLefOpt" > <a onclick=radioCheck(document.getElementById("replaceLefOpt"));> <fmt:message key="eCA.InsertLeft.label" bundle="${ca_labels}"/> </a>&nbsp;&nbsp;
							<input type="radio" class="radio" value='IR' name="replaceRigOpt"  id="replaceRigOpt"  checked> <a onclick=radioCheck(document.getElementById("replaceRigOpt"));> <fmt:message key="eCA.InsertRight.label" bundle="${ca_labels}"/> </a>&nbsp;&nbsp;		
							<br><br>
							<input type="button" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>' id="remov" name="remov" onClick="removeValue();"  >
							<input type="button" class="button" align="right" id="rese" name="rese" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>' name="resetBtn" onClick="onReset();" >
						</td>
				</tr>				
			</table>
			<input type='hidden' name='spec_no_format' id='spec_no_format' value = '<%=spec_no_format%>'>
			<input type='hidden' name='mode' id='mode' value = '<%=mode%>'>
			<script>			
			if ("<%=record_exits_YN%>" != "Y")
			{
				setTimeout("displayValues('<%=spec_no_format%>')",200);
			}else{
				var msg = getMessage("CANNOT_MODIFY_SPEC_FORMAT","OR")
				alert(msg);
				document.SpecFmtConstFrm.spec_no_frmt_code.disabled=false;
				document.SpecFmtConstFrm.spec_no_frmt_code.value="";
				document.SpecFmtConstFrm.description.value="";
				document.SpecFmtConstFrm.spec_no_format.value="";
				document.SpecFmtConstFrm.mode.value="I";
			}
			
		</script> 
		</form>		
		
	</body>
	<%}catch(Exception e){e.printStackTrace();}finally{
		if(con!=null)ConnectionManager.returnConnection(con);
		
		}%>
</html>

