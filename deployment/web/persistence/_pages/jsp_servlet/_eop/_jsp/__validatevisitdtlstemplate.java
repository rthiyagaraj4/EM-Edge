package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public final class __validatevisitdtlstemplate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eop/jsp/ValidateVisitDtlsTemplate.jsp", 1709119502600L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n<HEAD>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eOP/js/VisitRegistrationQuery.js\' language=\'javascript\'></script>\n<script src=\'../../eOP/js/VisitRegistration.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n</HEAD>\n<BODY CLASS=\'MESSAGE\' onKeyDown=\"lockKey()\">\n<form name=\'validate_form\' id=\'validate_form\'>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<script>\t\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</script>\t\n\n</form>\n</body>\n</html>\n\n\t\t\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

void episode_validation(javax.servlet.jsp.JspWriter out, String p_visit_type_ind,String episodeReqd, String servicecode,String subservicecode, String l_patient_id,Connection con,String facility_id,String frame_list1,String locncode,String override_vtype_on_epsd_yn) throws IOException
  { 
	String setreadonly  = "F";
    String visit_date = "";
    //String str4     = "";   
	String chkFlag = "Y";
	String episode_close_days_fu="";
    String episode_close_days_wo_fu="";
	String last_visit_fu_reqd_yn="";
	//String last_visit_num="";
	int last_visit_num=0;
	String last_visit_date="";
	String episode_id="";
	String sql="";
//    String str1="";
    PreparedStatement pstmt=null;         
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	ResultSet rs=null;
	ResultSet rset2=null;
	ResultSet rset3=null;

	String dur_for_fu_vsts_in_days = "";
	int no_of_fu_visits_allowed = 0;

    try
      {
	  if (!(episodeReqd.equals("X")))
       {
	     if(!servicecode.equals(""))
	      {
			 out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='S';}");
			 /*
			try{
		       pstmt = con.prepareStatement( " select build_episode_rule from op_param_for_facility_service where service_code='"+servicecode+"' and operating_facility_id='"+facility_id+"'",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
               str1  = "";
		       int maxrecord=0;
               rs = pstmt.executeQuery();
               if( rs != null )
                {
			       rs.last();
		           maxrecord=rs.getRow();
			       rs.beforeFirst();
			       if(maxrecord != 0 )
		         	{
			          while( rs.next() )
			              {
				            str1 = rs.getString( "build_episode_rule" );
							out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='"+str1+"';}");
			              }
		             }
                 }
		        if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
		      }catch(Exception e){out.println("alert(e);");e.printStackTrace();}
			  */
	     }
	  
		 sql = "";
         sql = "select episode_id, last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"+facility_id+"' and episode_status='01' and patient_id='"+l_patient_id+"'";

         if (!servicecode.equals(""))
		  {
		       sql = sql+" and service_code='"+servicecode+"'";                     
          }           
        /*
		 * else if (str1.equals("R") && !servicecode.equals(""))//to be verified {
		 * sql = sql+" and service_code='"+servicecode+"' and
		 * subservice_code=nvl('"+subservicecode+"',subservice_code)"; }
		 */ 
		
	      pstmt   = con.prepareStatement(sql);
          rs  = pstmt.executeQuery();    
		 
             
          if( rs != null && rs.next())
          {   
				
				  if (rs.getString("episode_id") != null)
                  episode_id = rs.getString( "episode_id" );
                  if (rs.getString("last_visit_fu_reqd_yn") != null)
                  last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
                  if (rs.getString("last_visit_date") != null)
                  last_visit_date = rs.getString( "last_visit_date" );

				  last_visit_num = rs.getInt( "last_visit_num" );

				  /*	
                  if (rs.getString("last_visit_num") != null)
                  last_visit_num = rs.getString( "last_visit_num" );
				  */
				
            	   if(!servicecode.equals(""))
			       {
					 if(override_vtype_on_epsd_yn.equals("Y"))
					 {					 
						 sql = "select  nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd')) + decode('"+last_visit_fu_reqd_yn+"','Y',nvl(episode_close_days_fu,0),nvl(episode_close_days_wo_fu,0))),trunc(sysdate))),0) visit_date, nvl(episode_close_days_fu,0), nvl(episode_close_days_wo_fu,0) from op_param_for_facility_service where service_code ='"+servicecode+"' and operating_facility_id='"+facility_id+"'" ;						 
				
						 pstmt2   = con.prepareStatement(sql);
						 rset2 = pstmt2.executeQuery();
						 if (!rset2.next())
						  {
							
							sql = "select  nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd')) + decode('"+last_visit_fu_reqd_yn+"','Y',nvl(episode_close_days_fu,0),nvl(episode_close_days_wo_fu,0))),trunc(sysdate))),0) visit_date, nvl(episode_close_days_fu,0), nvl(episode_close_days_wo_fu,0) from op_param where operating_facility_id='"+facility_id+"'" ;							
							
							pstmt3   = con.prepareStatement( sql );
							rset3 = pstmt3.executeQuery();     
							if (!rset3.next())
							 {
								
								chkFlag = "N";
							 }
							 else
								{
								   
									episode_close_days_fu = rset3.getString(2);
									episode_close_days_wo_fu = rset3.getString(3);
									visit_date = rset3.getString("visit_date");
								}           
							  if(rset3 != null) rset3.close();
							  if(pstmt3 != null) pstmt3.close();
						  }else
							  {
									
									episode_close_days_fu = rset2.getString(2);
									episode_close_days_wo_fu =rset2.getString(3);
									visit_date = rset2.getString("visit_date");
							  }
						if(rset2 != null) rset2.close();
						if(pstmt2 != null) pstmt2.close();
				   }
				   else if(override_vtype_on_epsd_yn.equals("N"))
				   {
					    sql = "select nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd'))+ nvl(dur_for_follow_up_vsts_in_days,0)),trunc(sysdate))),0) visit_date, nvl(dur_for_follow_up_vsts_in_days,0) dur_for_follow_up_vsts_in_days, no_of_follow_up_visits_allowed from op_visit_type_control where service_code ='"+servicecode+"' and facility_id ='"+facility_id+"' and clinic_code = '"+locncode+"'" ;	
				
						 pstmt2   = con.prepareStatement(sql);
						 rset2 = pstmt2.executeQuery();
						 if (!rset2.next())
						 {							
							sql = "select nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd'))+ nvl(dur_for_follow_up_vsts_in_days,0)),trunc(sysdate))),0) visit_date, nvl(dur_for_follow_up_vsts_in_days,0) dur_for_follow_up_vsts_in_days, no_of_follow_up_visits_allowed from op_param where operating_facility_id='"+facility_id+"'" ;								
							
							pstmt3 = con.prepareStatement( sql );
							rset3  = pstmt3.executeQuery();     
							if (!rset3.next())
							 {
								
								chkFlag = "N";
							 }
							 else
							 {
								   
									dur_for_fu_vsts_in_days = rset3.getString("dur_for_follow_up_vsts_in_days");
									no_of_fu_visits_allowed = rset3.getInt("no_of_follow_up_visits_allowed");
									visit_date = rset3.getString("visit_date");
							 }           
							 if(rset3 != null) rset3.close();
							 if(pstmt3 != null) pstmt3.close();
						  }else
							  {
									
									dur_for_fu_vsts_in_days = rset2.getString("dur_for_follow_up_vsts_in_days");
									no_of_fu_visits_allowed = rset2.getInt("no_of_follow_up_visits_allowed");
									visit_date = rset2.getString("visit_date");
							  }
						if(rset2 != null) rset2.close();
						if(pstmt2 != null) pstmt2.close();


				   }

		         } 
		         else if(servicecode.equals(""))
		               {
			               chkFlag = "N";
		               }		
			

                  if(chkFlag.equals("Y"))
                 {
												   
					if(override_vtype_on_epsd_yn.equals("Y"))
					{
						out.println("if("+frame_list1+"forms[0].episode_close_days_fu != null){"+frame_list1+"forms[0].episode_close_days_fu.value='"+episode_close_days_fu+"';}");
						out.println("if("+frame_list1+"forms[0].episode_close_days_wo_fu != null){"+frame_list1+"forms[0].episode_close_days_wo_fu.value='"+episode_close_days_wo_fu+"';}");

						 if (visit_date.equals("-1")|| visit_date.equals("0"))
						 {						  
							 out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							 out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
							 out.println(frame_list1+"forms[0].op_episode_id.value='';"); 					 
						 }
						 else
						 {       
							   
							 if(p_visit_type_ind.equals("F"))
							 {
								   
								out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
								out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
								out.println(frame_list1+"forms[0].op_episode_id.value='';"); 
								
								}
								else
								   {
									
									
									
								out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");
								out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
								out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
								out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
								  }
					
							 if(episode_id.equals(""))
							  {
								
								out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							   out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
								out.println(frame_list1+"forms[0].op_episode_id.value='';");
							  }
						 }
					}
					else 
					{
						out.println("if("+frame_list1+"forms[0].dur_for_fu_vsts_in_days != null){"+frame_list1+"forms[0].dur_for_fu_vsts_in_days.value='"+dur_for_fu_vsts_in_days+"';}");
						out.println("if("+frame_list1+"forms[0].no_of_fu_visits_allowed != null){"+frame_list1+"forms[0].no_of_fu_visits_allowed.value='"+no_of_fu_visits_allowed+"';}");						

						 if (visit_date.equals("-1")|| visit_date.equals("0")|| last_visit_num > (no_of_fu_visits_allowed+1))
						 {	
							 out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							 out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
							 out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				 
						 }
						 else
						 {       
							   
								if(p_visit_type_ind.equals("F"))
								{									   
									out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
									out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
									out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				
								}
								else
								{									
									out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");			out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
									out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
									out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
								}
					
							   if(episode_id.equals(""))
							   {																						out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
									out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
									out.println(frame_list1+"forms[0].op_episode_id.value='';");
							   }
						 }
					}

				 }
            }			 
          else
          {
					if(override_vtype_on_epsd_yn.equals("Y"))
					{
						pstmt2   = con.prepareStatement("select episode_close_days_fu,episode_close_days_wo_fu from op_param where operating_facility_id = '"+facility_id+"'");

						rset2 = pstmt2.executeQuery();

						if (rset2!= null)
						{
							if(rset2.next())
							{
							  episode_close_days_fu   = rset2.getString("episode_close_days_fu");
							  episode_close_days_wo_fu= rset2.getString("episode_close_days_wo_fu");						  
							}
						}

						out.println(frame_list1+"forms[0].episode_close_days_fu.value='"+episode_close_days_fu+"';");
						out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='"+episode_close_days_wo_fu+"';");

						if (rset2 != null)   rset2.close();
						if (pstmt2 != null) pstmt2.close();

					}

					out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
					out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
					out.println(frame_list1+"forms[0].op_episode_id.value='';");
		}

		  if(rs != null) rs.close();
		  if(pstmt != null)  pstmt.close();

        
      }
      else
      { 
		
        setreadonly = "T";
      }
    
	  if (setreadonly.equals("T") && !(episodeReqd.equals("X")))
       {
		   
			//out.println(frame_list1+"forms[0].new_op_episode_yn.disabled=false;");
			//out.println(frame_list1+"forms[0].new_op_episode_yn.checked=true;");
			//out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
			//out.println(frame_list1+"forms[0].new_op_episode_yn.disabled=true;");
			out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
			out.println(frame_list1+"forms[0].op_episode_id.value='';");
			out.println(frame_list1+"forms[0].episode_close_days_fu.value='0';");
			out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='0';");
	   }
     }
     catch(Exception ex){
		 ex.printStackTrace();
     out.println(ex);
     out.println("alert('exception');");
    }
  }
  
  

  void episode_validation_pract(javax.servlet.jsp.JspWriter out, String p_visit_type_ind,String episodeReqd, String servicecode,String subservicecode, String l_patient_id,Connection con,String facility_id,String frame_list1,String locncode) throws IOException
  { 
	String setreadonly  = "F";     
	String last_visit_fu_reqd_yn="";	
	int last_visit_num=0;
	String last_visit_date="";
	String episode_id="";
	String sql="";
    PreparedStatement pstmt=null; 
	ResultSet rs=null;	 
    try
      {
		
	  if(!(episodeReqd.equals("X"))){
		  		
	     if(!servicecode.equals("")){
			 out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='S';}");			
	     }	  
		 sql = "";
         sql = "select episode_id, last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"+facility_id+"' and episode_status='01' and patient_id='"+l_patient_id+"'";
         if (!servicecode.equals("")){
		       sql = sql+" and service_code='"+servicecode+"'";                     
          }       
		  
	      pstmt   = con.prepareStatement(sql);
          rs  = pstmt.executeQuery();             
          if( rs != null && rs.next()){   
				
				  if (rs.getString("episode_id") != null)
                  episode_id = rs.getString( "episode_id" );
                  if (rs.getString("last_visit_fu_reqd_yn") != null)
                  last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
                  if (rs.getString("last_visit_date") != null)
                  last_visit_date = rs.getString( "last_visit_date" );
				  last_visit_num = rs.getInt( "last_visit_num" );	
				  
				  
            	   if(!servicecode.equals("")){				
					   
						if(p_visit_type_ind.equals("F")){									   
							out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
							out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				
						}else{									
							out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");			out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
							out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
							out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
						}
					}
		  if(rs != null) rs.close();
		  if(pstmt != null)  pstmt.close();
		  }else{
					
					out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
					out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
					out.println(frame_list1+"forms[0].op_episode_id.value='';");
		  }
      }
      else
      { 
		
        setreadonly = "T";
      }
    
	  if (setreadonly.equals("T") && !(episodeReqd.equals("X")))
       {			 
			out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
			out.println(frame_list1+"forms[0].op_episode_id.value='';");
			out.println(frame_list1+"forms[0].episode_close_days_fu.value='0';");
			out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='0';");
	   }
     }
     catch(Exception ex){
		 ex.printStackTrace();
     out.println(ex);
     out.println("alert('exception');");
    }
  }
  
  

