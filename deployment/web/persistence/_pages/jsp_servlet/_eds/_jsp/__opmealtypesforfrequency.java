package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __opmealtypesforfrequency extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/OPMealTypesForFrequency.jsp", 1745232207900L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nFile Name\t\t: OPMealTypesForFrequency.jsp\nFile Description: This file is for selecting MealTypes for OPMeal Order.\nCRF#\t\t\t: Bru-HIMS-CRF-230\nAuthor\t\t\t: Abirami\nDate\t\t\t: Aug-2013\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t<script type=\"text/javascript\">\n\t\n//Function: For Getting Meal Types:\nfunction getMealTypes(fecthedMealTypes,mealtype){\n\n\tvar mealArray = fecthedMealTypes.split(\",\");\n\tvar tableObj = null;\n\tvar found_flag = false;\n\tvar code = null;\n\ttableObj = document.getElementById(\"AbleM\");\n\tvar selObj = \"\";\n\tvar row_ind = 0;\n\t//get Meal Desc ::\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root></root>\";\n\t\tvar param=\"func_mode=getMealDesc&fecthedMealTypes=\"+fecthedMealTypes;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eDS/jsp/DLCommonValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = xmlHttp.responseText;\n\t\tretVal = TrimStr(retVal);\n\t\tif(retVal != null && retVal != \"\"){\n\t\t\tvar mealArray = retVal.split(\"???\");\n\t\t\tif(mealArray!=\'\'){\n\t\t\n\t\t\t\tfor (var i=0; i < mealArray.length;) {\n\t\t\t\t\tvar mealList = mealArray[i].split(\":::\");\n\t\t\t\t\tvar mealCode = mealList[0];\n\t\t\t\t\tvar mealDesc = mealList[1];\n\t\t\t\t\t\n\t\t\t\t\tvar sel=\"\";\n\t\t\t\t\t//if( i % 2 == 0){\n\n\t\t\t\t\t\tvar newRow = tableObj.insertRow(row_ind);\n\t\t\t\t\t\tvar newCellDesc = newRow.insertCell(newRow.cells.length);\n\t\t\t\t\t\tnewCellDesc.className = \"label\";\n\t\t\t\t\t\t//newCellDesc.appendChild(document.createTextNode(mealArray[i+1]));\n\t\t\t\t\t\tnewCellDesc.appendChild(document.createTextNode(mealDesc));\n\t\t\t\t\t\t//sel=\"<input type=\'hidden\' name=\'mealType\' id=\'mealType\'\"+row_ind+\" value=\'\"+mealArray[i]+\"\'>\";\n\t\t\t\t\t\tsel=\"<input type=\'hidden\' name=\'mealType\' id=\'mealType\'\"+row_ind+\" value=\'\"+mealCode+\"\'>\";\n\t\t\t\t\t\tvar newCellCBox = newRow.insertCell(newRow.cells.length);\n\t\t\t\t\t\tvar mealTypesind=\"mealType_\"+row_ind;\n\t\t\t\t\t\tvar mealTypeDesc = mealDesc; //mealArray[i+1];\n\t\t\t\t\t\t\tif(mealTypeDesc != \"\"){\n\t\t\t\t\t\t\t\tvar mealTypeDescArr = mealTypeDesc.split(\" \");\n\t\t\t\t\t\t\t\tfor(var j=1 ; j <=mealTypeDescArr.length;j++){\n\t\t\t\t\t\t\t\t\tmealTypeDesc = mealTypeDesc.replace(\" \",\"#\");\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t//code = mealArray[i]+\"@\"+mealTypeDesc;\n\t\t\t\t\t\tcode = mealCode+\"@\"+mealTypeDesc;\n\n\t\t\t\t\tvar checkedYn = \"\"\n\t\t\t\t\tvar disabledYn = \"\";\n\t\t\t\t\t//if(mealtype==mealArray[i])\n\t\t\t\t\t\n\t\t\t\t\tif(mealtype==mealCode)\n\t\t\t\t\t{\n\t\t\t\t\t\tcheckedYn=\"checked\"\n\t\t\t\t\t}\n\n\t\t\t\t\t//alert(\"mealtype..\"+mealtype)\n\t\t\t\t\tsel+=\"<input type=\\\"checkbox\\\" value=\" +code+ \" name=\" + mealTypesind + \" id=\" + mealTypesind + \" \"+checkedYn+\" onclick=\\\"setStatus(\"+row_ind+\",this.value)\\\" >\"\n\t\t\t\t\t\n\t\t\t\t\tnewCellCBox.innerHTML = sel;\n\t\t\t\t\trow_ind++;\n\t\t\t\t\t//}\n\t\t\t\t\ti++;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n}\n\nvar k=0;\nvar mealTypesArray = new Array();\nfunction setStatus(ind,mealTypes){\n\tchkBox = document.getElementById((\"mealType_\" + ind));\n\tif(chkBox != null || chkBox != \"\"){\n\t\tif(chkBox.checked == true){\n\t\t\tmealTypesArray[ind]=mealTypes;\n\t\t\tk++;\n\t\t}else{\n\t\t\tmealTypesArray[ind]=\"\";\n\t\t\tk++;\n\t\t}\n\t}\n}\nvar mealTypeStr;\n\nfunction getMealTypesSpFoodItems() {\n\t\tfor (var i=0; i < mealTypesArray.length ;i++ )\n\t\t{\n\t\t\tif(mealTypesArray[i] == undefined){\n\t\t\t\tmealTypesArray[i] = \"\";\n\t\t\t}\n\t\t}\n\tmealTypeStr=mealTypesArray.join(\"*\");\n\tparent.document.querySelectorAll(\'#dialog-body\')[parent.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.returnValue = mealTypeStr;\n\tparent.document.querySelectorAll(\'#dialog_tag\')[parent.document.querySelectorAll(\'#dialog_tag\').length-1].close();\n\t//top.returnValue = mealTypeStr;\n\t//top.close();\n}\n\n\t</script>\n\t<title>MealTypes...</title>\n\t<style type=\"text/css\">\n\t@import url(../../eDS/css/css2/themes/winxp/skin.css);\n\n\n\t</style>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/navbar.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n</head>\n<body>\n\t<form name=\"\" id=\"\" action=\"\" target=\"messageFrame\">\n\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t<tr id=\"contentsForAssignDietType\" >\n\t\t\t\t\t<TD>\n\t\t\t\t\t\t<div id=\"listContentLayer\" style=\"display:block;visibility:visible;overflow-y: scroll;height:136;width:233;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t\t\t\t\t<TABLE width=\"100%\" id=\"AbleM\" CELLSPACING=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</TD>\n\t\t\t</tr>\n\t\t\t<TR>\n\t\t\t\t<TD colspan=\"4\" align=\"center\" style=\"height:90vh\">\n\t\t\t\t\t<input type=\"button\" name=\"Close\" id=\"Close\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" onClick=\"getMealTypesSpFoodItems()\" class=\"Button\">\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"test\" id=\"test\" value=\"Test\" />\n\t\t<input type=\"hidden\" name=\"fecthedMealTypes\" id=\"fecthedMealTypes\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />\n\t\t<input type=\"hidden\" name=\"mealtype\" id=\"mealtype\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" />\n\t\t<script>\n\t\t\tvar fecthedMealTypes = document.getElementById(\"fecthedMealTypes\").value;\n\t\t\tvar mealtype = document.getElementById(\"mealtype\").value;\n\t\t\tgetMealTypes(fecthedMealTypes,mealtype);\n\t\t</script>\n\t</form>\n\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
  
	    //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends

		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		if (sStyle == null)
				sStyle = "IeStyle.css";
         
		//String locale = (String)request.getAttribute("LOCALE");

		String mealtype=(String)request.getParameter("mealtype");

		String fecthedMealTypes=request.getParameter("fecthedMealTypes");

	System.out.println("fecthedMealTypes:: "+ fecthedMealTypes);
	System.out.println("mealtype:: "+ mealtype);
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fecthedMealTypes));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mealtype));
            _bw.write(_wl_block10Bytes, _wl_block10);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
