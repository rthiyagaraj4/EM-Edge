<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
    <link rel='StyleSheet' href='../../eCommon/html/<%= session.getAttribute("PREFERRED_STYLE") != null ? session.getAttribute("PREFERRED_STYLE").toString() : "IeStyle.css" %>' type='text/css'>
    <SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
    <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</HEAD>

<BODY onkeydown='lockKey()' onmousedown='CodeArrest()' style="scrollbar-base-color:#E2E3F0; scrollbar-arrow-color:#000080; scrollbar-darkshadow-color:#E2E3F0; scrollbar-face-color:#E2E3F0; scrollbar-highlight-color:white; scrollbar-shadow-color:#E2E3F0; scrollbar-3dlight-color:#E2E3F0;">
    <SCRIPT language="javascript">
        document.body.style.scrollbarBaseColor = '#E2E3F0';
        document.body.style.scrollbarArrowColor = '#000080';
        document.body.style.scrollbarDarkShadowColor = '#E2E3F0';
        document.body.style.scrollbarFaceColor = '#E2E3F0';
        document.body.style.scrollbarHighlightColor = 'white';
        document.body.style.scrollbarShadowColor = '#E2E3F0';
        document.body.style.scrollbar3dlightColor = '#E2E3F0';
    </SCRIPT>

    <FORM name="formViewVariancesResult" id="formViewVariancesResult">
        <TABLE cellSpacing="0" cellPadding="0" width="100%" align="center" border="0">
            <%
                String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
                Connection connection = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                String locale = (String) session.getAttribute("LOCALE");
                String sqlEvalError = "SELECT CP_PLN.PATIENT_ID, TO_CHAR(CP_VAR.VARIANCE_LOG_DATE,'DD/MM/YYYY HH24:MI') VARIANCE_DATE, CP_OUT.SHORT_DESC OUTCOME_DESC, CP_CAUSE.VAR_CAUSE_DESC, CP_REASON.VAR_REASON_DESC, CP_VAR_DTL.VARIANCE_REMARKS, CP_VAR_DTL.ACTION_PLAN FROM CP_PAT_CARE_PLAN CP_PLN, CP_PAT_CARE_PLAN_VAR CP_VAR, CP_PAT_CARE_PLAN_VAR_DTL CP_VAR_DTL, CP_OUTCOME_LANG_VW CP_OUT, CP_VARIANCE_CAUSE_LANG_VW CP_CAUSE, CP_VARIANCE_REASON_LANG_VW CP_REASON WHERE PATIENT_ID = ? AND CP_PLN.MD_CARE_PLAN_ID = CP_VAR.MD_CARE_PLAN_ID AND CP_PLN.CARE_PLAN_ID = CP_VAR.CARE_PLAN_ID AND CP_VAR.MD_CARE_PLAN_ID = CP_VAR_DTL.MD_CARE_PLAN_ID AND CP_VAR.CARE_PLAN_ID = CP_VAR_DTL.CARE_PLAN_ID AND CP_VAR.VARIANCE_LOG_ID = CP_VAR_DTL.VARIANCE_LOG_ID AND CP_VAR_DTL.VAR_OUTCOME_CODE = CP_OUT.OUTCOME_CODE(+) AND CP_VAR_DTL.VAR_CAUSE_CODE = CP_CAUSE.VAR_CAUSE_CODE AND CP_VAR_DTL.VAR_REASON_CODE = CP_REASON.VAR_REASON_CODE AND CP_OUT.LANGUAGE_ID(+) = ? AND CP_CAUSE.LANGUAGE_ID = ? AND CP_REASON.LANGUAGE_ID = ? ORDER BY CP_VAR.VARIANCE_LOG_DATE DESC";
                
                String outcome = "";
                String remarks = "";
                String actionplan = "";
                int recCount = 0;
                String classvalue = "";

	
	try{
		connection	=	ConnectionManager.getConnection(request);
		pstmt = connection.prepareStatement( sqlEvalError);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		rs=pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				outcome=rs.getString("OUTCOME_DESC")==null ? "&nbsp;":rs.getString("OUTCOME_DESC");
				remarks=rs.getString("VARIANCE_REMARKS")==null ? "":rs.getString("VARIANCE_REMARKS");
				actionplan=rs.getString("ACTION_PLAN")==null ? "":rs.getString("ACTION_PLAN");

				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				String date	=	com.ehis.util.DateUtils.convertDate(rs.getString("VARIANCE_DATE"),"DMYHM","en",locale);
%>
		<TR>
			<TD align="left" width="25%" class="<%=classvalue%>"><font size=1><B>&nbsp;<%=date%></B></TD>
			<TD align="left" width="25%" class="<%=classvalue%>"><font size=1><%=outcome%></TD>
			<TD align="left" width="25%" class="<%=classvalue%>"><font size=1 color="red"><%=rs.getString("VAR_CAUSE_DESC")%></TD>
			<TD align="left" width="25%" class="<%=classvalue%>"><font size=1 color="red"><%=rs.getString("VAR_REASON_DESC")%></TD>
		</TR>
		<TR>
			<TD align="right" class="<%=classvalue%>"><font size=1><B><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></B>&nbsp;</TD>
			<TD align="left"  class="<%=classvalue%>" colspan=3><font size=1>&nbsp;<%=remarks%></TD>
		</TR>
		<TR>
			<TD align="right" class="<%=classvalue%>"><font size=1><B><fmt:message key="eCP.ActionPlan.label" bundle="${cp_labels}"/></B>&nbsp;</TD>
			<TD align="left"  class="<%=classvalue%>" colspan=3><font size=1>&nbsp;<%=actionplan%></TD>
		</TR>

<%
		recCount++;
			}
		}
		
	}catch(Exception e){
		System.err.println(e.toString());
		e.printStackTrace();
}finally{
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();
	ConnectionManager.returnConnection(connection,request);
}
%>
		</TABLE>
	</FORM>
</BODY>
</HTML>
