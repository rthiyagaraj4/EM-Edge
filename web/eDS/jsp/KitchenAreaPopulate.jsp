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
<%
//Checkstyle Violation commented by Munisekhar
  // String kitchen = "";
  // String shortDesc = "";
  //String longDesc = "";
  //String enabledYn = "";

   String kitchenCode = request.getParameter("kitchen")==null?"":request.getParameter("kitchen");
   String kitchen_Code = request.getParameter("kitchen_code")==null?kitchenCode:request.getParameter("kitchen");
  /* if("".equals(kitchen_Code)&&(!("".equals(kitchenCode)))){
	   kitchen_Code = kitchenCode;
   }*/
   //String disabled_flag = "";
   //String readOnlyFlag = "";
	int totalRows = 0;
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
%>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="kitchenArea_form" id="kitchenArea_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.KitchenAreaServlet" method="POST" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
				<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement("SELECT kitchen_code,long_desc FROM ds_kitchens_lang_vw WHERE language_id = ?");
						pstmt.setString(1, locale);
						rst = pstmt.executeQuery();
				%>
				<tr>
				  <td  class='label'>
					<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/> <!-- Modified Against PMG2017-COMN-CRF-0012 [IN066074] -->
				  </td>
				  <td align="left">
					<select name="kitchenArea" id="kitchenArea" onchange="getKitchenAreas(this);">
						<option value="">
							<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
						</option>
							<%while(rst.next()) {
								if(rst.getString("kitchen_code").equals(kitchenCode)){%>
									<option value="<%=rst.getString("kitchen_code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("kitchen_code")%>">
								<%} %>
							<%=rst.getString("long_desc") %>
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
					System.err.println("Exception in Food Item:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Food Item:"+e);
					}
				}
				%>
				</table>
				<br>
				<br>
								<table border='1' cellpadding='2' cellspacing='0' width='100%' align='center' id="listContentTable">
								<tr>
								<td class="COLUMNHEADERCENTER" nowrap>
									<fmt:message key="eOT.KitchenAreaCode.Label" bundle="${ot_labels}"/>
								</td>
								<td class="COLUMNHEADERCENTER" nowrap>
									<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
								</td>
								<td class="COLUMNHEADERCENTER" nowrap>
									<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
								</td>
								<td class="COLUMNHEADERCENTER" nowrap>
									<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
								</td>
								</tr>
								<%
								try{
									con = ConnectionManager.getConnection(request);
									pstmt = con.prepareStatement("select kitchen_area_code,long_desc,short_desc,eff_status from ds_kitchen_area where kitchen_code = ?");
									pstmt.setString(1, kitchen_Code);
									rst = pstmt.executeQuery();
									int i=0;
									int cnt=2;
									while(rst.next()){%>
										<tr>
										<td><a href='javascript:callfn12(<%=cnt %>);'><%=rst.getString("kitchen_area_code")%></a></td>
										<td><%=rst.getString("long_desc")%></td>
										<td><%=rst.getString("short_desc")%></td>
										<td><%if("E".equals(rst.getString("eff_status"))){ %>
												<img src='../../eCommon/images/enabled.gif'></img>
											<%}
											else{%>
												<img src='../../eCommon/images/RRnwd.gif'></img>
											<%} %></td>
										</tr>
										<input type='hidden' name='nutMode<%=i %>' id='nutMode<%=i %>' value='U'>
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
			<input type='hidden' name='valueForKitCode' id='valueForKitCode' value=''>
			<input type='hidden' name='totalRows' id='totalRows' value='<%=totalRows%>'>
		</form>
	</body>
</html>


