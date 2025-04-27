/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blutil;
import java.sql.* ;
import java.util.*;
public class BLHealthScheme
{
	public Hashtable getHealthSchemeDetails (java.util.Properties properties,
				Connection con,
				java.util.Hashtable hashtableBL)
	{
		String strPatBlngGrp = "";
		String strMessageDesc = "";
		String strHcardApplicableYN = "";
		String strHcareApplicableYN = "";
		String strHcardSchemeId = "";
		String strHcareSchemeId = "";
		String strHcardExpiredYN = "";
		String strHcareExpiredYN = "";
		String strDfltBillingGroup = "";
		String strDfltBillingGroupDesc = "";
		String strPreviousBlngGrp = "";
		String strPreviousBlngGrpDesc = "";
		String strHcardPrerequisite_yn = "";
		String strSpecialSchemeBlngGrp = "";
		String strSpecialSchemeBlngGrpDesc = "";
		String strSchemeType = "";
		String strErrorText = "";
		
		Hashtable returnHashtableBL = new Hashtable();
		
		try
		{
			CallableStatement call = con.prepareCall("{ call blcommon.GET_HEALTH_SCHEME_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
			call.setString(1,(String) hashtableBL.get("patient_id"));
			call.setString(2,(String) hashtableBL.get("facility_id"));
			call.registerOutParameter(3,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
			call.registerOutParameter(4,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
			call.registerOutParameter(5,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
			call.registerOutParameter(6,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
			call.registerOutParameter(7,java.sql.Types.VARCHAR); // p_hcard_expired_yn out varchar2,
			call.registerOutParameter(8,java.sql.Types.VARCHAR); // p_hcare_expired_yn out varchar2,
			call.registerOutParameter(9,java.sql.Types.VARCHAR); // p_dflt_blng_grp_for_hc out varchar2,
			call.registerOutParameter(10,java.sql.Types.VARCHAR); // p_dflt_blng_grp_for_hc_desc out varchar2,
			call.registerOutParameter(11,java.sql.Types.VARCHAR); // p_previous_blng_grp out varchar2,
			call.registerOutParameter(12,java.sql.Types.VARCHAR); // p_previous_blng_grp_desc out varchar2, 
			call.registerOutParameter(13,java.sql.Types.VARCHAR); // p_hcard_prerequisite_yn out varchar2,
			call.registerOutParameter(14,java.sql.Types.VARCHAR); // error text			call.execute();
			call.registerOutParameter(15,java.sql.Types.VARCHAR); // error text			call.execute();
			call.registerOutParameter(16,java.sql.Types.VARCHAR); // error text			call.execute();
			call.registerOutParameter(17,java.sql.Types.VARCHAR); // error text			call.execute();
			call.registerOutParameter(18,java.sql.Types.VARCHAR); // error text			call.execute();

			call.registerOutParameter(19,java.sql.Types.VARCHAR); // error text			call.execute();

			call.execute();

			strPatBlngGrp=call.getString(3);		// _hcard_scheme_id out varchar2,            
			strMessageDesc=call.getString(4);		// _hcare_scheme_id out varchar2,            
			strHcardApplicableYN =call.getString(5);		// _hcard applicable out varchar2,            
			strHcareApplicableYN =call.getString(6);		// _hcard applicable out varchar2,            
			strHcardSchemeId=call.getString(7);		// _hcard_scheme_id out varchar2,            
			strHcareSchemeId=call.getString(8);		// _hcare_scheme_id out varchar2,            
			strHcardExpiredYN=call.getString(9);	// p_hcard_expired_yn out varchar2,          
			strHcareExpiredYN=call.getString(10);	// p_hcare_expired_yn out varchar2,          
			strDfltBillingGroup = call.getString(11);			// p_dflt_blng_grp_for_hc out varchar2,     
			strDfltBillingGroupDesc = call.getString(12);		// p_dflt_blng_grp_for_hc_desc out varchar2,
			strPreviousBlngGrp = call.getString(13);				// p_previous_blng_grp out varchar2,         
			strPreviousBlngGrpDesc= call.getString(14);			// p_previous_blng_grp_desc out varchar2,    
			strHcardPrerequisite_yn= call.getString(15)	;		// p_hcard_prerequisite_yn out varchar2,     
			strSpecialSchemeBlngGrp=call.getString(16);		// _hcard_scheme_id out varchar2,            
			strSpecialSchemeBlngGrpDesc=call.getString(17);		// _hcare_scheme_id out varchar2,            
			strSchemeType = 	call.getString(18);					 // error text			call.execute();      
 			strErrorText = 	call.getString(19);					 // error text			call.execute();      
			
			if ((strHcardSchemeId == null) || ( strHcardSchemeId.equals("")) || ( strHcardSchemeId.equalsIgnoreCase("null")) )
			{ 
				strHcardSchemeId="";
			}

			if ((strHcareSchemeId == null) || ( strHcareSchemeId.equals("")) || ( strHcareSchemeId.equalsIgnoreCase("null")) )
			{ 
				strHcareSchemeId="";
			}

			if ((strHcardExpiredYN == null) || ( strHcardExpiredYN.equals("")) || ( strHcardExpiredYN.equalsIgnoreCase("null")) )
			{ 
				strHcardExpiredYN="";
			}

			if ((strHcareExpiredYN == null) || ( strHcareExpiredYN.equals("")) || ( strHcareExpiredYN.equalsIgnoreCase("null")) )
			{ 
				strHcareExpiredYN="";
			}

			if ((strDfltBillingGroup == null) || ( strDfltBillingGroup.equals("")) || ( strDfltBillingGroup.equalsIgnoreCase("null")) )
			{ 
				strDfltBillingGroupDesc="";
			}

			if ((strPreviousBlngGrp  == null) || ( strPreviousBlngGrp.equals("")) || ( strPreviousBlngGrp.equalsIgnoreCase("null")) )
			{ 
				strPreviousBlngGrp ="";
				strPreviousBlngGrpDesc="";

			}

			if ((strHcardPrerequisite_yn == null) || ( strHcardPrerequisite_yn.equals("")) || ( strHcardPrerequisite_yn.equalsIgnoreCase("null")) )
			{ 
				strHcardPrerequisite_yn  ="";
			}

			if ((strHcardApplicableYN  == null) || ( strHcardApplicableYN.equals("")) || ( strHcardApplicableYN.equalsIgnoreCase("null")) )
			{ 
				strHcardApplicableYN ="";


			}

			if ((strHcareApplicableYN  == null) || ( strHcareApplicableYN.equals("")) || ( strHcareApplicableYN.equalsIgnoreCase("null")) )
			{ 
				strHcareApplicableYN ="";


			}

			if ((strSpecialSchemeBlngGrp== null) || ( strSpecialSchemeBlngGrp.equals("")) || ( strSpecialSchemeBlngGrp.equalsIgnoreCase("null")) )
			{ 
				strSpecialSchemeBlngGrp ="";
				strSpecialSchemeBlngGrpDesc="";

			}
			if ((strMessageDesc== null) || ( strMessageDesc.equals("")) || ( strMessageDesc.equalsIgnoreCase("null")) )
			{ 
				strMessageDesc ="";
			}
			call.close();
			returnHashtableBL.put("PatBlngGrp",strPatBlngGrp);
			returnHashtableBL.put("MessageDesc",strMessageDesc);
			returnHashtableBL.put("HcardApplicableYN",strHcardApplicableYN);
			returnHashtableBL.put("HcareApplicableYN",strHcareApplicableYN);
			returnHashtableBL.put("HcardSchemeId",strHcardSchemeId);
			returnHashtableBL.put("HcareSchemeId",strHcareSchemeId);
			returnHashtableBL.put("HcardExpiredYN",strHcardExpiredYN);
			returnHashtableBL.put("HcareExpiredYN",strHcareExpiredYN);
			returnHashtableBL.put("DfltBillingGroup",strDfltBillingGroup);
			returnHashtableBL.put("DfltBillingGroupDesc",strDfltBillingGroupDesc);
			returnHashtableBL.put("PreviousBlngGrp",strPreviousBlngGrp);
			returnHashtableBL.put("PreviousBlngGrpDesc",strPreviousBlngGrpDesc);
			returnHashtableBL.put("HcardPrerequisite_yn",strHcardPrerequisite_yn);
			returnHashtableBL.put("SpecialSchemeBlngGrp",strSpecialSchemeBlngGrp);
			returnHashtableBL.put("SpecialSchemeBlngGrpDesc",strSpecialSchemeBlngGrpDesc);
			returnHashtableBL.put("SchemeType",strSchemeType);
			returnHashtableBL.put("ErrorText",strErrorText);
 
			
		}
		catch(Exception e)
		{
			
		}
			return (returnHashtableBL);
	}
}
