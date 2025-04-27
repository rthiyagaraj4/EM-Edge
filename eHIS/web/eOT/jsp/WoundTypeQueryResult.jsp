<!DOCTYPE html>


<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eOT/js/WoundType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<%
//OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";

    String wound_type_code = checkForNull(request.getParameter("wound_type_code"));
	String long_desc =checkForNull(request.getParameter("long_desc"));
	String wound_text =checkForNull(request.getParameter("wound_text"));
	
    String enabled =checkForNull(request.getParameter("status"));

	
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(wound_type_code == null || wound_type_code.equals("")) ){
	        sql = sql + " where upper(wound_type_code ) like upper('"+wound_type_code +"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like upper('"+long_desc+"%')";
			else{
				sql=sql+" where upper(long_desc) like upper('"+long_desc+"%')";
				cnt=1;
			}

        }
	   if ( !(wound_text == null || wound_text.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(wound_text) like upper('"+wound_text+"%')";
			else{
				sql=sql+" where upper(wound_text) like upper('"+wound_text+"%')";
				cnt=1;
			}

        }
	
	

	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E' ";
			else{
				sql=sql+ " where nvl(status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and status='D'";
			else
				sql=sql+ " where  status='D'";
			cnt=1;
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }
	if(cnt>0)
		sql =sql+" and LANGUAGE_ID = '"+locale+"' " ;
	else
		sql = sql+" where LANGUAGE_ID = '"+locale+"' ";

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
String strsql="";
String strsql1="";
	try{
		
		strsql="select count(*) as total from OT_WOUND_TYPE_LANG_VW "+sql;
		strsql1="select wound_type_code,long_desc, wound_text, nvl(status,'E') status from  OT_WOUND_TYPE_LANG_VW "+sql;

		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		/* out.println("sdfsadfs error in line 161 : "+e);
		out.println("strsql1==="+strsql1);
		out.println("strsql==="+strsql); */
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/WoundTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/WoundTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.WoundTypeCode.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.Text.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th> 

<%
	String first_few_char="";

	String heading="Wound Type Text";
   if ( start != 1 )
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

    wound_type_code =checkForNull(rset.getString(1));
    long_desc=checkForNull(rset.getString(2));
    wound_text=checkForNull(rset.getString(3));
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/WoundTypeAddModify.jsp?mode="+mode+"&wound_type_code="+ wound_type_code+"' target='f_query_add_mod' >");
    out.println(wound_type_code+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+long_desc+"</td>");
  if(wound_text.length()<=20)
	{
  out.println("<td class='" + classValue+"'><a href=\"javascript:openDialogWindow('"+heading+"',"+i+");\">"+wound_text+"</td>");
	}
	else
	{
		first_few_char=wound_text.substring(0,20);
		 out.println("<td class='" + classValue+"'><a href=\"javascript:openDialogWindow('"+heading+"',"+i+");\">"+first_few_char+"....................</td>");
	}
  
   out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
     %><img src='../../eCommon/images/RRnwd.gif'></img>
</td><%

	
    out.println("<input type=hidden name=remarks_"+i+" value='"+wound_text+"'>");
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
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

</center>
</form>
</BODY>
</HTML>

