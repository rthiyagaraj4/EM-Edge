<!DOCTYPE html>
 <%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%

	request.setCharacterEncoding("UTF-8");
	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from 			= request.getParameter("from") ;
	String to 				= request.getParameter("to") ;
	if ( (whereClause == null || whereClause.equals("")) )
	{
		 String inj_category_code	= request.getParameter("inj_category_code");
		 String long_desc			= request.getParameter("long_desc");
		 String oscc_yn				= request.getParameter("oscc_yn");
		 String enabled				= request.getParameter("eff_status");
		 int andCheck 				= 0;
		 // Changing to Upper case and checking
		 inj_category_code		= inj_category_code.toUpperCase();
	
	 if ( !(inj_category_code== null || inj_category_code.equals("")) )
	 {
	  sql.append(" where INJ_CATEGORY_CODE like '"+inj_category_code+"%'");
	  andCheck 	= 1;
	 }
	 
	if ( !(long_desc == null || long_desc.equals("")) )
	 {
	    if ( andCheck == 1 )
	    {
	          sql.append(" and ");
	     	  sql.append(" upper(LONG_DESC) like upper('"+long_desc+"%')");
	    }
	    else
	    {
			 sql.append(" where upper(LONG_DESC) like upper('"+long_desc+"%')");
			 andCheck 	= 1;
	    }
	 }
     if ( !(oscc_yn == null || oscc_yn.equals("")) )
	     {
		   if ( oscc_yn.equals("Y") )
            {
			   
			    sql.append(" where OSCC_YN='Y'");
				andCheck = 1;
			}
			if ( oscc_yn.equals("N") )
            {
			  
			     sql.append(" where OSCC_YN='N'");
			     andCheck = 1; 
			}
			if ( oscc_yn.equals("A") )
            {
			}
		 }
	  if ( !(enabled == null || enabled.equals("")) )
	     {
   	        if ( enabled.equals("E") )
            {
				if ( andCheck == 0 ) 
				 {
					sql.append(" where EFF_STATUS='E'");
					andCheck = 1;
				}
				else
					 sql.append(" and EFF_STATUS='E'");
			}
   			if ( enabled.equals("D") )
			{
			  if ( andCheck == 0 ) 
			   {
					sql.append(" where  EFF_STATUS='D'");
					andCheck = 1; 
				}
	          else
				  sql.append(" and EFF_STATUS='D'");
	       }
   			if ( enabled.equals("B") )
   			{
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
	else 
		{
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

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
	try
	{
      con =  ConnectionManager.getConnection(request);

	  StringBuffer strsql2=new StringBuffer();
	  strsql2.append("select * from AE_INJURY_CATEGORY ");
	  strsql2.append(sql.toString());
      stmt = con.prepareStatement(strsql2.toString()); 
	   rs = stmt.executeQuery();
	  String classValue = "" ;
	  int cnt=0;
	  String endOfRes="1";
	  if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  {
			rs.next() ;
		  }
  
	 while (i<=end && rs.next()){
		if(cnt==0){
%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/InjuryCategoryQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/InjuryCategoryQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='5%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th width='47%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th width='33%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th width='5%'><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></th>
<th width='5%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%}
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String inj_category_code_disp = rs.getString("INJ_CATEGORY_CODE");
	
	out.println("<a href='../../eAE/jsp/addModifyInjuryCategory.jsp?inj_category_code="+inj_category_code_disp+"' target='f_query_add_mod' >");
	out.println(inj_category_code_disp+"</a></td><td class='" + classValue + "'>");
	String long_desc_disp= rs.getString("LONG_DESC");
	out.println(long_desc_disp+"</td><td class='" + classValue + "'>");
	String short_desc_disp = rs.getString("SHORT_DESC");
	out.println(short_desc_disp+"</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("OSCC_YN").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");

    out.println("</td><td align='center' class='" + classValue + "'>");   
	if ( rs.getString("EFF_STATUS").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
	i++;
 	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%} 
 %>
</td></tr>
</table>
<br><center>
</center>
<%
sql.setLength(0);
//strsql1.setLength(0);
strsql2.setLength(0);

if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
			e.printStackTrace();
     }
	finally   
	{
		if(con != null)		 
		ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

