package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __bllogincashcounteradv extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLLogInCashCounterAdv.jsp", 1729826404034L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\'javascript\' src=\'../js/BLAmount.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n\n\n<script>\n//setTimeOut(\'datefun()\',30);\nsetInterval(\"datefun()\",500);\nfunction datefun()\n{\n\t/*var now = new Date();\t\n\tvar date= now.getDate()+\"/\"+now.getMonth()+\"/\"+now.getYear();\n\tvar time=now.getHours()+\":\"+now.getMinutes()+\":\"+now.getSeconds();\n\tvar date_time=date+\" \"+time;\n\t//document.menu_form.current_time.value=date_time;*/\t\n\tvar locale=document.getElementById(\'locale\').value;\t\n\tvar dat1=getCurrentDate(\'DMYHMS\' ,locale);\t\n\tdocument.menu_form.current_time.value=dat1;\n\t\n\n\t\n}\n\nfunction home()\n{\n\ttry\n\t{\n\t\tdocument.menu_form.Login.disabled = true;\n\t}\n\tcatch(e){}\n}\nfunction view()\n{\n\tvar jsp_name = \"../jsp/BLLogInCashCounterQuery.jsp\";\n\tvar dialogHeight= \"36\" ;//26\n\tvar dialogWidth\t= \"30\" ;//42\n\tvar status = \"no\";\n\t\n\tvar title = getLabel(\"eBL.CASH_COUNTER_IN_USAGE_LIST.label\",\"BL\");\n\tvar arguments\t= \"title=\"+title ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\n\twindow.showModalDialog(jsp_name,arguments,features);\n\n}\nfunction login()\n{\n\tvar cashcounter = document.forms[0].cashcounter.value;\n\tvar loin = getMessage(\'BL9326\',\'BL\');\n\tdocument.forms[0].loin.value=loin;\t\n\tif ((cashcounter == null) || (cashcounter == \'\') ||(cashcounter == \' \'))\n\t{\n\t\treturn(false);\n\t}\n\t\t\n\tdocument.forms[0].submit();\n\t\n\tparent.frames[1].location.href =\'../../eBL/jsp/BLLogInCashCounterAdv.jsp\';\n\tparent.frames[2].location.href =\'../../eBL/jsp/BLLogInCashCounterQuery.jsp\';\n}\n\nfunction funCashcounter()\n{\n\n\t\tvar arr = new Array();\n\t\tvar codeArray = new Array();\n\t\tvar appArray = new Array();\n\t\tvar cashcounter_array = document.forms[0].cashcounter_array.value;\n\t\t\n\t\tvar code = \'\';\n\t\tarr = cashcounter_array.split(\"|\");\n\t\tvar indx = arr.length;\n\t\tvar val = document.forms[0].cashcounter.value;\n\n\t\tfor (i=0;i<indx;i++)\n\t\t{\n\t\t\t\n\t\t\tif (arr[i] != null)\n\t\t\t{\n\n\t\t\t\tcodeArray = arr[i].split(\'-\');\n\t\t\t}\n\t\t\tif (codeArray[1] != null)\n\t\t\t{\n\t\t\t\tappArray =  codeArray[1].split(\';\');\n\t\t\t}\n\n\t\t\tcode = codeArray[0];\n\t\t\top_ctr = appArray[0];\n\t\t\tip_ctr = appArray[1];\n\t\t\trf_ctr = appArray[2];\n\n\t\t\tif(!(document.menu_form.cashcounter.value==\"\"))\n\t\t\t{\t\t\n\t\t\t\tif(code == val)\n\t\t\t\t{\n\t\t\t\t\tif (op_ctr == \'Y\')\n\t\t\t\t\t\tdocument.forms[0].op_ctr.checked = true;\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.forms[0].op_ctr.checked = false;\n\t\t\t\t\tif (ip_ctr == \'Y\')\n\t\t\t\t\t\tdocument.forms[0].ip_ctr.checked = true;\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.forms[0].ip_ctr.checked = false;\n\n\t\t\t\t\tif (rf_ctr == \'Y\')\n\t\t\t\t\t\tdocument.forms[0].rf_ctr.checked = true;\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.forms[0].rf_ctr.checked = false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].op_ctr.checked = false;\n\t\t\t\tdocument.forms[0].ip_ctr.checked = false;\n\t\t\t\tdocument.forms[0].rf_ctr.checked = false;\n\t\t\t}\n\t\t}\n\t\t\t\n\n\t\tvar cccode=document.forms[0].cashcounter.value;\n\t\t\n\t\tif(cccode!=\"\")\n\t\t{\n\n\t\t\tparent.frames[2].location.href =\'../../eBL/jsp/BLLogInCashCounterValidation.jsp?facility_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&login_user=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&strCashCounterCode=\'+cccode;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].shift_started_at.value=\"\";\n\t\t\tdocument.forms[0].opening_balance.value=\"\";\n\t\t}\n\t\n}\t\nfunction funCheckNumber()\n{\n\tif (isNaN(document.forms[0].opening_balance.value))\n\t{\n\t\tdocument.forms[0].opening_balance.focus();\n\t\treturn false;\n\t}\n\tcurrencyFormat(document.forms[0].opening_balance);\n\treturn(true);\n}\n\n\n</script>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/AddModifyPatFinDetails.js\"></script>\n\t<script language=\'javascript\' src=\"../../eBL/js/BLCashCounterLogin.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" onLoad=\"datefun();\">\n\t\t<form name=\'menu_form\' id=\'menu_form\'  method=\'post\' target=\'dummyFrame\' >\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<!--\t\t\t<tr>\n\t\t\t\t\t<td width=\'30%\'></td>\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t\t<td width=\'15%\'></td>\n\t\t\t\t\t<td width=\'30%\'></td>\n\t\t\t\t</tr>\n-->\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"15\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t <tr>\n    \t\t\t\t     <td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n    \t\t\t\t     <td width=\"50%\" class=\'fields\' ><select name=\'cashcounter\' id=\'cashcounter\' onchange=\'funCashcounter();\' >\n\t\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="----------</option>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</select></td>\n\t   </tr>\n\n\t\t<tr>\n\t\t    <td width=\"50%\" class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t    <td width=\"50%\" class=\'label\'><input type=\'checkbox\' name=\'ip_ctr\' id=\'ip_ctr\' value=\'N\'  Disabled ></td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t    <td width=\"50%\" class=\'label\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t    <td width=\"50%\" class=\'label\'><input type=\'checkbox\' name=\'op_ctr\' id=\'op_ctr\' value=\'N\'  Disabled></td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t    <td width=\"50%\" class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t    <td width=\"50%\" class=\'label\'><input type=\'checkbox\' name=\'rf_ctr\' id=\'rf_ctr\' value=\'N\'  Disabled></td>\n    \t</tr>\n\n\t\t<tr>\n\t\t    <td width=\"50%\" class=\'label\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t    <td width=\"50%\" class=\'label\'><input type=\'text\' name=\'shift_started_at\' id=\'shift_started_at\' size=\'30\' maxlength=\'20\' value=\'\' Disabled></td>\n    \t</tr>\n\n\t\t<tr>\n\t\t    <td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t    <td width=\"50%\" class=\'label\'><input type=\'text\' name=\'shift_started_by\' id=\'shift_started_by\' size=\'30\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' Disabled></td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t    <td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t    <td width=\"50%\" class=\'label\'><input type=\'text\' name=\'current_time\' id=\'current_time\' size=\'30\' maxlength=\'20\' value=\'\' Disabled></td>\n\t\t</tr>\n\t\t<tr>\n\t\t    <td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t    <td width=\"50%\" class=\'label\'><input type=\'text\' name=\'opening_balance\' id=\'opening_balance\' size=\'20\' style=\'text-align:right; font-weight:bold\' maxlength=\'30\' value=\"\" onBlur=\'funCheckNumber()\'></td>\n\t\t</tr>\n\n\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t <tr>\n\t\t\t    <td width=\"50%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t<td width=\"50%\" class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t\t\t<!--out.println(\"<script> alert(getMessage(\'BL9546\',\'BL\'));parent.commontoolbarFrame.onHome();  </script> \");-->\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'BL8195\',\'BL\'));\n//\t\t\t\t\t\t\tparent.commontoolbarFrame.onHome(); //commented by manivel on 15th Feb\'2007 because tht function is nt available in commontoolbar.jsp\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<tr>\n\t\t\t\t\t<td width=\"50%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td width=\"50%\" class=\'label\'><input type=\'button\' class=\'button\' name=\'Login\' id=\'Login\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onClick=\'callapply()\'> \n\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"50%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t<td width=\"50%\" class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"50%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t<td width=\"50%\" class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\n</table>\n\t\t<input type=\'hidden\' name=\'cashcounter_array\' id=\'cashcounter_array\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=\'hidden\' name=\'strCashCounterCode\' id=\'strCashCounterCode\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type= \'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=\'hidden\' name=\'loin\' id=\'loin\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'called_frm\' id=\'called_frm\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\n\t\n\n\n\t</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	String strCashCounterArray = "";
	String strCashCounterCode = "";
	String op_ip_rf_ctr = "N";
	String op_ctr  = "N";
	String ip_ctr  = "N";
	String rf_ctr   = "N";
	String date_time="";
	String refresh_flag="";
	String called_frm = "";
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	Statement stmt=con.createStatement();
	
	
	String locale	= (String)session.getAttribute("LOCALE");

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");

		refresh_flag=request.getParameter("refresh_flag");
		if(refresh_flag==null) refresh_flag="";

		called_frm = request.getParameter("called_frm");
		if(called_frm==null) called_frm="";

	
	String str=("select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual");
	ResultSet rs1=stmt.executeQuery(str);
	while(rs1.next())
		date_time=rs1.getString(1);

	if(rs1 != null) rs1.close();
	stmt.close();
	

            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle =		    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			try
			{
				//Connection 

//				if(!refresh_flag.equals("Y"))
//				{
				try
				{
					CallableStatement call = con.prepareCall("{ call bl_cash_counter_check.get_cash_counter_details(?,?,?,?,?,?) }");	
					call.setString(1,login_user);
					call.setString(2,facility_id);
					call.registerOutParameter(3,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
					call.registerOutParameter(4,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
					call.registerOutParameter(5,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
					call.registerOutParameter(6,java.sql.Types.VARCHAR); 
					call.execute();

					op_ip_rf_ctr = call.getString(3);    
					op_ctr = call.getString(4);          
					ip_ctr = call.getString(5);          
					rf_ctr = call.getString(6);   
					call.close();

					if(op_ip_rf_ctr==null) op_ip_rf_ctr="";
					if(op_ctr==null) op_ctr="";
					if(ip_ctr==null) ip_ctr="";
					if(rf_ctr==null) rf_ctr="";

//					System.out.println("op_ip_rf_ctr:"+op_ip_rf_ctr);
//					System.out.println("op_ctr:"+op_ctr);
//					System.out.println("ip_ctr:"+ip_ctr);
//					System.out.println("rf_ctr:"+rf_ctr);
					
				}
				catch(Exception exp)
				{
					//out.println("error="+exp);
					exp.printStackTrace();
				}

//				}

				try
				{
					String sql1 = "	select cash_counter_code,  "+
					" short_desc , " +
					" decode(nvl(op_applicable_ind,'N'),'N',nvl(op_refund_ind,'N'),nvl(op_applicable_ind,'N')), "+
					" decode(nvl(ip_applicable_ind,'N'),'N',nvl(ip_refund_ind,'N'),nvl(ip_applicable_ind,'N')), "+
					" decode(nvl(ref_applicable_ind,'N'),'N',nvl(ref_refund_ind,'N'),nvl(ref_applicable_ind,'N')), "+
					" nvl(status,'X'),	 "+
					" nvl(cash_ctr_in_use_yn, 'N') "+
					" from bl_cash_counter_lang_vw "+
					" where language_id='"+locale+"' and nvl(cash_ctr_in_use_yn,'N') = 'N'  "+
					" and operating_facility_id = ?"+
					" and NVL(status,'X') <> 'S' "+
					" and cash_counter_code in ( "+
					" SELECT cash_counter_code FROM bl_users_for_cash_counter "+
					" WHERE operating_facility_id = ?  AND cash_counter_user_id = ? "+
					" AND NVL(status,'X') <> 'S') "+
					" order by cash_counter_code";

					PreparedStatement pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, facility_id);
					pstmt.setString(3, login_user);
					ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCounterCode = rs.getString(1);
						strCashCounterArray = strCashCounterArray + strCashCounterCode + "-" + rs.getString(3)+";"+rs.getString(4)+";" +rs.getString(5)+";"+"|";
//						System.err.println("strCashCounterArray:"+strCashCounterArray);
						out.println("<option value='"+strCashCounterCode+"'>"+rs.getString(2));
					}
					rs.close();
					pstmt.close();
					
				}
				catch(Exception e)
				{
					//out.println("Error = "+e);
					e.printStackTrace();
				}
				// commented in Banglore on 13/10/2005
				//ConnectionManager.returnConnection(con, request);

				
				
			}
			catch(Exception exp)
			{
				//out.println("Error = "+exp);
				exp.printStackTrace();
			}
			
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);


					
	
				
				if ( (op_ip_rf_ctr.equalsIgnoreCase("Y") )||
				   (op_ctr.equalsIgnoreCase("Y") &&
				   ip_ctr.equalsIgnoreCase("Y") &&
				   rf_ctr.equalsIgnoreCase("Y")) )
				{
/*					
					out.println("<script> alert('Cash Counter is already Logged On'); 	parent.commontoolbarFrame.onHome();  </script> ");
					out.println("");
*/

            _bw.write(_wl_block24Bytes, _wl_block24);
					if(!refresh_flag.equals("Y"))
					{

            _bw.write(_wl_block25Bytes, _wl_block25);

					}

				}
				if(!refresh_flag.equals("Y") && ( (op_ip_rf_ctr.equalsIgnoreCase("N") ) || (op_ctr.equalsIgnoreCase("N") && ip_ctr.equalsIgnoreCase("N") && rf_ctr.equalsIgnoreCase("N")) ) )
				{

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CONFIRM_LOGIN.label","bl_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strCashCounterArray));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strCashCounterCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block32Bytes, _wl_block32);

	}
	catch(Exception eX)
	{
			//out.println("Error= "+eX);
			eX.printStackTrace();
	}
	finally
	{
		if(con!=null) 
		{
			ConnectionManager.returnConnection(con, request);
		}
	}


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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_COUNTER_LOGIN.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_COUNTER.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IP_ALLOWED.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OP_EMG_ALLOWED.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EXT_ALLOWED.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SHIFT_STARTED_AT.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SHIFT_STARTED_BY.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CurrentDateTime.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OpeningBalance.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
