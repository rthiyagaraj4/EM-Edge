<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");%>
<% 
String facilityID		= (String)session.getValue("facility_id");
String locale 			= (String)session.getAttribute("LOCALE");
Connection con  =  null;
String isSpltyNurUnitToEnableYNAppl="";
try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	}catch(Exception e){/* out.println(e); */e.printStackTrace();}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }




%>
<html>
<head>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<Script src="../../eIP/js/IPLookup.js" language="JavaScript"></Script>
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<Script src="../../eIP/js/IPPractitionerComponent.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	

<script>
function clearAll()
{	
	parent.frames[2].location.href ='../../eCommon/html/blank.html';
	if(parent.messageFrame)
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
function submitPage()
{
	var condition="";
	for(var i=0; i<document.forms[0].elements.length; i++)
	{
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
	}
	            var from_date= document.forms[0].from_date.value;
				var to_date= document.forms[0].to_date.value;
				if(from_date=="" || to_date=="")
				{
				var err=getMessage("CAN_NOT_BE_BLANK",'common')
				var err1=getLabel("Common.DischargeAdvice.label","Common")+" "+getLabel("eCA.Prepared.label","eCA")+" "+getLabel("Common.fromTo.label","Common");
				err=err.replace('$',err1);
				alert(err);
				document.forms[0].search.disabled=false;
				}				
				else
				{  
					parent.frames[2].location.href= '../../eIP/jsp/ViewPrepareDischargeAdviseListQueryResult.jsp?<%=request.getQueryString()%>&'+condition;
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				}		
}		
		
async function searchCode(obj,target)
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
		
			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`  ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			
			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= facilityID%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
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
function callPatientSearch()
{   
	var v_patient_id	=	PatientSearch();
	
	if(v_patient_id)
	{ 
		document.forms[0].v_patient_id.value =v_patient_id;
		
	}
}


function checkDate(Obj)
{ if(Obj.value!=''){
	if(!validDateObj(Obj,"DMY",localeName)) {
		    Obj.value = "";
			Obj.select();
			return false;			
		 } else if(isBeforeNow(Obj.value,"DMY",localeName) == false) {
			var err1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");			
			alert(err1);
			Obj.value = "";
			Obj.focus();
		 }		
		 }
}
function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{   
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
		CheckNum(obj);
}
</script>
<body onSelect="codeArrestThruSelect();" onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="FocusFirstElement();">
<form name='Inpatientlookup_Form1' id='Inpatientlookup_Form1' action='../../eIP/jsp/ViewPrepareDischargeAdviseListQueryResult.jsp' target='result' >

<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>

        <tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
		<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="v_nursing_unit_code"/>
				</jsp:include>
				<%}else{%>
			<td  align='left' width='25%' class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='25%'><input type='text' id='nursing_unit_code'   name='v_nursing_unit_code' id='v_nursing_unit_code' size='15' maxlength='15' align='left'><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button'  onclick='searchCode(this, v_nursing_unit_code)'></td>
				<%}%>
    
	
	         <td align='left' class='label' width='25%' nowrap><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="ePH.PreparedDate.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
								
		     <td   class='fields' width='25%'  nowrap><input type='text' id="dis_date_from" size='10' maxlength='10' name='from_date' id='from_date'  value="" onBlur='checkDate(this);compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].from_date.focus();return showCalendar('from_date');"><img src='../../eCommon/images/mandatory.gif' align='center'></img> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="dis_date_to" value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='checkDate(this);compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].to_date.focus();return showCalendar('to_date',null);"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				 <td width = "45%" align='left' >&nbsp;</td>
	
	    </tr>
		<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
		<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="v_spacialty_code"/>
				</jsp:include>
				<%}else{%>
		  <td  align='left' class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		  <td  class='fields' width='25%'><input type='text'  id='spacialty_code' name='v_spacialty_code' id='v_spacialty_code' size='15' maxlength='15' align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, v_spacialty_code)'></td>
				<%}%>
		  <td align='left' class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

		 <td class='fields' width='25%' nowrap><input type='text' id='v_practid_desc' name='practid_desc' id='practid_desc' size="15" maxlength="30"  value=""><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(this,practid_desc);"></td>
	</tr>
	<tr>
		<td align='left' class='label'  width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	    <td class='fields' width='25%'><input type='text'  id='patient_id' name='v_patient_id' id='v_patient_id' value='' size='15' maxlength='15'><input type='button' class='button' value='?' name='srch' id='srch' onClick="callPatientSearch()"></td> 
   
		<td align='left' width='25%' class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> &nbsp;</td>
		<td  class='fields' width='25%'><input type='text' id='encounter_id' name='v_encounter_id' id='v_encounter_id' size="15" maxlength="15" align="center" onKeyPress='return CheckForSpecChars(event)' onBlur="validSplchars1(this);CheckNumVal(this)"></td>
	
    </tr>
</table>
<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr>
			<td width = "75%" class='white' >&nbsp;</td>
			<td width = "25%" class='white' align="right"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'>
			</td>
		</tr>
		
</table>
<input type='hidden' id='nursing_unit_code' value="" >		
<input type='hidden' id='spacialty_code' value="">		
<input type='hidden' id='v_practid_desc' value="" >		
<input type='hidden' id='patient_id' value="" >		
<input type='hidden' id='encounter_id' value="" >		
<input type='hidden' id='dis_date_from' value="" >		
<input type='hidden' id='dis_date_to' value="" >	
</form>
</body>		
<script>
function getPractitionerLocal(obj, target)
{   
	var facility_id		= "<%=facilityID%>";
	getPractitioner(obj, target, facility_id, "","","Q3");
}
function PractLookupRetVal(retVal,objName)
{  
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid_desc.value=arr[0];	
	}
	
}
</script>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

