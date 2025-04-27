package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __functionsforroledetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/FunctionsForRoleDetailForm.jsp", 1723794144000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'JavaScript\' src=\'../../eOT/js/FunctionsForRole.js\'></script>\n\t<script language=\"JavaScript\">\n\nfunction validateCheckBox(obj){\n\tvar formObj = document.forms[0];//modified By yadav\n\tformObj.modified_flag.value=\"false\";\n\tvar name=obj.name;\n\tvar ind=name.substring(10,12);\n\tif(obj.checked==true){   \n\t\t\t//obj.select_yn=\"Y\";\n\t\t\tobj.setAttribute(\'select_yn\',\'Y\');\n\t\t\tdocument.getElementById(\"Srl_No\"+ind).disabled=true;\n\t\t\t\n\t}else{\n\t\t   //obj.select_yn=\"N\";\n\t\t   obj.setAttribute(\'select_yn\',\'N\');\n\t\t   document.getElementById(\"Srl_No\"+ind).disabled=false;\n\t\t  }\n\n\tvar arrobj1=document.forms[0].elements;\n\t\n\tfor(var i=0;i<arrobj1.length-1;i++)\n\t\t{\n\t\t\tarrobj1[i+1].srl_no=arrobj1[i].value;\n\t\t\ti++;\n\t\t}\n\n\t\tfor(var j=0;j<arrobj1.length-2;j=j+2)\n\n                {\n\n               \n                if((arrobj1[j+1].checked==true)&&(arrobj1[j+1].srl_no==\"0\"))\n\n                            {\n\t\t\t\t\t\t\t\tarrobj1[j+1].checked;\n\n                            alert(\'The Serial No can not be inserted as 0 \');\n\n                            arrobj1[j+1].checked=false\n\t\t\t\t\t\t\tarrobj1[j].disabled=false\n                            arrobj1[j].focus();\n\n                            return;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\tcontinue;\n\t\t\t\t}\n\n\t\n\tvar arrObj = document.forms[0].elements;\n\t\n\tfor(var i=0;i<arrObj.length;i++){\n\t\tif(arrObj[i].type==\"checkbox\" ){\n\t\t\tif(arrObj[i].value==arrObj[i].getAttribute(\'select_yn\')){\n\t\t\t  //arrObj[i].db_change=\"N\";\n\t\t\t  arrObj[i].setAttribute(\'db_change\',\'N\');\n\t\t\t \n\t\t\t\t  continue;\n\t\t\t}else{\n\t\t\t\tformObj.modified_flag.value=\"true\";\n\t\t\t\t //arrObj[i].db_change=\"Y\";\n\t\t\t\t arrObj[i].setAttribute(\'db_change\',\'Y\');\n\t\t\t}\n\t\t} \n\t\t\n\t}\n\n\t\n\t\t\n}\n\nfunction previous(){\n     var frm=window.parent.frames[0].document.forms[0];\n\t var frm1=window.parent.frames[1];\n\t //var frm2=window.parent.frames[1].frames[1];\n\t //alert(frm.name);\n\t //alert(frm1.name);\n\t //alert(frm2.name);\n\t var formObj = document.forms[0];\n\n\t var modified_flag=formObj.modified_flag.value;\n\t if(modified_flag==\"true\"){\n\t\talert(\"Please apply Changes..!\");\n\t\treturn;\n\t}\n\tvar role_id=frm.role_description.value;\n\t//var execute_flag=formObj.execute_flag.value\n\tvar start = formObj.start.value;\n\tformObj.start.value=start-14;\n\tvar end = formObj.end.value;\n\tformObj.end.value=end-14;\n\tstart = formObj.start.value;\n\tend = formObj.end.value;\n    //alert(window.parent.frames[1].name);\n\t//alert(window.parent.frames[1].frames[2].name);\n\tdocument.location.href=\"../../eOT/jsp/FunctionsForRoleDetailForm.jsp?from=\"+start+\"&to=\"+end+\"&role_id=\"+role_id;\n\t//window.parent.messageFrame.document.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\";\n\t\t\n}\n\n  function next(){\n\t var frm=window.parent.frames[0].document.forms[0];\n\t var frm1=window.parent.frames[1];\n\t //var frm2=window.parent.frames[1].frames[1];\n\t// alert(frm.name);\n\t //alert(frm1.name);\n\t //alert(frm2.name);\n\t var formObj = document.forms[0];\n\t var modified_flag=formObj.modified_flag.value;\n\t if(modified_flag==\"true\"){\n\t\talert(\"Please apply Changes..!\");\n\t\treturn;\n\t}\n\t var role_id=frm.role_description.value;\n\t //alert(role_id);\n\t var start = formObj.start.value;\n\t formObj.start.value=parseInt(start)+14;\n\t start = formObj.start.value;\n\t var end = formObj.end.value;\n\t formObj.end.value=parseInt(end)+14;\n\t end = formObj.end.value;\n   //alert(window.parent.frames[1].name);//frames[1].frames[1].name);\n// alert(window.parent.frames[1].frames[1].frames[1].name);\t\n   var frmobj=window.parent.frames[1];\ndocument.location.href=\"../../eOT/jsp/FunctionsForRoleDetailForm.jsp?from=\"+start+\"&to=\"+end+\"&role_id=\"+role_id;\n\t//window.parent.messageFrame.document.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\";\n\t\t\n\t \n\n\t\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<BODY class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"StatusDetailForm\" id=\"StatusDetailForm\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=3  align=\'center\'>\n<th class=\'columnHeaderCenter\' nowrap>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</th>\n<th class=\'columnHeaderCenter\' nowrap>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</th>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n</center>\n<br><center>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n<input type=\"hidden\" name=\"modified_flag\" id=\"modified_flag\" value=\"false\" >\n<input type=\"hidden\" name=\"execute_flag\" id=\"execute_flag\" value=\"YES\" >\n<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n<input type=\"hidden\" name=\"srl_number\" id=\"srl_number\" value=\"\" >\n<input type=\"hidden\" name=\"sel\" id=\"sel\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n<input type=\"hidden\" name=\"chkval\" id=\"chkval\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"role_id\" id=\"role_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"srl_no_from_DB\" id=\"srl_no_from_DB\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n</center>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'rowNo\' id=\'rowNo\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n</form>\n</BODY>\n<script>\n//Added By yadav for disabling SequenceNo\nvar st=document.getElementById(\"start\").value;\nvar rowNo=document.getElementById(\"rowNo\").value;\n\nfor(var i=st;i<=parseInt(rowNo-1);++i)\n\t\t{\n\t\tif(document.getElementById(\"chk_select\"+i).checked==true )\n\t\t\tdocument.getElementById(\"Srl_No\"+i).disabled=true;\n\t\t\n\t\t}\n</script>\n</HTML>\n\n";
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
  String role_id=CommonBean.checkForNull(request.getParameter("role_id"));
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

  //OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
   String from = CommonBean.checkForNull(request.getParameter( "from" )) ;
   String to =   CommonBean.checkForNull(request.getParameter( "to" ) ) ;
  
   
   String select_value="Y";
   String function_id="";
   String function_desc_user="";
   String sel="";
   String srl_no="";
   StringBuffer srl_no_from_DB=new StringBuffer();
   String select_checked="";
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   Connection conn = null;
   PreparedStatement pstmt = null;
   //PreparedStatement pstmt1= null;
   ResultSet rst=null;
   //ResultSet rst1=null;
    String strsql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_USER,nvl(B.SRL_NO,'0'),DECODE (B.FUNCTION_ID, A.FUNCTION_ID,'Y','N') SEL FROM OT_FUNCTIONS_LANG_VW A, OT_ROLES_FUNCTIONS B WHERE A.LANGUAGE_ID ='"+locale+"'  AND A.FUNCTION_ID = B.FUNCTION_ID(+) AND B.ROLE_ID(+)= ? ORDER BY 1";
   
   
   int maxRecord = 0;
   int i=1;
   try{
   
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,role_id);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			//return;
			
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,role_id);
		rst = pstmt.executeQuery();


            _bw.write(_wl_block9Bytes, _wl_block9);

	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
		String classValue= " ";
		int k=0;
		while ( rst.next() && i<=end  ){
		if ( i % 2 == 0 )
            classValue = "gridData" ;
        else
		    classValue = "gridData" ;
 			function_id = rst.getString(1);
			function_desc_user= rst.getString(2);
			srl_no=rst.getString(3);
			if(!rst.getString(3).equals("0"))
			srl_no_from_DB=srl_no_from_DB.append(",").append(rst.getString(3));
			sel=rst.getString(4);
			if(srl_no.equals("null"))
			srl_no="&nbsp;";
 			out.println("<tr>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_id+"</td>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_desc_user+"</td>");
			out.println("<td class='" + classValue+"' nowrap><input type=text name=Srl_No"+i+" id=Srl_No"+i+" value="+srl_no+" size=2 maxlength=2  db_change1='N' onblur='CheckNum(this)' ></td>");
   			if (sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
					k++;
			}else{
				select_checked="";
				select_value="N";
			}
			out.println("<td class='"+classValue+"' nowrap><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+select_value+" "+select_checked+"  func_id='"+function_id+"' db_change='N' srl_no='' select_yn='"+select_value+"' onclick='validateCheckBox(this);'>");
			out.println("</td>");
		    out.println("</tr>");
   			i++;
		} 
	
            _bw.write(_wl_block13Bytes, _wl_block13);
 
   }catch(Exception e){
		e.printStackTrace();
		//out.println("FunctionForRoleDetailForm : "+e);
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
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
            out.print( String.valueOf(select_value));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(role_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(srl_no_from_DB));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FunctionID.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SequenceNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
