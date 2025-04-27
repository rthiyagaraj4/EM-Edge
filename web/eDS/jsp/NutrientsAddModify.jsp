<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/Nutrients.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String nutrients = "";
   String shortDesc = "";
   String longDesc = "";
   String uom = "";
   String nutrientConversion = "";
   String energyConversion = "";
   String enabledYn = "";

   String nutrientsCode = request.getParameter("nutrients");
   String disabled_flag = "";
   String readOnlyFlag = "";

   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_NUTRIENTS);
	   		pstmt.setString(1,locale);
	   		pstmt.setString(2,nutrientsCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			nutrients = rst.getString("nutrients_code");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			uom = rst.getString("uom_code");
	   			nutrientConversion = rst.getString("nutrient_conversion");
	   			energyConversion = rst.getString("energy_conversion");
	   			enabledYn = rst.getString("eff_status");
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Nutrients->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Nutrients:"+e);
			}
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="nutrients_form" id="nutrients_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.NutrientsServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.NutrientCode.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="nutrients" id="nutrients" value="<%=nutrients %>" size="4" maxlength="4" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc %>"  size="30" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="short_Desc" id="short_Desc" value="<%=shortDesc %>" size="15" maxlength="15" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
						pstmt.setString(1, locale);
						rst = pstmt.executeQuery();
				%>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Uom.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="uom" id="uom" onchange="getUnit(this);">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("uom_code").equals(uom)){%>
									<option value="<%=rst.getString("uom_code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("uom_code")%>">
								<%} %>
							<%=rst.getString("short_desc") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<%}

				catch(Exception e){
					System.err.println("Exception in UOM:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in UOM:"+e);
					}
				}
				%>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabledYn)){ %>
								<input type="checkbox" name="enabled_Yn" id="enabled_Yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="enabled_Yn" id="enabled_Yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enabled_Yn" id="enabled_Yn"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<tr>
			</tr>
			</table>
			<br>
			<table id="description" border='0' cellpadding='2' cellspacing='0' width='75%' align='center' class='COMMON_TOOLBAR'>
			<tr class='button'>
			<th colspan='4' align='left'>
			<fmt:message key="eOT.EnergyConversion.Label" bundle="${ot_labels}"/><br>
			</th>
			</tr>
			<tr>
			<td colspan='4'>&nbsp</td>
			</tr>
				<tr>
				<td align="right" class='label'>
					<input type="text" name=nutrient_Conversion value="<%=nutrientConversion %>" size="4" maxlength="4" onblur="return CheckPosNumber('nutrient_Conversion')" />
					<img src='../../eCommon/images/mandatory.gif'></img>
					<input type=text name="nutUnits" id="nutUnits" readonly="true" class='label' value="<%=uom %>" style="background:transparent;border=0;border: transparent;"/>
				</td>

				<td>=</td>
				<td  align="left" class='label'>
					<input type="text" name=energy_Conversion value="<%=energyConversion %>" size="4" maxlength="4" onblur="return CheckPosNumber('energy_Conversion')" />
					<img src='../../eCommon/images/mandatory.gif'></img>
					<input type=text name="energyUnits" id="energyUnits" readonly="true" class='label' value="Calories" style="background:transparent;border=0 ;border: transparent;"/>
				</td>
				</tr>

				<tr>
				<td colspan='3'>
					<br>
				</td>
				</tr>
			</table>

			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updNutrients' id='updNutrients' value='<%=nutrients%>'>
		</form>
	</body>
</html>


