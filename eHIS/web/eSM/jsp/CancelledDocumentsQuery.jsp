<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        <script src="../../eSM/js/CancelledDocuments.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onload='parent.commontoolbarFrame.document.getElementById("reset").disabled=true;'>
<form name="entity_acct_params" id="entity_acct_params"  method="post" target="messageFrame">
<%
    request.setCharacterEncoding("UTF-8");
     String doc_type_code	= "";
	 String doc_num	= "";
	 String narration = "";
	 String cancelled_date = "";
	 String classValue = "";

	 Connection con = ConnectionManager.getConnection(request);
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	
     String from = request.getParameter( "from" ) ;
	 String to = request.getParameter( "to" ) ;
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
	 try
		{
			pstmt = con.prepareStatement("select DOC_TYPE_CODE, DOC_NUM, NARRATION, to_char(CANCELLED_DATE,'dd/mm/yyyy') CANCELLED_DATE1 from SY_DOC_CONTROL order by DOC_TYPE_CODE, DOC_NUM ");

			rs = pstmt.executeQuery();
			int cnt=0;
	  String endOfRes="1";
	  	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
  
 while (i<=end && rs.next()){
	if(cnt==0){

%>
<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eSM/jsp/CancelledDocumentsQuery.jsp?from="+(start-14)+"&to="+(end-14)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eSM/jsp/CancelledDocumentsQuery.jsp?from="+(start+14)+"&to="+(end+14)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</P>

			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
		
		    <th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSM.DocNumber.label" bundle="${sm_labels}"/></th>
			<th><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.CancellationDate.label" bundle="${common_labels}"/></th>
			</tr>

<%}		
cnt++;

if (i % 2 == 0 )
  	classValue = "QRYEVEN" ;
 else
  	classValue = "QRYODD" ;
                
				 doc_type_code	= (rs.getString("DOC_TYPE_CODE")==null?"&nbsp;":rs.getString("DOC_TYPE_CODE"));
				 doc_num	= (rs.getString("DOC_NUM")==null?"&nbsp;":rs.getString("DOC_NUM"));
		        // narration	= (rs.getString("NARRATION")==null?"&nbsp;":rs.getString("NARRATION"));
		         narration	= rs.getString("NARRATION");
				 if(narration==null || narration.equals(" "))
				 narration="&nbsp;";
				 cancelled_date	= (rs.getString("CANCELLED_DATE1")==null?"&nbsp;":rs.getString("CANCELLED_DATE1"));
				 out.println("<tr>");
				 out.println("<td class='" + classValue + "'>"+doc_type_code +"</td>");
				 out.println("<td class='" + classValue + "'>"+doc_num +"</td>");
				 out.println("<td class='" + classValue + "'>"+narration +"</td>");
				 out.println("<td class='" + classValue + "'>"+cancelled_date +"</td>");
				 out.println("</tr>");

				 i++;

	
			}
			if( cnt == 0 )
	//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		if(!rs.next()&&cnt!=0){
	endOfRes="0";
	%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%}
 %>

 <%
			if(rs!=null)rs.close();
			pstmt.close();
		}catch(Exception e)
		{ out.println(e); }
      finally{
		 	 if(rs!=null) rs.close();
			 if(pstmt!=null) pstmt.close();
		     if(con!=null)
		 ConnectionManager.returnConnection(con,request);
	}

		
%>
</table>
</form>
</body>
</html>

