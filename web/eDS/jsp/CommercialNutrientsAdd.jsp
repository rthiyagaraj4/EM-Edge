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
<script language='javascript' src='../../eDS/js/CommercialFoodItem.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% // Checkstyle Violation commented by Munisekhar
   //String nutrient = "";
   String contentValue = "";
   String uomCode = "";

   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
%>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="CommercialNutrientsAdd" id="CommercialNutrientsAdd"  onload='FocusFirstElement()'  action="../../servlet/eDS.CommercialFoodItemServlet" method="post" target="messageFrame" style="width: 100%; max-width: 500px; margin: 20px auto;">

				<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' height='30%' style="margin: 20px 0;">
						<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_COM_NUTRIENTS);
						pstmt.setString(1, locale);
						rst = pstmt.executeQuery();
						%>
						<tr style="margin-bottom: 15px;">
							<td class='label' align="right">
								<fmt:message key="eOT.Nutrient.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<select name="nutrients_List" id="nutrients_List" onchange="getNutrientsUom(this);">
								<option value="">
									<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
								</option>
								<%while(rst.next()) {%>
										<option value="<%=rst.getString("nutrients_code")%>">
								<%=rst.getString("short_desc") %>
								</option>
								<%}
								pstmt = null;
								rst = null;%>
								</select>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
						<%

						}

						catch(Exception e){
							System.err.println("Exception in Food Item Nutrients:"+e);
						}

						finally{
							try{
								if(pstmt!=null) pstmt.close();
								if(rst!=null) rst.close();
								ConnectionManager.returnConnection(con);
							}
							catch(Exception e){
								System.err.println("Exception in Food Item Nutrients:"+e);
							}
						}
						%>
						<tr style="margin-bottom: 15px;">
							<td class='label' align="right">
								<fmt:message key="eOT.ContentValue.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="text" name="content_Value" id="content_Value" value="<%=contentValue %>"  size="15" maxlength="15" onblur="CheckPosNumber('content_Value')"/>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>

						<tr style="margin-bottom: 15px;">
							<td class='label' align="right">
								<fmt:message key="eOT.UOMCode.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="text" name="uom_Code" id="uom_Code" value="<%=uomCode %>"  size="15" maxlength="15" />
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>

						<tr>
							<td align="right" class="label">
								<input class="BUTTON" type="button" name="select" id="select" value="Select" onClick="selectRecord1();"/>
								<input type="button" class='BUTTON' name="cancel" id="cancel" value="Cancel" onClick="cancelRecord();"/>
							</td>
						</tr>
					</table>

			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='forUpdate' id='forUpdate' value=''>
		</form>
	</body>
</html>


