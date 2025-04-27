<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
</head>


<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String p_event_title=request.getParameter("p_event_title") == null ? "" : request.getParameter("p_event_title");
String new_cycle=request.getParameter("new_cycle") == null ? "" : request.getParameter("new_cycle");
String NewEvent=request.getParameter("NewEvent") == null ? "" : request.getParameter("NewEvent");
String dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
String sex=request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
Connection con = null;
PreparedStatement pstmt1 = null;
ResultSet rs1 = null;
int cycle_no=Integer.parseInt(request.getParameter("p_cycle_no"));
String cycle_status=request.getParameter("cycle_status");

if(cycle_status.equals("C") || (new_cycle.equals("N") && !NewEvent.equals("NewEvent")))
cycle_no=cycle_no+1;

StringBuffer SQL1= new StringBuffer("SELECT a.SPLTY_EVENT_CODE,a.SPLTY_EVENT_DESC FROM CA_SPLTY_EVENT_LANG_VW a WHERE a.MODULE_ID=? AND a.LANGUAGE_ID=? AND a.EFF_STATUS='E' and (a.AGE_GROUP_CODE is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=a.AGE_GROUP_CODE AND   TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN         DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,?)=? )) ");
if(NewEvent.equals("NewEvent"))
	SQL1.append(" and SPLTY_EVENT_CODE in('MCE005','MCE006') and not exists (select 1 from CA_PAT_SPLTY_EPISODE_EVENT where patient_id=? and MODULE_ID=? and CYCLE_NO =? and SPLTY_EVENT_CODE = a.SPLTY_EVENT_CODE )");
SQL1.append(" ORDER BY 2");
try{
con = ConnectionManager.getConnection(request);
}catch(Exception e){
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


<FORM METHOD=POST ACTION="" name="matconsscycle" id="matconsscycle">
<TABLE width='50%' align='left' border=0 cellspacing=0>
<TR>
	<TD></TD><TD class='label'  WIDTH='25%' colspan='2'><b><fmt:message key="Common.open.label" bundle="${common_labels}"/> <%=p_event_title%></b></TD>
	<TD class='field' width='50%'><select name="event_select" id="event_select" onchange='enableGoButton(this);'>
	<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
	

<%try{

	pstmt1=con.prepareStatement(SQL1.toString());
	pstmt1.setString(1,module_id);
	pstmt1.setString(2,locale);
	pstmt1.setString(3,dob);
	pstmt1.setString(4,sex);
	pstmt1.setString(5,sex);
	if(NewEvent.equals("NewEvent"))
	{
		pstmt1.setString(6,patient_id);
		pstmt1.setString(7,module_id);
		pstmt1.setInt(8,cycle_no);
	}
	rs1	 =pstmt1.executeQuery();
	while(rs1.next()){%>
	<option value='<%=rs1.getString(1)%>'><%=rs1.getString(2)%></option>
	<%}
	if(rs1!=null)
		rs1.close();
	if(pstmt1!=null)
		pstmt1.close();//recordevent()
	%>
	<input type="button" class="BUTTON" name="Record" id="Record" onclick='chk_event_status()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")%>' disabled></TD></TR>
	<%
}catch(Exception e){
	e.printStackTrace() ;
	
}finally
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
<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type=hidden name='queryString' id='queryString' value='<%=queryString%>'>
<input type=hidden name='splty_event_code' id='splty_event_code' value=''>
<input type=hidden name='mode' id='mode' value=''>
<input type=hidden name='cycle_no' id='cycle_no' value='<%=cycle_no%>'>
<input type=hidden name='NewEvent' id='NewEvent' value='<%=NewEvent%>'>
</FORM>
</BODY>
</TABLE>
</html>

