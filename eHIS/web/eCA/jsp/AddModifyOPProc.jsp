<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created 
20/01/2012		CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]										
------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------
05/08/2015	IN037505	   Karthi L	       ?			  ?			[SRR20056-SCF-9373 ] - After select Start Date/time and Duration, System doesn?t calculate and display Ending date/time.
10/03/2022  36285          Hariharan k       		                  MMs-DM-CRF-0221.v1.0(003)
------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<% 	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../js/procedures.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
<script src="../../eCommon/js/dchk.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<%
	Connection con = null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String visitdate= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
	String accession_number= request.getParameter("accession_number")==null?"":request.getParameter("accession_number");
	visitdate = com.ehis.util.DateUtils.convertDate(visitdate,"DMYHM","en",locale);
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
	String facility_id		= (String) session.getValue("facility_id");// 36285 
	String bean_id 						= "@ProceduresBean";// 36285
	String bean_name 					= "eCA.ProceduresBean";// 36285
	ProceduresBean bean					= (ProceduresBean)getBeanObject( bean_id, bean_name, request ) ;// 36285
	String  enablePriSecProc = bean.getProceduresData(facility_id);
	// 36285
	//String proc_scheme_id="";// 36285

	try
	{   
		PreparedStatement stmt = null;
		ResultSet rset = null ;
		PreparedStatement pstmt = null;
	
		con = ConnectionManager.getConnection(request);
		String sql = "";
		String sql1 = "";
		String operating_facility_id = "";
		String practitioner_id1 = "";
		String patient_id = "";
		String encounter_id = "";
		String sel = "";
		String name = "";
		String curr_level = "";
		String ass_pract_name = "";
		String ass_pract_name3 = "";
		String id = "";
		String s_scheme = "";
		String s_scheme_desc = "";
		String desc = "";
		String record_type = "O";
		String cause_indicator = "";
		String locn_code = "";
		String locn_type = "";
		String order_id = "";
		String order_line_num = "";
		String or_order_id = "";
		String code_disable = "";
		String term_set_id = "";	
		String disp_code = "display:";
		int i = 1;
		operating_facility_id = (String)session.getValue("facility_id");
		String practitioner_type = (String)session.getValue("practitioner_type")==null?"":(String)session.getValue("practitioner_type");
		StringBuffer sql_proc = new StringBuffer(); 
		String Encounter_Id	= request.getParameter("Encounter_Id") == null ? "" : request.getParameter("Encounter_Id");
		term_set_id = request.getParameter("term_set_id") == null ? "" : request.getParameter("term_set_id");
	
		
		String resp_id = (String)session.getValue("responsibility_id");
		String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");

		//practitioner_id1 = (String)session.getValue("ca_practitioner_id");

		practitioner_id1 = (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");

		String practitioner_name = "";
		String visit_adm_date_time = "";
		or_order_id		= request.getParameter("orderId") == null ? "" : request.getParameter("orderId");
		order_line_num	= request.getParameter("order_line_num") == null ? "" : request.getParameter("order_line_num");
		encounter_id	= request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
		patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		locn_code		= request.getParameter("location_code") == null ? "" : request.getParameter("location_code");
		locn_type		= request.getParameter("location_type") == null ? "" : request.getParameter("location_type");

		String patient_class = request.getParameter("patient_class")==null?"": request.getParameter("patient_class");
		String proc_code				= "";
		String proc_narration			= "";
		String proc_codelong_desc		= "";
		String proc_date				= "";
		String start_datetime = "";
		String end_datetime = "";
		String ass_practitioner1 = "";
		String ass_practitioner2 = "";
		String ass_practitioner3 = "";
		String anaesthetist1 = "";
		String anaesthetist2 = "";
		String anaesthetist3 = "";
		String anaesthesia_code = "";
		String anaesthesia_detail = "";
		String indication = "";
		String monitoring = "";
		String events = "";
		String post_proc_std_orders = "";
		String specimen_sent = "";
		String scrub_nurse = "";
		String upd_practitioner_name	= "";
		String upd_practitioner_id		= "";
		String hpi						= "";
		String proc_summary				= "";
		String findings					= "";
		String impression				= "";
		String disposition				= "";
		String upd_encounter_id			= "";
		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		
		String upd_code = request.getParameter("code") == null ? "" : request.getParameter("code");
		String upd_pat_id = request.getParameter("pat_id") == null ? "" : request.getParameter("pat_id");
		String upd_srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
		String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
		String upd_enc_id = request.getParameter("encounter_id1") == null ? "" : request.getParameter("encounter_id1");
		
		String scrubname="";
		String laterality_ind = "";
		String proc_perf_locn_code = "";
		String locn_desc = "";
		String modify_Yn = "";
		String sql_task = "";
		String classifition_type=""; //36285

		if(!term_set_id.equals("") && !mode.equals("OR"))
		{
			mode ="update";
			disp_code ="display:";
		}
		order_id = or_order_id;

		String pracsql="Select  practitioner_name from am_practitioner_LANG_VW WHERE practitioner_id=? AND LANGUAGE_ID = ?";
		pstmt = con.prepareStatement(pracsql);
		pstmt.setString(1,practitioner_id1);
		pstmt.setString(2,locale);
		rset= pstmt.executeQuery();

		if(rset.next())
		practitioner_name=rset.getString("practitioner_name");

		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();


	    sql1 ="SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time FROM pr_encounter WHERE encounter_id=? AND facility_id=?";
		pstmt=con.prepareStatement(sql1);
		if(mode.equals("update"))
		{
			pstmt.setString(1,upd_enc_id);
		}
		else
		{

           pstmt.setString(1,Encounter_Id);
		}
		pstmt.setString(2,operating_facility_id);
		rset=pstmt.executeQuery();

		if(rset.next())
		{
		visit_adm_date_time = rset.getString("visit_adm_date_time")==null?"":rset.getString("visit_adm_date_time");
		visit_adm_date_time = com.ehis.util.DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);
		}
		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();
		if(mode.equals("update"))
		{
			String sql_nquery ="SELECT CURR_LEVEL FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID=? AND ENCOUNTER_ID=?";
			try
			{
				pstmt=con.prepareStatement(sql_nquery);
				pstmt.setString(1,operating_facility_id);
				pstmt.setString(2,encounter_id);
				rset=pstmt.executeQuery();
				if(rset!=null)
				{
					while(rset.next())
					{
						curr_level=rset.getString("CURR_LEVEL");						
					}
				}
				if(rset != null)rset.close();
				if(pstmt != null)pstmt.close();				
			}
			catch(Exception e)
			{
				e.printStackTrace() ;				
			}
		}		
		if(mode.equals("update"))
		{
			//String sql_query = "select proc_code, proc_narration, to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date, practitioner_name upd_practitioner_name, hpi, proc_summary, findings, impression, disposition, a.practitioner_id upd_practitioner_id, encounter_id, order_id, order_line_num,           start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime ,  ass_practitioner1,  ass_practitioner2,(select short_name from am_practitioner where practitioner_id=ass_practitioner2 ) ass_pract_name , anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, long_desc from pr_encounter_procedure a , am_practitioner b ,mr_term_code where a.practitioner_id = b.practitioner_id and proc_code = ? and patient_id =? and srl_no =? and term_code = proc_code ";

			//String sql_query = "select rtrim(proc_code) proc_code, SHORT_DESC proc_narration, to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') upd_practitioner_name, hpi, proc_summary, findings, impression, disposition, a.practitioner_id upd_practitioner_id, encounter_id, order_id, order_line_num, start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime ,  ass_practitioner1,  ass_practitioner2,AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner2,?,'1')  ass_pract_name , anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, long_desc, laterality_ind, ass_practitioner3, AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner3,?,'1')  ass_pract_name3, a.proc_perf_locn_code, OP_GET_DESC.OP_CLINIC(?,a.proc_perf_locn_code,?,'2') locn_desc from pr_encounter_procedure a , mr_term_code where  rtrim(proc_code) = ? and patient_id =? and srl_no =? and term_code = rtrim(proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME";
			String sql_query = "select rtrim(proc_code) proc_code, SHORT_DESC proc_narration, to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') upd_practitioner_name, hpi, proc_summary, findings, impression, disposition, a.practitioner_id upd_practitioner_id, encounter_id, order_id, order_line_num, start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime ,  ass_practitioner1,  ass_practitioner2,AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner2,?,'1')  ass_pract_name , anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, long_desc, laterality_ind, ass_practitioner3, AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner3,?,'1')  ass_pract_name3, a.proc_perf_locn_code, OP_GET_DESC.OP_CLINIC(?,a.proc_perf_locn_code,?,'2') locn_desc,a.CLASSIFITION_TYPE from pr_encounter_procedure a , mr_term_code where  rtrim(proc_code) = ? and patient_id =? and srl_no =? and term_code = rtrim(proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME";//36285
			pstmt = con.prepareStatement(sql_query);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,operating_facility_id);
			pstmt.setString(5,locale);
			pstmt.setString(6,upd_code);
			pstmt.setString(7,upd_pat_id);
			pstmt.setString(8,upd_srl_no);
			rset= pstmt.executeQuery();
			
			if(rset!=null)
			{
				if(rset.next())
				{
					proc_code				=	rset.getString("proc_code");
					proc_narration			=	rset.getString("proc_narration");
					proc_date				=	rset.getString("proc_date");
					upd_practitioner_name	=	rset.getString("upd_practitioner_name");
					hpi						=	rset.getString("hpi");
					proc_summary			=	rset.getString("proc_summary");
					findings				=	rset.getString("findings");
					impression				=	rset.getString("impression");
					disposition				=	rset.getString("disposition");
					upd_practitioner_id		=   rset.getString("upd_practitioner_id");
					upd_encounter_id		=	rset.getString("encounter_id");
					order_id                =   rset.getString("order_id");
					order_line_num          =   rset.getString("order_line_num");
					start_datetime			=	rset.getString("start_datetime");
					end_datetime			=	rset.getString("end_datetime");
					ass_practitioner1		=	rset.getString("ass_practitioner1");
					ass_practitioner2		=	rset.getString("ass_practitioner2");
					ass_pract_name			=	rset.getString("ass_pract_name")==null?"":rset.getString("ass_pract_name");
					anaesthetist1			=	rset.getString("anaesthetist1");
					anaesthetist2			=	rset.getString("anaesthetist2");
					anaesthetist3			=	rset.getString("anaesthetist3");
					anaesthesia_code		=	rset.getString("anaesthesia_code");
					anaesthesia_detail		=	rset.getString("anaesthesia_detail");
					indication				=   rset.getString("indication");
					monitoring				=	rset.getString("monitoring");
					events					=   rset.getString("events");
					post_proc_std_orders    =   rset.getString("post_proc_std_orders");
					specimen_sent           =   rset.getString("specimen_sent");
					scrub_nurse				=   rset.getString("scrub_nurse");
					proc_codelong_desc		=	rset.getString("long_desc");
					laterality_ind			=	rset.getString("laterality_ind");
					ass_pract_name3			=	rset.getString("ass_pract_name3") == null ? "" : rset.getString("ass_pract_name3");
					ass_practitioner3		=	rset.getString("ass_practitioner3") == null ? "" : rset.getString("ass_practitioner3");
					proc_perf_locn_code		=	rset.getString("proc_perf_locn_code") == null ? "" : rset.getString("proc_perf_locn_code");
					locn_desc				=	rset.getString("locn_desc") == null ? "" : rset.getString("locn_desc");
					classifition_type       =   rset.getString("classifition_type");//36285
					

					if(start_datetime== null)start_datetime			= "";
					if(end_datetime== null )end_datetime			= "";
					if(ass_practitioner1== null )ass_practitioner1	= "";
					if(ass_practitioner2== null )ass_practitioner2	= "";
					if(anaesthetist1== null )anaesthetist1			= "";
					if(anaesthetist2== null )anaesthetist2			= "";
					if(anaesthetist3== null )anaesthetist3			= "";
					if(anaesthesia_code== null )anaesthesia_code	= "";
					if(anaesthesia_detail== null )anaesthesia_detail= "";
					if(indication== null )indication				= "";
					if(monitoring== null )monitoring				= "";
					if(events== null )events						= "";
					if(post_proc_std_orders== null )post_proc_std_orders	= "";
					if(specimen_sent== null )specimen_sent			= "";
					if(scrub_nurse== null )scrub_nurse				= "";
					if(proc_code				== null	)proc_code				= "";
					if(proc_narration			== null )proc_narration			= "";
					if(proc_date				== null )proc_date				= "";
					if(upd_practitioner_name	== null )upd_practitioner_name	= "";
					if(hpi						== null )hpi					= "";
					if(proc_summary				== null )proc_summary			= "";
					if(findings					== null )findings				= "";
					if(impression				== null )impression				= "";
					if(disposition				== null )disposition			= "";
					if(upd_practitioner_id		== null )upd_practitioner_id	= "";
					if(upd_encounter_id			== null )upd_encounter_id		= "";
					if(order_id                 == null )order_id				= "";
					if(order_line_num			== null )order_line_num			= "";
					if(proc_codelong_desc		== null )proc_codelong_desc		= "";
					if(laterality_ind			== null )laterality_ind			= "";
					if(classifition_type		== null )classifition_type	    = "";//36285
					

					proc_date		=	com.ehis.util.DateUtils.convertDate(proc_date,"DMYHM","en",locale);
					end_datetime	=	com.ehis.util.DateUtils.convertDate(end_datetime,"DMYHM","en",locale);
				}
			}
			code_disable ="readonly";	
		}
		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();

		sql_task = "SELECT GET_TASK_APPLICABILITY('MOIDFY_PROCEDURE',NULL,?,?,?,?,?) FROM DUAL";
		pstmt = con.prepareStatement(sql_task);
		pstmt.setString(1,resp_id);
		pstmt.setString(2,reln_id);
		pstmt.setString(3,operating_facility_id);
		pstmt.setString(4,Encounter_Id);
		pstmt.setString(5,patient_id);
		
		rset= pstmt.executeQuery();
		if(rset!=null)
		{
			if(rset.next())
			{
				modify_Yn = rset.getString(1);
			}
		}
		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();

		sql="Select proc_code_scheme scheme,decode(proc_code_scheme,'3','CPT4','4','ICD9-CM','6','ICD10-PCS') scheme_desc from mr_parameter";
		try
		{
			stmt=con.prepareStatement(sql);
			rset=stmt.executeQuery();
			if(rset!=null)
			{
				while(rset.next())
				{
					s_scheme=rset.getString(1);
					s_scheme_desc =rset.getString(2);
				}
			}
			if(rset != null)rset.close();
			if(stmt != null)stmt.close();
			if(pstmt!=null)pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}

		if (mode.equals("OR"))
		{
			s_scheme = "";
			try
			{
    			if (s_scheme.equals("3"))
				{
    				sql="Select cpt_code proc_code,short_desc from mr_cpt_code where cpt_code=?";
    			}
				else if ((s_scheme.equals("4"))||(s_scheme.equals("6")))
				{
    				sql="Select diag_code proc_code,short_desc,record_type,cause_indicator from mr_icd_code where record_type='O' and diag_code=?";
    			}
				else
				{
					sql="select term_code proc_code,short_desc ,long_desc from mr_term_code where term_set_id like upper(?) and term_code like upper(?)";
				}
    		  
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,term_set_id);
    			pstmt.setString(2,upd_code);
    			rset = pstmt.executeQuery();
    			while(rset.next())
				{
					proc_code = rset.getString("proc_code");	
					if (proc_code == null) proc_code = "";
    				desc = rset.getString("short_desc");
					if (desc == null) desc = "";
					proc_codelong_desc = rset.getString("long_desc");
    				if (proc_codelong_desc == null) proc_codelong_desc = "";
    			}
		 
				if(rset != null) rset.close();
		  
			}
			catch (Exception e)
			{
				e.printStackTrace() ;
			}
		}
