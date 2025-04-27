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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
public class QueryNoteTemplateServlet extends javax.servlet.http.HttpServlet	
{

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{ 
		
		PrintWriter out = null;
		Connection con = null;
	
		String mode ="";
		request.setCharacterEncoding("UTF-8");			
		response.setContentType("text/html; charset=UTF-8");
		con = ConnectionManager.getConnection(request);

		mode = request.getParameter("mode")==null?"insert":request.getParameter("mode");
		
		if(mode.equals("insert"))
		{
			insertQueryTemplate(request,response,con);
		}
		else
		{
			updateQueryTemplate(request,response,con);
		}

	}

	public void insertQueryTemplate(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		java.util.Properties p;
		HttpSession session;
		session = request.getSession(false);

		String loginuserid = "";
		String client_ip_address = "";
		String facility_id = "";
		String locale="";

		p					= (java.util.Properties) session.getAttribute( "jdbc" ) ;
		facility_id			= (String) session.getAttribute( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		loginuserid		=(String) session.getAttribute("login_user");
		locale = (String) p.getProperty("LOCALE");

		String query_id = "";
		String query_desc = "";
		String note_type = "";
		String bean_key = "";
		String eff_status = "";
		String sec_hdg_code = "";
		String comp_id = "";
		String srl_no = "";
		String prompt_id = "";
		String result_type = "";
		String error_value ="";
		String errorMsg =	"";

		Boolean insFlag = false;
		int [] nInsStat1		= null;

		query_id = request.getParameter("query_id")==null?"":request.getParameter("query_id");
		query_desc = request.getParameter("query_desc")==null?"":request.getParameter("query_desc");
		note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");

		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		eff_status = request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList selectedList = new ArrayList();
		String strVal ="";
		StringTokenizer Tokens = null ;

		eCA.PatientBannerGroupLine queryTemplateBean = null;

		queryTemplateBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		selectedList = queryTemplateBean.returnList1();

		int listSize = selectedList.size();
		int nInsStat = 0;

		String dup_chk ="Select 1 from CA_TEMP_QRY_HDR Where QUERY_REF = ? ";

		String ins_CaTempQryHdr=" INSERT INTO CA_TEMP_QRY_HDR (QUERY_REF ,QUERY_DESC ,NOTE_TYPE ,EFF_STATUS ,ADDED_BY_ID ,ADDED_DATE,ADDED_AT_WS_NO         ,ADDED_FACILITY_ID ,MODIFIED_BY_ID ,MODIFIED_DATE,MODIFIED_AT_WS_NO      ,MODIFIED_FACILITY_ID ) VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) "; 

		String ins_CaTempQryDtl="INSERT INTO CA_TEMP_QRY_DTL ( QUERY_REF,SEC_HDG_CODE  ,COMP_ID,SRL_NO,PROMPT_ID ,RESULT_TYPE ,ADDED_BY_ID ,ADDED_DATE                 ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE              ,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";

		try
		{
			pstmt = con.prepareStatement(dup_chk);
			pstmt.setString(1,query_id);
			rs = pstmt.executeQuery();

			if(rs.next())
			{
				errorMsg = getMessage(locale, "CODE_ALREADY_EXISTS","Common");

				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(errorMsg,"UTF-8") + "&err_value=0");
				return;
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(ins_CaTempQryHdr);
			pstmt.setString(1,query_id);
			pstmt.setString(2,query_desc);
			pstmt.setString(3,note_type);
			pstmt.setString(4,eff_status);
			pstmt.setString(5,loginuserid);
			pstmt.setString(6,client_ip_address);
			pstmt.setString(7,facility_id);
			pstmt.setString(8,loginuserid);
			pstmt.setString(9,client_ip_address);
			pstmt.setString(10,facility_id);

			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();

			if(nInsStat>0)
			{

				pstmt = con.prepareStatement(ins_CaTempQryDtl);
				
				for(int k=0; k<listSize; k++)
				{
				
					strVal = (String)selectedList.get(k);
			
					Tokens = new StringTokenizer(strVal,"~");

					while(Tokens.hasMoreTokens())
					{

						sec_hdg_code =(String)Tokens.nextToken();
						comp_id =(String)Tokens.nextToken();
						srl_no =(String)Tokens.nextToken();
						prompt_id =(String)Tokens.nextToken();
						result_type =(String)Tokens.nextToken();

					
						pstmt.clearParameters();
						pstmt.setString(1,query_id);
						pstmt.setString(2,sec_hdg_code);
						pstmt.setString(3,comp_id);
						pstmt.setString(4,srl_no);
						pstmt.setString(5,prompt_id);
						pstmt.setString(6,result_type);
						pstmt.setString(7,loginuserid);
						pstmt.setString(8,client_ip_address);
						pstmt.setString(9,facility_id);
						pstmt.setString(10,loginuserid);
						pstmt.setString(11,client_ip_address);
						pstmt.setString(12,facility_id);

						pstmt.addBatch();
										
					}

				}
				nInsStat1 = pstmt.executeBatch();

				for(int n=0; n< nInsStat1.length;++n )
				{
					if(nInsStat1[n]<0  && nInsStat1[n] != -2)
					{
						insFlag = false;
						break;
					}
					else
					{ 
						insFlag = true;
					}
				}

				if(pstmt != null) pstmt.close();

				if(insFlag)
				{ 		
					con.commit();
					errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
					error_value = "1" ;

				}
				else
				{
					con.rollback();
					errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
					error_value = "0" ;

				}
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(errorMsg,"UTF-8") + "&err_value="+error_value);
		
		}
	}
		catch(Exception e )
		{
			
			e.printStackTrace();
			
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{
			
			if(con != null) ConnectionManager.returnConnection(con);
		
		}
	}

	public void updateQueryTemplate(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		java.util.Properties p;
		HttpSession session;
		session = request.getSession(false);

		String loginuserid = "";
		String client_ip_address = "";
		String facility_id = "";
		String locale="";

		p					= (java.util.Properties) session.getAttribute( "jdbc" ) ;
		facility_id			= (String) session.getAttribute( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		loginuserid		=(String) session.getAttribute("login_user");
		locale = (String) p.getProperty("LOCALE");

		String query_id = "";
		String query_desc = "";
		String note_type = "";
		String bean_key = "";
		String eff_status = "";
		String sec_hdg_code = "";
		String comp_id = "";
		String srl_no = "";
		String prompt_id = "";
		String result_type = "";
		String error_value ="";
		String errorMsg =	"";
		Boolean insFlag = false;
		int [] nInsStat1		= null;

		query_id = request.getParameter("query_id")==null?"":request.getParameter("query_id");
		query_desc = request.getParameter("query_desc")==null?"":request.getParameter("query_desc");
		note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		eff_status = request.getParameter("eff_status")==null?"":request.getParameter("eff_status");


		PreparedStatement pstmt = null;

		ArrayList selectedList = new ArrayList();
		String strVal ="";
		StringTokenizer Tokens = null ;

		eCA.PatientBannerGroupLine queryTemplateBean = null;


		queryTemplateBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		selectedList = queryTemplateBean.returnList1();

		int listSize = selectedList.size();
		int nInsStat = 0;

		String upd_CaTempQryHdr=" update CA_TEMP_QRY_HDR set QUERY_DESC=?,EFF_STATUS=? where QUERY_REF = ? ";

		String del_CaTempQryDtl=" delete from CA_TEMP_QRY_DTL where QUERY_REF = ? ";

		String ins_CaTempQryDtl="INSERT INTO CA_TEMP_QRY_DTL ( QUERY_REF,SEC_HDG_CODE  ,COMP_ID,SRL_NO,PROMPT_ID ,RESULT_TYPE ,ADDED_BY_ID ,ADDED_DATE                 ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE              ,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";

		try
		{
			pstmt = con.prepareStatement(upd_CaTempQryHdr);

			pstmt.setString(1,query_desc);
			pstmt.setString(2,eff_status);
			pstmt.setString(3,query_id);
			
			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();
			
			if(nInsStat>0)
			{
				nInsStat=0;
				pstmt = con.prepareStatement(del_CaTempQryDtl);
				pstmt.setString(1,query_id);

				nInsStat = pstmt.executeUpdate();
				if(pstmt != null) pstmt.close();
		
				if(nInsStat>0)
				{

				pstmt = con.prepareStatement(ins_CaTempQryDtl);
				
				for(int k=0; k<listSize; k++)
				{
				
					strVal = (String)selectedList.get(k);
			
					Tokens = new StringTokenizer(strVal,"~");

					while(Tokens.hasMoreTokens())
					{

						sec_hdg_code =(String)Tokens.nextToken();
						comp_id =(String)Tokens.nextToken();
						srl_no =(String)Tokens.nextToken();
						prompt_id =(String)Tokens.nextToken();
						result_type =(String)Tokens.nextToken();

					
						pstmt.clearParameters();
						pstmt.setString(1,query_id);
						pstmt.setString(2,sec_hdg_code);
						pstmt.setString(3,comp_id);
						pstmt.setString(4,srl_no);
						pstmt.setString(5,prompt_id);
						pstmt.setString(6,result_type);
						pstmt.setString(7,loginuserid);
						pstmt.setString(8,client_ip_address);
						pstmt.setString(9,facility_id);
						pstmt.setString(10,loginuserid);
						pstmt.setString(11,client_ip_address);
						pstmt.setString(12,facility_id);

						pstmt.addBatch();
										
					}

				}

				nInsStat1 = pstmt.executeBatch();


				for(int n=0; n< nInsStat1.length;++n )
				{
					if(nInsStat1[n]<0  && nInsStat1[n] != -2)
					{
						insFlag = false;
						break;
					
					}
					else
					{ 
						insFlag = true;
			
					}
				}

				if(pstmt != null) pstmt.close();

				if(insFlag)
				{ 		
					con.commit();
					errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
					error_value = "1" ;

				}
				else
				{
					con.rollback();
					errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
					error_value = "0" ;

				}


				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(errorMsg,"UTF-8") + "&err_value="+error_value);
		
			}
		  }
		}
		catch(Exception e )
		{
			
			e.printStackTrace();
			
			try
			{
				con.rollback();
				
			}
			catch(Exception eee)
			{
				
				eee.printStackTrace();
			}

		}
		finally
		{
			
			if(con != null) ConnectionManager.returnConnection(con);
				
		}
	
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }
}
