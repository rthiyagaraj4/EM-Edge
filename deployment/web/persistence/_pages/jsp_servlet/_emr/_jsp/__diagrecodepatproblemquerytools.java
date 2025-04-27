package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __diagrecodepatproblemquerytools extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagRecodePatProblemQueryTools.jsp", 1743670706927L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<!-- \t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script language=\'javascript\' src=\'../../eMR/js/DiagRecodePatProblem.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=javascript>\n\nasync function showErrorList(){\n\t\tvar patient_id=document.forms[0].Patient_Id.value;\n\t\tvar retVal;\n\t\tvar dialogHeight=20vh;\n\t\tvar dialogWidth=50vw;\n\t\tvar features=\'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; scroll=auto; status=no\';\n\t\tretVal=await window.showModalDialog(\'../../eMR/jsp/DiagRecodePatProblemViewErrorList.jsp?patient_id=\'+patient_id,arguments,features);\t\n}\n\nasync function markError()\n{\n\t\tvar value=parent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value;\n\t\tvar comments;\n\t\tvar retVal;\n\t\tvar dialogHeight =\'7vh\' ;\n\t\tvar dialogWidth = \'30vw\' ;\n\t\tvar features \t= \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; scroll=no; status=no\';\n\t\tretVal \t\t\t= await window.showModalDialog(\'../../eCA/jsp/RemarksDialog.jsp?allDia=Y&resultStr=\'+value,arguments,features);\n\t\t\n\t\tif(retVal==undefined){\n\t\t\t\t\t//checking undefined\t\t\t\n\t\t}else  if(retVal!=null && retVal!=\'\'){\n\t\t\tparent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value=retVal;\n\t\t\tparent.addModifyPatProblem.document.getElementById(\"disMar\").innerHTML=\"<font color=yellow  size=2>Marked for Error &nbsp;&nbsp;</font>\";\n\t\t}else{\n\t\t\tparent.addModifyPatProblem.document.getElementById(\"disMar\").innerText=\"\";\n\t\t\tparent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value=\"\";\n\t\t}\n}\n\n</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\tfunction cancel_close()\n\t{\n\t\tvar called_from_ip =  document.query_button.called_from_ip.value;\n\t\tif(called_from_ip == \'Y\'|| document.query_button.modal_yn.value==\'Y\')\n\t\t\tparent.window.close();\n\t\telse\n\t\t\tcancel_a();\n\t}\n</script>\n<form name=\"query_button\" id=\"query_button\">\n\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"   width=\'100%\'>\n<tr>\n<td width=\'80%\' class=\'white\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<input type=\'button\' name=\'authorize\' id=\'authorize\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' class=\'button\' style=\'display:none\' onclick=\'parent.addModifyPatProblem.chkAuthorize(document.forms[0].mode,parent.addModifyPatProblem.document.PatProblem_form.code_indicator.value)\'><input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"Authorize Mode\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t<script language=javascript> \n\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].authorize.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'; \n\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].mode.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\n\t\t\t\t\t\t\t\t\t</script>\t\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n \t\t\t\t\t\t\t<input type=\'button\' name=\'btnView\' id=\'btnView\' onclick=\"showErrorList();\" value=\"View Error List\"  class=\'button\' style=\'display:none\'>&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<input type=\'button\' align=\'left\' name=\'error\' id=\'error\' onclick=\"markError()\" class=\'button\' value=\"Mark Error\" style=\'display:none\'>&nbsp;\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<td class=\'white\' nowrap>\n<input type=\'Button\'  name=\'finalize\' id=\'finalize\'  title=\'Finalize\' class=\"Button\" onclick=\"apply1(\'fromFinalize\')\" value=\"Finalize\" style=\'display:none\'>\n<input type=\'Button\'  name=\'record\' id=\'record\' title=\'Record\' class=\"Button\" onclick=\"apply1()\" disabled value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'Button\' name=\'clear\' id=\'clear\' title=\'Clear\' class=\"Button\" onclick=\"clearform()\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'Button\' name=\'cancel\' id=\'cancel\' title =\'Cancel\' class=\"Button\" onclick=\"cancel_close()\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n</td>\n<td>\n<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'Locn_Code\' id=\'Locn_Code\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'Locn_Type\' id=\'Locn_Type\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\'hidden\' name=\'f_authorize_yn\' id=\'f_authorize_yn\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'Sec_Hdg_Code\' id=\'Sec_Hdg_Code\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'Invoking_Function\' id=\'Invoking_Function\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'Context\' id=\'Context\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'stage_code\' id=\'stage_code\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'stage_desc\' id=\'stage_desc\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\'hidden\' name=\'logical_seq_no\' id=\'logical_seq_no\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\'hidden\' name=\'called_from_ip\' id=\'called_from_ip\'value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\'hidden\' name=\'calledFromDeathReg\' id=\'calledFromDeathReg\'value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\'value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'RECORD_DIAGNOSIS\'>\n<input type=\'hidden\' name=\'QueryString1\' id=\'QueryString1\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"authorizeButton\" id=\"authorizeButton\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n</td>\n</tr>\n</table>\n</form>\n</body>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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

