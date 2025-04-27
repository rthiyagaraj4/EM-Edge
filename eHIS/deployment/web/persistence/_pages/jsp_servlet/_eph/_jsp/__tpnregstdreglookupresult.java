package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __tpnregstdreglookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNRegStdRegLookupResult.jsp", 1709121529701L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n/* \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\n06/02/2017      IN68728            Devindra          ML-MMOH-CRF-1266 [IN:068728]   \n---------------------------------------------------------------------------------------------------------------\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n<html>\n\n<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- \t\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/TPNStdRegimen.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<!--<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">-->\n<!-- <body> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t <table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr>\n\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t<td width=\"20%\" class=\"white\">&nbsp; \n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td></tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t<tr> <th colspan=4>&nbsp;</th><th colspan=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th><th colspan=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" align=\'center\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th><th colspan=1 >&nbsp;</th></tr>\n\t\t<tr><th  style=\"width:5%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t<th  style=\"width:60%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t<th style=\"width:10%\" colspan=2>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t    \n\t   ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t        <th style=\"width:5%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t      ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t        <th style=\"width:5%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t   \n\t   ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t    ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t     ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<th style=\"width:5%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t\t<th style=\"width:5%\"></th></tr> \n\t\t<tr>\n\t\t<td>&nbsp;</td>\n\t\t<td style=\"font-weight:bold;padding-right: 35%;\" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t<TD style=\"font-weight:bold;padding-right: 5%;\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</TD>\n\t\t<TD style=\"font-weight:bold;padding-right: 6%;\" >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</TD>\n\t\t<TD style=\"font-weight:bold;padding-right: 9%;\" align=\'left\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</TD>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\n\t     <TD style=\"font-weight:bold;padding-right: 9%;\" align=\'left\'>0</TD>\n\t    ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<TD style=\"font-weight:bold;padding-right: 9%;\" align=\'left\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<TD style=\"font-weight:bold\" align=\'left\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</TD>\n\t\t<td style=\"font-weight:bold;padding-right: 10%\">&nbsp;</td>\n         </tr>\n\t\t ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t \n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t<tr> <th colspan=4 >&nbsp;</th><th colspan=3 >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</th><th colspan=4 align=\'center\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</th><th colspan=1 >&nbsp;</th></tr>\n\t\t <tr><th  style=\"width:5 %\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t\t <th  style=\"width:30%\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th>\n\t\t<th style=\"width:5%\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="CHO</th>\n\t\t<th style=\"width:5%\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</th>\n\t\t<th style=\"width:5%\"> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n\t\t<th style=\"width:5%\"></th></tr> \n\t\t<tr>\n\t\t<td>&nbsp;</td>\n\t\t<td style=\"font-weight:bold\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t<TD style=\"font-weight:bold\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</TD>\n\t\t<TD style=\"font-weight:bold\" nowrap >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</TD>\n\t\t<TD style=\"font-weight:bold\" align=\'right\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</TD>\n\t\t<td style=\"font-weight:bold\">&nbsp;</td>\n         </tr>         \n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<tr >\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t</table>\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));history.go(-1);</script>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


public String roundTwoDigits(String a)
{
	try
	{
		
		String bb = "";
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}
			else
			{   
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3)
				{
					bb=a.substring(0,a.indexOf(".")+3);
				}
				else
				{
					bb=a;
				}
			
			}
			return bb;
	}
	catch (Exception e)
	{
			return a;
			
	}
}



