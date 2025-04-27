<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
String clearAll="";
try
{
String term_set_id=request.getParameter("term_set_id");
//Below code was modified by Sudhakar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
if(term_set_id == null) term_set_id="";
String pract_type=request.getParameter("pract_type");
String pract_name=request.getParameter("pract_name");
String search_criteria=request.getParameter("search_criteria");
if(pract_name == null || pract_name.equals("undefined")) pract_name="";
if(search_criteria == null || search_criteria.equals("undefined")) search_criteria="";
if(pract_type == null || pract_type.equals("undefined")) pract_type="";
 clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
RecordSet	TerminologyForPractitioner	=	null;
RecordSet	TerminologyForPractitioner1	=	null;
TerminologyForPractitioner	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologyForPractitioner");
TerminologyForPractitioner1	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologyForPractitioner1");
if(clearAll.equals("clearAll"))
{

StringBuffer sql= new StringBuffer();
sql.append(" select a.practitioner_id practitioner_id, 'U' db_action from mr_term_set_for_pract a, am_practitioner b where term_set_id='"+term_set_id+"' and b.pract_type = nvl('"+pract_type+"',b.pract_type) and b.practitioner_id = a.practitioner_id ");
if(pract_name!=null){ 
	if(search_criteria.equals("S")){
		sql.append(" and upper(b.PRACTITIONER_NAME) not like upper('"+pract_name+"%') ");
	}else if(search_criteria.equals("C")){
		sql.append(" and upper(b.PRACTITIONER_NAME) not like upper('%"+pract_name+"%') ");
	}else if(search_criteria.equals("E")){
		sql.append(" and upper(b.PRACTITIONER_NAME) not like upper('%"+pract_name+"') ");
	}
}
sql.append(" order by 2 ");



TerminologyForPractitioner.clearAll();
TerminologyForPractitioner1.clearAll();
con = ConnectionManager.getConnection(request);
stmt=con.createStatement();
 rs=stmt.executeQuery(sql.toString());
 sql.setLength(0);
while(rs.next())
{
TerminologyForPractitioner.putObject(rs.getString(1));

}
}
else if(clearAll.equals("notCleared"))
{


StringBuffer sql= new StringBuffer("select practitioner_id,'I' db_action from am_practitioner where practitioner_id not in(select practitioner_id from mr_term_set_for_pract where term_set_id = '"+term_set_id+"') and eff_status = 'E' and pract_type = nvl('"+pract_type+"',pract_type)");
if(pract_name!=null){
	if(clearAll.equals("notCleared")){
	
	   if(search_criteria.equals("S")){
			sql.append(" and upper(PRACTITIONER_NAME) like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(PRACTITIONER_NAME) like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(PRACTITIONER_NAME) like upper('%"+pract_name+"') ");
		}
			
	}else if(clearAll.equals("clearAll")){
       if(search_criteria.equals("S")){
			sql.append(" and upper(PRACTITIONER_NAME) not like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(PRACTITIONER_NAME) not like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(PRACTITIONER_NAME) not like upper('%"+pract_name+"') ");
		}
	} 
}

sql.append(" union all ");
sql.append(" select a.practitioner_id practitioner_id, 'U' db_action from mr_term_set_for_pract a, am_practitioner b where term_set_id='"+term_set_id+"' and b.pract_type = nvl('"+pract_type+"',b.pract_type) and b.practitioner_id = a.practitioner_id ");
if(pract_name!=null){
	/*if(clearAll.equals("notCleared")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(b.PRACTITIONER_NAME) like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(b.PRACTITIONER_NAME) like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(b.PRACTITIONER_NAME) like upper('%"+pract_name+"') ");
		}
	}else if(clearAll.equals("clearAll")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(b.PRACTITIONER_NAME) not like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(b.PRACTITIONER_NAME) not like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(b.PRACTITIONER_NAME) not like upper('%"+pract_name+"') ");
		}
	}*/
}
sql.append(" order by 2 ");

TerminologyForPractitioner.clearAll();
con = ConnectionManager.getConnection(request);
//String   sql  =" select practitioner_id,'I' db_action from am_practitioner where practitioner_id not in(select practitioner_id from mr_term_set_for_pract where term_set_id = '"+term_set_id+"') and eff_status = 'E' and pract_type = nvl('"+pract_type+"',pract_type) union all select a.practitioner_id practitioner_id, 'U' db_action from mr_term_set_for_pract a, am_practitioner b where term_set_id='"+term_set_id+"' and b.pract_type = nvl('"+pract_type+"',b.pract_type) and b.practitioner_id = a.practitioner_id order by 2";

 stmt=con.createStatement();
 rs=stmt.executeQuery(sql.toString());
 sql.setLength(0);
 //end SKR-SCF-0739 [IN:036606] 
while(rs.next())
{
TerminologyForPractitioner.putObject(rs.getString(1));

}

}
%>

<html>
<head>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body CLASS='MESSAGE' onKeyDown='lockKey()'>
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
catch(Exception e){
	e.printStackTrace();
}
  finally
  {
	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(con,request);

  }
%>

