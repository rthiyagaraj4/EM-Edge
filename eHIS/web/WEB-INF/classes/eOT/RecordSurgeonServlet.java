/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.lang.reflect.Method; 
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.InputSource;
import eOT.RecordSurgeon.RecordSurgeonHome;
import eOT.RecordSurgeon.RecordSurgeonRemote;
import eOT.Common.OTRepository;
import eCommon.Common.CommonBean;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.util.Iterator;
import eOR.OrderEntryBillingQueryBean;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class RecordSurgeonServlet extends javax.servlet.http.HttpServlet {
	
	
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added Against MMS Vulnerability Issue - Starts
        req= new XSSRequestWrapper(req);
        res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends


			Connection conn=null;
	
		PreparedStatement pstmt_doc_type=null;
		PreparedStatement pstmt_patclass_encid=null;
		PreparedStatement pstmt_mmitem=null;
		PreparedStatement pstmt_ord_phy_id=null;
		ResultSet rset=null;
		ResultSet rset_one=null;
		ResultSet rset_patclass_encid=null;
		ResultSet rset_mmitem=null;

		boolean result1=true;

		String doc_level = CommonBean.checkForNull(req.getParameter("doc_level"));
		String oper_num =  CommonBean.checkForNull(req.getParameter("oper_num"));
		String theatre_code = CommonBean.checkForNull(req.getParameter("theatre_code"));
		String doc_complete = CommonBean.checkForNull(req.getParameter("doc_complete"));
		String diagnosis_text  = CommonBean.checkForNull(req.getParameter("diagnosis_text"));
		String login_user = CommonBean.checkForNull(req.getParameter("slate_user_id"));
		String nursing_doc_comp_yn=CommonBean.checkForNull(req.getParameter("nursing_doc_comp_yn"));
		String surgeon_doc_comp_yn=CommonBean.checkForNull(req.getParameter("surgeon_doc_comp_yn"));
		//newly added for patient Billing on 29/08/2005
		String update_notes			= CommonBean.checkForNull(req.getParameter("update_notes")); //Added against PMG2023-MMS-CRF-0002
		String patient_id			= CommonBean.checkForNull(req.getParameter("patient_id")) ;
		String patient_class		= CommonBean.checkForNull(req.getParameter("patient_class")) ;
		String episode_type			= CommonBean.checkForNull(req.getParameter("episode_type")) ;
		String episode_id			= CommonBean.checkForNull(req.getParameter("episode_id")) ;
		String oper_date			= CommonBean.checkForNull(req.getParameter("oper_date")) ;
		String surgeon_code			= CommonBean.checkForNull(req.getParameter("surgeon_code")) ;
		String anaesthesia_code		= CommonBean.checkForNull(req.getParameter("anaesthesia_code")) ;//PMG2017-SS-CRF-0001-US002
		String visit_id				= CommonBean.checkForNull(req.getParameter("visit_id")) ;
		String order_id				= CommonBean.checkForNull(req.getParameter("order_id")) ;
		String oper_line_status				= CommonBean.checkForNull(req.getParameter("chk_status")) ;
		/* Newly added below flag by Sathish.K on 13-03-2009 for TransferTOOT Cases... to uncheck Billing after TransferTOOT from Recovery Room.*/
		String trfr_to_ot_flag		= CommonBean.checkForNull(req.getParameter("trfr_to_ot_flag")) ;
		String pros_implants_complete_flag		= CommonBean.checkForNull(req.getParameter("pros_implants_complete_flag")) ;
		String oper_proc_comp		= CommonBean.checkForNull(req.getParameter("oper_proc_comp")) ;
		String customerId				= CommonBean.checkForNull(req.getParameter("customerId")) ;//047397
		String checkInTime				= CommonBean.checkForNull(req.getParameter("checkInTime")) ;//047397

		HashMap sqlMap = new HashMap();
		String st_interface_flag= CommonBean.checkForNull(req.getParameter("st_interface_flag")) ;	
		PrintWriter out;
		HashMap hashElement=null;
		eOT.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOT.MasterXMLParse();
		//eOT.LogFile.log(logFile,"Parser constructed successfully", this);
		String client_ip_address="";
		String facility_id = "";
		String locale = "";
		String st_doc_type_rti= "";
		String st_doc_type_sli= "";
		String encounter_id= "";
		String sal_trn_type= "";
		String mm_item_code= "";
		String msgid= "";
		String err_text= "";
		String err_desc= "";

		java.util.Properties prop = null;
		facility_id = (String)session.getAttribute( "facility_id" ) ;
		prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		locale = prop.getProperty( "LOCALE" );
		//login_user = prop.getProperty( "login_user" );

//Newly added for addl Services by rajesh on 19/08/08
	String bl_bean_id = "Bl_BLAddlSurgeryReturnValuesBean" ;
	String bl_bean_name = "eBL.BLAddlSurgeryReturnValuesBean";

		HashMap hm1 =new HashMap();		
		eBL.BLAddlSurgeryReturnValuesBean beangetvalues = (eBL.BLAddlSurgeryReturnValuesBean) com.ehis.persist.PersistenceHelper.getBeanObject(bl_bean_id, bl_bean_name, req);
		hm1=beangetvalues.getAddSurgeryValues();		
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("oper_num",oper_num);
		CommonData.put("doc_level",doc_level);
		CommonData.put("theatre_code",theatre_code);
		CommonData.put("doc_complete",doc_complete);
		CommonData.put("diagnosis_text",diagnosis_text);
		CommonData.put("nursing_doc_comp_yn",nursing_doc_comp_yn);
		CommonData.put("surgeon_doc_comp_yn",surgeon_doc_comp_yn);
		//newly added on 22/08/2005 by subramanian for Billing procedure
		CommonData.put("update_notes",update_notes); //Added against PMG2023-MMS-CRF-0002
		CommonData.put("patient_id",patient_id);
		CommonData.put("patient_class",patient_class);
		CommonData.put("episode_id",episode_id);
		CommonData.put("episode_type",episode_type);
		CommonData.put("visit_id",visit_id);
		CommonData.put("oper_date",oper_date);
		CommonData.put("surgeon_code",surgeon_code);
		CommonData.put("anaesthesia_code",anaesthesia_code);//PMG2017-SS-CRF-0001-US002
		CommonData.put("order_id",order_id);
		CommonData.put("locale",locale);
		CommonData.put("bl_addl_serv",hm1);
		CommonData.put("trfr_to_ot_flag",trfr_to_ot_flag);
		CommonData.put("oper_line_status",oper_line_status);
		CommonData.put("pros_implants_complete_flag",pros_implants_complete_flag);
		CommonData.put("oper_proc_comp",oper_proc_comp);
		CommonData.put("st_interface_flag",st_interface_flag);
		CommonData.put("checkInTime", checkInTime);//047397
		CommonData.put("customerId", customerId);//047397
		
		//eOT.LogFile.log(logFile,"CommonData=="+CommonData,this);
		try{


/*
ArrayList arrList1=new ArrayList();
				hashElement=masterXMLParse.parseXMLData(null,xmlData,arrList1,eOT.MasterXMLParse.DETAIL_ONLY);	
				ArrayList tabData1 =(ArrayList) hashElement.get("SEARCH");
				HashMap map1 = null;
				if(tabData1!=null && tabData1.size()>0){
					for(Iterator itr = tabData1.iterator();itr.hasNext();){
					   map1 = (HashMap) itr.next();
						if(map1!=null && map1.size()>0){
							CommonData.put("AddlBlngSrv",map1);
						}
					}
				}
				//
*/

				conn = ConnectionManager.getConnection(req);

				String p_ord_practitioner_id="";
				String sql_phy_id="SELECT ORD_PRACT_ID from or_order where order_id='"+order_id+"'";
				pstmt_ord_phy_id=conn.prepareCall(sql_phy_id);
				rset_one=pstmt_ord_phy_id.executeQuery();
				if(rset_one !=null && rset_one.next())
				{
				p_ord_practitioner_id =rset_one.getString("ORD_PRACT_ID");
				if(p_ord_practitioner_id ==null) p_ord_practitioner_id="";
				
				}
				if(pstmt_ord_phy_id!=null)pstmt_ord_phy_id.close();
				if(rset_one!=null)rset_one.close();	

				ArrayList arrList=new ArrayList();
				InputSource inputSource=new InputSource(req.getReader());
				hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
				ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
				HashMap map = null;
				String key = "";
				String table_name = "";
				String strItemId="";
				String sale_document_no="";
				if(tabData!=null && tabData.size()>0){
					for(Iterator itr = tabData.iterator();itr.hasNext();){
					   map = (HashMap) itr.next();					   
						if(map!=null && map.size()>0){


					//	String reserved_qty =(String)map.get("reserved_qty");
						String quantity =(String)map.get("quantity");
						//String requested_qty =(String)map.get("requested_qty");
						String req_store_code =(String)map.get("req_store_code");
						String db_mode =(String)map.get("db_mode");						
						 sale_document_no =(String)map.get("sale_document_no");
					//	String sale_document_type =(String)map.get("sale_document_type");
						String frm_pick_list =(String)map.get("frm_pick_list");


				String bill_str =(String)map.get("bill_str");
				if(bill_str ==null) bill_str="";
						//String panel_str =(String)map.get("panel_str");
							key = (String) map.get("table_name")+"_"+(String) map.get("db_mode");							
							if(key.equals("OT_POST_OPER_DTLS_L"))
							{
								key="OT_POST_OPER_DTLS_U";
							}                             
							table_name = (String) map.get("table_name");
						if(table_name.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS" )|| table_name.equals("OT_SURGICAL_ACCESSORIES_PACKAGES"))
							{

							if(st_interface_flag.equals("Y"))
						{		
							if(pros_implants_complete_flag.equals("Y") )
						   {

								String overridden_excl_incl_ind="";
	        String action_reason_code="";
				if(!bill_str.equals("") )
							   {
			String[] charge_arr=null;
						charge_arr=bill_str.split("::");

						
						overridden_excl_incl_ind=charge_arr[5];
						action_reason_code =charge_arr[8]; 
							   }


if(overridden_excl_incl_ind.equals("null")) overridden_excl_incl_ind="";
if(action_reason_code.equals("null")) action_reason_code="";
		


						HashMap hm =new HashMap();	
						HashMap hmData =new HashMap();	
						HashMap hmHdrData =new HashMap();	
						HashMap alReqHdrData =new HashMap();	
						HashMap alDtlRecords =new HashMap();	
						ArrayList alReqHdrData1		= new ArrayList();
						ArrayList alDtlRecords1		= new ArrayList();
						String bean_id 				    = "ottransactionbean";
						String bean_name 			    = "eST.OTTransactionBean";


						if(!db_mode.equals("D"))
							   {
						eST.OTTransactionBean reqBean = (eST.OTTransactionBean) 
						com.ehis.persist.PersistenceHelper.getBeanObject(bean_id, bean_name, req);
						reqBean.setLanguageId(locale);	
						
									strItemId=(String)map.get("implant_code");
									
									String sql_doc_type="SELECT ST_DOC_TYPE_RTI,ST_DOC_TYPE_SLI  FROM ot_param_for_facility WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
									pstmt_doc_type=conn.prepareCall(sql_doc_type);
									rset=pstmt_doc_type.executeQuery();
									if(rset !=null && rset.next())
									{
										st_doc_type_rti =rset.getString("ST_DOC_TYPE_RTI");
										st_doc_type_sli=rset.getString("ST_DOC_TYPE_SLI");
									}
									if(pstmt_doc_type!=null)pstmt_doc_type.close();
									if(rset!=null)rset.close();


									String sql_patclass_encid="select PATIENT_CLASS ,ENCOUNTER_ID from OT_POST_OPER_HDR where OPER_NUM='"+oper_num+"' and OPERATING_FACILITY_ID='"+facility_id+"'";
									pstmt_patclass_encid=conn.prepareCall(sql_patclass_encid);
									rset_patclass_encid=pstmt_patclass_encid.executeQuery();

									if(rset_patclass_encid !=null && rset_patclass_encid.next())
									{
										patient_class =rset_patclass_encid.getString("PATIENT_CLASS");
										encounter_id=rset_patclass_encid.getString("ENCOUNTER_ID");
									}
										if(pstmt_patclass_encid!=null)pstmt_patclass_encid.close();
									if(rset_patclass_encid!=null)rset_patclass_encid.close();


									String sql_mmitem="SELECT MM_ITEM_CODE FROM OT_PROSTHESIS WHERE PROSTHESIS_CODE=?";
									pstmt_mmitem=conn.prepareCall(sql_mmitem);

									if(patient_class.equals("IP"))
									{
										sal_trn_type="I";
									}else if(patient_class.equals("OP"))
									{
									sal_trn_type="O";
									}else if(patient_class.equals("EM"))
									{
									sal_trn_type="E";
									}else if(patient_class.equals("DC"))
									{
									sal_trn_type="D";
									}else if(patient_class.equals("XT"))
									{
									sal_trn_type="R";
									}

									pstmt_mmitem.setString(1,strItemId);
									rset_mmitem=pstmt_mmitem.executeQuery();
							if(rset_mmitem !=null && rset_mmitem.next())
							{
								mm_item_code =rset_mmitem.getString("MM_ITEM_CODE");
							}
							if(pstmt_mmitem!=null)pstmt_mmitem.close();
							if(rset_mmitem!=null)rset_mmitem.close();

							 if(frm_pick_list.equals("Y"))  {
								hmHdrData.put("MODE","U");
							 }else
							  {
								hmHdrData.put("MODE","D");
								 }
								hmHdrData.put("SAL_DOC_TYPE_CODE",st_doc_type_sli);
								hmHdrData.put("REQUEST_BY_STORE",req_store_code);
								hmHdrData.put("PATIENT_ID",patient_id);
								hmHdrData.put("ENCOUNTER_ID",encounter_id);
								hmHdrData.put("SAL_TRN_TYPE",sal_trn_type);
								hmHdrData.put("DOC_CREATION_FOR","S");
								 if(frm_pick_list.equals("Y"))  {
								hmHdrData.put("SAL_DOC_NO",sale_document_no);
								 }
								 hmHdrData.put("P_ORD_PRACTITIONER_ID",p_ord_practitioner_id);
		

								alReqHdrData.put("REQ_DOC_TYPE_CODE",st_doc_type_rti);
								alReqHdrData.put("REQUEST_BY_STORE",req_store_code);
								alReqHdrData.put("REQUEST_ON_STORE","");
								alReqHdrData1.add(alReqHdrData);
								alDtlRecords.put("UOM_CODE","");
								alDtlRecords.put("RESERVE_QTY",quantity);
								alDtlRecords.put("ITEM_UNIT_COST","");
								alDtlRecords.put("ITEM_CODE", mm_item_code);
								alDtlRecords.put("REQUEST_QTY","");
								alDtlRecords.put("INCLUDE_EXCLUDE_YN",overridden_excl_incl_ind);
								alDtlRecords.put("OVERRIDE_REASON_CODE",action_reason_code);

								alDtlRecords1.add(alDtlRecords);

								hmData.put("REQ_HDR_DATA",alReqHdrData1);
								hmData.put("SAL_HDR_DATA",hmHdrData);
								hmData.put("DTL_DATA",alDtlRecords1);
							

								hm = reqBean.requestForOT(hmData,conn);

								  result1= ((Boolean) hm.get("result"));
								 err_text += CommonBean.checkForNull(((String) hm.get("msgid")));
							     err_text += CommonBean.checkForNull(((String) hm.get("message")));

								 msgid = CommonBean.checkForNull(((String) hm.get("msgid")));
								 		  if(hm.containsKey("doc_no")){
								 sale_document_no= CommonBean.checkForNull(((String)((ArrayList)hm.get("doc_no")).get(0)).toString());
								 }
map.put("sale_document_no",sale_document_no);
map.put("sale_document_type",st_doc_type_sli);

						
									
								if(result1 ==true)
								{
									conn.commit();
								}else
								{
									conn.rollback();
								}
							   }
					   }
							}
					   }
							sqlMap.put(key,OTRepository.getOTKeyValue( key ) );
						}
					}
				}
				
//tabData.get("Bill_Sub_Services_Dtl");
	if(result1 ==true)
			{
				boolean local_ejbs=isLocalEJB();
				//Lookup the Home Object using the Service locator pattern
				//Object home =com.medicom.ESLP.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_RECORD_SURGEON"),RecordSurgeonHome.class,local_ejbs);
				Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_RECORD_SURGEON"),RecordSurgeonHome.class,local_ejbs);
				//Get the remote object by invoking create method on the home object using reflection
				Object busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
				//Create an object array, which will be passed as argument to the method call
				Object argArray[]  = new Object[4];
					   argArray[0] = tabData;				   
					   argArray[1] = sqlMap;
					   argArray[2] = CommonData;
					   argArray[3] = prop;

				//Create a class array, containing the class types of the arguments passed
				Class [] paramArray	   = new Class[4];
						 paramArray[0] = tabData.getClass();
						 paramArray[1] = sqlMap.getClass();
						 paramArray[2] = CommonData.getClass();
						 paramArray[3] = prop.getClass();

				//Invoke the business method on the EJB using the argument array, class	array and reflection
				String result =(String)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

				//Call to remove the EJB
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				//Nullify the class and the object arrays
				argArray = null;
				paramArray = null;

				//Now Clean up the containers passed to the EJB
				tabData.clear();
				sqlMap.clear();
				CommonData.clear();
					if(result.equals("RECORD_INSERTED"))
				{
					out.println(result);
					conn.commit();
				}else
				{
					out.println(result);
					conn.rollback();
				}
			}else
			{
				err_desc+=getMessag(msgid);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				conn.rollback();
				
				out.println(err_desc);
			}

			
		
		

		}catch(Exception e){
			e.printStackTrace();
			//eOT.LogFile.log(logFile,"Err Msg in RecordSurgeonServlet==="+ee.getMessage(),this);
			    System.err.println(" eOT Err Msg in RecordSurgeonServlet "+e.getMessage());
		}	finally
		{
	if(conn!=null)
			ConnectionManager.returnConnection(conn, req);
		}					
	}
	boolean isLocalEJB(){
        ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		return false;
	}

	public  String getMessag(String msgid){
		Connection con = null;
		StringBuilder sbr = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String err_desc = "";
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
		con = ConnectionManager.getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,msgid);
		rst = pstmt.executeQuery();
		while(rst.next()){
		err_desc=CommonBean.checkForNull(rst.getString(1));
		}
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println(" eOT Err Mesg in getMessage Function"+e);
		}finally{
		try{
		sbr.setLength(0);
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con); //Common-ICN-0052
		}catch(Exception e){e.printStackTrace();}
		}
		return err_desc;
   }
}

