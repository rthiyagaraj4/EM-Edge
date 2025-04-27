package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blamendmultiservicepriceextn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAmendMultiServicePriceExtn.jsp", 1709114394729L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\t<input type=\'hidden\' name=\'priceindbot";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\' id=\'priceindbot";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\n\t<input type=\'hidden\' name=\'effFrmDate";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' id=\'effFrmDate";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n\t<input type=\'hidden\' name=\'efftodate";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' id=\'efftodate";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t<input type=\'hidden\' name=\'discPerip";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' id=\'discPerip";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type=\'hidden\' name=\'discPerop";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' id=\'discPerop";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=\'hidden\' name=\'discPerem";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'discPerem";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type=\'hidden\' name=\'discPerex";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'discPerex";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'discPerdc";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'discPerdc";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=\'hidden\' name=\'Applicability";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'Applicability";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'baseqty";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'baseqty";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<input type=\'hidden\' name=\'publicchk";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'publicchk";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=\'hidden\' name=\'rate_Basis_Ind";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'rate_Basis_Ind";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<input type=\'hidden\' name=\'mincharge";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'mincharge";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\'hidden\' name=\'maxcharge";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'maxcharge";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<input type=\'hidden\' name=\'checkcostavl";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'checkcostavl";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type=\'hidden\' name=\'costind";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'costind";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=\'hidden\' name=\'costamt";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'costamt";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type=\'hidden\' name=\'applydiscount";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'applydiscount";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\n\t<input type=\'hidden\' name=\'discString";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'discString";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'discDtls";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'discDtls";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'billingclass";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'billingclass";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t<input type=\'hidden\' name=\'billingdesc";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'billingdesc";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' value=\'\'>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<input type=\'hidden\' name=\'discString";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\'\'>\t\t\t\n\t<input type=\'hidden\' name=\'discDtls";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'applydiscount";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' value=\'N\'>\n\t<input type=\'hidden\' name=\'billingclass";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'billingdesc";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'priceindbot";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'effFrmDate";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'efftodate";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'discPerip";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'discPerop";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'discPerem";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'discPerex";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'discPerdc";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'Applicability";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'baseqty";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'publicchk";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' value=\'N\'>\n\t<input type=\'hidden\' name=\'mincharge";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'maxcharge";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'checkcostavl";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'costind";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'costamt";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' value=\'\'>\n\t<input type=\'hidden\' name=\'rate_Basis_Ind";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' value=\'\'>\t\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\t\n\t\t\t\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);

		String parvalues=request.getParameter("parvalues");
		String[] arrParValues = parvalues.split("~");
		int tableIndex = Integer.parseInt(request.getParameter("tableIndex"));
		String mode = request.getParameter("mode");
		System.err.println("parvalues:"+parvalues);
		System.err.println("arrParValues:"+arrParValues);
		System.err.println("tableIndex:"+tableIndex);
		System.err.println("mode:"+mode);
		if("modify".equals(mode))
		{
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[0]));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[1]));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[2]));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[3]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[4]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[5]));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[6]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[7]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[8]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[9]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[10]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[11]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[12]));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[13]));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[14]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[15]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[16]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[17]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[18]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block46Bytes, _wl_block46);

		} else {

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block69Bytes, _wl_block69);

		}

            _bw.write(_wl_block70Bytes, _wl_block70);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
