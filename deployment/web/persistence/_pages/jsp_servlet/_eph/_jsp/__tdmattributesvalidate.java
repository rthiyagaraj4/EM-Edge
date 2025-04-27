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

public final class __tdmattributesvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TDMAttributesValidate.jsp", 1721642754293L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String bean_id			=	 request.getParameter( "bean_id" ) ;
	String bean_name		=	 request.getParameter( "bean_name" ) ;
	String validate			=	 request.getParameter( "validate" ) ;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;
	TDMAttributesBean bean	=	 (TDMAttributesBean)getBeanObject( bean_id,bean_name,request);
	Hashtable hash						=	 ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash										=	 ( Hashtable )hash.get( "SEARCH" ) ;
	try{
		if ( validate.equals( "LAB_ORDER_FINAL" ) ) {
			String sample				=		request.getParameter("sample");
			bean.setSelectLabOrderFinal(sample);
		}
		else if ( validate.equals( "LAB_ORDER_SELECT_REMOVE" ) ) {
			String labOrdercode		=		request.getParameter("labOrdercode")==null?"":request.getParameter("labOrdercode");
			String labOrderdesc		=		request.getParameter("labOrderdesc")==null?"":request.getParameter("labOrderdesc");
		//	if(!labOrderdesc.equals(""))
		//		labOrderdesc = java.net.URLDecoder.decode(labOrderdesc,"UTF-8"); //decoded for IN24564-reopen --04/11/2010-- priya
			String sample				=		request.getParameter("sample");
			String flag						=		request.getParameter("flag");
			String final_yn						=		request.getParameter("final_yn")==null?"N":request.getParameter("final_yn");
			bean.setSelectLabOrder(labOrdercode,labOrderdesc,flag,sample);
			if(final_yn.equals("Y")){
				bean.setSelectLabOrderFinal(sample);
			}
		}
		else if ( validate.equals( "LAB_ORDER_RESET" ) ) {
			String sample				=		request.getParameter("sample");
			bean.setSelectLabOrderReset(sample);
		}
		else if ( validate.equals( "saveRemark" ) ) {
			String stype			 = (String)hash.get("stypecode");
			String remarks = "";
			if(stype.equals("P")){
				remarks = (String)hash.get("remarks");
				bean.setPeakRemarks(remarks);
			} 
			else if(stype.equals("T")){
				remarks	   = (String)hash.get("remarks");
				bean.setTroughRemarks(remarks);
			} 
			else if(stype.equals("E")){
				remarks	 = (String)hash.get("remarks");
				bean.setExtendRemarks(remarks);
			} 
			else if(stype.equals("R")){
				remarks	  = (String)hash.get("remarks");
				bean.setRandomRemarks(remarks);
			}
		}
		else if ( validate.equals( "CLEAR_SAMPLE" ) ) {
			String sample			=		request.getParameter("sample");
				bean.clearSampleList(sample);
				bean.clearSamplingDetails(sample);
			out.println("loadResult()");
		}
		else if ( validate.equals( "CHECKFORVALID" ) ) {
			String drugCode			=		request.getParameter("drugCode");
			String ageGrpCode		=		request.getParameter("ageGrpCode");
			int flag=0;
			flag=bean.checkforvalid(drugCode,ageGrpCode);
			out.println("clearCheckForValid('"+flag+"')");	
		}
		else if ( validate.equals( "SAMPLETIME" ) ) {
			String sampleType		=		request.getParameter("sampleType");
			String sampleTime		=		request.getParameter("sampleTime");
			String sampleTimeType	=		request.getParameter("sampleTimeType");
			bean.setSamplingDetails(sampleType,sampleTime,sampleTimeType);
		}
		else if ( validate.equals( "CHECKFOROVERLAP" ) ) {
			String drug_code		= (String) hash.get("drugCode");
			String age_group_code	= (String) hash.get("age_group_code");
			String exists_yn	=	bean.CheckForOverlap(drug_code,age_group_code);
			out.println("clearCheckForOverlap('"+exists_yn+"')");	
		}
		else if ( validate.equals( "CHECKFOROVERLAP" ) ) {
			String drug_code		= (String) hash.get("drugCode");
			String age_group_code	= (String) hash.get("age_group_code");
			String exists_yn	=	bean.CheckForOverlap(drug_code,age_group_code);
			out.println("clearCheckForOverlap('"+exists_yn+"')");	
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	putObjectInBean(bean_id,bean,request);

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
