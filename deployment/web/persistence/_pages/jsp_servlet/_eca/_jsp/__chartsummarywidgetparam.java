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
import com.ehis.util.*;

public final class __chartsummarywidgetparam extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryWidgetParam.jsp", 1709115715980L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t\t<title>Widget Param</title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\"\tlanguage=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\"\t\t\tlanguage=\"javascript\"></script>\n\t\t<script src=\'../js/WidgetParameter.js\'\t\t\tlanguage=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\' >\n\n\n<form name=\"chartSummaryWidgetParamForm\" id=\"chartSummaryWidgetParamForm\"  action=\'../../servlet/eCA.WidgetParamServlet\' method=\"post\" target=\"messageFrame\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<BR><BR><BR><BR><BR><BR><BR><BR>\n <table cellpadding=\'3\' cellspacing=\'0\' border=\'0\'  align=\'center\'\'>\n\t<tr>\n\t  <td class=\"label\" align=\'left\'>Enable Widget Themes/Icons</td>\n\t  <td align=\'right\'><input type=\"checkbox\" name=\"EnableWidgetThemeOrIcon\" id=\"EnableWidgetThemeOrIcon\" value = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" onclick =\"enableDisableWidgetThemeOrIcon(this)\"></td>\n\t  </td>\n\t</tr>\n\t\t\n\t<tr id=\"widgetThemes\" style=\"display:none\">\n\t  <td  class=\"label\" align=\'left\'>Widget Themes</td>\n\t  <td colspan=\"2\" align=\'right\' class=\"label\"><input type=\"radio\" name=\"widgetTheme\" id=\"widgetTheme\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" id =\'themerequired\' onclick=\"defaultWidgetThemeSelection(this)\">Yes</td>\n\t</tr>\n\t<tr id=\"widgetThemes1\" style=\"display:none\">\n\t  <td  class=\"label\" align=\'left\'></td>\n\t  <td colspan=\"2\" align=\'right\' class=\"label\"><input type=\"radio\" name=\"widgetTheme\" id=\"widgetTheme\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" id =\'themenotrequired\' onclick=\"defaultWidgetThemeSelection(this)\">No</td>\n\t</tr>\n\t<tr id=\"widgetIcons\" style=\"display:none\">\n\t  <td  class=\"label\" align=\'left\'>Widget Icons</td>\n\t  <td colspan=\"2\" align=\'right\' class=\"label\"><input type=\"radio\" name=\"widgetIcons\" id=\"widgetIcons\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" id =\'iconsrequired\' onclick=\"defaultWidgetIconSelection(this)\">Yes</td>\n\t</tr>\n\t<tr id=\"widgetIcons1\" style=\"display:none\">\n\t  <td  class=\"label\" align=\'left\'></td>\n\t  <td colspan=\"2\" align=\'right\' class=\"label\"><input type=\"radio\" name=\"widgetIcons\" id=\"widgetIcons\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" id =\'iconsnotrequired\' onclick=\"defaultWidgetIconSelection(this)\">No</td>\n\t</tr>\n\t<!-- IN034513 starts -->\n\t<tr>\n\t  <td class=\"label\" align=\'left\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t  <td align=\'right\'><input type=\"checkbox\" name=\"EncntrGrpngCurrSpeclty\" id=\"EncntrGrpngCurrSpeclty\" value = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" onclick =\"enableEncounterGrpByCurrSpeclty(this)\"></td>\n\t  </td>\n\t</tr>\n\t<!-- IN034513 ends -->\n</table>\n\t<input type=hidden name=\"widget_ThemeIcon_yn\" id=\"widget_ThemeIcon_yn\" value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t<input type=hidden name=\"widget_Theme_yn\" id=\"widget_Theme_yn\" value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t<input type=hidden name=\"widget_Icon_yn\" id=\"widget_Icon_yn\" value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t<input type=hidden name=\"enc_grp_by_splty_yn\" id=\"enc_grp_by_splty_yn\" value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="><!-- IN034513 -->\n</form>\n<script>\nvar enableThemeIcon_yn = document.chartSummaryWidgetParamForm.EnableWidgetThemeOrIcon.value;\n\nif(enableThemeIcon_yn == \'Y\'){\t\n\tdocument.getElementById(\'widgetThemes\').style.display=\'\';\n\t\tdocument.getElementById(\'widgetThemes1\').style.display=\'\';\n\t\tdocument.getElementById(\"widgetIcons\").style.display=\'\';\n\t\tdocument.getElementById(\'widgetIcons1\').style.display=\'\';\n\t\n}\n\n</script> \n</body>\n</html>\t\t\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           							created
12/02/2013		CHL_CRF			Nijitha									CHL_CRF   
21/03/2014	 	IN034513	  	Vijayakumar K 							SS-CRF-0007 In the patient Chart Clinician Access, 
																		the previous Encounters were grouped by specialty in eHIS version 5x. This enabled the doctors to view the details of their desired specialty. With the upgrade, this grouping has been removed.								 
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

            _bw.write(_wl_block5Bytes, _wl_block5);

			request.setCharacterEncoding("UTF-8");	
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	String widgetThemeIconChecked ="";
	String widgetThemeIconIndicator="N";
	String widgetThemeIndicator="";
	String widgetIconIndicator="";
	String widgetThemeChecked_YES ="";
	String widgetThemeChecked_NO ="";
	String widgetIconChecked ="";
	String widgetIconChecked_YES ="";
	String widgetIconChecked_NO ="";
	String widgetThemeIndicator_yes="Y";
	String widgetThemeIndicator_no="N";
	String widgetIconIndicator_yes="Y";
	String widgetIconIndicator_no="N";
	//IN034513 starts
	String enc_grp_by_splty_yn="N";
	String enc_grp_checked ="";
	//IN034513 ends
	try{
	conlCon = ConnectionManager.getConnection(request);
	StringBuilder sblQry = new StringBuilder();
	//IN034513 starts
	//sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN FROM CA_WIDGET_PARAM ");
	sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN,ENC_GRP_BY_SPLTY_YN FROM CA_WIDGET_PARAM ");
	//IN034513 ends
	pstmt = conlCon.prepareStatement( sblQry.toString());
	rslRst = pstmt.executeQuery();
	if(rslRst.next())
	{
		do
		{
			widgetThemeIconIndicator = rslRst.getString("WIDGET_THEME_ICON_YN");
			widgetThemeIndicator = rslRst.getString("WIDGET_THEME_YN");
			widgetIconIndicator = rslRst.getString("WIDGET_ICON_YN");
			enc_grp_by_splty_yn = rslRst.getString("ENC_GRP_BY_SPLTY_YN");//IN034513
			
			if("Y".equals(widgetThemeIconIndicator))
			{
				widgetThemeIconChecked="checked";
			}
			if("Y".equals(widgetThemeIndicator))
			{
				widgetThemeChecked_YES="checked";
				widgetThemeChecked_NO="";
				widgetThemeIndicator_yes="Y";
			}
			else
			{
				widgetThemeChecked_NO="checked";
				widgetThemeChecked_YES="";
				widgetThemeIndicator_no="N";
			}
			if("Y".equals(widgetIconIndicator))
			{
				widgetIconChecked_YES="checked";
				widgetIconChecked_NO="";
				widgetIconIndicator_yes="Y";
			}
			else
			{
				widgetIconChecked_NO="checked";
				widgetIconChecked_YES="";
				widgetIconIndicator_no="N";
			}
			//IN034513 starts
			if("Y".equals(enc_grp_by_splty_yn))
			{
				enc_grp_checked="checked";
			}
			else
			{
				enc_grp_checked = "unchecked";
			}
			//IN034513 ends
		}while(rslRst.next());
			out.println("<input type='hidden' name='mode' id='mode' value='update'>");
	}
	else
	{
			out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
	}		
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();	



            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(widgetThemeIconIndicator));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(widgetThemeIconChecked));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(widgetThemeIndicator_yes));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(widgetThemeChecked_YES));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(widgetThemeIndicator_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(widgetThemeChecked_NO));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(widgetIconIndicator_yes));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(widgetIconChecked_YES));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(widgetIconIndicator_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(widgetIconChecked_NO));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(enc_grp_by_splty_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(enc_grp_checked));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(widgetThemeIconIndicator ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(widgetThemeIndicator ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(widgetIconIndicator ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(enc_grp_by_splty_yn ));
            _bw.write(_wl_block20Bytes, _wl_block20);

}
catch(Exception e)
{
//out.println("Exception in ChartSummaryWidgetParam.jsp:"+e.toString());//common-icn-0181
e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EncGrpCurrSpeclty.label", java.lang.String .class,"key"));
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
}
