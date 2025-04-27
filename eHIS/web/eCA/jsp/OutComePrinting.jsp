<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
		<title><fmt:message key="eCA.RecMaternityconsPrinting.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script Language="vbscript">
    Dim WSHShell
    Dim myHeader
    Dim myFooter
    Dim myMarginleft 
    Dim myMarginright 
    Set WSHShell = CreateObject("WScript.Shell")
    myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
    myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")
    myMarginleft = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left") 
    myMarginright = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right") 

    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"

    Sub ResetHeader()
        Dim WSHShell
        Set WSHShell = CreateObject("WScript.Shell")
        WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", myHeader
        WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", myFooter
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", myMarginleft 
        WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", myMarginright 
    End Sub
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
		ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
</head>
<%
	   java.sql.Connection			con		=	null;
	   java.sql.PreparedStatement 	pstmt	=	null;
	   java.sql.ResultSet			rs		=	null;
    	con = ConnectionManager.getConnection(request);
	   String  site_name="";
	   String  facility_name="";
	   String  strNodesHeaderText="";
	   String  patient_id="";
	   String  patient_name="";
	   String  patient_gender="";
	   String  patient_age="";
	   String  encounter_id="";
	   String  episode_type="";
	   String  visit_adm_date="";
	   String  location_name="";
	   String  dischargeDateTime="";
	   String  speciality_name="";
	   String  attending_practitioner="";
	   String	printDateTime="";
	   String 	strQuery="";
	  // String login_user_id			= (String)session.getValue("login_user");
	   //String clinician_name			= (String)session.getValue("practitioner_name");
	   String facility_id				= (String)session.getValue("facility_id");
	   strNodesHeaderText	=	request.getParameter("outcomedesc")==null?"":request.getParameter("outcomedesc");
	   patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	   try
		{
			//strQuery = "SELECT site_name FROM SM_SITE_PARAM";
			strQuery = "SELECT 	site_name FROM 	SM_SITE_PARAM_LANG_VW where language_id = ?";
			pstmt	= con.prepareStatement(strQuery);
			pstmt.setString(1, locale);
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
				site_name = rs.getString(1);
			else
				site_name = "";
		}
		catch (Exception ePP1)
		{
			//out.println("Exception@147: "+ePP1);//COMMON-ICN-0181
			ePP1.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		try
			{
				//strQuery = "SELECT FACILITY_NAME,to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from sm_facility_param where facility_id = ?";
				strQuery = "SELECT 	SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name,to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time 	from 	dual";
				pstmt	= con.prepareStatement(strQuery);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locale);

				rs = pstmt.executeQuery();

				if(rs.next())
				{
					facility_name	=	rs.getString("facility_name");
					printDateTime	=	rs.getString("print_date_time");
				}
				else
				{
					facility_name = "";
					printDateTime =	"";
				}

			}
			catch (Exception ePP2)
			{
				out.println("Exception@147: "+ePP2);
				ePP2.printStackTrace();
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			
		try
			{
				
				strQuery	=" Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END LOCN_DESC,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   specialty_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,'2') attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME  FROM	PR_ENCOUNTER A 	WHERE A.FACILITY_ID=? and  patient_id=?";
				pstmt	= con.prepareStatement(strQuery);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,patient_id);

				rs = pstmt.executeQuery();

				if(rs.next() )
				{
					visit_adm_date			= rs.getString("ENC_DATE");
					episode_type			= rs.getString("patient_class");
					location_name			= rs.getString("LOCN_DESC");
					attending_practitioner	= rs.getString("attending_practitioner");
					speciality_name			= rs.getString("specialty_name");

					dischargeDateTime		= rs.getString("DISCHARGE_DATE_TIME");
					
				}
				  if(dischargeDateTime==null)
						dischargeDateTime="";
				if(location_name == null)
					location_name ="";
			}
			catch (Exception ePPA)
			{
				out.println("Exception@12: "+ePPA);
				ePPA.printStackTrace();
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}

			   try
			{
				
				strQuery	="SELECT CURR_ENCOUNTER_ID,PATIENT_NAME,sex,GET_AGE(date_of_birth) age FROM mp_patient WHERE patient_id=?";
				pstmt	= con.prepareStatement(strQuery);
				pstmt.setString(1,patient_id);

				rs = pstmt.executeQuery();

				if(rs.next() )
				{
					encounter_id			= rs.getString("CURR_ENCOUNTER_ID");
					patient_name			= rs.getString("PATIENT_NAME");
					patient_gender			= rs.getString("sex");
					if(patient_gender.equals("F"))
						patient_gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else
						patient_gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					patient_age	= rs.getString("age");
									
				}
				  
			}
			catch (Exception ePPA)
			{
				out.println("Exception@12: "+ePPA);
				ePPA.printStackTrace();
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}