%>

<script>
    var dt1;
    function proc_getcode_temp(Obj)
    {
		if(makeValidString(Obj)==false || document.OPProc_form.mode.value == 'update')
            return false;

		var pq = document.OPProc_form.s_scheme.value;pq="";
		var p_called_from_widget  = document.OPProc_form.p_called_from_widget.value;
		if (pq == 3 || pq == 4|| pq == 6)
		{
			var p_code = Obj.value;
			var p_scheme    = '<%=s_scheme%>';
			var modal_yn = document.OPProc_form.modal_yn.value;

			if(modal_yn == "Y")
			{
				HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eCA/jsp/getProcCodeModal.jsp'><input type='hidden' name='p_code' id='p_code' value='"+p_code+"'><input type='hidden' name='p_scheme' id='p_scheme' value='"+p_scheme+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+modal_yn+"'></form></body></html>";
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(p_called_from_widget!=""){
					HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eCA/jsp/getProcCodeModal.jsp'><input type='hidden' name='p_code' id='p_code' value='"+p_code+"'><input type='hidden' name='p_scheme' id='p_scheme' value='"+p_scheme+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+modal_yn+"'></form></body></html>";
				}else{
				//CHL-CRF End.[IN035950]
					HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eCA/jsp/getProcCode.jsp'><input type='hidden' name='p_code' id='p_code' value='"+p_code+"'><input type='hidden' name='p_scheme' id='p_scheme' value='"+p_scheme+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+modal_yn+"'></form></body></html>";
				}//CHL-CRF [IN035950]
			}

			if(modal_yn == "Y")
			{
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.messageFrame.document.form1.submit();
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(p_called_from_widget!=""){
					parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.messageFrame.document.form1.submit();
				}else{
				//CHL-CRF End.[IN035950]
					top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					top.content.messageFrame.document.form1.submit();
				}//CHL-CRF [IN035950]
			}
		}
		else
		{
			
			var term_set_id = document.OPProc_form.proc_set.value;
			var term_code = Obj.value;
			var modal_yn = document.OPProc_form.modal_yn.value;
			if(modal_yn == "Y")
			{
				HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eCA/jsp/getProcCodeModal.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='term_code' id='term_code' value='"+term_code+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+modal_yn+"'></form></body></html>";
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(p_called_from_widget!=""){
					HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eCA/jsp/getProcCodeModal.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='term_code' id='term_code' value='"+term_code+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+modal_yn+"'></form></body></html>";
				}else{
				//CHL-CRF End.[IN035950]
					HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eCA/jsp/getProcCode.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='term_code' id='term_code' value='"+term_code+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+modal_yn+"'></form></body></html>";
				}//CHL-CRF [IN035950]
			}

			if(modal_yn == "Y")
			{
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.messageFrame.document.form1.submit();
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(p_called_from_widget!=""){
					parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.messageFrame.document.form1.submit();
				}else{
				//CHL-CRF End.[IN035950]
					top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					top.content.messageFrame.document.form1.submit();
				}//CHL-CRF [IN035950]
			}
			
		}
	}
	

    async function show_window()
    {
		var s_scheme=document.forms[0].s_scheme.value;
		var retVal =    new String();
		var dialogHeight= "28" ;
		var dialogWidth = "43" ;
		var status = "no";
		var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal =await  window.showModalDialog("../../eCA/jsp/SearchProcedureMain.jsp?s_scheme="+s_scheme+"&s_scheme_desc=<%=s_scheme_desc%>",arguments,features);

		if (!(retVal == null))
		{
			var vals=retVal.split("/");
			document.OPProc_form.code.value=vals[0];
			if(vals[1] == null || vals[1] == undefined)
			{
				vals[1] = "";
			}
			document.OPProc_form.description1.value=vals[1];
		}
		document.OPProc_form.code.focus();
    }

    function val_date(obj)
	{
		if(obj.value !='')
		{
			if(doDateTimeChk(obj))
			{
				HTMLVal = "<html><body><form name='form1' id='form1' method='post' action='../../eCA/jsp/getProcCode.jsp'><input type='hidden' name='validate_dttime' id='validate_dttime' value='Y'><input type='hidden' name='to_dttime' id='to_dttime' value='"+obj.value+"'></form></body></html>";
				top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				top.content.messageFrame.document.form1.submit();
			}
			else
			{
				alert(getMessage("INVALID_DATE_TIME","CA"));
				window.event.returnValue = false;
			}
	   }
	}		
