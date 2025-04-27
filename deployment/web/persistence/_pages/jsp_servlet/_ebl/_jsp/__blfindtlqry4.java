package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.util.*;
import com.ehis.util.*;

public final class __blfindtlqry4 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDtlQry4.jsp", 1725606386544L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nSr No        Version           Incident        SCF/CRF             Developer Name\n-----------------------------------------------------------------------------------\n1            V201016            74223         SKR-SCF-1448\t\t\tMuthukumarN\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n  <head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</tr>\n</table>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<td class=\'COLUMNHEADER\'></td>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t<tr><td colspan=6>&nbsp;</td></tr>\n\t\t<tr><td colspan=6>&nbsp;</td></tr>\n\t\t<!-- <tr><td colspan=6>&nbsp;</td></tr>\n\t\t<tr><td colspan=6>&nbsp;</td></tr>\n\t\t<tr><td colspan=6>&nbsp;</td></tr>\n\t\t<tr><td colspan=6>&nbsp;</td></tr>\n\t\t<tr><td colspan=6>&nbsp;</td></tr>\t -->\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</table>\n</form>\n</body>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	String strSetInd = ""; 
	String strAdmFlag = "";
	String strFamIn = ""; 
	String strFamAss  = "";
	String strNoDep = ""; 	
	String strNonInsBlGrId = ""; 	
	String strNonInsCustCode = "";
	String strGLHol  = ""; 
	String strPatRel  = "";
	String strBillGrp = "";
	String strPatRelGL = "";
	String strCrdDocRef = ""; 	
	String strCrDocRefStDate = "";
	String strCrDocRefEndDate = "";	
	String strResPay  = ""; 	
	String strPatRelnRespPers=""; 	 

	String strepisodetype=""; 
	String strepisodeid=""; 
	String strvisitid="";
	String strpatientid="";
	String streffFromDate ="";  	
	String streffToDate=""; 
	String strfinRemarks="";
	int noofdecimal = 2;
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs3 = null;
	String sqlrem=""; 	

	String locale	= (String)session.getAttribute("LOCALE");	
	request.setCharacterEncoding("UTF-8");

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");
		strBillGrp =	request.getParameter("strBillGrp");		
		if(strBillGrp==null) strBillGrp="";
		strSetInd =	request.getParameter("strSetInd");	
		if(strSetInd==null) strSetInd="";
		strAdmFlag =	request.getParameter("strAdmFlag");	
		if(strAdmFlag==null) strAdmFlag="";
		strFamIn =	request.getParameter("strFamIn");	
		if(strFamIn==null) strFamIn="";
		strFamAss =	request.getParameter("strFamAss");	
		if(strFamAss==null) strFamAss="";
		strNoDep =	request.getParameter("strNoDep");	
		if(strNoDep==null) strNoDep="";
		strNonInsBlGrId =	request.getParameter("strNonInsBlGrId");	
		if(strNonInsBlGrId==null) strNonInsBlGrId="";
		strNonInsCustCode =	request.getParameter("strNonInsCustCode");	
		if(strNonInsCustCode==null) strNonInsCustCode="";
		strGLHol =	request.getParameter("strGLHol");
		if(strGLHol==null) strGLHol="";
		strPatRel =	request.getParameter("strPatRel");	
		if(strPatRel==null) strPatRel="";
		strPatRelGL =	request.getParameter("strPatRelGL");	
		if(strPatRelGL==null) strPatRelGL="";
		strCrdDocRef =	request.getParameter("strCrdDocRef");
		if(strCrdDocRef==null) strCrdDocRef="";
		strCrDocRefStDate =	request.getParameter("strCrDocRefStDate");
		if(strCrDocRefStDate==null) strCrDocRefStDate="";
		strCrDocRefEndDate =	request.getParameter("strCrDocRefEndDate");
		if(strCrDocRefEndDate==null) strCrDocRefEndDate="";
		strResPay =	request.getParameter("strResPay");
		if(strResPay==null) strResPay="";
		strPatRelnRespPers =	request.getParameter("strPatRelnRespPers");
		if(strPatRelnRespPers==null) strPatRelnRespPers="";
		strepisodetype = request.getParameter("episodetype");
		if(strepisodetype==null) strepisodetype="";
		strepisodeid = request.getParameter("episodeid");
		if(strepisodeid==null) strepisodeid="";
		strvisitid = request.getParameter("visitid");
		if(strvisitid==null) strvisitid="";
		strpatientid= request.getParameter("patientid");
		if(strpatientid==null) strpatientid="";
		strpatientid=strpatientid.trim();			
		
		try
		{	
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs3 = pstmt.executeQuery();	
			while(rs3.next())
			{
				noofdecimal  =  rs3.getInt(1);		
			}
			pstmt.close();
			rs3.close();
			CurrencyFormat cf = new CurrencyFormat();
			strFamIn = cf.formatCurrency(strFamIn, noofdecimal);
			strFamAss = cf.formatCurrency(strFamAss, noofdecimal);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in Currency Conversion="+e.toString());
		}

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try
	{		
		sqlrem="SELECT distinct TO_CHAR(a.eff_from_date,'dd/mm/yyyy') eff_from_date, "+
			   " TO_CHAR(a.eff_to_date,'dd/mm/yyyy') eff_to_date,"+
			   " a.fin_remarks fin_remarks "+
				" FROM bl_patient_fin_remarks a "+
				" WHERE a.operating_facility_id = '"+facility_id+"' "+
				" AND a.episode_type = '"+strepisodetype+"' "+
				" AND ((a.patient_id = '"+strpatientid+"' AND a.episode_type = 'R') OR "+
				" (a.episode_id = '"+strepisodeid+"' AND a.visit_id = '"+strvisitid+"' AND a.episode_type IN ('O','E')) OR "+
				" (a.episode_id = '"+strepisodeid+"' AND a.episode_type IN ('I','D')))";//V201016

		pstmt = con.prepareStatement(sqlrem);
		rs3 = pstmt.executeQuery() ;
	
		if(rs3!=null)
		{

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	else
	{

            _bw.write(_wl_block10Bytes, _wl_block10);

	}			
	while(rs3.next())
	{
		streffFromDate = rs3.getString(1);
		if(streffFromDate==null) streffFromDate="";
		if(!streffFromDate.equals(""))
		{
			streffFromDate=com.ehis.util.DateUtils.convertDate(streffFromDate,"DMY","en",locale);
		}
		streffToDate=rs3.getString(2);
		if(streffToDate==null) streffToDate="";
		if(!streffToDate.equals(""))
		{
			streffToDate=com.ehis.util.DateUtils.convertDate(streffToDate,"DMY","en",locale);
		}
		strfinRemarks=rs3.getString(3);	

		if (streffFromDate == null) streffFromDate = "";
		if (streffToDate == null) streffToDate = "";
		if (strfinRemarks == null) strfinRemarks = "";			

		out.println("<tr>");
		out.println("<td width='25%' class='data'>"+streffFromDate+"</td>");
		out.println("<td width='25%' class='fields'>"+streffToDate+"</td>");
		out.println("<td width='25%' class='fields'>"+"<TextArea name='' tabindex='0' cols='70' readonly value=''> "+strfinRemarks+"</TextArea></td>");
		out.println("<td width='25%' class='label' size='30' > </td>");
		out.println("</tr>");
	}//while closing	
	if((streffFromDate.equals("")) && (streffToDate.equals("")) && (strfinRemarks.equals("")))
	{

            _bw.write(_wl_block11Bytes, _wl_block11);

		}//if
	}//try closing
	catch(Exception sql)
	{
		sql.printStackTrace();
		System.out.println("Exception in Currency Conversion="+sql.toString());			
	}

            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Main Exception:"+e);
	}
	finally
	{
		if (rs3 != null)   rs3.close();
		if (pstmt != null) pstmt.close();
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FINANCIAL_REMARKS.label", java.lang.String .class,"key"));
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
