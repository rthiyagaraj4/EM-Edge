<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<jsp:useBean id="icdforDiagGroup" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
    <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<!-- <script language='javascript' src='../js/ICDCodeForTabList.js'></script> -->
	<script language='javascript' src='../js/ICDForDiagGroup.js'></script>

	</head>

<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
        Connection conlConn = null;
        int initCount = 1;
        
        Statement stmt1 = null;
        ResultSet rstlRs1 = null;
        //Statement stmt2 = null;
        //ResultSet rstlRs2 = null;
        
        PreparedStatement stmt3 = null;
        ResultSet rstlRs3 = null;
		String alphadescription="";
		String searchby="";
		String searchcrt="";

 try
 {
	 conlConn = ConnectionManager.getConnection(request);
	 String group_type = request.getParameter("group_type");
	 if(group_type == null) group_type="";
     searchby					= checkForNull(request.getParameter("searchby"));
	 searchcrt					= checkForNull(request.getParameter("searchcrt"));
	 alphadescription				= checkForNull(request.getParameter("alphadescription"));
	 String diag_group_code = request.getParameter("diag_group_code");
		if(diag_group_code == null) diag_group_code="";
	 String selectedAlpha = request.getParameter("selectedAlpha");
		if(selectedAlpha == null) selectedAlpha="";
	String diag_code_scheme = request.getParameter("diag_code_scheme");
		if(diag_code_scheme == null) diag_code_scheme="";
//     String continue_yn = request.getParameter("continue_yn")==null?"":request.getParameter("continue_yn");   
	 
    String flagSelect = request.getParameter("fromSelect");
      	
			if(flagSelect !=null)
        	{
        		icdforDiagGroup.clearAll();
				String sqlinsVals="";
				if (group_type.equals("P")&&diag_code_scheme.equals("3"))
				sqlinsVals= " select cpt_code from mr_proc_group_dtl  where group_type = ? and diag_group_code= ? ";				 
				else
				sqlinsVals= " select diag_srl_no from mr_diag_group_dtl  where group_type = ? and diag_group_code= ? ";

				stmt3=conlConn.prepareStatement(sqlinsVals);
				stmt3.setString(1,group_type);
				stmt3.setString(2,diag_group_code);
				rstlRs3 = stmt3.executeQuery();

			if(rstlRs3 !=null)
			{
				 while(rstlRs3.next())
				 {
					icdforDiagGroup.putObject(rstlRs3.getString(1));
				 }
			}
			
        	}
			//        int recordCount			=	0;
			String  req_start   =   "", req_end     =   "";

			String  checkedOnes         =   "";
			String from = request.getParameter("from") ;
			String to = request.getParameter("to") ;
			int maxRecord = 0;
			int start = 0 ;
			int end = 0 ;
			int i=1;
		
		if (from == null || from.equals("0") ){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }

        req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
        req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

        if(from != null && to != null)
        {
                int j=0;
                for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                {
                    if(request.getParameter("icdCodeNum"+(i)) != null)
                    { 
                        checkedOnes = request.getParameter("icdCodeNum"+(i));
                        if(!(icdforDiagGroup.containsObject(checkedOnes)))
                            icdforDiagGroup.putObject(checkedOnes);

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

 

 /*String sqlCount="";
 if (group_type.equals("P")&&diag_code_scheme.equals("3"))
	 {
	  if(!alphadescription.equals(""))
	   {
		  sqlCount="select count(1)  from mr_cpt_code where ";
		  if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (CPT_CODE) LIKE  upper( '"+alphadescription+"%')";
			}
	   }
	   else{
		if(selectedAlpha.equals("Others"))
			sqlCount="select count(1) from mr_cpt_code where upper(substr(short_desc,1,1)) not between 'A' and 'Z'  order by  short_desc";
		else
			sqlCount="select count(1)  from mr_cpt_code where UPPER (short_desc) like '"+selectedAlpha+"%' order by  short_desc ";
	   }
	 }
else
	 {
		if(!alphadescription.equals(""))
	   {
		  sqlCount="select count(1)  from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and ";
		  if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";
			}
	   }
	   else{
		if(!selectedAlpha.equals("Others"))
			 sqlCount= " select count(1) from  mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and short_desc like '"+selectedAlpha+"%' ";
		else
			 sqlCount= " select count(1) from  mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' ";
	   }
	 }

 stmt2= conlConn.createStatement();
 
 rstlRs2 = stmt2.executeQuery(sqlCount);
 rstlRs2.next();
  maxRecord = rstlRs2.getInt(1);
  if(maxRecord==0)
			{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}*/
	String sql="";
 if (group_type.equals("P")&&diag_code_scheme.equals("3"))
	 {
		if(!alphadescription.equals(""))
	   {
		   sql="select cpt_code diag_code ,short_desc,cpt_code from mr_cpt_code where";
		   if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sql=sql+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (CPT_CODE) LIKE  upper( '"+alphadescription+"%')";
			}
			if(searchby.equals("D"))
				sql=sql+" order by 2";
			else if(searchby.equals("C"))
				sql=sql+" order by 1";
	   }
	   else{
		if(selectedAlpha.equals("Others"))
			sql="select cpt_code diag_code ,short_desc,cpt_code from mr_cpt_code where upper(substr(short_desc,1,1)) not between 'A' and 'Z'  order by  short_desc";
		else
		  sql="select cpt_code diag_code ,short_desc,cpt_code from mr_cpt_code where UPPER (short_desc) like '"+selectedAlpha+"%' order by  short_desc ";
	   }
	 }
else
	 {
		
	   if(!alphadescription.equals(""))
	   {
		   sql="select diag_code ,short_desc,diag_srl_no from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"'   and ";
		   if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sql=sql+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sql=sql+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";
			}
			if(searchby.equals("D"))
				sql=sql+" order by 2";
			else if(searchby.equals("C"))
				sql=sql+" order by 1";
	   }
	   else{
		if(selectedAlpha.equals("Others"))
			sql="select diag_code ,short_desc,diag_srl_no from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and upper(substr(short_desc,1,1)) not between 'A' and 'Z'  order by  short_desc";
		else
		  sql="select diag_code ,short_desc,diag_srl_no from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"'   and UPPER (short_desc) like '"+selectedAlpha+"%' order by  short_desc ";
	   }
	 }

//out.println("sql is:"+sql);
 //stmt1 = conlConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 stmt1 = conlConn.createStatement();
 rstlRs1 = stmt1.executeQuery(sql);

if ( start != 0 )
	{
	 for( int j=1; j<start; i++,j++ ){
	  rstlRs1.next() ;
	  }
	  initCount+=start;
	  --initCount;
	}

 if (maxRecord==0)
			{
%>

	<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();" onKeyDown='lockKey()'>
	<form name='tablistQueryResult' id='tablistQueryResult' method="post" action="../../eMR/jsp/ICDForDiagGroupResult.jsp" action='messageFrame' >	
	
	<table width='100%' border=0 cellspacing=0>
		<%if(alphadescription.equals(""))
	   {%>
	<tr>
		<td colspan='6'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:callMember1('A')">A</a>&nbsp;&nbsp;<a href="javascript:callMember1('B')">B</a>&nbsp;&nbsp;<a href="javascript:callMember1('C')">C</a>&nbsp;&nbsp;<a href="javascript:callMember1('D')">D</a>&nbsp;&nbsp;<a href="javascript:callMember1('E')">E</a>&nbsp;&nbsp;<a href="javascript:callMember1('F')">F</a>&nbsp;&nbsp;<a href="javascript:callMember1('G')">G</a>&nbsp;&nbsp;<a href="javascript:callMember1('H')">H</a>&nbsp;&nbsp;<a href="javascript:callMember1('I')">I</a>&nbsp;&nbsp;<a href="javascript:callMember1('J')">J</a>&nbsp;&nbsp;<a href="javascript:callMember1('K')">K</a>&nbsp;&nbsp;<a href="javascript:callMember1('L')">L</a>&nbsp;&nbsp;<a href="javascript:callMember1('M')">M</a>&nbsp;&nbsp;<a href="javascript:callMember1('N')">N</a>&nbsp;&nbsp;<a href="javascript:callMember1('O')">O</a>&nbsp;&nbsp;<a href="javascript:callMember1('P')">P</a>&nbsp;&nbsp;<a href="javascript:callMember1('Q')">Q</a>&nbsp;&nbsp;<a href="javascript:callMember1('R')">R</a>&nbsp;&nbsp;<a href="javascript:callMember1('S')">S</a>&nbsp;&nbsp;<a href="javascript:callMember1('T')">T</a>&nbsp;&nbsp;<a href="javascript:callMember1('U')">U</a>&nbsp;&nbsp;<a href="javascript:callMember1('V')">V</a>&nbsp;&nbsp;<a href="javascript:callMember1('W')">W</a>&nbsp;&nbsp;<a href="javascript:callMember1('X')">X</a>&nbsp;&nbsp;<a href="javascript:callMember1('Y')">Y</a>&nbsp;&nbsp;<a href="javascript:callMember1('Z')">Z</a>&nbsp;&nbsp;<a href="javascript:callMember1('Others')"><fmt:message key="Common.others.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;</td>
	</tr>
		<%}%>
	</table>
	<table border='0' align='right'>
	<tr>
	
	<%
	    if ( !(start <= 1)) {
	
	    out.println("<td align ='right' id='prev'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	
	
	    }
	   // if ( !((start+12) > maxRecord )){
	
		out.println("<td align ='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	
	    //}
	%>
	
	</tr>
	</table>
	<br>
	<br>
	<table  align='center' cellpadding=0 cellspacing=0 border=1 width='100%'>
	<tr id='header'>
		<th nowrap> <fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></th>
		<th> <fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
		<th> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>
	<% 
			}
	 String classValue = "" ;String diag_srl_no="";
//	recordCount			=	icdforDiagGroup.getSize();

	String chkAttribute="";
	
	/*if ( start != 0 )
	{
	 for( int j=1; j<start; i++,j++ ){
	  rstlRs1.next() ;
	  }
	  initCount+=start;
	  --initCount;
	}*/
	//while(rstlRs1.next() && i<=end ) {

		
		while( i<=end && rstlRs1.next() ) {
	diag_srl_no = rstlRs1.getString(3);
//    out.println(diag_srl_no);
	
	if(icdforDiagGroup.containsObject(diag_srl_no))  
		chkAttribute = "CHECKED";
	else
		chkAttribute="";	
	
	int recordIndex = icdforDiagGroup.indexOfObject(diag_srl_no);
	
	if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    icdforDiagGroup.removeObject(recordIndex);		
	
	if ( i % 2 == 0 )
	classValue = "QRYEVEN" ;
	else
	classValue = "QRYODD" ;
	
	out.println("<tr>");
		out.println("<td class='"+classValue+"' width='5%'>"+checkForNullnb(rstlRs1.getString(1))+"</td>");
		out.println("<td  class='"+classValue+"' width='90%' >"+checkForNullnb(rstlRs1.getString(2))+"</td>");
		out.println("<td align='center' width='5%' class='"+classValue+"' ><input type='checkbox'  "+chkAttribute +" name='icdCodeNum"+initCount+"' id='icdCodeNum"+initCount+"'  value='"+diag_srl_no+"'></td>");
		out.println("</tr>");
	  i++;
	  initCount++;
	  maxRecord++;
	  } 
	  
	  if ( maxRecord < 12 || (!rstlRs1.next()) )
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

		if(maxRecord==0)
			{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
  %>
	<input type='hidden' name='group_type' id='group_type' value='<%=group_type%>' >
	<input type='hidden' name='diag_group_code' id='diag_group_code' value='<%=diag_group_code%>' >
	<input type='hidden' name='selectedAlpha' id='selectedAlpha' value='<%=selectedAlpha%>' >
	<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value='<%=diag_code_scheme%>' >
	<input type=hidden name=from value='<%=start%>'>
	<input type=hidden name=to value='<%=end%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>	
	<input type=hidden name='continue_yn' id='continue_yn' value='Y'>

	  <input type=hidden name='alphadescription' id='alphadescription' value='<%=alphadescription%>'>
		  <input type=hidden name='searchby' id='searchby' value='<%=searchby%>'>
		  <input type=hidden name='searchcrt' id='searchcrt' value='<%=searchcrt%>'>
	</form>
	</body>


</html>
<%    }
catch(Exception e){
       
    }
finally{
           
		try
		{
				if(stmt1 != null){ stmt1.close(); }
				if(rstlRs1 != null){ rstlRs1.close(); }
				//if(stmt2 != null){ stmt2.close(); }
				//if(rstlRs2 != null){ rstlRs2.close(); }
				if(stmt3 != null){ stmt3.close(); }
				if(rstlRs3 != null){ rstlRs3.close(); }
		}
		catch(Exception e){
			//out.println("Exception @ finally "+e.toString());
			e.printStackTrace();
		}
	  session.setAttribute("icdforDiagGroup", icdforDiagGroup);
	  ConnectionManager.returnConnection(conlConn,request);
  }
%>
<%!
    public static String checkForNullnb(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

