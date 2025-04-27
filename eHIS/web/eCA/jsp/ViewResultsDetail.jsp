<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
20/09/2012		PERF-1			Dinesh T	Check email dated 09/20/2012, added for performance tuning
03/06/2013	    EMG   			Chowminya G	PACS LIVE issue
18/12/2013		IN045966		Ramesh G	Bru-HIMS-CRF-391/10 --- Notes Confidentiality
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/09/2014 		IN050936	Chowminya							     	 None of the order retrieving any image from RIS/PACS but already having order image in PACS
07/10/2014		IN041153	Karthi											System is displaying 'Result' icon
30/01/2015  	IN053093		Nijitha S										ML-BRU-SCF-1515 
19/03/2015		IN052800		Karthi L										If link image for Histology orderable, from CA, user not able to view the image. No link appear under View.
07/07/2017		IN064688		Raja S			08/07/2017		RameshG			ML-MMOH-SCF-0753
07/02/2018		IN065970		Vijayakumar K	07/02/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970]
07/03/2018		IN065970		Vijayakumar K	07/03/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970] reopen
19/03/2018		IN067037		Raja S			19/03/2018		Ramesh G		ML-BRU-SCF-1787
26/02/2018		IN066119		Raja S			26/02/2018		Ramesh G		ML-MMOH-CRF-1024
07/06/2018		IN067651		Raja S			07/06/2018		Ramesh G		GHL-SCF-1338
03/02/2020		IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
15/12/2020		7902		Sivabagyam M		15/12/2020		Ramesh G	MMS-DM-CRF-0180.1
20/04/2021		6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
--------------------------------------------------------------------------------------------------------------------
--> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.sql.*,java.util.*, eOR.* ,java.math.*,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!-- Added math.* IN064688 -->
 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html> 
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../../eCA/js/ViewResult.js"></script>
 	<script language="JavaScript" src="../../eCA/js/CAOpenExternalApplication.js"></script>

	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<script>
		function alignWidth()
		{
			var last=eval(document.getElementById('detailTab').rows.length)-1;
				
			if(document.getElementById('detailTab')!=null)
			{
				for(i=0;i <document.getElementById('detailTab').rows(last).cells.length;i++)
				{
					var wid=document.getElementById('detailTab').rows(last).cells(i).offsetWidth;
					var wid1= parent.ReviewResultsHeader.document.getElementById('titleTab').rows(0).cells(i).offsetWidth;
						
					if(eval(wid1) <eval(wid))
						parent.ReviewResultsHeader.document.getElementById('titleTab').rows(0).cells(i).width=wid;
					else
						document.getElementById('detailTab').rows(last).cells(i).width = wid1;
				}
			}
		}
	</script>
	 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">     
