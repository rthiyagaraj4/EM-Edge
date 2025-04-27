<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8"); 
	Connection				con		=	null;
	ResultSet				rset	=	null; 
	Statement				stmt	=	null;

	String p_module_id		= "IP" ;
	String p_report_id		= "IPBREFLT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");
%>
<SCRIPT LANGUAGE="JavaScript">

async function searchCode(obj,target,Ar_installed)
{
var retVal = 	new String();
var locale= "<%=locale%>"
var dialogHeight= "28" ;
var dialogWidth	= "43" ;
var status = "no";
var arguments	= "" ;
var sql="";
var search_code="";
var search_desc="";
var tit="";
if(obj.name=="pract")
{
	var tit=getLabel('Common.practitioner.label','common')
	//sql="select practitioner_id, short_name from am_practitioner";
	sql="select practitioner_id, short_name from am_practitioner_lang_vw where language_id=`"+locale+"` ";
	search_code="practitioner_id";
	search_desc= "short_name";
}
else if(obj.name=="location")
{
	tit=getLabel('Common.Location.label','common');
	//sql="select nursing_unit_code, short_desc from ip_nursing_unit";
	sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where language_id=`"+locale+"` ";
	search_code="nursing_unit_code";
	search_desc= "short_desc";
}
else if(obj.name=="specality")
{
	tit=getLabel('Common.speciality.label','common');
	//sql="select speciality_code, short_desc from am_speciality";
	sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
	search_code="speciality_code";
	search_desc= "short_desc";
}
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

if (!(retVal == null))
	target.value=retVal;
else
	target.focus();
}

function setreferral(obj){
	
	
	var p_ref_type=document.forms[0].p_ref_type.value;
	var P_FM_REF_CODE=document.forms[0].P_FM_REF_CODE;
	//while(P_FM_REF_CODE.options.length>1) P_FM_REF_CODE.options.remove(1);
    var P_TO_REF_CODE=document.forms[0].P_TO_REF_CODE;
   // while(P_TO_REF_CODE.options.length>1) P_TO_REF_CODE.options.remove(1);
	document.forms[0].P_FM_REF_CODE.value="";
	document.forms[0].P_TO_REF_CODE.value="";
if(obj.value != '')
					{
					document.forms[0].P_FM_REF_CODE.disabled=false;
					document.forms[0].P_FM_referral_source_lkp_but.disabled=false;

					document.forms[0].P_TO_REF_CODE.disabled=false;
					document.forms[0].P_TO_referral_source_lkp_but.disabled=false;
					}else
					{
						document.forms[0].P_FM_REF_CODE.disabled=true;
						document.forms[0].P_FM_referral_source_lkp_but.disabled=true;

						document.forms[0].P_TO_REF_CODE.disabled=true;
						document.forms[0].P_TO_referral_source_lkp_but.disabled=true;
					}
	/*if(p_ref_type!=''){
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH p_ref_type=\""+p_ref_type+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/internalReportValidation_SRR.jsp",false)
	xmlHttp.send(xmlDoc)
		
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	}*/
}

