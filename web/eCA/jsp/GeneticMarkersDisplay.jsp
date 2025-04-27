<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
19/03/2012	  Bru-HIMS-0154	 Menaka V	 	The View Future Bookings/Appointments hyperlink will be visible for the patient in Chart summary
											only if the patient has got any future bookings/Appointments.		
24/12/2012	  ML-BRU-SCF-0373	Karthi L	The View Future Bookings/Appointments hyperlink will be visible for the patient in Chart summary
											only if the patients has got any future bookings/Appointments. Currently past
											appointments also display this hyperlink for radiology appointment patients..
-----------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------
27/06/2014	  IN045536		Karthi L	27/06/2014		Akbar				To provide a visual indication for the clinician to indicate the minimum data set is met/not met and the ability for the clinician to check what is pending (similar to the check already provided).											
19/08/2014	  IN050593		Karthi L	19/08/2014		Akbar				 The Label should be ?MDS Criteria Met? and ?MDS Criteria Not Met?.
26/03/2014    IN054712		Nijitha S	 									 System displays the priority zone inconsistently.
09/01/2016	IN057106		Vijayakumar K	09/01/2016		Ramesh Goli		ML-MMOH-CRF-0328 [IN:057106]
14/01/2016	IN058872		Vijayakumar K	14/01/2016		Ramesh goli	 	ML-MMOH-CRF-0328/01 - System doesn't display a 
																			new Field ?Antibody? in Patient Chart Screen beside Rh Factor field with no value [IN:058872]
20/01/2016	IN058921		Vijayakumar K	20/01/2016		Ramesh Goli		ML-MMOH-CRF-0328/02 - System doesn't display 
																			Antibody values in Bold, Antibody description is wrong. [IN:058921]
29/02/2016	IN057106_changed Vijayakumar K	29/02/2016		Ramesh Goli		ML-MMOH-CRF-0328
06/08/2018  IN063885         Ramya Maddena  07/08/2018      Ramesh Goli     MMS-DM-CRF-0103
15/04/2023		37866			Ramesh G									MMS-DM-CRF-0226
22/09/2023	28906	   Ranjith P R		25/07/2023		RAMESH G		ML-MMOH-CRF-1846.1
04/11/2024	70705	   Gunasekar R		05/11/2024		 Ashwini Ragupathi  ML-MMOH-CRF-1759
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page language="java" import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/CACommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- 37866 -->
<script>
	async function ImmunizationDetails(){
		var queryString = "<%=request.getQueryString()%>";//document.refForm.queryString.value;
		var dialogHeight= "60vh" ;
		var dialogWidth	= "60vw" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto;  status:" + status;
	await	window.showModalDialog("../../eCA/jsp/Immunization.jsp?"+queryString,arguments,features);
		return false;
	}

	async function researchPatient(){
		var queryString = "<%=request.getQueryString()%>";//document.refForm.queryString.value;
		var dialogHeight= "60vh" ;
		var dialogWidth	= "60vw" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
		await window.showModalDialog("../../eCA/jsp/ResearchPatient.jsp?"+queryString,arguments,features);
		return false;
	}

	async function growthChart(chart_id,P_patient_id,sex){
		var queryString = "<%=request.getQueryString()%>";//document.refForm.queryString.value;
		var dialogHeight= "80vh" ;
		var dialogWidth	= "80vw" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
	await 	window.showModalDialog("../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?splChartType=GR&chart_id="+chart_id+"&patient_id="+P_patient_id+"&Sex="+sex,arguments,features);
		return false;
	}
