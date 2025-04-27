<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*
 "  contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 <html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String doc_type = request.getParameter("doc_type");
	if(doc_type != null)
		doc_type=doc_type.toUpperCase();
	String longdesc = request.getParameter("long_desc");
	if(longdesc != null)
		longdesc=longdesc.toUpperCase();
	String enabled = request.getParameter("enabled");

	int andCheck = 0;


	if ( !(doc_type == null || doc_type.equals("")) )
		{
		sbQuery.append("where upper(doc_type) like '");
		sbQuery.append(doc_type);
		sbQuery.append("%'");
		andCheck = 1;
		}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append(" upper(long_desc) like  '");
			sbQuery.append(longdesc);
			sbQuery.append("%'" );
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(long_desc) like '");
			sbQuery.append(longdesc);
			sbQuery.append("%'");
			andCheck = 1;
		}
	}
	if ( !(enabled == null || enabled.equals("") || enabled.equals("B")) )
	{
		String strEffStatus="";
		if(enabled.equals("E"))
			strEffStatus="E";
		else if(enabled.equals("D"))
			strEffStatus="D";
		
		if(andCheck == 0 ){
			sbQuery.setLength(0);
			sbQuery.append("where eff_status='"+strEffStatus+"'");
		}else{
			sbQuery.append(" and eff_status='"+strEffStatus+"'");
		}
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);

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
PreparedStatement pstmt=null;
ResultSet rs=null;
		//int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);

	Boolean isSuppDocFieldAvail	= eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","GENERATE_FORM_60"); //Added by Sangeetha for KDAH-CRF-0347

	/*pstmt = conn.prepareStatement("select count(*) as total from mp_document_type"+sbQuery.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");

	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
		
	if (maxRecord==0) 				
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

	//pstmt = conn.prepareStatement("select doc_type, long_desc, short_desc, eff_Status from mp_document_type order by doc_type");
	pstmt = conn.prepareStatement("select doc_type, long_desc, short_desc, eff_Status, ADDRESS_PROOF_YN,IDENTITY_PROOF_YN from mp_document_type "+sbQuery.toString());  //Added IDENTITY_PROOF_YN,IDENTITY_PROOF_YN by Dharma for KDAH-CRF-0347
	rs = pstmt.executeQuery(); %>


<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  	  String classValue = "" ;
		  int cnt=0;

while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryDocumentType.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryDocumentType.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>

		<center>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<% if(isSuppDocFieldAvail) { %>
		<th><fmt:message key="eMP.SuppDocType.label" bundle="${mp_labels}"/></th> <!--Added by Sangeetha for KDAH-CRF-0347 -->
		<% } %>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%	}
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	//Added by Sangeetha for KDAH-CRF-0347
	String ADDRESS_PROOF_YN = "";
	String IDENTITY_PROOF_YN = "";
	String supportDocTypeDisp	= "";
	ADDRESS_PROOF_YN	=	checkForNull(rs.getString("ADDRESS_PROOF_YN"));
	IDENTITY_PROOF_YN	=	checkForNull(rs.getString("IDENTITY_PROOF_YN"));
	if(ADDRESS_PROOF_YN.equals("Y")){
		supportDocTypeDisp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AddrProof.label","mp_labels");
	}
	//if(!supportDocTypeDisp.equals("")){
	if(ADDRESS_PROOF_YN.equals("Y") && IDENTITY_PROOF_YN.equals("Y")){
		supportDocTypeDisp = supportDocTypeDisp +" , ";
	}
	if(IDENTITY_PROOF_YN.equals("Y")){
		supportDocTypeDisp = supportDocTypeDisp + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IDProof.label","mp_labels");
	}
	supportDocTypeDisp	= supportDocTypeDisp + "&nbsp;";
	

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String code = rs.getString("doc_type");

	out.println("<a href='../../eMP/jsp/DocumentTypeModify.jsp?doc_type="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	
	//Added by Sangeetha for KDAH-CRF-0347
	if(isSuppDocFieldAvail) { 
		out.println("</td><td class='" + classValue + 
			"'  align='center'>"+supportDocTypeDisp+"");
	}
	out.println("</td><td class='" + classValue + 
		"'  align='center'>");
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	cnt++;
} 
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
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



	<%}%>

</td></tr>
</table>
</center>

<br><center>
<%

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
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

