/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
27/03/2017	  IN063686		Raja S			27/03/2017		Ramesh G		PMG2017-GHL-CRF-0001
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
04/09/2017	IN065144		Dinesh T		04/09/2017		Ramesh G		Script error displayed
12/02/2018	IN065713		Dinesh T		12/02/2018		Ramesh G		ML-MMOH-CRF-0987
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
08/01/2020	IN068314	Nijitha S      24/12/2019	  Ramesh G			ML-MMOH-CRF-1229
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR.OROrderSet ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;
import javax.ejb.* ;
import javax.transaction.* ;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="OROrderSet"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrderSet"
*	local-jndi-name="OROrderSet"
*	impl-class-name="eOR.OROrderSet.OROrderSetManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.OROrderSet.OROrderSetLocal"
*	remote-class="eOR.OROrderSet.OROrderSetRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrderSet.OROrderSetLocalHome"
*	remote-class="eOR.OROrderSet.OROrderSetHome"
*	generate= "local,remote"
*
*
*/

public class OROrderSetManager extends OrEJBSessionAdapter 
{

   private boolean chkDuplicate(String sql,Connection con , String arr[]) throws Exception
 {
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt =  null;
	ResultSet rs	         = null ;
	try
	{
	
		boolean dupFlag = false ;

		 pstmt = con.prepareStatement(sql);


		int size				= arr.length ;

		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}

		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
			count = rs.getInt(1);

		if(count > 0)
		dupFlag = true ;


		return dupFlag;

		}catch(Exception e){
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally
	 {
		closeResultSet( rs ) ;
		closeStatement( pstmt ) ;
	 }

}//End of dulicate chk

/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap insert(HashMap tabDataParam , HashMap sqlMap )
{
	//IN065713, starts
	/*HashMap map =null;
	map = new HashMap() ;*/
	HashMap map = new HashMap(); 
	//IN065713, ends
	
		
	StringBuffer messages =  null ;
	StringBuffer traceVal =  null ;
	//HashMap map =null;
	Connection connection =  null ;
	Properties  pt   =  null ;

	 PreparedStatement pstmt_cr	    	= null ;
	 PreparedStatement pstmt_comp	    = null ;	 
	 PreparedStatement pstmt_syn		= null ;
	 PreparedStatement pstmt_ptcl		= null ;
	 PreparedStatement pstmt_add_select		= null ;
	 PreparedStatement pstmt_add_delete		= null ;
	 PreparedStatement pstmt_appl_facility = null;//IN068370,IN068373
	 PreparedStatement pstmt_del_appl_facility = null;//IN068370,IN068373
	 ResultSet resultSet 			= null;
	 //IN062992, starts
	 PreparedStatement pstmt_comp_age_wise_insert	    = null ;
	 PreparedStatement pstmt_comp_age_wise_select	= null ;
	 PreparedStatement pstmt_comp_age_wise_delete		= null ;
	 Boolean isSiteSpecificYN = new Boolean(false);
	 ResultSet resultSetAgeWise = null;
	 //IN062992
	 
	 //IN68241, starts
	 ResultSet resultSetDosageTypeWise = null;
	 PreparedStatement pstmt_comp_dosage_type_wise_insert	    = null ;
	 PreparedStatement pstmt_comp_dosage_type_wise_select	= null ;
	 PreparedStatement pstmt_comp_dosage_type_wise_delete		= null ; 								
	 //IN68241, ends	 
	 String globalFacilityYn = "N";//IN068370,IN068373
	 Boolean siteSpecGlobalFac = false;//IN068370,IN068373
	try 
	{
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;

		HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");

		pt							=(Properties)tabDataParam.get("properties");

		String[] l_appl_fac_id = null;//IN068370,IN068373
		ArrayList mappedFacilities = new ArrayList();//IN068370,IN068373

		HashMap	 careSetHeaderStr	=(HashMap)tabData_p.get("careSetHeaderStr");		
		//IN068370,IN068373, starts
		if(careSetHeaderStr.containsKey("appl_fac_id"))
		{
			l_appl_fac_id =(String[])careSetHeaderStr.get("appl_fac_id");			
		}
		//IN068370,IN068373, ends
		ArrayList componentStr		=(ArrayList)tabData_p.get("componentStr");
		ArrayList synonymsRec		=(ArrayList)tabData_p.get("synonymsStr");
		ArrayList explanatoryRec		=(ArrayList)tabData_p.get("explanatoryStr");//passed as arrayList
		HashMap synonymsStr			=(HashMap)synonymsRec.get(0);
		HashMap explanatoryStr			=(HashMap)explanatoryRec.get(0);	
	//	String explanatory_text=(String)explanatoryStr.get("explanatory_text");
	//	careSetHeaderStr.put("explanatory_text",explanatory_text);	
		ArrayList settingsStr		=(ArrayList)tabData_p.get("settingsStr");
		ArrayList billingRecStr		=(ArrayList)tabData_p.get("billingRecStr");
		HashMap billingStr			=(HashMap)billingRecStr.get(0);	

		mappedFacilities=(ArrayList)tabData_p.get("MappedFacilities");//IN068370,IN068373
		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;
		//HashMap	 componentAdditionalStr	=(HashMap)tabData_p.get("componentAdditionalStr");//Check Style Violation
		//IN062992, starts
		HashMap	 componentAgeWiseStr	=(HashMap)tabData_p.get("componentAgeWiseStr");
		isSiteSpecificYN =(Boolean)tabData_p.get("isSiteSpecificYN");
		//IN062992, ends
		//IN068370,IN068373, starts
		globalFacilityYn = (String)tabData_p.get("GlobalFacilityYn");
		siteSpecGlobalFac = (Boolean)tabData_p.get("SiteSpecGlobalFac");
		//IN068370,IN068373, ends
		
		//IN68241, starts
		HashMap hashCatalogDosageTypeWise = (HashMap)tabData_p.get("hashCatalogDosageTypeWise");
//		HashMap hashAdditionalCatalogDosageTypeKgWise = (HashMap)tabData_p.get("hashAdditionalCatalogDosageTypeKgWise"); //Checkstyle
//		HashMap hashAdditionalCatalogDosageTypeM2Wise = (HashMap)tabData_p.get("hashAdditionalCatalogDosageTypeM2Wise"); //CheckStyle
		//IN68241, ends

		connection = getConnection(pt) ;
		connection.setAutoCommit( false ) ;

		String SQL_OR_ORDERSET_DUP_CHK					= (String)sqlMap.get("SQL_OR_ORDERSET_DUP_CHK");
		String SQL_OR_ORDERSET_INSERT					= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT");
		String SQL_OR_ORDERSET_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_SYNONYM");
		String SQL_OR_ORDERSET_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_BY_PTCL");
		String SQL_OR_ORDERSET_INSERT_COMP				= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_COMP");
		//String SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT				= (String)sqlMap.get("SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT");//Check Style Violation
		//String SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE				= (String)sqlMap.get("SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE");//Check Style Violation

		//IN062992, starts
		String SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT	= (String)sqlMap.get("SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT");
		String SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT");
		String SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE");
		//IN062992, ends
		
		//IN68241, starts
		String SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT	= (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT");
		String SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT");
		String SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE");
		//IN68241, ends	
		//IN068370,IN068373, starts
		String SQL_OR_CATALOG_BY_FACILITY_INSERT = "";
		String SQL_OR_CATALOG_BY_FACILITY_DELETE = "";
		
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			SQL_OR_CATALOG_BY_FACILITY_INSERT = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_INSERT");
			SQL_OR_CATALOG_BY_FACILITY_DELETE = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_DELETE");
		}
		//IN068370,IN068373, end
		
		String order_set_code							=(String)careSetHeaderStr.get("order_set_code") ;
		traceVal.append("order_set_code="+order_set_code)	   ;
		String	order_category							=(String)careSetHeaderStr.get("order_category") ;
		String iv_prep_yn								    =(String)careSetHeaderStr.get("iv_prep_yn") ;
		String contr_mod_id								=(String)careSetHeaderStr.get("contr_mod_id") ;
		String contr_msr_panel_id 					=(String)careSetHeaderStr.get("contr_msr_panel_id ") ;
		if(order_category!=null && !order_category.equals("PH"))
		iv_prep_yn									= "";	

		/********DUPLICATE CHK*****************************************/
		String arrChkDup[]  =  new String[1] ;

		arrChkDup[0] = order_set_code ;

		traceVal.append("Before dup chk");

		boolean duplicate = chkDuplicate(SQL_OR_ORDERSET_DUP_CHK,connection,arrChkDup);

		traceVal.append("After dup chk");

		if(duplicate)
		{

		  String msg  =	 "CODE_ALREADY_EXISTS";
		  map.put( "message", msg ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;

		}

		/*************************************************************/

		pstmt_cr										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT);
		pstmt_syn										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_BY_PTCL);
		pstmt_comp										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_COMP);
		
		//pstmt_add_select										= connection.prepareStatement(SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT);
		//pstmt_add_delete										= connection.prepareStatement(SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE);

		//IN062992, starts
		if(isSiteSpecificYN.booleanValue())
		{
			pstmt_comp_age_wise_insert								= connection.prepareStatement(SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT);
			pstmt_comp_age_wise_select										= connection.prepareStatement(SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT);
			pstmt_comp_age_wise_delete										= connection.prepareStatement(SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE);
			
			//IN68241, starts
			pstmt_comp_dosage_type_wise_insert								= connection.prepareStatement(SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT);
			pstmt_comp_dosage_type_wise_select						    = connection.prepareStatement(SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT);
			pstmt_comp_dosage_type_wise_delete						    = connection.prepareStatement(SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE);
		}
			//IN68241, ends
		//IN068370,IN068373, starts
        if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
        {
        	pstmt_appl_facility                             = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_INSERT);
        	pstmt_del_appl_facility                         = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_DELETE);
        }
		//IN068370,IN068373, ends

		int	insert_cr		= -1 ;
		int	insert_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_comp[]	= {} ;
		int	insert_comp_age_wise[]	= {} ;//IN062992
		int	insert_comp_dosage_type_wise[]	= {} ;//IN68241
		int insert_fac_mapping[] = {};//IN068370,IN068373
		//int   existing=0;//Check Style Violation
        //int   delete_comp_del_status=0;//Check Style issue
		int    delete_comp_del_status_age_wise=  0;//IN062992
		int delete_comp_del_status_dosage_type_wise = 0;//IN68241

		/******************INSERT INTO ORDER_CATALOG*************/


		pstmt_cr.setString(1	, order_set_code);
		pstmt_cr.setString(2	, (String)careSetHeaderStr.get("long_desc"));
		pstmt_cr.setString(3	, (String)careSetHeaderStr.get("short_desc"));
		pstmt_cr.setString(4	, (String)careSetHeaderStr.get("order_category"));
		pstmt_cr.setString(5	, (String)careSetHeaderStr.get("order_type_code"));
		pstmt_cr.setString(6	, (String)careSetHeaderStr.get("activity_type"));
		pstmt_cr.setString(7	, (String)careSetHeaderStr.get("security_level"));
	//	pstmt_cr.setString(8	,(String)careSetHeaderStr.get("explanatory_text"));
		pstmt_cr.setString(8	, (String)explanatoryStr.get("explanatory_text"));		
		pstmt_cr.setString(9	, "S");
		pstmt_cr.setString(10	, "N");
		pstmt_cr.setString(11	, "");
		pstmt_cr.setString(12	, "N");
		pstmt_cr.setString(13	, "");
		pstmt_cr.setString(14	, "N");
		pstmt_cr.setString(15	, "");
		pstmt_cr.setString(16	, "N");
		pstmt_cr.setString(17	, "N");
		pstmt_cr.setString(18	, "N");
		pstmt_cr.setString(19	, "N");
		pstmt_cr.setString(20	, "N");
		pstmt_cr.setString(21	, "N");
		pstmt_cr.setString(22	, "");
		pstmt_cr.setString(23	, "N");
		pstmt_cr.setString(24	, "");
		pstmt_cr.setString(25	, "");
		pstmt_cr.setString(26	, "");
		pstmt_cr.setString(27	, "");
		pstmt_cr.setString(28	, "");
		pstmt_cr.setString(29	, "");
		pstmt_cr.setString(30	, "");
		pstmt_cr.setString(31	, "");
		pstmt_cr.setString(32	, "");
		pstmt_cr.setString(33	, "");
		pstmt_cr.setString(34	, "N");
		pstmt_cr.setString(35	, "");
		pstmt_cr.setString(36	, "N");
		pstmt_cr.setString(37	, "N");
		pstmt_cr.setString(38	, "N");
		//pstmt_cr.setString(39	,"N");
		pstmt_cr.setString(39	, (String)billingStr.get("bill_yn"));
		pstmt_cr.setString(40	, "N");
		pstmt_cr.setString(41	, "N");
		pstmt_cr.setString(42	, "");
		pstmt_cr.setString(43	, "");
		pstmt_cr.setString(44	, contr_mod_id);
		pstmt_cr.setString(45	, contr_msr_panel_id);
		pstmt_cr.setString(46	, "");
		pstmt_cr.setString(47	, (String)careSetHeaderStr.get("indexed_yn"));
		pstmt_cr.setString(48	, (String)careSetHeaderStr.get("discharge_indicator"));
		pstmt_cr.setString(49	, (String)careSetHeaderStr.get("eff_status"));
		pstmt_cr.setString(50	, login_by_id);
		pstmt_cr.setString(51	, login_at_ws_no);
		pstmt_cr.setString(52	, login_facility_id);
		pstmt_cr.setString(53	, login_by_id);
		pstmt_cr.setString(54	, login_at_ws_no);
		pstmt_cr.setString(55	, login_facility_id);
		pstmt_cr.setString(56	, "");//Little differnce in database name and bean name
   		pstmt_cr.setString(57	, "");//FROM SQL
   		pstmt_cr.setString(58	, iv_prep_yn);//iv_prep_yn
		pstmt_cr.setString(59	, (String)billingStr.get("charge_type_applicable"));
		pstmt_cr.setString(60	, (String)billingStr.get("ord_set_charge_pat_yn"));
		pstmt_cr.setString(61	, (String)careSetHeaderStr.get("fpp_yn"));//IN068314
		pstmt_cr.setString(62	, (String)billingStr.get("fpp_category"));//IN068314
		

		insert_cr = pstmt_cr.executeUpdate();

		traceVal.append("ORDER_CATALOG after Insetion insert_cr="+insert_cr) ;
		//IN068370,IN068373, starts
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			pstmt_del_appl_facility.setString(1, order_set_code);
			pstmt_del_appl_facility.execute();
			
			if(mappedFacilities!=null && mappedFacilities.size()>0)
			{
				for(int i=0;i<mappedFacilities.size();i++)
				{
					pstmt_appl_facility.setString(1, order_set_code);
					pstmt_appl_facility.setString(2, (String)mappedFacilities.get(i));
					pstmt_appl_facility.setString(3	,login_by_id);
					pstmt_appl_facility.setString(4	,login_at_ws_no);
					pstmt_appl_facility.setString(5	,login_facility_id);
					pstmt_appl_facility.setString(6	,login_by_id);
					pstmt_appl_facility.setString(7	,login_at_ws_no);
					pstmt_appl_facility.setString(8	,login_facility_id);
					pstmt_appl_facility.addBatch();
				}
				
				insert_fac_mapping = pstmt_appl_facility.executeBatch();	
			}
		}
		//IN068370,IN068373, ends


		/**************INSERT INTO ORDER CATALOG SYNONYM**************/


		String 	effective_status_primary		= (String)synonymsStr.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)synonymsStr.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)synonymsStr.get("effective_status_ancillaryDept") ;
		

		if(effective_status_primary.trim().equalsIgnoreCase("Y"))
		{//This insertion is Mandatory
			pstmt_syn.setString(1 , order_set_code);
			pstmt_syn.setString(2 , "PR");
			pstmt_syn.setString(3 , (String)synonymsStr.get("catalog_synonym_primary"));
			pstmt_syn.setString(4 , login_by_id);
			pstmt_syn.setString(5 , login_at_ws_no);
			pstmt_syn.setString(6 , login_facility_id);
			pstmt_syn.setString(7 , login_by_id);
			pstmt_syn.setString(8 , login_at_ws_no);
			pstmt_syn.setString(9 , login_facility_id);
			pstmt_syn.setString(10, effective_status_primary);//*************
			pstmt_syn.addBatch() ;

		}

		if(effective_status_directCare.trim().equalsIgnoreCase("Y"))
		{
			pstmt_syn.setString(1 , order_set_code);
			pstmt_syn.setString(2 , "DC");
			pstmt_syn.setString(3 , (String)synonymsStr.get("catalog_synonym_directCare"));
			pstmt_syn.setString(4 , login_by_id);
			pstmt_syn.setString(5 , login_at_ws_no);
			pstmt_syn.setString(6 , login_facility_id);
			pstmt_syn.setString(7 , login_by_id);
			pstmt_syn.setString(8 , login_at_ws_no);
			pstmt_syn.setString(9 , login_facility_id);
			pstmt_syn.setString(10 , effective_status_directCare);//*************
			pstmt_syn.addBatch() ;
		}

		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y"))
		{
			pstmt_syn.setString(1 , order_set_code);
			pstmt_syn.setString(2 , "AD");
			pstmt_syn.setString(3 , (String)synonymsStr.get("catalog_synonym_ancillaryDept"));
			pstmt_syn.setString(4 , login_by_id);
			pstmt_syn.setString(5 , login_at_ws_no);
			pstmt_syn.setString(6 , login_facility_id);
			pstmt_syn.setString(7 , login_by_id);
			pstmt_syn.setString(8 , login_at_ws_no);
			pstmt_syn.setString(9 , login_facility_id);
			pstmt_syn.setString(10 , effective_status_ancillaryDept);//*************
			pstmt_syn.addBatch();
		}

		insert_syn = pstmt_syn.executeBatch();

		traceVal.append("after insertion sysn="+insert_syn.length);

