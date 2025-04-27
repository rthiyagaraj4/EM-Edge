/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

package eOT.AdministrativeFunction;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Statement;
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
import eCommon.Common.CommonBean;
import java.util.*;
import eOT.Common.BillingManager;
import eOT.Common.BillingUtil;

/**
*
* @ejb.bean
*	name="AdministrativeFunction"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AdministrativeFunction"
*	local-jndi-name="AdministrativeFunction"
*	impl-class-name="eOT.AdministrativeFunction.AdministrativeFunctionforAllChargesManager"
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.AdministrativeFunction.AdministrativeFunctionforAllChargesLocal"
*	remote-class="eOT.AdministrativeFunction.AdministrativeFunctionforAllChargesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.AdministrativeFunction.AdministrativeFunctionforAllChargesLocalHome"
*	remote-class="eOT.AdministrativeFunction.AdministrativeFunctionforAllChargesHome"
*	generate= "local,remote"
*
*
*/

public class AdministrativeFunctionforAllChargesManager implements  SessionBean{
	HashMap stmt_hash = new HashMap();
	String transaction_err_msg="";
	//HashMap<String,List> bill_map = new HashMap<String,List>(); // Commented against AAKH-SCF-0294
	//call back methods overriden
	public void ejbCreate() {}
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
		System.err.println("==CommonData==insert=="+CommonData);
		System.err.println("==tabData==insert=="+tabData);
		System.err.println("==sqlMap==insert=="+sqlMap);
		HashMap<String,List> bill_map = new HashMap<String,List>();//Added against AAKH-SCF-0294
		Connection con = null;
		String err_text ="";
		String facility_id = (String) CommonData.get("facility_id");
		String oper_no=( String )CommonData.get( "oper_num" );
		String proc_chrg_cmp_yn=( String )CommonData.get( "proc_chrg_cmp_yn" );
		String oper_compl_yn=( String )CommonData.get( "oper_compl_yn" );
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt1 = null;
		boolean billing_installed_yn = false;
		String executeTransactions_success_YN = "N"; // For checking transaction succesful_YN
		boolean callBillingProcedure_success_flag = false; // For checking billing transaction succesful_YN
		String  callBillingProcedure_return_value = ""; // For checking billing transaction succesful_YN
		ArrayList result_array = new ArrayList(); // For checking billing transaction succesful_YN
		String err_desc="SUCCESS";
		HashMap hash=null;
		int rec = 0;
		int or = 0;
		int ha = 0;
		int proc = 0;
		String oper_codee = "";
		String panel_strr = "";
		String err_mesg_gpb = "RECORD_INSERTED";
		String insert_flag = "";
		try
		{
			con=ConnectionManager.getConnection(prop);
			createStatementCollection(con,sqlMap);
			String doc_compl_rec_yn       =( String ) CommonData.get( "doc_compl_rec_yn" );
			String doc_compl_or_yn        =( String ) CommonData.get( "doc_compl_or_yn" );
			String doc_compl_ha_yn        =( String ) CommonData.get( "doc_compl_ha_yn" );
			String rec_chargeable_yn      =( String ) CommonData.get( "rec_chargeable_yn" );
			String charge_recovery_room_yn =( String ) CommonData.get( "charge_recovery_room_yn" );
			String bill_flag               =( String ) CommonData.get( "bill_flag" );
			String or_chargeable_yn        =( String ) CommonData.get( "or_chargeable_yn" );
			String charge_operating_room_yn =( String ) CommonData.get( "charge_operating_room_yn" );
			String charge_holding_area_yn  =( String ) CommonData.get( "charge_holding_area_yn" );
			String rec_chrg_cmp_yn          =( String ) CommonData.get( "rec_chrg_cmp_yn" );
			String or_chrg_cmp_yn           =( String ) CommonData.get( "or_chrg_cmp_yn" );
			String hld_chrg_cmp_yn          =( String ) CommonData.get( "hld_chrg_cmp_yn" );
			String modified_charge_units    =(String)CommonData.get("modified_charge_units");
			String modified_charge_units_or =(String)CommonData.get("modified_charge_units_or");

			int size = tabData.size();

			billing_installed_yn = isBillingInstalled(con,facility_id);
        /* newly added below Code on 21-aug-2009 against CRF-677*/
		if(!("Y").equals(proc_chrg_cmp_yn))
		{
			if (billing_installed_yn)
			{
			for (int i = 0; i < size; i++)
			{
				hash=(HashMap)tabData.get(i);
				System.err.println("==hash==insert=="+i+"=="+hash);
				insert_flag=(String) hash.get("insert_flag");
				if (hash != null && ("Operation").equals(insert_flag))
				{
				  oper_codee = (String)hash.get("oper_code");
				if (oper_codee != null && !oper_codee.equals(""))
				{
					panel_strr = (String)hash.get("panel_str");
				if (panel_strr != null && !panel_strr.equals(""))
				{
					List<String> list = new ArrayList<String>();
					System.err.println("==bill_str==insert=="+ hash.get("bill_str"));
					list.add(java.net.URLDecoder.decode(panel_strr,"UTF-8"));
					list.add((String) hash.get("bill_str"));
					System.err.println("==list==insert=="+list);
					bill_map.put(oper_codee,list);
				}
			   }
			  }
			}
				System.err.println("==bill_map==insert=="+bill_map);
		  if(("N").equals(proc_chrg_cmp_yn))
			  err_mesg_gpb = GeneratePatientBill(con,CommonData,bill_map,tabData );
				//err_mesg_gpb="RECORD_INSERTED";
			 }
			 if(("RECORD_INSERTED").equals(err_mesg_gpb))//Added 39773
		     {
				  err_desc="SUCCESS";
				  String sql_update_proc="UPDATE OT_POST_OPER_HDR SET PROC_CHRG_CMP_YN ='"+oper_compl_yn+"' WHERE   OPERATING_FACILITY_ID = '"+facility_id+"' AND	OPER_NUM	= '"+oper_no+"'";
				  System.err.println("==sql_update_proc==insert=="+sql_update_proc);
				  pstmt5 = con.prepareStatement(sql_update_proc);
				  proc=pstmt5.executeUpdate();
				  con.commit();
 		     }
				else
				 err_desc=err_mesg_gpb;
	       }
            if(("SUCCESS").equals(err_desc))
		    {
			if (("true").equals(bill_flag) && ("Y").equals(charge_recovery_room_yn) && ("Y").equals(rec_chargeable_yn) && !("Y").equals(rec_chrg_cmp_yn) && !("").equals(modified_charge_units))
			{
					err_desc=(String) updateRecRoomPopulateIntercaceRecsOTR(con,prop,CommonData);
			if(("SUCCESS").equals(err_desc) && doc_compl_rec_yn.equals("Y"))
			{
					err_desc=(String) updateRecRoomPopulateIntercaceRecsOTF(con,prop,CommonData);
			if(("SUCCESS").equals(err_desc))
			{
				String sql_update_rec="UPDATE OT_POST_OPER_HDR SET REC_CHRG_CMP_YN  ='Y' WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND OPER_NUM	= '"+oper_no+"'";
				pstmt2 = con.prepareStatement(sql_update_rec);
				rec=pstmt2.executeUpdate();
				con.commit();
			}
			}
			}

			if (("true").equals(bill_flag) && ("Y").equals(charge_operating_room_yn) && ("Y").equals(or_chargeable_yn)
					&& !("Y").equals(or_chrg_cmp_yn) && !("").equals(modified_charge_units_or))
			{
			if(("SUCCESS").equals(err_desc))
			{
				err_desc=(String) updateOperRoomPopulateIntercaceRecsOTR(con,prop,CommonData);
				if(doc_compl_or_yn.equals("Y"))
				{
				err_desc=(String) updateOperRoomPopulateIntercaceRecsOTF(con,prop,CommonData);
				if(("SUCCESS").equals(err_desc))
				{
				String sql_update_or="UPDATE OT_POST_OPER_HDR SET OR_CHRG_CMP_YN  ='Y' WHERE   OPERATING_FACILITY_ID	='"+facility_id+"' AND	OPER_NUM = '"+oper_no+"'";
				pstmt3 = con.prepareStatement(sql_update_or);
				or=pstmt3.executeUpdate();
				con.commit();
					}
				}
			}
			}
			if(("true").equals(bill_flag) && ("Y").equals(charge_holding_area_yn) && !("Y").equals(hld_chrg_cmp_yn))
			{
				if(("SUCCESS").equals(err_desc))
				{
					err_desc=(String) updateHoldingAreaPopulateIntercaceRecsOTR(con,prop,CommonData);
					if(doc_compl_ha_yn.equals("Y"))
					{
					err_desc=(String) updateHoldingAreaPopulateIntercaceRecsOTF(con,prop,CommonData);
					if(("SUCCESS").equals(err_desc))
					{
					String sql_update_ha="UPDATE 	OT_POST_OPER_HDR SET HLD_CHRG_CMP_YN  ='Y' WHERE   OPERATING_FACILITY_ID= '"+facility_id+"' AND	OPER_NUM = '"+oper_no+"'";
					pstmt4 = con.prepareStatement(sql_update_ha);
					ha=pstmt4.executeUpdate();
					con.commit();
					}
					}
				}
			}
			}
         if(("SUCCESS").equals(err_desc))
		{
			 result_array = (ArrayList)executeTransactions(con,tabData,CommonData);
			 executeTransactions_success_YN = (String)result_array.get(0);
		}

		if (executeTransactions_success_YN.equals("Y") && ("SUCCESS").equals(err_desc))
		{
			tabData = (ArrayList)result_array.get(1);// tabData is modified in executeTransactions to get the key_line for each oper_code
			int j=0;
			if (billing_installed_yn == true)
			{
				callBillingProcedure_return_value = callBillingProcedure(tabData,CommonData);
			if(("RECORD_INSERTED").equals(callBillingProcedure_return_value))
				 callBillingProcedure_success_flag=true;
			else
			{
				 callBillingProcedure_success_flag=false;
				 transaction_err_msg=callBillingProcedure_return_value;
			}
			 }
			else
				callBillingProcedure_success_flag=true;

			if (callBillingProcedure_success_flag == true)
			{
				con.commit();
				err_text="RECORD_INSERTED";
			}
			else
			{
				 con.rollback();//err_text = "RECORD_INSERTED";
				 if(!("SUCCESS").equals(err_desc))
				 err_desc+=transaction_err_msg;
				 else
				 err_desc=transaction_err_msg;
			}
				String pros_implants_compyn=checkForNull(( String ) CommonData.get( "pros_implants_yn" ));
				String cons_packs_compyn=checkForNull(( String ) CommonData.get( "cons_packs_yn" ));
				String equip_compyn=checkForNull(( String ) CommonData.get( "equipments_yn" ));
				String instr_css_compyn=checkForNull(( String ) CommonData.get( "inst_cssd_yn" ));
				if(callBillingProcedure_success_flag==true)
			    {
					String sql_update="UPDATE ot_post_oper_hdr SET IMPLANT_ENTRY_CMP_YN='"+pros_implants_compyn+"', CONSUMABLE_ENTRY_CMP_YN='"+cons_packs_compyn+"', EQUIPMENT_ENTRY_CMP_YN='"+equip_compyn+"', INSTRUMENT_ENTRY_CMP_YN='"+instr_css_compyn+"' WHERE operating_facility_id = '"+facility_id+"' AND oper_num  ='"+oper_no+"'";
					pstmt1 = con.prepareStatement(sql_update);
					j=pstmt1.executeUpdate();
					con.commit();
				}
			}
			else
			{
				con.rollback();
                if(("SUCCESS").equals(err_desc) || ("").equals(err_desc))
					err_desc=transaction_err_msg;
			 } //executeTransactions_success_YN
		}
		catch (Exception ee)
		{
			System.err.println("Admin Function: error in insert method:: "+ee);
			ee.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt5 != null)
					pstmt5.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (pstmt3 != null)
					pstmt3.close();
				if (pstmt4 != null)
					pstmt4.close();
				if (pstmt1 != null)
					pstmt1.close();
				if(con!=null)
					ConnectionManager.returnConnection(con);
		}
			catch (Exception e)
			{
				e.printStackTrace();
			}
   }
	return err_desc;
}

 public boolean isBillingInstalled(Connection con,String facility_id){
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean flag = false;
	try{
		cstmt=con.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);
		cstmt.execute();

		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();

   }finally{
		try{
			if(cstmt!=null)cstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return flag;
 }

public void createStatementCollection(Connection con,HashMap sqlMap){
	try{
		  Set set=sqlMap.keySet();
		  Iterator itr=set.iterator();
		  PreparedStatement pstmt=null;
		  String key="";
		  while(itr.hasNext())
		  {
			  key=(String) itr.next();
			  pstmt=con.prepareStatement((String) sqlMap.get(key));
			  stmt_hash.put(key,pstmt);
		  }
	 }
	 catch(Exception ee)
	 {
			System.err.println("Admin Function: Err createStatementCollection(EJB): "+ee);
			ee.printStackTrace();
			closeAllStatement(stmt_hash);
	 }
  }

   public String updateRecRoomPopulateIntercaceRecsOTR(Connection con,Properties prop,HashMap CommonData){
	CallableStatement cstmt= null;
	Statement stmt=null;
	Statement stmt_bl=null;
	ResultSet rst=null;
	ResultSet rst_bl=null;
	String addedById = prop.getProperty( "login_user" );

	PreparedStatement pstmt2 = null;
	int rec=0;

	String err_text			= "";
	String err_desc		= "";
	String mesg_id			= "";
	String encounter_id="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String patient_class="";
	String bl_episode_type="";
	String pract_code_val = "";
	String[] pract_arr=null;

	String oper_num=(String)CommonData.get("oper_num");
	String recv_bl_accession_num=(String)CommonData.get("recv_bl_accession_num");
	String rec_room_code=(String)CommonData.get("rec_room_code");
	String modified_charge_units=(String)CommonData.get("modified_charge_units");
	String serv_code=(String)CommonData.get("serv_code");
	String patient_id=(String)CommonData.get("patient_id");
	String surgeon_code=(String)CommonData.get("surgeon_code");
	String login_at_ws_no=(String)CommonData.get("login_at_ws_no");
	String facility_id=(String)CommonData.get("facility_id");
	String include_exclude1=(String)CommonData.get("include_exclude1");
	String action_reason_code1=(String)CommonData.get("action_reason_code1");
	String bl_panel_str_reco=(String)CommonData.get("bl_panel_str_reco");
	try{
		if(("").equals(bl_panel_str_reco)||("null").equals(bl_panel_str_reco))
		{
			bl_panel_str_reco=null;
		}
		if(bl_panel_str_reco!=null)
		{
			pract_arr=bl_panel_str_reco.split("#");
			pract_code_val=pract_arr[5];
		 }

		stmt=con.createStatement();
		String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND operating_facility_id='"+facility_id+"'";//Added(facility_id) Against KDAH-scf-500

		rst=stmt.executeQuery(sql);
		if(rst !=null && rst.next())
		{
			encounter_id=rst.getString("ENCOUNTER_ID");
			episode_id=rst.getString("EPISODE_ID");
			episode_type=rst.getString("EPISODE_TYPE");
			visit_id=rst.getString("VISIT_ID");
			patient_class=rst.getString("PATIENT_CLASS");
			if(visit_id ==null) visit_id="";
		}

		String sql_update_rec="UPDATE OT_POST_OPER_HDR SET RECV_CHARGEABLE_UNITS  = '"+modified_charge_units+"' WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND	OPER_NUM = '"+oper_num+"'";
		pstmt2 = con.prepareStatement(sql_update_rec);
		rec=pstmt2.executeUpdate();
		con.commit();

		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		stmt_bl = con.createStatement();
		rst_bl=stmt_bl.executeQuery(sql_bl_epi_type);
		 if(rst_bl !=null && rst_bl.next())
		  {
			bl_episode_type=checkForNull(rst_bl.getString(1));
		  }
			cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			cstmt.setString(1,"OTR");	//
			cstmt.setString(2,facility_id);
			cstmt.setString(3,bl_episode_type);//Episode Type
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,recv_bl_accession_num);//accession_num
			cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,recv_bl_accession_num);//accession_num
			cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,serv_code);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,rec_room_code);//rec_room_code
			cstmt.setString(16,"");//rec_room_desc
			cstmt.setString(17,modified_charge_units);//modified_charge_units			
			/*Added by Suma inoder to pass the modified pract id when changed in billing window on 7/03/2010 as per site req*/
			if(("").equals(pract_code_val)||("null").equals(pract_code_val))
            {
				pract_code_val=null;
            }

		    if(pract_code_val!=null)
			{
				cstmt.setString(18,pract_code_val );
			}else
			{
				cstmt.setString(18,surgeon_code );
			}
			/*Added by Suma ends here*/

			cstmt.setString(19,include_exclude1);//surgeon_code
			cstmt.setString(20,action_reason_code1);//surgeon_code
			cstmt.setString(21,addedById);//login_id  ---> to be change
			cstmt.setString(22,login_at_ws_no);//ws_no			
			cstmt.registerOutParameter(23,Types.VARCHAR);
			cstmt.registerOutParameter(24,Types.VARCHAR);
			cstmt.registerOutParameter(25,Types.VARCHAR);
			cstmt.execute();
			err_text+=checkForNull(cstmt.getString(23));
			err_text+=checkForNull(cstmt.getString(24));
			err_text+=checkForNull(cstmt.getString(25));
			mesg_id=checkForNull(cstmt.getString(24));
			if(!err_text.equals("")){
				err_desc+=getMessag(con,mesg_id);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				con.rollback();
			}
			else{				
				con.commit();
			}
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
				if(stmt!=null)    stmt.close();
				if(rst!=null)     rst.close();
				if(pstmt2!=null)  pstmt2.close();
				if(stmt_bl!=null) stmt_bl.close();
				if(rst_bl!=null)  rst_bl.close();
             }catch(Exception es){es.printStackTrace();}
        }
	return (err_desc.equals(""))?"SUCCESS":err_desc;
 }

 public String updateRecRoomPopulateIntercaceRecsOTF(Connection con,Properties prop,HashMap CommonData){
	CallableStatement cstmt= null;
	Statement stmt=null;
	Statement stmt_bl=null;
	ResultSet rst=null;
	ResultSet rst_bl=null;
	String locale	= prop.getProperty("LOCALE");
	String addedById = prop.getProperty( "login_user" ) ;

	String err_text			= "";
	String err_desc		= "";
	String mesg_id			= "";
	String flag="SUCCESS";
	String encounter_id="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String patient_class="";
	String bl_episode_type="";
	String pract_code_val = "";
	String[] pract_arr=null;

	String oper_num=(String)CommonData.get("oper_num");
	String recv_bl_accession_num=(String)CommonData.get("recv_bl_accession_num");
	String rec_room_code=(String)CommonData.get("rec_room_code");
	String modified_charge_units=(String)CommonData.get("modified_charge_units");
	String serv_code=(String)CommonData.get("serv_code");
	String patient_id=(String)CommonData.get("patient_id");
	String surgeon_code=(String)CommonData.get("surgeon_code");
	String login_at_ws_no=(String)CommonData.get("login_at_ws_no");
	String facility_id=(String)CommonData.get("facility_id");
	String include_exclude1=(String)CommonData.get("include_exclude1");
	String action_reason_code1=(String)CommonData.get("action_reason_code1");
	String bl_panel_str_reco=(String)CommonData.get("bl_panel_str_reco");

	 if(("").equals(bl_panel_str_reco)||("null").equals(bl_panel_str_reco))
	 {
		 bl_panel_str_reco=null;
	 }
	try{
		if(bl_panel_str_reco!=null)
		{
			pract_arr=bl_panel_str_reco.split("#");
			pract_code_val=pract_arr[5];
		}

		stmt=con.createStatement();
		String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' ";
		//Added(facility_id) Against KDAH-scf-500
		rst=stmt.executeQuery(sql);
		if(rst !=null && rst.next())
		{
			encounter_id=rst.getString("ENCOUNTER_ID");
			episode_id=rst.getString("EPISODE_ID");
			episode_type=rst.getString("EPISODE_TYPE");
			visit_id=rst.getString("VISIT_ID");
			patient_class=rst.getString("PATIENT_CLASS");
			if(visit_id ==null) visit_id="";
		}
		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		stmt_bl = con.createStatement();
		rst_bl=stmt_bl.executeQuery(sql_bl_epi_type);
		if(rst_bl !=null && rst_bl.next())
		{
			bl_episode_type=checkForNull(rst_bl.getString(1));
		 }
			cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			cstmt.setString(1,"OTF");	//
			cstmt.setString(2,facility_id);
			cstmt.setString(3,bl_episode_type);//Episode Type
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,recv_bl_accession_num);//accession_num
			cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,recv_bl_accession_num);//accession_num
			cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,serv_code);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,rec_room_code);//rec_room_code
			cstmt.setString(16,"");//rec_room_desc
			cstmt.setString(17,modified_charge_units);//modified_charge_units
			/*Added by Suma inoder to pass the modified pract id when changed in billing window on 7/03/2010 as per site req*/
		   if(("").equals(pract_code_val)||("null").equals(pract_code_val))
            {
	          pract_code_val=null;
            }

		   if(pract_code_val!=null)
			{
			cstmt.setString(18,pract_code_val );
			}else
			{
			cstmt.setString(18,surgeon_code );
			}
			/*Added by Suma ends here*/

			cstmt.setString(19,include_exclude1);//surgeon_code
			cstmt.setString(20,action_reason_code1);//surgeon_code
			cstmt.setString(21,addedById);//login_id  ---> to be change
			cstmt.setString(22,login_at_ws_no);//ws_no
			cstmt.registerOutParameter(23,Types.VARCHAR);
			cstmt.registerOutParameter(24,Types.VARCHAR);
			cstmt.registerOutParameter(25,Types.VARCHAR);
			cstmt.execute();
			err_text+=checkForNull(cstmt.getString(23));
			err_text+=checkForNull(cstmt.getString(24));
			err_text+=checkForNull(cstmt.getString(25));
			mesg_id=checkForNull(cstmt.getString(24));
			if(!err_text.equals("")){
				err_desc+=getMessag(con,mesg_id);
			if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				con.rollback();
			}
			else{					
				flag=updateRecRoomProcessIntercaceRecs(con,addedById,patient_id,encounter_id,episode_id,bl_episode_type, visit_id,recv_bl_accession_num,rec_room_code,locale,login_at_ws_no,facility_id);
				if(!"SUCCESS".equals(flag) ) {
                     err_desc+=flag;
					 con.rollback();
				}
			}
			cstmt.close();
		}
		catch ( Exception e ){
	        e.printStackTrace();
		}finally {
            try{
			 if(stmt!=null)    stmt.close();
			 if(rst!=null)     rst.close();
			 if(stmt_bl!=null) stmt_bl.close();
			 if(rst_bl!=null)  rst_bl.close();
            }catch(Exception es){es.printStackTrace();}
        }
		return (err_desc.equals(""))?"SUCCESS":err_desc;
 }

 public String updateRecRoomProcessIntercaceRecs(Connection con,String addedById,String patient_id,String encounter_id,String episode_id,String episode_type,String visit_id,String recv_bl_accession_num,String rec_room_code,String locale,String login_at_ws_no,String facility_id){
	CallableStatement cstmt= null;
	String err_text			= "";
	String err_desc		= "";
	String mesg_id			= "";
	try{
			cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.process_interfaced_rec(?,?,?,?,?,?, ?,?,?,?,?,?,?)}");
			cstmt.setString(1,facility_id);//facility_id
			cstmt.setString(2,patient_id);//Patient_id
			cstmt.setString(3,episode_type);//Episode Type
			cstmt.setString(4,episode_id);//Episode Id
			cstmt.setString(5,visit_id);//visit_id
			cstmt.setString(6,recv_bl_accession_num);//accession_num
			cstmt.setString(7,"OT");
			cstmt.setString(8,recv_bl_accession_num);//accession_num
			cstmt.setString(9,addedById);//login_id  ---> to be change
			cstmt.setString(10,login_at_ws_no);//ws_no
			cstmt.registerOutParameter(11,Types.VARCHAR);
			cstmt.registerOutParameter(12,Types.VARCHAR);
			cstmt.registerOutParameter(13,Types.VARCHAR);
			cstmt.execute();
			err_text+=checkForNull(cstmt.getString(11));
			err_text+=checkForNull(cstmt.getString(12));
			err_text+=checkForNull(cstmt.getString(13));
			mesg_id=checkForNull(cstmt.getString(12));
			if(!err_text.equals("")){
				err_desc+=getMessag(con,mesg_id);
				err_text="";
				con.rollback();
			}else{
				//con.commit();
			}
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
             }catch(Exception es){es.printStackTrace();}
        }
		 return (err_desc.equals(""))?"SUCCESS":err_desc;
	}

