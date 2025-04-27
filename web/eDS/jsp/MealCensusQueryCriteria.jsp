<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="eDS.Common.DlQuery"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
String locale = (String) session.getAttribute("LOCALE");
String facility_id	= (String)session.getAttribute("facility_id");
 %>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/MealCensus.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type="text/javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 </head>
<%   
    //Checkstyle Violation commented by Munisekhar
	//String params = request.getQueryString() ;
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="getSysDate()">
		<form name="CensusQueryCriteria" id="CensusQueryCriteria">

		<br/>
		<br/>
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>

				</tr>
				<% try{
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement(DlQuery.DL_WARDS_KITCHEN_CODE);
					pstmt.setString(1,locale);
					pstmt.setString(2,facility_id);
					rst = pstmt.executeQuery();
				%>
				<tr>
					<td align="right" class="label">
						<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
					</td>

					<td>
						<select name="kitchen_Code" id="kitchen_Code">
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

					<td align="right" class="label">
						<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}"/>
					</td>
					<%pstmt = con.prepareStatement(DlQuery.DL_DS_NURSING_UNIT);
					pstmt.setString(1, locale);
					pstmt.setString(2, facility_id);
					rst = pstmt.executeQuery(); %>
					<td>

						<select name="nursing_Unit" id="nursing_Unit">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {%>
								<option value="<%=rst.getString("nursing_unit_code")%>">
								<%=rst.getString("short_desc") %>
								</option>
							<%}
								pstmt = null;
								rst = null;%>
							</select>
							<!-- Commented Against 57812 <img src='../../eCommon/images/mandatory.gif'></img>-->
					</td>
				<%//Checkstyle Correction added by Munisekhar
				       if(rst!=null) rst.close();
					   if(pstmt!=null) pstmt.close();
						

				}catch(Exception e){
					System.err.println("Exception in Attendents:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Attendents:"+e);
					}
				}
				%>

					<td align="right" class="label">
						<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type ="text" size="10" name="servDate" id="servDate" value="" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
						<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('servDate');">
					</td>
			</table>
			<br/>
			<table width="100%">
				<tr>
					<td width="33%"></td>
					<td width="25%"></td>
					<td width="25%"></td>
					<td width="17%" colspan='6' align="right" class="label">
						<input type="button" class='BUTTON' name="select" id="select" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onclick="submitForm();"/>
					</td>
				</tr>
			</table>

			<input type='hidden' name = 'locale' id = 'locale' value = '<%=locale %>'>
		</form>
	</body>
</html>

