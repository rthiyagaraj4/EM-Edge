<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
        
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
    <script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script src="../js/PatHighRisk.js" language="javascript"></SCRIPT>
	<script src="../../ePH/js/Prescription_1.js" language="javascript"></script>
	<script>
	    function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
		{
	
			eval("document.forms[0].detail"+obj).innerHTML="<a href='#'  onClick=\" display_records1('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black' bgcolor='#FF9933'>-</font></a>";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\" det='add' steps='7'/></root>"
	
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)		   
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
		}

		function display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
		{
			eval("document.forms[0].detail"+obj).innerHTML="<a href='#' onClick=\"display_records('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black'>+</font></a>";

			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" det='sub' status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\"  steps='7'/></root>"
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
	
		}
		function callonload()
		{
			var tot_allr=document.forms[0].rowcolor.value;
		}	
 </script>

</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<script language=javascript>
		document.body.style.scrollbarBaseColor='#E2E3F0';
		document.body.style.scrollbarArrowColor='#000080';
		document.body.style.scrollbarDarkShadowColor='#E2E3F0';
		document.body.style.scrollbarFaceColor='#E2E3F0';
		document.body.style.scrollbarHighlightColor='white';
		document.body.style.scrollbarShadowColor='#E2E3F0';
		document.body.style.scrollbar3dlightColor='#E2E3F0';
	</script>
<form name="frmPatientContent" id="frmPatientContent">
<div id="header"></div>
<div id="printArea">

<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");	
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String patient_profile = request.getParameter("patient_profile");
	if(patient_profile == null) patient_profile = "";
	if(encounter_id == null) encounter_id = "";
	String facility_id = (String)session.getValue("facility_id");

	StringBuffer strSql = new StringBuffer();
	StringBuffer sql  = new StringBuffer();
	StringBuffer sql1 = new StringBuffer();
	String drug_code = "";

	Connection con  = null;
	ResultSet oRs = null;
	ResultSet rset = null;
	PreparedStatement stmt = null;
	PreparedStatement pstmt  = null;

	int j =0;
	String classValue = "";

	String content_id = "";
	boolean found; 
	String titlemsg; 

	// PATIENT MARKERS
	String blood_grp	= "";
	String rh_factor	= "";
	String g6pd			= "";
	String 	sicc		= "";

	// CURRENT PROBLEMS
	String diag_desc	= "";
	String diag_type	= "";
	String dtype		= "";
	String onset_date	= "";

	// CURRENT ALLERGIES
	String allergen		= "";

	// VITAL_SIGNS
	String  discr_msr_desc		= "";
	
	String care_flow_detail		= "";
	String color_cell_indicator	= "";
	String descCellInd		= "";
	String styleValue		= "";
	String legend_type		= "";
	String normal_low		= "";
	String normal_high		= "";
	String normalcy_ind		= "";
	String result_num		= "";

	// MEDICATIONS
	String drug_name			= "";
	String drug_duration		= "";

	//	CURRENT ENCOUNTERS
	String location_desc		= "";
	String speciality			= "";
	String practitioner_name	= "";
	String visit_date			= "";
	String los					= "";

	// PROCEDURE PERFORMED
	String proc_name			= "";
	String proc_date			= "";
	String long_desc			= "";
	String diagnosis = "";
	String calculated_onset_date_yn = "";
	String img_disp_yn = "";

	try
	{
		con  =  ConnectionManager.getConnection(request);
		if(strSql.length() > 0) strSql.delete(0,strSql.length());
		
		strSql.append("select CONTENT_ID,");
		strSql.append("NVL(CONTENT_USER_DEF_DESC,CONTENT_SYS_DEF_DESC)");
		strSql.append(" TITLE_DESC ");
		strSql.append(" FROM CA_PAT_PROF_CONT_LANG_VW ");
		strSql.append(" WHERE INCLUDE_YN='Y' AND LANGUAGE_ID = ?");
		strSql.append(" ORDER BY ORDER_SEQ_NO");

		stmt = con.prepareStatement(strSql.toString());
		stmt.setString(1,locale);
		oRs = 	stmt.executeQuery();

		String checkBoxClick = "";
		int counter = 0;
		int k = 0;
		
		while (oRs.next())
		{
			content_id = oRs.getString("content_id");
			checkBoxClick = request.getParameter("chk"+content_id)==null?"":request.getParameter("chk"+content_id);

			if (content_id.equals("1") && checkBoxClick.equals("Y"))
			{
				found = false;
				titlemsg = "";
				sql = new StringBuffer();
     
				sql.append("SELECT C.SHORT_DESC blood_grp, b.short_desc ");   sql.append("rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc");
				sql.append(" FROM MP_PAT_OTH_DTLS A,MR_RHESUS_FACTOR_LANG_VW B,"); sql.append("MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ?"); 
				sql.append("and a.rh_factor = b.RHESUS_FACTOR_CODE(+) ");
				sql.append("and a.blood_grp = c.blood_grp(+) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = ? ") ;
			 
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, patient_id );
				pstmt.setString(2, locale );
				pstmt.setString(3, locale );
				rset = pstmt.executeQuery();

				if (rset.next())
				{
					found = true;
					titlemsg = "";
				}
			
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, patient_id );
				pstmt.setString(2, locale );
				pstmt.setString(3, locale );
				rset = pstmt.executeQuery();

				while(rset.next())
				{
					blood_grp = rset.getString("blood_grp")==null?"":rset.getString("blood_grp");
					rh_factor = rset.getString("rh_factor")==null?"":rset.getString("rh_factor");
					g6pd	  = rset.getString("g6pd")==null?"":rset.getString("g6pd");
					sicc	  = rset.getString("sicc")==null?"":rset.getString("sicc");
					k++;
					j++;
				}
							
				if (k==0)
				{
					found = false;
					titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotIdentified.label","ca_labels");
				}
%>
			<div id = "one">
			<a name = "1">
			
			<table width = "100%" class = 'grid'>
				<tr>
					<td class = 'columnheader' colspan = "2" align = "left" style="background-color: black; color: white;"><input type = "checkbox" name = "chk1" checked><fmt:message key="eCA.PatientMarkers.label" bundle="${ca_labels}"/> <%=titlemsg%></td>
				</tr>
				
				<tr>
					<td class = "gridData" width = "50%"><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td> <td class="gridData" width="50%"> <%=blood_grp%> </td>
				</tr>
				<tr>
					<td class = "gridData" width = "50%"><fmt:message key="Common.RhFactor.label" bundle="${common_labels}"/></td> <td class="gridData" width="50%"> <%=rh_factor%> </td>
				</tr>
				<tr>
					<td class = "gridData" width = "50%"><fmt:message key="Common.g6pd.label" bundle="${common_labels}"/></td> <td class="gridData" width="50%"> <%=g6pd%> </td>
				</tr>
				<tr>
					<td width = "50%" class = "gridData" ><fmt:message key="Common.sicc.label" bundle="${common_labels}"/></td></td> <td width="50%" class="gridData" > <%=sicc%> </td>
				</tr>	
				
			</table>
			</div>
<%
		} //if 1
		else if(content_id.equals("2") && checkBoxClick.equals("Y"))
		{
			found = false;;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotExist.label","ca_labels");
			sql = new StringBuffer();
			
			sql.append("select srl_no,"); 
			sql.append("diag_type dtype,");
			sql.append("to_char(onset_date,'dd/mm/yyyy') onset_date,");
			sql.append("sensitive_yn,diag_desc, diag_code,");
			sql.append("diag_code_scheme_desc from pr_problem_vw ");
			sql.append("where patient_Id=? and ");
			sql.append("nvl(problem_status,'O')!='C' and ");
			sql.append("nvl(sensitive_yn,'N')=decode('N','N','N',NVL(sensitive_yn,'N')) ");
			sql.append("and diag_code_scheme=(select diag_code_scheme ");
			sql.append("from mr_parameter where rownum=1)  order by ");
			sql.append("to_date(onset_date,'dd/mm/yyyy') desc");

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				found = true;
				titlemsg = "";
				k++;
			}
			if (k == 0)
			{
				found = false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotExist.label","ca_labels");
			}
			
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset = pstmt.executeQuery();
%>
			<div id = "two">
			<br> <br> <br>
			<a name = "2">
			<table width = "100%" class = 'grid'>
				<tr>
					<td class = 'columnheader' colspan = "3" ><input type = "checkbox" name = "chk2" checked><fmt:message key="eCA.current.label" bundle="${ca_labels}"/><fmt:message key="Common.Problems.label" bundle="${common_labels}"/><%=titlemsg%></td>
				</tr>
				
				<tr>
					<td class='columnheadercenter'><fmt:message key="Common.Problem.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' width="25%" > <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
				</tr>