public String updateOperRoomPopulateIntercaceRecsOTR(Connection con,Properties prop,HashMap CommonData){
	CallableStatement cstmt= null;
	Statement stmt=null;
	Statement stmt_bl=null;
	ResultSet rst=null;
	ResultSet rst_bl=null;
	String addedById = prop.getProperty( "login_user" ) ;
	String err_desc		= "";
	String encounter_id="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String err_text="";
	String mesg_id="";
	String patient_class="";
	String bl_episode_type="";
	PreparedStatement pstmt3 = null;
	//String pract_code_val = ""; //Commented Against AAKH-ICN-0008
	//String[] pract_arr=null; //Commented Against AAKH-ICN-0008

	int or=0;
	String oper_num=(String)CommonData.get("oper_num");
	String or_bl_accession_num=(String)CommonData.get("or_bl_accession_num");
	String oper_room_code_or=(String)CommonData.get("oper_room_code_or");
	String modified_charge_units_or=(String)CommonData.get("modified_charge_units_or");
	String serv_code_or=(String)CommonData.get("serv_code_or");
	String patient_id=(String)CommonData.get("patient_id");
	String surgeon_code=(String)CommonData.get("surgeon_code");
	String login_at_ws_no=(String)CommonData.get("login_at_ws_no");
	String facility_id=(String)CommonData.get("facility_id");
	String include_exclude_or=(String)CommonData.get("include_exclude_or");
	String action_reason_code_or=(String)CommonData.get("action_reason_code_or");

	try{
			stmt=con.createStatement();
			String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' ";
			//Added(facility_id) Against KDAH-scf-500
			rst=stmt.executeQuery(sql);
			if(rst !=null && rst.next())
			{
				encounter_id=rst.getString("ENCOUNTER_ID");
				episode_id=rst.getString("EPISODE_ID");
				episode_type=rst.getString("EPISODE_TYPE");
				visit_id=rst.getString("VISIT_ID");
				patient_class=rst.getString("PATIENT_CLASS");
				if(visit_id ==null) visit_id="";
			}
		String sql_update_or="UPDATE 	OT_POST_OPER_HDR SET OR_CHARGEABLE_UNITS  ='"+modified_charge_units_or+"' WHERE   OPERATING_FACILITY_ID	='"+facility_id+"' AND	OPER_NUM = '"+oper_num+"'";
		pstmt3 = con.prepareStatement(sql_update_or);
		or=pstmt3.executeUpdate();
		con.commit();

		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		stmt_bl = con.createStatement();
		rst_bl=stmt_bl.executeQuery(sql_bl_epi_type);
		if(rst_bl !=null && rst_bl.next())
		{
			bl_episode_type=checkForNull(rst_bl.getString(1));
		}
			cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			cstmt.setString(1,"OTR");	//
			cstmt.setString(2,facility_id);
			cstmt.setString(3,bl_episode_type);//Episode Type
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,or_bl_accession_num);//accession_num
			cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,or_bl_accession_num);//accession_num
			cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,serv_code_or);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,oper_room_code_or);//holding_bay_code
			cstmt.setString(16,"");//holding_bay_desc
			cstmt.setString(17,modified_charge_units_or);//modified_charge_units
			cstmt.setString(18,surgeon_code);//surgeon_code
			cstmt.setString(19,include_exclude_or);//surgeon_code
			cstmt.setString(20,action_reason_code_or);//surgeon_code
			cstmt.setString(21,addedById);//login_id  ---> to be change
			cstmt.setString(22,login_at_ws_no);//ws_no			
			cstmt.registerOutParameter(23,Types.VARCHAR);
			cstmt.registerOutParameter(24,Types.VARCHAR);
			cstmt.registerOutParameter(25,Types.VARCHAR);
			cstmt.execute();
			err_text=checkForNull(cstmt.getString(23));
			err_text=checkForNull(cstmt.getString(24));
			err_text=checkForNull(cstmt.getString(25));
			mesg_id=checkForNull(cstmt.getString(24));
			if(!err_text.equals("")){
				err_desc+=getMessag(con,mesg_id);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				con.rollback();
			}
			else{
				con.commit();				
			}
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
				if(stmt!=null)    stmt.close();
				if(rst!=null)     rst.close();
				if(pstmt3!=null)  pstmt3.close();
				if(stmt_bl!=null) stmt_bl.close();
				if(rst_bl!=null)  rst_bl.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return (err_desc.equals(""))?"SUCCESS":err_desc;
}

