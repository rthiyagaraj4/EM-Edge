/*
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
23/05/2019	IN068778		Selvin M		23/05/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
*/

package eOR;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import eCA.RecClinicalNotesMultiFileUploadBean.NoteDoc;
import eOR.Common.*;
import org.apache.commons.fileupload.FileItem;
import java.io.*;
import java.util.*;
import webbeans.eCommon.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageVideosMultiFileUploadBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputStream inStream = null;
	OutputStream outStream = null;
	private double allowedFileSize;
	private long maxFilesAllowed;
	private String orderId = "";
	private String orderLineNum = "";
	private String accessionNum = "";
	private String discr_msr_panel_id = "";
	private String fileUnit = "";
	private int docCount = 1;
	private int docMaxDBCount = 0;
	private int DBDocCount = 0;
	private double size;
	private Map<String, FileDoc> fileListMap;
	private List<String> docNameList;
	private String sharedPath;
	ArrayList<String> manipulatedFiles = new ArrayList<String>();

	public ImageVideosMultiFileUploadBean() {
		fileListMap = new HashMap<String, FileDoc>();
		docNameList = new ArrayList<String>();
		new ArrayList<String>();
	}

	public void checkAndLoadBean(String order_id, String order_line_num, String accession_num, String discr_msr_panel_id) {
		if (!order_id.equals(getOrderId())) {
			clear();
			setOrderId(order_id);
			setOrderLineNum(order_line_num);
			setAccessionNum(accession_num);
			setDiscrMsrPanelId(discr_msr_panel_id);
			load();
		}
	}
	
	private void setDiscrMsrPanelId(String discr_msr_panel_id) {
		this.discr_msr_panel_id = discr_msr_panel_id;
	}
	
	private String getDiscrMsrPanelId() {
		return discr_msr_panel_id;
	}

	public void checkAndLoadBean(String accession_num,String order_catalog_code, String view_type) {
		clear();
		setAccessionNum(accession_num);
		setDiscrMsrPanelId(order_catalog_code);
		load();	
	}
	
	public void checkAndLoadBean(String order_id, String order_line_num) {
		if (!order_id.equals(getOrderId())) {
			clear();
			setOrderId(order_id);
			setOrderLineNum(order_line_num);
			load();
		}
	}
	
	private void setAccessionNum(String accession_num){	
		accessionNum = accession_num;
	}
	
	private String getAccessionNum() {
		return accessionNum;
	}	
	
	public void setSharedPath() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;

		con = ConnectionManager.getConnection();
		try {
			pst = con.prepareStatement("SELECT ORD_FILES_UPLOAD_HTTP_PATH FROM OR_PARAM");
			rs = pst.executeQuery();
			while (rs.next()) {
				sharedPath = rs.getString(1);
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
	
	public void insertIntoTemp(String[] files){
		Connection con = null;
		PreparedStatement pst = null;
			
		try {
			String insQry = "INSERT INTO OR_MULTI_FILE_UPLOAD_VID_TEMP  SELECT ?, 'N' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM OR_MULTI_FILE_UPLOAD_VID_TEMP WHERE FILE_NAME = ? )";

			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(insQry);
									
			for(String file : files){
				String extn = file.substring(file.lastIndexOf(".")+1, file.length()); //IN70150
				
				if("mp4".equalsIgnoreCase(extn)){
					pst.setString(1, file);
					pst.setString(2, file);					
					pst.addBatch();
				}
			}
			pst.executeBatch();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			
			try {
				if(pst!=null)
					pst.close();
				if (con != null)
					ConnectionManager.returnConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public ArrayList<String> getUnlinkedVideoFiles(){
		return manipulatedFiles;
	}
	
	public void loadUnlinkedVideoFiles(){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		manipulatedFiles = new ArrayList<String>();
		
		try{
			String qry = "SELECT FILE_NAME FROM OR_MULTI_FILE_UPLOAD_VID_TEMP WHERE FILE_LINKED_YN = 'N'";

			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(qry);

			rs = pst.executeQuery();
			
			while(rs.next()){
				manipulatedFiles.add(rs.getString("FILE_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				
				if(pst!=null)
					pst.close();
				
				if (con != null)
					ConnectionManager.returnConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private int getMaxFileSeqNo(Connection con) throws Exception {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try{
			//String sqlQry = "SELECT MAX(FILE_SEQ_NO) FROM OR_MULTI_FILE_UPLOAD_OBJ WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?";
			String sqlQry = "SELECT MAX(FILE_SEQ_NO) FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ?";		
		
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, getAccessionNum());
			pst.setString(2, getDiscrMsrPanelId());
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{		
			if (rs != null) {
				rs.close();
			}
			
			if (pst != null) {
				pst.close();
			}
		}
		return -1;
	}
	
	private void load(){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try{
			String sqlQry = "SELECT OBJTYPE, HIST_DATA, FILE_NAME, FILE_SEQ_NO,EVENT_TITLE FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? ORDER BY FILE_SEQ_NO";
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, getAccessionNum());
			pst.setString(2, getDiscrMsrPanelId());
			rs = pst.executeQuery();
			FileDoc noteDoc = null;
			int docCnt = 1;
			while(rs.next()){
				noteDoc = new FileDoc();
				String fileName = rs.getString("FILE_NAME")== null?"temp_"+docCnt:rs.getString("FILE_NAME");
				noteDoc.setDocName(fileName);
				noteDoc.setLoadFromDB(true);
				noteDoc.setDocSeqNo(rs.getInt("FILE_SEQ_NO"));
				noteDoc.setDocSize(((java.sql.Blob)rs.getBlob("HIST_DATA")).length());
				noteDoc.setDocType(rs.getString("OBJTYPE"));
				noteDoc.setDocRemarks(rs.getString("EVENT_TITLE")==null?"":rs.getString("EVENT_TITLE"));
				//noteDoc.setDocStream(((java.sql.Blob)rs.getBlob("HIST_DATA")).getBinaryStream());
				setNoteDoc(fileName, noteDoc);
				setDocNameList(fileName);
				setSize(((java.sql.Blob)rs.getBlob("HIST_DATA")).length());
				setDocCount(getDocCount()+1);
				docCnt++;
			}

			setDocMaxDBCount(getMaxFileSeqNo(con));			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}

				if(pst != null){
					pst.close();
				}
				
				if(con != null){
					ConnectionManager.returnConnection(con);
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}			
		}
	}	

	public void clear() {
		removeTempDocs();
		this.orderId = "";
		this.orderLineNum = "";
		this.fileUnit = "";
		this.allowedFileSize = 0;
		this.maxFilesAllowed = 0;
		this.DBDocCount = 0;
		this.size = 0.0;
		this.docCount = 1;
		this.docMaxDBCount = 0;
		fileListMap.clear();
		docNameList.clear();
		manipulatedFiles.clear();
	}

	private void removeTempDocs() {
		Connection con = null;
		PreparedStatement pst = null;
		String sqlQry = "";
		try {
			con = ConnectionManager.getConnection();
			sqlQry = "DELETE FROM OR_MULTI_FILE_UPLOAD_TEMP WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?";
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, getOrderId());
			pst.setString(2, getOrderLineNum());
			int res = pst.executeUpdate();
			if (res > 0) {
				con.commit();
			}
			if (pst != null) {
				pst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		} finally {			
			try {
				if (pst != null) {
					pst.close();
				}
				if (con != null)
					ConnectionManager.returnConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}

	private void setDocNameList(String docName) {
		if (docName != null && !docName.equals("")) {
			docNameList.add(docName);
		}
	}

	public List<String> getDocNameList() {
		return docNameList;
	}

	private double convertSize(long fileSize) {
		double cSize = fileSize;
		if (getFileUnit().equals("M")) {
			cSize = (cSize / 1024) / 1024;
		} else if (getFileUnit().equals("K")) {
			cSize = cSize / 1024;
		}

		return cSize;
	}

	public String setFileList(String fileRemarks, String fileName,
			FileItem file, String fileType, String fileNameDoc) {
		String msg = "UNKNOWN";

		if (file != null && !isDuplicateFile(fileName)) {
			try {
				setDocMaxDBCount(getDocMaxDBCount() + 1);
				FileDoc fileDoc = new FileDoc();
				fileDoc.setDocFileItem(file);
				fileDoc.setDocName(fileName);
				fileDoc.setLoadFromDB(false);
				fileDoc.setDocSeqNo(getDocMaxDBCount());
				fileDoc.setDocSize(file.getSize());
				fileDoc.setDocType(file.getContentType());
				fileDoc.setDocRemarks(fileRemarks == null ? "" : fileRemarks);
				//fileDoc.setFileType(fileType == null ? "" : fileType);
				fileDoc.setFileType(file.getContentType());
				fileDoc.setFilePath(fileNameDoc == null ? "" : fileNameDoc);
				setNoteDoc(fileName, fileDoc);
				setSize(file.getSize());
				setDocNameList(fileName);
				//saveDocToDB(file.getInputStream(), fileName, file.getSize(),
						//fileType, fileNameDoc);
				saveDocToDB(file.getInputStream(), fileName, file.getSize(),
						file.getContentType(), fileNameDoc);
				setDocCount(getDocCount() + 1);
				msg = "SUCESS";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			if (isDuplicateFile(fileName)) {
				return "DUPLICATEFILE";
			}
		}
		return msg;
	}

	private void saveDocToDB(InputStream docIns, String fileName, long size,
			String fileType, String fileNameDoc) {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			StringBuilder insQry = new StringBuilder();
			insQry.append(" INSERT INTO OR_MULTI_FILE_UPLOAD_TEMP ");
			insQry.append(" (ORDER_ID, ORDER_LINE_NUM, FILE_SEQ_NO, FILE_NAME");
			insQry.append(",FILE_CONTENT,FILE_TYPE) values(?,?,?,?,?,?) ");

			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(insQry.toString());

			pst.setString(1, getOrderId());
			pst.setString(2, getOrderLineNum());
			pst.setInt(3, getDocMaxDBCount());
			pst.setString(4, fileName);	
			pst.setBinaryStream(5, docIns, (int) size);
			pst.setString(6, fileType);

			pst.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst!=null)
					pst.close();
				
				if (con != null)
					ConnectionManager.returnConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertDocToDB(Connection con, String order_id,
			String order_line_num) {
		PreparedStatement pst = null;
		boolean isCommit = false;

		ResultSet rs = null;
		String l_hist_rec_type = "TRET";
		
		PreparedStatement updateReferencePst = null;
		ResultSet updateReferenceRs = null;

		try {
			//String insQry = "INSERT INTO OR_MULTI_FILE_UPLOAD_OBJ ( ORDER_ID, ORDER_LINE_NUM, REMARKS, HIST_DATA,OBJTYPE, FILE_SEQ_NO,FILE_NAME,FILE_PATH,FILE_TYPE ) VALUES (?,?,?,EMPTY_BLOB(),?,?,?,?,?)";
			
			String insQry = "insert into CR_ENCOUNTER_DETAIL_OBJ ( HIST_REC_TYPE, CONTR_SYS_ID," +
					" ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA,OBJTYPE, " +
					" FILE_SEQ_NO,FILE_NAME ) values ('"+l_hist_rec_type+"','OR' ,?,?,?,empty_blob(),?,?,?)";

			pst = con.prepareStatement(insQry);
			
			
			String updateReferenceQry = "update OR_MULTI_FILE_UPLOAD_VID_TEMP set file_linked_yn = 'Y' where file_name = ?";
			
			updateReferencePst = con.prepareStatement(updateReferenceQry);

			for(String fileName : getDocNameList())
			{
				Map<String, FileDoc> noteMap = getFileSet();
				FileDoc docFile = noteMap.get(fileName);
				if(!docFile.isLoadFromDB())
				{					
					int fileTypeIndex = docFile.docName.lastIndexOf(".")+1;
					String fileType = docFile.docName.substring(fileTypeIndex);					
					
					String l_file_name = order_id + "_" + order_line_num + "_" + docFile.getDocSeqNo()+"."+fileType;
					pst.setString(1, getAccessionNum());
					pst.setString(2, getDiscrMsrPanelId());
					pst.setString(3, docFile.getDocRemarks());

					//pst.setBinaryStream(4, loadDocFromDB(con, docFile), (int)docFile.getDocSize());
					pst.setString(4, docFile.getDocType());
					pst.setInt(5, docFile.getDocSeqNo());
					if (!fileType.equalsIgnoreCase("mp4")) {
					pst.setString(6, l_file_name);
					}
					else
						pst.setString(6, fileName);
					pst.executeUpdate();				

					if (!fileType.equalsIgnoreCase("mp4")) {						
						fileName = sharedPath + l_file_name;
						updateDoc(con, order_id, order_line_num, docFile);						
						saveImage(con, fileName, docFile);
					} else {						
						updateReferencePst.setString(1, fileName);
						updateReferencePst.executeUpdate();
						//File oldName = new File(sharedPath + fileName);
						//File newName = new File(sharedPath + order_id + "_"
							//	+ order_line_num + "_" + docFile.getDocSeqNo()
								//+ "."+fileType);
						//oldName.renameTo(newName);
					}
					
					isCommit = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("479,e==" + e.getMessage());
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();
				
				if(pst!=null)			
					 pst.close();
				
				if(updateReferenceRs!=null)			
					updateReferenceRs.close();
				if(updateReferencePst!=null)
					updateReferencePst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();				
			}
		}
		return isCommit;
	}

	private void saveImage(Connection con, String fileName, FileDoc docFile)
			throws Exception {

		//File afile = new File(docFile.getFilePath()); //COMMON-ICN-0122
		InputStream docIns = loadDocFromDB(con, docFile);

		outStream = new FileOutputStream(fileName);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = docIns.read(buffer)) > 0) {
			outStream.write(buffer, 0, length);
		}
		
		docIns.close();
		outStream.close();
	}

	private void removeImage(Connection con, String fileName) throws Exception {
		fileName = sharedPath + fileName;

		File file = null;
		file = new File(fileName);

		if (file.exists()) {
			file.delete();
		}		
	}

	private void updateDoc(Connection con, String order_id,
			String order_line_num, FileDoc docFile) throws Exception {
		PreparedStatement pst = null;
		OutputStream outStream = null;
		ResultSet rs = null;

		//String update_enctr_dtl_obj = "SELECT HIST_DATA FROM OR_MULTI_FILE_UPLOAD_OBJ WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ? AND FILE_SEQ_NO = ? FOR UPDATE";
		String update_enctr_dtl_obj = "SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? AND FILE_SEQ_NO = ? FOR UPDATE";

		pst = con.prepareStatement(update_enctr_dtl_obj);
		
		pst.setString(1, getAccessionNum());
		pst.setString(2, getDiscrMsrPanelId());
		pst.setInt(3, docFile.getDocSeqNo());
		rs = pst.executeQuery();

		while (rs.next()) {

			java.sql.Blob outStreamObj = (java.sql.Blob) rs.getBlob(1);
			outStream = outStreamObj.setBinaryStream(0);
			InputStream docIns = loadDocFromDB(con, docFile);
			byte[] bytez = new byte[(int) docFile.getDocSize()]; // 4K buffer
																	// buf, 0,
																	// buf.length
			int index = docIns.read(bytez, 0, (int) docFile.getDocSize());


			while (index != -1) {
				outStream.write(bytez, 0, index);
				index = docIns.read(bytez, 0, (int) docFile.getDocSize());

			}
			outStream.close();
		}

		if (rs != null)
			rs.close();
		if (pst != null)
			pst.close();
	}

	public void removeFile(String fileName) {
		if (fileListMap.containsKey(fileName)) {
			FileDoc doc = fileListMap.get(fileName);
			Connection con = null;
			PreparedStatement pst = null;
			String sqlQry = "";
			String fileType = "";

			try {
				con = ConnectionManager.getConnection();
				if (doc.isLoadFromDB) {
					//sqlQry = "DELETE FROM OR_MULTI_FILE_UPLOAD_OBJ WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ? AND FILE_SEQ_NO = ?";				
					sqlQry = "DELETE FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? AND FILE_SEQ_NO = ?";
					
				} else {
					sqlQry = "DELETE FROM OR_MULTI_FILE_UPLOAD_TEMP WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ? AND FILE_SEQ_NO = ?";					
				}
				
				pst = con.prepareStatement(sqlQry);
				
				if (doc.isLoadFromDB) {
					pst.setString(1, getAccessionNum());				
					pst.setString(2, getDiscrMsrPanelId());
					pst.setInt(3, doc.getDocSeqNo());
				}
				else
				{
					pst.setString(1, getOrderId());				
					pst.setString(2, getOrderLineNum());
					pst.setInt(3, doc.getDocSeqNo());
				}
				
				int res = pst.executeUpdate();
				if (res > 0) {
					if (doc.isLoadFromDB) {
						int fileTypeIndex = doc.docName.lastIndexOf(".")+1;
						fileType = doc.docName.substring(fileTypeIndex);

						//fileName = getOrderId()+"_"+getOrderLineNum()+"_"+doc.docSeqNo+"."+fileType;
						removeImage(con, fileName);
						if("MP4".equalsIgnoreCase(fileType)){
							updateUnlinkedFiles(fileName);
						}
					}else{
						int fileTypeIndex = doc.docName.lastIndexOf(".")+1;
						fileType = doc.docName.substring(fileTypeIndex);
						
						if("MP4".equalsIgnoreCase(fileType)){
							getUnlinkedVideoFiles().add("fileName");
						}							
					}
				
					con.commit();
				}				
			} catch (Exception e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			} finally {
				try {
					if (pst != null) {
						pst.close();
					}

					if (con != null)
						ConnectionManager.returnConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			fileListMap.remove(fileName);

			setDocCount(getDocCount() - 1);

			setSize(-doc.getDocSize());
			getDocNameList().remove(fileName);
		}
	}

	private void updateUnlinkedFiles(String fileName) {
		Connection con = null;
		PreparedStatement pst = null;
			
		try {
			String insQry = "DELETE FROM OR_MULTI_FILE_UPLOAD_VID_TEMP WHERE FILE_NAME = ?";

			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(insQry);
									
			pst.setString(1, fileName);							
			pst.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			
			try {
				if(pst!=null)
					pst.close();
				if (con != null)
					ConnectionManager.returnConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Map<String, FileDoc> getFileSet() {
		return this.fileListMap;
	}

	public InputStream getFileInputStream(String fileName) {
		if (fileListMap.containsKey(fileName)) {
			return loadDocFromDB(null, fileListMap.get(fileName));
		}
		return null;
	}

	public boolean checkForNewDoc() {
		Map<String, FileDoc> docMap = getFileSet();
		Set<String> docNames = docMap.keySet();
		if (docNames != null) {
			boolean isNew = false;
			for (String docName : docNames) {
				FileDoc doc = docMap.get(docName);
				if (!doc.isLoadFromDB()) {
					isNew = true;
				}
			}
			return isNew;
		}
		return false;
	}

	private InputStream loadDocFromDB(Connection con, FileDoc doc) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strSplit = "";
		
		try {
			if (con == null) {
				con = ConnectionManager.getConnection();
			}
			String sqlQry = "";
			if (doc.isLoadFromDB()) {

				//sqlQry = "SELECT  HIST_DATA , FILE_NAME FROM OR_MULTI_FILE_UPLOAD_OBJ WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ? and  FILE_SEQ_NO = ? ";
				sqlQry = "SELECT HIST_DATA, FILE_NAME FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? and  FILE_SEQ_NO = ? ORDER BY FILE_SEQ_NO ";
				pst = con.prepareStatement(sqlQry);
				pst.setString(1, getAccessionNum());
				pst.setString(2, getDiscrMsrPanelId());
				pst.setInt(3, doc.getDocSeqNo());

			}else{

				sqlQry = "select FILE_CONTENT, FILE_NAME from OR_MULTI_FILE_UPLOAD_TEMP where ORDER_ID =? AND ORDER_LINE_NUM = ? and FILE_SEQ_NO = ?";

				pst = con.prepareStatement(sqlQry);
				pst.setString(1, getOrderId());
				pst.setString(2, getOrderLineNum());
				pst.setInt(3, doc.getDocSeqNo());
			}

			rs = pst.executeQuery();

			while (rs.next()) {
				strSplit = rs.getString("FILE_NAME");
				String[] array = strSplit.split(".");
				array = strSplit.split("\\.");

				if ("mp4".equalsIgnoreCase(array[1])) {
					return null;
				} else {
					return ((java.sql.Blob) rs.getBlob(1)).getBinaryStream();
				}
			}

			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getFileType(String fileName) {
		if (fileListMap.containsKey(fileName)) {
			return fileListMap.get(fileName).getDocType();
		}
		return null;
	}

	public String getFilePath(String fileName) {
		if (fileListMap.containsKey(fileName)) {
			return fileListMap.get(fileName).getDocType();
		}
		return null;
	}

	public long getFileSize(String fileName) {
		if (fileListMap.containsKey(fileName)) {
			return fileListMap.get(fileName).getDocSize();
		}
		return -1;
	}

	private boolean isDuplicateFile(String fileName) {
		return fileListMap.containsKey(fileName);
	}

	/**
	 * @return the dBDocCount
	 */
	public int getDBDocCount() {
		return DBDocCount;
	}

	/**
	 * @param docCount
	 *            the dBDocCount to set
	 */
	/*private void setDBDocCount(int docCount) {
		this.DBDocCount = docCount;
	}*/

	/**
	 * @return the docMaxDBCount
	 */
	private int getDocMaxDBCount() {
		return this.docMaxDBCount;
	}

	/**
	 * @param docCount
	 *            the docMaxDBCount to set
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
	 * @param docCount
	 *            the docCount to set
	 */
	private void setDocCount(int docCount) {
		this.docCount = docCount;
	}

	/**
	 * @param fileListMap
	 *            the fileDoc to set
	 */
	private void setNoteDoc(String fileName, FileDoc doc) {

		if (fileName != null && !fileName.equals("")) {
			this.fileListMap.put(fileName, doc);
		}
	}

	/**
	 * @return the allowedFileSize
	 */
	public double getAllowedFileSize() {
		return (double) allowedFileSize;
	}

	/**
	 * @return the maxFilesAllowed
	 */
	public long getMaxFilesAllowed() {
		return maxFilesAllowed;
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	private void setSize(long size) {

		this.size += convertSize(size);

	}

	/**
	 * @return the noteType
	 */
	public String getOrderLineNum() {
		return orderLineNum;
	}

	/**
	 * @param noteType
	 *            the noteType to set
	 */
	private void setOrderLineNum(String orderLineNum) {
		this.orderLineNum = orderLineNum;
	}

	/**
	 * @return the accessionNum
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param accessionNum
	 *            the accessionNum to set
	 */
	private void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the fileUnit
	 */
	public String getFileUnit() {
		return fileUnit;
	}

	public class FileDoc {
		private String docName;
		private String docType;
		private String docRemarks;
		private boolean isLoadFromDB;
		private long docSize;
		private String fileTypeName;
		private String filePathName;
		private int docSeqNo;
		private FileItem docFileItem;

		/**
		 * @return the docFileItem
		 */
		public FileItem getDocFileItem() {
			return docFileItem;
		}

		/**
		 * @param docFileItem
		 *            the docFileItem to set
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
		 * @param docName
		 *            the docName to set
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
		 * @param docType
		 *            the docType to set
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
		 * @param isLoadFromDB
		 *            the isLoadFromDB to set
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
		 * @param docSize
		 *            the docSize to set
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
		 * @param docSeqNo
		 *            the docSeqNo to set
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
		 * @return the fileTypeName
		 */

		public String getFileType() {
			return fileTypeName;
		}

		private void setFileType(String fileTypeName) {

			this.fileTypeName = fileTypeName;
		}

		public String getFilePath() {
			return filePathName;
		}

		private void setFilePath(String filePathName) {

			this.filePathName = filePathName;
		}

		/**
		 * @param docRemarks
		 *            the docRemarks to set
		 */
		private void setDocRemarks(String docRemarks) {

			this.docRemarks = docRemarks;
		}

		@Override
		public String toString() {
			return "FileDoc [docName=" + docName + ", docType=" + docType
					+ ", docRemarks=" + docRemarks + ", isLoadFromDB="
					+ isLoadFromDB + ", docSize=" + docSize + ", fileTypeName="
					+ fileTypeName + ", filePathName=" + filePathName
					+ ", docSeqNo=" + docSeqNo + ", docFileItem=" + docFileItem
					+ "]";
		}
	}
}