/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
18/11/2012	  IN031304		Karthi L		new checkbox field Visit type and fucntionality introduced(IN035976)
10/03/2014	  IN024984		Chowminya										Duplicate order recording with reason - new mandatory option
-------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
11/07/2014	  IN048467		Karthi L										To have an indicator to skip the authorization process if the priority for that order is urgent.
22/09/2014 	  IN049998		Nijitha S										Setting Tab in Pharmacy order catalog is not update accordingly.
08/05/2017	IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]
15/12/2017	IN065942	Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
17/07/2018	IN064543		Kamalakannan 17/07/2018		Ramesh G					ML-MMOH-CRF-0776
01/08/2018	IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
20/11/2018	ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
10/05/2019  IN068926       sivabagyam      10/05/2019      Ramesh G    	 ML-MMOH-CRF-1290
23/12/2019	IN068314	Nijitha		  23/12/2019			Ramesh G	 ML-MMOH-CRF-1229
07/09/2020	7540			Nijitha S		07/12/2020		Nijitha S		PMG2019-MMS-CRF-0004.1
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR.OROrderCatalog ;

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
*	name="OROrderCatalog"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrderCatalog"
*	local-jndi-name="OROrderCatalog"
*	impl-class-name="eOR.OROrderCatalog.OROrderCatalogManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOR.OROrderCatalog.OROrderCatalogLocal"
*	remote-class="eOR.OROrderCatalog.OROrderCatalogRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrderCatalog.OROrderCatalogLocalHome"
*	remote-class="eOR.OROrderCatalog.OROrderCatalogHome"
*	generate= "local,remote"
*
*
*/

public class OROrderCatalogManager extends OrEJBSessionAdapter
{
//StringBuffer messages = new StringBuffer() ;
//StringBuffer traceVal = new StringBuffer() ;

private final long daysInMonthsEJB[]    = {0,31,59,90,120,151,181,212,242,273,304,334,365};

private long getDaysEJB(long yrs,int mths,long days)
{
	return 	(yrs*365 + daysInMonthsEJB[mths] + days) ;
}


/*******************this method give range of duplicates******************/
private boolean chkDuplicate(String sql,Connection con , String arr[]) throws Exception{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = null;
	ResultSet rs	         = null ;
try{


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
	 } finally {
	 	closeResultSet( rs ) ;
  		closeStatement( pstmt ) ;
	}

}//End of dulicate chk

/****************************************************************************/

/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap insert(HashMap tabDataParam , HashMap sqlMap )
{	
StringBuffer messages =  null ;
StringBuffer traceVal =  null ;
HashMap map			  =  null ;
Connection connection =  null ;
Properties  pt		  =  null ;
PreparedStatement pstmt_ch	    = null ;
PreparedStatement pstmt_type	= null ;
PreparedStatement pstmt_syn		= null ;
PreparedStatement pstmt_ptcl	= null ;
PreparedStatement pstmt_Instr	= null ;
PreparedStatement pstmt_Freq	= null ;
PreparedStatement	pstmt_format	 =null;
ResultSet	rs						 =null;
PreparedStatement pstmt_appl_facility = null;//IN068370,IN068373
PreparedStatement pstmt_del_appl_facility = null;//IN068370,IN068373

PreparedStatement pstmt_Prep	= null ;
ArrayList clobDataAge = null;
String globalFacilityYn = "N";//IN068370,IN068373
Boolean siteSpecGlobalFac = false;//IN068370,IN068373
try {
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;

		HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");
	//	traceVal.append("tabData_p="+tabData_p.toString());


		  pt      		=(Properties)tabDataParam.get("properties");

		  HashMap	CatalogHeader	=new HashMap();
		  ArrayList Characterstics	=new ArrayList();
		  ArrayList TurnAround		=new ArrayList();
		  ArrayList Reviews			=new ArrayList();
		  ArrayList Frequencies     =new ArrayList();
		  ArrayList Settings		=new ArrayList();
		  ArrayList Instructions	=new ArrayList();
		  HashMap InstructionClobTemp	=new HashMap();//ML-MMOH-SCF-1108
		  ArrayList Prep			=new ArrayList();
		  ArrayList PrepDetail      =new ArrayList();
		  HashMap tempReview  = new HashMap();
		  HashMap tempSetting = new HashMap();
		  String[] l_appl_fac_id = null;//IN068370,IN068373
		  ArrayList mappedFacilities = new ArrayList();//IN068370,IN068373

		if (((HashMap)tabData_p.get("CatalogHeader"))!=null)
			CatalogHeader		=(HashMap)tabData_p.get("CatalogHeader");

		//IN068370,IN068373, starts
		if(CatalogHeader.containsKey("appl_fac_id"))
		{
			l_appl_fac_id =(String[])CatalogHeader.get("appl_fac_id");			
		}
		//IN068370,IN068373, ends
		if (((ArrayList)tabData_p.get("Characterstics"))!=null)
		Characterstics	=(ArrayList)tabData_p.get("Characterstics");


		if (((ArrayList)tabData_p.get("TurnAround"))!=null)
		TurnAround        =(ArrayList)tabData_p.get("TurnAround");

		if (((ArrayList)tabData_p.get("Reviews"))!=null)
		Reviews			=(ArrayList)tabData_p.get("Reviews");

		if (((ArrayList)tabData_p.get("Frequency"))!=null)
		Frequencies       =(ArrayList)tabData_p.get("Frequency");

		if (((ArrayList)tabData_p.get("Settings"))!=null)
		Settings			=(ArrayList)tabData_p.get("Settings");

		if (((ArrayList)tabData_p.get("Instructions"))!=null)
		Instructions		=(ArrayList)tabData_p.get("Instructions");
		//ML-MMOH-SCF-1108 start
		if (((HashMap)tabData_p.get("InstructionClobTemp"))!=null)
			InstructionClobTemp		=(HashMap)tabData_p.get("InstructionClobTemp");
		//ML-MMOH-SCF-1108 end	
		if (((ArrayList)tabData_p.get("Prep"))!=null)
		Prep       =(ArrayList)tabData_p.get("Prep");

		if (((ArrayList)tabData_p.get("PrepDetail"))!=null)
		PrepDetail       =(ArrayList)tabData_p.get("PrepDetail");
		///Clear
		//IN068370,IN068373, starts
		mappedFacilities=(ArrayList)tabData_p.get("MappedFacilities");		
		globalFacilityYn = (String)tabData_p.get("GlobalFacilityYn");
		siteSpecGlobalFac = (Boolean)tabData_p.get("SiteSpecGlobalFac");
		//IN068370,IN068373, ends

		HashMap charactersticsRec	=(HashMap)Characterstics.get(0) ;
		

		HashMap turnAroundRec       =(HashMap)TurnAround.get(0);
		HashMap reviews				=(HashMap)Reviews.get(0) ;
	//	HashMap settings			=(HashMap)Settings.get(0) ;

        HashMap prepRec             = (HashMap)Prep.get(0);

		/*Instr*/
		HashMap	recordOrderCatalog  =(HashMap)Instructions.get(0);
		HashMap	recordPreps		    =(HashMap)Instructions.get(1);
		HashMap	recordStdIntruction =(HashMap)Instructions.get(2);
		HashMap	recordByAge			=(HashMap)Instructions.get(3);


		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;
		tabData_p.clear();

		 connection = getConnection(pt) ;
	 //	 connection = getConnection() ;



		 String SQL_OR_CATALOG_DUP_CHK					= (String)sqlMap.get("SQL_OR_CATALOG_DUP_CHK");
		 String SQL_OR_CATALOG_INSERT					= (String)sqlMap.get("SQL_OR_CATALOG_INSERT");
		 String SQL_OR_CATALOG_INSERT_BY_TYPE			= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_BY_TYPE");
		 String SQL_OR_CATALOG_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_SYNONYM");
		 String SQL_OR_CATALOG_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_BY_PTCL");
		 String SQL_OR_CATALOG_INSERT_PREPS_INSTRN		= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_PREPS_INSTRN");

		//To get value for feild format_id for insertion in order Catalog
		 String SQL_OR_CATALOG_FORMAT_ID1				= (String)sqlMap.get("SQL_OR_CATALOG_FORMAT_ID1");
		 String SQL_OR_CATALOG_FORMAT_ID2				= (String)sqlMap.get("SQL_OR_CATALOG_FORMAT_ID2");

		 String SQL_OR_CATALOG_FREQUENCY_INSERT			= (String)sqlMap.get("SQL_OR_CATALOG_FREQUENCY_INSERT");

		 String SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT			= (String)sqlMap.get("SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT");
	//	 String SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE			= (String)sqlMap.get("SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE");
		String SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS = (String)sqlMap.get("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS");//IN64543
		String SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM = (String)sqlMap.get("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM");//IN64543
		//sqlMap.clear();
		//tabDataParam.clear();
		
		//IN068370,IN068373, starts
		String SQL_OR_CATALOG_BY_FACILITY_INSERT = "";
		String SQL_OR_CATALOG_BY_FACILITY_DELETE = "";
		
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			SQL_OR_CATALOG_BY_FACILITY_INSERT = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_INSERT");
			SQL_OR_CATALOG_BY_FACILITY_DELETE = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_DELETE");
		}
		//IN068370,IN068373, ends


         String	order_category		=(String)CatalogHeader.get("order_category") ;
		String  order_type_code		=(String)CatalogHeader.get("order_type_code") ;
//		String  activity_type		=(String)CatalogHeader.get("activity_type") ;

		String 	order_catalog_code  =(String)CatalogHeader.get("order_catalog_code") ;


		/********DUPLICATE CHK*****************************************/
		String arrChkDup[]  =  new String[1] ;

		arrChkDup[0] = order_catalog_code ;

		boolean duplicate = chkDuplicate(SQL_OR_CATALOG_DUP_CHK,connection,arrChkDup);

		if(duplicate){

		  String msg  =	 "CODE_ALREADY_EXISTS";
		  map.put( "message", msg ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}
		
		/********************GET FORMAT ID***************************/
		String field_format_id				 ="";

		boolean		fieldFlag				 =false;

		pstmt_format = connection.prepareStatement(SQL_OR_CATALOG_FORMAT_ID1);

		pstmt_format.setString(1,order_category);
		pstmt_format.setString(2,order_type_code);
		//pstmt_format.setString(3,activity_type);

		rs	= pstmt_format.executeQuery();

		if(rs.next()){
			field_format_id = rs.getString("format_id");
			fieldFlag		= true;
		}

		closeResultSet( rs ) ;
		closeStatement(pstmt_format);

		if(!fieldFlag){
		pstmt_format		= null ;
		rs					= null ;
		pstmt_format =connection.prepareStatement(SQL_OR_CATALOG_FORMAT_ID2);
		pstmt_format.setString(1,order_category);
		rs	= pstmt_format.executeQuery();

		if(rs.next()){
			field_format_id = rs.getString("format_id");
			fieldFlag		= false;
		}
			closeResultSet( rs ) ;
			closeStatement(pstmt_format);
		}

		if(!fieldFlag){
		field_format_id = null ;
//		map.put( "message", "Cannot get Feild formai Id Transaction ....did not proceed" ) ;
//		map.put( "traceVal", traceVal.toString() ) ;
//		return map ;
		}
	//	traceVal.append("field_format_id="+field_format_id);


		/*************************************************************/

		pstmt_ch										= connection.prepareStatement(SQL_OR_CATALOG_INSERT);
		pstmt_type										= connection.prepareStatement(SQL_OR_CATALOG_INSERT_BY_TYPE);
		pstmt_syn										= connection.prepareStatement(SQL_OR_CATALOG_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_CATALOG_INSERT_BY_PTCL);
		pstmt_Instr										= connection.prepareStatement(SQL_OR_CATALOG_INSERT_PREPS_INSTRN);
        pstmt_Freq                                      = connection.prepareStatement(SQL_OR_CATALOG_FREQUENCY_INSERT);
        pstmt_Prep                                      = connection.prepareStatement(SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT);
        //IN068370,IN068373, starts
        if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
        {
        	pstmt_appl_facility                             = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_INSERT);
        	pstmt_del_appl_facility                         = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_DELETE);
        }
		//IN068370,IN068373, ends
		int	insert_ch		= -1 ;
		int	insert_type		= -1 ;
		int	insert_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_Instr[]	= {} ;
		int	insert_Freq[]	= {} ;
		int	insert_Prep[]	= {} ;
		int insert_fac_mapping[] = {};//IN068370,IN068373
		int indexCnt =1;//IN068314

		/******************INSERT INTO ORDER_CATALOG*************/

		String comment_format_id			 ="";
		String	pat_instrn_age_sex_yn 		 ="N";
		//IN64543, starts
		//String	temp				 		 =(String)recordOrderCatalog.get("pat_preps_or_instrns_id");		
		String	temp = "";
		
		if(((String)recordOrderCatalog.get("instrn_content_type")).equals("T"))
			temp = (String)recordOrderCatalog.get("pat_preps_or_instrns_id");
		else if(((String)recordOrderCatalog.get("instrn_content_type")).equals("E"))
			temp = (String)recordOrderCatalog.get("pat_instrns_free_fmt_id");
		//IN64543, ends

		if(temp.trim().equalsIgnoreCase("IM")){
		pat_instrn_age_sex_yn	= "Y" ;
		}

	//	traceVal.append("ORDER_CATALOG Insetion");



//		traceVal.append("CatalogHeader="+CatalogHeader.toString()+"   //////");
//		traceVal.append("charactersticsRec="+charactersticsRec.toString()+"   /////");
//		traceVal.append("recordOrderCatalog="+recordOrderCatalog.toString()+"   ");
//		traceVal.append("reviews="+reviews.toString()+"   ");

		String chk_for_dupl_ahead_period	= (String)charactersticsRec.get("chk_for_dupl_ahead_period");
		String chk_for_dupl_behind_period	= (String)charactersticsRec.get("chk_for_dupl_behind_period");
		String appt_time					= (String)recordOrderCatalog.get("appt_time") ;
		String consent_form_id				= (String)charactersticsRec.get("consent_form_id") ;
		String refusal_form_id				= (String)charactersticsRec.get("refusal_form_id") ;
		String priority_appl				= (String)charactersticsRec.get("priority_appl") ;
		String proc_coding_scheme			= (String)charactersticsRec.get("proc_coding_scheme") ;
		String discr_msr_panel_id			= (String)charactersticsRec.get("discr_msr_panel_id") ;
		String consent_stage				= (String)charactersticsRec.get("consent_stage") ;
		String num_of_consent_req_bo		= (String)charactersticsRec.get("num_of_consent_req_bo") ;
		String num_of_consent_req_br		= (String)charactersticsRec.get("num_of_consent_req_br") ;
		String dup_reason_reqd_yn			= (String)charactersticsRec.get("dup_reason_reqd_yn");//IN024984
		String tpn_item_yn			= (String)CatalogHeader.get("tpn_item_yn");//IN068926
		if(chk_for_dupl_ahead_period.trim().equalsIgnoreCase(""))
			chk_for_dupl_ahead_period = "" ;

		if(chk_for_dupl_behind_period.trim().equalsIgnoreCase(""))
			chk_for_dupl_behind_period = "" ;


		java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date today = new java.util.Date();
		String dateString = dt.format(today);



		if(appt_time.trim().equals(""))
			appt_time = dateString + " " + "00:00" ;
		else
			appt_time = dateString + " " + appt_time ;

