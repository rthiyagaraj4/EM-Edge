/*
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
28/03/2019	IN068778		Selvin M		28/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
*/

package eOR;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import webbeans.eCommon.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import com.ehis.persist.PersistenceHelper;
/**
 * Servlet implementation class for Servlet: UploadServlet
 *
 */
public class ImageVideosMultiUploadServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	//static final long serialVersionUID = 1L;

	private ServletContext sc = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sc = config.getServletContext();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ImageVideosMultiUploadServlet() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doPost(request, response);

	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("charset=UTF-8");
		System.err.println("62,================ImageVideosMultiUploadServlet=======");
		DiskFileUpload upload = new DiskFileUpload();
		boolean isMultipart = DiskFileUpload.isMultipartContent(request);
		HttpSession ses = request.getSession(false);
		try{
		if(ses == null)
		{
			ses = request.getSession(true);
		}

		ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) com.ehis.persist.PersistenceHelper.getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", ses);

		if (isMultipart)
		{
			List<FileItem> fileItems = null;
			try
			{
				fileItems = upload.parseRequest(request);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if(fileItems != null)
			{
				Iterator<FileItem> itr = fileItems.iterator();
				FileItem fileItm = null;
				FileItem uploadDoc = null;
				String fldName = "";
				String fileRemarks = "" ;
				String fileType=""; 
				String fileuploadname=""; 
				String called_from = "" ;
//				String order_line_num = "" ;   //Common-ICN-0092  

				while (itr.hasNext())
				{
					fileItm = itr.next();
					if (!fileItm.isFormField())
					{
						uploadDoc = fileItm;
					}
					else
					{
						fldName = fileItm.getFieldName();
						if (fldName.equals("uploadremarks"))
						{
							fileRemarks =  new String(fileItm.getString().getBytes("ISO-8859-1"), "UTF-8");
						}
						if(fldName.equals("filetype"))
						{
							fileType =  fileItm.getString();	
						}
						if(fldName.equals("fileuploadname"))
						{
							fileuploadname =  fileItm.getString();
						}
						else if (fldName.equals("called_from"))
						{
							called_from = fileItm.getString();
						}

					}
				}
				if (uploadDoc != null)
				{
					String fileNameDoc = uploadDoc.getName();
					if(fileNameDoc.equals(""))
					{
						fileNameDoc=fileuploadname;
					}
				
					String fileName = fileNameDoc.substring(fileNameDoc.lastIndexOf("\\")+1, fileNameDoc.length());					
					String result = fbean.setFileList(fileRemarks, fileName, uploadDoc, fileItm.getContentType(), fileNameDoc);
					System.err.println("131,result=="+result+"called_from=="+called_from+",fileItm.getContentType()=>"+fileItm.getContentType());
					response.sendRedirect("../eOR/jsp/ImageVideosFileUploadList.jsp?resultFlag="+result+"&called_from="+called_from);
				}
				else
				{
					throw new IOException("Exception In ImageVideosMultiUploadServlet.java File uploading ......");
				}
			}
		}
		} //try
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