/*	async function TriageDetail(){
		var queryString = "<%=request.getQueryString()%>";
		var dialogHeight= "60vh" ;
		var dialogWidth	= "60vw" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
		await window.showModalDialog("../../eCA/jsp/TriageDetail.jsp?"+queryString,arguments,features);
		return false;
	}*/
	async function TriageDetail(patient_id,encounter_id,visit_adm_date_time)
	{
		
	     var retVal = "";
			var function_id ="query";
			var dialogHeight= "95vh" ;
			var dialogWidth	= "95vw" ;
			var dialogTop ="";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id="+patient_id+"&episode_id="+encounter_id+"&rec_date_time="+visit_adm_date_time+"&function_id="+function_id;//IN054712 Changed key visit_adm_date_time to rec_date_time
			retVal = await top.window.showModalDialog(action_url,arguments,features);
	}
	//IN063885 start
	function displayMRReports(p_patient_id,p_encounter_id,p_facility_id,p_note_type)
	{	
		var queryString = "<%=request.getQueryString()%>";
		var retVal="";
		var p_report_id="CABMEDRPT";
		var p_module_id="CA";
		var dialogHeight	= "10" ;
		var dialogWidth	= "30" ;
		var status = "no";
		var scroll = "yes";
		var dialogTop = "140";
		var arguments	= "" ;
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;	
		
		var params = "&p_report_id="+p_report_id+"&p_module_id="+p_module_id+"&p_facility_id="+p_facility_id;
		
		document.GenMarkersDispForm.action = "../../eCommon/jsp/report_options.jsp?p_note_type="+p_note_type+"&p_patient_id="+p_patient_id+"&p_encounter_id="+p_encounter_id+params;
		document.GenMarkersDispForm.submit();

	}
	//IN063885 end 
	//28906 starts
	async function PhenotypeDetails(){
		var queryString = "<%=request.getQueryString()%>";
		var dialogHeight= "18" ;
		var dialogWidth	= "45" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto;  status:" + status;
		await window.showModalDialog("../../eCA/jsp/PhenotypeDetails.jsp?"+queryString,arguments,features);
	}
	//28906 ends
</script>	
</head>

<body class='CONTENT'  OnMouseDown="CodeArrest()" onLoad="" onKeyDown="lockKey()">
<!--IN063885 start-->
<!--<form name='' id='' method=post target="messageFrame">-->
<form name='GenMarkersDispForm' id='GenMarkersDispForm' method=post target="messageFrame">
<!--IN063885 end-->
</form>
<%
	
	String P_patient_id = request.getParameter("patient_id");
	String sex = request.getParameter("Sex");
	String encounter_id = request.getParameter("encounter_id");
	if (encounter_id==null) encounter_id="";
	//37866 Start.
	String episode_type = request.getParameter("episode_type");
	String clinicianId =(String)session.getValue("ca_practitioner_id");
	if(clinicianId == null) clinicianId="";
	//37866 End.
	String visit_adm_date = request.getParameter("visit_adm_date");
	if (visit_adm_date==null) visit_adm_date="";
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	StringBuffer strBuff_display = new StringBuffer();
	strBuff_display.append("&nbsp;");
	//String display = "&nbsp;"; 
	String blood_grp ="";
	String rh_factor ="";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String facilityId = (String)session.getValue("facility_id"); //IN045536 
	int mds_chk_cnt = 0; // IN045536 
	String mr_mds_recorded_yn = "";	 // IN045536 
	int iTotalNoOfAntibody = 0; //IN057106_changed

	String research_pat_sql ="";
	String display_mode = "";
	String triage_display_mode = "display:none";
	int count = 0 ;

	String grChSql ="";
	String chart_id ="";
	String grChart_display_mode = "display:none";

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null ;


	PreparedStatement res_pstmt=null;
	ResultSet res_rset=null ;
	if (patient_class.equals("EM") )
			triage_display_mode ="display";
    String recorded_date_time = "";	//IN054712	
	//IN057106 starts
	String AbMarkerSQL = "";
	PreparedStatement ab_pstmt=null;
	ResultSet ab_rsltset=null ;
	//IN057106 ends
	//IN063885 start
	String p_facility_id = (String)session.getValue("facility_id");			
	String sql_note_type = "";
	String p_note_type = "";
	String MRReportHypLnkYNSql = "";
	String mr_rpt_hyp_yn = "";
	String mr_rpt_hyp_yn_style = "";
	Boolean isMRReportappl = false; //IN063885
	PreparedStatement pstmt_note_type = null;
	PreparedStatement mr_rpt_hyp_yn_pstmt = null;
	ResultSet rs_note_type = null ;
	ResultSet mr_rpt_hyp_yn_rsltset = null;
	//IN063885 ends
