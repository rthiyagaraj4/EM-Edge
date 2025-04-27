/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.sql.*;
import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

public class XHTranslationManagerServletN extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;

	java.util.Properties p;
	Connection con ;
	PreparedStatement pslPrepStmt = null;	 
	int pkDataCnt=0;
	ResultSet rs=null;
	String facilityId="";
	int rscnt=0;  
	String client_ip_address="";
	String table_id=""; 
	String language="";
	String appl = "";
	String count="";
	StringBuffer sql=new StringBuffer();
	StringBuffer sql1=new StringBuffer();
	String pk_value="";
	String desc1="";
	String desc2="";
	String desc3="";
	String trans_table_id="";
	String pk_value1="";
	ArrayList columnNames=null;
	String locale = "";
	int cnt=0;
	HttpSession session;
    public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");				
        
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		locale  = p.getProperty("LOCALE");

		if(facilityId==null) facilityId="";
	    client_ip_address = p.getProperty("client_ip_address");
		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			insertRecords(req, res);
		}
		catch(Exception e)
		{
			System.out.println("XHTranslationManagerServletN.java e.toString() "+e.toString());
		}
	finally
		{
			ConnectionManager.returnConnection(con, req);
		}

	}


	private void insertRecords(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			columnNames=new ArrayList();
			String addedById = p.getProperty( "login_user" ) ;
    		String modifiedById = addedById ;
	    	String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			String table_or_from="";

			table_id=req.getParameter("master_table_id")==null?"":req.getParameter("master_table_id");
			table_or_from=req.getParameter("table_or_from")==null?"":req.getParameter("table_or_from");
			language = req.getParameter("language")==null?"":req.getParameter("language");

			appl = req.getParameter("application")==null?"":req.getParameter("application");

			trans_table_id = req.getParameter("trans_tab_id")==null?"":req.getParameter("trans_tab_id");
			int trans_tbl_len = trans_table_id.length();
			String trans_tbl_type = trans_table_id.substring(trans_tbl_len-4,trans_tbl_len);
// 			 System.out.println("XHTranslationManagerResult.jsp trans_table_id : "+trans_table_id.substring(trans_tbl_len-4,trans_tbl_len)); 
			count= req.getParameter("cnt");
			pkDataCnt= Integer.parseInt(req.getParameter("pkDataCnt"));
			cnt=Integer.parseInt(count);
//				System.out.println("XHTranslationManagerServletN.java cnt : "+cnt);
           int countOrder1=0;
		    sql.setLength(0);
//			added on Mar 12th
			if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL")) {
					sql.append("SELECT trans_column_id  FROM  xh_mapping WHERE  master_table_id=? order by srl_no");
			}
			else{
					sql.append("SELECT column_id  FROM  xh_mapping WHERE  master_table_id=? order by srl_no");
			}

