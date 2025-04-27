<%@page
	import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String locale = "en";
	StringBuffer sqlStr = new StringBuffer("");

	String accession_num = request.getParameter("accession_num");
	String hist_rec_type = request.getParameter("hist_rec_type");
	String contr_sys_id = request.getParameter("contr_sys_id");
	String contr_sys_event_code = request
			.getParameter("contr_sys_event_code");
	String notes_content = "";
	//String notesHeader = request.getParameter("notesHeader");
	//String	notes_content		=	"";

	java.sql.Clob clob_notes_content = null;
	java.io.Reader content_reader = null;
	java.io.BufferedReader bf_content_reader = null;

	//sqlStr.append("SELECT B.TERM_SET_DESC AS ProblemSet,A.TERM_CODE as DiagProb,A.TERM_CODE_SHORT_DESC as Description FROM PR_DIAGNOSIS A JOIN MR_TERM_SET B ON A.TERM_SET_ID = B.TERM_SET_ID WHERE A.PATIENT_ID = 'MC00000149'");

	//sqlStr.append("SELECT HIST_DATA FROM cr_encounter_detail_txt WHERE hist_rec_type = "+ hist_rec_type +" AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code AND DBMS_LOB.getlength (hist_data) > 0)");
	sqlStr.append("SELECT HIST_DATA FROM cr_encounter_detail_txt WHERE hist_rec_type = '"
			+ hist_rec_type
			+ "' AND contr_sys_id = '"
			+ contr_sys_id
			+ "' AND accession_num = '"
			+ accession_num
			+ "' AND contr_sys_event_code = '"
			+ contr_sys_event_code
			+ "'");
	Statement stmt = null;
	ResultSet rs = null;

	Statement stmt1 = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	Connection conn = null;
	int maxRecord = 0;
	int start = 0;
	int end = 0;
	int i = 1;
	String strRowCount = "";
	try {
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		stmt1 = conn.createStatement();
		
		
		rs = stmt.executeQuery(sqlStr.toString());
		

		if (rs != null && rs.next()) {
			clob_notes_content = (java.sql.Clob) rs
					.getObject("HIST_DATA");

			if (clob_notes_content != null) {
				try {
					content_reader = clob_notes_content
							.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(
							content_reader);
					char[] arr_notes_content = new char[(int) clob_notes_content
							.length()];
					bf_content_reader.read(arr_notes_content, 0,
							(int) clob_notes_content.length());
					notes_content = new String(arr_notes_content);
					//out.println("notes content=" + notes_content);
					bf_content_reader.close();
				} catch (Exception e) {
					out.println("Exception@2-readCLOB : " + e);
				}

				/*if (notes_content != null
						&& !notes_content.trim().equals("")) {
					int nIndex = notes_content.indexOf("<BODY>");
					int nIndex1 = notes_content.lastIndexOf("</BODY>");

					if (nIndex != -1 && nIndex1 != -1)
						notes_content = notes_content.substring(
							nIndex + 6, nIndex1);

				}*/
				
			}//c
			else {
				out.println("notes content is null");
			}
		} else {
			out.println("rs is null");
		}

	} catch (Exception e) {
		out.println("Exception " + e);
		//out.println(sqlStr.toString());
		e.printStackTrace();
	} finally {
		if (rs != null)
			rs.close();
		if (rs1 != null)
			rs1.close();
		if (stmt1 != null)
			stmt1.close();
		if (stmt != null)
			stmt.close();

		ConnectionManager.returnConnection(conn, request);
	}
%>

<!DOCTYPE html>
<html>
<head>
<title>jQuery Mobile Application</title>
<meta name="apple-mobile-web-app-capable" content="yes" />

<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 
<link rel="stylesheet" href="../css/ipadAllergyContent.css" />


<script>
function noteclose()
{
	//document.getElementById("notesContentFrame2").src = "../jsp/widgetResultDetail.jsp";
	window.parent.closenotes();
}
function changeOrientation(orient)
{
		
	if(orient == "landscape")
	   {
	
	    $("#notes").css('min-height','470px');
	 
	   
	   }
     else
	   {
    	 
    	$("#notes").css('min-height','726px');
   
	   }
 
}
</script>
<style>
.ADDRESS {
	FONT-FAMILY: Arial;
	FONT-SIZE: 10pt;
	FONT-STYLE: NORMAL;
	COLOR: BLACK;
}

.white {
	
}
</style>
</head>

<body style="background-color: #ffffff">

	<form>
       <div id = "notes" style = "height:auto;overflow:auto;padding:0px;background-color: #ffffff" data-role = "none"> 
       
		<table border="0" width="100%" cellspacing='0' cellpadding='3'>
			
            <tr >  
            <td style = "width : 80%">&nbsp;&nbsp;</td>
            <td style = "width : 20%" align = "right" valign = "center" >
          
          <input type ="button" name='Close_btn' id='Close_btn' value='Close' class="btnType1"  data-role = "none" onclick = "noteclose()" />
            
         </td>
            </tr>
			<tr >
				<td align='left'><%=notes_content%></td>
			</tr>
		</table>
</div>
	</form>


</body>

</html>

