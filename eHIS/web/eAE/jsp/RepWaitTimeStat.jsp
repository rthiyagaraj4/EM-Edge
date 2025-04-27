<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBWTSTA" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale						= (String)session.getAttribute("LOCALE");
    Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null ;
	ResultSet rset			= null ;
	//Statement stmt			= null;

	String currdate			= "";
try{
		con = ConnectionManager.getConnection(request);

		Boolean isPriorZoneApplicable = eCommon.Common.CommonBean.isSiteSpecific(con,"AE","PRIORITY_ZONE_WAIT_TIME_STATS");//Added by Thamizh selvi on 31st Jan 2017 against ML-MMOH-CRF-0724
		
	try {
		
	      String sql = "Select  to_char(sysdate,'dd/mm/yyyy') sys_date from dual";
		  pstmt = con.prepareStatement(sql);
	      rs    = pstmt.executeQuery();
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	currdate = rs.getString("sys_date") ;
			  }
		  }			
    
	if (rs    != null)    rs.close();
	if (pstmt != null) pstmt.close();

	} catch(Exception e) {e.printStackTrace();}
%>

<html>

<HEAD>
<TITLE></TITLE>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../js/AERepWaitTimeStat.js"></script>
        <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>
<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="RepWaitTimeStat" id="RepWaitTimeStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	

	<tr>

		<td width="80%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
					
					<tr><td class='label' height='5'></td></tr>						
					<tr>
					<td  class="label" width="25%"> <fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td width="25%"> 
							<select name='p_all_facility_id' id='p_all_facility_id' >
							<option value='ALL' selected><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
						<%
							try
							{
															

							String sql_facility="select facility_id, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID, '"+locale+"', 1) facility_name  from sm_facility_for_user where appl_user_id=?";				
							
							pstmt =con.prepareStatement(sql_facility);
							pstmt.setString(1,p_user_name);
							rset=pstmt.executeQuery();

							if(rset!=null)
							{
							   while(rset.next())
							   {
								String fid= rset.getString("facility_id");;
								String fname=rset.getString("facility_name");;
								if(fid == null) fid	=	"";
								if(fname == null) fname = "";

								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
							
							if(rset != null)rset.close();
							if(pstmt != null)pstmt.close();
							
							}catch(Exception e)
							{
								e.printStackTrace();
							}
							
						%>	
						</select>
					</td>
					<td width="25%"></td><td width="25%"></td>
				</tr>

				<tr>
					<td align='right' width='25%' class="label">&nbsp;</td>
				</tr>

				<tr>
						<td  width="25%" ></td>
						<td  width="25%" class='querydata' ><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
						<td class='querydata' width="30%" ><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
						<td width="25%"></td>
					</tr>
					<tr>
						<td class='label' width="25%"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
						<td width="25%"><input type=text id='deathregsfrom'  name='p_fm_visit_date' id='p_fm_visit_date' size="10" maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>')" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('deathregsfrom');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> 
						</td>
						<td width="25%"><input type=text id='deathregsto' name='p_to_visit_date' id='p_to_visit_date' size="10" maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>')" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('deathregsto');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> 
						</td>
						<td width="25%"></td>
				</tr>
				
				<tr><td colspan=4 height='5'></td></tr>

				<!--Added by Thamizh selvi on 31st Jan 2017 against ML-MMOH-CRF-0724 Start-->
				<%if(isPriorZoneApplicable){%>
				<tr>
					<td align='right' width='25%' class="label">  &nbsp;</td>
				</tr>

				<!--Added by Ashwini on 08-Feb-2018 for ML-MMOH-CRF-0892-->
				<tr>
					<td  class="label" width="25%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td width="25%"><input type="text" name="p_fr_locn_code" id="p_fr_locn_code" size="4" maxlength="4" onBlur='if(this.value != "") searchCode1(fromlocn,this);clearDetail1(this);'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode1(this,p_fr_locn_code);clearDetail1(this);'>
					</td>
				</tr>

				<tr>
					<td align='right' width='25%' class="label">&nbsp;</td>
				</tr>
				<!--End ML-MMOH-CRF-0892-->

				<tr>
						<td  class='label' width="25%">
							<fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/>
						</td>
						<td width="25%">
							<select name='p_priority_zone' id='p_priority_zone' >
								<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
								<%
									JSONArray priorZoneJsonArr	= new JSONArray();
									priorZoneJsonArr  = eAE.AECommonBean.getPriorityZoneList(con,locale,p_facility_id);	
									
									for(int i = 0 ; i < priorZoneJsonArr.size() ; i++) 
									{
											JSONObject json	= (JSONObject)priorZoneJsonArr.get(i);
											String PRIORITY_ZONE  = (String) json.get("PRIORITY_ZONE");
											String PRIORITY_ZONE_DESC  = (String) json.get("PRIORITY_ZONE_DESC");
											
											out.println("<option value='"+PRIORITY_ZONE+ "'>"+PRIORITY_ZONE_DESC+"</option>");
											
									}
									
									
								%>
							</select>
						</td>
						<td width="25%"></td>
						<td width="25%"></td>
				</tr>
				<tr>
					<td align='right' width='25%' class="label">  &nbsp;</td>
				</tr>
				
				<!--Added by Ashwini on 08-Feb-2018 for ML-MMOH-CRF-0892-->
				<tr>
					<td  class="label" width="25%"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td width="25%"><input type="text" name="p_fr_tmt_area_code" id="p_fr_tmt_area_code" size="4" maxlength="2" onBlur='if(this.value != "") nursCode(fromlocn1,this)'><input type='button' name='fromlocn1' id='fromlocn1' value='?' class='button' onclick='nursCode(this, p_fr_tmt_area_code)'>
					</td>
					<td width="25%"><input type="text" name="p_to_tmt_area_code" id="p_to_tmt_area_code" size="4" maxlength="2" onBlur='if(this.value != "") nursCode(tolocn1,this)'><input type='button' name='tolocn1' id='tolocn1' value='?' class='button' onclick='nursCode(this, p_to_tmt_area_code)'>
					</td>
				</tr>

				<tr>
					<td align='right' width='25%' class="label">&nbsp;</td>
				</tr>
				<!--End ML-MMOH-CRF-0892-->

				<%}%>
			<!--End-->

		</table>
	</td>
</tr>
</table>
<%
}catch(Exception e){
	e.printStackTrace();
}
finally { 
	if(con!=null)	ConnectionManager.returnConnection(con,request);
}
%>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_curr_date" id="p_curr_date"			value="<%= currdate%>">
<input type="hidden" name="locale" id="locale"			value="<%=locale%>">
</form>
<script>document.forms[0].p_all_facility_id.focus();</script>
</body>
</html>

