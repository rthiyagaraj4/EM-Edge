package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __newbornregistrationframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NewbornRegistrationFrames.jsp", 1733139318456L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head></head>\n<body style=\"margin: 1px;\"> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n\t\t\t<iframe src=\"../../eCommon/jsp/pline.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" name=\"motherline_frame\" id=\"motherline_frame\"  NORESIZE=NORESIZE   scrolling=\"no\" style=\'height:10vh;width:97vw\'></iframe>\n\t\t\t<iframe  src=\"../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&function_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&function_id_new=REGISTER_NEWBORN&encounter_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nursing_unit=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&patient_id_length=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&inhouse_birth_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&new_born_pat_ser_grp=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nb_use_mother_ser=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&accessRights=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&calling_module_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&disable_button_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&called_from_mothercare=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&mother_patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&ca_encounter_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&ip_install_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&siteId=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&isNewBornChngsAppl=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  name=\"newbornheader_frame\" id=\"newbornheader_frame\" scrolling=\"no\" noresize style=\'height:4vh;width:97vw\'></iframe>\n\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<iframe  src=\"../../eMP/jsp/NewbornRegistrationMainSLY.jsp?mother_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&parent_details=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&function_invoked=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&module_invoked=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&mother_nursing_unit=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&mother_bed_no=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&function_name=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&invoke_adm_from_newborn_yn=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&invoked_from=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&newTransactionYN=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&mother_pat_id=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  name=\"newbornmain_frame\"  id=\"newbornmain_frame\" scrolling=\"auto\" noresize style=\'height:4vh;width:97vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<iframe  src=\"../../eMP/jsp/NewbornRegistrationMain.jsp?mother_id=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  name=\"newbornmain_frame\" id=\"newbornmain_frame\" scrolling=\"auto\" noresize style=\'height:87vh;width:97vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<iframe  src=\"../../eMP/jsp/NewbornRegistrationDetails.jsp?mother_id=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&exceedMaxBirthYN=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" name=\"newborndtls_frame\" id=\"newborndtls_frame\" scrolling=\"auto\" noresize style=\'height:9vh;width:97vw\'></iframe>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\n\t\t\n\t\t\t<iframe src=\"../../eCommon/jsp/pline.jsp?";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" name=\"motherline_frame\" id=\"motherline_frame\"  NORESIZE=NORESIZE   scrolling=\"no\" style=\'height:10vh;width:99vw\'></iframe>\n\t\t\t<iframe  src=\"../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"  name=\"newbornheader_frame\" id=\"newbornheader_frame\" scrolling=\"no\" noresize style=\'height:7.5vh;width:99vw\'></iframe>\n\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"  name=\"newbornmain_frame\" id=\"newbornmain_frame\" scrolling=\"auto\" noresize style=\'height:4vh;width:99vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  id=\"newbornmain_frame\" name=\"newbornmain_frame\" scrolling=\"auto\" noresize style=\'height:65vh;width:99vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" name=\"newborndtls_frame\" id=\"newborndtls_frame\" scrolling=\"auto\" noresize style=\'height:10vh;width:99vw\'></iframe>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<script> ////change by vijayan for IE  to Edge testing jul-10-2024\n\t\t\t/*<frameset rows=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" frameborder=\'0\'>\n\t\t\t<frame src=\"../../eCommon/jsp/pline.jsp?";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" name=\"motherline_frame\"  NORESIZE=NORESIZE   scrolling=\"no\">\n\t\t\t<frame  src=\"../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"  name=\"newbornheader_frame\" scrolling=\"no\" noresize >\n\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<frame  src=\"../../eMP/jsp/NewbornRegistrationMainSLY.jsp?mother_id=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  name=\"newbornmain_frame\" scrolling=\"auto\" noresize >\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<frame  src=\"../../eMP/jsp/NewbornRegistrationMain.jsp?mother_id=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<frame  src=\"../../eMP/jsp/NewbornRegistrationDetails.jsp?mother_id=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" name=\"newborndtls_frame\" scrolling=\"auto\" noresize>\n\n\t\t</frameset>*/</script>\n\t\t</body>\n\t</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

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
		String locale =((String)session.getAttribute("LOCALE"));
		String motherid = request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		String mother_encounter_id = request.getParameter("mother_encounter_id")==null?"": request.getParameter("mother_encounter_id");//Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12
		String function_id = request.getParameter("function_id") ;
		if(function_id == null)function_id = "" ;
		String mother_patient_id = "";		
		String accessRights = request.getParameter("accessRights");
		if( accessRights == null) accessRights="";
		String parent_details = request.getParameter("parent_details");
		if( parent_details == null) parent_details="";
		parent_details = java.net.URLEncoder.encode(parent_details);
		String function_invoked = request.getParameter("function_invoked");
		if( function_invoked == null) function_invoked="";
		String module_invoked = request.getParameter("module_invoked");
		if( module_invoked == null) module_invoked="";
		String called_from_mothercare = request.getParameter("called_from_mothercare")==null?"":request.getParameter("called_from_mothercare");
		String mother_nursing_unit	= request.getParameter("mother_nursing_unit")==null?"":request.getParameter("mother_nursing_unit");
		String calling_module_id	= request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");	
		String disable_button_yn	= request.getParameter("disable_add_yn")==null?"N":request.getParameter("disable_add_yn");
		String invoked_from			= request.getParameter("invoked_from")==null?"":request.getParameter("invoked_from");	
		String new_born_id			= request.getParameter("new_born_id")==null?"":request.getParameter("new_born_id");
		String mother_bed_no		= request.getParameter("mother_bed_no")==null?"":request.getParameter("mother_bed_no");
		if(calling_module_id.equals("IP")){
			mother_patient_id = request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		}else{
			mother_patient_id = request.getParameter("mother_patient_id")==null?"":request.getParameter("mother_patient_id");
		}		
		String ca_encounter_id		= request.getParameter("ca_encounter_id") == null ? "" : request.getParameter("ca_encounter_id");
		String function_name 		= request.getParameter( "function_name" ) ;
		if ( function_name	== null ) function_name	= "" ;	
		
		String nb_use_mother_ser = request.getParameter("nbUseMotherSer") == null ? "" : request.getParameter("nbUseMotherSer");
		String patientidlength	= request.getParameter("patIidLength") == null ? "" : request.getParameter("patIidLength");
		String newbornpatsergrp	= request.getParameter("nbPatSerGrp") == null ? "" : request.getParameter("nbPatSerGrp");
		String invoke_adm_from_newborn_yn = request.getParameter("invkAdmFrmNBYn")==null?"N":request.getParameter("invkAdmFrmNBYn");
		String ip_install_yn = request.getParameter("ipInstallYn")==null?"N":request.getParameter("ipInstallYn");
		String siteId = request.getParameter("siteId")==null?"":request.getParameter("siteId");	 	
		 

		String inhousebirthyn = "Y";  

		/*
		String unitofwtnb							= "";
		String unitofcircumnb					= "";
		String unitofchestunit				= "";//added by sen on 9/08/2004
		String unitoflengthnb					= "";
		String unitofgestnb						= "";
		String namesuffixmalenb			= "";
		String namesuffixfemalenb		= ""; 		
		String allownbregnwithindays	= "";
		String alt_id_type_desc			= "";
		*/

		String encounterid						= "";
		String nursingunitcode				= "";
		
		
		String patientLine = "";
		String Facility_Id = (String) session.getValue("facility_id");
		Connection con = null;
		PreparedStatement pstmt	= null;
		ResultSet rset		= null;
				
		String patient_id = "";
		String baby_patient_id = "";
		String multiple_birth_yn = "N";
		String exceedMaxBirthYN = "N";
		String newTransactionYN = "Y";
		Boolean isNewBornChngsAppl	= false;
		
		try
		{
			con = ConnectionManager.getConnection(request);
			 isNewBornChngsAppl		 = CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Dharma on 30th May 2018 against ML-MMOH-CRF-0898 [IN:064757]

			int no_of_multi_babies_regd = 0;
			//int no_of_births = 0;

			//pstmt = con.prepareStatement("SELECT PATIENT_ID, MULTIPLE_BIRTH_YN, no_of_births, no_of_multi_babies_regd FROM mp_birth_register WHERE MOTHER_PATIENT_ID = '"+motherid+"' order by birth_order, time_of_birth");
			String checkBirths="SELECT PATIENT_ID, MULTIPLE_BIRTH_YN, no_of_multi_babies_regd FROM mp_birth_register WHERE MOTHER_PATIENT_ID = '"+motherid+"' order by added_date desc";
					
			pstmt = con.prepareStatement(checkBirths); 

			rset = pstmt.executeQuery();

			if (rset!=null) {
				if(rset.next()) {
					baby_patient_id = rset.getString("PATIENT_ID")==null?"":rset.getString("PATIENT_ID");
					multiple_birth_yn = rset.getString("MULTIPLE_BIRTH_YN") ==null?"N":rset.getString("MULTIPLE_BIRTH_YN");
					no_of_multi_babies_regd = rset.getInt("no_of_multi_babies_regd"); 
					//no_of_births = rset.getInt("no_of_births"); 
				}					
			}
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
			if(invoked_from.equals("servlet")) {
				patient_id = new_born_id;
				if(multiple_birth_yn.equals("Y") && (no_of_multi_babies_regd == 0)) {				
					exceedMaxBirthYN = "Y";				
				} else if(multiple_birth_yn.equals("N")){
					exceedMaxBirthYN = "Y";	
				} else {
					exceedMaxBirthYN = "N";	
				}
				newTransactionYN = "N";
			} else {
				if(no_of_multi_babies_regd > 0 && multiple_birth_yn.equals("Y")) {
					patient_id = baby_patient_id;
					invoked_from = "servlet";
					newTransactionYN = "N";
				} else {
					patient_id = motherid;
					newTransactionYN = "Y";
				}
			}		  

			/*
			pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP'");
			rset = pstmt.executeQuery();
			if (rset!=null && rset.next())
			{
				ip_install_yn = rset.getString(1);
				if (ip_install_yn==null) ip_install_yn = "";
			}
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
			*/
		}
		catch(Exception ex)
		{
			out.println(ex.toString());
		}
		finally
		{
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
		}
	try{		
		if (ip_install_yn.equals("Y"))
		{
			/*
			pstmt = con.prepareStatement("select invoke_adm_from_newborn_yn from ip_param where facility_id='"+Facility_Id+"'");

			rset = pstmt.executeQuery();
			if (rset!=null && rset.next())
			{
				invoke_adm_from_newborn_yn = rset.getString("invoke_adm_from_newborn_yn")==null?"N": rset.getString("invoke_adm_from_newborn_yn");				
			}		

			if(rset!=null)
				rset.close();
			if(pstmt!=null)
				pstmt.close();
			*/

			String sql1 = "Select a.encounter_id, a.nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','1') Nursing_Unit_Short_Desc from IP_OPEN_ENCOUNTER a where a.facility_id='"+Facility_Id+"' and a.Patient_Id = '"+motherid+"'" ;
			
			pstmt	= con.prepareStatement(sql1);
			rset	= pstmt.executeQuery();
			if(rset!=null && rset.next())
			{
				encounterid			= rset.getString("encounter_id")==null?"":rset.getString("encounter_id");
				nursingunitcode	= rset.getString("nursing_unit_code")==null?"":rset.getString("nursing_unit_code");
				inhousebirthyn		= "Y";
			}/*else{
				encounterid = mother_encounter_id; //Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12 
			}*/
			if(pstmt!=null)pstmt.close();
		}
		//code fix for 36653 - starts
		if(encounterid.equals("") && !mother_encounter_id.equals("") && !mother_encounter_id.equals("TEMP*12*")) {
			encounterid=mother_encounter_id;
		}
		//code fix for 36653 - ends
		
		if (encounterid.equals("") )
		{
			patientLine = "Patient_ID="+motherid;
		}
		else{
			patientLine = "EncounterId="+encounterid;
		}
		
	}

	catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	/*

	try{  

		String sql =  "select unit_of_wt_nb, unit_of_circum_nb,unit_of_chest_circum_nb,unit_of_length_nb, unit_of_gest_nb,  name_suffix_male_nb,name_suffix_female_nb,patient_id_length,newborn_pat_ser_grp,  nb_use_mother_ser,allow_nb_regn_within_days, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id_type_desc from mp_param where module_id='MP'";

		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		if(rset!=null && rset.next())
		{
			alt_id_type_desc			= rset.getString("alt_id_type_desc")==null?"":rset.getString("alt_id_type_desc");
			unitofwtnb					= rset.getString("unit_of_wt_nb")==null?"":rset.getString("unit_of_wt_nb");
			unitofcircumnb				= rset.getString("unit_of_circum_nb")==null?"":rset.getString("unit_of_circum_nb");
			unitoflengthnb				= rset.getString("unit_of_length_nb")==null?"":rset.getString("unit_of_length_nb");
			unitofgestnb				= rset.getString("unit_of_gest_nb")==null?"":rset.getString("unit_of_gest_nb");
			patientidlength				= rset.getString("patient_id_length")==null?"":rset.getString("patient_id_length");
			namesuffixmalenb			= rset.getString("name_suffix_male_nb")==null?"":rset.getString("name_suffix_male_nb");
			namesuffixfemalenb		= rset.getString("name_suffix_female_nb")==null?"":rset.getString("name_suffix_female_nb");
			newbornpatsergrp			= rset.getString("newborn_pat_ser_grp")==null?"":rset.getString("newborn_pat_ser_grp");
			nb_use_mother_ser		= rset.getString("nb_use_mother_ser")==null?"N":rset.getString("nb_use_mother_ser");
			allownbregnwithindays	= rset.getString("allow_nb_regn_within_days")==null?"":rset.getString("allow_nb_regn_within_days");
			patient_id_length			= rset.getString("patient_id_length");

			unitofchestunit = rset.getString("unit_of_chest_circum_nb")==null?"":rset.getString("unit_of_chest_circum_nb");//aded by sen 0n 9/08/2004			
		}
		if(pstmt!=null)pstmt.close();
		if(rset!=null)rset.close();
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	*/

	

	String frameSetRows="";
	if(called_from_mothercare.equals("MC")){ 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patientLine));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientidlength));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(newbornpatsergrp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(calling_module_id.equals("IP") && isNewBornChngsAppl){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientidlength));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(newbornpatsergrp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(exceedMaxBirthYN));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block41Bytes, _wl_block41);
  }
 else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patientLine));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientidlength));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(newbornpatsergrp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block44Bytes, _wl_block44);
if(calling_module_id.equals("IP") && isNewBornChngsAppl){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientidlength));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(newbornpatsergrp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(exceedMaxBirthYN));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
	//Below line modified for this CRF  HSA-CRF-0182 linked incident [54168]

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(frameSetRows));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patientLine));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientidlength));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(newbornpatsergrp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(calling_module_id.equals("IP") && isNewBornChngsAppl){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block53Bytes, _wl_block53);
}else{
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ip_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientidlength));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(inhousebirthyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(newbornpatsergrp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(exceedMaxBirthYN));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ca_encounter_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block56Bytes, _wl_block56);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
