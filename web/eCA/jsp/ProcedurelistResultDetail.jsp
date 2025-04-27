<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,java.lang.Math.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%

	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs_anCode		=null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String facility_id	= request.getParameter("facility_id");
	String proc_code	= request.getParameter("proc_code");
	String encounter_id = request.getParameter("encounter_id");
	String srl_no = request.getParameter("srl_no");
	//out.println("srl_no"+srl_no);
	if(facility_id == null)	{ 		facility_id	= "";		}
	if(proc_code == null)	{		proc_code	= "";		}
	if(encounter_id == null)	{		encounter_id= "";		}

	
//	String sql = "SELECT  hpi,  proc_summary, findings, impression, disposition FROM pr_encounter_procedure WHERE facility_id = '"+facility_id+"' AND encounter_id =  '"+encounter_id+"' AND proc_code =  '"+proc_code+"'";

	//String sql = "SELECT  (select short_name from am_practitioner where practitioner_id =anaesthetist1) anaesthetist1,(select short_name from am_practitioner where practitioner_id =anaesthetist2) anaesthetist2,(select short_name from am_practitioner where practitioner_id =anaesthetist3) anaesthetist3,anaesthesia_code anaesthesia,specimen_sent,post_proc_std_orders,events,anaesthesia_detail,indication,monitoring,hpi,  proc_summary, findings, impression, disposition,scrub_nurse,anaesthesia_detail	FROM pr_encounter_procedure WHERE facility_id = ? AND encounter_id = ? AND srl_no =  ?";

	//String sql = "SELECT  AM_GET_DESC.AM_PRACTITIONER(anaesthetist1,?,'2') anaesthetist1,AM_GET_DESC.AM_PRACTITIONER(anaesthetist2,?,'2') anaesthetist2,AM_GET_DESC.AM_PRACTITIONER(anaesthetist3,?,'2') anaesthetist3,anaesthesia_code  anaesthesia,specimen_sent,post_proc_std_orders,events,anaesthesia_detail,indication,monitoring,hpi,  proc_summary, findings, impression, disposition,scrub_nurse,anaesthesia_detail	FROM pr_encounter_procedure WHERE facility_id = ? AND encounter_id = ? AND srl_no =  ? ";

	String sql = "SELECT proc_code_scheme, record_type, cause_indicator, proc_code, practitioner_id, proc_date, modified_by_id, (select SHORT_DESC from mr_term_code where TERM_CODE = rtrim(a.proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME) PROC_NARRATION, TO_CHAR(START_DATETIME,'DD/MM/YYYY HH24:MI')  START_DATETIME, TO_CHAR(END_DATETIME,'DD/MM/YYYY HH24:MI') END_DATETIME, end_datetime-start_datetime oper_durn_days,AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(ASS_PRACTITIONER1,?,'2')  ASS_PRACTITIONER1, AM_GET_DESC.AM_PRACTITIONER(ASS_PRACTITIONER2,?,'2') ASS_PRACTITIONER2, AM_GET_DESC.AM_PRACTITIONER(ASS_PRACTITIONER3,?,'2') ASS_PRACTITIONER3, AM_GET_DESC.AM_PRACTITIONER(anaesthetist1,?,'1') anaesthetist1, AM_GET_DESC.AM_PRACTITIONER(anaesthetist2,?,'1') anaesthetist2, AM_GET_DESC.AM_PRACTITIONER(anaesthetist3,?,'1') anaesthetist3, anaesthesia_code anaesthesia, specimen_sent, post_proc_std_orders, EVENTS, anaesthesia_detail, indication, MONITORING, hpi, proc_summary, findings, impression, disposition, AM_GET_DESC.AM_PRACTITIONER(scrub_nurse,?,'2') scrub_nurse, proc_perf_locn_code, OP_GET_DESC.OP_CLINIC(?,proc_perf_locn_code,?,'2') locn_desc, laterality_ind FROM  pr_encounter_procedure a WHERE facility_id = ? AND encounter_id = ? AND srl_no = ? ORDER BY proc_date DESC " ;


	try{
		con				= ConnectionManager.getConnection(request);
		rs				= null;
		pstmt			= null;

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,locale);
		pstmt.setString(7,locale);
		pstmt.setString(8,locale);
		pstmt.setString(9,facility_id);
		pstmt.setString(10,locale);
		pstmt.setString(11,facility_id);
		pstmt.setString(12,encounter_id);
		pstmt.setString(13,srl_no);

		rs=pstmt.executeQuery();
		String proc_code_scheme		=	"";
		//String record_type		=	"";
		//String cause_indicator		=	"";
		//String Description		=	"";
		String proc_code1		=	"";
		String PROC_NARRATION		=	"";
		String START_DATETIME		=	"";
		String END_DATETIME		=	"";
		String oper_durn_days		=	"";
		String practitioner_name		=	"";
		String ASS_PRACTITIONER1		=	"";
		String ASS_PRACTITIONER2		=	"";
		String ASS_PRACTITIONER3		=	"";

		String hpi			=	"";
		String proc_summary	=	"";
		String findings		=	"";
		String impression	=	"";
		String disposition	=	"";
		String indication	=	"";
		String monitoring	=	"";
		String anaesthesia_detail ="";
		String events		= "";
		String post_proc_std_orders ="";
		String specimen_sent ="";
		String anaesthetist1="",anaesthetist2="",anaesthetist3="";
		String scrub_nurse="";
		String anaesthesia ="",anaesthesia_desc="";
		String laterality_ind = "";
		String locn_desc = "";
		
			double oper_durn_days1 = 0;
			int oper_durn_hrs =0;
			long oper_durn_mts =0;
