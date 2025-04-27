<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?					?				?           created
29/06/2012	IN030468		Dinesh T			?				?			BRUHIMS CRF.
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
02/04/2014	IN048271		Ramesh G		02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
16/03/2015  IN054024		Ramesh G										There is an issue for 1 patient where the Report Header Contents as well as the Note Header 
																			Contents do not display on preview print as well as in the Print out.
22/08/2018	IN066793		Sharanraj		22/08/2018		Ramesh G		ARYU-SCF-0064																			
05/10/2018	IN068396		Raja S			05/10/2018		Ramesh G		ML-MMOH-CRF-1237
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
29/08/2023  48833           Srinivasa N T        21/08/2023      SRINIVASA N T 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.zip.*,java.io.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!-- IN066793 -->

<% 
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String note_status		=	(request.getParameter("note_status")==null)	? "" : request.getParameter("note_status");
	/*IN066793 starts*/
	boolean sitespecific=false;
	Connection	 conn=null;
	try
	{
		 conn	= ConnectionManager.getConnection(request);
		sitespecific = CommonBean.isSiteSpecific(conn, "CA","BURMESE_LANGUAGE_FONT");
	}
	catch(Exception e)
	{
		out.println("Exception@111 - in getting header_appl_yn : "+e);
		
	}
	finally
	{
		if(conn!=null)	ConnectionManager.returnConnection(conn,request);
	}
	/*IN066793 ends*/
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<title>RecClinicalNotesSearchDetails</title>
	<!-- IN066793 starts -->
	<%
	if(sitespecific)
	{	
	%>
	<style>
				ADDRESS	{ FONT-FAMILY: Segoe UI ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
		PRE
		{
			font-size:10pt;			
			font-family: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";
			//BACKGROUND-COLOR: #E2E3F0;
			BACKGROUND-COLOR: #FFFFFF;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;			
		}	
		/* IN054024 End. */
	</style>
	<%
	}
	else
	{	
	%>
		<style>
		/* IN043895 Start.  */
		/*ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 9pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }*/
			/*IN049424 Start.*/
				/*ADDRESS	{ 
					FONT-FAMILY: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS" ;
					FONT-SIZE: 10pt ; 
					FONT-STYLE: NORMAL; 
					COLOR: BLACK; 
				}*/
				ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
			/*IN049424 End.*/		
		/* IN054024 Start. */
		PRE
		{
			font-size:10pt;			
			font-family: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";
			//BACKGROUND-COLOR: #E2E3F0;
			BACKGROUND-COLOR: #FFFFFF;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;			
		}	
		/* IN054024 End. */
	</style>
	<%
	}
	%>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='RecClinicalNotesSearchDetailsForm' id='RecClinicalNotesSearchDetailsForm'>
<div id="note_content">
<table class='grid' width='100%' align='center'>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection			con			=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs					=	null;

	String	query_notes_detail	=	"";
	String	facility_id					=	"";
	String	accession_num			=	"";
	String	notes_content			=	"";

	//oracle.sql.CLOB			clob_notes_content	= null;
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

	try	
	{
		

		facility_id		=	(request.getParameter("facility_id")==null)		? "" : request.getParameter("facility_id");

		accession_num	=	(request.getParameter("accession_num")==null)	? "" : request.getParameter("accession_num");

		con				=	ConnectionManager.getConnection(request);
		//6484 Start.
		//query_notes_detail = "select a.note_content, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc from ca_encntr_note a where a.accession_num = ?";//IN030468
		query_notes_detail = "select a.note_content,a.compress_note_content,a.compress_note_content_yn, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc from ca_encntr_note a where a.accession_num = ?";		
		//6484 End.
		pstmt			=	con.prepareStatement(query_notes_detail);

		pstmt.setString(1, locale);
		pstmt.setString(2, accession_num);//IN030468

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
						//out.println("Exception@2-readCLOB : "+e);//common-icn-0181
					e.printStackTrace();//COMMON-ICN-0181
					}				
				}
							
			}
			//6484 Start.
			if(!"".equals(notes_content)){
				notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
				notes_content=notes_content.replaceAll("line-height: 100%"," ");//IN068396
				notes_content=notes_content.replaceAll("line-height: 120%"," ");//IN068396
				notes_content = notes_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
			}
			%>
				 <tr>
					<td class='gridData'> <%=notes_content%></td>
				</tr>
			<%	
			//6484 end.
		} // end of if(rs.next())
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%> 
	 </table>
	 </div>
	</form>
</body>
</html>

