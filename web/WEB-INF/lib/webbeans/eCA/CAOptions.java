/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCA;

import java.sql.*;
import java.util.*;

public class CAOptions implements java.io.Serializable 
{
	Hashtable menuData = null;
    //ArrayList arrlist = new ArrayList ();
	//ArrayList arrlist;

    public CAOptions() {
		menuData = new Hashtable();
		System.out.println("menuData===="+menuData);
	}

    public synchronized String setCAOptions(Connection con,String episodetype, String respid, String relationcode, String facilityid, String encounterid, String patientid,String practitionerId,String practitionerType){
        String  bool            = "true" ,menu_id="",patientclass="";
        PreparedStatement stmt  = null ,pstmtMenu = null;
        ResultSet rset      = null,rsMenu = null ;
        StringBuffer detl_sql     =new StringBuffer();
		String strSql="SELECT CA_GET_MENU_ID(A.SPECIALTY_CODE,A.patient_class,?,?) MENU_ID,patient_class  FROM (SELECT SPECIALTY_CODE, PATIENT_CLASS,1 dm FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) A, (select 1 dm from DUAl) b where a.dm(+)=b.dm";

		ArrayList arrlist = new ArrayList ();
        try
		{
			//arrlist = new ArrayList();

			pstmtMenu = con.prepareStatement(strSql);
		
			pstmtMenu.clearParameters();
			pstmtMenu.setString(1,practitionerId);
			pstmtMenu.setString(2,practitionerType);
			pstmtMenu.setString(3,facilityid);
			pstmtMenu.setString(4,encounterid);

			rsMenu = pstmtMenu.executeQuery();
			while(rsMenu.next()){			
				menu_id = rsMenu.getString("MENU_ID");
				patientclass = rsMenu.getString("PATIENT_CLASS");
			}

			if(menu_id == null)		menu_id="MED_DFLT";
			if(patientclass == null) patientclass = "";

			detl_sql.append(" SELECT    DISTINCT  A.LVL   , '");
			detl_sql.append(patientclass);
			detl_sql.append("' APPLICABLE_CATEGORY ");
			detl_sql.append(",B.OPTION_ID||B.OPTION_OCCURANCE OPTION_ID  , NVL(NVL(C.USER_DEF_SHORT_DESC,C.SHORT_DESC),(SELECT SHORT_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) OPTION_DESC  , NVL(NVL(C.USER_DEF_LONG_DESC,C.LONG_DESC) ,(SELECT LONG_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) FUNCTION_NAME  ,'H' MENU_POSITION  , NVL(C.OPTION_TYPE,'M') OPTION_TYPE  , C.EXECUTABLE_NAME  , DECODE(?, a.HEADER_OPTION_ID,'0', a.HEADER_OPTION_ID||B.HEADER_OPTION_OCCURANCE) HEADER_OPTION_ID  , a.ORDER_SEQ_NO  , nvl(C.OPEN_IN_MODAL_WINDOW_YN,'N') OPEN_IN_MODAL_WINDOW_YN   , NVL(C.APPLICABLE_ON_PAT_YN, 'N')  APPLICABLE_ON_PAT_YN, NVL(C.APPLICABLE_ON_ENC_YN, 'N') APPLICABLE_ON_ENC_YN  FROM  ( SELECT LEVEL LVL,OPTION_ID,ORDER_SEQ_NO,HEADER_OPTION_ID ,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE   FROM CA_MENU_DETAIL  WHERE MENU_ID=?  START WITH HEADER_OPTION_ID=?  CONNECT BY PRIOR  OPTION_ID=HEADER_OPTION_ID AND  OPTION_OCCURANCE=HEADER_OPTION_OCCURANCE) A  ,(SELECT  DISTINCT OPTION_ID,HEADER_OPTION_ID,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE FROM CA_MENU_DETAIL  WHERE MENU_ID=?  START WITH OPTION_ID IN (SELECT B.OPTION_ID FROM CA_APPL_TASK a, ca_option b WHERE a.option_id=b.option_id and 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,?,?,?,?,?) "); 


			if (patientid.equals("") ){
			   detl_sql.append(" and b.DESKTOP_YN='Y' ");
			}else{
				if (patientclass.equals("")){
					detl_sql.append(" and B.HIST_OR_RECORD='H' ");
				}else{
					detl_sql.append(" and b.APPL_"+patientclass+"_YN='Y' ");
				}
			}

			detl_sql.append(" ) "); 

			if(!patientid.equals("") ){
				detl_sql.append(" AND DESKTOP_CHART = 'P' " );
			}else{
				detl_sql.append(" AND DESKTOP_CHART = 'D' ");
			}

			detl_sql.append("  CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID ) B   , CA_OPTION C   WHERE A.OPTION_ID=B.OPTION_ID AND A.HEADER_OPTION_ID=B.HEADER_OPTION_ID AND A.HEADER_OPTION_OCCURANCE=B.HEADER_OPTION_OCCURANCE AND A.OPTION_OCCURANCE=B.OPTION_OCCURANCE AND C.OPTION_ID(+)=B.OPTION_ID   ORDER BY A.ORDER_SEQ_NO ");

			
			System.out.println("CAOption.java");
			System.out.println("MENU Query:"+strSql);
			System.out.println("practitionerId=="+practitionerId);
			System.out.println("practitionerType=="+practitionerType);
			System.out.println("facilityid=="+facilityid);
			System.out.println("encounterid=="+encounterid);
			System.out.println("Tabs Query:"+detl_sql.toString());
			System.out.println("MENU ID=="+menu_id);
			System.out.println("respid=="+respid);
			System.out.println("relationcode=="+relationcode);
			System.out.println("facilityid=="+facilityid);
			System.out.println("episode_id=="+encounterid);
			System.out.println("patient_id=="+patientid);
			

			stmt = con.prepareStatement(detl_sql.toString());
			stmt.setString(1,menu_id);
			stmt.setString(2,menu_id);
			stmt.setString(3,menu_id);
			stmt.setString(4,menu_id);
			stmt.setString(5,respid);
			stmt.setString(6,relationcode);
			stmt.setString(7,facilityid);
			stmt.setString(8,encounterid);
			stmt.setString(9,patientid);

			rset = stmt.executeQuery();

			System.out.println("Query From the Bean :"+detl_sql.toString());

            if( rset!=null ){
                int i =0;
                while( rset.next()){
                    Hashtable hash = new Hashtable () ;
                    hash.put ( "FUNCTION_NAME",( rset.getString ( "FUNCTION_NAME" ) ==null ?"" :rset.getString ( "FUNCTION_NAME" )));
                    hash.put ( "MENU_POSITION", (rset.getString ( "MENU_POSITION" ) ==null ?"" :rset.getString ( "MENU_POSITION" )) );
					hash.put ( "APPLICABLE_CATEGORY", (rset.getString ( "APPLICABLE_CATEGORY" ) ==null ?"" :rset.getString ( "APPLICABLE_CATEGORY" )) );
                    hash.put ( "OPTION_DESC", (rset.getString ( "OPTION_DESC" ) ==null ?"" :rset.getString ( "OPTION_DESC" ) ));
                    //hash.put ( "LEVEL_NO", String.valueOf ( rset.getInt( "LEVEL" ) ) );
                    hash.put ( "LEVEL_NO", String.valueOf ( rset.getInt( "LVL" ) ) );
                    hash.put ( "OPTION_TYPE", ( rset.getString( "OPTION_TYPE" ) ==null ?"" :rset.getString ( "OPTION_TYPE" ))) ;
                    hash.put ( "CA_OPTION_ID", (rset.getString( "OPTION_ID" ) ==null ?"" :rset.getString ( "OPTION_ID" ))) ;
                    hash.put ( "DISPLAY_ORDER_NO", String.valueOf ( rset.getInt( "ORDER_SEQ_NO" ) ) ) ;
                    hash.put ( "OPEN_IN_MODAL_WINDOW_YN", (rset.getString( "OPEN_IN_MODAL_WINDOW_YN" ) ==null ?"N" :rset.getString ( "OPEN_IN_MODAL_WINDOW_YN" ))) ;

                    hash.put ( "APPLICABLE_ON_PAT_YN", rset.getString( "APPLICABLE_ON_PAT_YN" ) ) ;
                    hash.put ( "APPLICABLE_ON_ENC_YN", rset.getString( "APPLICABLE_ON_ENC_YN" ) ) ;

                    String s="";
                    if( rset.getString( "EXECUTABLE_NAME" ) == null )
                        s=" ";
                    else
                        s= rset.getString( "EXECUTABLE_NAME" );
                    hash.put ( "EXECUTABLE_NAME", s ) ;

                    s="";
                    if( rset.getString( "HEADER_OPTION_ID" ) == null )
                        s=" ";
                    else
                        s= rset.getString( "HEADER_OPTION_ID" );
                    hash.put ( "HEADER_OPTION_ID", s );

                    arrlist.add( hash );
                    i++;
                }
                bool +=String.valueOf(i);
				//putting to the hashtable
				if(encounterid.equals("") && patientid.equals("")) //desktop
				{
					menuData.put("DESKTOP",arrlist);
				}
				else //patient chart with encounter
				{
					menuData.put(patientid+encounterid,arrlist);
				}
            }
        }catch( Exception e ) {
			e.printStackTrace(System.err);
			bool += e.toString() +"<br>"+ detl_sql; 
			System.out.println(bool);
		}

        try{
            if(stmt!=null)  stmt.close();
            if(pstmtMenu!=null)  pstmtMenu.close();
			if(rset!=null)      rset.close();
			if(rsMenu!=null)      rsMenu.close();
			
        }
        catch ( Exception e ) 
		{
			e.printStackTrace(System.err);
		}

            return bool ;
    }