<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet resultSet = null;
	ResultSet rs = null;

	StringBuffer tempNormCritStr = new StringBuffer();

	String details1 = "";
	
	String mode	= "1";

	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";
	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052800
	try { // added for IN041153
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String reln_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
    String user_id = (String)session.getValue("login_user");

	if(resp_id == null) resp_id = "";
	if (user_id == null) user_id = "";

	String priority		= CommonBean.checkForNull((String)request.getParameter("priority"));
	String normal_ind	= CommonBean.checkForNull((String)request.getParameter("normalcy_ind"));
	String result_type	= CommonBean.checkForNull((String)request.getParameter("result_type"));
	String patientId	= CommonBean.checkForNull((String)request.getParameter("patientId"));
	String event_class	= CommonBean.checkForNull((String)request.getParameter("event_class"));
	String group_by		= CommonBean.checkForNull((String)request.getParameter("groupby"));
	String ca_normalcy_ind	= CommonBean.checkForNull((String)request.getParameter("ca_normalcy_ind"));
	String modal            = CommonBean.checkForNull((String)request.getParameter("modal"));
	String period_from      = CommonBean.checkForNull((String)request.getParameter("period_from"));
	String period_to        = CommonBean.checkForNull((String)request.getParameter("period_to"));
	String encounter_id     = CommonBean.checkForNull((String)request.getParameter("encounter_id"));
	String curr_enc         = CommonBean.checkForNull((String)request.getParameter("curr_enc"));
	String status_crit      = CommonBean.checkForNull((String)request.getParameter("status_crit"));

	String legend_type = "";
	String color_cell_ind = "";
	String desc_cell_ind = "";
	String normal_range_symbol = "";
	String color_cell_indicator = "";
	String strNormalcyInd = "";
	String result_yn = "";
	String normalcy_str = "";
	String fac_id = "";//IN065970 reopen
	// added for IN041153 - Start
	Properties p			= (Properties)session.getValue("jdbc");
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");
	PreparedStatement pstmtImgView = null; 
	ResultSet resImgView = null; 
	PreparedStatement pstmtImgCount = null;
	PreparedStatement pstmtPerFacId = null;
	ResultSet rsetPerFacId = null;  
	ResultSet rsetImgCount = null; 
	int recCount = 0; 
	String ext_image_upld_id = ""; 
	String ext_img_file_locn = "";
	//IN066119 starts
	String facility_id= (String) session.getValue("facility_id");//IN066119
	String bean_id1 = "Or_ViewOrder" ;
	String bean_name1 = "eOR.ViewOrder";
	ViewOrder vbean = (ViewOrder)getBeanObject( bean_id1, bean_name1,request ) ;
	String hideSpecimenType = "N";
	HashMap orParamFac = new HashMap();
	String mainGrpDisable ="";
	//IN066119 ends
	// added for IN041153 - End
	boolean isPracSiteSpecific = false;//IN067651
	PreparedStatement pstmtImgView1 = null; //7902
	ResultSet resImgView1 = null;//7902
	String study_id="",ext_img_disable="",param_def_str="",ext_img_display="";//7902
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientId+encounter_id,"eCA.PatientBannerGroupLine",session); //IN052800
	ArrayList allValues = new ArrayList();

	String total_query_records = "0";
	String from	 = CommonBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = CommonBean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);

	int loop_start = start;

	ReviewResults bean = (ReviewResults)getBeanObject(bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	if (practitioner_id == null)
	{
	   String [] practitionerDetails = (String[])bean.getPractitionerDetails(user_id);
	   practitioner_id = practitionerDetails[0];
	}

	if(practitioner_id == null)practitioner_id = "";

	if(normal_ind == null) normal_ind = "";

	try
	{
		con =  ConnectionManager.getConnection(request);
		//IN066119 starts
		orParamFac=vbean.orParamFacility(con, facility_id);
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");
		//IN066119 ends
		//Added for IN067651 starts
		isPracSiteSpecific=eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");
		//Added for IN067651 starts
		boolean restrict_rd	=false;	//IN071561
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561

		stmt = con.prepareStatement("select VIEW_RESULT_DATETIME_YN from CA_ENCNTR_PARAM ");
		rs = stmt.executeQuery();
		if (rs.next())
		{
			result_yn = rs.getString(1) == null ? "N" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		StringBuffer SqlStr = new StringBuffer();
	
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix, result_num, result_num_uom, result_str, normal_low, normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN041153
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix, result_num, result_num_uom, result_str, normal_low, normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN041153
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix, result_num, result_num_uom, result_str, normal_low, normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN065970 facility id is added
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, result_num_uom, result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_low),TO_CHAR(normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_high),TO_CHAR(normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN065970 facility id is added//IN067037 //Commented for IN067651
		//6484 Start.
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, AM_GET_DESC.AM_PRACTITIONER(authorized_by_id,?,1) resulted_prac_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, result_num_uom, result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_low),TO_CHAR(normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_high),TO_CHAR(normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN065970 facility id is added//IN067037 //Modified for IN067651
		SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, AM_GET_DESC.AM_PRACTITIONER(authorized_by_id,?,1) resulted_prac_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, result_num_uom, result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_low),TO_CHAR(normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_high),TO_CHAR(normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and (dbms_lob.getlength(hist_data)>0 or dbms_lob.getlength(compress_hist_data)>0 ))  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); 
		//6484 end.
		if(!normal_ind.equals("") && (!normal_ind.equalsIgnoreCase("N"))) 
		{
			SqlStr.append(" and NORMALCY_IND in ($) ");	 
		}
		else
		{
			SqlStr.append("	AND NVL (normalcy_ind, '.') IN NVL ( $, NVL (normalcy_ind, '.'))");
		}
		//IN045966 Start.
		SqlStr.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+practitioner_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,a.event_group),'N')='Y'");
		//IN045966 End.
		//IN071561 starts
		if(restrict_rd)
			SqlStr.append("AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+user_id+"')='N'");
		//IN071561 ends
		if(result_yn.equals("Y"))
			//SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = NVL (? , patient_id) AND a.event_class = NVL (?  , a.event_class) AND ((A.HIST_REC_TYPE != 'LBIN' and TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy')) OR (A.HIST_REC_TYPE = 'LBIN' AND CONTR_SYS_ID='LB' and TRUNC (EVENT_AUTH_DATE_TIME) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'))) AND NVL (a.status, '#')  not in('S','E') ");//PERF-1
			SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = ? AND a.event_class = NVL (?  , a.event_class) AND ((A.HIST_REC_TYPE != 'LBIN' and TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy')) OR (A.HIST_REC_TYPE = 'LBIN' AND CONTR_SYS_ID='LB' and TRUNC (EVENT_AUTH_DATE_TIME) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'))) AND NVL (a.status, '#')  not in('S','E') ");//PERF-1
		else
			//SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = NVL (? , patient_id) AND a.event_class = NVL (?  , a.event_class) AND TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'  ) AND NVL (a.status, '#') not in('S','E') ");//PERF-1
			SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = ? AND a.event_class = NVL (?  , a.event_class) AND TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'  ) AND NVL (a.status, '#') not in('S','E') ");//PERF-1
	
		if(curr_enc.equals("Y"))
		{
			SqlStr.append(" and encounter_id = ? "); 
		}
		if(status_crit.equals("P"))
		{
			SqlStr.append(" and exists (select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE) "); 
		}
		else if(status_crit.equals("R"))
		{
			SqlStr.append(" and not exists (select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE) "); 
		}

		if(!result_type.equals(""))
		{
			SqlStr.append(" and hist_rec_type=? ");
		}
		else
		{
		  SqlStr.append(" and hist_rec_type in (select hist_rec_type from or_order_category where PREFERRED_VIEW_RESULT_YN='Y' )"); 
		}
		
		if(!priority.equals("") )
		{
			SqlStr.append(" and exists (select 1 from or_order ic where ic.order_id = SUBSTR (a.accession_num,                              INSTR (a.accession_num, '!') + 1, 15 ) and ic.PRIORITY=? )");
		}
		if(group_by.equals("E"))
		{
			if(result_yn.equals("Y"))
				SqlStr.append(" ORDER BY event ,1, a.hist_rec_type,  a.event_class, case when a.hist_rec_type='LBIN' AND CONTR_SYS_ID='LB' THEN  A.EVENT_AUTH_DATE_TIME ELSE event_date END, a.event_group, a.request_num_seq, a.event_code ");
			else
				SqlStr.append(" ORDER BY event ,1, a.hist_rec_type,  a.event_class, event_date, a.event_group, a.request_num_seq, a.event_code ");
		}
		else
		{
			if(result_yn.equals("Y"))
				SqlStr.append(" ORDER BY 1, a.hist_rec_type,  a.event_class, case when a.hist_rec_type='LBIN' AND CONTR_SYS_ID='LB' THEN  A.EVENT_AUTH_DATE_TIME ELSE event_date END, a.event_group, a.request_num_seq, a.event_code ");
			else
				SqlStr.append(" ORDER BY 1, a.hist_rec_type,  a.event_class, event_date, a.event_group, a.request_num_seq, a.event_code ");
		}
		
		stmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
		rs = stmt.executeQuery();
		if (rs.next())
		{
			legend_type = rs.getString(1) == null ? "S" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	
		if(normal_ind.equals(""))
		{
			strNormalcyInd = "nvl(NORMALCY_IND,'.')";
		}
		else if (normal_ind.equals("N"))
		{
			strNormalcyInd = "'.'";
		}
		else if (normal_ind.equals("A"))
		{
			stmt = con.prepareStatement("select ''''|| HIGH_STR   || '''' ||','||''''|| LOW_STR ||''''|| ','||''''|| ABN_STR|| '''' from cr_clin_event_param");
		}
		else if (normal_ind.equals("C"))
		{
			stmt = con.prepareStatement("select ''''|| CRIT_STR   || '''' ||','||''''|| CRIT_HIGH_STR ||''''|| ','||''''|| CRIT_LOW_STR|| '''' from cr_clin_event_param");	
		}

		if(!normal_ind.equals("") && (!normal_ind.equalsIgnoreCase("N"))) 
		{
			rs = stmt.executeQuery();
			if (rs.next())
			{
				strNormalcyInd = rs.getString(1);
			}
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		}
		
		String SqlStr1 = SqlStr.toString();	
		SqlStr1 = replace(SqlStr1,"$",strNormalcyInd,"N");
		stmt = con.prepareStatement(SqlStr1);
		
		if(normal_ind==null) normal_ind = "";
		if(priority==null) priority = "";
		if(patientId==null) patientId = "";
		if(event_class==null) event_class = "";
		if (group_by==null) group_by = "";
		if (ca_normalcy_ind == null) ca_normalcy_ind = "";
		if (modal == null) modal = "";
		
		if(period_from.equals("null") || period_from.equals(" ")) period_from="";
		if(period_to.equals("null") || period_to.equals(" ")) period_to="";
		if (!localeName.equals("en"))
		{
			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",localeName,"en");
			period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",localeName,"en");
		}

		int count = 1 ; 
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);//IN067651
		stmt.setString(count++,practitioner_id);
		stmt.setString(count++,resp_id);
		stmt.setString(count++,reln_id);
		stmt.setString(count++,patientId);
		stmt.setString(count++,event_class);
		if(result_yn.equals("Y"))
		{
			stmt.setString(count++,period_from);
			stmt.setString(count++,period_to);
			stmt.setString(count++,period_from);
			stmt.setString(count++,period_to);
		}
		else
		{
			stmt.setString(count++,period_from);
			stmt.setString(count++,period_to);
		}
		
		if(curr_enc.equals("Y"))
		{
		   stmt.setString(count++,encounter_id);	
		}
		if (status_crit.equals("P")||status_crit.equals("R"))
		{
			stmt.setString(count++,practitioner_id);
		}
		if (!result_type.equals(""))
			stmt.setString(count++,result_type);
		if (!priority.equals("") )
			stmt.setString(count++,priority);
		
		resultSet = stmt.executeQuery();

		if(resultSet!=null)
		{
			if(loop_start > 0)
		
			for(int i=0;(i<loop_start-1 && resultSet.next());i++);
		
			//while ( loop_start <= end && resultSet.next()) //Commented for IN066119
			while (  resultSet.next()) //Modified for IN066119
			{
				//String[] record = new String[46]; - commented for IN041153
				//String[] record = new String[47]; // modified for IN041153
				//String[] record = new String[48]; // modified for IN065970
				String[] record = new String[49]; // modified for IN067651
				record[0] = resultSet.getString( "episode_details" )  ;
				record[1] = resultSet.getString( "event" )  ;
				record[2] = resultSet.getString( "contr_sys_event_code" )  ;
				record[5] = resultSet.getString( "accession_num" )  ;
				record[6] = resultSet.getString( "hist_rec_type" )  ;
				record[7] = resultSet.getString( "contr_sys_id" )  ;
				record[8] = resultSet.getString( "pract_id" )  ;
				record[9] = resultSet.getString( "review_types" )  ;
				record[11] = resultSet.getString( "hist_data_type" )  ;
				record[12] = resultSet.getString( "reported_by" )  ;
				record[13] = resultSet.getString( "reported_at" )  ;
				record[14] = resultSet.getString( "authorized_by_id" )  ;
				record[15] = resultSet.getString( "event_auth_date_time" )  ;
				//IN064688 Changes starts
				//record[16] = resultSet.getString( "result_num" ) ;
				BigDecimal rm =resultSet.getBigDecimal("result_num");
				if(rm!=null)
				record[16]=rm.toString();
				else
				record[16]="";
				//IN064688 Changes Ends
				record[17] = resultSet.getString( "result_num_uom" )  ;
				record[18] = resultSet.getString( "result_str" )  ;
				//IN064688 Changes starts
				//record[19] = resultSet.getString( "normal_low" )  ;
				BigDecimal nl =resultSet.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
				record[19]=nl.toString();
				else
				record[19]="";
				//record[20] = resultSet.getString( "normal_high" )  ;
				BigDecimal nh=resultSet.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
				record[20]=nh.toString();
				else
				record[20]="";
				//IN064688 Changes Ends
				record[21] = resultSet.getString( "normalcy_ind" )  ;
				record[22] = resultSet.getString( "ext_image_obj_id" )  ;
				record[23] = resultSet.getString( "ext_image_appl_id" )  ;
				record[24] = resultSet.getString( "practitioner_name" )  ;
				record[25] = resultSet.getString( "authorized_by_id" )  ;
				record[26] = resultSet.getString( "create_date_time" )  ;
				record[27] = resultSet.getString( "status" )  ;
				record[28] = resultSet.getString( "ordering_practitioner" )  ;
				record[29] = resultSet.getString("hist_rec_type_desc");
				record[30] = resultSet.getString("event_class_desc");
				record[31] = resultSet.getString("event_group_desc");
				record[32] = resultSet.getString("patient_id");
				record[33] = resultSet.getString("event_code");
				record[34] = resultSet.getString("event_group");
				record[35] = resultSet.getString("event_class");
				record[36] = resultSet.getString("hist_data"); 
				record[37] = resultSet.getString("requested_by_pract_id"); 
				record[38] = resultSet.getString("requested_by_pract_name"); 
				record[39] = resultSet.getString("Review_YN"); 
				record[40] = resultSet.getString("COLOR_CELL_IND"); 
				record[41] = resultSet.getString("DESC_CELL_IND"); 
				record[42] = resultSet.getString("normal_range_symbol"); 
				record[43] = resultSet.getString("result_num_prefix"); 
				record[44] = resultSet.getString("normalcy_str"); 
				record[45] = resultSet.getString("EXT_IMAGE_UPLD_ID"); // IN041153 
				record[47] = resultSet.getString("facility_id"); // IN065970 
				record[48] = resultSet.getString("resulted_prac_name"); // IN067651 
				
				allValues.add(record) ;
				loop_start++;
			}

			if (resultSet.next())
			{
				String[] templist = (String[])allValues.get(0);
				//templist[45] = ""+(end+7); - IN041153
				templist[46] = ""+(end+7); // IN041153
				allValues.set(0,templist);
			}
		}

		if(resultSet != null) resultSet.close();
		if(stmt != null) stmt.close();
	}//try ends
	catch ( Exception e )
	{
		e.printStackTrace() ; 
	} 
	// commented for IN041153 - Start
	/*finally 
	{
		ConnectionManager.returnConnection(con,request);
	}*/
	// commented for IN041153 - End
	String result_data[] = (String[])bean.getAbnormalCondition();

	String high_str			= result_data[0];
	String low_str			= result_data[1];
	String abn_str			= result_data[2];

	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String tooltip			= "";
	String result			= "";

	if(allValues.size() == 0)
	{
%>
	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		parent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;
		parent.ReviewResultsHeader.location.href = "../../eCommon/html/blank.html"
		parent.ReviewResultsResult.location.href = "../../eCommon/html/blank.html"
		parent.ReviewResultsBtn.location.href = "../../eCommon/html/blank.html"
	</script>
<%	
	}
	if(allValues.size() != 0)
	{
%>
	<script>focusOnResult();</script>
<%
	}
