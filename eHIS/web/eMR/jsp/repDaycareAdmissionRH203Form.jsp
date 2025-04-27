<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%

	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
	String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");

try 
{
    con=ConnectionManager.getConnection(request);
%>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eMR/js/repDaycareAdmissionRH203.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<SCRIPT>

async function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var facilityid = "<%=facility_id%>";
	var facilityID= document.repDaycareAdmissionRH203Form.facilityid.value;
	var tit="";
	if(obj.name=="nurse")
	{	
		tit=getLabel("Common.nursingUnit.label","Common");
		sql="select nursing_unit_code,short_Desc from ip_nursing_unit where APPL_PATIENT_CLASS='DC' and facility_id = '"+facilityID+"' ";
		search_code=" nursing_unit_code";
		search_desc= "short_desc";
	}	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+escape(sql)+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
}
function mychange()
 {
	 if (document.getElementById("report_type").value=='M')
	 {
		document.getElementById("MYfrom").innerHTML = "<input type='text' name='p_from_date' id='p_from_date'  maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_from_date.select();return showCalendar('p_from_date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		document.getElementById("MYto").innerHTML = "<input type='text' name='p_to_date' id='p_to_date'  maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_date.select();return showCalendar('p_to_date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		document.getElementById("MY").innerHTML ="<fmt:message key='Common.month.label' bundle='${common_labels}'/>";
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		 document.getElementById("MYfrom").innerHTML = "<input type='text' name='p_from_date' id='p_from_date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_from_date.select();return showCalendar('p_from_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>";
		 document.getElementById("MYto").innerHTML = "<input type='text' name='p_to_date' id='p_to_date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_date.select();return showCalendar('p_to_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 document.getElementById("MY").innerHTML ="<fmt:message key='Common.year.label' bundle='${common_labels}'/>";
	 }
 }

/*Added by Ashwini on 18-Oct-2019 for ML-MMOH-CRF-1354*/
function callReportid(obj)
{
	if(obj.value=="D")
	{
		document.forms[0].p_report_id.value="MRBRH203";

	}
	else if(obj.value=="S")
	{
		document.forms[0].p_report_id.value="MRBRHS203";
	}
}

</SCRIPT>
</head>
<body  OnMouseDown="CodeArrest()" onLoad="mychange()"  onKeyDown = 'lockKey()'>
<form name="repDaycareAdmissionRH203Form" id="repDaycareAdmissionRH203Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="3" cellspacing="0"  align='center'>
<tr>
<th class="COLUMNHEADER" colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
</tr>
<tr>
	<td class='label' colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class="label" width="30%" align="right"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields' width='30%'><select name='facilityid' id='facilityid'>
		<%
			Statement stmt	= null;
			ResultSet rset	= null;
			try
			{
			String fid;
			String fname;
			String sql1 = "select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ user_id+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+resp_id+"') order by 2";					
			stmt=con.createStatement();
			rset=stmt.executeQuery(sql1);
			if(rset!=null)
			{
				while(rset.next())
				{
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");

					if(fid.equals("DF"))
						out.println("<option value='"+fid+"' selected>"+fname+"</option>");
					else
						out.println("<option value='"+fid+"'>"+fname+"</option>");
				}
			}

			}catch(Exception e){/* out.println(e); */  e.printStackTrace();}
			finally
			{
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				ConnectionManager.returnConnection(con,request);
			}
			%>
		</select>
	</td>
	<td class='label' width='40%'>&nbsp;</td>
</tr>
<tr>
	<td align='right' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
	<td width='25%'>
		 <SELECT name="report_type" id="report_type" onchange='mychange()'>
		 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
		 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
		 </SELECT>
	</td>
	 <td colspan ='3'> 
</tr>

<tr>
	<td class='label'>&nbsp;</td>
	<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td align='right' id='MY' class="label"><fmt:message key="Common.month.label" bundle="${common_labels}"/></td>
	<td id='MYfrom' class='querydata'> &nbsp; </td>
	<td  id='MYto' class='querydata'> &nbsp; </td>
</tr>
<tr>
	<td class="label" align="right"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_care_code" id="p_fm_care_code" size="4" maxlength="4" ><input type='button' name='nurse' id='nurse' value='?' class='button' onclick='searchCode(this, p_fm_care_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_care_code" id="p_to_care_code" size="4" maxlength="4"><input type='button' name='nurse' id='nurse' value='?' class='button' onclick='searchCode(this, p_to_care_code)'>
	</td>
</tr>
<!--Added by Ashwini on 18-Oct-2019 for ML-MMOH-CRF-1354-->
<tr>
	<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
	<td width='25%'>
	<SELECT name="p_type" id="p_type" onchange='callReportid(this)'>
	<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
	<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
	</SELECT>
	</td>
	<td>&nbsp;</td>
</tr>
<tr><td class='label' colspan='3'>&nbsp;</td></tr>
</table>
<input type="hidden" name="p_module_id" id="p_module_id" 	value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="MRBRH203">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */ e.printStackTrace(); }
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>


