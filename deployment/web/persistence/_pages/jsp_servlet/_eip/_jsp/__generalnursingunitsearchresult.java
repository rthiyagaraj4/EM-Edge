package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __generalnursingunitsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/GeneralNursingUnitSearchResult.jsp", 1742385301633L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction hideToolTip(){\n\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'hidden\';\n}\n\n\nfunction close_window(Dcode,position,patient_class,desccc){\n\n\t//var Name = eval(\"document.forms[0].desc\"+position).value;\n/*\n\t//this loop is to remove the %20 addition in description fields\n\twhile(Name.indexOf(\"+\")!=-1)\n\t{\n\t\tName=Name.replace(\'+\',\" \");\n\t}\n*/\n\t//window.parent.parent.returnValue=Dcode+\"~\"+Name+\"~\"+patient_class;\n\treturnValue=Dcode+\"~\"+desccc+\"~\"+patient_class;\n\t//window.parent.parent.returnValue=\"Test\";\n\t//close();\nlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\n    dialogBody.contentWindow.returnValue = returnValue;\n\n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\n    dialogTag.close();   \n}\n\nfunction openToolTip(nursingUnitCode)\n{\n\n\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'bed_class_form\' id=\'bed_class_form\' method=\'post\' action=\'../../eIP/jsp/PopulateNursingUnitBedDetails.jsp\'><input type=\'hidden\' name=\'nursingunit\' id=\'nursingunit\' value=\'\"+nursingUnitCode+\"\'><input type=\'hidden\' name=\'x_coordinate\' id=\'x_coordinate\' value=\'\"+event.clientX+\"\'><input type=\'hidden\' name=\'y_coordinate\' id=\'y_coordinate\' value=\'\"+event.clientY+\"\'></form></body></html>\";\n\tparent.frames[2].document.write(HTMLVal);\n\tparent.frames[2].document.bed_class_form.submit();\n/*\n\n\n\tvar retVal = \tnew String();\n\tvar dialogHeight= \"41\";\n\tvar dialogWidth = \"65\";\n\tvar dialogTop\t= \"72\";\n\n\tvar status = \"no\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \";dialogTop:\" + dialogTop + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\tretVal = window.showModalDialog(\"../../eIP/jsp/PopulateNursingUnitBedDetails.jsp?nursingunit=\"+escape(nursingUnitCode),arguments,features);\n*/\n\n}\n\nfunction closeesc(Dcode,Name,patient_class)\n{\n\twindow.parent.parent.returnValue=Dcode+\"~\"+Name+\"~\"+patient_class;\n\twindow.parent.parent.close();\n}\n/*Friday, June 04, 2010 , function added for SRR20056-SCF-4564-IN021691*/\nfunction submitPrevNext(from,to)\n{\n\t\n\tdocument.location.href=\"../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?from=\"+from+\"&to=\"+to+\"&queryString=\"+\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n}\n\n</script>\n</head>\n\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<form name=\'NUform\' id=\'NUform\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table align=\'right\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<BR>\n\t\t\t</P>\n\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<th width=\'50%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<th >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t<th >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<tr style=\'background-color:;\'  ><td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\"desc";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<a href=\'javascript:close_window(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\",\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\")\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a></td><td width=\'2%\' class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td><td width=\'2%\' class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t<a href=# onclick=\'close_window(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\")\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</a></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'\n\t\t\t\t\t\t<a href=\'javascript:close_window(\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\")\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</a></td><td class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' align=\'right\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' style=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' align=\'right\' onMouseOut=\'hideToolTip()\' onclick=\'openToolTip(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\");\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t</td><td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\");\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<script>closeesc(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\',\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\",\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));                      \n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'nursing_unit_desc\'))                   \t\t\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'nursing_unit_desc\').readOnly=false;      \n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'Search\'))                                     \n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'Search\').disabled=false;                 \n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'clear\'))\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'clear\').disabled=false;\t\n\t\t\t\t\tdocument.location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'nursing_unit_code\'))\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'nursing_unit_code\').readOnly=false;                     \n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'nursing_unit_desc\'))\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'nursing_unit_desc\').readOnly=false;               \n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'Search\'))\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'Search\').disabled=false;\n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'clear\'))\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'clear\').disabled=false;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<script >\n\t\t\t\t\t\n\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'searchtext\' id=\'searchtext\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" > \n\t\t<input type=hidden name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=hidden name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:5%; visibility:visible;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t</form>\n\t\t</BODY>\n\t\t</html>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );
  
	public String specialCharacter(String single)
	{
		if(single == null) single = "";
		return single.replaceAll("'","");
	}	


	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
 
	String sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	String queryString			= request.getQueryString() ;
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getValue("facility_id");
	String specilaty_code		= checkForNull(request.getParameter("specilaty_code"));
	String nursing_unit_code	= checkForNull(request.getParameter("nursing_unit_code"));
	String nursing_unit_desc	= checkForNull(request.getParameter("nursing_unit_desc"));
	String start_ends_contains	= checkForNull(request.getParameter("start_ends_contains"));
	String applicable_to		= checkForNull(request.getParameter("applicable_to"));
	String statics_yn			= checkForNull(request.getParameter("statics_yn"));
	String bkg_type				= checkForNull(request.getParameter("bkg_type"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String open_location_yn		= checkForNull(request.getParameter("open_location_yn"));
	String room_no				= checkForNull(request.getParameter("room_no"));
	String med_serv_grp_code	= checkForNull(request.getParameter("med_ser_grp"));
	String practitioner_id		= checkForNull(request.getParameter("pract_id"));
	
	
	if( call_function.equals("IPList") || call_function.equals("PatMovList") || call_function.equals("AdminHist") || call_function.equals("QueryDischarge")||call_function.equals("ChangedAdmDtls") )
		open_location_yn		= "Y";

	String clinic_code			= checkForNull(request.getParameter("clinic_code"));

	if(start_ends_contains.equals(""))
		start_ends_contains = "S";
	String whereClause			= checkForNull(request.getParameter("whereclause"));
	String user_sql				= checkForNull(request.getParameter("sql"));
	String radioval				= checkForNull(request.getParameter("radioval"));
	if(radioval.equals("code"))
		radioval = "1";
	else
		radioval = "2";

	String code					= "";
	String desc					= "";
	String pat_class			= "";
	String pat_class_desc		= "";
	String login_user			= checkForNull(request.getParameter("login_user"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_id"));
	String patient_class		= checkForNull(request.getParameter("patientclass"));
	String linkColor			= "";
	if(patient_class.equals("")) 
		patient_class			=	applicable_to;
	if(bkg_type.equals("D"))
		patient_class			= "DC";
	else if(bkg_type.equals("I"))
		patient_class			= "IP";


	Connection conn				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt_block		= null;	
	ResultSet rs				= null;
	ResultSet rs1				= null;
	String searchtext			= "";
	String dispDescFirst		= checkForNull(request.getParameter("dispDescFirst"));
	int i						= 1;
	
	//Added by Kamatchi S for MOHE-SCF-0134
	if(user_sql.equals("SQL_GENNUR"))
	{
			user_sql = (String)session.getAttribute("SQL_GENNUR");
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try
	{
		conn				= ConnectionManager.getConnection(request);
		StringBuffer sql	= new StringBuffer();
		String from			= checkForNull(request.getParameter( "from" ));
		String to			= checkForNull(request.getParameter( "to" ));
		searchtext			= checkForNull(request.getParameter("searchtext"));
		
		if(user_sql.equals(""))
		{
			if(open_location_yn.equals("Y"))
			{
			
				sql.append("SELECT  COUNT(*) OVER () rowCount, a.nursing_unit_code, a.short_desc, a.patient_class APPL_PATIENT_CLASS,");
				sql.append(" patient_class, (SELECT COUNT (*) FROM ip_nursing_unit_bed ");
				sql.append("WHERE nursing_unit_code = a.nursing_unit_code AND facility_id = "); 
				sql.append("a.facility_id AND eff_status = 'E' AND pseudo_bed_yn = 'N') total_beds,");
				sql.append("(SELECT COUNT (*) FROM ip_nursing_unit_bed WHERE nursing_unit_code = "); 
				sql.append("a.nursing_unit_code AND facility_id = a.facility_id AND eff_status = 'E' ");
				sql.append("AND pseudo_bed_yn = 'N' AND current_status = 'A') available,(SELECT "); 
				sql.append("COUNT(*) FROM ip_nursing_unit_bed WHERE nursing_unit_code = "); 
				sql.append("a.nursing_unit_code AND facility_id = a.facility_id AND eff_status = 'E' ");
				sql.append("AND pseudo_bed_yn = 'N' AND current_status = 'O') occupied ");
				/*Monday, April 19, 2010 , added for Nurisng Unit Lookup fine tuning....*/
				sql.append(",nvl((SELECT SUM(CASE WHEN BOOKING_TYPE IN('B','N','L','T','D') THEN 1 ELSE 0 END) Blocked FROM IP_BED_BOOKING WHERE facility_id = a.facility_id AND req_nursing_unit_code = a.nursing_unit_code AND booking_status IN('0','1') AND ( SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time OR blocked_until_date_time IS NULL )),0) blocked ");
				/**/
				sql.append("FROM IP_NURSING_UNIT_LANG_VW a WHERE language_id = '"+locale+"' and a.facility_id = '"+facility_id+"' AND  ");
				sql.append("a.eff_status = 'E' ");
			}
			else
			{
			
				
				sql.append( "select  COUNT(*) OVER () rowCount,a.nursing_unit_code,a.short_desc,a.patient_class appl_patient_class, patient_class,(select count(*) from ip_nursing_unit_bed where  nursing_unit_code = a.nursing_unit_code ");
				sql.append(" and facility_id = a.facility_id and eff_status = 'E' and pseudo_bed_yn = 'N' ) total_beds,(select count(*) from ip_nursing_unit_bed where nursing_unit_code = a.nursing_unit_code and facility_id = a.facility_id and eff_status = 'E' and pseudo_bed_yn = 'N' and current_status = 'A')available, ");
				sql.append(" (select count(*) from ip_nursing_unit_bed where nursing_unit_code = a.nursing_unit_code and facility_id = a.facility_id and eff_status = 'E' and pseudo_bed_yn = 'N'   and current_status = 'O' )occupied ");
				/*Monday, April 19, 2010 , added for Nurisng Unit Lookup fine tuning....*/
				sql.append(",nvl((SELECT SUM(CASE WHEN BOOKING_TYPE IN('B','N','L','T','D') THEN 1 ELSE 0 END) Blocked FROM IP_BED_BOOKING WHERE facility_id = a.facility_id AND req_nursing_unit_code = a.nursing_unit_code AND booking_status IN('0','1') AND (SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time OR blocked_until_date_time IS NULL )),0)blocked ");
				/**/
				sql.append(" from IP_NURSING_UNIT_LANG_VW a,AM_OS_USER_LOCN_ACCESS_VW c ");

				if(call_function.equals("Admit_patient") || (call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")&&!specilaty_code.equals("")) )
					sql.append(",IP_NURS_UNIT_FOR_SPECIALTY e");

				if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
					sql.append(",IP_MED_SER_GRP_NURS_UT_TYPE e,IP_NURS_UNIT_FOR_SPECIALTY f ");

				if((call_function.equals("IP_Booking")  || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))&& !practitioner_id.equals(""))
					/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
					sql.append(" ,IP_NURSING_UNIT_FOR_PRACT g ");
			
				if(bkg_type.equals("D") && !room_no.equals(""))
					sql.append(",IP_NURSING_UNIT_ROOM d ");
				
				sql.append(" where c.locn_type = 'N' and c.locn_code = a.nursing_unit_code and language_id = '"+locale+"' and a.facility_id ='"+facility_id+"' and a.eff_status = 'E' and ");

				if(bkg_type.equals("D") && !room_no.equals(""))
				{
					sql.append(" a.facility_id = d.facility_id and d.room_no = '"+room_no+"' and a.nursing_unit_code = d.nursing_unit_code and ");
				}
		
				//added by kishore on 8/13/2004
				//	if(bkg_type.equals("D"))
				/*Modified by Dharma on July 25 2014*/
				if(bkg_type.equals("D") && !clinic_code.equals(""))
				{
					sql.append(" a.nursing_unit_code in ( select a.nursing_unit_code code from ip_dc_unit_for_nurs_unit_vw a, am_os_user_locn_access_vw b where a.facility_id = '"+facility_id+"' and a.facility_id = b.facility_id and a.nursing_unit_code = b.locn_code and b.locn_type = 'N' and b.oper_stn_id = '"+oper_stn_id+"' and b.appl_user_id ='"+login_user+"' and a.clinic_code ='"+clinic_code+"') and ");
				}
				
				//sql.append(" c.facility_id  = a.facility_id  and c.locn_type = 'N' and c.locn_code  = a.nursing_unit_code and  c.appl_user_id = '"+login_user+"' ");
				sql.append("  c.facility_id  = a.facility_id   and  c.appl_user_id = '"+login_user+"' ");
				sql.append(" and c.oper_stn_id = '"+oper_stn_id+"'");

				//Condition for Admit Patient
				if(call_function.equals("Admit"))
				{
					sql.append(" and (c.ADMIT_PAT_YN = 'Y' or c.ADMIT_PATIENT_WITH_BED_YN = 'Y') ");
				}

				if(call_function.equals("Admit_patient"))
				{
					sql.append(" and e.SPECIALTY_CODE = '"+specilaty_code+"' AND e.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND e.facility_id = a.facility_id ");
				}
			
			//Condition Added  For Change Patient Details  @ 3/16/2009
				if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")&&!specilaty_code.equals("")){
					sql.append(" and e.SPECIALTY_CODE = '"+specilaty_code+"' AND e.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND e.facility_id = a.facility_id ");
				}
				if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))
					/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
				{
					sql.append(" and e.FACILITY_ID = a.FACILITY_ID and e.MED_SER_GRP_CODE ='"+med_serv_grp_code+"' and e.NURSING_UNIT_TYPE_CODE = a.NURSING_UNIT_TYPE_CODE and f.FACILITY_ID = a.FACILITY_ID AND f.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND f.SPECIALTY_CODE = '"+specilaty_code+"' ");
				}
				if((call_function.equals("IP_Booking")|| call_function.equals("CA_Task_IP_Booking")  || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))&& !practitioner_id.equals("") )
				/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
				{
					sql.append(" and g.FACILITY_ID = a.FACILITY_ID AND g.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND g.PRACTITIONER_ID = '"+practitioner_id+"'  ");
				}

				if(call_function.equals("IP_ConfirmBooking"))
					sql.append(" and (c.CONFIRM_BOOKING_YN = 'Y' OR c.CREATE_BOOKING_WITH_CONF_YN = 'Y') ");

				if(call_function.equals("Revise_Booking") || call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("OT"))
					sql.append(" and (c.CREATE_BOOKING_YN = 'Y' OR c.CREATE_BOOKING_WITH_CONF_YN = 'Y') ");
				/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */	

				//Condition for Transfer BLOCK BED
				if(call_function.equals("BLOCK_BED"))
					 sql.append(" and (c.BLOCK_BED_YN = 'Y') ");
				//Condition for Transfer BLOCK BED
				if(call_function.equals("RELEASE_BED"))
					 sql.append(" and (c.RELEASE_BED_YN = 'Y') ");
				//Condition for Cancel Admission
				if(call_function.equals("CancelAdmission"))
					sql.append(" and (c.CANC_ADMISSION_YN = 'Y') ");
				//Condition for Assign Bed
				if(call_function.equals("assign_bed"))
					sql.append(" and (c.ASSIGN_BED_YN = 'Y' ) ");
				//Condition for AssignTreatingPract
				if(call_function.equals("AssignTreatingPract"))
					 sql.append(" and (c.ASSIGN_TREAT_PRACT_YN = 'Y') ");
				//Condition for ExpectedDischarge
				if(call_function.equals("ExpectedDischarge"))
					sql.append(" and (c.ADMIT_PAT_YN = 'Y') ");
				//Condition for Transfer Patient 
				if(call_function.equals("TransferPatient"))
					 sql.append(" and (c.EMERGENCY_TFR_YN = 'Y') ");
				//Condition for SWAP PATIENT BED 
				if(call_function.equals("SWAP_PAT_BED"))
					sql.append(" and (c.SWAP_BED_YN = 'Y') ");
				//Condition for TransferPractitioner 
				if(call_function.equals("TransferPractitioner"))
					sql.append(" and (c.PRACT_TRANSFER_YN = 'Y') ");
				//Condition for TransferPractitioner 
				if(call_function.equals("RequestforTransfer"))
					sql.append(" and (c.ROUTINE_TFR_YN = 'Y') ");
				//Condition for Transfer Patient OUT Criteria
				if(call_function.equals("TransferPatientOut"))
					sql.append(" and (c.TRANSFER_OUT_PATIENT_YN = 'Y') ");
				//Condition for Transfer Patient In Criteria
				if(call_function.equals("TransferPatientIn"))
					sql.append(" and (c.TRANSFER_IN_PATIENT_YN = 'Y') ");
				//Condition for Cancle Transfer Patient Out Criteria
				if(call_function.equals("CancelTransferPatientOut"))
					sql.append(" and (c.CANCEL_TRANSFER_OUT_YN = 'Y') ");
				//Condition for Confirm Request Transfer Criteria
				if(call_function.equals("CONFIRM_TRANS_BOOKING"))
					sql.append(" and (c.CONFIRM_REQUEST_YN = 'Y') ");
				//Condition for Cancle Request Transfer Criteria
				if(call_function.equals("CANCEL_TRANS_BOOKING"))
					sql.append(" and (c.CANCEL_REQUEST_YN = 'Y') ");
				//Condition for Confirm Bed Class Criteria
				if(call_function.equals("ConfirmBedClass"))
					sql.append(" and (c.BED_CLASS_CHANGE_YN = 'Y') ");
				//Condition for Prepare Discharge Advice Criteria
				if(call_function.equals("PrepareDischargeAdvice"))
					 sql.append(" and (c.DISCHARGE_ADVICE_YN = 'Y') ");
				//Condition for Discharge Patient Criteria
				if(call_function.equals("DischargePatient"))
					sql.append(" and (c.DISCHARGE_PAT_YN = 'Y') ");
				//Condition for Checkin Accompaning Person Criteria
				if(call_function.equals("CHECK_IN_ACCMP_PERSON"))
					sql.append(" and (c.CHECK_LODGER_YN = 'Y') ");
				//Condition for Record Inpatient Leave / Amend Inpatient Leave Criteria
				if(call_function.equals("RecordInpatienLeave")||call_function.equals("AMEND_LEAVE"))
				  sql.append(" and (c.REVISE_LEAVE_YN = 'Y') ");
				//Condition for Transfer Patient In
				if(call_function.equals("Transfer_In"))
					sql.append(" and (c.TRANSFER_IN_PATIENT_YN = 'Y') ");
				//Condition for New Born Reg
				if(call_function.equals("NEWBORN_REG") || call_function.equals("BabyLinktoMother"))
					sql.append(" and (a.ALLOW_NEW_BORN_REGN_YN ='Y') ");

				//Condition for AssignBed after Admit patient
				/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if change nursing unit in assign bed is unchecked in AM->operator station restriction function , c.chg_nurs_unit_in_assign_bed_yn = 'Y' added */
				if(call_function.equals("ASSIGN_BED"))
					sql.append(" and (c.assign_bed_yn = 'Y' and c.chg_nurs_unit_in_assign_bed_yn = 'Y') and  a.locn_type=c.locn_type ");

				//Condition for RENEW_GATE_PASS
				if(call_function.equals("RENEW_GATE_PASS") || call_function.equals("CHECK_OUT_ACCMP_PERSON") || call_function.equals("CHECK_OUT_LODGER") )
					sql.append(" and (c.CHECK_LODGER_YN = 'Y') ");

				//Condition for Emergency Transfer Patient 
				if(call_function.equals("EMERGENCY_TRANSFER"))
					 sql.append(" and (c.EMERGENCY_TRANSFER_YN = 'Y') ");
				//Condition Added For Change Patient Details  @ 3/16/2009
				if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT"))
					sql.append(" and (c.revise_admission_yn='Y') ");
			

		

			}
			/*//Condition Added For Change Patient Details  @ 3/16/2009
			if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){
				sql.append(" and (c.revise_admission_yn='Y') ");
			}*/

			// This is for where criteria for the query
			if(!patient_class.equals("")) 
				sql.append(" and a.PATIENT_CLASS='"+patient_class+"' ");
			
			if(!nursing_unit_desc.equals(""))
			{
				whereClause = " and upper(a.SHORT_DESC) like ";
				if(start_ends_contains.equals("S"))
				{
					nursing_unit_desc=nursing_unit_desc+"%";
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("E"))
				{
					nursing_unit_desc="%"+nursing_unit_desc;
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("C"))
				{
					nursing_unit_desc="%"+nursing_unit_desc+"%";
					whereClause=whereClause+"upper(?)";
				}
			}
			else  if(!nursing_unit_code.equals(""))
			{
				whereClause = " and upper(A.Nursing_unit_code) like ";
				if(start_ends_contains.equals("S"))
				{
					nursing_unit_code=nursing_unit_code+"%";
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("E"))
				{
					nursing_unit_code="%"+nursing_unit_code;
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("C"))
				{
					nursing_unit_code="%"+nursing_unit_code+"%";
					whereClause=whereClause+"upper(?)";
				}
			}
			
			sql.append(whereClause);
			sql.append(" ORDER BY "+radioval);	
		}	
		else
		{
			sql.append(user_sql);
		}


		int start			= 0 ;
		int end				= 0 ;
		int k				= 0;
		int nRowCount =0; // this line and added  for ICN-64475
		if (( from == null ) ||(from == ""))
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if (( to == null ) ||(to == ""))
			end = 14 ;
		else
			end = Integer.parseInt(to);
		try
		{
		
			pstmt = conn.prepareStatement(sql.toString());

			if(!nursing_unit_desc.equals(""))
			{
				pstmt.setString(1, nursing_unit_desc);
			}
			else if(!nursing_unit_code.equals(""))
			{
				pstmt.setString(1, nursing_unit_code);
			}
			/*Monday, April 19, 2010 , commented for Nurisng Unit Lookup fine tuning.... & added in main query */
			/*
			rs1	= pstmt.executeQuery();
			while(rs1.next())
			{
				//k++;
			}
		
			if(rs1!=null) rs1.close();
			rs1	= pstmt.executeQuery();
			Hashtable block_bed = new Hashtable();
			Vector block = new Vector();
			while(rs1.next())
			{
				k++;
				block.add(rs1.getString("nursing_unit_code"));
			}

			if(rs1!=null) rs1.close();
				
			String sbTmp = new String();			

			sbTmp = "Select sum(case when BOOKING_TYPE IN('B','N','L','T','D') then 1 else 0 end) Blocked from IP_BED_BOOKING where facility_id = '"+facility_id+"' and req_nursing_unit_code = ? and booking_status in('0','1') and ( sysdate between blocked_from_date_time and blocked_until_date_time OR blocked_until_date_time IS NULL )";			
			pstmt_block = conn.prepareStatement(sbTmp);


			// This code is used for finding any blocked beds are there for the nursing units.

			for(int b=0;b<block.size();b++)
			{				
				pstmt_block.setString(1, block.elementAt(b).toString());

				rs1 = pstmt_block.executeQuery();
				
				while(rs1.next())
				{
					String temp = rs1.getString("blocked");
					if(temp == null)
						temp = "0";
					block_bed.put(block.elementAt(b),temp);
				}
			}
			
			if(rs1!=null) rs1.close();
			if(pstmt_block!=null) pstmt_block.close();
			
			
			// If there are no records then message will be fired...
			if(k == 0)
			{
				<!--<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));                      
					if(parent.frames[0].document.getElementById('nursing_unit_desc'))                   		
						parent.frames[0].document.getElementById('nursing_unit_desc').readOnly=false;      
					if(parent.frames[0].document.getElementById('Search'))                                     
						parent.frames[0].document.getElementById('Search').disabled=false;                 
					if(parent.frames[0].document.getElementById('clear'))
						parent.frames[0].document.getElementById('clear').disabled=false;	
					document.location.href='../../eCommon/html/blank.html'
				</script>-->
		//	}/*Monday, April 19, 2010 , commented for Nurisng Unit Lookup fine tuning.... & added in main query */
			rs = pstmt.executeQuery();
			session.removeAttribute("SQL_GENNUR");//Added by Kamatchi S for MOHE-SCF-0134
			if(rs != null)
			{
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ ){
					
					rs.next() ;
				}
				
				
				
//			while((i<=(end+1))&&(rs.next()))
				while((rs.next()))
				{
				nRowCount = Integer.parseInt(rs.getString("rowCount"));	 // added  for ICN-64475
					
                  if(i<=(end)){
					if(k == 0)
					{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
 

						session.setAttribute("SQL_GENNUR",sql.toString());//Added by Kamatchi S for MOHE-SCF-0134
						// This code is used for next previous navigation 
						if ( !(start <= 1) )
						{
							/*Friday, June 04, 2010 , condition added for SRR20056-SCF-4564-IN021691*/
							if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))
							{
								out.println("<td align ='right' id='prev'><A HREF='javascript:submitPrevNext("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
							}else
							{
								//Commented by Kamatchi S for MOHE-SCF-0134
								/*out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql="+URLEncoder.encode(sql.toString())+"&from="+(start-14)+"&to="+(end-14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");*/
								out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql=SQL_GENNUR&from="+(start-14)+"&to="+(end-14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
							}
							
						}
						//if ( !( (start+14) > k ) )
							/*Friday, June 04, 2010 , condition added for SRR20056-SCF-4564-IN021691*/
							if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))
							{
								out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='javascript:submitPrevNext("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							}
							else
							{
								//Commented by Kamatchi S for MOHE-SCF-0134
								/*out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql="+URLEncoder.encode(sql.toString())+"&from="+(start+14)+"&to="+(end+14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");*/
								out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql=SQL_GENNUR&from="+(start+14)+"&to="+(end+14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							}
							
							
					
            _bw.write(_wl_block10Bytes, _wl_block10);
if(dispDescFirst.equals("dispDescFirst")||statics_yn.equals("")||statics_yn.equals("N")) 
			{
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
} 
			else if(statics_yn.equals("Y"))
			{
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);

				}
				
					
            _bw.write(_wl_block19Bytes, _wl_block19);

					String rowclass		= "" ;

					if ( i % 2 == 0 )
						rowclass = "QRYEVEN" ;
					else
						rowclass = "QRYODD" ;
					code				= rs.getString("nursing_unit_code");
					desc				= specialCharacter(rs.getString("short_desc"));
					pat_class			= rs.getString("APPL_PATIENT_CLASS");
					pat_class_desc		= rs.getString("patient_class");
					if(pat_class_desc.equals("IP"))
						pat_class_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
					else 
						pat_class_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

					String total_beds	= "";
					String occupied_beds= "";
					String blocked_beds	= "";
					String vacant_beds	= "";
					if(statics_yn.equals("Y"))
					{
						total_beds		=	rs.getString("total_beds");
						occupied_beds	=	rs.getString("Occupied");
						//blocked_beds	=   (String)block_bed.get(code);
						blocked_beds	=   rs.getString("blocked");
						if(blocked_beds == null) blocked_beds = "0";
						vacant_beds		= Integer.parseInt(total_beds) - Integer.parseInt(occupied_beds) - Integer.parseInt(blocked_beds) + "";
						/*4/1/2009 IN009426 */
						vacant_beds		= Integer.parseInt(vacant_beds) < 0 ? "0" : vacant_beds +"";
						/**/
						linkColor		= Integer.parseInt(total_beds) == 0 ? "" : "COLOR:BLUE;cursor:pointer;";
					}
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
		//this case is redundant as of now....
					if(dispDescFirst.equals("dispDescFirst")||statics_yn.equals("")||statics_yn.equals("N")) 
					{
						if(!locale.equals("en"))
						{	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
	}
						else	
						{	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
	}	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pat_class_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);

					}
					else if(statics_yn.equals("Y"))
					{
						if(!locale.equals("en"))
						{ 
							out.print("<a href=\"javascript:close_window('"+code+"','"+i+"','"+pat_class+"','"+desc+"')\">"+code+"</a></td>");
						} 
						else
						{
						
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code));
            _bw.write(_wl_block34Bytes, _wl_block34);
	}	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(pat_class_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(linkColor));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(total_beds));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(linkColor));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(occupied_beds));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(linkColor));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(blocked_beds));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(linkColor));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vacant_beds));
            _bw.write(_wl_block46Bytes, _wl_block46);

					}
				}
					i++;
					k++;
				}
				if(i == 2) 
				{
					
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block50Bytes, _wl_block50);

				}
				if(k == 0)
				{
            _bw.write(_wl_block51Bytes, _wl_block51);
	}
				
            _bw.write(_wl_block52Bytes, _wl_block52);

			} 
				
				

				//if ( (k < 14) && (!rs.next()) ) // commented this line and added new line for ICN-64475
				if ( k<14 || (end >= nRowCount) ) 
				{
				
            _bw.write(_wl_block53Bytes, _wl_block53);
 
				}
				else
				{
            _bw.write(_wl_block54Bytes, _wl_block54);

				}
		}
		catch(Exception e) { out.println(e.toString()); e.printStackTrace();}
		
		
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(searchtext));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(start));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(end));
            _bw.write(_wl_block58Bytes, _wl_block58);
            _bw.write(_wl_block59Bytes, _wl_block59);

	}
	catch(Exception e) {
		
		e.printStackTrace();
		
		}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(pstmt_block!=null) pstmt_block.close();
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
		if (conn != null)
		ConnectionManager.returnConnection(conn,request);

		}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApplicableTo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApplicableTo.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noofbeds.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedsOccupied.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedsBlocked.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedsVacant.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
