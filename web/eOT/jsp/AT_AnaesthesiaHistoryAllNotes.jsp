<!DOCTYPE html>
<html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Clob,java.io.BufferedReader" %>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,java.util.zip.*,java.io.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- JSP Page specific attributes end --%>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eOT/js/AT_AnaesthesiaHistory.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

</head>
<% 
	String doc_linked = "";
	String note_type = "";
	String accession_num = "";
	String img = "";
	String facility_id = request.getParameter("facility_id");
	String anaesthesia_srl_no = request.getParameter("anaesthesia_srl_no");
	String tab_id = request.getParameter("tab_id");
	String contr_mod_accession_num = facility_id+anaesthesia_srl_no+tab_id;
			
	//String Sql="SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? and Event_Status <> '9'"; //added by Sanjay for Surgeon Notes against IN34391
	//String Sql="SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ?  order by ADDED_DATE desc";//Against 45394
	String Sql="SELECT NOTE_CONTENT,compress_note_content_yn, compress_note_content,nvl2(EXT_IMAGE_APPL_ID,'Y','N') doc_linked,note_type,accession_num FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? and Event_Status <> '9'";	//Modified Against ML-MMOH-CRF-1977.1
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String notes_content="";
	int index =0;
	Clob clob_notes_content = null;
	String compressResultYN = "N";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(Sql);
		pstmt.setString(1,contr_mod_accession_num);
		rst=pstmt.executeQuery();
		if( rst.next() ){
			++index;
			clob_notes_content	= rst.getClob(1);
			doc_linked	=	rst.getString("doc_linked")==null?"N":rst.getString("doc_linked");
			note_type = rst.getString("note_type")==null?"":rst.getString("note_type");
			accession_num = rst.getString("accession_num")==null?"":rst.getString("accession_num");
			compressResultYN = rst.getString("compress_note_content_yn")==null?"N":(String)rst.getString("compress_note_content_yn");
			if(compressResultYN.equals("N"))
			{
			if(clob_notes_content!=null){
				notes_content = clob_notes_content.getSubString(1,(int) clob_notes_content.length());
				out.println(notes_content);
				//ML-MMOH-CRF-1977.1 Starts
			if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
			else
				img = "&nbsp;";
			out.println(img);
			//ML-MMOH-CRF-1977.1 Ends
			}
			}
			else	//MO-CRF-20147.13 Starts
			{
				java.sql.Blob note_blob =  (java.sql.Blob)rst.getBlob("compress_note_content");
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
				//content.append(notes_content);
				out.println(notes_content.toString());
			//ML-MMOH-CRF-1977.1 Starts
			if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
			else
				img = "&nbsp;";
			out.println(img);
			//ML-MMOH-CRF-1977.1 Ends
			}

		}
		if(index==0) out.println("<script>callNoNotes('"+tab_id+"')</script>");
			
	}catch(Exception e){
		 //e.printStackTrace();
		 System.err.println("Err AT_AnaesthesiaHistoryAllNotes.jsp :"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

	%> 


