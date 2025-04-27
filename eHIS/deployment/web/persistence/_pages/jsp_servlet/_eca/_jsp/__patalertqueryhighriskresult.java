package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patalertqueryhighriskresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatAlertQueryHighRiskResult.jsp", 1722320634293L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n</head>\n<body  class=\'CONTENT\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\n\nfunction CallDescFrame(Obj)\n{\n\tvar selected_val =Obj.value;\n\ttop.content.workAreaFrame.PatAlertHighRiskMainFrame.PatAlertQueryHighRiskDesc.location.href=\'PatAlertQueryHighRiskDesc.jsp?radio_par=\'+selected_val+\'&patient_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'\n}\n\nfunction authorised(Obj)\n{\n\tvar P_access_type=document.forms[0].P_access_type.value;\n\tvar P_access_data=document.forms[0].P_access_data.value;\n\tvar context_value=document.forms[0].context_value.value;\n\tvar btn_flag\t =document.forms[0].btn_flag.value;\n\n\n\tChk_val=Obj.value;\n\n\tif(btn_flag = \"A\")\n\t{\n\t\tdocument.forms[0].btn_flag.value =\"N\";\n\t\tvar bool = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n\t\tif (bool == \'Y\' )\n\n\t\t\talert(getMessage(\'NO_USER_FOUND\',\'CA\'));\n\t\telse\n\t\t\tparent.PatAlertHighRiskMainFrame.location.href=\"Authorize.jsp?called_from_ip=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Access_Type=\"+P_access_type+\"&Context=\"+context_value+\"&Access_Data=\"+P_access_data+\"&Patient_Id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&jsp_name=PatAlertHighRiskMainFrame.jsp&radio_par=A\";\n\t}\n    else if(btn_flag = \"N\")\n\t{\n\t\t\tdocument.forms[0].btn_flag.value =\"A\";\n\t\t\tif(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" == \"Y\")\n\t\t\t\tparent.PatAlertHighRiskMainFrame.location.href=\'blank.jsp\';\n\t\t\telse\n\t\t\t\ttop.content.workAreaFrame.PatAlertHighRiskMainFrame.location.href=\'blank.jsp\';\n\n\t\t\tdocument.forms[0].high_risk_button.value=getLabel(\"Common.Authorized.label\",\"Common\");\n\n\t}\n\n}\n</script>\n<form name=\"radio_high_risk\" id=\"radio_high_risk\">\n<table border=0   height=100% cellpadding=\'3\' cellspacing=\'0\' align=center width=\'100%\'>\n<th class=\'columnHeader\'  align=center ><font size=1>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</th>\n<td class=\'columnHeader\' >\n<font size=1></font>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<input type=\'button\' name=\'high_risk_button\' id=\'high_risk_button\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onclick=\'authorised(this)\' class=\'button\'>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</td>\n</table>\n<input type=\"hidden\" name=\"P_access_type\" id=\"P_access_type\" value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n<input type=\"hidden\" name=\"P_access_data\" id=\"P_access_data\" value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n<input type=\"hidden\" name=\"context_value\" id=\"context_value\" value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n<input type=\"hidden\" name=\"btn_flag\" id=\"btn_flag\"      value=\"A\">\n\n\n</form>\n</body>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	StringBuffer strBuff_sql = new StringBuffer();
	Connection conn 	= 	null; //(Connection) session.getValue( "connection" ) ;
	PreparedStatement stmt		=	null, pstmt = null;
	ResultSet rs		=	null, rs_new = null;
	String login_user 	= (String) session.getValue( "login_user" ) ;
	String patient_id 	= request.getParameter("patient_id");
	String context_value  = (String) request.getParameter("PQ");//request.getParameter("Context");
	
	if (context_value ==null) context_value ="Y";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String userid = p.getProperty( "login_user" ) ;
	String facilityId 		= (String) session.getValue( "facility_id" ) ;
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");

	String sql ="";
	String set_flag="";

	String P_access_type="V";
	String P_access_data="HR";

	String patient_type=request.getParameter("patient_type");
	if(patient_type==null)
		patient_type="C";
try{

	conn = ConnectionManager.getConnection(request);
	strBuff_sql.append("select 'x' from mr_user_access_rights_vw where  FACILITY_ID   =? ");
	strBuff_sql.append(" and APPL_USER_ID=? and ACCESS_TYPE    ='V'  and ");

			   if(context_value.equals("Y")){
				   strBuff_sql.append("PATIENT_TYPE='C' ");
					
			   }else{
				   strBuff_sql.append("PATIENT_TYPE='O' ");
					
			   }
			strBuff_sql.append(" and ACCESS_SCOPE='HR' and ");
			strBuff_sql.append(" exists(select '1' from pr_high_risk_condition where patient_id=? and ");
			strBuff_sql.append("  rownum<2) ");

		pstmt = conn.prepareStatement(strBuff_sql.toString());
		pstmt.setString(1,facilityId);
		pstmt.setString(2,userid);
		pstmt.setString(3,patient_id);
		rs_new=pstmt.executeQuery();

	if (context_value.equals("Y"))
	{
		sql= "Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='C' and access_scope='HR'";
	}
	else
	{
		sql="Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='O' and access_scope='HR'";
	}

	stmt = conn.prepareStatement(sql);
	stmt.setString(1,login_user);
	rs = stmt.executeQuery();
	if (!(rs.next()))
		set_flag="Y";
	else
		set_flag="N";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(set_flag));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	if(rs_new.next())
	{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	else
	{
		out.print("&nbsp");
	}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(P_access_type ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(P_access_data ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(context_value ));
            _bw.write(_wl_block20Bytes, _wl_block20);

}
catch (Exception e) 
{
	//out.println("Exception @ try"+e.toString()); //COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181	
}
finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(rs_new!=null) rs_new.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null)ConnectionManager.returnConnection(conn,request);	
	}catch(Exception e){
			//out.println("Exception @ finally try"+e.toString()); //COMMON-ICN-0181
		     e.printStackTrace();//COMMON-ICN-0181

	} 
}


            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighRiskConditions.label", java.lang.String .class,"key"));
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
