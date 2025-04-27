package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __statgrpnationdetailquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/StatGrpNationDetailquery.jsp", 1740542071654L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language = \'javascript\'></script>\n\t\t<script src = \'../../eCommon/js/common.js\' language = \'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eAM/js/StatGrpNationDetail.js\"></script>\n\t\t\n\t\t<script language=\"JavaScript\">\n\t  var sStyle=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\tfunction callMember(alpha)\n\t{\n\t\tvar errors = \"\";\t\n\t\tvar stat = parent.parent.frames[1].getLabel(\"Common.StatisticsGroup.label\",\"Common\");\n\n\t\tif(document.getElementById(\'stat_grp_id\').value.length !=0)\n\t\t{\n\t\t\t\n\t\t\tparent.frames[1].location.href=\'../../eAM/jsp/StatGrpNationDetailresult.jsp?param=\'+alpha+\'&stat_grp_id=\'+document.getElementById(\'stat_grp_id\').value+\'&category=\'+document.getElementById(\'category\').value+\'&dtl_flag=insert\';\n\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\terrors += getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(stat)));\n\t\t\tparent.parent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors;\n\t\t\t//parent.parent.frames(2).location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Statistics Group cannot be blank...\'\n\t\t}\n\t}\n\tfunction to_hide()\n\t{\n\t\tdocument.getElementById(\'alpha\').style.visibility=\"hidden\";\n\t\tdocument.getElementById(\'alpha1\').style.visibility=\"hidden\";\n\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t\n\t}\n\tfunction to_visible()\n\t{\n\t\tvar cat = parent.parent.frames[1].getLabel(\"Common.category1.label\",\"Common\")\n\t\tvar stat = parent.parent.frames[1].getLabel(\"Common.StatisticsGroup.label\",\"Common\");\n\t\t   \t\t\n\t\tdocument.forms[0].statusval.value=\'Y\'\n\t\tvar names = new Array(cat,stat);\n\t\tvar errors = \"\";\n\t\t\n\t\tif(document.forms[0].category.value ==\"\")\n\t\t{\t\n\t\t\t//alert(\"APP-000001 Category cannot be blank...\");\n\t\t\terrors += getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(cat)))+\"<br>\";\n\t\t\t//errors = getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(cat)));\n\t\t\t\n\t\t\tdocument.forms[0].category.focus();\n\t\t\t//return false;\n\t\t}\n\t\t\n\t\tif( document.forms[0].stat_group.value !=\"\")\n\t\t{\n\t\t\tdocument.getElementById(\'alpha\').style.visibility=\"visible\";\n\t\t\tdocument.getElementById(\'alpha1\').style.visibility=\"visible\";\n\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//parent.frames(2).location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Statistics Group cannot be blank...\'\n\t\t\t//alert(\"APP-000001 Statistics Group cannot be blank...\");\n\t\t\terrors += getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(stat)));\n\t\t\t\n\t\t\t\n\t\t\tdocument.forms[0].stat_group.focus();\n\t\t\t\n\t\t\t//parent.frames(2).document.statgrpdtlquery.focus();\n\t\t\t// parent.parent.frames(2).location.href=\'../../eCommon/jsp/MstCodeToolbar.jsp\'\n\t\t\t//messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0\';\n           // return false;\n\n\t\t\t//return false;\n\t\t\t\n\t\t\t\n\t\t}\n\n\n\n\t\tif(errors.length != 0)\n\t\t{\n\t\t\t\n\t\t\terrors = errors + \"<br> \";\n\t\t\t\n\t\t\t\n\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+errors;\n\t\t\terrors=\"\";\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\terrors=\"\";\n\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+errors;\n\t\t//parent.reload();\n\t\t}\n\t}\n\t/**/\n\tfunction display_query()\n\t{\n\t\tparent.frames[1].location.href=\'../../eAM/jsp/StatGrpNationDetailresult.jsp?dtl_flag=query&stat_grp_id=\'+document.forms(0).stat_group.value;\n\t}\n\t\n\tfunction getVal()\n\t{\n\t\t\n\t   var category=document.getElementById(\'category\').value;\n\t\tvar HTMLVal = \"<HTML><HEAD>\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'>\";\n\t\tHTMLVal = HTMLVal +\"<form name=\'form1\' method=\'post\' action=\'../../eAM/jsp/StatGrpPopulate.jsp\' target=messageFrame>\";\n\t\tHTMLVal = HTMLVal +\"<input name=\'category\' id=\'category\' type=\'hidden\' value= \'\"+category+\"\'>\";\n\t\tHTMLVal = HTMLVal +\"</form></BODY></HTML>\";\n\t\tparent.parent.frames[2].document.write(HTMLVal);\n\t\tparent.parent.frames[2].document.forms[0].submit();\n\t\tdocument.getElementById(\'alpha\').style.visibility=\"hidden\";\n        document.getElementById(\'alpha1\').style.visibility=\"hidden\";\n        parent.result.location.href=\"../../eCommon/html/blank.html\";\n\n\t\t\t\t\t\n\t\t\t\t\n\t\t}\n\t\t\t\t\n\t\t\t\t\n\n\t\n\n\tfunction from_query(stat_grp_id,category)\n\t{\n\t\tparent.frames[1].location.href=\'../../eAM/jsp/StatGrpNationDetailresult.jsp?dtl_flag=insert&stat_grp_id=\'+stat_grp_id+\'&category=\'+category;\n\t}\n\tfunction assignVal(val)\n\t{\n\t\tdocument.forms[0].stat_grp_id.value = val;\n\t\tdocument.getElementById(\'alpha\').style.visibility=\"hidden\";\n        document.getElementById(\'alpha1\').style.visibility=\"hidden\";\n        parent.result.location.href=\"../../eCommon/html/blank.html\";\n\n\t}\n\t\n\t</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<body  onLoad=\"to_hide();Focusing(\'category\');getVal();\" onMouseDown =\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<body onLoad=\"from_query(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');Focusing(\'stat_group\');\" onKeyDown = \'lockKey()\' onMouseDown =\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<form name=\'statgrpdtlquery\' id=\'statgrpdtlquery\'>\n\t\t<table cellspacing=0 cellpadding=0 width=\'100%\' border=0>\n\t\t<tr>\n\t\t<td class=\'label\' align=\'left\' width=\'30%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<td><input type =\'text\' name = \'category_desc\'  id = \'category_desc\' readOnly  size =\'20\' value =\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\n\t\t<input type=\'hidden\' name=\'category\' id=\'category\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n         \n\t\t\t\n\t\t\t<td><select name=\'category\' id=\'category\' onChange=\'getVal()\'> \n\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" -----        <option value=\'N\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n        <option value=\'S\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\n   \n\t\t</select>&nbsp;<img align=\'center\' src=\'../../eMP/images/mandatory.gif\'>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\t\t</td>\t\t\t\n\t\t</tr>\n\n\t\t\t\n        <tr><td colspan=\'2\'>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' align=\'left\' width=\'30%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<td width=\'70%\' align=\'left\'>\t\t\t\n\t\t\t<select name=\'stat_group\' id=\'stat_group\' onChange=\'assignVal(this.value)\'><option value=\'\'>----- ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" -----\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t</select>&nbsp;<img align=\'center\' src=\'../../eMP/images/mandatory.gif\'>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td><input type =\'text\' name = \'stat_group\' readOnly  size =\'20\' value =\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<input type =\'hidden\' name =\'stat_grp_id\' id =\'stat_grp_id\' value =\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\t\t\n\t\t\t<input type =\'hidden\' name =\'statusval\' id =\'statusval\' value =\'\'>\t\t\n\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' name=\'search\' id=\'search\' onClick=\'to_visible()\'>&nbsp;&nbsp;<input type=\'button\' class=\'button\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onClick=\'to_hide()\'>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td colspan=\'2\'>&nbsp;</td></tr>\n\t<TR id=\'alpha\' name=\'alpha\'>\n\t\t\t<TD colspan=\'2\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:callMember(\'A\')\">A</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'B\')\">B</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'C\')\">C</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'D\')\">D</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'E\')\">E</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'F\')\">F</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'G\')\">G</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'H\')\">H</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'I\')\">I</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'J\')\">J</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'K\')\">K</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'L\')\">L</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'M\')\">M</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'N\')\">N</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'O\')\">O</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'P\')\">P</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Q\')\">Q</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'R\')\">R</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'S\')\">S</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'T\')\">T</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'U\')\">U</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'V\')\">V</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'W\')\">W</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'X\')\">X</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Y\')\">Y</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Z\')\">Z</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</a>&nbsp;&nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr id=\'alpha1\' name=\'alpha1\'><td colspan=\'2\'>&nbsp;</td></tr>\n\t\t</TABLE>\n\t\t</form>\n\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con =ConnectionManager.getConnection(request);
	
	Statement stmt=null;
	ResultSet rset=null ;
	Statement stmt1=null;
	ResultSet rset1=null ;
	String stat_grp_desc ="";
	
	request.setCharacterEncoding("UTF-8");	
	String stat_grp_id = request.getParameter("stat_grp_id");	// from AddModifyStatGrpNationDetail.jsp
	String catgy=request.getParameter("category");
	if(catgy == null) catgy="";

	String catgy_desc="";
	if(catgy.equals("N"))
	   catgy_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels");
	else if(catgy.equals("S"))
	   catgy_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");
	else if(catgy.equals("P"))
	   catgy_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	 
	 
	try{
		if(stat_grp_id == null || stat_grp_id.equals("null")) 
			stat_grp_id="";
		if(stat_grp_id.equals(""))
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
	
		} 
		else
		{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(stat_grp_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(catgy));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
		}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(!stat_grp_id.equals(""))
	     {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(catgy_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(catgy));
            _bw.write(_wl_block17Bytes, _wl_block17);
}else
	 {
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
if(stat_grp_id.equals("")) {
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

			
            _bw.write(_wl_block27Bytes, _wl_block27);
} else if(!stat_grp_id.equals("")){

				stmt1 = con.createStatement();
				rset1 = stmt1.executeQuery("select stat_grp_desc from am_stat_group where stat_grp_id='"+stat_grp_id+"'");
				if(rset1.next())
				{
				stat_grp_desc = rset1.getString("stat_grp_desc");
				}
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(stat_grp_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stat_grp_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Member.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
}catch(Exception e){out.println("Exception :"+e);}
finally{
	try{
if(stmt!=null) stmt.close();
if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
if(rset1!=null) rset1.close();
	}
	catch(Exception e)
	{}
ConnectionManager.returnConnection(con,request);
} 
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StatisticsGroup.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
