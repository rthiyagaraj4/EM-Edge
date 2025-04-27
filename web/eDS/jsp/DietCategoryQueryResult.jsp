<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
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
    String dietCategory = request.getParameter("diet_Category")==null?"":request.getParameter( "diet_Category" ).trim().toUpperCase();
	String longDesc =request.getParameter("long_Desc")==null?"":request.getParameter( "long_Desc" ).trim().toUpperCase();
	String orderType =request.getParameter("order_Type")==null?"":request.getParameter( "order_Type" ).trim().toUpperCase();

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(dietCategory == null || dietCategory.equals("")) ){
	        sql = sql + " where upper(diet_category_code) like upper('"+dietCategory +"%')";
			cnt++;
        }

        if ( !(longDesc == null || longDesc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(description) like '"+longDesc+"%'";
			else{
				sql=sql+" where upper(description) like '"+longDesc+"%'";
				cnt=1;
			}

        }
	   if ( !(orderType == null || orderType.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(order_type_code) like '"+orderType+"%'";
			else{
				sql=sql+" where upper(order_type_code) like '"+orderType+"%'";
				cnt=1;
			}

        }
		// Added Against Start PMG2017-COMN-CRF-0012 [IN066074]
		 if(sql !=null){
			if(cnt>0){
				sql = sql + " and a.order_type_code = b.order_type_code ";
			}	
			else{
			sql=sql + " where a.order_type_code = b.order_type_code ";
			cnt=1;
			}
		}
		// Added Against End PMG2017-COMN-CRF-0012 [IN066074]	

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
		// Added Against Start PMG2017-COMN-CRF-0012 [IN066074]
		String strsql="select count(*) as total from ds_diet_category a, or_order_type b  "+sql;
		String strsql1="select a.diet_category_code,a.description,b.short_desc as order_type_code from ds_diet_category  a, or_order_type b "+sql;
		// Added Against End PMG2017-COMN-CRF-0012 [IN066074] 
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
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
    out.println("<A HREF='../../eDS/jsp/DietCategoryQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/DietCategoryQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
	<fmt:message key="eOT.DietCategoryCode.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.Description.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.OrderType.Label" bundle="${ot_labels}"/>
</th>


<%
    //Checkstyle Violation commented by Munisekhar
	//int mOrder = 0;
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    dietCategory = checkForNull(rset.getString(1));
    longDesc=checkForNull(rset.getString(2));
	/*if(rset.getString(3) == null){
    	orderType = "&nbsp;";
    }else{ */
    	orderType= checkForNull(rset.getString(3));	
    //}

	String mode="modify";
	out.println("<a href='../../eDS/jsp/DietCategoryAddModify.jsp?mode="+mode+"&dietCategory="+ dietCategory+"' target='f_query_add_mod' >");
    out.println(dietCategory+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+orderType+"</td>");

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

