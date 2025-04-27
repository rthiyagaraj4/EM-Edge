package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __altdisplocnvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/AltDispLocnValidate.jsp", 1722257489865L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	String objname = request.getParameter( "object" ) ;
	String mode = request.getParameter( "mode" ) ;
	String code="";
	String desc="";
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	
  
	AltDispLocnBean beanObj = ( AltDispLocnBean )getBeanObject(bean_id,bean_name,request) ;
	beanObj.setLanguageId(locale);
	String logged_fcy = beanObj.getLoggedInFacility();
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
   
   

	hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "ORDER_SRC_TYPE" ) ) {
      
		out.println("clearData('document.AltDispLocn.ORDER_SRC_LOCN');") ;
	
		String order_src_type = (String)hash.get( objname ) ;
		String Ordering_Facility = request.getParameter( "Ordering_Facility" ) ;
		ArrayList ordSrcLocns = beanObj.getLocns(order_src_type, "",Ordering_Facility,"1") ;
		for (int i=0; i<ordSrcLocns.size(); i+=2) {
			code=(String)ordSrcLocns.get(i);
			desc=(String)ordSrcLocns.get(i+1);
			if((code.substring(0,1)).equals("'")){
				code=code.substring(1,(code.length())-1);
			}
			if((desc.substring(0,1)).equals("'")){
				desc=desc.substring(1,(desc.length())-1);
			}
			out.println("addData('"+ code + "', '" + desc +"', 'document.AltDispLocnHeaderForm.ORDER_SRC_LOCN');") ;
		}
	}
	if ( validate.equals( "ORDER_FCY" ) ) {
	
		out.println("clearData('document.AltDispLocnHeaderForm.ORDER_SRC_LOCN');") ;
	
		String Ordering_Facility = (String)hash.get( objname ) ;
        String order_src_type = request.getParameter( "ord_src_type" ) ;
     
	
		ArrayList ordSrcLocns = beanObj.getLocns(order_src_type, "",Ordering_Facility,"1") ;
		
		for (int i=0; i<ordSrcLocns.size(); i+=2) {
			code=(String)ordSrcLocns.get(i);
			desc=(String)ordSrcLocns.get(i+1);
			if((code.substring(0,1)).equals("'")){
				code=code.substring(1,(code.length())-1);
			}
			if((desc.substring(0,1)).equals("'")){
				desc=desc.substring(1,(desc.length())-1);
			}
			out.println("addData('"+ code + "', '" + desc +"', 'document.AltDispLocnHeaderForm.ORDER_SRC_LOCN');") ;
		}
	}
	if ( validate.equals( "PERFORM_FCY" ) ) {
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
	
		String perform_fcy = (String)hash.get( objname ) ;
		
	
		ArrayList ordSrcLocns = beanObj.getLocns(ord_src_type, perform_fcy,"","1") ;
		for (int i=0; i<ordSrcLocns.size(); i+=3) {
			
		
			
			if(mode.equals("1")){
							out.println("addData2();");
						}
		}
	}

	if(validate.equals("alt_disp_locn_select")){	
		String alt_disp_code=request.getParameter("alt_disp_code");
		String frmtime=request.getParameter("frmtime");
		String totime=request.getParameter("totime");
		String flag=request.getParameter("flag");
		String eff_status=request.getParameter("eff_status");
		String repeat=request.getParameter("repeat");
		ArrayList altdisp=new ArrayList();
		altdisp=beanObj.selectedlocn(alt_disp_code,frmtime,totime,flag,eff_status,repeat);
	}
	if ( validate.equals( "ORDER_SRC_LOCN" ) ) {
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
		String perform_fcy = logged_fcy ;
		ArrayList ordSrcLocns = beanObj.getLocns(ord_src_type, perform_fcy,"","1") ;
		for (int i=0; i<ordSrcLocns.size(); i+=3) {
			
			if(mode.equals("1")){
				out.println("addData2();");
			}
		}
	}
	if ( validate.equals( "CUR_DISP_LOC" ) ) {
		String order_fcy = request.getParameter( "order_fcy" ) ;
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
        String order_src_locn = request.getParameter( "order_src_locn" ) ;
		HashMap hm= null;
	 	out.println("clearData('document.AltDispLocnHeaderForm.CURR_DISP_LOC');") ;
	    ArrayList disp_loc_code = beanObj.getCurrDispLocation(order_fcy, ord_src_type,order_src_locn);
		if(disp_loc_code!=null && disp_loc_code.size()>0){
			for (int i=0; i<disp_loc_code.size(); i++) {
				hm= new HashMap();
				hm=(HashMap)disp_loc_code.get(i);
				code=hm.get("CODE")==null?"":(String)hm.get("CODE");
				desc=hm.get("DESC")==null?"":(String)hm.get("DESC");
				if(!code.equals("")){
					if((code.substring(0,1)).equals("'")){
						code=code.substring(1,(code.length())-1);
					}
					if((desc.substring(0,1)).equals("'")){
						desc=desc.substring(1,(desc.length())-1);
					}
					out.println("addData('"+ code  + "',\"" + desc +"\", 'document.AltDispLocnHeaderForm.CURR_DISP_LOC');") ;	
				}
			}
		}
   	}
	if ( validate.equals( "ALT_DISP_LOC" ) ) {
		String order_fcy = request.getParameter( "order_fcy" ) ;
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
        String order_src_locn = request.getParameter( "order_src_locn" ) ;
		String alt_disp_locn_code = beanObj.getAltDispLocnCode(order_fcy, ord_src_type,order_src_locn) ;
			 if(!(alt_disp_locn_code.equals("")))   
				out.println("addData1('"+alt_disp_locn_code + "', 'f_query_add_mod.alt_disp_locn_header.document.AltDispLocnHeaderForm.alt_disp_locn_code');") ;		
	} 
	if ( validate.equals( "for_timings" ) ) {
		String order_fcy = request.getParameter( "order_fcy" ) ;
		String short_desc = request.getParameter( "short_desc" ) ;
		String working_hours_from="";
		String working_hours_to="";
        ArrayList desptimes = beanObj.getDespTimings(order_fcy,short_desc) ;
		if (desptimes.size() != 0){
		 working_hours_from = (String)desptimes.get(0);
		 working_hours_to = (String)desptimes.get(1);
		}          
		
         out.println("addtimings('"+ working_hours_from + "','"+working_hours_to+"' );") ;
	}
	putObjectInBean(bean_id,beanObj,request);
	
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
