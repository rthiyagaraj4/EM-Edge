<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/StatusDescriptions.js'></script>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String whereClause = checkForNull(request.getParameter("whereclause"));
	String from = checkForNull(request.getParameter( "from" ) );
    String to = checkForNull(request.getParameter( "to" ) );
	int start = ( "".equals(from) )?1:Integer.parseInt(from);
    int end =  ( "".equals(to) )?14:Integer.parseInt(to);
    String status_code = checkForNull(request.getParameter( "status_code" ));
	String status_desc_sysdef = checkForNull(request.getParameter( "status_desc_sysdef" ));
	String status_desc = checkForNull(request.getParameter( "status_desc" ));
	String color_ind = checkForNull(request.getParameter( "color_ind"));
	String text_color= checkForNull(request.getParameter( "text_color"));
	String sql = " ";
	StringBuffer sbr = new StringBuffer();

	//Labels Picking up from MessageBundle
    String black	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Black.Label","ot_labels");
	String white	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.White.Label","ot_labels");
	String blue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Blue.Label","ot_labels");
	String lightblue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightBlue.Label","ot_labels");
	String darkblue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkBlue.Label","ot_labels");
	String green	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels");
	String lightgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightGreen.Label","ot_labels");
	String darkgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkGreen.Label","ot_labels");
	String yellow	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels");
	String red		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels");
	String darkred	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkRed.Label","ot_labels");
	String magenta	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Magenta.Label","ot_labels");
	String brown	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Brown.Label","ot_labels");
	String violet	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Violet.Label","ot_labels");
	String indigo	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Indigo.Label","ot_labels");
	String orange	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Orange.Label","ot_labels");
	String pink		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Pink.Label","ot_labels");
	String grey		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Gray.Label","ot_labels");
	String cyan		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Cyan.Label","ot_labels");
	String darkcyan	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkCyan.Label","ot_labels");
	String purple	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Purple.Label","ot_labels");
	StringBuffer bgcolor = new StringBuffer();
	bgcolor.append("decode(color_ind,'BLUE','").append(blue).append("',");
	bgcolor.append("'LIGHTBLUE','").append(lightblue).append("',");
	bgcolor.append("'DARKBLUE','").append(darkblue).append("',");
	bgcolor.append("'GREEN','").append(green).append("',");
	bgcolor.append("'LIGHTGREEN','").append(lightgreen).append("',");
	bgcolor.append("'DARKGREEN','").append(darkgreen).append("',");
	bgcolor.append("'YELLOW','").append(yellow).append("',");
	bgcolor.append("'RED','").append(red).append("',");
	bgcolor.append("'DARKRED','").append(darkred).append("',");
	bgcolor.append("'MAGENTA','").append(magenta).append("',");
	bgcolor.append("'BROWN','").append(brown).append("',");
	bgcolor.append("'VIOLET','").append(violet).append("',");
	bgcolor.append("'INDIGO','").append(indigo).append("',");
	bgcolor.append("'ORANGE','").append(orange).append("',");
	bgcolor.append("'PINK','").append(pink).append("',");
	bgcolor.append("'GREY','").append(grey).append("',");
	bgcolor.append("'CYAN','").append(cyan).append("',");
	bgcolor.append("'DARKCYAN','").append(darkcyan).append("',");
	bgcolor.append("'PURPLE','").append(purple).append("') color_ind, DECODE(text_color,");
	bgcolor.append("'WHITE','").append(white).append("',");
	bgcolor.append("'BLACK','").append(black).append("') text_color");
	String textcolor = bgcolor.toString();
	int cnt = 0  ;
   if ( (whereClause == null || whereClause.equals("")) )
    {
	// cnt=0;

		if ( !(status_code == null || status_code.equals("")) ){
	        sql = sql + " where upper(status_code ) like upper('"+status_code +"%')";
			cnt++;
        }

        if ( !(status_desc_sysdef == null || status_desc_sysdef.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(status_desc_sysdef) like upper('"+status_desc_sysdef+"%')";
			else{
				sql=sql+" where upper(status_desc_sysdef) like upper('"+status_desc_sysdef+"%')";
				cnt=1;
			}

        }
	   if ( !(status_desc == null || status_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(status_desc) like upper('"+status_desc+"%')";
			else{
				sql=sql+" where upper(status_desc) like upper('"+status_desc+"%')";
				cnt=1;
			}

        }
	
	if ( !(color_ind == null || color_ind.equals("all")) ){
			if(cnt>0)
				sql = sql + " and color_ind like '"+color_ind+"%'";
			else{
				sql=sql+" where color_ind like '"+color_ind +"%'";

				cnt =1;
			}
        } 
	if ( !(text_color == null || text_color.equals("all")) ){
			if(cnt>0)
				sql = sql + " and text_color like '"+text_color+"%'";
			else{
				sql=sql+" where text_color like '"+text_color +"%'";

				cnt =1;
			}
        } 
   
    }

	if(cnt>0)
		sql = sql+" and LANGUAGE_ID = '"+locale+"' ";
	else
		sql = sql+" where LANGUAGE_ID = '"+locale+"' ";
	cnt=1;


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

    //end of where clause IF
    else
            sql = whereClause;

	
	Connection conn  =  null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	int maxRecord = 0;
	int i=1;
	// String strsql="select count(*) as total from OT_Status "+sql;
	// String strsql1="select status_code,status_desc_sysdef, status_desc,decode(color_ind,'BLUE','Blue','LIGHTBLUE','Light Blue','DARKBLUE','Dark Blue','GREEN','Green','LIGHTGREEN','Light Green','DARKGREEN','Dark Green','YELLOW','Yellow','RED','Red','DARKRED','Dark  Red','MAGENTA','Magenta','BROWN','Brown','VIOLET','Violet','INDIGO','Indigo','ORANGE','Orange','PINK','Pink','GREY','Grey','CYAN','Cyan','DARKCYAN','Dark Cyan','PURPLE','Purple') color_ind ,DECODE(text_color, 'WHITE','White','BLACK','Black') text_color from  OT_STATUS "+sql;
	//out.println("Where Clause : "+whereClause);
	//String strsql="select count(*) as total from OT_STATUS "+whereClause;
	String strsql1="select status_code,status_desc_sysdef, status_desc,"+textcolor+" from  OT_STATUS_LANG_VW "+sql;
	try{
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset = pstmt.executeQuery();
		//getting maximum record
		rset.last();	maxRecord = rset.getRow();
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		//again move the resultset pointer to initial position
		rset.beforeFirst();
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr><td>
<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eOT/jsp/StatusDescriptionsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eOT/jsp/StatusDescriptionsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td></tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnHeader" nowrap>
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
</th>
<th class="columnHeader" nowrap>
	<fmt:message key="eOT.SystemDefinedDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnHeader" nowrap>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class="columnHeader" nowrap>
	<fmt:message key="Common.Color.label" bundle="${common_labels}"/>
</th>
<th class="columnHeader" nowrap>
	<fmt:message key="eOT.TextColor.Label" bundle="${ot_labels}"/>
</th>

<%
	if ( start != 1 ) rset.absolute(start-1);
	i=start;
	String classValue= " ";
    while ( rset.next() && i<=end  ){
		classValue = ( i % 2 == 0 )?"gridData":"gridData";
		status_code = checkForNull(rset.getString(1));
		status_desc_sysdef=checkForNull(rset.getString(2));
		status_desc= checkForNull(rset.getString(3));
		color_ind =  checkForNull(rset.getString(4));
		text_color = checkForNull(rset.getString(5));
		sbr.append("<tr><td  class='" + classValue + "' nowrap>");
		sbr.append("<a href='../../eOT/jsp/StatusDescriptionsModify.jsp?mode=modify&status_code="+status_code+"' target='f_query_add_mod' >");
		sbr.append(checkForNull(rset.getString(1))+"</a></td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+checkForNull(rset.getString(2))+"</td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+status_desc+"</td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+color_ind+"</td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+text_color+"</td>");
		i++;
	} 
	out.println(sbr.toString());
	if(pstmt!=null)	pstmt.close();
	if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err StatusDescriptionsQueryResult" +e);
}
%>
</td></tr>
</table>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

