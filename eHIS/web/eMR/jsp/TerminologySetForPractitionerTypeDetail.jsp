<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="TerminologySetForPractitionerType" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="TerminologySetForPractitionerType1" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="TerminologySetForPractitionerType2" class="webbeans.eCommon.RecordSet" scope="session"/> 

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../js/TerminologySetForPractitionerType.js"></script>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String req_start   =   "";
String req_end     =   "";	
String checkedOnes         =   "";
String checkedOnes1         =   "";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
String pract_type_text = request.getParameter("pract_type_text") ;
String search_criteria = request.getParameter("search_criteria") ;
String removeCode	= "";
String dftremoveCode="";
String dflt_term_set_yn="";
String dflt_term_set_yn1="";
String disable_yn="";
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
if (from == null){
	start = 0 ;
	TerminologySetForPractitionerType1.clearAll();
	TerminologySetForPractitionerType2.clearAll();
}
else
	start = Integer.parseInt(from);
if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
req_start=(request.getParameter("start")==null)?"0":request.getParameter("start");
req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");
//String totAssignreasign="",
String effStatus="";
//Statement stmt3 = null;
PreparedStatement stmt3=null;	
//Statement stmt4=null;
PreparedStatement stmt4=null;	

ResultSet rstlRs3 = null;
effStatus=request.getParameter("effStatus");
if(effStatus == null) 
	effStatus="";
Statement stmt=null;
ResultSet rs=null ;
Connection con = null;
String selectCHkChecked="";
String selectCHk=checkForNull(request.getParameter("selectCHk"));
if(selectCHk.equals("Y"))
selectCHkChecked="checked";
else
selectCHkChecked=" ";


