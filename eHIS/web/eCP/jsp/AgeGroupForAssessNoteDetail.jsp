<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreenivasulu.Y
*	Created On		:	10 Jan 2005

--%>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="AgeGroupForAssessNote" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
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
	var assess_note_id = document.forms[0].assess_note_id.value;
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='AgeGroupForAssessNoteDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='assess_note_id' id='assess_note_id' value='"+assess_note_id+"'></form></BODY></HTML>";
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
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='AgeGroupForAssessNoteDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
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

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	PreparedStatement pstmt3 = null;
	ResultSet rstlRs3 = null;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
		PreparedStatement pstmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try{
			
	con = ConnectionManager.getConnection(request);
	String assess_note_id=request.getParameter("assess_note_id");
	String flagSelect = request.getParameter("fromSearch");
	String age_group_code="";
	String long_desc="";
	String min_age="";
	String max_age="";
	String gender="";

	        	if(flagSelect !=null)
	        	{
	        		 AgeGroupForAssessNote.clearAll();
	        		 String sqlinsVals= " select age_group_code from CP_ASSESS_NOTE_AGE_GROUP where assess_note_id=?";

					 pstmt3=con.prepareStatement(sqlinsVals);
					 pstmt3.setString(1,assess_note_id);
				     rstlRs3 = pstmt3.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						AgeGroupForAssessNote.putObject(rstlRs3.getString(1));

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
                             if(!(AgeGroupForAssessNote.containsObject(checkedOnes)))
                                 AgeGroupForAssessNote.putObject(checkedOnes);
                             j++;
                         }

                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			String sql="";
					
//sql  =" select ?, a.age_group_code, a.long_desc, a.min_age, decode(a.age_unit,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') min_age_durn_unit, a.max_age, decode(a.age_unit_max,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') max_age_durn_unit, decode(a.gender,'M','Male','F','Female','U','Unknown') gender,'I' db_action from am_age_group a where age_group_code not in(select age_group_code from cp_assess_note_age_group where assess_note_id = ?) and eff_status = 'E' union all select ?,a.age_group_code, b.long_desc, b.min_age, decode(b.age_unit,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') min_age_durn_unit, b.max_age, decode(b.age_unit_max,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') max_age_durn_unit, decode(b.gender,'M','Male','F','Female','U','Unknown') gender,'U' db_action from cp_assess_note_age_group a, am_age_group b where a.assess_note_id = ? and b.age_group_code = a.age_group_code order by 3 ";
sql  =" SELECT ?, a.age_group_code, a.long_desc, a.min_age, DECODE(a.age_unit,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') min_age_durn_unit, a.max_age, DECODE(a.age_unit_max,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') max_age_durn_unit, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender,'I' db_action FROM am_age_group_LANG_VW a WHERE age_group_code NOT IN(SELECT age_group_code FROM cp_assess_note_age_group WHERE assess_note_id = ?) AND eff_status = 'E' AND A.LANGUAGE_ID = ? UNION ALL SELECT ?,a.age_group_code, b.long_desc, b.min_age, DECODE(b.age_unit,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') min_age_durn_unit, b.max_age, DECODE(b.age_unit_max,'D','Days','H','Hours','N','Minutes','M','Months','S','Seconds','Y','Years') max_age_durn_unit, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender,'U' db_action FROM cp_assess_note_age_group a, am_age_group_LANG_VW b WHERE a.assess_note_id = ? AND b.age_group_code = a.age_group_code AND B.LANGUAGE_ID = ? ORDER BY 3 ";
System.err.println("assess_note_id "+assess_note_id);
						
try{
	pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt.setString(1,assess_note_id);
	pstmt.setString(2,assess_note_id);
	pstmt.setString(3,locale);
	pstmt.setString(4,assess_note_id);
	pstmt.setString(5,assess_note_id);
	pstmt.setString(6,locale);
	rs=pstmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	System.err.println("maxRecord "+maxRecord);
	rs.beforeFirst();
	  }catch(Exception e){
		 // out.println(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
		  }

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/AgeGroupForAssessNoteDetail.jsp' method='post' >

<table  width=90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='assess_note_id' id='assess_note_id' value='<%=assess_note_id%>'>
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
			<th width='35%'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="eCP.SexSpecific.label" bundle="${cp_labels}"/></th>
			<th width='15%'><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></th>
			<th width='15%'><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></th>

			<th width='15%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
		<%	 
		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ 

			age_group_code=rs.getString("age_group_code");
			long_desc=rs.getString("long_desc");
			min_age=rs.getString("min_age");
			max_age=rs.getString("max_age");
			gender=rs.getString("gender");
			
			if(min_age == null) min_age="&nbsp;";
			if(max_age == null) max_age="&nbsp;";
			if(gender == null) gender="&nbsp;";


			if(AgeGroupForAssessNote.containsObject(age_group_code))  chkAttribute = "CHECKED";
			else
			chkAttribute="";

			int recordIndex = AgeGroupForAssessNote.indexOfObject(age_group_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    AgeGroupForAssessNote.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=long_desc%></td>
					<td  class='<%=classValue%>'><%=gender%></td>
					<td align=right class='<%=classValue%>'><%=min_age%></td>
					<td align=right class='<%=classValue%>'><%=max_age%></td>

				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=age_group_code%>'> </td>
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
				            if(pstmt != null){ pstmt.close(); }
				   		    if(pstmt3 != null){ pstmt3.close(); }
					    
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("AgeGroupForAssessNote", AgeGroupForAssessNote);

			  }%>

</table>
</form>
</body>
</html>

