<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreenivasulu.Y
*	Created On		:	30 Dec 2004

--%>

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="TerminologyForPractitioner" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="TerminologyForPractitioner1" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="TerminologyForPractitioner2" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../js/TerminologySetForPractitioner.js"></script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String req_start   =   "";
	String req_end     =   "";
	String checkedOnes         =   "";
	String checkedOnes1         =   "";
	String dftremoveCode="";
	String dflt_term_set_yn1="";
	String dflt_term_set_yn="";
	String dftchkAttribute="";
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	String pract_desc_text = request.getParameter("pract_desc_text") ;
	String search_criteria = request.getParameter("search_criteria") ;
	String removeCode = "";
	String disable_yn="";
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if (from == null){ 
		start = 0 ; 
		TerminologyForPractitioner1.clearAll();
		TerminologyForPractitioner2.clearAll();
	}   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
	req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	//Statement stmt3 = null;
	PreparedStatement stmt3=null;
	//Statement stmt4 = null;
	PreparedStatement stmt4=null;
	ResultSet rstlRs3 = null;
	ResultSet rstlRs4 = null;
	
	String selctAllCHk=checkForNull(request.getParameter("selctAllCHk"));
	String _chkAll="";
	if(selctAllCHk.equals("Y"))
	_chkAll="checked";
	else
		_chkAll="";

	effStatus=request.getParameter("effStatus");
	if(effStatus == null)
		effStatus="";
	
	Statement stmt=null;
	ResultSet rs=null ;

	Connection con = null;
	try
	{
			
		con = ConnectionManager.getConnection(request);
	
		String term_set_id=request.getParameter("term_set_id");
		String pract_type=request.getParameter("pract_type")==null?"":request.getParameter("pract_type");
		String flagSelect = request.getParameter("fromSearch");

		if(flagSelect !=null)
       	{
      		TerminologyForPractitioner.clearAll();
      		TerminologyForPractitioner1.clearAll();
      		TerminologyForPractitioner2.clearAll();
       		String sqlinsVals= "select practitioner_id ,DFLT_TERM_SET_YN from mr_term_set_for_pract where term_set_id=? and practitioner_id in(select practitioner_id from am_practitioner where pract_type=nvl(?,pract_type))"; 
			//stmt3=con.createStatement();
			stmt3 = con.prepareStatement(sqlinsVals);
			stmt3.setString(1,term_set_id);
			stmt3.setString(2,pract_type);
			rstlRs3 = stmt3.executeQuery();
			if(rstlRs3 !=null)
			{
				while(rstlRs3.next())
				{
					TerminologyForPractitioner.putObject(rstlRs3.getString(1));
					dflt_term_set_yn1=rstlRs3.getString(2);
					if(dflt_term_set_yn1.equals("Y")){
					TerminologyForPractitioner1.putObject(rstlRs3.getString(1));
					}
				 }
			}
		}





    String sqlinsVals1="select practitioner_id from mr_term_set_for_pract where DFLT_TERM_SET_YN='Y' and term_set_id !=?";
	//out.println("sqlinsVals1:"+sqlinsVals1);
    //stmt4=con.createStatement();
	stmt4 = con.prepareStatement(sqlinsVals1);
	stmt4.setString(1,term_set_id);
	rstlRs4 = stmt4.executeQuery();
    if(rstlRs4 !=null){
				while(rstlRs4.next()){
					TerminologyForPractitioner2.putObject(rstlRs4.getString("practitioner_id"));
					
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
					if(!(TerminologyForPractitioner.containsObject(checkedOnes)))
						TerminologyForPractitioner.putObject(checkedOnes);
					j++;
				}

				removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))
				{
					String practCode = request.getParameter("practCode"+(i));
					if((TerminologyForPractitioner.containsObject(practCode)))
					{
						int removeCodeIndex = TerminologyForPractitioner.indexOfObject(practCode);
							TerminologyForPractitioner.removeObject(removeCodeIndex);
					}
				}
			


