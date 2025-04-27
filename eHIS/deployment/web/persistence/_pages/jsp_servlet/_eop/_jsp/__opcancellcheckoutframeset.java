package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __opcancellcheckoutframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OPCancellCheckoutFrameset.jsp", 1709119445945L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<HEAD>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"CHECKED_OUT_ENCOUNTER_EXISTS\",\"OP\"));\n\t\t\t\twindow.close();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"REGISTERED_IN_MORTUARY\",\"Common\"));\t\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"CURRENTLY_IN_PATIENT1\",\"Common\"));\t\n\t\t\t\t\t\twindow.close();\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"ALREADY_VISITED_SAME_LOCN\",\"Common\"));\t\t\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<FRAMESET ROWS=\'9%,88%,0%,0%\' framespacing=0>  \n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t<FRAMESET ROWS=\'9%,88%,0%\' framespacing=0>  \n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t\n\t\t\t\t<FRAME name=\'PLINE\' id=\'PLINE\' SRC=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Facility_Id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' noresize  frameborder=no scrolling=\'no\'>\n\t\t\t\t<!--<frame name=\'detail\' id=\'detail\' src=\'../../eOP/jsp/OPCancellCheckoutModel.jsp?module_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&encounter_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&pract=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&oplocation=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&patient_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&loc_type=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&function_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&oper_stn_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\'>-->\n\t\t\t\t<frame name=\'detail\' id=\'detail\' src=\"../../eOP/jsp/OPCancellCheckoutModel.jsp?module_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\'><!--Modified by Rameswar Against IN55430-->\n\t\t\t\t<frame name=\'Dummy_frame\' id=\'Dummy_frame\' src=\'../../eCommon/html/blank.html\' framesetborder=0 frameborder=0 noresize scrolling=\'no\'>\n\t\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t <frame name=\'billingfr\' id=\'billingfr\' src=\'../../eBL/jsp/BLSessionValuesReset.jsp\' frameborder=0 noresize scrolling=\'no\'>\n\t\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t</FRAMESET>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n</head>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

        request.setCharacterEncoding("UTF-8");
		String tit=request.getParameter("title");
        if(tit==null)
tit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelCheckout.label","common_labels");
			String locale = (String)session.getAttribute("LOCALE");
          
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(tit));
            _bw.write(_wl_block7Bytes, _wl_block7);

				
		Connection con=null;
 	    PreparedStatement pstmt = null ;
		ResultSet rs=null;
		Boolean isAllowRegForSameService = false; //Added by Mujafar  for ML-MMOH-CRF-1437
		

		String facility= (String) session.getValue( "facility_id" ) ;
		String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
		String encounter_id = request.getParameter("encounter_id");
		String patient_id = request.getParameter("pat_id");
		String loc_type = request.getParameter("clinic_type");
		String oplocation = request.getParameter("location_id");
		String pract = request.getParameter("pract_id");
		String module_id = request.getParameter("module_id");
		String queue_date = request.getParameter("queue_date");
		String service_code = request.getParameter("service_code");

		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String registered_in_mo_yn=request.getParameter("registered_in_mo_yn")==null?"":request.getParameter("registered_in_mo_yn");

		
	try
	{
            con=ConnectionManager.getConnection(request);
			isAllowRegForSameService = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALLOW_VISIT_SAME_SER");//Added by Mujafar  for ML-MMOH-CRF-1437
/*
		String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+facility+"','"+userid+"','X','','CANCEL_CHECKOUT_YN') FROM dual" ;  
			pstmt=con.prepareStatement(sql_new);
            rs=pstmt.executeQuery();
            rs.next();
	        String OsVal=rs.getString(1);
        
			if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")))
	        {
			   check_out_yn="Y";
			   
            }else
				{
				check_out_yn="N";
				}
			if(pstmt!=null ) pstmt.close();	
			if (rs != null)  rs.close();

			if(check_out_yn.equals("N"))
			{ */

		//	}else


			//{

		/*	String sql1= "SELECT REGISTERED_IN_MO_YN FROM mp_patient where PATIENT_ID='"+patient_id+"'";			
			String registered_in_mo_yn = "";
			pstmt=con.prepareStatement(sql1);
            rs=pstmt.executeQuery();            
    		if(rs.next() && rs!=null) 	{						
				registered_in_mo_yn=rs.getString("REGISTERED_IN_MO_YN");				
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();		*/	


			String sql2= "SELECT TO_CHAR(ADMISSION_DATE_TIME, 'dd/mm/yyyy hh24:mi')ADMISSION_DATE_TIME from IP_OPEN_ENCOUNTER where PATIENT_ID='"+patient_id+"'";
			String addmission_date_time = "";
			String open_encounter = "";		
				
			pstmt=con.prepareStatement(sql2);
            rs=pstmt.executeQuery();            
    		if(rs.next() && rs!=null) 	{						
				addmission_date_time=rs.getString("ADMISSION_DATE_TIME");				
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			boolean checkdate =false;
			
			checkdate =com.ehis.util.DateUtils.isAfter(addmission_date_time,queue_date,"DMYHM",locale);			
			if(checkdate) 
				open_encounter = "Y";					
			else
				open_encounter = "N";		
			
			String sql4= "select * from op_patient_queue where FACILITY_ID ='"+facility+"' and PATIENT_ID ='"+patient_id+"' and  SERVICE_CODE='"+service_code+"' and  queue_status = '07' and  queue_date > to_date('"+queue_date+"','dd/mm/yyyy hh24:mi:ss')";		
			
			String recordExists = "";
			pstmt=con.prepareStatement(sql4);
			rs=pstmt.executeQuery();
			if(rs.next() && rs!=null){
				recordExists = "Y";
			} else{
				recordExists = "N";
			}

			if(recordExists.equals("Y")){
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			String sql3="";
			if(isAllowRegForSameService) //Added by Mujafar  for ML-MMOH-CRF-1437
				sql3= "select * from op_patient_queue where FACILITY_ID ='"+facility+"' and PATIENT_ID ='"+patient_id+"' and locn_code='"+oplocation+"' and  SERVICE_CODE='"+service_code+"' and  queue_status < '07'";
			else
				sql3= "select * from op_patient_queue where FACILITY_ID ='"+facility+"' and PATIENT_ID ='"+patient_id+"' and  SERVICE_CODE='"+service_code+"' and  queue_status < '07'";
			String op_pat_queue_val ="";			
			pstmt=con.prepareStatement(sql3);
            rs=pstmt.executeQuery();            
    		if(rs.next() && rs!=null) 	{						
				op_pat_queue_val="Y";
			} else {
				op_pat_queue_val = "N";
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();			
			
			if(registered_in_mo_yn.equals("Y")){
				
            _bw.write(_wl_block9Bytes, _wl_block9);

			} 

			if(open_encounter.equals("Y")){
				
            _bw.write(_wl_block10Bytes, _wl_block10);

			} 

			if(op_pat_queue_val.equals("Y")){
				
            _bw.write(_wl_block11Bytes, _wl_block11);

			} 

			 if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oplocation));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(loc_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oplocation));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(loc_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);

		//}
	}catch(Exception e){out.println("Errorr"+e);
			e.printStackTrace();	
				
	}finally{
		//if(cs != null)  cs.close() ;
		ConnectionManager.returnConnection(con,request);
		}
	
	
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
