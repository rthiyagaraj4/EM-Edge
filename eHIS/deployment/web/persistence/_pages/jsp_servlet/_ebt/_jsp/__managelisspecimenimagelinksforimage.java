package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __managelisspecimenimagelinksforimage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/ManageLISSpecimenImageLinksForImage.jsp", 1709115156087L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="eCommon/html/IeStyle.css\' type=\'text/css\' />\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\n\t<title>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</title>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\"../../eBT/js/ManageLISSpecimenImage.js\" language=\"javascript\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t</head>\n\t<body>\n\t<form name=\'showImageLinksForm\' id=\'showImageLinksForm\'>\n\t<table border=\'1\' width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' align=\'center\'>\n\t<tr>\n\t<td class=\'CAGROUP\' colspan=\'6\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t</tr>\n\t<tr>\n\t<th align=\'left\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t<th align=\'left\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t<!--<th align=\'left\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>-->\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<th align=\'left\'>Delete</th>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</tr>\t\n\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<!-- <td colspan=\'2\' align=\'center\' width=\'25%\' > -->\n\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</table>\n<input type=\'hidden\' name=\'applServerURL\' id=\'applServerURL\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'cnt\' id=\'cnt\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'hdInterfaceFileId\' id=\'hdInterfaceFileId\' value=\"\">\n<!-- <input type=\'hidden\' name=\'hdInterfaceFileId1\' id=\'hdInterfaceFileId1\' value=\"\"> -->\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"> \n<input type=\'hidden\' name=\'filePath\' id=\'filePath\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n</form> \n<!-- added by Sanjay on 08-May-13 for Deleting Image STARTS -->\t\t\t\t\n<form name=\'DeleteButton\' id=\'DeleteButton\' method=\'POST\' action = \'../../eBT/jsp/ManageLISSpecimenImageLinksForImage.jsp\'>\n<tr></tr>\n<tr></tr>\n<tr>\t<td colspan=\'4\' align=\'center\' width=\'50%\'>\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<input type=\"button\" class=\"button\" name=\"apply\" id=\"apply\" value=\"Apply\" onClick=\"applyAll();\">\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</td>\t\t\t\t\t\t\n<td colspan=\'4\' align=\'center\' width=\'50%\'>\n<input type=\"button\" class=\"button\" name=\"reset\" id=\"reset\" value=\"Close\" \tonClick=\"resetAll();\">\n</td>\n</tr>\t\t\t\t\n</form>\t\t\n<!-- added by Sanjay on 08-May-13 for Deleting Image ENDS -->\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");
String p_resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
//Sanjay for removing Delete Option when viewed from Review
String calledFromForms = request.getParameter("calledFromForms") == null ? "" : request.getParameter("calledFromForms");
String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
String applServerURL = "";
String appleHISServerURL = "";
String secCode = "";
String oper_facilityId="";//Added by Nandhini against GHL-SCF-1354 on 26/June/2018

Connection con = null;
PreparedStatement pstmt = null;
ResultSet res = null;
// to get filePath STARTS here
PreparedStatement pstmt1 = null;
ResultSet res1 = null;
PreparedStatement pstmt2 = null;
ResultSet res2 = null;
String filePath = "";
// to get filePath ENDS here
StringBuffer sql = new StringBuffer("select INTERFACE_FILE_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') added_date_time from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? ");

String test = "";
String sampleId = "";
String anatomy = "";
int cnt = 1;

