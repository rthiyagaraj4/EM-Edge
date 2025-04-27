<!DOCTYPE html>
<PRE></PRE>
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
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eMO/js/MORegisterAttn.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

        Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
        String  disabledyn="";
		
		con                  = ConnectionManager.getConnection(request);
		
		String patient_id_length	 = "";
		String facilityId			 = (String)session.getValue("facility_id");
        String patientID=request.getParameter("patientID")==null?"":request.getParameter("patientID"); 
		String mode=request.getParameter("mode")==null?"":request.getParameter("mode"); 		
	    String menudis=request.getParameter("menudis")==null?"":request.getParameter("menudis"); 
		String external=request.getParameter("external")==null?"N":request.getParameter("external"); 
		String register_no=request.getParameter("register_no")==null ?"":request.getParameter("register_no"); //Added for this CRF Bru-HIMS-CRF-407 [IN:045167]
	    String burial_permit_no="";
		 if(mode.equals("modify")||menudis.equals("Y")||mode.equals("viewdata"))
		 {
		    pstmt = con.prepareStatement("select BURIAL_PERMIT_NO from MO_mortuary_regn where facility_id='"+facilityId+"' and patient_id='"+patientID+"'");
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				burial_permit_no = rset.getString("BURIAL_PERMIT_NO")==null?"":rset.getString("BURIAL_PERMIT_NO");
				
			}
		  
		   if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();		 
			 
			 disabledyn="readOnly";
          //disablebtn="disabled";
		 }
		int flag=0;
		int flag1=0;
		try{
             
			   
				    String patLength = "select PATIENT_ID_LENGTH, to_char(sysdate,'dd/mm/yyyy') from MP_PARAM";
					pstmt   = con.prepareStatement(patLength);
					rset = pstmt.executeQuery();
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
	 <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()"	 onLoad="setFocus();clearing()">
	 <form name="ae_patient_form" id="ae_patient_form">
	  	<%
            pstmt = con.prepareStatement("select count(*) from MO_Parameter where facility_id='"+facilityId+"'");
			rset = pstmt.executeQuery();
			if(rset!=null)
		   {
			while(rset.next())
			{
				flag1 = rset.getInt(1);
				
			}
		   }
		   if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();	
			if(flag1==0)
			{
			%>
				<script>
				alert(getMessage("PARAMETER_TO_BE_SETUP","MO"))
				parent.parent.location.href='../../eCommon/jsp/dmenu.jsp';
			    </script>
		 <%}

             pstmt = con.prepareStatement("select count(*) from MO_REGN_NUM_CONTROL where facility_id='"+facilityId+"'");
			rset = pstmt.executeQuery();
			if(rset!=null)
		   {
				while(rset.next())
				{
					flag = rset.getInt(1);
				}
		   }if(rset!=null) rset.close();
			
			if(flag==0)
			{
			%>
				<script>
				alert(getMessage("REGN_NO_CTRL_TO_BE_SETUP","MO"))
			   	history.go(-1);
			    </script>
			 <%}else{%>
		<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>			
	      <tr>
			<td class='label' width='25%'><fmt:message key="eMO.BurialPermitNo.label" bundle="${mo_labels}"/></td>
            <td class='fields' width='25%' >
		   <%	
				if(mode.equals("modify")||mode.equals("viewdata"))
				{
		   %>
			<input type='text' name='BURIAL_PERMIT_NO' id='BURIAL_PERMIT_NO' value="<%=burial_permit_no%>" disabled maxLength='16' size='20' onKeyPress="return CheckForSpecChars(event)" ><input type="button" name="burialno_search" id="burialno_search" disabled class=BUTTON value="?" onClick="callpatientsearch(this,'<%=facilityId%>',BURIAL_PERMIT_NO)" ></td>
			<%
				}
				else
				{
		   %>
			<input type='text' name='BURIAL_PERMIT_NO' id='BURIAL_PERMIT_NO' value="<%=burial_permit_no%>"  disabled maxLength='16' size='20' onKeyPress="return CheckForSpecChars(event)"  onBlur="searchPatient(this,'<%=mode%>');ChangeCase(this)"><input type="button" name="burialno_search" id="burialno_search" disabled class=BUTTON value="?" onClick="callpatientsearch(this,'<%=facilityId%>',BURIAL_PERMIT_NO)" ></td>
			<%}%>			
		    <td class='label' width='20%'><fmt:message key="eMO.DeceasedPatientID.label" bundle="${mo_labels}"/></td>
  		    <td class='fields' width='30%' ><input type='text' name='patient_id' id='patient_id'  value="<%=patientID%>" <%=disabledyn%> maxLength='<%=patient_id_length%>' size='20' onKeyPress="return CheckForSpecChars(event)"   onBlur="searchPatient(this,'<%=mode%>');ChangeCase(this)" ><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="callpatientsearch(this,'<%=facilityId%>',patient_id)" ><img name='mandatory' src='../../eCommon/images/mandatory.gif'></img></td> 	
		
	    </tr>	
   	   </table> 
       <%}%>  
	<input type=hidden name='mode' id='mode' value='<%=mode%>'>
	<input type=hidden name='menudis' id='menudis' value='<%=menudis%>'> 
			<input type=hidden name='error' id='error' value=''> 
	<input type=hidden name='external' id='external' value="<%=external%>"> 
	<input type=hidden name='register_no' id='register_no' value="<%=register_no%>"> <!--Added for this CRF Bru-HIMS-CRF-407 [IN:045167] -->
	</form>
	 </body>
<%
        if(pstmt!=null)  pstmt.close();
		if(rset!=null)  rset.close(); 
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


