<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<style type="text/css">A:ACTIVE{COLOR:WHITE;}</style>
<script src='../../eCA/js/PatHighRisk.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
 Connection conn= null; //(Connection)session.getValue("connection");
// Statement stmt=null;
 PreparedStatement stmt=null;
 ResultSet rset=null;
 String facility_id		=	(String)session.getValue("facility_id");
 String practitioner_id =	(String) session.getValue("ca_practitioner_id");
 practitioner_id		=	(practitioner_id==null)	?	""	:	practitioner_id;
 String Encounter_Id = request.getParameter("Encounter_Id");
 if(Encounter_Id == null) Encounter_Id="0";	
 String Diag_groupcode="";
 String Diag_groupdesc="";
 String diagcode=request.getParameter("p_diag_code");
 String diagdesc=request.getParameter("p_diag_scheme_desc");
 String authorize=request.getParameter("p_auth_yn");
 String cause_indicator = request.getParameter("cause_indicator");
 String code_indicator = (request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");


	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
/*out.println("<script>alert('" + sex + "')</script>");
out.println("<script>alert('" + dob + "')</script>");
out.println("<script>alert('" + request.getQueryString() + "')</script>");*/



 if(diagcode == null)	diagcode  ="";
 if(diagdesc == null)	diagdesc  ="";
 if(authorize == null)	authorize  ="";
 if(cause_indicator == null)	cause_indicator  ="";



try
{

conn = ConnectionManager.getConnection(request);

/*   	String sql = "SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme=( select DIAG_CODE_SCHEME from mr_parameter)  and  (practitioner_id = ? or practitioner_id is null) AND (speciality_code is null or speciality_code IN  (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = nvl(?,practitioner_id) UNION SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?) )";
*/


StringBuffer sql =new StringBuffer();
if(sql.length() > 0) sql.delete(0,sql.length());
sql.append("SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme=( select DIAG_CODE_SCHEME from mr_parameter)  and  (practitioner_id = ? or practitioner_id is null) ");
if (!Encounter_Id.equals("0")) 
	sql.append(" AND (speciality_code is null or speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?)) ");
sql.append(" ORDER BY diag_group_desc ");


   stmt=conn.prepareStatement(sql.toString());
   stmt.setString(1,practitioner_id);
   if (!Encounter_Id.equals("0")) 
	{
	   stmt.setString(2,facility_id);
	   stmt.setString(3,Encounter_Id);
	}
   rset=stmt.executeQuery();

   rset.next();
%>
<table  border='1' cellspacing='0' cellpadding='3' id='tb1' align='center'>
<tr>
<%
String classValue="";
int rowCount = 1;

if (rset!=null)
{
do

{
		classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
		Diag_groupcode=rset.getString("diag_group_code");
		Diag_groupdesc=rset.getString("diag_group_desc");
		//class=\""+classValue+"\"
		  out.println("<tr id=\"tbl_row"+rowCount+"\" style='background-color:;'><td valign='top' class='"+classValue+"'>");
		  out.println("<li><a  href=\"CustomICDQueryFrames.jsp?Diag_code="+Diag_groupcode+"&Diag_desc="+java.net.URLEncoder.encode(Diag_groupdesc)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+java.net.URLEncoder.encode(diagdesc)+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"&Dob=" + dob + "&Sex=" + sex +"&code_indicator=" + code_indicator    + "\"   onClick=\"changeRowColor(tbl_row"+rowCount+")\" target='code_description'>");
		  out.println(Diag_groupdesc+"</a></td></tr>");
			rowCount++;
 }while (rset.next());
}
 
 
	if (rset!=null) rset.close();
	if (stmt!=null) stmt.close();
 }
     catch  (Exception e) {//out.print(e);
	 }

     finally
     {
		 if(conn!=null)ConnectionManager.returnConnection(conn,request);
     }

%>
</table>
</body>
</html>






