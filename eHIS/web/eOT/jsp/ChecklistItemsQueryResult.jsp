<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eOT/js/ChecklistItems.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
    try{	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String list_id="";
    String checklist_item_code = request.getParameter("checklist_item_code")==null?"":request.getParameter( "checklist_item_code" );
	String description =request.getParameter("description")==null?"":request.getParameter( "description" );
	String checklist_type =request.getParameter("checklist_type")==null?"":request.getParameter( "checklist_type" );
	String list_desc = request.getParameter("list_desc")==null?"":request.getParameter("list_desc");
	String accept_remarks_yn = request.getParameter("accept_remarks_yn")==null?"":request.getParameter("accept_remarks_yn");
	String item_level = request.getParameter("item_level")==null?"":request.getParameter("item_level");
    String enabled = request.getParameter("status")==null?"":request.getParameter( "status");

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(checklist_item_code == null || checklist_item_code.equals("")) ){
	        sql = sql + " where upper(checklist_item_code ) like upper('"+checklist_item_code +"%')";
			cnt++;
        }

        if ( !(description == null || description.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(description) like upper('"+description+"%')";
			else{
				sql=sql+" where upper(description) like upper('"+description+"%')";
				cnt=1;
			}

        }
	   if ( !(checklist_type == null || checklist_type.equals("sel")) ){
			if(cnt>0)
				sql = sql + " and checklist_type like '"+checklist_type+"%'";
			else{
				sql=sql+" where checklist_type like '"+checklist_type+"%'";
				cnt=1;
			}

        }
	  
	  if ( !(list_desc == null || list_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(list_id) like upper('"+list_desc+"%')";
			else{
				sql=sql+" where upper(list_id) like upper('"+list_desc+"%')";
				cnt=1;
			}

        }
	 
	  if ( !(accept_remarks_yn == null || accept_remarks_yn.equals("")) ){
         if( accept_remarks_yn.equals("N") ){

			if(cnt>0)
			   sql = sql+" and nvl(accept_remarks_yn,'N')='N' ";
			else{
				sql=sql+ " where nvl(accept_remarks_yn,'N')='N' ";
				cnt=1;
			}
         }

		 if ( accept_remarks_yn.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and accept_remarks_yn='Y'";
			else
				sql=sql+ "where  accept_remarks_yn='Y'";
         }

         if ( accept_remarks_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

		 if ( !(item_level == null || item_level.equals("all")) ){
			if(cnt>0)
				sql = sql + " and item_level = '"+item_level+"'";
			else{
				sql=sql+" where item_level = '"+item_level+"'";
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
				sql=sql+ "where  status='D'";
         }

         if ( enabled.equals("B") ){
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
    }

	  }} //end of where clause IF
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
		String strsql="SELECT CHECKLIST_ITEM_CODE, DESCRIPTION, DECODE(CHECKLIST_TYPE,'C', 'Check Box', 'L', 'List Item', 'E', 'Label'), LIST_ID, ACCEPT_REMARKS_YN, ITEM_LEVEL, nvl(STATUS,'E') status FROM OT_CHECKLIST_ITEMS"+sql;
        String strsql1="SELECT CHECKLIST_ITEM_CODE, DESCRIPTION, DECODE(CHECKLIST_TYPE,'C', 'Check Box', 'L', 'List Item', 'E', 'Label'), LIST_ID, ACCEPT_REMARKS_YN, ITEM_LEVEL, nvl(STATUS,'E') status FROM OT_CHECKLIST_ITEMS"+sql;
		stmt = conn.prepareStatement(strsql);
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
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Err Msg from ChecklistItemQueryResult.jsp : "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/ChecklistItemsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ChecklistItemsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.ChecklistItem.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.ChecklistType.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.List.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.AcceptRemarks.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.ItemLevel.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
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
                    classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
    out.println("<tr><td align=='left' class='gridData'>"); // changed by yadav

    checklist_item_code = rset.getString(1);
    description=rset.getString(2);
    checklist_type= rset.getString(3);
	list_id=rset.getString(4);
	 //list_desc=rset.getString(5);
    accept_remarks_yn=rset.getString(5);
	item_level=rset.getString(6);
	if(list_desc==null)
		list_desc="&nbsp;";
    if(list_id==null)
		list_id="&nbsp;";
	String mode="modify";
	
	out.println("<a href='../../eOT/jsp/ChecklistItemsAddModify.jsp?mode="+mode+"&checklist_item_code="+ checklist_item_code+"' target='f_query_add_mod' >");
	
    out.println(checklist_item_code+"</a></td>");
  
   out.println("<td nowrap class='" + classValue+"'>"+description+"</td>");
   out.println("<td nowrap class='" + classValue+"'>"+checklist_type+"</td>");
   out.println("<td nowrap class='" + classValue+"'>"+list_id+"</td>");

   out.println("<td nowrap class='" + classValue + "' align='center'>");
    if ( rset.getString("accept_remarks_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
   out.println("<td nowrap class='gridData'>"+item_level+"</td>");  // changed by yadav 
     
   out.println("<td nowrap class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") )
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
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("here "+e);
}
%>

</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

