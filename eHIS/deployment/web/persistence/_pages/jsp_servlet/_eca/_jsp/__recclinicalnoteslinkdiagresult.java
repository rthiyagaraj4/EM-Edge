package jsp_servlet._eca._jsp;

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
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkdiagresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkDiagResult.jsp", 1709116143779L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<!-- added by Kishore Kumar N on 10/12/2008  -->\n\t\t\n\t\t<!-- end here -->\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/RecClinicalNotesLinkDiag.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n</head> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t  \t<script>\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\tparent.window.close();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t  \t<script>\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\n\t\t</script>\n\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n\n\n<body onScroll=\"scrollTitle()\" onKeyDown=\"lockKey()\"> \n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<form name=\"RecClinicalNotesLinkDiagResultForm\" id=\"RecClinicalNotesLinkDiagResultForm\">\t\n<div id=\'authorizeMode\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table  id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n</td>\n</tr>\n</table>\n</div>\n\n<table width=\"100%\" class=\'grid\' name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t&nbsp;<center>\n\t\t<a class=\'gridLink\' href=\"javascript:CallAuathorize(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'V\',\'N\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\" onMouseOver=\"showToolTip(this,\'Y\')\" onMouseOut=\"javascript:hideToolTip()\" ><font size=\'2\' color=\'red\'> [";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="] </a></font></center>\t\n\t\t\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<tr>\n<td class=\'columnheadercenter\' width=\"8%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<input type=\'checkbox\' name=\'ctrlChkBox\' id=\'ctrlChkBox\' onClick=\"javascript:perform(this);\" ></td>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<td class=\'columnheadercenter\' style=\"font-size:10\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n \t\t<td class=\'columnheadercenter\' style=\"font-size:10\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td><!-- 38981 -->\n \t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<td class=\'columnheadercenter\' style=\"font-size:10\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<td class=\'columnheadercenter\' style=\"font-size:10\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td><!-- 38981 -->\n\t\t\n\t\t\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</tr>\n\t \n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<script>document.forms[0].ctrlChkBox.checked = true</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" align=\"center\"><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"chkbox";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onClick=\"Reassaign(this);chkunchk(this)\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ><input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'chk_value";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t<!-- Instead if encoding and sending \'diagdesc\' is passed directly modified by Archana Dhal on 10/14/2010 related to incident no IN024424. -->\n\t\t\t\t<!-- <input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'ret_value";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="~";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="|";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'> -->\n\t\t\t\t<!--  <input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'></td>-->\n\t\t\t\t<!--<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'></td>--><!-- IN33558 -->\n\t\t\t\t<!--IN067855 Start..-->\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<!--IN069327-->\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n               ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="            \n               ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<!--38981-->\n                      <input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'></td><!--38981--> \n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<!--38981-->\n\t\t\t       \t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'></td><!--38981--> \t\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n                ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\t\t\t\n                ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<!--38981-->\n                     <input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'></td><!--38981-->\t\t\t                  \n \n ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t           <td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t       \t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t\t          \t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<!--IN069327-->\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td><!--IN069327-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">&nbsp;</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="<!--IN069327-->\n\t\t\t\t\t<!--IN067855 starts-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t<!--IN067855 ends-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="<!--IN069327-->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td><!--IN069327-->\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td><!-- 38981 -->\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<script>document.forms[0].ctrlChkBox.disabled = true</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name=\"term_set_id\" id=\"term_set_id\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"includestatus\" id=\"includestatus\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"><!-- 38981 -->\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n</table>\n<!--IN061907 start-->\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t<script>\n\t\tselectall();\n\t</script>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n<!--IN061907 Ends-->\n</form>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n</body>\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

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

