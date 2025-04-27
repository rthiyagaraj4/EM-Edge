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

public class SecTempOutputFormServlet extends javax.servlet.http.HttpServlet
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
		   eCA.SecTempOutputFormBean CA_SecTempOutputFormBean= (eCA.SecTempOutputFormBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("CA_SecTempOutputFormBean","eCA.SecTempOutputFormBean",session);
		   mode=req.getParameter("mode");
		   if(mode == null || mode.equals(""))
			   mode="";

		   if(mode.equals("insert")){
				insert(req,res, out,CA_SecTempOutputFormBean);	
		   }else if(mode.equals("modify")){
				modify(req,res,out,CA_SecTempOutputFormBean);
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
   
    private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out,eCA.SecTempOutputFormBean CA_SecTempOutputFormBean) throws Exception
    {

		HashMap tabdata			= new HashMap();
		HashMap condflds		= new HashMap();
		String tabname				= "";
		java.util.HashMap results=new HashMap();
		String error_value = "0" ;
		boolean inserted=false;
		PreparedStatement insert_clob_data1 = null;
		PreparedStatement insert_xml_clob_data1 = null;
		try{
			String section1=req.getParameter("section");
			String editor_content1=checkForNull((String)CA_SecTempOutputFormBean.getEditorContent(),"");

			
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			condflds.put("sec_hdg_code",section1);
			boolean local_ejbs		= false;
			tabname					= "ca_sec_output_form";
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
				insert_clob_data1					= con.prepareStatement("select OUTPUT_FORMAT from CA_SEC_OUTPUT_FORM where  SEC_HDG_CODE =? for update");
		
				String error1= insertClobData(insert_clob_data1,editor_content1,section1);
				if(!error1.equals("")){
				inserted=false;
				error=error1;
				con.rollback();
				}


			}

			if ( inserted ){
				insert_xml_clob_data1					= con.prepareStatement("select OUTPUT_XML_FORMAT from CA_SEC_OUTPUT_FORM where  SEC_HDG_CODE =? for update");
		
				String error2= insertXMLClobData(insert_xml_clob_data1,editor_content1,section1);
				if(!error2.equals("")){
				inserted=false;
				error=error2;
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
			if(insert_xml_clob_data1 !=null)
				insert_xml_clob_data1.close();

			
		}
   }


    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out,eCA.SecTempOutputFormBean CA_SecTempOutputFormBean) throws Exception
    {
		String error_value = "0" ;
		PreparedStatement insert_clob_data = null;	
		PreparedStatement insert_xml_clob_data = null;	
        try
        {	

			String section=req.getParameter("section");
			String editor_content=checkForNull((String)CA_SecTempOutputFormBean.getEditorContent(),"");



			HashMap tabdata=new HashMap();
			String tabname				= "";
			
			tabdata.put("sec_hdg_code",section);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"sec_hdg_code"};
			boolean local_ejbs = false;
			tabname="ca_sec_output_form";
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
				insert_clob_data					= con.prepareStatement("select OUTPUT_FORMAT from CA_SEC_OUTPUT_FORM where  SEC_HDG_CODE =? for update");
		
				String error1= insertClobData(insert_clob_data,editor_content,section);
				if(!error1.equals("")){
					inserted=false;
					error=error1;
					con.rollback();
				}
			}
			
			if ( inserted ){
				insert_xml_clob_data					= con.prepareStatement("select OUTPUT_XML_FORMAT from CA_SEC_OUTPUT_FORM where  SEC_HDG_CODE =? for update");	
				String error2= insertXMLClobData(insert_xml_clob_data,editor_content,section);
				if(!error2.equals("")){
					inserted=false;
					error=error2;
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
			if(insert_xml_clob_data !=null)
				insert_xml_clob_data.close();
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
  	public String insertClobData(PreparedStatement pstmt_clob, String editor_content,String code)
	{

		StringBuffer messages = new StringBuffer("");
		ResultSet rset_clob = null;
		PreparedStatement pstmt=null;
		int count=0;
	
		try
		{
			pstmt=con.prepareStatement("update ca_sec_output_form set OUTPUT_FORMAT=empty_clob() where SEC_HDG_CODE =? ");
			pstmt.setString(1,code);
			count=pstmt.executeUpdate();
			if(count>0){

			pstmt_clob.setString(1,code);
			rset_clob=pstmt_clob.executeQuery();
			if(rset_clob!=null && rset_clob.next())
			{
				BufferedWriter bw =null;
				Clob clb=null;

				clb = (Clob)rset_clob.getClob("OUTPUT_FORMAT");
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
	 public String insertXMLClobData(PreparedStatement pstmt_clob, String editor_content,String code)
	{

		StringBuffer messages = new StringBuffer("");
		ResultSet rset_clob = null;
		PreparedStatement pstmt=null;
		int count=0;
		try
		{
			/*********************/

			editor_content=editor_content.replaceAll("<","&lt;");

			editor_content="<OUTTEMP><TEXT>"+editor_content;

			//String org=editor_content;			
			String str="";
			String des="";
			String temp="";
			String type="";

			editor_content=editor_content.replaceAll("&nbsp;","&#160;");

			//int i=org.indexOf('~');			
			int i=editor_content.indexOf('~');			
			while(i != -1){				
				str=editor_content.substring(i,editor_content.indexOf('`')+1);
				temp=str.substring(1,str.length()-1);
				if((temp.substring(0,2).equals("C_"))){
					type=temp.substring(2,3);
					temp=temp.substring(0,2)+temp.substring(4,temp.length());
					des="</TEXT><FIELD ID=\""+temp+"\" TYPE=\""+type+"\"></FIELD><TEXT>";
				}else
				des="</TEXT><FIELD ID=\""+temp+"\" TYPE=\"hidden\"></FIELD><TEXT>";
				editor_content=editor_content.replaceAll(str,des);
				i=editor_content.indexOf('~');
			}
			editor_content=editor_content+"</TEXT></OUTTEMP>";

			/*********************/
			pstmt=con.prepareStatement("update ca_sec_output_form set OUTPUT_XML_FORMAT =empty_clob() where SEC_HDG_CODE =? ");
			pstmt.setString(1,code);

			count=pstmt.executeUpdate();

			if(count>0){

			pstmt_clob.setString(1,code);
			rset_clob=pstmt_clob.executeQuery();
			if(rset_clob!=null && rset_clob.next())
			{
				Clob clb1=null;
				BufferedWriter bw1=null;

				clb1 = (Clob)rset_clob.getClob("OUTPUT_XML_FORMAT");     
				bw1   = new BufferedWriter(clb1.setCharacterStream(0));
				bw1.write(editor_content,0,editor_content.length());
				bw1.flush();
				bw1.close();	
								
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
