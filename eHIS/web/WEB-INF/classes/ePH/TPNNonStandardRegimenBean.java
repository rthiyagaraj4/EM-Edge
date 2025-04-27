/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import oracle.sql.*;
import java.io.*;
//import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import eOR.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
//saved on 22/10/2005
public class TPNNonStandardRegimenBean extends PhAdapter implements Serializable, eOR.SceduleFreqeuncyInterface {


	private HashMap regimenRemarks	= new HashMap();
	private String presRemarks="";

	private HashMap scheduleFrequency	= new HashMap();

	private ArrayList GroupCodes	=new ArrayList();
	private ArrayList GroupDescs	=new ArrayList();
	
	private HashMap Generics		=new HashMap();
	private HashMap Groups			=new HashMap();

	private ArrayList regdet			=new ArrayList();
	private HashMap AdminDetails	 = new HashMap(); //used for storing admin details while amending
	private HashMap OverriddenReason	= new HashMap();

	private String StockUOM		    = "";
	//private String dflt_disp_locn	= "";
	String ageGroup				    = "";
	String ncp_n_val                = "";
	String order_id                 = "";


	private Hashtable recordSet		= new Hashtable();
	private HashMap   schdMap		= new HashMap();
	
	public TPNNonStandardRegimenBean() 
	{
		//Constructor
		try 
		{
			doCommon() ;
		}
		catch(Exception e) {System.err.println( "Error loading " ) ;
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception 
	{
	}
	public void setRegimenRemarks(HashMap tmp)
	{
		
			this.regimenRemarks=tmp;
	}
	public void setNcpVal(String ncp_n_val){
		this.ncp_n_val=ncp_n_val;
	}
	public HashMap getRegimenRemarks()
	{
			return this.regimenRemarks;
	}
	public void setPresRemarks(String remarks)
	{
			this.presRemarks=remarks;
	}

	public String getPresRemarks()
	{
		return this.presRemarks;
	}

	/*public void setDispCode(String dflt_disp_locn)
	{
			this.dflt_disp_locn=dflt_disp_locn;
	}

	public String getDispCode()
	{
		return this.dflt_disp_locn;
	}*/

	



	public void setOverriddenRemarks(String group,String row_no,String remarks)
	{
			OverriddenReason.put(group+"$"+row_no,remarks);
	}
	public String getOverriddenReason(String group,String row_no)
	{
		return ((String)OverriddenReason.get(group+"$"+row_no));
	}
	public HashMap getAdminDetails(){
		return this.AdminDetails;
	}
	public void clear(){
		super.clear() ;

		Generics=new HashMap();
		GroupCodes=new ArrayList();
		GroupDescs=new ArrayList();
		Groups			=new HashMap();
		regdet			=new ArrayList();
		scheduleFrequency	= new HashMap();
		regimenRemarks	= new HashMap();
		AdminDetails= new HashMap();
		OverriddenReason = new HashMap();
		recordSet = new Hashtable();
		schdMap		= new HashMap();

		presRemarks="";
		StockUOM="";
		ncp_n_val="";
		order_id="";
		ageGroup="";
	}

	/* Over-ridden Adapter methods endS here */

	public void  setScheduleDates(HashMap schdMap)
	{
		this.schdMap = schdMap;	
	}

	public HashMap getScheduleDates()
	{
		return this.schdMap;
	}

	public String getLoggedInFacility()  
	{
		return login_facility_id;
	}


	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
public ArrayList getStoredGroups()  
{
	return GroupCodes;
}
public String getDesc(String groupcode)
{
		return (String)Groups.get(groupcode);
}
public HashMap getGenerics()  
{
	return Generics;
}
public ArrayList getStoredGroupDescs()  
{
	return GroupDescs;
}

public ArrayList getRegimenDetails()
{
	return this.regdet;
}

public void addGenerics(String key,ArrayList value)
{
	Generics.put(key,value);

}

public ArrayList  getTPNGroups(String patientid,String regimen_code)
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt1 = null ;
		ResultSet resultSet = null ;
		ResultSet resultSet1 = null ;
//		ResultSet resultSet2 = null ;
		String lnk = "";
		ArrayList result=new ArrayList();
		ArrayList result1=new ArrayList();
		try {
			connection = getConnection() ;
			
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT4" )) ;
			pstmt = connection.prepareStatement("SELECT    B.CONST_GROUP_NAME,B.CONST_GROUP_CODE   FROM     PH_TPN_CONSTITUENT_GROUP B WHERE   B.CONST_GROUP_CODE <> 'FL' ") ;
			//pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT24" )) ;
			pstmt1 = connection.prepareStatement("SELECT DISTINCT CONST_GROUP_CODE FROM PH_TPN_CONST_GENERIC_NAME WHERE CONST_GENERIC_CODE  IN(SELECT CONST_GENERIC_CODE FROM PH_TPN_CONSTITUENT_LIMIT WHERE AGE_GROUP_CODE =(SELECT AGE_GROUP_CODE FROM AM_AGE_GROUP WHERE ( SELECT   CASE  WHEN INSTR(GET_AGE(DATE_OF_BIRTH),'Y')>0    THEN Ph_Pkg_Common.Ph_Getsubstrbtwndelim(GET_AGE(DATE_OF_BIRTH),'Y',1) WHEN INSTR(GET_AGE(DATE_OF_BIRTH),'M')>0 THEN    Ph_Pkg_Common.Ph_Getsubstrbtwndelim(GET_AGE(DATE_OF_BIRTH),'M',1) WHEN INSTR            (GET_AGE (DATE_OF_BIRTH),'D') > 0  THEN ph_pkg_common.ph_getsubstrbtwndelim              (GET_AGE (DATE_OF_BIRTH),'D',1) END  AGE FROM MP_PATIENT WHERE PATIENT_ID =? )BETWEEN MIN_AGE AND MAX_AGE  AND (GENDER<>DECODE((SELECT sex  FROM mp_patient WHERE     patient_id=?),'M','F','F','M','U','*') OR gender IS NULL)   AND age_group_code IN(SELECT age_group_code FROM PH_TPN_CONSTITUENT_LIMIT) AND ROWNUM<2))") ;
			pstmt1.setString(1,patientid);
			pstmt1.setString(2,patientid);
			//pstmt1.setString(3,patientid);
			//pstmt1.setString(4,patientid);
			resultSet = pstmt.executeQuery() ;
			resultSet1 = pstmt1.executeQuery() ;
			while(resultSet1.next()){
					result1.add(resultSet1.getString("CONST_GROUP_CODE"));
			}
		
			while (resultSet.next()) {
				lnk="N";
				for (int i=0;i<result1.size();i++)
			{		

					if(resultSet.getString("CONST_GROUP_CODE").equals((String)(result1.get(i)))){
						lnk="Y";
						break;
					}
									
				}
				String groupcode=resultSet.getString("CONST_GROUP_CODE")==null?"":resultSet.getString("CONST_GROUP_CODE");
				String groupdesc=	resultSet.getString("CONST_GROUP_NAME")==null?"":resultSet.getString("CONST_GROUP_NAME");
				result.add(groupcode);
				result.add(groupdesc);
				result.add(lnk);
		
				GroupCodes.add(groupcode);
				GroupDescs.add(groupdesc);
				Groups.put(groupcode,groupdesc);
			
			}
			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null)		closeStatement( pstmt ) ;

		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   System.err.println( "Error loading values from database1" ) ;
			}
		
		}
		  // System.err.println("result-------213--->"+result);
		return result;


}


public HashMap  getOrderDetails(String orderid)
{

		Connection connection = null ;
		PreparedStatement pstmt = null,pstmt1=null,pstmt2=null ;
		ResultSet resultSet = null ,resultSet1=null,resultSet2=null;
		HashMap result=new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT20" )) ;
			pstmt.setString(1,orderid);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {

				String isscheduled=resultSet.getString("ISSCHEDULED")==null?"":resultSet.getString("ISSCHEDULED");
				AdminDetails.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CATALOG_CODE")==null?"":resultSet.getString("ORDER_CATALOG_CODE"));
				AdminDetails.put("START_DATE_TIME",resultSet.getString("START_DATE_TIME")==null?"":resultSet.getString("START_DATE_TIME"));
				AdminDetails.put("END_DATE_TIME",resultSet.getString("END_DATE_TIME")==null?"":resultSet.getString("END_DATE_TIME"));
				AdminDetails.put("FREQ_CODE",resultSet.getString("FREQ_CODE")==null?"":resultSet.getString("FREQ_CODE"));
				AdminDetails.put("FREQ_NATURE",resultSet.getString("FREQ_NATURE")==null?"":resultSet.getString("FREQ_NATURE"));
				AdminDetails.put("DURN_VALUE",resultSet.getString("DURN_VALUE")==null?"":resultSet.getString("DURN_VALUE"));
				AdminDetails.put("DURN_TYPE",resultSet.getString("DURN_TYPE")==null?"":resultSet.getString("DURN_TYPE"));
				AdminDetails.put("INFUSE_OVER",resultSet.getString("INFUSE_OVER")==null?"":resultSet.getString("INFUSE_OVER"));
				AdminDetails.put("INFUSE_OVER_UNIT",resultSet.getString("INFUSE_OVER_UNIT")==null?"":resultSet.getString("INFUSE_OVER_UNIT"));
				AdminDetails.put("ISSCHEDULED",isscheduled);
				AdminDetails.put("LONG_NAME",resultSet.getString("LONG_NAME")==null?"":resultSet.getString("LONG_NAME"));
				AdminDetails.put("TOTAL_VOLUME",resultSet.getString("TOTAL_VOLUME")==null?"":resultSet.getString("TOTAL_VOLUME"));
				AdminDetails.put("PRES_BASE_UNIT",resultSet.getString("PRES_BASE_UNIT")==null?"":resultSet.getString("PRES_BASE_UNIT"));
				
				result.put("TPN_ADMIN_ROUTE",resultSet.getString("TPN_ADMIN_ROUTE")==null?"":resultSet.getString("TPN_ADMIN_ROUTE"));
				//Added for ML-MMOH-CRF-1012 amend mode start
				result.put("TOTAL_DAILY_FLUID",resultSet.getString("TOTAL_DAILY_FLUID")==null?"":resultSet.getString("TOTAL_DAILY_FLUID"));	
				result.put("ENTERAL_FEEDING",resultSet.getString("ENTERAL_FEEDING")==null?"":resultSet.getString("ENTERAL_FEEDING"));
				//Added for ML-MMOH-CRF-1012 amend mode end
				if (!isscheduled.equals("0"))
				{
					//get scheduled time and put it in an array list and send it back
					ArrayList schtime=new ArrayList();
					pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT23" )) ;
					pstmt1.setString(1,orderid);
					resultSet1 = pstmt1.executeQuery() ;
					while (resultSet1.next())
					{
						schtime.add(resultSet1.getString("ORDER_LINE_FIELD_VALUE"));
						schtime.add(resultSet1.getString("DOSE"));
					} 
				AdminDetails.put("SCH_TIME",schtime);					
				}
				// Now that we hae stored all admin details, tpn details have to be got  from the db and returned to the page
				

				
			pstmt2= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_NON_STD_REGIMEN_SELECT2" )) ;
			pstmt2.setString(1,orderid);
			resultSet2 = pstmt2.executeQuery() ;
			HashMap MNList=new HashMap();
			HashMap ELList=new HashMap();
			HashMap OTList=new HashMap();
			HashMap TRList=new HashMap();
			HashMap VTList=new HashMap();

			while (resultSet2.next())
			{
				//A.CONST_GENERIC_CODE, B.CONST_GROUP_CODE,CONST_QTY, CONST_QTY_UNIT 
				String cgencode		=resultSet2.getString("CONST_GENERIC_CODE"); 
				String cgroupcode	=resultSet2.getString("CONST_GROUP_CODE");
				String cqty			=resultSet2.getString("CONST_QTY");
//				String cqtyunit		=resultSet2.getString("CONST_QTY_UNIT");

             
			   if (cgroupcode.equals("MN"))
			   {
				   MNList.put(cgencode,cqty);

			   }
			   else if (cgroupcode.equals("EL"))
				{
				   ELList.put(cgencode,cqty);

				}
				else if (cgroupcode.equals("OT"))
				{
				   OTList.put(cgencode,cqty);

				}
				else if (cgroupcode.equals("TR"))
				{
				   TRList.put(cgencode,cqty);

				}
				else if (cgroupcode.equals("VT"))
				{
				   VTList.put(cgencode,cqty);

				}
				
			}

			if(resultSet2!=null) closeResultSet( resultSet2 ) ;
			if(pstmt2!=null) closeStatement( pstmt2 ) ;

			result.put("MN",MNList);
			result.put("VT",VTList);
			result.put("TR",TRList);
			result.put("OT",OTList);
			result.put("EL",ELList);
				
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			AdminDetails.put("ERROR",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   System.err.println( "Error loading values from database1" ) ;
			}
		
		}
		return result;

}





public String  getRegimenName(String orderdate,String regimencode,String patient_id) 
{
		Connection connection		= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet				= null ;
		String  result						= "";
		if(regimencode==null)
			regimencode="";
		//String param  ="";
		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			//System.out.println("in bean"+orderdate+regimencode+pediatric_regimen_yn+patient_id);
	        
		//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_NON_STD_REGIMEN_SELECT1A" )) ;
			pstmt = connection.prepareStatement("SELECT   TPN_REGIMEN_CODE,   DFLT_TPN_ROUTE,   TOTAL_VOLUME,   SHORT_NAME,   b.QTY_UOM PRES_BASE_UNIT,   ITEM_CODE,   INFUSE_OVERDURN_TYPE,   INFUSE_OVER_VALUE,   B.ORDER_TYPE_CODE,   CONSENT_REQD_YN,   ORD_AUTH_REQD_YN,   ORD_COSIGN_REQD_YN,   ORD_SPL_APPR_REQD_YN,   FREQ_CODE,   DURN_VALUE,   DURN_TYPE,   CHK_FOR_MAX_DURN_ACTION,   PROMPT_MSG,   MAX_DURN_VALUE,   TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')+NVL(durn_value,0),'DD/MM/YYYY HH24:MI') ENDDATE FROM     PH_TPN_REGIMEN A,  OR_ORDER_CATALOG B,   OR_ORDER_CATALOG_BY_PTCL C WHERE    STANDARD_REGIMEN_YN='N' AND   A.TPN_REGIMEN_CODE=B.ORDER_CATALOG_CODE AND   B.ORDER_CATALOG_CODE=C.ORDER_CATALOG_CODE AND A.TPN_REGIMEN_CODE = NVL(?,'NON_STANDARD') and  exists (select 'Y' from PH_TPN_CONSTITUENT_LIMIT where TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE and age_group_code in (select age_group_code from am_age_group where nvl(gender,(select sex from mp_patient where patient_id = ?))=(select sex from mp_patient where patient_id = ?)  and trunc(sysdate)-(select trunc(date_of_birth) from mp_patient where patient_id = ?) between  decode(age_unit,'Y',365,'M',30,1)*min_age and decode(age_unit,'Y',365,'M',30,1)*max_age and eff_status='E' )) ");

			pstmt.setString(1,orderdate);
			pstmt.setString(2,regimencode);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,patient_id);
			//System.out.println("regimen code in bean"+regimencode);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				regdet.add(resultSet.getString("TPN_REGIMEN_CODE")==null?"":resultSet.getString("TPN_REGIMEN_CODE"));
				regdet.add(resultSet.getString("DFLT_TPN_ROUTE")==null?"C":resultSet.getString("DFLT_TPN_ROUTE"));
				regdet.add(resultSet.getString("TOTAL_VOLUME")==null?"":resultSet.getString("TOTAL_VOLUME"));
				result=resultSet.getString("SHORT_NAME")==null?"":resultSet.getString("SHORT_NAME");
				regdet.add(result);
				regdet.add(resultSet.getString("PRES_BASE_UNIT")==null?"":resultSet.getString("PRES_BASE_UNIT"));
				regdet.add(resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE"));
				regdet.add(resultSet.getString("INFUSE_OVERDURN_TYPE")==null?"H":resultSet.getString("INFUSE_OVERDURN_TYPE"));
				regdet.add(resultSet.getString("INFUSE_OVER_VALUE")==null?"":resultSet.getString("INFUSE_OVER_VALUE"));
				regdet.add(resultSet.getString("ORDER_TYPE_CODE")==null?"":resultSet.getString("ORDER_TYPE_CODE"));
				regdet.add(resultSet.getString("CONSENT_REQD_YN")==null?"N":resultSet.getString("CONSENT_REQD_YN"));
				regdet.add(resultSet.getString("ORD_AUTH_REQD_YN")==null?"N":resultSet.getString("ORD_AUTH_REQD_YN"));
				regdet.add(resultSet.getString("ORD_COSIGN_REQD_YN")==null?"N":resultSet.getString("ORD_COSIGN_REQD_YN"));
				regdet.add(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null?"N":resultSet.getString("ORD_SPL_APPR_REQD_YN"));
				regdet.add(resultSet.getString("FREQ_CODE")==null?"":resultSet.getString("FREQ_CODE"));
				regdet.add(resultSet.getString("DURN_VALUE")==null?"":resultSet.getString("DURN_VALUE"));
				regdet.add(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null?"":resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
				regdet.add(resultSet.getString("PROMPT_MSG")==null?"":resultSet.getString("PROMPT_MSG"));
				regdet.add(resultSet.getString("MAX_DURN_VALUE")==null?"":resultSet.getString("MAX_DURN_VALUE"));
				regdet.add(resultSet.getString("ENDDATE")==null?"":resultSet.getString("ENDDATE"));

				}
				
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   System.err.println( "Error loading values from database1" ) ;
			}
		
		}
		return result;

}

