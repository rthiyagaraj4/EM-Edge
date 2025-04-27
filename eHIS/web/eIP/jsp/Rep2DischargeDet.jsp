<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDISLT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";
	%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js" language='javascript'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

async function searchCode2(obj,target)
	{ // added by mujafar for GDOH-CRF-0139
		var retVal = 	new String();
		var tit="";
		var locale= "<%=locale%>";
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();


		if(obj.name=="billing_group"){
			tit=getLabel('Common.BillingGroup.label','common');
			argumentArray[0]="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where  language_id='"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?)";
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
		}

		retVal = await CommonLookup( tit, argumentArray ) ;

		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[0];
		}
		else
		{
			target.value='';
		}
	}

 function validate_date(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }

function setValue()
{
				
if ( Rep2DischargeForm.sum_id.checked == true)
     {
	    Rep2DischargeForm.p_sum_yn.value="Y";
			 
	  }
              
	  if ( Rep2DischargeForm.detail_id.checked == true)
        {
	     Rep2DischargeForm.p_sum_yn.value="N";
		}
             
}

function searchCode1(obj,target)
{
    if(target.value=="")
	{
		target.value="";
		return ;
	}
	else
	{
			searchCode(obj,target);
	}
}

async function searchCode(obj,target)
	{		
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			/* var dialogHeight= "28" ;
			var dialogWidth	= "43" ; */
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var from_pract_type = Rep2DischargeForm.fm_pract_type.value;
			var to_pract_type = Rep2DischargeForm.to_pract_type.value;
		
			if(obj.name=="practitioner_id1")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where operating_facility_id= `<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";
				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";
				
				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where a.PRACT_TYPE=nvl(`"+from_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id ";

				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="practitioner_id2")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where operating_facility_id= `<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";
				
				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";
				
				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where a.PRACT_TYPE=nvl(`"+to_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id ";

				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`  ";
				search_code="speciality_code";
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
			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			if(obj.name=="discharge_type")
			{
				tit=getLabel('Common.dischargetype.label','common');
				//sql=" select discharge_type_code , short_desc from ip_discharge_type ";
				sql=" select discharge_type_code , short_desc from ip_discharge_type_lang_vw where language_id=`"+locale+"` ";
				search_code="discharge_type_code";
				search_desc= "short_desc";
			}
/*modified on 2/07/2008 for SCR 3228 */
			if(obj.name=="discharge_status")
			{
				tit=getLabel('eIP.DischargeStatus.label','IP');
				sql=" select discharge_status_code , short_desc from ip_discharge_status where eff_status=`E` ";
				search_code="discharge_status_code";
				search_desc= "short_desc";
			}
/*  */
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
<form name="Rep2DischargeForm" id="Rep2DischargeForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	Connection con  =  null;
	Statement stmt = null;
	StringBuffer sql1 = new StringBuffer();

	//sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" );
	sql1.append("Select PRACT_TYPE, DESC_USERDEF,to_char(sysdate,'dd/mm/yyyy')CurrentDate From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E'  and language_id='"+locale+"' order by 2" );
	ResultSet rset = null;
	String CurrentDate = "";
	
	StringBuffer StrVal = new StringBuffer();
	Boolean isBillingGroupApplicable = false; //added by mujafar for GDOH-CRF-0139
    try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql1.toString());
		isBillingGroupApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"IP","BILLING_GROUP_APPLICABLE"); //added by mujafar for GDOH-CRF-0139

		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
				CurrentDate=rset.getString("CurrentDate");

				
			}
		}
	 }
	 catch(Exception e){/* out.println(e); */e.printStackTrace();}
	 finally
	 {
		 try
		 {
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();
		 }
		 catch(Exception e)
		 {/* out.println("Exception in tryCatch : "+ e.toString()); */e.printStackTrace();}
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
						<td align='left' width='30%' class="label"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text id="dis_date_from"  name='p_fm_discharge_date' id='p_fm_discharge_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_from');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width='40%'> 
							<input type=text id="dis_date_to"  name='p_to_discharge_date' id='p_to_discharge_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this);"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_to');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
 
				<tr>
					<td>&nbsp;</td>
					
				</tr>

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td width='30%'  >
							<input type=text  name='p_fm_dis_type' id='p_fm_dis_type' size="2" maxlength="2" align="center" ><input type='button' name='discharge_type' id='discharge_type' value='?' class='button' onclick='searchCode(this, p_fm_dis_type)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_dis_type' id='p_to_dis_type' size="2" maxlength="2" align="center"><input type='button' name='discharge_type' id='discharge_type' value='?' class='button' onclick='searchCode(this, p_to_dis_type)'>
						</td>
				</tr>
 
				<tr>
					<td>&nbsp;</td>
					
				</tr>

<!-- modified on 2/07/2008 for SCR 3228 -->
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td width='30%'  >
							<input type=text  name='p_fm_dis_status' id='p_fm_dis_status' size="2" maxlength="2" align="center"><input type='button' name='discharge_status' id='discharge_status' value='?' class='button' onclick='searchCode(this, p_fm_dis_status)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_dis_status' id='p_to_dis_status' size="2" maxlength="2" align="center"><input type='button' name='discharge_status' id='discharge_status' value='?' class='button'  onclick='searchCode(this, p_to_dis_status)'>
						</td>
				</tr>
 
				<tr>
					<td>&nbsp;</td>
					
				</tr>
<!-- -->

				<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
				</jsp:include>
				<%}else{%>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				<%}%>		
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>	


				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_bed_class' id='p_fm_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_fm_bed_class)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_bed_class' id='p_to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_to_bed_class)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
                <tr>
                    <td align='left' width='30%' class="label" nowrap><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
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
						<td width='30%'  >
							<input type=text  name='p_fm_practitioner' id='p_fm_practitioner' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode(this, p_fm_practitioner)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_practitioner' id='p_to_practitioner' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick='searchCode(this, p_to_practitioner)'>
						</td>
				</tr>
			

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>	
	
				<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="p_fm_speciality"/>
				<jsp:param name="speciality_to_code_Appl" value="p_to_speciality"/>
				</jsp:include>
				<%}else{%>
						<td align='left' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_speciality' id='p_fm_speciality' size="4" maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_speciality)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_speciality)'>
						</td>
				<%}%>		
				</tr>
				
				<!--Below Line Added for this CRF [041660]  -->
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<%if(isBillingGroupApplicable)
				{ //added by mujafar for GDOH-CRF-0139 %>
				
					<tr>
						<td  align='left' width='30%' class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='40%' >
							<input type=text  name='p_fm_bill_group_code' id='p_fm_bill_group_code'  size="4" maxlength="4"  align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode2(this, p_fm_bill_group_code)'>
						</td>
						<td width='30%' >
							<input type=text  name='p_to_bill_group_code' id='p_to_bill_group_code' size="4" maxlength="4" align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode2(this,  p_to_bill_group_code)'>
						</td>
					</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
				<%}%>
					<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >							
						<select name='P_patient_class' id='P_patient_class'>
						<option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						<option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
						<option value='ALL'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>						
						</select>					
						</td>
						<td width='40%'> &nbsp;	</td>
				</tr>				
				<!-- End this CRF incident[041660]  --->
			
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='30%' align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
						<option value='3'><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/>
						<option value='4'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
						<%
						if(isBillingGroupApplicable)
						{ //added by mujafar for GDOH-CRF-0139
						%>
						<option value='5'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>
						<%}%>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
			
				<%if(isBillingGroupApplicable)
				{//added by mujafar for GDOH-CRF-0139 %>
				
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.groupby.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='40%' align="left">
						<select name='p_group_by' id='p_group_by'>						
						<option value='1'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<%}%>
			
				</table>
	<table width='80%' align='center' valign='top'>

				<tr>
				<td align='left' width='30%' class="label">
						<fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
						<td width='3%'><input type='radio' id='sum_id' name='p_sum_yn' id='p_sum_yn' value = 'Y' checked onClick="setValue();"></td>
						<td align='right' width='5%' class="label">
						<fmt:message key="Common.Detail.label" bundle="${common_labels}"/></td>
						<td><input type='radio' id='detail_id' name='p_sum_yn' id='p_sum_yn' value = 'N'  onClick="setValue();"></td>
               
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
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">
	<input type='hidden' name ='isBillingGroupApplicable' value="<%=isBillingGroupApplicable%>"> <!-- added by mujafar for GDOH-CRF-0139 -->

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

