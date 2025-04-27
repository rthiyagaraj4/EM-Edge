package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;

public final class __addresscomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/AddressComponent.jsp", 1709116502373L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n  ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\' />\n\n<script src=\'../js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script language=\"JavaScript\">\n\tfunction populateTown";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="(object){\n\n\t}\n\tfunction searchCode(obj,target)\n    {\n            var retVal =    new String();\n            var dialogHeight= \"28\" ;\n            var dialogWidth = \"43\" ;\n            var status = \"no\";\n            var arguments   = \"\" ;\n            var sql=\"\";\n            var search_code=\"\";\n            var search_desc=\"\";\n            var tit=\"\";\n            \n            //alert(obj.name)\n            if(obj.name==\"postal_code\")\n            {\n                tit=\"Postal Code\"\n                sql=\"select postal_code, short_desc from mp_postal_code\";\n                search_code=\"postal_code\";\n                search_desc= \"short_desc\"\n            }\n            var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n            retVal = window.showModalDialog(\"GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit,arguments,features);\n\n            if (!(retVal == null))\n            {\n                target.value=retVal;\n            }\n            else\n                target.focus();\n    }\n\n</script>\n<table width=\'100%\' height=\'100%\' cellpadding=\'0\' cellspacing=\'0\' >\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<tr>\n\t\t<td align=right class=\'label\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&nbsp;&nbsp;</td>\t\t\n\t\t<td>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<input type=\"text\" name=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" id=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" maxlength=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" size=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></input>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<select type=\"select\" name=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onChange=\"populateTown";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="(this)\">\n\t\t\t\t\t<option value=\"\">--Select--</option>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</select>\t\t\t  \t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<select name=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t<option value=\"\">--Select--</option>\t\n\t\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</table>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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

