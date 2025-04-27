package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingcolorbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingColorBar.jsp", 1709115661418L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<SCRIPT LANGUAGE=\"JavaScript\">\nfunction clearLayer()\n{\n\thidePopUp();\n}\nfunction showToolTip(obj,objcount,text)\n{\t\n\t//alert(\"objcount:\"+objcount);\n\tif(text.length>15)\n\t{\n\t\tvar tab_dat  = \"<table class=\'grid\' id=\'tooltiptable1\'  width=\'\' height=\'10\' align=\'center\'>\"\n\t\ttab_dat   =  tab_dat+\"<tr bgcolor=\'lightyellow\' >\" ;\n\t\ttab_dat    = tab_dat+ \"<td class = \'contextMenuItem\' style=\'padding-left:10px;padding-right:10px\' >\"+text+\"</td>\" ;\n\t\ttab_dat     =tab_dat+ \"</tr>\" ;\t\t\n\t\ttab_dat     =tab_dat+ \"</table> \";\t\t\n\t\t//document.getElementById(\"t\").innerHTML = tab_dat;\t\n\t\tdocument.getElementById(\"descLink\").innerHTML = tab_dat;\t\n\t\tdocument.getElementById(\"descLink\").style.top  = obj.offsetTop;\n\t\tif(objcount==\"5\")\n\t\t{\n\t\t\tdocument.getElementById(\"descLink\").style.left  = obj.offsetLeft+37;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"descLink\").style.left  = obj.offsetLeft+80;\n\t\t}\n\t\tdocument.getElementById(\"descLink\").style.visibility=\'visible\' ;\n\t}\n\telse\n\t{\n\t\thidePopUp();\n\t}\n}\n\nfunction hidePopUp()\n{\n\tif(document.getElementById(\"descLink\"))\n\tdocument.getElementById(\"descLink\").style.visibility=\'hidden\' ;\n}\n\n\n</SCRIPT>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<STYLE>\n\n\tTD.DELTAFAIL{\n\t\tbackground-color:#FFE4E1;\n\t}\n\n</STYLE>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"button_form\" id=\"button_form\">\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n\n<table cellpadding=3 cellspacing=0 width=\'100%\' border=\'0\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<!--<td width=\'8%\'>&nbsp;</td>-->\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<!--<td width=\'13%\'>&nbsp;</td>-->\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td width=\'17%\' height=\'100%\' >\n\t\t<table cellpadding=3 cellspacing=0 width=\'100%\' border=0 >\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<td  onMouseOut=\'clearLayer()\' onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\" width=\'15%\' nowrap>\n\t\t\t\t<font style=\'background:url(\"../../eCA/images/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\");size:1;width:16px;height:16px\' >&nbsp;&nbsp;</font>&nbsp;<font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font>\n\t\t\t</td>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<td  onMouseOut=\'clearLayer()\' width=\'15%\' nowrap onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\">\n\t\t\t\t\t<font style=\'background-color:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =";size:1;width:16px;height:16px\' >&nbsp;&nbsp;</font>&nbsp;\n\t\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td  width=\'15%\' nowrap>\n\t\t\t\t<font style=\'background:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px\' >&nbsp;&nbsp;</font>&nbsp;<font size=1>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<td  width=\'15%\' nowrap>\n\t\t\t\t<font style=\'background-color:#32CD32;size:1;width:16px;height:16px\' >&nbsp;&nbsp;</font>&nbsp;<font size=1>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t</table>\n\t<div id=\'descLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\' ></div>\n\t</form>\n\t\n\t\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	HashMap mapDescColor = new HashMap();
	ArrayList listDesc = new ArrayList();
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale					=	(String) p.getProperty("LOCALE");
    StringBuffer sblQry		= new StringBuffer();
	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String deltaValue	= "";
	String legend_type = "";
	//String module_id		=	request.getParameter("module_id")==null?"":request.getParameter("module_id");

            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

