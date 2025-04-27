package eMR;

import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public class HAADcolorcodeServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String facilityId;
	String login_user;
	String client_ip_address;
	String action ;
	Connection con				= null;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try{
			HttpSession httpsession = request.getSession(false);
			facilityId = (String)httpsession.getValue("facility_id");
			p = (Properties)httpsession.getValue("jdbc");
			client_ip_address = p.getProperty("client_ip_address");
			login_user = p.getProperty("login_user");
			action = request.getParameter("action")==null?"":request.getParameter("action");
			
			if (action.equals("ValidateTermCode")){
				ValidateTermCode(request,response);
			}else{
			setHAADColorCodeSetup(request,response);	
			 }
				
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void setHAADColorCodeSetup(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException{
		
		JSONObject json						= new JSONObject();
		
		try{
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			response.setContentType("application/json");
			
			String concatenatedString	= request.getParameter("IDANDCOLORCONCAT")==null?"":request.getParameter("IDANDCOLORCONCAT");
			String termSetLists			= request.getParameter("termSetLists")==null?"":request.getParameter("termSetLists");
			String haadId				= "";
			String colorCode			= "";
			String haadID				= "";
			String termSetId			= "";
			String termCode				= "";
			HashMap haadIdColorCode		 = new HashMap();

			int executableCount			= 0;
			int result					= 0;
			int executableCountDtls		= 0;
			int resultDtls				= 0;
			if(!concatenatedString.equals("")){
				String sql = "update MR_HAAD_DISEASE_HDR set COLOR_CODE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where DISEASE_ID=?";
				PreparedStatement prep =  con.prepareStatement(sql);
				
				StringTokenizer indtoken = new StringTokenizer(concatenatedString, "|");
				while (indtoken.hasMoreTokens()) {
					String inner_string = indtoken.nextToken();
					StringTokenizer stoken = new StringTokenizer(inner_string,"~");
					while(stoken.hasMoreTokens()) {
						haadId				= stoken.nextToken();
						colorCode			= stoken.nextToken();
						haadIdColorCode.put(haadId,colorCode);
					}
					int i=1;
					prep.setString(i++, colorCode);
					prep.setString(i++, login_user);
					prep.setString(i++, client_ip_address);
					prep.setString(i++, facilityId);
					prep.setString(i++, haadId);
					prep.addBatch();
					executableCount++;
				}
			
				if(executableCount >0){
					int[] no = prep.executeBatch();
					result	 = no.length;
				}
				prep.close();
			}

			String deleteSql			= "delete from MR_HAAD_DISEASE_DTLS";
			PreparedStatement prep1		= con.prepareStatement(deleteSql);
			int delResult = prep1.executeUpdate(deleteSql);
			prep1.close();

			
			String insertSql	= " insert into MR_HAAD_DISEASE_DTLS(DISEASE_ID,TERM_SET_ID,TERM_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			PreparedStatement prep2 =  con.prepareStatement(insertSql);

			
			if(!termSetLists.equals("")){
				StringTokenizer tsToken = new StringTokenizer(termSetLists, "~");
				while(tsToken.hasMoreTokens()){
					String tsTokenInner1 = tsToken.nextToken();
					StringTokenizer tsTokenInner2 = new StringTokenizer(tsTokenInner1,"###");
					while(tsTokenInner2.hasMoreTokens()){
						String tIDCode	= tsTokenInner2.nextToken();
						haadID			= tsTokenInner2.nextToken();
						colorCode		= (String) haadIdColorCode.get(haadID);
						StringTokenizer tsTokenInner3 = new StringTokenizer(tIDCode,"$$$");
						while(tsTokenInner3.hasMoreTokens()){
							termSetId	= tsTokenInner3.nextToken();
							termCode		= tsTokenInner3.nextToken();
						}
						int j=1;
						prep2.setString(j++, haadID);
						prep2.setString(j++, termSetId);
						prep2.setString(j++, termCode);
						prep2.setString(j++, login_user);
						prep2.setString(j++, client_ip_address);
						prep2.setString(j++, facilityId);
						prep2.setString(j++, login_user);
						prep2.setString(j++, client_ip_address);
						prep2.setString(j++, facilityId);
						prep2.addBatch();
						executableCountDtls++;
					}
				}
				if(executableCountDtls >0){
					int[] no1		= prep2.executeBatch();
					resultDtls		= no1.length;
				}
				prep2.close();
			}

			if(executableCount == result && executableCountDtls == resultDtls){ 
					con.commit();
					json.put("success","true");	
					json.put("error","");	
			
			}else{
					con.rollback();
					json.put("success","false");	
					json.put("error","error");
			}
			response.getWriter().write(json.toString());
		
		}catch ( Exception e ) {
	
			e.printStackTrace();
			json.put("error",e);
			try{
				con.rollback();
				response.setContentType("application/json");
				response.getWriter().write(json.toString());
			}catch( Exception e1 ) {
			}
		}finally{
			if(con != null)  ConnectionManager.returnConnection(con, request);
		}
	}
private void ValidateTermCode(HttpServletRequest request, HttpServletResponse response){
		
			con 				= ConnectionManager.getConnection(request);
			Statement stmt    	=null;
			ResultSet rs 		= null;
			int Count			= 0;
			JSONObject json		= new JSONObject();
		try{
			
			
			String code_set	= request.getParameter("code_set")==null?"":request.getParameter("code_set");
			String p_diag_code= request.getParameter("p_diag_code")==null?"":request.getParameter("p_diag_code");
			
			
			String  sql ="SELECT count(*) count FROM MR_D_"+code_set+"_lang_VW a where  a.TERM_CODE=upper('"+p_diag_code+"') and a.TERM_SET_ID = '"+code_set+"' and a.eff_status='E' and language_id='en' " ;
		
			stmt=con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null && rs.next()){
				Count = rs.getInt("count");
				System.out.println("Count=>"+Count);
			}
			json.put("Count",Count);
			response.getWriter().write(json.toString());
			
		}catch ( Exception ex ) {
			System.err.println("Exception in ValidateTermCode - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(con != null)  ConnectionManager.returnConnection(con, request);
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}

		}

	}
}