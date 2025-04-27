<!DOCTYPE html>
       
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper " %>
<%
String facilityId = (String) session.getValue( "facility_id" ) ; 
%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eOA/js/PractDutyRoster.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
PreparedStatement pstmt=null;
Statement stmt=null,stmt3=null;
ResultSet rset=null,rset3=null ;


String shortdesc1="",currentdate = "",clinictype = "",locncode = "",shortdesc ="",locn_desc = "",ondutydate = "",carelocn="",clinictype1="",sel1="",sel2="",sel3="",sel4="",practitionercode="",practitioner_name="";

String fnval = "insert";
String dis = "DISABLED" ;
String oper_stn_id=request.getParameter("oper_stn_id");

practitionercode = request.getParameter("practitioner_code");
practitioner_name = request.getParameter("practitioner_name");
if(practitionercode == null) practitionercode="";
if(practitioner_name == null) practitioner_name="";
String fromdate=request.getParameter("fromdate");
if(fromdate==null) fromdate="";
String todate=request.getParameter("todate");
if(todate==null) todate="";
String locn = request.getParameter("locn_code");
if(!(locn == null || locn.equals(""))){
	StringTokenizer st1 = new StringTokenizer(locn,"|");
	st1.nextToken();
}
		
String resource1=request.getParameter("resource1");
String locations=request.getParameter("locations");
if(locations==null)locations="";
if(resource1==null)resource1="";
if(locn==null)locn="";	

if(!(locn == null) || (!locn.equals(""))){
		
	StringTokenizer st = new StringTokenizer(locn,"|");
	
	while(st.hasMoreTokens()){
		locncode = st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();			
		st.nextToken();
	}
}
String locale=(String)session.getAttribute("LOCALE");
clinictype = request.getParameter("clinic_type")== null ? "" :request.getParameter("clinic_type") ;
String pract_id = request.getParameter("pract_id");
String cname = request.getParameter("cname");
String practname = request.getParameter("practname");
String on_duty_day = request.getParameter("on_duty_day");
String resourceq = request.getParameter("resourceq");
if(resourceq==null) resourceq="";
String resource7 = request.getParameter("resource7");
if(resource7==null) resource7="";
String carelocnind = request.getParameter("carelocnind");
String c_code = request.getParameter("c_code") == null ? "" : request.getParameter("c_code") ;
request.getParameter("operating_facility_id") ;
ondutydate = request.getParameter("onduty_date") == null ? "" : request.getParameter("onduty_date") ;

String ondutydate_disp=DateUtils.convertDate(ondutydate,"DMY","en",locale);

