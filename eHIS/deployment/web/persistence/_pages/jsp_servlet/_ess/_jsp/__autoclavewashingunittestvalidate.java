package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eSS.*;
import eSS.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __autoclavewashingunittestvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/AutoclaveWashingUnitTestValidate.jsp", 1732661522000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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

/*

--------------------------------------------------------------------------------------------------------------------
Date       Edit History     Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
25/11/2014	IN052312		Karthi L						Ramesh			Autoclaving Unit Test Entry
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.ArrayList alAutoclaveWashingUnitTestList= null;synchronized(session){
                alAutoclaveWashingUnitTestList=(java.util.ArrayList)pageContext.getAttribute("alAutoclaveWashingUnitTestList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alAutoclaveWashingUnitTestList==null){
                    alAutoclaveWashingUnitTestList=new java.util.ArrayList();
                    pageContext.setAttribute("alAutoclaveWashingUnitTestList",alAutoclaveWashingUnitTestList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
   	String bean_id								=	"autoclaveWashingUnitTestListBean" ;
	String bean_name							=	"eSS.AutoclaveWashingUnitTestListBean";
	AutoclaveWashingUnitTestListBean bean		= (AutoclaveWashingUnitTestListBean) getBeanObject(bean_id, bean_name, request) ;  
	String autoclave_wash_unit_code				=	request.getParameter("autoclave_wash_unit_code");
	String validate								=	request.getParameter("validate");

	String test_code							=	request.getParameter("test_code");
	String batch_id								=	request.getParameter("batch_id"); ;
	String test_result							=	request.getParameter("test_result");
	String result_date							=	request.getParameter("result_date"); 
	String unit_type							=	request.getParameter("unit_type"); 
	String result_remarks						=	request.getParameter("result_remarks"); 

	String index								=	request.getParameter("index");
	// added for AAKH-CRF-0057 - IN052312 - Start
	String room_temp							=	request.getParameter("room_temp");
	String relative_humidity					=	request.getParameter("relative_humidity");
	String biologic_indicator					=	request.getParameter("biologic_indicator");
	String bms_pass_fail						=	request.getParameter("bms_pass_fail");
	// added for AAKH-CRF-0057 - IN052312 - End
	String message								=	"";
	String flag									=	"";
	boolean	result								=	false;

	try{
		if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	new HashMap();
			bean.setUnit_type(unit_type);
		if(bean.isTestCodeInArrayList(alAutoclaveWashingUnitTestList,test_code,autoclave_wash_unit_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			hmListItems.put("test_code",		test_code		);
			hmListItems.put("batch_id",		batch_id );
			hmListItems.put("test_result",				test_result		);
			hmListItems.put("result_date",				result_date );
			hmListItems.put("result_remarks",				result_remarks		);
			hmListItems.put("unit_type",				unit_type		);
			// added for AAKH-CRF-0057 - IN052312 - Start
			hmListItems.put("room_temp",		room_temp		);
			hmListItems.put("relative_humidity",		relative_humidity		);
			hmListItems.put("biologic_indicator",		biologic_indicator		);
			hmListItems.put("bms_pass_fail",		bms_pass_fail		);
			// added for AAKH-CRF-0057 - IN052312 - End
			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alAutoclaveWashingUnitTestList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alAutoclaveWashingUnitTestList.get(Integer.parseInt(index))).get("mode"));
				alAutoclaveWashingUnitTestList.set(Integer.parseInt(index),hmListItems);
			}
			result	=	true;
			message	=	"Done";
		}
		else if(validate.equals("LOAD_BMS_BIO_CODE")){
			String bio_bms_codes = bean.getBioBmsApplicableCodes(test_code);
			out.println( "addBmsBiologicalCodes(\"" + bio_bms_codes + "\");" ) ;
		}
		//Ramesh Start.
		else if(validate.equals("CLEAR_LIST")){
			alAutoclaveWashingUnitTestList.clear();
		}
		//Ramesh End.
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		putObjectInBean(bean_id,bean,request);
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
