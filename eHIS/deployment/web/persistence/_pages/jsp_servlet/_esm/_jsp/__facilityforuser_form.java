package jsp_servlet._esm._jsp;

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
import com.ehis.util.*;

public final class __facilityforuser_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/FacilityforUser_Form.jsp", 1730982464434L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n\n<head>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eSM/js/FacilitiesForUser.js\' language=\'javascript\'></SCRIPT>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n\nfunction mandatoryChk()\n{\n\t var fields = new Array ( document.forms[0].userID);\n\t var message=document.forms[0].label.value;\n    \n\t var names  = new Array (message);\n\t if(checkFieldsofMst( fields, names, parent.parent.frames[2])) {\n\t parent.parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'\n\t return true;\n\t }\n\t else\n\t return false;\n}\nfunction displayDetails()\n{\n\t\n\tvar searchText = document.resp_form.searchText.value\n\tvar label=document.forms[0].label.value;\n    var filter = document.resp_form.filter.value\n\n\tif(mandatoryChk())\t\n\t{\t\t\t\t  parent.result.location.href=\"../../eSM/jsp/FacilityforUserDetailForm.jsp?userID=\"+document.forms[0].userID.value+\"&flagSelect=fromSelect&searchText=\"+searchText+\"&label=\"+label+\"&filter=\"+filter+\"&label=\"+document.forms[0].label.value;\n\t} else\n\t{\n\t parent.result.location.href=\"../../eCommon/html/blank.html\";\n\n\t}\n}\n\nfunction clearValues()\n{\n\tparent.result.location.href=\"../../eCommon/html/blank.html\";\n}\nfunction callMember(varAlpha)\n{\n\t\n\n}\nfunction blockevent(event){\n       \n\t var whichCode = (window.Event) ? event.which : event.keyCode;\n    if (whichCode==\'13\')\n\treturn false ;\n}\n\n\t\tfunction GetLookupBlur(target)\n\t\t\t{\n\t\t\t\tif(target.value != \"\")\n\t\t\t\t{\n\t\t\t\t\tGetLookup(target);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].userID.value=\'\';\n\t\t\t\t\tparent.result.location.href=\"../../eCommon/html/blank.html\";\n\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tasync function GetLookup(target){\t\t\t\t\n\t\n\t\t\tvar sql=\"\";\t\t\t\n\t\t\tvar retVal\t\t\t= new String();\n\t\t\tvar argumentArray\t= new Array() ;\n\t\t\tvar dataNameArray\t= new Array() ;\n\t\t\tvar dataValueArray\t= new Array() ;\n\t\t\tvar dataTypeArray\t= new Array() ;\t\t\t\n\t\t\tvar tit\t\t\t\t= getLabel(\"Common.user.label\",\'Common\');\n\n\t\t\tsql=\"select  appl_user_id code,appl_user_name description from sm_appl_user where eff_status=\'E\'  and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)\";\n\t\t\t\n\n\t\t\targumentArray[0]\t= sql;\n\t\t\targumentArray[1]\t= dataNameArray ;\n\t\t\targumentArray[2]\t= dataValueArray ;\n\t\t\targumentArray[3]\t= dataTypeArray ;\n\t\t\targumentArray[4]\t= \"1,2\";\n\t\t\targumentArray[5]\t=target.value;\n\t\t\targumentArray[6]\t= DESC_LINK;\n\t\t\targumentArray[7]\t= DESC_CODE;\n\n\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\n\t\t\tif(retVal != null && retVal != \"\" )\n\t\t\t{\n\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\ttarget.value=arr[1];\n\t\t\t\t//target_id.value=arr[0];\n\t\t\t\t//clearValues();\n\t\t\t\tdocument.forms[0].userID.value=arr[0];\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\t//target_id.value=\"\";\n\t\t\t\tclearValues();\n\n\t\t\t}\n\t\n}\n\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\n\t</head>\n\n\t<body  onLoad=\"FocusFirstElement()\" onKeyDown = \'lockKey()\'; OnMouseDown=\"CodeArrest()\";>\n\t\t<form name=\'resp_form\' id=\'resp_form\' action=\'../../servlet/eSM.FacilityForResponsibilityServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\'  width=\'91%\' >\n\t\t\t<tr> \n\t\t\t    <td width=\"25%\" colspan=4>&nbsp;</td>\n\t\t\t    <td width=\"25%\"><td>\n\t\t\t    <td width=\"25%\"><td>\n\t\t\t    <td width=\"25%\"><td>\n\t\t\t</tr>\n\t\t\t\t    <tr>\n\t\t\t\t     \n\t\t\t\t\t <td class=\'label\' id =\'tdLabel\' width=\"25%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n    \t\t\t\t <td class=\'FIELDS\' width=\"25%\">\n\n    \t\t\t\t    \t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\'userName\' id=\'userName\' size=22 onblur=\'GetLookupBlur(userName)\'>\n\t\t\t\t\t\t\t<input type=button class=button name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\'GetLookup(userName)\'>\t\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'userID\' id=\'userID\' value=\'\'>\n\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<select name=\'userID\' id=\'userID\' onChange=\'clearValues()\'><option value=\'\' selected> ------------- ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="----------\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    \t\t\t\t    \t\t\t\t<option value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n    \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'>\n    \t\t\t\t    \t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n    \t\t\t\t    \t\n    \t\t\t\t     </td>\n\t\t\t\t\t\t\t<td width=\"25%\"><td>\n\t\t\t    <td width=\"25%\"><td> \n    \t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t\n    \t\t\t\t\t<td  class=\'label\' width=\"25%\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'FIELDS\' width=\"25%\"><input type=\"text\" onBlur=\'makeValidQueryCriteria(this)\' name=\"searchText\" id=\"searchText\" maxLength=\'35\' size=\'35\' onKeyPress=\"return blockevent(event)\"></td><td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<select name=\"filter\" id=\"filter\" >\n\t\t\t\t\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"BUTTON\"><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' class=\'BUTTON\' onclick=\'displayDetails()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' class=\'BUTTON\' onclick=\'clearValues()\'></td>\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t </table> \n\t\t<input type=\'hidden\' name=\'function1\' id=\'function1\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=\'hidden\' name=\'label\' id=\'label\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\t\n\t</form>\n\n</body>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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

          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con=null;
	try{
    request.setCharacterEncoding("UTF-8");
    con = ConnectionManager.getConnection(request);
	
	Statement stmt=null;
	ResultSet rset=null ;
	String label = request.getParameter("label")==null ? "" : request.getParameter("label");
	String sqlUser = "";
	String dat="";
	String fnval="insert";
	String id="";
		
	try
	{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(label));
            _bw.write(_wl_block9Bytes, _wl_block9);

    				    		
								if(label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
							else
							{
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

								stmt=con.createStatement();
								sqlUser = "select facility_name,facility_id from sm_facility_param order by facility_name";
							
							rset=stmt.executeQuery(sqlUser);
				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    		   dat=rset.getString(1).trim();
    				    		   id=rset.getString(2);
								   
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block15Bytes, _wl_block15);

    				    		   }
    				    		}
								
            _bw.write(_wl_block16Bytes, _wl_block16);

									if(rset!=null)	rset.close();
									if(stmt!=null)	stmt.close();
							}
					 }
				     catch(Exception e){out.print(e);}
				     
            _bw.write(_wl_block17Bytes, _wl_block17);

							if(label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){
							out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.SearchFacility.label","sm_labels"));
						}
						else{
							out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SearchUser.label","common_labels"));
						}
						
							
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(label));
            _bw.write(_wl_block27Bytes, _wl_block27);

}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.criteria.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
