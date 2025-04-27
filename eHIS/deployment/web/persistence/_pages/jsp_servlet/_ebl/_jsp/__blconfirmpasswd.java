package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blconfirmpasswd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLConfirmPassWd.jsp", 1738642706295L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\tfunction call_pass_valid()\n\t{ \n\t\tvar user = document.forms[0].user.value;\n\t\tvar err_msg = document.forms[0].err_msg.value;\n\t\tif(err_msg!=\"\"){\n\t\t\talert(getMessage(err_msg,\'BL\'));\n\t\t\treturn false;\n\t\t}\n\n\t\tvar remarks = document.forms[0].remarks.value;\n\n\t\tvar upd_fin_dtl = document.forms[0].upd_fin_dtl.value;\n\t\tvar called_frm = document.forms[0].called_frm.value;\n\t\tvar reimb_override_allow_YN = document.forms[0].reimb_override_allow_YN.value;\n\t\tvar max_part_serv_reim_per = document.forms[0].max_part_serv_reim_per.value;\n\t\tvar max_part_serv_reim_amt = document.forms[0].max_part_serv_reim_amt.value;\n\t\tvar override_control = document.forms[0].override_control.value;\n\t\tvar reimb_reason_code = document.forms[0].reimb_reason_code.value;\n\t\tvar cancel_reason_code = document.forms[0].cancel_reason_code.value;\n\t\tvar cancel_reason_desc = document.forms[0].cancel_reason_desc.value;\n\t\tvar void_Number = document.forms[0].void_Number.value;\n\t\tvar print = document.forms[0].print.value;\n\t\tvar recept_Refund_ind = document.forms[0].recept_Refund_ind.value;\t\t\n\t\tvar errorFlag =document.forms[0].errorFlag.value;\n\t\tvar errorFlag1 =document.forms[0].errorFlag1.value;\n\t\tvar rec_ref_flag =document.forms[0].rec_ref_flag.value;\n\t\t//Added V190828-Gomathi/GHL-SCF-1436 Starts\n\t\tif(called_frm == \"\")\n\t\t\t\t{\n\t\t\t\t\tif(upd_fin_dtl == \"Y\")\n\t\t\t\t\t\tvar returnArray = new Array (\"Y\",\"Y\",remarks,user);\n\t\t\t\t\telse\n\t\t\t\t\t\tvar returnArray = new Array (\"Y\",\"N\",remarks,user);\n\t\t\t\t}else if (called_frm==\"BILL_REIMB_AMT\") {\n\t\t\t\t\tif(reimb_override_allow_YN == \"Y\"){\n\t\t\t\t\t\tvar returnArray = new Array (reimb_override_allow_YN,max_part_serv_reim_per,max_part_serv_reim_amt,override_control,reimb_reason_code);\n\t\t\t\t\t}else{\n\t\t\t\t\t\tvar returnArray = new Array (reimb_override_allow_YN,max_part_serv_reim_per,max_part_serv_reim_amt,override_control,\"\");\n\t\t\t\t\t\talert(getMessage(\"BL6327\",\"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}else if (called_frm==\"PKG_BULK_UPD_ACCESS\"){\t//Added by Rajesh V for MMS-CRF-0125\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar returnArray = new Array (\"Y\",\"Y\",reasonCode,user);\n\t\t\t\t}else if (called_frm==\"EBL_TRANS_SETL_REPRNT\"  && print != \"Y\")\t{\n\t\t\t\t\tif(errorFlag == \"N\"){\n\t\t\t\t\t\talert(getMessage(\'BL1285\',\'BL\'));\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close() ;*/\n\t\t\t\t\t\treturn false;\t\n\t\t\t\t\t}\n\t\t\t\t\tvar returnArray = new Array (\"Y\",\"N\",cancel_reason_code,cancel_reason_desc,user);\n\t\t\t\t}else if (called_frm==\"EBL_TRANS_SETL_REPRNT\"  && print == \"Y\")\t{//Added by Rajesh V for MMS-CRF-0125\t\t\t\t\t\n\t\t\t\t\tif(errorFlag== \"N\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'BL1457\',\'BL\'));\n\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tvar returnArray = new Array (\"Y\",\"N\",\"\",\"\",user);\n\t\t\t\t}\n\t\t\t\telse if (called_frm==\"EBL_TRANS_SETL_RECEIPT\"  && print != \"Y\") \t//Added by Rajesh V for MMS-CRF-0125\n\t\t\t\t{\t\n\t\t\t\t\tif(rec_ref_flag==\"B\"){\n\t\t\t\t\t\tif(errorFlag == \"N\"  && errorFlag1 == \"N\" ) {\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\'BL00941\',\'BL\'));\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}else if(errorFlag == \"N\"){\n\t\t\t\t\t\t\talert(getMessage(\'BL1303\',\'BL\'));\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}else if( errorFlag1 == \"N\" ){\n\t\t\t\t\t\t\talert(getMessage(\'BL1304\',\'BL\'));\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t}else if((errorFlag== \"N\") &&(recept_Refund_ind ==\"R\" || rec_ref_flag == \"R\")){\n\t\t\t\t\t\t\talert(getMessage(\'BL1303\',\'BL\'));\t\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t}else if(( errorFlag1 == \"N\") &&(recept_Refund_ind ==\"F\"  || rec_ref_flag == \"F\")){\n\t\t\t\t\t\talert(getMessage(\'BL1304\',\'BL\'));\n\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar returnArray = new Array (\"Y\",\"N\",cancel_reason_code,cancel_reason_desc,void_Number,user);\n\t\t\t\t\t\n\t\t\t\t}else if (called_frm==\"EBL_TRANS_SETL_RECEIPT\"  && print == \"Y\" ) \t//Added by Rajesh V for MMS-CRF-0125\n\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tif(errorFlag == \"N\"  && errorFlag1 == \"N\" && rec_ref_flag==\"B\"){\n\t\t\t\t\t\talert(getMessage(\'BL00938\',\'BL\'));\n\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}else if(errorFlag== \"N\" &&(recept_Refund_ind ==\"R\" || (rec_ref_flag==\"B\" || rec_ref_flag == \"R\"))){\n\t\t\t\t\t\t\talert(getMessage(\'BL00939\',\'BL\'));\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t}else if((errorFlag == \"N\" || errorFlag1 == \"N\") &&(recept_Refund_ind ==\"F\" ||(rec_ref_flag==\"B\" ||  rec_ref_flag == \"F\"))){\n\t\t\t\t\t\talert(getMessage(\'BL00940\',\'BL\'));\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); */\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tvar returnArray = new Array (\"Y\",\"N\",errorFlag,\"Y\",remarks,user);\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\telse if(called_frm==\'EBL_TRANS_INS_RECORD_APPROVAL\')\n\t\t\t\t\t{\n\t\t\t\t\t//alert(\'EBL_TRANS_INS_RECORD_APPROVAL\'); // COMMENTED V190513 DHANANJAY /MMS-DM-SCF-612/START\n\t\t\t\t\tvar returnArray=new Array(\"SuccessfulUser\",\"Y\");\t\t\t\t\t\n\t\t\t\t\t//alert(\'returnArray\'+returnArray);  // COMMENTED V190513 DHANANJAY /MMS-DM-SCF-612/START\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\tparent.window.returnValue=returnArray;\n\t\t\t\tparent.window.close();\n\t\t\t\t/*let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\tdialogBody.contentWindow.returnValue = returnArray;\n    \n\t\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\tdialogTag.close(); */\n\t\t\n\t}\n</script>\n\n<body onLoad=\"call_pass_valid();\">\n<form>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<input type=\'hidden\' name=\'user\' id=\'user\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\'hidden\' name=\'err_msg\' id=\'err_msg\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type=\'hidden\' name=\'upd_fin_dtl\' id=\'upd_fin_dtl\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\'hidden\' name=\'called_frm\' id=\'called_frm\' id=\'called_frm\'   value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\'hidden\' name=\'reimb_override_allow_YN\' id=\'reimb_override_allow_YN\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\'hidden\' name=\'max_part_serv_reim_per\' id=\'max_part_serv_reim_per\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\'hidden\' name=\'max_part_serv_reim_amt\' id=\'max_part_serv_reim_amt\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\'hidden\' name=\'override_control\' id=\'override_control\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\'hidden\' name=\'reimb_reason_code\' id=\'reimb_reason_code\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\'hidden\' name=\'cancel_reason_code\' id=\'cancel_reason_code\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\'hidden\' name=\'cancel_reason_desc\' id=\'cancel_reason_desc\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\'hidden\' name=\'void_Number\' id=\'void_Number\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\'hidden\' name=\'print\' id=\'print\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\'hidden\' name=\'recept_Refund_ind\' id=\'recept_Refund_ind\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\'hidden\' name=\'rec_ref_flag\' id=\'rec_ref_flag\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\t\n\t<input type=\'hidden\' name=\'errorFlag\' id=\'errorFlag\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\'hidden\' name=\'errorFlag1\' id=\'errorFlag1\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
Sr No        Version           TFS/Incident        SCF/CRF            		 		 Developer Name
--------------------------------------------------------------------------------------------------------
1		    V220322	    		27763			  MMS-ME-SCF-0052 					   Mohana Priya K
--------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);


	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con = null;
	CallableStatement call =null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSet rst=null;

	Statement stmt1=null;
	Statement stmt2=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	PreparedStatement pstmt=null;
	String err_msg="";
	String usr_id="",pass_wd="", query_usr_id="", query_pass_wd="", pass_word="",upd_fin_dtl="",remarks="", mod_fin_chk = "N",cancel_reason_code="",cancel_reason_desc="", query_elgb_user="";	
	String called_frm="", blng_serv_code="",blng_serv_date="",serv_item_code="",reimb_override_allow_YN="",max_part_serv_reim_per="",max_part_serv_reim_amt="";
	String valid_user_rec_found_YN="N",override_control="",serv_module_id="",reimb_reason_code="",void_Number="",print="",recept_Refund_ind="",rec_ref_flag="",valid_eligible_user="";	
	String errorFlag ="",errorFlag1 ="",responsibilityId="",loggeduser="";
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String facility_id  =  (String) session.getValue("facility_id") ;
		request.setCharacterEncoding("UTF-8");
		usr_id	= 	request.getParameter("usr_id");
		pass_wd	= 	request.getParameter("pass_wd");
		upd_fin_dtl	= 	request.getParameter("upd_fin_dtl");
		remarks	= 	request.getParameter("remarks");
		mod_fin_chk = request.getParameter("mod_fin_chk");
		called_frm  = request.getParameter("called_frm");
		blng_serv_code=request.getParameter("blng_serv_code");
		blng_serv_date=request.getParameter("blng_serv_date");
		serv_item_code=request.getParameter("serv_item_code");
		serv_module_id=request.getParameter("serv_module_id");
		reimb_reason_code=request.getParameter("reimb_reason_code");
		cancel_reason_code=request.getParameter("cancel_reason_code");
		cancel_reason_desc=request.getParameter("cancel_reason_desc");
		void_Number=request.getParameter("void_Number");
		print = request.getParameter("print");
		recept_Refund_ind = request.getParameter("recept_Refund_ind");
		rec_ref_flag = request.getParameter("rec_ref_flag");
		loggeduser=request.getParameter("loggeduser");		
		
		responsibilityId=(String)session.getAttribute("responsibility_id");
   		java.sql.Date curDate= new java.sql.Date(new java.util.Date().getTime());		
		
		if(usr_id==null) usr_id="";
		usr_id=usr_id.trim();

		if(pass_wd==null) pass_wd="";pass_wd=pass_wd.trim();
	

		if(upd_fin_dtl==null)upd_fin_dtl="N";
		upd_fin_dtl=upd_fin_dtl.trim();

		if(remarks==null)remarks="";
		remarks=remarks.trim();

		if(mod_fin_chk==null) mod_fin_chk = "N";
		mod_fin_chk=mod_fin_chk.trim();		

		if(called_frm == null) called_frm="";
		if(blng_serv_code == null) blng_serv_code="";
		if(blng_serv_date == null) blng_serv_date="";
		if(serv_item_code == null) serv_item_code="";
		if(serv_module_id == null) serv_module_id="";
		if(reimb_reason_code == null) reimb_reason_code="";
		if(cancel_reason_code == null) cancel_reason_code="";
		if(cancel_reason_desc == null) cancel_reason_desc="";
		if(void_Number==null) void_Number="";
		if(print==null) print="";
		if(recept_Refund_ind==null) recept_Refund_ind="";
		if(rec_ref_flag==null) rec_ref_flag="";		
		if(loggeduser==null) loggeduser="";		

            _bw.write(_wl_block6Bytes, _wl_block6);

	stmt = con.createStatement();
	stmt1 = con.createStatement();
	stmt2 = con.createStatement();
	if(called_frm.equals(""))
	{
		query_usr_id = "Select  'X'  from bl_users_for_credit_auth where operating_facility_id = '"+facility_id+"' and ((nvl(fin_dtls_change_auth_yn,'N')='Y' and '"+mod_fin_chk+"'='Y') or (nvl(credit_auth_yn,'N')='Y' and '"+mod_fin_chk+"'='N')) and credit_auth_user_id='"+usr_id+"'";
	}
	if(called_frm.equals("EBL_TRANS_SETL_REPRNT")&& !print.equals( "Y"))
	{
		query_usr_id = "Select   BILL_CANCEL_AUTH_YN from bl_users_for_credit_auth where operating_facility_id = '"+facility_id+"' and ((nvl(fin_dtls_change_auth_yn,'N')='Y' and '"+mod_fin_chk+"'='Y') or (nvl(credit_auth_yn,'N')='Y' and '"+mod_fin_chk+"'='N')) and credit_auth_user_id='"+usr_id+"'";
	}
	if(called_frm.equals("EBL_TRANS_SETL_RECEIPT" ) && !print.equals( "Y"))
	{
		query_usr_id = "Select   nvl(RECEIPT_CANCEL_AUTH_YN,'N'),nvl(REFUND_CANCEL_AUTH_YN,'N')  from bl_users_for_credit_auth where operating_facility_id = '"+facility_id+"' and ((nvl(fin_dtls_change_auth_yn,'N')='Y' and '"+mod_fin_chk+"'='Y') or (nvl(credit_auth_yn,'N')='Y' and '"+mod_fin_chk+"'='N')) and credit_auth_user_id='"+usr_id+"'";
	}else if(called_frm.equals("EBL_TRANS_SETL_RECEIPT" ) && print.equals( "Y") && (recept_Refund_ind.equals("F")) || (rec_ref_flag.equals("F"))){		
			query_usr_id =  "SELECT Distinct REPRINT_REFUND_AUTH_YN    FROM bl_users_for_credit_auth WHERE operating_facility_id = '"+facility_id+"' AND upper(credit_auth_user_id) = upper('"+usr_id+"')   AND status IS NULL ";
	}else if(called_frm.equals("EBL_TRANS_SETL_RECEIPT" ) && print.equals( "Y") && (recept_Refund_ind.equals("R"))|| (rec_ref_flag.equals("R"))){
		query_usr_id =  "SELECT Distinct REPRINT_RECEIPT_AUTH_YN   FROM bl_users_for_credit_auth WHERE operating_facility_id = '"+facility_id+"' AND upper(credit_auth_user_id) = upper('"+usr_id+"')   AND status IS NULL ";
	}else if(called_frm.equals("EBL_TRANS_SETL_RECEIPT" ) && print.equals( "Y") && rec_ref_flag.equals("B") ){
		query_usr_id =  "SELECT Distinct REPRINT_RECEIPT_AUTH_YN,REPRINT_REFUND_AUTH_YN   FROM bl_users_for_credit_auth WHERE operating_facility_id = '"+facility_id+"' AND upper(credit_auth_user_id) = upper('"+usr_id+"')   AND status IS NULL ";
	} 
	//added against pmg-common-crf-0077 crfs
	else if(called_frm.equals("EBL_TRANS_SETL_RECEIPT" ) && print.equals( "Y") && (recept_Refund_ind.equals(""))|| (rec_ref_flag.equals("R"))){
		System.err.println("267");
		query_usr_id =  "SELECT Distinct REPRINT_RECEIPT_AUTH_YN   FROM bl_users_for_credit_auth WHERE operating_facility_id = '"+facility_id+"' AND upper(credit_auth_user_id) = upper('"+usr_id+"')   AND status IS NULL ";
	}
	
	if(called_frm.equals("EBL_TRANS_SETL_REPRNT" ) && print.equals( "Y")) {
			query_usr_id ="SELECT Distinct REPRINT_BILL_AUTH_YN   FROM bl_users_for_credit_auth WHERE operating_facility_id ='"+facility_id+"' AND upper(credit_auth_user_id) =  upper('"+usr_id+"')  AND status IS NULL "; 
	}	
	
	if(called_frm.equals("BILL_REIMB_AMT"))
	{
		query_usr_id = "Select Distinct 'X' From BL_USERS_FOR_CREDIT_AUTH Where CREDIT_AUTH_USER_ID='"+usr_id+"' and OPERATING_FACILITY_ID='"+facility_id+"'";
	}
	if("PKG_BULK_UPD_ACCESS".equals(called_frm)){
		//Added by Rajesh V for MMS-CRF-0125
		query_usr_id = "Select Distinct 'X' From BL_USERS_FOR_CREDIT_AUTH Where CREDIT_AUTH_USER_ID='"+usr_id+"' and OPERATING_FACILITY_ID='"+facility_id+"'";
	}	
	
	query_pass_wd="select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id='"+usr_id+"' ";
	//Added V190828-Gomathi/GHL-SCF-1436 Starts
	query_elgb_user=" select eff_status from sm_appl_user a, sm_facility_for_user b where b.appl_user_id = a.appl_user_id  and a.appl_user_id= '"+usr_id+"' and facility_id = '"+facility_id+"' ";
		pstmt=con.prepareStatement(query_elgb_user);
		rs2=pstmt.executeQuery();		
		while(rs2!=null && rs2.next())
		{	
			valid_eligible_user = rs2.getString(1);
		}
	//Added V190828-Gomathi/GHL-SCF-1436 Ends 
	
 try{ 
	rs = stmt.executeQuery(query_usr_id);	
	if(rs.next())
	{
		valid_user_rec_found_YN = "Y";
		if(called_frm.equals("EBL_TRANS_SETL_RECEIPT" ) && print.equals( "Y")) {
			errorFlag=rs.getString(1);
			if( rec_ref_flag.equals("B")) {
				errorFlag1=rs.getString(2);	
			}
		}	
		if(called_frm.equals("EBL_TRANS_SETL_REPRNT" ) && print.equals( "Y")) {
				errorFlag=rs.getString(1);
		}
		if(called_frm.equals("EBL_TRANS_SETL_REPRNT" ) && !print.equals( "Y")) {
			errorFlag=rs.getString(1);
	}
		if(called_frm.equals("EBL_TRANS_SETL_RECEIPT" ) && !print.equals( "Y")) {
			errorFlag=rs.getString(1);
			//if( rec_ref_flag.equals("B")) {
				errorFlag1=rs.getString(2);	
		//	}
		}	
	/*	if(called_frm.equals("EBL_TRANS_SETL_REPRNT" ) && !print.equals( "Y")) {
				errorFlag=rs.getString(1);
		}	*/
		rs1 = stmt1.executeQuery(query_pass_wd);
		while((rs1.next()))
		{			
			pass_word = rs1.getString("pass_wd");
		}
		pass_word=pass_word.trim();		
	}
	else
	{
		valid_user_rec_found_YN="N";
	}
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("exception in rst"+e);	
	}
 
	if(called_frm.equals("EBL_TRANS_INS_RECORD_APPROVAL"))
	{		
		try{
		
		try{
			call = con.prepareCall("{ call blpolicyuseraccessdtls.get_bl_multi_privlege_yn(?,?,?,?,?,?,?,?,?,?,?) }");
			call.setString(1,facility_id);
			System.out.println("loggeduser before set "+usr_id);
			call.setString(2,usr_id);
			call.setString(3,responsibilityId);
			call.setString(4,"RECORD_APPROVAL");
			call.setString(5,"**");
			call.setString(6,"**");
			call.setString(7,"**");
			call.setString(8,"CHG_APPR_STATUS_FOR_BILLED_REC");
			call.setDate(9,curDate);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.registerOutParameter(11,java.sql.Types.VARCHAR);
			call.execute();	
			String privilageValue = call.getString(10);	
			valid_user_rec_found_YN = call.getString(11);
			
			if(valid_user_rec_found_YN==null) valid_user_rec_found_YN="N";			
		}		
		catch(Exception e)
		{			
			e.printStackTrace();
			System.err.println("Exception in  blpolicyuseraccessdtls.get_bl_multi_privlege_yn "+e);		
		}	
		
		try{
			
			pstmt=con.prepareStatement(query_pass_wd);
			rst=pstmt.executeQuery();
			if(rst!=null)
			{
				while(rst.next())
				{
					pass_word = rst.getString("pass_wd");
				}
				pass_word=pass_word.trim();			
			}			
		}catch(Exception e1)
		{
			e1.printStackTrace();
			System.err.println("Exception in e1 "+e1);
		}		
		}catch(Exception ee)
		{
			ee.printStackTrace();
			System.err.println("Exception in EBL_TRANS_INS_RECORD_APPROVAL" +ee);
		}	
	} 
 
	if(valid_user_rec_found_YN.equals("Y") && called_frm.equals("BILL_REIMB_AMT"))
	{
		try
		{
			call = con.prepareCall("{ ? = call  BLCORE.CHK_SERV_REIM_OVERRIDE_ALLOWED(?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,facility_id);
			call.setString(3,blng_serv_code);
			call.setString(4,usr_id);
			call.setString(5,blng_serv_date);
			if(serv_module_id.equals("PS") || serv_module_id.equals("MM") || serv_module_id.equals("ST") || serv_module_id.equals("PH"))
			{
				call.setString(6,serv_item_code);
			}
			else
			{
				call.setString(6,"");
			}
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);

			call.execute();							
			reimb_override_allow_YN = call.getString(1);				
			max_part_serv_reim_per = call.getString(7);				
			max_part_serv_reim_amt = call.getString(8);				
			override_control = call.getString(9);				
			call.close();

			if ( reimb_override_allow_YN == null ) reimb_override_allow_YN = "N";
			if ( max_part_serv_reim_per == null ) max_part_serv_reim_per = "";
			if ( max_part_serv_reim_amt == null ) max_part_serv_reim_amt = "";
			if ( override_control == null ) override_control = "";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("CHK_SERV_REIM_OVERRIDE_ALLOWED execution---"+e);
		}
	}
	System.err.println("422,valid_eligible_user-"+valid_eligible_user);
		if(valid_eligible_user.equals("D"))	
			{
				err_msg="BL1025";
				
			}
		if(valid_user_rec_found_YN .equals("N"))
			{
				err_msg="BL9539";
			}
		else if(!(pass_word.toUpperCase()).equals(pass_wd.toUpperCase()))
			{
				err_msg="BL1232";
			}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(usr_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(err_msg));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(upd_fin_dtl));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(reimb_override_allow_YN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(max_part_serv_reim_per));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(max_part_serv_reim_amt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(override_control));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(reimb_reason_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cancel_reason_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cancel_reason_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(void_Number));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(print));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recept_Refund_ind));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rec_ref_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(errorFlag));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(errorFlag1));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception@1 : "+e);
	}
	finally
	{
		if (rs != null)   rs.close();
		if (rs1 != null)   rs1.close();
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
