/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
23/03/2016	IN059763		Karthi L										Unable to view the Consent details after configured it.[ML-MMOH-SCF-0371]
---------------------------------------------------------------------------------------------------------
*/
package eOR;



//import eCommon.Common.CommonAdapter; 
import eCommon.Common.CommonRepository;
import eOR.Common.OrAdapter;
import eOR.Common.OrRepository;
//import eOR.ORConsentFormat.ORConsentFormHome;
//import eOR.ORConsentFormat.ORConsentFormRemote;
import eOR.ORConsentFormat.*;
//import java.io.PrintStream;
//import java.io.Serializable;
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;

public class ConsentFormat extends OrAdapter
    implements Serializable
{
    char[] ch;
	
    String id;
    String desc;
    //String descBrief;
    String eff_status;
	String consent_type;
	String Consent_form_label;
	String consent_values;
	String consent_format;
	String indexed;

    public ConsentFormat()
    {
        id = "";
        desc = "";
      //  descBrief = "";
        eff_status = "";
		consent_type = "";
		Consent_form_label = "";
		consent_values	= "";
		consent_format	= "";	
		indexed = "";
    }
	
	public void setConsentType(String type)
	{
		this.consent_type = type;
	}
	public void setConsentFormLabel(String type)
	{
		this.Consent_form_label = type;
	}
	public void setId(String s)
    {
        id = s;
    }

    public void setDesc(String s)
    {
        desc = s;
    }

    public void setEffectiveStatus(String s)
    {
        eff_status = s;
    }

	public void setConsentFormat(String consent_format)
	{
	   this.consent_format = consent_format;
	}
	public void setConsentValues(String consent_values)
	{
	   this.consent_values = consent_values;
	}
	public String getConsentValues()
	{      
	  return consent_values;
	}

	public String getConsentType()
	{
		return this.consent_type;
	}
	public String getConsentFormLabel()
	{
		return this.Consent_form_label;
	}
    public String getId()
    {
        return id;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getEffectiveStatus()
    {
        return eff_status;
    }

	public String getConsentFormat()
	{
		return this.consent_format;
	}

	public void setIndexed(String indexed)
	{
		this.indexed = indexed;
	}

	public String getIndexed()
	{
		return this.indexed;
	}

    public HashMap validate()
        throws Exception
    {
        //Object obj = null;
       // Object obj1 = null;
       // Object obj2 = null;
        HashMap hashmap = new HashMap();

        Connection connection 				= null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset					= null;

        hashmap.put("result", new Boolean(true));
        if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
        {
            connection = getConnection();
            try
            {
                preparedstatement = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORM_DUPLICATE"));
                preparedstatement.setString(1, id);
                resultset = preparedstatement.executeQuery();
                if(resultset != null && resultset.next())
                {
                    int i = resultset.getInt(1);
                    if(i > 0)
                    {
                        hashmap.put("result", new Boolean(false));
                        hashmap.put("message", "CODE_ALREADY_EXISTS");
						hashmap.put("message", getMessage(language_id, (String) hashmap.get( "message" ), "Common")) ;
                    } else
                    {
                        hashmap.put("result", new Boolean(true));
                        hashmap.put("message", "success..");
                    }
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
                hashmap.put("result", new Boolean(false));
                hashmap.put("message", exception);
                throw exception;
            }
            finally
            {
                try
                {
                    closeResultSet(resultset);
                    closeStatement(preparedstatement);
					closeConnection(connection);
                }
                catch(Exception exception2) {exception2.printStackTrace(); }
            }
        }
        return hashmap;
    }

    public String[] getDescription(String s)
        throws Exception
    {

        //String s1 = "";
        Connection connection 				= null;
        PreparedStatement preparedstatement	= null;
        ResultSet resultset					= null;
       // Object obj = null;
        //Object obj1 = null;
        String as[] = new String[6];
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORM_SELECT"));
            preparedstatement.setString(1, s);
            resultset = preparedstatement.executeQuery();
            resultset.next();
            as[0] = "";
            java.sql.Clob consent_form_content = resultset.getClob("consent_form_content");
            if(consent_form_content!=null && consent_form_content.length() > 0)
					as[0] = consent_form_content.getSubString(1,( (int)consent_form_content.length() ));
            as[1] = resultset.getString("eff_status");
			as[2] = resultset.getString("consent_type");
			as[3] = resultset.getString("Consent_form_label");
			as[4] = resultset.getString("consent_format");
			as[5] = resultset.getString("indexed_yn");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            closeResultSet(resultset);
            closeStatement(preparedstatement);
			closeConnection(connection);
        }
        return as;
    }
   public HashMap insert()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("result", new Boolean(false));
        HashMap hashmap1 = new HashMap();
        desc = desc.replace('\"','\n');
        hashmap1.put("desc", desc);
        hashmap1.put("id", id);
        hashmap1.put("eff_status", eff_status);
        hashmap1.put("added_by_id", super.login_by_id);
        hashmap1.put("added_at_ws_no", super.login_at_ws_no);
        hashmap1.put("added_facility_id", super.login_facility_id);
        hashmap1.put("modified_by_id", super.login_by_id);
        hashmap1.put("modified_facility_id", super.login_facility_id);
        hashmap1.put("modified_at_ws_no", super.login_at_ws_no);
		hashmap1.put("consent_type",consent_type);
		hashmap1.put("Consent_form_label",Consent_form_label);
		hashmap1.put("consent_format",consent_format);
		hashmap1.put("indexed",indexed);


        HashMap hashmap2 = new HashMap();
        try
        {
            hashmap2.put("SQL_OR_CONSENT_FORM_INSERT", OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORM_INSERT"));
            hashmap2.put("SQL_OR_CONSENT_FORM_UPDATE_CLOB", OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORM_UPDATE_CLOB"));
        }
        catch(Exception exception) { exception.printStackTrace();}
       // Object obj = null;
       // ORConsentFormRemote orconsentformremote = null;

        try
        {
			 hashmap1.put("properties", getProperties());

           /* InitialContext initialcontext = new InitialContext();
            Object obj1 = initialcontext.lookup(OrRepository.getOrKeyValue("CONSENT_FORMAT_JNDI"));
            ORConsentFormHome orconsentformhome = (ORConsentFormHome)PortableRemoteObject.narrow(obj1, eOR.ORConsentFormat.ORConsentFormHome.class);
           hashmap1.put("properties", getProperties());
            orconsentformremote = orconsentformhome.create();
           hashmap = orconsentformremote.insert(hashmap1, hashmap2);
			*/
		  
		  Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("CONSENT_FORMAT_JNDI"), ORConsentFormHome.class, getLocalEJB());
    	  Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


		  Object argArray[]	= new Object[2];
			argArray[0]		= hashmap1;
			argArray[1]		= hashmap2;
 		  Class [] paramArray = new Class[2];
 		 	paramArray[0]	= hashmap1.getClass();
			paramArray[1]	= hashmap2.getClass();
 		  hashmap = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
		  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
		  argArray		= null;
		  paramArray	= null;
		
		if( ((Boolean) hashmap.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					hashmap.put( "message", getMessage(language_id, (String) hashmap.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					hashmap.put( "message", getMessage(language_id, (String) hashmap.get( "message" ), "Common")) ;
				}
        }
        catch(Exception exception1)
        {

            hashmap.put("message", exception1.getMessage());
            exception1.printStackTrace();
        }
        finally
        {
            clear();
            /*try
            {
                if(orconsentformremote != null)
                    orconsentformremote.remove();
            }
            catch(Exception exception3)
            {

                hashmap.put("message", exception3.getMessage());
            }*/
        }
        return hashmap;
    }
 

    public HashMap modify()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("result", new Boolean(false));
        HashMap hashmap1 = new HashMap();
        desc = desc.replace('\"','\n');
        hashmap1.put("desc", desc);
        hashmap1.put("id",id);
        hashmap1.put("eff_status", eff_status);
		hashmap1.put("Consent_form_label",Consent_form_label);
		hashmap1.put("consent_format",consent_format);
		hashmap1.put("indexed",indexed);

        hashmap1.put("modified_by_id", super.login_by_id);
        hashmap1.put("modified_facility_id", super.login_facility_id);
        hashmap1.put("modified_at_ws_no", super.login_at_ws_no);

        HashMap hashmap2 = new HashMap();
        try
        {
            hashmap2.put("SQL_OR_CONSENT_FORM_UPDATE", OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORM_UPDATE"));
            hashmap2.put("SQL_OR_CONSENT_FORM_UPDATE_CLOB", OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORM_UPDATE_CLOB"));
        }
        catch(Exception exception) { exception.printStackTrace();}
       // Object obj = null;
       // ORConsentFormRemote orconsentformremote = null;
        try
        {
			hashmap1.put("properties", getProperties());

            /*InitialContext initialcontext = new InitialContext();
            Object obj1 = initialcontext.lookup(OrRepository.getOrKeyValue("CONSENT_FORMAT_JNDI"));
            ORConsentFormHome orconsentformhome = (ORConsentFormHome)PortableRemoteObject.narrow(obj1, eOR.ORConsentFormat.ORConsentFormHome.class);
            orconsentformremote = orconsentformhome.create();
            hashmap1.put("properties", getProperties());
            hashmap = orconsentformremote.modify(hashmap1, hashmap2);
			*/

 			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("CONSENT_FORMAT_JNDI"), ORConsentFormHome.class, getLocalEJB());
     		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
 			Object argArray[]	= new Object[2];
				argArray[0]		= hashmap1;
				argArray[1]		= hashmap2;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= hashmap1.getClass();
				paramArray[1]	= hashmap2.getClass();
  			hashmap = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
 			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
					argArray	= null;
					paramArray	= null;
			hashmap.put( "message", getMessage(language_id, (String) hashmap.get( "message" ), "SM")) ;
        }
        catch(Exception exception1)
        {

            hashmap.put("message", exception1.getMessage());
            exception1.printStackTrace();
        }
        finally
        {
            clear();
            /*try
            {
                if(orconsentformremote != null)
                    orconsentformremote.remove();
            }
            catch(Exception exception3)
            {

                hashmap.put("message", exception3.getMessage());
            }*/
        }
        return hashmap;
    }

    public void setAll(Hashtable hashtable)
    {
        if(hashtable.containsKey("consent_form_id"))
            setId((String)hashtable.get("consent_form_id"));
        if(hashtable.containsKey("consent_form_text"))
		{

			if((String)hashtable.get("consent_form_text")!=null && (  !((String)hashtable.get("consent_form_text")).equals("")))
	            setDesc((String)hashtable.get("consent_form_text"));
			else   // From the editor.
				setDesc(consent_values);

			if(hashtable.containsKey("Consent_form_label")) 
			{ 
				setConsentFormLabel((String)hashtable.get("Consent_form_label"));
			}
			if(hashtable.containsKey("effective_status"))
	        {
		        String s = (String)hashtable.get("effective_status");
			    if(!s.equals(""))
				    setEffectiveStatus("E");
	            else	
		            setEffectiveStatus("D");
			}
			if(hashtable.containsKey("consent_format"))
			{
				String consent_format = (String)hashtable.get("consent_format");
  				if(consent_format!= null)
					setConsentFormat(consent_format);
			}

			if(hashtable.containsKey("consent_type"))
			{
				String s = (String)hashtable.get("consent_type");
				if(s != null)
					setConsentType(s);
			}
			if(hashtable.containsKey("indexed"))
			{
				String s = (String)hashtable.get("indexed");
				if(s != null)
				{
					if(s.equals("")  || s.equals("N"))
						setIndexed("N");
					else
						setIndexed(s);
				}
			}

	   }
	}
    public void clear()
    {
        id = "";
        desc = "";
        eff_status = "";
		consent_type = "";
		consent_format = "";
		consent_values = "";
		Consent_form_label = "";
		indexed = "";
        super.clear();
    }
	//ML-MMOH-SCF-0371 [IN059763] - Start
	public int getTimeInterval() throws Exception {
		String selectSql = "";
		int time_interval = 0;
		Connection connection 			= null;
        PreparedStatement pStatement	= null;
        ResultSet resultSet				= null;
		try{
			selectSql = "SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM";
			connection = getConnection();
			pStatement = connection.prepareStatement(selectSql);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				time_interval			= Integer.parseInt(resultSet.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)resultSet.getString("NOTE_PRINT_TIME_INTERVAL"));
			}
		} catch(Exception ex) {
			System.out.println(" 469. Exception in ConsentFormat.java " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if(resultSet != null)  resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return time_interval;
	}
	//ML-MMOH-SCF-0371 [IN059763] - End
}