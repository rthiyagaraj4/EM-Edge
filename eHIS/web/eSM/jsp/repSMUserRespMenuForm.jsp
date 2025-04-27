<!DOCTYPE html>

<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<TITLE></TITLE>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
   
   

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src="../js/repSMUserRespMenuForm.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "SM" ;
	String p_report_id		= "SMURESML" ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	Connection con=null;
	try{
		  
	con = ConnectionManager.getConnection(request);
	
%>

</head>
<body OnMouseDown='CodeArrest()' ; onKeyDown = 'lockKey()'; onload='FocusFirstElement()';  >
<BR>
	<form name="repSMUserRespMenuForm" id="repSMUserRespMenuForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table border='0' align='center' cellspacing='0' cellpadding='0' width='80%'>
		
		 <tr>
            <td class='columnheader' colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td><br>
            
         </tr>
         
         <tr>
			<td>&nbsp;</td>
		 </tr>
         
     <table width='80%' align='center' valign='top' border='0'>
	 <tr>
                    <td width="33%">&nbsp;</td>
                    <td class="querydata" width="33%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
                    <td class="querydata" width="33%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
                </tr>
     <tr>
				<td width='20%' class="label" nowrap><fmt:message key="Common.userid.label" bundle="${sm_labels}"/></td>
				<td width='10%' class='fields'><input type="text" name="p_fm_user_id" id="p_fm_user_id"size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(from_user_id,this);'><input type='button' align='left' name='from_user_id' id='from_user_id' value='?' class='button' onclick='searchCode(this,p_fm_user_id)'></td>
				<td width='05%' class='fields'><input type="text" name="p_to_user_id" id="p_to_user_id" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(to_user_id,this);'><input type='button' align='left' name='to_user_id' id='to_user_id' value='?' class='button' onclick='searchCode(this, p_to_user_id)'></td>
				<td width='10%' >&nbsp;</td>
	</tr> 
	
			<tr>
			<td>&nbsp;</td>
		 	</tr>
				
	<tr>
	<td class='label' width='15%'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
    <input type="text" name="p_responsibility" id="p_responsibility" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(resp_id,this);'><input type='button' align='left' name='resp_id' id='resp_id' value='?' class='button' onclick='searchCode(this,p_responsibility)'>
    </td>			
	</tr>
	
	<tr>
	<td>&nbsp;</td>
	</tr>
	
	<tr>			
	 <td class= "label" width='15%'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<input type="text" name="p_menu" id="p_menu" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(menu_id,this);'><input type='button' align='left' name='menu_id' id='menu_id' value='?' class='button'  onClick='searchCode(this,p_menu)'>
		</td>
	 
					</tr>
					
					<tr>
					<td>&nbsp;</td>
					</tr>
			
			<tr>
			<td align='right' width='10%' class="label">
						<fmt:message key="Common.groupby.label" bundle="${common_labels}"/> &nbsp;
					</td>
					
					<td  width='10%' align="left" >
						<select name='p_group_by' id='p_group_by' onChange='clearValues()'>
						<option value='S'>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
						<option value='1' selected><fmt:message key="Common.responsibility.label" bundle="${bl_labels}" />
						<option value='2'><fmt:message key="Common.menu.label" bundle="${common_labels}"/>
						<option value='3'><fmt:message key="Common.user.label" bundle="${common_labels}"/>
						</select>
					</td>
			
			</tr>  
			
			<tr>
	<td>&nbsp;</td>
	</tr>
			<tr>
			<td align='right' width='10%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='10%' align="left">
						
						<select name='p_order_by' id='p_order_by' onChange='clearValues()'>
						<option value='1'><fmt:message key="Common.userid.label" bundle="${bl_labels}"/>
						<option value='2'><fmt:message key="Common.username.label" bundle="${common_labels}"/>
						</select>
					</td>	 
					</tr>
			   
   </table>
   <input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
   <input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
    <input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">

	</table>	
</form>
</body>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>
</html> 

