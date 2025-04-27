package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __mobayavailabilitychartresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOBayAvailabilityChartResult.jsp", 1709118400744L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n\n\t<head>\n\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\t\n\t\t<script src=\'../../eMO/js/MOBayAvailability.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n \t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body  id=\'b\' onKeyDown = \'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script> \n\t\t\t\tresetValues(); \n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\')); \n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</table> \n\n\n\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<script>\n\t\t\tparent.processBar.document.location.href = \"../../eCommon/html/blank.html\";\n\t\t\n\t\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
  
			//Conversion
public String specialCharacter(String single){
	int i=0;
	if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
	}
	return single ;
}	

		


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			Connection	con			        = null;
			java.sql.Statement	stmt		= null;
			ResultSet	rs					= null;
			java.sql.Statement stmt_cnt		= null;
			ResultSet rs_cnt				= null;
			PreparedStatement pstmt			= null;
			PreparedStatement pstmt3		= null;

			String locale=(String)session.getAttribute("LOCALE"); 
			String	   facilityId 			= (String) session.getValue( "facility_id" ) ;
			String blocked="";
								
			String total				= "&nbsp;" ;
			String occupied				= "&nbsp;" ;
			String vacant				= "&nbsp;" ;
			String area_code_prev		= "";
			String area_desc			= ""; 
			String bed_no				= "";
			String blocked_yn          ="";
			String patient_id		    = ""; 
			
			String butt_color 			= "";
			StringBuffer TableStr		=new StringBuffer();
			StringBuffer tip		=new StringBuffer();
			String registration_no="";
		
		int		bed_col_num		= 1;
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			StringBuffer whereBuffer = new StringBuffer();			 
			StringBuffer queryBuffer = new StringBuffer();
	try
	{
     	request.setCharacterEncoding("UTF-8");
		String area_code			= checkForNull(request.getParameter("area_code"));
		String bed_status			= checkForNull(request.getParameter("bed_status"));
		String bed_patient_id			= checkForNull(request.getParameter("bed_patient_id"));
		con=ConnectionManager.getConnection(request);

		whereBuffer.append("where facility_id ='"+facilityId+"' and eff_status ='E'" );
		if (!area_code.equals(""))
		{
			whereBuffer.append(" and area_code = '");
			whereBuffer.append(area_code);
			whereBuffer.append("'");
			 

		}

		if (!bed_status.equals(""))
		{
			if(bed_status.equals("V"))
			{
			whereBuffer.append(" and (((OCCUPYING_PATIENT_ID is null or occupying_patient_id='') and (registration_no is null or registration_no='') and BLOCKED_YN='N') OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE))");
		
			}
			if(bed_status.equals("BL"))
			{
			whereBuffer.append(" and BLOCKED_YN='Y' AND NVL(BLOCKED_UPTO,SYSDATE-1) > SYSDATE");
		
			}
			
    		if(bed_status.equals("O"))
			{
			whereBuffer.append(" and (occupying_patient_id is  not null or registration_no is not null)");
		
			}

		}
		queryBuffer.append("SELECT area_code,MO_GET_DESC.mo_area('"+facilityId+"',area_code,'"+locale+"','1') area_desc,(case when BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE then 'N' else BLOCKED_YN end) BLOCKED_YN,bed_no,occupying_patient_id,registration_no ");
		queryBuffer.append("FROM mo_bed_for_area_vw ");
        queryBuffer.append(whereBuffer.toString());			
       	String sqlCount = "Select count(*) count_val from mo_bed_for_area_vw "+ whereBuffer.toString();
		
        if(!bed_patient_id.equals("")){
			queryBuffer.append("union SELECT   area_code, mo_get_desc.mo_area ('"+facilityId+"', area_code, '"+locale+"', '1') area_desc,(CASE WHEN blocked_yn = 'Y' AND blocked_upto <= SYSDATE THEN 'N' ELSE blocked_yn END) blocked_yn, bed_no, occupying_patient_id, registration_no FROM mo_bed_for_area_vw where facility_id ='"+facilityId+"' and eff_status ='E' and area_code ='"+area_code+"' and OCCUPYING_PATIENT_ID='"+bed_patient_id+"'");		 
	   }
	   queryBuffer.append(" order by area_desc, area_code, bed_no "); 
		int max_count	= 0;
		
		pstmt			= con.prepareStatement(sqlCount);
		rs				= pstmt.executeQuery();

		if(rs.next())
		{
			max_count = rs.getInt(1);
		}
		if (pstmt != null) pstmt.close();
		if(rs!=null) rs.close();
		if(max_count == 0)
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else
		{
     			stmt = con.createStatement() ;

				
				rs     = stmt.executeQuery(queryBuffer.toString()) ;
				
				int count_buttn = 0 ;
				TableStr.setLength(0);
				TableStr.append("<table cellspacing=0 cellpadding=0 align='left' border='0' width='10%'>");
				TableStr.append("<tr>");
				if(rs!=null)
				{	
					
					TableStr.append("<form name='query_form' id='query_form'>");
					 area_code		=  ""; 

					
					String placeholder 				=  "";
 					String sqlCnt					=  "";
					String header = "";
                    String sqlCnt1=""; 
					String sqlCnt2="";
                    String sqlCnt3 =""; 

					String regno =""; 
					String BayNo =""; 
					String PatientID =""; 
					String Tot_desc="";
					String Occ_desc="";
					String Vac_desc="";
					String Block_desc="";

					BayNo=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.BayNo.label","mo_labels");
					regno=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.registrationno.label","common_labels");
					PatientID=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels");
					Tot_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels");
					Occ_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels");
					Vac_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels");
					Block_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.blocked.label","common_labels");


					sqlCnt="Select count(*) tot_cnt from mo_bed_for_area_vw where area_code=? and  facility_id = '"+facilityId+"' and  eff_status='E'";
					sqlCnt1="Select count(*) occupied from mo_bed_for_area_vw where area_code=?  and  facility_id = '"+facilityId+"' and  (occupying_patient_id is not null or registration_no is not null) and eff_status='E'";
					sqlCnt2="select count(*) vacant from mo_bed_for_area where AREA_CODE=? and occupying_patient_id is null and  facility_id = '"+facilityId+"' and    (BLOCKED_YN='N' OR (BLOCKED_YN='Y' AND NVL(BLOCKED_UPTO,SYSDATE-1) <= SYSDATE)) and eff_status='E'";
					sqlCnt3="select count(*) blocked from mo_bed_for_area where AREA_CODE=? and BLOCKED_YN='Y' AND  facility_id = '"+facilityId+"' and  NVL(BLOCKED_UPTO,SYSDATE-1) > SYSDATE and eff_status='E'";
					PreparedStatement pstmt1=null;
					PreparedStatement pstmt2=null;
					//pstmt=con.prepareStatement(sqlCnt);	
					//pstmt1=con.prepareStatement(sqlCnt1);	
				//	pstmt2=con.prepareStatement(sqlCnt2);	
			//		pstmt3=con.prepareStatement(sqlCnt3);	
					
					while(rs.next())
					{
						area_code					= checkForNull(rs.getString("area_code")) ;
						area_desc					= checkForNull(rs.getString("area_desc")) ;
						bed_no						= checkForNull(rs.getString("bed_no")) ;
						patient_id					= checkForNull(rs.getString("occupying_patient_id")) ;
						blocked_yn                  =checkForNull(rs.getString("blocked_yn")) ;
						registration_no = checkForNull(rs.getString("registration_no")) ;
						butt_color 					= "IP_GreenButton";
						placeholder					= "";
						
                       
						//stmt_cnt = con.createStatement();
						//rs_cnt = stmt_cnt.executeQuery( sqlCnt );
					    pstmt=con.prepareStatement(sqlCnt);	
						pstmt.setString(1,area_code);
						rs_cnt = pstmt.executeQuery();
						if(rs_cnt.next())
						{
								total		= String.valueOf (rs_cnt.getInt ("tot_cnt")); 
						}
						if (rs_cnt != null) rs_cnt.close();
						if (pstmt != null) pstmt.close();
						
						pstmt1=con.prepareStatement(sqlCnt1);	
						pstmt1.setString(1,area_code);
						rs_cnt = pstmt1.executeQuery();
						if(rs_cnt.next())
						{
								occupied		= String. valueOf (rs_cnt.getInt ("occupied")); 
						}
			            if (rs_cnt != null) rs_cnt.close();
						if (pstmt1 != null) pstmt1.close();
						pstmt2=con.prepareStatement(sqlCnt2);	
						pstmt2.setString(1,area_code);
						rs_cnt = pstmt2.executeQuery();
						//stmt_cnt = con.createStatement();
						//rs_cnt = stmt_cnt.executeQuery( sqlCnt );
						if(rs_cnt.next())
						{
								vacant		= String.valueOf (rs_cnt.getInt ("vacant")); 
						}
						if (rs_cnt != null) rs_cnt.close();
						if (pstmt2 != null) pstmt2.close();
						
                        pstmt3=con.prepareStatement(sqlCnt3);	
						pstmt3.setString(1,area_code);
						rs_cnt = pstmt3.executeQuery();
						//stmt_cnt = con.createStatement();
						//rs_cnt = stmt_cnt.executeQuery( sqlCnt );
						if(rs_cnt.next())
						{
								blocked		= String.valueOf (rs_cnt.getInt ("blocked")); 
						}
						if (rs_cnt != null) rs_cnt.close();
						if (pstmt3 != null) pstmt3.close();
						
						
						placeholder = "";
						placeholder = specialCharacter(bed_no);
						tip.setLength(0);
						//tip.append("Bay No ��"+placeholder+"<br>") ;
						tip.append(""+BayNo+"~~"+placeholder+"<br>") ;

						
						placeholder = "";
						placeholder = specialCharacter(registration_no);
						//tip.append("&nbsp;  Registration No ��"+placeholder+"<br>") ;						
						tip.append( ""+regno+"~~"+placeholder+"<br>") ;						
						placeholder = "";
						placeholder = specialCharacter(patient_id);
						//tip.append("&nbsp;  Patient ID ��"+placeholder+"<br>") ;					
						tip.append(""+PatientID+"~~"+placeholder+"<br>") ;					
					
										
						if (!patient_id.equals(""))
							butt_color = "IP_LPinkButton";
                           else						
							butt_color = "IP_LGreenButton";
				         if (!registration_no.equals(""))
							butt_color = "IP_LPinkButton";
                           else						
							butt_color = "IP_LGreenButton";
				          if(blocked_yn.equals("Y"))  
				          	butt_color = "IP_BrownButton";
						
						if(area_code.equals(area_code_prev)){
						}else{ 
							
							header	 =area_desc; 	
							area_code_prev=area_code;

							TableStr.append("</tr><tr><table width='100%' border=0><th class='TEXTGROUPING' align='left' width='55%'> "+ header +"</th><th class='GROUPING' align='left' width='45%'>"+""+Tot_desc+": "+total+"   "+""+Occ_desc+": "+occupied+"   "+""+Vac_desc+": "+vacant+"   "+Block_desc+": "+blocked+" </th></table></tr><tr>");
							bed_col_num = 1;
						}
						
						//String retVal = bed_no+"^"+area_code+"^"+patient_id;
						TableStr.append("<script>var tips"+count_buttn+" = escape(\""+tip.toString()+"\");</script>");
						TableStr.append(" <td width='2%'> <input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\" class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:82;' onclick='closeWin(\""+URLEncoder.encode(bed_no)+"\",\""+butt_color+"\")'> </td> ");

						if ( bed_col_num == 9)
						{
							bed_col_num = 0;
							TableStr.append("</tr><tr>");
						}
											bed_col_num++ ;
						count_buttn++ ;
					}}
				
		}
				TableStr.append("</form></tr>");
				out.print(TableStr.toString());
				out.println("<script> resetValues(); </script>");
		        TableStr.setLength(0); 
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (rs_cnt != null) rs_cnt.close();
				if (stmt_cnt != null) stmt_cnt.close();
				if (pstmt != null) pstmt.close();
			//	if (pstmt2 != null) pstmt2.close();
				if (pstmt3 != null) pstmt3.close();
				
				}
				catch(Exception e) {
					out.println("MOBayAvailabilityChartResult"+e.toString());
					e.printStackTrace();}
	finally
	{
		
		ConnectionManager.returnConnection(con,request);
	}
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
