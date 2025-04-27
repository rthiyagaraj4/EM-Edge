package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCA.CAMenstrualHistDtlTransBean;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnoteslinkmenstlmpselectedtext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkMenstLmpSelectedText.jsp", 1742180275323L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/RecClinicalNotesLinkMenstHistDtl.js\"></script>\n\n<html>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onScroll=\"scrollTitle1()\">\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\t\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<form name=\"RecClinicalNotesLinkMenstSelectedTextForm\" id=\"RecClinicalNotesLinkMenstSelectedTextForm\">\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<tr ><td class=\'CAGROUP\' ><b><font size=\'2\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b></td></tr>\n</table>\n</div> \n<div id=\"finalDiv1\">\n<table width=\"100%\" class=\'grid\' name=\"selectedTable\" id=\"selectedTable\" id=\"selectedTable\">\n<tr><td class=\'columnheadercenter\' style=\"font-size:10\" width=\'5%\' ></td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<td class=\'columnheadercenter\' style=\"font-size:10; padding:4px;\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<td class=\'columnheadercenter\' style=\"font-size:10\"  >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<td class=\'columnheadercenter\' style=\"font-size:10\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<td class=\'columnheadercenter\'  style=\"font-size:10\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n<td class=\'columnheadercenter\'  style=\"font-size:10\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n<td class=\'columnheadercenter\'  style=\"font-size:10\"> ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"gridData\" width=\'5%\' ><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" checked  onClick=\"selText(this)\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><input type=hidden name=\'clear";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<td class=\"gridData\" width=\'10%\'>&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t<td class=\"gridData\" width=\'10%\'>&nbsp;";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t<td class=\"gridData\" width=\'20%\'>&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td> \n\t\t\t\t\t<td class=\"gridData\" width=\'10%\'>&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</td>\n</tr>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<tr>\t\n\t\t\t\t<td class=\"fields\" width=\'5%\'><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onClick=\"selText(this)\" checked value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"></td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<td class=\"gridData\"  >&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t<td class=\"gridData\" >&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n                            ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"gridData\" width=\'10%\'>&nbsp;";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</tr>\n</table>\n</div></table>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n<input type=\"hidden\" name=\"temp\" id=\"temp\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"innerhtml\" id=\"innerhtml\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"innerhtml_header\" id=\"innerhtml_header\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"innertext\" id=\"innertext\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n<input type=\"hidden\" name=\"innertext_header\" id=\"innertext_header\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n</form>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\t<script>\n\t\treturnDataApprove();\n\t</script>\n";
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

