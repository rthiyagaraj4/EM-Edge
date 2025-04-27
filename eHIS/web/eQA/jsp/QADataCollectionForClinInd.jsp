<!DOCTYPE html>
<html>
<%@ page import =" java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%!
  String ip_StartDate="",ip_EndDay="",op_StartDate="",op_EndDay="",
  dc_StartDate="",
  dc_EndDay="",em_StartDate="",em_EndDay="";
%>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js"  language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js"		  language="javascript"> </script>
	<script src="../../eCommon/js/dchk.js"			  language="javascript"> </script>
	<Script src="../../eQA/js/QAMessages.js"  language="JavaScript"></Script>
	<Script src="../../eQA/js/QADataCollectionForClinInd.js" language="JavaScript"></Script>
	<script language='javascript' src='../js/NoteDisclaimer.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="QABGEngine" id="QABGEngine" action="../../servlet/eQA.QADataCollectionForClinIndServlet" method="post" target="messageFrame">
<%
	Connection conn          = null;
	PreparedStatement pstmt  = null;
	ResultSet rs             = null;
	try
	{
		String qaparm            = "select count(*) from qa_qind_param";
		conn					 = ConnectionManager.getConnection(request);
		pstmt                    = conn.prepareStatement(qaparm);
		rs                       = pstmt.executeQuery();
		rs.next();
		if(rs.getInt(1)==0)
		{
			out.println("<script>alert(getMessage('QA_PARAM_NOT_FOUND'));parent.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		 
		}
		else
		{
			if (rs != null ) rs.close();
			if (pstmt != null) pstmt.close();
			String sql="select to_char((SYS_REC_PROC_UPTO_DATE_IP),'dd/mm/yyyy hh24:mi:ss') IP_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') IP_TO_DAY, to_char(SYS_REC_PROC_UPTO_DATE_DC,'dd/mm/yyyy hh24:mi:ss') DC_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') DC_TO_DAY, to_char(SYS_REC_PROC_UPTO_DATE_OP,'dd/mm/yyyy hh24:mi:ss') OP_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') OP_TO_DAY , to_char(SYS_REC_PROC_UPTO_DATE_EM,'dd/mm/yyyy hh24:mi:ss') EM_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') EM_TO_DAY, to_char(SYS_REC_PROC_UPTO_DATE_XT,'dd/mm/yyyy hh24:mi:ss') XT_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') XT_TO_DAY from QA_QIND_PARAM";
			//java.util.Date dat=new java.util.Date();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{	 
				ip_StartDate=rs.getString("IP_START_DAY");			
				if(ip_StartDate==null)
				ip_StartDate="01/01/1900 12:00:01";
				ip_EndDay=rs.getString("IP_TO_DAY");

				dc_StartDate=rs.getString("DC_START_DAY");
				if(dc_StartDate==null)
				dc_StartDate="01/01/1900 12:00:01";
				dc_EndDay=rs.getString("DC_TO_DAY");

				em_StartDate=rs.getString("EM_START_DAY");
				if(em_StartDate==null)
				em_StartDate="01/01/1900 12:00:01";
				em_EndDay=rs.getString("EM_TO_DAY");

				op_StartDate=rs.getString("OP_START_DAY");
				if(op_StartDate==null)
				op_StartDate="01/01/1900 12:00:01";
				op_EndDay=rs.getString("OP_TO_DAY");
 			}
		if (rs != null ) rs.close();
		if (pstmt != null) pstmt.close();
	   }
%>
<br>
<br><BR><BR><BR>
<table border="0" cellpadding="0" cellspacing="0" width="60%" align='center'>
<tr><td colspan=6>&nbsp</td></tr>
<tr>
		<td> &nbsp;</td>
		<td> &nbsp;</td>
		<td>&nbsp;</td>
	   <td class=label><b> From</b></td>
	   <td class=label><b>To</b></td>
	   <td class=label><b>Run</b></td>
	</tr>
     <tr >
  	  <td> &nbsp; </td>
      <td> &nbsp;</td>
	  
	  <td align="right" align ='left' class="label"><!-- <b>Inpatient</b> -->&nbsp;&nbsp;</td>
		
     <td class="label" align='left'> 
	  <INPUT TYPE="text" id='IP_FROM' name="PROC_DATE_IP_FROM"  size=17 maxlength=20   value='<%=ip_StartDate%>'  readonly ><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('IP_FROM');" disabled>
     <td>
          <INPUT TYPE="text" id='IP_TO' name="PROC_DATE_IP_TO"  size=17 maxlength=20   value='<%=ip_EndDay%>' onkeypress="return chkchar(this,event)"; onBlur='ValidateDateTimesp(forms[0].IP_FROM,this)' ><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('IP_TO',null,'hh:mm:ss') ;">
		  </td>
            <td  align=left> <INPUT TYPE="checkbox" name="ipgenerate" id="ipgenerate"  checked value="Y" onClick='checkyn(this)'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
	  
	 </tr>

	 <tr><td colspan=6>&nbsp</td></tr>

<!-- <tr>
	  <td> &nbsp; </td>
      <td> &nbsp;</td>
	  <td align="right" align ='left' class="label"><b>Daycare</b>&nbsp;&nbsp;</td>
     <td class="label" align='left'>
      <INPUT TYPE="text" id='DC_FROM' name="PROC_DATE_DC_FROM" id="PROC_DATE_DC_FROM" size=17 maxlength=20     value='<%=dc_StartDate%>' readonly><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('DC_FROM');" disabled></td>
	
     <td> 
		 <INPUT TYPE="text" id='DC_TO' name="PROC_DATE_DC_TO" id="PROC_DATE_DC_TO" size=17 maxlength=20  value='<%=dc_EndDay%>' onkeypress="return chkchar(this,event)"; onBlur='ValidateDateTimesp(forms[0].DC_FROM,this)'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('DC_TO',null,'hh:mm:ss');">&nbsp
	  </td>
 <td > <INPUT TYPE="checkbox" name="dcgenerate" id="dcgenerate" value="Y"  checked onClick='checkyn(this)'> </td> 
</tr>

	 	<tr><td colspan=6>&nbsp</td></tr>
<tr >
  	  <td> &nbsp; </td>
       <td> &nbsp; </td>
      <td align="right" align ='right' class="label"><b>Emergency</b>&nbsp;&nbsp;</td>

     <td class='Label' align='left'>
      <INPUT TYPE="text" id='EM_FROM' name="PROC_DATE_EM_FROM" id="PROC_DATE_EM_FROM" size=17 maxlength=20   value='<%=em_StartDate%>'  readonly><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('EM_FROM');" disabled></td>
    
     <td> <INPUT TYPE="text" id='EM_TO' name="PROC_DATE_EM_TO" id="PROC_DATE_EM_TO" size=17 maxlength=20  value='<%=em_EndDay%>' onkeypress="return chkchar(this,event)";	  onBlur='ValidateDateTimesp(forms[0].EM_FROM,this)'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('EM_TO',null,'hh:mm:ss');">&nbsp
	  </td>

<td > <INPUT TYPE="checkbox" name="emgenerate" id="emgenerate" value="Y"  checked onClick='checkyn(this)'> </td> 
</tr>
	<tr><td colspan=6>&nbsp</td></tr>
<tr >
  	 <td> &nbsp; </td> 
     <td> &nbsp; </td>
      <td align="right" align ='right' class="label"><b>Outpatient</b>&nbsp;&nbsp;</td>

     <td class="label" align='left'>
      <INPUT TYPE="text" id='OP_FROM' name="PROC_DATE_OP_FROM" id="PROC_DATE_OP_FROM" size=17 maxlength=20	   value='<%=op_StartDate%>'  readonly><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('OP_FROM');" disabled></td>
	
     <td> <INPUT TYPE="text" id='OP_TO' name="PROC_DATE_OP_TO" id="PROC_DATE_OP_TO" size=17 maxlength=20   value='<%=op_EndDay%>' onkeypress="return chkchar(this,event)"; onBlur='ValidateDateTimesp(forms[0].OP_TO,this)'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('OP_TO',null,'hh:mm:ss');">&nbsp
  </td>
<td > <INPUT TYPE="checkbox" name="opgenerate" id="opgenerate" value="Y"  checked onClick='checkyn(this)'> </td> 
</tr>  -->
<tr><td colspan=6>&nbsp</td></tr>
</table>
<%
   }
	catch(Exception ee)
	{
%>
 Exception Occured <%=ee%>
<%
 }
finally
{
	ConnectionManager.returnConnection(conn, request);
}	
%>	
	<input type='hidden' name='ip_StartDate' id='ip_StartDate' value='<%=ip_StartDate%>'>
	<input type='hidden' name='dc_StartDate' id='dc_StartDate' value='<%=dc_StartDate%>'>
	<input type='hidden' name='op_StartDate' id='op_StartDate' value='<%=op_StartDate%>'>
	<input type='hidden' name='em_StartDate' id='em_StartDate' value='<%=em_StartDate%>'>
	<input type='hidden' name='ip_EndDay' id='ip_EndDay'	 value='<%=ip_EndDay%>'>
	<input type='hidden' name='dc_EndDay' id='dc_EndDay'	 value='<%=dc_EndDay%>'>
	<input type='hidden' name='op_EndDay' id='op_EndDay'	 value='<%=op_EndDay%>'>
	<input type='hidden' name='em_EndDay' id='em_EndDay'	 value='<%=em_EndDay%>'>
</form>
</body>
</html>




