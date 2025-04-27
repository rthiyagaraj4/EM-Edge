package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesprevfiltercriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesPrevFilterCriteria.jsp", 1743657842358L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"> -->\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<style type=\'text/css\'>\n\tA.imageClass1 \n\t{\n\t\twidth:30px;\n\t\theight:28px;\n\t\tmargin-left:0;\n\t\tmargin-right:0;\n\t\tmargin-top:0;\n\t\tmargin-bottom:0;\n\t\tpadding-left:3px;\n\t\tpadding-right:3px;\n\t\tpadding-top:2px;\n\t\tpadding-bottom:1px;\n\t\tborder-top:0px;\n\t}\n\tA.imageClass2 \n\t{\n\t\tbackground-color:#FFFFFF;\n\t\twidth:30px;\n\t\theight:28px;\n\t\tmargin-left:0;\n\t\tmargin-right:0;\n\t\tmargin-top:0;\n\t\tmargin-bottom:0;\n\t\tpadding-left:2px;\n\t\tpadding-right:2px;\n\t\tpadding-top:2px;\n\t\tpadding-bottom:1px;\n\t\tborder-left:1px solid;\n\t\tborder-right:1px solid;\n\t\tBORDER-COLOR: #75768B;\n\t}\n\timg\n\t{\n\t\tborder:0;\n\t}\n\n\tTR.iconBarRow\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBG.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowBlue\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGBlue.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowLime\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGLime.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowOrange\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGOrange.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowViolet\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGViolet.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tIMG.imageClass\n\t{\n\t\tvertical-align: middle;\n\t}\n\t</style>\n\t<script>\nfunction loadFilterFunction(obj)\n{\n\tparent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href=\'../../eCommon/html/blank.html\';\n\tif(obj.value != \'\')\n\t{\n\t\tvar arr = new Array();\n\t\tarr = obj.value.split(\"|\");\n\t\tvar pre_ql_ref = arr[0];\n\t\tvar qs= parent.RecClinicalNotesPrevFilterCriteriaFrame.document.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value;\n\t\tif(arr[1].indexOf(\"?\") != -1)\n\t\t{\n\t\t\tparent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href=arr[1]+\'&\'+qs+\"&pre_ql_ref=\"+pre_ql_ref;\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href=arr[1]+\'?\'+qs+\"&pre_ql_ref=\"+pre_ql_ref;\t\n\t\t\n\t\t}\n\t}\n\telse\n\t{\n\t\tvar executable_path = document.RecClinicalNotesPrevNotesFilterCriteriaForm.executable_path.value;\n\t\tvar qs = parent.RecClinicalNotesPrevFilterCriteriaFrame.document.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value;\n\t\tif(executable_path.indexOf(\"?\") != -1)\n\t\t{\n\t\t\tparent.RecClinicalNotesPrevNotesSearchCriteriaFrame.document.location.href = executable_path+\'&default_yn=N&\'+qs;\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.RecClinicalNotesPrevNotesSearchCriteriaFrame.document.location.href = executable_path+\'?default_yn=N&\'+qs;\n\t\t}\n\t\t\n\t}\n}\n\nasync function UpdateFilter()\n{\n\tparent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href=\'../../eCommon/html/blank.html\';\n\tvar function_id = \"PREVIOUS_NOTES\";\n\t/*\n\tvar dialogHeight= \"31\" ;\n\tvar dialogWidth\t= \"35\" ;\n\tvar dialogTop\t= \"150\";\n\tvar dialogLeft\t= \"200\";\n\t*/\n\n\tvar dialogHeight= \"65vh\" ;\n\tvar dialogWidth\t= \"35vw\" ;\n\tvar dialogTop\t= \"0vh\";\n\tvar dialogLeft\t= \"0vw\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no \";\n\tvar ret = await window.showModalDialog(\"../../eCA/jsp/QuickLinksForRespCustomize.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&link_type=F&prev_notes_called_from=\"+function_id,arguments,features);\n\t\n\tif(ret != \'\' && ret != undefined)\n\t{\n\t\tif(document.RecClinicalNotesPrevNotesFilterCriteriaForm.filter != null)\n\t\t{\n\t\t\tvar optlength =document.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.options.length;\n\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t{\n\t\t\t\tdocument.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.options.remove(\"filter\");\n\t\t\t}\n\t\t\tvar HTMLVal=\"<html><body><form name=\'QuickLinksUpdateDescForm\' id=\'QuickLinksUpdateDescForm\' method=\'post\' action=\'../../eCA/jsp/QuickLinksForRespUpdateFilter.jsp\'>\"+\n\t\t\t\"<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\"+function_id+\"\'>\"+\n\t\t\t\"</form></body></html>\";\n\t\t\tparent.messageframe.document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\tparent.messageframe.document.QuickLinksUpdateDescForm.submit();\n\t\t\t\n\t\t}\n\t}\n}\n\t</script>\n\t</head>\n<body OnMouseDown=\'CodeArrest()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<center>\n<form name=\'RecClinicalNotesPrevNotesFilterCriteriaForm\' id=\'RecClinicalNotesPrevNotesFilterCriteriaForm\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n<tr class=\'iconBarRow";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t<td id=\'dispname\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t\t<td id=\'filter_by\' align=\'right\'><img src=\"../../eCA/images/filter.gif\" name=\'filterImg\' alt=\'Filter\' /> : <select name=\'filter\' id=\'filter\' onchange=\'loadFilterFunction(this)\'>\n\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="---</option>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="|";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="selected";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</select><a href=\"#\"><img src=\"../../eCA/images/customize.gif\" alt=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' name=\"RightStrip1\"  border=\"0\" id=\"RightStrip1\" onclick=\'UpdateFilter()\' height=\'18\'/></a>&nbsp;&nbsp;\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\'><input type=\'hidden\' name=\'executable_path\' id=\'executable_path\' value=\'RecClinicalNotesPrevNotesSearchCriteria.jsp\'></td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'locale\' id=\'locale\'\tvalue=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\'hidden\' name=\'operation_mode\' id=\'operation_mode\'\tvalue=\'\'>\n\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\'\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\'hidden\' name=\'appl_task_id\' id=\'appl_task_id\'\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\'hidden\' name=\'from_date_time\' id=\'from_date_time\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\'hidden\' name=\'to_date_time\' id=\'to_date_time\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\n</form>\n</center>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</select></td>\n</body>\n<script language=\'javascript\'>\n\tparent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href = \"../../eCA/jsp/RecClinicalNotesPrevNotesSearchCriteria.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&pre_ql_ref=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String imgUrl="";
		//String strqry=request.getQueryString();
		//out.println("strqry "+strqry);
		if(sStyle.equals("IeStyle.css"))
		 {
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
		 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
			 {
				styleMap = "Blue";
			 }
			 else if(sStyle.equals("IeStyleLime.css"))
			 {
				styleMap = "Lime";
			 }
			 else if(sStyle.equals("IeStyleOrange.css"))
			 {
				styleMap = "Orange";
			 }
			 else if(sStyle.equals("IeStyleVoilet.css"))
			 {
				styleMap = "Violet";
			 }
			 else
			 {
				styleMap = "";
			 }
			
			//out.println("Query string "+request.getQueryString());
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	StringBuffer	query_string		=	new StringBuffer(request.getQueryString());
	String	from_date_time		=	"",		to_date_time		=	"";
	String appl_task_id		=	"";
	String resp_id			=	(String)		session.getValue("responsibility_id");
	appl_task_id          =   request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");
	String function_id	= "PREVIOUS_NOTES";
		
	int Existance_Count = 0;
	StringBuffer sqlQuery	= new StringBuffer();
	String sql = "";		
	String login_user	= (String)session.getValue("login_user");
	String pre_ql_ref = "";
				
	try
	{
		//query_string	=	request.getQueryString();		
		con				=	ConnectionManager.getConnection(request);
		to_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		from_date_time		=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,1,"d");	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				//sql = "select 1 Existance_Count from SM_QUICK_LINK_FOR_USER where APPL_USER_ID = ? and  rownum=1 and OPTION_ID =? ";
				//sql = "SELECT 1 existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.default_yn = 'Y' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y' AND ROWNUM = 1 ";
				sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";

				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1,login_user);
				pstmt.setString(2,resp_id);
				pstmt.setString(3,function_id);
				pstmt.setString(4,locale);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					Existance_Count = rs.getInt("EXISTANCE_COUNT");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				sqlQuery.append("select a.quick_link_ref Quick_Link_Ref, C.quick_link_description, B.EXECUTABLE_NAME,a.DEFAULT_YN from ");
				if(Existance_Count>0)//changed
					sqlQuery.append(" SM_QUICK_LINK_FOR_USER A ");
				else
					sqlQuery.append(" SM_QUICK_LINK_RESP A ");
				sqlQuery.append(", CA_OPTION B,sm_quick_link_list_lang_vw  C where  c.LANGUAGE_ID = '"+locale+"' and B.option_id = ? and c.FUNCTION_SPEC_YN ='Y' AND B.OPTION_ID  = A.OPTION_ID AND C.QUICK_LINK_REF=A.QUICK_LINK_REF AND C.eff_STATUS='E' AND ");
				if(Existance_Count>0)//changed
					sqlQuery.append(" A.APPL_USER_ID=?  ");
				else
					sqlQuery.append(" A.RESP_ID=?  ");
				sqlQuery.append(" and LINK_TYPE = 'F' order by 2 ");
						
				pstmt = con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,function_id);
				if(Existance_Count>0)//changed
					pstmt.setString(2,login_user);
				else
					pstmt.setString(2,resp_id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString("Quick_Link_Ref")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString("EXECUTABLE_NAME")));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(rs.getString("DEFAULT_YN").equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("quick_link_description")));
            _bw.write(_wl_block18Bytes, _wl_block18);
								
						if(rs.getString("DEFAULT_YN").equals("Y"))
							pre_ql_ref = rs.getString("Quick_Link_Ref");
					}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			
			
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(from_date_time));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
	catch(Exception e)
	{
		//out.println("Exception@2: "+e);//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pre_ql_ref));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewPreviousNotes.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomiseFilter.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
