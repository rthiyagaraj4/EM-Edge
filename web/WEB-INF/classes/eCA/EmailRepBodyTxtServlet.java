/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.HttpUtils.*;
import webbeans.eCommon.*;
import org.apache.commons.fileupload.*;
import java.net.*;

import eCommon.SingleTabHandler.*;

public class EmailRepBodyTxtServlet extends javax.servlet.http.HttpServlet
{
	HttpSession session				= null;
	java.util.Properties p			= null;

	Connection con					= null;
	PrintWriter out					= null;
	
	String facilityId				= "";
	String client_ip_address		= "";
	String addedById				= "";
	String modifiedById				= "";
	String addedFacilityId			= "";
	String modifiedFacilityId		= "";
	String addedAtWorkstation		= "";
	String modifiedAtWorkstation	= "";
	String locale					= "";
	String enabled					= "";
	String error					= "";
	String mode					= "";
	int insert_clob_result					= 0;
	java.io.InputStream instream	= null;

	public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, IOException, FileNotFoundException
    {
		out = res.getWriter();
		try
		{
		   req.setCharacterEncoding("UTF-8");
		   res.setContentType("text/html;charset=UTF-8");
		   session					= req.getSession(false);
		   p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		   locale					= (String) p.getProperty("LOCALE");
		   facilityId				= (String) session.getValue( "facility_id" ) ;
		   client_ip_address		= p.getProperty("client_ip_address");
		   
		   addedById				= p.getProperty( "login_user" ) ;
           modifiedById				= addedById ;
           addedFacilityId			= facilityId;
           modifiedFacilityId		= addedFacilityId ;
           addedAtWorkstation		= client_ip_address;
		         
		   modifiedAtWorkstation	= addedAtWorkstation ;
			con = ConnectionManager.getConnection(req);
		   eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean= (eCA.EmailRepBodyTxtBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("CA_EmailRepBodyTxtBean","eCA.EmailRepBodyTxtBean",session);
			mode=req.getParameter("mode")==null?"":((String)req.getParameter("mode"));
			if(mode.equals("insert")){
				insert(req,res,out,CA_EmailRepBodyTxtBean);
			}else if(mode.equals("modify")){
				modify(req,res,out,CA_EmailRepBodyTxtBean);
			}
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception @ Servlet - main:2"+e.toString());//common-icn-0181
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con);	
		}
    }
   
    private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out,eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean) throws Exception
    {
		HashMap tabdata			= new HashMap();
		HashMap condflds		= new HashMap();
		String tabname				= "";
		java.util.HashMap results=new HashMap();
		String error_value = "0" ;
		boolean inserted=false;
		PreparedStatement insert_clob_data1 = null;
		try{
			String module_id=req.getParameter("module_id");
			String report_id=req.getParameter("report_id");
			String body_text_ref=req.getParameter("body_text_ref");
			String body_text_dec=req.getParameter("body_text_dec");
			String editor_content1=checkForNull((String)CA_EmailRepBodyTxtBean.getEditorContent(),"");
			tabdata.put("body_text_desc",body_text_dec);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			condflds.put("module_id",module_id);
			condflds.put("report_id",report_id);
			condflds.put("body_text_ref",body_text_ref);
			boolean local_ejbs		= false;
			tabname					= "SM_REPORT_MAIL_BODY";
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;
						
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();
				
			results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();
			condflds.clear();
			
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
			if ( inserted ){
				insert_clob_data1					= con.prepareStatement("select BODY_TEMPLATE_TEXT from SM_REPORT_MAIL_BODY where module_id =? and report_id=? and body_text_ref=? for update");
		
				String error1= insertClobData(insert_clob_data1,editor_content1,module_id,report_id,body_text_ref);
				if(!error1.equals("")){
					inserted=false;
					error=error1;
					con.rollback();
				}
			}
			if(inserted){
				error_value = "1" ;	           
				con.commit();
			}
				results.clear();

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}catch ( Exception e )
        {
			
			e.printStackTrace();
        }
		finally{
			if(insert_clob_data1 !=null)
				insert_clob_data1.close();
			
		}
   }
    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out,eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean) throws Exception
    {
		String error_value = "0" ;
		PreparedStatement insert_clob_data = null;	
        try
        {	
			String module_id=req.getParameter("module_id");
			String report_id=req.getParameter("report_id");
			String body_text_ref=req.getParameter("body_text_ref");
			String body_text_dec=req.getParameter("body_text_dec");
			String editor_content=checkForNull((String)CA_EmailRepBodyTxtBean.getEditorContent(),"");
			HashMap tabdata=new HashMap();
			String tabname				= "";
			
			tabdata.put("module_id",module_id);
			tabdata.put("report_id",report_id);
			tabdata.put("body_text_ref",body_text_ref);
			tabdata.put("body_text_desc",body_text_dec);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			String dupflds[]={"module_id","report_id","body_text_ref"};
			boolean local_ejbs = false;
			tabname="SM_REPORT_MAIL_BODY";
		    if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tabname.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
			if ( inserted ){
				insert_clob_data					= con.prepareStatement("select BODY_TEMPLATE_TEXT from SM_REPORT_MAIL_BODY where module_id =? and report_id=? and body_text_ref=? for update");
		
				String error1= insertClobData(insert_clob_data,editor_content,module_id,report_id,body_text_ref);
				if(!error1.equals("")){
					inserted=false;
					error=error1;
					con.rollback();
				}
			}
			if(inserted){
				error_value = "1" ;			
				con.commit();
			}
			results.clear();
	        res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
        }
        catch ( Exception e )
        {
            
			e.printStackTrace();
        }finally{
			if(insert_clob_data !=null)
				insert_clob_data.close();
		}
    }
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
  	public String insertClobData(PreparedStatement pstmt_clob, String editor_content,String module_id,String report_id,String body_text_ref)
	{
		StringBuffer messages = new StringBuffer("");
		ResultSet rset_clob = null;
		PreparedStatement pstmt=null;
		int count=0;
	
		try
		{
			pstmt=con.prepareStatement("update SM_REPORT_MAIL_BODY set BODY_TEMPLATE_TEXT=empty_clob() where module_id =? and report_id=? and body_text_ref=?");
			pstmt.setString(1,module_id);
			pstmt.setString(2,report_id);
			pstmt.setString(3,body_text_ref);
			count=pstmt.executeUpdate();
			if(count>0){				
			pstmt_clob.setString(1,module_id);
			pstmt_clob.setString(2,report_id);
			pstmt_clob.setString(3,body_text_ref);
			rset_clob=pstmt_clob.executeQuery();
			if(rset_clob!=null && rset_clob.next())
			{
				BufferedWriter bw =null;
				Clob clb=null;
				clb = (Clob)rset_clob.getClob("BODY_TEMPLATE_TEXT");
				bw   = new BufferedWriter(clb.setCharacterStream(0));
				bw.write(editor_content,0,editor_content.length());
				bw.flush();
				bw.close();	
								
			}	
				
			rset_clob.close();
		}
		} catch ( Exception ee ) {
			messages.append("Error "+ee.getMessage() ) ;
			
			ee.printStackTrace() ;
		} finally {
			try {

				if (rset_clob != null) {
					rset_clob.close();
				}
				if (pstmt_clob != null) {
					pstmt_clob.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e){e.printStackTrace() ;}
		}
		
		return messages.toString();
	}
	
}
