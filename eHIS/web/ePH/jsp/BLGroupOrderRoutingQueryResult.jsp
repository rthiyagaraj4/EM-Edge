<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page
		String ordering_facility_id		= request.getParameter( "ordering_facility_id" );
		String ordering_source_type		= request.getParameter( "ordering_source_type" ) ;
		String ordering_source_code		= request.getParameter( "ordering_source_code" ) ;
		String ordering_source_desc		= request.getParameter( "ordering_source_desc" ) ;
		String routing_level			= request.getParameter( "routing_level" ) ;
		String billing_group			= request.getParameter( "billing_group" ) ;
		String customer_group			= request.getParameter( "customer_group" ) ;
		String customer_id			    = request.getParameter( "customer_id" ) ;
		String polocy_type			    = request.getParameter( "polocy_type" ) ;
		String routing_code = "";

		if(routing_level != null && routing_level.equals("G"))
					{
			routing_code	= request.getParameter( "drug_code");
			if(routing_code == null || routing_code.equals(""))
				routing_code	= request.getParameter( "drug_desc");
		}
		else if(routing_level != null && routing_level.equals("M")){
			routing_code	= request.getParameter( "drug_code");
			if(routing_code == null || routing_code.equals(""))
				routing_code	= request.getParameter( "drug_desc");
		}
		else{
			routing_code	= request.getParameter( "routing_code" ) ;
		}
		if(routing_code.indexOf(":")>=0){
			routing_code = routing_code.substring(0,routing_code.indexOf(":"));
		}

		String rtn_ord_disp_locn_code   = request.getParameter( "rtn_ord_disp_locn_code" );
		//String rtn_ord_disp_locn_desc   = request.getParameter( "rtn_ord_disp_locn_desc" );
		String stat_ord_disp_locn_code  = request.getParameter( "stat_ord_disp_locn_code" );
		//String stat_ord_disp_locn_desc  = request.getParameter( "stat_ord_disp_locn_desc" );
		String disch_ord_disp_locn_code = request.getParameter( "disch_ord_disp_locn_code" );
		//String disch_ord_disp_locn_desc = request.getParameter( "disch_ord_disp_locn_desc" );

		//String ord[]				= request.getParameterValues("orderbycolumns");
		String strRoutingLevel		= "S";
		
		if (ordering_source_type.equals("B")){
			ordering_source_type = "";
		}

		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			= "";
			String orderingSourceType	= "";

			ordering_facility_id = CommonBean.checkForNull( ordering_facility_id.trim() );
			ordering_source_type = CommonBean.checkForNull( ordering_source_type.trim() );
			ordering_source_code = CommonBean.checkForNull( ordering_source_code.trim() );
			ordering_source_desc = CommonBean.checkForNull( ordering_source_desc.trim() );
			routing_level		 = CommonBean.checkForNull( routing_level.trim() );
			routing_code		 = CommonBean.checkForNull( routing_code.trim() );
			rtn_ord_disp_locn_code	= CommonBean.checkForNull( rtn_ord_disp_locn_code.trim() );
			stat_ord_disp_locn_code = CommonBean.checkForNull( stat_ord_disp_locn_code.trim() );
			disch_ord_disp_locn_code= CommonBean.checkForNull( disch_ord_disp_locn_code.trim() );
			 if(routing_level.equals(""))	   {
				if (ordering_source_type.equals("N")||ordering_source_type.equals("D"))
					orderingSourceType = " and a.ordering_source_type = 'N'"; 
				else if (ordering_source_type.equals("E")||ordering_source_type.equals("C"))
					orderingSourceType = " and a.ordering_source_type = 'C'"; 
				else
					orderingSourceType = "";
			}
			String abc="SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' ELSE CASE WHEN i.patient_class = 'IP'  and a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN k.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN k.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL THEN 'Nursing Unit' END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C'THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, r.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code,s.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code, d.short_desc disch_ord_disp_locn_desc, a.BLNG_GRP_ID, a.CUST_GROUP_CODE, a.CUST_CODE,a.POLICY_TYPE_CODE,bg.short_desc billing_group_desc,bcg.short_desc customer_group,bc.short_name customer_id,bp.short_desc billing_polocy FROM ph_blgroup_order_routing a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw r,ph_disp_locn_lang_vw s,ph_disp_locn_lang_vw d,am_care_locn_type k,bl_blng_grp_lang_vw bg,ar_cust_group_lang_vw bcg, ar_customer_lang_vw bc, bl_ins_policy_types bp WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = r.facility_id AND a.rtn_ord_disp_locn_code = r.disp_locn_code AND a.performing_facility_id = s.facility_id AND a.stat_ord_disp_locn_code = s.disp_locn_code AND a.performing_facility_id = d.facility_id AND a.disch_ord_disp_locn_code = d.disp_locn_code AND a.BLNG_GRP_ID = bg.blng_grp_id  AND a.CUST_GROUP_CODE = bcg.cust_group_code(+) AND a.CUST_CODE = bc.cust_code(+) AND a.POLICY_TYPE_CODE = bp.policy_type_code(+) AND h.clinic_type = k.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR DECODE (?, 'N', a.ordering_source_code, NULL) IN (select '*A' from dual where a.ordering_source_type='N' union SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')OR DECODE (?, 'D', a.ordering_source_code, NULL) IN (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC') OR DECODE (?, 'C', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))OR DECODE (?, 'E', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E'))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND UPPER (a.rtn_ord_disp_locn_code) LIKE UPPER (?)AND UPPER (a.stat_ord_disp_locn_code) LIKE UPPER (?) AND UPPER (a.disch_ord_disp_locn_code) LIKE UPPER (?) AND NVL (a.BLNG_GRP_ID, 'X') LIKE UPPER(?) AND NVL (a.CUST_GROUP_CODE, 'X') LIKE UPPER(?) AND NVL (a.CUST_CODE, 'X') LIKE UPPER(?) AND NVL (a.POLICY_TYPE_CODE, 'X') LIKE UPPER(?)   and b.language_id = ? and c.language_id(+) =? and h.language_id(+) = ? and i.language_id(+) = ? and r.language_id(+) = ? and s.language_id(+) = ? and d.language_id(+) = ? AND bg.language_id(+) = ? AND bcg.language_id(+) =? AND bc.language_id(+) = ? "; 

			String abc1="SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' 	   ELSE CASE  WHEN i.patient_class = 'IP' AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN p.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN p.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'C' THEN 'Clinic' END END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, j.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code, k.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code, l.short_desc disch_ord_disp_locn_desc, a.routing_code,DECODE (a.routing_level,'G', UPPER (m.drug_desc),'O', UPPER (n.short_desc),'M',UPPER (m.drug_desc),'D', DECODE (a.routing_code,'G', 'General','N', 'Narcotic','C', 'Controlled')) routing_code_desc,a.routing_level,a.blng_grp_id,a.cust_group_code,a.cust_code,a.policy_type_code,bg.short_desc billing_group_desc,bcg.short_desc customer_group,bc.short_name customer_id,bp.short_desc billing_polocy FROM ph_blgroup_order_routing_dtl a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw j,ph_disp_locn_lang_vw k,ph_disp_locn_lang_vw l,ph_drug_lang_vw m,or_order_type_lang_vw n,am_care_locn_type p,bl_blng_grp_lang_vw bg,ar_cust_group_lang_vw bcg, ar_customer_lang_vw bc, bl_ins_policy_types bp WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = j.facility_id AND a.rtn_ord_disp_locn_code = j.disp_locn_code AND a.performing_facility_id = k.facility_id AND a.stat_ord_disp_locn_code = k.disp_locn_code AND a.performing_facility_id = l.facility_id(+) AND a.disch_ord_disp_locn_code = l.disp_locn_code(+) AND a.blng_grp_id = bg.blng_grp_id  AND a.cust_group_code = bcg.cust_group_code(+) AND a.cust_code = bc.cust_code(+) AND a.policy_type_code = bp.policy_type_code(+) AND h.clinic_type = p.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR a.ordering_source_type = 'N' AND DECODE (?, 'N', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')) OR a.ordering_source_type = 'N' AND DECODE (?, 'D', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC')) OR a.ordering_source_type = 'C' AND DECODE (?, 'C', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))) OR a.ordering_source_type = 'C' AND DECODE (?, 'E', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E')))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END) ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND a.routing_level LIKE UPPER (?)   AND a.routing_code LIKE UPPER (?) AND a.routing_code = m.drug_code(+) AND a.routing_code = n.order_type_code(+) AND a.rtn_ord_disp_locn_code LIKE ? AND a.stat_ord_disp_locn_code LIKE ? AND NVL (a.disch_ord_disp_locn_code, 'X') LIKE ?  AND NVL (a.BLNG_GRP_ID, 'X') LIKE UPPER(?) AND NVL (a.CUST_GROUP_CODE, '*A') LIKE UPPER(?) AND NVL (a.CUST_CODE, '*A') LIKE UPPER(?) AND NVL (a.POLICY_TYPE_CODE, '*A') LIKE UPPER(?) and b.language_id = ? and c.language_id(+) = ? and h.language_id(+) = ? and i.language_id(+) = ? and j.language_id(+) = ? and k.language_id(+) = ? and l.language_id(+) = ? and m.language_id(+) = ? and n.language_id(+) = ? AND bg.language_id(+) = ? AND bcg.language_id(+) =? AND bc.language_id(+) = ?";//X replaced *A for MMS interanal issue  

			String all =" SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' ELSE CASE WHEN i.patient_class = 'IP' AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN k.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN k.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL THEN 'Nursing Unit' END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C'THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, r.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code,s.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code, d.short_desc disch_ord_disp_locn_desc,a.BLNG_GRP_ID, a.CUST_GROUP_CODE, a.CUST_CODE,a.POLICY_TYPE_CODE, bg.short_desc billing_group_desc,bcg.short_desc customer_group, bc.short_name customer_id,bp.short_desc billing_polocy, 'S' routing_level,'' routing_code  , '' routing_code_desc  FROM PH_BLGROUP_ORDER_ROUTING a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw r,ph_disp_locn_lang_vw s,ph_disp_locn_lang_vw d,am_care_locn_type k,BL_BLNG_GRP_LANG_VW BG,AR_CUST_GROUP_LANG_VW BCG,AR_CUSTOMER_LANG_VW BC,BL_INS_POLICY_TYPES BP WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = r.facility_id AND a.rtn_ord_disp_locn_code = r.disp_locn_code AND a.performing_facility_id = s.facility_id AND a.stat_ord_disp_locn_code = s.disp_locn_code AND a.performing_facility_id = d.facility_id AND a.disch_ord_disp_locn_code = d.disp_locn_code   AND a.BLNG_GRP_ID = bg.blng_grp_id AND a.CUST_GROUP_CODE = bcg.cust_group_code(+) AND a.CUST_CODE = bc.cust_code(+) AND a.POLICY_TYPE_CODE = bp.policy_type_code(+) AND h.clinic_type = k.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR DECODE (?, 'N', a.ordering_source_code, NULL) IN (select '*A' from dual where a.ordering_source_type='N' union SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')OR DECODE (?, 'D', a.ordering_source_code, NULL) IN (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC') OR DECODE (?, 'C', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))OR DECODE (?, 'P', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E'))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND UPPER (a.rtn_ord_disp_locn_code) LIKE UPPER (?)AND UPPER (a.stat_ord_disp_locn_code) LIKE UPPER (?) AND UPPER (a.disch_ord_disp_locn_code) LIKE UPPER (?) AND NVL (a.BLNG_GRP_ID, '*A') LIKE UPPER(?) AND NVL (a.CUST_GROUP_CODE, '*A') LIKE UPPER(?) AND NVL (a.CUST_CODE, '*A') LIKE UPPER(?) AND NVL (a.POLICY_TYPE_CODE, '*A') LIKE UPPER(?) and b.language_id = ? and c.language_id(+) =? and h.language_id(+) = ? and i.language_id(+) = ? and r.language_id(+) = ? and s.language_id(+) = ? and d.language_id(+) = ? AND bg.language_id(+) = ? AND bcg.language_id(+) =? AND bc.language_id(+) = ?  "+orderingSourceType +" union all SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' 	   ELSE CASE  WHEN i.patient_class = 'IP' AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN p.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN p.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'C' THEN 'Clinic' END END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, j.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code, k.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code,l.short_desc disch_ord_disp_locn_desc, A.BLNG_GRP_ID,A.CUST_GROUP_CODE,A.CUST_CODE,A.POLICY_TYPE_CODE,BG.SHORT_DESC billing_group_desc,BCG.SHORT_DESC customer_group, BC.SHORT_NAME customer_id,BP.SHORT_DESC billing_polocy,a.routing_level,a.routing_code,DECODE (a.routing_level,'G', UPPER (m.drug_desc),'O', UPPER (n.short_desc),'M',UPPER (m.drug_desc),'D', DECODE (a.routing_code,'G', 'General','N', 'Narcotic','C', 'Controlled')) routing_code_desc FROM PH_BLGROUP_ORDER_ROUTING_DTL a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw j,ph_disp_locn_lang_vw k,ph_disp_locn_lang_vw l,ph_drug_lang_vw m,or_order_type_lang_vw n,am_care_locn_type p, BL_BLNG_GRP_LANG_VW BG, AR_CUST_GROUP_LANG_VW BCG, AR_CUSTOMER_LANG_VW BC, BL_INS_POLICY_TYPES BP WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = j.facility_id AND a.rtn_ord_disp_locn_code = j.disp_locn_code AND a.performing_facility_id = k.facility_id AND a.stat_ord_disp_locn_code = k.disp_locn_code AND a.performing_facility_id = l.facility_id(+) AND a.disch_ord_disp_locn_code = l.disp_locn_code(+)  AND a.BLNG_GRP_ID = BG.BLNG_GRP_ID AND A.CUST_GROUP_CODE = BCG.CUST_GROUP_CODE(+) AND A.CUST_CODE = BC.CUST_CODE(+) AND A.POLICY_TYPE_CODE = BP.POLICY_TYPE_CODE(+) AND h.clinic_type = p.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR a.ordering_source_type = 'N' AND DECODE (?, 'N', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')) OR a.ordering_source_type = 'N' AND DECODE (?, 'D', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC')) OR a.ordering_source_type = 'C' AND DECODE (?, 'C', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))) OR a.ordering_source_type = 'C' AND DECODE (?, 'E', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E')))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END) ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND a.routing_level LIKE UPPER (?)   AND a.routing_code LIKE UPPER (?) AND a.routing_code = m.drug_code(+) AND a.routing_code = n.order_type_code(+) AND a.rtn_ord_disp_locn_code LIKE ? AND a.stat_ord_disp_locn_code LIKE ? AND NVL (a.disch_ord_disp_locn_code, 'X') LIKE ? AND NVL (a.BLNG_GRP_ID, 'X') LIKE UPPER(?) AND NVL (a.CUST_GROUP_CODE, 'X') LIKE UPPER(?) AND NVL (a.CUST_CODE, 'X') LIKE UPPER(?) AND NVL (a.POLICY_TYPE_CODE, 'X') LIKE UPPER(?) and b.language_id = ? and c.language_id(+) = ? and h.language_id(+) = ? and i.language_id(+) = ? and j.language_id(+) = ? and k.language_id(+) = ? and l.language_id(+) = ? and m.language_id(+) = ? and n.language_id(+) = ?  AND BG.language_id(+) = ? AND BCG.language_id(+) = ? AND BC.language_id(+) = ? "; 

			HashMap sqlMap = new HashMap();
			if (routing_level.equals("S")){
				if (ordering_source_type.equals("N")||ordering_source_type.equals("D"))
					abc += " and a.ordering_source_type = 'N'"; 
				else if (ordering_source_type.equals("E")||ordering_source_type.equals("C"))
					abc += " and a.ordering_source_type = 'C'"; 
				else
					abc += "";
				sqlMap.put( "sqlData",abc);
			} 
			else if(routing_level.equals(""))	   {
				if (ordering_source_type.equals("N")||ordering_source_type.equals("D"))
					all += " and a.ordering_source_type = 'N'"; 
				else if (ordering_source_type.equals("E")||ordering_source_type.equals("C"))
					all += " and a.ordering_source_type = 'C'"; 
				else
					all += "";

				sqlMap.put( "sqlData",all);
			}
			else{
				strRoutingLevel = "ODGLMH";
				sqlMap.put( "sqlData", abc1);
			}
			//Function Parameters
			HashMap funcMap = new HashMap();
			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "ordering_facility_name"); //0
			displayFields.add( "ordering_facility_id" );
			displayFields.add( "location_type");//location_type
			displayFields.add( "ordering_source_code" );
			displayFields.add( "ordering_source_desc" );
			if (!routing_level.equals("S")){	
				displayFields.add( "routing_level"); //5
				displayFields.add( "routing_code" );
				displayFields.add( "routing_code_desc" ); //7
			}
			displayFields.add( "rtn_ord_disp_locn_desc" );
			displayFields.add( "stat_ord_disp_locn_desc" );
			displayFields.add( "disch_ord_disp_locn_desc" );
			displayFields.add( "billing_group_desc" );
			displayFields.add( "customer_group" );
			displayFields.add( "customer_id" );
			displayFields.add( "billing_polocy" );
			displayFields.add( "BLNG_GRP_ID" );
			displayFields.add( "CUST_GROUP_CODE" );
			displayFields.add( "CUST_CODE" );
			displayFields.add( "POLICY_TYPE_CODE" );

			ArrayList chkFields = new ArrayList();
			
			if(routing_level.equals("S")){
				chkFields.add( ordering_facility_id.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_code.trim() + "%" );
				chkFields.add( ordering_source_desc.trim() + "%" );	
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );
				chkFields.add( billing_group.trim() + "%" );
				chkFields.add( customer_group.trim() + "%" );
				chkFields.add( customer_id.trim() + "%" );
				chkFields.add( polocy_type.trim() + "%" );
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
			}
			else if(routing_level.equals(""))	{
				chkFields.add( ordering_facility_id.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_code.trim() + "%" );
				chkFields.add( ordering_source_desc.trim() + "%" );	
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );
				chkFields.add( billing_group.trim() + "%" );
				chkFields.add( customer_group.trim() + "%" );
				chkFields.add( customer_id.trim() + "%" );
				chkFields.add( polocy_type.trim() + "%" );
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add( ordering_facility_id.trim());//1
				chkFields.add( ordering_source_type.trim());//2
				chkFields.add( ordering_source_type.trim());//3
				chkFields.add( ordering_source_type.trim());//4
				chkFields.add( ordering_source_type.trim());//5
				chkFields.add( ordering_source_type.trim());//6
				chkFields.add( ordering_source_code.trim() + "%" );//7
				chkFields.add( ordering_source_desc.trim() + "%" );//8		
				chkFields.add( routing_level.trim()+ "%" );//9
				chkFields.add( routing_code.trim()+ "%" );//10
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );//11
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );//12
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );//13
				chkFields.add( billing_group.trim() + "%" );
				chkFields.add( customer_group.trim() + "%" );
				chkFields.add( customer_id.trim() + "%" );
				chkFields.add( polocy_type.trim() + "%" );
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
			}
			else{
				chkFields.add( ordering_facility_id.trim());//1
				chkFields.add( ordering_source_type.trim());//2
				chkFields.add( ordering_source_type.trim());//3
				chkFields.add( ordering_source_type.trim());//4
				chkFields.add( ordering_source_type.trim());//5
				chkFields.add( ordering_source_type.trim());//6
				chkFields.add( ordering_source_code.trim() + "%" );//7
				chkFields.add( ordering_source_desc.trim() + "%" );//8		
				chkFields.add( routing_level.trim()+ "%" );//9
				chkFields.add( routing_code.trim()+ "%" );//10
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );//11
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );//12
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );//13
				chkFields.add( billing_group.trim() + "%" );
				chkFields.add( customer_group.trim() + "%" );
				chkFields.add( customer_id.trim() + "%" );
				chkFields.add( polocy_type.trim() + "%" );
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
			}
			

			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext, sqlMap, funcMap,request);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
				String link_columns ="", dkVal="", bl_group_id="",bl_cust_group_id="",bl_cust_id="",bl_polocy_id="";