//Added for the sCF - MMS-SCF-0072
  void episode_validation_insurance(javax.servlet.jsp.JspWriter out,String p_visit_type_ind,String l_patient_id,Connection con,String facility_id,String frame_list1,String locncode,String episode_id) throws IOException
  { 
	String setreadonly  = "F";     
	String last_visit_fu_reqd_yn="";	
	int last_visit_num=0;
	String last_visit_date="";
	//String episode_id="";
	String sql="";
    PreparedStatement pstmt=null; 
	ResultSet rs=null;	 
    try
      {			
		 sql = "";
		 
			 out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='S';}");			
	  
        // if(!episode_id.equals("")){
			  sql = "select  last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"+facility_id+"' and episode_status='01' and patient_id='"+l_patient_id+"' " ;
			  if(!episode_id.equals(""))
				  sql=sql+" and episode_id='"+episode_id+"'";                     
				else{
					sql=sql+" and clinic_code='"+locncode+"'";
				}
				sql = sql+" order by added_date desc"; 
				pstmt   = con.prepareStatement(sql);
				rs  = pstmt.executeQuery();             
				 if( rs != null && rs.next()){   
				
					if (rs.getString("last_visit_fu_reqd_yn") != null)
					 last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
					 if (rs.getString("last_visit_date") != null)
					 last_visit_date = rs.getString( "last_visit_date" );
					 last_visit_num = rs.getInt( "last_visit_num" );	
					 if(p_visit_type_ind.equals("F")){									   
						out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
						out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
						out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				
						out.println(frame_list1+"forms[0].vst_type_ind.value='F';"); 		
					}else{									
						out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");			
						out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
						out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
						out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
						out.println(frame_list1+"forms[0].vst_type_ind.value='L';");
					}
				}else{
					out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
					out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
					out.println(frame_list1+"forms[0].op_episode_id.value='';");
					out.println(frame_list1+"forms[0].vst_type_ind.value='F';");
				}
				   				
		  if(rs != null) rs.close();
		  if(pstmt != null)  pstmt.close();

		/* }else{
				
		 }*/
		    
		  
		  
	      
		  
      /*}
      else
      { 
		
        setreadonly = "T";
      }
    
	  if (setreadonly.equals("T") && !(episodeReqd.equals("X")))
       {			 
			out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
			out.println(frame_list1+"forms[0].op_episode_id.value='';");
			out.println(frame_list1+"forms[0].episode_close_days_fu.value='0';");
			out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='0';");
	   }*/
     }
     catch(Exception ex){
		 ex.printStackTrace();
     out.println(ex);
     out.println("alert('exception');");
    }
  }
  
  