//				System.out.println("XHTranslationManagerServletN.java sql 102 : "+sql);
//				System.out.println("XHTranslationManagerServletN.java sql 102 executeQuery: ");
				pslPrepStmt=con.prepareStatement(sql.toString());
				pslPrepStmt.setString(1,table_id);
		//		System.out.println("112 pslPrepStmt : "+pslPrepStmt);
				 rs=pslPrepStmt.executeQuery();
		   
		   while(rs.next())
			{
			 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")){
				  	if(!(rs.getString("trans_column_id").equals("DESC1_VALUE"))){
//				 System.out.println(" 121 trans_column_id : " +rs.getString("trans_column_id"));
						columnNames.add(rs.getString("trans_column_id"));
					}
			 }
             else{
				 	String coll_id  = "";
				 	if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL")) {
						coll_id  = rs.getString("trans_column_id");
//						System.out.println("coll_id1 : "+coll_id);
					}
					else{
						coll_id  = rs.getString("column_id");
//						System.out.println("coll_id2 : "+coll_id);
					}
						
			   columnNames.add(coll_id);
			 }
			} // end of rs.next();

			if(rs!=null)	rs.close();
			if(pslPrepStmt!=null) pslPrepStmt.close();

			for(int i=0;i<cnt;i++)
			{
				sql.setLength(0);
				if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
					{
						sql.append("SELECT COUNT(*) count FROM "+trans_table_id+ "  WHERE  TABLE_ID=? AND APPLICATION_ID =?   "); 
					}else
					{
					sql.append("SELECT COUNT(*) count FROM "+trans_table_id+ "  WHERE  APPLICATION_ID =?   "); 

					
					}
				int inparam1=1;
//				System.out.println("XHTranslationManagerServletN.java 147 pkDataCnt : "+pkDataCnt);
				for( int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
				{
				  sql.append("and  "+(String)columnNames.get(pkcnt)+"=?"); 
				}
//				pk_value=req.getParameter("pk"+i)==null?"":req.getParameter("pk"+i);
				if(i == cnt-1){
//					System.out.println("XHTranslationManagerServletN.java sql131 : "+sql);
//					System.out.println("XHTranslationManagerServletN.java sql 131 inparam1: "+inparam1);
				}

//				System.out.println("sql.toString() 170:"+sql.toString());

				pslPrepStmt=con.prepareStatement(sql.toString());
				if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
					{
				pslPrepStmt.setString(inparam1,table_id);
				inparam1++;
					}
				pslPrepStmt.setString(inparam1,appl);
				inparam1++;
//				System.out.println("XHTranslationManagerServletN.java 166 pkDataCnt : "+pkDataCnt);
				for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
				{
//				System.out.println("pk hidden Val: "+req.getParameter("pk"+countOrder1+""+pkcnt));
				pslPrepStmt.setString(inparam1,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
				inparam1++;
				}
//				System.out.println("inparam1 194: "+inparam1);

//				System.out.println("195 pslPrepStmt : "+pslPrepStmt);
				rs=pslPrepStmt.executeQuery();
				rs.next();
				if(rs!=null)	rs.close();
				
				int countOrder=0;
		/*	if(rs.getInt("count")>0)
			{*/
				sql.setLength(0);
        
			  sql.append("update " + trans_table_id+ "  set  ");
	/*	         if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
				{
					for(int k=1;k<=pkDataCnt;k++){
	//					sql.append((String )columnNames.get(k)+"=?,");
						sql.append("ext_pk"+k+"_value"+"=?,"); 
					}

            }
			*/
//			System.out.println("pkDataCnt : "+pkDataCnt);

			if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
            {
					sql.append("ext_pk_id=?,"); 
            }

			else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL"))
            {
				for(int k=1;k<=pkDataCnt;k++){
//					sql.append((String )columnNames.get(k)+"=?,");
					sql.append("ext_pk"+k+"_value"+"=?,"); 
				}
					sql.append("combined_ext_pk_value=?,"); 
					// added on jan 9th
					sql.append("combined_ehis_pk_value=?,"); 

            }
            // for Others - added on Mar 13th 
			else if(pkDataCnt>1){
 				   sql.append("combined_ext_pk_value=?,"); 
					// added on jan 9th
					sql.append("combined_ehis_pk_value=?,"); 
			}

			for(int k=pkDataCnt;k<columnNames.size();k++)
			{
				if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL")){
					sql.append((String )columnNames.get(k)+"=?,");
				}
				else
				{
//					String colfields=(String )columnNames.get(k);
//					System.out.println("colfields"+colfields);
                    //if(                      
				if(((String)columnNames.get(k)).substring(0,3).equals("EXT")){

							sql.append((String )columnNames.get(k)+"=?,");
                           
						//sql.append(colValue.get(k)+" EXT_"+(String)colValue.get(k));
					}
					else{
					sql.append("EXT_"+(String )columnNames.get(k)+"=?,");
					//	sql.append((String )columnNames.get(k)+"=?,");
					}
					
				}
			
			}

		   if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
				{
					sql.append("  MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where  TABLE_ID=? and APPLICATION_ID=?  ");
				}else
				{
					sql.append("  MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where  APPLICATION_ID=?  ");
		
				}



			for( int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			  sql.append("and  "+(String)columnNames.get(pkcnt)+"=?"); 
			}
						
			 desc1=req.getParameter("desc0"+i)==null?"":req.getParameter("desc0"+i);
			
			String pkNewVal = req.getParameter("pkVal0"+i)==null?"":req.getParameter("desc0"+i); 
//						System.out.println("pkNewVal and desc1 are  : " +pkNewVal+" "+desc1);
// 			 cmmntd on Dec 30 and added abov line of code also
//			if(!desc1.equals(""))
			if(!desc1.equals("") || !pkNewVal.equals(""))
			{
//				 System.out.println("228 !desc1.equals");
				if(i == cnt-1){
//					System.out.println("XHTranslationManagerServletN.java sql255 : "+sql);
//					System.out.println("XHTranslationManagerServletN.java sql 256 inparam1: "+inparam1);
				}	
				
				pslPrepStmt=con.prepareStatement(sql.toString());
				int  inparam=1;
				// added on Oct 15
				if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL")){
					for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
					{
					pslPrepStmt.setString(inparam,req.getParameter("pkVal"+pkcnt+""+countOrder1)==null?"":req.getParameter("pkVal"+pkcnt+""+countOrder1));
					inparam++;
//					System.out.println("XHTranslationManagerServletN.java  aft extpk  inparam: "+inparam);
					}
				}	

			// Added oct16
			if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){
				String ext_pk1 = "";
				String ext_pk2 = "";
				ext_pk1 = (String)req.getParameter("pkVal0"+countOrder1);
				ext_pk2 = (String)req.getParameter("pkVal1"+countOrder1);
				String combined_ext_key = ext_pk1+"-"+ext_pk2;
//				System.out.println("combined_ext_key : "+combined_ext_key);
				pslPrepStmt.setString(inparam,combined_ext_key);
				inparam++;
				int ehis_pkcnt = 0;
				String ehis_pk1 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				ehis_pkcnt ++;
				String ehis_pk2 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				String combined_ehis_key = ehis_pk1+"^"+ehis_pk2;
				pslPrepStmt.setString(inparam,combined_ehis_key);
				inparam++;
			} // END OF DKEY

			// Added on jun11
			if(trans_tbl_type.equals("APPL")){
				String ext_pk1 = "";
				String ext_pk2 = "";
				String ext_pk3 = "";
				ext_pk1 = (String)req.getParameter("pkVal0"+countOrder1);
				ext_pk2 = (String)req.getParameter("pkVal1"+countOrder1);
				ext_pk3 = (String)req.getParameter("pkVal2"+countOrder1);
				String combined_ext_key = ext_pk1+"-"+ext_pk2+"-"+ext_pk3;
//				System.out.println("combined_ext_key : "+combined_ext_key);
				pslPrepStmt.setString(inparam,combined_ext_key);
				inparam++;
				int ehis_pkcnt = 0;
				String ehis_pk1 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				ehis_pkcnt ++;
				String ehis_pk2 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				ehis_pkcnt ++;
				String ehis_pk3 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				String combined_ehis_key = ehis_pk1+"^"+ehis_pk2+"^"+ehis_pk3;
//				System.out.println("combined_eHis_key : "+combined_ehis_key);
				pslPrepStmt.setString(inparam,combined_ehis_key);
				inparam++;
			} // END OF APPL
           // modified on Mar 17th
			if(!trans_table_id.equals("XH_OTH_APPL_DATA_SKEY") && !trans_table_id.equals("XH_OTH_APPL_DATA_DKEY") && !trans_tbl_type.equals("APPL")){
					if(pkDataCnt>1){
						String ext_val = "";
						String combined_ext_key = "";
//						for(int k=0;k<columnNames.size()-pkDataCnt;k++)
						for(int k=0;k<pkDataCnt;k++)
						{
							ext_val = req.getParameter("desc"+k+""+countOrder)==null?"":req.getParameter("desc"+k+""+countOrder);
							if(k==0){
								combined_ext_key = ext_val;
							}
							else{
								combined_ext_key = combined_ext_key+"-"+ext_val;
							}
						}
//						System.out.println("311  combined_ext_key : "+combined_ext_key);
						pslPrepStmt.setString(inparam,combined_ext_key);
						inparam++;

						String ehis_val = "";
						String combined_ehis_key = "";

						for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
						{
							ehis_val = req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt);
							if(pkcnt==0){
								combined_ehis_key = ehis_val;
							}
							else{
								combined_ehis_key = combined_ehis_key+"^"+ehis_val;
							}
						}
//						System.out.println("322  combined_ehis_key : "+combined_ehis_key);
						pslPrepStmt.setString(inparam,combined_ehis_key);
						inparam++;
					}
			} // END OF OTHER than SKEY && DKEY

			for(int k=0;k<columnNames.size()-pkDataCnt;k++)
			{
//				System.out.println("256 k<columnNames.size");
				pslPrepStmt.setString(inparam,req.getParameter("desc"+countOrder+""+i)==null?"":req.getParameter("desc"+countOrder+""+i));
			   countOrder++;	
			   inparam++;
			}
