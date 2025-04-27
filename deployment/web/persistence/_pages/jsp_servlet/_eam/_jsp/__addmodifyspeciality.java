package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyspeciality extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addModifySpeciality.jsp", 1709113969430L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n      <head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n      \t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n      \t<script>\n      \tfunction change() \n\t\t{\n      \t\t\n      \t\tvar isMRSpecialtyApp = document.forms[0].isMRSpecialtyApp.value;\n      \t\tif (speciality_form.eff_status.checked == true){\n\t      \t \tspeciality_form.eff_status.value=\"E\";\n\t      \t \tif(isMRSpecialtyApp==\"true\"){\n\t      \t \t\tspeciality_form.mr_appl_yn.disabled\t= false;\n\t      \t \t}\n\t      \t \t\n\t      \t}else{\n\t      \t\tspeciality_form.eff_status.value=\"D\";\n\t      \t\tif(isMRSpecialtyApp==\"true\"){\n\t\t      \t\tspeciality_form.mr_appl_yn.checked\t= false;\n\t\t      \t\tspeciality_form.mr_appl_yn.disabled\t= true;\n\t      \t\t}\n\t\t\t}\n\t      \t\n\t      \t\n\t\t}\n      \t\n      \t//Added for the CRf - Bru-HIMS-CRF-0198\n      \tfunction changeSpeciality(){\n      \t\tif (speciality_form.multi_speciality_chk_yn.checked == true){\n          \t \tspeciality_form.multi_speciality_chk_yn.value=\"Y\";\n          \t \tspeciality_form.multi_speciality_yn.value=\"Y\";\n      \t\t}\n          \t else{\n          \t\tspeciality_form.multi_speciality_chk_yn.value=\"N\";\n          \t\tspeciality_form.multi_speciality_yn.value=\"N\";\n          \t }\n      \t}\n      \t</script>\n\n      </head>\n\n      <body OnMouseDown=\'CodeArrest()\' onLoad=\"FocusFirstElement();\" onKeyDown = \'lockKey()\'>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n      \t<form name=\'speciality_form\' id=\'speciality_form\' action=\'../../servlet/eAM.SpecialityServlet\' method=\'post\' target=\'messageFrame\'>\n      \t<div>\n      \t<br><br><br><br><br><br><br><br>\n      \t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'auto\' align=\'center\'>\n      \t<tr>\n      \t\t<td width=\'10%\'>&nbsp;</td>\n      \t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t</tr>\n      \t<tr>\n      \t\t    <td class=\'label\'>&nbsp;</td>\n      \t\t    <td  class=\'label\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n      \t\t    <td class=\'fields\'>&nbsp;&nbsp;\n      \t\t    <input type=\'text\' name=\'speciality_code\' id=\'speciality_code\' onKeyPress=\"return CheckForSpecChars(event)\"  value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" size=\'4\' maxlength=\'4\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">&nbsp;\n      \t\t    <img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n      \t\t    <td class=\'label\'>&nbsp;</td>\n      \t</tr>\n      \t<tr>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n      \t<tr>\n      \t\t    <td class=\'label\'>&nbsp;</td>\n      \t\t    <td    class=label>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n      \t\t    <td class=\'fields\'>&nbsp;&nbsp;\n      \t\t    <input type=\'text\' name=\'long_desc\' id=\'long_desc\' onBlur=\"makeValidString(this)\" size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >\n      \t\t    <img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n      \t\t    <td>&nbsp;</td>\n      \t</tr>\n      \t<tr>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n      \t<tr>\n      \t\t    <td class=\'label\'>&nbsp;</td>\n      \t\t    <td  class=label>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t    <td class=\'fields\'>&nbsp;&nbsp;\n\t\t\t\t<input type=\'text\' onBlur=\"makeValidString(this)\" name=\'short_desc\' id=\'short_desc\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n\t\t\t    <img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t\t    <td>&nbsp;</td>\n      \t</tr>\n      \t<tr>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\n   \t\t<tr>\n      \t\t    <td class=\'label\'>&nbsp;</td>\n      \t\t    <td  class=label>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t    <td class=\'fields\'>&nbsp;&nbsp;\n\t\t\t\t<select name=\"vital_signs_battery\" id=\"vital_signs_battery\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t\t\t\t<option value=\"\">-------- ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="-------- </option>\t\t\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t</select>\n\t\t\t</td>\n\t\t    <td class=\'label\'>&nbsp;</td>\n      \t</tr>\n      \t<tr>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<tr>\n    \t\t      <td>&nbsp;</td>\n      \t\t     <td   class=\'label\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n      \t\t     <td  class=\'fields\'>&nbsp;&nbsp;\n      \t\t     <input type=\'checkbox\' name=\'multi_speciality_chk_yn\' id=\'multi_speciality_chk_yn\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="  onClick=\"changeSpeciality()\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></td>\n      \t\t     <input type=\'hidden\' name=\'multi_speciality_yn\' id=\'multi_speciality_yn\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'/>\n      \t\t     <td>&nbsp;</td>\n   \t\t</tr>\n   \t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n   \t\t<tr>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t\n   \t\t<tr>\n    \t\t      <td>&nbsp;</td>\n      \t\t     <td   class=\'label\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n      \t\t     <td  class=\'fields\'>&nbsp;&nbsp;\n      \t\t     <input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" onClick=\"change()\"></td>\n      \t\t     <td>&nbsp;</td>\n   \t\t</tr>\n   \t\t<tr>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t<!-- Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 Start -->\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n      \t\t     <td  class=\'fields\'>&nbsp;&nbsp;\n      \t\t     <input type=\'checkbox\' name=\'mr_appl_yn\' id=\'mr_appl_yn\' value=\"Y\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="checked";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="disabled";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  /></td>\n      \t\t     <td>&nbsp;</td>\n   \t\t</tr>\n   \t\t<tr>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n      \t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<input type=\'hidden\' name=\'isMRSpecialtyApp\' id=\'isMRSpecialtyApp\' value =\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' />\n\t\t<input type=\'hidden\' name=\'mrOpenReqCount\' id=\'mrOpenReqCount\' value =\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' />\n\t\t<!-- Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 End -->\n   \t</table>\n \t</div>\n \t\n    ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\n      ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n     ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n \t</form>\n   </body>\n  </html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
   String  specialitycode="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String vitalsignbattery = "";
   String multi_speciality_yn = "";//Added for the CRF - Bru-HIMS-CRF-0198
   String multi_spclty_checked = "";//Added for the CRF - Bru-HIMS-CRF-0198
   String multi_spclty_disabled = "";//Added for the CRF - Bru-HIMS-CRF-0198
   boolean isMultiSpeciality=false;//Added for the CRF - Bru-HIMS-CRF-0198
   String codeTextAttribute="";
   String otherTextAttribute="";
   String listAttribute="";
   String checkBoxAttribute="checked";
   String eventFunctionForCase="";
   String mrApplYN		= "Y";
   boolean newSpeciality=false;
   String sql="";
   PreparedStatement pstmt = null;
   PreparedStatement pstmt1 = null;
   ResultSet rs = null;
   ResultSet rs1 = null;
   Connection conn =null;
   int mrOpenReqCount	= 0;
   boolean isMRSpecialtyApp	= false;//Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454

            _bw.write(_wl_block1Bytes, _wl_block1);

	try
	{
		conn = ConnectionManager.getConnection(request);
		specialitycode=request.getParameter("speciality_code");
		//Added for the CRF - Bru-HIMS-CRF-0198
		isMultiSpeciality	= eOP.QMSInterface.isSiteSpecific(conn, "OP", "MULTI_SPECIALTY");
		isMRSpecialtyApp	= eCommon.Common.CommonBean.isSiteSpecific(conn, "MR", "MR_SPECIALTY_DEF_APPL_YN");//Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454
		
		if(specialitycode==null)
		{
			specialitycode="";
			longdesc="";
			shortdesc="";
			effstatus="E";
			vitalsignbattery="";
			multi_speciality_yn="N";//Added for the CRF - Bru-HIMS-CRF-0198
			multi_spclty_checked="";//Added for the CRF - Bru-HIMS-CRF-0198
			codeTextAttribute="";
			otherTextAttribute="";
			listAttribute = "";
			checkBoxAttribute="CHECKED";
			newSpeciality=true;
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
		}
		else
		{
	       Statement stmt=null;
		   PreparedStatement pstmt2 = null;
	    	ResultSet rset=null;
			try
			{
				stmt = conn.createStatement();
				sql = "select speciality_code, long_desc, short_desc, eff_date_from,eff_date_to,eff_status, vital_signs_battery_id, multi_speciality_yn, mr_appl_yn  from am_speciality where speciality_code=?";
				//rset = stmt.executeQuery(sql);
				
				pstmt2   = conn.prepareStatement(sql);
				pstmt2.setString	(	1,	specialitycode		);

				rset		 = pstmt2.executeQuery();
				rset.next();
				specialitycode	= rset.getString("speciality_code");
				longdesc		= rset.getString("long_desc");
				shortdesc		= rset.getString("short_desc");
				effstatus		= rset.getString("eff_status");
				vitalsignbattery= rset.getString("vital_signs_battery_id");
				multi_speciality_yn= rset.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
				mrApplYN		= rset.getString("mr_appl_yn");
				if(effstatus.equals("D"))
				{
					listAttribute = "DISABLED";
					otherTextAttribute="READONLY";
					checkBoxAttribute="";
				}
				else
				{
					listAttribute = "";
					otherTextAttribute="";
					checkBoxAttribute="CHECKED";
				}
				//Added for the CRF - Bru-HIMS-CRF-0198
				if(multi_speciality_yn != null && multi_speciality_yn.equals("Y")){
					multi_spclty_checked="checked";
					multi_spclty_disabled="disabled";
				}
				/*Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454 Start*/
				if(isMRSpecialtyApp){
					mrOpenReqCount	= eMR.MRCommonBean.getMROpenReqCount(conn,specialitycode);
				}
				/*Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454 End*/		
			}
			catch(Exception e)
			{	
				e.toString();	
			}
			finally
			{
				try
				{
	     		if(rset!=null)	rset.close();
				if(stmt!=null)	stmt.close();
				if(pstmt2!=null)	pstmt2.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		     }
			codeTextAttribute="READONLY";
			newSpeciality=false;
			eventFunctionForCase="";
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(codeTextAttribute));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(eventFunctionForCase));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(listAttribute));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

			pstmt = conn.prepareStatement("select short_desc,discr_msr_id from am_discr_msr where eff_Status ='E' and result_type ='V' order by 1");
			rs = pstmt.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					String vscode = rs.getString("discr_msr_id");
					String vsdesc = rs.getString("short_desc");
					if(vscode.equals(vitalsignbattery))
						out.println("<option value='"+vscode+"' selected>"+vsdesc+"</option>");
					else
						out.println("<option value='"+vscode+"'>"+vsdesc+"</option>");
				}
			}

            _bw.write(_wl_block21Bytes, _wl_block21);
//Added for the CRF - Bru-HIMS-CRF-0198
		if(isMultiSpeciality){ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(multi_spclty_checked));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(multi_spclty_disabled ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(isMRSpecialtyApp){ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
if(mrApplYN.equals("Y") && effstatus.equals("E")){
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
if(!effstatus.equals("E")){
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
} 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(isMRSpecialtyApp));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mrOpenReqCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
  if(newSpeciality){
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
}
     }
	 catch(Exception e)
	 {}
     finally
	{
		try
		{
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();
		if(rs1 != null)		rs1.close();
		if(pstmt1 != null)	pstmt1.close();
		}
		catch(Exception re)
		{
			re.printStackTrace();
		}

		if(conn != null)
     	ConnectionManager.returnConnection(conn,request);
     }
     
            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VitalSignsBattery.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.Multispeciality.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicableForMR.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
