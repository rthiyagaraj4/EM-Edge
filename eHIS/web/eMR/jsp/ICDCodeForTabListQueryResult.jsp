<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
     <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language='javascript' src='../js/ICDCodeForTabList.js'></script>
	<script>
	function callchk(obj)
	{
		 if(obj.checked==true)
         {
			obj.value="Y"
	  	}
		else
		{
			
			obj.value="N"
		}
	}
	</script>
    
	</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
        Connection conlConn = null;
//        int initCount = 1;
        
        //java.sql.Statement stmt		= null;
        //ResultSet rstlRs	= null;
        java.sql.Statement stmt1		= null;
        ResultSet rstlRs1	= null;
       // PreparedStatement stmt2		= null;
        //ResultSet rstlRs2	= null;
        
        //PreparedStatement stmt3		= null;
        //ResultSet rstlRs3	= null;
		int maxRecord = 0;
		String alphadescription="";
		String searchby="";
		String searchcrt="";
	int start = 0 ;
	int end = 0 ;
	String from	= checkForNull(request.getParameter("from"));
	String to	= checkForNull(request.getParameter("to"));

	if (from == null || from == "")
	{ 
		start = 0 ;  
	}   
	else 
	{  
		start = Integer.parseInt( from ) ; 
	}

	if (to == null || to == ""){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }


 try
 {
	 conlConn = ConnectionManager.getConnection(request);
	 String tabulation_list = request.getParameter("tabulation_list");
		if(tabulation_list == null) tabulation_list="";
	String orderBy = request.getParameter("orderBy");
		if(orderBy == null) orderBy="";
		
	searchby					= checkForNull(request.getParameter("searchby"));
	searchcrt					= checkForNull(request.getParameter("searchcrt"));
	alphadescription				= checkForNull(request.getParameter("alphadescription"));	
 

	 String age_spec = request.getParameter("age_spec");
		if(age_spec == null) age_spec="";
		if(age_spec.equals("P")) age_spec="O";
		
	 String selectedAlpha = request.getParameter("selectedAlpha");
		if(selectedAlpha == null) selectedAlpha="";
	String term_set_id = request.getParameter("term_set_id");
		if(term_set_id == null) term_set_id="";

	String diag_code_scheme = request.getParameter("diag_code_scheme");
		if(diag_code_scheme == null) diag_code_scheme="";
        
//           int i=1;
			int j=0;
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
      

	StringBuffer sqlfirst = new StringBuffer();
	StringBuffer sqlsecond = new StringBuffer();
	StringBuffer sqlwherefirst =new StringBuffer();
	StringBuffer sqlwheresecond =new StringBuffer();


	sqlfirst.append("");
	sqlsecond.append("");
	sqlwherefirst.append("");
	sqlwheresecond.append("");

	sqlfirst.append("SELECT NULL TAB_LIST_NO, TERM_CODE, SHORT_DESC, 'N' CHKD FROM MR_TERM_CODE WHERE TERM_SET_ID = '"+term_set_id+"' AND ");

	sqlsecond.append(" AND (TERM_SET_ID, TERM_CODE) NOT IN ( SELECT TERM_SET_ID, TERM_CODE FROM MR_TERM_CODE_FOR_TAB_LIST WHERE TAB_LIST_NO ='"+tabulation_list+"') UNION SELECT A.TAB_LIST_NO, B.TERM_CODE, B.SHORT_DESC, 'Y' CHKD FROM MR_TERM_CODE_FOR_TAB_LIST A, MR_TERM_CODE B WHERE A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND A.TAB_LIST_NO = '"+tabulation_list+"' AND " );
	if(!alphadescription.equals(""))
	{  
		if(searchby.equals("D"))
		{
			if(searchcrt.equals("C"))
				sqlwherefirst.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwherefirst.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwherefirst.append(" UPPER (SHORT_DESC) LIKE  UPPER( '"+alphadescription+"%')");
		}
		else if(searchby.equals("C"))
		{
			if(searchcrt.equals("C"))
				sqlwherefirst.append(" UPPER (TERM_CODE ) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwherefirst.append(" UPPER (TERM_CODE) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwherefirst.append(" UPPER (TERM_CODE) LIKE  UPPER( '"+alphadescription+"%')");
		}
		if(searchby.equals("D"))
		{
			if(searchcrt.equals("C"))
				sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '"+alphadescription+"%')");
		}
		else if(searchby.equals("C"))
		{
			if(searchcrt.equals("C"))
				sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '"+alphadescription+"%')");
		}
	}
	else
	{
		if(selectedAlpha.equals("Others"))
		{

			sqlwherefirst.append(" UPPER(SUBSTR("+orderBy+",1,1)) NOT BETWEEN 'A' AND 'Z' ");
			sqlwheresecond.append(" UPPER(SUBSTR("+orderBy+",1,1)) NOT BETWEEN 'A' AND 'Z' ");
		}
		else
		{
			sqlwherefirst.append(" UPPER("+orderBy+") LIKE '"+selectedAlpha+"%'");
			if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
					sqlwherefirst.append(" AND UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwherefirst.append(" AND UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwherefirst.append(" AND UPPER (SHORT_DESC) LIKE  UPPER( '"+selectedAlpha+"%')");
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
					sqlwherefirst.append(" AND UPPER (TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwherefirst.append(" AND UPPER (TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwherefirst.append(" AND UPPER (TERM_CODE) LIKE  UPPER( '"+selectedAlpha+"%')");
			}

			if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
					sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '"+selectedAlpha+"%')");
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
					sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '"+selectedAlpha+"%')");
			}
		}
	}
	sqlfirst.append(sqlwherefirst);  
	sqlfirst.append(sqlsecond);  
	sqlfirst.append(sqlwheresecond);  
	
	
	sqlfirst.append(" ORDER BY  "+orderBy+" " );
	//stmt1 = conlConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stmt1 = conlConn.createStatement();
	rstlRs1 = stmt1.executeQuery(sqlfirst.toString());
	//rstlRs1.last();
	 //maxRecord  = rstlRs1.getRow();
	//rstlRs1.beforeFirst();
	
	
