package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __icdcodefortablistqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ICDCodeForTabListQueryResult.jsp", 1732536272556L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n     <head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t<script language=\'javascript\' src=\'../js/ICDCodeForTabList.js\'></script>\n\t<script>\n\tfunction callchk(obj)\n\t{\n\t\t if(obj.checked==true)\n         {\n\t\t\tobj.value=\"Y\"\n\t  \t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\tobj.value=\"N\"\n\t\t}\n\t}\n\t</script>\n    \n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  OnMouseDown=\"CodeArrest()\" onLoad=\"FocusFirstElement();\" onKeyDown = \'lockKey()\'>\n<form name=\'tablistQueryResult\' id=\'tablistQueryResult\' method=\"post\" action=\"../../eMR/jsp/ICDCodeForTabListQueryResult.jsp\"   >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!--<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>-->\n\t<table border=\'1\' cellpadding=\'1\' cellspacing=\'1\' width=\'100%\' align=\'center\'>\n\n\t<tr>\n\t\t<td><a href=\"javascript:callMember(\'A\')\">A</a></td>\n\t\t<td><a href=\"javascript:callMember(\'B\')\">B</a></td>\n\t\t<td><a href=\"javascript:callMember(\'C\')\">C</a></td>\n\t\t<td><a href=\"javascript:callMember(\'D\')\">D</a></td>\n\t\t<td><a href=\"javascript:callMember(\'E\')\">E</a></td>\n\t\t<td><a href=\"javascript:callMember(\'F\')\">F</a></td>\n\t\t<td><a href=\"javascript:callMember(\'G\')\">G</a></td>\n\t\t<td><a href=\"javascript:callMember(\'H\')\">H</a></td>\n\t\t<td><a href=\"javascript:callMember(\'I\')\">I</a></td>\n\t\t<td><a href=\"javascript:callMember(\'J\')\">J</a></td>\n\t\t<td><a href=\"javascript:callMember(\'K\')\">K</a></td>\n\t\t<td><a href=\"javascript:callMember(\'L\')\">L</a></td>\n\t\t<td><a href=\"javascript:callMember(\'M\')\">M</a></td>\n\t\t<td><a href=\"javascript:callMember(\'N\')\">N</a></td>\n\t\t<td><a href=\"javascript:callMember(\'O\')\">O</a></td>\n\t\t<td><a href=\"javascript:callMember(\'P\')\">P</a></td>\n\t\t<td><a href=\"javascript:callMember(\'Q\')\">Q</a></td>\n\t\t<td><a href=\"javascript:callMember(\'R\')\">R</a></td>\n\t\t<td><a href=\"javascript:callMember(\'S\')\">S</a></td>\n\t\t<td><a href=\"javascript:callMember(\'T\')\">T</a></td>\n\t\t<td><a href=\"javascript:callMember(\'U\')\">U</a></td>\n\t\t<td><a href=\"javascript:callMember(\'V\')\">V</a></td>\n\t\t<td><a href=\"javascript:callMember(\'W\')\">W</a></td>\n\t\t<td><a href=\"javascript:callMember(\'X\')\">X</a></td>\n\t\t<td><a href=\"javascript:callMember(\'Y\')\">Y</a></td>\n\t\t<td><a href=\"javascript:callMember(\'Z\')\">Z</a></td>\n\t\t<td><a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a></td>\n\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t<tr id=\"prevnext\">\n\t\t\t\t<td align=\'right\' colspan=\'3\'>\n\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\n\t\t\t<a align= \'right\' id=\'prev\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t\t\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<a align=\'left\' id=\'next\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a>\n\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t\t\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</td></tr>\n\n\n\t<tr id=\'header\'>\n\t\t<th nowrap>Term Code  </th>\n\t\t<th> ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t<th> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t</tr>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<tr>\n\t\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' width=\"10%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t<td  class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' width=\'82%\'> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n \n\t\t<td align=\'center\' width=\'8%\' class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<input type=\'checkbox\'  onclick=\"callchk(this);\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" name=\"icdCodeNum";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" checked value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t  \t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t</td>\n\t    </tr>\n\t\t\t<input type=\"hidden\" name=\"tab_list_no";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"tab_list_no";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type=\"hidden\" name=\"diag_srl_no";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"diag_srl_no";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t <script>\n\t\t if (document.getElementById(\"next\"))\n\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t</script>\n\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t <input type=\'hidden\' name=\'concat_string\' id=\'concat_string\' value=\'\'>\n\t        <input type=\'hidden\' name=\'recVals\' id=\'recVals\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<input type=\'hidden\' name=\'age_spec\' id=\'age_spec\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n\t\t\t<input type=\'hidden\' name=\'tabulation_list\' id=\'tabulation_list\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >\n\t\t\t<input type=\'hidden\' name=\'selectedAlpha\' id=\'selectedAlpha\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\n\t\t\t<input type=hidden name=\'alphadescription\' id=\'alphadescription\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=hidden name=\'searchby\' id=\'searchby\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t<input type=hidden name=\'searchcrt\' id=\'searchcrt\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\' name=\'diag_code_scheme\' id=\'diag_code_scheme\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >\n\t\t\t<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' >\n\t\t\t<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t<input type=\'hidden\' name=\'maxRecord\' id=\'maxRecord\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\n  \t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n\t \n</form>\n</body>\n\n\n</html>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
        Connection conlConn = null;
//        int initCount = 1;
        
        //java.sql.Statement stmt		= null;
        //ResultSet rstlRs	= null;
        java.sql.Statement stmt1		= null;
        ResultSet rstlRs1	= null;
       // PreparedStatement stmt2		= null;
        //ResultSet rstlRs2	= null;
        
        //PreparedStatement stmt3		= null;
        //ResultSet rstlRs3	= null;
		int maxRecord = 0;
		String alphadescription="";
		String searchby="";
		String searchcrt="";
	int start = 0 ;
	int end = 0 ;
	String from	= checkForNull(request.getParameter("from"));
	String to	= checkForNull(request.getParameter("to"));

	if (from == null || from == "")
	{ 
		start = 0 ;  
	}   
	else 
	{  
		start = Integer.parseInt( from ) ; 
	}

	if (to == null || to == ""){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }


 try
 {
	 conlConn = ConnectionManager.getConnection(request);
	 String tabulation_list = request.getParameter("tabulation_list");
		if(tabulation_list == null) tabulation_list="";
	String orderBy = request.getParameter("orderBy");
		if(orderBy == null) orderBy="";
		
	searchby					= checkForNull(request.getParameter("searchby"));
	searchcrt					= checkForNull(request.getParameter("searchcrt"));
	alphadescription				= checkForNull(request.getParameter("alphadescription"));	
 

	 String age_spec = request.getParameter("age_spec");
		if(age_spec == null) age_spec="";
		if(age_spec.equals("P")) age_spec="O";
		
	 String selectedAlpha = request.getParameter("selectedAlpha");
		if(selectedAlpha == null) selectedAlpha="";
	String term_set_id = request.getParameter("term_set_id");
		if(term_set_id == null) term_set_id="";

	String diag_code_scheme = request.getParameter("diag_code_scheme");
		if(diag_code_scheme == null) diag_code_scheme="";
        
//           int i=1;
			int j=0;
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
      

	StringBuffer sqlfirst = new StringBuffer();
	StringBuffer sqlsecond = new StringBuffer();
	StringBuffer sqlwherefirst =new StringBuffer();
	StringBuffer sqlwheresecond =new StringBuffer();


	sqlfirst.append("");
	sqlsecond.append("");
	sqlwherefirst.append("");
	sqlwheresecond.append("");

	sqlfirst.append("SELECT NULL TAB_LIST_NO, TERM_CODE, SHORT_DESC, 'N' CHKD FROM MR_TERM_CODE WHERE TERM_SET_ID = '"+term_set_id+"' AND ");

	sqlsecond.append(" AND (TERM_SET_ID, TERM_CODE) NOT IN ( SELECT TERM_SET_ID, TERM_CODE FROM MR_TERM_CODE_FOR_TAB_LIST WHERE TAB_LIST_NO ='"+tabulation_list+"') UNION SELECT A.TAB_LIST_NO, B.TERM_CODE, B.SHORT_DESC, 'Y' CHKD FROM MR_TERM_CODE_FOR_TAB_LIST A, MR_TERM_CODE B WHERE A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND A.TAB_LIST_NO = '"+tabulation_list+"' AND " );
	if(!alphadescription.equals(""))
	{  
		if(searchby.equals("D"))
		{
			if(searchcrt.equals("C"))
				sqlwherefirst.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwherefirst.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwherefirst.append(" UPPER (SHORT_DESC) LIKE  UPPER( '"+alphadescription+"%')");
		}
		else if(searchby.equals("C"))
		{
			if(searchcrt.equals("C"))
				sqlwherefirst.append(" UPPER (TERM_CODE ) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwherefirst.append(" UPPER (TERM_CODE) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwherefirst.append(" UPPER (TERM_CODE) LIKE  UPPER( '"+alphadescription+"%')");
		}
		if(searchby.equals("D"))
		{
			if(searchcrt.equals("C"))
				sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '"+alphadescription+"%')");
		}
		else if(searchby.equals("C"))
		{
			if(searchcrt.equals("C"))
				sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+alphadescription+"%')");
			else if(searchcrt.equals("E"))
				sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+alphadescription+"')");
			else if(searchcrt.equals("S"))
				sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '"+alphadescription+"%')");
		}
	}
	else
	{
		if(selectedAlpha.equals("Others"))
		{

			sqlwherefirst.append(" UPPER(SUBSTR("+orderBy+",1,1)) NOT BETWEEN 'A' AND 'Z' ");
			sqlwheresecond.append(" UPPER(SUBSTR("+orderBy+",1,1)) NOT BETWEEN 'A' AND 'Z' ");
		}
		else
		{
			sqlwherefirst.append(" UPPER("+orderBy+") LIKE '"+selectedAlpha+"%'");
			if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
					sqlwherefirst.append(" AND UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwherefirst.append(" AND UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwherefirst.append(" AND UPPER (SHORT_DESC) LIKE  UPPER( '"+selectedAlpha+"%')");
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
					sqlwherefirst.append(" AND UPPER (TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwherefirst.append(" AND UPPER (TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwherefirst.append(" AND UPPER (TERM_CODE) LIKE  UPPER( '"+selectedAlpha+"%')");
			}

			if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
					sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwheresecond.append(" UPPER (SHORT_DESC) LIKE  UPPER( '"+selectedAlpha+"%')");
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
					sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"%')");
				else if(searchcrt.equals("E"))
					sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '%"+selectedAlpha+"')");
				else if(searchcrt.equals("S"))
					sqlwheresecond.append(" UPPER (A.TERM_CODE) LIKE  UPPER( '"+selectedAlpha+"%')");
			}
		}
	}
	sqlfirst.append(sqlwherefirst);  
	sqlfirst.append(sqlsecond);  
	sqlfirst.append(sqlwheresecond);  
	
	
	sqlfirst.append(" ORDER BY  "+orderBy+" " );
	//stmt1 = conlConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stmt1 = conlConn.createStatement();
	rstlRs1 = stmt1.executeQuery(sqlfirst.toString());
	//rstlRs1.last();
	 //maxRecord  = rstlRs1.getRow();
	//rstlRs1.beforeFirst();
	
	