private void getAgeGroup(String patientid,String regimen_code)
{
Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			//this query retrieves generic ids and limits set for the age group
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT5" )) ;
			pstmt = connection.prepareStatement("SELECT AGE_GROUP_CODE FROM AM_AGE_GROUP WHERE ( SELECT   CASE  WHEN INSTR(GET_AGE(DATE_OF_BIRTH),'Y')>0    THEN    Ph_Pkg_Common.Ph_Getsubstrbtwndelim(GET_AGE(DATE_OF_BIRTH),'Y',1)   WHEN INSTR(GET_AGE(DATE_OF_BIRTH),'M')>0 THEN    Ph_Pkg_Common.Ph_Getsubstrbtwndelim   (GET_AGE(DATE_OF_BIRTH),'M',1) WHEN INSTR(GET_AGE(DATE_OF_BIRTH),'D')>0 THEN    Ph_Pkg_Common.Ph_Getsubstrbtwndelim   (GET_AGE(DATE_OF_BIRTH),'D',1) END  AGE FROM MP_PATIENT WHERE PATIENT_ID =? )    BETWEEN MIN_AGE AND MAX_AGE  AND (GENDER<>DECODE((SELECT sex  FROM mp_patient WHERE     patient_id=?),'M','F','F','M','U','*') OR gender IS NULL)   AND age_group_code IN  (SELECT age_group_code FROM PH_TPN_CONSTITUENT_LIMIT) AND ROWNUM<2 ") ;
			pstmt.setString(1,patientid);
			pstmt.setString(2,patientid);
			//pstmt.setString(3,patientid);
			//pstmt.setString(4,regimen_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				ageGroup=resultSet.getString("AGE_GROUP_CODE")==null?"":resultSet.getString("AGE_GROUP_CODE");
			}
			//System.out.println("ageGroup----in bean-- 457->"  +ageGroup);
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {  System.err.println( "Error loading values from database1" ) ; 
			}
		
		}
	

}
public ArrayList  getTPNGenerics(String groupCode,String patientid,String regimen_code)
{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			getAgeGroup(patientid,regimen_code);
           	connection = getConnection() ;
			//this query retrieves generic ids and limits set for the age group
			//System.out.println("Inside getTPNGenerics-----------488-----in bean---->");
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT3A" )) ;
			pstmt = connection.prepareStatement("SELECT   c.const_generic_code, c.const_generic_name, c.dflt_during_order_yn,(SELECT ORD_UNIT_IND FROM ph_tpn_constituent_limit WHERE tpn_regimen_code = ? and age_group_code = ? AND const_generic_code = c.const_generic_code) w_or_a, (SELECT uom_code || '!' || short_desc FROM am_uom WHERE uom_code = (SELECT a.ORDERING_UNIT FROM ph_tpn_param_for_const a WHERE a.group_or_individual_ind = c.uom_setup_level_ind and a.srl_no=c.disp_srl_no AND a.const_group_code = ? AND ROWNUM < 2) )const_qty_unit,(SELECT const_min_val FROM ph_tpn_constituent_limit WHERE tpn_regimen_code = ? and age_group_code = ? AND const_generic_code = c.const_generic_code) const_min_val,(SELECT const_max_val FROM ph_tpn_constituent_limit WHERE tpn_regimen_code = ? and age_group_code = ? AND const_generic_code = c.const_generic_code) const_max_val,(SELECT const_std_val FROM ph_tpn_constituent_limit WHERE tpn_regimen_code = ? and age_group_code = ? AND const_generic_code = c.const_generic_code) const_std_val,(SELECT const_ceil_val FROM ph_tpn_constituent_limit WHERE tpn_regimen_code = ? and age_group_code = ? AND const_generic_code = c.const_generic_code) const_ceil_val,(SELECT const_usage_ind FROM ph_tpn_constituent_limit WHERE tpn_regimen_code = ? and age_group_code = ? AND const_generic_code = c.const_generic_code) const_usage_ind, (SELECT const_remarks FROM ph_tpn_constituent_limit WHERE tpn_regimen_code = ? and age_group_code = ? AND const_generic_code = c.const_generic_code) const_remarks  FROM ph_tpn_const_generic_name c WHERE c.const_group_code = ? ORDER BY c.disp_srl_no, c.const_generic_name");
			pstmt.setString(1,regimen_code);
			pstmt.setString(2,ageGroup);
			pstmt.setString(3,groupCode);
			pstmt.setString(4,regimen_code);
			pstmt.setString(5,ageGroup);
			pstmt.setString(6,regimen_code);
			pstmt.setString(7,ageGroup);
			pstmt.setString(8,regimen_code);
			pstmt.setString(9,ageGroup);
			pstmt.setString(10,regimen_code);
			pstmt.setString(11,ageGroup);
			pstmt.setString(12,regimen_code);
			pstmt.setString(13,ageGroup);
			pstmt.setString(14,regimen_code);
			pstmt.setString(15,ageGroup);
			pstmt.setString(16,groupCode);
			/*System.out.println("regimen_code----in bean---->" +regimen_code);
			System.out.println("ageGroup----in bean---->" +ageGroup);
			System.out.println("groupCode----in bean---->" +groupCode);*/
			
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				if (resultSet.getString("CONST_MAX_VAL")!=null && resultSet.getString("CONST_MIN_VAL")!=null && resultSet.getString("CONST_STD_VAL")!=null){
				result.add(resultSet.getString("CONST_GENERIC_CODE")==null?"":resultSet.getString("CONST_GENERIC_CODE"));
				result.add(resultSet.getString("CONST_GENERIC_NAME")==null?"":resultSet.getString("CONST_GENERIC_NAME"));
				result.add(resultSet.getString("CONST_QTY_UNIT")==null?"":resultSet.getString("CONST_QTY_UNIT"));
				result.add(resultSet.getString("w_or_a")==null?"":resultSet.getString("w_or_a"));

				result.add(resultSet.getString("CONST_MAX_VAL")==null?"":resultSet.getString("CONST_MAX_VAL"));
				result.add(resultSet.getString("CONST_MIN_VAL")==null?"":resultSet.getString("CONST_MIN_VAL"));
				result.add(resultSet.getString("CONST_STD_VAL")==null?"":resultSet.getString("CONST_STD_VAL"));	
				result.add(resultSet.getString("DFLT_DURING_ORDER_YN")==null?"N":resultSet.getString("DFLT_DURING_ORDER_YN"));
				result.add(resultSet.getString("CONST_CEIL_VAL")==null?"":resultSet.getString("CONST_CEIL_VAL"));
				result.add(resultSet.getString("CONST_USAGE_IND")==null?"":resultSet.getString("CONST_USAGE_IND"));
				result.add(resultSet.getString("CONST_REMARKS")==null?"":resultSet.getString("CONST_REMARKS"));
				//System.out.println("result in bean!!!!!!!"+result);
				}
				
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {  System.err.println( "Error loading values from database1" ) ; 
			}
		
		}
		
		return result;

}

/* These two methods are for the scheduled frequency lookup */
public boolean setScheduleFrequencyStr(Hashtable ht) {
		try {
			String code 								= (String)ht.get("code");
			String duration_type 						= (String)ht.get("durationType");
			int repeat									= Integer.parseInt((String)ht.get("repeat"));
			String row_value							= (String)ht.get("row_value");
			scheduleFrequency							= new HashMap();
			ArrayList scheduleFrequencyDatas	= new ArrayList();

			for(int j=1; j <= repeat; j++) {
				HashMap hashMap	= new HashMap();
				hashMap.put("admin_day_or_time","H");
				hashMap.put("duration_type",duration_type);
				hashMap.put("start_time_assign","");
				hashMap.put("repeat",String.valueOf(repeat));
				hashMap.put("row_value",row_value);
				hashMap.put("admin_time",(String)ht.get("time"+j));
				hashMap.put("admin_qty",(String)ht.get("qty"+j));
				scheduleFrequencyDatas.add(hashMap);
			}
			scheduleFrequency.put(code,scheduleFrequencyDatas);
			return true;
		}
		catch(Exception e) {
			System.err.println("Error when setting schedule");
			return false;
		}
	}

	public ArrayList getScheduleFrequencyStr(String code, String row_value) {
		Object scheduleFrequencyDatasObj = scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
			return (ArrayList)scheduleFrequencyDatasObj;
	}

public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		this.recordSet = recordSet;
	}
public String getEndDate(String sdate,String duration)
{
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String result				="";

		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT9" )) ;
			pstmt.setString(1,sdate);
			pstmt.setString(2,duration);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result=resultSet.getString("ENDDATE");
			}
		}
	catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
					es.printStackTrace();
			}

		}
		return result;


}
public String getOrderID(){
	return this.order_id;
}
public String setOrderID(String patientClass) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String order_id			= null;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37"));
			pstmt.setString(1, "PH");
			pstmt.setString(2, patientClass);
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				order_id	 = resultSet.getString("order_id");
			}
			this.order_id=order_id;
		}
		catch(Exception e) {
			System.err.println("Error @ generating Order ID : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ generating Order ID : " + es);}
		}
		return order_id;
	}

public String getFormatId(String order_category,String order_type_code,String order_catalog_code) 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String format_id		=	"";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT16"));
			pstmt.setString(1, order_category);
			pstmt.setString(2, order_type_code);
			pstmt.setString(3, order_catalog_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				format_id	=	resultSet.getString("FORMAT_ID");
			}
		}
		catch(Exception e) {
			format_id = e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ : " + es);}
		}
		return format_id;
	}
public  int calculateQty(String freqCode,int volume,int duration,String regcode)
{
	int qtyvalue=0;
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;
	String rptValue="";
	String intValue="";
	
	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT10"));
			pstmt.setString(1, freqCode);
			resultSet	= pstmt.executeQuery();
			
			if(resultSet.next() && resultSet!=null) {
		
				rptValue = resultSet.getString("REPEAT_VALUE")== null?"":resultSet.getString("REPEAT_VALUE");
				intValue	 = resultSet.getString("INTERVAL_VALUE")== null?"":resultSet.getString("INTERVAL_VALUE");
				//rptValue = resultSet.getString("REPEAT_VALUE");
				//intValue	 = resultSet.getString("INTERVAL_VALUE");
			}
			if(rptValue.equals("") || rptValue.equals("0") || rptValue== null )	{
				rptValue	=	"1";
			}

			if(intValue.equals("") || intValue.equals("0") || intValue== null )	{
				intValue	=	"1";
			}

		


			//Now find the stock uom and insert
			qtyvalue=duration*volume*(Integer.parseInt(rptValue));
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT19"));
			pstmt.setString(1, qtyvalue+"");
			pstmt.setString(2, regcode);
			resultSet	= pstmt.executeQuery();

			if(resultSet.next()) {
				String tmp				= resultSet.getString("STOCK_QTY");
				if (tmp!=null && !tmp.equals(""))
				{
					qtyvalue			= Integer.parseInt(tmp);
				}
				this.StockUOM		= resultSet.getString("STOCK_UOM");
			}
						
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving frequency for qty calculations : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving frequency for qty calculations : " + es);}
		}
		return qtyvalue;
}

public String getTradeCode(String regcode)
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="";

		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT12" )) ;
			pstmt.setString(1,regcode);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result=resultSet.getString("TRADE_ID");
				
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
							es.printStackTrace();
			}

		}
		return result;

}
/* -- Function  getDispenseLocation commented for SRR20056-SCF-7783	ICN 28195
public  ArrayList getDispenseLocation(String facility,String locationtype,String locationcode,String takehome,String priority)
{
	ArrayList result=new ArrayList();
	Connection connection	= null;
    CallableStatement cstmt	= null;
    ResultSet resultSet		= null;
	
	try {
			connection	= getConnection();
			cstmt = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
			cstmt.setString(1, facility);
			cstmt.setString(2, locationtype);
			cstmt.setString(3, locationcode);
			cstmt.setString(4, takehome);
			cstmt.setString(5, priority);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.execute();

			String perf_locn_code	= cstmt.getString(6);
			String perf_locn_type	= cstmt.getString(7);

			result.add(perf_locn_code);
			result.add(perf_locn_type);
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving dispense location : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {			
				System.err.println("Error @ retrieving dispense location : " + es);
			}
		}
		return result;
	}
*/
public  String getOrderStatus(String authreqd,String cosignreqd,String appreqd,String authorized,String approved,String cosigned)
{
	String order_status				="";
	Connection connection			= null;
    PreparedStatement pstmt			= null;
    ResultSet resultSet				= null;

	/* Calculation of Order Status starts here*/
	String init_auth_reqd_yn		=authreqd;
	String init_spl_appr_reqd_yn	=appreqd;
	String init_cosign_reqd_yn		=cosignreqd;

	
	String ord_auth_reqd_yn			=authorized;
	String ord_appr_reqd_yn			=approved;
	String ord_cosign_reqd_yn		=cosigned;

	if( (init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N")) )
	{
			order_status="10";
	}
	else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y")))
	{
			if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")))
					order_status	=	"10";
			else
					order_status	=	"00";
	}
	else if ((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N"))) 
	{
			if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))		
					order_status	=	"10";
				else
					order_status	=	"05";
	}
	else if ((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N"))) 
	{
				if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
					order_status	=	"10";
				else
					order_status="03";
	}
	else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N")))
	{
				if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) )
				{		
					order_status="10";
				}
				else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
				{		
					order_status="05";
				}
				else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
				{		
					order_status="03";
				} 
				else
				{
					order_status="03";
				}
	}
	else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y")))
	{
				if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) )
				{
					order_status="10";
				}
				else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")))
				{
					order_status="03";
				}
				else if((ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) )
				{
					order_status="00";
				}
				else 
				{
					order_status="00";
				}
	}
	else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y")))
	{
				if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) )
				{
					order_status="10";
				}
				else 
				{
					order_status="05";
				}
	}
	else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y"))) 
	{
				if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y"))) 
				{
					order_status	=	"10";
				}
				else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) ) 
				{
					order_status	=	"03";
				}
				else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) 
				{
					order_status	=	"05";
				}
				else if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) 
				{
					order_status	=	"10";
				}
				else 
				{	
					order_status	=	"03";
				}

	}
	if(order_status.equals("")){order_status="10";}

