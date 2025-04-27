<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/BuildMARRules.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%

		String facility_id  		= (String)session.getValue("facility_id");
		String pat_class			= request.getParameter("app_pat_class");
		String location				= request.getParameter("location");
		String priority				= request.getParameter("priority");
		String form_code			= request.getParameter("form_code");
		String form_desc			= request.getParameter("form_desc");
		String mar_defaulting		= request.getParameter("mar_defaulting");
		String mode					= request.getParameter("mode");
		String bean_id				= "BuildMARRules" ;
		String bean_name			= "ePH.BuildMARRules";
		BuildMARRules bean 			= (BuildMARRules)getBeanObject( bean_id, bean_name, request ) ;

		boolean searched			= request.getParameter( "searched" ) == null ? false : true ;
		String ord[]				= request.getParameterValues("orderbycolumns");

	try {
	
		String classvalue	= "";
		facility_id 	= CommonBean.checkForNull( facility_id );
		pat_class 		= CommonBean.checkForNull( pat_class );
		location		= CommonBean.checkForNull( location );
		priority		= CommonBean.checkForNull( priority );
		form_code			= CommonBean.checkForNull( form_code );
		mar_defaulting	= CommonBean.checkForNull( mar_defaulting );
		
		if(pat_class.trim().toUpperCase().equals("OUTPATIENT") || pat_class.trim().toUpperCase().equals("OUT PATIENT") || pat_class.trim().toUpperCase().equals("OP"))
		{
			pat_class="OP";
		}
		else if(pat_class.trim().toUpperCase().equals("INPATIENT") || pat_class.trim().toUpperCase().equals("IN PATIENT") || pat_class.trim().toUpperCase().equals("IP"))
		{
			pat_class="IP";
		}
		else if(pat_class.trim().toUpperCase().equals("DAYCARE") || pat_class.trim().toUpperCase().equals("DAY CARE") || pat_class.trim().toUpperCase().equals("DC"))
		{
			pat_class="DC";
		}
		else if(pat_class.trim().toUpperCase().equals("EMERGENCY") || pat_class.trim().toUpperCase().equals("EM"))
		{
			pat_class="EM";
		}
		else if(pat_class.trim().toUpperCase().equals("DISCHARGE MEDICATION") || pat_class.trim().toUpperCase().equals("DISCHARGEMEDICATION") || pat_class.trim().toUpperCase().equals("DM"))
		{
			pat_class="DM";
		}
		
		if(priority.trim().equals(MessageManager.getLabel(locale,"Common.all.label","Common")))
		{
			priority="A";
		}
		else if(priority.trim().equals(MessageManager.getLabel(locale,"Common.routine.label","Common")) || priority.trim().toUpperCase().equals("R"))
		{
			priority="R";
		}
		else if(priority.trim().equals(MessageManager.getLabel(locale,"Common.urgent.label","Common")) || priority.trim().toUpperCase().equals("U"))
		{
			priority="U";
		}
		
		if(location.trim().toUpperCase().equals("*A"))
		{
			location=MessageManager.getLabel(locale,"Common.AllLocations.label","Common");
		}
		else
		{
			location=bean.getDesc(form_code,locale,"Location",facility_id,pat_class);
		}
		
		if(form_code.trim().toUpperCase().equals("*A"))
		{
			form_desc=MessageManager.getLabel(locale,"ePH.AllForms.label","PH");
		}
		else
		{
			form_desc=bean.getDesc(form_code,locale,"Form",facility_id,pat_class);
		}

		//Common parameters.
		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_BUILD_MAR_RULE_QUERY_RESULT" ) );

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "PATIENT_CLASS" );
		displayFields.add( "LOC_DESC" );
		displayFields.add( "FORM_DESC" );
		displayFields.add( "PRIORITY" );
		displayFields.add( "BUILD_MAR_INDICATOR" );
		displayFields.add( "FORM_CODE" );
		displayFields.add( "SOURCE_CODE" );

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(session.getValue( "facility_id" ));
		chkFields.add( locale );
		chkFields.add( locale );
		chkFields.add( "%"+location +"%");
		chkFields.add( "%"+form_code +"%");
		chkFields.add( "%"+form_desc +"%");
		chkFields.add( mar_defaulting );
		chkFields.add( mar_defaulting );
		chkFields.add( pat_class );
		chkFields.add( pat_class );
		chkFields.add( priority );
		chkFields.add( priority );

	// Adding function parameters related array list into the HashMap
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if( result.size() >= 3 && ( !( ( (String)result.get(0)).equals("0")) )) {
%>

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" ALIGN="center">
		<TR>
			<TD WIDTH="80%" CLASS="white">&nbsp;</TD>
			<TD WIDTH="20%" CLASS="white">&nbsp;

<%
			// For display the previous/next link
			
			out.println( result.get(1) );
%>

			</TD>
		</TR>
		</TABLE>

		<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" style="margin-left:40px;">
		<TR>
			<TH WRAP  WIDTH="15%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></TH>
			<TH WRAP  WIDTH="25%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TH>
			<TH WRAP  WIDTH="25%"><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></TH>
			<TH WRAP  WIDTH="15%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></TH>
			<TH WRAP  WIDTH="15%"><fmt:message key="ePH.MARDefaulting.label" bundle="${ph_labels}"/></TH>
		</TR>
		

<%
			//Retriving the records from result arraylist
			ArrayList records = new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
			
%>

			<TR onClick="Modify(this);" >

<%
				String link_columns = "1";

				records = (ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++) {

				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ) {
				
					String pat_class_value=(String)records.get( colCount );
					if (pat_class_value.toUpperCase().equals("IP"))
							pat_class_value=MessageManager.getLabel(locale,"Common.inpatient.label","Common");
						else if(pat_class_value.toUpperCase().equals("OP"))	
							pat_class_value=MessageManager.getLabel(locale,"Common.Outpatient.label","Common");
						else if(pat_class_value.toUpperCase().equals("DC"))	
							pat_class_value=MessageManager.getLabel(locale,"Common.daycare.label","Common");
						else if(pat_class_value.toUpperCase().equals("EM"))	
							pat_class_value=MessageManager.getLabel(locale,"Common.emergency.label","Common");
						else if(pat_class_value.toUpperCase().equals("DM"))	
							pat_class_value=MessageManager.getLabel(locale,"Common.DischargeMedication.label","Common");
						
					
%>
				<TD CLASS="<%=classvalue%>" onMouseover="changeCursor(this);" ><FONT CLASS='HYPERLINK'>  <%=pat_class_value%> </FONT></TD>
				
<%
					}
					
				else if(!(colCount==5 || colCount==6)){
					String fieldValue=((String)records.get( colCount ));
					
					if (fieldValue==null) fieldValue = "";
					
					if(colCount==1){
						if (fieldValue.equals("ALL"))
							fieldValue=MessageManager.getLabel(locale,"Common.AllLocations.label","Common");
					}
					else if(colCount==2){
						if (fieldValue.toUpperCase().equals("ALL"))
							fieldValue=MessageManager.getLabel(locale,"ePH.AllForms.label","PH");
					}
					else if(colCount==3){
						if (fieldValue.toUpperCase().equals("R"))
							fieldValue=MessageManager.getLabel(locale,"Common.routine.label","Common");
						else if(fieldValue.toUpperCase().equals("U"))	
							fieldValue=MessageManager.getLabel(locale,"Common.urgent.label","Common");
						else
							fieldValue=MessageManager.getLabel(locale,"Common.all.label","Common");
					}
					else if(colCount==4){
						if (fieldValue.toUpperCase().equals("CE"))
							fieldValue=MessageManager.getLabel(locale,"ePH.Checked.label","PH");
						else if(fieldValue.toUpperCase().equals("UE"))	
							fieldValue=MessageManager.getLabel(locale,"ePH.UnChecked.label","PH");
						else if(fieldValue.toUpperCase().equals("CD"))	
							fieldValue=MessageManager.getLabel(locale,"ePH.CheckedDisabled.label","PH");
						else if(fieldValue.toUpperCase().equals("UD"))	
							fieldValue=MessageManager.getLabel(locale,"ePH.UnCheckedDisabled.label","PH");
					}
					String dkVal =fieldValue ;
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
	%>

	<td class="<%=classvalue%>" align="left" onclick="disableClick(event); "><%=dkVal%></td>
	<%
				}
				else 
				{
	%>
				<td  align="left" style="visibility:hidden" onclick="disableClick(event); "> <%=(String)records.get( colCount )%> </td>
	<%		
				}
			}
%>
			</TR>
<%
			}
%>
		</TABLE>
<%
			out.flush();
		}
		else {
%>
		<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>
<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/BuildMARRulesQueryResult.jsp", searched ) );
	}
	catch(Exception e) {
		out.print("Exception in Query Result JSP :"+e.toString());
	}
%>

</BODY>
</HTML>

