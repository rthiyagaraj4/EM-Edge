<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
    request.setCharacterEncoding("UTF-8");
	Connection con=null;
	Statement stmt = null;
	ResultSet rs ;

	String p_module_id		= "SM" ;
	String p_report_id		= "SMBFUNLS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script>
	async function searchCode(obj,target){
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql=" select function_id, function_name from sm_function ";

			var moduleid  = document.repFunctionList.p_ft_module_id.value;
			if(moduleid != '')
				sql += " where module_id = `"+moduleid+"` ";
			var search_code="function_id";
			var search_desc="function_name";
			var tit=encodeURIComponent(getLabel('Common.Function.label','Common'));

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
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eSM/js/codeCheck.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<!--<BODY onLoad="abc(this)"-->
<BODY onload='FocusFirstElement()';onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()'>
<br>
<br>
<form name="repFunctionList" id="repFunctionList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' border='0'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

</table>

	<table width='80%' cellPadding="0" cellSpacing="0" align='center' border='0'>

					<tr>
					<td class='label'><fmt:message key="Common.Module.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td colspan='5'  ><select name='p_ft_module_id' id='p_ft_module_id'>
<!-- 						<OPTION value="">------------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------ -->
						<%
						try {
								
								 con = ConnectionManager.getConnection(request);
								 stmt = con.createStatement();
								 String sql="select module_id,module_name from sm_module where install_yn='Y' order by 2";
								 rs = stmt.executeQuery(sql);
								 if( rs != null )
								 {
								   while( rs.next() )
								   {
									String classcode1 = rs.getString( "module_id" ) ;
									String classcode2 = rs.getString( "module_name" ) ;
									out.println("<OPTION VALUE='" + classcode1+ "'>" + classcode2);
								   }
									if( rs != null )  rs.close();
									if( stmt != null )  stmt.close();
								}
							     } catch(Exception e) {
									out.println( e.getMessage() ) ;
									 	   }
									finally { 
												   ConnectionManager.returnConnection(con,request);
											}
						%>

							</select>
						</td>
						</tr>
						<tr><td colspan='6'>&nbsp;</td></tr>
					<tr>
						<td width="20%" class='label'><fmt:message key="Common.Function.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp&nbsp;</td>
						<td width="10%" ><input type=text name='p_from_function_id' id='p_from_function_id' OnBlur='ChangeUpperCase(this)'>	</td>
						<td width="10%" ><input type='button' align='left' name='from_resp_id' id='from_resp_id' value='?' class='button' onclick='searchCode(this,p_from_function_id)'>&nbsp;&nbsp;</td>
						<td width="15%" class='label' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						<td width="10%" class='fields'><input type=text name='p_to_function_id' id='p_to_function_id' OnBlur='ChangeUpperCase(this)'></td>
						<td width="15%" ><input type='button' align='left' name='from_resp_id' id='from_resp_id' value='?' class='button' onclick='searchCode(this,p_to_function_id)'>&nbsp;&nbsp;</td>
					</tr>

				<tr><td colspan='6'>&nbsp;</td></tr>

					<tr>
					<td class='label' width='30%'>
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>
					<td colspan='5' class='fields'>
						<select name='p_order_by' id='p_order_by'>
						<option value="2"><fmt:message key="Common.Function.label" bundle="${common_labels}"/> <fmt:message key="Common.identification.label" bundle="${common_labels}"/>
						<option value="3"><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr><td colspan='6'>&nbsp;</td></tr>
		</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
</form>
</BODY>
</HTML>

