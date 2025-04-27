<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/DirectSalesPatient.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <script>
        function_id				=			"<%= request.getParameter( "function_id" ) %>"
    </script>
</head>

<body >
<%
		String mode				=			"";
		String bean_id			=			"";
		String bean_name		=			"";
		String patient_id		=			"";
		String patient_name		=			"";
		String eff_status		=			"";
		String CheckValue		=			"";
		String Disab			=			"";
		mode					=			request.getParameter( "mode" ) ;
		bean_id					=			"directSalesPatient" ;
		bean_name				=			"eST.DirectSalesPatientBean";
		String facility_id		=			(String)session.getValue("facility_id");	

	/* Mandatory checks end */

	if ( mode == null || mode.equals("") ) 
		return ;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	/* Initialize Function specific start */

	DirectSalesPatientBean bean =			(DirectSalesPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	//bean.setMode( mode ) ;

	/* Initialize Function specific end */
	ServletContext context		=			getServletConfig().getServletContext();

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

	if ( (mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ))){// || (mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )))
			//return;
			patient_id			=			request.getParameter("patient_id");
			patient_name		=			request.getParameter("patient_name");
			eff_status			=			request.getParameter("enabled");
			
			//bean.setPatientId(request.getParameter( "patient_id" ));
			if(eff_status.equals("E"))
		         {
					CheckValue	=			"checked";
          		}
				else
		          {
					CheckValue	=			"";
				  }
				
			Disab				=			"disabled";
	}
	
	else
	{
			Disab				=			"";
	}
	int pat_length				=		Integer.parseInt((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"));
		
%>


	<form name="DirectSalesPatientForm" id="DirectSalesPatientForm" onload="Status();" >
       
			<table border=0 cellspacing=0 cellpadding=0 height="15%" width="75%"  align="center" >			    
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<tr>
				
				    
					<td  class=label><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td class='fields'><input type=text name='patient_id' id='patient_id' size=20 maxLength='<%=pat_length%>' value="<%=patient_id%>" onKeyPress="return CheckForSpecChars(event)" <%=Disab%> onblur="searchPatientId1(patient_id);" >
					<input type="button" name="" id="" class="button"   onClick="return searchPatientId(patient_id);"  value='?'  <%=Disab%> ><img src="../../eCommon/images/mandatory.gif" align="center"></img></td></tr>
                <tr>
				      <td class=label><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td class='fields'><input type=text name='patient_name' id='patient_name' size=40 maxlength=300 value="<%=patient_name%>" disabled></td></tr>
				<tr>
				      <td class=label><fmt:message key="Common.Enable.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="E" <%=CheckValue%>></td></tr>
		 </table>
</center>
			<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden" name="locale" id="locale"						value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"					value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="facility_id" id="facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="SQL_ST_MP_PATIENT_LOOKUP" id="SQL_ST_MP_PATIENT_LOOKUP"	value="<%=bean.getStRepositoryValue("SQL_ST_MP_PATIENT_LOOKUP")%>">
			<input type="hidden" name="count" id="count">


<%
      putObjectInBean(bean_id,bean,request);
%>   
     </form>
          </body>
               </html>