%>
<form name='review_results_dtl' id='review_results_dtl'  action="../../eCA/jsp/ViewResultsDetail.jsp" method="post">
<table cellpadding=3 cellspacing=0 border=1 width="100%" id='detailTab' class="grid" >
<%
	String 	episode_details				= "";
	String temp_episode_details         = "";
	String 	event						= "";
	String 	contr_sys_event_code		= "";
	String 	order_id					= "";
	String 	accession_num				= "";
	String 	hist_rec_type				= "";
	String 	contr_sys_id				= "";
	String 	review_types				= "";
	String 	review_type					= "";
	String 	hist_data_type				= "";
	String 	reported_at					= "";
	String 	result_num					= "";
	String 	result_num_prefix			= "";
	String 	result_num_uom				= "";
	String 	result_str					= "";
	String 	result_str_disp				= "";
	String 	normal_low					= "";
	String 	normal_high					= "";
	String 	normalcy_ind				= "";
	String 	ext_image_obj_id			= "";
	String 	ext_image_appl_id			= "";
	String 	practitioner_name			= "";
	String 	create_date_time			= "";
	String  status						= "";
    String  ordering_practitioner		= "";
    String  hist_rec_type_desc          = "";
    String  event_class_desc            = "";
    String  event_group_desc            = "";
	String  temp_res_event_header       = "";
	String  temp_event_group_desc       = "";
    String	temp_order_id				= "";
    String  patient_id                  = "";
    String  event_code                  = "";
    String  event_group                 = "";
    String  event_class_code            = "";
    String  requested_by_pract_id       = "";
    String  requested_by_pract_name     = "";
    String  Review_YN					= "";
    String  chk_disable					= "";
	String  status_desc					= "";
	String  event_auth_date_time		= "";
	Boolean ckh_flag					= false;
	
	StringBuffer disp_value = new StringBuffer();
	String slClassValue = "";
	String[] record  = null;
	int j=1;//Added for IN066119
	
	for(int i=0; i<allValues.size(); i++)
	{
		record  = (String[])allValues.get(i);
		if (record[0].indexOf(",") != -1)
		{
			StringTokenizer fieldTokenizer = new StringTokenizer(record[0],",");
			record[0] = "";
		
			while (fieldTokenizer.hasMoreTokens())
			{
				String tempToken = fieldTokenizer.nextToken();
		 
				if((tempToken.indexOf('/'))==1)
				{
					String tempstr=tempToken.substring(1);
					if (tempToken.charAt(0)=='M')
						tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
					else if(tempToken.charAt(0)=='F')
						tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
				}
				record[0]=record[0].concat(tempToken).concat(",");
			}
		}
		
		episode_details				= CommonBean.checkForNull(record[0]);
		event						= CommonBean.checkForNull(record[1]);
		contr_sys_event_code		= CommonBean.checkForNull(record[2]);
		accession_num				= CommonBean.checkForNull(record[5]);
		hist_rec_type				= CommonBean.checkForNull(record[6]);
		contr_sys_id				= CommonBean.checkForNull(record[7]);
		review_types				= CommonBean.checkForNull(record[9]);
		hist_data_type				= CommonBean.checkForNull(record[11]);
		reported_at					= CommonBean.checkForNull(record[13]);
		reported_at					= com.ehis.util.DateUtils.convertDate(reported_at,"DMYHM","en",localeName);
		event_auth_date_time		= CommonBean.checkForNull(record[15]);
		result_num					= CommonBean.checkForNull(record[16]);
		result_num_uom				= CommonBean.checkForNull(record[17]);
		result_str					= CommonBean.checkForNull(record[18]);
		normal_low					= CommonBean.checkForNull(record[19]);
		normal_high					= CommonBean.checkForNull(record[20]);
		normalcy_ind				= CommonBean.checkForNull(record[21]);
		ext_image_obj_id			= CommonBean.checkForNull(record[22]);
		ext_image_appl_id			= CommonBean.checkForNull(record[23]);
		//IN067651 changes starts
		//practitioner_name			=CommonBean.checkForNull(record[24]);
		if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
		{
			practitioner_name			=CommonBean.checkForNull(record[48]);
		}else{
			practitioner_name			=CommonBean.checkForNull(record[24]);
		}
		//IN067651 changes ends
		create_date_time			= CommonBean.checkForNull(record[26]);
		create_date_time			= com.ehis.util.DateUtils.convertDate(create_date_time,"DMYHM","en",localeName);
		status						= CommonBean.checkForNull(record[27]);
		ordering_practitioner		= CommonBean.checkForNull(record[28]);
		hist_rec_type_desc          = CommonBean.checkForNull(record[29]);
		event_class_desc            = CommonBean.checkForNull(record[30]);
		event_group_desc            = CommonBean.checkForNull(record[31]);
		patient_id                  = CommonBean.checkForNull(record[32]);
        event_code                  = CommonBean.checkForNull(record[33]);
        event_group                 = CommonBean.checkForNull(record[34]);
        event_class_code            = CommonBean.checkForNull(record[35]);
		result			            = CommonBean.checkForNull(record[36]);
		requested_by_pract_id	    = CommonBean.checkForNull(record[37]);
		requested_by_pract_name     = CommonBean.checkForNull(record[38]);
		Review_YN					= CommonBean.checkForNull(record[39]);
		color_cell_ind				= CommonBean.checkForNull(record[40]);
		desc_cell_ind				= CommonBean.checkForNull(record[41]);
		normal_range_symbol			= CommonBean.checkForNull(record[42]);
		result_num_prefix			= CommonBean.checkForNull(record[43]);
		normalcy_str				= CommonBean.checkForNull(record[44]);
		ext_image_upld_id			= CommonBean.checkForNull(record[45]); // IN041153
		fac_id						= CommonBean.checkForNull(record[47]); // IN065970 reopen
		if(normal_low == null || normal_low.equals(""))
		{
			normal_low = "";
		}
		if(normal_high == null || normal_high.equals(""))
		{
			normal_high = "";
		}
	
		if(legend_type.equals("C"))
			color_cell_indicator = color_cell_ind; 
		else if(legend_type.equals("S"))
			color_cell_indicator = normal_range_symbol; 
		
		if(!status.equals("") && status.equals("C"))
		{
			slClassValue = "ORSTATUSPARTIAL";
			tooltip      = "This result has been Modified";
		}
		else
		{
			tooltip = "";
			slClassValue="gridData";
		} 
		
		if(Review_YN.equals("Y"))
		{
			chk_disable="";
			ckh_flag = true;
			status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReview.label","ca_labels");
		}
		else
		{
			chk_disable="disabled";	
			status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Reviewed.label","ca_labels");
		}

		if(i==0)
		{
			//if(record[45] != null) //- IN041153
			if(record[46] != null) // IN041153
			//total_query_records = bean.checkForNull((String)record[45],"0"); - IN041153
			total_query_records = bean.checkForNull((String)record[46],"0"); // IN041153
%>
		<!--	<jsp:include page="ViewResultsResultScrolling.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="from" value= "<%=start%>" /> 
			<jsp:param name ="to" value= "<%=end%>" />	
			<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
			<jsp:param name ="check_box_name" value= "chk" />					 
			<jsp:param name ="form_name" value= "review_results_dtl" />  
			</jsp:include>				
		Commented for IN066119-->
<%				
		}
		disp_value = new StringBuffer();
 		disp_value.append("&nbsp;");
		//IN066119 start
		if("Y".equals(hideSpecimenType))
			result_str="";
		//IN066119 ends
		
		if(result_str.length()>10)
		{
			result_str_disp=result_str.substring(0,9);
		}
		else
		{
			result_str_disp = result_str;
		}
				
		tempNormCritStr.setLength(0);
		if(hist_data_type.trim().equals("NUM"))
		{
			//Added by Jyothi.G on 09/12/2010 to fix IN025310
			if(!normal_low.equals("") && !normal_high.equals(""))
				details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : " + normal_low + " " + result_num_uom +" to "+ normal_high + " " + result_num_uom ;
			else if(!normal_low.equals(""))
				details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (>=" + normal_low + " " + result_num_uom + ")";
			else if(!normal_high.equals(""))
				details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (<=" + normal_high + " " + result_num_uom + ")";//END
							
			if(!color_cell_indicator.equals(""))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else
			{
				if(normalcy_ind.equals("."))
				{
					if(legend_type.equals("S"))
						disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
					else
						disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				}
				else if(!normal_low.equals("") && !normal_high.equals(""))
				{
					if(Float.parseFloat(result_num) > 0)
					{
						if((Float.parseFloat(result_num) >= Float.parseFloat(normal_low)) && (Float.parseFloat(result_num) <= 	Float.parseFloat(normal_high)))
						{
							if(legend_type.equals("S"))
								disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
							else
								disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
						}
					}
				}
				else if(!normal_low.equals("") && normal_high.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
				{
					if(Float.parseFloat(result_num) > 0)
					{
						if(Float.parseFloat(result_num) >= Float.parseFloat(normal_low))
						{
							if(legend_type.equals("S"))
								disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
							else
								disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
						}
					}
				}
				else if(normal_low.equals("") && !normal_high.equals(""))
				{
					if(Float.parseFloat(result_num) > 0)
					{
						if(Float.parseFloat(result_num) <= 	Float.parseFloat(normal_high))
						{
							if(legend_type.equals("S"))
								disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
							else
								disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
						}
					}
				}//END
			}
			//IN067037 changes starts
			/*
			//IN053093 Starts
			if(Float.parseFloat(result_num) < 1)
			{
				disp_value.append(result_num_prefix+Float.parseFloat(result_num) + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;");
			}
			else
			{
				disp_value.append(result_num_prefix+result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;");
			}
			//IN053093 Ends
			*/
			if(!result_num.equals("")){
					disp_value.append(result_num_prefix+result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;");
			}
			//IN067037 changes ends
			if(result_str!=null && !result_str.equals(""))
			{
				if(result_str.length()>11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append( "<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} 
		else if(hist_data_type.trim().equals("STR"))
		{
			if(!color_cell_indicator.equals(""))
			{
			   if(legend_type.equals("S"))
				   disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			   else
				  disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else if(normalcy_ind.equals("."))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			}
			if(result_str!=null && !result_str.equals(""))
			{				
				if(result_str.length()<11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}

			}
			if(!normalcy_str.equals(""))
			{
				disp_value.append(" <font color=blue>( Normal Value : " + normalcy_str + " )</font>");
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} 
		else if(hist_data_type.trim().equals("TXT"))
		{
			if(!color_cell_indicator.equals(""))
			{
			   if(legend_type.equals("S"))
				   disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			   else
				  disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else if(normalcy_ind.equals("."))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			}
			if(result_str!=null && !result_str.equals(""))
			{
				if(result_str.length()>11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		}
		else if(hist_data_type.trim().equals("HTM"))
		{
			if(!color_cell_indicator.equals(""))
			{
			   if(legend_type.equals("S"))
				   disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			   else
				  disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else if(normalcy_ind.equals("."))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			}
			if(result_str!=null && !result_str.equals(""))
			{				
				if(result_str.length()>11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobDataHtm('"+accession_num+"','"+hist_data_type+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		}
		//7902 STARTS
		if(!ext_image_appl_id.equals("")&& ext_image_appl_id.equals("CPACS"))
		{
		
			ext_img_disable="disabled";
			
			pstmtImgView1 = con.prepareStatement("SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW WHERE  EXT_IMAGE_APPL_ID=?"); 
			pstmtImgView1.setString(1,ext_image_appl_id);
			resImgView1 = pstmtImgView1.executeQuery();
			
			while(resImgView1.next())
			{
				param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
			}
			if(pstmtImgView1!=null) pstmtImgView1.close();
			if(resImgView1!=null) resImgView1.close();
			
			if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){
				pstmtImgView = con.prepareStatement("SELECT A.study_id  FROM or_order_line a, cr_encounter_detail b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?"); 
				pstmtImgView.setString(1,ext_image_appl_id);
				pstmtImgView.setString(2,ext_image_obj_id);
				resImgView = pstmtImgView.executeQuery();
				
				while(resImgView.next())
				{
					study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
				}
				
				if(pstmtImgView!=null) pstmtImgView.close();
				if(resImgView!=null) resImgView.close();
			}
			
		}
		if(study_id.equals("null"))
			study_id="";
		if(!study_id.equals("") && param_def_str.contains("~STUDY_ID`"))
		{
			ext_img_disable="";
			ext_img_display="Result";
		} 
		else if(!study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
		{
			ext_img_disable="";
			ext_img_display="Result";
		} 
		else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`")&& ext_image_appl_id.equals("CPACS"))
		{
			ext_img_disable="disabled";
			ext_img_display="Study ID not available, we cannot Proceed";
		}
		else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
		{
			ext_img_disable="";
			ext_img_display="Result";
		}	//7902 ENDS
					
		
		if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
			pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
			pstmtImgView.setString(1,ext_image_upld_id);
			resImgView = pstmtImgView.executeQuery();
			String recCountInt = "";
			String perfFacilityId = "";  
			while(resImgView.next())
			{
				ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
			}
			
			pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
			pstmtPerFacId.setString(1,ext_image_obj_id);
			rsetPerFacId = pstmtPerFacId.executeQuery();
			if(rsetPerFacId.next()){
				perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
			}
			// IN052800 - Start
			if(perfFacilityId.equals("") || perfFacilityId == null){
				perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(ext_image_obj_id);
			}
			//IN052800 - End
			//IN065970 starts
			//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?"); 
			pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?"); 
			/*pstmtImgCount.setString(1,perfFacilityId);
			pstmtImgCount.setString(2,ext_image_obj_id);
			pstmtImgCount.setString(3,event_group);*/
			
			pstmtImgCount.setString(1,ext_image_obj_id);
			pstmtImgCount.setString(2,event_group);
			//IN065970 ends
			rsetImgCount = pstmtImgCount.executeQuery();
			if(rsetImgCount.next()) 
			{
				recCount = rsetImgCount.getInt(1);
			}
			recCountInt = String.valueOf(recCount);
			//IN065970 reopen starts
			//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",user_id).replace("~language_id#",localeName); 
			ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",user_id).replace("~language_id#",localeName); 
			//IN065970 reopen ends
			
			
			if(resImgView  != null) resImgView.close();
			if(pstmtImgView != null) pstmtImgView.close();

			if(rsetImgCount  != null)  rsetImgCount.close();
			if(pstmtImgCount  != null) pstmtImgCount.close();

			if(rsetPerFacId  != null) rsetPerFacId.close();
			if(pstmtPerFacId  != null) pstmtPerFacId.close();
		}
		
		
		// End	

		//if ((ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_appl_id!=null && !ext_image_appl_id.equals("")) )
	/*	if ((ext_image_appl_id!=null && !ext_image_appl_id.equals("")) )
		{
			disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"')\"> ");
			disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='XRAY' align=center></a>");
		}*/ //Commentted for EMG
		
		//Added docul condition for EMG
		if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
		{
			if(!("DMS").equals(ext_image_appl_id)) { // added for IN041153
				//if(!("DOCUL").equals(ext_image_appl_id)) // commented for IN041153
				if(!("DOCUL").equals(ext_image_appl_id) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))) // added for IN041153
				{
					//IN050936 included patient_id	
					if(ext_img_disable.equals("disabled")){
					disp_value.append("<br><a class='gridLink'> ");
					disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 "+ext_img_disable+" alt='"+ext_img_display+"'></a>");
					}
					else{
						disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
						disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='"+ext_img_display+"'></a>");
					}
					
				}
				else  if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")) // added for IN041153
				{
					//IN050936 included patient_id
					if(ext_img_disable.equals("disabled")){
						disp_value.append("<br><a class='gridLink'> ");
						disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 "+ext_img_disable+"  alt='"+ext_img_display+"'></a>");
						}
						else{
							disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
							disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='"+ext_img_display+"'></a>");
						}
					
				} 
				else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) { // added for IN041153 - Start
					disp_value.append("<br><a class='gridLink'  href=\"javascript:viewUploadedImg('"+ext_img_file_locn+"')\">" );
					disp_value.append(" View Image </a>");
				} // added for IN041153 - End
			}  	
								
		}

		disp_value.append("<a class='gridLink' href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' title='Previous Results' border='0' align=center></img></a>");

		if(status.equals("P"))
			disp_value.append("<font color='red'>(Preliminary)</font>");
%>
		<input type=hidden name='hist_rec_type<%=i%>' id='hist_rec_type<%=i%>' value='<%=hist_rec_type%>'>
		<input type=hidden name='contr_sys_id<%=i%>' id='contr_sys_id<%=i%>' value='<%=contr_sys_id%>'>
		<input type=hidden name='contr_sys_event_code<%=i%>' id='contr_sys_event_code<%=i%>' value='<%=contr_sys_event_code%>'>
		<input type=hidden name='accession_num<%=i%>' id='accession_num<%=i%>' value='<%=accession_num%>'>
		<input type=hidden name='review_type<%=i%>' id='review_type<%=i%>' value='<%=review_types%>'>
		<input type=hidden name='result_str<%=i%>' id='result_str<%=i%>' value='<%=result_str%>'>
		<input type=hidden name='create_date_time<%=i%>' id='create_date_time<%=i%>' value='<%=create_date_time%>'>
		<input type=hidden name='patient_id<%=i%>' id='patient_id<%=i%>' value='<%=patient_id%>'>
		<input type=hidden name='event_code<%=i%>' id='event_code<%=i%>' value='<%=event_code%>'>
		<input type=hidden name='event_group<%=i%>' id='event_group<%=i%>' value='<%=event_group%>'>
		<input type=hidden name='event_class_code<%=i%>' id='event_class_code<%=i%>' value='<%=event_class_code%>'>
		<input type=hidden name='normalcy_ind<%=i%>' id='normalcy_ind<%=i%>' value='<%=(record[21]==null)?"":record[21]%>'>
<% 
		if(!group_by.equals("E"))
		{
			if (!temp_episode_details.equals(episode_details))
			{ 
%>
			<tr><Td colspan='9' class ='CAFLOWSHEETLEVEL3'><%=episode_details%></Td></tr> 
<%
			temp_episode_details = episode_details;
			temp_res_event_header = "";
			}
			if(!temp_res_event_header.equals(hist_rec_type_desc+"/"+event_class_desc))
			{
%>
				<tr> <Td colspan='9' class ='CAGROUPHEADING'><%=hist_rec_type_desc+"/"+event_class_desc%></Td></tr>
<%
				temp_res_event_header =  hist_rec_type_desc+"/"+event_class_desc;
			}
%>
			<tr>
<%
			if (event_group_desc.equals(""))
			{
				//IN066119 starts
				j++;
				temp_event_group_desc="";
				temp_order_id ="";
				//IN066119 ends
%>
				<td width='7%' id='status<%=i%>' class='<%=slClassValue%>' title = "<%=tooltip%>"><input type=checkbox name='chk<%=i%>' onClick="clickChk('<%=i%>')" value="" <%=chk_disable%> ><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' value=''></td>
				<td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=event%></font></td>
				<td width='9.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
				<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>
				<%--<td width='13%' class='<%=//slClassValue%>' title = "<%=//tooltip%>"><font size=1><%=//episode_details%></font></td>--%>
				<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1>
<%
				if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
					out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
				else
					out.println(reported_at);
%>
				</font> </td>
				<td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
				<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=status_desc%></font></td>
<%
			}
			else
			{
				if ((!temp_event_group_desc.equals(event_group_desc))|| (!temp_order_id.equals(order_id)))
				{   
					j++;//IN066119
%>
					<TR>
					<TR>
						<TD> <input type="checkbox" name='chkgrp<%=j%>' id='maingrp<%=j%>' onClick="checkgroup('<%=j%>')" <%=mainGrpDisable%>  value='chk<%=i%>'  ></TD><!--Modified for IN066119-->
						<TD colspan='9' >
							<Font size=1><%=event_group_desc%></Font>
						</TD>
					</TR>

					<TR>
						<%--<td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>" > <input type=checkbox name='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" <%=chk_disable%> ><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' value=''></td>//Commented for IN066119--%>
						<td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>" > <input type=checkbox id='subgrp<%=j%><%=i%>' name='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" <%=chk_disable%> ><input type='hidden' name='headval<%=i%>' id='headval<%=i%>' value='<%=j%>'><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='subgrp_remarks<%=j%><%=i%>'  value=''></td><!--Modified for IN066119-->
						<td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>" ><font size=1><%=event%></font></td>
						<td width='9.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>

						<%--<td width='13%' class='<%=//slClassValue%>' title = "<%=//tooltip%>"><font size=1><%=//episode_details%></font></td>--%>
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1>
<%
						if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
							out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
						else
							out.println(reported_at);
%>
						</font> </td>
						
						<td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=status_desc%></font>&nbsp;</td>
					</TR>
<%
					temp_order_id=order_id;temp_event_group_desc = event_group_desc;
				}
				else
				{
%>
					<TR>
						<%--<td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>"> <input type=checkbox name='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" <%=chk_disable%> ><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' value=''></td>Commented for IN066119--%>
						<td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>"> <input type=checkbox id='subgrp<%=j%><%=i%>' name='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" <%=chk_disable%> ><input type='hidden' name='headval<%=i%>' id='headval<%=i%>' value='<%=j%>'><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='subgrp_remarks<%=j%><%=i%>' value=''></td><!--Modified for IN066119-->
						<td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=event%></font></td>
						<td width='9.5' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>
						<%--<td width='13%' class='<%=//slClassValue%>' title = "<%=//tooltip%>"><font size=1><%=//episode_details%></font></td>--%>
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1>
<%
						if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
							out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
						else
							out.println(reported_at);
%>
						</font> </td>
						
						<td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=status_desc%></font>&nbsp;</td>
					</TR>
<%
				}
			}
%>
			</tr>
<%  	}
		else
		{
%>
			<TR>
				<td width='8.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value=""   <%=chk_disable%> ><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='review_remarks<%=i%>' value=''></td>
				<td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=event%></font></td>
				<td width='9.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
				<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>
				<td width='8%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1>
<%
				if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
					out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
				else
					out.println(reported_at);
%>
				</font></td>
				<td width='14.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=episode_details%></font></td>
				<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
				<td width='9%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=status_desc%></font></td>
			</TR>
<%
		}
	}
%>
</table>
	<input type="hidden" name="from" id="from" value="<%=from%>" >
	<input type="hidden" name="to" id="to" value="<%=to%>" >

	<input type=hidden name='requested_by_pract_id' id='requested_by_pract_id' value='<%=requested_by_pract_id%>'>
	<input type=hidden name='requested_by_pract_name' id='requested_by_pract_name' value='<%=requested_by_pract_name%>'>
	<input type=hidden name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
	<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">

	<input type="hidden" name="priority" id="priority" value="<%=(String)request.getParameter("priority")%>">
	<input type="hidden" name="normalcy_ind" id="normalcy_ind" value="<%=(String)request.getParameter("normalcy_ind")%>">
	<input type="hidden" name="result_type" id="result_type" value="<%=(String)request.getParameter("result_type")%>">
	<input type="hidden" name="patientId" id="patientId" value="<%=(String)request.getParameter("patientId")%>">
	<input type="hidden" name="event_class" id="event_class" value="<%=(String)request.getParameter("event_class")%>">
	<input type="hidden" name="groupby" id="groupby" value="<%=(String)request.getParameter("groupby")%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=(String)request.getParameter("patient_class")%>">
	<input type="hidden" name="ca_normalcy_ind" id="ca_normalcy_ind" value="<%=(String)request.getParameter("ca_normalcy_ind")%>">
	<input type="hidden" name="modal" id="modal" value="<%=(String)request.getParameter("modal")%>">
	<input type="hidden" name="period_from" id="period_from" value="<%=(String)request.getParameter("period_from")%>">
	<input type="hidden" name="period_to" id="period_to" value="<%=(String)request.getParameter("period_to")%>">
	<input type="hidden" name="status_crit" id="status_crit" value="<%=(String)request.getParameter("status_crit")%>">
</form>

<script>
	if(parent.ReviewResultsHeader.document.getElementById('titleTab')!=null)
	{
		alignWidth();
		parent.ReviewResultsHeader.document.review_results_hdg.select_all.checked=false;
		if('<%=ckh_flag%>'=="false")
		{
			parent.ReviewResultsHeader.document.review_results_hdg.select_all.disabled =true;
		}
		else
		{
			parent.ReviewResultsHeader.document.review_results_hdg.select_all.disabled =false;
		}
	}
	parent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;
</script>

</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);

	} // added for IN041153
	catch(Exception ex) {
		System.out.println(" 1084. View ResultsDetail.jsp ===> " + ex.getMessage());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
%>

<%!
	private String replace(String str ,String change ,String replace,String quotes)
	{
		int t = str.indexOf(change);
		if( t == -1)
			return str;
		if (quotes.equalsIgnoreCase("Y"))
			str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;
		else if (quotes.equalsIgnoreCase("N"))
			str   = str.substring(0,t) + " " + replace.trim()+ " " + str.substring(t+1)  ;
		return str ;
	}
%>