try{
	con = ConnectionManager.getConnection(request);	
	if (pract_id!=null ){
		fnval="delete";
	}

	%>
	</head>

	<body onLoad="chgbuttonclr();" OnMouseDown="CodeArrest()";  onLoad='FocusFirstElement();'  onKeyDown = 'lockKey()' >
	<form name='PractDutyRoster_form' id='PractDutyRoster_form' action='../../servlet/eOA.PractDutyRosterServlet' method='post' target='messageFrame'>

	<div>

	<center>
	
<table  id='table1' border='0' cellpadding='0' cellspacing='0'  width='100%' >
		<tr width='100%'><td colspan=4>&nbsp;</td></tr>
		<tr width='100%'>
					<TD class="label" width='25%' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></TD>
					
					<TD class="fields"  width='25%'>
						<%if(fnval.equals("delete")){%>
							<input type='text' size='15' maxlength='15' name='location11' id='location11' value='<%=clinictype%>' READONLY>
						<%}else{
							String sql1="select locn_type, short_desc, care_locn_type_ind,to_char(sysdate,'dd/mm/yyyy') d from am_care_locn_type_lang_vw where language_id = '"+locale+"' and SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y')  order by short_desc";
							stmt3=con.createStatement();
							rset3=stmt3.executeQuery(sql1);%>
							<select name='location1' id='location1' onChange='ClearDetail1();getLocation(this);'>
							<option  value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
							<%
							if(rset3!=null){
							
								while(rset3.next()){ 
									shortdesc1=rset3.getString("short_desc");
									clinictype1=rset3.getString("locn_type");
									carelocn=rset3.getString("CARE_LOCN_TYPE_IND");
									currentdate = rset3.getString("d");
									
									%>
									<option value='<%=clinictype1%>|<%=carelocn%>'><%=shortdesc1%></option>
									<% 
								}

							}
							%>
							</select><img src='../../eCommon/images/mandatory.gif' align='center'></img> <%}%>
						</td>
								
						<TD class="label" width='25%' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>	
						
						<TD class="fields"  width='25%'>
						<%if(fnval.equals("delete")){%>
							<input type='text' size='15' maxlength='15' name='location_name' id='location_name' value='<%=cname%>' READONLY><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
						<%}else{%>	
							<!--<select name='location' id='location' onchange='javascript:checkinIdentification(this);'>
							<option  value=''  align=right >----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------------</option>-->
                     <input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);"><input type="hidden" name="location" id="location" ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'>

							</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
							
						<%}%>
							</td>
		</tr>
		<tr>
						
						<TD class="label"  width='25%' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></TD>
						<TD class="fields" width='25%' nowrap >
							<%
							
							if(fnval.equals("delete")){%>
								<input type='text' size='15' maxlength='15' name='resourced1' id='resourced1' value="<%=resourceq%>" READONLY>
											
							<%}else{ %>
								<select name='resource' id='resource'     onchange="enable_dsiable_res(this)" disabled >
								<option  value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
								<option  value='P' <%="P".equals(resource1)?sel1="selected":sel1%> ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
								<option  value='E' <%="E".equals(resource1)?sel2="selected":sel2%> ><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
								<option  value='R' <%="R".equals(resource1)?sel3="selected":sel3%> ><fmt:message key="Common.room.label" bundle="${common_labels}"/></option>
								<option  value='O' <%="O".equals(resource1)?sel4="selected":sel4%> ><fmt:message key="Common.other.label" bundle="${common_labels}"/></option>
								</select><img id = 'imgpract1' src='../../eCommon/images/mandatory.gif' ></img>
							<% } %>
							</td>

						
							
							<%
							if(fnval.equals("delete")){
								shortdesc = locn_desc;
							}
							
							%>
										
							<input name = 'locn_type' type = 'hidden' size='15' maxlength = '15' value='<%=shortdesc%>' >
							
							<%
								if(fnval.equals("delete")){%>
								<TD class="label"  width='25%' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></TD>
							
						<TD class="fields" width='25%' nowrap ><input type='text'size='18' maxlength='18' name='practitioner_name' id='practitioner_name' value="<%=practname%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
							<%}else{%>	
							
							<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "duty_roaster" />
					<jsp:param name ="pract_value" value= "" />
					</jsp:include>
					
										
							<%}%>
								
							</td>
	</tr> 


	<tr width='100%'>

							<%if(fnval.equals("delete")){%>
					<td width='25%' class='label'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					
					<td class='fields' width='25%'  >
						<input type='text' size='10' maxlength='10' name='onduty_date' id='onduty_date' value='<%=ondutydate_disp%>' READONLY><input type='hidden' name='onduty_date1' id='onduty_date1' value='<%=ondutydate%>'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
								
					<td class='label' >&nbsp;</td>	
					
					<td class='fields' width='25%' >
						<input type='text'size='10' maxlength='10' name='on_duty_day' id='on_duty_day' value='<%=on_duty_day%>' READONLY><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
						
					
						
	</tr>
					
					<%
						}else{%>
					
					<td  width='25%' class=label nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
					
					<td   class='fields' width='25%' nowrap>
					
						<input type='text' id='dutyrosterfrom' name='eff_from' id='eff_from' size='14' maxlength='10' value='<%=fromdate%>' Onblur="validate_date_from(this,'<%=currentdate%>');compare_from(this,eff_to);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].eff_from.select();return showCalendar('dutyrosterfrom');">
						<input type='hidden' name='eff_from_date' id='eff_from_date' size='10' maxlength='10' value=''><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
						
					<td  width='20%' class=label nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
					
					<td   class='fields' width='25%' nowrap>
						
						<input type='text' id='dutyrosterto'  name='eff_to' id='eff_to' size='14' maxlength='10' value="<%=todate%>"  Onblur='validate_date_to(this,eff_from);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].eff_to.select();return showCalendar('dutyrosterto');">
						<input type='hidden' name='eff_to_date' id='eff_to_date' size='10' maxlength='10' value=''><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>
	<tr>
					

					<td  class='button' colspan='4' align='right' ><input type='button' name='Select_button' id='Select_button'  onclick="show_details()" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' class = 'button' <%=dis%> ></td>
	</tr>
							<%}%>
	</tr>

	<tr width='100%'><td   id='roster1' colspan='1' style='visibility:visible' nowrap class='label'>&nbsp;</td>
	<td   id='roster' colspan='2' style='visibility:visible' nowrap class='label'>&nbsp;</td>
	<td   id='roster2' colspan='1' style='visibility:visible' nowrap class='label'>&nbsp;</td> 
	
	
	</tr>
	</table>
		
	<%
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
	if(pstmt!=null)	pstmt.close();
	if(stmt!=null)	stmt.close();
	if(stmt3 !=null) stmt3.close();
	if(rset3 !=null) rset3.close();


}catch (Exception e) {
	// out.print(e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{

	//Changes
			  
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

</div>

<input type='hidden'  name='locale' id='locale' value='<%=locale%>' >
<input type='hidden'  name='locationd1' id='locationd1' value='<%=carelocnind%>' > 
<input type='hidden'  name='resourced' id='resourced' value='<%=resource7%>' > 
<input type='hidden'  name='location_code' id='location_code' value='<%=c_code%>' >
<input type='hidden' name='pract_id' id='pract_id' value='<%=pract_id%>' > 
<input type='hidden' name='function_nam' id='function_nam' value='' >
<input type='hidden' name='checkdtlframe' id='checkdtlframe' value='NO'>		
<input type='hidden' name='roster_defined' id='roster_defined' value=''>	<!-- Added by S.Sathish for IN020568 on Thursday, April 08, 2010 -->	
<input type='hidden' name='noofdays' id='noofdays' value=''>
<input type='hidden' name='function' id='function' value='<%=fnval%>'>
<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input  type='hidden' name='locationk' id='locationk' value=''>
<input type='hidden' name='locn_code' id='locn_code' value='<%=locncode%>'>
<input type='hidden' name='locncode1' id='locncode1' value='<%=locncode%>'>
<input  type='hidden' name='location1k' id='location1k' value=''> 
<input type='hidden' name='carelocnk' id='carelocnk' value=''>
<input type='hidden' name='practitionerk' id='practitionerk' value=''>
<input type='hidden' name='resourcek' id='resourcek' value=''>  
<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityId%>'>  
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'> 

</form>
</body>
</html>


