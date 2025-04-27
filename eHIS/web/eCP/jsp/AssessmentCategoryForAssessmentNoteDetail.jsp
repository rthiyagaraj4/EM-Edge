<!DOCTYPE html>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="CatgForAssessment" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
 //This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function submitPrevNext(from, to)
{
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
		if(eval("document.forms[0].select"+i))
		eval("document.forms[0].select"+i).checked=true;
		}
	var assess_note_id = document.forms[0].assess_note_id.value;

	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='AssessmentCategoryForAssessmentNoteDynamicValues.jsp?'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='assess_note_id' id='assess_note_id' value='"+assess_note_id+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=false;
			}
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='AssessmentCategoryForAssessmentNoteDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
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
        ArrayList recordArray=new ArrayList();	
		ArrayList resultArray=new ArrayList();

     	String select_yn="";
		String chk_select="";
		String chk_action="";
		String chk="";
		String assess_catg_code="";
		String long_desc="";

	    String  req_start   =   "", req_end     =   "";
	
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "1" :   request.getParameter("start");
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

	        	if(flagSelect !=null)
	        	{
	        		CatgForAssessment.clearAll();
//	        		 String sqlinsVals= "select assess_catg_code,long_desc,'I' db_action from cp_assess_catg where assess_catg_code not in (select assess_catg_code from cp_assess_note_assess_catg where assess_note_id = ?) and eff_status = 'E' union all select a.assess_catg_code,b.long_desc,'U' db_action from cp_assess_note_assess_catg a,cp_assess_catg b where a. assess_note_id =? and b.assess_catg_code = a.assess_catg_code order by long_desc";
	        		 String sqlinsVals= "SELECT assess_catg_code,long_desc,'I' db_action FROM cp_assess_catg_LANG_VW WHERE assess_catg_code NOT IN (SELECT assess_catg_code FROM cp_assess_note_assess_catg WHERE assess_note_id = ?) AND eff_status = 'E' AND LANGUAGE_ID = ? UNION ALL SELECT a.assess_catg_code,b.long_desc,'U' db_action FROM cp_assess_note_assess_catg a,cp_assess_catg_LANG_VW b WHERE a.assess_note_id =? AND b.assess_catg_code = a.assess_catg_code AND B.LANGUAGE_ID = ? ORDER BY long_desc";
			
				 pstmt3=con.prepareStatement(sqlinsVals);
				 pstmt3.setString(1,assess_note_id);
				 pstmt3.setString(2,locale);
				 pstmt3.setString(3,assess_note_id);
				 pstmt3.setString(4,locale);
				 rstlRs3 = pstmt3.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						recordArray=new ArrayList();
				
			         	recordArray.add(rstlRs3.getString("assess_catg_code"));
				        recordArray.add(rstlRs3.getString("db_action"));
						if(rstlRs3.getString("db_action").equals("U"))
						select_yn="Y";
			         	else if(rstlRs3.getString("db_action").equals("I"))
					    select_yn="N";

     			 		recordArray.add(select_yn);
						CatgForAssessment.putObject(recordArray);
					 }
				}
        	}
             if(from != null && to != null)
             {
                 int j=0;
                 for( i=(Integer.parseInt(req_start)); i<(Integer.parseInt(req_end)); i++)
                 {
                 assess_catg_code = request.getParameter("assess_catg_code"+(i));
				 chk_action = request.getParameter("action"+(i));
				
				 if((request.getParameter("select"+(i)))!=null)
					 chk_select="Y";
				 else
					 chk_select="N";
			
     				    resultArray=new ArrayList();
						resultArray.add(assess_catg_code);
						resultArray.add(chk_action);
						resultArray.add(chk_select);
						CatgForAssessment.setObject(i,resultArray);
                     }
     
  
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
           i = 1 ;
     
			String classValue="";

	//String sql  = "select assess_catg_code,long_desc,'I' db_action from cp_assess_catg where assess_catg_code not in (select assess_catg_code from cp_assess_note_assess_catg where assess_note_id = ?) and eff_status = 'E' union all select a.assess_catg_code,b.long_desc,'U' db_action from cp_assess_note_assess_catg a,cp_assess_catg b where a. assess_note_id =? and b.assess_catg_code = a.assess_catg_code order by long_desc";
	String sql  = "SELECT assess_catg_code,long_desc,'I' db_action FROM cp_assess_catg_LANG_VW WHERE assess_catg_code NOT IN (SELECT assess_catg_code FROM cp_assess_note_assess_catg WHERE assess_note_id = ?) AND eff_status = 'E' AND LANGUAGE_ID = ? UNION ALL SELECT a.assess_catg_code,b.long_desc,'U' db_action FROM cp_assess_note_assess_catg a,cp_assess_catg_LANG_VW b WHERE a.assess_note_id =? AND b.assess_catg_code = a.assess_catg_code AND B.LANGUAGE_ID = ? ORDER BY long_desc";
	
    try
	{
	pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt.setString(1,assess_note_id);
	pstmt.setString(2,locale);
	pstmt.setString(3,assess_note_id);
	pstmt.setString(4,locale);
	rs=pstmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		  //out.println(e);//common-icn-0181
		  e.printStackTrace();//COMMON-ICN-0181
	  }

%>
<body onKeyDown="lockKey()" OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/AssessmentCategoryForAssessmentNoteDetail.jsp' method='post' >

<table  width='90%' border=0 align='center'>
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
			<th width='60%'><fmt:message key="eCP.AssessmentCategory.label" bundle="${cp_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
		<%	 
		if (start != 0)
	    {
		    for(int j=1; j<=start; i++,j++)
			{
					rs.next() ;
			}
	    }

		while(rs.next() && i<=end)
		{ 

        	recordArray=new ArrayList();
			recordArray.add(rs.getString("assess_catg_code"));
			recordArray.add(rs.getString("db_action"));
           
			if(rs.getString("db_action").equals("U"))
				   select_yn="Y";
			else if(rs.getString("db_action").equals("I"))
				   select_yn="N";

		 	recordArray.add(select_yn);

			 assess_catg_code=rs.getString("assess_catg_code");
			 long_desc=rs.getString("long_desc");
            
			 for(int k=0;k<CatgForAssessment.getSize();k++)
			 {
				resultArray=(ArrayList)CatgForAssessment.getObject(k);
     			if(((String)recordArray.get(0)).equals((String)resultArray.get(0)))
				 {
					  	 if((resultArray.get(2)).equals("Y"))
							 chk="checked";
						 else
							 chk="";
					break;
				}
				 else
				 {
					 chk="";
				 }
			 } 
				if( i%2 == 0) 
                   classValue="QRYEVEN";
				else
				   classValue="QRYODD";

		%>
			<tr>
				<td class='<%=classValue%>'><%=long_desc%></td>
			    <input type=hidden name="assess_catg_code<%=(i-1)%>" id="assess_catg_code<%=(i-1)%>" value="<%=recordArray.get(0)%>">
      			<input type=hidden name='action<%=(i-1)%>' id='action<%=(i-1)%>' value='<%=recordArray.get(1)%>'>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chk%> name='select<%=(i-1)%>'  value='<%=recordArray.get(2)%>'> </td>
			</tr>
			<%
			i++;
			}		
    	 }
			  catch(Exception e){
				  //out.println(e);//common-icn-0181
				  e.printStackTrace();//COMMON-ICN-0181
				  }
			  finally
			  {
				  // Added on 25/07/2003 for closing ResultSet & Statements which are not closed Properly.
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(pstmt != null){ pstmt.close(); }
				   		    if(pstmt3 != null){ pstmt3.close(); }
					    
// End of Addition on 25/07/2003 for closing ResultSet & Statements which are not closed properly.
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("CatgForAssessment", CatgForAssessment);

			  }%>

</table>
</form>
</body>
</html>






