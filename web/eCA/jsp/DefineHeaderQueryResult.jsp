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
 <%

	
	String license_rights = "";
	if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
	{
		license_rights= "FULL";
	}
	else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
	{
		license_rights= "BASIC";
	}
	else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
	{
		license_rights= "MINI";
	}
	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    
	StringBuffer sql = new StringBuffer();

	String note_group_id  = request.getParameter("note_group_id");
	String note_type  = request.getParameter("note_type");
    String note_type_desc = request.getParameter("note_type_desc");
	if(note_type_desc == null){
		note_type_desc = "";
	}else{
		note_type_desc = note_type_desc.toUpperCase();
	}
    String event_class = request.getParameter("event_class");
    String confidential_yn = request.getParameter("confidential_yn");
	
	String eff_status = request.getParameter("eff_status");
//		String ca_note_type = request.getParameter("ca_note_type");

	String event_class_desc="";

	String note_group  ="", serv_facility ="", doc_link_note ="",	amnd_type="",applicability="";
    
	applicability = request.getParameter("applicability");
	if (applicability==null)
		applicability="";
	if ( (whereClause == null || whereClause.equals("")) )
    {


	

	if ( !(note_type == null || note_type.equals("")) )
        {
	        sql = new StringBuffer();
			sql.append(" and upper(a.note_type ) like upper('"+note_type +"%')");
			
        }

        if ( !(note_type_desc == null || note_type_desc.equals("")) )
        {
			
				sql.append(" and upper(a.note_type_desc) like '"+note_type_desc+"%'");
			

        }
		   if ( !(event_class == null || event_class.equals("")) )
        {
			
				sql.append(" and a.event_class like '"+event_class+"%'");
			
        }
		


		 if ( !(note_group_id == null || note_group_id.equals("")) )
        {
			sql.append(" and a.note_group_id like '"+note_group_id+"%'");
				
        }

    if ( !(eff_status == null || eff_status.equals("")) )
    {
         if( eff_status.equals("E") )
         {
  			  sql.append(" and a.eff_status='E'");
		  }
         if ( eff_status.equals("D") )
	     {
			  sql.append(" and a.eff_status='D'");
		 }
        
    }
if(!(confidential_yn == null || confidential_yn.equals("")))
		{
			if(confidential_yn.equals("N"))
			{
				 sql.append(" and a.confidential_yn='N'");
			}
			if(confidential_yn.equals("Y"))
			{
				 sql.append(" and a.confidential_yn='Y'");
			}
}

			note_group = request.getParameter("note_group");
			if(note_group != null || !(note_group.equals("")))
			{
			
				note_group = note_group.toUpperCase();
				if(note_group.equals("") || note_group==null) note_group = "%";
				else
				 note_group = note_group + "%";
				 sql.append(" and upper(b.NOTE_GROUP)  like  '"+note_group+"' ");
				
			}




			serv_facility = request.getParameter("serv_facility");
			if(serv_facility != null || !(serv_facility.equals("")))
			{
			
				serv_facility = serv_facility.toUpperCase();
				serv_facility = serv_facility + "%";
				
				
				
					sql.append(" and upper(a.SERV_FACL_SPEC_YN)  like  '"+serv_facility+"' ");
			}

		doc_link_note = request.getParameter("doc_link_note");
			if(doc_link_note != null || !(doc_link_note.equals("")))
			{
			
				doc_link_note = doc_link_note.toUpperCase();
				doc_link_note = doc_link_note + "%";

				
				
					sql.append(" and upper(a.DOC_LINKED_NOTE_YN)  like  '"+doc_link_note+"' ");
			}


amnd_type = request.getParameter("amnd_type");
			if(amnd_type != null || !(amnd_type.equals("")))
			{
			
				amnd_type = amnd_type.toUpperCase();
				amnd_type = amnd_type + "%";
				
				
				
					sql.append(" and upper(a.AMMENDMENT_TYPE)  like  '"+amnd_type+"' ");
			}


		if (!applicability.equals(""))
			sql.append("and "+applicability+" ='Y' ");

		


    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by ");
        for ( int i=0;i < ord.length;i++ )
        {
			sql.append("a.");
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

PreparedStatement stmt,stmt1;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;


String strsql="select count(*) as total from ca_note_type  a ,ca_note_group b where b.note_group(+) = a.NOTE_GROUP_ID"+sql.toString();
String strsql1="select a.note_type,a.note_type_desc, a.event_class, a.eff_status,b.note_group_desc,note_group_id,a.confidential_yn from  ca_note_type  a ,ca_note_group b where b.note_group(+) = a.NOTE_GROUP_ID "+sql.toString();
try
{
stmt = conn.prepareStatement(strsql);
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}

stmt1=conn.prepareStatement(strsql1);
rset = stmt1.executeQuery();
%>

<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td> 
<td nowrap  width='12%' align='right'>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/NoteTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("&nbsp;<A HREF='../../eCA/jsp/NoteTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table border="1" width="100%" cellspacing='0' cellpadding='3'>

<td class='columnheadercenter' width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='25%'><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td>
<%
if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
{
%>
<td class='columnheadercenter' width='30%'><fmt:message key="Common.Class.label" bundle="${common_labels}"/></td>
<%}%>
<td class='columnheadercenter' width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='20%'><fmt:message key="Common.Confidential.label" bundle="${common_labels}"/></td>

<%
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

     String note_group_id1		=(rset.getString("note_group_desc")==null)?"":rset.getString("note_group_desc");
	String note_type1		=(rset.getString(1)==null)?"":rset.getString(1);
    String note_type_desc1	=(rset.getString(2)==null)?"":rset.getString(2);
  
	String event_class1		=(rset.getString(3)==null)?"":rset.getString(3);
	String eff_status1		=(rset.getString(4)==null)?"":rset.getString(4);
	String conf_yn    =(rset.getString(7)==null)?"":rset.getString(7);
	if(event_class1.equals("PHY$")) event_class_desc="Physician";
	else if(event_class1.equals("NUR$")) event_class_desc="Nursing";
	else if(event_class1.equals("CLI$")) event_class_desc="Clinician";
	else if(event_class1.equals("REF$")) event_class_desc="Referral Letter";
	else if(event_class1.equals("NTF$")) event_class_desc="Notification Form";
	else if(event_class1.equals("MDR$")) event_class_desc="Medical Record";
	else if(event_class1.equals("MDB$")) event_class_desc="Medical Board";
	else  event_class_desc ="";
	
	out.println("<a href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=update&note_type="+ URLEncoder.encode(note_type1)+"' target='f_query_add_mod' >");
    out.println(note_type1 + "</a></td><td class='" + classValue + "'>");
 //   out.println("<a href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=update&note_type="+ URLEncoder.encode(note_type1)+"' target='f_query_add_mod' >");
   out.println(note_type_desc1);
   out.println("</td><td class='" + classValue + "'>");
	out.println(note_group_id1);
	if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
	{
		out.println("</td><td class='" + classValue + "'>");
//out.println("<a href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=update&note_type="+ 	URLEncoder.encode(note_type1)+"' target='f_query_add_mod' >");
		out.println(event_class_desc);
	}
    out.println("</td><td class='" + classValue + "' >");
    if ( eff_status1.equalsIgnoreCase("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	 out.println("</td><td class='" + classValue + "'>");
    if ( conf_yn.equalsIgnoreCase("Y") )
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
	//out.println("Exception @ 3333"+e.toString());//COMMON-ICN-0181
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