try
{
		//IN063885 Start.
		ArrayList<String> functionIds = new ArrayList<String>();
		functionIds.add("PAT_MED_REPT");
		String bean_id = "CA_ca_patListbylocationresult" ;
		String bean_name = "eCA.PatListByLocationResult";
		PatListByLocationResult bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
		bean.setSiteSpecific(functionIds,"CA");
		isMRReportappl = bean.isSiteSpecific("PAT_MED_REPT");
		//IN063885 End.
        con=ConnectionManager.getConnection(request);
		boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866
		boolean isPhenotypeSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","PHENOTYPE_DETAILS"); //28906
		//IN054712 Starts
		String rec_dt_time_qry = "select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?";
		res_pstmt=con.prepareStatement(rec_dt_time_qry);
		res_pstmt.setString(1,facilityId );
		res_pstmt.setString(2,encounter_id );
		res_rset=res_pstmt.executeQuery();
		while(res_rset.next())
		{
			recorded_date_time = res_rset.getString("recorded_date_time");
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();	
		//IN054712 Ends
		
		grChSql = "select CHART_ID from CA_SPL_CHART_PAT_REC_DTL where patient_id=? and rownum=1";
		res_pstmt=con.prepareStatement(grChSql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			chart_id = res_rset.getString("CHART_ID");
			grChart_display_mode = "display";
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();	
		
		String virtualApptYN="N";
		if(patient_class.equals("OP")){
			res_pstmt=con.prepareStatement("SELECT oa_appt_virtual_status(?,?,?,?) virtualApptYN FROM DUAL");
			res_pstmt.setString(1,facilityId );
			res_pstmt.setString(2,P_patient_id );
			res_pstmt.setString(3,encounter_id );
			res_pstmt.setString(4,patient_class );
			
			res_rset=res_pstmt.executeQuery();

			while(res_rset.next())
			{
				virtualApptYN = res_rset.getString("virtualApptYN");
			}
			if(res_rset != null)res_rset.close();
			if(res_pstmt != null)res_pstmt.close();
		}

		research_pat_sql = "SELECT COUNT(*) as total FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?";
		res_pstmt=con.prepareStatement(research_pat_sql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			count = res_rset.getInt("total");
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();
		
		if(count>0)
		  {
			display_mode="display";
		  }
		  else
			{
			  display_mode="display:none";
		  }

		
		//String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+)" ;

		String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+) AND C.LANGUAGE_ID = ?" ;

		

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, P_patient_id );
		pstmt.setString(2, locale );

		rset=pstmt.executeQuery();

		while(rset.next())
		{
			blood_grp = rset.getString("blood_grp")	;
			rh_factor = rset.getString("rh_factor")	;
			
			
		}

		String space =  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" ;
		
		if(blood_grp != null )
		{	
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": <b>");
			strBuff_display.append(blood_grp);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}

		if(rh_factor != null )
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": <b>");
			strBuff_display.append(rh_factor);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}
		//28906 starts
		
		String sql2="";
		int TotalRecord = 0;
		PreparedStatement pstmt2=null;
		ResultSet rs1=null ;

			try
			{
				sql2		=	"SELECT SUM (rec) totalrec FROM (SELECT COUNT (*) rec FROM bt_patient_blgrp_rh_ant a, rl_result_comment_code b WHERE a.rh_pheno_type_code = b.result_comment_code AND a.patient_id = ? UNION SELECT COUNT (*) rec FROM bt_patient_rbc_phenotype a, bt_rbc_phenotype_code b WHERE a.rbc_phenotype_code = b.rbc_phenotype_code AND a.patient_id = ?)";
				pstmt2		=	con.prepareStatement(sql2);
				pstmt2.setString	(	1,	P_patient_id	);
				pstmt2.setString	(	2,	P_patient_id	);
				rs1			=	pstmt2.executeQuery();

				while(rs1.next())
				{
					TotalRecord=rs1.getInt("TOTALREC");
					
				}

			
				
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs1!=null) rs1.close();
					if(pstmt2!=null) pstmt2.close();
			}
		
			if(isPhenotypeSiteSpec)
			{
			if(TotalRecord > 0){
				strBuff_display.append("&nbsp;&nbsp;&nbsp;&nbsp;<a class='gridLink' href='javascript:PhenotypeDetails();'><font size='2'>Phenotype</font></a>");
				
			} 
			else {
				strBuff_display.append("&nbsp;&nbsp;&nbsp;&nbsp;<a class='gridLink' disabled title ='Phenotype Details Not Available.'><font size='2'>Phenotype</font></a>");
					
			}
			}
			
			//28906 ends
		
		//strBuff_display=null;
		String strsql2="";
		PreparedStatement pstmt1=null;
		ResultSet rs=null ;
		int count1=0;

			try
			{
				strsql2		=	" select  count(*) noofRecords from CA_IM_PAT_VAC_SCH_HDR a, CA_IM_PAT_VAC_SCH_DTL b where a.patient_id = ? and b.OUTCOME_CODE='C' and a.VAC_SCH_REF = b.VAC_SCH_REF   ";
				pstmt1		=	con.prepareStatement(strsql2);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
						count1=rs.getInt("noofRecords");
				}

			
				
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			//Bru-HIMS-0154 Starts
			int opCount=0;
			int ipCount=0;
			int radCount=0;
			//String rad_installed_yn="";
			boolean show_appt_btn_yn=false;
			String strsql3="";
			String strsql4="";
			String strsql5="";
			try
			{
				strsql3		=	" select count(1) as total from oa_appt where patient_id=? and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date,appt_slab_from_time  ";
				pstmt1		=	con.prepareStatement(strsql3);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
					opCount = rs.getInt("total");
				}
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			try
			{
				//strsql4		=	" SELECT count(1) as total FROM RD_APPT where patient_id=?"; // Commented for ML-BRU-SCF-0373[IN034783]
				
				strsql4		=	" SELECT count(1) as total FROM RD_APPT where patient_id=?  and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date, appt_start_time"; // modified for ML-BRU-SCF-0373[IN034783]
				
				pstmt1		=	con.prepareStatement(strsql4);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
					radCount = rs.getInt("total");
				}
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			try
			{
				strsql5		=	" select count(1) as total from ip_booking_list where  patient_id=? and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1  ";
				pstmt1		=	con.prepareStatement(strsql5);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
					ipCount = rs.getInt("total");
				}
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			if (opCount != 0 || ipCount != 0 || radCount != 0)
			{
				show_appt_btn_yn=true;
			}
			//Bru-HIMS-0154 Ends
			// IN045536 - Start
			try
			{
				String strsql6		= "";
				if(patient_class.equals("IP") || patient_class.equals("DC")) {
					strsql6		=	" select mr_mds_recorded_yn ('"+facilityId+"','"+encounter_id+"','"+patient_class+"',null,'DA',null) mr_mds_recorded from dual ";
					pstmt1		=	con.prepareStatement(strsql6);
					rs			=	pstmt1.executeQuery();

					while(rs.next())
					{
						mr_mds_recorded_yn = rs.getString("mr_mds_recorded");
						System.err.println(" 430. GenericMarkersDisplay.jsp " + mr_mds_recorded_yn);
					}
				}
				else if(patient_class.equals("OP") || patient_class.equals("EM")){
				
					strsql6		=	" select mr_mds_recorded_yn ('"+facilityId+"','"+encounter_id+"','"+patient_class+"',null,'OC',null) mr_mds_recorded from dual ";
					pstmt1		=	con.prepareStatement(strsql6);
					rs			=	pstmt1.executeQuery();

					while(rs.next()) 
					{
						mr_mds_recorded_yn = rs.getString("mr_mds_recorded");
						System.err.println(" 442. GenericMarkersDisplay.jsp " + mr_mds_recorded_yn);
					}
				}
			}
			catch(Exception e)
			{		
					System.err.println("Error in GeneticMarketDisplay"+e.toString());
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			try
			{
				String strsql7	= "";
				if(patient_class.equals("IP") || patient_class.equals("DC")) {
					strsql7		=	" select count(*) as mds_chk from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y' and  ("+patient_class+"_STAGE='ALL' or "+patient_class+"_STAGE='DA') ";
					pstmt1		=	con.prepareStatement(strsql7);
					rs			=	pstmt1.executeQuery();

					while(rs.next())
					{
						mds_chk_cnt = rs.getInt("mds_chk");
					}
				}
				else if(patient_class.equals("OP") || patient_class.equals("EM")){
					strsql7		= "select count(*) as mds_chk from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y'";
					pstmt1		=	con.prepareStatement(strsql7);
					rs			=	pstmt1.executeQuery();

					while(rs.next())
					{
						mds_chk_cnt = rs.getInt("mds_chk");
					}
				}	
			}
			catch(Exception e)
			{		
					System.err.println("Error in GeneticMarketDisplay"+e.toString());
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			// IN045536 - End
			//IN057106 starts
			try
			{
				//IN057106_changed starts
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				String bt_install_yn = "";
				pstmt = con.prepareStatement("select install_yn from sm_module where module_id='BT' ");
				rset	= pstmt.executeQuery();
				if(rset!=null  && rset.next())
				{
						bt_install_yn		= rset.getString(1);
				}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				//String ab_marker_desc="";//commented for checkstyle
				if("Y".equals(bt_install_yn))
				{
				
					AbMarkerSQL = "SELECT count(*) TOTAL_NO_OF_ANTIBODY FROM (SELECT A.ANTIBODY_CODE ANTIBODY_CODE,A.PATIENT_ID PATIENT_ID, A.LAST_REPORTED_DATE FROM BT_PATIENT_ANTIBODY A UNION SELECT DISTINCT C.ANTIBODY_CODE ANTIBODY_CODE,B.PATIENT_ID PATIENT_ID, C.LAST_REPORTED_DATE FROM BD_DONOR_MAST_DTLS B, BT_DONOR_ANTIBODY C  WHERE B.DONOR_ID = C.DONOR_ID ) a,BT_ANTIBODY_CODE_MAST_LANG_VW b  WHERE a.ANTIBODY_CODE = b.ANTIBODY_CODE AND b.language_id = ? AND PATIENT_ID = ? ";
					ab_pstmt		=	con.prepareStatement(AbMarkerSQL);
					ab_pstmt.setString	(	1,	locale	);
					ab_pstmt.setString	(	2,	P_patient_id	);
				
					ab_rsltset			=	ab_pstmt.executeQuery();
				

					while(ab_rsltset.next())
					{
					
						iTotalNoOfAntibody = ab_rsltset.getInt("TOTAL_NO_OF_ANTIBODY");
					
					}
					
				}
				//IN057106_changed	 ends
					
			}
			catch(Exception e)
			{		
					System.err.println("Error in GeneticMarkerDisplay - Antibody marker section"+e.toString());
			}
			finally
			{
					if(ab_rsltset!=null) ab_rsltset.close();
					if(ab_pstmt!=null) ab_pstmt.close();
			}
			//IN057106 ends
			//IN063885 start
			if(isMRReportappl){
				try
				{
					sql_note_type		= "select  MED_RPT_NOTE_TYPE from ca_note_param";
					pstmt_note_type		= con.prepareStatement(sql_note_type);
					rs_note_type		= pstmt_note_type.executeQuery();

					while(rs_note_type.next())
					{
						p_note_type = rs_note_type.getString("MED_RPT_NOTE_TYPE");
					}
		

					MRReportHypLnkYNSql	= "select CA_PAT_MED_RPT_YN(?,?,?,?) MR_RPT_HYP_YN from dual";
					mr_rpt_hyp_yn_pstmt	= con.prepareStatement(MRReportHypLnkYNSql);
					mr_rpt_hyp_yn_pstmt.setString(	1,	p_facility_id	);
					mr_rpt_hyp_yn_pstmt.setString(	2,	P_patient_id);
					mr_rpt_hyp_yn_pstmt.setString(	3,	encounter_id);
					mr_rpt_hyp_yn_pstmt.setString(	4,	p_note_type);
					
					mr_rpt_hyp_yn_rsltset			=	mr_rpt_hyp_yn_pstmt.executeQuery();
					
					while(mr_rpt_hyp_yn_rsltset.next())
					{
						mr_rpt_hyp_yn = mr_rpt_hyp_yn_rsltset.getString("MR_RPT_HYP_YN")==null?"":mr_rpt_hyp_yn_rsltset.getString("MR_RPT_HYP_YN");
					}

					if("Y".equals(mr_rpt_hyp_yn))
					{
						mr_rpt_hyp_yn_style = "visibility: visible";
					}
					else
					{
						mr_rpt_hyp_yn_style = "visibility: hidden";
					}
				}
				catch(Exception e)
				{		
					System.err.println("Error in GeneticMarkerDisplay - Antibody marker section"+e.toString());
				}
				finally
				{
					if(rs_note_type!=null) rs_note_type.close();
					if(mr_rpt_hyp_yn_rsltset!=null) mr_rpt_hyp_yn_rsltset.close();
					if(pstmt_note_type!=null) pstmt_note_type.close();
					if(mr_rpt_hyp_yn_pstmt!=null) mr_rpt_hyp_yn_pstmt.close();
				}
			}
			//IN063885 ends
          
			int p_count = bean.getMenstPatCount(con, P_patient_id);//70705 

		%>

	<table  width='100%' style="" border=0 valign='top' CELLSPACING=0 CELLPADDING=3 align='center'>
     <tr>
        <td  width='30%' style='CAENCOUNTERLINE'><font size='-1' ><%=strBuff_display.toString()%></td><!-- IN057106_changed -->
		<%
		//IN057106_changed starts
		if(iTotalNoOfAntibody > 0)
		{
		%>
				<td  width='20%' style='CAENCOUNTERLINE'  ><a class='gridLink' href="javascript:getAntibodyResults('<%=P_patient_id%>')"><font size='2'><fmt:message key="eCA.Antibody.label" bundle="${ca_labels}"/></font></a></td>
		<%
		}
		else
		{
		%>
				<td  width='20%' style='CAENCOUNTERLINE'  >&nbsp;</td>
		<%
		}
		//IN057106_changed ends
		%>
<% 	if (count1>0){%>
		<td  width='10%' style='CAENCOUNTERLINE'  ><a class='gridLink' href='#' onClick='return ImmunizationDetails()'><font size='2'><fmt:message key="eCA.Immunization.label" bundle="${ca_labels}"/></font></a></td>
<%}%>
		<td width='10%' style='CAENCOUNTERLINE' style="<%=display_mode%>"><a class='gridLink' href='#' onClick='return researchPatient()'><font size='2'><fmt:message key="eCA.ResearchInfo.label" bundle="${ca_labels}"/></font></a></td>
		<td  width='10%' style='CAENCOUNTERLINE' ALIGN='right' style="<%=grChart_display_mode%>"><a class='gridLink' href='#' onClick="return growthChart('<%=chart_id%>','<%=P_patient_id%>','<%=sex%>')"><font size='2'><fmt:message key="eCA.GrowthChart.label" bundle="${ca_labels}"/></font>&nbsp;&nbsp;</font></a></td>
		
		<td  width='10%' style='CAENCOUNTERLINE'  style="<%=triage_display_mode%>"><a class='gridLink' href='#' onClick="return TriageDetail('<%=P_patient_id%>','<%=encounter_id%>','<%=recorded_date_time%>')"><font size='2'><fmt:message key="eCA.TriageDetail.label" bundle="${ca_labels}"/></font></a></td><!--IN054712 Chnaged visit_date_time to recorded_date_time-->

		<!-- Bru-HIMS-0154 starts -->
		<%if (show_appt_btn_yn == true){%>
			<td  width='17%' style='CAENCOUNTERLINE' nowrap ><a class='gridLink' href='#' onClick="return showFutureAppointments('<%=P_patient_id%>')"><font size='2'><fmt:message key="eIP.FutureAppointments.label" bundle="${ip_labels}"/></font></a></td>
			<%}%>
		<!-- Bru-HIMS-0154 Ends -->
		<%
		//37866 Start.
		if(isVirtualConsSiteSpec && "OP".equals(patient_class) && "Y".equals(virtualApptYN)){%>
		<td  width = '10%' style='CAENCOUNTERLINE' >
			<img  src="../../eCA/images/virtualConsultation.png" title="Virtual Consultation" onClick="virtualConsultation('<%=p_facility_id%>','<%=P_patient_id%>','<%=episode_type%>','<%=encounter_id%>','<%=clinicianId%>');"/>
		</td>
		<%}
		//37866 End.
		if(p_count!=0){%> <!-- 70705 Start	 -->	
		<td  width='10%' style='CAENCOUNTERLINE' nowrap ><a class='gridLink' href='#' onClick="return menstHistDtl('<%=P_patient_id%>', '<%=p_facility_id%>')"><font size='2'><fmt:message key="eCA.MenstrualHistoryDetails.label" bundle="${ip_labels}"/></font></a></td>
		<%} %><!-- 70705 End -->
		<td  width = '10%' style='CAENCOUNTERLINE' >
		<a class='gridLink' href='javascript:refresh();'><font size='2'><U><fmt:message key="Common.Refresh.label" bundle="${common_labels}"/></U></font></a></td>
		<!-- IN045536 - Start -->
		<!--IN063885  start-->
		<% if(isMRReportappl){ %>
			<td  width = '10%' style='CAENCOUNTERLINE'style = '<%=mr_rpt_hyp_yn_style%>'>
				<a class='gridLink' href="javascript:displayMRReports('<%=P_patient_id%>','<%=encounter_id%>','<%=p_facility_id%>','<%=p_note_type%>')"><font size='2'><U>MR Reports</U></font></a>
			</td>
		<% } %>
		<!--IN063885 end-->
	<%	if(mds_chk_cnt>0){
			if(mr_mds_recorded_yn.equals("Y")) {
	%>
				<td  width='10%' style='CAENCOUNTERLINE' ><font size = "2"  color=red><fmt:message key="eCA.mdscriteriamet.label" bundle="${ca_labels}"/></font> </td> <!-- IN050593 -->
	<%		}
			else {
	%>			
				<td  width='10%' style='CAENCOUNTERLINE'  nowrap><a class='gridLink' href= # onClick="return MDSCompliance('<%=mr_mds_recorded_yn %>')" name='mindata'><font size = "2" color=red><U> <fmt:message key="eCA.mdscriterianotmet.label" bundle="${ca_labels}"/> </U></font></a></td> <!-- IN050593 -->
	<%
			}
		}
	 %>
		<!-- IN045536 - End -->	
      </tr>
     </table>
<% 
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
		//out.println(e.getMessage());//COMMON-ICN-0181
	      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
		if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

