<!DOCTYPE html>

<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 Jan 2005

--%>

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="TerminologyForSpecialty" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
       
	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
		if(document.forms[0].chkAll.checked==true)
			document.getElementById("selectchkALL").value="Y";
	}
function RemSelectAll(obj, i)
{
	document.forms[0].chkAll.checked = false;

	if(obj.checked == false)
		eval("document.forms[0].removeCode"+i).value = "Y";
	else
		eval("document.forms[0].removeCode"+i).value = "N";
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
		//Below code was modified by N Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
	 var term_set_id = document.forms[0].term_set_id.value;
	 var specialty_desc_text=document.forms[0].specialty_desc_text.value;
	 var search_criteria=document.forms[0].search_criteria.value; 
	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForSpecialtyDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='specialty_desc_text' id='specialty_desc_text' value='"+specialty_desc_text+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	document.getElementById("selectchkALL").value="Y";

	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
			}
			var term_set_id = document.forms[0].term_set_id.value;
	        var specialty_desc_text=document.forms[0].specialty_desc_text.value;
	        var search_criteria=document.forms[0].search_criteria.value;
	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForSpecialtyDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='specialty_desc_text' id='specialty_desc_text' value='"+specialty_desc_text+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	document.getElementById("selectchkALL").value="N";
	}
}
 //end SKR-SCF-0739 [IN:036606]

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


	String selectchkALLChk="";
	String selectchkALL = checkForNull(request.getParameter("selectchkALL") );
	if(selectchkALL.equals("Y"))
	selectchkALLChk="checked";
	else
	selectchkALLChk=" ";

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "";
        
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
		String specialty_desc_text = request.getParameter("specialty_desc_text") ;
		String search_criteria = request.getParameter("search_criteria") ;
		String removeCode = "";
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	//String totAssignreasign="",
		String effStatus="";
		//Statement stmt3 = null;
		PreparedStatement stmt3=null;
		ResultSet rstlRs3 = null;

		effStatus=request.getParameter("effStatus");
		if(effStatus == null) effStatus="";
			Statement stmt=null;
			ResultSet rs=null ;

		Connection con = null;
		try{
			
			con = ConnectionManager.getConnection(request);

	
	//String dat="";
	//String facility="";
	//String pract="";
	//String en="";
	//String fnval="insert";
	//String id="";
	//String fname="";
	//String prname="";
	//String ps="";
//	String facility_id=(String)session.getValue("facility_id");
			String term_set_id=request.getParameter("term_set_id");
			String flagSelect = request.getParameter("fromSearch");


	        	if(flagSelect !=null)
	        	{
	        		TerminologyForSpecialty.clearAll();
	        		 String sqlinsVals= "select specialty_code from mr_term_set_for_specialty where term_set_id=?";
			
				 //stmt3=con.createStatement();
				 stmt3 = con.prepareStatement(sqlinsVals);
				 stmt3.setString(1,term_set_id);
				 rstlRs3 = stmt3.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						TerminologyForSpecialty.putObject(rstlRs3.getString(1));

					 }
				}
	
	        	}
	        //int recordCount			=	0;

             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(TerminologyForSpecialty.containsObject(checkedOnes)))
                                 TerminologyForSpecialty.putObject(checkedOnes);
                             j++;
                         }
                         else
                         {
                         
                         }
						 removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclt_Code = request.getParameter("Code"+(i));
							if((TerminologyForSpecialty.containsObject(spclt_Code)))
							{
								int removeCodeIndex = TerminologyForSpecialty.indexOfObject(spclt_Code);
									TerminologyForSpecialty.removeObject(removeCodeIndex);
}
						}				 
            
                     }

						
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
			i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			//String eff_status="",selectyn="";
			

		StringBuffer sql = new StringBuffer();
		sql.append("select '"+term_set_id+"',speciality_code  specialty_code,long_desc specialty_desc ,'I' db_action from am_speciality where speciality_code not in (select specialty_code from mr_term_set_for_specialty where term_set_id = '"+term_set_id+"') ");
		if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(long_desc) LIKE Upper('"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(long_desc) LIKE Upper('%"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(long_desc) LIKE Upper('%"+specialty_desc_text+"')");
		
		sql.append("  union all select '"+term_set_id+"',a.specialty_code specialty_code,b.long_desc specialty_desc, 'U' db_action from mr_term_set_for_specialty a, am_speciality b where a.term_set_id ='"+term_set_id+"' and b.speciality_code = a.specialty_code ");

		if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('%"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('%"+specialty_desc_text+"')");
		sql.append("  order by 3");	

		//String sql="select '"+term_set_id+"',speciality_code  specialty_code,long_desc specialty_desc ,'I' db_action from am_speciality where speciality_code not in (select specialty_code from mr_term_set_for_specialty where term_set_id = '"+term_set_id+"') union all select '"+term_set_id+"',a.specialty_code specialty_code,b.long_desc specialty_desc, 'U' db_action from mr_term_set_for_specialty a, am_speciality b where a.term_set_id ='"+term_set_id+"' and b.speciality_code = a.specialty_code order by 3";

	
			
		try{
			//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());
			//rs.last();
			//maxRecord = rs.getRow();
			//rs.beforeFirst();
		}catch(Exception e){/* out.println(e); */e.printStackTrace();}

		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }

		while(i<=end && rs.next()){ 
			if(maxRecord == 0)
			{

%>
		<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' onKeyDown='lockKey()'>
		<form name='facility_form_result' id='facility_form_result' action='../../eMR/jsp/TerminologySetForSpecialtyDetail.jsp' method='post' >

		<table  width='90%' border=0 align='center'>
		<tr>
		<!--<td align='right' class='NONURGENT'>-->
		<input type=hidden name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
		<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>

		<input type=hidden name='from' id='from' value='<%=start%>'>
		<input type=hidden name='to' id='to' value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type=hidden name='specialty_desc_text' id='specialty_desc_text' value='<%=specialty_desc_text%>'>
		<input type=hidden name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<input type='hidden' name='allValues' id='allValues' value=''>
		<input type='hidden' name='selectchkALL' id='selectchkALL' value='<%=selectchkALL%>'>

		<table  align='right'>
		<tr>
<%
	
		if ( !(start <= 1)) {
		out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
%>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    //if ( !((start+12) >= maxRecord )){
		out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
%>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
<%
   // }
%>
		</tr>
		</table>
		<br>
		<br>
		</tr>
		</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<tr>
			<td width='60%' class="COLUMNHEADER"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td width='20%' class='COLUMNHEADERCENTER'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll'<%=selectchkALLChk%> onClick='selectAll(this,<%=start%>,<%=end%>)'></td></tr>
		<%	 
			}
		//recordCount =TerminologyForSpecialty.getSize();
		/*if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }*/
			//while(rs.next() && i<=end){ 
			String specialty_code=rs.getString("specialty_code");
						
			String specialty_desc=rs.getString("specialty_desc");
			

			if(TerminologyForSpecialty.containsObject(specialty_code)) 
				{
				chkAttribute = "CHECKED";
			
				}
			else
				{
			chkAttribute="";
		
				}

			int recordIndex = TerminologyForSpecialty.indexOfObject(specialty_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    TerminologyForSpecialty.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=specialty_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=specialty_code%>' onclick="RemSelectAll(this, <%=i%>);"><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='Code<%=i%>' id='Code<%=i%>' value="<%=specialty_code%>"></td>
			</tr>
			<%
			i++;
			maxRecord++;
		}			
			if ( maxRecord < 12 || (!rs.next()) )
				{
					%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
					<% 
				}
				else
				{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

				<%
				}

				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}

			 }
			  catch(Exception e){/* out.print(e); */e.printStackTrace();}
			  finally
			  {
				  // Added on 25/07/2003 for closing ResultSet & Statements which are not closed Properly.
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(stmt3 != null){ stmt3.close(); }
					    
// End of Addition on 25/07/2003 for closing ResultSet & Statements which are not closed properly.
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("TerminologyForSpecialty", TerminologyForSpecialty);

			  }%>

</table>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

