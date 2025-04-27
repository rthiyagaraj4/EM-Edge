<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,java.util.zip.*,java.io.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<title>RecClinicalNotesSearchDetails.jsp</title>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
		/* IN043895 Start.*/
		/*ADDRESS	{ FONT-FAMILY:Verdana;FONT-SIZE:9pt ; FONT-STYLE: NORMAL; COLOR: BLACK; } */
			/* IN049424 Start.*/
				/*ADDRESS	{ 
					FONT-FAMILY: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS" ;
					FONT-SIZE: 10pt ; 
					FONT-STYLE: NORMAL; 
					COLOR: BLACK; 
				}*/
				ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
			/*IN049424 End.*/		
		/* IN043895 End.*/
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='RecClinicalNotesSearchDetailsForm' id='RecClinicalNotesSearchDetailsForm'>

<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	query_notes_detail	=	"";

	String	facility_id			=	"",		accession_num		=	"";
	String	notes_content		=	"";
	String action_date_time		=   "";	
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

	try
	{
		
		facility_id		=	(String)	session.getValue("facility_id");
		accession_num	=	(request.getParameter("accession_num")==null)	? "" : request.getParameter("accession_num");
		action_date_time	=	(request.getParameter("action_date_time")==null)	? "" : request.getParameter("action_date_time");

		con				=	ConnectionManager.getConnection(request);

		query_notes_detail = "select a.pre_amendment_note_content note_content,a.compress_note_content,a.compress_note_content_yn, CA_GET_DESC.CA_NOTE_TYPE(c.NOTE_TYPE,?,'1') note_type_desc from  ca_encntr_note_audit_log a,ca_encntr_note c where  c.accession_num=a.accession_num  and a.accession_num = ? and a.action_date_time = to_date(?,'dd/mm/yyyy hh24:mi:ss')";
		
		pstmt			=	con.prepareStatement(query_notes_detail);

		pstmt.setString(1, locale);
		pstmt.setString(2, accession_num);
		pstmt.setString(3, action_date_time);

		rs				=	pstmt.executeQuery();

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
				if(clob_notes_content!=null)
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
						//out.println("Exception@2-readCLOB : "+e);//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
					}
				}			
			}
		} 
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	 notes_content = notes_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966/
%>

<%

if(!notes_content.equals(""))
{
%>
	<table class='grid' width='100%'>
	<tr>
	<td class='BODYCOLORFILLED'><%=notes_content%></td>
	</tr>
	</table>
<%
}
%>

</form>
</body>
</html>

