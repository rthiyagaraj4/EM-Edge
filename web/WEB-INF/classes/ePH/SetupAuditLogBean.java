/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class SetupAuditLogBean extends PhAdapter implements Serializable 
{

	private String pk_value				= "";



	 public SetupAuditLogBean() 
	 {
        try 
		{
            doCommon();
        }
        catch(Exception e) 
    	{
           System.err.println("Error in Constructor"+e.toString()); e.printStackTrace();
		}
    }

	
	private void doCommon() throws Exception 
	{
	}

	public void clear() {
		pk_value = "";
		super.clear() ;
	}
	public void setpk_value(String pk_value) {
		this.pk_value	=	pk_value;
	}	
	public String getpk_value() {
		return this.pk_value;
	}

	public String ShowAuditLogYN(String table_id,ArrayList pk_values)throws Exception{
		String Show_Audit_Log_Button_YN	= "";
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;

		StringBuffer strBuffer			= new StringBuffer("");
		pk_value					    = "";
		int pk_value_size				= 0;
        try {
			//code for building pk_value by concatnation of all primarykey values  separated by "|" 
			 pk_value_size =pk_values.size();
			  for(int i=0;i<pk_value_size;i++){				 
				  if((pk_value_size -1) ==i){
					  strBuffer.append(pk_values.get(i));
				  }else{
					  strBuffer.append(pk_values.get(i));
					  strBuffer.append("|");
				  }
			  }	
              pk_value		=	strBuffer.toString();  
			

			  connection	= getConnection() ;
		      pstmt			= connection.prepareStatement( PhRepository.getPhKeyValue("PH_SETUP_LOG_SELECT1") ) ;
			  pstmt.setString(1,table_id);
			  pstmt.setString(2,pk_value);
		      resultSet = pstmt.executeQuery() ;
                if( resultSet != null && resultSet.next() ) {
					Show_Audit_Log_Button_YN   =  resultSet.getString("view_log_yn"); 				
			    }
		}
        catch ( Exception e ) {
            System.err.println( "ShowAuditLogYN:Error loading values from database" ) ;
            e.printStackTrace() ;
            throw e ;
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
		return Show_Audit_Log_Button_YN;
  }



  public ArrayList getHeadervalues(String table_id,String pkey_value)throws Exception{
		
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null ;
		ArrayList header_values	= new ArrayList();				
		//StringBuffer strBuffer	= new StringBuffer("");
		//int pk_value_size		= 0;
        try {
			
			  connection	= getConnection() ;
		      pstmt			= connection.prepareStatement( PhRepository.getPhKeyValue("PH_SETUP_LOG_SELECT3") ) ;
			  pstmt.setString(1,table_id);
			  pstmt.setString(2,pkey_value);
		      resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
				header_values.add(resultSet.getString("modified_date"));
				header_values.add(resultSet.getString("log_id")); 
				header_values.add(resultSet.getString("appl_user_name"));
				header_values.add(resultSet.getString("facility_name"));
				header_values.add(resultSet.getString("modified_at_ws_no"));
			//	result.add(resultSet.getString("modified_facility_id") );
			//	result.add(resultSet.getString("modified_by_id") );

			}
		}
        catch ( Exception e ) {
            System.err.println( "getHeadervalues :Error loading values from database" ) ;
            e.printStackTrace() ;
            throw e ;
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
		return header_values;
  }


public ArrayList getDetailvalues(String table_id,String log_id)throws Exception{
		
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null ;
		ArrayList detail_values	= new ArrayList();				
		//StringBuffer strBuffer	= new StringBuffer("");
		//int pk_value_size		= 0;
        try {
			
			  connection	= getConnection() ;
		      pstmt			= connection.prepareStatement( PhRepository.getPhKeyValue("PH_SETUP_LOG_SELECT2") ) ;
			
			  pstmt.setString(1,log_id);
			  pstmt.setString(2,table_id);
		      resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
				detail_values.add(resultSet.getString("main_legend_key"));
				detail_values.add(resultSet.getString("main_legend_desc"));
				//detail_values.add(resultSet.getString("legend_option_key_new"));
				detail_values.add(resultSet.getString("legend_option_key_new")==null?"":resultSet.getString("legend_option_key_new"));
				//detail_values.add(resultSet.getString("legend_option_desc_new"));
				detail_values.add(resultSet.getString("legend_option_desc_new")==null?"":resultSet.getString("legend_option_desc_new"));
				detail_values.add(resultSet.getString("legend_option_key_old")==null?"":resultSet.getString("legend_option_key_old"));
				//detail_values.add(resultSet.getString("legend_option_key_old"));
				detail_values.add(resultSet.getString("legend_option_desc_old")==null?"":resultSet.getString("legend_option_desc_old"));
				//detail_values.add(resultSet.getString("legend_option_desc_old"));
				detail_values.add(resultSet.getString("option_type"));
				detail_values.add(resultSet.getString("column_value_old")==null?"":resultSet.getString("column_value_old"));
				detail_values.add(resultSet.getString("column_value_new")==null?"":resultSet.getString("column_value_new"));
		
			}
		}
        catch ( Exception e ) {
          
            e.printStackTrace() ;
			  System.err.println( "getDetailvalues :Error loading values from database" +e) ;

            throw e ;
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
		return detail_values;
  }

}
 
