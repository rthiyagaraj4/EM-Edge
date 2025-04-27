package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __agegroupsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AgeGroupSearch.jsp", 1720445648655L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction chk_age_validity(obj){\nvar age_group=obj.value;\nif(age_group!=\"\")\n\t\t{\n\t\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'chk_age\' id=\'chk_age\' method=\'post\' action=\'../../eIP/jsp/AgeGroupValidityCheck.jsp\'><input type=\'hidden\' name=\'age_group\' id=\'age_group\' value=\'\"+age_group+\"\'></form></body></html>\";\t\n\t\t\tparent.parent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.parent.frames[2].document.forms[0].submit();\n\t\t}\n}\n\n// Added by Sridhar on 6 APR 2004\n// This is fired on onClick of the button.... \n// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..\n\nfunction checkTxtVal(target_id,target)\n{\n\tif(document.forms[0].age_group_desc.value == \"\")\n\t\tLookup(target_id,target);\n}\n\n\n// Added by Sridhar on 3 APR 2004\n// Function will check for empty values before calling up the common lookup func..\n\t\t\nfunction beforeGetAgeGroup(target_id,target)\n{\n\tif(document.forms[0].agegrp_desc_hid.value != document.forms[0].age_group_desc.value)\n\t{\n\t\tif(document.forms[0].age_group_desc.value != \"\")\n\t\t\tLookup(target_id,target);\n\t}\n}\n\t\n\n/* CODED ON 07/02/04 by SRIDHAR */\n/* COMMON LOOKUP FOR AGEGROUP START */\nasync function Lookup(target_id,target)\n{\n\tvar facility_id = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\tvar title=\"\";\n\t\n\tvar argumentArray=new Array(8);\n\t\n\tif(target_id.name == \"age_group\")\n\t{\n\t\ttitle=getLabel(\'Common.agegroup.label\',\'common\');\n\n\t\targumentArray[0]=\"select AGE_GROUP_CODE code, SHORT_DESC description from AM_AGE_GROUP where EFF_STATUS like ? and upper(AGE_GROUP_CODE) like upper(nvl(?,AGE_GROUP_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) \";\n\t\t\n\t\targumentArray[1]=new Array(\"EFF_STATUS\");\n\t\targumentArray[2]=new Array(\"E\");\n\t\targumentArray[3]=new Array(STRING);\n\t\targumentArray[4]=\"2,3\";\n\t\targumentArray[5]=target.value;\n\t\targumentArray[6]=CODE_DESC_LINK;\n\t\targumentArray[7]=CODE_DESC;\n}\n\t\t\t\nvar retVal= await CommonLookup(title,argumentArray);\nvar ret1=unescape(retVal);\narr=ret1.split(\",\");\n\t\t\t\n\tif(retVal ==null || retVal==\"\" || !retVal)\n\t{\n\t\ttarget.value=\"\";\n\t\ttarget_id.value=\"\";\n\t}\n\telse\n\t{\n\t\t\n\t\ttarget_id.value=arr[0];\n\t\ttarget.value=arr[1];\n\t\tdocument.forms[0].agegrp_desc_hid.value = document.forms[0].age_group_desc.value\n\t\tchk_age_validity(target_id);\n\t}\n}\n\n/* COMMON LOOKUP FOR AGEGROUP END */\n\nfunction PopulateResult()\n{\n\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\tvar age_group=document.forms[0].age_group.value;\n\tdocument.forms[0].statusval.value=\'Y\';\n\tif(age_group.length>0)\n\t{\n\t\t\tparent.frames[1].location.href=\'../../eIP/jsp/addModifyAgeGroupBkgLimit.jsp?age_group=\'+age_group;\n\t\t\tparent.frames[2].location.href=\'../../eIP/jsp/AgeGroupDynamicValues.jsp\';\n\t}\n\telse\n\t{\n\t\tvar err= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\t\t\n\t\terr= err.replace(\"$\",\"Age Group\");\n\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+err\n\t\t\n\t}\n}\n</script>\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'Search_form\' id=\'Search_form\'>\n  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t<tr>\n\t\t<td width=\"20%\" >&nbsp;</td>\n\t\t<td width=\"30%\" >&nbsp;</td>\n\t</tr>\n\t <tr>\n\t  \t<td align=\'right\' class=\'label\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;&nbsp;</td>\n\t\t <td align=\'left\' class=\'fields\' width=\'60%\' id=td5>\n\t\t \n\t\t \n\t\t\t <!--************ Common Lookup code for Agegroup *************-->\n\t\t\t <input type=\"text\" name=\"age_group_desc\" id=\"age_group_desc\" size=\"15\" maxlength=\"15\" onblur=\"beforeGetAgeGroup(age_group,age_group_desc)\" ><input type=\"button\" class=\"button\" name=\"?\" id=\"?\" value=\"?\" onclick=\"checkTxtVal(age_group,age_group_desc)\"><input type=\"hidden\" name=\"age_group\" id=\"age_group\" size=\"2\" maxlength=\"2\" ><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"></img></td> \n\t\t\t<input type=hidden name=\"agegrp_desc_hid\" id=\"agegrp_desc_hid\" value=\'\'>\n\t</tr>\n\t<tr>\n\t\t<td colspan=1>&nbsp;&nbsp;</td>\n\t\t<td align=right><input type=button class=button value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' name=\'search_age\' onclick=\'PopulateResult()\'>\n\t\t<input type=button class=button value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' name=\'Clear\' onclick=\"parent.frames[1].location.href=\'../../eCommon/html/blank.html\'\" ></td>\n\t</tr>\n<input type=hidden name=facility_id value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'statusval\' id=\'statusval\' value=\'\'>\n\n</form>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con					= null;
	Statement stmt=null;
	ResultSet rs =null;
	String facility_id=(String)session.getValue("facility_id");

String operating_facility_id="";
operating_facility_id=(String) session.getValue("facility_id");
	try{
		con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(operating_facility_id));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

}
catch ( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();
	}
finally{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
		ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.agegroup.label", java.lang.String .class,"key"));
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
}
