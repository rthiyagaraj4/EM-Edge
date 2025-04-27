<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
     
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eOA/js/repMRPullingListForAppt.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<%
	String p_module_id		= "OA" ;
	String p_report_id		= "OABMRPLA" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_passing_local_date="";
	String locale = (String)session.getAttribute("LOCALE");
	if(locale.equals("th"))
	{
		p_passing_local_date="Y";
	}else 
	{
		p_passing_local_date="N";
	}
//	String sql			= "" ;
	
	Connection con = null;
	Statement stmt   		= null;
	Statement stmt1   		= null;
	ResultSet rs	   		= null;
	ResultSet rs1	   		= null;
	Statement stmt2   		= null;
	ResultSet rs2	   		= null;
	String sql1="";
	String install_yn="";
	request.setCharacterEncoding("UTF-8");
	
	
	

try{	
	
	//sql	= "select trans_code,trans_desc from oa_trans_type order by 1" ;
	//rs	= stmt.executeQuery( sql ) ;
	con = ConnectionManager.getConnection(request);
	 stmt   		= con.createStatement() ;
	 stmt1   		= con.createStatement() ;
	 stmt2   		= con.createStatement() ;
	rs1 = stmt1.executeQuery("select to_char(sysdate,'dd/mm/yyyy') d from dual")  ;
	rs1.next();
	String currentdate = rs1.getString("d");



		String maintain_doc_or_file="";
		String sql_chk="select maintain_doc_or_file from mp_param";
		rs	= stmt.executeQuery( sql_chk ) ;

		if(rs !=null && rs.next())
		{
		maintain_doc_or_file=rs.getString("maintain_doc_or_file");
		}
		if(maintain_doc_or_file.equals("D"))
		{%>
			<script>
				alert(getMessage('FILE_MAINTENANCE','OA'));
				parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';
				</script>
		<%}
if(rs !=null)rs.close();
		
		String sql5=" select install_yn from sm_module where module_id='FM'";
				rs=stmt.executeQuery(sql5);
				if(rs !=null && rs.next())
				{
					install_yn=rs.getString("install_yn");

				}
				if(install_yn.equals("N"))
				{%>
				<script>
				alert(getMessage('FM_NOT_INSTALLED','OA'));
				parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';
				</script>
			<%}

%>


<center>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name="repMRPullingListForAppt" id="repMRPullingListForAppt" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		
		<table width="80%" border='0' align='center' cellpadding='2' cellspacing='0'>
		
		<tr>
			
			<td class='label' width='30%'>&nbsp;</td>
			<td class='querydata'  width='35%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='querydata'  width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>

			

		</tr>

		<tr>
			
			<td class="label" width='30%'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type="text" id='apptdate' name="p_fm_appt_date1" id="p_fm_appt_date1" size="10" maxlength="10" onBlur="DateCompare_from('from',this);chkFormat(this);" ><img  style="cursor:pointer"  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdate');"></input><img src='../../eCommon/images/mandatory.gif'></img></td><input type='hidden' name='p_fm_appt_date' id='p_fm_appt_date' value=''/>
			<td class='fields'>
				<input type="text" id='apptdatefrom' name="p_to_appt_date1" id="p_to_appt_date1" size="10" maxlength="10" onBlur="DateCompare_from('To',this);DateCompare3(p_fm_appt_date1,this);chkFormat(this);" ><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');"></input><img src='../../eCommon/images/mandatory.gif'></img></td><input type='hidden' name='p_to_appt_date' id='p_to_appt_date' value=''/>

		</tr>
		<tr>
			
			<td  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields' nowrap>
					<% sql1 = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
					 rs2 = stmt2.executeQuery(sql1);
					 %>
					<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> <option value='' style='align:center'>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
						<%
						 String locn_type="";
                                            String short_desc="";
                                            while(rs2.next() && rs2 !=null){
                                                locn_type=rs2.getString("care_locn_type_ind");
                                                short_desc=rs2.getString("short_desc");
                                                out.println("<option value='"+locn_type+"'>"+short_desc);
}
%>

					</SELECT></td>

			<td class='label'>&nbsp;</td>

		</tr>
		<tr>
			
			<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="10" maxlength="4" onblur='if(this.value!="") searchCode1(this, p_fm_locn_code,p_fm_locn)'><input type="hidden" name="p_fm_locn" id="p_fm_locn"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, p_fm_locn_code,p_fm_locn)'></td>
			<td class='fields'>
				<input type="text" name="p_to_locn_code" id="p_to_locn_code" size="10" maxlength="4" onblur='if(this.value!="") searchCode1(this, p_to_locn_code,p_to_locn)'><input type="hidden" name="p_to_locn" id="p_to_locn"><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCode1(this, p_to_locn_code,p_to_locn)'></td>

		</tr>
		<tr>
			
			<td class="label"><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
			<td class='fields' nowrap>
				<SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
                                      <OPTION value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
                                      <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                                      <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                                      <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
									  <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
                                     </SELECT></td>
			<td class='label'>&nbsp;</td>

		</tr>
		<tr>
			
			<td class="label"><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
     		<td class='fields' id='loc' >
				  <SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);//validateTbs();'>
				  <OPTION value='' >&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
										 
										 </SELECT></td>
			<td class='fields' id='loc' >
				  <SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
				  <OPTION value='' >&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
										 
										 </SELECT></td>
					
		</tr>

				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "reports" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>

		<!-- <tr>
			
			<td  class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_pract_id" id="p_fm_pract_id" onblur="onblurcheck(this,p_fm_pract_id)"size="15" disabled maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick='callPractSearch(this, p_fm_pract_id)'></td>
			<td class='fields'>
				<input type="text" name="p_to_pract_id" id="p_to_pract_id" disabled onblur="onblurcheck(this,p_to_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch(this, p_to_pract_id)'>
			</td>

		</tr> -->


		<tr>
			
			<td class="label"><fmt:message key="Common.PickOnlyBookingsDoneAfter.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type = 'text' id="pbkdoneafter" name='p_bk_done_after' id='p_bk_done_after' onBlur='doDateTimeChk(this)'  size='16' maxlength='16'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('pbkdoneafter',null,'hh:mm');"></input></td>

			<td class='label'>&nbsp;</td>
		</tr>

		<tr>
			
			<td class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class='fields'nowrap>
				 <select name='sex' id='sex'>
				  <option value=""> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
				  <option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
				  <option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				  <option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				 </select></td>
			<td class='label'> &nbsp;</td>
			
		</tr>


		<tr>
			<td class='label' colspan=3>&nbsp;</td>
		</tr>

		
		</table>
		

		<table border='0' width='80%' align='center' cellpadding='0' cellspacing='0'>
			<th colspan='3' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></th>
		<tr>
			<td colspan=3>&nbsp;</td>
		</tr>

		<tr>

			<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td class='label'>&nbsp;</td>
			<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td align='center'><select name='orderbycols' id='orderbycols' size='6' >
				<option value='Appt_Date'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></option>
				<option value='Practitioner_id'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value='Pat_Id'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
				<option value='Gender'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></option>
				</select>
			</td>

				<td align='center' width='3%' ><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>

			<td  align='center'>
			<select name='orderbycolumns' id='orderbycolumns' size='6' multiple='true'>
			<option value='Clinic_Code' selected><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></option>
			</select>
			</td>
		</tr>
			<td class='label' colspan=3>&nbsp;</td>
		</table>


		<br>

			<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
			<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
			<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
			<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
			<input type="hidden" name="p_order_by" id="p_order_by"		value="">
			<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
			<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>
			<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'></input>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			 <!-- Monday, March 29, 2010 20345 venkat S -->
			<input type='hidden' name='p_fm_speciality' id='p_fm_speciality' value=''>
		    <input type='hidden' name='p_to_speciality' id='p_to_speciality' value=''>
	</form>
</body>
</center>
<%
if(rs !=null) rs.close();
if(stmt !=null) stmt.close();
if(rs1 !=null) rs1.close();
if(rs2 !=null) rs2.close();
if(stmt1 !=null) stmt1.close();
if(stmt2 !=null) stmt2.close();
}catch(Exception es){
//out.println(es.toString());
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{

ConnectionManager.returnConnection(con,request);
}

%>
</body>
<script>document.forms[0].p_fm_appt_date1.focus();</script>
</html>

