<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eAE/js/ReleaseBay.js' language='javascript'></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<%
		request.setCharacterEncoding("UTF-8");
		Connection con	= null;
		PreparedStatement pstmt =null;
		String locale			= (String)session.getAttribute("LOCALE");

		ResultSet rs=null;
		String facilityid	= checkForNull((String)session.getValue("facility_id"));
		String loginUser	= checkForNull((String)session.getValue("login_user"));
		String operstn		= "";
		String sys_date_time="";
		StringBuffer sqlAM = null;
	try{

			con =ConnectionManager.getConnection(request);

				    sqlAM = new StringBuffer();
				    sqlAM.append("select a.oper_stn_id oper_stn_id,to_char(sysdate,'dd/mm/yyyy hh24:mi')sys_date from ");
					sqlAM.append(" am_oper_stn a, am_user_for_oper_stn b,dual ");
					sqlAM.append(" where a.facility_id= ? ");
					sqlAM.append(" and a.facility_id=b.facility_id ");
					sqlAM.append(" and a.oper_stn_id = b.oper_stn_id ");
					sqlAM.append(" and b.appl_user_id = ?  ");
					sqlAM.append(" and trunc(sysdate) between b.eff_date_from  ");
					sqlAM.append(" and  nvl(b.eff_date_to,trunc(sysdate)) ");
					pstmt=con.prepareStatement(sqlAM.toString());
					pstmt.setString(1, facilityid);
			        pstmt.setString(2, loginUser);
					rs=pstmt.executeQuery();
					if(rs != null && rs.next())
					{
						operstn	 = checkForNull(rs.getString("oper_stn_id"));
						sys_date_time=rs.getString(2);

					}
					
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				    if((sqlAM != null) && (sqlAM.length() > 0))
					  {
						sqlAM.delete(0,sqlAM.length());
					  } 

                
	%>
		<form name="releasebed_criteriaform" id="releasebed_criteriaform" action='../jsp/ReleaseBayResult.jsp' method='post' target='messageFrame'>
			<input type="hidden" name="sys_date_time" id="sys_date_time" value = "<%=sys_date_time%>">
			<input type="hidden" name="fac_id" id="fac_id" value = "<%=facilityid%>">
		 <table cellpadding='0' cellspacing='0' border='0' width='100%' > 
			<tr>
	<td>
					<table cellpadding='0' cellspacing='0' border='0' width='100%' >
						<tr><td  class='label' height='5'></td></tr>
						<tr>
							<td  class='label' width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td  width='25%' class='fields' >
								<select name="clinic_code" id="clinic_code" onChange="popTreatmentCode(this);">
									<option value=''>&nbsp;&nbsp;------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------&nbsp;&nbsp;
								<%
									

                                  
									
									String sqlAELoc="select clinic_code, long_desc clinic_desc from OP_CLINIC_LANG_VW where language_id='"+locale+"' and eff_status = 'E' AND LEVEL_OF_CARE_IND = 'E' and (facility_id,clinic_code,clinic_type) in (select facility_id,locn_code,locn_type from AM_OS_USER_LOCN_ACCESS_VW where facility_id =? and oper_stn_id =? and appl_user_id = ? and RELEASE_BED_BAY_YN='Y')order by 2";
									pstmt=con.prepareStatement(sqlAELoc);
									pstmt.setString(1, facilityid);
									pstmt.setString(2, operstn);
									pstmt.setString(3, loginUser);

									rs=pstmt.executeQuery();
									if(rs != null)
									{
										while(rs.next())
										{
											%>
												<option value='<%=rs.getString("clinic_code")%>' ><%=rs.getString("clinic_desc")%>
											<%
										}
									}
									if(rs != null) rs.close();
									if(pstmt != null) pstmt.close();
									
								%>
								</select>
							</td>
							<td  class='label' width='25%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
							<td class='fields'  width='25%'>
								<input type='text' name='treatment_area_desc' id='treatment_area_desc' size=15 onblur='GetLookupBlur(treatment_area,treatment_area_desc)'>
								<input type=button class=button name='treatment_area_lookup' id='treatment_area_lookup' value='?' disabled onClick='GetLookup(treatment_area,treatment_area_desc)'>
									<input type=hidden class=label name=treatment_area >
									<input type=hidden name="treatment_areadesc_hid" id="treatment_areadesc_hid" value=''>
							</td>
					</tr>
					<tr>
							<td   class='label'  width='25%'><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></td>
							<td class='fields' width='25%'>
								<input type='text' name='bay_type_desc' id='bay_type_desc' size=15 onblur='GetLookupBlur(bay_type,bay_type_desc)'>
								<input type=button class=button name='bay_type_lookup' id='bay_type_lookup' value='?' onClick='GetLookup(bay_type,bay_type_desc)'>
									<input type=hidden class=label name=bay_type >
									<input type=hidden name="bay_typedesc_hid" id="bay_typedesc_hid" value=''>					
							</td>								
						
						
							<td class="label" width='25%'><fmt:message key="eAE.ReserveUntil.label" bundle="${ae_labels}"/></td>
							<td  class="field" width='25%'>						
								<input type="text" id="reserve_until" name="reserve_until" id="reserve_until" size=14 maxlength=16 value="" onKeyPress='return(CheckNumberInput(this,event,2));' onblur="DateCompare(sys_date_time,this);dateVal(sys_date_time,this);"><img src='../../eCommon/images/CommonCalendar.gif'  id="resCaln" onClick="reserve_until.focus();return showCalendar('reserve_until', null, 'hh:mm');" style='cursor:pointer'></img>							
							</td>
						</tr>
					<tr>
							<td >&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
							<td  class="field" width='25%'>
								<input type="button" class="button" name="search" id="search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="javascript:showresult();" >
								<input type="button" class="button"  name="clear" id="clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="javascript:clearValues();">
							</td>								
						</tr>
					</table>
	</td>
			</tr>
									<tr><td  class='label' height='5'></td></tr>
		</table>
		
		</form>
<%
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)
			ConnectionManager.returnConnection(con,request);
}
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
%>
</body>
</html>