<%
				classValue = "gridData";
				while(rset.next())
				{
					diag_desc = rset.getString("diag_desc")==null?"":rset.getString("diag_desc");
					diag_type = rset.getString("dtype")==null?"":rset.getString("dtype").trim();
					if(diag_type.equals("P"))
						dtype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
					else if (diag_type.equals("D"))
						dtype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
					else if (diag_type.equals("F"))
						dtype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");

					onset_date = rset.getString("onset_date")==null?"":rset.getString("onset_date");
					if(!locale.equals("en"))
					  onset_date = com.ehis.util.DateUtils.convertDate(onset_date,"DMYHM","en",locale);
%>
					<tr>
						<td width="50%"  class="<%=classValue%>"> <%=diag_desc%> </td>
						<td width="50%"  class="<%=classValue%>"> <%=dtype%> </td>
						<td width="50%"  class="<%=classValue%>"> <%=onset_date%> </td>
					</tr>
<%	
					j++;
				}
%>
			</table>
			</div>
<%
		}//if 2
		else if(content_id.equals("3") && checkBoxClick.equals("Y"))
		{
			ResultSet rs = null;
			Statement stmt1 = null;
			PreparedStatement pstmt2 = null;//common-icn-0180
			String allergen1="",adv_event_type="",Certainity="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",error_status="" ,status1="",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="";
        
			try 
			{
%> 
			<div id="three">
			<br> <br> <br>
			<a name="3">
			<body OnMouseDown = "CodeArrest()" onKeyDown = 'lockKey()' >
			<form name = 'chk_val'>
	
			<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
            <tr>
				<td class='columnheader' colspan="3" style="background-color: black; color: white;"><input type="checkbox" name="chk3" id="chk3" checked><fmt:message key="Common.current.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></td>
			</tr>
			</table>
			<table class='grid' width='100%'  id='record'>
			<tr>
				<th width='3%'><div  id='head1'  class='myClass' nowrap width='3%'>&nbsp;&nbsp;</div></th>
				<th width='15%'><div  id='head2' class='myClass' nowrap width='24%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></th>
				<th width='15%'><div  id='head3' class='myClass' nowrap width='25%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></th>
				<th width='15%'><div  id='head4' class='myClass' nowrap width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></th>
				<th width='15%'><div  id='head5' class='myClass' nowrap width='23%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th>
			</tr>
<%
			//stmt1 = con.createStatement();//common-icn-0180
          
			int rowcolor = 0,m = 0;
			
			//String sql2="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) END allergen, MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') adv_event_type_ind_desc, MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION,CALCULATED_ONSET_DATE_YN,f.status error_status FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+patient_id+"' AND  a.status='A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";//common-icn-0180	
			String sql2="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,?,'1') reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id=?),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id=?))) END allergen, MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,?,'1') adv_event_type_ind_desc, MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,?,'1') adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id=?),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION,CALCULATED_ONSET_DATE_YN,f.status error_status FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = ? AND  a.status='A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";	//common-icn-0180
			pstmt2 = con.prepareStatement(sql2);//common-icn-0180
			//common-icn-0180 starts
			pstmt2.setString(1, locale);
			pstmt2.setString(2, locale);
			pstmt2.setString(3, locale);
			pstmt2.setString(4, locale);
			pstmt2.setString(5, locale);
			pstmt2.setString(6, locale);
			pstmt2.setString(7, patient_id);
			
			
			//rs = stmt1.executeQuery(sql2);//common-icn-0180
			rs = pstmt2.executeQuery();
			//common-icn-0180 ends
			if(rs !=null)
			{
				classValue = "gridData";	
				while(rs.next())
				{
					causative_code = rs.getString("allergen_code");
					adv_event_type_ind_code = rs.getString("ADV_EVENT_TYPE_IND");

					adv_event_type_code = rs.getString("ADV_EVENT_TYPE");
					allergen = rs.getString("allergen");
					adv_event_type = rs.getString("adv_event_type_desc");
					Certainity = rs.getString("CERTAINTY");
					onset_date = rs.getString("ONSET_DATE");
					if(onset_date == null) onset_date = "";
					status = rs.getString("STATUS");
					severity_main = rs.getString("severity1");
					if(severity_main == null) severity_main = "";
					adv_event_dtl_srl_no = rs.getString("adv_event_dtl_srl_no");
					if(adv_event_dtl_srl_no == null) adv_event_dtl_srl_no = "";
					causative_substance = rs.getString("causative_substance");
					if(causative_substance == null) causative_substance = "";
					route_of_exposure = rs.getString("route_of_exposure");
					if(route_of_exposure == null) route_of_exposure = "";
					severity_two = rs.getString("severity_two");
					if(severity_two == null) severity_two = "&nbsp;";
					adv_reac_code = rs.getString("adv_reac_code");
					if(adv_reac_code == null) adv_reac_code = "";
					reaction_date1 = rs.getString("reaction_date");
					if(reaction_date1 == null) reaction_date1 = "";
					reac_desc = rs.getString("reac_desc");

					if(reac_desc == null) reac_desc = "&nbsp;";
					severity_code = rs.getString("severity_code");
					if(severity_code == null)severity_code = "";
					diagnosis_code = rs.getString("diagnosis_code");
					if(diagnosis_code == null)diagnosis_code = "";
					active_date = rs.getString("active_date");
					if(active_date == null) active_date = "";
					final_reac_code_val = rs.getString("REACTION_CODE_VALUES");
					if(final_reac_code_val == null || final_reac_code_val.equals("THR")) final_reac_code_val = "";
					reaction_site= rs.getString("reaction_site");
					if(reaction_site == null || reaction_site == "") reaction_site = "&nbsp;";
					
					others_reaction = rs.getString("OTHERS_REACTION");
					if(others_reaction == null) others_reaction = "&nbsp;";
					
					calculated_onset_date_yn = rs.getString("CALCULATED_ONSET_DATE_YN");
					if(calculated_onset_date_yn == null) calculated_onset_date_yn = "&nbsp;";
					error_status = rs.getString("error_status") == null ? "A" : rs.getString("error_status");

					if(calculated_onset_date_yn.equals("Y"))
					{
						img_disp_yn = "display:visible";
					}
					else
					{
						img_disp_yn = "display:none";
					}

					cnt_recurring = rs.getString("COUNT");

					if(adv_event_type_ind_code.equals("01"))
						classValue1 = "MRALLERGY";
					else if(adv_event_type_ind_code.equals("02"))
						classValue1 = "MRHYPERII";
					else if(adv_event_type_ind_code.equals("03"))
						classValue1 = "MRHEADER";
					else if(adv_event_type_ind_code.equals("04"))
						classValue1 = "ORBROWN";
					
					if(severity_main.equals("U"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					else if(severity_main.equals("M"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					else if(severity_main.equals("O"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					else if(severity_main.equals("S"))
						severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");

					if(Certainity.equals("D"))
						Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Definitive.label","common_labels");
					else if(Certainity.equals("P"))
						Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");

					status_pass = status;

					if(status.equals("A"))
						status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
				
					if(route_of_exposure.equals("1"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
					else if(route_of_exposure.equals("2"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inhalation.label","mr_labels");
					else if(route_of_exposure.equals("3"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Injection.label","mr_labels");
					else if(route_of_exposure.equals("4"))
						route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Tropical.label","mr_labels");

					if(severity_two.equals("U"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					else if(severity_two.equals("M"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					else if(severity_two.equals("O"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					else if(severity_two.equals("S"))
						severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");

					onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
					reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);

					if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1)|| !status.equals(status1)|| !adv_event_type_ind_code.equals(adv_event_type_ind_code1)|| !onset_date_disply.equals(onset_date_disply1)))
					{
%>

			<tr id='first' >
				<td  class='<%=classValue1%>' nowrap id='detail<%=m%>'><a href="javascript:onclick=display_records1('<%=m%>','<%=patient_id%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>','<%=status_pass%>','<%=error_status%>','<%=onset_date%>')">&nbsp;-&nbsp;</a></td>
				<td  class='<%=classValue%>' nowrap ><%=adv_event_type%></td>
				<td   class='<%=classValue%>' nowrap id='header'><%=allergen%></td>
				<td  class='<%=classValue%>' nowrap ><%=onset_date_disply%><img src='../../eCA/images/mc_history.gif' BORDER='0' style='<%=img_disp_yn%>'> </td>
					
<%
				if(cnt_recurring.equals("0"))
				{
%>
				<td  class='<%=classValue%>' nowrap ><%=status%></td>
<%
				}
				else
				{
%>
				<td  class='<%=classValue%>' nowrap ><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
<%
				}
%>
			</tr>
			<tr id='third<%=m%>' Style="display;visibility:visible">
				<td  class='<%=classValue%>' nowrap >&nbsp;</td>
				<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></b></th>
				<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></b></th>
				<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></b></th>
				<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></b></th>
			</tr>
<%
			if(!error_status.equals("E"))
			{
%>
			<tr id='second<%=m%>' Style="display;visibility:visible" >
				<td  class='<%=classValue%>' nowrap >&nbsp;</td>
				<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
<% 
				if(adv_reac_code.equals("Oth")) 
				{ 
%>
				<td  class='<%=classValue%>' nowrap ><%=others_reaction%></td>
<%
				}
				else
				{
%>
				<td  class='<%=classValue%>' nowrap ><%=reac_desc%></td>
<%
				}
%>
				<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
				<td  class='<%=classValue%>' nowrap ><%=reaction_site%></td>
			
			</tr>
<%
			}
			}
			else
			{
				if(!error_status.equals("E"))
				{
%>
					<tr id='third<%=m%>' Style="display:none;visibility:hidden" >
					<td  class='<%=classValue%>' nowrap >&nbsp;</td>
					<td class=<%=classValue%> align=center nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
					<td class=<%=classValue%> align=center nowrap ><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></td>
					<td class=<%=classValue%> align=center nowrap ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
					<td class=<%=classValue%> align=center nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr id='second<%=m%>' Style="display;visibility:visible" >
						<td  class='<%=classValue%>' nowrap >&nbsp;</td>
						<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
<% 
					if(adv_reac_code.equals("Oth")) 
					{
%>
					<td  class='<%=classValue%>' nowrap ><%=others_reaction%></td>
<%
					}
					else
					{
%>
					<td  class='<%=classValue%>' nowrap ><%=reac_desc%></td>
<%
					}
%>
					<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
					<td  class='<%=classValue%>' nowrap ><%=reaction_site%></td>
				</tr>
<%
				}
				}
				
				allergen1=rs.getString("allergen_code");
				reaction_date_prev =rs.getString("reaction_date");
				adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");

				adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
				onset_date1 = rs.getString("onset_date");
				onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
				status1 = rs.getString("status");
					
				if(status1.equals("A"))
					status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
				else if(status1.equals("R"))
					status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
				else if(status1.equals("E"))
					status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
				
				rowcolor ++;
				m++;
				j++;
			}
%>
		</table>
		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
			<tr><td width='100%' id='t'></td></tr>
		</table>
		</div>
<%
		}
%>

	<input type="hidden" name="detail" id="detail" value="" >
	<input type="hidden" name="rowcolor" id="rowcolor" value="<%=rowcolor%>" >
	<input type="hidden" name="cnt" id="cnt" value="" >
	<input type="hidden" name="flag1" id="flag1" VALUE="">

	<input type="hidden" name="PatientId" id="PatientId" value="<%=patient_id%>" >
	<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=encounter_id%>" >
  </form>
</body></div>
<%
			}
			catch(Exception e)
			{
				e.printStackTrace();
				if (rs != null) rs.close();
				if (stmt1 != null) stmt1.close();
				if (pstmt2 != null) pstmt2.close();//common-icn-0180
			}
		} //if 3
		else if(content_id.equals("4") && checkBoxClick.equals("Y"))
		{
			found = false;
			titlemsg = "";
						
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM");
			rset = pstmt.executeQuery();
			if (rset.next())
			{
				legend_type = rset.getString(1) == null ? "S" : rset.getString(1);
			}

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			sql = new StringBuffer();
			 
			sql.append("select EVENT_DATE dummydate , b.short_desc ");
			sql.append(" discr_msr_desc, a.NORMAL_LOW, a.NORMAL_HIGH, a.RESULT_NUM, A.NORMALCY_IND,");
			sql.append("RESULT_NUM_UOM,to_char(EVENT_DATE, 'dd/mm/yyyy hh24:mi') event_date ,");
			sql.append("nvl(RESULT_NUM,'')||nvl(RESULT_STR,'')||' '||nvl(RESULT_NUM_UOM,'')");
			sql.append(" care_flow_detail,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR ,crit_low_color_code,'')");
            sql.append("from CR_CLIN_EVENT_PARAM ) COLOR_CELL_IND, ");
			sql.append("(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)");
			sql.append("from CR_CLIN_EVENT_PARAM ) DESC_CELL_IND, ");
			sql.append("(select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol ");
			sql.append("from cr_encounter_detail a,");
			sql.append("CR_CLN_EVT_MST_LANG_VW b where B.LANGUAGE_ID = ? and ");
			sql.append("a.hist_rec_type = 'PTCR' and ");
			sql.append("b.hist_rec_type  = a.hist_rec_type   and ");
			sql.append("b.event_code = a.event_code and  b.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE and patient_id = ? ");
			sql.append("and event_date in (select max(event_date) from ");
			sql.append("cr_encounter_detail where ");
			sql.append("patient_id=? and hist_rec_type = 'PTCR') and nvl(a.STATUS,'`') not in('S','E') order by dummydate desc ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2, patient_id );
			pstmt.setString(3, patient_id );
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				found = true;
				String eventdate = rset.getString("event_date");
				if(!locale.equals("en"))
					eventdate = com.ehis.util.DateUtils.convertDate(eventdate,"DMYHM","en",locale);

				titlemsg = " : "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Recorded.label","ca_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.At.label","common_labels")+ " " + eventdate;
				k++;
			}
			if(k == 0)
			{
				found = false;
				titlemsg = " : "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotRecorded.label","ca_labels");

			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2, patient_id );
			pstmt.setString(3, patient_id );
			rset = pstmt.executeQuery();
%>
			<div id="four">

			<br> <br> <br>
			<a name="4">
			<table width="100%" class = 'grid'>
				<tr>
					<td class='columnheader' colspan="4" align="left" style="background-color: black; color: white;"> <input type="checkbox" name="chk4" id="chk4" checked><fmt:message key="eCA.PatientCare.label" bundle="${ca_labels}"/><%=titlemsg%></td>
				
				</tr>
				<tr>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.Observation.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.Result.label" bundle="${common_labels}"/> </td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="eCA.NormalcyStatus.label" bundle="${ca_labels}"/> </td>
				</tr>
<%
				while(rset.next())
				{
					classValue = "gridData" ;

					discr_msr_desc = rset.getString("discr_msr_desc")==null?"":rset.getString("discr_msr_desc");
					care_flow_detail = rset.getString("care_flow_detail")==null?"":rset.getString("care_flow_detail");
					normal_low = rset.getString("NORMAL_LOW")==null?"0":rset.getString("NORMAL_LOW");
					normal_high = rset.getString("NORMAL_HIGH")==null?"0":rset.getString("NORMAL_HIGH");
					result_num = rset.getString("RESULT_NUM")==null?"0":rset.getString("RESULT_NUM");
					normalcy_ind = rset.getString("NORMALCY_IND")==null?"":rset.getString("NORMALCY_IND");
					color_cell_indicator = rset.getString("COLOR_CELL_IND")==null?"":rset.getString("COLOR_CELL_IND");

					if(legend_type.equals("S"))
						color_cell_indicator = rset.getString("normal_range_symbol") == null? "" : rset.getString("normal_range_symbol");
					else
						color_cell_indicator = rset.getString("COLOR_CELL_IND")== null ? "" : rset.getString("COLOR_CELL_IND");
				   
					descCellInd = rset.getString("DESC_CELL_IND") == null ? "&nbsp;" : rset.getString("DESC_CELL_IND");
					if(!color_cell_indicator.equals("") && color_cell_indicator != null)
					{
						if(legend_type.equals("S"))
							styleValue = "<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
						else
							styleValue = "<font style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
					}
					else if(!normal_low.equals("0") && !normal_high.equals("0"))
					{
						if(Float.parseFloat(result_num)>0)
						{
							if((Float.parseFloat(result_num) >= Float.parseFloat(normal_low)) && (Float.parseFloat(result_num) <= 	Float.parseFloat(normal_high)))
							{
								if(legend_type.equals("S"))
									styleValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
								else
									styleValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";

								descCellInd = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
							}
						}
					}
					else if(normalcy_ind.equals("."))
					{
						if(legend_type.equals("S"))
							styleValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
						else
							styleValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";

						descCellInd = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
					}
					else
						styleValue = "";
%>
					<tr>
						<td class="<%=classValue%>"> <%=discr_msr_desc%> </td>
						<td class="<%=classValue%>"> <%=styleValue%><%=care_flow_detail%> </td>
						<td class="<%=classValue%>"> <%=descCellInd%> </td>
					</tr>
<%
					j++;
				}
%>
			</table>
			</div>
<%
		}//if 4

		else if(content_id.equals("5") && checkBoxClick.equals("Y"))
		{
			found =false;;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			sql = new StringBuffer();
			
			sql.append(" SELECT NULL drug_code,e.form_code||' '||");
			sql.append("e.DRUG_DESC||' '||decode (g.SLIDING_SCALE_YN ,'Y','<font color=red>(Sliding Scale)</font>',RTRIM (RTRIM (TO_CHAR (a.dosage, '9999999999999990.999999999999'), '0'), '.') ||' '||");
			sql.append(" PH_GET_UOM_DISPLAY('"+facility_id+"',a.dosage_uom_code,'"+localeName+"'))||' '||DECODE (drug_yn, 'Y', DECODE (a.split_yn, 'Y', '(Divided)',d.freq_desc), '')||decode(DRUG_YN, 'Y',' * ','')||");
			sql.append(" decode(DRUG_YN, 'Y', a.DURATION,'')  ||' '||decode(DRUG_YN, 'Y', c.durn_desc,'') ");  
			sql.append(" drug_name,TO_CHAR (sm_convert_date(a.start_date,'"+locale+"'), 'dd/mm/yy')||'-'||TO_CHAR (sm_convert_date(a.end_date,'"+locale+"'), 'dd/mm/yy') drug_duration ");
			sql.append(" FROM ph_patient_drug_profile a ,am_duration_type c,am_frequency d, ph_drug e ,ph_generic_name f,or_order_line_ph g WHERE a.orig_order_id =g.ORDER_ID and a.ORIG_ORDER_LINE_NO =g.ORDER_LINE_NUM");
			sql.append(" and a.patient_id = ? AND TRUNC(NVL(a.end_date,SYSDATE)) >= TRUNC(SYSDATE) and nvl(CANCEL_YN,'N')='N' ");
			sql.append(" AND a.discont_date_time IS NULL AND ");
			sql.append(" a.on_hold_date_time IS NULL AND ");
			sql.append(" d.freq_code(+)=a.FREQ_CODE AND e.DRUG_CODE=a.DRUG_CODE  and f.GENERIC_ID=a.GENERIC_ID and e.drug_yn='Y' AND ");
			sql.append(" c.durn_type(+)=a.DURN_TYPE ORDER BY start_date DESc ");
 			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset=pstmt.executeQuery();
			
			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
			if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, patient_id );
			rset=pstmt.executeQuery();
	%>

			<div id = "five">

			<br> <br> <br>
			<a name="5">
			<table width="100%" class = 'grid'>
				<tr>
					<td class='columnheader' colspan="2" align="left" style="background-color: black; color: white;"> <input type="checkbox" name="chk5" id="chk5" checked><fmt:message key="eCA.Medications.label" bundle="${ca_labels}"/> <%=titlemsg%></td>
				</tr>
				
				<tr>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="eCA.DrugDuration.label" bundle="${ca_labels}"/></td>
				</tr>
<%
			while(rset.next())
			{
				classValue = "gridData" ;

				drug_name = rset.getString("drug_name")==null?"":rset.getString("drug_name");
				drug_code = rset.getString("drug_code")==null?"":rset.getString("drug_code");
				drug_duration= rset.getString("drug_duration")==null?"":rset.getString("drug_duration");
				
%>
				<tr>
					<td class="<%=classValue%>"> <%=drug_name%></td>
					<td class="<%=classValue%>"> <%=drug_duration%><%if(!drug_code.equals("")){%><br><a href="javascript:;" onClick='return loadDrugInfo("<%=drug_code%>","<%=drug_name%>")'><img src='../../ePH/images/info.gif' width='15' height='15'></img></a><%}%></td>
				</tr>
<%
				j++;
			}
%>
			</table>
			</div>
	<%	
		}//end if 5
		else if(content_id.equals("6") && checkBoxClick.equals("Y"))
		{
			found =false;;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
			sql = new StringBuffer();
		
			sql.append( "Select PATIENT_CLASS, " );
			sql.append("DECODE (assign_care_locn_type,");
	        sql.append("'N', IP_GET_DESC.IP_NURSING_UNIT(facility_id,assign_care_locn_code,?,'1'),");
			sql.append("OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,?,'1')) LOCATION_DESC,"); 
			sql.append("AM_GET_DESC.AM_SPECIALITY(pr_encounter.SPECIALTY_CODE,?,'2') Short_desc,"); 
			sql.append("AM_GET_DESC.AM_PRACTITIONER(attend_practitioner_id,?,'2') ");
			sql.append("practitioner_name,");
			sql.append("to_char(sm_convert_date(visit_adm_date_time,'"+locale+"'),'dd/mm/yyyy') visit_date, ");
			sql.append("to_char(TRUNC(SYSDATE-VISIT_ADM_DATE_TIME))||' days' LOS " );
			sql.append(" from pr_encounter where facility_id=? " );
			
			if(encounter_id == null || encounter_id.equals(""))
			{
				sql.append(" and (facility_id,encounter_id) in (select facility_id,encounter_id from (select facility_id,encounter_id, ROW_NUMBER() OVER (order by visit_adm_date_time desc) RANK_NO  from  pr_encounter where patient_id= ?) where RANK_NO < 2)" );
			}
			else
			{
				sql.append(" and encounter_id=? " );
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, locale );
			pstmt.setString(2, locale );
			pstmt.setString(3, locale );
			pstmt.setString(4, locale );
			pstmt.setString(5, facility_id );
			
			if(encounter_id == null || encounter_id.equals(""))
			{
				pstmt.setString(6, patient_id );
			}
			else
			{
				pstmt.setString(6, encounter_id );
			}
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
				if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, locale );
			pstmt.setString(2, locale );
			pstmt.setString(3, locale );
			pstmt.setString(4, locale );
			pstmt.setString(5, facility_id  );

			if(encounter_id.equals(""))
			{
				pstmt.setString(6, patient_id );
			}
			else
			{
				pstmt.setString(6, encounter_id );
			}

			rset=pstmt.executeQuery();
%>

			<div id="six">
			<br> <br> <br>
			<a name="6">
			<table width="100%" class = 'grid'>
				<tr>
					<td class='columnheader' style="background-color: black; color: white;" colspan="6" > <input type="checkbox" name="chk6" id="chk6" checked><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="eCA.LOS.label" bundle="${ca_labels}"/></td>
				</tr>
				<%
				while(rset.next())
				{
					classValue = "gridData" ;
					
					location_desc= rset.getString("location_desc")==null?"":rset.getString("location_desc");
					speciality =  rset.getString("short_desc")==null?"":rset.getString("short_desc");
					practitioner_name =  rset.getString("practitioner_name")==null?"":rset.getString("practitioner_name");
						
					visit_date =  rset.getString("visit_date")==null?"":rset.getString("visit_date");

					los =  rset.getString("los")==null?"":rset.getString("los");

			%>
					<tr>
						<td class="<%=classValue%>"> <%=location_desc%> </td>
						<td class="<%=classValue%>"> <%=speciality%> </td>
						<td class="<%=classValue%>"> <%=practitioner_name%> </td>
						<td class="<%=classValue%>"> <%=visit_date%> </td>
						<td class="<%=classValue%>"> <%=los%> </td>
					</tr>
				<%
				 j++;
				}%>
			</table>
		</div>
	<%			
		}// end if 6	
		else if(content_id.equals("7") && checkBoxClick.equals("Y"))
		{
			found = false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			String error_yn = "";
			sql = new StringBuffer();
			
			sql.append( "Select a.proc_narration  proc_name,");
			sql.append("AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') practitioner_name,");
			sql.append( "to_char(proc_date,'dd/mm/yyyy hh24:mi') ");
			sql.append( "proc_date,proc_date dummydate, a.ERROR_YN error_yn from ");
			sql.append( "pr_encounter_procedure a ");
			sql.append( "where a.facility_id = ? and a.PATIENT_ID = ? ");
			sql.append( "order by dummydate desc");

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,patient_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
				if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,patient_id);			
			rset=pstmt.executeQuery();
			%>

			<div id="seven">
			<br> <br> <br>
			<a name="7">
			<table width="100%" class = 'grid'>
				<tr>
					<td class='columnheader' style="background-color: black; color: white;"colspan="3" > <input type="checkbox" name="chk7" id="chk7" checked> <fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> <fmt:message key="Common.Performed.label" bundle="${common_labels}"/><%=titlemsg%></td>
				</tr>
				
				<tr>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.Performed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.PerformedOn.label" bundle="${common_labels}"/>  </td>
				</tr>
				<%
				while(rset.next())
				{
					classValue = "gridData" ;

					proc_name = rset.getString("proc_name")==null?"":rset.getString("proc_name");
					practitioner_name= rset.getString("practitioner_name")==null?"":rset.getString("practitioner_name");		proc_date= rset.getString("proc_date")==null?"":rset.getString("proc_date");
					if(!locale.equals("en"))
					  proc_date=com.ehis.util.DateUtils.convertDate(proc_date,"DMYHM","en",locale);
					error_yn= rset.getString("error_yn")==null?"N":rset.getString("error_yn");

					if(!error_yn.equals("Y"))
					{
				%>
					<tr>
						 <td class="<%=classValue%>"> <%=proc_name%> </td>
						<td class="<%=classValue%>"> <%=practitioner_name%> </td>
						<td class="<%=classValue%>"> <%=proc_date%> </td>
					</tr>
				<%}
				  j++;
				}%>
			</table>
			</div>
	<%
		} // end if 7
		else if(content_id.equals("8") && checkBoxClick.equals("Y"))
		{
			found =false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			sql = new StringBuffer();
			
			sql.append("Select MR_GET_DESC.MR_HIGH_RISK(a.high_risk_code,?,'1') long_desc, to_char(sm_convert_date(a.onset_date,'"+locale+"'),'dd/mm/yyyy')");
			sql.append(" onset_date from pr_high_risk_condition a ");
			sql.append("where a.patient_id =? and a.close_date is null");

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
			if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}


			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);	
			rset=pstmt.executeQuery();


			%>
			
			<div id="eight">
			<br> <br> <br>
			<a name="8">
			<table width="100%" class = 'grid'>
				<tr>
					<td class='columnheader' colspan="4" align="left" style="background-color: black; color: white;"> <input type="checkbox" name="chk8" id="chk8" checked><fmt:message key="Common.HighRisk.label" bundle="${common_labels}"/><%=titlemsg%></td>
				</tr>
				
				<tr>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.HighRiskConditions.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' style="background-color: black; color: white;"><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
				</tr>
				
				<%
				while(rset.next())
				{
					classValue = "gridData" ;

					long_desc = rset.getString("long_desc")==null?"":rset.getString("long_desc");
					onset_date= rset.getString("onset_date")==null?"":rset.getString("onset_date");	
					

				%>
					<tr>
						<td class="<%=classValue%>"> <%=long_desc%> </td>
						<td class="<%=classValue%>"> <%=onset_date%> </td>						
					</tr>
				<%
				j++;
				}
				%>
			</table>
			</div>
		<%//}%>

	<%
		}
		else if(content_id.equals("9") && checkBoxClick.equals("Y"))
		{
			found =false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			sql = new StringBuffer();
			sql1 = new StringBuffer();
			
			sql1.append("select  DIAGNOSIS  from PR_REFERRAL_REGISTER a, PR_ENCOUNTER B where B.FACILITY_ID=? and  B.ENCOUNTER_ID =? AND A.REFERRAL_ID=B.REFERRAL_ID ");

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt=con.prepareStatement(sql1.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
				if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql1.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);			
			rset=pstmt.executeQuery();
			%>
			
			<div id="nine">
			<br> <br> <br>
			<a name="9">
			<table width="100%" class = 'grid'>
				 <tr>
					<td class='columnheader' colspan="4" style="background-color: black; color: white;" align="left"> <input type="checkbox" name="chk9" id="chk9" checked><fmt:message key="Common.ReferralDiagnosis.label" bundle="${common_labels}"/><%=titlemsg%></td>
				</tr>
			   <%
				while(rset.next())
				{
					classValue = "gridData" ;

					diagnosis = rset.getString("diagnosis")==null?"":rset.getString("diagnosis");
					

				%>
					<tr>
						<td class="<%=classValue%>"><%=diagnosis%> </td>
								
					</tr>
				<%
					j++;
				}%>
			</table>
			</div>
		<%//}%>

	<%
	
		}
		
		else if(content_id.equals("10") && checkBoxClick.equals("Y"))
		{
			found =false;
			titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			sql = new StringBuffer();
			
			sql.append("SELECT A.GENO_ID, A.SRL_NO, A.PATIENT_ID, A.NON_PATIENT_ID, A.NAME, A.SEX, DECODE(A.SEX,'M','Male','F','Female','U','Unknown') SEX_DESC, A.DATE_OF_BIRTH, CA_GET_AGE(A.DATE_OF_BIRTH,SYSDATE,'YMD') AGE FROM CA_GENOGRAM_ATTRIBUTE A, CA_GENOGRAM_ATTRIBUTE B WHERE A.GENO_ID=B.GENO_ID AND B.PATIENT_ID=?");
			

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());
			
			pstmt.setString(1,patient_id);			
			rset=pstmt.executeQuery();

			if(rset.next())
			{
				found=true;
				titlemsg = "";
				k++;
			}
			if(k==0)
			{
				found=false;
				titlemsg = ": "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
			}


			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql.toString());			
			pstmt.setString(1,patient_id);	
			rset=pstmt.executeQuery();


			%>
			
			<div id="eight">
			<br> <br> <br>
			<a name="8">
			<table width="100%" class = 'grid'>
				<tr>
					<td class='columnheader' style="background-color: black; color: white;" colspan="5" align="left"> <input type="checkbox" name="chk10" id="chk10" checked>Family Members<%=titlemsg%></td>
				</tr>
				
				<tr>					
					<th class='columnHeadercenter' style="background-color: black; color: white;" width="15%">Patient ID </th>
					<th class='columnHeadercenter' style="background-color: black; color: white;" width="15%">NON Patient ID </th>
					<th class='columnHeadercenter' style="background-color: black; color: white;" width="40%">Patient Name </th>
					<th class='columnHeadercenter' style="background-color: black; color: white;" width="15%">Age </th>
					<th class='columnHeadercenter' style="background-color: black; color: white;" width="15%">Gender </th>
				</tr>
				
				<%
				while(rset.next())
				{
					classValue = "gridData" ;
				%>
					<tr>						
						<td class='<%=classValue%>' ><%=rset.getString("PATIENT_ID")==null?"":(String)rset.getString("PATIENT_ID") %>&nbsp;</td>
						<td class='<%=classValue%>' ><%=rset.getString("NON_PATIENT_ID")==null?"":(String)rset.getString("NON_PATIENT_ID") %>&nbsp;</td>
						<td class='<%=classValue%>' ><%=rset.getString("NAME")==null?"":(String)rset.getString("NAME") %>&nbsp;</td>
						<td class='<%=classValue%>' ><%=rset.getString("AGE")==null?"":(String)rset.getString("AGE") %>&nbsp;</td>
						<td class='<%=classValue%>' ><%=rset.getString("SEX_DESC")==null?"":(String)rset.getString("SEX_DESC") %>&nbsp;</td>
					</tr>
				<%
				j++;
				}
				%>
			</table>
			</div>
		<%//}%>

	<%
		}
		counter++;
	} //while
	if(patient_profile.equals("P"))
	{
	   if(j==0)
		{
			out.println("<script>alert('APP-002415 Query caused no records to be retrieved')</script>");
		 }
	}
	
%>
</div>
<input type=hidden name=counter value="<%=counter%>">
</form>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%
	if(oRs!=null) oRs.close();
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception @ 3444"+e.toString());//common-icn-0181
	e.printStackTrace();
}
finally
{	
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>






