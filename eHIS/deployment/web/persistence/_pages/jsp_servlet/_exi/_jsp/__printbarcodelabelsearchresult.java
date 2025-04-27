package jsp_servlet._exi._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXI.*;
import eXI.XIDBAdapter;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __printbarcodelabelsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exi/jsp/PrintBarcodeLabelSearchResult.jsp", 1742897525636L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link href=\"../../eCA/Kendo/styles/kendo.common.min.css\" rel=\'stylesheet\' />\n<link href=\"../../eCA/Kendo/styles/kendo.blueopal.min.css\" rel=\'stylesheet\' />\n<link href=\"../../eCA/Kendo/styles/kendo.default.min.css\" rel=\'stylesheet\' />\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/common.js\" ></script>\n<script src=\"../../eCA/Kendo/js/jquery.min.js\"  type=\"text/javascript\"></script>\n<script src=\"../../eCA/Kendo/js/kendo.all.min.js\"  type=\"text/javascript\"></script>\t\n<script src=\"../../eCA/js/ES_Kendo.js\"  type=\"text/javascript\"></script>\n\n\n<script Language=\"Javascript\">\n\n\n/**** progress bar code ends ****/\n\n\nvar obj1;\nfunction setObject(object1)\n{\n  obj1=object1;\n  var current_row_id=obj1.getAttribute(\'current_row_id\');\n  document.forms[0].current_row_id.value=current_row_id;\n}\nfunction funAction(typ)\n{  \n\tparent.frames[2].ORGWSITEMSTATUS_RESULTS.action_type.value = typ;\n\tfunSubmit();\n}\nfunction funSubmit()\n{\n\tparent.frames[2].ORGWSITEMSTATUS_RESULTS.action = \'../../eXI/jsp/PrintBarcodeLabelSearchResult.jsp\';\n\tparent.frames[2].ORGWSITEMSTATUS_RESULTS.target=\"f_query_add_mod_detail\";\n\tparent.frames[2].ORGWSITEMSTATUS_RESULTS.submit();\n}\nfunction printQRcode(){\n\tif(obj1==null)\n\t{\n      alert(\"Select any record to print.\");\n\t  $(\"#print\").removeClass(\"k-state-disabled\");        \n\t  return false;\n\t}\n     var hideFeatures\t= \"toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10000, top=10000, width=4, height=4, visible=none \";\n\t var arguments\t= \"\" ;\n     var pb = $(\"#progressBar\").data(\"kendoProgressBar\");\n     pb.value(0);\n     clearInterval(100);\n\n\n\n    var current_row_id=obj1.getAttribute(\'current_row_id\');\n\tvar barcode_qty_eval = eval(\"document.forms[0].barcode_qty\"+current_row_id);\n\tvar barcode_qty_value = \"0\";\n\tif(barcode_qty_eval!=undefined)\n\t{\n      barcode_qty_value = barcode_qty_eval.value;\n\t}\n\t//alert(\"barcode_qty_value.....\"+barcode_qty_value);\n\tvar item_name = obj1.getAttribute(\'item_desc\');\n\tvar batch_id = obj1.getAttribute(\'batch_id\');\n\tvar expiry_date = obj1.getAttribute(\'expiry_date\');\n\tvar barcode_id = obj1.getAttribute(\'barcode_id\');\n\tvar item_code = obj1.getAttribute(\'item_code\');\n\tvar dataElements = \"itemname=\"+item_name+\"&batchid=\"+batch_id+\"&expdate=\"+expiry_date+\"&barcode_qty=\"+barcode_qty_value+\"&barcode_id=\"+barcode_id+\"&printQty=\"+barcode_qty_value+\"&item_code=\"+item_code;\n\tvar dialogHeight = \"4\";\t\t\t    \n\tvar dialogWidth  = \"4\";\n\tvar dialogTop    = \"300\";\n\tvar dialogLeft   = \"500\";\n\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\tvar url = \"../../eXH/jsp/XHBarcodePrinting.jsp?\" + dataElements;\n\t//parent.frames[3].document.location.href=\'../../eXH/jsp/XHBarcodePrinting.jsp?\'+ dataElements;\n    var ret = window.open(url,arguments, hideFeatures);\n    for(var i=0;i<barcode_qty_value;i++)\n\t{\n\t\tif (pb.value() < barcode_qty_value) {\n\t\t\tpb.value(pb.value() + 1);\t              \n\t\t} \n\t}\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"ORGWSITEMSTATUS_RESULTS\" id=\"ORGWSITEMSTATUS_RESULTS\" method=\"POST\" action=\'\'  >\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'\'>\n\n    <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'doc_type_code\' id=\'doc_type_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'his_grn_no\' id=\'his_grn_no\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t<input type=\'hidden\' name=\'sap_grn_no\' id=\'sap_grn_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'doc_date\' id=\'doc_date\' value=\'\'>\n\t<input type=\'hidden\' name=\'item_code\' id=\'item_code\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type=\'hidden\' name=\'item_desc value=\' id=\'item_desc value=\'\'>\n\t<input type=\'hidden\' name=\'batch_id\' id=\'batch_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'item_qty\' id=\'item_qty\' value=\'\'>\n\t<input type=\'hidden\' name=\'grn_item_qty\' id=\'grn_item_qty\' value=\'\'>\n\t<input type=\'hidden\' name=\'expiry_date\' id=\'expiry_date\' value=\'\'>\n\t<input type=\'hidden\' name=\'current_row_id\' id=\'current_row_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'barcode_id\' id=\'barcode_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'searchCriteria\' id=\'searchCriteria\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<script>\n//alert(\"APP-XI0021 Query caused no records to be retrived\");\nalert(getMessage(\'XH1021\',\'XH\'));\nparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\n</script>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<tr>\n\t<td colspan=\"10\" align=\"right\" class=\"CAGROUP\" > \n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</A>\n\t</td>\n\t</tr>\n\n<tr>\n\t<td class=\'COLUMNHEADER\'  width=\'8%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'10%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'25%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t<td class=\'COLUMNHEADER\'  width=\'10%\'>HIS GRN No</td> \n\t<td class=\'COLUMNHEADER\'  width=\'10%\'>SAP GRN No</td>\n\t<td class=\'COLUMNHEADER\'  width=\'10%\'>GRN DATE</td>\n\t<td class=\'COLUMNHEADER\'  width=\'15%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'30%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'30%\'>GRN QTY</td>\n\t<td class=\'COLUMNHEADER\'  width=\'25%\'>BARCODE QTY</td>\t\n</tr>\n\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t<tr>\n\t<td ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" align=\"left\"> \n\t<input id=item_sr_no type=radio name=item_sr_no id=item_sr_no value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onClick=\'setObject(this)\' current_row_id=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' facility_id=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' doc_type_code=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' doc_date=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' sap_grn_no=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' his_grn_no=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  item_code=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' item_desc=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' batch_id=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' grn_item_qty=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' expiry_date=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' barcode_id=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" align=\"left\"> \n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \n\t</td>\n\t<td ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t</td>\n\t<td\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" align=\"left\"> \n\t<input name=\"barcode_qty";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"barcode_qty";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" type=\'text\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t</td>\n\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n\t</table>\n\t<table width=\'100%\'>\n\t\t<tr align=\'right\'>\n          <td align=\'right\'> <img src=\"../../eCommon/images/Rprint.gif\"\n\t\t\t\t\t\talt=\"Print\" onClick=\"createProgressBar()\" name=\'print\' id=\'print\'\n\t\t\t \t\t\tonMouseOver=\"src=\'../../eCommon/images/RRprint.gif\'\"\n\t\t\t \t\t\tonMouseOut=\"src=\'../../eCommon/images/Rprint.gif\'\" style=\"align:right\"> </td>\n\t\t</tr>\n\t</table>\n\n\t<div class=\"demo-section\" id=\"demo\">\n\t        <div id=\"progressBar\"></div>        \n\t    </div>\n\n</form>\n\n<script>\n\n/**** progress bar code ****/\n\n$(\"#print\").click(function () {\n\t        if (!$(this).hasClass(\"k-state-disabled\")) {\n\t            $(this).addClass(\"k-state-disabled\");\n\t            printQRcode();            \n\t        }\n\t    });\n\t \t\n\t \tfunction createProgressBar() {\n\t\t\tvar current_row_id=document.forms[0].current_row_id.value;\n\t\t     if(current_row_id==null || current_row_id==\"\")\n\t\t\t{\n                return false;\n\t\t\t}\t\n\t\t\tvar barcode_qty_eval = eval(\"document.forms[0].barcode_qty\"+current_row_id);\n\t\t\tvar barcode_qty_value = \"0\";\n\t\t\tif(barcode_qty_eval!=undefined)\n\t\t\t{\n\t\t\t  barcode_qty_value = barcode_qty_eval.value;\n\t\t\t}\n\t \t\tvar pb = $(\"#progressBar\").data(\"kendoProgressBar\");\n\n\t \t\tif (pb != null ){\t\t\t\t\n\t\t\t\t$(\"#progressBar\").data(\"kendoProgressBar\").destroy();\n\t\t\t\t$(\"#demo\").empty().append(\"<div id=\'progressBar\'></div>\");\t\t\t\t\n\t\t\t}\n\t\t\t$(\"#progressBar\").kendoProgressBar({\n\t            min: 0,\n\t            max: barcode_qty_value,\n\t            type: \"percent\",\n\t            change: onChange,\n\t            complete: onComplete,\n\t            enable: false\n\n\t        });\n\t\t\t\n\t\t}\t\n\n\t    function onChange(e) {\n\t        \n\t    }\n\n\t    function onComplete(e) {\n\t\t\talert(\"Process Completed\");\n\t        $(\"#print\").removeClass(\"k-state-disabled\");        \n\t    }\n\n</script>\n\n<style scoped>\n        #progressBar {\n        \tmargin-top: 10px;\n            width: 440px;\n            margin-bottom: 10px;\n        }  \n        .demo-section {\n            width: 100%;\n            text-align: center;\n        }\n              \n</style> \n\n\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
										 
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "PRINTITEMBARCODE";

			String item_code = "";
            String grn_num = "";

            String status = "";
			String searchCriteria = "GRN";
			Connection conn = null;
			String whereClause = "";
			String orderByColumns="";

			String sap_num = "";
			String facility_id = "";
			String grn_from_date = "";
            String grn_to_date = "";
			String grn_sort_by = "";
			String grn_sort_order = "";

			try
			{
				grn_num=XIDBAdapter.checkNull(request.getParameter("grn_num"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_num : "+grn_num);
				item_code=XIDBAdapter.checkNull(request.getParameter("item_code"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: item_code : "+item_code);
				searchCriteria=XIDBAdapter.checkNull(request.getParameter("searchCriteria"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: searchCriteria : "+searchCriteria);

				sap_num=XIDBAdapter.checkNull(request.getParameter("sap_num"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: sap_num : "+sap_num);

				facility_id=XIDBAdapter.checkNull(request.getParameter("facility_id"));
					System.out.println("PrintBarcodeLabelSearchResult.jsp:::: facility_id : "+facility_id);
				
				grn_from_date=XIDBAdapter.checkNull(request.getParameter("grn_from_date"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_from_date : "+grn_from_date);

				grn_to_date=XIDBAdapter.checkNull(request.getParameter("grn_to_date"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_to_date : "+grn_to_date);
						
				grn_sort_by=XIDBAdapter.checkNull(request.getParameter("grn_sort_by"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_sort_by : "+grn_sort_by);

				grn_sort_order=XIDBAdapter.checkNull(request.getParameter("grn_sort_order"));
							 System.out.println("PrintBarcodeLabelSearchResult.jsp:::: grn_sort_order : "+grn_sort_order);
				
				if(searchCriteria!=null && searchCriteria.equals("ITEMCODE"))
				{
                    qry_id = "PRINTBARCODEITEMBASED";
				}
				else
				{
                    qry_id = "PRINTITEMBARCODE";
				}
                 
				/* whereClause = " where a.ITEM_CODE = b.ITEM_CODE and a.ITEM_CODE = c.ITEM_CODE and a.BATCH_ID = c.BATCH_ID and a.store_code = c.store_code and a.bin_location_code = c.bin_location_code and to_date(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') = to_date(A.EXPIRY_DATE,'DD/MM/YYYY') and c.QTY_ON_HAND > 0"; */

				whereClause = " WHERE a.ITEM_CODE=b.ITEM_CODE  ";
				
				
				/* and c.QTY_ON_HAND > 0 Condition has been removed for the SCF GHL-SCF-1288 by Sethu on 01/02/2018. */ 

				/* Facility ID Condition has been added for the SCF GHL-SCF-1288.1 by Sethu on 04/05/2018. */

				if(facility_id!="" && facility_id!=null) 
				{
				   whereClause=whereClause+" AND a.FACILITY_ID='"+facility_id+"'";
				}


				if(sap_num!="" && sap_num!=null)
				{
				   whereClause=whereClause+" AND a.DOC_REF=NVL('"+sap_num+"',a.DOC_REF)";
				}


				if(grn_num!="" && grn_num!=null)
				{
				   whereClause=whereClause+" AND a.IBA_DOC_NUM=NVL('"+grn_num+"',a.IBA_DOC_NUM)";
				   
				}
				
				if(item_code!="" && item_code!=null)
				{
				   whereClause=whereClause+" AND a.ITEM_CODE=NVL('"+item_code+"',a.ITEM_CODE)";
				   
				}

				if((grn_from_date!="" && grn_from_date!=null) && (grn_to_date!="" && grn_to_date!=null))
				{
				   whereClause=whereClause+" AND a.DOC_DATE BETWEEN TO_DATE('"+grn_from_date+"','DD/MM/YYYY') AND TO_DATE('"+grn_to_date+"','DD/MM/YYYY')";
				  
				}

				if(grn_sort_by!="" && grn_sort_order!=null)
				{
					orderByColumns = " ORDER BY a."+grn_sort_by;
				}
				
				if(grn_sort_order!="" && grn_sort_order!=null)
				{
					if(grn_sort_order.equals("A")){
						//orderByColumns=orderByColumns.substring(0,orderByColumns.length()-1);
						orderByColumns=orderByColumns+" ASC";
					}
					else{
						//orderByColumns=orderByColumns.substring(0,orderByColumns.length()-1);
						orderByColumns=orderByColumns+" DESC";
					}

				}

                System.out.println("PrintBarcodeLabelSearchResult.jsp:::: whereClause : "+whereClause);
				System.out.println("PrintBarcodeLabelSearchResult.jsp:::: orderByColumns : "+orderByColumns);
				request.setAttribute(XIQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XIQueryRender.col,"12");
				request.setAttribute(XHQueryRender.maxRec,"8");
			    request.setAttribute(XHQueryRender.whereClause,whereClause);
				request.setAttribute(XHQueryRender.orderByColumns,orderByColumns);
				conn = ConnectionManager.getConnection(request);				
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
					strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				}
				else
				{
					strNext  = " ";
				}
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(grn_num ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(item_code ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(searchCriteria));
            _bw.write(_wl_block11Bytes, _wl_block11);

if(arrRow.size()==0)
{

            _bw.write(_wl_block12Bytes, _wl_block12);
 } else { 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strPrevious ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strNext ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		System.out.println("arrRow.size()......"+arrRow.size());
	int i=1;
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(arrCol.get(3)+""));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(arrCol.get(4)+""));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(arrCol.get(5)+""));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(arrCol.get(7)+""));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(arrCol.get(8)+""));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(arrCol.get(9)+""));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(10)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(arrCol.get(11)+""));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j+1 ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(6) ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(7) ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(5) ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(4) ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(3) ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(8) ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(10) ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(""+arrCol.get(9) ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrCol.get(9)));
            _bw.write(_wl_block43Bytes, _wl_block43);

		i++;
	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		e1.printStackTrace();
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Batch.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Expiry.label", java.lang.String .class,"key"));
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
