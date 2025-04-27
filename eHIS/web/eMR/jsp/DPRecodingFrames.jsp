<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
 

<% 
getServletConfig().getServletContext().removeAttribute("blocked");
ArrayList encounterLIst=null;
ArrayList patientLIst=null;
Connection conn = ConnectionManager.getConnection(request);	 
PreparedStatement pstmt		= null;
ResultSet rs				= null;
 
try{ 
	
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String) session.getValue( "login_user" );
/* In Below line specialty_code added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/	
	String specialty_code     =""; 


	


	RecordSet	MedicalReportReq	=	null;
	String	from	=	"",	to		=	"";
	//String checkedOnes = "";
	from		=	(request.getParameter("from")==null)	?	"0"	:	request.getParameter("from");
	to			=	(request.getParameter("to")==null)		?	"0"	:	request.getParameter("to");
	//String fetchrecord=	(request.getParameter("fetchrecord")==null)		?	""	:	request.getParameter("fetchrecord");


	MedicalReportReq	=	(webbeans.eCommon.RecordSet)	session.getAttribute("MedicalReportReq");
	encounterLIst=new ArrayList();
	patientLIst=new ArrayList();
	String str = "";

	StringBuffer finalvals=new StringBuffer();

	for(int y=0;y<MedicalReportReq.getSize();y++){
		finalvals.append((String)MedicalReportReq.getObject(y)+"~");
	}
	
	StringTokenizer st_final = new StringTokenizer(finalvals.toString(),"~");
	while(st_final.hasMoreTokens()){
		str = st_final.nextToken();
		StringTokenizer st1 = new StringTokenizer(str,"`");
		String nxt_tkn="";
		while(st1.hasMoreTokens()){
			nxt_tkn=st1.nextToken();
			patientLIst.add( nxt_tkn);
			nxt_tkn=st1.nextToken();
			encounterLIst.add(nxt_tkn);
			


		}	
	}

	String enc_val = "";
	String enc_temp1 = "";
	String enc_temp = "";
	String pat_temp = "";
	String pat_temp1 = "";
	String finalSelect1 = "";
	String enc1 = "";
	String objName = "";
	String pat_line = "";
	String dflt_termset = "";
	String pid = "";
	String pat_class = "";
	int Stage_no = 0;
	String confirm_appl = ""; // added by mujafar for ML-MMOH-CRF-0878
	enc_val= request.getParameter("enc_val");
	enc_temp1= request.getParameter("enc_temp");
	pat_temp1= request.getParameter("pat_temp");
	finalSelect1= request.getParameter("finalSelect1");
	String allow_recode_diag_yn = "";
	String allow_recode_proc_yn = "";
	String allow_ot_proc_recode_yn = "";
	String allow_non_ot_proc_recode_yn = "";
	String drg_calculation_yn = "";//Added On 4/21/2010 For PE Tuning This value wil pass to all the Recodingpages

	if(enc_temp1.equals("") &&  pat_temp1.equals("") && MedicalReportReq.getSize()== 0){%>
		<script>alert(getMessage("NO_SELECTION","MR")); 
			window.close();
			
		</script>
	<%}

	//out.println("<script>alert(\"in new pat_temp :"+pat_temp+"\");</script>");
	
	String sql2="SELECT   ALLOW_RECODE_DIAG_YN ,ALLOW_RECODE_PROC_YN , ALLOW_OT_PROC_RECODE_YN, ALLOW_NON_OT_PROC_RECODE_YN,nvl(DRG_CALCULATION_YN,'N') DRG_CALCULATION_YN FROM MR_PARAMETER";
	pstmt = conn.prepareStatement(sql2);
	rs = pstmt.executeQuery();	
		
	while(rs.next()){
		allow_recode_diag_yn					= rs.getString("ALLOW_RECODE_DIAG_YN");
		allow_recode_proc_yn					= rs.getString("ALLOW_RECODE_PROC_YN");
		allow_ot_proc_recode_yn			= rs.getString("ALLOW_OT_PROC_RECODE_YN");
		allow_non_ot_proc_recode_yn	= rs.getString("ALLOW_NON_OT_PROC_RECODE_YN");
		drg_calculation_yn						= rs.getString("DRG_CALCULATION_YN");
	}
		
		
	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

	
	//String sql20="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID='"+loginUser+"' AND FACILITY_ID='"+facilityId+"'";
	String sql20="SELECT CONFIRM_APPL,stage_no from MR_RECODE_PRIVI_SETUP where stage_no in ((select STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID=? AND FACILITY_ID=?))" ;
		//  added by mujafar for ML-MMOH-CRF-0878
		pstmt = conn.prepareStatement(sql20);
		pstmt.setString(1,loginUser);
		pstmt.setString(2,facilityId);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		Stage_no = rs.getInt("STAGE_NO");
		confirm_appl=rs.getString("CONFIRM_APPL"); // added by mujafar for ML-MMOH-CRF-0878
	}
		
		
	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

	if(Stage_no == 0){
		
		String sql_st="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP WHERE SPECIFIC_IND='*ALL' ORDER BY  STAGE_NO DESC";
		pstmt = conn.prepareStatement(sql_st);

		rs = pstmt.executeQuery();	
			
		if(rs.next()){
			Stage_no = rs.getInt("STAGE_NO");

		}
			
			
		
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

	}


	
	String sql3="SELECT  TERM_SET_ID FROM mr_term_set WHERE RECODERS_APPL_YN='Y' AND ADDED_FACILITY_ID=?";
		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1,facilityId);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		dflt_termset = rs.getString("TERM_SET_ID");
	}
	

	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
		
	
	
				

	StringTokenizer st=new StringTokenizer(enc_val,"~");
	int temp=st.countTokens();

	for(int u2=0;u2<temp;u2++){

		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");

		enc1=st1.nextToken();

		objName=st1.nextToken();

		if(u2 == 0)
			pat_line=enc1;


	}


	String eval1="";
	String eval2="";
	int r= 0;




	StringTokenizer e1=new StringTokenizer(enc_temp1,",");
	int temp1=e1.countTokens();
	for(int v2=0;v2<temp1;v2++){

		String st2=e1.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		eval1=st1.nextToken();
		eval2=st1.nextToken();

		if(eval2.equals("E")){
			if(r == 0){
				enc_temp=eval1;
			}else{
				enc_temp=enc_temp+","+eval1;
			}
		
		}
		r++;
	
	}


	String etemp = "";
	int t=0;
	if(encounterLIst.size() != 0){
		//for (Iterator iter = encounterLIst.iterator();    iter.hasNext(); ) {
		int jj=encounterLIst.size()-1;
		for( int j=jj;j>=0;j--){

			if(!enc_temp.equals("")){
				//etemp=",";
				etemp="";
			}

			//String nxt_itr_enc=(String)iter.next();
			String nxt_itr_enc=(String)encounterLIst.get(j);
			if(j==0){
				pat_line=nxt_itr_enc;
			}
			etemp=etemp+"'"+nxt_itr_enc+"',";
			//enc_temp=enc_temp+etemp;
			enc_temp=etemp+enc_temp;
	
			if(t != 0){
				enc_temp=enc_temp+",";
			}
		}
		  if(enc_temp.endsWith(",")){
				enc_temp=enc_temp.substring(0,enc_temp.lastIndexOf(','));//Modified on 10/7/2009;
		  }
//		enc_temp=enc_temp.substring(0,enc_temp.lastIndexOf(','));//Modified on 10/7/2009;

	}
	
	/*String sql4="SELECT PATIENT_ID,PATIENT_CLASS FROM PR_ENCOUNTER WHERE ENCOUNTER_ID='"+pat_line+"' AND FACILITY_ID='"+facilityId+"'";
		pstmt = conn.prepareStatement(sql4);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		pid = rs.getString("PATIENT_ID");
		pat_class = rs.getString("PATIENT_CLASS");
	}
	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();*/

		
	
		


	String pat1="";
	String pat2="";
	int r1= 0;

	StringTokenizer p1=new StringTokenizer(pat_temp1,",");
	int temp2=p1.countTokens();
	for(int v2=0;v2<temp2;v2++) {
		String st2=p1.nextToken();

		StringTokenizer st1=new StringTokenizer(st2,"$");
		pat1=st1.nextToken();
		pat2=st1.nextToken();
		if(pat2.equals("E")){
			if(r1 == 0){
				pat_temp=pat1;
			}else{
				pat_temp=pat_temp+","+pat1;
			}
			
		}
		r1++;
	
	}
		String ptemp = "";
		int u=0;
		if(patientLIst.size() != 0)	{
			//for (Iterator iter = patientLIst.iterator();    iter.hasNext(); ) {
			int kk=patientLIst.size()-1;
			for( int k=kk;k>=0;k--){
				if(!pat_temp.equals("")){
					//ptemp=",";
					ptemp="";
				}
				//String nxt_itr_pat=(String)iter.next();
				String nxt_itr_pat=(String)patientLIst.get(k);
				//ptemp=ptemp+"'"+nxt_itr_pat+"'"; 
				ptemp=ptemp+"'"+nxt_itr_pat+"',"; 
				//pat_temp=pat_temp+ptemp;
				pat_temp=ptemp+pat_temp;
				if(u != 0){
					pat_temp=pat_temp+",";
				}
			}
//			pat_temp=pat_temp.substring(0,pat_temp.lastIndexOf(','));//Modified on 10/7/2009;
		}

		String ENC_PAT_SQL="SELECT PATIENT_ID,ENCOUNTER_ID FROM PR_ENCOUNTER WHERE ENCOUNTER_ID IN ("+enc_temp+") AND FACILITY_ID=? ORDER BY VISIT_ADM_DATE_TIME asc";
		pstmt = conn.prepareStatement(ENC_PAT_SQL);
		//pstmt.setString(1,enc_temp);
		pstmt.setString(1,facilityId);
		rs = pstmt.executeQuery();
		int cc=0;
		String rec_pat_temp="";
		String rec_enc_temp="";
		String enc_temp_ses="";
		String pat_temp_ses="";
		while(rs.next()){
			rec_pat_temp = rs.getString("PATIENT_ID");
			rec_enc_temp = rs.getString("ENCOUNTER_ID");
			if(cc==0){
				pat_line =rec_enc_temp;
			}
			pat_temp_ses=pat_temp_ses+"'"+rec_pat_temp+"'"+",";
			enc_temp_ses=enc_temp_ses+"'"+rec_enc_temp+"'"+",";
			cc++;
		}
		enc_temp_ses=enc_temp_ses.substring(0,enc_temp_ses.length()-1);
		pat_temp_ses=pat_temp_ses.substring(0,pat_temp_ses.length()-1);
		session.setAttribute("patientList",pat_temp_ses);
		session.setAttribute("encountertList",enc_temp_ses);

	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

