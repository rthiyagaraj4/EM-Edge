<!DOCTYPE html>

<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


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
	String note_group_id  = request.getParameter("report_name");
    String note_group_desc = request.getParameter("report_type");
	if(note_group_desc == null)
	{
		note_group_desc = "";
	}
	else
	{
		note_group_desc = note_group_desc.toUpperCase();
	}
   // String applic_task = request.getParameter("applic_task");
    //String note_encounter = request.getParameter("note_encounter");
	//String role_base= request.getParameter("role_base");
	//String precondition_recording= request.getParameter("precondition_recording");
	//String event_class_desc="";
//	String default_age_group=request.getParameter("default_age_group");
    String eff_status= request.getParameter("eff_status");
	 
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(note_group_id == null || note_group_id.equals("")) )
        {
			sql.append(" and upper(report_name) like '"+note_group_id +"%'");
			//sql.append(" and upper(a.note_group ) like upper('"+note_group_id +"%')");
        }

        if ( !(note_group_desc == null || note_group_desc.equals("")) )
        {
				if(note_group_desc.equals("SC"))
				sql.append(" and upper(report_type) like 'SC'");
				else if(note_group_desc.equals("LC"))
				sql.append(" and upper(report_type) like 'LC'");
				else
				sql.append("");
        }


	if ( !(eff_status == null || eff_status.equals("")) )
    {
         if( eff_status.equals("E") )
         {
			   sql.append(" and eff_status='E'");
         }
         if ( eff_status.equals("D") )
	     {

			   sql.append(" and eff_status='D'");
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
    else
	{
		 sql.append(whereClause);
	}



    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null ){
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
		end =  Integer.parseInt(MstQryPageCnt);
	}
    else
        end = Integer.parseInt( to ) ;

Connection conn  = null;

PreparedStatement stmt1;
int maxRecord = 0;
ResultSet rset = null;

String strsql1="select * from CA_TEMPLATE_REPORT_LIST where 1=1"+sql.toString();
//String strsql1="select a.note_group,a.note_GROUP_desc, b.APPL_TASK_desc APPL_TASK_ID, a.NO_OF_REC_PER_ENC,a.ROLE_BASED_ACCESS_YN,a.PRE_COND_FOR_REC,a.EFF_STATUS from  ca_note_group a,ca_appl_task b where a.APPL_TASK_ID = b.APPL_TASK_ID "+sql.toString();

try
{
	conn  =  ConnectionManager.getConnection(request);

stmt1=conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
rset = stmt1.executeQuery();
while(rset.next())
{
	maxRecord++;
}
if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}


%>

<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
 <td class='white' width='100%'></td> <!-- <88 to 100Updated by Arvind @19-12-08> -->
<td  width='25%' nowrap>
<%
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
if ( !(start <= 1) )
    out.println("<A class='gridLink' HREF='../../eCA/jsp/TemplateReportListQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/TemplateReportListQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
<td class='columnheadercenter' width='15%'><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='25%'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>

<td class='columnheadercenter' width='20%'><fmt:message key="eCA.DefaultAgeGrp.label" bundle="${ca_labels}"/></td>

<td class='columnheadercenter' width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<%
PreparedStatement pst_seq = null;
ResultSet rs_seq = null;

rset.beforeFirst();

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

	out.println("<tr><td class='gridData'>");

		String note_group_id1	=(rset.getString("REPORT_NAME")==null)?"":rset.getString("REPORT_NAME");
		String note_group_desc1	 =(rset.getString("REPORT_TYPE")==null)?"":rset.getString("REPORT_TYPE");
		String applic_task1	=(rset.getString("DEFULT_AGE_GROUP")==null)?"":rset.getString("DEFULT_AGE_GROUP");
		
		String effective_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
  
	String new_note_group_desc1="";
	if(note_group_desc1.equals("SC"))
		new_note_group_desc1="Simple Count";
	else
		new_note_group_desc1="List Choice Count";

	out.println("<a class='gridLink' href='../../eCA/jsp/TemplateReportListAddModify.jsp?mode=update&report_name="+ URLEncoder.encode(note_group_id1)+"' target='f_query_add_mod' >");
    out.println(note_group_id1 + "</a></td><td class='gridData'>");
	
    out.println(new_note_group_desc1);
	
	   
String new_sql="Select SHORT_DESC description from am_age_group Where upper(AGE_GROUP_CODE) LIKE  UPPER(?)  ";
		
		
			pst_seq = conn.prepareStatement(new_sql);
			pst_seq.setString(1,applic_task1);
			rs_seq =  pst_seq.executeQuery();
			
			String new_applic_task1="";
			if (rs_seq.next())
			{
				new_applic_task1=rs_seq.getString("description");
			}

			if(rs_seq != null) rs_seq.close();
			if(pst_seq != null) pst_seq.close();

    out.println("</td><td class='gridData'>");

out.println(new_applic_task1);
    out.println("</td><td class='gridData'>");
	
 if ( effective_status1.equalsIgnoreCase("E") )
    {
	 out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	}
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


if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	out.println("Report name "+note_group_id);
	out.println("Report type "+note_group_desc);
	out.println("Effective status "+eff_status);
	//out.println("Exception from TemplateReportListQueryResult JSP : "+e.getMessage());//COMMON-ICN-0181
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

