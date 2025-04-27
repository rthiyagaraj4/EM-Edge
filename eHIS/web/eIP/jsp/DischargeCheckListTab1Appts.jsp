<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
 %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
Connection con	= null;
ResultSet rset  = null; 
Statement stmt	= null;

String  patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String  facilityId			= (String)session.getValue("facility_id");
StringBuffer sqlSB			= new StringBuffer();
String  cname				= "";
String	care_locn_type_ind	= ""; 
String	appt_ref_no			= ""; 
String	referral_id			= ""; 
String	referral_date		= "";
String	to_pract_id			= "";
String	to_speciality_desc	= "";
String	Practitioner		= "";
String	to_ref_locn_desc	= "";
String	to_locn_type		= "";
String  to_nurs_unit_code	= "";
String  to_clinic_code		= "";
String  referred_to			= "";
String  Location_Code		= "";
String  Location_Desc		= "";
String  to_nurs_unit_desc	= "";
String  to_clinic_desc		= "";
String  to_ref_type			= "";
String  to_facility_name	= "";
String  from_time			= "";
String  to_time				= "";
String  appt_date			= "";
String  resource_class		= "";
String  apptNO				= "";
int		maxRecord			= 0;
%>

<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eIP/js/DischargeCheckList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

async function showRefDtls(ref_id)
{
	var retVal = 	new String();
	var dialogHeight= "90vh" ;
	var dialogTop = "" ;
	var dialogWidth	= "85vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;
	
	var retVal = await top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref_id,arguments,features);
}

async function view_appt_details(ref_no, pract_id, clinic_code, from_time, to_time, appt_date, res_class, care_locn_ind )
{
	if(ref_no != '')
	{
		var retVal		=    new String();
		var dialogHeight= "70vh";	
		var dialogWidth = "80vw";
		var dialogTop	= "";
		var center		= "1";
		var status		= "no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments   = "" ;
		retVal = await top.window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?calling_mode=IP&i_appt_ref_no="+ref_no,arguments,features);
	}
}

function setValue(obj)
{
	if(obj.checked)
		obj.value='Y';
	else
		obj.value = '';
}

function Valid_DT(event)
{
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return false;  
} 

function chk_with_sysdate(obj)
{
	if(obj.value!='')
	{
		var to = parent.parent.DischargeCheckList_frame1.document.forms[0].system_date_time;
		if(isAfter(obj.value,to.value,"DMYHM",localeName))
		{
			var str = getMessage("CANNOT_GREATER","MP");
			str = str.replace('#', getLabel("Common.date.label","Common"));
			str = str.replace('$', getLabel("Common.SystemDate.label","Common"));
			alert(str);
			obj.value="";
			//obj.select();
			//obj.focus();			
		}
	}
}   

</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DischargeCheckListTab5' id='DischargeCheckListTab5'>
	<table border="1" cellpadding="0" cellspacing="0" width="100%" align='center'>
		<tr>
			<td class='COLUMNHEADER' colspan='7'><fmt:message key="eIP.FollowupAppointments.label" bundle="${ip_labels}"/></td>
		</tr>
		<tr></tr>
