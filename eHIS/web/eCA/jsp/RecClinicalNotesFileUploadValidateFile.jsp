<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.io.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<script language='javascript' src='../js/NoteImageList.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	File filecreate;
	boolean record_status = false;
	ArrayList doc_arr = null;
	String note_linked_file_limit_unit = "";
	String docType = "";
	String file_name = "";

	int note_linked_file_limit = 0;
	double paramsize = 0;
	long docSize = 0;

	String file_upload = request.getParameter("file_upload")==null?"":request.getParameter("file_upload");
	String remote_host = request.getRemoteHost();

	docType = "application/pdf";

	try
	{
			con = ConnectionManager.getConnection();
		try
		{
			file_name = buildFileName(remote_host,file_upload);
			filecreate = new File(file_name);
			docSize = filecreate.length();

			doc_arr = new ArrayList();
			String qry_doc_type = "select distinct OBJ_TYPE from ca_appl_linked_obj_type where APPLICABLE_YN = 'Y'";
			pstmt = con.prepareStatement(qry_doc_type);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				doc_arr.add(rs.getString("OBJ_TYPE"));
			}
			
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();

			for(int i =0; i<doc_arr.size(); i++)
			{
					if(docType.equals(doc_arr.get(i)))
					{
						record_status = true;
						break;
					}
					else
					{
						record_status = false;
					}

			}

			if(record_status)
			{
				String docsize_note_param = "select NOTE_LINKED_FILE_LIMIT , NOTE_LINKED_FILE_LIMIT_UNIT from CA_NOTE_PARAM";
				pstmt = con.prepareStatement(docsize_note_param);
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					note_linked_file_limit = rs.getInt("note_linked_file_limit");
					note_linked_file_limit_unit = rs.getString("note_linked_file_limit_unit");
				}

				if(rs!=null)
						rs.close();
				if(pstmt!=null)
						pstmt.close();

				if(note_linked_file_limit_unit.equalsIgnoreCase("K") || note_linked_file_limit_unit.equalsIgnoreCase("KB"))
				{
						paramsize = note_linked_file_limit * 1024;
				}
				if(note_linked_file_limit_unit.equalsIgnoreCase("M") || note_linked_file_limit_unit.equalsIgnoreCase("MB"))
				{
						paramsize = note_linked_file_limit *1024 *1000;
				}
				if(note_linked_file_limit_unit.equalsIgnoreCase("G") || note_linked_file_limit_unit.equalsIgnoreCase("GB"))
				{
						paramsize = note_linked_file_limit *1024 *1000 * 1000;
				}

				if(docSize > paramsize || docSize > ((1024 *1000 * 1000) * 2)) 
				{
					out.println("<script>alert(getMessage('FILE_SIZE_NOT_SUPPORTED','CA'))</script>");
					out.println("top.messageframe.document.location.href='../../eCA/jsp/CAError.jsp'");
				}
				else
				{
					out.println("<script>");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.target = top.messageframe.name;");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = 'Record'");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesSectionsFileUploadServlet'");
					out.println("top.RecClinicalNotesFileUploadToolbarFrame.document.getElementById('noterecord_sec').disabled = true");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit()");
					out.println("</script>");
				}
			}
			else
			{
				out.println("<script>alert(getMessage('FILE_NOT_SUPPORTED','CA'))</script>");
				out.println("top.messageframe.document.location.href='../../eCA/jsp/CAError.jsp'");
			}
		}
		catch(Exception e)
		{
			//out.println("Exception @ RecClinicalNotesFileUploadValidateFile "+e.toString());//common-icn-0181
		        e.printStackTrace();//COMMON-ICN-0181
		}
				
%>			
</html>
<%
	}
	catch(Exception e)
	{
		//out.println("Exception @ RecClinicalNotesFileUploadValidateFile.jsp "+e.toString());
		e.printStackTrace();//COMMON-ICN-0181
		//out.println("Exception @ RecClinicalNotesFileUploadValidateFile.jsp "+e.toString());//common-icn-0181
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
<%!
	private String buildFileName(String remoteHost , String imageUrl)
	{

		int i=0;
		String result = "";
		imageUrl = imageUrl.replaceAll(":","$");
		imageUrl = imageUrl.replaceAll("\\","%");
		String search = "%";
		String sub = "\\";
		
		do { 
			// replace all matching substrings (\\)
				i = imageUrl.indexOf(search);
				if(i != -1) 
				{
					result = imageUrl.substring(0, i);
					result = result + sub;
					result = result + imageUrl.substring(i + search.length());
					imageUrl = result;
				}
		} while(i != -1);	
	
		String filePath = "\\\\"+remoteHost+"\\"+imageUrl;
		return filePath;
	}	
	
%>



