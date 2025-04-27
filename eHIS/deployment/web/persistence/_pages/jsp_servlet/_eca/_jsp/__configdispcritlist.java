package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.SectionConfigDispFldBean;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __configdispcritlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ConfigDispCritList.jsp", 1730876755300L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\n\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/ConfigDispCrit.js\'></script>\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"formConfigDispFlds\" id=\"formConfigDispFlds\">\n<br>\n<div style=\"display: flex; justify-content: center;\">\n<table class=\"grid\" width=\'85%\' align=\'center\' id=\'tblResultLinked\' style=\'visibility:visible\' >\n\t<tr>\n\t\t<th class=\'columnheader\' width=\'20%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t\n\t\t<th class=\'columnheader\' width=\'60%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\n\t\t<th class=\'columnheader\' width=\'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t</tr>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.ConfigDispFldsIntermediate.location.href=\"../../eCA/jsp/ConfigDispFldsIntermediate.jsp?key=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&mode=ADD&fieldCount=\"+";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\n</table>\n</div>\n\t<input type=\'hidden\' name=\'firstPos\' id=\'firstPos\' value=\'\'>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'resCategoryKey\' id=\'resCategoryKey\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	

	String resCategory = request.getParameter("resCategory")==null?"":request.getParameter("resCategory");
	String resSubCategory = request.getParameter("resSubCategory")==null?"":request.getParameter("resSubCategory");
	String configStrSql = request.getParameter("configStrSql")==null?"":request.getParameter("configStrSql");
	String pos1 = request.getParameter("pos1")==null?"":request.getParameter("pos1");
	String pos2 = request.getParameter("pos2")==null?"":request.getParameter("pos2");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String pageReload = request.getParameter("pageReload")==null?"":request.getParameter("pageReload");
	
	int index1, index2;
	
	if(pos1 != null && pos2 != null)
	{
		index1 = Integer.parseInt(pos1);
		index2 = Integer.parseInt(pos2);
	}
	else
	{
		index2  = 0;
		index1 = 0;
	}
	eCA.SectionConfigDispFldBean confBean = (eCA.SectionConfigDispFldBean)session.getAttribute("ConfigDispFldBean");
	if(confBean != null)
	{	
		if(configStrSql != null && !configStrSql.equals(""))
		{
			confBean.setSectionConfig(configStrSql, resCategory, resSubCategory, index1, index2);
		}
		else
		{
			confBean.setSectionConfig(resCategory, index1, index2);
		}
		LinkedList<String> dispCol = confBean.getDispColumn();
		LinkedList<String> filedRef = confBean.getFieldReffColumn();
		Map<String, ArrayList<String>> keyData = confBean.getSelectedData();
		Map<String, String> mandatory =	confBean.getMandatoryYN();
		LinkedList<String> orderSeq = (LinkedList<String>)session.getAttribute("OrderSeq");

		if(orderSeq == null)
		{
			mode = "insert";
		}
		else
		{
			mode = "modify";
		}


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			int count = 1;

			for(int i = 0; i < dispCol.size(); i++)
			{
				out.println("<tr id = 'numRows"+count+"'>");
				out.println("<td  width='20%' class='gridNumericData'><a id='gridLnk"+i+"' class='gridLink' href='javascript:changeColor("+dispCol.lastIndexOf(dispCol.get(i))+",\""+resCategory+"\",\""+count+"\");'>"+count+"</a></td>");
				out.println("<td  width='60%' class='gridData'>"+dispCol.get(i)+"</td> </td>");
				String check = mandatory.get(filedRef.get(i));

				if(mode.equals("modify"))
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");
					}
					else if(pageReload != null && pageReload.equals("reload"))
					{
						if(keyData.containsKey(filedRef.get(i))){
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");
						}
						else
						{
							out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");						
						}
					}
					else if(orderSeq.contains(filedRef.get(i)))
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(filedRef.get(i)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
					else
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");	
					}

				}
				else
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");
					}
					else if(pageReload != null && pageReload.equals("reload"))
					{
						if(keyData.containsKey(filedRef.get(i)))
						{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");
						}
						else
						{
							out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");						
						}
					}
					else
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(filedRef.get(i)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
				}
				count++;
			}
	}
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(resCategory));
            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OrderSequence.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DisplayFields.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