request.setCharacterEncoding("UTF-8");	
	int arr[] = new int[7];
	int finArr[] = new int[7];
	int fieldLengths[] = new int[7];
	String strArr[] = new String[7];
	String valArr[] = new String[7];
	String fieldNames[] = new String[7];
	Connection con = null;
	PreparedStatement pstmtOrder =  null;
	PreparedStatement pstmtArea = null;
	con = ConnectionManager.getConnection(request);	
	pstmtOrder = con.prepareStatement("select nvl(ADDR_LINE1_PROMPT,'') addr_line1_prompt,addr_line1_order,nvl(ADDR_LINE2_PROMPT,'') addr_line2_prompt,addr_line2_order,nvl(ADDR_LINE3_PROMPT,'') addr_line3_prompt,addr_line3_order,nvl(ADDR_LINE4_PROMPT,'') addr_line4_prompt,addr_line4_order,nvl(RES_AREA_PROMPT,'') res_area_prompt,res_area_order,nvl(RES_TOWN_PROMPT,'') res_town_prompt,res_town_order,nvl(POSTAL_CODE_PROMPT,'') postal_code_prompt,postal_code_order from sm_site_param");
	pstmtArea = con.prepareStatement("Select RES_AREA_CODE,SHORT_DESC from MP_RES_AREA order by SHORT_DESC");
		
	ResultSet rs = pstmtOrder.executeQuery();
	if (rs.next()){
		arr[0] = rs.getInt("addr_line1_order") - 1;
		arr[1] = rs.getInt("addr_line2_order") - 1;
		arr[2] = rs.getInt("addr_line3_order") - 1;
		arr[3] = rs.getInt("addr_line4_order") - 1;
		arr[4] = rs.getInt("res_area_order") - 1;
		arr[5] = rs.getInt("res_town_order") - 1;
		arr[6] = rs.getInt("postal_code_order") - 1;

		strArr[0] = (rs.getString("addr_line1_prompt")==null)?"":rs.getString("addr_line1_prompt");
		strArr[1] = (rs.getString("addr_line2_prompt")==null)?"":rs.getString("addr_line2_prompt");
		strArr[2] = (rs.getString("addr_line3_prompt")==null)?"":rs.getString("addr_line3_prompt");
		strArr[3] = (rs.getString("addr_line4_prompt")==null)?"":rs.getString("addr_line4_prompt");
		strArr[4] = (rs.getString("res_area_prompt")==null)?"":rs.getString("res_area_prompt");
		strArr[5] = (rs.getString("res_town_prompt")==null)?"":rs.getString("res_town_prompt");
		strArr[6] = (rs.getString("postal_code_prompt")==null)?"":rs.getString("postal_code_prompt");	

	}
	ResultSet rsArea = pstmtArea.executeQuery();

	for (int y=0;y<arr.length;y++){
		int j = arr[y];
		finArr[j]=y;
	}

	String addr_line1 = request.getParameter("addr_line1");
	addr_line1 = (addr_line1 == null)?"":addr_line1;
	String addr_line2 = request.getParameter("addr_line2");
	addr_line2 = (addr_line2 == null)?"":addr_line2;
	String addr_line3 = request.getParameter("addr_line3");
	addr_line3 = (addr_line3 == null)?"":addr_line3;
	String addr_line4 = request.getParameter("addr_line4");
	addr_line4 = (addr_line4 == null)?"":addr_line4;
	String res_area = request.getParameter("res_area");
	res_area = (res_area == null)?"":res_area;
	String res_town = request.getParameter("res_town");
	res_town = (res_town == null)?"":res_town;
	String postal_code = request.getParameter("postal_code");
	postal_code = (postal_code == null)?"":postal_code;
	String suffix = request.getParameter("suffix");
	suffix = (suffix == null)?"0":suffix;

	valArr[0] = addr_line1;
	valArr[1] = addr_line2;
	valArr[2] = addr_line3;
	valArr[3] = addr_line4;
	valArr[4] = res_area;
	valArr[5] = res_town;
	valArr[6] = postal_code;

	fieldNames[0] = "addr_line1"+suffix;
	fieldNames[1] = "addr_line2"+suffix;
	fieldNames[2] = "addr_line3"+suffix;
	fieldNames[3] = "addr_line4"+suffix;
	fieldNames[4] = "res_area"+suffix;
	fieldNames[5] = "res_town"+suffix;
	fieldNames[6] = "postal_code"+suffix;

	fieldLengths[0] = 30;
	fieldLengths[1] = 30;
	fieldLengths[2] = 30;
	fieldLengths[3] = 30;
	fieldLengths[4] = -1;
	fieldLengths[5] = -2;
	fieldLengths[6] = 8;

            _bw.write(_wl_block2Bytes, _wl_block2);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(suffix));
            _bw.write(_wl_block5Bytes, _wl_block5);

	for (int y=0;y<finArr.length;y++){ 
		int p = finArr[y];
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strArr[p]));
            _bw.write(_wl_block7Bytes, _wl_block7);

			  if (fieldLengths[p] > 0){
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fieldNames[p]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fieldNames[p]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fieldLengths[p]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(fieldLengths[p]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(valArr[p]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((fieldLengths[p] != 8)?"":"<input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,"+fieldNames[p]+")'>"));
            _bw.write(_wl_block14Bytes, _wl_block14);

			}else if (fieldLengths[p] == -1){
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fieldNames[p]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fieldNames[p]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(valArr[p]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(suffix));
            _bw.write(_wl_block17Bytes, _wl_block17);

					while(rsArea.next()){
					
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rsArea.getString("RES_AREA_CODE")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rsArea.getString("SHORT_DESC")));
            _bw.write(_wl_block20Bytes, _wl_block20);

					}
				
            _bw.write(_wl_block21Bytes, _wl_block21);

			}else{
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(fieldNames[p]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fieldNames[p]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(valArr[p]));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
			
            _bw.write(_wl_block24Bytes, _wl_block24);
}

            _bw.write(_wl_block25Bytes, _wl_block25);

	rs.close();
	rsArea.close();
	pstmtArea.close();
	pstmtOrder.close();
	ConnectionManager.returnConnection(con,request);

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