/*Order Status Calculation ends here*/

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT13"));
			pstmt.setString(1,order_status);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				order_status = resultSet.getString("ORDER_STATUS_CODE");
			}

		}
		catch(Exception e) {
			System.err.println("Error @ retrieving order status : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving order status : " + es);}
		}
		return order_status;
	}
	 public HashMap insert() {
	 //System.out.println("Insert---------in bean");
           //System.out.println("record set for tpn"+recordSet);

//		HashMap result=new HashMap();
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();
		map.put("flag","temp");
		map.put("result",new Boolean(true));
		map.put("message","inside insert");

		//put required data
		String patientclass=(String)recordSet.get("patient_class");
		/* Generate Order Id*/
		if (patientclass.equals("EA"))
		{
			patientclass="OP";
		}
		else if (patientclass.equals("DF"))
		{
			patientclass="IP";
		}
		//String orderid			=setOrderID(patientclass);
		ArrayList orderIds		= new ArrayList();
		ArrayList startDates	= new ArrayList();
		ArrayList endDates		= new ArrayList();
		String freqNature		= (String)recordSet.get("freqNature");
		String freqCode			= (String)recordSet.get("frequency");
		if (freqCode== null) { freqCode="";	}
		String regCode		=(String)recordSet.get("Regimen_Code");
		String regDesc		=(String)recordSet.get("Regimen_Desc");
		String locCode		=(String)recordSet.get("location_code");
		String locType		=(String)recordSet.get("location_type");
		String priority			=(String)recordSet.get("priority"); 
		String patient_id		=(String)recordSet.get("patient_id");
		String encounter_id=(String)recordSet.get("encounter_id");
		String ordertype		=(String)recordSet.get("ordertype_code");
		String strt_date		=(String)recordSet.get("startdate"); 
		if(!getLanguageId().equals("en")) // if block added for SRR20056-SCF-7783	28195
			strt_date=com.ehis.util.DateUtils.convertDate(strt_date, "DMYHM",getLanguageId(),"en");
		int volume				=Integer.parseInt((String)recordSet.get("volume"));
		int duration			=Integer.parseInt((String)recordSet.get("duration"));
		String total_daily_fluid			=(String)(recordSet.get("total_daily_fluid")==null?"":recordSet.get("total_daily_fluid"));//added for ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(recordSet.get("enteral_feeding")==null?"":recordSet.get("enteral_feeding"));//added for ML-MMOH-CRF-1012
		
		int qty					=calculateQty(freqCode,volume,1,regCode);
		String qty1				=qty+"";

	    //System.err.println("duration----nonstan baen-->"+duration);


		for(int i=0; i<duration; i++){
			orderIds.add(setOrderID(patientclass));
			startDates.add(getNextDate(strt_date,i+""));
			endDates.add(getNextDate(strt_date,(i+1)+""));
		}
		/*Get trade_code*/
		String tradecode		=getTradeCode(regCode);
		
		/* Get Dispense location*/
		//ArrayList dispLocn	=getDispenseLocation(login_facility_id,locType,locCode,"N",priority); //Commented for for SRR20056-SCF-7783	ICN 28195
		ArrayList dispLocn	=getOrderDispenseLocationForTPN(locType,locCode,"N",priority,"8","",patient_id,encounter_id);// added for for SRR20056-SCF-7783	ICN 28195,"",patient_id,encounter_id added for MMS-QH-CRF-0048 [IN:037704]
		if (dispLocn.size()==0)
		{
			tabData.put("flag","temp");
			tabData.put("result",new Boolean(false));
			tabData.put("message","Errror Retrieving dispense locations!!");
		}

		String dispcode		=(String)dispLocn.get(0);
	
		String authreqd		=(String)recordSet.get("authreqdYN");
		String cosignreqd	=(String)recordSet.get("cosignreqdYN");
		String appreqd		=(String)recordSet.get("splappreqdYN");
		String authorized	=(String)recordSet.get("authorizedYN");
		String approved		=(String)recordSet.get("splappedYN");
		String cosigned		=(String)recordSet.get("cosignedYN");
		String infroute		=(String)recordSet.get("infroute");
		//String infuseover   =(String)recordSet.get("infuseover");
		//String enddate      =(String)recordSet.get("enddate");
	   								 
		/*System.err.println("infroute----bean-->"+infroute);
	    System.err.println("infuseover----bean-->"+infuseover);
	    System.err.println("strt_date----bean-->"+strt_date);
	    System.err.println("enddate----bean-->"+enddate);*/


		/* Calculate order status */
		String orderstatus	=getOrderStatus(authreqd,cosignreqd,appreqd,authorized,approved,cosigned);

		tabData.put("flag","temp"); 
		tabData.put("result",new Boolean(true));
		tabData.put("message","inside insert");

		//common order details
		tabData.put("order_id",orderIds);
		tabData.put("patient_id",patient_id);
		tabData.put("encounter_id",encounter_id);
		tabData.put("location_type",locType);
		tabData.put("location_code",locCode);
		tabData.put("pract_id",recordSet.get("pract_id"));
		tabData.put("patient_class",patientclass);
		if(!getLanguageId().equals("en")) // if& else block added for SRR20056-SCF-7783	28195
			tabData.put("order_date",com.ehis.util.DateUtils.convertDate((String)recordSet.get("order_date"), "DMYHM",getLanguageId(),"en"));
		else
			tabData.put("order_date",recordSet.get("order_date"));

		//tabData.put("order_date",recordSet.get("order_date")); // commented for SRR20056-SCF-7783	28195
		tabData.put("weight",recordSet.get("weight"));
		tabData.put("height",recordSet.get("height"));
		tabData.put("priority",priority);
		tabData.put("orderstatus",orderstatus);
		tabData.put("scheduleFrequency",scheduleFrequency);
		tabData.put("header_comments",getPresRemarks());

		//Regimen related details
        try{
		tabData.put("Regimen_Code",regCode);
		tabData.put("Regimen_Name",regDesc);
		tabData.put("ordertype",ordertype);
		tabData.put("startdate",recordSet.get("startdate"));
		tabData.put("enddate",recordSet.get("enddate"));
		tabData.put("duration",recordSet.get("duration"));
		tabData.put("frequency",freqCode);
		tabData.put("freqNature",freqNature);
		tabData.put("quantity",qty1);
		tabData.put("tradecode",tradecode);
		tabData.put("infuseover",recordSet.get("infuseover"));
		tabData.put("infuseoverdrn",recordSet.get("infuseoverdrn"));
		tabData.put("volume",recordSet.get("volume"));
		tabData.put("unitofvolume",(StockUOM==null || StockUOM.equals(""))?recordSet.get("unitofvolume"):StockUOM);
		tabData.put("authreqdYN",authreqd); 
		tabData.put("cosignreqdYN",cosignreqd);
		tabData.put("splappreqdYN",appreqd);
		tabData.put("consentreqdYN",recordSet.get("consentreqdYN"));
		tabData.put("authorizedYN",authorized);
		tabData.put("cosignedYN",cosigned);
		tabData.put("splappedYN",approved);
		tabData.put("dispcode",dispcode);		/*dispcode to be inserted*/
		tabData.put("user",login_by_id);
		tabData.put("facility",login_facility_id);
		tabData.put("wsno",login_at_ws_no);

		tabData.put("GroupCodes",getStoredGroups());
		tabData.put("Generics",getGenerics());
		tabData.put("ncp_n_val",ncp_n_val);
		tabData.put("infroute",infroute);
		tabData.put("startDates",startDates);
		tabData.put("endDates",endDates);
		tabData.put("total_daily_fluid",total_daily_fluid);//added for ML-MMOH-CRF-1012
		tabData.put("enteral_feeding",enteral_feeding);//added for ML-MMOH-CRF-1012
	    }catch(Exception e){System.err.println("Exception is"+e.getMessage());}

		/*Get Regimen Remarks  and store it in the tabData*/
		tabData.put("regimenRemarks",regimenRemarks);
		try {
			// TOTAL_DAILY_FLUID, ENTERAL_FEEDING ? ? added for ML-MMOH-CRF-1012 
			String SQLORDERLINEPH="INSERT INTO OR_ORDER_LINE_PH (ORDER_ID,ORDER_LINE_NUM,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ADMIN_RATE_DETAIL,TOTAL_DAILY_FLUID, ENTERAL_FEEDING) VALUES (? /*ORDER_ID */,? /* ORDER_LINE_NUM */,? /*TRADE_CODE */,'N',? /*DOSAGE_TYPE */,?/* TOT_STRENGTH*/,?/*TOT_STRENGTH_UOM */,?/*INFUSE_OVER */,?/* INFUSE_OVER_UNIT*/,?/*INFUSION_RATE */,?/* INFUSION_VOL_STR_UNIT*/,?/* INFUSION_PER_UNIT*/,'N','N','N',?/*DISPENSING_LOC_TYPE */,?/* DISPENSING_LOC*/,?/*BMS_QTY */,?/* BMS_STRENGTH */,?/*ADDED_BY_ID */,SYSDATE,?/* ADDED_AT_WS_NO*/,?/* ADDED_FACILITY_ID */,?/* MODIFIED_BY_ID */,SYSDATE,?/*MODIFIED_AT_WS_NO */,?/* MODIFIED_FACILITY_ID */,'N',?/* STRENGTH_VALUE */,?/*STRENGTH_UOM */,?/*PRES_QTY_VALUE */,?/*PRES_QTY_UOM */,?,?,?)";
			String SQL_PH_TPN_STD_REGIMEN_UPDATE1="SELECT ORDER_COMMENT FROM OR_ORDER_COMMENT WHERE ORDER_ID =? AND ACTION_SEQ_NUM = ? FOR UPDATE ";
			String SQL_PH_TPN_NON_STD_REGIMEN_INSERT1="INSERT INTO OR_ORDER_LINE_PH_TPN ( ORDER_ID, ORDER_LINE_NUM, CONST_GENERIC_CODE, CONST_QTY,  CONST_QTY_UNIT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,   MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, PRES_ITEM_CODE, TPN_LIMIT_OVERRIDE_REASON )     VALUES ( ? ,?,?, ?,?, ?, SYSDATE, ?,?, ?, SYSDATE,?, ?, ?, ?) ";
			
			String SQLORDER="INSERT INTO OR_ORDER (ORDER_ID, ORDER_TYPE_CODE, ORDER_CATEGORY,CONTR_SYS_ID, PATIENT_ID, PATIENT_CLASS, ORDERING_FACILITY_ID,ENCOUNTER_ID, EPISODE_ID, SOURCE_TYPE,SOURCE_CODE, DISCHARGE_IND, ORD_DATE_TIME, ORD_PRACT_ID, PRIORITY, ORD_AUTH_REQD_YN,  ORD_AUTH_BY_PRACT_ID,ORD_AUTH_DATE_TIME,ORD_APPR_REQD_YN, ORD_APPR_BY_USER_ID, ORD_APPR_DATE_TIME, ORD_COSIGN_REQD_YN, ORD_COSIGN_BY_PRACT_ID, ORD_COSIGN_DATE_TIME,BILL_YN, CONT_ORDER_IND, PERFORMING_FACILITY_ID, PERFORMING_SYS_ID, PERFORMING_DEPTLOC_TYPE, PERFORMING_DEPTLOC_CODE, PERFORMING_PRACT_ID,  RESULT_AUTH_REQD_YN, CHILD_ORDER_YN,  ORDER_SET_YN,  IV_PREP_YN,  ORDER_STATUS,ADDED_BY_ID,  ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,  MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ORD_CONSENT_REQD_YN, ORD_CONSENT_BY_ID,  ORD_CONSENT_BY_DATE_TIME,TRN_GROUP_REF) VALUES (?/*order_id*/, ?/*ORDER_TYPE_CODE*/, 'PH', 'PH', ?/*PATIENT_ID*/,?/*PATIENT_CLASS*/, ?/*ORDERING_FACILITY_ID*/, ?/*ENCOUNTER_ID*/, ?/*EPISODE_ID*/, ? /*SOURCE_TYPE*/, ?/*SOURCE_CODE*/, 'N', TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_DATE_TIME*/, ?/*ORD_PRACT_ID*/, ?/*PRIORITY*/,?/*ORD_AUTH_REQD_YN*/, ?/*ORD_AUTH_BY_PRACT_ID*/,  TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_AUTH_DATE_TIME*/,?/*ORD_APPR_REQD_YN*/, ?/*ORD_APPR_BY_USER_ID*/,  TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_APPR_DATE_TIME*/,?/*ORD_COSIGN_REQD_YN*/, ?/*ORD_COSIGN_BY_PRACT_ID*/, TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_COSIGN_DATE_TIME*/,'N', 'CO', ?/*PERFORMING_FACILITY_ID*/, 'PH', ?/*PERFORMING_DEPTLOC_TYPE*/,	?/*PERFORMING_DEPTLOC_CODE*/,?/*PERFORMING_PRACT_ID*/, 'N', 'N', 'N', ?, ?/*ORDER_STATUS*/, ?/*ADDED_BY_ID*/, SYSDATE, ?/*ADDED_AT_WS_NO*/, ?/*ADDED_FACILITY_ID*/,  ?/*MODIFIED_BY_ID*/, SYSDATE, ?/*MODIFIED_AT_WS_NO*/,   ?/*MODIFIED_FACILITY_ID*/, ?/*ORD_CONSENT_REQD_YN*/, ?/*ORD_CONSENT_BY_ID*/,    TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_CONSENT_BY_DATE_TIME*/,? )";
			//sqlMap.put("SQLORDER", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT1" ) );
			sqlMap.put("SQLORDER",SQLORDER);
			sqlMap.put("SQLORDERLINE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT2" ) );
			//sqlMap.put("SQLORDERLINEPH", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT3A" ) );
			sqlMap.put("SQLORDERLINEPH",SQLORDERLINEPH);
			sqlMap.put("SQLORDERCOMMENTS", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT4" ) );
			sqlMap.put("SQLORDERCOMMENTS1",SQL_PH_TPN_STD_REGIMEN_UPDATE1);
			sqlMap.put("SQLORDERLINEFIELDVALUES", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT5" ) );
			sqlMap.put("SQLMEDNADMIN", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT6" ) );
			sqlMap.put("SQLDATESELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT15" ) );
			sqlMap.put("SQLFACILITYPARAMSELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT14" ) );
			sqlMap.put("SQLORDERLINETPNINSERT",SQL_PH_TPN_NON_STD_REGIMEN_INSERT1 );
			sqlMap.put("SQLPH_PATIENT_DRUG_PROFILE_INSERT", PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_INSERT4A" ) );

			sqlMap.put("SERIALNO", PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_SELECT55" ) );
         
			map=localInsert (tabData,sqlMap ); 
			//System.out.println("tabData------1175--->" +tabData);

			if( ((Boolean) map.get( "result")).booleanValue() )
					//map.put( "message", getMessage((String) map.get( "msgid")) ) ;
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

			else
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
					//map.put( "message", (String)map.get("msgid") ) ;
			 }
			 catch (Exception e)
			 {
			System.err.println("exception in insert"+e.toString());
			 }
			return map;
	}

	private HashMap localInsert( HashMap tabData , HashMap sqlMap ) {
	System.out.println("localInsert---------in bean");


		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside local Insert" ) ;

		String debug="0";

		Connection connection			= null ;
		PreparedStatement pstmt_insert1	= null ;
		PreparedStatement pstmt_insert2	= null ;
		PreparedStatement pstmt_insert3	= null ;
		PreparedStatement pstmt_insert4	= null ;
		PreparedStatement pstmt_insert5	= null ;
		PreparedStatement pstmt_insert6	= null ;
		PreparedStatement pstmt_insert7	= null ;
		PreparedStatement pstmt_insert	= null ;
		PreparedStatement pstmt			= null ;
		CallableStatement cstmt_insert	= null ;
		ResultSet resultSet				= null ;
		PreparedStatement pstmt_clob	= null ;
		ResultSet	rset_clob			= null ;
		PreparedStatement pstmttmp		= null ;
		ResultSet rstmp					= null ;

//		String order_id					=(String)tabData.get("order_id");
		ArrayList orderIds				=(ArrayList)tabData.get("order_id");
		ArrayList startDates			=(ArrayList)tabData.get("startDates");
		ArrayList endDates				=(ArrayList)tabData.get("endDates");
		String orderstatus				=(String)tabData.get("orderstatus");
		String patient_id				=(String)tabData.get("patient_id");
		String encounter_id				=(String)tabData.get("encounter_id");
		String location_type			=(String)tabData.get("location_type");
		String location_code			=(String)tabData.get("location_code");
		String pract_id					=(String)tabData.get("pract_id");
		String patient_class			=(String)tabData.get("patient_class");
		String order_date				=(String)tabData.get("order_date");
		String weight					=(String)tabData.get("weight");
		String height					=(String)tabData.get("height");
		String priority					=(String)tabData.get("priority");
		String Regimen_Code				=(String)tabData.get("Regimen_Code");
		String tradecode				=(String)tabData.get("tradecode");
		String stdregimen				=(String)tabData.get("Regimen_Name");
		String ordertype				=(String)tabData.get("ordertype");
		//String startdate				=(String)tabData.get("startdate");
		//String enddate					=(String)tabData.get("enddate");
		String duration					=(String)tabData.get("duration");
		String frequency				=(String)tabData.get("frequency");
		String quantity					=(String)tabData.get("quantity");
		String infuseover				=(String)tabData.get("infuseover");
		String infuseoverdrn			=(String)tabData.get("infuseoverdrn");
		String volume					=(String)tabData.get("volume");
		String unitofvolume				=(String)tabData.get("unitofvolume");
		String authreqdYN				=(String)tabData.get("authreqdYN");
		String cosignreqdYN				=(String)tabData.get("cosignreqdYN");
		String splappreqdYN				=(String)tabData.get("splappreqdYN");	
		String consentreqdYN			=(String)tabData.get("consentreqdYN");	
		String authorizedYN				=(String)tabData.get("authorizedYN");
		String cosignedYN				=(String)tabData.get("cosignedYN");
		String splappedYN				=(String)tabData.get("splappedYN");	
		String dispcode					=(String)tabData.get("dispcode");
		String user						=(String)tabData.get("user");
		String facility					=(String)tabData.get("facility");
		String wsno						=(String)tabData.get("wsno");
		HashMap	regimenRemarks			=(HashMap)tabData.get("regimenRemarks");
		ArrayList	groupcodes			=(ArrayList)tabData.get("GroupCodes");
		HashMap	generics				=(HashMap)tabData.get("Generics");
		HashMap	scheduleFrequency		=(HashMap)tabData.get("scheduleFrequency");
		String header_comments			=(String)tabData.get("header_comments");
		String ncp_n					=(String)tabData.get("ncp_n_val");
		String infroute					=(String)tabData.get("infroute");
		String total_daily_fluid		=(String)(tabData.get("total_daily_fluid")==null?"":tabData.get("total_daily_fluid"));//added for ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(tabData.get("enteral_feeding")==null?"":tabData.get("enteral_feeding"));//added for ML-MMOH-CRF-1012
		
		String route_code				="";  
		String trn_group_ref			="";  
		int tmpcount					= 0;
		int srl_NO						= 0;


		try {

			connection		= getConnection() ;
			pstmt			= connection.prepareStatement((String) sqlMap.get( "SERIALNO"));
				pstmt.setString(1,patient_id);

				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						srl_NO	=	resultSet.getInt("NEXT_SRL_NO");
				}

			 pstmt=null;   
			 pstmt   =connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT5A"));
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
				route_code=resultSet.getString("DFLT_IV_ROUTE_CODE");
				if(route_code == null){route_code="";}
						
				}

				closeResultSet(resultSet);
				closeStatement(pstmt);

			  pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT")) ;
			  resultSet	= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				trn_group_ref = resultSet.getString("TRN_GROUP_REF");
			}
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
			}
			catch(Exception es) {
				es.printStackTrace();
			}

			pstmt_insert1=connection.prepareStatement((String) sqlMap.get( "SQLORDER"));
			if(orderIds.size()>0){
				for(int i=0;i<orderIds.size();i++){
							pstmt_insert1.setString(1,(String)orderIds.get(i));
							pstmt_insert1.setString(2,ordertype);
							pstmt_insert1.setString(3,patient_id);
							pstmt_insert1.setString(4,patient_class);
							pstmt_insert1.setString(5,facility);
							pstmt_insert1.setString(6,encounter_id);
							pstmt_insert1.setString(7,encounter_id);
							pstmt_insert1.setString(8,location_type);
							pstmt_insert1.setString(9,location_code);
							pstmt_insert1.setString(10,order_date);
							pstmt_insert1.setString(11,pract_id);
							pstmt_insert1.setString(12,priority);
							pstmt_insert1.setString(13,authreqdYN);
						
							if (authorizedYN.equals("Y"))
							{
								pstmt_insert1.setString(14,pract_id);
								pstmt_insert1.setString(15,order_date);
							}
							else
							{
								pstmt_insert1.setString(14,"");
								pstmt_insert1.setString(15,"");
							}
							pstmt_insert1.setString(16,splappreqdYN);
							if (splappedYN.equals("Y"))
							{
								pstmt_insert1.setString(17,pract_id);
								pstmt_insert1.setString(18,order_date);
							}
							else
							{
								pstmt_insert1.setString(17,"");
								pstmt_insert1.setString(18,"");
							}
							pstmt_insert1.setString(19,cosignreqdYN);
							if (cosignedYN.equals("Y"))
							{
								pstmt_insert1.setString(20,pract_id);
								pstmt_insert1.setString(21,order_date);
							}
							else
							{
								pstmt_insert1.setString(20,"");
								pstmt_insert1.setString(21,"");
							}
							pstmt_insert1.setString(22,facility);
							pstmt_insert1.setString(23,"P");
							pstmt_insert1.setString(24,dispcode);/*dispcode to be inserted*/
							pstmt_insert1.setString(25,pract_id);
							pstmt_insert1.setString(26,"8");/* IV_PREP_YN*/
							pstmt_insert1.setString(27,orderstatus);
							pstmt_insert1.setString(28,user);
							pstmt_insert1.setString(29,wsno);
							pstmt_insert1.setString(30,facility);
							pstmt_insert1.setString(31,user);
							pstmt_insert1.setString(32,wsno);
							pstmt_insert1.setString(33,facility);
							pstmt_insert1.setString(34,consentreqdYN);
							pstmt_insert1.setString(35,"");
							pstmt_insert1.setString(36,"");
							pstmt_insert1.setString(37,trn_group_ref);
							
				//			tmpcount = pstmt_insert1.executeUpdate();
							pstmt_insert1.addBatch();
				}		

					//Execute the batch
						int[] batch_result = pstmt_insert1.executeBatch();
							//System.err.println("batch_result.length-----line1307------>"+batch_result.length);
						for (int i=0;i<batch_result.length ;i++ )
						{
							if(batch_result[i]<0  && batch_result[i] != -2 ){
								tmpcount=0;
								break;
							} 
							else 
							{
								tmpcount = 1;
							}
  						}
				  	closeStatement(pstmt_insert1);
				}
				if (tmpcount==0){
				//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into OR_ORDER") ;
					connection.rollback();
					return map;
				}
				
			/* OR_ORDER  OVER*/

			pstmt_insert2=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINE"));
			if(orderIds.size()>0){
				for(int i=0;i<orderIds.size();i++){
						pstmt_insert2.setString(1,(String)orderIds.get(i));
						pstmt_insert2.setString(2,"1");
						pstmt_insert2.setString(3,Regimen_Code);
						pstmt_insert2.setString(4,stdregimen);
						pstmt_insert2.setString(5,stdregimen);
						pstmt_insert2.setString(6,ordertype);
						pstmt_insert2.setString(7,order_date);
						pstmt_insert2.setString(8,priority);
						pstmt_insert2.setString(9,authreqdYN);
						pstmt_insert2.setString(10,splappreqdYN);
						pstmt_insert2.setString(11,cosignreqdYN);
						pstmt_insert2.setString(12,(String)startDates.get(i));
						pstmt_insert2.setString(13,route_code); 
			//			qty_value=(Integer.parseInt(quantity)/Integer.parseInt(duration))+"";
						pstmt_insert2.setString(14,volume);//quantity_vlaue
						pstmt_insert2.setString(15,unitofvolume);
						pstmt_insert2.setString(16,frequency);
						pstmt_insert2.setString(17,"1");
						pstmt_insert2.setString(18,"D");
						if (!regimenRemarks.isEmpty())
						{
							pstmt_insert2.setString(19,(String)regimenRemarks.get("order_format_values"))/*LINE_FIELDS_DISPLAY_TEXT*/;
						}
						else
						{
							pstmt_insert2.setString(19,"")/*LINE_FIELDS_DISPLAY_TEXT*/;
						}
						pstmt_insert2.setString(20,(String)endDates.get(i));
						pstmt_insert2.setString(21,quantity);//order_qty
						pstmt_insert2.setString(22,unitofvolume);
						pstmt_insert2.setString(23,pract_id);
						pstmt_insert2.setString(24,orderstatus);
						pstmt_insert2.setString(25,user);
						pstmt_insert2.setString(26,wsno);
						pstmt_insert2.setString(27,facility);
						pstmt_insert2.setString(28,user);
						pstmt_insert2.setString(29,wsno);
						pstmt_insert2.setString(30,facility);
						pstmt_insert2.setString(31,consentreqdYN);
						pstmt_insert2.setString(32,stdregimen);
						pstmt_insert2.setString(33,stdregimen);

//						tmpcount = pstmt_insert2.executeUpdate();
						pstmt_insert2.addBatch();
				}
				//Execute the batch
					int[] batch_result = pstmt_insert2.executeBatch();
						System.out.println("batch_result.length-----line1380------>"+batch_result.length);
					for (int i=0;i<batch_result.length ;i++ ){
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							tmpcount=0;
							break;
						}else {
							tmpcount = 1;
						}
  					}
				closeStatement(pstmt_insert2);
			}	
			if (tmpcount==0){
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER_LINE") ;
				connection.rollback();
				return map;
			}
			
			
			/* OR_ORDER_LINE  OVER*/
			/* PH_PATIENT_DRUG_PROFILE_INSERT     */

			//System.err.println("duration------>"+duration);

			pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLPH_PATIENT_DRUG_PROFILE_INSERT"));
			if(orderIds.size()>0){
				for(int i=0;i<orderIds.size();i++){
						pstmt_insert.setString(1,patient_id);
						pstmt_insert.setString(2,""+(srl_NO++));
						pstmt_insert.setString(3,facility);
						pstmt_insert.setString(4,encounter_id);
						pstmt_insert.setString(5,patient_class);
						pstmt_insert.setString(6,location_type);
						pstmt_insert.setString(7,location_code);
						pstmt_insert.setString(8,"");//
						pstmt_insert.setString(9,"");//
						pstmt_insert.setString(10,"");//
						pstmt_insert.setString(11,"");//
						pstmt_insert.setString(12,"");//
						pstmt_insert.setString(13,"");//
						pstmt_insert.setString(14,pract_id);//
						pstmt_insert.setString(15,pract_id);//
						pstmt_insert.setString(16,Regimen_Code);//DRUG_CODE,
						pstmt_insert.setString(17,"NONSTREG");//GENERIC_ID,
						pstmt_insert.setString(18,(String)startDates.get(i));
						pstmt_insert.setString(19,(String)endDates.get(i));
						pstmt_insert.setString(20,"Y");
						pstmt_insert.setString(21,"N");
						pstmt_insert.setString(22,"");//strength
						pstmt_insert.setString(23,"");//strength_uom_code
						pstmt_insert.setString(24,"");//dosage
						pstmt_insert.setString(25,"");//dosage_uom_code
						pstmt_insert.setString(26,"");//SPLIT_DOSE_PREVIEW
						pstmt_insert.setString(27,frequency);
						pstmt_insert.setString(28,duration);
						pstmt_insert.setString(29,quantity);
						pstmt_insert.setString(30,"");//DIAG_TEXT
						pstmt_insert.setString(31,"");
						pstmt_insert.setString(32,"8");
						pstmt_insert.setString(33,"");
						pstmt_insert.setString(34,"");
						pstmt_insert.setString(35,"");
						pstmt_insert.setString(36,"");
						pstmt_insert.setString(37,"");
						pstmt_insert.setString(38,"N");
						pstmt_insert.setString(39,"");
						pstmt_insert.setString(40,null);
						pstmt_insert.setString(41,"N");
						pstmt_insert.setString(42,"");
						pstmt_insert.setString(43,null);
						pstmt_insert.setString(44,"P");
						pstmt_insert.setString(45,facility);
						pstmt_insert.setString(46,(String)orderIds.get(i));
						pstmt_insert.setString(47,"1");
						pstmt_insert.setString(48,"");
						pstmt_insert.setString(49,"N");
						pstmt_insert.setString(50,null);
						pstmt_insert.setString(51,"");
						pstmt_insert.setString(52,"");
						pstmt_insert.setString(53,null);
						pstmt_insert.setString(54,"");
						pstmt_insert.setString(55,"");
						pstmt_insert.setString(56,"N");
						pstmt_insert.setString(57,null);
						pstmt_insert.setString(58,"");
						pstmt_insert.setString(59,"");
						pstmt_insert.setString(60,user);
						pstmt_insert.setString(61,wsno);
						pstmt_insert.setString(62,facility);
						pstmt_insert.setString(63,user);
						pstmt_insert.setString(64,wsno);
						pstmt_insert.setString(65,facility);
						pstmt_insert.setString(66,"");
						pstmt_insert.setString(67,"");//ALLERGY_REMARKS
						pstmt_insert.setString(68,"");//DOSE_REMARKS
						pstmt_insert.setString(69,"");//IV_INGREDIENTS
						pstmt_insert.setString(70,"D");//DURN_TYPE
						pstmt_insert.setString(71,"");//DISPENSED_DRUGS,
						pstmt_insert.setString(72,"");//ALTERNATE_GENERIC_ID,
						pstmt_insert.setString(73,"");//DISP_REMARKS,
						pstmt_insert.setString(74,"");//DUPLICATE_DRUG_OVERRIDE_REASON,
						pstmt_insert.setString(75,"N");//REFILL_YN,
						pstmt_insert.setString(76,"");//FORM_CODE
						pstmt_insert.setString(77,"");//
						pstmt_insert.setString(78,"");//
						pstmt_insert.setString(79,"");//
						pstmt_insert.setString(80,"");//
						pstmt_insert.setString(81,"");//
						pstmt_insert.setString(82,"");//
						pstmt_insert.setString(83,"");//
						pstmt_insert.setString(84,"");//
						pstmt_insert.setString(85,"");//
						pstmt_insert.setString(86,"");//PRESCRIBED_MODE
						pstmt_insert.setString(87,height);
						pstmt_insert.setString(88,"");//height_unit
						pstmt_insert.setString(89,weight);
						pstmt_insert.setString(90,"");//weight_unit
						pstmt_insert.setString(91,"");//bsa
						pstmt_insert.setString(92,"N");	//allergic_yn					
						pstmt_insert.setString(93,"");//bmi	
						pstmt_insert.setString(94,infroute);//TPN_ADMIN_ROUTE

					// tmpcount = pstmt_insert.executeUpdate();
						pstmt_insert.addBatch();
				}
				//Execute the batch
					int[] batch_result = pstmt_insert.executeBatch();
					//System.err.println("batch_result.length-----line1505------>"+batch_result.length);
					for (int i=0;i<batch_result.length ;i++ ){
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							tmpcount=0;
							break;
						}else {
							tmpcount = 1;
						}
  					}
				closeStatement(pstmt_insert);
			}
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into PH_PATIENT_DRUG_PROFILE") ;
				connection.rollback();
				return map;

			}



					
			pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEPH"));
			if(orderIds.size()>0){
				for(int i=0;i<orderIds.size();i++){
					pstmt_insert3.setString(1,(String)orderIds.get(i));
					pstmt_insert3.setString(2,"1");
					pstmt_insert3.setString(3,tradecode);
					pstmt_insert3.setString(4,"A");
					pstmt_insert3.setString(5,"");
					pstmt_insert3.setString(6,"");
					pstmt_insert3.setString(7,infuseover);
					pstmt_insert3.setString(8,infuseoverdrn);
					pstmt_insert3.setString(9,"");
					pstmt_insert3.setString(10,"");
					pstmt_insert3.setString(11,"");
					pstmt_insert3.setString(12,"P");
					pstmt_insert3.setString(13,"");/*dispcode to be inserted*/
					pstmt_insert3.setString(14,quantity);
					pstmt_insert3.setString(15,"");
					pstmt_insert3.setString(16,user);
					pstmt_insert3.setString(17,wsno);
					pstmt_insert3.setString(18,facility);
					pstmt_insert3.setString(19,user);
					pstmt_insert3.setString(20,wsno);
					pstmt_insert3.setString(21,facility);
					pstmt_insert3.setString(22,"");
					pstmt_insert3.setString(23,"");
					pstmt_insert3.setString(24,quantity);
					pstmt_insert3.setString(25,unitofvolume);
					pstmt_insert3.setString(26,ncp_n);
					pstmt_insert3.setString(27,total_daily_fluid);//added for ML-MMOH-CRF-1012
					pstmt_insert3.setString(28,enteral_feeding);//added for ML-MMOH-CRF-1012		
//					tmpcount = pstmt_insert3.executeUpdate();
					pstmt_insert3.addBatch();
				}
				//Execute the batch
					int[] batch_result = pstmt_insert3.executeBatch();
				//	System.err.println("batch_result.length-----1566------>"+batch_result.length);
					for (int i=0;i<batch_result.length ;i++ ){
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							tmpcount=0;
							break;
						}else {
							tmpcount = 1;
						}
  					}
				closeStatement(pstmt_insert3);
			}
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER_LINE_PH") ;
				connection.rollback();
				return map;

			}
			/* OR_ORDER_LINE_PH OVER*/


			
			// Header Level Comments  /* ORDER_COMMENT */

			
			if ( (header_comments!=null) && (header_comments.length() > 0) && (!header_comments.equals(""))   )
			{
				//System.err.println("in side block");
				pstmt_insert4 = connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS"));
				// System.err.println("orderIds.size()------>"+orderIds.size());
				if(orderIds.size()>0){
					for(int i=0;i<orderIds.size();i++){
							pstmt_insert4.setString(1, (String)orderIds.get(i));
							pstmt_insert4.setString(2, "1"); // For Insert it will be "1"
							pstmt_insert4.setString(3, user);
							pstmt_insert4.setString(4, wsno);
							pstmt_insert4.setString(5, facility);
							pstmt_insert4.setString(6, user);
							pstmt_insert4.setString(7, wsno);
							pstmt_insert4.setString(8, facility);
							tmpcount = pstmt_insert4.executeUpdate();
							//System.err.println("tmpcount-----line1607------>"+tmpcount);

							if(tmpcount > 0 )
							{
								
								pstmt_clob		= connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS1"));
								pstmt_clob.setString(1,(String)orderIds.get(i));
								pstmt_clob.setString(2,"1"); 
								rset_clob=pstmt_clob.executeQuery();
								if(rset_clob!=null)
								{
									while(rset_clob.next())
									{
										Clob clb 			= (Clob) rset_clob.getClob(1);
										BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
										bw.write(header_comments,0,header_comments.length());
										bw.flush();
										bw.close();
									}

								}
								
								closeResultSet(rset_clob);
								closeStatement(pstmt_clob);
							}
							else
							{
								map.put( "result", new Boolean( false) ) ;
								map.put( "msgid", "Error During Insertion into OR_ORDER_COMMENTS") ;
								connection.rollback();
								return map;
							}
					}
					closeStatement(pstmt_insert4);
					closeResultSet(rset_clob);
				}
	  		}

			/* OR_ORDER_COMMENTS OVER*/

		if(pstmt_insert5!=null) closeStatement(pstmt_insert5);
			int seqNo=0;
			if (!scheduleFrequency.isEmpty())
			{
				pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEFIELDVALUES"));
				ArrayList fieldvalues=(ArrayList)scheduleFrequency.get(Regimen_Code);
				if(orderIds.size()>0){
					for(int i=0;i<orderIds.size();i++){
						for(int n=0;n<fieldvalues.size();n++){
							HashMap data=new HashMap();
							data=(HashMap)fieldvalues.get(n);
							String admin_time=(String)data.get("admin_time");
							String admin_qty=(String)data.get("admin_qty");
							seqNo++;
							pstmt_insert5.setString(1,(String)orderIds.get(i));
							pstmt_insert5.setString(2,"1");
							pstmt_insert5.setString(3,"S");
							pstmt_insert5.setString(4,""+(seqNo++));
							pstmt_insert5.setString(5, "SCHED_ADMIN_TIME");
							pstmt_insert5.setString(6,"C");
							pstmt_insert5.setString(7,"D");
							pstmt_insert5.setString(8,admin_time);
							pstmt_insert5.setString(9,admin_qty);
							pstmt_insert5.setString(10,unitofvolume);
							pstmt_insert5.setString(11,"O");
							pstmt_insert5.setString(12,user);
							pstmt_insert5.setString(13,wsno);
							pstmt_insert5.setString(14,facility);
							pstmt_insert5.setString(15,user);
							pstmt_insert5.setString(16,wsno);
							pstmt_insert5.setString(17,facility);
							pstmt_insert5.addBatch();
						}
					}
				}
				//Execute the batch
				int[] batch_result = pstmt_insert5.executeBatch();
				//System.err.println("batch_result.length-----line1681------>"+batch_result.length);
				if(pstmt_insert5!=null)			closeStatement( pstmt_insert5 ) ;

				for (int i=0;i<batch_result.length ;i++ )
					{
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							tmpcount=0;
							break;
						} 
						else 
						{
							tmpcount = 1;
						}
  					}
			closeStatement(pstmt_insert5);

				if (tmpcount==0)
				{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion of Frequency into OR_ORDER_LINE_FIELD_VALUES table") ;
				connection.rollback();
				return map;

				}
			}
		
			if(pstmt_insert5!=null)			closeStatement( pstmt_insert5 ) ;

			if (!regimenRemarks.isEmpty())
			{
					pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEFIELDVALUES"));
					String  total_seq=(String)regimenRemarks.get("order_format_count") ;
 					int order_format_count=Integer.parseInt(total_seq);
					if(orderIds.size()>0){
						for(int i=0;i<orderIds.size();i++){
							for(int k=0;k<order_format_count;k++){
								pstmt_insert5.setString(1,(String)orderIds.get(i));
								pstmt_insert5.setString(2,"1"); // order_line_num
								pstmt_insert5.setString(3,"S");
								pstmt_insert5.setString(4,""+(seqNo++));
								pstmt_insert5.setString(5,(String)regimenRemarks.get("field_mnemonic"+k));
								pstmt_insert5.setString(6,(String)regimenRemarks.get("field_type"+k));
								pstmt_insert5.setString(7,(String)regimenRemarks.get("label_text"+k));
								pstmt_insert5.setString(8,(String)regimenRemarks.get("field_values"+k));
								pstmt_insert5.setString(9,"");
								pstmt_insert5.setString(10,"");
								pstmt_insert5.setString(11,(String)regimenRemarks.get("accept_option"+k));
								pstmt_insert5.setString(12,user);
								pstmt_insert5.setString(13,wsno);
								pstmt_insert5.setString(14,facility);
								pstmt_insert5.setString(15,user);
								pstmt_insert5.setString(16,wsno);
								pstmt_insert5.setString(17,facility);
								pstmt_insert5.addBatch();
							}
						}
					}
						//Execute the batch
						int[] batch_result = pstmt_insert5.executeBatch();
					 	//System.err.println("batch_result.length-----line1741----->"+batch_result.length);

						for (int i=0;i<batch_result.length ;i++ )
						{
							if(batch_result[i]<0  && batch_result[i] != -2 ){
								tmpcount=0;
								break;
							} 
							else 
							{
								tmpcount = 1;
							}
  						}
				  	closeStatement(pstmt_insert5);

						if (tmpcount==0)
						{
						//failure and so
						map.put( "result", new Boolean( false) ) ;
						map.put( "msgid", "Error During Insertion of Remarks into OR_ORDER_LINE_FIELD_VALUES table") ;
						connection.rollback();
						return map;

						}  
				}
			
			/* OR_ORDER_LINE_FIELD_VALUES OVER*/

			//INSERT INTO PH_MEDN_ADMIN
			//INSERT INTO PH_MEDN_ADMIN
