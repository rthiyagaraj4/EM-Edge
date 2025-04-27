<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	if ( whereClause == null ) whereClause = "" ;

	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	if ( from == null ) from = "1" ;

	String to = request.getParameter( "to" ) ;
	if ( to == null ) to = "14" ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	String APPL_USER_ID = request.getParameter("APPL_USER_ID");
	String user_name=request.getParameter("user_name");
	String pseriescode = request.getParameter("pat_ser_grp_code");
	String pshortdesc = request.getParameter("short_desc");

	if ( APPL_USER_ID == null ) APPL_USER_ID = "" ;
	if ( user_name == null ) user_name = "" ;
	if ( pseriescode == null ) pseriescode = "" ;
	if ( pshortdesc == null ) pshortdesc = "" ;
	APPL_USER_ID=APPL_USER_ID.toUpperCase();
	pseriescode=pseriescode.toUpperCase();
	user_name=user_name.toUpperCase();
	pshortdesc=pshortdesc.toUpperCase();

	int andCheck = 0;
	if ( !(APPL_USER_ID == null || APPL_USER_ID.equals("")) )
		{
			sql.append(" where appl_user_id like '");
			sql.append(APPL_USER_ID);
			sql.append("%'");
			andCheck = 1;
		}

	if ( !(user_name == null || user_name.equals("")) )
		{
		if ( andCheck == 1 )
				{
					sql.append( " and ");
					sql.append( " upper(sm_get_desc.sm_appl_user (appl_user_id, '"+localeName+"', 1)) like  '");
					sql.append(user_name);
					sql.append("%'");
				}
				else
				{
					sql.append(" where upper(sm_get_desc.sm_appl_user (appl_user_id, '"+localeName+"', 1)) like '");
					sql.append(user_name);
					sql.append("%'");
					andCheck = 1;
				}

		}

	if ( !(pseriescode == null || pseriescode.equals("")) )
		{
			if(andCheck==1)
				{
					sql.append( " and ");
					sql.append(" pat_ser_grp_code like  '");
					sql.append(pseriescode);
					sql.append("%'");
				}
			else{
				sql.append(" where pat_ser_grp_code like '");
				sql.append(pseriescode);
				sql.append("%'");
				andCheck = 1;
			}
		}

	if ( !(pshortdesc == null || pshortdesc.equals("")) )
		{
			if(andCheck==1)
				{
						sql.append( " and ");
						sql.append( "upper(MP_GET_DESC.MP_PAT_SER_GRP(pat_ser_grp_code,'"+localeName+"','2')) like  '");
						sql.append(pshortdesc);
						sql.append("%'");
				}
			else{
						sql.append(" where upper(MP_GET_DESC.MP_PAT_SER_GRP(pat_ser_grp_code,'"+localeName+"','2')) like '");
						sql.append(pshortdesc);
						sql.append("%'");
						andCheck = 1;
			}
		}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{

			sql.append(" order by ");



			for ( int i=0;i < ord.length;i++ )
		 	{
			 	if ( i == ord.length - 1 ){
				sql.append(ord[i]);

				}
				else
				{
				sql.append(ord[i]);
				sql.append(",");

				}
			}

		}
	} //end of where clause IF
	else
	{
		sql.setLength(0);
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

Connection conn = null;
//PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
//ResultSet rs=null;
ResultSet rset=null;
/*int maxRecord = 0;
try{
	
	String strSQL="select count(*) as total from mp_pat_ser_grp_for_user "+sql.toString();
	//out.println(strSQL);
	pstmt = conn.prepareStatement(strSQL);
	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
}catch(Exception e){out.println(e.toString());}
finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
}
if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");*/
try{
	conn = ConnectionManager.getConnection(request);
	String strSQL1="select APPL_USER_ID,sm_get_desc.sm_appl_user (appl_user_id, '"+localeName+"', 1)user_name,PAT_SER_GRP_CODE,MP_GET_DESC.MP_PAT_SER_GRP(pat_ser_grp_code,'"+localeName+"','2') short_desc from mp_pat_ser_grp_for_user "+sql.toString();

	//out.println("strSQL1---->"+strSQL1);
	pstmt1 = conn.prepareStatement(strSQL1);
	rset = pstmt1.executeQuery();
%>


<%
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
		    String classValue = "" ;
	int cnt=0;
while ( i<=end && rset.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>
		<%

		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../jsp/PatientSeriesGroupForUserQueryResultPage.jsp?from="+(start-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"&to="+(end-14)+"&text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../jsp/PatientSeriesGroupForUserQueryResultPage.jsp?from="+(start+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"&to="+(end+14)+"&text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
				else
			classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");

	String uid = rset.getString(1);
	String udesc = rset.getString(2);
	String pcode = rset.getString(3);
	String pdesc = rset.getString(4);
	out.println(uid+"</td><td class='" + classValue + "'>");

	out.println(udesc+"<!-- </a> --></td><td class='" + classValue + "'>");
	out.println(pcode+"<!-- </a> --></td><td class='" + classValue + "'>");
	out.println(pdesc+"<!-- </a> --></td>");
	i++;
	cnt++;

}
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rset.next()) ) { 
	%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

}catch(Exception e){
	out.println(e.toString());
	e.printStackTrace();
if(rset!=null)rset.close();
if(pstmt1!=null)pstmt1.close();
}
finally
	{
	 if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>

</tr>
</table>
<br><center>
<%


%>

</center>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

