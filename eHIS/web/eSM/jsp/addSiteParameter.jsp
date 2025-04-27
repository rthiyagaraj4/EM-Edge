<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,java.rmi.*,javax.ejb.*,javax.naming.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
	Connection con = null ;
	Statement stmt = null ;
	ResultSet rs = null ;
    request.setCharacterEncoding("UTF-8");

	
%>
<html>
<head>
   <%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<script>
	function setValue(Obj)
	{
		if(Obj.checked)
			Obj.value = "Y";
		else
			Obj.value = "N";
	}
</script>

<script  language='javascript'>	function addOrderByCol()	{ 		var from = document.getElementById('item')('orderbycols'); if ( from.options.length > 0 ) { var to = document.getElementById('item')('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element); 			from.remove(from.selectedIndex); } } function removeOrderByCol()	{ var from = document.getElementById('item')('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.getElementById('item')('orderbycols');		var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);			from.remove(from.selectedIndex); } }	function SelectAll(){var i = 0; document.getElementById('orderbycolumns').selectedIndex=0; while ( i < document.getElementById('orderbycolumns').length) { 	document.getElementById('orderbycolumns').options[i].selected=true; i++; }} function execQuery(){  SelectAll();  document.query_form.submit();}</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="siteparameter_form" id="siteparameter_form" action="../../servlet/eSM.SiteParameterServlet" method="post" target="messageFrame">
<div align="left">
<%

	  try{
			con = ConnectionManager.getConnection(request);
	      stmt = con.createStatement();
	      rs = stmt.executeQuery( "select site_id from sm_site_param" );

	      if( !(rs.next()) )

	      {
%>

 		 <table border="0" cellpadding="0" cellspacing="0" width="100%">
 		   <tr>
 		     <td width="40%" class="label"><fmt:message key="eSM.SiteID.label" bundle="${sm_labels}"/></td>
 		     <td width="60%">
 		     &nbsp;&nbsp; <input type="text" name="site_id" id="site_id" size="2" maxlength="2" onBlur="ChangeUpperCase(this)">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
  		     </td>
 		   </tr>

 		   <tr>
 		     <td width="40%" class="label" ><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/> </td>
 		     <td width="60%">&nbsp;&nbsp;&nbsp;<input type="text" name="site_name" id="site_name" size="30"   maxlength="30">
 		     <img src='../../eCommon/images/mandatory.gif'></img>
 		     </td>
 		   </tr>
	</table>
				 <br>

		<TABLE  border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>

			<TABLE  border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>

<th>&nbsp;</th><th ><fmt:message key="Common.Address.label" bundle="${common_labels}"/></th><th align='left'><fmt:message key="eSM.Prompts.label" bundle="${sm_labels}"/></th><th align='left'><fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></th> 
<tr><td width='10%'>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
<tr>
	<td>&nbsp;</td><td class='label' width='20%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>1&nbsp;&nbsp;&nbsp;</td>
	<td><input type='text' name='addr_line1_prompt' id='addr_line1_prompt' size='15' maxlength='15'
	value=''>
	</td>
	<td><input type='text' name='addr_line1_order' id='addr_line1_order' size='1' maxlength='1' value=''  onKeyPress='return allowValidNumber(this,event,1,0);return checkNumberRange()'> 
	</td>
	
</tr>


<tr>
	<td>&nbsp;</td>
	<td class='label' width='20%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>2&nbsp;&nbsp;&nbsp;</td>
	<td >
	<input type='text' name='addr_line2_prompt' id='addr_line2_prompt' size='15' maxlength='15' value=''>
	</td>
	<td>
	<input type='text' name='addr_line2_order' id='addr_line2_order' size='1' maxlength='1' value='' onKeyPress='return allowValidNumber(this,event,1,0);'> 
	</td>
</tr>

<tr>
	<td>&nbsp;</td><td class='label' width='20%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>3&nbsp;&nbsp;&nbsp;</td>
	<td ><input type='text' name='addr_line3_prompt' id='addr_line3_prompt' size='15' maxlength='15' value=''>
	</td>
	<td>
	<input type='text' name='addr_line3_order' id='addr_line3_order' size='1' maxlength='1' value='' onKeyPress='return allowValidNumber(this,event,1,0);'>&nbsp;<img src='../../eCommon/images/mandatory.gif' name='img_addr_line3_prompt' style="visibility:hidden"></td>
</tr>


<tr>
	<td>&nbsp;</td><td class='label' width='20%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>4&nbsp;&nbsp;&nbsp;</td>
	<td ><input type='text' name='addr_line4_prompt' id='addr_line4_prompt' size='15' maxlength='15' value=''>
	</td>
	<td>
	<input type='text' name='addr_line4_order' id='addr_line4_order' size='1' maxlength='1' value='' onKeyPress='return allowValidNumber(this,event,1,0);' >
	</td>
</tr>

<tr><td  colspan='4'>&nbsp;</td></tr>

<tr>
	<td>&nbsp;</td><td class='label' width='20%'><fmt:message key="Common.area.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
	<td ><input type='text' name='res_area_prompt' id='res_area_prompt' size='15' maxlength='15' value='' >
	</td>
	<td>
	<input type='text' name='res_area_order' id='res_area_order' size='1' maxlength='1' value='' onKeyPress='return allowValidNumber(this,event,1,0);'> 
	</td>


<tr>
	<td>&nbsp;</td>
	<td class='label' width='20%'><fmt:message key="Common.Town.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
	<td ><input type='text' name='res_town_prompt' id='res_town_prompt' size='15' maxlength='15' value='' >
	</td>
	<td><input type='text' name='res_town_order' id='res_town_order' size='1' maxlength='1' value='' onKeyPress='return allowValidNumber(this,event,1,0);'>
	</td>
</tr>
<tr><td  colspan='4'>&nbsp;</td></tr>

<tr>
	<td>&nbsp;</td><td class='label' width='20%'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;</td>
	<td > <input type='text' name='postal_code_prompt' id='postal_code_prompt' size='15' maxlength='15' value='' >
	</td>
	<td><input type='text' name='postal_code_order' id='postal_code_order' size='1' maxlength='1' value='' onKeyPress='return allowValidNumber(this,event,1,0);'></td>
</tr>
<tr><td colspan='4'>&nbsp;</td></tr>
</table>
<br>
<table  border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>
<th align='left' colspan='2'><fmt:message key="eSM.WorkStationIdentification.label" bundle="${sm_labels}"/></th> 
<tr>
	<td width="40%" class="label" nowrap><fmt:message key="eSM.WorkstationIdentificationBy.label" bundle="${sm_labels}"/></td>
 	<td width="60%">&nbsp;&nbsp;<select name="wkstation_identify" id="wkstation_identify">
		<option value='I'><fmt:message key="eSM.IPAddress.label" bundle="${sm_labels}"/></option>
		<option value='N'><fmt:message key="Common.MachineName.label" bundle="${common_labels}"/></option>
	</select>
  	</td> 
</tr>
<tr>
	<td width="40%" class="label" nowrap><fmt:message key="eSM.ChangeWSIdentificationat FacilityLevel.label" bundle="${sm_labels}"/></td>
 	<td width="60%">&nbsp;&nbsp;<input type="checkbox" name="change_wsid_at_facility" id="change_wsid_at_facility" value="N" onChange="setValue(this);">
  	</td>
</tr>
</table>
</div>
<input type="hidden" name="eff_date_from" id="eff_date_from" value="">
<input type="hidden" name="eff_date_to" id="eff_date_to" value="" >
<input type="hidden" name="eff_date_from1" id="eff_date_from1" value="">
<input type="hidden" name="eff_date_to1" id="eff_date_to1" value="" >
<input type="hidden" name="function" id="function" value="insert">
<input type='hidden' name='function_name' id='function_name' value='insert'>
</form>
</body>
</html>
<%
  }
	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;
		
}catch(Exception e){out.println(e);}
finally { 
			ConnectionManager.returnConnection(con,request);
		}
%>

