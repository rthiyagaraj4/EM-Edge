package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __md_addmodifypractforteamresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/md_addModifyPractForTeamResult.jsp", 1740033799799L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nvar roleValue = new Array();\n\tasync function showPractWindow(practID)\n\t{\n\t    var url     = \"../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id=\"+practID+\"&fcall=call\";\n\t    var dialogHeight    = \"80vh\" ;\n\t\t/* below lines moidified by Venkatesh.S agasint 57984 on 07-01-2015 */\n\t    var dialogWidth = \"80vw\" ;\n\t\t/*End 57984 */\n\t    var dialogLeft=\"\";\n\t    var arguments   = \"\" ;\n\t    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no;dialogLeft:\"+dialogLeft+\";\";\n\t    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;\n\t}\n\n\tfunction submitPrevNext(from, to){\n\t\tvar count=0;\n\t\tvar arr = new Array();\n\t\tfor(var u=0;u<document.forms[0].maxRecord.value;u++)\n\t\t{\n\t\t\tif(eval(\"document.forms[0].role\"+u))\n\t\t\t{\t\n\t\t\t\t//Added on 3/15/2005\n\t\t\t\tdocument.forms[0].roleValue.value += eval(\"document.forms[0].role\"+u).value + \"#\";\n\t\t\t\t//End\n\t\t\t\tif(eval(\"document.forms[0].role\"+u).value == \'C\')\n\t\t\t\t{\n\t\t\t\tarr[count]=eval(\"document.forms[0].role\"+u).value;\t\t\t\t\n\t\t\t\tcount++;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\n        if(parent.frames[0].flag==true){\n\t\tif( arr.length ==  1) parent.frames[0].flag=false;\n\t\telse\n\t\tparent.frames[0].flag=true;\n        }\n\n\t\tdocument.forms[0].totRoleId.value=parent.frames[0].rowId;\n\t\tdocument.forms[0].start.value = from;\n\t\tdocument.forms[0].to.value = to;\t   \n\t\tdocument.forms[0].action = \'../../eAM/jsp/md_addModifyPractForTeamResult.jsp\';\n\t\tdocument.forms[0].target = \"_self\";\n\t\tvar search_txt = document.forms[0].search_txt.value;\n\t\tvar search_by = document.forms[0].search_by.value;\n\n\t\tvar facility_id = document.forms[0].facilityID.value;\n\t\tvar from = from;\n\t\tvar to = to;\n\t\tvar speciality_code=document.forms[0].speciality_code.value;\n\t\tvar team_id = document.forms[0].team_id.value;\n\n\t/*\tif(confirm(\'Do you want to submit the current page\'))\n\t\t\t{\n\t\t\t \n\t\t\tparent.frames[0].apply(\'Y\');\n\t\t\talert(\"yes\");\n\t\t\tdocument.location.href=\"../../eAM/jsp/md_addModifyPractForTeamResult.jsp?facilityID=\"+facility_id+\"&start=\"+from+\"&to=\"+to+\"&speciality_code=\"+speciality_code+\"&team_id=\"+team_id+\"&search_txt=\"+search_txt+\"&search_by=\"+search_by;\n\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tdocument.location.href=\"../../eAM/jsp/md_addModifyPractForTeamResult.jsp?facilityID=\"+facility_id+\"&start=\"+from+\"&to=\"+to+\"&speciality_code=\"+speciality_code+\"&team_id=\"+team_id+\"&search_txt=\"+search_txt+\"&search_by=\"+search_by;\n\t\t\t\n\t\t\t} */\n\t   document.forms[0].submit();\n\t\tparent.parent.window.frames[2].location.href=\"../../eCommon/jsp/error.jsp\";\n\t    document.forms[0].finalSelect.value=parent.frames[0].temp;\n\t\t//alert(document.forms[0].finalSelect.value);\n\t}\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</head>\n\n<body  OnMouseDown=\"CodeArrest();\"  class=\'CONTENT\' onKeyDown = \'lockKey()\'>\n<form name=\'pract_for_team_result\' id=\'pract_for_team_result\' action=\'../../eAM/jsp/md_addModifyPractForTeamResult.jsp\' method=\'post\' >\n<input type=\"hidden\" name=\"roleValue\" id=\"roleValue\" value=\'\'>\n<input type=\"hidden\" name=\"pageAction\" id=\"pageAction\" value=\"\">\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\"white\">\n\t\t\t<table border=\'0\' align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'totRoleId\' id=\'totRoleId\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'maxRecord\' id=\'maxRecord\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\n\t\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'team_id\' id=\'team_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'facilityID\' id=\'facilityID\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'search_txt\' id=\'search_txt\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t\t\n\n\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t    <td align =\'right\' id=\'prev\'><a href=\'javascript:document.forms[0].pageAction.value=\"P\";javascript:submitPrevNext(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =",";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></td>\n\t\t\t\t    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t    <td align =\'right\' id=\'next\' style=\'visibility:hidden\'><a href=\'javascript:document.forms[0].pageAction.value=\"N\";javascript:submitPrevNext(";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a></td>\n\t\t\t\t    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnheader\' width=\'1%\' >&nbsp;</td>\n\t\t\t\t<td class=\'columnheader\' width=\'79%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t<td class=\'columnheader\' width=\'10%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\'1%\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'><a href=javaScript:showPractWindow(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')>+</a></td>\n\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' align=\'center\'><select name=\'role";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'role";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onChange=\"parent.frames[0].populateRole(this,chk";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =",\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\"><option value=\'S\'>--------";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="-------<option value=\'C\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<option value=\'M\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</select></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' align=\'center\'><input type=\'checkbox\' name=\'chk";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'chk";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick=\"parent.frames[0].finalSelect(this,role";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\"></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String finalSelect=request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
	
	String strRoleValue = (request.getParameter("roleValue")==null)?"":request.getParameter("roleValue");

	String strPageAction = (request.getParameter("pageAction")==null)?"":request.getParameter("pageAction");
	String from = request.getParameter("start") ;
    String to = request.getParameter("to") ;
	String totRoleId = request.getParameter("totRoleId");
	if(totRoleId == null) totRoleId="";
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";

	if(search_by.equals("01"))
	   search_by="PRACTITIONER_ID";
    else if(search_by.equals("02"))
	   search_by="PRACTITIONER_NAME";


	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
        //int i3=1;

          if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }

	//Added on 3/15/2005

	String strClearSession = (String)request.getParameter("clsSessRoleValue");
	if(strClearSession != null && strClearSession.equals("Y"))		
		session.removeValue("roleValue");

	HashMap hmRole=null;
	if(session.getValue("roleValue") == null){
		hmRole = new HashMap();			
	}else{
		hmRole = (HashMap)session.getValue("roleValue");		
	}
	if(strPageAction.equals("N")){
		hmRole.put((start-14)+"_"+(end-14),strRoleValue);
	}else if(strPageAction.equals("P")){
		hmRole.put((start+14)+"_"+(end+14),strRoleValue);
	}
	session.putValue("roleValue",hmRole);

