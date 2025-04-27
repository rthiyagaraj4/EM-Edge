/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;
import ePH.UomForForm.*;


//saved on 27/10/2005
public class UomForFormBean extends PhAdapter implements Serializable 
{

/* Variable Declarations start */
 protected ArrayList applicableUom		=	null;
 protected ArrayList associatedUom		=	null;
 protected HashMap uom_detail			=	new HashMap();
 protected String	form_code			=	"";
 protected String   code_found			=	"";
 protected String   db_found			=	"";
 /* Variable Declarations end */

		
	public UomForFormBean() {
        try {
            doCommon();
        }catch(Exception e) 
		{
//			System.out.println("Exception in constructor"+e.toString());
			e.printStackTrace();
		}
    }


/* Set and get methods */ 
	public void setFormCode(String form_code)	{
		this.form_code	=	form_code;
	}
	public String getFormCode()	{
		return this.form_code;
	}
	
	public void setUomDetail(HashMap values)	{
		this.uom_detail	=	values;
	}

	public HashMap getUomDetail(String code)	{
		HashMap	record	=	new HashMap();
		if(this.uom_detail.containsKey(code))
		record	=	(HashMap)this.uom_detail.get(code);
		return record;
	}

	public boolean findUomDetail(String code) {
		boolean found	=	false;
		
		if(this.uom_detail.containsKey(code))
			found	=	true;

	return found;
	}

	public void setApplicableUom(ArrayList values)	{
		applicableUom		= (ArrayList)values.clone();
	}

	public void setAssociatedUom(ArrayList ass_values)	{
		associatedUom		= (ArrayList) ass_values.clone();
	}

	public void updateApplicableUom(ArrayList values,int start, int end)	{
			int i=0;
			int j=0;
	
			while(start<end)	{
				Hashtable t_record	=(Hashtable)values.get(i);
					j=start-1;
					applicableUom.set(j,t_record);
					start++;
					i++;
			}
	}

	public ArrayList getApplicableUom()	{
		return applicableUom;
	}
	
	public ArrayList getAssociatedUom()	{
		return associatedUom;
	}			
/* Set and get methods */ 
	

	    /* Over-ridden Adapter methods start here */
    public HashMap validate() throws Exception {
		
        HashMap map                 =   new HashMap() ;

		boolean found		=	false;

		ArrayList	all_data	=	getStoredUom();
		for(int i=0; i<all_data.size(); i++)	{
		Hashtable	record	=	(Hashtable) all_data.get(i);
			if(record!=null)	{
				String	flag		=(String)	record.get("flag");
					if(flag.equals("I") || flag.equals("U") || flag.equals("D") || flag.equals("DB")) {
						found	=	true;
					}
			}
		}
		if(!found)	{        
			map.put( "result", new Boolean( false) ) ;
			map.put( "message", "PH_ATLEAST_ONE_SELECTED" ) ;
		}
		else
		{
		map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		}
		return map ;
    }

	public boolean checkDuplicate(String code,ArrayList data) {
		boolean found	=	false;

		for(int i=0; i<data.size(); i++) {
			ArrayList record	=	(ArrayList)data.get(i);
			if(record.contains(code)) {
				found	=	true;
				break;
			}				
			
		}
	return found;
	}

//*********************************************************************************************

    public HashMap insert() {
		ArrayList	insertData		=	new ArrayList();
		ArrayList	insertRecord	=	null;
		HashMap		sqlMap			=	new HashMap();
		HashMap		tabData			=	new HashMap() ;
		Hashtable	record			=	null;
		String		form_code		=	"";
		String		code			=	"";
		String		default_yn		=	"N";
		String		flag			=	"";

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert Failed" ) ;
		
		ArrayList	all_data	=	getStoredUom();
		form_code				=	getFormCode();

		for(int i=0; i<all_data.size(); i++)	{
			record	=	(Hashtable) all_data.get(i);

			if(record!=null)	{
					
					code		=(String)	record.get("code");
					default_yn	=(String)	record.get("default");
					flag		=(String)	record.get("flag");
					if(default_yn.equals("")) default_yn="N";

					if(flag.equals("I") || flag.equals("U") || flag.equals("DB"))	{
					insertRecord	=	new ArrayList();
					insertRecord.add(code);
					insertRecord.add(default_yn);
						if(!checkDuplicate(code,insertData) )
						insertData.add(insertRecord);
					}  
				}
		}	

		try	{
		sqlMap.put("SQL_PH_UOM_FOR_FORM_INSERT",PhRepository.getPhKeyValue("SQL_PH_UOM_FOR_FORM_INSERT"));
		sqlMap.put("SQL_PH_UOM_FOR_FORM_DELETE",PhRepository.getPhKeyValue("SQL_PH_UOM_FOR_FORM_DELETE"));

		tabData.put("properties", getProperties() );
		tabData.put("form_code",form_code);
		tabData.put("login_by_id", login_by_id ) ;
		tabData.put("login_at_ws_no", login_at_ws_no ) ;
		tabData.put("login_facility_id", login_facility_id ) ;
		tabData.put("insertData",insertData);
	
/*      UomForFormHome home = null;
        UomForFormRemote remote = null;

		InitialContext context = new InitialContext() ;
        Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_UOM_FOR_FORM")) ;
        home  = (UomForFormHome) PortableRemoteObject.narrow( object, UomForFormHome.class ) ;
        remote = home.create() ;
		map = remote.insert( tabData, sqlMap ) ;*/

		Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_UOM_FOR_FORM"),UomForFormHome.class,getLocalEJB());
		Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]=new Object[2];
		argArray[0]=tabData;
		argArray[1]=sqlMap;

		Class[] paramArray=new Class[2];
		paramArray[0]=tabData.getClass();
		paramArray[1]=sqlMap.getClass();

		map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		}catch(Exception e)	{
			map.put("flag",e.toString());	
		}
		try {
               if( ((Boolean) map.get( "result" )).booleanValue() ){
				//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			   }
				else{
                map.put( "message", (map.get("msgid"))) ;
				}
			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			} 
        return map ;
    }

//**************************************************************************************************

