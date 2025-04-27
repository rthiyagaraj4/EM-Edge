<!DOCTYPE html>
<html>     
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
				String p_facility_id	= (String) session.getValue( "facility_id" ) ;
				String p_user_name		= (String) session.getValue( "login_user" ) ;
				String locale = (String)session.getAttribute("LOCALE");

					Connection conn = null;
					int i=0;
try
{
	request.setCharacterEncoding("UTF-8");	

					conn = ConnectionManager.getConnection(request);	
%>
		<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eOA/js/repApptStatsByDayOfMonthByPract_SRR.js" language="javascript"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>


		<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='document.forms[0].P_FM_SPECIAL.focus()'> 
		<form name="ApptStatsMonthPractform" id="ApptStatsMonthPractform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
		 <table border="0" cellpadding="0" cellspacing="0" width='65%' align='center'>

		 <tr>
				<td class="label" >&nbsp;</td>
				<td class='QUERYDATA'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class="label" >&nbsp;</td>
				<td class='QUERYDATA'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
			<td  class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>

			</td>

			<td class='fields' nowrap>
				<input type="text" name="P_FM_SPECIAL" id="P_FM_SPECIAL" size="15" maxlength="15" onblur='if(this.value !="") searchCode1(this, P_FM_SPECIAL,p_fm_speciality)' ><input type="hidden" name="p_fm_speciality" id="p_fm_speciality"><input type='button' name='speciality' id='speciality' value='?' class='button'  onclick='searchCode1(this, P_FM_SPECIAL,p_fm_speciality)'>
			</td>
			<td class="label"  >&nbsp;</td>

			<td class='fields' nowrap>
				<input type="text" name="P_TO_SPECIAL" id="P_TO_SPECIAL" size="15" maxlength="15" onblur='if(this.value !="") searchCode1(this, P_TO_SPECIAL,p_to_speciality)'><input type="hidden" name="p_to_speciality" id="p_to_speciality"><input type='button' name='speciality1' id='speciality1' value='?' class='button' onclick='searchCode1(this, P_TO_SPECIAL,p_to_speciality)'>
			</td>
	  </tr>
	  <tr>
			<td class='label' colspan=4>&nbsp;</td>
		</tr>	
		
		<tr>
			<td  class="label" width='25%' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>

			<td class='fields' width='30%'nowrap><SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
                                      <OPTION value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
                                      <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                                      <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                                      <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
									  <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
                                     </SELECT>
			</td>
			<td class="label" width='15%'>&nbsp;</td>
			<td class="label" width='30%'>&nbsp;</td>
		</tr>

		<tr>
			<td class='label' colspan=4>&nbsp;</td>
		</tr>	
		
			
		<tr>
				<td  class="label" nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

				<td   class='fields' nowrap>
				<SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);'>
				<OPTION value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---                          
				</SELECT></td>

				<td class="label"  >&nbsp;</td>
				<td  class='fields'><SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
				 <OPTION value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
				 </SELECT></td>
		</tr>
		
		<tr>
				<td class='label' colspan=4>&nbsp;</td>
		</tr>	

				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" flush="true" >
				<jsp:param name ="from_page" value= "stats" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>

		<!-- <tr>
			<td  class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td  class='fields' nowrap><input type="text" name="from_pract_code" id="from_pract_code" disabled onblur="onblurcheck(this,from_pract_code)"size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick='callPractSearch(this, from_pract_code)'>
			</td>

			<td class="label" >&nbsp;</td>
			<td  class='fields'><input type="text" name="to_pract_code" id="to_pract_code" onblur="onblurcheck(this,to_pract_code)" disabled size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' value='?' disabled class='button' onclick='callPractSearch(this, to_pract_code)'>
			</td>


		</tr> -->

		<tr>
			<td class='label' colspan=4>&nbsp;</td>
		</tr>	
 
	<tr>
			<td  class='Label'><fmt:message key="eOA.StatisticsMonth.label" bundle="${oa_labels}"/></td>
			<td  class='fields'><select name="mon" id="mon" >
					<option value =''>-<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-</option>
				<%

					for(i=1;i<13;i++)
					{
						out.println( "<option value='"+i+"' >"+i+"</option>" ) ; 
					}

				%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				
			<td class='label'><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
			<td  class='fields'> 
			<input type='text' name='years' id='years' value="" id='yr' size="5"  maxlength="4"  onkeypress = 'return allowValidNumber(this,event,4,0)' onBlur='validateYear(this)'><img  style="cursor:pointer"  src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].years.select();return showCalendar('yr','y')"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
 	</tr>

	<tr>
			<td class='label' colspan=4>&nbsp;</td>
	</tr>
	<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] Start-->
	<%
	Boolean isAppointmentThrough	= CommonBean.isSiteSpecific(conn, "OA","OA_PORTAL_APP_REPORTS");
	if(isAppointmentThrough){
	
	%>
	<tr>
		<td  class="label" width='25%' nowrap><fmt:message key="eOA.AppointmentThrough.label" bundle="${oa_labels}"/></td>

		<td class='fields' width='30%'nowrap>
			<select name="P_APPT_THROUGH" id="P_APPT_THROUGH">
				<OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>			
				<OPTION value='O'><fmt:message key="eOA.Online.label" bundle="${oa_labels}"/>
				<OPTION value='H'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
			</select>
		</td>
		<td class="label" width='15%' colspan="2">&nbsp;</td>
	</tr>
	<%} else{%>
	<input type='hidden' name='P_APPT_THROUGH' id='P_APPT_THROUGH' value='A' />
	<%}%>
	<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] End-->

	<input type='hidden' name='P_From_Pract_Code' id='P_From_Pract_Code' value=''></input>
	<input type='hidden' name='P_To_Pract_Code' id='P_To_Pract_Code' value=''></input>
	<input type='hidden' name='P_Start_Month' id='P_Start_Month' value=''></input>	
	<input type='hidden' name='P_Start_Year' id='P_Start_Year' value=''></input>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value='<%=p_facility_id%>'></input>
	<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
	<input type="hidden" name="p_report_id" id="p_report_id"   value="OADMPRST"></input>
	<input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''></input>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
	 <!-- Monday, March 29, 2010 20345 venkat S -->
	<input type='hidden' name='p_fm_locn_code' id='p_fm_locn_code' value=''>
	<input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value=''>

	
  </table>
</form>
</body>
<%
 }
catch ( Exception e )
{
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{  	
	ConnectionManager.returnConnection(conn,request);
}

%>
<script>document.forms[0].fm_pract_type.focus();</script>
</html>

