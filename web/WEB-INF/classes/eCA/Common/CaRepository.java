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
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/12/2021	25408			Ramesh Goli		21/04/2021		RAMESH G		ML-BRU-CRF-0629.4
----------------------------------------------------------------------------------------------------------------------------------------------------------	
*/

package eCA.Common ;
import java.util.* ;
public class CaRepository {
		//private static OrRepository instance ;
		private static int i=0;
		private static HashMap<String,String> dataMap ;

		public static final int DISPLAY_MIN_RECORDS = 8;
		public static final int DISPLAY_RECORDS 	= 36;
		public static final int DISPLAY_EQ_RECORDS 	= 12;
		public static final int DISPLAY_MAX_RECORDS = 44;
		public static final int SHOW_MODAL_WINDOW   = 1;
		static{
			dataMap = new HashMap<String,String>() ;
			load() ;
		}
		public int getSqlSize(){
			return dataMap.size();
		}

		public static String getOrKeyValue( String key ) throws Exception{
 				return (getValue(key.trim().toUpperCase()));
		}

		public static int getI(){
			return i;
		}

		private static String getValue( String key ) throws Exception{
		 String value = "" ;

			try
				{
				value = (String) dataMap.get(key) ;

				if ( value == null )
				throw new Exception( key + " : Key not found" ) ;
				}
				catch ( Exception e )
				{
				throw new Exception( key + " : Key not found" ) ;
				}

			return value ;
		}

		protected void finalize() throws Throwable{
			if ( dataMap != null )
            dataMap = null ;
			}

		private static void load(){
		
			dataMap.put("SQL_SPECIALITY_LOOKUP_SELECT","Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2");
			dataMap.put("SQL_PRACTITIONERWITHFACILITY_SPECIALITY_LOOKUP_SELECT","select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b,am_practitioner c where b.practitioner_id = a.func_role_id and b.practitioner_id = c.practitioner_id and c.eff_status='E' and b.operating_facility_id ='~FACILITY_ID`' and b.primary_speciality_code='~SPECIALITY_ID`' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2");
			dataMap.put("SQL_PRACTITIONERWITHFACILITY_LOOKUP_SELECT","select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b,am_practitioner c where b.practitioner_id = a.func_role_id and b.practitioner_id = c.practitioner_id and c.eff_status='E' and b.operating_facility_id ='~FACILITY_ID`' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2");
		
			dataMap.put("SQL_CODER_ATTENDING_SELECT","Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '~FACILITY_ID`' and a.practitioner_id = b.practitioner_id   and a.eff_status = b.eff_status and b.language_id = '~LANGUAGE_ID`' and a.eff_status = 'E' and upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name");
			dataMap.put("SQL_CODER_CLINIC_SELECT","Select code , description from (SELECT CLINIC_CODE CODE,LONG_DESC DESCRIPTION FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID='~LANGUAGE_ID`' AND EFF_STATUS='E' UNION SELECT  NURSING_UNIT_CODE CODE,LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='~LANGUAGE_ID`' AND  EFF_STATUS='E')WHERE  upper(code) like upper(?) and upper(description) like upper(?) order by 2");
			dataMap.put("SQL_CODER_BILLING_GROUP_SELECT", "SELECT blng_grp_id code, group_desc description FROM (SELECT blng_grp_id, long_desc group_desc   FROM bl_blng_grp_lang_vw  WHERE language_id = NVL ('~LANGUAGE_ID`', 'en') AND NVL (status, '#') <> 'S'  and blng_grp_id!='**') where upper(blng_grp_id) like upper(?) and upper(group_desc) like upper(?) order by 2");
			dataMap.put("SQL_CODER_CUSTOMERORPAYER_GROUP_SELECT", "SELECT cust_group_code code, group_desc description  FROM (SELECT cust_group_code, long_desc group_desc FROM ar_cust_group_lang_vw WHERE language_id =  '~LANGUAGE_ID`'   AND NVL (status, '#') <> 'S') where upper(cust_group_code) like upper(?) and upper(group_desc) like upper(?) order by 2");
			dataMap.put("SQL_CODER_CUSTOMERORPAYER_SELECT", "SELECT cust_code code, cust_desc description  FROM (SELECT cust_code, long_name cust_desc FROM ar_customer_lang_vw WHERE language_id = '~LANGUAGE_ID`'  AND NVL (status, '#') <> 'S' AND cust_group_code = NVL ('~CUSTOMER_GROUP_ID`', cust_group_code)) where upper(cust_code) like upper(?) and upper(cust_desc) like upper(?) order by 2");
			dataMap.put("SQL_CODER_POLICY_SELECT", "SELECT policy_code code, policy_desc description FROM (SELECT DISTINCT a.policy_type_code policy_code, a.long_desc policy_desc FROM bl_ins_policy_types a, bl_ins_policy_type_hdr b WHERE a.operating_facility_id = b.operating_facility_id  AND a.policy_type_code = b.policy_type_code AND b.operating_facility_id = '~FACILITY_ID`'  AND b.cust_group_code = NVL ('~CUSTOMER_GROUP_ID`', b.cust_group_code) AND b.cust_code = NVL ('~CUSTOMER_ID`', b.cust_code) AND NVL (a.status, 'E') = 'E' )  where upper(policy_code) like upper(?) and upper(policy_desc) like upper(?) order by 2");
		}
}
