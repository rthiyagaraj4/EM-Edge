package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dtissuefileoutstandingdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTIssueFileOutstandingDetail.jsp", 1709116819232L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eFM/js/FMIssueFilesDoc.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'IssueOutstandingDetail\' id=\'IssueOutstandingDetail\' method=\'post\' target=\'messageFrame\' action=\'../../eFM/jsp/FMIssueFilesUpdateBean.jsp\'>\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr><td colspan=\'8\' class=\'label\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td></tr>\n\t\n\t<th width=\'41%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t<th width=\'5%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t<th width=\'12%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t<th width=\'22%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t<th width=\'10%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="?</th>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t   <td class=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><font size=\'1\'><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </b></font> <br>&nbsp;&nbsp; <font size=\'1\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </font></td>\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ><font size=\'1\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =",<BR><A HREF CLASS=\"label\" onMouseover=\"changeCursor(this)\" onClick=\"showEncounter(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;</A></font></td>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </b></font><br>&nbsp;<font size=\'1\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;</A></font></td>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\t\t\t\t<td class=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="><font size=\'1\'> ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font></td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="><font size=\'1\'>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t   <a href=\'javascript:GetShowRemarks(\"ReqComm";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\",\"R\")\'>Remarks</a></font></td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><font size=\'1\'> ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<br>&nbsp; (";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =")</font></td>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onMouseOver=\"displayToolTipDataChange(\'DATACHANGE\',\'Document Issued on<br> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\" onMouseOut=\"disasbleToolTipDataChange(\'DATACHANGE\');\"><font size=\'1\'> ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =")</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t   <td id=\'remarks";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' class=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" ><font size=\'1\'>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t   <a href=\'javascript:GetShowRemarks(\"txtComm";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\",\"I\")\'>Remarks</a>\n\t\t\t\t   </font></td>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<input type=\'checkbox\' name=\"chk";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"chk";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' onClick=\"setVal(this,";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =");\">\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t</td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\t\t\t\t<input type=\'hidden\' name=\"select";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"select";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" value=\"Y\">\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\"select";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" value=\"N\">\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\t\t</tr>\n\t\t\t<input type=\"hidden\" name=\'fileno";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'fileno";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t<input type=\"hidden\" name=\'file_type";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'file_type";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t<input type=\"hidden\" name=\'volume_no";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'volume_no";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t<input type=\"hidden\" name=\'patient";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'patient";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t\t<input type=\"hidden\" name=\'pline";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'pline";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t<input type=\"hidden\" name=\'filestatus";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'filestatus";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t\t<input type=\"hidden\" name=\'currlocn";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'currlocn";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t\t<input type=\"hidden\" name=\'currlocndesc";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'currlocndesc";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t<input type=\"hidden\" name=\'currlocniden";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'currlocniden";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t<input type=\"hidden\" name=\'currmrlocnyn";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'currmrlocnyn";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n \t\t\t<input type=\"hidden\" name=\'currfacility";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'currfacility";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t\t<input type=\"hidden\" name=\'txtComm";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'txtComm";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t\t<input type=\"hidden\" name=\'ReqComm";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'ReqComm";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n</table>\n<input type=\'hidden\' name=\'ManualReq\' id=\'ManualReq\' value=\'N\'>\n<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n<input type=\'hidden\' name=\'iss_count\' id=\'iss_count\' value=\'\'>\n<input type=\'hidden\' name=\'Req_on\' id=\'Req_on\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'Req_no\' id=\'Req_no\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\'hidden\' name=\'Req_fac_id\' id=\'Req_fac_id\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\'hidden\' name=\'Req_fac_name\' id=\'Req_fac_name\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n<input type=\'hidden\' name=\'Req_locn_code\' id=\'Req_locn_code\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n<input type=\'hidden\' name=\'Req_locn_desc\' id=\'Req_locn_desc\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n<input type=\'hidden\' name=\'Req_locn_identity\' id=\'Req_locn_identity\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n<input type=\'hidden\' name=\'Req_locn_mrlocn_yn\' id=\'Req_locn_mrlocn_yn\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n<input type=\'hidden\' name=\'Req_by\' id=\'Req_by\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n<input type=\'hidden\' name=\'Req_by_name\' id=\'Req_by_name\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n<input type=\'hidden\' name=\'Narration_code\' id=\'Narration_code\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n<input type=\'hidden\' name=\'Narration_desc\' id=\'Narration_desc\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n<input type=\'hidden\' name=\'No_Of_Days\' id=\'No_Of_Days\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n<input type=\'hidden\' name=\'Issue_user_id\' id=\'Issue_user_id\' value=\'\'>\n<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n</table>\n</div>\t\n\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            webbeans.eFM.FMFilesIssueCart FMIssueFilesCart= null;synchronized(session){
                FMIssueFilesCart=(webbeans.eFM.FMFilesIssueCart)pageContext.getAttribute("FMIssueFilesCart",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFilesCart==null){
                    FMIssueFilesCart=new webbeans.eFM.FMFilesIssueCart();
                    pageContext.setAttribute("FMIssueFilesCart",FMIssueFilesCart,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection conn = null;
		java.sql.Statement stmt=null;
		PreparedStatement pstmt	 = null;
		PreparedStatement pstmt1=null;		
		ResultSet rs=null;
		ResultSet rs1=null;
		String resLocnIdentities = request.getParameter("resLocnIdentities");
		String ReqOn			= request.getParameter("ReqOn");
		String Reqno			= request.getParameter("Reqno");
		String Reqfacilityid	= request.getParameter("Reqfacilityid");
		String Reqfacilityname	= request.getParameter("Reqfacilityname");
		String Reqfslocncode	= request.getParameter("Reqfslocncode");
		String Reqfslocndesc	= request.getParameter("Reqfslocndesc");
		String Reqfslocnidentity= request.getParameter("Reqfslocnidentity");
		String Reqlocnismrlocnyn= request.getParameter("Reqlocnismrlocnyn");
		String Reqby			= request.getParameter("Reqby");
		String Reqbyname		= request.getParameter("Reqbyname");
		String Narrationcode	= request.getParameter("Narrationcode");
		String Narrationdesc	= request.getParameter("Narrationdesc");
		String NoOfdays			= request.getParameter("NoOfdays");	
		String issueLocn		= request.getParameter("issueLocn");
		String s_file_no		= request.getParameter("s_file_no");
		String s_file_type		= request.getParameter("s_file_type");
		String s_volume_no		= request.getParameter("s_volume_no");
		String facility_id = (String) session.getValue("facility_id");	
		
		String sql1 = "";
		String classValue = "";
		String classVal = "mediumaquamarine";
		String checkValue = "checked";
		String checkStatus = "";
		String chkVal = "Y";
		String Remarks = "Remarks";
		String req_remarks = "";
		String volume_no	=	"";
		String file_type	=	"";
		String file_type_appl_yn	=	"N";
		String doc_folder_id = "";
		String doc_folder_name = "";
		String doc_type_name = "";
		String doc_type = "";

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		int i=1;
		int temp = 1;
		int Other_rec_count = 0;
		boolean file_exist = false,p_same_file_no_exist=false;
try
{
		conn = ConnectionManager.getConnection(request);
		s_file_type	=	((s_file_type == null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_volume_no	=	((s_volume_no == null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

		if(resLocnIdentities == null || resLocnIdentities.equals("null"))
			resLocnIdentities = "N";

	//	String InvalidFiles = "&nbsp;";

		stmt = conn.createStatement();
		rs	 = stmt.executeQuery("SELECT file_type_appl_yn FROM mp_param ");
		if ((rs!=null) &&(rs.next()))
	{
			file_type_appl_yn = rs.getString("file_type_appl_yn");
	}
	if(rs!=null) rs.close();

		if ((file_type_appl_yn==null) || (file_type_appl_yn.equals("")) || (file_type_appl_yn.equals("null")))
			file_type_appl_yn = "N";

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Reqno));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);


		SelectSqlBuffer.append( "Select A.FILE_NO, D.CURR_FILE_STATUS, DECODE(D.CURR_FILE_STATUS,'A','Archive','T','In  Transit','I','Inside','O','Outside','L','Lost','E','Other Facility', 'R', 'Returned') FILE_STATUS, A.CURR_FS_LOCN_CODE, B.SHORT_DESC CURR_FS_LOCN_DESC, A.REQ_TO_FS_LOCN_CODE, B.LOCN_IDENTITY, DECODE(B.LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDEN_DESC, NVL(B.MR_LOCN_YN,'N') CURR_MR_LOCN_YN, A.PATIENT_ID, get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE, D.REMARKS, ltrim(rtrim(A.REMARKS)) REQ_REMARKS,TO_CHAR(D.ISS_DATE_TIME,'DD/MM/YYYY HH:MI AM')ISS_DATE_TIME, A.VOLUME_NO, a.file_type_code, e.short_desc file_type,d.doc_folder_id,d.doc_type_code,f.DOC_FOLDER_NAME,g.DOC_TYPE_NAME,(CASE WHEN f.PATIENT_PERIOD_SPECIFIC='D' THEN ' ,' || TO_CHAR(f.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(f.to_period,'dd/mm/rrrr ')  ELSE ' ' || get_patient_line(f.patient_id) END)doc_type,H.encounter_id from FM_REQ_DTL A,  FM_STORAGE_LOCN B, FM_CURR_LOCN D, mr_file_type e,fm_doc_folder f, fm_doc_type g, FM_ENCOUNTER_DOC_TYPE_LINK H Where A.REQ_NO = '"+Reqno+"' AND A.ISS_YN = 'N' AND A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+issueLocn+"' AND A.REQ_TO_FACILITY_ID = B.FACILITY_ID AND A.CURR_FS_LOCN_CODE = B.FS_LOCN_CODE  AND A.FILE_NO = D.FILE_NO (+) AND A.VOLUME_NO = D.VOLUME_NO  AND A.CURR_FACILITY_ID = D.CURR_FACILITY_ID (+) AND NVL(A.CANCEL_YN,'N')='N' AND d.file_type_code = e.file_type_code (+) AND d.facility_id = e.facility_id(+) AND d.doc_type_code = g.doc_type_code(+) and d.doc_folder_id = f.doc_folder_id AND d.facility_id = f.facility_id AND a.file_no=H.file_no and a.REQ_TO_FACILITY_ID = H.facility_id ");
		
		if (!(s_file_no.equals("null") || s_file_no.equals("") ))
		SelectSqlBuffer.append("AND A.FILE_NO = '"+s_file_no+"' ");

		if (!(s_volume_no.equals("null") || s_volume_no.equals("") ))
		SelectSqlBuffer.append("AND A.VOLUME_NO = '"+s_volume_no+"' ");
		
		SelectSqlBuffer.append(" order by A.FILE_NO");		
		
		pstmt = conn.prepareStatement(SelectSqlBuffer.toString());
		rs	  = pstmt.executeQuery();
		if(rs != null)
		{
			while ( rs.next() )
			{
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

					String cuurIden = rs.getString("LOCN_IDENTITY");
					if(cuurIden == null || cuurIden.equals("null")){
					cuurIden="";}
					String currStatus = rs.getString("CURR_FILE_STATUS");
					if(currStatus == null || currStatus.equals("null")){
					currStatus="";}					
					String currLocn = rs.getString("CURR_FS_LOCN_CODE");
					if(currLocn == null || currLocn.equals("null")){
					currLocn="";}
					String permLocn = rs.getString("REQ_TO_FS_LOCN_CODE");
					if(permLocn == null || permLocn.equals("null")){
					permLocn="";}
					req_remarks		= rs.getString("REQ_REMARKS");
					if(req_remarks == null || req_remarks.equals("null")){
					req_remarks="";
					}
					String encounter_id = rs.getString("encounter_id");
					if(encounter_id == null || encounter_id.equals("null")){
					encounter_id="";}
					volume_no	=	rs.getString("volume_no");
					file_type	=	rs.getString("file_type");

					if ((file_type == null) || (file_type.equals("null")))
						file_type	=	"&nbsp;";
					else file_type = file_type + " / ";
					if ((volume_no == null) || (volume_no.equals("null")))
						volume_no	=	"&nbsp;";
					doc_folder_id	=	rs.getString("doc_folder_id");

					if ((doc_folder_id == null) || (doc_folder_id.equals("null")))
						doc_folder_id	=	"&nbsp;";
					doc_folder_name	=	rs.getString("doc_folder_name");
					if ((doc_folder_name == null) || (doc_folder_name.equals("null")))
						doc_folder_name	=	"&nbsp;";
					doc_type_name	=	rs.getString("doc_type_name");
					if ((doc_type_name == null) || (doc_type_name.equals("null")))
						doc_type_name	=	"&nbsp;";
					doc_type	=	rs.getString("doc_type");
					if ((doc_type == null) || (doc_type.equals("null")))
						doc_type	=	"&nbsp;";
				
				if(currStatus.equals("I") && currLocn.equals(permLocn))
				{
						temp = 1;
						checkValue = "checked";
						checkStatus = "";
						chkVal = "Y";
						Remarks = "Remarks";
				}
				else
				{
						temp = 1;
						checkValue = "unchecked";
						checkStatus = "disabled";
						chkVal = "N";
				}
				
				file_exist = FMIssueFilesCart.FileNoExist(Reqno,rs.getString("FILE_NO"), s_volume_no);
				if(file_exist)
				{
					checkValue = "checked";
					checkStatus = "disabled";
					chkVal = "Y";
				}

				if (!file_exist)
				{
					p_same_file_no_exist = FMIssueFilesCart.SameFileNoExist(rs.getString("FILE_NO"));
					
					if (p_same_file_no_exist)
					{
						checkValue = "";
						checkStatus = "disabled";
						chkVal = "N";
					}
				}
				String FileNoValue = rs.getString("file_no");
				if(FileNoValue == null || FileNoValue.equals("null")) FileNoValue = "";

				sql1 = "select count(*) from fm_encounter_volume_link a,pr_encounter b where a.facility_id= ? and a.file_no= ? and b.facility_id=a.facility_id and  b.encounter_id=a.encounter_id and volume_no= ? and closed_date is null and b.mlc_yn='Y'";
						
						pstmt1 = conn.prepareStatement(sql1);
						pstmt1.setString(1,facility_id);
						pstmt1.setString(2,FileNoValue);
						pstmt1.setString(3,volume_no);
						rs1  = pstmt1.executeQuery();
				if ((rs1!=null) &&(rs1.next()))
				{					
					Other_rec_count = rs1.getInt(1);					
				}
				if(rs1!=null) rs1.close();
				if(pstmt1!=null) pstmt1.close();

            _bw.write(_wl_block16Bytes, _wl_block16);

					String tempstr = rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
					StringTokenizer st = new StringTokenizer(tempstr, ",");
					st.nextToken();
					st.nextToken();
					st.nextToken();
					//String patient_id = st.nextToken();
				if (file_type_appl_yn.equals("N"))	
				{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(doc_folder_name));
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(doc_type_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("FILE_NO")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}else if (file_type_appl_yn.equals("Y"))	
				{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_folder_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(doc_type_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("FILE_NO")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rs.getString("FILE_STATUS")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);

					if (req_remarks==null)
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>");
				   else
				{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(req_remarks));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}

            _bw.write(_wl_block1Bytes, _wl_block1);

				if ((rs.getString("ISS_DATE_TIME")==null) || (rs.getString("ISS_DATE_TIME").equals("")))
				{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs.getString("CURR_FS_LOCN_DESC")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs.getString("LOCN_IDEN_DESC")));
            _bw.write(_wl_block38Bytes, _wl_block38);
				}
				else
				{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs.getString("ISS_DATE_TIME")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rs.getString("CURR_FS_LOCN_DESC")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs.getString("LOCN_IDEN_DESC")));
            _bw.write(_wl_block41Bytes, _wl_block41);

				}
			    
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);

				if(checkStatus.equals("disabled"))
				{
					out.println("Remarks</font></td>");
				}
				else
				{
				   String RemarksValue  = rs.getString("REMARKS");


            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(RemarksValue));
            _bw.write(_wl_block46Bytes, _wl_block46);

				}

// cyan, magenta, sandybrown, mediumvioletred, mediumaquamarine, orchid,
// mediumorchid,  violet, yellowgreen, darkseagreen, gold, lightseagreen
// mediumaquamarine, gold, lightseagreen, sandybrown

				if(temp == 2)
				{
					out.println("<td align='center' id='chbox"+i+"' class='"+classValue+"'>");
					
				}
				else if(file_exist)
				{
					out.println("<td align='center' style='background-color:"+classVal+"'>");
					
				}
				else
				{						
					out.println("<td align='center' id='chbox"+i+"' class='"+classValue+"'>");					
				}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(checkStatus));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(chkVal));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
					
					if(Other_rec_count > 0)
					{
						out.println("&nbsp;<img src='../../eFM/images/stop.gif' align='center'></img>");
					}

            _bw.write(_wl_block53Bytes, _wl_block53);

					if(checkValue.equals("checked"))
					{

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
					}
					else
					{

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
					}

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("FILE_NO")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("FILE_TYPE_CODE")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("VOLUME_NO")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6)));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("FILE_STATUS")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("CURR_FS_LOCN_CODE")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("CURR_FS_LOCN_DESC")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("LOCN_IDENTITY")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("CURR_MR_LOCN_YN")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
			i++;
			}
		}
	if(rs!=null)	rs.close();
	if(rs1!=null)	rs1.close();	
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();		
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(ReqOn));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(Reqno));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Reqfacilityid));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(Reqfacilityname));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(Reqfslocncode));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(Reqfslocndesc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(Reqfslocnidentity));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(Reqlocnismrlocnyn));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(Reqby));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(Reqbyname));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(Narrationcode));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(Narrationdesc));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(NoOfdays));
            _bw.write(_wl_block101Bytes, _wl_block101);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentsRequestedin.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentdetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentStatus.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.RequestRemarks.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSLocation.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueRemarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Issue.label", java.lang.String .class,"key"));
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
}