if(request.getParameter("dftselect"+(i)) != null){
				checkedOnes1 = request.getParameter("dftselect"+(i));
				//out.println("checkedOnes1="+checkedOnes1);
				if(!(TerminologyForPractitioner1.containsObject("dftselect"+i))){
					TerminologyForPractitioner1.putObject(checkedOnes1);
				}
			}
			dftremoveCode = checkForNull(request.getParameter("dftremoveCode"+(i)));
			if(dftremoveCode.equals("Y")){
				String dftpractTypeCode = request.getParameter("dftpractTypeCode"+(i));
				if((TerminologyForPractitioner1.containsObject(dftpractTypeCode))){
					int dftremoveCodeIndex = TerminologyForPractitioner1.indexOfObject(dftpractTypeCode);
					TerminologyForPractitioner1.removeObject(dftremoveCodeIndex);
				}
			}
			




			}
			out.println("<input type=hidden name='pages' id='pages' value='multiple'>"); 
			out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		}
		i = 1 ;
     	String classValue="";
		String chkAttribute="";
				
		StringBuffer sql = new StringBuffer();
		


		sql.append("select '"+term_set_id+"', practitioner_id, practitioner_name, 'I' db_action ,'N' DFLT_TERM_SET_YN from am_practitioner where practitioner_id not in(select practitioner_id from mr_term_set_for_pract where term_set_id = '"+term_set_id+"') and eff_status = 'E' and pract_type = nvl('"+pract_type+"',pract_type) ");

		if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(practitioner_name) LIKE Upper('"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(practitioner_name) LIKE Upper('%"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(practitioner_name) LIKE Upper('%"+pract_desc_text+"')");

		sql.append(" union all select '"+term_set_id+"', a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, 'U' db_action,a.DFLT_TERM_SET_YN from mr_term_set_for_pract a, am_practitioner b where term_set_id='"+term_set_id+"' and b.pract_type = nvl('"+pract_type+"',b.pract_type) and b.practitioner_id = a.practitioner_id ");

		if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
			sql.append(" and Upper(b.practitioner_name) LIKE Upper('"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(b.practitioner_name) LIKE Upper('%"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(b.practitioner_name) LIKE Upper('%"+pract_desc_text+"')");

		sql.append(" order by 3");


		

		//String   sql  ="select '"+term_set_id+"', practitioner_id, practitioner_name, 'I' db_action from am_practitioner where practitioner_id not in(select practitioner_id from mr_term_set_for_pract where term_set_id = '"+term_set_id+"') and eff_status = 'E' and pract_type = nvl('"+pract_type+"',pract_type) union all select '"+term_set_id+"', a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, 'U' db_action from mr_term_set_for_pract a, am_practitioner b where term_set_id='"+term_set_id+"' and b.pract_type = nvl('"+pract_type+"',b.pract_type) and b.practitioner_id = a.practitioner_id order by 3";
							
				
		try
		{
			//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			

			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());
			
		}
		catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}

		
		if (start != 0)
		{
			for(int j=1; j<=start; i++,j++)
			{
				rs.next() ;
			}
		}

		while( i<=end  && rs.next() )
		{

			if(maxRecord == 0)
			{
%>
				<body  OnMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
				<form name='facility_form_result' id='facility_form_result' action='../../eMR/jsp/TerminologySetForPractitionerDetail.jsp' method='post' >

				<table  width=90%' border=0 align='center'>
				<tr>
					<!--<td align='right' class='NONURGENT'>-->
					<input type=hidden name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>	
					<input type=hidden name='pract_type' id='pract_type' value='<%=pract_type%>'>
					<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
					<input type=hidden name='from' id='from' value='<%=start%>'>
					<input type=hidden name='to' id='to' value='<%=end%>'>
					<input type=hidden name='start' id='start' value='<%=start%>'>
					<input type=hidden name='end' id='end' value='<%=end%>'>
					<input type=hidden name='pract_desc_text' id='pract_desc_text' value='<%=pract_desc_text%>'>
					<input type=hidden name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>	
					<input type='hidden' name='function_name' id='function_name' value='insert'>
					<input type='hidden' name='allValues' id='allValues' value=''>
					<input type='hidden' name='selctAllCHk' id='selctAllCHk' value='<%=_chkAll%>'>
					<table align='right'>
					<tr>
<%
				
				if ( !(start <= 1)) 
				{
					out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
%>
					<input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
				}
				//if ( !((start+12) >= maxRecord ))
				//{
					out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
%>
					<input type=hidden name='whichPage' id='whichPage' value='next'>
					</tr>
					</table>
					<br>
					<br>
					</tr>
					</table>

					<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
					<tr>
						<td width='60%' class="COLUMNHEADER"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						<td width='20%' class='COLUMNHEADERCENTER' ><fmt:message key="eMR.DefaultTermSet.label" bundle="${mr_labels}"/></td>
						<td width='20%' class='COLUMNHEADERCENTER'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' <%=_chkAll%> value="" onClick='selectAll(this,<%=start%>,<%=end%>)'></td>
					</tr>
<%	
			}
			
		
				/*if (start != 0)
				{
					for(int j=1; j<=start; i++,j++)
					{
						rs.next() ;
					}
				}*/
			
				//while(rs.next() && i<=end)
				//{ 
					String practitioner_id=rs.getString("practitioner_id");
					String practitioner_name=rs.getString("practitioner_name");
					dflt_term_set_yn=rs.getString("DFLT_TERM_SET_YN");
					//out.println("dflt_term_set_yn="+dflt_term_set_yn);
					if(TerminologyForPractitioner.containsObject(practitioner_id)) 
						chkAttribute = "CHECKED";
					else
						chkAttribute="";
					int recordIndex = TerminologyForPractitioner.indexOfObject(practitioner_id);
					if(recordIndex!=-1)
					if(chkAttribute.equals("CHECKED"))   
						TerminologyForPractitioner.removeObject(recordIndex);



    if(TerminologyForPractitioner1.containsObject(practitioner_id)){  
			dftchkAttribute = "CHECKED";
		}
		else
			dftchkAttribute="";
		
	int dftrecordIndex = TerminologyForPractitioner1.indexOfObject("dftselect"+i);
		if(dftrecordIndex!=-1)
			if(dftchkAttribute.equals("CHECKED"))
			TerminologyForPractitioner1.removeObject(dftrecordIndex);

	
	
				
					disable_yn="";
		if(TerminologyForPractitioner2.containsObject(practitioner_id))
		{
	
				disable_yn = "disabled";
	
		}		
		else
			{
			disable_yn="";
			}
					
					
					
					if( i%2 == 0)
						classValue="QRYEVEN";
					else
						classValue="QRYODD";
%>
				<tr>
					<td class='<%=classValue%>'><%=practitioner_name%></td>
					<td align='center' class='<%=classValue%>'><input type='checkbox' name='dftselect<%=i%>' id='dftselect<%=i%>'      onclick='SelectDefaultChk(this, <%=i%>)' value='<%=practitioner_id%>' <%=dftchkAttribute%> <%=disable_yn %>><input type='hidden' name='dftremoveCode<%=i%>' id='dftremoveCode<%=i%>' value="N"><input type='hidden' name='dftpractTypeCode<%=i%>' id='dftpractTypeCode<%=i%>' value='<%=practitioner_id%>'></td>

					<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=practitioner_id%>' onClick='unSelectAll(this, <%=i%>)'><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='practCode<%=i%>' id='practCode<%=i%>' value="<%=practitioner_id%>"> </td>
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
		}
		catch(Exception e)
		{
			//out.print(e);
			e.printStackTrace();
		}
		finally
		{
			if(rs != null){ rs.close(); }
			if(rstlRs3 != null){ rstlRs3.close(); }
			if(stmt != null){ stmt.close(); }
			if(stmt3 != null){ stmt3.close(); }
				    
			ConnectionManager.returnConnection(con,request);
			session.setAttribute("TerminologyForPractitioner", TerminologyForPractitioner);
			session.setAttribute("TerminologyForPractitioner1", TerminologyForPractitioner1);
		}
%>

		</table>
	</form>
</body>
<%
	
%>
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