//			PreparedStatement pstmt_select	=null;
//			ResultSet temprs						=null;

			//Check ph_facility_param
/*			 pstmttmp=connection.prepareStatement((String) sqlMap.get( "SQLFACILITYPARAMSELECT"));
			pstmttmp.setString(1,facility);
			 rstmp=pstmttmp.executeQuery();
			String verify			="N";
			String medadmin	="N";
			if (rstmp.next())
			{
				verify		=rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null?"N":rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				medadmin	=rstmp.getString("MED_ADMIN_REQD_YN")==null?"N":rstmp.getString("MED_ADMIN_REQD_YN");
			}
        
			if (	(medadmin.equals("Y"))&&((patient_class.equals("IP")||(patient_class.equals("EM")))))
			{
		
				pstmt_insert6=connection.prepareStatement((String) sqlMap.get( "SQLMEDNADMIN"));
						pstmt_insert6.setString(1,facility);
						pstmt_insert6.setString(2,encounter_id);
						pstmt_insert6.setString(3,startdate);
						pstmt_insert6.setString(4,Regimen_Code);
						pstmt_insert6.setString(5,"1");
						pstmt_insert6.setString(6,order_id);
						pstmt_insert6.setString(7,"1");
						pstmt_insert6.setString(8,patient_id);
						pstmt_insert6.setString(9,pract_id);
						pstmt_insert6.setString(10,quantity);
						pstmt_insert6.setString(11,unitofvolume);
						pstmt_insert6.setString(12,"")   //SCH_ROUTE_CODE;
						pstmt_insert6.setString(13,user);
						pstmt_insert6.setString(14,wsno);
						pstmt_insert6.setString(15,facility);
						pstmt_insert6.setString(16,user);
						pstmt_insert6.setString(17,wsno);
						pstmt_insert6.setString(18,facility);
						pstmt_insert6.setString(19,verify)  //VERIFY_REQD_YN;
						tmpcount =pstmt_insert6.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into PH_MEDN_ADMIN") ;
				connection.rollback();
				return map;

			}
		
		}  */
				//Execute Batch for PH_MEDN_ADMIN

				/* START OF INSERT INTO OR_ORDER_LINE_PH_TPN */
				pstmt_insert7=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINETPNINSERT"));
				StringTokenizer st = null;
				int line_no			=	0;
					System.out.println("INSERT INTO OR_ORDER_LINE_PH_TPN  orderIds--- 1874->" +orderIds);

				if(orderIds.size()>0){
					//System.out.println("orderIds--- 1874->" +orderIds);

					for(int i=0;i<orderIds.size();i++){
						line_no			=	0;
						for (int gc=0;gc<groupcodes.size();gc++){
							ArrayList gns=(ArrayList)generics.get(groupcodes.get(gc));
					System.out.println("gns--- 1874->" +gns);
							for (int k=0;k<gns.size();k+=8)	{
					System.out.println("insert generics "+gns.size()+" ===gns==>"+gns);
								st = new StringTokenizer((String)gns.get(k+3),"!");
								String const_qty_unit = (String)st.nextToken();
                    //System.out.println("const_qty_unit "+const_qty_unit);

								if (!const_qty_unit.equals(" ")){
									pstmt_insert7.setString(1,(String)orderIds.get(i));
									pstmt_insert7.setString(2,++line_no+"");
									pstmt_insert7.setString(3,(String)gns.get(k+0));
									String qty=(String)gns.get(k+2);
									if (qty==null || qty.equals("0")  )
									{
										continue;
									}
							
									pstmt_insert7.setString(4,(String)gns.get(k+2));
									pstmt_insert7.setString(5,const_qty_unit.trim());
									pstmt_insert7.setString(6,user);
									pstmt_insert7.setString(7,wsno);
									pstmt_insert7.setString(8,facility);
									pstmt_insert7.setString(9,user);
									pstmt_insert7.setString(10,wsno);
									pstmt_insert7.setString(11,facility);
									pstmt_insert7.setString(12,(String)gns.get(k+7));
									pstmt_insert7.setString(13,(String)gns.get(k+6));
									//System.out.println("(String)gns.get(k+7)--Insert--->" +(String)gns.get(k+7));
									//System.out.println("(String)gns.get(k+6)--Insert--->" +(String)gns.get(k+6));
									pstmt_insert7.addBatch();						
								}	
							}
						}
					}
				}
				//Execute Batch for OR_ORDER_LINE_PH_TPN
				int[] batch_result1 = pstmt_insert7.executeBatch();
			  	System.out.println("batch_result1.length-----line1865----->"+batch_result1.length);

				for (int i=0;i<batch_result1.length ;i++ ){
						if(batch_result1[i]<0  && batch_result1[i] != -2 ){
							tmpcount=0;
							break;
						} 
						else{
							tmpcount = 1;
						}
				}
			  	closeStatement(pstmt_insert7);

				if (tmpcount==0){
					//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into OR_ORDER_LINE_PH_TPN Table") ;
					connection.rollback();
					return map;
				}
				
	//Now call workload procedure

	
			cstmt_insert=connection.prepareCall("{call PH_CREATE_WORKLOAD_STATS(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt_insert.setString( 1, pract_id);
			cstmt_insert.setString( 2, order_date);
			cstmt_insert.setString( 3, facility);
			cstmt_insert.setString( 4, patient_class);
			cstmt_insert.setString( 5, location_type);
			cstmt_insert.setString( 6, location_code);
			cstmt_insert.setString( 7,"1");
			cstmt_insert.setString( 8,"1");
			cstmt_insert.setString( 9, wsno);
			cstmt_insert.setString( 10, user);
			cstmt_insert.registerOutParameter(11, Types.VARCHAR );
			cstmt_insert.registerOutParameter(12, Types.VARCHAR );
			cstmt_insert.execute() ;
			String insert_yn	= cstmt_insert.getString( 11 );
			//System.err.println("insert_yn-- 1949--->"+insert_yn);
			if(insert_yn.equals("Y"))
						tmpcount = 1;
			else
						tmpcount = 0;
			 closeStatement( cstmt_insert ) ;
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into Workload Statistics Table") ;
				connection.rollback();
				return map;

			}

			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();

		}//end of try
		catch( Exception e ) {
			map.put( "result",new Boolean( false ) ) ;
			map.put( "msgid", "Exception has occured: " +e+debug) ;
			e.printStackTrace();
					}
		finally {
			try {
				closeResultSet(resultSet);
				closeResultSet(rset_clob);
				closeResultSet(rstmp);
				closeStatement(pstmt);
				closeStatement( pstmttmp);
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_insert3 ) ;
				closeStatement( pstmt_insert4 ) ;
				closeStatement( pstmt_insert5 ) ;
				closeStatement( pstmt_insert6 ) ;
				closeStatement( pstmt_insert7 ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement(pstmt_clob);
				closeConnection( connection );

				 resultSet		=null;
				 rset_clob		=null;
				 rstmp			=null;
				 pstmt			=null;
				 pstmttmp		=null;
				 pstmt_insert 	=null;
				 pstmt_insert1 	=null;
				 pstmt_insert2 	=null;
				 pstmt_insert3 	=null;
				 pstmt_insert4	=null;
				 pstmt_insert5 	=null;
				 pstmt_insert6 	=null;
				 pstmt_insert7 	=null;
				 cstmt_insert 	=null;
				 pstmt_clob		=null;


				closeConnection( connection );
				
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;

			}
		}

		return map ;
	/* Function specific methods end */
}



 public HashMap modify() {
	 //System.out.println("modify---- in 2028---->");
	 //System.out.println("record set for tpn in modify"+recordSet);

		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();
		String orderid			=(String)recordSet.get("order_id");
		String freqNature	=(String)recordSet.get("freqNature");
		String freqCode		=(String)recordSet.get("frequency");
		String regCode		=(String)recordSet.get("Regimen_Code");
		String regDesc		=(String)recordSet.get("Regimen_Desc");
		String patientclass=(String)recordSet.get("patient_class");
		String infroute=(String)recordSet.get("infroute");
		String total_daily_fluid		=(String)(recordSet.get("total_daily_fluid")==null?"":recordSet.get("total_daily_fluid"));//added for amend ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(recordSet.get("enteral_feeding")==null?"":recordSet.get("enteral_feeding"));//added for amend ML-MMOH-CRF-1012
		/* Generate Order Id*/

		if (patientclass.equals("EA"))
		{
			patientclass="OP";
		}
		else if (patientclass.equals("DF"))
		{
			patientclass="IP";
		}

	
		int volume				=Integer.parseInt((String)recordSet.get("volume"));
		int duration			=Integer.parseInt((String)recordSet.get("duration")); 		
		int qty					=calculateQty(freqCode,volume,duration,regCode);
		//System.out.println("qty------2087-->" +qty);
		String qty1				=qty+"";

		//common order details
		tabData.put("order_id",orderid);
		tabData.put("pract_id",recordSet.get("pract_id"));
		tabData.put("patientclass",patientclass);
		tabData.put("encounter_id",recordSet.get("encounter_id"));
		tabData.put("patient_id",recordSet.get("patient_id")); 
		//Regimen related details
		if(!getLanguageId().equals("en")){ // if& else block added for SRR20056-SCF-7783	28195
			tabData.put("startdate",com.ehis.util.DateUtils.convertDate((String)recordSet.get("startdate"), "DMYHM",getLanguageId(),"en"));
			tabData.put("enddate",com.ehis.util.DateUtils.convertDate((String)recordSet.get("enddate"), "DMYHM",getLanguageId(),"en"));
		}
		else{
			tabData.put("startdate",recordSet.get("startdate"));
			tabData.put("enddate",recordSet.get("enddate"));
		}
		//tabData.put("startdate",recordSet.get("startdate")); //commented for SRR20056-SCF-7783	28195
		//tabData.put("enddate",recordSet.get("enddate")); //commented for SRR20056-SCF-7783	28195
		tabData.put("duration",recordSet.get("duration"));
		tabData.put("frequency",freqCode);
		tabData.put("freqNature",freqNature);
		tabData.put("quantity",qty1);
		tabData.put("infuseover",recordSet.get("infuseover"));
		tabData.put("infuseoverdrn",recordSet.get("infuseoverdrn"));
		tabData.put("volume",recordSet.get("volume"));
		tabData.put("unitofvolume",(StockUOM==null || StockUOM.equals(""))?recordSet.get("unitofvolume"):StockUOM);
		tabData.put("user",login_by_id);
		tabData.put("facility",login_facility_id);
		tabData.put("wsno",login_at_ws_no);
		tabData.put("Regimen_Code",regCode);
		tabData.put("Regimen_Desc",regDesc);
		tabData.put("scheduleFrequency",scheduleFrequency);
		tabData.put("header_comments",getPresRemarks()); 
		/*Get Regimen Remarks  and store it in the tabData*/
		tabData.put("regimenRemarks",regimenRemarks);
		tabData.put("GroupCodes",getStoredGroups());
		tabData.put("Generics",getGenerics());
		tabData.put("ncp_n_val",ncp_n_val);
		tabData.put("infroute",infroute);
		//Added for ML-MMOH-CRF-1012 amend mode start
				tabData.put("total_daily_fluid",total_daily_fluid);
				tabData.put("enteral_feeding",enteral_feeding);
		//Added for ML-MMOH-CRF-1012 amend mode end
		try {
			sqlMap.put("SQLORDERLINE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_UPDATEORDERLINE1" ) );
			sqlMap.put("SQLORDERREMARKSDEL", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_ORDERREMARKSDELETE" ) );
			sqlMap.put("SQLORDERLINEREMARKSDEL", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_ORDERLINEREMARKSDELETE" ) );
			//TOTAL_DAILY_FLUID=?, ENTERAL_FEEDING=? added amend ML-MMOH-CRF-1012
			String SQLORDERLINEPH="UPDATE OR_ORDER_LINE_PH SET INFUSE_OVER=?, INFUSE_OVER_UNIT=?,TOT_INFUSION_OVER=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, ADMIN_RATE_DETAIL=?,BMS_QTY=?, PRES_QTY_VALUE=?,TOTAL_DAILY_FLUID=?, ENTERAL_FEEDING=? WHERE ORDER_ID=?";
//			sqlMap.put("SQLORDERLINEPH", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_UPDATEORDERLINEPH1" ) );
			sqlMap.put("SQLORDERLINEPH", SQLORDERLINEPH );
			sqlMap.put("SQLORDERLINESCHEDULE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT5" ) );
			sqlMap.put("SQLORDERCOMMENTS", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT4" ) );
			sqlMap.put("SQLORDERCOMMENTS1", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_UPDATE1" )) ; 			
			sqlMap.put("SQLMEDNADMINDEL", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_DELETE" )) ; 			
			sqlMap.put("SQLMEDNADMIN", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT6" ) );
			sqlMap.put("SQLDATESELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT15" ) );
			sqlMap.put("SQLFACILITYPARAMSELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT14" ) );
			sqlMap.put("SQLMAXSEQNO", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT22" ) );
			//sqlMap.put("SQLORDERLINETPNINSERT", PhRepository.getPhKeyValue( "SQL_PH_TPN_NON_STD_REGIMEN_INSERT1" ) );
			sqlMap.put("SQLORDERLINETPNINSERT", "INSERT INTO OR_ORDER_LINE_PH_TPN ( ORDER_ID, ORDER_LINE_NUM, CONST_GENERIC_CODE, CONST_QTY,  CONST_QTY_UNIT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,   MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,PRES_ITEM_CODE, TPN_LIMIT_OVERRIDE_REASON )     VALUES ( ? ,?,?, ?,?, ?, SYSDATE, ?,?, ?, SYSDATE,?, ?,?,?)" );

			sqlMap.put("SQLORDERLINETPNDELETE", PhRepository.getPhKeyValue( "SQL_PH_TPN_NON_STD_REGIMEN_DELETE1" ) );
			sqlMap.put("PH_DRUG_PROFILE_UPDATE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_PH_DRUG_PROFILE_UPDATE" ) ); 
			
			map.put("result",new Boolean(true));
			map.put("flage","testing modfy");
			map.put("message","In modify");
		
			map=localModify (tabData,sqlMap );
			//System.out.println("map---- bean  2142-->" +map);

			if( ((Boolean) map.get( "result")).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;	
				//map.put( "message", getMessage((String) map.get( "msgid")) ) ;
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;				
				//map.put( "message", (String)map.get("msgid") ) ;
				
			 }
			 catch (Exception e)
			 {
			System.err.println(e.toString());
			 }

			return map;
}

private HashMap localModify( HashMap tabData , HashMap sqlMap ) {
	//System.out.println("localModify----in bean---2163");
	//System.out.println("tabData----in bean---2164" +tabData);
	//System.out.println("sqlMap----in bean---2164" +sqlMap);
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside local Modify" ) ;

		String debug="0"; 
		Connection connection			= null ;
		PreparedStatement pstmt_insert1	= null ;
		PreparedStatement pstmt_insert2	= null ;
		PreparedStatement pstmt_insert3	= null ;
		PreparedStatement pstmt_insert4	= null ;
		PreparedStatement pstmt_insert5	= null ;
		PreparedStatement pstmt_insert6	= null ;
		PreparedStatement pstmt_insert7	= null ;
		PreparedStatement pstmt_update	= null ;
		PreparedStatement pstmt			= null ;
		String route_code				= "";
		PreparedStatement pstmttmp		= null ;
		ResultSet rstmp					= null ;
		ResultSet resultSet				= null ;
		PreparedStatement pstmt_clob	= null ;
		ResultSet	rset_clob			= null ;
		
		
		//Retrieve tabData and sql data

		String order_id				=(String)tabData.get("order_id");
		String startdate			=(String)tabData.get("startdate");
		String enddate				=(String)tabData.get("enddate");
		String duration				=(String)tabData.get("duration");
		String quantity				=(String)tabData.get("quantity");
		String infuseover			=(String)tabData.get("infuseover");
		String infuseoverdrn		=(String)tabData.get("infuseoverdrn");
		String volume				=(String)tabData.get("volume");
		String unitofvolume			=(String)tabData.get("unitofvolume");
		String user					=(String)tabData.get("user");
		String facility				=(String)tabData.get("facility");
		String wsno					=(String)tabData.get("wsno");	
		String Regimen_Code			=(String)tabData.get("Regimen_Code");
		String Regimen_Desc			=(String)tabData.get("Regimen_Desc");	
		String ncp_n			    =(String)tabData.get("ncp_n_val");
		String infroute				=(String)tabData.get("infroute");	

		ArrayList	groupcodes		=(ArrayList)tabData.get("GroupCodes");
		HashMap	generics			=(HashMap)tabData.get("Generics"); 
		HashMap	regimenRemarks		=(HashMap)tabData.get("regimenRemarks");
		HashMap	scheduleFrequency	=(HashMap)tabData.get("scheduleFrequency");
		String total_daily_fluid		=(String)(tabData.get("total_daily_fluid")==null?"":tabData.get("total_daily_fluid"));//added amend for ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(tabData.get("enteral_feeding")==null?"":tabData.get("enteral_feeding"));//added amend for ML-MMOH-CRF-1012

	
		int tmpcount			=0;
		int seqNo=1;
		int t=0;

		try {

			connection	= getConnection() ;
					
			pstmt=null;
			 pstmt   =connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT5A"));
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
				route_code=resultSet.getString("DFLT_IV_ROUTE_CODE");
				if(route_code == null){route_code="";}
						
				}
           try{
		
			pstmt_insert2=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINE"));
			pstmt_insert2.setString(1,route_code); 
			pstmt_insert2.setString(2,volume);//qty_value
			pstmt_insert2.setString(3,unitofvolume);//qty_unit 
			pstmt_insert2.setString(4,quantity);//order_qty	
			pstmt_insert2.setString(5,unitofvolume);//order_uom	
			pstmt_insert2.setString(6,duration); 
			pstmt_insert2.setString(7,startdate); 
			pstmt_insert2.setString(8,enddate);	
			pstmt_insert2.setString(9,user);   
			pstmt_insert2.setString(10,wsno);  
			pstmt_insert2.setString(11,facility); 
			pstmt_insert2.setString(12,Regimen_Desc);
			pstmt_insert2.setString(13,Regimen_Desc);
			pstmt_insert2.setString(14,Regimen_Desc);
			pstmt_insert2.setString(15,Regimen_Desc); 
			pstmt_insert2.setString(16,order_id);
			
			tmpcount = pstmt_insert2.executeUpdate();
		   }catch(Exception e){
			   e.printStackTrace();
			}
			closeStatement( pstmt_insert2 ) ;

			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Updation into OR_ORDER_LINE") ;
				connection.rollback();
				return map;

			}
			/* OR_ORDER_LINE  OVER*/
		
			pstmt_insert1=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEPH"));
			pstmt_insert1.setString(1,infuseover);
			pstmt_insert1.setString(2,infuseoverdrn);
			pstmt_insert1.setString(3,duration);
			pstmt_insert1.setString(4,user);
			pstmt_insert1.setString(5,wsno);
			pstmt_insert1.setString(6,facility);
			pstmt_insert1.setString(7,ncp_n);
			pstmt_insert1.setString(8,quantity);
			pstmt_insert1.setString(9,quantity);
			pstmt_insert1.setString(10,total_daily_fluid);//added amend for ML-MMOH-CRF-1012
			pstmt_insert1.setString(11,enteral_feeding);//added amend for ML-MMOH-CRF-1012
			pstmt_insert1.setString(12,order_id);//changes from 10 to 12 ML-MMOH-CRF-1012 amend
			
			tmpcount = pstmt_insert1.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Updation into OR_ORDER_LINE_PH") ;
				connection.rollback();
				return map;

			}
		closeStatement( pstmt_insert1 ) ;

			/* OR_ORDER_LINE  PH OVER*/

          /* PH_PATIENT_DRUG_PROFILE */

			pstmt_update=connection.prepareStatement((String) sqlMap.get("PH_DRUG_PROFILE_UPDATE"));
	
			pstmt_update.setString(1,infroute);//TPN_ADMIN_ROUTE
			pstmt_update.setString(2,wsno);//MODIFIED_AT_WS_NO
			pstmt_update.setString(3,user);//MODIFIED_BY_ID
			pstmt_update.setString(4,facility);//MODIFIED_FACILITY_ID
			pstmt_update.setString(5,order_id);//ORIG_ORDER_ID
			
			tmpcount = pstmt_update.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Updation into PH_PATIENT_DRUG_PROFILE") ;
				connection.rollback();
				return map;

			}

				closeStatement( pstmt_update ) ;


		  /* Start of ORDER LINE FIELD VALUES */


			if (!scheduleFrequency.isEmpty())
			{

				if(pstmt_insert5!=null) closeStatement(pstmt_insert5);
				pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINESCHEDULE"));
				ArrayList fieldvalues=(ArrayList)scheduleFrequency.get(Regimen_Code);
				for(int n=0;n<fieldvalues.size();n++)
				{
					HashMap data=new HashMap();
					data=(HashMap)fieldvalues.get(n);
  					String admin_time=(String)data.get("admin_time");
  					String admin_qty=(String)data.get("admin_qty");
					pstmt_insert5.setString(1,order_id);
  					pstmt_insert5.setString(2,"1");
  					pstmt_insert5.setString(3,"S");
  					pstmt_insert5.setString(4,""+(seqNo++));
  					pstmt_insert5.setString(5, "SCHED_ADMIN_TIME");
  					pstmt_insert5.setString(6,"C");
  					pstmt_insert5.setString(7,"D");
  					pstmt_insert5.setString(8,admin_time);
  					pstmt_insert5.setString(9,admin_qty);
  					pstmt_insert5.setString(10,unitofvolume);
  					pstmt_insert5.setString(11,"O");
  					pstmt_insert5.setString(12,user);
  					pstmt_insert5.setString(13,wsno);
  					pstmt_insert5.setString(14,facility);
  					pstmt_insert5.setString(15,user);
  					pstmt_insert5.setString(16,wsno);
  					pstmt_insert5.setString(17,facility);
  					pstmt_insert5.addBatch();
				}

			
				//Execute the batch
				int[] batch_result = pstmt_insert5.executeBatch();
				for (int i=0;i<batch_result.length ;i++ )
					{
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							tmpcount=0;
							break;
						} 
						else 
						{
							tmpcount = 1;
						}
  					}
				closeStatement( pstmt_insert5 ) ;

				if (tmpcount==0)
				{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion of Frequency into Order Line Field Values table") ;
				connection.rollback();
				return map;

				}
				
			}


			if (!regimenRemarks.isEmpty())
			{
				if(pstmt_insert3!=null) 
					closeStatement(pstmt_insert3);

					//Delete from or_order_line_field values where field text is not sched_admin_time ie only remarks will be deleted
					pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEREMARKSDEL"));
					pstmt_insert3.setString(1,order_id);
					pstmt_insert3.executeUpdate();

					if(pstmt_insert3!=null) 
						closeStatement(pstmt_insert3);

					//now choose the maximum seq no from or_order_line_field_values							
	   				pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLMAXSEQNO"));
					pstmt_insert3.setString(1,order_id);
					resultSet=	pstmt_insert3.executeQuery();
					if (resultSet.next())
					{
								seqNo=Integer.parseInt(resultSet.getString("SEQ"));
								seqNo=seqNo+1;
					}

					if(pstmt_insert5!=null)	{
						closeStatement(pstmt_insert5);
					}

					pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINESCHEDULE"));
					String  total_seq=(String)regimenRemarks.get("order_format_count") ;
 					int order_format_count=Integer.parseInt(total_seq);
  					for(int k=0;k<order_format_count;k++)
					{
 		  					pstmt_insert5.setString(1,order_id);
 							pstmt_insert5.setString(2,"1"); // order_line_num
 							pstmt_insert5.setString(3,"S");

		 					pstmt_insert5.setString(4,""+(seqNo++));
 							pstmt_insert5.setString(5,(String)regimenRemarks.get("field_mnemonic"+k));
 							pstmt_insert5.setString(6,(String)regimenRemarks.get("field_type"+k));
 							pstmt_insert5.setString(7,(String)regimenRemarks.get("label_text"+k));
 							pstmt_insert5.setString(8,(String)regimenRemarks.get("field_values"+k));
 							pstmt_insert5.setString(9,"");
 							pstmt_insert5.setString(10,"");
 							pstmt_insert5.setString(11,(String)regimenRemarks.get("accept_option"+k));
 							pstmt_insert5.setString(12,user);
							pstmt_insert5.setString(13,wsno);
							pstmt_insert5.setString(14,facility);
							pstmt_insert5.setString(15,user);
							pstmt_insert5.setString(16,wsno);
							pstmt_insert5.setString(17,facility);

							pstmt_insert5.addBatch();
						}
						//Execute the batch
						int[] batch_result = pstmt_insert5.executeBatch();
						for (int i=0;i<batch_result.length ;i++ )
						{
							if(batch_result[i]<0  && batch_result[i] != -2 ){
								tmpcount=0;
								break;
							} 
							else 
							{
								tmpcount = 1;
							}
  						}

						closeStatement(pstmt_insert5);
						if (tmpcount==0)
						{
						//failure and so
						map.put( "result", new Boolean( false) ) ;
						map.put( "msgid", "Error During Insertion of Remarks into Order Line Field Values table") ;
						connection.rollback();
						return map;

						}


				}
			
		/* OR_ORDER_LINE_FIELD_VALUES OVER*/

		/* END OF ORDERLINE_FIELD_VALES */
			String header_comments = (String)tabData.get("header_comments");

			if(pstmt_insert3!=null) closeStatement(pstmt_insert3);
			if ( (header_comments!=null) && (header_comments.length() > 0) && (!header_comments.equals(""))   )
			{

					
				pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERREMARKSDEL"));
				pstmt_insert3.setString(1,order_id);
				pstmt_insert3.executeUpdate();

				pstmt_insert4 = connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS"));
				pstmt_insert4.setString(1, order_id);
				pstmt_insert4.setString(2, "1"); // For Insert it will be "1"
				pstmt_insert4.setString(3, user);
				pstmt_insert4.setString(4, wsno);
				pstmt_insert4.setString(5, facility);
				pstmt_insert4.setString(6, user);
				pstmt_insert4.setString(7, wsno);
				pstmt_insert4.setString(8, facility);
				tmpcount = pstmt_insert4.executeUpdate();
				if(tmpcount > 0 )
				{
					pstmt_clob		= connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS1"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,"1"); 
					rset_clob=pstmt_clob.executeQuery();
					if(rset_clob!=null)
					{
						while(rset_clob.next())
						{
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(header_comments,0,header_comments.length());
							bw.flush();
							bw.close();
						}

					}
				}
				else
				{
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into OR_ORDER_COMMENTS") ;
					connection.rollback();
					return map;
				}
	  		}
			/* OR_ORDER_COMMENTS OVER*/
			if(pstmt_insert3!=null) closeStatement(pstmt_insert3);
			 pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLMEDNADMINDEL"));
			 pstmt_insert3.setString(1,order_id);
			 pstmt_insert3.executeUpdate();

			//INSERT INTO PH_MEDN_ADMIN
				//INSERT INTO PH_MEDN_ADMIN
