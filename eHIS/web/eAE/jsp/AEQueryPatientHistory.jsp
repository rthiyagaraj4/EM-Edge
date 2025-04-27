<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	 String facilityId					= (String)session.getValue("facility_id");
%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<script language='javascript' src='../../eAE/js/AEPatientHistory.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

 <%	
 try{
     Connection con 					= null;
	 java.sql.Statement stmt						= null;
	 PreparedStatement pstmt            = null;
	 ResultSet rset					    = null;
	 String location_code				= "";
	 String location_desc				= "";
	 String sqlstr						= "";
	 String pid_length					= "";
	 String single_or_multi_files_ind   = "";
	 String separate_file_no_yn         = "";
	 String maintain_doc_or_file        = "";
	 String showFileNo                  = "Y"; 
	 String locale						= (String)session.getAttribute("LOCALE");

try
  {
    request.setCharacterEncoding("UTF-8");
    con	= ConnectionManager.getConnection(request);
	stmt = con.createStatement();

    sqlstr = "select patient_id_length,single_or_multi_files_ind, separate_file_no_yn, maintain_doc_or_file from mp_param";
    rset = stmt.executeQuery(sqlstr);
    if(rset != null)
       if(rset.next())
	  {
          pid_length                  = rset.getString("patient_id_length");
		  single_or_multi_files_ind   = rset.getString("single_or_multi_files_ind");
	      separate_file_no_yn         = rset.getString("separate_file_no_yn");
	      maintain_doc_or_file        = rset.getString("maintain_doc_or_file");
	  }
          
    if(pid_length==null || pid_length.equals(""))
       pid_length = "20";
    if(single_or_multi_files_ind==null || single_or_multi_files_ind.equals(""))
       single_or_multi_files_ind = "";
	if(separate_file_no_yn==null || separate_file_no_yn.equals(""))
       separate_file_no_yn = "";
	if(maintain_doc_or_file==null || maintain_doc_or_file.equals(""))
       maintain_doc_or_file = "";
	if (maintain_doc_or_file.equals("D"))
	{
		showFileNo = "N";
	}
	if (single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N"))
	{
		showFileNo = "N";
	}
	 %>  
<body onLoad='callfocus()' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center >
<form name='AEQueryPatientHistoryForm' id='AEQueryPatientHistoryForm' >   
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr><td class='LABEL' colspan='4' height='5'>&nbsp;</td></tr> 
<tr>
	<td class='LABEL' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='field'  width='25%'><input type='text' name='patient_id' id='patient_id' tabindex=1 onKeyPress="return(CheckForSpecChars(event))" value="" size='20' maxlength='<%=pid_length%>' onBlur='changeCase(this);'><input type='button' class='BUTTON' value='?' name='patient_search' id='patient_search' onClick = 'parent.callPatientSearch()'></td>
    <td class='LABEL'  width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='field'  width='25%'><input type='text' name='encounter_id' id='encounter_id' value='' tabindex=3 size='13' maxlength='12' onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))' onBlur='return(ChkNumber(this))'><input type='button' class='BUTTON' value='?' name='encounter_search' id='encounter_search' onClick ='parent.patvisit()'></td>
</tr>

<tr>
	<td  class='LABEL' width='25%'> <fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/> </td>
	<td  class='field'  width='25%'><input type='text' id='patfrom' maxlength='10'  size=9 tabindex=4 name='ae_pat_history_datefrom' id='ae_pat_history_datefrom' size='15' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){checkDate(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patfrom');" style='cursor:pointer' ></img></td>

	<td  class='LABEL'  width='25%'> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
	<td  class='field'  width='25%'><input type='text' id='patto' maxlength='10'  size=9 tabindex=5 name='ae_pat_history_dateto' id='ae_pat_history_dateto' size='15' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){checkDate(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patto');" style='cursor:pointer'></img></td>
</tr>  
<tr>
   	<td class='LABEL'  width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td  class='field'  width='25%'><select name='ae_pat_history_location' id='ae_pat_history_location' tabindex=7 onChange ='remVal1(document.forms[0].ae_pat_history_service);setService(this);'>
	<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%	

String sql_locn="select clinic_code, long_desc clinic_desc from op_clinic_lang_vw where facility_id = ? and care_locn_type_ind = 'C' and level_of_care_ind = 'E' and eff_status = 'E' and language_id ='"+locale+"' order by 2";

pstmt	= con.prepareStatement(sql_locn);
pstmt.setString(1,facilityId);
rset	= pstmt.executeQuery();
	
		while(rset!=null  && rset.next())
		{
		 location_code=rset.getString(1);
		 location_desc=rset.getString(2);
		 out.println("<option value='"+location_code+"'>"+location_desc+"</option>");
         }
		if(rset!=null)  rset.close();
		if(pstmt!=null) pstmt.close();
%>
	</select> 
	</td>
	<td class='LABEL'  width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td  class='field'  width='25%'><select name='ae_pat_history_service' id='ae_pat_history_service' tabindex=6>
	<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
</select> 
</td> 
</tr>

<tr>
	<%if (showFileNo.equals("Y")) {%> 
	<input type=hidden name='FileNo' id='FileNo' value="Y">
	<td class='LABEL'  width='25%'><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></td>
	<td class='field'  width='25%'><input type='text' name='mrn' id='mrn' tabindex=2 onKeyPress="return(CheckForSpecChars(event))" value="" size='20' maxlength='15'></td>
    <%}else{%>
	<input type=hidden name='FileNo' id='FileNo' value="N">
    <td class='LABEL' width='25%' ></td>
	<td class='field'  width='25%'><input type='text' name='mrn' id='mrn' tabindex=2  value="" size='20' maxlength='15' style="visibility:hidden"></td>
	<%}%> 
	<td class='button' colspan='2' style="text-align: right; width: 100%; padding-right: 10px;">
	<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' tabindex=8 name='search' onClick='parent.callSearch(patient_id,mrn,encounter_id,ae_pat_history_datefrom,ae_pat_history_dateto,ae_pat_history_location,ae_pat_history_service,parent.messageFrame)' style="margin-left: 5px;">
	<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' tabindex=9 onClick="parent.clear()" style="margin-left: 5px;">
	</td>
</tr>
<tr><td colspan='4' height='5'></td></tr>
</table>

</form>
<script>
	//parent.frames[0].document.forms[0].reset.disabled=true;
</script>
</body>   
	<% 
	if(rset!=null) rset.close();
    if(stmt!=null) stmt.close();
} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con!=null)		
		ConnectionManager.returnConnection(con,request);
    }
%>
<input type=hidden name=facilityId value='<%=facilityId%>'>

</html>
<%}
catch(Exception e1)
{
e1.printStackTrace();
}
%>

