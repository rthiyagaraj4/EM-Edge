package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import webbeans.eCommon.ConnectionManager;
import eMP.*;
import eXH.InterfaceUtil;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __changepatientdtlsdocmisc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ChangePatientDtlsDocMisc.jsp", 1743068504038L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Latest Modified Date : 9/17/2005 9:29 AM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n<!--Added by Ashwini on 15-Oct-2018 for TBMC-CRF-0005.1-->\n<script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script>\n<head>\n<style>\n\ttextarea {\n\t  \tresize: none;\n\t}\n</style>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script>\n\t\n/* Below line was added by Suresh.M on 14-Aug-2012  against  SKR-SCF-0631 [IN035065] */\nfunction makeValidStringRemark(txtObj)\n{  \n    var text_value  =   txtObj.value;\n\t\n    while(text_value.indexOf(\'\"\')!=-1)\n    {\n        text_value = text_value.replace(\'\"\',\"\'\");\n    }\n\t\n\twhile (text_value.indexOf(\'+\')!=-1)\n\t{ \n\ttext_value=text_value.replace(\'+\',\"\");\n\t}\n\twhile (text_value.indexOf(\'%\')!=-1)\n\t{ \n\ttext_value=text_value.replace(\'%\',\"\");\n\t}\n\t\n    txtObj.value = text_value;\n\n    if(text_value.indexOf(\"&\")==(text_value.length-1))\n    {\n        return false;\n    }\n\n    for(var i=0; i<text_value.length; i++)\n    {\n        if( (text_value.charAt(i)==\'&\')  || (text_value.charAt(i)==\'<\') )\n        {\n            if(text_value.charAt(i+1)!=\' \')\n            {\n                text_value  =   text_value.substring(0,(i+1))+\' \'+ text_value.substring((i+1),text_value.length);\n                i++;\n            }\n        }\n    }\n    txtObj.value = text_value;\n    if(txtObj.value.length>txtObj.maxLength)\n    {\n        alert(getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null));\n\n        txtObj.select();\n        txtObj.focus();\n    }\n}\n\t/*SKR-SCF-0631 [IN035065]*/\n\t/* Below function was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ \t\nasync function viewDocument(patientID,column_name,isViewPrintPatDoc,ndhm_appl_YN)\n{\nvar dialogHeight = \'800px\' ;\nvar dialogWidth  = \'1400px\' ;\nif(ndhm_appl_YN==\'Y\'){\n\tdialogHeight = \'800px\' ;\n\tdialogWidth  = \'1400px\' ;\n}\nvar features     = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; status=no;\'\nvar arguments    = \'\' ;\nvar retVal =await window.showModalDialog(\"../../eMP/jsp/ViewPatientDocFrame.jsp?patient_id=\"+patientID+\"&isViewPrintPatDoc=\"+isViewPrintPatDoc+\"&column_name=\"+column_name,arguments,features); \n}\n\n/* end PMG2012-CRF-0006 [IN034693] */ \t\n/*Added BY Dharma on 19th Jan 2021 against RBU-COMMON-IND-CRF-0002 Start*/\nfunction downloadDocument(patientID,column_name) {\n\tparent.parent.frames[2].document.open();\n\tHTMLVal = \"<HTML><head></head><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMP/jsp/ViewPatientDocument.jsp\'><input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'\"+patientID+\"\'><input name=\'column_name\' id=\'column_name\' type=\'hidden\' value=\'\"+column_name+ \"\'><input name=\'action\' id=\'action\' type=\'hidden\' value=\'download\'></form></BODY></HTML>\";\n\tparent.parent.frames[2].document.write(HTMLVal);\n\tparent.parent.frames[2].document.form1.submit();\n\tparent.parent.frames[2].document.close();\n}\n/*Added BY Dharma on 19th Jan 2021 against RBU-COMMON-IND-CRF-0002 End*/\n\n\t\n\t</script>        \n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	/*Added by lakshmanan on nov 03 2022 against GHL-CRF-0657.1*/
	public static String getNDHMApplicable(Connection con){
		String sqlNDHMApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%NDHMPROF1%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String ndhmYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlNDHMApplicable);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				ndhmYN="Y";
			}
		}catch(Exception ex){
			System.err.println("Exception in getNDHMApplicable --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return ndhmYN;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8"); 
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		 /*Added by Ashwini on 15-Oct-2018 for TBMC-CRF-0005.1*/
		 String facility_id = (String)session.getAttribute("facility_id");
		 String login_user_id =	(String)session.getValue("login_user");	
		 String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
		 Properties p =	(java.util.Properties) session.getValue("jdbc");
		 /*End TBMC-CRF-0005.1*/

		String locale					= (String)session.getAttribute("LOCALE");
		String patient_id			= (String)request.getParameter("patient_id");
		String dependency		= (String)request.getParameter("dependency");
		String arrangement		= (String)request.getParameter("arrangement");
		String education_level	= (String)request.getParameter("education_level");
		String educ_level_desc	= (String)request.getParameter("educ_level_desc");
		String informant			= (String)request.getParameter("informant");
		String comments			= (String)request.getParameter("comments");
		int cnt						= Integer.parseInt((String)request.getParameter("cnt"));
		String general_remarks	= (String)request.getParameter("general_remarks") == null ? "" : (String)request.getParameter("general_remarks");

		String doc1_type_code = "";
		String doc1_type_desc = "";
		String doc2_type_code = "";
		String doc2_type_desc = "";
		String doc3_type_code = "";
		String doc3_type_desc = "";
		String doc4_type_code = "";
		String doc4_type_desc = "";
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
	
		String doc1_disable="disabled";
		String doc2_disable="disabled";
		String doc3_disable="disabled";
		String doc4_disable="disabled";
		 java.sql.Blob doc1=null;
		java.sql.Blob doc2=null;
		java.sql.Blob doc3=null;
		java.sql.Blob doc4=null;
		/* end PMG2012-CRF-0006 [IN034693] */
		
		boolean isDownloadDoc	= false;
		boolean isViewPrintPatDoc  =false;
		Connection con			= null;
		ResultSet rs1 = null;
		StringBuffer result = new StringBuffer("");
		try
		{
					   /* Below query was modified  by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			con = ConnectionManager.getConnection(request);
			isDownloadDoc  = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","DOWNLOAD_PAT_DOC");
			isViewPrintPatDoc  = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","VIEW_PRINT_PAT_DOC");
			
			String ndhm_appl_YN="N";
			ndhm_appl_YN 	= getNDHMApplicable(con); //added for NDHM integration GHL-CRF-0657.1 
		
			String sql = "SELECT DOC1_TYPE, nvl(DOC1_NUM,' ') DOC1_NUM, to_char(DOC1_EXP_DATE,'dd/mm/yyyy') DOC1_EXP_DATE, nvl(DOC1_PLACE_OF_ISSUE,'') DOC1_PLACE_OF_ISSUE, to_char(DOC1_ISS_DATE,'dd/mm/yyyy') DOC1_ISS_DATE, nvl(DOC2_TYPE,'') DOC2_TYPE, nvl(DOC2_NUM,'') DOC2_NUM, to_char(DOC2_EXP_DATE,'dd/mm/yyyy') DOC2_EXP_DATE, nvl(DOC2_PLACE_OF_ISSUE,'') DOC2_PLACE_OF_ISSUE, to_char(DOC2_ISS_DATE,'dd/mm/yyyy') DOC2_ISS_DATE, nvl(DOC3_TYPE,'') DOC3_TYPE, nvl(DOC3_NUM,'') DOC3_NUM, to_char(DOC3_EXP_DATE,'dd/mm/yyyy') DOC3_EXP_DATE, nvl(DOC3_PLACE_OF_ISSUE,'') DOC3_PLACE_OF_ISSUE, to_char(DOC3_ISS_DATE,'dd/mm/yyyy') DOC3_ISS_DATE, nvl(DOC4_TYPE,'') DOC4_TYPE, nvl(DOC4_NUM,'') DOC4_NUM, to_char(DOC4_EXP_DATE,'dd/mm/yyyy') DOC4_EXP_DATE, nvl(DOC4_PLACE_OF_ISSUE,'') DOC4_PLACE_OF_ISSUE, to_char(DOC4_ISS_DATE,'dd/mm/yyyy') DOC4_ISS_DATE,DOC1_IMAGE,DOC2_IMAGE,DOC3_IMAGE,DOC4_IMAGE, nvl(DOC1_UPLOAD_FLAG,0) DOC1_UPLOAD_FLAG,nvl(DOC2_UPLOAD_FLAG,0) DOC2_UPLOAD_FLAG,nvl(DOC3_UPLOAD_FLAG,0) DOC3_UPLOAD_FLAG,nvl(DOC4_UPLOAD_FLAG,0) DOC4_UPLOAD_FLAG, DOC1_IMAGE_PATH, DOC2_IMAGE_PATH, DOC3_IMAGE_PATH, DOC4_IMAGE_PATH FROM mp_pat_documents WHERE patient_id = '"+patient_id+"'";

			// Added by Sethu for AAKH-CRF-0075 
			// DOC_DB_FLAG, DOC1_IMAGE_PATH, DOC2_IMAGE_PATH, DOC3_IMAGE_PATH, DOC4_IMAGE_PATH columns has been added to the select clause.
		 /*end PMG2012-CRF-0006 [IN034693] */

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			String doc1_type				= "";
			String doc1_num				= "";
			String doc1_exp_date		= "";
			String doc1_place_of_issue	= "";
			String doc1_iss_date		= "";
			String doc2_type				= "";
			String doc2_num				= "";
			String doc2_exp_date		= "";
			String doc2_place_of_issue	= "";
			String doc2_iss_date		= "";
			String doc3_type				= "";
			String doc3_num				= "";
			String doc3_exp_date		= "";
			String doc3_place_of_issue	= "";
			String doc3_iss_date		= "";
			String doc4_type				= "";
			String doc4_num				= "";
			String doc4_exp_date		= "";
			String doc4_place_of_issue	= "";
			String doc4_iss_date		= "";
			String docexp1disable		= "";
			String docexp2disable		= "";
			String docexp3disable		= "";
			String docexp4disable		= "";	
			
           // Added by Sethu for AAKH-CRF-0075
			String doc1_image_path = "", doc2_image_path = "", doc3_image_path = "", doc4_image_path = "";
			/*Added by Rameswar on  16-03-2016 for  MMS-DM-CRF-0035 */
			int doc1_upload_flag = 0;
			int doc2_upload_flag = 0;
			int doc3_upload_flag = 0;
			int doc4_upload_flag = 0;
			/*Added by Rameswar on  16-03-2016 for  MMS-DM-CRF-0035 */
			// Changes made for AAKH-CRF-0075 ends here

			 /*Added by Ashwini on 15-Oct-2018 for TBMC-CRF-0005.1*/
			 HashMap hash_Map = new HashMap();
			 hash_Map = eMP.ChangePatientDetails.getPatientData(patient_id,con,p);
			 String regn_date = (String)hash_Map.get("regn_date");
			 /*End TBMC-CRF-0005.1*/

			if(rs.next())
			{
				doc1_type					= rs.getString("DOC1_TYPE") == null ? "" : rs.getString("DOC1_TYPE");
				doc1_num					= rs.getString("DOC1_NUM") == null ? "" : rs.getString("DOC1_NUM");
				doc1_exp_date				= rs.getString("DOC1_EXP_DATE") == null ? "" : rs.getString("DOC1_EXP_DATE");
				doc1_place_of_issue	= rs.getString("DOC1_PLACE_OF_ISSUE") == null ? "" : rs.getString("DOC1_PLACE_OF_ISSUE");
				doc1_iss_date			    = rs.getString("DOC1_ISS_DATE") == null ? "" : rs.getString("DOC1_ISS_DATE");
				doc2_type					= rs.getString("DOC2_TYPE") == null ? "" : rs.getString("DOC2_TYPE");
				doc2_num				    = rs.getString("DOC2_NUM") ==null?"":rs.getString("DOC2_NUM");
				doc2_exp_date				= rs.getString("DOC2_EXP_DATE") == null ? "" : rs.getString("DOC2_EXP_DATE");
				doc2_place_of_issue	= rs.getString("DOC2_PLACE_OF_ISSUE") == null ? "" : rs.getString("DOC2_PLACE_OF_ISSUE");
				doc2_iss_date				= rs.getString("DOC2_ISS_DATE") == null ? "" : rs.getString("DOC2_ISS_DATE");
				doc3_type					= rs.getString("DOC3_TYPE") ==null?"":rs.getString("DOC3_TYPE");
				doc3_num					= rs.getString("DOC3_NUM") ==null?"":rs.getString("DOC3_NUM");
				doc3_exp_date				= rs.getString("DOC3_EXP_DATE") == null ? "" : rs.getString("DOC3_EXP_DATE");
				doc3_place_of_issue	= rs.getString("DOC3_PLACE_OF_ISSUE") == null ? "" : rs.getString("DOC3_PLACE_OF_ISSUE");
				doc3_iss_date				= rs.getString("DOC3_ISS_DATE") == null ? "" : rs.getString("DOC3_ISS_DATE");
				doc4_type					= rs.getString("DOC4_TYPE") ==null?"":rs.getString("DOC4_TYPE");
				doc4_num					= rs.getString("DOC4_NUM") ==null?"":rs.getString("DOC4_NUM");
				doc4_exp_date				= rs.getString("DOC4_EXP_DATE") == null ? "" : rs.getString("DOC4_EXP_DATE");
				doc4_place_of_issue	= rs.getString("DOC4_PLACE_OF_ISSUE") == null ? "" : rs.getString("DOC4_PLACE_OF_ISSUE");
				doc4_iss_date				= rs.getString("DOC4_ISS_DATE") == null ? "" : rs.getString("DOC4_ISS_DATE");
				
				// Added by Sethu for AAKH-CRF-0075
				doc1_upload_flag = rs.getInt("DOC1_UPLOAD_FLAG");
				doc2_upload_flag = rs.getInt("DOC2_UPLOAD_FLAG");
				doc3_upload_flag = rs.getInt("DOC3_UPLOAD_FLAG");
				doc4_upload_flag = rs.getInt("DOC4_UPLOAD_FLAG");

                /* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			   /*
			    doc1 =rs.getBlob("DOC1_IMAGE");
				doc2 =rs.getBlob("DOC2_IMAGE");
				doc3 =rs.getBlob("DOC3_IMAGE");
				doc4 =rs.getBlob("DOC4_IMAGE");*/
				/*commented by Rameswar on  05-04-2016 to handle the multiple store location for single patient*/
				 /* end PMG2012-CRF-0006 [IN034693] */


				 // Changed by prithivi on 12/10/2015 -- doc_db_flag is 1 for shared document and 0 for db storage.

				/*Added by Rameswar on  05-04-2016 to handle the multiple store location for single patient */
				if (doc1_upload_flag == 1){   
					doc1_image_path = rs.getString("DOC1_IMAGE_PATH") == null ? "" : rs.getString("DOC1_IMAGE_PATH");}else{
					doc1 =rs.getBlob("DOC1_IMAGE");
					}
				if (doc2_upload_flag == 1){
					doc2_image_path = rs.getString("DOC2_IMAGE_PATH") == null ? "" : rs.getString("DOC2_IMAGE_PATH");}else{
					doc2 =rs.getBlob("DOC2_IMAGE");
					}
				if (doc3_upload_flag == 1){
					doc3_image_path = rs.getString("DOC3_IMAGE_PATH") == null ? "" : rs.getString("DOC3_IMAGE_PATH");}else{
					doc3 =rs.getBlob("DOC3_IMAGE");	
					}
				if (doc4_upload_flag == 1){
					doc4_image_path = rs.getString("DOC4_IMAGE_PATH") == null ? "" : rs.getString("DOC4_IMAGE_PATH");}else{
					doc4 =rs.getBlob("DOC4_IMAGE");
					}
				/*Added by Rameswar on  05-04-2016 to handle the multiple store location for single patient */

			    /* Below line was added by by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
				if(!doc1_type.equals("")){ docexp1disable = "disabled"; doc1_disable="";}
				if(!doc2_type.equals("")){ docexp2disable = "disabled"; doc2_disable="";}
				if(!doc3_type.equals("")){ docexp3disable = "disabled"; doc3_disable="";}
				if(!doc4_type.equals("")){ docexp4disable = "disabled"; doc4_disable="";}
				/* end PMG2012-CRF-0006 [IN034693] */

				if ( !locale.equals("en") )
					{ 
						if (!doc1_exp_date.equals(""))
							doc1_exp_date= DateUtils.convertDate(doc1_exp_date,"DMY","en",locale);
						if (!doc1_iss_date.equals(""))
							doc1_iss_date= DateUtils.convertDate(doc1_iss_date,"DMY","en",locale);
						if (!doc2_exp_date.equals(""))
							doc2_exp_date= DateUtils.convertDate(doc2_exp_date,"DMY","en",locale);
						if (!doc2_iss_date.equals(""))
							doc2_iss_date= DateUtils.convertDate(doc2_iss_date,"DMY","en",locale);
						if (!doc3_exp_date.equals(""))
							doc3_exp_date= DateUtils.convertDate(doc3_exp_date,"DMY","en",locale);
						if (!doc3_iss_date.equals(""))
							doc3_iss_date= DateUtils.convertDate(doc3_iss_date,"DMY","en",locale);
						if (!doc4_exp_date.equals(""))
							doc4_exp_date= DateUtils.convertDate(doc4_exp_date,"DMY","en",locale);
						if (!doc4_iss_date.equals(""))
							doc4_iss_date= DateUtils.convertDate(doc4_iss_date,"DMY","en",locale);
					}
			}
			
			ArrayList codes = new ArrayList();

			//sql = "SELECT doc_type, initcap(short_desc) short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc1_type+"' and eff_status = 'E' ORDER BY 2 ";
			/*Modified By Dharma on Feb 11th 2015 against HSA-SCF-0192 [IN:053070]*/
			sql = "SELECT doc_type, short_desc short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc1_type+"' and eff_status = 'E' ORDER BY 2 ";

			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(sql);
			rs1 = pstmt.executeQuery();
			
			if(rs1 !=null)
			{
				while(rs1.next())
				{
					//codes.add( rs1.getString(1) ) ;
					//codes.add( rs1.getString(2) ) ;
					doc1_type_code = rs1.getString(1);
					doc1_type_desc = rs1.getString(2);
				}	 
			}

			if ( doc1_type_code == null )		doc1_type_code="";
			if ( doc1_type_desc == null )		doc1_type_desc="";

			if(rs1!= null) rs1.close() ;
		    result.append("<div> <table width='100%' cellpadding='1' border='0' cellspacing='0' align='center'>");
			result.append("<tr>");
			result.append("<td  class='COLUMNHEADER'  width='13%'nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.documenttype.label","common_labels")+"</td>");
			result.append("<td  class='COLUMNHEADER'  width='12%' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.documentno.label","common_labels")+"</td>");
			result.append("<td  class='COLUMNHEADER'   width='11%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>");
			result.append("	<td  class='COLUMNHEADER'  width='17%' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PlaceOfIssue.label","mp_labels")+"</td>");
			result.append("<td  class='COLUMNHEADER'   width='11%' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IssueDate.label","common_labels")+"</td>");
			result.append("	<td  class='COLUMNHEADER'  width='21%'  nowrap >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UplodDoc.label","common_labels")+"</td>");
			if(isDownloadDoc){
				result.append("<td  class='COLUMNHEADER'  width='19%'  nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Download.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")+"</td></tr>");
			}else{
				result.append("<td  class='COLUMNHEADER'  width='19%'  nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")+"</td></tr>");
			}
			result.append("<tr>");
			/*result.append("<td class='fields' width='20%'>");
			result.append("<select name='doc_id1' id='doc_id1' onchange='enbl_disble(this)' onfocus= \"parent.patient_main.tab_click('pat_docs_tab')\">");
			result.append("<option value='' >------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------------</option>");
			
			for(int i=0; i<codes.size(); i+=2)
			{
				String sel = "";
				if(doc1_type.equals((String)codes.get(i)))
				sel = "selected";
				result.append("<option value='"+(String)codes.get(i)+"' "+sel+">"+(String)codes.get(i+1)+"</option>") ;
			} 
			result.append("</select></td>");
			*/
						
		   result.append("<td  class='fields'> <input type='text' name='doc_id1_desc' id='doc_id1_desc' size='20' maxlength='20' value=\""+doc1_type_desc+"\" onblur='if(this.value!=\"\"){searchDocumentType(doc_id1,doc_id1_desc);}else{clearfields();} '><input type='button'  id='doc1_id'  name='doc_code_id1' id='doc_code_id1' value='?' class='button' onclick='searchDocumentType(this,doc_id1_desc); '>	<input type='hidden' name='doc_id1' id='doc_id1' value=\""+doc1_type_code+"\"> </td>");

			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 implemented the logic as in 5.x - Begins*/
			String disble_chk_doc2_j="disabled";
			String mandatory_doc1_j="hidden";
			if(doc1_type !="" &&  doc1_type != null )					
				{
				disble_chk_doc2_j="";
				docexp1disable="";
				mandatory_doc1_j="display";  
				}
			
			result.append("<td class='fields'>");
            result.append("<input type='text' name='doc_num1' id='doc_num1'  size=15 maxlength=15  value='"+doc1_num+"' "+disble_chk_doc2_j+" onBlur='makeValidString(this);'><img id='doc1' style='visibility:"+mandatory_doc1_j+"' src='../../eCommon/images/mandatory.gif'></img>");
			result.append("</td><td class='fields'><input type='text' name='doc_exp_dt1' id='doc_exp_dt1' id='docexpdt1' size=10 maxlength=10  onblur = 'validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date1);' value='"+doc1_exp_date+"' "+disble_chk_doc2_j+" onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='docexpdate1' "+docexp1disable+" onClick=\"document.forms[0].doc_exp_dt1.select();return showCalendar('doc_exp_dt1');\" "+disble_chk_doc2_j+"></td>");  //Locale is added by Rameswar on 30-Sep-15 for Leap Year Issue    
			result.append("<td class='fields'><input type='text' name='place_of_issue1' id='place_of_issue1'  size=30 maxlength=30 value=\""+doc1_place_of_issue+"\"' "+disble_chk_doc2_j+" onBlur='makeValidString(this);'></td>");
		    result.append("<td class='fields' ><input type='text' name='issue_date1' id='issue_date1' size=10 maxlength=10  onblur='validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date1);validatIssueDatechk(this,doc_exp_dt1)' value='"+doc1_iss_date+"' "+disble_chk_doc2_j+" onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='issuedt1' "+docexp1disable+" onClick=\"document.forms[0].issue_date1.select();return showCalendar('issue_date1');\" "+disble_chk_doc2_j+"></td>"); //Locale is added by Rameswar on 30-Sep-15 for Leap Year Issue
          
		  /* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			result.append("<td class='fields'> <div id='doc1imageId'><input type='file' name='doc1image' id='doc1image' "+doc1_disable+"  value=''   size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)' >");//This line modified to include div tag for the incident 38504 to clear the file path.

			/*Added by Rameswar on  16-03-2016 for  MMS-DM-CRF-0035 */
					
					String sFacilityId = (String) session.getValue("facility_id");
					int iDocScanEnabled = 0;
					String document_id="";
					String doc1_scan_disable="disabled" ;
					String doc2_scan_disable="disabled" ;
					String doc3_scan_disable="disabled" ;
					String doc4_scan_disable="disabled" ;
					int iDocFolderOption = 0;
					
					List<DocumentConfigBean> oDocConfigList = null;
					List<DocumentTypeBean> oDocTypeList = null;  
					DocumentConfigBean oDocumentConfigBean = null;	
					
					DocumentConfigOption docConfigOption = new DocumentConfigOption(); 		
					oDocConfigList = new ArrayList<DocumentConfigBean>();
					oDocConfigList = docConfigOption.getDocumentConfigDetails(sFacilityId);
					int nDocConfigListsize = oDocConfigList.size();
					if (nDocConfigListsize>0)
					{						
					oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
					sFacilityId 	= oDocumentConfigBean.getsFacilityId();
					iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
					iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();		
					}	
					if((!doc1_type.equals(""))&&(iDocScanEnabled==1)){  doc1_scan_disable="";}
					if((!doc2_type.equals(""))&&(iDocScanEnabled==1)){  doc2_scan_disable="";}
					if((!doc3_type.equals(""))&&(iDocScanEnabled==1)){  doc3_scan_disable="";}
					if((!doc4_type.equals(""))&&(iDocScanEnabled==1)){  doc4_scan_disable="";}

					document_id ="doc_id1"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
						
					 result.append("<input type='button' name='doc1scan' id='doc1scan'  value='Scan' "+doc1_scan_disable+" size=4  onClick=ShowScanner('"+patient_id+"','MP','"+document_id+"',this) style='visibility:hidden'></div></td></td><input type='hidden' name='document_id1' id='document_id1' value='"+document_id+"'><input type='hidden' name='iDocScanEnabled' id='iDocScanEnabled' value='"+iDocScanEnabled+"'><input type='hidden' name='iDocFolderOption' id='iDocFolderOption' value='"+iDocFolderOption+"'> ");
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035 */

			if((!doc1_type.equals(""))&&((doc1 != null) || (doc1_image_path != ""))){   // or condition added by sethu for AAKH-CRF-0075 on 09/07/2015 -- changes made by prithivi 12/10/2015
			 result.append("<td class='data'>");
			 if(isDownloadDoc==true && !doc1_type.equals("99")){
				 result.append("<a name='text' href=\"javascript:onClick=downloadDocument('"+patient_id+"','DOC1_IMAGE')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Download.label","common_labels")+"</a>");	
			 }else{
				 result.append("<a name='text' href=\"javascript:onClick=viewDocument('"+patient_id+"','DOC1_IMAGE','"+isViewPrintPatDoc+"','"+ndhm_appl_YN+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			 }
				result.append("</td>"); 
					  
			}
			result.append("<tr></tr>");
		   /* end against PMG2012-CRF-0006 [IN034693] */ 

			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - Ends*/
			
		/*	result.append("<td class='fields'><select name='doc_id2' id='doc_id2' onchange='enbl_disble(this)' disabled><option value=''>--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----------</option>");
							   
			for(int i=0; i<codes.size(); i+=2)
			{
				String sel = "";
				if(doc2_type.equals((String)codes.get(i)))
					sel = "selected";
				result.append("<option value='"+(String)codes.get(i)+"' "+sel+">"+(String)codes.get(i+1)+"</option>") ;
			} 
			result.append("</select></td>");
			*/

			//sql = "SELECT doc_type, initcap(short_desc) short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc2_type+"' and eff_status = 'E' ORDER BY 2 ";
			/*Modified By Dharma on Feb 11th 2015 against HSA-SCF-0192 [IN:053070]*/
			sql = "SELECT doc_type, short_desc short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc2_type+"' and eff_status = 'E' ORDER BY 2 ";

			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(sql);
			rs1 = pstmt.executeQuery();
			
			if(rs1 !=null)
			{
				while(rs1.next())
				{
					doc2_type_code = rs1.getString(1);
					doc2_type_desc = rs1.getString(2);
				}	 
			}

			if ( doc2_type_code == null )		doc2_type_code="";
			if ( doc2_type_desc == null )		doc2_type_desc="";

			if(rs1!= null) rs1.close() ;
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 implemented the logic as in 5.x - Begins*/
			String disble_chk_doc3_j="disabled";
			String mandatory_doc2_j="hidden";
			String disble_chk_doc1="disabled";
			//if(doc1_type != "" && doc1_type != null)					
				//{
				disble_chk_doc3_j="";
				docexp2disable="";
				if(doc2_type != "" && doc2_type != null){
					mandatory_doc2_j="display";
					disble_chk_doc1="";
				    }
				//}	
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - Ends*/
			result.append("<td  class='fields'> <input type='text' name='doc_id2_desc' id='doc_id2_desc' size='20' maxlength='20' "+disble_chk_doc3_j+" value=\""+doc2_type_desc+"\" onblur='if(this.value!=\"\"){searchDocumentType(doc_id2,doc_id2_desc);}else{clearfields();} '><input type='button'  name='doc2_code_id2' id='doc2_code_id2' "+disble_chk_doc3_j+" value='?' class='button' onclick='searchDocumentType(this,doc_id2_desc); '> <input type='hidden' name='doc_id2' id='doc_id2' value=\""+doc2_type_code+"\"> </td>");
				
							   
						result.append("<td class='fields' ><input type='text' name='doc_num2' id='doc_num2' size=15 maxlength=15 "+disble_chk_doc1+" value='"+doc2_num+"' onBlur='makeValidString(this);'><img id='doc2' style='visibility:"+mandatory_doc2_j+"' src='../../eCommon/images/mandatory.gif'></img></td><td class='fields' ><input type='text' name='doc_exp_dt2' id='doc_exp_dt2'  id='docexpdt2' size=10 maxlength=10 "+disble_chk_doc1+" onblur = 'validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date2);' value='"+doc2_exp_date+"' onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='docexpdate2' "+docexp2disable+" onClick=\"document.forms[0].doc_exp_dt2.select();return showCalendar('doc_exp_dt2');\" "+disble_chk_doc1+"></td><td class='fields' ><input type='text' name='place_of_issue2' id='place_of_issue2'  size=30 maxlength=30 "+disble_chk_doc1+" value=\""+doc2_place_of_issue+"\"' onBlur='makeValidString(this);'></td><td class='fields'><input type='text' name='issue_date2' id='issue_date2' id='issuedate2' size=10 maxlength=10 "+disble_chk_doc1+" onblur='validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date2);validatIssueDatechk(this,doc_exp_dt2)' value='"+doc2_iss_date+"' onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='issuedt2' "+docexp2disable+" onClick=\"document.forms[0].issue_date2.select();return showCalendar('issue_date2');\"  "+disble_chk_doc1+"></td>"); // locale is added by Rameswar on 30-Sep-15 for Leap Year Issue

			result.append("<td class='fields'><div id='doc2imageId'> <input type='file' name='doc2image' id='doc2image' "+doc2_disable+"  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'>");//This line modified to include div tag for the incident 38504 to clear the file path.
			
					/*Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035*/
							document_id ="doc_id2"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
										
					result.append("<input type='button' name='doc2scan' id='doc2scan'  value='Scan' "+doc2_scan_disable+"  size=4  onClick=ShowScanner('"+patient_id+"','MP','"+document_id+"',this) style='visibility:hidden'></div></td><input type='hidden' name='document_id2' id='document_id2' value='"+document_id+"'>");
					 /*Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035*/

          /* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			if((!doc2_type.equals(""))&&((doc2 != null) || (doc2_image_path != ""))){  // or condition added by sethu for AAKH-CRF-0075 on 09/07/2015 -- changes made by prithivi 12/10/2015
					result.append("<td class='data'>");
					if(isDownloadDoc==true && !doc2_type.equals("99")){
						result.append("<a href=\"javascript:onClick=downloadDocument('"+patient_id+"','DOC2_IMAGE')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Download.label","common_labels")+"</a>");
					}else{
						result.append("<a href=\"javascript:onClick=viewDocument('"+patient_id+"','DOC2_IMAGE','"+isViewPrintPatDoc+"','"+ndhm_appl_YN+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
					}
					
					result.append("</td> ");
			  }
			
           /* end PMG2012-CRF-0006 [IN034693] */ 
			result.append("</tr><tr>");

			
			/*
			result.append("<td class='fields'><select name='doc_id3' id='doc_id3' onchange='enbl_disble(this)' disabled><option value=''>--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----------</option>");
			
			for(int i=0; i<codes.size(); i+=2)
			{
				String sel = "";
				if(doc3_type.equals((String)codes.get(i)))
					sel = "selected";
				result.append("<option value='"+(String)codes.get(i)+"' "+sel+">"+(String)codes.get(i+1)+"</option>") ;
			}
			result.append("</select></td>");
			*/


			//sql = "SELECT doc_type, initcap(short_desc) short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc3_type+"' and eff_status = 'E' ORDER BY 2 ";
			/*Modified By Dharma on Feb 11th 2015 against HSA-SCF-0192 [IN:053070]*/
			sql = "SELECT doc_type, short_desc short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc3_type+"' and eff_status = 'E' ORDER BY 2 ";

			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(sql);
			rs1 = pstmt.executeQuery();
			
			if(rs1 !=null)
			{
				while(rs1.next())
				{
					doc3_type_code = rs1.getString(1);
					doc3_type_desc = rs1.getString(2);
				}	 
			}

			if ( doc3_type_code == null )		doc3_type_code="";
			if ( doc3_type_desc == null )		doc3_type_desc="";

			if(rs1!= null) rs1.close() ;
			
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 implemented the logic as in 5.x - Begins*/
			String disble_chk_doc4_j="disabled";
			String mandatory_doc3_j="hidden";	
			String disble_chk_doc2="disabled";
			//if(doc1_type!="" && doc1_type != null)					
				//{
				disble_chk_doc4_j="";
				docexp3disable="";
				if(doc3_type != "" && doc3_type != null){
					mandatory_doc3_j="display";
					disble_chk_doc2="";
					}
					
				//}
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 implemented the logic as in 5.x - Ends*/
			
			result.append("<td  class='fields'> <input type='text' name='doc_id3_desc' id='doc_id3_desc' size='20' maxlength='20' "+disble_chk_doc4_j+" value=\""+doc3_type_desc+"\" onblur='if(this.value!=\"\"){searchDocumentType(doc_id3,doc_id3_desc);}else{clearfields();}'><input type='button'  id='doc3_id'  name='doc3_code_id3' id='doc3_code_id3' "+disble_chk_doc4_j+" value='?' class='button' onclick='searchDocumentType(this,doc_id3_desc); '> <input type='hidden' name='doc_id3' id='doc_id3' value=\""+doc3_type_code+"\"> </td>");
            result.append("<td class='fields'><input type='text' name='doc_num3' id='doc_num3' size=15 maxlength=15 "+disble_chk_doc2+" value='"+doc3_num+"' onBlur='makeValidString(this);'><img id='doc3' style='visibility:"+mandatory_doc3_j+"' src='../../eCommon/images/mandatory.gif'></img></td><td class='fields' ><input type='text' name='doc_exp_dt3' id='doc_exp_dt3' size=10 maxlength=10 "+disble_chk_doc2+" onblur = 'validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date3);' value='"+doc3_exp_date+"'  onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='docexpdate3' "+docexp3disable+" onClick=\"document.forms[0].doc_exp_dt3.select();return showCalendar('doc_exp_dt3');\" "+disble_chk_doc2+"></td><td class='fields' ><input type='text' name='place_of_issue3' id='place_of_issue3'  size=30 maxlength=30 "+disble_chk_doc2+" value=\""+doc3_place_of_issue+"\"' onBlur='makeValidString(this);'></td><td class='fields' ><input type='text' name='issue_date3' id='issue_date3' id='issuedate3' size=10 maxlength=10 "+disble_chk_doc2+" onblur='validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date3);validatIssueDatechk(this,doc_exp_dt3)' value='"+doc3_iss_date+"' onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='issuedt3' "+docexp3disable+" onClick=\"document.forms[0].issue_date3.select();return showCalendar('issue_date3');\"  "+disble_chk_doc2+"></td>"); //Locale is added by Rameswar on 30-Sep-15 for Leap Year Issue
			result.append("<td class='fields'> <div id='doc3imageId'><input type='file' name='doc3image' id='doc3image' "+doc3_disable+"  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'>");//This line modified to include div tag for the incident 38504 to clear the file path.
			
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			/*Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035*/
						document_id ="doc_id3"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
										
					result.append("<input type='button' name='doc3scan' id='doc3scan'  value='Scan' "+doc3_scan_disable+"  size=4  onClick=ShowScanner('"+patient_id+"','MP','"+document_id+"',this) style='visibility:hidden'></div></td><input type='hidden' name='document_id3' id='document_id3' value='"+document_id+"'>");
					 /*Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035*/
			 if((!doc3_type.equals(""))&&((doc3 != null) || (doc3_image_path != ""))){  // or condition added by sethu for AAKH-CRF-0075 on 09/07/2015 -- changes made by prithivi 12/10/2015
			
				 	result.append("<td class='data'>");
					 if(isDownloadDoc==true && !doc3_type.equals("99")){
				 		result.append("<a href=\"javascript:onClick=downloadDocument('"+patient_id+"','DOC3_IMAGE')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Download.label","common_labels")+"</a>");
					 }else{
				 		result.append("<a href=\"javascript:onClick=viewDocument('"+patient_id+"','DOC3_IMAGE','"+isViewPrintPatDoc+"','"+ndhm_appl_YN+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
					 }
					result.append("</td> "); 
			 }
			/* end PMG2012-CRF-0006 [IN034693] */ 
			result.append("</tr><tr>");

			
			/*
			result.append("<td class='fields'><select name='doc_id4' id='doc_id4' onchange='enbl_disble(this)' disabled><option value=''>--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----------</option>");
			
			for(int i=0; i<codes.size(); i+=2)
			{
				String sel = "";
				if(doc4_type.equals((String)codes.get(i)))
					sel = "selected";
				result.append("<option value='"+(String)codes.get(i)+"' "+sel+">"+(String)codes.get(i+1)+"</option>") ;
			}
							   
			result.append("</select></td>");
			*/

			//sql = "SELECT doc_type, initcap(short_desc) short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc4_type+"' and eff_status = 'E' ORDER BY 2 ";
			/*Modified By Dharma on Feb 11th 2015 against HSA-SCF-0192 [IN:053070]*/
			sql = "SELECT doc_type, short_desc short_name FROM mp_document_type_lang_vw WHERE language_id='"+locale+"' and doc_type='"+doc4_type+"' and eff_status = 'E' ORDER BY 2 ";

			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(sql);
			rs1 = pstmt.executeQuery();
			
			if(rs1 !=null)
			{
				while(rs1.next())
				{
					doc4_type_code = rs1.getString(1);
					doc4_type_desc = rs1.getString(2);
				}	 
			}

			if ( doc4_type_code == null )		doc4_type_code="";
			if ( doc4_type_desc == null )		doc4_type_desc="";

			if(rs1!= null) rs1.close() ;
			
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 implemented the logic as in 5.x - Begins*/
			String disble_chk_doc5_j="disabled";
			String mandatory_doc4_j="hidden";
			String disble_chk_doc3="disabled";
			//if(doc1_type!="" && doc1_type != null)					
				//{
				disble_chk_doc5_j="";
				docexp4disable="";
				if(doc4_type != "" && doc4_type != null){
					mandatory_doc4_j="display";
					disble_chk_doc3="";
					}
				//}	
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 implemented the logic as in 5.x - Ends*/
			
			result.append("<td  class='fields'> <input type='text' name='doc_id4_desc' id='doc_id4_desc' size='20' maxlength='20' "+disble_chk_doc5_j+" value=\""+doc4_type_desc+"\" onblur='if(this.value!=\"\"){searchDocumentType(doc_id4,doc_id4_desc);}else{clearfields();}' ><input type='button'  id='doc4_id'  name='doc4_code_id4' id='doc4_code_id4' "+disble_chk_doc5_j+" value='?' class='button' onclick='searchDocumentType(this,doc_id4_desc);' > <input type='hidden' name='doc_id4' id='doc_id4' value=\""+doc4_type_code+"\"> </td>");
				
			
			result.append("<td class='fields'><input type='text' name='doc_num4' id='doc_num4' size=15 maxlength=15 "+disble_chk_doc3+" value='"+doc4_num+"' onBlur='makeValidString(this);'><img id='doc4' style='visibility:"+mandatory_doc4_j+"' src='../../eCommon/images/mandatory.gif'></img></td><td class='fields'><input type='text' name='doc_exp_dt4' id='doc_exp_dt4' size=10 maxlength=10 "+disble_chk_doc3+" onblur = 'validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date4);' value='"+doc4_exp_date+"'  onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='docexpdate4' "+docexp4disable+" onClick=\"document.forms[0].doc_exp_dt4.select();return showCalendar('doc_exp_dt4');\" "+disble_chk_doc3+"></td><td class='fields'><input type='text' name='place_of_issue4' id='place_of_issue4'  size=30 maxlength=30 "+disble_chk_doc3+" value=\""+doc4_place_of_issue+"\"' onBlur='makeValidString(this);'></td><td class='fields'><input type='text' name='issue_date4' id='issue_date4' id='issuedate4' size=10 maxlength=10 "+disble_chk_doc3+" onblur='validDateObj(this,\""+"DMY"+"\",\""+locale+"\");return ChkForIssueDate(this,document.forms[0].issue_date4);validatIssueDatechk(this,doc_exp_dt4)' value='"+doc4_iss_date+"' onBlur='makeValidString(this);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='issuedt4' "+docexp4disable+" onClick=\"document.forms[0].issue_date4.select();return showCalendar('issue_date4');\"  "+disble_chk_doc3+"></td>"); //Locale is added by Rameswar on 30-Sep-15 for Leap Year Issue
		    /* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
            result.append("<td class='fields'><div id='doc4imageId'> <input type='file' name='doc4image' id='doc4image' "+doc4_disable+"  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'>");//This line modified to include div tag for the incident 38504 to clear the file path.
            /*Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035*/
						document_id ="doc_id4"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
										
					result.append("<input type='button' name='doc4scan' id='doc4scan'  value='Scan' "+doc4_scan_disable+"  size=4  onClick=ShowScanner('"+patient_id+"','MP','"+document_id+"',this) style='visibility:hidden'></div></td><input type='hidden' name='document_id4' id='document_id4' value='"+document_id+"'>");
					 /*Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035*/
					
				if((!doc4_type.equals(""))&&((doc4 != null) || (doc4_image_path != ""))){   // or condition added by sethu for AAKH-CRF-0075 on 09/07/2015 -- changes made by prithivi on 12/10/2015 
			 		result.append("<td class='data'>");
			 		if(isDownloadDoc==true && !doc4_type.equals("99")){
						result.append("<a href=\"javascript:onClick=downloadDocument('"+patient_id+"','DOC4_IMAGE')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Download.label","common_labels")+"</a>");
			 		}else{
						result.append("<a href=\"javascript:onClick=viewDocument('"+patient_id+"','DOC4_IMAGE','"+isViewPrintPatDoc+"','"+ndhm_appl_YN+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			 		}
			 		result.append("</td> ");
			 	 }			
            /* end PMG2012-CRF-0006 [IN034693] */ 


			result.append("</tr></table></div><br>");

	
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(rs1 != null) rs1.close();

			codes.clear();
			out.println(result);
	
