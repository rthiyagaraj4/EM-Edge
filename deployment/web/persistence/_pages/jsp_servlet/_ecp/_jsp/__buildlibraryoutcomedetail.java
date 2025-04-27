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
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __buildlibraryoutcomedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/BuildLibraryOutcomeDetail.jsp", 1742797780995L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\' ></SCRIPT>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t\t<SCRIPT language=\"javascript\" src=\"../js/BuildLibrary.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</HEAD>\n<BODY onKeyDown = \'lockKey()\';  OnMouseDown=\"CodeArrest()\">\n<FORM name=\"formBuildLibraryOutcomeDetails\" id=\"formBuildLibraryOutcomeDetails\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t<TR>\n\t\t<TD width=\"55%\" class=\"white\">&nbsp;</TD>\n\t\t<TD width=\"10%\" class=\"white\">&nbsp;</TD>\n\t\t<TD align=\"right\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<label onClick=\'Outcomenavigation(document.formBuildLibraryOutcomeDetails,\"previous\")\'  style=\'cursor:pointer;color:blue\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</label>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<label onClick=\'Outcomenavigation(document.formBuildLibraryOutcomeDetails,\"next\")\'  style=\'cursor:pointer;color:blue\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</label>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</TD></TR></TABLE>\n\n<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'100%\' >\n\t<TH width=\"47%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</TH>\n\t<TH >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TH>\n\t<TH width=\"20%\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TH>\n\t<TH width=\"4%\" >&nbsp;</TH>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<TR>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<INPUT type=\"hidden\" name=\"outcomeDesc";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"outcomeDesc";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" align=\"center\">\n\t\t\t<SELECT name=\"Nature";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"Nature";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onchange=\"updateOutcomeList(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\">\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<OPTION ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</OPTION>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<OPTION  value=\"X\">X</OPTION>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</SELECT></TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" align=\"center\"><INPUT type=\"text\"  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" size=\"1\" name=\"targetPeriod";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\'  onblur=\"updateOutcomeList(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\">\n\t\t\t<SELECT name=\"targetPeriodType";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"targetPeriodType";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" align=\"center\" >\n\t\t\t\t<INPUT type=\"checkBox\" name=\"select";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"select";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onclick=\"updateOutcomeList(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\">\n\t\t</TD>\n\t</TR>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</TABLE>\n\t<BR>\n<DIV align=\'right\'>\n<TABLE  cellpadding=\'0\' cellspacing=\'0\' >\n\t<TR>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<TD >\n\t\t\t<INPUT type=\'button\' name=\'close\' id=\'close\' value=\'Create New Group\' onClick=\'ChkNewGrp(\"new1\")\' class=\'button\'>\n\t\t</TD> \n\t\t<TD >\n\t\t\t&nbsp;<INPUT type=\'button\' name=\'close\' id=\'close\' value=\'Close\' onClick=\'ChkNewGrp(\"close\");\' class=\'button\'>\n\t\t</TD>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t <TD >\n\t\t\t<INPUT type=\'button\' name=\'close\' id=\'close\' value=\'Create New Group\' onClick=\"ChkNewGrp(\'new\');LoadPages(\'0\',\'0\');\" class=\'button\'> \n\t\t</TD>  \n\t\t <TD >\n\t\t\t&nbsp;<INPUT type=\'button\' name=\'close\' id=\'close\' value=\'Close\' onClick=\'ChkNewGrp(\"new\");closeW()\' class=\'button\'>\n\t\t</TD> \n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t</TR>\n</TABLE>\n\t\n<INPUT type=\"hidden\" name=\"start\" id=\"start\"     value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<INPUT type=\"hidden\" name=\"end\" id=\"end\"       value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<INPUT type=\"hidden\" name=\"alphalink\" id=\"alphalink\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<INPUT type=\"hidden\" name=\"termSet\" id=\"termSet\"   value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<INPUT type=\"hidden\" name=\"termCode\" id=\"termCode\"  value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<INPUT type=\"hidden\" name=\"goalCode\" id=\"goalCode\"  value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<INPUT type=\"hidden\" name=\"libraryid\" id=\"libraryid\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<INPUT type=\"hidden\" name=\"versionno\" id=\"versionno\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<INPUT type=\"hidden\" name=\"tableName\" id=\"tableName\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">          \n<INPUT type=\"hidden\" name=\"maxGrpID\" id=\"maxGrpID\"  value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<INPUT type=\"hidden\" name=\"GroupID\" id=\"GroupID\"   value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t<!-- <SCRIPT>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\"));</SCRIPT> -->\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\n</BODY>\n</FORM>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

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

