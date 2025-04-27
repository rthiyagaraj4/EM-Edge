<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
response.setContentType("text/html");
String Facility_Id = (String) session.getValue("facility_id");
String loginuser    = (String) session.getValue( "login_user" ) ;
String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
String sql = "";
String pid_length="";
String locale=(String)session.getAttribute("LOCALE");
%>
<%

Connection conn1 = null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
ResultSet rset1=null;
try{	
		conn1 = ConnectionManager.getConnection(request);
	    
		 
		StringBuffer sql1 =new StringBuffer();
		String loctype="";
		String loctypedesc="";
		String sysdate1="";
	    sql = "select patient_id_length from mp_param";
		stmt = conn1.createStatement();
		rset = stmt.executeQuery(sql);
		if(rset != null){
		if(rset.next())
			  pid_length = rset.getString(1);
          
		}
		if(pid_length==null || pid_length.equals(""))
			pid_length = "20";
        if(rset != null) rset.close();
		if(stmt != null) stmt.close();
       
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script language='javascript' src='../../eOP/js/OPCancelledCheckout.js'></script>
<script language="javascript" src="../../eOP/js/OPPractitionerComponent.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>

<%
String str="select to_char(sysdate,'dd/mm/yyyy') sys from dual";
Statement smt=conn1.createStatement();
ResultSet rst=smt.executeQuery(str);
   if(rst != null)
	 {
	   while(rst.next())
		{
		 sysdate1=rst.getString("sys");
										
										
			}
			}						  
	if (rst != null)       rst.close();
	if (smt != null)       smt.close();

	%>

<form name='OPCancelChkoutSearchForm' id='OPCancelChkoutSearchForm'>
<table border='0' cellpadding='2' cellspacing='0' width='100%' >
<tr>
        <td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" name ="speciality_desc"  id ="speciality_desc" maxlength="15" size="15" onBlur="getValues(speciality_button,this,speciality_code)"><input type='button' class='button'  name='speciality_button' id='speciality_button' value='?' onclick="getValues(this,speciality_desc,speciality_code)"><input type='hidden' name='speciality_code' id='speciality_code' value=''></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
</tr>
<tr>    <td   class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
<td  class='Fields'>
				<select name="Qloctype" id="Qloctype" onChange="clearList()"><option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- 
				<%

								sql1.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");
								stmt1 = conn1.createStatement();
								rset1=stmt1.executeQuery(sql1.toString());
								if(rset1 != null)
								{
									while(rset1.next())
									{
										loctype=rset1.getString("locn_type");
										loctypedesc=rset1.getString("short_desc");
										%>
											<option value="<%=loctype%>" ><%=loctypedesc%>
										<%
									}
								}						  
							  if (rset1 != null)       rset1.close();
							  if (stmt1 != null)       stmt1.close();
							  sql1.setLength(0);						

				%>
				</select>
				</td>
      
		<td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'> <input type='text' name='oplocation_desc' id='oplocation_desc' size='20' maxlength='20' onBlur="getValues(locn_button,this,oplocation,document.forms[0].Qloctype.value)"><input type='hidden' name='oplocation' id='oplocation' value=''><input type='button' class='button' readOnly name='locn_button' id='locn_button' value='?' onClick="getValues(this,oplocation_desc,oplocation,document.forms[0].Qloctype.value)"></td>
		<!--<td class='LABEL'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		  <td class='fields'><INPUT TYPE="text" name="oplocation_desc" id="oplocation_desc" size='20' maxlength='20' ><input type='hidden' name='oplocation' id='oplocation' value=''><input type='button' class='button' readOnly name='locn_button' id='locn_button' value='?'onClick="getLocn('<%=loginuser%>','<%=oper_id%>','<%=Facility_Id%>',document.forms[0].Qloctype.value,document.forms[0].oplocation_desc)"></td>-->
</tr>
<tr>
 <td class='label'> <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text' name='oppract_desc' id='oppract_desc' size='30' maxlength='30' onBlur="getValues(pract_button,this,oppract)"><input type='hidden' name='oppract' id='oppract' value=''><input type='button' class='button' readOnly name='pract_button' id='pract_button' value='?' onClick="getValues(this,oppract_desc,oppract)"></td>
<td class='label' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
        <td class='fields'  width='25%'><input type='text' name='txtpatid' id='txtpatid' size='20' onKeyPress="return CheckForSpecChars(event)" onBlur='changeCase(this)' maxlength='<%=pid_length%>'><input type='button' class='button'  name='butpat' id='butpat' value='?'  onclick='patqry()'></td>
</tr>
<tr>
		<td  class='label'  width="25%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><select name='gender' id='gender' tabindex=8>
		<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select>
		</td>
       <!-- <td class='LABEL'  width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	    <td class='field'  width='25%'><input type='text' name='encounter_id' id='encounter_id' value='' tabindex=2 size='13' maxlength='12' onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))' onBlur='return(ChkNumber(this))'><input type='button' class='BUTTON' value='?' name='encounter_search' id='encounter_search' onClick ='patvisit();'></td>-->
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</tr>
		<tr>
       <!-- <td class='LABEL' width='25%'><fmt:message key="Common.CancelledDateFrom.label" bundle="${common_labels}"/></td>
        <td class='fields' width='25%'><input type='text' id='crifrom' name='txtdtfrm' id='txtdtfrm' size='10' maxlength='10' onblur='validDateObj(this,"DMY",localeName);'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('crifrom');" style="cursor='hand'"></img></td>
		<td class='LABEL' width='25%'> <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
        <td class='fields' width='25%'><input type='text' id='crito' name='txtdtto' id='txtdtto' size='10' maxlength='10' onblur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('crito');" style="cursor='hand'"></img></td>-->
		<td class='label' width='25%'><fmt:message key="Common.CancelledDateFrom.label" bundle="${common_labels}"/></td>
        <td class='fields' width='25%'><input type='text'  name='txtdtfrm' id='txtdtfrm' size='10' maxlength='10' onblur='validDateObj(this,"DMY",localeName);'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('txtdtfrm');" style="cursor='hand'"></img></td>

        <td class='label' width='25%'> <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
        <td class='fields' width='25%'><input type='text'  name='txtdtto' id='txtdtto' size='10' maxlength='10' onblur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('txtdtto');" style="cursor='hand'"></img></td>
    </tr>
	<tr>
	<td class='label' width="25%"><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><input type='text' name='cancelled_by' id='cancelled_by'  tabindex=4 onKeyPress="return(CheckForSpecChars(event))"  value="" size='20' maxlength='30' onBlur='GetCancellLookupBlur(this);'><input type='hidden' name='user' id='user' size='40' maxlength='30' value='' readonly><input type='button' class='BUTTON' value="?"  name='cancel_search' id='cancel_search'onclick='GetCancellLookup(cancelled_by)' ></td>
		<td>&nbsp;</td>
		<td class='fields'><input type="button" class='Button' name="search_button" id="search_button" title='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onClick='searchCancelChkout();'><input type="button" class='Button' name="clear_button" id="clear_button" title='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearFn();'></td>
		</tr>

</table>
<input type='hidden' name='facility_id' id='facility_id' value='<%=Facility_Id%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='sysdate1' id='sysdate1' value='<%=sysdate1%>'>
	</form>
</body>
</html>
<%
}
catch(Exception e){
//out.println("Excep1:"+e);
e.printStackTrace();
}
finally
{
	try{
	if(stmt!=null) stmt.close();
	if(rset!=null)rset.close();
	}catch(Exception e){}
   if(conn1!=null) ConnectionManager.returnConnection(conn1,request);
}
%>