public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\">";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id          = (String)session.getValue( "facility_id" );
//out.println("TPNRegStdRegLookupResult.jsp--->" );

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);

	//Search Criteria's from Query Criteria page
	String regname			= request.getParameter( "regname" );
	String searchpos		= request.getParameter( "searchpos" );
	String chofrom			= request.getParameter( "chofrom" );
	String choto			= request.getParameter( "choto" );
	String proteinfrom		= request.getParameter( "proteinfrom" );
	String proteinto		= request.getParameter( "proteinto" );
	String lipidfrom		= request.getParameter( "lipidfrom" );
	String lipidto			= request.getParameter( "lipidto" );
	String eml_type			= request.getParameter( "eml_type" );
	String cho_energy		= request.getParameter("cho_energy");
	String pro_energy		= request.getParameter("pro_energy");
	String lipd_energy		= request.getParameter("lipd_energy");
	String cho_qty			= request.getParameter("cho_qty");
	String pro_qty			= request.getParameter("pro_qty");
	String lipd_qty			= request.getParameter("lipd_qty");
	String fluid			= request.getParameter("fluid");
	String unit				= request.getParameter("unit");
		 //  unit				= unit.substring(0,(unit.indexOf("/"))) ;
	String fluidunit		= request.getParameter("fluidunit");
	String assmnt_total		= (Integer.parseInt(cho_energy))+(Integer.parseInt(pro_energy))+(Integer.parseInt(lipd_energy))+"";
   	String sqlappend		= "";
    String queryString		= request.getQueryString();

	String basedOnAssmntValues		= request.getParameter( "basedOnAssmntValues" );    
	String displayRecords			= request.getParameter( "displayRecords" ); 
	String CHO						= request.getParameter( "CHO" ) ;    
	String PROTEIN					= request.getParameter( "PROTEIN" );      
	String LIPID					= request.getParameter( "LIPID" )  ;

	String CHO_PER					= request.getParameter( "CHO_PER" );    
	String PROTEIN_PER				= request.getParameter( "PROTEIN_PER" );      
	String LIPID_PER				= request.getParameter( "LIPID_PER" )== "" ? "0":request.getParameter( "LIPID_PER" );
	if(basedOnAssmntValues.equals("Y")){
		chofrom  = (Integer.parseInt(CHO)-Integer.parseInt(CHO_PER))+""; 
		choto	 = (Integer.parseInt(CHO)+Integer.parseInt(CHO_PER))+""; 

		proteinfrom  = (Integer.parseInt(PROTEIN)-Integer.parseInt(PROTEIN_PER))+""; 
		proteinto	 = (Integer.parseInt(PROTEIN)+Integer.parseInt(PROTEIN_PER))+""; 

		lipidfrom  = (Integer.parseInt(LIPID)-Integer.parseInt(LIPID_PER))+""; 
		lipidto	 = (Integer.parseInt(LIPID)+Integer.parseInt(LIPID_PER))+""; 
	}

//	String Rf_Name		= request.getParameter( "RFName" ) ;
//	String Drug_Code		= request.getParameter( "DrugCode" ) ;
//	String Drug_Desc		= request.getParameter( "DrugName" ) ;

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	String bean_id	= "TPNStandardRegimenBean";
	String bean_name	 = "ePH.TPNStandardRegimenBean";
	TPNStandardRegimenBean bean = (TPNStandardRegimenBean)getBeanObject(bean_id, bean_name,request);
	ArrayList generics=bean.getTPNGenerics("EL");
	ArrayList energyConst = bean.getTPNConstEnrg("MN");  // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	String select_energy_const_weight_query = "";
	String select_energy_const_energy_query = "";
	String where_clause_query = "";
	String energy_const_code ="";
	String energy_const_name ="";
	ArrayList displayFieldsConstWeight = new ArrayList();
	ArrayList displayFieldsConstEnergy = new ArrayList();
	ArrayList energyConstName = new ArrayList();
	ArrayList energyConstcode = new ArrayList();
	ArrayList columnHeader   = new ArrayList();
	Connection con			= null;
	boolean macro_nutrients_not_mnd_yn = false;
	boolean tpn_tab_reg = false;//ML-MMOH-CRF-1290
        try{
	   con				= ConnectionManager.getConnection(request);    
           macro_nutrients_not_mnd_yn = CommonBean.isSiteSpecific(con, "PH", "MACRO_ENTERABLE_YN");
           tpn_tab_reg          =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","INSTRUCTIONS_REQUIRED_YN");//ADDED FOR ML-MMOH-CRF-1290
        }
	 catch(Exception e){
		e.printStackTrace();
	 }
	 finally{
		if(con != null){
		   ConnectionManager.returnConnection(con,request);
		}
	 }
         for(int i=0;i<energyConst.size();i=i+2){
    	 
    	 energy_const_code = "";
    	 
    	 energy_const_name = "";
    	 
    	 energy_const_code = CommonBean.checkForNull((String)energyConst.get(i));
    	 
    	 energy_const_name = CommonBean.checkForNull((String)energyConst.get(i+1));
    	 
    	 energyConstName.add(energy_const_name);
    	 energyConstcode.add(energy_const_code);
    	 
    	 displayFieldsConstWeight.add("const_weight_"+energy_const_code);
    	 
    	 displayFieldsConstEnergy.add("const_energy_"+energy_const_code);
    	 
    	 columnHeader.add(energy_const_code);
    	    	   
    	 select_energy_const_weight_query = select_energy_const_weight_query+",(SELECT const_weight FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + "AND tpn_regimen_code = a.tpn_regimen_code) const_weight_"+energy_const_code;
    	 
    	 select_energy_const_energy_query = select_energy_const_energy_query+",(SELECT const_weight FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND tpn_regimen_code = a.tpn_regimen_code) * (SELECT energy_rel_value FROM ph_tpn_energy_for_const WHERE constituent_code = "+"'"+energy_const_code+"'"+") const_energy_"+energy_const_code;
         
    	 if(i==0){
    		 if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && (energy_const_code.equals("CHO") || energy_const_code.equals("PROTEIN"))){
    		   where_clause_query = where_clause_query+"a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000))";
    		 }
    		 else if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && energy_const_code.equals("LIPID")){
      		   where_clause_query = where_clause_query+"a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000) AND NVL (emulsion_type, '%') LIKE DECODE (?, 'A', '%', ?))";
      		 }
    		 else{
    		   where_clause_query = where_clause_query+"a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL ('', 0) AND NVL ('', 100000))";
    		 }
         }
         else{
        	 if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && (energy_const_code.equals("CHO") || energy_const_code.equals("PROTEIN"))){
    	       where_clause_query = where_clause_query+" or a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000))";
        	 }
        	 else if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && energy_const_code.equals("LIPID")){
      	       where_clause_query = where_clause_query+" or a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000)AND NVL (emulsion_type, '%') LIKE DECODE (?, 'A', '%', ?))";
          	 }
        	 else{
        		 where_clause_query = where_clause_query+" or a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL ('', 0) AND NVL ('', 100000))";
        	 }
         }
        } // Added for ML-MMOH-CRF-1266 [IN:068728] - End
    