String alphalink				=	request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
String termSet					=	request.getParameter("termSet");
String termCode					=	request.getParameter("termCode");
String goalCode					=	request.getParameter("goalCode");
String libraryid				=	request.getParameter("libraryid");
String versionno				=	request.getParameter("versionno");
String tableName				=	request.getParameter("tableName");
String maxGrpID					=	request.getParameter("maxGrpID");
String GroupID1					=	request.getParameter("GroupID");
int GroupID						=	Integer.parseInt(GroupID1);
//out.println("GroupID  "+GroupID);
//out.println("maxGrpID  "+maxGrpID);

String GrpID					=	"";
alphalink						=	alphalink.trim();
Connection connection			=	null;
Statement stmt					=	null;
PreparedStatement pstmt			=	null;
ResultSet rs					=	null;
Statement stmt1					=	null;
ResultSet rs1					=	null;
String from						=	request.getParameter("from") ;
String to						=	request.getParameter("to") ;
String classValue				=	"";
String  sqlData					=	"";
String outcomeCode				=	"";
String outcomeDesc				=	"";
//String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id='"+locale+"'";//common-icn-0180
String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id= ?";//common-icn-0180
String sqlNature				=	"SELECT NATURE_APPL_YN FROM MR_TERM_SET WHERE  TERM_SET_ID=?";
String sqlNaturetype			=	"";
String Status					=	"";
String potential				=	"";
String wellness					=	"";
String  actual					=	"";
String disabled					=	"";
String readonly					=	"";
String targetPeriod				=	"";
String targetPeriodType			=	"";
String targetPeriodTypeSelect	=	"";
String tempTargetPeriodType		=	"";
String NatureValue				=	"";
String tempNature				=	"";
String NatureSelect				=	"";
String chkStatus				=	"";
String chkAttribute				=	"";
String tempTermSet				=	"";
String tempTermCode				=	"";
String curGroupID				=	"";

ArrayList Nature				=	new ArrayList();
ArrayList DurationList			=	new ArrayList();
ArrayList TermCodeList			=	null;
ArrayList Goal					=	null;
HashMap	interventionOutcome		=	null;
ArrayList Outcome				=	null;
int GrpID1						=	0;
int maxRecord					=	0;
int start						=	0 ;
int end							=	0 ;
int i							=	1;
if(!GroupID1.equals("0")){
	maxGrpID=GroupID1;
}
//out.println("maxGrpID"+maxGrpID);
//out.println("GroupID1"+GroupID1);

 if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
 if (to == null){ end = 5 ; }   else {  end = Integer.parseInt( to ) ; }

 ArrayList sessionList				=		(ArrayList)BuildLibrary.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		TermCodeList=(ArrayList)BuildLibrary.getObject(0);
	}

	
if(alphalink.equals("Associated") && !GroupID1.equals("0")){
	//sqlData="SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
	sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC FROM CP_OUTCOME_LANG_VW WHERE OUTCOME_CODE IN (";
	boolean first_time=true;
	for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet	=	(String)TermCodeList.get(j);
				 tempTermCode	=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal			=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Outcome				=	(ArrayList)interventionOutcome.get("O");
						 if(Outcome.size()>0){
							 for(int k=0;k<Outcome.size();k=k+8){
								 curGroupID=(String)Outcome.get(k+1);
								 if(GroupID1.equals(curGroupID)){
									// System.err.println("inside if");
									 if(!first_time)
										 sqlData =sqlData+",";
									 if(first_time){
										 sqlData =sqlData+"'"+(String)Outcome.get(k)+"'";
										 first_time=false;
									 }
									 else{
										sqlData =sqlData+"'"+(String)Outcome.get(k)+"'";
									 }
								 }

							 }
						 }
					}
				}
	}
	//sqlData=sqlData+") AND LANGUAGE_ID = '"+locale+"' AND OUTCOME_TYPE='O' ORDER BY OUTCOME_DESC";
	sqlData=sqlData+") AND LANGUAGE_ID = ? AND OUTCOME_TYPE='O' ORDER BY OUTCOME_DESC";
				
						
	}
