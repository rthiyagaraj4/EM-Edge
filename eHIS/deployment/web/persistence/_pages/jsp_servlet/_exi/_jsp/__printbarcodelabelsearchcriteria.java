package jsp_servlet._exi._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eST.*;
import eST.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __printbarcodelabelsearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exi/jsp/PrintBarcodeLabelSearchCriteria.jsp", 1710229024538L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n<script language=\"javascript\">\n\n</script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXI/js/Validate.js\" ></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\'javascript\' src=\'../../eXI/js/ViewGRNS.js\'></script>\n<script language=\"JavaScript\">\n\nfunction searchGRN(){\n     \n\t\t\tvar tdesc=\"\";\n            var tcode=\"\";\n\n            var retVal =new String();\n            var argumentArray  = new Array() ;\n            var dataNameArray  = new Array() ;\n            var dataValueArray = new Array() ;\n            var dataTypeArray  = new Array() ;\n            var tit= getLabel(\"eST.GRN.label\",\"ST\");\t\t\t\n            var target=this.document.forms[0].grn_num;\n            var sap_num=this.document.forms[0].sap_num;\n\t\t\tvar supp_name=this.document.forms[0].supplier;\n\t\t\tvar grn_num_1=this.document.forms[0].grn_num_1; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018 Added.\n\n\t\t\tvar facility_id=this.document.forms[0].facility_id.value; // Added by Sethu for GHL-SCF-1288.1 on 08/05/2018\n\t\t\t\n\t\t    sql=\"SELECT DISTINCT IBA_DOC_NUM code,DOC_REF description FROM xi_trn_grn WHERE  FACILITY_ID = \'\"+facility_id+\"\' and UPPER(IBA_DOC_NUM) LIKE UPPER(?) AND UPPER(DOC_REF) LIKE UPPER(?) ORDER BY 1 \";\n\n            argumentArray[0] = sql;\n            argumentArray[1] = dataNameArray ;\n            argumentArray[2] = dataValueArray ;\n            argumentArray[3] = dataTypeArray ;\n//            argumentArray[4] = \"2,1\";\n\t\t    argumentArray[4] = \"1,2\";\n            argumentArray[5] = target.value;\n            argumentArray[6] = DESC_LINK  ;\n            argumentArray[7] = DESC_CODE ;\n\n            retVal = await CommonLookup( tit, argumentArray );\n\n            if(retVal != null && retVal != \"\" ){\n\t            var ret1=unescape(retVal);\n                arr=ret1.split(\",\");\n                sap_num.value=arr[1];\n\t\t\t\tgrn_num_1.value=arr[0]; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018\n                target.value=arr[1];// arr[0] Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018\n\t\t\t\tvar sup=getSupplierName(arr[0]); // target.value Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018\n\t\t\t\tif(sup!=undefined && sup!=null)\n\t\t\t\t{\n\t\t\t\t\tsupp_name.value=sup;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n                   supp_name.value=\"\";\n\t\t\t\t}\n\t\t\t\t\n            }\n            else{\n                target.value=tcode; // tdesc Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018\n\t\t\t\tgrn_num_1.value=tdesc; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018\n                sap_num.value=tcode;\n\t\t\t\tsupp_name.value=\"\";\n            }\n\t\t\t\n}// End of searchGRN\n\n\nfunction searchItemCode(){\n     \n\t\t\tvar tdesc=\"\";\n            var tcode=\"\";\n\n            var retVal =new String();\n            var argumentArray  = new Array() ;\n            var dataNameArray  = new Array() ;\n            var dataValueArray = new Array() ;\n            var dataTypeArray  = new Array() ;\n            var tit= getLabel(\"Common.ItemCode.label\",\"Common\");\t\t\t\n            var target=this.document.forms[0].item_code_desc;\n            var item_code=this.document.forms[0].item_code;\n\t\t\t\n\t\t    sql=\"SELECT ITEM_CODE code,SHORT_DESC description FROM mm_item WHERE  UPPER(ITEM_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 \";\n\t\t\t\n            argumentArray[0] = sql;\n            argumentArray[1] = dataNameArray ;\n            argumentArray[2] = dataValueArray ;\n            argumentArray[3] = dataTypeArray ;\n//            argumentArray[4] = \"2,1\";\n\t\t    argumentArray[4] = \"1,2\";\n            argumentArray[5] = target.value;\n            argumentArray[6] = DESC_LINK  ;\n            argumentArray[7] = DESC_CODE ;\n\n            retVal = await CommonLookup( tit, argumentArray );\n\n            if(retVal != null && retVal != \"\" ){\n\t            var ret1=unescape(retVal);\n                arr=ret1.split(\",\");\n                item_code.value=arr[0];\n                target.value=arr[1];\n            }\n            else{\n                target.value=tdesc;\n                item_code.value=tcode;\n            }\n}// End of searchItemCode\n\nfunction getSupplierName(hisGrnNum) {\n\tvar responseText=\"\";\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr += \" iba_doc_num=\\\"\"+hisGrnNum+\"\\\"\";   \t\t  \n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\t\n\t\txmlHttp.open(\"POST\",\"XIUtil.jsp?func_mode=getSupplierName\",false);\t\t   \n\t\txmlHttp.send(xmlDoc);\t\t\n\t\tresponseText = trimString(xmlHttp.responseText);\n\t\t//alert(responseText);\n\t\treturn responseText;\n}\nfunction checkDate() {\n   var selectedText = document.getElementById(\'datepicker\').value;\n   var selectedDate = new Date(selectedText);\n   var now = new Date();\n   if (selectedDate < now) {\n    alert(\"Date must be in the future\");\n   }\n }\nfunction compare(date1,date2) \n{\n\t\tvar fromarray;\n \t\tvar toarray;\n \t\tvar frmdat = date1;\n\t\tvar todat=date2;\n\t\tvar d =  new Date(); \n\t\tfromarray =frmdat.split(\"/\");\n\t\ttoarray=todat.split(\"/\");\n\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\t\n     \n\t\n\t\t if((frmdat.length > 0) &&(todat.length>0))\n\t\t {\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt))\n\t\t\t{\n\t\t\t\talert(getMessage(\"XH1009\",\"XH\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse \n\t\t\t\tif(Date.parse(todt) >= Date.parse(fromdt)) \n\t\t\t\treturn true;\n\t\t }\t\n\t\t else return true;\n\t\t      \n\t\t\t\n}\nfunction getResults()\n{\n\tvar grn_num=document.forms[0].grn_num_1.value; //grn_num Changed by Sethu for GHL-SCF-1288.1 on 04/05/2018\n\tvar item_code=document.forms[0].item_code.value; \n\tvar facility_id=document.forms[0].facility_id.value; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018\n\tvar sap_num=document.forms[0].sap_num.value; // Added by Sethu for GHL-SCF-1288.1 on 04/05/2018\n\tvar grn_from_date=document.forms[0].grn_from_date.value; // Added by Apoorva for GHL-SCF-1288.1 on 11/02/2020\n\tvar grn_to_date=document.forms[0].grn_to_date.value; // Added by Apoorva for GHL-CRF-610 on 11/02/2020\n\tvar grn_sort_by=document.forms[0].grn_sort_by.value; // Added by Apoorva for GHL-CRF-610 on 11/02/2020\n\tvar grn_sort_order=document.forms[0].grn_sort_order.value; // Added by Apoorva for GHL-CRF-610 on 11/02/2020\n\tvar grn_from = new Date(grn_from_date);\n\tvar grn_to = new Date(grn_to_date);\n\n\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\n\tvar checkdate = true;\n\tif(grn_from_date != 0 && grn_to_date != 0){\n\t\tcheckdate = false;\n\t\tcheckdate = compare(grn_from_date,grn_to_date);\n\t}\n\telse if(grn_from_date != 0 && grn_to_date == 0){\n\t\tcheckdate = false;\n\t\talert(\"Please Enter GRN To Date\");\n\n\t}\n\telse if(grn_to_date != 0 && grn_from_date == 0){\n\t\tcheckdate = false;\n\t\talert(\"Please Enter GRN From Date\");\n\t}\n\t\n\tif (checkdate)\n\t{\n\t\tparent.frames[2].document.location.href=\'../../eXI/jsp/PrintBarcodeLabelSearchResult.jsp?grn_num=\'+grn_num+\'&item_code=\'+item_code+\'&facility_id=\'+facility_id+\'&sap_num=\'+sap_num+\'&grn_from_date=\'+grn_from_date+\'&grn_to_date=\'+grn_to_date+\'&grn_sort_by=\'+grn_sort_by+\'&grn_sort_order=\'+grn_sort_order;\n\t}\n}\n\nfunction clear22()\n{\n\tparent.f_query_add_mod.location.reload();\n\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n}\n\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\n<form name=\"printbarcodelabel_form\" id=\"printbarcodelabel_form\" target=\'f_query_add_mod_detail\' method=\'post\' >\n\n\n<fieldset style=\" border-color:grey;\">\n<table width=\"100%\">\n\t<tr >\n\t\t<td class=\"LABEL\" nowrap align=\'left\' width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<input type=\'text\' name=\'grn_num\' id=\'grn_num\' value=\'\' size=\'20\' onBlur=\"searchGRN()\">\n\t\t\t<input type=\'hidden\' name=\'sap_num\' id=\'sap_num\' value=\'\' >\n\t\t\t<input type=\'hidden\' name=\'grn_num_1\' id=\'grn_num_1\' value=\'\' >\n\t\t\t<input class=\"BUTTON\" type=\"button\"  name=grn_search value=\'?\'  onClick=\"searchGRN()\" >\n\t\t</td>\t\t\n\t\t<td class=\"LABEL\" nowrap align=\'left\' width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;\n\t\t\t<input type=\'text\' name=\'supplier\' id=\'supplier\' value=\'\' size=\'20\' readonly disabled>\n\t\t</td>\n\t\n\t\t<td class=\"LABEL\" nowrap align=\'left\'  width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<input type=\'text\' name=\'item_code_desc\' id=\'item_code_desc\' value=\'\' size=\'20\' onBlur=\"searchItemCode()\">\n\t\t\t<input type=\'hidden\' name=\'item_code\' id=\'item_code\' value=\'\'>\n\t\t\t<input class=\"BUTTON\" type=\"button\"  name=itemCode_search value=\'?\' onClick=\"searchItemCode()\" >\n\t\t</td>\n\t\t\n\t</tr>\n\t\n\t<tr>\n\t\t<td class=\"LABEL\" nowrap align=\'left\' width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t&nbsp;\n\t\t\t<input type=\'text\' name=\'grn_from_date\' id=\'grn_from_date\' value=\'13/02/2020\' size=\'10\' maxLength=\'10\' onKeyPress=\"return AllowDateFormat()\" onBlur=\"CheckValidDate(this);checkWithSysDate(this);checkDateRange(this,to_date_time);\">\n\t\t\t<input type=\'image\' id=\"frcal\" name=\"frcal\" id=\"frcal\" src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'grn_from_date\');\">\n\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t&nbsp;\n\t\t\t<input type=\'text\' name=\'grn_to_date\' id=\'grn_to_date\' \" value=\'13/02/2020\' size=\'10\' maxLength=\'10\' onKeyPress=\"return AllowDateFormat()\" onBlur=\"CheckValidDate(this);checkWithSysDate(this);checkDateRange(from_date_time,this);\">\n\t\t\t<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'grn_to_date\');\">\n\t\t</td>\n\t\t<td class=\"LABEL\" nowrap align=\'left\' width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t&nbsp; \n\t\t\t<select name=\'grn_sort_by\' id=\'grn_sort_by\'>\n\t\t\t\t<option value=\"DOC_DATE\">GRN Date</option>\n\t\t\t\t<option value=\"IBA_DOC_NUM\">GRN</option>\n\t\t\t\t<option value=\"ITEM_CODE\">Item Code</option>\n\t\t\t</select>\n\t\t\t&nbsp; \n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t&nbsp;\n\t\t\t<select name=\'grn_sort_order\' id=\'grn_sort_order\'>\n\t\t\t\t<option value=\"A\">Ascending</option>\n\t\t\t\t<option value=\"D\">Descending</option>\n\t\t\t</select>\n\t\t</td>\n\t\t<td  width=\'10%\'>&nbsp;&nbsp;&nbsp;&nbsp; </td>\n\t</tr>\n\t<tr>\t\n\t\t<td  width=\'10%\'>&nbsp;&nbsp;&nbsp;&nbsp; </td>\n\t\t<td  width=\'10%\'>&nbsp;&nbsp;&nbsp;&nbsp; </td>\n\t\t<td  width=\'10%\' align=\"right\"> \n\t\t\t\t<input class=\"button\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onClick=\"getResults()\" type=\"button\" >\n\t\t\t\t<input class=\"button\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onClick=\"clear22()\" type=\"button\" >\n\t\t</td>\t\n\t</tr>\n\t\n</table>\n</fieldset>\n\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'st_date\' id=\'st_date\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n</form>\n</BODY>\n</HTML> \n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 // String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block6Bytes, _wl_block6);
											 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//	System.out.println("p_facility_id : "+p_facility_id);
String selected = "";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


String mode			= "";
String item_code	= "";
String item_desc	= "";
String status			= "";
String strStDate = "", strEndDate = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try 
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') STDATE,TO_CHAR(SYSDATE,'DD/MM/YYYY') EDDATE FROM DUAL");
	rs = pstmt.executeQuery();
	if (rs != null && rs.next()) 
	{
		strStDate = rs.getString(1);
		strEndDate = rs.getString(2);
	}
} 
catch (Exception e1) 
{
	e1.printStackTrace(System.err);
	System.out.println(" Error in Criteria Page " + e1.getMessage());
} 
finally 
{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (con != null) ConnectionManager.returnConnection(con, request);
}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strEndDate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strStDate));
            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.GRN.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Supplier.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GRNFromDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GRNToDate.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Sortby.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SortOrder.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
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