/* In Below line specialty_code added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/	
	String sql4="SELECT PATIENT_ID,PATIENT_CLASS,SPECIALTY_CODE FROM PR_ENCOUNTER WHERE ENCOUNTER_ID=? AND FACILITY_ID=?";
	   
	    
		pstmt = conn.prepareStatement(sql4);
		pstmt.setString(1,pat_line);
		pstmt.setString(2,facilityId);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		pid = rs.getString("PATIENT_ID"); 
		pat_class = rs.getString("PATIENT_CLASS"); 
		specialty_code	= rs.getString("SPECIALTY_CODE");
	}

	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
/*The Query Was added on 4/26/2010 for PE*/
	String L1_hdr_status ="";
	String L2_hdr_status ="";
	String L3_hdr_status ="";
	String curr_level ="";
	String hdr_modified_dt ="";

	String sql_hdr_sts="SELECT CURR_LEVEL, nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID=? AND ENCOUNTER_ID=?";
	pstmt = conn.prepareStatement(sql_hdr_sts);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,pat_line);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		L1_hdr_status=rs.getString("LEVEL1_STATUS");
		L2_hdr_status=rs.getString("LEVEL2_STATUS");
		L3_hdr_status=rs.getString("LEVEL3_STATUS");
		curr_level		  =rs.getString("CURR_LEVEL");
		hdr_modified_dt=rs.getString("MODIFIED_DATE");
	}
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

