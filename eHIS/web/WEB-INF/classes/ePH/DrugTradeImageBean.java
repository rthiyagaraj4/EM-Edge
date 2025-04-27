/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  //This file is saved on 25/10/2005.
package ePH;

import java.io.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class DrugTradeImageBean  extends PhAdapter  {

	String drugyesno = "Y";
	String file_path = "";

	public String getDrugyesno()
	{
		return this.drugyesno;
	}

	public void setDrugyesno(String drugyesno)
	{
		this.drugyesno = drugyesno;
	}
	public String getFilePath()
	{
		return this.file_path;
	}

	public void setFilePath(String file_path)
	{
		this.file_path = file_path;
	}

	public String getImagePath(String drug_code, String trade_code ){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String fileName            = "";
	//	String fileName1            = "";  Removed for IN063877
		String str_qry = "";
		try{
			connection				= getConnection() ;
			if(file_path==null || file_path.equals("")){
				//String str_qry			= PhRepository.getPhKeyValue("");
				str_qry			= "SELECT ITEM_IMAGE_PATH FROM PH_PARAM WHERE MODULE_ID='PH'";
				
				pstmt					= connection.prepareStatement(str_qry) ;
				resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next())
					{
						file_path=resultSet.getString("ITEM_IMAGE_PATH")==null?"":resultSet.getString("ITEM_IMAGE_PATH");
					}
				
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;  
			}
            if(drugyesno.equals("")){
				str_qry			= "SELECT DRUG_YN FROM ph_drug WHERE drug_code=?";
				pstmt			= connection.prepareStatement(str_qry) ;
				pstmt.setString(1,drug_code);
				resultSet		= pstmt.executeQuery();
				pstmt.setString(1,drug_code);
				if(resultSet!=null && resultSet.next())
					{
						drugyesno  = resultSet.getString("DRUG_YN")==null?"":resultSet.getString("DRUG_YN");
					}

				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}

			if(drugyesno.equals("Y") ) //
			{ //
				if(!trade_code.equals("") && !drug_code.equals(""))
				{
					str_qry			= "SELECT trade_image_filename FROM PH_TRADE_NAME_FOR_DRUG WHERE drug_code=? AND trade_code=?";
					pstmt			= connection.prepareStatement(str_qry) ;
					pstmt.setString(1,drug_code);
					pstmt.setString(2,trade_code);
					resultSet		= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next())
					{
						fileName=resultSet.getString("TRADE_IMAGE_FILENAME")==null?"":resultSet.getString("TRADE_IMAGE_FILENAME");
					}
				
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}

				if((trade_code.equals("") || fileName.equals(""))&& !drug_code.equals(""))
				{
					str_qry			= "SELECT item_image_filename FROM ph_drug WHERE drug_code=?";
					pstmt			= connection.prepareStatement(str_qry) ;
					pstmt.setString(1,drug_code);
					resultSet		= pstmt.executeQuery();
					pstmt.setString(1,drug_code);
					if(resultSet!=null && resultSet.next())
						{
							fileName=resultSet.getString("ITEM_IMAGE_FILENAME")==null?"":resultSet.getString("ITEM_IMAGE_FILENAME");
						}

					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
			}
/*=============================================================================================================*/
			else // drugyesno="N"
			{
				if(!drug_code.equals(""))
				{
					str_qry			= "select IMAGE_FILE_NAME from st_item where item_code =?";
					pstmt			= connection.prepareStatement(str_qry) ;
					pstmt.setString(1,drug_code);
			
					resultSet		= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next())
						{
							fileName=resultSet.getString("IMAGE_FILE_NAME")==null?"":resultSet.getString("IMAGE_FILE_NAME");
						}
					
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
			}
/*=============================================================================================================*/
		}catch ( Exception e ) {
			//	System.err.println( "Error sys_date  :"+e ) ;
				e.printStackTrace() ;

		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
		}
		if(fileName.equals(""))
			return fileName;

		return file_path+fileName;
	}

		public String getImagePath(String drug_code, String trade_code, Connection connection){
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String fileName				= "";
		String str_qry ;
		try{
			//String str_qry			= PhRepository.getPhKeyValue("");
			if(file_path==null || file_path.equals("")){
				str_qry			= "SELECT ITEM_IMAGE_PATH FROM PH_PARAM WHERE MODULE_ID='PH'";
				pstmt					= connection.prepareStatement(str_qry) ;
				resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					file_path=resultSet.getString("ITEM_IMAGE_PATH")==null?"":resultSet.getString("ITEM_IMAGE_PATH");
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			if(!trade_code.equals("") && !drug_code.equals("")){
				str_qry			= "SELECT trade_image_filename FROM PH_TRADE_NAME_FOR_DRUG WHERE drug_code=? AND trade_code=?";
				pstmt			= connection.prepareStatement(str_qry) ;
				pstmt.setString(1,drug_code);
				pstmt.setString(2,trade_code);
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					fileName=resultSet.getString("TRADE_IMAGE_FILENAME")==null?"":resultSet.getString("TRADE_IMAGE_FILENAME");
				}

				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}

			if((trade_code.equals("") || fileName.equals(""))&& !drug_code.equals("")){
				str_qry			= "SELECT item_image_filename FROM ph_drug WHERE drug_code=?";
				pstmt			= connection.prepareStatement(str_qry) ;
				pstmt.setString(1,drug_code);
				resultSet		= pstmt.executeQuery();
				pstmt.setString(1,drug_code);
				if(resultSet!=null && resultSet.next()){
					fileName=resultSet.getString("ITEM_IMAGE_FILENAME")==null?"":resultSet.getString("ITEM_IMAGE_FILENAME");
				}

				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
		}
		catch ( Exception e ) {
			//	System.err.println( "Error sys_date  :"+e ) ;
				e.printStackTrace() ;

		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){}
		}
		if(fileName.equals(""))
			return fileName;

		return file_path+fileName;
	}
} 