		try
		{
			if(consent_form_id.trim().equals(""))
				consent_form_id = null ;

			if(consent_stage.trim().equals(""))
			{
				consent_stage = null ;
			}
			else
			{
				if( num_of_consent_req_bo !=null && num_of_consent_req_bo.equals("") && consent_stage.equals("A"))
				{
					num_of_consent_req_bo = "1";
					num_of_consent_req_br = "0";
				}

				if( num_of_consent_req_br !=null && num_of_consent_req_br.equals("") && consent_stage.equals("R"))
				{
					num_of_consent_req_bo = "0";
					num_of_consent_req_br = "1";
				}
			}
			if( num_of_consent_req_bo !=null && !num_of_consent_req_bo.equals("") && Integer.parseInt(num_of_consent_req_bo) > 0)
					consent_stage = "A" ;

			if( num_of_consent_req_br !=null && !num_of_consent_req_br.equals("") && Integer.parseInt(num_of_consent_req_br) > 0)
			{
				if(Integer.parseInt(num_of_consent_req_bo) > 0 )
					consent_stage = "A" ;
				else
					consent_stage = "R" ;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(refusal_form_id.trim().equals(""))
			refusal_form_id = null ;

		if(priority_appl.trim().equals(""))
			priority_appl = null ;


		traceVal.append("discr_msr_panel_id="+discr_msr_panel_id);

		if(discr_msr_panel_id.trim().equals(""))
			discr_msr_panel_id = null ;
		if(proc_coding_scheme.trim().equals(""))
			proc_coding_scheme = null ;

	    String stat_turn_around_time = (turnAroundRec.get("stat_turn_around_time") != null) ? (String)turnAroundRec.get("stat_turn_around_time") : "";
	    String stat_turn_around_type = (turnAroundRec.get("stat_turn_around_type") != null) ? (String)turnAroundRec.get("stat_turn_around_type") : "";
	    String urgent_turn_around_time = (turnAroundRec.get("urgent_turn_around_time") != null) ? (String)turnAroundRec.get("urgent_turn_around_time") : "";
	    String urgent_turn_around_type = (turnAroundRec.get("urgent_turn_around_type") != null) ? (String)turnAroundRec.get("urgent_turn_around_type") : "";
	    String routine_turn_around_time = (turnAroundRec.get("routine_turn_around_time") != null) ? (String)turnAroundRec.get("routine_turn_around_time") : "";
	    String routine_turn_around_type = (turnAroundRec.get("routine_turn_around_type") != null) ? (String)turnAroundRec.get("routine_turn_around_type") : "";
		String l_instrn_content_type = (String)recordOrderCatalog.get("instrn_content_type");//IN64543

        pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("order_catalog_code"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("long_desc"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("short_desc"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("order_category"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("order_type_code"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("activity_type"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("image_link_id"));
		pstmt_ch.setString(indexCnt++	,CatalogHeader.get("indexed_yn")==null?"N":(String)CatalogHeader.get("indexed_yn"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("security_level"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("order_catalog_nature"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("consent_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,consent_form_id);
		pstmt_ch.setString(indexCnt++	,refusal_form_id);
		pstmt_ch.setString(indexCnt++	,priority_appl);
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("prompt_alert_yn"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("prompt_alert_msg"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("qty_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("qty_uom"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("split_dose_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("taper_dose_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("taper_up"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("appl_sliding_scale_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("freq_applicable_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("soft_stop_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("cont_order_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("refill_cont_order_yn"));
		pstmt_ch.setString(indexCnt++	,comment_format_id); //from sql
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("chk_for_dupl_yn"));
		pstmt_ch.setString(indexCnt++,(String)charactersticsRec.get("chk_for_dupl_status"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("chk_for_dupl_ahead_action"));
		pstmt_ch.setString(indexCnt++	,chk_for_dupl_ahead_period);
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("chk_for_dupl_ahead_unit"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("chk_for_dupl_behind_action"));
		pstmt_ch.setString(indexCnt++	,chk_for_dupl_behind_period);
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("chk_for_dupl_behind_unit"));
		pstmt_ch.setString(indexCnt++	,(String)reviews.get("ord_auth_level"));
		pstmt_ch.setString(indexCnt++	,(String)reviews.get("ord_cosign_level"));
		pstmt_ch.setString(indexCnt++	,(String)reviews.get("ord_spl_appr_level"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("appt_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,appt_time);
		pstmt_ch.setString(indexCnt++	,pat_instrn_age_sex_yn);//depends in instr Tab
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("dept_only_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("complete_on_order_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("bill_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("charge_type_applicable"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("result_applicable_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("auto_report_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("result_auth_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("chart_result_type"));
		pstmt_ch.setString(indexCnt++	,proc_coding_scheme);
		pstmt_ch.setString(indexCnt++	,discr_msr_panel_id);
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("contr_mod_id"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("contr_msr_panel_id"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("proc_link_applicable"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("proc_link_resulting_option"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("term_set_id"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("term_code"));
		//**pstmt_ch.setString(56	,(String)charactersticsRec.get("image_link_id"));//moved to header frame
		//pstmt_ch.setString(57	,(String)charactersticsRec.get("indexed_yn"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("eff_status"));
		pstmt_ch.setString(indexCnt++	,login_by_id);
		pstmt_ch.setString(indexCnt++	,login_at_ws_no);
		pstmt_ch.setString(indexCnt++	,login_facility_id);
		pstmt_ch.setString(indexCnt++	,login_by_id);
		pstmt_ch.setString(indexCnt++	,login_at_ws_no);
		pstmt_ch.setString(indexCnt++	,login_facility_id);
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("contineous_freq_order"));//Little differnce in database name and bean name
   		pstmt_ch.setString(indexCnt++	,field_format_id);//FROM SQL
   		//pstmt_ch.setString(59   ,(String)charactersticsRec.get("activity_type"));
   		pstmt_ch.setString(indexCnt++   ,(String)charactersticsRec.get("check_for_dupl_level"));
   		pstmt_ch.setString(indexCnt++   ,stat_turn_around_time);
   		pstmt_ch.setString(indexCnt++   ,stat_turn_around_type);
   		pstmt_ch.setString(indexCnt++   ,urgent_turn_around_time);
   		pstmt_ch.setString(indexCnt++   ,urgent_turn_around_type);
   		pstmt_ch.setString(indexCnt++  ,routine_turn_around_time);
   		pstmt_ch.setString(indexCnt++   ,routine_turn_around_type);
   		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("confidential_yn"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("stat_appt_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("urgent_appt_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("routine_appt_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,consent_stage);
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("routine_chk_for_dupl_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("urgent_chk_for_dupl_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("stat_chk_for_dupl_yn"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("explanatory_text"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("appt_prep_time"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("appt_prep_time_type"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("appt_action_for_prep"));
		pstmt_ch.setString(indexCnt++	,(String)charactersticsRec.get("consent_form_list"));
		pstmt_ch.setString(indexCnt++	,num_of_consent_req_bo);
		pstmt_ch.setString(indexCnt++	,num_of_consent_req_br);
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("clin_cmts_reqd_yn"));
		pstmt_ch.setString(indexCnt++,(String)recordOrderCatalog.get("splty_speci_reqd_yn"));
		pstmt_ch.setString(indexCnt++	,(String)recordOrderCatalog.get("pri_splty_code"));
		pstmt_ch.setString(indexCnt++	,(String)CatalogHeader.get("linked_vaccine_id"));
		pstmt_ch.setString(indexCnt++  ,(String)recordOrderCatalog.get("follow_visit_type_yn")); // added for IN031304
		pstmt_ch.setString(indexCnt++  ,dup_reason_reqd_yn);//IN024984
		pstmt_ch.setString(indexCnt++   ,(String)charactersticsRec.get("barcode_reqd_yn"));//IN063816
		pstmt_ch.setString(indexCnt++   ,(String)charactersticsRec.get("prn_regd_ord"));//IN065942
		pstmt_ch.setString(indexCnt++  ,(String)recordOrderCatalog.get("invoke_instrn_window_yn"));//IN065942
		pstmt_ch.setString(indexCnt++ ,l_instrn_content_type);//IN64543

		pstmt_ch.setString(indexCnt++   ,tpn_item_yn);//IN068926
		pstmt_ch.setString(indexCnt++   ,(String)charactersticsRec.get("fpp_yn")); //IN068314
		pstmt_ch.setString(indexCnt++   ,(String)charactersticsRec.get("fpp_category"));//IN068314
		pstmt_ch.setString(indexCnt++   ,(String)charactersticsRec.get("freq_order_split_indvi_yn"));//7540
		insert_ch = pstmt_ch.executeUpdate();
	//	traceVal.append("ORDER_CATALOG after Insetion");

		//
		
		//IN068370,IN068373, starts
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			String l_catalog_code = (String)CatalogHeader.get("order_catalog_code");
			pstmt_del_appl_facility.setString(1, l_catalog_code);
			pstmt_del_appl_facility.execute();
			
			if(mappedFacilities!=null && mappedFacilities.size()>0)
			{
				for(int i=0;i<mappedFacilities.size();i++)
				{
					pstmt_appl_facility.setString(1, l_catalog_code);
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


		String 	effective_status_primary		= (String)charactersticsRec.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)charactersticsRec.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)charactersticsRec.get("effective_status_ancillaryDept") ;


	//	traceVal.append("at start for syn");

		if(effective_status_primary.trim().equalsIgnoreCase("Y")){//This insertion is Mandatory
			pstmt_syn.setString(1 ,(String)CatalogHeader.get("order_catalog_code"));
			pstmt_syn.setString(2 ,"PR");
			pstmt_syn.setString(3 ,(String)charactersticsRec.get("catalog_synonym_primary"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_primary);//*************
			pstmt_syn.addBatch() ;

		}


		if(effective_status_directCare.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,(String)CatalogHeader.get("order_catalog_code"));
			pstmt_syn.setString(2 ,"DC");
			pstmt_syn.setString(3 ,(String)charactersticsRec.get("catalog_synonym_directCare"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_directCare);//*************
			pstmt_syn.addBatch() ;
		}



		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,(String)CatalogHeader.get("order_catalog_code"));
			pstmt_syn.setString(2 ,"AD");
			pstmt_syn.setString(3 ,(String)charactersticsRec.get("catalog_synonym_ancillaryDept"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_ancillaryDept);//*************
			pstmt_syn.addBatch();
		}

	//		traceVal.append("before execuution");

			insert_syn = pstmt_syn.executeBatch();

	//		traceVal.append("after insertion sysn="+insert_syn);

   /****************INSERT ORDER CATALOG TYPE ***********************/

			pstmt_type.setString(1 ,(String)CatalogHeader.get("order_type_code"));
			//pstmt_type.setString(2 ,(String)CatalogHeader.get("activity_type"));
			pstmt_type.setString(2 ,login_by_id);
			pstmt_type.setString(3 ,login_at_ws_no);
			pstmt_type.setString(4 ,login_facility_id);
			pstmt_type.setString(5 ,login_by_id);
			pstmt_type.setString(6 ,login_at_ws_no);
			pstmt_type.setString(7 ,login_facility_id);
			pstmt_type.setString(8 ,(String)CatalogHeader.get("order_catalog_code"));

			insert_type = pstmt_type.executeUpdate();


	//		traceVal.append("after insertion type="+insert_type);

	/**************INSERT INTO OR_ORDER BY PTCL*******************/

			int sizeReviews				=Reviews.size()  ;
			int sizeSettings			=Settings.size()  ;
			int iterateVal				=0;

			 traceVal.append("Reviews="+sizeReviews + "   //////");
			 traceVal.append("Settings="+sizeSettings + "   //////");


			if(sizeReviews == sizeSettings)
			iterateVal = sizeReviews ;
			else if(sizeReviews > sizeSettings)
			iterateVal = sizeReviews ;
			else if(sizeReviews < sizeSettings)
			iterateVal = sizeSettings ;


		//	traceVal.append("iterateVal="+iterateVal + "  ");
	//		traceVal.append("Reviews="+Reviews + "   //////");
	//		traceVal.append("Settings="+Settings + "   //////");



///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same
for(int i = 0; i < iterateVal ; i++){//0 for the default

			double qty_value				= 0.0 ;
			long   durn_value				= 0 ;
			long   max_durn_value			= 0;

			String qty_value_str			=  "";
			String durn_value_str			=  "";
			String max_durn_value_str		=  "";


			String patient_class			="";

			String setting_applicability_R	="x";
			String setting_applicability_S	="X";
			String ord_auth_reqd_yn			="N";
			String ord_cosign_reqd_yn		="N";
			String ord_spl_appr_reqd_yn		="N";
			//String setting_applicability	="X" ;
			String qty_uom					="" ;
			String age_group_code			="" ;
			String freq_code				="" ;
			String durn_type				="" ;
			String max_durn_type			="" ;
			String chk_for_max_durn_action	="" ;
			String ord_auth_level			="" ;
			String prompt_msg				="" ;
			boolean atleastOneAppl			=false;
			String ord_skip_auth			= "NA"; //IN048467
		if(i <= (sizeReviews-1) && i <= (sizeSettings-1)){//This condn  will be always true


				tempReview  = (HashMap)Reviews.get(i);
				tempSetting = (HashMap)Settings.get(i);


				setting_applicability_R		=tempReview.get("setting_applicability")==null?"x":(String)tempReview.get("setting_applicability") ;
				setting_applicability_S	    =tempSetting.get("setting_applicability")==null?"X":(String)tempSetting.get("setting_applicability");


				if(setting_applicability_R.trim().equalsIgnoreCase("A") ||
						i== 0 ){
					patient_class				=(String)tempReview.get("patient_class");
//					traceVal.append("patient_class="+patient_class);
					ord_auth_reqd_yn			=(String)tempReview.get("ord_auth_reqd_yn");
					ord_cosign_reqd_yn		    =(String)tempReview.get("ord_cosign_reqd_yn");
					ord_spl_appr_reqd_yn		=(String)tempReview.get("ord_spl_appr_reqd_yn");
					ord_skip_auth				=(String)tempReview.get("skip_auth"); // IN048467
					atleastOneAppl				= true;
					//IN048467 - Start
					if(ord_skip_auth == null || ord_skip_auth.equals("")) {
						ord_skip_auth = "NA";
					}
					//IN048467 - End
				}


				if(setting_applicability_S.trim().equalsIgnoreCase("A") ||
						i== 0 ){

//					traceVal.append("Lp-bse/"+i);

					qty_value_str					= (String)tempSetting.get("qty_value");
					durn_value_str					= (String)tempSetting.get("durn_value");
					max_durn_value_str				= (String)tempSetting.get("max_durn_value");


					if(!qty_value_str.trim().equals(""))
						qty_value		= Double.parseDouble(qty_value_str);


					if(!(durn_value_str.equals(""))){
						durn_value		= Long.parseLong(durn_value_str);
					}


					if(!max_durn_value_str.trim().equals(""))
						max_durn_value	= Long.parseLong(max_durn_value_str);



					freq_code			= (String)tempSetting.get("freq_code");
//					traceVal.append("ferq Code="+freq_code);


					if(freq_code.trim().equals(""))
						freq_code = null ;


                    age_group_code			= (String)tempSetting.get("age_group_code");
//					traceVal.append("ferq Code="+freq_code);


					if(age_group_code.trim().equals(""))
						age_group_code = null ;

//					traceVal.append("freq_code="+freq_code);



					
					qty_uom					    =((String)tempSetting.get("qty_uom")).trim();					
					if (qty_uom.equals("") && charactersticsRec != null)
					{						
						qty_uom = (String)charactersticsRec.get("qty_uom");
					}					
					patient_class				=(String)tempSetting.get("patient_class");
					durn_type					=(String)tempSetting.get("durn_type");
					max_durn_type				=(String)tempSetting.get("max_durn_type");
					chk_for_max_durn_action		=(String)tempSetting.get("chk_for_max_durn_action");
					ord_auth_level				=(String)tempSetting.get("ord_auth_level");
					prompt_msg					=(String)tempSetting.get("prompt_msg");
					atleastOneAppl				= true;
				 }


				tempReview.clear();
				tempSetting.clear();
		}else if(i <= (sizeReviews-1) && i >= sizeSettings){//This condn when he has  visited reviews but not settings

//				traceVal.append("Lp=/Re/"+i);

				tempReview  = (HashMap)Reviews.get(i);
				setting_applicability_R		=tempReview.get("setting_applicability")==null?"x":(String)tempReview.get("setting_applicability");

				if(setting_applicability_R.trim().equalsIgnoreCase("A")){
					patient_class				=(String)tempReview.get("patient_class");
					ord_auth_reqd_yn			=(String)tempReview.get("ord_auth_reqd_yn");
					ord_cosign_reqd_yn		    =(String)tempReview.get("ord_cosign_reqd_yn");
					ord_spl_appr_reqd_yn		=(String)tempReview.get("ord_spl_appr_reqd_yn");
					ord_skip_auth				=(String)tempReview.get("skip_auth"); // IN048467
					atleastOneAppl				= true;
					//IN048467 - Start
					if(ord_skip_auth == null || ord_skip_auth.equals("")) {
						ord_skip_auth = "NA";
					}
					//IN048467 - End
				}
				tempReview.clear();
	   }else{

		 if(i >= sizeReviews && i <= (sizeSettings-1)){//This condn when he has  visited settings  but not reviews tab


//				traceVal.append("Lp=/Se/"+i);
				tempSetting = (HashMap)Settings.get(i);

//				traceVal.append("Lp=/tempSetting/"+tempSetting);

				setting_applicability_S	    =tempSetting.get("setting_applicability")==null?"X":(String)tempSetting.get("setting_applicability");


				if(setting_applicability_S.trim().equalsIgnoreCase("A")){

//					traceVal.append("Lp=/insise se/"+i);

					qty_value_str					= (String)tempSetting.get("qty_value");
					durn_value_str					= (String)tempSetting.get("durn_value");
					max_durn_value_str				= (String)tempSetting.get("max_durn_value");


					if(!qty_value_str.trim().equals(""))
						qty_value		= Double.parseDouble(qty_value_str);

//					traceVal.append("se="+ i+durn_value);

					if(!durn_value_str.trim().equals(""))
						durn_value  = Long.parseLong(durn_value_str);

					if(!max_durn_value_str.trim().equals(""))
						max_durn_value = Long.parseLong(max_durn_value_str);


					freq_code					=(String)tempSetting.get("freq_code");

//					traceVal.append("freq_code="+ i+freq_code);

					if(freq_code.trim().equals(""))
						freq_code = null ;



                    age_group_code					=(String)tempSetting.get("age_group_code");

//					traceVal.append("age_group_code="+ i+age_group_code);

					if(age_group_code.trim().equals(""))
						age_group_code = null ;

					qty_uom					    =(String)tempSetting.get("qty_uom");					
					if (qty_uom.trim().equals("") && charactersticsRec != null)
					{									
						qty_uom = (String)charactersticsRec.get("qty_uom");
					}
					
					patient_class				=(String)tempSetting.get("patient_class");
					durn_type					=(String)tempSetting.get("durn_type");
					max_durn_type				=(String)tempSetting.get("max_durn_type");
					chk_for_max_durn_action		=(String)tempSetting.get("chk_for_max_durn_action");
					ord_auth_level				=(String)tempSetting.get("ord_auth_level");
					prompt_msg					=(String)tempSetting.get("prompt_msg");
					atleastOneAppl				= true;
				 }
			tempSetting.clear();
			}//End of If
	   }//End of Last Else



			if(atleastOneAppl){
			//	traceVal.append("setting_applicability_R:="+ i + setting_applicability_R);
			//	traceVal.append("patient_class:="+ i + patient_class);
				pstmt_ptcl.setString(1	 ,(String)CatalogHeader.get("order_catalog_code"));
				pstmt_ptcl.setString(2	 ,patient_class);
				pstmt_ptcl.setString(3	 ,setting_applicability_R);
				pstmt_ptcl.setString(4	 ,ord_auth_reqd_yn);
				pstmt_ptcl.setString(5	 ,ord_cosign_reqd_yn);
				pstmt_ptcl.setString(6	 ,ord_spl_appr_reqd_yn);
				pstmt_ptcl.setString(7	 ,setting_applicability_S);
				pstmt_ptcl.setString(8	 ,age_group_code);
				pstmt_ptcl.setDouble(9	 ,qty_value);
				pstmt_ptcl.setString(10	 ,qty_uom);
				pstmt_ptcl.setString(11	 ,freq_code);
				pstmt_ptcl.setLong(	 12	 ,durn_value);
				pstmt_ptcl.setString(13	 ,durn_type);
				pstmt_ptcl.setString(14	 ,max_durn_type);
				pstmt_ptcl.setString(15	 ,chk_for_max_durn_action);
				pstmt_ptcl.setString(16	 ,ord_auth_level);
				pstmt_ptcl.setString(17  ,prompt_msg);
				pstmt_ptcl.setString(18	 ,login_by_id);
				pstmt_ptcl.setString(19	 ,login_at_ws_no);
				pstmt_ptcl.setString(20  ,login_facility_id);
				pstmt_ptcl.setString(21  ,login_by_id);
				pstmt_ptcl.setString(22  ,login_at_ws_no);
				pstmt_ptcl.setString(23  ,login_facility_id);
				pstmt_ptcl.setLong(	 24  ,max_durn_value);
				pstmt_ptcl.setString(25  ,ord_skip_auth); // IN048467
				pstmt_ptcl.addBatch();
			}

	}//end of For Loop for PTCL INSERTION


				insert_ptcl = pstmt_ptcl.executeBatch();

//				traceVal.append("afterInsertion="+insert_ptcl.length);


/*****************INSERTION FOR OR ORDER CATALOG PREPS INSTRN************/

	/*Instr*/
			recordOrderCatalog  =(HashMap)Instructions.get(0);
			recordPreps		    =(HashMap)Instructions.get(1);
			recordStdIntruction =(HashMap)Instructions.get(2);
			recordByAge			=(HashMap)Instructions.get(3);

//		traceVal.append("recordOrderCatalog="+recordOrderCatalog);
//		traceVal.append("recordPreps="+recordPreps);
//		traceVal.append("recordStdIntruction="+recordStdIntruction);
//		traceVal.append("recordByAge="+recordByAge);


	//Insertion of recordOrderCatalog is Mandatory
		pstmt_Instr.setString(1 ,(String)recordPreps.get("pat_preps_or_instrns_id_pr"));
		pstmt_Instr.setString(2			,"0");
		pstmt_Instr.setString(3			,"0");
		pstmt_Instr.setString(4			,"0");
		pstmt_Instr.setString(5			,"0");
		pstmt_Instr.setString(6			,"0");
		pstmt_Instr.setString(7			,"0");
		pstmt_Instr.setLong(8			,0);
		pstmt_Instr.setLong(9			,0);
		pstmt_Instr.setString(10		,"N");
		pstmt_Instr.setString(11		,(String)recordPreps.get("pat_preps_or_instrns_txt_pr"));
		pstmt_Instr.setString(12		,login_by_id);
		pstmt_Instr.setString(13		,login_at_ws_no);
		pstmt_Instr.setString(14		,login_facility_id);
		pstmt_Instr.setString(15		,login_by_id);
		pstmt_Instr.setString(16		,login_at_ws_no);
		pstmt_Instr.setString(17		,login_facility_id);
		pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

		pstmt_Instr.addBatch();


		//Insertion of recordOrderCatalog is Mandatory----DepartMent Instrns
		pstmt_Instr.setString(1 ,(String)recordPreps.get("pat_preps_or_instrns_id_dr"));
		pstmt_Instr.setString(2			,"0");
		pstmt_Instr.setString(3			,"0");
		pstmt_Instr.setString(4			,"0");
		pstmt_Instr.setString(5			,"0");
		pstmt_Instr.setString(6			,"0");
		pstmt_Instr.setString(7			,"0");
		pstmt_Instr.setLong(8			,0);
		pstmt_Instr.setLong(9			,0);
		pstmt_Instr.setString(10		,"N");
		pstmt_Instr.setString(11		,(String)recordPreps.get("pat_preps_or_instrns_txt_dr"));
		pstmt_Instr.setString(12		,login_by_id);
		pstmt_Instr.setString(13		,login_at_ws_no);
		pstmt_Instr.setString(14		,login_facility_id);
		pstmt_Instr.setString(15		,login_by_id);
		pstmt_Instr.setString(16		,login_at_ws_no);
		pstmt_Instr.setString(17		,login_facility_id);
		pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

		pstmt_Instr.addBatch();



		//IN64543, starts
		//String pat_preps_or_instrns_id	=(String) recordOrderCatalog.get("pat_preps_or_instrns_id");
		String pat_preps_or_instrns_id = "";
		if(((String)recordOrderCatalog.get("instrn_content_type")).equals("T"))
			pat_preps_or_instrns_id = (String)recordOrderCatalog.get("pat_preps_or_instrns_id");
		else if(((String)recordOrderCatalog.get("instrn_content_type")).equals("E"))
			pat_preps_or_instrns_id = (String)recordOrderCatalog.get("pat_instrns_free_fmt_id");
		//IN64543, ends


 if(pat_preps_or_instrns_id.trim().equals("IS")){//By standards

		Object  pat_txt_is_obj = recordStdIntruction.get("pat_preps_or_instrns_txt_is") ;
		String  pat_txt_is     ="";

		if(pat_txt_is_obj != null)
			pat_txt_is = (String)pat_txt_is_obj;

		pstmt_Instr.setString(1			,"IS");
		pstmt_Instr.setString(2			,"0");
		pstmt_Instr.setString(3			,"0");
		pstmt_Instr.setString(4			,"0");
		pstmt_Instr.setString(5			,"0");
		pstmt_Instr.setString(6			,"0");
		pstmt_Instr.setString(7			,"0");
		pstmt_Instr.setLong(8			,0);
		pstmt_Instr.setLong(9			,0);
		pstmt_Instr.setString(10		,"N");
		pstmt_Instr.setString(11		,pat_txt_is);
		pstmt_Instr.setString(12		,login_by_id);
		pstmt_Instr.setString(13		,login_at_ws_no);
		pstmt_Instr.setString(14		,login_facility_id);
		pstmt_Instr.setString(15		,login_by_id);
		pstmt_Instr.setString(16		,login_at_ws_no);
		pstmt_Instr.setString(17		,login_facility_id);
		pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

		pstmt_Instr.addBatch();

	 }else if(pat_preps_or_instrns_id.trim().equals("IM")){

		//ML-MMOH-SCF-1108 start
		 Object recordObj = null;
			if("E".equals(l_instrn_content_type))
			{
				recordObj = InstructionClobTemp.get("pat_preps_or_instrns_free_fmt_im");			
			}
			else if("T".equals(l_instrn_content_type))
			{
				recordObj= recordByAge.get("records");			
			}
		//ML-MMOH-SCF-1108 end	
		clobDataAge = new ArrayList<Object>();
		
		if (recordObj!=null)//IN64543
		{
		//for(Object obj: (ArrayList<Object>)recordByAge.get("records"))//ML-MMOH-SCF-1108
		/*for(Object obj: (ArrayList)recordByAge.get("records"))
		{	
			clobDataAge.add(obj) ;
		}*/
			for(Object obj:(ArrayList)recordObj){	
				clobDataAge.add(obj) ;
			}
		System.out.println("clobDataAge1=>"+clobDataAge);
		ArrayList records = null ;
		HashMap	currRec=new HashMap();

		if(recordObj == null )
			records =new ArrayList();
		else
			records =(ArrayList)recordObj;

		int recsize = 	records.size();
		if(recsize != 0){
		 for (int j = 0; j < recsize ; j++ ){

			currRec =(HashMap)records.get(j);

			String min_age_in_days				=(String)currRec.get("min_age_in_days");
			String min_age_in_mths				=(String)currRec.get("min_age_in_mths");
			String min_age_in_yrs				=(String)currRec.get("min_age_in_yrs");
			String max_age_in_days				=(String)currRec.get("max_age_in_days");
			String max_age_in_mths				=(String)currRec.get("max_age_in_mths");
			String max_age_in_yrs				=(String)currRec.get("max_age_in_yrs");
			String sex_spec_ind					=(String)currRec.get("sex_spec_ind");
			String pat_preps_or_instrns_txt		=(String)currRec.get("pat_preps_or_instrns_txt");


			long currMinTotal  = getDaysEJB(Long.parseLong(min_age_in_yrs),Integer.parseInt(min_age_in_mths),Long.parseLong(min_age_in_days));
			long currMaxTotal  = getDaysEJB(Long.parseLong(max_age_in_yrs),Integer.parseInt(max_age_in_mths),Long.parseLong(max_age_in_days));


			/*INSERT INTO or_order_catalog_preps_instrn(PAT_PREPS_OR_INSTRNS_IND,MIN_AGE_IN_DAYS,MIN_AGE_IN_MTHS,MIN_AGE_IN_YRS,MAX_AGE_IN_DAYS,MAX_AGE_IN_MTHS,MAX_AGE_IN_YRS,CALC_MIN_AGE_IN_DAYS,CALC_MAX_AGE_IN_DAYS,SEX_SPEC_IND,PAT_PREPS_OR_INSTRNS_TXT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_CATALOG_CODE ) values (? ,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)*/

			pstmt_Instr.setString(1	,"IM");
			pstmt_Instr.setString(2			,min_age_in_days);
			pstmt_Instr.setString(3			,min_age_in_mths);
			pstmt_Instr.setString(4			,min_age_in_yrs);
			pstmt_Instr.setString(5			,max_age_in_days);
			pstmt_Instr.setString(6			,max_age_in_mths);
			pstmt_Instr.setString(7			,max_age_in_yrs);
			pstmt_Instr.setLong(8			,currMinTotal);
			pstmt_Instr.setLong(9			,currMaxTotal);
			pstmt_Instr.setString(10		,sex_spec_ind);
			pstmt_Instr.setString(11		,pat_preps_or_instrns_txt);
			pstmt_Instr.setString(12		,login_by_id);
			pstmt_Instr.setString(13		,login_at_ws_no);
			pstmt_Instr.setString(14		,login_facility_id);
			pstmt_Instr.setString(15		,login_by_id);
			pstmt_Instr.setString(16		,login_at_ws_no);
			pstmt_Instr.setString(17		,login_facility_id);
			pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

			pstmt_Instr.addBatch();
			//currRec.clear();//commted temp
		  }
		}//End of loop if size not equals zero
		//records.clear();
	  }//End of esle loop for pat_preps_or_instrns_ind : "IM"
	 }

	  insert_Instr = pstmt_Instr.executeBatch();

	  //IN64543, starts
	  boolean isClobUpdated = true;
	  if("E".equals(l_instrn_content_type))
	  {	  
		  ArrayList<String> queries = new ArrayList<String>();
		  queries.add(SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS);
		  queries.add(SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM);
		  ArrayList data = new ArrayList();
		  data.add(CatalogHeader.get("order_catalog_code"));
		  data.add(recordPreps);
		  data.add(pat_preps_or_instrns_id.trim());
		  //data.add(clobDataAge);//ML-MMOH-SCF-1108
		  ArrayList clobDataAgeList =(ArrayList) InstructionClobTemp.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108
		  data.add(clobDataAgeList);//ML-MMOH-SCF-1108
		  data.add(recordStdIntruction);//IN064543 K
		  data.add(InstructionClobTemp);//ML-MMOH-SCF-1108
		  
		  isClobUpdated = updateInstrn(connection, queries,data);
	  }
	//IN64543, ends
	  int sizeFrequencies				=Frequencies.size()  ;

        for(int i = 0; i < sizeFrequencies ; i++){
            tempSetting = (HashMap)Frequencies.get(i);

            pstmt_Freq.setString(1,((String)tempSetting.get("frequency_code")));
            pstmt_Freq.setString(2,((String)CatalogHeader.get("order_catalog_code")));
            pstmt_Freq.setString(3,login_by_id);
            pstmt_Freq.setString(4,login_at_ws_no);
            pstmt_Freq.setString(5,login_facility_id);
            pstmt_Freq.setString(6,login_by_id);
            pstmt_Freq.setString(7,login_at_ws_no);
            pstmt_Freq.setString(8,login_facility_id);

            if (((String)tempSetting.get("applicable_yn")).equals("Y")) {
            	traceVal.append("applicable_yn="+((String)tempSetting.get("applicable_yn")));
                pstmt_Freq.addBatch();
            }
			tempSetting.clear();
        }

		insert_Freq = pstmt_Freq.executeBatch();


		int prepSize = prepRec.size();

		if (prepSize > 0) {
		    prepSize = Integer.parseInt((String)prepRec.get("tot_recs"));
		}

		  HashMap record=new HashMap();
		for (int i = 0; i < prepSize; i++) {
		  if (prepRec.containsKey("patient_class"+i)) {
		      for(int j = 0;j < PrepDetail.size(); j++) {
				  record = (HashMap)PrepDetail.get(j);

                  pstmt_Prep.setString(1,((String)CatalogHeader.get("order_catalog_code")));
    		      pstmt_Prep.setString(2,((String)record.get("code")));
    		      pstmt_Prep.setString(3,((String)prepRec.get("patient_class"+i)));
    		      pstmt_Prep.setString(4,((String)record.get("sec_order_stage_stat")));
    		      pstmt_Prep.setString(5,((String)record.get("sec_order_stat_durn")));
    		      pstmt_Prep.setString(6,((String)record.get("sec_order_stat_durn_type")));
    		      pstmt_Prep.setString(7,((String)record.get("sec_order_stage_urg")));
    		      pstmt_Prep.setString(8,((String)record.get("sec_order_urg_durn")));
    		      pstmt_Prep.setString(9,((String)record.get("sec_order_urg_durn_type")));
    		      pstmt_Prep.setString(10,((String)record.get("sec_order_stage_rtn")));
    		      pstmt_Prep.setString(11,((String)record.get("sec_order_rtn_durn")));
    		      pstmt_Prep.setString(12,((String)record.get("sec_order_rtn_durn_type")));
    		      pstmt_Prep.setString(13,login_by_id);
    		      pstmt_Prep.setString(14,login_at_ws_no);
    		      pstmt_Prep.setString(15,login_facility_id);
    		      pstmt_Prep.setString(16,login_by_id);
    		      pstmt_Prep.setString(17,login_at_ws_no);
    		      pstmt_Prep.setString(18,login_facility_id);
				  pstmt_Prep.setString(19,((String)record.get("pri_sec_tasks_type")));
    		      traceVal.append("Prep:"+j);
    		      pstmt_Prep.addBatch();
				  //record.clear();
		      }
		  }
		}

		insert_Prep = pstmt_Prep.executeBatch();


//		traceVal.append("insert_Instr="+insert_Instr.length);

		boolean insert_Int	=  false ;
//		boolean insert_Fre	=  false ;
//		boolean insert_Pre	=  false ;
		boolean insert_ptl	=  false ;
		boolean insert_sy	=  false ;
		boolean bool_insert_fac_mapping = true;//IN068370,IN068373

		 if((insert_Instr.length > 0)){ //check updation in INSTRN
					insert_Int= true ;
		 }else if((insert_Instr.length == (-3))){
					insert_Int= false ;
		 }

	/*	 if((insert_Prep.length > 0)){ //check updation in INSTRN
					insert_Pre= true ;
		 }else if((insert_Prep.length == (-3))){
					insert_Pre= false ;
		 }

         if((insert_Freq.length > 0)){ //check updation in INSTRN
					insert_Fre= true ;
		 }else if((insert_Freq.length == (-3))){
					insert_Fre= false ;
		 }
	*/

		 if((insert_ptcl.length > 0)){ //check updation in PTCL
					insert_ptl= true ;
		 }else if((insert_ptcl.length == (-3))){
					insert_ptl= false ;
		 }

		 if((insert_syn.length > 0)){ //check updation in SYN
					insert_sy= true ;
		 }else if((insert_syn.length == (-3))){
					insert_sy= false ;
		 }
		 
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
//		traceVal.append("/insert_ch="+insert_ch);
//		traceVal.append("/insert_type="+insert_type);
//		traceVal.append("/insert_sy="+insert_syn.length+"/insert_Int="+insert_Instr.length+"/insert_ptl="+insert_ptcl.length);
		//if (insert_ch > 0 && insert_type > 0  && insert_sy  && insert_Int && insert_ptl)
		//if (insert_ch > 0 && insert_type > 0  && insert_sy  && insert_Int && insert_ptl && isClobUpdated)//IN068370,IN068373
		if (insert_ch > 0 && insert_type > 0  && insert_sy  && insert_Int && insert_ptl && isClobUpdated && bool_insert_fac_mapping)//IN068370,IN068373
		{  // && insert_Fre
			/*connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append("RECORD_INSERTED") ;Modified by Uma on 8/20/2009 for PMG20089-CRF641*/
			boolean status_flg = false;
			status_flg = executeProcedure(connection,((String)CatalogHeader.get("order_catalog_code")));
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
		}
		else
		{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
		}
		/*CatalogHeader.clear();
		Characterstics.clear();
		TurnAround.clear();
		Reviews.clear();
		Frequencies.clear();
		Settings.clear();
		Instructions.clear();
		Prep.clear();
		PrepDetail.clear();
		charactersticsRec.clear();
		turnAroundRec.clear();
		reviews.clear();
		prepRec.clear();
		recordOrderCatalog.clear();
		recordPreps.clear();
		recordStdIntruction.clear();
		recordByAge.clear();*/
	}catch( Exception e ){
					traceVal.append("In Exception==");
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

			try {
						connection.rollback();
						closeConnection( connection,pt);
//						closeConnection(connection);
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}
				if (e instanceof java.lang.NullPointerException || (((String)e.getMessage()).indexOf("Index: 0, Size: 0") != -1)){
                   messages.delete(0, messages.length());
                    messages.append("Cannot Update. Try Again Later...");
                }
                else
                    messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
    		  } finally{
	            	try {
						closeResultSet( rs ) ;
						closeStatement( pstmt_ch ) ;
						closeStatement( pstmt_type ) ;
						closeStatement( pstmt_syn ) ;
						closeStatement( pstmt_ptcl ) ;
						closeStatement( pstmt_Instr ) ;
						closeStatement( pstmt_format ) ;
						closeStatement( pstmt_Prep ) ;
						closeStatement( pstmt_Freq  ) ;
						closeStatement(pstmt_appl_facility);//IN068370,IN068373
						closeStatement(pstmt_del_appl_facility);//IN068370,IN068373
						closeConnection( connection,pt);
				//		closeConnection(connection);
					} catch ( Exception fe ) {
					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;


}//End of Insert Method

/************************MODIFY*****************************/
/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) 
{
	int update_syn_del_status =  0;
	StringBuffer messages =  null ;
	StringBuffer traceVal	=  null ;
	HashMap map				=  null;
	Connection connection	=  null ;
	Properties  pt			=  null;
	PreparedStatement pstmt_ch	    	= null ;
    PreparedStatement pstmt_type	    = null ;
    PreparedStatement pstmt_syn		    = null ;
    PreparedStatement pstmt_ptcl	    = null ;
    PreparedStatement pstmt_Instr	    = null ;
    PreparedStatement pstmt_Freq	    = null ;
    PreparedStatement pstmt_Freq_del    = null ;
    PreparedStatement pstmt_eff		    = null ;
    PreparedStatement pstmt_format	    = null;
	ResultSet	rs					    = null;
	ResultSet	rs_eff				    = null;
	ResultSet	sel_syn_rstset				    = null;
	PreparedStatement pstmt_Prep	    = null ;
	PreparedStatement pstmt_Prep_del	= null ;
	PreparedStatement select_pstmt_syn	= null ;
	PreparedStatement update_pstmt_syn	= null ;
	/****************DELETE RECORD IN THREE TABLES*****************/
	PreparedStatement del_pstmt_syn		= null ;
	PreparedStatement del_pstmt_ptcl		= null ;
	PreparedStatement del_pstmt_Instr		= null ;
	ArrayList<Object> clobDataAge = null;//IN064543 K
	PreparedStatement pstmt_appl_facility = null;//IN068370,IN068373
	PreparedStatement pstmt_del_appl_facility = null;//IN068370,IN068373
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
//		traceVal.append("tabData_p="+tabData_p.toString());
		 pt      		=(Properties)tabDataParam.get("properties");
/**********************************/
		HashMap	  CatalogHeader=new HashMap();
		ArrayList Characterstics=new ArrayList();
		ArrayList Reviews=new ArrayList();
		ArrayList Frequencies=new ArrayList();
		ArrayList Settings=new ArrayList();
		ArrayList Instructions=new ArrayList();
		ArrayList TurnAround=new ArrayList();
		ArrayList Prep=new ArrayList();
		ArrayList PrepDetail =new ArrayList();
		ArrayList DeletePrepDetail =new ArrayList();
		HashMap tempReview  = new HashMap();
		HashMap tempSetting =new HashMap();
		String[] l_appl_fac_id = null;//IN068370,IN068373
		ArrayList mappedFacilities = new ArrayList();//IN068370,IN068373
/**********************************/
		if (((HashMap)tabData_p.get("CatalogHeader"))!=null)
			CatalogHeader		=(HashMap)tabData_p.get("CatalogHeader");

		if (((ArrayList)tabData_p.get("Characterstics"))!=null)
			Characterstics	=(ArrayList)tabData_p.get("Characterstics");

		if (((ArrayList)tabData_p.get("Reviews"))!=null)
			 Reviews			=(ArrayList)tabData_p.get("Reviews");

		if (((ArrayList)tabData_p.get("Frequency"))!=null)
			 Frequencies		=(ArrayList)tabData_p.get("Frequency");

		if (((ArrayList)tabData_p.get("Settings"))!=null)
			Settings			=(ArrayList)tabData_p.get("Settings");

		if (((ArrayList)tabData_p.get("Instructions"))!=null)
			Instructions		=(ArrayList)tabData_p.get("Instructions");

		if (((ArrayList)tabData_p.get("TurnAround"))!=null)
			TurnAround        = (ArrayList)tabData_p.get("TurnAround");
		///Clear

		HashMap charactersticsRec	=(HashMap)Characterstics.get(0) ;
		HashMap turnAroundRec       = (HashMap)TurnAround.get(0);		//
		HashMap reviews				=(HashMap)Reviews.get(0) ;
	//	HashMap settings			=(HashMap)Settings.get(0) ;

		if (((ArrayList)tabData_p.get("Prep"))!=null)
        Prep       =(ArrayList)tabData_p.get("Prep");

		if (((ArrayList)tabData_p.get("PrepDetail"))!=null)
		PrepDetail       =(ArrayList)tabData_p.get("PrepDetail");

		if (((ArrayList)tabData_p.get("DeletePrepDetail"))!=null)
		DeletePrepDetail       =(ArrayList)tabData_p.get("DeletePrepDetail");
		
		//IN068370,IN068373, starts
		if(CatalogHeader.containsKey("appl_fac_id"))
		{
			l_appl_fac_id = (String[])CatalogHeader.get("appl_fac_id");
		}
		
		mappedFacilities=(ArrayList)tabData_p.get("MappedFacilities");
		globalFacilityYn = (String)tabData_p.get("GlobalFacilityYn");
		siteSpecGlobalFac = (Boolean)tabData_p.get("SiteSpecGlobalFac");
		//IN068370,IN068373, ends

		HashMap prepRec             =null;
		if(Prep != null)
			prepRec             = (HashMap)Prep.get(0);

	//	traceVal.append("Instructions="+Instructions.toString());


		/*Instr*/
		HashMap	recordOrderCatalog  =(HashMap)Instructions.get(0);
		HashMap	recordPreps		    =(HashMap)Instructions.get(1);
		HashMap	recordStdIntruction =(HashMap)Instructions.get(2);
		HashMap	recordByAge			=(HashMap)Instructions.get(3);		


		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;

		traceVal.append("login_at_ws_no="+login_at_ws_no);

		 connection = getConnection(pt) ;
	// 	 connection = getConnection() ;

		 String SQL_OR_CATALOG_BY_EFF_STATUS_SELECT		= (String)sqlMap.get("SQL_OR_CATALOG_BY_EFF_STATUS_SELECT");
		 String SQL_OR_CATALOG_BY_EFF_STATUS_UPDATE		= (String)sqlMap.get("SQL_OR_CATALOG_BY_EFF_STATUS_UPDATE");
		 String SQL_OR_CATALOG_UPDATE					= (String)sqlMap.get("SQL_OR_CATALOG_UPDATE");
	//	 String SQL_OR_CATALOG_BY_TYPE_UPDATE			= (String)sqlMap.get("SQL_OR_CATALOG_BY_TYPE_UPDATE");
		 String SQL_OR_CATALOG_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_SYNONYM");
		 String SQL_OR_CATALOG_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_BY_PTCL");
		 String SQL_OR_CATALOG_INSERT_PREPS_INSTRN		= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_PREPS_INSTRN");
		 //String SQL_OR_CATALOG_BY_SYNONYM_DELETE		= (String)sqlMap.get("SQL_OR_CATALOG_BY_SYNONYM_DELETE");
		 String SQL_OR_CATALOG_BY_INSTRN_DELETE			= (String)sqlMap.get("SQL_OR_CATALOG_BY_INSTRN_DELETE");
		 String SQL_OR_CATALOG_BY_PTCL_DELETE			= (String)sqlMap.get("SQL_OR_CATALOG_BY_PTCL_DELETE");
		//To get value for field format_id for insertion in order Catalog
		 String SQL_OR_CATALOG_FORMAT_ID1				= (String)sqlMap.get("SQL_OR_CATALOG_FORMAT_ID1");
		 String SQL_OR_CATALOG_FORMAT_ID2				= (String)sqlMap.get("SQL_OR_CATALOG_FORMAT_ID2");
		 String SQL_OR_CATALOG_FREQUENCY_INSERT			= (String)sqlMap.get("SQL_OR_CATALOG_FREQUENCY_INSERT");
		 String SQL_OR_CATALOG_FREQUENCY_DELETE			= (String)sqlMap.get("SQL_OR_CATALOG_FREQUENCY_DELETE");
		 String SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT	= (String)sqlMap.get("SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT");
		 String SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE	= (String)sqlMap.get("SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE");
		 String SQL_OR_ORDER_CATALOG_SYN_UPDATE     	= "UPDATE OR_ORDER_CATALOG_SYNONYM SET CATALOG_SYNONYM=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,EFF_STATUS =? WHERE ORDER_CATALOG_CODE=? AND CATALOG_SYNONYM_TYPE=? ";
		 String SQL_OR_ORDER_CATALOG_SYN_DELETE			= "DELETE FROM OR_ORDER_CATALOG_SYNONYM WHERE ORDER_CATALOG_CODE=? AND CATALOG_SYNONYM_TYPE=?";
		 String SQL_OR_ORDER_CATALOG_SYN_SELECT			= "SELECT CATALOG_SYNONYM,CATALOG_SYNONYM_TYPE FROM OR_ORDER_CATALOG_SYNONYM WHERE ORDER_CATALOG_CODE=?";
		 String SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS		= (String)sqlMap.get("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS");//IN64543
		 String SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM = (String)sqlMap.get("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM");//IN64543
		 
		//IN068370,IN068373, starts
		String SQL_OR_CATALOG_BY_FACILITY_INSERT = "";
		String SQL_OR_CATALOG_BY_FACILITY_DELETE = "";
		
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			SQL_OR_CATALOG_BY_FACILITY_INSERT = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_INSERT");
			SQL_OR_CATALOG_BY_FACILITY_DELETE = (String)sqlMap.get("SQL_OR_CATALOG_BY_FACILITY_DELETE");
		}
		//IN068370,IN068373, ends
 		 String	order_category							=(String)CatalogHeader.get("order_category") ;
		 String order_type_code							=(String)CatalogHeader.get("order_type_code") ;
//		 String activity_type							=(String)CatalogHeader.get("activity_type") ;
		 String order_catalog_code						=(String)CatalogHeader.get("order_catalog_code") ;
		 String tpn_item_yn						=(String)CatalogHeader.get("tpn_item_yn") ;//IN068926

		/*****EFFECTIVE STATUS CHK AND UPDATION*****************/
		 String eff_status					= "";

		 pstmt_eff			= connection.prepareStatement(SQL_OR_CATALOG_BY_EFF_STATUS_SELECT);
		 select_pstmt_syn	= connection.prepareStatement(SQL_OR_ORDER_CATALOG_SYN_SELECT);
		 del_pstmt_syn		= connection.prepareStatement(SQL_OR_ORDER_CATALOG_SYN_DELETE);
		 update_pstmt_syn	= connection.prepareStatement(SQL_OR_ORDER_CATALOG_SYN_UPDATE);
		//IN068370,IN068373, starts
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
		{
			pstmt_appl_facility = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_INSERT);
			pstmt_del_appl_facility = connection.prepareStatement(SQL_OR_CATALOG_BY_FACILITY_DELETE);
		}
		//IN068370,IN068373, ends
		 pstmt_eff.setString(1,order_catalog_code.trim());
		 rs_eff	= pstmt_eff.executeQuery();

		 if(rs_eff.next())
			eff_status =   rs_eff.getString("eff_status");

		 closeResultSet( rs_eff ) ;
		 closeStatement( pstmt_eff ) ;

		 if(eff_status.trim().equalsIgnoreCase("D"))
		 {//Update only the Eff Status and return

			pstmt_eff = connection.prepareStatement(SQL_OR_CATALOG_BY_EFF_STATUS_UPDATE);

			pstmt_eff.setString(1 ,(String)CatalogHeader.get("eff_status"));
			pstmt_eff.setString(2 ,login_by_id);
			pstmt_eff.setString(3 ,login_at_ws_no);
			pstmt_eff.setString(4 ,login_facility_id);
			pstmt_eff.setString(5 ,order_catalog_code.trim());

			int update_eff_status = pstmt_eff.executeUpdate();

			if(update_eff_status > 0)
			{
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;

				map.put( "message", messages.toString() ) ;
				map.put( "traceVal", traceVal.toString() ) ;
				return map ;
			}

			closeResultSet( rs_eff ) ;
			closeStatement( pstmt_eff ) ;

	    }
		traceVal.append("Update or chk eff status");

		/********************GET FORMAT ID***************************/
		String field_format_id				 ="";

		boolean		fieldFlag				 =false;

		pstmt_format = connection.prepareStatement(SQL_OR_CATALOG_FORMAT_ID1);

		pstmt_format.setString(1,order_category);
		pstmt_format.setString(2,order_type_code);
		//pstmt_format.setString(3,activity_type);

		rs	= pstmt_format.executeQuery();

		if(rs.next())
		{
			field_format_id = rs.getString("format_id");
			fieldFlag		= true;
		}

		closeResultSet( rs ) ;
		closeStatement( pstmt_format ) ;

		if(!fieldFlag)
		{
			pstmt_format		= null ;
			rs					= null ;
			pstmt_format =connection.prepareStatement(SQL_OR_CATALOG_FORMAT_ID2);
			pstmt_format.setString(1,order_category);
			rs	= pstmt_format.executeQuery();

			if(rs.next())
			{
				field_format_id = rs.getString("format_id");
				fieldFlag		= false;
			}
		}
		closeResultSet( rs ) ;
		closeStatement( pstmt_format ) ;

		if(!fieldFlag)
		{
			field_format_id = null ;
			//map.put( "message", "Cannot get Feild formai Id Transaction ....did not proceed" ) ;
			//map.put( "traceVal", traceVal.toString() ) ;
			//return map ;
		}

		traceVal.append("field_format_id="+field_format_id);		

		 //int update_syn_del_status =  0;
		 int update_ptcl_del_status =  0;
		 int update_instrns_del_status =  0;
		 /*del_pstmt_syn = connection.prepareStatement(SQL_OR_CATALOG_BY_SYNONYM_DELETE);
		 del_pstmt_syn.setString(1,order_catalog_code.trim());
		 update_syn_del_status = del_pstmt_syn.executeUpdate();
		 del_pstmt_syn.close();*/

  		 traceVal.append("del=syn");


		 del_pstmt_ptcl = connection.prepareStatement(SQL_OR_CATALOG_BY_PTCL_DELETE);
		 del_pstmt_ptcl.setString(1,order_catalog_code.trim());

		 update_ptcl_del_status = del_pstmt_ptcl.executeUpdate();
		 closeStatement( del_pstmt_ptcl ) ;


 		 traceVal.append("del=ptcl");

		 del_pstmt_Instr = connection.prepareStatement(SQL_OR_CATALOG_BY_INSTRN_DELETE);
		 del_pstmt_Instr.setString(1,order_catalog_code.trim());

		 update_instrns_del_status = del_pstmt_Instr.executeUpdate();

		 closeStatement( del_pstmt_Instr ) ;

 		 traceVal.append("del=inst");

		 if(update_syn_del_status < 0 || update_ptcl_del_status < 0  || update_instrns_del_status < 0  )
		 {
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			messages.append("Failure") ;
			map.put( "message", "Some prob in delete" ) ;
			map.put( "traceVal", "Some prob in delete" ) ;
			return map ;
		}

		traceVal.append("delete done");

		/*************************************************************/

		pstmt_ch										= connection.prepareStatement(SQL_OR_CATALOG_UPDATE);
//		pstmt_type										= connection.prepareStatement(SQL_OR_CATALOG_BY_TYPE_UPDATE);
		pstmt_syn										= connection.prepareStatement(SQL_OR_CATALOG_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_CATALOG_INSERT_BY_PTCL);
		pstmt_Instr										= connection.prepareStatement(SQL_OR_CATALOG_INSERT_PREPS_INSTRN);
		pstmt_Freq										= connection.prepareStatement(SQL_OR_CATALOG_FREQUENCY_INSERT);
		pstmt_Freq_del									= connection.prepareStatement(SQL_OR_CATALOG_FREQUENCY_DELETE);
        pstmt_Prep                                      = connection.prepareStatement(SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT);
        pstmt_Prep_del                                  = connection.prepareStatement(SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE);
       

		int	update_ch		= -1 ;
		//int	update_type		= -1 ;
		int	insert_syn[]	= {} ;
		int	delete_syn[]	= {} ;
		int	update_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_Instr[]	= {} ;
		int	insert_Freq[]	= {} ;
		int	insert_Prep[]	= {} ;
		int insert_fac_mapping[] = {};//IN068370,IN068373

		/******************INSERT INTO ORDER_CATALOG*************/

		String comment_format_id			 ="";
		String	pat_instrn_age_sex_yn 		 ="N";
		//IN64543, starts
		//String	temp				 		 =(String)recordOrderCatalog.get("pat_preps_or_instrns_id");
		String	temp = "";
		
		if(((String)recordOrderCatalog.get("instrn_content_type")).equals("T"))
			temp = (String)recordOrderCatalog.get("pat_preps_or_instrns_id");
		else if(((String)recordOrderCatalog.get("instrn_content_type")).equals("E"))
			temp = (String)recordOrderCatalog.get("pat_instrns_free_fmt_id");
		//IN64543, ends

		if(temp.trim().equalsIgnoreCase("IM"))
		{
			pat_instrn_age_sex_yn	= "Y" ;
		}

	//	traceVal.append("ORDER_CATALOG Insetion");
//		traceVal.append("CatalogHeader="+CatalogHeader.toString()+"   //////");
//		traceVal.append("charactersticsRec="+charactersticsRec.toString()+"   /////");
//		traceVal.append("recordOrderCatalog="+recordOrderCatalog.toString()+"   ");
//		traceVal.append("reviews="+reviews.toString()+"   ");

		String chk_for_dupl_ahead_period  =(String)charactersticsRec.get("chk_for_dupl_ahead_period");
		String chk_for_dupl_behind_period =(String)charactersticsRec.get("chk_for_dupl_behind_period");
		String appt_time				  =(String)recordOrderCatalog.get("appt_time") ;
		String consent_form_id			  =(String)charactersticsRec.get("consent_form_id") ;
		String refusal_form_id			  =(String)charactersticsRec.get("refusal_form_id") ;
		String priority_appl			  =(String)charactersticsRec.get("priority_appl") ;
		String proc_coding_scheme		  =(String)charactersticsRec.get("proc_coding_scheme") ;
		String discr_msr_panel_id		  =(String)charactersticsRec.get("discr_msr_panel_id") ;
		String consent_stage			  =(String)charactersticsRec.get("consent_stage") ;
		String num_of_consent_req_bo	  =(String)charactersticsRec.get("num_of_consent_req_bo") ;
		String num_of_consent_req_br	  =(String)charactersticsRec.get("num_of_consent_req_br") ;
		String dup_reason_reqd_yn		  =(String)charactersticsRec.get("dup_reason_reqd_yn");//IN024984
		
		if(chk_for_dupl_ahead_period.trim().equalsIgnoreCase(""))
			chk_for_dupl_ahead_period = "" ;

		if(chk_for_dupl_behind_period.trim().equalsIgnoreCase(""))
			chk_for_dupl_behind_period = "" ;

		java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date today = new java.util.Date();
		String dateString = dt.format(today);

		if(appt_time.trim().equals(""))
			appt_time = dateString + " " + "00:00" ;
		else
			appt_time = dateString + " " + appt_time ;

		traceVal.append("appt_time="+appt_time);

		if(consent_form_id.trim().equals(""))
			consent_form_id = null ;

		if(consent_stage.trim().equals(""))
			consent_stage = null ;

		if( num_of_consent_req_bo !=null && !num_of_consent_req_bo.equals("") && Integer.parseInt(num_of_consent_req_bo) > 0)
				consent_stage = "A" ;

		if( num_of_consent_req_br !=null && !num_of_consent_req_br.equals("") && Integer.parseInt(num_of_consent_req_br) > 0)
		{
			if(Integer.parseInt(num_of_consent_req_bo) > 0 )
				consent_stage = "A" ;
			else
				consent_stage = "R" ;
		}

		if(refusal_form_id.trim().equals(""))
			refusal_form_id = null ;

	    if(priority_appl.trim().equals(""))
			priority_appl = null ;

//		traceVal.append("discr_msr_panel_id="+discr_msr_panel_id);

		if(discr_msr_panel_id.trim().equals(""))
			discr_msr_panel_id = null ;
		if(proc_coding_scheme.trim().equals(""))
			proc_coding_scheme = null ;


        String stat_turn_around_time = (turnAroundRec.get("stat_turn_around_time") != null) ? (String)turnAroundRec.get("stat_turn_around_time") : "";
	    String stat_turn_around_type = (turnAroundRec.get("stat_turn_around_type") != null) ? (String)turnAroundRec.get("stat_turn_around_type") : "";
	    String urgent_turn_around_time = (turnAroundRec.get("urgent_turn_around_time") != null) ? (String)turnAroundRec.get("urgent_turn_around_time") : "";
	    String urgent_turn_around_type = (turnAroundRec.get("urgent_turn_around_type") != null) ? (String)turnAroundRec.get("urgent_turn_around_type") : "";
	    String routine_turn_around_time = (turnAroundRec.get("routine_turn_around_time") != null) ? (String)turnAroundRec.get("routine_turn_around_time") : "";
	    String routine_turn_around_type = (turnAroundRec.get("routine_turn_around_type") != null) ? (String)turnAroundRec.get("routine_turn_around_type") : "";
	    String l_instrn_content_type = (String)recordOrderCatalog.get("instrn_content_type");//IN64543

		pstmt_ch.setString(1	,(String)CatalogHeader.get("long_desc"));
		pstmt_ch.setString(2	,(String)CatalogHeader.get("short_desc"));
		pstmt_ch.setString(3	,(String)CatalogHeader.get("order_category"));
		pstmt_ch.setString(4	,(String)CatalogHeader.get("order_type_code"));
		pstmt_ch.setString(5	,(String)CatalogHeader.get("activity_type"));
		pstmt_ch.setString(6	,(String)CatalogHeader.get("image_link_id"));
		pstmt_ch.setString(7	,CatalogHeader.get("indexed_yn")==null?"N":(String)CatalogHeader.get("indexed_yn"));
		pstmt_ch.setString(8	,(String)CatalogHeader.get("security_level"));
		pstmt_ch.setString(9	,(String)charactersticsRec.get("order_catalog_nature"));
		pstmt_ch.setString(10	,(String)charactersticsRec.get("consent_reqd_yn"));
		pstmt_ch.setString(11	,consent_form_id);
		pstmt_ch.setString(12	,refusal_form_id);
		pstmt_ch.setString(13	,priority_appl);
		pstmt_ch.setString(14	,(String)recordOrderCatalog.get("prompt_alert_yn"));
		pstmt_ch.setString(15	,(String)recordOrderCatalog.get("prompt_alert_msg"));
		pstmt_ch.setString(16	,(String)charactersticsRec.get("qty_reqd_yn"));		
		pstmt_ch.setString(17	,(String)charactersticsRec.get("qty_uom"));
		pstmt_ch.setString(18	,(String)charactersticsRec.get("split_dose_yn"));
		pstmt_ch.setString(19	,(String)charactersticsRec.get("taper_dose_yn"));
		pstmt_ch.setString(20	,(String)charactersticsRec.get("taper_up"));
		pstmt_ch.setString(21	,(String)charactersticsRec.get("appl_sliding_scale_yn"));
		pstmt_ch.setString(22	,(String)charactersticsRec.get("freq_applicable_yn"));
		pstmt_ch.setString(23	,(String)charactersticsRec.get("soft_stop_yn"));
		pstmt_ch.setString(24	,(String)charactersticsRec.get("cont_order_yn"));
		pstmt_ch.setString(25	,(String)charactersticsRec.get("refill_cont_order_yn"));
		pstmt_ch.setString(26	,comment_format_id); //from sql
		pstmt_ch.setString(27	,(String)charactersticsRec.get("chk_for_dupl_yn"));
		pstmt_ch.setString(28	,(String)charactersticsRec.get("chk_for_dupl_status"));
		pstmt_ch.setString(29	,(String)charactersticsRec.get("chk_for_dupl_ahead_action"));
		pstmt_ch.setString(30	,chk_for_dupl_ahead_period);
		pstmt_ch.setString(31	,(String)charactersticsRec.get("chk_for_dupl_ahead_unit"));
		pstmt_ch.setString(32	,(String)charactersticsRec.get("chk_for_dupl_behind_action"));
		pstmt_ch.setString(33	,chk_for_dupl_behind_period);
		pstmt_ch.setString(34	,(String)charactersticsRec.get("chk_for_dupl_behind_unit"));
		pstmt_ch.setString(35	,(String)reviews.get("ord_auth_level"));
		pstmt_ch.setString(36	,(String)reviews.get("ord_cosign_level"));
		pstmt_ch.setString(37	,(String)reviews.get("ord_spl_appr_level"));
		pstmt_ch.setString(38	,(String)recordOrderCatalog.get("appt_reqd_yn"));
		pstmt_ch.setString(39	,(String)recordOrderCatalog.get("follow_visit_type_yn")); //  added for IN031304
		pstmt_ch.setString(40	,appt_time);
		pstmt_ch.setString(41	,pat_instrn_age_sex_yn);//depends in instr Tab
		pstmt_ch.setString(42	,(String)charactersticsRec.get("dept_only_yn"));
		pstmt_ch.setString(43	,(String)charactersticsRec.get("complete_on_order_yn"));
		pstmt_ch.setString(44	,(String)charactersticsRec.get("bill_yn"));
		pstmt_ch.setString(45	,(String)charactersticsRec.get("charge_type_applicable"));
		pstmt_ch.setString(46	,(String)charactersticsRec.get("result_applicable_yn"));
		pstmt_ch.setString(47	,(String)charactersticsRec.get("auto_report_yn"));
		pstmt_ch.setString(48	,(String)charactersticsRec.get("result_auth_reqd_yn"));
		pstmt_ch.setString(49	,(String)charactersticsRec.get("chart_result_type"));
		pstmt_ch.setString(50	,proc_coding_scheme);
		pstmt_ch.setString(51	,discr_msr_panel_id);
		pstmt_ch.setString(52	,(String)charactersticsRec.get("contr_mod_id"));
		pstmt_ch.setString(53	,(String)charactersticsRec.get("contr_msr_panel_id"));
		pstmt_ch.setString(54	,(String)charactersticsRec.get("proc_link_applicable"));
		pstmt_ch.setString(55	,(String)charactersticsRec.get("proc_link_resulting_option"));
		pstmt_ch.setString(56	,(String)charactersticsRec.get("term_set_id"));
		pstmt_ch.setString(57	,(String)charactersticsRec.get("term_code"));
		//**pstmt_ch.setString(55	,(String)charactersticsRec.get("image_link_id"));//moved to header frame
		//pstmt_ch.setString(56	,(String)charactersticsRec.get("indexed_yn"));
		pstmt_ch.setString(58	,(String)CatalogHeader.get("eff_status"));
		pstmt_ch.setString(59	,(String)charactersticsRec.get("contineous_freq_order"));//Little differnce in databas name and bean name
		pstmt_ch.setString(60	,login_by_id);
		pstmt_ch.setString(61	,login_at_ws_no);
		pstmt_ch.setString(62	,login_facility_id);
		pstmt_ch.setString(63	,field_format_id);//FROM SQL
		//pstmt_ch.setString(55   ,(String)charactersticsRec.get("activity_type"));
		pstmt_ch.setString(64   ,(String)charactersticsRec.get("check_for_dupl_level"));
        pstmt_ch.setString(65  ,stat_turn_around_time);
		pstmt_ch.setString(66   ,stat_turn_around_type);
		pstmt_ch.setString(67   ,urgent_turn_around_time);
		pstmt_ch.setString(68   ,urgent_turn_around_type);
		pstmt_ch.setString(69   ,routine_turn_around_time);
		pstmt_ch.setString(70   ,routine_turn_around_type);
		pstmt_ch.setString(71	,(String)charactersticsRec.get("confidential_yn"));
		pstmt_ch.setString(72	,(String)recordOrderCatalog.get("stat_appt_reqd_yn"));
		pstmt_ch.setString(73	,(String)recordOrderCatalog.get("urgent_appt_reqd_yn"));
		pstmt_ch.setString(74	,(String)recordOrderCatalog.get("routine_appt_reqd_yn"));
		pstmt_ch.setString(75	,consent_stage);
		pstmt_ch.setString(76	,(String)charactersticsRec.get("routine_chk_for_dupl_yn"));
		pstmt_ch.setString(77	,(String)charactersticsRec.get("urgent_chk_for_dupl_yn"));
		pstmt_ch.setString(78	,(String)charactersticsRec.get("stat_chk_for_dupl_yn"));
		pstmt_ch.setString(79	,(String)charactersticsRec.get("explanatory_text"));
		pstmt_ch.setString(80	,(String)recordOrderCatalog.get("appt_prep_time"));
		pstmt_ch.setString(81	,(String)recordOrderCatalog.get("appt_prep_time_type"));
		pstmt_ch.setString(82	,(String)recordOrderCatalog.get("appt_action_for_prep"));
		pstmt_ch.setString(83	,(String)charactersticsRec.get("consent_form_list"));
		pstmt_ch.setString(84	,num_of_consent_req_bo);
		pstmt_ch.setString(85	,num_of_consent_req_br);
		pstmt_ch.setString(86	,(String)recordOrderCatalog.get("clin_cmts_reqd_yn"));
		pstmt_ch.setString(87	,(String)recordOrderCatalog.get("splty_speci_reqd_yn"));
		pstmt_ch.setString(88	,(String)recordOrderCatalog.get("pri_splty_code"));
		pstmt_ch.setString(89	,(String)CatalogHeader.get("linked_vaccine_id"));
		pstmt_ch.setString(90	,dup_reason_reqd_yn);//IN024984
		pstmt_ch.setString(91	,(String)charactersticsRec.get("barcode_reqd_yn"));//IN063816 included BARCODE_REQD_YN
		//pstmt_ch.setString(92	,(String)CatalogHeader.get("order_catalog_code"));//IN065942, commented
		/*pstmt_ch.setString(92	,(String)charactersticsRec.get("prn_regd_ord"));//IN065942
		pstmt_ch.setString(93	,(String)CatalogHeader.get("order_catalog_code"));//IN065942*/
		pstmt_ch.setString(92	,(String)charactersticsRec.get("prn_regd_ord"));//IN065942
		pstmt_ch.setString(93	,(String)recordOrderCatalog.get("invoke_instrn_window_yn"));//IN064543
		pstmt_ch.setString(94	,l_instrn_content_type);//IN64543
		//pstmt_ch.setString(94	,(String)CatalogHeader.get("order_catalog_code"));//IN065942
		pstmt_ch.setString(95	,tpn_item_yn);//IN068926
		pstmt_ch.setString(96	,(String)charactersticsRec.get("fpp_yn"));//IN068314
		pstmt_ch.setString(97	,(String)charactersticsRec.get("fpp_category"));//IN068314
		pstmt_ch.setString(98	,(String)charactersticsRec.get("freq_order_split_indvi_yn"));//7540
		pstmt_ch.setString(99	,(String)CatalogHeader.get("order_catalog_code"));//IN065942//IN068314
		

//        traceVal.append("1:"+(String)CatalogHeader.get("long_desc")+",2:"+(String)CatalogHeader.get("short_desc")+",3:"+(String)CatalogHeader.get("order_category")+",4:"+(String)CatalogHeader.get("order_type_code")+",5:"+
//        (String)CatalogHeader.get("security_level")+",6:"+(String)charactersticsRec.get("order_catalog_nature")+",7:"+
//        (String)charactersticsRec.get("consent_reqd_yn")+",8:"+consent_form_id+",9:"+
//        (String)recordOrderCatalog.get("prompt_alert_yn")+",10:"+(String)recordOrderCatalog.get("prompt_alert_msg")+",11:"+
//        (String)charactersticsRec.get("qty_reqd_yn")+",12:"+(String)charactersticsRec.get("qty_uom")+",13:"+
//        (String)charactersticsRec.get("split_dose_yn")+",14:"+(String)charactersticsRec.get("taper_dose_yn")+",15:"+
//        (String)charactersticsRec.get("freq_applicable_yn")+",16:"+(String)charactersticsRec.get("soft_stop_yn")+",17:"+
//        (String)charactersticsRec.get("cont_order_yn")+",18:"+(String)charactersticsRec.get("refill_cont_order_yn")+",19:"+
//        comment_format_id+",20:"+(String)charactersticsRec.get("chk_for_dupl_yn")+",21:"+
//        (String)charactersticsRec.get("chk_for_dupl_status")+",22:"+(String)charactersticsRec.get("chk_for_dupl_ahead_action")+",23:"+
//        chk_for_dupl_ahead_period+",24:"+(String)charactersticsRec.get("chk_for_dupl_ahead_unit")+",25:"+
//        (String)charactersticsRec.get("chk_for_dupl_behind_action")+",26:"+chk_for_dupl_behind_period+",27:"+
//        (String)charactersticsRec.get("chk_for_dupl_behind_unit")+",28:"+(String)reviews.get("ord_auth_level")+",29:"+
//        (String)reviews.get("ord_cosign_level")+",30:"+(String)reviews.get("ord_spl_appr_level")+",31:"+
//        (String)recordOrderCatalog.get("appt_reqd_yn")+",32:"+appt_time+",33:"+pat_instrn_age_sex_yn+",34:"+
//        (String)charactersticsRec.get("dept_only_yn")+",35:"+(String)charactersticsRec.get("complete_on_order_yn")+",36:"+
//        (String)charactersticsRec.get("bill_yn")+",37:"+(String)charactersticsRec.get("result_applicable_yn")+",38:"+
//        (String)charactersticsRec.get("result_auth_reqd_yn")+",39:"+(String)charactersticsRec.get("chart_result_type")+",40:"+
//        discr_msr_panel_id+",41:"+(String)charactersticsRec.get("contr_mod_id")+",42:"+(String)charactersticsRec.get("contr_msr_panel_id")+",43:"+
//        (String)charactersticsRec.get("image_link_id")+",44:"+(String)charactersticsRec.get("indexed_yn")+",45:"+
//        (String)CatalogHeader.get("eff_status")+",46:"+(String)charactersticsRec.get("contineous_freq_order")+",47:"+
//        login_by_id+",48:"+login_at_ws_no+",49:"+login_facility_id+",50:"+field_format_id+",51:"+(String)CatalogHeader.get("order_catalog_code"));

        update_ch			= pstmt_ch.executeUpdate();

		traceVal.append("ORDER_CATALOG after updation");
		
		//IN068370,IN068373, starts
		if("Y".equals(globalFacilityYn) && siteSpecGlobalFac)
	    {
			String l_catalog_code = (String)CatalogHeader.get("order_catalog_code");
			pstmt_del_appl_facility.setString(1, l_catalog_code);
			pstmt_del_appl_facility.execute();
		
			if(mappedFacilities!=null && mappedFacilities.size()>0)
			{
				for(int i=0;i<mappedFacilities.size();i++)
				{
					pstmt_appl_facility.setString(1, l_catalog_code);
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

  /****************INSERT ORDER CATALOG TYPE ***********************/
		/*	pstmt_type.setString(1 ,(String)CatalogHeader.get("order_type_code"));
			pstmt_type.setString(2 ,login_by_id);
			pstmt_type.setString(3 ,login_at_ws_no);
			pstmt_type.setString(4 ,login_facility_id);
			pstmt_type.setString(5,(String)CatalogHeader.get("order_catalog_code"));

			update_type = pstmt_type.executeUpdate();
		  */
/**************INSERT INTO ORDER CATALOG SYNONYM**************/

		String 	effective_status_primary		= (String)charactersticsRec.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)charactersticsRec.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)charactersticsRec.get("effective_status_ancillaryDept") ;

	//	traceVal.append("at start for syn");
		select_pstmt_syn.setString(1 , (String)CatalogHeader.get("order_catalog_code"));
		sel_syn_rstset = select_pstmt_syn.executeQuery();
		String syn_type = "";
		String cat_syn  = "";
		HashMap synonymExists = new HashMap();
		while(sel_syn_rstset!=null && sel_syn_rstset.next())
		{
			syn_type = sel_syn_rstset.getString("catalog_synonym_type");
			cat_syn  = sel_syn_rstset.getString("catalog_synonym");
			synonymExists.put(syn_type,cat_syn);
		}
		sel_syn_rstset.close();
		select_pstmt_syn.close();
		
		if(effective_status_primary.trim().equalsIgnoreCase("Y"))
		{//This insertion is Mandatory
			if(synonymExists.containsKey("PR"))
			{
				update_pstmt_syn.setString(1 , (String)charactersticsRec.get("catalog_synonym_primary"));
				update_pstmt_syn.setString(2 , login_by_id);
				update_pstmt_syn.setString(3 , login_at_ws_no);
				update_pstmt_syn.setString(4 , login_facility_id);
				update_pstmt_syn.setString(5 , effective_status_primary);
				update_pstmt_syn.setString(6 , (String)CatalogHeader.get("order_catalog_code"));
				update_pstmt_syn.setString(7 , "PR");
				update_pstmt_syn.addBatch() ;
			}
			else
			{
				pstmt_syn.setString(1 , (String)CatalogHeader.get("order_catalog_code"));
				pstmt_syn.setString(2 , "PR");
				pstmt_syn.setString(3 , (String)charactersticsRec.get("catalog_synonym_primary"));
				pstmt_syn.setString(4 , login_by_id);
				pstmt_syn.setString(5 , login_at_ws_no);
				pstmt_syn.setString(6 , login_facility_id);
				pstmt_syn.setString(7 , login_by_id);
				pstmt_syn.setString(8 , login_at_ws_no);
				pstmt_syn.setString(9 , login_facility_id);
				pstmt_syn.setString(10 , effective_status_primary);//*************
				pstmt_syn.addBatch() ;

			}
		}
		else
		{
			del_pstmt_syn.setString(1 , (String)CatalogHeader.get("order_catalog_code"));
			del_pstmt_syn.setString(2 , "PR");
			del_pstmt_syn.addBatch();
		}

		if(effective_status_directCare.trim().equalsIgnoreCase("Y"))
		{
			if(synonymExists.containsKey("DC"))
			{
				update_pstmt_syn.setString(1 , (String)charactersticsRec.get("catalog_synonym_directCare"));
				update_pstmt_syn.setString(2 , login_by_id);
				update_pstmt_syn.setString(3 , login_at_ws_no);
				update_pstmt_syn.setString(4 , login_facility_id);
				update_pstmt_syn.setString(5 , effective_status_primary);
				update_pstmt_syn.setString(6 , (String)CatalogHeader.get("order_catalog_code"));
				update_pstmt_syn.setString(7 , "DC");
				update_pstmt_syn.addBatch();
			}
			else
			{
				pstmt_syn.setString(1 ,(String)CatalogHeader.get("order_catalog_code"));
				pstmt_syn.setString(2 ,"DC");
				pstmt_syn.setString(3 ,(String)charactersticsRec.get("catalog_synonym_directCare"));
				pstmt_syn.setString(4 ,login_by_id);
				pstmt_syn.setString(5 ,login_at_ws_no);
				pstmt_syn.setString(6 ,login_facility_id);
				pstmt_syn.setString(7 ,login_by_id);
				pstmt_syn.setString(8 ,login_at_ws_no);
				pstmt_syn.setString(9 ,login_facility_id);
				pstmt_syn.setString(10,effective_status_directCare);//*************
				pstmt_syn.addBatch() ;
			}
		}
		else
		{
			del_pstmt_syn.setString(1 , (String)CatalogHeader.get("order_catalog_code"));
			del_pstmt_syn.setString(2 , "DC");
			del_pstmt_syn.addBatch();
		}

		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y"))
		{
			if(synonymExists.containsKey("AD"))
			{
				update_pstmt_syn.setString(1 , (String)charactersticsRec.get("catalog_synonym_ancillaryDept"));
				update_pstmt_syn.setString(2 , login_by_id);
				update_pstmt_syn.setString(3 , login_at_ws_no);
				update_pstmt_syn.setString(4 , login_facility_id);
				update_pstmt_syn.setString(5 , effective_status_primary);
				update_pstmt_syn.setString(6 , (String)CatalogHeader.get("order_catalog_code"));
				update_pstmt_syn.setString(7 , "AD");
				update_pstmt_syn.addBatch();
			}
			else
			{
				pstmt_syn.setString(1 ,(String)CatalogHeader.get("order_catalog_code"));
				pstmt_syn.setString(2 ,"AD");
				pstmt_syn.setString(3 ,(String)charactersticsRec.get("catalog_synonym_ancillaryDept"));
				pstmt_syn.setString(4 ,login_by_id);
				pstmt_syn.setString(5 ,login_at_ws_no);
				pstmt_syn.setString(6 ,login_facility_id);
				pstmt_syn.setString(7 ,login_by_id);
				pstmt_syn.setString(8 ,login_at_ws_no);
				pstmt_syn.setString(9 ,login_facility_id);
				pstmt_syn.setString(10,effective_status_ancillaryDept);//*************
				pstmt_syn.addBatch();
			}
		}
		else
		{
			del_pstmt_syn.setString(1 , (String)CatalogHeader.get("order_catalog_code"));
			del_pstmt_syn.setString(2 , "AD");
			del_pstmt_syn.addBatch();
		}

		traceVal.append("before execuution");
		insert_syn = pstmt_syn.executeBatch();		
		update_syn = update_pstmt_syn.executeBatch();
		delete_syn = del_pstmt_syn.executeBatch();
		traceVal.append("after insertion sysn="+insert_syn);
/**************INSERT INTO OR_ORDER BY PTCL*******************/

		int sizeReviews				=Reviews.size()  ;
		int sizeSettings			=Settings.size()  ;
		int iterateVal				=0;

		if(sizeReviews == sizeSettings)
		iterateVal = sizeReviews ;
		else if(sizeReviews > sizeSettings)
		iterateVal = sizeReviews ;
		else if(sizeReviews < sizeSettings)
		iterateVal = sizeSettings ;


		traceVal.append("iterateVal="+iterateVal + "  ");

//			traceVal.append("Reviews="+Reviews + "   //////");
//		traceVal.append("Settings="+Settings + "   //////");


///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same
		for(int i = 0; i < iterateVal ; i++)
		{//0 for the default

			double qty_value				= 0.0 ;
			long   durn_value				= 0 ;
			long   max_durn_value			= 0;

			String qty_value_str			=  "";
			String durn_value_str			=  "";
			String max_durn_value_str		=  "";
			String patient_class			="";
			String setting_applicability_R	="x";
			String setting_applicability_S	="X";
			String ord_auth_reqd_yn			="N";
			String ord_cosign_reqd_yn		="N";
			String ord_spl_appr_reqd_yn		="N";
			//String setting_applicability	="X" ;
			String qty_uom					="" ;
			String age_group_code			="" ;
			String freq_code				="" ;
			String durn_type				="" ;
			String max_durn_type			="" ;
			String chk_for_max_durn_action	="" ;
			String ord_auth_level			="" ;
			String prompt_msg				="" ;
			String ord_skip_auth			="NA" ; //IN048467
			boolean atleastOneAppl			=false;

			if(i <= (sizeReviews-1) && i <= (sizeSettings-1))
			{//This condn  will be always true

//				traceVal.append("Loop strats=/b/"+i);

				tempReview  = (HashMap)Reviews.get(i);
				tempSetting = (HashMap)Settings.get(i);

				setting_applicability_S	    =tempSetting.get("setting_applicability")==null?"X":(String)tempSetting.get("setting_applicability");
				setting_applicability_R		=tempReview.get("setting_applicability")==null?"x":(String)tempReview.get("setting_applicability") ;

				if(setting_applicability_R.trim().equalsIgnoreCase("A") || i== 0 )
				{
					patient_class				=(String)tempReview.get("patient_class");
//					traceVal.append("patient_class="+patient_class);
					ord_auth_reqd_yn			=(String)tempReview.get("ord_auth_reqd_yn");
					ord_cosign_reqd_yn		    =(String)tempReview.get("ord_cosign_reqd_yn");
					ord_spl_appr_reqd_yn		=(String)tempReview.get("ord_spl_appr_reqd_yn");
					ord_skip_auth 				= (String)tempReview.get("skip_auth"); //IN048467
					atleastOneAppl				= true;
					//IN048467 - Start
					if(ord_skip_auth == null || ord_skip_auth.equals("")) {
						ord_skip_auth = "NA";
					}
					//IN048467 - End
				}

				if(setting_applicability_S.trim().equalsIgnoreCase("A") || i== 0 || "PH".equals(order_category))
				{//IN049998
//					traceVal.append("Lp-bse/"+i);

					qty_value_str					= (String)tempSetting.get("qty_value");
					durn_value_str					= (String)tempSetting.get("durn_value");
					max_durn_value_str				= (String)tempSetting.get("max_durn_value");

					if(!qty_value_str.trim().equals(""))
						qty_value		= Double.parseDouble(qty_value_str);

					if(!(durn_value_str.equals("")))
					{
						durn_value		= Long.parseLong(durn_value_str);
					}

					if(!max_durn_value_str.trim().equals(""))
						max_durn_value	= Long.parseLong(max_durn_value_str);

					freq_code			= (String)tempSetting.get("freq_code");
//					traceVal.append("ferq Code="+freq_code);

					if(freq_code.trim().equals(""))
						freq_code = null ;

					age_group_code			= (String)tempSetting.get("age_group_code");
//					traceVal.append("ferq Code="+freq_code);

					if(age_group_code.trim().equals(""))
						age_group_code = null ;

//					traceVal.append("freq_code="+freq_code);

					qty_uom					    =(String)tempSetting.get("qty_uom");
					patient_class				=(String)tempSetting.get("patient_class");
					durn_type					=(String)tempSetting.get("durn_type");
					max_durn_type				=(String)tempSetting.get("max_durn_type");
					chk_for_max_durn_action		=(String)tempSetting.get("chk_for_max_durn_action");
					ord_auth_level				=(String)tempSetting.get("ord_auth_level");
					prompt_msg					=(String)tempSetting.get("prompt_msg");
					atleastOneAppl				= true;
				 }
				tempReview.clear();
				tempSetting.clear();

			}
			else if(i <= (sizeReviews-1) && i >= sizeSettings)
			{//This condn when he has  visited reviews but not settings

	//				traceVal.append("Lp=/Re/"+i);
					tempReview  = (HashMap)Reviews.get(i);
					setting_applicability_R		=tempReview.get("setting_applicability")==null?"x":(String)tempReview.get("setting_applicability") ;
					if(setting_applicability_R.trim().equalsIgnoreCase("A"))
					{
						patient_class				=(String)tempReview.get("patient_class");
						ord_auth_reqd_yn			=(String)tempReview.get("ord_auth_reqd_yn");
						ord_cosign_reqd_yn		    =(String)tempReview.get("ord_cosign_reqd_yn");
						ord_spl_appr_reqd_yn		=(String)tempReview.get("ord_spl_appr_reqd_yn");
						ord_skip_auth 				= (String)tempReview.get("skip_auth"); // IN048467
						atleastOneAppl				= true;
						//IN048467 - Start
						if(ord_skip_auth == null || ord_skip_auth.equals("")) {
							ord_skip_auth = "NA";
						}
						//IN048467 - End
					}
					tempReview.clear();
			}
			else
			{

			    if(i >= sizeReviews && i <= (sizeSettings-1))
				{//This condn when he has  visited settings  but not reviews tab


	//				traceVal.append("Lp=/Se/"+i);
					tempSetting = (HashMap)Settings.get(i);

	//				traceVal.append("Lp=/tempSetting/"+tempSetting);

					setting_applicability_S	    =tempSetting.get("setting_applicability")==null?"X":(String)tempSetting.get("setting_applicability");


					if(setting_applicability_S.trim().equalsIgnoreCase("A"))
					{

//					traceVal.append("Lp=/insise se/"+i);

					qty_value_str					= (String)tempSetting.get("qty_value");
					durn_value_str					= (String)tempSetting.get("durn_value");
					max_durn_value_str				= (String)tempSetting.get("max_durn_value");


					if(!qty_value_str.trim().equals(""))
						qty_value		= Double.parseDouble(qty_value_str);

//					traceVal.append("se="+ i+durn_value);

					if(!durn_value_str.trim().equals(""))
						durn_value  = Long.parseLong(durn_value_str);

					if(!max_durn_value_str.trim().equals(""))
						max_durn_value = Long.parseLong(max_durn_value_str);


					freq_code					=(String)tempSetting.get("freq_code");

//					traceVal.append("freq_code="+ i+freq_code);

					if(freq_code.trim().equals(""))
						freq_code = null ;

                    age_group_code					=(String)tempSetting.get("age_group_code");

//					traceVal.append("freq_code="+ i+freq_code);

					if(age_group_code.trim().equals(""))
						age_group_code = null ;

					qty_uom					    =(String)tempSetting.get("qty_uom");
					patient_class				=(String)tempSetting.get("patient_class");
					durn_type					=(String)tempSetting.get("durn_type");
					max_durn_type				=(String)tempSetting.get("max_durn_type");
					chk_for_max_durn_action		=(String)tempSetting.get("chk_for_max_durn_action");
					ord_auth_level				=(String)tempSetting.get("ord_auth_level");
					prompt_msg					=(String)tempSetting.get("prompt_msg");
					atleastOneAppl				= true;
				 }
		tempSetting.clear();
			}//End of If
	   }//End of Last Else



			if(atleastOneAppl)
			{
	//			traceVal.append("patient_class:="+ i + patient_class);
				pstmt_ptcl.setString(1	 ,(String)CatalogHeader.get("order_catalog_code"));
				pstmt_ptcl.setString(2	 ,patient_class);
				pstmt_ptcl.setString(3	 ,setting_applicability_R); //Setting
				pstmt_ptcl.setString(4	 ,ord_auth_reqd_yn);
				pstmt_ptcl.setString(5	 ,ord_cosign_reqd_yn);
				pstmt_ptcl.setString(6	 ,ord_spl_appr_reqd_yn);
				pstmt_ptcl.setString(7	 ,setting_applicability_S);
				pstmt_ptcl.setString(8	 ,age_group_code);
				pstmt_ptcl.setDouble(9	 ,qty_value);
				pstmt_ptcl.setString(10	 ,qty_uom);
				pstmt_ptcl.setString(11	 ,freq_code);
				pstmt_ptcl.setLong(	 12	 ,durn_value);
				pstmt_ptcl.setString(13	 ,durn_type);
				pstmt_ptcl.setString(14	 ,max_durn_type);
				pstmt_ptcl.setString(15	 ,chk_for_max_durn_action);
				pstmt_ptcl.setString(16	 ,ord_auth_level);
				pstmt_ptcl.setString(17  ,prompt_msg);
				pstmt_ptcl.setString(18	 ,login_by_id);
				pstmt_ptcl.setString(19	 ,login_at_ws_no);
				pstmt_ptcl.setString(20  ,login_facility_id);
				pstmt_ptcl.setString(21  ,login_by_id);
				pstmt_ptcl.setString(22  ,login_at_ws_no);
				pstmt_ptcl.setString(23  ,login_facility_id);
				pstmt_ptcl.setLong(	 24  ,max_durn_value);
				pstmt_ptcl.setString(25  ,ord_skip_auth); //IN048467
				pstmt_ptcl.addBatch();
			}

	}//end of For Loop for PTCL INSERTION


				insert_ptcl = pstmt_ptcl.executeBatch();

				traceVal.append("afterInsertion="+insert_ptcl.length);


/*****************INSERTION FOR OR ORDER CATALOG PREPS INSTRN************/

	/*Instr*/
			recordOrderCatalog  =(HashMap)Instructions.get(0);
			recordPreps		    =(HashMap)Instructions.get(1);
			recordStdIntruction =(HashMap)Instructions.get(2);
			recordByAge			=(HashMap)Instructions.get(3);

		traceVal.append("recordOrderCatalog="+recordOrderCatalog);
		traceVal.append("recordPreps="+recordPreps);
		traceVal.append("recordStdIntruction="+recordStdIntruction);
		traceVal.append("recordByAge="+recordByAge);


	//Insertion of recordOrderCatalog is Mandatory
		pstmt_Instr.setString(1 ,(String)recordPreps.get("pat_preps_or_instrns_id_pr"));
		pstmt_Instr.setString(2			,"0");
		pstmt_Instr.setString(3			,"0");
		pstmt_Instr.setString(4			,"0");
		pstmt_Instr.setString(5			,"0");
		pstmt_Instr.setString(6			,"0");
		pstmt_Instr.setString(7			,"0");
		pstmt_Instr.setLong(8			,0);
		pstmt_Instr.setLong(9			,0);
		pstmt_Instr.setString(10		,"N");
		pstmt_Instr.setString(11		,(String)recordPreps.get("pat_preps_or_instrns_txt_pr"));
		pstmt_Instr.setString(12		,login_by_id);
		pstmt_Instr.setString(13		,login_at_ws_no);
		pstmt_Instr.setString(14		,login_facility_id);
		pstmt_Instr.setString(15		,login_by_id);
		pstmt_Instr.setString(16		,login_at_ws_no);
		pstmt_Instr.setString(17		,login_facility_id);
		pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

		pstmt_Instr.addBatch();


	//Insertion of recordOrderCatalog is Mandatory----DepartMent Instrns
		pstmt_Instr.setString(1 ,(String)recordPreps.get("pat_preps_or_instrns_id_dr"));
		pstmt_Instr.setString(2			,"0");
		pstmt_Instr.setString(3			,"0");
		pstmt_Instr.setString(4			,"0");
		pstmt_Instr.setString(5			,"0");
		pstmt_Instr.setString(6			,"0");
		pstmt_Instr.setString(7			,"0");
		pstmt_Instr.setLong(8			,0);
		pstmt_Instr.setLong(9			,0);
		pstmt_Instr.setString(10		,"N");
		pstmt_Instr.setString(11		,(String)recordPreps.get("pat_preps_or_instrns_txt_dr"));
		pstmt_Instr.setString(12		,login_by_id);
		pstmt_Instr.setString(13		,login_at_ws_no);
		pstmt_Instr.setString(14		,login_facility_id);
		pstmt_Instr.setString(15		,login_by_id);
		pstmt_Instr.setString(16		,login_at_ws_no);
		pstmt_Instr.setString(17		,login_facility_id);
		pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

		pstmt_Instr.addBatch();

		//IN64543, starts
		//String pat_preps_or_instrns_id	=(String) recordOrderCatalog.get("pat_preps_or_instrns_id");
		
		String pat_preps_or_instrns_id	="";		
		
		if(((String)recordOrderCatalog.get("instrn_content_type")).equals("T"))
			pat_preps_or_instrns_id = (String)recordOrderCatalog.get("pat_preps_or_instrns_id");
		else if(((String)recordOrderCatalog.get("instrn_content_type")).equals("E"))
			pat_preps_or_instrns_id = (String)recordOrderCatalog.get("pat_instrns_free_fmt_id");
		//IN64543, ends

		 if(pat_preps_or_instrns_id.trim().equals("IS"))
		 {//By standards

			Object  pat_txt_is_obj = recordStdIntruction.get("pat_preps_or_instrns_txt_is") ;
			String  pat_txt_is     ="";

			if(pat_txt_is_obj != null)
				pat_txt_is = (String)pat_txt_is_obj;

			pstmt_Instr.setString(1			,"IS");
			pstmt_Instr.setString(2			,"0");
			pstmt_Instr.setString(3			,"0");
			pstmt_Instr.setString(4			,"0");
			pstmt_Instr.setString(5			,"0");
			pstmt_Instr.setString(6			,"0");
			pstmt_Instr.setString(7			,"0");
			pstmt_Instr.setLong(8			,0);
			pstmt_Instr.setLong(9			,0);
			pstmt_Instr.setString(10		,"N");
			pstmt_Instr.setString(11		,pat_txt_is);
			pstmt_Instr.setString(12		,login_by_id);
			pstmt_Instr.setString(13		,login_at_ws_no);
			pstmt_Instr.setString(14		,login_facility_id);
			pstmt_Instr.setString(15		,login_by_id);
			pstmt_Instr.setString(16		,login_at_ws_no);
			pstmt_Instr.setString(17		,login_facility_id);
			pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

			pstmt_Instr.addBatch();

		}
		else if(pat_preps_or_instrns_id.trim().equals("IM"))
		{
			//ML-MMOH-SCF-1108 start
			Object recordObj = null;
			if("E".equals(l_instrn_content_type))
			{
				recordObj = ((HashMap)tabData_p.get("InstructionClobTemp")).get("pat_preps_or_instrns_free_fmt_im");			
			}
			else if("T".equals(l_instrn_content_type))
			{
				recordObj= recordByAge.get("records");			
			}
			//ML-MMOH-SCF-1108 end
			ArrayList records = null ;
			HashMap	currRec=new HashMap();
			//IN064543 K start
			clobDataAge = new ArrayList<Object>();
			if (recordObj!=null)////IN64543
			{
			for(Object obj:(ArrayList)recordObj){	
				clobDataAge.add(obj) ;
			}
			//IN064543 K end
			if(recordObj == null )
				records =new ArrayList();
			else
				records =(ArrayList)recordObj;

			int recsize = 	records.size();
			if(recsize != 0)
			{
			 for (int j = 0; j < recsize ; j++ )
			 {
				currRec =(HashMap)records.get(j);

				String min_age_in_days				=(String)currRec.get("min_age_in_days");
				String min_age_in_mths				=(String)currRec.get("min_age_in_mths");
				String min_age_in_yrs				=(String)currRec.get("min_age_in_yrs");
				String max_age_in_days				=(String)currRec.get("max_age_in_days");
				String max_age_in_mths				=(String)currRec.get("max_age_in_mths");
				String max_age_in_yrs				=(String)currRec.get("max_age_in_yrs");
				String sex_spec_ind					=(String)currRec.get("sex_spec_ind");
				String pat_preps_or_instrns_txt		=(String)currRec.get("pat_preps_or_instrns_txt");

				long currMinTotal  = getDaysEJB(Long.parseLong(min_age_in_yrs),Integer.parseInt(min_age_in_mths),Long.parseLong(min_age_in_days));
				long currMaxTotal  = getDaysEJB(Long.parseLong(max_age_in_yrs),Integer.parseInt(max_age_in_mths),Long.parseLong(max_age_in_days));


				/*INSERT INTO or_order_catalog_preps_instrn(PAT_PREPS_OR_INSTRNS_IND,MIN_AGE_IN_DAYS,MIN_AGE_IN_MTHS,MIN_AGE_IN_YRS,MAX_AGE_IN_DAYS,MAX_AGE_IN_MTHS,MAX_AGE_IN_YRS,CALC_MIN_AGE_IN_DAYS,CALC_MAX_AGE_IN_DAYS,SEX_SPEC_IND,PAT_PREPS_OR_INSTRNS_TXT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_CATALOG_CODE ) values (? ,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)*/

				pstmt_Instr.setString(1	,"IM");
				pstmt_Instr.setString(2			,min_age_in_days);
				pstmt_Instr.setString(3			,min_age_in_mths);
				pstmt_Instr.setString(4			,min_age_in_yrs);
				pstmt_Instr.setString(5			,max_age_in_days);
				pstmt_Instr.setString(6			,max_age_in_mths);
				pstmt_Instr.setString(7			,max_age_in_yrs);
				pstmt_Instr.setLong(8			,currMinTotal);
				pstmt_Instr.setLong(9			,currMaxTotal);
				pstmt_Instr.setString(10		,sex_spec_ind);
				pstmt_Instr.setString(11		,pat_preps_or_instrns_txt);
				pstmt_Instr.setString(12		,login_by_id);
				pstmt_Instr.setString(13		,login_at_ws_no);
				pstmt_Instr.setString(14		,login_facility_id);
				pstmt_Instr.setString(15		,login_by_id);
				pstmt_Instr.setString(16		,login_at_ws_no);
				pstmt_Instr.setString(17		,login_facility_id);
				pstmt_Instr.setString(18		,(String)CatalogHeader.get("order_catalog_code"));

				pstmt_Instr.addBatch();
				//currRec.clear();//IN064543 K 
			  }

			}//End of loop if size not equals zero
			//records.clear();//IN064543 K 
		  }//End of esle loop for pat_preps_or_instrns_ind : "IM"
	}

		insert_Instr = pstmt_Instr.executeBatch();
		//IN64543, starts
		
		boolean isClobUpdated = true;
		
		if("E".equals(l_instrn_content_type))
		{
			ArrayList<String> queries = new ArrayList<String>();
			queries.add(SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS);
			queries.add(SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM);
			ArrayList data = new ArrayList();
			data.add(CatalogHeader.get("order_catalog_code"));
			data.add(recordPreps);
			//data.add(((ArrayList)tabData_p.get("InstructionClobTemp")).get(1));//776 tf change
			data.add(pat_preps_or_instrns_id.trim());
			//data.add(clobDataAge);//IN064543 K 
			ArrayList clobDataAgeList =(ArrayList) ((HashMap)tabData_p.get("InstructionClobTemp")).get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108
			data.add(clobDataAgeList);//ML-MMOH-SCF-1108
			data.add(recordStdIntruction);//IN064543 K 
			HashMap temp1 = (HashMap)tabData_p.get("InstructionClobTemp");//ML-MMOH-SCF-1108
			
			
			
		/*ML-MMOH-SCF-1108*/	
			
			
			if(!temp1.containsKey("pat_preps_or_instrns_free_fmt_pr")){
				if(recordPreps.containsKey("pat_preps_or_instrns_free_fmt_pr")){
					if(recordPreps.get("pat_preps_or_instrns_free_fmt_pr")!=null)
						temp1.put("pat_preps_or_instrns_free_fmt_pr", recordPreps.get("pat_preps_or_instrns_free_fmt_pr"));
					else
						temp1.put("pat_preps_or_instrns_free_fmt_pr", "");
				}
			}
			if(!temp1.containsKey("pat_preps_or_instrns_free_fmt_dr")){
				if(recordPreps.containsKey("pat_preps_or_instrns_free_fmt_dr")){
					if(recordPreps.get("pat_preps_or_instrns_free_fmt_dr")!=null)
						temp1.put("pat_preps_or_instrns_free_fmt_dr", recordPreps.get("pat_preps_or_instrns_free_fmt_dr"));
					else
						temp1.put("pat_preps_or_instrns_free_fmt_dr", "");
				}
			}
			if(!temp1.containsKey("pat_preps_or_instrns_free_fmt_is")){
				if(recordPreps.containsKey("pat_preps_or_instrns_free_fmt_is")){
					if(recordPreps.get("pat_preps_or_instrns_free_fmt_is")!=null)
						temp1.put("pat_preps_or_instrns_free_fmt_is", recordPreps.get("pat_preps_or_instrns_free_fmt_is"));
					else
						temp1.put("pat_preps_or_instrns_free_fmt_is", "");
				}
			}
			
			
		/*ML-MMOH-SCF-1108*/		
			data.add(temp1);//ML-MMOH-SCF-1108
			isClobUpdated = updateInstrn(connection, queries,data);			
		}
		//IN64543, ends

		traceVal.append("insert_Instr="+insert_Instr.length);

        pstmt_Freq_del.setString(1,((String)CatalogHeader.get("order_catalog_code")));
        pstmt_Freq_del.executeUpdate();

        int sizeFrequencies				=Frequencies.size()  ;
        for(int i = 0; i < sizeFrequencies ; i++)
		{
            tempSetting = (HashMap)Frequencies.get(i);

            pstmt_Freq.setString(1,((String)tempSetting.get("frequency_code")));
            pstmt_Freq.setString(2,((String)CatalogHeader.get("order_catalog_code")));
            pstmt_Freq.setString(3,login_by_id);
            pstmt_Freq.setString(4,login_at_ws_no);
            pstmt_Freq.setString(5,login_facility_id);
            pstmt_Freq.setString(6,login_by_id);
            pstmt_Freq.setString(7,login_at_ws_no);
            pstmt_Freq.setString(8,login_facility_id);

            if (((String)tempSetting.get("applicable_yn")).equals("Y")) 
			{
                pstmt_Freq.addBatch();
            }
			tempSetting.clear();
        }

		insert_Freq = pstmt_Freq.executeBatch();
        traceVal.append("after Freq"+insert_Freq);

//if(PrepDetail.size()>0 || DeletePrepDetail.size()>0)
		if(CatalogHeader.containsKey("order_catalog_code") && !((String)CatalogHeader.get("order_catalog_code")).equals(""))
		{

			pstmt_Prep_del.setString(1,((String)CatalogHeader.get("order_catalog_code")));
			pstmt_Prep_del.executeUpdate();

		}
        int prepSize = 0;
		if(prepRec !=null)
			prepSize = prepRec.size();

		if (prepSize > 0) 
		{
		    prepSize = Integer.parseInt((String)prepRec.get("tot_recs"));
		}

		HashMap record=new HashMap();
		/*String temp_pri_sec_tasks_type="";
		for(int k = 0;k < PrepDetail.size(); k++) {
		          record = (HashMap)PrepDetail.get(k);
				  if(record.get("pri_sec_tasks_type")!=null){
					temp_pri_sec_tasks_type=(String)record.get("pri_sec_tasks_type");
					break;
				  }
		}*/

		for (int i = 0; i < prepSize; i++) 
		{
		  if (prepRec.containsKey("patient_class"+i) && !prepRec.get("patient_class"+i).equals("")) 
		  {
		      for(int j = 0;j < PrepDetail.size(); j++) 
			  {
		          record = (HashMap)PrepDetail.get(j);

				 // if(record.get("pri_sec_tasks_type")!=null)
				//  {
				  pstmt_Prep.setString(1,((String)CatalogHeader.get("order_catalog_code")));
    		      pstmt_Prep.setString(2,((String)record.get("code")));
    		      pstmt_Prep.setString(3,((String)prepRec.get("patient_class"+i)));
    		      pstmt_Prep.setString(4,((String)record.get("sec_order_stage_stat")));
    		      pstmt_Prep.setString(5,((String)record.get("sec_order_stat_durn")));
    		      pstmt_Prep.setString(6,((String)record.get("sec_order_stat_durn_type")));
    		      pstmt_Prep.setString(7,((String)record.get("sec_order_stage_urg")));
    		      pstmt_Prep.setString(8,((String)record.get("sec_order_urg_durn")));
    		      pstmt_Prep.setString(9,((String)record.get("sec_order_urg_durn_type")));
    		      pstmt_Prep.setString(10,((String)record.get("sec_order_stage_rtn")));
    		      pstmt_Prep.setString(11,((String)record.get("sec_order_rtn_durn")));
    		      pstmt_Prep.setString(12,((String)record.get("sec_order_rtn_durn_type")));
    		      pstmt_Prep.setString(13,login_by_id);
    		      pstmt_Prep.setString(14,login_at_ws_no);
    		      pstmt_Prep.setString(15,login_facility_id);
    		      pstmt_Prep.setString(16,login_by_id);
    		      pstmt_Prep.setString(17,login_at_ws_no);
    		      pstmt_Prep.setString(18,login_facility_id);
				 //pstmt_Prep.setString(19,(temp_pri_sec_tasks_type.equals("")?((String)prepRec.get("patient_class"+i)):temp_pri_sec_tasks_type));
				  pstmt_Prep.setString(19,((String)prepRec.get("pri_sec_tasks_type"+i)));
    		      traceVal.append("Prep:"+j);
    		      pstmt_Prep.addBatch();
				 // }
				  //record.clear();
		      }
		  }
		}

		insert_Prep = pstmt_Prep.executeBatch();

		boolean insert_Int	=  false ;
//		boolean insert_Fre	=  false ;
		boolean insert_ptl	=  false ;
		boolean insert_sy	=  false ;
//		boolean insert_Pre	=  false ;
		boolean bool_insert_fac_mapping = true;//IN068370,IN068373

		 if((insert_Instr.length > 0))
		 { //check updation in INSTRN
					insert_Int= true ;
		 }
		 else if((insert_Instr.length == (-3)))
		 {
					insert_Int= false ;
		 }

/*         if((insert_Freq.length > 0)){ //check updation in Freq
					insert_Fre= true ;
		 }else if((insert_Freq.length == (-3))){
					insert_Fre= false ;
		 }

		 if((insert_Prep.length > 0)){ //check updation in PREP
					insert_Pre= true ;
		 }else if((insert_Prep.length == (-3))){
					insert_Pre= false ;
		 }
*/
		 if((insert_ptcl.length > 0))
		 { //check updation in PTCL
			insert_ptl= true ;
		 }
		 else if((insert_ptcl.length == (-3)))
		 {
			insert_ptl= false ;
		 }

		 if((insert_syn.length > 0)||(delete_syn.length > 0)||((update_syn.length > 0)))
		 { //check updation in SYN
			insert_sy= true ;
		 }
		 else //if((insert_syn.length == (-3)))
		 {
			insert_sy= false ;
		 }
		 
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

		//traceVal.append("/insert_ch="+insert_ch);
		//traceVal.append("/insert_type="+insert_type);
		traceVal.append("/insert_sy="+insert_syn.length+"/insert_Int="+insert_Instr.length+"/insert_ptl="+insert_ptcl.length+"/insert_prep="+insert_Prep.length);

		//if (update_ch > 0 && insert_sy  && insert_Int && insert_ptl)
		//if (update_ch > 0 && insert_sy  && insert_Int && insert_ptl && isClobUpdated)//IN068370,IN068373
		if (update_ch > 0 && insert_sy  && insert_Int && insert_ptl && isClobUpdated && bool_insert_fac_mapping)//IN068370,IN068373
		{   // && insert_Fre
			/*connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append("RECORD_MODIFIED") ;Modified by Uma on 8/20/2009 for PMG20089-CRF-641*/

			boolean status_flg = false;
			status_flg = executeProcedure(connection,((String)CatalogHeader.get("order_catalog_code")));
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

		}
		else
		{
			connection.rollback();
			messages.append( "Insert Failed" ) ;
		}
/*sqlMap.clear();
tabDataParam.clear();
tabData_p.clear();
CatalogHeader.clear();
Characterstics.clear();
Reviews.clear();
Frequencies.clear();
Settings.clear();
Instructions.clear();
TurnAround.clear();
Prep.clear();
PrepDetail.clear();
DeletePrepDetail.clear();
charactersticsRec.clear();
turnAroundRec.clear();
reviews.clear();
prepRec.clear();
recordOrderCatalog.clear();
recordPreps.clear();
recordStdIntruction.clear();
recordByAge.clear();*/
}catch( Exception e ){
					traceVal.append("In Exception==");
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

			try {
						connection.rollback();
						closeConnection( connection,pt);
//						closeConnection(connection);
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}
                if (e instanceof java.lang.NullPointerException || (((String)e.getMessage()).indexOf("Index: 0, Size: 0") != -1)){
                   messages.delete(0, messages.length());
                    messages.append("Cannot Update. Try Again Later...");
                }
                else
                    messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
    		  } finally{
	            	try {
						closeResultSet( rs ) ;
						closeResultSet( rs_eff ) ;
  						closeStatement( pstmt_ch ) ;
  						closeStatement( pstmt_Prep ) ;
  						closeStatement( pstmt_Prep_del ) ;
  						closeStatement( pstmt_type ) ;
  						closeStatement( pstmt_syn ) ;
  						closeStatement( pstmt_ptcl ) ;
  						closeStatement( pstmt_Instr ) ;
  						closeStatement( pstmt_Freq  ) ;
    					closeStatement( pstmt_Freq_del ) ;
  						closeStatement( pstmt_eff ) ;
  						closeStatement( pstmt_format ) ;
						closeStatement( del_pstmt_syn );
						closeStatement( update_pstmt_syn );
						//closeStatement(del_pstmt_syn);
						//closeStatement(del_pstmt_ptcl);
						//closeStatement(del_pstmt_Instr);
						closeStatement(pstmt_appl_facility);//IN068370,IN068373
						closeStatement(pstmt_del_appl_facility);//IN068370,IN068373
						closeConnection( connection,pt);
			//			closeConnection(connection);
					} catch ( Exception fe ) {
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

public HashMap delete( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;
		//tabData.clear();
		//sqlMap.clear();
		return map ;
	}

/****************************************************************************/
/**
* @ejb.interface-method
*	 view-type="both"
*/
/*Added by Uma on 8/18/2009 for PMG20089-641 to post the catalog to privilege*/
	private boolean executeProcedure(Connection connection,String catalog_code) throws Exception
	{
		String p_error_message = "";
		CallableStatement cstmt 	= null;
		try{

			cstmt			= connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_POST_CATALOG_PRIV_REC")+" }");
			cstmt.setString(1, catalog_code);						 // P_CATALOG_CODE
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
	
	//IN64543, starts
	private void updateClobData(String query, Connection con, ArrayList<String> params, String sourceContent) throws Exception
	{
		PreparedStatement	pstUpdClob		=	null;
		ResultSet rsUpdClob = null;
		java.sql.Clob clob_notes_section_content	=	null;
		java.io.BufferedWriter	bf_section_content_writer	=	null;
		String type = "";//IN064543 K 
		int index = 0;
		int paramIndex = 0;		
		
		try
		{			
			pstUpdClob		=	con.prepareStatement(query);
			pstUpdClob.setString	(++index,	params.get(paramIndex));
			type = params.get(++paramIndex);
			pstUpdClob.setString(++index, type);
			
			if("IM".equals(type))
			{
				pstUpdClob.setLong(++index, Long.parseLong(params.get(++paramIndex)));			
				pstUpdClob.setLong(++index, Long.parseLong(params.get(++paramIndex)));
				pstUpdClob.setString(++index, params.get(++paramIndex));				
			}
			
			rsUpdClob = pstUpdClob.executeQuery();
	
			if(rsUpdClob.next())
			{						
				clob_notes_section_content	=	(java.sql.Clob) rsUpdClob.getClob("PAT_PREPS_OR_INSTRNS_FREE_FMT");
				bf_section_content_writer = new java.io.BufferedWriter(clob_notes_section_content.setCharacterStream(0));
				bf_section_content_writer.write(sourceContent,0,sourceContent.length());
				bf_section_content_writer.flush();
				bf_section_content_writer.close();
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{			
			try 
			{
				closeResultSet( rsUpdClob ) ;
				closeStatement( pstUpdClob ) ;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}	
		}
	}
	
	private boolean updateInstrn(Connection connection,
			ArrayList<String> queries, ArrayList data) {
		boolean proceed = false;
		String order_catalog_code = (String) data.get(0);
		HashMap recordPreps = (HashMap) data.get(1);
		String pat_preps_or_instrns_id = (String)data.get(2);
		Object recordObj = data.get(3);
		//HashMap recordStdIntruction = (HashMap)data.get(4);//IN064543 K  //Checkstyle
		HashMap tempRecordPreps = (HashMap) data.get(5);//ML-MMOH-SCF-1108
		ArrayList<String> params = new ArrayList<String>();

		try 
		{
			params.add(order_catalog_code);
			params.add((String) recordPreps.get("pat_preps_or_instrns_id_pr"));
			//ML-MMOH-SCF-1108 start
			/*updateClobData(queries.get(0), connection, params,
					(String) recordPreps.get("pat_preps_or_instrns_free_fmt_pr"));*/
			if(tempRecordPreps.containsKey("pat_preps_or_instrns_free_fmt_pr"))
			updateClobData(queries.get(0), connection, params,
					(String) tempRecordPreps.get("pat_preps_or_instrns_free_fmt_pr"));
			


			params.clear();
			params.add(order_catalog_code);
			params.add((String) recordPreps.get("pat_preps_or_instrns_id_dr"));
			//ML-MMOH-SCF-1108 
			/*updateClobData(queries.get(0), connection, params,
					(String) recordPreps.get("pat_preps_or_instrns_free_fmt_dr"));*/
			if(tempRecordPreps.containsKey("pat_preps_or_instrns_free_fmt_dr"))
			updateClobData(queries.get(0), connection, params,
					(String) tempRecordPreps.get("pat_preps_or_instrns_free_fmt_dr"));
			
			

			if (pat_preps_or_instrns_id.trim().equals("IS")) {// By standards
				params.clear();
				params.add(order_catalog_code);
				params.add("IS");
				
			
				//if(recordStdIntruction!=null && recordStdIntruction.size()>0)//IN064543 K 
				/*updateClobData(queries.get(0), connection, params,
						(String) recordStdIntruction.get("pat_preps_or_instrns_free_fmt_is"));*///IN064543 K
				if(tempRecordPreps.containsKey("pat_preps_or_instrns_free_fmt_is"))	
				updateClobData(queries.get(0), connection, params,
							(String) tempRecordPreps.get("pat_preps_or_instrns_free_fmt_is"));
			} else if (pat_preps_or_instrns_id.trim().equals("IM")) {

				// Object recordObj = recordByAge.get("records") ;
				ArrayList records = null;
				HashMap currRec = new HashMap();

				if (recordObj == null)
					records = new ArrayList();
				else
					records = (ArrayList) recordObj;

				int recsize = records.size();

				if (recsize != 0) {
					for (int j = 0; j < recsize; j++) {
						currRec = (HashMap) records.get(j);

						String min_age_in_days = (String) currRec
								.get("min_age_in_days");
						String min_age_in_mths = (String) currRec
								.get("min_age_in_mths");
						String min_age_in_yrs = (String) currRec
								.get("min_age_in_yrs");
						String max_age_in_days = (String) currRec
								.get("max_age_in_days");
						String max_age_in_mths = (String) currRec
								.get("max_age_in_mths");
						String max_age_in_yrs = (String) currRec
								.get("max_age_in_yrs");
						String sex_spec_ind = (String) currRec
								.get("sex_spec_ind");

						long currMinTotal = getDaysEJB(
								Long.parseLong(min_age_in_yrs),
								Integer.parseInt(min_age_in_mths),
								Long.parseLong(min_age_in_days));
						long currMaxTotal = getDaysEJB(
								Long.parseLong(max_age_in_yrs),
								Integer.parseInt(max_age_in_mths),
								Long.parseLong(max_age_in_days));
						
						params.clear();
						params.add(order_catalog_code);
						params.add("IM");
						params.add(Long.toString(currMinTotal));
						params.add(Long.toString(currMaxTotal));
						params.add(sex_spec_ind);
						updateClobData(queries.get(1),connection, params,(String)((HashMap)((ArrayList)recordObj).get(j)).get("pat_preps_or_instrns_free_fmt_im"));//IN064543 K 
						//currRec.clear();	
					}
				}
			}
			proceed = true;
		} catch (Exception e) {
			proceed = false;
			e.printStackTrace();
		}
		return proceed;
	}
	//IN64543, ends
}