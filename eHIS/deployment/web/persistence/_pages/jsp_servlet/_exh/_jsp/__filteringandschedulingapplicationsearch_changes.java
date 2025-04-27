package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.List;
import eXH.*;
import eXH.XHSQLSet;
import java.util.TreeMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;

public final class __filteringandschedulingapplicationsearch_changes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilteringAndSchedulingApplicationSearch_Changes.jsp", 1742466577391L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>    \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"JavaScript\" src=\'../../eCommon/js/common.js\'> </script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"JavaScript\" src=\'../../eXH/js/Validate.js\'> </script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\n\n<script Language=\"JavaScript\">\n//Added by prithivi for enotification requirement on 11/05/2016. these functions are used for filter out the details\n\tfunction searchFilterValues()\n\t{\n\t\tvar filterGroupCode = document.forms[0].filterCodeValue.value;\n\t\tvar filterLevelType = document.forms[0].filterLevelType.value;\n\t\tvar filterLevelSubType= document.forms[0].filterLevelSubType.value;\n\t\tvar filterLevelSubTypeDesc = document.forms[0].filterLevelSubTypeDesc.value;\n\t\tvar filterLevelValue = document.forms[0].filterLevelValue.value;\n\t\tvar searchFor = \"QueryFilter\";\n\t\tvar queryString = \"searchFor=\"+searchFor+\"&Filter_group_code=\"+filterGroupCode+\"&filter_level_type=\"+filterLevelType+\"&filter_level_subtype=\"+filterLevelSubType+\"&filter_level_subtype_desc=\"+filterLevelSubTypeDesc+\"&filter_level_value=\"+filterLevelValue ;\n\t\t//alert(\"qry string value...\"+queryString);\n\t\tparent.frames[3].location.href=\'../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?\'+queryString+\'&rule=R\';\n\t\tparent.frames[4].location.href=\"../../eCommon/html/blank.html\";\n\t\tparent.frames[5].location.href=\'../../eCommon/jsp/MstCodeError.jsp\';  \n\t}\n\n\tfunction clearSearch()\n\t{\t\n\t\tvar filterGroupCode = document.forms[0].filterCodeValue.value;\n\t\tdocument.forms[0].filterLevelType.value=\"\";\n\t\tdocument.forms[0].filterLevelSubType.value=\"\";\n        document.forms[0].filterLevelSubTypeDesc.value=\"\";\n        document.forms[0].filterLevelValue.value=\"\";\n\t\tvar queryString = \"Filter_group_code=\"+filterGroupCode;\n\t\t//alert(\"qry string value...\"+queryString);\n\t\tparent.frames[3].location.href=\'../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?\'+queryString+\'&rule=R\';\n\t\tparent.frames[4].location.href=\"../../eCommon/html/blank.html\";\n\t\tparent.frames[5].location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\t}\t\n\n\tfunction validate_py_tranx(trans)\n\t{\n\t\tvar payTMReturnStr = \"\";\n\t\tvar payTMData = \"\";\n\t\tvar errMessage = \"\";\n\n\t\tvar l_req = \'<PATIENT_ID>0924168$!^<PAYTM_CODE>281005028j8ym3yygE56E72c$!^<AMOUNT>0.01$!^<PROMO_CODE>$!^<REQUEST>WITHDRAW_MONEY$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>$!^<TRN_TYPE>withdraw$!^<TRN_GUID>\'$!^<SESSION_ID>REGPAT$!^<USER>SETHU\";\n\t\tpayTMReturnStr = payTMTransaction(returnData);\n\n\t\talert(payTMReturnStr);\n\n\t\tpayTMData = payTMReturnStr.split(\"$!^\");\n\n\t\tif (payTMData.length > 0)\n\t\t{\n\t\t\t\n\t\t\tif (payTMData[0] == \"SUCCESS\"){\n\t\t\t\talert(\" ::: PayTM Sale Draft No : \"+payTMData[3]+ \" ::: Receipt ID No : \"+payTMData[4]+\" ::: Transaction Date : \"+payTMData[5]);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\terrMessage = payTMData[1] + \" - \" + payTMData[2];\n\t\t\t\talert(\" ::: errMessage : \"+errMessage);\n\n\t\t\t}\n\t\t}\t\t\t\n\t}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n</HEAD>\n<BODY  leftmargin=0 topmargin=0  onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"FilterSearchForm\" id=\"FilterSearchForm\" target=\'\' action=\'\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<table cellspacing=0 cellpadding=3 width=\'100%\' >\n<tr>\n<td>\n<table cellspacing=0 cellpadding=3 width=\'100%\' >\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="  \n</td>\n</tr>\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</td>\n</tr>\n</table>\n</td>\n<td>\n<table cellspacing=0 cellpadding=3 width=\'100%\' >\n<tr>\n<td class=\"label\"><B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</B></td>\n</tr>\n<tr>\n<td class=\"label\"><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B>\n</td>\n</tr>\n</table>\n</td>\n\n<td>\n<table cellspacing=0 cellpadding=3 width=\'100%\' >\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n</tr>\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</td>\n</tr>\n</table>\n</td>\n\n<td>\n<table cellspacing=0 cellpadding=3 width=\'100%\' >\n<tr>\n<td class=\"label\"><B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n</tr>\n<tr>\n<td class=\"label\">\n</td>\n</tr>\n</table>\n</td>\n\n<td>\n<table cellspacing=0 cellpadding=3 width=\'100%\' >\n<tr>\n<td class=\"label\"><B>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></td>\n</tr>\n<tr>\n<td class=\"label\">\n</td>\n</tr>\n</table>\n</td>\n\t</tr>\n\n</table>\n<input type=hidden name=\"filterCodeValue\" id=\"filterCodeValue\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t   <table name=termSetSearchTable id=termSetSearchTable  cellspacing=0 cellpadding=8 width=\'100%\' align=center>\n\t\t\t\t  \n\t\t\t\t <tr>\n\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  \n\t\t\t\t\t\t</td>\n\t\t\t\t\t <td class=\"label\" align=\"right\">\n\t\t\t\t\t   <select name=\'filterLevelType\' id=\'filterLevelType\'  style=\"width:200\"> \n\t\t\t\t\t\t\t <option value=\'\' >---Select---</option>\n\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="                  \n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t</option>                    \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\n\t\t\t\t\t   </select>\n\t\t\t\t\t\t  </td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" align=\"right\"><INPUT TYPE=\"text\" name=\"filterLevelSubType\" id=\"filterLevelSubType\" > \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" align=\"right\"> Description\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" align=\"right\"><INPUT TYPE=\"text\" name=\"filterLevelSubTypeDesc\" id=\"filterLevelSubTypeDesc\" > \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<td class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"label\" align=\"center\">\n\n\t\t\t\t\t  <select name=\'filterLevelValue\' id=\'filterLevelValue\' id=\'filterLevelValue\' style=\"width:200\"> \n\t\t\t\t\t  <option value=\'\' >---Select---</option>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\n\t\t\t\t\t  </select>  \n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=7> </td>\n\t\t\t\t\t<td align=\"right\">\n\t\t\t\t\t   <input class=\'button\' type=\'button\'  name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onClick=\"searchFilterValues();\"> \n\t\t\t\t\t   <input class=\'button\' type=\'button\'  name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onClick=\"clearSearch();\"> \n      \t\t\t\t\t<input class=\'button\' type=\'button\'  name=\'clear\' id=\'clear\' value=\'PayTM\' onClick=\"PayTMTrans()\"> \n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t   </table> \n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<input type=hidden name=\"facility_id\" id=\"facility_id\" value=\'\' >\n \n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
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
            _bw.write(_wl_block5Bytes, _wl_block5);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection conn = null;