%>
				<form name='OrderRoutingQueryResult' id='OrderRoutingQueryResult'>
				<table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr>
						<td width="80%" class="white">&nbsp;</td>
						<td width="20%" class="white">&nbsp;
<%
				// For display the previous/next link
						out.println(result.get(1));
%>
						</td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
					<tr >
						<th  width='18%'><fmt:message key="Common.OrderingFacilityName.label" bundle="${common_labels}"/></th>
						<th  width='8%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
						<th  width='8%'><fmt:message key="Common.LocationName.label" bundle="${common_labels}"/></th>
<%
						if (!routing_level.equals("S")){
%>
							<th width='10%'><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/></th>
							<th width='10%'><fmt:message key="ePH.RoutingCodeDesc.label" bundle="${ph_labels}"/></th>
<%
						}
%>
						<th width='10%'> <fmt:message key="ePH.RoutineOrders.label" bundle="${ph_labels}"/></th>
						<th width='10%'><fmt:message key="ePH.StatOrder.label" bundle="${ph_labels}"/></th>
						<th width='10%'><fmt:message key="ePH.DischargeMedicationOrders.label" bundle="${ph_labels}"/></th>
					    <th width='10%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></th>
						<th width='10%'><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/></th>
						<th width='10%'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></th>
						<th width='10%'><fmt:message key="ePH.PolicyType.label" bundle="${ph_labels}"/></th>
					</tr>
					
