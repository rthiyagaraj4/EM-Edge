<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBCIPLT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function setValue()
			{
				
				if ( Rep2CurrentIPListForm.sum_id.checked == true)
                {
	          Rep2CurrentIPListForm.p_sum_yn.value="Y";
			 
	           }
              
		     if ( Rep2CurrentIPListForm.detail_id.checked == true)
                {
	          Rep2CurrentIPListForm.p_sum_yn.value="N";
			 }
             
			}
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
			var from_pract_type = Rep2CurrentIPListForm.fm_pract_type.value;
			var to_pract_type = Rep2CurrentIPListForm.to_pract_type.value;

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

			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			if(obj.name=="nationality")
			{
				tit=getLabel('Common.nationality.label','common');
				//sql="select COUNTRY_CODE, LONG_DESC from MP_COUNTRY ";
				sql="select COUNTRY_CODE, LONG_DESC from MP_COUNTRY_lang_vw where language_id=`"+locale+"`  ";
				search_code="COUNTRY_CODE";
				search_desc= "LONG_DESC";
			}

			if(obj.name=="bed_class_code")
			{
				tit=getLabel('Common.BedClass.label','common')
				//sql="select bed_class_code,short_desc from ip_bed_class ";
				sql="select bed_class_code,short_desc from ip_bed_class_lang_vw where language_id=`"+locale+"`  ";
				search_code="bed_class_code";
				search_desc= "short_desc";
			}

			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>`and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			if(obj.name=="pat_series")
			{
				tit=getLabel('eMP.PatientSeries.label','MP');
				//sql="select pat_ser_grp_code, short_desc from mp_pat_ser_grp ";				
				sql="select pat_ser_grp_code, short_desc from mp_pat_ser_grp_lang_vw where language_id=`"+locale+"` ";
				search_code="pat_ser_grp_code";
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
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2CurrentIPListForm" id="Rep2CurrentIPListForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;
    StringBuffer sql = new StringBuffer();
    //sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" );
	sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" );
    ResultSet rset = null;
	ResultSet rset1=null;
	StringBuffer StrVal = new StringBuffer();
	StringBuffer StrVal1 = new StringBuffer();
	boolean isresidencySpe=false;//Added by N Munisekhar against AMS-CRF-0059 [IN:045468] 
	boolean isChngSearchCrtAppl=false;
	String sql1 ="";
	String isSpltyNurUnitToEnableYNAppl="";//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	
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
				StrVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
			}
		}
		isresidencySpe=eCommon.Common.CommonBean.isSiteSpecific(con,"IP","IP_RESIDENCY_LIST");//Added by N Munisekhar against AMS-CRF-0059 [IN:045468] 
		isChngSearchCrtAppl=eCommon.Common.CommonBean.isSiteSpecific(con,"IP","CHNG_SEARCH_CRT");//Added by Shanmukh on 9th-JULy-2018 for ML-MMOH-CRF-1116
		sql1="select pat_ser_grp_code, short_desc from mp_pat_ser_grp_lang_vw where language_id='"+locale+"'";
		rset1 = stmt.executeQuery(sql1.toString());
		if(rset1 != null)
		{
			while(rset1.next())
			{
				StrVal1.append(" <option value='"+rset1.getString(1)+"'>"+rset1.getString(1)+"</option> ");
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
		if(rset1 != null)    rset1.close();
		}
		catch(Exception e)
		 {out.println("Exception in tryCatch : "+ e.toString());}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>
<table width='80%' align='center' valign='top'>
	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td class='label' align="center" width="20%">&nbsp;</td>
					<td class="querydata" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<%if(isChngSearchCrtAppl){%>
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
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
                    <td align='left' width='20%' class="label" nowrap><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                    <td class='fields' width='40%'><select name="fm_pract_type" id="fm_pract_type">
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
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_bed_class' id='p_fm_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_fm_bed_class)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_bed_class' id='p_to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_to_bed_class)'>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.NationalityCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_nationality' id='p_fm_nationality' size="4" maxlength="4" align="center"><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_fm_nationality)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_nationality' id='p_to_nationality' size="4" maxlength="4" align="center"><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_to_nationality)'>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td class='fields' width='40%'><select name="p_fm_pat_series" id="p_fm_pat_series">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal1.toString()%>
						</select>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
				</jsp:include></tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="p_fm_speciality"/>
				</jsp:include></tr>
				<%}else{%>
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_speciality' id='p_fm_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_speciality)'>
						</td>
				</tr>
				<%}%>
				<%}else{%>
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_pat_series' id='p_fm_pat_series' size="2" maxlength="2" align="center"><input type='button' name='pat_series' id='pat_series' value='?' class='button' onclick='searchCode(this, p_fm_pat_series)'>
						</td>
						<td  class='fields' width='40%'> 
							<input type=text  name='p_to_pat_series' id='p_to_pat_series' size="2" maxlength="2" align="center"><input type='button' name='pat_series' id='pat_series' value='?' class='button' onclick='searchCode(this, p_to_pat_series)'>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>	

				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td  class='fields' width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				</tr>

				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>	

				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_bed_class' id='p_fm_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_fm_bed_class)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_bed_class' id='p_to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_to_bed_class)'>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>

                <tr>
                    <td align='left' width='20%' class="label" nowrap><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                    <td class='fields' width='40%'><select name="fm_pract_type" id="fm_pract_type">
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
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
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
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_speciality' id='p_fm_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_speciality)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_speciality)'>
						</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>	
				<!--Added by N Munisekhar against AMS-CRF-0059 [IN:045468] -->
				<%if(isresidencySpe){ %>
				<tr>
					<td align='right' width='20%' class="label">
					<fmt:message key="Common.residency.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  class='fields' width='40%' align="left">
						<select name='p_residency' id='p_residency'>
						<option value='B' selected ><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value='Y'><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
						<option value='N'><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td class='label'>&nbsp;</td>
						
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
                <%}%>
				<!-- end  of  AMS-CRF-0059 [IN:045468] -->
				<tr>
						<td align='left' width='20%' class="label" nowrap><fmt:message key="Common.NationalityCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='40%'  >
							<input type=text  name='p_fm_nationality' id='p_fm_nationality' size="4" maxlength="4" align="center"><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_fm_nationality)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_nationality' id='p_to_nationality' size="4" maxlength="4" align="center"><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_to_nationality)'>
						</td>
				</tr>
				<%}%>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>	

				<tr>
					<td align='left' width='20%' class="label">
						<fmt:message key="Common.gender.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  class='fields' width='40%' align="left">
						<select name='p_gender' id='p_gender'>
						<option value=''>&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr> 
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="eIP.PrintTransferDetails.label" bundle="${ip_labels}"/>     &nbsp;
					</td>
					<td class='fields'  width='40%' align="left">
						<select name='p_trn_details' id='p_trn_details'>
						<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/>
						<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr> 
				</table>
				<table width='80%' align='center' valign='top'>
				<tr>
				<td align='left' width='32%' class="label">
						<fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
						<td width='3%'><input type='radio' id='sum_id' name='p_sum_yn' id='p_sum_yn' value = 'Y' onClick="setValue();"></td>
						<td align='right' width='3%' class="label">
						<fmt:message key="Common.Detail.label" bundle="${common_labels}"/></td>
						<td><input type='radio' id='detail_id' name='p_sum_yn' id='p_sum_yn' value = 'N' checked onClick="setValue();"></td>
               
				</tr>
		</table>
	</td>
</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="isChngSearchCrtAppl" id="isChngSearchCrtAppl"	value="<%= isChngSearchCrtAppl %>">
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