String facility_id = request.getParameter("facilityID");
	if(facility_id == null) facility_id="";

String team_id= request.getParameter("team_id");
if(team_id == null) team_id="";
String speciality_code= request.getParameter("speciality_code");
if(speciality_code == null) speciality_code="";

String sql=" Select practitioner_id, practitioner_name, Practitioner_Role, upper(practitioner_name) from am_pract_for_team_vw where Facility_Id = '"+facility_id+"' and team_id ='"+team_id+"' ";
if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" Union  Select Practitioner_Id, Practitioner_Name, 'S', upper(practitioner_name) from am_pract_for_speciality_vw where facility_id ='"+facility_id+"' and speciality_code = '"+speciality_code+"'   ";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+"and  Practitioner_ID not in (Select Practitioner_Id from am_pract_for_team_vw Where Facility_ID ='"+facility_id+"' and team_id ='"+team_id+"') ";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" Union Select Practitioner_Id, Practitioner_Name Practitioner_Short_Name, 'S' , upper(practitioner_name)from  am_pract_for_facility_vw where operating_facility_id = '"+facility_id+"'  AND Primary_Speciality_code ='"+speciality_code+"'";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" and Practitioner_ID not in (Select Practitioner_Id from am_pract_for_team_vw  Where 	facility_id ='"+facility_id+"' and Team_ID ='"+team_id+"' ";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" ) order by 4";

