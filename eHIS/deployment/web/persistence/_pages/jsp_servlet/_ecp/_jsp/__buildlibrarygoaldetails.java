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

public final class __buildlibrarygoaldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/BuildLibraryGoalDetails.jsp", 1734168752072L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\' ></SCRIPT>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t\t<SCRIPT language=\"javascript\" src=\"../js/BuildLibrary.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</HEAD>\n<BODY onKeyDown = \'lockKey()\';  OnMouseDown=\"CodeArrest()\">\n<FORM name=\"formBuildLibraryGoalDetails\" id=\"formBuildLibraryGoalDetails\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" align=\"center\">\n\t\t<TR>\n\t\t<TD width=\"80%\" class=\"white\">&nbsp;</TD>\n\t\t<TD width=\"20%\" class=\"white\">&nbsp;</TD>\n\t\t<TD align=\"right\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<label onClick=\'Goalnavigation(document.formBuildLibraryGoalDetails,\"previous\")\'  style=\'cursor:pointer;color:blue\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</label>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<label onClick=\'Goalnavigation(document.formBuildLibraryGoalDetails,\"next\")\'  style=\'cursor:pointer;color:blue\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</label>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</TD></TR></TABLE>\n\n<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'100%\' >\n\t<TH >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</TH>\n\t<TH width=\"20%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TH>\n\t<TH width=\"20%\">&nbsp;</TH>\n\t<TH width=\"10%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </TH>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<TR>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" align=\"left\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<INPUT TYPE=\"hidden\" name=\"goalDesc";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"goalDesc";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<!-- <INPUT type=\"hidden\" name=\"goalDesc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"> -->\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" align=\"left\">\n\t\t\t\t<INPUT type=\"text\" class=\"number\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" name=\"targetPeriod";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onblur=\"updateGoalList(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');\" maxlength=\"5\" size=\"5\">\n\t\t\t\t<SELECT name=\"targetPeriodType";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"targetPeriodType";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onchange=\"updateGoalList(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\">\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<OPTION ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</OPTION>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" align=\"center\">\n\t\t\t<SELECT name=\"practitionerType";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"practitionerType";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\">\n\t\t\t\t<OPTION >&nbsp;&nbsp;&nbsp;--";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="--</OPTION>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<OPTION ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</OPTION>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" align=\"center\"> <label onclick=\"updateGoalList(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');showInterventiondialog(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\', \'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\"\n\tstyle=\'cursor:pointer;color:Blue;font:11\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</label> </TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" align=\"center\"><INPUT type=\"checkbox\" name=\"select";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"select";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="   value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"onclick=\"updateGoalList(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="></TD>\n\t</TR>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n</TABLE>\n<INPUT type=\"hidden\" name=\"start\" id=\"start\"     value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<INPUT type=\"hidden\" name=\"end\" id=\"end\"       value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<INPUT type=\"hidden\" name=\"alphalink\" id=\"alphalink\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<INPUT type=\"hidden\" name=\"termSet\" id=\"termSet\"   value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<INPUT type=\"hidden\" name=\"termCode\" id=\"termCode\"  value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<INPUT type=\"hidden\" name=\"termDesc\" id=\"termDesc\"  value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<INPUT type=\"hidden\" name=\"libraryid\" id=\"libraryid\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<INPUT type=\"hidden\" name=\"versionno\" id=\"versionno\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<INPUT type=\"hidden\" name=\"tableName\" id=\"tableName\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t<SCRIPT></SCRIPT>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n</BODY>\n</FORM>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet BuildLibrary= null;synchronized(session){
                BuildLibrary=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BuildLibrary",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BuildLibrary==null){
                    BuildLibrary=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BuildLibrary",BuildLibrary,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
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
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


String alphalink			=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
String termSet				=		request.getParameter("termSet");
String termCode				=		request.getParameter("termCode");
String termDesc				=		request.getParameter("termDesc");
String libraryid			=		request.getParameter("libraryid");
String versionno			=		request.getParameter("versionno");
String tableName			=		request.getParameter("tableName");
String from					=		request.getParameter("from") ;
String to					=		request.getParameter("to") ;
alphalink					=		alphalink.trim();

Connection connection		=		null;
Statement stmt				=		null;
ResultSet rs				=		null;
Statement stmt1	 			=		null;
ResultSet rs1				=		null;
PreparedStatement pstmt     =       null;//common-icn-0180
PreparedStatement pstmt1     =       null;//common-icn-0180
PreparedStatement pstmt2     =       null;//common-icn-0180

int maxRecord				=		0;
int start					=		0 ;
int end						=		0 ;
int i						=		1;

String classValue			=		"";
String  sqlData				=		"";
String readonly				=		"";
String disabled				=		"";
String db_action			=		"";
String goalDesc				=		"";
String goalCode				=		"";
String checkedAttribute		=		"";
String targetPeriod			=		"";
String targetPeriodType		=		"";
String targetSelectStatus	=		"";
//String maxGrpID				=		"";
String practitionerType1	=		"";
String temppractitionerType	=		"";
String practitionerTypeSelect=		"";
String tempTermSet			=		"";
String tempTermCode			=		"";
String Status				=		"";
String temptargetType		=		"";
//String sqlData1				=		"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw where language_id='"+locale+"' ORDER BY 2";//common-icn-0180
String sqlData1				=		"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw where language_id=? ORDER BY 2";//common-icn-0180


