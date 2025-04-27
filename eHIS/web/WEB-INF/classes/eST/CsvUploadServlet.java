package eST;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import eST.Common.*;
import eCommon.Common.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class CsvUploadServlet extends javax.servlet.http.HttpServlet {

	HttpSession session = null;
	java.util.Properties p = null;
	PrintWriter out = null;
	String locale = "";
	List items = null;
	Iterator iter = null;
	long paramsize = 0;
	long docSize = 0;
	int file_limit = 0;
	FileItem Item = null;
	FileItem fileItem = null;
	static String phyInvId = "";
	static String store = "";
	static String file_name = "";
	static String filePath="";
	String bean_id = "";
	String bean_name = "";
	static String be;
	static boolean result1 = false;
	static PhysicalInventoryEntryBean bean = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Inside Servlet1");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException, IOException, FileNotFoundException {
		File file;
		session=req.getSession(true);
	    out = res.getWriter();
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;
		// String filePath=
		// CsvUploadServlet.(getServletContext().getRealPath("/temp"));
		
		//filePath = "C:\\temp\\";
		//filePath="C:\\EM_WLS_Workspace_15122022_Neon\\eHIS\\web\\eST\\";

		String contentType = req.getContentType();
		if ((contentType.indexOf("multipart/form-data") >= 0)) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);
			//factory.setRepository(new File("c:\\temp"));
			factory.setRepository(new File(filePath));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxFileSize);
			try {
				List fileItems = upload.parseRequest(req);
				Iterator i = fileItems.iterator();
				Iterator j = fileItems.iterator();
				while (j.hasNext()) {
					FileItem fi = (FileItem) j.next();
					if(fi.isFormField() && fi.getFieldName().equals("file_path") )
					{
						if (fi.getString() != null) {
							filePath= fi.getString();
							System.out.print("filePath in form field"+filePath);
						}
						break;
					}
				}

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
							System.out.println("CSV Upload Servlet file"+filePath);
						} else {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
							System.out.println("CSV Upload Servlet file"+filePath);
						}
						fi.write(file);
                        System.out.println("write successful");
					} else {
						if (fi != null) {
							System.out.println(fi);
							if (fi.getFieldName() != null) {
								if (fi.getFieldName().equals("phy_inv_id")) {
									if (fi.getString() != null) {
										phyInvId = fi.getString();
									}
								}
								if (fi.getFieldName().equals("file_name")) {
									if (fi.getString() != null) {
										file_name = fi.getString();
									}
								}
								if (fi.getFieldName().equals("store_code")) {
									if (fi.getString() != null) {
										store = fi.getString();
									}
								}
								if (fi.getFieldName().equals("bean_id")) {
									if (fi.getString() != null) {
										bean_id = fi.getString();
									}
								}
								if (fi.getFieldName().equals("bean_name")) {
									if (fi.getString() != null) {
										bean_name = fi.getString();
									}
								}
								
								if (fi.getFieldName().equals("Entry_Comp")) {
									if (fi.getString() != null) {
										be = fi.getString();
									}
								}
								
								bean = (PhysicalInventoryEntryBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( bean_id,  bean_name,session ) ;   
								 
							}
						}
					}
				}
				callBean();
				System.out.println("Start JS");
      		    out.println("<html><head><script language='javascript' src='../eST/js/PhysicalInventoryEntryByFile.js'></script>");  		   
      		    out.println("<script>callFileDetail(\""+phyInvId+"\",\""+be+ "\",\""+file_name+"\")</script>");
				out.println("</script></head></html>");
				System.out.println("End ");
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		} else {

			System.out.println("No file uploaded");
		}

	}

	private static void callBean() {
		
		bean.setLanguageId("en");
		if (bean != null) {
			result1 = bean.processFileData(file_name, store, phyInvId,be,filePath);
			System.out.println("Print from call bean "+ filePath);
		}
	}

	private String getMessage(String locale, String messageId, String moduleId) {
		java.util.Hashtable message = MessageManager.getMessage(locale, messageId, moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return (mesg);
	}
}
