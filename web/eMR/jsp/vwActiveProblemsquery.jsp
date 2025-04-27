<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,com.ehis.util.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %><!--,oracle.jdbc.driver.*-->

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale	= (String)session.getAttribute("LOCALE");
	String userid	= p.getProperty( "login_user" ) ;

	String patID=request.getParameter("Patient_Id");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String facility_id = (String) session.getValue("facility_id");

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<script language='javascript'src='../../eMR/js/vwActiveProblems.js' ></script>
<script>
async function showEncounter(enc,patid,Patient_Class)
{
	
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="CurrentEncounterMain.jsp";
	var win_height = "98vh";
	var win_width= "75vw";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + ";" ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
}

async function authorizeFn(obj)
{
	var pat_id = document.forms[0].patID.value;

	if(obj.id=="Sensitive")
	{
		var val1 = 'V' ;
		var val2 = 'Ass' ;
		var val3='C'
		if('Y'=="PatientQueue")
			val3="O";
		var val = val1+'/'+val2+'/'+val3+'/';

		var retVal = 	new String();
		var dialogHeight= "9vh" ;
		var dialogWidth	= "25vw" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../eMR/jsp/AuthorizeMRAccess.jsp?constr="+val,arguments,features);
		if(retVal=="T")
		{
			window.location.href='../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=Y&Patient_Id='+pat_id;
			document.getElementById("authorize").value = getLabel("Common.Normal.label","Common");//"Normal";
		}
		/*else
		{			
			window.location.href='../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=Y&Patient_Id='+pat_id;
		}*/		
	}
	else
	{																			
		window.location.href='../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=N&Patient_Id='+pat_id
		document.getElementById("authorize").value = getLabel("Common.Sensitive.label","Common");//"Sensitive";
	}
}

</script>
</head>
<body OnMouseDown='CodeArrest();'  onKeyDown = 'lockKey()' class='CONTENT'>      
<%
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
Connection conn =null;

Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;
int sensitive_cnt = 0;
String diag_code_scheme="";
String onset_date = "";
String onset_date_display = "";
String diag_desc = "";
String diag_code = "";
String diag_code_scheme_desc = "";
String primary_diag = "";
String problem_status = "";
String sensitive_disp = "";
String sensitive_auth = "";
String sensitive_yn ="";
String visit_adm_date_time="";
String visit_adm_date_time_display="";
String patient_class="";
String discharge_date_time="";
String discharge_date_time_display="";
String onset_facility_id="";
String encounter_id="";
String patient_id="";
// 01 Oct 2010 IN024038 for Principl daignosis check mark
String diag_class_type="";

//Added for this CRF ML-MMOH-CRF-0868 
boolean isSupportingDiag = false ; 
String supporting_code="", supporting_desc="";

