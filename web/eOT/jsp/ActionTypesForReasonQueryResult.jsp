<!DOCTYPE html>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%	

    String whereClause = request.getParameter("whereclause");
	/*String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;*/
    String reason_code =checkForNull(request.getParameter("reason_code"));
	String action_type = checkForNull(request.getParameter("action_type"));
	String active_yn = checkForNull(request.getParameter("active_yn"));

	//Paging calculation
	//int page_index = Integer.parseInt(page_index);
	String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	boolean prev = false;
	boolean next = false;
	
	String action_desc="";
	String reason_desc="";
	String sql="";
	StringBuilder sbr = new StringBuilder();

	
   if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		
	if ( !(reason_code == null || reason_code.equals("")) )
		{
		
			sql+= "and  A.reason_code = '"+reason_code+"' ";
			//andCheck = 1;
			cnt++;
		}

	if ( !(action_type == null || action_type.equals("all")) )
		{
		
		if(cnt>0)
			sql+= "and  A.action_type ='"+action_type+"' ";
			//andCheck = 1;
			else{
				sql=sql+" and A.action_type = '"+action_type+"'";
				cnt=1;

		       }
			}
		
	if ( !(active_yn == null || active_yn.equals("")) )
		{
		if(active_yn.equals("Y")){
			
			if(cnt>0)
			sql+= "and  nvl(A.active_yn,'N') ='Y' ";
			//andCheck = 1;
			else{
				sql=sql+" and nvl(A.active_yn,'N')='Y' ";
				cnt=1;
			    }
		    }
		

	if(active_yn.equals("N")){
			if(cnt>0)
			sql+= "and  nvl(A.active_yn,'N')='N' ";
			//andCheck = 1;
			else{
				sql=sql+" and nvl(A.active_yn,'N') ='N' ";
				cnt=1;
			}
		}
		if ( active_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
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
		}	}
 //end of where clause IF

 else
    {
	sql = whereClause;
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



Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rs=null;
ResultSet rset=null;
int maxRecord = 0;
try{

String strsql="SELECT  a.reason_code, SUBSTR (b.reason_desc, 1, 50) reason_desc, a.action_type, DECODE (a.action_type, 'CA', 'Cancel Appointment', 'CW', 'Cancel Waitlist', 'SC', 'Booking Sequence Change','TA', 'Transfer / Reschedule Appt.','CN', 'Cancel Check-In Case', 'TT', 'Transfer back to OT' ) action_desc, NVL (a.active_yn, 'N') active_yn FROM ot_reason_action_type a, ot_reasons_lang_vw b WHERE a.reason_code = b.reason_code AND b.language_id = ?"+sql;

 String strsql1="SELECT  a.reason_code, SUBSTR (b.reason_desc, 1, 50) reason_desc, a.action_type, DECODE (a.action_type, 'CA', 'Cancel Appointment', 'CW', 'Cancel Waitlist', 'SC', 'Booking Sequence Change','TA', 'Transfer / Reschedule Appt.','CN', 'Cancel Check-In Case', 'TT', 'Transfer back to OT' ) action_desc, NVL (a.active_yn, 'N') active_yn FROM ot_reason_action_type a, ot_reasons_lang_vw b WHERE a.reason_code = b.reason_code AND b.language_id = ?"+sql; 


	    stmt = conn.prepareStatement(strsql);
		stmt.setString(1,locale);
		rs = stmt.executeQuery();
	    //int total=0;
		while(rs.next()){
          maxRecord++;
		}
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			return;
		}

		
		//stmt1=conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,locale);
		//stmt1.setInt(2,start);
		//stmt1.setInt(3,end);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
		//out.println("sdfsadfs "+e);
	}

%>

<p>
<form name="QueryResult" id="QueryResult">
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/ActionTypesForReasonQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ActionTypesForReasonQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");	

/*
	if(prev){
		out.println("<A HREF='../jsp/ActionTypesForReasonQueryResult.jsp?page_index="+(page_index-1)+"&last_page="+last_page+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Previous</A>");
	}

	if(next){
		out.println("<A HREF='../jsp/ActionTypesForReasonQueryResult.jsp?page_index="+(page_index+1)+"&last_page="+last_page+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Next</A>");
	}*/
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 >
<th class="columnheadercenter" nowrap>   <!-- changed by yadav -->
	<fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap>  <!-- changed by yadav -->
	<fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap>  <!-- changed by yadav -->
	<fmt:message key="Common.ActionType.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap>  <!-- changed by yadav -->
	<fmt:message key="Common.ActionDescription.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap>  <!-- changed by yadav -->
	<fmt:message key="Common.active.label" bundle="${common_labels}"/>
</th>

<%
if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	  String classValue= "gridData";
      while ( rset.next() && i<=end  ){
	    
		reason_code = rset.getString(1);
	    reason_desc = rset.getString(2);
	    action_type = rset.getString(3);
		action_desc=rset.getString(4);
		active_yn = rset.getString(5);
		
	//out.println("<a href='../jsp/ResponsibilityforUser_Form.jsp?user_id="+ uid +"&resp_id="+ rid +"' target='f_query_add_mod' >");
	sbr.append("<tr>");
	sbr.append("<td class='").append(classValue).append("'>");
	sbr.append(reason_code);
	sbr.append("</td>");

	sbr.append("<td class='").append(classValue).append("'>");
	sbr.append(reason_desc);
	sbr.append("</td>");

	sbr.append("<td class='").append(classValue).append("'>");
	sbr.append(action_type);
	sbr.append("</td>");

	sbr.append("<td class='").append(classValue).append("'>");
	sbr.append(action_desc);
	sbr.append("</td>");


	/*sbr.append("<td class='").append(classValue).append(reason_code).append("'></td>");
    sbr.append("<td class='").append(classValue).append(reason_desc).append("'></td>");
    sbr.append("<td class='").append(classValue).append(action_type).append("'></td>");
    sbr.append("<td class='").append(classValue).append(action_desc).append("'></td>");*/
	if(active_yn.equals("Y"))
		//out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		 sbr.append("<td class='").append(classValue).append("'><img src='../../eCommon/images/enabled.gif'></img></td>");
    else
        //out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	    //out.println("<td class='" + classValue + "' align='center'>");
		 sbr.append("<td class='").append(classValue).append("'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
		sbr.append("</tr>");
		i++;
	}
	sbr.append("</table>");
	out.println(sbr.toString());
	sbr.setLength(0);
%>
</td></tr>
</table>
<br><center>
<%
	if(sbr.length()>0) sbr.setLength(0);
	if(stmt!=null)
			stmt.close();
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
		if(rs!=null)
			rs.close();
		ConnectionManager.returnConnection(conn,request);
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

