<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String function_id= checkForNull(request.getParameter("function_id"));
	String defaultSelect = "";
	/*Added by Rameswar on 07/04/2016 for  MMS-QH-CRF-0090.1*/
	if(function_id.equals("REP_ADMISSION_LIST")){
	p_report_id		= "IPBADMLT" ;
	}else if (function_id.equals("REP_ADM_LIST_GRP_BY_NU")){
			p_report_id		= "IPBADMLTGN" ;
			defaultSelect = "selected";
	}
/*Added by Rameswar on 07/04/2016 for MMS-QH-CRF-0090.1*/
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"  language='javascript' ></script>
<script src="../../eCommon/js/common.js"  language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>

// added by mujafar for GDOH-CRF-0139

async function searchCode1(obj,target)
	{
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

// END
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
			var from_pract_type = Rep2AdmissionForm.fm_pract_type.value;
			var to_pract_type = Rep2AdmissionForm.to_pract_type.value;
			
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



function setValue()
{
				
if ( Rep2AdmissionForm.sum_id.checked == true)
     {
	    Rep2AdmissionForm.p_sum_yn.value="Y";
			 
	  }
              
	  if ( Rep2AdmissionForm.detail_id.checked == true)
        {
	     Rep2AdmissionForm.p_sum_yn.value="N";
		}
             
}


 function validate_date(obj) {
	
		if(obj.value!=''){
			
			if(!validDateObjforAdm(obj.value,'DMYHM',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			obj.select();
		}else{
			if(isBeforeNow(obj.value,"DMYHM",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
				}
			}
		}
  }

function validDateObjforAdm(Object3){
	
	var checkFlag= true ;
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    
    var dateArray1=Object3.split(" ");
	var	dateArray=(dateArray1[0]).split("/");
	var time1arr=dateArray1[1].split(":")
	if(time1arr.length==2)
				{
					var time1hr=time1arr[0]
					var time1min=time1arr[1]

					if(time1hr < 0 && time1hr >24 && time1min < 00 && time1min > 59)
						{
						 checkFlag=false;
					}

					if (time1hr.length != 2 || time1min.length != 2)
					{
						 checkFlag=false;
					}
				}
    var strDateArray = new Array();

   
    if (dateArray.length == 0) checkFlag= true;


    strDateArray = dateArray;
    if (strDateArray.length != 3) {
        checkFlag= false;
    }
    else {
        strDay = trimString(strDateArray[0]);
        strMonth = trimString(strDateArray[1]);
        strYear = trimString(strDateArray[2]);
    }


    if (strYear.length < 4 || strYear.length > 4) checkFlag= false;
    if (strMonth.length != 2) checkFlag= false;
    if (strDay.length != 2) checkFlag= false;

    if (isNaN(strDay)==true) checkFlag= false;
    if (isNaN(strMonth)==true) checkFlag = false;
    if (isNaN(strYear)==true) checkFlag= false;

    if (strYear < 1800) checkFlag = false;

        if (strMonth>12 || strMonth<1)  checkFlag = false;

    if ((strMonth == 01 || strMonth == 03 || strMonth == 05 || strMonth == 07 || strMonth == 08 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) checkFlag = false;

    if ((strMonth == 04 || strMonth == 06 || strMonth == 09 || strMonth == 11) && (strDay > 30 || strDay < 01)) checkFlag = false;

    if (strMonth == 02) {
        if (strDay < 01) checkFlag = false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) checkFlag = false;
        }
        else {
            if (strDay > 28) checkFlag = false;
        }
    }
    return checkFlag;
}
</script>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown ="lockKey();">
<br>
<br>
<form name="Rep2AdmissionForm" id="Rep2AdmissionForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;
    StringBuffer sql = new StringBuffer();
    //sql.append("Select PRACT_TYPE, DESC_USERDEF, sysdate From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" );
	sql.append("Select PRACT_TYPE, DESC_USERDEF, sysdate From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" );
    ResultSet rset = null;
	StringBuffer StrVal = new StringBuffer();

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
	java.sql.Timestamp dt	= new Timestamp(System.currentTimeMillis()) ;

	String Sdate = dateFormat.format(dt) ;
	Boolean isBillingGroupApplicable = false; //added by mujafar for GDOH-CRF-0139
	String isSpltyNurUnitToEnableYNAppl="";//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
    try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql.toString());
		isBillingGroupApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"IP","BILLING_GROUP_APPLICABLE"); //added by mujafar for GDOH-CRF-0139

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
					<td class="label" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="30%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				</tr>								

				<tr>
 				<td align='left' width='30%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'  >
							<input type=text id="adm_date_from"  name='p_fm_admission_date' id='p_fm_admission_date' size="16" maxlength="16" align="center" onblur="if(validDateObj(this,'DMYHM',localeName))validate_date(this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="Rep2AdmissionForm.p_fm_admission_date.focus();return showCalendar('adm_date_from',null,'hh:mm');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width='30%'> 
							<input type=text id="adm_date_to"  name='p_to_admission_date' id='p_to_admission_date' size="16" maxlength="16" align="center" onblur="if(validDateObj(this,'DMYHM',localeName))validate_date(this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="Rep2AdmissionForm.p_to_admission_date.focus();return showCalendar('adm_date_to',null,'hh:mm');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'  >
							<input type=text  name='p_fm_adm_type' id='p_fm_adm_type' size="2" maxlength="2" align="center" ><input type='button' name='admission_type' id='admission_type' value='?' class='button' onclick='searchCode(this, p_fm_adm_type)'>
						</td>
						<td width='30%'> 
							<input type=text  name='p_to_adm_type' id='p_to_adm_type' size="2" maxlength="2" align="center"><input type='button' name='admission_type' id='admission_type' value='?' class='button' onclick='searchCode(this, p_to_adm_type)'>
						</td>
				</tr>
 
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
 
				<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
				</jsp:include>
				<%}else{%>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td width='30%'> 
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
						<td width='40%'  >
							<input type=text  name='p_fm_bed_class' id='p_fm_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_fm_bed_class)'>
						</td>
						<td width='30%'> 
							<input type=text  name='p_to_bed_class' id='p_to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_to_bed_class)'>
						</td>
				</tr>
 
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
                <tr>
                    <td align='left' width='30%' class="label" nowrap><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                    <td width='40%'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                    <td width='30%'><select name="to_pract_type" id="to_pract_type">
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
						<td width='40%'  >
							<input type=text  name='p_fm_practitioner' id='p_fm_practitioner' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode(this, p_fm_practitioner)'>
						</td>
						<td width='30%'> 
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
						<td width='40%'  >
							<input type=text  name='p_fm_speciality' id='p_fm_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_speciality)'>
						</td>
						<td width='30%'> 
							<input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_speciality)'>
						</td>
				<%}%>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
				<%if(isBillingGroupApplicable)
				{ //added by mujafar for GDOH-CRF-0139 %>
				
					<tr>
						<td  align='left' width='30%' class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='40%' >
							<input type=text  name='p_fm_bill_group_code' id='p_fm_bill_group_code'  size="4" maxlength="4"  align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode1(this, p_fm_bill_group_code)'>
						</td>
						<td width='30%' >
							<input type=text  name='p_to_bill_group_code' id='p_to_bill_group_code' size="4" maxlength="4" align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode1(this,  p_to_bill_group_code)'>
						</td>
					</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
				<%}%>
				<tr>
					<td align='lift' width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='40%' align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>
						<option value='3'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
						<option value='4'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
						<option value='5'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
						<option value='6' <%=defaultSelect%> ><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/>
						<%
						if(isBillingGroupApplicable)
						{ //added by mujafar for GDOH-CRF-0139
						%>
						<option value='7'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>
						<%}%>
						
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.groupby.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='40%' align="left">
						<select name='p_group_by' id='p_group_by'>						
						<option value='1'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="eMP.RaceGroup.label" bundle="${mp_labels}"/>
						<%
						if(isBillingGroupApplicable)
						{ //added by mujafar for GDOH-CRF-0139
						%>
						<option value='3'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>
						<%}%>
						
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
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
	<input type='hidden' name ='currdate' value="<%=Sdate%>">
	<input type='hidden' name ='function_id' value="<%=function_id%>"> 
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

