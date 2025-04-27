<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
String locale			= (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con = null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String clearAll="";
String clearOne="";
//This file is saved on 18/10/2005.
try
{
String patient_class=request.getParameter("patient_class");
if(patient_class == null) patient_class="";
clearAll = request.getParameter("clearAll");
if(clearAll == null) clearAll="";
clearOne = request.getParameter("clearOne");
if(clearOne == null) clearOne="";
RecordSet	InterventionPatient	=	null;
InterventionPatient	=	(webbeans.eCommon.RecordSet)	session.getAttribute("InterventionPatient");
if(clearAll.equals("clearAll"))
{
InterventionPatient.clearAll();
}
else if(clearAll.equals("notCleared"))
{
InterventionPatient.clearAll();

con = ConnectionManager.getConnection(request);
//String sql="select intervention_code,'I' db_action from ca_intervention where intervention_code not in (select intervention_code from ca_pat_class_intervention where patient_class =?) and eff_status = 'E' union all select a.intervention_code, 'U' db_action from ca_pat_class_intervention a, ca_intervention b where a.patient_class = ? and b.intervention_code  = a.intervention_code order by 2";
String sql="SELECT intervention_code,'I' db_action FROM ca_intervention_lang_vw WHERE intervention_code NOT IN (SELECT intervention_code FROM ca_pat_class_intervention WHERE patient_class =?) AND eff_status = 'E' AND language_id = ? UNION ALL SELECT a.intervention_code, 'U' db_action FROM ca_pat_class_intervention a, ca_intervention_lang_vw b WHERE a.patient_class = ? AND b.intervention_code  = a.intervention_code AND b.language_id = ? ORDER BY 2";
pstmt=con.prepareStatement(sql);
pstmt.setString(1,patient_class);
pstmt.setString(2,locale);
pstmt.setString(3,patient_class);
pstmt.setString(4,locale);
rs=pstmt.executeQuery();
while(rs.next())
{
InterventionPatient.putObject(rs.getString(1));
}

}
if(!clearOne.equals(""))
{

	if(InterventionPatient.containsObject(clearOne))
	{
		InterventionPatient.removeObject(InterventionPatient.indexOfObject(clearOne));		
	}
}
%>
<html>
<body CLASS='MESSAGE'>
<form name=Dynamic_form>
<input type=hidden name=E value='<%=clearAll%>'>
<input type=hidden name=R value=''>
<input type=hidden name=S value=''>
<input type=hidden name=X value=''>
<input type=hidden name=Y value=''>
</form>
</body>
</html>
<%}
catch(Exception e){out.print(e);}
finally
{
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();

	  if(con != null)
	  ConnectionManager.returnConnection(con,request);
}
%>