ResultSet rset = null; 
PreparedStatement pstmt = null ;  
 
try  
 {
 if(conn==null) conn = ConnectionManager.getConnection();

	String Fileter_group_code=request.getParameter("Filter_group_code");
	String filterLevelTypeName="";
	String filterLevelSubtypeName="";
	String elementCodeName="";

	 

     if("ENOTIFYFIL".equals(Fileter_group_code))
	 {
	 // Added by prithivi for enotification requirement on 11/05/2016
	 HashMap<String, TreeMap> resultMap = null;
	 TreeMap tretype = new TreeMap();
	 TreeMap treelement = new TreeMap();


	 FilteringAndQuerySearch querySearchObj = new FilteringAndQuerySearch();

	 resultMap=querySearchObj.getSelectBoxValues(Fileter_group_code);
	  
	 tretype = resultMap.get("TreeType");
	 treelement = resultMap.get("TreeElement");

	request.setAttribute("tretype",tretype);
	request.setAttribute("treelement",treelement);

	 }
 
// Added by prithivi for enotification requirement on 11/05/2016
 String sql="select B.LEVEL_NUMBER,A.APPLICATION_ID,A.FACILITY_ID,A.EVENT_TYPE,A.MESSAGE_TYPE,A.PROTOCOL_LINK,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE  AND rownum = 1 and A.FILTER_GROUP_CODE='"+Fileter_group_code+"' ORDER BY 1";

 /*select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME ,A.FACILITY_ID,A.APPLICATION_ID, A.EVENT_TYPE, A.PROTOCOL_LINK from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='ENOTIFYFIL' ORDER BY 1*/


 System.out.println(" ::: sql ::: ..."+sql);
 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();

 while(rset.next())
 {
   filterLevelTypeName=rset.getString(10).toString().trim();
   filterLevelSubtypeName=rset.getString(11).toString().trim();
   elementCodeName=rset.getString(12).toString().trim();

   System.out.println(" ::: filterLevelTypeName ::: ..."+filterLevelTypeName+" ..filterLevelSubtypeName.. "+filterLevelSubtypeName+" ..elementCodeName.."+elementCodeName);
   
  
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rset.getString(2).toString().trim()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rset.getString(4).toString().trim()));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rset.getString(3).toString().trim()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rset.getString(5).toString().trim()));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rset.getString(6).toString().trim()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Fileter_group_code ));
            _bw.write(_wl_block18Bytes, _wl_block18);

 }
 
 //Added by prithivi for enotification requirement on 11/05/2016
 System.out.println("FilteringAndSchedulingApplicationSearch.jsp::::filter group code...."+Fileter_group_code);
              if("ENOTIFYFIL".equals(Fileter_group_code))
			 {
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(filterLevelTypeName));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(filterLevelSubtypeName));
            _bw.write(_wl_block25Bytes, _wl_block25);

						if(elementCodeName!= null && elementCodeName.trim().indexOf("None")== -1)
						 {
							
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(elementCodeName));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

						 }
						
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
 
			 }
	}
 catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationLevel.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      } 
 finally
 {
	 if(conn != null) ConnectionManager.returnConnection(conn);
	 if(pstmt != null) pstmt.close();
	 if(rset != null) rset.close();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MessageType.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Gateway.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag5 = null ;
        int __result__tag5 = 0 ;
        boolean _skipPage__tag5= false;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${tretype}",java.lang.Object.class,pageContext,_jspx_fnmap));
        __tag5.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("subject1", java.lang.String .class,"var"));
        try {_activeTag=__tag5;
            __result__tag5 = __tag5.doStartTag();

            if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block21Bytes, _wl_block21);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${subject1.key}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block22Bytes, _wl_block22);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${subject1.value}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block23Bytes, _wl_block23);
                } while (__tag5.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag5 = true;
                return true;
            }
            _activeTag=__tag5.getParent();
            _skipPage__tag5 = false;
        } catch (java.lang.Throwable __t){
            __tag5.doCatch(__t);
        } finally {
            __tag5.doFinally();
            if (!_skipPage__tag5){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
                __tag5.release();
            }else{
                _releaseTags(pageContext, __tag5);
            }
        }
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag6 = null ;
        int __result__tag6 = 0 ;
        boolean _skipPage__tag6= false;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${treelement}",java.lang.Object.class,pageContext,_jspx_fnmap));
        __tag6.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("subject2", java.lang.String .class,"var"));
        try {_activeTag=__tag6;
            __result__tag6 = __tag6.doStartTag();

            if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block21Bytes, _wl_block21);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${subject2.key}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block22Bytes, _wl_block22);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${subject2.value}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block23Bytes, _wl_block23);
                } while (__tag6.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag6 = true;
                return true;
            }
            _activeTag=__tag6.getParent();
            _skipPage__tag6 = false;
        } catch (java.lang.Throwable __t){
            __tag6.doCatch(__t);
        } finally {
            __tag6.doFinally();
            if (!_skipPage__tag6){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
                __tag6.release();
            }else{
                _releaseTags(pageContext, __tag6);
            }
        }
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
