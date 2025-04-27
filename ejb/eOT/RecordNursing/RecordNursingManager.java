/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.RecordNursing;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import webbeans.eCommon.ConnectionManager;
import java.io.BufferedReader;
import java.io.Reader;
import eOT.Common.BillingManager;
import eOT.Common.BillingUtil;
//MO-CRF-20147.13 Starts
//import java.util.* ;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import oracle.sql.CLOB;
//import java.sql.* ;
import java.io.* ;
//MO-CRF-20147.13 Ends
/**
*
* @ejb.bean
*	name="RecordNursing"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecordNursing"
*	local-jndi-name="RecordNursing"
*	impl-class-name="eOT.RecordNursing.RecordNursingManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.RecordNursing.RecordNursingLocal"
*	remote-class="eOT.RecordNursing.RecordNursingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.RecordNursing.RecordNursingLocalHome"
*	remote-class="eOT.RecordNursing.RecordNursingHome"
*	generate= "local,remote"
*
*
*/

public class RecordNursingManager implements  SessionBean{
	HashMap stmt_hash = new HashMap();
	String transaction_err_msg="";
	//int result = 0;	//used for billing subregkeyline

	//call back methods overriden
	//public void ejbCreate() throws CreateException {}
	public void ejbCreate(){}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) {}

	/**
	 *Method to insert the data
	 *@param tabData
	 *@param sqlMap
	 *@param CommonData
	 *@param prop Connection Properties
	 *@return String holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public String insert(ArrayList tabData, HashMap sqlMap, HashMap CommonData, Properties prop)
	{
		Connection con = null;
		String nursing_doc_comp_yn=( String ) CommonData.get( "nursing_doc_comp_yn" );

		String trfr_to_ot_flag=( String ) CommonData.get( "trfr_to_ot_flag" );
		String called_from = ( String ) CommonData.get( "called_from" );
		//String function_id= ( String ) CommonData.get( "function_id" ); //Commented Against AAKH-ICN-0008
		String build_history_yn = (nursing_doc_comp_yn.equals("Y"))?"YES":"NO";
		String err_text ="";
		String facility_id = (String) CommonData.get("facility_id");
		boolean billing_installed_yn				= false; // For checking Billing enabled Flag
		boolean callBillingProcedure_success_flag	= false; // For checking billing transaction succesful_YN
		String executeTransactions_success_YN = "N"; // For checking transaction succesful_YN
		ArrayList result_array = new ArrayList(); // For checking billing transaction succesful_YN
		try
		{
			 con=ConnectionManager.getConnection(prop);
			// boolean transaction_flag = false;	//Commented Against AAKH-ICN-0008
			 createStatementCollection(con,sqlMap);
			 result_array = (ArrayList)executeTransactions(tabData,CommonData);
			 executeTransactions_success_YN = (String)result_array.get(0);

			 if(executeTransactions_success_YN.equals("Y")){
				tabData = (ArrayList)result_array.get(1);// tabData is modified in executeTransactions to get the key_line for each oper_code


			PreparedStatement pstmt1 = null;
			int j=0;

			String pros_implants_compyn=checkForNull(( String ) CommonData.get( "pros_implants_compyn" ));
			String cons_packs_compyn=checkForNull(( String ) CommonData.get( "cons_packs_compyn" ));
			String equip_compyn=checkForNull(( String ) CommonData.get( "equip_compyn" ));
			String instr_css_compyn=checkForNull(( String ) CommonData.get( "instr_css_compyn" ));
			//String facility_id=checkForNull(( String ) CommonData.get( "facility_id" ));
			String oper_no					=				( String )CommonData.get( "oper_num" );

			 if(called_from.equals("CHECK_OUT_RECO") ){
			 }else if(called_from.equals("CHECK_OUT_FROM_OR"))
			 {
			 }else
			 {

			String sql_update="UPDATE ot_post_oper_hdr SET IMPLANT_ENTRY_CMP_YN='"+pros_implants_compyn+"', CONSUMABLE_ENTRY_CMP_YN='"+cons_packs_compyn+"', EQUIPMENT_ENTRY_CMP_YN='"+equip_compyn+"', INSTRUMENT_ENTRY_CMP_YN='"+instr_css_compyn+"' WHERE operating_facility_id = '"+facility_id+"' AND oper_num  ='"+oper_no+"'";
			pstmt1 = con.prepareStatement(sql_update);
			j=pstmt1.executeUpdate();
			 con.commit();
		 }
			 billing_installed_yn = isBillingInstalled(facility_id);
			  /* Newly added below condition by Sathish.K on 13-03-2009 for TransferTOOT Cases...
			  to uncheck Billing after TransferTOOT from Recovery Room.*/

			 if(("Y").equals(trfr_to_ot_flag))
				 billing_installed_yn=false;
			 if( billing_installed_yn==true ){
				callBillingProcedure_success_flag = callBillingProcedure(tabData,CommonData);
				con.commit();
			 }

			 if((billing_installed_yn==true && callBillingProcedure_success_flag==true) || billing_installed_yn==false){
				if(build_history_yn.equals("YES") && !called_from.equals("CHECK_IN_RECO") ) {
					if(buildHistory(CommonData)==true){
						con.commit();
						err_text = updateDocumentationLevel(CommonData);
						/*if(err_text.equals("RECORD_INSERTED"))
							err_text = callSurgeonAvgTime(CommonData);*/
					}else{
						err_text = "Opertation Failed in History Builiding...";
					}
				}else if(!called_from.equals("CHECK_IN_RECO") ){
					con.commit();
					err_text = updateDocumentationLevel(CommonData);
					con.commit();
				}else
					err_text = "RECORD_INSERTED";

				if(err_text.equals("RECORD_INSERTED")){
					con.commit();
					if(build_history_yn=="YES"){
						String surg_avg_time_txt = callSurgeonAvgTime(CommonData) ;
						if( !surg_avg_time_txt.equals("RECORD_INSERTED")){
						}
					}
				}else{
					con.rollback();
				}
			 }else {
				con.rollback();
				err_text=transaction_err_msg;
			 }
		 }else {
			con.rollback();
			err_text=transaction_err_msg;
		 }
	}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("RecNursingManager: error in insert method::"+ee);
	}finally{
		try{
			closeAllStatement(stmt_hash);
			//if(con!=null) con.close();
			if(con!=null) ConnectionManager.returnConnection(con); //Common-ICN-0052
		}
		catch(Exception e){}
   }

	return err_text;
}

 public boolean isBillingInstalled(String facility_id){
	Connection con = null;
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean flag = false;
	try{
		con = ConnectionManager.getConnection();
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=con.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}
		else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();

   }finally{
		try{
			//if(rst!=null)rst.close();
			if(cstmt!=null)cstmt.close();
			//if(con!=null)con.close();
			ConnectionManager.returnConnection(con); //Common-ICN-0052
		}catch(Exception e){}

	}
	return flag;
 }

public void createStatementCollection(Connection con,HashMap sqlMap){
	try{
		  Set set=sqlMap.keySet();
		  Iterator itr=set.iterator();
		  PreparedStatement pstmt=null;
		  String key="";
		  while(itr.hasNext()){
			  key=(String) itr.next();
			  pstmt=con.prepareStatement((String) sqlMap.get(key));
			  stmt_hash.put(key,pstmt);
		  }
	 }catch(Exception ee){
			 ee.printStackTrace();
			System.err.println("RecNursingManager: Err createStatementCollection(EJB): "+ee);
			closeAllStatement(stmt_hash);
	 }
  }

