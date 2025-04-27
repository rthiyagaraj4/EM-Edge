<!DOCTYPE html>
<% 
/*
-----------------------------------------------------------------------
Date       		Edit History     	Name        		Description
-----------------------------------------------------------------------
25/01/2013    	 IN037196			Ramesh Kannnan S 	Alpha-CA-Record Procedures-Modified details are not displayed .
20/01/2012		CHL-CRF [IN035950]	Ramesh G			CHL-CRF [IN035950]
10/03/2022        36285            Hariharan k       	 MMs-DM-CRF-0221.v1.0(003)
-----------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
	<head>
	<script>
	function alignWidth(){
	var totalRows =  document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = document.getElementById("dataTitleTable").rows[1].cells.length;
	
	for(var i=0;i<temp;i++) {
		document.getElementById("dataTitleTable").rows[1].cells[i].width=document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
}
</script>
<% 	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
		String Patient_Id        = request.getParameter("Patient_Id");
		String Encounter_Id      = request.getParameter("Encounter_Id");				
		String operating_facility_id=(String) session.getValue("facility_id");
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		//String locale=(String)session.getValue( "LOCALE" ) ;
		String procedure="";
		String code="";
		String scheme="";
		String classifition_type="";//36285
		String date="";
		String practitioner="";
		String classValue="";
		String srl_no="";
		String term_set_id="";
		String status = "";
		String curr_status = "";
		String encounter_id = "";
		String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
		String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
		String facility_id		= (String) session.getValue("facility_id");// 36285 
		String bean_id 						= "@ProceduresBean";// 36285 
		String bean_name 					= "eCA.ProceduresBean";// 36285 
		ProceduresBean bean					= (ProceduresBean)getBeanObject( bean_id, bean_name, request ) ;// 36285 
		String  enablePriSecProc = bean.getProceduresData(facility_id);// 36285 
		
		int k=1;
		
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @04-12-2008> -->

	 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/procedures.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollTitle()'>
	<form name='query_form' id='query_form'>
	<div id='divDataTitle' style='postion:relative'>
			<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
			<tr><th class='columnheader' colspan='8' align="left"><font size=1><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> <fmt:message key="Common.History.label" bundle="${common_labels}"/></font></th></tr>
			<tr align="left">
					<th class='columnheadercenter'><font size=1><fmt:message key="Common.ProcedureDescription.label" bundle="${common_labels}"/></font></th>
					<th class='columnheadercenter'><font size=1><fmt:message key="Common.code.label" bundle="${common_labels}"/></font></th>
					<th class='columnheadercenter'><font size=1><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></font></th>
					<!-- 36285  -->
				     <%
			      if(enablePriSecProc.equals("Y")) {  %> 
		             <th class='columnheadercenter'><fmt:message key="eCA.ClassificationType.label" bundle="${ca_labels}"/></th>
					<% } %> 
					<!-- 36285  -->
					<th class='columnheadercenter'><font size=1><fmt:message key="Common.date.label" bundle="${common_labels}"/></font></th>
					<th class='columnheadercenter'><font size=1><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></font></th>
					<th class='columnheadercenter'><font size=1><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></th>
					<th class='columnheadercenter'><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></th>
					
			</tr>
			</table>
	</div>

	<table class ='grid' border='1' width='100%' id='dataTable'  >
	<%
	try
	{
		String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
        con=ConnectionManager.getConnection(request);
        
        
		try
	    {
	//	    String sql="Select a.proc_narration,a.proc_code,decode(a.proc_code_scheme,'3','CPT 4','4','ICD 9CM','6','ICD10-PCS') scheme,  to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name, PATIENT_ID,proc_date dummydate, a.srl_no srl_no from pr_encounter_procedure a, am_practitioner b where a.facility_id = ? and a.PATIENT_ID = ? and b.practitioner_id=a.practitioner_id and nvl(error_yn,'N')='N' order by dummydate desc ";
		   // String sql="Select a.proc_narration,a.proc_code,c.Term_Set_Desc  scheme,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name, PATIENT_ID,proc_date dummydate, a.srl_no srl_no,c.term_set_id term_set_id  from pr_encounter_procedure a, am_practitioner b ,mr_term_set  c where a.facility_id = ? and a.PATIENT_ID = ? and a.PROC_CODE_SCHEME = c.TERM_SET_ID and b.practitioner_id=a.practitioner_id and nvl(error_yn,'N')='N' order by dummydate desc ";
			String sql="Select rtrim(a.proc_code), (select SHORT_DESC from mr_term_code where TERM_CODE = rtrim(a.proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME) proc_narration,c.Term_Set_Desc  scheme,CLASSIFITION_TYPE,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') practitioner_name, PATIENT_ID,proc_date dummydate, a.srl_no srl_no,c.term_set_id term_set_id, a.CURR_STATUS curr_status, a.encounter_id  from pr_encounter_procedure a, mr_term_set  c where a.facility_id = ? and a.PATIENT_ID = ? and a.PROC_CODE_SCHEME = c.TERM_SET_ID  and nvl(error_yn,'N')='N' order by dummydate desc";//36285

			stmt = con.prepareStatement(sql);
			stmt.setString(1, locale);
			stmt.setString(2, operating_facility_id);
			stmt.setString(3, Patient_Id);
			rs = stmt.executeQuery();

			if (!rs.next()) 
			{
				for (int x=0; x<1 ; x++)
				{
					if ( k%2 == 0 )
					classValue = "QRYEVEN" ;
					else
					classValue = "QRYODD" ;

					out.println("<tr><td class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td></tr>");
					k++;
				}
			}else{
				do{
						if ( k%2 == 0 )
								classValue = "QRYEVEN" ;
						else
								classValue = "QRYODD" ;
						code			= (rs.getString(1)==null) ? "&nbsp;" : rs.getString(1);
						procedure       = (rs.getString(2)==null) ? "&nbsp;" : rs.getString(2);
						scheme          = (rs.getString(3)==null) ? "&nbsp;" : rs.getString(3);
						classifition_type=(rs.getString(4)==null) ? "&nbsp;" : rs.getString(4);//36285
						date            = (rs.getString(5)==null) ? "&nbsp;" : rs.getString(5);
				
						if(!date.equals("&nbsp;"))
							date =com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale);
						practitioner    = (rs.getString(6)==null)?"&nbsp;":rs.getString(6);
						srl_no			= (rs.getString("srl_no")==null)?"&nbsp;":rs.getString("srl_no");
						term_set_id		= (rs.getString("term_set_id")==null)?"&nbsp;":rs.getString("term_set_id");
						curr_status		= (rs.getString("curr_status")==null) ? "R" : rs.getString("curr_status");
						encounter_id		= (rs.getString("encounter_id")==null) ? "&nbsp;" : rs.getString("encounter_id");
						// start 36285
						if(classifition_type.equals("P")){
							classifition_type="Primary(PPX)";
						}
						else if(classifition_type.equals("S")){
						
						  classifition_type="Secondary(SPX)";
						}
						//end 36285

						if(curr_status.equals("R"))
							status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Recorded.label","ca_labels");
						else if(curr_status.equals("M"))
							status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
						//36285 start
						 if(enablePriSecProc.equals("N")) { 
							 if(modal_yn.equals("Y")&&!called_from.equals("MR")){
								  out.println("<tr><td class='gridData' width='18%'>"+procedure+"</td><td class='gridData' width='14%'>&nbsp;"+code+"</td><td class='gridData' width='15%'>&nbsp;"+scheme+"</td><td class='gridData' width='15%' >"+date+"&nbsp;</td><td class='gridData' width='15%' >"+date+"&nbsp;</td><td class='gridData'width='16%'>"+practitioner+"</td><td class='gridData'width='12%'>"+status+"</td><td class='gridData' width='12%'>&nbsp;</td></tr>");
							  }else{
								  out.println("<tr><td class='gridData' width='18%'><a class='gridLink'  href=\"javascript:callDetails('"+code+"', '"+Patient_Id+"', '"+srl_no+"','"+term_set_id+"','"+encounter_id+"')\">"+procedure+"</a></td><td class='gridData' width='15%'>&nbsp;"+code+"</td><td class='gridData' width='15%'>"+scheme+"</td><td class='gridData' width='15%' nowrap>"+date+"</td><td class='gridData'width='16%'>"+practitioner+"</td><td class='gridData'width='12%'>"+status+"</td>");
							}
							 if(curr_status.equals("R"))
									out.println("<td class='gridData' width='10%'>&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;</td></tr>"); 
								else if(curr_status.equals("M"))
									
									//out.println("<td class='gridData' width='10%'><a class='gridLink'  href=\"javascript:callAudit("+srl_no+")\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ViewDetails.label","common_labels")+"</a></td></tr>");
									out.println("<td class='gridData' width='10%'><a class='gridLink'  href=\"javascript:callAudit("+srl_no+","+encounter_id+")\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ViewDetails.label","common_labels")+"</a></td></tr>"); //IN037196
						}
					 if(enablePriSecProc.equals("Y")) { 
						if(modal_yn.equals("Y")&&!called_from.equals("MR")){
							out.println("<tr><td class='gridData' width='15%'>"+procedure+"</td><td class='gridData' width='11%'>&nbsp;"+code+"</td><td class='gridData' width='12%'>&nbsp;"+scheme+"</td><td class='gridData' width='12%' >"+classifition_type+"&nbsp;</td><td class='gridData' width='12%' >"+date+"&nbsp;</td><td class='gridData' width='12%' >"+date+"&nbsp;</td><td class='gridData'width='15%'>"+practitioner+"</td><td class='gridData'width='12%'>"+status+"</td><td class='gridData' width='10%'>&nbsp;</td></tr>");
						}else{
							out.println("<tr><td class='gridData' width='15%'><a class='gridLink'  href=\"javascript:callDetails('"+code+"', '"+Patient_Id+"', '"+srl_no+"','"+term_set_id+"','"+encounter_id+"')\">"+procedure+"</a></td><td class='gridData' width='11%'>&nbsp;"+code+"</td><td class='gridData' width='12%'>"+scheme+"</td><td class='gridData' width='12%' >"+classifition_type+"&nbsp;</td><td class='gridData' width='12%' nowrap>"+date+"</td><td class='gridData'width='15%'>"+practitioner+"</td><td class='gridData'width='12%'>"+status+"</td>");
						}
						//36285
							if(curr_status.equals("R"))
								out.println("<td class='gridData' width='10%'>&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;</td></tr>"); 
							else if(curr_status.equals("M"))
								//out.println("<td class='gridData' width='10%'><a class='gridLink'  href=\"javascript:callAudit("+srl_no+")\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ViewDetails.label","common_labels")+"</a></td></tr>");
								out.println("<td class='gridData' width='10%'><a class='gridLink'  href=\"javascript:callAudit("+srl_no+","+encounter_id+")\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ViewDetails.label","common_labels")+"</a></td></tr>"); //IN037196
						}
						k++;
					} while  (rs.next());
			}
		
			if(rs!=null)    rs.close();
			if(stmt!=null)  stmt.close();
		}catch(Exception e){out.print("ERROR"+e);}
		
%>
</table>
</div>
	<input type='hidden' name='qryStr' id='qryStr' value="<%=request.getQueryString()%>" >
	<input type='hidden' name='Patient_Id' id='Patient_Id' value="<%=Patient_Id%>" >
	<input type='hidden' name='Encounter_Id' id='Encounter_Id' value="<%=Encounter_Id%>" >
	<input type='hidden' name='facility_id' id='facility_id' value="<%=operating_facility_id%>" >
	<input type='hidden' name='modal_yn' id='modal_yn' value="<%=modal_yn%>" >
	<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value="<%=p_called_from_widget%>" ><!--CHL-CRF [IN035950]-->
</form>
</body>
</html>
<%
}
catch(Exception e){out.println(e);}
finally
{
   if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
 <script>setTimeout('alignWidth()',500);</script> 

