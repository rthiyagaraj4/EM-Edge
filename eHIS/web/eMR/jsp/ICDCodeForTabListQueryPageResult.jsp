<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %><!--oracle.jdbc.driver.*,-->
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
	<script language='javascript' src='../js/ICDCodeForTabList.js'></script>

<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT' >");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
if ( (whereClause == null || whereClause.equals("")) )
{
	sql.append("");
	String tab_list_no = request.getParameter("tab_list_no");
	String short_desc = request.getParameter("short_desc");
	String term_code = request.getParameter("term_code");
	String term_set_id = request.getParameter("term_set_id");
	String title_desc = request.getParameter("title_desc");


	if ( !(tab_list_no == null || tab_list_no.equals("")) )
	{
		sql.append( "and  upper(a.tab_list_no) like upper('"+tab_list_no+"%')");
	}

	if ( !(term_code == null || term_code.equals("")) )
	{
		sql.append( " and ");
		sql.append( " upper(b.term_code)  like  upper('"+term_code+"%') " );
	}

	if ( !(term_set_id == null || term_set_id.equals("")) )
	{
		sql.append( " and ");
		sql.append( " upper(b.term_set_id)  like  upper('"+term_set_id+"%') " );
	}


	if ( !(short_desc == null || short_desc.equals("")) )
		{
				sql.append( " and ");
				sql.append( " upper(c.long_desc)  like  upper( '"+short_desc+"%') " );
		}
		
		//out.println("<script>alert(\"title_desc :"+title_desc+"\");</script>");


	if ( !(title_desc == null || title_desc.equals("")) )
		{
				sql.append( " and ");
				sql.append( " upper(b.short_desc)  like  upper('"+title_desc+"%') " );
				
			
		}


	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
		{
		if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}

}
	else {
			sql.append( whereClause);
	
	}
	
	
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
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;

try{
		conn=ConnectionManager.getConnection(request);
		/*stmt = conn.createStatement();
		String strsql1="select count(*) as total from MR_ICD_FOR_TAB_LIST a,mr_icd_code b,mr_tab_list c where b.DIAG_SRL_NO = a.DIAG_SRL_NO and c.TAB_LIST_NO = a.TAB_LIST_NO " +sql.toString() ;
		
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");

		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
			
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		*/
		//String strsql2="select  a.tab_list_no  ,b.diag_code ,b.short_desc title,c.LONG_DESC short_desc from MR_ICD_FOR_TAB_LIST a,mr_icd_code b,mr_tab_list c where b.DIAG_SRL_NO = a.DIAG_SRL_NO and  c.TAB_LIST_NO = a.TAB_LIST_NO " +sql.toString() ;

		String strsql2="SELECT A.TAB_LIST_NO,B.TERM_SET_ID, B.TERM_CODE, B.SHORT_DESC TITLE, C.LONG_DESC SHORT_DESC FROM MR_TERM_CODE_FOR_TAB_LIST A,MR_TERM_CODE B,MR_TAB_LIST C WHERE A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND C.TAB_LIST_NO = A.TAB_LIST_NO " +sql.toString() ;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				 rs.next() ;
			  }

		while (i<=end && rs.next() )
			{

				if (maxRecord==0)
					{
	
%>
		<P>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/ICDCodeForTabListQueryPageResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ICDCodeForTabListQueryPageResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		%>
		</tr>
		
		</table>
		<br><br>
		</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="eMR.TabListCode.label" bundle="${mr_labels}"/></th>
		<th><fmt:message key="eMR.TabListDescription.label" bundle="${mr_labels}"/></th>
		<th>Term Code</th>
		<th>Term Set</th>
		<th><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
<%
					}
 	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }*/
		String classValue="";
//while ( rs.next() && i<=end )
//{
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;
	out.println("<tr><td  class='" + classValue + "'>");
	String tab_list_no =rs.getString("TAB_LIST_NO");
	String short_desc =rs.getString("SHORT_DESC");
	String term_code =rs.getString("TERM_CODE");
	String term_set_id =rs.getString("TERM_SET_ID");
	String long_desc =rs.getString("TITLE");
	

	out.println(tab_list_no+"</a></td><td  class='" + classValue + "'>");
	out.println(short_desc );
	out.println("</td><td  class='" + classValue + "'>");
	out.println( term_code );
	out.println("</td><td  class='" + classValue + "'>");
	out.println( term_set_id );
	out.println("</td><td  class='" + classValue + "'>");
	out.println(long_desc );
	out.println("</td></tr>");
	i++;
	maxRecord++;
	sql.setLength(0);
			}

			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			if ( maxRecord < 14 || (!rs.next()) )
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
			<%
			}
}
catch(Exception e){ 
		//out.println("Exception "+e.toString());
		e.printStackTrace();
}
finally{
	try
	{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
	}
	catch(Exception e){
	//out.println("Exception @ try "+e.toString());
	e.printStackTrace();
}
ConnectionManager.returnConnection(conn,request);
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

