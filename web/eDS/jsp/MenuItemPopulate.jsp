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
PreparedStatement pstmt = null;
int totalRows = 0;
String mode = request.getParameter("mode");
String menu = request.getParameter("menu");
%>
	<br>
		<fmt:setLocale value="<%=locale %>"/>
		<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="menuItemAdd_form" id="menuItemAdd_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MenuCycleServlet" method="post" target="messageFrame">
		<table border='1' cellspacing='0' width='100%' align='center' id="listContentTable"  height='20'>
			<tr>
				<th valign='top' class='ColumnHeaderCenter' style="visibility:visible;color:white;font-size:8pt;font-weight: bolder;text-align: center;padding-left:7px;padding-right:7px;">
					<fmt:message key="eOT.ItemSrl.Label" bundle="${ot_labels}"/>
				</th>
				<th class='ColumnHeaderCenter' style="visibility:visible;color:white;font-size:8pt;font-weight: bolder;text-align: center;padding-left:7px;padding-right:7px;">
					<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}"/>
				</th>
				<th class='ColumnHeaderCenter' style="visibility:visible;color:white;font-size:8pt;font-weight: bolder;text-align: center;padding-left:7px;padding-right:7px;">
					<fmt:message key="eOT.Item.Label" bundle="${ot_labels}"/>
				</th>
				<th class='ColumnHeaderCenter' style="visibility:visible;color:white;font-size:8pt;font-weight: bolder;text-align: center;padding-left:7px;padding-right:7px;">
					<fmt:message key="eOT.ItemQty.Label" bundle="${ot_labels}"/>
				</th>
			</tr>
			<%try{
				if("modify".equals(mode)){
					con = ConnectionManager.getConnection(request);
					
					System.out.println("locale locale locale locale locale"+locale);
					pstmt = con.prepareStatement(DlQuery.DL_GET_MENU_ITEM);
					pstmt.setString(1,menu);
					pstmt.setString(2,locale);

					rst = pstmt.executeQuery();
					int cnt = 2;
					int hdn = 0;					
					while(rst.next()){
						int counter=cnt-1;
				%>
			<tr>
				<td><%=rst.getInt("item_sl") %></td>

				<!-- Modified Against PMG2017-COMN-CRF-0012.1-US003 Starts Here -->
				<td><%=rst.getString("Item_Type_SDes") %>
				<input type='hidden' name='itemTypeCode<%=counter%>' id='itemTypeCode<%=counter%>' value='<%=rst.getString("item_type") %>'/>
				</td>

				<td>
					<a href='javascript:callfn12(<%= cnt%>)'><%=rst.getString("Item_SDes") %></a>
				<!-- Modified Against PMG2017-COMN-CRF-0012.1-US003 Ends Here -->
					<input type='hidden' name='itemCode<%=counter%>' id='itemCode<%=counter%>' value='<%=rst.getString("item_code") %>'/>
				</td>

				<td><%=rst.getInt("item_qty") %></td>
				<input type='hidden' name='nutMode<%=hdn%>' id='nutMode<%=hdn%>' value='U'>
			</tr>
			<%
					cnt++;
					hdn++;
					}
					totalRows = hdn;
				}
			}catch(Exception e){
					e.printStackTrace();
			}finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}catch(Exception e){
						e.printStackTrace();
					}
				}%>
		</table>
		<input type="hidden" name="locale" id="locale" value="<%=locale%>" />
		<input type='hidden' name='valueForNutCode' id='valueForNutCode' value=''>		
		<input type='hidden' name='forUpdate' id='forUpdate' value=''>
		<input type='hidden' name="flag" id="flag" />
		<input type='hidden' name='totalRows' id='totalRows' value='<%=totalRows%>'>
		<input type="hidden" id="itemCode" name="itemCode" id="itemCode" value=""/>
		</form>
	</body>
</html>