//  				System.out.println("XHTranslationManagerServletN.java  273 aft desc  inparam: "+inparam);
			   pslPrepStmt.setString(inparam,modifiedById);
			   inparam++;
			   pslPrepStmt.setString(inparam,modifiedAtWorkstation);
				inparam++;
				pslPrepStmt.setString(inparam,modifiedFacilityId);
				inparam++;
//   				System.out.println("XHTranslationManagerServletN.java  280 aft fac_id  inparam: "+inparam);
// 				if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL"))
				if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY") )
					{
				pslPrepStmt.setString(inparam,table_id);
				inparam++;
					}
//   				System.out.println("XHTranslationManagerServletN.java 286  aft tab_id  inparam: "+inparam);
				pslPrepStmt.setString(inparam,appl);
				inparam++;
//   				System.out.println("XHTranslationManagerServletN.java 286  aft appl_id  inparam: "+inparam);
				for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
				{
//					System.out.println("292 pkeHISVal : "+req.getParameter("pk"+countOrder1+""+pkcnt));
//					System.out.println("292 pkeHISVal : "+java.net.URLEncoder.encode(req.getParameter("pk"+countOrder1+""+pkcnt)));			
				pslPrepStmt.setString(inparam,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
				inparam++;

				}
//   				System.out.println("XHTranslationManagerServletN.java 286  aft pk_val  inparam: "+inparam);

				countOrder1++;
//					System.out.println("283 pslPrepStmt : "+pslPrepStmt);
//					System.out.println("XHTranslationManagerServletN.java sql 287 inparam1: "+inparam1);
				rscnt= pslPrepStmt.executeUpdate();
			} // !desc1 ||  !pkNewVal
			else
			{ 
				if(i == cnt-1){
//					System.out.println("XHTranslationManagerServletN.java sql 293 : "+sql);
//					System.out.println("XHTranslationManagerServletN.java sql 293 inparam1: "+inparam1);
				}	


				pslPrepStmt=con.prepareStatement(sql.toString());
				int  inparam=1;
				// added on Oct 15
				if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL")){
	//				System.out.println("desc null 275");
					for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
					{
						pslPrepStmt.setString(inparam,req.getParameter("pkVal"+pkcnt+""+countOrder1)==null?"":req.getParameter("pkVal"+pkcnt+""+countOrder1));
						inparam++;
					}
//				System.out.println("inparam 307 : "+inparam);
				}

				// Added oct16
				if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){
					String ext_pk1 = "";
					String ext_pk2 = "";
					ext_pk1 = (String)req.getParameter("pkVal0"+countOrder1);
					ext_pk2 = (String)req.getParameter("pkVal1"+countOrder1);
					String combined_ext_key = ext_pk1+"-"+ext_pk2;
	//				System.out.println("combined_ext_key : "+combined_ext_key);
					pslPrepStmt.setString(inparam,combined_ext_key);
					inparam++;
					int ehis_pkcnt = 0;
	//				System.out.println("countOrder1 : "+countOrder1);
					String ehis_pk1 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
					ehis_pkcnt ++;
					String ehis_pk2 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
					String combined_ehis_key = ehis_pk1+"^"+ehis_pk2;
					pslPrepStmt.setString(inparam,combined_ehis_key);
					inparam++;
				}
			// Added on jun11
			if(trans_tbl_type.equals("APPL")){
				String ext_pk1 = "";
				String ext_pk2 = "";
				String ext_pk3 = "";
				ext_pk1 = (String)req.getParameter("pkVal0"+countOrder1);
				ext_pk2 = (String)req.getParameter("pkVal1"+countOrder1);
				ext_pk3 = (String)req.getParameter("pkVal2"+countOrder1);
				String combined_ext_key = ext_pk1+"-"+ext_pk2+"-"+ext_pk3;
//				System.out.println("combined_ext_key : "+combined_ext_key);
				pslPrepStmt.setString(inparam,combined_ext_key);
				inparam++;
				int ehis_pkcnt = 0;
				String ehis_pk1 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				ehis_pkcnt ++;
				String ehis_pk2 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				ehis_pkcnt ++;
				String ehis_pk3 = (String)req.getParameter("pk"+countOrder1+""+ehis_pkcnt);
				String combined_ehis_key = ehis_pk1+"^"+ehis_pk2+"^"+ehis_pk3;
				pslPrepStmt.setString(inparam,combined_ehis_key);
				inparam++;
			} // END OF APPL
				for(int k=0;k<columnNames.size()-pkDataCnt;k++)
				{
//					System.out.println("315 k<columnNames.size");
					pslPrepStmt.setString(inparam,req.getParameter("desc"+countOrder+""+i)==null?"":req.getParameter("desc"+countOrder+""+i));
				   countOrder++;	
				   inparam++;
				}
