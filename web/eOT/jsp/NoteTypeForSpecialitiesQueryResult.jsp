<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");

%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<HTML>
<head>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
	<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script>   -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%	try{

    String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String speciality_code =request.getParameter("speciality_code")==null?"":request.getParameter( "speciality_code" );
	String locn_type = request.getParameter("locn_type")==null?"":request.getParameter( "locn_type" );
	String note_type = request.getParameter("note_type")==null?"":request.getParameter( "note_type" );
	String sql="";
    String speciality_desc="";
	
	
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;
	
	if ( !(speciality_code == null || speciality_code.equals("")) )
		{
			sql+= " and  A.specialty_code = '"+speciality_code+"' ";
			//andCheck = 1;
			cnt++;
		}


	if ( !(locn_type == null || locn_type.equals("all")) )
		{
		if(cnt>0)
			sql+= " and  A.locn_type='"+locn_type+"'";
			//andCheck = 1;
			else{
				sql=sql+" and A.locn_type='"+locn_type+"'";
				cnt=1;

		}
	} 
	 
	
	if ( !(note_type == null || note_type.equals("")) )
		{
			if(cnt>0)
			sql+= " and  upper(A.note_type) like upper('%"+note_type+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" and upper(A.note_type) like upper('%"+note_type+"%')";
				cnt=1;
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
	}//end of where clause IF

 else
    {
	sql = whereClause;
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

Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rs=null;
ResultSet rset=null;
int maxRecord = 0;
try{

//String strsql="SELECT A.SPECIALTY_CODE, B.SHORT_DESC, DECODE(A.LOCN_TYPE, '10',' Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, C.NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES A, AM_SPECIALITY_LANG_VW B, CA_NOTE_TYPE C WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALTY_CODE=B.SPECIALITY_CODE AND A.NOTE_TYPE=C.NOTE_TYPE" +sql;

String strsql="SELECT A.SPECIALTY_CODE, B.SHORT_DESC, DECODE(A.LOCN_TYPE, '10',' Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, C.NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES A, AM_SPECIALITY_LANG_VW B, CA_NOTE_TYPE_LANG_VW C WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALTY_CODE=B.SPECIALITY_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND A.NOTE_TYPE=C.NOTE_TYPE" +sql ;

//String strsql1="SELECT A.SPECIALTY_CODE, B.SHORT_DESC, DECODE(A.LOCN_TYPE, '10',' Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, C.NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES A, AM_SPECIALITY_LANG_VW B, CA_NOTE_TYPE C WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALTY_CODE=B.SPECIALITY_CODE AND A.NOTE_TYPE=C.NOTE_TYPE" +sql;

String strsql1="SELECT A.SPECIALTY_CODE, B.SHORT_DESC, DECODE(A.LOCN_TYPE, '10',' Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, C.NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES A, AM_SPECIALITY_LANG_VW B, CA_NOTE_TYPE_LANG_VW C WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALTY_CODE=B.SPECIALITY_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND A.NOTE_TYPE=C.NOTE_TYPE" +sql;


   stmt = conn.prepareStatement(strsql);
   rs = stmt.executeQuery();
 int total=0;
		while(rs.next()){
		total++;
	}

	 maxRecord=total;
	if(maxRecord == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		out.println("Err Msg From NoteTypeSpecialitiesQueryResult.jsp :: "+e);
	}

%>
<form name='QueryResult' id='QueryResult'>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eOT/jsp/NoteTypeForSpecialitiesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )

		out.println("<A HREF='../../eOT/jsp/NoteTypeForSpecialitiesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding=3>
<td class='columnHeaderCenter' >
	<fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/>
</td>
<td class='columnHeaderCenter' >
	<fmt:message key="Common.SpecialtyDescription.label" bundle="${common_labels}"/>
</td>
<td class='columnHeaderCenter' >
	<fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>
</td>
<td class='columnHeaderCenter' >
	<fmt:message key="Common.NoteType.label" bundle="${common_labels}"/> </td>


<%
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
	String classValue = "" ;
	
while ( rset.next() && i<=end )
{
        if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		

	out.println("<tr><td class='" + classValue + "'>");

	 speciality_code = rset.getString(1);
	 speciality_desc = rset.getString(2);
	 locn_type = rset.getString(3);
	 note_type = rset.getString(5);

	out.println(speciality_code+"</td><td class='" + classValue + "'>");
	out.println(speciality_desc+"</td><td class='" + classValue + "'>");
	out.println(locn_type+"</td><td class='" + classValue + "'>");
	out.println(note_type+"</td>");

	
	i++;

}


		
%>

</td></tr>
</table>
<br><center>
<%
	if(stmt!=null)
			stmt.close();
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
		if(rs!=null)
			rs.close();
		ConnectionManager.returnConnection(conn,request);

		}
catch(Exception e)
{
	out.println("here "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