//		if (maxRecord==0)
//	{


            _bw.write(_wl_block8Bytes, _wl_block8);
	 if(!alphadescription.equals("")) {} else {
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
	
		if(!(start <= 1)) 
		{	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
	}
		
		if(((start+14) >= maxRecord ))
		{	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
	}	
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 
//			}
	String classValue = "" ;
//	String diag_srl_no="";
	String chkAttribute="";
	String tab_list="";
	String diag_srlno="";
	String box_value="";
	StringBuffer recVals = new StringBuffer("");
	boolean first = true;
	/*if(maxRecord==0)
	 {
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	 }
	 else{*/
	 int i=1;
	 if(start != 0)
		{
			for(i=1; i<=start; i++)
			{
				rstlRs1.next() ;
			}
		}
			while(rstlRs1.next() && i<=end)
		{
	
	tab_list=rstlRs1.getString("TERM_CODE");
	//diag_srlno=rstlRs1.getString("DIAG_SRL_NO");
	if ( i % 2 == 0 )
	classValue = "QRYEVEN" ;
	else
	classValue = "QRYODD" ;
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tab_list));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rstlRs1.getString("SHORT_DESC")));
            _bw.write(_wl_block25Bytes, _wl_block25);

		if(rstlRs1.getString("CHKD").equals("Y"))
			{
			chkAttribute = "CHECKED";
			 box_value="Y";
			}
		else
			{
			chkAttribute = "";
			box_value="N";
			}
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

			if ( first )
			{
					recVals.append("('");
					first = false;
			}
			recVals.append(diag_srlno+"','");
        if(chkAttribute.equals("CHECKED")){
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(box_value));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else {
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(box_value));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tab_list));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(diag_srlno));
            _bw.write(_wl_block39Bytes, _wl_block39);

		i++;
		maxRecord++;
	   
	  } 
	  if ( ! first)
	 {
		  recVals.delete(recVals.length()-3,recVals.length()-1);
		  recVals.append(")");
	  }
	  if(maxRecord==0)
	 {
			if(!alphadescription.equals(""))
		    {
			  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			  out.println("<script>parent.frames[1].document.location.href='../../eCommon/html/blank.html';</script>");
			}
			else{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			    out.println("<script>parent.frames[1].document.getElementById(\"header\").style.visibility='hidden';</script>");	
			    out.println("<script>parent.frames[1].document.getElementById(\"prevnext\").style.visibility='hidden';</script>");	
				}
	 }

	 if (maxRecord<14 || (!rstlRs1.next()))
	 {
            _bw.write(_wl_block40Bytes, _wl_block40);
 }
	else
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}
	
	
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recVals.toString()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(age_spec));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tabulation_list));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(selectedAlpha));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alphadescription));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(searchby));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(searchcrt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orderBy));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(start));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(end));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(start));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(end));
            _bw.write(_wl_block57Bytes, _wl_block57);
    
sqlfirst.setLength(0);
sqlsecond.setLength(0);
sqlwherefirst.setLength(0);
sqlwheresecond.setLength(0);
//sqlCount.setLength(0);
	
}
catch(Exception e){
    	//out.println("Exception @ try "+e.toString());   
		e.printStackTrace();
    }
	finally
	{
		try
		{
		//if(rstlRs != null){ rstlRs.close(); }
		//if(stmt != null){ stmt.close(); }
		if(rstlRs1 != null){ rstlRs1.close(); }		
		if(stmt1 != null){ stmt1.close(); }
		//if(rstlRs2 != null){ rstlRs2.close(); }
		//if(stmt2 != null){ stmt2.close(); }
		//if(rstlRs3 != null)rstlRs3.close();
		//if(stmt3 != null){ stmt3.close(); }
		}
		catch(Exception e){
		//out.println("Exception @ finally "+e.toString());
		e.printStackTrace();
    }
		session.setAttribute("AXSRightRecSet", accessRightRecSet);
		ConnectionManager.returnConnection(conlConn,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TITLE.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
