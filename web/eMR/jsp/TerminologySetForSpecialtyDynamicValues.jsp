<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 Jan 2005

--%>
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
if(term_set_id == null) term_set_id="";
//Below code was modified by N Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
String specialty_desc=request.getParameter("specialty_desc_text");
if(specialty_desc == null || specialty_desc.equals("undefined")) specialty_desc="";
String search_criteria=request.getParameter("search_criteria");
  if(search_criteria == null || search_criteria.equals("undefined")) search_criteria="";
 clearAll = request.getParameter("clearAll");

	if(clearAll == null) clearAll="";
RecordSet	TerminologyForSpecialty	=	null;
TerminologyForSpecialty	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologyForSpecialty");
if(clearAll.equals("clearAll"))
{
         StringBuffer sql= new StringBuffer();
         sql.append("select a.specialty_code specialty_code,'U' db_action from mr_term_set_for_specialty a, am_speciality b where a.term_set_id ='"+term_set_id+"' and b.speciality_code = a.specialty_code");
		   if(specialty_desc!=null){ 
				 if(search_criteria.equals("S")){
					sql.append(" and upper(b.long_desc) not like upper('"+specialty_desc+"%') ");
				}else if(search_criteria.equals("C")){
					sql.append(" and upper(b.long_desc) not like upper('%"+specialty_desc+"%') ");
				}else if(search_criteria.equals("E")){
					sql.append(" and upper(b.long_desc) not like upper('%"+specialty_desc+"') ");
				 }
             }
             sql.append(" order by 2 ");
			 
			TerminologyForSpecialty.clearAll();
            con = ConnectionManager.getConnection(request);
           stmt=con.createStatement();
           rs=stmt.executeQuery(sql.toString());
            sql.setLength(0);
           while(rs.next())
            {
          TerminologyForSpecialty.putObject(rs.getString(1));
		  }

}
else if(clearAll.equals("notCleared"))
{

		 StringBuffer sql= new StringBuffer("select speciality_code,'I' db_action from am_speciality where speciality_code not in (select specialty_code from mr_term_set_for_specialty where term_set_id = '"+term_set_id+"') ");
     if(specialty_desc!=null){
	if(clearAll.equals("notCleared")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(long_desc) like upper('"+specialty_desc+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(long_desc) like upper('%"+specialty_desc+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(long_desc) like upper('%"+specialty_desc+"') ");
		}
	}else if(clearAll.equals("clearAll")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(long_desc) not like upper('"+specialty_desc+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(long_desc) not like upper('%"+specialty_desc+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(long_desc) not like upper('%"+specialty_desc+"') ");
		}
	}
}

    sql.append(" union all ");
    sql.append("select a.specialty_code specialty_code,'U' db_action from mr_term_set_for_specialty a, am_speciality b where a.term_set_id ='"+term_set_id+"' and b.speciality_code = a.specialty_code");
	/*
	if(specialty_desc!=null){
	if(search_criteria.equals("S")){
			sql.append(" and upper(long_desc) like upper('"+specialty_desc+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(long_desc) like upper('%"+specialty_desc+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(long_desc) like upper('%"+specialty_desc+"') ");
		} 
		}
		*/
         sql.append(" order by 2 ");	 
	TerminologyForSpecialty.clearAll();

//String sql="select speciality_code,'I' db_action from am_speciality where speciality_code not in (select specialty_code from mr_term_set_for_specialty where term_set_id = '"+term_set_id+"')  union all select a.specialty_code specialty_code,'U' db_action from mr_term_set_for_specialty a, am_speciality b where a.term_set_id ='"+term_set_id+"' and b.speciality_code = a.specialty_code order by 2";
con = ConnectionManager.getConnection(request);
 stmt=con.createStatement();
 rs=stmt.executeQuery(sql.toString());
 sql.setLength(0);
 //end SKR-SCF-0739 [IN:036606]
while(rs.next())
{
TerminologyForSpecialty.putObject(rs.getString(1));

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
catch(Exception e){/* out.print(e); */e.printStackTrace();}
  finally
  {
	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(con,request);

  }
%>