public String updateOperRoomPopulateIntercaceRecsOTF(Connection con,Properties prop,HashMap CommonData){
	CallableStatement cstmt= null;
	Statement stmt=null;
	Statement stmt_bl=null;
	ResultSet rst=null;
	ResultSet rst_bl=null;
	String locale	= prop.getProperty("LOCALE");
	String addedById = prop.getProperty( "login_user" ) ;
	String flag="SUCCESS";
	String err_desc		= "";
	String encounter_id="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String err_text="";
	String mesg_id="";
	String patient_class="";
	String bl_episode_type="";
	//String pract_code_val = ""; //Commented Against AAKH-ICN-0008
	//String[] pract_arr=null;	//Commented Against AAKH-ICN-0008
	String oper_num=(String)CommonData.get("oper_num");
	String or_bl_accession_num=(String)CommonData.get("or_bl_accession_num");
	String oper_room_code_or=(String)CommonData.get("oper_room_code_or");
	String modified_charge_units_or=(String)CommonData.get("modified_charge_units_or");
	String serv_code_or=(String)CommonData.get("serv_code_or");
	String patient_id=(String)CommonData.get("patient_id");
	String surgeon_code=(String)CommonData.get("surgeon_code");
	String login_at_ws_no=(String)CommonData.get("login_at_ws_no");
	String facility_id=(String)CommonData.get("facility_id");
	String include_exclude_or=(String)CommonData.get("include_exclude_or");
	String action_reason_code_or=(String)CommonData.get("action_reason_code_or");

	try{
			stmt=con.createStatement();
			String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' ";
			//Added(facility_id) Against KDAH-scf-500
			rst=stmt.executeQuery(sql);
			if(rst !=null && rst.next())
			{
				encounter_id=rst.getString("ENCOUNTER_ID");
				episode_id=rst.getString("EPISODE_ID");
				episode_type=rst.getString("EPISODE_TYPE");
				visit_id=rst.getString("VISIT_ID");
				patient_class=rst.getString("PATIENT_CLASS");
				if(visit_id ==null) visit_id="";
			}
		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		stmt_bl = con.createStatement();
		rst_bl=stmt_bl.executeQuery(sql_bl_epi_type);
		  if(rst_bl !=null && rst_bl.next())
		  {
			bl_episode_type=checkForNull(rst_bl.getString(1));
		  }
		cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,?,?,?)}");
		cstmt.setString(1,"OTF");	//
		cstmt.setString(2,facility_id);
		cstmt.setString(3,bl_episode_type);//Episode Type
		cstmt.setString(4,patient_id);//Patient_id
		cstmt.setString(5,episode_id);//Episode Id
		cstmt.setString(6,visit_id);//visit_id
		cstmt.setString(7,or_bl_accession_num);//accession_num
		cstmt.setString(8,"1");//Primary Key main --line_num
		cstmt.setString(9,"OT");
		cstmt.setString(10,or_bl_accession_num);//accession_num
		cstmt.setString(11,"1");//Secondday key main --- line_num
		cstmt.setString(12,"S");//Service
		cstmt.setString(13,serv_code_or);//service_code
		cstmt.setString(14,"OTF");//OTF
		cstmt.setString(15,oper_room_code_or);//holding_bay_code
		cstmt.setString(16,"");//holding_bay_desc
		cstmt.setString(17,modified_charge_units_or);//modified_charge_units
		cstmt.setString(18,surgeon_code);//surgeon_code
		cstmt.setString(19,include_exclude_or);//surgeon_code
		cstmt.setString(20,action_reason_code_or);//surgeon_code
		cstmt.setString(21,addedById);//login_id  ---> to be change
		cstmt.setString(22,login_at_ws_no);//ws_no
		cstmt.registerOutParameter(23,Types.VARCHAR);
		cstmt.registerOutParameter(24,Types.VARCHAR);
		cstmt.registerOutParameter(25,Types.VARCHAR);
		cstmt.execute();
		err_text=checkForNull(cstmt.getString(23));
		err_text=checkForNull(cstmt.getString(24));
		err_text=checkForNull(cstmt.getString(25));
		mesg_id=checkForNull(cstmt.getString(24));
		if(!err_text.equals("")){
			err_desc+=getMessag(con,mesg_id);
			if(("").equals(err_desc))
			err_desc+=err_text;
			err_text="";
			con.rollback();
		}
		else{					flag=updateHoldingAreaProcessIntercaceRecs(con,addedById,patient_id,encounter_id,episode_id,bl_episode_type, visit_id,or_bl_accession_num,oper_room_code_or,locale,login_at_ws_no,facility_id);
		if(!"SUCCESS".equals(flag) ) {
			 err_desc+=flag;
			 con.rollback();
			}
		}
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
				if(stmt!=null)    stmt.close();
				if(rst!=null)     rst.close();
				if(stmt_bl!=null) stmt_bl.close();
				if(rst_bl!=null)  rst_bl.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return (err_desc.equals(""))?"SUCCESS":err_desc;
}

