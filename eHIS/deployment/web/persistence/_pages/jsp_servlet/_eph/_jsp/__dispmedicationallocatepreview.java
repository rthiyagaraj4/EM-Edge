package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispmedicationallocatepreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationAllocatePreview.jsp", 1709120712833L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t</head>\n\t<!-- <body topmargin=\"0\"> -->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\" topmargin=\"0\">\n\t\t<form name=\"DispMedicationAllocatePreview\" id=\"DispMedicationAllocatePreview\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class= \"COLUMNHEADERCENTER\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADERCENTER\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style=\"font-size:9;\">\n\t\t\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"drug_desc";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t</label>&nbsp;&nbsp; <!---/*bean.getUomDisplay(facility_id,strength_uom)*/-->\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<br>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</label>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label>&nbsp;</label>\n\t\t\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\n\t\t\t\t\t\t\t\t<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t<label style=\"font-size:9\">&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b>&nbsp;</label>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" style=\"font-size:9\">\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t<br>\t\n\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t\t\t\t\t\t\t\t\t\t<br>&nbsp;\t\t\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t</label><!--/*bean.getUomDisplay(facility_id,strength_uom)*/-->\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t<label style=\"color:";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label>\n\t\t\t\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style=\"color:";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" style=\"font-size:9\" >&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =")\n\t\t<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t<label style=\"font-size:9;color:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">&nbsp;<b>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </b>&nbsp;</label>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" style=\"font-size:9\">&nbsp;\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t<br>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t&nbsp;<br>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t&nbsp;<br>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t&nbsp;<br>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\n\t\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t</table>\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\"white\" align=\'right\'>\n\t\t\t\t\t\t<input type=\"button\" name=\"btnPreviewClose\" id=\"btnPreviewClose\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' onClick=\"window.close()\" class=\"button\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\"hidden\" name=\"qty_found\" id=\"qty_found\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

			try{
			String	bean_id			=	"DispMedicationAllStages" ;
			String	bean_name		=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request ) ;
			bean.setLanguageId(locale);

			String	bean_id_1		=	"DispMedicationBean" ;
			String	bean_name_1		=	"ePH.DispMedicationBean";
			
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1,request);
			bean_1.setLanguageId(locale);

			String facility_id	= (String) session.getValue("facility_id");
			String patient_id	= request.getParameter("patient_id");
			String order_id		= request.getParameter("order_id");
			String chosen_drug	= request.getParameter("chosen_drug");
			String source		= request.getParameter("source");
			String taper, show_remarks, taper_disable;

			if (order_id==null)		order_id	="";
			if (chosen_drug==null)	chosen_drug	="";
			if (source==null)		source	="";

			String order_line_no	=	"";
			String drug_code		=	"";
			String drug_name		=	"";
			
			String end_date			=	"";
			String pres_qty			=	"";
			String qty_uom			=	"";
			String qty_uom_disp		=	"";
			String alt_drug_code	=	"";
			String alt_drug_desc	=	"";
			String drug_color		=	"";
			String style			=	"";
			String strength_value	=	"";
			String strength_uom		=	"";
			String strength_uom_disp=	"";
			HashMap pack_dtls		=	null;	
			String uom				=	""; 
			
			boolean qty_found		=	false;
			double	tot_qty			=	0;
			ArrayList	colors		=	new ArrayList();
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			String disp_level	    = bean_1.getDispLevelValue();

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult  = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null)
			{
				alOrderIds = bean_1.getAlTrxOrderIds();
			}


			if(disp_level.equals("P")) {
				//order lines of all orders
				result			= bean_1.getOrders(patient_id.trim());

				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))) // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
				{
					if(alOrderIds.size()>0)
					{
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607 //Modified for RUT-CRF-0088 [IN036978]  13 ->11 //IN 44141
							if(alOrderIds.contains(result.get(i+1)))
							{
								for(int j=i;j< i+11;j++)	//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978]  13 ->11 //IN 44141
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();
			
				for(int i=0;i<result.size();i=i+11) {		 //10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978]  13 ->11 //IN 44141
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0) {
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
					
					for(int j=0; j<tmp.size(); j++)
						orderLineDtls.add(tmp.get(j));
					}
				}
			}
			else {
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}

			String disp_stage		=	bean_1.getDispStage();
			String module_id	    =	bean.getModuleId();
/*
			if(module_id.equals("1")) {
				//width_1	=	"50%";
				//width_2	=	"25%";
				//width_3	=	"25%";
			}
			else {
				//width_1	=	"61%";
				//width_2	=	"15%";
				//width_3	=	"19%";
			}*/


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

				String classvalue			=	"";
				int recCount				=	1;
				//String strMulti				=	"";
				ArrayList stock_opt			=	new ArrayList();
				//String image				=	"";
				//String alt_strength_value	=	"";
				//String alt_strength_uom		=	"";
				//float  prod_qty				=  0.0f;
				for(int i=0;i<orderLineDtls.size(); i++){

					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

					if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
						order_id		=	(String)orderLineDtls.get(i);
						//ordered_by	=	(String)orderLineDtls.get(++i);
									  i = i+2;
					//	location		=	(String)orderLineDtls.get(++i);
						++i;
					}

					
					stock_opt		=	new ArrayList();
					//image			=	"";
					tot_qty			=	0;
					//onClick			=	"";
					
					//allergy		=	(String)orderLineDtls.get(i);
								 i	=	i+2;
					//exceed_dose	=	(String)orderLineDtls.get(++i);
					//duplicate		=	(String)orderLineDtls.get(++i);
					drug_code		=	(String)orderLineDtls.get(++i);
					drug_name		=	(String)orderLineDtls.get(++i);
								i	=	i+2;
					//dosage_dtls	=	(String)orderLineDtls.get(++i);              
					//start_date	=	(String)orderLineDtls.get(++i);
					end_date		=	(String)orderLineDtls.get(++i);
					pres_qty		=	(String)orderLineDtls.get(++i);
					qty_uom			=	(String)orderLineDtls.get(++i);
					qty_uom_disp	=	(String)orderLineDtls.get(++i);
					order_line_no	=	(String)orderLineDtls.get(++i);
					i	=	i+4;
					//generic_id	=	(String)orderLineDtls.get(++i);
					//generic_name	=	(String)orderLineDtls.get(++i);
					//dosage_details=	(String)orderLineDtls.get(++i);
					//bms_qty		=	(String)orderLineDtls.get(++i);
					i	=	i+6;
					//duplicate_yn	=	(String)orderLineDtls.get(++i);
					//min_dose_dtls	=	(String)orderLineDtls.get(++i);
					i	=	i+2;
					strength_value	=	(String)orderLineDtls.get(++i);
					strength_uom	=	(String)orderLineDtls.get(++i);
					strength_uom_disp	=	(String)orderLineDtls.get(++i);
					if(module_id.equals("2")) {
						StringTokenizer st	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
						while(st.hasMoreTokens()){
							stock_opt.add((String)st.nextToken());
						} 
					}
					i=i+30;//changed 26 to 27 for Bru-HIMS-CRF-093-DD1[IN047223] //changed from i+24 to i+26 for dischargeIND, encounter_id 25-->26 for JD-CRF-0179 [IN:041211] // 27 --> 28 for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271] --> 30 for  HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080

					/* Commented for RUT-CRF-0088 [IN036978] //IN 44141
					taper_order_yn 					=	(String)orderLineDtls.get(++i);// RUT-CRF-0069 ICN29607		
					taper_order_id					=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607
					taper_order_line_num					=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607*/

					if(end_date.length() >=10)
					end_date		=	end_date.substring(0,10);

					if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
						strength_value = Float.parseFloat(strength_value) +"" ;

					if(strength_value.equals("0")) {
						strength_value	=	"";
						strength_uom	=	"";
					}

					if(!chosen_drug.equals("") && !chosen_drug.equals(drug_code))
						continue;

					if(bean.checkHold(order_id,order_line_no)) 
						continue;

					ArrayList multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);
					String qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					if(!qty.equals(""))
						tot_qty				+=	Double.parseDouble(qty);

					//String alt_drug				=	bean.checkMultiStrength(drug_code);
					//	alt_drug_qty			=	"";
					ArrayList drug_detail		=	new ArrayList();
					ArrayList alt_drug_detail	=	new ArrayList();

					if(multi_drugs.size()	<	1	) {
						drug_detail					=	bean.getDrugDetail(patient_id,order_id,order_line_no);
					} 
				//if(!(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals(""))){ //Commented for RUT-CRF-0088 [IN036978] //IN 44141
					if(multi_drugs.size() < 1 && drug_detail.size()!=0) {
						String item_code	=	"";
						//String item_desc	=	"";
						String batch_id		=	"";
						String expiry_date	=	"";
						String alloc_qty	=	"";
						ArrayList	item_det	=	new ArrayList();

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(style));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strength_uom_disp));
            _bw.write(_wl_block18Bytes, _wl_block18);

							int	incr_1					=	0;	
							String prev_item_code		=	"";
							
							while(drug_detail.size() > incr_1 ) {
								item_code	=		(String)drug_detail.get(incr_1);
								incr_1		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block19Bytes, _wl_block19);
	
									if(!prev_item_code.equals(item_code)) {	
										prev_item_code	=	item_code;

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
	
									}
									else{	

            _bw.write(_wl_block22Bytes, _wl_block22);
	
									}
								}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block26Bytes, _wl_block26);

								int	qty_incr					=	0;	
								while(drug_detail.size() > qty_incr ) {	
									alloc_qty		=		(String)drug_detail.get(qty_incr+3);
									qty_incr		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alloc_qty));
            _bw.write(_wl_block28Bytes, _wl_block28);
	
								}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
								int	incr_3					=	0;		
								while(drug_detail.size() > incr_3 ) {	
									expiry_date	=		(String)drug_detail.get(incr_3+2);
									incr_3		+=	10;  //9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)));
            _bw.write(_wl_block1Bytes, _wl_block1);
	
								}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
								int	incr_4					=	0;		
								while(drug_detail.size() > incr_4 ) {	
									item_code	=		(String)drug_detail.get(incr_4);
									batch_id	=		(String)drug_detail.get(incr_4+1);
									item_det	=	bean.getItemAndTradeName(item_code,batch_id);
									incr_4		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]
									if(item_det.size()==2) {					

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)item_det.get(0)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)item_det.get(1)));
            _bw.write(_wl_block1Bytes, _wl_block1);
		
									}
									else{	

            _bw.write(_wl_block34Bytes, _wl_block34);

									}
								}	

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
								int	incr_5					=	0;		
								while(drug_detail.size() > incr_5 ) {	
									batch_id	=		(String)drug_detail.get(incr_5+1);	
									incr_5		+=	10;   //9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block1Bytes, _wl_block1);
	
								}

            _bw.write(_wl_block36Bytes, _wl_block36);
	
						}	
						else if(multi_drugs.size() != 0) 	{
							String item_code	=	"";
							//String item_desc	=	"";
							String batch_id		=	"";
							String expiry_date	=	"";
							String alloc_qty	=	"";
							int			x		=	0;
							ArrayList	item_det	=	new ArrayList();

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(style));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strength_uom_disp));
            _bw.write(_wl_block39Bytes, _wl_block39);

							for(int n=0; n<multi_drugs.size(); n+=5)	{ 
								alt_drug_code			=	(String)multi_drugs.get(n);
								alt_drug_desc			=	(String)multi_drugs.get(n+1);
								alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
								drug_color				=	(String)colors.get(x++);
							
								int	incr_1					=	0;	
								String prev_item_code		=	"";
								while(alt_drug_detail.size() > incr_1 ) {
									item_code	=		(String)alt_drug_detail.get(incr_1);
									incr_1		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block40Bytes, _wl_block40);

								if(!prev_item_code.equals(item_code)) {	
									prev_item_code	=	item_code;

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}
								else	{	

            _bw.write(_wl_block44Bytes, _wl_block44);

								}
							}	
						}

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty_uom_disp));
            _bw.write(_wl_block47Bytes, _wl_block47);
	
						x		=	0;
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
							drug_color				=	(String)colors.get(x++);
							pack_dtls				=	bean.getPackSize(alt_drug_code);
							uom						=	(String)pack_dtls.get("STOCK_UOM");
							int	incr_2					=	0;
							while(alt_drug_detail.size() > incr_2 ) {
								alloc_qty	=		(String)alt_drug_detail.get(incr_2+3);
								incr_2		+=	10;//9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(alloc_qty));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
							}
						}

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
	
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
							
							int	incr_3					=	0;	
							while(alt_drug_detail.size() > incr_3 ) {
								expiry_date	=		(String)alt_drug_detail.get(incr_3+2);
								incr_3		+=	10;//9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block1Bytes, _wl_block1);
	
							}	
						}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);

							int	incr_4					=	0;
							while(alt_drug_detail.size() > incr_4 ) {	
								item_code	=		(String)alt_drug_detail.get(incr_4);
								batch_id	=		(String)alt_drug_detail.get(incr_4+1);
								item_det	=	bean.getItemAndTradeName(item_code,batch_id);	
								incr_4		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]
								if(item_det.size()==2) {	

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf((String)item_det.get(0)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)item_det.get(1)));
            _bw.write(_wl_block1Bytes, _wl_block1);
	
								}
								else	{	

            _bw.write(_wl_block55Bytes, _wl_block55);
	
								}
							}
						}

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
		
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);

							int	incr_5					=	0;	
							while(alt_drug_detail.size() > incr_5 ) {	
								batch_id	=		(String)alt_drug_detail.get(incr_5+1);	
								incr_5		+=	10;   //9->10 for MMS-SCF-0040 [IN:041888]

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block1Bytes, _wl_block1);
	
							}
						}

            _bw.write(_wl_block58Bytes, _wl_block58);
	
				}
				//}		//Commented for RUT-CRF-0088 [IN036978] //IN 44141
				recCount++;
			}

            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(qty_found));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block65Bytes, _wl_block65);

putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);

            _bw.write(_wl_block1Bytes, _wl_block1);

	}catch(Exception e){

      e.printStackTrace();
}


            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreviewAllocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug/ItemDesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TradeName/ManufacturerName.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
