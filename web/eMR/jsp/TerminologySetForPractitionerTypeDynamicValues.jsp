<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*  File Name		:	TerminologySetForPractitionerTypeDyanamicValues.jsp
*	Purpose 			:	to Store the selected practitioner type into the RecordSet
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	Statement stmt_practType=null;
	ResultSet rs_practType=null;
	String clearAll="";
	String term_set_id="";
	try{
		term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
		clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");
		//Below code was modified by N Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
         String pract_name=request.getParameter("pract_type_text");
         String search_criteria=request.getParameter("search_criteria");
        if(pract_name == null || pract_name.equals("undefined")) pract_name="";
        if(search_criteria == null || search_criteria.equals("undefined")) search_criteria="";
		RecordSet	TerminologySetForPractitionerType	=	null;
		RecordSet	TerminologySetForPractitionerType1	=	null;
		TerminologySetForPractitionerType	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologySetForPractitionerType");
		TerminologySetForPractitionerType1	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologySetForPractitionerType1");

		if(clearAll.equals("clearAll")){
		   StringBuffer sql= new StringBuffer();
         sql.append("select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from mr_term_set_for_pract_type a, am_pract_type b where a.term_set_id ='"+term_set_id+"' and b.pract_type = a.pract_type");
		   if(pract_name!=null){ 
				 if(search_criteria.equals("S")){
					sql.append(" and upper(b.DESC_USERDEF) not like upper('"+pract_name+"%') ");
				}else if(search_criteria.equals("C")){
					sql.append(" and upper(b.DESC_USERDEF) not like upper('%"+pract_name+"%') ");
				}else if(search_criteria.equals("E")){
					sql.append(" and upper(b.DESC_USERDEF) not like upper('%"+pract_name+"') ");
				 }
             }
             sql.append(" order by 2 ");
			 
			TerminologySetForPractitionerType.clearAll();
			TerminologySetForPractitionerType1.clearAll();
            con = ConnectionManager.getConnection(request);
           stmt_practType=con.createStatement();
           rs_practType=stmt_practType.executeQuery(sql.toString());
            sql.setLength(0);
           while(rs_practType.next())
            {
          TerminologySetForPractitionerType.putObject(rs_practType.getString(1));
		  }
         } else if(clearAll.equals("notCleared")){
		 
		 StringBuffer sql= new StringBuffer("select pract_type, desc_userdef pract_type_desc, 'I' db_action from am_pract_type where pract_type not in (select pract_type from mr_term_set_for_pract_type where term_set_id = '"+term_set_id+"') and eff_status='E' ");
     if(pract_name!=null){
	if(clearAll.equals("notCleared")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(DESC_USERDEF) like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(DESC_USERDEF) like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(DESC_USERDEF) like upper('%"+pract_name+"') ");
		}
	}else if(clearAll.equals("clearAll")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(DESC_USERDEF) not like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(DESC_USERDEF) not like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(DESC_USERDEF) not like upper('%"+pract_name+"') ");
		}
	}
}

    sql.append(" union all ");
    sql.append("select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from mr_term_set_for_pract_type a, am_pract_type b where a.term_set_id ='"+term_set_id+"' and b.pract_type = a.pract_type");
	
    sql.append(" order by 2 ");	 
	con = ConnectionManager.getConnection(request);
	//String sql_practType="select pract_type, desc_userdef pract_type_desc, 'I' db_action from am_pract_type where pract_type not in (select pract_type from mr_term_set_for_pract_type where term_set_id = '"+term_set_id+"') and eff_status='E' union all select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from mr_term_set_for_pract_type a, am_pract_type b where a.term_set_id ='"+term_set_id+"' and b.pract_type = a.pract_type order by 2";
         
	stmt_practType=con.createStatement();
    rs_practType=stmt_practType.executeQuery(sql.toString());
    sql.setLength(0);
	//end SKR-SCF-0739 [IN:036606] 
	while(rs_practType.next()){
	if(!(TerminologySetForPractitionerType.containsObject(rs_practType.getString(1))))
		TerminologySetForPractitionerType.putObject(rs_practType.getString(1));
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
<%
	}
	catch(Exception e){/* out.print(e); */e.printStackTrace();}
		finally{

		if(rs_practType!=null)
			  rs_practType.close();
		if(stmt_practType!=null)
			  stmt_practType.close();
		ConnectionManager.returnConnection(con,request);

	  }
%>

