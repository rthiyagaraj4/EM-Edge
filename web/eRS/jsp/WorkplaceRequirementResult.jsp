<!DOCTYPE html>
<!-- /**
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	20 October 2004.
*/ -->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/WorkplaceRequirement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

	String facility_id  = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String reqd_id		= request.getParameter("reqd_id")==null?"":request.getParameter("reqd_id");
	String wrkplace_code= request.getParameter("wrkplace_code")==null?"":request.getParameter("wrkplace_code");
	String mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
	String frm_dt		= request.getParameter("frm_dt")==null?"":request.getParameter("frm_dt");
	String to_dt		= request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String reqd_desc	= request.getParameter("reqd_desc")==null?"":request.getParameter("reqd_desc");

	String slClassValue		="";
	String Sql				="";
	String countSql			="";
	int count				=0;
	ArrayList ResultData	= new ArrayList();
	String[] record			= null;
	String readOnly			="";
	String chk_shift_flag	="";
	//out.println("mode----->" +mode);	
	try{
		Con=ConnectionManager.getConnection(request);
		
		countSql="select count(*) count from rs_workplace_requirement where facility_id= ? and workplace_code = ? and requirement_date_fm is null and requirement_date_to is null and (? is null or to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to)";

		pstmt=Con.prepareStatement(countSql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,wrkplace_code);
		pstmt.setString(3,frm_dt);
		pstmt.setString(4,frm_dt);

		rslRst = pstmt.executeQuery();
		while(rslRst.next()){
			count=rslRst.getInt("count");
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst !=null)
			rslRst.close();

		//Sql="SELECT 'U' db_action,a.facility_id facility_id,a.workplace_code workplace_code,a.requirement_id requirement_id,a.shift_code shift_code,c.short_desc shift_desc,a.position_code position_code,	b.position_desc position_desc,a.fr_wday_min fr_wday_min,a.fr_wday_opt fr_wday_opt,a.fr_wday_max fr_wday_max,a.fr_nwday_min fr_nwday_min,a.fr_nwday_opt fr_nwday_opt,a.fr_nwday_max fr_nwday_max,	a.fr_hday_min fr_hday_min,a.fr_hday_opt fr_hday_opt,a.fr_hday_max fr_hday_max,a.fr_sbr_staff_wday fr_sbr_staff_wday,a.fr_sbr_bed_wday fr_sbr_bed_wday,a.fr_sbr_staff_nwday fr_sbr_staff_nwday,	a.fr_sbr_bed_nwday fr_sbr_bed_nwday,a.fr_sbr_staff_hday fr_sbr_staff_hday,a.fr_sbr_bed_hday fr_sbr_bed_hday,a.vr_spr_staff_wday vr_spr_staff_wday,a.vr_spr_patient_wday vr_spr_patient_wday,	a.vr_spr_staff_nwday vr_spr_staff_nwday,a.vr_spr_patient_nwday vr_spr_patient_nwday,	a.vr_spr_staff_hday vr_spr_staff_hday,a.vr_spr_patient_hwday vr_spr_patient_hwday,a.vr_fte_wday vr_fte_wday,a.vr_fte_hours_wday vr_fte_hours_wday,a.vr_fte_nwday vr_fte_nwday,a.vr_fte_hours_nwday vr_fte_hours_nwday,a.vr_fte_hday vr_fte_hday,a.vr_fte_hours_hday vr_fte_hours_hday FROM 	rs_workplace_requirement_dtl a, am_position b, am_shift c WHERE 	a.facility_id = (?) AND 	a.workplace_code = (?) AND	a.requirement_id = (?) AND 	a.position_code = b.position_code AND	c.shift_code = a.shift_code UNION ALL SELECT 'I' db_action,m.facility_id facility_id,m.workplace_code workplace_code,(?) reqirement_id, m.shift_code shift_code, p.short_desc shift_desc,n.position_code position_code, o.position_desc position_desc ,0 fr_wday_min,0  fr_wday_opt,0 fr_wday_max,0 fr_nwday_min,0 fr_nwday_opt,0 fr_nwday_max ,0 fr_hday_min,0 fr_hday_opt,0 fr_hday_max,0 fr_sbr_staff_wday,0 fr_sbr_bed_wday,0 fr_sbr_staff_nwday,0 fr_sbr_bed_nwday,0 fr_sbr_staff_hday,0 fr_sbr_bed_hday,0 vr_spr_staff_wday,0 vr_spr_patient_wday,0 vr_spr_staff_nwday,0 vr_spr_patient_nwday,0 vr_spr_staff_hday,0 vr_spr_patient_hwday,0 vr_fte_wday,0 vr_fte_hours_wday 	,0 vr_fte_nwday,0 vr_fte_hours_nwday,0 vr_fte_hday,0 vr_fte_hours_hday FROM rs_shift_for_workplace m, am_shift_for_position n, am_position o, am_shift p WHERE 	m.facility_id = (?) AND 	m.workplace_code =(?) AND 	m.shift_code = n.shift_code AND 	n.position_code = o.position_code AND 	(n.shift_code, n.position_code) NOT IN 	(SELECT 	shift_code, position_code FROM rs_workplace_requirement_dtl WHERE 	facility_id =(?) AND 	workplace_code =(?) AND	requirement_id =(?)) AND	p.shift_code = m.shift_code and p.shift_indicator = 'P' ORDER BY shift_code, position_desc";
		Sql="SELECT 'U' db_action,a.facility_id facility_id,a.workplace_code workplace_code,a.requirement_id requirement_id,a.shift_code shift_code,c.short_desc shift_desc,a.position_code position_code, b.position_desc position_desc,a.fr_wday_min fr_wday_min,a.fr_wday_opt fr_wday_opt,a.fr_wday_max fr_wday_max,a.fr_nwday_min fr_nwday_min,a.fr_nwday_opt fr_nwday_opt,a.fr_nwday_max fr_nwday_max, a.fr_hday_min fr_hday_min,a.fr_hday_opt fr_hday_opt,a.fr_hday_max fr_hday_max,a.fr_sbr_staff_wday fr_sbr_staff_wday,a.fr_sbr_bed_wday fr_sbr_bed_wday,a.fr_sbr_staff_nwday fr_sbr_staff_nwday, a.fr_sbr_bed_nwday fr_sbr_bed_nwday,a.fr_sbr_staff_hday fr_sbr_staff_hday,a.fr_sbr_bed_hday fr_sbr_bed_hday,a.vr_spr_staff_wday vr_spr_staff_wday,a.vr_spr_patient_wday vr_spr_patient_wday, a.vr_spr_staff_nwday vr_spr_staff_nwday,a.vr_spr_patient_nwday vr_spr_patient_nwday, a.vr_spr_staff_hday vr_spr_staff_hday,a.vr_spr_patient_hwday vr_spr_patient_hwday,a.vr_fte_wday vr_fte_wday,a.vr_fte_hours_wday vr_fte_hours_wday,a.vr_fte_nwday vr_fte_nwday,a.vr_fte_hours_nwday vr_fte_hours_nwday,a.vr_fte_hday vr_fte_hday,a.vr_fte_hours_hday vr_fte_hours_hday FROM  rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c WHERE  a.facility_id = (?) AND  a.workplace_code = (?) AND a.requirement_id = (?) AND  a.position_code = b.position_code AND c.shift_code = a.shift_code and b.language_id = ? and c.language_id = b.language_id UNION ALL SELECT 'I' db_action,m.facility_id facility_id,m.workplace_code workplace_code,(?) reqirement_id, m.shift_code shift_code, p.short_desc shift_desc,n.position_code position_code, o.position_desc position_desc ,0 fr_wday_min,0  fr_wday_opt,0 fr_wday_max,0 fr_nwday_min,0 fr_nwday_opt,0 fr_nwday_max ,0 fr_hday_min,0 fr_hday_opt,0 fr_hday_max,0 fr_sbr_staff_wday,0 fr_sbr_bed_wday,0 fr_sbr_staff_nwday,0 fr_sbr_bed_nwday,0 fr_sbr_staff_hday,0 fr_sbr_bed_hday,0 vr_spr_staff_wday,0 vr_spr_patient_wday,0 vr_spr_staff_nwday,0 vr_spr_patient_nwday,0 vr_spr_staff_hday,0 vr_spr_patient_hwday,0 vr_fte_wday,0 vr_fte_hours_wday  ,0 vr_fte_nwday,0 vr_fte_hours_nwday,0 vr_fte_hday,0 vr_fte_hours_hday FROM rs_shift_for_workplace m, am_shift_for_position n, am_position_lang_vw o, am_shift_lang_vw p WHERE  m.facility_id = (?) AND  m.workplace_code =(?) AND  m.shift_code = n.shift_code AND  n.position_code = o.position_code AND  (n.shift_code, n.position_code) NOT IN  (SELECT  shift_code, position_code FROM rs_workplace_requirement_dtl WHERE  facility_id =(?) AND  workplace_code =(?) AND requirement_id =(?)) AND p.shift_code = m.shift_code and p.shift_indicator = 'P' and o.language_id = ? and p.language_id = o.language_id ORDER BY shift_code, position_desc";

		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,wrkplace_code);
		pstmt.setString(3,reqd_id);
		pstmt.setString(4,locale);
		pstmt.setString(5,reqd_id);
		pstmt.setString(6,facility_id);
		pstmt.setString(7,wrkplace_code);
		pstmt.setString(8,facility_id);
		pstmt.setString(9,wrkplace_code);
		pstmt.setString(10,reqd_id);
		pstmt.setString(11,locale);
		rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			record = new String[35];
			
			record[0]			=rslRst.getString("db_action");
			record[1]			=rslRst.getString("facility_id");
			record[2]			=rslRst.getString("workplace_code");
			record[3]			=rslRst.getString("requirement_id");
			record[4]			=rslRst.getString("shift_code");
			record[5]			=rslRst.getString("shift_desc");
			record[6]			=rslRst.getString("position_code");
			record[7]			=rslRst.getString("position_desc");
			record[8]			=rslRst.getString("fr_wday_min");
			record[9]			=rslRst.getString("fr_wday_opt");
			record[10]			=rslRst.getString("fr_wday_max");
			record[11]			=rslRst.getString("fr_nwday_min");
			record[12]			=rslRst.getString("fr_nwday_opt");
			record[13]			=rslRst.getString("fr_nwday_max");
			record[14]			=rslRst.getString("fr_hday_min");
			record[15]			=rslRst.getString("fr_hday_opt");
			record[16]			=rslRst.getString("fr_hday_max");
			record[17]			=rslRst.getString("fr_sbr_staff_wday");
			record[18]			=rslRst.getString("fr_sbr_bed_wday");
			record[19]			=rslRst.getString("fr_sbr_staff_nwday");
			record[20]			=rslRst.getString("fr_sbr_bed_nwday");
			record[21]			=rslRst.getString("fr_sbr_staff_hday");
			record[22]			=rslRst.getString("fr_sbr_bed_hday");
			record[23]			=rslRst.getString("vr_spr_staff_wday");
			record[24]			=rslRst.getString("vr_spr_patient_wday");
			record[25]			=rslRst.getString("vr_spr_staff_nwday");
			record[26]			=rslRst.getString("vr_spr_patient_nwday");
			record[27]			=rslRst.getString("vr_spr_staff_hday");
			record[28]			=rslRst.getString("vr_spr_patient_hwday");
			record[29]			=rslRst.getString("vr_fte_wday");
			record[30]			=rslRst.getString("vr_fte_hours_wday");
			record[31]			=rslRst.getString("vr_fte_nwday");
			record[32]			=rslRst.getString("vr_fte_hours_nwday");
			record[33]			=rslRst.getString("vr_fte_hday");
			record[34]			=rslRst.getString("vr_fte_hours_hday");

			ResultData.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst !=null)
			rslRst.close();
		if(ResultData.size()<= 0){
%>
			<script>
				parent.frameWorkPlaceHdr.document.location.href="../../eCommon/html/blank.html"
			</script>
<%
			%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
			
		}
		if(mode.equals("edit")){
			readOnly="readonly";
%>
			 <form name='form_WrkPlaceReqdResult' id='form_WrkPlaceReqdResult' action='../../servlet/eRS.WorkplaceRequirementServlet' method='POST' target='messageFrame'> 
<%
			 for( int i=0 ; i<ResultData.size(); i++ ) {
				if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}

				String[] record1 = (String[])ResultData.get(i);

//				String dbAction				=	record1[0]==null?"":record1[0];
				String shift_code			=	record1[4]==null?"":record1[4];
				String shift_desc			=	record1[5]==null?"":record1[5];
				String posiDesc				=	record1[7]==null?"":record1[7];
				String fr_Wday_min			=	record1[8]==null?"":record1[8];
				String fr_Wday_opt			=	record1[9]==null?"":record1[9];
				String fr_Wday_max			=	record1[10]==null?"":record1[10];
				String fr_NWday_min			=	record1[11]==null?"":record1[11];
				String fr_NWday_opt			=	record1[12]==null?"":record1[12];
				String fr_NWday_max			=	record1[13]==null?"":record1[13];
				String fr_Hday_min			=	record1[14]==null?"":record1[14];
				String fr_Hday_opt			=	record1[15]==null?"":record1[15];
				String fr_Hday_max			=	record1[16]==null?"":record1[16];
				String fr_SBR_staff_wday	=	record1[17]==null?"":record1[17];
				String fr_SBR_bed_wday		=	record1[18]==null?"":record1[18];
				String fr_SBR_staff_nwday	=	record1[19]==null?"":record1[19];
				String fr_SBR_bed_nwday		=	record1[20]==null?"":record1[20];
				String fr_SBR_staff_hday	=	record1[21]==null?"":record1[21];
				String fr_SBR_bed_hday		=	record1[22]==null?"":record1[22];
				String vr_spr_staff_wday	=	record1[23]==null?"":record1[23];
				String vr_spr_patient_wday	=	record1[24]==null?"":record1[24];
				String vr_spr_staff_nwday	=	record1[25]==null?"":record1[25];
				String vr_spr_patient_nwday	=	record1[26]==null?"":record1[26];
				String vr_spr_staff_hday	=	record1[27]==null?"":record1[27];
				String vr_spr_patient_hday	=	record1[28]==null?"":record1[28];
				String vr_FTE_wday			=	record1[29]==null?"":record1[29];
				String vr_FTE_hours_wday	=	record1[30]==null?"":record1[30];
				String vr_FTE_nwday			=	record1[31]==null?"":record1[31];
				String vr_FTE_hours_nwday	=	record1[32]==null?"":record1[32];
				String vr_FTE_hday			=	record1[33]==null?"":record1[33];
				String vr_FTE_hours_hday	=	record1[34]==null?"":record1[34];

				if(shift_code == null ) 
					shift_code =""; 
				else 
					shift_code = shift_code.trim();
%>
				<table cellpadding=0 cellspacing=0 border=1 align=center width="98%" id='' >
<%
				if((chk_shift_flag.equals("")) || !(chk_shift_flag.equals(shift_code))){
%>
					<tr>
						<!--------shift data -------------->
						<td colspan='13' align=left class='CAGROUPHEADING' style="font-ssize:6pt;"><%=shift_desc%></td>
					</tr>
<%
					chk_shift_flag=shift_code;
				}
%>
				<tr>
				<!--------Position data -------------->
					<td rowspan='3' align=left  valign='top' class='<%=slClassValue%>' width='35%'  ><%=posiDesc%></td>

				<!--------fixed data --Wday-------------->
				<td  Align='left' class='<%=slClassValue%>' width='9%'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_Wday_min%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_Wday_opt%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_Wday_max%></td>

				<!------- By ratio --Wday------------>
				<td  Align='center'  class='<%=slClassValue%>' width='13%'><%=fr_SBR_staff_wday%>:<%=fr_SBR_bed_wday%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='13%'><%=vr_spr_staff_wday%>:<%=vr_spr_patient_wday%></td>

				<!------- By FTE --Wday------------>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=vr_FTE_wday%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=vr_FTE_hours_wday%></td>

				<tr>
				<!--------fixed data --NWday-------------->
				<td  Align='left' class='<%=slClassValue%>' width='9%'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_NWday_min%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_NWday_opt%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_NWday_max%></td>


				<!------- By ratio --NWday------------>
				<td  Align='center'  class='<%=slClassValue%>' width='13%'><%=fr_SBR_staff_nwday%>:<%=fr_SBR_bed_nwday%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='13%'><%=vr_spr_staff_nwday%>:<%=vr_spr_patient_nwday%></td>

				<!------- By FTE --NWday------------>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=vr_FTE_nwday%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'>
				<%=vr_FTE_hours_nwday%></td>

				</tr>
				<tr>
				<!--------fixed data --Hday-------------->
				<td  Align='left' class='<%=slClassValue%>' width='9%'><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_Hday_min%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_Hday_opt%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=fr_Hday_max%></td>


				<!------- By ratio --Hday------------>
				<td  Align='center'  class='<%=slClassValue%>' width='13%'><%=fr_SBR_staff_hday%>:<%=fr_SBR_bed_hday%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='13%'><%=vr_spr_staff_hday%>:<%=vr_spr_patient_hday%></td>

				<!------- By FTE --Hday------------>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'><%=vr_FTE_hday%></td>
				<td  Align='center'  class='<%=slClassValue%>' width='6%'>
				<%=vr_FTE_hours_hday%></td>

				</tr>
<%
				/***************************************************/
			}
		}
		else{
%>
		<form name='form_WrkPlaceReqdResult' id='form_WrkPlaceReqdResult' action='../../servlet/eRS.WorkplaceRequirementServlet' method='POST' target='messageFrame'> 
<%
		 for( int i=0 ; i<ResultData.size(); i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}

			String[] record1 = (String[])ResultData.get(i);

			String dbAction				=	record1[0]==null?"":record1[0];
			String shift_code			=	record1[4]==null?"":record1[4];
			String shift_desc			=	record1[5]==null?"":record1[5];
			String posiCode				=	record1[6]==null?"":record1[6];
			String posiDesc				=	record1[7]==null?"":record1[7];
			String fr_Wday_min			=	record1[8]==null?"":record1[8];
			String fr_Wday_opt			=	record1[9]==null?"":record1[9];
			String fr_Wday_max			=	record1[10]==null?"":record1[10];
			String fr_NWday_min			=	record1[11]==null?"":record1[11];
			String fr_NWday_opt			=	record1[12]==null?"":record1[12];
			String fr_NWday_max			=	record1[13]==null?"":record1[13];
			String fr_Hday_min			=	record1[14]==null?"":record1[14];
			String fr_Hday_opt			=	record1[15]==null?"":record1[15];
			String fr_Hday_max			=	record1[16]==null?"":record1[16];
			String fr_SBR_staff_wday	=	record1[17]==null?"":record1[17];
			String fr_SBR_bed_wday		=	record1[18]==null?"":record1[18];
			String fr_SBR_staff_nwday	=	record1[19]==null?"":record1[19];
			String fr_SBR_bed_nwday		=	record1[20]==null?"":record1[20];
			String fr_SBR_staff_hday	=	record1[21]==null?"":record1[21];
			String fr_SBR_bed_hday		=	record1[22]==null?"":record1[22];
			String vr_spr_staff_wday	=	record1[23]==null?"":record1[23];
			String vr_spr_patient_wday	=	record1[24]==null?"":record1[24];
			String vr_spr_staff_nwday	=	record1[25]==null?"":record1[25];
			String vr_spr_patient_nwday	=	record1[26]==null?"":record1[26];
			String vr_spr_staff_hday	=	record1[27]==null?"":record1[27];
			String vr_spr_patient_hday	=	record1[28]==null?"":record1[28];
			String vr_FTE_wday			=	record1[29]==null?"":record1[29];
			String vr_FTE_hours_wday	=	record1[30]==null?"":record1[30];
			String vr_FTE_nwday			=	record1[31]==null?"":record1[31];
			String vr_FTE_hours_nwday	=	record1[32]==null?"":record1[32];
			String vr_FTE_hday			=	record1[33]==null?"":record1[33];
			String vr_FTE_hours_hday	=	record1[34]==null?"":record1[34];
			String Check="";
			String Chkvalue="";
			if(dbAction.equals("U")){
				Check="Checked";
				Chkvalue="Y";
			}else{
				Check="";
				Chkvalue="";
			}
			if(shift_code == null ) shift_code =""; else shift_code = shift_code.trim();
%>
			<table cellpadding=0 cellspacing=0 border=1 align=center width="98%" id=''>
<%
			if((chk_shift_flag.equals("")) || !(chk_shift_flag.equals(shift_code))){
%>
				<tr>
					<!--------shift data -------------->
					<td colspan='13' align=left class='CAGROUPHEADING'><%=shift_desc%></td>
				</tr>
<%
				chk_shift_flag=shift_code;
			}
%>
			<input type='hidden' name=shift_code<%=i%> value='<%=shift_code%>'>
			<tr>
			<!--------Position data -------------->
				<td rowspan='3' align=left  valign='top' class='<%=slClassValue%>' width='35%'  ><%=posiDesc%></td>
			 <input type='hidden' name='posiCode<%=i%>' id='posiCode<%=i%>' value='<%=posiCode%>'>

			<!--------fixed data --Wday-------------->
			<td  Align='left' class='<%=slClassValue%>' width='9%'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="wday_min<%=i%>" id="wday_min<%=i%>" value="<%=fr_Wday_min%>" size="1"  <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="wday_opt<%=i%>" id="wday_opt<%=i%>" value="<%=fr_Wday_opt%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="wday_max<%=i%>" id="wday_max<%=i%>" value="<%=fr_Wday_max%>" size="1" <%=readOnly%>  onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			<!------- By ratio --Wday------------>
			<td  Align='center'  class='<%=slClassValue%>'  width='10%'><input type=text name="wday_sb1<%=i%>" id="wday_sb1<%=i%>" value="<%=fr_SBR_staff_wday%>" size="1"<%=readOnly%>  onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'>:<input type=text name="wday_sb2<%=i%>" id="wday_sb2<%=i%>" value="<%=fr_SBR_bed_wday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='10%'><input type=text name="wday_sp1<%=i%>" id="wday_sp1<%=i%>" value="<%=vr_spr_staff_wday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'>:<input type=text name="wday_sp2<%=i%>" id="wday_sp2<%=i%>" value="<%=vr_spr_patient_wday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			<!------- By FTE --Wday------------>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="wday_fte<%=i%>" id="wday_fte<%=i%>" value="<%=vr_FTE_wday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="wday_hrs<%=i%>" id="wday_hrs<%=i%>" value="<%=vr_FTE_hours_wday%>" size="1"<%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			<!------- select------------>
			<td  Align='center' class='<%=slClassValue%>' rowspan='3' width='6%'><input type=checkbox name='select<%=i%>' id='select<%=i%>'  value='<%=Chkvalue%>' <%=Check%> ></td>
			</tr>

			<tr>
			<!--------fixed data --NWday-------------->
			<td  Align='left' class='<%=slClassValue%>' width='9%'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></td>
			<td  Align='center'  class='<%=slClassValue%>'  width='6%'><input type=text name="nwday_min<%=i%>" id="nwday_min<%=i%>" value="<%=fr_NWday_min%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>'  width='6%'><input type=text name="nwday_opt<%=i%>" id="nwday_opt<%=i%>" value="<%=fr_NWday_opt%>" size="1"<%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>'  width='6%'><input type=text name="nwday_max<%=i%>" id="nwday_max<%=i%>" value="<%=fr_NWday_max%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			<!------- By ratio --NWday------------>
			<td  Align='center'  class='<%=slClassValue%>'  width='10%'><input type=text name="nwday_sb1<%=i%>" id="nwday_sb1<%=i%>" value="<%=fr_SBR_staff_nwday%>"size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'>:<input type=text name="nwday_sb2<%=i%>" id="nwday_sb2<%=i%>" value="<%=fr_SBR_bed_nwday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>'  width='10%'><input type=text name="nwday_sp1<%=i%>" id="nwday_sp1<%=i%>" value="<%=vr_spr_staff_nwday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'>:<input type=text name="nwday_sp2<%=i%>" id="nwday_sp2<%=i%>" value="<%=vr_spr_patient_nwday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			<!------- By FTE --NWday------------>
			<td  Align='center'  class='<%=slClassValue%>'  width='6%'><input type=text name="nwday_fte<%=i%>" id="nwday_fte<%=i%>" value="<%=vr_FTE_nwday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="nwday_hrs<%=i%>" id="nwday_hrs<%=i%>" value="
			<%=vr_FTE_hours_nwday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			</tr>
			<tr>
			<!--------fixed data --Hday-------------->
			<td  Align='left' class='<%=slClassValue%>' width='9%'><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="hday_min<%=i%>" id="hday_min<%=i%>" value="<%=fr_Hday_min%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="hday_opt<%=i%>" id="hday_opt<%=i%>" value="<%=fr_Hday_opt%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="hday_max<%=i%>" id="hday_max<%=i%>" value="<%=fr_Hday_max%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			<!------- By ratio --Hday------------>
			<td  Align='center'  class='<%=slClassValue%>'><input type=text name="hday_sb1<%=i%>" id="hday_sb1<%=i%>" value="<%=fr_SBR_staff_hday%>"size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);' width='10%'>:<input type=text name="hday_sb2<%=i%>" id="hday_sb2<%=i%>" value="<%=fr_SBR_bed_hday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='10%'><input type=text name="hday_sp1<%=i%>" id="hday_sp1<%=i%>" value="<%=vr_spr_staff_hday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'>:<input type=text name="hday_sp2<%=i%>" id="hday_sp2<%=i%>" value="<%=vr_spr_patient_hday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			<!------- By FTE --Hday------------>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="hday_fte<%=i%>" id="hday_fte<%=i%>" value="<%=vr_FTE_hday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>
			<td  Align='center'  class='<%=slClassValue%>' width='6%'><input type=text name="hday_hrs<%=i%>" id="hday_hrs<%=i%>" value="
			<%=vr_FTE_hours_hday%>" size="1" <%=readOnly%> onKeyPress='return NumberFormat()' maxlength='3' onblur='checkForNull(this);'></td>

			</tr>
			<input type='hidden' name=dbAction<%=i%> value='<%=dbAction%>'>
<%
		}
	}
%>
	</table>
	<input type='hidden' name=fac_id value='<%=facility_id%>'>
	<input type='hidden' name=workplace_code value='<%=wrkplace_code%>'>
	<input type='hidden' name=req_id  value='<%=reqd_id%>'>
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=ResultData.size()%>" > 
	<input type="hidden" name="mode" id="mode" value="<%=mode%>" > 
	<input type="hidden" name="frm_dt" id="frm_dt" value="<%=frm_dt%>" > 
	<input type="hidden" name="to_dt" id="to_dt" value="<%=to_dt%>" > 
	<input type="hidden" name="reqd_desc" id="reqd_desc" value="<%=reqd_desc%>" > 		
	<input type="hidden" name="constCount" id="constCount" value="<%=count%>" > 		
	</form>
<%
	}
	catch(Exception e){
		out.println("Exception in try of WrkPlaceReqdNewStaffDtl.jsp : "+e);
	}
	finally {
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}
%>
</body>	
</html>

