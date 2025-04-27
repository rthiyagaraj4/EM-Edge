<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
    
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<script language="javascript" src="../../eOA/js/TransferCancelAppointment.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>



	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css'  href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con=null;
Statement stmt   	= null ;
Statement stmtlen   =null;
Statement stmt1 = null;
Statement stmt5 = null;
ResultSet rs2	   	= null;
ResultSet rs5	   	= null;
ResultSet rslen	   	= null;

boolean allow_inside=true;

String fac_id    	= (String) session.getValue( "facility_id" ) ;


String called_for=request.getParameter("called_for");
if(called_for==null) called_for="";

String locale=(String)session.getAttribute("LOCALE");
String pat_name_as_multipart_yn = "";
String pat_name_length = "";
String oper_stn_id=request.getParameter("oper_stn_id");
String currentdate=request.getParameter("currentdate");

String canc_appt_yn=request.getParameter("canc_appt_yn");
if(canc_appt_yn.equals("") ) canc_appt_yn="N";
String tfr_appt_yn=request.getParameter("tfr_appt_yn");
if(tfr_appt_yn.equals("") ) tfr_appt_yn="N";

%>
<%
try{
		con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;
		 stmtlen   = con.createStatement() ;
		 stmt1 = con.createStatement();
		 stmt5 = con.createStatement();
	
			
if(allow_inside){


	if(called_for.equals("")){
	
		if( tfr_appt_yn.equals("N") || canc_appt_yn.equals("N")){%>
			<script>alert(getMessage('NO_TRFR_APPT_OPER','OA'));
			parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';
			</script>
		<%
		}
	}else{

		 tfr_appt_yn =request.getParameter("book_appt_yn"); 
			 if(tfr_appt_yn.equals("") ) tfr_appt_yn="N";

		if(tfr_appt_yn.equals("N")){%>
			<script>alert(getMessage('SCH_NOT_ALLOW','OA'));
		parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';
			</script>
		<%
		}

	}
int pat_id_len=0;

	rslen=stmtlen.executeQuery("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length, pat_name_as_multipart_yn from mp_param");
	
	if( rslen !=null && rslen.next())
	{
	
	 pat_id_len=rslen.getInt("Patient_Id_Length");
	
	pat_name_as_multipart_yn = rslen.getString("pat_name_as_multipart_yn");
	}

	if (pat_name_as_multipart_yn.equals("N"))
	{
		//pat_name_size = "58";
		pat_name_length = "60";
	}
	else
	{
		//pat_name_size = "40";
		pat_name_length = "40";
	}
%>

</head>
<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
<form name="QueryApptForPatient" id="QueryApptForPatient">
<table width='100%' cellspacing='0' cellpadding='0' border='0'>
<tr>
	<td nowrap class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

	<td class='fields'>
			<select name='b_loc1' id='b_loc1' onchange='populatepract(this)' nowrap>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>

				<%
				rs5=stmt5.executeQuery("select locn_type, short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id = '"+locale+"' order by short_desc");
				while(rs5.next()) {
				%>
					<option value='<%=rs5.getString("CARE_LOCN_TYPE_IND")%>'><%=rs5.getString("short_desc")%>
				<%}%>		
			</select>

	<td nowrap class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

	<td class='fields'><select name='b_loc' id='b_loc' onChange = 'enablepract(this)' >
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
			</select>
	</td>
</tr>		

<tr id='resource_part'><jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "transfer_cancel" /></jsp:include>


<tr>
		<td  class='Label' nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>

        <td class='fields'>
				<input type='text' name='reason_code_cancel' id='reason_code_cancel' value='' onblur='if(this.value !="") reasonlookup()' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup();' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img>
				<input type='hidden' name='reason_for_cancellation' id='reason_for_cancellation' value=''></td>

		<td  nowrap class=label ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>

		<td  class=fields nowrap>
		<input type='text'  name='b_from_date' id='b_from_date' size='8' maxlength='10' Onblur='validate_date_from(this,b_to_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_from_date.select();return showCalendar('b_from_date');" tabindex=-1>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text'  name='b_to_date' id='b_to_date' size='8' maxlength='10' Onblur='validate_date_to(this,b_from_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_to_date.select();return showCalendar('b_to_date');" tabindex=-1><img src="../../eCommon/images/mandatory.gif"     align='center'></img>
</tr>

<tr>
	<td class='button' colspan='4'><input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick="callResult()"><input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()"></td>
</tr>
				
				
	       
</table>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'></input>
<input type='hidden' name='oper_stn' id='oper_stn' value='<%=oper_stn_id%>'>
<input type='hidden' name='called_for' id='called_for' value='<%=called_for%>'>
<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>


</form>
<%
}
	if(stmt !=null) stmt.close();
	if(rs2 !=null) rs2.close();
	if(rs5 !=null) rs5.close();
	if(stmt1 !=null) stmt1.close();
	if(stmt5 !=null) stmt5.close();
	if(rslen !=null) rslen.close();
	if(stmtlen !=null) stmtlen.close();

}catch(Exception es){
	//out.println("Exception in querycriteria"+ es.toString());
	 es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}		
%>
</body>
</html>