public String updateHoldingAreaProcessIntercaceRecs(Connection con,String addedById,String patient_id,String encounter_id,String episode_id,String episode_type,String visit_id,String or_bl_accession_num,String oper_room_code_or,String locale,String login_at_ws_no,String facility_id){
	CallableStatement cstmt= null;
	String err_desc		= "";
	String err_text     ="";
	String mesg_id="";

	try{
		cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.process_interfaced_rec(?,?,?,?,?,?, ?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id);//facility_id
		cstmt.setString(2,patient_id);//Patient_id
		cstmt.setString(3,episode_type);//Episode Type
		cstmt.setString(4,episode_id);//Episode Id
		cstmt.setString(5,visit_id);//visit_id
		cstmt.setString(6,or_bl_accession_num);//accession_num
		cstmt.setString(7,"OT");
		cstmt.setString(8,or_bl_accession_num);//accession_num
		cstmt.setString(9,addedById);//login_id  ---> to be change
		cstmt.setString(10,login_at_ws_no);//ws_no
		cstmt.registerOutParameter(11,Types.VARCHAR);
		cstmt.registerOutParameter(12,Types.VARCHAR);
		cstmt.registerOutParameter(13,Types.VARCHAR);
		cstmt.execute();
		err_text=checkForNull(cstmt.getString(11));
		err_text=checkForNull(cstmt.getString(12));
		err_text=checkForNull(cstmt.getString(13));
		mesg_id=checkForNull(cstmt.getString(12));
		if(!err_text.equals("")){
			err_desc+=getMessag(con,mesg_id);
			err_text="";
			con.rollback();
		}else{
			//con.commit();
		}
		cstmt.close();
	}
	catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
		 }catch(Exception es){es.printStackTrace();}
	}
	return (err_desc.equals(""))?"SUCCESS":err_desc;
}

public String updateHoldingAreaPopulateIntercaceRecsOTR(Connection con,Properties prop,HashMap CommonData){
	CallableStatement cstmt= null;
	Statement stmt=null;
	Statement stmt_bl=null;
	ResultSet rst=null;
	ResultSet rst_bl=null;
	String addedById = prop.getProperty( "login_user" ) ;
	String err_desc		= "";
	String encounter_id="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String charge_units="";
	String bl_accession_num="";
	String holding_area_code="";
	String modified_charge_units="";
	String serv_code_ha="";
	String err_text="";
	String mesg_id="";
	String patient_class="";
	String bl_episode_type="";
	String chk_in_ha_date_time="";
	String chk_out_ha_date_time="";
	String calc_charge_units="";
	String holding_seq_num="";
	String status	  = "";
	//String pract_code_val = "";	//Commented Against AAKH-ICN-0008
	//String[] pract_arr=null;	//Commented Against AAKH-ICN-0008
	PreparedStatement pstmt4 = null;
	int ha=0;

	try{
		String final_val=( String ) CommonData.get( "final_val" );
		String login_at_ws_no=(String)CommonData.get("login_at_ws_no");
		String facility_id=(String)CommonData.get("facility_id");
		String oper_num=(String)CommonData.get("oper_num");
		String patient_id=(String)CommonData.get("patient_id");
		String surgeon_code=(String)CommonData.get("surgeon_code");
		String include_exclude_ha="";
		String action_reason_code_ha="";

		stmt=con.createStatement();
		String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' ";
		//Added(facility_id) Against KDAH-scf-500
		rst=stmt.executeQuery(sql);
		if(rst !=null && rst.next())
		{
			encounter_id=rst.getString("ENCOUNTER_ID");
			episode_id=rst.getString("EPISODE_ID");
			episode_type=rst.getString("EPISODE_TYPE");
			visit_id=rst.getString("VISIT_ID");
			patient_class=rst.getString("PATIENT_CLASS");
			if(visit_id ==null) visit_id="";
		}

		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		stmt_bl = con.createStatement();
		rst_bl=stmt_bl.executeQuery(sql_bl_epi_type);
		if(rst_bl !=null && rst_bl.next())
		{
			bl_episode_type=checkForNull(rst_bl.getString(1));
		}
		StringTokenizer sec_sel_st1 = new StringTokenizer(final_val,"@@");
		while(sec_sel_st1.hasMoreTokens())
		{
			String sec_sel_str1=sec_sel_st1.nextToken();
			StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,"$$");
			while(sec_sel_st2.hasMoreTokens())
			{
			 charge_units=sec_sel_st2.nextToken();
			 bl_accession_num=sec_sel_st2.nextToken();
			 holding_area_code=sec_sel_st2.nextToken();
			 modified_charge_units=sec_sel_st2.nextToken();
			 serv_code_ha=sec_sel_st2.nextToken();
			 chk_in_ha_date_time=sec_sel_st2.nextToken();
			 chk_out_ha_date_time=sec_sel_st2.nextToken();
			 calc_charge_units=sec_sel_st2.nextToken();
			 holding_seq_num=sec_sel_st2.nextToken();
			 include_exclude_ha=sec_sel_st2.nextToken();
			 action_reason_code_ha=sec_sel_st2.nextToken();

			if(("null").equals(include_exclude_ha)) include_exclude_ha="";
			if(("null").equals(action_reason_code_ha)) action_reason_code_ha="";
		    if(!("").equals(modified_charge_units))
			{
				String sql_update_ha="UPDATE OT_OPER_HOLDING_DTLS SET CHARGEABLE_UNITS  ='"+modified_charge_units+"' WHERE   OPERATING_FACILITY_ID= '"+facility_id+"' AND	OPER_NUM = '"+oper_num+"' AND HOLDING_SEQ_NUM='"+holding_seq_num+"' AND   HOLDING_AREA_CODE ='"+holding_area_code+"'";
				pstmt4 = con.prepareStatement(sql_update_ha);
				ha=pstmt4.executeUpdate();
				if(pstmt4!=null)  pstmt4.close();
				con.commit();

				cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
				cstmt.setString(1,"OTR");	//
				cstmt.setString(2,facility_id);
				cstmt.setString(3,bl_episode_type);//Episode Type (For all patiend classes i.e Dc, emergency,IP,OP)
				cstmt.setString(4,patient_id);//Patient_id
				cstmt.setString(5,episode_id);//Episode Id
				cstmt.setString(6,visit_id);//visit_id
				cstmt.setString(7,bl_accession_num);//accession_num
				cstmt.setString(8,holding_seq_num);//Primary Key main --line_num
				cstmt.setString(9,"OT");
				cstmt.setString(10,bl_accession_num);//accession_num
				cstmt.setString(11,holding_seq_num);//Secondday key main --- line_num
				cstmt.setString(12,"S");//Service
				cstmt.setString(13,serv_code_ha);//service_code
				cstmt.setString(14,"OTF");//OTF
				cstmt.setString(15,holding_area_code);//holding_bay_code
				cstmt.setString(16,"");//holding_bay_desc
				cstmt.setString(17,charge_units);//modified_charge_units
				cstmt.setString(18,surgeon_code);//surgeon_code
				cstmt.setString(19,include_exclude_ha);//surgeon_code
				cstmt.setString(20,action_reason_code_ha);//surgeon_code
				cstmt.setString(21,addedById);//login_id  ---> to be change
				cstmt.setString(22,login_at_ws_no);//ws_no				
				cstmt.registerOutParameter(23,Types.VARCHAR);
				cstmt.registerOutParameter(24,Types.VARCHAR);
				cstmt.registerOutParameter(25,Types.VARCHAR);
				cstmt.execute();
				err_text=checkForNull(cstmt.getString(23));
				err_text=checkForNull(cstmt.getString(24));
				err_text=checkForNull(cstmt.getString(25));
				mesg_id=checkForNull(cstmt.getString(24));
				if(!err_text.equals("")){
					err_desc+=getMessag(con,mesg_id);
				 if(("").equals(err_desc))
					err_desc+=err_text;
					err_text="";
					con.rollback();
				}else{
					con.commit();
				  }
				if(!("E").equals(status)){
				cstmt.close();
				}
			}
			}
		}
	}catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
				if(stmt!=null)    stmt.close();
				if(rst!=null)     rst.close();
				if(stmt_bl!=null)  stmt_bl.close();
				if(rst_bl!=null)  rst_bl.close();
				if(pstmt4!=null)  pstmt4.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return (err_desc.equals(""))?"SUCCESS":err_desc;
	}