<%	try
	{
		con	= ConnectionManager.getConnection(request);
		
		/*sqlSB.append(" SELECT count(*) FROM pr_referral_register a, OA_APPT b WHERE a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and BEDSIDE_REFERRAL_YN !='Y' order by a.REFERRAL_ID, a.REFERRAL_DATE desc");
		stmt	= con.createStatement();
		rset	= stmt.executeQuery(sqlSB.toString());

		

		
		int record_count = 0;
		if(rset!=null)
		{
			while(rset.next())
				record_count = rset.getInt(1);
		}
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		*/
		//if(record_count>0)
		//{

			if (sqlSB.length() > 0)
				sqlSB.delete(0, sqlSB.length());

			sqlSB.append("SELECT b.CARE_LOCN_TYPE_IND care_locn_type_ind, b.APPT_REF_NO appt_ref_no, sm_get_desc.sm_facility_param(a.to_facility_id, '"+locale+"', 1) to_facility_name, to_char(b.appt_slab_from_time,'hh24:mi') from_time, to_char(b.appt_slab_to_time,'hh24:mi') to_time, to_char(b.appt_date,'dd/mm/rrrr') appt_date, b.resource_class resource_class,  a.to_ref_type to_ref_type, to_char(sysdate,'dd/mm/rrrr hh24:mi') sydate, a.REFERRAL_ID REFERRAL_ID, TO_CHAR (a.referral_date, 'dd/mm/rrrr') REFERRAL_DATE,  a.TO_REF_CODE TO_REF_CODE,  (CASE WHEN a.TO_REF_CODE IS NOT NULL THEN (AM_GET_DESC.AM_REFERRAL(a.TO_REF_CODE,'"+locale+"',1)) END ) TO_REF_DESC ,  a.PATIENT_ID PATIENT_ID, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME , a.TO_PRACT_ID TO_PRACT_ID,  a.TO_PRACT_NAME TO_REF_PRACT_NAME, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  (CASE WHEN a.TO_SPECIALITY_CODE IS NOT NULL THEN (AM_GET_DESC.AM_SPECIALITY(a.TO_SPECIALITY_CODE,'"+locale+"',2)) END ) TO_SPECIALITY_DESC , a.TO_locn_DESC TO_REF_LOCN_DESC, a.TO_LOCN_TYPE TO_LOCN_TYPE, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  a.to_locn_code TO_CLINIC_CODE, a.to_locn_code TO_NURS_UNIT_CODE, (CASE WHEN a.TO_locn_CODE IS NOT NULL and a.to_locn_type != 'N' THEN (OP_GET_DESC.OP_CLINIC('"+facilityId+"', a.TO_locn_CODE,'"+locale+"',1)) END ) TO_CLINIC_DESC ,  (CASE WHEN a.to_locn_code IS NOT NULL and a.to_locn_type = 'N' THEN (IP_GET_DESC.IP_NURSING_UNIT('"+facilityId+"',a.to_locn_code,'"+locale+"',2)) END ) TO_NURS_UNIT_DESC  FROM pr_referral_register a, OA_APPT b  WHERE  a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and a.BEDSIDE_REFERRAL_YN !='Y'  order by a.REFERRAL_ID, a.REFERRAL_DATE desc");

			stmt= con.createStatement();
			rset	= stmt.executeQuery(sqlSB.toString());

			cname= "QRYEVEN" ;

			while(rset.next())
			{
				if(maxRecord==0)
				{
      %>				
					<tr>
					<th width='16%' align='center' nowrap ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></th>
					<th width='12%' align='center' nowrap ><fmt:message key="Common.PreferredOn.label" bundle="${common_labels}"/></th>
					<th width='15%' align='center' nowrap ><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></th>
					<th width='15%' align='center' nowrap ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
					<th width='15%' align='center' nowrap ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
					<th width='15%' align='center' nowrap ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
					<th width='10%' align='center' nowrap ><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></th>
					</tr>
<%		
				}
		//if (sqlSB.length() > 0)
			//sqlSB.delete(0, sqlSB.length());
        

		//sqlSB.append("SELECT b.CARE_LOCN_TYPE_IND care_locn_type_ind, b.APPT_REF_NO appt_ref_no, sm_get_desc.sm_facility_param(a.to_facility_id, '"+locale+"', 1) to_facility_name, to_char(b.appt_slab_from_time,'hh24:mi') from_time, to_char(b.appt_slab_to_time,'hh24:mi') to_time, to_char(b.appt_date,'dd/mm/rrrr') appt_date, b.resource_class resource_class,  a.to_ref_type to_ref_type, to_char(sysdate,'dd/mm/rrrr hh24:mi') sydate, a.REFERRAL_ID REFERRAL_ID, TO_CHAR (a.referral_date, 'dd/mm/rrrr') REFERRAL_DATE,  a.TO_REF_CODE TO_REF_CODE,  (CASE WHEN a.TO_REF_CODE IS NOT NULL THEN (AM_GET_DESC.AM_REFERRAL(a.TO_REF_CODE,'"+locale+"',1)) END ) TO_REF_DESC ,  a.PATIENT_ID PATIENT_ID, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME PATIENT_NAME, a.TO_PRACT_ID TO_PRACT_ID,  a.TO_PRACT_NAME TO_REF_PRACT_NAME, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  (CASE WHEN a.TO_SPECIALITY_CODE IS NOT NULL THEN (AM_GET_DESC.AM_SPECIALITY(a.TO_SPECIALITY_CODE,'"+locale+"',2)) END ) TO_SPECIALITY_DESC , a.TO_locn_DESC TO_REF_LOCN_DESC, a.TO_LOCN_TYPE TO_LOCN_TYPE, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  a.to_locn_code TO_CLINIC_CODE, a.to_locn_code TO_NURS_UNIT_CODE, (CASE WHEN a.TO_locn_CODE IS NOT NULL and a.to_locn_type != 'N' THEN (OP_GET_DESC.OP_CLINIC('"+facilityId+"', a.TO_locn_CODE,'"+locale+"',1)) END ) TO_CLINIC_DESC ,  (CASE WHEN a.to_locn_code IS NOT NULL and a.to_locn_type = 'N' THEN (IP_GET_DESC.IP_NURSING_UNIT('"+facilityId+"',a.to_locn_code,'"+locale+"',2)) END ) TO_NURS_UNIT_DESC  FROM pr_referral_register a, OA_APPT b  WHERE  a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and a.BEDSIDE_REFERRAL_YN !='Y'  order by a.REFERRAL_ID, a.REFERRAL_DATE desc");

		/*sqlSB.append("SELECT b.CARE_LOCN_TYPE_IND care_locn_type_ind, b.APPT_REF_NO appt_ref_no, sm_get_desc.sm_facility_param(a.to_facility_id, '"+locale+"', 1) to_facility_name, to_char(b.appt_slab_from_time,'hh24:mi') from_time, to_char(b.appt_slab_to_time,'hh24:mi') to_time, to_char(b.appt_date,'dd/mm/rrrr') appt_date, b.resource_class resource_class,  a.to_ref_type to_ref_type, to_char(sysdate,'dd/mm/rrrr hh24:mi') sydate, a.REFERRAL_ID REFERRAL_ID, TO_CHAR (a.referral_date, 'dd/mm/rrrr') REFERRAL_DATE,  a.TO_REF_CODE TO_REF_CODE,  (CASE WHEN a.TO_REF_CODE IS NOT NULL THEN (AM_GET_DESC.AM_REFERRAL(a.TO_REF_CODE,'"+locale+"',1)) END ) TO_REF_DESC ,  a.PATIENT_ID PATIENT_ID, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME , a.TO_PRACT_ID TO_PRACT_ID,  a.TO_PRACT_NAME TO_REF_PRACT_NAME, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  (CASE WHEN a.TO_SPECIALITY_CODE IS NOT NULL THEN (AM_GET_DESC.AM_SPECIALITY(a.TO_SPECIALITY_CODE,'"+locale+"',2)) END ) TO_SPECIALITY_DESC , a.TO_locn_DESC TO_REF_LOCN_DESC, a.TO_LOCN_TYPE TO_LOCN_TYPE, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  a.to_locn_code TO_CLINIC_CODE, a.to_locn_code TO_NURS_UNIT_CODE, (CASE WHEN a.TO_locn_CODE IS NOT NULL and a.to_locn_type != 'N' THEN (OP_GET_DESC.OP_CLINIC('"+facilityId+"', a.TO_locn_CODE,'"+locale+"',1)) END ) TO_CLINIC_DESC ,  (CASE WHEN a.to_locn_code IS NOT NULL and a.to_locn_type = 'N' THEN (IP_GET_DESC.IP_NURSING_UNIT('"+facilityId+"',a.to_locn_code,'"+locale+"',2)) END ) TO_NURS_UNIT_DESC  FROM pr_referral_register a, OA_APPT b  WHERE  a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and a.BEDSIDE_REFERRAL_YN !='Y'  order by a.REFERRAL_ID, a.REFERRAL_DATE desc");

		stmt= con.createStatement();
		rset	= stmt.executeQuery(sqlSB.toString());*/
		
		//if(rset != null)
		//{
				//cname= "QRYEVEN" ;
			//while(rset.next())
			//{
				if(cname.equals("QRYEVEN"))
					cname = "QRYODD" ;
				else
					cname = "QRYEVEN" ;
				
				care_locn_type_ind	= checkForNull(rset.getString("care_locn_type_ind"));
				appt_ref_no			= checkForNull(rset.getString("APPT_REF_NO"));

				if(appt_ref_no==null ||appt_ref_no.equals("")) appt_ref_no="&nbsp;";

				apptNO = rset.getString("APPT_REF_NO");	if(apptNO == null) apptNO = "";

				from_time			= checkForNull(rset.getString("FROM_TIME"));
				to_time				= checkForNull(rset.getString("TO_TIME"));
				appt_date			= checkForNull(rset.getString("APPT_DATE"));
				resource_class		= checkForNull(rset.getString("RESOURCE_CLASS"));
				referral_id			= checkForNull(rset.getString("REFERRAL_ID"));
				referral_date		= checkForNull(rset.getString("REFERRAL_DATE"));

				if(!(referral_date==null || referral_date.equals("")))
					referral_date = DateUtils.convertDate(referral_date,"DMY","en",locale);

				referred_to			= checkForNull(rset.getString("TO_REF_DESC"));
				if(referred_to.equals("")) 
				{
					to_facility_name	= checkForNull(rset.getString("TO_FACILITY_NAME"));
						if(to_facility_name.equals("")) to_facility_name = "&nbsp;";
							referred_to	= to_facility_name;
				}

				to_speciality_desc	= rset.getString("TO_SPECIALITY_DESC");
				if(to_speciality_desc == null) to_speciality_desc = "&nbsp;";
				to_pract_id			= checkForNull(rset.getString("TO_PRACT_ID"));
			
				Practitioner		= rset.getString("TO_REF_PRACT_NAME");
					if(Practitioner == null)	Practitioner = "&nbsp;";
				
				to_locn_type		= checkForNull(rset.getString("TO_LOCN_TYPE"));
				
				to_ref_type			= checkForNull(rset.getString("TO_REF_TYPE"));
					if(!to_ref_type.equals("L")) to_ref_type = "&nbsp;";

				if(to_locn_type.equals("N") || to_locn_type.equals("D") )
				{
					to_nurs_unit_code	= checkForNull(rset.getString("TO_NURS_UNIT_CODE"));
					to_nurs_unit_desc	= checkForNull(rset.getString("TO_NURS_UNIT_DESC"));
					Location_Code		= to_nurs_unit_code;
					Location_Desc		= to_nurs_unit_desc;
				}
				else if(to_locn_type.equals("C") || to_locn_type.equals("E"))
				{
					to_clinic_code		= checkForNull(rset.getString("TO_CLINIC_CODE"));
					to_clinic_desc		= checkForNull(rset.getString("TO_CLINIC_DESC"));
					
					Location_Code		= to_clinic_code;
					Location_Desc		= to_clinic_desc;
				}
				else
				{
					to_ref_locn_desc	= checkForNull(rset.getString("TO_REF_LOCN_DESC"));
					Location_Desc		= to_ref_locn_desc;
				}

				if(Location_Desc == null || Location_Desc.equals("")) 
					Location_Desc = "&nbsp;";
			%>
			<tr>
				<td width='16%' class="<%=cname%>" ><a href ="javascript:showRefDtls('<%=referral_id%>')"><%=referral_id%></a></td>
				<td class='<%=cname%>' width='12%'><%=referral_date%></td>
				<td class='<%=cname%>' width='15%' ><%=referred_to%></td>
				<td class='<%=cname%>' width='15%' ><%=to_speciality_desc%></td>
				<td class='<%=cname%>' width='15%' ><%=Location_Desc%></td>
				<td class='<%=cname%>' width='15%' ><%=Practitioner%></td>
				<td class='<%=cname%>' width='10%' ><a href="javascript:view_appt_details('<%=apptNO%>','<%=to_pract_id%>','<%=Location_Code%>','<%=from_time%>','<%=to_time%>','<%=appt_date%>','<%=resource_class%>','<%=care_locn_type_ind%>')" ><%=appt_ref_no%></a></td>
			</tr>
				
	<%		
				maxRecord++;
			}
		
		//}
	//}

		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();

	}catch(Exception e) 
	{ 
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
</table>
<form>
</body>
</html>
 
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

