<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script language="javascript" src="../../eMO/js/MOExportDeceased.js"></script> 
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <%	
	Connection con 				   = null;
	java.sql.Statement stmt				   = null;
	ResultSet rset			       = null;
	String	facilityId 		       = (String) session.getValue( "facility_id" ) ;
	String locale = ((String)session.getAttribute("LOCALE"));
	
	
	
	Properties p; //Manivannan added for the ML-MMOH-CRF-0691
	
	
p = (java.util.Properties) session.getValue( "jdbc" ) ; //Manivannan added for the ML-MMOH-CRF-0691
	String UserId = p.getProperty( "login_user" ) ;//Manivannan added for the ML-MMOH-CRF-0691 

	
	int yt = 0 ;
	
	try
	{
		String patientid = request.getParameter("param");
		
		String chktw     = request.getParameter("chktw");
		String first     = request.getParameter("first");	

		if(patientid==null) patientid	= "";
		if(chktw==null)		chktw		= "";
		if(first==null)		first		= "";

		con					=	ConnectionManager.getConnection(request);
		String loginUserName	= ""; 
		String pname		=	"";
		String sex			=	"";
		String expyn		=	"";
		StringBuffer sql = new StringBuffer();
		String age			=	"";
		String cname		=	"";
		String destination	=	"";
		String expdate		=	"";
		String byrecddate	=	"";
		String sydate		=	"";   
		String patid="";
		Boolean relLetterEmbassyApplicable = false; //Added by Mano Aganist ML-MMOH-CRF-0738
		Boolean isHealthOfficer_YN	= eCommon.Common.CommonBean.isSiteSpecific(con, "MO","HEALTH_OFFICER_APPLICABLE");//Manivannan added for the ML-MMOH-CRF-0691 
		relLetterEmbassyApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MO","RELEASE_LETTER_FRM_EMBASSY_YN"); //Added by Mano aganist ML-MMOH-CRF-0738
	  
		if(!(patientid.equals("")))
		{
		 sql.append("select decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang,patient_name)) PATIENT_NAME,SEX,EXPORTATION_REQD_YN,age,destination,(EXPORTATION_DOC_ISS_DATE) ot_date_time,(RELEASE_BODY_DATE) byrecddate,patient_id,sm_get_desc.sm_appl_user('"+UserId+"','"+locale+"','1') loginUserName  from mo_mortuary_regn_vw where REGISTRATION_NO='"+patientid+"' and EXPORTATION_REQD_YN ='Y' and EXPORTATION_DOC_ISS_DATE is  null and FACILITY_ID = '"+facilityId+"'");
		 
		 stmt  = con.createStatement();
		 
		 rset	= stmt.executeQuery(sql.toString());
		 while(rset!=null  && rset.next())
		 {
			yt  = 1;
			loginUserName=checkForNull(rset.getString("loginUserName")); 
		    pname = rset.getString(1);
			if(pname==null) pname ="";
			sex = rset.getString(2);
			if(sex==null) sex ="";		  
			expyn = rset.getString(3);
		    if(expyn==null) expyn ="";
			if(expyn.equals("Y")) expyn ="YES";
			if(expyn.equals("N")) expyn ="NO";
		    age = rset.getString(4);
		    if(age==null) age ="";
			destination = rset.getString(5);
		    if(destination==null) destination ="";
			expdate = rset.getString(6);
		    if(expdate==null) expdate ="";
			byrecddate = rset.getString(7);
		    if(byrecddate==null) byrecddate ="";
		 patid = rset.getString("patient_id");
		    if(patid==null) patid ="";
		    
		 } if(rset!=null) rset.close();
 	       if(stmt!=null) stmt.close();
	  }	  
	       sql.setLength(0);
	
 	 if(!(patientid.equals("")))
	 {
	 	stmt = con.createStatement();
		rset = stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy hh24:mi') ot_date_time from dual");
		if(rset!=null)
		 {
		   while(rset.next())
		   {
			  sydate = rset.getString("ot_date_time");
		   }
		 } if(rset!=null) rset.close();
		   if(stmt!=null) stmt.close();
		   
	}
	if(yt==1)
	{
		sql.append("select name  from mo_claimant where REGISTRATION_NO ='"+patientid+"' and FACILITY_ID = '"+facilityId+"'");
		
		stmt =con.createStatement();
		rset = stmt.executeQuery(sql.toString());
		while(rset!=null  && rset.next())
		 {
			cname = rset.getString("name");
			  if(cname==null) cname ="";
			
		 } if(rset!=null) rset.close();
		   if(stmt!=null) stmt.close();
	}
	if(expdate.equals("")) expdate =sydate;
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='firstfocus();'>
<form name="EDeceased_form" id="EDeceased_form" action="../../servlet/eMO.MOExportDeceasedServlet" method="post" target="msgFrame">
<input type=hidden name ="facilityId"	value='<%=facilityId%>'>
<input type=hidden name ="patient_id"	value='<%=patientid%>'>
<input type=hidden name ="patid"	value='<%=patid%>'>

<input type=hidden name ="ssdate"		value='<%=sydate%>'>
<input type=hidden name ="first"		value='<%=first%>'>
<input type=hidden name ="byrecddate"	value='<%=byrecddate%>'>
<input type=hidden name ="prnyn1"		value=''>
<input type=hidden name ="chktw"		value='<%=chktw%>'>
<input type=hidden name ="tosub"		value=''>
<input type=hidden name ="relLetterEmbassyApplicable" value='<%=relLetterEmbassyApplicable%>'> <!--Added by Mano aganist ML-MMOH-CRF-0738-->
<br><br>
<!-- <table border="0" cellpadding="0" cellspacing="0" align='center' width='82%'>
<tr><td colspan='4'>&nbsp;</td></tr>
	 <tr>		  
	 <td class='LABEL' align='center' width="10%" nowrap colspan = 2>&nbsp;&nbsp;&nbsp;Registration Number&nbsp;&nbsp;
		 <input type='text'  name='patient_id' id='patient_id'  value="<%=patientid%>"  size="18" maxlength="16" onKeyPress="return(CheckForSpecChars(event));" onblur='chkman(this);'><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="searchCode(this, patient_id);" >&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
	 </td>	
	 <td align='left' width='10%'>&nbsp;</td>
	 <td align='left' width='50%'>&nbsp;</td>
</tr>
<tr><td colspan='4'>&nbsp;</td></tr>	
</table> -->
<table border="0" cellpadding="3" cellspacing="0" align='center' width='90%' id='details'>
	<td colspan="4" ></td>
		<tr>	     
		   
			<td class='label'  width='9%' nowrap><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
		     <td class='label' align='left' width='15%'><b><%=patientid%></b>
			 </td> 
			
			<td class='label'  width='3%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='label' align='left' width='16%'><b><%=patid%></b>
		   </td> 	
			  
		     </tr>
	<tr>		      
		<td class='label'  width='12%' nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='label'  width='16%' colspan="3"><b><%=pname%></b>
		</td> 	
	</tr>	
	<tr>	     
		<td class='label'  width='9%' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		<td class='label'  width='20%'><b><%=age%></b>
		</td> 
		<!--Label Modified by Ajay on 22-Nov-2022 for ML-MMOH-SCF-2209-->
		<td class='label'  width='3%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='label'  width='16%'><b><%=sex%></b>
		</td> 	
	</tr>
	<tr>		      
	  <td class='label'  nowrap><fmt:message key="eMO.ClaimantAccompany.label" bundle="${mo_labels}"/></td>
	  <td class='label' ><b><%=cname%></b>
	  </td> 	
	  <td align='left' width='13%'>&nbsp;</td>
	  <td align='left' width='20%'>&nbsp;</td>
	</tr>
	<% if(isHealthOfficer_YN){ //Manivannan added for the ML-MMOH-CRF-0691

	
	
	
%>
	<tr>		      
	  <td class='label'  width='9%'><fmt:message key="eMO.HealthOfficer.label" bundle="${mo_labels}"/>&nbsp;</td>
	  <td class='querydata' width='16%' style='word-wrap: break-word;width:300px;'><%=loginUserName%>&nbsp;
	  <input type=hidden name ="health_officer"		value='<%=UserId%>'>
	  </td> 	
	<% } else { %>
	  <td class='label'  width='9%'><fmt:message key="eMO.HealthOfficer.label" bundle="${mo_labels}"/>&nbsp;</td>
	  <td class='field'  width='16%'><b><input type='text'   size="29" maxlength="30" name='health_officer' id='health_officer'></b>
	 
	  </td> 	
	
	<% } %>
	
	<!-- <td align='left' width='13%'>&nbsp;</td>
	  <td align='left' width='20%'>&nbsp;</td> -->
	   <td class='label'   width='3%'><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
	  <td class='field'><input type='text' size="25" maxlength="30" name='designation' id='designation'>&nbsp;
	  </td>
	</tr>
	<tr><td class=label ><fmt:message key="eMO.HealthOfficerRemarks.label" bundle="${mo_labels}"/>&nbsp;</td>
	<td colspan=3 ><TEXTAREA style="resize:none;" NAME="remarks" ROWS="2" COLS="30" onblur='checkmaxlength(this);'></TEXTAREA></td>
	</tr>
	<tr>		      
	  <td class='label'  width='9%'><fmt:message key="Common.Destination.label" bundle="${common_labels}"/></td>
	  <td class='field' width='16%'><b><input type='text' size="40" maxlength="30" name='des' id='des' value='<%=destination%>'></b><img src='../../eCommon/images/mandatory.gif'align='center'></img>
	  </td> 	
	  <td align='left' width='13%'>&nbsp;</td>
	  <td align='left' width='20%'>&nbsp;</td>
	</tr>	
	  <tr><td class=label ><fmt:message key="eMO.ExportationAddress.label" bundle="${mo_labels}"/>&nbsp;</td>
	<td colspan=3 ><TEXTAREA style="resize:none;" NAME="exportation_address" ROWS="5" COLS="30"></TEXTAREA></td>
  </tr>
  <!--<tr><td colspan='4'>&nbsp;</td></tr>-->
  <tr><td class=label  nowrap><fmt:message key="eMO.EmbassyCertificateNo.label" bundle="${mo_labels}"/></td>
	<td class='field'><INPUT TYPE="text" name="embassy_certificate_no" id="embassy_certificate_no"  maxlength=50></td>
	<td class=label ><fmt:message key="Common.issuedby.label" bundle="${common_labels}"/></td>
	<td class='field'><INPUT TYPE="text" name="exportation_doc_issued_by" id="exportation_doc_issued_by" maxlength=30></td>
  </tr>	  
	<tr>		      
	  <td class='label'  width='9%'><fmt:message key="Common.issueddatetime.label" bundle="${common_labels}"/></td>
	  <td class='field' align='left' width='16%'><b><input type='text' size="16" maxlength="16" name='doi' id='doi' value='<%=DateUtils.convertDate(expdate,"DMYHM","en",localeName)%>' onblur='dtchk(this);'></b><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].doi.select();return showCalendar('doi', null, 'hh:mm' );"style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
	  </td> 
	  <%if(relLetterEmbassyApplicable){%>
	  <td class='label'  width='9%'><fmt:message key="eMO.ReleaseLetterFromEmbassy.label" bundle="${mo_labels}"/></td>
	  <td class='field' width="25%">
	  <input type='checkbox' name='release_letter_frm_embassy_yn' id='release_letter_frm_embassy_yn' value='Y'  ></td>
	  <%}%>
	    
	  <td class='label'  width='3%'></td>
	  <td class='label'  width='16%'></td>
	</tr>	
	<tr><td class='label' colspan='6' align='right'><input type='button' class='button' name='Record' id='Record' value='Record' onClick='recordExpDec();'><input type='button' class='button' name='Close' id='Close' value='Close' onClick='CloseExpDec();'></tr>
</table>
</form>
</body>
</html>
<% 
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();
	} 
	catch(Exception e){ out.println("Exception in File MOExportDeceasedSearch "+e.toString());
	}
	finally
    {
	   ConnectionManager.returnConnection(con,request);
    }
%>

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

