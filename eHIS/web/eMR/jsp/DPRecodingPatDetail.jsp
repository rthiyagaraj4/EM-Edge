<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*"%>
<%	//String locale = (String)session.getAttribute("LOCALE");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	

	
	 


	Connection conn = ConnectionManager.getConnection(request);	
	PreparedStatement pstmt		= null;
	//PreparedStatement pstmt1		= null;
	PreparedStatement pstmt2		= null;
	ResultSet rs				= null;
	//ResultSet rs1				= null;
	ResultSet rs2				= null;
	StringBuffer sqlbuff = new StringBuffer();
	String Pat_name ="";
	String Pat_sex ="";
	String Pat_age ="";
	String Pat_class ="";
	String Pat_dob ="";
	String Pat_enc ="";
	String Pat_spec ="";
	String Pat_fname ="";
	String Pat_familyname ="";
	String classValue	 = "";
	String dPatient_id = "";
    String Pat_disch = "";
	String Pat_visit = "";
	String Pat_los = "";


    int i=1;
    int m=0;
    int n=0;



	try
	{
	String stage_no1=request.getParameter("stage_no");
	int stage_no = Integer.parseInt(stage_no1);
	String enc_val=request.getParameter("enc_val");
/*
	String enc_temp=request.getParameter("enc_temp");
	String pat_temp=request.getParameter("pat_temp");
*/
	String finalSelect1=request.getParameter("finalSelect1");
	String dflt_termset=request.getParameter("dflt_termset");
	String Patient_Class=request.getParameter("Patient_Class");
	String Pat_id=request.getParameter("Pat_id");
	Pat_sex=request.getParameter("Pat_sex");
	Pat_age=request.getParameter("Pat_age");
	/*
		F.Y.I
		1.Added On 4/26/2010 for PE Tuning;
		2.The below vairable values will be getting from the Frames page and Servlet while loading.
	*/
	String L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
	String L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
	String L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
	String curr_level				= checkForNull(request.getParameter("curr_level"));
	String hdr_modified_dt		= checkForNull(request.getParameter("hdr_modified_dt"));


	String pat_temp="";
	String enc_temp="";
	pat_temp=request.getParameter("pat_temp");
	enc_temp=request.getParameter("enc_temp");




	if(pat_temp ==null || pat_temp.equals("null") || pat_temp.equals("") ){
		pat_temp	=	(String)	session.getAttribute("patientList");
	}

	if(enc_temp ==null || enc_temp.equals("null")  ||enc_temp.equals("")){
		enc_temp	=	(String)	session.getAttribute("encountertList");
	}
	
String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");



	//pstmt = conn.prepareStatement("select ENCOUNTER_ID from pr_encounter where FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID IN ("+enc_temp+") order by VISIT_ADM_DATE_TIME");
	//rs = pstmt.executeQuery();
	//enc_val="";

	//while (rs.next()){
		//enc_val=enc_val+"$"+rs.getString("ENCOUNTER_ID");
	//}






%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js'  language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eMR/js/DPRecoding.js' language='javascript'></script>

<html>
<body onKeyDown='lockKey()'>
	<form name="RecodeDiagnosisPatDetail" id="RecodeDiagnosisPatDetail">
	<table border=0 cellpadding='3' cellspacing='0' width="100%">
		<tr>
			<th align='center' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
			<th align='center'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></th>
			<th align='center'><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
		</tr>

		

<%
		 


	String objName = "";
	String enc1 = "";
	String enc_line = "";
	int temp = 0;
	//int temp1= 0;

		StringTokenizer st=new StringTokenizer(enc_val,"~");
		temp=st.countTokens();


		for(int u2=0;u2<temp;u2++)
		{
		
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			enc1=st1.nextToken();
			objName=st1.nextToken();
		}
		
		//String sql_pat="SELECT DISTINCT patient_id FROM mp_patient WHERE patient_id IN ("+pat_temp+")";

		String duplicates=pat_temp;
		StringTokenizer tokenString=new StringTokenizer(duplicates,",");
		int len = tokenString.countTokens();

		String[] duplicates1=new String[len];

		int z=0;
		StringTokenizer tokenString1=new StringTokenizer(duplicates,",");
		while(tokenString1.hasMoreTokens()){
			duplicates1[z++]=tokenString1.nextToken();
		}

		//Arrays.sort(duplicates1);  // commented on 7th oct
		int kkk = 0;

		for (int iii = 0; iii < duplicates1.length; iii++){
			if (iii > 0 && duplicates1[iii].equals(duplicates1[iii -1])){
				continue;
			}

			duplicates1[kkk++] = duplicates1[iii];
		}

		String[] unique = new String[kkk];

		System.arraycopy(duplicates1, 0, unique, 0, kkk);

		//ArrayList pat_list=new ArrayList();

		for (int jjj = 0; jjj < unique.length; jjj++){

			dPatient_id = unique[jjj];
			//String patsql="SELECT a.PATIENT_ID PATIENT_ID,a.PATIENT_NAME PATIENT_NAME, a.first_name, a.family_name, a.SEX SEX,to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy')DATE_OF_BIRTH , GET_AGE(a.DATE_OF_BIRTH) AGE  FROM MP_PATIENT a  WHERE  a.PATIENT_ID="+dPatient_id;
		String patsql="SELECT a.PATIENT_ID PATIENT_ID,a.PATIENT_NAME PATIENT_NAME, a.first_name, a.family_name, a.SEX SEX,to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy')DATE_OF_BIRTH , GET_AGE(a.DATE_OF_BIRTH,NVL(a.DECEASED_DATE,SYSDATE)) AGE  FROM MP_PATIENT a  WHERE  a.PATIENT_ID="+dPatient_id;
			
			pstmt = conn.prepareStatement(patsql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				Pat_id = rs.getString("PATIENT_ID");
				Pat_name = rs.getString("PATIENT_NAME");
				Pat_sex = checkForNull(rs.getString("SEX"));
				Pat_age= checkForNull(rs.getString("AGE"));
				//Pat_class= rs.getString("PATIENT_CLASS");
				Pat_dob= rs.getString("DATE_OF_BIRTH");
				//Pat_enc= rs.getString("ENCOUNTER_ID");
				//Pat_spec= rs.getString("SPECIALTY_CODE");
				Pat_fname= rs.getString("first_name");
				Pat_familyname= rs.getString("family_name");
				//Pat_disch= rs.getString("discharge_date_time");
				//Pat_visit= rs.getString("visit_adm_date_time");
				//Pat_los= rs.getString("v_los");

			}

			if(rs != null)rs.close();
			if(pstmt  != null)pstmt.close();

					if ( i % 2 == 0 )
					classValue = "gridData" ;
				else
					classValue = "gridData" ;

		
%>

		
			<tr class='<%=classValue%>'><td  class='<%=classValue%>' id='encSymbol<%=m%>'><a href="javascript:onclick=showEncounter_new('<%=m%>')">+</a>&nbsp;&nbsp;<%=Pat_name%></td>
			<td class='<%=classValue%>'><%=Pat_sex%></td>
			<td class='<%=classValue%>'><%=Pat_age%></td></tr>
			<input type='hidden' name='pid<%=m%>' id='pid<%=m%>' value='<%=Pat_id%>'>
			<input type='hidden' name="Pat_name<%=m%>" id="Pat_name<%=m%>" value="<%=Pat_name%>">
			<input type='hidden' name='gender<%=m%>' id='gender<%=m%>' value='<%=Pat_sex%>'>
			<input type='hidden' name='age<%=m%>' id='age<%=m%>' value='<%=Pat_age%>'>
			<input type='hidden' name='dob<%=m%>' id='dob<%=m%>' value='<%=Pat_dob%>'>
			<input type='hidden' name='spec_code<%=m%>' id='spec_code<%=m%>' value='<%=Pat_spec%>'>
			<tr>
			<td colspan=3>	
			<table id='dispenc<%=m%>' cellpadding=0 cellspacing=0 style='visibility:hidden;display:none'>

			<%
			
			if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
			sqlbuff.append("SELECT B.PATIENT_ID PATIENT_ID,B.PATIENT_NAME PATIENT_NAME,A.ENCOUNTER_ID ENCOUNTER_ID,B.SEX SEX,GET_AGE(B.DATE_OF_BIRTH) AGE FROM MP_PATIENT B,PR_ENCOUNTER A WHERE A.FACILITY_ID='"+FacilityId+"' AND A.ENCOUNTER_ID IN ("+enc_temp+") AND A.PATIENT_ID=B.PATIENT_ID AND A.PATIENT_ID="+dPatient_id+ " order by a.VISIT_ADM_DATE_TIME desc");
			//sqlbuff.append("SELECT B.PATIENT_ID PATIENT_ID,B.PATIENT_NAME PATIENT_NAME,A.ENCOUNTER_ID ENCOUNTER_ID,B.SEX SEX,GET_AGE(B.DATE_OF_BIRTH) AGE FROM MP_PATIENT B,PR_ENCOUNTER A WHERE A.FACILITY_ID='"+FacilityId+"' AND A.PATIENT_ID IN ('"+pid+"') AND A.PATIENT_ID=B.PATIENT_ID group by B.PATIENT_ID,B.PATIENT_NAME,A.ENCOUNTER_ID,B.SEX,GET_AGE(B.DATE_OF_BIRTH) order by B.PATIENT_NAME");
			pstmt = conn.prepareStatement(sqlbuff.toString());
			rs = pstmt.executeQuery();

			String enc_status="";
			//String complete_yn="";
			//String partial_yn="";
			//String pending_yn="";
//			String enc_status_sql="";
			while(rs.next()){
				enc_line=rs.getString("ENCOUNTER_ID");
				String patsql1=" SELECT  b.PATIENT_CLASS, b.SPECIALTY_CODE, b.ENCOUNTER_ID, to_char(b.visit_adm_date_time,'dd/mm/yyyy')visit_adm_date_time, to_char(b.discharge_date_time,'dd/mm/yyyy')discharge_date_time,(b.discharge_date_time - b.discharge_date_time) v_los FROM PR_ENCOUNTER b WHERE  b.encounter_id ='"+enc_line+"' AND b.facility_id = '"+FacilityId+"' AND b.PATIENT_ID= "+dPatient_id + "order by b.VISIT_ADM_DATE_TIME desc";
				pstmt2 = conn.prepareStatement(patsql1);
				rs2 = pstmt2.executeQuery();
				while(rs2.next()){
					Pat_class= rs2.getString("PATIENT_CLASS");
					Pat_enc= rs2.getString("ENCOUNTER_ID");
					Pat_spec= rs2.getString("SPECIALTY_CODE");
					Pat_disch= rs2.getString("discharge_date_time");
					Pat_visit= rs2.getString("visit_adm_date_time");
					Pat_los= rs2.getString("v_los");
				}
				/*
				if(rs2 != null)rs2.close();
				if(pstmt2  != null)pstmt2.close();
				
				if(stage_no1.equals("1")){
					enc_status_sql="SELECT nvl(LEVEL1_STATUS,'P') enc_status FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";

				}else if(stage_no1.equals("2")){
					enc_status_sql="SELECT nvl(LEVEL2_STATUS,'P') enc_status FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";
				}else if(stage_no1.equals("3")){
					enc_status_sql="SELECT nvl(LEVEL3_STATUS,'P') enc_status FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";
				}

				pstmt2 = conn.prepareStatement(enc_status_sql);
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					enc_status = rs2.getString("enc_status");
				}
				*/
				if(rs2 != null)rs2.close();
				if(pstmt2  != null)pstmt2.close();
				// aded 19/jun	
				String sql_hdr_sts="SELECT CURR_LEVEL, nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";
				pstmt2 = conn.prepareStatement(sql_hdr_sts);
				rs2 = pstmt2.executeQuery();	
				while(rs2.next()){
					L1_hdr_status=rs2.getString("LEVEL1_STATUS");
					L2_hdr_status=rs2.getString("LEVEL2_STATUS");
					L3_hdr_status=rs2.getString("LEVEL3_STATUS");
					curr_level		  =rs2.getString("CURR_LEVEL");
					hdr_modified_dt=rs2.getString("MODIFIED_DATE");
				}
				if(stage_no1.equals("1")){
					enc_status=L1_hdr_status;
				}else if(stage_no1.equals("2")){
					enc_status=L2_hdr_status;
				}else if(stage_no1.equals("3")){
					enc_status=L3_hdr_status;
				}
				if(pstmt2!=null)pstmt2.close();
				if(rs2!=null)rs2.close();
				if(stage_no1.equals("2")){
					if(L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
						if(L1_hdr_status.equals("A")){
							L2_hdr_status="A";
						}
					}
					enc_status=L2_hdr_status;	
				}else if(stage_no1.equals("3")){
					if(L3_hdr_status.equals("P")){
						if((L1_hdr_status.equals("A") && L2_hdr_status.equals("P")) || L2_hdr_status.equals("A")){
							L3_hdr_status="A";
						}
					}
					enc_status=L3_hdr_status;
				}
				if(enc_status.equals("R")){
					enc_status="S";
				}
			%>
			<tr class='<%=classValue%>'>
			<%
			if(enc_status.equals("A"))	{
			%>
				<td class='<%=classValue%>' colspan='3' align='center'><img src='../../eCommon/images/Authorised.gif' ></img><a href="javascript:onclick=changePline('<%=enc_line%>','<%=FacilityId%>','<%=m%>','<%=L1_hdr_status%>','<%=L2_hdr_status%>','<%=L3_hdr_status%>','<%=curr_level%>')"><%=enc_line%></a></td>
			<%}else if(enc_status.equals("C"))	{
			%>
				<td class='<%=classValue%>' colspan='3' align='center'><img src='../../eCommon/images/Completed.gif' ></img><a href="javascript:onclick=changePline('<%=enc_line%>','<%=FacilityId%>','<%=m%>','<%=L1_hdr_status%>','<%=L2_hdr_status%>','<%=L3_hdr_status%>','<%=curr_level%>')"><%=enc_line%></a></td>

			<%
			}else if(enc_status.equals("S"))	{
			%>
				<td class='<%=classValue%>' colspan='3' align='center'><img src='../../eCommon/images/Partiallycompleted.gif' ></img><a href="javascript:onclick=changePline('<%=enc_line%>','<%=FacilityId%>','<%=m%>','<%=L1_hdr_status%>','<%=L2_hdr_status%>','<%=L3_hdr_status%>','<%=curr_level%>')"><%=enc_line%></a></td>

			<%
			}else{
			%>
				<td class='<%=classValue%>' colspan='3' align='center'><img src='../../eCommon/images/Pendingforreview.gif' ></img><a href="javascript:onclick=changePline('<%=enc_line%>','<%=FacilityId%>','<%=m%>','<%=L1_hdr_status%>','<%=L2_hdr_status%>','<%=L3_hdr_status%>','<%=curr_level%>')"><%=enc_line%></a></td>
			<%}%>
			
			<input type='hidden' name='enc1<%=m%>' id='enc1<%=m%>' value='<%=enc_line%>'>
			</tr>
			
			<%	

		} // while loop for encounter
		%>
		</table>
			</td>
		</tr>

		<%
	
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();

		i++;
		m++;
		n++;		
	
	}  /// for loop for pat id

	//if(rs1 != null)rs1.close();
		//if(pstmt1  != null)pstmt1.close();
	
%>


	</table>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=FacilityId%>'>
	<input type='hidden' name='dflt_termset' id='dflt_termset' value='<%=dflt_termset%>'>
	<input type='hidden' name='Pat_id' id='Pat_id' value='<%=Pat_id%>'>
	<input type='hidden' name='Pat_sex' id='Pat_sex' value='<%=Pat_sex%>'>
	<input type='hidden' name='Pat_age' id='Pat_age' value='<%=Pat_age%>'>
	<input type='hidden' name='stage_no' id='stage_no' value='<%=stage_no%>'>
	<input type='hidden' name='Pat_familyname' id='Pat_familyname' value='<%=Pat_familyname%>'>
	<input type='hidden' name='Pat_disch' id='Pat_disch' value='<%=Pat_disch%>'>
	<input type='hidden' name='Pat_visit' id='Pat_visit' value='<%=Pat_visit%>'>
	<input type='hidden' name='Pat_los' id='Pat_los' value='<%=Pat_los%>'>
	<input type='hidden' name='Pat_name' id='Pat_name' value='<%=Pat_name%>'>
	<input type='hidden' name='Pat_dob' id='Pat_dob' value='<%=Pat_dob%>'>
	<input type='hidden' name='Pat_class' id='Pat_class' value='<%=Pat_class%>'>
	<input type='hidden' name='Patient_Class' id='Patient_Class' value='<%=Patient_Class%>'>
	<input type='hidden' name='i' id='i' value='<%=i%>'>

	<input type='hidden' name='enc_val' id='enc_val' value='<%=enc_val%>'>
	<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect1%>'>
	<input type='hidden' name='enc_temp' id='enc_temp' value="<%=enc_temp%>">
	<input type='hidden' name='pat_temp' id='pat_temp' value="<%=pat_temp%>">
	<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value="<%=allow_recode_diag_yn%>">
	<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value="<%=allow_recode_proc_yn%>">
	<input type='hidden' name='hdr_modified_dt' id='hdr_modified_dt' value="<%=hdr_modified_dt%>">
	<input type='hidden' name='L1_hdr_status' id='L1_hdr_status' value="<%=L1_hdr_status%>">
	<input type='hidden' name='L2_hdr_status' id='L2_hdr_status' value="<%=L2_hdr_status%>">
	<input type='hidden' name='L3_hdr_status' id='L3_hdr_status' value="<%=L3_hdr_status%>">
	<input type='hidden' name='curr_level' id='curr_level' value="<%=curr_level%>">





	</form>
</body>
</html>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		session.removeAttribute("patientList");
		session.removeAttribute("encountertList");
		if(conn!=null){
			ConnectionManager.returnConnection(conn,request);
		}
	}
		%>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

