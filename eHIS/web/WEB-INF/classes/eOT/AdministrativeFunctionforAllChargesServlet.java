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
import eOT.AdministrativeFunction.AdministrativeFunctionforAllChargesHome;
import eOT.AdministrativeFunction.AdministrativeFunctionforAllChargesRemote;
import eOT.Common.OTRepository;
import eCommon.Common.CommonBean;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.util.Iterator;
import eST.OTTransactionBean;
import java.util.Properties;
import webbeans.eCommon.ConnectionManager; 
import webbeans.eCommon.*;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import eCommon.XSSRequestWrapper;


//import oracle.aurora.jndi.sess_iiop.ServiceCtx;

public class AdministrativeFunctionforAllChargesServlet extends javax.servlet.http.HttpServlet {

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{



		Connection conn=null;
		//PreparedStatement pstmt=null;
		//PreparedStatement pstmt1=null;
		//PreparedStatement pstmt2=null;
		//PreparedStatement pstmt3=null;
		PreparedStatement pstmt_doc_type=null;
		PreparedStatement pstmt_patclass_encid=null;
		PreparedStatement pstmt_mmitem=null;
		PreparedStatement pstmt_ord_phy_id=null;
		ResultSet rset=null;
		ResultSet rset_one=null;
		ResultSet rset_patclass_encid=null;
		ResultSet rset_mmitem=null;

		boolean result1=true;
		// Added By Shaiju for SRR20056-SCF-6083 
		boolean commit_flag=true;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		String doc_level = CommonBean.checkForNull(req.getParameter("doc_level"));
		String oper_num =  CommonBean.checkForNull(req.getParameter("oper_num"));
		String theatre_code = CommonBean.checkForNull(req.getParameter("theatre_code"));
		String doc_complete = CommonBean.checkForNull(req.getParameter("doc_complete"));
		String nursing_doc_comp_yn=CommonBean.checkForNull(req.getParameter("nursing_doc_comp_yn"));
		String surgeon_doc_comp_yn=CommonBean.checkForNull(req.getParameter("surgeon_doc_comp_yn"));
	
		//added by subramanian on 9/8/2005 for adding specimen details in checkout from recovery
		String called_from=CommonBean.checkForNull(req.getParameter("recovery_in_out_flag"));
		String surgeon_code=CommonBean.checkForNull(req.getParameter("surgeon_code"));
		String order_id=CommonBean.checkForNull(req.getParameter("order_id"));
		String oper_date=CommonBean.checkForNull(req.getParameter("oper_date"));
		String proc_chrg_cmp_yn=CommonBean.checkForNull(req.getParameter("proc_chrg_cmp_yn"));
		if(("").equals(proc_chrg_cmp_yn))proc_chrg_cmp_yn="N";
		String patient_id=CommonBean.checkForNull(req.getParameter("patient_id"));
		String doc_compl_rec_yn=CommonBean.checkForNull(req.getParameter("doc_compl_rec_yn"));
		String doc_compl_or_yn=CommonBean.checkForNull(req.getParameter("doc_compl_or_yn"));
		String doc_compl_ha_yn=CommonBean.checkForNull(req.getParameter("doc_compl_ha_yn"));
		String oper_compl_yn=CommonBean.checkForNull(req.getParameter("oper_compl_yn"));
		if(("").equals(oper_compl_yn))oper_compl_yn="N";
		String pros_implants_yn=CommonBean.checkForNull(req.getParameter("pros_implants_yn"));
		String cons_packs_yn=CommonBean.checkForNull(req.getParameter("cons_packs_yn"));
		String equipments_yn=CommonBean.checkForNull(req.getParameter("equipments_yn"));
		String inst_cssd_yn=CommonBean.checkForNull(req.getParameter("inst_cssd_yn"));
		String st_interface_flag=CommonBean.checkForNull(req.getParameter("st_interface_flag"));
		String finalize_implants_in=CommonBean.checkForNull(req.getParameter("finalize_implants_in"));
		String finalize_equp_in=CommonBean.checkForNull(req.getParameter("finalize_equp_in"));
		String finalize_instr_in=CommonBean.checkForNull(req.getParameter("finalize_instr_in"));
		String finalize_packs_in=CommonBean.checkForNull(req.getParameter("finalize_packs_in"));
		String slate_user_id=CommonBean.checkForNull(req.getParameter("slate_user_id"));
		String rec_chargeable_yn=CommonBean.checkForNull(req.getParameter("rec_chargeable_yn"));
		String charge_recovery_room_yn=CommonBean.checkForNull(req.getParameter("charge_recovery_room_yn"));
		String rec_chrg_cmp_yn=CommonBean.checkForNull(req.getParameter("rec_chrg_cmp_yn"));
		String hld_chrg_cmp_yn=CommonBean.checkForNull(req.getParameter("hld_chrg_cmp_yn"));
		String or_chrg_cmp_yn=CommonBean.checkForNull(req.getParameter("or_chrg_cmp_yn"));
		String bill_flag=CommonBean.checkForNull(req.getParameter("bill_flag"));
		String or_chargeable_yn=CommonBean.checkForNull(req.getParameter("or_chargeable_yn"));
		String charge_operating_room_yn=CommonBean.checkForNull(req.getParameter("charge_operating_room_yn"));
		String charge_holding_area_yn=CommonBean.checkForNull(req.getParameter("charge_holding_area_yn"));
		String include_exclude1=CommonBean.checkForNull(req.getParameter("include_exclude1"));
		String include_exclude_or=CommonBean.checkForNull(req.getParameter("include_exclude_or"));
		String action_reason_code1=CommonBean.checkForNull(req.getParameter("action_reason_code1"));
		String action_reason_code_or=CommonBean.checkForNull(req.getParameter("action_reason_code_or"));
		String recv_bl_accession_num=CommonBean.checkForNull(req.getParameter("recv_bl_accession_num"));
		String rec_room_code=CommonBean.checkForNull(req.getParameter("rec_room_code"));
		String modified_charge_units=CommonBean.checkForNull(req.getParameter("modified_charge_units"));
		String serv_code=CommonBean.checkForNull(req.getParameter("serv_code"));
		//Oper Room
		String oper_room_code_or=CommonBean.checkForNull(req.getParameter("oper_room_code_or"));
		String serv_code_or=CommonBean.checkForNull(req.getParameter("serv_code_or"));
		String modified_charge_units_or=CommonBean.checkForNull(req.getParameter("modified_charge_units_or"));
		String or_bl_accession_num=CommonBean.checkForNull(req.getParameter("or_bl_accession_num"));
		String locale=CommonBean.checkForNull(req.getParameter("locale"));
		String final_val=CommonBean.checkForNull(req.getParameter("final_val"));
		String checkInTime = CommonBean.checkForNull(req.getParameter("checkInTime"));
		String customerId = CommonBean.checkForNull(req.getParameter("customerId"));

		/* Newly added below flag by Sathish.K on 13-03-2009 for TransferTOOT Cases... to uncheck Billing after TransferTOOT from Recovery Room.*/
		String trfr_to_ot_flag=CommonBean.checkForNull(req.getParameter("trfr_to_ot_flag"));
		HashMap sqlMap = new HashMap();
		PrintWriter out;
		HashMap hashElement=null;
		eOT.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		//String logFile="RecordServletDebugger";		
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOT.MasterXMLParse();
		
		String client_ip_address="";
		String login_user="";
		String facility_id = "";
		String st_doc_type_rti= "";
		String st_doc_type_sli= "";
		String patient_class= "";
		String encounter_id= "";
		String sal_trn_type= "";
		String mm_item_code= "";
		String msgid= "";
		String err_text= "";
		String err_desc= "";
		//String message_st= "";
	
		
		java.util.Properties prop = null;
		facility_id = (String)session.getAttribute( "facility_id" ) ;
		prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("oper_num",oper_num);
		CommonData.put("doc_level",doc_level);
		CommonData.put("theatre_code",theatre_code);
		CommonData.put("doc_complete",doc_complete);
		CommonData.put("nursing_doc_comp_yn",nursing_doc_comp_yn);
		CommonData.put("surgeon_doc_comp_yn",surgeon_doc_comp_yn);
		CommonData.put("called_from",called_from);
		CommonData.put("surgeon_code",surgeon_code);
		CommonData.put("order_id",order_id);
		CommonData.put("locale",locale);
		CommonData.put("trfr_to_ot_flag",trfr_to_ot_flag);
		CommonData.put("doc_compl_rec_yn",doc_compl_rec_yn);
		CommonData.put("doc_compl_or_yn",doc_compl_or_yn);
		CommonData.put("doc_compl_ha_yn",doc_compl_ha_yn);
		CommonData.put("pros_implants_yn",pros_implants_yn);
		CommonData.put("cons_packs_yn",cons_packs_yn);
		CommonData.put("equipments_yn",equipments_yn);
		CommonData.put("inst_cssd_yn",inst_cssd_yn);
		CommonData.put("recv_bl_accession_num",recv_bl_accession_num);
		CommonData.put("rec_room_code",rec_room_code);
		CommonData.put("modified_charge_units",modified_charge_units);
		CommonData.put("serv_code",serv_code);
		CommonData.put("patient_id",patient_id);
		CommonData.put("oper_room_code_or",oper_room_code_or);
		CommonData.put("serv_code_or",serv_code_or);
		CommonData.put("modified_charge_units_or",modified_charge_units_or);
		CommonData.put("or_bl_accession_num",or_bl_accession_num);
		CommonData.put("final_val",final_val);
		CommonData.put("st_interface_flag",st_interface_flag);
		CommonData.put("finalize_implants_in",finalize_implants_in);
		CommonData.put("finalize_equp_in",finalize_equp_in);
		CommonData.put("finalize_instr_in",finalize_instr_in);
		CommonData.put("finalize_packs_in",finalize_packs_in);
		CommonData.put("oper_date",oper_date);
		CommonData.put("proc_chrg_cmp_yn",proc_chrg_cmp_yn);
		CommonData.put("oper_compl_yn",oper_compl_yn);
		CommonData.put("slate_user_id",slate_user_id);
		CommonData.put("rec_chargeable_yn",rec_chargeable_yn);
		CommonData.put("charge_recovery_room_yn",charge_recovery_room_yn);
		CommonData.put("bill_flag",bill_flag);
		CommonData.put("or_chargeable_yn",or_chargeable_yn);
		CommonData.put("charge_operating_room_yn",charge_operating_room_yn);
		CommonData.put("charge_holding_area_yn",charge_holding_area_yn);
		CommonData.put("rec_chrg_cmp_yn",rec_chrg_cmp_yn);
		CommonData.put("hld_chrg_cmp_yn",hld_chrg_cmp_yn);
		CommonData.put("or_chrg_cmp_yn",or_chrg_cmp_yn);
		CommonData.put("include_exclude1",include_exclude1);
		CommonData.put("include_exclude_or",include_exclude_or);
		CommonData.put("action_reason_code1",action_reason_code1);
		CommonData.put("action_reason_code_or",action_reason_code_or);

		CommonData.put("checkInTime",checkInTime);
		CommonData.put("customerId",customerId);
		try{
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
				ArrayList arrList= new ArrayList();
				InputSource inputSource=new InputSource(req.getReader());
				hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
				ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
				//ArrayList tabData1 =(ArrayList) hashElement.get("HOLDING");

				HashMap map = null;
				String key = "";
				String table_name = "";
				String strItemId="";
				if(tabData!=null && tabData.size()>0){
					for(Iterator itr = tabData.iterator();itr.hasNext();){
					   map = (HashMap) itr.next();
					   if(map!=null && map.size()>0){

						//String reserved_qty =(String)map.get("reserved_qty");
						String quantity =(String)map.get("quantity");
						//String requested_qty =(String)map.get("requested_qty");
						String req_store_code =(String)map.get("req_store_code");
						String sale_document_no =(String)map.get("sale_document_no");
						//String sale_document_type =(String)map.get("sale_document_type");
						String frm_pick_list =(String)map.get("frm_pick_list");
						String bill_str =(String)map.get("bill_str");

						key = (String) map.get("table_name")+"_"+(String) map.get("db_mode");
						table_name = (String) map.get("table_name");
					
					if(table_name.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS" ))
					{
					 if(st_interface_flag.equals("Y"))
					  {	 	
						if(pros_implants_yn.equals("Y"))
						{
						String overridden_excl_incl_ind="";
						String action_reason_code="";
						String[] charge_arr=null;
						if(bill_str==null) bill_str="";
						if(!("").equals(bill_str))
						{
						charge_arr=bill_str.split("::");
                        overridden_excl_incl_ind=charge_arr[5];
						action_reason_code =charge_arr[8]; 
						}
			
						if(("null").equals(overridden_excl_incl_ind))  overridden_excl_incl_ind="";
						if(("null").equals(action_reason_code))        action_reason_code="";
						
						HashMap hm =new HashMap();	
						HashMap hmData =new HashMap();	
						HashMap hmHdrData =new HashMap();	
						HashMap alReqHdrData =new HashMap();	
						HashMap alDtlRecords =new HashMap();	
						ArrayList alReqHdrData1		= new ArrayList();
						ArrayList alDtlRecords1		= new ArrayList();
						//ArrayList sales_doc_num		= new ArrayList();
						String bean_id 				    = "ottransactionbean";
						String bean_name 			    = "eST.OTTransactionBean";
		              
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
												if(pstmt_doc_type!=null) pstmt_doc_type.close();
												if(rset!=null) rset.close();

									String sql_patclass_encid="SELECT  PATIENT_CLASS,ENCOUNTER_ID  FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"'";
									pstmt_patclass_encid=conn.prepareCall(sql_patclass_encid);
									rset_patclass_encid=pstmt_patclass_encid.executeQuery();
									
									if(rset_patclass_encid !=null && rset_patclass_encid.next())
									{
										patient_class =rset_patclass_encid.getString("PATIENT_CLASS");
										encounter_id=rset_patclass_encid.getString("ENCOUNTER_ID");
									}

									if(pstmt_patclass_encid!=null) pstmt_patclass_encid.close();
									if(rset_patclass_encid!=null) rset_patclass_encid.close();
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
								if(pstmt_mmitem!=null) pstmt_mmitem.close();
							 	if(rset_mmitem!=null) rset_mmitem.close();

                                if(frm_pick_list.equals("Y")){
								hmHdrData.put("MODE","U");
								}else
							    {   
								hmHdrData.put("MODE","D");
								}
								//hmHdrData.put("MODE","I");
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
								 err_text = err_text+CommonBean.checkForNull(((String) hm.get("msgid")));
							     err_text = err_text+CommonBean.checkForNull(((String) hm.get("message")));

								 msgid = CommonBean.checkForNull(((String) hm.get("msgid")));
								
								 if(hm.containsKey("doc_no")){
								 sale_document_no= CommonBean.checkForNull(((String)((ArrayList)hm.get("doc_no")).get(0)).toString());
								 }
                                 map.put("sale_document_no",sale_document_no);
                                 map.put("sale_document_type",st_doc_type_sli);
								
								// Added By Shaiju for SRR20056-SCF-6083 starts
								if(result1 == false )
			                     {
									commit_flag = false; 
									break;
								 }
								 
								/* 
								 if(result1 == true)
			                     {
									 conn.commit();
								 }
								 else
							     {  
									conn.rollback();
							     }

								 */
								 // Added By Shaiju for SRR20056-SCF-6083 ends
					     }
						}//st_interface_flag
					   }
						sqlMap.put(key,OTRepository.getOTKeyValue( key ) );
					   }
					}
					// Added By Shaiju for SRR20056-SCF-6083 Starts
					// Commented SKR-SCF-0788 // 10/24/2013
					if(commit_flag == true)
			         {
						 conn.commit();
					 }
					 else
					 {  
						conn.rollback();
					 }
					 // Commented SKR-SCF-0788 // 10/24/2013
					
					 // Added By Shaiju for SRR20056-SCF-6083 ends
					
				}
				//eOT.LogFile.log(logFile,"TabData=="+tabData,this);
				//getting EJB Home Context	
				


			if(result1 ==true)
			{
				boolean local_ejbs=isLocalEJB();
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_ADMIN_FUNCTION"),AdministrativeFunctionforAllChargesHome.class,local_ejbs);
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

			System.err.println("result  "+result);

			//Call to remove the EJB
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			//Nullify the class and the object arrays
			argArray = null;
			paramArray = null;
			//Now Clean up the containers passed to the EJB
			tabData.clear();
		    if(result.equals("SUCCESS"))
			{
			out.println(result);
			conn.commit();
			}
			else
			{
            System.err.println("result 440 "+result);
			out.println(result);
			conn.rollback();
			}

			}else
			{
				err_desc+=getMessag(msgid);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
			//	con.rollback();
				
			out.println(err_desc);
			}
		}catch(Exception ee){	
			 ee.printStackTrace();
		}finally{
			 try{
			if(conn!=null) ConnectionManager.returnConnection(conn,req);
			if(pstmt_doc_type!=null) pstmt_doc_type.close();
			if(pstmt_patclass_encid!=null) pstmt_patclass_encid.close();
			if(pstmt_mmitem!=null) pstmt_mmitem.close();
			if(pstmt_ord_phy_id!=null) pstmt_ord_phy_id.close();
			if(rset_one!=null) rset_one.close();
			if(rset!=null) rset.close();
			if(rset_patclass_encid!=null) rset_patclass_encid.close();
			if(rset_mmitem!=null) rset_mmitem.close();
			sqlMap.clear();
			hashElement.clear();
			}catch(Exception es){es.printStackTrace();}
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
		//String err_mesg = "";
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
		con = ConnectionManager.getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,msgid);
		rst = pstmt.executeQuery();
		//int count=0;
		while(rst.next()){
		err_desc=CommonBean.checkForNull(rst.getString(1));
		}
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println("Err Mesg in getMessage Function"+e);
		}finally{
		try{
		sbr.setLength(0);
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		//con.close();
		if(con!=null) ConnectionManager.returnConnection(con); //Common-ICN-0052
		}catch(Exception e){e.printStackTrace();}
		}
		return err_desc;
   }
}
