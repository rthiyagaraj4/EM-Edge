<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head><title><fmt:message key="Common.Printing.label" bundle="${common_labels}"/></title>

		<%
		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
		
		</head>
		<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "Print()">
		<form >
		
		<script Language="vbscript">
			Dim WSHShell
			Dim myHeader
			Dim myFooter
			Dim myMarginleft 
			Dim myMarginright 
			Set WSHShell = CreateObject("WScript.Shell")
			REM myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
			REM myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")
			REM myMarginleft = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left") 
			REM myMarginright = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right") 

			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"

	    </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			Connection con = null;
			con =  ConnectionManager.getConnection(request);
			PreparedStatement stmt=null;
			PreparedStatement fstmt=null;
			//PreparedStatement stHist=null;
			ResultSet rs=null;
			ResultSet frs=null;

			
			//String patient_id ="";
			String pline ="";
			//String encounter_id ="";
			String rsAdmission_date_time ="";
			String rsSpecialty_code ="";
			String rsSpecialty_desc ="";
			String rsLocation_code ="";
			String cons_status ="";
			String classValue ="";
			String nursing_unit_desc ="";
			String prenursing_unit_desc ="";
			//String checked ="";

			String cons_ref_id ="";
			String status ="";
			String practitionerId ="";
			String cons_date ="";
			String cons_time ="";
			String cons_list_desc ="";
			String practitioner_name ="";
			String facility_id = (String)session.getValue("facility_id");
			String facility_name="";
			StringBuffer existListQry = new StringBuffer();

			int i=0;
			int rowCnt=0;

			cons_ref_id			=	(request.getParameter("cons_ref_id")==null)	?	""	:	request.getParameter("cons_ref_id");
			status			=	(request.getParameter("status")==null)	?	""	:	request.getParameter("status");
			practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
			cons_date			=	(request.getParameter("cons_date")==null)	?	""	:	request.getParameter("cons_date");
			cons_time			=	(request.getParameter("cons_time")==null)	?	""	:	request.getParameter("cons_time");
			



		%>


		<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTableHdr" id="resultTableHdr" id="resultTableHdr">
		<tr>
		<td align='left' width='5%' rowspan="4">
		<img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'>
		</td>
		</tr>
		<!-- <tr>
			<th><fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></th>
			<th><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></th>
		</tr> -->
	
  <%
		fstmt=con.prepareStatement("select SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name from sm_facility_param where facility_id =?");
		fstmt.setString(1,locale);
		fstmt.setString(2,facility_id);
		frs=fstmt.executeQuery();
		while(frs.next())
		{
			facility_name = frs.getString("facility_name")==null?"":frs.getString("facility_name");
		}
		if(frs!=null) frs.close();
		if(fstmt!=null)fstmt.close();
		
		fstmt=con.prepareStatement("select am_get_desc.AM_PRACTITIONER(?,?,1) practitioner_name,a.CONS_LIST_DESC   from CA_CONS_LIST_HDR A where a.CONS_REF_ID =?");
		fstmt.setString(1,practitionerId);
		fstmt.setString(2,locale);
		fstmt.setString(3,cons_ref_id);
		frs=fstmt.executeQuery();
		while(frs.next())
		{
			practitioner_name = frs.getString("practitioner_name")==null?"":frs.getString("practitioner_name");
			cons_list_desc = frs.getString("CONS_LIST_DESC")==null?"":frs.getString("CONS_LIST_DESC");
		}
		if(frs!=null) frs.close();
		if(fstmt!=null)fstmt.close();


	%>
		<tr>
			<td colspan="3" align="center"><%=facility_name%></td>
		</tr> 
		<tr>
			<td colspan="3" align="center"><fmt:message key='eCA.ConsultationList.label' bundle='${ca_labels}'/></td>
		</tr> 
		<tr>
			<td colspan="3" align="center" class="label"></td>
		</tr> 
		<tr>
		</table>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTableHdr" id="resultTableHdr" id="resultTable2">
			<tr>
				<td width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<%=practitioner_name%></td><td width='25%'>&nbsp;&nbsp;&nbsp;</td>
				<td width='25%'><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;&nbsp;:&nbsp;<%=cons_date%>&nbsp;&nbsp;</td><td width='25%'><fmt:message key="Common.time.label" bundle="${common_labels}"/>&nbsp;&nbsp;:&nbsp;<%=cons_time%>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td width='35%' ><fmt:message key="eCA.ListReference.label" bundle="${ca_labels}"/>&nbsp;&nbsp;:&nbsp;<%=cons_list_desc%></td>
				<td colspan='3'>&nbsp;</td>
			</tr>
		</table>
		<table class="grid"  width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
			<th class="columnheadercenter"><fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></th>
			<th class="columnheadercenter"><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></th>
		</tr>
	<%
		existListQry.append( "select get_patient.get_line_detail(d.PATIENT_ID,?) Pline,to_char(e.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME,e.SPECIALTY_CODE,am_get_desc.AM_SPECIALITY(e.SPECIALTY_CODE,?,2) SPECIALTY_DESC,e.NURSING_UNIT_CODE,d.CONS_STATUS,IP_get_desc.IP_NURSING_UNIT(?,NURSING_UNIT_CODE,?,2) nursing_unit_desc from  CA_CONS_LIST_DTL d,IP_OPEN_ENCOUNTER e where d.CONS_REF_ID = ? and d.PATIENT_ID=e.PATIENT_ID and d.ENCOUNTER_ID =e.ENCOUNTER_ID and d.FACILITY_ID =e.FACILITY_ID");
		if(!status.equals("A"))
		{
		existListQry.append( " and d.CONS_STATUS = ?");
		}
		
		try
		{
			stmt = con.prepareStatement(existListQry.toString());
			stmt.setString(1,locale);
			stmt.setString(2,locale);
			stmt.setString(3,facility_id);
			stmt.setString(4,locale);
			stmt.setString(5,cons_ref_id);
			if(!status.equals("A"))
			{
				stmt.setString(6,status);
			}

			rs = stmt.executeQuery();

		while(rs.next())
		{
			/**if(i % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";	*/
			classValue = "gridData";

			rowCnt++;
			

						
			//patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
			//encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
			pline = rs.getString("Pline")==null?"":rs.getString("Pline");
			rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
			rsSpecialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
			rsSpecialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
			rsLocation_code = rs.getString("NURSING_UNIT_CODE")==null?"":rs.getString("NURSING_UNIT_CODE");
			cons_status = rs.getString("CONS_STATUS")==null?"":rs.getString("CONS_STATUS");
			nursing_unit_desc = rs.getString("nursing_unit_desc")==null?"":rs.getString("nursing_unit_desc");

			out.println("<tr>");
		//out.println("<td class='"+classValue+"'><input type='checkbox' onClick=\"\""+checked+" ></td>");
		if(!nursing_unit_desc.equals(prenursing_unit_desc))
		{
			out.println("<tr ><td colspan='5' class=CAFOURTHLEVELCOLOR><font size=1>" +nursing_unit_desc+ "</font></td></tr>");
		}
		
		out.println("<td class='"+classValue+"'>"+pline+"</td>");
		out.println("<td class='"+classValue+"'>"+rsAdmission_date_time+"</td>");
		out.println("</tr>");

		prenursing_unit_desc =nursing_unit_desc ;
		
		i++;
		}
		if(rs!=null) rs.close();
		if(frs!=null) frs.close();
		if(stmt!=null)stmt.close();	
		if(fstmt!=null)fstmt.close();	
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception caught in IPConsultationListPrint.jsp" + e);//COMMON-ICN-0181

		}
		finally 
		{
		
			ConnectionManager.returnConnection(con,request);
		}



 %>


	<script>
				function Print() 
				{
					
					//if (document.all) {
					if (typeof window.print === "function") {	
						//var i = 0;
						var res = confirm('Continue printing?');
						if(res)  
						{
							/*while( i < document.applets.length ) 
							{
								var j = 0 ;
								while ( !document.applets[i].isActive() && j++ <=75000 ) 
									window.status = i;
								i++;
							} */
							//parent.window.print();
							window.print();
						}
						else
						{
							//window.close();
							const dialogTag = parent.document.getElementById('dialog_tag');dialogTag.close();
						}
					}
				}
	</script>
	 </table>
	</form>
  </body>
</html>

