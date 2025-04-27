<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
	Connection con=null;
	try{
    request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	Statement stmt = con.createStatement();
	ResultSet rs =null;
%>

<html>
<head>
    <%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eSM/js/ReportGroup.js' language='javascript'></script> 
<script language="JavaScript">
		function checkNum(obj) {
			if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {		
				if(obj.value.indexOf(".") >= 0)
				{
					alert(parent.parent.frames[0].getMessage('INVALID_INTEGER','SM'));
					obj.select();
					obj.focus();
				}
				}
				else {
					if ( obj.value.length > 0 ) {
						alert(getMessage('NUM_ALLOWED','SM'));
						obj.select();
						obj.focus();
					}
				}
	}
function CheckPositiveNumber1(obj)
		{	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {		
	}
	else {
  		if ( obj.value.length > 0 ) {
  			alert(getMessage('COPY_GR_ZERO','SM'));
  			obj.select();
  			obj.focus();
  		}
  	}
}

function checkFields1( fields, names, messageFrame) {
	var errors = "" ;
	alert(names[0]);
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
			{ 
			
				errors = getMessage('CAN_NOT_BE_BLANK','Common'); errors=errors.replace('$', names[i] );errors + "<br>" ; 
			} 
	}
	if ( errors.length != 0 ) {
		
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
		return false ;
	}
	return true ;
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="FocusFirstElement()";>

<form name='reportgroup_form' id='reportgroup_form' action='../../servlet/eSM.ReportGroupServlet' method='post' target='messageFrame'>
<div>
<br><br><br><br><br><br><br>
  <table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
  <tr>
  	<td width='25%'>&nbsp;</td>
  	<td width='25%'>&nbsp;</td>
  	<td width='25%'>&nbsp;</td>
  	<td width='25%'>&nbsp;</td>
  </tr>
    <tr>
      <td class='label' width='25%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
      <td class='fields' colspan='2'>
       <input type='text' name='id' id='id'  size='10'maxlength='8' onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this);makeValidString(this);">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
      </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
    	<td width='25%'>&nbsp;</td>
    	<td width='25%'>&nbsp;</td>
    	<td width='25%'>&nbsp;</td>
    	<td width='25%'>&nbsp;</td>
   </tr>
    <tr>
      <td class='label' width='25%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td class='fields' colspan='2'><input type='text' onBlur='makeValidString(this);' name='long_desc' id='long_desc' size='30' maxlength='30' style='{ font-size: ;}'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      <td >&nbsp;</td>
    </tr>
    <tr>
    	<td width='25%'>&nbsp;</td> 
    	<td width='25%'>&nbsp;</td>
    	<td width='25%'>&nbsp;</td>
    	<td width='25%'>&nbsp;</td>
   </tr>
    <tr>
      <td class='label' width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td class='fields' colspan="2"><!--width='60%'--><input type='text' onBlur='makeValidString(this);' name='short_desc' id='short_desc' size='15' maxlength='15'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
   </tr>
	<tr>
	  	<td class='label' width='25%'><fmt:message key="eSM.DefaultPrinter.label" bundle="${sm_labels}"/>&nbsp;</td>
	  	<td class='fields' colspan='2'>
	  	<select name='Dflt_Printer_Id' id='Dflt_Printer_Id'><option value =''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------
	<%
	        rs = stmt.executeQuery("Select Printer_Id,printer_name from sm_printer where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by printer_name ");

		if( rs != null ) {
	          	while( rs.next() ) {
				String printerid = rs.getString( "Printer_Id" ) ;
				String printername=rs.getString( "Printer_Name");
	%>
		<OPTION VALUE='<%=printerid%>'><%=printername%>
	<%
	          }
	      }
			  if(rs != null) rs.close();
    	      if(stmt != null) stmt.close();
	      
	%>
              </select>&nbsp;
	  </td>
	  <td>&nbsp;</td>
   </tr>
   <tr>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
  </tr>
   <tr>
  	<td class='label' width='25%'><fmt:message key="eSM.NumberofCopies.label" bundle="${sm_labels}"/></td>
  	<td class='fields' colspan='2'><!---width='60%'--> <input type='text' name='Dflt_No_Of_Copies' id='Dflt_No_Of_Copies' size='2' maxlength='2' onKeyPress='return(ChkNumberInput(this,event,0))' onblur="CheckNum(this);CheckPositiveNumber1(this);">
  	<td>&nbsp;</td>
   </tr>
   <tr>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   </tr>
    <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10'   onblur='CheckDate(this)' maxlength='10'>
    <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10'  onblur='CheckDate(this)' maxlength='10'>
     
    
	<tr>
	<td class='label' width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      <td class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E' checked>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
   </tr>
  </table>
</div>
<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='eff_date_from' id='eff_date_from'>
<input type='hidden' name='eff_date_to' id='eff_date_to'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
</form>

</body>
</html>
<%
}catch(Exception e){out.println(e);}
finally { 
			ConnectionManager.returnConnection(con,request);
		}	
%>