/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	 Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
29/10/2024	   70704       Gunasekar                                   ML-MMOH-CRF-1759
------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);
            webbeans.eCommon.RecordSet Beannew= null;synchronized(session){
                Beannew=(webbeans.eCommon.RecordSet)pageContext.getAttribute("Beannew",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(Beannew==null){
                    Beannew=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("Beannew",Beannew,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);


	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	    String bean_id = "@CAMenstrualHistDtlTransBean" ;
	    String bean_name = "eCA.CAMenstrualHistDtlTransBean";
	
	    CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean) getBeanObject( bean_id, bean_name ,  request) ;

		ArrayList  fields			=	new ArrayList();
		String col_field ="";
		int col_span=0;
		
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer innertext_header = new StringBuffer(); 
		
		String result_linked_rec_type	=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
		String call_from_link_doc_btn 	=   request.getParameter("call_from_link_doc_btn")==null?"":request.getParameter("call_from_link_doc_btn");
		String result_sub_category		=	request.getParameter("result_sub_category")==null?"":request.getParameter("result_sub_category");

 		fields = bean.getFields(sec_hdg_code, result_linked_rec_type, result_sub_category);
        if(fields.size()==0)
  	       fields = bean.getFields(result_linked_rec_type, result_sub_category );

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(fields.size()>0)
	{
		col_span = fields.size();
		innerhtml_header.append("<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr>");
		innertext_header.append("<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr>");
		for(int l=0;l<fields.size();++l)
		{
			 col_field = (String)fields.get(l);
			 if(col_field.equals("LMP"))
			{
			
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LMP.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LMP.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("EDD"))
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EDD.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EDD.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("GESTATION(POA)"))
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationPOA.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationPOA.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("DELIVERYDATE"))
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DeliveryDate.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DeliveryDate.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("MISCARRIAGEDATE"))
			{
			
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MiscarriageDate.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MiscarriageDate.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("REMARKS"))
			{
			
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Remarks.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Remarks.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("EVENTSTATUS"))
			{
			
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EventStatus.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EventStatus.label","ca_labels")+"</b></td>");
			}
		}
		innerhtml_header.append("</tr>");
		innertext_header.append("</tr>");
	}
	else
	{
 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);

	ArrayList d=null;
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	
    
 	String lmp="";
    String edd="";
    String lmp_gestation_poa="";
 	String lmp_delivery_date="";
    String lmp_miscarriage_date="";
 	String lmp_remarks="";
    String lmp_event_status="";
	String formet="";
	
    StringBuffer innerhtml = new StringBuffer();
    StringBuffer innertext = new StringBuffer();
    StringBuffer temp_new = new StringBuffer();

	String return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	  

	if(return_format.equals("TEXT"))
		{
		  formet="\n";
		}else
		{
		  formet="<br>";
		}
	
	
	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");

        ret_str	=	(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	remval	=	(request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean	=	(request.getParameter("removebean")==null)?"":request.getParameter("removebean");	  
	flag	=	(request.getParameter("flag")==null)?"":request.getParameter("flag");

	if(sel_all.equals("select"))
	{
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"),"UTF-8");
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	String cat = "";
	int i=0;
	int index=0;
    if(flag.equals("clear"))
	{
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"),"UTF-8");
		if(ret_str!=null && !ret_str.equals(""))
		{
			ret_str = ret_str.substring(0, ret_str.length()-1);
		}
		
		if(ret_str!=null && !ret_str.equals(""))
		{
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"�");
			while(strtCodes.hasMoreTokens())
			{
				temp= (String) strtCodes.nextToken();
				StringTokenizer tempCodes = new StringTokenizer(temp,"~");
				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();
					index = Beannew.indexOfObject(key.trim());
					if(index!=-1)
					{
						Beannew.removeObject(index);
						Beannew.removeObject(index);
					}
				}		
			}
		}
		else
		{
			Beannew.clearAll();
		}
		ret_str="";
	}
	
	if(!removebean.equals("Y"))
	{
		if(ret_str!=null && ret_str!="")
		{
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"�");   
			while(strtCodes.hasMoreTokens())
			{			   
				temp= (String) strtCodes.nextToken();
				StringTokenizer tempCodes = new StringTokenizer(temp,"~");
				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();
					Beannew.putObject(key);
					Beannew.putObject(value);
				}			
			}
		}		
				
		for(i=1;i<Beannew.getSize();i+=2){
			disbean=Beannew.getObject(i).toString(); 

			if(temp_new.length() > 0)
				temp_new.delete(0,temp_new.length());
							
			String strs[] = disbean.split("\\|");

			if(strs.length>0)
			{
				lmp= strs[0];
				edd= strs[1];		
				lmp_gestation_poa = strs[2]; 	
				lmp_delivery_date= strs[3];
				lmp_miscarriage_date= strs[4];
				lmp_remarks= strs[5];
				lmp_event_status= strs[6];
				disbean = lmp+"|"+edd+"|"+lmp_gestation_poa+"|"+lmp_delivery_date+"|"+lmp_miscarriage_date+"|"+lmp_remarks+"|"+lmp_event_status;
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Beannew.getObject(i-1).toString()));
            _bw.write(_wl_block22Bytes, _wl_block22);

				String classValue="gridData";
				if(fields.size()>0){
					col_span = fields.size();
					innerhtml.append("<tr>"); 
					innertext.append("<tr>"); 
					for(int n=0;n<fields.size();++n){						
						col_field = (String)fields.get(n);
						if(n != 0)
							temp_new.append(",");

						if(col_field.equals("LMP"))
						{
						
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(lmp));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp+"</td>");
						}
						else if(col_field.equals("EDD"))
						{
						
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(edd));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(edd);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+edd+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+edd+"</td>");
						}
						else if(col_field.equals("GESTATION(POA)"))
						{
						
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(lmp_gestation_poa));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_gestation_poa);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_gestation_poa+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_gestation_poa+"</td>");
						}
						else if(col_field.equals("DELIVERYDATE"))
						{
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(lmp_delivery_date));
            _bw.write(_wl_block27Bytes, _wl_block27);

							temp_new.append(lmp_delivery_date);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td>");
						}
						else if(col_field.equals("MISCARRIAGEDATE"))
						{
						
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(lmp_miscarriage_date));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_miscarriage_date);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td>");
						}
						else if(col_field.equals("REMARKS"))
						{
						
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(lmp_remarks));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_remarks);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_remarks+"</td>");
						}
						else if(col_field.equals("EVENTSTATUS"))
						{
						
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(lmp_event_status));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_event_status);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_event_status+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_event_status+"</td>");
						}
					}
					cat=cat+formet+temp_new.toString();
					innerhtml.append("</tr>");
					innertext.append("</tr>");
				}
				else
				{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(lmp));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(edd));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lmp_gestation_poa));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(lmp_delivery_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(lmp_miscarriage_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lmp_remarks));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(lmp_event_status));
            _bw.write(_wl_block33Bytes, _wl_block33);
 
			  			innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+lmp+"</td><td style='font-size:12'>&nbsp;"+edd+"</td><td style='font-size:12'>&nbsp;"+lmp_gestation_poa+"</td>	<td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td><td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td><td style='font-size:12'>&nbsp;"+lmp_remarks+"</td><td style='font-size:12'>&nbsp;"+lmp_event_status+"</td></tr>");
						innertext.append("<tr><td style='font-size:12'>&nbsp;"+lmp+"</td><td style='font-size:12'>&nbsp;"+edd+"</td><td style='font-size:12'>&nbsp;"+lmp_gestation_poa+"</td>	<td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td><td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td><td style='font-size:12'>&nbsp;"+lmp_remarks+"</td><td style='font-size:12'>&nbsp;"+lmp_event_status+"</td></tr>");
						cat=cat+formet+disbean;	
						cat=cat.replace('|' , ',');
				}		
			}
		}
	}

            _bw.write(_wl_block34Bytes, _wl_block34);

	if(removebean.equals("Y"))
	{
	  String beankey="";
	  for(int l=0;l<Beannew.getSize();l++)
	   {
			beankey=Beannew.getObject(l).toString();  
			if(remval.equalsIgnoreCase(beankey))
			{
					Beannew.removeObject(l);
					Beannew.removeObject(l);
					break;
			}
		}

		d=new ArrayList();
		d=Beannew.getRecordSetHandle();
		int size=0;
		size=d.size();
				
		for( i=1;i<size;i+=2){
			beanval= java.net.URLDecoder.decode(d.get(i).toString());
			if(temp_new.length() > 0)
				temp_new.delete(0,temp_new.length());
			String strs[] = beanval.split("\\|");
																			
			if(strs.length>0)
			{
				lmp= strs[0];
				edd= strs[1];		
				lmp_gestation_poa = strs[2]; 	
				lmp_delivery_date= strs[3];
				lmp_miscarriage_date= strs[4];
				lmp_remarks= strs[5];
				lmp_event_status= strs[6];
				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Beannew.getObject(i-1).toString()));
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(fields.size()>0)
				{
					col_span = fields.size();
					innerhtml.append("<tr>"); 
					innertext.append("<tr>");
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);

						if(n != 0)
							temp_new.append(",");
							
						if(col_field.equals("LMP"))
						{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(lmp));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp+"</td>");
						}
						else if(col_field.equals("EDD"))
						{
						
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(edd));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(edd);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+edd+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+edd+"</td>");
						}
						else if(col_field.equals("GESTATION(POA)"))
						{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(lmp_gestation_poa));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_gestation_poa);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_gestation_poa+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_gestation_poa+"</td>");
						}
						else if(col_field.equals("DELIVERYDATE"))
						{
							
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(lmp_delivery_date));
            _bw.write(_wl_block40Bytes, _wl_block40);

							temp_new.append(lmp_delivery_date);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td>");
						}
						else if(col_field.equals("MISCARRIAGEDATE"))
						{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(lmp_miscarriage_date));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_miscarriage_date);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td>");
						}
						else if(col_field.equals("REMARKS"))
						{
						
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(lmp_remarks));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_remarks);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_remarks+"</td>");
						}
							else if(col_field.equals("EVENTSTATUS"))
						{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(lmp_event_status));
            _bw.write(_wl_block25Bytes, _wl_block25);

							temp_new.append(lmp_event_status);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+lmp_event_status+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+lmp_event_status+"</td>");
						}							
					}

					cat=cat+formet+temp_new.toString();
					innerhtml.append("</tr>");
					innertext.append("</tr>");
				}
				else
				{
				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(lmp));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(edd));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lmp_gestation_poa));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(lmp_delivery_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(lmp_miscarriage_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lmp_remarks));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(lmp_event_status));
            _bw.write(_wl_block42Bytes, _wl_block42);
 
						innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+lmp+"</td><td style='font-size:12'>&nbsp;"+edd+"</td><td style='font-size:12' >&nbsp;"+lmp_gestation_poa+"</td><td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td><td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td><td  style='font-size:12'>&nbsp;"+lmp_remarks+"</td><td  style='font-size:12'>&nbsp;"+lmp_event_status+"</td></tr>");
						innertext.append("<tr><td style='font-size:12'>&nbsp;"+lmp+"</td><td style='font-size:12'>&nbsp;"+edd+"</td><td style='font-size:12' >&nbsp;"+lmp_gestation_poa+"</td><td style='font-size:12'>&nbsp;"+lmp_delivery_date+"</td><td style='font-size:12'>&nbsp;"+lmp_miscarriage_date+"</td><td  style='font-size:12'>&nbsp;"+lmp_remarks+"</td><td  style='font-size:12'>&nbsp;"+lmp_event_status+"</td></tr>");
					
            _bw.write(_wl_block43Bytes, _wl_block43);
	
						cat=cat+formet+beanval;
						cat=cat.replace('|' , ',');	
					
				}
			}
		}
		
	}

if(d!=null)d.clear();
	
            _bw.write(_wl_block44Bytes, _wl_block44);

if(!return_format.equals("TEXT"))
{
	
cat = "<font size=2>"+cat+"</font>";
}
cat = java.net.URLEncoder.encode(cat,"UTF-8");

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cat));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i-2));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(innerhtml.toString()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(innerhtml_header.toString()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(innertext.toString()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(innertext_header.toString()));
            _bw.write(_wl_block51Bytes, _wl_block51);

if(call_from_link_doc_btn.equals("YES"))
{

            _bw.write(_wl_block52Bytes, _wl_block52);

}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SelectedItems.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LMP.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EDD.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GestationPOA.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DeliveryDate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MiscarriageDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EventStatus.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LMP.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EDD.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GestationPOA.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DeliveryDate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MiscarriageDate.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EventStatus.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
