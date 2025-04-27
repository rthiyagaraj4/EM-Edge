<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

%>


<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%
	Connection conn  =  ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;
	try{
		String whereClause = checkForNull(request.getParameter("whereclause"));
	    String from = checkForNull(request.getParameter( "from" ) );
		String to = checkForNull(request.getParameter( "to" ) );
		int start = ( from.equals("") )?1:Integer.parseInt(from);
		int end =  ( to.equals("") )?14:Integer.parseInt(to);
	    String sql = " ";
	    String oper_code = checkForNull(request.getParameter( "oper_code" ) );
		String long_desc =checkForNull(request.getParameter( "long_desc") ).toUpperCase();
		String short_desc =checkForNull(request.getParameter( "short_desc" ) ).toUpperCase();
		String oper_type_code =checkForNull(request.getParameter( "oper_type_code" ) ).toUpperCase();
		String speciality_code =checkForNull(request.getParameter( "speciality_code" ) ).toUpperCase();
		String order_catalog_code =checkForNull(request.getParameter( "order_catalog_code" ) ).toUpperCase();
		String enabled = checkForNull(request.getParameter( "status") );
		String appl_right_left_flag ="";
		String status = "";
	    if (  whereClause.equals("") ){
			int cnt=0;
			if ( !(oper_code == null || oper_code.equals("")) ){
	        sql = sql + " and Upper(oper_code ) like upper('"+oper_code +"%')";
			cnt++;
        }

        if ( ! long_desc.equals("") ){
			sql = sql + " and Upper(long_desc) like '"+long_desc+"%'";
			cnt=1;
		}

	   if ( ! short_desc.equals("") ){
			sql = sql + " and Upper(short_desc) like '"+short_desc+"%'";
			cnt=1;
		}
		if ( !(oper_type_code == null || oper_type_code.equals("all")) ){
			sql = sql + " and Upper(oper_type_code) like '"+oper_type_code+"%'";
			cnt =1;
		}

	if ( ! speciality_code.equals("all") ){
			if(cnt>0)
				sql = sql + " and upper(speciality_code) like '"+speciality_code+"%'";
			else{
				sql=sql+" where upper(speciality_code) like '"+speciality_code +"%'";
				cnt =1;
			}
        }

	if (  ! "".equals(order_catalog_code) ){
			if(cnt>0)
				sql = sql + " and upper(order_catalog_code) like '"+order_catalog_code+"%'";
			else{
				sql=sql+" where upper(order_catalog_code) like '"+order_catalog_code+"%'";
				cnt =1;
			}
        }

	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){
			   sql = sql+" and nvl(status,'E')='E' ";
				cnt=1;
			}
		 if ( enabled.equals("D") ){
			   sql = sql+" and nvl(status,'E')='D'";
				cnt=1;
			}
    }

         if ( enabled.equals("B") ){
		//  sql = sql; //nothing is added to get both E and D
         }
    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");
    if ( !(ord == null || ord .equals("")) ){
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


	int i=1;

    /*int start = 0 ;
    int end = 0 ;
    

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;
		*/
	String strsql1="";
	try{
		
		String strsql="select count(*) as total from OT_OPER_MAST_LANG_VW WHERE LANGUAGE_ID=? "+sql;

		strsql1="select oper_code, long_desc, short_desc, oper_type_code, order_catalog_code, speciality_code, nvl(appl_right_left_flag,'N') appl_right_left_flag, nvl(status,'E') status  from  OT_OPER_MAST_LANG_VW WHERE LANGUAGE_ID = ? "+sql;

		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,locale);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,locale);

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
    out.println("<A HREF='../../eOT/jsp/OperProcQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/OperProcQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
	<fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.CatalogCrossReference.label" bundle="${common_labels}"/></th> 

<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

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

    oper_code = rset.getString(1);
    long_desc=rset.getString(2);
    short_desc= rset.getString(3);
	oper_type_code = rset.getString(4);
	order_catalog_code = rset.getString(5);
	order_catalog_code=checkForNull(order_catalog_code);
	speciality_code = rset.getString(6);
	speciality_code=checkForNull(speciality_code);
	speciality_code=checkForNull(speciality_code);
	appl_right_left_flag = checkForNull(rset.getString(7));
	status = rset.getString(8);
	//enabled=rset.getString(7);

	String mode="modify";
	out.println("<a href='../../eOT/jsp/OperationsProceduresAddModify.jsp?mode="+mode+"&oper_code="+ oper_code+"' target='f_query_add_mod' >");
    out.println(oper_code+"</a></td>");
  
   out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+short_desc+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+oper_type_code+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+order_catalog_code+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+speciality_code+"</td>");
  
   out.println("<td class='" + classValue + "' nowrap>");
    if ( appl_right_left_flag.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

   out.println("<td class='" + classValue + "' nowrap>");
    if ( status.equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	//out.println("<td class='" + classValue + "' align='center'>");
	

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
finally{
		try{
			if(rset!=null)rset.close();
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(stmt1!=null) stmt1.close();
			if(conn!=null)
			ConnectionManager.returnConnection(conn,request);

             }catch(Exception e){e.printStackTrace();}
}
%>

</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

