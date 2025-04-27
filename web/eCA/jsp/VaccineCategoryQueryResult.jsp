<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
 <% 
    request.setCharacterEncoding("UTF-8");
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
 	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    
	StringBuffer sql = new StringBuffer();
	String vaccine_Category_id  = request.getParameter("vaccine_Category_id");
    String vaccine_long_desc = request.getParameter("vaccine_long_desc");
    String vaccine_short_desc = request.getParameter("vaccine_short_desc");

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(vaccine_long_desc == null)
	{
	 vaccine_long_desc = "";
	}else
	{
	  vaccine_long_desc = vaccine_long_desc.toUpperCase();
	}

	if(vaccine_short_desc == null)
	{
	 vaccine_short_desc = "";
	}else
	{
	  vaccine_short_desc = vaccine_short_desc.toUpperCase();
	}
	String eff_status = request.getParameter("eff_status");

	
	 int count = 0;
	if ( (whereClause == null || whereClause.equals("")) )
    {

	if ( !(vaccine_Category_id == null || vaccine_Category_id.equals("")) )
        {
			sql.append(" where upper( VACC_CATEG_ID) like upper('"+vaccine_Category_id +"%')");
			count =  1;
        }

        if ( !(vaccine_long_desc == null || vaccine_long_desc.equals("")) )
        {
			if(count == 1)
				sql.append(" and upper( LONG_DESC) like '"+vaccine_long_desc+"%'");
		else
			{
			sql.append(" where upper(LONG_DESC) like '"+vaccine_long_desc+"%'");
			count=1;
			}	

        }
		
        if ( !(vaccine_short_desc == null || vaccine_short_desc.equals("")) )
        {
			if(count == 1)
				sql.append(" and upper( SHORT_DESC) like upper('"+vaccine_short_desc+"%')");
			else
			{
			sql.append(" where upper(SHORT_DESC) like upper('"+vaccine_short_desc+"%')");
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
			
        if ( i == ord.length - 1 )
            sql.append(ord[i]);
        else
            sql.append(ord[i]+",");
        }
    }

    } //end of where clause IF
    else{
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
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;


Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement stmt,stmt1;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;
String strsql="select count(*) as total from CA_IM_VAC_CATEG "+sql.toString();

String strsql1="select VACC_CATEG_ID,LONG_DESC,SHORT_DESC,EFF_STATUS from  CA_IM_VAC_CATEG "+sql.toString();

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
    out.println("<A class='gridLink'  href='../../eCA/jsp/VaccineCategoryQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/VaccineCategoryQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>

<th class='columnheadercenter' width="25%"><fmt:message key="eCA.CategoryId.label" bundle="${ca_labels}"/></th>
<th class='columnheadercenter' width="25%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' width="25%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' width="25%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>



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
			  classValue = "gridData" ;
		 else
			   classValue = "gridData" ;

		out.println("<tr><td align=='left' class='" + classValue + "'>");

		 
		String vaccine_Category_id1		=(rset.getString("VACC_CATEG_ID")==null)?"":rset.getString("VACC_CATEG_ID");
		String vaccine_long_desc1	=(rset.getString("LONG_DESC")==null)?"":rset.getString("LONG_DESC");
	  
		String vaccine_short_desc1		=(rset.getString("SHORT_DESC")==null)?"":rset.getString("SHORT_DESC");
		String eff_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");

		out.println("<a class='gridLink'  href='../../eCA/jsp/VaccineCategoryAddModify.jsp?mode=update&vaccine_Category_id="+ URLEncoder.encode(vaccine_Category_id1)+"' target='f_query_add_mod' >");
		out.println(vaccine_Category_id1 + "</a></td><td class='" + classValue + "'>");
		out.println(vaccine_long_desc1);
		out.println("</td><td class='" + classValue + "'>");
		out.println(vaccine_short_desc1);
		
		out.println("</td><td class='" + classValue + "'>");

		if ( eff_status1.equalsIgnoreCase("E") )
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
//rs.close();
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	e.printStackTrace();
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




