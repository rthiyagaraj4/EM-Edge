<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
	<head>
	<!-- <link rel='stylesheet' type ='text/css'  href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<!-- <modifeid by Arvind @06-12-2008> -->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
    String whereClause		=		request.getParameter("whereclause");
	if(whereClause==null) 
		whereClause="";

    StringBuffer sql=new StringBuffer();
	String note_seq_num			=		"";

	String from		=		request.getParameter( "from" ) ;
    String to				=		request.getParameter( "to" ) ;

	String note_type_display = "";
	String note_type_desc_display = "";
	String sec_hdg_code_display = "";
	String sec_hdg_desc_display = "";
	String note_seq_num_display = "";
	String CHIEF_COMPLAINT_SEC_YN_display="";
	String content_type="";
	
	String note_type		=		request.getParameter("note_type");
    String note_type_desc	=		request.getParameter("note_type_desc");
    String sec_hdg_code		=		request.getParameter("sec_hdg_code");
    String sec_hdg_desc		=		request.getParameter("sec_hdg_desc");

	String CHIEF_COMPLAINT_SEC_YN = request.getParameter("CHIEF_COMPLAINT_SEC_YN");

String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);



    if ( (whereClause == null || whereClause.equals("")) )
    {
			sql.append(" where b.note_type = a.note_type AND   c.sec_hdg_code = a.sec_hdg_code ");
		
		if ( !(note_type == null || note_type.equals("")) ){
	        sql.append(" and upper(a.note_type) like upper('"+note_type +"%')");
		}

        if ( !(note_type_desc == null || note_type_desc.equals("")) ){
			sql.append(" and upper(b.note_type_desc) like upper('"+note_type_desc+"%')");
		}
		
		if ( !(sec_hdg_code == null || sec_hdg_code.equals("")) ){
			sql.append(" and  upper(a.sec_hdg_code) like upper('"+sec_hdg_code+"%')");
		}
		
		if ( !(sec_hdg_desc == null || sec_hdg_desc.equals("")) ){
			sql.append(" and upper(c.sec_hdg_desc) like upper('"+sec_hdg_desc+"%')");
		}

if ( !(CHIEF_COMPLAINT_SEC_YN == null || CHIEF_COMPLAINT_SEC_YN.equals("")) )
    {
         if( CHIEF_COMPLAINT_SEC_YN.equals("E") )
         {
			   sql.append(" and CHIEF_COMPLAINT_SEC_YN='Y'");
         }
         if ( CHIEF_COMPLAINT_SEC_YN.equals("D") )
	     {
			   sql.append(" and CHIEF_COMPLAINT_SEC_YN='N'");
         }
         if ( CHIEF_COMPLAINT_SEC_YN.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
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
            sql.append(whereClause);



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

	Connection conn = null;

	PreparedStatement stmt1= null;
	int maxRecord = 0;
	ResultSet rset = null;
try
{
	conn  =  ConnectionManager.getConnection(request);	

	StringBuffer strsql=new StringBuffer();
	strsql.append("select count(*) as total from ca_note_section a, ca_note_type b, ca_section_hdg c");
	strsql.append(sql);


	stmt1=conn.prepareStatement(strsql.toString());
	rset = stmt1.executeQuery();
	rset.next();
	maxRecord = rset.getInt(1);
	if(rset !=null) rset.close();
	if(stmt1 != null)stmt1.close();


	if(maxRecord == 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	StringBuffer strsql1=new StringBuffer();
	strsql1.append("SELECT a.note_type note_type, b.note_type_desc note_type_desc, a.sec_hdg_code sec_hdg_code, c.sec_hdg_desc||nvl2(c.sec_hdr_meta_desc,' - '||c.sec_hdr_meta_desc,null) sec_hdg_desc, a.note_sec_seq_num note_seq_num,CHIEF_COMPLAINT_SEC_YN, content_type FROM ca_note_section a,ca_note_type b, ca_section_hdg c");
	strsql1.append(sql);

//out.println(strsql1.toString());
	
	
	stmt1=conn.prepareStatement(strsql1.toString());
	rset = stmt1.executeQuery();
	%>
	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
	<td class='white' width='88%'></td> 
	<td  align='right' width='12%' nowrap>
	<%
	if ( !(start <= 1) )
		out.println("<A class='gridLink'  href='../../eCA/jsp/SectionForNoteTypeQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+pageCnt) > maxRecord ) )
		out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/SectionForNoteTypeQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
	
	%>
	</td>
	</tr>
	</table>
	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
	<tr align='left'>
	<th class='columnHeadercenter'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></th>
	<th class='columnHeadercenter'><fmt:message key="eCA.NoteTypeDesc.label" bundle="${ca_labels}"/></th>
	<th class='columnHeadercenter'><fmt:message key="Common.SectionCode.label" bundle="${common_labels}"/></th>
	<th class='columnHeadercenter'><fmt:message key="Common.SectionDescription.label" bundle="${common_labels}"/></th>
	<th class='columnHeadercenter'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
	<th class='columnHeadercenter'><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/></th>
	</tr>

	<%
	   if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  rset.next() ;
	String classValue= " ";
		  while ( rset.next() && i<=end  ) {
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;



			note_type = rset.getString("note_type");
			note_type_desc=rset.getString("note_type_desc");
			sec_hdg_code= rset.getString("sec_hdg_code");
			sec_hdg_desc= rset.getString("sec_hdg_desc");
			note_seq_num= rset.getString("note_seq_num");
	CHIEF_COMPLAINT_SEC_YN=rset.getString("CHIEF_COMPLAINT_SEC_YN")==null?"N":rset.getString("CHIEF_COMPLAINT_SEC_YN");
			content_type=rset.getString("content_type");


			note_type_display = note_type;
			note_type_desc_display = note_type_desc;
			sec_hdg_code_display = sec_hdg_code;
			sec_hdg_desc_display = sec_hdg_desc;
			note_seq_num_display = note_seq_num;
			CHIEF_COMPLAINT_SEC_YN_display=CHIEF_COMPLAINT_SEC_YN;
			note_type = java.net.URLEncoder.encode(note_type);
			note_type_desc = java.net.URLEncoder.encode(note_type_desc);
			sec_hdg_code = java.net.URLEncoder.encode(sec_hdg_code);
			sec_hdg_desc = java.net.URLEncoder.encode(sec_hdg_desc);
			note_seq_num = java.net.URLEncoder.encode(note_seq_num);
			CHIEF_COMPLAINT_SEC_YN=java.net.URLEncoder.encode(CHIEF_COMPLAINT_SEC_YN);
			content_type=java.net.URLEncoder.encode(content_type);

	%>
		<tr>
			<td  class='gridData'  ><%= note_type_display %></td>
			<td class='gridData' ><%= note_type_desc_display %></td>
			<td class='gridData' ><%= sec_hdg_code_display %></td>
			<td class='gridData' ><%= sec_hdg_desc_display %></td>
			<td class='gridNumericData'  align='right'><%= note_seq_num_display%></td>
	<%
			out.println("<td class='gridData' align='center'>");
    if ( CHIEF_COMPLAINT_SEC_YN_display.equalsIgnoreCase("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
%>
		</tr>
	<%
		i++;
		} 
	%>

	</table>
	</center>

	<br><center>
<%
//rs.close();

	if(rset != null)rset.close();
	if(stmt1 != null)stmt1.close();

}
catch(Exception e)
{
	//out.println("Exception in main try"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

