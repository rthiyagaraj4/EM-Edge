/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */ 
package eSS;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.Common.CommonRepository;
import eCommon.Common.*;
import eSS.Common.*;
import eCommon.SingleTableHandler.*;
import java.util.StringTokenizer;

public class ReportsMasterCodeBean extends eSS.Common.SsAdapter implements java.io.Serializable{

	public String module_id="SS";
	private String sterile_type;
	private String linen_applicable_yn="";//mmoh-crf-1661
	 
public String getLinen_applicable_yn() {
		return linen_applicable_yn;
	}
	public void setLinen_applicable_yn(String linen_applicable_yn) {
		this.linen_applicable_yn = linen_applicable_yn;
	}
public ReportsMasterCodeBean() {

	}
//Added by B.Badmavthi against  AAKH_CRF_0057
public String getSterile_type() {
	return sterile_type;
}

public void setSterile_type(String sterile_type) {
	this.sterile_type = checkForNull(sterile_type);
}
//Add ended
	public ArrayList getMasterCodeList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrMasterCode		=	new  ArrayList();
		HashMap		hmMasterCode		=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_SM_MASTER_CODE_SELECT_REPORTS")); 
				pstmt.setString(1, module_id);
				resultSet = pstmt.executeQuery();
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmMasterCode			=	new HashMap();
					
					hmMasterCode.put("code",checkForNull(resultSet.getString(1)));
					hmMasterCode.put("desc",checkForNull(resultSet.getString(2)));
					arrMasterCode.add(hmMasterCode);
				}
			} 
			catch (Exception e )
			{
				
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrMasterCode;
		}


    public String getROFStatus() {
		String sql = (String) getSsRepositoryValue("sql_SS_RQT_TRAY_STATUS");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql);
		return getListOptionTag(alOptionValues);
	}
	
	public String getDocTypeForRof() {
		String sql = (String) getSsRepositoryValue("SQL_SS_DOC_TYPE_ROF_GROUP_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql);
		return getListOptionTag(alOptionValues);
	}


	public String getNature(){
		return getStaticListOptionTag( "B,Both;E,Enabled;D,Disabled;");
	}
	
	public String getUnitType(){
		return getStaticListOptionTag( "B,Both;A,Autoclave;W,Washing;");
	}
	
	public String getSWPvals(){
		return getStaticListOptionTag( "B,Both;Y,Yes;N,No;" );
	}

	public String getReportType(){
		return getStaticListOptionTag( "1,Summary;D,Detail;");
	}
	public String getWrite_off_Entry_StatusList(){
	return getStaticListOptionTag( "A,All;Y,Completed;N,Not Completed;");
	}

	public String getLoadStatusList(){
	return getStaticListOptionTag( "A,All;P,Passed;F,Failed;");
	}

	public String getWrite_off_finalized_StatusList(){
	return getStaticListOptionTag( "A,All;Y,Finalized;N,UnFinalized;");
	}
	public String getMonthlyServiceStatisticsList(){
	return getStaticListOptionTag( "A,Both;C,Item Count Only;L,Load Count Only;");
	}
	public String getRequestOrderStatusSummaryOptionList(){
	return getStaticListOptionTag( "A,All;RE,Entered;RC,Checked;WE,Washing Entered;WC,Washing Completed;PACK,Packed;HL,Hold;AE,Auto Claving;AC,Auto claved;DI,Dispatched;ACK,Acknowledged");
	}
	public String getDepartmentChargeDetails(){
	return getStaticListOptionTag( "D,Department;R,Store;");
	}
	public String getGroupCode(){
		if(getLinen_applicable_yn()!=null && getLinen_applicable_yn().equals("Y")){//mmoh-crf-1661 
			return getStaticListOptionTag( "T,Tray;E,Set;P,Soft Pack;S,Single;A,All;L,Linen;");
		}else{
			return getStaticListOptionTag( "T,Tray;E,Set;P,Soft Pack;S,Single;A,All;");
		}
	}
	
	public String getRequest_type_List(){
		return getStaticListOptionTag( "A,All;N,Normal;U,Urgent;E,Elective;");
	}
	public String getInstRetStatusPatient_List(){
		return getStaticListOptionTag( "A,All;0,Returned;1,Pending");
	}
	public String getTrayDtlStatusList(){
		return getStaticListOptionTag( "A,All;U,Unsterilized;S,Sterilized;R,In Service Location;W,Written Off;");
	}
	

	public String getOrderBySterilizationType(){
		return getStaticListOptionTag( "1,Sterilization Type Code;2,Sterilization Type Description;");
	}

	public String getOrderByItemClass(){
		return getStaticListOptionTag( "1,Item Class Code;2,Item Class Description;");
	}

	public String getOrderBySurgeryType(){
		return getStaticListOptionTag( "1,Surgery Type Code;2,Surgery Type Description;");
	}

	public String getOrderByServiceLocation(){
		return getStaticListOptionTag( "1,Service Location Code;2,Service Location Description;");
	}

	public String getOrderByAutoclaveWashingUnit(){
		return getStaticListOptionTag( "1,Autoclave Wash Unit Code;2,Autoclave Wash Unit Description;");
	}

	public String getOrderByAutoclaveWashingTest(){
		return getStaticListOptionTag( "1,Test Code;2,Test Description;");
	}
	
	public String getOrderByWriteOffReason(){
		return getStaticListOptionTag( "1,Write Off Reason Code;2,Write Off Reason Description;");
	}

	public String getOrderByUsageType(){
		return getStaticListOptionTag( "1,Usage Type Code;2,Usage Type Description;");
	}

	public String getOrderBySubClassification(){
		return getStaticListOptionTag( "1,Sub Classification Code;2,Sub Classification Description;");
	}

	public String getOrderBySterProcessStage(){
		return getStaticListOptionTag( "1,Process Stage Code;2,Process Stage Description;");
	}

	public String getOrderByWashingType(){
		return getStaticListOptionTag( "1,Washing Type Code;2,Washing Type Description;");
	}

	public String getOrderByStatGroup(){
		return getStaticListOptionTag( "1,Statistical Group Code;2,Statistical Group Description;");
	}

	public String getOrderByStore(){
		return getStaticListOptionTag( "1,Store Code;2,Store Description;");
	}

	public String getOrderByItem(){
		return getStaticListOptionTag( "1,Item Code;2,Item Description;");
	}

	public String getOrderByGroup(){
		return getStaticListOptionTag( "1,Group Code;2,Group Description;");
	}

	public String getOrderBySterilizationCost(){
		return getStaticListOptionTag( "1,Group Code;2,Group Description;");
	}

	public String getOrderByGroupForStore(){
		return getStaticListOptionTag( "1,Store Code;2,Store Description;3,Group Code;4,Group Description;");
	}
	public String getOrderByUserAccessForStore(){
		return getStaticListOptionTag( "2,User Name;4,Store Description;");
	}
	public String getOrderByTrnDocType(){
		return getStaticListOptionTag( "1,Doc Type Code;2,Doc Type Description;");
	}
	public String getOrderByExpiryList(){
		return getStaticListOptionTag( "5,Owner Store Code;7,Current Store Code;2,Group Code;3,Tray No");
	}
	
	public String getStoreType(){
		return getStaticListOptionTag( "B,Both;Y,Owner ;N,Requestor;");
	}

	public String getConsumable(){
		return getStaticListOptionTag( "A,All Items;Y,Consumable Only ;N,Non Consumable;");
	}

	public String getChargeable(){
		return getStaticListOptionTag( "A,All Items;Y,Chargeable Only ;N,Non Chargeable;");
	}

	public String getStaticListOptionTag(String stStaticList, String defaultValue) {
		StringBuffer tagValue = new StringBuffer();
		StringTokenizer stListItems=new StringTokenizer(stStaticList,";");
		while (stListItems.hasMoreTokens()) {
			StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),",");
			String value	=	stListValueText.nextToken();
			String selected =    defaultValue.equalsIgnoreCase(value)?"selected":"";
			tagValue.append("<option value=\""+value+"\" "+selected+">"+stListValueText.nextToken()+"</option>\n");
		}
		return tagValue.toString();
	}
	public String getStaticListOptionTag(String stStaticList) {
		return getStaticListOptionTag(stStaticList, "");
	} 
