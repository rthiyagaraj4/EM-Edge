/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.xml.sax.InputSource;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;


public class PeriodontalChartServlet extends javax.servlet.http.HttpServlet{
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		java.util.Properties prop = null;
		eOH.MasterXMLParse masterXMLParse=new eOH.MasterXMLParse();

		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst=null;
		ResultSet rst1=null;

		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		String locale="";

		HashMap CommonData=new HashMap();
		HashMap map=new HashMap();
		HashMap hashElement=null;
		
		String mode =req.getParameter("mode");  
		String chart_id="";
		String component_code="";
		String chart_desc="";
		String status="";
		String sequence_no="";
		String min_value="";
		String max_value="";
		String redif_value="";
		String selected_value="";
		String db_mode="";
		String dtl_db_mode="";
		String msgr="";

		int flag=0;
		int flag1=0;
		int flag2=0;

		//Common-ICN-0044
		ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
		ArrayList arrList = new ArrayList(1);
		try{
			//ArrayList arrList = new ArrayList(1);
			InputSource inputSource=new InputSource(req.getReader());
			hashElement = masterXMLParse.parseXMLData(inputSource,null,arrList,eOH.MasterXMLParse.DETAIL_ONLY);
			connection = ConnectionManager.getConnection(req);
			//ArrayList tabData =(ArrayList) hashElement.get("SEARCH");

			prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			login_user = prop.getProperty( "login_user" );
			client_ip_address = prop.getProperty( "client_ip_address" );
			facility_id = (String)session.getValue( "facility_id" ) ;
			locale = prop.getProperty("LOCALE");

			CommonData.put("login_user", login_user); 
			CommonData.put("login_at_ws_no",client_ip_address);
			CommonData.put("facility_id",facility_id);
			CommonData.put("locale",locale);

			if(mode.equals("insert")){
				if(tabData!=null && tabData.size()>0){
					map = (HashMap) tabData.get(0);
					chart_id = (String )  map.get("chart_id");
					component_code = (String )  map.get("component_code");
					chart_desc = (String )  map.get("chart_desc");
					chart_desc = java.net.URLDecoder.decode(chart_desc,"UTF-8");
					status = (String )  map.get("status");
					db_mode = (String )  map.get("db_mode");
					int result=0;

					String select="SELECT COUNT(*) FROM OH_PERIODONTAL_CHART_DEF_HDR WHERE CHART_CODE=?";
					pstmt = connection.prepareStatement(select) ;
					pstmt.setString(1,chart_id);
					rst1=pstmt.executeQuery();		
					while(rst1!=null && rst1.next()){
						result=Integer.parseInt(rst1.getString(1));

					}

					if(rst1!=null) rst1.close();
					if(pstmt!=null) pstmt.close();

					if(result==0){
						String sql_insert_hdr="INSERT INTO OH_PERIODONTAL_CHART_DEF_HDR(CHART_CODE, CHART_DESC, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
						pstmt = connection.prepareStatement(sql_insert_hdr) ;
						pstmt.setString(1,chart_id);
						pstmt.setString(2,chart_desc);
						pstmt.setString(3,status);
						pstmt.setString(4,(String) CommonData.get("login_user"));
						pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
						pstmt.setString(6,(String) CommonData.get("facility_id"));
						pstmt.setString(7,(String) CommonData.get("login_user"));
						pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
						pstmt.setString(9,(String) CommonData.get("facility_id"));
						flag = pstmt.executeUpdate();		

						if(!db_mode.equals("H")){
							for(int i = 0;i	 <tabData.size();i++){
								map = (HashMap) tabData.get(i);
								dtl_db_mode = (String )  map.get("db_mode");
								if(!dtl_db_mode.equals("H")){
									chart_id = (String )  map.get("chart_id");
									component_code = (String )  map.get("component_code");
									chart_desc = (String )  map.get("chart_desc");
									chart_desc = java.net.URLDecoder.decode(chart_desc,"UTF-8");
									status = (String )  map.get("status");
									sequence_no = (String )  map.get("sequence_no");
									min_value = (String )  map.get("min_value");
									max_value = (String )  map.get("max_value");
									redif_value = (String )  map.get("redif_value");
									selected_value = (String )  map.get("selected_value");

									//Changed by sathish for graph reqd yn removing....graph_reqd_yn = (String )  map.get("graph_reqd_yn");
					
									// Changed by Sathish on 18/01/08 for remvoing graph reqd field String sql_insert_dtl="INSERT INTO OH_PERIODONTAL_CHART_DEF_DTL(CHART_CODE, COMPONENT_CODE, SEQUENCE_NO, MIN_VALUE, MAX_VALUE, CUT_OFF, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ,GRAPH_REQD_YN)VALUES(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
									String sql_insert_dtl="INSERT INTO OH_PERIODONTAL_CHART_DEF_DTL(CHART_CODE, COMPONENT_CODE, SEQUENCE_NO, MIN_VALUE, MAX_VALUE, CUT_OFF, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID )VALUES(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

									pstmt1 = connection.prepareStatement(sql_insert_dtl) ;
									pstmt1.setString(1,chart_id);
									pstmt1.setString(2,component_code);
									pstmt1.setString(3,sequence_no);
									pstmt1.setString(4,min_value);
									pstmt1.setString(5,max_value);
									pstmt1.setString(6,redif_value);
									pstmt1.setString(7,(String) CommonData.get("login_user"));
									pstmt1.setString(8,(String) CommonData.get("login_at_ws_no"));
									pstmt1.setString(9,(String) CommonData.get("facility_id"));
									pstmt1.setString(10,(String) CommonData.get("login_user"));
									pstmt1.setString(11,(String) CommonData.get("login_at_ws_no"));
									pstmt1.setString(12,(String) CommonData.get("facility_id"));
									//Changed by Sathish on 18/01/08 for remvoing graph reqd field pstmt1.setString(13,graph_reqd_yn);
									flag1 = pstmt1.executeUpdate();		
									if(pstmt1!=null) pstmt1.close();
								}
							}
						}
						else{
							flag1=1;
						}
					}
					else{
						msgr="Record";
					}
				}
			} 
			else if(mode.equals("modify")){
				if(tabData!=null && tabData.size()>0){
					map = (HashMap) tabData.get(0);
					chart_id = (String )  map.get("chart_id");
					component_code = (String )  map.get("component_code");
					chart_desc = (String )  map.get("chart_desc");
					chart_desc = java.net.URLDecoder.decode(chart_desc,"UTF-8");
					status = (String )  map.get("status");
					db_mode = (String )  map.get("db_mode");
					String sql_update_hdr="UPDATE OH_PERIODONTAL_CHART_DEF_HDR SET CHART_DESC=?, EFF_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE CHART_CODE=?";

					pstmt = connection.prepareStatement(sql_update_hdr) ;
					pstmt.setString(1,chart_desc);
					pstmt.setString(2,status);
					pstmt.setString(3,(String) CommonData.get("login_user"));
					pstmt.setString(4,(String) CommonData.get("login_at_ws_no"));
					pstmt.setString(5,(String) CommonData.get("facility_id"));
					pstmt.setString(6,chart_id);
					flag = pstmt.executeUpdate();	
				
					if (!db_mode.equals("H")){
						for(int i = 0;i	<tabData.size();i++){            //// 292
							map = (HashMap) tabData.get(i);
							db_mode = (String )  map.get("db_mode");
							if(db_mode.equals("I")){
								map = (HashMap) tabData.get(i);
								chart_id = (String )  map.get("chart_id");
								component_code = (String )  map.get("component_code");
								chart_desc = (String )  map.get("chart_desc");
								chart_desc = java.net.URLDecoder.decode(chart_desc,"UTF-8");
								status = (String )  map.get("status");
								sequence_no = (String )  map.get("sequence_no");
								min_value = (String )  map.get("min_value");
								max_value = (String )  map.get("max_value");
								redif_value = (String )  map.get("redif_value");
								selected_value = (String )  map.get("selected_value");
						
						
								//Changed by Sathish on 18/01/08 for remvoing graph reqd field graph_reqd_yn = (String )  map.get("graph_reqd_yn");
							   
								//Changed by Sathish on 18/01/08 for remvoing graph reqd field String sql_insert_dtl="INSERT INTO OH_PERIODONTAL_CHART_DEF_DTL(CHART_CODE, COMPONENT_CODE, SEQUENCE_NO, MIN_VALUE, MAX_VALUE, CUT_OFF, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID , GRAPH_REQD_YN) VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
								String sql_insert_dtl="INSERT INTO OH_PERIODONTAL_CHART_DEF_DTL(CHART_CODE, COMPONENT_CODE, SEQUENCE_NO, MIN_VALUE, MAX_VALUE, CUT_OFF, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

								pstmt1 = connection.prepareStatement(sql_insert_dtl) ;
								pstmt1.setString(1,chart_id);
								pstmt1.setString(2,component_code);
								pstmt1.setString(3,sequence_no);
								pstmt1.setString(4,min_value);
								pstmt1.setString(5,max_value);
								pstmt1.setString(6,redif_value);
								pstmt1.setString(7,(String) CommonData.get("login_user"));
								pstmt1.setString(8,(String) CommonData.get("login_at_ws_no"));
								pstmt1.setString(9,(String) CommonData.get("facility_id"));
								pstmt1.setString(10,(String) CommonData.get("login_user"));
								pstmt1.setString(11,(String) CommonData.get("login_at_ws_no"));
								pstmt1.setString(12,(String) CommonData.get("facility_id"));
								//Changed by Sathish on 18/01/08 for remvoing graph reqd field pstmt1.setString(13,graph_reqd_yn);
								flag1 = pstmt1.executeUpdate();	
								if(pstmt1!=null) pstmt1.close();
							} 
							else if (db_mode.equals("M")){
								map = (HashMap) tabData.get(i);

								chart_id = (String )  map.get("chart_id");
								component_code = (String )  map.get("component_code");
								chart_desc = (String )  map.get("chart_desc");
								chart_desc = java.net.URLDecoder.decode(chart_desc,"UTF-8");
								status = (String )  map.get("status");
								sequence_no = (String )  map.get("sequence_no");
								min_value = (String )  map.get("min_value");
								max_value = (String )  map.get("max_value");
								redif_value = (String )  map.get("redif_value");
								selected_value = (String )  map.get("selected_value");
								
								//Added by Sridevi Joshi on 1/8/2010 for IN017778 
								pstmt1 = connection.prepareStatement("SELECT COUNT(*) FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE=? AND COMPONENT_CODE=?") ;
								pstmt1.setString(1,chart_id);
								pstmt1.setString(2,component_code);
								rst = pstmt1.executeQuery();		
								int result_count=0;
								if(rst!=null && rst.next()){
									result_count=Integer.parseInt(rst.getString(1));
								}

								if(result_count > 0){
									String sql_update_dtl="UPDATE OH_PERIODONTAL_CHART_DEF_DTL SET SEQUENCE_NO=?,MIN_VALUE=?, MAX_VALUE=?, CUT_OFF=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE CHART_CODE=? AND COMPONENT_CODE=?";

									pstmt1 = connection.prepareStatement(sql_update_dtl) ;
									pstmt1.setString(1,sequence_no);
									pstmt1.setString(2,min_value);
									pstmt1.setString(3,max_value);
									pstmt1.setString(4,redif_value);
									pstmt1.setString(5,(String) CommonData.get("login_user"));
									pstmt1.setString(6,(String) CommonData.get("login_at_ws_no"));
									pstmt1.setString(7,(String) CommonData.get("facility_id"));
									pstmt1.setString(8,chart_id);
									pstmt1.setString(9,component_code);
									flag1 = pstmt1.executeUpdate();	
								}else{//Added by Sridevi Joshi on 1/8/2010 for IN017778 
									pstmt1 = connection.prepareStatement("INSERT INTO OH_PERIODONTAL_CHART_DEF_DTL(CHART_CODE, COMPONENT_CODE, SEQUENCE_NO, MIN_VALUE, MAX_VALUE, CUT_OFF, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)") ;
									pstmt1.setString(1,chart_id);
									pstmt1.setString(2,component_code);
									pstmt1.setString(3,sequence_no);
									pstmt1.setString(4,min_value);
									pstmt1.setString(5,max_value);
									pstmt1.setString(6,redif_value);
									pstmt1.setString(7,(String) CommonData.get("login_user"));
									pstmt1.setString(8,(String) CommonData.get("login_at_ws_no"));
									pstmt1.setString(9,(String) CommonData.get("facility_id"));
									pstmt1.setString(10,(String) CommonData.get("login_user"));
									pstmt1.setString(11,(String) CommonData.get("login_at_ws_no"));
									pstmt1.setString(12,(String) CommonData.get("facility_id"));
									flag1 = pstmt1.executeUpdate();	
								}

								if(pstmt1!=null) pstmt1.close();
								if(rst!=null) rst.close();

								
								if(component_code.equals("PD") || component_code.equals("CEJ")){ //This block is to assign min and max values CAL based on PD and CEJ values Added by Sridevi Joshi on 1/6/2010 for IN017778

									pstmt1 = connection.prepareStatement("SELECT COUNT(*) FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE=? AND COMPONENT_CODE='CAL'") ;
									pstmt1.setString(1,chart_id);
									rst = pstmt1.executeQuery();		
									int result_CAL_count=0;
									if(rst!=null && rst.next()){
										result_CAL_count=Integer.parseInt(rst.getString(1));
									}

									if(result_CAL_count > 0){
										String insert_maxCAL_value = "";
										String insert_minCAL_value = "";
										String db_comp_code = "";
										String PD_CEJ_min_value = "";
										String PD_CEJ_max_value = "";

										if(component_code.equals("PD")){
											db_comp_code = "CEJ";
										}
										else if(component_code.equals("CEJ")){
											db_comp_code = "PD";
										}

										pstmt1 = connection.prepareStatement("SELECT MIN_VALUE, MAX_VALUE FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE=? AND COMPONENT_CODE=?") ;
										pstmt1.setString(1,chart_id);
										pstmt1.setString(2,db_comp_code);
										rst = pstmt1.executeQuery();		
										if(rst!=null && rst.next()){
											PD_CEJ_min_value=rst.getString("MIN_VALUE");
											PD_CEJ_max_value=rst.getString("MAX_VALUE");
										}

										//Added by Sridevi Joshi on 1/6/2010 for IN017778 
										if(component_code.equals("PD") && Integer.parseInt(PD_CEJ_max_value) >= Integer.parseInt(max_value)){
											insert_maxCAL_value = PD_CEJ_max_value;
										}
										else if(component_code.equals("PD") && Integer.parseInt(PD_CEJ_max_value) <= Integer.parseInt(max_value)){
											insert_maxCAL_value = max_value;
										}

										if(component_code.equals("PD") && Integer.parseInt(PD_CEJ_min_value) <= Integer.parseInt(min_value)){
											insert_minCAL_value = PD_CEJ_min_value;
										}
										else if(component_code.equals("PD") && Integer.parseInt(PD_CEJ_min_value) >= Integer.parseInt(min_value)){
											insert_minCAL_value = min_value;
										}

										if(component_code.equals("CEJ") && Integer.parseInt(PD_CEJ_max_value) >= Integer.parseInt(max_value)){
											insert_maxCAL_value = PD_CEJ_max_value;
										}
										else if(component_code.equals("CEJ") && Integer.parseInt(PD_CEJ_max_value) <= Integer.parseInt(max_value)){
											insert_maxCAL_value = max_value;
										}

										if(component_code.equals("CEJ") && Integer.parseInt(PD_CEJ_min_value) <= Integer.parseInt(min_value)){
											insert_minCAL_value = PD_CEJ_min_value;
										}
										else if(component_code.equals("CEJ") && Integer.parseInt(PD_CEJ_min_value) >= Integer.parseInt(min_value)){
											insert_minCAL_value = min_value;
										}

										if(pstmt1!=null) pstmt1.close();
										pstmt1 = connection.prepareStatement("UPDATE OH_PERIODONTAL_CHART_DEF_DTL SET MIN_VALUE=?, MAX_VALUE=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE CHART_CODE=? AND COMPONENT_CODE='CAL'") ;
										pstmt1.setString(1,insert_minCAL_value);
										pstmt1.setString(2,insert_maxCAL_value);
										pstmt1.setString(3,(String) CommonData.get("login_user"));
										pstmt1.setString(4,(String) CommonData.get("login_at_ws_no"));
										pstmt1.setString(5,(String) CommonData.get("facility_id"));
										pstmt1.setString(6,chart_id);
										flag2 = pstmt1.executeUpdate();	

										if(flag2 != 0){
											connection.commit();
										}
									}
								}
							} 
							else if (db_mode.equals("D")){
								map = (HashMap) tabData.get(i);
								chart_id = (String )  map.get("chart_id");
								component_code = (String )  map.get("component_code");
								chart_desc = (String )  map.get("chart_desc");
								chart_desc = java.net.URLDecoder.decode(chart_desc,"UTF-8");
								status = (String )  map.get("status");
								sequence_no = (String )  map.get("sequence_no");
								min_value = (String )  map.get("min_value");
								max_value = (String )  map.get("max_value");
								redif_value = (String )  map.get("redif_value");
								selected_value = (String )  map.get("selected_value");

								String sql_for_delete="SELECT COUNT(*) FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE=? AND COMPONENT_CODE=?";
								pstmt1 = connection.prepareStatement(sql_for_delete) ;
								pstmt1.setString(1,chart_id);
								pstmt1.setString(2,component_code);
								rst = pstmt1.executeQuery();		
								int result=0;
								if(rst!=null && rst.next()){
									result=Integer.parseInt(rst.getString(1));
								}

								if(result>0){
									String sql_delete_dtl="DELETE FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE=? AND COMPONENT_CODE=?";

									pstmt1 = connection.prepareStatement(sql_delete_dtl) ;
									pstmt1.setString(1,chart_id);
									pstmt1.setString(2,component_code);
									flag1 = pstmt1.executeUpdate();	

									if(flag1 != 0){//Added by Sridevi Joshi on 4/8/2010 for IN020529...If used deselect one component and selects the other with same sequence then to delete the record first and to insert next..
										connection.commit();
									}
									else{
										connection.rollback();
									}
								} 
								else{
									flag1=99;
								}
							}
						}  
					} 
					else{
						if(flag1!=99){
							flag1=1;
						}
					}
				}
			}

			MessageManager mm=new MessageManager();
			String msg = "";
			if(flag==1 && flag1==99 && msgr.equals("")){
				connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				out.println(msg);
				mesg.clear();	//Common-ICN-0044
			}else if (flag==0 && flag1==0 && msgr.equals("Record"))	{
				connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
				msg = ((String) mesg.get("message"));
				out.println(msg);
				mesg.clear();	//Common-ICN-0044
			} else if (flag==0  && msgr.equals(""))	{
				connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
				out.println(msg);
				mesg.clear();	//Common-ICN-0044
			} else{		
				connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				out.println(msg);
				mesg.clear();	//Common-ICN-0044
			}

		}catch(Exception e){
			try{
				System.err.println("Rollback performed, Err Msg in PERIODONTALCHARTservlet. "+e.getMessage());
				connection.rollback();
			}catch(Exception e_1){
				System.err.println("96: Caught Exception during rollback"+e_1);
			}
		}finally {
			try{
				//Common-ICN-0044
				CommonData.clear();	
				map.clear();	
				hashElement.clear();	
				arrList.clear();	
				tabData.clear();	
				//Common-ICN-0044
				 if(pstmt!=null) pstmt.close() ;
				 ConnectionManager.returnConnection( connection,req );
			}catch(Exception es){es.printStackTrace();}
		}
	}
}