try{
	if (generics.size()>0)
	{
		for (int i=0;i<generics.size();i++)
		{
		String code=(String)generics.get(i);	
		String val	=request.getParameter(code);
		if  ( val!=null && !val.equals("") && !val.equals("0") )
		{
			sqlappend+=" AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='"+code+"' AND  CONST_WEIGHT ="+val +")";
		
		}
		}

	}
	
	
	
	String classvalue			= "";

	regname = CommonBean.checkForNull( regname );
	searchpos = CommonBean.checkForNull( searchpos );
	if ( searchpos.equals("sw"))
	{
		regname=regname+"%"	;
		
	}
	else
	{
			regname="%"+regname+"%"	;
	}


//	Drug_Code = CommonBean.checkForNull( Drug_Code );
//	Drug_Desc = CommonBean.checkForNull( Drug_Desc );

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//out.println(PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT2"));
	
	//Function Parameters
	HashMap funcMap = new HashMap();
	//String SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT, (SELECT CONST_WEIGHT  FROM    PH_CONST_FOR_TPN_REGIMEN WHERE     CONST_GENERIC_CODE='CHO' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    CHO, (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN        WHERE CONST_GENERIC_CODE='PROTEIN' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    PROTEIN,      (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN    WHERE CONST_GENERIC_CODE='LIPID' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    LIPID,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'CHO' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'CHO'  )) CHO_KCAL, ((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'PROTEIN' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'PROTEIN'  )) PROTEIN_KCAL,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN  WHERE CONST_GENERIC_CODE = 'LIPID' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM  PH_TPN_ENERGY_FOR_CONST  WHERE CONSTITUENT_CODE = 'LIPID'  ))  LIPID_KCAL     FROM    PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='CHO' AND   CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='PROTEIN' AND  CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='LIPID'  AND CONST_WEIGHT   BETWEEN NVL(?,0) AND   NVL(?,100000) AND NVL(emulsion_type,'%') LIKE  DECODE(?,'A','%',?))  AND A.LANGUAGE_ID = ?";

	//SRR20056-SCF-7808 - chandrasekhar
	//String SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT, (SELECT CONST_WEIGHT  FROM    PH_CONST_FOR_TPN_REGIMEN WHERE     CONST_GENERIC_CODE='CHO' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    CHO, (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN        WHERE CONST_GENERIC_CODE='PROTEIN' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    PROTEIN,      (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN    WHERE CONST_GENERIC_CODE='LIPID' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    LIPID,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'CHO' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'CHO'  )) CHO_KCAL, ((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'PROTEIN' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'PROTEIN'  )) PROTEIN_KCAL,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN  WHERE CONST_GENERIC_CODE = 'LIPID' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM  PH_TPN_ENERGY_FOR_CONST  WHERE CONSTITUENT_CODE = 'LIPID'  ))  LIPID_KCAL     FROM    PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='CHO' AND   CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='PROTEIN' AND  CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='LIPID'  AND CONST_WEIGHT   BETWEEN NVL(?,0) AND   NVL(?,100000) AND NVL(emulsion_type,'%') LIKE  DECODE(?,'A','%',?))  AND A.LANGUAGE_ID = ?"; // Added for ML-MMOH-CRF-1266 [IN:068728] - Start

	String SQL_PH_TPN_STD_REGIMEN_SELECT2 = ""; 
	 
	if(macro_nutrients_not_mnd_yn){ 
	  SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT"+select_energy_const_weight_query + select_energy_const_energy_query+" FROM  PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND ("+ where_clause_query +") AND A.LANGUAGE_ID = ?";	
	} 
	else{		
	  SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT, (SELECT CONST_WEIGHT  FROM    PH_CONST_FOR_TPN_REGIMEN WHERE     CONST_GENERIC_CODE='CHO' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    CHO, (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN        WHERE CONST_GENERIC_CODE='PROTEIN' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    PROTEIN,      (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN    WHERE CONST_GENERIC_CODE='LIPID' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    LIPID,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'CHO' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'CHO'  )) CHO_KCAL, ((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'PROTEIN' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'PROTEIN'  )) PROTEIN_KCAL,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN  WHERE CONST_GENERIC_CODE = 'LIPID' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM  PH_TPN_ENERGY_FOR_CONST  WHERE CONSTITUENT_CODE = 'LIPID'  ))  LIPID_KCAL     FROM    PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='CHO' AND   CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='PROTEIN' AND  CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='LIPID'  AND CONST_WEIGHT   BETWEEN NVL(?,0) AND   NVL(?,100000) AND NVL(emulsion_type,'%') LIKE  DECODE(?,'A','%',?))  AND A.LANGUAGE_ID = ?";
	} // Added for ML-MMOH-CRF-1266 [IN:068728] - End


	//AND eff_status = 'E') AND system_created_yn = 'N'   AND UPPER(A.LONG_NAME) LIKE UPPER(?)     AND a.tpn_regimen_code = b.tpn_regimen_code(+)   AND   b.const_generic_code(+)  ='CHO'  AND b.const_generic_code(+) = 'PROTEIN'    AND  b.const_generic_code(+) ='LIPID' AND const_weight(+) BETWEEN NVL ('', 0) AND NVL ('', 100000)  AND A.LANGUAGE_ID = ?";


	String sql=SQL_PH_TPN_STD_REGIMEN_SELECT2+sqlappend;
	
