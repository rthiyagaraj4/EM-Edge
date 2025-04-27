<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

04/05/2015  IN053425		NijithaS										ML-BRU-SCF-1544  
09/06/2015  IN055539		NijithaS										System displays wrong records when status is Alive.
18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	

----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCA.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><!-- 32902 -->


<HTML><head>
<%
//oracle.jdbc.driver.*,
	request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
</head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/RelatedPatientHist.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCA/js/CACommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- 32902 -->

<%

out.println("<BODY  class='CONTENT' onLoad=\"parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num= ';\" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	StringBuffer sql = new StringBuffer();
	String sqlbuild="";
	String orderby="";
   
	String	facilityId 	= (String) session.getValue( "facility_id" )==null ? "" : (String) session.getValue( "facility_id" ) ;
	String	patientId 	= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	String  practitioner_id=(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");

	
	
	String from 					= request.getParameter("from") ;
	String to 						= request.getParameter("to") ;

	String view			= (request.getParameter("view")==null)?"":request.getParameter("view");
    String spl			= (request.getParameter("spl")==null)?"":request.getParameter("spl");
	String rest			= (request.getParameter("rest")==null)?"":request.getParameter("rest");
	String from_date	= (request.getParameter("from_date")==null)?"":request.getParameter("from_date");
	String to_date		= (request.getParameter("to_date")==null)?"":request.getParameter("to_date");
	
	from_date			=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date				=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");

	String diag1		= request.getParameter("diag");
	//IN053425 Starts
	String diagnew1 = "";
	if (!diag1.equals("")) 
	    diagnew1  = diag1.substring(0,diag1.indexOf("-"));
	//IN053425 Ends
	String diag2		= request.getParameter("diag2");
		if (diag2==null)  diag2="";
	
	String diagnew2  = "";
	
	if (!diag2.equals(""))  
		diagnew2=diag2.substring(0,diag2.indexOf("-"));

	String diag3		= request.getParameter("diag3");
	
	if (diag3==null)  diag3="";
	
	String diagnew3  = "";
	
	if (!diag3.equals(""))  
	diagnew3=diag3.substring(0,diag3.indexOf("-"));

	String b_year		= request.getParameter("b_year")==null?"":request.getParameter("b_year");
	String b_months     = request.getParameter("b_months")==null?"":request.getParameter("b_months");
	String b_days		= request.getParameter("b_days")==null?"":request.getParameter("b_days");
	String b_year2		= request.getParameter("b_year2")==null?"":request.getParameter("b_year2");
	String b_months2    = request.getParameter("b_months2")==null?"":request.getParameter("b_months2");
	String b_days2      = request.getParameter("b_days2")==null?"":request.getParameter("b_days2");
 	String sex		    = request.getParameter("sex")==null?"": request.getParameter("sex");
 	String status		= request.getParameter("status")==null?"":request.getParameter("status");
 	String group		= request.getParameter("group")==null?"":request.getParameter("group");
 	String term_set_id		= request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String otherDiagYN		= request.getParameter("otherdiag")==null?"N":request.getParameter("otherdiag");//IN053425
	//32902 start
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1					= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	 int accessRightsViewPatient=bean1.getAccessRightsViewPatient(practitioner_id,facilityId);	
	 //32902 end


	String fr_age="",to_age="";
	String whereClause				= request.getParameter("whereclause");
			 
	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(view.equals("S"))
			sqlbuild=sqlbuild+" and exists(select 1 from ca_encntr_pract_reln where FACILITY_ID=a.onset_facility_id and ENCOUNTER_ID=a.onset_encounter_id and PRACTITIONER_ID='"+practitioner_id+"')";

	    if( !(spl == null || spl.equals("")) )
			sqlbuild=sqlbuild+" and c.SPECIALTY_CODE='"+spl+"' ";
	
		if(rest.equals("F") || rest.equals("E"))
			sqlbuild=sqlbuild+" and c.facility_id='"+facilityId+"' ";

		if( !(from_date == null || from_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME>=to_date('"+from_date+"' ,'dd/mm/yyyy')";
	
		if( !(to_date == null || to_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME<=to_date('"+to_date+"' ,'dd/mm/yyyy')+.99 ";

		if(!(sex == null || sex.equals("")))
			sqlbuild=sqlbuild+" and b.sex='"+sex+"'";

		if(status.equals("D"))
			sqlbuild=sqlbuild+" and EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='Y' AND  disp_type=C.DISPOSITION_TYPE) ";
		else if(status.equals("A"))//IN055539
			sqlbuild=sqlbuild+" and (C.DISPOSITION_TYPE is null or EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='N' AND  disp_type= nvl(C.DISPOSITION_TYPE,'xxx'))) ";
    
		if ((!b_year.equals("")) ||(!b_months.equals(""))||(!b_days.equals("")))
		{  
			if (b_year.equals(""))
			  b_year="0";
			if (b_months.equals(""))
			  b_months="0";
			if	(b_days.equals(""))
			  b_days="0";
			fr_age="("+b_year+"*365+"+b_months+"*30+"+b_days+")";
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth>"+fr_age+" ";
		}
	
		if ((!b_year2.equals("")) ||(!b_months2.equals(""))||(!b_days2.equals("")))
		{  
			if (b_year2.equals(""))
			  b_year2="0";
			else
			   b_year2="("+b_year2+"+1)";
			if (b_months2.equals(""))
			  b_months2="0";
			else
			   b_months2="("+b_months2+"+1)";
			if	(b_days2.equals(""))
			  b_days2="0";
			else
			   b_days2="("+b_days2+"+1)";
			to_age="("+b_year2+"*365+"+b_months2+"*30+"+b_days2+")";
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth<="+to_age+" ";
		}
	}
	else
		sqlbuild=whereClause;
	
	
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 7 ;
	else
		end = Integer.parseInt( to ) ;

		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int maxRecord = 0;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  
   //   out.println("<script>alert('Quest')</script>");
//     out.println("<script>alert('"+group+"')</script>");

	  sql.append("SELECT COUNT(*) as total FROM PR_DIAGNOSIS A,MP_PATIENT B,PR_ENCOUNTER C WHERE B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID  AND TERM_SET_ID=?  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') ) */ and a.TERM_CODE in ('"+diagnew1+"' ");
		
	  if (!diagnew2.equals(""))
		  sql.append(",'"+diagnew2+"'");
	  
	  if (!diagnew3.equals(""))
		  sql.append(",'"+diagnew3+"'");
	  //IN053425 Starts
	  if(otherDiagYN.equals("Y"))
		  sql.append(",'*OTH'");
	  //IN053425 Ends
	 
	  sql.append(") ");

	  if (!patientId.equals("")){
		  //sql.append(" and a.patient_id!='"+patientId+"' ");//common-icn-0180
		  sql.append(" and a.patient_id!= ? ");//common-icn-0180
	  }	  
	  sql.append(sqlbuild);

	  sql.append(" AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,b.patient_id,c.facility_id)");//32902

	  int pstmtcount =1;//common-icn-0180
	  pstmt = con.prepareStatement(sql.toString());
	  
	  //pstmt.setString(1,term_set_id);//common-icn-0180
	  //pstmt.setString(2,practitioner_id);//32902//common-icn-0180
	  //common-icn-0180 starts
	  pstmt.setString(pstmtcount++,term_set_id);
	  if (!patientId.equals("")){
	  pstmt.setString(pstmtcount++,patientId);
	  }
	  pstmt.setString(pstmtcount++,practitioner_id);
	//common-icn-0180 ends

      rs = pstmt.executeQuery();

	 while(rs!=null && rs.next())
		{
		  maxRecord = rs.getInt("total");
        }
		
      if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
	  
	  if (maxRecord== 0)
	  {
	  %>
	  	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		
		</script>
	 <%
	  }
	  else
		{
 
    if(group.equals("1"))
    orderby=orderby+" ORDER BY 1";
	else if(group.equals("4"))
    orderby=orderby+" ORDER BY 4";
	else if(group.equals("8"))
    orderby=orderby+" ORDER BY 8";
	else
    orderby=orderby+" ORDER BY 1";  
     StringBuffer sqlnew	= new StringBuffer();
		
	// sqlnew.append("SELECT distinct D.SHORT_DESC DIAG_DESC  ,A.TERM_CODE DIAG_CODE  ,A.PATIENT_ID  ,replace(decode('"+locale+"','en',PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)),'''','')  PATIENT_NAME ,c.patient_class ,(SELECT SHORT_DESC  FROM AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS=C.PATIENT_CLASS 	AND LANGUAGE_ID='"+locale+"') PATIENT_CLASS_DESC  ,CASE WHEN PATIENT_CLASS IN ('EM','OP') then 	(SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID   	 AND   CLINIC_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"') 	WHEN PATIENT_CLASS IN ('IP','DC') then 	(SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID 	 AND   NURSING_UNIT_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"' )   END LOCN_DESC  ,(SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW    WHERE PRACTITIONER_ID=C.ATTEND_PRACTITIONER_ID AND LANGUAGE_ID='"+locale+"') PRACT_NAME  ,(SELECT SHORT_DESC||DECODE(DECEASED_YN,'Y','/(Deceased)') FROM AM_DISPOSITION_TYPE_LANG_VW    WHERE DISP_TYPE=C.DISPOSITION_TYPE   AND LANGUAGE_ID='"+locale+"' ) DISPOSITION_TYPE_DESC  ,(SELECT COUNT(*) FROM pr_diagnosis_ENC_DTL    WHERE PATIENT_ID=A.PATIENT_ID    AND TERM_SET_ID =A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) ENC_COUNT,C.ENCOUNTER_ID EID,C.FACILITY_ID FID,A.OCCUR_SRL_NO SRLNO,c.facility_id Facility FROM  PR_DIAGNOSIS A ,MP_PATIENT B ,PR_ENCOUNTER C ,MR_TERM_CODE D WHERE     B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') )*/ AND A.TERM_SET_ID=? and a.TERM_CODE in ('"+diagnew1+"' ");//32902
           //sqlnew.append("SELECT distinct D.SHORT_DESC DIAG_DESC  ,A.TERM_CODE DIAG_CODE  ,A.PATIENT_ID  ,replace(decode('"+locale+"','en',PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)),'''','')  PATIENT_NAME ,c.patient_class ,(SELECT SHORT_DESC  FROM AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS=C.PATIENT_CLASS 	AND LANGUAGE_ID='"+locale+"') PATIENT_CLASS_DESC  ,CASE WHEN PATIENT_CLASS IN ('EM','OP') then 	(SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID   	 AND   CLINIC_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"') 	WHEN PATIENT_CLASS IN ('IP','DC') then 	(SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID 	 AND   NURSING_UNIT_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"' )   END LOCN_DESC  ,(SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW    WHERE PRACTITIONER_ID=C.ATTEND_PRACTITIONER_ID AND LANGUAGE_ID='"+locale+"') PRACT_NAME  ,(SELECT SHORT_DESC||DECODE(DECEASED_YN,'Y','/(Deceased)') FROM AM_DISPOSITION_TYPE_LANG_VW    WHERE DISP_TYPE=C.DISPOSITION_TYPE   AND LANGUAGE_ID='"+locale+"' ) DISPOSITION_TYPE_DESC  ,(SELECT COUNT(*) FROM pr_diagnosis_ENC_DTL    WHERE PATIENT_ID=A.PATIENT_ID    AND TERM_SET_ID =A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) ENC_COUNT,C.ENCOUNTER_ID EID,C.FACILITY_ID FID,A.OCCUR_SRL_NO SRLNO,c.facility_id Facility,b.restrict_reinstate_yn FROM  PR_DIAGNOSIS A ,MP_PATIENT B ,PR_ENCOUNTER C ,MR_TERM_CODE D WHERE     B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') )*/ AND A.TERM_SET_ID=? and a.TERM_CODE in ('"+diagnew1+"' ");//32902
           sqlnew.append("SELECT distinct D.SHORT_DESC DIAG_DESC  ,A.TERM_CODE DIAG_CODE  ,A.PATIENT_ID  ,replace(decode(?,'en',PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)),'''','')  PATIENT_NAME ,c.patient_class ,(SELECT SHORT_DESC  FROM AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS=C.PATIENT_CLASS 	AND LANGUAGE_ID= ?) PATIENT_CLASS_DESC  ,CASE WHEN PATIENT_CLASS IN ('EM','OP') then 	(SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID   	 AND   CLINIC_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID= ?) 	WHEN PATIENT_CLASS IN ('IP','DC') then 	(SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID 	 AND   NURSING_UNIT_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID= ? )   END LOCN_DESC  ,(SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW    WHERE PRACTITIONER_ID=C.ATTEND_PRACTITIONER_ID AND LANGUAGE_ID= ?) PRACT_NAME  ,(SELECT SHORT_DESC||DECODE(DECEASED_YN,'Y','/(Deceased)') FROM AM_DISPOSITION_TYPE_LANG_VW    WHERE DISP_TYPE=C.DISPOSITION_TYPE   AND LANGUAGE_ID= ? ) DISPOSITION_TYPE_DESC  ,(SELECT COUNT(*) FROM pr_diagnosis_ENC_DTL    WHERE PATIENT_ID=A.PATIENT_ID    AND TERM_SET_ID =A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) ENC_COUNT,C.ENCOUNTER_ID EID,C.FACILITY_ID FID,A.OCCUR_SRL_NO SRLNO,c.facility_id Facility,b.restrict_reinstate_yn FROM  PR_DIAGNOSIS A ,MP_PATIENT B ,PR_ENCOUNTER C ,MR_TERM_CODE D WHERE     B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') )*/ AND A.TERM_SET_ID=? and a.TERM_CODE in ('"+diagnew1+"' ");//32902

	  if (!diagnew2.equals(""))
		  sqlnew.append(",'"+diagnew2+"'");
	  
	  if (!diagnew3.equals(""))
		  sqlnew.append(",'"+diagnew3+"'");
	  //IN053425 Starts	 
	  if(otherDiagYN.equals("Y"))
		  sqlnew.append(",'*OTH'");
	  //IN053425 Ends
	  sqlnew.append(") ");
	  if (!patientId.equals("")){
		  //sqlnew.append(" and a.patient_id!='"+patientId+"' ");//common-icn-0180
		  sqlnew.append(" and a.patient_id!= ? ");//common-icn-0180
	  
	  }
	  sqlnew.append(" AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,b.patient_id,c.facility_id)");//32902

	  sqlnew.append(sqlbuild+orderby);
      
      int pstmtcount1 = 1;//common-icn-0180
      pstmt = con.prepareStatement(sqlnew.toString());
	 // pstmt.setString(1,term_set_id);//common-icn-0180
	 // pstmt.setString(2,practitioner_id);//32902//common-icn-0180

	  //common-icn-0180 starts
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,term_set_id);
	  if (!patientId.equals("")){
	  pstmt.setString(pstmtcount1++,patientId);
	  }
	  pstmt.setString(pstmtcount1++,practitioner_id);
	  
	//common-icn-0180 ends
	  
	  rs = pstmt.executeQuery();
     

%>
<!--<p>-->
<table cellpadding='3' align='center' width='100%'>
<tr>
<td width='90%' class='white' ></td>
<td width='10%'>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eCA/jsp/RelatedPatientHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&term_set_id="+term_set_id+"&diag3="+diag3+"&otherdiag="+otherDiagYN+"&group="+group+"&patient_id="+patientId+"&from="+(start-7)+"&to="+(end-7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");//IN053425 added otherDiagYN

  if ( !( (start+7) > maxRecord ) )
	{
		out.println("<A HREF='../../eCA/jsp/RelatedPatientHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&diag3="+diag3+"&otherdiag="+otherDiagYN+"&term_set_id="+term_set_id+"&group="+group+"&patient_id="+patientId+"&from="+(start+7)+"&to="+(end+7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none' class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");//IN053425 added otherDiagYN
	}
	
%>
</td>
</tr>
</table>
<!--</p> 
<br><br> -->
<table  width="100%" class='grid'>
<td class='columnheader' width='3%' nowrap>&nbsp;&nbsp;</td>
<%
	if(!(group.equals("1")))
	 {
%>
<td class='columnheader' width='10%'  nowrap><fmt:message key="eCA.DiagID.label" bundle="${ca_labels}"/></td>
<td class='columnheader' width='20%'  nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<% }%>

<%
	if(!(group.equals("4")))
	 {
%>
<td class='columnheader' width='10%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td class='columnheader' width='20%' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
<% } %>



<td class='columnheader' width='10%' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
<td class='columnheader' width='15%' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<td class='columnheader' width='15%' nowrap><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>

<%
	if(!(group.equals("8")))
	 {
%>
<td class='columnheader' width='10%'><fmt:message key="Common.DisplayType.label" bundle="${common_labels}"/></td>
<% } %>



<td class='columnheader' width='5%'><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>


<%
	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
// String classValue = "" ;
 String prev="";
 String prevpat="";
 String prevdtype="";
 //String cur="";

 while ( rs!=null && rs.next() && i<=end )
 {
	 	 
	/* if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;*/

     String diagdesc = (rs.getString("DIAG_DESC")==null)?"":rs.getString("DIAG_DESC");
	 String diagcode = (rs.getString("DIAG_CODE")==null)?"":rs.getString("DIAG_CODE");
	 String patid = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
	 String patname = (rs.getString("PATIENT_NAME")==null)?"":rs.getString("PATIENT_NAME");
	 String distype = (rs.getString("DISPOSITION_TYPE_DESC")==null)?"&nbsp;":rs.getString("DISPOSITION_TYPE_DESC");
	 String enccount = (rs.getString("ENC_COUNT")==null)?"":rs.getString("ENC_COUNT");
	// String fid = (rs.getString("FID")==null)?"":rs.getString("FID");
	 String eid = (rs.getString("EID")==null)?"":rs.getString("EID");
	 String srlno = (rs.getString("SRLNO")==null)?"":rs.getString("SRLNO");
	 String faci = (rs.getString("Facility")==null)?"":rs.getString("Facility");
	 String patclass_desc= rs.getString("PATIENT_CLASS_DESC")==null?"":rs.getString("PATIENT_CLASS_DESC");
	 String patclass= rs.getString("patient_class")==null?"":rs.getString("patient_class");
	 String restPatientYN= rs.getString("restrict_reinstate_yn")==null?"":rs.getString("restrict_reinstate_yn");//kp

     
    if(!(diagcode.equals(prev)))
	 {
	if((group.equals("1")))
	 {
	out.println("<tr><td nowrap  class='CAHIGHERLEVELCOLOR' align=left colspan='8' ><font  size=2>"+diagcode+"/");
    out.println(diagdesc+"</font></td></tr>"); 
	 }
	 }

	 if(!(patid.equals(prevpat)))
	 {
	if((group.equals("4")))
	 {
	out.println("<tr><td nowrap align=left colspan='2' class='gridLink'><font size=2><a href=\"javascript:openHistory('"+eid+"','"+patclass+"' )\" class='gridLink'>"+patid+"</a></td>");
    out.println("<td class='' colspan='6'>"+patname+"</font></td></tr>"); 
	 }
	 }
  //  out.println("<script>alert('distype"+distype+"');</script>");
//	out.println("<script>alert('prevdtype"+prevdtype+"');</script>");
//	out.println("<script>alert('group"+group+"');</script>");
	 if(!(distype.equals(prevdtype)))
	 {
	if((group.equals("8")))
	 {
	out.println("<tr><td nowrap align=left colspan='9' class='CAHIGHERLEVELCOLOR'><font  size=2>"+distype+"</td></font></tr>");
    
	 }
	 }
   
	 
    if(Integer.parseInt(enccount) > 1)
	 {
    out.println("<tr><td nowrap class='gridData'><a href=\"javascript:showEncounterDeatils('"+patid+"','"+srlno+"','"+diagcode+"', '"+term_set_id+"')\" class='gridLink'>&nbsp;&nbsp;+&nbsp;&nbsp;</a>");
	 }
	 else
	 {
	 out.println("<tr><td nowrap class='gridData'>&nbsp;");
	 }
	out.println("</td><td nowrap class='gridData'>");
	
	
	
	/*out.println("<a href='../../eCA/jsp/x.jsp?clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"' target='f_query_add_mod' >"); */

	
	
	
	if(!(group.equals("1")))
	 {
	out.println(diagcode+"</td><td nowrap class='gridData'>");
    out.println(diagdesc+"</td><td nowrap class='gridData'>"); 
	 }

	
	if(!(group.equals("4")))
	 {
	//out.println("<a href=\"javascript:openHistory('"+eid+"','"+patclass+"')\" class='gridLink'>"+patid+"</a></td><td  class='gridData'> ");//32902
      out.println("<a href=\"javascript:openHistory('"+eid+"','"+patclass+"','"+i+"')\" class='gridLink'>"+patid+"</a></td><td  class='gridData'> ");//32902
	out.println(patname+"</td><td  class='gridData'>");
	 }
	
	
	out.println(patclass_desc+"</td><td  class='gridData'>");

	String location = rs.getString("LOCN_DESC")==null?"":rs.getString("LOCN_DESC");
	out.println(location+"</td><td  class='gridData'>");

	String practname = rs.getString("PRACT_NAME")==null?"":rs.getString("PRACT_NAME");
	out.println(practname+"</td><td  class='gridData'>");

	if(!(group.equals("8")))
	 {
	out.println(distype+"</td><td align='center' class='gridData'>");
	 }

	
	out.println("<a href=\"javascript:populateChart('"+faci+"','"+eid+"','"+patid+"')\" class='gridLink'><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td>");

	//out.println("<a href='javascript:' onClick='populate(\""+fid+"\");'><img src='../../eCA/images/flow_text.gif' ></a></td>");
    
	

prev=diagcode;	
prevpat=patid;
prevdtype=distype;
      //32902
	%>
		 <input type='hidden' id='patid<%=i%>' name='patid<%=i%>' value=<%=patid%>>
	 	 <input type='hidden' id='accessRightsViewPatient' name='accessRightsViewPatient' id='accessRightsViewPatient' value=<%=accessRightsViewPatient%>>	 
	 	 <input type='hidden' id='restPatientYN<%=i%>' name='restPatientYN<%=i%>' value=<%=restPatientYN%>>	 
	 	 <%
      //32902

i++;
 }//endwhile 
		}
 %>
</td></tr>
</table>
	 
<br><center>
</center>
<%

 }catch(Exception e)
     {
        e.printStackTrace();
		e.toString();
		//out.println(e.toString());//COMMON-ICN-0181
     }
	finally   
	{
		 if(pstmt!=null)pstmt.close();
		 if(rs!=null)rs.close();
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }
%>
<form name="chartForm" id="chartForm" action="OpenChartWrapper.jsp">
	 <input type="hidden" name='insert_op' id='insert_op' value= 'N'>
	 <input type='hidden' name='encounter_id' id='encounter_id' value= ''>
	 <input type='hidden' name='episode_id' id='episode_id' value= ''>
	 <input type='hidden' name='patient_class' id='patient_class' value= ''>
	 <input type='hidden' name='called_function_id' id='called_function_id' value= 'REL_PAT_TREAT'> 
</form>
</BODY>
</HTML>


