package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __smtranslationmanagerresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/SMTranslationManagerResult.jsp", 1709121725197L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\' </script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../js/TranslationManager.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body onLoad=\'FocusFirstElement()\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"TranslationResult\" id=\"TranslationResult\" method=post  action= \'../../servlet/eSM.SMTranslationManagerServlet\'  target=\"messageFrame\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<p>\n\t\t<table align=\'right\' border=0 >\n\t\t<tr>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</p>\n\t\t<br>\n\t\t<br>\n\t\t<table cellspacing=0 cellpadding=0 align=\"center\" width=\"95%\" border=\"0\">\n\t\t<tr ><td class=data\t align=center style=\"BACKGROUND-COLOR:white;font:12pt\" ><B>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td></td>\n\t\t</table>\n\t\t<table cellspacing=0 cellpadding=0 align=\"center\" width=\"95%\" border=\"0\">\n\t\t<tr> \n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<th align=left>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<th align=left>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </th>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t <th align=left>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t <th align=left>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t<td class=data style=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' ><b>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<td class=data style=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' >&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<input type=hidden name=pk";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" value=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">  \n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td class=data><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</b></td>\n\t\t\t<td class=data ><b>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<td class=data><INPUT TYPE=\"text\" name=\"desc";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="0\" id=\"desc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="0\" onblur=\'return makeValidString(this);\'\tsize=50 maxlength=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' dir=\'RTL\'>  </td>\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >  </td>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<td class=data style=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' ><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td> \n\t\t\t\t\t\t<input type=\"hidden\" name=\"engLang";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"engLang";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t<td class=\'fields\' style=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' ><INPUT TYPE=\"text\" NAME=desc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="  onkeypress=\'cheeckText(event)\' onblur=\'return makeValidString(this);\' maxlength=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" size=70 dir=\'RTL\'></td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" size=70></td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t</tr>\n\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<input type=hidden name=pk";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">  \n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<INPUT TYPE=\"hidden\" name=\'language_direction\' id=\'language_direction\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<INPUT TYPE=\"hidden\" name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<INPUT TYPE=\"hidden\" name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<INPUT TYPE=\"hidden\" name=\'module_id\' id=\'module_id\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<INPUT TYPE=\"hidden\" name=\'masterName\' id=\'masterName\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<INPUT TYPE=\"hidden\" name=\'language\' id=\'language\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<INPUT TYPE=\"hidden\" name=\'display\' id=\'display\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<INPUT TYPE=\"hidden\" name=\'Searchbymod\' id=\'Searchbymod\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<INPUT TYPE=\"hidden\" name=\'SearchbyFunct\' id=\'SearchbyFunct\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\n<INPUT TYPE=\"hidden\" name=\'start_ends_contains\' id=\'start_ends_contains\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<INPUT TYPE=\"hidden\" name=\'searchText\' id=\'searchText\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<INPUT TYPE=\"hidden\" name=\'master_table_id\' id=\'master_table_id\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<INPUT TYPE=\"hidden\" name=\'trans_tab_id\' id=\'trans_tab_id\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<INPUT TYPE=\"hidden\" name=\'cnt\' id=\'cnt\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<INPUT TYPE=\"hidden\" name=\'pkDataCnt\' id=\'pkDataCnt\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<INPUT TYPE=\"hidden\" name=\'flag\' id=\'flag\' value=\"\">\n<INPUT TYPE=\"hidden\" name=\'table_or_from\' id=\'table_or_from\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<INPUT TYPE=\"hidden\" name=\'colsize\' id=\'colsize\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<INPUT TYPE=\"hidden\" name=\'submitformYN\' id=\'submitformYN\' value=\"N\">\n<INPUT TYPE=\"hidden\" name=\'mod_id\' id=\'mod_id\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n<INPUT TYPE=\"hidden\" name=\'report_id\' id=\'report_id\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n \n </table>\n </form>\n </body>\n </html>\n ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

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

     Connection con =null;
	 String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
    try{
		StringBuffer sql=new  StringBuffer();
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String lang="";
		//String facilityId = (String) session.getValue("facility_id");
		String module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
		String mod_id=request.getParameter("mod_id")==null?"":request.getParameter("mod_id");
		String masterName=request.getParameter("masterName")==null?"":request.getParameter("masterName");
		String language=request.getParameter("language")==null?"":request.getParameter("language");
		String language_direction=request.getParameter("language_direction")==null?"":request.getParameter("language_direction");
		//out.println("language_direction==="+language_direction);
		String display=request.getParameter("display")==null?"":request.getParameter("display");
		String searchText=request.getParameter("searchText")==null?"":request.getParameter("searchText");
        searchText=java.net.URLEncoder.encode((String)searchText);//Added by Suji Keerthi for MOHE-SCF-0015
		String searchText1=searchText; 
		String Searchbymod=request.getParameter("Searchbymod")==null?"":request.getParameter("Searchbymod");
		String SearchbyFunct=request.getParameter("SearchbyFunct")==null?"":request.getParameter("SearchbyFunct");
		String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");
		String report_id=request.getParameter("report_id")==null?"":request.getParameter("report_id");
		String legend_key="";
		if(start_ends_contains.equals("S")){
			searchText=searchText+"%";
		}else if(start_ends_contains.equals("E")){
			searchText="%"+searchText;
		}else if(start_ends_contains.equals("C")){
			searchText="%"+searchText+"%";
		}
		String table_or_form="";
		String table_desc=""; 
		int startVal=0;
		String pk2="";
		int colCount=0;
		String classValue="";
		String trans_table_id="";
		String master_table_id=""; 
		String pk1="";
		String temppk2="";
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		ArrayList pkval=new ArrayList();
		ArrayList pkValue=new ArrayList();
	
		ArrayList pkLen=new ArrayList();
		ArrayList pkPrompt=new ArrayList();
		ArrayList columnPrompt=new ArrayList();
		ArrayList columnVal=new ArrayList();

		ArrayList colValue=new ArrayList();
		ArrayList columnLen=new ArrayList();
		int start = 0 ;
		int end = 0 ;
		int maxRecord=0;
     
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt(from) ;
		if ( to == null )
			end = 20 ;
		else
			end = Integer.parseInt(to) ;
		if(!report_id.equals("")){
			pstmt= con.prepareStatement("select legend_key from sm_report where report_id=?");
			pstmt.setString(1,report_id);
			rs = pstmt.executeQuery() ;
			if(rs!=null && rs.next()){
				legend_key=rs.getString("legend_key")==null?"":rs.getString("legend_key");
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}

            _bw.write(_wl_block6Bytes, _wl_block6);
	
	sql.setLength(0);
	sql.append("select * from sm_mapping  where  MASTER_TABLE_ID='"+masterName+"' order by SRL_NO ");	
    pstmt= con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery() ;
	int count=0;
	while(rs.next()){
		table_desc		=rs.getString("table_desc")==null?"":rs.getString("table_desc");
		table_or_form   =rs.getString("table_or_form")==null?"":rs.getString("table_or_form");
		if(rs.getString("pk_yn").equals("Y")){	
			pkval.add(rs.getString("COLUMN_ID")==null?"":rs.getString("COLUMN_ID"));
			pkLen.add(rs.getString("COLUMN_LENGTH")==null?"":rs.getString("COLUMN_LENGTH"));
			pkPrompt.add(rs.getString("COLUMN_PROMPT")==null?"":rs.getString("COLUMN_PROMPT"));
			pkValue.add(rs.getString("TRANS_COLUMN_ID")==null?"":rs.getString("TRANS_COLUMN_ID"));
		}else{		
			columnLen.add(rs.getString("COLUMN_LENGTH")==null?"":rs.getString("COLUMN_LENGTH"));
			columnVal.add(rs.getString("COLUMN_ID")==null?"":rs.getString("COLUMN_ID"));
			columnPrompt.add(rs.getString("COLUMN_PROMPT")==null?"":rs.getString("COLUMN_PROMPT"));
			colValue.add(rs.getString("TRANS_COLUMN_ID")==null?"":rs.getString("TRANS_COLUMN_ID"));
		}
		trans_table_id                  =rs.getString("trans_table_id")==null?"":rs.getString("trans_table_id");
		master_table_id               =rs.getString("master_table_id")==null?"":rs.getString("master_table_id");
		count++;
	}
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	sql.setLength(0);
	if(display.equals("N")){
		sql.append("Select count(*)  total from (Select 'en' LANGUAGE_ID, 1 seq_no," ); 
	}else{
		sql.append("Select count(*)  total from (Select LANGUAGE_ID," ); 
	}
	if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY") && (!display.equals("N"))){
		sql.append("pk_value,");
		for(startVal=0;startVal<columnVal.size();startVal++){
			sql.append("desc"+(startVal+1)+"_Value");
			if(startVal<columnVal.size()-1){
				sql.append(",");
			}
		}
	}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY") && (!display.equals("N"))){
		sql.append("pk1_value,pk2_value,");
		for(startVal=0;startVal<columnVal.size();startVal++){
			sql.append("desc"+(startVal+1)+"_Value");
			if(startVal<columnVal.size()-1){
				sql.append(",");
			}
	   }		
	}else{
		if(!masterName.equals("SM_MASTER_CODE")){
			for( startVal=0;startVal<pkval.size();startVal++){
				sql.append(pkval.get(startVal)+",");	  
			}
		}else{
			sql.append("MODULE_ID,to_char(MASTER_CODE),");
		}
		for( startVal=0;startVal<columnVal.size();startVal++){
			sql.append(columnVal.get(startVal));
			if(startVal<(columnVal.size()-1)){
				sql.append(",");
			}
		}
	}
	if(display.equals("N")){
		sql.append("   FROM  "+masterName+"  WHERE (");
		for( startVal=0;startVal<pkval.size();startVal++){
			sql.append(pkval.get(startVal));
			if(startVal<pkval.size()-1){
				sql.append(",");
			}
		}
		sql.append(")   in (select ");
		for( startVal=0;startVal<pkValue.size();startVal++){
			sql.append(pkValue.get(startVal));
			if(startVal<pkValue.size()-1){
				sql.append(",");
			}
		}	 
		sql.append(" from  "+trans_table_id+"  where ");
		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
			sql.append("table_id='"+masterName+"' and language_id='"+language+"' and desc1_value is null ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals(""))){
				//sql.append(" and module_id='"+Searchbymod+"' ");
				if(masterName.equals("SM_RECORD_TRANS")){
					if(report_id.equals("")){
						sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
					}else{
						sql.append("and  module_id='"+module_id+"' and pk_value like '"+legend_key+"%' ");
					}
				}else{
					if(!Searchbymod.equals("")){
						sql.append(" and module_id='"+Searchbymod+"'");
					}
				}
			}
			if(masterName.equals("SM_FUNCTION_LEGEND")){
				if(!SearchbyFunct.equals("")){
					sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			    }
			 }
			sql.append("  union	 SELECT  '"+language+"' LANGUAGE_ID,2 SEQ_NO, ");	   
		}else{
			sql.append("language_id='"+language+"'  and "+columnVal.get(0)+" is null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals(""))){
				//sql.append(" and module_id='"+Searchbymod+"'");
				if(masterName.equals("SM_RECORD_TRANS")){
					if(report_id.equals("")){
						sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
					}else{
						sql.append("and  module_id='"+module_id+"' and pk_value like '"+report_id+"%' ");
					}
				}else{
					if(!Searchbymod.equals("")){
						sql.append(" and module_id='"+Searchbymod+"'");
					}
				}
			 }
		    if(masterName.equals("SM_FUNCTION_LEGEND")){
				if(!SearchbyFunct.equals("")){
					sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			    }
			 }
			 sql.append(" union	 SELECT  '"+language+"' LANGUAGE_ID,2 SEQ_NO," );
		}
		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
			sql.append("pk_value,");
			for(startVal=0;startVal<columnVal.size();startVal++){
				sql.append("desc"+(startVal+1)+"_Value");
				if(startVal<columnVal.size()-1){
					sql.append(",");
				}
			}
		}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
			sql.append("pk1_value,pk2_value,");
			for(startVal=0;startVal<columnVal.size();startVal++){
				sql.append("desc"+(startVal+1)+"_Value");
				if(startVal<columnVal.size()-1){
					sql.append(",");
			  }
			}
		}else{
			for(startVal=0;startVal<pkval.size();startVal++){
				sql.append(pkval.get(startVal)+",");
			}
			for(startVal=0;startVal<columnVal.size();startVal++){
				sql.append(columnVal.get(startVal));
				if(startVal<columnVal.size()-1){
					sql.append(",");
				}
			}
		}
		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
			sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and language_id = '"+language+"' and table_id='"+masterName+"'");
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
				if(!Searchbymod.equals("")){
					sql.append(" and pk_value='"+Searchbymod+"')");
				}else{
					sql.append(")");
				}
			}else{
				sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");			 
			}
		}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
			sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and language_id = '"+language+"' and table_id='"+masterName+"'");
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
				if(!Searchbymod.equals("")){
					sql.append(" and pk1_value='"+Searchbymod+"'");
				}
			}
			sql.append(" AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			if(masterName.equals("SM_MASTER_CODE")){
				sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			}else{
				 sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			}		
		}else{
			sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is null and language_id = '"+language+"' " ); 
		  	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals(""))){
				//sql.append(" and module_id='"+Searchbymod+"'");
				if(masterName.equals("SM_RECORD_TRANS")){
					if(report_id.equals("")){
						sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
					}else{
						sql.append("and  module_id='"+module_id+"' and pk_value like '"+legend_key+"%' ");
					}
				}else{
					if(!Searchbymod.equals("")){
						sql.append(" and module_id='"+Searchbymod+"'");
					}
				}
			}
			if(masterName.equals("SM_FUNCTION_LEGEND")){
				if(!SearchbyFunct.equals("")){
					sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			    }
			}
			sql.append( " and  (");
			for( startVal=0;startVal<pkValue.size();startVal++){
				sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1){
					sql.append(",");
				}
			}
			sql.append(" ) IN (SELECT ");
			for( startVal=0;startVal<pkValue.size();startVal++){
				sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1){
					sql.append(",");
				}
			}
			sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");			
		}
	}else  if(display.equals("T")){
		sql.append("   from "+trans_table_id+" where language_id in ('en','"+language+"') and (");  
		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
			sql.append("pk_value");		
		}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
			sql.append("pk1_value,pk2_value");		  
		}else{
			for( startVal=0;startVal<pkval.size();startVal++){
				sql.append(pkval.get(startVal));
			    if(startVal<pkval.size()-1){
					sql.append(",");
				}
			}
		}sql.append(")   in( Select " );
		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
			sql.append(" pk_value");
		}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
			sql.append("pk1_value,pk2_value");
		}else{
			for( startVal=0;startVal<pkval.size();startVal++){
				sql.append(pkval.get(startVal));
				if(startVal<pkval.size()-1){
					sql.append(",");
				}
			}	  
		}
		sql.append("  FROM  "+trans_table_id+"  WHERE   ");
		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
			sql.append(" TABLE_ID (+) = '"+masterName+"'  and desc1_value  is not null and LANGUAGE_ID ='"+language+"'");
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
				if(!Searchbymod.equals("")){ 
					sql.append(" and pk_value='"+Searchbymod+"'))");
				}else{
					sql.append(")");
				}
			}else{
				sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
				sql.append(" and  TABLE_ID (+) = '"+masterName+"')");
			}
		}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
			sql.append(" TABLE_ID (+) = '"+masterName+"'  and desc1_value  is not null and LANGUAGE_ID ='"+language+"')");
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
				if(!Searchbymod.equals("")){ 
					sql.append(" and pk1_value='"+Searchbymod+"'");
				}
			 }
			 sql.append(" AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			 if(masterName.equals("SM_MASTER_CODE")){
				 sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }else{
				sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }
		}else{
			sql.append( columnVal.get(0)+" is not null and language_id='"+language+"' ");
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals(""))){
				/*if(!Searchbymod.equals("")){ 
					 sql.append(" and module_id='"+Searchbymod+"'");
				}*/
				if(masterName.equals("SM_RECORD_TRANS")){
					if(report_id.equals("")){
						sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
					}else{
						sql.append("and  module_id='"+module_id+"' and pk_value like '"+legend_key+"%' ");
					}
				}else{
					if(!Searchbymod.equals("")){
						sql.append(" and module_id='"+Searchbymod+"'");
					}
				}
				if(masterName.equals("SM_FUNCTION_LEGEND")){
					if(!SearchbyFunct.equals("")){
						sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
					}
				}
			}
			sql.append( " and  (");
			for( startVal=0;startVal<pkValue.size();startVal++){
				sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1){
					sql.append(",");
				}
			}
			sql.append(" ) IN (SELECT ");
			for( startVal=0;startVal<pkValue.size();startVal++){
				sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1){
					sql.append(",");
				}
			}
			sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))"); 
			sql.append(")");		
		}
	}else{
		sql.append("   from "+trans_table_id+" where language_id in ('en','"+language+"') and "); 		
		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
				if(!Searchbymod.equals(""))
					sql.append("TABLE_ID (+) = '"+masterName+"' and pk_value='"+Searchbymod+"')");
				else
					sql.append(")");
			}else{ 
				sql.append(" TABLE_ID (+) = '"+masterName+"'");
				sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			}
		 }else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
			sql.append("  TABLE_ID (+) = '"+masterName+"'");
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
				if(!Searchbymod.equals(""))
					sql.append(" and  pk1_value='"+Searchbymod+"'");
			}
			sql.append(" AND (pk1_value ,pk2_value)IN (SELECT "+pkval.get(0)+","+pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
		}else{
			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
				if(masterName.equals("SM_RECORD_TRANS")){
					if(report_id.equals("")){
						sql.append(" module_id='"+module_id+"' and pk_value like '"+mod_id+"%' and ");
					}else{
						sql.append(" module_id='"+module_id+"' and pk_value like '"+legend_key+"%' and ");
					}
				}else{
					if(!Searchbymod.equals("")){
						sql.append(" module_id='"+Searchbymod+"' and ");
					}
				}
			}
			if(masterName.equals("SM_FUNCTION_LEGEND") && !SearchbyFunct.equals("")){
				sql.append(" function_id like upper('"+SearchbyFunct+"%')  and "); 
			}
			sql.append( "  (");
			for( startVal=0;startVal<pkValue.size();startVal++){
				sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1){
					sql.append(",");
				}
			}
			sql.append(" ) IN (SELECT ");
			for( startVal=0;startVal<pkValue.size();startVal++){
				sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1){
					sql.append(",");
				}
			}
		    sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
		}
	}
	pstmt= con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery() ; 
	rs.next()   ;
	maxRecord = rs.getInt("total");
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	if(maxRecord==0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.dummyFrame.location.href='../../eCommon/html/blank.html';</script>");
	}else{
            _bw.write(_wl_block9Bytes, _wl_block9);

			if(!(start <= 1))
				out.println("<A HREF='javascript:recordPrevData()'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	
			if(!((start+20) > maxRecord))
				out.println("<A href='javascript:recordNextData()' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(table_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(!table_or_form.equals("F")){
				for(int startval=0;startval<pkPrompt.size();startval++){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pkPrompt.get(startval)));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
				for(int startval=0;startval<columnPrompt.size();startval++){
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(columnPrompt.get(startval)));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

			sql.setLength(0);
			if(display.equals("N")){
				sql.append("Select 'en'  LANGUAGE_ID,1 SEQ_NO," ); 
			}else{
				//sql.append("Select LANGUAGE_ID,2 SEQ_NO," ); 
				sql.append("Select a.LANGUAGE_ID, b.SEQ_NO," ); 
			}
			if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")&& (!display.equals("N"))){
				sql.append("pk_value" +" "+pkval.get(0)+",");
				for(startVal=0;startVal<columnVal.size();startVal++){
					sql.append("desc"+(startVal+1)+"_Value"+" "+columnVal.get(startVal));
					if(startVal<columnVal.size()-1){
						sql.append(",");
					}
				}
			}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")&&(!display.equals("N"))){
				for( startVal=0;startVal<pkval.size();startVal++){
					sql.append("pk"+(startVal+1)+"_Value" +" "+pkval.get(startVal)+",");
				}
				for(startVal=0;startVal<columnVal.size();startVal++){
					sql.append("desc"+(startVal+1)+"_Value"+" "+columnVal.get(startVal));
					if(startVal<columnVal.size()-1){
						sql.append(",");
					}
				}
			}else{
				if(!masterName.equals("SM_MASTER_CODE")){
					for( startVal=0;startVal<pkval.size();startVal++){
						sql.append("a.");
						sql.append(pkval.get(startVal)+",");
					}
				}else{
					sql.append("a.MODULE_ID,to_char(a.MASTER_CODE)MASTER_CODE ,");
					//sql.append("MODULE_ID,to_char(MASTER_CODE)MASTER_CODE ,");
				}
				for( startVal=0;startVal<columnVal.size();startVal++){
					sql.append("a.");
					sql.append(columnVal.get(startVal));
           			if(startVal<(columnVal.size()-1)){
						sql.append(",");
					}
				}
			}
			if(masterName.equals("SM_FUNCTION_LEGEND")){
				sql.append(",(SELECT function_name FROM sm_function WHERE function_id = a.function_id) function_name ");
			}
			if(display.equals("N")){
				sql.append("   FROM  "+masterName+"  a WHERE (");
				for( startVal=0;startVal<pkval.size();startVal++){
					sql.append(pkval.get(startVal));
					if(startVal<pkval.size()-1){
						sql.append(",");
					}
				}
				sql.append(")   in (select ");
				for( startVal=0;startVal<pkValue.size();startVal++){
					sql.append(pkValue.get(startVal));
					if(startVal<pkValue.size()-1){
						sql.append(",");
					}
				}				
				sql.append(" from  "+trans_table_id+"  where ");
				if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
					sql.append("table_id='"+masterName+"' and language_id='"+language+"' and desc1_value is null ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");		
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals(""))){
						//sql.append(" and module_id='"+Searchbymod+"'");
						if(masterName.equals("SM_RECORD_TRANS")){
							if(report_id.equals("")){
								sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
							}else{
								sql.append("and  module_id='"+module_id+"' and pk_value like '"+legend_key+"%' ");
							}
						}else{
							if(!Searchbymod.equals("")){
								sql.append(" and module_id='"+Searchbymod+"'");
							}
						}
					}
					if(masterName.equals("SM_FUNCTION_LEGEND")){
						if(!SearchbyFunct.equals("")){
							sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
						}
					}
					sql.append("  union	 SELECT  '"+language+"' LANGUAGE_ID,2 SEQ_NO, ");
				}else{
					sql.append("language_id='"+language+"'  and "+columnVal.get(0)+" is null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals(""))){
						//sql.append(" and Module_Id='"+Searchbymod+"'");
						if(masterName.equals("SM_RECORD_TRANS")){
							if(report_id.equals("")){
								sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
							}else{
								//sql.append("and  module_id='"+module_id+"' and pk_value like '"+report_id+"%' ");
								sql.append("and  module_id='"+module_id+"' and pk_value like '"+legend_key+"%' ");
							}
						}else{
							if(!Searchbymod.equals("")){
								sql.append(" and module_id='"+Searchbymod+"'");
							}
						}
					}
					if(masterName.equals("SM_FUNCTION_LEGEND")){
						if(!SearchbyFunct.equals("")){
							sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
						}
					}
					sql.append(" union	 SELECT  '"+language+"' LANGUAGE_ID,2 SEQ_NO," );
				}
				if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
					sql.append("pk_value,");
					for(startVal=0;startVal<columnVal.size();startVal++){
						sql.append("desc"+(startVal+1)+"_Value");
						if(startVal<columnVal.size()-1){
							sql.append(",");
						}
					}
				}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
					sql.append("pk1_value,pk2_value,");
					for(startVal=0;startVal<columnVal.size();startVal++){
						sql.append("desc"+(startVal+1)+"_Value");
						if(startVal<columnVal.size()-1){
							sql.append(",");
						}
					}
				}else{
					for(startVal=0;startVal<pkval.size();startVal++){
						sql.append(pkval.get(startVal)+",");
					}
					for(startVal=0;startVal<columnVal.size();startVal++){
	     				sql.append(columnVal.get(startVal));
						if(startVal<columnVal.size()-1){
							sql.append(",");
						}
					}
				}
				if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
					sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and language_id = '"+language+"' and table_id='"+masterName+"'");
		 			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						if(!Searchbymod.equals("")){
							sql.append(" and pk_value='"+Searchbymod+"'");
						}
					}else{
						sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}
				}else if( trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
					sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and language_id = '"+language+"' and table_id='"+masterName+"'");
		 			if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						if(!Searchbymod.equals("")){
							sql.append(" and pk1_value='"+Searchbymod+"'");
						}
					}
					sql.append("  AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
					if(masterName.equals("SM_MASTER_CODE")){
						sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}else{
						sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}
				}else{
					sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is null and language_id = '"+language+"' " ); 
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						/*if(!Searchbymod.equals("")){
							sql.append(" and module_id='"+Searchbymod+"'");
						}*/
						if(masterName.equals("SM_RECORD_TRANS")){
							if(report_id.equals("")){
								sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
							}else{
								//sql.append("and  module_id='"+module_id+"' and pk_value like '"+report_id+"%' ");
								sql.append("and  module_id='"+module_id+"' and pk_value like '"+legend_key+"%' ");
							}
						}else{
							if(!Searchbymod.equals("")){
								sql.append(" and module_id='"+Searchbymod+"'");
							}
						}
						if(masterName.equals("SM_FUNCTION_LEGEND")){
							if(!SearchbyFunct.equals("")){
								sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
							}
						}
						sql.append( " and  (");
						for( startVal=0;startVal<pkValue.size();startVal++){
							sql.append(pkValue.get(startVal));
							if(startVal<pkValue.size()-1){
								sql.append(",");
							}
						}
						sql.append(" ) IN (SELECT ");
						for( startVal=0;startVal<pkValue.size();startVal++){
							sql.append(pkValue.get(startVal));
							if(startVal<pkValue.size()-1){
								sql.append(",");
							}
						}
						sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}else{
						// Changed against IN018751 on 18/02/2010 by Muthu
						//sql.append(" AND "+pkval.get(0)+" IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");

						sql.append( " and  (");
						for( startVal=0;startVal<pkValue.size();startVal++){
							sql.append(pkValue.get(startVal));
							if(startVal<pkValue.size()-1){
								sql.append(",");
							}
						}
						sql.append(" ) IN (SELECT ");
						for( startVal=0;startVal<pkValue.size();startVal++){
							sql.append(pkValue.get(startVal));
							if(startVal<pkValue.size()-1){
								sql.append(",");
							}
						}
						sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");

						// End of Changes 
					}
				}
			}else if(display.equals("T")){
				sql.append("   from "+trans_table_id+"  a, sm_language b  where a.language_id=b.language_id and a.language_id in ('en','"+language+"') and (");
				if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
					sql.append("pk_value");
				}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
					sql.append("pk1_value,pk2_value");
				}else{
					for( startVal=0;startVal<pkval.size();startVal++){
						sql.append(pkval.get(startVal));
						if(startVal<pkval.size()-1){
							sql.append(",");
						}
					}
				}sql.append(")   in( Select " );
		 		if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
					sql.append(" pk_value");
				}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
					sql.append("pk1_value,pk2_value");
		 		}else{
					for( startVal=0;startVal<pkval.size();startVal++){
						sql.append(pkval.get(startVal));	
						if(startVal<pkval.size()-1){
							sql.append(",");
						}
					}	  
				}
				sql.append("  FROM  "+trans_table_id+"  WHERE ");
				if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
					sql.append(" TABLE_ID (+) = '"+masterName+"'  and desc1_value  is not null and LANGUAGE_ID ='"+language+"' ");
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						if(!Searchbymod.equals("")){ 
							sql.append(" and pk_value='"+Searchbymod+"')");
						}else{
							sql.append(")");
						}
					}else{
						sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
						sql.append(" and  TABLE_ID (+) = '"+masterName+"'");
					}
				}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
					sql.append(" TABLE_ID (+) = '"+masterName+"'  and desc1_value  is not null and LANGUAGE_ID ='"+language+"' )");
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						if(!Searchbymod.equals("")){ 
							sql.append(" and pk1_value='"+Searchbymod+"'");
						}
					}
					sql.append(" AND (pk1_value ,pk2_value ) IN (SELECT "+pkval.get(0)+",");
					if(masterName.equals("SM_MASTER_CODE")){
						sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}else{
						sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}
					sql.append(" and  TABLE_ID (+) = '"+masterName+"'");
				}else{
					sql.append( columnVal.get(0)+" is not null and language_id='"+language+"' ");
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						/*if(!Searchbymod.equals(""))
						sql.append(" and module_id='"+Searchbymod+"'");*/
						if(masterName.equals("SM_RECORD_TRANS")){
							if(report_id.equals("")){
								sql.append(" and module_id='"+module_id+"' and pk_value like '"+mod_id+"%'");
							}else{
								//sql.append("and  module_id='"+module_id+"' and pk_value like '"+report_id+"%' ");
								sql.append("and  module_id='"+module_id+"' and pk_value like '"+legend_key+"%' ");
							}
						}else{
							if(!Searchbymod.equals("")){
								sql.append(" and module_id='"+Searchbymod+"'");
							}
						}
						if(masterName.equals("SM_FUNCTION_LEGEND")){
							if(!SearchbyFunct.equals("")){
								sql.append(" and function_id like upper('"+SearchbyFunct+"%') "); 
							}
						}		
					}
					sql.append( " )and  (");
					for( startVal=0;startVal<pkValue.size();startVal++){
						sql.append(pkValue.get(startVal));
						if(startVal<pkValue.size()-1){
							sql.append(",");
						}
					}
					sql.append(" ) IN (SELECT ");
					for( startVal=0;startVal<pkValue.size();startVal++){
						sql.append(pkValue.get(startVal));
						if(startVal<pkValue.size()-1){
							sql.append(",");
						}
					}
					sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))"); 
				}
			}else{
				//sql.append("   from "+trans_table_id+" where language_id in ('en','"+language+"') and "); 
				sql.append("   from "+trans_table_id+" a,  SM_LANGUAGE b where a.language_id in ('en','"+language+"') and  a.language_id=b.language_id and "); 
				if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")){
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						if(!Searchbymod.equals(""))
							sql.append("TABLE_ID (+) = '"+masterName+"' and pk_value='"+Searchbymod+"'");
					}else{ 
						sql.append(" TABLE_ID (+) = '"+masterName+"'");
						sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}
				}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")){
					sql.append("   TABLE_ID (+) = '"+masterName+"'");
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						if(!Searchbymod.equals("")){ 
							sql.append("  and pk1_value='"+Searchbymod+"'");
						}
					}
					sql.append(" AND (pk1_value ,pk2_value) IN (SELECT "+pkval.get(0)+",");
					if(masterName.equals("SM_MASTER_CODE")){
						sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}else{
						sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
					}
				}else{
					if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))){
						if(masterName.equals("SM_RECORD_TRANS")){
							if(report_id.equals("")){
								sql.append(" module_id='"+module_id+"' and pk_value like '"+mod_id+"%' and ");
							}else{
								//sql.append(" module_id='"+module_id+"' and pk_value like '"+report_id+"%' and ");
								sql.append(" module_id='"+module_id+"' and pk_value like '"+legend_key+"%' and ");
							}
						}else{
							if(!Searchbymod.equals("")){
								sql.append(" module_id='"+Searchbymod+"' and  ");
							}
						}
						/*if(!Searchbymod.equals(""))
						sql.append(" module_id='"+Searchbymod+"' and  ");*/
						if(masterName.equals("SM_FUNCTION_LEGEND")){
							if(!SearchbyFunct.equals("")){
								sql.append(" function_id like upper('"+SearchbyFunct+"%') and "); 
							}
						}
					}
					sql.append( "  (");
					for( startVal=0;startVal<pkValue.size();startVal++){  
						sql.append("a.");
						sql.append(pkValue.get(startVal));
						if(startVal<pkValue.size()-1){
							sql.append(",");
						}
					}
					sql.append(" ) IN (SELECT ");
					for( startVal=0;startVal<pkValue.size();startVal++){
						sql.append(pkValue.get(startVal));
						if(startVal<pkValue.size()-1){
							sql.append(",");
						}
					}
					sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))"); 
				}
			}
			sql.append(" order by  ");
			if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")&&(!display.equals("N"))){
				sql.append(" pk_value");
			}else if(trans_table_id.equals("SM_OTH_LANG_DATA_DKEY")&&(!display.equals("N"))){
				sql.append("pk1_value,pk2_value");
			}else{
				for( startVal=0;startVal<pkval.size();startVal++){
					sql.append(pkval.get(startVal));
					if(startVal<pkval.size()-1)
						sql.append(",");
				}
	 		}
			sql.append(",seq_no");	
			pstmt= con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery() ;
			String temppk1="";
			int l=0;
			int m=0;
			int i=0,j=0;
			int colDispCount=0;
			int pkDataCnt=pkval.size();
 
			if ( start != 1 )
				for( m=1; m<start; l++, m++ ){
					rs.next() ;
				}
			String pkData[] =new String[pkval.size()];
			String pkData1[] =new String[pkval.size()];
			
			for( startVal=0;startVal<pkval.size();startVal++){
				pkData1[i]="";
			}
			boolean maxrecallow=false;
			if(!table_or_form.equals("F")){
				maxrecallow=l<end;
			}else{
				maxrecallow=true;
			}
			while(rs.next() && maxrecallow){ 
				lang=rs.getString(1);
				for( startVal=0;startVal<pkval.size();startVal++){
					pkData[startVal]=rs.getString((String)pkval.get(startVal));
				}
				if ( i % 2 == 0 ){
					//classValue = "BACKGROUND-COLOR:#F0F0F2" ;
					classValue = "QRYODD" ;
				}else{
					//classValue = "BACKGROUND-COLOR:#E2E3F0;" ;
					classValue = "QRYEVEN" ;
				}
		
            _bw.write(_wl_block21Bytes, _wl_block21);

			if(!table_or_form.equals("F")){
				for( startVal=0;startVal<pkval.size();startVal++){
					boolean temp1=false;;
					if(startVal==0){
						temp1=(pkData[startVal].equals(pkData1[startVal]));
					}else{
						temp1=(pkData[startVal].equals(pkData1[startVal])&&(pkData[startVal-1].equals(pkData1[startVal-1])));
					}
					if(!(temp1)){
						if(masterName.equals("SM_FUNCTION_LEGEND") && startVal==1){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("function_name")));
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkData[startVal]));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
					}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
				}
				for( startVal=0;startVal<pkval.size();startVal++){
					pkData1[startVal]=pkData[startVal] ;
				}
			}
		
            _bw.write(_wl_block27Bytes, _wl_block27);

			int colCount1=0;
			int engColCount=0;
			if(table_or_form.equals("F")){ 
				for( startVal=0;startVal<pkval.size();startVal++){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(colCount));
            out.print( String.valueOf(startVal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pkData[startVal]));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(columnPrompt.get(colDispCount)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((rs.getString((String)columnVal.get(colDispCount))==null)? "":(rs.getString((String)columnVal.get(colDispCount)))));
            _bw.write(_wl_block33Bytes, _wl_block33);
rs.next();
            _bw.write(_wl_block16Bytes, _wl_block16);

				if(language_direction.equals("R")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(colDispCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(colDispCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(columnLen.get(colDispCount)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs.getString((String)columnVal.get(colDispCount))==null?"":rs.getString((String)columnVal.get(colDispCount))));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(colDispCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(colDispCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(columnLen.get(colDispCount)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs.getString((String)columnVal.get(colDispCount))==null?"":rs.getString((String)columnVal.get(colDispCount))));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);

				colDispCount=colDispCount+1; 
				colCount=1;
			}else{
				for(startVal=0;startVal<columnVal.size();startVal++){
					if(lang.equals("en")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rs.getString((String)columnVal.get(startVal))==null?"":rs.getString((String)columnVal.get(startVal))));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(engColCount++));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(engColCount++));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rs.getString((String)columnVal.get(startVal))==null?"":rs.getString((String)columnVal.get(startVal))));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
						if(language_direction.equals("R")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(colCount1++));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(columnLen.get(startVal)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rs.getString((String)columnVal.get(startVal))==null?"":rs.getString((String)columnVal.get(startVal))));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(colCount1++));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(columnLen.get(startVal)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rs.getString((String)columnVal.get(startVal))==null?"":rs.getString((String)columnVal.get(startVal))));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
					}
				}	 
			
            _bw.write(_wl_block53Bytes, _wl_block53);

		temppk1=pk1;
		temppk2=pk2; 
	}
	if(!lang.equals("en")){
		for(startVal=0;startVal<pkval.size();startVal++){
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(colCount));
            out.print( String.valueOf(startVal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pkData[startVal]));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
		i++;
		colCount++; 
	}else{
	}
	j++;
	l++;
	if(!table_or_form.equals("F")){
		maxrecallow=l<end;
	}
	if(colDispCount>=columnPrompt.size()){
		break;
	 }
	if(table_or_form.equals("F")){
		rs.beforeFirst();
	}
 }
 if(rs!=null)rs.close();
 if(pstmt!=null)pstmt.close();
 
 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(start));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(end));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(masterName));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(language));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(display));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(Searchbymod));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(SearchbyFunct));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(start_ends_contains));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(searchText1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(master_table_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(trans_table_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(pkDataCnt));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(table_or_form));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(columnVal.size()));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mod_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block75Bytes, _wl_block75);

 }
	 pkval.clear();
	 pkValue.clear();
     pkLen.clear();
	 pkPrompt.clear();
	 columnPrompt.clear();
	 columnVal.clear();
	 colValue.clear();
	 columnLen.clear();
 }catch(Exception e)
 {
	 e.printStackTrace();
 }finally{
	
   ConnectionManager.returnConnection(con,request);
}
 
 
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.English.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.TranslatedLanguage.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