//		if (maxRecord==0)
//	{

%>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();" onKeyDown = 'lockKey()'>
<form name='tablistQueryResult' id='tablistQueryResult' method="post" action="../../eMR/jsp/ICDCodeForTabListQueryResult.jsp"   >
<%	 if(!alphadescription.equals("")) {} else {%>
	<!--<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>-->
	<table border='1' cellpadding='1' cellspacing='1' width='100%' align='center'>

	<tr>
		<td><a href="javascript:callMember('A')">A</a></td>
		<td><a href="javascript:callMember('B')">B</a></td>
		<td><a href="javascript:callMember('C')">C</a></td>
		<td><a href="javascript:callMember('D')">D</a></td>
		<td><a href="javascript:callMember('E')">E</a></td>
		<td><a href="javascript:callMember('F')">F</a></td>
		<td><a href="javascript:callMember('G')">G</a></td>
		<td><a href="javascript:callMember('H')">H</a></td>
		<td><a href="javascript:callMember('I')">I</a></td>
		<td><a href="javascript:callMember('J')">J</a></td>
		<td><a href="javascript:callMember('K')">K</a></td>
		<td><a href="javascript:callMember('L')">L</a></td>
		<td><a href="javascript:callMember('M')">M</a></td>
		<td><a href="javascript:callMember('N')">N</a></td>
		<td><a href="javascript:callMember('O')">O</a></td>
		<td><a href="javascript:callMember('P')">P</a></td>
		<td><a href="javascript:callMember('Q')">Q</a></td>
		<td><a href="javascript:callMember('R')">R</a></td>
		<td><a href="javascript:callMember('S')">S</a></td>
		<td><a href="javascript:callMember('T')">T</a></td>
		<td><a href="javascript:callMember('U')">U</a></td>
		<td><a href="javascript:callMember('V')">V</a></td>
		<td><a href="javascript:callMember('W')">W</a></td>
		<td><a href="javascript:callMember('X')">X</a></td>
		<td><a href="javascript:callMember('Y')">Y</a></td>
		<td><a href="javascript:callMember('Z')">Z</a></td>
		<td><a href="javascript:callMember('Others')"><fmt:message key="Common.others.label" bundle="${common_labels}"/></a></td>
	</tr>
	</table>
	<%}%>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
	<tr id="prevnext">
				<td align='right' colspan='3'>

	<%	
		if(!(start <= 1)) 
		{	%>
			
			<a align= 'right' id='prev' href='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
			<input type=hidden name='whichPage' id='whichPage' value='prev'>
			
	<%	}
		
		if(((start+14) >= maxRecord ))
		{	%>
			<a align='left' id='next' href='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			<input type=hidden name='whichPage' id='whichPage' value='next'>
			
	<%	}	%>
		</td></tr>


	<tr id='header'>
		<th nowrap>Term Code  </th>
		<th> <fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
		<th> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>
	<% 
//			}
	String classValue = "" ;
