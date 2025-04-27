<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String accession_num=request.getParameter("accession_num");
String notesHeader = request.getParameter("notesHeader");
String	notes_content		=	"";

java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;






//sqlStr.append("SELECT B.TERM_SET_DESC AS ProblemSet,A.TERM_CODE as DiagProb,A.TERM_CODE_SHORT_DESC as Description FROM PR_DIAGNOSIS A JOIN MR_TERM_SET B ON A.TERM_SET_ID = B.TERM_SET_ID WHERE A.PATIENT_ID = 'MC00000149'");

sqlStr.append("SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,'" + locale + "' ,'1') note_type_desc FROM ca_encntr_note a where  a.accession_num= '" + accession_num + "'");

Statement stmt				= null;
ResultSet rs				= null;

Statement stmt1				= null;
ResultSet rs1				= null;
ResultSet rs2				= null;
Connection conn=null;
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
String strRowCount = "";
try {
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
stmt1	 = conn.createStatement();
if (rs!=null) rs.close();   
rs = stmt.executeQuery(sqlStr.toString());

if(rs != null && rs.next())
{
	clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");

	if(clob_notes_content != null)
	{
		try
		{
			content_reader	= clob_notes_content.getCharacterStream();
			bf_content_reader = new java.io.BufferedReader(content_reader);
			char[] arr_notes_content = new char[(int)clob_notes_content.length()];
			bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
			notes_content = new String(arr_notes_content);
			bf_content_reader.close();
		}
		catch(Exception e)
		{
			out.println("Exception@2-readCLOB : "+e);
		}

		if(!notes_content.equals(""))
		{
			int nIndex	= notes_content.indexOf("<BODY>");
			int nIndex1 = notes_content.lastIndexOf("</BODY>");

			if(nIndex != -1 && nIndex1 != -1)
				notes_content = notes_content.substring(nIndex+6,nIndex1);
		}
	}//c
}

}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(conn,request);
}




%>

<!DOCTYPE html> 
<html> 
<head> 
<title>jQuery Mobile Application</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />
<!--  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />  -->
<script src="http://code.jquery.com/jquery-1.5.2.min.js"></script> 
<script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 
  <link rel="stylesheet" href="iPadViewNotes.css" />  

<script>

</script>
<style>
  .ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
  .white
  {
    
  }
</style>
</head>

<body  style = "background-color : #ffffff">

 <form>
 
<table border="0" width="100%" cellspacing='0' cellpadding='3' id='tb1'>
<tr style="width:100%;height:100%" class = "dvViewNotes">
         <td style = "width : 90%" align = "left" valign = "center">
            <span class = "spanViewNotes"><%=notesHeader %></span>
            
       </tr>
<tr>
<td class='white' align='left'><%=notes_content%></td>
</tr>
</table>

</form> 
  

</body>

</html>

