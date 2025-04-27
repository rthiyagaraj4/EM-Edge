/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.OtherStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.*;
import java.util.Properties;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;


/**
*
* @ejb.bean
*	name="OtherStaff"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OtherStaff"
*	local-jndi-name="OtherStaff"
*	impl-class-name="eAM.OtherStaff.OtherStaffManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.OtherStaff.OtherStaffLocal"
*	remote-class="eAM.OtherStaff.OtherStaffRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.OtherStaff.OtherStaffLocalHome"
*	remote-class="eAM.OtherStaff.OtherStaffHome"
*	generate= "local,remote"
*
*
*/



public class OtherStaffManager
    implements SessionBean
{

    public OtherStaffManager()
    {
        ct = 0;
        ct1 = 0;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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

    public void setSessionContext(SessionContext session)
    {
    }

/**
* @ejb.interface-method
*	 view-type="both"
*/
  public HashMap insertOperation(Properties properties,HashMap hashmap )
      
    {
			String s  = (String)hashmap.get("otherstafftype");
			String s1 = (String)hashmap.get("otherstaffid");
			String s2 = (String)hashmap.get("otherstaffname");
			String s3 = (String)hashmap.get("shortname");
			String s4 = (String)hashmap.get("sex");
			String s5 = (String)hashmap.get("birthdate");
			String s6 = (String)hashmap.get("birthplace");
			String s7 = (String)hashmap.get("maritalstatus");
			String s8 = (String)hashmap.get("aliasname");
			String s9 = (String)hashmap.get("citizen");
			String s10= (String)hashmap.get("nationalidno");
			String s11= (String)hashmap.get("Position");
			String s12 = (String)hashmap.get("emplstatus");
			String s13 = (String)hashmap.get("degree");
			String s14= (String)hashmap.get("allfacilities");
			String s15= (String)hashmap.get("repfacility");
			String s16= (String)hashmap.get("restelno");
			String s17= (String)hashmap.get("pagerno");
			String s18= (String)hashmap.get("mobileno");
			String s19 = (String)hashmap.get("offtelno");
			String s20= (String)hashmap.get("offtelext");
			String s21= (String)hashmap.get("faxno");
			String s22 = (String)hashmap.get("emailid");
			String s23= (String)hashmap.get("prefmode");
			String s24 = (String)hashmap.get("resaddln1");
			String s25= (String)hashmap.get("resaddln2");
			String s26= (String)hashmap.get("resaddln3");
			String s27 = (String)hashmap.get("resaddln4");
			String s28= (String)hashmap.get("respostalcode");
			String s29= (String)hashmap.get("rescountrycode");
			String s30= (String)hashmap.get("offaddln1");
			String s31= (String)hashmap.get("offaddln2");
			String s32= (String)hashmap.get("offaddln3");
			String s33= (String)hashmap.get("offaddln4");
			String s34 = (String)hashmap.get("offpostalcode");
			String s35= (String)hashmap.get("offcountrycode");
			String s36 = (String)hashmap.get("mailaddln1");
			String s37 = (String)hashmap.get("mailaddln2");
			String s38= (String)hashmap.get("mailaddln3");
			String s39= (String)hashmap.get("mailaddln4");
			String s40= (String)hashmap.get("mailpostalcode");
			String s41= (String)hashmap.get("mailcountrycode");
			String s42= (String)hashmap.get("effectiveDateFrom");
			String s43 = (String)hashmap.get("effectiveDateTo");
			String s44= (String)hashmap.get("effectiveStatus");
			String s45= (String)hashmap.get("facilityId");
			String s46 = (String)hashmap.get("client_ip_address");
			String s47= (String)hashmap.get("employeeid");
			String s55= (String)hashmap.get("longname");
			String locale="";
			/*Below line added for this CRF HAS-CRF-160*/
		String other_alt_type=(String) hashmap.get("other_alt_type");
		String other_alt_no=(String) hashmap.get("other_alt_no");		
		
		
			
			
			locale= properties.getProperty("LOCALE"); 
            hashmap.clear();

		
        HashMap hashmap1 = new HashMap();
        boolean flag = false;
        boolean flag2 = true;
        StringBuffer stringbuffer = new StringBuffer("");
        boolean flag3 = false;
        String s48 = "insert into \t am_other_staff(\t other_staff_type, other_staff_id, other_staff_name,  short_name, gender,  date_of_birth, place_of_birth,  mar_status_code, alias_name,  citizenship_code, national_id_num,  position_code,  empl_status, degree,  all_facilities_yn, reporting_facility_id,  res_tel_num, pager_num,  mobile_num, off_tel_num,  off_tel_ext, fax_num,  email_id, pref_contact_mode,  res_add_ln1, res_add_ln2,  res_add_ln3, res_add_ln4,  res_add_postal_code, res_add_country_code,  off_add_ln1, off_add_ln2,  off_add_ln3, off_add_ln4,  off_add_postal_code, off_add_country_code,  mail_add_ln1, mail_add_ln2,  mail_add_ln3, mail_add_ln4,  mail_add_postal_code, mail_add_country_code,  eff_date_from, \teff_date_to,\t eff_status,  added_by_id,\t\tadded_date,  added_facility_id, added_at_ws_no,  modified_by_id,\t modified_date,  modified_facility_id,\tmodified_at_ws_no,employee_id,LONG_NAME,OTH_ALT_ID_TYPE, OTH_ALT_ID_NO  ) values (?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
        String s49 = properties.getProperty("login_user");
        String s50 = dateFormat.format(new Date());
        String s51 = s49;
        String s52 = s50;
        String s53 = s45;
        String s54 = s46;
        java.sql.Date date = null;
        java.sql.Date date1 = null;
        java.sql.Date date2 = java.sql.Date.valueOf(s50);
        java.sql.Date date3 = java.sql.Date.valueOf(s52);
        ResultSet resultset = null;
        ResultSet resultset1 = null;
        ResultSet resultset2 = null;
        if(s42 != null && !s42.equals(""))
            date = java.sql.Date.valueOf(s42);
        if(s43 != null && !s43.equals(""))
            date1 = java.sql.Date.valueOf(s43);
		try{
        try
        {
            con = ConnectionManager.getConnection(properties);
            pstmt2 = con.prepareStatement("select count(*) as total from sm_facility_param");
            resultset1 = pstmt2.executeQuery();
            resultset1.next();
            ct = resultset1.getInt("total");
			if(resultset1 != null)
                    resultset1.close();
			if(pstmt2 != null) pstmt2.close();
            facilityid = new String[ct];
            pstmt = con.prepareStatement("select 1 from  am_other_staff where other_staff_id = ?");
            pstmt.setString(1, s1);
            resultset = pstmt.executeQuery();
            if(resultset.next())
            {
                flag2 = false;
                Hashtable hashtable2 = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
                stringbuffer.append((String)hashtable2.get("message"));
				 hashtable2.clear();

            } if(resultset != null)
                    resultset.close();
			if(pstmt != null) pstmt.close();
            pstmt1 = con.prepareStatement("select facility_id from sm_facility_param");
            resultset2 = pstmt1.executeQuery();
            for(int l = 0; resultset2.next(); l++)
            {
                facilityid[l] = resultset2.getString("facility_id");
                flag3 = true;
            }if(resultset2 != null)
                resultset2.close();
			if(pstmt1 != null) pstmt1.close();

        }
        catch(Exception exception)
        {
            flag2 = false;
            flag3 = false;
            stringbuffer.append(exception.getMessage() + "<br>");
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if(resultset != null)
                    resultset.close();
                if(resultset2 != null)
                    resultset2.close();
                if(resultset1 != null)
                    resultset1.close();
            }
            catch(Exception exception6) { 
			exception6.printStackTrace();}
        }
        if(flag2)
            try
            {
                pstmt = con.prepareStatement(s48);
                pstmt.setString(1, s);
                pstmt.setString(2, s1);
                pstmt.setString(3, s2);
                pstmt.setString(4, s3);
                pstmt.setString(5, s4);
                pstmt.setString(6, s5);
                pstmt.setString(7, s6);
                pstmt.setString(8, s7);
                pstmt.setString(9, s8);
                pstmt.setString(10, s9);
                pstmt.setString(11, s10);
                pstmt.setString(12, s11);
                pstmt.setString(13, s12);
                pstmt.setString(14, s13);
                pstmt.setString(15, s14);
                if(s15 == "" || s15 == "null" || s15 == " ")
                    pstmt.setString(16, null);
                else
                    pstmt.setString(16, s15);
                pstmt.setString(17, s16);
                pstmt.setString(18, s17);
                pstmt.setString(19, s18);
                pstmt.setString(20, s19);
                pstmt.setString(21, s20);
                pstmt.setString(22, s21);
                pstmt.setString(23, s22);
                if(s23 == "" || s23 == "null" || s23 == " ")
                    pstmt.setString(24, null);
                else
                    pstmt.setString(24, s23);
                pstmt.setString(25, s24);
                pstmt.setString(26, s25);
                pstmt.setString(27, s26);
                pstmt.setString(28, s27);
                if(s28 == "" || s28 == "null" || s28 == " ")
                    pstmt.setString(29, null);
                else
                    pstmt.setString(29, s28);
                if(s29 == "" || s29 == "null" || s29 == " ")
                    pstmt.setString(30, null);
                else
                    pstmt.setString(30, s29);
                pstmt.setString(31, s30);
                pstmt.setString(32, s31);
                pstmt.setString(33, s32);
                pstmt.setString(34, s33);
                if(s34 == "" || s34 == "null" || s34 == " ")
                    pstmt.setString(35, null);
                else
                    pstmt.setString(35, s34);
                if(s35 == "" || s35 == "null" || s35 == " ")
                    pstmt.setString(36, null);
                else
                    pstmt.setString(36, s35);
                pstmt.setString(37, s36);
                pstmt.setString(38, s37);
                pstmt.setString(39, s38);
                pstmt.setString(40, s39);
                if(s40 == "" || s40 == "null" || s40 == " ")
                    pstmt.setString(41, null);
                else
                    pstmt.setString(41, s40);
                if(s41 == "" || s41 == "null" || s41 == " ")
                    pstmt.setString(42, null);
                else
                    pstmt.setString(42, s41);
                pstmt.setDate(43, date);
                pstmt.setDate(44, date1);
                pstmt.setString(45, s44);
                pstmt.setString(46, s49);
                pstmt.setDate(47, date2);
                pstmt.setString(48, s45);
                pstmt.setString(49, s46);
                pstmt.setString(50, s51);
                pstmt.setDate(51, date3);
                pstmt.setString(52, s53);
                pstmt.setString(53, s54);
                pstmt.setString(54, s47);
                pstmt.setString(55, s55);
				//Added HSA-CRF-160
				pstmt.setString(56, other_alt_type);
				pstmt.setString(57, other_alt_no);
				
                int i = pstmt.executeUpdate();
                if(i != 0)
                {
                    flag = true;
                    con.commit();
                }
                if(s14.equals("Y"))
                {
                    for(int j = 0; j < facilityid.length; j++)
                    {
                        String s58 = "insert into am_other_staff_for_facility(  facility_id, other_staff_id,  eff_date_from, \teff_date_to,\t eff_status,  added_by_id,\t\tadded_date,   added_at_ws_no,added_facility_id,  modified_by_id,\t modified_date,  \tmodified_at_ws_no,modified_facility_id  ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        String s60 = "E";
                        if(flag3)
                            try
                            {
                                pstmt1 = con.prepareStatement(s58);
                                pstmt1.setString(1, facilityid[j]);
                                pstmt1.setString(2, s1);
                                pstmt1.setDate(3, date);
                                pstmt1.setDate(4, date1);
                                pstmt1.setString(5, s60);
                                pstmt1.setString(6, s49);
                                pstmt1.setDate(7, date2);
                                //pstmt1.setString(8, s45); // commented and below line added by mujafar for MOHE-SCF-0011
								pstmt1.setString(8, s46);
                                //pstmt1.setString(9, s46); // commented and below line added by mujafar for MOHE-SCF-0011
								pstmt1.setString(9, s45);
                                pstmt1.setString(10, s51);
                                pstmt1.setDate(11, date3);
                               // pstmt1.setString(12, s53); // commented and below line added by mujafar for MOHE-SCF-0011
								 pstmt1.setString(12, s54);
                                //pstmt1.setString(13, s54); // commented and below line added by mujafar for MOHE-SCF-0011
								pstmt1.setString(13, s53);
                                int k = pstmt1.executeUpdate();
                                if(k != 0)
                                {
                                    flag = true;
                                    con.commit();
                                } else
                                {
                                    flag = false;
                                }
                                pstmt1.close();
                            }
                            catch(Exception exception3)
                            {
                                try
                                {
                                    con.rollback();
									if(pstmt != null) pstmt.close();
									if(pstmt1 != null) pstmt1.close();
									if(pstmt2 != null) pstmt2.close();
                                }
                                catch(Exception exception4) {
								exception4.printStackTrace();}
                                exception3.printStackTrace();
                            }
                    }

                }
                if(flag)
                {
                    Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
                    stringbuffer.append((String)hashtable1.get("message"));
                }
                pstmt.close();
            }
            catch(Exception exception1)
            {
                try
                {
                    con.rollback();
                }
                catch(Exception exception2) {
				exception2.printStackTrace();}
                stringbuffer.append(exception1.getMessage() + "<br>");
                exception1.printStackTrace();
            }
            finally
            {
                
                    try
                    {
                        ConnectionManager.returnConnection(con, properties);
                    }
                    catch(Exception exception8) {
					exception8.printStackTrace();}
            }
        hashmap1.put("status", new Boolean(flag));
        hashmap1.put("error", stringbuffer.toString());
		}catch(Exception exception9) {
					exception9.printStackTrace();}
		 finally
            {
                
                    try
                    {
                        ConnectionManager.returnConnection(con, properties);
                    }
                    catch(Exception exception22) {
					exception22.printStackTrace();}
            }
        return hashmap1;
    }

/**
* @ejb.interface-method
*	 view-type="both"
*/
    public HashMap updateOperation(Properties properties,HashMap hashmap )
       
    {
			String s  = (String)hashmap.get("otherstafftype");
			String s1 = (String)hashmap.get("otherstaffid");
			String s2 = (String)hashmap.get("otherstaffname");
			String s3 = (String)hashmap.get("shortname");
			String s4 = (String)hashmap.get("sex");
			String s5 = (String)hashmap.get("birthdate");
			String s6 = (String)hashmap.get("birthplace");
			String s7 = (String)hashmap.get("maritalstatus");
			String s8 = (String)hashmap.get("aliasname");
			String s9 = (String)hashmap.get("citizen");
			String s10= (String)hashmap.get("nationalidno");
			String s11= (String)hashmap.get("Position");
			String s12 = (String)hashmap.get("emplstatus");
			String s13 = (String)hashmap.get("degree");
			String s14= (String)hashmap.get("allfacilities");
			String s15= (String)hashmap.get("repfacility");
			String s16= (String)hashmap.get("restelno");
			String s17= (String)hashmap.get("pagerno");
			String s18= (String)hashmap.get("mobileno");
			String s19 = (String)hashmap.get("offtelno");
			String s20= (String)hashmap.get("offtelext");
			String s21= (String)hashmap.get("faxno");
			String s22 = (String)hashmap.get("emailid");
			String s23= (String)hashmap.get("prefmode");
			String s24 = (String)hashmap.get("resaddln1");
			String s25= (String)hashmap.get("resaddln2");
			String s26= (String)hashmap.get("resaddln3");
			String s27 = (String)hashmap.get("resaddln4");
			String s28= (String)hashmap.get("respostalcode");
			String s29= (String)hashmap.get("rescountrycode");
			String s30= (String)hashmap.get("offaddln1");
			String s31= (String)hashmap.get("offaddln2");
			String s32= (String)hashmap.get("offaddln3");
			String s33= (String)hashmap.get("offaddln4");
			String s34 = (String)hashmap.get("offpostalcode");
			String s35= (String)hashmap.get("offcountrycode");
			String s36 = (String)hashmap.get("mailaddln1");
			String s37 = (String)hashmap.get("mailaddln2");
			String s38= (String)hashmap.get("mailaddln3");
			String s39= (String)hashmap.get("mailaddln4");
			String s40= (String)hashmap.get("mailpostalcode");
			String s41= (String)hashmap.get("mailcountrycode");
			String s42= (String)hashmap.get("effectiveDateFrom");
			String s43 = (String)hashmap.get("effectiveDateTo");
			String s44= (String)hashmap.get("effectiveStatus");
			String s45= (String)hashmap.get("facilityId");
			String s46 = (String)hashmap.get("client_ip_address");
			String s47= (String)hashmap.get("employeeid");
			String s55= (String)hashmap.get("longname");
			String locale="";
			
		/*Below line added for this CRF HAS-CRF-160*/
		String other_alt_type=(String) hashmap.get("other_alt_type");
		String other_alt_no=(String) hashmap.get("other_alt_no");		
			
			
			
			locale= properties.getProperty("LOCALE"); 



        HashMap hashmap2 = new HashMap();
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = true;
        StringBuffer stringbuffer = new StringBuffer("");
        String s48 = "update am_other_staff set  other_staff_type= ?,   other_staff_name= ?,   short_name =?,    gender = ?,    date_of_birth = to_date(?,'DD/MM/YYYY'),    place_of_birth = ?,    mar_status_code = ?,    alias_name = ?,    citizenship_code = ?,    national_id_num = ?,    position_code = ?,    empl_status = ?,    degree = ?,    all_facilities_yn = ?,    reporting_facility_id = ?,    res_tel_num = ?,    pager_num = ?,    mobile_num = ?,    off_tel_num = ?,    off_tel_ext = ?,    fax_num = ?,    email_id = ?,    pref_contact_mode = ?,    res_add_ln1 = ?,   res_add_ln2 = ?,    res_add_ln3 = ?,    res_add_ln4 = ?,   res_add_postal_code = ?,    res_add_country_code = ?,    off_add_ln1 = ?,    off_add_ln2 = ?,    off_add_ln3 = ?,    off_add_ln4 = ?,    off_add_postal_code = ?,    off_add_country_code = ?,    mail_add_ln1 = ?,    mail_add_ln2 = ?,    mail_add_ln3 = ?,    mail_add_ln4 = ?,    mail_add_postal_code = ?,    mail_add_country_code = ?,    eff_date_from= ?,     eff_date_to= ?, eff_status= ?,modified_by_id= ?, modified_date= sysdate,modified_facility_id= ?,    modified_at_ws_no = ?, employee_id=?,LONG_NAME=?,OTH_ALT_ID_TYPE=?,OTH_ALT_ID_NO=?    where other_staff_id = ?";
        String s49 = properties.getProperty("login_user");
        String s50 = dateFormat.format(new Date());
        java.sql.Date date = null;
        java.sql.Date date1 = null;
        java.sql.Date date2 = java.sql.Date.valueOf(s50);
        String s51 = properties.getProperty("login_user");
        String s52 = dateFormat.format(new Date());
        java.sql.Date date3 = java.sql.Date.valueOf(s52);
        String s53 = s45;
        String s54 = s46;
        if(s42 != null && !s42.equals(""))
            date = java.sql.Date.valueOf(s42);
        if(s43 != null && !s43.equals(""))
            date1 = java.sql.Date.valueOf(s43);

         hashmap.clear();
        if(flag3)
            try
            {
                con = ConnectionManager.getConnection(properties);
                String s59 = "select count(*) as total from sm_facility_param where facility_id not in (select facility_id from am_other_staff_for_facility where  other_staff_id ='" + s1 + "')";
                pstmt2 = con.prepareStatement(s59);
                ResultSet resultset = pstmt2.executeQuery();
                resultset.next();
                ct1 = resultset.getInt("total");
                facilityid1 = new String[ct1];
                String s60 = "select facility_id from sm_facility_param where facility_id not in (select facility_id from am_other_staff_for_facility where  other_staff_id ='" + s1 + "')";
                pstmt1 = con.prepareStatement(s60);
                ResultSet resultset1 = pstmt1.executeQuery();
                for(int i = 0; resultset1.next(); i++)
                {
                    facilityid1[i] = resultset1.getString(1);
                    flag2 = true;
                }
               // if(s11==null || s11.equals("null"))
					//s11="";

                pstmt = con.prepareStatement(s48);
                pstmt.setString(1, s);
                pstmt.setString(2, s2);
                pstmt.setString(3, s3);
                pstmt.setString(4, s4);
                pstmt.setString(5, s5);
                pstmt.setString(6, s6);
                pstmt.setString(7, s7);
                pstmt.setString(8, s8);
                pstmt.setString(9, s9);
                pstmt.setString(10, s10);
				 if(s11 == "" || s11 == "null" || s11 == " ")
                pstmt.setString(11, null);
				 else
					 pstmt.setString(11, s11);
				
                pstmt.setString(12, s12);
                pstmt.setString(13, s13);
                pstmt.setString(14, s14);
                pstmt.setString(15, s15);
                pstmt.setString(16, s16);
                pstmt.setString(17, s17);
                pstmt.setString(18, s18);
                pstmt.setString(19, s19);
                pstmt.setString(20, s20);
                pstmt.setString(21, s21);
                pstmt.setString(22, s22);
                pstmt.setString(23, s23);
                pstmt.setString(24, s24);
                pstmt.setString(25, s25);
                pstmt.setString(26, s26);
                pstmt.setString(27, s27);
                pstmt.setString(28, s28);
                pstmt.setString(29, s29);
                pstmt.setString(30, s30);
                pstmt.setString(31, s31);
                pstmt.setString(32, s32);
                pstmt.setString(33, s33);
                pstmt.setString(34, s34);
                pstmt.setString(35, s35);
                pstmt.setString(36, s36);
                pstmt.setString(37, s37);
                pstmt.setString(38, s38);
                pstmt.setString(39, s39);
                pstmt.setString(40, s40);
                pstmt.setString(41, s41);
                pstmt.setDate(42, date);
                pstmt.setDate(43, date1);
                pstmt.setString(44, s44);
                pstmt.setString(45, s49);
                pstmt.setString(46, s45);
                pstmt.setString(47, s46);
                pstmt.setString(48, s47);
                pstmt.setString(49, s55);
				//Added HSA-CRF-160
				pstmt.setString(50, other_alt_type);
				pstmt.setString(51, other_alt_no);
				
                pstmt.setString(52, s1);
                int k = pstmt.executeUpdate();
                if(k != 0)
                {
                    flag = true;
                    con.commit();
                }
                if(s14.equals("Y"))
                {
                    for(int j = 0; j < facilityid1.length; j++)
                    {
                        String s61 = "insert into am_other_staff_for_facility(  facility_id, other_staff_id,  eff_date_from, \teff_date_to, eff_status,  added_by_id,added_date,  added_facility_id, added_at_ws_no,  modified_by_id,\t modified_date,  modified_facility_id,\tmodified_at_ws_no  ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        String s62 = "E";
                        if(flag2)
                            try
                            {
                                pstmt1 = con.prepareStatement(s61);
                                pstmt1.setString(1, facilityid1[j]);
                                pstmt1.setString(2, s1);
                                pstmt1.setDate(3, date);
                                pstmt1.setDate(4, date1);
                                pstmt1.setString(5, s62);
                                pstmt1.setString(6, s51);
                                pstmt1.setDate(7, date3);
                                pstmt1.setString(8, s53);
                                pstmt1.setString(9, s54);
                                pstmt1.setString(10, s49);
                                pstmt1.setDate(11, date2);
                                pstmt1.setString(12, s45);
                                pstmt1.setString(13, s46);
                                int l = pstmt1.executeUpdate();
                                if(l != 0)
                                {
                                    flag = true;
                                    con.commit();
                                } else
                                {
                                    flag = false;
                                }
                                pstmt1.close();
                            }
                            catch(Exception exception2)
                            {
                                try
                                {
                                    con.rollback();
                                }
                                catch(Exception exception3) { 
								exception3.printStackTrace();}
                                stringbuffer.append(exception2.getMessage() + "<br>");
                                exception2.printStackTrace();
                            }
                            finally
                            {
                                try
                                {
                                    if(resultset != null)
                                        resultset.close();
                                    if(resultset1 != null)
                                        resultset1.close();
                                }
                                catch(Exception exception5) {
								exception5.printStackTrace();
								}
                            }
                    }

                }
                if(flag)
                {
                    Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM");
                    stringbuffer.append((String)hashtable1.get("message"));
                }
                pstmt.close();
            }
            catch(Exception exception)
            {
                try
                {
                    con.rollback();
                }
                catch(Exception exception1) {
				exception1.printStackTrace();
				}
                stringbuffer.append(exception.getMessage() + "<br>");
                exception.printStackTrace();
            }
            finally
            {
                if(con != null)
                {
                    try
                    {
                        con.close();
						if(pstmt != null) pstmt.close();
						if(pstmt1 != null) pstmt1.close();
						if(pstmt2 != null) pstmt2.close();
                    }
                    catch(Exception exception7) { 
					exception7.printStackTrace();}
                    ConnectionManager.returnConnection(con, properties);
                }
            }
        hashmap2.put("status", new Boolean(flag));
        hashmap2.put("status", new Boolean(flag1));
        hashmap2.put("error", stringbuffer.toString());
        return hashmap2;
    }

    Connection con;
    PreparedStatement pstmt;
    PreparedStatement pstmt1;
    PreparedStatement pstmt2;
    String facilityid[];
    int ct;
    int ct1;
    String facilityid1[];
    SimpleDateFormat dateFormat;
}
