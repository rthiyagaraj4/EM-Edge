package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __schedulevaccinadmintab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ScheduleVaccinAdminTab.jsp", 1732691876644L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script src=\'../js/ScheduleForVacination.js\' language=\'javascript\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t<title></title>\n<script>\nfunction dfltTab()\n{\n\tvar loadAlrg =document.getElementById(\"loadAlrg\").value;\n\tif(loadAlrg==\'N\')\n\t{\n\t\tdocument.getElementById(\"allergy_tab\").className = \"tabA\";\n\t\tdocument.getElementById(\"allergy_tabspan\").className = \"tabAspan\";\n\t\tprevTabObj=\"admin_tab\";\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\"admin_tab\").className = \"tabA\";\n\t\tdocument.getElementById(\"admin_tabspan\").className = \"tabAspan\";\t\n\t\tprevTabObj=\"allergy_tab\";\n\t}\n}\n//parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href=\"ScheduleVaccinAdminDetails.jsp?\"+query_string+\"&vac_sch_ref=\"+vac_sch_ref+\"&vaccine_id=\"+vaccine_id+\"&dose_no=\"+dose_no+\"&mode_new=modify&adhoc_yn=\"+adhoc_yn;\n\nfunction tab_clickAdmin(id) \n{\t\n\tprevTabObj=\"allergy_tab\";\n\tselectTab(id);\n\tloadAdministerPage();\n\t//moveToLink(1);\n}\nfunction loadAdministerPage()\n{\n\tvar query_string =document.getElementById(\"query_string\").value;\n\tvar mode=document.getElementById(\"mode\").value;\n\tvar adhoc_yn=document.getElementById(\"adhoc_yn\").value;\n\tvar appl_task_id = document.vaccinAdminTabsForm.appl_task_id.value;\n\tif(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" == \"\" && \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" == \"\")\n\t{\n\t\tparent.VaccinAdminDetailsFrame.location.href=\'../../eCA/jsp/ScheduleVaccinAdminDetails.jsp?query_string=\'+query_string+\'&mode_new=\'+mode+\'&adhoc_yn=\'+adhoc_yn+\'&option_id=\'+appl_task_id;\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\t\n\t}else{\t\t\n\t\tparent.VaccinAdminDetailsFrame.location.href=\"ScheduleVaccinMedAdminDetails.jsp?query_string=\"+query_string;\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\t\n\t}\n\t\n}\n\nfunction tab_clickAllergy(id) \n{\n\t\n\tprevTabObj=\"admin_tab\";\n\tvar query_string =document.getElementById(\"query_string\").value;\n\tselectTab(id);\n\t//moveToLink(2);\n//alert(\'query_string...\'+query_string);\n\tparent.VaccinAdminDetailsFrame.location.href=\'../../eCA/jsp/ScheduleVaccAllegyMain.jsp?query_string=\'+query_string;\n\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\t//ScheduleVaccAllegyMain.jsp\n\t//callRecClinicalNotesSearch();\n}\nfunction moveToLink(LinkIndex) {\n\tif(LinkIndex==1)\n\t{\n\t\tparent.frames[1].document.getElementById(\"AdministerDetails\").scrollIntoView();\n\t\tparent.frames[1].document.forms[0].vaccine_name.focus();\n\t}\n\telse if(LinkIndex==2)\n\t{\n\t\t\tparent.frames[1].document.getElementById(\"allergies\").scrollIntoView();\n\t\t\tparent.frames[1].document.forms[0].vaccine_name1.focus();\n\t}\n}\n\n\n</script>\n\t\n\t</head>\n\n\t<form name=\'vaccinAdminTabsForm\' id=\'vaccinAdminTabsForm\'>\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\' onLoad=\"dfltTab()\" >\n\n\t<center>\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width= \"100%\" class=\"white\">\n\t\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\">\n\t\t\t\t<li class=\"tablistitem\" title=\'Administer Details\' >\n\t\t\t\t<a onclick=\"tab_clickAdmin(\'admin_tab\')\" class=\"tabClicked\" id=\"admin_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"admin_tabspan\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li id=\'allergy\' class=\"tablistitem\" title=\'Allergy\'>\n\t\t\t\t<a onclick=\"tab_clickAllergy(\'allergy_tab\')\" class=\"tabClicked\" id=\"allergy_tab\" readonly >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"allergy_tabspan\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t</ul>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t</center>\n\t <input type=hidden value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' name=\'query_string\' id=\'query_string\'>\n\t <input type=hidden value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' name=\'loadAlrg\' id=\'loadAlrg\'>\n\t <input type=hidden value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' name=\'adhoc_yn\' id=\'adhoc_yn\'>\n\t <input type=hidden value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' name=\'mode\' id=\'mode\'>\n\t <input type=hidden value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' name=\'appl_task_id\' id=\'appl_task_id\'>\n\t</form>\n\t<Script>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\tdocument.getElementById(\"allergy\").style.visibility = \'visible\' ;\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\tdocument.getElementById(\"allergy\").style.visibility = \'hidden\' ;\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t</script>\n\n\t</body>\n\n\t\n</html>\n\t\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String administered_date =request.getParameter("administered_date")==null?"":request.getParameter("administered_date");  //undefined
	String status =request.getParameter("status")==null?"":request.getParameter("status");  //undefined
	String loadAlrg =request.getParameter("loadAlrg")==null?"N":request.getParameter("loadAlrg");  //undefined
	String mode =request.getParameter("mode_new")==null?"":request.getParameter("mode_new");  //undefined
	String adhoc_yn =request.getParameter("adhoc_yn")==null?"N":request.getParameter("adhoc_yn");  //undefined
	String alergry_exists_yn =request.getParameter("alergry_exists_yn")==null?"N":request.getParameter("alergry_exists_yn"); 
	String hideAlrgTab =request.getParameter("hideAlrgTab")==null?"N":request.getParameter("hideAlrgTab"); 
	String order_id =request.getParameter("order_id")==null?"":request.getParameter("order_id");  //undefined
	String ord_drug_code =request.getParameter("ord_drug_code")==null?"":request.getParameter("ord_drug_code");  //undefined

	//String mode_new =request.getParameter("mode_new")==null?"N":request.getParameter("mode_new");  //undefined
	//out.println("loadAlrg ..."+loadAlrg);
	/*out.println("<br>status ..."+status);
	/*out.println("<br>alergry_exists_yn ..."+alergry_exists_yn);
	out.println("<br>adhoc_yn ..."+adhoc_yn);
	out.println("<br>ord_drug_code ..."+ord_drug_code);
	out.println("<br>order_id ..."+order_id);
	out.println("<br>mode ..."+mode);*/


	String query_string =request.getQueryString();  

	

	if(administered_date.equals("undefined"))
		{
			administered_date ="";
		}
		if(status.equals("undefined"))
		{
			status ="";
		}

 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ord_drug_code));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(loadAlrg));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(adhoc_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getParameter("option_id")));
            _bw.write(_wl_block16Bytes, _wl_block16);

			if((alergry_exists_yn.equals("Y") || status.equals("C")) && hideAlrgTab.equals("N"))
			{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
			else 
			{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
		
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AdministerDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Allergy.label", java.lang.String .class,"key"));
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
