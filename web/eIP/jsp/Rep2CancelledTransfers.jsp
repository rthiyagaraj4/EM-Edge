<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBCNLTR" ;
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
<script src="../../eCommon/js/common.js" language="JavaScript" ></script>
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
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var from_pract_type = Rep2CancelledTransfersForm.fm_pract_type.value;
			var to_pract_type = Rep2CancelledTransfersForm.to_pract_type.value;
			
			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			if(obj.name=="bed_class_code")
			{
				tit=getLabel('Common.BedClass.label','common')
				//sql="select bed_class_code,short_desc from ip_bed_class ";
				sql="select bed_class_code,short_desc from ip_bed_class_lang_vw where language_id=`"+locale+"` ";
				search_code="bed_class_code";
				search_desc= "short_desc";
			}

			if(obj.name=="practitioner_id1")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw "
				//sql += " where operating_facility_id= `<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";

				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";

				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where a.PRACT_TYPE=nvl(`"+from_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id ";
										
				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="practitioner_id2")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw "
				//sql += " where operating_facility_id= `<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";

				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";

				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where a.PRACT_TYPE=nvl(`"+to_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id ";

				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}
			
			if(obj.name=="transfer_type")
			{
				tit=getLabel('eIP.TransferType.label','IP')
				//sql=" select transfer_type_code, short_desc from ip_transfer_type";
				sql=" select transfer_type_code, short_desc from ip_transfer_type_lang_vw where language_id=`"+locale+"` ";
				search_code="transfer_type_code";
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
<br>
<br>
<form name="Rep2CancelledTransfersForm" id="Rep2CancelledTransfersForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;
    StringBuffer sql = new StringBuffer();
    //sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" );
	sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" );
    ResultSet rset = null;
	StringBuffer StrVal = new StringBuffer();
    String isSpltyNurUnitToEnableYNAppl="";
    try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql.toString());

		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
	 }
	 catch(Exception e){out.println(e);}
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
					<td align="center" width="30%">&nbsp;</td>
					<td class="label" width="30%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
			</tr>								

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text id="trn_date_from"  name='p_fm_booking_date_time' id='p_fm_booking_date_time' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>")'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('trn_date_from');"/>
						</td>
						<td width='40%'> 
							<input type=text id="trn_date_to"  name='p_to_booking_date_time' id='p_to_booking_date_time' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>")'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('trn_date_to');"/>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td width='20%'  >
							<input type=text  name='p_fm_transfer_type' id='p_fm_transfer_type' size="2" maxlength="2" align="center"><input type='button' name='transfer_type' id='transfer_type' value='?' class='button' onclick='searchCode(this, p_fm_transfer_type)'> 
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_transfer_type' id='p_to_transfer_type' size="2" maxlength="2" align="center"><input type='button' name='transfer_type' id='transfer_type' value='?' class='button' onclick='searchCode(this, p_to_transfer_type)'> 
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<tr>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="p_fm_req_specialty_code"/>
				<jsp:param name="speciality_to_code_Appl" value="p_to_req_specialty_code"/>
				</jsp:include>
				</tr>
				<td>&nbsp;</td>
				<Td>&nbsp;</td>
				<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_req_nursing_unit_code"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_req_nursing_unit_code"/>
				</jsp:include>
				</tr>
					
			<%}else{%>
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_fm_req_specialty_code' id='p_fm_req_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_req_specialty_code)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_req_specialty_code' id='p_to_req_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_req_specialty_code)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>

						<td width='20%'  >
							<input type=text  name='p_fm_req_nursing_unit_code' id='p_fm_req_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_req_nursing_unit_code)'>
						</td>

						<td width='40%'> 
							<input type=text  name='p_to_req_nursing_unit_code' id='p_to_req_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_req_nursing_unit_code)'>
						</td>
				</tr>
			<%}%>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>	

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_fm_req_bed_class_code' id='p_fm_req_bed_class_code' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_fm_req_bed_class_code)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_req_bed_class_code' id='p_to_req_bed_class_code' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_to_req_bed_class_code)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.CancellationDate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text id="can_date_from" name='p_fm_cancellation_date_time' id='p_fm_cancellation_date_time' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>")'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('can_date_from');"/>
						</td>
						<td width='40%'> 
							<input type=text id="can_date_to" name='p_to_cancellation_date_time' id='p_to_cancellation_date_time' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>")'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('can_date_to');"/>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
                <tr>
                    <td align='left' width='30%' class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/> &nbsp;</td>
                    <td width='30%'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                    <td width='40%'><select name="to_pract_type" id="to_pract_type">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_fm_req_practitioner_id' id='p_fm_req_practitioner_id' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode(this, p_fm_req_practitioner_id)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_req_practitioner_id' id='p_to_req_practitioner_id' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick='searchCode(this, p_to_req_practitioner_id)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
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
	<input type="hidden" name="p_user_name" id="p_user_name"	     	value="<%= p_user_name %>">

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

