<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  language="java" contentType="text/html;charset=UTF-8"  import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<jsp:useBean id="PractitionerSpeciality" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript" src="../js/CustomListTerminologyGroup.js"></script>
 </head>
 <%
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String term_set_id		= checkForNull(request.getParameter("term_set_id"));
	String mode				= checkForNull(request.getParameter("mode"));
	String term_grp_id		= checkForNull(request.getParameter("term_grp_id"));
	String index_type		= checkForNull(request.getParameter("index_type"));
	String from				= checkForNull(request.getParameter("from")) ;
    String to				= checkForNull(request.getParameter("to")) ;   
	//String eff_status		= checkForNull(request.getParameter("effect_status")) ; 
	String flagSelect		= checkForNull(request.getParameter("fromSearch"));
	String function_name	= checkForNull(request.getParameter("function_name"));
	String search_criteria  = checkForNull(request.getParameter("search_criteria")) ;	
	String index_desc       = checkForNull(request.getParameter("index_desc")) ;	
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	StringBuffer sqlQuery	= new StringBuffer();
	String	classValue		= "";
	String code				= "";
	String desc				= "";
	int maxRecord = 0;
    int start = 0 ;
    int end = 0 ;
    int i=1;
	String req_start		= "", req_end	= "";
	String checkBoxAttribute  = "";
	String checkedOnes       = "";
	String removeCode = "";
	try
	{
		if (from == null || from.equals("")){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null ||  to.equals("")){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }  

		req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
		req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

		

		/*if(mode!=null && mode.equals("2"))
		{
			function_name	= "modify";
		}
		else
		{
			function_name	= "insert";
		}*/
			
		con = ConnectionManager.getConnection(request);
		

		if(flagSelect !=null && !flagSelect.equals(""))
       	{
      		PractitionerSpeciality.clearAll();
			StringBuffer selectedPractitionerSpecialityQuery = new StringBuffer();
			if(index_type!=null && index_type.equals("S"))
			{
				selectedPractitionerSpecialityQuery.append("SELECT a.SPECIALITY_CODE , a.SHORT_DESC FROM AM_SPECIALITY a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.SPECIALITY_CODE= b.SPECIALITY_CODE AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' ");
				//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
				if(search_criteria!=null && search_criteria.equals("S"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.SHORT_DESC) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.SHORT_DESC) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.SHORT_DESC) like Upper('%"+index_desc+"')");
				selectedPractitionerSpecialityQuery.append(" order by a.SHORT_DESC");
			}
			else
			{
				selectedPractitionerSpecialityQuery.append("SELECT a.PRACTITIONER_ID , a.PRACTITIONER_NAME FROM AM_PRACTITIONER a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.PRACTITIONER_ID= b.PRACTITIONER_ID AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' "); 
				//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
				if(search_criteria!=null && search_criteria.equals("S"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.PRACTITIONER_NAME) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.PRACTITIONER_NAME) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.PRACTITIONER_NAME) like Upper('%"+index_desc+"')");
				
				selectedPractitionerSpecialityQuery.append(" order by a.PRACTITIONER_NAME");
			}
			
			//out.println("<script>alert(\""+selectedPractitionerSpecialityQuery.toString()+"\");</script>");
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectedPractitionerSpecialityQuery.toString());
			if(rs !=null)
			{
				while(rs.next())
				{
					PractitionerSpeciality.putObject(rs.getString(1));
					function_name	= "modify";
				 }
			}

			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}

		 if(from != null && to != null)
        {
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("chk"+(i)) != null)
				{
					checkedOnes = request.getParameter("chk"+(i));
					if(!(PractitionerSpeciality.containsObject(checkedOnes)))
					{
						//out.println("<script>alert(\""+checkedOnes+"\");</script>");
						PractitionerSpeciality.putObject(checkedOnes);
					}
					j++;
				}

				removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))
				{
					String nu_pract_Code = request.getParameter("Code"+(i));
					if((PractitionerSpeciality.containsObject(nu_pract_Code)))
					{
						int removeCodeIndex = PractitionerSpeciality.indexOfObject(nu_pract_Code);
							PractitionerSpeciality.removeObject(removeCodeIndex);
					}
				}
			}			
		}

		if(index_type!=null && index_type.equals("S"))
		{
			//if(mode!=null && mode.equals("2"))
				//sqlQuery.append("SELECT a.SPECIALITY_CODE , a.SHORT_DESC FROM AM_SPECIALITY a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.SPECIALITY_CODE= b.SPECIALITY_CODE AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' ");
			//else
				sqlQuery.append("select SPECIALITY_CODE,SHORT_DESC from AM_SPECIALITY ");
				if(search_criteria!=null && search_criteria.equals("S"))
					sqlQuery.append("where Upper(SHORT_DESC) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					sqlQuery.append("where Upper(SHORT_DESC) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					sqlQuery.append("where Upper(SHORT_DESC) like Upper('%"+index_desc+"')");
				sqlQuery.append("order by SHORT_DESC");
		}
		else if(index_type!=null && index_type.equals("P"))
		{
			//if(mode!=null && mode.equals("2"))
				//sqlQuery.append("SELECT a.PRACTITIONER_ID , a.PRACTITIONER_NAME FROM AM_PRACTITIONER a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.PRACTITIONER_ID= b.PRACTITIONER_ID AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' ");
			//else
				sqlQuery.append("select PRACTITIONER_ID,PRACTITIONER_NAME from AM_PRACTITIONER  ");
				if(search_criteria!=null && search_criteria.equals("S"))
					sqlQuery.append("where Upper(PRACTITIONER_NAME) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					sqlQuery.append("where Upper(PRACTITIONER_NAME) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					sqlQuery.append("where Upper(PRACTITIONER_NAME) like Upper('%"+index_desc+"')");
				sqlQuery.append("order by PRACTITIONER_NAME ");
		}
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlQuery.toString());
//		out.println(sqlQuery);
		i = 1 ; 

		if(rs!=null)
		{
			if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
		}

		//while(i<=end && rs.next()){ 
		
 %>
 <!-- Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018 -->
<body  OnMouseDown="CodeArrest();"  class='CONTENT' onLoad="chkForSelectAll(<%=start%>,<%=end%>,'<%=search_criteria%>','<%=index_desc%>')" onKeyDown='lockKey()'>
<form name='customTerminologyGroupResultForm' id='customTerminologyGroupResultForm' action='../../eMR/jsp/CustomListTerminologyGroupAddModifyDetail.jsp' method='post' >
<%
	// while(rs!=null && rs.next()){ 
	 while(i<=end && rs.next()){ 
			if(maxRecord == 0)
			{
				%>
<table  width='90%' border=0 align='center'>
	<table  align='right'>
	<tr>
	<%
		
			if ( !(start <= 1)) {
			out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	%>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>

	<%
		}
			out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	%>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
		</tr>
		</table>
		<br>
		<br>
		</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
		<tr>
		<% if(index_type!=null && index_type.equals("S"))
				{
		%>
			<td width='60%' class="COLUMNHEADER"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<%
				}
			else if(index_type!=null && index_type.equals("P"))
				{
		%>
			<td width='60%' class="COLUMNHEADER"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<%
				}
		%>
			<!--//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018 -->
			<td width='20%' class='COLUMNHEADERCENTER'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick="selectAll(this,<%=start%>,<%=end%>,'<%=search_criteria%>','<%=index_desc%>')" ></td></tr>


	<%
			}
			code=rs.getString(1);
						
			desc=rs.getString(2);

			if(PractitionerSpeciality.containsObject(code)) 
		 		checkBoxAttribute = "CHECKED";
		 	else
				checkBoxAttribute="";
			//out.println("<script>alert(\""+checkBoxAttribute+"\");</script>");
			int recordIndex = PractitionerSpeciality.indexOfObject(code);
			//out.println("<script>alert(\""+recordIndex+"\");</script>");
	
			if(recordIndex!=-1)
				if(checkBoxAttribute.equals("CHECKED"))   
					PractitionerSpeciality.removeObject(recordIndex);
	
			//out.println("<script>alert(\""+checkBoxAttribute+"\");</script>");
			if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=desc%></td>
				<td align='left' class='<%=classValue%>'><input type='checkbox' name='chk<%=i%>' id='chk<%=i%>'  onclick='RemSelectAll();setCheckUncheck(this,"<%=i%>");' <%=checkBoxAttribute%> value='<%=code%>'>
				<input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='Code<%=i%>' id='Code<%=i%>' value="<%=code%>">
				<!--<input type='hidden' name='code<%=i%>' id='code<%=i%>'  value='<%=code%>'>--></td>
			</tr>
			<%
				i++;
				maxRecord++;
		}

		if(maxRecord == 0)
		{
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>enableCriteria();</script>");
		}
		if ( maxRecord < 12 || (!rs.next()) )
				{
					%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<% 
				}
				else
				{%>
					<script>
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
				<%
				}		
	%>
	<input type='hidden' name='function_name' id='function_name' value='<%=function_name%>'>
	<input type=hidden name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
	<input type=hidden name='term_grp_id' id='term_grp_id' value='<%=term_grp_id%>'>
	<input type=hidden name='index_type' id='index_type' value='<%=index_type%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>
	<input type=hidden name='from' id='from' value='<%=start%>'>
	<input type=hidden name='to' id='to' value='<%=end%>'>
	<input type=hidden name='mode' id='mode' value='<%=mode%>'>
	<input type='hidden' name='max_record' id='max_record' value='<%=maxRecord%>'>
	<input type='hidden' name='index_desc' id='index_desc' value='<%=index_desc%>'>
	<!-- FOR 17211:-- modified by Venkats Modified on 15/12/09-->
	<input type='hidden' name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>
	</table>
	</form>
	<script>
			//if('<%=mode%>'==2)
				//document.forms[0].chkAll.onclick();	
	</script>
	</body>
	<%
	}
	catch(Exception e)
	{
		//out.println("Exception in CustomListTerminologyGroupAddModifyDetail page:"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("PractitionerSpeciality", PractitionerSpeciality);
	}		
	%>	

 </html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>