//							System.out.println("inparam 331 : "+inparam);
				   pslPrepStmt.setString(inparam,modifiedById);
				   inparam++;
				   pslPrepStmt.setString(inparam,modifiedAtWorkstation);
					inparam++;
					pslPrepStmt.setString(inparam,modifiedFacilityId);
					inparam++;
//							System.out.println("inparam 338 aft facility : "+inparam);
//					if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")||trans_tbl_type.equals("APPL"))
					if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))

						{
					pslPrepStmt.setString(inparam,table_id);
					inparam++;
						}
//						System.out.println("inparam 344 aft tbl_id : "+inparam);
					pslPrepStmt.setString(inparam,appl);
					inparam++;
//						System.out.println("inparam 344 aft appl_id : "+inparam);
					for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
					{
					pslPrepStmt.setString(inparam,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
					inparam++;
					}
//						System.out.println("inparam 352 aft pkval : "+inparam);
					countOrder1++;
//						System.out.println("343 pslPrepStmt : "+pslPrepStmt);
//						System.out.println("XHTranslationManagerServletN.java sql 355 inparam for Update: "+inparam);
					rscnt= pslPrepStmt.executeUpdate();
//						System.out.println("358 rscnt  : "+rscnt);
				} // !( !desc1 ||  !pkNewVal )
		  
				if(pslPrepStmt!=null) pslPrepStmt.close();
						
			} // END OF FOR
			
			con.commit();
//	            System.out.println("358 rscnt  : "+rscnt);

//				Code added on 24/12/2008
			MessageManager mm=new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			String message = ((String) mesg.get("message"));
			 res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+message+"&err_value=1");
		
	}
	catch ( Exception e )
		{  try
			{con.rollback();
			System.out.println("XHTranslationManagerServletN.java Exc e"+e.toString());
			e.printStackTrace();
			
		//	out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			}catch(Exception e1)
			{e.printStackTrace();
			System.out.println("XHTranslationManagerServletN.java Exc e1 : "+e.toString());
			}
	}
	finally {
			XHUtil.closeDBResources(null, null, con);

		}
} // END OF insertRecords

}