</script>

<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' onload='checkPractitioner();'>
<form name='OPProc_form' id='OPProc_form' action="../../servlet/eCA.ProceduresServlet"  method='post' target='messageFrame'>
<input type="hidden" name="locale" id="locale" value="<%=locale%>"> <!-- SRR20056-SCF-9395 [IN037505] -->
<input type="hidden"  name="modal_yn" id="modal_yn"	value="<%=modal_yn%>">
<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from_widget%>'> <!-- //CHL-CRF [IN035950]-->
<br>
        <table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' height='100%'>
			<tr align="left">
				<th class='COLUMNHEADER' colspan=2 ><fmt:message key="Common.NewProcedure.label" bundle="${common_labels}"/></th>
				<th class='COLUMNHEADER' colspan=2 id=disMar ><font color=red></font></th>
			</tr>
			<tr>
				<td  class='label'><fmt:message key="eCA.ProcedureSet.label" bundle="${ca_labels}"/></td>
                <td colspan='2' class='FIELDS'>					
					<%
						if(!term_set_id.equals("")) {  %> 
					<select name="code_set" id="code_set"  disabled <option value='<%=term_set_id%>''></option>
					<% } else { %>
					<select name="code_set" id="code_set" <%if(mode.equals("update") ||( modal_yn.equals("Y")&&!called_from.equals("MR"))){%> disabled <%}%> onChange="showTable(this);" ><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
		<% }
					if(sql_proc.length() > 0) sql_proc.delete(0,sql_proc.length());
					sql_proc.append("select a.term_set_id,priority_appl_yn||'='||nature_appl_yn||'='||severity_appl_yn||'='||onset_type_appl_yn||'='||factors_appl_yn||'='||notification_appl_yn term_set_id1,term_set_desc "); 
					sql_proc.append("from mr_term_set a where exists (select 1 from mr_term_set_for_facility where FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from "); 
					sql_proc.append("mr_term_set_for_pract_type where PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID) ");
					if (!patient_class.equals("XT"))
					sql_proc.append(" and exists (select 1 from mr_term_set_for_specialty where SPECIALTY_CODE in (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?) AND TERM_SET_ID=A.TERM_SET_ID)  "); 
					sql_proc.append(" and (exists (select 1 from mr_term_set_for_pract ib  where PRACTITIONER_ID=? AND "); 
					sql_proc.append(" TERM_SET_ID=A.TERM_SET_ID) or not exists (select 1 from "); 
					sql_proc.append(" mr_term_set_for_pract  where PRACTITIONER_ID=?) ) and "); 
					sql_proc.append(" Eff_status='E' and proc_spec_yn='Y' order by term_set_desc");
			
					pstmt = con.prepareStatement(sql_proc.toString());
					pstmt.setString(i++,operating_facility_id);
					pstmt.setString(i++,practitioner_type);

					if (!patient_class.equals("XT"))
					{
						pstmt.setString(i++,operating_facility_id);
						pstmt.setString(i++,Encounter_Id);
					}
					pstmt.setString(i++,practitioner_id1);
					pstmt.setString(i++,practitioner_id1);
					rset = pstmt.executeQuery();

					while(rset.next())
					{
						String proc_desc = rset.getString("term_set_desc");
						String proc_set_id = rset.getString("term_set_id")+"~"+proc_desc;
						String temp_proc_set = rset.getString("term_set_id");
						
						if(term_set_id.equals(temp_proc_set))
						{
							out.print("<option value='"+proc_set_id+"' selected >"+proc_desc+"</option>");
						}
						else
						{
							out.print("<option value='"+proc_set_id+"' >"+proc_desc+"</option>");
						}
					}
					if(rset	!= null)   rset.close();
					if(pstmt  != null)   pstmt.close();		
		%>
					</select><img src='../../eCommon/images/mandatory.gif'>
					<input type="hidden" name="proc_set" id="proc_set" value="<%=term_set_id%>">
					<input type="hidden" name="proc_set_desc" id="proc_set_desc" value="">
				</td>
				<td width='25%'></td>
            </tr>
            <tr id='proc_CODE' style='<%=disp_code%>'>
                <td width = 25% class='label' ><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></td>
                <td   class='FIELDS'>
					<input type="text"  name="code" id="code" value="<%=proc_code%>" size='20' maxlength="30" <%=code_disable%> onkeypress="return CheckForSpecChars2(event)" onBlur = 'return proc_getcode_temp(this)' <%if(mode.equals("OR")) {%>readonly<%}%> readonly><img src='../../eCommon/images/mandatory.gif'align='center'><input type="button" class='Button' name="exclamation" id="exclamation" title='Long Description' value="!" onClick='showDescription(description)' style='<%=(proc_codelong_desc.equals("") ? "visibility:hidden":"visibility:visible")%>' ><input type="hidden" name="s_scheme" id="s_scheme"   value=<%//=s_scheme%>><input type="button" class='Button' name="search_button" id="search_button" title='Search' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick='callTermCode()' <%=(mode.equals("OR") ? "disabled":"")%> <%=(mode.equals("update") ? "disabled":"")%> disabled>
				</td>
               <td> </td><td></td>
            </tr>
            <tr id='proc_DESC' style='<%=disp_code%>'>
				<td class='label'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td colspan='2' class='fields'>
                    <input type="text"  onBlur="makeValidString(this);" name="description1" id="description1" value="<%if(mode.equals("update")) out.print(proc_narration); else out.print(desc);%>"  style="width: 340px;" maxlength=100 readonly><img src='../../eCommon/images/mandatory.gif'><input type="hidden" onBlur="makeValidString(this);"  name="description" id="description" value="<%if(mode.equals("update")) out.print(proc_codelong_desc); else out.print(desc);%>">
				</td>
				<!--36285 start-->
				<%
			        if(enablePriSecProc.equals("Y")) {  %> 
		      <td class='fields' align='right'>&nbsp;&nbsp; <fmt:message key="eCA.ClassificationType.label" bundle="${ca_labels}"/> &nbsp; 
				 <select name='classifition_type' id='classifition_type' onChange="validatePrimaryClassificationAvaliableYN();"  <%if(mode.equals("update") && !"".equals(classifition_type) ){%> disabled <%}%>>
				     <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${ca_labels}"/>-----</option>
					 <option value='P' <%if("P".equals(classifition_type)){%>select<%} %> ><fmt:message key="eCA.Primaryppx.label" bundle="${ca_labels}"/></option>
					 <option value='S' <%if("S".equals(classifition_type)){%>select<%} %> ><fmt:message key="eCA.Secondaryppx.label" bundle="${ca_labels}"/></option>
				 </select><img src='../../eCommon/images/mandatory.gif'>
				</td>
				<%
				if(mode.equals("update"))
				{
			%>
					<script>
						document.forms[0].classifition_type.value = '<%=classifition_type%>';
						if('<%=modify_Yn%>' == 'X')
							document.forms[0].classifition_type.disabled = true;
					</script>
			<%		
				}
			%>
				<%
				  } else{
				%>
				<td<input type="hidden" name="classifition_type" id="classifition_type" value=""></td>
				<%
				  }
			    %>
				<!--36285 start-->				
				
				 <td class='fields' align='right'>&nbsp;&nbsp; <fmt:message key="eCA.Laterality.label" bundle="${ca_labels}"/> &nbsp;
					<select name='laterality' id='laterality'>
						<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
						<option value='L'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
						<option value='R'><fmt:message key="eCA.Right.label" bundle="${ca_labels}"/></option>
						<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			<%
				if(mode.equals("update"))
				{
			%>
					<script>
						document.forms[0].laterality.value = '<%=laterality_ind%>';
						if('<%=modify_Yn%>' == 'X')
							document.forms[0].laterality.disabled = true;
					</script>
			<%		
				}
			%>
            </tr>
			<%
				String dt = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			%>
            <tr>
				<td class='label' width ='24%'><fmt:message key="eCA.StartingTime.label" bundle="${ca_labels}"/></td>
				<td class='FIELDS'>
			<%
					if(mode.equals("update"))
					{
				
			%>
						<input type='text' size=16 maxlength='16' name='date' id='date' value='<%=proc_date%>' <%if(modify_Yn.equals("X")){%>readonly<%}else{%>onblur="callCheckDateTime(this);timeCalculate(this);"<%}%>><%if(!modify_Yn.equals("X")){%><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('date');"><%}%><img src='../../eCommon/images/mandatory.gif'><input type='hidden' name='ServerDate' id='ServerDate' value='<%=proc_date%>'>
			<%
					}
					else
					{
						
			%>
						<input type='text' size=16 maxlength='16' name='date' id='date' value='<%=dt%>' onblur="callCheckDateTime(this);timeCalculate(this);"><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('date');" ><img src='../../eCommon/images/mandatory.gif'  ><input type='hidden' name='ServerDate' id='ServerDate' value='<%=dt%>'>
			<%
					}
			%>
				</td>
				<td class='label'><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
				<td class='fields' nowrap>
					<input type=text name=Hrs id=Hrs size=3 maxlength='2' value='' onKeyPress = "return allowValidNumber(this,event,2,0);" <%if((mode.equals("update")&& modify_Yn.equals("X"))){%>readonly<%}else{%>onBlur=' timeCalculate(this);CheckPositiveNumber(this);'<%}%>>&nbsp;Hrs. <input type=text name=Min id=Min size=3 maxlength='2' value='' <%if((mode.equals("update")&& modify_Yn.equals("X"))){%>readonly<%}else{%>onBlur='checkDur(this);timeCalculate(this);CheckPositiveNumber(this);'<%}%> onKeyPress = "return allowValidNumber(this,event,2,0);" maxlength=2>&nbsp; Min.
				</td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="eCA.EndingTime.label" bundle="${ca_labels}"/></td>
				<td class='fields'>
			<%
					if(mode.equals("update"))
					{
			%>
						<input type='text' size=16 maxlength='16' name='enddate' id='enddate' value='<%=end_datetime%>'  <%if(modify_Yn.equals("X")){%>readonly<%}else{%>onblur="callCheckDateTime(this);clear_hrs();timeCalculate(this);"<%}%>><%if(!modify_Yn.equals("X")){%><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('enddate');"><%}%>
						<input type='hidden' name='ServerDate1' id='ServerDate1' value='<%=end_datetime%>'>
			<%
					}
					else
					{
			%>
						<input type='text' size=16 maxlength='16' name='enddate' id='enddate' value=''  onblur="callCheckDateTime(this);clear_hrs();timeCalculate(this);"><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('enddate');">
						<input type='hidden' name='ServerDate1' id='ServerDate1' value='<%=dt%>' >
			<%
					}
			%>
				</td>
			<%
					if(mode.equals("update"))
					{
			%>
						<script language=javascript>
							if(document.forms[0].enddate.value != "")
							{
								document.forms[0].enddate.focus();
								document.forms[0].enddate.blur();
							}
						</script>
			<% 
					} 
			%>		

			<td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='FIELDS'>
				<input type='text' name='loc' id='loc' size='15' maxlength='30' value='<%=(mode.equals("update")?locn_desc:"")%>' <%if((mode.equals("update")&& modify_Yn.equals("X"))){%>readonly<%}else{%>onBlur="populateLocation()"<%}%>><input type='button' class='button' value='?'  name='searchLoc' id='searchLoc' onClick="populateLocation()" <%=((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")%>><input type=hidden name='Location' id='Location' value='<%=(mode.equals("update")?proc_perf_locn_code:"")%>'>
			</td>
			</tr>
			
            <tr>
				<td class='label' width='10%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td colspan=3 class='fields'>
					<input type='text' name='pract' id='pract' size='15' maxlength='30' value='<%=(mode.equals("update")?upd_practitioner_name:practitioner_name)%>' <%if((mode.equals("update")&& modify_Yn.equals("X"))){%>readonly<%}else{%>onBlur="populatePract_blur(this)"<%}%>><input type='button' class='button' value='?'  name='searchpract' id='searchpract' onClick="populatePract()" <%=((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")%>><input type=hidden name='practitioner' id='practitioner' value='<%=mode.equals("update")?(upd_practitioner_id):(practitioner_id1)%>'><img src='../../eCommon/images/mandatory.gif'align='center'>

					<b>,</b><input type='text' name='pract1' id='pract1' size='15' maxlength='30' value='<%=(mode.equals("update")?ass_pract_name:"")%>' <%if((mode.equals("update")&& modify_Yn.equals("X"))){%>readonly<%}else{%>onBlur="populatePract2_blur(this)"<%} if(upd_practitioner_id.equals("")&&practitioner_id1.equals("")){%>readonly<%}%>><input type='button' class='button' value='?'  name='searchpract2' id='searchpract2' onClick="populatePract2()" <%=(((mode.equals("update")&& modify_Yn.equals("X"))||(upd_practitioner_id.equals("")&&practitioner_id1.equals("")))?"disabled":"")%>><input type=hidden name='practitioner1' id='practitioner1' value='<%=(mode.equals("update")?ass_practitioner2:"")%>'>

					<b>,</b><input type='text' name='pract2' id='pract2' size='15' maxlength='30' value='<%=(mode.equals("update")?ass_pract_name3:"")%>' <%if((mode.equals("update")&& modify_Yn.equals("X"))){%>readonly<%}else{%>onBlur="populatePract3_blur(this)"<%}if(ass_practitioner2.equals("")) { %>readonly<%}%> ><input type='button' class='button' value='?'  name='searchpract3' id='searchpract3' onClick="populatePract3()" <%=(((mode.equals("update")&& modify_Yn.equals("X"))||(ass_practitioner2.equals("")))?"disabled":"")%>><input type=hidden name='practitioner2' id='practitioner2' value='<%=(mode.equals("update")?ass_practitioner3:"")%>'> 
				</td>
			</tr>	
			<tr>
				<td class='label' width='10%'><fmt:message key="eCA.Anaesthetists.label" bundle="${ca_labels}"/>&nbsp;</td>
				<td colspan=3 class='fields'>
					<select name='anaesthetists1' id='anaesthetists1' onchange='chkDupPract(this)' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")%>><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
            <%
						sql="Select b.practitioner_name,a.practitioner_id from am_pract_for_facility A, AM_PRACTITIONER_LANG_VW B where a.facility_id= ? and a.eff_status='E' and b.pract_type='AN' and a.practitioner_id = b.practitioner_id and b.language_id = ? order by 1";
						try
						{
							stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							stmt.setString(1,operating_facility_id);
							stmt.setString(2,locale);
							rset=stmt.executeQuery();
							if(rset!=null)
							{
								while(rset.next())
								{
									name=rset.getString(1);
									id =rset.getString(2);
									if(mode.equals("update"))
									{
										if (id.trim().equalsIgnoreCase(anaesthetist1))
											sel="selected";
										else 
											sel="";
									}
									else
									{
											sel="";
									}
									out.println("<option value='"+id+"'" + sel +">"+name+"</option>");
								}
							}
														  
						}
						catch(Exception e)
						{
							e.printStackTrace() ;
						}
			%>
					</select><b>,</b><select name='anaesthetists2' id='anaesthetists2' onchange='chkDupPract(this)' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")%>><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
            <% 
						try
						{
							rset.beforeFirst();
							if(rset!=null)
							{
								while(rset.next())
								{
									name=rset.getString(1);
									id =rset.getString(2);
									if(mode.equals("update"))
									{
										if (id.trim().equalsIgnoreCase(anaesthetist2))
											sel="selected";
										else
											sel="";
									}
									else
									{
										sel="";
									}
									out.println("<option value ='"+id+"'" + sel +">"+name+"</option>");
								}
							}
						}
						catch(Exception e)
						{
							e.printStackTrace() ;
						}

             %>
					</select><b>,</b><select name='anaesthetists3' id='anaesthetists3' onchange='chkDupPract(this)' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")%>><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
             <% 
						try
						{
							rset.beforeFirst();
							if(rset!=null)
							{
								while(rset.next())
								{
									name=rset.getString(1);
									id =rset.getString(2);
									if(mode.equals("update"))
									{
										if (id.trim().equalsIgnoreCase(anaesthetist3))
											sel="selected";
										else 
											sel="";
									}
									else
									{
										sel="";
									}
									out.println("<option value='"+id+"'" + sel +">"+name+"</option>");
								}
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
							}
							catch(Exception e)
							{
								e.printStackTrace() ;
							}

				%>
					</select></td></tr>
			<%
				if(mode.equals("update"))
				{
					if(!scrub_nurse.equals(""))
					{
						sql="Select b.practitioner_name description,a.practitioner_id code from am_pract_for_facility A,AM_PRACTITIONER_LANG_VW B where a.facility_id= ? and a.eff_status='E' and b.pract_type='NS'  and a.practitioner_id = b.practitioner_id and b.language_id = ? and  upper(a.practitioner_id)  like upper(?)";
						try
						{
							stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							stmt.setString(1,operating_facility_id);
							stmt.setString(2,locale);
							stmt.setString(3,scrub_nurse);
							rset=stmt.executeQuery();
							if(rset!=null)
							{
								while(rset.next())
								{
									scrubname=rset.getString("description");
								}
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
						}
						catch(Exception e)
						{
							e.printStackTrace() ;
						}
					}
				}
			%>
			<tr>
				<td  class='label' width='10%'><fmt:message key="Common.ScrubNurse.label" bundle="${common_labels}"/></td>
				<td colspan=3 class='FIELDS'>
					<input type='text' name='nurse' id='nurse' size='15'  value='<%if(mode.equals("update")) out.println(scrubname);%>' <%if((mode.equals("update")&& modify_Yn.equals("X"))){%>readonly<%}else{%>onBlur="populateNurse()"<%}%>><input type='button' class='button' value='?'  name='' id='' onClick="populateNurse()" <%=((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")%>><input type=hidden name='scrubnurse' id='scrubnurse' value='<%=(mode.equals("update")?scrub_nurse:"")%>'>
				</td>
									
			</tr>	
			<tr>
				<td class='label' width='10%'><fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>&nbsp;</td>
				<td colspan=3 class='FIELDS'> 
					<select name='anaesthesia' id='anaesthesia' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")%>><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
            <%
					sql="Select AM_GET_DESC.AM_ANAESTHESIA(ANAESTHESIA_CODE,?,'1')  LONG_DESC,ANAESTHESIA_CODE from AM_ANAESTHESIA where eff_status='E' order by 1";     
					try
					{
						stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						stmt.setString(1,locale);
						rset=stmt.executeQuery();
						if(rset!=null)
						{
							while(rset.next())
							{
								name=rset.getString(1);
								id =rset.getString(2);
								if(mode.equals("update"))
								{
									if (id.trim().equalsIgnoreCase(anaesthesia_code))
										sel="selected";
									else
										sel="";
								}
								else
								{
									sel="";
								}
								out.println("<option value='"+id+"' " + sel +">"+name+"</option>");
							}
						}
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
						if(stmt!=null) stmt.close();
					}
					catch(Exception e)
					{
						e.printStackTrace() ;
					}
			%>
					</select>
				</td>
			</tr>	
			<tr>
                    <td class="label"><fmt:message key="Common.AnaesthesiaDetails.label" bundle="${common_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="anaesthesDet" rows='2' maxlength=500  onFocus='getObject(this)'  onKeyPress='checkMaxLimit(this,500);'   onBlur="makeValidString(this);" cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=anaesthesia_detail%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="eCA.Indication.label" bundle="${ca_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="indication" rows='2'  maxlength=2000 onFocus='getObject(this)'                   onKeyPress='checkMaxLimit(this,2000);'  onBlur="makeValidString(this);" cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=indication%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="Common.Monitoring.label" bundle="${common_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="monitor" rows='2'  onFocus='getObject(this)' onBlur="makeValidString(this);" maxlength=500 onKeyPress='checkMaxLimit(this,500);' cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=monitoring%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="eCA.HPI.label" bundle="${ca_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="hpi" rows='2' maxlength=500  onFocus='getObject(this)' onKeyPress='checkMaxLimit(this,500);'   onBlur="makeValidString(this);" cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=hpi%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="eCA.ProcedureSummary.label" bundle="${ca_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="proceduresummary" rows='2'  maxlength=2000  onFocus='getObject(this)'                     onKeyPress='checkMaxLimit(this,2000);'  onBlur="makeValidString(this);" cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=proc_summary%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="Common.Findings.label" bundle="${common_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="findings" rows='2' onBlur="makeValidString(this);" maxlength=500  onFocus='getObject(this)' onKeyPress='checkMaxLimit(this,500);' cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=findings%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="eCA.Impression.label" bundle="${ca_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="impression" rows='2' onBlur="makeValidString(this);" cols='60'  onFocus='getObject(this)' onKeyPress='checkMaxLimit(this,200);' maxlength=200 <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=impression%></textarea>
					</td>
            </tr>
            <tr>
                    <td  class="label"><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="disposition" rows='2' maxlength=200 onBlur="makeValidString(this);"  onFocus='getObject(this)' onKeyPress='checkMaxLimit(this,200);' cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=disposition%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="Common.Events.label" bundle="${common_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="events" rows='2' onBlur="makeValidString(this);" maxlength=500  onFocus='getObject(this)' onKeyPress='checkMaxLimit(this,500);' cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=events%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="eCA.PostProcedureStdOrders.label" bundle="${ca_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="postProcedure" rows='2' onBlur="makeValidString(this);" cols='60'  onFocus='getObject(this)' onKeyPress='checkMaxLimit(this,200);' maxlength=200 <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=post_proc_std_orders%></textarea>
					</td>
            </tr>
            <tr>
                    <td class="label"><fmt:message key="eCA.SpecimenSent.label" bundle="${ca_labels}"/>&nbsp;</td>
                    <td colspan='3' class='FIELDS'>
						<textarea style="resize:none"  name="specimen" rows='2' maxlength=200 onBlur="makeValidString(this);"  onFocus='getObject(this)' onKeyPress='checkMaxLimit(this,200);' cols='60' <%=((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")%>><%=specimen_sent%></textarea>
					</td>
            </tr>
        </table>
        <input type="hidden"  name="practitionernameSESSION" id="practitionernameSESSION"    value="<%=practitioner_id1%>">
        <input type="hidden"  name="locncode" id="locncode"       value="<%=locn_code%>">
        <input type="hidden"  name="locntype" id="locntype"       value="<%=locn_type%>">
        <input type="hidden"  name="facility_id" id="facility_id"         value="<%=operating_facility_id%>">
        <input type="hidden"  name="facilityid" id="facilityid"         value="<%=operating_facility_id%>">
        <input type="hidden"  name="encounterid" id="encounterid"        value="<%=encounter_id%>">
        <input type="hidden"  name="patientid" id="patientid"      value="<%=patient_id%>">
        <input type="hidden"  name="record_type" id="record_type"        value="<%=record_type%>">
        <input type="hidden"  name="cause_indicator" id="cause_indicator"    value="<%=cause_indicator%>">
        <input type="hidden"  name="patient_class" id="patient_class"      value='<%=patient_class%>' >
		<input type="hidden"  name="mode" id="mode"				value="<%=mode%>">
		<input type="hidden"  name="upd_pat_id" id="upd_pat_id"			value="<%=upd_pat_id%>">
		<input type="hidden"  name="upd_srl_no" id="upd_srl_no"			value="<%=upd_srl_no%>">
		<input type="hidden"  name="upd_encounter_id" id="upd_encounter_id"	value="<%=upd_encounter_id%>">
		<input type="hidden"  name="order_id" id="order_id"	value="<%=order_id%>">
		<input type="hidden"  name="order_line_num" id="order_line_num"	value="<%=order_line_num%>"> 
		<input type="hidden"  name="dup_chk" id="dup_chk"	value="">

		<input type="hidden"  name="dummy" id="dummy"	value="">
		<input type="hidden" name="errorRemarks" id="errorRemarks" value="">
		<input type="hidden" name="visitdate" id="visitdate" value="<%=visitdate%>">
		<input type="hidden" name="visit_adm_date_time" id="visit_adm_date_time" value="<%=visit_adm_date_time%>">
		<input type="hidden" name="qryStr" id="qryStr" value="<%=request.getQueryString()%>">
		<!--	<input type="hidden" name="locale" id="locale" value="<%=locale%>"> - commented for  SRR20056-SCF-9395 [IN037505] --> 
		<input type="hidden" name="accession_number" id="accession_number" value="<%=accession_number%>"> 
		<input type="hidden" name="curr_level" id="curr_level" value="<%=curr_level%>">
		<input type="hidden" name="enablePriSecProc" id="enablePriSecProc" value="<%=enablePriSecProc%>"><!-- // 36285 -->
		<input type="hidden" name="p_classifition_type" id="p_classifition_type" value="<%=classifition_type%>">
		</td>	
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

