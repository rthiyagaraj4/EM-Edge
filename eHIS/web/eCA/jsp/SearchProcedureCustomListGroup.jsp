<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.util.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCA/js/ProcedureList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style type="text/css">A:ACTIVE{COLOR:WHITE;}</style>
</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection conn= null;
	PreparedStatement stmt=null;
 ResultSet rset=null;

 String facility_id		=	(String)session.getValue("facility_id");
 String practitioner_id =	(String) session.getValue("ca_practitioner_id");
 practitioner_id		=	(practitioner_id==null)	?	""	:	practitioner_id;
 String Encounter_Id = request.getParameter("Encounter_Id");
 if(Encounter_Id == null) Encounter_Id="0";	
 String Diag_groupcode="";
 String Diag_groupdesc="";
 String diagcode=request.getParameter("p_code");
 String diagdesc=request.getParameter("p_desc");
 String cause_indicator=request.getParameter("cause_indicator");

 if(diagcode == null)	diagcode  ="";
 if(diagdesc == null)	diagdesc  ="";
 if(cause_indicator == null)	cause_indicator  ="";

try
{
	conn = ConnectionManager.getConnection(request);
	/* *** commented for internationalization*** 
	String sql="SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE  GROUP_TYPE='P' and diag_code_scheme=( select PROC_CODE_SCHEME from mr_parameter where rownum=1) and  (practitioner_id = ? or practitioner_id is null) and (speciality_code is null or speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?))"; */
  //String sql="SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE  GROUP_TYPE='P' and diag_code_scheme=4 and  (practitioner_id = ? or practitioner_id is null) and (speciality_code is null or speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?))"; 
    String sql="SELECT diag_group_code, MR_GET_DESC.MR_DIAG_GROUP('P',diag_group_code,?,'1') diag_group_desc FROM mr_diag_group WHERE  diag_code_scheme=( select PROC_CODE_SCHEME from mr_parameter where rownum=1) and  (practitioner_id = ? or practitioner_id is null) and (speciality_code is null or speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?))";
	stmt=conn.prepareStatement(sql);
	stmt.setString(1,locale);
	stmt.setString(2,practitioner_id);
	stmt.setString(3,facility_id);
	stmt.setString(4,Encounter_Id);
	rset=stmt.executeQuery();
    %>
<table  border='1' cellspacing='0' cellpadding='3' id='tb1'>
<tr>
<%
String  classValue="";
int rowCount = 1;
if (rset!=null)
{
	while (rset.next()) {
	 	classValue	=((rowCount%2)==0)?"QRYEVEN":	"QRYODD";
		Diag_groupcode=rset.getString("diag_group_code");
		Diag_groupdesc=rset.getString("diag_group_desc");
		  out.println("<tr id=\"tbl_row"+rowCount+"\" style='background-color:;'><td valign='top' class='"+classValue+"'>");
          out.println("<li><a  href=\"SearchProcedureCustomListResult.jsp?Diag_code="+Diag_groupcode+"&Diag_desc="+java.net.URLEncoder.encode(Diag_groupdesc)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+java.net.URLEncoder.encode(diagdesc)+
			  "&cause_indicator="+cause_indicator+"\"onClick=\"changeRowColor(tbl_row"+rowCount+")\" target='code_description'>");
		  out.println(Diag_groupdesc+"</a></td></tr>");
			rowCount++;


    }//while
  } //if

	if (rset!=null) rset.close();
	if (stmt!=null) stmt.close();

} //try
catch(Exception e) {
	//out.println("Exception="+e.toString());//COMMON-ICN-0181
     e.printStackTrace();//COMMON-ICN-0181
 }

   finally
     {
		 if(conn!=null)ConnectionManager.returnConnection(conn,request);
     }

%>

</body>
</html>

