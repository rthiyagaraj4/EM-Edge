<!DOCTYPE html>
<html>
<%@ page import =" java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eQA/js/QAAnalyzePartialIndicators.js" language="javascript"></script>
<script src="../../eQA/js/QAMessages.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String pat_id_length ="";
try{
	conn					 = ConnectionManager.getConnection(request);
	pstmt                    = conn.prepareStatement("select count(*) from qa_qind_param");
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
	pstmt = conn.prepareStatement("select patient_class,short_desc FROM am_patient_class");
	 rs = pstmt.executeQuery();
	

%>




<body onload='FocusFirstElement()' onKeyDown = 'lockKey()' onMouseDown="CodeArrest();">
<form name="QA_SEARCH_FORM" id="QA_SEARCH_FORM" action="QAAnalyzePartialIndSearchResult.jsp" method="post"  target='query_result'>

 
 
 <table  width='100%' align="center" cellpadding='3' cellspacing='0' border='0'>
<tr>
<td   class="label" align="right" nowrap>&nbsp;Period From&nbsp;</td>
<td align=left><input type='text' name='PERIOD_FROM' id='PERIOD_FROM' value=''  onBlur="CheckDate(this)" size=10 maxlength=10><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('PERIOD_FROM');" >&nbsp;</td>
<td class=label align=right>&nbsp;To&nbsp;</td>
<td align=left><input type='text' name='PERIOD_TO' id='PERIOD_TO' value='' onBlur="CheckDate(this)" size=10 maxlength=10><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('PERIOD_TO');">
</td>
	<td width="" class="label" align="right"  nowrap>&nbsp;Patient Class&nbsp;</td>
	<td align='left'><select name='PATIENT_CLASS' id='PATIENT_CLASS' onChange='clearResult()'>
		<option value=''>&nbsp;---- Select ---&nbsp</option>
		<%
	while(rs.next())
		{
		
	%>
		<option value='<%=rs.getString("patient_class")%>'><%=rs.getString("short_desc")%></option>
	<%
		}
			%>
		</select>&nbsp;
	</td>
<%if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	String clinic_class="select qind_group_id,qind_group_desc FROM qa_qind_group WHERE eff_status LIKE 'E'"; 
	pstmt = conn.prepareStatement(clinic_class);
	 rs = pstmt.executeQuery();
	%>
</tr>

	<tr>
<td width="" class="label" align="right"  nowrap>&nbsp;Clinical Group&nbsp;</td>
	<td align='left' ><select name='clinical_group' id='clinical_group' onChange='getClindInd(),clearResult()'>
		<option value=''>&nbsp;---------------- Select ---------------&nbsp</option>

	<%
	while(rs.next())
		{
		
	%>
		<option value='<%=rs.getString("qind_group_id")%>'><%=rs.getString("qind_group_desc")%></option>
	<%
		}
			%>

<%
    if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();	 
	pstmt = conn.prepareStatement("select qind_clind_id,qind_clind_desc FROM qa_qind_clind");
	 rs = pstmt.executeQuery();
%>
		</select>
</td>
		<td width="" class="label" align="right"  nowrap>&nbsp;Clinical Indicator&nbsp;</td>
	<td align='left' colspan='3' ><select name='clinical_ind' id='clinical_ind' onChange='clearResult()'>
		<option value=''>&nbsp;---------------- Select ---------------&nbsp</option>
	<%
	while(rs.next())
		{
		
	%>
		 <option value='<%=rs.getString("qind_clind_id")%>'><%=rs.getString("qind_clind_desc")%></option> 
	<%
		}
			%>

<%
	if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
%>
		</select>&nbsp;
</td>
</tr>

<tr>
<td class=label align='right' >&nbsp;Status&nbsp;</td>
<td align='left'><select name='STATUS' id='STATUS' onChange='clearResult()'>
		<option value='Partial' selected>Partial &nbsp;</option>
		<option value='Complete' >Complete&nbsp;</option>
		<option value='All' >All&nbsp;</option>
		</select>
</td> 
<%if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	pstmt = conn.prepareStatement("select patient_id_length from mp_param");
	 rs = pstmt.executeQuery();
	if (rs.next())
			{
				pat_id_length = rs.getString(1);
				

			}
	%>
<td class=label  align=right nowrap>&nbsp;Patient ID&nbsp;</td>
<td nowrap><input type='text' name='PatientId' id='PatientId' value="" size='20' maxlength='<%=pat_id_length%>'onBlur="makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);" onKeypress='return CheckForSpecChars(event);'  >						
<input type='button' class='button' value='?' name='pat_button' id='pat_button' onClick="funPatient();" >
</td>
<td CLASS='LABEL' align='right'>Sentinel</td>
<td align='left'><select name='sentinel' id='sentinel' onChange='clearResult()'>
		<option value='' selected>Select &nbsp;</option>
		<option value='Y' >Yes&nbsp;</option>
		<option value='N' >No&nbsp;</option>
		</select></td>


</tr>
<tr>
<td class=label align=right>Order By&nbsp;</td>
<td><select name='ORDER_BY' id='ORDER_BY' onChange='clearResult()'>
<option value='ENCOUNTER_ID' selected>Encounter Id&nbsp;</option>
<option value='PATIENT_NAME' >Patient Name&nbsp;
<option value='ENCOUNTER_START_DATE'>Admission Date&nbsp;
</select></td>
<td>&nbsp;<td>
<td>&nbsp;	</td>
        <td colspan=2 nowrap align=right><input type='button' class='button' value='Search' name='Search' id='Search'
		onClick='funQATransactionSearch(document.forms[0])' ><input type='button' class='button' value='Clear' name='Clear' id='Clear'
		onClick='clearPage()'></td>
<tr>
</table>
<input type='hidden' name='sql' id='sql' value="">
</form>
</body>

</html>


	<%	}
	
	if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	}catch(Exception e) 
		{
			e.printStackTrace();
		}
	finally{
    ConnectionManager.returnConnection(conn,request);
	}
	
	
	%>

