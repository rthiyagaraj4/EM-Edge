<!DOCTYPE html>
<%@ page language="java" import="java.sql.Connection,java.util.*,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>Resource For Ambulance</title>
		<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/messages.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eAE/js/AMBResEquForVehicle.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'secForNoteTypeValuesForm'>
			<table cellpadding='5' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
					<td class='label' align='left' width='40%'> <fmt:message key="eMP.Ambulance.label" bundle="${mp_labels}"/> &nbsp;
						<select name = 'note_type' onChange = 'setTimeout("reloadFrames()",50)'>				
							<option value=''>-----------------Select-----------------</option>
			<%
				Connection con = null;
				PreparedStatement pstmtNoteType = null;
				ResultSet resNoteType = null;
				String note_type = "";
				String note_type_desc = "";
				String facilityId=(String)session.getValue("facility_id");
				try
				{					
					con = ConnectionManager.getConnection(request);
					String sql_note_type = "SELECT AMB_VEHICLE_NAME, AMB_VEHICLE_ID FROM AE_AMB_VEHICLE where facility_id = '"+facilityId+"' and eff_status='E' ORDER BY  AMB_VEHICLE_NAME ";
					pstmtNoteType = con.prepareStatement(sql_note_type);
					resNoteType = pstmtNoteType.executeQuery();
					while(resNoteType.next())
					{
						note_type = resNoteType.getString("AMB_VEHICLE_ID");
						note_type_desc = resNoteType.getString("AMB_VEHICLE_NAME");
						out.println("<option value="+note_type+"> "+note_type_desc+" </option>");
					} 
					if(resNoteType != null) resNoteType.close();
					if(pstmtNoteType != null) pstmtNoteType.close();
				}
				catch(Exception e)
				{
					//out.println("Exception "+e.toString());
					e.printStackTrace(System.err);
				}
				finally
				{
					if(con != null) ConnectionManager.returnConnection(con,request);
				}
			%>
				</select><img src="../../eCommon/images/mandatory.gif"></img></td>
				<td align = 'left' class='label' width ='30%'><input type='radio' name='amb_res_equip' id='amb_res_equip' value="RS" checked ><fmt:message key="Common.Staff.label" bundle="${common_labels}"/>&nbsp;<input type='radio' name='amb_res_equip' id='amb_res_equip' value="EQ" ><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></td>
				<td align='right'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="loadFrames();"></td>
				</tr>
			</table>
		</form>
	</body>	
</html>