public String updateHoldingAreaPopulateIntercaceRecsOTF(Connection con,Properties prop,HashMap CommonData){
		CallableStatement cstmt= null;
		Statement stmt=null;
		Statement stmt_bl=null;
		ResultSet rst=null;
		ResultSet rst_bl=null;
		String locale	= prop.getProperty("LOCALE");
		String addedById = prop.getProperty( "login_user" ) ;
		String flag="SUCCESS";
		String err_desc		= "";
		String encounter_id="";
		String episode_id="";
		String episode_type="";
		String visit_id="";
		String charge_units="";
		String bl_accession_num="";
		String holding_area_code="";
		String modified_charge_units="";
		String serv_code_ha="";
		String err_text="";
		String mesg_id="";
		String patient_class="";
		String bl_episode_type="";
		String chk_in_ha_date_time="";
		String chk_out_ha_date_time="";
		String calc_charge_units="";
		String holding_seq_num="";
		String include_exclude_ha="";
		String action_reason_code_ha="";
		//String pract_code_val = ""; //Commented Against AAKH-ICN-0008
		//String[] pract_arr=null;	//Commented Against AAKH-ICN-0008
		try{
			String final_val=( String ) CommonData.get( "final_val" );
			String login_at_ws_no=(String)CommonData.get("login_at_ws_no");
			String facility_id=(String)CommonData.get("facility_id");
			String oper_num=(String)CommonData.get("oper_num");
			String patient_id=(String)CommonData.get("patient_id");
			String surgeon_code=(String)CommonData.get("surgeon_code");

			stmt=con.createStatement();
			String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' ";
			//Added(facility_id) Against KDAH-scf-500	
			rst=stmt.executeQuery(sql);

			if(rst !=null && rst.next())
			{
				encounter_id=rst.getString("ENCOUNTER_ID");
				episode_id=rst.getString("EPISODE_ID");
				episode_type=rst.getString("EPISODE_TYPE");
				visit_id=rst.getString("VISIT_ID");
				patient_class=rst.getString("PATIENT_CLASS");
				if(visit_id ==null) visit_id="";
			}

		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		stmt_bl = con.createStatement();
		rst_bl=stmt_bl.executeQuery(sql_bl_epi_type);
		if(rst_bl !=null && rst_bl.next())
		{
			bl_episode_type=checkForNull(rst_bl.getString(1));
		}
			StringTokenizer sec_sel_st1 = new StringTokenizer(final_val,"@@");
			while(sec_sel_st1.hasMoreTokens())
			{
				String sec_sel_str1=sec_sel_st1.nextToken();
				StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,"$$");
				while(sec_sel_st2.hasMoreTokens())
				{
				 charge_units=sec_sel_st2.nextToken();
				 bl_accession_num=sec_sel_st2.nextToken();
				 holding_area_code=sec_sel_st2.nextToken();
				 modified_charge_units=sec_sel_st2.nextToken();
				 serv_code_ha=sec_sel_st2.nextToken();
				 chk_in_ha_date_time=sec_sel_st2.nextToken();
				 chk_out_ha_date_time=sec_sel_st2.nextToken();
				 calc_charge_units=sec_sel_st2.nextToken();
				 holding_seq_num=sec_sel_st2.nextToken();
				 include_exclude_ha=sec_sel_st2.nextToken();
				 action_reason_code_ha=sec_sel_st2.nextToken();

                 if(("null").equals(include_exclude_ha)) include_exclude_ha="";
				 if(("null").equals(action_reason_code_ha)) action_reason_code_ha="";

			if(!("").equals(modified_charge_units))
			{
			cstmt=con.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			cstmt.setString(1,"OTF");	//
			cstmt.setString(2,facility_id);
			cstmt.setString(3,bl_episode_type);//Episode Type (For all patiend classes i.e Dc, emergency,IP,OP)
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,bl_accession_num);//accession_num
			cstmt.setString(8,holding_seq_num);//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,bl_accession_num);//accession_num
			cstmt.setString(11,holding_seq_num);//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,serv_code_ha);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,holding_area_code);//holding_bay_code
			cstmt.setString(16,"");//holding_bay_desc
			cstmt.setString(17,charge_units);//modified_charge_units
			cstmt.setString(18,surgeon_code);//surgeon_code
			cstmt.setString(19,include_exclude_ha);//surgeon_code
			cstmt.setString(20,action_reason_code_ha);//surgeon_code
			cstmt.setString(21,addedById);//login_id  ---> to be change
			cstmt.setString(22,login_at_ws_no);//ws_no
			cstmt.registerOutParameter(23,Types.VARCHAR);
			cstmt.registerOutParameter(24,Types.VARCHAR);
			cstmt.registerOutParameter(25,Types.VARCHAR);
			cstmt.execute();
			err_text=checkForNull(cstmt.getString(23));
			err_text=checkForNull(cstmt.getString(24));
			err_text=checkForNull(cstmt.getString(25));
			mesg_id=checkForNull(cstmt.getString(24));
			if(!err_text.equals("")){
				err_desc+=getMessag(con,mesg_id);
			  if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				con.rollback();
			}else{
				flag=updateHoldingAreaProcessIntercaceRecs(con,addedById,patient_id,encounter_id,episode_id,bl_episode_type, visit_id,bl_accession_num,holding_area_code,locale,login_at_ws_no,facility_id);// this is same for Holding Area and Operation Room so calling same function
				if(!"SUCCESS".equals(flag) ) {
                     err_desc+=flag;
					 con.rollback();
					}
			  }
            cstmt.close();
			}
			}
		}
	}catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
				if(stmt!=null)    stmt.close();
				if(rst!=null)     rst.close();
				if(stmt_bl!=null) stmt_bl.close();
				if(rst_bl!=null)  rst_bl.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return (err_desc.equals(""))?"SUCCESS":err_desc;
	}


