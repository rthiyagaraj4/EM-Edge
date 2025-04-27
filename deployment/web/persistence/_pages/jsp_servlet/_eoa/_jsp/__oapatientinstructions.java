package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __oapatientinstructions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAPatientInstructions.jsp", 1734063568875L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "utf-8".intern();

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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t  \n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>       \n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eOA/js/OAPatientInstructions.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body onKeyDown=\'lockKey()\' onLoad=\'loadInstruciotnsCheck()\'>\n<form name=\'patInsForm\' id=\'patInsForm\' >\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<div id=\'patinsheaderID\'>\n\t\t<table width=\'610\'>\n\t\t\t<th width=\'500\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<th width=\'30\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</th>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</table>\n\t\t</div>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<div id=\'patinsID\' style=\'visibility:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";display:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";width:630;height:400;overflow-y:auto;overflow-x:no\'>\n\t<table width=\'610\' id=\'patinsTableID\'>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<tr><td><TEXTAREA NAME=\'descriptionID";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\', ROWS=2 COLS=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" id=\'descriptionID";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' size=\'200\' maxlength=\'200\' onkeypress=\'checkMaxLimit(this,200);return Allow(event);\'onBlur=\'RemoveSpec()\' onpaste=\'return maxLengthPaste(this,\"200\")\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</TEXTAREA></td>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<td><input type=\'checkbox\' id=\'check_BoxID";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' name=\'check_BoxID";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="></td>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<input type=\'hidden\' name=\'instructionID_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'instructionID_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'display_orderID_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'display_orderID_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'/>\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' size=\'200\' maxlength=\'200\' onkeypress=\'checkMaxLimit(this,200)\' onBlur=\'RemoveSpec()\' onpaste=\'return maxLengthPaste(this,\"200\")\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' value=\'\'></td>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'/>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t</table>\n\n\t</div>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<div id=\'procinsID\' style=\"visibility:";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<table width=\'610\'>\n\t\t\t<tr><td>\n\t\t\t\t<TEXTAREA name=\'or_standard_ins\' ROWS=5 COLS=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" size=\'2000\' maxlength=\'200\' onkeypress=\'checkMaxLimit(this,200)\'onpaste=\'return maxLengthPaste(this,\"200\")\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<td><input type=\'checkbox\' id=\'procCheckID\' name=\'procCheck\' id=\'procCheck\' value=\'\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</tr>\n\t\t</div>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<input type=\'hidden\' name=\'recCount\' id=\'recCount\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'viewinsdtlsYN\' id=\'viewinsdtlsYN\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\'hidden\' name=\'clinicInsYN\' id=\'clinicInsYN\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'orderInsYN\' id=\'orderInsYN\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'orderInsStandardYN\' id=\'orderInsStandardYN\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\'hidden\' name=\'or_catalogue_code\' id=\'or_catalogue_code\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\'hidden\' name=\'pending_order_catalog_code\' id=\'pending_order_catalog_code\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\'hidden\' name=\'procInsCount\' id=\'procInsCount\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\'hidden\' name=\'from_page\' id=\'from_page\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t</form>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=utf-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale=(String)session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	Connection connection = null;
	Statement stmt = null;
	ResultSet rset = null;
	String ins_dec="";
	String instruction_id="";
	String display_order="";
	String default_linked_yn="";
	String checkValue="";
	String valueObject="";
	Integer inObj=null;
	String clinic_visibility="";
	String proc_visibility="";
	String proc_display="";
	String clinic_display="";
	int recCount=1;
	//Set  keySet=null;
	//Iterator setIterator=null;


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	try{
		connection = ConnectionManager.getConnection(request);
		HashMap patInstructionsMap=(java.util.HashMap)session.getAttribute("patInstructionsMap");
		HashMap prcInstructionMap=(java.util.HashMap)session.getAttribute("prcInstructionMap");
		//HashMap patInsMapBasic=new HashMap();
		//HashMap displayMap=new HashMap();
		//String order_stand_ins="";
		//String pat_preps_or_instrns_ind="";
		String patInsColSize="68";
		String prcInsColSize="68";
		int procInsCount=0;
		int patInsCount=0;
		String prcCheckFlag="";
		//String appt_pat_ins="";
		//String appt_prc_ins="";
		String disabledTextArea="";
		String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");
		//String appt_refno=request.getParameter("appt_refno")==null?"":request.getParameter("appt_refno");
		String viewinsdtlsYN=request.getParameter("viewinsdtlsYN")==null?"N":request.getParameter("viewinsdtlsYN");
		String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String pending_order_catalog_code=request.getParameter("pending_order_catalog_code")==null?"":request.getParameter("pending_order_catalog_code");
		String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String clinicInsYN=request.getParameter("clinicInsYN")==null?"N":request.getParameter("clinicInsYN");
		String orderInsYN=request.getParameter("orderInsYN")==null?"N":request.getParameter("orderInsYN");
		String orderInsStandardYN=request.getParameter("orderInsStandardYN")==null?"N":request.getParameter("orderInsStandardYN");
		String addInstructionYN=request.getParameter("addInstructionYN")==null?"N":request.getParameter("addInstructionYN");
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		//String date_of_birth=request.getParameter("date_of_birth")==null?"":request.getParameter("date_of_birth");
		//String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String addCode=request.getParameter("addCode")==null?"":request.getParameter("addCode");
		String addDesc=request.getParameter("addDesc")==null?"":request.getParameter("addDesc");
		
		if(clinicInsYN.equals("Y")){
			proc_visibility="hidden";
			proc_display="none";
		}else{
			clinic_visibility="hidden";
			clinic_display="none";
			proc_visibility="";
			proc_display="";
		}
		if(patInstructionsMap!=null){
			patInsCount=patInstructionsMap.size();
		}
		if(prcInstructionMap!=null){
			if(prcInstructionMap.size()>0){
				procInsCount++;
				String checkedValue=(String)prcInstructionMap.get("checked");
				if(checkedValue!=null && checkedValue.equals("Y")){
					prcCheckFlag="checked";
				}
			}
		}
		if(from_page.equals("view_dtls")){
			disabledTextArea="readonly";
			patInsColSize="83";
			prcInsColSize="83";
		}

            _bw.write(_wl_block7Bytes, _wl_block7);
if(patInsCount >0 || procInsCount>0){
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
if(!(from_page.equals("view_dtls"))){
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_visibility));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinic_display));
            _bw.write(_wl_block16Bytes, _wl_block16);

			for(int countValue=1;countValue<=patInsCount;countValue++){
				default_linked_yn="";
				inObj=new Integer(countValue);
				display_order=inObj.toString();
				valueObject=(String)patInstructionsMap.get(inObj.toString());
				if(valueObject !=null){
					String[] tokens=valueObject.split("\\|~");
					instruction_id=tokens[0];
					ins_dec=tokens[1];
					default_linked_yn=tokens[2];
				}
				if(default_linked_yn.equals("Y")){
					checkValue="checked";
				}else{
					checkValue="";
				}

		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patInsColSize));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disabledTextArea));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ins_dec));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(!(from_page.equals("view_dtls"))){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(instruction_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(countValue));
            _bw.write(_wl_block32Bytes, _wl_block32);

				recCount++;
			}
			if(addInstructionYN.equals("Y")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patInsColSize));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(addDesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(!(from_page.equals("view_dtls"))){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(addCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
recCount++;}
		
            _bw.write(_wl_block36Bytes, _wl_block36);
if(procInsCount>0){
		String procDesc=(String)(prcInstructionMap.get("prcIns")==null?"":prcInstructionMap.get("prcIns"));
		if(procDesc==null)procDesc="";
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(proc_visibility));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(proc_display));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(prcInsColSize));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabledTextArea));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(procDesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(!(from_page.equals("view_dtls"))){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prcCheckFlag));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(viewinsdtlsYN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(clinicInsYN));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(orderInsYN));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(orderInsStandardYN));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(pending_order_catalog_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(procInsCount));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block57Bytes, _wl_block57);
	
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(connection,request);
	}

            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
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
}
