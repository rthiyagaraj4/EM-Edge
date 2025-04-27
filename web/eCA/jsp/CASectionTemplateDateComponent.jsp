<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language="JavaScript">
<!--
function loadFormulaInfo()
{
	var formulaVal = window.dialogArguments;
	var plusIndex = formulaVal.indexOf("+");
	var minusIndex = formulaVal.indexOf("-");
	if(formulaVal != "")
	{
		if(plusIndex == -1)
			document.CASectionTemplateDateComponentForm.operationAllowed.value = "minus";
		else
			document.CASectionTemplateDateComponentForm.operationAllowed.value = "plus";		
		var i = formulaVal.indexOf("$$$");
		var j = formulaVal.indexOf("###");
		var firstComponent = formulaVal.substring(i+3,j);
		document.CASectionTemplateDateComponentForm.firstComponent.value = firstComponent;
		i = formulaVal.indexOf("$$$", j);
		j = formulaVal.indexOf("###", j+3);
		var secondComponent = formulaVal.substring(i+3,j);	
		if(isNaN(secondComponent))
			document.CASectionTemplateDateComponentForm.secondComponent.value = secondComponent;
		else
		{
			document.CASectionTemplateDateComponentForm.secondComponent.value = "***CONSTANT***";
			document.getElementById("constantTR").style.display = "inline";
			document.CASectionTemplateDateComponentForm.constantValue.value = secondComponent;
		}
	}
}
//-->
</script>
<title>
</title>
<%  
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String sec_hdg_code		=request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");	
	String comp_id				=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");	
	String formulaResultType = request.getParameter("formulaResultType")==null?"":request.getParameter("formulaResultType");
	String formulaResultUnits = request.getParameter("formulaResultUnits")==null?"":request.getParameter("formulaResultUnits");
	//String includeDates				=request.getParameter("includeDates");	
	String temp_comp_id = "";
	String comp_desc  = "",srl_no = "";
	//out.println(includeDates + "=" + formulaResultType);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
	try
	{
		con = ConnectionManager.getConnection(request);

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="loadFormulaInfo()">
	<form name="CASectionTemplateDateComponentForm" id="CASectionTemplateDateComponentForm">
		<table width='100%' cellpadding='3' align='center' >
			<tr>
				<td class='columnheader'><fmt:message key="eCA.FirstOperand.label" bundle="${ca_labels}"/></td>		
				<td class='columnheader'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
				<td class='columnheader' colspan='2'><fmt:message key="eCA.SecondOperand.label"  bundle="${ca_labels}"/></td>			
			</tr>
			<tr>
				<td class='fields'>
					<select name="firstComponent" id="firstComponent">
						<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<%
							try
							{
								String qry = "select comp_id ,comp_prompt,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_desc, srl_no from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id != ? and comp_type in ('D','E') and accept_option in ('O','D') order by row_pos_no,column_pos_no";
								pstmt = con.prepareStatement(qry);
								pstmt.setString(1,  sec_hdg_code);
								pstmt.setString(2,  comp_id);
								rs = pstmt.executeQuery();
								while(rs.next())
								{
									temp_comp_id = rs.getString("comp_id");
									comp_desc = rs.getString("comp_desc");
									srl_no = rs.getString("srl_no");
									out.println("<option value=\"" + temp_comp_id + "!" + srl_no + "\">" + temp_comp_id + "</option>");
								}
								if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
							}
							catch(Exception e)
							{
								e.printStackTrace();
								//out.println("Exception caught-->1.00-->" + e);//COMMON-ICN-0181
							}
						%>
						<option value="systemDate!99999A">*<fmt:message key="Common.CurrentDate.label" bundle="${common_labels}"/>*</option>
						<option value="systemDateTime!99999A">*<fmt:message key="Common.CurrentDateTime.label" bundle="${common_labels}"/>*</option>
					</select>
				</td>
				<td class='fields'>
				<%if(formulaResultType.equals("D")){%>
					<select name="operationAllowed" id="operationAllowed">
						<option value="plus"><fmt:message key="eCA.Plus.label" bundle="${ca_labels}"/></option>
						<option value="minus"><fmt:message key="eCA.Minus.label" bundle="${ca_labels}"/></option>
					</select>
				<%}else{%>
					<input type="hidden" name="operationAllowed" id="operationAllowed" value="minus">
					<fmt:message key="eCA.Minus.label" bundle="${ca_labels}"/>
				<%}%>
				</td>
				<td class='fields'>
					<select name="secondComponent" id="secondComponent" onchange="changeSecondComponent(this);">
						<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<%
							try
							{								
								StringBuffer qry = new StringBuffer("select comp_id ,comp_prompt,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_desc, srl_no from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id != ? and ");
								if(formulaResultType.equals("D"))
									qry.append(" comp_type in ('N','I') ");									
								else
									qry.append(" comp_type in ('D','E') ");
								qry.append(" and accept_option in ('O','D') order by row_pos_no,column_pos_no ");
								pstmt = con.prepareStatement(qry.toString());
								pstmt.setString(1,  sec_hdg_code);
								pstmt.setString(2,  comp_id);
								rs = pstmt.executeQuery();
								while(rs.next())
								{
									temp_comp_id = rs.getString("comp_id");
									comp_desc = rs.getString("comp_desc");
									srl_no = rs.getString("srl_no");
									out.println("<option value=\"" + temp_comp_id + "!" + srl_no + "\">" + temp_comp_id + "</option>");
								}
								if(formulaResultType.equals("N"))
								{
									out.println("<option value=\"systemDate!99999A\">*Current Date*</option>");
									out.println("<option value=\"systemDateTime!99999A\">*Current Date/Time*</option>");
								}
								else
									out.println("<option value=\"***CONSTANT***\">*Constant*</option>");

								if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}							
							%>
					</select>
				</td>
                <td>
								<select name="formulaResultUnits" id="formulaResultUnits">
									<option value="Hours" <%=formulaResultUnits.equals("Hours")?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
									<option value="Minutes"<%=formulaResultUnits.equals("Minutes")?"selected":""%>><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
									<option value="Days" <%=formulaResultUnits.equals("Days")?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
									<option value="Weeks" <%=formulaResultUnits.equals("Weeks")?"selected":""%>><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
									<option value="Months" <%=formulaResultUnits.equals("Months")?"selected":""%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
									<option value="Years" <%=formulaResultUnits.equals("Years")?"selected":""%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
								</select>
							</td> 
			</tr>
			<tr style="display:none" id="constantTR">
				<td colspan="2">
					&nbsp;
				</td>
				<td colspan="2">
					<table>
						<tr>
							<td class="label" >
									<fmt:message key="eCA.ConstantValue.label" bundle="${ca_labels}"/> 
							</td>
					        <td class="fields" >
								<input type="text" name="constantValue" id="constantValue" value="" size="2" maxlength="2" onKeyPress="return allowValidNumber(this,event,1,0)">
							</td>
							
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught -->1.01-->" + e);//common-icn-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con, request);
	}
							%>
</body>

