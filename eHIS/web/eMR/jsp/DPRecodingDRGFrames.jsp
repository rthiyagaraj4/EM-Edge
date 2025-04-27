<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
 String facility_id		= (String) session.getValue( "facility_id" ) ;

 

%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
	<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
Connection con = null;
try
{
			con = ConnectionManager.getConnection();
	Statement stmt = null;
	Statement stmt1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ArrayList elements = new ArrayList();
	CallableStatement drgCalStmt = null;		
	//HashMap results = new HashMap();		
	
	String drgMdc = "";
	String drgVal = "";
	String drgRw = "";
	String drgWtlos = "";
	String drgOt = "";
	String drgAdjrw = "";
	String drgError = "";
	String drgWarn = "";
	String drgException = "";
	String drgStatus = "";
	String drgResult = "";//Added On 3/17/2010 for Site Enhancmenent.
	String msgID = "";
	String hdr_modified_dt = "";// Added For 3/8/2010 Site Issue.
	String responseText = "";
	String profileID = "";
	String standardCode = "";
//	HashMap map = (HashMap)request.getAttribute("results");
	HashMap map = (HashMap)session.getAttribute("DRG_VAL");
	session.removeAttribute("DRG_VAL");
	String Pat_id = request.getParameter("Pat_id");
	String EncounterId = request.getParameter("EncounterId");
	String stage_no = request.getParameter("stage_no");
//	HashMap map111 = (HashMap)session.getAttribute("DRG_VAL");
	String p_language_id=request.getParameter("p_language_id");
	String	success="N";
	//String results1 = request.getParameter("results");
	String DRGcal = request.getParameter("DRGcal");
	String idle_time="";  // added on 16th Oct 2009 for crf 510
	String errTxt=""; // added on 16th Oct 2009 for crf 510
	String resp_text="";
	String drgDesc="";
	boolean is_map_null=true;
	
					//out.println("<script>alert(\"EncounterId :"+EncounterId+"\");</script>");
//					out.println("<script>alert(\"DRGcal :"+DRGcal+"\");</script>");
	if(DRGcal.equals("Y"))
	{
		try
		{

			stmt = con.createStatement();
			String msgSql="SELECT TRX_NO FROM MR_DIAG_PROC_RECODING_HDR WHERE  PATIENT_ID='"+Pat_id+"' AND ENCOUNTER_ID='"+EncounterId+"' AND FACILITY_ID='"+facility_id+"'";
			rs = stmt.executeQuery(msgSql);
			if(rs.next()){
				msgID = rs.getString("TRX_NO");
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT response_text,profile_id FROM xh_interactive_integration WHERE message_id='"+msgID+"'");
			if(rs.next()){
				responseText = rs.getString("response_text");
				profileID = rs.getString("profile_id");
			}
			
						//out.println("<script>alert(\"responseText :"+responseText+"\");</script>");
						//out.println("<script>alert(\"profileID :"+profileID+"\");</script>");

			responseText = responseText;
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT standard_code FROM xh_standard_profile WHERE profile_id='"+profileID+"'");
			if(rs1.next())
			{
				standardCode = rs1.getString("standard_code");
			}
			else
			{
				standardCode = "TGRP1";
			}
			
//			out.println("<script>alert(\"standardCode :"+standardCode+"\");</script>");

			elements.add(":DRG[38]");
			elements.add(":DRG[39]");
			elements.add(":DRG[40]");
			elements.add(":DRG[41]");
			elements.add(":DRG[42]");
			elements.add(":DRG[43]");
			elements.add(":DRG[44]");
			elements.add(":DRG[45]");
			elements.add(":DRG[48]");
			elements.add(":DRG[50]");		
			drgCalStmt = con.prepareCall("{call XHINTERACTIVE.INTERACTIVE_RESPONSE_FETCH(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			drgCalStmt.setString(1,msgID);						
			drgCalStmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(11,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(12,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(13,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(14,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(15,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(16,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(17,java.sql.Types.VARCHAR);
			drgCalStmt.execute();
			/*drgMdc = checkForNull(drgCalStmt.getString(8));
			drgVal = checkForNull(drgCalStmt.getString(4));
			drgRw = checkForNull(drgCalStmt.getString(5));
			drgWtlos = checkForNull(drgCalStmt.getString(7));
			drgOt = checkForNull(drgCalStmt.getString(6));
			drgAdjrw = checkForNull(drgCalStmt.getString(13));
			drgError = checkForNull(drgCalStmt.getString(9));
			drgWarn = checkForNull(drgCalStmt.getString(10));
			drgResult = checkForNull(drgCalStmt.getString(11));//Added On 3/17/2010 For Site Enhancement
			drgException = checkForNull(drgCalStmt.getString(16));
			drgStatus = checkForNull(drgCalStmt.getString(15));
			errTxt=checkForNull(drgCalStmt.getString(3));
			resp_text=checkForNull(drgCalStmt.getString(2));*/
			drgWtlos = checkForNull(drgCalStmt.getString(8));
			drgVal = checkForNull(drgCalStmt.getString(4));
			drgDesc = checkForNull(drgCalStmt.getString(5));
			drgOt = checkForNull(drgCalStmt.getString(7));
			drgRw = checkForNull(drgCalStmt.getString(6));
			drgResult = checkForNull(drgCalStmt.getString(12));
			drgAdjrw = checkForNull(drgCalStmt.getString(14));
			drgMdc = checkForNull(drgCalStmt.getString(9));
			drgError = checkForNull(drgCalStmt.getString(10));
			drgWarn = checkForNull(drgCalStmt.getString(11));//Added On 3/17/2010 For Site Enhancement
			drgException = checkForNull(drgCalStmt.getString(17));
			drgStatus = checkForNull(drgCalStmt.getString(16));
			errTxt=checkForNull(drgCalStmt.getString(3));
			resp_text=checkForNull(drgCalStmt.getString(2));
			

		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}

	}else{
		if(map != null)
		{
			is_map_null=false;


			drgDesc = checkForNull((String)map.get("desc"));
			drgMdc = checkForNull((String)map.get("mdc"));
			drgVal = checkForNull((String)map.get("drg"));
			drgRw = checkForNull((String)map.get("rw"));
			drgWtlos = checkForNull((String)map.get("wtlos"));
			drgOt = checkForNull((String)map.get("ot"));
			drgAdjrw = checkForNull((String)map.get("adjrw"));
			drgError = checkForNull((String)map.get("err"));
			drgWarn = checkForNull((String)map.get("warn"));
			drgResult = checkForNull((String)map.get("result"));// Added On 3/17/2010 For Site(Walkthrough) Enhancement.
			drgException = checkForNull((String)map.get("drgErrMsg"));
			drgStatus = checkForNull((String)map.get("drgErrCode"));
			idle_time=checkForNull((String)map.get("idletime"));  // added on 16th oct 2009 for crf 510
			errTxt=checkForNull((String)map.get("errTxt")); // added on 16th oct 2009 for crf 510
		}
	}

String [] warn_ary=drgWarn.split(" - ");
int i=0;
String drg_warn_code="";
for (String warn : warn_ary){
	if(i==0){
		drg_warn_code=warn;
	}
	i++;
}
String [] err_ary=drgError.split(" - ");
int j=0;
String drg_err_code="";
for (String error : err_ary){
	if(j==0){
		drg_err_code=error;
	}
	j++;
}
String result_msg="";
if(drgResult.equals("0")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Success.label","common_labels");
}else if(drgResult.equals("1")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels");;
}else if(drgResult.equals("2")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels");
}else if(drgResult.equals("3")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.and.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels");
}

String msgSql="SELECT to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE  PATIENT_ID='"+Pat_id+"' AND ENCOUNTER_ID='"+EncounterId+"' AND FACILITY_ID='"+facility_id+"'";
stmt = con.createStatement();
rs = stmt.executeQuery(msgSql);

if(rs.next()){
	hdr_modified_dt = rs.getString("MODIFIED_DATE");
}
if(stmt != null) stmt.close();
if(rs != null) rs.close();

%>
<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >
<FORM name="drg_query_results_form" id="drg_query_results_form" method="post">

<%


if(is_map_null && DRGcal.equals("N")){

	%><script>
		
		alert(getMessage('MRDRG_ERROR','MR'))
		parent.frames[4].document.forms[0].seqDrg.disabled=true;	
		</script><%

		

}else{
	if(idle_time.equals("1")){

		%><script>
		
		alert(getMessage('MRDRG_IDL_TM','MR'))
		parent.frames[4].document.forms[0].seqDrg.disabled=true;		
		</script><%
	}else{
		if(resp_text.equals("") && !errTxt.equals("")&&DRGcal.equals("Y")){%>
			<script>
				alert(getMessage('PREVIOUS_REQ_NOT_PROCESSED','MR'))
				parent.frames[4].document.forms[0].seqDrg.disabled=true;		
			</script><%
		}else{
			if(drgStatus.equals("E")){%>
				<script>
					alert('<%=drgException%>')
					parent.frames[4].document.forms[0].seqDrg.disabled=true;		
				</script><%
			}else{
				
				if(drgStatus.equals("S") && !errTxt.equals("")){

					%><script>
					
					alert('<%=errTxt%>')
					parent.frames[4].document.forms[0].seqDrg.disabled=true;		
					</script><%

				}else{
					success="Y";
					%>


						<!--<DIV ID="drgResultsDiv">-->
						<TABLE cellspacing='0' cellpadding='0' width='100%' align=center >
						<TR><td class='PANELTOOLBAR' colspan='11'><fmt:message key="eMR.DRGCalculation.label" bundle="${mr_labels}"/></TD></TR>
						<TR><TD class="label" colspan="11">&nbsp;</TD>
						</TR>

						<TR>
							<TD class="label" COLSPAN="1"><fmt:message key="eMR.MDC.label" bundle="${mr_labels}"/></TD>	
							<TD colspan="2" class='fields'><INPUT TYPE="text" name="drgMdc" id="drgMdc" ID="drgMdc" VALUE="<%=drgMdc%>" Readonly></TD>
							<TD class="label" COLSPAN="1"><fmt:message key="eMR.DRG.label" bundle="${mr_labels}"/></TD>	
							<TD class='fields' colspan="2"><INPUT TYPE="text" name="drg_drg" id="drg_drg" ID="drg_drg" VALUE="<%=drgVal%>" Readonly title="<%=drgDesc%>">
							<TD class="label" COLSPAN="1"><fmt:message key="eMR.WTLOS.label" bundle="${mr_labels}"/></TD>
							<TD class='fields' colspan="2"><INPUT TYPE="text" name="drg_wtlos" id="drg_wtlos" ID="drg_wtlos" VALUE="<%=drgWtlos%>" Readonly></TD>
							</TD>
						</TR>
						<TR><TD class="label">&nbsp;</TD><TD class="label">&nbsp;</TD><TD class="label">&nbsp;</TD><TD class="label">&nbsp;</TD>
						</TR>
						<TR>
							<TD class="label" COLSPAN="1"><fmt:message key="eMR.RW.label" bundle="${mr_labels}"/></TD>
							<TD class='fields' colspan="2"><INPUT TYPE="text" name="drg_rw" id="drg_rw" ID="drg_rq" VALUE="<%=drgRw%>" Readonly></TD>
							<TD class="label" COLSPAN="1"><fmt:message key="eMR.OT.label" bundle="${mr_labels}"/></TD>
							<TD class='fields' colspan="2"><INPUT TYPE="text" name="drg_ot" id="drg_ot" ID="drg_ot" VALUE="<%=drgOt%>" Readonly></TD>
							<TD class="label" COLSPAN="1" nowrap><fmt:message key="eMR.AdjRW.label" bundle="${mr_labels}"/></TD>
							<TD class='fields' colspan="2"><INPUT TYPE="text" name="drg_adrrw" id="drg_adrrw" ID="drg_adrrw" VALUE="<%=drgAdjrw%>" Readonly></TD>
						</TR>
						<TR><TD class="label">&nbsp;</TD><TD class="label">&nbsp;</TD><TD class="label">&nbsp;</TD><TD class="label">&nbsp;</TD>
						</TR>

						<TR>
							<TD class="label" COLSPAN="1"><fmt:message key="eMR.WARN.label" bundle="${mr_labels}"/></TD>
							<TD class='fields' colspan="2"><textarea NAME="drgwarn_desc"  Readonly cols="30" rows="3"><%=drgWarn%></textarea></TD>
							<TD class="label" COLSPAN="1"><fmt:message key="Common.Error.label" bundle="${common_labels}"/></TD>
							<TD class='fields' colspan="2"><textarea NAME="drg_error_desc"  Readonly cols="30" rows="3"><%=drgError%></textarea></td>
							<input type='hidden' name="warn" id="warn" value="<%=drg_warn_code%>">
							<input type='hidden' name="drg_error" id="drg_error" value="<%=drg_err_code%>">
							<TD class="label" COLSPAN="1"><fmt:message key="Common.Result.label" bundle="${common_labels}"/></TD>
							<TD class='fields' colspan="5"><textarea NAME="drg_result_msg"  Readonly cols="20" rows="3"><%=result_msg%></textarea></td>
							<input type='hidden' name="drg_result_code" id="drg_result_code" value="<%=drgResult%>">
						</TR>
						<TR>
							<td COLSPAN="11" align=right><input type='button' width='5%' name='Save' id='Save' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%>' class='button' onclick='Save_DRG()'></td>
						</TR>

						</TABLE>
						<!--
						</DIV>
						-->
						<INPUT TYPE="hidden" name="drgstatus" id="drgstatus" ID="drgstatus" VALUE="<%=drgStatus%>">
						<INPUT TYPE="hidden" name="drgexception" id="drgexception" ID="drgexception" VALUE="<%=drgException%>">

						<%

						if(DRGcal.equals("N")){
							//doOnlineReports(facility_id,EncounterId,Pat_id,p_language_id,sStyle);
						}
				} // end error S check
			} // end error E check
		}// end of idle time check
	}// end of previous req not processed
}// end of null check for map

	%>
		<INPUT TYPE="hidden" name="mode" id="mode" ID="mode" VALUE="">
		<INPUT TYPE="hidden" name="rep_EncounterId" id="rep_EncounterId"  VALUE="<%=EncounterId%>">
		<INPUT TYPE="hidden" name="EncounterId" id="EncounterId"  VALUE="<%=EncounterId%>">
		<INPUT TYPE="hidden" name="stage_no" id="stage_no"  VALUE="<%=stage_no%>">
		<INPUT TYPE="hidden" name="Pat_id" id="Pat_id"  VALUE="<%=Pat_id%>">
		<INPUT TYPE="hidden" name="rep_Pat_id" id="rep_Pat_id"  VALUE="<%=Pat_id%>">
		<INPUT TYPE="hidden" name="activity" id="activity"  VALUE="SaveDRG">
		<INPUT TYPE="hidden" name="Patient_Class" id="Patient_Class"  VALUE="IP">
		<INPUT TYPE="hidden" name="rep_language_id" id="rep_language_id"  VALUE="<%=p_language_id%>">
		<INPUT TYPE="hidden" name="rep_facility_id" id="rep_facility_id"  VALUE="<%=facility_id%>">
		<INPUT TYPE="hidden" name="rep_sStyle" id="rep_sStyle"  VALUE="<%=sStyle%>">
		<input type='hidden' name='hdr_modified_dt' id='hdr_modified_dt' value='<%=hdr_modified_dt%>'>


		<script>
			parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";
			open_Print('<%=DRGcal%>','<%=success%>');
		</script>

		</FORM>
		</BODY>

	<%
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}finally{
		if(con!=null){
			ConnectionManager.returnConnection(con,request);
		}
 }
%>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


%>

