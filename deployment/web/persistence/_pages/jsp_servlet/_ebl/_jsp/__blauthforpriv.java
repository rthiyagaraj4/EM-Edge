package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.io.*;
import webbeans.op.CurrencyFormat;
import eOR.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __blauthforpriv extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAuthForPriv.jsp", 1709114403103L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<!--\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t-->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n<!-- \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t<script language=\"javascript\" src=\'../js/PkgAdhocDiscount.js\'></script> \n\t\n\t<script language=\'javascript\'>\n\t\t\tfunction retModal(obj)\n\t\t\t{\t\t\n\t\t\t\tvar returnArray = \"N\";\n\t\t\t\tparent.window.returnValue = returnArray;\n\t\t\t\t\n\t\t\t}\n\n\t\t\tfunction confirmPasswdchk(obj)\n\t\t\t{\t\t\t\t\n\t\t\t\tvalidateUserPassForPriv(obj);\n\t\t\t}\n\t\t\t\n\t\t\tfunction validateUserPassForPriv(obj)\n\t\t\t{\t\t\n\t\t\t\tvar usr_id=document.forms[0].user_id.value;\n\t\t\t\tvar pass_wd=document.forms[0].passwd.value;\n\t\t\t\tvar auth_resn=document.forms[0].auth_resn.value;\n\t\t\t\tvar auth_resn_code=document.forms[0].auth_resn_code.value;\n\t\t\t\tvar priv_code = document.forms[0].priv_code.value;\t\n\t\t\t\tvar functionID = document.forms[0].functionID.value;\n\t\t\t\tvar facility_id = document.forms[0].facility_id.value;\n\t\t\t\tvar prespid = document.forms[0].prespid.value;;\n\t\t\t\tvar payer_group = document.forms[0].payer_group.value;;\n\t\t\t\tvar payer = document.forms[0].payer.value;\n\t\t\t\tvar policy = document.forms[0].policy.value;\n\t\t\t\tvar currentDt = document.forms[0].currentdate.value;\n\t\t\t\t\t\n\t\t\t\tif(usr_id==\"\")\n\t\t\t\t{\n//\t\t\t\t\talert(getMessage(\"BL9112\"));\n\t\t\t\t\talert(getMessage(\"BL9112\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].user_id.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif(pass_wd==\"\")\n\t\t\t\t{\n//\t\t\t\t\talert(getMessage(\"BL9113\"));\n\t\t\t\t\talert(getMessage(\"BL9113\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].passwd.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\tif(auth_resn == \"\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL0986\",\"BLEXT\"));\n\t\t\t\t\tdocument.forms[0].auth_resn.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr+= \"usr_id=\\\"\" + usr_id + \"\\\" \" ;\t\t\n\t\t\t\txmlStr+= \"pass_wd=\\\"\" + pass_wd + \"\\\" \" ;\n\t\t\t\txmlStr+= \"priv_code=\\\"\" + priv_code + \"\\\" \" ;\t\t\t\t\t\t\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\tvar temp_jsp=\"BLAuthForPrivValidation.jsp?functionID=\" + functionID+\"&facility_id=\"+facility_id+\"&prespid=\"+prespid+\"&payer_group=\"+payer_group+\"&payer=\"+payer+\"&policy=\"+policy+\"&currentdate=\"+currentDt;\t\t\t\t\t\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar responseText=trimString(xmlHttp.responseText);\t\n\t\t\t\t//Added V190828-Gomathi/GHL-SCF-1436 Starts\n\t\t\t\tresponseText = responseText.split(\":::\");\t\n\t\t\t\tif(responseText[1]==\"D\")\t\t\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'BL1025\',\'BL\'));\n\t\t\t\t\treturn false;\n\t\t\t\t} \n\t\t\t\t//Added V190828-Gomathi/GHL-SCF-1436 Ends\n\t\t\t\tif(responseText[0]==\"Y\")\t\t//Added array[] for split the values\n\t\t\t\t{\n\t\t\t\t\twindow.parent.returnValue=\"Y\"+\"~\"+usr_id+\"~\"+auth_resn_code; // added for CRF-076.2\n\t\t\t\t\twindow.close();\n\t\t\t\t}\n\t\t\t\telse if(responseText[0]==\"U\"){\t\t//Added array[] for split the values\n\t\t\t\t\talert(getMessage(\'BL9539\',\'BL\'));\n\t\t\t\t}else if(responseText[0]==\"A\"){\t\t//Added array[] for split the values\n\t\t\t\t\talert(getMessage(\'BL0968\',\'BLEXT\'));\n\t\t\t\t}else{\n\t\t\t\t\talert(getMessage(\'BL1232\',\'BL\'));\n\t\t\t\t}\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\tfunction funAuthReasonLkup()\n\t\t\t{\n\t\t\t\tvar dialogTop\t\t\t= \"40\";\n\t\t\t\tvar dialogHeight\t\t= \"10\" ;\n\t\t\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\t\tvar title=getLabel(\"eBL.ListOfReasons.label\",\"BL\"); \n\t\t\t\ttitle=encodeURIComponent(title);\n\t\t\t\tvar column_sizes = escape(\"70%,30%\");               \n\t\t\t\tvar reasons=getLabel(\"eBL.Reasons.label\",\"common\");\n\t\t\t\tcashcntrcode=encodeURIComponent(reasons);\n\t\t\t\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\t\t\t\tdesc=encodeURIComponent(desc);\n\t\t\t\tvar column_descriptions = desc+\",\"+reasons;\n\t\t\t\tvar locale = document.getElementById(\'locale\').value;\n\t\t\t\tvar reason_code = document.getElementById(\"reason_code\").value;\n\t\t\t\tvar sql = \"\" ; \n\t\t\t\t\n\t\t\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\"+\"&called_for=PRIV_AUTH_REASON_LKUP&locale=\"+locale+\"&target=\"+document.getElementById(\"auth_resn\").value+\"&reason_code=\"+reason_code;\n\t\t\t\t\n\t\t\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\t\t\t\tvar arr=new Array();\n\n\t\t\t\tif(retVal == null) retVal=\'\';\n\t\t\t\t\t\n\t\t\t\tif (retVal != null || retVal!=\'\')\n\t\t\t\t{\t\n\t\t\t\t\tvar retVal=unescape(retVal);\n\t\t\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tarr=retVal.split(\"^~^\");\n\t\t\t\t\t\tdocument.getElementById(\"auth_resn\").value=arr[0];\n\t\t\t\t\t\tdocument.getElementById(\"auth_resn_code\").value=arr[1];\t\t\t\n\t\t\t\t\t} else {\n\t\t\t\t\t\talert(getMessage(\"BL0987\",\"BLEXT\"));\n\t\t\t\t\t\tdocument.getElementById(\"auth_resn\").focus();\t\n\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t} else {\n\t\t\t\t\talert(getMessage(\"BL0987\",\"BLEXT\"));\n\t\t\t\t\tdocument.getElementById(\"auth_resn\").focus();\t\n\t\t\t\t}\n\t\t\t}\n\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title> \n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<center>\n<form name=\'AuthForm\' id=\'AuthForm\'>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\n<tr>\n\t<td colspan=15>&nbsp;</td>\n</tr>\n\n\n <tr>\n\t<td width=\"50%\" class=\"label\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td width=\"50%\" class=\"fields\"><input type=\'text\' name=\'user_id\' id=\'user_id\' size=\'20\' maxlength=\'20\' onKeyPress=\'return makeUpperCase()\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n </tr>\n <tr>\n\t<td width=\"50%\" class=\"label\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td width=\"50%\" class=\"fields\"><input type=\'password\' name=\'passwd\' id=\'passwd\' size=\'21\' maxlength=\'64\'><img src=\'../../eCommon/images/mandatory.gif\'></td> \n </tr>\n <tr>\n\t<td width=\"50%\"class=\"label\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td width=\"50%\" class=\"fields\">\n\t\t<input type=\"text\" name=\"auth_resn\" id=\"auth_resn\" id=\"auth_resn\" value=\'\' onBlur=\"funAuthReasonLkup()\" />\n\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funAuthReasonLkup()\" />\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t<input type= \'hidden\' name=\"auth_resn_code\" id=\"auth_resn_code\"  value=\'\'>\n\t</td>\n </tr>\n<tr>\n\t<td width=\"50%\"></td>\n\t<td width=\"50%\">\n\t<input type=\'button\' class=\'button\' name=\'auth_ok\' id=\'auth_ok\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onClick =\'return confirmPasswdchk(this);\'>\n\t<input type=\'button\' class=\'button\' name=\'auth_cancel\' id=\'auth_cancel\'  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onClick=\'parent.window.close(); return retModal(this);\'>\n\t</td>\t\n</tr>\n\n<tr>\n\t<td colspan=15>&nbsp;</td>\n</tr>\n<tr>\n\t<td colspan=15>&nbsp;</td>\n</tr>\n\n\t<script>\n\t\tdocument.forms[0].user_id.focus();\n\t</script>\n</table>\n<input type= \'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\n<input type= \'hidden\' name=\"functionID\" id=\"functionID\"  value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type= \'hidden\' name=\"facility_id\" id=\"facility_id\"  value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type= \'hidden\' name=\"userid\" id=\"userid\"  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type= \'hidden\' name=\"prespid\" id=\"prespid\"  value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type= \'hidden\' name=\"payer_group\" id=\"payer_group\"  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type= \'hidden\' name=\"payer\" id=\"payer\"  value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type= \'hidden\' name=\"policy\" id=\"policy\"  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type= \'hidden\' name=\"priv_code\" id=\"priv_code\"  value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type= \'hidden\' name=\"currentdate\" id=\"currentdate\"  value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type= \'hidden\' name=\"reason_code\" id=\"reason_code\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\n</form>\n</center>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

	Connection con = null;
