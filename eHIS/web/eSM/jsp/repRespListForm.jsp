<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
<script>
	async function searchCode(obj,target){
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="select RESP_ID,RESP_NAME from sm_resp ";
			var search_code="RESP_ID";
			var search_desc="RESP_NAME";
			var tit=encodeURIComponent(getLabel('Common.responsibility.label','Common'));

			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
function CheckString1(str,fromobj,toobj,messageFrame) 
{
	if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
		if(fromobj.value <= toobj.value) 
		{
			return true;
		}
		else 
		{
		
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + getMessage('TO_RESP_GE_FROM_RESP','SM') ;		
			return false;
		}
	}	
	else {
		return true;		
	}	

}

</script>
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "SM" ;
	String p_report_id		= "SMBRESP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<body OnMouseDown='CodeArrest()' ; onKeyDown = 'lockKey()'; onload='FocusFirstElement()';  >
<center>
	<form name="repRespList" id="repRespList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		
		<table border='0' align='center' cellpadding='0' cellspacing='0' width='80%'>
		<tr>
			<td width='20%'>&nbsp;</td>
			<td colspan='4'>&nbsp;</td>
			<td width='20%'>&nbsp;</td>
		</tr>	
			<TR>
				<td width='40%' class="label" ><fmt:message key="eSM.ResponsibilityIDFrom.label" bundle="${sm_labels}"/></td>
				<td width='20%' class='fields'><input type="text" name="p_from_resp_id" id="p_from_resp_id" size="20" maxlength="20" OnBlur='ChangeUpperCase(this)'><input type='button' align='left' name='from_resp_id' id='from_resp_id' value='?' class='button' onclick='searchCode(this,p_from_resp_id)'></td>
				<td width='5%' >&nbsp;&nbsp;</td>
				<td width='10%' class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td width='20%' class='fields'><input type="text" name="p_to_resp_id" id="p_to_resp_id" size="20" maxlength="20" OnBlur='ChangeUpperCase(this)'><input type='button' align='left' name='to_resp_id' id='to_resp_id' value='?' class='button' onclick='searchCode(this, p_to_resp_id)'></td>
				<td width='10%' >&nbsp;&nbsp;</td>
			</TR>
			
			<tr>
						<td>&nbsp;</td>
						<td colspan='4'>&nbsp;</td>
						<td>&nbsp;</td>
						
			</tr>

			<tr>
				
				<td class="label">
					<fmt:message key="eSM.ReportNature.label" bundle="${sm_labels}"/>
				</td>
				
				<td class='fields'>
					<select name="p_report_nature" id="p_report_nature">
					<option value="B"> <fmt:message key="Common.Both.label" bundle="${common_labels}"/>
					<option value="E"> <fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
					<option value="D"> <fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
					</select>
				</td>
				<td>&nbsp;</td>
				<td colspan='2'>&nbsp;</td>
				<td>&nbsp;</td>
		</tr>
			<tr>
						<td>&nbsp;</td>
						<td colspan='4'>&nbsp;</td>
						<td>&nbsp;</td>
						
			</tr>
		</table>

		<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	</form>

</center>
</body>