function chkWithSysDt(obj){
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
function referralSourceLookup(obj, getFacilitID)
{
var facility_id	   = getFacilitID;
	var target		   = document.forms[0].P_FM_REF_CODE;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var ref_type = document.forms[0].p_ref_type.value;
	var locale = document.forms[0].locale.value;
	

	if(ref_type=='L'){
		
		sql="Select facility_id code,facility_name description from sm_facility_param_lang_vw Where language_id='"+locale+"' and STATUS = 'E' and upper(facility_name) like upper(?) and upper(facility_id) like upper(?) and facility_id='"+facility_id+"' order by 1";

	}else if(ref_type=='E'){
		
     sql="Select facility_id code ,facility_name description from sm_facility_param_lang_vw Where language_id='"+locale+"'  and STATUS = 'E' and upper(facility_id) like upper(?) and upper(facility_name) like upper(?) order by 1";
	 
	}else{
		sql="Select referral_Code code,short_desc description from am_referral_lang_vw where language_id='"+locale+"' and eff_status = 'E' and upper(referral_Code) like upper(?) and upper(short_desc) like upper(?) order by 1";
	}
	
	tit=getLabel("Common.referralsource.label","Common");
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		
			document.forms[0].referral_source1.value=arr[1];
			document.forms[0].P_FM_REF_CODE.value=arr[0];
	}
	else
	{
		
			document.forms[0].P_FM_REF_CODE.value = "";
			document.forms[0].referral_source1.value = "";
		
	}
}
function referralSourceLookup1(obj, getFacilitID)
{
var facility_id	   = getFacilitID;
	var target		   = document.forms[0].P_TO_REF_CODE;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var ref_type = document.forms[0].p_ref_type.value;
	var locale = document.forms[0].locale.value;

	if(ref_type=='L'){
		
		sql="Select facility_id code,facility_name description from sm_facility_param_lang_vw Where language_id='"+locale+"' and STATUS = 'E' and upper(facility_name) like upper(?) and upper(facility_id) like upper(?) and facility_id='"+facility_id+"' order by 1";

	}else if(ref_type=='E'){
		
     sql="Select facility_id code ,facility_name description from sm_facility_param_lang_vw Where language_id='"+locale+"'  and STATUS = 'E' and upper(facility_id) like upper(?) and upper(facility_name) like upper(?) order by 1";
	 
	}else{
		sql="Select referral_Code code,short_desc description from am_referral_lang_vw where language_id='"+locale+"' and eff_status = 'E' and upper(referral_Code) like upper(?) and upper(short_desc) like upper(?) order by 1";
	}
	
	tit=getLabel("Common.referralsource.label","Common");
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		
			document.forms[0].referral_source1.value=arr[1];
			document.forms[0].P_TO_REF_CODE.value=arr[0];
	}
	else
	{
		
			document.forms[0].P_TO_REF_CODE.value = "";
			document.forms[0].referral_source1.value = "";
		
	}
	
}
</SCRIPT>


<html>
<center>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="RepIpReferral" id="RepIpReferral" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR>
<table width='90%' align='center' border='0' valign='top'>
<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
		<table width='100%' border='0' cellPadding="0" cellSpacing="0" align='center'  >
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>	
	<tr>
		<td align="right" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
		<td class="fields" colspan ="3"> 
				<select name='p_for_facility_id' id='p_for_facility_id'>
			<%
				try
				{
					con		=	ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				String fid;
				String fname;
				StringBuffer sql1 = new StringBuffer();
				//sql1.append("select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ");					
				
				String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

				sql1.append("select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2");					
				rset=stmt.executeQuery(sql1.toString());
				if(rset!=null)
				{
				   while(rset.next())
				   {
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");
					if(fid.equals("All"))
					out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
					else
					out.println("<option value='"+fid+ "' >"+fname+"</option>");
				   }
				}
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();
				}
				catch(Exception e)
				{
					out.println(e);
				}
				finally 
				{ 
					if(rset!=null)rset.close();
					if(stmt!=null)stmt.close();
					ConnectionManager.returnConnection(con,request);
				}
			%>	
			</select>
		</td>
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<TR><!--Referral type -->
		<TD class='Label' width='25%' ><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='30%'>
		<select name='p_ref_type' id='p_ref_type' onchange='setreferral(this)'>	
		<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
		<option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
		<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
		<option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>		
		</select>
		</TD>
		<TD class='fields' width='30%'></TD>
 </TR>
 <tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
 <tr>
		<td class="label">&nbsp;</td>
		<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class="querydata" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	 <TR><!--Referral source -->
		<TD class='Label' width='25%' ><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='30%'>
		<!--<SELECT name='P_FM_REF_CODE' id='P_FM_REF_CODE'>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		</SELECT>-->
		<input type='text' name='P_FM_REF_CODE' id='P_FM_REF_CODE' size='20' value="" disabled><input type='button' class='button' name='P_FM_referral_source_lkp_but' id='P_FM_referral_source_lkp_but' value='?' " onClick="referralSourceLookup(P_FM_REF_CODE,'<%=p_facility_id%>')" disabled>
		<input type='hidden' name='referral_source1' id='referral_source1'   value="">
		</TD>
		<TD class='fields' width='30%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--<SELECT name='P_TO_REF_CODE' id='P_TO_REF_CODE'>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		</SELECT>-->
		<input type='text' name='P_TO_REF_CODE' id='P_TO_REF_CODE' size='20' value="" disabled><input type='button' class='button' name='P_TO_referral_source_lkp_but' id='P_TO_referral_source_lkp_but' value='?' onClick="referralSourceLookup1(P_TO_REF_CODE,'<%=p_facility_id%>')" disabled>
		<input type='hidden' name='referral_source2' id='referral_source2'   value="">
		</TD>
 </TR>
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>	
	<tr>
		<td  width='40%' class="label" align='right' nowrap><fmt:message key="Common.referral.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class="fields" width='20%' align='left'>
		       <input type=text id="p_date_from" name='p_fm_admn_date' id='p_fm_admn_date' size="10" maxlength="10" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}' ><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from');"/>
		</td>
		<td class="fields" width='40%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text id="p_date_to"  name='p_to_admn_date' id='p_to_admn_date' size="10" maxlength="10" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');"/>
		</td>
	</tr>
