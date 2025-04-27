<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
          request.setCharacterEncoding("UTF-8");
          String sStyle	=         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'; class='CONTENT'>");

	String whereClause = request.getParameter("whereclause");
	String sql ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql = "";
		String cd = request.getParameter("function_id");
		String longname=request.getParameter("function_name");
	
		String moduleid = request.getParameter("module_id");
	
		int andCheck = 0;

	
		if ( !(cd == null || cd.equals("")) )
		{
			sql = "where upper(function_id) like upper('"+cd+"%')";
			andCheck = 1;
		}
		if ( !(longname == null || longname.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql = sql + " and ";
				sql = sql + " upper(function_name) like  upper('"+longname+"%') " ;
			}
			else 
			{	
				sql = "where upper(function_name)  like upper('"+longname+"%') " ;
				andCheck = 1;
			}
		}
	
		if ( !(moduleid == null || moduleid.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql = sql + " and ";
				sql = sql + " upper(module_name)  like  upper('"+moduleid+"%') " ;
			}
			else 
			{	
				sql = "where upper(module_name)  like upper('"+moduleid+"%') " ;
				andCheck = 1;
			}
		}	
	
	
	
		
//appending order by clause 
	
		String ord[] = request.getParameterValues("orderbycolumns");
		
		if ( !(ord == null || ord .equals("")) )
		{	
			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ )
		 	{	
			 	if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else 
				sql=sql+ord[i]+",";
			}
		}
	} //end of where clause IF
	else 
		sql = whereClause;
	
	int start = 0 ;       
	int end = 0 ;
	int i=1;
		
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ; 
	
	if ( to == null )
	  	end = 14 ;
	else 
		end = Integer.parseInt( to ) ;


Connection conn=null;
try{
	conn = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rs = null ;

try{
		int cnt = 0;
		String endOfRes="1";
	stmt = conn.createStatement();
	/*int maxRecord = 0;
	rs = stmt.executeQuery("select count(*) as total from sm_function_vw "+sql);
	rs.next();
	maxRecord = rs.getInt("total");
	if(rs!=null) rs.close();
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");*/

	rs = stmt.executeQuery("select * from sm_function_vw "+sql);
		if ( start != 1 )
 		for( int j=1; j<start; i++,j++ )
			 rs.next() ;
	  String classValue = "" ;
	  
	  while ( i<=end  && rs.next()){
		  if(cnt==0){

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eSM/jsp/querySmFunction.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if (endOfRes.equals("1"))
	out.println("<A id='nextval' HREF='../../eSM/jsp/querySmFunction.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
</p>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='20%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Function.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/></th> 
<th><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Insert.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Update.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.print.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.query.label" bundle="${common_labels}"/></th>

<%}

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("module_name"); 
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("function_id") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("function_name") );
	out.println("</td><td align='center' class='" + classValue + "'>");
	
	if ( rs.getString("insert_access_yn").equals("Y") )  
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else  

		out.println("&nbsp;");
	
	
	out.println("</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("update_access_yn").equals("Y") )  
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else  

		out.println("&nbsp;"); 
	
	
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("delete_access_yn").equals("Y") )  
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else  

		out.println("&nbsp;");
		
	
		
	out.println("</td><td align='center' class='" + classValue + "'>");	

	if ( rs.getString("print_access_yn").equals("Y") )  
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else  

		out.println("&nbsp;");
			
	
	
	
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("query_only_access_yn").equals("Y") )  
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else  

		out.println("&nbsp;");
				
	i++;
				cnt++;
	} 
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById("nextval").innerHTML=" ";
		</script>
	<%}
	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;

%>

</td></tr>
</table>
<br><center>

<%
}
catch ( Exception e ){}

finally{
	
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	
	}
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}

%>

</center>
</BODY>
</HTML>



