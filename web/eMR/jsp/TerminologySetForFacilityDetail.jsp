<!DOCTYPE html>
		
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	30 Dec 2004

--%>

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="TerminologyForFacility" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>


<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
    
	function RemSelectAll(obj, i)
	{
		document.forms[0].chkAll.checked = false;

		if(obj.checked == false)
			eval("document.forms[0].removeCode"+i).value = "Y";
		else
			eval("document.forms[0].removeCode"+i).value = "N";
	}


	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
		if(document.forms[0].chkAll.checked==true)
		document.getElementById("selectChk").value='Y';
		
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
	var term_set_id = document.forms[0].term_set_id.value;
	//Below code was modified by N Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
	var facility_desc_text=document.forms[0].facility_desc_text.value;
	var search_criteria=document.forms[0].search_criteria.value;
	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForFacilityDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='facility_desc_text' id='facility_desc_text' value='"+facility_desc_text+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	document.getElementById("selectChk").value='Y';

	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
			}
	var term_set_id = document.forms[0].term_set_id.value;
	var facility_desc_text=document.forms[0].facility_desc_text.value;
	var search_criteria=document.forms[0].search_criteria.value;
	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForFacilityDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='facility_desc_text' id='facility_desc_text' value='"+facility_desc_text+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	document.getElementById("selectChk").value='N';
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

		String selectChkecked="";
		String selectChk=checkForNull(request.getParameter("selectChk"));
			if(selectChk.equals("Y"))
				selectChkecked="checked";
				

			
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
		String facility_desc_text = request.getParameter("facility_desc_text") ;
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

	
	
              
			


			String term_set_id=request.getParameter("term_set_id");
			String flagSelect = request.getParameter("fromSearch");

	        	if(flagSelect !=null)
	        	{
	        		TerminologyForFacility.clearAll();
	        		 String sqlinsVals= "select facility_id from mr_term_set_for_facility where term_set_id=?";
			
				 //stmt3=con.createStatement();
				 stmt3 = con.prepareStatement(sqlinsVals);
				 stmt3.setString(1,term_set_id);
				 rstlRs3 = stmt3.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						TerminologyForFacility.putObject(rstlRs3.getString(1));

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
                             if(!(TerminologyForFacility.containsObject(checkedOnes)))
                                 TerminologyForFacility.putObject(checkedOnes);
                             j++;
                         }
                         else
                         {
                         
                         }

						removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String facilityCode = request.getParameter("facilityCode"+(i));
							if((TerminologyForFacility.containsObject(facilityCode)))
							{
								int removeCodeIndex = TerminologyForFacility.indexOfObject(facilityCode);
									TerminologyForFacility.removeObject(removeCodeIndex);
							}
						}
                     }
     
				
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
			i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			//String eff_status="",
			//String selectyn="";
			

				
			StringBuffer sql = new StringBuffer();
			sql.append(" select '"+term_set_id+"',facility_id,facility_name,'I' db_action from sm_facility_param where facility_id not in (select facility_id from mr_term_set_for_facility where term_set_id = '"+term_set_id+"') and status='E' ");
			
			if(facility_desc_text!=null && !facility_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
				sql.append(" and Upper(facility_name) LIKE Upper('"+facility_desc_text+"%')");
			else if(facility_desc_text!=null && !facility_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
				sql.append(" and Upper(facility_name) LIKE Upper('%"+facility_desc_text+"%')");
			else if(facility_desc_text!=null && !facility_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
				sql.append(" and Upper(facility_name) LIKE Upper('%"+facility_desc_text+"')");

			sql.append(" union all select '"+term_set_id+"',a.facility_id facility_id,b.facility_name facility_name, 'U' db_action from mr_term_set_for_facility a, sm_facility_param b where a.term_set_id ='"+term_set_id+"' and b.facility_id = a.facility_id ");

			if(facility_desc_text!=null && !facility_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
				sql.append(" and Upper(b.facility_name) LIKE Upper('"+facility_desc_text+"%')");
			else if(facility_desc_text!=null && !facility_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
				sql.append(" and Upper(b.facility_name) LIKE Upper('%"+facility_desc_text+"%')");
			else if(facility_desc_text!=null && !facility_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
				sql.append(" and Upper(b.facility_name) LIKE Upper('%"+facility_desc_text+"')");

			sql.append(" order by 3");
	
	
	
			//String sql=" select '"+term_set_id+"',facility_id,facility_name,'I' db_action from sm_facility_param where facility_id not in (select facility_id from mr_term_set_for_facility where term_set_id = '"+term_set_id+"') and status='E' union all select '"+term_set_id+"',a.facility_id facility_id,b.facility_name facility_name, 'U' db_action from mr_term_set_for_facility a, sm_facility_param b where a.term_set_id ='"+term_set_id+"' and b.facility_id = a.facility_id order by 3";
			
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
	while( i<=end  && rs.next() )
		{
			if (maxRecord==0)
			{

%>
	<body  OnMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
	<form name='facility_form_result' id='facility_form_result' action='../../eMR/jsp/TerminologySetForFacilityDetail.jsp' method='post' >

	<table  width='90%' border=0 align='center'>
	<tr>
	<!--<td align='right' class='NONURGENT'>-->
	<input type=hidden name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
	<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>

	<input type=hidden name='from' id='from' value='<%=start%>'>
	<input type=hidden name='to' id='to' value='<%=end%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>
	<input type=hidden name='facility_desc_text' id='facility_desc_text' value='<%=facility_desc_text%>'>
	<input type=hidden name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>					
	<input type='hidden' name='function_name' id='function_name' value='insert'>
	<input type='hidden' name='allValues' id='allValues' value=''>
	<input type='hidden' name='selectChk' id='selectChk' value='<%=selectChk%>'>
	


<%
	
	//if (maxRecord==0)
		//{
	%>
			<table align='right'>
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
			
			</tr>
			</table>
			<br>
			<br>
<%
    //}
%>

			</tr>
			</table>
			<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<tr>
			<td width='60%' class="COLUMNHEADER"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td width='20%' class='COLUMNHEADERCENTER'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' <%=selectChkecked%> onClick='selectAll(this,<%=start%>,<%=end%>)'></td></tr>
		<%	 
		//recordCount =TerminologyForFacility.getSize();
		}
		
		/*if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }*/
			//while(rs.next() && i<=end){ 
			//while(i<=end && rs.next() ){
			String facility_id=rs.getString("facility_id");
			
			String facility_name=rs.getString("facility_name");

			if(TerminologyForFacility.containsObject(facility_id))  chkAttribute = "CHECKED";
			else
			chkAttribute="";

			int recordIndex = TerminologyForFacility.indexOfObject(facility_id);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    TerminologyForFacility.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=facility_name%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=facility_id%>'  onclick="RemSelectAll(this, <%=i%>);"><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='facilityCode<%=i%>' id='facilityCode<%=i%>' value="<%=facility_id%>"></td>
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
					%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));parent.frames[1].location.href='../../eCommon/html/blank.html';</script>
					<%
				}		
		}catch(Exception e){/* out.print(e); */e.printStackTrace();}
			  finally
			  {
				
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(stmt3 != null){ stmt3.close(); }
					    

				ConnectionManager.returnConnection(con,request);
				session.setAttribute("TerminologyForFacility", TerminologyForFacility);

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