else if(!GroupID1.equals("0")|| !alphalink.equals("Associated"))
{
	//sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC, TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) OUTCOME_TARGET_DURN, TO_CHAR(NULL) OUTCOME_TARGET_DURN_UNIT, TO_CHAR(NULL) APPL_NATURE, 'I' DB_ACTION  FROM  CP_OUTCOME                     WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT OUTCOME_CODE FROM CP_LIBRARY_OUTCOME WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"' AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"' AND GOAL_CODE = '"+goalCode+"')                                                            UNION ALL SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION  FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME                     B WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"' AND  B.OUTCOME_CODE = A.OUTCOME_CODE   AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z' ))                                                               ORDER BY OUTCOME_DESC";
	  //sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC, TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) OUTCOME_TARGET_DURN, TO_CHAR(NULL) OUTCOME_TARGET_DURN_UNIT, TO_CHAR(NULL) APPL_NATURE, 'I' DB_ACTION  FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT OUTCOME_CODE FROM CP_LIBRARY_OUTCOME WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"' AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"' AND GOAL_CODE = '"+goalCode+"') AND OUTCOME_TYPE='O' AND LANGUAGE_ID = '"+locale+"' UNION ALL SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION  FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"' AND  B.OUTCOME_CODE = A.OUTCOME_CODE   AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z' )) AND B.LANGUAGE_ID = '"+locale+"' ORDER BY OUTCOME_DESC";//common-icn-0180
	  sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC, TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) OUTCOME_TARGET_DURN, TO_CHAR(NULL) OUTCOME_TARGET_DURN_UNIT, TO_CHAR(NULL) APPL_NATURE, 'I' DB_ACTION  FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT OUTCOME_CODE FROM CP_LIBRARY_OUTCOME WHERE LIBRARY_ID = ? AND VERSION_NO = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND GOAL_CODE = ?) AND OUTCOME_TYPE='O' AND LANGUAGE_ID = ? UNION ALL SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION  FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ? AND  B.OUTCOME_CODE = A.OUTCOME_CODE   AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z' )) AND B.LANGUAGE_ID = ? ORDER BY OUTCOME_DESC";//common-icn-0180

}

try{
	connection	=	ConnectionManager.getConnection(request);
	//stmt1		=	connection.createStatement();//common-icn-0180
	pstmt = connection.prepareStatement(sqlDurationType);//common-icn-0180
	pstmt.setString(1,locale);//common-icn-0180
	rs1			=	pstmt.executeQuery();//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlDurationType);//common-icn-0180

	if(rs1!=null){
		while(rs1.next()){
			DurationList.add(rs1.getString("DURN_TYPE"));
			DurationList.add(rs1.getString("DURN_DESC"));

		}
	}
	rs1.close();

		//rs1=stmt1.executeQuery(sqlNature);
					pstmt = connection.prepareStatement( sqlNature);
					pstmt.setString(1,termSet);
					rs1=pstmt.executeQuery();

			if(rs1!=null && rs1.next()){
			Status	=	rs1.getString("NATURE_APPL_YN");
			//out.println("tableName "+tableName);
			}
			rs1.close();
			if(Status.equals("Y"))
			{
				//sqlNaturetype	=	"SELECT  term_set_id,term_code,ACTUAL_YN,POTENTIAL_YN,WELLNESS_YN FROM "+tableName+" where  term_set_id='"+termSet+"' and term_code='"+termCode+"'";//common-icn-0180
				sqlNaturetype	=	"SELECT  term_set_id,term_code,ACTUAL_YN,POTENTIAL_YN,WELLNESS_YN FROM "+tableName+" where  term_set_id=? and term_code=?";//common-icn-0180
				
				
				pstmt = connection.prepareStatement(sqlNaturetype);//common-icn-0180
				pstmt.setString(1,termSet);//common-icn-0180
				pstmt.setString(2,termCode);//common-icn-0180
				rs1				=	pstmt.executeQuery();//common-icn-0180
				//rs1				=	stmt1.executeQuery(sqlNaturetype);//common-icn-0180
				if(rs1 !=null && rs1.next()){					
					potential	=	rs1.getString("POTENTIAL_YN");
					wellness	=	rs1.getString("WELLNESS_YN");
					actual		=	rs1.getString("ACTUAL_YN");
					System.err.println("potential "+potential+"wellness "+wellness+"actual "+actual);
					if(potential.equals("Y")){
						Nature.add("P");
						Nature.add("Potiental");
					}
					if(actual.equals("Y")){
						Nature.add("A");
						Nature.add("Actual");
					}
					if(actual.equals("Y") && potential.equals("Y")){
						Nature.add("B");
						Nature.add("Both");
					}
					if(wellness.equals("Y")){
						//Nature.clear();
						Nature.add("W");
						Nature.add("Wellness");
					}
				}
			}
			//System.err.println("Nature  "+Nature);
	
	//stmt	=	connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	int pstmtcount=1;//common-icn-0180
	if(!sqlData.equals("")){
	pstmt=connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	//common-icn-0180 starts
	if(alphalink.equals("Associated") && !GroupID1.equals("0")){
	pstmt.setString(pstmtcount++, locale);
	}
	else if(!GroupID1.equals("0")|| !alphalink.equals("Associated")){
		pstmt.setString(pstmtcount++, libraryid);	
		pstmt.setString(pstmtcount++, versionno);	
		pstmt.setString(pstmtcount++, termSet);	
		pstmt.setString(pstmtcount++, termCode);
		pstmt.setString(pstmtcount++, goalCode);
		pstmt.setString(pstmtcount++, locale);
		pstmt.setString(pstmtcount++, libraryid);	
		pstmt.setString(pstmtcount++, versionno);	
		pstmt.setString(pstmtcount++, termSet);	
		pstmt.setString(pstmtcount++, termCode);
		pstmt.setString(pstmtcount++, goalCode);
		pstmt.setString(pstmtcount++, locale);
	}
	//common-icn-0180 ends
	//System.err.println("sqlData "+sqlData);
	if(!sqlData.equals("")){
	//rs		=	stmt.executeQuery(sqlData);//common-icn-0180
	rs		=	pstmt.executeQuery();//common-icn-0180
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
		if ( !( (start+5) >= maxRecord ) )
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
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
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

			outcomeCode	=	rs.getString("OUTCOME_CODE");
			outcomeDesc	=	rs.getString("OUTCOME_DESC");


			for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet	=	(String)TermCodeList.get(j);
				 tempTermCode	=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal			=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Outcome				=	(ArrayList)interventionOutcome.get("O");
						 if(Outcome.size()>0){
							 if(Outcome.contains(outcomeCode)){
								int index1			=	Outcome.indexOf(outcomeCode);
								NatureValue			=	(String)Outcome.get(index1+2);
								targetPeriod		=	(String)Outcome.get(index1+3);
								targetPeriodType	=	(String)Outcome.get(index1+4);
								chkStatus			=	(String)Outcome.get(index1+5);
								GrpID				=	(String)Outcome.get(index1+1);
								if(!GrpID.equals(""))
									GrpID1				=	Integer.parseInt(GrpID);

								if(targetPeriod==null)
									targetPeriod="";

								if(chkStatus.equals("Y"))
									chkAttribute="checked";
								else
									chkAttribute="";
							 }
						 }
					}
				}
			}

			if(!alphalink.equals("Associated")){
				if(GroupID>0 && GroupID==GrpID1){
					disabled	=	"Disabled";
					readonly	=	"readonly";
				}
				else{
					disabled	=	"";
					readonly	=	"";
				}
			}
		
