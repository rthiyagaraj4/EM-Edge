<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String accession_num=request.getParameter("accession_num");
String notesHeader = "header";//request.getParameter("notesHeader");
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
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<script type="text/javascript">
var noteScroll;
function notesScroll() {
	 setTimeout(function () {
		noteScroll = new iScroll('divcnt', {
		useTransform: true,
		zoom: false,
	
		});
}, 1000); 
}
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
document.addEventListener('DOMContentLoaded', notesScroll, false);
function changeOrientation(orient, EMHFheight)
{
	var CSHFheight = $('#allergyHeader').height();
	var content_height = parent.getTotalPageDivHeight() - EMHFheight- CSHFheight-6  ;
	
	document.getElementById("divcnt").style.height = content_height+"px";
	if(noteScroll != null)
	{
		noteScroll.refresh();	
	}
}
$(document).ready(function () {
	//parent.setOnLoadContentPaneHeight();
	parent.setNotesFrameContentHeight();
});
function closeNotesContent()
{
	window.parent.closeNotesContent();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<style>
  .ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
  .white
  {
    
  }
.dvViewNotes
{
    height:44px;
    /*width : 100%;*/
 
    background :  -webkit-gradient(linear, left top, left bottom, from( #48cbcb ), to( #27707e )); /* Saf4+, Chrome */
    background : -webkit-linear-gradient( #48cbcb , #27707e ); /* Chrome 10+, Saf5.1+ */
    background :   -moz-linear-gradient( #48cbcb , #27707e ); /* FF3.6 */
    /*border : 1px solid #48d1d8;*/
     /*border : 1px solid #48d1d8; */ 
  
}
.viewNotesHeader {
	position:relative;
	height:8vhpx;

}
</style>
</head>

<body  style = "background-color : #ffffff">


<!--  <div id="divcnt" class="divAllergyContent divAllergyContentTheme" style="padding: 0px; overflow: hidden" data-role="none">-->
<div id="allergyHeader" class="AllergyHeader" style="padding: 0px"
				data-role="none">
				<table cellpadding="0" cellspacing="0" class="tbAllergyHeader"
					data-role="none">
					<tr class="normalTr">
						<td class="normalTd">
							<div class="viewNotesHeader  RecordAllergyHeaderTheme">
								<div class="RecordAllergyTable">
									<div class="normalRow">
										<div class="AllergyCell" style="width: 99%; text-align: left">
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Notes Content</div>
										</div>
										<div class="AllergyCell" style="width: 1%">
											<div class="RecordAllergyTable">
												<div class="normalRow">
													<div class="AllergyCell"
														style="width: auto; text-align: right">
														<div class="buttonContainer">
															<div class="WidgetButtonTheme" style = "margin-right:10px" onclick="closeNotesContent()">
																<img src="${path}/eIPAD/images/CS_Close16x16.png"/>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
<div id="divcnt" class = "ChartSummaryMainWrapper" style="position:relative;padding: 0px; overflow: hidden;" data-role="none">
	<div class="ChartSummaryMainScroller" style="position:relative;width: 100%; height: auto; overflow: auto" data-role="none">	
		<%=notes_content%>	
	</div>
</div>

  

</body>

</html>