public boolean allowToProceed(String locncode, Connection con,String facility_id,String refid, String appt_id,String allow_walk_in_yn,String allow_referral_yn,String allow_appt_yn,JspWriter out)  throws Exception
{
  StringBuffer alertString = new StringBuffer( "" ) ;
  if(!refid.equals(""))
   {
    if(allow_referral_yn.equals("N"))
     {  out.println("alert(parent.frames[1].frames[1].getMessage(\"REF_NOT_ALLOWED_FOR_CURR_CLINIC\",'OP'))");
       return false;
     }
   }
  if(! appt_id.equals(""))
   {
    if(allow_appt_yn.equals("N"))
	  {
         out.println("alert(parent.frames[1].frames[1].getMessage(\"APPT_NOT_ALLOWED_FOR_CURR_CLINIC\",'OP'))");
         return false;
     }	 
  }

 if( allow_walk_in_yn.equals("N"))
 {
 	out.println("alert(parent.frames[1].frames[1].getMessage(\"WALK_INS_NOT_ALLOWED_FOR_CURR_CLINIC\",'OP'))");
    return false;
 }

 if(!alertString.toString().equals(""))
  {
	//out.println("alert(\""+alertString.toString()+"\")");
	return false;
  }
else{
	return true;
 }

}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

    request.setCharacterEncoding("UTF-8");
    

	String sStyle	=   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


	String facility_id = (String) session.getValue("facility_id");
	String locale      = (String) session.getAttribute("LOCALE");	
	

	Connection con 	= null;	
	PreparedStatement pstmt    = null;
	ResultSet rs    = null; 
	
	//String userid = (String) session.getValue("login_user");

	String visit_dtl_temp_code = request.getParameter("visit_dtl_temp_code")==null?"":request.getParameter("visit_dtl_temp_code");
	String or_install_yn=request.getParameter("or_install_yn")==null?"":request.getParameter("or_install_yn");
	String p_referral_id=request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id");
	String q_visit_adm_type_ind= request.getParameter("q_visit_adm_type_ind")==null?"":request.getParameter("q_visit_adm_type_ind");
	//String visit_adm_type = request.getParameter("visit_adm_type")==null?"":request.getParameter("visit_adm_type");
	String functionId=request.getParameter("functionId")==null?"":request.getParameter("functionId");
	//String nat_id_prompt=request.getParameter("nat_id_prompt")==null?"":request.getParameter("nat_id_prompt");
	String episodeReqd=request.getParameter("episodeReqd")==null?"":request.getParameter("episodeReqd");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String override_vtype_on_epsd_yn = request.getParameter("override_vtype_on_epsd_yn")==null?"":request.getParameter("override_vtype_on_epsd_yn");
	String allow_pop_subser = request.getParameter("allow_pop_subser")==null?"":request.getParameter("allow_pop_subser");
	String visit_type_derv_rule = request.getParameter("visit_type_derv_rule")==null?"S":request.getParameter("visit_type_derv_rule");
	String appt_id = request.getParameter("appt_ref_no")==null?"":request.getParameter("appt_ref_no");
	String invite_no = request.getParameter("invitation_no")==null?"":request.getParameter("invitation_no");
	//String register_visit_yn = request.getParameter("register_visit_yn")==null?"":request.getParameter("register_visit_yn");	
	
	String isRoomMandatoryRegVisit = request.getParameter("isRoomMandatoryRegVisit")==null?"false":request.getParameter("isRoomMandatoryRegVisit"); // added by mujafar for NMC-JD-CRF-0025
	
	HashMap hash_Visit_Type = new HashMap();

	StringBuffer vsql =new StringBuffer();
	String VisitDate = "";
	
	String frame_ref="parent.frames[1].frames[3].document.";

	String allow_walk_in_yn="";
	String allow_referral_yn="";
	String allow_appt_yn="";

	String OP_APPL_YN="N";
	String IP_APPL_YN="N";
	String DC_APPL_YN="N";
	String EM_APPL_YN="N";

	String locncode = "";
	String locn_desc = "";
	String room_num = "";
	String service_code = "";
	String subservicecode = "";
	String visit_type_code = "";
	String practitioner_id = "";
	String other_res_class = "";
	String other_resource_id = "";
	String order_catalog_code = "";
	String contact_reason_code = "";
    String order_catalog_desc=""; 
	String contact_reason_desc = "";
	String pract_name="";
	String resource_desc="";
	String location_type="";
	boolean allowTemplatePopulation = true;
	Boolean isAllowRegForSameService=false; //Added by Mujafar  for ML-MMOH-CRF-1437
	String open_to_all_pract_yn="";
	String ident_at_checkin="";
	String primary_resource_class="";
	
	String p_visit_type_ind = "";
	
	/*Below Code variable Added for this [SS-SCF-0664]*/	
	String order_cate_code="";
	String order_types_code="";
    //End [SS-SCF-0664]
	//Added for the SCF - MMS-SCF-0167 - Begin
	String vst_date_time=request.getParameter("vst_date_time")==null?"":request.getParameter("vst_date_time");	
	String episode_id=request.getParameter("episode_id")==null?"":request.getParameter("episode_id");		
	String blng_grp_id=request.getParameter("blng_grp_id")==null?"":request.getParameter("blng_grp_id");					 
	String cust_grp_code=request.getParameter("cust_grp_code")==null?"":request.getParameter("cust_grp_code");
	String cust_code=request.getParameter("cust_code")==null?"":request.getParameter("cust_code");					 
	String policy_type_code=request.getParameter("policy_type_code")==null?"":request.getParameter("policy_type_code");		
	String visit_type_ind="";	
	//Added for the SCF - MMS-SCF-0167 - End
	
            _bw.write(_wl_block4Bytes, _wl_block4);


	try	{
    
		con = ConnectionManager.getConnection(request);	
		isAllowRegForSameService = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALLOW_VISIT_SAME_SER");//Added by Mujafar  for GHL-CRF-0527

		//String tmp_code_sel_sql ="select locn_code, (select  care_locn_type_ind  from op_clinic where clinic_code = locn_code and facility_id = '"+facility_id+"') location_type, op_get_desc.op_clinic(facility_id,locn_code,'"+locale+"','1') locn_desc, room_num, service_code, subservice_code, visit_type_code, practitioner_id,am_get_desc.AM_PRACTITIONER (practitioner_id,'"+locale+"',1) pract_name, other_res_class, other_resource_id,am_get_desc.AM_RESOURCE ('"+facility_id+"',other_resource_id,'"+locale+"',2) resource_desc, order_catalog_code,or_get_desc.or_order_catalog(order_catalog_code,'"+locale+"',2) order_cat_desc,contact_reason_code ,am_get_desc.AM_CONTACT_REASON (contact_reason_code,'"+locale+"',1) reason_desc from op_template_for_vis_regn where facility_id = '"+facility_id+"' and template_code = '"+visit_dtl_temp_code+"'";	

		//String tmp_code_sel_sql = "select c.eff_status,p.eff_status,a.locn_code, (select care_locn_type_ind from op_clinic where clinic_code = a.locn_code and a.facility_id = '"+facility_id+"') location_type, op_get_desc.op_clinic(a.facility_id,locn_code,'"+locale+"','1') locn_desc, a.room_num, a.service_code, a.subservice_code, a.visit_type_code, a.practitioner_id,am_get_desc.AM_PRACTITIONER (a.practitioner_id,'"+locale+"',1) pract_name, a.other_res_class, a.other_resource_id, am_get_desc.AM_RESOURCE ('"+facility_id+"',a.other_resource_id,'"+locale+"',2) resource_desc, a.order_catalog_code,or_get_desc.or_order_catalog(a.order_catalog_code,'"+locale+"',2) order_cat_desc,a.contact_reason_code , am_get_desc.AM_CONTACT_REASON (a.contact_reason_code,'"+locale+"',1) reason_desc from op_template_for_vis_regn a,op_clinic c, am_practitioner p where a.facility_id = '"+facility_id+"' and a.template_code = '"+visit_dtl_temp_code+"' and a.locn_code=C.CLINIC_CODE and a.facility_id=c.facility_id and C.EFF_status='E' and A.PRACTITIONER_ID=p.practitioner_id and P.EFF_STATUS='E'";

		//Below query modified by Ashwini on 18-May-2017 for MMS-JU-SCF-0082
		String tmp_code_sel_sql = "select a.locn_code, (select care_locn_type_ind from op_clinic where clinic_code = a.locn_code and facility_id = '"+facility_id+"') location_type, op_get_desc.op_clinic(a.facility_id,locn_code,'"+locale+"','1') locn_desc, a.room_num, a.service_code, a.subservice_code, a.visit_type_code, a.practitioner_id,am_get_desc.AM_PRACTITIONER (a.practitioner_id,'"+locale+"',1) pract_name, a.other_res_class, a.other_resource_id, am_get_desc.AM_RESOURCE ('"+facility_id+"',a.other_resource_id,'"+locale+"',2) resource_desc, a.order_catalog_code,or_get_desc.or_order_catalog(a.order_catalog_code,'en',2) order_cat_desc,a.contact_reason_code , am_get_desc.AM_CONTACT_REASON (a.contact_reason_code,'"+locale+"',1) reason_desc from op_template_for_vis_regn a where a.facility_id = '"+facility_id+"' and a.template_code = '"+visit_dtl_temp_code+"' and ((a.practitioner_id is null) or (a.practitioner_id = (select practitioner_id from am_practitioner where practitioner_id=a.practitioner_id and eff_status='E'))) and ((a.locn_code is null) or (a.locn_code = (select clinic_code from op_clinic where clinic_code=a.locn_code and eff_status='E' and facility_id='"+facility_id+"')))";
		pstmt = con.prepareStatement(tmp_code_sel_sql);

		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()) {

				locncode = rs.getString("locn_code")==null?"":rs.getString("locn_code");
				locn_desc = rs.getString("locn_desc")==null?"":rs.getString("locn_desc");
				room_num = rs.getString("room_num")==null?"":rs.getString("room_num");
				service_code = rs.getString("service_code")==null?"":rs.getString("service_code");
				subservicecode = rs.getString("subservice_code")==null?"":rs.getString("subservice_code");
				visit_type_code = rs.getString("visit_type_code")==null?"":rs.getString("visit_type_code");
				practitioner_id = rs.getString("practitioner_id")==null?"":rs.getString("practitioner_id");
				pract_name=rs.getString("pract_name")==null?"":rs.getString("pract_name");
				other_res_class = rs.getString("other_res_class")==null?"":rs.getString("other_res_class");
		        other_resource_id=rs.getString("other_resource_id")==null?"":rs.getString("other_resource_id");
			    resource_desc=rs.getString("resource_desc")==null?"":rs.getString("resource_desc"); 
				order_catalog_code=rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
		        contact_reason_code=rs.getString("contact_reason_code")==null?"":rs.getString("contact_reason_code");
		        order_catalog_desc=rs.getString("order_cat_desc")==null?"":rs.getString("order_cat_desc");
		        contact_reason_desc=rs.getString("reason_desc")==null?"":rs.getString("reason_desc");
		        location_type=rs.getString("location_type")==null?"":rs.getString("location_type");
				
		}

