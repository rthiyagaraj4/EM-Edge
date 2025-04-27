<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBBKLST" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			/* var dialogHeight= "28" ;
			var dialogWidth	= "43" ; */
			var dialogTop = "10px" ;
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var from_pract_type = Rep2DlyBkgListForm.fm_pract_type.value;
			var to_pract_type = Rep2DlyBkgListForm.to_pract_type.value;
			
			if(obj.name=="practitioner_id1")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where operating_facility_id= `<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";

				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";

				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where a.PRACT_TYPE=nvl(`"+from_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id ";

				//search_code="practitioner_id";		
				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
				
			}

			if(obj.name=="practitioner_id2")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where operating_facility_id= `<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";
				
				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";

				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where a.PRACT_TYPE=nvl(`"+to_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id ";

				//search_code="practitioner_id";
				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			if(obj.name=="bed_class_code")
			{
				tit=getLabel('Common.BedClass.label','common')
				//sql="select bed_class_code,short_desc from ip_bed_class ";
				sql="select bed_class_code,short_desc from ip_bed_class_lang_vw where language_id=`"+locale+"`";
				search_code="bed_class_code";
				search_desc= "short_desc";
			}


			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"`";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			if(obj.name=="admission_type")
			{
				tit=getLabel('Common.admissiontype.label','common');
				//sql=" select admission_type_code, short_desc from ip_admission_type ";
				sql=" select admission_type_code, short_desc from ip_admission_type_lang_vw where language_id=`"+locale+"` ";
				search_code="admission_type_code";
				search_desc= "short_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	function dateVal( obj )
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert( parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM") )
			}
		}
	}
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="Rep2DlyBkgListForm" id="Rep2DlyBkgListForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;
    String isSpltyNurUnitToEnableYNAppl ="";
	StringBuffer sql = new StringBuffer();
    //sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" );
	sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E'  and language_id='"+locale+"' order by 2" );
    ResultSet rset = null;
	StringBuffer StrVal = new StringBuffer();

    try
    {
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement(); 
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
		rset = stmt.executeQuery(sql.toString());

		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
			}
		}
	 }
	 catch(Exception e){out.println(e);e.printStackTrace();}
	 finally
	 {
		 try
		 {
		if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
		 }
		 catch(Exception e)
		 {out.println("Exception in tryCatch : "+ e.toString());}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td class='label' align="center" width="30%">&nbsp;</td>
					<td class="querydata" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				</tr>								

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.PreferredAdmissionDate.label" bundle="${ip_labels}"/>&nbsp;</td>
						<td class='fields' width='30%'  >
							<input type=text id="adm_date_from"  name='p_fm_admission_date' id='p_fm_admission_date' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>")'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_from');"/>
						</td>
						<td class='fields' width='40%'> 
							<input type=text id="adm_date_to"  name='p_to_admission_date' id='p_to_admission_date' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>")'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_to');"/>
						</td>
				</tr>
				
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
				</jsp:include></tr>
				
				<%}else{%>
				<tr>

						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='30%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				</tr>
				<%}%>
				<tr>
					<td class='label'> &nbsp;</td>
					<Td>&nbsp;</td>
				</tr>	

                <tr>
                    <td align='left' width='30%' class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                    <td class='fields' width='30%'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                    <td class='fields' width='40%'><select name="to_pract_type" id="to_pract_type">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                </tr>
                <tr>
                    <td class='label'>&nbsp;</td>
                    <td class='label'>&nbsp;</td>
                </tr>

				<tr>
						<td  align='left' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='30%'  >
							<input type=text  name='p_fm_practitioner' id='p_fm_practitioner' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode(this, p_fm_practitioner)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_practitioner' id='p_to_practitioner' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick='searchCode(this, p_to_practitioner)'>
						</td>
				</tr>
			

				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>	

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/> &nbsp;</td>
						<td  class='fields' width='30%'  >
							<input type=text  name='p_fm_bed_class' id='p_fm_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_fm_bed_class)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_bed_class' id='p_to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_to_bed_class)'>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<tr>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="p_fm_specialty_code"/>
				<jsp:param name="speciality_to_code_Appl" value="p_to_specialty_code"/>
				</jsp:include></tr>
				
				<%}else{%>
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='30%'  >
							<input type=text  name='p_fm_specialty_code' id='p_fm_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_specialty_code' id='p_to_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
						</td>
				</tr>
				<%}%>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.priority.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  class='fields' width='30%' align="left">
						<select name='p_priority' id='p_priority'>							
							<option value=''>&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;
							<option value='N'><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/>
							<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>

				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>

				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.BookingStatus.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td class='fields' width='30%' align="left">
						<select name='p_rep_type' id='p_rep_type'>	
							<!--Added by Ashwini on 13-Feb-2017 for ML-MMOH-CRF-0947-->
							<option value='0'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
							<!--End ML-MMOH-CRF-0947-->
							<option value='1'><fmt:message key="Common.Admitted.label" bundle="${common_labels}"/>
							<option value='2'><fmt:message key="Common.NoShows.label" bundle="${common_labels}"/>
							<option value='3'><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/>
							<option value='4'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>							
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
					</td>
				</tr>

				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.groupby.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td class='fields' width='30%' align="left">
						<select name='p_order_by' id='p_order_by'>							
							<option value='1'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
							<option value='2'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>							
							<option value='3'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
					</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  class='fields' width='30%' align="left">
						<select name='p_order' id='p_order'>				

							<option value='1'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>

						</select>
					</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>

		</table>
	</td>
</tr>
</table>

	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	    value="<%= p_user_name %>">
	

</form>
</BODY>
</HTML>
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

