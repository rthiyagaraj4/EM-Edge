package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.ehis.util.*;

public final class __releasebeddetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ReleaseBedDetail.jsp", 1725436264661L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eIP/js/ReleaseBed.js\' language=\'javascript\'></script>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script language=javascript>\n\nasync function OnRemarks(bookingtype,bedbookingrefno)\n{\t\t\n\tvar retVal1;\n\tvar calling_from\t\t\t= \'ReleaseBedDetail\';\n\tvar arguments\t\t\t\t= \"\";\n\tvar facilityid\t\t\t\t= \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\tvar dialogHeight\t\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t\t= \"50\" ;\n\tvar dialogTop\t\t\t\t= \"230\";\n\tvar dialogLeft\t\t\t\t= \"230\";\n\t\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\tretVal1\t\t\t\t\t\t= await window.showModalDialog(\"../../eIP/jsp/remarks.jsp?remarks=\"+calling_from+\"&facilityid=\"+facilityid+\"&bookrefno=\"+bedbookingrefno+\"&booking_type=\"+bookingtype,arguments,features);\n}\n\n</script>\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n</link>\n</head>\n<BODY  class=\'CONTENT\' onMouseDown=\'CodeArrest()\' OnKeyDown=\'CodeArrest();lockKey()\'  >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<form name=\"ReleaseBedDetail_Form\" id=\"ReleaseBedDetail_Form\" method=\'post\' >\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t           <input type=hidden name=\'pages\' id=\'pages\' value=\'multiple\'>\n\t\t           <input type=hidden name=\'totChecked\' id=\'totChecked\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n       ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<table width=\'100%\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<table border=\'0\' align=\'right\'>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<table border=\"1\" width=\"99%\" cellspacing=\'0\' cellpadding=\'0\' align=\"center\">\n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</th>\n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</th> <!--added by Mano aganist ML-MMOH-CRF-01052-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<tr><td class=\'CAGROUPHEADING\' colspan=13>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td></tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t<tr><td class=\'CAGROUPHEADING\' colspan=12>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td> <!--added by Mano aganist ML-MMOH-CRF-01052-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' nowrap>\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:OnRemarks(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' nowrap>&nbsp;\n\t\t\t\t\t\t\t\t\t<!--<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" this line comment for 17874 Tuesday, January 05, 2010-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' nowrap><input type=\'checkbox\'  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" name=\'select_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' nowrap><input type=\'checkbox\'   ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' onclick=\"checkbill(this,\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\"></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</table>\n\t\t  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<script>\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t<input type=\"hidden\" name=\"no_of_rec\" id=\"no_of_rec\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"hidden\" name=\"final_vals\" id=\"final_vals\" value=\"\">\n\t\t<input type=\"hidden\" name=\"sel_rec\" id=\"sel_rec\" value=\"\">\n\t\t<input type=hidden name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=hidden name=\'booking_type\' id=\'booking_type\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=hidden name=\'block_type\' id=\'block_type\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=hidden name=\'from_date\' id=\'from_date\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=hidden name=\'until_date\' id=\'until_date\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=hidden name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=hidden name=\'bed_class_code\' id=\'bed_class_code\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=hidden name=\'reservebedyn\' id=\'reservebedyn\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\t\t\n\t\t<input type=\'hidden\' name = \'locale\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">  \n\t\t<input type=\'hidden\' name = \'select_bed\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">  \n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}

	
	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultVal)	{
		return (inputString==null)	?	defaultVal	:	inputString;
	}


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

	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	String sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet releaseBedDetail= null;synchronized(session){
                releaseBedDetail=(webbeans.eCommon.RecordSet)pageContext.getAttribute("releaseBedDetail",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(releaseBedDetail==null){
                    releaseBedDetail=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("releaseBedDetail",releaseBedDetail,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String	 facilityId			= (String) session.getValue( "facility_id" ) ;
	String	 call_function		= checkForNull(request.getParameter("call_function"));
	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

	Connection con				= null ;
	ResultSet rset				= null ;
	PreparedStatement pstmt=null;
	con							= ConnectionManager.getConnection(request);
	String P_nursingunitcode	= checkForNull(request.getParameter("nursing_unit_code"));
	String P_bedclasscode		= checkForNull(request.getParameter("bed_class_code"));
	String P_bookingtype		= checkForNull(request.getParameter("booking_type"));
	String P_blocktype			= checkForNull(request.getParameter("block_type"));
	String P_fromdate			= checkForNull(request.getParameter("from_date"));
	String P_untildate			= checkForNull(request.getParameter("until_date"));
	String reserve_bed_on_tfr_yn= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"));
	String reservebed_yn		= checkForNull(request.getParameter("reservebedyn"));
	String select_bed			= checkForNull(request.getParameter("select_bed"));
	String bl_operational		= (String)session.getValue("bl_operational");
	P_nursingunitcode			= singleToDoubleQuotes(P_nursingunitcode);
	P_bedclasscode				= singleToDoubleQuotes(P_bedclasscode);
	P_bookingtype				= singleToDoubleQuotes(P_bookingtype);
	P_blocktype					= singleToDoubleQuotes(P_blocktype);
	String and_or_or			= " and ";
	StringBuffer sqlSb			= new StringBuffer();


	
	//sqlSb.append(" and facility_id='"+facilityId+"' and blocked_from_date_time <= SYSDATE ");
	/*Thursday, December 16, 2010 , SRR20056-SCF-6224 [IN:025500]*/
	sqlSb.append(" and facility_id='"+facilityId+"' ");

	if(!(P_nursingunitcode == null  || P_nursingunitcode.equals("")))
		sqlSb.append( " and req_nursing_unit_code = '"+P_nursingunitcode+"' ");

	if(!(P_bedclasscode == null  || P_bedclasscode.equals("")))
		sqlSb.append(" and req_bed_class_code = '"+P_bedclasscode+"' ");

	if(!(P_bookingtype == null  || P_bookingtype.equals("")))
	{
		//if(P_bookingtype.equals("T") && reservebed_yn.equals("Y"))
		/*5/5/2009 IN010339 SRR20056-SCF-2975*/
		if(P_bookingtype.equals("T") &&   (select_bed.equals("R") || select_bed.equals("A")))
			sqlSb.append( " and booking_type in ('N','T') ");
		else
			sqlSb.append( " and booking_type = '"+P_bookingtype+"' ");
	}

	if(!(P_blocktype == null  || P_blocktype.equals("")))
		sqlSb.append( " and blocking_type_code = '"+P_blocktype+"' ");

	if(!(P_fromdate == null  || P_fromdate.equals("")))
	{
		sqlSb.append( " and ( trunc(blocked_from_date_time) >= to_date('"+P_fromdate+"','dd/mm/rrrr')   ");
		/*Thursday, December 16, 2010 , SRR20056-SCF-6224 [IN:025500]*/
		sqlSb.append(" OR TO_DATE('"+P_fromdate+"', 'dd/mm/rrrr') BETWEEN TRUNC(blocked_from_date_time) AND TRUNC(blocked_until_date_time))");
			and_or_or=" and ";
	}

	if(!(P_untildate == null  || P_untildate.equals("")))
	{
		sqlSb.append( and_or_or+"  ( trunc(blocked_until_date_time) <= to_date('"+P_untildate+"','dd/mm/rrrr')   ");
		/*Thursday, December 16, 2010 , SRR20056-SCF-6224 [IN:025500]*/
		 sqlSb.append(" OR TO_DATE('"+P_untildate+"', 'dd/mm/rrrr') BETWEEN TRUNC(blocked_from_date_time) AND TRUNC(blocked_until_date_time))");
	}
		
	/*FS102IPSRRCRF0228V2.0 SCR-228 */	
		if(select_bed.equals("B"))
			{
				sqlSb.append("and booking_status = '0' and blocked_until_date_time > sysdate");
				/*Modified for IP-ICN-6903_Reopen*/
				sqlSb.append(" and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) > sysdate  ");
				/**/
				
			}else if(select_bed.equals("R"))
			{
				sqlSb.append(" and booking_status = '1'");
				sqlSb.append(" and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) > sysdate  ");
				
			}else if(select_bed.equals("A"))
			{
				sqlSb.append("and booking_status IN ('0','1') ");
				sqlSb.append(" and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) > sysdate  ");
			}
			


            _bw.write(_wl_block12Bytes, _wl_block12);

		String	req_start		= ""; 
		String  req_end			= "";
		String  checkedOnes		= "";
		String	from			= request.getParameter("from") ;
		String	to				= request.getParameter("to") ;
		int		start			= 0;
		int		end				= 0;
		int		i				= 1;
		int		initCount		= 1;
		int		records_to_show	= 12;

		String reserved_bed_charged="";

        if (from == null)
			{ start = 1 ; }  
		else
			{  start = Integer.parseInt( from ) ; }

        if (to == null)
			{ end = 12 ; }
		else 
			{  end = Integer.parseInt( to ) ; }

        req_start				=   checkForNull(request.getParameter("start"),"0");
        req_end					=   checkForNull(request.getParameter("end"),"0");
			

		String classValue		= "" ;
		String next				= "";
		String prev				= "";
		
		try
		{
			String flagSelect	= checkForNull(request.getParameter("fromSelect"));
			        
			if(!flagSelect.equals(""))
				releaseBedDetail.clearAll();
		
			if(from != null && to != null)
			{
				int j			= 0;
				for( i=(Integer.parseInt(req_start)); i<= (Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("select_"+(i)) != null)
					{
						checkedOnes = request.getParameter("select_"+(i));
						if(!(releaseBedDetail.containsObject(checkedOnes)))
							releaseBedDetail.putObject(checkedOnes);

						j++;
					}
				}
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(j));
            _bw.write(_wl_block14Bytes, _wl_block14);
 }
        		i = 1 ;

		StringBuffer sql_count = new StringBuffer();
//		stmt					= con.createStatement(); Commented On 6/1/2010 for PE
		if (sql_count.length() > 0){ 
			sql_count.delete(0,sql_count.length());
		}
		
		sql_count.append(" SELECT " ); 
		sql_count.append("	 a.PATIENT_ID");
		sql_count.append("  ,decode(?,?,b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name");
		sql_count.append("  ,ENCOUNTER_ID " );
		sql_count.append("  ,req_bed_no " );
		sql_count.append("  ,req_room_no " );
		sql_count.append("  ,IP_GET_DESC.IP_BED_CLASS(REQ_BED_CLASS_CODE,?,'2') bed_class_desc ");
		sql_count.append("  ,IP_GET_DESC.IP_BLOCKING_TYPE(BLOCKING_TYPE_CODE,?,'2') blocking_type_desc ");
		sql_count.append("  ,TO_CHAR(blocked_from_date_time,'dd/mm/rrrr hh24:mi') blocked_from_date_time ");
		sql_count.append("  ,TO_CHAR(blocked_until_date_time,'dd/mm/rrrr hh24:mi') blocked_until_date_time ");
		sql_count.append("  ,blocking_remarks ");
		sql_count.append("  ,blocking_type_code ");
		sql_count.append("  ,bed_booking_ref_no ");
		sql_count.append("  ,booking_type ");
		sql_count.append("  ,req_bed_type_code ");
		sql_count.append("  ,req_nursing_unit_code ");
		sql_count.append("  ,IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, REQ_NURSING_UNIT_CODE,?,'2') nursing_unit_desc, sm_get_desc.sm_appl_user (a.modified_by_id,'en',1)blocked_by ");
/*FS102IPSRRCRF0228V2.0 SCR-228 */
		if(bl_operational.equals("Y")){
			sql_count.append("  ,BLCORE.RESERVED_BED_CHARGED(a.facility_id,a.patient_id,'I',a.encounter_id,(select srl_no from ip_reserved_bed_dtl where encounter_id = a.encounter_id AND facility_id = a.facility_id and reserved_nursing_unit_code = a.req_nursing_unit_code and reserved_bed_no = a.req_bed_no and reserved_to_time is null ),a.req_bed_type_code) reserved_bed_charged ");
		}
		sql_count.append(" FROM ");
		sql_count.append("  IP_BED_BOOKING a,MP_PATIENT b ");
		sql_count.append(" WHERE a.PATIENT_ID=b.PATIENT_ID(+)  and booking_type IN ('B','D','T','N') "+sqlSb.toString()+"  ");
		sql_count.append(" order by ");
		sql_count.append("  nursing_unit_desc ");
		sql_count.append("  , req_bed_no ");
//out.println(""+sql_count.toString());
		pstmt = con.prepareStatement(sql_count.toString());
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		rset = pstmt.executeQuery();

		if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rset.next() ;
			}
			initCount+=start;
			--initCount;
		}

		int z=0;
		int maxRecord = 0;
		while((z < records_to_show) && rset.next() ){
				if(maxRecord==0) {
            _bw.write(_wl_block15Bytes, _wl_block15);

											if ( !(start <= 1))
											//{
											out.println("<td align='right' id='prev' width='100%'><a href='../../eIP/jsp/ReleaseBedDetail.jsp?from="+(start-12)+"&to="+(end-12)+"&select_bed="+select_bed+"&call_function="+call_function+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
											//}else{
											out.println("<td align='right' id='next' style='visibility:hidden' ><a id = 'nextval' href='../../eIP/jsp/ReleaseBedDetail.jsp?from="+(start+12)+"&to="+(end+12)+"&select_bed="+select_bed+"&call_function="+call_function+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
											//}
											
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!call_function .equals("QBB") ){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}
				}
							String chkAttribute	=	"";
							z++;
							if ( i % 2 == 0 ){
								classValue	= "QRYEVENSMALL" ;
							}else{
								classValue	= "QRYODDSMALL" ;
							}
							String patientid				= checkForNull(rset.getString("PATIENT_ID"),"&nbsp;");
							String patientname		= checkForNull(rset.getString("patient_name"),"&nbsp;");
							String encounterid			= checkForNull(rset.getString("ENCOUNTER_ID"),"&nbsp;");
							String encounterid_select		= checkForNull(rset.getString("ENCOUNTER_ID"),"null");
							String reqbedno			= checkForNull(rset.getString("req_bed_no"));     
							String reqroomno			= checkForNull(rset.getString("req_room_no"));     
							String reqnursingunitcode	= checkForNull(rset.getString("req_nursing_unit_code"));     
							String bedclassdesc			= checkForNull(rset.getString("bed_class_desc"));
							String blockingtypedesc	= checkForNull(rset.getString("blocking_type_desc"),"&nbsp;");
							String blockedfromdatetime	= checkForNull(rset.getString("blocked_from_date_time"));     
							String blockeduntildatetime	= checkForNull(rset.getString("blocked_until_date_time"));     
							String blockingremarks			= checkForNull(rset.getString("blocking_remarks"));
							String bedbookingrefno			= checkForNull(rset.getString("bed_booking_ref_no"));
							String bookingtypedesc			= checkForNull(rset.getString("booking_type"),"&nbsp");
							//String req_bed_type_code		= checkForNull(rset.getString("req_bed_type_code"),"");
							/*FS102IPSRRCRF0228V2.0 SCR-228 */
							String blockedby             = checkForNull(rset.getString("blocked_by"),""); /* added by Mano aganist ML-MMOH-CRF-01052 */
							if(bl_operational.equals("Y")){
								reserved_bed_charged            = checkForNull(rset.getString("RESERVED_BED_CHARGED"),"");
							}
							if(bookingtypedesc.equals("N")){
								select_bed	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reserved.label","common_labels");
							}else {
								select_bed	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.blocked.label","common_labels");
							}
							if(bookingtypedesc.equalsIgnoreCase("D")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("T")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("B")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockingFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("N")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("L")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferFunction.label","ip_labels");
							}
							String bookingtype		= checkForNull(rset.getString("booking_type")); 
							String nursingunitdesc	= checkForNull(rset.getString("nursing_unit_desc"));
							String selectvalue			= bookingtype+"`"+bedbookingrefno+"`"+encounterid_select+"`"+reqbedno+"`"+reqnursingunitcode;
							next								= nursingunitdesc;
							String blok_date_fr_display		= checkForNull(DateUtils.convertDate(blockedfromdatetime,"DMYHM","en",locale),"&nbsp;");
							String blok_date_until_display	= checkForNull(DateUtils.convertDate(blockeduntildatetime,"DMYHM","en",locale),"&nbsp;");
							if(blockeduntildatetime==null || blockeduntildatetime.equals("")){
								blok_date_until_display		= "&nbsp;";
							}
							if(releaseBedDetail.containsObject(selectvalue)){
								chkAttribute		= "CHECKED";
							}else{
								chkAttribute		= "";
							}
							int recordIndex		= releaseBedDetail.indexOfObject(selectvalue);
							if(recordIndex!=-1)
							if(chkAttribute.equals("CHECKED"))   
							releaseBedDetail.removeObject(recordIndex);
							if(!next.equals(prev) && reserve_bed_on_tfr_yn .equals("Y") ) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(next));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else if(!next.equals(prev)){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(next));
            _bw.write(_wl_block23Bytes, _wl_block23);
 }
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(select_bed));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(reqbedno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(reqroomno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bedclassdesc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(blockingtypedesc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bookingtypedesc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(blok_date_fr_display));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(blok_date_until_display));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(blockedby));
            _bw.write(_wl_block28Bytes, _wl_block28);
  
								//	if(!blockingremarks.equals("")){ Commented and added below code for IN023630 on 03.08.2010 by Suresh M
									if(!blockingremarks.equals("") && !select_bed.equals("Reserved")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bookingtype));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bedbookingrefno));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}
								if(!call_function .equals("QBB") ){ 	//if(!blockeduntildatetime.equals("")){
									if(select_bed.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.blocked.label","common_labels"))){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(selectvalue));
            _bw.write(_wl_block40Bytes, _wl_block40);
}else if((!reserved_bed_charged.equals(""))||(!reserved_bed_charged.equals("null"))){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(selectvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reserved_bed_charged));
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(selectvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
}}
            _bw.write(_wl_block45Bytes, _wl_block45);

				prev = next;
				i++;
				maxRecord++;
			}//endwhile
			
            _bw.write(_wl_block46Bytes, _wl_block46);
//}
			if(maxRecord<12 || (!rset.next()))
			{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
			else
			{
            _bw.write(_wl_block48Bytes, _wl_block48);
}

			if(maxRecord==0)
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");

		}catch(Exception e){
			e.printStackTrace();
		}	
		finally {
			    try{
					if(pstmt!=null) pstmt.close();
					if(rset!=null) 	rset.close();
					
				}catch(Exception e){}
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("releaseBedDetail", releaseBedDetail);
				out.print("<script>parent.frames[0].document.forms[0].search.disabled=false</script>");
		}
	
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(start));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(end));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(start));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(end));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(P_nursingunitcode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(P_bookingtype));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(P_blocktype));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(P_fromdate));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(P_untildate));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(P_bedclasscode));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(reservebed_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(select_bed));
            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedstatus.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockType.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforReserveBed.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockedThrough.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockedFrom.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.blockeduntil.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockedBy.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }
}
