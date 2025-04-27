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
    //ArrayList arrlist = new ArrayList ();
	ArrayList arrlist;

    public CAOptions() {}

    public synchronized String setCAOptions(Connection con,String episodetype, String respid, String relationcode, String facilityid, String encounterid, String patientid)
    {
        String  bool            = "true" ;
        PreparedStatement stmt  = null ;
        ResultSet rset      = null ;
        StringBuffer detl_sql     =new StringBuffer();
        try
        {
            //stmt = con.createStatement ()  ;

            //if(arrlist.size()>0)     arrlist.clear();
			arrlist = new ArrayList();

			detl_sql.append(" SELECT LVL , A.OPTION_ID OPTION_ID ,OPTION_DESC,FUNCTION_NAME,MENU_POSITION,OPTION_TYPE,EXECUTABLE_NAME,APPLICABLE_CATEGORY,HEADER_OPTION_ID,ORDER_SEQ_NO,OPEN_IN_MODAL_WINDOW_YN,APPLICABLE_ON_PAT_YN,APPLICABLE_ON_ENC_YN FROM ( SELECT LEVEL LVL,OPTION_ID,SHORT_DESC OPTION_DESC,LONG_DESC FUNCTION_NAME,MENU_POSITION ,OPTION_TYPE,EXECUTABLE_NAME,APPLICABLE_CATEGORY,HEADER_OPTION_ID,ORDER_SEQ_NO,OPEN_IN_MODAL_WINDOW_YN,APPLICABLE_ON_PAT_YN,APPLICABLE_ON_ENC_YN FROM CA_OPTION START WITH HEADER_OPTION_ID IS NULL CONNECT BY PRIOR  OPTION_ID=HEADER_OPTION_ID ) A,(SELECT  DISTINCT OPTION_ID FROM CA_OPTION START WITH OPTION_ID IN (SELECT OPTION_ID FROM CA_APPL_TASK WHERE 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,?,?,?,?,?)) ");
//'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,'"+respid+"','"+relationcode+"','"+facilityid+"','"+encounterid+"','"+patientid+"')) ";
						if(!(episodetype == null || episodetype.equals("")) )
							{
								if(episodetype.equals("O"))
									detl_sql.append("  AND APPLICABLE_CATEGORY in ('O','B') ");
								else if(episodetype.equals("I"))
									detl_sql.append("  AND APPLICABLE_CATEGORY in ('I','B') ");
							}

						   detl_sql.append(" CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID ) B WHERE B.OPTION_ID=A.OPTION_ID ORDER BY ORDER_SEQ_NO ");


/*            detl_sql =  " SELECT LEVEL, OPTION_ID , "+
                               " SHORT_DESC OPTION_DESC, "+
                               " LONG_DESC FUNCTION_NAME, "+
                               " MENU_POSITION , "+
                               " OPTION_TYPE, "+
                               " EXECUTABLE_NAME, "+
                               " APPLICABLE_CATEGORY, "+
                               " HEADER_OPTION_ID, "+
                               " ORDER_SEQ_NO,"+
                               " OPEN_IN_MODAL_WINDOW_YN, "+
                               " APPLICABLE_ON_PAT_YN, "+
                               " APPLICABLE_ON_ENC_YN FROM CA_OPTION "+
                               " WHERE OPTION_ID IN (SELECT  OPTION_ID "+
                               " FROM CA_OPTION "+
                               " START WITH OPTION_ID IN (SELECT OPTION_ID FROM CA_APPL_TASK "+
                               " WHERE 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,'"+respid+"','"+relationcode+"','"+facilityid+"','"+encounterid+"','"+patientid+"')) ";

				if(!(episodetype == null || episodetype.equals("")) )
				{
					if(episodetype.equals("O"))
						detl_sql+= "  AND APPLICABLE_CATEGORY in ('O','B') ";
					else if(episodetype.equals("I"))
						detl_sql+= "  AND APPLICABLE_CATEGORY in ('I','B') ";
				}

			   detl_sql+=" CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID )" +
								   " START WITH HEADER_OPTION_ID IS NULL"+
								   " CONNECT BY PRIOR OPTION_ID= HEADER_OPTION_ID "+
								   " ORDER BY ORDER_SEQ_NO ";
*/
				stmt = con.prepareStatement(detl_sql.toString());
				stmt.setString(1,respid);
				stmt.setString(2,relationcode);
				stmt.setString(3,facilityid);
				stmt.setString(4,encounterid);
				stmt.setString(5,patientid);
                rset = stmt.executeQuery();

            if( rset!=null )
            {
                int i =0;
                while( rset.next())
                {
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
            }
        }
        catch( Exception e ) {
			bool += e.toString() +"<br>"+ detl_sql; 
			System.out.println(bool);
		}

        try
        {
            if(stmt!=null)  stmt.close();
            if(rset!=null)      rset.close();
        }
        catch ( Exception e ) {}

            return bool ;
    }

    public ArrayList getHeaders()
    {
        ArrayList  retList = new ArrayList () ;

        for (int i=0; i<arrlist.size(); i++)
        {
             Hashtable dat = (Hashtable) arrlist.get(i) ;
             if (dat.get( "LEVEL_NO" ).equals("1"))
             {
                retList. add( (Hashtable) arrlist.get(i)) ;
             }
        }
        return retList ;
    }

    public ArrayList getSubHeaders( String level, String HeaderOptionID )
    {
        ArrayList retList = new ArrayList () ;

        for (int i=0; i<arrlist.size() ;i++ )
        {
             Hashtable dat = (Hashtable) arrlist.get(i) ;

             if ( dat.get( "LEVEL_NO" ).equals( level ) && dat.get( "HEADER_OPTION_ID" ).equals( HeaderOptionID ) )
             {
                retList. add( (Hashtable) arrlist.get(i)) ;
             }
        }
        return retList ;
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
		}catch( Exception e ) { 
			retrelnid += e.toString() +"<br>"+ sql; 
			System.out.println("chkActiveRelation : "+retrelnid);
		}

        try
        {
            if(stmt!=null)  stmt.close();
            if(rset!=null)      rset.close();
        }
        catch ( Exception e ) {}

		return retrelnid ;
	}
}
