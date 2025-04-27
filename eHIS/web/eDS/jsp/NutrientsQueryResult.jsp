<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
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
    String nutrients = request.getParameter("nutrients")==null?"":request.getParameter( "nutrients" ).trim().toUpperCase();
	String longDesc =request.getParameter("long_Desc")==null?"":request.getParameter( "long_Desc" ).trim().toUpperCase();
	String shortDesc =request.getParameter("short_Desc")==null?"":request.getParameter( "short_Desc" ).trim().toUpperCase();
	String uom =request.getParameter("uom")==null?"":request.getParameter( "uom" ).trim().toUpperCase();
	String enabledYn = request.getParameter("enabled_Yn")==null?"":request.getParameter( "enabled_Yn");

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(nutrients == null || nutrients.equals("")) ){
	        sql = sql + " where upper(nutrients_code) like upper('"+nutrients +"%')";
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
	   if ( !(uom == null || uom.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(uom_code) like '"+uom+"%'";
			else{
				sql=sql+" where upper(uom_code) like '"+uom+"%'";
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
		String strsql="select count(*) as total from ds_nutrients "+sql;
		String strsql1="select nutrients_code,long_desc,short_desc,am_get_desc.am_uom(uom_code,?,2) uom_code,eff_status from ds_nutrients "+sql; // Modified Against PMG2017-COMN-CRF-0012 [IN066074]
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,locale); //Added Against PMG2017-COMN-CRF-0012 [IN066074]
		rset = stmt1.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/NutrientsQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/NutrientsQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
	<fmt:message key="eOT.NutrientCode.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.Uom.Label" bundle="${ot_labels}"/>
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

    nutrients = checkForNull(rset.getString(1));
    longDesc=checkForNull(rset.getString(2));
    shortDesc= checkForNull(rset.getString(3));
    uom = checkForNull(rset.getString(4));
    enabledYn = checkForNull(rset.getString(5));

	String mode="modify";
	out.println("<a href='../../eDS/jsp/NutrientsAddModify.jsp?mode="+mode+"&nutrients="+ nutrients+"' target='f_query_add_mod' >");
    out.println(nutrients+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+uom+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( "E".equals(enabledYn) )
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
}catch(Exception e){
	e.printStackTrace();
}
%>
</center>
</form>
</BODY>
</HTML>

