package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patlistbylocationpatclass extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByLocationPatClass.jsp", 1735585026640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\'\tlanguage=\'javascript\'></script>\n<script src=\'../../eCA/js/PatientListByLocationResult.js\'\tlanguage=\'javascript\'></script>\n<script src=\'../../eCA/js/PatListByLocation.js\'\tlanguage=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\'\t\t\tlanguage=\'javascript\'></script>\n</head>\n\n<STYLE TYPE=\"text/css\">\nA:link {\n\tCOLOR: white;\n}\n\nA:visited {\n\tCOLOR:white ;\n}\nA:active {\n\tCOLOR: white;\n}\n</STYLE>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script language=javascript>\n\n\t\tif(eval(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\').PatResultFr.LocnResult.location != null)\n\t\t{\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\n\t\t}\n\t\t\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\nfunction callLevelTwo(obj)\n{\n\tparent.parent.document.getElementById(\"PatCriteriaFr\").style.height = \"26vh\";\n\tparent.parent.document.getElementById(\"PatResultFr\").style.height = \"60vh\";\n\t//alert(\"here ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="   \"+obj);\n\tif(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \"Y\"&&obj!=\"RP\")\n\t{\n\t\t//makeVisible1(eval(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\').PatCriteriaFr.PatCriteriaFrm,eval(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\').PatCriteriaFr.PatCriteriaFrm.more,\'N\');\n\t\tmakeVisible1(eval(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\').PatCriteriaFr,eval(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\').PatCriteriaFr.PatCriteriaFrm.more,\'N\');\n\t\tvar url = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&pat_type=\'+obj;\n\t\tvar count = url.indexOf(\"&pat_type=\");\n\t\turl = url.substring(0,count);\n\t\turl = url+\'&pat_type=\'+obj;\n\t\teval(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\').PatResultFr.LocnResultLocation.location.href=\'../../eCA/jsp/PatListByLocationPatLocn.jsp?\'+url;\n\t\teval(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\').PatCriteriaFr.PatCriteriaFrm.url.value = url+\'&locn_type=\'+obj;\n\t\t\n\t}\n\telse if(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' == \"N\"||obj==\"RP\")\n\t{\n\t\t//eval(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\').PatResultFr.resultFrameSet.rows =\'7%,0%,0%,*\';\n\t\teval(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\').PatResultFr.LocnResultPatClass.style = \"display\";\n\t\teval(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\').PatResultFr.LocnResultPatClass.style.height = \"7vh\"\n\t\teval(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\').PatResultFr.LocnResultPatClass.style.width = \"100vw\";\n\t\teval(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\').PatResultFr.LocnResultLocation.style.display = \"none\";\n\t\teval(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\').PatResultFr.LocnResultTitle.style.display = \"none\";\n\t\teval(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\').PatResultFr.LocnResult.style.height = \"91vh\"\n\t\teval(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\').PatResultFr.LocnResult.style.width = \"100vw\";\n\t\tvar url = \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&locn_type=\'+obj;\n\t\teval(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\').PatResultFr.LocnResultLocation.location.href=\'../../eCA/jsp/PatListByLocationPatLocn.jsp?\'+url+\'&pat_type=\'+obj;\n\t\t/*added by Deepa on 6/9/2009 at 3:57 PM for IN011216*/\n\t\tif(obj!=\"RP\")\n\t\t{\n\t\t\teval(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\').PatCriteriaFr.PatCriteriaFrm.url.value = url;\n\t\t\t//eval(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\').PatResultFr.LocnResultLocation.url.value = url;\n\t\t}\n\t\t/*added by Deepa on 6/9/2009 at 3:57 PM for IN011216*/\n\t\tif(obj==\"RP\")\n\t\t{\n\t\t\teval(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\').PatResultFr.LocnResultLocation.location.href =\'../../eCommon/html/blank.html\';\n\t\t\teval(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\').PatResultFr.LocnResultTitle.location.href =\'../../eCA/jsp/PatListByLocationTitle.jsp?locn_type=\'+obj;\n\t\t\t//top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href=\'../../eCA/jsp/PatListByLocationTitle.jsp?locn_type=\'+obj;\n\t\t}\n\t\teval(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\').PatResultFr.LocnResult.location.href=\'../../eCA/jsp/PatListByLocationResult.jsp?\'+url;\t\t\n\t}\n\n\tif(eval(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\').PatResultFr.LocnResultTitle.location.href.indexOf(\".jsp\") != -1){\n\t   eval(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\').PatResultFr.LocnResultTitle.location.href=\'../../eCommon/html/blank.html\';\n\t}\n}\n</script>\n\t\t\t<body class =\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n                    <form name=\"formLocnResultPatClass\" id=\"formLocnResultPatClass\">\n                        <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' class=\'\' id=\"tab\" width=\"50%\">\n                        <tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n                                        <th class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  align=\"center\" onMouseOver=\'callOnMouseOver(this);\' onMouseOut=\'callOnMouseOut(this);\'style=\'cursor:pointer;\' onclick=\"display(this);callLevelTwo(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\" >\n\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:callLevelTwo(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\"> ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a></th>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n                        </tr>\n                        </table>\n                            <input type=\"hidden\" name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n                            <input type=\"hidden\" name=\"url\" id=\"url\" value=\"\">\t\t\t\t\t\t\n                        </form>\n            </body>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n            <script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'==\"RP\")\n\t\t\t\t{\t\n\t\t\t\t\tvar url1 = \'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&locn_type=RP\';\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'==\'Y\')\n\t\t\t\t\t{\n\t\t\t\t\t\t//eval(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\').PatResultFr.resultFrameSet.rows =\'4.5%,0%,0%,*\';\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\').PatResultFr.LocnResultPatClass.style = \"display\";\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\').PatResultFr.LocnResultPatClass.style.height = \"7vh\"\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\').PatResultFr.LocnResultPatClass.style.width = \"100vw\";\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\').PatResultFr.LocnResultLocation.style.display = \"none\";\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\').PatResultFr.LocnResultTitle.style.display = \"none\";\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\').PatResultFr.LocnResult.style.height = \"91vh\"\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\').PatResultFr.LocnResult.style.width = \"100vw\";\n\t\t\t\t\t}\n\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'==\'N\')\n\t\t\t\t\t{\n\t\t\t\t\t\t//eval(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\').PatResultFr.resultFrameSet.rows =\'0%,0%,0%,*\';\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\').PatResultFr.LocnResultPatClass.style.display = \"none\";\n\t\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\').PatResultFr.LocnResult.style.width = \"100vw\";\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\').PatCriteriaFr.PatCriteriaFrm.document.forms[0].url.value = url1;\n\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\').PatResultFr.LocnResult.location.href=\'../../eCA/jsp/PatListByLocationResult.jsp?\'+\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&pat_type=RP&locn_type=RP\';\n\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\teval(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\').PatResultFr.LocnResultLocation.location.href=\'../../eCA/jsp/PatListByLocationPatLocn.jsp?";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&pat_type=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\t\t\t\n\t\t\t\t}\n\t\t\t //alert(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\');\n\t\t\t //alert(top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href);\n            </script>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n</html>\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );
	
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


        String getPatientClassName(String code,PageContext pgContxt)
        {
            if(code!=null)
            {
                if(code.equals("IP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.inpatient.label","common_labels");
                else if(code.equals("OP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.Outpatient.label","common_labels");
                else if(code.equals("EM"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.emergency.label","common_labels");
                else if(code.equals("DC"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.daycare.label","common_labels");
				else if(code.equals("RP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.referral.label","common_labels");
            }
            return null;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);

	String queryString  = request.getQueryString();	
	String allowSecondLevel = request.getParameter("allowSecondLevel");
	String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
	String groupByEpisode = request.getParameter("groupByEpisode")==null?"":request.getParameter("groupByEpisode");

	String locnHandle;
	String rp_hanlde="";;
	if (Summary.equals("Summary"))
		locnHandle="parent.parent";
	else
		locnHandle="top.content.workAreaFrame";

	if(allowSecondLevel == null || allowSecondLevel.equals(""))
		allowSecondLevel="";

	String locationType     = request.getParameter("locationType");
	if(locationType == null || locationType =="") 
		locationType="";
	
	String classArray[] = new String[5];
	
	HashSet patClassSet =PatSearch.getFirstLevel();
	
	int j=0;
	
	
	if(patClassSet!=null && patClassSet.size()>0)
	{
		Iterator itr = patClassSet.iterator();

		while(itr.hasNext())
		{
			classArray[j] = (String)itr.next();
			j++;
		}
	}
		
	patClassSet = null;

	if(classArray[0]==null )
	{
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
		
		rp_hanlde = classArray[0]==null?"":classArray[0];
		
		
		

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block37Bytes, _wl_block37);

                            String classValue="";
                            for(int i=0;i<classArray.length;i++)        {
                                if(i==0)  classValue="FIRSTSELECTED";
                                else classValue="FIRSTNORMAL";
						
                                if(classArray[i]!=null){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classArray[i]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classArray[i]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(getPatientClassName(classArray[i],pageContext)));
            _bw.write(_wl_block42Bytes, _wl_block42);
                          }
                             }

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block44Bytes, _wl_block44);

        String pat_type = "";
        if(classArray[0]!=null){
            pat_type = classArray[0];
            if(!allowSecondLevel.equals("")){
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rp_hanlde));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(groupByEpisode));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(groupByEpisode));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block67Bytes, _wl_block67);

            }
        }

            _bw.write(_wl_block68Bytes, _wl_block68);
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