    public ArrayList getHeaders(String patientid, String encounterid)
    {
        ArrayList  retList = new ArrayList () ;
		//getting the actual arraylist for the patient /desktop
		ArrayList arrlist = null;
		if(encounterid.equals("") && patientid.equals("")) //desktop
		{			
			arrlist = (ArrayList)menuData.get("DESKTOP");			
		}
		else //patient chart
		{
			arrlist = (ArrayList)menuData.get(patientid+encounterid);
		}
		if(arrlist!=null)
		{
			for (int i=0; i<arrlist.size(); i++)
			{
				 Hashtable dat = (Hashtable) arrlist.get(i) ;
				 if (dat.get( "LEVEL_NO" ).equals("1"))
				 {
					retList. add( (Hashtable) arrlist.get(i)) ;
				 }
			}
		}
        return retList ;
    }

    public ArrayList getSubHeaders( String level, String HeaderOptionID,String patientid, String encounterid )
    {
        ArrayList retList = new ArrayList () ;
		//getting the actual arraylist for the patient /desktop
		ArrayList arrlist = null;
		if(encounterid.equals("") && patientid.equals("")) //desktop
		{
			arrlist = (ArrayList)menuData.get("DESKTOP");
		}
		else //patient chart
		{
			arrlist = (ArrayList)menuData.get(patientid+encounterid);
		}
		if(arrlist!=null)
		{	
			for (int i=0; i<arrlist.size() ;i++ )
			{
				 Hashtable dat = (Hashtable) arrlist.get(i) ;

				 if ( dat.get( "LEVEL_NO" ).equals( level ) && dat.get( "HEADER_OPTION_ID" ).equals( HeaderOptionID ) )
				 {
					retList. add( (Hashtable) arrlist.get(i)) ;
				 }
			}
		}
        return retList ;
    }
	public void clearMenuData(String patientid, String encounterid)
	{
		ArrayList arrlist = null;
		if(encounterid.equals("") && patientid.equals("")) //desktop
		{
			arrlist = (ArrayList)menuData.get("DESKTOP");
			arrlist.clear();
			menuData.remove("DESKTOP");
		}
		else //patient chart
		{
			arrlist = (ArrayList)menuData.get(patientid+encounterid);
			arrlist.clear();
			menuData.remove(patientid+encounterid);
		}

	}
	