//	PreparedStatement pstmt = null ;	
	Statement stmt = null; 
	ResultSet rs1=null;	

	try
	{
	
	con	=	ConnectionManager.getConnection(request);

	
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	
	String functionID = request.getParameter("functionID");
	if(functionID==null) functionID="";
	
	String facility_id = request.getParameter("facility_id");
	if(facility_id==null) facility_id="";
	
	String userid = request.getParameter("userid");
	if(userid==null) userid="";
	
	String prespid = request.getParameter("prespid");
	if(prespid==null) prespid="";
	
	String payer_group = request.getParameter("payer_group");
	if(payer_group==null) payer_group="";
	
	String payer = request.getParameter("payer");
	if(payer==null) payer="";
	
	String policy = request.getParameter("policy");
	if(policy==null) policy="";
	
	String priv_code = request.getParameter("previlage");
	if(priv_code==null) priv_code="";
	
	String currentdate = request.getParameter("currentdate");
	if(currentdate==null) currentdate="";
		
	String reason_code = request.getParameter("reason_code");
	if(reason_code==null) reason_code="";

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(functionID));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(prespid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(payer_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(policy));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(priv_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(reason_code));
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
	catch(Exception ee)
	{
	  System.err.println("Error in BLFinDetailsAuthorise.jsp: " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AUTH_SCREEN.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
}
