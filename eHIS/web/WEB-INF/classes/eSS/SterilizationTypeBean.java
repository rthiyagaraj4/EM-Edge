/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.sql.Connection ;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.* ;
import eSS.Common.* ;

public class SterilizationTypeBean extends MasterCodeBean implements Serializable {

	protected String sterile_type		="";
	protected String sterile_life		="";
	protected String sterile_life_unit  ="";

	public void setSterile_type(String sterile_type) {
		 this.sterile_type = sterile_type.toUpperCase	();
	}

	public String getSterile_type( ) {
		 return sterile_type;
	}

	public void setSterile_life(String sterile_life) {
		 this.sterile_life = sterile_life;
	}

	public String getSterile_life( ) {
		 return sterile_life;
	}

	public void setSterile_life_unit(String sterile_life_unit) {
		 this.sterile_life_unit = sterile_life_unit;
	}

	public String getSterile_life_unit( ) {
		 return sterile_life_unit;
	}

	public String getSterile_life_unit_List(){
		String uint=getSterile_life_unit( );
		if(uint.length()==0 || uint==null || uint.equals("null"))
			uint="L";
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_AM_DURATION_TYPE_SELECT_LIST"),getLanguageId(),false),uint);
	}

	/* Over-ridden Adapter methods start here */
	public HashMap validate() {
		HashMap hmReturn = new HashMap() ;
		hmReturn.put("result", new Boolean( true ) ) ;
		hmReturn.put("message", "success mode="+getMode() ) ;
		return hmReturn ;
	}

	public HashMap modify() {
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
        ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;

		alModifyData.add(getLong_desc()				);
		alModifyData.add(getShort_desc()			);
		alModifyData.add(getSterile_life()			);
		alModifyData.add(getSterile_life_unit()		);
		alModifyData.add(getEff_status()			);

		alModifyData.add(login_by_id				);
		alModifyData.add(login_at_ws_no				);
		alModifyData.add(login_facility_id			);

		alModifyData.add(getSterile_type()			);
		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmTableData.put	( "LanguageData",LanguageData);

		hmSQLMap.put	( "ModifySQL", getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_UPDATE"));

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );

	}

	public HashMap insert() {
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;

		alInsertData.add(getSterile_type()	);
		alInsertData.add(getLong_desc()		);
		alInsertData.add(getShort_desc()	);
		alInsertData.add(getSterile_life()	);
		alInsertData.add(getSterile_life_unit()	);
		alInsertData.add(getEff_status()	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		
		alWhereData.add(getSterile_type());
		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "InsertData",alInsertData);
		hmTableData.put	( "WhereData",alWhereData);
		hmTableData.put	( "LanguageData",LanguageData);

		hmSQLMap.put	( "InsertSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STERILIZATION_TYPE_INSERT"));

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}

	public void clear() {
		super.clear() ;
		sterile_life	= "";
		sterile_life_unit	= "";
		sterile_type = "" ;
	}

	public void setAll( Hashtable htRecordSet ) {
		super.setAll(htRecordSet);
		setMode((String) htRecordSet.get("mode")) ;

		setSterile_type((String) htRecordSet.get("sterile_type")) ;
		setSterile_life((String)htRecordSet.get("sterile_life"));
		setSterile_life_unit((String)htRecordSet.get("sterile_life_unit"));
		System.err.println("(String)htRecordSet.get"+(String)htRecordSet.get("STERILE_LIFE_UNIT" ));

	}


	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		HashMap	hmRecord=null;
		hmRecord=fetchRecord("SELECT sterile_type, long_desc, short_desc, sterile_life, eff_status,STERILE_LIFE_UNIT FROM ss_sterilization_type WHERE sterile_type=?",getSterile_type());
		
		
		setSterile_type	( (String)hmRecord.get("STERILE_TYPE" ) ) ;
		setLong_desc	( (String)hmRecord.get("LONG_DESC" )	) ;
		setShort_desc	( (String)hmRecord.get("SHORT_DESC" )	) ;
		setSterile_life	( checkForNull((String)hmRecord.get("STERILE_LIFE" ) )) ;
		setSterile_life_unit((String)hmRecord.get("STERILE_LIFE_UNIT" ) ) ;
		setEff_status	( (String)hmRecord.get("EFF_STATUS" )	) ;

	}

	/* Function specific methods end */

	public String paramsInBean() {
		return long_desc +"\t" + eff_status +"\t" + sterile_life +"\t" + short_desc +"\t" + sterile_type+"\tmode:" + mode;
	}

   public int getSterilizationTypeCode(String code)
   {
	   	java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		int checkCode=0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_COUNT")); 
			preparedStatement.setString(1,code);
			
			
				
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				checkCode=resultSet.getInt("total");				
			}
		}
		
		
		catch (Exception e )	{
			e.printStackTrace();
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return checkCode;	

    }


}
