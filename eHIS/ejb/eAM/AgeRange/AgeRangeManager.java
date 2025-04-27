/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.AgeRange ;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import java.util.*;
import javax.rmi.*;
import webbeans.eCommon.*;



/**
*
* @ejb.bean
*	name="AgeRange"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AgeRange"
*	local-jndi-name="AgeRange"
*	impl-class-name="eAM.AgeRange.AgeRangeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.AgeRange.AgeRangeManagerLocal"
*	remote-class="eAM.AgeRange.AgeRangeManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.AgeRange.AgeRangeManagerLocalHome"
*	remote-class="eAM.AgeRange.AgeRangeManagerHome"
*	generate= "local,remote"
*
*
*/




public class AgeRangeManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){
	context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertAgeRange(java.util.HashMap hmParams)
	{
		java.util.Properties p =(Properties) hmParams.get("p");
		String 	rangeType				=(String)hmParams.get("rangeType");
		String  rangeId					=(String)hmParams.get("rangeId");
		String  longDesc				=(String)hmParams.get("longDesc");
		String  shortDesc				=(String)hmParams.get("shortDesc");
		int		noOfRanges				=((Integer)hmParams.get("noOfRanges")).intValue();
		String  range1Fr				=(String)hmParams.get("range_1_fr");
		String  range1FrUnit			=(String)hmParams.get("range1FrUnit");
		String    range1To				=(String)hmParams.get("range_1_to");
		String  range1ToUnit			=(String)hmParams.get("range1ToUnit");
		String     range2Fr				=(String)hmParams.get("range_2_fr");
		String  range2FrUnit			=(String)hmParams.get("range2FrUnit");
		String     range2To				=(String)hmParams.get("range_2_to");
		String  range2ToUnit			=(String)hmParams.get("range2ToUnit");
		String     range3Fr				=(String)hmParams.get("range_3_fr");
		String  range3FrUnit			=(String)hmParams.get("range3FrUnit");
		String     range3To				=(String)hmParams.get("range_3_to");
		String  range3ToUnit			=(String)hmParams.get("range3ToUnit");
		String     range4Fr				=(String)hmParams.get("range_4_fr");
		String  range4FrUnit			=(String)hmParams.get("range4FrUnit");
		String     range4To				=(String)hmParams.get("range_4_to");
		String  range4ToUnit			=(String)hmParams.get("range4ToUnit");
		String     range5Fr				=(String)hmParams.get("range_5_fr");
		String  range5FrUnit			=(String)hmParams.get("range5FrUnit");
		String     range5To				=(String)hmParams.get("range_5_to");
		String  range5ToUnit			=(String)hmParams.get("range5ToUnit");
		String     range6Fr				=(String)hmParams.get("range_6_fr");
		String  range6FrUnit			=(String)hmParams.get("range6FrUnit");
		String     range6To				=(String)hmParams.get("range_6_to");
		String  range6ToUnit			=(String)hmParams.get("range6ToUnit");
		String    range7Fr				=(String)hmParams.get("range_7_fr");
		String  range7FrUnit			=(String)hmParams.get("range7FrUnit");
		String    range7To				=(String)hmParams.get("range_7_to");
		String  range7ToUnit			=(String)hmParams.get("range7ToUnit");
		String    range8Fr				=(String)hmParams.get("range_8_fr");
		String  range8FrUnit			=(String)hmParams.get("range8FrUnit");
		String    range8To				=(String)hmParams.get("range_8_to");
		String  range8ToUnit			=(String)hmParams.get("range8ToUnit");
		String    range9Fr				=(String)hmParams.get("range_9_fr");
		String  range9FrUnit			=(String)hmParams.get("range9FrUnit");
		String    range9To				=(String)hmParams.get("range_9_to");
		String  range9ToUnit			=(String)hmParams.get("range9ToUnit");
		String    range10Fr				=(String)hmParams.get("range_10_fr");
		String  range10FrUnit			=(String)hmParams.get("range10FrUnit");
		String    range10To				=(String)hmParams.get("range_10_to");
		String  range10ToUnit			=(String)hmParams.get("range10ToUnit");
		String    range11Fr				=(String)hmParams.get("range_11_fr");
		String  range11FrUnit			=(String)hmParams.get("range11FrUnit");
		String    range11To				=(String)hmParams.get("range_11_to");
		String  range11ToUnit			=(String)hmParams.get("range11ToUnit");
		String    range12Fr				=(String)hmParams.get("range_12_fr");
		String  range12FrUnit			=(String)hmParams.get("range12FrUnit");
		String    range12To				=(String)hmParams.get("range_12_to");
		String  range12ToUnit			=(String)hmParams.get("range12ToUnit");
		String    range13Fr				=(String)hmParams.get("range_13_fr");
		String  range13FrUnit			=(String)hmParams.get("range13FrUnit");
		String    range13To				=(String)hmParams.get("range_13_to");
		String  range13ToUnit			=(String)hmParams.get("range13ToUnit");
		String    range14Fr				=(String)hmParams.get("range_14_fr");
		String  range14FrUnit			=(String)hmParams.get("range14FrUnit");
		String    range14To				=(String)hmParams.get("range_14_to");
		String  range14ToUnit			=(String)hmParams.get("range14ToUnit");
		String    range15Fr				=(String)hmParams.get("range_15_fr");
		String  range15FrUnit			=(String)hmParams.get("range15FrUnit");
		String    range15To				=(String)hmParams.get("range_15_to");
		String  range15ToUnit			=(String)hmParams.get("range15ToUnit");
		String    range16Fr				=(String)hmParams.get("range_16_fr");
		String  range16FrUnit			=(String)hmParams.get("range16FrUnit");
		String    range16To				=(String)hmParams.get("range_16_to");
		String  range16ToUnit			=(String)hmParams.get("range16ToUnit");
		String    range17Fr				=(String)hmParams.get("range_17_fr");
		String  range17FrUnit			=(String)hmParams.get("range17FrUnit");
		String    range17To				=(String)hmParams.get("range_17_to");
		String  range17ToUnit			=(String)hmParams.get("range17ToUnit");
		String    range18Fr				=(String)hmParams.get("range_18_fr");	
		String  range18FrUnit			=(String)hmParams.get("range18FrUnit");
		String    range18To				=(String)hmParams.get("range_18_to");
		String  range18ToUnit			=(String)hmParams.get("range18ToUnit");
		String    range19Fr				=(String)hmParams.get("range_19_fr");
		String  range19FrUnit			=(String)hmParams.get("range19FrUnit");
		String    range19To				=(String)hmParams.get("range_19_to");
		String  range19ToUnit			=(String)hmParams.get("range19ToUnit");
		String    range20Fr				=(String)hmParams.get("range_20_fr");
		String  range20FrUnit			=(String)hmParams.get("range20FrUnit");
		String    range20To				=(String)hmParams.get("range_20_to");
		String  range20ToUnit			=(String)hmParams.get("range20ToUnit");
		String    range21Fr				=(String)hmParams.get("range_21_fr");
		String  range21FrUnit			=(String)hmParams.get("range21FrUnit");
		String    range21To				=(String)hmParams.get("range_21_to");
		String  range21ToUnit			=(String)hmParams.get("range21ToUnit");
		String    range22Fr				=(String)hmParams.get("range_22_fr");
		String  range22FrUnit			=(String)hmParams.get("range22FrUnit");
		String    range22To				=(String)hmParams.get("range_22_to");
		String  range22ToUnit			=(String)hmParams.get("range22ToUnit");
		String    range23Fr				=(String)hmParams.get("range_23_fr");
		String  range23FrUnit			=(String)hmParams.get("range23FrUnit");
		String    range23To				=(String)hmParams.get("range_23_to");
		String  range23ToUnit			=(String)hmParams.get("range23ToUnit");
		String    range24Fr				=(String)hmParams.get("range_24_fr");
		String  range24FrUnit			=(String)hmParams.get("range24FrUnit");
		String    range24To				=(String)hmParams.get("range_24_to");
		String  range24ToUnit			=(String)hmParams.get("range24ToUnit");
		String    range25Fr				=(String)hmParams.get("range_25_fr");
		String  range25FrUnit			=(String)hmParams.get("range25FrUnit");
		String    range25To				=(String)hmParams.get("range_25_to");
		String  range25ToUnit			=(String)hmParams.get("range25ToUnit");
		String	effectiveDateFrom		=(String)hmParams.get("effectiveDateFrom");
		String	effectiveDateTo			=(String)hmParams.get("effectiveDateTo");
		String	effectiveStatus			=(String)hmParams.get("effectiveStatus");
		String	addedFacilityId			=(String)hmParams.get("facilityId");
		String	addedAtWorkstation		=(String)hmParams.get("client_ip_address");
		String locale="";
		locale= p.getProperty("LOCALE");
		hmParams.clear();
						
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sql = new StringBuffer("");
	
			sql.append("insert into am_summ_range (	  "		  );
			sql.append(" range_type,  "						  );
			sql.append(" range_id,		long_desc,   "		  );
			sql.append(" short_desc,	no_of_ranges,"		  );
			sql.append(" range_1_fr, 	range_1_fr_unit,"	  );
			sql.append(" range_1_to,	range_1_to_unit,"	  );
			sql.append(" range_2_fr, 	range_2_fr_unit,"	  );
			sql.append(" range_2_to,	range_2_to_unit,"	  );
			sql.append(" range_3_fr, 	range_3_fr_unit,"	  );
			sql.append(" range_3_to,	range_3_to_unit,"	  );
			sql.append(	" range_4_fr, 	range_4_fr_unit,"	  );
			sql.append(	" range_4_to,	range_4_to_unit,"	  );
			sql.append(	" range_5_fr, 	range_5_fr_unit,"	  );
			sql.append(	" range_5_to,	range_5_to_unit,"	  );
			sql.append(" range_6_fr, 	range_6_fr_unit,"	  );
			sql.append(	" range_6_to,	range_6_to_unit,"	  );
			sql.append(	" range_7_fr, 	range_7_fr_unit,"	  );
			sql.append(	" range_7_to,	range_7_to_unit,"	  );
			sql.append(	" range_8_fr, 	range_8_fr_unit,"	  );
			sql.append(" range_8_to,	range_8_to_unit,"	  );
			sql.append(" range_9_fr, 	range_9_fr_unit,"	  );
			sql.append(" range_9_to,	range_9_to_unit,"	  );
			sql.append(" range_10_fr, 	range_10_fr_unit,"	  );
			sql.append(" range_10_to,	range_10_to_unit,"	  );
			sql.append(" range_11_fr, 	range_11_fr_unit,"	  );
			sql.append(" range_11_to,	range_11_to_unit,"	  );
			sql.append(" range_12_fr, 	range_12_fr_unit,"	  );
			sql.append(" range_12_to,	range_12_to_unit,"	  );
			sql.append(" range_13_fr, 	range_13_fr_unit,"	  );
			sql.append(" range_13_to,	range_13_to_unit,"	  );
			sql.append(" range_14_fr, 	range_14_fr_unit,"	  );
			sql.append(" range_14_to,	range_14_to_unit,"	  );
			sql.append(" range_15_fr, 	range_15_fr_unit,"	  );
			sql.append(" range_15_to,	range_15_to_unit,"	  );
			sql.append(" range_16_fr, 	range_16_fr_unit,"	  );
			sql.append(" range_16_to,	range_16_to_unit,"	  );
			sql.append(" range_17_fr, 	range_17_fr_unit,"	  );
			sql.append(" range_17_to,	range_17_to_unit,"	  );
			sql.append(" range_18_fr, 	range_18_fr_unit,"	  );
			sql.append(" range_18_to,	range_18_to_unit,"	  );
			sql.append(" range_19_fr, 	range_19_fr_unit,"	  );
			sql.append(" range_19_to,	range_19_to_unit,"	  );
			sql.append(" range_20_fr, 	range_20_fr_unit,"	  );
			sql.append(" range_20_to,	range_20_to_unit,"	  );
			sql.append(" range_21_fr, 	range_21_fr_unit,"	  );
			sql.append(" range_21_to,	range_21_to_unit,"	  );
			sql.append(" range_22_fr, 	range_22_fr_unit,"	  );
			sql.append(" range_22_to,	range_22_to_unit,"	  );
			sql.append(" range_23_fr, 	range_23_fr_unit,"	  );
			sql.append(" range_23_to,	range_23_to_unit,"	  );
			sql.append(" range_24_fr, 	range_24_fr_unit,"	  );
			sql.append(" range_24_to,	range_24_to_unit,"	  );
			sql.append(" range_25_fr, 	range_25_fr_unit,"	  );
			sql.append(" range_25_to,	range_25_to_unit,"	  );
			sql.append(" eff_date_from,eff_date_to, "		  );
			sql.append(" eff_status, 	added_by_id, "		  );
			sql.append(" added_date,	added_facility_id,"	  );
			sql.append(" added_at_ws_no,modified_by_id,  "	  );
			sql.append(" modified_date, modified_facility_id,"   );
			sql.append(" modified_at_ws_no "				   	  );
			sql.append(" ) values ( ?, ?, ?, ?, ?, ?, ?, ?,?,");
			sql.append(" ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,");
			sql.append(" ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,");
			sql.append(" ?,?,?,?,sysdate,?,?,?,sysdate,?,?)" );

		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;

		java.sql.Date effective_date_from = null ;
		java.sql.Date effective_date_to = null ;

		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
			effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;

		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
			effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;

		try 
		{
			con=ConnectionManager.getConnection(p);

			final String duplicateSql = "select range_type,range_id from am_summ_range where range_type= ? and range_id= ?" ;
			pstmt = con.prepareStatement( duplicateSql ) ;
			pstmt.setString( 1, rangeType ) ;
			pstmt.setString( 2, rangeId ) ;

			rs = pstmt.executeQuery() ;

			if ( rs.next() ) 
			{
				insertable = false ;

				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
				sb.append( (String) message.get("message") ) ;

				message.clear();
			}

				if(rs!=null) rs.close();	
				if(pstmt!=null) pstmt.close();
		} 
		catch ( Exception e )
		{
			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
		}
		finally
		{
//			sql.setLength(0);
		}

		if ( insertable )
		{
			try 
			{
				pstmt = con.prepareStatement( sql.toString());
				pstmt.setString	( 1,  rangeType ) ;
				pstmt.setString	( 2,  rangeId ) ;
				pstmt.setString	( 3,  longDesc  ) ;
				pstmt.setString	( 4,  shortDesc  ) ;
				pstmt.setInt	( 5,  noOfRanges  ) ;
				pstmt.setString	( 6,  range1Fr  ) ;
				pstmt.setString	( 7,  range1FrUnit  ) ;
				pstmt.setString	( 8,  range1To  ) ;
				pstmt.setString	( 9, range1ToUnit  ) ;
				pstmt.setString	( 10, range2Fr  ) ;
				pstmt.setString	( 11, range2FrUnit  ) ;
				pstmt.setString	( 12, range2To  ) ;
				pstmt.setString	( 13, range2ToUnit  ) ;
				pstmt.setString	( 14, range3Fr  ) ;
				pstmt.setString	( 15, range3FrUnit  ) ;
				pstmt.setString	( 16, range3To ) ;
				pstmt.setString	( 17, range3ToUnit  ) ;
				pstmt.setString	( 18, range4Fr  ) ;
				pstmt.setString	( 19, range4FrUnit  ) ;
				pstmt.setString	( 20, range4To ) ;
				pstmt.setString	( 21, range4ToUnit  ) ;
				pstmt.setString	( 22, range5Fr  ) ;
				pstmt.setString	( 23, range5FrUnit  ) ;
				pstmt.setString	( 24, range5To ) ;
				pstmt.setString	( 25, range5ToUnit  ) ;
				pstmt.setString	( 26, range6Fr  ) ;
				pstmt.setString	( 27, range6FrUnit  ) ;
				pstmt.setString	( 28, range6To ) ;
				pstmt.setString	( 29, range6ToUnit  ) ;
				pstmt.setString	( 30, range7Fr  ) ;
				pstmt.setString	( 31, range7FrUnit  ) ;
				pstmt.setString	( 32, range7To ) ;
				pstmt.setString	( 33, range7ToUnit  ) ;
				pstmt.setString	( 34, range8Fr  ) ;
				pstmt.setString	( 35, range8FrUnit  ) ;
				pstmt.setString	( 36, range8To ) ;
				pstmt.setString	( 37, range8ToUnit  ) ;
				pstmt.setString	( 38, range9Fr  ) ;
				pstmt.setString	( 39, range9FrUnit  ) ;
				pstmt.setString	( 40, range9To ) ;
				pstmt.setString	( 41, range9ToUnit  ) ;
				pstmt.setString	( 42, range10Fr  ) ;
				pstmt.setString	( 43, range10FrUnit  ) ;
				pstmt.setString	( 44, range10To ) ;
				pstmt.setString	( 45, range10ToUnit  ) ;
				pstmt.setString	( 46, range11Fr  ) ;
				pstmt.setString	( 47, range11FrUnit  ) ;
				pstmt.setString	( 48, range11To ) ;
				pstmt.setString	( 49, range11ToUnit  ) ;
				pstmt.setString	( 50, range12Fr  ) ;
				pstmt.setString	( 51, range12FrUnit  ) ;
				pstmt.setString	( 52, range12To ) ;
				pstmt.setString	( 53, range12ToUnit  ) ;
				pstmt.setString	( 54, range13Fr  ) ;
				pstmt.setString	( 55, range13FrUnit  ) ;
				pstmt.setString	( 56, range13To ) ;
				pstmt.setString	( 57, range13ToUnit  ) ;
				pstmt.setString	( 58, range14Fr  ) ;
				pstmt.setString	( 59, range14FrUnit  ) ;
				pstmt.setString	( 60, range14To ) ;
				pstmt.setString	( 61, range14ToUnit  ) ;
				pstmt.setString	( 62, range15Fr  ) ;
				pstmt.setString	( 63, range15FrUnit  ) ;
				pstmt.setString	( 64, range15To ) ;
				pstmt.setString	( 65, range15ToUnit  ) ;
				pstmt.setString	( 66, range16Fr  ) ;
				pstmt.setString	( 67, range16FrUnit  ) ;
				pstmt.setString	( 68, range16To ) ;
				pstmt.setString	( 69, range16ToUnit  ) ;
				pstmt.setString	( 70, range17Fr  ) ;
				pstmt.setString	( 71, range17FrUnit  ) ;
				pstmt.setString	( 72, range17To ) ;
				pstmt.setString	( 73, range17ToUnit  ) ;
				pstmt.setString	( 74, range18Fr  ) ;
				pstmt.setString	( 75, range18FrUnit  ) ;
				pstmt.setString	( 76, range18To ) ;
				pstmt.setString	( 77, range18ToUnit  ) ;
				pstmt.setString	( 78, range19Fr  ) ;
				pstmt.setString	( 79, range19FrUnit  ) ;
				pstmt.setString	( 80, range19To ) ;
				pstmt.setString	( 81, range19ToUnit  ) ;
				pstmt.setString	( 82, range20Fr  ) ;
				pstmt.setString	( 83, range20FrUnit  ) ;
				pstmt.setString	( 84, range20To ) ;
				pstmt.setString	( 85, range20ToUnit  ) ;
				pstmt.setString	( 86, range21Fr  ) ;
				pstmt.setString	( 87, range21FrUnit  ) ;
				pstmt.setString	( 88, range21To ) ;
				pstmt.setString	( 89, range21ToUnit  ) ;
				pstmt.setString	( 90, range22Fr  ) ;
				pstmt.setString	( 91, range22FrUnit  ) ;
				pstmt.setString	( 92, range22To ) ;
				pstmt.setString	( 93, range22ToUnit  ) ;
				pstmt.setString	( 94, range23Fr  ) ;
				pstmt.setString	( 95, range23FrUnit  ) ;
				pstmt.setString	( 96, range23To ) ;
				pstmt.setString	( 97, range23ToUnit  ) ;
				pstmt.setString	( 98, range24Fr  ) ;
				pstmt.setString	( 99, range24FrUnit  ) ;
				pstmt.setString	( 100, range24To ) ;
				pstmt.setString	( 101, range24ToUnit  ) ;
				pstmt.setString	( 102, range25Fr  ) ;
				pstmt.setString	( 103, range25FrUnit  ) ;
				pstmt.setString	( 104, range25To ) ;
				pstmt.setString	( 105, range25ToUnit  ) ;
				pstmt.setDate	( 106, effective_date_from ) ;
				pstmt.setDate	( 107, effective_date_to ) ;
				pstmt.setString	( 108, effectiveStatus ) ;
				pstmt.setString	( 109, addedById ) ;
				pstmt.setString	( 110, addedFacilityId ) ;
				pstmt.setString	( 111, addedAtWorkstation ) ;
				pstmt.setString	( 112, modifiedById ) ;
				pstmt.setString	( 113, modifiedFacilityId ) ;
				pstmt.setString	( 114, modifiedAtWorkstation ) ;

				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) 
				{
					result = true ;
					con.commit();

				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;

					message.clear();
				}

				pstmt.close() ;

			} 
			catch ( Exception e )
			{
				try
				{
					con.rollback();
			    }
				 catch(Exception ce)
				{}
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			finally
		{
			if(con != null)     ConnectionManager.returnConnection(con,p);
		}
		}
		else
		{if(con != null)     ConnectionManager.returnConnection(con,p);
	
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap updateAgeRange(java.util.HashMap hmParams)
	{
			java.util.Properties p =(Properties) hmParams.get("p");
		String 	rangeType				=(String)hmParams.get("rangeType");
		String  rangeId					=(String)hmParams.get("rangeId");
		String  longDesc				=(String)hmParams.get("longDesc");
		String  shortDesc				=(String)hmParams.get("shortDesc");
		int		noOfRanges				=((Integer)hmParams.get("noOfRanges")).intValue();
		String    range1Fr				=(String)hmParams.get("range_1_fr");
		String  range1FrUnit			=(String)hmParams.get("range1FrUnit");
		String    range1To				=(String)hmParams.get("range_1_to");
		String  range1ToUnit			=(String)hmParams.get("range1ToUnit");
		String    range2Fr				=(String)hmParams.get("range_2_fr");
		String  range2FrUnit			=(String)hmParams.get("range2FrUnit");
		String    range2To				=(String)hmParams.get("range_2_to");
		String  range2ToUnit			=(String)hmParams.get("range2ToUnit");
		String    range3Fr				=(String)hmParams.get("range_3_fr");
		String  range3FrUnit			=(String)hmParams.get("range3FrUnit");
		String    range3To				=(String)hmParams.get("range_3_to");
		String  range3ToUnit			=(String)hmParams.get("range3ToUnit");
		String    range4Fr				=(String)hmParams.get("range_4_fr");
		String  range4FrUnit			=(String)hmParams.get("range4FrUnit");
		String    range4To				=(String)hmParams.get("range_4_to");
		String  range4ToUnit			=(String)hmParams.get("range4ToUnit");
		String    range5Fr				=(String)hmParams.get("range_5_fr");
		String  range5FrUnit			=(String)hmParams.get("range5FrUnit");
		String    range5To				=(String)hmParams.get("range_5_to");
		String  range5ToUnit			=(String)hmParams.get("range5ToUnit");
		String    range6Fr				=(String)hmParams.get("range_6_fr");
		String  range6FrUnit			=(String)hmParams.get("range6FrUnit");
		String    range6To				=(String)hmParams.get("range_6_to");
		String  range6ToUnit			=(String)hmParams.get("range6ToUnit");
		String    range7Fr				=(String)hmParams.get("range_7_fr");
		String  range7FrUnit			=(String)hmParams.get("range7FrUnit");
		String    range7To				=(String)hmParams.get("range_7_to");
		String  range7ToUnit			=(String)hmParams.get("range7ToUnit");
		String    range8Fr				=(String)hmParams.get("range_8_fr");
		String  range8FrUnit			=(String)hmParams.get("range8FrUnit");
		String    range8To				=(String)hmParams.get("range_8_to");
		String  range8ToUnit			=(String)hmParams.get("range8ToUnit");
		String    range9Fr				=(String)hmParams.get("range_9_fr");
		String  range9FrUnit			=(String)hmParams.get("range9FrUnit");
		String    range9To				=(String)hmParams.get("range_9_to");
		String  range9ToUnit			=(String)hmParams.get("range9ToUnit");
		String    range10Fr				=(String)hmParams.get("range_10_fr");
		String  range10FrUnit			=(String)hmParams.get("range10FrUnit");
		String    range10To				=(String)hmParams.get("range_10_to");
		String  range10ToUnit			=(String)hmParams.get("range10ToUnit");
		String    range11Fr				=(String)hmParams.get("range_11_fr");
		String  range11FrUnit			=(String)hmParams.get("range11FrUnit");
		String    range11To				=(String)hmParams.get("range_11_to");
		String  range11ToUnit			=(String)hmParams.get("range11ToUnit");
		String    range12Fr				=(String)hmParams.get("range_12_fr");
		String  range12FrUnit			=(String)hmParams.get("range12FrUnit");
		String    range12To				=(String)hmParams.get("range_12_to");
		String  range12ToUnit			=(String)hmParams.get("range12ToUnit");
		String    range13Fr				=(String)hmParams.get("range_13_fr");
		String  range13FrUnit			=(String)hmParams.get("range13FrUnit");
		String    range13To				=(String)hmParams.get("range_13_to");
		String  range13ToUnit			=(String)hmParams.get("range13ToUnit");
		String    range14Fr				=(String)hmParams.get("range_14_fr");
		String  range14FrUnit			=(String)hmParams.get("range14FrUnit");
		String    range14To				=(String)hmParams.get("range_14_to");
		String  range14ToUnit			=(String)hmParams.get("range14ToUnit");
		String    range15Fr				=(String)hmParams.get("range_15_fr");
		String  range15FrUnit			=(String)hmParams.get("range15FrUnit");
		String    range15To				=(String)hmParams.get("range_15_to");
		String  range15ToUnit			=(String)hmParams.get("range15ToUnit");
		String    range16Fr				=(String)hmParams.get("range_16_fr");
		String  range16FrUnit			=(String)hmParams.get("range16FrUnit");
		String    range16To				=(String)hmParams.get("range_16_to");
		String  range16ToUnit			=(String)hmParams.get("range16ToUnit");
		String    range17Fr				=(String)hmParams.get("range_17_fr");
		String  range17FrUnit			=(String)hmParams.get("range17FrUnit");
		String    range17To				=(String)hmParams.get("range_17_to");
		String  range17ToUnit			=(String)hmParams.get("range17ToUnit");
		String    range18Fr				=(String)hmParams.get("range_18_fr");
		String  range18FrUnit			=(String)hmParams.get("range18FrUnit");
		String    range18To				=(String)hmParams.get("range_18_to");
		String  range18ToUnit			=(String)hmParams.get("range18ToUnit");
		String    range19Fr				=(String)hmParams.get("range_19_fr");
		String  range19FrUnit			=(String)hmParams.get("range19FrUnit");
		String    range19To				=(String)hmParams.get("range_19_to");
		String  range19ToUnit			=(String)hmParams.get("range19ToUnit");
		String    range20Fr				=(String)hmParams.get("range_20_fr");
		String  range20FrUnit			=(String)hmParams.get("range20FrUnit");
		String    range20To				=(String)hmParams.get("range_20_to");
		String  range20ToUnit			=(String)hmParams.get("range20ToUnit");
		String    range21Fr				=(String)hmParams.get("range_21_fr");
		String  range21FrUnit			=(String)hmParams.get("range21FrUnit");
		String    range21To				=(String)hmParams.get("range_21_to");
		String  range21ToUnit			=(String)hmParams.get("range21ToUnit");
		String    range22Fr				=(String)hmParams.get("range_22_fr");
		String  range22FrUnit			=(String)hmParams.get("range22FrUnit");
		String    range22To				=(String)hmParams.get("range_22_to");
		String  range22ToUnit			=(String)hmParams.get("range22ToUnit");
		String    range23Fr				=(String)hmParams.get("range_23_fr");
		String  range23FrUnit			=(String)hmParams.get("range23FrUnit");
		String    range23To				=(String)hmParams.get("range_23_to");
		String  range23ToUnit			=(String)hmParams.get("range23ToUnit");
		String    range24Fr				=(String)hmParams.get("range_24_fr");		
		String  range24FrUnit			=(String)hmParams.get("range24FrUnit");
		String    range24To				=(String)hmParams.get("range_24_to");
		String  range24ToUnit			=(String)hmParams.get("range24ToUnit");
		String    range25Fr				=(String)hmParams.get("range_25_fr");
		String  range25FrUnit			=(String)hmParams.get("range25FrUnit");
		String    range25To				=(String)hmParams.get("range_25_to");
		String  range25ToUnit			=(String)hmParams.get("range25ToUnit");
		String	effectiveDateFrom		=(String)hmParams.get("effectiveDateFrom");
		String	effectiveDateTo			=(String)hmParams.get("effectiveDateTo");
		String	effectiveStatus			=(String)hmParams.get("effectiveStatus");
		String	modifiedFacilityId		=(String)hmParams.get("facilityId");
		String	modifiedAtWorkstation	=(String)hmParams.get("client_ip_address");
		String locale="";
		locale= p.getProperty("LOCALE");
		hmParams.clear();
						
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sql = new StringBuffer("");
		try
		{
			sql.append("update am_summ_range set " );
			sql.append(" long_desc				 	= ?, " );
			sql.append(" short_desc			 	= ?, " );
			sql.append(" no_of_ranges			 	= ?, ");
			sql.append(" range_1_fr		 		= ?, " );
			sql.append(" range_1_fr_unit	 		= ?, " );
			sql.append(" range_1_to		 		= ?, " );
			sql.append(" range_1_to_unit			= ?, " );
			sql.append(" range_2_fr		 		= ?, " );
			sql.append(" range_2_fr_unit	 		= ?, " );
			sql.append(" range_2_to		 		= ?, " );
			sql.append(" range_2_to_unit			= ?, " );
			sql.append(" range_3_fr		 		= ?, " );
			sql.append(" range_3_fr_unit	 		= ?, " );
			sql.append(" range_3_to		 		= ?, " );
			sql.append(" range_3_to_unit			= ?, " );
			sql.append(" range_4_fr		 		= ?, " );
			sql.append(" range_4_fr_unit	 		= ?, " );
			sql.append(" range_4_to		 		= ?, " );
			sql.append(" range_4_to_unit			= ?, " );
			sql.append(" range_5_fr		 		= ?, " );
			sql.append(" range_5_fr_unit	 		= ?, " );
			sql.append(" range_5_to		 		= ?, " );
			sql.append(" range_5_to_unit			= ?, " );
			sql.append(" range_6_fr		 		= ?, " );
			sql.append(" range_6_fr_unit	 		= ?, " );
			sql.append(" range_6_to		 		= ?, " );
			sql.append(" range_6_to_unit			= ?, " );
			sql.append(" range_7_fr =?, 	range_7_fr_unit =? ,"	  );
			sql.append(" range_7_to =? ,	range_7_to_unit= ? ,"	  );
			sql.append(" range_8_fr=? , 	range_8_fr_unit= ?,"	 );
			sql.append(" range_8_to= ?,	range_8_to_unit =? ,"	  );
			sql.append(" range_9_fr=? , 	range_9_fr_unit=? ,"	  );
			sql.append(" range_9_to=? ,	range_9_to_unit=? ,"	  );
			sql.append(" range_10_fr=? , 	range_10_fr_unit=? ,"	 );
			sql.append(" range_10_to=? ,	range_10_to_unit=? ,"	  );
			sql.append(" range_11_fr=?, 	range_11_fr_unit=? ,"	  );
			sql.append(" range_11_to=? ,	range_11_to_unit=? ,"	 );
			sql.append(" range_12_fr=? , 	range_12_fr_unit=?,"	  );
			sql.append(" range_12_to=?,	range_12_to_unit=? ,"	  );
			sql.append(" range_13_fr=?, 	range_13_fr_unit =?,"	  );
			sql.append(" range_13_to =?,	range_13_to_unit =?,"	  );
			sql.append(" range_14_fr=?, 	range_14_fr_unit =?,"	 );
			sql.append(" range_14_to =?,	range_14_to_unit =?,"	  );
			sql.append(" range_15_fr =?, 	range_15_fr_unit =?,"	  );
			sql.append(" range_15_to =?,	range_15_to_unit =?,"	  );
			sql.append(" range_16_fr =?, 	range_16_fr_unit=?,"	 );
			sql.append(" range_16_to =?,	range_16_to_unit =?,"	  );
			sql.append(" range_17_fr =?, 	range_17_fr_unit =?,"	  );
			sql.append(" range_17_to =?,	range_17_to_unit =?,"	  );
			sql.append(" range_18_fr =?, 	range_18_fr_unit =?,"	  );
			sql.append(" range_18_to =?,	range_18_to_unit =?,"	  );
			sql.append(" range_19_fr =?, 	range_19_fr_unit =?,"	  );
			sql.append(" range_19_to =?,	range_19_to_unit =?,"	  );
			sql.append(" range_20_fr =?, 	range_20_fr_unit=?,"	  );
			sql.append(" range_20_to=?,	range_20_to_unit=?,"	  );
			sql.append(" range_21_fr=?, 	range_21_fr_unit =?,"	  );
			sql.append(" range_21_to =?,	range_21_to_unit =?,"	  );
			sql.append(" range_22_fr =?, 	range_22_fr_unit =?,"	  );
			sql.append(" range_22_to=?,	range_22_to_unit=?,"	  );
			sql.append(" range_23_fr=?, 	range_23_fr_unit=?,"	  );
			sql.append(" range_23_to=?,	range_23_to_unit=?,"	  );
			sql.append(" range_24_fr=?, 	range_24_fr_unit=?,"	  );
			sql.append(" range_24_to=?,	range_24_to_unit=?,"	  );
			sql.append(" range_25_fr=?, 	range_25_fr_unit=?,"	  );
			sql.append(" range_25_to=?,	range_25_to_unit=?,"	  );
			sql.append(" eff_date_from				= ?, " );
			sql.append(" eff_date_to				= ?, " );
			sql.append(" eff_status				= ?, " );
			sql.append(" modified_by_id			= ?, " );
			sql.append(" modified_date				= sysdate, " );
			sql.append(" modified_facility_id		= ?, " );
			sql.append(" modified_at_ws_no 		= ?  " );
			sql.append(" where	range_type		 	= ?  " );
			sql.append(" and range_id				= ?  ");

		String modifiedById = p.getProperty( "login_user" ) ;
		java.sql.Date effective_date_from = null ;
		java.sql.Date effective_date_to = null ;

		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
			effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;

		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
			effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;

		if ( updatable )
			{
			try {
				con=ConnectionManager.getConnection(p);

				pstmt = con.prepareStatement( sql.toString() );
				pstmt.setString	( 1,  longDesc  ) ;
				pstmt.setString	( 2,  shortDesc  ) ;
				pstmt.setInt	( 3,  noOfRanges  ) ;
				pstmt.setString	( 4,  range1Fr  ) ;
				pstmt.setString	( 5,  range1FrUnit  ) ;
				pstmt.setString	( 6,  range1To  ) ;
				pstmt.setString	( 7,  range1ToUnit  ) ;
				pstmt.setString	( 8,  range2Fr  ) ;
				pstmt.setString	( 9,  range2FrUnit ) ;
				pstmt.setString	( 10, range2To ) ;
				pstmt.setString	( 11, range2ToUnit  ) ;
				pstmt.setString	( 12, range3Fr  ) ;
				pstmt.setString	( 13, range3FrUnit ) ;
				pstmt.setString	( 14, range3To ) ;
				pstmt.setString	( 15, range3ToUnit  ) ;
				pstmt.setString	( 16, range4Fr  ) ;
				pstmt.setString	( 17, range4FrUnit ) ;
				pstmt.setString	( 18, range4To ) ;
				pstmt.setString	( 19, range4ToUnit  ) ;
				pstmt.setString	( 20, range5Fr  ) ;
				pstmt.setString	( 21, range5FrUnit ) ;
				pstmt.setString	( 22, range5To ) ;
				pstmt.setString	( 23, range5ToUnit  ) ;
				pstmt.setString	( 24, range6Fr  ) ;
				pstmt.setString	( 25, range6FrUnit ) ;
				pstmt.setString	( 26, range6To ) ;
				pstmt.setString	( 27, range6ToUnit  ) ;
				pstmt.setString	( 28, range7Fr  ) ;
				pstmt.setString	( 29, range7FrUnit  ) ;
				pstmt.setString	( 30, range7To ) ;
				pstmt.setString	( 31, range7ToUnit  ) ;
				pstmt.setString	( 32, range8Fr  ) ;
				pstmt.setString	( 33, range8FrUnit  ) ;
				pstmt.setString	( 34, range8To ) ;
				pstmt.setString	( 35, range8ToUnit  ) ;
				pstmt.setString	( 36, range9Fr  ) ;
				pstmt.setString	( 37, range9FrUnit  ) ;
				pstmt.setString	( 38, range9To ) ;
				pstmt.setString	( 39, range9ToUnit  ) ;
				pstmt.setString	( 40, range10Fr  ) ;
				pstmt.setString	( 41, range10FrUnit  ) ;
				pstmt.setString	( 42, range10To ) ;
				pstmt.setString	( 43, range10ToUnit  ) ;
				pstmt.setString	( 44, range11Fr  ) ;
				pstmt.setString	( 45, range11FrUnit  ) ;
				pstmt.setString	( 46, range11To ) ;
				pstmt.setString	( 47, range11ToUnit  ) ;
				pstmt.setString	( 48, range12Fr  ) ;
				pstmt.setString	( 49, range12FrUnit  ) ;
				pstmt.setString	( 50, range12To ) ;
				pstmt.setString	( 51, range12ToUnit  ) ;
				pstmt.setString	( 52, range13Fr  ) ;
				pstmt.setString	( 53, range13FrUnit  ) ;
				pstmt.setString	( 54, range13To ) ;
				pstmt.setString	( 55, range13ToUnit  ) ;
				pstmt.setString	( 56, range14Fr  ) ;
				pstmt.setString	( 57, range14FrUnit  ) ;
				pstmt.setString	( 58, range14To ) ;
				pstmt.setString	( 59, range14ToUnit  ) ;
				pstmt.setString	( 60 ,range15Fr  ) ;
				pstmt.setString	( 61, range15FrUnit  ) ;
				pstmt.setString	( 62, range15To ) ;
				pstmt.setString	( 63, range15ToUnit  ) ;
				pstmt.setString	( 64, range16Fr  ) ;
				pstmt.setString	( 65, range16FrUnit  ) ;
				pstmt.setString	( 66, range16To ) ;
				pstmt.setString	( 67, range16ToUnit  ) ;
				pstmt.setString	( 68, range17Fr  ) ;
				pstmt.setString	( 69, range17FrUnit  ) ;
				pstmt.setString	( 70, range17To ) ;
				pstmt.setString	( 71, range17ToUnit  ) ;
				pstmt.setString	( 72, range18Fr  ) ;
				pstmt.setString	( 73, range18FrUnit  ) ;
				pstmt.setString	( 74, range18To ) ;
				pstmt.setString	( 75, range18ToUnit  ) ;
				pstmt.setString	( 76, range19Fr  ) ;
				pstmt.setString	( 77, range19FrUnit  ) ;
				pstmt.setString	( 78, range19To ) ;
				pstmt.setString	( 79, range19ToUnit  ) ;
				pstmt.setString	( 80, range20Fr  ) ;
				pstmt.setString	( 81, range20FrUnit  ) ;
				pstmt.setString	( 82, range20To ) ;
				pstmt.setString	( 83, range20ToUnit  ) ;
				pstmt.setString	( 84, range21Fr  ) ;
				pstmt.setString	( 85, range21FrUnit  ) ;
				pstmt.setString	( 86, range21To ) ;
				pstmt.setString	( 87, range21ToUnit  ) ;
				pstmt.setString	( 88, range22Fr  ) ;
				pstmt.setString	( 89, range22FrUnit  ) ;
				pstmt.setString	( 90, range22To ) ;
				pstmt.setString	( 91, range22ToUnit  ) ;
				pstmt.setString	( 92, range23Fr  ) ;
				pstmt.setString	( 93, range23FrUnit  ) ;
				pstmt.setString	( 94, range23To ) ;
				pstmt.setString	( 95, range23ToUnit  ) ;
				pstmt.setString	( 96, range24Fr  ) ;
				pstmt.setString	( 97, range24FrUnit  ) ;
				pstmt.setString	( 98, range24To ) ;
				pstmt.setString	( 99, range24ToUnit  ) ;
				pstmt.setString	( 100, range25Fr  ) ;
				pstmt.setString	( 101, range25FrUnit  ) ;
				pstmt.setString	( 102, range25To ) ;
				pstmt.setString	( 103, range25ToUnit  ) ;
				pstmt.setDate	( 104, effective_date_from  ) ;
				pstmt.setDate	( 105, effective_date_to  ) ;
				pstmt.setString	( 106, effectiveStatus ) ;
				pstmt.setString	( 107, modifiedById ) ;
				pstmt.setString	( 108, modifiedFacilityId ) ;
				pstmt.setString	( 109, modifiedAtWorkstation ) ;
				pstmt.setString	( 110, rangeType ) ;
				pstmt.setString	( 111, rangeId ) ;

				int res = pstmt.executeUpdate() ;

				if ( res != 0 )
				{
					result = true ;
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();

				}

				pstmt.close() ;
			} 
			catch ( Exception e )
			{
				try
				  {
					con.rollback();
			      }
				   catch(Exception ce)
					   {}
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;

			//
				
			
			if ( con != null )
				//	{
					//	try {
							con.close() ;
						//	} 
						//catch( Exception ce ) {}
					//}
			}
				sql.setLength(0);
		}
				
		}
		catch(Exception eee)
		{}
		finally
		{	
			
			if(con != null)     ConnectionManager.returnConnection(con,p);

		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}

