package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eOR.*;
import eOR.Common.*;
import eXH.XHIdentify;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __fileteringandschdulinglookupqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FileteringAndSchdulingLookupQueryResult.jsp", 1742465681943L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="   \n<html> \n<head>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\t\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t<script language=\"JavaScript\" src=\'../../eXH/js/Validate.js\'> </script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n    <script language=\"JavaScript\" src=\"../../eXH/js/FilteringAndSchdulingLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script>alert(getMessage(\"XH1021\",\"XH\"));parent.frames[1].document.location.href=\'../../eCommon/html/blank.html\'</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" >\n<form name=\'OrderableResult\' id=\'OrderableResult\' action=\"FileteringAndSchdulingLookupQueryResult.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  method=\'post\'>\n\t <table border=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\'65%\'></td> \n\t\t\t<td align=\'right\' width=\'35%\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<a class=\'gridLink\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\' text-decoration=\'none\'>&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</td>\n\t\t</tr>\n\t </table>\n \n\t<table cellspacing=0 cellpadding=3 width=\'100%\' border=1 align=center>\n\n\t\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<!--<td class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>-->\n\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onmouseover=\"changeCursor(this);\" onClick=\"funShow(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\"><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td>\n\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<input type=\"hidden\" name=\"short_desc";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"short_desc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td></tr>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\t\t<input type=hidden name=from id=from value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=hidden name=to id=to value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=hidden name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t<input type=hidden name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=hidden name=\'description_code\' id=\'description_code\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=hidden name=\'long_desc\' id=\'long_desc\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\n\t\t\n\t </table>\n\t\n\t <table border=\'0\' width=\'100%\'> \n\t <tr><td class=\"button\" align=\"right\" nowrap ><input type=\"button\" class=\"button\" align=\"left\" onClick=\"funAdd()\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' width=\'25%\' class=\"button\">\n\t <input type=\"button\" class=\"button\" align=\"left\" onClick=\"funFresh()\" value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' width=\'25%\' class=\"button\"></td></tr></table>\n\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n\t ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n</form>\n</body>\n<script>\nfunction funFresh()\n{\n document.OrderableResult.target = \"refusal_resultframe1\"\n document.OrderableResult.submit();\n\t if(parent.frames[2].document.forms[0])\n\t{\n\t  parent.frames[2].document.forms[0].reset();\n\t  parent.frames[2].document.location.href=\'FilteringAndSchdulingLookupAdd.jsp?\';\n     parent.frames[3].document.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\t}\n}\n\n\n\tfunction submitPrevNext(from, to)\n\t{\n\t\tdocument.OrderableResult.from.value = from;\n        document.OrderableResult.to.value = to; \n        document.OrderableResult.target = \"refusal_resultframe1\"\n        document.OrderableResult.submit();\n\t}\n\tfunction funAdd()\n\t{\t\t\n\t\t//window.close();\n\t\tvar dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\tdialogTag.close();\n\n\t\tparent.frames[2].document.location.href=\'../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp\';\n          parent.frames[3].document.location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t}\n\tfunction dummy()\n\t{\n\t}\n\t function funShow(code,desc)\n\t{\n\t\n \n\t\t \n\t\t// window.returnValue=code+\",\"+desc;\n\t\t// window.close();\n\t\tvar retVal = code+\",\"+desc;\n\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = retVal;\n\t\t\n\t\tvar dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\tdialogTag.close();\n\t\t}\n</script>\n</html>\n  \n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle ="IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    String sql_query = "";
 	String from	= request.getParameter("from") ;
	String to	= request.getParameter("to") ;
	String checkedOnes	= "";
	String  req_start   =   "", req_end     =   "";
	String called_from = request.getParameter("called_from");

	if(called_from == null) called_from = "";
 	String search_by = request.getParameter("search_by");
	if(search_by == null || search_by == "null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
	String long_desc=request.getParameter("search_text");
	if(long_desc==null || long_desc=="null") long_desc = "";
 	String facility_id = (String)session.getValue("facility_id");
	int counts=0;
	if(from==null)
	{
	}

    PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
if(search_by.equals("C"))
{
	if(description_code.equals("S"))
	{
		sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('"+long_desc+"%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%') ORDER BY 1";
	} 
   else if(description_code.equals("E"))
	{
         sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%"+long_desc+"') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%') ORDER BY 1";
	}
	else
	{
	 sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%"+long_desc+"%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%') ORDER BY 1";
	}
 }
 else
 {
if(description_code.equals("S"))
	{
		sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('"+long_desc+"%') ORDER BY 1";
	} 
   else if(description_code.equals("E"))
	{
         sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%"+long_desc+"') ORDER BY 1";
	}
	else
	{
	 sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%"+long_desc+"%') ORDER BY 1";
	}
 }

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	
	int i=1;
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 15 ; }   else {  end = Integer.parseInt( to ) ; }
	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");
	if(from != null && to != null) {
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
			if(request.getParameter("chk"+(i-1)) != null) {
				checkedOnes = request.getParameter("chk"+(i-1));
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
   i = 1;
	try  
	{
		con = ConnectionManager.getConnection(request);
		String option_id	= "";
		String application_id="";
		String protocollink_id="";
		String short_desc	= "";
		int ilCkeckedYN = 0;
		int recordCount;
		StringBuffer sql = new StringBuffer();
		String classValue="";
		sql.append(sql_query);
		pstmt = con.prepareStatement(sql_query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();

            _bw.write(_wl_block2Bytes, _wl_block2);
if(maxRecord==0){
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);

		if ( !(start <= 1)) {
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start-15)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end-15)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		if ( !((start+15) > maxRecord )){
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start+15)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end+15)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
	
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			if (start != 0){
            for(int j=1; j<start; i++,j++){
                rs.next() ;  
             }
			 ilCkeckedYN+=start;
             --ilCkeckedYN ;   
			}
			recordCount			=	XHIdentify.getSize(con,sql_query); 
			while(rs.next()&& i<=end)
			{
				counts++;
				option_id = rs.getString(1)==null?"":rs.getString(1);
				short_desc = rs.getString(2)==null?"":rs.getString(2);
			    application_id = rs.getString(3)==null?"":rs.getString(3);
			    protocollink_id = rs.getString(4)==null?"":rs.getString(4);
				
				classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
				//classValue="gridData";
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(application_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(protocollink_id));
            _bw.write(_wl_block34Bytes, _wl_block34);

				ilCkeckedYN = ilCkeckedYN + 1;		
				i=i+1;
				//}
			}
			out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
 			out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
			out.println("<input type=hidden name=occurance id=occurance value='next'>");
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(end));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(start));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(end));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(description_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
   
		}
		catch(Exception e){
			out.println("Exception in OrderableResult.jsp"+e.toString());
		}finally{
		    if(con != null)ConnectionManager.returnConnection(con,request);
		}
	 
            _bw.write(_wl_block3Bytes, _wl_block3);

            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Gateway.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Refresh.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
