package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import java.text.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __buildlibrarygoalhyperlinks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/BuildLibraryGoalHyperlinks.jsp", 1709116569372L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t\t<SCRIPT language=\"javascript\" src=\"../js/BuildLibrary.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<BODY>\n<FORM name=\"formLibraryGoalHyperlinks\" id=\"formLibraryGoalHyperlinks\">\n\t<TABLE  border=\'0\' cellspacing=\'0\' cellpadding=\'0\' align=\'center\' width=\'102%\'>\n\t<TR>\n\t<TR>\n\t\t<!-- <TD><a href=\'../../eCP/Jsp/BuildLibraryGoalDetails.jsp?alphalink=Associated&termSet=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&termCode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&termDesc=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&libraryid=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&versionno=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&tableName=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' target=\"f_Goal_detail\"><u>Associated</u></a></TD> -->\n\t\t<TD><label onClick=\"loadGoalDetail(associated_lbl,\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'Associated\')\" style=\"color:blue;cursor:pointer\" id=\"associated_lbl\"><u><font color=maroon>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(A_lbl,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'A\')\" style=\"color:blue;cursor:pointer\" id=\"A_lbl\"><u>A</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(B_lbl,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'B\')\" style=\"color:blue;cursor:pointer\" id=\"B_lbl\"><u>B</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(C_lbl,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'C\')\" style=\"color:blue;cursor:pointer\" id=\"C_lbl\"><u>C</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(D_lbl,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'D\')\" style=\"color:blue;cursor:pointer\" id=\"D_lbl\"><u>D</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(E_lbl,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'E\')\" style=\"color:blue;cursor:pointer\" id=\"E_lbl\"><u>E</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(F_lbl,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'F\')\" style=\"color:blue;cursor:pointer\" id=\"F_lbl\"><u>F</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(G_lbl,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'G\')\" style=\"color:blue;cursor:pointer\" id=\"G_lbl\"><u>G</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(H_lbl,\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'H\')\" style=\"color:blue;cursor:pointer\" id=\"H_lbl\"><u>H</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(I_lbl,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'I\')\" style=\"color:blue;cursor:pointer\" id=\"I_lbl\"><u>I</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(J_lbl,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'J\')\" style=\"color:blue;cursor:pointer\" id=\"J_lbl\"><u>J</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(K_lbl,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'K\')\" style=\"color:blue;cursor:pointer\" id=\"K_lbl\"><u>K</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(L_lbl,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'L\')\" style=\"color:blue;cursor:pointer\" id=\"L_lbl\"><u>L</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(M_lbl,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'M\')\" style=\"color:blue;cursor:pointer\" id=\"M_lbl\"><u>M</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(N_lbl,\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'N\')\" style=\"color:blue;cursor:pointer\" id=\"N_lbl\"><u>N</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(O_lbl,\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'O\')\" style=\"color:blue;cursor:pointer\" id=\"O_lbl\"><u>O</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(P_lbl,\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'P\')\" style=\"color:blue;cursor:pointer\" id=\"P_lbl\"><u>P</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(Q_lbl,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'Q\')\" style=\"color:blue;cursor:pointer\" id=\"Q_lbl\"><u>Q</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(R_lbl,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'R\')\" style=\"color:blue;cursor:pointer\" id=\"R_lbl\"><u>R</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(S_lbl,\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'S\')\" style=\"color:blue;cursor:pointer\" id=\"S_lbl\"><u>S</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(T_lbl,\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'T\')\" style=\"color:blue;cursor:pointer\" id=\"T_lbl\"><u>T</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(U_lbl,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'U\')\" style=\"color:blue;cursor:pointer\" id=\"U_lbl\"><u>U</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(V_lbl,\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'V\')\" style=\"color:blue;cursor:pointer\" id=\"V_lbl\"><u>V</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(W_lbl,\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'W\')\" style=\"color:blue;cursor:pointer\" id=\"W_lbl\"><u>W</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(X_lbl,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'X\')\" style=\"color:blue;cursor:pointer\" id=\"X_lbl\"><u>X</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(Y_lbl,\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'Y\')\" style=\"color:blue;cursor:pointer\" id=\"Y_lbl\"><u>Y</u></a></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(Z_lbl,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'Z\')\" style=\"color:blue;cursor:pointer\" id=\"Z_lbl\"><u>Z</u></a></TD>\n\t\t<TD></TD>\n\t\t<TD><label onClick=\"loadGoalDetail(Others_lbl,\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'\')\" style=\"color:blue;cursor:pointer\" id=\"Others_lbl\"><u>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</u></a></TD>\n\t</TR>\n</TABLE>\n</FORM>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

		//This file is saved on 18/10/2005.
		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String termSet		=	request.getParameter("termSet");
String termCode		=	request.getParameter("termCode");
String termDesc		=	request.getParameter("termDesc");
String libraryid	=	request.getParameter("libraryid");
String versionno	=	request.getParameter("versionno");
String tableName	=	request.getParameter("tableName");
try{
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Associated.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
}