try
{
	con = ConnectionManager.getConnection(request);			
	String term_set_id=request.getParameter("term_set_id");
	String flagSelect = request.getParameter("fromSearch");
	if(flagSelect !=null){
		TerminologySetForPractitionerType.clearAll();
		TerminologySetForPractitionerType1.clearAll();
		TerminologySetForPractitionerType2.clearAll();
		String sqlinsVals="select pract_type,DFLT_TERM_SET_YN from mr_term_set_for_pract_type where term_set_id=?";
		//stmt3=con.createStatement();
		stmt3 = con.prepareStatement(sqlinsVals);
		stmt3.setString(1,term_set_id);
			 rstlRs3 = stmt3.executeQuery();
			if(rstlRs3 !=null){
				while(rstlRs3.next()){
					TerminologySetForPractitionerType.putObject(rstlRs3.getString(1));
					dflt_term_set_yn1=rstlRs3.getString(2);
					if(dflt_term_set_yn1.equals("Y")){
					TerminologySetForPractitionerType1.putObject(rstlRs3.getString(1));
					}
				 }
			}	
		}
		String sqlinsVals1="select pract_type from mr_term_set_for_pract_type where DFLT_TERM_SET_YN='Y' and term_set_id !=?";
	
		//stmt4=con.createStatement();
		stmt4 = con.prepareStatement(sqlinsVals1);
		stmt4.setString(1,term_set_id);
		rstlRs3 = stmt4.executeQuery();
		//out.println("sql 2"+sqlinsVals1.toString());
	
		if(rstlRs3 !=null){
				while(rstlRs3.next()){
					TerminologySetForPractitionerType2.putObject(rstlRs3.getString("pract_type"));		
				 }
			}	

	if(from != null && to != null){
		int j=0;
		for( i=(Integer.parseInt(req_start))+1; i<=(Integer.parseInt(req_end)); i++){
			 if(request.getParameter("select"+(i)) != null){
				 checkedOnes = request.getParameter("select"+(i));
				 if(!(TerminologySetForPractitionerType.containsObject(checkedOnes)))
					 TerminologySetForPractitionerType.putObject(checkedOnes);
				 j++;
				 }

			removeCode = checkForNull(request.getParameter("removeCode"+(i)));
			if(removeCode.equals("Y")){
				String practTypeCode = request.getParameter("practTypeCode"+(i));
				if((TerminologySetForPractitionerType.containsObject(practTypeCode))){
					int removeCodeIndex = TerminologySetForPractitionerType.indexOfObject(practTypeCode);
						TerminologySetForPractitionerType.removeObject(removeCodeIndex);
				}
			}
			if(request.getParameter("dftselect"+(i)) != null){
				checkedOnes1 = request.getParameter("dftselect"+(i));
				
				if(!(TerminologySetForPractitionerType1.containsObject("dftselect"+i))){
					TerminologySetForPractitionerType1.putObject(checkedOnes1);
				}
			}
			dftremoveCode = checkForNull(request.getParameter("dftremoveCode"+(i)));
			if(dftremoveCode.equals("Y")){
				String dftpractTypeCode = request.getParameter("dftpractTypeCode"+(i));
				if((TerminologySetForPractitionerType1.containsObject(dftpractTypeCode))){
					int dftremoveCodeIndex = TerminologySetForPractitionerType1.indexOfObject(dftpractTypeCode);
					TerminologySetForPractitionerType1.removeObject(dftremoveCodeIndex);
				}
			}
			

	}

		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	 }
	i = 1 ;

	String classValue="";
	String chkAttribute="";
	String dftchkAttribute="";
	
	//String eff_status="",
	

	StringBuffer sql = new StringBuffer();
	sql.append("select pract_type, desc_userdef pract_type_desc, 'I' db_action,'N' DFLT_TERM_SET_YN from am_pract_type where pract_type not in (select pract_type from mr_term_set_for_pract_type where term_set_id ='"+term_set_id+"') and eff_status='E' ");
	if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(desc_userdef) LIKE Upper('"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
		sql.append(" and Upper(desc_userdef) LIKE Upper('%"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
		sql.append(" and Upper(desc_userdef) LIKE Upper('%"+pract_type_text+"')");
	
	sql.append(" union all select  a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action,a.DFLT_TERM_SET_YN from mr_term_set_for_pract_type a, am_pract_type b where a. term_set_id = '"+term_set_id+"' and b. pract_type = a.pract_type ");
	if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(b.desc_userdef) LIKE Upper('"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
		sql.append(" and Upper(b.desc_userdef) LIKE Upper('%"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
		sql.append(" and Upper(b.desc_userdef) LIKE Upper('%"+pract_type_text+"')");

	sql.append(" order by 2");
//out.println("sql2 "+sql.toString());
	
	try{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());

	}catch(Exception e){/* out.println(e); */e.printStackTrace();}

	if (start != 0){
		for(int j=1; j<=start; i++,j++){
			rs.next() ;
		}
	}

while(i<=end && rs.next() ){ 

	if(maxRecord == 0)
			{
%>
		<body  OnMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
		<form name='formPractitionerResult' id='formPractitionerResult' action='../../eMR/jsp/TerminologySetForPractitionerTypeDetail.jsp' method='post' >

		<table  width='90%' border='0' align='center'>
		<tr>
		<!--<td align='right' class='NONURGENT'>-->
		<input type=hidden name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
		<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
		<input type=hidden name='from' id='from' value='<%=start%>'>
		<input type=hidden name='to' id='to' value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type=hidden name='pract_type_text' id='pract_type_text' value='<%=pract_type_text%>'>
		<input type=hidden name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>
			<input type='hidden' name='allValues' id='allValues' value=''>
		<input type='hidden' name='selectCHk' id='selectCHk' value='<%=selectCHk%>'>

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
		</tr>
		</table>
		<br>
		<br>
		</tr>
		</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
		<tr><td width='60%' class="COLUMNHEADER"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
		<td width='20%' class='COLUMNHEADERCENTER' ><fmt:message key="eMR.DefaultTermSet.label" bundle="${mr_labels}"/></td>
		<td width='20%' class='COLUMNHEADERCENTER' ><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='selectall' id='selectall' <%=selectCHkChecked%> onClick='selectAll(this,<%=start%>,<%=end%>)'></td></tr>
<%	 
			}
//recordCount =TerminologySetForPractitionerType.getSize();
/*if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}*/
	//while(rs.next() && i<=end){ 
		String pract_type=rs.getString("pract_type");
		String pract_type_desc=rs.getString("pract_type_desc");
		dflt_term_set_yn=rs.getString("DFLT_TERM_SET_YN");
		//out.println("<script>alert('"+TerminologySetForPractitionerType1.getObject(i)+"')</script>");
		
		if(TerminologySetForPractitionerType.containsObject(pract_type))  
			chkAttribute = "CHECKED";
		else
			chkAttribute="";
		
		int recordIndex = TerminologySetForPractitionerType.indexOfObject(pract_type);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    TerminologySetForPractitionerType.removeObject(recordIndex);
	
		if(TerminologySetForPractitionerType1.containsObject(pract_type)){  
			dftchkAttribute = "CHECKED";
		}
		else
			dftchkAttribute="";
		
	
		int dftrecordIndex = TerminologySetForPractitionerType1.indexOfObject("dftselect"+i);
		if(dftrecordIndex!=-1)
			if(dftchkAttribute.equals("CHECKED"))
			TerminologySetForPractitionerType1.removeObject(dftrecordIndex);

		disable_yn="";
		if(TerminologySetForPractitionerType2.containsObject(pract_type))
		{
	
				disable_yn = "disabled";
	
		}		
		else
			{
			disable_yn="";
			}

			if( i%2 == 0)  classValue="QRYEVEN";
			else
			classValue="QRYODD";
		%>
		<tr>
		<td class='<%=classValue%>'><%=pract_type_desc%></td>
		<td align='center' class='<%=classValue%>'><input type='checkbox' name='dftselect<%=i%>' id='dftselect<%=i%>'      onclick='SelectDefaultChk(this, <%=i%>)' value='<%=pract_type%>' <%=dftchkAttribute%> <%=disable_yn %> ><input type='hidden' name='dftremoveCode<%=i%>' id='dftremoveCode<%=i%>' value="N"><input type='hidden' name='dftpractTypeCode<%=i%>' id='dftpractTypeCode<%=i%>' value="<%=pract_type%>"></td>

		<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='select<%=i%>'  value='<%=pract_type%>'  onclick="RemSelectAll(this, <%=i%>);"><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='practTypeCode<%=i%>' id='practTypeCode<%=i%>' value="<%=pract_type%>"></td>
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
			
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			%>
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				parent.frames[1].location.href='../../eCommon/html/blank.html';
				</script>
			<%
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
	if(stmt4 != null){ stmt4.close(); }
	
// End of Addition on 25/07/2003 for closing ResultSet & Statements which are not closed properly.
	ConnectionManager.returnConnection(con,request);
	session.setAttribute("TerminologySetForPractitionerType", TerminologySetForPractitionerType);
	session.setAttribute("TerminologySetForPractitionerType1", TerminologySetForPractitionerType1);
	
}
%>
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