//			PreparedStatement pstmt_select	=null;
//			ResultSet temprs						=null;

			//Check ph_facility_param
	/*		 pstmttmp=connection.prepareStatement((String) sqlMap.get( "SQLFACILITYPARAMSELECT"));
			pstmttmp.setString(1,facility);
			 rstmp=pstmttmp.executeQuery();
			String verify			="N";
			String medadmin	="N";
			if (rstmp.next())
			{
				verify		=rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null?"N":rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				medadmin	=rstmp.getString("MED_ADMIN_REQD_YN")==null?"N":rstmp.getString("MED_ADMIN_REQD_YN");
			}

			if (	(medadmin.equals("Y"))&&((patient_class.equals("IP")||(patient_class.equals("EM")))))
			{

				pstmt_insert6=connection.prepareStatement((String) sqlMap.get( "SQLMEDNADMIN"));
						pstmt_insert6.setString(1,facility);
						pstmt_insert6.setString(2,encounter_id);
						pstmt_insert6.setString(3,startdate);
						pstmt_insert6.setString(4,Regimen_Code);
						pstmt_insert6.setString(5,"1");
						pstmt_insert6.setString(6,order_id);
						pstmt_insert6.setString(7,"1");
						pstmt_insert6.setString(8,patient_id);
						pstmt_insert6.setString(9,pract_id);
						pstmt_insert6.setString(10,quantity);
						pstmt_insert6.setString(11,unitofvolume);
						pstmt_insert6.setString(12,"")//SCH_ROUTE_CODE;
						pstmt_insert6.setString(13,user);
						pstmt_insert6.setString(14,wsno);
						pstmt_insert6.setString(15,facility);
						pstmt_insert6.setString(16,user);
						pstmt_insert6.setString(17,wsno);
						pstmt_insert6.setString(18,facility);
						pstmt_insert6.setString(19,verify) //VERIFY_REQD_YN;
						tmpcount =pstmt_insert6.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into PH_MEDN_ADMIN") ;
				connection.rollback();
				return map;

			}
		
		}  */
			/* PH_MEDN_ADMIN OVER */

			//Execute Batch for PH_MEDN_ADMIN    

			if(pstmt_insert3!=null) closeStatement(pstmt_insert3);
			 pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINETPNDELETE"));
			 pstmt_insert3.setString(1,order_id);
			 //System.out.println("order_id--- in --- Modify   ---2530--" +order_id);
			 t= pstmt_insert3.executeUpdate();
           //System.out.println("pstmt_insert3---->"+t);

				/* START OF INSERT INTO OR_ORDER_LINE_PH_TPN */
				pstmt_insert7=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINETPNINSERT"));

				//PRES_ITEM_CODE, TPN_LIMIT_OVERRIDE_REASON

				StringTokenizer st = null;
				int line_no			=	0;
				for (int i=0;i<groupcodes.size();i++)
				{ 
					
						ArrayList gns=(ArrayList)generics.get(groupcodes.get(i));
						//System.out.println("gns--- 2546->" +gns);
						for (int k=0;k<gns.size();k+=8)
						{
								//System.out.println("insert generics "+gns.size());
							    st = new StringTokenizer((String)gns.get(k+3),"!");
								String const_qty_unit = (String)st.nextToken();
								//if (!const_qty_unit.equals(" ")){
									
								pstmt_insert7.setString(1,order_id);
								//pstmt_insert7.setString(1,(String)order_id.get(i));
								pstmt_insert7.setString(2,++line_no+"");
								pstmt_insert7.setString(3,(String)gns.get(k+0));
								//System.out.println("order_id-- 2558->" +order_id);
								//System.out.println("line_no-- 2558->" +line_no);
								System.out.println("(String)gns.get(k+0)---->" +(String)gns.get(k+0));
								String qty=(String)gns.get(k+2);
								if (qty==null || qty.equals("0")  )
								{
									continue;
								}
								/*System.out.println("qty--->" +(String)gns.get(k+2));
								System.out.println("const_qty_unit.trim()--->" +const_qty_unit.trim());
								System.out.println("user--->" +user);
								System.out.println("wsno--->" +wsno);
								System.out.println("facility--->" +facility);
								System.out.println("user--->" +user);
								System.out.println("wsno--->" +wsno);
								System.out.println("facility--->" +facility);*/
								
								pstmt_insert7.setString(4,(String)gns.get(k+2));
								pstmt_insert7.setString(5,const_qty_unit.trim());
								pstmt_insert7.setString(6,user);
								pstmt_insert7.setString(7,wsno);
								pstmt_insert7.setString(8,facility);
								pstmt_insert7.setString(9,user);
								pstmt_insert7.setString(10,wsno);
								pstmt_insert7.setString(11,facility);
								try
								{
									//System.out.println("(String)gns.get(k+6)--in modify->" +(String)gns.get(k+6));
									//System.out.println("(String)gns.get(k+7)--in modify->" +(String)gns.get(k+7));
									pstmt_insert7.setString(12,(String)gns.get(k+7));
									pstmt_insert7.setString(13,(String)gns.get(k+6));
								}
								catch (Exception e)
								{
									e.printStackTrace();
								}
								//pstmt_insert7.setString(12,(String)gns.get(k+7));
								//pstmt_insert7.setString(13,(String)gns.get(k+6));
								//System.out.println("(String)gns.get(k+7)- in modify-->" +(String)gns.get(k+7));
								//System.out.println("(String)gns.get(k+6)--in modify->" +(String)gns.get(k+6));
								pstmt_insert7.addBatch();	
								//}
								

							}

				}
				//Execute Batch for OR_ORDER_LINE_PH_TPN
				int[] batch_result1 = pstmt_insert7.executeBatch();
				//System.out.println("batch_result1.length-----line2594----->"+batch_result1.length);
				
				for (int i=0;i<batch_result1.length ;i++ )
				{
						if(batch_result1[i]<0  && batch_result1[i] != -2 ){
							tmpcount=0;
							break;
						} 
						else 
						{
							tmpcount = 1;
						}
				}
				if (tmpcount==0)
				{
					//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into OR_ORDER_LINE_PH Table") ;
					connection.rollback();
					return map;
				}
				
			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();


		}//end of try
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception has occured: " +e+debug) ;
			e.printStackTrace();
				}
		finally {
			try {
				closeResultSet(rstmp);
				closeResultSet( resultSet ) ;
				closeResultSet( rset_clob ) ;
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_insert3 ) ;
				closeStatement( pstmt_insert4 ) ;
				closeStatement( pstmt_insert5 ) ;
				closeStatement( pstmt_insert6 ) ;
				closeStatement( pstmt_insert7 ) ;
				closeStatement( pstmt_update ) ;
				closeStatement(pstmt_clob);
				closeStatement(pstmttmp);
				closeStatement(pstmt); 
				rstmp		    =null;
				resultSet 	    =null;
				rset_clob 	    =null;
				pstmt_insert1 	=null;
				pstmt_insert2 	=null;
				pstmt_insert3 	=null;
				pstmt_insert4 	=null;
				pstmt_insert5 	=null;
				pstmt_insert6 	=null;
				pstmt_insert7 	=null;
				pstmt_update 	=null;
				pstmt_clob		=null;
				pstmttmp		=null;
				pstmt			=null;	
				closeConnection( connection );
			
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;

			}
		} 	
		return map ;  
	}


	/* Function specific methods start */

	/*=====================================*/