%>
		<table class='grid'  border=1 width='100%' align=center>
<%

		while(rs.next()){
			
			proc_code_scheme				= rs.getString("proc_code_scheme");
			//hpi				= rs.getString("hpi");
			//hpi				= rs.getString("hpi");
			proc_code1				= rs.getString("proc_code");
			PROC_NARRATION				= rs.getString("PROC_NARRATION");
			START_DATETIME				= rs.getString("START_DATETIME");
			END_DATETIME				= rs.getString("END_DATETIME")==null?"&nbsp;":rs.getString("END_DATETIME");
			oper_durn_days				= rs.getString("oper_durn_days")==null?"0":rs.getString("oper_durn_days");
			practitioner_name				= rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
			ASS_PRACTITIONER1				= rs.getString("ASS_PRACTITIONER1") ==null?"&nbsp;":rs.getString("ASS_PRACTITIONER1");
			ASS_PRACTITIONER2				= rs.getString("ASS_PRACTITIONER2")==null?"&nbsp;":rs.getString("ASS_PRACTITIONER2");
			ASS_PRACTITIONER3				= rs.getString("ASS_PRACTITIONER3")==null?"&nbsp;":rs.getString("ASS_PRACTITIONER3");
			
			hpi				= rs.getString("hpi");
			proc_summary	= rs.getString("proc_summary");
			findings		= rs.getString("findings");
			impression		= rs.getString("impression");
			disposition		= rs.getString("disposition");
			
			
			indication		= rs.getString("indication")==null?"&nbsp;":rs.getString("indication");
			monitoring		= rs.getString("monitoring")==null?"&nbsp;":rs.getString("monitoring");
			anaesthesia_detail= rs.getString("anaesthesia_detail")==null?"&nbsp;":rs.getString("anaesthesia_detail");
			events			= rs.getString("events")==null?"&nbsp;":rs.getString("events");
			post_proc_std_orders			= rs.getString("post_proc_std_orders")==null?"&nbsp;":rs.getString("post_proc_std_orders");
			specimen_sent			= rs.getString("specimen_sent")==null?"&nbsp;":rs.getString("specimen_sent");
			anaesthetist1			= rs.getString("anaesthetist1")==null?"&nbsp;":rs.getString("anaesthetist1");
			anaesthetist2			= rs.getString("anaesthetist2")==null?"&nbsp;":rs.getString("anaesthetist2");
			anaesthetist3			= rs.getString("anaesthetist3")==null?"&nbsp;":rs.getString("anaesthetist3");
			scrub_nurse			= rs.getString("scrub_nurse")==null?"&nbsp;":rs.getString("scrub_nurse");
			anaesthesia			= rs.getString("anaesthesia")==null?"&nbsp;":rs.getString("anaesthesia");
			locn_desc			= rs.getString("locn_desc")==null?"&nbsp;":rs.getString("locn_desc");
			laterality_ind			= rs.getString("laterality_ind")==null?"":rs.getString("laterality_ind");

			START_DATETIME			=	com.ehis.util.DateUtils.convertDate(START_DATETIME,"DMYHM","en",locale);
			if(!END_DATETIME.equals("&nbsp;"))
			END_DATETIME			=	com.ehis.util.DateUtils.convertDate(END_DATETIME,"DMYHM","en",locale);
			
		
			//String anCode = " Select SHORT_DESC from AM_ANAESTHESIA where ANAESTHESIA_CODE = '"+anaesthesia+"'";	

			String anCode = "Select LONG_DESC from AM_ANAESTHESIA_LANG_VW where ANAESTHESIA_CODE = '"+anaesthesia+"' and LANGUAGE_ID = '"+locale+"'";

			stmt = con.createStatement();
			rs_anCode = stmt.executeQuery(anCode);
			while(rs_anCode.next())
			{
				anaesthesia_desc=rs_anCode.getString("LONG_DESC")==null?"&nbsp;":rs_anCode.getString("LONG_DESC");
			}

        if(rs_anCode!=null) 	rs_anCode.close();
		if(stmt!=null) 	stmt.close();
		
			if(hpi == null)			{ 		hpi	= "&nbsp;";				}
			if(proc_summary == null){ 		proc_summary	= "&nbsp;";	}
			if(findings == null)	{ 		findings	= "&nbsp;";		}
			if(impression == null)	{ 		impression	= "&nbsp;";		}
			if(disposition == null)	{ 		disposition	= "&nbsp;";		}
			 oper_durn_days1 = Double.parseDouble(oper_durn_days); 
			 oper_durn_hrs =0;
			 oper_durn_mts =0;
			if (oper_durn_days1 > 0){
				
					oper_durn_hrs = (int)Math.floor(oper_durn_days1*24);
					//oper_durn_mts = Math.round((oper_durn_hrs-Math.ceil(oper_durn_hrs))*60);
					oper_durn_mts = Math.round((oper_durn_days1*24-Math.floor(oper_durn_hrs))*60);
			}
			if(laterality_ind.equals("L"))
				laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
			else if(laterality_ind.equals("R"))
				laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Right.label","ca_labels");
			else if(laterality_ind.equals("B"))
				laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
			else if(laterality_ind.equals("N"))
				laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
			else
				laterality_ind = "&nbsp;";
			
				
%>
		<!--new -->
		<tr><td class='gridData' align='right'><b><fmt:message key="eCA.ProcedureSet.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'><font size='1'><%=proc_code_scheme%></font></td></tr>

		<tr><td class='gridData' align='right'><b><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'><font size='1'><%=proc_code1%></font></td></tr>

		<tr><td class='gridData' align='right'><b><fmt:message key="Common.description.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'><font size='1'><%=PROC_NARRATION%></font></td></tr>
		<tr><td class='gridData' align='right'><b><fmt:message key="eCA.Laterality.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'><font size='1'><%=laterality_ind%></font></td></tr>
		<tr><td class='gridData' align='right'><b><fmt:message key="eCA.StartingTime.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=START_DATETIME%></font></td></tr>

		<tr><td class='gridData'   align='right'><b><fmt:message key="eCA.EndingTime.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=END_DATETIME%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.duration.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=oper_durn_hrs%>&nbsp;Hrs.&nbsp;<%=oper_durn_mts%>&nbsp;Mins.</font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=locn_desc%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=practitioner_name%>,<%=ASS_PRACTITIONER2%>,<%=ASS_PRACTITIONER3%></font></td></tr>

		<!--ends -->
		
		<tr><td class='gridData'   align='right'><b><fmt:message key="eCA.Anaesthetists.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=anaesthetist1%>,<%=anaesthetist2%>,<%=anaesthetist3%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.ScrubNurse.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=scrub_nurse%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=anaesthesia_desc%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.AnaesthesiaDetails.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=anaesthesia_detail%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="eCA.Indication.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=indication%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.Monitoring.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=monitoring%></font></td></tr>
		<tr><td width='25%' class='gridData'   align='right'><b><fmt:message key="eCA.HPI.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=hpi%>	</td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="eCA.ProcedureSummary.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=proc_summary%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.Findings.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=findings%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="eCA.Impression.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=impression%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=disposition%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="Common.Events.label" bundle="${common_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=events%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="eCA.PostProcedureStdOrders.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=post_proc_std_orders%></font></td></tr>
		<tr><td class='gridData'   align='right'><b><fmt:message key="eCA.SpecimenSent.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class='gridData'  ><font size='1'><%=specimen_sent%></font></td></tr>
<%
		}
%>
		</table>
<%
	
		

}catch(Exception e){
		//out.print("ERROR"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}finally{
		
		if(rs!=null)	rs.close();
		if(pstmt!=null) 	pstmt.close();
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

