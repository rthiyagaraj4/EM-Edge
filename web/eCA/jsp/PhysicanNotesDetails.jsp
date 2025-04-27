<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             	100           	 ?					?				?           created
02/04/2014	IN048271	Ramesh G	02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format
24/06/2018	IN065341	Prakash C	25/06/2018		Ramesh G		ML-MMOH-CRF-0115
05/10/2018	IN068396	Raja S		05/10/2018		Ramesh G		Ml-MMOH-CRF-1237
04/01/2019	IN069365	Raja S		04/01/2019		Ramesh G		ML-BRU-SCF-1908
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
14/08/2024	65094			Kishore Kumar	 16/08/2024    Ramesh Goli      ML-MMOH-CRF-2149
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*,eCA.Common.*,java.util.zip.*" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.Notescontent.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
String accession_num=request.getParameter("accession_num");
String sql			="";
Connection con		=null;
ResultSet rs		=null;
PreparedStatement stmt		=null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
//StringBuffer notes_content = new StringBuffer();
String	notes_content		=	"";

java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;
//IN065341 starts
String bean_id = "ca_CentralizedBean" ;
String bean_name = "eCA.CentralizedBean";
CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
bean.setLanguageId(localeName);
bean.clear() ;
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
//IN065341 ends

try
	{
		con					=ConnectionManager.getConnection(request);
		if(clob_data.equals("_CDR")){
			bean.executeCDR(con,patient_id,encounter_id,RepDb,"CA_ENCNTR_NOTE");
		} 
		rs					=null;
		stmt				=null;
		//sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc FROM ca_encntr_note a where  a.accession_num=? ";
		//6484 Start.
		//sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE##REPDB##(a.note_type,?,'1') note_type_desc FROM ca_encntr_note##CLOB## a where  a.accession_num=? ";
		sql="SELECT a.note_content,a.compress_note_content_yn,a.compress_note_content, CA_GET_DESC.CA_NOTE_TYPE##REPDB##(a.note_type,?,'1') note_type_desc FROM ca_encntr_note##CLOB## a where  a.accession_num=? ";
		//6484 End.
		sql=sql.replaceAll("##REPDB##",RepDb);
		sql=sql.replaceAll("##CLOB##",clob_data);
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,accession_num);
		rs=stmt.executeQuery();

		
		if(rs.next())
		{
			//6484 Start.
			if("Y".equals(rs.getString("compress_note_content_yn")==null?"":(String)rs.getString("compress_note_content_yn"))){
				
				java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_note_content");
				if(note_blob!=null && note_blob.length()>0){
					InputStream ins1 = note_blob.getBinaryStream();
					ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
					int i;
					while((i = ins1.read()) != -1) 
						bytearrayoutputstream.write(i);
					
					byte[] compressed	=bytearrayoutputstream.toByteArray();
					if(compressed.length > 0){
						if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
							GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
							BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

							String line;
							while ((line = bufferedReader.readLine()) != null) {
								notes_content += line;
							}
						}					
					}
				}				
			}else{
			//6484 End.
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
					}catch(Exception e){
						//out.println("Exception@2-readCLOB : "+e);//common-icn-0181
					e.printStackTrace();//COMMON-ICN-0181
					}
					if(!notes_content.equals(""))
					{
						notes_content = notes_content.replaceAll("<HTML><BODY><PRE>","<PRE>");				
						notes_content = notes_content.replaceAll("</PRE></BODY></HTML>","</PRE>");			
						notes_content = notes_content.replaceAll("line-height: 100%"," ");			//IN068396
						int nIndex	= notes_content.indexOf("<BODY>");
						int nIndex1 = notes_content.lastIndexOf("</BODY>");

						if(nIndex != -1 && nIndex1 != -1)
							notes_content = notes_content.substring(nIndex+6,nIndex1);
						notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
					}
				}
			} //6484
		}		
		if(rs!=null)			rs.close();
		if(stmt!=null)			stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception"+e.toString());
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}



	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String facilityId = (String)session.getValue("facility_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src='../js/PhysicianNote.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<style>
	ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
</style>
</head>
<body class='CONTENT' >
<!-- onMouseDown="CodeArrest()" onKeyDown="lockKey()" -->
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<form name='result_form' id='result_form'>
<table border="0" width="100%" cellspacing='0' cellpadding='3' id='tb1'>
<tr>
<%notes_content = notes_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML-MMOH-SCF-2966 %>
<td class='white' align='left'><%=notes_content%></td>
</tr>
</table>
</form>
</body>
<!-- Added for ML-MMOH-CRF-2149 start -->
<%-- <script>
 <%
String copyRestrict = bean.getCopyRestrict(facilityId);
if(copyRestrict.equals("Y")){
System.out.println("view clinial notes");
if(copyRestrict.equals("Y") && bean.getRestrictPreviewNotes().equals("PHYSICIAN_NOTES1")){
	System.out.println("view clinial notes 1");
%> 
 if (document.body.addEventListener) {
	document.body.addEventListener('selectstart', function(e) {
        e.preventDefault();
    });
} else if (document.body.attachEvent) { 
	 document.body.attachEvent('onselectstart', function(e) {
        e.returnValue = false;
    });
} 
 <% }}%> 
 
 
 <% 
 String copyRestrictPreview = bean.getCopyRestrictPreview(facilityId);
 if(copyRestrictPreview.equals("Y")){
 System.out.println("preview notes");
 if(copyRestrictPreview.equals("Y") && bean.getRestrictPreviewNotes().equals("CLINICAL_NOTES")){ 
	 System.out.println("preview notes 1");
 %> 
 if (document.body.addEventListener) {
		document.body.addEventListener('selectstart', function(e) {
	        e.preventDefault();
	    });
	} else if (document.body.attachEvent) { 
		 document.body.attachEvent('onselectstart', function(e) {
	        e.returnValue = false;
	    });
	} 
 <%}}%>
</script> --%>
<!-- Added for ML-MMOH-CRF-2149 end -->
<script>
<%
    String copyRestrict = bean.getCopyRestrict(facilityId);
    String copyRestrictPreview = bean.getCopyRestrictPreview(facilityId);
    String restrictPreviewNotes = bean.getRestrictPreviewNotes();
%>

    function preventTextSelection() {
        if (document.body.addEventListener) {
            document.body.addEventListener('selectstart', function(e) {
                e.preventDefault();
            });
        } else if (document.body.attachEvent) {
            document.body.attachEvent('onselectstart', function(e) {
                e.returnValue = false;
            });
        }
    }

    <%
    if ("Y".equals(copyRestrict) && ("PHYSICIAN_NOTES1".equals(restrictPreviewNotes)||"PHYSICIAN_NOTES".equals(restrictPreviewNotes))){
    %>
        preventTextSelection();
    <%
    }
    
    if ("Y".equals(copyRestrictPreview) && "CLINICAL_NOTES".equals(restrictPreviewNotes)) {
    %>
        preventTextSelection();
    <%
    }
    %>
</script>
</html>

