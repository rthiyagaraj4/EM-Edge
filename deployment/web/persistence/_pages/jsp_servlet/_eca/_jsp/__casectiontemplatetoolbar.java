package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __casectiontemplatetoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CASectionTemplateToolbar.jsp", 1736157587604L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>\n</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../js/SectionTemplate.js\"></script>\n<script language=\"Javascript\" src=\"../../eCA/js/CASectionTemplateMessage.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'CASectionTemplateToolbarForm\' id=\'CASectionTemplateToolbarForm\' method=\'post\' action=\'../../servlet/eCA.CASectionTemplateServlet\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table  width=\'100%\' cellspacing=\'5\' cellpadding=\'3\' style=\"border: 1.5px solid blue; border-collapse: collapse;\">\n<tr>\n\t<td  colspan = 4 align = right width = \'100%\'>\n\t<input type=\'button\' class=button  name=\'linking\' id=\'linking\' value=\'Dependency\' onclick=\"callOnLinking(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\" style=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' > \n\t<input type=\'button\' class=button  name=\'formulaDefinitionBtn\' id=\'formulaDefinitionBtn\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onclick=\"callOnFormulaDefinition()\" style=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t<input type=\'button\' class=button  name=\'linkHistoryBtn\' id=\'linkHistoryBtn\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onclick=\"callOnLinkHistory()\" style=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >  \n\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t\t<input type =\"button\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" class=\"button\" onClick=\"Record(\'Modify\')\">\n\t\t\t\t<input type =\"button\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\"button\" onClick=\"Record(\'Delete\')\">\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<input  type=\"button\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" class=\"button\" onClick=\"Record(\'Insert\')\">\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<input  type=\"button\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" class=\"button\" onclick=\'getCancel()\'>\n\t</td>\n</tr>\n</table>\n\n<input type=\'hidden\' name=\'section\' id=\'section\' value=\"\">\n<input type=\'hidden\' name=\'hitem_type\' id=\'hitem_type\' value=\"\">\n<input type=\'hidden\' name=\'srl_no\' id=\'srl_no\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'component_type\' id=\'component_type\'  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\'hidden\' name=\'old_hist_time_frame_val\' id=\'old_hist_time_frame_val\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\n<input type=\'hidden\' name=\'old_hist_time_frame_unit\' id=\'old_hist_time_frame_unit\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' >\n<input type=\'hidden\' name=\'comp_id\' id=\'comp_id\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >\n<input type=\'hidden\' name=\'section_code\' id=\'section_code\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'hist_def_yn\' id=\'hist_def_yn\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String operation=request.getParameter("operation");
String value="";
String disableEnableHistBtn="disabled";
//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//String locale = (String) p.getProperty("LOCALE");

if(operation == null) 
{
	operation="insert";
	value="N";
}

String comp_id					=	""	,			prompt_id			=	"";
String srl_no					=	""	,			comp_type			=	"";
String formula_def_button	="display:none";
String linking_btn				="display:none";
String link_history_button	="display:none";
String sectionCode				=	request.getParameter("section");
if(sectionCode==null) sectionCode="";
String link_to_std_value_yn		= "";
String dflt_from_hist_appl_yn	= "";
String old_hist_time_frame_unit = "";
String old_hist_time_frame_val	= "";
String list_presentation ="";
String hist_def_yn = "";


if(operation.equals("modify"))
{
	if(comp_id==null) comp_id="";
	comp_id=request.getParameter("comp_id");
	prompt_id=request.getParameter("prompt_id");
	if(prompt_id==null) prompt_id="";
	srl_no=request.getParameter("srl_no");
	if(srl_no==null) srl_no="";
	comp_type=request.getParameter("comp_type");
	if(comp_type==null) comp_type="";
	list_presentation			=	(request.getParameter("list_presentation")==null)	?""	:	request.getParameter("list_presentation");
	link_to_std_value_yn = request.getParameter("link_to_std_value_yn")==null?"":request.getParameter("link_to_std_value_yn");
	dflt_from_hist_appl_yn = request.getParameter("dflt_from_hist_appl_yn")==null?"N":request.getParameter("dflt_from_hist_appl_yn");
	old_hist_time_frame_unit = request.getParameter("old_hist_time_frame_unit")==null?"":request.getParameter("old_hist_time_frame_unit");
	old_hist_time_frame_val = request.getParameter("old_hist_time_frame_val")==null?"":request.getParameter("old_hist_time_frame_val");
	hist_def_yn = request.getParameter("hist_def_yn") == null ? "":request.getParameter("hist_def_yn");

	if(comp_type.equals("I") || comp_type.equals("N") || comp_type.equals("H"))
	{
		link_history_button = "display";
	}
	else
	{
		link_history_button = "display:none";
	}
	
	if(comp_type.equals("C") || (comp_type.equals("L") && list_presentation.equals("S")))
	{
		formula_def_button="display:none";
		linking_btn="display";
	}

	if(link_to_std_value_yn.equals("N") && dflt_from_hist_appl_yn.equals("Y") && !(comp_type.equals("P") || comp_type.equals("A") || comp_type.equals("R") || comp_type.equals("L")) )
	{
		link_history_button = "display";
	}

	if(dflt_from_hist_appl_yn.equals("Y")){
		if(comp_type.equals("I") || comp_type.equals("N") || comp_type.equals("H"))
		{
			link_history_button = "display";
		}
		else
		{
			link_history_button = "display:none";
		}
		disableEnableHistBtn = "";
	}

	if(comp_type.equals("A"))
	{
		linking_btn="display:none";
		formula_def_button="display";
		
	}
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(comp_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(comp_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(prompt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(linking_btn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FormulaDefinition.label","ca_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(formula_def_button));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LinkHistory.label","ca_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(link_history_button));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disableEnableHistBtn));
            _bw.write(_wl_block16Bytes, _wl_block16);
	if (operation.equals("modify"))
		{ 
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
		}
		else
		{ 
			
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);

		}
	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(comp_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(old_hist_time_frame_val));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(old_hist_time_frame_unit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(comp_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(hist_def_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
