package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbilldetailsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillDetailsMain.jsp", 1709723694849L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n\t<TITLE>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</TITLE>\n\t<!--\n\t<LINK rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK>\n\t-->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n</HEAD>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!--\n\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n \t\n\t<iframe SRC= \"../../eBL/jsp/BLBillDetails.jsp?insind=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&baseqty=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&basechargeamt=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&baserate=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&grosschargeamt=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&discountper=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&discountamt=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&daytypecode=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&daytypedesc=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&timetypecode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&timetypedesc=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&addlfactor=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&patgrosschargeamt=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&patdiscamt=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&patnetamt=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&custgrosschargeamt=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&custdiscamt=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&custnetamt=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&ordercatalogcode=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&ordercatalogdesc=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&blngservcode=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&blngservdesc=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&blngrule=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&netchargeamt=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" NAME=\"TabFrame\" noresize scrolling=\"yes\" style=\"height:15vh;width:100vw\"></iframe>\n\t<iframe SRC=\"../../eCommon/html/blank.html\"\tname=\"ValidationFrame\" id=\"ValidationFrame\" noresize scrolling=\"NO\" style=\"height:0vh;width:100vw\"></iframe>\t\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</HTML>\n\n";
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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs =null, rs1 = null;
	String strfacilityid	=  ""; 

	//unused variable, commented on 09/06/05
	//String strloggeduser	=  "";
	String strblngrule   = "N";
	int		noofdecimal = 2;
	request.setCharacterEncoding("UTF-8");
	try{	// Added in Bangalore on 13/10/2005	
	con					=	ConnectionManager.getConnection(request);
	strfacilityid		=  (String) session.getValue("facility_id");
	//strloggeduser		=  (String) session.getValue("login_user");

	String strinsind		   = request.getParameter("insind");		
	String strbaseqty	       = request.getParameter("baseqty");
	String strbasechargeamt    = request.getParameter("basechargeamt");
	String strbaserate		   = request.getParameter("baserate");
	String strgrosschargeamt   = request.getParameter("grosschargeamt");
	String strdiscountper	   = request.getParameter("discountper");
	String strdiscountamt      = request.getParameter("discountamt");
	String strdaytypecode      = request.getParameter("daytypecode");
	String strdaytypedesc      = request.getParameter("daytypedesc");
	String strtimetypecode     = request.getParameter("timetypecode");
	String strtimetypedesc     = request.getParameter("timetypedesc");
	String straddlfactor       = request.getParameter("addlfactor");	

	String strpatgrosschargeamt = request.getParameter("patgrosschargeamt");	
	String strpatdiscamt = request.getParameter("patdiscamt");	
	String strpatnetamt = request.getParameter("patnetamt");	
	String strcustgrosschargeamt = request.getParameter("custgrosschargeamt");	
	String strcustdiscamt = request.getParameter("custdiscamt");	
	String strcustnetamt = request.getParameter("custnetamt");	

	String strordercatalogcode = request.getParameter("ordercatalogcode");	
	String strordercatalogdesc = request.getParameter("ordercatalogdesc");	
	String strblngservcode = request.getParameter("blngservcode");	
	String strblngservdesc = request.getParameter("blngservdesc");	
	String strnetchargeamt = request.getParameter("netchargeamt");

	if (strinsind == null)  strinsind = "";
	if (strbaseqty == null) 	strbaseqty = "";
	if (strbasechargeamt == null)  strbasechargeamt = "";
	if (strbaserate == null ) strbaserate = "";
	if (strgrosschargeamt == null ) strgrosschargeamt = "";
	if (strdiscountper == null ) strdiscountper = "";
	if (strdiscountper == null) strdiscountper = "";
	if (strdiscountamt == null ) strdiscountamt = "";
	if (strdaytypecode==null) strdaytypecode = "";
	if (strdaytypedesc==null) strdaytypedesc="";
	if (strtimetypecode == null ) strtimetypecode = "";
	if ( strtimetypedesc == null ) strtimetypedesc ="";
	if ( straddlfactor == null ) straddlfactor ="";
	if ( strpatgrosschargeamt == null ) strpatgrosschargeamt ="";	
	if ( strpatdiscamt == null ) strpatdiscamt = "";
	if ( strpatdiscamt == null ) strpatdiscamt ="";
	if ( strpatnetamt == null ) strpatnetamt ="";
	if (strcustgrosschargeamt == null ) strcustgrosschargeamt = "";
	if ( strcustgrosschargeamt == null ) strcustgrosschargeamt ="";
	if ( strcustdiscamt  == null ) strcustdiscamt = "";
	if ( strcustnetamt == null ) strcustnetamt = "";


	if ( strordercatalogcode == null ) strordercatalogcode = "";
	if ( strordercatalogdesc == null) strordercatalogdesc ="";
	if ( strblngservcode == null ) strblngservcode = "";
	if ( strblngservdesc == null ) strblngservdesc = "";	
	if ( strnetchargeamt == null ) strnetchargeamt = "";




	if (strinsind == null || strinsind == ""  )
		strinsind = "Y";

    if (strbaseqty == null || strbaseqty == ""  )
		strbaseqty = "1.00";

	if (straddlfactor == null || straddlfactor == ""  )
		straddlfactor = "1.0000";	

    if (strdaytypecode == null)
		strdaytypecode = "";

    if (strdaytypedesc == null)
		strdaytypedesc = "";

    if (strtimetypecode == null)
		strtimetypecode = "";

    if (strtimetypedesc == null)
		strtimetypedesc = "";

	try
	{		
  		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from sm_acc_entity_param");
		
		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
			noofdecimal  =  rs.getInt(1);			
	}
	catch(Exception e) {out.println(e.toString());}

	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 		
	}	


	try
	{		
  		pstmt = con.prepareStatement( " select nvl(blng_class_pricing_rule,'N') from bl_parameters where operating_facility_id = '"+strfacilityid+"'");
		
		rs1 = pstmt.executeQuery();	
		if ( rs1.next() && rs1 != null ) 
			strblngrule  =  rs1.getString(1);			
	}
	catch(Exception e) {out.println(e.toString());}

	finally 
	{
		if (rs1 != null)   rs1.close();
		if (pstmt != null) pstmt.close();		 		
	}	

	if ( strblngrule == null ) strblngrule = "";

	
	CurrencyFormat cf = new CurrencyFormat();
	
	strbaserate		  = cf.formatCurrency(strbaserate, noofdecimal);	
	strbasechargeamt  = cf.formatCurrency(strbasechargeamt, noofdecimal);	
	strgrosschargeamt = cf.formatCurrency(strgrosschargeamt, noofdecimal);		
	strdiscountamt    = cf.formatCurrency(strdiscountamt, noofdecimal);	
	strbaseqty        = cf.formatCurrency(strbaseqty,2);	
    strdiscountper    = cf.formatCurrency(strdiscountper,2);	
	straddlfactor     = cf.formatCurrency(straddlfactor,4);	

	strnetchargeamt		  = cf.formatCurrency(strnetchargeamt, noofdecimal);	

	if (strinsind.equals("Y"))
		{
			strpatgrosschargeamt    = cf.formatCurrency(strpatgrosschargeamt, noofdecimal);	
			strpatdiscamt			= cf.formatCurrency(strpatdiscamt, noofdecimal);	
			strpatnetamt			= cf.formatCurrency(strpatnetamt, noofdecimal);	

			strcustgrosschargeamt   = cf.formatCurrency(strcustgrosschargeamt, noofdecimal);	
			strcustdiscamt			= cf.formatCurrency(strcustdiscamt, noofdecimal);	
			strcustnetamt			= cf.formatCurrency(strcustnetamt, noofdecimal);	
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strinsind));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strbaseqty));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbasechargeamt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbaserate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strgrosschargeamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strdiscountper));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strdiscountamt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strdaytypecode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strdaytypedesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strtimetypecode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strtimetypedesc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(straddlfactor));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strpatgrosschargeamt));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strpatdiscamt));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strpatnetamt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strcustgrosschargeamt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strcustdiscamt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strcustnetamt));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strordercatalogcode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(strordercatalogdesc)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strblngservcode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(strblngservdesc)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strblngrule));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strnetchargeamt));
            _bw.write(_wl_block33Bytes, _wl_block33);
	
	// commented in Bangalore on 13/10/2005
	//ConnectionManager.returnConnection(con, request);			
	}catch(Exception e){
		out.println(e.toString());
	}finally{  // Added in Bangalore on 13/10/2005
		if(con!=null){
			ConnectionManager.returnConnection(con, request);		
		}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingDetails.label", java.lang.String .class,"key"));
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
}