conlCon = ConnectionManager.getConnection(request);
try
{
	sblQry.append("SELECT high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,DELTA_FAIL_STR, HIGH_SYMBOL_ICON, LOW_SYMBOL_ICON, ABN_SYMBOL_ICON, CRIT_SYMBOL_ICON, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_SYMBOL_ICON, LEGEND_TYPE FROM cr_clin_event_param_lang_vw where language_id=? ");
	pstmt = conlCon.prepareStatement(sblQry.toString());
	pstmt.setString(1,locale);
	rslRst = pstmt.executeQuery();


	if(rslRst.next())
	{
		legend_type = rslRst.getString("LEGEND_TYPE") == null ? "S" : rslRst.getString("LEGEND_TYPE");

		high_value_desc = rslRst.getString("high_str_desc") == null ? "" : rslRst.getString("high_str_desc");
		high_value_color = rslRst.getString("high_color_code") == null ? "" : rslRst.getString("high_color_code");
		if(legend_type.equals("S"))
			high_value_color = rslRst.getString("HIGH_SYMBOL_ICON") == null ? "" : rslRst.getString("HIGH_SYMBOL_ICON");

		mapDescColor.put(high_value_desc,high_value_color);
		listDesc.add(high_value_desc);

		low_value_desc = rslRst.getString("low_str_desc") == null ? "" : rslRst.getString("low_str_desc");
		low_value_color = rslRst.getString("low_color_code") == null ? "" : rslRst.getString("low_color_code");
		if(legend_type.equals("S"))
			low_value_color = rslRst.getString("LOW_SYMBOL_ICON") == null ? "" : rslRst.getString("LOW_SYMBOL_ICON");
	   
		if(!(mapDescColor.containsKey(low_value_desc)))
		{
			mapDescColor.put(low_value_desc,low_value_color);
			listDesc.add(low_value_desc);
		}

		abnml_value_desc = rslRst.getString("abn_str_desc") == null ? "" : rslRst.getString("abn_str_desc");
		abnml_value_color = rslRst.getString("abn_color_code") == null ? "" : rslRst.getString("abn_color_code");
		if(legend_type.equals("S"))
			abnml_value_color = rslRst.getString("ABN_SYMBOL_ICON") == null ? "" : rslRst.getString("ABN_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(abnml_value_desc)))
		{
			mapDescColor.put(abnml_value_desc,abnml_value_color);
			listDesc.add(abnml_value_desc);
		}

		crtcl_value_desc = rslRst.getString("crit_str_desc") == null ? "" : rslRst.getString("crit_str_desc");
		crtcl_value_color = rslRst.getString("crit_color_code") == null ? "" : rslRst.getString("crit_color_code");
		if(legend_type.equals("S"))
			crtcl_value_color = rslRst.getString("CRIT_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_value_desc)))
		{
			mapDescColor.put(crtcl_value_desc,crtcl_value_color);
			listDesc.add(crtcl_value_desc);
		}

		crtcl_high_value_desc = rslRst.getString("crit_high_str_desc") == null ? "" : rslRst.getString("crit_high_str_desc");
		crtcl_high_value_color = rslRst.getString("crit_high_color_code") == null ? "" : rslRst.getString("crit_high_color_code");
		if(legend_type.equals("S"))
			crtcl_high_value_color = rslRst.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_HIGH_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
		{
			mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
			listDesc.add(crtcl_high_value_desc);
		}  

		crtcl_low_value_desc = rslRst.getString("crit_low_str_desc") == null ? "" : rslRst.getString("crit_low_str_desc");
		crtcl_low_value_color = rslRst.getString("crit_low_color_code") == null ? "" : rslRst.getString("crit_low_color_code");
		if(legend_type.equals("S"))
			crtcl_low_value_color = rslRst.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_LOW_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
		{
			mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
			listDesc.add(crtcl_low_value_desc);
		}

		deltaValue = rslRst.getString("DELTA_FAIL_STR") == null ? "" : rslRst.getString("DELTA_FAIL_STR");

		out.println("<input type=hidden name='mode' id='mode' value='update'>");
	}
	else
	{
		out.println("<input type=hidden name='mode' id='mode' value='insert'>");
	}


            _bw.write(_wl_block9Bytes, _wl_block9);

		//if(module_id.equals("MC"))
		//{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		//}
		//else
		//{
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		//}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

		String listValues = "";
		String listValuesdisp = "";
		String mapValues = "";

		for(int i=0;i<listDesc.size();i++)
		{
			listValues = (String) listDesc.get(i);
			if(listValues.length()>15)
				listValuesdisp=listValues.substring(0,16);
			else
				listValuesdisp=listValues;
			mapValues = (String) mapDescColor.get(listValues);
			if(legend_type.equals("S"))
			{
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(listValues));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mapValues));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(listValuesdisp));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
			else{
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(listValues));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mapValues));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(listValuesdisp));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
		}
		if(legend_type.equals("S"))
		{
	
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		else
		{
	
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		
		
            _bw.write(_wl_block24Bytes, _wl_block24);

	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in ChartRecordingColorBar.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon !=null)ConnectionManager.returnConnection(conlCon,request);
}

            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
}
