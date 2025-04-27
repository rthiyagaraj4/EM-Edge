<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>

<script>
	async function searchCode(obj,target){
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="select APPL_USER_ID,APPL_USER_NAME from sm_appl_user ";
			var search_code="APPL_USER_ID";
			var search_desc="APPL_USER_NAME";
			var tit="User";

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
			
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
	async function searchCodeResp(obj,target){
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="select RESP_ID,RESP_NAME from sm_resp ";
			var search_code="RESP_ID";
			var search_desc="RESP_NAME";
			var tit="Responsibility";

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
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0053 - To " + str + " should be greater than or equal to From " + str ;		
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
	String p_report_id		= "SMBFUNRE" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_or_user   = request.getParameter("resp_user");
%>
<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()';onKeyDown = 'lockKey()'; >
<center>
	<form name="repUserList" id="repUserList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br><br><br><br><br><br><br>

		<table border='0' align='center' cellspacing='0' cellpadding='0' width='80%'>
		<tr>
					<td width='10%'>&nbsp;</td>
					<td colspan='4'>&nbsp;</td>
					<td width='10%'>&nbsp;</td>
					
		</tr>	
           <%
		   if (p_resp_or_user.equalsIgnoreCase("U"))
		     {
			  p_report_id		= "SMBFUNUR" ;
			 %>
				<TR>
				<td width='30%' class="label" nowrap><fmt:message key="eSM.UserIDFrom.label" bundle="${sm_labels}"/></td>
				<td width='10%' >&nbsp;&nbsp;<input type="text" name="p_from_appl_user_id" id="p_from_appl_user_id" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);'>
				<td width='10%' ><input type='button' align='left' name='from_user_id' id='from_user_id' value='?' class='button' onclick='searchCode(this,p_from_appl_user_id)'>&nbsp;&nbsp;</td>
				<td width='10%' class="label" width='10%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td width='10%' >&nbsp;&nbsp;<input type="text" name="p_to_appl_user_id" id="p_to_appl_user_id" size="30" maxlength="30" OnBlur='ChangeUpperCase(this)'></td>
				<td width='30%' ><input type='button' align='left' name='to_user_id' id='to_user_id' value='?' class='button' onclick='searchCode(this, p_to_appl_user_id)'>&nbsp;</td>
			</TR>
			<%
			 }
			else
			{
			  p_report_id		= "SMBFUNRE" ;
			 %>
			<TR>
				<td width='30%' class="label" nowrap><fmt:message key="eSM.ResponsibilityIDFrom.label" bundle="${sm_labels}"/></td>
				<td width='10%' colspan=2 class='fields'>&nbsp;&nbsp;<input type="text" name="p_from_resp_id" id="p_from_resp_id" size="20" maxlength="20" OnBlur='ChangeUpperCase(this);'><!-- </td>
				<td width='10%' > --><input type='button' align='left' name='from_resp_id' id='from_resp_id' value='?' class='button' onclick='searchCodeResp(this,p_from_resp_id)'>&nbsp;&nbsp;</td>
				<td width='10%' class="label" width='10%'>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td width='10%' colspan = 2>&nbsp;&nbsp;<input type="text" name="p_to_resp_id" id="p_to_resp_id" size="20" maxlength="20" OnBlur='ChangeUpperCase(this)'><!-- </td>
				<td width='20%' > --><input type='button' align='left' name='to_resp_id' id='to_resp_id' value='?' class='button' onclick='searchCodeResp(this, p_to_resp_id)'>&nbsp;&nbsp;</td>
			</TR>
            <% }
			%>
				<tr>

				<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
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
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	</form>
</center>
</body>

