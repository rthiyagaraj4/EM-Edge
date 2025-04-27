package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;
import java.sql.Date;
import java.math.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __queryfmfilenotreturnedtomrdsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryFMFileNotReturnedToMRDSearchResult.jsp", 1726469397199L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Developed By      :   Prashant Bhalsingh\n     Created on        :    21/06/2001\n     Module Name       :    FM\\File Not returned to MRD\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n   <!--  <LINK rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n    <SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n    <SCRIPT src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/QueryFMFileNotReturnedToMRD.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<HEAD>\n<BODY OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\' >\n\t<FORM name=\"QueryFMSearchResult\" id=\"QueryFMSearchResult\" action=\"../../eFM/jsp/QueryFMFileNotReturnedToMRDSearchResult.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\n            <TABLE cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n\t\t\t\t<TR>\n\t\t\t\t<TD align=\'right\' >\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<A href=\'javascript:getNext(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =")\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TABLE>\n<!--Added for ML-MMOH-SCF-0588 on 7th Mar 2017 Start-->\n<TABLE border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t  <TR><Td colspan=\"7\" class=\'columnheader\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</Td></TR>\n\t  <TR><TD></TD></TR>\n\t  <TR>\n\t  <Th class=\'columnheader\' width=\"38%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</Th> \n\t  <Th class=\'columnheader\' width=\"12%\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</Th>\n      <Th class=\'columnheader\' width=\"10%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</Th>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t  <TR><Th colspan=\"7\" class=\'columnheader\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</Th></TR>\n\t  <TR><TD></TD></TR>\n\t  <TR>\n ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n      <Th class=\'columnheader\' width=\"38%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</Th>\n ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n      <Th width=\"38%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t  <Th class=\'columnheader\' width=\"12%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t  <Th class=\'columnheader\' width=\"10%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</Th>\n\t  <!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->\n      <Th class=\'columnheader\' width=\"10%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</Th>\n\t  <Th class=\'columnheader\' width=\"10%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</Th> \n    </TR>\n</TABLE>\n<!--End-->\n\t\t        <TABLE border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'cenetr\' width=\"100%\">\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<TR> \n\t\t\t\t\t\t\t<TD  width=\"100%\"  colspan=\'7\' class=\'CAGROUPHEADING\' ><B>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</B></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<TR><TD colspan=\'7\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'><FONT size=1><B>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</B></FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD  width=\"100%\"  colspan=\'7\' class=\'CAGROUPHEADING\'  ><B>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</B></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t    <TR>\n\t\t\t\t       <TD  width=\"38%\" class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' ><FONT size=1>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</FONT></TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<TD  width=\"12%\" class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' nowrap><CENTER><FONT size=1>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t</FONT></CENTER>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD  width=\"10%\" class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><FONT size=1>\n           \t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</FONT></TD>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t        <TD  width=\"10%\" class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><FONT size=1>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\n\t\t\t\t\t      <TD  width=\"10%\" class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' style=\'background-color:";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'><FONT size=1>\n\t\t\t\t\t       ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</FONT>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t <TD  width=\"10%\" class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n\t\t\t\t\t\t  <TD  width=\"10%\" class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'><FONT size=1>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\n\t\t\t\t\t\t  <TD  width=\"10%\" class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'><FONT size=1>\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t  \n\t\t\t\t\t\t  </FONT>\n\t\t\t\t\t\t \n\t\t\t\t\t\t  </TD>  \n\t\t\t\t\t</TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<TR><TD colspan=\'7\' class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</B></FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<SCRIPT>\n\t\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\';\n\t\t\t\t\tvar p_criteria = \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\';\n\t\t\t\t\tif (p_criteria==\'all\')\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\'FILE_STORAGE_NOT_BLANK\',\'FM\'));\n\t\t\t\t\t}\n\t\t\t\t\telse if (parseInt(p_rec_cnt)==0)\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\t}\n\t\t\t\t</SCRIPT>\n\t\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t </TABLE>\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t<SCRIPT>\n\t\tparent.frames[1].document.forms[0].search.disabled=false;\n\t</SCRIPT>\n\t<INPUT type=\'hidden\' name=\'doc_or_file\' id=\'doc_or_file\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'><!--Added by Thamizh selvi on 7th Mar 2017 for ML-MMOH-SCF-0588-->\n\t<INPUT type=\'hidden\' name=\'previousRecord\' id=\'previousRecord\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t<INPUT type=\'hidden\' name=\'nextRecord\' id=\'nextRecord\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>   \n\t<INPUT type=\'hidden\' name=\'flag\' id=\'flag\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' >\n\t<INPUT type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>  \n\t<INPUT type=\'hidden\' name=\'noOfRecords\' id=\'noOfRecords\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>     \n\t<INPUT type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t<INPUT type=\'hidden\' name=\'fs_locn_id\' id=\'fs_locn_id\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t<INPUT type=\'hidden\' name=\'from_search\' id=\'from_search\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t<INPUT type=\'hidden\' name=\'out_criteria\' id=\'out_criteria\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t<INPUT type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n    <INPUT type=\'hidden\' name=\'out_facility_id\' id=\'out_facility_id\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

   request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
        Connection con				= ConnectionManager.getConnection(request);
       	java.sql.Statement mystmt	= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;
		PreparedStatement pstmt2	= null;
		PreparedStatement pstmt3	= null;
		PreparedStatement pstmt4	= null;
		PreparedStatement pstmt5	= null;
        ResultSet rset				= null;
       	ResultSet rset1				= null;
		ResultSet rset2				= null;
			
       // java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;

        String discharge_date_time = "";
       String discharge_date_time1="";
		//int	nextRecord = (request.getParameter("nextRecord")==null)? 0 : Integer.parseInt(request.getParameter("nextRecord"));
        
