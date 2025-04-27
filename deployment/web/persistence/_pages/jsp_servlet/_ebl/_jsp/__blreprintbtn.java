package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Calendar;
import java.util.*;
import com.ehis.util.*;

public final class __blreprintbtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReprintBtn.jsp", 1739355503491L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!--\nSr No       Version         TFS/Incident        SCF/CRF   \t\t\t\tDeveloper Name\n---------------------------------------------------------------------------------------------\n1           V210622           17147     \t \tPMG2021-COMN-CRF-0077\t\tMuthkumarN\n2\t\t\tV220208\t\t\t  28689\t\t\t\tNMC-JD-CRF-0091\t\t\t\tManivel N\n---------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n    ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n<script language=\'javascript\' src=\'../../eBL/js/BLReprintReport.js\'></script>\n</head>\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \tonSelect=\"codeArrestThruSelect();\" onload=\"showData();\">\n\t<form name=\'reprintBtn\' id=\'reprintBtn\' scrolling=\'no\'>\n\t\t<div id=\'btnDiv\' style=\"display: none;\">\n\t\t\t<table width=\'100%\' align=\"center\">\n\t\t\t<tr>\t\t\t\n\t\t\t\t\n\t\t\t\t<td width=\'15%\'> </td>\n\t\t\t\t<td width=\'25%\' align=\'right\' >\n\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\t<script>\n\t$(document).ready(function(){\n\t\t\n\tif($(\'#report_type\').val()==\'R\')\n\t{\n\t\t$(\'#payer_type\').val(\'B\');\n\t$(\'#payer_type\').attr(\'disabled\',\'disabled\');\n\t}\telse\t{\n\t\t$(\'#payer_type\').removeAttr(\'disabled\');\n\t}\n\t\n\t\t\n$(\'#report_type\').click(function(){\n\n\t//alert($(\'#report_type\').val());\n\tif($(\'#report_type\').val()==\'R\')\n\t\t{\n\t\t$(\'#payer_type\').val(\'B\');\n\t\t$(\'#payer_type\').attr(\'disabled\',\'disabled\');\n\t//$(\'#payer_type\').val(\'B\');\n\t\t}\n\telse\n\t\t{\n\t\t$(\'#payer_type\').removeAttr(\'disabled\');\n\t\t}\n});\n});\t \n\n</script>\n\t\t\t\t\t<input name=\"chk_print_stamp_YN\" id=\"chk_print_stamp_YN\" type=\"checkbox\" id=\"chk_print_stamp_YN\" value=\"N\" onclick=\"selPrintStamp(); \">\n\t\t\t\t\t <span id=\"lbl_print_stamp_YN\">Print Stamp</span>\n\t\t\t\t\t\n\t\t\t\t\t\n\n\t\t\t\t\t<select name=\'payer_type\' id=\'payer_type\' >\n\n\t\t\t\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</option> <!--added against MOHE-CRF-0039--> \n\t\t\t\t\t\t\t<option value=\'I\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option> <!--added against MOHE-CRF-0039--> \n\t\t\t\t\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option> <!--added against MOHE-CRF-0039--> \n\t\t\t\t\t\t\t</option>\n\n\t\t\t\t\t</select> \n\t\t\t\t\t<select name=\'report_type\' id=\'report_type\' >\n\n\t\t\t\t\t\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option> <!--added against MOHE-CRF-0039--> \n\t\t\t\t\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option> <!--added against MOHE-CRF-0039--> \n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t</select> \n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t<input class=\'button\' type=\"button\" name=\'btnSettlement\' id=\'btnSettlement\' value=\'Settlement\' onclick=\'insertConsolidatedBill();\' >\n\t\t\t\t\t\t<input class=\'button\' type=\"button\" name=\'btnCancel\' id=\'btnCancel\'  value=\'Cancel All\' onclick=\'cancelAll();\'>\n\t\t\t\t\t\t<input class=\'button\' type=\"button\" name=\'btnReprint\' id=\'btnReprint\' value=\'Reprint All\' onclick=\'insertSyProgParamBulk();\'>\t\n\t\t\t\t\t\t<input class=\'button\' type=\"button\" name=\'btnReprint1\' id=\'btnReprint1\'  value=\'Print All\' onclick=\'insertSyProgParamBulk();\'>\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t          \n\t\t          </td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\n\t\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'  value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'site_id\' id=\'site_id\'  value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t<!-- Commented against V210622\n\t\t\t<input type=\'hidden\' name=\'demo_version\' id=\'demo_version\' id=\'demo_version\' value=\'\'>-->\n\t\t\t<input type=\'hidden\' name=\'bilparam\' id=\'bilparam\'  value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'siteSpecBillItemDateWiseYN\'  id=\'siteSpecBillItemDateWiseYN\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t<input type=\'hidden\' name=\'site3TierAlmoFeatureYN\'  id=\'site3TierAlmoFeatureYN\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t<input type=\'hidden\' name=\'hid_chk_print_stamp_YN\'  id=\'hid_chk_print_stamp_YN\' value=\'N\' />\n\t\t\t<input type=\'hidden\' name=\'siteEnableDigitalSignatureYN\'  id=\'siteEnableDigitalSignatureYN\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' />\n\t\t\t\n\t\t</div>\n<script type=\"text/javascript\">\nfunction showData(){\n\tvar site_id= document.getElementById(\'site_id\').value;\n\t//var demo_version= document.getElementById(\'demo_version\').value;//Commented against V210622\n\tvar site3TierAlmoFeatureYN= document.getElementById(\'site3TierAlmoFeatureYN\').value;\n\tvar siteEnableDigitalSignatureYN = document.getElementById(\"siteEnableDigitalSignatureYN\").value;\n\t\n\t//if( (site_id==\'ALMO\' || site3TierAlmoFeatureYN == \'Y\') && (demo_version == \'Y\')){//Commented against V210622\n\tif( (site_id==\'ALMO\' || site3TierAlmoFeatureYN == \'Y\')){//removed demo_version against V210622\n\t\t\t document.getElementById(\"btnSettlement\").style.visibility = \"visible\";\n\t\t\t document.getElementById(\"btnCancel\").style.visibility = \"visible\";\n\t\t\t document.getElementById(\"btnReprint\").style.visibility = \"visible\";\n\t\t\t document.getElementById(\"btnReprint1\").style.visibility = \"hidden\";\n\t\t}\n\telse{\n\t\t\tdocument.getElementById(\"btnSettlement\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"btnCancel\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"btnReprint\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"btnReprint1\").style.visibility = \"visible\";\n\t}\n\t\n\tif(siteEnableDigitalSignatureYN == \'Y\'){\n\t\t document.getElementById(\"chk_print_stamp_YN\").style.visibility = \"visible\";\n\t\t document.getElementById(\"lbl_print_stamp_YN\").style.visibility = \"visible\";\n\t}\n\telse{\n\t\tdocument.getElementById(\"chk_print_stamp_YN\").style.visibility = \"hidden\";\n\t\tdocument.getElementById(\"lbl_print_stamp_YN\").style.visibility = \"hidden\";\n\t}\n}\n</script>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facilityId = (String) session.getAttribute("facility_id");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			request.setCharacterEncoding("UTF-8");
			Connection con = null;
			ResultSet rs=null;
			String site_id="";
			//String demo_version="";//Commented against V210622
			boolean siteSpecBillItemDateWise = false;
			String siteSpecBillItemDateWiseYN = "";
			//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
			Connection con1 = null;
			boolean site3TierAlmoFeature = false;
			String site3TierAlmoFeatureYN = "";
			try {
					con1	=	ConnectionManager.getConnection(request);
					site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL","3TIERALMOFEATURE");
					if (site3TierAlmoFeature) {
						site3TierAlmoFeatureYN = "Y";
					}else {
						site3TierAlmoFeatureYN = "N";
					}
				} catch(Exception ex) {
					System.err.println("Error in BLReprintBtn.jsp for getting site3TierAlmoFeature Connection: "+ex);
					ex.printStackTrace();
				}finally{
						if(con1!=null) {
							ConnectionManager.returnConnection(con1, request);
						}
					}
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1	
			try
			{
				con	=	ConnectionManager.getConnection(request);	
				String site_id_sql = "select customer_id from sm_site_param ";

				Statement stmt = con.createStatement();
				rs = stmt.executeQuery(site_id_sql);	

				if(rs.next())
				{
					site_id  =  rs.getString(1);	
				}
				if(rs!=null)   rs.close();
				if(stmt!=null) stmt.close();
			
			}
			catch(Exception eX)
			{	
				//out.println("Error= "+eX);
				eX.printStackTrace();			
			}
			//Added by Subha-V20180803/ML-MMOH-CRF-1173/Starts
			try {
				siteSpecBillItemDateWise = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BILL_MAIN_ITEM_DATE_WISE");
				System.out.println("siteSpecBillItemDateWise: "+siteSpecBillItemDateWise);
				if(siteSpecBillItemDateWise) {
					siteSpecBillItemDateWiseYN = "Y";
				}else {
					siteSpecBillItemDateWiseYN = "N";
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			//Added by Subha-V20180803/ML-MMOH-CRF-1173/Ends
			
				// Added for NMC-JD-CRF-0091
			String enableDigitalSignatureYN = "N";
			try 
			{
				boolean siteEnableDigitalSignatureYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","TO_ENABLE_DIGITAL_SIGNATURE");
				if (siteEnableDigitalSignatureYN) {
					enableDigitalSignatureYN = "Y";
				}else {
					enableDigitalSignatureYN = "N";
				}
			} catch(Exception ex) {
				System.err.println("Error in siteEnableDigitalSignatureYN Connection: "+ex);
				ex.printStackTrace();
			} finally{
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
			}
			
			/* Commented against V210622
			try
			{ 
				//con1	=	ConnectionManager.getConnection(request);	
				String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = 'QF' ";
				
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(demo_identifier_sql);	

				if(rs2.next())
				{
					demo_version  =  rs2.getString(1);	
					System.out.println("demo_identifier" +demo_version);
				}
				if(rs2!=null)   rs2.close();
				if(stmt2!=null) stmt2.close();
				con.close();
		}
		catch(Exception eX){	
			out.println("Error 1= "+eX);			
		eX.printStackTrace();			
		}finally{
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
			}*/
			
			
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
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(site_id ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(siteSpecBillItemDateWiseYN ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(site3TierAlmoFeatureYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(enableDigitalSignatureYN ));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BOTH.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RePrint_Bill.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Reprint_Bill_Item_Wise.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Reprint_Bill_Date_Wise.label", java.lang.String .class,"key"));
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
}
