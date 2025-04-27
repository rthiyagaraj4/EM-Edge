<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eBL/js/BLRecordPaymentConsent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	<FORM name="search" id="search" id="search" >
	

<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String patient_name = checkForNull(request.getParameter("patient_name"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	System.err.println("Encounter id is: "+encounter_id);
	System.err.println("Encounter id is: "+episode_type);
	String enc_from_date = checkForNull(request.getParameter("enc_from_date"));
	String enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String patientId = "", patientName = "", episodeId = "", episodeType = "", consentAmt = "", consentDate = "", relName = "", relNationality = "", relCivilId = "", relTelNum = "", pat_rel_esign = "", signed_YN = "", signedYN = "", pmntUser = "", esign ="", episode_type_val = "";
	String sql="";
	String totalDisabled = "";
	int rowCount = 0;
	boolean amountRoundOff = true;
	int noofdecimal=2;
	CurrencyFormat cf1 = new CurrencyFormat();	
		

	try
	{
		con =  ConnectionManager.getConnection(request);
		
		pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
		rs = pstmt.executeQuery();	
		if ( rs != null && rs.next()) {
			if(rs.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
				amountRoundOff = false;
			}
		}

		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rs = pstmt.executeQuery();	
		while(rs.next())
		{
			noofdecimal  =  rs.getInt(1);		
		}
			
		
		
		sql = "select A.OPERATING_facility_id,DECODE(A.EPISODE_TYPE,'I','Inpatient','O','Outpatient','D','Daycare','E','Emergency') "+ 
		"EPISODE_TYPE, A.EPISODE_TYPE EPISODE_TYPE_VAL, A.PATIENT_ID PATIENT_ID,A.encounter_id EPISODE_ID, "+
		"nvl(B.CONSENT_AMT,NVL(A.TOT_OUTST_AMT,0))CONSENT_AMT,to_char(B.CONSENT_DATE ,'dd/mm/yyyy') CONSENT_DATE,B.SIGNED_YN "+
		"SIGNED_YN,(select short_name  FROM MP_PATIENT_MAST  WHERE PATIENT_ID=NVL( ? ,A.PATIENT_ID)) "+
		"PATIENT_NAME,B.PMNT_USER PMNT_USER from "+ "BL_PAT_ENC_UNBLD_OUTST_VW  A ,BL_PAT_PMNT_CONSENT B "+
		"where A.PATIENT_ID=B.PATIENT_ID(+) AND A.OPERATING_facility_id= B.operating_facility_id(+)  and "+
		"A.episode_type = B.episode_type(+)  and A.encounter_id =B.episode_id(+) AND A.OPERATING_facility_id= ?  "+
		"AND A.PATIENT_ID=NVL( ? ,A.PATIENT_ID)  AND "+ "A.encounter_id=NVL( ? ,A.encounter_id) AND "+
		"A.EPISODE_TYPE=NVL( ? ,A.EPISODE_TYPE) AND (ADMISSION_DATE_TIME between "+
		"NVL((to_date(?,'DD-MM-YYYY')),TO_DATE('01-JAN-1000 00:00:00'  ,'DD-MON-YYYY HH24:MI:SS')) "+
		"AND NVL((to_date(?,'DD-MM-YYYY')), "+
		"TO_DATE('01-DEC-4100 00:00:00'  ,'DD-MON-YYYY HH24:MI:SS'))  ) AND ((select DISCHARGE_DATE_TIME from "+
		"pr_encounter where patient_id = NVL(?, A.PATIENT_ID) and ENCOUNTER_ID = NVL( ? , A.encounter_id) ) "+
		"IS NULL OR B.SIGNED_YN is NOT NULL)"; 
		System.err.println("sql:"+sql);
		
		pstmt = con.prepareStatement(sql);	
		
		pstmt.setString(1,patient_id);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,encounter_id);
		pstmt.setString(5,episode_type);
		pstmt.setString(6,enc_from_date);
		pstmt.setString(7,enc_to_date);
		pstmt.setString(8,patient_id);
		pstmt.setString(9,encounter_id);
		
		rs = pstmt.executeQuery();
		if(rs != null)
		{
			while(rs.next()){
				rowCount++;
				totalDisabled = "";
				patientId = checkForNull(rs.getString("PATIENT_ID"));
				episodeType = checkForNull(rs.getString("EPISODE_TYPE"));
				episode_type_val = checkForNull(rs.getString("EPISODE_TYPE_VAL"));
				episodeId = checkForNull(rs.getString("EPISODE_ID"));
				patientName = checkForNull(rs.getString("PATIENT_NAME"));
				consentAmt = checkForNull(rs.getString("CONSENT_AMT"));
				if(amountRoundOff) {
					consentAmt = cf1.formatCurrency(consentAmt, noofdecimal);
				} else {
					consentAmt = BLReportIdMapper.truncateUptoTwoDecimal(consentAmt, noofdecimal);	
				}
				consentDate = checkForNull(rs.getString("CONSENT_DATE"));
				signedYN = checkForNull(rs.getString("SIGNED_YN"));
				pmntUser = checkForNull(rs.getString("PMNT_USER"));
				if(pmntUser.equals("")) pmntUser = "P";
				
				System.out.println("sql:"+patientId);
				System.out.println("sql:"+episodeType);
				System.out.println("sql:"+episodeId);
				System.out.println("sql:"+patientName);
				System.out.println("sql:"+consentAmt);
				System.out.println("sql:"+consentDate);
				System.out.println("sql:"+signedYN);
				System.out.println("sql:"+pmntUser);
				
				if(rowCount==1){
%>
<TABLE width="100%" border =1 CELLSPACING=0 cellpadding=4 align='center'>
		<tr>
			<td  class="columnheader"><%= request.getParameter("title")%></td>
		</tr>	
	</TABLE>
	<TABLE width="100%" border=1 class='grid' >
		<tr>
			<td class='columnheader' nowrap><fmt:message key="Common.SlNo.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' nowrap><fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/></td>
			<td class='columnheadercenter' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' nowrap><fmt:message key="eBL.ConsentAmount.label" bundle="${bl_labels}"/><span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span></td>
			<td class='columnheadercenter' nowrap><fmt:message key="eBL.ConsentDate.label" bundle="${bl_labels}"/><span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span></td>
			<td class='columnheadercenter' nowrap><fmt:message key="eBL.ESignature.label" bundle="${bl_labels}"/></td>
			<td class='columnheadercenter' nowrap><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/></td>
		</tr>	
		<%
				}
		%>
		
	<tr>
			<td class="fields"><%=rowCount%></td>
			<td class="fields"><%=patientId%></td>
			<td class="fields"><%=patientName%></td>
			<td class="fields"><%=episodeType%></td>
			<td class="fields"><%=episodeId%></td>

			<%if(signedYN.equals("Y"))
				totalDisabled = "disabled";
			%>

			<td class="fields" >
				<input type="text" name="consentAmt_<%=rowCount%>" id="consentAmt_<%=rowCount%>" maxlength="15" value="<%=consentAmt%>" <%=totalDisabled%> onblur="checkForNumberDecimal(this,'<%=rowCount%>')">
			</td>
			
			<td class="fields">
				<input type="text" name="consentDate_<%=rowCount%>" id="consentDate_<%=rowCount%>" maxlength="10" onblur="validateConsentDate(this,consentDate_<%=rowCount%>,'<%=rowCount%>');" value="<%=consentDate%>" <%=totalDisabled%>>
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('consentDate_<%=rowCount%>');"  onKeyPress="return lockbackSpace();" <%=totalDisabled%>>
			</td>
			
			<td class="fields">
			    <select id="consent_<%=rowCount%>" name="consent_<%=rowCount%>" onchange="fnclear('<%=rowCount%>');" <%=totalDisabled%>>
					<option value="P" <%="P".equals(pmntUser) ? "selected" : "" %>><fmt:message key="eBL.Patient.label" bundle="${common_labels}" /></option>
					<option value="R" <%="R".equals(pmntUser) ? "selected" : "" %>><fmt:message key="eBL.Relative.label"bundle="${common_labels}" /></option>
					
					
				</select>
				<input type="checkbox" name="consent_flag_<%=rowCount%>" id="consent_flag_<%=rowCount%>" onClick="callESign('<%=rowCount%>');" <%=totalDisabled%>
				 <%=signedYN.equals("Y")?"checked ":""%> 
				/>
				
				
			</td>
			
			<td class="fields"><input type="button" name="consent_flag" id="consent_flag" id="consent_flag" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.view_print_save.label","bl_labels")%>" onClick="saveConsentForm('<%=rowCount%>');"></td>
			
		<input type="hidden" name="episodeType_<%=rowCount%>" id="episodeType_<%=rowCount%>" value="<%=episode_type_val%>"/>
		<input type="hidden" name="patientId_<%=rowCount%>" id="patientId_<%=rowCount%>" value="<%=patientId%>"/>
		<input type="hidden" name="episodeId_<%=rowCount%>"  id="episodeId_<%=rowCount%>" value="<%=episodeId%>"/>
		<input type="hidden" name="signedYN_<%=rowCount%>"  id="signedYN_<%=rowCount%>" value="<%=signedYN%>"/>
		<input type="hidden" name="pmntUser_<%=rowCount%>"  id="pmntUser_<%=rowCount%>" value="<%=pmntUser%>"/>  
			

<%
			}
		}if(rowCount==0){
			System.err.println("In else:");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
	}
	catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally 
	{
	}		
%>
	</table>	
		<input type="hidden" name="episodeType" id="episodeType" id="episodeType" value="<%=episodeType%>"/>
		<input type="hidden" name="patient_Id" id="patient_Id" id="patient_Id" value="<%=patientId%>"/>
		<input type="hidden" name="episodeId" id="episodeId"  id="episodeId" value="<%=episodeId%>"/>
		<input type="hidden" name="consentAmt" id="consentAmt" id="consentAmt" value="<%=consentAmt%>"/>
		<input type="hidden" name="consentDate" id="consentDate"  id="consentDate" value="<%=consentDate%>"/>
		<input type="hidden" name="relName" id="relName" id="relName" value="<%=relName%>"/>
		<input type="hidden" name="relNationality" id="relNationality" id="relNationality" value="<%=relNationality%>"/>
		<input type="hidden" name="relCivilId" id="relCivilId" id="relCivilId" value="<%=relCivilId%>"/>
		<input type="hidden" name="relTelNum" id="relTelNum" id="relTelNum" value="<%=relTelNum%>"/>
		<input type="hidden" name="pmntUser" id="pmntUser" id="pmntUser" value="<%=pat_rel_esign%>"/>
		<input type="hidden" name="signed_YN" id="signed_YN" id="signed_YN" value="<%=signedYN%>"/>
		<input type="hidden" name="esign" id="esign" id="esign" value="<%=esign%>"/>
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facility_id%>"/>
		<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	</form>
</body>
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