//	String sql=PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT2")+sqlappend;
	
//	out.println(sql);

	sqlMap.put( "sqlData", sql);

	ArrayList displayFields = new ArrayList();
	displayFields.add( "TPN_REGIMEN_CODE" );
	displayFields.add( "LONG_NAME" );
	displayFields.add( "TOTAL_VOLUME" );
	displayFields.add( "PRES_BASE_UNIT" );
 if(macro_nutrients_not_mnd_yn){ // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	displayFields.addAll(displayFieldsConstWeight);
	displayFields.addAll(displayFieldsConstEnergy);
 } // Added for ML-MMOH-CRF-1266 [IN:068728] - End
 else{
	displayFields.add( "CHO" );
	displayFields.add( "PROTEIN" );
	displayFields.add( "LIPID" );
	displayFields.add( "CHO_KCAL" );
	displayFields.add( "PROTEIN_KCAL" );
	displayFields.add( "LIPID_KCAL" );
 }
	ArrayList chkFields = new ArrayList();

  chkFields.add( regname);
  
  if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y")){	
	
	for(int j=0;j<energyConstcode.size();j++){
		if(((String)energyConstcode.get(j)).equals("CHO")){
			chkFields.add( chofrom);
			chkFields.add( choto);			
		}
		else if(((String)energyConstcode.get(j)).equals("PROTEIN")){
			chkFields.add( proteinfrom);
			chkFields.add( proteinto);			
		}
		else if(((String)energyConstcode.get(j)).equals("LIPID")){
			chkFields.add( lipidfrom);
			chkFields.add( lipidto);  
			chkFields.add( eml_type);
			chkFields.add( eml_type);			
		}
	}
  }
  else if(!macro_nutrients_not_mnd_yn){
	  chkFields.add( chofrom);
	  chkFields.add( choto);
	  chkFields.add( proteinfrom);
	  chkFields.add( proteinto);
	  chkFields.add( lipidfrom);
	  chkFields.add( lipidto);  
	  chkFields.add( eml_type);
	  chkFields.add( eml_type);
  }
	chkFields.add( locale);

//	chkFields.add( Rf_Id.trim() + "%" );
//	chkFields.add( Rf_Name.trim() + "%" );
	
	

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	
	if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")))){ // (result.size()>=3) changed to (result.size()>3) for ML-MMOH-CRF-1266 [IN:068728]
		
            _bw.write(_wl_block10Bytes, _wl_block10);

		// For display the previous/next link
		out.println(result.get(1));
	
            _bw.write(_wl_block11Bytes, _wl_block11);