if(pstmt!=null) pstmt.close();
if(rs!=null) rs.close(); 

/*Below Line Code Added for this [SS-SCF-0664]*/
if(!order_catalog_code.equals("")){		
String catagorycode="select ORDER_CATEGORY,ORDER_TYPE_CODE from or_order_catalog  where ORDER_CATALOG_CODE='"+order_catalog_code+"'";
pstmt = con.prepareStatement(catagorycode);	
rs = pstmt.executeQuery();
if(rs!=null && rs.next()) {
order_cate_code=rs.getString("ORDER_CATEGORY")==null?"":rs.getString("ORDER_CATEGORY");
order_types_code=rs.getString("ORDER_TYPE_CODE")==null?"":rs.getString("ORDER_TYPE_CODE");
}
if(pstmt!=null) pstmt.close();
if(rs!=null) rs.close(); 
}	
/*Above Line Code Added for this SCF [SS-SCF-0664]*/

if(allowTemplatePopulation == true) {

	if(!locncode.equals(""))
	{
	   	if(!invite_no.equals(""))
		{
		  appt_id="";
		}
		String fileCreateSql =  "{call GET_WORKING_DAY_YN(?,?,?,sysdate,?,?)}";
		String clinicWorkingYN="N";
		String P_ERR_MSG="";
		String practid="";		
		CallableStatement fileCreateCS = con.prepareCall(fileCreateSql);
		fileCreateCS.setString(1, facility_id);
		fileCreateCS.setString(2, locncode);
		fileCreateCS.setString(3, practid);
		fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
		fileCreateCS.execute();
		clinicWorkingYN = fileCreateCS.getString(4);
		if(clinicWorkingYN==null) clinicWorkingYN="";	
		P_ERR_MSG = fileCreateCS.getString(5);
		if(P_ERR_MSG==null) P_ERR_MSG="";   
		if(!clinicWorkingYN.equals(""))
		 {
		   if(clinicWorkingYN.equals("Y"))
			{
			   String sqlc="select allow_walk_in_yn,allow_referral_yn,allow_appt_yn,allow_non_referral_yn,allow_visit_regn_yn,OP_APPL_YN, DC_APPL_YN, IP_APPL_YN, EM_APPL_YN, open_to_all_pract_yn, ident_at_checkin, primary_resource_class from op_clinic where facility_id='"+facility_id+"' and clinic_code='"+locncode+"'";
			   
			   pstmt   = con.prepareStatement(sqlc);
			   rs = pstmt.executeQuery();
			   while( rs.next() )  {
					allow_walk_in_yn = rs.getString( "allow_walk_in_yn" );
					allow_referral_yn = rs.getString( "allow_referral_yn" );
					allow_appt_yn = rs.getString( "allow_appt_yn" );
					OP_APPL_YN = rs.getString( "OP_APPL_YN" );
					IP_APPL_YN = rs.getString( "IP_APPL_YN" );
					DC_APPL_YN = rs.getString( "DC_APPL_YN" );
					EM_APPL_YN = rs.getString( "EM_APPL_YN" ); 					open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"N":rs.getString("open_to_all_pract_yn");
					ident_at_checkin=rs.getString("ident_at_checkin")==null?"N":rs.getString("ident_at_checkin");	primary_resource_class=rs.getString("primary_resource_class")==null?"N":rs.getString("primary_resource_class");
			   }
			   if(rs != null) rs.close();
		       if(pstmt != null) pstmt.close();
		       if(allowToProceed(locncode,con,facility_id,p_referral_id,appt_id,allow_walk_in_yn,allow_referral_yn,allow_appt_yn,out))  {
				 allowTemplatePopulation = true;					
			   } else {
					allowTemplatePopulation = false;							
			   }
		 } else	{			   		out.println("alert(parent.frames[1].frames[1].getMessage(\"VISIT_REGISTRATION_NOT_ALLOWED_ON_HOLIDAY\",'OP'))");
			allowTemplatePopulation = false;						
		 }
	  }
	} else {
		allowTemplatePopulation = false;		
	}
}

