<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
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
<script language='javascript' src='../../eDS/js/Menu.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%   Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null; %>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
	<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="menuItemAdd_form" id="menuItemAdd_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MenuCycleServlet" method="post" target="messageFrame">

		<table width="100%" border='1' cellpadding='0' cellspacing='0' align='center' height='20'>
			<tr>
				<!-- <th  align='left' colspan='7' Height='18' style="background-color:black;color:white;font-size:8pt;font-weight: bolder;text-align: left;padding-left:7px;padding-right:7px;"> -->


				<th valign='top' class='ColumnHeaderCenter' style="display:block;visibility:visible;color:white;font-size:8pt;font-weight: bolder;text-align: left;padding-left:7px;padding-right:7px;">
					<fmt:message key="eOT.ItemsForMenu.Label" bundle="${ot_labels}"/>
				</th>

			</tr>
		</table>

		<table border='0' cellpadding='0' cellspacing='0' width="100%" align='center' >

			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.ItemSrl.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td>
					<input type="text" name="item_Srl" id="item_Srl" size="2" maxlength="2" onblur="checkNumberSrl(this);" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<% try{
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(DlQuery.DL_DS_ITEM_TYPE);
				pstmt.setString(1,locale);
				rst = pstmt.executeQuery();
			%>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td>
					<select name="item_Type" id="item_Type" onBlur="changeItemType(this)"><!-- Modified Aganist PMG2017-COMN-CRF-0012.1-US003 -->
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {%>
									<option value="<%=rst.getString("item_type")%>">
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
					System.err.println("Exception in Menu Time table:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}catch(Exception e){
						System.err.println("Exception in Menu Time Table:"+e);
						e.printStackTrace();
					}
				}
				%>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.Item.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td>
					<input type="text" name="item_Name" id="item_Name" size="15" maxlength="10" onblur="if(this.value!=''){ getLookup(item_Name); }" />
					<input type="button" name="click" id="click" value="?" onClick="getLookup(item_Name);" class="BUTTON" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>

			</tr>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.ItemQty.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td>
					<input type="text" name="item_Qty" id="item_Qty" size="4" maxlength="6" onblur="checkNumberQty(this)" />
					<img src='../../eCommon/images/mandatory.gif'></img>
					<input type=text name="units" id="units" readonly="true" class='label' style="background:transparent;border=0"/>
				</td>
			</tr>
				<tr align="right">
				<td align="right" colspan="3">
					<input type="button" class='BUTTON' name="select" id="select" value="<fmt:message key="Common.Select.label" bundle="${common_labels}"/>" onClick="selectRecord1();"/>
					<input type="button" class='BUTTON' name="cancel" id="cancel" value="<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>" onClick="cancelRecord();"/>
				</td>
			</tr>

		</table>

		<input type="hidden" name="locale" id="locale" value="<%=locale%>" />
		<input type='hidden' name='valueForNutCode' id='valueForNutCode' value=''>
		<input type='hidden' name='valueForItmtypCode' id='valueForItmtypCode' value=''><!-- Added Against PMG2017-COMN-CRF-0012.1-US003 -->
		<input type='hidden' name='forUpdate' id='forUpdate' value=''>
		<input type=hidden name="flag" id="flag" />

		</form>
	</body>
</html>


