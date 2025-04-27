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
import java.util.*;
import com.ehis.util.*;

public final class __billinterimbedchargecompute extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillInterimBedChargeCompute.jsp", 1709114373370L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<HEAD>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\t<script>\n\t\t\t\tfunction funComputeBedCharges()\n\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\tif(document.forms[0].compute_bed_charge_flag.value==\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\talert(\"no records to submit\");\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t//parent.frames[2].document.forms[0].bed_chr_date.value=document.forms[0].bed_chr_date.value;\n\t\t\t\t\t//alert(\"Job Submitted For Bed Charge Process\");\n\t\t\t\t\talert(getMessage(\"BL9928\",\"BL\"))\n\t\t\t\t\tparent.frames[2].document.forms[0].submit();\t\n\t\t\t\t\n\t\t\t\t}\n\n\t\t\t</script>\n    </HEAD> \n\t\t\t<BODY onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n\t\t\t<FORM name=\'BillSlmtInterimReportBedComp\' id=\'BillSlmtInterimReportBedComp\' method=\'post\' action=\'../../eBL/jsp/BillInterimBedChargeCompute.jsp\'>\n\t\t\t<TABLE border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t\t\t<!-- <TR>\n\t\t\t <td class=\"label\" width=\"25%\">Bed Charge Computed upto Date</td>\t\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"bed_chr_date\" id=\"bed_chr_date\" SIZE=\"15\" MAXLENGTH=\'10\' VALUE=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' readonly ></td>\n\t\t\t\t<td class=\"label\" width=\"25%\">No of days to run</td>\t\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"int_bill_gen_freq\" id=\"int_bill_gen_freq\" SIZE=\"15\" MAXLENGTH=\'10\' VALUE=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' ></td>\n\t\t\t</tr>-->\n\t\t\t<TR>\t\n\t\t\t<td class=\"label\" width=\"25%\"></td>\n\t\t\t<td class=\"label\" width=\"25%\"></td>\n\t\t\t<td class=\"fields\" width=\"25%\"></td> \n\t\t\t<td width=\"25%\"  class=\"label\" ><input type=\'button\' class=\'button\' disabled onclick=\'funComputeBedCharges()\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" name=\'submit_but\'></td>\t\t\t\n\t\t\t<td class=\"fields\" width=\"25%\"></td>\n\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t\t<input type= hidden name=\"compute_bed_charge_flag\" id=\"compute_bed_charge_flag\"  value=\'\'>\n\t\t\t</FORM>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	ResultSet rs1=null; ResultSet rs3=null;ResultSet rs2=null;
	PreparedStatement pstmt = null ;
	String locale="",p_facility_id="";
	String strBedChrDate="",strDays="";
	String strSysdate="";
try{	
		HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		con	=	ConnectionManager.getConnection(request);
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");

			try{
					pstmt = con.prepareStatement("SELECT to_char(FROM_TIME_BED_BLNG,'DD/MM/YYYY') FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID ='"+p_facility_id+"' ");

					rs1 = pstmt.executeQuery();	
					while(rs1.next())
					{
						strBedChrDate  =  rs1.getString(1);		
					}
					if ( strBedChrDate== null || strBedChrDate.equalsIgnoreCase("null")){
							strBedChrDate="";}
//					System.out.println("strBedChrDate :" +strBedChrDate);
				rs1.close();
				pstmt.close();
				}catch(Exception e) {System.out.println("bed computation="+e.toString());}

				try{
					pstmt = con.prepareStatement("SELECT to_char(sysdate,'dd/mm/yyyy') FROM dual ");

					rs2 = pstmt.executeQuery();	
					while(rs2.next())
					{
						strSysdate =  rs2.getString(1);		
					}
					if ( strSysdate== null || strSysdate.equalsIgnoreCase("null")){
							strSysdate="";}
//					System.out.println("strSysdate :" +strSysdate);
				rs2.close();
				pstmt.close();
				}catch(Exception e) {System.out.println("strSysdate="+e.toString());}

				try{
					pstmt = con.prepareStatement("select floor(to_date('"+strSysdate+"' ,'dd/mm/yyyy')- to_date('"+strBedChrDate+"','dd/mm/yyyy')) from dual ");

					rs3 = pstmt.executeQuery();	
					while(rs3.next())
					{
						strDays =  rs3.getString(1);		
					}
					if ( strDays== null || strDays.equalsIgnoreCase("null")){
							strDays="";}
					
//					System.out.println("strDays :" +strDays);
				rs3.close();
				pstmt.close();
				}catch(Exception e) {System.out.println("strDays="+e.toString());}

				

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strBedChrDate));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strDays));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SUBMIT_BED_CHARGE_PROCESS.label","bl_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);

		}catch(Exception e){}
			finally{				
					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
					}	
		
	
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