<%
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
%>
						<tr onClick="Modify(this,'<%=recCount%>');" >
<%
						link_columns ="";
						if (routing_level.equals("S")){
							link_columns = "1,3,5";
						}
						else{
							link_columns = "1,3,5,6,8";
						}
						records=(ArrayList) result.get( recCount );
						if(!routing_level.equals("S")){
							bl_group_id=(String)records.get(15)==null?"":(String)records.get(15);
							bl_cust_group_id=(String)records.get(16)==null?"":(String)records.get(16);
							bl_cust_id=(String)records.get(17)==null?"":(String)records.get(17);
							bl_polocy_id=(String)records.get(18)==null?"":(String)records.get(18);
						}
						else{
							bl_group_id=(String)records.get(12)==null?"":(String)records.get(12);
							bl_cust_group_id=(String)records.get(13)==null?"":(String)records.get(13);
							bl_cust_id=(String)records.get(14)==null?"":(String)records.get(14);
							bl_polocy_id=(String)records.get(15)==null?"":(String)records.get(15);
						}
						for(int colCount=0; colCount<records.size()-4; colCount++){
							
							if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
								dkVal = (String)records.get( colCount );
								
								if (dkVal== null)
									dkVal = "";
								else
									dkVal = dkVal;					
							if(colCount==7 && (routing_level.equals("") || routing_level.equals("L") ||  routing_level.equals("H"))){						  
								dkVal = (String)records.get( colCount-1);
								if(dkVal == null) {
									dkVal = "";
								}
								if(dkVal.equals("G")) {
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.general.label", "common_labels");
								}
								if(dkVal.equals("N")) {
									dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Narcotics.label", "ph_labels");
								}
								if(dkVal.equals("C")) {
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Controlled.label", "ph_labels");
								}
								if(dkVal.equals("ALLD")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllDirectOrders.label", "ph_labels");
								}
								else if(dkVal.equals("ALLA")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllAdmixtures.label", "ph_labels");
								}
								else if(dkVal.equals("CMPA")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompoundingOrder.label", "ph_labels");
								}
								else if(dkVal.equals("IVOD")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderDirect.label", "ph_labels");
								}
								else if(dkVal.equals("IVOA")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderAdmixture.label", "ph_labels");
								}
								else if(dkVal.equals("ONCD")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderDirect.label", "ph_labels");
								}
								else if(dkVal.equals("ONCA")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderAdmixture.label", "ph_labels");
								}
								else if(dkVal.equals("TPND")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNStandardRegimen.label", "ph_labels");
								}
								else if(dkVal.equals("TPNA")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNNONStandardRegimen.label", "ph_labels");
								}
								else {
									dkVal =dkVal = (String)records.get(colCount);//added for MMS Local Testing;
								}
							}
							if(dkVal == null) {
								dkVal = "";
							}
							if (dkVal.equals("*A")){
								dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AllLocations.label", "common_labels");
							}
							if ((colCount==2) && (dkVal.equals("N"))){
								dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.nursingUnit.label", "common_labels");
							}
							else if ((colCount==2) && (dkVal.equals("C"))){
								dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.clinic.label", "common_labels");
							}
							if (colCount==5){
%>
								<input type='hidden' name='routingLevel_<%=recCount%>' id='routingLevel_<%=recCount%>' value='<%=dkVal%>'/>
								<input type='hidden' name='bl_group_id_<%=recCount%>' id='bl_group_id_<%=recCount%>' value='<%=bl_group_id%>'/>
								<input type='hidden' name='bl_cust_group_id_<%=recCount%>' id='bl_cust_group_id_<%=recCount%>' value='<%=bl_cust_group_id%>'/>
								<input type='hidden' name='bl_cust_id_<%=recCount%>' id='bl_cust_id_<%=recCount%>' value='<%=bl_cust_id%>'/>
								<input type='hidden' name='bl_polocy_id_<%=recCount%>' id='bl_polocy_id_<%=recCount%>' value='<%=bl_polocy_id%>'/>
								
<%
								if((dkVal.equals("S")))
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.source.label", "common_labels");
								else if (dkVal.equals("O"))
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.OrderType.label", "common_labels");
								else if (dkVal.equals("D"))
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugClass.label", "ph_labels");
								else if (dkVal.equals("G"))
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Drug.label", "common_labels"); 
								else if (dkVal.equals("L"))
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SpecialOrders.label", "ph_labels");
								else if (dkVal.equals("M"))
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.MedicalItem.label","common_labels");
								else if (dkVal.equals("H")) 
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.HomeLeave.label","ph_labels");
%>
								<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=dkVal%>&nbsp; </font></td>
<%
							}
							else{
								if(dkVal.equals("AllDirectOrders")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllDirectOrders.label", "ph_labels");
								}
								else if(dkVal.equals("AllAdmixtures")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllAdmixtures.label", "ph_labels");
								}
								else if(dkVal.equals("CompoundingOrder")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompoundingOrder.label", "ph_labels");
								}
								else if(dkVal.equals("IVOrderAdmixture")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderAdmixture.label", "ph_labels");
								}
								else if(dkVal.equals("IVOrderDirect")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderDirect.label", "ph_labels");
								}
								else if(dkVal.equals("OncologyOrderAdmixture")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderAdmixture.label", "ph_labels");
								}
								else if(dkVal.equals("OncologyOrderDirect")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderDirect.label", "ph_labels");
								}
								else if(dkVal.equals("TPNStandardRegimen")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNStandardRegimen.label", "ph_labels");
								}
								else if(dkVal.equals("TPNNONStandardRegimen")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNNONStandardRegimen.label", "ph_labels");
								}
%>
								<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=dkVal%>&nbsp; </font></td>
<%
							}
						}
						else if (colCount ==1 || colCount ==3 || (colCount==6 && !routing_level.equals("S"))){
							dkVal = (String)records.get( colCount );
							if(colCount ==3){
%>
								<input type='hidden' name='ordering_source_code_<%=recCount%>' id='ordering_source_code_<%=recCount%>' value='<%=dkVal%>'/>
<%
							}
%>
							<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=CommonBean.checkForNull((String)records.get( colCount ))%>" style="display:none">
<%
							out.println(dkVal);
							out.println("&nbsp;</td>"); 
							dkVal = "";	
						}
						else{	
							dkVal ="&nbsp;";
							if (records.get( colCount ) != null){
								dkVal = (String)records.get( colCount );
							}
							if (colCount==5){
%>
									<input type='hidden' name='routingLevel_<%=recCount%>' id='routingLevel_<%=recCount%>' value='S'/>
									<input type='hidden' name='bl_group_id_<%=recCount%>' id='bl_group_id_<%=recCount%>' value='<%=bl_group_id%>'/>
									<input type='hidden' name='bl_cust_group_id_<%=recCount%>' id='bl_cust_group_id_<%=recCount%>' value='<%=bl_cust_group_id%>'/>
									<input type='hidden' name='bl_cust_id_<%=recCount%>' id='bl_cust_id_<%=recCount%>' value='<%=bl_cust_id%>'/>
									<input type='hidden' name='bl_polocy_id_<%=recCount%>' id='bl_polocy_id_<%=recCount%>' value='<%=bl_polocy_id%>'/>
<%
								}		
								if(colCount==16 && routing_level.equals("S")){
%>
									<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>" >
<%
									if (dkVal.equals("*A")){
										dkVal = "All Locations";
									}
									out.println(dkVal);
									out.println("&nbsp;</td>"); 						
								}
								else if(!(colCount==13 && routing_level.equals("S"))){
%>
									<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>" >
<%
									if (dkVal.equals("*A")){
										dkVal = "All Locations";
									}
									out.println(dkVal);
									out.println("&nbsp;</td>"); 
									dkVal = "";	
								}
							} 
						}
%>
					<td style="display:none"><%=strRoutingLevel%>&nbsp;</td>
				</tr>
<%
			}
%>
			</table>
			</form>
<%
			out.flush();
		}
		else{
%>
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				document.location.href="../../ePH/jsp/BLGroupOrderRoutingQueryCriteria.jsp?function_id="+function_id ;
			</script>
<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/BLGroupOrderRoutingQueryResult.jsp", searched) );
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
%>
	</body>
</html>

