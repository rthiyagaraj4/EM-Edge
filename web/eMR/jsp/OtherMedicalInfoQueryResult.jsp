<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,com.ehis.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>


<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  onKeyDown = 'lockKey()' class='CONTENT'>");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patID	= request.getParameter("Patient_Id");
String locale	= (String) session.getAttribute("LOCALE"); 

Connection conn =null;
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

Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;

try{
conn=ConnectionManager.getConnection(request);
stmt=conn.createStatement();
String strsql2="select  to_char(ref_date,'dd/mm/yyyy') ref_date1, ref_no, category,remarks from MR_PAT_OTHER_MED_INFO where patient_id = '"+patID+"'";

rs = stmt.executeQuery(strsql2);

// variables for query retrieval

String ref_no 	= "";
String ref_date	= "";
String ref_date_display = "";
String category	= "";
String category_desc	= "";
String remarks	= "";

%>
<table border="1" width="100%" cellspacing='0' cellpadding='3' align=center>
<tr>
<td width='15%' class="COLUMNHEADER"><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
<td width='15%' class="COLUMNHEADER"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
<td width='15%' class="COLUMNHEADER"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
<td width='55%' class="COLUMNHEADER"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
</tr>
<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	    String classValue = "" ;
while ( rs.next() && i<=end )
{
	ref_no 	= rs.getString("ref_no");
	if(ref_no==null) ref_no="&nbsp;";
	ref_date	= rs.getString("ref_date1");
	if(ref_date==null){
		ref_date="&nbsp;";
		ref_date_display = "&nbsp;";
	}		
	else
		ref_date_display = DateUtils.convertDate(ref_date,"DMY","en",locale);



	category	= rs.getString("category");

	if(category==null) category_desc="&nbsp;";
	else if(category.equals("O")) category_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
	else if(category.equals("A")) category_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.adhoc.label","common_labels");
	else if(category.equals("R")) category_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels");
	else if(category.equals("C")) category_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Correspondence.label","mr_labels");

	remarks=rs.getString("remarks");
	if(remarks==null) remarks="&nbsp;";


if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'><a href=\"../../eMR/jsp/OtherMedicalInfoAddModify.jsp?Patient_Id="+patID+"&ref_no="+ref_no+"\"  target='addmodify'>");

	out.println("&nbsp;"+ref_no+"</a></td>");

	out.println("<td class='" + classValue + "'>");
	out.println(ref_date_display+"</td><td class='" + classValue + "'>");
	out.println(category_desc);
	//out.println("</td><td class='" + classValue + "'><input type='hidden' name='hidden"+i+"' id='hidden"+i+"' value=\""+remarks+"\"><a href='javascript:displayDetails1(document.getElementById("hidden")"+i+")' > ");
	out.println("<td class='" + classValue + "'><input type='hidden' name='hidden" + i + "' id='hidden" + i + "' value=\"" + remarks + "\"><a href='javascript:displayDetails1(document.getElementById(\"hidden" + i + "\"))'>Remarks</a></td>");
	//out.println("Remarks</a></td>");
	%>
	<%-- <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> --%></a></td>
	<%

	i++;

  }//endwhile
}catch(Exception e){
		//out.print(e.toString());
		e.printStackTrace();

}
	finally   {
try
		{
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
	if(rset!=null)
	rset.close();
		}
		catch(Exception e){


}
	ConnectionManager.returnConnection(conn,request);
	}
%>

</tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

