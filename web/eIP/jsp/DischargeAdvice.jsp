<!DOCTYPE html>
<%
/*
* This is used only when called from CA - Discharge Advice,
* This page is used to define frames...
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<% 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String locale = (String)session.getAttribute("LOCALE");
	%>
<html>
<title><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/></title>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
			
			
</head>
<script>
var pat_id;
var enc_id;
var  fac_id;
//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671
var myarr = new Array();
index=0;
var cons;
async function message(myarr,flag,cont,ward_return,chk_pen_ward_rtn_bfr_dis_adv){
	var listno=1;

	var order_list="";
	var i;
	var pendingWardReturn = "";
	var dialogHeight= "1200px" ;
	var dialogTop = "1200px" ;
	var dialogWidth	= "10px" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

							
	var url="../../eOR/jsp/ViewPendingOrders.jsp?patient_id="+pat_id+"&encounter_id="+enc_id+"&facility_id="+fac_id+"&discharge_ind=A";

	if(chk_pen_ward_rtn_bfr_dis_adv=="Y" && ward_return=="W"){
		pendingWardReturn = "Y";	
	} 
	
	
	if(flag=='Y') {				
			
		if(pendingWardReturn==""){				
			document.getElementById('pda').rows='0%,0%,0%,0%,*';
			document.getElementById('messageFrame').src='../html/blank.html'
			var retVal = new String();
			retVal = await window.showModalDialog(url,arguments,features);		
			if(window.confirm(getMessage("PROCEED_DISCHARGE_ADVICE","IP"))){
				document.getElementById('pda').rows='0,50,128,8,0';
			}else{
				document.getElementById('f_query_add_mod_display').src='../html/blank.html'
				document.getElementById('f_query_add_mod').src='../html/blank.html'
				document.getElementById('f_query_add_mod_button').src='../html/blank.html'
				document.getElementById('messageFrame').src='../html/blank.html'
			}
		}else{
				document.getElementById('f_query_add_mod_display').src='../html/blank.html'
				document.getElementById('f_query_add_mod').src='../html/blank.html'
				document.getElementById('f_query_add_mod_button').src='../html/blank.html'
				document.getElementById('messageFrame').src='../html/blank.html'
		}
	}else{
			if(window.confirm(getMessage("ORDER_PENDING_CNT_PROCEED_VIEW","IP"))){
				var retVal = new String();
				retVal = await window.showModalDialog(url,arguments,features);
			}	
	}		
} 
		

	// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END
</script>

<%
	request.setCharacterEncoding("UTF-8"); 
    Connection con  = null;
	ResultSet rs 	= null; 
	PreparedStatement pstmt 	= null;
	Statement stmt			=	null;
	StringBuffer SqlSB = new StringBuffer();
	String facilityId = (String)session.getValue("facility_id");
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String EncounterId			= checkForNull(request.getParameter("encounter_id"));
	String ward_return="";
	
	//String query_string			= request.getParameter("query_string");
	//String option_id			= checkForNull(request.getParameter("option_id"));
	//String CA			= checkForNull(request.getParameter("CA"));
	String admissiondatetime	= "";
	String admissiontypedesc	= "";
	String specialtyshortdesc	= "";
	String practitionername		= "";
	String nursingunitshortdesc = "";
	String serviceshortdesc		= "";
	String bedno				= "";
	String roomno				= "";
	String bedclassshortdesc	= "";
	String bed_type_desc		= "";
	String practitioner_id		= "";
	int patient_age				= 0;
	String spltycode			= "";
	String patienttype 			= "";
	String nursingunitcode 		= "";
	String gender				= "";
	String DOB					= "";
	String expdischargedatetime = "";
	String patient_class		= "";
	String patient_status		= "";
	String pol_rep_no_vw		= "";
	String pol_stn_id_vw		= ""; 
	String pol_id_vw			= "";
	String mlc_yn				= "";
	String setup_bl_dtls_in_ip_yn		= "";
	String allow_discharge_date_predc	= "";
	String max_disch_period_for_predc	= "";
	String bl_interfaced_yn		= "";
	String mother_cut_off_age_pda		= "";
	String mother_max_age_pda			= "";
	String pat_dtls_unknown_yn_pda		= "";
	String contact1_name_pda			= "";
	String contact2_name_pda			= "";
	//String leave_expiry_date_time		= "";
	
	//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start
	String pre_disch_appl_yn			= "";
	String pre_dis_initiate_yn			= "";
	//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End
	String chk_pen_sale_rtn_bfr_dis_adv	  =""; 
	String pend_sal_ret_fin_stats		  ="Y";

	String dis_adv_ot_pend_ord_yn	= "N";
	String isAllowDischargeDisAdv	= "Y";
	
	/*Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String age								= "";
	String weight_on_admission				= "";
	String weight_on_admission_unit			= "";
	String weight_on_admission_unit_display	= "";
	String weight_on_admn_mandatory			= "";
	String chk_pen_ward_rtn_bfr_dis_adv			= "N";
	String is_value_already_captured		= "";
	int no_of_days							= 0;
	/*Added By Dharma on  Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String height_on_admn_mandatory         = "";
	String enable_height_bmi_pat_cls        = "";
	String bmi="";
	String is_value_already_captured_height="";
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527  END*/

	
	String ip_leave_status		= "";
	String leave_exp_dt_flag	= "";
	boolean result				= true;
	int cnt						= 0;
	
	//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671
	
	String chc_for_pen_orders_bfr_dis_adv="";
	String dis_adv_allow_yn="";
	String query="";
	int count =0;
	
  //List arr = new ArrayList<String>();
	// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END

	try
	{
		con = ConnectionManager.getConnection(request);		
		Boolean isRestrictDisAdvSaleRetPend = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","RESTRICT_DIS_ADV_SALE_RET_PEND");
		/*Monday, May 10, 2010 , modified for PE */
		//pstmt = con.prepareStatement("select 1 from ip_discharge_advice where facility_id= ? and encounter_id = ? and DIS_ADV_STATUS!='9'" );
		//pstmt = con.prepareStatement("SELECT setup_bl_dtls_in_ip_yn,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN, TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date,max_disch_period_for_dc, bl_interfaced_yn , b.nb_mother_cutoff_age mother_cut_off_age,b.nb_mother_upper_age mother_max_age,(SELECT 1 FROM ip_discharge_advice WHERE facility_id = ? AND encounter_id = ? AND dis_adv_status != '9') cnt , (select ip_leave_status from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null)) ip_leave_status FROM ip_param, mp_param b WHERE facility_id = ? AND b.module_id = 'MP'" );
		//Modified for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 (PRE_DIS_INITIATE_YN and pre_disch_appl_yn added to the query)
		//weight_on_admn_mandatory  Added By Dharma on  Nov 3rd 2014 against HSA-CRF-0181 [IN:049541
		
		String disSql	= "SELECT setup_bl_dtls_in_ip_yn,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN, TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date,max_disch_period_for_dc, bl_interfaced_yn , b.nb_mother_cutoff_age mother_cut_off_age,b.nb_mother_upper_age mother_max_age,(SELECT 1 FROM ip_discharge_advice WHERE facility_id = ? AND encounter_id = ? AND dis_adv_status != '9') cnt , (select ip_leave_status from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null)) ip_leave_status,(select pre_dis_initiate_yn from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? ) pre_dis_initiate_yn,pre_disch_appl_yn,weight_on_admn_mandatory,chk_pen_ward_rtn_bfr_dis_adv,chk_pen_sale_rtn_bfr_dis_adv,dis_adv_ot_pend_ord_yn,(select ot_allow_discharge_patient('"+facilityId+"','"+EncounterId+"','"+patient_id+"') from dual) isAllowDischargeDisAdv ";

		if(isRestrictDisAdvSaleRetPend){
			disSql	= disSql + " ,(select ST_SAL_FIN_STATUS('"+patient_id+"','"+EncounterId+"','"+facilityId+"') from dual) pend_sal_ret_fin_stats ";
		}
		disSql	= disSql + " FROM ip_param, mp_param b WHERE facility_id = ? AND b.module_id = 'MP'";
		//pstmt = con.prepareStatement("SELECT setup_bl_dtls_in_ip_yn,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN, TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date,max_disch_period_for_dc, bl_interfaced_yn , b.nb_mother_cutoff_age mother_cut_off_age,b.nb_mother_upper_age mother_max_age,(SELECT 1 FROM ip_discharge_advice WHERE facility_id = ? AND encounter_id = ? AND dis_adv_status != '9') cnt , (select ip_leave_status from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null)) ip_leave_status,(select pre_dis_initiate_yn from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? ) pre_dis_initiate_yn,pre_disch_appl_yn,weight_on_admn_mandatory,chk_pen_ward_rtn_bfr_dis_adv,chk_pen_sale_rtn_bfr_dis_adv,(select ST_SAL_FIN_STATUS('"+patient_id+"','"+EncounterId+"','"+facilityId+"') from dual) pend_sal_ret_fin_stats FROM ip_param, mp_param b WHERE facility_id = ? AND b.module_id = 'MP'" );
		pstmt = con.prepareStatement(disSql);
		pstmt.setString	( 1, facilityId ) ;
		pstmt.setString	( 2, EncounterId ) ;
		pstmt.setString	( 3, facilityId ) ;
		pstmt.setString	( 4, patient_id ) ;
		pstmt.setString	( 5, EncounterId ) ;
		/*Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start*/
		
		pstmt.setString	( 6, facilityId ) ;
		pstmt.setString	( 7, patient_id ) ;
		pstmt.setString	( 8, EncounterId ) ;
		pstmt.setString	( 9, facilityId ) ;
		
		/*Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End*/
	
		
		rs=pstmt.executeQuery();
  
		if(rs!=null && rs.next())
        {
			setup_bl_dtls_in_ip_yn		= checkForNull(rs.getString("setup_bl_dtls_in_ip_yn"));
			allow_discharge_date_predc	= checkForNull(rs.getString("allow_discharge_date"));
			max_disch_period_for_predc	= checkForNull(rs.getString("max_disch_period_for_dc"));
			bl_interfaced_yn			= checkForNull(rs.getString("bl_interfaced_yn"));
			mother_cut_off_age_pda		= checkForNull(rs.getString("mother_cut_off_age"));
			mother_max_age_pda			= checkForNull(rs.getString("mother_max_age"));
			cnt							= rs.getInt("cnt");
			ip_leave_status				= checkForNull(rs.getString("ip_leave_status"));
			//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671
			
			chc_for_pen_orders_bfr_dis_adv= checkForNull(rs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS_ADV"));
			dis_adv_allow_yn              =checkForNull(rs.getString("DIS_ADV_ALLOW_YN"));
			
		// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END
			
			/*result = false;
			out.println("<script>alert(getMessage('DIS_ADVICE_ALREAD_EXISIT','IP'));</script>");*/
			//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start
			pre_disch_appl_yn			= checkForNull(rs.getString("pre_disch_appl_yn")); 
			pre_dis_initiate_yn			= checkForNull(rs.getString("pre_dis_initiate_yn"));
			//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End
			weight_on_admn_mandatory	= checkForNull(rs.getString("weight_on_admn_mandatory"));//Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541] 
			chk_pen_ward_rtn_bfr_dis_adv	= checkForNull(rs.getString("chk_pen_ward_rtn_bfr_dis_adv"));
			chk_pen_sale_rtn_bfr_dis_adv	= checkForNull(rs.getString("chk_pen_sale_rtn_bfr_dis_adv"),"Y");
			if(isRestrictDisAdvSaleRetPend){
				pend_sal_ret_fin_stats	= checkForNull(rs.getString("pend_sal_ret_fin_stats"),"Y");
			}
		
			dis_adv_ot_pend_ord_yn	= checkForNull(rs.getString("dis_adv_ot_pend_ord_yn"),"N");
			isAllowDischargeDisAdv	= checkForNull(rs.getString("isAllowDischargeDisAdv"),"Y");
		}
		
		
		if(cnt > 0)
		{
			result = false;
			out.println("<script>alert(getMessage('DIS_ADVICE_ALREAD_EXISIT','IP'));</script>");
		}
		//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 Start
		else if(pre_disch_appl_yn.equals("Y") && pre_dis_initiate_yn.equals("N")){
			out.println("<script>alert(getMessage('PREDISCHARGE_NOT_INITIATED','IP'));</script>");
		}
		//Added for the CRF -KDAH-CRF-0104  by Dharma on Nov 19th 2013 End
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
		else if(chk_pen_sale_rtn_bfr_dis_adv.equals("Y") && pend_sal_ret_fin_stats.equals("N") && isRestrictDisAdvSaleRetPend){
			result = false;
			out.println("<script>alert(getMessage('SALE_RET_PENDING_CNT_PROCEED','IP'));</script>");
		} 
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/
		else if(dis_adv_ot_pend_ord_yn.equals("Y") && isAllowDischargeDisAdv.equals("N")){
			result = false;
			out.println("<script>alert(getMessage('OT_REC_PENDING_CNT_PROCEED','IP'));</script>");

		} 
			else {
			/*Monday, May 10, 2010 , modified for PE & query merged to line no 39
			if(result)
			{
				if (rs != null)		rs.close();
				if (pstmt != null)	pstmt.close();
				pstmt = con.prepareStatement(" select 1 from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time >  sysdate or leave_expiry_date_time is null) AND ip_leave_status = '1' ");
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, patient_id ) ;
				pstmt.setString	( 3, EncounterId ) ;
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
						result = false;
						out.println("<script>alert(getMessage('LEAVE_CANNOT_DISCHARGE_ADYC','IP'));</script>");
				}
				

			}
			if(result)
			{
				if (rs != null)		rs.close();
				if (pstmt != null)	pstmt.close();
				pstmt = con.prepareStatement(" select 1 from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time > sysdate or leave_expiry_date_time is null) AND ip_leave_status = '3' ");
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, patient_id ) ;
				pstmt.setString	( 3, EncounterId ) ;
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
						result = false;
						out.println("<script>alert(getMessage('NOSHOW_CANNOT_DISCHARGE_ADYC','IP'));</script>");
				}
				

			}
			if(result)
			{
				if (rs != null)		rs.close();
				if (pstmt != null)	pstmt.close();
				pstmt = con.prepareStatement(" select 1 from IP_OPEN_ENCOUNTER where facility_id=? and patient_id = ? and encounter_id = ? and (leave_expiry_date_time > sysdate or leave_expiry_date_time is null) AND ip_leave_status = '4' ");
				pstmt.setString	( 1, facilityId ) ;
				pstmt.setString	( 2, patient_id ) ;
				pstmt.setString	( 3, EncounterId ) ;
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
						result = false;
						out.println("<script>alert(getMessage('ABS_CANNOT_DISCHARGE_ADYC','IP'));</script>");
				}
				

			}*/
		
			if(result && ip_leave_status.equals("1") )
			{
				result = false;
				out.println("<script>alert(getMessage('LEAVE_CANNOT_DISCHARGE_ADYC','IP'));</script>");
			}
			if(result && ip_leave_status.equals("3") )
			{
				result = false;
				out.println("<script>alert(getMessage('NOSHOW_CANNOT_DISCHARGE_ADYC','IP'));</script>");
			}
			if(result && ip_leave_status.equals("4") )
			{
				result = false;
				out.println("<script>alert(getMessage('ABS_CANNOT_DISCHARGE_ADYC','IP'));</script>");
			}
			
			
			
			
			if(result && "y".equalsIgnoreCase(chk_pen_ward_rtn_bfr_dis_adv)){			
				

				
			
				pstmt = con.prepareStatement("SELECT distinct patient_id, store_acknowledge_status store_status FROM ph_ward_return_dtl a, ph_ward_return_hdr b WHERE a.facility_id = b.facility_id AND a.ret_doc_no = b.ret_doc_no AND patient_id = ? and encounter_id=? and b.facility_id=? and store_acknowledge_status is null");
				pstmt.setString	( 1, patient_id ) ;
				pstmt.setString	( 2, EncounterId ) ;
				pstmt.setString	( 3, facilityId ) ;
				rs=pstmt.executeQuery();

				if (rs!=null && rs.next()){
					 ward_return=rs.getString("store_status")==null?"W":rs.getString("store_status");  
				}

				

				%><script>					
					if('<%=ward_return%>'=="W"){
						alert(getMessage('WARD_RETURN','IP'));
					}</script>
				<%
			
			}
			
			//Below code added by venkatesh on 28/November/2011 against the IP-CA-KDAH-CRF-0041-ICN-IN029671
		
		
			
			
			if (result && chc_for_pen_orders_bfr_dis_adv.equals("Y") )
			{  
			
				/*stmt =con.createStatement();
				query ="SELECT COUNT (*)conut,b.long_desc FROM or_order a ,or_order_category b WHERE order_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE oper_or_group_ref = 'OPER_AMENDCANCEL' AND a.order_status_type = b.order_status_type) AND patient_id = '"+patient_id+"'AND encounter_id = '"+EncounterId+"' AND patient_class IN ('IP','DC') AND a.ORDER_CATEGORY=b.ORDER_CATEGORY AND b.order_category IN (SELECT order_category FROM or_order_category WHERE chk_pend_ord_category = 'Y') group by b.ORDER_CATEGORY,b.long_desc";
				
				rs =stmt.executeQuery(query);
				
				
				while (rs.next())
				{
				count=0;
			   arr.add(rs.getString("LONG_DESC"));
			   String temp=rs.getString("LONG_DESC");
			  
				/*count++;
				}
				} 
						
				count=arr.size();	
				*/

				String ord_stat="";
				stmt =con.createStatement();
				query ="select Or_patient_Order_Pend('"+patient_id+"','"+facilityId+"','"+EncounterId+"','A') ord_stat   from dual";
				rs =stmt.executeQuery(query);

				if (rs!=null && rs.next()){
					ord_stat=rs.getString("ord_stat");
				}

				if(ord_stat.equals("Y")){
					count=1;
				}else{
					count=0;
				}

				%>
				<script>
					pat_id='<%=patient_id%>';
					<%--enc_id='<%=facilityId%>';
					fac_id='<%=EncounterId%>';Commented by Menaka for the issue IN032890--%>
					enc_id='<%=EncounterId%>';
					fac_id='<%=facilityId%>';
				</script>
				<%

			}
			//out.println("count" + count);
	// venkatesh IP-CA-KDAH-CRF-0041-ICN-IN029671 END






		
		
		
		if(result)
			{	
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				SqlSB.append(" SELECT ");
				SqlSB.append("	To_char(a.Admission_Date_Time,'dd/mm/rrrr HH24:mi') Admission_Date_Time,");
				SqlSB.append("        c.Sex Gender,");
				SqlSB.append("        a.Encounter_Id,");
				SqlSB.append("        To_char(a.exp_Discharge_Date_Time,'dd/mm/rrrr HH24:mi') exp_Discharge_Date_Time,");
				SqlSB.append("        ip_Get_desc.Ip_admission_type(a.Admission_Type,'"+locale+"',2) Admission_Short_desc,");
				SqlSB.append("        a.Specialty_Code,");
				SqlSB.append("        Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"',2) Specialty_Short_desc,");
				SqlSB.append("        a.Encounter_Id,");
				SqlSB.append("        a.Attend_Practitioner_Id practitioner_id,");
				SqlSB.append("        Am_Get_desc.Am_practitioner(a.Attend_Practitioner_Id,'"+locale+"',1) Practitioner_Name,");
				SqlSB.append("        NULL Patient_Type_Short_desc,");
				SqlSB.append("        a.nurSing_Unit_Code,");
				SqlSB.append("        ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,'"+locale+"',2) nurSing_Unit_Short_desc,");
				SqlSB.append("        Am_Get_desc.Am_service(a.Service_Code,'"+locale+"',2) Service_Short_desc,");
				SqlSB.append("        a.Bed_num Bed_No,");
				SqlSB.append("        a.Room_num Room_No,");
				SqlSB.append("        a.Patient_Class,");
				SqlSB.append("        a.oth_Adt_Status,");
				SqlSB.append("        DECODE(Sign((a.Leave_exPiry_Date_Time - SYSDATE)),");
				SqlSB.append("               -1,'Y',");
				SqlSB.append("                                                          ");
				SqlSB.append("               'N') Leave_Flag,");
				SqlSB.append("        To_char(c.Date_Of_Birth,'dd/mm/rrrr') Date_Of_Birth,");
				SqlSB.append("        Calculate_age(To_char(c.Date_Of_Birth,'dd/mm/rrrr'),1) Patient_Age,");
				SqlSB.append("        ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"',2) Bed_Type_Short_desc,");
				SqlSB.append("        ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,'"+locale+"',2) Bed_Class_Short_desc,");
				SqlSB.append("        a.pol_rep_No,");
				SqlSB.append("        a.pol_stn_Id,");
				SqlSB.append("        a.pol_Id,");
				SqlSB.append("        a.mlc_yn");
				SqlSB.append("        , c.pat_dtls_unknown_yn, b.contact1_name, b.contact2_name ");
				SqlSB.append(" ,a.height_on_admission,a.bmi ");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
				SqlSB.append(" 		  , get_age(c.DATE_OF_BIRTH) age,a.weight_on_admission,a.weight_on_admission_unit,trunc (sysdate) - trunc (c.DATE_OF_BIRTH) no_of_days  ");//Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]
				SqlSB.append(" FROM   IP_OPEN_ENCOUNTER a,");
				SqlSB.append("        mp_pat_rel_contacts b,");
				SqlSB.append("        MP_PATIENT c");
				SqlSB.append(" WHERE  a.Facility_Id = '"+facilityId+"'");
				SqlSB.append("        AND a.Encounter_Id = '"+EncounterId+"'");
				SqlSB.append("        AND a.patient_id = b.patient_id");
				SqlSB.append("        AND a.patient_id = c.patient_id");
				SqlSB.append("        AND b.patient_id = c.patient_id");
				

	/*

				SqlSB.append(" SELECT TO_CHAR(admission_date_time,'dd/mm/rrrr HH24:mi') admission_date_time,");
				SqlSB.append(" a.gender gender, a.encounter_id, ");
				SqlSB.append(" TO_CHAR (exp_discharge_date_time,'dd/mm/rrrr HH24:mi') exp_discharge_date_time,");
				SqlSB.append(" a.admission_short_desc, a.specialty_code, ");
				SqlSB.append(" a.specialty_short_desc, a.encounter_id, a.admission_short_desc,");
				SqlSB.append(" a.practitioner_id, a.practitioner_name, a.patient_type_short_desc,");
				SqlSB.append(" a.nursing_unit_code, a.nursing_unit_short_desc, ");
				SqlSB.append(" a.service_short_desc, a.bed_no, a.room_no, a.patient_class, a.oth_adt_status, ");
				SqlSB.append(" decode(sign(( leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag,");
				SqlSB.append(" to_char(a.date_of_birth,'dd/mm/rrrr') date_of_birth,");
				SqlSB.append(" calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),1) patient_age,");
				SqlSB.append(" a.bed_type_short_desc, a.bed_class_short_desc, POL_REP_NO, POL_STN_ID, POL_ID, MLC_YN ");
				SqlSB.append(" FROM ");
				SqlSB.append(" ip_open_encounter_vw a, pr_encounter_other_detail b ");
				SqlSB.append(" WHERE ");
				SqlSB.append(" a.facility_id = '"+facilityId+"' ");
				SqlSB.append(" AND a.encounter_id ='"+EncounterId+"' ");
				SqlSB.append(" AND a.facility_id = b.operating_facility_id ");
				SqlSB.append(" AND a.encounter_id = b.encounter_id" );
	*/


				stmt=con.createStatement();
				rs=stmt.executeQuery(SqlSB.toString());
				if(rs.next())
				{
					admissiondatetime 	= checkForNull(rs.getString("admission_date_time"));
					admissiontypedesc 	= checkForNull(rs.getString("admission_short_desc"));
					specialtyshortdesc 	= checkForNull(rs.getString("specialty_short_desc"));
					practitionername 	= checkForNull(rs.getString("practitioner_name"));
					nursingunitshortdesc= checkForNull(rs.getString("Nursing_unit_short_desc"));
					serviceshortdesc 	= checkForNull(rs.getString("service_short_desc"));
					bedno 				= checkForNull(rs.getString("bed_no"));
					roomno 				= checkForNull(rs.getString("room_no"));
					bedclassshortdesc 	= checkForNull(rs.getString("bed_class_short_desc"));
					bed_type_desc		= checkForNull(rs.getString("bed_type_short_desc"));
						session.putValue("practitioner_name",practitionername);
					practitioner_id		= checkForNull(rs.getString("practitioner_id"));
					patient_age			= Integer.parseInt(rs.getString("patient_age"))	;
					spltycode			= checkForNull(rs.getString("specialty_code"));
					patienttype 		= checkForNull(rs.getString("patient_type_short_desc"));
					nursingunitcode 	= checkForNull(rs.getString("nursing_unit_code"));
					gender				= checkForNull(rs.getString("gender"));
					DOB					= checkForNull(rs.getString("date_of_birth"));
					expdischargedatetime= checkForNull(rs.getString("exp_discharge_date_time"));
					patient_class		= checkForNull(rs.getString("patient_class"));
					patient_status		= checkForNull(rs.getString("OTH_ADT_STATUS"));
				
					mlc_yn				= checkForNull(rs.getString("MLC_YN"),"N");
					pol_rep_no_vw		= checkForNull(rs.getString("POL_REP_NO"));
					pol_stn_id_vw		= checkForNull(rs.getString("POL_STN_ID"));
					pol_id_vw			= checkForNull(rs.getString("POL_ID"));

					pat_dtls_unknown_yn_pda			= checkForNull(rs.getString("pat_dtls_unknown_yn"));
					contact1_name_pda				= checkForNull(rs.getString("contact1_name"));
					contact2_name_pda				= checkForNull(rs.getString("contact2_name"));
					contact2_name_pda				= checkForNull(rs.getString("contact2_name"));
					/*Tuesday, December 28, 2010 , SRR20056-SCF-6317 [IN:025692]*/
					leave_exp_dt_flag	= rs.getString("leave_flag");
							if(leave_exp_dt_flag == null) leave_exp_dt_flag="";
							
					/*Added By Dharma on Nov 3d 2014 against HSA-CRF-0181 [IN:049541]  Start*/
					age  				= checkForNull(rs.getString("age"));
					weight_on_admission			= checkForNull(rs.getString("weight_on_admission"));
					weight_on_admission_unit	= checkForNull(rs.getString("weight_on_admission_unit"));
					no_of_days					= rs.getInt("no_of_days");
					/*Added By Dharma on Nov 3d 2014 against HSA-CRF-0181 [IN:049541]  End*/	
					/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
						height_on_admission			= checkForNull(rs.getString("height_on_admission"));
						bmi			= checkForNull(rs.getString("bmi"));
						/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/

				}
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				
				/*Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  Start*/
				String is_validate_weight_on_admission	= (weight_on_admn_mandatory.equals("P")?"Y":"N");
				if(weight_on_admission.equals("") && weight_on_admission_unit.equals("")){
					/*String lastchar	="";
					int calculate_age	= 0;
					if (age.length() > 0 ){
						lastchar		= age.substring(age.length() - 1);
						if (!age.contains("Y"))
							calculate_age	= Integer.parseInt(age.substring(0, age.length()-1));
					}
					weight_on_admission_unit	= (lastchar.equals("D")?(calculate_age >30 ? "K":"G"):"K");*/
					weight_on_admission_unit	= (no_of_days >30 ? "K":"G");
				}else{
					is_value_already_captured	= "Y";
				}
				weight_on_admission_unit_display	= (weight_on_admission_unit.equals("G")?"Gram":"Kg");
				/*Added By Dharma on Nov 3rd 2014 against HSA-CRF-0181 [IN:049541]  End*/
				
				/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  Start*/
		if(height_on_admn_mandatory.equals("")||enable_height_bmi_pat_cls.equals("")){//If discharge advise called from CA.
			stmt=con.createStatement();
			rs=stmt.executeQuery("select HEIGHT_ON_ADMN_MANDATORY,ENABLE_HEIGHT_BMI_PAT_CLS from ip_param where facility_id = '"+facilityId+"'");
			if(rs.next()){
				 height_on_admn_mandatory	= checkForNull(rs.getString("height_on_admn_mandatory"));
				 enable_height_bmi_pat_cls	= checkForNull(rs.getString("enable_height_bmi_pat_cls"));
			}
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		String is_validate_height_on_admission = (height_on_admn_mandatory.equals("P")?"Y":"N");
		if(height_on_admission.equals("") || height_on_admission_unit.equals("")){
			height_on_admission_unit	= ("Cm");
		}
		else{
			is_value_already_captured_height = "Y";
		}
		/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  End*/


			%>
			<% 
			if(chc_for_pen_orders_bfr_dis_adv.equals("Y") && count >0 ){ if(dis_adv_allow_yn.equals("Y")){ 
		
			
			%>
		
	

			<title><fmt:message key="eIP.PrepareDischargeAdvice.label" bundle="${ip_labels}"/></title>
			<iframe name='pline' id='pline' SRC='' noresize  frameborder=no scrolling='no'>
				<!--Maheshwaran K added patient_class for the  JD-CRF-0145 [IN:030011] --><!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-- style='height:0%;width:100vw'></iframe><iframe id='frame' name='f_query_add_mod_display' id='f_query_add_mod_display' 	 src='addmodifyDischargeAdvice.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&&EncounterId=<%=java.net.URLEncoder.encode(EncounterId)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&patient_Id=<%=java.net.URLEncoder.encode(patient_id)%>&admissiondatetime=<%=java.net.URLEncoder.encode(admissiondatetime)%>&admissiontypedesc=<%=java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")%>&specialtyshortdesc=<%=java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")%>&practitionername=<%=java.net.URLEncoder.encode(practitionername,"UTF-8")%>&nursingunitshortdesc=<%=java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")%>&serviceshortdesc=<%=java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")%>&bedno=<%=java.net.URLEncoder.encode(bedno,"UTF-8")%>&roomno=<%=java.net.URLEncoder.encode(roomno,"UTF-8")%>&bedclassshortdesc=<%=java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&weight_on_admission=<%=weight_on_admission%>&weight_on_admission_unit=<%=weight_on_admission_unit%>&weight_on_admission_unit_display=<%=weight_on_admission_unit_display%>&is_validate_weight_on_admission=<%=is_validate_weight_on_admission%>&is_value_already_captured=<%=is_value_already_captured%>&height_on_admission=<%=height_on_admission%>&height_on_admission_unit=<%=height_on_admission_unit%>&is_validate_height_on_admission=<%=is_validate_height_on_admission%>&bmi=<%=bmi%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>&is_value_already_captured_height=<%=is_value_already_captured_height%>' frameborder=0 scrolling='no' noresize style='height:70%;width:100vw'></iframe> 
				
				<iframe id='frame2' name='f_query_add_mod' id='f_query_add_mod' 	 src='AddModifyDischargeAdvTabs.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&EncounterId=<%=java.net.URLEncoder.encode(EncounterId)%>&patient_Id=<%=java.net.URLEncoder.encode(patient_id)%>&admissiondatetime=<%=java.net.URLEncoder.encode(admissiondatetime)%>&admissiontypedesc=<%=java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")%>&specialtyshortdesc=<%=java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")%>&practitionername=<%=java.net.URLEncoder.encode(practitionername,"UTF-8")%>&nursingunitshortdesc=<%=java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")%>&serviceshortdesc=<%=java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")%>&bedno=<%=java.net.URLEncoder.encode(bedno,"UTF-8")%>&roomno=<%=java.net.URLEncoder.encode(roomno,"UTF-8")%>&bedclassshortdesc=<%=java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&practitioner_id=<%=java.net.URLEncoder.encode(practitioner_id)%>&spltycode=<%=java.net.URLEncoder.encode(spltycode)%>&patienttype=<%=java.net.URLEncoder.encode(patienttype)%>&nursingunitcode=<%=java.net.URLEncoder.encode(nursingunitcode)%>&gender=<%=java.net.URLEncoder.encode(gender)%>&DOB=<%=java.net.URLEncoder.encode(DOB)%>&expdischargedatetime=<%=java.net.URLEncoder.encode(expdischargedatetime)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&leave_exp_dt_flag=<%=java.net.URLEncoder.encode(leave_exp_dt_flag)%>&patient_status=<%=java.net.URLEncoder.encode(patient_status)%>&patient_age=<%=patient_age%>&&mlc_yn=<%=java.net.URLEncoder.encode(mlc_yn)%>&pol_rep_no_vw=<%=java.net.URLEncoder.encode(pol_rep_no_vw,"UTF-8")%>&pol_stn_id_vw=<%=java.net.URLEncoder.encode(pol_stn_id_vw,"UTF-8")%>&pol_id_vw=<%=java.net.URLEncoder.encode(pol_id_vw,"UTF-8")%>&setup_bl_dtls_in_ip_yn=<%=java.net.URLEncoder.encode(setup_bl_dtls_in_ip_yn)%>&allow_discharge_date_predc=<%=java.net.URLEncoder.encode(allow_discharge_date_predc)%>&max_disch_period_for_predc=<%=java.net.URLEncoder.encode(max_disch_period_for_predc)%>&bl_interfaced_yn=<%=java.net.URLEncoder.encode(bl_interfaced_yn)%>&mother_cut_off_age_pda=<%=java.net.URLEncoder.encode(mother_cut_off_age_pda)%>&mother_max_age_pda=<%=java.net.URLEncoder.encode(mother_max_age_pda)%>&pat_dtls_unknown_yn_pda=<%=java.net.URLEncoder.encode(pat_dtls_unknown_yn_pda)%>&contact1_name_pda=<%=java.net.URLEncoder.encode(contact1_name_pda,"UTF-8")%>&contact2_name_pda=<%=java.net.URLEncoder.encode(contact2_name_pda,"UTF-8")%>&bmi=<%=bmi%>' frameborder=0 scrolling='no' noresize style='height:118%;width:100vw'></iframe> 

				<iframe id='frame3' name='f_query_add_mod_button' id='f_query_add_mod_button' 	 src='AddModifyDischargeAdvButtons.jsp?jsp_name=&win_height=1&win_width=40&patient_Id=<%=patient_id%>&is_ca_yn=Y&nursingunitcode=<%=java.net.URLEncoder.encode(nursingunitcode)%>' frameborder=0 scrolling='no' noresize style='height:8%;width:100vw'></iframe>

				<iframe id='frame4' name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
			
			
				<% out.println("<script>message(myarr,'"+dis_adv_allow_yn+"','"+count+"','"+ward_return+"','"+chk_pen_ward_rtn_bfr_dis_adv+"');</script>");
				
			}if(dis_adv_allow_yn.equals("N")) { 
			out.println("<script> message(myarr,'"+dis_adv_allow_yn+"','"+count+"','"+ward_return+"','"+chk_pen_ward_rtn_bfr_dis_adv+"');</script>");
			} }
			%>
			<% if (count==0 && !"w".equalsIgnoreCase(ward_return))
			{ 
			
			%>
			<title><fmt:message key="eIP.PrepareDischargeAdvice.label" bundle="${ip_labels}"/></title>
			<iframe name='pline' id='pline' SRC='' noresize  frameborder=no scrolling='no'>
				<!--Maheshwaran K added patient_class for the  JD-CRF-0145 [IN:030011] -- style='height:0%;width:100vw'></iframe><iframe name='f_query_add_mod_display' id='f_query_add_mod_display' 	 src='addmodifyDischargeAdvice.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&&EncounterId=<%=java.net.URLEncoder.encode(EncounterId)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&patient_Id=<%=java.net.URLEncoder.encode(patient_id)%>&admissiondatetime=<%=java.net.URLEncoder.encode(admissiondatetime)%>&admissiontypedesc=<%=java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")%>&specialtyshortdesc=<%=java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")%>&practitionername=<%=java.net.URLEncoder.encode(practitionername,"UTF-8")%>&nursingunitshortdesc=<%=java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")%>&serviceshortdesc=<%=java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")%>&bedno=<%=java.net.URLEncoder.encode(bedno,"UTF-8")%>&roomno=<%=java.net.URLEncoder.encode(roomno,"UTF-8")%>&bedclassshortdesc=<%=java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&weight_on_admission=<%=weight_on_admission%>&weight_on_admission_unit=<%=weight_on_admission_unit%>&weight_on_admission_unit_display=<%=weight_on_admission_unit_display%>&is_validate_weight_on_admission=<%=is_validate_weight_on_admission%>&is_value_already_captured=<%=is_value_already_captured%>&is_validate_height_on_admission=<%=is_validate_height_on_admission%>&bmi=<%=bmi%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>&is_value_already_captured_height=<%=is_value_already_captured_height%>&height_on_admission=<%=height_on_admission%>&height_on_admission_unit=<%=height_on_admission_unit%>' frameborder=0 scrolling='no' noresize style='height:70%;width:100vw'></iframe> 
				
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='AddModifyDischargeAdvTabs.jsp?jsp_name=&win_height=1&win_width=40&is_ca_yn=Y&EncounterId=<%=java.net.URLEncoder.encode(EncounterId)%>&patient_Id=<%=java.net.URLEncoder.encode(patient_id)%>&admissiondatetime=<%=java.net.URLEncoder.encode(admissiondatetime)%>&admissiontypedesc=<%=java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")%>&specialtyshortdesc=<%=java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")%>&practitionername=<%=java.net.URLEncoder.encode(practitionername,"UTF-8")%>&nursingunitshortdesc=<%=java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")%>&serviceshortdesc=<%=java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")%>&bedno=<%=java.net.URLEncoder.encode(bedno,"UTF-8")%>&roomno=<%=java.net.URLEncoder.encode(roomno,"UTF-8")%>&bedclassshortdesc=<%=java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")%>&bed_type_desc=<%=java.net.URLEncoder.encode(bed_type_desc,"UTF-8")%>&practitioner_id=<%=java.net.URLEncoder.encode(practitioner_id)%>&spltycode=<%=java.net.URLEncoder.encode(spltycode)%>&patienttype=<%=java.net.URLEncoder.encode(patienttype)%>&nursingunitcode=<%=java.net.URLEncoder.encode(nursingunitcode)%>&gender=<%=java.net.URLEncoder.encode(gender)%>&DOB=<%=java.net.URLEncoder.encode(DOB)%>&expdischargedatetime=<%=java.net.URLEncoder.encode(expdischargedatetime)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&leave_exp_dt_flag=<%=java.net.URLEncoder.encode(leave_exp_dt_flag)%>&patient_status=<%=java.net.URLEncoder.encode(patient_status)%>&patient_age=<%=patient_age%>&&mlc_yn=<%=java.net.URLEncoder.encode(mlc_yn)%>&pol_rep_no_vw=<%=java.net.URLEncoder.encode(pol_rep_no_vw,"UTF-8")%>&pol_stn_id_vw=<%=java.net.URLEncoder.encode(pol_stn_id_vw,"UTF-8")%>&pol_id_vw=<%=java.net.URLEncoder.encode(pol_id_vw,"UTF-8")%>&setup_bl_dtls_in_ip_yn=<%=java.net.URLEncoder.encode(setup_bl_dtls_in_ip_yn)%>&allow_discharge_date_predc=<%=java.net.URLEncoder.encode(allow_discharge_date_predc)%>&max_disch_period_for_predc=<%=java.net.URLEncoder.encode(max_disch_period_for_predc)%>&bl_interfaced_yn=<%=java.net.URLEncoder.encode(bl_interfaced_yn)%>&mother_cut_off_age_pda=<%=java.net.URLEncoder.encode(mother_cut_off_age_pda)%>&mother_max_age_pda=<%=java.net.URLEncoder.encode(mother_max_age_pda)%>&pat_dtls_unknown_yn_pda=<%=java.net.URLEncoder.encode(pat_dtls_unknown_yn_pda)%>&contact1_name_pda=<%=java.net.URLEncoder.encode(contact1_name_pda,"UTF-8")%>&contact2_name_pda=<%=java.net.URLEncoder.encode(contact2_name_pda,"UTF-8")%>&bmi=<%=bmi%>' frameborder=0 scrolling='no' noresize style='height:118%;width:100vw'></iframe> 

				<iframe name='f_query_add_mod_button' id='f_query_add_mod_button' 	 src='AddModifyDischargeAdvButtons.jsp?jsp_name=&win_height=1&win_width=40&patient_Id=<%=patient_id%>&is_ca_yn=Y&nursingunitcode=<%=java.net.URLEncoder.encode(nursingunitcode)%>' frameborder=0 scrolling='no' noresize style='height:8%;width:100vw'></iframe>

				<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
			
			<%}%>
	
	
	<%	}
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());
	e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
	
	
		


 
 
	
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

