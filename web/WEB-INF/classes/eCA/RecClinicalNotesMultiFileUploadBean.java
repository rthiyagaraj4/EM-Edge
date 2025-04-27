/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name			Rev.Date   		Rev.By 			Description
--------------------------------------------------------------------------------------------------------------------------------
	?			100				?				?				?				?
19/05/2020		IN070345		Ramesh Goli		19/05/2020		Ramesh G		MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;	//IN070345
import java.io.FileInputStream; //IN070345
import java.io.FileOutputStream; //IN070345
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;  //IN070345
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.apache.tomcat.util.http.fileupload.FileItem;

import org.apache.commons.fileupload.FileItem;

import webbeans.eCommon.*;

/**
 * @author KishoreKumarN
 *
 */
public class RecClinicalNotesMultiFileUploadBean implements java.io.Serializable
{
	private double allowedFileSize;
	private long maxFilesAllowed;
	private String accessionNum = "";
	private String fileReffNo = "";
	private String noteType ="";
	private String fileUnit = "";
	private int docCount = 1;
	private int docMaxDBCount = 0;
	private int DBDocCount = 0;
	private double size;
	private Map<String, NoteDoc> noteDocMap;
	private List<String> docNameList;
	//IN070345 Start.
	private String sharedPath="";;
	InputStream inStream = null;
	OutputStream outStream = null;
	public void setSharedPath(String facility_id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
		this.sharedPath ="";
		String sharedFolderPath="";
		String sharedFolder="";
		con = ConnectionManager.getConnection();
		try {
			pst = con.prepareStatement("SELECT A.DOC_STORED_TYPE,A.DOC_STORED_PATH,B.DOC_FOLDER_NAME FROM CA_FUNCITON_DOC_CONFIG_DTL A, CA_FUNCTION_DOC_DTL B  WHERE A.DOC_SUB_FUNCTION_ID = B.DOC_SUB_FUNCTION_ID AND A.DOC_STORED_TYPE='F' AND A.DOC_SUB_FUNCTION_ID='CLINICAL_NOTES_UPLOADED_DOC' AND A.FACILITY_ID=?");
			pst.setString(1,facility_id);
			rs = pst.executeQuery();
			if (rs!=null && rs.next()) {
				sharedFolderPath = rs.getString("DOC_STORED_PATH")==null?"":(String)rs.getString("DOC_STORED_PATH");
				sharedFolder= rs.getString("DOC_FOLDER_NAME")==null?"":(String)rs.getString("DOC_FOLDER_NAME");
				if(!"".equals(sharedFolderPath) && !"".equals(sharedFolder))
					sharedPath =sharedFolderPath+"/"+sharedFolder;
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					ConnectionManager.returnConnection(con);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public String getSharedPath() {
		return sharedPath;
	}
	//IN070345 End.
	public RecClinicalNotesMultiFileUploadBean()
	{
		noteDocMap = new  HashMap<String, NoteDoc>();
		docNameList = new ArrayList<String>();
		getMaxFileSize();
	}

	private void getMaxFileSize()
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try
		{
			con = ConnectionManager.getConnection();
			String sqlQry = "SELECT NOTE_LINKED_FILE_LIMIT,MAX_NO_IMG_ALLOWED,NOTE_LINKED_FILE_LIMIT_UNIT FROM CA_NOTE_PARAM WHERE MODULE_ID = 'CA'";
			pst = con.prepareStatement(sqlQry);
			rs = pst.executeQuery();

			while(rs.next())
			{
				setAllowedFileSize(rs.getLong("NOTE_LINKED_FILE_LIMIT")==0?0:rs.getLong("NOTE_LINKED_FILE_LIMIT"));
				setMaxFilesAllowed(rs.getLong("MAX_NO_IMG_ALLOWED")==0?1:rs.getLong("MAX_NO_IMG_ALLOWED"));
				setFileUnit(rs.getString("NOTE_LINKED_FILE_LIMIT_UNIT")==null?"K":rs.getString("NOTE_LINKED_FILE_LIMIT_UNIT"));
			}
			if(rs!=null)
				rs.close();
			if(pst!=null)
				pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public void checkAndLoadBean(String accessionNum, String noteType)
	{
		if(!accessionNum.equals(getAccessionNum()))
		{
			clear();
			setAccessionNum(accessionNum);
			setNoteType(noteType);
			load();
		}
	}

	private int getMaxFileSeqNo(Connection con) throws Exception
	{
		String sqlQry = "SELECT MAX(FILE_SEQ_NO) FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		pst = con.prepareStatement(sqlQry);
		pst.setString(1, getAccessionNum());
		rs = pst.executeQuery();
		if(rs.next())
		{
			return rs.getInt(1);
		}
		if (rs != null)
		{
			rs.close();
		}
		if (pst != null)
		{
			pst.close();
		}
		return  -1;
	}

	private void load()
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try
		{
			//IN070345 Start.
			//String sqlQry = "SELECT OBJTYPE, HIST_DATA, FILE_NAME, FILE_SEQ_NO,EVENT_TITLE FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? ORDER BY FILE_SEQ_NO";
			String sqlQry = "SELECT OBJTYPE, HIST_DATA, FILE_NAME, FILE_SEQ_NO, EVENT_TITLE, SHARED_FILE_PATH, SHARED_FILE_NAME FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? ORDER BY FILE_SEQ_NO";
			//IN070345 End.
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, getAccessionNum());
			pst.setString(2, getNoteType());
			rs = pst.executeQuery();
			NoteDoc noteDoc = null;
			int docCnt = 1;
			while(rs.next())
			{
				noteDoc = new NoteDoc();
				String fileName = rs.getString("FILE_NAME")== null?"temp_"+docCnt:rs.getString("FILE_NAME");
				noteDoc.setDocName(fileName);
				//IN070345 Start.
				String sharedFilePath = rs.getString("SHARED_FILE_PATH")== null?"":(String)rs.getString("SHARED_FILE_PATH");
				String sharedFileName = rs.getString("SHARED_FILE_NAME")== null?"":(String)rs.getString("SHARED_FILE_NAME");
				noteDoc.setDocSharedFilePath(sharedFilePath);
				noteDoc.setDocSharedFileName(sharedFileName);
				if(!"".equals(sharedFilePath) && !"".equals(sharedFileName)){		
					File file =new File(sharedFilePath+"/"+sharedFileName);
					if(file.exists()){
						noteDoc.setDocSize(file.length());
					}
					noteDoc.setLoadFromFileServer(true);
				}else{			
				// IN070345 End.
					noteDoc.setDocSize(((java.sql.Blob)rs.getBlob("HIST_DATA")).length());
					noteDoc.setLoadFromFileServer(false);
				} //IN070345
				noteDoc.setLoadFromDB(true);
				noteDoc.setDocSeqNo(rs.getInt("FILE_SEQ_NO"));
				noteDoc.setDocType(rs.getString("OBJTYPE"));
				noteDoc.setDocRemarks(rs.getString("EVENT_TITLE")==null?"":rs.getString("EVENT_TITLE"));
				//noteDoc.setDocStream(((java.sql.Blob)rs.getBlob("HIST_DATA")).getBinaryStream());
				setNoteDoc(fileName, noteDoc);
				setDocNameList(fileName);
				setSize(((java.sql.Blob)rs.getBlob("HIST_DATA")).length());
				setDocCount(getDocCount()+1);
				docCnt++;
			}

			setDocMaxDBCount(getMaxFileSeqNo(con)+1);

			if(rs != null)
			{
				rs.close();
			}

			if(pst != null)
			{
				pst.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public void clear()
	{
		removeTempDocs();
		this.accessionNum = "";
		this.fileReffNo = "";
		this.noteType ="";
		this.fileUnit = "";
		this.allowedFileSize = 0;
		this.maxFilesAllowed = 0;
		this.DBDocCount = 0;
		this.size = 0.0;
		this.docCount = 1;
		this.docMaxDBCount = 0;
		noteDocMap.clear();
		docNameList.clear();
		getMaxFileSize();
	}

	private void removeTempDocs()
	{
		Connection con = null;
		PreparedStatement pst = null;
		String sqlQry = "";
		try
		{
			con = ConnectionManager.getConnection();
			sqlQry = "DELETE FROM CA_MULTI_FILE_UPLOAD_TEMP WHERE FILE_REF_NO = ?";

			pst = con.prepareStatement(sqlQry);
			pst.setString(1, getFileReffNo());
			int res = pst.executeUpdate();
			if (res > 0)
			{
				con.commit();
			}
			if(pst != null)
			{
				pst.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		finally
		{
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	private void setDocNameList(String docName)
	{
		if(docName != null && !docName.equals(""))
		{
			docNameList.add(docName);
		}
	}

	public List<String>  getDocNameList()
	{
		return docNameList;
	}

	private double convertSize(long fileSize)
	{
		double cSize = fileSize;
		if(getFileUnit().equals("M"))
		{
			cSize = (cSize/1024)/1024;
		}
		else if(getFileUnit().equals("K"))
		{
			cSize = cSize/1024;
		}

		return cSize;
	}

	public String setFileList(String fileRemarks, String fileName, FileItem file)
	{
		String msg = "UNKNOWN";

		if(file != null && checkFileLimt() && !isDuplicateFile(fileName) && !isNoteDocSigned())
		{

			try
			{

				double currentFileSize = convertSize(file.getSize()) + getSize();

				if(currentFileSize  <= getAllowedFileSize())
				{


					setDocMaxDBCount(getDocMaxDBCount()+1);

					NoteDoc noteDoc = new NoteDoc();
					noteDoc.setDocFileItem(file);
					noteDoc.setDocName(fileName);
					noteDoc.setLoadFromDB(false);
					noteDoc.setDocSeqNo(getDocMaxDBCount());
					noteDoc.setDocSize(file.getSize());
					noteDoc.setDocType(file.getContentType());
					noteDoc.setDocRemarks(fileRemarks==null?"":fileRemarks);
					setNoteDoc(fileName, noteDoc);
					setSize(file.getSize());
					setDocNameList(fileName);
					saveDocToDB(file.getInputStream(), fileName, file.getSize());
					setDocCount(getDocCount()+1);
					msg = "SUCESS";
				}
				else
				{
					return "FILESIZEEXCEED";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			if(!isFileLimitExceed())
			{
				return "FILELIMITEXCEED";
			}

			if(!isFileSizeExceed())
			{

			}

			if (isDuplicateFile(fileName))
			{
				return "DUPLICATEFILE";
			}

			if (isNoteDocSigned())
			{
				return "NOTEALREADYSIGNED";
			}
		}
		return msg;
	}

	private void saveDocToDB(InputStream docIns, String fileName, long size)
	{
		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			String insQry = "insert into CA_MULTI_FILE_UPLOAD_TEMP (FILE_REF_NO, FILE_SEQ_NO, " +
					" FILE_NAME, FILE_CONTENT) values(?,?,?,?)";
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(insQry);
			pst.setString(1, getFileReffNo());
			pst.setInt(2, getDocMaxDBCount());
			pst.setString(3, fileName);
			pst.setBinaryStream(4, docIns, (int)size);
			pst.executeUpdate();
			con.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pst!=null)
					pst.close();
				if(con != null)
				{
					con.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	}

	//IN070345 Start.
	//public boolean insertDocToDB(Connection con, String accNum, String noteDocType)
	public HashMap<String,String> insertDocToDB(Connection con, String accNum, String noteDocType, String locale)
	//IN070345 End.
	{
		PreparedStatement pst = null;
		boolean isCommit = true;
		HashMap<String,String> resultDetails = new HashMap<String,String>(); //IN070345
		resultDetails.put("ERROR", "N");  //IN070345
		resultDetails.put("ERROR_MSG", "");  //IN070345
		try
		{
			//IN070345 Start.
			//String insQry = "insert into CR_ENCOUNTER_DETAIL_OBJ ( HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA,OBJTYPE,  FILE_SEQ_NO,FILE_NAME ) values ('CLNT','CA' ,?,?,?,empty_blob(),?,?,?)";
			String insQry = "insert into CR_ENCOUNTER_DETAIL_OBJ ( HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA,OBJTYPE,  FILE_SEQ_NO,FILE_NAME, SHARED_FILE_NAME, SHARED_FILE_PATH ) values ('CLNT','CA' ,?,?,?,empty_blob(),?,?,?,?,?)";
			//IN070345 End.
			pst = con.prepareStatement(insQry);
			for(String fileName : getDocNameList())
			{
				Map<String, NoteDoc> noteMap = getFileSet();
				NoteDoc docFile = noteMap.get(fileName);
				if(!docFile.isLoadFromDB())
				{
					//IN070345 Start.
					String sharedFileName = "";
					if(!"".equals(sharedPath))
					sharedFileName ="CLNT_CA"+accNum+docFile.getDocSeqNo()+noteDocType+"."+getFileExtension(fileName);
					/*File name logic HIST_REC_TYPE+CONTR_SYS_ID+ACCESSION_NUM+FILE_SEQ_NO+CONTR_SYS_EVENT_CODE*/
					//IN070345 Start.
					pst.setString(1, accNum);
					pst.setString(2, noteDocType);
					pst.setString(3, docFile.getDocRemarks());

					//pst.setBinaryStream(4, loadDocFromDB(con, docFile), (int)docFile.getDocSize());
					pst.setString(4, docFile.getDocType());
					pst.setInt(5, docFile.getDocSeqNo());
					pst.setString(6, fileName);
					pst.setString(7, sharedFileName);  //IN070345
					pst.setString(8, sharedPath);   //IN070345
					pst.executeUpdate();
					if("".equals(sharedPath)){  //IN070345
						updateDoc(con, accNum, noteDocType, docFile);						
					}else{  //IN070345
						resultDetails= saveDocInSharedPath(con, sharedPath, sharedFileName, docFile, locale);  //IN070345						
					} //IN070345
				}

			}
			if(pst!=null)
				pst.close();
		}
		catch (Exception e)
		{
			isCommit = false;
			resultDetails.put("ERROR", "Y"); //IN070345
			resultDetails.put("ERROR_MSG", ""); //IN070345
			e.printStackTrace();
		}
		//IN070345
		//return isCommit;
		return resultDetails;
		//IN070345
	}
	
	private void updateDoc(Connection con, String accNum, String noteDocType, NoteDoc docFile) throws Exception
	{
			PreparedStatement pst = null;
			OutputStream outStream = null;
			ResultSet rs = null;
			try{
			String update_enctr_dtl_obj = "select HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? and FILE_SEQ_NO = ? for update";

			pst = con.prepareStatement(update_enctr_dtl_obj);
			pst.setString(1, "CLNT");
			pst.setString(2, "CA");
			pst.setString(3, accNum);
			pst.setString(4, noteDocType);
			pst.setInt(5, docFile.getDocSeqNo());
			rs = pst.executeQuery();

			while(rs.next())
			{
				//outStream = ((oracle.sql.BLOB)rs.getBlob(1)).getBinaryOutputStream();
				java.sql.Blob outStreamObj = (java.sql.Blob)rs.getBlob(1);
				outStream = outStreamObj.setBinaryStream(0);				
				InputStream docIns = loadDocFromDB(con, docFile);
				byte[] bytez = new byte[(int)docFile.getDocSize()]; // 4K buffer buf, 0, buf.length
				int index = docIns.read(bytez, 0, (int)docFile.getDocSize());

				while(index != -1)
				{
					outStream.write(bytez , 0, index);
					index = docIns.read (bytez, 0, (int)docFile.getDocSize());
				}
				outStream.close();
			}

			if(rs!=null)
				rs.close();
			if(pst!=null)
				pst.close();
			}catch(Exception e){				
				e.printStackTrace();
			}
	}
	//IN070345 Start.
	private HashMap<String,String> saveDocInSharedPath(Connection con, String sharedPath, String fileName, NoteDoc docFile, String locale) throws Exception
	{
		File sharedFolder = new File(sharedPath);
		MessageManager		msgmngr = new MessageManager();
		boolean dirFlag = false;
		HashMap<String,String> resultDetails = new HashMap<String,String>();
		resultDetails.put("ERROR", "N");
		resultDetails.put("ERROR_MSG", "");
		java.util.Hashtable		 message	= msgmngr.getMessage(locale, "SHARED_PATH_INCORRECT", "CA");
		try{
			if(sharedFolder.exists()){
				dirFlag = true;	
			}else{
				dirFlag = sharedFolder.mkdirs();
			}
			if(dirFlag){
				InputStream docIns = loadDocFromDB(con, docFile);
				outStream = new FileOutputStream(sharedPath+"/"+fileName);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = docIns.read(buffer)) > 0) {
					outStream.write(buffer, 0, length);
				}				
				docIns.close();
				outStream.close();
			}else{
				resultDetails.put("ERROR", "Y");
				resultDetails.put("ERROR_MSG", (String) message.get("message"));
			}
		}catch(Exception e){
			resultDetails.put("ERROR", "Y");
			resultDetails.put("ERROR_MSG", (String) message.get("message"));
			e.printStackTrace();
		}
		return resultDetails;
	}
	//IN070345 End.
	private boolean isFileLimitExceed()
	{
		return getDocCount() <= getMaxFilesAllowed();
	}

	private boolean isFileSizeExceed()
	{
		return getSize() <= getAllowedFileSize();
	}

	private boolean checkFileLimt()
	{


		return (getDocCount() <= getMaxFilesAllowed() && getSize() <= getAllowedFileSize());
	}


	public void removeFile(String fileName)
	{
		if(noteDocMap.containsKey(fileName))
		{
			NoteDoc doc = noteDocMap.get(fileName);
			Connection con = null;
			PreparedStatement pst = null;
			String sqlQry = "";

			try
			{
				con = ConnectionManager.getConnection();
				if (doc.isLoadFromDB)
				{
					sqlQry = "DELETE FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND  FILE_SEQ_NO = ? AND FILE_NAME = ?";

					pst = con.prepareStatement(sqlQry);
					pst.setString(1, getAccessionNum());
				}
				else
				{
					sqlQry = "DELETE FROM CA_MULTI_FILE_UPLOAD_TEMP WHERE FILE_REF_NO = ? AND  FILE_SEQ_NO = ? AND FILE_NAME = ?";

					pst = con.prepareStatement(sqlQry);
					pst.setString(1, getFileReffNo());
				}
				pst.setInt(2, doc.getDocSeqNo());
				pst.setString(3, doc.getDocName());
				int res = pst.executeUpdate();
				checkAndUpdateCANOTE(con);
				if (res > 0)
				{
					con.commit();
					//IN070345 Start.
					if (doc.isLoadFromDB)
					{
						String sharedFilePath = doc.getDocSharedFilePath();
						String sharedFileName = doc.getDocSharedFileName();
						
						File file =new File(sharedFilePath+"/"+sharedFileName);
						if(file.exists()){
							file.delete();
						}
					}
					//IN070345 End.
				}
				if(pst != null)
				{
					pst.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				try
				{
					con.rollback();
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
			}
			finally
			{
				if(con != null)
				{
					try
					{
						con.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}

			noteDocMap.remove(fileName);

			setDocCount(getDocCount()-1);

			setSize(-doc.getDocSize());
			getDocNameList().remove(fileName);
		}
	}

	private void checkAndUpdateCANOTE(Connection con)
	{

		PreparedStatement pst = null;
		ResultSet rs = null;

		try
		{
			String sqlQry = "SELECT count(*) FROM CR_ENCOUNTER_DETAIL_OBJ " +
					" WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? order by FILE_SEQ_NO";
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, getAccessionNum());
			pst.setString(2, getNoteType());
			rs = pst.executeQuery();
			int docCnt = 0;
			while(rs.next())
			{
				docCnt = rs.getInt(1);
			}

			if(rs != null)
			{
				rs.close();
			}

			if(pst != null)
			{
				pst.close();
			}
			if(docCnt == 0)
			{
				sqlQry = "update CA_ENCNTR_NOTE set EXT_IMAGE_APPL_ID = null WHERE accession_num = ?";
				pst = con.prepareStatement(sqlQry);
				pst.setString(1, getAccessionNum());
				pst.executeUpdate();
			}

			if(rs != null)
			{
				rs.close();
			}

			if(pst != null)
			{
				pst.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean checkAndSingDoc(String accessNum)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try
		{
			String sqlQry = "SELECT EVENT_STATUS FROM CA_ENCNTR_NOTE  WHERE ACCESSION_NUM = ? ";
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, accessNum);
			rs = pst.executeQuery();
			String eventStatus = "";
			while(rs.next())
			{
				eventStatus = rs.getString(1)==null?"":rs.getString(1);
			}

			if (!eventStatus.equals("") && (eventStatus.equals("4") || eventStatus.equals("5")))
			{
				return true;
			}

			if(rs != null)
			{
				rs.close();
			}

			if(pst != null)
			{
				pst.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null)
				{
					con.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean isNoteDocSigned()
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try
		{
			String sqlQry = "SELECT EVENT_STATUS FROM CA_ENCNTR_NOTE  WHERE ACCESSION_NUM = ? ";
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, getAccessionNum());
			rs = pst.executeQuery();
			String eventStatus = "";
			while(rs.next())
			{
				eventStatus = rs.getString(1)==null?"":rs.getString(1);
			}

			if (!eventStatus.equals("") && (eventStatus.equals("4") || eventStatus.equals("5")))
			{
				return true;
			}

			if(rs != null)
			{
				rs.close();
			}

			if(pst != null)
			{
				pst.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null)
				{
					con.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	public Map<String, NoteDoc> getFileSet()
	{
		return this.noteDocMap;
	}

	public InputStream getFileInputStream(String fileName)
	{
		if(noteDocMap.containsKey(fileName))
		{
			return loadDocFromDB(null, noteDocMap.get(fileName));
		}
		return null;
	}

	public boolean checkForNewDoc()
	{
		Map<String, NoteDoc> docMap = getFileSet();
		Set<String> docNames = docMap.keySet();

		if(docNames != null)
		{
			boolean isNew = false;
			for(String docName : docNames)
			{
				NoteDoc doc = docMap.get(docName);
				if(!doc.isLoadFromDB())
				{
					isNew = true;
				}
			}
			return isNew;
		}

		return false;
	}

	private InputStream loadDocFromDB(Connection con , NoteDoc doc)
	{
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean closeCon = false;
		try
		{
			if(!doc.isLoadFromFileServer()){ //IN070345
				if(con == null)
				{
					con = ConnectionManager.getConnection();
					closeCon = true;
				}
				String sqlQry = "";
				if(doc.isLoadFromDB())
				{
					sqlQry = "SELECT  HIST_DATA FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND  CONTR_SYS_EVENT_CODE = ? and  FILE_SEQ_NO =? ";
					pst = con.prepareStatement(sqlQry);
					pst.setString(1, getAccessionNum());
					pst.setString(2, getNoteType());
					pst.setInt(3, doc.getDocSeqNo());					
				}
				else
				{
					sqlQry = "select FILE_CONTENT from CA_MULTI_FILE_UPLOAD_TEMP where FILE_REF_NO =? and FILE_SEQ_NO = ?";
					pst = con.prepareStatement(sqlQry);
					pst.setString(1, getFileReffNo());
					pst.setInt(2, doc.getDocSeqNo());	
				}
	
				rs = pst.executeQuery();
	
				while(rs.next())
				{
	
					return ((java.sql.Blob)rs.getBlob(1)).getBinaryStream();
				}
	
				if(rs != null)
				{
					rs.close();
				}
	
				if(pst != null)
				{
					pst.close();
				}
			//IN070345 Start.	
			}else{
				
				File file =new File(doc.getDocSharedFilePath()+"/"+doc.getDocSharedFileName());
				InputStream in = new FileInputStream(file);
				return in;
			}
			//IN070345 End.
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
		finally
		{
			if(con != null && closeCon)
			{
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}



	/**
	 * @return the fileReffNo
	 */
	public String getFileReffNo() {

		return this.fileReffNo;
	}

	/**
	 * @param fileReffNo the fileReffNo to set
	 */
	public void setFileReffNo(String fileReffNo) {

		this.fileReffNo = fileReffNo;

	}

	public String getFileType(String fileName)
	{
		if(noteDocMap.containsKey(fileName))
		{
			return noteDocMap.get(fileName).getDocType();
		}
		return null;
	}

	public long getFileSize(String fileName)
	{
		if(noteDocMap.containsKey(fileName))
		{
			return noteDocMap.get(fileName).getDocSize();
		}
		return -1;
	}

	private boolean isDuplicateFile(String fileName)
	{
		return noteDocMap.containsKey(fileName);
	}

	/**
	 * @return the dBDocCount
	 */
	public int getDBDocCount() {
		return DBDocCount;
	}

	/**
	 * @param docCount the dBDocCount to set
	 */
	private void setDBDocCount(int docCount) {
		this.DBDocCount = docCount;
	}

	/**
	 * @return the docMaxDBCount
	 */
	private int getDocMaxDBCount() {
		return this.docMaxDBCount;
	}

		/**
	 * @param docCount the docMaxDBCount to set
	 */
	private void setDocMaxDBCount(int docMaxDBCount) {
		this.docMaxDBCount = docMaxDBCount;
	}

	/**
	 * @return the docCount
	 */
	private int getDocCount() {
		return docCount;
	}

	/**
	 * @param docCount the docCount to set
	 */
	private void setDocCount(int docCount) {
		this.docCount = docCount;
	}

	/**
	 * @param noteDocMap the noteDoc to set
	 */
	private void setNoteDoc(String fileName, NoteDoc doc) {

		if (fileName != null && !fileName.equals(""))
		{
			this.noteDocMap.put(fileName, doc);
		}
	}

	/**
	 * @return the allowedFileSize
	 */
	public double getAllowedFileSize()
	{
		return (double)allowedFileSize;
	}

	/**
	 * @param allowedFileSize the allowedFileSize to set
	 */
	private void setAllowedFileSize(long allowedFileSize)
	{
		this.allowedFileSize = allowedFileSize;
	}

	/**
	 * @return the maxFilesAllowed
	 */
	public long getMaxFilesAllowed()
	{
		return maxFilesAllowed;
	}

	/**
	 * @param maxFilesAllowed the maxFilesAllowed to set
	 */
	private void setMaxFilesAllowed(long maxFilesAllowed)
	{
		this.maxFilesAllowed = maxFilesAllowed;
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	private void setSize(long size)
	{

		this.size +=  convertSize(size) ;
		/*if(getFileUnit().equals("M"))
		{
			this.size +=  convetSize() (double)(size/1024)/1204;
		}
		else if(getFileUnit().equals("K"))
		{
			this.size += (double) size/1024;
		}*/
	}

	/**
	 * @return the noteType
	 */
	public String getNoteType() {
		return noteType;
	}

	/**
	 * @param noteType the noteType to set
	 */
	private void setNoteType(String noteType) {
		this.noteType = noteType;
	}

	/**
	 * @return the accessionNum
	 */
	public String getAccessionNum() {
		return accessionNum;
	}

	/**
	 * @param accessionNum the accessionNum to set
	 */
	private void setAccessionNum(String accessionNum) {
		this.accessionNum = accessionNum;
	}

	/**
	 * @return the fileUnit
	 */
	public String getFileUnit() {
		return fileUnit;
	}

	/**
	 * @param fileUnit the fileUnit to set
	 */
	private void setFileUnit(String fileUnit) {
		this.fileUnit = fileUnit;
	}
	//IN070345 Start.
	private static String getFileExtension(String fileName) {        
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".")+1);
		else 
			return "";
	}
	////IN070345 End.
	public class NoteDoc
	{
		private String docName;
		private String docType;
		private String docRemarks;
		private boolean isLoadFromDB;
		private long docSize;
		private int docSeqNo;
		private FileItem docFileItem;
		private String docSharedFilePath; //IN070345 
		private String docSharedFileName; //IN070345
		private boolean isLoadFromFileServer; //IN070345
		/**
		 * @return the docFileItem
		 */
		public FileItem getDocFileItem() {
			return docFileItem;
		}
		/**
		 * @param docFileItem the docFileItem to set
		 */
		private void setDocFileItem(FileItem docFileItem) {
			this.docFileItem = docFileItem;
		}
		/**
		 * @return the docName
		 */
		public String getDocName() {
			return docName;
		}
		/**
		 * @param docName the docName to set
		 */
		private void setDocName(String docName) {
			this.docName = docName;
		}
		/**
		 * @return the docType
		 */
		public String getDocType() {
			return docType;
		}
		/**
		 * @param docType the docType to set
		 */
		private void setDocType(String docType) {
			this.docType = docType;
		}
		/**
		 * @return the isLoadFromDB
		 */
		public boolean isLoadFromDB() {
			return isLoadFromDB;
		}
		/**
		 * @param isLoadFromDB the isLoadFromDB to set
		 */
		private void setLoadFromDB(boolean isLoadFromDB) {
			this.isLoadFromDB = isLoadFromDB;
		}
		/**
		 * @return the docSize
		 */
		public long getDocSize() {
			return docSize;
		}
		/**
		 * @param docSize the docSize to set
		 */
		private void setDocSize(long docSize) {
			this.docSize = docSize;
		}
		/**
		 * @return the docSeqNo
		 */
		public int getDocSeqNo() {
			return docSeqNo;
		}
		/**
		 * @param docSeqNo the docSeqNo to set
		 */
		private void setDocSeqNo(int docSeqNo) {
			this.docSeqNo = docSeqNo;
		}
		/**
		 * @return the docRemarks
		 */
		public String getDocRemarks() {
			return docRemarks;
		}
		/**
		 * @param docRemarks the docRemarks to set
		 */
		private void setDocRemarks(String docRemarks) {

			this.docRemarks = docRemarks;
		}
		//IN070345 Start.
		public String getDocSharedFilePath() {
			return docSharedFilePath;
		}
		public void setDocSharedFilePath(String docSharedFilePath) {
			this.docSharedFilePath = docSharedFilePath;
		}
		public String getDocSharedFileName() {
			return docSharedFileName;
		}
		public void setDocSharedFileName(String docSharedFileName) {
			this.docSharedFileName = docSharedFileName;
		}
		public boolean isLoadFromFileServer() {
			return isLoadFromFileServer;
		}
		public void setLoadFromFileServer(boolean isLoadFromFileServer) {
			this.isLoadFromFileServer = isLoadFromFileServer;
		}
		//IN070345 End.
	}
}
