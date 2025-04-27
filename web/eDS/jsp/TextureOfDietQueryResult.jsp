<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

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
	String ph_module_yn = request.getParameter("ph_module_yn");
try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String textureofdiet = request.getParameter("textureofdiet")==null?"":request.getParameter( "textureofdiet" ).trim().toUpperCase();
	String longDesc =request.getParameter("longDesc")==null?"":request.getParameter( "longDesc" ).trim().toUpperCase();
	String shortDesc =request.getParameter("shortDesc")==null?"":request.getParameter( "shortDesc" ).trim().toUpperCase();
    String enabledYn = request.getParameter("enabledYn")==null?"":request.getParameter( "enabledYn");

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(textureofdiet == null || textureofdiet.equals("")) ){
	        sql = sql + " where upper(texture_of_diet ) like upper('"+textureofdiet +"%')";
			cnt++;
        }

        if ( !(longDesc == null || longDesc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like '"+longDesc+"%'";
			else{
				sql=sql+" where upper(long_desc) like '"+longDesc+"%'";
				cnt=1;
			}

        }
	   if ( !(shortDesc == null || shortDesc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(short_desc) like '"+shortDesc+"%'";
			else{
				sql=sql+" where upper(short_desc) like '"+shortDesc+"%'";
				cnt=1;
			}

        }


	if (!(enabledYn.equals("B"))){

		if(enabledYn.equals("E")){
			if(cnt>0)
				   sql = sql+" and nvl(eff_status,'D')='E' ";
				else{
					sql=sql+ " where nvl(eff_status,'D')='E' ";
					cnt=1;
				}
		}
		else if(enabledYn.equals("D")){
			if(cnt>0)
				   sql = sql+" and nvl(eff_status,'D')='D' ";
				else{
					sql=sql+ " where nvl(eff_status,'D')='D' ";
					cnt=1;
				}
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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{

		String strsql="select count(*) as total from ds_texture_of_diet "+sql;
		String strsql1="select texture_of_diet,long_desc,short_desc,eff_status from ds_texture_of_diet "+sql;
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
        //System.out.println("strsql"+strsql);
		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();

	}catch(Exception e){
		out.println("fffg "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/TextureOfDietQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/TextureOfDietQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.TextureOfDiet.Label" bundle="${ds_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th>

<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ; 
                else
            classValue = "gridData" ; 
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");
	

    textureofdiet = rset.getString(1);
    longDesc=rset.getString(2);
    shortDesc= rset.getString(3);
    enabledYn = rset.getString(4);


	String mode="modify";
	out.println("<a href='../../eDS/jsp/TextureOfDietAddModify.jsp?mode="+mode+"&textureofdiet="+ textureofdiet+"' target='f_query_add_mod' >");
    out.println(textureofdiet+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDesc+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( enabledYn.equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

//	out.println("<td class='" + classValue + "' align='center'>");
	/*if ( image_linked_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");*/

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
	out.println("here "+e);
}
%>

</center>
</form>
</BODY>
</HTML>