	public String chkActiveRelation(Connection con,String clinicianid, String patientid, String facilityid, String episodeid, String episodetype, String visitid)
	{
		PreparedStatement stmt  = null ;
        ResultSet rset      = null ;
        String sql     ="";
		String  retrelnid   = "" ;
        try
        {
             sql = " Select PRACT_RELN_ID PHYS_PROV_RELN_ID from CA_ENCNTR_PRACT_RELN Where PRACTITIONER_ID=? And  PATIENT_ID=? And   FACILITY_ID=? And  STATUS is null And sysdate between BEGIN_DATE_TIME and nvl( END_DATE_TIME,sysdate)  ";

			 if(!(episodeid == null || episodeid.equals("")))
			{
				sql +=  " AND encounter_id =?";
					
			}

			stmt = con.prepareStatement(sql);

			stmt.setString(1,clinicianid);
			stmt.setString(2,patientid);
			stmt.setString(3,facilityid);
			if(!(episodeid == null || episodeid.equals(""))){
				stmt.setString(4,episodeid);
			}
			
			rset = stmt.executeQuery();

            if(rset!=null && rset.next())
            {
				String relnid = rset.getString("PHYS_PROV_RELN_ID")==null?"":rset.getString("PHYS_PROV_RELN_ID");
				retrelnid = relnid;
			}
		}catch( Exception e ) 
		{ 
			e.printStackTrace(System.err);
			retrelnid += e.toString() +"<br>"+ sql; 
			System.out.println("chkActiveRelation : "+retrelnid);
		}

        try
        {
            if(stmt!=null)  stmt.close();
            if(rset!=null)      rset.close();
        }
        catch ( Exception e ) 
		{
			e.printStackTrace(System.err);
		}

		return retrelnid ;
	}
}