public ArrayList executeTransactions(ArrayList tabData,HashMap CommonData){
	ArrayList result_array = new ArrayList();
	/* result_array will have the following
	 1. boolean flag true/false for transaction execution
	 2. modified tabData ArrayList. Modified to include the key_line field for surgical accessories
	*/
	PreparedStatement pstmt = null;

	HashMap hash=null;
	String key ="";
	String key_line="0";
	int keyNo =0;
	String strPrevKey	=	"";
	String nursing_doc_comp_yn=checkForNull(( String ) CommonData.get( "nursing_doc_comp_yn" ));
	String locale = (String)CommonData.get("locale");//048580
	System.err.println("===locale==nursing manager="+locale);

	int size=0;
	String success_flag_yn = "N"; // Initialize
	Connection con = null;
	PreparedStatement pstmt_chk = null;
	ResultSet rst = null;
	boolean flag_chk = true;
	try{

con = ConnectionManager.getConnection();


	 size = tabData.size();

	/* for(int i=0;i<size;i++){

		 hash=(HashMap) tabData.get(i);

		System.out.println("hash  "+hash);
	 }*/

	 for(int i=0;i<size;i++){
		 hash=(HashMap) tabData.get(i);
 		//System.out.println("hash  "+hash);

		 if(hash!=null){
			key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
//			System.err.println("key 3:" +key);

			if(key.equals("VISIT_PERSONNEL_I")||key.equals("OT_POST_OPER_DTL2_I") )
			{
				strPrevKey =  key;
				key="OT_POST_OPER_DTL2_I";
			}


			pstmt = (PreparedStatement) stmt_hash.get(key);
		 if(key.equals("OT_POST_OPER_SPECIMENS_I")){
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("specimen_dtls"));
			pstmt.setString(4,(String)hash.get("dept_code"));
			pstmt.setString(5,(String)hash.get("quantity"));
			pstmt.setString(6,(String)CommonData.get("login_user"));
			pstmt.setString(7,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(8,(String)CommonData.get("facility_id"));
			pstmt.setString(9,(String)CommonData.get("login_user"));
			pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(11,(String)CommonData.get("facility_id"));
		}else if(key.equals("OT_POST_OPER_SPECIMENS_U")){
//			System.err.println("*********304************");
			pstmt.setString(1,(String)hash.get("quantity"));
			pstmt.setString(2,(String)CommonData.get("login_user"));
			pstmt.setString(3,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(4,(String)CommonData.get("facility_id"));
			pstmt.setString(5,(String)hash.get("oper_num"));
			pstmt.setString(6,(String)CommonData.get("facility_id"));
			pstmt.setString(7,(String)hash.get("specimen_dtls"));
			pstmt.setString(8,(String)hash.get("dept_code"));
		}else if(key.equals("OT_POST_OPER_SPECIMENS_D")) {
//			System.err.println("*********314************");
			pstmt.setString(1,(String)hash.get("oper_num"));
			pstmt.setString(2,(String)CommonData.get("facility_id"));
			pstmt.setString(3,(String)hash.get("specimen_dtls"));
			pstmt.setString(4,(String)hash.get("dept_code"));
		}else if(key.equals("OT_POST_OPER_ORGAN_U")){
//			System.err.println("*********320************");
			pstmt.setString(1,(String)hash.get("disposal_code"));
			pstmt.setString(2,(String)hash.get("given_by"));
			pstmt.setString(3,(String)hash.get("received_by"));
			pstmt.setString(4,(String)CommonData.get("login_user"));
			pstmt.setString(5,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(6,(String)CommonData.get("facility_id"));
			pstmt.setString(7,(String)CommonData.get("facility_id"));
			pstmt.setString(8,(String)hash.get("oper_num"));
			pstmt.setString(9,(String)hash.get("anatomical_code"));
		}else if(key.equals("OT_POST_OPER_ORGAN_D")) {
//			System.err.println("*********331************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String)hash.get("oper_num"));
			pstmt.setString(3,(String)hash.get("anatomical_code"));
			pstmt.setString(4,(String)hash.get("disposal_code"));
		}else if(key.equals("OT_POST_OPER_ORGAN_I")){
//			System.err.println("*********337************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("anatomical_code"));
			pstmt.setString(4,(String)hash.get("disposal_code"));
			pstmt.setString(5,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(6,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(7,(String)CommonData.get("facility_id"));
			pstmt.setString(8,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(10,(String)CommonData.get("facility_id"));
			pstmt.setString(11,(String)hash.get("given_by"));
			pstmt.setString(12,(String)hash.get("received_by"));
		}else if(key.equals("OT_POST_OPER_PERSONNEL_I")){
//			System.err.println("*********351************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
			pstmt.setString(4,(String)hash.get("practitioner_id"));
			pstmt.setString(5,(String)hash.get("role_id"));
			pstmt.setString(6,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(7,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(8,(String)CommonData.get("facility_id"));
			pstmt.setString(9,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(11,(String)CommonData.get("facility_id"));
			pstmt.setString(12,(String)hash.get("role_type"));
		}else if(key.equals("OT_POST_OPER_PERSONNEL_D")){
//			System.err.println("*********365************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
			pstmt.setString(4,(String)hash.get("practitioner_id"));
			pstmt.setString(5,(String)hash.get("role_id"));
		}else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_I")){
//			System.err.println("*********372************");
			keyNo++;
			key_line = ""+(keyNo+getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type")));
			System.out.println("eOT keyLine instrument"+key_line);
			hash.put("key_line",key_line);
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("instr_code"));
			pstmt.setString(6,(String)hash.get("accessory_type"));
			//Added by Rajesh for CRF-0058 to decode location
			String trayNoVal = ((String)hash.get("tray_no"));
			if(!trayNoVal.equals("")){
				trayNoVal = java.net.URLDecoder.decode(trayNoVal,"UTF-8");
			}
			pstmt.setString(7,trayNoVal);
			//pstmt.setString(7,(String)hash.get("tray_no"));
			//Added by Rajesh for CRF-0058 to decode location
			//pstmt.setString(8,(String)hash.get("remarks"));
//			System.out.println("instr_code    I  "+hash.get("instr_code"));
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(8,remarksVal);

			//auditing fields
			pstmt.setString(9,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(11,(String)CommonData.get("facility_id"));
			pstmt.setString(12,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(13,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(14,(String)CommonData.get("facility_id"));
			//newly added by bala subramanian for billing related changes.
			pstmt.setString(15,"S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
			pstmt.setString(16,key_line);
			//newly added by Suma  for crf 677.
			pstmt.setString(17,(String)hash.get("quantity"));
		}else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_U")){
//			System.err.println("*********396************");
			//Added by Rajesh for CRF-0058 to decode location
			String trayNoVal = ((String)hash.get("tray_no"));
			if(!trayNoVal.equals("")){
				trayNoVal = java.net.URLDecoder.decode(trayNoVal,"UTF-8");
			}
			pstmt.setString(1,trayNoVal);
			//pstmt.setString(1,(String)hash.get("tray_no"));
			//Added by Rajesh for CRF-0058 to decode location
			//pstmt.setString(2,(String)hash.get("remarks"));
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(2,remarksVal);

			pstmt.setString(3,(String)hash.get("quantity"));
			//WHERE CONDITION
			pstmt.setString(4,(String)CommonData.get("facility_id"));
			pstmt.setString(5,(String) hash.get("oper_num"));
			pstmt.setString(6,(String) hash.get("oper_code"));
			pstmt.setString(7,(String) hash.get("oper_line_no"));
			pstmt.setString(8,(String) hash.get("instr_code"));

			//System.out.println("instr_code    U  "+hash.get("instr_code"));

		}else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_D")){
//			System.err.println("********407***********");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String) hash.get("instr_code"));

		}
		else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_I")){
	// Modified by DhanasekarV against issue IN026523 on 14/02/2011
			keyNo++;
			key_line =""+ (keyNo+getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type")));
		//	System.out.println("eOT keyLine equpiment"+key_line);
			hash.put("key_line",key_line);
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("equip_code"));
			pstmt.setString(6,(String)hash.get("accessory_type"));
			pstmt.setString(7,(String)hash.get("equip_id"));
			//pstmt.setString(8,(String)hash.get("remarks"));
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(8,remarksVal);

			//auditing fields
			pstmt.setString(9,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(11,(String)CommonData.get("facility_id"));
			pstmt.setString(12,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(13,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(14,(String)CommonData.get("facility_id"));
			pstmt.setString(15,"E"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
			pstmt.setString(16,key_line);
			pstmt.setString(17,(String)hash.get("quantity"));
			//048580
			if(locale != null && locale.equals("th"))
				pstmt.setString(18, com.ehis.util.DateUtils.convertDate((String)hash.get("desiredDate"),"DMYHM", locale, "en"));
			else
				pstmt.setString(18,(String)hash.get("desiredDate"));
			//048580
		}
		else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_U")){
			pstmt.setString(1,(String)hash.get("equip_id"));
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			pstmt.setString(2,remarksVal);
			pstmt.setString(3,(String)hash.get("quantity"));
			//WHERE CONDITION
			if(locale != null && locale.equals("th"))
				pstmt.setString(4, com.ehis.util.DateUtils.convertDate((String)hash.get("desiredDate"),"DMYHM", locale, "en"));
			else
				pstmt.setString(4,(String)hash.get("desiredDate"));
			pstmt.setString(5, (String) CommonData.get("facility_id"));
			pstmt.setString(6, (String) hash.get("oper_num"));
			pstmt.setString(7, (String) hash.get("oper_code"));
			pstmt.setString(8, (String) hash.get("oper_line_no"));
			pstmt.setString(9, (String) hash.get("equip_code"));
		}else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_D")){
//			System.err.println("*********449************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("equip_code"));
		} else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_I")){
//			System.err.println("*********456************");
	// Modified by DhanasekarV against issue IN026523 on 14/02/2011
				keyNo++;
			key_line = ""+(keyNo+getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type")));
			hash.put("key_line",key_line);
			//String quantity =(String)hash.get("quantity"); //Commented Against AAKH-ICN-0008
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("package_code"));
			pstmt.setString(6,(String)hash.get("accessory_type"));
			pstmt.setString(7,(String)hash.get("quantity"));
			//pstmt.setString(8,(String)hash.get("remarks"));
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(8,remarksVal);

			//auditing fields
			pstmt.setString(9,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(11,(String)CommonData.get("facility_id"));
			pstmt.setString(12,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(13,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(14,(String)CommonData.get("facility_id"));
			pstmt.setString(15,"C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
			pstmt.setString(16,key_line);


		}else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_U")){
//			System.err.println("*********500************");
			pstmt.setString(1,(String)hash.get("quantity"));
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(2,remarksVal);
			pstmt.setString(3,(String)CommonData.get("facility_id"));
			pstmt.setString(4,(String) hash.get("oper_num"));
			pstmt.setString(5,(String) hash.get("oper_code"));
			pstmt.setString(6,(String) hash.get("oper_line_no"));
			pstmt.setString(7,(String)hash.get("package_code"));
		}else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_D")){
//			System.err.println("*********514************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("package_code"));
		}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_I")){
//		    System.err.println("*********521************");
			String action_reason_code="";
			String excl_incl_ind="";
			String st_interface_flag=( String ) CommonData.get( "st_interface_flag" );


			String bill_str=(String) hash.get("bill_str");
			if(bill_str == null)bill_str="";
			if(!bill_str.equals("") )
			{
			//System.out.println("bill_str--->"+bill_str);
			String[] charge_arr=null;
			charge_arr=bill_str.split("::");
			//System.out.println("charge_arr--->"+charge_arr);
			if(charge_arr.length==6)
			 {
				 excl_incl_ind=charge_arr[5];
			 }
  			 if(charge_arr.length==9)
		     {
		         action_reason_code=charge_arr[8];
			 }
			}

			if(("null").equals(excl_incl_ind))
			{
				excl_incl_ind="";
			}
			if(("null").equals(action_reason_code))
			{
				action_reason_code="";
			}
				// Modified by DhanasekarV against issue IN026523 on 14/02/2011
			 keyNo++;
			key_line = ""+(keyNo+getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type")));
		//		System.out.println("eOT keyLine implant"+key_line);
			hash.put("key_line",key_line);
			hash.put("nursing_doc",nursing_doc_comp_yn);

			/* String reserved_qty =(String)hash.get("reserved_qty");
			String quantity =(String)hash.get("quantity"); `
			String requested_qty =(String)hash.get("requested_qty"); 
			String req_store_code =(String)hash.get("req_store_code");
			String sale_document_no =(String)hash.get("sale_document_no");
			String sale_document_type =(String)hash.get("sale_document_type"); */ //Commented Against AAKH-ICN-0008
			String batch=(String)hash.get("batch");
			if(batch ==null) batch="";
			String manufacturer=(String)hash.get("manufacturer");
			if(manufacturer ==null) manufacturer="";
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("implant_code"));
			pstmt.setString(6,(String)hash.get("accessory_type"));
			pstmt.setString(7,(String)hash.get("quantity"));
			pstmt.setString(8,manufacturer);
			pstmt.setString(9,batch);
			//pstmt.setString(10,(String)hash.get("remarks"));10/12/2010
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(10,remarksVal);



			//St values
			pstmt.setString(11,(String)hash.get("req_store_code"));
			pstmt.setString(12,(String)hash.get("reserved_qty"));
			pstmt.setString(13,(String)hash.get("requested_qty"));
			pstmt.setString(14,(String)hash.get("sale_document_type"));
			pstmt.setString(15,(String)CommonData.get("sale_document_no"));

			//auditing fields
			pstmt.setString(16,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(17,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(18,(String)CommonData.get("facility_id"));
			pstmt.setString(19,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(20,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(21,(String)CommonData.get("facility_id"));

						//pstmt.setString(22,"I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));

	/*Added by Suma for bill changes ion 26 feb 2010*/
	String st_bill_value=(String)hash.get("sale_document_type")+"-"+(String)hash.get("sale_document_no");

		if(st_interface_flag.equals("Y"))
		{
//			System.err.println("*********595************");
	pstmt.setString(22,st_bill_value);
		}else
		{
//			System.err.println("*********599************");
	pstmt.setString(22,"I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
		}
	/*ends here*/

/*Added by Suma for bill changes on 05/03/2010*/

if(st_interface_flag.equals("Y"))
		{
//	System.err.println("*********608************");
		pstmt.setString(23,"1");
		}else
		{
//			System.err.println("*********612************");
		pstmt.setString(23,key_line);
		}
/*Added by Suma ends here*/
			pstmt.setString(24,excl_incl_ind);
			pstmt.setString(25,action_reason_code);

		}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_U")){
//			System.err.println("*********620************");
           String st_interface_flag=( String ) CommonData.get( "st_interface_flag" );
		   	// Modified by DhanasekarV against issue IN026523 on 14/02/2011
			keyNo++;
		   key_line =""+(keyNo+getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type")));
		   String st_bill_value=(String)hash.get("sale_document_type")+"-"+(String)hash.get("sale_document_no");

	        String action_reason_code="";
			String excl_incl_ind="";

			String bill_str=(String) hash.get("bill_str");
			if(bill_str == null)bill_str="";
			if(!bill_str.equals("") )
			{
			//System.out.println("bill_str>>>>>>>>update  "+bill_str);
			String[] charge_arr=null;
			charge_arr=bill_str.split("::");
			//System.out.println("charge_arr>>>>>>>>update  "+charge_arr);

//Added on 10/26/2010 by AnithaJ
			 if(charge_arr.length==6)
			 {
				 excl_incl_ind=charge_arr[5];
			 }
    		 if(charge_arr.length==9)
		     {
		        action_reason_code=charge_arr[8];
			 }

			}

			if(("null").equals(excl_incl_ind))
			{
				excl_incl_ind="";
			}
			if(("null").equals(action_reason_code))
			{
				action_reason_code="";
			}
			String batch=(String)hash.get("batch");
			if(batch ==null) batch="";
			String manufacturer=(String)hash.get("manufacturer");
			if(manufacturer ==null) manufacturer="";


			pstmt.setString(1,(String)hash.get("quantity"));
			pstmt.setString(2,manufacturer);
			pstmt.setString(3,batch);
			//pstmt.setString(4,(String)hash.get("remarks"));10/12/2010
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(4,remarksVal);

			pstmt.setString(5,excl_incl_ind);
			pstmt.setString(6,action_reason_code);
			/* String reserved_qty =(String)hash.get("reserved_qty");	
			String requested_qty =(String)hash.get("requested_qty"); */		//Commented Against AAKH-ICN-0008
			//UPDATE OT_SURGICAL_ACCESSORIES SET ACCESSORY_CODE=?,QUANTITY=?,PROSTHESIS_MFR=?,PROSTHESIS_BATCH_NO=?,REMARKS=? WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND OPER_CODE=? AND OPER_LINE_NUM=? AND ACCESSORY_CODE=?"

			//oper_line_no=18, quantity=4, accessory_type=S, batch=89/22,
			/*table_name=OT_SURGICAL_ACCESSORIES_IMPLANTS, oper_code=20000,
			db_mode=U, oper_num=I050224010, remarks=REMARKS NEW UPTD,
			manufacturer=CARNER, implant_code=BIOP*/

			pstmt.setString(7,(String)hash.get("sale_document_type"));
			pstmt.setString(8,(String)hash.get("sale_document_no"));

			if(st_interface_flag.equals("Y"))
		    {
	        pstmt.setString(9,st_bill_value);
		    }else
		    {
	         pstmt.setString(9,"I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
		    }

			if(st_interface_flag.equals("Y"))
			{
			pstmt.setString(10,"1");
			}else
			{
			pstmt.setString(10,key_line);
			}
            pstmt.setString(11,(String)hash.get("req_store_code"));
			pstmt.setString(12,(String)hash.get("requested_qty"));

			pstmt.setString(13,(String)CommonData.get("facility_id"));
			pstmt.setString(14,(String) hash.get("oper_num"));
			pstmt.setString(15,(String) hash.get("oper_code"));
			pstmt.setString(16,(String) hash.get("oper_line_no"));
			pstmt.setString(17,(String)hash.get("implant_code"));
		}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_D")){
//			System.err.println("*********692************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("implant_code"));
		}
		else if(key.equals("OT_POST_OPER_DTL2_I"))
		{


//			System.err.println("*********700************");
			String remarks=(String) hash.get("visit_desc");
			if(remarks==null) remarks="";



			String visit_desc="";
			if(!remarks.equals(""))
			{
			visit_desc=java.net.URLDecoder.decode(remarks,"UTF-8");

			}

			String preparation_time=(String)hash.get("preparation_time");
			if(preparation_time==null) preparation_time="";

			if(preparation_time.equals(""))
			{
			preparation_time=preparation_time.trim();
			}



			String procedure_start_time=	(String)hash.get("procedure_start_time");
			if(procedure_start_time==null) procedure_start_time="";
			if(procedure_start_time.equals(""))
			{
			procedure_start_time=procedure_start_time.trim();
			}


			String procedure_end_time=	(String)hash.get("procedure_end_time");
			if(procedure_end_time==null) procedure_end_time="";
			if(procedure_end_time.equals(""))
			{
			procedure_end_time=procedure_end_time.trim();
			}


			String anaesthesia_start_time=	(String)hash.get("anaesthesia_start_time");
			if(anaesthesia_start_time==null) anaesthesia_start_time="";
			if(anaesthesia_start_time.equals(""))
			{
			anaesthesia_start_time=anaesthesia_start_time.trim();
			}

			String anaesthesia_end_time=	(String)hash.get("anaesthesia_end_time");
			if(anaesthesia_end_time==null) anaesthesia_end_time="";
			if(anaesthesia_end_time.equals(""))
			{
			anaesthesia_end_time=anaesthesia_end_time.trim();
			}

			String surgery_start_time=	(String)hash.get("surgery_start_time");
			if(surgery_start_time==null) surgery_start_time="";

			if(surgery_start_time.equals(""))
			{
			surgery_start_time=surgery_start_time.trim();
			}

			String surgery_end_time=	(String)hash.get("surgery_end_time");
			if(surgery_end_time==null) surgery_end_time="";

			if(surgery_end_time.equals(""))
			{
			surgery_end_time=surgery_end_time.trim();
			}

			//Added by Arthi for ML-MMOH-CRF-1936
			String prep_start_time=	(String)hash.get("prep_start_time");
				if(prep_start_time==null) prep_start_time="";

			if(prep_start_time.equals(""))
			{
				prep_start_time=prep_start_time.trim();
			}

			String prep_end_time=	(String)hash.get("prep_end_time");
				if(prep_end_time==null) prep_end_time="";

			if(prep_end_time.equals(""))
			{
				prep_end_time=prep_end_time.trim();
			}
			//End ML-MMOH-CRF-1936


			int count_chk=0;

			String sql_chk="select count(*) from OT_POST_OPER_DTL2 where OPERATING_FACILITY_ID='"+(String)CommonData.get("facility_id")+"'and OPER_NUM='"+(String) hash.get("oper_num")+"' and SPECIALITY_CODE='"+(String) hash.get("speciality_code")+"'";

//			System.err.println("751");
			pstmt_chk=con.prepareStatement(sql_chk);
			rst=pstmt_chk.executeQuery();
//			System.err.println("754");

			if(rst !=null && rst.next())
			{
			count_chk=rst.getInt(1);
			}
//			System.err.println("760");
			//System.out.println("count_chk---------->"+count_chk);
			String sql_new = "";
			if(count_chk <=0)
			{
				//sql_new="INSERT INTO OT_POST_OPER_DTL2 (OPERATING_FACILITY_ID,OPER_NUM,SPECIALITY_CODE,PREPARATION_TIME,ANEST_PROC_START_TIME,ANEST_PROC_END_TIME,ANEST_START_TIME,ANEST_END_TIME,SURG_START_TIME,SURG_END_TIME, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VISITING_PERSONNEL,WOUND_TYPE) VALUES ('"+(String)CommonData.get("facility_id")+"','"+(String) hash.get("oper_num")+"','"+(String) hash.get("speciality_code")+"',TO_DATE('"+preparation_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+procedure_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+procedure_end_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+anaesthesia_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+anaesthesia_end_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+surgery_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+surgery_end_time+"','DD/MM/YYYY HH24:MI'),'"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+visit_desc+"','')";

				if(strPrevKey.equals("VISIT_PERSONNEL_I"))
				{
//					System.err.println("762");
					 sql_new="INSERT INTO OT_POST_OPER_DTL2 (OPERATING_FACILITY_ID,OPER_NUM,SPECIALITY_CODE,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VISITING_PERSONNEL,WOUND_TYPE) VALUES ('"+(String)CommonData.get("facility_id")+"','"+(String) hash.get("oper_num")+"','"+(String) hash.get("speciality_code")+"','"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+visit_desc+"','')";
				}
				else
				{
					 sql_new="INSERT INTO OT_POST_OPER_DTL2 (OPERATING_FACILITY_ID,OPER_NUM,SPECIALITY_CODE,PREPARATION_TIME,ANEST_PROC_START_TIME,ANEST_PROC_END_TIME,ANEST_START_TIME,ANEST_END_TIME,SURG_START_TIME,SURG_END_TIME, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VISITING_PERSONNEL,WOUND_TYPE,PREP_START_TIME,PREP_END_TIME) VALUES ('"+(String)CommonData.get("facility_id")+"','"+(String) hash.get("oper_num")+"','"+(String) hash.get("speciality_code")+"',TO_DATE('"+preparation_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+procedure_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+procedure_end_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+anaesthesia_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+anaesthesia_end_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+surgery_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+surgery_end_time+"','DD/MM/YYYY HH24:MI'),'"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+visit_desc+"','',TO_DATE('"+prep_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+prep_end_time+"','DD/MM/YYYY HH24:MI'))";//Modified Against ML-MMOH-CRF-1936

				}

			}
			else
			{
				if(strPrevKey.equals("VISIT_PERSONNEL_I"))
				{

					 sql_new="UPDATE OT_POST_OPER_DTL2 SET VISITING_PERSONNEL='"+visit_desc+"',MODIFIED_BY_ID='"+(String)CommonData.get("facility_id")+"',MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO='"+(String)CommonData.get("login_at_ws_no")+"',MODIFIED_FACILITY_ID='"+(String)CommonData.get("facility_id")+"' WHERE OPERATING_FACILITY_ID='"+(String)CommonData.get("facility_id")+"' AND OPER_NUM='"+(String) hash.get("oper_num")+"' AND SPECIALITY_CODE='"+(String) hash.get("speciality_code")+"'";
				}
				else {
					 sql_new="UPDATE OT_POST_OPER_DTL2 SET PREPARATION_TIME=TO_DATE('"+preparation_time+"','DD/MM/YYYY HH24:MI'),ANEST_PROC_START_TIME=TO_DATE('"+procedure_start_time+"','DD/MM/YYYY HH24:MI'),ANEST_PROC_END_TIME=TO_DATE('"+procedure_end_time+"','DD/MM/YYYY HH24:MI'),ANEST_START_TIME=TO_DATE('"+anaesthesia_start_time+"','DD/MM/YYYY HH24:MI'),ANEST_END_TIME=TO_DATE('"+anaesthesia_end_time+"','DD/MM/YYYY HH24:MI'),SURG_START_TIME=TO_DATE('"+surgery_start_time+"','DD/MM/YYYY HH24:MI'),SURG_END_TIME=TO_DATE('"+surgery_end_time+"','DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID='"+(String)CommonData.get("login_user")+"',MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO='"+(String)CommonData.get("login_at_ws_no")+"',MODIFIED_FACILITY_ID='"+(String)CommonData.get("facility_id")+"',PREP_START_TIME=TO_DATE('"+prep_start_time+"','DD/MM/YYYY HH24:MI'),PREP_END_TIME=TO_DATE('"+prep_end_time+"','DD/MM/YYYY HH24:MI') WHERE OPERATING_FACILITY_ID='"+(String)CommonData.get("facility_id")+"' AND OPER_NUM='"+(String) hash.get("oper_num")+"' AND SPECIALITY_CODE='"+(String) hash.get("speciality_code")+"'";//Modified Against ML-MMOH-CRF-1936

				}

			}

			//System.out.println("strPrevKey---------->"+strPrevKey);
			//System.out.println("sql_new---------->"+sql_new);

			pstmt=con.prepareStatement(sql_new);
//			System.err.println("767");

			/*else
			{
			flag_chk = false;
			}*/
//			System.err.println("775");

							/*String remarks=(String) hash.get("visit_desc");
String visit_desc="";
visit_desc=java.net.URLDecoder.decode(remarks,"UTF-8");
System.err.println("visit_desc 3:" +visit_desc);

			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
			pstmt.setString(4,((String) hash.get("preparation_time")).trim());
			pstmt.setString(5,((String)hash.get("procedure_start_time")).trim());
			pstmt.setString(6,((String)hash.get("procedure_end_time")).trim());
			pstmt.setString(7,((String)hash.get("anaesthesia_start_time")).trim());
			pstmt.setString(8,((String)hash.get("anaesthesia_end_time")).trim());
			pstmt.setString(9,((String)hash.get("surgery_start_time")).trim());
			pstmt.setString(10,((String)hash.get("surgery_end_time")).trim());
			//auditing fields
			pstmt.setString(11,(String)CommonData.get("login_user"));
			pstmt.setString(12,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(13,(String)CommonData.get("facility_id"));
			pstmt.setString(14,(String)CommonData.get("login_user"));
			pstmt.setString(15,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(16,(String)CommonData.get("facility_id"));
			pstmt.setString(17,visit_desc);
			pstmt.setString(18,"");*/
		}else if(key.equals("OT_POST_OPER_DTL2_U")){
			pstmt.setString(1,((String) hash.get("preparation_time")).trim());
			pstmt.setString(2,((String)hash.get("procedure_start_time")).trim());
			pstmt.setString(3,((String)hash.get("procedure_end_time")).trim());
			pstmt.setString(4,((String)hash.get("anaesthesia_start_time")).trim());
			pstmt.setString(5,((String)hash.get("anaesthesia_end_time")).trim());
			pstmt.setString(6,((String)hash.get("surgery_start_time")).trim());
			pstmt.setString(7,((String)hash.get("surgery_end_time")).trim());
			pstmt.setString(8,(String)CommonData.get("login_user"));
			pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(10,(String)CommonData.get("facility_id"));
			pstmt.setString(11,((String)hash.get("prep_start_time")).trim());//Added by Arthi for ML-MMOH-CRF-1936
			pstmt.setString(12,((String)hash.get("prep_end_time")).trim());//Added by Arthi for ML-MMOH-CRF-1936
			//where condition
			pstmt.setString(13,(String)CommonData.get("facility_id"));
			pstmt.setString(14,(String) hash.get("oper_num"));
			pstmt.setString(15,(String) hash.get("speciality_code"));
//			System.err.println("*********816************");
		}else if(key.equals("OT_POST_OPER_DTL2_D")){
//			System.err.println("*********818************");
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
		}else if(key.equals("VISIT_PERSONNEL_I")){
//            System.err.println("*********822*********" );
			String remarks=(String) hash.get("visit_desc");
String visit_desc="";
visit_desc=java.net.URLDecoder.decode(remarks,"UTF-8");
//System.err.println("visit_desc :" +visit_desc);
			pstmt.setString(1,(String) CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
			pstmt.setString(4,visit_desc);
			//auditing fields
			pstmt.setString(5,(String)CommonData.get("login_user"));
			pstmt.setString(6,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(7,(String)CommonData.get("facility_id"));
			pstmt.setString(8,(String)CommonData.get("login_user"));
			pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(10,(String)CommonData.get("facility_id"));
			pstmt.setString(11,"");
		}else if(key.equals("VISIT_PERSONNEL_U")){
//			System.err.println("*********842************");
				String remarks=(String) hash.get("visit_desc");
String visit_desc="";
visit_desc=java.net.URLDecoder.decode(remarks,"UTF-8");
//System.err.println("visit_desc 2 :" +visit_desc);

			pstmt.setString(1,visit_desc);
			pstmt.setString(2,(String)CommonData.get("login_user"));
			pstmt.setString(3,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(4,(String)CommonData.get("facility_id"));
		//where condition
			pstmt.setString(5,(String)CommonData.get("facility_id"));
			pstmt.setString(6,(String) hash.get("oper_num"));
			pstmt.setString(7,(String) hash.get("speciality_code"));
		}
//		System.err.println("*********879************");
		int count=0;
		//System.out.println("key  "+key);
		//System.out.println("flag_chk  "+flag_chk);
		if(flag_chk)
		{
		count = pstmt.executeUpdate();
		}
		else{
			count=1;
		}

				//System.out.println("count  "+count);

		if(count>0){
			success_flag_yn = "Y";
		}else{
			success_flag_yn = "N";
		}
		}else{
			success_flag_yn = "Y";
			break;
		}
	 }//end for Loop

	 //Added on 11/12/2010 for scf 5515
	if(success_flag_yn.equals("Y"))
	{
		con.commit();
	}

	transaction_err_msg = "";
	//System.out.println("success_flag_yn  "+success_flag_yn);

	result_array.add(success_flag_yn);
	result_array.add(tabData);
}catch(Exception e){
	System.err.println("RecNursingManager: Err Msg in Execute Process,executeTransactions "+e.getMessage());
	success_flag_yn = "N";
	e.printStackTrace();
	transaction_err_msg = e.getMessage();
	result_array.add(success_flag_yn);
	result_array.add(tabData);
}finally{
	try{
		if(pstmt != null)
		pstmt.close();
		/* if(con != null)
		con.close(); */
	ConnectionManager.returnConnection(con); //Common-ICN-0052
		if(rst != null)	//Added Against AAKH-ICN-0008
		rst.close();
	}
	catch(Exception e){}
 }
 return result_array;
}

public boolean callBillingProcedure(ArrayList tabData,HashMap CommonData)
{
	Connection con = null;
	PreparedStatement pstmt = null;
	HashMap hash=null;
	String key ="";
	//String key_line="";	//Commented Against AAKH-ICN-0008
	//String nursing_doc_comp_yn=( String ) CommonData.get( "nursing_doc_comp_yn" );	//Commented Against AAKH-ICN-0008
	String pros_implants_compyn=checkForNull(( String ) CommonData.get( "pros_implants_compyn" ));
	String cons_packs_compyn=checkForNull(( String ) CommonData.get( "cons_packs_compyn" ));
	String equip_compyn=checkForNull(( String ) CommonData.get( "equip_compyn" ));
	String instr_css_compyn=checkForNull(( String ) CommonData.get( "instr_css_compyn" ));
	String checkInTime = (String) CommonData.get("checkInTime");
	String customerId = (String) CommonData.get("customerId");

	String st_interface_flag=( String ) CommonData.get( "st_interface_flag" );
	int size=0;
	BillingManager billingManager = null;
	boolean flag = false;
	try{
		con = ConnectionManager.getConnection();
	 size = tabData.size();
	 for(int i=0;i<size;i++){
		hash=(HashMap) tabData.get(i);
		if(hash!=null){
			key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
			pstmt = (PreparedStatement) stmt_hash.get(key);
			if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_I")){
				//key_line = getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",instr_css_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,instr_css_compyn,"N", con);	//Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 603");
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_U")){
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",instr_css_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,instr_css_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 612");
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_D")){
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",instr_css_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,instr_css_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 620");
			} else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_I")){
				//key_line = getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				//hash.put("BillRegnNum","B"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("BillRegnNum","E"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",equip_compyn);
				hash.put("desiredDate", (String) hash.get("desiredDate"));
				hash.put("checkInTime", checkInTime);
				hash.put("customerId", customerId);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,equip_compyn,"N", con);	//Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 629");
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_U")){
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				//hash.put("BillRegnNum","B"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("BillRegnNum","E"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",equip_compyn);
				hash.put("desiredDate", (String) hash.get("desiredDate"));
				hash.put("checkInTime", checkInTime);
				hash.put("customerId", customerId);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,equip_compyn,"N", con);	//Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 637");
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_D")){
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				//hash.put("BillRegnNum","B"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("BillRegnNum","E"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",equip_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,equip_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 645");
			} else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_I")){
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",cons_packs_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,cons_packs_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 655");
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_U")){
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",cons_packs_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,cons_packs_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 664");
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_D")){
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",cons_packs_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,cons_packs_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 672");
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_I")){
				//key_line = getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );
				if(st_interface_flag.equals("N"))
				{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,pros_implants_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 681");

				}
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_U")){
				if(st_interface_flag.equals("N"))
				{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,pros_implants_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 689");

				}
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_D")){
			if(st_interface_flag.equals("N"))
				{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				//boolean acc_flag = billingManager.processBilling(CommonData,key,pros_implants_compyn,"N", con); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 697");

			}}
		}else{
			flag=false;
			break;
		}
	 }//end for Loop
	 /*if(nursing_doc_comp_yn.equals("Y")){
		// Billing Process to be called here only once if the nursing_doc_comp_yn = "Y"
		//billingManager = BillingManager.intializeBillingManager(hash,CommonData); // Only here, This initialization is not used for this method.
		billingManager = BillingManager.intializeBillingManager(CommonData); // Only here, This initialization is not used for this method.
		boolean acc_flag = billingManager.processBilling(CommonData,key,nursing_doc_comp_yn,"Y");
		billingManager.tearDown("Rec Nursing Manager: 710");
	 }*/
	 transaction_err_msg = "";
	 flag=true;
}catch(Exception e){
	System.err.println("RecNursingManager: Err Msg in callBillingProcedure "+e.getMessage());
	flag = false;
	e.printStackTrace();
	transaction_err_msg = e.getMessage();
}finally{
	try{
		if(pstmt!=null) pstmt.close();
		//if(con!=null) con.close(); //perf issue 05Dec
		ConnectionManager.returnConnection(con); //Common-ICN-0052
	}
	catch(Exception e){}
 }
 return flag;
}

void closeAllStatement(HashMap hashStatement){
	String key="";
	Set set=hashStatement.keySet();
	Iterator itr=set.iterator();
	PreparedStatement pstmt=null;
	try{
		while(itr.hasNext()){
			 key=(String) itr.next();
			 pstmt=(PreparedStatement)hashStatement.get(key);
			 if(pstmt!=null)
			 pstmt.close();
		 }
	}catch(Exception ee){
		ee.printStackTrace();
		System.err.println("RecNursingManager: Err in closeAllStatement="+ee.getMessage());
	}


  }


    public String updateDocumentationLevel(HashMap map){
		Connection con = null;
	   	CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		String doc_compl_date ="null";
		//OT_UPDATE_STATUS('07', <LOGGED IN FACILITY ID>, NULL, <OPER_NUM>,  NULL, NULL,  NULL, <DOCUMENTATION_LEVEL>, NULL, NULL, NULL, NULL, <SLATE USER ID>, <WORKSTATION ID>, <L_STATUS>, <L_ERROR_TEXT>);
		try{
			//cstmt=con.prepareCall("{call OT_UPDATE_STATUS(?,?,null,?,null,null,?,?,null,null,?,null,null,?,?,?,?)}");
			//cstmt=con.prepareCall("{call OT_UPDATE_OPER_DTLS(1?,2?,3null,4?,5null,6null,7?,ADDNL_FLD1?,ADDNL_FLD2null,ADDNL_FLD3null,ADDNL_FLD4?,ADDNL_FLD5null,ADDNL_FLD6null,ADDNL_FLD7null,ADDNL_FLD8null,ADDNL_FLD9null,ADDNL_FLD10null,ADDNL_FLD11null,ADDNL_FLD12null,ADDNL_FLD13null,ADDNL_FLD14null,ADDNL_FLD15null,ADDNL_FLD16null,ADDNL_FLD17null,ADDNL_FLD18null,ADDNL_FLD19null,ADDNL_FLD20null,?,?,?,?)}");

//			System.err.println("doc_comp in nursing :" +(String) map.get("doc_complete"));
			if( ( (String) map.get("doc_complete") ).equals("Y")){
				doc_compl_date="TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')";
			}
			con = ConnectionManager.getConnection();
			cstmt=con.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,null,?,?,null,null,?,null,null,null,null,null,null,null,null,null,null,"+doc_compl_date+",null,null,null,null,null,?,?,?,?,?)}");
//			System.err.println("doc_comp in nursingsdasdsad :" +(String) map.get("doc_complete"));
			cstmt.setString(1,"08");//Function ID
			cstmt.setString(2,(String)map.get("facility_id"));
			cstmt.setString(3,(String)map.get("oper_num"));
			cstmt.setString(4,(String)map.get("doc_complete"));//DOCUMENTATION_COMPLETE
			cstmt.setString(5,(String)map.get("doc_level")); // ADDNL_FLD1
			cstmt.setString(6,(String)map.get("theatre_code")); // ADDNL_FLD4
			// the null fields are additional fields...not used in this function
			cstmt.setString(7,(String) map.get("login_user"));
			cstmt.setString(8,(String) map.get("login_at_ws_no"));
			cstmt.registerOutParameter(9,Types.VARCHAR);
			cstmt.registerOutParameter(10,Types.VARCHAR);
			cstmt.registerOutParameter(11,Types.VARCHAR);//LANG_ERR_MESG_ID
			cstmt.execute();
			status = cstmt.getString(9);
//			System.err.println("status in nursing :" +status);
			if(status.equals("E")){
				//error_text = cstmt.getString(10);
				error_text = cstmt.getString(11);
				con.rollback();
			}else{
				error_text ="RECORD_INSERTED";
			con.commit();
			}
				cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                if(cstmt!=null) cstmt.close();
				//if(con!=null) con.close();
				ConnectionManager.returnConnection(con); //Common-ICN-0052
             }catch(Exception es){es.printStackTrace();}
        }

		return error_text;
	}

public boolean buildHistory(HashMap CommonData) {
		Connection con = null;
		PreparedStatement pstmt			=				null;
		ResultSet rst					=				null;
		boolean err_text				=				true;
		String facility_id				=				( String )CommonData.get( "facility_id" );
		String oper_no					=				( String )CommonData.get( "oper_num" );

		String documt_level				=	( String )CommonData.get( "doc_level" );
		StringBuffer content			=				new StringBuffer();
		String short_desc				=				"";
		String side						=				"";
		String documentation_level		=				"";
		String speciality_code			=				"";
		String short_desc1				=				"";
		//String	notes_content			=				"";	//Commented Against AAKH-ICN-0008
		String speciality_desc			=				"";
		String role_desc				=				"";
		String practitioner_name		=				"";
		String holding_area_desc		=				"";
		String checked_in_date_time		=				"";
		String recovery_start_time		=				"";
		String recovery_end_time		=				"";
		//Reader content_reader			=				null;//Commented Against AAKH-ICN-0008
		Clob clob_notes_content			=				null;
		String speciality_code_as                               = "*ALL";
		String contr_mod_accession_num = "";
		//String contr_mod_accession_num_all = ""; //Commented Against AAKH-ICN-0008
		//BufferedReader	bf_content_reader	=	null; //Commented Against AAKH-ICN-0008
		Clob oper_details				=				null;
		java.io.Writer oper_details_writer			=	null;
		java.io.BufferedWriter	oper_details_buffered_writer	= null;
		HashMap map = new HashMap();
		String surg_contr_mod_accession_num = "";
		String key						=               "";
		String val						=               "";
		//oracle.sql.CLOB			clob_notes_content	= null;
		//MO-CRF-20147.13
		String compressedResult = "";
		String compressResultYN = "N";
		//MO-CRF-20147.13 

	try{
		 con = ConnectionManager.getConnection();
		 //String sql="SELECT SHORT_DESC,DECODE(RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Both Sides',RIGHT_LEFT_FLAG) side FROM   OT_POST_OPER_DTLS A,OT_OPER_MAST B WHERE  A.OPER_CODE = B.OPER_CODE AND A.OPERATING_FACILITY_ID = '"+facility_id+"' AND  A.OPER_NUM = '"+oper_no+"' AND NVL(OPER_LINE_STATUS,'X') NOT IN ('99') ";
		 String sql="SELECT SHORT_DESC,DECODE(RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Both Sides',RIGHT_LEFT_FLAG) side FROM   OT_POST_OPER_DTLS A,OT_OPER_MAST B WHERE  A.OPER_CODE = B.OPER_CODE AND A.OPERATING_FACILITY_ID = '"+facility_id+"' AND  A.OPER_NUM = '"+oper_no+"' ";
		 pstmt=con.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
		 content.append("<tr><td colspan=2><B>Operation Details:</B></td></tr>");
		 while(rst.next()){
			short_desc  = rst.getString("SHORT_DESC")==null?"":rst.getString("SHORT_DESC");
			side  = rst.getString("side")==null?"":rst.getString("side");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+short_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+side+" </td></tr>");

		 }
		 if(pstmt !=null) pstmt.close();
		 if(rst !=null) rst.close();
		 sql="select 'Anaesthesia Given to Patient:  '||SHORT_DESC short_desc, TO_CHAR(RECOVERY_START_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_START_TIME,TO_CHAR(RECOVERY_END_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_END_TIME,DOCUMENTATION_LEVEL,SPECIALITY_CODE from  ot_post_oper_hdr a, AM_ANAESTHESIA b where  A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND    A.OPER_NUM = '"+oper_no+"' and    a.ANESTHESIA_CODE = b. ANAESTHESIA_CODE(+)";
		 pstmt=con.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 while(rst.next()){
			documentation_level		=		 rst.getString("DOCUMENTATION_LEVEL")==null?"":rst.getString("DOCUMENTATION_LEVEL");
			speciality_code			=		 rst.getString("SPECIALITY_CODE")==null?"":rst.getString("SPECIALITY_CODE");
			recovery_start_time		=		 rst.getString("RECOVERY_START_TIME")==null?"":rst.getString("RECOVERY_START_TIME");
			recovery_end_time		=		 rst.getString("RECOVERY_END_TIME")==null?"":rst.getString("RECOVERY_END_TIME");
			short_desc1				=		 rst.getString("SHORT_DESC")==null?"":rst.getString("SHORT_DESC");
		}
	 if(pstmt !=null) pstmt.close();
		 if(rst !=null) rst.close();
		String anaes_srl_no="";
		final String QUOTE = "'";
		final String COMMA = ",";
		String SQL_ANES_SRL_NO = "SELECT anaesthesia_serial_num FROM at_anaesthesia_record_hdr WHERE SOURCE_ORDER_ID = ?";
		pstmt=con.prepareStatement(SQL_ANES_SRL_NO);
		pstmt.setString(1,(String) CommonData.get("order_id"));
		rst=pstmt.executeQuery();
		if(rst.next()){
			anaes_srl_no = rst.getString(1);
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

		//added by sahtihs on 24/12/2008

		String sql_speciality = "SELECT DISTINCT A.SPECIALITY_CODE,B.SHORT_DESC  FROM OT_OPER_MAST A, AM_SPECIALITY B WHERE A.OPER_CODE IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID = ?  AND OPER_NUM = ?) AND A.SPECIALITY_CODE = B.SPECIALITY_CODE AND NVL(B.EFF_STATUS,'E')='E' ORDER BY 1";
		pstmt=con.prepareStatement(sql_speciality);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_no);
		 rst=pstmt.executeQuery();
		 while(rst.next()){
			key	= checkForNull(rst.getString(1));//speciality_code
			val = checkForNull(rst.getString(2));//speciality_desc
			map.put(key,val);
		}

		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		//newly added by subramanian on 4/3/2006

		//changed for scf 822

		if(documt_level.equals("AS")){
		//contr_mod_accession_num = facility_id+oper_no+"*ALL";
		contr_mod_accession_num = facility_id+oper_no+speciality_code_as;
		}else{
		contr_mod_accession_num = facility_id+oper_no+speciality_code;
		}




		//String contr_mod_accession_num = facility_id+oper_no+speciality_code;



		String facility_srl_no = facility_id+anaes_srl_no;
		StringBuffer sbr = new StringBuffer();
		sbr.append(QUOTE).append(contr_mod_accession_num).append("10").append(QUOTE).append(COMMA);
		//sbr.append(QUOTE).append(contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);



		if(documt_level.equals("AS")){
		surg_contr_mod_accession_num = facility_id+oper_no+speciality_code_as;
		sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
		}else{
		Iterator keys = map.keySet().iterator();
			while(keys.hasNext()){
				surg_contr_mod_accession_num = facility_id+oper_no+(String)keys.next();
				sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
			}
	   }


		/*
		Iterator keys = map.keySet().iterator();
			while(keys.hasNext()){
				surg_contr_mod_accession_num = facility_id+oper_no+(String)keys.next();
				sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
			}
			*/

		/*if(documt_level.equals("AS")){
        System.out.println( " the if document_level is as " + documt_level);
		sbr.append(QUOTE).append(contr_mod_accession_num).append("40").append(QUOTE).append(COMMA);
		}else{ */
		sbr.append(QUOTE).append(contr_mod_accession_num).append("40").append(QUOTE).append(COMMA);
		//}
		sbr.append(QUOTE).append(contr_mod_accession_num).append("99").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("PRE").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("INTRA").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("POST").append(QUOTE);
			if(pstmt !=null) pstmt.close();
		if(rst !=null) rst.close();

		//sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") ORDER BY 1";
		//sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT, CONTR_MOD_ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") AND EVENT_STATUS <> 9 ORDER BY 1";
		sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT,  CONTR_MOD_ACCESSION_NUM, compress_note_content_yn, compress_note_content FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") AND EVENT_STATUS <> 9 ORDER BY 1";	//Modified Against MO-CRF-20147.13

		sbr.setLength(0);
		content.append("<link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' />");

		pstmt = con.prepareStatement(sql);
		rst=pstmt.executeQuery();
		while(rst.next()){
			switch(rst.getInt(1)){
				case 1: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Holding Area Notes</TD><TR><TABLE>"); break;
				//case 2: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>"); break;
				case 2:
				 /* if(documt_level.equals("AS")){
				   content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>");
					}else{ */
				//	val = rst.getString(4);
				//	key = val.substring(12,val.length()-2);
				//	content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes("+map.get(key)+")</TD><TR><TABLE>");
				//	}

					val = rst.getString(4);
					key = val.substring(12,val.length()-2);
					if (key!=null && !key.equals("") && !key.equals("*ALL")){
					//if (key!=null && key !=""){
					content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes("+map.get(key)+")</TD><TR><TABLE>");
					}else{
					content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>");
					}


					break;
				case 3: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Recovery Notes</TD><TR><TABLE>"); break;
				case 4: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Operative Records</TD><TR><TABLE>"); break;
				case 5: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Pre Anesthesia Details</TD><TR><TABLE>"); break;
				case 6: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Intra Anesthesia Details</TD><TR><TABLE>"); break;
				case 7: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Post Anesthesia Details</TD><TR><TABLE>"); break;
				default :break;

			}


			//clob_notes_content	= while_rst.getClob("note_content");

			clob_notes_content	= rst.getClob("note_content");

		//	clob_notes_content	=	(oracle.sql.CLOB) rst.getObject("note_content");

	//		System.out.println( " oracle.sql.CLOB clob_notes_content is as shown 1519" +clob_notes_content);




			if(clob_notes_content!=null){

				System.out.println( " oracle.sql.CLOB clob_notes_content is as shown 1523  " + content.append(clob_notes_content.getSubString(1,(int) clob_notes_content.length())).append("*****"));
			/*	try{
				    System.out.println( " first time is try block " );
					content_reader	= clob_notes_content.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					notes_content = new String(arr_notes_content);
					System.out.println( "1531  notes_content clob_notes_content is as shown " +notes_content);
					content.append(notes_content);
					bf_content_reader.close();

				}


				catch(Exception e){
					err_text=false;
					System.err.println("RecNursingManager: Exception@2-readCLOB : "+e);
					e.printStackTrace();
				} */

			}
			// end of if(clob_notes_content!=null)
				//MO-CRF-20147.13 Starts
		
		compressResultYN = rst.getString("compress_note_content_yn")==null?"N":(String)rst.getString("compress_note_content_yn");
		java.sql.Blob note_blob =  (java.sql.Blob)rst.getBlob("compress_note_content");
					if(note_blob!=null && note_blob.length()>0){
						InputStream ins1 = note_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
							bytearrayoutputstream.write(i);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {
									compressedResult += line;
								}
							}					
						}
					}
		//MO-CRF-20147.13 Ends
		} // end of if(rst.next())
        content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
		content.append("<tr><td></td><td nowrap>"+short_desc1+"</td></tr>");

			if(pstmt !=null) pstmt.close();
		if(rst !=null) rst.close();
	    sql=" SELECT DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities', D.SHORT_DESC) SPECIALITY_DESC,C.ROLE_DESC, B.SHORT_NAME PRACTITIONER_NAME  FROM   OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER B, OT_ROLES C, (SELECT '*ALL' SPECIALITY_CODE,'All Specialities'  SHORT_DESC FROM DUAL UNION SELECT SPECIALITY_CODE, SHORT_DESC FROM  AM_SPECIALITY  )  D  WHERE  A.OPERATING_FACILITY_ID = '"+facility_id+"' AND 	 A.OPER_NUM			 ='"+oper_no+"' AND	  A.SPECIALITY_CODE	 = D.SPECIALITY_CODE  AND	 A.PRACTITIONER_ID	 = B.PRACTITIONER_ID  AND  A.ROLE_ID	 = C.ROLE_ID ";
        pstmt=con.prepareStatement(sql);
		rst=pstmt.executeQuery();
		content.append("<tr><td colspan=6 class='CAGROUPHEADING'>Personnel Details</td></tr>");
		while(rst.next()){
			speciality_desc		=	rst.getString("SPECIALITY_DESC")==null?"":rst.getString("SPECIALITY_DESC");
			role_desc			=	rst.getString("ROLE_DESC")==null?"":rst.getString("ROLE_DESC");
			practitioner_name	=	rst.getString("PRACTITIONER_NAME")==null?"":rst.getString("PRACTITIONER_NAME");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+speciality_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+role_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+practitioner_name+"  </td></tr>");

		}
		if(pstmt !=null) pstmt.close();
		if(rst !=null) rst.close();
		sql="SELECT B.HOLDING_AREA_DESC, TO_CHAR(CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_IN_DATE_TIME FROM  OT_OPER_HOLDING_DTLS A, OT_HOLDING_AREAS B WHERE A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND   A.OPER_NUM ='"+oper_no+"' AND   A.OPERATING_FACILITY_ID  = B.OPERATING_FACILITY_ID AND A. HOLDING_AREA_CODE = B. HOLDING_AREA_CODE";
		pstmt=con.prepareStatement(sql);
		rst=pstmt.executeQuery();
		content.append("<tr><td colspan=5 class='CAGROUPHEADING'>Holding Bay Details</td></tr>");
		while(rst.next()){
			holding_area_desc  = rst.getString("HOLDING_AREA_DESC")==null?"":rst.getString("HOLDING_AREA_DESC");
			checked_in_date_time  = rst.getString("CHECKED_IN_DATE_TIME")==null?"":rst.getString("CHECKED_IN_DATE_TIME");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+holding_area_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+checked_in_date_time+"</td></tr>");

		}
		//pstmt.close();
		//rst.close();

		content.append("<tr><td colspan=6 class='CAGROUPHEADING'><B>Recovery start and end time:</B></td></tr>");
		content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+recovery_start_time+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+recovery_end_time+"</td></tr>");
		content.append("</table></BODY></HTML>");
			if(pstmt !=null) pstmt.close();
		if(rst !=null) rst.close();
		if(compressResultYN.equals("N"))	//MO-CRF-20147.13 
		{
		String updateSql = "UPDATE ot_post_oper_hdr SET  oper_details = empty_clob()  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";
		pstmt = con.prepareStatement(updateSql);
		pstmt.executeUpdate();
		//pstmt.close();
			if(pstmt !=null) pstmt.close();
		if(rst !=null) rst.close();

		String selectSql = "select oper_details from ot_post_oper_hdr where operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"' for update";

		pstmt = con.prepareStatement(selectSql);
		rst = pstmt.executeQuery();
		if(rst.next()){
			oper_details = rst.getClob("oper_details");
			//oper_details_writer = ((oracle.sql.CLOB)oper_details).getCharacterOutputStream();
			oper_details_writer = oper_details.setCharacterStream(0L);//Modified by MuthuN against WebLogic CLOB
			oper_details_buffered_writer = new java.io.BufferedWriter(oper_details_writer);
			oper_details_buffered_writer.write(content.toString(),0,content.length());

			oper_details_buffered_writer.flush();
			oper_details_buffered_writer.close();
			//con.commit();
		}
		}
		//MO-CRF-20147.13 Starts
		else{
			String updateCompressed = "UPDATE OT_POST_OPER_HDR SET compress_note_content_yn = ? , compress_note_content = ?  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";
			
			pstmt = con.prepareStatement(updateCompressed);

			pstmt.setString(1,compressResultYN );
		 pstmt.setBytes(2, compress(compressedResult));
		 pstmt.executeUpdate();
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close(); 

		}
		//MO-CRF-20147.13 Ends
	}catch(Exception ee){
		ee.printStackTrace();
		System.err.println("RecNursingManager: error in insert method::"+ee);
		err_text=false;
	}finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			con.commit();// added on 23-02-2008
			//if(con!=null) con.close();
			ConnectionManager.returnConnection(con); //Common-ICN-0052
		 }catch(Exception e){}
	  }
 	return err_text;
	 //return true;
	}

	//MO-CRF-20147.13 Starts
	public  byte[] compress(final String str) throws IOException {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}
		System.err.println("compressing");
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes("UTF-8"));
		gzip.close();
		return obj.toByteArray();
	}
	//MO-CRF-20147.13 Ends
	
	public String callSurgeonAvgTime(HashMap map){
	   	CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		Connection con = null;
		try{
			con=ConnectionManager.getConnection();
			cstmt=con.prepareCall("{call OT_SURGEON_AVG_TIME(?,?,?,null,null,null,?,?,?,?,?)}");
			cstmt.setString(1,(String)map.get("facility_id"));
			cstmt.setString(2,(String)map.get("oper_num"));
			cstmt.setString(3,(String)map.get("surgeon_code"));
			cstmt.setString(4,(String) map.get("login_user"));
			cstmt.setString(5,(String) map.get("login_at_ws_no"));
			cstmt.registerOutParameter(6,Types.VARCHAR);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MSG_ID
			cstmt.execute();
			status = cstmt.getString(6);
			if(status.equals("E")){
				//error_text = cstmt.getString(7);
				error_text = cstmt.getString(8);
				con.rollback();
			}else if( status.equals("S") ){
				error_text ="RECORD_INSERTED";
				con.commit();
			}

		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                if(cstmt!=null) cstmt.close();
				//if(con!=null) con.close();
				ConnectionManager.returnConnection(con); //Common-ICN-0052
             }catch(Exception es){es.printStackTrace();}
        }

		return error_text;
	}


	public int getBillSubRegnLineNum(String oper_num,String oper_line_num,String acc_type){

		int result =0;
		//String error_text = "";	//Commented Against AAKH-ICN-0008
		PreparedStatement pstmt= null;
		Connection con = null;
		ResultSet rst = null;

		String SQL = "SELECT NVL(MAX(TO_NUMBER(BILL_SUB_REGN_LINE_NUM)),0) FROM OT_SURGICAL_ACCESSORIES WHERE OPER_NUM = ? AND OPER_LINE_NUM=? ";

			try{
				con=ConnectionManager.getConnection();
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1,oper_num);
				pstmt.setString(2,oper_line_num);
				rst = pstmt.executeQuery();
				while(rst.next()){
					result = rst.getInt(1);
				}
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();	//Added Against Common-ICN-0031
					//if(con!=null) con.close();
					ConnectionManager.returnConnection(con); //Common-ICN-0052
				 }catch(Exception es){}
			}


		return result;
	}

	//Commented by DhanasekarV against issue IN026523 on 14/02/2011

	/*public String getBillSubRegnLineNum(String oper_num,String oper_line_num,String acc_type,String keyline){

		//Added as local variable to function for 26068 by AnithaJ on 1/28/2011
		int result = 0;	//used for billing subregkeyline

		String error_text = "";
		PreparedStatement pstmt= null;
		Connection con = null;
		ResultSet rst = null;
		//Consumable -> C , Equipment-->B, CSSD --> S ,Implant-->I

		//String SQL = "SELECT MAX(NVL(BILL_SUB_REGN_LINE_NUM,0))+1 FROM OT_SURGICAL_ACCESSORIES WHERE OPER_NUM = ? AND OPER_LINE_NUM=? AND ACCESSORY_TYPE=?";
		System.out.println("1 result  "+result);
		System.out.println("2 oper_num  "+oper_num);
		System.out.println("3 oper_line_num  "+oper_line_num);
		if(result==0){
			String SQL = "SELECT NVL(MAX(TO_NUMBER(BILL_SUB_REGN_LINE_NUM)),0)+1 FROM OT_SURGICAL_ACCESSORIES WHERE OPER_NUM = ? AND OPER_LINE_NUM=? ";

			try{
				con=ConnectionManager.getConnection();
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1,oper_num);
				pstmt.setString(2,oper_line_num);
				rst = pstmt.executeQuery();
				while(rst.next()){
					result = rst.getInt(1);
				}
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				 }catch(Exception es){}
			}

		if(result==1)
		{
					System.out.println("eOT  keyline"+keyline);
			if(keyline==null||keyline.length()==0||keyline.equals("null")) keyline ="0";
			result=1+Integer.parseInt(keyline);// Default value in case query returns no rows
		}

		}else
			result++;
		System.out.println(" result  value"+result);


		return ""+result;
	}*/


public String checkForNull(String str){
	return (  str!=null && str.intern()!="null" )?str:"";
}

};





