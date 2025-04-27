/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created		
08/11/2012    		 	     Ramesh       ML-Bru-HIMS-CRF-032
01/08/2013    IN042027		 Chowminya G  Catalog Name Does Not Display In Refusal Form For Catalogs Which Does Not Have A Consent Attached
-----------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;
import eOR.Common.* ;
import eCommon.Common.*;

public class InterventionOrdersBean extends OrAdapter implements java.io.Serializable 
{
	public String getInterventionFormContent(String patient_id, String encounter_id, String facility_id,String intervention_id,String consentform_id)
	{
 
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String text ="";
		if(patient_id==null)  patient_id		= ""; else patient_id = patient_id.trim();
		if(encounter_id==null)  encounter_id	= ""; else encounter_id = encounter_id.trim();
		if(intervention_id==null)  intervention_id	= ""; else intervention_id = intervention_id.trim();

        try
        {
			
            connection = getConnection(); 
           
 			preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_INTERVENTION_CONTENT_SELECT"));
 
			preparedstatement.setString(1,consentform_id.trim());
			
			resultset = preparedstatement.executeQuery();
            while ( resultset != null && resultset.next() )
			{
			
				java.sql.Clob consent_form_content = resultset.getClob("consent_form_content");
				
				if(consent_form_content!=null && consent_form_content.length() > 0)
						text = consent_form_content.getSubString(1,( (int)consent_form_content.length() ));
				if(text!=null && !text.equals("") ) 
				{ 
					//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, "", "E",  text, intervention_id);//consent_format --> 'E' Editor, catalog_description=orderable
					text		= getMnemonicDetails(patient_id, facility_id, encounter_id, "", "E",  text, intervention_id, ""); //IN042027 
					
				}
			}
		}
        catch(Exception exception)
        {
		
            exception.printStackTrace();
        
        }
        finally
        {
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
        }
        return text;
	}


}