if(allowTemplatePopulation == true) {	
	
	if(!service_code.equals("")) {

		// Commented for PE tuning on 23/04/2010
		/*
		pstmt = con.prepareStatement("select '1' from op_current_patient where facility_id = ? and locn_code = ? and patient_id = ? and service_code = ? and trunc(queue_date) = trunc(sysdate) and queue_status < '07' ");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locncode);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,service_code);
		*/ 
		// added by mujafar for ML-MMOH-CRF-1437 start
		if(isAllowRegForSameService)
		{
	pstmt = con.prepareStatement("select '1' from op_current_patient where facility_id = ? and locn_code = ? and patient_id = ? and service_code = ?  and queue_status < '07'");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locncode);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,service_code);

		}
		else
		{
		pstmt = con.prepareStatement("select '1' from op_current_patient where facility_id = ? and patient_id = ? and service_code = ?  and queue_status < '07'");
		pstmt.setString(1,facility_id);
		//pstmt.setString(2,locncode);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,service_code);
		}
       // added by mujafar for ML-MMOH-CRF-1437 end

		rs = pstmt.executeQuery();
		boolean allowPopulation = true;
		if(rs.next())
		{
			  out.println("alert(parent.frames[1].frames[1].getMessage('OPEN_VISIT_STATUS_FOR_CLINIC','OP'));");
			  allowPopulation = false;
			  out.println(frame_ref+"visit_registration.service_code.options[0].selected = true;");		  
		}
		if(rs != null)rs.close();
		if(pstmt != null)pstmt.close();
	   
	   if(allowPopulation) {

			
		if(visit_type_derv_rule.equals("S")){//modified for the SCF - MMS-SCF-0167
			String str1="";
			String str2="";  
			boolean foundTemplateVisType = false;		
		   pstmt=con.prepareStatement("Select OP_EPISODE_VALIDATION(?,?,'',?,?) from Dual");
		   pstmt.setString( 1, facility_id);
		   pstmt.setString( 2, service_code);
		   pstmt.setString( 3, patient_id);
		   pstmt.setString( 4, locncode);
		   rs = pstmt.executeQuery();
		   if(rs.next())
			{
				VisitDate = rs.getString(1);
			}	
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();		
			
		  if(!q_visit_adm_type_ind.equals("R"))
		  {
			  vsql.setLength(0);
			  vsql.append("select visit_type_code, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, VISIT_TYPE_CODE,'"+locale+"','2') short_desc ");
			  vsql.append(" from op_visit_type_for_clinic where ");
			  vsql.append(" facility_id = '"+facility_id+"' and clinic_code ='"+locncode+"' and eff_status='E' ");

			  if(override_vtype_on_epsd_yn.equals("Y"))
			  {	
				  if( (VisitDate.equals("-1")|| VisitDate.equals("0")))
					vsql.append(" and visit_type_ind = 'F' ");			  
			  }
			  else if(override_vtype_on_epsd_yn.equals("N"))
			  {
				  if( (VisitDate.equals("-1")|| VisitDate.equals("0")))
					vsql.append(" and visit_type_ind = 'F' ");
				  else
					vsql.append(" and visit_type_ind = 'L' ");
			  }

			  vsql.append(" order by 2 ");

			  pstmt   = con.prepareStatement( vsql.toString());
			  rs = pstmt.executeQuery() ;
			  if( rs != null )
			  { 
				while( rs.next() ) {

						str1 = rs.getString( "short_desc" ) ;
						str2 = rs.getString( "visit_type_code" );

						if(visit_type_code.equals("") || visit_type_code.equals(str2)) {//modified for the SCF - MMS-SCF-0072
							foundTemplateVisType = true;
						} 					
						hash_Visit_Type.put(str2,str1); 				
				 }
			  } 
			  if(pstmt!=null)pstmt.close();
			  if(rs!=null)rs.close();
		 }
	   
		 //out.println("alert('foundTemplateVisType--"+foundTemplateVisType+"')");
		 if(foundTemplateVisType == true) {
			allowTemplatePopulation= true; 	    
		 } else {
			allowTemplatePopulation = false; 	    			
		 }
	   }else if(visit_type_derv_rule.equals("B")){
		 //modified for the SCF - MMS-SCF-0167
			String str1="";
			String str2="";  
			boolean foundTemplateVisType = false;		
			 
					
			CallableStatement billingCS = null;
			String billingSql =  "{call bl_interface_proc.proc_first_or_followup_visit(?,?,?,?,to_date('"+vst_date_time+"','DD/MM/YYYY HH24:MI:SS'),'','','','',?,?,?,?,?,?)}";//modified for the SCF - MMS-SCF-0072
			billingCS = con.prepareCall(billingSql);
			billingCS.setString(1, facility_id);
			billingCS.setString(2, patient_id);
			billingCS.setString(3, "O");
			billingCS.setString(4, locncode);
			billingCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 6,java.sql.Types.VARCHAR);
			//Added for the SCF - MMS-SCF-0082
			billingCS.registerOutParameter( 7,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 8,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 9,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 10,java.sql.Types.VARCHAR);

			 try{
				billingCS.execute();
				episode_id = billingCS.getString(5)==null?"":billingCS.getString(5);//Added for the SCF - MMS-SCF-0082
				visit_type_ind = billingCS.getString(6);
				if(visit_type_ind==null) visit_type_ind="F";
				
				//Added for the SCF - MMS-SCF-0082
				blng_grp_id = billingCS.getString(7)==null?"":billingCS.getString(7);
				cust_grp_code = billingCS.getString(8)==null?"":billingCS.getString(8);
				cust_code = billingCS.getString(9)==null?"":billingCS.getString(9);
				policy_type_code = billingCS.getString(10)==null?"":billingCS.getString(10);
				System.err.println("Billing values obtained from the procedure in validate visit details template");
				System.err.println("blng_grp_id-->"+blng_grp_id);
				System.err.println("cust_grp_code-->"+cust_grp_code);
				System.err.println("cust_code-->"+cust_code);
				System.err.println("policy_type_code-->"+policy_type_code);
				System.err.println("episode_id-->"+episode_id);
				System.err.println("visit_type_ind-->"+visit_type_ind);
			} catch(Exception e1) {
					e1.printStackTrace();
				} finally{billingCS.close();}		
			
		  if(!q_visit_adm_type_ind.equals("R"))
		  {
			  vsql.setLength(0);
			  vsql.append("select visit_type_code, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, VISIT_TYPE_CODE,'"+locale+"','2') short_desc ");
			  vsql.append(" from op_visit_type_for_clinic where ");
			  vsql.append(" facility_id = '"+facility_id+"' and clinic_code ='"+locncode+"' and eff_status='E' ");

			 vsql.append(" and visit_type_ind = '"+visit_type_ind+"' ");			  
			 
			  vsql.append(" order by 2 ");

			  pstmt   = con.prepareStatement( vsql.toString());
			  rs = pstmt.executeQuery() ;
			  if( rs != null )
			  { 
				while( rs.next() ) {

						str1 = rs.getString( "short_desc" ) ;
						str2 = rs.getString( "visit_type_code" );

						if(visit_type_code.equals("") || visit_type_code.equals(str2)) {//modified for the SCF - MMS-SCF-0072
							foundTemplateVisType = true;
						} 					
						hash_Visit_Type.put(str2,str1); 				
				 }
			  } 
			  if(pstmt!=null)pstmt.close();
			  if(rs!=null)rs.close();
		 }
	   
		 //out.println("alert('foundTemplateVisType--"+foundTemplateVisType+"')");
		 if(foundTemplateVisType == true) {
			allowTemplatePopulation= true; 	    
		 } else {
			allowTemplatePopulation = false; 	    			
		 }	     	 
	}
}else {
	   allowTemplatePopulation = false; 	  		   
}
	}

}
if(allowTemplatePopulation == true) {

	if(functionId.equals("PROCD_REGISTRATION"))	 {

		PreparedStatement pstmtPatClass2   = con.prepareStatement( "Select Patient_Class, Short_Desc from AM_PATIENT_CLASS_lang_vw WHERE language_id='"+locale+"' and PATIENT_CLASS in(		decode(?,'Y','OP'),decode(?,'Y','IP'),decode(?,'Y','EM'),decode(?,'Y','DC'))");
		pstmtPatClass2.setString(1,OP_APPL_YN);
		pstmtPatClass2.setString(2,IP_APPL_YN);
		pstmtPatClass2.setString(3,EM_APPL_YN);
		pstmtPatClass2.setString(4,DC_APPL_YN);
		rs = pstmtPatClass2.executeQuery();
		while( rs.next())
		{
			out.println(  "if("+frame_ref+"forms[0].pat_class != null) {var element = "+frame_ref+"createElement('OPTION');"+
			"element.text = \""+rs.getString( "Short_Desc" )+"\";"+
			"element.value= \""+rs.getString( "Patient_Class" )+"\";"+
			frame_ref+"forms[0].pat_class.add(element);}");
		}
			if(rs != null) rs.close();
			if(pstmtPatClass2 != null) pstmtPatClass2.close();
	}
	
	out.println(frame_ref+"forms[0].open_to_all_pract_yn.value='"+open_to_all_pract_yn+"'");
	out.println(frame_ref+"forms[0].ident_at_checkin.value='"+ident_at_checkin+"'");
	out.println(frame_ref+"forms[0].clptype.value='"+primary_resource_class+"'");
	
	/*
	pstmt   = con.prepareStatement( "select open_to_all_pract_yn,ident_at_checkin,primary_resource_class from op_clinic where clinic_code='"+locncode+"' and facility_id='"+facility_id+"'");
	rs = pstmt.executeQuery();

	if (rs.next())	{
		String open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"N":rs.getString("open_to_all_pract_yn");
		String ident_at_checkin=rs.getString("ident_at_checkin")==null?"N":rs.getString("ident_at_checkin");
		String primary_resource_class=rs.getString("primary_resource_class")==null?"N":rs.getString("primary_resource_class");
					   
		out.println(frame_ref+"forms[0].open_to_all_pract_yn.value='"+open_to_all_pract_yn+"'");
		out.println(frame_ref+"forms[0].ident_at_checkin.value='"+ident_at_checkin+"'");
		out.println(frame_ref+"forms[0].clptype.value='"+primary_resource_class+"'");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	*/
//Commented for the SCF - MMS-SCF-0082
	//if(!service_code.equals("")) {

		StringBuffer servsql1=new StringBuffer();
		servsql1.setLength(0);
						
		servsql1.append("SELECT  service_code, short_desc FROM   am_service_lang_vw WHERE  language_id='"+locale+"' and eff_status = 'E' AND service_code in (SELECT service_code FROM op_clinic WHERE clinic_code ='"+locncode+"' AND   facility_id='"+facility_id+"' UNION SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+locncode+"' AND b.facility_id='"+facility_id+"'");					
						
		if(functionId.equals("VISIT_REGISTRATION"))	 {
			servsql1.append( " and b.care_locn_type_ind = 'C')");
		}
		else if(functionId.equals("PROCD_REGISTRATION")) {
			servsql1.append(" and b.care_locn_type_ind = 'E')");
		}
		servsql1.append( " order by 2 ");			
						
		pstmt   = con.prepareStatement(servsql1.toString());
		//Added for the SCF - MMS-SCF-0189 [IN045505]
		out.println("var len = "+frame_ref+"forms[0].service_code.length; var i=1; while(i<len) { len="+frame_ref+"forms[0].service_code.length;"+frame_ref+"forms[0].service_code.remove(i);}");
		rs = pstmt.executeQuery();
		if( rs != null ) {
			while( rs.next())  {
				out.println(  "var element = "+frame_ref+"createElement('OPTION');"+
				"element.text = \""+rs.getString( "short_desc" )+"\";"+
				"element.value= \""+rs.getString( "service_code" )+"\"; if('"+rs.getString("service_code")+"'=='"+service_code+"'){element.selected = true}"+
				frame_ref+"forms[0].service_code.add(element);");
			}
		}			
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	//} 
	
	if(!location_type.equals("")) {
		out.println(frame_ref+"forms[0].locn_type.value='"+location_type+"';"); 
	}
	
	if(!locncode.equals("")) { 
        out.println(frame_ref+"forms[0].assign_care_locn_desc.value='"+locn_desc+"';"); 
		out.println(frame_ref+"forms[0].assign_care_locn_code.value='"+locncode+"';"); 
		out.println("PatVisHid(2);");//added by munisekhar for [IN:046603] 
	} 
	
	if(!room_num.equals("")) {
	// query tuning.. modified by venkat S		
	
	      /* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */

		pstmt   = con.prepareStatement( "SELECT a.practitioner_id ROOM_NO, b.room_type room_type, am_get_desc.am_facility_room (a.facility_id, a.practitioner_id,'"+locale+"', 2) room_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id='"+facility_id+"' AND a.clinic_code='"+locncode+"' AND  a.eff_status='E' AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID");
				/*CRF end SS-CRF-0010 [IN034516]*/
				
		rs = pstmt.executeQuery();
		while( rs.next()) {
			String room_type = rs.getString( "room_type" );
			 /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			 out.println(  "var element = "+frame_ref+"createElement('OPTION');"+
			"element.text = '"+rs.getString("ROOM_NO")+" "+rs.getString("room_desc")+"';"+
			"element.value= '"+rs.getString("ROOM_NO")+"';"+
			"if(element.value=='"+room_num+"'){element.selected = true;}if("+frame_ref+"forms[0].room_no != null){"+frame_ref+"forms[0].room_no.add(element);}"+
			"if("+frame_ref+"forms[0].room_type != null){"+frame_ref+"forms[0].room_type.value='"+room_type+"';}");
		}	

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		String sqlQuery="select short_desc from am_facility_room where room_num = '"+room_num+"' and operating_facility_id = '"+facility_id+"' ";
          String short_desc = "" ; 
		   pstmt   = con.prepareStatement(sqlQuery);
           rs = pstmt.executeQuery();
           if( rs.next() ) {
				short_desc = rs.getString( "short_desc" );
				
               }
			     
	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close();     		    	 
	   //out.println(" "+frame_ref+"all.roomDesc.innerHTML='&nbsp;/&nbsp;' + '"+short_desc+"' ");	

	}
	
	if(isRoomMandatoryRegVisit.equals("true") ){ // added by mujafar for NMC-JD-CRF-0025
				
			if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		pstmt   = con.prepareStatement( "SELECT a.practitioner_id ROOM_NO, b.room_type room_type, am_get_desc.am_facility_room (a.facility_id, a.practitioner_id,'"+locale+"', 2) room_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id='"+facility_id+"' AND a.clinic_code='"+locncode+"' AND  a.eff_status='E' AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID");
		int recordCount = 0;		
		rs = pstmt.executeQuery();
		while( rs.next()) {
			recordCount=recordCount +1;		
		}
	
				if(recordCount > 0 )
					out.println(" "+frame_ref+"all.room_img.style.visibility = 'visible'; ");
				
				
		if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close();   
					
			}
	
	
	
				
	if(allow_pop_subser.equals("Y") && !service_code.equals("") && !subservicecode.equals("")) {
		pstmt       = con.prepareStatement(" SELECT  SUBSERVICE_CODE subservice_code, AM_GET_DESC.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+locale+"','2') short_desc FROM AM_FACILITY_SUBSRVC WHERE  OPERATING_FACILITY_ID='"+facility_id+"' AND  SERVICE_CODE='"+service_code+"' ORDER BY 2");
			
		rs = pstmt.executeQuery();
		while( rs.next() )	{
			String str1 = rs.getString( "short_desc" );
			String str2 = rs.getString( "subservice_code" );
			out.println(  "var element = "+frame_ref+"createElement('OPTION');"+
			"element.text = \""+str1+"\";"+
			"element.value= \""+str2+"\"; if(element.value=='"+subservicecode+"'){element.selected = true;}"+
			 frame_ref+"forms[0].subservice_code.add(element);");
		}
	    if(rs != null) rs.close();
	    if(pstmt!=null) pstmt.close();
   }
			
			
		if(!other_res_class.equals(""))	{
			//out.println("var len = "+frame_ref+"forms[0].other_res_type.length; var i=1; while(i<len) { len="+frame_ref+"forms[0].other_res_type.length;"+frame_ref+"forms[0].other_res_type.remove(i);}");
							 
			if(other_res_class.equals("E"))	{					
				out.println(frame_ref+"forms[0].other_res_type.selectedIndex='1';");				
			}		
			else if(other_res_class.equals("O")) {
				out.println(frame_ref+"forms[0].other_res_type.selectedIndex='2';");	
			}
			else {			 
				out.println(frame_ref+"forms[0].other_res_type.selectedIndex='0';");
			}
		} 
		
		
		
		
		if(!practitioner_id.equals(""))
		{		

            out.println(frame_ref+"forms[0].pract_name.value='"+pract_name+"';"); 
			out.println(frame_ref+"forms[0].attend_practitioner_id.value='"+practitioner_id+"';"); 
            out.println(frame_ref+"forms[0].pract_name.readOnly=false;");
			out.println(frame_ref+"forms[0].pract_butt.disabled=false;");

			if(visit_type_derv_rule.equals("P")){
			try{
				//hash_Visit_Type.clear();
			  boolean foundTemplateVisType1 = true;
			  
			  
			  String VisitRule = "";
			  String strDesc="";
			  String strCode="";			
			   pstmt=con.prepareStatement("Select op_validation_for_visit_type(?,?,?,?) from Dual");
			   pstmt.setString( 1, facility_id);
			   pstmt.setString( 2, practitioner_id);
			   pstmt.setString( 3, patient_id);
			   pstmt.setString( 4, service_code);
			   
			   rs = pstmt.executeQuery();
			   if(rs.next()){
					VisitRule = rs.getString(1);					
					out.println(frame_ref+"forms[0].populate_visit_type.value='"+VisitRule+"';");
			   }
//			   int count = 0;
	
			   if(!VisitRule.equals("")){		   
			   String visitTypeQuery = "SELECT visit_type_code,op_get_desc.op_visit_type (facility_id,visit_type_code,'en','2') short_desc FROM op_visit_type_for_clinic WHERE facility_id = '"+facility_id+"' AND clinic_code = '"+locncode+"' AND eff_status = 'E' and visit_type_ind in('"+VisitRule+"','E') order by 2";
	
				pstmt   = con.prepareStatement(visitTypeQuery);
				rs = pstmt.executeQuery() ;
				  if( rs != null ) { 
					while(rs.next()) {				
						strDesc = rs.getString( "short_desc" ) ;
						strCode = rs.getString( "visit_type_code" );			
						if(visit_type_code.equals(strCode)) {
						  foundTemplateVisType1 = true;
						}
						hash_Visit_Type.put(strCode,strDesc); 			
						
					}
				  }	 
				}			 
				  if(pstmt!=null)pstmt.close();
				  if(rs!=null)rs.close();		   
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		}else{
			if(visit_type_derv_rule.equals("P")){
				 out.println(frame_ref+"forms[0].pract_name.readOnly=false;");
				 out.println(frame_ref+"forms[0].pract_butt.disabled=false;");
			}
		}
		  		
		
			
		// if(!visit_type_code.equals("")) {

		String vis_code = "";
		String vis_desc = "";

		Set set_visits = hash_Visit_Type.keySet();

		Iterator it = set_visits.iterator();	

		//Added for the SCF MMS-SCF-0189[IN045505]
		out.println("var len = "+frame_ref+"forms[0].visit_adm_type.length; var i=1; while(i<len) { len="+frame_ref+"forms[0].visit_adm_type.length;"+frame_ref+"forms[0].visit_adm_type.remove(i);}");

		while(it.hasNext()) {

			vis_code = (String) it.next();			
			vis_desc = (String) hash_Visit_Type.get(vis_code);
			out.println(  "var element = "+frame_ref+"createElement('OPTION');"+
						"element.text = \""+vis_desc+"\";"+
						"element.value= \""+vis_code+"\"; if(element.value=='"+visit_type_code+"'){element.selected = true;}"+
		     frame_ref+"forms[0].visit_adm_type.add(element);");
	    	out.println(frame_ref+"forms[0].visit_adm_type.disabled=false;");
			
		}

		if(!visit_type_code.equals("")){
			out.println(frame_ref+"forms[0].visit_adm_type.onchange();");
		}else{//Added for the incident - MMS-ICN-CRF-MMS-QH-CRF-0041.1-01 [IN:046131]
			if(set_visits.size()>=1){
				out.println(frame_ref+"forms[0].visit_adm_type.selectedIndex='1';");
			}
		}

		String str1="";
		String str2="";
		
		String p_order_cat="";
		pstmt   = con.prepareStatement( "select  visit_type_ind,order_catalog_criteria from op_visit_type where visit_type_code='"+visit_type_code+"' and facility_id='"+facility_id+"'");
		rs = pstmt.executeQuery();
		if( rs != null )
		 {
		 if( rs.next() )
		  {
			str1 = rs.getString( "visit_type_ind" );		
			 if(str1.equals("F"))
			  {
			  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
			  }else if(str1.equals("L"))
			  {
			  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
			  }else if(str1.equals("R"))
			  {
			  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			  }else if(str1.equals("E"))
			  {
			  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			  }else if(str1.equals("S"))
			  {
			  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
			  }else if(str1.equals("C"))
			  {
			  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
			  }

			p_visit_type_ind = str1;
			p_order_cat=(rs.getString("order_catalog_criteria") == null)?"":rs.getString("order_catalog_criteria");
			out.println(frame_ref+"forms[0].order_cat_txt.value='"+order_catalog_desc+"'"); 
			out.println(frame_ref+"forms[0].order_cat_code.value='"+order_catalog_code+"'"); 
			
			/*Below Line Code Added for this SCF [SS-SCF-0664]*/
			out.println(frame_ref+"forms[0].order_category_code.value='"+order_cate_code+"'"); 
			out.println(frame_ref+"forms[0].order_type_code.value='"+order_types_code+"'"); 
			/*Above Line Code Added for this SCF [SS-SCF-0664]*/
			
			if(or_install_yn.equals("Y"))
			 {
				if(!p_order_cat.equals(""))
				 {
				  if(p_order_cat.equals("R"))
				   {
					   out.println(frame_ref+"forms[0].order_cat_txt.readOnly=false;");
					   out.println(frame_ref+"forms[0].order_cat_butt.disabled=false;");
					   out.println(" if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='visible';}");
					   out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
				   }
				   else
					  {
						out.println(frame_ref+"forms[0].order_cat_txt.readOnly=false;");
						out.println(frame_ref+"forms[0].order_cat_butt.disabled=false;");
						out.println("if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='hidden';}");
						out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
					  }
				 }else
				 {
					out.println(frame_ref+"forms[0].order_cat_txt.readOnly=true;");
					out.println(frame_ref+"forms[0].order_cat_butt.disabled=true;");
					out.println(" if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='hidden';}");
					out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
							 }
			  }
			  else
				 {
					out.println(frame_ref+"forms[0].order_cat_txt.readOnly=true;");
					out.println(frame_ref+"forms[0].order_cat_butt.disabled=true;");
					out.println(" if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='hidden';}");
					out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
						  }
							if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();

				out.println(frame_ref+"forms[0].h_visit_type_ind.value=\""+str1+"\";");
				out.println(frame_ref+"forms[0].visit_adm_type.value='"+visit_type_code+"';");
				out.println(frame_ref+"forms[0].vst_type_ind.value='';");//Added for the SCF - MMS-SCF-0167
			  }
		  }  

		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();
	if(!other_resource_id.equals(""))
		{
         out.println(frame_ref+"forms[0].other_res_txt.value='"+resource_desc+"';"); 
		out.println(frame_ref+"forms[0].other_res_code.value='"+other_resource_id+"';");
		}
	
	if(!contact_reason_code.equals(""))
		{		
	      
			out.println(frame_ref+"forms[0].contact_reason_txt.value='"+contact_reason_desc+"';"); 
			out.println(frame_ref+"forms[0].contact_reason_code.value='"+contact_reason_code+"';"); 
		}  
		
		  if(visit_type_derv_rule.equals("S")){
			  if(visit_type_code != null && !visit_type_code.equals(""))	{   
				   episode_validation(out, p_visit_type_ind,episodeReqd, service_code, subservicecode, patient_id,con,facility_id,frame_ref,locncode,override_vtype_on_epsd_yn);           
			  }
		  } else if(visit_type_derv_rule.equals("P")){//modified for the sCF - MMS-SCF-0072
			  if(visit_type_code != null && !visit_type_code.equals(""))	{   
				   //episode_validation(out, p_visit_type_ind,episodeReqd, service_code, subservicecode, patient_id,con,facility_id,frame_ref,locncode,override_vtype_on_epsd_yn);   
				   episode_validation_pract(out, p_visit_type_ind,episodeReqd, service_code, subservicecode, patient_id,con,facility_id,frame_ref,locncode); 
			  }
		  } else if(visit_type_derv_rule.equals("B")){//modified for the sCF - MMS-SCF-0072
			 //Following condition commented for the SCF - MMS-ICN-CRF-MMS-QH-CRF-0041.1-01 [IN:046131]
		//	  if(visit_type_code != null && !visit_type_code.equals(""))	{   
			 
				   episode_validation_insurance(out, p_visit_type_ind,patient_id,con,facility_id,frame_ref,locncode,episode_id);    
				
		  //}
		  }
			  
	//}
}
if(allowTemplatePopulation == false) { 

	out.println("alert(parent.frames[1].frames[1].getMessage(\"VISIT_DTLS_TEMP_NOT_APPL_FOR_PATIENT\",'OP'))");
	out.println(frame_ref+"forms[0].vis_det_temp_desc.select();");
      
}

} catch(Exception e)	{
	out.print(e);
} finally {
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