//Added by B.Badmavthi against  AAKH_CRF_0057
	public String getSterile_type_List(){
		
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_SELECT_LIST"),getLanguageId()));
	}//Added ended

	/* ML-MMOH-CRF-1821 - ENDS */		
	public String getMultiGroupTypeYn () {

		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		String    multi_group_type_yn = "";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( getSsRepositoryValue("SQL_SS_GROUPTYPE_DEFLT_PARAM") ) ;
			pstmt.setString( 1, login_facility_id ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				multi_group_type_yn = checkForNull(resultSet.getString("ALLOW_MULTI_GROUP_TYPES_YN"),"N" ) ;
			}
		} catch ( Exception e )	{
				e.printStackTrace();
			} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return multi_group_type_yn;
	}

	public String getMonthsRangeSysdate(){ 
		java.sql.Connection connection		= null;
		java.sql.PreparedStatement pstmt	= null;
		java.sql.ResultSet resultSet		= null;

		StringBuffer sql = new StringBuffer();
	    sql.append("Select TO_CHAR(SYSDATE-89,'DD/MM/rrrr'),TO_CHAR(SYSDATE,'DD/MM/rrrr')  From DUAL " );
		String strValFrom		= "";
		String strValTo			= "";
		String strDate			= "";
		try{
				connection  =  getConnection();
				pstmt		= connection.prepareStatement(sql.toString()); 
				resultSet	= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					strValFrom	= resultSet.getString(1); 
					strValTo	= resultSet.getString(2);
				}
				strDate = strValFrom+":"+strValTo;
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
				es.printStackTrace() ;
			}
		}
		return strDate;
	}
	/* ML-MMOH-CRF-1821 - ENDS */

}
