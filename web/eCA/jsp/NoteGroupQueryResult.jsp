<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @06-12-2008> -->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String note_group_id  = request.getParameter("note_group_id");
    String note_group_desc = request.getParameter("note_group_desc");
	if(note_group_desc == null)
	{
		note_group_desc = "";
	}
	else
	{
		note_group_desc = note_group_desc.toUpperCase();
	}
   // String applic_task = request.getParameter("applic_task");
    String note_encounter = request.getParameter("note_encounter");
	//String role_base= request.getParameter("role_base");
	String precondition_recording= request.getParameter("precondition_recording");
	//String event_class_desc="";
    String eff_status= request.getParameter("eff_status");
	 
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(note_group_id == null || note_group_id.equals("")) )
        {
			sql.append(" and upper(a.note_group ) like upper('"+note_group_id +"%')");
        }

        if ( !(note_group_desc == null || note_group_desc.equals("")) )
        {
				sql.append(" and upper(a.note_group_desc) like '"+note_group_desc+"%'");
        }
 if (!(note_encounter == null || note_encounter.equals("")))
        {
		sql.append(" and a.NO_OF_REC_PER_ENC like '"+note_encounter+"%'");

        }

  /*  if (!(role_base == null || role_base.equals("")))
    {
         if(role_base.equals("Y"))
         {
  		   sql.append(" and ROLE_BASED_ACCESS_YN='Y' ");
		 }
	     if ( role_base.equals("N") )
	     {
		   sql.append(" and ROLE_BASED_ACCESS_YN='N' ");
	     }
        
	  }
	  */

		
		 if ( !(precondition_recording == null)) //|| role_base.equals("")) )
	    {
			if( precondition_recording.equals("E") )
			{

			   sql.append(" and PRE_COND_FOR_REC='E'");
			}
			if ( precondition_recording.equals("D") )
			{

			   sql.append(" and PRE_COND_FOR_REC='D'");
			}
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
//ResultSet rs = null;


//String strsql="select count(*) as total from ca_note_group a,ca_appl_task b where a.APPL_TASK_ID = b.APPL_TASK_ID  "+sql.toString();
String strsql1="select a.note_group,a.note_GROUP_desc, b.APPL_TASK_desc APPL_TASK_ID, a.NO_OF_REC_PER_ENC,a.ROLE_BASED_ACCESS_YN,a.PRE_COND_FOR_REC,a.EFF_STATUS from  ca_note_group a,ca_appl_task b where a.APPL_TASK_ID = b.APPL_TASK_ID "+sql.toString();
//out.println("strsql"+strsql);
//out.println("\nstrsql22222222222222"+strsql1);
try
{
	conn  =  ConnectionManager.getConnection(request);
/*stmt = conn.prepareStatement(strsql);
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");
*/
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
    out.println("<A class='gridLink' HREF='../../eCA/jsp/NoteGroupQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/NoteGroupQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
<th class='columnheadercenter' width='15%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

<th class='columnheadercenter' width='20%'><fmt:message key="eCA.ApplicableTask.label" bundle="${ca_labels}"/></th>

<th class='columnheadercenter' width='20%'><fmt:message key="eCA.NumofNotePerEncounter.label" bundle="${ca_labels}"/></th>
<!--<th width='10%'>Role Based Access</th>-->
<th class='columnheadercenter' width='20%'><fmt:message key="eCA.PreconditionforRecording.label" bundle="${ca_labels}"/></th>
<th class='columnheadercenter' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>



<%
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

		String note_group_id1	=(rset.getString("NOTE_GROUP")==null)?"":rset.getString("NOTE_GROUP");
		String note_group_desc1	 =(rset.getString("NOTE_GROUP_DESC")==null)?"":rset.getString("NOTE_GROUP_DESC");
		String applic_task1	=(rset.getString("APPL_TASK_ID")==null)?"":rset.getString("APPL_TASK_ID");
		String note_encounter1		=(rset.getString("NO_OF_REC_PER_ENC")==null)?"&nbsp;":rset.getString("NO_OF_REC_PER_ENC");
//		String role_base1		=(rset.getString("ROLE_BASED_ACCESS_YN")==null)?"":rset.getString("ROLE_BASED_ACCESS_YN"); 
		String precondition_recording1		=(rset.getString("PRE_COND_FOR_REC")==null)?"":rset.getString("PRE_COND_FOR_REC");
		String effective_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
  
	out.println("<a class='gridLink' href='../../eCA/jsp/NoteGroupAddModify.jsp?mode=update&note_group_id="+ URLEncoder.encode(note_group_id1)+"' target='f_query_add_mod' >");
    out.println(note_group_id1 + "</a></td><td class='gridData'>");

    out.println(note_group_desc1);
	
		out.println("</td><td class='gridData'>");
		out.println(applic_task1);

    out.println("</td><td class='gridNumericData'>");
	out.println(note_encounter1);

   
    out.println("</td><td class='gridData'>");


   /* if ( role_base1.equalsIgnoreCase("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	out.println("</td><td class='" + classValue + "' align='center'>");*/

if(precondition_recording1.equals("D"))
{
	out.println("Discharge Advise");
}
else if (precondition_recording1.equals("E"))
{
out.println("Deceased");
}
else 
	out.println("&nbsp");

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

/*if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
*/
if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	//out.println("Exception from NoteGroupQueryResult JSP : "+e.getMessage());//common-icn-0181
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