//        int	previousRecord = (request.getParameter("previousRecord")==null)? 0 : Integer.parseInt(request.getParameter("previousRecord"));        
       
        String sql               = "";  
      //  String sql0              = "";  
        String sql1              = "";  
        String sql11             = ""; 
		String sql2				 = "";        
        String file_type_appl_yn = "";  
        String classValue        = "";
		String req_start		 = "", req_end = "";
        String patient_id="";
		String curr_locn_id="";
		String iss_date_time = "";
		String return_date_time = "";
		String nia_return_date = "";
       	StringBuffer sqlCriteria	= null;
		sqlCriteria					= new StringBuffer();

        String from_search		= request.getParameter("from_search");
		String from				= request.getParameter("from");
		String to				= request.getParameter("to");
		String queryCriteria    = request.getParameter("criteria");
        String flag             = request.getParameter("flag");
        String facility_id      = request.getParameter("facility_id");
        String out_facility_id	= request.getParameter("out_facility_id");
		String out_criteria		= request.getParameter("out_criteria");
		//out.println("out_criteria==="+out_criteria);
		String fs_locn_id		= request.getParameter("fs_locn_id");
		file_type_appl_yn		= request.getParameter("file_type_appl_yn");
		String doc_or_file				= request.getParameter("doc_or_file");//Added on 7th Mar 2017 for ML-MMOH-SCF-0588
       	int parameter_hours = 0;	
		if(out_facility_id == null || out_facility_id.equals("null")) out_facility_id = "";
		if(out_criteria == null || out_criteria.equals("null")) out_criteria = "";
		if(queryCriteria == null || queryCriteria.equals("null")) queryCriteria = "";
		if(fs_locn_id == null || fs_locn_id.equals("null")) fs_locn_id = "";
		if(facility_id == null || facility_id.equals("null")) facility_id = "";
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
		if(doc_or_file == null || doc_or_file.equals("null")) doc_or_file = "";//Added on 7th Mar 2017 for ML-MMOH-SCF-0588
		
		int counter             = 0;
        int fromRecordNumber    = 0;
        int toRecordNumber      = 0;
        int noOfRecords         = 0; 
		double diffhrs=0.00; 
		int maxRecord	= 0;
	    int start		= 0;
		int end			= 0;
	    int i			= 1;
		
		if (from == null){ start = 0; } else { start = Integer.parseInt(from); }
	    if (to == null){ end = 5; } else { end = Integer.parseInt(to); }

		req_start  = (request.getParameter("start") == null) ? "0" : request.getParameter("start");
		req_end    = (request.getParameter("end") == null)   ? "0" : request.getParameter("end");

        if(from_search == null)from_search = "";
		
		try
		{
			if(from_search.equals("Y"))
		    {
				if(!out_facility_id.equals(""))
					sqlCriteria.append( " AND  a.curr_facility_id = '"+out_facility_id+"' ");
				if(!out_criteria.equals(""))
					sqlCriteria.append(" AND  a.curr_fs_locn_code = '"+out_criteria+"' ");
				if(!queryCriteria.equals(""))
					sqlCriteria.append(" AND  a.PERM_FS_LOCN_CODE = '"+queryCriteria+"' ");
				if(!fs_locn_id.equals(""))
					sqlCriteria.append(" AND  a.curr_fs_locn_identity = '"+fs_locn_id+"' ");
			}
			else
			{
				if(!queryCriteria.equals(""))            
					sqlCriteria.append(" AND  a.PERM_FS_LOCN_CODE='" + queryCriteria + "' " );
			}
			
			i = 1;

           	mystmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//sql	= "SELECT a.file_no,a.file_type_desc,a.volume_no,get_patient_line(a.patient_id,'"+localeName+"') patient_line,a.curr_fs_locn_code,a.curr_fs_locn_short_desc,DECODE(a.curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing unit','X','External', 'E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity,DECODE(A.CURR_FILE_STATUS,'R','Returned', 'I','Inside','O','Outside','L','Lost','T','InTransit','A','Archived','E','Other Facility')curr_file_status,TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time,TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time,(CASE WHEN sysdate > return_date_time THEN 'Y' ELSE 'N' END) time_bar,(CASE WHEN facility_id<>curr_facility_id THEN '(' || curr_facility_name ||')' ELSE '&nbsp;' END) curr_facility_name,a.return_criteria,a.no_of_dh_to_return_op, a.duration_type,TO_CHAR(a.nia_return_date,'dd/mm/rrrr hh24:mi') nia_return_date FROM fm_curr_locn_vw a WHERE a.curr_fs_locn_code<>a.mr_pat_fs_locn_code AND doc_folder_id is null AND a.facility_id='"+ facility_id +"' "+sqlCriteria+" ORDER BY a.curr_fs_locn_short_desc,a.file_no " ;
			sql	= "SELECT  a.file_no ,a.curr_locn_id ,a.patient_id, MR_GET_DESC.MR_FILE_TYPE(a.facility_id, a.file_type_code, '"+localeName+"', 2) file_type_desc  ,a.volume_no  ,get_patient_line(a.patient_id,'"+localeName+"') patient_line  ,a.curr_fs_locn_code  ,FM_GET_DESC.FM_STORAGE_LOCN(A.CURR_FACILITY_ID, a.curr_fs_locn_code,'"+localeName+"','2') curr_fs_locn_short_desc  ,a.curr_fs_locn_identity curr_fs_locn_identity  ,A.CURR_FILE_STATUS curr_file_status  ,TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time  ,TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time  ,(  CASE   WHEN sysdate > return_date_time   THEN  'Y'   ELSE 'N'   END) time_bar  ,(  CASE   WHEN a.facility_id<>curr_facility_id   THEN  '(' || SM_GET_DESC.SM_FACILITY_PARAM(A.CURR_FACILITY_ID,'"+localeName+"','1') ||')'   ELSE '&nbsp;'   END) curr_facility_name  ,b.return_criteria  ,b.no_of_dh_to_return_op  , b.duration_type  ,TO_CHAR(a.nia_return_date,'dd/mm/rrrr hh24:mi') nia_return_date  FROM  fm_curr_locn a,   fm_storage_locn b WHERE a.curr_fs_locn_code<>a.PERM_FS_LOCN_CODE   AND doc_folder_id IS null   AND a.facility_id='"+ facility_id +"'   "+sqlCriteria+"  AND a.curr_facility_id = b.facility_id  AND a.curr_fs_locn_code = b.fs_locn_code ORDER BY  FM_GET_DESC.FM_STORAGE_LOCN(A.CURR_FACILITY_ID, a.curr_fs_locn_code,'"+localeName+"','2')  ,a.file_no  " ;
	
	
			try
			{
		  		rset = mystmt.executeQuery(sql);
				rset.last();
				maxRecord = rset.getRow();
				rset.beforeFirst();
	        }catch(Exception e){
				out.println("resultset"+e);
				e.printStackTrace() ;
			}
			
            _bw.write(_wl_block8Bytes, _wl_block8);
 if(!(start <= 1)) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((start-5)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end-5)));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 } if(!((start+5) >= maxRecord)) {
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((start+5)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end+5)));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 } 
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(doc_or_file.equals("D")) { 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else if(doc_or_file.equals("F")) { 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(file_type_appl_yn.equals("Y")) { 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 } else if(file_type_appl_yn.equals("N")) { 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

		        String p_first_curr_fs_locn_code = "";				
				String bgcolor                   = "";
				String nia_bgcolor               = "";
				String return_criteria			 = "";
			//	String no_of_dh_to_return_ip	 = "";
				String no_of_dh_to_return_op	 = "";
				String curr_fs_locn_identity	 = "";
				String duration_type			 = "";
				String f_no						 = "";
				String vol_no					 = "";
				String returnfile_date_time		 = "";
				//String no_hours					 = "0";
				double no_hours					 = 0.00;
				//String nia_no_hours				 = "0";
				double nia_no_hours				 = 0.00;
				String curr_file_status			 = "";
					
				int p_rec_cnt	= 0;
				int cnt			= 0;  //To Display the total No of Files Groupwise - by Meghanath.

				if(start != 0)
				{
					for(int j=1; j<=start; i++,j++)
					{
						rset.next() ;
					}
				}

				/*sql0 = "SELECT to_char(MAX(ISS_DATE_TIME)+ (?/24),'dd/mm/rrrr hh24:mi') returndate FROM FM_CURR_LOCN WHERE FILE_NO = ? ";
				pstmt = con.prepareStatement(sql0);*/

				sql1 = "SELECT (sysdate - max(DISCHARGE_DATE_TIME)) *24 diffinhours FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? and assign_care_locn_code=? AND patient_id in (select patient_id FROM fm_movement_log where FILE_NO = ? AND patient_id=? AND facility_id = ? AND SENT_DATE_TIME IS NOT null)";
				pstmt1 = con.prepareStatement(sql1);

			//	sql11 = "SELECT (sysdate-max(SENT_DATE_TIME)) *24 diffinhours from fm_movement_log where FILE_NO = ? AND VOLUME_NO = ? AND facility_id = ? and SENT_DATE_TIME is not null";
			
			sql11 = "SELECT (sysdate-max(RETURN_DATE_TIME)) diffinhours from fm_curr_locn where FILE_NO = ? AND patient_id =? AND VOLUME_NO = ? AND facility_id = ? ";
				pstmt2 = con.prepareStatement(sql11);
				
				sql2 = "SELECT (sysdate - max(nia_return_date)) *24 nia_diffinhours from fm_curr_locn where nia_return_date is not null AND facility_id = ? and patient_id in (select patient_id from fm_movement_log WHERE file_no = ? AND patient_id =? AND facility_id = ? and sent_date_time is not null)";
				pstmt3 = con.prepareStatement(sql2);

			//	String mysql1 = "SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi')discharge_date_time,to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no = ? AND facility_id = ? AND sent_date_time IS NOT null)";
			//	pstmt5 = con.prepareStatement(mysql1);

			
           while(rset.next() && i<=end)
				{
					return_criteria			= rset.getString("return_criteria");
				//	no_of_dh_to_return_ip	= rset.getString("no_of_dh_to_return_ip");
					no_of_dh_to_return_op	= rset.getString("no_of_dh_to_return_op");
					curr_fs_locn_identity	= rset.getString("curr_fs_locn_identity");
					duration_type			= rset.getString("duration_type");
					 patient_id=rset.getString("patient_id");
				curr_locn_id=rset.getString("curr_locn_id");
		      if(patient_id==null) patient_id="";
				if(curr_locn_id==null) curr_locn_id="";	
					
					f_no					= rset.getString("file_no");
					vol_no					= rset.getString("volume_no");
					curr_file_status= rset.getString("curr_file_status")==null? "&nbsp" :rset.getString("curr_file_status");

					if(return_criteria == null || return_criteria.equals("null")) return_criteria = "";
				//	if(no_of_dh_to_return_ip == null) no_of_dh_to_return_ip = "0";
					if(no_of_dh_to_return_op == null) no_of_dh_to_return_op = "0";
					if(curr_fs_locn_identity == null ) curr_fs_locn_identity = "";
					if(duration_type == null ) duration_type = "";
					if(f_no == null) f_no = "";
					if(vol_no == null) vol_no = "";

					if(!curr_fs_locn_identity.equals(""))
		{
			switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
				
			if(!curr_file_status.equals(""))
			{
				switch(curr_file_status.charAt(0))
				{
					case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'R' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;

					case 'E' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;
			
				}
			}					

				
										
					if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}

			        if(counter == 0)
					{
						p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");
						
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rset.getString("curr_fs_locn_short_desc")+" ("+curr_fs_locn_identity+") "));
            _bw.write(_wl_block30Bytes, _wl_block30);

					}
			        else if(!p_first_curr_fs_locn_code.equals(rset.getString("curr_fs_locn_code")))
					{
						if(classValue.equals("QRYODD"))
						{
							classValue = "QRYEVEN";
						}
						else if(classValue.equals("QRYEVEN"))
						{
							classValue = "QRYODD";
						}
						
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block34Bytes, _wl_block34);

						cnt = 0;
						
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rset.getString("curr_fs_locn_short_desc")+" ("+curr_fs_locn_identity+") "));
            _bw.write(_wl_block36Bytes, _wl_block36);

					}

					counter++;

					if(counter % 2 == 0) classValue = "QRYODD";
					else classValue = "QRYEVEN" ;
						
					//no_hours				= "0";
					no_hours				= 0.00;
					//nia_no_hours			= "0";
					nia_no_hours			= 0.00;
					returnfile_date_time	= "";
		
		///////////////////////////////////////////////////////////////////////
		
					/*pstmt.setInt(1,parameter_hours);
					pstmt.setString(2,f_no);
					
					rset2 = pstmt.executeQuery();
					
					while(rset2 != null && rset2.next())
					{
						returnfile_date_time = rset2.getString("returndate");
						if(returnfile_date_time == null) returnfile_date_time = "";
					} if(rset2 != null) rset2.close();*/

		/////////////////////////////////////////////////////////////////////////////
          
		
		   if(return_criteria.equals("D"))
					{

		/////////////////////////////////////////////////////////////////////////////

						pstmt1.setString(1,facility_id);
						pstmt1.setString(2,curr_locn_id);
						pstmt1.setString(3,f_no);
						pstmt1.setString(4,patient_id);
						pstmt1.setString(5,facility_id);
						rset1 = pstmt1.executeQuery();

		/////////////////////////////////////////////////////////////////////////////
						
					}
					else
					{

	/////////////////////////////////////////////////////////////////////////////                       
						pstmt2.setString(1,f_no);
						pstmt2.setString(2,patient_id);
						pstmt2.setString(3,vol_no);
						pstmt2.setString(4,facility_id);
						rset1 = pstmt2.executeQuery();

		/////////////////////////////////////////////////////////////////////////////

					}
					
					while(rset1 != null && rset1.next())
					{
						no_hours = rset1.getDouble("diffinhours");
						//if(no_hours == null) no_hours=0.00;
						//else if(no_hours == "0") no_hours=0.00;
						//no_hours =  no_hours.substring(0,no_hours.indexOf("."));
					} if(rset1  !=null) rset1.close();

		/////////////////////////////////////////////////////////////////////////////
					//if(!no_hours.equals("-")){
						//	if(Integer.parseInt(no_hours) <= parameter_hours)
						if(no_hours <= 0.00)
						{
							bgcolor="orange";		
						}
					//	else if(Integer.parseInt(no_hours) > parameter_hours)
						else if(no_hours > 0.00)
						{
							bgcolor = "red";		
						}	
					//}
					if(return_criteria.equals("D"))
					{

		/////////////////////////////////////////////////////////////////////////////

						pstmt3.setString(1,facility_id);
						pstmt3.setString(2,f_no);
						pstmt3.setString(3,patient_id);
						pstmt3.setString(4,facility_id);
						
						rset1 = pstmt3.executeQuery();
						
						while(rset1!= null && rset1.next())
						{
							nia_no_hours = rset1.getDouble("nia_diffinhours");
							//if(nia_no_hours == null) nia_no_hours="0.00";
							//nia_no_hours =  nia_no_hours.substring(0,nia_no_hours.indexOf("."));
						} if(rset1  !=null) rset1.close();

		/////////////////////////////////////////////////////////////////////////////

					}						
					if(return_criteria.equals("D"))
					{
						if(nia_no_hours <= parameter_hours)
						{
							nia_bgcolor = "orange";		
						}
						else if(nia_no_hours > parameter_hours)
						{
							nia_bgcolor = "red";		
						}	
										
					}
					else
					{
						if(no_hours <= parameter_hours)
						{
							nia_bgcolor = "orange";		
						}
						else if(no_hours > parameter_hours)
						{
							nia_bgcolor = "red";		
						}	
					}
				////////////////////////////////////////////////////////////////////
				// Modified against HSA-SCF-0112 : Getting IncompleteLocation from the table-FM_PARAMETER 
				/*Change Desc: If incompletefslocation of FM Parameter value exists, then in search criteria, avoiding the clinic code check 
								in where condition of the below query 'mysql1' */
				
				String sqlChkInCompleteLocn = "SELECT DFLT_INCOMPLETE_FS_LOCN_CODE  FROM FM_PARAMETER  WHERE FACILITY_ID = '"+facility_id+"'";
				String sIncompleteFSLocn = "";
				String mysql1 = "";
				
				pstmt5 = con.prepareStatement(sqlChkInCompleteLocn);	
				rset1  = pstmt5.executeQuery();
				
				if(rset1 != null && rset1.next())
				{
					sIncompleteFSLocn  = rset1.getString("DFLT_INCOMPLETE_FS_LOCN_CODE");
				} 
				if(rset1 != null) rset1.close();
				if(pstmt5 != null) pstmt5.close();
				
				if( sIncompleteFSLocn != null && sIncompleteFSLocn != "")
				{
					mysql1 = "SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi')discharge_date_time,to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time,(sysdate-(discharge_date_time+ "+(parameter_hours)+" / 24)) diffhrs  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no = ? AND facility_id = ? AND sent_date_time IS NOT null)";
					 
					pstmt5 = con.prepareStatement(mysql1);
					pstmt5.setString(1,facility_id);
					pstmt5.setString(2,f_no);
					pstmt5.setString(3,facility_id); 
				}else
				{
					mysql1 = "SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi')discharge_date_time,to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time,(sysdate-(discharge_date_time+ "+(parameter_hours)+" / 24)) diffhrs  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? AND assign_care_locn_code=? AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no = ? AND facility_id = ? AND sent_date_time IS NOT null)";
					pstmt5 = con.prepareStatement(mysql1);
					pstmt5.setString(1,facility_id);
					pstmt5.setString(2,curr_locn_id);
					pstmt5.setString(3,f_no);
					pstmt5.setString(4,facility_id); 
				}
				
					rset1 = pstmt5.executeQuery();
					
					discharge_date_time = "";
 
					if(rset1 != null && rset1.next())
					{
						discharge_date_time = rset1.getString(1);
					    discharge_date_time1 = rset1.getString(2);
					  diffhrs                  =rset1.getDouble("diffhrs");
					} if(rset1 != null) rset1.close();
					if(pstmt5 != null) pstmt5.close();//checkstyle changes for 35865

		//////////////////////////////////////////////////////////////////////
						if(!discharge_date_time.equals(""))
						{
							discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
						}
						else
					{
						discharge_date_time ="&nbsp";
					}
					if(discharge_date_time1 != null || (!discharge_date_time1.equals(""))) 
					{
                    discharge_date_time1=DateUtils.convertDate(discharge_date_time1,"DMYHM","en",localeName);
					}else{
                     discharge_date_time1 ="&nbsp";
                 
					}
					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);

						if(file_type_appl_yn.equals("N"))
						{
						
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((rset.getString("file_no")==null)?"":"<b>"+rset.getString("file_no")+"</b><br>&nbsp;&nbsp;"+rset.getString("patient_line").substring(0,rset.getString("patient_line").length()-6)));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } else if(file_type_appl_yn.equals("Y")) { 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((rset.getString("patient_line").substring(0,rset.getString("patient_line").length()-6))));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((rset.getString("file_type_desc")==null)?"&nbsp;":(rset.getString("file_type_desc")+" / ")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((rset.getString("volume_no")==null)?"&nbsp;":rset.getString("volume_no")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(curr_file_status+"<br>"+rset.getString("curr_facility_name")+""));
            _bw.write(_wl_block46Bytes, _wl_block46);

						iss_date_time = rset.getString("iss_date_time");
						if(iss_date_time != null)
						{
							iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
						}
						else
							iss_date_time = "&nbsp";
						
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(iss_date_time));
            _bw.write(_wl_block46Bytes, _wl_block46);

						if(rset.getString("return_date_time") == null || rset.getString("return_date_time").equals(""))
							bgcolor="";
						
						return_date_time = rset.getString("return_date_time");
						if(return_date_time != null)
						{
							return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
						}
						else
							return_date_time = "&nbsp";
						
						if(return_criteria.equals("D")){	 			
															
						
						if(parameter_hours<=0)
							{
						discharge_date_time1="&nbsp;";
						}
							if(return_date_time.equals("&nbsp"))
							{
							return_date_time=discharge_date_time1; 
						    }
						if(!return_date_time.equals("") && parameter_hours>0)
							{
											
						if(diffhrs <= 0.00)
						{
							bgcolor="orange";		
						}
					//	else if(Integer.parseInt(no_hours) > parameter_hours)
						else if(diffhrs >0.00)
						{
							bgcolor = "red";		
						}
							}
						}
						if(return_date_time.equals(""))
					    {
                         return_date_time="&nbsp";
						   }
												
						if(!discharge_date_time.equals("&nbsp") && return_criteria.equals("D") && parameter_hours>0)					
						{
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(discharge_date_time1));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(return_date_time));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block54Bytes, _wl_block54);

						return_date_time="";
						  discharge_date_time1="";
						  if(rset.getString("nia_return_date") == null || rset.getString("nia_return_date").equals(""))
							nia_bgcolor="";

						nia_return_date = rset.getString("nia_return_date");
					
					if(discharge_date_time.equals("&nbsp") && return_criteria.equals("D") &&  nia_return_date != null)
					  {
					 nia_return_date=null;
					nia_bgcolor="";
						}
						
						
						if(nia_return_date != null)
						{
							nia_return_date=DateUtils.convertDate(nia_return_date,"DMYHM","en",localeName);
						}
						else
							nia_return_date = "&nbsp";
						
												
						
						
						
						
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(nia_bgcolor));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(nia_return_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block59Bytes, _wl_block59);

	                p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");
   			       	p_rec_cnt++;
					if(p_first_curr_fs_locn_code.equals(rset.getString("curr_fs_locn_code")))
					{
						cnt++;
					}i++;
				}
				if(cnt !=0)
				{
					if(classValue.equals("QRYODD"))
					{
						classValue = "QRYEVEN";
					}
					else if(classValue.equals("QRYEVEN"))
					{
						classValue = "QRYODD";
					}
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block61Bytes, _wl_block61);
 } 
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(start));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(end));
            _bw.write(_wl_block66Bytes, _wl_block66);

		if(rset  !=null) rset.close(); 
		if(rset1 !=null) rset1.close();
		if(rset2 !=null) rset2.close();
		if(mystmt !=null) mystmt.close();
		if(pstmt !=null) pstmt.close();
		if(pstmt1 !=null) pstmt1.close();
		if(pstmt2 !=null) pstmt2.close();
		if(pstmt3 !=null) pstmt3.close();
		if(pstmt4 !=null) pstmt4.close();
		if(pstmt5 !=null) pstmt5.close();

		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
		    
		    ConnectionManager.returnConnection(con, request);
		}
	
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(fromRecordNumber));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(toRecordNumber));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(noOfRecords));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(fs_locn_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(from_search));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(out_criteria));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(out_facility_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSlocationoftheDocument.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentdetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentStatus.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSlocationoftheFile.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileNoPatientDetails.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileTypeVolumeNo.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileStatus.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.issueddate.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDueDateTime.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.NIADueDate.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TotalNoofFiles.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TotalNoofFiles.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
