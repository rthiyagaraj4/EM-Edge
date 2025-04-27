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
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eMO/js/MOBurialPermit.js' ></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script language='javascript' src='../../eCommon/js/dchk.js' > </script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%	
 Connection con 					  = null;
 java.sql.Statement stmt1					  = null; 
 ResultSet rset					      = null;
 StringBuffer sql					  = new StringBuffer();
 String locale		                    = (String)session.getAttribute("LOCALE");
 String	facility_id 				  = (String) session.getValue( "facility_id" ) ;
 String patientid = request.getParameter("param");
 if(patientid==null) patientid = "";
 String mode = request.getParameter("mode");
 if(mode==null) mode = "";
 
 String modePro ="";
 String burial_permit_no          ="";
 String burial_permit_approved_by_name ="";
 String burial_permit_approved_by = "";
 String burial_permit_approved_date ="";
 
 String genBurialPermitNo = "";
 if(mode.equals("query") ){
	 modePro ="readonly";
	 genBurialPermitNo = "disabled";
 }
 try
  {
     con			=	ConnectionManager.getConnection(request);

     String sydate	=	"";
	 String deceased_date = "";
	 String ssdate	=	"";
	 Boolean isRemoveMandBPermitAppBy = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","BURIAL_PERMIT_MANDATORY");//Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]
     if(!(patientid.equals("")))
	 {
		 sql.append("select to_char(DECEASED_DATE,'dd/mm/yyyy hh24:mi') DECEASED_DATE from mp_patient where patient_id='"+patientid+"' and DECEASED_YN ='Y' ");
		 stmt1	= con.createStatement();
		 rset	= stmt1.executeQuery(sql.toString());
		 while(rset!=null  && rset.next())
		 {
			   deceased_date = rset.getString("DECEASED_DATE");
		 }
	  }	  
	  sql.setLength(0);
	  if(deceased_date==null || deceased_date.equals("null")) deceased_date = "";
	  if(rset!=null) rset.close();
	  if(stmt1!=null) stmt1.close();

	  if(!(patientid.equals("")))
		{
			stmt1 = con.createStatement();
			rset = stmt1.executeQuery("select to_char(sysdate,'dd/mm/yyyy hh24:mi') ot_date_time,to_char(sysdate,'dd/mm/yyyy')ssdate from dual");
			while(rset.next())
			{
			   sydate = rset.getString("ot_date_time");
			   ssdate = rset.getString("ssdate");
			}
			if(rset!=null) rset.close();
	        if(stmt1!=null) stmt1.close();
		

		    stmt1 = con.createStatement();
			rset = stmt1.executeQuery("select DISCH_PRACTITIONER_ID, DISCH_PRACT_NAME from mo_encounter_dtls_vw where  facility_id='"+facility_id+"' and patient_id='"+patientid+"'");
			while(rset.next())
			{
			   burial_permit_approved_by = rset.getString("DISCH_PRACTITIONER_ID")==null?"":rset.getString("DISCH_PRACTITIONER_ID");
			   burial_permit_approved_by_name = rset.getString("DISCH_PRACT_NAME")==null?"":rset.getString("DISCH_PRACT_NAME");
			}
			if(rset!=null) rset.close();
	        if(stmt1!=null) stmt1.close();
		
		
		}
    /*   if(mode.equals("query")){
	
		strsql2="select patient_id,burial_permit_no, burial_permit_approved_by_name,burial_permit_approved_by,burial_permit_approved_date from mo_burial_permit_vw where  facility_id='"+facility_id+"' and patient_id='"+patientid+"'"; 
		stmt1 = con.createStatement();
		rset = stmt1.executeQuery(strsql2);
		while(rset.next())
		{
          patient_id                     = rset.getString("patient_id");
	      burial_permit_no               = rset.getString("burial_permit_no");
	      burial_permit_approved_by_name = rset.getString("burial_permit_approved_by_name");
		  burial_permit_approved_by      = rset.getString("burial_permit_approved_by");
	      burial_permit_approved_date= rset.getString("burial_permit_approved_date");
        }
		patient_id	= (patient_id== null) ? "" :patient_id;
	    burial_permit_no	= (burial_permit_no== null) ? "" :burial_permit_no;
	    burial_permit_approved_by_name	= (burial_permit_approved_by_name== null) ? "" :burial_permit_approved_by_name;
		burial_permit_approved_by	= (burial_permit_approved_by== null) ? "" :burial_permit_approved_by;
	    burial_permit_approved_date	= (burial_permit_approved_date== null) ? "" :burial_permit_approved_date;
	 }*/
	 
	 
	 /*Added by santhosh for ML-MMOH-CRF-1947 Start*/
	 Boolean maxSizeBurialPermitAppl = false;
	 maxSizeBurialPermitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MAX_SIZE_BURIAL_PERMIT");
	 String max_size_burial_permit_no = "";
	 stmt1 = con.createStatement();
		rset = stmt1.executeQuery("select NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO, DATETIME_CLAIM_MAND from mo_parameter a where  a.facility_id='"+facility_id+"' ");
		while(rset.next())
		{
		   max_size_burial_permit_no = (maxSizeBurialPermitAppl)?rset.getString("MAX_SIZE_BURIAL_PERMIT_NO"):"16";
		}
		if(rset!=null) rset.close();
		if(stmt1!=null) stmt1.close();
		
	/*END*/
%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='document.forms[0].burial_permit_no.focus();'>
	<form name="bury_form" id="bury_form" action="../../servlet/eMO.MOBurialPermitServlet" method="post" target="messageFrame">
	<input type=hidden name ="facilityId" value='<%=facility_id%>'>
	<input type=hidden name ="patient_id" value='<%=patientid%>'>
	<input type=hidden name ="sydate" value='<%=sydate%>'>
	<input type=hidden name ="ssdate" value='<%=ssdate%>'>
	<input type=hidden name ="mode" value='<%=mode%>'>
	<br><br>
	 <table border="0" cellpadding="2" cellspacing="0" align='center' width='90%'>
	 <tr>
	     <td class='label' width='25%'><fmt:message key="eMO.GenerateBurialPermit.label" bundle="${mo_labels}"/>&nbsp;&nbsp;</td>
		 <td class='field' width='25%'><input type='checkbox' name="gen_burial_permit" id="gen_burial_permit"  onClick='genBurialPerNo(this);' value='N' <%=genBurialPermitNo%> >
		 </td> 
		 <td class='label'  width='25%' colspan='2'></td>
	 </tr>
	 <tr>	
		<td class='label' width='25%'><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></td>
		 <%if(mode.equals("query")){%><!--maxlength="16" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->
				<td class='field' width='25%'><input type='text' size="16" maxlength="<%=max_size_burial_permit_no%>" tabindex='1' name='burial_permit_no'  onKeyPress="return CheckForSpecChars(event);" value='<%=burial_permit_no%>'  <%=modePro%> ><img id='mand2' tabindex='2' src='../../eCommon/images/mandatory.gif' align='center'></img>
		  </td> 
	      <%}else{%><!--maxlength="16" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->
				<td class='field' width='25%'><input type='text' size="16" tabindex='1' maxlength="<%=max_size_burial_permit_no%>" name='burial_permit_no' value='<%=burial_permit_no%>'  onKeyPress="return CheckForSpecCharsLocal(event);" onblur='burialNoValid(this);' ><img id='mand2' tabindex='2' src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
		  <%}%>
		  <td class='label' width='25%' colspan='2'></td>

	  </tr>	
	  <tr>	
	      <td class='label' width='25%'><fmt:message key="eMO.BurialPermitApprovedBy.label" bundle="${mo_labels}"/></td>
		  <td class='field' width='25%'>
		  <!-- isRemoveMandBPermitAppBy condition Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]-->
		 <% if(!isRemoveMandBPermitAppBy){%>
		  <input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="<%=burial_permit_approved_by_name%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);'><input type='button' name='pract_id' id='pract_id' value='?' class='button' onclick='searchCode(this, burial_permit_app_by)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
         <input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value ='<%=burial_permit_approved_by%>'>
		<%}else{%>
			<!--Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990-->
			<input type='text' name='burial_permit_app_by' id='burial_permit_app_by' value="<%=burial_permit_approved_by_name%>" size="60" maxlength="60"/>
			<input type='hidden' name="burial_permit_app_desc" id="burial_permit_app_desc" value=""/>
			<input type='hidden' name='pract_id' id='pract_id' value=""/>

		  <%}%>
		</td>
	   	<td class='label' width='25%' colspan='2'></td>
  	
	 </tr>
	   <%if(mode.equals("query")){%>		  
	   <tr>		      
	      <td class='label' width='25%'><fmt:message key="eMO.BurialPermitApprovalDate.label" bundle="${mo_labels}"/></td>
	      <td class='field' width='25%'><input type='text' size="16" maxlength="16" name='bpadate' id='bpadate' value="<%=DateUtils.convertDate(burial_permit_approved_date,"DMYHM","en",locale)%>" onblur='dtchk2(this);'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].bpadate.select();return showCalendar('bpadate', null, 'hh:mm' );"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		  </td> 	
		  <td class='label' width='25%' colspan='2'></td>
	   </tr>
       <%}else{%>	
         <tr>		      
	      <td class='label' width='25%'><fmt:message key="eMO.BurialPermitApprovalDate.label" bundle="${mo_labels}"/></td>
	      <td class='field' width='25%'><input type='text' size="16" maxlength="16" name='bpadate' id='bpadate' value="<%=DateUtils.convertDate(sydate,"DMYHM","en",locale)%>" onblur='dtchk2(this);'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].bpadate.select();return showCalendar('bpadate', null, 'hh:mm' );" style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		  </td> 
		  <td class='label' width='25%' colspan='2'></td>
	   </tr>
       <%}%>
	</table>
	<input type='hidden' name='deceased_date' id='deceased_date' value ='<%=deceased_date%>'>
	<input type='hidden' name='isRemoveMandBPermitAppBy' id='isRemoveMandBPermitAppBy' value ='<%=isRemoveMandBPermitAppBy%>'> <!--Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]-->
 </form>
 </body>

<% 
	        if(rset!=null) rset.close();
	        if(stmt1!=null) stmt1.close();
   } 
   catch(Exception e){ out.println("Main "+e);}
   finally
    {
		    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

