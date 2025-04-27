package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.model.BillReceiptPackageInfo;
import java.util.List;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.request.BillReceiptRequest;

public final class __billreceiptpkgclosure extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptPkgClosure.jsp", 1742746091257L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Open Subscribed Packages</title>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\'javascript\' src=\'../../eBL/js/BillReceipt.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\t$(document).ready(function(){\n\t\tvar confirmBox=\'\';\n\t\tvar pkgSeqNo = \'\';\n\t\tvar packageCode=\'\';\n\t\tvar noOfDecimal=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =";\n\t\t$(\'#close\').click(function(){\n\t\t\t\n\t\t\tvar totalCount = $(\'#totalCount\').val();\n\t\t\tvar dataParams = \'calledFrom=PackageClosure&totalCount=\'+totalCount+\n\t\t\t\t\t\t\t\'&patientId=\'+$(\'#patientId\').val()+\n\t\t\t\t\t\t\t\'&episodeType=\'+$(\'#episodeType\').val()+\n\t\t\t\t\t\t\t\'&episodeId=\'+$(\'#episodeId\').val()+\n\t\t\t\t\t\t\t\'&visitId=\'+$(\'#visitId\').val();\n\t\t\tfor(var i=1; i<=totalCount; i++){\n\t\t\t\tdataParams += \'&packageSeqNo\'+i+\'=\'+$.trim($(\'#seqNo\'+i).text())+\n\t\t\t\t\t\t\t\'&packageCode\'+i+\'=\'+$.trim($(\'#packageCode\'+i).text());\n\t\t\t\t\n\t\t\t\tpkgSeqNo =pkgSeqNo+\',\'+$.trim($(\'#seqNo\'+i).text());\n\t\t\t\t\n\t\t\t\tpackageCode =packageCode+\',\'+$.trim($(\'#packageCode\'+i).text());\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\tif($(\'#totalGroup\').val()==0){\n\t\t\t\t confirmBox =window.confirm(getMessage(\'BL00961\',\'BL\'));\n\t\t\t\t if(confirmBox){\n\t\t\t\t\t\n\t\t\t$.ajax({\n\t\t\t\ttype:\"GET\",\n\t\t\t\turl:\"../jsp/BillReceiptAjax.jsp\",\n\t\t\t\tdata:dataParams,\n\t\t\t\tdataType:\"json\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\tif(data.success==\'Y\'){\t\n\t\t\t\t\t\t//window.returnValue = totalCount+\"::\"+pkgSeqNo+\"::\"+packageCode;\n\t\t\t\t\t\t//window.close();\n\t\t\t\t\t\tparent.document.querySelectorAll(\"#dialog-body\")[parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = totalCount+\"::\"+pkgSeqNo+\"::\"+packageCode;\n\t\t\t\t\tparent.document.querySelectorAll(\"#dialog_tag\")[parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\talert($.trim(data.error));\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\t error: function(data){\n\t\t\t\t\t alert(data)\n\t\t\t      }\n\t\t\t});\n\t\t\t}\n\t\t\t\t else{\n\t\t\t\t\t /*  window.returnValue=\"N\";\n\t\t\t\t\t window.close(); */\n\t\t\t\t\t \n\t\t\tparent.document.querySelectorAll(\"#dialog-body\")[parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = \"N\";\n\t\t\t\t\t\tparent.document.querySelectorAll(\"#dialog_tag\")[parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t\t\t\t\t \n\t\t\t\t }\n\t\t\t}\n\t\t\telse{\n\t\t\t\t/* window.returnValue = totalCount+\"::\"+pkgSeqNo+\"::\"+packageCode;\n\t\t\t\twindow.close(); */\n\t\t\t\t\n\t\t\t\tparent.document.querySelectorAll(\"#dialog-body\")[parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = totalCount+\"::\"+pkgSeqNo+\"::\"+packageCode;\n\t\t\t\tparent.document.querySelectorAll(\"#dialog_tag\")[parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'#cancel\').click(function(){\n\t\t\t/* window.returnValue=\"N\";\n\t\t\twindow.close(); */\n\t\t\t\n\t\t\tparent.document.querySelectorAll(\"#dialog-body\")[parent.parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = \"N\";\n\t\t\tparent.document.querySelectorAll(\"#dialog_tag\")[parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t\t});\n\t\t$(\'[id^=pkg_amt]\').each(function(){\n\t\t\t\n\t\t\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\t\t\n\t\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t$(this).text(\'0\');\n\t\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t$(\'[id^=avail_amt]\').each(function(){\n\t\t\t\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\n\t\t\t}\n\t\t});\n\t\t$(\'[id^=deposit_amt]\').each(function(){\n\t\t\t\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\n\t\t\t}\n\t\t});\n\t});\n</script>\n</head>\n<body>\n\t<br/>\n\t<br/>\n\t<form id=\'pkgClosureFrm\'>\n\t<table class=\'grid\' border=\'1\' width=\'100%\' align=\"centre\" cellpadding=\'2\'  cellspacing=0 >\t\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' width=\"5%\" align=\"left\">Select</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" align=\"left\">Episode Type</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" align=\"left\">Episode Id</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" align=\"left\">Visit Id</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" align=\"left\">Package Code</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" align=\"left\">Package Description</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" align=\"left\">Package Seq No</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" align=\"left\">Package Amount</td>\t\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" align=\"left\">Availed Amount</td>\t\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" align=\"left\">Deposit Amount</td>\t\t\t\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<tr>\t\t\n\t\t\t<td class=\'LABEL\'>\n\t\t\t\t<input type=\'checkbox\' checked name=\'pkgSelect";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' id=\'pkgSelect";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onclick=\"checkAlways(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\">\n\t\t\t</td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td class=\'LABEL\' id=\'episodeType";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\' id=\'episodeId";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\'LABEL\' id=\'visitId";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</td>\t\n\t\t\t\n\t\t<td class=\'LABEL\' id=\'packageCode";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</td>\n\t\t\n\t\t<td class=\'LABEL\' >\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'seqNo";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'pkg_amt";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' style=\"text-align: right;\" style=\"white-space: nowrap\">\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'avail_amt";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</td>\n\t\t\n\t\t<td class=\'LABEL\' id=\'deposit_amt";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' style=\"text-align: right;\" style=\"white-space: nowrap\">\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t&nbsp;\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</td>\t\t\t\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t</table>\n\t\t<br/>\n\t\t<br/>\n\t\t<table width=\'100%\'  cellpadding=\'0\'  cellspacing=0 >\n\t\t<tr>\n\t\t\t<td class=\'LABEL\' width=\"60%\" colspan=\"8\">\n\t\t\t\tOpen Subscribed Packages are available for the Patient. Do you want to Close?\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\'button\' class=\'button\' name=\'close\' id=\'close\' id=\'close\' value=\'Yes\' >\n\t\t\t</td>\n\t\t\t<td width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<input type=\'button\' class=\'button\' name=\'cancel\' id=\'cancel\' id=\'cancel\' value=\'No\' disabled>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<input type=\'button\' class=\'button\' name=\'cancel\' id=\'cancel\' id=\'cancel\' value=\'No\' >\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</td>\n\t\t</tr>\t\t\n\t</table>\n\t<input type=\'hidden\' id=\'totalCount\' name=\'totalCount\' id=\'totalCount\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type=\'hidden\' id=\'patientId\' name=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=\'hidden\' id=\'episodeType\' name=\'episodeType\' id=\'episodeType\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=\'hidden\' id=\'episodeId\' name=\'episodeId\' id=\'episodeId\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t<input type=\'hidden\' id=\'visitId\' name=\'visitId\' id=\'visitId\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type=\'hidden\' id=\'totalGroup\' name=\'totalGroup\' id=\'totalGroup\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
	
	String patientId = replaceNull(request.getParameter("patient_id"));
	String episodeType = replaceNull(request.getParameter("episode_type"));
	String episodeId = replaceNull(request.getParameter("episode_id"));
	String visitId = replaceNull(request.getParameter("visit_id"));
	String totalGroup = replaceNull(request.getParameter("totalGroup"));
	String facilityId = (String) session.getValue("facility_id");
	String locale = (String) session.getValue("LOCALE");
	String noOfDecimal = replaceNull(request.getParameter("noOfDecimal"));
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setEpisodeType(episodeType);
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLocale(locale);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptPackageInfo>  pkgInfoList = billReceiptBC.getPackageClosureDtls(billRequest);

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(noOfDecimal));
            _bw.write(_wl_block5Bytes, _wl_block5);

		int indx = 0;
		String episode_type="";
		String pkgInfoCloseYn = "";
		for(BillReceiptPackageInfo pkgInfo:pkgInfoList){ 
			indx++;
			pkgInfoCloseYn = pkgInfo.getPkgCloseYn();
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block9Bytes, _wl_block9);
if("O".equals(replaceNull(episodeType))){
		episode_type="Outpatient";
		}
		else if("I".equals(replaceNull(episodeType))){
			episode_type="Inpatient";
		}
		else if("D".equals(replaceNull(episodeType))){
			episode_type="Daycare";
		}
		else if("E".equals(replaceNull(episodeType))){
			episode_type="Emergency";
		}
		else if("R".equals(replaceNull(episodeType))){
			episode_type="External";
		}
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block14Bytes, _wl_block14);
if("".equals(replaceNull(visitId))){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(replaceNull(visitId) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
} 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pkgInfo.getPackageCode() ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pkgInfo.getPackageDesc() ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pkgInfo.getPkgSeqNo() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(replaceNull(pkgInfo.getPackageAmt()) ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(replaceNull(pkgInfo.getUtilized()) ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block24Bytes, _wl_block24);
if("".equals(pkgInfo.getDepositAmt())){ 
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{ 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(replaceNull(pkgInfo.getDepositAmt())));
            _bw.write(_wl_block26Bytes, _wl_block26);
} 
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
if("N".equals(pkgInfoCloseYn)){
            _bw.write(_wl_block29Bytes, _wl_block29);
	} else{	
            _bw.write(_wl_block30Bytes, _wl_block30);
} 
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(visitId ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalGroup ));
            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
