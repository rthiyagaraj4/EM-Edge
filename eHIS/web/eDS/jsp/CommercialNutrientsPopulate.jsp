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
<%
   int totalRows = 0;
   String kitchenCode = request.getParameter("foodItem")==null?"":request.getParameter("foodItem");
   String nutCode = request.getParameter("nutCode")==null?kitchenCode:request.getParameter("nutCode");
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;
   String mode = request.getParameter("mode");
%>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="comNutrients_form" id="comNutrients_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.CommercialFoodItemServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eDS.CommercialFoodItem.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<input type="text" name="commercial_Formula" id="commercial_Formula" value="<%=kitchenCode %>" size="15" maxlength="15" onblur="if(this.value!=''){ getLookup(commercial_Formula); }"/>
						<input type="button" class='BUTTON' name="lookUp" id="lookUp" value="?" onClick="getLookup(commercial_Formula);"/>
							<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
			</table>
			<table>
				<tr>
			<table border='1' cellpadding='2'  cellspacing='0' width='100%' align='right' id="listContentTable">
				<tr>
					<th class="columnheadercenter" nowrap>
						<fmt:message key="eOT.Nutrient.Label" bundle="${ot_labels}"/>
					</th>
					<th class="columnheadercenter" nowrap>
						<fmt:message key="eOT.ContentValue.Label" bundle="${ot_labels}"/>
					</th>
					<th class="columnheadercenter" nowrap>
						<fmt:message key="eOT.UOMCode.Label" bundle="${ot_labels}"/>
					</th>
				</tr>
				<%
				try{
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement(DlQuery.DL_COM_NUT_LIST);
					pstmt.setString(1, nutCode);
					rst = pstmt.executeQuery();
					int i=0;
					int cnt=2;
					while(rst.next()){%>
					<tr>
						<td><a href='javascript:callfn12(<%=cnt %>);'><%=rst.getString("short_desc") %></a></td>
						<td><%=rst.getString("content_value") %></td>
						<td><%=rst.getString("uom_code") %></td>
					</tr>
									<input type='hidden' name='nutMode<%=i %>' id='nutMode<%=i %>' value='<%=rst.getString("nutrient_code")+"::U" %>'>
				<% i++;
				   cnt++;
					}
						totalRows = i;
					}catch(Exception e){
						System.err.println("Exception in Food Item Nutrients:"+e);
						e.printStackTrace();
					}finally{
						try{
							if(pstmt!=null) pstmt.close();
							if(rst!=null) rst.close();
							ConnectionManager.returnConnection(con);
						}catch(Exception e){
							System.err.println("Exception in Food Item Nutrients:"+e);
							e.printStackTrace();
						}
					}
					%>
			</table>
				</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='valueForNutCode' id='valueForNutCode' value='<%=nutCode%>'>
			<input type='hidden' name='totalRows' id='totalRows' value='<%=totalRows%>'>
		</form>
	</body>
</html>

