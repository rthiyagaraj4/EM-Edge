<!DOCTYPE html>

<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../js/Section.js'></script>

<HTML>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>


	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	Connection conn=null;
	try
	{
	String whereClause = request.getParameter("whereclause");
	
	if(whereClause==null) whereClause="";
    
	String note_desc = "";
	
	String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
//    String rec_short_desc = "";
	StringBuffer sql=new StringBuffer();
	String query_id  = request.getParameter("query_id")==null?"":request.getParameter("query_id");
	String query_desc  = request.getParameter("query_desc")==null?"":request.getParameter("query_desc");
	String note_type  = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String enabled					= request.getParameter("eff_status")==null?"":request.getParameter( "eff_status");
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";

	int pageCnt = Integer.parseInt(MstQryPageCnt);

	if ( (whereClause == null || whereClause.equals("")) )
    {
		int cnt=0;

		if ( !(query_id == null || query_id.equals("")) )
		{
	        if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper( query_ref ) like upper('"+query_id +"%') ");
			cnt++;
        }

		if ( !(query_desc == null || query_desc.equals("")) )
		{
			if(cnt>0)
				sql.append(" and upper(query_desc) like upper('"+query_desc+"%')");
			else
			{
				sql.append(" where upper(query_desc) like upper('"+query_desc+"%')");
				cnt=1;
			}

        }

		if ( !(note_type == null || note_type.equals("")) ){
			if(cnt>0)
				//sql.append(" and upper(NOTE_TYPE) like upper('"+note_type+"%')");
				sql.append(" and NOTE_TYPE in ( select NOTE_TYPE from ca_note_type where UPPER(NOTE_TYPE_DESC) like upper('"+note_type+"%'))");
			else
			{
				sql.append(" where NOTE_TYPE in ( select NOTE_TYPE from ca_note_type where UPPER(NOTE_TYPE_DESC) like upper('"+note_type+"%'))");
				cnt=1;
			}

        }

		if ( !(enabled == null || enabled.equals("")) )
		{
			 if( enabled.equals("E") )
			 {
				if(cnt>0)
				   sql.append(" and eff_status='E'");
				else
				{
					sql.append(" where  eff_status='E'");
					cnt=1;
				}
			 }
			 if ( enabled.equals("D") )
			 {
				if(cnt>0)
				   sql.append(" and eff_status='D'");
				else
					sql.append("where  eff_status='D'");
			 }

			 if ( enabled.equals("B") )
			 {
				//    sql = sql; //nothing is added to get both E and D
			 }
		}
		 String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord.equals("")) )
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
            sql.append(whereClause);


	int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;

	conn  =  ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rset=null;
	ResultSet rs = null;	
	
	int maxRecord = 0;

	try{
		
			StringBuffer strsql=new StringBuffer();
			strsql.append("select count(*) as total from CA_TEMP_QRY_HDR ");
			strsql.append(sql.toString());
			StringBuffer strsql1=new StringBuffer();
			strsql1.append("select QUERY_REF,QUERY_DESC, NOTE_TYPE,ca_get_desc.CA_NOTE_TYPE(NOTE_TYPE,'en',2) note_desc , eff_status from  CA_TEMP_QRY_HDR ");
			strsql1.append(sql.toString());

			stmt = conn.prepareStatement(strsql.toString());
			rs = stmt.executeQuery();

			rs.next();
			maxRecord = rs.getInt("total");

			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
			}
			stmt1=conn.prepareStatement(strsql1.toString());

			//	out.println("strsql1.toString() = "+strsql1.toString());
			rset = stmt1.executeQuery();
		
		}
		catch(Exception e)
		{
			out.println("sdfsadfs "+e);
		}

	%>
	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='white' width='88%'></td> 
			<td  align='right' width='12%' nowrap>
			<%
			if ( !(start <= 1) )
				out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultQueryTemplate.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+pageCnt) > maxRecord ) )
				out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/QueryResultQueryTemplate.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
		</tr>
	</table>

	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
		<tr>
			<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="eCA.QueryID.label" bundle="${ca_labels}"/></td>
			<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="eCA.QueryDesc.label" bundle="${ca_labels}"/></td>
			<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

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
				out.println("<tr><td class='" + classValue + "'>");

			query_id   = rset.getString(1)==null?"":rset.getString(1);
			query_desc = rset.getString(2)==null?"":rset.getString(2);
			note_type  = rset.getString(3)==null?"":rset.getString(3);
			note_desc  = rset.getString(4)==null?"":rset.getString(4);

			out.println("<a class='gridLink'  href='../../eCA/jsp/QueryNoteTemplateAddModify.jsp?query_id="+ query_id+"' target='f_query_add_mod' onclick=''>");
			out.println(query_id+"</a></td><td class='" + classValue + "'>");
			out.println( query_desc );
			out.println("</td><td class='" + classValue + "'>");
			out.println( note_desc );
			 out.println("<td class='" + classValue + "'>");
			if ( rset.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			out.println("</td>");
			i++;
			}
			%>

			</td>
		</tr>
	</table>
</center>

<center>

	<%
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();

	}
	catch(Exception e)
	{
		//out.println("here "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if (conn != null)  
		ConnectionManager.returnConnection(conn,request);
	}	
	%>

</center>
</BODY>
</HTML>