try
{
	if(!p_resp_id.equals("RL_MANAGER"))
	con = ConnectionManager.getConnection(request);
	else
	{
		con = ConnectionManager.getConnection();
	}

	//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 
		
			try
			{
			pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID FROM rl_request_header where SPECIMEN_NO=? and ORDERED_FACILITY_ID=?");
			pstmt.setString(1,specNum);
			pstmt.setString(2,facilityId);
			res = pstmt.executeQuery();	
		
			if(res.next()  )
			{
				oper_facilityId = res.getString("OPERATING_FACILITY_ID") == null ? "" : res.getString("OPERATING_FACILITY_ID");
				facilityId=oper_facilityId;
				System.out.println("ManageLISSpecimenImageServlet.java facilityId:" +facilityId);
			}
			
			}
			catch(Exception e1)
		{
			System.out.println("Ex1:"+e1);
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 
		}

	test = request.getParameter("test") == null ? "" : request.getParameter("test");
	sampleId = request.getParameter("sampleId") == null ? "" : request.getParameter("sampleId");
	anatomy = request.getParameter("anatomy") == null ? "" : request.getParameter("anatomy");

	//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
	secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");	

	String interfaceFileId = "";
	String addedDate = "";
	String classValue = "";

	//int cnt = 1;//Sanjay		
	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM RL_EXT_INTERFACE_PARAM where EXT_APPL_ID='LBIMG' ");
	res = pstmt.executeQuery();
	
	while(res.next())
	{
		applServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM CA_EXT_INT_PARAM ");
	res = pstmt.executeQuery();
	
	while(res.next())
	{
		appleHISServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	if(facilityId.equals(""))
	facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

	if(p_resp_id.equals("RL_MANAGER"))
	{
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(appleHISServerURL));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else
	{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	//Commented by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
	// Query to get Section Code STARTS here
	/*
				pstmt1 = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
				pstmt1.setString(1,test);
				res1 = pstmt1.executeQuery();
				while(res1.next())
				{
					secCode = res1.getString(1) == null ? "" : res1.getString(1);
				}
				if(res1 != null) res1.close();
				if(pstmt1 != null) pstmt1.close();
	*/	
	// Query to get Section Code ENDS here

	// Query to get file path for copying uploaded Image STARTS here
	String sqlFilePath = "select IMAGE_FILE_HOME_IDR from RL_SECTION_CTL where OPERATING_FACILITY_ID = ? and SECTION_CODE = ?";
	pstmt2 = con.prepareStatement(sqlFilePath);
	pstmt2.setString(1,facilityId);	
	pstmt2.setString(2,secCode);
	
	res2 = pstmt2.executeQuery();
	while(res2.next())
	{
		filePath = res2.getString(1) == null ? "" : res2.getString(1);
	}
	if(res2 != null) res2.close();
	if(pstmt2 != null) pstmt2.close();
	// Query to get file path for copying uploaded Image ENDS here	
	filePath = filePath.replace("\\", "/");
	// ENDS

	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(specNum));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	if (!calledFromForms.equalsIgnoreCase("RL_REVIEW")) {
		
            _bw.write(_wl_block18Bytes, _wl_block18);

	}
	
            _bw.write(_wl_block19Bytes, _wl_block19);

	if(!test.equals("")) sql.append("  and TEST_CODE = ? ");
	if(!sampleId.equals("")) sql.append(" and SAMPLE_ID = ? ");
	if(!anatomy.equals("")) sql.append(" and ANATOMY_SITE_CODE = ? ");
	sql.append(" order by 2 ");	
	pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1,facilityId);
	pstmt.setString(2,specNum);
	if(!test.equals(""))
	pstmt.setString(3,test);
	if(!sampleId.equals(""))
	pstmt.setString(4,sampleId);
	if(!anatomy.equals(""))
	pstmt.setString(5,anatomy);
	res = pstmt.executeQuery();

	while(res.next())
	{
		if(cnt % 2 != 0) classValue = "QRYEVEN";
		else classValue = "QRYODD";
		out.println("<tr>");
		interfaceFileId = res.getString("INTERFACE_FILE_ID") == null ? "" : res.getString("INTERFACE_FILE_ID");
		addedDate = res.getString("added_date_time") == null ? "" : res.getString("added_date_time");
		addedDate = DateUtils.convertDate(addedDate,"DMYHMS","en",locale);//added by Sanjay for 10.x conversion
		out.println("<td class='"+classValue+"'>"+addedDate+"</td>");
		//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
		out.println("<td class='"+classValue+"'><a style='cursor:pointer;color:blue' onclick=\"javascript:imageView('"+specNum+"','"+test+"','"+sampleId+"','"+secCode+"','"+anatomy+"','"+facilityId+"','"+interfaceFileId+"')\">Image </a></td>");
		//Sanjay for removing Delete Option when viewed from Review
		if (!calledFromForms.equalsIgnoreCase("RL_REVIEW")) {					
			out.println("<td class='"+classValue+"'><input type='checkbox' name='chkavilable"+cnt+"' id='chkavilable"+cnt+"' onClick=chkDelete('"+interfaceFileId+"',this)></td>");
			//out.println("<td class='"+classValue+"'><input type='checkbox' name='chkavilable"+cnt+"' id='chkavilable"+cnt+"'</td>");
		}
		out.println("</tr>");
		cnt++;
	}
	
            _bw.write(_wl_block20Bytes, _wl_block20);

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	//System.out.println("Exception in try of ManageLISSpecimenImageLinksForImage.jsp--"+e.toString());
	out.println("Exception in try of ManageLISSpecimenImageLinksForImage.jsp--"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	//System.out.println("ManageLISSpecimenImageLinksForImage.jsp");
}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(applServerURL));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(filePath));
            _bw.write(_wl_block26Bytes, _wl_block26);

//Condtion added by Sanjay for hiding Apply button when called from review
if (!calledFromForms.equalsIgnoreCase("RL_REVIEW")) {
	
            _bw.write(_wl_block27Bytes, _wl_block27);

}
//added by Sanjay for hiding Apply button when called from review

            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.ImageLinks.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.SpecimenNo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.UploadedDate.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSS.ImagePreview.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSS.ImagePreview.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
