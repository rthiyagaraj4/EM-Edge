<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*,java.lang.Math.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eAE/js/AESecondaryTriage.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>   
<%
    Connection con				      = null;  
    PreparedStatement pstmt		      = null;
	ResultSet rset				      = null;
	PreparedStatement pstmtEncounter  = null; 
    ResultSet rsetEncounter			  = null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");


	String strQueryString      = request.getQueryString();
	String facilityId			= (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
//	String Dob = request.getParameter("Dob");
	String encounter_id  = request.getParameter("encounter_id");
	String called_from_ca      = request.getParameter("called_from_ca");
	if((called_from_ca==null) || (called_from_ca.equals("null")) || (called_from_ca=="") || (called_from_ca.equals("")))
	called_from_ca= "N";
	String alergyProp = "";
	String disRecord 			= "";
	String ca_install_yn		= "";
	String modify_flag			= request.getParameter("modify_flag")==null?"N":request.getParameter("modify_flag"); 
	if(modify_flag.equals("Y"))
	 {
		 disRecord ="disabled";
	 }
	//String last_encounter_id    = ""; Wednesday, May 05, 2010 venkats PE_EXE
	String EncounterProp        = "";
	String VisitProp            = "";
	
	//Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650
	Boolean isReplacePresntngPrblmByChiefComp = true;

	Boolean isChngBtnPositionAppl = false;//Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655

	int countRecEnc             =  0;
	double prev_visit_hrs       = 0d;
	try{
		con = ConnectionManager.getConnection(request);

		  isReplacePresntngPrblmByChiefComp = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","REPLACE_PRE_PROB_BY_CHF_COMPL"); //Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650

		  isChngBtnPositionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","DIAGNOSIS_DTLS_IN_24HRS_VISIT");//Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655
	
		try
		 {
			 pstmt = con.prepareStatement("select install_yn from sm_module where module_id='CA' ");
			 rset = pstmt.executeQuery();
			 while(rset!=null  && rset.next())
			  {
				ca_install_yn		= rset.getString("install_yn");
			  }
			  if(rset!=null) rset.close();
			  if(pstmt!=null) pstmt.close();
		 }catch(Exception e)
		 {
			e.printStackTrace();
		 }
		 if(ca_install_yn.equals("Y"))
				alergyProp = "";
		 else {
				alergyProp = "disabled";
			}

/*
	StringBuffer displLastVisit = new StringBuffer();
	displLastVisit.append(" SELECT ENCOUNTER_ID from PR_ENCOUNTER where  ");
	displLastVisit.append(" VISIT_ADM_DATE_TIME = (SELECT max(visit_adm_date_time) ");
	displLastVisit.append(" from PR_ENCOUNTER where PATIENT_ID = ? and   ");
	displLastVisit.append(" VISIT_STATUS !='99'  and FACILITY_ID = ? and ");
	displLastVisit.append(" patient_class = 'EM' and ae_episode_yn='Y' ) ");
	displLastVisit.append(" and PATIENT_ID = ? and  VISIT_STATUS !='99' ");
	displLastVisit.append(" and FACILITY_ID = ? and patient_class='EM' and ");
	displLastVisit.append(" ae_episode_yn='Y'  ");
    try{
		   pstmt = con.prepareStatement(displLastVisit.toString());
		   pstmt.setString(1,patient_id);
		   pstmt.setString(2,facilityId);
		   pstmt.setString(3,patient_id);
		   pstmt.setString(4,facilityId);
		   rset = pstmt.executeQuery();
		   while(rset!=null && rset.next())
		   {
				last_encounter_id = rset.getString(1);
		   }
		   if(rset!=null) rset.close();
		   if(pstmt!=null) pstmt.close();
		   if((displLastVisit != null) && (displLastVisit.length() > 0))
		   {
				displLastVisit.delete(0,displLastVisit.length());
		   }
	 }catch(Exception e)
     {
        out.println("Exception in CAInstall ="+e);
     }

	 */
	 try
	  {	
	   StringBuffer sqlPr = new StringBuffer();
       sqlPr.append("select count(*) from pr_encounter where ");
	   sqlPr.append("facility_id= ?  and patient_id= ? and encounter_id !=? ");
	   pstmtEncounter = con.prepareStatement(sqlPr.toString());
       pstmtEncounter.setString(1,facilityId );
	   pstmtEncounter.setString(2,patient_id );
	   pstmtEncounter.setString(3,encounter_id );

	   rsetEncounter = pstmtEncounter.executeQuery();
		  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  countRecEnc=rsetEncounter.getInt(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((sqlPr != null) && (sqlPr.length() > 0))
		  {
			sqlPr.delete(0,sqlPr.length());
		  }
		  if (countRecEnc==0)
		  {
			  EncounterProp = "disabled";
		  }else
		  {
			  EncounterProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}

	   try
	  {	
	   StringBuffer prevEnc = new StringBuffer();
	   prevEnc.append("SELECT (SYSDATE - MAX (VISIT_STATUS_SET_ON_DATE)) ");
	   prevEnc.append(" * 24  PREV_VISIT_HRS FROM PR_ENCOUNTER WHERE  ");
	   prevEnc.append(" facility_id = ?  AND patient_id = ?  ");
	   prevEnc.append(" AND VISIT_STATUS in ('07', '09')   ");
	   pstmtEncounter = con.prepareStatement(prevEnc.toString());
       pstmtEncounter.setString(1, facilityId);
	   pstmtEncounter.setString(2, patient_id);

	   rsetEncounter = pstmtEncounter.executeQuery();
			  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  prev_visit_hrs = rsetEncounter.getDouble(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((prevEnc != null) && (prevEnc.length() > 0))
		  {
			prevEnc.delete(0,prevEnc.length());
		  }
		  if(prev_visit_hrs > 24 || prev_visit_hrs == 0) {
			  VisitProp = "disabled";
		  }else if(prev_visit_hrs > 0 && prev_visit_hrs <= 24)
		  {
			  VisitProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}

	}catch(Exception e){e.printStackTrace();}
	finally
     {
		ConnectionManager.returnConnection(con,request);
    }
	  
	 
%>
<body onKeyDown = 'lockKey()'>
<center>
<form name='SecondaryTriageButtonsForm' id='SecondaryTriageButtonsForm' method='post'>
<table border="0" cellpadding="0" cellspacing="0" align='center' colspan=3 width="100%">
<tr><td colspan=3 class=label ></td></tr>
<tr>
<td colspan='3' class="BUTTON" >
<% if(!isChngBtnPositionAppl){ %><!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655-->
	<input type="button" name="allergy_det" id="allergy_det" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllergyDetails.label","common_labels")%>' onClick='recAllergyDet();' <%=alergyProp%>> 
	<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
	<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
<% } %>
<%if(!isReplacePresntngPrblmByChiefComp){ %>
<input type=button name='ChiefComplaints' id='ChiefComplaints' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")%>'   onClick='ChiefComplaints_type()'  class='Button'  > 
<%}%>

<input type=button name='Record' id='Record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'   class='Button'  onClick='apply1()' <%=disRecord%> >
<input type=button name='Reset' id='Reset' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>'   onClick='resetpage()'  class='Button'  >  <% if(called_from_ca .equals("Y")) {%>   
      <input type=button name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'   onClick='close_func()'  class='Button' disabled>
<%}else{%>
	<input type=button name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  onClick='close_func()'  class='Button' >
<%}%>
</td>
</tr>
</table>
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
<input type='hidden' name='query_string' id='query_string' value="<%=strQueryString%>">
<input type='hidden' name='modify_flag' id='modify_flag' value="<%=modify_flag%>">
<input type='hidden' name='called_from_ca' id='called_from_ca' value="<%=called_from_ca%>">
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<!--Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652-->
<input type='hidden' name='isDiagDtlsSectionAppl' id='isDiagDtlsSectionAppl' value='<%=isChngBtnPositionAppl%>'>

</form>
</center>
</body>
</html>


