<!DOCTYPE html>


<html> 
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="CaseTypeNote" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
       
	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}

function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
	for(var i=start;i<=end;i++)
		{
		if(eval("document.forms[0].chk"+i))
		eval("document.forms[0].chk"+i).checked=true;
		}
		var case_type_code = document.forms[0].case_type_code.value;
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LibraryForCaseTypeDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='case_type_code' id='case_type_code' value='"+case_type_code+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
			}
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LibraryForCaseTypeDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
}

function chkForSelectAll(start,end)
{
	if(parent.frames[2].document.forms[0].E.value == 'selectAll')
	{
	document.forms[0].chkAll.checked=true;
	selectAll(document.forms[0].chkAll,start,end)
	}

}
</script>
<%
	String  req_start   =   "", req_end     =   "";
        String  checkedOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

		String case_type_code="";
		String flagSelect = "";
		String sqlinsVals="";
		String two_val="";

		String classValue="";
		String chkAttribute="";

		String  sql="";
		String library_id="";
		String version_no="";
		String long_desc="";	
		String two_valus="";


        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

		//Statement stmt3 = null;
		//ResultSet rstlRs3 = null;
		PreparedStatement pstmt = null;
		ResultSet rstlRs3 = null;

		Statement stmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try{
			
	con = ConnectionManager.getConnection(request);
	 case_type_code=request.getParameter("case_type_code")==null?"":request.getParameter("case_type_code");
	 flagSelect = request.getParameter("fromSearch");	

	        	if(flagSelect !=null)
	        	{
	        		 CaseTypeNote.clearAll();
	        		  //sqlinsVals= "select library_id,version_no from CP_CASE_TYPE_FOR_LIBRARY where case_type_code='"+case_type_code+"'";
					 //stmt3=con.createStatement();
				     //rstlRs3 = stmt3.executeQuery(sqlinsVals);
					 sqlinsVals= "select library_id,version_no from CP_CASE_TYPE_FOR_LIBRARY where case_type_code=?";
					 pstmt=con.prepareStatement(sqlinsVals);
					 pstmt.setString(1,case_type_code);
					 rstlRs3 = pstmt.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {

						 two_val=rstlRs3.getString(1)+"~"+rstlRs3.getString(2);
						CaseTypeNote.putObject(two_val);

					 }
				}
	
	        	}
	        

             if(from != null && to != null)
             {
                     int j=0;
		
			         for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
							
							 if(!(CaseTypeNote.containsObject(checkedOnes)))
                                 CaseTypeNote.putObject(checkedOnes);
                             j++;
						
                         }
                         else
                         {
                         
                         }
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
								
     // sql="SELECT distinct library_id, version_no, long_desc, db_action FROM (SELECT library_id, version_no, long_desc, db_action, status, first_value(status) OVER (PARTITION BY library_id) firstvalue FROM (SELECT DISTINCT ad.library_id,ad.term_code,ad.version_no,ad.term_Set_id, ad.long_desc, ad.db_action, DECODE(b.term_code,NULL,'N','Y') status FROM (SELECT   DISTINCT a.library_id, a.version_no, b.term_code,b.term_set_id,a.long_desc, 'U' db_action FROM cp_library a, cp_term_code_for_case_type b WHERE a.library_basis = 'C' AND a.status = 'F' AND a.eff_status = 'E' AND b.case_type_code= '"+case_type_code+"') ad,cp_library_intervention b WHERE ad.library_id = b.library_id(+) AND ad.term_code = b.term_code(+) AND ad.term_set_id = b.term_set_id(+) AND ad.version_no = b.version_no(+) ORDER BY status)) WHERE firstvalue = 'Y' AND (library_id, version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = '"+case_type_code+"') union all select a.library_id,a.version_no,b.long_desc, 'U' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = '"+case_type_code+"' and b.library_id = a.library_id and b.version_no = a.version_no order by 3";
	    sql="SELECT DISTINCT library_id, version_no, long_desc, db_action FROM (SELECT library_id, version_no, long_desc, db_action, status, first_value(status) OVER (PARTITION BY library_id) firstvalue FROM (SELECT DISTINCT ad.library_id,ad.term_code,ad.version_no,ad.term_Set_id, ad.long_desc, ad.db_action, DECODE(b.term_code,NULL,'N','Y') status FROM (SELECT   DISTINCT a.library_id, a.version_no, b.term_code,b.term_set_id,a.long_desc, 'U' db_action FROM cp_library_lang_vw a, cp_term_code_for_case_type b WHERE a.library_basis = 'C' AND a.status = 'F' AND a.eff_status = 'E' AND a.language_id = '"+locale+"' AND b.case_type_code= '"+case_type_code+"') ad,cp_library_intervention b WHERE ad.library_id = b.library_id(+) AND ad.term_code = b.term_code(+) AND ad.term_set_id = b.term_set_id(+) AND ad.version_no = b.version_no(+) ORDER BY status)) WHERE firstvalue = 'Y' AND (library_id, version_no) NOT IN (SELECT library_id,version_no FROM cp_case_type_for_library WHERE case_type_code = '"+case_type_code+"') UNION ALL SELECT a.library_id,a.version_no,b.long_desc, 'U' db_action FROM cp_case_type_for_library a, cp_library_lang_vw b WHERE a.case_type_code = '"+case_type_code+"' AND b.library_id = a.library_id AND b.language_id = '"+locale+"' AND b.version_no = a.version_no ORDER BY 3";

try{
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sql);
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){out.println(e);}

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/LibraryForCaseTypeDetail.jsp' method='post' >

<table  width=90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='case_type_code' id='case_type_code' value='<%=case_type_code%>'>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='allValues' id='allValues' value=''>

<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( !((start+12) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th width='15%'><fmt:message key="eCP.LibraryID.label" bundle="${cp_labels}"/></th>
				<th width='15%'><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></th>
			<th width='50%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
		<%	 
		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
					System.err.println("one");
				     }
				    }
			System.out.println("one and half"+i);
			while(rs.next() && i<=end){ 
				System.err.println("two");
			 library_id=rs.getString("library_id");
			 version_no=rs.getString("version_no");
			 long_desc=rs.getString("long_desc");	
			 two_valus=library_id+"~"+version_no;
			
			if(CaseTypeNote.containsObject(two_valus))  
				chkAttribute = "CHECKED";
			else
			chkAttribute="";

			int recordIndex = CaseTypeNote.indexOfObject(two_valus);
			if(recordIndex!=-1)

			if(chkAttribute.equals("CHECKED"))  
			CaseTypeNote.removeObject(recordIndex);
			
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
							
				%>
			<tr>
				<td class='<%=classValue%>'><%=library_id%></td>
				<td class='<%=classValue%>'><%=version_no%></td>
				<td class='<%=classValue%>'><%=long_desc%></td>	
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=two_valus%>'> </td>
			</tr>
			<%
			i++;
			
			}
			
			 }
			  catch(Exception e){out.print(e);}
			  finally
			  {
				  
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(pstmt != null){ pstmt.close(); }
					    
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("CaseTypeNote", CaseTypeNote);

			  }%>

</table>
</form>
</body>
</html>