  public HashMap modify() 
  {

		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put("flag", "0");
        return map ;
   }

//***************************************************************************************************
   public HashMap delete() 
	  {
		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put("flag", "0" );
		return map;
	 }


	public void clear() {
             super.clear() ;
			 applicableUom = new ArrayList();
    }

	public void setAll( Hashtable recordSet ) {
		 if(recordSet.containsKey("form_code"))
            setFormCode((String)recordSet.get("form_code")) ;

        if(recordSet.containsKey("mode"))
            setMode((String)recordSet.get("mode")) ;
	}

	private void doCommon() throws Exception 
	{
    }
    /* Over-ridden Adapter methods end here */

    /* Function specific methods start */

	public ArrayList loadFormofDrug(String locale)
	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query            =   "";
		String form_code			=	"";
		String form_desc			=	"";

		ArrayList formOfDrug		= new ArrayList();
		try 
		{
		sql_query               = PhRepository.getPhKeyValue("SQL_PH_FORM_OF_DRUG_SELECT");
		 
                connection  = getConnection() ;
                pstmt       = connection.prepareStatement(sql_query) ;
			    pstmt.setString(1,locale);

				resultSet   =   pstmt.executeQuery();

				while(resultSet.next())
				{
				form_code	=	resultSet.getString("FORM_CODE");
				form_desc	=	resultSet.getString("FORM_DESC");
				formOfDrug.add(form_code);
				formOfDrug.add(form_desc);
				}
			
			} catch ( Exception e ) {
                System.err.println( "Error loading values from database" ) ;
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es)
					{
						es.printStackTrace();
					}
              }
		return formOfDrug;
	}

	public ArrayList getStoredUom()	{
		ArrayList associated	=	new ArrayList();
		ArrayList beanvalues	=   getApplicableUom();
		if(beanvalues.size()!=0)	{
		for(int i=0; i<beanvalues.size(); i++)		{
		Hashtable	rec	=	(Hashtable)beanvalues.get(i);
			if( ((String)rec.get("flag")).equals("I") || ((String)rec.get("flag")).equals("DB") || ((String)rec.get("flag")).equals("D") || ((String)rec.get("flag")).equals("U")) {
				associated.add(rec);  
			}
		}
		}
	return associated;
	}

	public void setDB(String db)	{
		this.db_found	=	db;
	}

	public String getDB()	{
		return this.db_found;
	}
	public void setDefault(String code)	{
		this.code_found	=	code;
	}

	public String getDefault()	{
		return this.code_found;
	}

	public void getConsolidatedUom()	{
		ArrayList	UomValues			=	getApplicableUom();
		ArrayList	associatedUomValues	=	getAssociatedUom();
		String		t_code				=	"";
		String		t_default			=	"";
		for(int cnt=0; cnt<UomValues.size(); cnt++)
		{
		Hashtable rec	=	(Hashtable)UomValues.get(cnt);
		String code		=	(String)rec.get("code");
		String flag		=	(String)rec.get("flag");
		if(! flag.equals("D")  )	{
			for(int cnt_1=0; cnt_1<associatedUomValues.size(); cnt_1++)	{
					Hashtable rec_1		=	(Hashtable)associatedUomValues.get(cnt_1);
					String code_1		=	(String)rec_1.get("code");
					String  default_1	=	(String)rec_1.get("default");
					if(code_1.equals(code))	{
							rec.put("default",default_1);
							if(default_1.equals("Y")) 
							t_code	=	code;
							rec.put("select","Y");
							rec.put("flag","DB");
							t_default ="DB Found";
					}
			}
		}
		}
		setDefault(t_code);
		setDB(t_default);
	}

	public void loadAssociatedUom(String form_code)	{
		Connection connection				=	null ;
        PreparedStatement pstmt				=	null ;
        ResultSet resultSet					=	null ;
		String sql_query					=   "";
		String uom_code						=	"";
		String default_yn					=	"";
		ArrayList	associated_Uom			=	new ArrayList();
		Hashtable	associated_record		=	null;

		try {
		sql_query               = PhRepository.getPhKeyValue("SQL_PH_UOM_FOR_FORM_SELECT2");

		 
                connection  = getConnection() ;
                pstmt       = connection.prepareStatement(sql_query) ;
				pstmt.setString(1,form_code);
				resultSet   =   pstmt.executeQuery();

				while(resultSet.next())
				{
				uom_code	=	resultSet.getString("UOM_CODE");
				default_yn	=	resultSet.getString("DFLT_UOM_YN");	
				
				associated_record	=	 new Hashtable();
				associated_record.put("code",uom_code);
				associated_record.put("default",default_yn);
				associated_record.put("flag","DB");


				associated_Uom.add(associated_record);
				}
				setAssociatedUom(associated_Uom);
			

			} catch ( Exception e ) {
                System.err.println( "Error loading values from database" ) ;
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es)
					{
						System.out.println("Exception while closing resultsets and statements"+es.toString());
					}
              }
	}

	
	public void loadApplicableUom(String locale)	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query            =   "";
		String uom_code				=	"";
		String uom_desc				=	"";
		ArrayList	appl_Uom	=	new ArrayList();
		applicableUom		=	new ArrayList();
		Hashtable	record		= null;
		 try {
		sql_query               = PhRepository.getPhKeyValue("SQL_PH_UOM_FOR_FORM_SELECT1");

		
                connection  = getConnection() ;
                pstmt       = connection.prepareStatement(sql_query) ;
                pstmt.setString(1,locale);
				resultSet   =   pstmt.executeQuery();
				//System.err.println("resultSet------->"+resultSet);

				while(resultSet.next())
				{
				uom_code	=	resultSet.getString("UOM_CODE");
				uom_desc	=	resultSet.getString("SHORT_DESC");
				
				record	=	new Hashtable();
				record.put("code",uom_code);
				record.put("desc",uom_desc);
				record.put("flag","N");

				appl_Uom.add(record);
				//System.err.println("appl_Uom--------->"+appl_Uom);
				}
			
			setApplicableUom(appl_Uom);
			loadUomDetail(locale);
			} catch ( Exception e ) {
                System.err.println( "Error loading values from database" ) ;
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es)
					{
						System.out.println("Exception while closing resultsets and statements"+es.toString());
					}
              }
	}

	public HashMap loadUomDetail(String locale)	{
	
		Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null ;
		String sql_query				=   "";
		HashMap records					=	new HashMap();
		HashMap	record					= null;
		String uom_code					=	"";
		String uom_ldesc				=	"";
		String uom_sdesc				=	"";
		String pur_uom_yn				=	"";	
		String stock_uom_yn				=	"";
		String sale_uom_yn				=	"";
		String strength_uom_yn			=	"";
		String qty_uom_yn				=	"";

		try {
		sql_query					= PhRepository.getPhKeyValue("SQL_PH_UOM_FOR_FORM_SELECT4");
		 
                connection  = getConnection() ;
                pstmt       = connection.prepareStatement(sql_query) ;
				pstmt.setString(1,locale);
				resultSet   =   pstmt.executeQuery();

				while(resultSet.next())
				{
				uom_code		=	resultSet.getString("UOM_CODE");
				uom_ldesc		=	resultSet.getString("LONG_DESC");
				uom_sdesc		=	resultSet.getString("SHORT_DESC");
				pur_uom_yn		=	resultSet.getString("PUR_UOM_YN");
				stock_uom_yn	=	resultSet.getString("STOCK_UOM_YN");
				sale_uom_yn		=	resultSet.getString("SALE_UOM_YN");
				strength_uom_yn	=	resultSet.getString("STRENGTH_UOM_YN");
				qty_uom_yn		=	resultSet.getString("QTY_UOM_YN");
				
				
				record	=	new HashMap();
				record.put("ldesc",uom_ldesc);
				record.put("sdesc",uom_sdesc);
				record.put("pur_yn",pur_uom_yn);
				record.put("stock_yn",stock_uom_yn);
				record.put("sale_yn",sale_uom_yn);
				record.put("strength_yn",strength_uom_yn);
				record.put("qty_uom_yn",qty_uom_yn);
				records.put(uom_code,record);
				}
			
				setUomDetail(records);		
		
			} catch ( Exception e ) {
                System.err.println( "Error loading values from database" ) ;
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es)
					{
						System.out.println("Exception while closing resultsets and statements"+es.toString());
					}
              }

		return record;
	}

	public void makeDefault()
	{
	ArrayList	tvalues	=	getApplicableUom();
    for(int j=0; j<tvalues.size(); j++)	{
		Hashtable trecord	=	(Hashtable) tvalues.get(j);
		if(trecord.get("default")!=null)	{
			String    def		=   (String)trecord.get("default");	
			 if(def.equals("Y"))
			  trecord.put("default","N");
		}
	 }  
    }
    /* Function specific methods end */
}
