<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*, eCA.ChartRecording.*,javax.rmi.*,webbeans.eCommon.MessageManager,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
 String notesHeading = "";
 if(request.getParameter("notesHeading") != null)
 {
	 notesHeading = request.getParameter("notesHeading");
 }
String strHeight = "341px";
if(request.getParameter("height") != null)
{
	strHeight = request.getParameter("height");
}
request.setCharacterEncoding("UTF-8");
String display= "display:none";
String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String accession_num = "";
String operationMode = "";
String hdgCode = "";
String subHdgCode = "";
if(request.getParameter("accessnum") != null)
{
	accession_num=request.getParameter("accessnum");
}
if(request.getParameter("secCode") != null)
{
	hdgCode = request.getParameter("secCode");
}
if(request.getParameter("secChildCode") != null)
{
	subHdgCode = request.getParameter("secChildCode");
}
	

String	notes_content		=	"";

java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;






//sqlStr.append("SELECT B.TERM_SET_DESC AS ProblemSet,A.TERM_CODE as DiagProb,A.TERM_CODE_SHORT_DESC as Description FROM PR_DIAGNOSIS A JOIN MR_TERM_SET B ON A.TERM_SET_ID = B.TERM_SET_ID WHERE A.PATIENT_ID = 'MC00000149'");

sqlStr.append("select notes_section_content from ca_encntr_note_section where sec_hdg_code = '" +hdgCode +"' and subsec_hdg_code = '" + subHdgCode+ "' and accession_num = '" +accession_num + "'");

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
	clob_notes_content	=	(java.sql.Clob) rs.getObject("notes_section_content");

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
	operationMode = "UpdateRecord";
	display= "display:block";
}
else
{
	operationMode = "Record";
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
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


  
<link rel="stylesheet" href="../css/iPadCreateNotes.css" />

<script>
function Loading()
{
	//window.parent.hideLoading();
	var scrollheight = document.getElementById("txtnotes").scrollHeight;
	var orgHeight = $("#txtnotes").height();
	var modHeight = scrollheight + orgHeight + "px";
	//alert(orgHeight);
	//alert(modHeight);
	//alert(document.getElementById("txtnotes").scrollHeight );
	//alert($("#txtnotes").height() );
	
	  $("#txtnotes").css('height', scrollheight);
	  
	  document.getElementById("dv").contentEditable='true';
	 // alert(document.getElementById("dv").textContent);
	 // document.getElementById("txtnotes").value = document.getElementById("dv").textContent;
} 
function changeOrientation(orient,height)
{
		//alert(height);
	if(orient == "landscape")
	   {
	     document.getElementById("dvmain").style.height = "auto";
	     document.getElementById("txtnotes").style.height = height;
	    // $("#txtnotes").css('min-height', height);
	   }
     else
	   {
	   document.getElementById("dvmain").style.height = "auto";
	   document.getElementById("txtnotes").style.height = height;
	 //  $("#txtnotes").css('min-height', height);
	   }
 
}
function showText()
{
	 //alert(document.getElementById("dv").innerHTML);
}
function getNotescontent()
{
	var notesContent =  document.getElementById("txtnotes").value;
	var dvNotescontent = document.getElementById("dv").innerHTML;
	//var accessnum = document.getElementById("accession_num").value;
	var operationMode = document.getElementById("operation_mode").value;
	/*
	if(accessnum != null && accessnum != "")
	{
		 operationMode = "UpdateRecord";	
	}
	else
	{
		 operationMode = "Record";	
	}
	*/
	//alert(dvNotescontent);
	//alert(notesContent);
	//alert("notescontent");
	window.parent.setNotesContent(notesContent,dvNotescontent, operationMode);
}
</script>
<style>
  .ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
  .white
  {
    
  }
  ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}
</style>
</head>

<body onload = "Loading()" >
<section data-role = "page" style = "padding:0px;">
 <form>
 <div data-role = "none"  id = 'dvmain'  style="padding:0px;height:auto;background-color:#ffffff" >
   
  <div data-role = "none" class = "dvViewNotes">
     <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
       <tr style="width:100%;height:100%">
         <td style = "width : 80%" align = "left" valign = "center">
            <span class = "spanCreateNotesView"><%=notesHeading %></span>
            
         </td> 
         <td style="width:20%">
         &nbsp;
         </td>
       </tr>
     </table>
   </div> 
  
	  <div id = "dv" style="<%=display %>;height:auto">
      <%=notes_content%>
	  </div>
	  <div style="height:auto;overflow:auto">
		  <textarea  class = "txtNotes" data-role = "none" id = "txtnotes" style="height:<%=strHeight%>;display:block" onclick = "showText()" >
	          
	
	      </textarea>
      </div>
  
  

</div>
<input type = "hidden" name = "accession_num" id = "accession_num" value = "<%=accession_num%>" />
<input type = "hidden" name = "operation_mode" id = "operation_mode" value = "<%=operationMode%>"/>
</form> 
</section>  
</body>

</html>

