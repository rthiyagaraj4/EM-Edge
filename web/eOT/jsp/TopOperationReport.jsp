<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>          
<% String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eOT/js/TopOperationRep.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String sql="";
			String strCode ="";
			String strDesc ="";
			String servingDate="";
			String patient_id_length="";

			try{

				conn = ConnectionManager.getConnection(request);


				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();

		%>
	<form name="TopOperationRep" id="TopOperationRep" method="post"  target="messageFrame">
		<table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td></tr>
			<tr>
				<td align="left" class="label">
					<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<input type="text" name="fromOperationDate_disp" id="fromOperationDate_disp" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur="isValidDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('fromOperationDate_disp');">
					<img src='../../eCommon/images/mandatory.gif' />
					<!-- Added by MuthuN 43650 -->
					<input type='hidden' name='fromOperationDate' id='fromOperationDate' value='<%=DateUtils.convertDate(servingDate,"DMY",locale,"en")%>'>
				</td>
				<td align="right" class="label">
					<fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<input type="text" name="toOperationDate_disp" id="toOperationDate_disp" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur="isValidDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('toOperationDate_disp');">
					<img src='../../eCommon/images/mandatory.gif' />
					<!-- Added by MuthuN 43650 -->
					<input type='hidden' name='toOperationDate' id='toOperationDate' value='<%=DateUtils.convertDate(servingDate,"DMY",locale,"en")%>'>
				</td>	
			</tr>
			<tr>
				<td align="left" class="label">
					<fmt:message key="eOT.count.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<input type="text" name="count" id="count" maxlength="5" size="5" onkeypress="numericFilter()" onblur="checkNum(this.value);"
>
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>
			<%
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally
			{
				if(rst !=null) rst.close();
				if(pstmt !=null) pstmt.close();
				ConnectionManager.returnConnection(conn);
			}
			%>
		</table>
		<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
		<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
 		<input type="hidden" name="p_report_id" id="p_report_id" value="OTTOPOPR">
		<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
		<input type="hidden" name="pgm_id" id="pgm_id" value="OTTOPOPR">
		<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
</form>
</body>

</html>

