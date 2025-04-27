package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;

public final class __recdiagnosiserror extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosiserror.jsp", 1740479893964L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script>\n<script src=\'../../eXH/js/jquery-1.7.min.js\' language=\'javascript\'></script>\n<head>\n<body class=\"message\" onKeyDown=\'lockKey()\'>\n<script>\n/*Below funtion modified for this CRF PMG2012-CRF-0030 */\n\tfunction onsuccess(Patient_Id, Encounter_Id, patient_class, term_set_id, Practitioner_Id, relationship_id, Locn_Type, Locn_Code, sex, dob, occur_srl_no, f,modal_yn,pract_type,isCalledFromCA,option_id,accession_number,call_from,reload_mdr,p_called_from_widget,called_from_ot)  //CHL-CRF- 0008 - IN:001472\n\t{ \n\t\tif(f ==\'EOC\')\n\t\t{\t\t\t\t\t\t\t\n\t\t\tparent.frames[0].document.location.href=\"../../eMR/jsp/RecDiagnosisEOCResult.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&term_set_id=\"+term_set_id+\"&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&occur_srl_no=\"+occur_srl_no;\n\t\t\tparent.frames[1].document.location.href=\"../../eMR/jsp/RecDiagnosisEOCAddModify.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&term_set_id=\"+term_set_id+\"&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&occur_srl_no=\"+occur_srl_no;\n\t\t\tparent.frames[2].document.location.href=\"../../eMR/jsp/RecDiagnosisEOCButtons.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&occur_srl_no=\"+occur_srl_no;\n\t\t}\n\t\telse if(isCalledFromCA!=\'Y\')\n\t\t{\n\t\t\t//Maheshwaran K added for MMS-DM-CRF-197.1\n\t\t\tif(document.RecDaignosiserror_form.error.value.indexOf(\"APP-MR0182\")==0){\n\t\t\t\tparent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.focus();\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\t//parent.frames[2].document.location.href=\"../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&term_set_id=\"+term_set_id+\"&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&occur_srl_no=\"+occur_srl_no;\n\t\t\tif(call_from==\"MAINTAIN_DEATH_REGISTER\"){\n\t\t\t\n\t\t\t\t\t\twindow.returnValue=reload_mdr;\t\t\n\t\t\t\t\t\twindow.close();\n\t\t\t}\n\t\t\t\n\t\t\tvar dialogFrame = top.document.getElementById(\'dialog-body\')?top.document.querySelectorAll(\'#dialog-body\')[top.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.frames[1]:parent;\n\t\t\tdialogFrame.frames[0].document.location.href=\"../../eCommon/jsp/pline.jsp?EncounterId=\"+Encounter_Id;\n\t\t\tdialogFrame.frames[2].document.location.href=\"../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&term_set_id=\"+term_set_id+\"&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&occur_srl_no=\"+occur_srl_no+\"&modal_yn=\"+modal_yn+\"&practitioner_type=\"+pract_type+\"&option_id=\"+option_id+\"&accession_num=\"+accession_number+\"&called_from_ot=\"+called_from_ot+\"&function_id=\"+f; //Modified for this CRF [ PMG2012-CRF-0030] //function_id added by Suji Keerthi for ML-MMOH-CRF-1605\n\t\t\t\n\t\t\tdialogFrame.frames[3].document.location.href=\"../../eMR/jsp/RecDiagnosisCurrentDiagLegend.jsp\";\n\t\t\t//parent.frames[4].document.location.href=\"../../eMR/jsp/RecDiagnosisAddModify.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&term_set_id=\"+term_set_id+\"&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&occur_srl_no=\"+occur_srl_no;\n\n\t\t\tdialogFrame.frames[4].document.location.href=\"../../eMR/jsp/RecDiagnosisAddModify.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&term_set_id=&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&occur_srl_no=\"+occur_srl_no+\"&modal_yn=\"+modal_yn+\"&practitioner_type=\"+pract_type+\"&isCalledFromCA=\"+isCalledFromCA+\"&option_id=\"+option_id+\"&accession_number=\"+accession_number+\"&called_from_ot=\"+called_from_ot+\"&function_id=\"+f; //Modified for this CRF [ PMG2012-CRF-0030] //function_id added by Suji Keerthi for ML-MMOH-CRF-1605\n\t\t\tdialogFrame.frames[5].document.location.href=\"../../eMR/jsp/RecDiagnosisOpernToolbar.jsp?Patient_Id=\"+Patient_Id+\"&Encounter_Id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&Practitioner_Id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&Locn_Type=\"+Locn_Type+\"&occur_srl_no=\"+occur_srl_no+\"&function_id=\"+f; //function_id added by Suji Keerthi for ML-MMOH-CRF-1605\n\t\t\t\t}\n\t\t}\n\t\telse\n\t\t{\t\t\t\n\t\t\t\t//Maheshwaran K added for MMS-DM-CRF-197.1\n\t\t\tif(document.RecDaignosiserror_form.error.value.indexOf(\"APP-MR0182\")==0){\n\t\t\tparent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.focus();\n\t\t\t\n\t\t}else {\n\t\t    //Modified for this CRF [ PMG2012-CRF-0030]\n\t\t\tparent.parent.frames[1].document.location.href=\"../../eMR/jsp/RecDiagnosisMain.jsp?patient_id=\"+Patient_Id+\"&encounter_id=\"+Encounter_Id+\"&patient_class=\"+patient_class+\"&term_set_id=&practitioner_id=\"+Practitioner_Id+\"&Locn_Code=\"+Locn_Code+\"&relationship_id=\"+relationship_id+\"&location_type=\"+Locn_Type+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&occur_srl_no=\"+occur_srl_no+\"&practitioner_type=\"+pract_type+\"&modal_yn=\"+modal_yn+\"&option_id=\"+option_id+\"&CA=\"+isCalledFromCA+\"&accession_num=\"+accession_number+\"&p_called_from_widget=\"+p_called_from_widget+\"&called_from_ot=\"+called_from_ot; //CHL-CRF- 0008 - IN:001472\n\t\t}\n\t\t}\n\t\tif(document.RecDaignosiserror_form.error.value.indexOf(\"Operation Completed Successfully\")>0){\n\t\t\tvar term_code=\"\";\n\t\t\tif(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value ==\"\" && parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value !=\"\"){\n\t\t\t\tterm_code=\"*OTH\";\n\t\t\t}else{\n\t\t\t\tterm_code=parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;\n\t\t\t}\n\t\t\tvar accuracy_val= parent.RecDiagnosisAddModify.document.RecDaignosis_form.accuracy.value;\n\t\t\tvar accuracy_val_arr=accuracy_val.split(\"=\");\n\t\t\teNotifikasi(Patient_Id, Encounter_Id,term_set_id,term_code,accuracy_val_arr[1]);\n\t\t}\n\t}\n</script>\n</head>\n\n<form name=\'RecDaignosiserror_form\' id=\'RecDaignosiserror_form\'  action=\'\' method=\'post\' target=\'\'>\n<p align=\"left\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t<input type=\'hidden\' name=\'error_value\' id=\'error_value\' value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"> \n\t<input type=\'hidden\' name=\'error\' id=\'error\' value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"> \n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</p>\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"> \n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
	
