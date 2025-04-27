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

public final class __md_addmodifyoppfforfacilityresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/md_addModifyOPPFForFacilityResult.jsp", 1740033841280L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 =" \n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n <script src=\'../../eAM/js/OPPForFacility.js\' language=\'javascript\'></script>\n <script>\n\n\tfunction changeEnable(Obj,Obj1)\n\t{\n\t\tvar arr = new Array();\n\t\tarr = Obj1.value.split(\"$\");\n\t\tif(Obj.checked)\n\t\t{\n\t\t\tarr[1]=\"Y\";\n\t\t}\n\t\telse\n\t\t\tarr[1]=\"N\";\n\t\t\tObj1.value=arr[0]+\"$\"+arr[1]+\"$\"+arr[2];\n\t}\n\t\n\tasync function showPractWindow(practID)\n\t{\n\t    var url     = \"../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id=\"+practID+\"&fcall=call\";\n\t    var dialogHeight    = \"70vh\" ;\n\t\t/* below lines moidified by Venkatesh.S agasint 57984 on 07-01-2015 */\n\t    var dialogWidth = \"80vw\" ;\n\t\t/*End 57984 */\n\t    var dialogLeft=\"\";\n\t    var arguments   = \"\" ;\n\t    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no;dialogLeft:\"+dialogLeft+\";\";\n\t    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;\n\t}\n\t        \n\tfunction submitPrevNext(from, to)\n\t{\n\t\tdocument.forms[0].totAssignreassign.value=parent.frames[0].assignReassign;\n\t\tdocument.forms[0].effStatus.value=parent.frames[0].effStatus;\n\t\tdocument.forms[0].totselected.value=parent.frames[0].selected;\n\t\tdocument.forms[0].finalSelect.value=parent.frames[0].temp;\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t\tvar search_txt = document.forms[0].search_txt.value;\n\t\tvar search_by = document.forms[0].search_by.value;\n\t    document.forms[0].submit();\n\t}\n\t\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body  OnMouseDown=\"CodeArrest();\"  class=\'CONTENT\' onKeyDown = \'lockKey()\'>\n<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eAM/jsp/md_addModifyOPPFForFacilityResult.jsp\' method=\'post\' >\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\"white\">\n\t\t\t<table border=\'0\' align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t<td align=\'right\' class=\'NONURGENT\' nowrap>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<input type=hidden name=\'totAssignreassign\' id=\'totAssignreassign\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t<input type=hidden name=\'effStatus\' id=\'effStatus\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t<input type=hidden name=\'totselected\' id=\'totselected\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\n\t\t\t\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n\t\t\t\t<input type=\'hidden\' name=\'primary_specialty\' id=\'primary_specialty\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n\t\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t\t\t<input type=\'hidden\' name=\'pract_id_exists\' id=\'pract_id_exists\' value=\'N\'>\n\t\t\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'search_txt\' id=\'search_txt\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t     <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =",";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a>\n\t\t\t\t     <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n \n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</a>\n\t\t\t     <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t  </table>\n        </td>\n\t</tr>\t\n\t\t<tr>\n\t\t\t<td>\t\n\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t\t<th width=\'1%\' >&nbsp;</th>\n\t\t\t\t\t<th width=\'64%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t\t\t<th width=\'5%\' nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" <br>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\'1%\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'><a href=javaScript:showPractWindow(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')>+</a></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t<!-- Modified By Dharma on Feb 26th 2015 against ML-BRU-SCF-1541 [IN:053351] Start -->\n\t\t\t\t<!--\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" name=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  onClick=\'parent.frames[0].chkassignReAssign(this,select";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =")\'  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="$";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' > </td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onClick=\'parent.frames[0].chkEnable(this,select";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =");\'  value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'> </td>\n\t\t\t\t-->\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =");parent.frames[0].finalSelect(select";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'> </td>\n\t\t\t\t<!-- Modified By Dharma on Feb 26th 2015 against ML-BRU-SCF-1541 [IN:053351] End -->\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><input type=\'checkbox\'  name= \'select";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" onClick=\"parent.frames[0].finalSelect(this,";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =")\"  value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'> </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n  </table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

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
	String totAssignreasign="",effStatus="",totselected="",finalSelect="";
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	totAssignreasign=request.getParameter("totAssignreassign");
	if(totAssignreasign == null) totAssignreasign="";
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";
	search_txt = search_txt.replaceAll("\'","\'\'"); //Added for ML-MMOH-SCF-2337 by Ajay H.
	totselected=request.getParameter("totselected");
	if(totselected == null) totselected="";

	finalSelect=request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";

	if(search_by.equals("01"))
	   search_by="PRACTITIONER_ID";
    else if(search_by.equals("02"))
	   search_by="PRACTITIONER_NAME";
	
	String space="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	
	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
	
	Connection con = null;
	PreparedStatement pstmt=null;
	PreparedStatement stmtap=null;
	Statement stmt=null;
	ResultSet rs=null ;
	
	String facility_id=request.getParameter("facility_id") ;
	if(facility_id == null) facility_id="";
	String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }
	
	
	String primary_specialty=request.getParameter("primary_specialty");
	if( primary_specialty == null) primary_specialty="";
