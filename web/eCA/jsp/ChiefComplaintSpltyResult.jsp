<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%   
   request.setCharacterEncoding("UTF-8");
	String whereClause		= request.getParameter("whereclause");
	String complaint_id		= request.getParameter("complaint_id");
	String complaint_desc		= request.getParameter("complaint_desc");
	String speciality_code		= request.getParameter("speciality_code");
	String speciality_desc		= request.getParameter("speciality_desc");
	StringBuffer sql		=new StringBuffer();
	String from 			= request.getParameter("from") ; 
	String to 				= request.getParameter("to") ;
	String complaint_id1=null;
	String complaint_desc1=null;
	String speciality_code1=null;
	String speciality_desc1=null;
	if ( (whereClause == null || whereClause.equals("")) )
	{
		 // Changing to Upper case and checking





	if ( !(complaint_id == null || complaint_id.equals("")) )
	 {
		sql.append(" and upper(A.CA_CHIEF_COMPLAINT) LIKE Upper('"+complaint_id+"%') ");
	 }

	 	if ( !(complaint_desc == null || complaint_desc.equals("")) )
	 {
		sql.append(" and upper(B.COMPLAINT_DESC) LIKE Upper('"+complaint_desc+"%') ");
	 }

	 	if ( !(speciality_code == null || speciality_code.equals("")) )
	 {
		sql.append(" and upper(A.SPECIALITY_CODE) LIKE Upper('"+speciality_code+"%') ");
	 }

	 	if ( !(speciality_desc == null || speciality_desc.equals("")) )
	 {
		sql.append(" and upper(C.LONG_DESC) LIKE Upper('"+speciality_desc+"%') ");
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

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  StringBuffer strsql2=new StringBuffer();
	  strsql2.append("SELECT A.CA_CHIEF_COMPLAINT,B.COMPLAINT_DESC,C.SPECIALITY_CODE,c.LONG_DESC FROM CA_CHIEF_COMPLAINT_SPLTY A,CA_CHIEF_COMPLAINT B,am_speciality C where A.CA_CHIEF_COMPLAINT=B.COMPLAINT_ID and A.SPECIALITY_CODE=C.SPECIALITY_CODE ");
	  strsql2.append(sql.toString());
	  stmt = con.prepareStatement(strsql2.toString());
 	  rs = stmt.executeQuery();
	  String classValue = "" ;
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
<p>
<table align='right'> 
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eCA/jsp/ChiefComplaintSpltyResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eCA/jsp/ChiefComplaintSpltyResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ComplaintID.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ComplaintDescription.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.SpecialityDesc.label" bundle="${ca_labels}"/></td> 
<%}
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");	
	complaint_id1	=(rs.getString(1)==null)?"":rs.getString(1);
	complaint_desc1=(rs.getString(2)==null)?"":rs.getString(2); 
  	speciality_code1=(rs.getString(3)==null)?"":rs.getString(3); 
  	speciality_desc1=(rs.getString(4)==null)?"":rs.getString(4); 

	//out.println("eff_status...."+eff_status);
	out.println(complaint_id1+"</td>");
	out.println("<td class='" + classValue + "'>"+complaint_desc1+"</td>");
	out.println("<td class='" + classValue + "'>"+speciality_code1+"</td>");
	out.println("<td class='" + classValue + "'>"+speciality_desc1+"</td>");
	out.println("</tr>");

	i++;
 	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%} 
 %>
</td></tr>
</table>
<br><center>
</center>
<%

sql.setLength(0);
//strsql1.setLength(0);
strsql2.setLength(0);

if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
		e.toString();
		//out.println(e.toString());//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
     }
	finally   
	{
		 
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

