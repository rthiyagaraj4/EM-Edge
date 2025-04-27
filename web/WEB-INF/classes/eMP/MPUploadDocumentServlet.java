package eMP;

import eCommon.SingleTabHandler.*;
import java.io.*;
import java.net.URLEncoder;
import java.sql.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import org.apache.commons.fileupload.*;

public class MPUploadDocumentServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	String locale = "";
	String facility_id = "";
	String client_ip_address = "";
	String operation = "";
	String function_id = "";                                           
	String patient_id = "";                                           
	String encounter_id = "";                                            
	String insurance_type = "";                                             
	String serial_no = "";                                             
	String upload_doc_file = "";
	String addedById = "";
	String modifiedById = "";
	String addedFacilityId = "";
	String modifiedFacilityId = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";
	String error = "";
	String err_value = "";
	String docName = "";
	String docType = "";
	String name	= "";
	String value = "";
	int cnt	= 0;
	long docSize = 0;
	boolean status;
	boolean isMultipart	= false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	FileItem Item = null;
	FileItem fileItem = null;
	List items = null;
	Iterator iterHiddFields = null;
	Iterator iterFiles = null;
	java.io.InputStream instream = null;
	DiskFileUpload upload = null;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException {
		
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) session.getValue("facility_id");
		this.client_ip_address = p.getProperty("client_ip_address");
		this.out = response.getWriter();
        locale = p.getProperty("LOCALE");

		addedById = p.getProperty( "login_user" );
		modifiedById = addedById;
		addedFacilityId = facility_id;
		modifiedFacilityId = addedFacilityId;
		addedAtWorkstation = client_ip_address;
		modifiedAtWorkstation = addedAtWorkstation;

		isMultipart	= FileUpload.isMultipartContent(request);
	
		try{

			if(isMultipart){

				upload	= new DiskFileUpload();
				items	= upload.parseRequest(request);
				iterHiddFields	= items.iterator();
				iterFiles	= items.iterator();

				while(iterHiddFields.hasNext()){

					Item = (FileItem)iterHiddFields.next();

					if(Item.isFormField()){ 

						name = Item.getFieldName();
						value = Item.getString();

						if(name.equals("operation")) operation = checkForNull(value);
						if(name.equals("function_id")) function_id = checkForNull(value);
						if(name.equals("patient_id")) patient_id = checkForNull(value);
						if(name.equals("hidd_encounter_id")) encounter_id = checkForNull(value);
						if(name.equals("hidd_insurance_type")) insurance_type = checkForNull(value);
						if(name.equals("hidd_serial_no")) serial_no = checkForNull(value);

					}
					
				}

				while(iterFiles.hasNext()){

					Item = (FileItem)iterFiles.next();

					if(!Item.isFormField()){ 

						name = Item.getFieldName();

						if(fileItem == null && name.equals("upload_doc_name"+serial_no)){
						docName	= Item.getName();
						if(!docName.equals("")) fileItem = Item;
						docType	= Item.getContentType();
						docSize	= Item.getSize();

						if(docType == null)
							docType = "999";
						}
					}
					
				}
			}

			if(operation.equals("insert")){
				insertDocument(request,response);
			}else if(operation.equals("modify")){
				updateDocument(request,response);
			}

		}catch(Exception e){
				e.printStackTrace();
		}

	}

	private  void insertDocument(HttpServletRequest request,HttpServletResponse response) {

		try {
				con = ConnectionManager.getConnection(request);
				stmt = con.createStatement();
				con.setAutoCommit(false);
				
				String sql = "INSERT INTO mp_upload_document (encounter_id, facility_id, patient_id, insurance_type, serial_no, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, document_file ) VALUES (?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, EMPTY_BLOB () )";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, encounter_id);
				pstmt.setString(2, facility_id);
				pstmt.setString(3, patient_id);
				pstmt.setString(4, insurance_type);						
				pstmt.setString(5, serial_no);						
				pstmt.setString(6, addedById);
				pstmt.setString(7, addedAtWorkstation);
				pstmt.setString(8, addedFacilityId);
				pstmt.setString(9, modifiedById);
				pstmt.setString(10, modifiedAtWorkstation);
				pstmt.setString(11, modifiedFacilityId);

				cnt=pstmt.executeUpdate();

				if(pstmt != null) pstmt.close();

				if(cnt>0){

					java.sql.Blob img_blob = null;	
					java.io.OutputStream blobOutputStream = null;

					String updateSQL = "SELECT document_file FROM mp_upload_document WHERE patient_id = ? AND encounter_id = ? AND serial_no = ? AND facility_id = ? FOR UPDATE";

					pstmt=con.prepareStatement(updateSQL);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,serial_no);
					pstmt.setString(4,facility_id);

					ResultSet rsupdt= pstmt.executeQuery();

					while(rsupdt!=null && rsupdt.next()){

						img_blob = (java.sql.Blob)rsupdt.getBlob(1);
						blobOutputStream = img_blob.setBinaryStream(0);
						int docs = (int)docSize;
						
						blobOutputStream.write(fileItem.get(),0,docs);
						blobOutputStream.close();
					}

					if(rsupdt!=null) rsupdt.close();
					if(pstmt!=null)	pstmt.close();
					status = true;
					fileItem = null;

				}else{
					status=false;
				}

			if(status){
				err_value="1";
				con.commit();

				Hashtable hashtable = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				if(function_id.equals("UPLOAD_DOC"))
				{
					error = "";
				}else
				{
					error = (String)hashtable.get("message");
				}
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);
				if ( hashtable != null ) hashtable.clear();
				out.println("<script language='JavaScript'>parent.onSuccess();</script>");

			}else{
				err_value="0";
				con.rollback();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);	 	 
			}

			if(stmt!=null) stmt.close();

		} catch ( Exception e ) {
			//out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			try {
				con.rollback();
			} catch(Exception eee) {
				//out.println("Exception raised by servlet"+eee.toString());
				eee.printStackTrace();
			}
			//out.println(e.toString());
			e.printStackTrace();
		} finally {
			 if( con != null ) ConnectionManager.returnConnection(con,request);
		}

	}

	private  void updateDocument(HttpServletRequest request,HttpServletResponse response) {

		try {
				con = ConnectionManager.getConnection(request);
				stmt = con.createStatement();
				con.setAutoCommit(false);
				
				String sql = "UPDATE mp_upload_document SET encounter_id = ?, facility_id = ?, patient_id = ?, insurance_type = ?, serial_no = ?, added_by_id = ?, added_date = SYSDATE, added_at_ws_no = ?, added_facility_id = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, document_file = EMPTY_BLOB () WHERE patient_id = ? AND encounter_id = ? AND serial_no = ? AND facility_id = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, encounter_id);
				pstmt.setString(2, facility_id);
				pstmt.setString(3, patient_id);
				pstmt.setString(4, insurance_type);						
				pstmt.setString(5, serial_no);						
				pstmt.setString(6, addedById);
				pstmt.setString(7, addedAtWorkstation);
				pstmt.setString(8, addedFacilityId);
				pstmt.setString(9, modifiedById);
				pstmt.setString(10, modifiedAtWorkstation);
				pstmt.setString(11, modifiedFacilityId);
				pstmt.setString(12, patient_id);
				pstmt.setString(13, encounter_id);
				pstmt.setString(14, serial_no);
				pstmt.setString(15, facility_id);

				cnt=pstmt.executeUpdate();

				if(pstmt != null) pstmt.close();

				if(cnt>0){

					java.sql.Blob img_blob = null;	
					java.io.OutputStream blobOutputStream = null;

					String updateSQL = "SELECT document_file FROM mp_upload_document WHERE patient_id = ? AND encounter_id = ? AND serial_no = ? AND facility_id = ? FOR UPDATE";

					pstmt=con.prepareStatement(updateSQL);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,serial_no);
					pstmt.setString(4,facility_id);

					ResultSet rsupdt= pstmt.executeQuery();

					while(rsupdt!=null && rsupdt.next()){

						img_blob = (java.sql.Blob)rsupdt.getBlob(1);
						blobOutputStream = img_blob.setBinaryStream(0);
						int docs = (int)docSize;
						
						blobOutputStream.write(fileItem.get(),0,docs);
						blobOutputStream.close();
					}

					if(rsupdt!=null) rsupdt.close();
					if(pstmt!=null)	pstmt.close();
					status = true;
					fileItem = null;

				}else{
					status=false;
				}

			if(status){
				err_value="1";
				con.commit();

				Hashtable hashtable = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				if(function_id.equals("UPLOAD_DOC"))
				{
					error = "";
				}else
				{
					error = (String)hashtable.get("message");
				}
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);
				if ( hashtable != null ) hashtable.clear();
				out.println("<script language='JavaScript'>parent.onSuccess();</script>");

			}else{
				err_value="0";
				con.rollback();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);	 	 
			}

			if(stmt!=null) stmt.close();

		} catch ( Exception e ) {
			//out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			try {
				con.rollback();
			} catch(Exception eee) {
				//out.println("Exception raised by servlet"+eee.toString());
				eee.printStackTrace();
			}
			//out.println(e.toString());
			e.printStackTrace();
		} finally {
			 if( con != null ) ConnectionManager.returnConnection(con,request);
		}

	}
	
	public String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	public String checkForNull(String inputString, String Defaultstr)
	{
		return((inputString == null) ? Defaultstr : inputString);
	}
}