String FrameSettings	="";
String DiagFrameScroll	 	="NO";
String ProcFrameScroll	 	="NO";
/*Based up on the Parameter SetUp frame Setting will Change*/
if(allow_recode_diag_yn.equals("Y")&& allow_recode_proc_yn.equals("Y")){
	FrameSettings	="48%,48%,4%,0%";
	DiagFrameScroll		="AUTO";
	ProcFrameScroll		="AUTO";
}else if(allow_recode_diag_yn.equals("Y")){
	FrameSettings	="95%,0%,5%,0";
	DiagFrameScroll		="AUTO";
}else if(allow_recode_proc_yn.equals("Y")){
	FrameSettings	="10%,85%,5%,0";
	ProcFrameScroll		="AUTO";
}
session.setAttribute("allow_recode_diag_yn",allow_recode_diag_yn);
session.setAttribute("allow_recode_proc_yn",allow_recode_proc_yn);
session.setAttribute("allow_ot_proc_recode_yn",allow_ot_proc_recode_yn);
session.setAttribute("allow_non_ot_proc_recode_yn",allow_non_ot_proc_recode_yn);
session.setAttribute("drg_calculation_yn",drg_calculation_yn);
/**Ends**/


%>

	<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	</head>
	<title><fmt:message key="eMR.DiagnosisProcedureCode.label" bundle="${mr_labels}"/></title>
	<body  class="relativePosition" >
	<form name ='DiagProcRecoding' method='post'>
 <!--In Below frames speciality added by venkatesh.s against HAS-CRF-300 -->
	<!--<frameset rows="7%,*,5%,0%">-->
		<iframe name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=pat_line%>' noresize  frameborder=0 scrolling='no' style='height:8vh;width:100vw'></iframe>

		<!--<frameset cols="22%,*">-->
			<iframe name="DiagProcRecodingPatDetail" id="DiagProcRecodingPatDetail" frameborder="no" scrolling="auto" noresize src='../../eMR/jsp/DPRecodingPatDetail.jsp?stage_no=<%=Stage_no%>&enc_val=<%=enc_val%>&finalSelect1=<%=finalSelect1%>&dflt_termset=<%=dflt_termset%>&Patient_Class=<%=pat_class%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&hdr_modified_dt=<%=hdr_modified_dt%>&specialty_code=<%=specialty_code%>' style='height:32vh;width:20vw'>
			</iframe>

