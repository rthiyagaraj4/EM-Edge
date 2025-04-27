/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.LibrarySetup;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="LibrarySetup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="LibrarySetup"
*	local-jndi-name="LibrarySetup"
*	impl-class-name="eCP.LibrarySetup.LibrarySetupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.LibrarySetup.LibrarySetupLocal"
*	remote-class="eCP.LibrarySetup.LibrarySetupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.LibrarySetup.LibrarySetupLocalHome"
*	remote-class="eCP.LibrarySetup.LibrarySetupHome"
*	generate= "local,remote"
*
*
*/
public class LibrarySetupManager
    implements SessionBean
{

	Connection con;
    PreparedStatement pstmt;
	PreparedStatement pstmt1;
	ResultSet rs;
	StringBuffer stringbuffer = new StringBuffer();

    public LibrarySetupManager()
    {
       
    }

    public void ejbCreate()
        throws  CreateException
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
    }
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
    public HashMap AddModify(Properties properties, HashMap hashtable)
    {
		stringbuffer = new StringBuffer();
		String msg="";
		HashMap map=new HashMap();
		int insert_record1	=	0;
		int insert_record2	=	0;
		HashMap hashtable1=new HashMap();
		hashtable1=(HashMap)hashtable.get("VD");
		ArrayList PatientClass=new ArrayList();
		PatientClass=(ArrayList)hashtable.get("PC");
		ArrayList AgeGrpList=new ArrayList();
		AgeGrpList=(ArrayList)hashtable.get("AG");
		String records="";
		String values="";
		int insertvalue=0;
		int result =0;
		int count=0;
		int insertStatus=1;
						
		String library_id=(String)hashtable1.get("LIBRARY_ID");
		String longdesc=(String)hashtable1.get("LONG_DESC");
		String shortdesc=(String)hashtable1.get("SHORT_DESC");
		//System.err.println("longdesc in ejb "+longdesc);
		//System.err.println("shortdesc in ejb "+shortdesc);
		String eff_status=(String)hashtable1.get("EFF_STATUS");
		String status=(String)hashtable1.get("STATUS");
		String version_remarks=(String)hashtable1.get("VERSION_REMARKS");
		String add_by_id=(String)hashtable1.get("ADDED_BY_ID");
		String add_at_ws_no=(String)hashtable1.get("ADDED_AT_WS_NO");
		String add_facility_id=(String)hashtable1.get("ADDED_FACILITY_ID");
		String dependency_level=(String)hashtable1.get("DEPENDENCY_LEVEL");
		String mode=(String)hashtable1.get("MODE");
		String locale=(String)hashtable1.get("locale")==null?"en":(String)hashtable1.get("locale");
		int version_no=Integer.parseInt((String)hashtable1.get("VERSION_NO"));
		String version_query="SELECT NVL(MAX(VERSION_NO),0)+1  VERSION_NO FROM CP_LIBRARY WHERE LIBRARY_ID=?";

		String Library_Insert="INSERT INTO CP_LIBRARY(LIBRARY_ID, VERSION_NO, LONG_DESC, SHORT_DESC, EFF_STATUS, VERSION_REMARKS, STATUS, LIBRARY_BASIS, DEPENDENCY_LEVEL, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

		String Pat_Class_Insert="INSERT INTO CP_PAT_CLASS_FOR_LIBRARY(LIBRARY_ID, VERSION_NO, PATIENT_CLASS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

		String Age_Grp_Insert="INSERT INTO CP_AGE_GRP_FOR_LIBRARY(LIBRARY_ID, VERSION_NO, AGE_GROUP_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

		String version_update="UPDATE CP_LIBRARY SET SHORT_DESC=?,LONG_DESC=?,EFF_STATUS=?,VERSION_REMARKS=?,STATUS=?,DEPENDENCY_LEVEL=?,LIBRARY_BASIS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE LIBRARY_ID=? AND VERSION_NO=?";

		String duplicate_chk_insert="select count(*)VALUE  from cp_library where library_id =? and status='F' ";

		String duplicate_chk_update="select count(*)VALUE  from cp_library where library_id = ? and version_no != ? and status = 'F'";

		String delete_patclass="DELETE FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=?";

		String delete_agegrp="DELETE FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=?";

		 if(mode.equals("1"))
			 msg="RECORD_INSERTED";
		 else
			 msg="RECORD_MODIFIED";
	
		try
        {
			
			 con = ConnectionManager.getConnection(properties);
			 con.setAutoCommit(false);
			 if(mode.equals("1"))
			{
					pstmt=con.prepareStatement(duplicate_chk_insert);
					pstmt.setString(1,library_id);
					rs=pstmt.executeQuery();										
					if(rs.next())
					 count=rs.getInt("VALUE");
					if(count >0 && status.equals("F"))
					{
				 		 insertStatus=0;
						 msg="ONE_FINAL_LIB_VERSION";
					}
					if(rs!=null) 
					{
						rs.close();
						//rs = null;
					}
					if(pstmt != null) 
					{
						pstmt.close();
						//pstmt = null;
					}
					if(insertStatus==1)
					{
						pstmt = con.prepareStatement(version_query);
						pstmt.setString(1,library_id);
						rs=pstmt.executeQuery();
						if(rs.next())
							version_no=rs.getInt("VERSION_NO");
						if(rs!=null) rs.close();
						if(pstmt != null) 
						{
							pstmt.close();
							//pstmt = null;
						}
						pstmt = con.prepareStatement(Library_Insert);
						pstmt.setString(1,library_id);
						pstmt.setInt(2,version_no);
						pstmt.setString(3,longdesc);
						pstmt.setString(4,shortdesc);
						pstmt.setString(5,eff_status);
						pstmt.setString(6,version_remarks);
						pstmt.setString(7,status);
						pstmt.setString(8,(String)hashtable1.get("LIBRARY_BASIS"));
						pstmt.setInt(9,Integer.parseInt(dependency_level));
						pstmt.setString(10,add_by_id);
						pstmt.setString(11,add_at_ws_no);
						pstmt.setString(12,add_facility_id);
						pstmt.setString(13,add_by_id);
						pstmt.setString(14,add_at_ws_no);
						pstmt.setString(15,add_facility_id);
						
						result = pstmt.executeUpdate();
						if(pstmt != null) 
						{
							pstmt.close();
							//pstmt = null;
						}
					}
				}
				else if(mode.equals("2"))
				{
					pstmt=con.prepareStatement(duplicate_chk_update);
					pstmt.setString(1,library_id);
					pstmt.setInt(2,version_no);
					rs=pstmt.executeQuery();
					if(rs.next())
					 count=rs.getInt("VALUE");
					if(rs!=null)
					{
						rs.close();
						//rs = null;
					}
					if(pstmt != null) 
					{
						pstmt.close();
						//pstmt = null;
					}

					if(count >0 && status.equals("F"))
					{
						insertStatus=0;
						msg="ONE_FINAL_LIB_VERSION";
					}

					if(insertStatus==1)
					{
						 pstmt = con.prepareStatement(delete_patclass);
						 pstmt.setString(1,library_id);
						 pstmt.setInt(2,version_no);
						 
						 int delresult1= pstmt.executeUpdate();
						
						if(pstmt != null) 
						{
							pstmt.close();
							//pstmt = null;
						}
						pstmt = con.prepareStatement(delete_agegrp);
						pstmt.setString(1,library_id);
						pstmt.setInt(2,version_no);

						int delresult2= pstmt.executeUpdate();

						if(delresult1>0 && delresult2>=0)
							insertvalue=1;
						else
							 insertvalue=0;		 			 
						if(pstmt != null) 
						{
							pstmt.close();
							//pstmt = null;
						}
						if(insertvalue==1)
						{
							pstmt = con.prepareStatement(version_update);
							pstmt.setString(1,shortdesc);
							pstmt.setString(2,longdesc);
							pstmt.setString(3,eff_status);
							pstmt.setString(4,version_remarks);
							pstmt.setString(5,status);
							pstmt.setInt(6,Integer.parseInt(dependency_level));
							pstmt.setString(7,(String)hashtable1.get("LIBRARY_BASIS"));
							pstmt.setString(8,add_by_id);
							pstmt.setString(9,add_at_ws_no);
							pstmt.setString(10,add_facility_id);
							pstmt.setString(11,library_id);
							pstmt.setInt(12,version_no);
							result = pstmt.executeUpdate();
							if(pstmt != null) 
							{
									pstmt.close();								
							}
						}
					}
				}
			if(result==1)
			{
				pstmt=con.prepareStatement(Pat_Class_Insert);
				pstmt1=con.prepareStatement(Age_Grp_Insert);
				
				for(int k=0;k<PatientClass.size();k++)
				{
					records=(String)PatientClass.get(k);
					pstmt.setString(1,library_id);
					pstmt.setInt(2,version_no);
					pstmt.setString(3,records);
					pstmt.setString(4,add_by_id);
					pstmt.setString(5,add_at_ws_no);
					pstmt.setString(6,add_facility_id);
					pstmt.setString(7,add_by_id);
					pstmt.setString(8,add_at_ws_no);
					pstmt.setString(9,add_facility_id);
					pstmt.addBatch();
				}
				int result1[]=pstmt.executeBatch();
				for(int i=0;i<result1.length;i++)
				{
						if(result1[i]<0 && result1[i]!=-2)
						{
						insert_record1=0;
						break;
						}
						else
						{
							insert_record1=1;
						}
				}					
				if(AgeGrpList.size()>0)
				{
					for(int j=0;j<AgeGrpList.size();j++)
					{
						values=(String)AgeGrpList.get(j);
						pstmt1.setString(1,library_id);
						pstmt1.setInt(2,version_no);
						pstmt1.setString(3,values);
						pstmt1.setString(4,add_by_id);
						pstmt1.setString(5,add_at_ws_no);
						pstmt1.setString(6,add_facility_id);
						pstmt1.setString(7,add_by_id);
						pstmt1.setString(8,add_at_ws_no);
						pstmt1.setString(9,add_facility_id);
						//pstmt1.executeUpdate();
						pstmt1.addBatch();
					}
					int result2[]=pstmt1.executeBatch();
					for(int index=0;index<result2.length;index++)
					{
						if(result2[index]<0 && result2[index]!=-2)
						{
							insert_record2=0;
							break;
						}
						else
						{
							insert_record2=1;
						}
					}
				}		
				if(pstmt != null) 
				{
					pstmt.close();
					//pstmt = null;
				}
				if(pstmt1 !=null)
				{
					pstmt1.close();
					pstmt1 = null;
				}
			}
				
				if(insert_record1==1 && insert_record2==1 && result==1) {
					map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();
					hashtable.clear();
					hashtable1.clear();
				}else if(insert_record1==1 && result==1) {
					map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale,msg,"CP");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();
					hashtable.clear();
					hashtable1.clear();
				} else {
					map.clear();
					map.put( "status", new Boolean( false) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale,msg,"CP");
					stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					hashtable.clear();
					hashtable1.clear();
					con.rollback();
					throw new Exception("Error : CP_LIBRARY");
				}		
			 if(con != null)   ConnectionManager.returnConnection(con, properties);
		
		}	catch(Exception exception)
			{
				stringbuffer.append("Error in main try " + exception.getMessage());
				System.err.println(exception.toString());
				exception.printStackTrace();
			}
	        finally
			{
			    if(con != null)
				    try
					{
						if (rs != null)
						{
							rs.close();
							//rs = null;
						}
						if(pstmt != null)
						{
							pstmt.close();
							//pstmt = null;
						}
						if(pstmt1 !=null)
						{
							pstmt1.close();
							//pstmt1 = null;
						}
			            if(con != null)
				            ConnectionManager.returnConnection(con, properties);
					}
                catch(Exception exception2) 
				{ 
					stringbuffer.append("Error in main try " + exception2.getMessage());
				}
        }
		return map;
	}
}
