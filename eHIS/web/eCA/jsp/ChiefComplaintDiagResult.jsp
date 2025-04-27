<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
 -->
 <jsp:useBean id="RecordDiagnosisBeannew" class="eCA.RecordDiagnosis" scope="session"/>

<%
	/*eCA.RecordDiagnosis RecordDiagnosisBean = (eCA.RecordDiagnosis)getObjectFromBean("RecordDiagnosisBean","eCA.RecordDiagnosis",session); */
   
%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- Added by Arvind @ 07-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/ChiefComplaintDiag.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con = null;
//PreparedStatement stmt_desc = null;
//ResultSet rs_desc = null;

PreparedStatement pstmtExisting = null;
ResultSet rsExisting = null;

//String sql_desc ="";
//String term_set_desc ="";
//String flag_vals ="";
 String diag_desc ="",diag_code="";
 String codedesc = "";
 String termid = "";
 String term_code_desc = "";
 

try
{
	con	= ConnectionManager.getConnection();
	String appendval = "";

	String complaint_id = request.getParameter("complaint_id");

	String code = request.getParameter("code");
	String flag = request.getParameter("flag");
	String desc = request.getParameter("description");
	
	String icd_code = request.getParameter("icd_code");
	String itermsetdesc = request.getParameter("itermsetdesc");
	//String iterm_id = request.getParameter("iterm_id");
	 
	String mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");

	//out.println("<script>alert('icd_code"+icd_code+"')</script>");
	
	String openmode = (request.getParameter("openmode")==null)?"":request.getParameter("openmode");
	
 
	if(mode.equals("insert")){
			RecordDiagnosisBeannew.clearAllRecord();
			String strSqlExisitingDiag = "select a.TERM_SET_ID TERM_SET_ID, b.TERM_CODE TERM_CODE,b.SHORT_DESC term_code_desc,a.term_set_desc SHORT_DESC FROM  MR_TERM_SET a,MR_TERM_CODE b,CA_CHIEF_COMP_TERM_CODE c WHERE c.complaint_id=? and b.term_set_id=c.term_set_id and c.term_code=b.term_code and a.EFF_STATUS='E' and a.term_set_id=b.term_set_id  ORDER BY 2 ";
		
			
			pstmtExisting = con.prepareStatement(strSqlExisitingDiag);
			pstmtExisting.setString(1,complaint_id);
			rsExisting = pstmtExisting.executeQuery();
			
			while(rsExisting.next()){
				termid    = (rsExisting.getString("TERM_SET_ID")==null)?"":rsExisting.getString("TERM_SET_ID");
				diag_code = (rsExisting.getString("TERM_CODE")==null)?"":rsExisting.getString("TERM_CODE");
				diag_desc = (rsExisting.getString("SHORT_DESC")==null)?"":rsExisting.getString("SHORT_DESC");
				term_code_desc = (rsExisting.getString("term_code_desc")==null)?"":rsExisting.getString("term_code_desc");
				
				//appendval = termid+"~"+diag_code+"~"+diag_desc;	
				appendval = term_code_desc+"~"+diag_code+"~"+termid+"~"+diag_desc;	
				RecordDiagnosisBeannew.addRecord(rsExisting.getString(2),appendval);
			}
	}

		if(code!= null)
		{
			if(flag.equals("true"))
			{
				codedesc = desc+"~"+icd_code+"~"+code+"~"+itermsetdesc;
				RecordDiagnosisBeannew.addRecord(icd_code,codedesc);
				//String beanval =(String)RecordDiagnosisBeannew.getRecord(code);
			}
			else if(flag.equals("false"))
			{
				 RecordDiagnosisBeannew.removeRecord(icd_code);
				//return rec;
			}

		}
%>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()"  onScroll='scrollTitle()' >
     <form name="ChiefComplaintDiagResultfrm" id="ChiefComplaintDiagResultfrm" action="../../servlet/eCA.ChiefComplaintDiagServlet" method="post" target="messageFrame">

 <div id='divDataTitle' style='postion:relative' >
 <table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >	
	<tr><td class='COLUMNHEADER' colspan='4'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/><!--( uncheck to exclude )--></td></tr>
	<tr >
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='10%' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> 
	</tr>	
 </table>
 </div>
	 <table class='grid' border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' >	
<!-- style='postion:relative' <table align='center' border="1" width="100%" id='dataTable' cellspacing='0' cellpadding='3' style="border-bottom:#ffffff"> -->
		
<%

ArrayList record = RecordDiagnosisBeannew.getAllRecord();
//out.println("<script>alert('sizein first"+record.size()+"')</script>");
String recordval = "",key = "",description= "",icd_code1="",iterm_id1="",itermdesc1="";
for(int i=0;i<record.size();i++)
{
	recordval =(String)record.get(i);
	StringTokenizer st = new StringTokenizer(recordval,"~");
	String classValue="",chkAttribute="checked";
	int chkCounter=0;
	while(st.hasMoreTokens())
	{
		key = st.nextToken();
		description = st.nextToken();
		icd_code1 = st.nextToken();
		iterm_id1 = st.nextToken();
		itermdesc1 = st.nextToken();

		if ( i % 2 == 0 )
			 classValue = "gridData" ;
        else
			 classValue = "gridData" ;	
		
		/*sql_desc="SELECT TERM_SET_desc term_set_desc FROM  MR_TERM_SET where term_set_id=?";
		 
		stmt_desc = con.prepareStatement(sql_desc);
		stmt_desc.setString(1,iterm_id1);
			
		rs_desc = stmt_desc.executeQuery();
			
		while(rs_desc.next())
		{
			term_set_desc = rs_desc.getString("term_set_desc");
			
		}
		if(rs_desc!=null) rs_desc.close();
		if(stmt_desc!=null) stmt_desc.close();*/
		

		out.println("<tr><td class='" + classValue + "'>"+itermdesc1+"</td>");
        out.println("<td class='" + classValue + "'>"+icd_code1+"</td>");
		out.println("<td class='" + classValue + "'>"+description+"</td>");
		out.println("<td class='"+classValue+"'><input type='checkbox'  "+chkAttribute +" name='diag_exists"+chkCounter+"' id='diag_exists"+chkCounter+"'  value='"+key+"' onClick='Reassaign(this,"+i+")'>");
		out.println("<input type='hidden'  name='clear"+key+"' id='clear"+key+"'  value='"+key+"' >");
		out.println("</td></tr>"); 
		chkCounter++;
	}
}
%>	
	<TR style='visibility:hidden'>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='10%' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> 
	</tr>
	</table>

<input type='hidden' name='complaint_id' id='complaint_id' value='<%=complaint_id%>'></input>
<input type='hidden' name='openmode' id='openmode' value='<%=openmode%>'></input>
</form>
</body>
<%	
		
	
		if(rsExisting!=null) rsExisting.close();
		if(pstmtExisting!=null) pstmtExisting.close();

		putObjectInBean("RecordDiagnosisBeannew",RecordDiagnosisBeannew,session);

	}
			catch(Exception e)
			{
				//out.println("Exception in try :"+e);////COMMON-ICN-0181
				e.printStackTrace();////COMMON-ICN-0181
			}
			finally
			{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
%>
</html>
<!--<script>alignWidth();</script> -->

