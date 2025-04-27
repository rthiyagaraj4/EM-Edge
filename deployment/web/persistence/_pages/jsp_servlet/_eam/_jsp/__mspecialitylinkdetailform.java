package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __mspecialitylinkdetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/MSpecialityLinkDetailForm.jsp", 1709114018132L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eAM/js/MSpecialityLink.js\'></script>\n\t<script language=\"JavaScript\">\n\t\tfunction validateCheckBox(obj){\n\t\t\tvar formObj = document.forms[0];\n\t\t\tformObj.modified_flag.value=\"false\";\n\t\t\tif(obj.checked==true){\n\t\t\t\tobj.select_yn=\"Y\";\n\t\t\t}else{\n\t\t\t\tobj.select_yn=\"N\";\n\t\t\t}\n\t\t\tvar arrObj = document.forms[0].elements;\n\t\t\tfor(var i=0;i<arrObj.length;i++){\n\t\t\t\tif(arrObj[i].type==\"checkbox\"){\n\t\t\t\t\tif(arrObj[i].value==arrObj[i].select_yn){\n\t\t\t\t\t\tarrObj[i].db_change=\"N\";\n\t\t\t\t\t\tcontinue;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tformObj.modified_flag.value=\"true\";\n\t\t\t\t\t\tarrObj[i].db_change=\"Y\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tfunction previous(){\n\t\t\tvar frm=window.parent.frames[0].document.forms[0];\n\t\t\tvar formObj = document.forms[0];\n\t\t\tvar modified_flag=formObj.modified_flag.value;\n\t\t\tif(modified_flag==\"true\"){\n\t\t\tif(confirm(getMessage(\'WANT_TO_SAVE\',\'common\'))){\n\t\t\t\tdocument.forms[0].prevnext.value=14;\n\t\t\tparent.parent.apply();\n\t\t\tvar speciality_module=frm.speciality_module.value;\n\t\t\tvar start = formObj.start.value;\n\t\t\tformObj.start.value=start-14;\n\t\t\tvar end = formObj.end.value;\n\t\t\tformObj.end.value=end-14;\n\t\t\tstart = formObj.start.value;\n\t\t\tend = formObj.end.value;\n\t\tvar search_by=document.forms[0].search_by.value;\n\t\tvar search_txt=document.forms[0].search_txt.value;\n\tdocument.location.href=\"../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from=\"+start+\"&to=\"+end+\"&speciality_module=\"+speciality_module+\"&search_by=\"+search_by+\"&search_txt=\"+search_txt;\n\t\t\t\treturn;\n\t\t}else{\n\t\t\tvar speciality_module=frm.speciality_module.value;\n\t\t\tvar start = formObj.start.value;\n\t\t\tformObj.start.value=start-14;\n\t\t\tvar end = formObj.end.value;\n\t\t\tformObj.end.value=end-14;\n\t\t\tstart = formObj.start.value;\n\t\t\tend = formObj.end.value;\t\n\t\t\t\n\t\tvar search_by=document.forms[0].search_by.value;\n\t\tvar search_txt=document.forms[0].search_txt.value;\tdocument.location.href=\"../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from=\"+start+\"&to=\"+end+\"&speciality_module=\"+speciality_module+\"&search_by=\"+search_by+\"&search_txt=\"+search_txt;\n\t\t}\n\t\t}else{\n\n\t\t\tvar speciality_module=frm.speciality_module.value;\n\t\t\tvar start = formObj.start.value;\n\t\t\tformObj.start.value=start-14;\n\t\t\tvar end = formObj.end.value;\n\t\t\tformObj.end.value=end-14;\n\t\t\tstart = formObj.start.value;\n\t\t\tend = formObj.end.value;\t\n\t\t\tvar search_by=document.forms[0].search_by.value;\n\t\t\tvar search_txt=document.forms[0].search_txt.value;\n\t\tdocument.location.href=\"../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from=\"+start+\"&to=\"+end+\"&speciality_module=\"+speciality_module+\"&search_by=\"+search_by+\"&search_txt=\"+search_txt;\n\t\t}\n\t\t}\n\n\t\tfunction next(){\n\t\t\tvar frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];\n\t\t\tvar formObj = document.forms[0];\n\t\t\tvar modified_flag=formObj.modified_flag.value;\n\t\t\tif(modified_flag==\"true\"){\n\t\t\tif(confirm(getMessage(\'WANT_TO_SAVE\',\'common\'))){\n\t\t\tdocument.forms[0].prevnext.value=14;\n\t\t\tparent.parent.apply();\t\n\t\t\tvar speciality_module=frm.speciality_module.value;\n\t\t\tvar start = formObj.start.value;\n\t\t\tvar start1=parseInt(start)+14;\n\t\t\tstart = formObj.start.value;\n\t\t\tvar end = formObj.end.value;\n\t\t\tvar end1=parseInt(end)+14;\n\t\t\tend = formObj.end.value;\n\t\t\tvar masterFrame=window.parent.frames[0];\n\t\t\tvar detailFrame=window.parent.frames[1];\t\n\t\t\tvar search_by=document.forms[0].search_by.value;\n\t\t\tvar search_txt=document.forms[0].search_txt.value;\n\t\tdocument.location.href=\"../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from=\"+start1+\"&to=\"+end1+\"&speciality_module=\"+speciality_module+\"&search_by=\"+search_by+\"&search_txt=\"+search_txt;\t\n\t\t\treturn;\n\t\t}else{\n\t\t\tvar speciality_module=frm.speciality_module.value;\n\t\t\tvar start = formObj.start.value;\n\t\t\tformObj.start.value=parseInt(start)+14;\n\t\t\tstart = formObj.start.value;\n\t\t\tvar end = formObj.end.value;\n\t\t\tformObj.end.value=parseInt(end)+14;\n\t\t\tend = formObj.end.value;\n\t\t\tvar masterFrame=window.parent.frames[0];\n\t\t\tvar detailFrame=window.parent.frames[1];\t\n\t\t\tvar search_by=document.forms[0].search_by.value;\n\t\t\tvar search_txt=document.forms[0].search_txt.value;\n\t\tdocument.location.href=\"../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from=\"+start+\"&to=\"+end+\"&speciality_module=\"+speciality_module+\"&search_by=\"+search_by+\"&search_txt=\"+search_txt;\n\t\t}\n\t\t}else{\n\t\t\tvar speciality_module=frm.speciality_module.value;\n\t\t\tvar start = formObj.start.value;\n\t\t\tformObj.start.value=parseInt(start)+14;\n\t\t\tstart = formObj.start.value;\n\t\t\tvar end = formObj.end.value;\n\t\t\tformObj.end.value=parseInt(end)+14;\n\t\t\tend = formObj.end.value;\n\t\t\tvar masterFrame=window.parent.frames[0];\n\t\t\tvar detailFrame=window.parent.frames[1];\t\n\t\t\tvar search_by=document.forms[0].search_by.value;\n\t\t\tvar search_txt=document.forms[0].search_txt.value;\n\t\tdocument.location.href=\"../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from=\"+start+\"&to=\"+end+\"&speciality_module=\"+speciality_module+\"&search_by=\"+search_by+\"&search_txt=\"+search_txt;\n\t\t}\n\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY class=\'CONTENT\'  onKeyDown = \'lockKey()\'>\n\t<form name=\"MSpecialityLinkDetailForm\" id=\"MSpecialityLinkDetailForm\">\n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t\t<table align=\'right\' border=0>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<br><br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'CAGROUPHEADING\' colspan=3>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"columnHeader\" width=\'\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"columnHeader\" width=\'\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</table>\n\t\t</center>\n\t\t<br><center>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\"hidden\" name=\"modified_flag\" id=\"modified_flag\" value=\"false\" >\n\t\t<input type=\"hidden\" name=\"execute_flag\" id=\"execute_flag\" value=\"YES\" >\n\t\t<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t<input type=\"hidden\" name=\"prevnext\" id=\"prevnext\" value=\"\" >\n\t\t<input type=\"hidden\" name=\"sel\" id=\"sel\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t<input type=\"hidden\" name=\"speciality_module\" id=\"speciality_module\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t<input type=\"hidden\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'search_txt\' id=\'search_txt\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\n\t\t</center>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		   String from = checkForNull(request.getParameter( "from" )) ;
		   String to =   checkForNull(request.getParameter( "to" ) ) ;
		   String speciality_module=checkForNull(request.getParameter("speciality_module"));
		   String select_value="Y";
		   String speciality_code = "";
		   String speciality_desc = "";

			String search_by=request.getParameter("search_by");
			String search_txt=request.getParameter("search_txt");
			if(search_by == null) search_by="";
			if(search_txt == null) search_txt="";

			
			if(search_by.equals("01"))
			{
			   search_by="SPECIALITY_CODE";
			}
			else if(search_by.equals("02"))
			{
				search_by="LONG_DESC";
			}
		   
		  
		   String sel="";
		   String select_checked="";
		   int start = ( from.equals("") )?1:Integer.parseInt(from);
		   int end =  ( to.equals("") )?14:Integer.parseInt(to);
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   ResultSet rst=null;
		   
		 //  String strsql="SELECT A.SPECIALITY_CODE, B.SHORT_DESC, 'Y' CHECKBOX FROM AM_SPLTY_FOR_SPLTY_MODULES A, AM_SPECIALITY B WHERE A.MODULE_ID='"+speciality_module+"' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE UNION SELECT SPECIALITY_CODE, SHORT_DESC, 'N' CHECKBOX FROM AM_SPECIALITY WHERE EFF_STATUS='E' AND  SPECIALITY_CODE NOT IN (SELECT SPECIALITY_CODE from AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID='"+speciality_module+"') ORDER BY SHORT_DESC";

		  String strsql="SELECT A.SPECIALITY_CODE, B.LONG_DESC, 'Y' CHECKBOX FROM AM_SPLTY_FOR_SPLTY_MODULES A, AM_SPECIALITY B WHERE A.MODULE_ID='"+speciality_module+"' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE";
		  
			  if(!search_by.equals("") && !search_txt.equals(""))
			  strsql = strsql +" and upper(B."+search_by+")  like upper('"+search_txt+"%')"; 
		  
		  
		  strsql = strsql +" UNION SELECT SPECIALITY_CODE, LONG_DESC, 'N' CHECKBOX FROM AM_SPECIALITY WHERE EFF_STATUS='E'";
		  
			   if(!search_by.equals("") && !search_txt.equals(""))
			  strsql = strsql +" and upper("+search_by+")  like upper('"+search_txt+"%')";

		  strsql = strsql +" AND  SPECIALITY_CODE NOT IN (SELECT SPECIALITY_CODE from AM_SPLTY_FOR_SPLTY_MODULES) ORDER BY LONG_DESC";

			int maxRecord = 0;
			int i=1;
			try{
		   		conn  =  ConnectionManager.getConnection(request);
				pstmt = conn.prepareStatement(strsql);
				rst = pstmt.executeQuery();
				int total=0;
				while(rst.next()){
					total++;
				}
				maxRecord = total;
				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}
				pstmt=conn.prepareStatement(strsql);
				rst = pstmt.executeQuery();
		
            _bw.write(_wl_block8Bytes, _wl_block8);

					if ( !(start <= 1) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
					if ( !( (start+14) > maxRecord ) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
				
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				rst.next() ;
				String classValue= " ";
				int k=0;
				while ( rst.next() && i<=end  ){
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
					speciality_code = checkForNull(rst.getString(1));
					speciality_desc= checkForNull(rst.getString(2));
					sel=checkForNull(rst.getString(3));
					
					out.println("<tr>");
					out.println("<td class='" + classValue+"'>"+speciality_desc+"</td>");
					
					if (sel.equals("Y")){
						   select_checked="checked";
						   select_value="Y";
							k++;
					}else{
						select_checked="";
						select_value="N";
					}
					out.println("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" speciality_code='"+speciality_code+"' db_change='N' select_yn='"+select_value+"' onclick='validateCheckBox(this);'>");
					out.println("</td>");
					out.println("</tr>");
					i++;
				} 
			
            _bw.write(_wl_block13Bytes, _wl_block13);
 
		   }catch(Exception e){
				out.println("MSpecialityLinkDetailForm : "+e);
				e.printStackTrace();
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(select_checked));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_module));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AssociatedSpecialities.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
