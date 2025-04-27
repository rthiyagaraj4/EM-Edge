<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<head>
<title>Indicator Entry </title>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
function checkMaxLimit(obj,maxSize)	{
		var len  = obj.value;
	   	if ( len.length > maxSize ){	  
		  	alert("APP-OT0016 Value Should be within the specified limit of "+maxSize+" characters" );
	        event.returnValue = false; obj.focus();
   		}	
}	
</SCRIPT>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- The files  QAAnalyzePartialIndicators.js and QADirRecordOfClinIndicators.js should not 
be included in a single jsp -->

<%
String callfun = request.getParameter("Analyzepart")==null?"": request.getParameter("Analyzepart");
	if(callfun.equals("yes")){
	%>
 <script src='../../eQA/js/QAAnalyzePartialIndicators.js' language='javascript'></script>
 <%}else{%>
<script src="../../eQA/js/QADirRecordOfClinIndicators.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}%>

</head>
<%
	String strClinicalIndicatorId = request.getParameter("QIND_CLIND_ID");
//	String QIND_CLIND_Desc = request.getParameter("QIND_CLIND_DESC");
							
	String strInclProcCode = request.getParameter("INCL_PROC_CODE");
	String strInclDiagCode = request.getParameter("INCL_DIAG_CODE");
	String strInclYN = "N";
	String strYesChecked = "checked";
	String strNoChecked = "checked";
	String strRefNote = "null";
    String COMPL_DESCRIPTION="";
	String COMPL_CODE="";
	String strCloseButton = "disabled=true";
	String strFacilityId = request.getParameter("FACILITY_ID");
	String strUserSystem = request.getParameter("SYS_USER_CREATED");
	String strClindAnalysisStatus = request.getParameter("CLIND_ANALYSIS_STATUS");
	String strEncounterId = request.getParameter("ENCOUNTER_ID");
	String rowVal = request.getParameter("rowVal");
	if ( (strUserSystem.equalsIgnoreCase("S") && !(strClindAnalysisStatus.equalsIgnoreCase("5")))
		||(strClindAnalysisStatus.equalsIgnoreCase("A")))
	{
		strCloseButton = "disabled=true";
	}
	else
		strCloseButton = "disabled=false";

	String strComments = "";
	String diag_desc="";
	String proc_desc="";

%>

<!-- <body  OnMouseDown="CodeArrest()" OnLoad="Focusing('pat_ser_grp_code')" > -->
<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()' >
<form name='QA_QIND_ENCOUNTER_CLIND_TRN1' id='QA_QIND_ENCOUNTER_CLIND_TRN1' method="post" target="messageFrame" >
<%

	Connection conn=null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuffer sqlBuff = new StringBuffer();
	StringBuffer sql2Buff = new StringBuffer();
	StringBuffer sql3Buff = new StringBuffer();

    sqlBuff.append("select  REF_NOTE_TEXT REF_NOT   from QA_QIND_CLIND_REF_NOTE ");
	sqlBuff.append("where  SECTION_ID= 50 ");

	sql2Buff.append("select  nvl(INCL_FOR_YES_YN,'N') INCL_FOR_YES_YN,");
	sql2Buff.append("INCL_COMMENTS from QA_QIND_ENCOUNTER_CLIND_TRN ");
	sql2Buff.append(" where  FACILITY_ID =? AND ENCOUNTER_ID=? AND  ");
	sql2Buff.append(" QIND_CLIND_ID=?  ");

	sql3Buff.append("select a.INCL_COMPL_CODE, b.COMPL_DESCRIPTION ");
	sql3Buff.append(" from QA_QIND_ENCOUNTER_CLIND_TRN a,QA_QIND_CLIND_COMPL b");
	sql3Buff.append(" where  a.FACILITY_ID =? AND a.ENCOUNTER_ID=? AND  ");
	sql3Buff.append(" a.QIND_CLIND_ID=? and a.INCL_COMPL_CODE=b.COMPL_CODE(+)");

	String sql_diag = "SELECT  diag_desc from pr_problem a,pr_problem_enc_dtl b where a.patient_id=b.patient_id and a.srl_no=b.srl_no and encounter_id=? and diag_code=?";
	
	String sql_proc = "SELECT  proc_narration from pr_encounter_procedure  where encounter_id=? and proc_code=?";

	try
	{
		conn = ConnectionManager.getConnection(request);
		pstmt=conn.prepareStatement(sqlBuff.toString());
		rs=pstmt.executeQuery();
		if(rs.next())
		{	 
			strRefNote=rs.getString("REF_NOT");

		}	
	
		if ((strRefNote ==null)||(strRefNote =="null")||(strRefNote ==""))
		{
			strRefNote ="Not Defined";
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
		if((sqlBuff != null) && (sqlBuff.length() > 0))
		{
			sqlBuff.delete(0,sqlBuff.length());
		}
	
		pstmt=conn.prepareStatement(sql2Buff.toString());
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strEncounterId);
		pstmt.setString(3,strClinicalIndicatorId);
		rs=pstmt.executeQuery();
		
		if(rs.next())
		{	 
			strComments = rs.getString("INCL_COMMENTS");
			strInclYN = rs.getString("INCL_FOR_YES_YN");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
		
		pstmt=conn.prepareStatement(sql3Buff.toString());
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strEncounterId);
		pstmt.setString(3,strClinicalIndicatorId);
		rs=pstmt.executeQuery();
		if(rs.next())
		{	 
			COMPL_CODE = rs.getString("INCL_COMPL_CODE")==null?"":rs.getString("INCL_COMPL_CODE");
			COMPL_DESCRIPTION = rs.getString("COMPL_DESCRIPTION")==null?"":rs.getString("COMPL_DESCRIPTION");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
		
		if((sql2Buff != null) && (sql2Buff.length() > 0))
		{
			sql2Buff.delete(0,sql2Buff.length());
		}

	 
		pstmt=conn.prepareStatement(sql_diag);
		pstmt.setString(1,strEncounterId);
		pstmt.setString(2,strInclDiagCode);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
		   diag_desc = rs.getString("diag_desc")==null?"":rs.getString("diag_desc");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
	
		pstmt=conn.prepareStatement(sql_proc);
		pstmt.setString(1,strEncounterId);
		pstmt.setString(2,strInclProcCode);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
		   proc_desc = rs.getString("proc_narration")==null?"":rs.getString("proc_narration");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();


	if (strInclYN!= null)
	{
		if (strInclYN.equalsIgnoreCase("Y"))
		{
			strYesChecked = "checked";
			strNoChecked = "";
		}
		else
		{
			strNoChecked = "checked";
			strYesChecked = "";

		}
	}
%>
	<table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
			<td colspan='2'>&nbsp;
			</td>
		</tr>
	<tr>
	<td class="label" align="right" width="20%">Encounter Id
	</td>
	<td class="label" align="left" width="60%">				&nbsp;&nbsp;<B>
	<%=request.getParameter("ENCOUNTER_ID")%></B>
	</td>				
	</tr>
		<tr>
			<td colspan='2'>&nbsp;
			</td>
		</tr>
<tr>
			<td class="label" align="right" width="20%">Reference
			</td>
			<td align="left" width="60%" onClick='funShowNote()'>
				<b class='label' style='cursor:pointer'>&nbsp;&nbsp;<U><%=request.getParameter("QIND_CLIND_ID")%>
			&nbsp;
				<%=request.getParameter("QIND_CLIND_DESC")%></U>
				</b>
			</td>
		</tr>
		<tr>
		<td colspan='2'>&nbsp;
		</td>
		</tr>


	<INPUT TYPE="hidden" name='CLIND_ANALYSIS_STATUS' id='CLIND_ANALYSIS_STATUS'>

<!-- <tr>
				<td class="label" align="right" width="40%"><b>Analysis Status</b></td>
				<td align="left" width="60%">&nbsp;&nbsp;
				<select name='CLIND_ANALYSIS_STATUS' id='CLIND_ANALYSIS_STATUS' disabled>
<%if(strClindAnalysisStatus.equals("9")){%>
				<option value='9' selected>Analyzed&nbsp;</option>
				<option value='5' >Partially Analyzed&nbsp;
				<option value=''>Not Analyzed&nbsp;
<%} else if(strClindAnalysisStatus.equals("5")){%>
	<option value='9' >Analyzed&nbsp;</option>
				<option value='5' selected>Partially Analyzed&nbsp;
				<option value=''>Not Analyzed&nbsp;
<%} else {%>
	<option value='9' >Analyzed&nbsp;</option>
				<option value='5' >Partially Analyzed&nbsp;
				<option value='' selected>Not Analyzed&nbsp;
<%}%>
				</select>
				</td>
			</tr> -->
				<tr>
				<td class="label" align="right" width="20%"><b>Applicability</b></td>
				<td align="left" class="label" width="60%">&nbsp;&nbsp;Yes
				<input type="RADIO" name="INCL_FOR_YES_YN" id="INCL_FOR_YES_YN" value="Y"   <%=strYesChecked%> >&nbsp;&nbsp;	
				No<input type="RADIO" name="INCL_FOR_YES_YN" id="INCL_FOR_YES_YN" value="N"   <%=strNoChecked%> >
				</td>
				</tr>
				<tr>
				<td class="label" align="right" width="20%"><b><i>Inclusion Criteria</i></b></td>
				<td valign='top' class="label" width="60%" valign='top'>&nbsp;
				<%=strRefNote%>		
				
				</td>
				</tr>
				<tr>
				<td colspan='2'>&nbsp;
				</tr>

			<tr>
				<td class="label" align="right" width="20%">Diagnosis</td>
				<td align="left" class="label" width="60%">&nbsp;&nbsp;&nbsp;<textarea rows="2" name="INCL_DIAG_CODE"  cols="10" readonly><%=strInclDiagCode%>  </textarea>
				&nbsp;<textarea rows="2" name="DIAG_DESC"  cols="41" readonly><%=diag_desc%></textarea>
				</td>										
				<!-- 
<input type="text" name="INCL_DIAG_CODE" id="INCL_DIAG_CODE"  VALUE='<%=strInclDiagCode%>'size=5 maxlength=20 readonly>	
				&nbsp;<input type="text" name="DIAG_DESC" id="DIAG_DESC" value='<%=diag_desc%>'   size=60 maxlength=70 readonly>	 -->
				</tr>

				<tr>
				<td class="label" align="right" width="20%">Procedure</td>
				<td align="left" class="label" width="60%">
				&nbsp;&nbsp;
				<textarea rows="2" name="INCL_PROC_CODE"  cols="10" readonly><%=strInclProcCode%>  </textarea>
				&nbsp;<textarea rows="2" name="PROC_DESC"  cols="41" readonly><%=proc_desc%></textarea></td>
				</td>

<!-- <input type="text" name="INCL_PROC_CODE" id="INCL_PROC_CODE"  VALUE='<%=strInclProcCode%>'  size=5 maxlength=5 readonly>	
<input type="text" name="PROC_DESC" id="PROC_DESC" value='<%=proc_desc%>'   size=60 maxlength=100 readonly> 
 -->
				</tr>

				<tr>
				<td class="label" align="right" width="20%">Complication</td>
				<td align="left" class="label" width="60%">
				&nbsp;&nbsp;
				<input type="text" name="INCL_COMPL_CODE" id="INCL_COMPL_CODE"   value='<%=COMPL_CODE%>' size=5 maxlength=5 disabled>&nbsp;	
				<input type="text" name="COMPL_DESCRIPTION" id="COMPL_DESCRIPTION" value="<%=COMPL_DESCRIPTION%>"   size=20 maxlength=20 disabled>
				<input type='button' class='button' value='?' name='COMPL_button' id='COMPL_button' onClick=" funQAComplication(INCL_COMPL_CODE,'<%=strClinicalIndicatorId%>')" >
				</td>
				</tr>

<tr>
				<td class="label" align="right" width="20%">Comments</td>

				<td align="left" class="label" width="60%">
					&nbsp;&nbsp;
				<% 	if(strComments==null)
					strComments="";
					
				%>
			      <textarea rows="6" name="INCL_COMMENTS"  cols="31" onBlur="checkMaxLimit(this,500);"> <%=strComments%></textarea></td>				
				</tr>
				
				<tr>
				<td colspan='2'>&nbsp;
				</tr>
				<tr>
				<td class="label" align="right" width="20%">&nbsp;</td>
				<td align="left" class="label" width="60%">
								&nbsp;&nbsp;
				<input name='close_button' id='close_button' type='button' class='button' value='Apply' onClick='collectData()'>
				&nbsp;&nbsp;
				<input name='cancel_button' id='cancel_button' type='button' class='button' value='Cancel' onClick='funCancel()'>
				</td>
				</tr>
<tr>
<td colspan='2'>&nbsp;
</tr>
	             <tr>
				<td colspan='2'>&nbsp;
				</tr>

<tr>
			<td colspan='2'>&nbsp;
			</td>
		</tr>

</table>
<%
	}
	 catch (Exception sqlExp)
	 {
		out.println(sqlExp+"");
		
	 }
     finally
     {
	    	ConnectionManager.returnConnection(conn,request);
     }
%>
<input type="hidden" name="EPISODE_ID" id="EPISODE_ID" value=''>
<input type="hidden" name="VISIT_ID" id="VISIT_ID" value=''>
<input type="hidden" name="PATIENT_CLASS" id="PATIENT_CLASS" value='<%=request.getParameter("PATIENT_CLASS")%>'>
<input type="hidden" name="ENCOUNTER_ID" id="ENCOUNTER_ID" value='<%=strEncounterId%>'>
<input type="hidden" name="QIND_CLIND_ID" id="QIND_CLIND_ID" value='<%=request.getParameter("QIND_CLIND_ID")%>'>
<input type="hidden" name="QIND_CLIND_DESC" id="QIND_CLIND_DESC" value='<%=request.getParameter("QIND_CLIND_DESC")%>'>
<input type="hidden" name="SYS_USER_CREATED" id="SYS_USER_CREATED" value='<%=request.getParameter("SYS_USER_CREATED")%>'>
<input type="hidden" name="QUERY_STRING" id="QUERY_STRING" value='<%=request.getQueryString()%>'>
<input type="hidden" name="close_property" id="close_property" value='<%=strCloseButton%>'>
<input type="hidden" name="H_CLIND_ANALYSIS_STATUS" id="H_CLIND_ANALYSIS_STATUS" value='<%=strClindAnalysisStatus%>'>
<input type="hidden" name="rowVal" id="rowVal" value='<%=rowVal%>'>


</form>
</center>
<Script></Script>
</body>
</html>

