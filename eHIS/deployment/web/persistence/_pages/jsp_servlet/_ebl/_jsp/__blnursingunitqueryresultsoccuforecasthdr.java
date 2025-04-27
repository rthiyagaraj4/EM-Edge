package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blnursingunitqueryresultsoccuforecasthdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLNursingUnitQueryResultsOccuForecastHdr.jsp", 1709114558431L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\t\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/BLNursingUnitBillingDetails.js\"></script>\n\n<script language=\'javascript\'>\nfunction forecast_search(no_of_days)\n{\n\tif(no_of_days.value != \"\")\n\t{\n\t\tif(validate_entry(no_of_days))\n\t\t{\n\t\t\tvar query_string =document.forms[0].query_string.value;\n\t\t\tvar params = query_string+\"&no_of_days=\"+no_of_days.value;\n\t\t\tparent.frames[1].location.href = \'../../eBL/jsp/BLNursingUnitQueryResultsOccuForecastBody.jsp?\'+params; \n\t\t\tparent.frames[2].location.href = \"../../eCommon/jsp/process.jsp\";\n\t\t}\n\t}\n\telse\n\t{\n\t\tvar mess = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\tmess = mess.replace(\"$\",\"\'\"+getLabel(\"eBL.NO_OF_DAYS_OCCU_FORECAST.label\",\"BL\")+\"\'\");\n\t\talert(mess);\n\t}\n}\n\nfunction validate_entry(forecast_days)\n{\n\tif(forecast_days.value != \"\")\n\t{\n\t\tif(CheckForChar_withoutMinusSign(forecast_days))\n\t\t{\n\t\t\tif(eval(forecast_days.value) > 365)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6432\",\"BL\"));\n\t\t\t\tforecast_days.select();\n\t\t\t\tparent.frames[1].location.href = \'../../eCommon/html/blank.html\';\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if(eval(forecast_days.value) <= 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_BE_ZERO\",\"common\"));\n\t\t\t\tforecast_days.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t}\n\telse\n\t{\n\t\tparent.frames[1].location.href = \'../../eCommon/html/blank.html\';\n\t}\n}\n\nfunction CheckForChar_withoutMinusSign(Obj)\n{\n\tvar check_var = Obj.value;\n\n\tnumList = \'1234567890\';\n\t\n\tfor (i=0;i<check_var.length;i++)\n\t{\n\t\tif (numList.indexOf(check_var.charAt(i)) == -1) \n\t\t{\n\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\'Common\'));\n\t\t\tObj.select();\n\t\t\treturn false;  \n\t\t}\n\t}\n\treturn true;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n</head>\n\n<body onLoad=\"forecast_search(document.forms[0].forecast_days);\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n\n<form name=\'BLNursingUnitBlngDtlsForm\' id=\'BLNursingUnitBlngDtlsForm\' action=\"\" method=\"post\" target=\"\">\n\t<TABLE border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\' id=\'tab\'>\n\t\t<tr>\n\t\t\t<td width=\"80%\" class=\"label\"><B>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</B></td>\n\t\t\t<td width=\"10%\" class=\"fields\" ><input type=\'text\' size=\'4\' maxlength=\'4\' name=\"forecast_days\" id=\"forecast_days\" tabindex=\'1\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0));\' onBlur=\'validate_entry(this);\'></td>\t\n\t\t\t<td width=\"10%\" class=\"button\"><div align=\'left\'><input type=\'button\' class=\'button\' name=\'go_button\' id=\'go_button\'  value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  onClick=\'forecast_search(document.forms[0].forecast_days);\' tabindex=\'2\'></div>\n\t\t\t</td>\t\t\t\n\t\t</tr>\n\t</TABLE>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t<input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n</form>\n\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt				= null;
	ResultSet rs = null;

	String locale = (String)session.getAttribute("LOCALE");
	int noofdecimal=2;
	String sys_date="";
	String sys_date_wht_sec=""; // System time without seconds

	String nursing_unit_code="";

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p  = (Properties)httpSession.getValue("jdbc");	
		String facility_id = (String)httpSession.getValue("facility_id");
//		String strLoggedUser = p.getProperty("login_user");

//		java.util.Locale loc = new java.util.Locale(locale);

		String dflt_forecast_days = request.getParameter("dflt_forecast_days");
		if(dflt_forecast_days == null) dflt_forecast_days="15";

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}	

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();

			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date_wht_sec = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception @ sysdate"+e);
		}

		String query_string=request.getQueryString();
//		System.err.println("request.getQueryString() in BLPatientRegnBillingDtls.jsp:"+query_string);

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dflt_forecast_days));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block16Bytes, _wl_block16);

	session.removeAttribute("curr_inp_cnt");
	}
	catch(Exception ee)
	{
		out.println("Exception in Details.jsp"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NO_OF_DAYS_OCCU_FORECAST.label", java.lang.String .class,"key"));
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
}
