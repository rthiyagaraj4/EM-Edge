<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
  <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> </link> -->
  <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <SCRIPT language='javascript' src='../../eFM/js/DTDocumentNumberLookup.js'></SCRIPT>
   <SCRIPT language='javascript' src='../../eFM/js/FMRepInactiveFiles.js'></SCRIPT>
  <script src="../../eCommon/js/common.js" language="javascript"></script>
  <script src="../../eCommon/js/FieldFormatMethods.js" language="javascript"></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>

</head>
<%
  String p_facility_id		= (String) session.getValue( "facility_id" ) ;
  String URL = "../../eCommon/jsp/commonToolbar.jsp?";
  String params = request.getQueryString();
  String source = URL + params;
  String call_from=request.getParameter("call_from");

  String maintain_doc_or_file = "";
if(call_from==null) call_from="";
if (call_from.equals("MAIN"))
{
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs   = null;
  Statement stmt = null;
	try {
	stmt = con.createStatement();
	
	/*Added by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
	Boolean isNatIdInInactvFileRepAppl	=	eCommon.Common.CommonBean.isSiteSpecific(con, "FM", "FM_INACTV_FILE_NATID");

	JSONArray AlternateIdJsonArr = new JSONArray();
	AlternateIdJsonArr  = eFM.FMCommonBean.getAlternateId(con);
	 /*End ML-MMOH-CRF-0895*/
	
/*	String mysql = "SELECT maintain_doc_or_file FROM mp_param";
	rs = stmt.executeQuery(mysql);
	if(rs != null && rs.next())
	{
		maintain_doc_or_file = rs.getString("maintain_doc_or_file");
	}
	if(rs!=null)	rs.close();	*/
	
	String pat_length="",alt_id1_length="",alt_id1_type="";
   
	rs=stmt.executeQuery("select a.patient_id_length,a.maintain_doc_or_file,a.alt_id1_length,b.long_desc alt_id1_type from mp_param a, MP_ALTERNATE_ID_TYPE_lang_vw b where a.alt_id1_type=b.alt_id_type and language_id='"+localeName+"'");
	if (rs!=null&&rs.next()){
       pat_length = rs.getString("patient_id_length");
	   maintain_doc_or_file = rs.getString("maintain_doc_or_file");
       alt_id1_length = rs.getString("alt_id1_length");
       alt_id1_type = rs.getString("alt_id1_type");
	}
	if(rs!=null)	rs.close();	
%>

<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<br><br><br><br>
      <div>
        <table cellpadding='3' cellspacing='0' width='60%' border='0' align='center' >
		   <tr><td colspan='2'>&nbsp;</td></tr>
<%
		if(maintain_doc_or_file.equals("F"))
		{
%>
          <!-- <tr>
					<td width='30%' class="label">Patient Series &nbsp;</td>
					<td> <select name='p_patSeries' id='p_patSeries'><option value=''>&nbsp;&nbsp;---Select---
					<%						
					rs=stmt.executeQuery("select pat_ser_grp_code,short_desc from mp_pat_ser_grp");
					String code="",desc="";
					while (rs!=null&&rs.next()){
					   code = rs.getString(1);
					   desc = rs.getString(2);
					   %><option value = <%=code%>><%=desc%>
					   <%
					}
					%></select>
					</td>
					<td></td>
					<td></td>
          </tr>
		   <tr><td colspan='4'>&nbsp;</td></tr> -->
			<tr>
					<td  width='30%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width='70%' class='fields'><input type=text  name='p_patient_id' id='p_patient_id' size=<%=pat_length%> maxlength=<%=pat_length%> align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>
					</td>
          </tr>
			<tr>
			<!--Added by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895-->
			<%if(isNatIdInInactvFileRepAppl){%>
					<td  width='30%' class="label"><fmt:message key="Common.National.label" bundle="${common_labels}"/> <fmt:message key="Common.identification.label" bundle="${common_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/> / <fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>

					<td class='fields'>
					<select name="p_nat_id_typ_id" id="p_nat_id_typ_id" onChange = 'disableNatIdField(this.value)'>
						<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
							<%
								for(int i = 0 ; i < AlternateIdJsonArr.size() ; i++) 
									{
									JSONObject json	   = (JSONObject)AlternateIdJsonArr.get(i);
									String alt_id_type = (String) json.get("alt_id_type");
									String short_desc  = (String) json.get("short_desc");
									out.println("<option value='"+alt_id_type+"'>"+short_desc+"</option>");	
									}		
							%>
						<option value="2"><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></option>
					</select>
					<input type=text name='p_pat_id_no' id='p_pat_id_no' size=20 maxlength=20 align="center" disabled>
					</td>
			<%}else{%>
					<td  class="label"><%=alt_id1_type%></td>
					<td class='fields'><input type=text  name='p_alt_id1' id='p_alt_id1' size=<%=alt_id1_length%> maxlength=<%=alt_id1_length%> align="center" onKeyPress='return CheckForSpecChars(event);'>
					</td>
			<%}%>
			<!--End ML-MMOH-CRF-0895-->
          </tr>
          </tr>
		<!--    <tr>
				<td >&nbsp;</td><td class="label">&nbsp;Tertiary &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Secondary &nbsp;&nbsp;&nbsp;&nbsp;Primary</td>
				</tr> -->
			<tr>
		<td  class="label"><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></td>
					<td class='fields' >
					<TABLE border='0' width='100%'>
							<TR>
								<TD width='25%' class='querydata'><fmt:message key="Common.tertiary.label" bundle="${common_labels}"/></TD>
								<TD width='25%' class='querydata'><fmt:message key="Common.secondary.label" bundle="${common_labels}"/></TD>
								<TD width='25%' class='querydata'><fmt:message key="Common.primary.label" bundle="${common_labels}"/></TD>
								<TD width='25%'>&nbsp;</TD>
							</TR>
							<TR>
								<TD class='fields'><input type=text  name='p_terminalDigit3' id='p_terminalDigit3' size=7 maxlength=7 align="center"></TD>
								<TD class='fields'><input type=text  name='p_terminalDigit2' id='p_terminalDigit2' size=7 maxlength=7 align="center"></TD>
								<TD class='fields'><input type=text  name='p_terminalDigit1' id='p_terminalDigit1' size=7 maxlength=7 align="center"></TD>
								<TD>&nbsp;</TD>
							</TR>
					</TABLE>
				
			
			<!-- <input type=text  name='p_terminalDigit3' id='p_terminalDigit3' size=7 maxlength=7 align="center">&nbsp;&nbsp;<input type=text  name='p_terminalDigit2' id='p_terminalDigit2' size=7 maxlength=7 align="center">&nbsp;&nbsp;<input type=text  name='p_terminalDigit1' id='p_terminalDigit1' size=7 maxlength=7 align="center"> -->
					</td>
          </tr>
<%
	}
	else if(maintain_doc_or_file.equals("D"))
	{
%>
		<tr>
					<TD class='label' width='30%' ><fmt:message key="eFM.DocumentFolder.label" bundle="${fm_labels}"/></TD>
					<TD class='fields' width='70%'><input type="text" maxlength="15" size="18" name="document_folder" id="document_folder"  onChange="docFolderLookup(this.value);"><input type='button' class='button' name='doc_fold_search' id='doc_fold_search' value='?' align=center onClick='docFolderLookup(document_folder.value);'></TD>
          </tr>
<%
	}
%>	 
			<tr>
					<td class="label"><fmt:message key="eFM.InactivePeriod.label" bundle="${fm_labels}"/></td>
					<td  class='fields' ><input type=text  name='p_period' id='p_period'  class = number onKeyPress='return(ChkNumberInput(this,event,0))' onblur ='CheckPositiveNumber(this)' size=2 maxlength=2 align="center">
						<select name='p_period1' id='p_period1'  ><option value = 'D' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option><option value = 'M' ><fmt:message key="Common.months.label" bundle="${common_labels}"/></option><option value = 'Y' ><fmt:message key="Common.Years.label"  bundle="${common_labels}"/></option></select><img src='../../eCommon/images/mandatory.gif'>
					</td>
          </tr>
			<tr>
             <td  class='label'><fmt:message key="eFM.InactiveIn.label" bundle="${fm_labels}"/></td>
             <td class='fields'><input type='radio' name='visit_status1' id='visit_status1'  value='A' onClick="chkVal(this)" CHECKED>&nbsp;<font class='label'><fmt:message key="eFM.AcrossFacility.label" bundle="${fm_labels}"/>&nbsp;
			<input type='radio' name='visit_status2' id='visit_status2'  value='L' onClick="chkVal(this)"><font class='label'>&nbsp;<fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/></td>
			   </tr>
		   <tr><td colspan='2'>&nbsp;</td></tr>
        </table>
     </div>
     <input type='hidden' name='p_report_id' id='p_report_id' value='FMBINACT'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='FM'></input>
     <input type='hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     <input type='hidden' name='p_select' id='p_select' value="A"></input>
	 <INPUT type='hidden' name='doc_folder_id' id='doc_folder_id' value=''>
	 <!--Added by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895-->
	 <input type='hidden' name='isNatIdInInactvFileRepAppl' id='isNatIdInInactvFileRepAppl' value='<%=isNatIdInInactvFileRepAppl%>'></input>
<%
	 if (rs != null) rs.close();
     if (stmt != null) stmt.close();
     } catch(Exception e) {
          out.println(e.toString());          
     }
     finally {
         
		  ConnectionManager.returnConnection(con,request);

     }
%>
	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
  </form>
</body>

</html>
<%}
else
{
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_search_criteria' id='f_search_criteria' src='../../eFM/jsp/FMRepInactiveFiles.jsp?call_from=MAIN' scrolling='no' noresize frameborder='0' style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' noresize' frameborder='0' style='height:12vh;width:100vw'></iframe>

<%}%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