/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
16/11/2011    IN029542      Chowminya G      	Incident No: IN029542 -  <Dosage details in link notes option - incorrect> 
18/06/2012    IN032774      Chowminya G      	Incident No: IN032774 -  <Med Certificate show ICD-10 in English even use thai menu.> 
18/09/2012	  IN033558		Nijithas  S			Link Doc in Record Clinical Note Displays Error.
11/02/2013	  IN037164		Chowminya G			No Prompt for password for sensitive diagnosis in result link section in clinical notes
05/04/2013	  IN039182		Chowminya G			Restrict all users from result linking all diagnosis which are sensitive only �in the clinical notes
-----------------------------------------------------------------------
Date		Edit History	Name				Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
02/05/2017	IN061907		Krishna Gowtham		02/05/2017	Ramesh G		ML-MMOH-CRF-0559
21/08/2018	IN067855		Ramya Maddena  		11/10/2018	Ramesh G 		ML-MMOH-CRF-1202
30/01/2019	IN069327		Prakash C  		    30/01/2019	Ramesh G 		ML-MMOH-CRF-1281.1
15/04/2023	   38981        Krishna Pranay   16/04/2023     Ramesh G     ML-MMOH-CRF-1986
------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet Beannew= null;synchronized(session){
                Beannew=(webbeans.eCommon.RecordSet)pageContext.getAttribute("Beannew",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(Beannew==null){
                    Beannew=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("Beannew",Beannew,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	   
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    //String sel="";
	String diagtypestr="";
    String onsetdate="";
    String diagdesc="";
	String diagdesc1="";//IN067855
    String diagstage=" ";
	String diagstage1="";
    String diagcodestr="";
    String curr_remarks="";//38981
    String support_exisist_yn_yn="";//38981
    String occur_srl_no="";//38981
	String diagtypestr1 = "";
    String diagcodescheme="";
	String from_date_time_en	=	"";
	String to_date_time_en		=	"";
	String sensitive_yn ="";//IN037164
	StringBuffer strsql1 = new StringBuffer(" ");
	StringBuffer sqlwhere = new StringBuffer(" ");
	StringBuffer sqlwhere1 = new StringBuffer(" ");
	StringBuffer countsql = new StringBuffer(" ");
	StringBuffer SqlFindSensitive = new StringBuffer(" ");//IN037164
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	
	String locale = (String) p1.getProperty("LOCALE");

	String from_date_time	=	java.net.URLDecoder.decode(request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time"));
	String to_date_time		=	java.net.URLDecoder.decode(request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time"));
    String prob_status		=	java.net.URLDecoder.decode(request.getParameter("radio")==null?"":request.getParameter("radio"));
	String diagcode			=	java.net.URLDecoder.decode(request.getParameter("diagcode")==null?"":request.getParameter("diagcode"));
	String diagtype			=	java.net.URLDecoder.decode(request.getParameter("diagtype")==null?"":request.getParameter("diagtype"));
	
	String orderby1			=	java.net.URLDecoder.decode(request.getParameter("orderby1")==null?"":request.getParameter("orderby1"));
	String orderby2			=	java.net.URLDecoder.decode(request.getParameter("orderby2")==null?"":request.getParameter("orderby2"));
	String encstatus		=	java.net.URLDecoder.decode(request.getParameter("encstatus")==null?"":request.getParameter("encstatus"));
	String includestatus	=	java.net.URLDecoder.decode(request.getParameter("includestatus")==null?"":request.getParameter("includestatus"));//38981
	String patient_id		=	java.net.URLDecoder.decode(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
    String encounter_id		=	java.net.URLDecoder.decode(request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id")); 
	//String whereclause		=	java.net.URLDecoder.decode(request.getParameter("whereclause")==null?"":request.getParameter("whereclause"));
	//String whereclause1		=	java.net.URLDecoder.decode(request.getParameter("whereclause1")==null?"":request.getParameter("whereclause1"));

	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

	from_date_time_en		=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMY",locale,"en");
	to_date_time_en			=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMY",locale,"en");

	String from 		= request.getParameter("from");
	String to 			= request.getParameter("to");
	String term_set_id  = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String authorize  = request.getParameter("authorize")==null?"N":request.getParameter("authorize");//IN037164
	String rowid="";
	
	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String rslt_lnk_qry ="";//IN039182
	String rslt_lnk_sensidiag_yn ="";//IN039182
	String field_ref ="";
	String col_field ="";
	//String col_val ="";
	String call_from_link_doc_btn = request.getParameter("call_from_link_doc_btn")==null?"":request.getParameter("call_from_link_doc_btn");//IN061907
	int col_span=0;
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	PreparedStatement pstmt=null;
	ResultSet rset=null;
	
	PreparedStatement pstmt1=null;
	ResultSet rset1=null;
	
	//IN037164 - Start
	String sensitive_exist_yn="N";
	SqlFindSensitive.append("Select 'Y' from PR_DIAGNOSIS A,MR_TERM_CODE D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N') ='Y' ");
	if(encstatus.equals("Y") )
	{
		SqlFindSensitive.append(" and a.CURR_ENCOUNTER_ID = ? ");
	}
	SqlFindSensitive.append(" AND ROWNUM=1");
	boolean isSiteSpecific=false;//IN069327
	try
	{
	
	//IN039182 - Start
	try
	{
		con =  ConnectionManager.getConnection(request);
		isSiteSpecific = CommonBean.isSiteSpecific(con, "MR","ALLOW_MULTI_DESC"); //IN069327
		pstmt = con.prepareStatement(SqlFindSensitive.toString());
		pstmt.setString(1,patient_id);
		if(encstatus.equals("Y") )
		{
			pstmt.setString(2,encounter_id);
		}
		
		rs = pstmt.executeQuery();
		while(rs.next())
			sensitive_exist_yn = rs.getString(1) == null ? "N" : rs.getString(1);
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//IN037164 - End
	
		rslt_lnk_qry ="select LINK_SENST_DIAG_YN from ca_note_param ";

		pstmt1 = con.prepareStatement(rslt_lnk_qry);

		rset1 = pstmt1.executeQuery();

		while(rset1.next())
		{
			rslt_lnk_sensidiag_yn =rset1.getString("LINK_SENST_DIAG_YN")==null?"":rset1.getString("LINK_SENST_DIAG_YN");
		}
		if (rset1 != null) rset1.close();
		if (pstmt1 != null) pstmt1.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught in RecClinicalNotesLinkDiagResult.jsp,top" + e);//COMMON-ICN-0181
	}
	finally 
	{
		
		//ConnectionManager.returnConnection(con,request); //checkstyle
	}
		
	//IN039182 - End
	
	countsql.append("SELECT COUNT(*) as total FROM pr_diagnosis a, MR_TERM_CODE b, MR_TERM_SET c where a.TERM_SET_ID=b.TERM_SET_ID AND A.TERM_CODE =B.TERM_CODE and c.term_set_id=b.term_set_id ");
	
	//Modified --[IN032774]
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, a.TERM_CODE_SHORT_DESC diag_desc ,'N' sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc ,'N' sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc , sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");//Modified IN037164
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc , a.term_code_short_desc diag_desc1 ,sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");//IN067855
    strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc , a.term_code_short_desc diag_desc1 ,sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,NVL ((SELECT 'Y' FROM pr_support_diagnosis d WHERE a.patient_id = d.patient_id AND a.term_set_id = d.term_set_id AND a.term_code = d.term_code AND a.occur_srl_no = d.occur_srl_no AND ROWNUM = 1), 'N' ) support_exisist_yn_yn,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");//	38981
    
    if(encstatus.equals("Y") )
	{
		strsql1.append(" and encounter_id = a.CURR_ENCOUNTER_ID ");
	}else{
		strsql1.append(" and encounter_id = a.ONSET_ENCOUNTER_ID ");
	}
	
    
    
	//strsql1.append(" and rownum=1),'') diag_stage from pr_diagnosis a, MR_TERM_CODE b, MR_TERM_SET c where a.TERM_SET_ID=b.TERM_SET_ID AND A.TERM_CODE =B.TERM_CODE and c.term_set_id=b.term_set_id ");//In query '' is passed instead of passing as 'D' changed by Archana Dhal related to incident IN024424 on 10/14/2010.
	strsql1.append(" and rownum=1),'') diag_stage,a.curr_remarks ##SUPPORT_DIAG_DESC## from pr_diagnosis a, MR_TERM_CODE b, MR_TERM_SET c where a.TERM_SET_ID=b.TERM_SET_ID AND A.TERM_CODE =B.TERM_CODE and c.term_set_id=b.term_set_id ");//In query '' is passed instead of passing as 'D' changed by Archana Dhal related to incident IN024424 on 10/14/2010.//38981
	
	   	   
	   if(!term_set_id.equals(""))
		{
		   sqlwhere.append(" AND A.TERM_SET_ID = ? ");  
	       //sqlwhere1.append(" c.TERM_SET_ID = ? and  ");  
       }

       sqlwhere.append(" AND A.patient_id=? AND A.CURR_STATUS != 'E'");  //patient_id=?");
       //sqlwhere1.append(" patient_id=? and nvl(error_yn,'N') != 'Y'");
 
	  if (prob_status.equalsIgnoreCase("A"))
		{
		  // if(!diagtype.equals(""))
		  sqlwhere.append(" and CURR_STATUS = 'A'");
	      //sqlwhere1.append(" and problem_status != 'C'");

	    }
	  if(!diagtype.equals(""))
		{
		   sqlwhere.append(" and a.ONSET_ACCURACY_CODE = ?");
	      // sqlwhere1.append(" and DIAG_TYPE = ?");
          //sqlwhere.append(" and NVL(error_yn,'N') !='Y'");
	    }
	 

	  if((!encounter_id.equals("")) && encstatus.equals("Y") )
		{
		  sqlwhere.append(" and curr_encounter_id = ?"); //--[IN029542]
	     // sqlwhere1.append(" and onset_encounter_id = ?");
	    }
	  
        
       if(!diagcode.equals(""))
		{
		   sqlwhere.append(" AND a.TERM_CODE = nvl(?,a.TERM_CODE)");
	      // sqlwhere1.append(" AND DIAG_CODE = nvl(?,diag_code)");
	   }
	   

       if(!(from_date_time.equals("") && to_date_time.equals("")))
		{
		   sqlwhere.append(" AND ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')+.9999");
	       //sqlwhere1.append(" AND ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')");
	    }
		
		//IN037164 - Start
		sqlwhere.append(" and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N'))");
		//IN037164 - end	
		
		countsql.append(sqlwhere);	

	   if (orderby1.equals("O"))
	   {
			if(orderby2.equals("1"))
			{
					sqlwhere.append(" order by to_date(onset_date1,'dd/mm/yyyy') desc");
			}
			else
			{
					sqlwhere.append(" order by to_date(onset_date1,'dd/mm/yyyy')");
			}
	   }
	   else if (orderby1.equals("D"))
	   {
		   if(orderby2.equals("1"))
			   sqlwhere.append(" order by diag_desc desc");
		   else
			   sqlwhere.append(" order by diag_desc");
		}
	   else
		{
		   sqlwhere.append(" order by onset_date1, diag_desc");
		}
		strsql1.append(sqlwhere);	 
		
	

	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

   	try
	{
      //con =  ConnectionManager.getConnection(request);  //checkstyle
	 
	  //shaiju new diag starts
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());

		}
		else
		{
			 if (rset != null) rset.close();
			 if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(stmt != null) stmt.close();

			}
		

		}

			  
		  
	  
	  
	  //shaiju new diag ends
	  
	  stmt = con.prepareStatement(countsql.toString());
	  
	   
	    int st=0;

		//stmt.setString(++st,"ICD10");
	  if(!term_set_id.equals("")) 
      {
		 stmt.setString(++st,term_set_id);
	  }
		
		stmt.setString(++st,patient_id);
          
       if(!diagtype.equals("")) 
      {
	   stmt.setString(++st,diagtype);
	   //out.println("<script>alert('diagtype"+diagtype+"')</script>");
	  }

        if((!encounter_id.equals("")) && encstatus.equals("Y") )
		{
		stmt.setString(++st,encounter_id);
   	    //out.println("<script>alert('encounter_id"+encounter_id+"')</script>");
		}

        if(!diagcode.equals(""))
        {stmt.setString(++st,diagcode);
		//out.println("<script>alert('diagcode"+diagcode+"')</script>");
		}

        if(!(from_date_time_en.equals("") && to_date_time_en.equals(""))) 
		{
			stmt.setString(++st,from_date_time_en);
            stmt.setString(++st,to_date_time_en);
	//out.println("<script>alert('from_date_time"+from_date_time+"')</script>");
	//out.println("<script>alert('to_date_time"+to_date_time+"')</script>");
		}
		//IN037164 - Start
		if(authorize.equals("N"))
			stmt.setString(++st,"N");
		else
			stmt.setString(++st,"Y");
		//IN037164 - End
		
	   rs = stmt.executeQuery();
	
		//out.println("here 1");

	   if(rs!=null && rs.next())
		{
			maxRecord=rs.getInt("total");
		}
   //  out.println("<script>alert('maxRecord"+maxRecord+"')</script>");
	  if(rs!=null) rs.close();
	  if(stmt!=null)stmt.close();

		//out.println("<script>alert('maxRecord"+maxRecord+"')</script>");
	  if (maxRecord== 0 && sensitive_exist_yn.equals("N") && rslt_lnk_sensidiag_yn.equals("Y"))// IN037164 //modified IN039182
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			//IN061907 start
			if(call_from_link_doc_btn.equals("YES"))
			{
		
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			//IN061907 ends
		}
		else if(maxRecord== 0 && rslt_lnk_sensidiag_yn.equals("N")) //IN039182
		{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		
    
		st=0;
		  //38981 start
	String  finalQuery = strsql1.toString();
	
    if(includestatus.equals("Y") )
   	{
    	finalQuery= finalQuery.replaceAll("##SUPPORT_DIAG_DESC##", " , CA_SUPPORT_DIAG_DESC(A.patient_id,a.TERM_SET_ID,a.TERM_CODE,a.OCCUR_SRL_NO) supportDiagDesc ");
    	
   	}else{
   		finalQuery= finalQuery.replaceAll("##SUPPORT_DIAG_DESC##", " , '' supportDiagDesc ");
   	}
 
		stmt = con.prepareStatement(finalQuery);
		//38981 start
		stmt.setString(++st,locale); //--[IN032774]
		stmt.setString(++st,locale);
	
		if(!term_set_id.equals(""))
		{
			stmt.setString(++st,term_set_id);
		}
		stmt.setString(++st,patient_id);
          
        if(!diagtype.equals("")) 
		stmt.setString(++st,diagtype);

        if((!encounter_id.equals("")) && encstatus.equals("Y") )
		stmt.setString(++st,encounter_id);

        if(!diagcode.equals(""))
        stmt.setString(++st,diagcode);

        if(!(from_date_time_en.equals("") && to_date_time_en.equals(""))) 
		{
			stmt.setString(++st,from_date_time_en);
            stmt.setString(++st,to_date_time_en);
		}	
		//IN037164 - Start
		if(authorize.equals("N"))
			stmt.setString(++st,"N");
		else
			stmt.setString(++st,"Y");
		//IN037164 - End	
	
		rs = stmt.executeQuery();
		//out.println("here 2");
		
            _bw.write(_wl_block11Bytes, _wl_block11);

	
if ( !(start <= 1) )
		{
	out.println("<td width='75%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td class='CAGROUP'  width='10%' >");
	out.println("<A class= 'gridLink' HREF='../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp?from="+(start-14)+"&to="+(end-14)+"&patient_id="+patient_id+"&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&term_set_id="+term_set_id+"&diagtype="+diagtype+"&encounter_id="+encounter_id+"&diagcode="+diagcode+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&encstatus="+encstatus+"&authorize="+authorize+"&orderby1="+orderby1+"&orderby2="+orderby2+"&whereclause="+URLEncoder.encode(sqlwhere.toString())+"&whereclause1="+URLEncoder.encode(sqlwhere1.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
     else
		{
out.println("<td width='75%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td  class='CAGROUP' width='10%' >");
		}
//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A  class= 'gridLink' HREF='../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp?from="+(start+14)+"&to="+(end+14)+"&patient_id="+patient_id+"&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&term_set_id="+term_set_id+"&diagtype="+diagtype+"&encounter_id="+encounter_id+"&diagcode="+diagcode+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&encstatus="+encstatus+"&authorize="+authorize+"&orderby1="+orderby1+"&orderby2="+orderby2+"&whereclause="+URLEncoder.encode(sqlwhere.toString())+"&whereclause1="+URLEncoder.encode(sqlwhere1.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);
 //IN037164 - Start
	if (sensitive_exist_yn.equals("Y") && rslt_lnk_sensidiag_yn.equals("Y") ) //IN039182
	{
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diagtype));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(from_date_time_en));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encstatus));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(prob_status));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(result_linked_rec_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderby1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderby2));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
	
	}//IN037164 - End
	
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	if(fields.size()>0)
	{
		col_span = fields.size();
		for(int l=0;l<fields.size();++l)
		{
			 col_field = (String)fields.get(l);
			 
			 if(col_field.equals("ACCURACY"))
					{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					}
					else if(col_field.equals("ONSET DATE"))
					{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					}
					else if(col_field.equals("DESCRIPTION"))
					{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					}
					else if(col_field.equals("STAGE"))
					{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					}
					else if(col_field.equals("CODE"))
					{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					}
					else if(col_field.equals("SCHEME"))
					{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					}
					else if(col_field.equals("DIAGNOSIS REMARKS"))//38981 start
					{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					}//38981 end
					
		   }
		//   38981 start
		 if(includestatus !=null && includestatus.equals("Y")){ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
} 		//   38981 end
		}
	else
	{
	
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

	}
	
            _bw.write(_wl_block27Bytes, _wl_block27);
 
		String onset_date1_th	="";
	if ( start != 1 )
		{
		    for( int j=1; j<start; i++,j++ )
	           {
	             rs.next() ;
	           }
		}

		String classValue="";
		//String classValue="gridData";//IN037164
		int p=0; 
	
	 while(rs!=null && rs.next() && i<=end)
		{
		 		 
		 diagtypestr=rs.getString("DIAG_TYPE")==null?" ":rs.getString("DIAG_TYPE");
		 diagtypestr1=rs.getString("DIAG_TYPE")==null?" ":rs.getString("DIAG_TYPE");
		 String supportDiagDesc=rs.getString("supportDiagDesc")==null?" ":rs.getString("supportDiagDesc");//38981
		 rowid=rs.getString("row_id");
		 rowid = rowid.replace('+','$');
		 onsetdate		=	rs.getString("onset_date1")==null?" ":rs.getString("onset_date1");
		 onset_date1_th	=	com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);
		 diagdesc=rs.getString("diag_desc")==null?" ":rs.getString("diag_desc");
		 diagdesc1=rs.getString("diag_desc1")==null?" ":rs.getString("diag_desc1");//IN067855
		 //diagstage=rs.getString("diag_stage")==null?" ":rs.getString("diag_stage");
		 diagstage1=rs.getString("diag_stage")==null?" ":rs.getString("diag_stage");
		 diagcodestr=rs.getString("diag_code")==null?" ":rs.getString("diag_code");
		 diagcodescheme=rs.getString("scheme")==null?" ":rs.getString("scheme");
		 occur_srl_no =rs.getString("srl_no")==null?" ":rs.getString("srl_no");// 38981 
		 curr_remarks=rs.getString("curr_remarks")==null?" ":rs.getString("curr_remarks");// 38981 
		 support_exisist_yn_yn = rs.getString("support_exisist_yn_yn")==null?"":rs.getString("support_exisist_yn_yn"); //38981
		 if(curr_remarks.length()>200){
			 curr_remarks=curr_remarks.substring(0,200)+"...";
		 }
		 diagstage = rs.getString("diag_stage");
		 sensitive_yn = rs.getString("sensitive_yn");//IN037164
		 //IN037164 - Start
		if(sensitive_yn.equals("Y"))
				classValue="gridRed";
			else
				classValue="gridData";
		//IN037164 - end
		 if(diagstage == null || diagstage.equals("null") || diagstage.equals(""))diagstage="&nbsp";
		 
		 
		 if(diagtypestr1.equals("P"))
			diagtypestr= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
		 else if(diagtypestr1.equals("D"))
			diagtypestr= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
		 else if(diagtypestr1.equals("F"))
			diagtypestr= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
		 
		 if(diagstage1.equals("A"))
			diagstage= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
		 else if(diagstage1.equals("I"))
			diagstage= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
		 else if(diagstage1.equals("D"))
			diagstage= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");	 
		 
		 /*if ( i % 2 == 0 )
			 classValue = "QRYEVEN" ;
		 else
		  	classValue = "QRYODD" ;*/
	  
		
	    
		String beankey="";		
		String checkstatus="";		
         

		for(int m=0;m<Beannew.getSize();m+=2)
				{
					beankey=Beannew.getObject(m).toString();

  					if(rowid.equalsIgnoreCase(beankey))
					//if((java.net.URLDecoder.decode(rowid)).equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					beankey="";
                   

				}
				 
				 //out.println("<script>alert('p"+p+"')</script>");
                  if(p == maxRecord || p== 14)
					{
					
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(k));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(k));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(diagtypestr));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagdesc)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagstage));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagcodestr));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagcodescheme));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(diagtypestr));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagdesc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagstage));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagcodestr));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagcodescheme));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(k));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(rowid)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagtypestr)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(onsetdate)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagdesc)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagstage)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodestr)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodescheme)));
            _bw.write(_wl_block44Bytes, _wl_block44);