/**************INSERT INTO OR_ORDER BY PTCL*******************/

		int sizeSettings			=settingsStr.size()  ;
		int iterateVal				=0;

		 traceVal.append("Settings="+sizeSettings + "   //////");


		iterateVal = sizeSettings ;

///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same
		HashMap tempSetting=null;
		String setting_applicability="";
		String patient_class="";
		String age_group_code="";//Added for IN063686
		for(int i = 0; i < iterateVal ; i++)
		{//0 for the default

		   tempSetting = (HashMap)settingsStr.get(i);
			setting_applicability	    =(String)tempSetting.get("setting_applicability");

			if(setting_applicability.trim().equalsIgnoreCase("A") || i== 0 )
			{

				patient_class	=(String)tempSetting.get("patient_class");
				age_group_code	=(String)tempSetting.get("age_group_code"); //Added for IN063686
				pstmt_ptcl.setString(1	 , order_set_code);
				pstmt_ptcl.setString(2	 , patient_class);
				pstmt_ptcl.setString(3	 , "X");
				pstmt_ptcl.setString(4	 , "N");
				pstmt_ptcl.setString(5	 , "N");
				pstmt_ptcl.setString(6	 , "N");
				pstmt_ptcl.setString(7	 , setting_applicability.trim());
				pstmt_ptcl.setString(8	 , "");
				pstmt_ptcl.setString(9	 , "");
				pstmt_ptcl.setString(10	 , "");
				pstmt_ptcl.setString(11	 , "");
				pstmt_ptcl.setString(12	 , "");
				pstmt_ptcl.setString(13	 , "");
				pstmt_ptcl.setString(14	 , "");
				pstmt_ptcl.setString(15	 , "");
				pstmt_ptcl.setString(16  , "");
				//Added for IN063686 Start
				/*pstmt_ptcl.setString(17	 , login_by_id);
				pstmt_ptcl.setString(18	 , login_at_ws_no);
				pstmt_ptcl.setString(19  , login_facility_id);
				pstmt_ptcl.setString(20  , login_by_id);
				pstmt_ptcl.setString(21  , login_at_ws_no);
				pstmt_ptcl.setString(22  , login_facility_id);
				pstmt_ptcl.setString(23  , "");*/ //Commented for IN063686
				pstmt_ptcl.setString(17	 , age_group_code);
				pstmt_ptcl.setString(18	 , login_by_id);
				pstmt_ptcl.setString(19	 , login_at_ws_no);
				pstmt_ptcl.setString(20  , login_facility_id);
				pstmt_ptcl.setString(21  , login_by_id);
				pstmt_ptcl.setString(22  , login_at_ws_no);
				pstmt_ptcl.setString(23  , login_facility_id);
				pstmt_ptcl.setString(24  , "");
				//IN063686 End.
				pstmt_ptcl.addBatch();
			}//end of For Loop for PTCL INSERTION
		}

		insert_ptcl = pstmt_ptcl.executeBatch();

		traceVal.append("afterInsertion="+insert_ptcl.length);


	/*****************INSERTION FOR OR ORDER Set Component************/

		 int noOfRecords = componentStr.size() ;

		 int ageWiseRecords = 0;//IN062992
		 int dosageTypeWiseRecords = 0;//IN68241
		 HashMap currData=null;
		 String  associate_yn="";

			//IN068370,IN068373, starts
			if ("Y".equals(globalFacilityYn) && siteSpecGlobalFac) {
				ArrayList<String> mappingCatCombination = new ArrayList<String>();
				ArrayList<String> catalogs = new ArrayList<String>();

				for (int l = 0; l < noOfRecords; l++) {
					HashMap currRec = (HashMap) componentStr.get(l);
					if ("Y".equalsIgnoreCase((String)currRec.get("associate_yn"))) {
						catalogs.add((String) currRec.get("order_catalog_code"));
						for (int m = 0; m < mappedFacilities.size(); m++) {
							mappingCatCombination
									.add((String) ((HashMap) componentStr
											.get(l)).get("order_catalog_code")
											+ "#" + mappedFacilities.get(m));
						}
					}
				}

				ArrayList<String> combination = fetchMappingCombination(
						connection, catalogs, mappedFacilities);

				if (!combination.containsAll(mappingCatCombination))
					throw new Exception("ORDERSET_INCORRECT_CATALOG_COMB");
			}
			//IN068370,IN068373, ends
			
		 for(int k=0 ; k< noOfRecords ; k++){
		 HashMap catalogValues = new HashMap();//IN062992
		 currData	     =(HashMap)componentStr.get(k);
		 associate_yn	 =(String)currData.get("associate_yn");

		 traceVal.append("order_category="+order_category);

		 if(associate_yn.trim().equalsIgnoreCase("Y"))
		 {
			pstmt_comp.setString(1	, order_set_code);
			pstmt_comp.setString(2	, (String)currData.get("order_set_seq_num"));
			pstmt_comp.setString(3	, (String)currData.get("order_catalog_code"));
			pstmt_comp.setString(4	, (String)currData.get("order_type_code"));
			//pstmt_comp.setString(5	,(String)currData.get("activity_type"));
			pstmt_comp.setString(5	, (String)currData.get("order_category"));//order_category
			pstmt_comp.setString(6	, (String)currData.get("reqd_or_opt_ind"));
			pstmt_comp.setString(7	, (String)currData.get("rel_start_date_time"));
			pstmt_comp.setString(8	, (String)currData.get("route_code"));
			pstmt_comp.setString(9 , (String)currData.get("qty_unit"));		//Not in sec phase
			pstmt_comp.setString(10 , (String)currData.get("qty_value"));	//Not in sec phase
			pstmt_comp.setString(11 , (String)currData.get("freq_code"));
			pstmt_comp.setString(12 , (String)currData.get("durn_value"));
			pstmt_comp.setString(13 , (String)currData.get("durn_type"));
			pstmt_comp.setString(14 , (String)currData.get("prompt_msg"));//Not in sec phase
			pstmt_comp.setString(15 , login_by_id);
			pstmt_comp.setString(16 , login_at_ws_no);
			pstmt_comp.setString(17 , login_facility_id);
			pstmt_comp.setString(18 , login_by_id);
			pstmt_comp.setString(19 , login_at_ws_no);
			pstmt_comp.setString(20 , login_facility_id);
			pstmt_comp.setInt(21 , 1);
			
			//IN062992, starts
			if(isSiteSpecificYN.booleanValue())
			{
				//IN68241, starts
				//pstmt_comp.setString(22 , (String)currData.get("dosage_type"));
				int hashCatalogDosageTypeWiseSize = 0;
				String l_cat_code = (String)currData.get("order_catalog_code");
				
				if(hashCatalogDosageTypeWise!=null && hashCatalogDosageTypeWise.containsKey(l_cat_code))
					hashCatalogDosageTypeWiseSize = ((HashMap)hashCatalogDosageTypeWise.get(l_cat_code)).size();
				
				if(hashCatalogDosageTypeWise!=null && hashCatalogDosageTypeWiseSize > 0)					
					pstmt_comp.setString(22 , "M");
				else
					pstmt_comp.setString(22 , null);
				//IN68241, ends			
			}
			//IN062992, ends

			pstmt_comp.addBatch();

			//IN062992, starts
			if(isSiteSpecificYN.booleanValue())
			{
				//IN68241, commented starts
				//HashMap additionalComponentAgeWise = new HashMap ();//IN065713
				/*HashMap componentAgeWise = new HashMap ();//IN065713
						
				//additionalComponentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
				componentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713

				pstmt_comp_age_wise_select.setString(1,order_set_code.trim());
				pstmt_comp_age_wise_select.setString(2,(String)currData.get("order_catalog_code"));
				resultSetAgeWise = pstmt_comp_age_wise_select.executeQuery() ;

				while ( resultSetAgeWise != null && resultSetAgeWise.next() ) 
				{
					int total_records = resultSetAgeWise.getInt("total");
					
					if(total_records>0)
					{
						pstmt_comp_age_wise_delete.clearParameters();
						pstmt_comp_age_wise_delete.setString(1,order_set_code.trim());
						pstmt_comp_age_wise_delete.setString(2,(String)currData.get("order_catalog_code"));
						delete_comp_del_status_age_wise = pstmt_comp_age_wise_delete.executeUpdate();	
					}
				}

				closeResultSet(resultSetAgeWise);

			
				//if("A".equals(currData.get("dosage_type")) && additionalComponentAgeWise!=null)//IN065713
				if(componentAgeWise!=null)//IN065713
				{
					//if(additionalComponentAgeWise.size()>0)//IN065713
					if(componentAgeWise.size()>0)//IN065713
					{

						//Set newmap = additionalComponentAgeWise.keySet();//IN065713
						Set newmap = componentAgeWise.keySet();//IN065713

						Iterator iterator 	 = newmap.iterator();

						while( iterator. hasNext() )
						{								
							catalogValues = new HashMap();

							//catalogValues = (HashMap)additionalComponentAgeWise.get(iterator.next());//IN065713
							catalogValues = (HashMap)componentAgeWise.get(iterator.next());//IN065713
							
							pstmt_comp_age_wise_insert.setString(1	, order_set_code==null?"":order_set_code);
				
							pstmt_comp_age_wise_insert.setString(2	, (String)catalogValues.get("order_set_seq_num")==null?"":(String)catalogValues.get("order_set_seq_num"));
							pstmt_comp_age_wise_insert.setString(3	, (String)catalogValues.get("order_catalog_code")==null?"":(String)catalogValues.get("order_catalog_code"));
							pstmt_comp_age_wise_insert.setString(4	, (String)catalogValues.get("age_group_code")==null?"":(String)catalogValues.get("age_group_code"));
							pstmt_comp_age_wise_insert.setString(5	, (String)catalogValues.get("qty_unit")==null?"":(String)catalogValues.get("qty_unit"));
							pstmt_comp_age_wise_insert.setString(6	, (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));
							pstmt_comp_age_wise_insert.setString(7 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
							pstmt_comp_age_wise_insert.setString(8 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
							pstmt_comp_age_wise_insert.setString(9 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
							pstmt_comp_age_wise_insert.setString(10	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
							pstmt_comp_age_wise_insert.setString(11	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));								
							pstmt_comp_age_wise_insert.setString(12 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
							pstmt_comp_age_wise_insert.setString(13 , login_by_id);
							pstmt_comp_age_wise_insert.setString(14 , login_at_ws_no);
							pstmt_comp_age_wise_insert.setString(15 , login_facility_id);
							pstmt_comp_age_wise_insert.setString(16 , login_by_id);
							pstmt_comp_age_wise_insert.setString(17 , login_at_ws_no);
							pstmt_comp_age_wise_insert.setString(18 , login_facility_id);
							pstmt_comp_age_wise_insert.setInt(19 , 1);//IN065713
							pstmt_comp_age_wise_insert.setInt(20 , Integer.parseInt((String)catalogValues.get("occ_no")==null?"":(String)catalogValues.get("occ_no")));//CRF-1227
							ageWiseRecords++;
							pstmt_comp_age_wise_insert.addBatch();
						}
					}
				}*/
				//IN68241, ends
				
				//IN68241, starts
				HashMap componentDosageTypeWise = new HashMap ();//IN065713
				
				//additionalComponentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
				componentDosageTypeWise = (HashMap)hashCatalogDosageTypeWise.get((String)currData.get("order_catalog_code"));//IN065713
				pstmt_comp_dosage_type_wise_select.setString(1,order_set_code.trim());
				pstmt_comp_dosage_type_wise_select.setString(2,(String)currData.get("order_catalog_code"));
				resultSetDosageTypeWise = pstmt_comp_dosage_type_wise_select.executeQuery() ;

				while ( resultSetDosageTypeWise != null && resultSetDosageTypeWise.next() ) 
				{
					int total_records = resultSetDosageTypeWise.getInt("total");
					
					if(total_records>0)
					{
						pstmt_comp_dosage_type_wise_delete.clearParameters();
						pstmt_comp_dosage_type_wise_delete.setString(1,order_set_code.trim());
						pstmt_comp_dosage_type_wise_delete.setString(2,(String)currData.get("order_catalog_code"));
						delete_comp_del_status_dosage_type_wise = pstmt_comp_dosage_type_wise_delete.executeUpdate();	
					}
				}

				closeResultSet(resultSetDosageTypeWise);
				
				if(componentDosageTypeWise!=null)//IN065713
				{
					if(componentDosageTypeWise.size()>0)//IN065713
					{
						Set newmap = componentDosageTypeWise.keySet();//IN065713

						Iterator iterator 	 = newmap.iterator();							

						while( iterator. hasNext() )
						{								
							catalogValues = new HashMap();									
							catalogValues = (HashMap)componentDosageTypeWise.get(iterator.next());//IN065713
							
							String l_order_set_seq_no =(String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num");
							int l_dosage_type_seq_no = Integer.parseInt((String)catalogValues.get("dosage_type_seq_no")==null?"":(String)catalogValues.get("dosage_type_seq_no"));
							String l_catalog_code  =(String)catalogValues.get("order_catalog_code")==null?"":(String)catalogValues.get("order_catalog_code");
							String dosage_type = (String)catalogValues.get("dosage_type")==null?"":(String)catalogValues.get("dosage_type");
							pstmt_comp_dosage_type_wise_insert.clearParameters();
							pstmt_comp_dosage_type_wise_insert.setString(1	, order_set_code==null?"":order_set_code);					
							pstmt_comp_dosage_type_wise_insert.setString(2	, l_order_set_seq_no);
							pstmt_comp_dosage_type_wise_insert.setString(3	, l_catalog_code);
							pstmt_comp_dosage_type_wise_insert.setInt(4	, 1);
							pstmt_comp_dosage_type_wise_insert.setString(5	, dosage_type);
							pstmt_comp_dosage_type_wise_insert.setString(6	, (String)catalogValues.get("qty_unit")==null?"":(String)catalogValues.get("qty_unit"));
							pstmt_comp_dosage_type_wise_insert.setString(7	, (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));
							pstmt_comp_dosage_type_wise_insert.setString(8 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
							pstmt_comp_dosage_type_wise_insert.setString(9 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
							pstmt_comp_dosage_type_wise_insert.setString(10 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
							pstmt_comp_dosage_type_wise_insert.setString(11	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
							pstmt_comp_dosage_type_wise_insert.setString(12	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));								
							pstmt_comp_dosage_type_wise_insert.setString(13 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
							pstmt_comp_dosage_type_wise_insert.setString(14 , login_by_id);
							pstmt_comp_dosage_type_wise_insert.setString(15 , login_at_ws_no);
							pstmt_comp_dosage_type_wise_insert.setString(16 , login_facility_id);
							pstmt_comp_dosage_type_wise_insert.setString(17 , login_by_id);
							pstmt_comp_dosage_type_wise_insert.setString(18 , login_at_ws_no);
							pstmt_comp_dosage_type_wise_insert.setString(19 , login_facility_id);
							pstmt_comp_dosage_type_wise_insert.setInt(20 , l_dosage_type_seq_no);//IN065713							
							dosageTypeWiseRecords++;
							pstmt_comp_dosage_type_wise_insert.addBatch();
							//IN68241, ends							
							
							//IN68241, starts
							HashMap componentAgeWise = new HashMap ();//IN065713							
							//additionalComponentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
							
							componentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
							
							if(dosage_type.equals("A") && componentAgeWise!=null && componentAgeWise.size()>0)
							{
								pstmt_comp_age_wise_select.setString(1,order_set_code.trim());
								pstmt_comp_age_wise_select.setString(2,(String)currData.get("order_catalog_code"));
								resultSetAgeWise = pstmt_comp_age_wise_select.executeQuery() ;
	
								while ( resultSetAgeWise != null && resultSetAgeWise.next() ) 
								{
									int total_records = resultSetAgeWise.getInt("total");
									
									if(total_records>0)
									{
										pstmt_comp_age_wise_delete.clearParameters();
										pstmt_comp_age_wise_delete.setString(1,order_set_code.trim());
										pstmt_comp_age_wise_delete.setString(2,(String)currData.get("order_catalog_code"));
										delete_comp_del_status_age_wise = pstmt_comp_age_wise_delete.executeUpdate();	
									}
								}
	
								closeResultSet(resultSetAgeWise);
								
								if(componentAgeWise!=null)
								{
									if(componentAgeWise.size()>0)
									{							
										Set ageWisenewmap = componentAgeWise.keySet();
	
										Iterator ageWiseIterator 	 = ageWisenewmap.iterator();
	
										while( ageWiseIterator. hasNext() )
										{								
											catalogValues = new HashMap();
	
											catalogValues = (HashMap)componentAgeWise.get(ageWiseIterator.next());
											
											pstmt_comp_age_wise_insert.setString(1	, order_set_code==null?"":order_set_code);
								
											pstmt_comp_age_wise_insert.setString(2	, (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num"));
											pstmt_comp_age_wise_insert.setString(3	, (String)catalogValues.get("order_catalog_code")==null?"":(String)catalogValues.get("order_catalog_code"));
											pstmt_comp_age_wise_insert.setString(4	, (String)catalogValues.get("age_group_code")==null?"":(String)catalogValues.get("age_group_code"));
											pstmt_comp_age_wise_insert.setString(5	, (String)catalogValues.get("qty_unit")==null?"":(String)catalogValues.get("qty_unit"));
											pstmt_comp_age_wise_insert.setString(6	, (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));
											pstmt_comp_age_wise_insert.setString(7 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
											pstmt_comp_age_wise_insert.setString(8 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
											pstmt_comp_age_wise_insert.setString(9 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
											pstmt_comp_age_wise_insert.setString(10	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
											pstmt_comp_age_wise_insert.setString(11	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));								
											pstmt_comp_age_wise_insert.setString(12 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
											pstmt_comp_age_wise_insert.setString(13 , login_by_id);
											pstmt_comp_age_wise_insert.setString(14 , login_at_ws_no);
											pstmt_comp_age_wise_insert.setString(15 , login_facility_id);
											pstmt_comp_age_wise_insert.setString(16 , login_by_id);
											pstmt_comp_age_wise_insert.setString(17 , login_at_ws_no);
											pstmt_comp_age_wise_insert.setString(18 , login_facility_id);
											pstmt_comp_age_wise_insert.setInt(19 , 1);
											pstmt_comp_age_wise_insert.setInt(20 , l_dosage_type_seq_no);
											ageWiseRecords++;
											pstmt_comp_age_wise_insert.addBatch();
										}
									}
								}
							}
							//IN68241, ends
						}
					}
				}
				//IN68241, ends
			}
			//IN062992, ends
		 }//End of if
	} //End of For loop

	insert_comp = pstmt_comp.executeBatch();

	//IN062992, starts
	if(isSiteSpecificYN.booleanValue() && ageWiseRecords>0)
		insert_comp_age_wise = pstmt_comp_age_wise_insert.executeBatch();
	//IN062992, ends
	
	//IN68241, starts
	if(isSiteSpecificYN.booleanValue() && dosageTypeWiseRecords>0)
		insert_comp_dosage_type_wise = pstmt_comp_dosage_type_wise_insert.executeBatch();
	//IN68241, ends

	traceVal.append("insert_comp="+insert_comp.length);

	/*pstmt_add_select.setString(1,order_set_code.trim());
	pstmt_add_select.setString(2,order_set_code.trim());
	resultSet = pstmt_add_select.executeQuery() ;

	while ( resultSet != null && resultSet.next() ) 
	{
		existing=1;
		String record = resultSet.getString("catalog_code");
		pstmt_add_delete.setString(1,order_set_code.trim());
		pstmt_add_delete.setString(2,record.trim());
		delete_comp_del_status = pstmt_add_delete.executeUpdate();				
	}*/

	boolean insert_cmp	=  false ;
	boolean insert_cmp_age_wise	=  false ;//IN062992
	boolean insert_cmp_dosage_type_wise	=  false;//IN68241
	boolean insert_ptl	=  false ;
	boolean insert_sy	=  false ;
	boolean bool_insert_fac_mapping = true;//IN068370,IN068373
	//boolean insert_add	=  true ;//Check Style Violation


	 if((insert_comp.length > 0))
	 { //check updation in Component
		insert_cmp= true ;
	 }
	 else if((insert_comp.length == (-3)))
	 {
		insert_cmp= false ;
	 }

	 //IN062992, starts
	 if(isSiteSpecificYN.booleanValue() && ageWiseRecords>0)
		{
		 if((insert_comp_age_wise.length > 0))
		 { //check updation in Component
			insert_cmp_age_wise= true ;
		 }
		 else if((insert_comp_age_wise.length == (-3)))
		 {
			insert_cmp_age_wise= false ;
		 }
		}
		else
		{
			insert_cmp_age_wise = true;
		}
		//IN062992, ends
	 //IN68241, starts
	 if(isSiteSpecificYN.booleanValue() && dosageTypeWiseRecords>0)
		{
		 if((insert_comp_dosage_type_wise.length > 0))
		 { //check updation in Component
			insert_cmp_dosage_type_wise= true ;
		 }
		 else if((insert_comp_dosage_type_wise.length == (-3)))
		 {
			 insert_cmp_dosage_type_wise= false ;
		 }
		}
		else
		{
			insert_cmp_dosage_type_wise = true;
		}	
	 //IN68241, ends
	 if((insert_ptcl.length > 0))
	 { //check updation in PTCL
		insert_ptl= true ;
	 }
	 else if((insert_ptcl.length == (-3)))
	 {
		insert_ptl= false ;
	 }


	 if((insert_syn.length > 0))
	 { //check updation in SYN
		insert_sy= true ;
	 }
	 else if((insert_syn.length == (-3)))
	 {
		insert_sy= false ;
	 }

	 /*if(existing>0)
	{
		if(delete_comp_del_status>0)
		{
			insert_add=true;
		}
		else
		{
			insert_add=false;
		}
	}*/
	 //IN068370,IN068373, starts
	 if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
	 {
		 if(insert_fac_mapping.length >0)
		 {
			 bool_insert_fac_mapping= true ;
		 }
		 else if((insert_fac_mapping.length == (-3)))
		 {
			 bool_insert_fac_mapping= false ;
		 }
	 }
	 //IN068370,IN068373, ends
		

	//if (insert_cr > 0  && insert_sy  && insert_cmp && insert_ptl)// && insert_add)//IN062992
	//if (insert_cr > 0  && insert_sy  && insert_cmp && insert_ptl && insert_cmp_age_wise)// && insert_add)//IN062992
	//if (insert_cr > 0  && insert_sy  && insert_cmp && insert_ptl && insert_cmp_age_wise && insert_cmp_dosage_type_wise)// && insert_add)//IN062992//CRF-1227//IN068370,IN068373
	if (insert_cr > 0  && insert_sy  && insert_cmp && insert_ptl && insert_cmp_age_wise && insert_cmp_dosage_type_wise && bool_insert_fac_mapping)//IN062992//CRF-1227//IN068370,IN068373
	{
			/*connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append("RECORD_INSERTED") ;*/
		/*Added by Uma on 9/30/2009 for PMG-CRF-0641*/
		boolean status_flg = false;
		status_flg = executeProcedure(connection,((String)careSetHeaderStr.get("order_set_code")));
		 if(status_flg)
		{
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append("RECORD_INSERTED") ;
		}
		else
		{
			connection.rollback();
			messages.append( "Insert Failed" ) ;
		}
		/*Ends Here*/
	}
	else
	{
			connection.rollback();
			messages.append( "Insert Failed" ) ;
	}

}
catch( Exception e )
{
	traceVal.append("In Exception==");
	e.printStackTrace();
	traceVal.append(e.getMessage());
	map.put( "traceVal", traceVal.toString() ) ;

	try 
	{
		connection.rollback();
		closeConnection( connection,pt);
	}
	catch ( Exception ee ) 
	{
		messages.append(ee.getMessage() ) ;
	}
	messages.append( e.getMessage() ) ;
	e.printStackTrace() ;
 } 
 finally
 {
	try 
	{

		closeStatement( pstmt_cr ) ;
		closeStatement( pstmt_comp ) ;
		closeStatement( pstmt_syn ) ;
		closeStatement( pstmt_ptcl ) ;
		closeStatement( pstmt_add_select ) ;
		closeStatement( pstmt_add_delete ) ;
		closeResultSet( resultSet ) ;
		//IN062992, starts
		closeResultSet(resultSetAgeWise);
		closeStatement(pstmt_comp_age_wise_insert);
	    closeStatement(pstmt_comp_age_wise_select);
		closeStatement(pstmt_comp_age_wise_delete);
		//IN062992, ends
		
		//IN68241, starts
		closeResultSet(resultSetDosageTypeWise);
		closeStatement(pstmt_comp_dosage_type_wise_insert);
	    closeStatement(pstmt_comp_dosage_type_wise_select);
		closeStatement(pstmt_comp_dosage_type_wise_delete);
		//IN68241, ends
		closeStatement(pstmt_appl_facility);//IN068370,IN068373
		closeStatement(pstmt_del_appl_facility);//IN068370,IN068373
		closeConnection( connection,pt);
	} 
	catch ( Exception fe ) 
	{
		fe.printStackTrace() ;
	}
   }

	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;


	return map ;
	
}

/*****************MODIFY MODE ******************************/
/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap modify(HashMap tabDataParam , HashMap sqlMap )
{
	StringBuffer messages =  null ;
	StringBuffer traceVal =  null ;
	HashMap map =null;
	Connection connection =  null ;
	Properties  pt      		= null;

	PreparedStatement pstmt_cr	    	= null ;
	PreparedStatement pstmt_comp	    = null ;	
	PreparedStatement pstmt_syn		= null ;
	PreparedStatement pstmt_ptcl		= null ;
	PreparedStatement pstmt_add_select	= null ;
	PreparedStatement pstmt_add_delete		= null ;
	

	PreparedStatement del_pstmt_syn		= null ;
	PreparedStatement del_pstmt_ptcl		= null ;
	PreparedStatement del_pstmt_comp		= null ;
	PreparedStatement pstmt_eff		= null ;
	ResultSet	rs_eff					= null;
	ResultSet resultSet 			= null;
	//IN062992, starts
	PreparedStatement pstmt_comp_age_wise_insert	    = null ;
	PreparedStatement pstmt_comp_age_wise_select	= null ;
	PreparedStatement pstmt_comp_age_wise_delete		= null ;
	Boolean isSiteSpecificYN = new Boolean(false);
	ResultSet resultSetAgeWise = null;
	//IN062992, ends
	
	//IN68241, starts
	ResultSet resultSetDosageTypeWise = null;
	PreparedStatement pstmt_comp_dosage_type_wise_insert	    = null ;
	PreparedStatement pstmt_comp_dosage_type_wise_select	= null ;
	PreparedStatement pstmt_comp_dosage_type_wise_delete		= null ; 
	int delete_comp_del_status_dosage_type_wise = 0;
	int dosageTypeWiseRecords = 0;
	String appl_to = "";
	//IN68241, ends
	
	//IN068370,IN068373, starts
	PreparedStatement pstmt_appl_facility = null;
	PreparedStatement pstmt_del_appl_facility = null;
	String globalFacilityYn = "N";
	Boolean siteSpecGlobalFac = false;
	//IN068370,IN068373, ends

	try 
	{
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;

		String[] l_appl_fac_id = null;//IN068370,IN068373
		ArrayList mappedFacilities = new ArrayList();//IN068370,IN068373

		HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");

		pt					 		=(Properties)tabDataParam.get("properties");


		HashMap	 careSetHeaderStr	=(HashMap)tabData_p.get("careSetHeaderStr");
		ArrayList componentStr		=(ArrayList)tabData_p.get("componentStr");
		ArrayList synonymsRec		=(ArrayList)tabData_p.get("synonymsStr");//passed as arrayList
		ArrayList billingRecStr		=(ArrayList)tabData_p.get("billingRecStr");
		HashMap billingStr			=(HashMap)billingRecStr.get(0);
		HashMap synonymsStr			=(HashMap)synonymsRec.get(0);
		ArrayList explanatoryRec		=(ArrayList)tabData_p.get("explanatoryStr");//passed as arrayList
		HashMap explanatoryStr			=(HashMap)explanatoryRec.get(0);
	//	String explanatory_text=(String)explanatoryStr.get("explanatory_text");
	//	careSetHeaderStr.put("explanatory_text",explanatory_text);

		ArrayList settingsStr		=(ArrayList)tabData_p.get("settingsStr");


		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;
		HashMap	componentAdditionalStr	=(HashMap)tabData_p.get("componentAdditionalStr");

		isSiteSpecificYN = (Boolean)tabData_p.get("isSiteSpecificYN");//IN062992
		appl_to = (String)tabData_p.get("app_to");//IN68241

		HashMap	componentAgeWiseStr	=(HashMap)tabData_p.get("componentAgeWiseStr");//IN062992
		HashMap	additionalComponentAgeWiseStr	=(HashMap)tabData_p.get("additionalComponentAgeWiseStr");//IN065713
		
		//IN68241, starts
		HashMap hashCatalogDosageTypeWise = (HashMap)tabData_p.get("hashCatalogDosageTypeWise");
		HashMap hashAdditionalCatalogDosageTypeKgWise = (HashMap)tabData_p.get("hashAdditionalCatalogDosageTypeKgWise");
		HashMap hashAdditionalCatalogDosageTypeM2Wise = (HashMap)tabData_p.get("hashAdditionalCatalogDosageTypeM2Wise");
		//IN68241, ends
		//IN068370,IN068373, starts
		if(careSetHeaderStr.containsKey("appl_fac_id"))
		{
			l_appl_fac_id = (String[])careSetHeaderStr.get("appl_fac_id");
		}
		
		mappedFacilities=(ArrayList)tabData_p.get("MappedFacilities");
		globalFacilityYn = (String)tabData_p.get("GlobalFacilityYn");
		siteSpecGlobalFac = (Boolean)tabData_p.get("SiteSpecGlobalFac");
		//IN068370,IN068373, ends

		connection = getConnection(pt) ;
		connection.setAutoCommit( false ) ;

		String SQL_OR_ORDERSET_UPDATE					= (String)sqlMap.get("SQL_OR_ORDERSET_UPDATE");
		String SQL_OR_ORDERSET_EFF_STATUS_SELECT		= (String)sqlMap.get("SQL_OR_ORDERSET_EFF_STATUS_SELECT");
		String SQL_OR_ORDERSET_EFF_STATUS_UPDATE		= (String)sqlMap.get("SQL_OR_ORDERSET_EFF_STATUS_UPDATE");


		String SQL_OR_ORDERSET_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_SYNONYM");
		String SQL_OR_ORDERSET_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_BY_PTCL");
		String SQL_OR_ORDERSET_INSERT_COMP				= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_COMP");
		

		String SQL_OR_ORDERSET_SYNONYM_DELETE			= (String)sqlMap.get("SQL_OR_ORDERSET_SYNONYM_DELETE");
		// String SQL_OR_ORDERSET_COMP_DELETE				= (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DELETE");
		//String SQL_OR_ORDERSET_COMP_DELETE				= "delete or_order_set_component where order_set_code = ? and OCURRANCE_NUM=1 ";//IN065144
		String SQL_OR_ORDERSET_COMP_DELETE				= "delete or_order_set_component where order_set_code = ?";//IN065144

		String SQL_OR_ORDERSET_PTCL_DELETE				= (String)sqlMap.get("SQL_OR_ORDERSET_PTCL_DELETE");
		
		
		
		String SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT				= (String)sqlMap.get("SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT");
		String SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE				= (String)sqlMap.get("SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE");

		//IN062992, starts
		String SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT				= (String)sqlMap.get("SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT");
		String SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT");
		String SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE");
		//IN062992, ends
		
		//IN68241, starts
		String SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT	= (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT");
		String SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT");
		String SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE = (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE");
		//IN68241, ends
		//IN068370,IN068373, starts
		String SQL_OR_CATALOG_BY_FACILITY_INSERT = "";
		String SQL_OR_CATALOG_BY_FACILITY_DELETE = "";
		
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			SQL_OR_CATALOG_BY_FACILITY_INSERT = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_INSERT");
			SQL_OR_CATALOG_BY_FACILITY_DELETE = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_DELETE");
		}
		//IN068370,IN068373, ends
		String order_set_code							=(String)careSetHeaderStr.get("order_set_code") ;
		traceVal.append("order_set_code="+order_set_code)	   ;
		String	order_category							=(String)careSetHeaderStr.get("order_category") ;
		String iv_prep_yn								=(String)careSetHeaderStr.get("iv_prep_yn") ;
		String contr_mod_id								=(String)careSetHeaderStr.get("contr_mod_id") ;
		String contr_msr_panel_id								=(String)careSetHeaderStr.get("contr_msr_panel_id") ;

		if(order_category!=null && !order_category.equals("PH"))
		iv_prep_yn									= "";	


		/*****EFFECTIVE STATUS CHK AND UPDATION*****************/

		String eff_status					= "";

		pstmt_eff = connection.prepareStatement(SQL_OR_ORDERSET_EFF_STATUS_SELECT);

		pstmt_eff.setString(1,order_set_code.trim());
		rs_eff	= pstmt_eff.executeQuery();

		if(rs_eff.next())
		eff_status =   rs_eff.getString("eff_status");

		closeResultSet( rs_eff ) ;
		closeStatement(pstmt_eff);

		if(eff_status.trim().equalsIgnoreCase("D"))
		{//Update only the Eff Status and return

			pstmt_eff = connection.prepareStatement(SQL_OR_ORDERSET_EFF_STATUS_UPDATE);

			pstmt_eff.setString(1 ,(String)careSetHeaderStr.get("eff_status"));
			pstmt_eff.setString(2 ,login_by_id);
			pstmt_eff.setString(3 ,login_at_ws_no);
			pstmt_eff.setString(4 ,login_facility_id);
			pstmt_eff.setString(5 ,order_set_code.trim());


			int update_eff_status = pstmt_eff.executeUpdate();

			closeStatement(pstmt_eff);
			if(update_eff_status > 0)
			{
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;

				map.put( "message", messages.toString() ) ;
				map.put( "traceVal", traceVal.toString() ) ;
				return map ;
			}

		}

		/****************DELETE RECORD IN THREE TABLES*****************/


		int update_syn_del_status =  0;
		int update_ptcl_del_status =  0;
		int update_comp_del_status =  0;
		int existing=0;

		del_pstmt_syn = connection.prepareStatement(SQL_OR_ORDERSET_SYNONYM_DELETE);
		del_pstmt_syn.setString(1,order_set_code.trim());
		update_syn_del_status = del_pstmt_syn.executeUpdate();

		closeStatement(del_pstmt_syn);
		traceVal.append("del=syn");


		del_pstmt_ptcl = connection.prepareStatement(SQL_OR_ORDERSET_PTCL_DELETE);
		del_pstmt_ptcl.setString(1,order_set_code.trim());
		update_ptcl_del_status = del_pstmt_ptcl.executeUpdate();

		closeStatement(del_pstmt_syn);

		traceVal.append("del=ptcl");

		del_pstmt_comp = connection.prepareStatement(SQL_OR_ORDERSET_COMP_DELETE);
		del_pstmt_comp.setString(1,order_set_code.trim());
		update_comp_del_status = del_pstmt_comp.executeUpdate();

		closeStatement(del_pstmt_syn);

		traceVal.append("del=inst");

		if(update_syn_del_status < 0 || update_ptcl_del_status < 0  || update_comp_del_status < 0  )
		{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			messages.append("Faliure") ;
			map.put( "message", "Some prob in delete" ) ;
			map.put( "traceVal", "Some prob in delete" ) ;
			return map ;
		}

		traceVal.append("delete done");



		/*************************************************************/

		pstmt_cr										= connection.prepareStatement(SQL_OR_ORDERSET_UPDATE);
		pstmt_syn										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_BY_PTCL);
		pstmt_comp										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_COMP);
		
		
		pstmt_add_select										= connection.prepareStatement(SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT);
		pstmt_add_delete										= connection.prepareStatement(SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE);

		//IN062992, starts
		if(isSiteSpecificYN.booleanValue())
		{
			pstmt_comp_age_wise_insert										= connection.prepareStatement(SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT);
			pstmt_comp_age_wise_select										= connection.prepareStatement(SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT);
			pstmt_comp_age_wise_delete										= connection.prepareStatement(SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE);
			
			//IN68241, starts
			pstmt_comp_dosage_type_wise_insert								= connection.prepareStatement(SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT);
			pstmt_comp_dosage_type_wise_select						    = connection.prepareStatement(SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT);
			pstmt_comp_dosage_type_wise_delete						    = connection.prepareStatement(SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE);
			//IN68241, ends
		}
		//IN062992, ends
		//IN068370,IN068373, starts
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			pstmt_appl_facility = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_INSERT);
			pstmt_del_appl_facility = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_DELETE);
		}
		//IN068370,IN068373, ends

		int	update_cr	= -1 ;
		int	insert_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_comp[]	= {} ;
		int	insert_comp_age_wise[]	= {} ;//IN062992
		int    delete_comp_del_status =  0;
		int    delete_comp_del_status_age_wise=  0;//IN062992
		int	insert_comp_dosage_type_wise[]	= {} ;//IN68241
		boolean insert_cmp_dosage_type_wise	=  false;//IN68241
		int insert_fac_mapping[] = {};//IN068370,IN068373

		/******************UPDATE INTO ORDER_CATALOG*************/

		pstmt_cr.setString(1	, (String)careSetHeaderStr.get("long_desc"));
		pstmt_cr.setString(2	, (String)careSetHeaderStr.get("short_desc"));
		pstmt_cr.setString(3	, (String)careSetHeaderStr.get("order_category"));
		pstmt_cr.setString(4	, (String)careSetHeaderStr.get("order_type_code"));
		pstmt_cr.setString(5	, (String)careSetHeaderStr.get("activity_type"));
		pstmt_cr.setString(6	, (String)careSetHeaderStr.get("security_level"));
	//	pstmt_cr.setString(7	, (String)careSetHeaderStr.get("explanatory_text"));
		pstmt_cr.setString(7	, (String)explanatoryStr.get("explanatory_text"));		
		pstmt_cr.setString(8	, "S");
		pstmt_cr.setString(9	, "N");
		pstmt_cr.setString(10	, "");
		pstmt_cr.setString(11	, "N");
		pstmt_cr.setString(12	, "");
		pstmt_cr.setString(13	, "N");
		pstmt_cr.setString(14	, "");
		pstmt_cr.setString(15	, "N");
		pstmt_cr.setString(16	, "N");
		pstmt_cr.setString(17	, "N");
		pstmt_cr.setString(18	, "N");
		pstmt_cr.setString(19	, "N");
		pstmt_cr.setString(20	, "N");
		pstmt_cr.setString(21	, ""); //from sql
		pstmt_cr.setString(22	, "N");
		pstmt_cr.setString(23	, "");
		pstmt_cr.setString(24	, "");
		pstmt_cr.setString(25	, "");
		pstmt_cr.setString(26	, "");
		pstmt_cr.setString(27	, "");
		pstmt_cr.setString(28	, "");
		pstmt_cr.setString(29	, "");
		pstmt_cr.setString(30	, "");
		pstmt_cr.setString(31	, "");
		pstmt_cr.setString(32	, "");
		pstmt_cr.setString(33	, "N");
		pstmt_cr.setString(34	, "");
		pstmt_cr.setString(35	, "N");
		pstmt_cr.setString(36	, "N");
		pstmt_cr.setString(37	, "N");
		//pstmt_cr.setString(38	,"N");
		pstmt_cr.setString(38	,(String)billingStr.get("bill_yn"));
		pstmt_cr.setString(39	, "N");
		pstmt_cr.setString(40	, "N");
		pstmt_cr.setString(41	, "");
		pstmt_cr.setString(42	, "");
		pstmt_cr.setString(43	, contr_mod_id);
		pstmt_cr.setString(44	, contr_msr_panel_id );
		pstmt_cr.setString(45	, "");
		pstmt_cr.setString(46	, (String)careSetHeaderStr.get("indexed_yn"));
		pstmt_cr.setString(47	, (String)careSetHeaderStr.get("discharge_indicator"));
		pstmt_cr.setString(48	, (String)careSetHeaderStr.get("eff_status"));
		pstmt_cr.setString(49	, "");
		pstmt_cr.setString(50	, login_by_id);
		pstmt_cr.setString(51	, login_at_ws_no);
		pstmt_cr.setString(52	, login_facility_id);
		pstmt_cr.setString(53	, "");
		pstmt_cr.setString(54	, iv_prep_yn);
		pstmt_cr.setString(55	, (String)billingStr.get("charge_type_applicable"));
		pstmt_cr.setString(56	, (String)billingStr.get("ord_set_charge_pat_yn"));
		pstmt_cr.setString(57	, order_set_code.trim());

		update_cr			= pstmt_cr.executeUpdate();
		//IN068370,IN068373, starts
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			pstmt_del_appl_facility.setString(1, order_set_code);
			pstmt_del_appl_facility.execute();
			
			if(mappedFacilities!=null && mappedFacilities.size()>0)
			{
				for(int i=0;i<mappedFacilities.size();i++)
				{
					pstmt_appl_facility.setString(1, order_set_code);
					pstmt_appl_facility.setString(2, (String)mappedFacilities.get(i));
					pstmt_appl_facility.setString(3	,login_by_id);
					pstmt_appl_facility.setString(4	,login_at_ws_no);
					pstmt_appl_facility.setString(5	,login_facility_id);
					pstmt_appl_facility.setString(6	,login_by_id);
					pstmt_appl_facility.setString(7	,login_at_ws_no);
					pstmt_appl_facility.setString(8	,login_facility_id);
					pstmt_appl_facility.addBatch();
				}
				
				insert_fac_mapping = pstmt_appl_facility.executeBatch();	
			}
		}
		//IN068370,IN068373, ends

		/**************INSERT INTO ORDER CATALOG SYNONYM**************/


		String 	effective_status_primary		= (String)synonymsStr.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)synonymsStr.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)synonymsStr.get("effective_status_ancillaryDept") ;

		if(effective_status_primary.trim().equalsIgnoreCase("Y"))
		{//This insertion is Mandatory
			
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"PR");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_primary"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_primary);//*************
			pstmt_syn.addBatch() ;

		}


		if(effective_status_directCare.trim().equalsIgnoreCase("Y"))
		{
			
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"DC");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_directCare"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_directCare);//*************
			pstmt_syn.addBatch() ;
		}



		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y"))
		{
			
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"AD");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_ancillaryDept"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_ancillaryDept);//*************
			pstmt_syn.addBatch();
		}


		insert_syn = pstmt_syn.executeBatch();


		/**************INSERT INTO OR_ORDER BY PTCL*******************/

		int sizeSettings			=settingsStr.size()  ;
		int iterateVal				=0;

		traceVal.append("Settings="+sizeSettings + "   //////");


		iterateVal = sizeSettings ;



		if(sizeSettings > 0)
		{ //i:e page is visited in  update mode
		///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same

			HashMap tempSetting=null;
			String setting_applicability="";
			String patient_class="";
			String age_group_code = "";//IN063686
			for(int i = 0; i < iterateVal ; i++)
			{//0 for the default

				tempSetting = (HashMap)settingsStr.get(i);
				setting_applicability	    =(String)tempSetting.get("setting_applicability");

				if(setting_applicability.trim().equalsIgnoreCase("A") || i== 0 )
				{

					patient_class	=(String)tempSetting.get("patient_class");
					age_group_code 	=(String)tempSetting.get("age_group_code"); //IN063686
					pstmt_ptcl.setString(1	 , order_set_code);
					pstmt_ptcl.setString(2	 , patient_class);
					pstmt_ptcl.setString(3	 , "X");
					pstmt_ptcl.setString(4	 , "N");
					pstmt_ptcl.setString(5	 , "N");
					pstmt_ptcl.setString(6	 , "N");
					pstmt_ptcl.setString(7	 , setting_applicability.trim());
					pstmt_ptcl.setString(8	 , "");
					pstmt_ptcl.setString(9	 , "");
					pstmt_ptcl.setString(10	 , "");
					pstmt_ptcl.setString(11	 , "");
					pstmt_ptcl.setString(12	 , "");
					pstmt_ptcl.setString(13	 , "");
					pstmt_ptcl.setString(14	 , "");
					pstmt_ptcl.setString(15	 , "");
					pstmt_ptcl.setString(16  , "");
					//IN063686 Start.
					/*pstmt_ptcl.setString(17	 , login_by_id);
					pstmt_ptcl.setString(18	 , login_at_ws_no);
					pstmt_ptcl.setString(19  , login_facility_id);
					pstmt_ptcl.setString(20  , login_by_id);
					pstmt_ptcl.setString(21  , login_at_ws_no);
					pstmt_ptcl.setString(22  , login_facility_id);
					pstmt_ptcl.setString(23  , "");*/ //Commented for IN063686
					pstmt_ptcl.setString(17	 , age_group_code);
					pstmt_ptcl.setString(18	 , login_by_id);
					pstmt_ptcl.setString(19	 , login_at_ws_no);
					pstmt_ptcl.setString(20  , login_facility_id);
					pstmt_ptcl.setString(21  , login_by_id);
					pstmt_ptcl.setString(22  , login_at_ws_no);
					pstmt_ptcl.setString(23  , login_facility_id);
					pstmt_ptcl.setString(24  , "");
					//IN063686 End.
					pstmt_ptcl.addBatch();

				}//end of For Loop for PTCL INSERTION
			}

			insert_ptcl = pstmt_ptcl.executeBatch();

		}
		else
		{ //Page not visisted in update mode

		   traceVal.append("Before assign insert_ptcl.length");
		   insert_ptcl = new int[1];
		}

		traceVal.append("afterInsertion="+insert_ptcl.length);


	/*****************INSERTION FOR OR ORDER Set Component************/

		int noOfRecords = componentStr.size() ;

		int ageWiseRecords = 0;//IN062992
		Integer ageWiseRecordsObj = new Integer(ageWiseRecords);//IN065713
		if(noOfRecords > 0)
		{ //i:e page is visited in  update mode

			HashMap currData = null;
			HashMap additionalCatalogs = new HashMap ();
			String  associate_yn = "";
			//String	index_values = "";//Check Style Violation
			//String	index = "";//Check Style Violation
			HashMap catalogValues = new HashMap();
			String l_dosage_type = "";//IN062992
			
			//IN068370,IN068373, starts
			if ("Y".equals(globalFacilityYn) && siteSpecGlobalFac) {
				ArrayList<String> mappingCatCombination = new ArrayList<String>();
				ArrayList<String> catalogs = new ArrayList<String>();

				for (int l = 0; l < noOfRecords; l++) {
					HashMap currRec = (HashMap) componentStr.get(l);
					if ("Y".equalsIgnoreCase((String)currRec.get("associate_yn"))) {
						catalogs.add((String) currRec.get("order_catalog_code"));
						for (int m = 0; m < mappedFacilities.size(); m++) {
							mappingCatCombination
									.add((String) ((HashMap) componentStr
											.get(l)).get("order_catalog_code")
											+ "#" + mappedFacilities.get(m));
						}
					}
				}

				ArrayList<String> combination = fetchMappingCombination(
						connection, catalogs, mappedFacilities);

				if (!combination.containsAll(mappingCatCombination))
					throw new Exception("ORDERSET_INCORRECT_CATALOG_COMB");
			}
			//IN068370,IN068373, end
			for(int k=0 ; k< noOfRecords ; k++)
			{
				currData	     =(HashMap)componentStr.get(k);
				associate_yn	 =(String)currData.get("associate_yn");
				l_dosage_type = (String)currData.get("dosage_type")==null?"":(String)currData.get("dosage_type");//IN062992

				traceVal.append("order_category="+order_category);

				if(associate_yn.trim().equalsIgnoreCase("Y"))
				{
					pstmt_comp.setString(1	, order_set_code==null?"":order_set_code);
					pstmt_comp.setString(2	, (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num"));
					pstmt_comp.setString(3	, (String)currData.get("order_catalog_code")==null?"":(String)currData.get("order_catalog_code"));
					pstmt_comp.setString(4	, (String)currData.get("order_type_code")==null?"":(String)currData.get("order_type_code"));
					//pstmt_comp.setString(5	,(String)currData.get("activity_type"));
					pstmt_comp.setString(5	, (String)currData.get("order_category")==null?"":(String)currData.get("order_category"));
					pstmt_comp.setString(6	, (String)currData.get("reqd_or_opt_ind")==null?"":(String)currData.get("reqd_or_opt_ind"));
					pstmt_comp.setString(7	, (String)currData.get("rel_start_date_time")==null?"":(String)currData.get("rel_start_date_time"));
					pstmt_comp.setString(8	, (String)currData.get("route_code")==null?"":(String)currData.get("route_code"));
					pstmt_comp.setString(9  , (String)currData.get("qty_unit")==null?"":(String)currData.get("qty_unit"));		//Not in sec phase
					pstmt_comp.setString(10 , (String)currData.get("qty_value")==null?"":(String)currData.get("qty_value"));	//Not in sec phase
					pstmt_comp.setString(11 , (String)currData.get("freq_code")==null?"":(String)currData.get("freq_code"));
					pstmt_comp.setString(12 , (String)currData.get("durn_value")==null?"":(String)currData.get("durn_value"));
					pstmt_comp.setString(13 , (String)currData.get("durn_type")==null?"":(String)currData.get("durn_type"));
					pstmt_comp.setString(14 , (String)currData.get("prompt_msg")==null?"":(String)currData.get("prompt_msg"));//Not in sec phase
					pstmt_comp.setString(15 , login_by_id);
					pstmt_comp.setString(16 , login_at_ws_no);
					pstmt_comp.setString(17 , login_facility_id);
					pstmt_comp.setString(18 , login_by_id);
					pstmt_comp.setString(19 , login_at_ws_no);
					pstmt_comp.setString(20 , login_facility_id);
					pstmt_comp.setInt(21 , 1);

					//IN062992, starts
					if(isSiteSpecificYN.booleanValue())
					{
						//IN68241, starts
						//pstmt_comp.setString(22 , l_dosage_type);
						int hashCatalogDosageTypeWiseSize = 0;
						String l_cat_code = (String)currData.get("order_catalog_code");
				
						if(hashCatalogDosageTypeWise!=null && hashCatalogDosageTypeWise.containsKey(l_cat_code))
							hashCatalogDosageTypeWiseSize = ((HashMap)hashCatalogDosageTypeWise.get(l_cat_code)).size();
							
						if(hashCatalogDosageTypeWise!=null && hashCatalogDosageTypeWiseSize > 0)
							pstmt_comp.setString(22 , "M");
						else
							pstmt_comp.setString(22 , null);
						//IN68241, ends						
					}
					//IN062992, ends

					pstmt_comp.addBatch();
					/*Added by Uma on 6/7/2010 for IN021348*/
					additionalCatalogs = new HashMap ();
					
					additionalCatalogs = (HashMap)componentAdditionalStr.get((String)currData.get("order_catalog_code"));

					pstmt_add_select.setString(1,order_set_code.trim());
					pstmt_add_select.setString(2,(String)currData.get("order_catalog_code"));
					resultSet = pstmt_add_select.executeQuery() ;

					while ( resultSet != null && resultSet.next() ) 
					{
						existing=1;
						int total_records = resultSet.getInt("total");
						
						if(total_records>0)
						{
							pstmt_add_delete.clearParameters();
							pstmt_add_delete.setString(1,order_set_code.trim());
							pstmt_add_delete.setString(2,(String)currData.get("order_catalog_code"));
							delete_comp_del_status = pstmt_add_delete.executeUpdate();	
						}
					}
					
					closeResultSet(resultSet);
					
					if(additionalCatalogs!=null)
					{
						if(additionalCatalogs.size()>0)
						{
							Set newmap = additionalCatalogs.keySet();

							Iterator iterator 	 = newmap.iterator();

							while( iterator. hasNext() )
							{									
								catalogValues = new HashMap();

								catalogValues = (HashMap)additionalCatalogs.get(iterator.next());	
								
								pstmt_comp.clearParameters();//IN065713
								pstmt_comp.setString(1	, order_set_code==null?"":order_set_code);
					
								pstmt_comp.setString(2	, (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num"));
								pstmt_comp.setString(3	, (String)currData.get("order_catalog_code")==null?"":(String)currData.get("order_catalog_code"));
								pstmt_comp.setString(4	, (String)catalogValues.get("order_type_code")==null?"":(String)catalogValues.get("order_type_code"));
								pstmt_comp.setString(5	, (String)currData.get("order_category")==null?"":(String)currData.get("order_category"));
								pstmt_comp.setString(6	, (String)catalogValues.get("reqd_or_opt_ind")==null?"":(String)catalogValues.get("reqd_or_opt_ind"));
								pstmt_comp.setString(7	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
								pstmt_comp.setString(8	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));
								pstmt_comp.setString(9  , (String)catalogValues.get("qty_value")==null?"":(String)catalogValues.get("qty_value"));//Not in sec phase
								pstmt_comp.setString(10 , (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));//Not in sec phase
								pstmt_comp.setString(11 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
								pstmt_comp.setString(12 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
								pstmt_comp.setString(13 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
								pstmt_comp.setString(14 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
								pstmt_comp.setString(15 , login_by_id);
								pstmt_comp.setString(16 , login_at_ws_no);
								pstmt_comp.setString(17 , login_facility_id);
								pstmt_comp.setString(18 , login_by_id);
								pstmt_comp.setString(19 , login_at_ws_no);
								pstmt_comp.setString(20 , login_facility_id);
								//pstmt_comp.setInt(21 , Integer.parseInt((String)catalogValues.get("index")));//IN68241
								
								//IN065713, starts
								if(isSiteSpecificYN.booleanValue())
								{
									pstmt_comp.setString(22, l_dosage_type);
									
									//IN68241, starts
									if("C".equals(appl_to))
										pstmt_comp.setInt(21 , Integer.parseInt((String)catalogValues.get("occ_no")));
									else
										pstmt_comp.setInt(21 , Integer.parseInt((String)catalogValues.get("index")));
								}//IN68241, ends
								else//IN68241, starts
								{
									pstmt_comp.setInt(21 , Integer.parseInt((String)catalogValues.get("index")));									
								}//IN68241, ends
								//IN065713, ends
								pstmt_comp.addBatch();
							}
						}
					}

					//pstmt_comp.addBatch();

					//IN062992, starts
					if(isSiteSpecificYN.booleanValue())
					{
						//HashMap additionalComponentAgeWise = new HashMap ();//IN065713
						HashMap componentAgeWise = new HashMap ();//IN065713
						
						//additionalComponentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
						componentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713

						pstmt_comp_age_wise_select.setString(1,order_set_code.trim());
						pstmt_comp_age_wise_select.setString(2,(String)currData.get("order_catalog_code"));
						resultSetAgeWise = pstmt_comp_age_wise_select.executeQuery() ;

						while ( resultSetAgeWise != null && resultSetAgeWise.next() ) 
						{
							int total_records = resultSetAgeWise.getInt("total");
							
							if(total_records>0)
							{
								pstmt_comp_age_wise_delete.clearParameters();
								pstmt_comp_age_wise_delete.setString(1,order_set_code.trim());
								pstmt_comp_age_wise_delete.setString(2,(String)currData.get("order_catalog_code"));
								delete_comp_del_status_age_wise = pstmt_comp_age_wise_delete.executeUpdate();	
							}
						}

						closeResultSet(resultSetAgeWise);//IN065713					
						
						//if("A".equals(currData.get("dosage_type")) && (additionalComponentAgeWise!=null))//IN065713
						//{//IN065713
						//if(additionalComponentAgeWise.size()>0)//IN065713
						//IN68241, commented starts
						/*if(componentAgeWise!=null && componentAgeWise.size()>0)//IN065713
						{
							//Set newmap = additionalComponentAgeWise.keySet();//IN065713
							Set newmap = componentAgeWise.keySet();//IN065713

							Iterator iterator 	 = newmap.iterator();

							while( iterator. hasNext() )
							{										
								catalogValues = new HashMap();

								//catalogValues = (HashMap)additionalComponentAgeWise.get(iterator.next());//IN065713
								catalogValues = (HashMap)componentAgeWise.get(iterator.next());//IN065713
																
								//IN065713, starts
								/*
								pstmt_comp_age_wise_insert.setString(1	, order_set_code==null?"":order_set_code);
						
								pstmt_comp_age_wise_insert.setString(2	, (String)catalogValues.get("order_set_seq_num")==null?"":(String)catalogValues.get("order_set_seq_num"));
								pstmt_comp_age_wise_insert.setString(3	, (String)catalogValues.get("order_catalog_code")==null?"":(String)catalogValues.get("order_catalog_code"));
								pstmt_comp_age_wise_insert.setString(4	, (String)catalogValues.get("age_group_code")==null?"":(String)catalogValues.get("age_group_code"));
								pstmt_comp_age_wise_insert.setString(5	, (String)catalogValues.get("qty_unit")==null?"":(String)catalogValues.get("qty_unit"));
								pstmt_comp_age_wise_insert.setString(6	, (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));
								
								pstmt_comp_age_wise_insert.setString(7 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
								pstmt_comp_age_wise_insert.setString(8 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
								pstmt_comp_age_wise_insert.setString(9 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
								pstmt_comp_age_wise_insert.setString(10	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
								pstmt_comp_age_wise_insert.setString(11	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));								
								pstmt_comp_age_wise_insert.setString(12 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
								pstmt_comp_age_wise_insert.setString(13 , login_by_id);
								pstmt_comp_age_wise_insert.setString(14 , login_at_ws_no);
								pstmt_comp_age_wise_insert.setString(15 , login_facility_id);
								pstmt_comp_age_wise_insert.setString(16 , login_by_id);
								pstmt_comp_age_wise_insert.setString(17 , login_at_ws_no);
								pstmt_comp_age_wise_insert.setString(18 , login_facility_id);
								ageWiseRecords++;
								pstmt_comp_age_wise_insert.addBatch();
								*/
								/*String l_order_set_seq_num = (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num");
								String l_order_catalog_code = (String)currData.get("order_catalog_code")==null?"":(String)currData.get("order_catalog_code");
								String l_age_group_code =(String)catalogValues.get("age_group_code")==null?"":(String)catalogValues.get("age_group_code");
								String l_qty_unit = (String)catalogValues.get("qty_unit")==null?"":(String)catalogValues.get("qty_unit");
								String l_qty_uom = (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom");
								String l_freq_code = (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code");
								String l_durn_value = (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value");
								String l_durn_type = (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type");
								String l_rel_start_date_time = (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time");
								String l_route_code = (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code");
								String l_prompt_msg = (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg");
								
								ageWiseRecords = ageWiseDataSettings(pstmt_comp_age_wise_insert, ageWiseRecords, order_set_code,l_order_set_seq_num,l_order_catalog_code,l_age_group_code,l_qty_unit,l_qty_uom,l_freq_code,l_durn_value,l_durn_type,l_rel_start_date_time,l_route_code,l_prompt_msg,login_by_id,login_at_ws_no,login_facility_id,"1");
								
								HashMap additionalComponentAgeWise = new HashMap ();
								
								String additionalCataKey = currData.get("order_catalog_code")+"_"+catalogValues.get("age_group_code");
								
								additionalComponentAgeWise = (HashMap)additionalComponentAgeWiseStr.get(additionalCataKey);
								
								HashMap additionalCatalogValues = null;
								
								if(additionalComponentAgeWise!=null && additionalComponentAgeWise.size()>0)
								{
									Set addiCompNewmap = additionalComponentAgeWise.keySet();

									Iterator addiCompItr 	 = addiCompNewmap.iterator();

									while( addiCompItr. hasNext() )
									{										
										additionalCatalogValues = new HashMap();

										additionalCatalogValues = (HashMap)additionalComponentAgeWise.get(addiCompItr.next());
										
										l_order_set_seq_num = (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num");
										l_order_catalog_code = (String)currData.get("order_catalog_code")==null?"":(String)currData.get("order_catalog_code");
										l_age_group_code =(String)catalogValues.get("age_group_code")==null?"":(String)catalogValues.get("age_group_code");
										l_qty_unit = (String)additionalCatalogValues.get("qty_unit")==null?"":(String)additionalCatalogValues.get("qty_unit");
										l_qty_uom = (String)additionalCatalogValues.get("qty_uom")==null?"":(String)additionalCatalogValues.get("qty_uom");
										l_freq_code = (String)additionalCatalogValues.get("freq_code")==null?"":(String)additionalCatalogValues.get("freq_code");
										l_durn_value = (String)additionalCatalogValues.get("durn_value")==null?"":(String)additionalCatalogValues.get("durn_value");
										l_durn_type = (String)additionalCatalogValues.get("durn_type")==null?"":(String)additionalCatalogValues.get("durn_type");
										l_rel_start_date_time = (String)additionalCatalogValues.get("rel_start_date_time")==null?"":(String)additionalCatalogValues.get("rel_start_date_time");
										l_route_code = (String)additionalCatalogValues.get("route_code")==null?"":(String)additionalCatalogValues.get("route_code");
										l_prompt_msg = (String)additionalCatalogValues.get("prompt_msg")==null?"":(String)additionalCatalogValues.get("prompt_msg");
										String l_occ_no = (String)(additionalCatalogValues.get("index")==null?"":additionalCatalogValues.get("index"));
										ageWiseRecords = ageWiseDataSettings(pstmt_comp_age_wise_insert,ageWiseRecords, order_set_code,l_order_set_seq_num,l_order_catalog_code,l_age_group_code,l_qty_unit,l_qty_uom,l_freq_code,l_durn_value,l_durn_type,l_rel_start_date_time,l_route_code,l_prompt_msg,login_by_id,login_at_ws_no,login_facility_id,l_occ_no);
									}//IN065713, ends
								}
							}							
						}*/
						//IN68241, ends
						
						//IN68241, starts				
						HashMap componentDosageTypeWise = new HashMap ();//IN065713
						
						//additionalComponentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
						componentDosageTypeWise = (HashMap)hashCatalogDosageTypeWise.get((String)currData.get("order_catalog_code"));//IN065713
						pstmt_comp_dosage_type_wise_select.setString(1,order_set_code.trim());
						pstmt_comp_dosage_type_wise_select.setString(2,(String)currData.get("order_catalog_code"));
						resultSetDosageTypeWise = pstmt_comp_dosage_type_wise_select.executeQuery() ;

						while ( resultSetDosageTypeWise != null && resultSetDosageTypeWise.next() ) 
						{
							int total_records = resultSetDosageTypeWise.getInt("total");
							
							if(total_records>0)
							{
								pstmt_comp_dosage_type_wise_delete.clearParameters();
								pstmt_comp_dosage_type_wise_delete.setString(1,order_set_code.trim());
								pstmt_comp_dosage_type_wise_delete.setString(2,(String)currData.get("order_catalog_code"));
								delete_comp_del_status_dosage_type_wise = pstmt_comp_dosage_type_wise_delete.executeUpdate();	
							}
						}

						closeResultSet(resultSetDosageTypeWise);
						
						if(componentDosageTypeWise!=null)//IN065713
						{
							if(componentDosageTypeWise.size()>0)//IN065713
							{
								Set newmap = componentDosageTypeWise.keySet();//IN065713

								Iterator iterator 	 = newmap.iterator();							

								while( iterator. hasNext() )
								{								
									catalogValues = new HashMap();									
									catalogValues = (HashMap)componentDosageTypeWise.get(iterator.next());//IN065713
									
									String l_order_set_seq_no =(String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num");
									int l_dosage_type_seq_no = Integer.parseInt((String)catalogValues.get("dosage_type_seq_no")==null?"":(String)catalogValues.get("dosage_type_seq_no"));
									String l_catalog_code  =(String)catalogValues.get("order_catalog_code")==null?"":(String)catalogValues.get("order_catalog_code");
									String dosage_type = (String)catalogValues.get("dosage_type")==null?"":(String)catalogValues.get("dosage_type");
									pstmt_comp_dosage_type_wise_insert.clearParameters();
									pstmt_comp_dosage_type_wise_insert.setString(1	, order_set_code==null?"":order_set_code);							
									pstmt_comp_dosage_type_wise_insert.setString(2	, l_order_set_seq_no);
									pstmt_comp_dosage_type_wise_insert.setString(3	, l_catalog_code);
									pstmt_comp_dosage_type_wise_insert.setInt(4	, 1);
									pstmt_comp_dosage_type_wise_insert.setString(5	, dosage_type);
									pstmt_comp_dosage_type_wise_insert.setString(6	, (String)catalogValues.get("qty_value")==null?"":(String)catalogValues.get("qty_value"));
									pstmt_comp_dosage_type_wise_insert.setString(7	, (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));
									pstmt_comp_dosage_type_wise_insert.setString(8 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
									pstmt_comp_dosage_type_wise_insert.setString(9 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
									pstmt_comp_dosage_type_wise_insert.setString(10 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
									pstmt_comp_dosage_type_wise_insert.setString(11	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
									pstmt_comp_dosage_type_wise_insert.setString(12	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));								
									pstmt_comp_dosage_type_wise_insert.setString(13 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
									pstmt_comp_dosage_type_wise_insert.setString(14 , login_by_id);
									pstmt_comp_dosage_type_wise_insert.setString(15 , login_at_ws_no);
									pstmt_comp_dosage_type_wise_insert.setString(16 , login_facility_id);
									pstmt_comp_dosage_type_wise_insert.setString(17 , login_by_id);
									pstmt_comp_dosage_type_wise_insert.setString(18 , login_at_ws_no);
									pstmt_comp_dosage_type_wise_insert.setString(19 , login_facility_id);
									pstmt_comp_dosage_type_wise_insert.setInt(20 , l_dosage_type_seq_no);//IN065713							
									dosageTypeWiseRecords++;
									pstmt_comp_dosage_type_wise_insert.addBatch();
									
									HashMap additionalComponentDosageTypeWise = new HashMap ();
									
									String additionalCataKeyKg = (String)currData.get("order_catalog_code");
									
									additionalComponentDosageTypeWise = (HashMap)hashAdditionalCatalogDosageTypeKgWise.get(additionalCataKeyKg);								
									
									if(dosage_type.equals("K") && additionalComponentDosageTypeWise!=null && additionalComponentDosageTypeWise.size()>0)
									{
										Set addiCompNewmap = additionalComponentDosageTypeWise.keySet();

										Iterator addiCompItr 	 = addiCompNewmap.iterator();

										while( addiCompItr. hasNext() )
										{										
											String occ_no = (String)addiCompItr.next();
											catalogValues = (HashMap)additionalComponentDosageTypeWise.get(occ_no);//IN065713
											
											pstmt_comp_dosage_type_wise_insert.clearParameters();
											pstmt_comp_dosage_type_wise_insert.setString(1	, order_set_code==null?"":order_set_code);
											
											//int l_occ_no = Integer.parseInt(occ_no);
											//String l_dosage_seq_no = (String)catalogValues.get("dosage_type_seq_no")==null?"":(String)catalogValues.get("dosage_type_seq_no");
											l_dosage_type =(String)catalogValues.get("dosage_type")==null?"":(String)catalogValues.get("dosage_type");					
											pstmt_comp_dosage_type_wise_insert.setString(2	, (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num"));
											pstmt_comp_dosage_type_wise_insert.setString(3	, l_catalog_code);
											pstmt_comp_dosage_type_wise_insert.setInt(4	, Integer.parseInt((String)catalogValues.get("occ_no")==null?"":(String)catalogValues.get("occ_no")));
											pstmt_comp_dosage_type_wise_insert.setString(5	, l_dosage_type);
											pstmt_comp_dosage_type_wise_insert.setString(6	, (String)catalogValues.get("qty_value")==null?"":(String)catalogValues.get("qty_value"));
											pstmt_comp_dosage_type_wise_insert.setString(7	, (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));
											pstmt_comp_dosage_type_wise_insert.setString(8 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
											pstmt_comp_dosage_type_wise_insert.setString(9 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
											pstmt_comp_dosage_type_wise_insert.setString(10 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
											pstmt_comp_dosage_type_wise_insert.setString(11	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
											pstmt_comp_dosage_type_wise_insert.setString(12	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));								
											pstmt_comp_dosage_type_wise_insert.setString(13 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
											pstmt_comp_dosage_type_wise_insert.setString(14 , login_by_id);
											pstmt_comp_dosage_type_wise_insert.setString(15 , login_at_ws_no);
											pstmt_comp_dosage_type_wise_insert.setString(16 , login_facility_id);
											pstmt_comp_dosage_type_wise_insert.setString(17 , login_by_id);
											pstmt_comp_dosage_type_wise_insert.setString(18 , login_at_ws_no);
											pstmt_comp_dosage_type_wise_insert.setString(19 , login_facility_id);
											pstmt_comp_dosage_type_wise_insert.setInt(20 , l_dosage_type_seq_no);//IN065713
											dosageTypeWiseRecords++;
											pstmt_comp_dosage_type_wise_insert.addBatch();
										}//IN065713, ends
									}									
									
								//	HashMap additionalComponentDosageTypeM2Wise = new HashMap ();  //Checkstyle
									
									String additionalCataKeyM2 = (String)currData.get("order_catalog_code");
									
									additionalComponentDosageTypeWise = (HashMap)hashAdditionalCatalogDosageTypeM2Wise.get(additionalCataKeyM2);
						
									if(dosage_type.equals("M") && additionalComponentDosageTypeWise!=null && additionalComponentDosageTypeWise.size()>0)
									{
										Set addiCompNewmap = additionalComponentDosageTypeWise.keySet();

										Iterator addiCompItr 	 = addiCompNewmap.iterator();

										while( addiCompItr. hasNext() )
										{										
											
											String occ_no = (String)addiCompItr.next();
											catalogValues = (HashMap)additionalComponentDosageTypeWise.get(occ_no);
											
											pstmt_comp_dosage_type_wise_insert.clearParameters();
											pstmt_comp_dosage_type_wise_insert.setString(1	, order_set_code==null?"":order_set_code);
											
											//int l_occ_no = Integer.parseInt(occ_no);									
											
											//String l_dosage_seq_no = (String)catalogValues.get("dosage_type_seq_no")==null?"":(String)catalogValues.get("dosage_type_seq_no");
											l_dosage_type =(String)catalogValues.get("dosage_type")==null?"":(String)catalogValues.get("dosage_type");
											pstmt_comp_dosage_type_wise_insert.setString(2	, (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num"));
											pstmt_comp_dosage_type_wise_insert.setString(3	, l_catalog_code);
											pstmt_comp_dosage_type_wise_insert.setInt(4	, Integer.parseInt((String)catalogValues.get("occ_no")==null?"":(String)catalogValues.get("occ_no")));
											pstmt_comp_dosage_type_wise_insert.setString(5	, l_dosage_type);
											pstmt_comp_dosage_type_wise_insert.setString(6	, (String)catalogValues.get("qty_value")==null?"":(String)catalogValues.get("qty_value"));
											pstmt_comp_dosage_type_wise_insert.setString(7	, (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom"));
											pstmt_comp_dosage_type_wise_insert.setString(8 , (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code"));
											pstmt_comp_dosage_type_wise_insert.setString(9 , (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value"));
											pstmt_comp_dosage_type_wise_insert.setString(10 , (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type"));
											pstmt_comp_dosage_type_wise_insert.setString(11	, (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time"));
											pstmt_comp_dosage_type_wise_insert.setString(12	, (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code"));								
											pstmt_comp_dosage_type_wise_insert.setString(13 , (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"));//Not in sec phase
											pstmt_comp_dosage_type_wise_insert.setString(14 , login_by_id);
											pstmt_comp_dosage_type_wise_insert.setString(15 , login_at_ws_no);
											pstmt_comp_dosage_type_wise_insert.setString(16 , login_facility_id);
											pstmt_comp_dosage_type_wise_insert.setString(17 , login_by_id);
											pstmt_comp_dosage_type_wise_insert.setString(18 , login_at_ws_no);
											pstmt_comp_dosage_type_wise_insert.setString(19 , login_facility_id);
											pstmt_comp_dosage_type_wise_insert.setInt(20 , l_dosage_type_seq_no);//IN065713
											dosageTypeWiseRecords++;
											pstmt_comp_dosage_type_wise_insert.addBatch();
										}//IN065713, ends
									}
									
									if(dosage_type.equals("A") && componentAgeWise!=null && componentAgeWise.size()>0)
									{
										if(componentAgeWise!=null && componentAgeWise.size()>0)//IN065713
										{											
											Set newmap1 = componentAgeWise.keySet();//IN065713

											Iterator iterator1 	 = newmap1.iterator();

											while( iterator1. hasNext() )
											{										
												catalogValues = new HashMap();												
												catalogValues = (HashMap)componentAgeWise.get(iterator1.next());//IN065713																				
												
												String l_order_set_seq_num = (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num");
												String l_order_catalog_code = (String)currData.get("order_catalog_code")==null?"":(String)currData.get("order_catalog_code");
												String l_age_group_code =(String)catalogValues.get("age_group_code")==null?"":(String)catalogValues.get("age_group_code");
												String l_qty_unit = (String)catalogValues.get("qty_unit")==null?"":(String)catalogValues.get("qty_unit");
												String l_qty_uom = (String)catalogValues.get("qty_uom")==null?"":(String)catalogValues.get("qty_uom");
												String l_freq_code = (String)catalogValues.get("freq_code")==null?"":(String)catalogValues.get("freq_code");
												String l_durn_value = (String)catalogValues.get("durn_value")==null?"":(String)catalogValues.get("durn_value");
												String l_durn_type = (String)catalogValues.get("durn_type")==null?"":(String)catalogValues.get("durn_type");
												String l_rel_start_date_time = (String)catalogValues.get("rel_start_date_time")==null?"":(String)catalogValues.get("rel_start_date_time");
												String l_route_code = (String)catalogValues.get("route_code")==null?"":(String)catalogValues.get("route_code");
												String l_prompt_msg = (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg");
												
												ageWiseRecords = ageWiseDataSettings(pstmt_comp_age_wise_insert, ageWiseRecords, order_set_code,l_order_set_seq_num,l_order_catalog_code,l_age_group_code,l_qty_unit,l_qty_uom,l_freq_code,l_durn_value,l_durn_type,l_rel_start_date_time,l_route_code,l_prompt_msg,login_by_id,login_at_ws_no,login_facility_id,"1",l_dosage_type_seq_no);
												
												HashMap additionalComponentAgeWise = new HashMap ();
												
												String additionalCataKey = currData.get("order_catalog_code")+"_"+catalogValues.get("age_group_code");
												
												additionalComponentAgeWise = (HashMap)additionalComponentAgeWiseStr.get(additionalCataKey);
												
												HashMap additionalCatalogValues = null;
												
												if(additionalComponentAgeWise!=null && additionalComponentAgeWise.size()>0)
												{
													Set addiCompNewmap = additionalComponentAgeWise.keySet();

													Iterator addiCompItr 	 = addiCompNewmap.iterator();

													while( addiCompItr. hasNext() )
													{										
														additionalCatalogValues = new HashMap();

														additionalCatalogValues = (HashMap)additionalComponentAgeWise.get(addiCompItr.next());
														
														l_order_set_seq_num = (String)currData.get("order_set_seq_num")==null?"":(String)currData.get("order_set_seq_num");
														l_order_catalog_code = (String)currData.get("order_catalog_code")==null?"":(String)currData.get("order_catalog_code");
														l_age_group_code =(String)catalogValues.get("age_group_code")==null?"":(String)catalogValues.get("age_group_code");
														l_qty_unit = (String)additionalCatalogValues.get("qty_unit")==null?"":(String)additionalCatalogValues.get("qty_unit");
														l_qty_uom = (String)additionalCatalogValues.get("qty_uom")==null?"":(String)additionalCatalogValues.get("qty_uom");
														l_freq_code = (String)additionalCatalogValues.get("freq_code")==null?"":(String)additionalCatalogValues.get("freq_code");
														l_durn_value = (String)additionalCatalogValues.get("durn_value")==null?"":(String)additionalCatalogValues.get("durn_value");
														l_durn_type = (String)additionalCatalogValues.get("durn_type")==null?"":(String)additionalCatalogValues.get("durn_type");
														l_rel_start_date_time = (String)additionalCatalogValues.get("rel_start_date_time")==null?"":(String)additionalCatalogValues.get("rel_start_date_time");
														l_route_code = (String)additionalCatalogValues.get("route_code")==null?"":(String)additionalCatalogValues.get("route_code");
														l_prompt_msg = (String)additionalCatalogValues.get("prompt_msg")==null?"":(String)additionalCatalogValues.get("prompt_msg");
														String l_occ_no = (String)(additionalCatalogValues.get("occ_no")==null?"":additionalCatalogValues.get("occ_no"));
													//	String l_dos_seq_no = (String)catalogValues.get("prompt_msg")==null?"":(String)catalogValues.get("prompt_msg"); //Checkstyle
														ageWiseRecords = ageWiseDataSettings(pstmt_comp_age_wise_insert,ageWiseRecords, order_set_code,l_order_set_seq_num,l_order_catalog_code,l_age_group_code,l_qty_unit,l_qty_uom,l_freq_code,l_durn_value,l_durn_type,l_rel_start_date_time,l_route_code,l_prompt_msg,login_by_id,login_at_ws_no,login_facility_id,l_occ_no,l_dosage_type_seq_no);
													}//IN065713, ends
												}
											}							
										}										
									}										
								}
							}
						}
						//IN68241, ends
					}
				}//End of if
				else
				{
					if(isSiteSpecificYN.booleanValue())
					{
						//HashMap additionalComponentAgeWise = new HashMap ();//IN065713
						HashMap componentAgeWise = new HashMap ();//IN065713
						
						//additionalComponentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
						componentAgeWise = (HashMap)componentAgeWiseStr.get((String)currData.get("order_catalog_code"));//IN065713
	
						pstmt_comp_age_wise_select.setString(1,order_set_code.trim());
						pstmt_comp_age_wise_select.setString(2,(String)currData.get("order_catalog_code"));
						resultSetAgeWise = pstmt_comp_age_wise_select.executeQuery() ;
	
						while ( resultSetAgeWise != null && resultSetAgeWise.next() ) 
						{
							int total_records = resultSetAgeWise.getInt("total");
							
							if(total_records>0)
							{
								pstmt_comp_age_wise_delete.clearParameters();
								pstmt_comp_age_wise_delete.setString(1,order_set_code.trim());
								pstmt_comp_age_wise_delete.setString(2,(String)currData.get("order_catalog_code"));
								delete_comp_del_status_age_wise = pstmt_comp_age_wise_delete.executeUpdate();	
							}
						}
	
						closeResultSet(resultSetAgeWise);
						
						//IN68241, starts
						HashMap componentDosageTypeWise = new HashMap ();
						componentDosageTypeWise = (HashMap)hashCatalogDosageTypeWise.get((String)currData.get("order_catalog_code"));
						pstmt_comp_dosage_type_wise_select.setString(1,order_set_code.trim());
						pstmt_comp_dosage_type_wise_select.setString(2,(String)currData.get("order_catalog_code"));
						resultSetDosageTypeWise = pstmt_comp_dosage_type_wise_select.executeQuery() ;

						while ( resultSetDosageTypeWise != null && resultSetDosageTypeWise.next() ) 
						{
							int total_records = resultSetDosageTypeWise.getInt("total");
							
							if(total_records>0)
							{
								pstmt_comp_dosage_type_wise_delete.clearParameters();
								pstmt_comp_dosage_type_wise_delete.setString(1,order_set_code.trim());
								pstmt_comp_dosage_type_wise_delete.setString(2,(String)currData.get("order_catalog_code"));
								delete_comp_del_status_dosage_type_wise = pstmt_comp_dosage_type_wise_delete.executeUpdate();	
							}
						}
						
						closeResultSet(resultSetDosageTypeWise);
						//IN68241, ends
					}
				}
				//IN062992, ends
			 } //End of For loop

			 insert_comp = pstmt_comp.executeBatch();

			 //IN062992, starts
			 if(isSiteSpecificYN.booleanValue() && ageWiseRecords>0)
				insert_comp_age_wise = pstmt_comp_age_wise_insert.executeBatch();			
			 //IN062992, ends
			 
			//IN68241, starts
			if(isSiteSpecificYN.booleanValue() && dosageTypeWiseRecords>0)
				insert_comp_dosage_type_wise = pstmt_comp_dosage_type_wise_insert.executeBatch();
			//IN68241, ends
			 /*Ends Here by Uma on 6/7/2010 for IN021348*/
		}
		else
		{//In case page is not visited the no Updation required		    
			insert_comp = new int[1];		 
			insert_comp_age_wise = new int[1];//IN062992 
		}

		traceVal.append("insert_comp="+insert_comp.length);

		/*pstmt_add_select.setString(1,order_set_code.trim());
		pstmt_add_select.setString(2,order_set_code.trim());
		resultSet = pstmt_add_select.executeQuery() ;

		while ( resultSet != null && resultSet.next() ) 
		{
			existing=1;
			String record = resultSet.getString("catalog_code");

			pstmt_add_delete.setString(1,order_set_code.trim());
			pstmt_add_delete.setString(2,record.trim());
			delete_comp_del_status = pstmt_add_delete.executeUpdate();				
		}*/

		boolean insert_cmp	=  false ;
		boolean insert_cmp_age_wise	=  false ;//IN062992
		boolean insert_ptl	=  false ;
		boolean insert_sy	=  false ;
		//boolean insert_add	=  true ;//Check Style Violation
		boolean bool_insert_fac_mapping = true;//IN068370,IN068373


		 if((insert_comp.length > 0))
		 { //check updation in Component
			insert_cmp= true ;
		 }
		 else if((insert_comp.length == (-3)))
		 {
			insert_cmp= false ;
		 }


		//IN062992, starts
		//if(isSiteSpecificYN.booleanValue() && ageWiseRecords>0)//IN065713
		if(isSiteSpecificYN.booleanValue() && ageWiseRecordsObj.intValue()>0)//IN065713
		{
		 if((insert_comp_age_wise.length > 0))
		 { //check updation in Component
			insert_cmp_age_wise= true ;
		 }
		 else if((insert_comp_age_wise.length == (-3)))
		 {
			insert_cmp_age_wise= false ;
		 }
		}
		else
		{
			insert_cmp_age_wise = true;
		}
		//IN062992, ends

		 //IN68241, starts
		 if(isSiteSpecificYN.booleanValue() && dosageTypeWiseRecords>0)
			{
			 if((insert_comp_dosage_type_wise.length > 0))
			 { //check updation in Component
				insert_cmp_dosage_type_wise= true ;
			 }
			 else if((insert_comp_dosage_type_wise.length == (-3)))
			 {
				 insert_cmp_dosage_type_wise= false ;
			 }
			}
			else
			{
				insert_cmp_dosage_type_wise = true;
			}	
		 //IN68241, ends
		 if((insert_ptcl.length > 0))
		 { //check updation in PTCL
			insert_ptl= true ;
		 }
		 else if((insert_ptcl.length == (-3)))
		 {
			insert_ptl= false ;
		 }

		 if((insert_syn.length > 0))
		 { //check updation in SYN
		
			insert_sy= true ;
		 }
		 else if((insert_syn.length == (-3)))
		 {
			insert_sy= false ;
		 }

		/*if(existing>0)
		{
			if(delete_comp_del_status>0)
			{
				insert_add=true;
			}
			else
			{
				insert_add=false;
			}
		}*/
		 //IN068370,IN068373, starts
		 if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		 {
			 if(insert_fac_mapping.length >0)
			 {
				 bool_insert_fac_mapping= true ;
			 }
			 else if((insert_fac_mapping.length == (-3)))
			 {
				 bool_insert_fac_mapping= false ;
			 }
		 }
		 //IN068370,IN068373, ends

		//if (update_cr > 0  && insert_sy  && insert_cmp && insert_ptl)// && insert_add)//IN062992
		//if (update_cr > 0  && insert_sy  && insert_cmp && insert_ptl && insert_cmp_age_wise)// && insert_add)//IN062992
		 //if (update_cr > 0  && insert_sy  && insert_cmp && insert_ptl && insert_cmp_age_wise && insert_cmp_dosage_type_wise)// && insert_add)//IN062992//CRF-1227//IN068370,IN068373
		 if (update_cr > 0  && insert_sy  && insert_cmp && insert_ptl && insert_cmp_age_wise && insert_cmp_dosage_type_wise && bool_insert_fac_mapping)// && insert_add)//IN062992//CRF-1227//IN068370,IN068373
		{
			/*connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append("RECORD_MODIFIED") ;*/
			/*Added by Uma on 9/30/2009 for PMG_CRF-0641*/
			
			boolean status_flg = false;
			status_flg = executeProcedure(connection,((String)careSetHeaderStr.get("order_set_code")));

			 if(status_flg)
			{
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_MODIFIED") ;
			}
			else
			{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
			}
			/*Ends Here*/
		}
		else
		{
			connection.rollback();
			messages.append( "Insert Failed" ) ;
		}
	}
	catch( Exception e )
	{
		traceVal.append("In Exception==");
		e.printStackTrace();
		traceVal.append(e.getMessage());
		map.put( "traceVal", traceVal.toString() ) ;

		try 
		{
			connection.rollback();
			closeConnection( connection,pt );
		} 
		catch ( Exception ee ) 
		{
			messages.append(ee.getMessage() ) ;
		}
		messages.append( e.getMessage() ) ;
		e.printStackTrace() ;
	} 
	finally
	{
		try 
		{
			closeStatement( pstmt_cr ) ;
			closeStatement( pstmt_comp ) ;
			closeStatement( pstmt_syn ) ;
			closeStatement( pstmt_ptcl ) ;
			closeStatement( pstmt_add_select) ;
			closeStatement( pstmt_add_delete) ;
			closeStatement( del_pstmt_syn ) ;
			closeStatement( del_pstmt_ptcl ) ;
			closeStatement( del_pstmt_comp ) ;
			closeStatement( pstmt_eff ) ;

			closeResultSet( rs_eff ) ;
			closeResultSet( resultSet ) ;
			//IN062992, starts
			closeResultSet(resultSetAgeWise);
			closeStatement(pstmt_comp_age_wise_insert);
			closeStatement(pstmt_comp_age_wise_select);
			closeStatement(pstmt_comp_age_wise_delete);
			//IN062992, ends
			
			//IN68241, starts
			closeResultSet(resultSetDosageTypeWise);
			closeStatement(pstmt_comp_dosage_type_wise_insert);
			closeStatement(pstmt_comp_dosage_type_wise_select);
			closeStatement(pstmt_comp_dosage_type_wise_delete);
			//IN68241, ends
		
			closeStatement(pstmt_appl_facility);//IN068370,IN068373
			closeStatement(pstmt_del_appl_facility);//IN068370,IN068373
			closeConnection( connection,pt);
		} 
		catch ( Exception fe ) 
		{
			fe.printStackTrace() ;
		}
	}

	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;

}

/*****************************************************************************/
/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap delete( HashMap tabData, HashMap sqlMap ) 
{

	StringBuffer messages = new StringBuffer() ;
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag", "") ;
	map.put( "callOnSuccess", new Boolean( false ) ) ;
	map.put( "message", messages.toString() ) ;

	return map ;
}

	/****************************************************************************/
/**
* @ejb.interface-method
*	 view-type="both"
*/
/*Added by Uma on 9/30/2009 for PMG20089-641 to post the orderset to privilege*/
	private boolean executeProcedure(Connection connection,String order_set_code) throws Exception
	{
		String p_error_message = "";
		CallableStatement cstmt 	= null;
		try{

			cstmt			= connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_POST_CATALOG_PRIV_REC")+" }");
			cstmt.setString(1,(String)order_set_code);						 // P_CATALOG_CODE
			cstmt.registerOutParameter( 2,  Types.VARCHAR ) ; 	// P_ERROR_MSG
			cstmt.execute();
			p_error_message	= cstmt.getString(2);  // message
			if(p_error_message!=null && p_error_message!="null" && !p_error_message.equals(""))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace() ;
			connection.rollback();
			throw e ;
		}
		finally
		{
			try
			{
				closeStatement( cstmt);
			} catch(Exception exec)
			{
				exec.printStackTrace();
			}
		}
	}
	/* End Here*/

//IN065713, starts
//private int ageWiseDataSettings(PreparedStatement pstmt_comp_age_wise_insert, int ageWiseRecords, String order_set_code,String order_set_seq_num,String order_catalog_code,String age_group_code,String qty_unit,String qty_uom,String freq_code,String durn_value,String durn_type,String rel_start_date_time,String route_code,String prompt_msg,String login_by_id,String login_at_ws_no,String login_facility_id,String occ_no) throws Exception//IN68241
private int ageWiseDataSettings(PreparedStatement pstmt_comp_age_wise_insert, int ageWiseRecords, String order_set_code,String order_set_seq_num,String order_catalog_code,String age_group_code,String qty_unit,String qty_uom,String freq_code,String durn_value,String durn_type,String rel_start_date_time,String route_code,String prompt_msg,String login_by_id,String login_at_ws_no,String login_facility_id,String occ_no, int dosage_seq_no) throws Exception//IN68241
{
	try
	{
	pstmt_comp_age_wise_insert.setString(1	, order_set_code==null?"":order_set_code);	
	pstmt_comp_age_wise_insert.setString(2	, order_set_seq_num);
	pstmt_comp_age_wise_insert.setString(3	, order_catalog_code);
	pstmt_comp_age_wise_insert.setString(4	, age_group_code);
	pstmt_comp_age_wise_insert.setString(5	, qty_unit);
	pstmt_comp_age_wise_insert.setString(6	, qty_uom);	
	pstmt_comp_age_wise_insert.setString(7 , freq_code);
	pstmt_comp_age_wise_insert.setString(8 , durn_value);
	pstmt_comp_age_wise_insert.setString(9 , durn_type);
	pstmt_comp_age_wise_insert.setString(10	, rel_start_date_time);
	pstmt_comp_age_wise_insert.setString(11	, route_code);								
	pstmt_comp_age_wise_insert.setString(12 , prompt_msg);
	pstmt_comp_age_wise_insert.setString(13 , login_by_id);
	pstmt_comp_age_wise_insert.setString(14 , login_at_ws_no);
	pstmt_comp_age_wise_insert.setString(15 , login_facility_id);
	pstmt_comp_age_wise_insert.setString(16 , login_by_id);
	pstmt_comp_age_wise_insert.setString(17 , login_at_ws_no);
	pstmt_comp_age_wise_insert.setString(18 , login_facility_id);
	pstmt_comp_age_wise_insert.setInt(19 , Integer.parseInt(occ_no));
	pstmt_comp_age_wise_insert.setInt(20 , dosage_seq_no);//IN68241
	ageWiseRecords++;
	pstmt_comp_age_wise_insert.addBatch();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return ageWiseRecords;
}
//IN065713, ends

	//IN068370,IN068373, starts
	private ArrayList<String> fetchMappingCombination(Connection connection,
			ArrayList catalog, ArrayList appl_fac) {

		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList<String> combinationRecords = new ArrayList<String>();

		String catalog_list = "";
		String appl_fac_list = "";

		catalog_list = extractString(catalog);
		appl_fac_list = extractString(appl_fac);

		String sql = " SELECT (order_catalog_code || '#' || applicable_facility_id) combination FROM or_order_catalog_by_facility WHERE order_catalog_code IN ("
				+ catalog_list
				+ ") AND applicable_facility_id IN ("
				+ appl_fac_list + ")";

		try {

			pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();
			while (resultSet.next())
				combinationRecords.add(resultSet.getString("combination"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return combinationRecords;
	}

	private String extractString(ArrayList input) {
		String str = "";

		for (int j = 0; j < input.size(); j++) {
			str = str + "'" + input.get(j) + "'";

			if (j != input.size() - 1)
				str = str + ",";
		}
		return str;
	}
	//IN068370,IN068373, ends
}