if(macro_nutrients_not_mnd_yn){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(energyConstName.size()));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(unit));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(energyConstName.size()+1));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 for(int j=0;j<energyConstName.size();j++){	
	       if(j==0){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(energyConstName.get(j)));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{ 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(energyConstName.get(j)));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
	     }
            _bw.write(_wl_block24Bytes, _wl_block24);
for(int j=0;j<energyConstName.size();j++){
	      if(j==0){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(energyConstName.get(j)));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{ 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(energyConstName.get(j)));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
	     }
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fluid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,fluidunit))));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cho_qty));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pro_qty));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lipd_qty));
            _bw.write(_wl_block32Bytes, _wl_block32);
 for(int j=3;j<energyConstName.size();j++){
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(cho_energy));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pro_energy));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lipd_energy));
            _bw.write(_wl_block32Bytes, _wl_block32);
 for(int j=3;j<energyConstName.size();j++){
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(roundTwoDigits(assmnt_total)));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(unit));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fluid));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,fluidunit))));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cho_qty));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pro_qty));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(lipd_qty));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cho_energy));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pro_energy));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(lipd_energy));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(roundTwoDigits(assmnt_total)));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if(basedOnAssmntValues.equals("Y") && (displayRecords != "0") && ((recCount-2) > Integer.parseInt(displayRecords))){break;}
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	
            _bw.write(_wl_block49Bytes, _wl_block49);

		
			records=(ArrayList) result.get( recCount );
			
			for(int colCount=0; colCount<records.size(); colCount++){
				
				
				String dkVal = (String)records.get( colCount );
                
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					
					if (colCount==0)
				{
					//put in a hyperlink and on click pass the selected name, code to the calliing page
					String desc=(String)records.get(colCount+1);
					out.println("<TD style='color:blue;cursor:pointer'   class='"+classvalue+"'onClick=\"chooseRegimen('"+dkVal+"','"+desc+"','"+tpn_tab_reg+"')\">"+dkVal+"</TD>");//,'"+tpn_tab_reg+"' added  ml-mmoh-crf-1290 
				}
				else if(colCount>3)
				{
						out.println("<TD align='right' class='"+classvalue+"'>"+dkVal+"</TD>");

				}
				else
				{
 					out.println("<TD class='"+classvalue+"'>"+dkVal+"</TD>");
				}
			
				
				}				   							       
			       String code=(String)records.get(0);
				   String cho_kcal= CommonBean.checkForNull((String)records.get( 7 ), "0"); // CommonBean.checkForNull added for ML-MMOH-CRF-1266 [IN:068728] - Start
				   String pro_kcal=CommonBean.checkForNull((String)records.get( 8 ),"0");
				   String lipid_kcal=CommonBean.checkForNull((String)records.get( 9 ),"0"); // CommonBean.checkForNull added for ML-MMOH-CRF-1266 [IN:068728] - End
				   String total =(Float.parseFloat(cho_kcal))+(Float.parseFloat(pro_kcal))+(Float.parseFloat(lipid_kcal))+"";
				   
				   if(macro_nutrients_not_mnd_yn){ // ML-MMOH-CRF-1266 [IN:068728] - Start
					   total="0";
					   for(int j=records.size()-energyConstcode.size();j<records.size();j++){
						   total = Float.parseFloat(total)+Float.parseFloat(CommonBean.checkForNull((String)records.get(j),"0"))+"";
					   }
				   } // ML-MMOH-CRF-1266 [IN:068728] - End
				   
				   
				   
				   out.println("<TD align='right' class='"+classvalue+"'>"+roundTwoDigits(total)+"</TD>");
				   out.println("<Td  style='color:blue;cursor:pointer'  onClick=\"displayConst('"+code+"')\"> Constituents</Td>");
	
            _bw.write(_wl_block50Bytes, _wl_block50);

		}
	
            _bw.write(_wl_block51Bytes, _wl_block51);

		out.flush();
	} else{
	
            _bw.write(_wl_block52Bytes, _wl_block52);

	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TPNRegStdRegLookupResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}

            _bw.write(_wl_block1Bytes, _wl_block1);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Weightin.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EnergyinKCal.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RegimenCode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RegimenName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AssesmentValue.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Weightin.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EnergyinKCal.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RegimenCode.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RegimenName.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Protein.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lipid.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Protein.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lipid.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AssesmentValue.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }
}