/*	StringBuffer callMisc(Connection con, HashMap misc, int cnt)
	The following part was a static function to display Misc details. The functions are merged and included in as dynamic JSP
*/
			result		= result.delete(0,result.length());
			if(comments == null) comments = "";
			if(informant == null) informant = "";

			PreparedStatement mpstmt = null;
			ResultSet mrs = null;

			result.append("<table width='100%' cellpadding='2' cellspacing='0'><tr>");
			result.append("<td  class='COLUMNHEADER '>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Miscellaneous.label","common_labels")+"</td></tr>");
			result.append("<tr><td>");
			result.append("<table width='100%' cellpadding='2' cellspacing='0'><tr>");
			result.append("<td width='25%' class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Dependency.label","common_labels")+"</td>");
			result.append("<td class='fields'><select name='living_dependency' id='living_dependency'>");
			if(dependency.equals("UN"))
				result.append("<option value='UN' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotKnown.label","common_labels")+"</option>");
			else
				result.append("<option value='UN'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotKnown.label","common_labels")+"</option>");
			if(dependency.equals("D"))
				result.append("<option value='D' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpouseDependent.label","mp_labels")+"</option>");
			else
				result.append("<option value='D'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpouseDependent.label","mp_labels")+"</option>");
			if(dependency.equals("M"))
				result.append("<option value='M' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MedicalSupervisionReqd.label","mp_labels")+"</option>");
			else 
				result.append("<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MedicalSupervisionReqd.label","mp_labels")+"</option>");
			if(dependency.equals("S"))
				result.append("<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SmallChildren.label","mp_labels")+"</option>");
			else 
				result.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SmallChildren.label","mp_labels")+"</option>");
			if(dependency.equals("WU"))
				result.append("<option value='WU' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.WalkUp.label","mp_labels")+"</option>");
			else 
				result.append("<option value='WU'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.WalkUp.label","mp_labels")+"</option>");
			
			result.append("</select><img src='../../eCommon/images/mandatory.gif'></img></td</tr>");
			result.append("<tr><td width='25%' class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Arrangement.label","mp_labels")+"</td>");

			result.append("<td class='fields'><select name='living_arrangement' id='living_arrangement' > ");
			if(arrangement.equals("U"))
				result.append("<option value='U' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+" </option>");
			else 
				result.append("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+" </option>");
			if(arrangement.equals("A"))
				result.append("<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Alone.label","mp_labels")+"</option>");
			else 
				result.append("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Alone.label","mp_labels")+"</option>");
			if(arrangement.equals("F"))
				result.append("<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.family.label","mp_labels")+"</option>");
			else 
				result.append("<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.family.label","mp_labels")+"</option>");
			if(arrangement.equals("R"))
				result.append("<option value='R' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.relative.label","mp_labels")+" </option>");
			else 
				result.append("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.relative.label","mp_labels")+" </option>");
			if(arrangement.equals("S"))
				result.append("<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.spouseonly.label","mp_labels")+" </option>");
			else 
				result.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.spouseonly.label","mp_labels")+" </option>");

			result.append("</select><img src='../../eCommon/images/mandatory.gif'></img></td></tr>");
			result.append("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EducationLevel.label","mp_labels")+"</td>");
		/*	result.append("<td class='fields' ><select name='education_level' id='education_level'>"); 
			result.append("<option value=''>--------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option>");
	
			mpstmt = con.prepareStatement("Select educ_level_code,short_desc from  mp_education_level_lang_vw where language_id='"+locale+"' and eff_status = 'E' order by short_desc");
			mrs = mpstmt.executeQuery();
			
			String sel = "";
			while(mrs.next())
			{
				sel = "";
				if(education_level.equalsIgnoreCase(mrs.getString("educ_level_code")))
				sel = "selected";
				result.append("<option value='"+mrs.getString("educ_level_code")+"' "+sel+">"+mrs.getString("short_desc")+"</option>)");
			}

			result.append("</select></td></tr>");
			*/
			
			result.append("<td  class='fields'> <input type='text' name='education_level_desc' id='education_level_desc' size='20' maxlength='20' value=\""+educ_level_desc+"\" onblur='if(this.value!=\"\"){searchEducation(education_level,education_level_desc);}else{clearfields();}'><input type='button'  id='education_level_id'  name='education_level_id1' id='education_level_id1' value='?' class='button' onclick='searchEducation(this,education_level_desc)'>	<input type='hidden' name='education_level' id='education_level' value=\""+education_level+"\">");

		
			result.append("</table></td></tr></table></td><td width='1%' class='BODYCOLORFILLED'></td></tr></table>");
			result.append("<table width='100%' cellpadding='2' cellspacing='0'><tr><td  class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegistrationSource.label","mp_labels")+"</td></tr><tr><td>");
			result.append("<table width='100%' cellpadding='0' cellspacing='0'><tr><td width='25%' class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Informant.label","mp_labels")+"</td><td  class='fields' width='75%'>");
			result.append("<input type='text' name='regn_informant' id='regn_informant' maxlength='20' size='20' value=\""+informant+"\" onBlur='makeValidString(this);'></td>");
			result.append("</tr><tr><td width='25%' class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.InformantRemarks.label","mp_labels")+"</td><td  class='fields'width='75%' >");
			result.append("<textarea name='regn_comments' rows='2' cols='45' onKeyPress='checkMaxLimit(this,100)' onBlur ='checkLength(this,100);makeValidString(this);'>"+comments+"</textarea>");
			result.append("</td></tr></table></td></tr></table>");
			result.append("</td><td width='1%' class='BODYCOLORFILLED' ></td></tr></table><br>");
			result.append("<table width='100%' cellpadding='2' cellspacing='0'><tr><td  class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.generalRemarks.label","common_labels")+"</td></tr><tr><td>");
			result.append("<table width='100%' cellpadding='2' cellspacing='0'><tr><td width='25%'></td><td class='fields' width='75%' >");
			if(cnt>0)
			{
				 result.append("<textarea name='general_remarks' rows='4' cols='45' onKeyPress='checkMaxLimit(this,500)' onblur='checkLength(this,500);makeValidStringRemark(this);'>"+general_remarks+"</textarea></td>");
			}
			else
			{
				result.append("<textarea name='general_remarks' rows='5' cols='45' onKeyPress='checkMaxLimit(this,500)' onblur='checkLength(this,500);makeValidStringRemark(this);'>"+general_remarks+"</textarea></td>");
			}
			result.append("</tr></table></table></td></tr></table>");
			
			/*Added by Ashwini on 15-Oct-2018 for TBMC-CRF-0005.1*/

			String DCSYN = InterfaceUtil.isInterfaceProfileExisting("DCSBM01");

			if(("Y").equals(DCSYN))
			{
			result.append("<table width='100%' cellpadding='2' cellspacing='0'><tr><td  class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.documents.label","common_labels")+"</td></tr><tr><td>");
			result.append("<table width='100%' cellpadding='0' cellspacing='0'><tr><td width='25%' class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Link.label","common_labels")+"</td><td width='75%'>");
			result.append("<img src='../../eCommon/images/ExternalDocument.PNG' onClick=getExtLink('"+facility_id+"','"+patient_id+"','"+login_user_id+"','"+resp_id+"',\""+java.net.URLEncoder.encode(regn_date)+"\") /></img></td>");
			result.append("</tr></table></td></tr></table>");
			}

			/*End TBMC-CRF-0005.1*/

			result.append("</td><td width='1%' class='BODYCOLORFILLED' ></td></tr><TABLE BORDER='0'><TR></TR><TR></TR><TR></TR><TR></TR></TABLE>");
			if(mrs!=null)mrs.close();
			if(mpstmt!=null)mpstmt.close();
			out.println(result);
		}
		catch(Exception ex)
		{ 
		ex.printStackTrace();
		}
		finally{
		if (con!=null) ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
