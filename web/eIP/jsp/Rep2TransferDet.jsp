<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!--<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>-->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBTRNLT";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";
	Connection con = ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	Statement stmt=null;
	ResultSet rs =null;
	String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
	String CurrentDate="";
	try{
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);

		
	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
/*function setValue(Obj)
{
if ( Rep2TransferForm.p_sum.checked == true)
 {
	Rep2TransferForm.p_sum_yn.value="Y";
		
			
 }
  else
     {
			//Rep2AdmissionForm.p_sum_yn.cheked=false;
	 Rep2TransferForm.p_sum_yn.value="N";
			
		}
				}*/

function validDate(obj) {
	var sysDt=document.forms[0].CurrentDate;
	var msg;
	if(obj.name=='p_fr_trans_date'){
		if(obj.value=='')
		document.forms[0].p_to_trans_date.value='';
	}
	if(CheckDate(obj)){
		if(obj.name=='p_to_trans_date'){
			sysDt=document.forms[0].p_fr_trans_date;
			if(document.forms[0].p_fr_trans_date.value !='' && document.forms[0].p_to_trans_date.value !=''){
				
				fromarray  = obj.value.split("/");
		toarray    = sysDt.value.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) > Date.parse(fromdt)) {
					msg=getMessage("TO_DT_GR_EQ_FM_DT",'SM');
					alert(msg);
					obj.value='';
					obj.focus();
					return;
					}
			}
			sysDt=document.forms[0].CurrentDate;
		fromarray  = obj.value.split("/");
		toarray    = sysDt.value.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {
				//	msg=getMessage("START_DATE_GREATER_SYSDATE");
				//	alert(msg);
				//	obj.value='';
				//	obj.focus();
				//	return;
					msg=getMessage("DATE1_GT_DATE2",'IP');
					//var transfer_date_from=getLabel("Common.transferdate.label","Common");
					var sys_date=getLabel("Common.CurrentDate.label","Common");

					var transfer_date_to1=getLabel("Common.Transfer.label","Common");
					var transfer_date_to=transfer_date_to1+" "+getLabel("Common.todate.label","Common");
					msg=msg.replace('$',transfer_date_to);
					msg=msg.replace('#',sys_date);
					alert(msg);
					obj.value='';
					obj.focus();
					return;

					}
		}else{
			if(document.forms[0].p_fr_trans_date.value !=''){
			fromarray  = obj.value.split("/");
		toarray    = sysDt.value.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {
					//msg=getMessage("START_DATE_GREATER_SYSDATE");
					//alert(msg);
					//obj.value='';
					//obj.focus();
					//return;
					msg=getMessage("DATE1_GT_DATE2",'IP');
					var transfer_date_from1=getLabel("Common.Transfer.label","Common");
					var transfer_date_from=transfer_date_from1+" "+getLabel("Common.fromdate.label","Common");
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					msg=msg.replace('$',transfer_date_from);
					msg=msg.replace('#',sys_date);
					alert(msg);
					obj.value='';
					obj.focus();
					return;
					}
			}

			if(document.forms[0].p_to_trans_date.value !=''){
				if(!doDateCheckAlert(obj,document.forms[0].p_to_trans_date)){
					msg=getMessage("TO_DT_GR_EQ_FM_DT",'SM');
					alert(msg);
					document.forms[0].p_to_trans_date.focus();
				}
			}

		}
	
	}else{
	}
}

function setValue()
{
				
if ( Rep2TransferForm.sum_id.checked == true)
     {
	    Rep2TransferForm.p_sum_yn.value="Y";
			 
	  }
              
	  if ( Rep2TransferForm.detail_id.checked == true)
        {
	     Rep2TransferForm.p_sum_yn.value="N";
		}
             
}



async 	function searchCode(obj,target){
			
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
			
			if(obj.name=="bed_class_code")
			{
				tit=getLabel('Common.BedClass.label','common')
				//sql="select bed_class_code,short_desc from ip_bed_class ";
				sql="select bed_class_code,short_desc from ip_bed_class_lang_vw where language_id=`"+locale+"` ";
				search_code="bed_class_code";
				search_desc= "short_desc";
			}
			else if(obj.name=="nursing")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code,short_desc from ip_nursing_unit ";
				sql="select nursing_unit_code,short_desc from ip_nursing_unit_lang_vw where language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			else if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code,short_desc from am_speciality ";
				sql="select speciality_code,short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
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
/*function transfer()			  
{
	if (document.forms[0].transfer_type.value=="In")
		document.forms[0].p_report_id.value="IPBTRNIN";
	else if	(document.forms[0].transfer_type.value=="Out")
		document.forms[0].p_report_id.value="IPBTRNOT";
}*/
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2TransferForm" id="Rep2TransferForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
<tr>
	<td width="100%" class="Border" align='center'>
	<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
	<tr>
		<td align="center" width="35%">&nbsp;</td>
		<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td align='left' width='30%' class="label"><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/> &nbsp;</td>
		<td width='20%'  >
			<input type=text id="trn_date_from"  name='p_fr_trans_date' id='p_fr_trans_date' size="10" maxlength="10" align="center" onblur='validDate(this)'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('trn_date_from');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td width='40%'> 
<!--		<input type=text id="trn_date_to"  name='p_to_trans_date' id='p_to_trans_date' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>")'>-->
			<input type=text id="trn_date_to"  name='p_to_trans_date' id='p_to_trans_date' size="10" maxlength="10" align="center" onblur='validDate(this,"DMY","<%=localeName%>")'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('trn_date_to');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	</tr>
	<!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->				
	<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
			<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
				</jsp:include>
			
			</tr>
				
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
			<tr>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="p_fm_speciality_code"/>
				<jsp:param name="speciality_to_code_Appl" value="p_to_speciality_code"/>
				</jsp:include>
				
			</tr>
			
<%}else{%>
	<tr>
		<td align='left' width='30%' class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> &nbsp;</td>
		<td width='40%'>
			<input type=text   name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="6" maxlength="6" align="center"><input type='button' name='nursing' id='nursing' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
		</td>
		<td width='40%'> 
			<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="6" maxlength="6" align="center"><input type='button' name='nursing' id='nursing' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	</tr>	
	<tr>
		<td align='left' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> &nbsp;</td>
		<td width='40%'>
			<input type=text  name='p_fm_speciality_code' id='p_fm_speciality_code' size="6" maxlength="6" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this,p_fm_speciality_code)'>
		</td>
		<td width='40%'> 
			<input type=text  name='p_to_speciality_code' id='p_to_speciality_code' size="6" maxlength="6" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_speciality_code)'>
		</td>
	</tr>
<%}%>
	<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	</tr>
	<tr>
		<td align='left' width='30%' class="label"><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/> &nbsp;</td>
		<td width='40%'>
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
		<td align='left' width='30%' class="label"><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/> &nbsp;</td>
		<td width='40%'>
			<SELECT name="transfer_type" id="transfer_type">
			<option value="5"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="1"><fmt:message key="eIP.Interward.label" bundle="${ip_labels}"/></option>
			<option value="2"><fmt:message key="eIP.Intraward.label" bundle="${ip_labels}"/> </option>
			<option value="3"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
			<option value="4"><fmt:message key="Common.Swap.label" bundle="${common_labels}"/> </option>
			</SELECT>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	</tr>
	</table>
	<table width='80%' align='center' valign='top'>
	<tr>
				<tr>
				<td align='left' width='36%' class="label">
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
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"			value="<%=CurrentDate %>">

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

