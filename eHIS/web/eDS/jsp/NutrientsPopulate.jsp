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
<script language='javascript' src='../../eDS/js/FoodItemNutrients.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%   //Checkstyle Violation commented by Munisekhar
    //String nutrients = "";
   //String contentValue = "";
	String foodItem = request.getParameter("foodItem");
	int totalRows = 0;
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
%>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="nutrients_form" id="nutrients_form"  onload='FocusFirstElement()'   method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
				<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_FOOD_ITEM);
						pstmt.setString(1, locale);
						rst = pstmt.executeQuery();
				%>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/>
					</td>
					<td align="left">
						<select name="nutrients_List" id="nutrients_List" onchange="getNutrients(this);">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
							if(rst.getString("food_item_code").equals(foodItem)){%>
									<option value="<%=rst.getString("food_item_code")%>" selected>
									<%}
							else{%>
							<option value="<%=rst.getString("food_item_code")%>">
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
				</table>
				<br>
				<br>

								<table border='1' class="grid" cellpadding='2' cellspacing='0' width='98%' align='center' id="listContentTable">
								<tr>
								<th class="columnheadercenter" align="left">
									<fmt:message key="eOT.Nutrient.Label" bundle="${ot_labels}"/>
								</th>
								<th class="columnheadercenter" align="left">
									<fmt:message key="eOT.ContentValue.Label" bundle="${ot_labels}"/>
								</th>
								</tr>
								<%
								try{
									con = ConnectionManager.getConnection(request);
									pstmt = con.prepareStatement(DlQuery.DL_DS_GET_NUTRIENTS_FOOD);
									pstmt.setString(1, foodItem);
									rst = pstmt.executeQuery();
									int i=0;
									int cnt=2;
									while(rst.next()){%>
										<tr>
										<td><a href='javascript:callfn12(<%=cnt %>);'><%=rst.getString("short_desc") %></a></td>
										<td><%=rst.getString("content_value") %></td>
										</tr>
										<input type='hidden' name='nutMode<%=i %>' id='nutMode<%=i %>' value='<%=rst.getString("nutrient_code")+"::U" %>'>
										<%i++;
										cnt++;%>
									<%}
									totalRows = i;
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
							</table>




			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='valueForNutCode' id='valueForNutCode' value=''>
				<input type='hidden' name='totalRows' id='totalRows' value='<%=totalRows%>'>
		</form>
	</body>
</html>


