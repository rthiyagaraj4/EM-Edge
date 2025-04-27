<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE");
   String facility_id	= (String)session.getAttribute("facility_id"); //43883 %>
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
<script language='javascript' src='../../eDS/js/WardsForKitchen.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%   Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	   //Checkstyle Violation commented by Munisekhar
	   //String dietType = "";
	   //String mealClass = "";
	   //String readOnlyFlag = "";
	    String disabled_flag = "";
	   
	    String mode = "";%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
		<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<fmt:setBundle basename="eCommon.resources.Labels" var="common_labels"/>
		<form name="wardsList_form" id="wardsList_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.WardsForKitchenServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_WARDS_KITCHEN_CODE);
						pstmt.setString(1,locale);
						pstmt.setString(2,facility_id); //43883
						rst = pstmt.executeQuery();
				%>
				<br>
				<br>
				<tr>
					<td>
						<table border='0' cellpadding='2' cellspacing='0' width='50%' align='center'>
						<tr>
							<td align="right" class='label'>
								<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<select name="kitchen_Code" id="kitchen_Code" <%=disabled_flag %> onchange="loadBottomPage(this);">
									<option value="">
										<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
									</option>
									<%while(rst.next()) {%>
											<option value="<%=rst.getString("kitchen_code")%>">
									<%=rst.getString("short_desc") %>
									</option>
									<%}
									pstmt = null;
									rst = null;%>
								</select>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				<%}

				catch(Exception e){
					System.err.println("Exception in Menu Time table:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Menu Time Table:"+e);
					}
				}
				%>
			</table>
			<br>
			<br>

			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name=selectedWards id=selectedWards value=''>
			<input type='hidden' name=removedWards id=removedWards value=''>
		</form>
	</body>
</html>