public String getenergyunit()
{
		Connection connection		= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet				= null ;
		String result						="";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT25" )) ;
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result=resultSet.getString("ENERGY_UNIT");

			}
		}
	catch ( Exception e ) {

			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
					es.printStackTrace();
			}

		}
		return result;


}
public HashMap getConsGenericDetails(String gCode)
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		HashMap result=new HashMap();
		
		try {
			connection = getConnection() ;
			//this query retrieveds cons Generic info
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GENERIC_SELECT1" )) ;
			pstmt = connection.prepareStatement("SELECT a.CONST_GENERIC_CODE, a.CONST_GENERIC_NAME, a.DISP_SRL_NO, a.CONST_GROUP_CODE, b.CONST_GROUP_NAME, a.UOM_SETUP_LEVEL_IND, a.ITEM_FLUID_APPL_YN FROM PH_TPN_CONST_GENERIC_NAME a, PH_TPN_CONSTITUENT_GROUP b WHERE a.EFF_STATUS='E' AND b.CONST_GROUP_CODE = a.CONST_GROUP_CODE AND a.CONST_GENERIC_CODE=?") ;
		  	pstmt.setString(1,gCode);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result.put("GNAME",resultSet.getString("CONST_GENERIC_NAME"));
				result.put("SRLNO",resultSet.getString("DISP_SRL_NO"));
				result.put("CGROUPCODE",resultSet.getString("CONST_GROUP_CODE"));
				result.put("CGROUPNAME",resultSet.getString("CONST_GROUP_NAME"));
				result.put("UOMFLAG",resultSet.getString("UOM_SETUP_LEVEL_IND"));
                result.put("ITEM_FLUID_REQ_YN",resultSet.getString("ITEM_FLUID_APPL_YN"));
			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.put("GNAME",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   
				System.err.println(es);
			}
		
		}
		return result;

}

