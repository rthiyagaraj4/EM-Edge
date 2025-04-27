<!DOCTYPE html>
 <!-- AgeGroupForTermCodeDetail.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Created By		:	Suchilagna panigrahi
*	Created On		:	7 Feb 2005
--%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.*,webbeans.eCommon.* " %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper"%>
<jsp:useBean id="AgeGroupForTermCode" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
			
	
	<script language="JavaScript" src="../js/AgeGroupForTermCode.js"></script>
<% 
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;String classValue="";
	String term_set_id="";
	//String checked="";
	String type="";
	String term_code_desc="";
	String age_group_code="";
	String sql_associated="";
	String term_code="" , short_desc="";
	String search_criteria="" , search_text="" ;
	Statement stmt_Associated=null;
	
	ResultSet rset_Associated=null ;
	/*
		This logic for the defaulted the values which is already select in deffirent age group of same termset
	*/

	List listTermCode=(ArrayList)session.getAttribute("compareTermCode");

	Set set = new HashSet();
	List newListTermCode = new ArrayList();
	 for (Iterator iter = listTermCode.iterator();    iter.hasNext(); ) {
	 Object element = iter.next();
	   if (set.add(element))
		  newListTermCode.add(element);
			}

	/*
		End here 
	*/


	try{
	con = ConnectionManager.getConnection(request);

term_set_id=request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
age_group_code=request.getParameter("age_group_code")==null ? "":request.getParameter("age_group_code");
type=request.getParameter("type")== null?"":request.getParameter("type");
term_code_desc=request.getParameter("term_code_desc")== null ? "":request.getParameter("term_code_desc");
search_criteria=request.getParameter("search_criteria") == null ? "": request.getParameter("search_criteria");
if(search_criteria.equals("S"))
				 search_text = term_code_desc +"%";
     else if(search_criteria.equals("E"))
             	 search_text ="%"+term_code_desc;
   	 else if(search_criteria.equals("C"))
   		   		 search_text = "%"+term_code_desc+"%";
   	 else
                 search_text = "%";
	String from = request.getParameter("from");
	String to = request.getParameter("to") ;
	int flag=0;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
        
        String chkAttribute="" ,disabled="";
        String dbaction="";
        String  req_start   =   "", req_end     =   "";
		/* Removed for Check Style correction 
		String db_action="";
		*/
       boolean isRecordFound = false;

        req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
        req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
		String alphalink = request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		if(alphalink.equals("*"))
				{
					alphalink="_";
				}
%>
		</head>
		<body  onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
		<form name='form_AgeGrupdetail' id='form_AgeGrupdetail' action="../../servlet/eMR.AgeGroupForTermCodeServlet" target="messageFrame" method='post' >
	
<%	
		ArrayList TabList		= null;

		ArrayList sessionList			=  (ArrayList)AgeGroupForTermCode.getRecordSetHandle();
		if(sessionList.size()>0)
		{
			TabList=(ArrayList)AgeGroupForTermCode.getObject(0);
		}
		if(alphalink.equals("Associated"))
		{
						
			 sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,'U' db_action FROM mr_age_grp_for_term_code a, mr_term_code b WHERE a.age_group_code = '"+age_group_code+"' and  b.term_set_id = '"+term_set_id+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' )) and upper(short_desc) like upper('"+search_text+"') ORDER BY 3";
		}
		else
		{
			 sql_associated="select term_set_id, term_code, short_desc, 'I' db_action from mr_term_code where term_set_id = '"+term_set_id+"' and (( '"+type+"' = 'PR' and procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and diagnosis_yn = 'Y')) and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) and (term_set_id, term_code) not in (select term_set_id,term_code from mr_age_grp_for_term_code where age_group_code = '"+age_group_code+"') union all select a.term_set_id, a.term_code, b.short_desc ,'U' db_action from mr_age_grp_for_term_code a, mr_term_code b where a.age_group_code = '"+age_group_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' )or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' )) and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) order by 3 ";  
	
		}
		
		stmt_Associated=con.createStatement();
		rset_Associated=stmt_Associated.executeQuery(sql_associated);
		if (start != 0){
		for(int j=1; j<=start; i++,j++){
			rset_Associated.next() ;
		}
	}

	
	
		while(i< end && rset_Associated.next() ){
            isRecordFound=true;
			term_code = rset_Associated.getString("term_code");
			short_desc=rset_Associated.getString("short_desc");
			dbaction=rset_Associated.getString("db_action");

if (maxRecord==0)
		{
		%>
		<br><br>
		<table align='right'>
		<tr>
		<!--<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>-->
	<%
	    if ( !(start <= 1)) {	
		out.println("<td align ='right' id='prev' ><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	    }
	    //if ( !((start+12) >= maxRecord )){
	    out.println("<td align ='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	
	   //}
	%>
		</tr>
		</table><br><br>
		
		<table border='1' cellpadding='0' cellspacing='0' align='center'  width='80%' >
			<tr>
			<td width='100%' colspan='2' class="COLUMNHEADER"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			</tr>			

<%
		}		
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
							
			if(dbaction.equals("U")){
				if(alphalink.equals("Associated"))
						disabled="";
				else
					disabled="Disabled";
			}
			
			if(TabList.contains(term_code))
			{
				chkAttribute="checked";
			}
			else
				chkAttribute="";

			/*
			Disableing field which is alredy defaulted
			*/
				String legDisabled="";
			if(newListTermCode.contains(term_code))
				legDisabled="Disabled";
			else
				legDisabled="";
				/*
				End here 
				*/
			
%>
			<tr>
				<td class='<%=classValue%>' align="left"><%=short_desc%></td>
				<td class='<%=classValue%>'><input type='checkbox' name='<%=alphalink%>chk<%=i%>' id='<%=alphalink%>chk<%=i%>'  value='<%=term_code%>' <%=chkAttribute%> <%=disabled%> <%=legDisabled%> onclick="updateValue(this);setchkAll(this);"></td>
			</tr>

	<%
			i++;
			chkAttribute="";
			disabled="";
			if(TabList.size()>0)
				flag=1;
	
			maxRecord++;
		}

		if(isRecordFound==false)
		{
		     out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			 out.println("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'</script>");
		}

		if ( maxRecord < 12 || (!rset_Associated.next()) )
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
			
	
%>	
	<input type=hidden name=from value='<%=start%>'>
	<input type=hidden name=to value='<%=end%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>
	<input type='hidden' name='term_code' id='term_code' value="<%=term_code%>" >
	<input type='hidden' name='function_name' id='function_name' value=''>
	<input type='hidden' name='maxRecords' id='maxRecords' value='<%=maxRecord%>'>
	<input type='hidden' name="age_group_code" id="age_group_code" value='<%=age_group_code%>'>
	<input type='hidden' name="term_set_id" id="term_set_id" value='<%=term_set_id%>'>
	<input type='hidden' name="type" id="type" value='<%=type%>'>
	<input type='hidden' name="alphalink" id="alphalink" value='<%=alphalink%>'>
	<input type='hidden' name="flag" id="flag" value='<%=flag%>'>

	</table>
		<%
	}catch(Exception e){
		e.printStackTrace();}
				finally { 
	if(rset_Associated!=null) rset_Associated.close();
	if(stmt_Associated!=null) stmt_Associated.close();

		ConnectionManager.returnConnection(con,request);
		session.setAttribute("AgeGroupForTermCode", AgeGroupForTermCode);
	}	
	%>
	
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

