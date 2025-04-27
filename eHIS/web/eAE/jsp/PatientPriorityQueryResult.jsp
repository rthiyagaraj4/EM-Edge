<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale				        = (String)session.getAttribute("LOCALE");
%>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
 
<%  
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from 			= request.getParameter("from") ;
	String to 				= request.getParameter("to") ;
	
/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	String green      =request.getParameter("green") ;
	String red        =request.getParameter("red") ;
    String yellow     =request.getParameter("yellow") ;
    String unassigned =request.getParameter("unassigned") ;
    //Added By Shanmukh for MMS-DM-CRF-0147 start
	
	String isPriorityZoneAppl=request.getParameter("isPriorityZoneAppl");
	
	

	
/* CRF  SKR-CRF-0021 [IN028173] end  */

	if ( (whereClause == null || whereClause.equals("")) )
	{
		 //sql						= "";
		 String priority_code		= request.getParameter("priority_code");
		 String short_desc			= request.getParameter("short_desc");
		 String long_desc			= request.getParameter("long_desc");
		 String priority_no			= request.getParameter("priority_no");
		 String enabled				= request.getParameter("eff_status");
		 int andCheck 				= 0;
		 // Changing to Upper case and checking
		 priority_code				= priority_code.toUpperCase();
	if( !(locale == null || locale.equals("")) )
	 {
	  sql.append(" where LANGUAGE_ID='"+locale+"'");
	  andCheck	=	1;
	 }
	 
	 if ( !(priority_code== null || priority_code.equals("")) )
	 {
	    if ( andCheck == 1 )
	    {
	          sql.append(" and ");
	     	  sql.append(" PRIORITY_CODE like '"+priority_code+"%'");
	    }
	    else
	    {
			 sql.append(" where PRIORITY_CODE like '"+priority_code+"%'");
			 andCheck 	= 1;
	    }
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

	 if ( !(short_desc == null || short_desc.equals("")) )
	 {
	    if ( andCheck == 1 )
	    {
	          sql.append(" and ");
	     	  sql.append(" upper(SHORT_DESC) like upper('"+short_desc+"%')");
	    }
	    else
	    {
			 sql.append(" where upper(SHORT_DESC) like upper('"+short_desc+"%')");
			 andCheck 	= 1;
	    }
	 }
	 if ( !(priority_no == null || priority_no.equals("") || priority_no.equals("A"))  )
	 {
	    if ( andCheck == 1 )
	    {
	          sql.append(" and ");
	     	  sql.append(" PRIORITY_ZONE ='"+priority_no+"'");
	    }
	    else
	    {
			 sql.append(" where PRIORITY_ZONE ='"+priority_no+"'");
			 andCheck 	= 1;
	    }
	 }
	 //Added By Shanmukh for MMS-DM-CRF-0147
	 if ( !(isPriorityZoneAppl == null || isPriorityZoneAppl.equals("") || isPriorityZoneAppl.equals("false"))  )
	 {
	    if ( andCheck == 1 )
	    {
	          sql.append(" and ");
	     	  sql.append(" PRIORITY_ZONE not in (select priority_zone from AE_PRIORITY_ZONE where eff_status ='D')");
	    }
	    else
	    {
			 sql.append(" where PRIORITY_ZONE not in (select priority_zone from AE_PRIORITY_ZONE where eff_status ='D')");
			 andCheck 	= 1;
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
	  


	  StringBuffer strsql2= new StringBuffer();
	  strsql2.append("select * from AE_PAT_PRIORITY_LANG_vw ");
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
	out.println("<A HREF='../../eAE/jsp/PatientPriorityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/PatientPriorityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='5%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th width='52%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th width='10%'><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></th>
<th width='5%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%}

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String priority_code_disp = rs.getString("PRIORITY_CODE");
	
	out.println("<a href='../../eAE/jsp/addModifyPatientPriority.jsp?priority_code="+priority_code_disp+"&green="+green+"&red="+red+"&yellow="+yellow+"&unassigned="+unassigned+" ' target='f_query_add_mod' >");
	out.println(priority_code_disp+"</a></td><td class='" + classValue + "'>");
	String long_desc_disp= rs.getString("LONG_DESC");
	out.println(long_desc_disp+"</td><td class='" + classValue + "'>");
	String short_desc_disp = rs.getString("SHORT_DESC");
	out.println(short_desc_disp+"</td><td class='" + classValue + "'>");
	String priority_zone_desc = rs.getString("priority_zone_desc");
	String priority_no_desc = "";
	
	/*if(priority_no_disp.equals("1"))
		priority_no_desc  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels");
	else if(priority_no_disp.equals("2"))
		priority_no_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels");
	else if(priority_no_disp.equals("3"))
		priority_no_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels");
	else if(priority_no_disp.equals("4"))
		priority_no_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");*/
	//below lines modified By Shanmukh for MMS-DM-CRF-0147
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	/*if(priority_no_disp.equals("1"))
		priority_no_desc  = red;
	else if(priority_no_disp.equals("2"))
		priority_no_desc  = green;
	else if(priority_no_disp.equals("3"))
		priority_no_desc  = yellow;
	else if(priority_no_disp.equals("4"))
		priority_no_desc  = unassigned;
	else priority_no_desc = "&nbsp;";*/
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	
	out.println(priority_zone_desc+"</td><td align='center' class='" + classValue + "'>");
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
strsql2.setLength(0);
 
if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
		e.printStackTrace();
     }
	finally   
	{
		if(con!=null)		 
        ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