<tr>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
</tr>
<tr>
<td width='40%' class="label" align='right' nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class="fields" width='20%' align='left'><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="15" maxlength="15"><input type='button' name='pract' id='pract' value='?' class='button' onclick="searchCode(this, p_fm_pract_id,'N')"></td>
<td  width='40%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="p_to_pract_id" id="p_to_pract_id" size="15" maxlength="15"><input type='button' name='pract' id='pract' value='?' class='button' onclick="searchCode(this, p_to_pract_id,'N')">
</td>
</tr>
<tr>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
</tr>
<tr>
<td width='40%' class="label" align='right' nowrap><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class="fields" width='20%' align='left'><input type="text" name="p_fm_location" id="p_fm_location" size="4" maxlength="4"><input type='button' name='location' id='location' value='?' class='button' onclick="searchCode(this, p_fm_location,'N')"></td>
<td  width='40%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="p_to_location" id="p_to_location" size="4" maxlength="4"><input type='button' name='location' id='location' value='?' class='button' onclick="searchCode(this, p_to_location,'N')"></td>
</tr>
<tr>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
</tr>
<tr>
<td width='40%' class="label" align='right' nowrap><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class="fields" width='20%' align='left'><input type="text" name="p_fm_specialty" id="p_fm_specialty" size="4" maxlength="4"><input type='button' name='specality' id='specality' value='?' class='button' onclick="searchCode(this, p_fm_specialty,'N')"></td>
<td class="fields" width='40%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<input type="text" name="p_to_specialty" id="p_to_specialty" size="4" maxlength="4"><input type='button' name='specality' id='specality' value='?' class='button' onclick="searchCode(this, p_to_specialty,'N')"></td>
</tr>
<tr>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
</tr>
<tr>
<td width='40%' class="label" align='right' nowrap><fmt:message key="Common.BedSideReferral.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class="fields" width='20%' align='left'>
<SELECT name="p_bed_ref" id="p_bed_ref">
<option value="N"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
<option	value="Y"><fmt:message key="eIP.Bedside.label" bundle="${ip_labels}"/></option>
</SELECT>
</td>
<td class="label">&nbsp;</td>
</tr>
<tr>
	<td class="label">&nbsp;</td>
	<td class="label">&nbsp;</td>
	<td class="label">&nbsp;</td>
</tr>
<tr>
<td width='40%' class="label" align='right' nowrap><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class="fields" width='20%' align='left'>
<SELECT name="P_ORDER_BY" id="P_ORDER_BY">
<option value="1"><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/></option>
<option	value="2"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
</SELECT>
</td>
<td class="label">&nbsp;</td>
</tr>
</table>
</td>
</tr>


</table>
	<br>
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
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
		<input type="hidden" name="locale" id="locale"			value="<%= locale %>">
</form>
</body>
</center>
</html>

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

