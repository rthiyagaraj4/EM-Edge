package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __oaadditionalspecialtyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAAdditionalSpecialtyResult.jsp", 1709119244865L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\t\tvar count=0;\n\t\t\tvar addtlArray =new Array(2);\n\t\t\tfunction selectCheck(obj,objValue,recNo){\n\t\t\t\tif(obj.checked){\n\t\t\t\t\tcount=parseInt(count)+1;\n\t\t\t\t\tif(count > 2){\n\t\t\t\t\t\talert(getMessage(\'MAX_2_SPLTY\',\'OA\'));\n\t\t\t\t\t\tobj.checked=false;\n\t\t\t\t\t\tcount=count-1;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tparent.button_frame.document.getElementById(\'spltyDisp\').style.display=\"\";\n\t\t\t\t\t\tif(parseInt(count)==1){\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=eval(\"parent.result_frame.addtl_splty_result_form.code\"+recNo).value;\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=eval(\"parent.result_frame.addtl_splty_result_form.desc\"+recNo).value;\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value+\",\"+eval(\"parent.result_frame.addtl_splty_result_form.code\"+recNo).value;\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value+\"^\"+eval(\"parent.result_frame.addtl_splty_result_form.desc\"+recNo).value;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty_cnt.value=count;\n\t\t\t\t\t\tvar retValArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value).split(\",\");\n\t\t\t\t\t\tvar descArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value).split(\"^\");\n\t\t\t\t\t\tfor (var cnt = 1; cnt <=count; cnt++) {\n\t\t\t\t\t\t\tif(cnt==1){\n\t\t\t\t\t\t\t\tparent.button_frame.document.getElementById(\'divCode1\').innerHTML=retValArr[0];\n\t\t\t\t\t\t\t\tparent.button_frame.document.getElementById(\'divDesc1\').innerHTML=descArr[0];\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tparent.button_frame.document.getElementById(\'divCode2\').innerHTML=retValArr[1];\n\t\t\t\t\t\t\t\tparent.button_frame.document.getElementById(\'divDesc2\').innerHTML=descArr[1];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t/*//parent.button_frame.document.getElementById(\"innerHTML\")\n\t\t\t\t\t\t//parent.button_frame.location.href=\"../../eOA/jsp/OAAdditionalSpecialtyButton.jsp?addtl_splty=\"+parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value;\n\t\t\t\t\t\tvar parentDiv=parent.button_frame.document.getElementById(\'spltyData\');\n\t\t\t\t\t\tvar newdiv = parent.button_frame.document.createElement(\'div\');\n\t\t\t\t\t\tnewdiv.setAttribute(\'id\',\"One\");\n\t\t\t\t\t\tnewdiv.style.position=\"absolute\";\n\t\t\t\t\t\tnewdiv.style.height=\"20px\";\n\t\t\t\t\t\tnewdiv.style.width=\"150px\";\n\t\t\t\t\t\tnewdiv.innerHTML = \'Element Number 12 has been added! \';\n\t\t\t\t\t\tparentDiv.appendChild(newdiv);\n\n\n\t\t\t\t\t\t<div style=\"position: absolute;left:0;width :150px;height: 20px;BACKGROUND-COLOR: #B0949B;\">ENT</div>\n\t\t\t\t<div style=\"position: absolute;left:150px;width :550px;height: 20px;BACKGROUND-COLOR: #5EF2A6;\">Ent Specialty</div>*/\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\tcount=parseInt(count)-1;\n\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty_cnt.value=count;\n\t\t\t\t\tparent.button_frame.document.getElementById(\'divCode1\').innerHTML=\"\";\n\t\t\t\t\tparent.button_frame.document.getElementById(\'divDesc1\').innerHTML=\"\";\n\t\t\t\t\tparent.button_frame.document.getElementById(\'divCode2\').innerHTML=\"\";\n\t\t\t\t\tparent.button_frame.document.getElementById(\'divDesc2\').innerHTML=\"\";\n\t\t\t\t\tif(count ==0){\n\t\t\t\t\t\tparent.button_frame.document.getElementById(\'spltyDisp\').style.display=\"none\";\n\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=\"\";\n\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=\"\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\tvar retValArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value).split(\",\");\n\t\t\t\t\t\tvar descArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value).split(\"^\");\n\t\t\t\t\t\tif(objValue==retValArr[0]){\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=retValArr[1];\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=descArr[1];\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=retValArr[0];\n\t\t\t\t\t\t\tparent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=descArr[0];\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.button_frame.document.getElementById(\'divCode1\').innerHTML=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value;\n\t\t\t\t\t\tparent.button_frame.document.getElementById(\'divDesc1\').innerHTML=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction default_values(){\n\t\t\t\tcount=parseInt(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_cnt.value);\n\t\t\t}\n\t\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onload=\'default_values()\' onKeyDown = \'lockKey()\'>\n\t<form name=\"addtl_splty_result_form\" id=\"addtl_splty_result_form\">\n\t\t<div style=\"position:relative;height:400px;overflow:auto\">\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" >\n\t\t\t\t\t\t\t\t\t<thead id=\"TabHead\">\n\t\t\t\t\t\t\t\t\t\t<tr style=\"position:relative;top:expression(this.offsetParent.scrollTop)\">\n\t\t\t\t\t\t\t\t\t\t\t<th >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t\t\t\t\t\t\t<th >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr></tr>\n\t\t\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="><input type=\'checkbox\' name=\'check";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'check";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\'selectCheck(this,\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\",\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="></td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"desc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"desc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<input type=\'hidden\' name=\"checked_count\" id=\"checked_count\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t<input type=\'hidden\' name=\"addtl_splty_1\" id=\"addtl_splty_1\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t<input type=\'hidden\' name=\"addtl_splty_2\" id=\"addtl_splty_2\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<input type=\'hidden\' name=\"recordCount\" id=\"recordCount\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t<input type=\'hidden\' name=\"selectedCount\" id=\"selectedCount\" value=\"\">\n\t\t</form>\n\t</body>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");		
		String locale=(String)session.getAttribute("LOCALE");
		StringTokenizer splty_token=null;
		String addtl_splty_1="";
		String addtl_splty_2="";
		int k=0;
		if(!addtl_splty.equals("")){
			splty_token=new StringTokenizer(addtl_splty,",");
			k=0;
			while(splty_token.hasMoreTokens()){
				if(k==0){
					addtl_splty_1=splty_token.nextToken();
				}else{
					addtl_splty_2=splty_token.nextToken();
				}
				k++;
			}
		}
	
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String code="";
		String desc="";
		String search_by=request.getParameter("search_by")==null?"":request.getParameter("search_by");
		String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");
		String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
		try{
			con = ConnectionManager.getConnection(request);
			StringBuffer sql=new StringBuffer("select speciality_code,short_desc from am_speciality_lang_vw where language_id='"+locale+"'");
			if(!search_text.equals("")){
				if(start_ends_contains.equals("S")){
					if(search_by.equals("D")){
						sql.append(" and upper(short_desc) like upper('"+search_text+"%')");
					}else{
						sql.append(" and upper(speciality_code) like upper('"+search_text+"%')");
					}
				}else if(start_ends_contains.equals("E")){
					if(search_by.equals("D")){
						sql.append(" and upper(short_desc) like upper('%"+search_text+"')");
					}else{
						sql.append(" and upper(speciality_code) like upper('%"+search_text+"')");
					}
				}else if(start_ends_contains.equals("C")){
					if(search_by.equals("D")){
						sql.append(" and upper(short_desc) like upper('%"+search_text+"%')");
					}else{
						sql.append(" and upper(speciality_code) like upper('%"+search_text+"%')");
					}
				}
			}
			sql.append(" order by short_desc");
			pstmt = con.prepareStatement(sql.toString());
			
			rs=pstmt.executeQuery();
	
            _bw.write(_wl_block8Bytes, _wl_block8);

						String classValue = "" ;						
						int i=0;
						int checked_count=0;
						String checkedStr="";
						while(rs!=null && rs.next()){
							checkedStr="";
							if(i==0){
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
}
							if ( i % 2 == 0 ){
								classValue = "QRYEVEN" ;
							}else{
								classValue = "QRYODD" ;
							}
							code=rs.getString("speciality_code");
							desc=rs.getString("short_desc");							
							if(!addtl_splty_1.equals("") || !addtl_splty_2.equals("")){
								if(code.equals(addtl_splty_1) || code.equals(addtl_splty_2)){
									checkedStr="checked";
									checked_count++;
								}
							}
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkedStr));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

						i++;
						}
					
            _bw.write(_wl_block26Bytes, _wl_block26);
if(i==0){
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
					}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checked_count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(addtl_splty_1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(addtl_splty_2));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
}catch(Exception e){
		e.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
