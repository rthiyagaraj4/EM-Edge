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
<script language='javascript' src='../../eDS/js/Kitchen.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String kitchen = "";
   String shortDesc = "";
   String longDesc = "";
   String enabledYn = "";
   String disabled_flag = "";
   //Checkstyle Violation commented by Munisekhar
   //String kitchenCode = request.getParameter("kitchen");
   //String readOnlyFlag = "";
   //Connection con = null;
   //ResultSet rst = null;
 // PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
%>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="kitchenAreaAdd" id="kitchenAreaAdd"  onload='FocusFirstElement()'  action="../../servlet/eDS.KitchenAreaServlet" method="post" target="messageFrame">

				<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center' height='30%'>
						<tr>
							<td class='label'>
								<fmt:message key="eOT.KitchenAreaCode.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="text" name="kitchen_Code" id="kitchen_Code" value="<%=kitchen %>" size="4" maxlength="4" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
						<tr>
							<td class='label' >
								<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc %>"  size="30" maxlength="30" />
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
						<tr>
							<td  class='label'>
								<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="text" name="short_Desc" id="short_Desc" value="<%=shortDesc %>" size="15" maxlength="15" />
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>

						<tr>
							<td  class='label'>
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
							<td align="left" class="label" colspan=2>
								<input class="BUTTON" type="button" name="select" id="select" value="Select" onClick="selectRecord1();"/>
								<input type="button" class='BUTTON' name="cancel" id="cancel" value="Cancel" onClick="cancelRecord();"/>
							</td>
						</tr>
					</table>

			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updKitchenCode' id='updKitchenCode' value='<%=kitchen%>'>
			<input type='hidden' name='forUpdate' id='forUpdate' value=''>
		</form>
	</body>
</html>


