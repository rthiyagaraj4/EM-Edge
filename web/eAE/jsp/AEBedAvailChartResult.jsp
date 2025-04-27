<!DOCTYPE html>

<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,java.net.*,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>

<head>
<%
  	String call_function		= checkForNull(request.getParameter("call_function"));
	String select_check			= checkForNull(request.getParameter("select_check"));

%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eAE/js/AEBedAvailChart.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection	con			= null;
	ResultSet	rs			= null;
	PreparedStatement pstmt = null; 
	PreparedStatement pstmt1 = null; 
	ResultSet	rs_oper		= null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale			= (String)session.getAttribute("LOCALE");

	String loginUser			= checkForNull((String)session.getValue("login_user"));
	String facility_id			= checkForNull((String) session.getAttribute("facility_id"));
	String clinic_code			= checkForNull(request.getParameter("clinic_code"));
	String treatment_area		= checkForNull(request.getParameter("treatment_area"));
	String bed_no				= checkForNull(request.getParameter("bed_no"));
	bed_no=bed_no.trim();

	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String gender				= checkForNull(request.getParameter("gender"));
	String bed_classification	= checkForNull(request.getParameter("bed_classification"));
	String bed_status			= checkForNull(request.getParameter("bed_status"));
	String priority_zone		= checkForNull(request.getParameter("priority_zone"));
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));

	String total				= "&nbsp;" ;
	String occupied				= "&nbsp;" ;
	String vacant				= "&nbsp;" ;
	String reserved				= "&nbsp;" ;
	String treatment_area_code_prev		= "" ;
	if (bed_status.equals(""))
		bed_status = "A";
	int		bed_col_num		= 1;
	int		l_cnt    		= 0;
%>

