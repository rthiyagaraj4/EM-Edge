package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import webbeans.eCommon.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import eCommon.XSSRequestWrapper;

public final class __staffrequirementqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/StaffRequirementQueryResult.jsp", 1709116621246L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t<script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonResult.js\"></Script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../js/CpMessages.js\">\nalert(\"entered\");\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n</head>\n\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n <table cellpadding=0 cellspacing=0 width=\"98%\" align=\"center\">\n<tr>\n\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</td>\n</tr>\n</table>\n\n<table cellpadding=0 cellspacing=0 border=1 width=\'97%\'  align=center>\n<tr>\n\n\t<th  align=\'left\'>Dependency Code</th>\n\t<th align=\'left\'>Dependency Description</th>\n\t<th align=\'left\'>Workplace Code</th>\n\t<th  align=\'left\'>Workplace Description</th>\n\t<th align=\'left\'>Shift Code</th>\n\t<th  align=\'left\'>Shift Description</th>\n\t\t<th  align=\'left\'>Position Code</th>\n\t\t<th  align=\'left\'>Position Description</th>\n\t\t\t<th  align=\'left\'>WDay</th>\n\t\t<th  align=\'left\'>NWDay</th>\n\t\t<th  align=\'left\'>HDay</th>\n</tr>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\n\t\t<tr>   \n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">&nbsp;</td>\n \t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</table>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\"));history.go(-1);</script>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n</body>\n</html>  \n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
	//String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	//String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
		
	String dependency_code= request.getParameter("dependency_code");
	String workplace_code	= request.getParameter("workplace_code");
	String workplace_desc		= request.getParameter("workplace_desc");
	String shift_code		= request.getParameter("shift_code");
	String position_code		= request.getParameter("position_code");
	String position_desc		= request.getParameter("position_desc");
	
	
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(dependency_code == null || dependency_code.equals("null")) dependency_code =" "; else dependency_code =dependency_code.trim();
	if(workplace_code == null ||workplace_code.equals("null")) workplace_code =" "; else workplace_code = workplace_code.trim();
	if(workplace_desc	 == null || workplace_desc	.equals("null")) workplace_desc	 =" "; else workplace_desc	 = workplace_desc	.trim();
	if(shift_code == null || shift_code.equals("null")) shift_code=" "; else shift_code = shift_code.trim();
	if(position_code	 == null || position_code	.equals("null")) position_code	 =" "; else position_code	 = position_code	.trim();
	if(position_desc	 == null || position_desc	.equals("null")) position_desc	 =" "; else position_desc	 = position_desc	.trim();
	
	HashMap sqlMap = new HashMap();

	
	/*String sql_terminology="select  a.dependency_code,b.long_desc,a.workplace_code,c.workplace_desc,a.shift_code,d.long_desc  long_desc1  from cp_staff_requirement a,cp_dependency b,rs_workplace c,am_shift d  where a.dependency_code=b.dependency_code and a.workplace_code=c.workplace_code and a.shift_code=d.shift_code and upper(a.dependency_code) like upper(?) and upper(b.long_desc) like upper(?) and upper(a.workplace_code) like upper(?)  and upper(c.workplace_desc) like upper(?)  and upper(a.shift_code) like upper(?)  and upper(d.long_desc) like upper(?)";*/
String sql_terminology="select a.dependency_code,b.long_desc,a.workplace_code,c.workplace_desc, a.shift_code,d.long_desc long_desc1, e.position_desc,e.position_code ,a.wday_hours,a.nwday_hours,a.hday_hours  from cp_staff_requirement a,cp_dependency b,rs_workplace c,am_shift d, am_position e  where a.dependency_code=b.dependency_code  and a.workplace_code=c.workplace_code  and a.shift_code=d.shift_code  and upper(a.dependency_code) like upper(?) and upper(a.workplace_code) like upper(?)  and upper(c.workplace_desc) like upper(?)  and upper(a.shift_code) like upper(?)  and upper(e.position_code) like upper(?)  and upper(e.position_desc) like upper(?) and e.position_code = a.position_code ";

	sqlMap.put( "sqlData",sql_terminology);

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("dependency_code");
	displayFields.add("long_desc");
	displayFields.add("workplace_code");
	displayFields.add("workplace_desc");
	displayFields.add("shift_code");
	displayFields.add("long_desc1");
	displayFields.add("position_code");
	displayFields.add("position_desc");
	displayFields.add("wday_hours");
	displayFields.add("nwday_hours");
	displayFields.add("hday_hours");
	

	
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(dependency_code+"%");
		chkFields.add( workplace_code+"%");
	chkFields.add( workplace_desc+"%");
	chkFields.add(shift_code+"%");
		chkFields.add( position_code+"%");
		chkFields.add(position_desc+"%");
	
	
	


	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
    //int rowCount = 1;
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

 
            _bw.write(_wl_block7Bytes, _wl_block7);

	// For display the previous/next link
     out.println(result.get(1));

            _bw.write(_wl_block8Bytes, _wl_block8);

		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			
			records=(ArrayList) result.get( recCount );
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		for(int colCount=0; colCount<records.size(); colCount++){		
			String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);
			if(str.equals("")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block11Bytes, _wl_block11);
} else {
		 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(str));
            _bw.write(_wl_block14Bytes, _wl_block14);
}}//end of for loop
		  
            _bw.write(_wl_block15Bytes, _wl_block15);
}//L00p for all records
            _bw.write(_wl_block16Bytes, _wl_block16);

	out.flush();
	}else{
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/StaffRequirementQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} 
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