String sStyle	=   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	String flag		=	 checkForNull(request.getParameter("flag"));
	String call_from	 =checkForNull(request.getParameter("call_from"));
	String reload_mdr	 =checkForNull(request.getParameter("reload_mdr"));
	String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
	String error				=request.getParameter( "error" );

	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(error_value));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(error));
            _bw.write(_wl_block6Bytes, _wl_block6);
if(flag.equals("Record_found")){
		out.print("<script>var ggp_status = window.confirm(getMessage('MR_DIAG_DIFFGRP_CONFIRM','MR'));</script>");
	//out.println("<script>alert(\"ppppopo :\");</script>");

	//out.println("<script>alert(\"+request.getQueryString() :\");</script>");
	//out.println("<script>alert(\"request.getQueryString() :"+request.getQueryString()+"\");</script>");						

		out.println("<script>if(ggp_status)diffGroupforDiag('"+request.getQueryString()+"')</script>");
			//out.println("<script>alert(\"klkklklkl :\");</script>");

	}

	
	String Patient_Id		=checkForNull(request.getParameter("Patient_Id"));
	String patient_class	=checkForNull(request.getParameter("patient_class"));
	String Encounter_Id	=checkForNull(request.getParameter("Encounter_Id"));
	String term_set_id		=checkForNull(request.getParameter("term_set_id"));
	String term_set_code		=checkForNull(request.getParameter("term_set_code"));
	String Practitioner_Id	=checkForNull(request.getParameter("Practitioner_Id"));
	String relationship_id	=checkForNull(request.getParameter("relationship_id"));
	String Locn_Type		=checkForNull(request.getParameter("Locn_Type"));
	String Locn_Code		=checkForNull(request.getParameter("Locn_Code"));
	String sex					=checkForNull(request.getParameter("sex"));
	String dob					=checkForNull(request.getParameter("dob"));
	String occur_srl_no_hid	=checkForNull(request.getParameter("occur_srl_no_hid"));
	String function_id		=checkForNull(request.getParameter("function_id"));
	String modal_yn		=checkForNull(request.getParameter("modal_yn"));
	//String diag_description		=checkForNull(request.getParameter("diag_Description"));
	String isCalledFromCA		=checkForNull(request.getParameter("isCalledFromCA"));
	String practitioner_type	=checkForNull(request.getParameter("practitioner_type"));
	String option_id		=checkForNull(request.getParameter("option_id"));
	String accession_number	=checkForNull(request.getParameter("accession_number"));
	String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget"));
	String called_from_ot = checkForNull(request.getParameter("called_from_ot")); //this line Adde dor this CRF PMG2012-CRF-0030
	
	
	//String returnval=term_set_id+"^"+term_set_code+"^"+diag_description;
	//System.out.println("returnval=============="+returnval);
	if(error_value != null)
	{
		if(!modal_yn.equals("Y"))
		{
			out.println( error ) ;
		}
		else
		{
			
			//out.print("<script>alert('"+error+"');window.returnValue='"+returnval+"';parent.window.close();</script>");
			//out.print("<script>alert('"+error+"');window.returnValue='"+returnval+"';</script>");
			System.out.println("before calling alert");
			out.println("<script>alert('"+error+"');</script>");
			System.out.println("after calling alert");
			//if(isCalledFromCA.equals("N"))
				out.println( "<script>onsuccess('"+Patient_Id+"','"+Encounter_Id+"','"+patient_class+"','"+term_set_id+"','"+Practitioner_Id+"','"+relationship_id+"','"+Locn_Type+"','"+Locn_Code+"','"+sex+"','"+dob+"','"+occur_srl_no_hid+"','"+function_id+"','"+modal_yn+"','"+practitioner_type+"','"+isCalledFromCA+"','"+option_id+"','"+accession_number+"','"+call_from+"','"+reload_mdr+"','"+p_called_from_widget+"','"+called_from_ot+"');</script>" ) ;  //CHL-CRF- 0008 - IN:001472   this line modified for this CRF [PMG2012-CRF-0030]
			/*else if (option_id.equals("OH_REST_CHART_REC1"))
			{
				out.println( "<script language='JavaScript'>onsuccess('"+Patient_Id+"','"+Encounter_Id+"','"+patient_class+"','"+term_set_id+"','"+Practitioner_Id+"','"+relationship_id+"','"+Locn_Type+"','"+Locn_Code+"','"+sex+"','"+dob+"','"+occur_srl_no_hid+"','"+function_id+"','"+modal_yn+"','"+practitioner_type+"','"+isCalledFromCA+"','"+option_id+"','"+accession_number+"');</script>" ) ;
				
			}*/
		}
		String queryString = (String)session.getValue( "queryString" ) ;
		if ( queryString == null ) queryString = "" ;
		
		if ( error_value.equals( "1" ) && !modal_yn.equals("Y"))
		{
			out.println( "<script>onsuccess('"+Patient_Id+"','"+Encounter_Id+"','"+patient_class+"','"+term_set_id+"','"+Practitioner_Id+"','"+relationship_id+"','"+Locn_Type+"','"+Locn_Code+"','"+sex+"','"+dob+"','"+occur_srl_no_hid+"','"+function_id+"','"+modal_yn+"','"+practitioner_type+"','"+isCalledFromCA+"','"+option_id+"','"+accession_number+"','"+call_from+"','"+reload_mdr+"','"+called_from_ot+"');</script>" ) ;  //this line modified for this CRF [PMG2012-CRF-0030] 
		}
	}


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
