<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/ProgressNotes.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
</head>


<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String encounter_id =  request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String appl_task_id =  request.getParameter("appl_task_id") == null ? "" : request.getParameter("appl_task_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
//String p_event_title=request.getParameter("p_event_title") == null ? "" : request.getParameter("p_event_title");
String new_cycle=request.getParameter("new_cycle") == null ? "" : request.getParameter("new_cycle");
String NewEvent=request.getParameter("NewEvent") == null ? "" : request.getParameter("NewEvent");
//String dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
//String sex=request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
String note_group = request.getParameter("note_group") == null ? "" : request.getParameter("note_group");
Connection con = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
ResultSet rs = null;
ResultSet rs1 = null;

String enc_specialty_code = "";
String sel = "";
String resp_id = (String)session.getValue("responsibility_id");
int cycle_no=Integer.parseInt(request.getParameter("p_cycle_no"));
String cycle_status=request.getParameter("cycle_status");

if(cycle_status.equals("C") || (new_cycle.equals("N") && !NewEvent.equals("NewEvent")))
cycle_no=cycle_no+1;

/*
StringBuffer SQL1 = new StringBuffer("SELECT a.SPLTY_EVENT_CODE,a.SPLTY_EVENT_DESC FROM CA_SPLTY_EVENT_LANG_VW a WHERE a.MODULE_ID=? AND a.LANGUAGE_ID=? AND a.EFF_STATUS='E' and (a.AGE_GROUP_CODE is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=a.AGE_GROUP_CODE AND   TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN         DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,?)=? )) ");
if(NewEvent.equals("NewEvent"))
	SQL1.append(" and SPLTY_EVENT_CODE in('MCE005','MCE006') and not exists (select 1 from CA_PAT_SPLTY_EPISODE_EVENT where patient_id=? and MODULE_ID=? and CYCLE_NO =? and SPLTY_EVENT_CODE = a.SPLTY_EVENT_CODE )");
SQL1.append(" ORDER BY 2");
*/
	
	String enc_spl_qry = " select f.SPECIALTY_CODE from pr_encounter F where f.ENCOUNTER_ID = ? ";
	
	String spl_qry     = " select SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) SHORT_DESC from  am_speciality where EFF_STATUS = 'E'  order by  SHORT_DESC ";

	StringBuffer prgNote_qry	= new StringBuffer("select NOTE_TYPE,CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) NOTE_TYPE_DESC from CA_NOTE_TYPE S where EFF_STATUS='E' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and s.NOTE_GROUP_ID in (select D.NOTE_GROUP from CA_NOTE_GROUP D  where d.APPL_TASK_ID= ? )  and NOTE_TYPE in (select NOTE_TYPE from CA_NOTE_TYPE_FOR_RESP A where A.RESP_ID = ?) ");

	if(called_from.equals("OH_TREATMENT"))
	{
		prgNote_qry.append(" and NOTE_GROUP_ID = ?");
	}


	
	
	
	try
	{
		con = ConnectionManager.getConnection(request);
	}
	catch(Exception e)
	{

		e.printStackTrace() ;
	}
%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<script language=javascript>
		document.body.style.scrollbarBaseColor='#E2E3F0';
		document.body.style.scrollbarArrowColor='#000080';
		document.body.style.scrollbarDarkShadowColor='#E2E3F0';
		document.body.style.scrollbarFaceColor='#E2E3F0';
		document.body.style.scrollbarHighlightColor='white';
		document.body.style.scrollbarShadowColor='#E2E3F0';
		document.body.style.scrollbar3dlightColor='#E2E3F0';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<FORM METHOD=POST ACTION="" name="matconsscycle" id="matconsscycle"  >
<!-- Below table width is modified by Archana Dhal on 4/28/2010 for IN020883. -->
	<TABLE width='100%' align='left' border=0 cellspacing=0>
		<BR><BR><BR>
		<TR>
			<td class='label'  WIDTH='20%' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
			<td class='field' width='30%'>
				<select name="speciality" id="speciality" onchange=''>
					<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
		
					
					try
					{
						pstmt = con.prepareStatement(enc_spl_qry);
						pstmt.setString(1,encounter_id);
						rs	= pstmt.executeQuery();
						while(rs.next())
						{
							enc_specialty_code=rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");

						}
						if(rs!=null)		rs.close();
						if(pstmt!=null) 	pstmt.close();

						pstmt1=con.prepareStatement(spl_qry);
						pstmt1.setString(1,locale);
						rs1	 =pstmt1.executeQuery();
						while(rs1.next())
						{
							if(rs1.getString(1).equals(enc_specialty_code))
							{
								sel ="selected";
							}
							else
							{
								sel ="";
							}
				
%>
							<option value='<%=rs1.getString(1)%>'<%=sel%>><%=rs1.getString(2)%></option>
<%						}
			
						if(rs1!=null) 		rs1.close();
						if(pstmt1!=null)	pstmt1.close();
		
					}	
					catch(Exception e)
					{
						e.printStackTrace() ;
				
					} 
%>
				</select></td>
				<td class='label'  WIDTH='20%' ><fmt:message key="eCA.ProgressNotes.label" bundle="${ca_labels}"/></td>
				<td class='field' width='30%'>
					<select name="ProgressNotes" id="ProgressNotes" onchange=''>
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
	
				try
				{
					pstmt1=con.prepareStatement(prgNote_qry.toString());  
					pstmt1.setString(1,locale);
					pstmt1.setString(2,patient_class);
					pstmt1.setString(3,appl_task_id);
					pstmt1.setString(4,resp_id);

					if(called_from.equals("OH_TREATMENT"))
					{
						pstmt1.setString(5,note_group);
					}

					rs1	 =pstmt1.executeQuery();
					while(rs1.next())
					{
%>
						<option value='<%=rs1.getString(1)%>'>&nbsp;&nbsp;<%=rs1.getString(2)%>&nbsp;</option>
<%					}
	
					if(rs1!=null) 		rs1.close();
					if(pstmt1!=null)	pstmt1.close();
	
				}	
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
				finally
				{
					try
					{
						if(con!= null) ConnectionManager.returnConnection(con,request);
					}
					catch(Exception e)
					{
						out.println("Exception in CAMainMenu.jsp"+e.toString());
					}
				}
%>
						</select>
						<input type="button" class="BUTTON" name="Record" id="Record" onclick='recordProgression()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")%>' ></td>

	<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
	<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type=hidden name='queryString' id='queryString' value='<%=queryString%>'>
	<input type=hidden name='splty_event_code' id='splty_event_code' value=''>
	<input type=hidden name='mode' id='mode' value=''>
	<input type=hidden name='progression_no' id='progression_no' value='<%=cycle_no%>'>
	<input type=hidden name='called_from' id='called_from' value='<%=called_from%>'>
	<input type=hidden name='NewEvent' id='NewEvent' value='<%=NewEvent%>'>
	</FORM>
</BODY>
</TABLE>
</html>

