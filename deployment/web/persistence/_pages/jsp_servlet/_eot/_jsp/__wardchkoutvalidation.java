package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import java.util.Hashtable;
import eOT.Common.*;
import eOT.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __wardchkoutvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/WardChkOutValidation.jsp", 1709117298000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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

//"java.sql.*, java.util.*, java.io.*, eOT.Common.*, eOT.*"

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);


	try {
		String func_mode	= request.getParameter("func_mode");
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "@WardChkOutBean";
		String bean_name	= "eOT.WardChkOutBean";
		WardChkOutBean bean= (WardChkOutBean)mh.getBeanObject( bean_id, request, bean_name );

		if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
		}else if(func_mode!= null && func_mode.equals("updateStatusAndCommit")){
			String booking_num		= (String) hash.get("booking_num");
			String bookings_type	= (String) hash.get("bookings_type");
			String check_out_time	= (String) hash.get("check_out_time");	
			String error_text = "";
			ArrayList result_arr = new ArrayList();
			if(bookings_type.equals("S"))
				error_text = bean.updateStatusAndCommit(booking_num,check_out_time);
			else if(bookings_type.equals("R")){ // RD Exams Check-out from ward.
				result_arr = bean.updateRDExamsStatusAndCommit(booking_num);
				error_text = (String)result_arr.get(0);
			}
			if(error_text==null) error_text="";
			if(error_text!=null && error_text.equals("null")) error_text="";
			if(error_text!=null && error_text.equals("")) error_text="";
			if(bookings_type.equals("S")){
				if(!error_text.equals("") && !error_text.equals("RECORD_INSERTED"))
					out.println(error_text);
				else
					out.println("NO_ERROR_FOUND");
			}else if(bookings_type.equals("R")){
				if(error_text.equals("E")){
					out.println(error_text);
				}else
					out.println("NO_ERROR_FOUND");
			}
		}else if(func_mode!= null && func_mode.equals("getCheckListsDetails")){
			String appt_ref_num	    =	(String) hash.get("appt_ref_num");
			String order_id     	=	(String) hash.get("order_id");
			String speciality_code  =	(String) hash.get("speciality_code");
			String verify_checklist_codes="";
			String no_of_verifications = "1";
			String role_id_1 = "";
			String role_id_2 = "";
			String role_id_3 = "";
			String role_id_4 = "";
			String retVal = "";
			ArrayList verify_checklist_arr = new ArrayList();
            
			verify_checklist_arr = bean.getOperChecklists(appt_ref_num,"",speciality_code,order_id); 
    
			if(verify_checklist_arr.size()>0){
			verify_checklist_codes=checkForNull((String)verify_checklist_arr.get(0));
			no_of_verifications = checkForNull((String)verify_checklist_arr.get(1));
			role_id_1 = checkForNull((String)verify_checklist_arr.get(2));
			role_id_2 = checkForNull((String)verify_checklist_arr.get(3));
			role_id_3 = checkForNull((String)verify_checklist_arr.get(4));
			role_id_4 = checkForNull((String)verify_checklist_arr.get(5));
			}else{
			verify_checklist_codes="";
			no_of_verifications = "";
			role_id_1 = "";
			role_id_2 = "";
			role_id_3 = "";
			role_id_4 = "";
			}
			 
			retVal=verify_checklist_codes+"$$"+no_of_verifications+"$$"+role_id_1+"$$"+role_id_2+"$$"+role_id_3+"$$"+role_id_4;
			out.println(retVal);
		}else if(func_mode!= null && func_mode.equals("getUserInfo")){
			String appt_ref_num	    =	(String) hash.get("appt_ref_num");
			String order_id     	=	(String) hash.get("order_id");
			String appt_yn          =	(String) hash.get("appt_yn");
			String old_checklist_user_id = "";
	        String checklist_completed_yn = "N";
			String retVal = "";
			ArrayList user_info_arr = new ArrayList();
            
			user_info_arr = (ArrayList)bean.getUserInfo(appt_ref_num,"","1",order_id,appt_yn);
			if(user_info_arr.size()>0){
				old_checklist_user_id	= (String)user_info_arr.get(0);
				checklist_completed_yn	= (String)user_info_arr.get(1);
			}else{
				old_checklist_user_id = "";
				checklist_completed_yn = "N";
			}
            
			retVal=old_checklist_user_id+"$$"+checklist_completed_yn;
			out.println(retVal);
		}					
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
