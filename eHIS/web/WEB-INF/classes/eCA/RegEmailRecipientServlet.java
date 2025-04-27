/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import com.ehis.eslp.ServiceLocator;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.*;
import java.util.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Random;
import javax.servlet.*;
import javax.naming.*;
import javax.rmi.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class RegEmailRecipientServlet extends HttpServlet 
{
    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public  void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
		PrintWriter out = null;
		
		try
        {   req.setCharacterEncoding("UTF-8");
            res.setContentType("text/html; charset=UTF-8");
            out = res.getWriter();
            
			String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
            
			if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res, out);
            if(mode.trim().equalsIgnoreCase("update"))
                modify(req, res, out);
        }
        catch(Exception e)
        {
            out.println(e.toString());
            
			e.printStackTrace();
        }
		
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
		PrintWriter out = null;

		try
        {
			out = res.getWriter();
            doPost(req, res);
        }
        catch(Exception e)
        {
            out.println("Exception in invoking doPost Method");
            
			e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata= new HashMap();	
		String mailer_id="";
		String mailer_name="";
		String email_id="";
		String eff_status="D";
		String authoriseChkBox="N";
		String password="";
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		int count=0;
		HttpSession session;
        
		session		= req.getSession(false);
		p					= (Properties)session.getValue("jdbc");
	    facilityId			= (String) session.getValue("facility_id");
	    client_ip_address	= (String) p.getProperty("client_ip_address");
	    modifiedById		= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    addedById			= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		try
        {
			mailer_id=(req.getParameter("mailer_id")==null)?"":req.getParameter("mailer_id");
			mailer_name=(req.getParameter("mailer_name")==null)?"":req.getParameter("mailer_name");
			email_id=(req.getParameter("email_id")==null)?"":req.getParameter("email_id");
			eff_status=(req.getParameter("eff_status")==null)?"D":req.getParameter("eff_status");	
			authoriseChkBox=(req.getParameter("authoriseChkBox")==null)?"N":req.getParameter("authoriseChkBox");	

			tabdata.put("mailer_id" ,mailer_id);
			tabdata.put("mailer_name",mailer_name);
			tabdata.put("email_id",email_id);
			tabdata.put("AUTHORIZE_YN",authoriseChkBox);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			
			           
            String as[] = {"mailer_id"};
			
            boolean flag = false;
            String s = "SM_REGD_MAILING_LST";
if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
            flag = true;
            
			Object obj = ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler", eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            
			Object aobj[] = new Object[4];
			aobj[0] = p;
            aobj[1] = tabdata;
            aobj[2] = as;
            aobj[3] = s;
            
			Class aclass[] = new Class[4];
            aclass[0] = p.getClass();
            aclass[1] = tabdata.getClass();
            aclass[2] = as.getClass();
            aclass[3] = s.getClass();
            
			HashMap hashmap = (HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			
			tabdata.clear();
            boolean flag1 = ((Boolean)hashmap.get("status")).booleanValue();
            
			String error_Mesg = (String)hashmap.get("error");
            String error_value = "0";

			con = ConnectionManager.getConnection(req);

			if(authoriseChkBox.equals("Y"))
			{
				eCA.RegEmailRecipientBean CA_RegEmailRecipientBean= (eCA.RegEmailRecipientBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
				if((CA_RegEmailRecipientBean.getPassword()==null) || (CA_RegEmailRecipientBean.getPassword()).isEmpty()|| (CA_RegEmailRecipientBean.getPassword().size()==0)){
					password=CA_RegEmailRecipientBean.getNewPassword(mailer_id,"insert",con);
				}else{
					String[] tempStr=new String[4];
					tempStr=(String[])(CA_RegEmailRecipientBean.getPassword()).get(0);
					password=tempStr[3];
				}
			
				if(flag1)
				{
					pstmt = con.prepareStatement("insert into sm_regd_mail_user_pwd(MAILER_ID,SRL_NO,FROM_DATE, TO_DATE,password ,ADDED_BY_ID,  ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID , MODIFIED_DATE, MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID ) values(?,?,sysdate,null,app_password.encrypt(?),?,sysdate,?,?,?,sysdate,?,?)");		
					pstmt.setString(1,mailer_id);
					pstmt.setString(2,"1");				
					pstmt.setString(3,password);
					pstmt.setString(4,addedById);
					pstmt.setString(5,addedAtWorkstation);
					pstmt.setString(6,facilityId);
					pstmt.setString(7,addedById);
					pstmt.setString(8,addedAtWorkstation);
					pstmt.setString(9,facilityId);
					count = pstmt.executeUpdate();
					
					if(count > 0)
						flag1 = true;
					else{
						flag1 = false;	
						error_Mesg="Insert failed...";
						con.rollback();
					}
					if(pstmt !=null) pstmt.close();

				}
			}

			if(flag1){					
				error_value = "1";
				con.commit();			
			}else{
				error_value = "0";
				con.rollback();
			}
			hashmap.clear();
			
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error_Mesg,"UTF-8") + "&err_value=" + error_value);
        }
        catch(Exception e)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
            
			e.printStackTrace();
        }finally{
			if(con!=null)	ConnectionManager.returnConnection(con);	
		}
    }

	 private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
     {
		Properties p;
		HashMap tabdata= new HashMap();	
	
		String mailer_id="";
		String mailer_name="";
		String email_id="";
		String password="";
		String eff_status="D";
		String authoriseChkBox="N";
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmtDel=null;
		PreparedStatement pstmtSrlno=null;
		ResultSet rsSrlno=null;
		ArrayList passwordVals=new ArrayList();
		int srl_no=1;

		HttpSession session;
        
		session = req.getSession(false);
		
		p					= (Properties)session.getValue("jdbc");
		facilityId			= (String) session.getValue("facility_id");
	    client_ip_address	= (String) p.getProperty("client_ip_address");
	    modifiedById		= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    addedById			= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";

		try
        {
			mailer_id=(req.getParameter("mailer_id")==null)?"":req.getParameter("mailer_id");
			mailer_name=(req.getParameter("mailer_name")==null)?"":req.getParameter("mailer_name");
			email_id=(req.getParameter("email_id")==null)?"":req.getParameter("email_id");
			eff_status=(req.getParameter("eff_status")==null)?"D":req.getParameter("eff_status");			
			authoriseChkBox=(req.getParameter("authoriseChkBox")==null)?"N":req.getParameter("authoriseChkBox");	
			
			tabdata.put("MAILER_NAME",mailer_name);
			tabdata.put("EMAIL_ID",email_id);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("AUTHORIZE_YN",authoriseChkBox);
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
		

            HashMap hashmap = new HashMap();
            hashmap.put("mailer_id", mailer_id);
            boolean flag = false;
            String s = "SM_REGD_MAILING_LST";

            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
                flag = true;
            
			Object obj = ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler", eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            
			Object aobj[] = new Object[4];
            aobj[0] = p;
            aobj[1] = tabdata;
            aobj[2] = hashmap;
            aobj[3] = s;
            
			Class aclass[] = new Class[4];
            aclass[0] = p.getClass();
            aclass[1] = tabdata.getClass();
            aclass[2] = hashmap.getClass();
            aclass[3] = s.getClass();
            
			HashMap hashmap1 = (HashMap)obj1.getClass().getMethod("update", aclass).invoke(obj1, aobj);
            
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			hashmap.clear();
			tabdata.clear();
            
			boolean flag1 = ((Boolean)hashmap1.get("status")).booleanValue();
            
			String error_Mesg = (String)hashmap1.get("error");
            String error_value = "0";
/****************insert password details*************start*************************/
			
			con = ConnectionManager.getConnection(req);
			if(authoriseChkBox.equals("Y"))
			{
				if(flag1)
				{
					eCA.RegEmailRecipientBean CA_RegEmailRecipientBean= (eCA.RegEmailRecipientBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
					passwordVals=CA_RegEmailRecipientBean.getPassword();
					
					if(passwordVals !=null && !passwordVals.isEmpty() && passwordVals.size()>0){
						pstmtDel = con.prepareStatement("delete sm_regd_mail_user_pwd where MAILER_ID = ?");
						pstmtDel.setString(1,mailer_id);
						pstmtDel.executeUpdate();
						if(pstmtDel != null) pstmtDel.close();
						pstmt	= con.prepareStatement("insert into sm_regd_mail_user_pwd(MAILER_ID,SRL_NO,FROM_DATE, TO_DATE,password ,ADDED_BY_ID,  ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID , MODIFIED_DATE, MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID ) values(?,?,to_date(?,'DD/MM/YYYY HH24:MI'),to_date(?,'DD/MM/YYYY HH24:MI'),app_password.encrypt(?),?,sysdate,?,?,?,sysdate,?,?)");
						
						int count=0;
						for(int j=0;j<passwordVals.size();j++){
							String[] pwdVals=(String[])passwordVals.get(j);
							String locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");
							if (!locale.equals("en")){
								if (pwdVals[1]==null || pwdVals[1].equals(" ") || pwdVals[1].equals("null") ) 
								pwdVals[1]="";
								pwdVals[1] = com.ehis.util.DateUtils.convertDate(pwdVals[1],"DMYHM",locale,"en");
								if (pwdVals[2]==null || pwdVals[2].equals(" ") || pwdVals[2].equals("null")) 
								pwdVals[2]="";
								pwdVals[2] = com.ehis.util.DateUtils.convertDate(pwdVals[2],"DMYHM",locale,"en");

							}
							pstmt.setString(1,mailer_id);
							pstmt.setString(2,pwdVals[0]);				
							pstmt.setString(3,pwdVals[1]);				
							pstmt.setString(4,pwdVals[2]);				
							pstmt.setString(5,pwdVals[3]);
							pstmt.setString(6,addedById);
							pstmt.setString(7,addedAtWorkstation);
							pstmt.setString(8,facilityId);
							pstmt.setString(9,modifiedById);
							pstmt.setString(10,modifiedAtWorkstation);
							pstmt.setString(11,facilityId);
							count = pstmt.executeUpdate();
					
						}
						if(count > 0)
							flag1 = true;
						else{
							flag1 = false;	
							error_Mesg="update failed...";
							con.rollback();
						}
						if(pstmt !=null) pstmt.close();
				}
				else
				{	
					
					int count=0;
					CA_RegEmailRecipientBean= (eCA.RegEmailRecipientBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
					if((CA_RegEmailRecipientBean.getPassword()==null) || (CA_RegEmailRecipientBean.getPassword()).isEmpty()|| (CA_RegEmailRecipientBean.getPassword().size()==0))
					{
						password=CA_RegEmailRecipientBean.getNewPassword(mailer_id,"modify",con);
						
					}
					else
					{
						String[] tempStr=new String[4];
						tempStr=(String[])(CA_RegEmailRecipientBean.getPassword()).get(0);
						password=tempStr[3];
						
					}
			
					if(flag1)
					{
						pstmtSrlno = con.prepareStatement("select max(srl_no) srlno from sm_regd_mail_user_pwd where MAILER_ID = ?");
						pstmtSrlno.setString(1,mailer_id);
						rsSrlno=pstmtSrlno.executeQuery();
						if (rsSrlno != null )   // Only One Record
						{
							while(rsSrlno.next())
							{
								srl_no=Integer.parseInt(rsSrlno.getString("srlno")==null?"0":rsSrlno.getString("srlno"));
								srl_no=srl_no+1;
							}
						}
						
						if(pstmtSrlno != null) pstmtSrlno.close();
						if(srl_no==1)
						{
							pstmt = con.prepareStatement("insert into sm_regd_mail_user_pwd(MAILER_ID,SRL_NO,FROM_DATE, TO_DATE,password ,ADDED_BY_ID,  ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID , MODIFIED_DATE, MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID ) values(?,?,sysdate,null,app_password.encrypt(?),?,sysdate,?,?,?,sysdate,?,?)");		
							pstmt.setString(1,mailer_id);
							pstmt.setString(2,String.valueOf(srl_no));				
							pstmt.setString(3,password);
							pstmt.setString(4,addedById);
							pstmt.setString(5,addedAtWorkstation);
							pstmt.setString(6,facilityId);
							pstmt.setString(7,addedById);
							pstmt.setString(8,addedAtWorkstation);
							pstmt.setString(9,facilityId);
							count = pstmt.executeUpdate();
							
							if(count > 0)
								flag1 = true;
							else{
								flag1 = false;	
								error_Mesg="update for auth failed...";
								con.rollback();
							}
							if(pstmt !=null) pstmt.close();
						}
					}
				}// end of else
			} // end of if flag1
		}//end of if auth
/****************insert password details*************end*************************/

			if(flag1){
                error_value = "1";
				con.commit();
			}else{
				error_value="0";
				con.rollback();
			}

			
			hashmap1.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error_Mesg,"UTF-8") + "&err_value=" + error_value);
        }
        catch(Exception exception)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            
			exception.printStackTrace();
        }finally{
			
			if(con!=null)	ConnectionManager.returnConnection(con);	
		}
    }
}
