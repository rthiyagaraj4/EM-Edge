<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"   contentType="text/html;charset=UTF-8" %>
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
	  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	  <script language='javascript' src='../../eMO/js/MOBurialPermit.js' ></script>
	  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
	  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   <%
        Connection con						= null;
    	PreparedStatement pstmt				= null;
        ResultSet rset						= null ;
		String patient_id_length			= "";
        String facility_id 					= (String) session.getValue( "facility_id" ) ;
        String patientid					= request.getParameter("param");
        String first						= request.getParameter("first");
        if(first==null) first				= "";
        if(patientid==null) patientid		= "";
        String patient_id					= request.getParameter("patient_id");
		if(patient_id==null) patient_id		= "";
		String burial_permit_no				= request.getParameter("burial_permit_no");
		if(burial_permit_no==null)
		   burial_permit_no = "";
		String mode							= request.getParameter("mode");
		if(mode==null) mode = "";

	    try{
                    con						= ConnectionManager.getConnection(request);
				    String patLength		= "select PATIENT_ID_LENGTH from MP_PARAM";
					pstmt					= con.prepareStatement(patLength);
					rset					= pstmt.executeQuery();
					if(rset!=null)
			         {
						while(rset!=null && rset.next())
				    	{   
							patient_id_length = rset.getString(1);
					
					    } 
					 }
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
                
    %>
</head> 
  <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='searchPatient(document.forms[0].patient_id);'>
   <form name="bury_form1" id="bury_form1" action="" method="post" >
   <br><br>
	<table border="0" cellpadding="2" cellspacing="0" align='center' width='90%'>
		<tr>
			<td class='LABEL'  width="25%"><fmt:message key="eMO.DeceasedPatientID.label" bundle="${mo_labels}"/>
			</td>
			<td lass='field' width='25%'><input type='text'  name='patient_id' id='patient_id'  value="<%=patient_id%>"  maxLength='<%=patient_id_length%>' size='20' onKeyPress="return CheckForSpecChars(event)"   readonly><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="searchCode1(this,document.forms[0].patient_id);" disabled><img name='mandatory' src='../../eCommon/images/mandatory.gif'></img>
			</td> 
			<td width='25%' colspan='2'>&nbsp;</td>
		</tr>
   </table>
		<input type=hidden name ="facilityId" value='<%=facility_id%>'>
		<input type=hidden name ="first" value='<%=first%>'>
		<input type=hidden name ="gotoser" value=''>
 	    <input type=hidden name ="patientid" value='<%=patientid%>'>
        <input type=hidden name ="mode" value='<%=mode%>'>
 </form>
 </body>
<%
	}
    catch(Exception e)
    {
        out.print(e.toString());
    }
    finally
    {
        
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>	 

