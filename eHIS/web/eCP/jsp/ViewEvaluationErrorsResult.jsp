<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		//This file is saved on 18/10/2005.
		request.setCharacterEncoding("UTF-8");
		String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
</HEAD>
<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<FORM name="formViewEvaluationErrorsResult" id="formViewEvaluationErrorsResult">
<SCRIPT language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<TABLE border=".1" cellpadding="0" cellspacing="0" width="100%" align="center">
			
<%
	String facilty_id = (String)session.getAttribute("facility_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	Connection connection		=	null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				=	null;
//	String sqlEvalError			=  "SELECT TO_CHAR(A.EVAL_DATETIME,'DD/MM/YYYY HH24:MI') EVAL_DATE,  C.PRACTITIONER_NAME EVAL_BY, A.REMARKS, A.STATUS_REMARKS, TO_CHAR(B.CARE_PLAN_START_DATE,'DD/MM/YYYY HH24:MI') CP_STARTDATE, TO_CHAR(B.CARE_PLAN_TARGET_DATE,'DD/MM/YYYY HH24:MI') CP_ENDDATE,D.PRACTITIONER_NAME CURRENT_CARE_MANAGER_ID,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH24:MI') ERROR_DATE FROM CP_PAT_CARE_PLAN_EVAL A,CP_PAT_CARE_PLAN B,AM_PRACTITIONER C,AM_PRACTITIONER D WHERE B.PATIENT_ID =? AND B.CREATED_FACILITY_ID =? AND A.STATUS = 'E'   AND A.CARE_PLAN_ID = B.CARE_PLAN_ID AND A.MD_CARE_PLAN_ID = B.MD_CARE_PLAN_ID AND A.EVAL_BY = C.PRACTITIONER_ID AND B.CURRENT_CARE_MANAGER_ID = D.PRACTITIONER_ID(+)";
	String sqlEvalError			=  "SELECT TO_CHAR(A.EVAL_DATETIME,'DD/MM/YYYY HH24:MI') EVAL_DATE,  C.PRACTITIONER_NAME EVAL_BY, A.REMARKS, A.STATUS_REMARKS, TO_CHAR(B.CARE_PLAN_START_DATE,'DD/MM/YYYY HH24:MI') CP_STARTDATE, TO_CHAR(B.CARE_PLAN_TARGET_DATE,'DD/MM/YYYY HH24:MI') CP_ENDDATE,D.PRACTITIONER_NAME CURRENT_CARE_MANAGER_ID,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH24:MI') ERROR_DATE FROM CP_PAT_CARE_PLAN_EVAL A,CP_PAT_CARE_PLAN B,AM_PRACTITIONER_LANG_VW C,AM_PRACTITIONER_LANG_VW D WHERE B.PATIENT_ID =? AND B.CREATED_FACILITY_ID =? AND A.STATUS = 'E'   AND A.CARE_PLAN_ID = B.CARE_PLAN_ID AND A.MD_CARE_PLAN_ID = B.MD_CARE_PLAN_ID AND A.EVAL_BY = C.PRACTITIONER_ID AND B.CURRENT_CARE_MANAGER_ID = D.PRACTITIONER_ID(+) AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? order by a.eval_datetime";
	
	String careplan_mngr		=	"";
	String Evalremarks			=	"";
	String classvalue			=	"";
	int  recCount				=	0;
	String startdate			=	"";
	String targetdate			=	"";
	String tempstartdate			=	"";
	String temptargetdate			=	"";
	int flag		= 0;

	try{
		connection	=	ConnectionManager.getConnection(request);
		pstmt = connection.prepareStatement( sqlEvalError);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,facilty_id);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		rs=pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				startdate=rs.getString("cp_startdate");
				String sdate	=	com.ehis.util.DateUtils.convertDate(startdate,"DMYHM","en",locale);
				targetdate=rs.getString("cp_enddate");
				String tdate	=	com.ehis.util.DateUtils.convertDate(targetdate,"DMYHM","en",locale);

				careplan_mngr=rs.getString("current_care_manager_id")==null ? "":rs.getString("current_care_manager_id");
				Evalremarks=rs.getString("remarks")==null ? "":rs.getString("remarks");
				if(!tempstartdate.equals(startdate) && !temptargetdate.equals(targetdate)){ 
					if ( recCount % 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;
					if(flag!=0){
%>
			<TR>
				<TD align="left" class="<%=classvalue%>" colspan=3>&nbsp;</TD>
			</TR>
<%
				}
%>
			<TR>
				<TD align="left" class="<%=classvalue%>" ><font size=1><B><%=sdate%><B></TD>
				<TD align="left" class="<%=classvalue%>"><font size=1><B>&nbsp;&nbsp;<%=tdate%><B></TD>
				<TD align="left" class="<%=classvalue%>"><font size=1><B>&nbsp;&nbsp;&nbsp;<%=careplan_mngr%><B></TD>
			</TR>
<%
	recCount++;
	}else{
%>
		<TR>
				<TD align="left" class="<%=classvalue%>" colspan=3>&nbsp;</TD>
			</TR>		
<%
	
	}
	String evaldate	=	com.ehis.util.DateUtils.convertDate(rs.getString("eval_date"),"DMYHM","en",locale);
	String errordate	=	com.ehis.util.DateUtils.convertDate(rs.getString("ERROR_DATE"),"DMYHM","en",locale);
%>
			
			<TR> 
				<TD  class="<%=classvalue%>" width = "33%"><font size=1><B><fmt:message key="eCP.EvaluationDate.label" bundle="${cp_labels}"/></B></TD>
				<TD align="left" class="<%=classvalue%>" width = "33%"><font size=1><B>&nbsp;&nbsp;<%=evaldate%></B></TD>
				<TD align="left" class="<%=classvalue%>" >&nbsp;</TD>
			</TR>
			<TR> 
				<TD  class="<%=classvalue%>"><font size=1><B><fmt:message key="eCP.EvaluatedBy.label" bundle="${cp_labels}"/></B></TD>
				<TD align="left" class="<%=classvalue%>"><font size=1>&nbsp;&nbsp;<%=rs.getString("eval_by")%></TD>
				<TD align="left" class="<%=classvalue%>">&nbsp;</TD>
			</TR>
			<TR> 
				<TD  class="<%=classvalue%>"><font size=1><B><fmt:message key="eCP.EvaluationRemarks.label" bundle="${cp_labels}"/></B></TD>
				<TD align="left" class="<%=classvalue%>"><font size=1>&nbsp;&nbsp;<%=Evalremarks%></TD>
				<TD align="left" class="<%=classvalue%>">&nbsp;</TD>
			</TR>
			<TR> 
				<TD  class="<%=classvalue%>"><font size=1><B><fmt:message key="eCP.EvaluationErrorDate.label" bundle="${cp_labels}"/></B></TD>
				<TD align="left" class="<%=classvalue%>"><font size=1 color="red">&nbsp;&nbsp;<%=errordate%></TD>
				<TD align="left" class="<%=classvalue%>">&nbsp;</TD>
			</TR>
			<TR> 
				<TD  class="<%=classvalue%>"><font size=1><B><fmt:message key="eCP.EvaluationErrors.label" bundle="${cp_labels}"/></B></TD>
				<TD align="left" class="<%=classvalue%>"><font size=1 color="red">&nbsp;&nbsp;<%=rs.getString("status_remarks")%></TD>
				<TD align="left" class="<%=classvalue%>">&nbsp;</TD>
			</TR>
		
		
<%
			tempstartdate			=	startdate;
			temptargetdate			=	targetdate;
			flag=1;
			}
		}
		if(recCount==0){
%>
			<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</SCRIPT>
<%		}
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

