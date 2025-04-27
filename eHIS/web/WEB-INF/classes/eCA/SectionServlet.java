/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 
 /*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2017	IN061907	Krishna Gowtham J	26/02/2017	Ramesh G		ML-MMOH-CRF-0559
------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
//import oracle.sql.*;
import eCommon.SingleTabHandler.*;

public class SectionServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MMS-ME-SCF-0097
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			String operation = req.getParameter("mode");

			if ( operation.equals("insert") )   insert(req, res, out);
			if ( operation.equals("modify"))    modify(req, res, out);
			if ( operation.equals("insMulti"))  insertMultiRes(req, res, out);
			if ( operation.equals("delMulti"))  deleteMultiRes(req, res, out);


		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);
		}
		catch(Exception e)
		{
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String sec_hdg_code = "";
		String sec_hdg_desc ="";
		String content_type = "" ;
		String template_type = "" ;
		String result_linked_rec_type = "" ;
		String eff_status = "" ;
		String sec_hdr_meta_desc1="";
		String preserve_yn="";
		String include_filled_yn="";
		String image_linked_yn = "";
		String facilityId ;
		String client_ip_address ;
		String outputYN ="" ;
		String result_sel ="" ;
		String disp_ord ="" ;
		String res_auto_lnk =""; //IN061907

		HttpSession session;

		session = req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");

		try
		{
			content_type =req.getParameter("content_type1");
			template_type =req.getParameter("template_type");
			outputYN =req.getParameter("outputYN")==null?"N":req.getParameter("outputYN");
			result_sel =req.getParameter("result_sel")==null?"":req.getParameter("result_sel");
			disp_ord =req.getParameter("disp_ord")==null?"":req.getParameter("disp_ord");
			res_auto_lnk =req.getParameter("res_auto_lnk_yn")==null?"N":req.getParameter("res_auto_lnk_yn"); //IN061907 


			if(template_type==null || template_type.equals("null")){
				template_type="";
			}
			String strParseStatus = "";

			sec_hdg_code =req.getParameter("sec_hdg_code1");
			sec_hdg_desc =req.getParameter("sec_hdg_desc");

			if(sec_hdg_desc ==null )
				sec_hdg_desc =req.getParameter("sec_hdg_desc1");

			image_linked_yn = req.getParameter("image_linked_yn1");

			if(image_linked_yn ==null) image_linked_yn="N";

			sec_hdr_meta_desc1 =req.getParameter("sec_hdr_meta_desc1");

			if(sec_hdr_meta_desc1 ==null) sec_hdr_meta_desc1 ="";

			result_linked_rec_type = req.getParameter("result_linked_rec_type");

			if(result_linked_rec_type==null)
				result_linked_rec_type=req.getParameter("result_linked_rec_type1");

			eff_status = req.getParameter("eff_status");

			if ( eff_status == null )
				eff_status="D";

			preserve_yn = req.getParameter("preserve_format_yn1");

			if ( preserve_yn == null ||preserve_yn.equals("null"))
				preserve_yn="N";

			include_filled_yn = req.getParameter("include_filled_yn1");

			if ( include_filled_yn == null ||include_filled_yn.equals("null"))
				include_filled_yn="N";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();

			tabdata.put("sec_hdg_desc",sec_hdg_desc);
			tabdata.put("sec_hdr_meta_desc",sec_hdr_meta_desc1);
			tabdata.put("result_linked_rec_type",result_linked_rec_type);
			tabdata.put("eff_status",eff_status);
			tabdata.put("image_linked_yn", image_linked_yn);
			tabdata.put("PRESERVE_FORMAT_YN", preserve_yn);
			tabdata.put("INCLUDE_ONLY_FILLED_COLUMN_YN", include_filled_yn);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("OUTPUT_FORM_EXISTS_YN",outputYN );
			//tabdata.put("SELECTION_TYPE",result_sel);
			tabdata.put("DISPLAY_ORDER",disp_ord);
			tabdata.put("AUTO_RESULT_YN",res_auto_lnk); //IN061907

			HashMap condflds=new HashMap();
			condflds.put("sec_hdg_code",sec_hdg_code);

			boolean local_ejbs = false;
			String tabname="ca_section_hdg";

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

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			condflds.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
				error_value = "1" ;

				if(content_type.equals("T"))
				{
					Connection con = null;

					try
					{
							con = ConnectionManager.getConnection(req);

							PreparedStatement pstClean = null;
							int nClean =0;

							try
							{
								String strUpd = "Update CA_SECTION_HDG SET TEMPLATE_FORMAT = empty_clob() where SEC_HDG_CODE = ?";

								pstClean = con.prepareStatement(strUpd);
								pstClean.setString(1,sec_hdg_code);

								nClean = pstClean.executeUpdate();
							}
							catch (Exception eClean)
							{
								con.rollback();
								//out.println("Exception while Cleaning Template Format ! "+eClean.toString());//common-icn-0181
						       eClean.printStackTrace();//COMMON-ICN-0181
							}
							finally
							{
								if (pstClean != null)
									pstClean.close();
							}

							String Sql = "";
							PreparedStatement ptmtInsert1 = null;
							ResultSet rs1 = null;
							if(nClean > 0)
							{
								con.commit();

								Sql = "Select TEMPLATE_FORMAT from ca_section_hdg  where SEC_HDG_CODE = ? for update ";

								Clob clb = null;

								try
								{
									ptmtInsert1=con.prepareStatement(Sql);
									ptmtInsert1.setString(1, sec_hdg_code);

									rs1= ptmtInsert1.executeQuery() ;

									if(rs1!=null && rs1.next())
										clb = rs1.getClob(1);
								}
								catch (Exception eSelection)
								{
									con.rollback();
									//out.println("Exception while Cleaning Template Format ! "+eSelection.toString());//common-icn-0181
							     eSelection.printStackTrace();//COMMON-ICN-0181
								}
								finally
								{
									if (ptmtInsert1 != null)
										ptmtInsert1.close();
								}

								//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());

								BufferedWriter w = new BufferedWriter(clb.setCharacterStream(0));
								SectionTemplateXMLDefinitionBean objBean = new SectionTemplateXMLDefinitionBean();
								StringBuffer XMLString = null;
								if((template_type==null) || (template_type.equals("")) ||(template_type.equals("B"))){
								XMLString=objBean.constructXML(con, sec_hdg_code);
								}else{
								XMLString=objBean.constructTemplateTypeXML(con,sec_hdg_code);
								}
								objBean = null;
								String removeSplChar = XMLString.toString();

								w.write(removeSplChar, 0, removeSplChar.length());
								w.flush();
								w.close();
								rs1.close();
								ptmtInsert1.close();
								con.commit();

								CallableStatement csXMLParse = null;

								try
								{
									csXMLParse = con.prepareCall("{call CA_parse_SectionXMLTemplate(?,?)}");
									csXMLParse.setString(1,sec_hdg_code);
									csXMLParse.registerOutParameter(2,Types.VARCHAR);
									csXMLParse.execute();

									strParseStatus = csXMLParse.getString(2);

									if(strParseStatus.equals("N"))
										con.rollback();
									else
										con.commit();
								}
								catch (Exception eeeee)
								{
									con.rollback();
									//out.println("Exception while parsing SectionTemplate ! "+eeeee.toString());//common-icn-0181
								 eeeee.printStackTrace();//COMMON-ICN-0181
								}
								finally
								{
									if (csXMLParse != null)
										csXMLParse.close();
								}
							}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//out.println("Exception caught in the servelt-->" + e);//common-icn-0181
						
					}
					finally
					{
						if(con!=null)	ConnectionManager.returnConnection(con, req);
					}
				}


				if(content_type.equals("R"))
				{
					tabdata.put("sec_hdg_code",sec_hdg_code);
					tabdata.put("added_by_id", addedById);
					tabdata.put("added_at_ws_no", addedAtWorkstation);
					tabdata.put("added_facility_id", addedFacilityId);
					/* This method for new functionality. Add the records into the table if records not exists before.
				       Delete the records from the table if exists.*/
					insertSectionConfigFlds(tabdata, req, out);
					tabdata.clear();
				}

			}

	       	error = (String) results.get("error") ;
			results.clear();
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			out.println( sec_hdg_code+" "+sec_hdg_desc+" "+content_type+" "+template_type+" "+eff_status );
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String sec_hdg_code = "";
		String sec_hdg_desc ="";
		String content_type ="" ;
		String template_type ="" ;
		String result_linked_rec_type = "" ;
		String eff_status ="" ;
		String sec_hdr_meta_desc="";
		String preserve_yn="";
		String include_filled_yn="";
		String image_linked_yn = "";
		String facilityId ;
		String client_ip_address ;
		String outputYN ="" ;
		String result_sel ="" ;
		String disp_ord ="" ;
		String res_auto_lnk ="" ;//IN061907
		HttpSession session;
		session = req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");

		try
		{
			sec_hdg_code =req.getParameter("sec_hdg_code");
			sec_hdg_desc =req.getParameter("sec_hdg_desc");
			content_type =req.getParameter("content_type");
			template_type =req.getParameter("template_type");
			outputYN =req.getParameter("outputYN")==null?"N":req.getParameter("outputYN");
			result_sel =req.getParameter("result_sel")==null?"":req.getParameter("result_sel");
			disp_ord =req.getParameter("disp_ord")==null?"":req.getParameter("disp_ord");
			res_auto_lnk =req.getParameter("res_auto_lnk_yn")==null?"N":req.getParameter("res_auto_lnk_yn");//IN061907

			if(template_type==null || template_type.equals("null"))
				template_type="";

			if(content_type.equals("R") || content_type.equals("F"))
			{
				image_linked_yn =req.getParameter("image_linked_yn");

				if (image_linked_yn==null)
					image_linked_yn="N";
				else
				{
					if  (image_linked_yn.equals("on") || image_linked_yn.equals("Y") || image_linked_yn.equals("y"))
						image_linked_yn="Y";
					else
						image_linked_yn="N";
				}
				result_linked_rec_type =req.getParameter("result_linked_rec_type");

				if(result_linked_rec_type==null) result_linked_rec_type="";
				if (image_linked_yn==null) image_linked_yn="N";
			}
			else
			{
				if(content_type.equals("T") ){
				image_linked_yn = "N";
				}
				result_linked_rec_type = "";
			}

			sec_hdr_meta_desc =req.getParameter("sec_hdr_meta_desc");

			if(sec_hdr_meta_desc ==null ) sec_hdr_meta_desc ="";

			eff_status = req.getParameter("eff_status");

			if ( eff_status == null ||eff_status.equals("null"))
				eff_status="D";

			preserve_yn = req.getParameter("preserve_format_yn");


			if ( preserve_yn == null || preserve_yn.equals("null"))
			preserve_yn="N";

			include_filled_yn = req.getParameter("include_filled_yn");

			if ( include_filled_yn == null ||include_filled_yn.equals("null"))
			include_filled_yn="N";

			if(template_type.equals("H") || template_type.equals("F") || template_type.equals("R")){
				preserve_yn="Y";
				include_filled_yn="N";
			}
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();

			tabdata.put("sec_hdg_code",sec_hdg_code);
			tabdata.put("sec_hdg_desc",sec_hdg_desc);
			tabdata.put("sec_hdr_meta_desc",sec_hdr_meta_desc);
			tabdata.put("content_type",content_type);
			tabdata.put("result_linked_rec_type",result_linked_rec_type);
			tabdata.put("eff_status",eff_status);
			tabdata.put("image_linked_yn", image_linked_yn);
			tabdata.put("PRESERVE_FORMAT_YN", preserve_yn);
			tabdata.put("INCLUDE_ONLY_FILLED_COLUMN_YN", include_filled_yn);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("template_type",template_type);
			tabdata.put("OUTPUT_FORM_EXISTS_YN",outputYN);
			tabdata.put("SELECTION_TYPE",result_sel);
			tabdata.put("DISPLAY_ORDER",disp_ord);
			tabdata.put("AUTO_RESULT_YN",res_auto_lnk); //IN061907 



			String dupflds[]={"sec_hdg_code"};
			boolean local_ejbs = false;

			String tabname="ca_section_hdg";

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


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
				if(content_type.equals("R"))
				{
					/* This method for new functionality. Add the records into the table if records not exists before.
					   Delete the records from the table if exists.*/
					insertSectionConfigFlds(tabdata, req, out);
					tabdata.clear();
				}
				error_value = "1" ;
			}
			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());//common-icn-0181
			
			e.printStackTrace();
			out.println( "Values sent are : <br>" ) ;
			out.println( sec_hdg_code+"--"+sec_hdg_desc+"--"+content_type+"--"+template_type+"--"+result_linked_rec_type+"--"+eff_status  +"--" + image_linked_yn+"--");
		}
	}
	private void insertMultiRes(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{

		java.util.Properties p;
		String sec_hdg_code = "";
		String res_categ = "";
		String ord_type = "";
		String ord_catlog = "";
		String errorMsg = "";
		String error_value = "";
		String sStyle = "";
		int nInsStat=0;
		int count=0;

		String facilityId ;
		String client_ip_address ;

		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs =null;
		//PrintWriter out = null;

		HttpSession session;
		session = req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String locale = (String) p.getProperty("LOCALE");

		try
		{

			con = ConnectionManager.getConnection(req);
			out= res.getWriter();

			sec_hdg_code =req.getParameter("sec_hdg_code")==null?"":req.getParameter("sec_hdg_code");
			res_categ =req.getParameter("res_categ")==null?"":req.getParameter("res_categ");
			ord_type =req.getParameter("ord_type")==null?"ALL":req.getParameter("ord_type");
			if(res_categ.equals("DIAG"))
			{
				ord_catlog =req.getParameter("ord_catlog1")==null?"ALL":req.getParameter("ord_catlog1");
			}
			else
			{
				ord_catlog =req.getParameter("ord_catlog")==null?"ALL":req.getParameter("ord_catlog");
			}
			if(ord_catlog.equals(""))
			{
				ord_catlog ="ALL";
			}
			if(ord_type.equals(""))
			{
				ord_type ="ALL";
			}

		//	HashMap tabdata=new HashMap();


			String rec_exi_qry ="select 1 from CA_SECTION_RESULT_CAT d where d.SEC_HDG_CODE=? and d.RESULT_LINKED_REC_TYPE =? and d.MAIN_TYPE=? and d.SUB_TYPE =? ";

			pstmt1 =con.prepareStatement(rec_exi_qry);

			pstmt1.setString(1,sec_hdg_code);
			pstmt1.setString(2,res_categ);
			pstmt1.setString(3,ord_type);
			pstmt1.setString(4,ord_catlog);

			rs = pstmt1.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(rs != null) rs.close();
			if(pstmt1 != null) pstmt1.close();

			if(count>0)
			{
				errorMsg = getMessage(locale, "CODE_ALREADY_EXISTS","Common");
				sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

				out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>");
				out.println(errorMsg);
				return ;

			}

			String ins_qry = "insert into CA_SECTION_RESULT_CAT(SEC_HDG_CODE,RESULT_LINKED_REC_TYPE,MAIN_TYPE,SUB_TYPE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

			pstmt=con.prepareStatement(ins_qry);

			pstmt.setString(1,sec_hdg_code);
			pstmt.setString(2,res_categ);
			pstmt.setString(3,ord_type);
			pstmt.setString(4,ord_catlog);
			pstmt.setString(5,addedById);
			pstmt.setString(6,addedAtWorkstation);
			pstmt.setString(7,facilityId);
			pstmt.setString(8,modifiedById);
			pstmt.setString(9,modifiedAtWorkstation);
			pstmt.setString(10,modifiedFacilityId);

			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();

				if(nInsStat>0)
				{

					CallableStatement	csDocRef	=	null;
					csDocRef	=	con.prepareCall("{call CA_MAINTAIN_RESULT_EVENT(?,?,?,?,'I')}");

					csDocRef.setString(1,sec_hdg_code);
					csDocRef.setString(2,res_categ);
					csDocRef.setString(3,ord_type);
					csDocRef.setString(4,ord_catlog);
					csDocRef.execute();

					if(csDocRef!=null) csDocRef.close();

					con.commit();
					errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
					error_value = "1" ;
				}
				else
				{
					//con.rollback();
					errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
					error_value = "0" ;

				}

			/*

			tabdata.put("SEC_HDG_CODE",sec_hdg_code);//SEC_HDG_CODE
			tabdata.put("RESULT_LINKED_REC_TYPE",res_categ);
			tabdata.put("MAIN_TYPE",ord_type);
			tabdata.put("SUB_TYPE",ord_catlog);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);


			String dupflds[]={"sec_hdg_code"};
			boolean local_ejbs = false;

			String tabname="CA_SECTION_RESULT_CAT";

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

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			
			if ( inserted )
				error_value = "1" ;

			results.clear(); */
			sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			out.println("<script>parent.onSuccess1('"+sec_hdg_code+"');</script></BODY></html>");
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") +"&err_value="+error_value);




		}
		catch(Exception e)
		{

			//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());//common-icn-0181
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


	}//end of insertMultiRes

	//delete

	private void deleteMultiRes(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{

		java.util.Properties p;
		String sec_hdg_code = "";
		String reslnk_rec_type = "";
		String main_type = "";
		String sub_type = "";
		String errorMsg = "";
		String error_value = "";
		String sStyle = "";
		int nInsStat=0;

		String facilityId ;
		String client_ip_address ;

		Connection con = null;
		PreparedStatement pstmt = null;
		//PrintWriter out = null;

		HttpSession session;
		session = req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		/* String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ; */
		String locale = (String) p.getProperty("LOCALE");

		try
		{

			con = ConnectionManager.getConnection(req);
			out= res.getWriter();

			sec_hdg_code =req.getParameter("sec_hdg_code")==null?"":req.getParameter("sec_hdg_code");
			reslnk_rec_type =req.getParameter("reslnk_rec_type")==null?"":req.getParameter("reslnk_rec_type");
			main_type =req.getParameter("main_type")==null?"":req.getParameter("main_type");
			sub_type =req.getParameter("sub_type")==null?"":req.getParameter("sub_type");

			//HashMap tabdata=new HashMap();

			String del_qry = " delete from CA_SECTION_RESULT_CAT d where d.SEC_HDG_CODE= ? and d.RESULT_LINKED_REC_TYPE=? and d.MAIN_TYPE =? and d.SUB_TYPE = ? and d.ADDED_FACILITY_ID =?";

			pstmt=con.prepareStatement(del_qry);

			pstmt.setString(1,sec_hdg_code);
			pstmt.setString(2,reslnk_rec_type);
			pstmt.setString(3,main_type);
			pstmt.setString(4,sub_type);
			pstmt.setString(5,facilityId);

			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();

				if(nInsStat>0)
				{

					CallableStatement	csDocRef	=	null;
					csDocRef	=	con.prepareCall("{call CA_MAINTAIN_RESULT_EVENT(?,?,?,?,'D')}");

					csDocRef.setString(1,sec_hdg_code);
					csDocRef.setString(2,reslnk_rec_type);
					csDocRef.setString(3,main_type);
					csDocRef.setString(4,sub_type);
					//csDocRef.setString(5,"D");
					csDocRef.execute();

					if(csDocRef!=null) csDocRef.close();

					con.commit();
					errorMsg= getMessage(locale,"RECORD_DELETED","CA");
					error_value = "1" ;
				}
				else
				{
					//con.rollback();
					errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
					error_value = "0" ;

				}

			/*

			tabdata.put("SEC_HDG_CODE",sec_hdg_code);//SEC_HDG_CODE
			tabdata.put("RESULT_LINKED_REC_TYPE",res_categ);
			tabdata.put("MAIN_TYPE",ord_type);
			tabdata.put("SUB_TYPE",ord_catlog);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);
			

			String dupflds[]={"sec_hdg_code"};
			boolean local_ejbs = false;

			String tabname="CA_SECTION_RESULT_CAT";

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

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			
			if ( inserted )
				error_value = "1" ;

			results.clear(); */
			sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>");
			out.println(errorMsg);
			out.println("<script>parent.onSuccess1('"+sec_hdg_code+"');</script></BODY></html>");
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") +"&err_value="+error_value);




		}
		catch(Exception e)
		{

			//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());//common-icn-0181
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


	}//end of insertMultiRes


	//delete

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }


   private void insertSectionConfigFlds(HashMap<String, String> fldsData, HttpServletRequest req, PrintWriter out)
   {
   		HttpSession session = req.getSession(false);
		eCA.SectionConfigDispFldBean sectionBean = (eCA.SectionConfigDispFldBean)session.getAttribute("SectionConfigDispFldBean");
		String applicable = req.getParameter("applicable");
		String deleteSql ="DELETE CA_LINK_CATEG_SEC_DEF  WHERE SEC_HDG_CODE=?";
		String insertSql = "INSERT INTO CA_LINK_CATEG_SEC_DEF (SEC_HDG_CODE,RESULT_CATEGORY,RESULT_SUB_CATEGORY,FIELD_REF,ORDER_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			con = ConnectionManager.getConnection(req);

				if(applicable.equals("NA"))
			{
				pst = con.prepareStatement(deleteSql);
				pst.setString(1,fldsData.get("sec_hdg_code"));
				pst.executeUpdate();

				if(pst != null)
				{
					pst.close();
				}
				if(sectionBean != null)
				{
					sectionBean.clearBean();
				}
			}
			else if(applicable.equals("A"))
			{
				if(sectionBean != null)
				{
					HashMap<String, ArrayList<String>> data = sectionBean.getSelectedData();

					if(data != null)
					{
						Set<String> keys = data.keySet();
						pst = con.prepareStatement(deleteSql);
						pst.setString(1,fldsData.get("sec_hdg_code"));
						pst.executeUpdate();

						if(pst != null)
						{
							pst.close();
						}
						pst = con.prepareStatement(insertSql);

						for(String str : keys)
						{
							ArrayList<String> row = data.get(str);
							String result_category = row.get(0);
							String result_sub_category = row.get(1);
							String field_ref = row.get(2);
							String default_order_seq = row.get(3);

							pst.setString(1, fldsData.get("sec_hdg_code"));
							pst.setString(2,result_category);
							pst.setString(3,result_sub_category);
							pst.setString(4,field_ref);
							pst.setInt(5,Integer.parseInt(default_order_seq));
							pst.setString(6, fldsData.get("added_by_id"));
							pst.setString(7, fldsData.get("added_at_ws_no"));
							pst.setString(8, fldsData.get("added_facility_id"));
							pst.setString(9, fldsData.get("modified_by_id"));
							pst.setString(10, fldsData.get("modified_at_ws_no"));
							pst.setString(11, fldsData.get("modified_facility_id"));
							pst.executeUpdate();

						}

						if(pst != null)
						{
							pst.close();
						}
					}
					sectionBean.clearBean();
				}
			}
			con.commit();
		}
		catch (Exception e)
		{
			//out.println(" Exception raised ...  Error Received : "+e.toString());//common-icn-0181
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pst != null)
				{
					pst.close();
				}
				if(con != null)
				{
				   con.close();
				}
			}
			catch (SQLException se)
			{
				//out.println(" Exception raised ... Error Received : "+se.toString());//common-icn-0181
				
				se.printStackTrace();
			}
		}
   } // end of insertSectionConfigFlds
}