public ArrayList getTpnParams()
{
		Connection connection		= null ;
		PreparedStatement pstmt1	= null ;
		ResultSet resultSet1				= null ;
		ArrayList uom_parameters= new ArrayList();
		String result						="";

		try {
			connection = getConnection() ;
		   // pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT5") ) ;
		    pstmt1 = connection.prepareStatement("SELECT ENERGY_UNIT, REGIMEN_PRESC_BASE_UNIT, PEAD_MAX_WEIGHT_VALUE,ADULT_MIN_WEIGHT_VALUE, EXPIRY_FOR_TPN_ADM, ITEM_FLUID_APPL_YN, ORD_REGIMEN_IND  FROM PH_TPN_PARAM WHERE MODULE_ID='PH'") ;
			resultSet1 = pstmt1.executeQuery() ;
            while ( resultSet1 != null && resultSet1.next() ) {
				uom_parameters.add(resultSet1.getString("ENERGY_UNIT"));
				uom_parameters.add(resultSet1.getString("REGIMEN_PRESC_BASE_UNIT"));

				uom_parameters.add(resultSet1.getString("PEAD_MAX_WEIGHT_VALUE"));
				uom_parameters.add(resultSet1.getString("ADULT_MIN_WEIGHT_VALUE"));
				uom_parameters.add(resultSet1.getString("EXPIRY_FOR_TPN_ADM"));
				uom_parameters.add(resultSet1.getString("ITEM_FLUID_APPL_YN"));
				uom_parameters.add(resultSet1.getString("ORD_REGIMEN_IND"));

			}
		}
	catch ( Exception e ) {

			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
					es.printStackTrace();
			}

		}
		return uom_parameters;


}
public  ArrayList getTpnFrequency()
{
	
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;
	String frequency="";
	String freqNature = "";
	String code="";
	ArrayList tpnfreq=new ArrayList();


	try {
			connection	= getConnection();
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT29"));
			pstmt		= connection.prepareStatement("select a.APPL_FREQ_FOR_TPN code,b.FREQ_DESC  FREQUENCY, b.FREQ_NATURE FREQ_NATURE from ph_param a, AM_FREQUENCY b where a.APPL_FREQ_FOR_TPN=b.FREQ_CODE and  MODULE_ID='PH'");
			//pstmt.setString(1,);
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()) {
				code	= resultSet.getString("code");
				frequency = resultSet.getString("FREQUENCY");
				freqNature= resultSet.getString("FREQ_NATURE");
				tpnfreq.add(code);
				tpnfreq.add(frequency);
				tpnfreq.add(freqNature);
			}
		
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + es);}
		}
		return tpnfreq;
}

public HashMap  getOrderDetails1(String orderid){
		Connection connection = null ;
		PreparedStatement pstmt = null,pstmt1=null ;
		ResultSet resultSet = null ,resultSet1=null;
		HashMap result=new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT20" )) ;
			pstmt.setString(1,orderid);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {

				String isscheduled=resultSet.getString("ISSCHEDULED")==null?"":resultSet.getString("ISSCHEDULED");
				result.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CATALOG_CODE")==null?"":resultSet.getString("ORDER_CATALOG_CODE"));
				result.put("START_DATE_TIME",resultSet.getString("START_DATE_TIME")==null?"":resultSet.getString("START_DATE_TIME"));
				result.put("END_DATE_TIME",resultSet.getString("END_DATE_TIME")==null?"":resultSet.getString("END_DATE_TIME"));
				result.put("FREQ_CODE",resultSet.getString("FREQ_CODE")==null?"":resultSet.getString("FREQ_CODE"));
				result.put("FREQ_NATURE",resultSet.getString("FREQ_NATURE")==null?"":resultSet.getString("FREQ_NATURE"));
				result.put("DURN_VALUE",resultSet.getString("DURN_VALUE")==null?"":resultSet.getString("DURN_VALUE"));
				result.put("DURN_TYPE",resultSet.getString("DURN_TYPE")==null?"":resultSet.getString("DURN_TYPE"));
				result.put("INFUSE_OVER",resultSet.getString("INFUSE_OVER")==null?"":resultSet.getString("INFUSE_OVER"));
				result.put("INFUSE_OVER_UNIT",resultSet.getString("INFUSE_OVER_UNIT")==null?"":resultSet.getString("INFUSE_OVER_UNIT"));
				result.put("ISSCHEDULED",isscheduled);
				result.put("LONG_NAME",resultSet.getString("LONG_NAME")==null?"":resultSet.getString("LONG_NAME"));
			
				result.put("CATALOG_DESC",resultSet.getString("CATALOG_DESC")==null?"":resultSet.getString("CATALOG_DESC"));
				result.put("TOTAL_VOLUME",resultSet.getString("TOTAL_VOLUME")==null?"":resultSet.getString("TOTAL_VOLUME"));
				result.put("PRES_BASE_UNIT",resultSet.getString("PRES_BASE_UNIT")==null?"":resultSet.getString("PRES_BASE_UNIT"));
				result.put("TPN_ADMIN_ROUTE",resultSet.getString("TPN_ADMIN_ROUTE")==null?"":resultSet.getString("TPN_ADMIN_ROUTE"));
				//Added for ML-MMOH-CRF-1012 amend mode start
				result.put("TOTAL_DAILY_FLUID",resultSet.getString("TOTAL_DAILY_FLUID")==null?"":resultSet.getString("TOTAL_DAILY_FLUID"));	
				result.put("ENTERAL_FEEDING",resultSet.getString("ENTERAL_FEEDING")==null?"":resultSet.getString("ENTERAL_FEEDING"));
				//Added for ML-MMOH-CRF-1012 amend mode end
					
				if (!isscheduled.equals("0"))
				{
					//get scheduled time and put it in an array list and send it back
					ArrayList schtime=new ArrayList();
					pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT23" )) ;
					pstmt1.setString(1,orderid);
					resultSet1 = pstmt1.executeQuery() ;
					while (resultSet1.next())
					{
						schtime.add(resultSet1.getString("ORDER_LINE_FIELD_VALUE"));
						schtime.add(resultSet1.getString("DOSE"));
					} 

			if (resultSet1!=null)	closeResultSet( resultSet1 ) ;
			if (pstmt1!=null)	closeStatement( pstmt1 ) ;

				result.put("SCH_TIME",schtime);					
				}
				
		

			}
			if (resultSet!=null)	closeResultSet( resultSet ) ;
			if (pstmt!=null)	closeStatement( pstmt ) ;

		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.put("ERROR",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {System.err.println( "Error loading values from database1" ) ;   
			}
		
		}
		return result;

}
public HashMap  getOrderDetails2(String orderid)
{

		Connection connection = null ;
		PreparedStatement pstmt=null ;
		ResultSet resultSet=null;
		HashMap result=new HashMap();
		ArrayList result1 =new ArrayList();
		try {
			connection = getConnection() ;
			pstmt= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_NON_STD_REGIMEN_SELECT2A" )) ;
			pstmt.setString(1,orderid);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next())
			{

				String cgencode		=resultSet.getString("CONST_GENERIC_CODE");
				String cqty			=resultSet.getString("CONST_QTY");
				//String cqtyunit		=resultSet.getString("CONST_QTY_UNIT");
				result1.add(resultSet.getString("CONST_GENERIC_CODE"));
               	result1.add(resultSet.getString("PRES_ITEM_CODE"));
				result1.add(resultSet.getString("TPN_LIMIT_OVERRIDE_REASON"));
				
			    result.put(cgencode,cqty);
						   
			}
			result.put("OVRREASON_FLUID",result1);
			 
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			AdminDetails.put("ERROR",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {  System.err.println( "Error loading values from database1" ) ; 
			}
		
		}
		return result;

}
public ArrayList getFluidRequired(String patient_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList fluidValue = new ArrayList();
		int ispresent=0;
		try {
			connection	= getConnection();
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT2"));
			pstmt		= connection.prepareStatement("SELECT CONST_GENERIC_CODE, short_desc CONST_QTY_UNIT,CONST_MIN_VAL,  CONST_MAX_VAL, CONST_STD_VAL FROM PH_TPN_CONSTITUENT_LIMIT , AM_UOM WHERE CONST_GENERIC_CODE='FLUID' AND UOM_CODE = CONST_QTY_UNIT AND age_group_code IN ( SELECT AGE_GROUP_CODE FROM AM_AGE_GROUP WHERE (   SELECT  CASE  WHEN INSTR(GET_AGE(DATE_OF_BIRTH),'Y')>0  THEN   Ph_Pkg_Common.Ph_Getsubstrbtwndelim(GET_AGE(DATE_OF_BIRTH),'Y',1)   WHEN INSTR(GET_AGE(DATE_OF_BIRTH),'M')>0 THEN    Ph_Pkg_Common.Ph_Getsubstrbtwndelim(GET_AGE(DATE_OF_BIRTH),'M',1)  END  AGE FROM MP_PATIENT WHERE PATIENT_ID =? ) BETWEEN MIN_AGE AND MAX_AGE 	 AND ( GENDER<>DECODE((SELECT sex FROM mp_patient WHERE  patient_id=?),'M','F','F','M','U','*')  OR gender IS NULL) AND  age_unit=( SELECT DECODE(GREATEST(INSTR(GET_AGE(DATE_OF_BIRTH),'Y'),0),0,'D','Y') FROM MP_PATIENT WHERE patient_id=?))");
			pstmt.setString(1, patient_id);			  
			pstmt.setString(2, patient_id);
			pstmt.setString(3, patient_id);
			//pstmt.setString(4, locale);
			resultSet	= pstmt.executeQuery();  
			while (resultSet.next()){
				fluidValue.add(resultSet.getString("CONST_QTY_UNIT"));
				fluidValue.add(resultSet.getString("CONST_MIN_VAL"));
				fluidValue.add(resultSet.getString("CONST_MAX_VAL"));
				fluidValue.add(resultSet.getString("CONST_STD_VAL")); 
				ispresent=1;
				}
				
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

				if (ispresent==0)
				{
					pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT6"));
					resultSet	= pstmt.executeQuery();
					while (resultSet.next()){
						fluidValue.add(resultSet.getString("ORDERING_UNIT"));
						fluidValue.add("0");
						fluidValue.add("100000");
						fluidValue.add("0");
						ispresent=1;
					}
		
		if(resultSet!=null) closeResultSet(resultSet);
		if(pstmt!=null) closeStatement(pstmt);

					if (ispresent==0)
					{
						fluidValue.add("  ");
						fluidValue.add("0");
						fluidValue.add("100000");
						fluidValue.add("0");

					}

				}//while

		

						
		}catch (Exception e) {
				System.err.println("Error loading Fluid Required: " + e);

			}finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception es) {
				System.err.println("Error loading Fluid Required: " + es);}
		}
		return fluidValue;
	}