String errorModify=request.getParameter("errorModify")==null?"N":request.getParameter("errorModify");
String Patient_Id=request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");


            _bw.write(_wl_block5Bytes, _wl_block5);

	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");

		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


String authorizeButton="Y";
	String QueryString1 = request.getQueryString();
//	String resp_id = (String)session.getValue("responsibility_id");
//	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	
	String auth_mode=request.getParameter("authorize")==null?"":request.getParameter("authorize");
	String Encounter_Id 		= request.getParameter("Encounter_Id");
	String Practitioner_Id		= request.getParameter("Practitioner_Id");
	String Locn_Code			= request.getParameter("Locn_Code");
	String Locn_Type			= request.getParameter("Locn_Type");
	String f_authorize_yn		= request.getParameter("f_authorize_yn");
	String Sec_Hdg_Code			= request.getParameter("Sec_Hdg_Code");
	String patient_class		= request.getParameter("patient_class");
	String invoking_function	= request.getParameter("Function");
	String context				= request.getParameter("P_context");
	String modal_yn				= request.getParameter("modal_yn")==null?"":request.getParameter("modal_yn");
	String stage_code			= request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String stage_desc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String logicalseqno = request.getParameter("Logical_Seq")==null?"":request.getParameter("Logical_Seq");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
	String calledFromDeathReg = request.getParameter("calledFromDeathReg")==null?"N":request.getParameter("calledFromDeathReg");
	String srl_no = request.getParameter("srl_no");
	String encounter_clor = request.getParameter("encounter_clor");
	if (encounter_clor==null)  encounter_clor="N";
	
	String btnVisible = "style=display:none";

	if(srl_no != null && calledFromDeathReg.equals("Y"))
	{
		btnVisible = "style=display:none";
	}
	else
	{
		btnVisible = "style=display:none";
	}
	
	Connection con 		= null; //(Connection) session.getValue( "connection" );
	String facilityId 		= (String) session.getValue( "facility_id" ) ;
	Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;
	String userid = p.getProperty("login_user") ;
	PreparedStatement stmt=null;
	ResultSet rs = null;
	String patient_type=request.getParameter("patient_type");
	String sql="";
	try
	{
		con = ConnectionManager.getConnection(request);

		if(patient_type.equals("null")) patient_type="C";

		sql=   "select 'x' from mr_user_access_rights_vw where  FACILITY_ID = ?  and APPL_USER_ID = ? and ACCESS_TYPE    ='E'  and PATIENT_TYPE = ? and ACCESS_SCOPE='SD' ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1, facilityId);
		stmt.setString(2, userid);
		stmt.setString(3, patient_type);
		rs=stmt.executeQuery();

		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String rec_exist="";
		try{

				sql="SELECT /*GET_TASK_APPLICABILITY('MARK_DIAG_ERROR',NULL,?,?,?,?,?),*/ nvl((SELECT 'Y' FROM pr_problem_enc_err_log WHERE PATIENT_ID=? AND ROWNUM=1),'N') ERR_EXIST   FROM DUAL";
				pstmt=con.prepareStatement(sql);
			/*	pstmt.setString(1,resp_id);
				pstmt.setString(2,reln_id);
				pstmt.setString(3,facilityId);
				pstmt.setString(4,Encounter_Id);
				pstmt.setString(5,Patient_Id);*/
				pstmt.setString(1,Patient_Id);
				rset=pstmt.executeQuery();

		if (rset.next()){
				rec_exist=rset.getString("ERR_EXIST");
		}
}catch(Exception e){
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace();
}
finally
{
	if(pstmt!=null)
			pstmt.close();
	if(rset!=null)
			rset.close();
}

            _bw.write(_wl_block8Bytes, _wl_block8);

		if(rs!=null)
		{
			if(rs.next())
			{

	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);

						if (!auth_mode.equals("")){    
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(auth_mode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(auth_mode));
            _bw.write(_wl_block14Bytes, _wl_block14);
					}
			}else{
			authorizeButton="N";

			}
		}
		//else{
		//	out.println("<script language=javascript>alert(222);</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		//	authorizeButton="N";
		//}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
	if (rec_exist.equals("Y") ) {
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
	if(errorModify.equals("Y")&& encounter_clor.equals("Y")) { 
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Sec_Hdg_Code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(invoking_function));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(context));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stage_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(stage_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(QueryString1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(authorizeButton));
            _bw.write(_wl_block39Bytes, _wl_block39);

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
	e.printStackTrace(System.err);
	}
 }

            _bw.write(_wl_block40Bytes, _wl_block40);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
