package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __specialapprovalordersbottom extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/SpecialApprovalOrdersBottom.jsp", 1731920146000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/SpecialApproveOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<script>function_id = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";</script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<iframe name=\'SpecialApprovalOrdersBottomLeft\' id=\'SpecialApprovalOrdersBottomLeft\'\tsrc=\'SpecialApprovalOrdersBottomLeft.jsp?source_type=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&source_code=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&patientId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&period_from=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&period_to=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&filter=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  frameborder=0 scrolling=\'no\' noresize style=\'height:100vh;width:20vw\' ></iframe>\n\t<iframe name=\'SpecialApprovalOrdersBottomRight\' id=\'SpecialApprovalOrdersBottomRight\' src=\'SpecialApprovalOrdersBottomRight.jsp?source_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&order_by=O&filter=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  frameborder=0 scrolling=\'no\' style=\'height:100vh;width:77vw\'></iframe>\n</html>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.SpecialApproveOrders bean= null;{
                bean=(eOR.SpecialApproveOrders)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eOR.SpecialApproveOrders();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
//	String bean_id = "Or_SpecialApproveOrders" ;
//	String bean_name = "eOR.SpecialApproveOrders";

	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";

	String source_type = request.getParameter("location_type");
	String source_code = request.getParameter("locn");
	String patientId   = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String filter=request.getParameter("filter")==null?"":request.getParameter("filter");

	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	//period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",localeName,"en");
	//period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",localeName,"en");
	Properties properties	= (Properties) session.getValue( "jdbc" );

//	SpecialApproveOrders bean = (SpecialApproveOrders)getBeanObject( bean_id, bean_name ,request ) ;

	bean.setLanguageId(localeName);
	//out.print(localeName);
	String  spl_yn = "";
	spl_yn = bean.getSplYN(properties, practitioner_id,resp_id) ;

	if((spl_yn.trim()).equals("")){
		out.println("<script>parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('PRACT_RESP_CANNOT_SPECIAL_APPRV','OR')); parent.location.href='../../eCommon/html/blank.html'</script>");
	}

	/*out.println("source_type > "+source_type+"<");
	out.println("source_code > "+source_code+"<");
	out.println("practitioner_id > "+practitioner_id+"<");
	out.println("resp_id > "+resp_id+"<");
*/
	ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,resp_id,patientId, period_from, period_to,"PS",filter) ;

//	out.println("PriorityData > "+PriorityData.size()+"<");
	if(PriorityData.size() == 0){
		out.println("<script>parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
	}
	if(PriorityData!=null) {
		PriorityData.clear();
		PriorityData = null;
	}


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(filter));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(filter));
            _bw.write(_wl_block17Bytes, _wl_block17);

	//putObjectInBean(bean_id,bean,request);

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