if(!isSiteSpecific){
            _bw.write(_wl_block45Bytes, _wl_block45);
if("*OTH".equals(diagcodestr)){
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block47Bytes, _wl_block47);
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(k));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(rowid,"UTF-8")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagtypestr,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(onsetdate,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagdesc1,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagstage,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodestr,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodescheme,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(curr_remarks,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(support_exisist_yn_yn,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(supportDiagDesc,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(k));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(rowid,"UTF-8")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagtypestr,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(onsetdate,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagdesc,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagstage,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodestr,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodescheme,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(curr_remarks,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(support_exisist_yn_yn,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(supportDiagDesc,"UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
}
			}else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            _bw.write(_wl_block53Bytes, _wl_block53);
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(rowid,"UTF-8")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagtypestr,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(onsetdate,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagdesc1,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagstage,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodestr,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagcodescheme,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(curr_remarks,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(support_exisist_yn_yn,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(supportDiagDesc,"UTF-8")));
            _bw.write(_wl_block55Bytes, _wl_block55);
}	
				if(fields.size()>0)
				{
					col_span = fields.size();
					
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);
						
						if(col_field.equals("ACCURACY"))
						{
						
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagtypestr1));
            _bw.write(_wl_block58Bytes, _wl_block58);

						}
						else if(col_field.equals("ONSET DATE"))
						{
						
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(onset_date1_th));
            _bw.write(_wl_block60Bytes, _wl_block60);

						}
						//IN067855 starts
						else if(col_field.equals("DESCRIPTION"))
						{	
							if(!isSiteSpecific){//IN069327
								 if("*OTH".equals(diagcodestr)){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagdesc1));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagdesc));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
							}else{
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagdesc1));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
				
						}
						//IN067855  ends
						else if(col_field.equals("STAGE"))
						{
						
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagstage));
            _bw.write(_wl_block60Bytes, _wl_block60);

						}
						else if(col_field.equals("CODE"))
						{
						
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagcodestr));
            _bw.write(_wl_block60Bytes, _wl_block60);

						}
						else if(col_field.equals("SCHEME"))
						{
						
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagcodescheme));
            _bw.write(_wl_block60Bytes, _wl_block60);

						}
						else if(col_field.equals("DIAGNOSIS REMARKS"))//38981 start
						{
						
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(curr_remarks));
            _bw.write(_wl_block60Bytes, _wl_block60);

						}//38981 end
                  }
					//38981 start
					if(includestatus !=null && includestatus.equals("Y")){
						if(support_exisist_yn_yn.equals("Y")){
						
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(supportDiagDesc));
            _bw.write(_wl_block66Bytes, _wl_block66);

						}else{
						
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block67Bytes, _wl_block67);
	
						}
					
			    	}
				//38981 end
				}
				else
				{
				
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagtypestr1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(onset_date1_th));
            _bw.write(_wl_block70Bytes, _wl_block70);
