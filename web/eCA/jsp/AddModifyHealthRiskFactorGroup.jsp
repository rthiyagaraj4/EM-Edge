 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/RiskFactorGroup.js'></script>
		<Script src ="../../eCommon/js/CommonLookup.js" language ="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%

%>
	</head>

	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='HealthRiskFactorGroup' id='HealthRiskFactorGroup' action='../../servlet/eCA.RiskFactorGroupServlet' method='post' target='messageFrame'>
		<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			Connection con = null;
			try{
			
			con = ConnectionManager.getConnection(request);
			String mode	   = request.getParameter( "mode" ) ;
			int rowID = 0;
			String enabled_checked = "";
			String rfiReadOnlyYN = "";
			String group_code = request.getParameter("group_id") == null? "" : request.getParameter("group_id");
			String group_desc = request.getParameter("group_desc") == null? "" : request.getParameter("group_desc");
			String eff_status = request.getParameter("eff_status") == null? "" : request.getParameter("eff_status");
			System.out.println( " MODE " + mode + "group_code " + group_code + " group_desc "+group_desc +" eff_status " + eff_status);
			
			if("E".equals(eff_status))
				enabled_checked = "checked";
			else
				enabled_checked = "";
				
			ResultSet resultSet = null;	
			HealthRiskFactorsBean beanObj = new HealthRiskFactorsBean();
			if(mode.equals("2")) {
				resultSet = beanObj.getGrpRiskFactorType(group_code, con);
				rfiReadOnlyYN		= "ReadOnly";
				rowID = 1;
			}
			else {
				rowID = -1;
			}			
		%>	
		<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='55%'>				
				<BR><BR><BR>
				<tr>
					<td class='label'  width='30%' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td width='70%'><input type='text'  name = "group_id"  size='20' maxlength = '20' onkeypress="return CheckForSpecChars(event)"  onblur = "refreshFooter()" value=<%=group_code %>  <%=rfiReadOnlyYN%> >
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>
					<td class='label'   width='30%' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td width='70%'><input type="textbox"  name = "group_desc"   maxlength = '60'  size='60' onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)' value ="<%= group_desc %>" >
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>
					<td class='label'  width='30%' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<% if(mode.equals("1")){ %>
					<td class='fields' width='70%'><input type="checkbox"  name="eff_status" id="eff_status" value= "E"  checked = "true" onclick = 'setEffStauts(this)'></td>		
					<% } else if(mode.equals("2")) {%>
					<td class='fields' width='70%'><input type="checkbox"  name="eff_status" id="eff_status" <%=enabled_checked%> value = <%= eff_status %> onclick = 'setEffStauts(this)'></td>		
					<% } %>
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>					
					<td class='label'  width='30%' ><fmt:message key="eCA.riskfactor.label" bundle="${ca_labels}"/></td>
					<td class='fields'  width='70%'>
						<input type="text"  name="risk_factor_desc_" id="risk_factor_desc_" value="" size='50'  maxlength = '100' onblur = 'riskFactorsearchOnClick(risk_factor_desc_)' >
						<input type='button' class='button' value='?'  onclick = 'riskFactorsearchOnClick(risk_factor_desc_)'>
						<input type="hidden" name="risk_factor_code_" id="risk_factor_code_" value=""> 
						<input type="button" value="Add" onClick="addRiskFactorsCode('RiskFactGrid',<%=mode%>)"/>
							
					</td>
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				
				<tr>
					<td colspan="2" >
						<DIV style="width:100%;height:430;overflow:auto">	
							<table  id='RiskFactGrid' name = 'RiskFactGrid' cellpadding='0' cellspacing='0' width="75%">
								<tr>
									<th width="70%" class='columnHeadercenter'><fmt:message key="eCA.riskfactor.label" bundle="${ca_labels}"/>s &nbsp;<img src='../../eCommon/images/mandatory.gif'></th>
									<th width="10%" class='columnHeadercenter'>
										<input type="button"  name="removeButton" id="removeButton" value="Remove" onClick="deleteRow('RiskFactGrid')" /> 
									</th>
								</tr> 
								<%
								if(mode.equals("2")) {
									while(resultSet.next()) {
								%>	<tr><td class='gridData'  ><%=  resultSet.getString("RISK_FACTOR_DESC") %></td>
									 
									<input type="hidden"  name="risk_fact_code<%= rowID%>" id="risk_fact_code<%= rowID%>" value=<%=  resultSet.getString("RISK_FACTOR_TYPE") %> >
									<td class='gridData'><input type="checkbox"  name="remove" id="remove" value= ""> 
									</td></tr>
								<%		rowID = rowID + 1;
									}
								}	
								%>
							</table>
						</DIV>
					</td>
				</tr>
			</table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>"/>
			<input type="hidden" name="rowID" id="rowID" value="<%=rowID %>" /> 
		</form>
	<%
	}
	catch(Exception ex){
		ex.getMessage();
	}
	finally{
		ConnectionManager.returnConnection(con,request);
	}
	%>	
	</body>
</html>

