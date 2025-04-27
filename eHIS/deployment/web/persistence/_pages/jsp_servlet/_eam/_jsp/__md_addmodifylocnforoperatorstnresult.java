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

public final class __md_addmodifylocnforoperatorstnresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/md_addModifyLocnForOperatorStnResult.jsp", 1740033834151L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tfunction changeEnable(Obj,Obj1)\n\t{\n\t\tvar arr = new Array();\n\t\tarr = Obj1.value.split(\"$\");\n\t\tif(Obj.checked)\n\t\t{\n\t\t\tarr[1]=\"Y\";\n\t\t}\n\t\telse\n\t\t\tarr[1]=\"N\";\n\t\tObj1.value=arr[0]+\"$\"+arr[1]+\"$\"+arr[2];\n\t}\n\tasync function showPractWindow(practID)\n\t{\n\t    var url     = \"../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id=\"+practID+\"&fcall=call\";\n\t    var dialogHeight    = \"70vh\" ;\n\t    var dialogWidth = \"80vw\" ;\n\t    var dialogLeft=\"\";\n\t    var arguments   = \"\" ;\n\t    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no;dialogLeft:\"+dialogLeft+\";\";\n\t    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;\n\t}\n\tfunction submitPrevNext(from, to){\n\t\t//alert(\"temp====>\"+parent.frames[0].temp);\n\t\t\n\t   document.forms[0].finalSelect.value=parent.frames[0].temp;\t\n\t   \n\t   document.forms[0].from.value = from;\n\t   document.forms[0].to.value = to; \n\t\tif(confirm(getMessage(\'WANT_TO_SAVE\',\'common\'))){ \n\t\t\tdocument.forms[0].action=\"../../servlet/eAM.md_LocnForOperatorStn\";\t\t\n\t\t\tdocument.forms[0].submit();\n\t\t}else{\t\t\t\t\n\t\t\t   parent.frames[0].temp=\'\';\n\t\t\t var operator_station=parent.frames[0].document.forms[0].oprstn.value;\n\t\t\tvar location_type=parent.frames[0].document.forms[0].loctype.value;\n\t\t\tvar speciality = parent.frames[0].document.forms[0].speciality.value;\n\t\t\tvar facility = parent.frames[0].document.forms[0].facility.value;\n           \n\t\t\tvar search_by=parent.frames[0].document.forms[0].search_by.value;\n\t\t\t\n\t\t\tvar search_txt=parent.frames[0].document.forms[0].search_txt.value;\n\t\t\tvar from=document.forms[0].from.value;\n\t\t\tvar to=document.forms[0].to.value;\t\t\t\n\t\t\tparent.frames[1].location.href=\'../../eAM/jsp/md_addModifyLocnForOperatorStnResult.jsp?operator_station=\'+operator_station+\'&location_type=\'+location_type+\'&facilityID=\'+facility+\'&speciality=\'+speciality+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&from=\'+from+\'&to=\'+to;\n\t\t\t\n\t    }\n\t}\n\tfunction reloadresultPage(frame){\n\n\t\tif(frame == \'R\'){\n\t\t    parent.frames[0].temp=\'\';\n\n\t\t\tvar operator_station=parent.frames[0].document.forms[0].oprstn.value;\n\t\t\tvar location_type=parent.frames[0].document.forms[0].loctype.value;\n\t\t\tvar speciality = parent.frames[0].document.forms[0].speciality.value;\n\t\t\tvar facility = parent.frames[0].document.forms[0].facility.value;\n           \n\t\t\tvar search_by=parent.frames[0].document.forms[0].search_by.value;\n\t\t\t\n\t\t\tvar search_txt=parent.frames[0].document.forms[0].search_txt.value;\n\t\t\tvar from=document.forms[0].from.value;\n\t\t\tvar to=document.forms[0].to.value;\t\t\n\t\t\tparent.frames[1].location.href=\'../eAM/jsp/md_addModifyLocnForOperatorStnResult.jsp?operator_station=\'+operator_station+\'&location_type=\'+location_type+\'&facilityID=\'+facility+\'&speciality=\'+speciality+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&from=\'+from+\'&to=\'+to;\t\t\t\n\t\t\t parent.parent.frames[2].location.href=\'../eCommon/jsp/MstCodeError.jsp?err_num?err_val=\';\n\t\t\t  alert(parent.frames[1].getMessage(\'RECORD_INSERTED\',\'SM\'));\n\t\t}\n\t}\n\tfunction chkSelect(){\n\n\t\tif(document.forms[0].record_empty.value==\"N\"){\n\t\t\t\tif(document.forms[0].all_flg.value==\"Y\"){\n\t\t\t\t\tdocument.forms[0].mainChk.checked=true;\n\t\t\t\t}else if(document.forms[0].all_flg.value==\"N\"){\n\t\t\t\t\tdocument.forms[0].mainChk.checked=false;\n\t\t\t\t}\n\n\t\t\t\tif(document.forms[0].global_available.value==\"Y\"){\n\t\t\t\t\tif(document.forms[0].all_global_flg.value==\"Y\"){\n\t\t\t\t\t\tdocument.forms[0].global_Chk.checked=true;\n\t\t\t\t\t}else if(document.forms[0].all_global_flg.value==\"N\"){\n\t\t\t\t\t\tdocument.forms[0].global_Chk.checked=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\n\t\t\t\t\n\t\t\t\tif(document.forms[0].mainChk.checked){\n\t\t\t\t}else{\n\t\t\t\t\t\n\t\t\t\t\tif(document.forms[0].global_available.value==\"Y\"){\n\t\t\t\t\t\tdocument.forms[0].global_Chk.checked=false;\n\t\t\t\t\t\tdocument.forms[0].global_Chk.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t}\t\n\n\t}\t\n\t\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n<body  OnMouseDown=\"CodeArrest();\" onKeyDown = \"lockKey()\" onload=\"chkSelect()\"  class=\'CONTENT\'>\n<form name=\'facility_form_result\' id=\'facility_form_result\'  method=\'post\' target=\"messageFrame\">\n<table  width=\'85%\' border=0 align=\'center\'>\n<tr>\n\t<td class=\"white\">\n\t\t<table border=\'0\' align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t<td>\n<input type=\'hidden\' name=\'operator_station\' id=\'operator_station\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=\'hidden\' name=\'speciality\' id=\'speciality\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'totValues\' id=\'totValues\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'globalValues\' id=\'globalValues\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'globalValuesdis\' id=\'globalValuesdis\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<!--input type=\'hidden\' name=\'totValuesfordis\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'-->\n<input type=hidden name=\'function_name\' id=\'function_name\' value=\'insert\'>\n<input type=\'hidden\' name=\'maxRecord\' id=\'maxRecord\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =",";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =")\' text-decoration=\'none\'> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </a>\n <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a>\n\t    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</td>\n</tr>\n</table>\n\t</td>\n\t</tr>\n\t</table>\n\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'85%\' align=\'center\'>\n\t\t\t<th width=\'50%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</th>\n\t\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<input type=\'checkbox\'  name=\'mainChk\' id=\'mainChk\'   onClick=\'parent.frames[0].chkAll(this)\'></th>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  \n\t\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<input type=\'checkbox\'  name=\'global_Chk\' id=\'global_Chk\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" onClick=\'parent.frames[0].chkAll_Global(this)\'></th>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</table>\n\t<input type=\'hidden\' name=\'facilityID\' id=\'facilityID\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t<input type=\'hidden\' name=\'search_txt\' id=\'search_txt\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t<input type=\'hidden\' name=\'Chkglobal\' id=\'Chkglobal\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t<input type=\'hidden\' name=\'all_flg\' id=\'all_flg\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t<input type=\'hidden\' name=\'global_available\' id=\'global_available\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t<input type=\'hidden\' name=\'record_empty\' id=\'record_empty\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t<input type=\'hidden\' name=\'all_global_flg\' id=\'all_global_flg\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\n\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			= null;
	PreparedStatement pstmt	= null;
	Statement stmt			= null;
	ResultSet rs			= null ;
			
	String all_flg="Y";
	String record_empty="N";
	String all_global_flg="Y";
	String disabled_attribute="";
	String locn_type_ind = "";
	String finalSelect   = "",effStatus = "";
	String from = request.getParameter("from");
    String to   = request.getParameter("to");
	String global_available="N";
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
		if(search_by == null) search_by="";
		if(search_txt == null) search_txt="";

		String search_by1="";
		String search_by2="";
		String search_by3="";

		if(search_by.equals("01"))
		{
		   search_by1="LOCN_CODE";
		   search_by2="CLINIC_CODE";
		   search_by3="NURSING_UNIT_CODE";
		}
		else if(search_by.equals("02"))
		{
			search_by1="LOCN_LONG_DESC";
			search_by2="LONG_DESC";
			search_by3="LONG_DESC";
		}
		
	int maxRecord = 0;
	int start     = 0;
	int end       = 0;

    if(from == null){ start = 0; } else {  start = Integer.parseInt( from ) ; }
    if(to == null){ end = 6; } else { end = Integer.parseInt( to ) ; }
	
	finalSelect=request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
    
	effStatus=request.getParameter("effStatus");
	
	if(effStatus == null) effStatus="";
	String facilityID     = request.getParameter("facilityID");
	if(facilityID == null) facilityID="";
	String specialty_code = request.getParameter("speciality");
	if(specialty_code == null) specialty_code="";
	String operator_station=request.getParameter("operator_station");
	if(operator_station == null) operator_station="";
	String location_type= request.getParameter("location_type");
	if(location_type == null) location_type="";
	String global_chkattribute="";
	String Chkglobal="";
	String Global_Flag= "";
  
	
	if((location_type.equals("C"))||(location_type.equals("Y"))||(location_type.equals("E"))){
		 Global_Flag="Y";
	 }


		
	try
	{
		con = ConnectionManager.getConnection(request);
		
		String GlobalSql="SELECT GLOBAL_BOOK_APPT_YN FROM am_oper_stn where Facility_Id = '"+facilityID+"' and Oper_Stn_ID ='"+operator_station+"'";
		pstmt = con.prepareStatement(GlobalSql.toString());		
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			global_chkattribute = rs.getString(1);
		}		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();


		StringBuffer practSql =new StringBuffer("");
		practSql.setLength(0);
		practSql.append("select care_locn_type_ind from am_care_locn_type where locn_type=?");
		pstmt = con.prepareStatement(practSql.toString());
		pstmt.setString(1, location_type);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			locn_type_ind = rs.getString(1);
		}
	
		practSql.setLength(0);
		practSql.append("");
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		
		if(locn_type_ind.equals("N"))
		{		
			practSql.setLength(0);

			if(!specialty_code.equals(""))				
			{
			practSql.append("Select a.locn_code, a.locn_long_desc,a.global_locn_yn global_locn_yn, 'Y' del_flag,service_desc,upper(a.locn_long_desc) from am_locn_for_oper_stn_vw a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' and a.CARE_LOCN_TYPE = '"+location_type+"'");

			
			if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 
			
			practSql.append(" Union Select a.nursing_unit_code locn_code, a.long_desc,'N' global_locn_yn,'N' del_flag, b.short_desc,upper(a.long_desc) from ip_nursing_unit a ,am_service b, IP_NURS_UNIT_FOR_SPECIALTY C where a.service_code= b.service_code and a.facility_id = '"+facilityID+"' and a.eff_status = 'E' and C.SPECIALTY_CODE = '"+specialty_code+"' and ");

			if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" upper(a."+search_by3+")  like upper('"+search_txt+"%') and"); 

			practSql.append("  A.FACILITY_ID = C.FACILITY_ID AND A.NURSING_UNIT_CODE = C.NURSING_UNIT_CODE AND a.LOCN_TYPE= '"+location_type+"' and a.nursing_unit_code not in (Select a.locn_code from am_locn_for_oper_stn a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' ");

			
			}else{
				practSql.append("Select a.locn_code, a.locn_long_desc,a.global_locn_yn global_locn_yn, 'Y' del_flag,service_desc,upper(a.locn_long_desc) from am_locn_for_oper_stn_vw a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' and a.CARE_LOCN_TYPE = '"+location_type+"'   ");

				if(!search_by.equals("") && !search_txt.equals(""))
				 practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 
				
			//out.println("The values pract values"+practSql.toString());


//				practSql.append(" and (nvl(a.SPECIALITY_CODE,'!') = nvl('"+specialty_code+"','!') or a.SPECIALITY_CODE = nvl('"+specialty_code+"',a.SPECIALITY_CODE))  ");

				practSql.append(" Union Select a.nursing_unit_code locn_code, a.long_desc,'N' global_locn_yn,'N' del_flag, b.short_desc,upper(a.long_desc) from ip_nursing_unit a ,am_service b where a.service_code= b.service_code and a.facility_id = '"+facilityID+"' and a.eff_status = 'E'  ");

				if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper(a."+search_by3+")  like upper('"+search_txt+"%')"); 


//				practSql.append(" and (nvl(c.SPECIALTY_CODE,'!') = nvl('"+specialty_code+"','!') or c.SPECIALTY_CODE = nvl('"+specialty_code+"',c.SPECIALTY_CODE)) and ");

				practSql.append(" and a.LOCN_TYPE= '"+location_type+"' and a.nursing_unit_code not in (Select a.locn_code from am_locn_for_oper_stn_vw a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' and a.care_locn_type = '"+location_type+"'");
				
			}

	
			
			practSql.append(" and a.LOCN_TYPE = '"+location_type+"') order by 5 ");

			
		}
		
		else
		{			
			practSql.setLength(0);
			practSql.append(" Select A.SPECIALITY_CODE,a.locn_code,a.locn_long_desc,a.service_desc,a.eff_status,a.global_locn_yn global_locn_yn, 'Y' del_flag,  upper(a.locn_long_desc) from am_locn_for_oper_stn_vw a where a.Facility_Id = '"+facilityID+"' and a.Oper_Stn_ID ='"+operator_station+"' ");

			if(!search_by.equals("") && !search_txt.equals(""))
				  practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 

			if(!specialty_code.equals(""))				
			{
				practSql.append(" and a.Speciality_Code = '"+specialty_code+"' ");
			}
			else
			{
				practSql.append(" and (nvl(a.Speciality_Code,'!') = nvl('"+specialty_code+"','!') or a.Speciality_Code = nvl('"+specialty_code+"',a.Speciality_Code)) ");
			}
			practSql.append(" and a.CARE_LOCN_TYPE = '"+location_type+"' Union Select A.SPECIALITY_CODE, a.clinic_code locn_code, a.long_desc, b.short_desc service_desc,a.eff_status,'N' global_locn_yn,'N' del_flag,upper(a.long_desc) from op_clinic a, am_service b where a.facility_id = '"+facilityID+"'  and a.clinic_type='"+location_type+"' ");

			if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper(a."+search_by2+")  like upper('"+search_txt+"%')"); 

			if(!specialty_code.equals(""))				
			{
				practSql.append(" and a.Speciality_Code = '"+specialty_code+"' ");
			}
			else
			{
				practSql.append(" and (nvl(a.Speciality_Code,'!') = nvl('"+specialty_code+"','!') or a.Speciality_Code = nvl('"+specialty_code+"',a.Speciality_Code)) ");
			}
			practSql.append(" and a.service_Code(+) = b.service_code and a.eff_status = 'E' and a.Clinic_Code not in (Select a.locn_code from am_locn_for_oper_stn_vw a where a.Facility_Id = '"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' ");

			if(!search_by.equals("") && !search_txt.equals(""))
				  practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 

			if(!specialty_code.equals(""))
			{
				practSql.append(" and a.Speciality_Code = '"+specialty_code+"' ");
			}
			else
			{
				practSql.append(" and (nvl(a.Speciality_Code,'!') = nvl('"+specialty_code+"','!') or a.Speciality_Code = nvl('"+specialty_code+"',a.Speciality_Code)) ");
			}
			practSql.append(" and a.CARE_LOCN_TYPE = '"+location_type+"') order by 4 ");
		}

		//out.println("The values pract values"+practSql.toString());
	
		StringBuffer totValues=new StringBuffer();
		StringBuffer totValuesfordis=new StringBuffer();	
		StringBuffer globalValues=new StringBuffer();	
		StringBuffer globalValuesdis=new StringBuffer();	
		
        String global_locn_yn="";   	
	
		int m=0;
		try
		{
		
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery(practSql.toString());
		
		while(rs.next())
		{
			
			totValues.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$E$"+rs.getString("global_locn_yn")+"$chkGlobe"+m+"~");
	  
			 globalValuesdis.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$E$N$chkGlobe"+m+"~");
			
			globalValues.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$E$Y$chkGlobe"+m+"~");
		 
			totValuesfordis.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$D$N$chkGlobe"+m+"~");
			m++;
		
		}
		
		rs.beforeFirst();
		
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();


	  }
	  catch(Exception e4)
	  {
		  out.println("Exception e4 :"+ e4.toString());
	  }

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(operator_station));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totValues));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(globalValues));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(globalValuesdis));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(totValuesfordis));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(end));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(start));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(end));
            _bw.write(_wl_block22Bytes, _wl_block22);

    if ( !(start <= 1)) {

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((start-7)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((end-7)));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

    }
    if (!((start+7) >= maxRecord ))
	{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((start+7)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((end+7)));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

    }

            _bw.write(_wl_block29Bytes, _wl_block29);
  if(maxRecord!=0)
			{      
		
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Chkglobal));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
 }else
				{
				record_empty="Y";
            _bw.write(_wl_block37Bytes, _wl_block37);
 }
		int i=0;
		
		String classValue="",chkAttribute="",chkAttribute1="" ;
		String service_desc="",old_service_desc="",clinic_desc="",locn_code="",del_flag=""/*,eff_status=""*/;
	
		if (start != 0)
		{
			for(int j=1; j<=start; i++,j++)
			{
				rs.next();				
			}
		}		     
		while(rs.next() && i<=end)
		{ 
			service_desc= rs.getString("service_desc");
			clinic_desc=rs.getString("locn_long_desc");
			locn_code=rs.getString("locn_code");
			del_flag= rs.getString("del_flag");
		
			if(Global_Flag.equals("Y")){
	    	    global_locn_yn= rs.getString("global_locn_yn");			     
			    if((del_flag.substring(0,1).equals("Y"))&&(global_locn_yn.equals("Y")))
				chkAttribute1="CHECKED";
			    else
				chkAttribute1="";
			}

			if(del_flag.substring(0,1).equals("Y")){
				chkAttribute="CHECKED";
				disabled_attribute="enabled";
			}else{
				chkAttribute="";				
				disabled_attribute="disabled";	
				all_flg="N";
			}

			if( i%2 == 0)  
				classValue="QRYEVEN";
			else
				classValue="QRYODD";
			if(!service_desc.equals(old_service_desc))	{
				out.println("<tr>");
				out.println("<td class='CAHIGHERLEVELCOLOR' colspan='3'>"+service_desc+"</td></tr>");
				out.println("<tr><td class='"+classValue+"'>"+clinic_desc+"</td>");
				out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+chkAttribute+"  name='chk"+i+"' id='chk"+i+"' value='"+locn_code+"$"+del_flag.substring(0,1)+"'  onClick='parent.frames[0].chkServices(this,"+i+")'></td>");
         
				if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{	 	
					out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+Chkglobal+" "+chkAttribute1+" name='chkGlobe"+i+"' id='chkGlobe"+i+"'  onClick='parent.frames[0].chkServices_global(this,"+i+")' "+disabled_attribute+"></td>");
					global_available="Y";

					if(disabled_attribute.equals("disabled") || chkAttribute1.equals("")){
						all_global_flg="N";
					}
				}
			}else{
				out.println("<tr>");
				out.println("<td class='"+classValue+"'>"+clinic_desc+"</td>");
				out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+ chkAttribute+" name='chk"+i+"' id='chk"+i+"' value='"+locn_code+"$"+del_flag.substring(0,1)+"' onClick='parent.frames[0].chkServices(this,"+i+")'></td>");

				if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{	
					out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+Chkglobal+" "+chkAttribute1+" name='chkGlobe"+i+"' id='chkGlobe"+i+"'  onClick='parent.frames[0].chkServices_global(this,"+i+")'"+disabled_attribute+"></td>");
					global_available="Y";

					if(disabled_attribute.equals("disabled") || chkAttribute1.equals("")){
						all_global_flg="N";
					}
				}
			}
			out.println("</tr>");
			old_service_desc=service_desc;
			i++;
		}
		
		StringTokenizer st=new StringTokenizer(finalSelect,"~");
		int temp=st.countTokens();	
		for(int u2=0;u2<temp;u2++)
		{			
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			st1.nextToken();
			st1.nextToken();
			String objName=st1.nextToken();
			String enable_dis=st1.nextToken();
			String global_dis=st1.nextToken();			
			
			if(enable_dis.equals("E"))
				out.println("<script>if(eval(\"document.forms[0]."+objName+"\")) document.forms[0]."+objName+".checked=true;</script>");
			else
				out.println("<script>if(eval(\"document.forms[0]."+objName+"\")) document.forms[0]."+objName+".checked=false;</script>");

       	if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{
			   String objName1=st1.nextToken();
			   
			if(global_dis.equals("Y"))
				out.println("<script>if(eval(\"document.forms[0]."+objName1+"\")) document.forms[0]."+objName1+".checked=true;</script>");
			else
				out.println("<script>if(eval(\"document.forms[0]."+objName1+"\")) document.forms[0]."+objName1+".checked=false;</script>");
		   }
		}

	}
	catch(Exception e2){out.print(e2);}
	finally
	{
		try
		{
	  if(rs!=null)		rs.close();
  	  if(stmt!=null)	stmt.close();
	  if(pstmt!=null)	pstmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
	  ConnectionManager.returnConnection(con,request);

	}
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(Chkglobal));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(all_flg));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(global_available));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(record_empty));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(all_global_flg));
            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Global.label", java.lang.String .class,"key"));
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