<body  id='b' onKeyDown = 'lockKey()'>
<%
	StringBuffer whereBuffer = new StringBuffer();
	StringBuffer queryBuffer = new StringBuffer();
	//StringBuffer sqlCnt = new StringBuffer();
	try {
		con= ConnectionManager.getConnection(request);
		if(oper_stn_id.equals("")) {
			StringBuffer operStnSql = new StringBuffer();
			operStnSql.append("select oper_stn_id from am_user_for_oper_stn ");
			operStnSql.append(" where appl_user_id= ?   and facility_id= ? ");
            ResultSet operStnRSet = null ;
			pstmt = con.prepareStatement(operStnSql.toString());
			pstmt.setString(1, loginUser);
			pstmt.setString(2, facility_id);
			operStnRSet = pstmt.executeQuery();
			if(operStnRSet.next())
				oper_stn_id=operStnRSet.getString(1);
			if(operStnRSet!=null)operStnRSet.close();
			if(pstmt!=null)pstmt.close();
		}
	
		//Below query commented by Ashwini on 06-Apr-2018 for PMG2018-COMN-CRF-0001

		/*queryBuffer.append("SELECT a.facility_id, sm_get_desc.sm_facility_param(a.facility_id,'"+locale+"','1') facility_name, b.clinic_code, OP_GET_DESC.OP_CLINIC(a.facility_id,B.CLINIC_CODE,'"+locale+"','1') clinic_desc, b.treatment_area_code,b.short_desc trmt_area_short_desc,  b.long_desc trmt_area_long_desc,a.bed_no, a.pseudo_bed_yn, TO_CHAR(sysdate,'dd/mm/rrrr hh24:mi')  sys,TO_CHAR (a.occupied_until_date_time,                  'dd/mm/rrrr hh24:mi' ) occupied_until_date_time, c.patient_id, c.patient_name, c.sex gender,TO_CHAR (c.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, a.current_status, a.eff_status, c.nationality_code, mp_get_desc.mp_country(C.NATIONALITY_CODE,'"+locale+"','1') nationality_long_desc, mp_get_desc.mp_country(C.NATIONALITY_CODE,'"+locale+"','2') nationality_short_desc, a.eff_status trmt_area_status, b.priority_zone, (SELECT clinic_code  || '~' || op_get_desc.op_clinic (facility_id,  clinic_code, 'en', '2' ) || '~' || SUM (DECODE (NVL (current_status, 'X'), 'A', 1,'X',1,0)) || '~' || SUM (DECODE (current_status, 'O', 1, 0)) || '~' || SUM (DECODE (current_status, 'R', 1, 0)) || '~' || SUM (DECODE (NVL (current_status, 'X'),'A',1,'O',1,'R',1,'X',1)) total_bed FROM ae_bed_for_trmt_area WHERE facility_id = a.facility_id AND clinic_code = a.clinic_code AND treatment_area_code = a.treatment_area_code AND eff_status = 'E' GROUP BY clinic_code, op_get_desc.op_clinic (facility_id, clinic_code, 'en', '2')) total_val,  (SELECT COUNT(*) count_value FROM  ae_bed_for_trmt_area  WHERE facility_id = a.facility_id  AND clinic_code  = a.clinic_code  AND treatment_area_code = a.treatment_area_code  AND pseudo_bed_yn = 'N'  AND current_status = 'A'  AND eff_status ='E') Count_value FROM ae_bed_for_trmt_area a,ae_tmt_area_for_clinic_lang_vw b,mp_patient c where a.facility_id = b.facility_id AND a.clinic_code = b.clinic_code AND a.treatment_area_code = b.treatment_area_code  AND b.language_id = '"+locale+"' AND a.occupying_patient_id = c.patient_id(+) AND a.bed_no IS NOT NULL AND a.facility_id = '"+facility_id+"' ");*/

		//Below query added by Ashwini on 06-Apr-2018 for PMG2018-COMN-CRF-0001

		queryBuffer.append("SELECT a.facility_id, sm_get_desc.sm_facility_param (a.facility_id, '"+locale+"', '1' ) facility_name, b.clinic_code, op_get_desc.op_clinic (a.facility_id, b.clinic_code, '"+locale+"', '1' ) clinic_desc, b.treatment_area_code, b.short_desc trmt_area_short_desc, b.long_desc trmt_area_long_desc, a.bed_no, a.pseudo_bed_yn, TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') SYS, TO_CHAR (a.occupied_until_date_time, 'dd/mm/rrrr hh24:mi' ) occupied_until_date_time, c.patient_id, c.patient_name, c.sex gender, TO_CHAR (c.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, a.current_status, a.eff_status, c.nationality_code, mp_get_desc.mp_country (c.nationality_code, '"+locale+"', '1' ) nationality_long_desc, mp_get_desc.mp_country (c.nationality_code, '"+locale+"', '2' ) nationality_short_desc, a.eff_status trmt_area_status, b.priority_zone, (SELECT e.clinic_code || '~' || op_get_desc.op_clinic (e.facility_id, e.clinic_code, 'en', '2' ) || '~' || SUM (DECODE ((CASE WHEN (NVL (e.current_status, 'X')) IN ('A', 'X') OR ( (e.current_status = 'R') AND (to_date(to_char(sysdate, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') > to_date(to_char(e.occupied_until_date_time, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') ) ) THEN 1 END ), '1', 1, 0 ) ) || '~' || SUM (DECODE (e.current_status, 'O', 1, 0)) || '~' || SUM (DECODE ((CASE WHEN e.current_status = 'R' AND (to_date(to_char(sysdate, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') <= to_date(to_char(e.occupied_until_date_time, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') ) THEN 1 END ), '1', 1, 0 ) ) || '~' || SUM (DECODE (NVL (e.current_status, 'X'), 'A', 1, 'O', 1, 'R', 1, 'X', 1 ) ) total_bed FROM ae_bed_for_trmt_area e, ae_spare_bays f WHERE e.facility_id = a.facility_id and e.facility_id = f.facility_id AND e.clinic_code = a.clinic_code AND e.treatment_area_code = a.treatment_area_code AND e.eff_status = 'E' AND e.clinic_code = f.clinic_code AND e.bed_no = f.bay_no AND f.eff_status = 'E' GROUP BY e.clinic_code, op_get_desc.op_clinic (e.facility_id, e.clinic_code, 'en', '2' )) total_val, (SELECT COUNT (*) count_value FROM ae_bed_for_trmt_area g, ae_spare_bays h WHERE g.facility_id = a.facility_id and g.facility_id = h.facility_id AND g.clinic_code = a.clinic_code AND g.treatment_area_code = a.treatment_area_code AND g.pseudo_bed_yn = 'N' AND g.current_status = 'A' AND g.eff_status = 'E' AND g.clinic_code = h.clinic_code AND g.bed_no = h.bay_no AND h.eff_status = 'E') count_value FROM ae_bed_for_trmt_area a, ae_tmt_area_for_clinic_lang_vw b, mp_patient c, ae_spare_bays d WHERE a.facility_id = b.facility_id  and  a.facility_id = d.facility_id AND a.clinic_code = b.clinic_code AND a.treatment_area_code = b.treatment_area_code AND b.language_id = '"+locale+"' AND a.clinic_code = d.clinic_code AND a.bed_no = d.bay_no AND d.eff_status = 'E' AND a.occupying_patient_id = c.patient_id(+) AND a.bed_no IS NOT NULL AND a.facility_id = '"+facility_id+"' ");
		// facility_id added in where clause for ML-BRU-SCF-1868(issue-3)

		if (!clinic_code.equals(""))
		{
			whereBuffer.append(" and a.clinic_code = '");
			whereBuffer.append(clinic_code);
			whereBuffer.append("' ");
		}
		
		if (!treatment_area.equals(""))
		{
			whereBuffer.append(" and a.treatment_area_code = '");
			whereBuffer.append(treatment_area);
			whereBuffer.append("' ");
		}
		if (!priority_zone.equals(""))
		{
			whereBuffer.append(" and b.priority_zone = '");
			whereBuffer.append(priority_zone);
			whereBuffer.append("' ");
		}
		
		if (!patient_id.equals(""))
		{
			whereBuffer.append(" and c.patient_id = '");
			whereBuffer.append(patient_id);
			whereBuffer.append("' ");
		}
		if (!gender.equals(""))
		{
			whereBuffer.append(" and c.sex = '");
			whereBuffer.append(gender);
			whereBuffer.append("' ");
		}
		
		if (!bed_classification.equals("B"))
		{
			if (bed_classification.equals("N"))
				whereBuffer.append(" and (A.PSEUDO_BED_YN = 'N' OR A.PSEUDO_BED_YN IS NULL) ");
			if (bed_classification.equals("P"))
				whereBuffer.append(" and A.PSEUDO_BED_YN = 'Y' ");
		}
		
		if (!bed_status.equals(""))
		{
			if (bed_status.equals("O"))
				whereBuffer.append(" AND A.CURRENT_STATUS = 'O' ");
			if (bed_status.equals("R"))
				whereBuffer.append(" AND (A.CURRENT_STATUS = 'R' and (to_date(to_char(sysdate, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') <= to_date(to_char(a.occupied_until_date_time, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))) ");
			if (bed_status.equals("V"))
				whereBuffer.append(" AND (A.CURRENT_STATUS = 'A' OR A.CURRENT_STATUS IS NULL or(a.current_status='R' and to_date(to_char(sysdate, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') > to_date(to_char(a.occupied_until_date_time, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')) ) ");
		}
		//whereBuffer.append(" and eff_status='E' and (facility_id,clinic_code) in (select facility_id,locn_code from am_locn_for_oper_stn_vw where facility_id ='"+facility_id+"' and oper_stn_id ='"+oper_stn_id+"' )");

		whereBuffer.append(" and a.eff_status='E' and EXISTS (SELECT 1 FROM am_locn_for_oper_stn WHERE facility_id = b.facility_id AND locn_code = b.clinic_code AND oper_stn_id = '"+oper_stn_id+"')");
		
		queryBuffer.append(whereBuffer.toString());

		//queryBuffer.append(" order by clinic_desc, clinic_code, trmt_area_short_desc, treatment_area_code,bed_no " );
		queryBuffer.append(" order by clinic_desc, a.clinic_code, trmt_area_short_desc,a.treatment_area_code, a.bed_no " );

			   pstmt = con.prepareStatement(queryBuffer.toString());
			  
		       rs				= pstmt.executeQuery();
				int count_buttn = 0 ;
                StringBuffer TableStr = new StringBuffer();
				StringBuffer tip = new StringBuffer();
				TableStr.append("<form name='query_form' id='query_form'>");
				TableStr.append("<table cellspacing=0 cellpadding=0 align='left' border='0' width='10%'>");
				TableStr.append("<tr>");
				
				if(rs!=null)
				{				
					
					String clinic_desc				=  ""; 
					String treatment_area_code		=  ""; 
					String trmt_area_short_desc		=  ""; 
					String pseudo_bed_yn			=  ""; 
					String occupied_until_date_time =  ""; 
					String sys_date_time =  ""; 
					String patient_name				=  ""; 
					String date_of_birth			=  ""; 
					String current_status			=  ""; 
					String nationality_code			=  ""; 
					String nationality_short_desc	=  ""; 
					String butt_color 				=  "";
					String placeholder 				=  "";
					String pseudo					=  "Y";
					String bed_type					=  "";
					String count_value					=  "";
					String total_val					=  "";
					StringBuffer sqlCnt = new StringBuffer();
      

					while(rs.next())
					{
						facility_id					= checkForNull(rs.getString("facility_id")) ;
						clinic_code					= checkForNull(rs.getString("clinic_code")) ;
						clinic_desc					= checkForNull(rs.getString("clinic_desc")) ;
						treatment_area_code			= checkForNull(rs.getString("treatment_area_code")) ;
						trmt_area_short_desc		= checkForNull(rs.getString("trmt_area_short_desc")) ;
						bed_no						= checkForNull(rs.getString("bed_no")) ;
						pseudo_bed_yn				= checkForNull(rs.getString("pseudo_bed_yn")) ;
						total_val				= checkForNull(rs.getString("total_val")) ;
						count_value				= checkForNull(rs.getString("count_value")) ;						

						StringTokenizer st				= new StringTokenizer(total_val,"~");
						if (st.hasMoreTokens())
						 {										
								if(st.hasMoreTokens()) 
								 st.nextToken();
								if(st.hasMoreTokens()) 
								 st.nextToken();	
								if(st.hasMoreTokens()) 
								 vacant			= checkForNull(st.nextToken());
								if(st.hasMoreTokens()) 
								 occupied	= checkForNull(st.nextToken());
								if(st.hasMoreTokens()) 
								 reserved			= checkForNull(st.nextToken());
								if(st.hasMoreTokens()) 
								 total			= checkForNull(st.nextToken());										
						 }

						if(pseudo_bed_yn.equals("Y"))
						 {
							bed_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SpareBedBay.label","ae_labels");
						 }
						else
						 {
							bed_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.NormalBedBay.label","ae_labels");
						  }
						
						occupied_until_date_time	= checkForNull(rs.getString("occupied_until_date_time")) ;
						sys_date_time	= checkForNull(rs.getString("sys")) ;
						patient_id					= checkForNull(rs.getString("patient_id")) ;
						patient_name				= checkForNull(rs.getString("patient_name")) ;
						gender						= checkForNull(rs.getString("gender")) ;
						date_of_birth				= checkForNull(rs.getString("date_of_birth")) ;
						current_status				= checkForNull(rs.getString("current_status")) ;
						nationality_code			= checkForNull(rs.getString("nationality_code")) ;
						nationality_short_desc		= checkForNull(rs.getString("nationality_short_desc")) ;
						butt_color 					= "IP_GreenButton";
						placeholder					= "";

						tip.setLength(0);
						placeholder = "";
						placeholder = specialCharacter(bed_no);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBayNo.label","ae_labels")+"^^"+placeholder+"<br>");

						placeholder = "";
						placeholder = specialCharacter(bed_type);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBayType.label","ae_labels")+" ^^"+placeholder+"<br>");
						
						placeholder = "";
						placeholder = specialCharacter(clinic_desc);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+" ^^"	+placeholder+"<br>"); 
						
						placeholder = "";
						placeholder = specialCharacter(trmt_area_short_desc);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.treatmentarea.label","common_labels") +"^^"+placeholder+"<br>");
						if ((current_status.equals("O"))) {			
						placeholder = "";
						placeholder = specialCharacter(patient_id);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+" ^^"+placeholder+"<br>");
						
					}
						if ((current_status.equals("O")) || ((current_status.equals("R"))))
						{
							if (current_status.equals("O"))
								butt_color	= "IP_RedButton";
							placeholder = "";
							
						}
						if ((current_status.equals("O")) && (pseudo_bed_yn.equals("Y")))
							butt_color = "IP_LPinkButton";
						
						if((current_status.equals("A")) && (pseudo_bed_yn.equals("Y"))) 
							butt_color = "IP_LGreenButton";
						if(current_status.equals("R") ) 
						{
						/* logic added for    22911 */

							if(!(DateUtils.isAfter(occupied_until_date_time, sys_date_time, "DMYHM", "en")))
								butt_color = "IP_GreenButton";

						/*  end    22911*/

								else 
								butt_color = "IP_BrownButton";
						}

						if (pseudo_bed_yn.equals("Y"))
						{
						
								if ((rs.getInt("count_value")) > 0)							
									 pseudo = "N";
			 					else pseudo = "Y";
						}
						if(current_status.equals("R")  && bed_status.equals("V") ) {
						
							
							if((pseudo_bed_yn.equals("N"))){
									butt_color = "IP_GreenButton"; 
							}

							if((pseudo_bed_yn.equals("Y"))){
							
								butt_color = "IP_LGreenButton";
							}
						}
					trmt_area_short_desc=	specialCharacter(trmt_area_short_desc);
						if(treatment_area_code.equals(treatment_area_code_prev)){
						}else{ 
							String header = "" ;
							header			 = clinic_desc +"/"+ trmt_area_short_desc;
							treatment_area_code_prev=treatment_area_code;

							TableStr.append("</tr><tr><table width='100%' border=0><th class='TEXTGROUPING' align='left' width='55%'> "+ header +"</th><th class='TEXTGROUPING' align='left' width='45%'>"+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+": "+total+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels")+": "+occupied+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels")+": "+vacant+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reserved.label","common_labels")+": "+reserved+" </th></table></tr><tr>");
							bed_col_num = 1;
						}
						patient_name =  specialCharacter(patient_name);
						clinic_desc =  specialCharacter(clinic_desc);
						String retVal = bed_no+"^"+clinic_code+"^"+clinic_desc+"^"+treatment_area_code+"^"+trmt_area_short_desc+"^"+occupied_until_date_time+"^"+patient_id+"^"+patient_name+"^"+gender+"^"+date_of_birth+"^"+nationality_code+"^"+nationality_short_desc+"^"+pseudo_bed_yn;
						retVal=java.net.URLEncoder.encode(retVal);
						TableStr.append("<script>var tips"+count_buttn+" = escape(\""+tip.toString()+"\");</script>");
						TableStr.append("<td width='2%'> <input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\" class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:82;' onclick='closeWin(\""+java.net.URLDecoder.decode(retVal)+"\",\""+butt_color+"\", \""+pseudo+"\")'> </td> ");

						if ( bed_col_num == 9)
						{
							bed_col_num = 0;
							TableStr.append("</tr><tr>");
						}

						bed_col_num++ ;
						count_buttn++ ;
						l_cnt++ ;
					}
					sqlCnt.setLength(0);
					if (pstmt != null) pstmt.close();
				}
				 if(l_cnt==0){
						%>
							<script> 
							resetValues(); 
							alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); 
							</script>
				     <%
				}
				 
                if (pstmt != null) pstmt.close();
                TableStr.append("<input type='hidden' name='call_fn' id='call_fn' value=\""+ call_function+"\" >");
				TableStr.append("</tr></table></form>");
				out.print(TableStr.toString());
				out.println("<script> resetValues(); </script>");
				TableStr.setLength(0);
		        tip.setLength(0);
		        
        if(rs != null) rs.close();
		if (rs_oper != null) rs_oper.close();
		if (pstmt != null) pstmt.close();
		if (pstmt1 != null) pstmt1.close();
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(con != null)
		ConnectionManager.returnConnection(con,request);
	} 
%>
<%!  
//Conversion
	public String specialCharacter(String single){
		int i=0;
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
		return single ;
	}	

%>
	                        </table> 

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
	<tr> <td width='100%' id='t'></td> </tr>
</table>
</div>
<script>
parent.processBar.document.location.href = "../../eCommon/html/blank.html";
if (('<%=select_check%>'!="N") && ('<%=select_check%>'!="X")) {
	//parent.criteria0.document.getElementById("clinic_code").disabled = true;
	//parent.criteria0.document.getElementById("treatment_area").disabled = true;
	//parent.criteria0.document.AEBedAvailChartForm.treatment_area.disabled = true;
}

</script>
</body>
</html>

<%!

	public static String checkForNull(String inputString) {
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

