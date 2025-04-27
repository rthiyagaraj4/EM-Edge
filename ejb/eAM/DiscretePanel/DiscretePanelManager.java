/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.DiscretePanel;


import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;





/**
*
* @ejb.bean
*	name="DiscretePanel"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DiscretePanel"
*	local-jndi-name="DiscretePanel"
*	impl-class-name="eAM.DiscretePanel.DiscretePanelManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eAM.DiscretePanel.DiscretePanelLocal"
*	remote-class="eAM.DiscretePanel.DiscretePanelRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.DiscretePanel.DiscretePanelLocalHome"
*	remote-class="eAM.DiscretePanel.DiscretePanelHome"
*	generate= "local,remote"
*
*
*/




public class DiscretePanelManager
    implements SessionBean
{

    public DiscretePanelManager()
    {

    }

    public void ejbCreate()
    {
    }

    public void ejbRemove()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void setSessionContext(SessionContext sessioncontext)
    {
		sessioncontext= sessioncontext;//for avoiding PMD violation
    }
/**
* @ejb.interface-method
*	 view-type="both"
*/

    public java.util.HashMap  insertDiscrete(Properties p,HashMap hashmap)
	{


		Connection con =null;
		PreparedStatement pstmt ;
		PreparedStatement pslPrepStmt;


      //  HashMap hashmap1 = new HashMap();
		HashMap results	    = new HashMap();
		java.sql.Timestamp modified_date = null;
		java.sql.Timestamp added_date	=null;

//            Properties properties = (Properties)hashmap.get("p");
            String s = (String)hashmap.get("discr_msr_id");
			String s1 = (String)hashmap.get("long_desc");
			String s2 = (String)hashmap.get("short_desc");
            String s3 = (String)hashmap.get("service");
            String s4 = (String)hashmap.get("result_type");
			RecordSet associateDiagBean=(RecordSet)hashmap.get("Recordset");
            int i = ((Integer)hashmap.get("numdigitsmax")).intValue();
            int j = ((Integer)hashmap.get("numdigitsmin")).intValue();
            int k = ((Integer)hashmap.get("numdigitsdec")).intValue();
            String s5 = (String)hashmap.get("refrangetype");
            String s6 = (String)hashmap.get("resulttemplateid");
            String s7 = (String)hashmap.get("effstatus");

			String locale="";
			locale= p.getProperty("LOCALE");
			String discrete_msr_id="";
			String mandatory = "";
            String s11 = (String)hashmap.get("added_facility_id");
            String s12 = (String)hashmap.get("added_at_ws_no");


			modified_date				=(java.sql.Timestamp)hashmap.get("modified_date");
			added_date					= (java.sql.Timestamp)hashmap.get("added_date");

            boolean flag = false;
            boolean flag1 = true;
			boolean result = false ;
            StringBuffer stringbuffer = new StringBuffer("");
            String s13 = p.getProperty("login_user");
            String s14 = s13;
           // String s15 = "";
			//s15=s11;
            String s16 = s12;
            hashmap.clear();
			try{
           try
            {
                con = ConnectionManager.getConnection(p);
                con.setAutoCommit(false);
                pstmt = con.prepareStatement("select 1 from  am_discr_msr where DISCR_MSR_ID = ? ");
                pstmt.setString(1, s);
                ResultSet resultset = pstmt.executeQuery();
                if(resultset != null && resultset.next())
                {
                    flag1 = false;
                    Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_ALREADY_EXISTS_IN_DIS","AM");
                    stringbuffer.append((String)hashtable1.get("message"));
					results.put( "status", new Boolean(flag1) ) ;
					results.put( "error", stringbuffer.toString() ) ;
                    hashtable1.clear();
					return results ;

                }

                if(resultset != null) resultset.close();
                if(pstmt != null)  pstmt.close();
            }
            catch(Exception exception1)
            {
                flag1 = false;
                stringbuffer.append(exception1.getMessage() + "<br>");
                exception1.printStackTrace();
            }
           if(flag1)
            {
                try
                {
                    String s17 = " insert into am_discr_msr  (  DISCR_MSR_ID ,  LONG_DESC ,     SHORT_DESC ,    SERVICE_CODE ,  RESULT_TYPE ,   ACTIVITY_TYPE , NUM_DIGITS_MAX ,  NUM_DIGITS_MIN ,  NUM_DIGITS_DEC ,  REF_RANGE_TYPE ,  RESULT_TEMPLATE_ID ,       SECURITY_LEVEL ,  EFF_STATUS ,    ADDED_BY_ID ,   ADDED_DATE ,    ADDED_AT_WS_NO , ADDED_FACILITY_ID ,   MODIFIED_BY_ID ,  MODIFIED_DATE , MODIFIED_AT_WS_NO ,  MODIFIED_FACILITY_ID   )  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ";
                    pstmt = con.prepareStatement(s17);
                    pstmt.setString(1, s);
                    pstmt.setString(2, s1);
                    pstmt.setString(3, s2);
                    pstmt.setString(4, s3);
                    pstmt.setString(5, s4);
                    pstmt.setString(6, "");
                    pstmt.setInt(7, i);
                    pstmt.setInt(8, j);
                    pstmt.setInt(9, k);
                    pstmt.setString(10, s5);
                    pstmt.setString(11, s6);
                    pstmt.setString(12, "");
                    pstmt.setString(13, s7);
                    pstmt.setString(14, s13);
                    pstmt.setTimestamp(15, added_date);
                    pstmt.setString(16, s12);
                    pstmt.setString(17, s11);
                    pstmt.setString(18, s14);
                    pstmt.setTimestamp(19, modified_date);
                    pstmt.setString(20, s16);
                    pstmt.setString(21, s11);
                    int l = pstmt.executeUpdate();
                    if(pstmt != null)
                        pstmt.close();
                    if(l != 0){
                        flag = true;
						con.commit();

					}
                    else
					{
                        flag = false;
						con.rollback();

					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}

           if(flag )
           {
				try
				{

				String delete= "Delete from am_discr_msr_battery where DISCR_MSR_BATTERY_ID=?";
				pslPrepStmt = con.prepareStatement(delete);
				pslPrepStmt.setString(1,s);
				pslPrepStmt.executeUpdate();
				result=true;
				if(pslPrepStmt!=null)
				{
					pslPrepStmt.close();
				}

				String s18 = "INSERT INTO AM_DISCR_MSR_BATTERY(DISCR_MSR_BATTERY_ID,DISCR_MSR_ID,ORDER_SRL_NO,MANDATORY_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				pslPrepStmt = con.prepareStatement(s18);

				int size=associateDiagBean.getSize();

				int cnt = 0;
				//int order=1;

				for(int e=0;e<size;e+=3)
				{
					discrete_msr_id=associateDiagBean.getObject(e).toString();

					mandatory =associateDiagBean.getObject(e+2).toString();

					pslPrepStmt.clearParameters();
					pslPrepStmt.setString(1,s);
					pslPrepStmt.setString(2,discrete_msr_id);
					pslPrepStmt.setInt(3,++cnt);
					pslPrepStmt.setString(4,mandatory);
				    pslPrepStmt.setString(5, s13);
                    pslPrepStmt.setTimestamp(6, added_date);
                    pslPrepStmt.setString(7, s12);
                    pslPrepStmt.setString(8, s11);
                    pslPrepStmt.setString(9, s14);
                    pslPrepStmt.setTimestamp(10, modified_date);
                    pslPrepStmt.setString(11, s16);
                    pslPrepStmt.setString(12, s11);
					pslPrepStmt.executeUpdate();



				}

				if(pslPrepStmt != null)pslPrepStmt.close();
				if(cnt*3==size)
				{
					con.commit();

					result=true;

				  Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
                    stringbuffer.append((String)hashtable1.get("message"));
					results.put( "status", new Boolean(result) ) ;
					results.put( "error", stringbuffer.toString() ) ;
					hashtable1.clear();
					return results ;
				}
				else{

				con.rollback();
				result=false;

				results.put( "status", new Boolean(result) ) ;
				results.put( "error", stringbuffer.toString() ) ;
				return results ;
				}


}
catch(Exception e)
{

                stringbuffer.append(e.getMessage() + "<br>");
                e.printStackTrace();

}
finally
 {
      if(con != null)
          ConnectionManager.returnConnection(con, p);
 }
}
}catch(Exception e)
{
	e.printStackTrace();
}
finally
 {
      if(con != null)
          ConnectionManager.returnConnection(con, p);
 }

 return results;
}
/**
* @ejb.interface-method
*	 view-type="both"
*/

 public java.util.HashMap  updateDiscrete(Properties p,HashMap hashmap)
{
		Connection con =null;
		PreparedStatement pstmt ;
		PreparedStatement pslPrepStmt;


       // HashMap hashmap1 = new HashMap();
		HashMap results	    = new HashMap();
		java.sql.Timestamp modified_date = null;
		java.sql.Timestamp added_date	=null;

//            Properties properties = (Properties)hashmap.get("p");
            String s = (String)hashmap.get("discr_msr_id");
			String s1 = (String)hashmap.get("long_desc");
			String s2 = (String)hashmap.get("short_desc");
            String s3 = (String)hashmap.get("service");
            String s4 = (String)hashmap.get("result_type");
			RecordSet associateDiagBean=(RecordSet)hashmap.get("Recordset");
            int i = ((Integer)hashmap.get("numdigitsmax")).intValue();
            int j = ((Integer)hashmap.get("numdigitsmin")).intValue();
            int k = ((Integer)hashmap.get("numdigitsdec")).intValue();
            String s5 = (String)hashmap.get("refrangetype");
            String s6 = (String)hashmap.get("resulttemplateid");
            String s7 = (String)hashmap.get("effstatus");
			String locale="";
		locale= p.getProperty("LOCALE");

			String discrete_msr_id="";
			String mandatory = "";

            String s11 = (String)hashmap.get("added_facility_id");
            String s12 = (String)hashmap.get("added_at_ws_no");


			modified_date				=(java.sql.Timestamp)hashmap.get("modified_date");
			added_date					= (java.sql.Timestamp)hashmap.get("added_date");


            boolean flag = false;
           // boolean flag1 = true;
			boolean result = false ;
            StringBuffer stringbuffer = new StringBuffer("");
            String s13 = p.getProperty("login_user");
            String s14 = s13;
           // String s15 = "";
			//s15=s11;
            String s16 = s12;
           // Object obj = null;
           // Timestamp timestamp = new Timestamp(System.currentTimeMillis());
           // Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());

		   hashmap.clear();
     try{
	 try
	{
		  con = ConnectionManager.getConnection(p);
          con.setAutoCommit(false);
		try
                {
                    String s17 = " UPDATE AM_DISCR_MSR  SET LONG_DESC = ?, SHORT_DESC = ? ,    SERVICE_CODE = ? ,  RESULT_TYPE = ? ,   NUM_DIGITS_MAX = ? ,  NUM_DIGITS_MIN = ? ,  NUM_DIGITS_DEC = ? ,  REF_RANGE_TYPE = ? ,  RESULT_TEMPLATE_ID = ? ,  EFF_STATUS = ? ,    MODIFIED_BY_ID = ? ,  MODIFIED_DATE = ? , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID =? where DISCR_MSR_ID =?";
                    pstmt = con.prepareStatement(s17);
                    pstmt.setString(1, s1);
                    pstmt.setString(2, s2);
                    pstmt.setString(3, s3);
                    pstmt.setString(4, s4);
                    pstmt.setInt(5, i);
                    pstmt.setInt(6,j);
                    pstmt.setInt(7, k);
                    pstmt.setString(8, s5);
                    pstmt.setString(9, s6 );
                    pstmt.setString(10, s7);
                    pstmt.setString(11, s14);
                    pstmt.setTimestamp(12, modified_date);
                    pstmt.setString(13, s16);
                    pstmt.setString(14, s11);
                    pstmt.setString(15, s);

                    int l = pstmt.executeUpdate();
                    if(pstmt != null)
                        pstmt.close();
                    if(l != 0){
                        flag = true;
						con.commit();

					}
                    else
					{
                        flag = false;
						con.rollback();

					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			 if(flag )
           {
				try
				{

				String delete= "Delete from am_discr_msr_battery where DISCR_MSR_BATTERY_ID=?";
				pslPrepStmt = con.prepareStatement(delete);
				pslPrepStmt.setString(1,s);
				pslPrepStmt.executeUpdate();
				result=true;
				if(pslPrepStmt!=null)
				{
					pslPrepStmt.close();
				}

				String s18 = "INSERT INTO AM_DISCR_MSR_BATTERY(DISCR_MSR_BATTERY_ID,DISCR_MSR_ID,ORDER_SRL_NO,MANDATORY_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				pslPrepStmt = con.prepareStatement(s18);

				int size=associateDiagBean.getSize();

				int cnt = 0;
				//int order=1;

				for(int e=0;e<size;e+=3)
				{
					discrete_msr_id=associateDiagBean.getObject(e).toString();

					mandatory =associateDiagBean.getObject(e+2).toString();

					pslPrepStmt.clearParameters();
					pslPrepStmt.setString(1,s);
					pslPrepStmt.setString(2,discrete_msr_id);
					pslPrepStmt.setInt(3,++cnt);
					pslPrepStmt.setString(4,mandatory);
				    pslPrepStmt.setString(5, s13);
                    pslPrepStmt.setTimestamp(6, added_date);
                    pslPrepStmt.setString(7, s12);
                    pslPrepStmt.setString(8, s11);
                    pslPrepStmt.setString(9, s14);
                    pslPrepStmt.setTimestamp(10, modified_date);
                    pslPrepStmt.setString(11, s16);
                    pslPrepStmt.setString(12, s11);
					pslPrepStmt.executeUpdate();


				}

				if(pslPrepStmt != null)pslPrepStmt.close();
				if(cnt*3==size)
				{
					con.commit();
					result=true;

				  Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM");
                    stringbuffer.append((String)hashtable1.get("message"));
					results.put( "status", new Boolean(result) ) ;
					results.put( "error", stringbuffer.toString() ) ;
					hashtable1.clear();
					return results ;
				}
				else{

				con.rollback();
				result=false;

				results.put( "status", new Boolean(result) ) ;
				results.put( "error", stringbuffer.toString() ) ;
				return results ;
				}


}
				catch(Exception e){
					e.printStackTrace();
				}
			}

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
      if(con != null)
          ConnectionManager.returnConnection(con, p);
	}
	 }
	 catch(Exception e)
	{
		 e.printStackTrace();
	}
	finally
	{
      if(con != null)
          ConnectionManager.returnConnection(con, p);
	}
	 return results;
}
}

