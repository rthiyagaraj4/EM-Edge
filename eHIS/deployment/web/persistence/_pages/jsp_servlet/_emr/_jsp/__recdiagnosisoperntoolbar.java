package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recdiagnosisoperntoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisOpernToolbar.jsp", 1722439661419L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eMR/js/RecDiagnosis.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMR/js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body onKeyDown=\'lockKey()\'>\n\t\t<form name=\'RecDiagAddModifyForm\' id=\'RecDiagAddModifyForm\' >\n\t\t<table border=0 cellspacing=0 cellpadding=0 width=\"100%\">\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td align=\'left\' width=\'10%\'><input style=\" margin-left: 20px;\" type=\"button\" name=\"authorize\" id=\"authorize\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' class=\'button\' onclick=\"parent.RecDiagnosisAddModify.chkAuthorize(document.forms[0].mode,parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value)\"><input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"Authorize Mode\">\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].authorize.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\n\t\t\t\t\t\tdocument.forms[0].mode.value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' class=\'button\' onclick=\"parent.RecDiagnosisAddModify.chkAuthorize(document.forms[0].mode,parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value)\" disabled><input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"Authorize Mode\">\n\t\t\t</td>\n\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\n\t\t\t\t\n\t\t\t\t<td align=\'left\' >\t\t\t\t\n\t\t\t\t<b><font align=\'left\' size=\'1\' color=\'blue\'><a href=\"javascript:;\" onclick=\"callNotifiableNotes()\" id=\'notice_anchor\'></a></font>&nbsp;</b></td> \n\t\t\t\t<td align=\'right\' style=\"padding-right: 40px;\" class=\'button\'><span name=\"principle_diag\" id=\"principle_diag\" style=\"background-color:red;visibility: hidden;font-size:12px\"><font color=\'yellow\' ><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></font>&nbsp&nbsp;&nbsp&nbsp;</span>&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;<input type=\'button\' class=\'button\' name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onclick=\'Record()\'><input type=\'Button\' name=\'clear\' id=\'clear\' value=\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \' class=\"button\" onclick=\'clearform()\'><input type=\'button\' class=\'button\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onclick=\'cancel_a()\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="disabled";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="></td>  <!-- CHL-CRF- 0008 - IN:001472 -->\n\t\t\t</tr>\n\t\t</table>\t\n\t\n\t\t<input type=\"hidden\" name = \"as_evidenced_by\" value = \"\">\n\t\t<input type=\"hidden\" name = \"as_evidenced_by1\" value = \"\">\n\t\t<input type=\"hidden\" name = \"patient_id\" value = \"\">\n\t\t<input type=\"hidden\" name=\"authorizeButton\" id=\"authorizeButton\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<!-- Added by Sangeetha for ML-MMOH-SCF-0714 on 15/may/17 -->\n\t\t<input type=\"hidden\" name=\"renameAsteriskToDagger_yn\" id=\"renameAsteriskToDagger_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\n\t</form>\n\t</body>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<script>\n\nif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'==0 && \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'==\"Y\")\n{\ndocument.getElementById(\'principle_diag\').style.visibility = \"visible\";\n}\n</script>\n</html>\n\t\t\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block6Bytes, _wl_block6);
  request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String authorizeButton="Y";		
		
		String auth_mode		= request.getParameter("authorize")==null?"":request.getParameter("authorize");
		
		String facilityId 		= (String) session.getValue( "facility_id" ) ;
		Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;
		String userid = p.getProperty("login_user") ;
		
		String patient_type			= request.getParameter("patient_type")==null?"C":request.getParameter("patient_type");
		String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF- 0008 - IN:001472
		
		
		String Patient_Id = request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");		
		String Encounter_Id=request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id"); //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
		//out.println("Patient_Id=>"+Patient_Id+"=Encounter_Id=>"+Encounter_Id);
		int priciplecount=0;
		String diag_class_yn="";
		
		
		Connection con 		= null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String sql="";
	try
	{
		
		con = ConnectionManager.getConnection(request);

		//Added by Sangeetha for ML-MMOH-SCF-0714 on 15/may/17
		String renameAsteriskToDagger_yn = eMR.MRCommonBean.getRenameToDaggerYN(con);
		
		/*Below line Added for this CRF */
		//Maheshwaran k commented the below query and modified as on 17/09/2013
		//String priciplediag="select count(*) as principlediagcount from pr_diagnosis where curr_encounter_id=? and patient_id=? and curr_facility_id=? and CURR_STATUS='A' and DIAG_CLASS_CODE in ( select DIAG_CLASS_CODE from mr_diag_class where DIAG_CLASS_TYPE='PD'and EFF_STATUS='E')";
		String priciplediag="select count(*) as principlediagcount from pr_diagnosis_enc_dtl where encounter_id=? and patient_id=? and facility_id=? and STATUS='A' and DIAG_CLASS_CODE in ( select DIAG_CLASS_CODE from mr_diag_class where DIAG_CLASS_TYPE='PD'and EFF_STATUS='E')";
		
		
		
		stmt=con.prepareStatement(priciplediag);
		stmt.setString(1, Encounter_Id);
		stmt.setString(2, Patient_Id);
		stmt.setString(3, facilityId);
		rs=stmt.executeQuery();
		if(rs.next()){
		priciplecount=rs.getInt("principlediagcount");
		}
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		
		
		stmt=con.prepareStatement("select DIAG_CLASS_MAND_YN from MR_PARAMETER");		
		rs=stmt.executeQuery();
		if(rs.next()){
		diag_class_yn=rs.getString("DIAG_CLASS_MAND_YN");
		if(diag_class_yn==null)diag_class_yn="N";
		}
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		
		
		
		//End
		
		

		sql=   "select 'x' from mr_user_access_rights_vw where  FACILITY_ID = ?  and APPL_USER_ID = ? and ACCESS_TYPE    ='E'  and PATIENT_TYPE = ? and ACCESS_SCOPE='SD' ";
		
		stmt=con.prepareStatement(sql);
		stmt.setString(1, facilityId);
		stmt.setString(2, userid);
		stmt.setString(3, patient_type);
		rs=stmt.executeQuery();

		
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(rs.next())
		{
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);

				if(!auth_mode.equals(""))
			{
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(auth_mode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(auth_mode));
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
				
		}
		else
		{
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);

				if(!auth_mode.equals(""))
			{
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(auth_mode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(auth_mode));
            _bw.write(_wl_block15Bytes, _wl_block15);

			}

			authorizeButton="N";
		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(!"".equals(p_called_from_widget)){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(authorizeButton));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(renameAsteriskToDagger_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);


	}catch(Exception e){
		//out.print("checking error"+e.toString());
		e.printStackTrace();
}finally{
	try{
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
	//out.print("checking error1"+e.toString());
	e.printStackTrace();
	}
 }

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(priciplecount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(diag_class_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PrincipleDiagnosisnotrecorded.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