<!-- 			<frameset rows="47%,47%,5%,0%" name="RecodeScreen"> -->				
				<!--<frameset rows=<%=FrameSettings%> name="RecodeScreen">	-->
<%
		
				if(Stage_no == 1){%>
					<iframe name="RecDiagnosisDiag" id="RecDiagnosisDiag" frameborder="no" scrolling=<%=DiagFrameScroll%> noresize src="../../eMR/jsp/DPRecodingDiag1.jsp?stage_no=<%=Stage_no%>&Pat_id=<%=pid%>&EncounterId=<%=pat_line%>&mode=Y&dflt_termset=<%=dflt_termset%>&Patient_Class=<%=pat_class%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&specialty_code=<%=specialty_code%>" style='height:37vh;width:77vw'>
					</iframe>

					<iframe name="RecDiagnosisProc"  id="RecDiagnosisProc" frameborder="no" scrolling=<%=ProcFrameScroll%> noresize src="../../eMR/jsp/DPRecodingProc1.jsp?stage_no=<%=Stage_no%>&Pat_id=<%=pid%>&EncounterId=<%=pat_line%>&mode=Y&dflt_termset=<%=dflt_termset%>&Patient_Class=<%=pat_class%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&specialty_code=<%=specialty_code%>" style='height:41vh;width:85vw ;margin-left: 232px'>
					</iframe>

				<%}else if(Stage_no == 2){%>
					<iframe name="RecDiagnosisDiag" id="RecDiagnosisDiag" frameborder="no" scrolling=<%=DiagFrameScroll%> noresize src="../../eMR/jsp/DPRecodingDiag1.jsp?stage_no=<%=Stage_no%>&Pat_id=<%=pid%>&EncounterId=<%=pat_line%>&mode=Y&dflt_termset=<%=dflt_termset%>&Patient_Class=<%=pat_class%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&specialty_code=<%=specialty_code%>" style='height:37vh;width:77vw'>
					</iframe>

					<iframe name="RecDiagnosisProc"  id="RecDiagnosisProc" frameborder="no" scrolling=<%=ProcFrameScroll%>  noresize src="../../eMR/jsp/DPRecodingProc1.jsp?stage_no=<%=Stage_no%>&Pat_id=<%=pid%>&EncounterId=<%=pat_line%>&mode=Y&dflt_termset=<%=dflt_termset%>&Patient_Class=<%=pat_class%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&specialty_code=<%=specialty_code%>" style='height:41vh;width:85vw;margin-left: 232px'>
					</iframe>


				<%}else if(Stage_no == 3){%>		
					<iframe name="RecDiagnosisDiag"  id="RecDiagnosisDiag" frameborder="no" scrolling=<%=DiagFrameScroll%> noresize src="../../eMR/jsp/DPRecodingDiag1.jsp?stage_no=<%=Stage_no%>&Pat_id=<%=pid%>&EncounterId=<%=pat_line%>&mode=Y&dflt_termset=<%=dflt_termset%>&Patient_Class=<%=pat_class%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&specialty_code=<%=specialty_code%>" style='height:37vh;width:77vw'></iframe>

					<iframe name="RecDiagnosisProc" id="RecDiagnosisProc" frameborder="no" scrolling=<%=ProcFrameScroll%> noresize src="../../eMR/jsp/DPRecodingProc1.jsp?stage_no=<%=Stage_no%>&Pat_id=<%=pid%>&EncounterId=<%=pat_line%>&mode=Y&dflt_termset=<%=dflt_termset%>&Patient_Class=<%=pat_class%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&specialty_code=<%=specialty_code%>" style='height:41vh;width:85vw;margin-left: 232px'>
					</iframe>


				<%}%>
				<iframe name="RecDiagnosisButton" id="RecDiagnosisButton" frameborder="no" scrolling="auto" noresize src="../../eMR/jsp/DPRecodingButton.jsp?confirm_appl=<%=confirm_appl%>&pat_class=<%=pat_class%>&stage_no=<%=Stage_no%>&Pat_id=<%=pid%>&EncounterId=<%=pat_line%>&curr_level=<%=curr_level%>&L1_hdr_status=<%=L1_hdr_status%>&L2_hdr_status=<%=L2_hdr_status%>&L3_hdr_status=<%=L3_hdr_status%>&hdr_modified_dt_qr=<%=hdr_modified_dt%>&execute_hdr_qry=N" style='height:4vh;width:99vw'></iframe>
				<iframe src='../../eCommon/html/blank.html' name='DiagProcTrans' id='DiagProcTrans' noresize frameborder="no" scrolling='auto'  style='display:none;height:20vh;width:79vw; margin-left: 232px;'></iframe>

			<!--</frameset>-->
		<!--</frameset>-->
			<iframe src='../../eCommon/jsp/error.jsp' name='messageFrame' id='messageFrame' noresize frameborder=0 scrolling='auto' style='height:6vh;width:100vw'></iframe>
			<iframe src='../../eCommon/jsp/error.jsp' name='submitFrame' id='submitFrame' noresize frameborder=0 scrolling='auto' style='height:0vh;width:100vw'></iframe>
	<!--</frameset>-->
	</form>
	</body>

	</html>
<%
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}finally{
	encounterLIst.clear(); 
	patientLIst.clear(); 
	if(conn != null) ConnectionManager.returnConnection(conn,request);

}


	%>
