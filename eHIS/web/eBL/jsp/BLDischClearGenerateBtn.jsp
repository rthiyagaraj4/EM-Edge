<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<head>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eBL/js/BLDischClear.js"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			
			String facility_id = (String)session.getAttribute("facility_id");
			String patientId = "", episodeId = "", discAdviceAtTo = "";
			String episodeType = "", admissionDt = "", docNumber = "", docType = "", patOutsAmt = "" , encounterId = "" , curAcctSeqNo = "", curWardCode="", curBedClassCode = "", curRoomNum = "", curBedNum = "", curPhysicianId = "", reasonCode = "", userId = "", 
			authRemarks = "", discClearanceDocTypeCode = "";
			
%>

<body onKeyDown="lockKey()" onMouseDown="CodeArrest()" >
<form name='BLDischClearGenerateBtn' id='BLDischClearGenerateBtn'  >

<table cellpadding='3' cellspacing='0'  width="100%">
<tr>
	<td width="25%"  class='labels'></td>
	<td width="25%"  class='labels'></td>
	<td width="25%"  class='labels'></td>
		
	<td class='fields'>
		<input type='button' name="gen_disch_clear_btn" id="gen_disch_clear_btn" id="gen_disch_clear_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GEN_DISC_CLEARANCE.label","bl_labels")%>" class='button' onclick='gen_disch_clearance()' >
	</td>
	
</tr>
</table>
		<input type="hidden" name="episodeType" id="episodeType" id="episodeType" value="<%=episodeType%>"/>
		<input type="hidden" name="patientId" id="patientId" id="patientId" value="<%=patientId%>"/>
		<input type="hidden" name="episodeId" id="episodeId"  id="episodeId" value="<%=episodeId%>"/>
		<input type="hidden" name="encounterId" id="encounterId" id="encounterId" value="<%=encounterId%>"/>
		<input type="hidden" name="acctSeqNo" id="acctSeqNo" id="acctSeqNo" value="<%=curAcctSeqNo%>"/>
		<input type="hidden" name="admissionDt" id="admissionDt"  id="admissionDt" value="<%=admissionDt%>"/>
		<input type="hidden" name="curWardCode" id="curWardCode" id="curWardCode" value="<%=curWardCode%>"/>
		<input type="hidden" name="curBedClassCode" id="curBedClassCode" id="curBedClassCode" value="<%=curBedClassCode%>"/>
		<input type="hidden" name="curRoomNum" id="curRoomNum" id="curRoomNum" value="<%=curRoomNum%>"/>
		<input type="hidden" name="curBedNum" id="curBedNum" id="curBedNum" value="<%=curBedNum%>"/>
		<input type="hidden" name="curPhysicianId" id="curPhysicianId" id="curPhysicianId" value="<%=curPhysicianId%>"/>
		<input type="hidden" name="docType" id="docType" id="docType" value="<%=docType%>"/>
		<input type="hidden" name="docNumber" id="docNumber" id="docNumber" value="<%=docNumber%>"/>
		<input type="hidden" name="discAdviceAtTo" id="discAdviceAtTo" id="discAdviceAtTo" value="<%=discAdviceAtTo%>"/>
		<input type="hidden" name="patOutsAmt" id="patOutsAmt" id="patOutsAmt" value="<%=patOutsAmt%>"/>
		<input type="hidden" name="reasonCode" id="reasonCode" id="reasonCode" value="<%=reasonCode%>"/>
		<input type="hidden" name="userId" id="userId" id="userId" value="<%=userId%>"/>
		<input type="hidden" name="authRemarks" id="authRemarks" id="authRemarks" value="<%=authRemarks%>"/>
		
		
</form>
</body>  
</html>

