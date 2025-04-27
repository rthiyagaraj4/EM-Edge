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

public final class __cliniceventmasterupdate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicEventMasterUpdate.jsp", 1730876709612L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n\t\t\n\t\t\n\t\t\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../js/ClinicEventMaster.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\n\tfunction checkVal(obj)\n\t{\n\t\tdocument.forms[0].dispMode.value = obj;\n\t\tdocument.forms[0].submit();\n\t}\n\n\tfunction chkunchk(Obj)\n\t{\n\t\tif(Obj.checked)\n\t\t{\n\t\t\tObj.value=\"Y\"\n\t\t\tdocument.forms[0].confirmyn.value=\'Y\'\n\t\t}\n\t\telse\n\t\t{\n\t\t\tObj.value=\"N\"\n\t\t\tdocument.forms[0].confirmyn.value=\'Y\'\n\t\t}\n\t}\n\n\tfunction prevRecs(start,end,search_by,search_text,search_criteria,hist_type,row_count)\n\t{\n\t\t//var row_count = document.forms[0].row_count.value;\n\n\t\tif(document.forms[0].confirmyn.value==\"N\")\n\t\t{\n\t\t\tparent.f_query_add_mod.location.href=\"../../eCA/jsp/ClinicEventMasterUpdate.jsp?from=\"+(start)+\"&to=\"+(end)+\"&search_by=\"+search_by+\"&search_criteria=\"+search_criteria+\"&hist_type=\"+hist_type+\"&row_count=\"+row_count+\"&search_text=\"+escape(search_text)\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\tupyesno=confirm(\"Update record\");\n\t\n\t\t\tif(upyesno)\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.clinic_event_param_form.nextpervin.value=\'prv\'\n\t\t\t\tparent.f_query_add_mod.document.clinic_event_param_form.submit() ;\n\t\t\t}\n\t/*\t\telse\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.location.href=\"../../eCA/jsp/ClinicEventMasterUpdate.jsp?from=\"+(start)+\"&to=\"+(end)+\"&search_by=\"+search_by+\"&search_criteria=\"+search_criteria+\"&hist_type=\"+hist_type+\"&row_count=\"+row_count+\"&search_text=\"+search_text;\n\t\t\t}*/\n\t\t}\n\t}\n\n\tfunction nextRecs(start,end,search_by,search_text,search_criteria,hist_type,row_count)\n\t{\n\t\t//var row_count = document.forms[0].row_count.value;\n\n\t\tif(document.forms[0].confirmyn.value==\"N\")\n\t\t{\n\t\t\tparent.f_query_add_mod.location.href=\"../../eCA/jsp/ClinicEventMasterUpdate.jsp?from=\"+(start)+\"&to=\"+(end)+\"&search_by=\"+search_by+\"&search_criteria=\"+search_criteria+\"&hist_type=\"+hist_type+\"&row_count=\"+row_count+\"&search_text=\"+escape(search_text);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tupyesno=confirm(\"Update record\");\n\t\t\n\t\t\tif(upyesno)\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.clinic_event_param_form.nextpervin.value=\'nxt\'\n\t\t\t\tparent.f_query_add_mod.document.clinic_event_param_form.submit() ;\n\t\t\t}\n\t\t/*\telse\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.location.href=\"../../eCA/jsp/ClinicEventMasterUpdate.jsp?from=\"+(start)+\"&to=\"+(end)+\"&search_by=\"+search_by+\"&search_criteria=\"+search_criteria+\"&hist_type=\"+hist_type+\"&search_text=\"+search_text+\"&row_count=\"+row_count;\n\t\t\t}*/\n\t\t}\n\t}\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"COMMON\");\t\n\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'90%\' align=\'center\'>\n\t\t<tr>\n\t\t\n\t\t\t<td colspan = 2 width = \'40%\'></td>\n\t\t\t<td  align=\'right\' colspan =2 width=\'50%\' >\n\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t<a class=\'gridLink\'  href=\'javascript:prevRecs(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" )\' > ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a> \n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<a class=\'gridLink\'  href=\'javascript:nextRecs(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" )\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t  </td>\n\t\t  </tr>\n\t\t  </table>\n\t\t\n\t\t  \t<body class=\'CONTENT\' onLoad=\"\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\'clinic_event_param_form\' id=\'clinic_event_param_form\' action=\'../../servlet/eCA.ClinicEventMasterServlet\' target=\'messageFrame\'>\n\t\t<!-- \t<table cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'90%\'  align=center> -->\n\t\t \t<div style=\"display: flex; justify-content: center;\">\n\t\t \t<table class=\'grid\' width=\'90%\'  align=center> \n\n\t\t    <tr>\n\t\t\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;<input type=\'checkbox\' name=\'orderingPractSelAll\' id=\'orderingPractSelAll\' onclick=\'selectAllPract(this)\'></td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;<input type=\'checkbox\' name=\'attendingPractSelAll\' id=\'attendingPractSelAll\' onclick=\'selectAllPract(this)\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<input type=\'hidden\' name=\'hist_rec_type";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'hist_rec_type";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'event_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'event_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td  align=left class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  width=\"50%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t<td align=center  class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'><input type=\'checkbox\'   name= \'Ord_phys_yn";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  width=\"25%\" onclick=\'chkunchk(this)\'></td>\n\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'><input type=\'checkbox\'  name=\'Atn_phys_yn";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'Atn_phys_yn";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="  width=\"25%\"onclick=\'chkunchk(this)\'></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t<td>\n\t</td>\n\t</table>\n\t</div>\n\t<input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" > \n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\n\t<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"group_by\" id=\"group_by\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"grp_by_code\" id=\"grp_by_code\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\n\t<input type=\"hidden\" name=\"search_criteria\" id=\"search_criteria\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'search_text\' id=\'search_text\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'hist_rec_type\' id=\'hist_rec_type\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\'hidden\' name=\'numOfOrdChkdBoxes\' id=\'numOfOrdChkdBoxes\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\'hidden\' name=\'numOfAttChkdBoxes\' id=\'numOfAttChkdBoxes\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\n\t\n\t<input type=\'hidden\' name=\'nextpervin\' id=\'nextpervin\' value=\"\">\n\t<input type=\'hidden\' name=\'confirmyn\' id=\'confirmyn\' value=\"N\">\n</form>\n<script>\n\tif(\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' > 0)\n\t\tchkUnchkSelAll();\n</script>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );
int row_count=0;

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
            webbeans.eCommon.RecordSet ClinicEventMaster= null;synchronized(session){
                ClinicEventMaster=(webbeans.eCommon.RecordSet)pageContext.getAttribute("ClinicEventMaster",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(ClinicEventMaster==null){
                    ClinicEventMaster=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("ClinicEventMaster",ClinicEventMaster,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            eCA._ca_license_rights getLincKey= null;{
                getLincKey=(eCA._ca_license_rights)pageContext.getAttribute("getLincKey");
                if(getLincKey==null){
                    getLincKey=new eCA._ca_license_rights();
                    pageContext.setAttribute("getLincKey",getLincKey);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

Connection con			= null;
PreparedStatement pstmt = null;
ResultSet rs			= null;

//Modified by Archana @10-12-2008
String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
int pageCnt = Integer.parseInt(MstQryPageCnt);

int row_disp=pageCnt;
int start = 0 ;
int nTotalRecs = 0;
int end = 0 ;
int fm_disp=0, to_disp=0;
int ilCount=0;
int rowCount=0;
int j=0,i=0;
int numOfOrdChkdBoxes = 0;
int numOfAttChkdBoxes = 0;

String group_by="", grp_by_code="";
//String classValue="";
String classValue="gridData";
String from= "", to ="", dispMode="" ;
String row_count=request.getParameter("row_count")==null?"":request.getParameter("row_count");




dispMode		=	request.getParameter("dispMode") ;
from			=	request.getParameter( "from" ) ;

to				=	request.getParameter( "to" ) ;

if ( from == null || from=="null" || from.equals("null") )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null || to =="null" || to.equals("null") )
	end = row_disp;//7 ;
else
	end = Integer.parseInt( to ) ;

	String sql ="";
	String strOpMode						= "";

	String search_by=request.getParameter("search_by")==null?"":request.getParameter("search_by");

	
	String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	
	String search_criteria=request.getParameter("search_criteria")==null?"":request.getParameter("search_criteria");
	String strTotRec		= request.getParameter("NoRecs")==null?"":request.getParameter("NoRecs");

	if ( !strTotRec.equals("")  && !strTotRec.equals("null") )
		nTotalRecs = Integer.parseInt( strTotRec ) ;
		

	String hist_type   = request.getParameter("hist_type");      

	strOpMode = request.getParameter("opmode")==null?"":request.getParameter("opmode");

	
	String hist_rec_type					= "";
	String event_code						= "";
	String event_desc						= "";
	String hist_rec_desc					= "";
	String create_review_ord_phys_yn        = "";
	String create_review_atn_phys_yn		= "";

	try
	{
		con = ConnectionManager.getConnection();

	if(strOpMode.equals("First"))
	{
		if(search_by.equals("C"))
			sql = "select  count(*) count from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and a.event_code like upper(?) " ;
		else
			sql = "select count(*) count from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and upper(a.long_desc) like upper(?) " ;

		if (search_criteria.equals("S"))
			search_text =  search_text+"%";
		
		if (search_criteria.equals("C"))
			search_text =  "%"+search_text+"%";
		if (search_criteria.equals("E"))
			search_text =  "%"+search_text;
	}
		if (strOpMode.equals("First") )
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,hist_type);
			pstmt.setString(2,search_text);
	
			rs = pstmt.executeQuery();
   
			if(rs.next())
   			{	
			rowCount=rs.getInt("count");
		
		}
		}else
		{
		rowCount=Integer.parseInt(row_count);
		}

		if(rowCount<=0)
		{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else
		{	
			if(search_by.equals("C"))
			{
				sql = "select b.hist_rec_type, b.long_desc hist_rec_desc, a.event_code,	a.long_desc event_desc,nvl(a.create_review_ord_phys_yn,'N')create_review_ord_phys_yn,nvl(a.create_review_atn_phys_yn,'N')create_review_atn_phys_yn  from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and a.event_code like upper(?) order by 1,2,3" ;
			}
			else
			{
				sql = "select b.hist_rec_type, b.long_desc hist_rec_desc, a.event_code,	a.long_desc event_desc,nvl(a.create_review_ord_phys_yn,'N')create_review_ord_phys_yn,nvl(a.create_review_atn_phys_yn,'N')create_review_atn_phys_yn  from  cr_clin_event_mast a, cr_hist_rec_type b where a.hist_rec_type(+) = b.hist_rec_type and event_code is not null and b.hist_rec_type = ? and upper(a.long_desc) like upper(?) order by 4" ;
			}
	 
			if (search_criteria.equals("S"))
				search_text =  search_text+"%";
			if (search_criteria.equals("C"))
				search_text =  "%"+search_text+"%";
			if (search_criteria.equals("E"))
				search_text =  "%"+search_text;
		

			
            _bw.write(_wl_block12Bytes, _wl_block12);
 
			if ( !(start <= 1) )
			{
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((start-pageCnt)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((end-pageCnt)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(hist_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			if ( !( (start+pageCnt) > rowCount ) )
			{
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((start+pageCnt)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((end+pageCnt)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(hist_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
	  
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,hist_type);
			pstmt.setString(2,search_text);
		
			rs = pstmt.executeQuery();
		
			if ( start != 1 )
				for( int k=1; k<=start; i++,k++ )
				{
					rs.next() ;
				}

			while(rs.next()&& i<=end)
			{
				 /*if ( i % 2 == 0 )
					 classValue = "QRYEVEN" ;
				 else
					 classValue = "QRYODD" ;*/

				hist_rec_type			 = (rs.getString("hist_rec_type")==null)?"":rs.getString("hist_rec_type");
				hist_rec_desc			 = (rs.getString("hist_rec_desc")==null)?"":rs.getString("hist_rec_desc");
				event_code				 = (rs.getString("event_code")==null)?"":rs.getString("event_code");
				event_desc				 = (rs.getString("event_desc")==null)?"":rs.getString("event_desc");
				create_review_ord_phys_yn= (rs.getString("create_review_ord_phys_yn")==null)?"N":rs.getString("create_review_ord_phys_yn");
				create_review_atn_phys_yn=( rs.getString("create_review_atn_phys_yn")==null)?"N":rs.getString("create_review_atn_phys_yn");
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( hist_rec_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(create_review_ord_phys_yn.equalsIgnoreCase("Y")){ out.println("checked  value='Y' "); numOfOrdChkdBoxes++; }
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(create_review_atn_phys_yn.equalsIgnoreCase("Y"))
					{ out.println("checked  value='Y' "); numOfAttChkdBoxes++; }
            _bw.write(_wl_block37Bytes, _wl_block37);

					i++;
					j++;
					ilCount++;
			}
		}
	}
	catch(Exception e)
	{
		//out.println("Exception in try :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}	


            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(start));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(end));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(grp_by_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ilCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( search_text));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(hist_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(numOfOrdChkdBoxes));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(numOfAttChkdBoxes));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(ilCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClinicalEventParameter.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Update.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HistoryType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingPract.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