//String sqlData2				=		"SELECT PRACT_TYPE,DESC_USERDEF FROM AM_PRACT_TYPE_lang_vw WHERE EFF_STATUS = 'E' and  language_id='"+locale+"' ORDER BY DESC_USERDEF";
String sqlData2				=		"SELECT PRACT_TYPE,DESC_USERDEF FROM AM_PRACT_TYPE_lang_vw WHERE EFF_STATUS = 'E' and  language_id=? ORDER BY DESC_USERDEF";

ArrayList targetType		=		new ArrayList();
ArrayList practitionerType	=		new ArrayList();
ArrayList TermCodeList		=		null;
ArrayList Goal				=		null;
ArrayList sessionList		=		(ArrayList)BuildLibrary.getRecordSetHandle();

if(sessionList.size()>0)
{
	TermCodeList=(ArrayList)BuildLibrary.getObject(0);
}

 if (from == null){ start = 0 ; }   else {  start = Integer.parseInt( from ) ; }
 if (to == null){ end = 10 ; }      else {  end = Integer.parseInt( to ) ; }

if(alphalink.equals("Associated")){
	//sqlData		=	"SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT ORDER BY GOAL_DESC";
	//sqlData		=	"SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"' AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND B.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180
	sqlData		=	"SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ?  AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ? AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180

}
else
{
	//sqlData		=	"SELECT  OUTCOME_CODE GOAL_CODE,SHORT_DESC GOAL_DESC, TO_NUMBER('') GOAL_TARGET_DURN,	TO_CHAR('') GOAL_TARGET_DURN_UNIT, 'I' DB_ACTION FROM  CP_OUTCOME WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  OUTCOME_TYPE = 'G' AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT GOAL_CODE FROM CP_LIBRARY_GOAL WHERE LIBRARY_ID = '"+libraryid+"' AND  VERSION_NO = '"+versionno+"' AND  TERM_SET_ID = '"+termSet+"'AND  TERM_CODE = '"+termCode+"') UNION ALL SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = '"+libraryid+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  B.OUTCOME_CODE = A.GOAL_CODE AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT  AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) ORDER BY GOAL_DESC";
	//sqlData		=	"SELECT  OUTCOME_CODE GOAL_CODE,SHORT_DESC GOAL_DESC, TO_NUMBER('') GOAL_TARGET_DURN,  TO_CHAR('') GOAL_TARGET_DURN_UNIT, 'I' DB_ACTION FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  OUTCOME_TYPE = 'G' AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT GOAL_CODE FROM CP_LIBRARY_GOAL WHERE LIBRARY_ID = '"+libraryid+"' AND  VERSION_NO = '"+versionno+"' AND  TERM_SET_ID = '"+termSet+"'AND  TERM_CODE = '"+termCode+"') AND LANGUAGE_ID = '"+locale+"' UNION ALL SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = '"+libraryid+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  B.OUTCOME_CODE = A.GOAL_CODE AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND B.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180
	sqlData		=	"SELECT  OUTCOME_CODE GOAL_CODE,SHORT_DESC GOAL_DESC, TO_NUMBER('') GOAL_TARGET_DURN,  TO_CHAR('') GOAL_TARGET_DURN_UNIT, 'I' DB_ACTION FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  OUTCOME_TYPE = 'G' AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT GOAL_CODE FROM CP_LIBRARY_GOAL WHERE LIBRARY_ID = ? AND  VERSION_NO = ? AND  TERM_SET_ID = ? AND  TERM_CODE = ?) AND LANGUAGE_ID = ? UNION ALL SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE = ? AND  B.OUTCOME_CODE = A.GOAL_CODE AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180

}
try{
	connection	=	ConnectionManager.getConnection(request);
	//stmt1		=	connection.createStatement();//common-icn-0180
	pstmt      =    connection.prepareStatement(sqlData1);//common-icn-0180
	pstmt.setString(1, locale);//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlData1);//common-icn-0180
	rs1			=	pstmt.executeQuery();//common-icn-0180
	if(rs1!=null){
		while(rs1.next()){
			targetType.add(rs1.getString("DURN_TYPE"));
			targetType.add(rs1.getString("DURN_DESC"));

		}
	}
	rs1.close();
	pstmt1      =    connection.prepareStatement(sqlData2);//common-icn-0180
	pstmt1.setString(1, locale);//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlData2);
	rs1			=	pstmt1.executeQuery();
	if(rs1!=null){
		while(rs1.next()){
			practitionerType.add(rs1.getString("PRACT_TYPE"));
			practitionerType.add(rs1.getString("DESC_USERDEF"));

		}
	}
	rs1.close();
	//common-icn-0180 starts
	int pstmtcount = 1;
	//stmt	=	connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	pstmt2      =    connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	if(alphalink.equals("Associated")){
		pstmt2.setString(pstmtcount++, libraryid);
		pstmt2.setString(pstmtcount++, versionno);
		pstmt2.setString(pstmtcount++, termSet);
		pstmt2.setString(pstmtcount++, termCode);
		pstmt2.setString(pstmtcount++, locale);

	}
	else{
		pstmt2.setString(pstmtcount++, libraryid);
		pstmt2.setString(pstmtcount++, versionno);
		pstmt2.setString(pstmtcount++, termSet);
		pstmt2.setString(pstmtcount++, termCode);
		pstmt2.setString(pstmtcount++, locale);
		pstmt2.setString(pstmtcount++, libraryid);
		pstmt2.setString(pstmtcount++, versionno);
		pstmt2.setString(pstmtcount++, termSet);
		pstmt2.setString(pstmtcount++, termCode);
		pstmt2.setString(pstmtcount++, locale);
	}
	
	//rs		=	stmt.executeQuery(sqlData);
	rs		=	pstmt2.executeQuery();
	//common-icn-0180 ends
	if(rs!=null){
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		if(maxRecord>0){
				

            _bw.write(_wl_block9Bytes, _wl_block9);

		if ( !(start <= 1) )
		{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		if ( !( (start+10) >= maxRecord ) )
		{
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	
if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}

while(rs.next() && i<=end){

		if((i%2) == 1)
				classValue = "QRYEVEN";
			else
				classValue ="QRYODD";

			goalCode	=	rs.getString("GOAL_CODE");
			goalDesc	=	rs.getString("GOAL_DESC");

			for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet=(String)TermCodeList.get(j);
				if(termSet.equals(tempTermSet)){
					 tempTermCode=(String)TermCodeList.get(j+1);
					if(tempTermCode.equals(termCode)){
						Goal=(ArrayList)TermCodeList.get(j+2);
						if(Goal.size()>0){
								if(Goal.contains(goalCode)){
									int k				=	Goal.indexOf(goalCode);
									Status				=	(String)Goal.get(k+4);
									db_action			=	(String)Goal.get(k+5);;
									targetPeriod		=	(String)Goal.get(k+1);
									practitionerType1	=	(String)Goal.get(k+8);
									//out.println("practitionerType1"+practitionerType1);
									if(targetPeriod.equals("0"))
										targetPeriod	=	"";
									targetPeriodType=(String)Goal.get(k+2);
									//maxGrpID			=	(String)Goal.get(k+6);
									if(Status.equals("Y")){
										checkedAttribute =	"checked";
									}
								}
							}
						}
					}
				}

				if(db_action.equals("U")){
					if(alphalink.equals("Associated")){
						readonly="";
						disabled="";
		
					}else
					{
						readonly="readonly";
						disabled="disabled";
					}
				}
							
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(goalDesc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(goalDesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(goalDesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(targetPeriod));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
for(int j=0;j<targetType.size();j=j+2){
					temptargetType=(String)targetType.get(j);
					if(temptargetType.equals(targetPeriodType))
						targetSelectStatus="selected";
					else
						targetSelectStatus="";
	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(targetSelectStatus));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(targetType.get(j)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(targetType.get(j+1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
for(int k=0;k<practitionerType.size();k=k+2){
			temppractitionerType=(String)practitionerType.get(k);
			//System.err.println("temppractitionerType  "+temppractitionerType);

			if(temppractitionerType.equals(practitionerType1))
				practitionerTypeSelect="selected";
			else
				practitionerTypeSelect="";
		
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(practitionerTypeSelect));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(temppractitionerType));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(practitionerType.get(k+1)));
            _bw.write(_wl_block45Bytes, _wl_block45);

		}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(checkedAttribute));
            _bw.write(_wl_block58Bytes, _wl_block58);

	i++;
		checkedAttribute	=	"";
		targetPeriod		=	"";
		targetPeriodType	=	"";
		practitionerType1	=	"";
		//maxGrpID			=	"";
		db_action			=	"";
		readonly			=	"";
		disabled			=	"";
}

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(start));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(end));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block68Bytes, _wl_block68);
	
		}else{

            _bw.write(_wl_block69Bytes, _wl_block69);

}
	}
}
catch(Exception e){
	
	System.err.println(e.toString());
		e.printStackTrace();
}finally{
	if(rs!=null)
		rs.close();
	if(rs1!=null)
		rs1.close();
	if(stmt!=null)
		stmt.close();
	if(stmt1!=null)
		stmt1.close();
	//common-icn-0180 starts
	if(pstmt!=null)
		pstmt.close();
	if(pstmt1!=null)
		pstmt1.close();
	if(pstmt2!=null)
		pstmt2.close();
	//common-icn-0180 ends
	ConnectionManager.returnConnection(connection,request);

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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.GoalDescription.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.TargetPeriod.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.InterventionsOutcomes.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