public ArrayList executeTransactions(Connection con,ArrayList tabData,HashMap CommonData){
	ArrayList result_array = new ArrayList();
	/* result_array will have the following
	 1. boolean flag true/false for transaction execution
	 2. modified tabData ArrayList. Modified to include the key_line field for surgical accessories
	*/
	System.err.println("1456,==tabData==executeTransactions=="+tabData);
	System.err.println("1457,==CommonData==executeTransactions=="+CommonData);
	PreparedStatement pstmt = null;
	HashMap hash=null;
	String key ="";
	String key_line="";
	String pros_implants_compyn=checkForNull(( String ) CommonData.get( "pros_implants_yn" ));
	String cons_packs_compyn=checkForNull(( String ) CommonData.get( "cons_packs_yn" ));
	String locale = (String)CommonData.get("locale");//048580
	int size=0;
	String success_flag_yn = "N"; // Initialize
	String insert_flag = ""; // Initialize
	try
	{
	 size = tabData.size();
	 for(int i=0;i<size;i++)
	 {
		 hash=(HashMap) tabData.get(i);
		 System.err.println("1476,==hash==executeTransactions=="+hash);
		 if(hash!=null)
		 {
			key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
			System.err.println("==key==executeTransactions=="+key);
			System.err.println("==stmt_hash==executeTransactions=="+stmt_hash);
			insert_flag=(String) hash.get("insert_flag");
			if(("Accessories").equals(insert_flag))
				pstmt = (PreparedStatement) stmt_hash.get(key);

			if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_I"))
			{
				key_line = getBillSubRegnLineNum(con,(String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );
				hash.put("key_line",key_line);
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("instr_code"));
				pstmt.setString(6,(String)hash.get("accessory_type"));
				String trayNoVal = ((String)hash.get("tray_no"));
				if(!trayNoVal.equals(""))
					trayNoVal = java.net.URLDecoder.decode(trayNoVal,"UTF-8");
				pstmt.setString(7,trayNoVal);
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(8,remarksVal);
				pstmt.setString(9,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(11,(String)CommonData.get("facility_id"));
				pstmt.setString(12,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(13,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(14,(String)CommonData.get("facility_id"));
				pstmt.setString(15,"S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				pstmt.setString(16,key_line);
				pstmt.setString(17,(String)hash.get("quantity"));
			 }
			 else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_U"))
			 {
				String trayNoVal = ((String)hash.get("tray_no"));
				if(!trayNoVal.equals(""))
					trayNoVal = java.net.URLDecoder.decode(trayNoVal,"UTF-8");
				pstmt.setString(1,trayNoVal);
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(2,remarksVal);
				pstmt.setString(3,(String)hash.get("quantity"));
				pstmt.setString(4,(String)CommonData.get("facility_id"));
				pstmt.setString(5,(String) hash.get("oper_num"));
				pstmt.setString(6,(String) hash.get("oper_code"));
				pstmt.setString(7,(String) hash.get("oper_line_no"));
				pstmt.setString(8,(String) hash.get("instr_code"));
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_D"))
			{
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String) hash.get("instr_code"));
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_I"))
			{
				key_line = getBillSubRegnLineNum( con,(String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );
				hash.put("key_line",key_line);
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("equip_code"));
				pstmt.setString(6,(String)hash.get("accessory_type"));
				pstmt.setString(7,(String)hash.get("equip_id"));
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(8,remarksVal);
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
			else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_U"))
			{
				pstmt.setString(1,(String)hash.get("equip_id"));
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(2,remarksVal);
				pstmt.setString(3,(String)hash.get("quantity"));
			if(locale != null && locale.equals("th"))
				pstmt.setString(4, com.ehis.util.DateUtils.convertDate((String)hash.get("desiredDate"),"DMYHM", locale, "en"));
			else
				pstmt.setString(4,(String)hash.get("desiredDate"));
				pstmt.setString(5,(String)CommonData.get("facility_id"));
				pstmt.setString(6,(String) hash.get("oper_num"));
				pstmt.setString(7,(String) hash.get("oper_code"));
				pstmt.setString(8,(String) hash.get("oper_line_no"));
				pstmt.setString(9,(String)hash.get("equip_code"));
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_D"))
			{
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("equip_code"));
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_I"))
			{
				key_line = getBillSubRegnLineNum( con,(String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );
				hash.put("key_line",key_line);
				hash.put("nursing_doc",cons_packs_compyn);
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("package_code"));
				pstmt.setString(6,(String)hash.get("accessory_type"));
				pstmt.setString(7,(String)hash.get("quantity"));
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(8,remarksVal);
				pstmt.setString(9,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(11,(String)CommonData.get("facility_id"));
				pstmt.setString(12,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(13,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(14,(String)CommonData.get("facility_id"));
				pstmt.setString(15,"C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				pstmt.setString(16,key_line);
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_U"))
			{
				pstmt.setString(1,(String)hash.get("quantity"));
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(2,remarksVal);
				pstmt.setString(3,(String)CommonData.get("facility_id"));
				pstmt.setString(4,(String) hash.get("oper_num"));
				pstmt.setString(5,(String) hash.get("oper_code"));
				pstmt.setString(6,(String) hash.get("oper_line_no"));
				pstmt.setString(7,(String)hash.get("package_code"));
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_D"))
			{
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("package_code"));
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_I"))
			{
	            String bill_str=(String) hash.get("bill_str");
				String st_interface_flag=( String ) CommonData.get( "st_interface_flag" );
				if(bill_str==null) bill_str="";
				String excl_incl_ind="";
				String action_reason_code="";
				if(!("").equals(bill_str))
			    {
					String[] charge_arr=null;
					charge_arr=bill_str.split("::");
					if(charge_arr.length==6)
						excl_incl_ind=charge_arr[5];
					if(charge_arr.length==9)
						action_reason_code=charge_arr[8];
				}
				if(("null").equals(excl_incl_ind))
					excl_incl_ind="";
				if(("null").equals(action_reason_code))
					action_reason_code="";

				key_line = getBillSubRegnLineNum( con,(String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );
				hash.put("key_line",key_line);
				hash.put("nursing_doc",pros_implants_compyn);
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("implant_code"));
				pstmt.setString(6,(String)hash.get("accessory_type"));
				pstmt.setString(7,(String)hash.get("quantity"));
				pstmt.setString(8,(String)hash.get("manufacturer"));
				pstmt.setString(9,(String)hash.get("batch"));
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(10,remarksVal);
				pstmt.setString(11,(String)hash.get("req_store_code"));
				pstmt.setString(12,(String)hash.get("reserved_qty"));
				pstmt.setString(13,(String)hash.get("requested_qty"));
				pstmt.setString(14,(String)hash.get("sale_document_type"));
				pstmt.setString(15,(String)hash.get("sale_document_no"));
				pstmt.setString(16,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(17,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(18,(String)CommonData.get("facility_id"));
				pstmt.setString(19,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(20,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(21,(String)CommonData.get("facility_id"));
				String st_bill_value=(String)hash.get("sale_document_type")+"-"+(String)hash.get("sale_document_no");
				if(st_interface_flag.equals("Y"))
					pstmt.setString(22,st_bill_value);
				else
					pstmt.setString(22,"I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
		        if(st_interface_flag.equals("Y"))
		        	pstmt.setString(23,"1");
		        else
		        	pstmt.setString(23,key_line);
				pstmt.setString(24,excl_incl_ind);
				pstmt.setString(25,action_reason_code);
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_U"))
			{
	            String st_interface_flag=( String ) CommonData.get( "st_interface_flag" );
				String bill_str=(String) hash.get("bill_str");
				if(bill_str==null) bill_str="";
				String excl_incl_ind="";
				String action_reason_code="";
				key_line = getBillSubRegnLineNum( con,(String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );

				if(!("").equals(bill_str))
			    {
					String[] charge_arr=null;
					charge_arr=bill_str.split("::");
					if(charge_arr.length==6)
						excl_incl_ind=charge_arr[5];
					if(charge_arr.length==9)
						action_reason_code=charge_arr[8];
				}
				if(("null").equals(excl_incl_ind))
					excl_incl_ind="";
				if(("null").equals(action_reason_code))
					action_reason_code="";
				String st_bill_value=(String)hash.get("sale_document_type")+"-"+(String)hash.get("sale_document_no");
				pstmt.setString(1,(String)hash.get("quantity"));
				pstmt.setString(2,(String)hash.get("manufacturer"));
				pstmt.setString(3,(String)hash.get("batch"));
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				pstmt.setString(4,remarksVal);
				pstmt.setString(5,excl_incl_ind);
				pstmt.setString(6,action_reason_code);
	            pstmt.setString(7,(String)hash.get("sale_document_type"));
				pstmt.setString(8,(String)hash.get("sale_document_no"));
				if(st_interface_flag.equals("Y"))
					pstmt.setString(9,st_bill_value);
				else
					pstmt.setString(9,"I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				if(st_interface_flag.equals("Y"))
					pstmt.setString(10,"1");
				else
					pstmt.setString(10,key_line);
				pstmt.setString(11,(String)hash.get("req_store_code"));
				pstmt.setString(12,(String)hash.get("requested_qty"));
				pstmt.setString(13,(String)CommonData.get("facility_id"));
				pstmt.setString(14,(String) hash.get("oper_num"));
				pstmt.setString(15,(String) hash.get("oper_code"));
				pstmt.setString(16,(String) hash.get("oper_line_no"));
				pstmt.setString(17,(String)hash.get("implant_code"));
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_D"))
			{
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("implant_code"));
			}
			int count=0;
			if(("Accessories").equals(insert_flag))
				count = pstmt.executeUpdate();
			else if(("Operation").equals(insert_flag))
				count=1;
			if(count>0)
				success_flag_yn = "Y";
			else
				success_flag_yn = "N";
		}
		else
		{
			success_flag_yn = "Y";
			break;
		}
	 }//end for Loop
	transaction_err_msg = "";
	result_array.add(success_flag_yn);
	result_array.add(tabData);
	}catch(Exception e){
		System.err.println("Admin Function: Err Msg in Execute Process,executeTransactions "+e.getMessage());
		success_flag_yn = "N";
		e.printStackTrace();
		transaction_err_msg = e.getMessage();
		result_array.add(success_flag_yn);
		result_array.add(tabData);
	}finally{
		try{
			pstmt.close();
		}
		catch(Exception e){e.printStackTrace();}
	 }
	 return result_array;
}

public String callBillingProcedure(ArrayList tabData,HashMap CommonData){
	Connection con = null;
	PreparedStatement pstmt = null;
	HashMap hash=null;
	String key ="";
	String st_interface_flag=( String )CommonData.get( "st_interface_flag" );
	String pros_implants_compyn=checkForNull(( String ) CommonData.get( "pros_implants_yn" ));
	String cons_packs_compyn=checkForNull(( String ) CommonData.get( "cons_packs_yn" ));
	String equip_compyn=checkForNull(( String ) CommonData.get( "equipments_yn" ));
	String instr_css_compyn=checkForNull(( String ) CommonData.get( "inst_cssd_yn" ));
	String checkInTime = (String) CommonData.get("checkInTime");
	String customerId = (String) CommonData.get("customerId");
	String err_msg="";
	String err_desc="RECORD_INSERTED";
	int size=0;
	BillingManager billingManager = null;
	boolean flag = false;

	try{
		con = ConnectionManager.getConnection();
		size = tabData.size();
		for(int i=0;i<size;i++){
		hash=(HashMap) tabData.get(i);
		if(hash!=null)
		{
			key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
			System.err.println("==key==callBillingProcedure=="+key);
			pstmt = (PreparedStatement) stmt_hash.get(key);
			if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_I"))
			{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));				
				hash.put("BillRegnNum","S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",instr_css_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,instr_css_compyn,"N",con);
				if(!("RECORD_INSERTED").equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("inst_cssd_yn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 603");
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_U"))
			{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));				
				hash.put("BillRegnNum","S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",instr_css_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,instr_css_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("inst_cssd_yn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 612");

			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_INSTRUMENT_D"))
			{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));				hash.put("BillRegnNum","S"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",instr_css_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,instr_css_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("inst_cssd_yn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 620");
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_I"))
			{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));				
				hash.put("BillRegnNum","E"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",equip_compyn);
				hash.put("desiredDate", (String) hash.get("desiredDate"));
				hash.put("checkInTime", checkInTime);
				hash.put("customerId", customerId);
				
				System.err.println("Hash, (String) hash.get=========>"+(String) hash.get("desiredDate"));
				System.err.println("Hash, checkInTime=========>"+checkInTime);
				System.err.println("Hash, 55555555555=========>"+hash);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,equip_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("equip_compyn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 629");			
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_U"))
			{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","E"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",equip_compyn);
				hash.put("desiredDate", (String) hash.get("desiredDate"));
				hash.put("checkInTime", checkInTime);
				hash.put("customerId", customerId);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);	
				err_desc=billingManager.processBilling1(CommonData,key,equip_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("equip_compyn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 637");
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_EQUIPMENTS_D"))
			{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","E"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",equip_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,equip_compyn,"N",con);
			if(!"RECORD_INSERTED".equals(err_desc))
			{
				con.rollback();
				err_msg+=err_desc;
				CommonData.put("equip_compyn","N");
			}
			billingManager.tearDown("Rec Nursing Manager: 645");
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_I"))
			{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",cons_packs_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,cons_packs_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("equip_compyn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 655");
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_U"))
			{			
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",cons_packs_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,cons_packs_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("cons_packs_compyn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 664");
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_PACKAGES_D"))
			{				
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","C"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",cons_packs_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,cons_packs_compyn,"N",con);
                if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("cons_packs_compyn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 672");
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_I"))
			{
				if(("N").equals(st_interface_flag))
				{				
					hash.put("BillRegnLineNum",(String)hash.get("key_line"));
					hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
			    err_desc=billingManager.processBilling1(CommonData,key,pros_implants_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("pros_implants_yn","N");
				}
				billingManager.tearDown("Rec Nursing Manager: 681");
				}
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_U"))
			{
				if(("N").equals(st_interface_flag))
				{				
					hash.put("BillRegnLineNum",(String)hash.get("key_line"));
					hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,pros_implants_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("pros_implants_yn","N");
				}
					billingManager.tearDown("Rec Nursing Manager: 689");
				}
			}
			else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_D"))
			{
				if(("N").equals(st_interface_flag))
				{				
					hash.put("BillRegnLineNum",(String)hash.get("key_line"));
					hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_compyn);
				billingManager = BillingManager.intializeBillingManager(hash,CommonData);
				err_desc=billingManager.processBilling1(CommonData,key,pros_implants_compyn,"N",con);
				if(!"RECORD_INSERTED".equals(err_desc))
				{
					con.rollback();
					err_msg+=err_desc;
					CommonData.put("pros_implants_yn","N");
				}
					billingManager.tearDown("Rec Nursing Manager: 697");
				}
			}
		}
		else
		{
			flag=true;
			err_msg="";
			break;
		}
		if(!("").equals(err_msg))
		{
			break;
		}
	 }//end for Loop

	 if(("").equals(err_msg))
	 {
	  con.commit();
	  err_msg="RECORD_INSERTED";
	 }
	 else{
		 con.rollback();
	 }
	 transaction_err_msg = "";
	 flag=true;
	}catch(Exception e){
		flag = false;
		e.printStackTrace();
		transaction_err_msg = e.getMessage();
	}finally{
		try{
			pstmt.close();
			con.close();
		}
		catch(Exception e){e.printStackTrace();}
 }
 return err_msg;
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
		System.err.println("Admin Function: Err in closeAllStatement="+ee.getMessage());
	}
  }

    public String updateDocumentationLevel(Connection con,HashMap map){
		System.err.println("2106,updateDocumentationLevel");
	   	CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		String doc_compl_date ="null";
		try{
			if( ( (String) map.get("doc_complete") ).equals("Y")){
				doc_compl_date="TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')";
			}
			cstmt=con.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,null,?,?,null,null,?,null,null,null,null,null,null,null,null,null,null,"+doc_compl_date+",null,null,null,null,null,?,?,?,?,?)}");
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
			if(status.equals("E")){
				error_text = cstmt.getString(11);
				con.rollback();
			}else{
				error_text ="RECORD_INSERTED";
			}
				cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
                if(cstmt!=null) cstmt.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return error_text;
	}

  public String getBillSubRegnLineNum(Connection con,String oper_num,String oper_line_num,String acc_type){
		int result = 0;	//used for billing subregkeyline

		PreparedStatement pstmt= null;
		ResultSet rst = null;
		if(result==0){
		System.err.println("result if=="+result);
		String SQL = "SELECT NVL(MAX(TO_NUMBER(BILL_SUB_REGN_LINE_NUM)),0)+1 FROM OT_SURGICAL_ACCESSORIES WHERE OPER_NUM = ? AND OPER_LINE_NUM=? ";

		try{
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1,oper_num);
				pstmt.setString(2,oper_line_num);
				rst = pstmt.executeQuery();
				while(rst.next()){
					result = rst.getInt(1);
				}
			}
			catch ( Exception e ) {
				e.printStackTrace();
			}finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null)     rst.close();
				 }catch(Exception es){es.printStackTrace();}
			}
		}else
			result++;
		if(result==0)
			result=1;// Default value in case query returns no rows
		return ""+result;
	}

public String GeneratePatientBill(Connection con,HashMap map,HashMap<String,List> bill_map,ArrayList tabData ){
	String[] charge_arr=null;
	String err_desc			= "";
	String oper_desc		= "";
	String key		= "";
	PreparedStatement chargesApplicablePstmt = null;
	StringBuffer chargesApplicableBuffer = new StringBuffer();
	ResultSet chargesApplicableRs = null;
	Statement stmt=null;
	Statement stmt_bl=null;
	ResultSet rst=null;
	ResultSet rst_bl=null;
	String bl_strerrorlevel="";
	String bl_strsysmessageid="";
	String bl_strerrortext="";
	String oper_line_status="";
	String facility_id		= (String)map.get("facility_id") ;
	String patient_id		= (String)map.get("patient_id") ;
	String oper_num			= (String)map.get("oper_num") ;
	String ws_no			= (String)map.get("login_at_ws_no") ;
	String oper_date		= (String)map.get("oper_date") ;
	String surgeon_code		= (String)map.get("surgeon_code") ;
	String oper_compl_yn		= (String)map.get("oper_compl_yn") ;
	String encounter_id="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String patient_class="";
	String bl_episode_type="";
	String[] pract_arr=null;
	String pract_code_val = "";
	String chargesApplicableCheck = "";	//047105
	String sql_oper_lilne_status_exist = "";
	//String dummyString=""; //Commented Against AAKH-ICN-0008
	String checkInTime = (String) map.get("checkInTime");
	System.err.println("2262,==checkInTime==GeneratePatientBill=="+checkInTime);
	String customerId = (String) map.get("customerId");
	System.err.println("2264,==customerId==GeneratePatientBill=="+customerId);

	try
	{
		stmt=con.createStatement();
		String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"'";
		//Added(facility_id) Against KDAH-scf-500
		rst=stmt.executeQuery(sql);
		if(rst !=null && rst.next())
		{
			encounter_id=rst.getString("ENCOUNTER_ID");
			episode_id=rst.getString("EPISODE_ID");
			episode_type=rst.getString("EPISODE_TYPE");
			visit_id=rst.getString("VISIT_ID");
			patient_class=rst.getString("PATIENT_CLASS");
			if(visit_id ==null)
				visit_id="";
		}
		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		stmt_bl = con.createStatement();
		rst_bl=stmt_bl.executeQuery(sql_bl_epi_type);
		if(rst_bl !=null && rst_bl.next())
			bl_episode_type=checkForNull(rst_bl.getString(1));
		//047105 start
		chargesApplicableBuffer.append("	SELECT charges_appl_checkin_yn	");
		chargesApplicableBuffer.append("	FROM ot_param_for_facility	");
		chargesApplicableBuffer.append("	WHERE operating_facility_id = ?	");
		chargesApplicablePstmt = con.prepareStatement(chargesApplicableBuffer.toString());
		chargesApplicablePstmt.setString(1, facility_id);
		chargesApplicableRs = chargesApplicablePstmt.executeQuery();
		while(chargesApplicableRs.next())
			chargesApplicableCheck = checkForNull(chargesApplicableRs.getString("charges_appl_checkin_yn"));
		//047105 end
	}
	catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
				if(stmt!=null)    stmt.close();
				if(rst!=null)     rst.close();
				if(stmt_bl!=null) stmt_bl.close();
				if(rst_bl!=null)  rst_bl.close();
				if(chargesApplicablePstmt!=null)  chargesApplicablePstmt.close(); //Added Against AAKH-ICN-0008
				if(chargesApplicableRs!=null)  chargesApplicableRs.close(); //Added Against AAKH-ICN-0008
             }catch(Exception es){es.printStackTrace();}
        }
	ArrayList list	= getOperationDtls(con,oper_num,facility_id,tabData);
	HashMap hmap = new HashMap();
	Set set = bill_map.keySet();
    Iterator itr = set.iterator();
	String db_mode="";
	boolean found_flag = false;

	int k=0;
		while (itr.hasNext())
		{
		key = (String) itr.next();
		found_flag=false;
		k=0;
			while (k < list.size() && found_flag == false)
			{
			hmap = (HashMap) list.get(k);
			db_mode = checkForNull( (String)hmap.get("db_mode"));
				if (key.equals("" + hmap.get("oper_code")) && (db_mode.equals("U") || db_mode.equals("I") || db_mode.equals("")))
				found_flag=true;
				else
				found_flag = false;
			k++;
		}
		}
		HashMap hash=null;
		HashMap hash1=null;

		Statement stmt1=null;
		ResultSet rset=null;
		CallableStatement cstmt = null;
		hash = null;

		List<String> panel_str	= new ArrayList<String>();
		String oper_line_status_exist="";
	try {
			stmt1=con.createStatement();
			cstmt = con.prepareCall("{call OT_BILLING_PACKAGE.BL_INTERFACE_OPER_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_number(?),?,?,?)}");//047105
			String v_stage = "";
			String v_oper_request_num = "";
			String v_line_num = "";
			System.err.println("2287,==list==OT_BILLING_PACKAGE=="+list);
			for(int i=0;i<list.size();i++)
			{
			   hash = (HashMap) list.get(i);
			   hash1 = (HashMap) tabData.get(i);
			System.err.println("2292,==bill_map==OT_BILLING_PACKAGE=="+bill_map);
			if (bill_map.size() > 0)
			{
				panel_str		=  bill_map.get(hash.get("oper_code") );
				// Added by Suma for passing modified practitioner id to billing on 07/03l2010 as per site requirement
				String panel_str1="";
				if(("").equals(panel_str) || ("null").equals(panel_str))
					panel_str=null;
				if(panel_str!= null)
				{
				panel_str1=panel_str.get(0);
				if(("").equals(panel_str1) || ("null").equals(panel_str1))
				panel_str1=null;

				if(panel_str1!= null)
				{
					pract_arr=panel_str1.split("#");
					if(pract_arr.length > 5)
						pract_code_val=pract_arr[5];
					}
				}
			// Added by Suma ends here
		   // below code is to get the db_mode for the operation. if its I, then mode should be passed as ORD

	    //db_mode = checkForNull( (String)hash1.get("db_mode") );//commented against SKR-SCF-1248
	    db_mode = "U"; //Added against SKR-SCF-1248
		v_oper_request_num	=oper_num;
		v_line_num			=(String)hash.get("oper_line_num");
		oper_line_status	=(String)hash1.get("oper_line_status");

		sql_oper_lilne_status_exist="SELECT OPER_LINE_STATUS FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID ='"+facility_id+"'AND OPER_NUM='"+oper_num+"'AND OPER_LINE_NUM='"+v_line_num+"' ";

		rset=stmt1.executeQuery(sql_oper_lilne_status_exist);
	     if(rset !=null && rset.next())
    	  {
			oper_line_status_exist=rset.getString("OPER_LINE_STATUS");
			if(oper_line_status_exist==null)
			oper_line_status_exist="";
		  }
		  if(rset!=null) rset.close();	//Added Against Common-ICN-0031
		 if(db_mode.equals("D"))
				 v_stage="CAN";
		else if(db_mode.equals("U") || db_mode.equals("I"))
		{
		if (oper_compl_yn.equals("Y") )
		{//when operation/procedures check box checked
			if(oper_line_status_exist.equals("99"))
				v_stage="CAN";
			else
				v_stage="CMP";
		}
		else
		{
			if(oper_line_status_exist.equals("99"))
				v_stage="CAN";
			else
				v_stage="REG";
		}
		}
	  oper_desc=(String) hash.get("oper_desc") ;
	  String overridden_excl_incl_ind="";
	  String action_reason_code="";
	  if(panel_str == null) // Here panel_str is list and it constains panelstring  and bil_str
	  {
		  overridden_excl_incl_ind="";
		  action_reason_code="";
	  }
	 else
	  {
		  String bill_str=panel_str.get(1);
		  charge_arr=bill_str.split("::");
		  if(charge_arr.length==6)
		  overridden_excl_incl_ind=charge_arr[5];
		  if(charge_arr.length==9)
		  action_reason_code=charge_arr[8];
	 }
		cstmt.setString(1,facility_id ); //v_facility_id	VARCHAR2,
		cstmt.setString(2,patient_id );	//v_patient_id	VARCHAR2,
		cstmt.setString(3,episode_id );	//v_episode_id	VARCHAR2,
		cstmt.setString(4,visit_id );	//v_visit VARCHAR2,
		cstmt.setString(5,(String) hash.get("order_id") ); //v_order_id VARCHAR2,
		cstmt.setString(6,(String) hash.get("order_line_num"));//v_ord_line_no VARCHAR2,
		cstmt.setString(7,(String) hash.get("oper_code") );//v_oper_code VARCHAR2,
		cstmt.setString(8, "Y"); // bl_interfaced_yn v_bl_interfaced VARCHAR2,
		cstmt.setString(9,bl_episode_type ); //v_bl_episode_type	VARCHAR2,
		cstmt.setString(10,v_oper_request_num ); //v_oper_request_num	VARCHAR2,
		cstmt.setString(11,v_line_num);//v_line_num VARCHAR2,
		cstmt.setString(12,v_stage );	//v_stage VARCHAR2,
		//047105 start
		if (customerId != null && customerId.equalsIgnoreCase("KDAH"))
		{
			if((chargesApplicableCheck != null && chargesApplicableCheck.equalsIgnoreCase("Y")) && (checkInTime != null && checkInTime.trim().length() > 0))
				cstmt.setString(13, checkInTime);
			else
				cstmt.setString(13, oper_date);
		}
		else
				cstmt.setString(13, oper_date); // v_oper_date VARCHAR2, FORMAT SHOULD BE 'DD/MM/YYYY HH24:MI'
		//047105 end
		// Added by Suma for passing modified practitioner id to billing on 07/03l2010 as per site requirement
		if(("").equals(pract_code_val)||("null").equals(pract_code_val))
			pract_code_val=null;
		if(pract_code_val!=null )
			cstmt.setString(14,pract_code_val);
		else
			cstmt.setString(14,surgeon_code );
			cstmt.setString(15,ws_no ) ; //v_ws_no VARCHAR2,
			cstmt.setString(16,null) ; //v_catalog_code IN OUT VARCHAR2,
			cstmt.setString(17, oper_desc ); //v_oper_desc VARCHAR2,
		if(panel_str == null) //Here panel_str is list and it constains panelstring  and bil_str
			cstmt.setString(18,"");
		else
			cstmt.setString(18, panel_str.get(0));		 

			cstmt.registerOutParameter(19, Types.VARCHAR); // v_serv_panel_ind OUT VARCHAR2,
			cstmt.registerOutParameter(20, Types.VARCHAR); // v_blng_srvc_code OUT VARCHAR2,
			cstmt.registerOutParameter(21, Types.VARCHAR); // v_charge_stage OUT VARCHAR2,
			cstmt.registerOutParameter(22, Types.VARCHAR); // err_code v_err_code OUT VARCHAR2,
			cstmt.registerOutParameter(23, Types.VARCHAR); // sys_mesg_id v_sys_message_id OUT VARCHAR2,
			cstmt.registerOutParameter(24, Types.VARCHAR); // error_text v_error_text OUT VARCHAR2,
			cstmt.registerOutParameter(25, Types.VARCHAR); // v_preapp_msg OUT VARCHAR2,
			cstmt.registerOutParameter(26, Types.VARCHAR); // v_excl_msg OUT VARCHAR2,
			cstmt.registerOutParameter(27, Types.VARCHAR); // LANG_ERR_MSG_ID V_LANG_ERR_MSG_ID OUT VARCHAR2,
			cstmt.setString(28, "N"); // FUTURE_ORDER_YN // P_FUTURE_ORDER_YN VARCHAR2 DEFAULT 'N'

		if(panel_str == null)// Here panel_str is list and it constains panelstring  and bil_str
			cstmt.setString(29,"");// P_AMT
		else
			cstmt.setString(29,panel_str.get(1).split("::")[0]);
			cstmt.setString(30,"OT");//P_calling_stage
		if(("null").equals(overridden_excl_incl_ind))
			cstmt.setString(31,"");
		else
			cstmt.setString(31,overridden_excl_incl_ind);//p_overridden_excl_incl_ind VARCHAR2 default null,
		if(("null").equals(action_reason_code))
			cstmt.setString(32,"");
		else
			cstmt.setString(32,action_reason_code);// p_action_reason_code  VARCHAR2 default null
		cstmt.execute();
			bl_strerrorlevel = checkForNull(cstmt.getString(22));
			bl_strsysmessageid = checkForNull(cstmt.getString(23));
			bl_strerrortext = checkForNull(cstmt.getString(24));
			err_desc=decodeProcedureErrorMsg(con,bl_strerrorlevel,bl_strsysmessageid,bl_strerrortext,"GeneratePatientBill()");
	if (!"RECORD_INSERTED".equals(err_desc))
		break;
	 }
	 //Added against AAKH-SCF-0294
	 else{
		 err_desc="APP-OT0210 Billing Panel String is not available ";
	 }
	 //Added against AAKH-SCF-0294
	}
		if (err_desc.equals("RECORD_INSERTED") && ("Y").equals(oper_compl_yn))  // when operation/procedures check box checked
		err_desc = callBillRecord(con, map, bl_episode_type, episode_id, visit_id);

		if (!err_desc.equals("RECORD_INSERTED"))
			con.rollback();
		else
			con.commit();
	 }catch(Exception e){
		err_desc=e.getMessage();
		e.printStackTrace();
	}finally{
	try{
		hash.clear();
		list.clear();
		if(cstmt!=null) cstmt.close();
		if(stmt1!=null) stmt1.close();
		if(rset!=null)  rset.close();
	}catch(Exception e){e.printStackTrace();}
	}
	return err_desc;
}

public ArrayList getOperationDtls(Connection con,String oper_num,String facility_id, ArrayList tabData){
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	ArrayList list = new ArrayList();
	HashMap result = null;
	HashMap hash = null;
	//String SQL="SELECT A.OPER_CODE,B.SHORT_DESC,NVL(DECODE(A.RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Bilateral','N','Not Applicable'),'Not Applicable') RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.OPER_LINE_NUM OPR_LN_NUM,A.ORDER_LINE_NUM ORD_LN_NUM,A.ORDER_ID ORD_ID FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";
	String SQL="SELECT A.OPER_CODE,B.SHORT_DESC,NVL(DECODE(A.RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Bilateral','N','Not Applicable'),'Not Applicable') RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.OPER_LINE_NUM OPR_LN_NUM,A.ORDER_LINE_NUM ORD_LN_NUM,A.ORDER_ID ORD_ID,A.OPER_LINE_STATUS OPER_STATUS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";
	
	int size = tabData.size();
	int i = 0;
	String oper_code = "";
	//String oper_line_status="";
	boolean found=false;
	try{
		pstmt = con.prepareStatement(SQL) ;
		pstmt.setString(1, facility_id );
		pstmt.setString(2, oper_num );
		resultSet= pstmt.executeQuery();
		while(resultSet.next())
		{
			result = new HashMap();
			oper_code = checkForNull(resultSet.getString("OPER_CODE"));
			result.put("oper_code",oper_code);
			result.put("oper_desc",checkForNull(resultSet.getString("SHORT_DESC")));
			result.put("oper_line_num",checkForNull(resultSet.getString("OPR_LN_NUM"))) ;
			result.put("order_line_num",checkForNull(resultSet.getString("ORD_LN_NUM")) );
			result.put("order_id",checkForNull(resultSet.getString("ORD_ID")) );
			found=false;
			while(found==false && i<size)
			{
				hash=(HashMap)tabData.get(i);
				if(hash!=null){
					if(oper_code.equals((String)hash.get("oper_code")))
					{
						result.put("db_mode",hash.get("db_mode"));
						found=true;
					}					
				}
				i++;
			}
			list.add(result);
		}
	}catch (Exception e){
		   e.printStackTrace();
		  System.err.println("AdministartiveFunction: Err Msg in getOperationalDtls "+e.getMessage());
	}
	finally{
	  try{
			if(resultSet!=null) resultSet.close();
			if(pstmt!=null) pstmt.close();
	  }catch(Exception e){e.printStackTrace();}
	}
	System.err.println("2623,==list=="+list);
	return list;
}

public String decodeProcedureErrorMsg(Connection con, String err_level, String sys_mesg_id, String err_text, String fname)
{
		String err_msg =("".equals(sys_mesg_id))?"RECORD_INSERTED":getMessag(con,sys_mesg_id);
		err_msg = ("".equals(err_text) && "RECORD_INSERTED".equals(err_msg) )?"RECORD_INSERTED":(!"".equals(sys_mesg_id))?err_msg:err_text;
		return err_msg;
	}

public String checkForNull(String str){
	return (  str!=null && str.intern()!="null" )?str:"";
}

public  String getMessag(Connection con,String mesg_id){
		StringBuilder sbr = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String err_desc = "";
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,mesg_id);
		rst = pstmt.executeQuery();
		while(rst.next()){
		err_desc=checkForNull(rst.getString(1));
		}
		}catch(Exception e){
		System.err.println("Err Mesg in getMessage Function"+e);
		}finally{
		try{
		sbr.setLength(0);
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		}catch(Exception e){e.printStackTrace();}
		}
		return err_desc;
   }

    public String callBillRecord(Connection con,HashMap map,String bl_episode_type,String episode_id,String visit_id){
	CallableStatement cstmt = null;
	String err_level="";
	String sys_message_id="";
	String error_text="";
	String facility_id = (String)map.get("facility_id") ;
	String patient_id = (String)map.get("patient_id") ;
	String oper_num =  (String)map.get("oper_num") ;
	String order_id =  (String)map.get("order_id") ;
	String client_ip_address =  (String)map.get("login_at_ws_no") ;
	String err_desc = "";
	//String dummyString1 = ""; //Commented Against AAKH-ICN-0008
	try{
		cstmt=con.prepareCall("{call OT_BILLING_PACKAGE.OT_BL_INTERFACED_REC(?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.setString(2,patient_id);
		cstmt.setString(3,bl_episode_type);
		cstmt.setString(4,episode_id);
		cstmt.setString(5,visit_id);
		cstmt.setString(6,order_id) ;
		cstmt.setString(7,oper_num) ;
		cstmt.setString(8,client_ip_address);
		//out parameters
		cstmt.registerOutParameter(9,Types.VARCHAR);//v_err_code
		cstmt.registerOutParameter(10,Types.VARCHAR);//v_sys_message_id
		cstmt.registerOutParameter(11,Types.VARCHAR);//v_error_text
		cstmt.registerOutParameter(12,Types.VARCHAR);//LANG_ERR_MESG_ID NOT ADDED IN THE PROCEDURE		
		cstmt.execute();

		err_level = checkForNull(cstmt.getString(9));
		sys_message_id = checkForNull(cstmt.getString(10));
		error_text = checkForNull(cstmt.getString(11));
		err_desc=decodeProcedureErrorMsg(con,err_level,sys_message_id,error_text,"callBillRecord()");

		if(!"RECORD_INSERTED".equals(err_desc))
			con.rollback();
		else
			con.commit();
	}catch(Exception e){
		err_desc=e.getMessage();
		System.err.println("Admin: Err Msg  "+e);
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
		}catch(Exception e){e.printStackTrace();}
	}
   return err_desc;
}
};