%>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="Print()">
  <table border='0' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
			<tr>
					<td align='left' width='5%' rowspan='2' colspan ="2">
						<img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'>
					</td>
					<td  align=center colspan = "8"><h3><%=site_name%></h3>
					</td>
			</tr>
			<tr >
				
				<td align=center colspan ="8"><h3><%=facility_name%></h3></td>
			</tr>
			<tr>
				<td colspan ="2">&nbsp;</td>
				<td align=center colspan ="8"><h4><%=strNodesHeaderText%></h4></td>
			</tr>
			</table>
			<br>
				<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
			<tr>
			<td>
			<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>
			<tr>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2" align ="left"><font size='2'>:&nbsp;<%=patient_id%></font></td>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.name.label" bundle="${common_labels}"/></b></td>
					<td nowrap colspan = "2"><font size='2'>:&nbsp;<%=patient_name%></font></td>
			</tr>								
			<tr>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.gender.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2" align ="left"><font size='2'>:&nbsp;<%=patient_gender%></font></td>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.age.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2" align ="left"><font size='2'>:&nbsp;<%=patient_age%></font></td>
			</tr>
			<%
					if(!encounter_id.equals("0") )
					{
						%>
						<tr>
							<td nowrap colspan ="2" align ="left"><font size='2'><b><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></b></font></td>
							<td nowrap colspan ="2"><font size='2'>:&nbsp;<%=encounter_id%></font></td>
							<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></b></font></td>
							<td nowrap colspan ="1"><font size='2'>:&nbsp;<%=episode_type%></font></td>
							<td nowrap colspan ="1" align='right'><font size='2'>&nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></b></td>
							<td nowrap colspan ="4"><font size='2'>&nbsp;:<%=visit_adm_date%></font></td>
						</tr>
						<tr>
							<td nowrap colspan ="2" align ="left"><font size='2'><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>
							<td colspan='2' nowrap><font size='2'>:&nbsp;<%=location_name%></font></td>
							<td	 align='left' nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></b></font></td>
							<td colspan ="5"><font size='2'>:&nbsp;<%=dischargeDateTime.trim()%></font></td>
						</tr>
						<tr>
							<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>
							<td colspan='2' nowrap><font size='2'>:&nbsp;<%=speciality_name%></font></td>
							<td colspan='2'  align='left' nowrap><font size='2'><b><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></b></font></td>
							<td nowrap colspan ="5"><font size='2'>:&nbsp;<%=attending_practitioner%></font></td>
						</tr>
						<%
					}
					%>
			</td>
		</tr>
		</td>
		</tr>
		</table>
		</table>
<%

	
	String query_details		=	"";
	
	StringBuffer htmContent = new StringBuffer();
	String accession_num					="";
	accession_num	=	request.getParameter("accession_num")==null?"":request.getParameter("accession_num");


	try
	{
			query_details="select  HTM_CONTENT from CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM=?";
			pstmt		=	con.prepareStatement(query_details);
			pstmt.setString(1,accession_num);
			rs			=	pstmt.executeQuery();
			while(rs.next())
			{
				Clob HTM_CONTENT = (Clob) rs.getClob("HTM_CONTENT");
				if(HTM_CONTENT !=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(HTM_CONTENT.getCharacterStream());
					String line = null;

					while((line=r.readLine()) != null) 
					{
						htmContent.append(line);
					}
				}
				
			 }	
		
	}
	catch(Exception e)
	{
		//out.println("Exception @ RecMaternityConsView.jsp"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
   <%=htmContent.toString()%>
 <script>
				function Print() 
				{
					if (document.all) {
						var i = 0;
						var res = confirm('Continue printing?');
						if(res)  
						{
							while( i < document.applets.length ) 
							{
								var j = 0 ;
								while ( !document.applets[i].isActive() && j++ <=75000 ) 
									window.status = i;
								i++;
							}
							window.print();
						}
						window.close();
					}
				}
			</script>



</body>
</html>

