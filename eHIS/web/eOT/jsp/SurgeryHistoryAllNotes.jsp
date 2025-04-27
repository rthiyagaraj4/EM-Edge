<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Clob,java.io.BufferedReader" %>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,java.util.zip.*,java.io.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eOT/js/SurgeryHistory.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
 -->
<% 
	String doc_linked = "";
	String note_type = "";
	String accession_num = "";
	String img = "";
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String speciality_code = CommonBean.checkForNull(request.getParameter("speciality_code"));
	String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
	locn_type=locn_type.equals("")?"99":locn_type;
	String contr_mod_accession_num = facility_id+oper_num+speciality_code+locn_type;
	String tab_id = CommonBean.checkForNull(request.getParameter("tab_id"));
	//String Sql="SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ?";
	//String Sql="SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? and Event_Status <> '9'";//added by Sanjay for Surgeon Notes against IN34391
	String Sql="SELECT NOTE_CONTENT,compress_note_content_yn, compress_note_content,nvl2(EXT_IMAGE_APPL_ID,'Y','N') doc_linked,note_type,accession_num FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? and Event_Status <> '9'";	//Modified Against ML-MMOH-CRF-1977.1
	//String Sql="SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? order by ADDED_DATE desc";//Against 45394
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	StringBuffer content  = new StringBuffer();
	BufferedReader bf_content_reader = null;
	//CLOB clob=null;
	String notes_content="";
	Clob clob_notes_content = null;
	String sql_doctor_notes="SELECT DOCTOR_NOTES FROM OT_DR_NOTES WHERE OPERATING_FACILITY_ID=?  AND  OPER_NUM = ?";
	String surgeon_notes = "";
	int index=0;
	String compressResultYN = "N";	//MO-CRF-20147.13 
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(Sql);
		pstmt.setString(1,contr_mod_accession_num);
		rst=pstmt.executeQuery();
		while( rst.next() ){
			++index;
			//oracle.sql.CLOB clob = (oracle.sql.CLOB) rst.getObject(1);
			clob_notes_content	= rst.getClob("note_content");
			doc_linked	=	rst.getString("doc_linked")==null?"N":rst.getString("doc_linked");
			note_type = rst.getString("note_type")==null?"":rst.getString("note_type");
			accession_num = rst.getString("accession_num")==null?"":rst.getString("accession_num");
			compressResultYN = rst.getString("compress_note_content_yn")==null?"N":(String)rst.getString("compress_note_content_yn");	//MO-CRF-20147.13 
			if(compressResultYN.equals("N"))
			{
			if(clob_notes_content!=null){
				//content_reader	= clob_notes_content.getCharacterStream();
				bf_content_reader = new java.io.BufferedReader(clob_notes_content.getCharacterStream());
				char[] arr_notes_content = new char[(int)clob_notes_content.length()];
				bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
				notes_content = new String(arr_notes_content);
				content.append(notes_content);
				bf_content_reader.close();
				out.println(content.toString());
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
				content.append(notes_content);
				out.println(content.toString());
				//ML-MMOH-CRF-1977.1 Starts
			if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
			else
				img = "&nbsp;";
			out.println(img);
			//ML-MMOH-CRF-1977.1 Ends
			}
			//MO-CRF-20147.13 Ends
			
		}
      
		if("surg_notes".equals(tab_id)){
			if(index==0){
				pstmt = con.prepareStatement(sql_doctor_notes);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,oper_num);
				rst=pstmt.executeQuery();
				while(rst.next()){
					++index;
					clob_notes_content = rst.getClob("DOCTOR_NOTES");
					if(clob_notes_content!=null)
					surgeon_notes = clob_notes_content.getSubString(1,(int)clob_notes_content.length());
					out.println(surgeon_notes);
				}
				rst.close();
				pstmt.close();
			}
		}
		if(index==0) out.println("<script>callNoNotes('"+tab_id+"')</script>");
			//out.println(contr_mod_accession_num);
	}catch(Exception e){
		 e.printStackTrace();
		 System.err.println("Err SurgeryHistoryAllNotes.jsp :"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(bf_content_reader!=null) bf_content_reader.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
			content.setLength(0);
		}catch(Exception e){}
	}

	%> 

<input type='hidden' name='locale' id='locale' value="<%=locale%>">

