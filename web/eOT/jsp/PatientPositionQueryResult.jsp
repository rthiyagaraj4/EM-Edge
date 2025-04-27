<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.net.URLEncoder,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
	<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    String locale = (String)session.getAttribute("LOCALE");
	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" )) ;
    String to = checkForNull(request.getParameter( "to" )) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
    int end =  ( to.equals("") )?14:Integer.parseInt(to);
    String position_code = checkForNull(request.getParameter( "position_code" ));
	String long_desc =checkForNull(request.getParameter( "long_desc" ));
	String short_desc =checkForNull(request.getParameter( "short_desc" ));
    String enabled = checkForNull(request.getParameter( "status"));
	
	String enable_img = "<img src='../../eCommon/images/enabled.gif'></img>";
	String disable_img = "<img src='../../eCommon/images/RRnwd.gif'></img>";
    String sql = "";
	StringBuffer sbr=new StringBuffer();


	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;
	//	sql = sql + " WHERE ";
		if ( !(position_code == null || position_code.equals("")) ){
	        sql = sql + " upper(position_code ) like upper('"+position_code +"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like upper('"+long_desc+"%')";
			else{
				sql=sql+" upper(long_desc) like upper('"+long_desc+"%')";
				cnt=1;
			}

        }
	   if ( !(short_desc == null || short_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(short_desc) like upper('"+short_desc+"%')";
			else{
				sql=sql+" upper(short_desc) like upper('"+short_desc+"%')";
				cnt=1;
			}

        }		
	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E'";
			else{
				sql=sql+ " nvl(status,'E')='E'";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and status='D'";
			else{
				sql=sql+ " status='D'";
				cnt=1;
			}
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if(cnt>0)
		sql = sql+" AND LANGUAGE_ID='"+locale+"' ";
	else
		sql=sql+ "  LANGUAGE_ID='"+locale+"' ";

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


Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
int maxRecord = 0;
ResultSet rst=null;
ResultSet rset=null;
try{
	String strsql="select position_code,long_desc,short_desc,nvl(status,'E') status from OT_POSITION_LANG_VW where "+sql;
	String strsql1="select position_code,long_desc,short_desc,nvl(status,'E') status from OT_POSITION_LANG_VW where "+sql;
	pstmt = conn.prepareStatement(strsql1);
	rst = pstmt.executeQuery();
	int total=0;
		while(rst.next()){
           total++;
		}
		maxRecord = total;

		if(maxRecord == 0) {
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}

		pstmt1=conn.prepareStatement(strsql);
		rset = pstmt1.executeQuery();
	%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/PatientPositionQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/PatientPositionQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding=3  align='center'><tr>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.PositionCode.label" bundle="${common_labels}"/></th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th>
</tr>
<%
	String classValue = "" ;
	String status="";
	int i=1;

	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {

	  rset.next() ;

	}

while ( rset.next() && i<=end )
{
        if ( i % 2 == 0 )
			classValue = "gridData" ; // changed by yadav
		else
			classValue = "gridData" ; // changed by yadav

	out.println("<tr><td class='" + classValue + "'>");
	//out.println("<a href='../../eOT/jsp/PatientPositionAddModify.jsp?mode=modify&position_code="+rst.getString(1)+" target='f_query_add_mod'>");
    out.println("<a href='../../eOT/jsp/PatientPositionAddModify.jsp?mode=modify&position_code="+rset.getString(1)+"' target='f_query_add_mod'>");
	out.println(rset.getString(1)+"</a></td><td class='" + classValue + "'>");
	out.println(rset.getString(2)+"</td><td class='" + classValue + "'>");
	out.println(rset.getString(3)+"</td><td class='" + classValue + "'>");
	//out.println(rset.getString(4)+"</td><td class='" + classValue + "'>");
	//status = "E".equals(checkForNull(rset.getString(4),"D"));//?enable_img:disable_img;
	status = checkForNull(rset.getString(4));//?enable_img:disable_img;
	if(status.equals("E"))
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	    //out.println("<td class='" + classValue + "' align='center'>");
	i++;
}

}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err Msg From PatientPositionQueryResult-->"+e);
}finally{
		try{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(conn,request);
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
}
%>
</table>
</center>
</BODY>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</HTML>

