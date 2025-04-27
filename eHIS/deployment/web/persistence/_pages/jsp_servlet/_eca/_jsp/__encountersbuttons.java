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

public final class __encountersbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncountersButtons.jsp", 1741325029448L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script src=\'../../eCA/js/Encounters.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\n<STYLE>\n\ttd.errorEvents\n\t{\n\t\tbackground-color: BROWN;\n\t\tborder-style: dashed;\n\t}\n\tFONT.DELTAFAIL{\n\t\tbackground-color:#FFE4E1;\n\t}\n\n</STYLE>\n</head>\n<body  class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"button_form\" id=\"button_form\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<table cellpadding=0 cellspacing=3 border = \'0\' width=\'100%\' align=\'right\'>\n\t\t<tr>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<!--<td width=\'25%\'>&nbsp;</td>-->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t  <td nowrap onMouseOut=\'clearLayer()\' onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\">\n        <span style=\'background:url(\"../../eCA/images/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"); width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size: 12px;\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n    </td>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t  <td nowrap onMouseOut=\'clearLayer()\' onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\">\n        <span style=\'background-color:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="; width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size: 12px;\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n    </td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t <td nowrap>\n        <span style=\'background:url(\"../../eCA/images/NI_Normal.gif\"); width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size:12px;\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n    </td>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td nowrap>\n        <span style=\'background-color:#32CD32; width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size:12px;\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<!-- <td colspan=\'2\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td  class=\'label\'>&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td width=\'5%\'>\n\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' class=\'BUTTON\' onClick=\'manageText()\' title=\'Click to manage the events\'>\n\t\t</td>\n\t\t<td width=\'5%\'>\n\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' class=\'BUTTON\' onClick=\'showEnterQuickText();\' title=\'Click to enter comments\'>\n\t\t</td>\n\t\t<td  width=\'3%\'>\n\t\t\t\t<input type=\"button\"  name=\"print\" id=\"print\"  class=\"button\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\"valsForPrint()\" title=\'Click to print the events\' >\n\t\t</td>\n\t\t<td width=\'5%\'>\n\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' class=\'BUTTON\' onClick=\'emailText()\' title=\'Click to email the events\' name=\'emailBtn\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t</td> -->\t\t\n\t\t\n\t</tr>\n\t</table>\n\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" name=\"patient_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" name=\"encounter_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" name=\"enc_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" name=\"called_from\">\n\t<input type=\"hidden\" value=\"\" name=\"data_type\" id=\"data_type\">\n\t<div id=\'descLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\' ></div>\n\t</form>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

    String patientid		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
    String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
    String enc_id		= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
    String called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");
    String normalcy		= request.getParameter("normalcy")==null?"":request.getParameter("normalcy");
	if(enc_id.equals("")) enc_id = "0";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	HashMap mapDescColor = new HashMap();
	ArrayList listDesc = new ArrayList();
	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String delta_fail_str = "";
	String birth="";

	String emailDisp = "style='display'";
	String defPrevStatus = "";	
	String defPrevStatusForPrint = "";	
	String printDisp = "style='display'";

            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	try{
		
		con = ConnectionManager.getConnection(request);

		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'EMAIL_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatus = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'PRINT_CLIN_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatusForPrint = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(defPrevStatusForPrint.equals("A")) printDisp = "style='display'";
		else printDisp = "style='display:none'";

		if(defPrevStatus.equals("A")) emailDisp = "style='display'";
		else emailDisp = "style='display:none'";

		pstmt = con.prepareStatement("SELECT high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,DELTA_FAIL_STR,HIGH_SYMBOL_ICON,LOW_SYMBOL_ICON,ABN_SYMBOL_ICON,CRIT_SYMBOL_ICON,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_SYMBOL_ICON,nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmt.setString(1,patientid);
		rs = pstmt.executeQuery();

		if(rs.next())
		{
			high_value_desc = rs.getString("high_str_desc") == null ? "" : rs.getString("high_str_desc");
	        high_value_color = rs.getString("high_color_code") == null ? "" : rs.getString("high_color_code");
			if(normalcy.equals("I"))
				high_value_color = rs.getString("HIGH_SYMBOL_ICON") == null ? "" : rs.getString("HIGH_SYMBOL_ICON");
			mapDescColor.put(high_value_desc,high_value_color);
		    listDesc.add(high_value_desc);

		    low_value_desc = rs.getString("low_str_desc") == null ? "" : rs.getString("low_str_desc");
		    low_value_color = rs.getString("low_color_code") == null ? "" : rs.getString("low_color_code");
			if(normalcy.equals("I"))
				low_value_color = rs.getString("LOW_SYMBOL_ICON") == null ? "" : rs.getString("LOW_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(low_value_desc)))
			{
				mapDescColor.put(low_value_desc,low_value_color);
				listDesc.add(low_value_desc);
			}

		    abnml_value_desc = rs.getString("abn_str_desc") == null ? "" : rs.getString("abn_str_desc");
		    abnml_value_color = rs.getString("abn_color_code") == null ? "" : rs.getString("abn_color_code");
			if(normalcy.equals("I"))
				abnml_value_color = rs.getString("ABN_SYMBOL_ICON") == null ? "" : rs.getString("ABN_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(abnml_value_desc)))
			{
				mapDescColor.put(abnml_value_desc,abnml_value_color);
				listDesc.add(abnml_value_desc);
			}

		    crtcl_value_desc = rs.getString("crit_str_desc") == null ? "" : rs.getString("crit_str_desc");
		    crtcl_value_color = rs.getString("crit_color_code") == null ? "" : rs.getString("crit_color_code");
			if(normalcy.equals("I"))
				crtcl_value_color = rs.getString("CRIT_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(crtcl_value_desc)))
			{
				mapDescColor.put(crtcl_value_desc,crtcl_value_color);
				listDesc.add(crtcl_value_desc);
			}

		    crtcl_high_value_desc = rs.getString("crit_high_str_desc") == null ? "" : rs.getString("crit_high_str_desc");
		    crtcl_high_value_color = rs.getString("crit_high_color_code") == null ? "" : rs.getString("crit_high_color_code");
			if(normalcy.equals("I"))
				crtcl_high_value_color = rs.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_HIGH_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
			{
				mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
				listDesc.add(crtcl_high_value_desc);
			}

		    crtcl_low_value_desc = rs.getString("crit_low_str_desc") == null ? "" : rs.getString("crit_low_str_desc");
		    crtcl_low_value_color = rs.getString("crit_low_color_code") == null ? "" : rs.getString("crit_low_color_code");
			if(normalcy.equals("I"))
				crtcl_low_value_color = rs.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_LOW_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
			{
				mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
				listDesc.add(crtcl_low_value_desc);
			}

			delta_fail_str = rs.getString("DELTA_FAIL_STR");
			birth = rs.getString("birth");		
		
			out.println("<input type=hidden name='mode' id='mode' value='update'>");				
	}
	else
	{
		out.println("<input type=hidden name='mode' id='mode' value='insert'>");
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

		String listValues = "";
		String listValuesdisp = "";
		String mapValues = "";
	
            _bw.write(_wl_block9Bytes, _wl_block9);


	    for(int i=0;i<listDesc.size();i++)
		{
			listValues = (String) listDesc.get(i);
			if(listValues.length()>15)
				listValuesdisp=listValues.substring(0,16);
			else
				listValuesdisp=listValues;
			mapValues = (String) mapDescColor.get(listValues);
			if(normalcy.equals("I"))
			{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(listValues));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mapValues));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(listValuesdisp));
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
			else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(listValues));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mapValues));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(listValuesdisp));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
		}
			if(normalcy.equals("I"))
			{
		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
			else
			{
		
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
		
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(emailDisp));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block33Bytes, _wl_block33);

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	out.println("Exception in ChartRecordingColorBar.jsp"+e.toString());
	e.printStackTrace();
}
finally
{	
	if(con !=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClickOnValueCell.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Manage.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Email.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
