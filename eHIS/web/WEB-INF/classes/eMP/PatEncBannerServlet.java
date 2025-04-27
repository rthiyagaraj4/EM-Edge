/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class PatEncBannerServlet extends javax.servlet.http.HttpServlet 
{
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		PrintWriter out = null;

		try 
		{
			request.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out = res.getWriter();

			insertPatEncBanner(request, res, out);

		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.err);
			//out.println("Exception in try of doPost() of PatEncBannerServlet.java"+ e.toString());

		}
	}

	private void insertPatEncBanner(HttpServletRequest request,HttpServletResponse res, PrintWriter out)
	{
		Properties p;
		HttpSession session;

		String addedById = "";
		String addedFacilityId = "";
		String clientIpAddress = "";
		String error_value = "0";

		session = request.getSession(false);
		p = (java.util.Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		addedFacilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
		clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");

//		String bannerRef = request.getParameter("bannerRef") == null ? "" : request.getParameter("bannerRef");
		String bannerCateg = request.getParameter("bannerCateg") == null ? "" : request.getParameter("bannerCateg");
		String bannerType = request.getParameter("bannerType") == null ? "U" : request.getParameter("bannerType");
		String htmlContent = request.getParameter("htmlContent") == null ? "" : request.getParameter("htmlContent");
		String elementRef = "";
		String dispLength = "";
		String lineRef = "";
		String defSelYN= "Y";
		String dispOrder = "";
		String toolTipText = "";
		String dispText = "";
		String numOfSpaces = "";
		String iconYN = "";

		java.sql.Clob clobBnrContent = null;
		java.io.Writer bannerContentWriter =	null;
		java.io.BufferedWriter bannerContentBufferedWriter = null;


		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sqlDeleteDtltable = "delete MP_PAT_BANNER_DTL where BANNER_CATEG = ?";
		String sqlBannerDtlTable = "insert into MP_PAT_BANNER_DTL(BANNER_REF, ELMT_REF, BANNER_CATEG, DISPLAY_LENGTH, LINE_REF, DISP_ORD, TOOL_TIP_TEXT, PREFIX_LABEL_TEXT, NUM_OF_SPACES, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		String sqlBannerHdrTable = "insert into MP_PAT_BANNER_HDR(BANNER_REF, BANNER_TYPE, BANNER_CATEG, BANNER_CONTENT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,empty_clob(),?,sysdate,?,?,?,sysdate,?,?)";
		String sqlUpdateBnrHdr = "update MP_PAT_BANNER_HDR set  BANNER_CONTENT = empty_clob(), ADDED_BY_ID = ?, ADDED_DATE = sysdate, ADDED_AT_WS_NO = ?, ADDED_FACILITY_ID = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where BANNER_REF = ? and BANNER_TYPE = ? and BANNER_CATEG = ?";
		String sqlSelHdrRec = "select 1 from MP_PAT_BANNER_HDR where BANNER_REF = ? and BANNER_TYPE = ? and BANNER_CATEG = ?";

		int cnt = 0;

		try
		{
			con = ConnectionManager.getConnection(request);
			try
			{
				pstmt = con.prepareStatement(sqlDeleteDtltable);
				pstmt.setString(1,bannerCateg);
				pstmt.executeUpdate();

				if(pstmt != null) pstmt.close();

				PatientBannerGroupLine patBannerGrpBean = (PatientBannerGroupLine) com.ehis.persist.PersistenceHelper.getObjectFromBean("patBannerGrpBean","PatientBannerGroupLine",session);
				ArrayList list1 = new ArrayList();
				ArrayList list2 = new ArrayList();
				
				list1 = patBannerGrpBean.returnList1();
				list2 = patBannerGrpBean.returnList2();

				int list1Size = list1.size();
				int list2Size = list2.size();

				String listValues = "";
				StringTokenizer strTok = null;

				pstmt = con.prepareStatement(sqlBannerDtlTable);

				for(int i=0;i<list1Size;i++)
				{
					listValues = (String) list1.get(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						lineRef = strTok.nextToken();
						defSelYN = strTok.nextToken();
						dispOrder = strTok.nextToken();
						strTok.nextToken();
						strTok.nextToken();
						dispLength = strTok.nextToken();
						numOfSpaces = strTok.nextToken();
						dispText = strTok.nextToken();
						toolTipText = strTok.nextToken();
						strTok.nextToken();
						elementRef = strTok.nextToken();
						iconYN = strTok.nextToken();
						strTok.nextToken();
					}//end of while

					if(defSelYN.equals("Y") || defSelYN.equals("y") || defSelYN.equals("checked"))
					{
						pstmt.setString(1,"U01");
						pstmt.setString(2,elementRef);
						pstmt.setString(3,bannerCateg);
						if(iconYN.equals("Y")) dispLength = "3";
						pstmt.setString(4,dispLength);
						pstmt.setString(5,lineRef);
						pstmt.setString(6,dispOrder);
						pstmt.setString(7,toolTipText);
						pstmt.setString(8,dispText);
						pstmt.setString(9,numOfSpaces);
						pstmt.setString(10,addedById);
						pstmt.setString(11,clientIpAddress);
						pstmt.setString(12,addedFacilityId);
						pstmt.setString(13,addedById);
						pstmt.setString(14,clientIpAddress);
						pstmt.setString(15,addedFacilityId);

						cnt = pstmt.executeUpdate();
					}
				}//end of for
				
				for(int i=0;i<list2Size;i++)
				{
					listValues = (String) list2.get(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						lineRef = strTok.nextToken();
						defSelYN = strTok.nextToken();
						dispOrder = strTok.nextToken();
						strTok.nextToken();
						strTok.nextToken();
						dispLength = strTok.nextToken();
						numOfSpaces = strTok.nextToken();
						dispText = strTok.nextToken();
						toolTipText = strTok.nextToken();
						strTok.nextToken();
						elementRef = strTok.nextToken();
						iconYN = strTok.nextToken();
						strTok.nextToken();
					}//end of while

					if(defSelYN.equals("Y") || defSelYN.equals("y") || defSelYN.equals("checked"))
					{
						pstmt.setString(1,"U01");
						pstmt.setString(2,elementRef);
						pstmt.setString(3,bannerCateg);
						if(iconYN.equals("Y")) dispLength = "3";
						pstmt.setString(4,dispLength);
						pstmt.setString(5,lineRef);
						pstmt.setString(6,dispOrder);
						pstmt.setString(7,toolTipText);
						pstmt.setString(8,dispText);
						pstmt.setString(9,numOfSpaces);
						pstmt.setString(10,addedById);
						pstmt.setString(11,clientIpAddress);
						pstmt.setString(12,addedFacilityId);
						pstmt.setString(13,addedById);
						pstmt.setString(14,clientIpAddress);
						pstmt.setString(15,addedFacilityId);

						cnt = pstmt.executeUpdate();
					}
				}

				if(pstmt != null) pstmt.close();
			
				if(cnt > 0)
				{
					pstmt = con.prepareStatement(sqlSelHdrRec);
					pstmt.setString(1,"U01");
					pstmt.setString(2,bannerType);
					pstmt.setString(3,bannerCateg);
					rs = pstmt.executeQuery();
					String flag = "";
					while (rs.next())
					{
						flag = rs.getString("1");
					}//end of while
					
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					int insResult = 0;

					if(!flag.equals("1"))
					{
						pstmt = con.prepareStatement(sqlBannerHdrTable);
						pstmt.setString(1,"U01");
						pstmt.setString(2,bannerType);	
						pstmt.setString(3,bannerCateg);
						pstmt.setString(4,addedById);
						pstmt.setString(5,clientIpAddress);
						pstmt.setString(6,addedFacilityId);
						pstmt.setString(7,addedById);
						pstmt.setString(8,clientIpAddress);
						pstmt.setString(9,addedFacilityId);

						insResult = pstmt.executeUpdate();

						if(pstmt != null) pstmt.close();

						if(insResult > 0)
						{
							try
							{
								pstmt = con.prepareStatement("select BANNER_CONTENT from MP_PAT_BANNER_HDR where BANNER_REF = ? and BANNER_TYPE = ? and BANNER_CATEG = ? for update");
								pstmt.setString(1,"U01");
								pstmt.setString(2,bannerType);	
								pstmt.setString(3,bannerCateg);

								rs = pstmt.executeQuery();
						
								if(rs.next())
								{
									clobBnrContent	= (java.sql.Clob) rs.getClob("BANNER_CONTENT");
									bannerContentWriter	= ((java.sql.Clob)	clobBnrContent).setCharacterStream(0);
									bannerContentBufferedWriter = new java.io.BufferedWriter(bannerContentWriter);			bannerContentBufferedWriter.write(htmlContent.toString(),0,htmlContent.length());						
									bannerContentBufferedWriter.flush();	
									bannerContentBufferedWriter.close();
								}
								error_value = "1";
							}//end of try
							catch(Exception ee)
							{
								try
								{
									con.rollback();
								}
								catch(Exception eee)
								{
								}
								error_value = "0";
								
								//out.println("Exception in clob part of PatEncBannerServlet.java -"+ee.toString());
								ee.printStackTrace(System.err);
							}//end of catch
							finally
							{
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
							}//end of finally
						}//end of if
					}//end of if flag 
					else if(flag.equals("1"))
					{
						int updResult = 0;

						pstmt = con.prepareStatement(sqlUpdateBnrHdr);
						pstmt.setString(1,addedById);
						pstmt.setString(2,clientIpAddress);
						pstmt.setString(3,addedFacilityId);
						pstmt.setString(4,addedById);
						pstmt.setString(5,clientIpAddress);
						pstmt.setString(6,addedFacilityId);
						pstmt.setString(7,"U01");
						pstmt.setString(8,bannerType);
						pstmt.setString(9,bannerCateg);
						
						updResult = pstmt.executeUpdate();

						if(updResult > 0)
						{
							try
							{
								pstmt = con.prepareStatement("select BANNER_CONTENT from MP_PAT_BANNER_HDR where BANNER_REF = ? and BANNER_TYPE = ? and BANNER_CATEG = ? for update");
								pstmt.setString(1,"U01");
								pstmt.setString(2,bannerType);	
								pstmt.setString(3,bannerCateg);

								rs = pstmt.executeQuery();
						
								if(rs.next())
								{
									clobBnrContent	= (java.sql.Clob) rs.getObject("BANNER_CONTENT");
									bannerContentWriter	= ((java.sql.Clob)	clobBnrContent).setCharacterStream(0);
									bannerContentBufferedWriter = new java.io.BufferedWriter(bannerContentWriter);			bannerContentBufferedWriter.write(htmlContent.toString(),0,htmlContent.length());						bannerContentBufferedWriter.flush();	
									bannerContentBufferedWriter.close();
								}
							}//end of try
							catch(Exception ee)
							{
								try
								{
									con.rollback();
								}
								catch(Exception eee)
								{
								}
								
								//out.println("Exception in clob - update part of PatEncBannerServlet.java -"+ee.toString());
								ee.printStackTrace(System.err);
							}//end of catch
							finally
							{
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
							}//end of finally
						}
					}//end of else
					
					//Start Update the banner content in the application context 
					if(bannerCateg.equalsIgnoreCase("E")){
						getServletConfig().getServletContext().setAttribute("User_Banner_Encounter",htmlContent);
					}else if(bannerCateg.equalsIgnoreCase("P")){
						getServletConfig().getServletContext().setAttribute("User_Banner_Patient",htmlContent);
					}
					//End Update the banner content in the application context 
					
				}//end of if cnt > 0
				error_value = "1";
			}
			catch(Exception e2)
			{
				try
				{
					con.rollback();
				}
				catch(Exception eee)
				{
				}
				error_value = "0";
				
				//out.println("Exception at try 2 of PatEncBannerServlet.java -"+e2.toString());
				e2.printStackTrace(System.err);
			}
			
			if(error_value.equals("1"))
			{
				Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				String errorMsg= (String) tabdata.get("message");
				tabdata.clear();			
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
				con.commit();
			}
		}//end of try
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
			}
			
			//out.println("Exception at try of PatEncBannerServlet.java -"+e.toString());
			e.printStackTrace(System.err);
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con,request);	
		}
	}//end of method - insertPatEncBanner 
}//end of class - PatEncBannerServlet