%>
<form name = "qryform" action="../../eMR/jsp/vwActiveProblemsquery.jsp" method ='post'>
<%
try{
	conn = ConnectionManager.getConnection(request) ;
	stmt = conn.createStatement();
	
	//Below line added for this CRF ML-MMOH-CRF-0868 
	isSupportingDiag=CommonBean.isSiteSpecific(conn, "MR","ACTIVE_PROB_LIST_EXT_CAUSES");
	
	sensitive_disp = request.getParameter("sensitive_disp");
	if (sensitive_disp==null) sensitive_disp = "";

	String strsql1="select diag_code_scheme from mr_parameter";
	rs = stmt.executeQuery(strsql1);
	if (rs.next())
		diag_code_scheme=  rs.getString(1);

	/*strsql1="select count(*) as total from pr_problem_vw where patient_id = '"+patID+"' and nvl(problem_status,'O')!='C' and nvl(sensitive_yn,'N') != 'Y' and diag_code_scheme= '"+diag_code_scheme+"'";
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();
	rs = stmt.executeQuery(strsql1);
    
	if (rs.next())
	{
//		maxRecord = rs.getInt("total");
	}
	*/
	strsql1="select '1' from mr_user_access_rights_vw where appl_user_id = '"+userid+"' and access_type = 'V' and facility_id = '"+facility_id+"' and access_scope= 'SD'";

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();

	rs = stmt.executeQuery(strsql1);
	if (rs.next())
		sensitive_auth = "Y";	
	

	strsql1="select count(*) as total from pr_problem where patient_id = '"+patID+"' and nvl(problem_status,'O')!='C' and nvl(sensitive_yn,'N') = 'Y' and diag_code_scheme= '"+diag_code_scheme+"'";

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();

	rs = stmt.executeQuery(strsql1);    
	if (rs.next())
		sensitive_cnt = rs.getInt("total");
   
	//String strsql2="select a.patient_id,a.onset_encounter_id,a.onset_facility_id,a.srl_no,decode(b.patient_class,'IP','Inpatient','OP','Outpatient','EM','Emergency','DC','DayCare') patient_class,to_char(b.visit_adm_date_time,'dd/mm/yyyy') visit_adm_date_time,to_char(b.discharge_date_time,'dd/mm/yyyy') discharge_date_time,to_char(a.onset_date,'dd/mm/yyyy') onset_date, a.sensitive_yn, a.diag_desc,a.diag_code,a.diag_code_scheme_desc, a.significant_yn,	decode(a.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype,nvl(a.PRIMARY_YN,'N') primary_diag, decode(a.problem_status, 'C', 'Closed', 'A','Active', 'B', 'Better', 'W', 'Worse', 'S', 'Same') problem_status, nvl(a.sensitive_yn,'N') sensitive_yn from pr_problem_vw a,pr_encounter b where a.onset_facility_id = b.facility_id and a.onset_encounter_id = b.encounter_id and a.patient_Id='"+patID+"' and  nvl(a.problem_status,'O')!='C' and a.diag_code_scheme= '"+diag_code_scheme+"' order by diagtype,onset_date desc ";

	// String strsql2="select a.patient_id, a.onset_encounter_id,a.onset_facility_id,a.srl_no,		 AM_GET_DESC.AM_PATIENT_CLASS(b.patient_class,'"+locale+"','2') patient_class,to_char(b.visit_adm_date_time,'dd/mm/yyyy') 		 visit_adm_date_time, to_char(b.discharge_date_time,'dd/mm/yyyy') discharge_date_time,to_char(a.onset_date,'dd/mm/yyyy') onset_date, a.sensitive_yn, a.diag_desc,a.diag_code, DECODE(A.DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') diag_code_scheme_desc,  a.significant_yn, a.diag_type diagtype, nvl(a.PRIMARY_YN,'N') primary_diag, a.problem_status problem_status,		 nvl(a.sensitive_yn,'N') sensitive_yn from pr_problem a, pr_encounter b where a.onset_facility_id = b.facility_id and a.onset_encounter_id = b.encounter_id and a.patient_Id='"+patID+"' and  nvl(a.problem_status,'O')!='C' and 	 a.diag_code_scheme= '"+diag_code_scheme+"' order by diagtype, onset_date DESC";
	//Maheshwaran k commented as on 17/09/2013
	//String strsql2="SELECT   a.patient_id, a.onset_encounter_id, a.onset_facility_id, a.occur_srl_no,am_get_desc.am_patient_class (b.patient_class, 'en','2') patient_class, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy') visit_adm_date_time, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy') discharge_date_time,TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date,a.term_code_short_desc diag_desc, a.term_code diag_code, a.term_set_id, a.curr_status,c.DIAG_CLASS_TYPE diag_class_type FROM pr_diagnosis a, pr_encounter b,MR_DIAG_CLASS c  WHERE a.onset_facility_id = b.facility_id AND a.onset_encounter_id = b.encounter_id AND a.patient_id = '"+patID+"' AND a.curr_status != 'E' AND a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE(+) /*AND a.term_set_id = 'ICD10'*/ ORDER BY onset_date DESC";
	String strsql2="SELECT   a.patient_id, a.encounter_id onset_encounter_id, a.facility_id onset_facility_id, a.occur_srl_no,am_get_desc.am_patient_class (b.patient_class, 'en','2') patient_class, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy') visit_adm_date_time, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy') discharge_date_time,TO_CHAR (a.recorded_date_time, 'dd/mm/yyyy') onset_date,a.term_code_short_desc diag_desc, a.term_code diag_code, a.term_set_id, a.status curr_status,c.DIAG_CLASS_TYPE diag_class_type FROM pr_diagnosis_enc_dtl a, pr_encounter b,MR_DIAG_CLASS c  WHERE a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND a.patient_id = '"+patID+"' AND a.status != 'E' AND a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE(+) /*AND a.term_set_id = 'ICD10'*/ ORDER BY onset_date DESC";

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();

	rs = stmt.executeQuery(strsql2);
	
	if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			 }

	 
	 if(rs !=null) 
	{
	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{

%>
<table border="0" width="100%" cellspacing='0' cellpadding='0'>

	<tr>
		
<%
	if(!(start <= 1))
	{
		out.println("<td align='right' id='prev' width='100%'><a href='../../eMR/jsp/vwActiveProblemsquery.jsp?from="+(start-14)+"&to="+(end-14)+"&Patient_Id="+patID+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	
	}
	else{
	out.println("<td align='right' id='next' style='visibility:hidden'><a id = 'nextval' href='../../eMR/jsp/vwActiveProblemsquery.jsp?from="+(start+14)+"&to="+(end+14)+"&Patient_Id="+patID+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	}
%>
		
	</tr>
</table>
<table width="100%" cellspacing='0' cellpadding='0'>
	<% 	
		
		if (!sensitive_disp.equals("Y"))
		{
			
			if (sensitive_auth.equals("Y") && sensitive_cnt > 0)
				out.println("<tr><td class='button'><input type='button' name='authorize' id='authorize' id='Sensitive'  value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sensitive.label","common_labels")+"' class='button' onclick='authorizeFn(this);'></td></tr>");
		}
		else
		{
			
			out.println("<tr><td class='button'><input type='button' name='authorize' id='authorize'  id='Normal'  value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"' class='button' onclick='authorizeFn(this);'></td></tr>");
		}
	%>
</table>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th nowrap>+</th>
<th nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.primary.label" bundle="${common_labels}"/></th>
<!-- <th nowrap>Status</th> -->
<%
 	
		}
		String classValue = "" ;
		visit_adm_date_time =rs.getString("visit_adm_date_time");
		if(visit_adm_date_time == null) 
		{
			visit_adm_date_time="&nbsp;";
			visit_adm_date_time_display="&nbsp;";
		}
		else
			visit_adm_date_time_display = DateUtils.convertDate(visit_adm_date_time,"DMY","en",locale);
		
		patient_class =rs.getString("patient_class");
		if(patient_class == null) patient_class="&nbsp;";
		discharge_date_time =rs.getString("discharge_date_time");
		if(discharge_date_time == null)
		{
			discharge_date_time="&nbsp;";
			discharge_date_time_display="&nbsp;";
		}
		else
			discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMY","en",locale);
		encounter_id=rs.getString("onset_encounter_id");
		onset_facility_id=rs.getString("onset_facility_id");
		patient_id=rs.getString("patient_id");
		onset_date =rs.getString("onset_date");
		if(onset_date == null) 
		{
			onset_date="&nbsp;";
			onset_date_display="&nbsp;";
		}
		else
			onset_date_display = DateUtils.convertDate(onset_date,"DMY","en",locale);
		diag_desc 	= rs.getString("diag_desc");
		if(diag_desc == null) diag_desc="&nbsp;";
		diag_code	= rs.getString("diag_code");
		if(diag_code == null) diag_code="&nbsp;";
		diag_code_scheme_desc =rs.getString("term_set_id"); 
		
		
		//Below line added for this CRF ML-MMOH-CRF-0868
		supporting_code="";supporting_desc="";
		if(isSupportingDiag){
		String externalDiagCode[]  = eMR.MRCommonBean.getExternalCauseDiagCode(conn,patID,diag_code_scheme_desc,diag_code);			    
		    if(externalDiagCode.length==2){
				supporting_code=" > "+externalDiagCode[0];				 
				supporting_desc=" > "+externalDiagCode[1];				 
			}
        System.err.println("vwActiveProblemsquery.jsp externalDiagCode.length=====>"+externalDiagCode.length);			
        }  
        		
	   //End this CRF ML-MMOH-CRF-0868
		
		if(diag_code_scheme_desc == null) diag_code_scheme_desc ="&nbsp;";
		/*
		primary_diag =rs.getString("primary_diag");
		if(primary_diag == null) primary_diag = "&nbsp;";
		problem_status =rs.getString("problem_status");
		if(problem_status == null) problem_status="&nbsp;";
		sensitive_yn = rs.getString("sensitive_yn");
		if(sensitive_yn == null) sensitive_yn="";
		*/
		//if (!sensitive_yn.equals("Y") || (sensitive_disp.equals("Y") && sensitive_yn.equals("Y")))
		//{

			// 01 Oct 2010 IN024038 for Principl daignosis check mark
			diag_class_type=rs.getString("diag_class_type");			
			if(diag_class_type == null) diag_class_type="&nbsp;";
			
			

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			if (sensitive_disp.equals("Y") && sensitive_yn.equals("Y"))
				classValue = "PATQRED" ;
				out.println("<tr><td nowrap class='" + classValue + "'>");%>
			<a href="javascript:showEncounter('<%=encounter_id%>','<%=patient_id%>','<%=patient_class%>')">+</a>
			<%
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(patient_class);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(visit_adm_date_time_display);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(discharge_date_time_display);

			out.println("</td><td nowrap class='" + classValue + "'>");
//			String code = rs.getString("onset_date");

			out.println(onset_date_display+"</a></td><td style='WORD-BREAK:BREAK-ALL;' class='" + classValue + "'>");
			out.println(rs.getString("diag_desc")+supporting_desc); //Modified for this CRF ML-MMOH-CRF-0868
			out.println("</a></td><td style='WORD-BREAK:BREAK-ALL;' class='" + classValue + "'>");
			out.println(rs.getString("diag_code")+supporting_code); //Modified for this CRF ML-MMOH-CRF-0868
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(rs.getString("term_set_id"));
			out.println("</td><td align='center' nowrap class='" + classValue + "'>");
			// 01 Oct 2010 IN024038 for Principl daignosis check mark
			if (diag_class_type.equals("PD")) 
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("&nbsp;");
			//Below line commented for ML-MMOH-CRF-0868		
			//out.println("</td><td nowrap align='center' class='" + classValue + "'>");
			
			out.println("</td></tr>");
			
		//}
		i++;
		maxRecord++;
	  }//endwhile
}
	  if(i == 1)
	{
  		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}

	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% 
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}
  	
}catch(Exception e){
		//out.print(e.toString());
		e.printStackTrace();

}
	finally   {
		try
		{

	if(rs!=null)	rs.close();
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
		}
		catch(Exception e){

}

	ConnectionManager.returnConnection(conn,request);
	}
%>
<!--Below line commented for ML-MMOH-CRF-0868-->
<!--</td></tr>-->
</table>
<center>
</center>
<input type="hidden" name="patID" id="patID"       value="<%= patID %>">
<input type='hidden' name='from' id='from' value='<%=start%>'>
<input type='hidden' name='to' id='to' value='<%=end%>'>
</form>

</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

