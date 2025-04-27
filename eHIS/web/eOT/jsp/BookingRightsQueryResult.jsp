<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String facility_id=(String) session.getAttribute("facility_id");
    String appl_user_id = request.getParameter("appl_user_id")==null?"":request.getParameter( "appl_user_id" );
	String appl_user_name =request.getParameter("appl_user_name")==null?"":request.getParameter( "appl_user_name" );
    String book_schedule_yn =request.getParameter("book_schedule_yn")==null?"":request.getParameter( "book_schedule_yn" );
    String transfer_schedule_yn = request.getParameter("transfer_schedule_yn")==null?"":request.getParameter( "transfer_schedule_yn");
	String cancel_schedule_yn = request.getParameter("cancel_schedule_yn")==null?"":request.getParameter( "cancel_schedule_yn");
	String overide_splty_restriction_yn = request.getParameter("overide_splty_restriction_yn")==null?"":request.getParameter( "overide_splty_restriction_yn");


		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(appl_user_id == null || appl_user_id.equals("")) ){
	        sql = sql + " and upper(a.appl_user_id ) like upper('"+appl_user_id +"%')";
			cnt++;
        }

        if ( !(appl_user_name == null || appl_user_name.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(b.appl_user_name) like upper('"+appl_user_name+"%')";
			else{
				sql=sql+" and upper(b.appl_user_name) like upper('"+appl_user_name+"%')";
				cnt=1;
			}

        }
	   
	

	
	if ( !(book_schedule_yn == null || book_schedule_yn.equals("")) ){
		
         if( book_schedule_yn.equals("N") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.book_schedule_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.book_schedule_yn,'N')='N' ";
				cnt=1;
			}
         }
	}

		 if ( book_schedule_yn.equals("Y") ){
             
            if(cnt>0)
			   sql = sql+" and a.book_schedule_yn='Y'";
			else
				sql=sql+ "and  a.book_schedule_yn='Y'";
         }

         if ( book_schedule_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

		 if ( !(transfer_schedule_yn == null || transfer_schedule_yn.equals("")) ){
         if( transfer_schedule_yn.equals("N") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.transfer_schedule_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.transfer_schedule_yn,'N')='N' ";
				cnt=1;
			}
         }
		 }

		 if ( transfer_schedule_yn.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and a.transfer_schedule_yn='Y'";
			else
				sql=sql+ "and a.transfer_schedule_yn='Y'";
         }

         if ( transfer_schedule_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }


		 if ( !(cancel_schedule_yn == null || cancel_schedule_yn.equals("")) ){
         if( cancel_schedule_yn.equals("N") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.cancel_schedule_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.cancel_schedule_yn,'N')='N' ";
				cnt=1;
			}
         }
		 }
		 if ( cancel_schedule_yn.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and a.cancel_schedule_yn='Y'";
			else
				sql=sql+ "and  a.cancel_schedule_yn='Y'";
         }

        
		 if ( cancel_schedule_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
         
		 if ( !(overide_splty_restriction_yn == null || overide_splty_restriction_yn.equals("")) ){
			 
         if( overide_splty_restriction_yn.equals("N") ){
               
			if(cnt>0)
			   sql = sql+" and nvl(a.overide_splty_restriction_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.overide_splty_restriction_yn,'N')='N' ";
				cnt=1;
			}
         }}

		 if ( overide_splty_restriction_yn.equals("Y") ){
          
            if(cnt>0)
			   sql = sql+" and a.overide_splty_restriction_yn='Y'";
			else
				sql=sql+ "and  a.overide_splty_restriction_yn='Y'";
         }

         if ( overide_splty_restriction_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		String strsql="SELECT A.APPL_USER_ID, B.APPL_USER_NAME, nvl(A.BOOK_SCHEDULE_YN,'N') book_schedule_yn, nvl(A.TRANSFER_SCHEDULE_YN,'N') transfer_schedule_yn, nvl(A.CANCEL_SCHEDULE_YN,'N') cancel_schedule_yn, nvl(A.OVERIDE_SPLTY_RESTRICTION_YN,'N') overide_splty_restriction_yn FROM OT_BOOKING_ACCESS_RIGHTS A, SM_APPL_USER B WHERE A.OPERATING_FACILITY_ID = ? AND A.APPL_USER_ID =B.APPL_USER_ID "+sql;
		String strsql1="SELECT A.APPL_USER_ID, B.APPL_USER_NAME, nvl(A.BOOK_SCHEDULE_YN,'N') book_schedule_yn, nvl(A.TRANSFER_SCHEDULE_YN,'N') transfer_schedule_yn, nvl(A.CANCEL_SCHEDULE_YN,'N') cancel_schedule_yn, nvl(A.OVERIDE_SPLTY_RESTRICTION_YN,'N') overide_splty_restriction_yn FROM OT_BOOKING_ACCESS_RIGHTS A, SM_APPL_USER B WHERE A.OPERATING_FACILITY_ID = ? AND A.APPL_USER_ID =B.APPL_USER_ID "+sql;
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,facility_id);
		rs = stmt.executeQuery();
        int total=0;
		while(rs.next())
		{
			total++;
		}
		maxRecord = total;
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,facility_id);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("sdfsadfs "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/BookingRightsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
    
if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/BookingRightsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 align='center'>
<th class='columnheadercenter' nowrap>Login ID</td> <!-- changed by yadav -->
<th class='columnheadercenter' nowrap><!-- changed by yadav -->
	<fmt:message key="Common.name.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.Book.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.OverrideSpecialtyRestriction.Label" bundle="${ot_labels}"/>
</th>

<%
   if ( start != 1 )
   {
   }
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                      classValue = "gridData" ; // changed by yadav
                else
                 classValue = "gridData" ; // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    appl_user_id = rset.getString(1);
	
    appl_user_name=rset.getString(2);
	
    book_schedule_yn=rset.getString(3);
	
    transfer_schedule_yn=rset.getString(4);
	
    cancel_schedule_yn=rset.getString(5);
	
    overide_splty_restriction_yn=rset.getString(6);
	
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/BookingRightsAddModify.jsp?mode="+mode+"&appl_user_id="+ appl_user_id+"&appl_user_name="+appl_user_name+"' target='f_query_add_mod' >");
    out.println(appl_user_id+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+appl_user_name+"</td>");
 
   
  
   out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("book_schedule_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
	 out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("transfer_schedule_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
	out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("cancel_schedule_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
	 out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("overide_splty_restriction_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
	 out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");


	
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
		 
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