//			System.err.println("condition in outcome "+(GrpID.equals("")|| (GroupID>0 && GroupID==GrpID1)));
//			System.err.println("GrpID "+GrpID);
		if(GrpID.equals("")|| (GroupID>0 && GroupID==GrpID1)){	

	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(outcomeDesc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(outcomeDesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
		if(Status.equals("Y"))
			{
				if(Nature.size()>0)
				{
					for(int k=0;k<Nature.size();k=k+2)
					{
						tempNature=(String)Nature.get(k);
						if(NatureValue.equals(tempNature))
							NatureSelect="Selected";
						else
							NatureSelect="";
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(NatureSelect));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Nature.get(k)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Nature.get(k+1)));
            _bw.write(_wl_block31Bytes, _wl_block31);
		}
				}
			}
			else
			{
	
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
	
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(targetPeriod));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
for(int k=0;k<DurationList.size();k=k+2){
					tempTargetPeriodType=(String)DurationList.get(k);
					if(targetPeriodType.equals(tempTargetPeriodType))
						targetPeriodTypeSelect="Selected";
					else
						targetPeriodTypeSelect="";

			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(targetPeriodTypeSelect));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(DurationList.get(k)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DurationList.get(k+1)));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(outcomeCode));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);

		}
	i++;
			disabled			=	"";
			GrpID				=	"";
			NatureValue			=	"";
			targetPeriod		=	"";
			targetPeriodType	=	"";
			chkAttribute		=	"";
			chkStatus			=	"";
			GrpID1				=	0;

}

            _bw.write(_wl_block48Bytes, _wl_block48);
if(GroupID==0){
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
			//out.println("inside else");
	
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(start));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(end));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(GroupID));
            _bw.write(_wl_block62Bytes, _wl_block62);
	
		}else{

            _bw.write(_wl_block63Bytes, _wl_block63);

}
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
	if(pstmt!=null)
		pstmt.close();
	ConnectionManager.returnConnection(connection,request);

}


            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.OutcomeDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.TargetPeriod.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
