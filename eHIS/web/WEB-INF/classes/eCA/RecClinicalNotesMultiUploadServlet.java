/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/ 
package eCA;

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
public class RecClinicalNotesMultiUploadServlet extends javax.servlet.http.HttpServlet implements
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
	public RecClinicalNotesMultiUploadServlet() {
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
		DiskFileUpload upload = new DiskFileUpload();
		boolean isMultipart = DiskFileUpload.isMultipartContent(request);
		HttpSession ses = request.getSession(false);
		if(ses == null)
		{
			ses = request.getSession(true);
		}
		RecClinicalNotesMultiFileUploadBean fbean = (RecClinicalNotesMultiFileUploadBean) PersistenceHelper.getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", ses);

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
				String called_from = "" ;

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
						}else if (fldName.equals("called_from"))
						{
							called_from = fileItm.getString();
						}

					}
				}
				if (uploadDoc != null)
				{
					String fileName = uploadDoc.getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1, fileName.length());
					String result = fbean.setFileList(fileRemarks, fileName, uploadDoc);
					response.sendRedirect("../eCA/jsp/RecClinicalNotesFileUploadList.jsp?resultFlag="+result+"&called_from="+called_from);
				}
				else
				{
					
					throw new IOException("Exception In RecClinicalNotesMultiUploadServlet.java File uploading ......");
				}
			}
		}
	}
}
