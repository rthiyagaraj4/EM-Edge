package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcheckeligibilitylevel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCheckEligibilityLevel.jsp", 1742750093862L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t<script>\n\tvar radioval = \'H\';\n\t$(document).ready(function(){\n\tif($(\'#defaultRequest\').val()==\'H\'){\n\t$(\'input:radio[name=bed_request]\')[1].checked = true;\n\tradioval = \'H\';\n\tdispReq();\n\t}\n\t});\n\n\tfunction storeVal(obj)\n\t{\n\t\tradioval = eval(obj).value;\n\t}\n\tfunction dispReq()\n\t{\n\tif(radioval == \'P\')\n\t{\n\t\tdocument.getElementById(\'dispNameOnReq\').innerText = \"\";\n\t\tdocument.getElementById(\'dispFieldOnReq\').innerHTML = \"<input type=\'hidden\' name=\'BedTypeCode\' id=\'BedTypeCode\' value=\'\'>\";\n\t}\n\telse if(radioval == \'H\')\n\t{\n\t\t//Added for authorization\n\t\tvar retVal;\n\t\tvar dialogHeight= \"9\" ;\n\t\tvar dialogWidth\t= \"22\" ;\n\t\tvar dialogTop = \"225\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\n\t\tvar arguments\t= \"\" ;\n\t\tvar tit\t= getLabel(\"eBL.AUTH_SCREEN.label\",\"BL\");\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBedTypeAuthMain.jsp?title=\"+tit,arguments,features);\n\n\t\tif(retVal==\'1\')\n\t\t{\n\t\t\tdocument.getElementById(\'dispNameOnReq\').innerText = getLabel(\"eBL.BED_TYPE_FOR_CHARGING_BASIS.label\",\"BL\");\n\t\t\tdocument.getElementById(\'dispFieldOnReq\').innerHTML = \"<select name=\'BedTypeCode\' id=\'BedTypeCode\'><option value=\'--select--\' selected>------\"+getLabel(\'Common.defaultSelect.label\',\'COMMON\')+\" ------</option>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</select>\";\n\t\t}\n\t\tif(retVal==\'0\')\n\t\t{\n\t\t\tdocument.getElementById(\'dispNameOnReq\').innerText = \"\";\n\t\t\tdocument.getElementById(\'dispFieldOnReq\').innerHTML = \"<input type=\'hidden\' name=\'BedTypeCode\' id=\'BedTypeCode\' value=\'\'>\";\n\t\t\tdocument.getElementById(\"bed_request\")[0].checked = true;\n\t\t}\n\t\tif(retVal!=\'0\' && retVal!=\'1\')\n\t\t{\n\t\t\tdocument.getElementById(\'dispNameOnReq\').innerText = \"\";\n\t\t\tdocument.getElementById(\'dispFieldOnReq\').innerHTML = \"<input type=\'hidden\' name=\'BedTypeCode\' id=\'BedTypeCode\' value=\'\'>\";\n\t\t\tdocument.getElementById(\"bed_request\")[0].checked = true;\n\t\t}\n\t\t}\n\t}\n\n\tfunction validate(obj)\n\t{\n\t\tif(eval(obj).name == \'OK\')\n\t\t{\t\n\t\tif(document.forms[0].BedTypeCode.value != null || document.forms[0].BedTypeCode.value != \'\' )\n\t\t{\tif(document.forms[0].BedTypeCode.value == \'--select--\')\n\t\t{\talert(getMessage(\"NO_SELECTION\",\"IP\"));\n\t\treturn false;\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\t/*Modified by Rajesh V for ML-MMOH-CRF-0866 & AMRI-CRF-0362 for PAS Team*/\n\t\t\tvar modified_bed_type = document.forms[0].BedTypeCode.value;\n\t\t\tvar modified_reqt_Rmks = document.forms[0].reqt_Rmks.value;\t\t\t\t\t\t\n\t\t\tvar returnArray = new Array();\n\t\t\treturnArray[0] = modified_bed_type;\n\t\t\treturnArray[1] = $(\'input:radio[name=bed_request]:checked\').val();\n\t\t\treturnArray[2] =modified_reqt_Rmks;\n\t\t\tparent.document.getElementById(\'dialog-body\').contentWindow.returnValue =returnArray;\n\t\t\tparent.document.getElementById(\'dialog_tag\').close();\n\t\t}\n\t\t}\t\t\t\t\n\t\t}\n\t\telse if(eval(obj).name == \'CANCEL\')\n\t\t{\n\t\t\tparent.document.getElementById(\'dialog-body\').contentWindow.returnValue=\'close\';\n\t\t\tparent.document.getElementById(\'dialog_tag\').close();\n\t\t}\n\t}\n\n\t//AMRI-CRF-0362 Starts\n\tfunction textAreaLimit(field, maxlen) {\n\t\tif (field.value.length > maxlen + 1)\n\t\talert(\'Should not be more than  \'+maxlen+\" characters\");\n\t\tif (field.value.length > maxlen)\n\t\tfield.value = field.value.substring(0, maxlen);\n\t}\n\t//AMRI-CRF-0362 Ends\n\t</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form>\n<br>\n<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t<tr>\n\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\'fields\'  width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<td class=\'label\' width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\">\n\t\t<td class=\'label\' width=\"25%\">\n\t\t<td class=\'label\' width=\"25%\">\n\t\t<td class=\'label\' width=\"25%\">\n\t</tr>\n</table>\n\n<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t<tr>\n\t\t<td  class=\'fields\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t</tr>\n</table>\n<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t<td class=\'label\' width=\"25%\">\n\t<td class=\'label\' width=\"25%\">\n\t<td class=\'label\' width=\"25%\">\n</tr>\n\t<tr>\n\t\t<td  class=\'fields\' width=\"25%\"><input type=\'radio\' name=\'bed_request\' id=\'bed_request\' value=\'P\' onClick=\'storeVal(this);dispReq()\'checked >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td  width=\"25%\" class=\'label\'><input type=\'radio\' name=\'bed_request\' id=\'bed_request\' value=\'H\' onClick=\'storeVal(this);dispReq()\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<td  width=\"25%\" class=\'label\'></td>\n\t\t<td  width=\"25%\" class=\'label\'></td>\n\t</tr>\n\t<tr>\t\t\n\t\t<td id = \'dispNameOnReq\' class=\'label\' width=\"40%\"></td>\n\t\t<td id = \'dispFieldOnReq\' class=\"fields\" width=\"30%\"><input type=\'hidden\' name=\'BedTypeCode\' id=\'BedTypeCode\' value=\'\'></td>\n\t\t<td  width=\"15%\"></td>\n\t\t<td  width=\"15%\"></td>\n\t</tr>\n\t<tr>\n\t\t<td  width=\"25%\" class=\'label\'></td>\n\t\t<td  width=\"25%\" class=\'label\'></td>\n\t\t<td  width=\"25%\" class=\'label\'></td>\n\t\t<td  width=\"25%\" class=\'label\'></td>\n\t</tr>\n\n\t<!-- AMRI-CRF-0362 Starts Here -->\n\t<tr>\n\t\t<td class=\'label\' align=\"right\">\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</td>\n\t\t<td>\n\t\t<textarea name=\"reqt_Rmks\" id=\"reqt_Rmks\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" rows=\"5\" cols=\"60\" onkeyup=\"textAreaLimit(this,250);\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</textarea>\n\t\t</td>\n\t</tr>\n\t<!-- AMRI-CRF-0362 Ends Here -->\n\n\t<tr>\n  \t    <td  class=\'label\' width=\"25%\"></td>\n\t\t<td class=\'button\'>\n\t\t<input type=\'button\' name=\"OK\" id=\"OK\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onClick=\'validate(this)\' class=\'button\'>\n\t\t<input type=\'button\' name=\'CANCEL\' id=\'CANCEL\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onClick=\'validate(this)\' class=\'button\'></td>\t\t\n\t\t<td  class=\'label\'></td>\n\t\t<td  class=\'label\'></td>\n\t</tr>\n</table>\n</form>\n\t<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t<input type=\'hidden\' name=\"defaultRequest\" id=\"defaultRequest\" id=\"defaultRequest\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n</body>\n</html>\n\n";
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

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	StringBuffer opt=new StringBuffer();
	Connection	con	=	null;
	PreparedStatement	stmt	=	null;
	ResultSet	rs		=	null;
	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);
	String bed_no="";
	String bed_type="";
	String bed_type_desc ="";
	String billing_group="";
	String title="";
	String blg_grp_name="";
	String elig_level="";	
	String high_bedtype_on_hosp_req_yn="N";
	String level_of_serv_for_bed_type="";
	String reqtRmks = "";//AMRI-CRF-0362
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id = (String)httpSession.getValue("facility_id");

	//Added by Rajesh V for ML-MMOH-CRF-0865
	String reasonForTransfer = request.getParameter("reasonForTransfer");
	if(reasonForTransfer == null){
		reasonForTransfer = "";
	}
	boolean defaultRequestBySetup = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","REQUEST_DEFAULT_BY_SETUP");
	String defaultRequest = "";

	try
	{
		//The following changes are done for Internationalisation Process
		request.setCharacterEncoding("UTF-8");
		bed_type=request.getParameter("bed_type");
		bed_no = request.getParameter("bed_no");
		billing_group = request.getParameter("billing_group");
		title = request.getParameter("title");

		String sql2 = "select HIGHER_BEDTYPE_ON_HOSP_REQ_YN from bl_parameters where OPERATING_FACILITY_ID='"+facility_id+"'";
		stmt = con.prepareStatement(sql2);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			high_bedtype_on_hosp_req_yn = rs.getString(1);
		}
		if(high_bedtype_on_hosp_req_yn == null) high_bedtype_on_hosp_req_yn="N";

		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();

		sql2 = "select short_desc,elig_level_of_service from bl_blng_grp_lang_vw where language_id='"+locale+"' and BLNG_GRP_ID = '"+billing_group+"'";
		stmt = con.prepareStatement(sql2);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			blg_grp_name = rs.getString("short_desc");
			elig_level  = rs.getString("ELIG_LEVEL_OF_SERVICE");
		}

		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();

		sql2 = "select short_desc from ip_bed_type_lang_vw where language_id='"+locale+"' and bed_type_code = '"+bed_type+"'";
		stmt = con.prepareStatement(sql2);
	    rs = stmt.executeQuery();
		while(rs.next())
		{
			bed_type_desc = rs.getString("short_desc");
		}
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();

		if(high_bedtype_on_hosp_req_yn.equals("Y"))
		{
			sql2 = "select b.LEVEL_OF_SERVICE LEVEL_OF_SERVICE from bl_ip_bed_type a, bl_blng_class b where a.blng_class_code = b.blng_class_code and a.bed_type_code ='"+bed_type+"'";
			stmt = con.prepareStatement(sql2);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				level_of_serv_for_bed_type = rs.getString("LEVEL_OF_SERVICE");
			}
			if(level_of_serv_for_bed_type == null ) level_of_serv_for_bed_type="";
			if (rs!=null) rs.close();
			if (stmt!=null) stmt.close();

			sql2 = "select a.bed_type_code, c.short_desc from bl_ip_bed_type a, bl_blng_class b, ip_bed_type_lang_vw c where c.language_id='"+locale+"' and a.blng_class_code = b.blng_class_code and a.bed_type_code = c.bed_type_code and b.level_of_service <= '"+elig_level+"' and b.level_of_service > '"+level_of_serv_for_bed_type+"'";
		}
		else
		{
			sql2 = "select a.bed_type_code, c.short_desc from bl_ip_bed_type a, bl_blng_class b, ip_bed_type_lang_vw c where c.language_id='"+locale+"' and a.blng_class_code = b.blng_class_code and a.bed_type_code = c.bed_type_code and b.level_of_service = '"+elig_level+"'";
		}

		stmt = con.prepareStatement(sql2);
	    rs = stmt.executeQuery();
		while(rs.next())
		{
			opt.append("<option value='"+rs.getString("bed_type_code")+"'>"+rs.getString("short_desc")+"</option>");			
		}
		
		if(defaultRequestBySetup && !"".equals(reasonForTransfer)){
			stmt = con.prepareStatement("Select blcommonproc.bl_transfer_type_default(?,?) from dual");
			stmt.setString(1, facility_id);
			stmt.setString(2, reasonForTransfer);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				defaultRequest = rs.getString(1);
			}
		}		
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
	}
	catch (Exception e)
	{ 
		e.printStackTrace();
		out.println ("Exception :"+e); 
	}
	finally
	{
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(title));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(opt));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(blg_grp_name));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(elig_level));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reqtRmks));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(reqtRmks));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(defaultRequest));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ELIG_LEVEL.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HIGHER_CLASS_CHARGE_BASIS_TITLE.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PATIENT_REQUEST.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HOSPITAL_REQUEST.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