if(!isSiteSpecific){
            _bw.write(_wl_block71Bytes, _wl_block71);
if("*OTH".equals(diagcodestr)){
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagdesc1));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagdesc));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
				}else{
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagdesc1));
            _bw.write(_wl_block74Bytes, _wl_block74);
}//IN069327
			
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagstage));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagcodestr));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagcodescheme));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(curr_remarks));
            _bw.write(_wl_block75Bytes, _wl_block75);

				}
			
            _bw.write(_wl_block76Bytes, _wl_block76);

				
				i++;
				k++;
			}

		if(maxRecord == 0)
					{
						call_from_link_doc_btn = "NO";//IN061907
					
            _bw.write(_wl_block77Bytes, _wl_block77);
}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		
	
	
	
	
}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagResult.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	//ConnectionManager.returnConnection(con,request); //checkstyle
}


            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(k));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(includestatus));
            _bw.write(_wl_block82Bytes, _wl_block82);

if(call_from_link_doc_btn.equals("YES"))
{

            _bw.write(_wl_block83Bytes, _wl_block83);

}

            _bw.write(_wl_block84Bytes, _wl_block84);
}
catch(Exception m)
{
	m.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagResult.jsp" + m);//COMMON-ICN-0181
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block85Bytes, _wl_block85);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sensitive.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stage.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SupportingDiag.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stage.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }
}