try{
		
		con = ConnectionManager.getConnection(request);
		
		String practSql=" select  practitioner_id, practitioner_name, allow_unassign_in_practq_yn,  eff_status,'N',upper(practitioner_name) from  am_pract_for_facility_vw where  operating_facility_id= '"+facility_id+"' and primary_speciality_code = '"+primary_specialty+"' ";
		
		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

		practSql=practSql+" union select practitioner_id, practitioner_name, 'Y',eff_status,'N',upper(practitioner_name) from am_practitioner where eff_status='E' and primary_speciality_code = '"+primary_specialty+"'";

		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

		practSql=practSql+" and practitioner_id   not in ( select practitioner_id from am_pract_for_facility_vw where operating_facility_id ='"+facility_id+"'  and primary_speciality_code ='"+primary_specialty+"'  ";

		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

		practSql=practSql+" ) order by 1";

		
try{


	stmt=con.createStatement();
	rs=stmt.executeQuery(practSql);
	  }catch(Exception e){
		  //out.println(e);
		  e.printStackTrace();
	  }

	  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(space));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(totAssignreasign));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(effStatus));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(totselected));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(primary_specialty));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block20Bytes, _wl_block20);

					if (start != 0){
					    for(int j=1; j<=start; i++,j++){
						rs.next() ;
					     }
				    }

					while(i<end && rs.next()){ 
						if(maxRecord==0)
						{

				    if ( !(start <= 1)) {
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

				}
			  //   if ( !((start+14) >= maxRecord )){
				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

			//	}
				
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
 }
					String classValue="",temp2="";
					String chkAttribute="",chkAttribute1="",chkAttribute2="";
					String practitioner_id="",practitioner_name="",allow_unassign_in_practq_yn="",eff_status="",selectyn="",dummyPractId="";
					
					temp2=rs.getString("practitioner_id");				

					practitioner_id="ID"+rs.getString("practitioner_id");
					dummyPractId=practitioner_id+"dummypractid";
					practitioner_name=rs.getString("practitioner_name");
					allow_unassign_in_practq_yn=rs.getString("allow_unassign_in_practq_yn");
					eff_status=rs.getString("eff_status");
					selectyn=rs.getString(5);
					selectyn=selectyn.substring(0,1);
			
					if( i%2 == 0)  classValue="QRYEVEN";
					else
						classValue="QRYODD";
					if(rs.getString("eff_status").equals("E"))
						chkAttribute="CHECKED";
					else
						chkAttribute="";
					if(rs.getString(3).equals("Y"))
						chkAttribute1="CHECKED";
					else
						chkAttribute1="";
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(temp2));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chkAttribute1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(allow_unassign_in_practq_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(selectyn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dummyPractId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dummyPractId));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(selectyn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chkAttribute1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dummyPractId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(allow_unassign_in_practq_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(selectyn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dummyPractId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dummyPractId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dummyPractId));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(selectyn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chkAttribute2));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dummyPractId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(selectyn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);

					
			i++;
			maxRecord++;
			}//end of while		

			if(maxRecord == 0)
			{
            _bw.write(_wl_block53Bytes, _wl_block53);
}

			if ( maxRecord < 14 || (!rs.next()) ) {
			
            _bw.write(_wl_block54Bytes, _wl_block54);
 
					} else {
            _bw.write(_wl_block55Bytes, _wl_block55);
}
			
			StringTokenizer st=new StringTokenizer(totAssignreasign,"~");
			int temp=st.countTokens();
			for(int u2=0;u2<temp;u2++)
			{
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			String practId=st1.nextToken();
			String asisignYN=st1.nextToken();
				if(asisignYN.equals("Y"))
					out.println("<script>if(document.forms[0]."+practId+") document.forms[0]."+practId+".checked=true;</script>");
				else
					out.println("<script>if(document.forms[0]."+practId+") document.forms[0]."+practId+".checked=false;</script>");
					
			}
			
			
			StringTokenizer steff=new StringTokenizer(effStatus,"~");
			int temp1=steff.countTokens();
			for(int u3=0;u3<temp1;u3++)
			{
			String st4=steff.nextToken();
			StringTokenizer st5=new StringTokenizer(st4,"$");
			String practname=st5.nextToken(); 
			String status=st5.nextToken(); 
			if(status.equals("E"))
			out.println("<script>if(document.forms[0]."+practname+") document.forms[0]."+practname+".checked=true;</script>");
			else
			out.println("<script>if(document.forms[0]."+practname+") document.forms[0]."+practname+".checked=false;</script>");

			}

			//out.println("totselected :"+totselected);
			StringTokenizer sel=new StringTokenizer(totselected,"~");
			int temp3=sel.countTokens();
			for(int u4=0;u4<temp3;u4++)
			{
			String st6=sel.nextToken();
			StringTokenizer st7=new StringTokenizer(st6,"$");
			st7.nextToken(); 
			String sel1=st7.nextToken();
			st7.nextToken(); 
			String s=st7.nextToken();
			//out.println("s :"+s);
			//out.println("<script>alert('into');</script>"); 
			if(sel1.equals("Y"))
			out.println("<script> if(document.forms[0].select"+s+") document.forms[0].select"+s+".checked=true;</script>");
			else
			out.println("<script>if(document.forms[0].select"+s+") document.forms[0].select"+s+".checked=false;</script>");
			}

			
            _bw.write(_wl_block56Bytes, _wl_block56);
	 }
			  catch(Exception e){
				  //out.print(e);
				  e.printStackTrace();
				  }
			  finally
			  {
			  if(rs!=null)		rs.close();
			  			  
			  if(stmt!=null)	stmt.close();
			  if(pstmt!=null)	pstmt.close();
			  if(stmtap!=null)  stmtap.close();
			  ConnectionManager.returnConnection(con,request);
			  }
            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AssignUnassigned.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
