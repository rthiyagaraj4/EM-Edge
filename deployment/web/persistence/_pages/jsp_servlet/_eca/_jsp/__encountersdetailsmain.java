package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __encountersdetailsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncountersDetailsMain.jsp", 1737607324529L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCA/js/Encounters.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t<frameset rows=\"20%,*,0%\" border=0 frameborder=0>\n\t\t<frame src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"  name=\"DisplayCriteria\" id=\"DisplayCriteria\" scrolling=\"auto\" frameborder=\"0\">\n\t\t \t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  name=\"DisplayCriteria\"  id=\"DisplayCriteria\" scrolling=\"auto\" frameborder=\"0\">\n\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t\t\t<frameset rows=\"*,0%\" border=0 frameborder=0>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n \t\t<frameset rows=\"*,0%\" border=0 frameborder=0>  \n \t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t<frameset rows=\"20%,*,0%\" border=0 frameborder=0>\n\t\t<frame src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  name=\"DisplayCriteria\" id=\"DisplayCriteria\" scrolling=\"auto\" frameborder=\"0\"> \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<!-- \t<frame src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  name=\"DisplayCriteria\"  scrolling=\"auto\" frameborder=\"0\">-->\n\t<frame src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  name=\"DisplayCriteria\"  id=\"DisplayCriteria\" scrolling=\"auto\" frameborder=\"0\">\n\t<frame src=\"../../eCommon/html/blank.html\" name=\"DisplayResult\" id=\"DisplayResult\" scrolling=\"auto\" frameborder=\"0\">\n</frameset>\n</html>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
07/01/2013		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   
15/07/2013	IN034514		Karthi L	In Clinical Event History, one could see information about patient's visit as a 
												summary which included Patient Admission date, date of discharge, attending practitioner, etc												
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
07/10/2016	IN047572			Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the �View Clinical Notes� and �Clinical Event History�				
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String encid = request.getParameter("enc_id")==null?"":request.getParameter("enc_id");
		String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String event_date = request.getParameter("event_date")==null?"":request.getParameter("event_date");

		String graphorder = request.getParameter("graphorder")==null?"":request.getParameter("graphorder");

		String abnormal = request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
		String normalcy = request.getParameter("normalcy")==null?"":request.getParameter("normalcy");
		String episode_wise = request.getParameter("episode_wise")==null?"":request.getParameter("episode_wise");
		String view_by = request.getParameter("view_by")==null?"":request.getParameter("view_by");
		
		String episodetype		= request.getParameter("episode_type")==null?"B":request.getParameter("episode_type");
		if(episodetype.equals("")) episodetype="B";
		String selectedhisttype		= request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
		String selectedeventclass	= request.getParameter("event_class")==null?"": request.getParameter("event_class");
		String selectedeventgroup	= request.getParameter("event_group")==null?"": request.getParameter("event_group");
		String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String selectedeventitem	= request.getParameter("event_item")==null?"":request.getParameter("event_item");
		String EHR_YN	= request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
		String show_mode = request.getParameter("show_mode")==null?"":request.getParameter("show_mode");
		//Added By Jyothi on 12/03/2010 to fix 18685
		String page_no = request.getParameter("page_no")==null?"1":request.getParameter("page_no");
		String relationship_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
		String patient_class 	=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");// IN034514
		String p_menu_type 	=	request.getParameter("p_menu_type")==null?"":request.getParameter("p_menu_type");// IN034514
		String p_enc_details_tree 	=	request.getParameter("p_enc_details_tree")==null?"":request.getParameter("p_enc_details_tree");// IN034514			
		String encntr_yn 	=	request.getParameter("encntr_yn")==null?"":request.getParameter("encntr_yn");// IN034514
		String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
		String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		
		String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id;//IN035950
		//Start - IN034514
			//String params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN035950  // commented for IN034514
			String params = "";
			String params1 = "";
			if(show_mode.equals("E") || show_mode.equals("C")){
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN035950 -- // MMS-QH-CRF-0177 [IN047572] 
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code;//modified for  MMS-QH-CRF-0177 [IN047572]
				params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&p_review_rad_yn="+p_review_rad_yn;//modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params=params+"&order_type_3T="+order_type_3T;	 //39052
				if(encounterid.equals("")){
					encounterid = encid;
				}
				//params1 = "patient_class="+patient_class+"&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN034514 -- // MMS-QH-CRF-0177 [IN047572]
				//params1 = "patient_class="+patient_class+"&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; //modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params1 = "patient_class="+patient_class+"&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&p_review_rad_yn="+p_review_rad_yn; //modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params1=params1+"&order_type_3T="+order_type_3T; //39052
			}
			else {
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN035950 -- // MMS-QH-CRF-0177 [IN047572]
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; //modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&p_review_rad_yn="+p_review_rad_yn; //modified for  MMS-QH-CRF-0177 [IN047572]
				params=params+"&order_type_3T="+order_type_3T; //39052
			}
		//End - IN034514
		String file_name="";
		//Start - IN034514
		String file_name1="";
			if(show_mode.equals("E")){ // IN034514
				file_name1="../../eCA/jsp/EncountersDetails.jsp?"+params1;
				file_name="../../eCA/jsp/ExpandedClinicalEvent.jsp?"+params;
			}
			else if(show_mode.equals("C")){ 
				file_name1="../../eCA/jsp/EncountersDetails.jsp?"+params1;
				file_name="../../eCA/jsp/EncountersDetailsDisplay.jsp?"+params ;
			}

	 	
	if(patient_class.equals("XT") || (encntr_yn.equals("N") && p_menu_type.equals(""))){ 
		if(patient_class.equals("XT") && p_menu_type.equals("H"))  { 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(file_name1));
            _bw.write(_wl_block8Bytes, _wl_block8);
 }else if(patient_class.equals("XT") && encntr_yn.equals("")){ 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(file_name1));
            _bw.write(_wl_block9Bytes, _wl_block9);
 } else { 
            _bw.write(_wl_block10Bytes, _wl_block10);
 }
	} else if(!patient_class.equals("XT") || p_menu_type.equals("H") || encntr_yn.equals(""))  { 
		if( p_enc_details_tree.equals("tree_builder") && p_menu_type.equals("")) {
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		}else {
 	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_name1));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
	}
		//End - IN034514
	
            _bw.write(_wl_block14Bytes, _wl_block14);
//=file_name
            _bw.write(_wl_block15Bytes, _wl_block15);
//=params
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(file_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
