<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "OA" ;
	String p_report_id		= "OARTMTAB" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eOA/js/repOACodeCheck.js" language="javascript"></script>
 <script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>


<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onLoad="Focusing('p_fm_clinic_code')">
<br>
<br>
<form name="repTimeTableList" id="repTimeTableList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
request.setCharacterEncoding("UTF-8");
    Connection con  =  null;
    Statement stmt = null; 
	ResultSet rset=null;
    String sql = "" ;
	  Statement stmt2 = null; 
    String sql1 = "" ;
	ResultSet rs2=null;
   
	StringBuffer Strday =new StringBuffer("");
	String p_passing_local_date="";
	String locale = (String)session.getAttribute("LOCALE");
	if(locale.equals("th"))
	{
		p_passing_local_date="Y";
	}else 
	{
		p_passing_local_date="N";
	}

    try
    {
		con  =  ConnectionManager.getConnection(request);
     stmt = con.createStatement(); 
	   stmt2 = con.createStatement(); 
		

	  sql = "select day_no,day_of_week from sm_day_of_week order by 1";	 
	  rset = stmt.executeQuery(sql);

		String day_no 	= "" ;
		String day_desc	= "" ;

	  while(rset!=null&&rset.next())
		{

		  day_no	= rset.getString("day_no") ;
		  day_desc= rset.getString("day_of_week") ;

		  if(day_desc.equals("MONDAY"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_desc.equals("TUESDAY"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_desc.equals("WEDNESDAY"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_desc.equals("THURSDAY"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_desc.equals("FRIDAY"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_desc.equals("SATURDAY"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_desc.equals("SUNDAY"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

		 Strday.append("<option value='"+day_no+"'>"+day_desc+"</option>");
		}
	
 
	 

%>

<table width='80%' align='center' valign='top' >
	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' border='0'>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%'  >
					<% 
					sql1 = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
				  rs2 = stmt2.executeQuery(sql1);
				  %>
					<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> 						<option value='' style='align:center'>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
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
					<td width='20%'> </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_clinic_code' id='p_fm_clinic_code' size="4" onblur='if(this.value !="") searchCode1(this, p_fm_clinic_code,p_fm_clinic)' maxlength="4" align="center"><input type="hidden" name="p_fm_clinic" id="p_fm_clinic"><input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode1(this, p_fm_clinic_code,p_fm_clinic)'></td>
					<td width='20%'> <input type=text  name='p_to_clinic_code' id='p_to_clinic_code' size="4" onblur='if(this.value !="") searchCode1(this, p_to_clinic_code,p_to_clinic)' maxlength="4" align="center"><input type="hidden" name="p_to_clinic" id="p_to_clinic"><input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode1(this, p_to_clinic_code,p_to_clinic)'></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				 <tr>
                    <td align='right' width='30%' class="label"><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/>&nbsp;</td>
                    <td width='30%'><SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
                                      <OPTION value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
                                      <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                                      <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                                      <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
									  <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
                                     </SELECT>
					</td>
                    <td width='40%'>
					</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

                <tr>
				
			<td align="right" class="label">
				<fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/>&nbsp;
			</td>
                  	 <TD align='left' id='loc' nowrap>
          <SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);//validateTbs();'>
          <OPTION value='' >&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
                                 
                                 </SELECT> </td>
									 <TD align='left' id='loc' > 
          <SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
          <OPTION value='' >&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
                                 
                                 </SELECT><!-- </td><td>&nbsp;</td> -->
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "reports1" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>


				<!-- <tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_pract_id' id='p_fm_pract_id' disabled onblur ="onblurcheck(this,p_fm_pract_id)" size="15" maxlength="15" align="center"><input type='button' name='practioner1' id='practioner1' value='?' disabled class='button' onclick='callPractSearch(this, p_fm_pract_id)'></td>
					<td width='20%'> <input type=text  name='p_to_pract_id' id='p_to_pract_id' onblur="onblurcheck(this,p_to_pract_id)" disabled size="15" maxlength="15" align="center"><input type='button' name='practioner2' id='practioner2' value='?' disabled class='button' onclick='callPractSearch(this, p_to_pract_id)'></td>
				</tr> -->
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.day.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_day_code' id='p_day_code'>
						<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
						<%=Strday%>
						</select>
					</td>
				</tr>
				<tr>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="eOA.TimeTableType.label" bundle="${oa_labels}"/>&nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_tmtable_type' id='p_tmtable_type'>
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
						<option value="1"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/>
						<option value="2"><fmt:message key="eOA.slab.label" bundle="${oa_labels}"/>	
						<option value="3"><fmt:message key="Common.FreeFormat.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="eOA.RosterRequired.label" bundle="${oa_labels}"/>&nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_roster_req' id='p_roster_req'>
						<option value=""><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>				

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- Friday, March 26, 2010 20345 venkat s -->
<input type="hidden" name="p_to_speciality" id="p_to_speciality"		value="">
<input type="hidden" name="p_fm_speciality" id="p_fm_speciality"		value="">
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
</form>
</BODY>
</HTML>
<%
		if(rset != null)    rset.close();
		if(rs2 != null)    rs2.close();
		if(stmt != null)    stmt.close();
		if(stmt2 != null)    stmt2.close();
	}
	 catch(Exception e){//out.println(e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	 finally
	 {
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }%>

