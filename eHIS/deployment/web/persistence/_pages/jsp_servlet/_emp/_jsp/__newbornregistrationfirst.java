package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __newbornregistrationfirst extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NewbornRegistrationFirst.jsp", 1726634622821L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n\t<script src=\'../../eMP/js/NewbornRegistration.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\n\t\t</script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\t\tvar motherid = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\tvar function_id = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tself.location.href=\"../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id=\"+motherid+\"&function_id=\"+function_id+\"&accessRights=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&parent_details=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&function_invoked=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&module_invoked=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&mother_nursing_unit=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&mother_bed_no=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&function_name=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&calling_module_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&called_from_mothercare=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&mother_patient_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&ca_encounter_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&ipInstallYn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&siteId=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&patIidLength=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbPatSerGrp=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbUseMotherSer=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&invkAdmFrmNBYn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>\n\t\t\n\t\tnewBornReg();\n\t\t\t\n\t\tasync function newBornReg(){\n\t\t\t\n\t\t\t\n\t\t\tvar retVal = \tnew String();\n\t\t\t//var dialogHeight= \"30\" ;//30\n\t\t\t//var dialogWidth\t= \"49.8\" ;//49.8\n\t\t\tvar dialogHeight= \'400px\' ;\n\t\t\tvar dialogWidth\t= \'700px\' ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; scroll=no; status:\" + status;\n\t\t\tvar motherid = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\tvar module_invoked = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\tif(function_id==\"\"){\n\t\t\t\t//alert(\"inside function9\");\n\t\t\t\tretVal = await window.showModalDialog(\"../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?accessRights=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&mother_id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\",arguments,features);if(retVal != null){\n\t\t\t\t\tvar arr = retVal.split(\'`\');\n\t\t\t\t\tif(arr[1] == \'N\'){\n\t\t\t\t\t//\talert(\"inside function10\");\n\t\t\t\t\t\talert(parent.frames[1].getMessage(\'NO_MOTHER_BABY_LINKS\',\'MP\'));\t\t\n\t\t\t\t\t\tself.location.href=\"../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id=\"+arr[0]+\"&function_id=\"+function_id+\"&accessRights=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" ;\n\t\t\t\t\t}else if(arr[1] == \'C\'){ \n\t\t\t\t\t//alert(\"inside function11\");\n\t\t\t\t\t\tif (module_invoked != \"IP\") {\n\t\t\t\t\t\tcreate();\n\t\t\t\t\t\t} \n\t\t\t\t\t}else {\t\n\t\t\t\t\t//alert(\"inside function12\");\n\t\t\t\t\tself.location.href=\"../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id=\"+arr[0]+\"&function_id=\"+function_id+\"&accessRights=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tself.location.href=\"../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id=\"+motherid+\"&function_id=\"+function_id+\"&accessRights=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ;\t\t\t\n\t\t\t\t}\n\t\t}\n\t\t</script>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
 
	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block5Bytes, _wl_block5);

	String Facility_Id = (String) session.getValue("facility_id");
	String motherid = request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
	if(motherid==null)motherid="";
	String function_name 	= request.getParameter( "function_name" ) ;
	if ( function_name	== null ) function_name	= "" ;		
	String function_id = request.getParameter("function_id") ;
	if(function_id == null)function_id = "" ;
	String reviewnblinksbefregyn = "";
	String accessRights = request.getParameter("accessRights");
	if( accessRights == null) accessRights="";	
	String parent_details = request.getParameter("parent_details");
	if( parent_details == null) parent_details="";
	parent_details = java.net.URLEncoder.encode(parent_details);
	String function_invoked = request.getParameter("function_invoked");
	if( function_invoked == null) function_invoked="";
	String module_invoked = request.getParameter("module_invoked")==null?"":request.getParameter("module_invoked");
	String calling_module_id = request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");
	String called_from_mothercare = request.getParameter("called_from_mothercare")==null?"":request.getParameter("called_from_mothercare");
	String mother_nursing_unit = request.getParameter("mother_nursing_unit")==null?"":request.getParameter("mother_nursing_unit");
	String mother_bed_no = request.getParameter("mother_bed_no")==null?"":request.getParameter("mother_bed_no");	
	String mother_patient_id = request.getParameter("mother_patient_id")==null?"":request.getParameter("mother_patient_id");	
	String ca_encounter_id		= request.getParameter("ca_encounter_id") == null ? "" : request.getParameter("ca_encounter_id");

	String ipInstallYn = "";
	String siteId = "";
	String patIidLength = "";
	String nbPatSerGrp = "";
	String nbUseMotherSer = "";
	String invkAdmFrmNBYn = "";


	if (module_invoked.equals("IP")){
		function_id=""; //added to call baby links on first invocation from IP.
	}	
	
	if(mother_patient_id.equals("")){
		mother_patient_id=motherid;
	}
	
	Connection con = null;
	PreparedStatement pstmt	= null;
	ResultSet rset		= null;

	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(" select review_nb_links_bef_reg_yn from mp_param where module_id='MP' ");
		pstmt = con.prepareStatement(" select (select install_yn from sm_module where module_id = 'IP') ip_install_yn, (select site_id from sm_site_param) site_id, (select invoke_adm_from_newborn_yn from ip_param where facility_id = ? ) invkAdmFrmNBYn, review_nb_links_bef_reg_yn, patient_id_length, newborn_pat_ser_grp, nb_use_mother_ser from mp_param where module_id='MP' ");

		pstmt.setString(1,Facility_Id);
		rset = pstmt.executeQuery();

		if(rset!=null && rset.next()){

			ipInstallYn	= rset.getString("ip_install_yn") == null?"N":rset.getString("ip_install_yn");
			siteId	= rset.getString("site_id") == null?"":rset.getString("site_id");
			invkAdmFrmNBYn	= rset.getString("invkAdmFrmNBYn") == null?"N":rset.getString("invkAdmFrmNBYn");
			reviewnblinksbefregyn	= rset.getString("review_nb_links_bef_reg_yn") == null?"":rset.getString("review_nb_links_bef_reg_yn");
			patIidLength	= rset.getString("patient_id_length");
			nbPatSerGrp	= rset.getString("newborn_pat_ser_grp") == null?"":rset.getString("newborn_pat_ser_grp");
			nbUseMotherSer	= rset.getString("nb_use_mother_ser") == null?"":rset.getString("nb_use_mother_ser");
		}
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	if(function_id!=""){
	
            _bw.write(_wl_block6Bytes, _wl_block6);
}
	if(reviewnblinksbefregyn.equals("N")){
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ipInstallYn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patIidLength));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nbPatSerGrp));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nbUseMotherSer));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(invkAdmFrmNBYn));
            _bw.write(_wl_block26Bytes, _wl_block26);

	}else{
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ipInstallYn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ipInstallYn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patIidLength));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nbPatSerGrp));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nbUseMotherSer));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(invkAdmFrmNBYn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ipInstallYn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patIidLength));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nbPatSerGrp));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nbUseMotherSer));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(invkAdmFrmNBYn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ipInstallYn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patIidLength));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nbPatSerGrp));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nbUseMotherSer));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(invkAdmFrmNBYn));
            _bw.write(_wl_block34Bytes, _wl_block34);

	}

            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
