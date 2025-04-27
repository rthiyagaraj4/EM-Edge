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
<script src="../../eQA/js/QADirRecordOfClinIndicators.js" language="javascript"></script>
<script src="../../eQA/js/QAMessages.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%	String qaparm            = "select count(*) from qa_qind_param";

String facilityid			=(String)session.getValue("facility_id");
   Statement stmt=null;
   ResultSet rs1=null;	
   String pat_id_length = "";
	Connection conn					 = ConnectionManager.getConnection(request);
	try{
	PreparedStatement pstmt                    = conn.prepareStatement(qaparm);
	ResultSet rs                       = pstmt.executeQuery();
	rs.next();
	if(rs.getInt(1)==0)
	{
	out.println("<script>alert(getMessage('QA_PARAM_NOT_FOUND'));parent.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		 
	}
	else
	{
	try
		{
			stmt = conn.createStatement();
			rs1	=	stmt.executeQuery("select patient_id_length from mp_param");
			if (rs1.next() && rs1 != null)
			{
				pat_id_length = rs1.getString(1);
				

			}
			if (rs1 != null ) rs1.close();
	     if (stmt != null) stmt.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	%>





<body onload='FocusFirstElement()' onKeyDown = 'lockKey()' onMouseDown="CodeArrest();">
<form name="QA_SEARCH_FORM" id="QA_SEARCH_FORM" action="" method="post"  target='query_result'>

 
<INPUT TYPE="hidden" name='facility_id' id='facility_id' value='<%=facilityid%>'>
 <table  width='100%' align="center" cellpadding='0' cellspacing='0' border='0'>
<tr>
<td class=label  align=right nowrap>Enconter ID&nbsp;</td>
<td align=left><Input type =text name='ENCOUNTER_ID' id='ENCOUNTER_ID' size='13' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)'></td>

 <td width="" class="label" align="left"  nowrap>&nbsp;Patient Class&nbsp;</td>
	<td>	<select name='PATIENT_CLASS' id='PATIENT_CLASS' onChange='clearResult()'>
		<option value=''>&nbsp;---- Select ---&nbsp</option>
		<option value='DC'>Day Care</option>
		<option value='EM' >Emergency&nbsp;</option>
		<option value='IP'>Inpatient&nbsp;</option>
		<option value='OP'>Outpatient&nbsp;</option>
		</select>&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
</td>

<td class=label  align=right nowrap>&nbsp;Patient ID&nbsp;</td>
<td nowrap><input type='text' name='PatientId' id='PatientId' value="" size='' maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);" onKeypress='return CheckForSpecChars(event);'  >						
<input type='button' class='button' value='?' name='pat_button' id='pat_button' onClick="funPatient()" >
</td>
</tr>

<tr>
<td align=right class=label nowrap>Location&nbsp;</td>
<td><input type="text" name ="ASSIGN_CARE_LOCN_CODE" maxlength="6" size="15" onBlur='if ((ASSIGN_CARE_LOCN_CODE.value !="") && (ASSIGN_CARE_LOCN_CODE.value !=null))  {getLocation(this,target); checkCodes(this);}'  > <input type='button' class='button' value='?' name='loc_button' id='loc_button' onClick="getLocation(this,target);" ></td> 
<td align="right "  class="label" nowrap>&nbsp;Period From&nbsp;</td>
<td align=left><input type='text' name='PERIOD_FROM' id='PERIOD_FROM' value=''  onBlur="CheckDate(this)" size=10 maxlength=10>
<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('PERIOD_FROM');" ></td>
<td class=label align=right>To&nbsp;</td>
<td align=left><input type='text' name='PERIOD_TO' id='PERIOD_TO' value='' onBlur="CheckDate(this)" size=10 maxlength=10>
<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('PERIOD_TO');">
</td>

</tr>

<tr>
<td align="right" class="label"  nowrap>Practitioner ID&nbsp;</td>
<td align='left'><input type="text" name ="PRACTITIONER_ID" maxlength="30" size="20" onBlur='if ((PRACTITIONER_ID.value !="") && (PRACTITIONER_ID.value !=null))  { funQAPractioner(this,target);checkCodes(this);}  '>
<input type='button' class='button'  name='pract_button' id='pract_button' value='?' onclick="funQAPractioner(PRACTITIONER_ID,target)">
<input type='hidden' name='PRACTITIONER_NAME' id='PRACTITIONER_NAME' value=''></td>
<td class=label align=right >&nbsp;Status&nbsp;</td>
<td>	<select name='STATUS' id='STATUS' onChange=''>
		<option value='1'>Open &nbsp;</option>
		<option value='2' >Closed&nbsp;
		<option value='' selected>All&nbsp;
		</select>
</td>     

<td  class='label' align=right> 
	Include Analyzed Encounters 							
<td><input type="checkbox" name="INCL_ANALYZED_YN" id="INCL_ANALYZED_YN" value="N" onClick='Incl_Encounter(); '> </td>

</tr>
<tr>
<td class=label align=right>Order By&nbsp;</td>
<td><select name='ORDER_BY' id='ORDER_BY' onChange=''>
<option value='ENCOUNTER_ID' selected>Encounter Id&nbsp;</option>
<option value='PATIENT_NAME' >Patient Name&nbsp;
<option value='VISIT_ADM_DATE_TIME'>Admission Date&nbsp;
</select></td>
<td>&nbsp;<td>
<td>&nbsp;	</td>
        <td colspan=2 nowrap align=right><input type='button' class='button' value='Search' name='Search' id='Search'
		onClick='funQATransactionSearch(document.forms[0])' >
		<input type='button' class='button' value='Clear' name='Clear' id='Clear'
		onClick='clearPage()' ></td> 
<tr>
</table>
 	
</form>
</body>

</html>

	<%	}
	
	if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	}catch(Exception e1) 
		{
			e1.printStackTrace();
		}
	finally{
    ConnectionManager.returnConnection(conn,request);
	}
	
	%>

