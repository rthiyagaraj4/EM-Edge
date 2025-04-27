<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,java.net.*" %>

<html>

	<head>
	
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eOA/js/WaitlistCategoryForSplty.js' language='javascript'></script>
	</head>

 		
		<%
		request.setCharacterEncoding("UTF-8");
			Connection	con			        = null;
			String whereClause = request.getParameter("whereclause");					
			String waitlist_category_code		= "";
			String waitlist_category_desc		= "";
			String specialty_code				= "";
			String specialty_desc		        = "";
			StringBuffer sql		=new StringBuffer();
			String from = request.getParameter( "from" ) ;
            String to = request.getParameter( "to" ) ;
			StringBuffer strsql2=new  StringBuffer();
			String locale = (String)session.getAttribute("LOCALE");
			
		
		
		%>

	<body  id='b' onKeyDown = 'lockKey()'>
	
		<%
		
		waitlist_category_code			= checkForNull(request.getParameter("WAITLIST_CATEGORY_CODE"));
		waitlist_category_desc			= checkForNull(request.getParameter("WAITLIST_CATEGORY_DESC"));
		specialty_code=checkForNull(request.getParameter("SPECIALTY_CODE"));
		specialty_desc=checkForNull(request.getParameter("SPECIALTY_DESC"));
		
		
if ( (whereClause == null || whereClause.equals("")) )
	{

    int andCheck = 0;
		if ( !(waitlist_category_code == null || waitlist_category_code.equals("")) )
		{ 
			sql.setLength(0);
		sql.append("where upper(waitlist_category_code) like upper('"+waitlist_category_code+"%')");
		andCheck = 1;
		} 

		if ( !(waitlist_category_desc == null || waitlist_category_desc.equals("")) )
		{
				if ( andCheck == 1 )
				{	sql.append(" and upper(oa_get_desc.OA_WAITLIST_CATEGORY(WAITLIST_CATEGORY_CODE,'"+locale+"','1'))  like  upper('"+waitlist_category_desc+"%') "); 
				}
				else
				{
					sql.setLength(0);
					 sql.append("where upper(oa_get_desc.OA_WAITLIST_CATEGORY(WAITLIST_CATEGORY_CODE,'"+locale+"','1'))  like upper('"+waitlist_category_desc+"%') ") ;
					 andCheck = 1;
				}
		}

		if ( !(specialty_code == null || specialty_code.equals("")) )
		{
				if ( andCheck == 1 )
				{	sql.append(" and upper(specialty_code)  like  upper('"+specialty_code+"%') "); 
				}
				else
				{
					sql.setLength(0);
					 sql.append("where upper(specialty_code)  like upper('"+specialty_code+"%') ") ;
					 andCheck = 1;
				}
		}

		if ( !(specialty_desc == null || specialty_desc.equals("")) )
		{
				if ( andCheck == 1 )
				{	sql.append(" and upper(am_get_desc.am_speciality(SPECIALTY_CODE,'"+locale+"','1'))  like  upper('"+specialty_desc+"%') "); 
				}
				else
				{
					sql.setLength(0);
					 sql.append("where upper(am_get_desc.am_speciality(SPECIALTY_CODE,'"+locale+"','1'))  like upper('"+specialty_desc+"%') ") ;
					 andCheck = 1;
				}
		}

	//appending order by clause
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
	} //end of where clause IF
	else{
		sql.append(whereClause);

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
	Statement stmt=null;
    ResultSet rs=null;
    int maxRecord = 0;

try{
		con=ConnectionManager.getConnection(request);


		stmt = con.createStatement();
		strsql2.append("select WAITLIST_CATEGORY_CODE,oa_get_desc.OA_WAITLIST_CATEGORY(WAITLIST_CATEGORY_CODE,'"+locale+"','1') WAITLIST_CATEGORY_DESC,SPECIALTY_CODE,am_get_desc.am_speciality(SPECIALTY_CODE,'"+locale+"','1') SPECIALTY_DESC from OA_WL_CATEGORY_FOR_SPLTY "+sql.toString());
		rs = stmt.executeQuery(strsql2.toString());
	


	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  while ( rs.next() && i<=end )
	{
		  if(maxRecord==0)
		{
%>

<P>
<table align='right'>
<tr >
<%
if ( !(start <= 1) )
	{
	out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/WaitlistCategoryForSpltyQryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
	}

//if ( !( (start+14) > maxRecord ) )
	{
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/WaitlistCategoryForSpltyQryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	}
%>
</tr>
</table>
	<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='COLUMNHEADER'><fmt:message key="eOA.WaitlistCategoryCode.label" bundle="${oa_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="eOA.WaitlistCategoryDescription.label" bundle="${oa_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="eMP.SpecialityDesc.label" bundle="${mp_labels}"/></td>

<% }
 	
	  String classValue = "" ;

if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("WAITLIST_CATEGORY_CODE");


	out.println(code+"</td><td class='" + classValue + "' wrap >");
	out.println( rs.getString("WAITLIST_CATEGORY_DESC") );


	out.println("</td>");
	out.println("<td class='" + classValue + "' wrap >");
	out.println( rs.getString("SPECIALTY_CODE") );
	out.println("</td>");


     out.println("<td class='" + classValue + "' wrap >");
	out.println( rs.getString("SPECIALTY_DESC") );
	out.println("</td>");

	i++;
	maxRecord++;
sql.setLength(0);

	
  }//endwhile

	if(maxRecord == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
	<%}

	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% 
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

  if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
}catch(Exception e){
		e.toString();
}
	finally   {
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	ConnectionManager.returnConnection(con,request);
	

	}
%>

</td></tr>
</table>

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='blue'>
<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
<tr><td width='100%' id='t'></td></tr>
</table>
</div>

<br><center>
</center>
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

