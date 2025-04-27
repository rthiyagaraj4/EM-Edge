<!DOCTYPE html>
﻿<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eIP/js/IPBkgPatientInstructions.js" language='javascript'></script>
<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'> 

</head>
<script>
</script>
<BODY  class='CONTENT' onLoad='ClearMsg();' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='PatInsForm' id='PatInsForm' action='../../eIP/jsp/PatInsResult.jsp' method='post' >
<%
	
	request.setCharacterEncoding("UTF-8");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String sql="select instruction_id code, instruction_desc description from am_pat_instructions_lang_vw where eff_status = 'E' and LANGUAGE_ID='en' and upper(instruction_id) like upper(?) and upper(instruction_desc) like upper(?) ";
	String searchby=request.getParameter("search_by")==null?"":request.getParameter("search_by");
	String searchtext=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	String searchcriteria=request.getParameter("searchcriteria")==null?"":request.getParameter("searchcriteria");
	String excludeInstns=request.getParameter("excludeInstns")==null?"":request.getParameter("excludeInstns");
	String patInsCount=request.getParameter("patInsCount")==null?"0":request.getParameter("patInsCount");
	String excludeInstnsFormatted="";
	if(excludeInstns!=null && !excludeInstns.equals("")){		
		excludeInstnsFormatted="'"+excludeInstns.replaceAll(",","','");
		excludeInstnsFormatted = excludeInstnsFormatted.substring(0,excludeInstnsFormatted.length()-2);
		sql=sql+" and instruction_id not in ("+excludeInstnsFormatted+") ";
	}
// 	StringBuffer sql = new StringBuffer();
	String from  = request.getParameter( "from" ) ;
	String to    = request.getParameter( "to" ) ;
	String selectedInstns    = request.getParameter( "selectedInstns" ) ;
	if (selectedInstns ==null || selectedInstns.equals("null"))
		selectedInstns="";
	int andCheck = 0;
	
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	String endOfRes="1";
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
	Connection conn = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try{		
			conn=ConnectionManager.getConnection(request);
			stmt=conn.prepareStatement(sql);
			if(searchby.equals("C")){
				if (searchcriteria.equals("S")){					
					stmt.setString(1,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(1,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(1,"%"+searchtext+"%");
				}
				//stmt.setString(1,searchtext+"%");
				stmt.setString(2,"%");
			}else{				
				stmt.setString(1,"%");
				//stmt.setString(2,searchtext+"%");
				if (searchcriteria.equals("S")){
					stmt.setString(2,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(2,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(2,"%"+searchtext+"%");
				}
			}
			rs=stmt.executeQuery();

			String codeArray[]=selectedInstns.split(",");
			String codeChecked="";

			if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }%>
			
					

					<%

					String classValue="";
				while (i<=end  && rs.next()  )
				{ 
					if (maxRecord==0)
				{
				  %>

					<p>
					<table align='right' >
					<tr>
					<%
					if ( !(start <= 1) )
						out.println("<td class='label' align='right'><A HREF='javascript:submitPrevNext("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");//modified for the incident 39911

					if ( endOfRes.equals("1"))
						out.println("<td class='label' align='right'><A  id='nextval' HREF='javascript:submitPrevNext("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");//modified for the incident 39911
					%>
					
					</tr>
					</table>
					</p>
					<br><br>
					<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
					<tr>
					<th><fmt:message key="Common.code.label" bundle="${common_labels}"/> </th>
					<th><fmt:message key="Common.description.label" bundle="${common_labels}"/> </th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> </th>
					</tr>
					<%
						
						
				}

						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						codeChecked="";
						for(int instnId=0;instnId<codeArray.length;instnId++){
							
							if(codeArray[instnId].equals(rs.getString(1))){
								codeChecked="checked";						
								break;
							}
						}
						out.println("<tr><td class='" + classValue + "'><font size='1'>"+rs.getString(1)+"</td>");
						out.println("<td class='" + classValue + "'><font size='1'>"+rs.getString(2)+"</td>");
						out.println("<td class='" + classValue + "'><input type='checkbox' name='patInsChk"+i+"' id='patInsChk"+i+"' onclick='addSelectedIns(this,"+i+");' "+codeChecked+"/></td></tr>");
						out.println("<input type='hidden' name='patInsCode"+i+"' id='patInsCode"+i+"' value='"+rs.getString(1)+"' />");
						

					i++;
					maxRecord++;
				}

				if( !rs.next() && maxRecord!=0 )
						{
							endOfRes="0";
						%>
						<script>		
							if(document.getElementById('nextval'))
							document.getElementById('nextval').innerHTML = " ";
						</script>
						<%
						}
				%><input type='hidden' name='InsCount' id='InsCount' value='<%=maxRecord%>'/>
				<input type='hidden' name='selectedInstns' id='selectedInstns' value='<%=selectedInstns%>'/>
				<input type='hidden' name='excludeInstns' id='excludeInstns' value='<%=excludeInstns%>'/>
				<input type='hidden' name='patInsCount' id='patInsCount' value='<%=patInsCount%>'/>
				<input type='hidden' name='from' id='from' value='<%=from%>'/>
				<input type='hidden' name='to' id='to' value='<%=to%>'/>
				<input type='hidden' name='search_text' id='search_text' value='<%=searchtext%>'/>
				<input type='hidden' name='search_by' id='search_by' value='<%=searchby%>'/>
				<input type='hidden' name='searchcriteria' id='searchcriteria' value='<%=searchcriteria%>'/>
				<%
		
			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			}

			boolean flag = false;
	
			
	}catch(Exception e){ out.println(e);e.printStackTrace();
	}
	finally   
	{
		if(stmt!=null) stmt.close();
		if(rs!=null) 	 rs.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
</form>
</BODY>
</HTML>
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

