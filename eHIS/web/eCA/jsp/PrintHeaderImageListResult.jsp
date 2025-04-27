<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<br>
 <%
	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    
	StringBuffer sql = new StringBuffer();

	//String note_group_id  = request.getParameter("note_group_id");
	String note_type  = request.getParameter("note_type");
    String note_type_desc = request.getParameter("note_type_desc");
     String file_type = request.getParameter("file_type");

	if(note_type_desc == null){
		note_type_desc = "";
	}else{
		note_type_desc = note_type_desc.toUpperCase();
	}
    //String event_class = request.getParameter("event_class");
    //String confidential_yn = request.getParameter("confidential_yn");
	
	String eff_status = request.getParameter("eff_status");
//		String ca_note_type = request.getParameter("ca_note_type");

	//String event_class_desc="";

	//String note_group  ="", serv_facility ="", doc_link_note ="",	amnd_type="",applicability="";
    int count = 0;
	if ( (whereClause == null || whereClause.equals("")) )
    {


	

	if ( !(note_type == null || note_type.equals("")) )
        {
	        sql = new StringBuffer();
			sql.append(" where upper( LOGO_ID) like upper('"+note_type +"%')");
			count =  1;
        }

        if ( !(note_type_desc == null || note_type_desc.equals("")) )
        {
			if(count == 1)
				sql.append(" and upper( LOGO_DESC) like '"+note_type_desc+"%'");
		else
			{
			sql.append(" where upper(LOGO_DESC) like '"+note_type_desc+"%'");
			count=1;
			}	

        }
		
        if ( !(file_type == null || file_type.equals("")) )
        {
			if(count == 1)
				sql.append(" and upper( LOGO_EXEC_NAME) like upper('"+file_type+"%')");
			else
			{
			sql.append(" where upper(LOGO_EXEC_NAME) like upper('"+file_type+"%')");
			count=1;
			}

        }
		   
 else
		{


    if ( !(eff_status == null || eff_status.equals("")) )
    {
         if( eff_status.equals("E") )
         {
              if(count == 1)
  			  sql.append(" and eff_status='E'");
			   else
               sql.append(" where eff_status='E'");
		  }
         if ( eff_status.equals("D") )
	     {
			  if(count == 1)
			  sql.append(" and eff_status='D'");
			   else
               sql.append(" where eff_status='D'");
		 }
        
    }
    }


    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by ");
        for ( int i=0;i < ord.length;i++ )
        {
			//sql.append("a.");
        if ( i == ord.length - 1 )
            sql.append(ord[i]);
        else
            sql.append(ord[i]+",");
        }
    }

    } //end of where clause IF
    else{
		sql = new StringBuffer();
		 sql.append(whereClause);
	}



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
PreparedStatement stmt1=null;
PreparedStatement stmt;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;


String strsql="select count(*) as total from CA_NOTE_LOGO_LIST"+sql.toString() ;
String strsql1="select LOGO_ID,LOGO_DESC, LOGO_EXEC_NAME, EFF_STATUS from  CA_NOTE_LOGO_LIST"+sql.toString() ;


try
{
stmt = conn.prepareStatement(strsql);
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}

%>

<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td> 
<td  align='right' width='12%'>
<%

if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/PrintHeaderImageListResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("&nbsp;<A HREF='../../eCA/jsp/PrintHeaderImageListResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>

<td class='columnheadercenter' width="25%"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width="25%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width="25%"><fmt:message key="Common.FileName.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width="25%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>




<%
	stmt1=conn.prepareStatement(strsql1);
rset = stmt1.executeQuery();

   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;

	out.println("<tr><td align=='left' class='" + classValue + "'>");

     
	String note_type1		=(rset.getString(1)==null)?"":rset.getString(1);
    String note_type_desc1	=(rset.getString(2)==null)?"":rset.getString(2);
  
	String file_type1		=(rset.getString(3)==null)?"":rset.getString(3);
	String eff_status1		=(rset.getString(4)==null)?"":rset.getString(4);

	out.println("<a href='../../eCA/jsp/PrintHeaderImageListAddModify.jsp?mode=update&note_type="+ URLEncoder.encode(note_type1)+"' target='f_query_add_mod' >");
    out.println(note_type1 + "</a></td><td class='" + classValue + "'>");
 //   out.println("<a href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=update&note_type="+ URLEncoder.encode(note_type1)+"' target='f_query_add_mod' >");
   out.println(note_type_desc1);
   out.println("</td><td class='" + classValue + "'>");
	out.println(file_type1);
	
		out.println("</td><td class='" + classValue + "'>");
//out.println("<a href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=update&note_type="+ 	URLEncoder.encode(note_type1)+"' target='f_query_add_mod' >");
		
    if ( eff_status1.equalsIgnoreCase("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	//out.println("</td>");
	 //out.println("</td><td class='" + classValue + "'>");
	out.println("</td>");
	i++;
} %>


</td></tr>
</table>
</center>

<br><center>
<%
//rs.close();
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	//out.println("Exception @ 3333"+e.toString());//common-icn-0181
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