public  String getVolume(String order_id)
{
	String ordertype="";
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;

	
	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT26"));
			pstmt.setString(1, order_id);
			pstmt.setString(2, login_facility_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				ordertype = resultSet.getString("QTY_VALUE");
			}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

		
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving order type : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving order type : " + es);}
		}
		return ordertype;
}


public  String getCarboConcentration()
{
	String high_carbo_concentration="";
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;
	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_NON_STD_REGIMEN_SELECT4"));
			pstmt.setString(1, login_facility_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				high_carbo_concentration = resultSet.getString("HIGH_CARBO_CONCENTRATION");
			}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);
		
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving high_carbo_concentration : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving high_carbo_concentration : " + es);}
		}
		return high_carbo_concentration;
}

 public String getNextDate(String date, String dayVal) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String nxt_date			= null;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_SELECT2"));
			pstmt.setString(1, date);
			pstmt.setString(2, dayVal);

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				nxt_date	 = resultSet.getString("END_DATE");
			}

		}
		catch(Exception e) {
			System.err.println("Error @ generating Order ID : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ generating Order ID : " + es);}
		}
		return nxt_date;
	}

	public ArrayList getMNEnergies() {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList MNEnergies	= new ArrayList();
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT8"));

			resultSet	= pstmt.executeQuery();
			while(resultSet.next()) {
				MNEnergies.add(resultSet.getString("CONSTITUENT_CODE"));
				MNEnergies.add(resultSet.getString("ENERGY_REL_VALUE"));
			}
		}
		catch(Exception e) {
			System.err.println("Error @ getting macro nutrient energy values : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ getting macro nutrient energy values  : " + es);}
		}
		return MNEnergies;
	}

   /* public String getDispLocn(String location_type,String location_code,String patient_class,String disch_medn_yn,String priority)
        {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="";
		String drug_class=null;
		String drug_code=null;
		String order_type=null;
		String order_type1=null;
		
		try {
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUG_SEARCH_SELECT16A" )) ;
			pstmt.setString(1,location_type);
			pstmt.setString(2,location_code);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,login_facility_id);
			pstmt.setString(5,drug_class);
			pstmt.setString(6,drug_code);
			pstmt.setString(7,order_type);
			pstmt.setString(8,patient_class);
			pstmt.setString(9,disch_medn_yn);
			pstmt.setString(10,priority);
			pstmt.setString(11,getLanguageId());

			System.err.println("location_type----->"+location_type);
			System.err.println("location_code----->"+location_code);
			System.err.println("login_facility_id----->"+login_facility_id);
			System.err.println("login_facility_id----->"+login_facility_id);
			System.err.println("drug_class----->"+drug_class);
			System.err.println("drug_code----->"+drug_code);
			System.err.println("order_type----->"+order_type);
			System.err.println("patient_class----->"+patient_class);
			System.err.println("disch_medn_yn----->"+disch_medn_yn);
			System.err.println("priority----->"+priority);
			System.err.println("getLanguageId()----->"+getLanguageId());
			

			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result=resultSet.getString("DISP_LOCN");
				//System.out.println("dispense loctn in bean------"+result);
			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   
				System.err.println(es);
			}
		
		}
		//System.err.println("result----->"+result);
		return result;

} */

public ArrayList getFluidValues(String order_id,String disp_locn,String generic_code)
{		
		Connection connection		= null ;
		PreparedStatement pstmt1	= null ;
		ResultSet resultSet1				= null ;
		ArrayList fluidvalues= new ArrayList();
		String result						="";
		    //System.err.println("disp_locn------->"+disp_locn);
		try {
			connection = getConnection() ;
		    //pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT2") ) ;commentesd on 17/9/09
		    pstmt1 = connection.prepareStatement("SELECT A.ITEM_CODE ITEM_CODE, D.SHORT_DESC ITEM_DESC FROM PH_INV_ITEM_FOR_NS_REGIMEN A,(SELECT ORDER_ID,CONST_GENERIC_CODE  FROM OR_ORDER_LINE_PH_TPN UNION  SELECT ? ORDER_ID,CONST_GENERIC_CODE FROM PH_TPN_CONST_GENERIC_NAME ) B,MM_ITEM D,PH_TPN_CONST_FOR_NS_REGIMEN E WHERE A.CONST_GENERIC_CODE=B.CONST_GENERIC_CODE AND a.CONST_GENERIC_CODE = E.CONST_GENERIC_CODE AND A.ITEM_CODE = D.ITEM_CODE and a.ITEM_CODE=E.ITEM_CODE AND B.CONST_GENERIC_CODE=? AND EXISTS (SELECT C.ITEM_CODE FROM ST_ITEM_BATCH C WHERE C.QTY_ON_HAND>=C.COMMITTED_QTY AND C.ITEM_CODE=A.ITEM_CODE AND STORE_CODE=?) AND B.ORDER_ID=? AND e.eff_status='E'") ;
			pstmt1.setString(1,order_id);
			pstmt1.setString(2,generic_code);
			pstmt1.setString(3,disp_locn);
			pstmt1.setString(4,order_id);
			/*System.out.println("1.order_id---in bean-->" +order_id);
			System.out.println("2.generic_code---in bean-->" +generic_code);
			System.out.println("3.disp_locn-in bean---->" +disp_locn);
			System.out.println("4.order_id---in bean-->" +order_id);*/
			resultSet1 = pstmt1.executeQuery() ;
            while ( resultSet1 != null && resultSet1.next() ) {
				fluidvalues.add(resultSet1.getString("ITEM_CODE"));
				fluidvalues.add(resultSet1.getString("ITEM_DESC"));
				
			}
		}
	catch ( Exception e ) {

			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
					es.printStackTrace();
			}

		}
		return fluidvalues;


}

public String getVolume(String quantity,String genrc_code,String fluid)
{
		Connection connection		= null ;
		PreparedStatement pstmt1	= null ;
		ResultSet resultSet1				= null ;
		//ArrayList volume_values= new ArrayList();
		String result						="";
		
		try {
			connection = getConnection() ;
String sql="SELECT round((?*(DECODE(a.CONCENTRATION_PERCENT,NULL,100,0,100,a.CONCENTRATION_PERCENT)/100)),2)  || ' ' || b.SALE_UOM_CODE  Volume FROM	PH_TPN_CONST_FOR_NS_REGIMEN a 	,ST_ITEM b WHERE a.CONST_GENERIC_CODE = ?  AND  a.ITEM_CODE=?   AND A.ITEM_CODE=B.ITEM_CODE ";

		//    pstmt1 = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_NON_STD_REGIMEN_SELECT6")) ;
		  pstmt1 = connection.prepareStatement(sql);
			pstmt1.setString(1,quantity);
			pstmt1.setString(2,genrc_code);
			pstmt1.setString(3,fluid);
			resultSet1 = pstmt1.executeQuery() ;
            while ( resultSet1 != null && resultSet1.next() ) {
				result=resultSet1.getString("VOLUME");
		    }
		}
	catch ( Exception e ) {

			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
					es.printStackTrace();
			}

		}
		return result;

	}

	public ArrayList getOrderDispenseLocationForTPN(String location_type,String location_code,String take_home_medication,String priority,String iv_prep_yn,String drug_code,String patient_id,String encounter_id) {
		Connection connection	= null;
        CallableStatement cstmt	= null;
        ResultSet resultSet		= null;
		ArrayList disp_locn		= new ArrayList();

		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			cstmt.setString(1, login_facility_id);
			cstmt.setString(2, location_type);
			cstmt.setString(3, location_code);
			cstmt.setString(4, take_home_medication);
			cstmt.setString(5, priority);
			cstmt.setString(6, iv_prep_yn);
			cstmt.setString(7, getLanguageId());
			
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.setString(12,drug_code); // added for Bru-HIMS-CRF-347 [IN:037862]-- end
			cstmt.setString(13,patient_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(14,encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.execute();

			disp_locn.add(cstmt.getString(8));
			disp_locn.add(cstmt.getString(9));
			disp_locn.add(cstmt.getString(10));
		    //setDispCode(cstmt.getString(8).toString());
		}
		catch (Exception e) {
			disp_locn.add(e.toString());
			System.err.println("Error finding default dispense location for TPN NS :"+e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		 
		return disp_locn;
	}

	public HashMap ChkDiscrete(String facility_id,String encounter_id,String note_type){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String contr_module_id="PH";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT  distinct to_char(TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi:ss') TEST_OBSERV_DT_TM FROM ca_encntr_discr_msr WHERE ? = facility_id(+) and encounter_id = ? and discr_msr_panel_or_form_id = ? and CONTR_MODULE_ID =? ");			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			pstmt.setString(4,contr_module_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                
				 result.put("TEST_OBSERV_DT_TM",resultSet.getString("TEST_OBSERV_DT_TM"));
				
			}
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}

		//System.err.println("TEST_OBSERV_DT_TM---from bean----->"+result);
		return result;
	}


 public HashMap ChkAdMixture(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		//String iv_admixture_appl_yn="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT TPN_SCREENING_TYPE,TPN_SCREENING_FORM_ID from ph_facility_param where FACILITY_ID=?");
			pstmt.setString(1,getLoggedInFacility());
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                
				 result.put("TPN_SCREENING_TYPE",resultSet.getString("TPN_SCREENING_TYPE"));
				 result.put("TPN_SCREENING_FORM_ID",resultSet.getString("TPN_SCREENING_FORM_ID"));

			}
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}

		//System.err.println("result---from bean----->"+result);
		return result;
	}
									
    public HashMap ChkScreeningDetails(String facility_id,String encounter_id,String note_type){
		//System.err.println("calling this method--->");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String accession_num="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE FACILITY_ID=? AND ENCOUNTER_ID =? AND NOTE_TYPE=?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                 accession_num =resultSet.getString("ACCESSION_NUM");
			     result.put("ACCESSION_NUM",accession_num);
			 }
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		System.err.println("result--oncology--->"+result);
		return result;
	}
 


public ArrayList getUOMData()throws Exception{
		ArrayList uom_parameters= new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt1=null;
        ResultSet resultSet1 = null;
        try {
			connection = getConnection() ;
		   // pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT5") ) ;
		    pstmt1 = connection.prepareStatement("SELECT ENERGY_UNIT, REGIMEN_PRESC_BASE_UNIT, PEAD_MAX_WEIGHT_VALUE,ADULT_MIN_WEIGHT_VALUE, EXPIRY_FOR_TPN_ADM, ITEM_FLUID_APPL_YN, ORD_REGIMEN_IND  FROM PH_TPN_PARAM WHERE MODULE_ID='PH'") ;
			resultSet1 = pstmt1.executeQuery() ;
            while ( resultSet1 != null && resultSet1.next() ) {
				uom_parameters.add(resultSet1.getString("ENERGY_UNIT"));
				uom_parameters.add(resultSet1.getString("REGIMEN_PRESC_BASE_UNIT"));

				uom_parameters.add(resultSet1.getString("PEAD_MAX_WEIGHT_VALUE"));
				uom_parameters.add(resultSet1.getString("ADULT_MIN_WEIGHT_VALUE"));
				uom_parameters.add(resultSet1.getString("EXPIRY_FOR_TPN_ADM"));
				uom_parameters.add(resultSet1.getString("ITEM_FLUID_APPL_YN"));
				uom_parameters.add(resultSet1.getString("ORD_REGIMEN_IND"));
				
			}
					
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet1 ) ;
                closeStatement( pstmt1 ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return uom_parameters;		
	}
public String ChkWorkingHours(String disp_locn_code){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String working_hours_flag ="";
		
		try {
			connection = getConnection() ;
			 pstmt = connection.prepareStatement( "SELECT 'X'FROM PH_disp_locn WHERE FACILITY_ID=? and disp_locn_code=? group by WORKING_HOURS_To,WORKING_HOURS_FROM having to_char(sysdate,'hh24:mi')  between to_char(WORKING_HOURS_FROM,'hh24:mi') and to_char(WORKING_HOURS_To,'hh24:mi')");
			  pstmt.setString(1,getLoginFacilityId());
			  pstmt.setString(2,disp_locn_code);
			  resultSet = pstmt.executeQuery() ;
			
			   if (resultSet != null && resultSet.next()){
				working_hours_flag = resultSet.getString(1);
				
			   }
				closeStatement(pstmt);
				closeResultSet(resultSet);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		
		return working_hours_flag;
	}
	public HashMap ChkAdMixtureAppl(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String iv_admixture_appl_yn="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("select IV_ADMIXTURE_APPL_YN,ALERT_PRACTITIONER_YN,TPN_SCREENING_TYPE,TPN_SCREENING_FORM_ID from ph_facility_param where FACILITY_ID=?");
			pstmt.setString(1,getLoginFacilityId());
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next())
			{
                 iv_admixture_appl_yn =resultSet.getString("IV_ADMIXTURE_APPL_YN");
			     result.put("IV_ADMIXTURE_APPL_YN",iv_admixture_appl_yn);
				 result.put("ALERT_PRACTITIONER_YN",resultSet.getString("ALERT_PRACTITIONER_YN"));
				 result.put("TPN_SCREENING_TYPE",resultSet.getString("TPN_SCREENING_TYPE"));
				 result.put("TPN_SCREENING_FORM_ID",resultSet.getString("TPN_SCREENING_FORM_ID"));

			}
			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null)	closeStatement( pstmt ) ;
            if(iv_admixture_appl_yn.equals("Y"))
            {
			  pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT92") );
			  pstmt.setString(1,getLoginFacilityId());
			  resultSet = pstmt.executeQuery() ;
			
			   if (resultSet != null && resultSet.next()){
				result.put("time_flag",resultSet.getString(1));				
			   }

			   if(resultSet!=null) closeResultSet( resultSet ) ;
			   if(pstmt!=null) closeStatement( pstmt ) ;
			}
		}catch(Exception e){
//			System.out.println(e);
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
				
		return result;
	}
	
	public String getprint_ord_sht_rule_ind(String order_type_code, String patient_class){//Added for Bru-HIMS-CRF-393_1.0
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String print_option_sql		= "";
		String pres_print			= "";
		try{
			connection				= getConnection() ;
			print_option_sql="SELECT PRINT_ORD_SHT_RULE_IND FROM OR_ORDER_TYPE_ROUTING WHERE ORDER_TYPE_CODE=? AND PATIENT_CLASS=DECODE(?,PATIENT_CLASS, PATIENT_CLASS, '*A') AND OPERATING_FACILITY_ID=?";
			pstmt			= connection.prepareStatement(print_option_sql) ;
			pstmt.setString(1,order_type_code);
			pstmt.setString(2,patient_class);
			pstmt.setString(3,login_facility_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				pres_print=resultSet.getString("PRINT_ORD_SHT_RULE_IND")==null ? "C" :resultSet.getString("PRINT_ORD_SHT_RULE_IND");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pres_print;
	}
	
}
