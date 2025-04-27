<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String called_from=checkForNull(request.getParameter("called_from"));
	Connection con	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs	= null;
	String facility_id=(String) session.getValue("facility_id");
%>
<html> 
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtSetupStyle.css"/>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src="../js/json2.js" language="JavaScript"></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/JQuery/ToolTip/jquery.cluetip.css"/>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtStyle.css"/>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/PopupStyle.css"/>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		
		
		<%
		if(called_from.equals("bed_mgmt_trns")){%>
			<script src='../../eIP/js/IPAdvBedMgmtTrns.js' language='javascript'></script>
			<script src='../../eIP/js/IPAdvBedMgmtSupplementary.js' language='javascript'></script>
		<%}else{%>
			<script src='../../eIP/js/IPAdvBedMgmtSetup.js' language='javascript'></script>			
		<%}%>
		<script type="text/javascript">
			var show=true;
			$(document).ready(function() {
				$('#showhidbedcolors').click(function (){
					if(show==true){
						document.getElementById("showhidbedcolors").src = "../../eIP/images/show_bedlegendsection.png";
						window.parent.document.getElementById('advBedMgmtFrameSet').rows = "0%,2.5%,5%,3.1%,0%,*,0%";
						show=false;
					}else{
						document.getElementById("showhidbedcolors").src = "../../eIP/images/hide_bedlegendsection.png";
						window.parent.document.getElementById('advBedMgmtFrameSet').rows = "0%,2.5%,5%,3.1%,7%,*,0%";
						show=true;
					}
				});
			});								
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body  onMouseDown="CodeArrest()" onKeyDown = "lockKey()">
		<%		
			try{
				if(called_from.equals("bed_mgmt_trns")){
					con=ConnectionManager.getConnection(request);
					String sqln="select NURSING_UNIT_CODE,IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID,NURSING_UNIT_CODE,?,2 )SHORT_DESC from IP_NURSING_UNIT where  facility_id=? and eff_status='E' order by 2";
					pstmt=con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy')sys_date,(select patient_id_length from mp_param)pat_id_length from dual");
					rs=pstmt.executeQuery();
					String sys_date="";
					String pat_id_length="";
					if(rs!=null && rs.next()){
						sys_date=rs.getString("sys_date");
						pat_id_length=rs.getString("pat_id_length");
					}
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
					pstmt=con.prepareStatement(sqln);
					pstmt.setString(1,localeName);
					pstmt.setString(2,facility_id);
					rs=pstmt.executeQuery();
					
				%>
					<table cellspacing=0 cellpadding=0 align='left' width='100%' height='100%'  border='0'>
						<tr>
							<td style='background-color:#3ca0b2;color:#FFFFFF;cursor:pointer' align='left' id='bedlegendsectn'><img id='showhidmenu' src='../../eIP/images/show_hide_menu.png' align='center' onclick='javascript:menuFun()'></img></td>
							<td class='label' style='background-color:#3ca0b2;color:#FFFFFF'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
							</td>
							<td align=left class='querydata' id=td3 style='background-color:#3ca0b2;color:#FFFFFF'>
								<select id="nursingunitcombo" name="nursing_unit" id="nursing_unit" onchange="popDynamicValues(false)">
									<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
									<%
										if(rs!=null){
											String id="";
											String desc="";
											while(rs.next()){
												id=rs.getString("NURSING_UNIT_CODE");
												desc=rs.getString("SHORT_DESC");
												out.println("<option value='"+id+"'>"+desc+"</option>");
											}
										}										
									%>
								</select>
							</td> 
							<td class='label' style='background-color:#3ca0b2;color:#FFFFFF'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td><td  class='fields' style='background-color:#3ca0b2;color:#FFFFFF'><input type='text' id="from_date" maxlength='10' size='10' name='from_date' id='from_date'  value="<%=sys_date%>" onBlur='validDateObj(this,"DMY","<%=sys_date%>");'disabled><img  src='../../eCommon/images/CommonCalendar.gif' onClick="/*document.forms[0].from_date.focus();*/return showCalendar('from_date');" disabled></td>
							<td class='label' colspan='2' style='background-color:#3ca0b2;color:#FFFFFF'><jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=pat_id_length%>" /><jsp:param name ="call_function"  value="adv_bed_mgmt" /></jsp:include></td>
							<td style='background-color:#3ca0b2;color:#FFFFFF'>&nbsp;</td>
							<td style='background-color:#3ca0b2;color:#FFFFFF'>&nbsp;</td>
							<td style='background-color:#3ca0b2;color:#FFFFFF;cursor:pointer' align='right' id='bedlegendsectn'><img id='showhidbedcolors' src='../../eIP/images/hide_bedlegendsection.png' align='center' ></img></td>
						</tr>
					</table>
				<%}else{
		%>
				<form name='bedMgmtSetupForm' id='bedMgmtSetupForm' method='post' action='../../servlet/eIP.NursingUnitBedServlet' target='messageFrame'>
					<table cellspacing=0 cellpadding=0 align='center' width='100%' height='100%'  border='0'>
						<tr>	 				
							<td align='middle' class='white'>
								<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
									<tr>
										<td  class='label' align='right'><fmt:message key="Common.setup.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.for.label" bundle="${common_labels}"/></td>
										<td  align ='left'>
											<select name="setupFor" id="setupFor" onChange='dipslayRoom(this)'>
												<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
												<option value="F"><fmt:message key="eIP.ConfigureFloor.label" bundle="${ip_labels}"/></option>
												<option value="R"><fmt:message key="eIP.ConfigureRooms.label" bundle="${ip_labels}"/></option>
												<option value="B"><fmt:message key="eIP.ConfigureBeds.label" bundle="${ip_labels}"/></option>
												<option value="CC"><fmt:message key="eIP.ConfigureColors.label" bundle="${ip_labels}"/></option>
											</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
										</td>
									</tr>
								</table>
							</td>
							<td align='middle' class='white' id='nursingUnitlabeltd' style="visibility:hidden;">
								<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
									<tr>
										<td  class='label' align='right'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
										<td  align ='left'>
											<select name='nursing_unit' id='nursing_unit' onChange='popDynamicValues(this)' >
												<option value='' >---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>				
											</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
										</td>
									</tr>
								</table>
							</td>
						<td  class='label' align='left' id='roomlabeltd' style="visibility:hidden;"><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
						<td id='roomtd' style="visibility:hidden;">
							<select name='room' id='room' onChange='roomBedLayout(this)' >
								<option value='' >---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>				
							</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
						</td>
						</tr>		
					</table>
				</form>
			<%}
		}catch(Exception e){
			e.printStackTrace();			
		}finally{
			ConnectionManager.returnConnection(con,request);
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
			}
		}
%>
	</body>


</html>
<%!

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