//out.println("sql :"+sql);
		
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null ;

	try
	{
		con = ConnectionManager.getConnection(request);
		try
		{

		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		
	
		rs.beforeFirst();

		while(rs.next()){
     		String avlChief = rs.getString("PRACTITIONER_ROLE");
			if(avlChief.equals("CHIEF")){
				out.println("<script>parent.frames[0].flag=false;</script>");
	   		}
		}
		rs.beforeFirst();
		}catch(Exception e){}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(totRoleId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
			if (start != 0){
			for(int j=1; j<=start-1; i++,j++){
			rs.next() ;
			}
			}

			int iStartIndex = i;
		
			int iEnd = end;
			if(end == 12)
			iEnd++;
			
			while(rs.next() && i<iEnd){
				if(maxRecord==0)
				{

            if ( !(start <= 1)) {
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

		    }
		//    if ( !((start+14) > maxRecord )){
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		//    }
		
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
 }
		
		String classValue="";//String chkAttribute="";
		
			if( i%2 == 0)  classValue="QRYEVEN";
			else
			classValue="QRYODD";

		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs.getString("Practitioner_ID")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs.getString("Practitioner_ID")));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs.getString("Practitioner_ID")));
            _bw.write(_wl_block45Bytes, _wl_block45);

			out.println("<script>document.forms[0].role"+i+".value='"+rs.getString("Practitioner_Role").substring(0,1)+"'</script>");			
				
            _bw.write(_wl_block46Bytes, _wl_block46);


		if(rs.getString("Practitioner_Role").substring(0,1).equals("M") || rs.getString("Practitioner_Role").substring(0,1).equals("C"))
			out.println("<script>document.forms[0].chk"+i+".checked=true;</script>");
		i++;
		maxRecord++;
		}//end of while

		if(maxRecord == 0)
				{
            _bw.write(_wl_block47Bytes, _wl_block47);
}

		if ( maxRecord < 13 || (!rs.next()) ) {
		
            _bw.write(_wl_block48Bytes, _wl_block48);
 
				} else {
            _bw.write(_wl_block49Bytes, _wl_block49);
}

		if(strPageAction.equals("P") || strPageAction.equals("N")){
			hmRole = (HashMap)session.getValue("roleValue");
			String strParse = (String)hmRole.get(start+"_"+end);
			if(strParse != null){
				StringTokenizer stRoleTokenizer = new StringTokenizer(strParse,"#");		
				String strValue="";
				while(stRoleTokenizer.hasMoreElements()){
					strValue = stRoleTokenizer.nextToken();
					out.println("<script>document.forms[0].role"+ iStartIndex +".value='"+ strValue +"'</script>");
					if(strValue.equals("M") || strValue.equals("C"))
						out.println("<script>document.forms[0].chk"+iStartIndex+".checked=true;</script>");
					iStartIndex++;
				}
			}
		}
        hmRole.clear();

		StringTokenizer stmain=new StringTokenizer(totRoleId,"~");
		int mainTkn=stmain.countTokens();
		for(int k=0;k<mainTkn;k++)
		{
		String st=stmain.nextToken();
		StringTokenizer subTkn=new StringTokenizer(st,"$");
		String role_name=subTkn.nextToken();
		String role_value=subTkn.nextToken();
		out.println("<script>if(document.forms[0]."+role_name+") { document.forms[0]."+role_name+".value='"+role_value+"' }</script>");

		}

			StringTokenizer stmain1=new StringTokenizer(finalSelect,"~");
			int mainTkn1=stmain1.countTokens();
			for(int k1=0;k1<mainTkn1;k1++)
			{
			String st1=stmain1.nextToken();
			StringTokenizer subTkn1=new StringTokenizer(st1,"$");
			subTkn1.nextToken();
			String role_value1=subTkn1.nextToken();
			subTkn1.nextToken();
			String role_name1=subTkn1.nextToken();
			String objname =subTkn1.nextToken();

			//out.println("<script>alert("+role_value1+"); alert("+role_name1+"); alert("+objname+");	</script>");
	
			out.println("<script>if(document.forms[0]."+role_name1+") {document.forms[0]."+role_name1+".value='"+role_value1+"' }</script>");
			out.println("<script>if(document.forms[0]."+objname+"){if(document.forms[0]."+role_name1+".value !='S') document.forms[0]."+objname+".checked=true;else document.forms[0]."+objname+".checked=false; } </script>");

			} 

    }
	  catch(Exception e){
		  //out.print(e);
		  e.printStackTrace();
	  }
	  finally
	  {
		  try
		  {
	  if(rs!=null)		rs.close();
	  if(stmt!=null)	stmt.close();
	  if(pstmt!=null)	pstmt.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }

		ConnectionManager.returnConnection(con,request);

	  }
            _bw.write(_wl_block50Bytes, _wl_block50);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Chief.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Member.label", java.lang.String .class,"key"));
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
