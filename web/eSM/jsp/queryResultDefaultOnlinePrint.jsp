<%@ page import="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eSM/js/Report.js' language='javascript'></script>
<script>


function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

function showDefaultOnlinePrint(module_id,module_name,report_id,report_desc,function_id,function_name,dflt_online_print_yn)
{
	var url="../../eSM/jsp/DefaultOnlinePrint.jsp?report_id="+report_id+"&module_id="+module_id+"&func_id="+function_id+"&report_desc="+report_desc+"&module_name="+module_name+"&func_name="+function_name+"&dflt_online_print_yn="+dflt_online_print_yn;
	document.location.href=url;
}


</script>
</head>

<BODY class='CONTENT' onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()' >
<form name="query_result_dflt_online_print" id="query_result_dflt_online_print" >
<%					 
	Connection conn = null;

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");



	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer() ;
	String from  = request.getParameter( "from" ) ;
	String to    = request.getParameter( "to" ) ; 
	String Report_Group_Id="";
	String sel="";
	String module_id = request.getParameter("module_id")==null?"MP":request.getParameter("module_id");
	if(module_id.equals("")){
		module_id="MP";
	}
	String Report_Desc = request.getParameter("Report_Desc")==null?"":request.getParameter("Report_Desc");	 
		String func_name = request.getParameter("func_name")==null?"":request.getParameter("func_name");
		String name=request.getParameter("name");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		if (!Report_Desc.equals("")){
			sql.append(" and upper(d.report_desc) like upper('"+Report_Desc+"%')");
		}
		if (!func_name.equals("")){
			sql.append(" and upper(c.function_name) like upper('"+func_name+"%')");
		}

		String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sql.append(ord[i]);
				}else{
					sql.append(ord[i]);
					sql.append(",");

				}
			}
		}
	}
	else
		{
		sql.setLength(0);
		sql.append(whereClause);
		}
	
	//if(sql.length() > 0) sql.delete(0,sql.length());
	int start = 0 ;       
	int end = 0 ;       
	int i=1;
	String endOfRes="1";
		
	if ( from == null )
	{
		start = 1 ;
	}
	else
	{
		start = Integer.parseInt( from ) ; 
	}
	
	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	ResultSet rs=null;
	PreparedStatement pstmt=null;
try{
	//request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	java.sql.Statement stmt=conn.createStatement();

	String query="SELECT a.report_id report_id, d.report_desc report_desc, b.MODULE_NAME module_name,a.function_id function_id,c.FUNCTION_NAME function_name,a.dflt_online_print_yn  dflt_online_print_yn FROM sm_dflt_online_print a, sm_module b, sm_function c, sm_report d WHERE a.module_id = '"+module_id+"' and a.module_id = b.module_id and a.report_id=d.report_id and a.function_id=c.function_id  "+sql.toString();
	pstmt = conn.prepareStatement(query);
	rs = pstmt.executeQuery();
	int cnt=0;
	
	//rs = stmt.executeQuery(sql.toString()); 

		if ( start != 1 )   
		for( int j=1; j<start; i++,j++ ) 
			rs.next() ;

			 
		while (i<=end && rs.next()) 
		{ 

			if(cnt==0){%>
			
				<p>
					<table align='right' >
					<tr>
					<%
					/*if ( !(start <= 1) )
						out.println("<td class='label' align='right'><A HREF='javascript:submitPrevNext("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
						
					if ( endOfRes.equals("1"))
						out.println("<td class='label' align='right'><A  id='nextval' HREF='javascript:submitPrevNext("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");*/
						%><%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eSM/jsp/queryResultDefaultOnlinePrint.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
			out.println("<A HREF='../../eSM/jsp/queryResultDefaultOnlinePrint.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
						
				
					
					</tr>
					</table>
					</p>
					<br><br>
			

			<table border="2" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
			<th><fmt:message key="Common.Module.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
			 
			
			<% }
 	

			String classValue = "" ;	
			String Rep_Group_Id = "";			 

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
		
 
			String rs_report_desc = rs.getString("report_desc"); 
			String rs_module_name = rs.getString("module_name");              
			String rs_report_id = rs.getString("report_id");        
			String short_desc="";		
			String rs_function_name =rs.getString("function_name"); 		
			String rs_function_id =rs.getString("function_id"); 		
			String rs_dflt_online_print_yn =rs.getString("dflt_online_print_yn"); 		
			%>
			<tr>
			
			<td align='left' class='<%=classValue%>'>		
			<%=rs_module_name%></td>
			<td align='left' class='<%=classValue%>'>		
			<%=rs_function_name%></td>
			<td align='left' class='<%=classValue%>'>		
			<a href="javascript:showDefaultOnlinePrint('<%=module_id%>','<%=rs_module_name%>','<%=rs_report_id%>','<%=rs_report_desc%>','<%=rs_function_id%>','<%=rs_function_name%>','<%=rs_dflt_online_print_yn%>')" ><%=rs_report_desc%></a></td>


				   
				<td align='center' class='<%=classValue%>'>
					  <%if(rs_dflt_online_print_yn.equals("Y")){%>
				  <img src='../../eCommon/images/enabled.gif'></img>
				<%}else{%> 
				  
				 <img src='../../eCommon/images/disabled.gif'></img>
				<%}%>  </td>
				
				

		
				<% 
				i++;
				cnt++;
		}
		if( !rs.next() && cnt!=0 )
		{
			endOfRes="0";
		%>
		<script>		
			if(document.getElementById('nextval'))
			document.getElementById('nextval').innerHTML = " ";
		</script>
		<%
		}
		if( cnt == 0 )
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
			boolean flag = false;
if ( cnt < 14 || (!rs.next()) ) { %>
	<script>
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% flag = true;
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}
		if(rs !=null) rs.close();

		if(pstmt != null) pstmt.close();


		//sql.setLength(0);     
		%>
        
        <input type='hidden'name='maxrecord'value='<%=i%>'>
		<input type='hidden' name='from' id='from' value='<%=from%>'>
		<input type='hidden' name='to' id='to' value='<%=to%>'>
		<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
		<input type='hidden' name='Report_Desc' id='Report_Desc' value='<%=Report_Desc%>'>
		<input type='hidden' name='func_name' id='func_name' value='<%=func_name%>'>
</tr>
</table>
<br><center>
</center>
</form>
</BODY>
</HTML>
<%
   }catch(Exception e){
			e.printStackTrace();
			out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}	
%>