//	String diag_srl_no="";
	String chkAttribute="";
	String tab_list="";
	String diag_srlno="";
	String box_value="";
	StringBuffer recVals = new StringBuffer("");
	boolean first = true;
	/*if(maxRecord==0)
	 {
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	 }
	 else{*/
	 int i=1;
	 if(start != 0)
		{
			for(i=1; i<=start; i++)
			{
				rstlRs1.next() ;
			}
		}
			while(rstlRs1.next() && i<=end)
		{
	
	tab_list=rstlRs1.getString("TERM_CODE");
	//diag_srlno=rstlRs1.getString("DIAG_SRL_NO");
	if ( i % 2 == 0 )
	classValue = "QRYEVEN" ;
	else
	classValue = "QRYODD" ;
	%>
	<tr>
		<td class='<%=classValue%>' width="10%"><%=tab_list%></td>
		<td  class='<%=classValue%>' width='82%'> <%=rstlRs1.getString("SHORT_DESC")%></td>
		<%
		if(rstlRs1.getString("CHKD").equals("Y"))
			{
			chkAttribute = "CHECKED";
			 box_value="Y";
			}
		else
			{
			chkAttribute = "";
			box_value="N";
			}
		%>
 
		<td align='center' width='8%' class='<%=classValue%>' >
			<%
			if ( first )
			{
					recVals.append("('");
					first = false;
			}
			recVals.append(diag_srlno+"','");
        if(chkAttribute.equals("CHECKED")){
		%>
		<input type='checkbox'  onclick="callchk(this);" <%=chkAttribute%> name="icdCodeNum<%=i%>" checked value='<%=box_value%>'>
	  	<%}else {%>
		<input type='checkbox'  onclick="callchk(this);" <%=chkAttribute%> name="icdCodeNum<%=i%>" value='<%=box_value%>'>
		<%}%>
			</td>
	    </tr>
			<input type="hidden" name="tab_list_no<%=i%>" id="tab_list_no<%=i%>" value="<%=tab_list%>">
			<input type="hidden" name="diag_srl_no<%=i%>" id="diag_srl_no<%=i%>" value="<%=diag_srlno%>">
			<%
		i++;
		maxRecord++;
	   
	  } 
	  if ( ! first)
	 {
		  recVals.delete(recVals.length()-3,recVals.length()-1);
		  recVals.append(")");
	  }
	  if(maxRecord==0)
	 {
			if(!alphadescription.equals(""))
		    {
			  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			  out.println("<script>parent.frames[1].document.location.href='../../eCommon/html/blank.html';</script>");
			}
			else{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			    out.println("<script>parent.frames[1].document.getElementById(\"header\").style.visibility='hidden';</script>");	
			    out.println("<script>parent.frames[1].document.getElementById(\"prevnext\").style.visibility='hidden';</script>");	
				}
	 }

	 if (maxRecord<14 || (!rstlRs1.next()))
	 {%>
	 <script>
		 if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>

	<% }
	else
		{%>
			<script >
			if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}
	
	
	%>

			 <input type='hidden' name='concat_string' id='concat_string' value=''>
	        <input type='hidden' name='recVals' id='recVals' value="<%=recVals.toString()%>">
			<input type='hidden' name='age_spec' id='age_spec' value='<%=age_spec%>' >
			<input type='hidden' name='tabulation_list' id='tabulation_list' value='<%=tabulation_list%>' >
			<input type='hidden' name='selectedAlpha' id='selectedAlpha' value='<%=selectedAlpha%>' >
			<input type=hidden name='alphadescription' id='alphadescription' value='<%=alphadescription%>'>
			<input type=hidden name='searchby' id='searchby' value='<%=searchby%>'>
			<input type=hidden name='searchcrt' id='searchcrt' value='<%=searchcrt%>'>
			<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value='<%=diag_code_scheme%>' >
			<input type='hidden' name='term_set_id' id='term_set_id' value='<%=term_set_id%>' >
			<input type='hidden' name='orderBy' id='orderBy' value='<%=orderBy%>'>
			<input type='hidden' name='maxRecord' id='maxRecord' value='<%=maxRecord%>'>
			<input type='hidden' name='from' id='from' value='<%=start%>'>
			<input type='hidden' name='to' id='to' value='<%=end%>'>
			<input type='hidden' name='start' id='start' value='<%=start%>'>
			<input type='hidden' name='end' id='end' value='<%=end%>'>

  		</table>
		</td>
	</tr>
</table>
	 
</form>
</body>


</html>
<%    
sqlfirst.setLength(0);
sqlsecond.setLength(0);
sqlwherefirst.setLength(0);
sqlwheresecond.setLength(0);
//sqlCount.setLength(0);
	
}
catch(Exception e){
    	//out.println("Exception @ try "+e.toString());   
		e.printStackTrace();
    }
	finally
	{
		try
		{
		//if(rstlRs != null){ rstlRs.close(); }
		//if(stmt != null){ stmt.close(); }
		if(rstlRs1 != null){ rstlRs1.close(); }		
		if(stmt1 != null){ stmt1.close(); }
		//if(rstlRs2 != null){ rstlRs2.close(); }
		//if(stmt2 != null){ stmt2.close(); }
		//if(rstlRs3 != null)rstlRs3.close();
		//if(stmt3 != null){ stmt3.close(); }
		}
		catch(Exception e){
		//out.println("Exception @ finally "+e.toString());
		e.printStackTrace();
    }
		session.setAttribute("AXSRightRecSet", accessRightRecSet);
		ConnectionManager.returnConnection(conlConn,request);
	}
%>
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


