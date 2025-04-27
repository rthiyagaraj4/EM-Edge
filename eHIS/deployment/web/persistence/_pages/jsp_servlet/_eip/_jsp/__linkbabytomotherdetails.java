package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __linkbabytomotherdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/LinkBabytoMotherDetails.jsp", 1742445874889L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<TITLE><!--  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="  --></TITLE>\n\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<script language=\"JavaScript\">\n\t<!--\n\tfunction submit_page()\n\t{\n\t\tvar babyCount =  document.forms[0].babyCount;\n\t\t\n\t\tvar error = \"\";\n\t\tvar arrayBedCount = new Array();\n\t\tvar   outcome    =\"\";   \n\t\tfor(var indexI=0;indexI < parseInt(babyCount.value);indexI++)\n\t\t{\n\t\t\tvar patid = eval(\"document.forms[0].baby_patient_id\"+indexI) \n\t\t\n\t\t\tvar objText = eval(\"document.forms[0].to_bed_no\"+indexI)\n\n\t\t\toutcome = eval(\"document.forms[0].outcome\"+indexI).value;\n\t\t\tif(outcome!=\"S\")\n\t\t\t{\n\t\t\t\t if(objText.value==\"\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BED_NO_NOTNULL\",\'IP\'));\n\t\t\t\t\tobjText.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tarrayBedCount[indexI] = objText.value;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t}\n\t\tfor(var indexI=0 ;indexI < arrayBedCount.length;indexI++)\n\t\t{\n\t\t\tfor(var indexJ=indexI + 1  ;indexJ <arrayBedCount.length;indexJ++)\n\t\t\t{\n\t\t\t\tif(arrayBedCount[indexJ] == arrayBedCount[indexI])\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"DUPLICATE_BED_NO\",\'IP\'));\n\t\t\t\t\tobjText = eval(\"document.forms[0].to_bed_no\"+indexJ);\n\t\t\t\t\tobjText.select();\n\t\t\t\t\treturn false;     \n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tif(!arrayBedCount.length == 0)\n\t\t{\n\t\t\tdocument.BabyMother_Link_Form.record_button.disabled= true;\n\t\t\tdocument.BabyMother_Link_Form.submit();\n\t\t}else\n\t\t{\n\t\t\talert(getMessage(\'NO_CHANGE_TO_SAVE\',\'Common\'));\n\t\t\twindow.close();\n\t\t}\n\t}\n\n\tfunction closeWindow()\n\t{\n\t\twindow.close();\n\t}\n\n\tasync function callBedAvailChart(obj)\n\t{\n\t\tvar nursing_unit_code =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tvar practitionerid = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\tvar specialitycode = \"\";\n\t\tvar ipparam_bed_yn = \"\";\n\t\tvar bedclasscode = \"\";\n\t\tvar main_bed_no = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\tvar bedtypecode = \"\";\n\t\tvar gender = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\tvar agevalue = \"\";\n\t\tvar age = \"\";\n\t\tvar yr = eval(agevalue.indexOf(\"Y\"));\n\t\tvar mon = eval(agevalue.indexOf(\"M\"));\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"1200px\";\n\t\tvar dialogWidth = \"1200px\";\n\t\tvar dialogTop\t= \"10px\";\n\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar wherecondn  = \"EMERGENCY_TFR_YN\"; \n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \";dialogTop:\" + dialogTop + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\n\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code=\"+nursing_unit_code+\"&main_bed_no=\"+main_bed_no+\"&call_function=NEW_BORN_REGN&bed_type=baby\",arguments,features);\n\t\tif(retVal!=null)\n\t\t{\n\t\t\tvar arr = retVal.split(\"^\");\n\t\t\tif(arr.length > 2)\n\t\t\t{\n\t\t\t\tvar arr1 = arr[1].split(\"/\");\n\t\t\t\tobj.value = arr1[0];\n\t\t\t\tvar arrsplty = arr[11].split(\"*All SPLTY*\");\n\t\t\t\n\t\t\t\tif(arr[4] ==null )  \tarr[4] =\'\';\n\t\t\t\t\n\t\t\t\tif(arr[14] ==\'Pseudo Bed\')\n\t\t\t\tvar pseudo_yn=\'Y\';\n\t\t\t\telse\n\t\t\t\tvar pseudo_yn=\'N\';\n\t\t\t\n\t\t\t}\n\t\t\t\n\t\t}\n\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n <form name=\"BabyMother_Link_Form\" id=\"BabyMother_Link_Form\" action=\'../../servlet/eIP.LinkBabytoMotherServlet\' method=\'post\' target=\'MessageFrame\'> \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<table border=0 cellpadding=0 cellspacing=0 width=\'100%\'>\n\t\t\t<tr><td colspan = \'10\' class=\'label\'>&nbsp;</tr><tr><td class=\'label\' colspan = \'10\'>&nbsp;</tr><tr><td class=\'label\' colspan = \'10\'>&nbsp;</tr><tr><td colspan = \'10\' class=\'label\'><table border=1 cellpadding=0 cellspacing=0 width=\'100%\'><tr><th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th><th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th></tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t                  <td class=\'\"+classValue+\"\'\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t           ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t                  <td class=\'\"+classValue+\"\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td> \n\t                  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t                   <td class=\'\"+classValue+\"\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );


	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		request.setCharacterEncoding("UTF-8");
		String practitioner_id	= checkForNull(request.getParameter("practitioner_id"));
		String gender			= checkForNull(request.getParameter("Sex"));
		String nurs_unit_code	= checkForNull(request.getParameter("nursing_code"));
		String main_bed_no		= checkForNull(request.getParameter("bed_no"));
		String patient_class	= checkForNull(request.getParameter("patient_class"));
		String mother_encounterid = checkForNull(request.getParameter("encounterid"));
		String facilityid		= checkForNull(request.getParameter("facilityid"));
		String call_function	= checkForNull(request.getParameter("call_function"));
		String mother_patient_id= checkForNull(request.getParameter("mother_patient_id"));
        String locale			= (String)session.getAttribute("LOCALE");
	    String outcome ="";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nurs_unit_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(main_bed_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block13Bytes, _wl_block13);

		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rset			=null;
		
	try{
		con			= ConnectionManager.getConnection(request);
		Boolean isLabelChangeApplicable = CommonBean.isSiteSpecific(con, "IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
		
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("select to_char(a.time_of_birth,'dd/mm/rrrr') date_of_birth, to_char(a.time_of_birth,'hh24:mi') time_of_birth,a.outcome , a.nb_sex gender, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, a.patient_id, a.weight, a.weight_unit, am_get_desc.am_practitioner(a.attend_physician_id, '"+locale+"', 1) practitioner_name, d.bed_no from mp_birth_register a, mp_patient b, ip_nursing_unit_bed d  where a.encounter_facility_id = '"+facilityid+"' and a.mother_encounter_id = '"+mother_encounterid+"'and a.mother_patient_id = '"+mother_patient_id+"' and a.patient_id = b.patient_id and a.mother_encounter_id = d.mothers_encounter_id (+) and a.patient_id = d.occupying_patient_id (+) and not exists (select patient_id from ip_open_encounter where patient_id = a.patient_id)  order by time_of_birth");
		pstmt	= con.prepareStatement(sqlQuery.toString());

		rset	= pstmt.executeQuery();
		int i	= 0;
		String classValue	= "";
		String birth_weight = "";
		String baby_bed_no	= "";
		int babycount		= 0;

		if(rset!=null && rset.next())
		{			
			
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			do
			{
				i++;

				if(i%2 == 0) 
					classValue="QRYEVEN";
				else
					classValue = "QRYODD";

				String date_of_birth_converted = rset.getString("date_of_birth");

				if(date_of_birth_converted==null || date_of_birth_converted.equals(""))
					date_of_birth_converted = "";
				else
					date_of_birth_converted = DateUtils.convertDate(date_of_birth_converted,"DMY","en",locale);
				
				String time_of_birth_converted = rset.getString("time_of_birth");
				
				if(time_of_birth_converted==null || time_of_birth_converted.equals(""))
					time_of_birth_converted = "";
				else
					time_of_birth_converted = DateUtils.convertDate(time_of_birth_converted,"HM","en",locale);
				
				


				out.println("<tr>");
				out.println("<td nowrap class='"+classValue+"'>"+rset.getString("patient_id")+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+rset.getString("patient_name")+"</td>");	
				out.println("<td nowrap class='"+classValue+"'>"+date_of_birth_converted+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+time_of_birth_converted+"</td>");
		        gender=rset.getString("gender");	
		        if(gender.toUpperCase().equals("M"))
	             {
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}else if(gender.toUpperCase().equals("F"))
	                    {
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}else if(gender.toUpperCase().equals("U"))
	                    {
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
				
				birth_weight	= checkForNull(rset.getString("weight"));
				baby_bed_no		= checkForNull(rset.getString("bed_no"));
                String weight_unit= checkForNull(rset.getString("weight_unit") );
				if(weight_unit.toUpperCase().equals("K"))
                {
				weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels");
				}
				else if(weight_unit.toUpperCase().equals("L"))
                {
			   weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.lb.label","common_labels");
				}
				if(!birth_weight.equals(""))
				out.println("<td nowrap class='"+classValue+"'>"+birth_weight+" "+weight_unit+"</td>");
				else
				out.println("<td nowrap class='"+classValue+"'>"+birth_weight+"</td>");
				 outcome=checkForNull(rset.getString("outcome"));
				if(outcome.equals("L"))
				{ 
					if(isLabelChangeApplicable){
					out.println("<td nowrap class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Alive.label","mp_labels")+"</td>");//Modified by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
					}else{
					out.println("<td nowrap class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Live.label","mp_labels")+"</td>");
					
					}
				}
				else 
				{
					out.println("<td nowrap 	class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StillBorn.option.label","mp_labels")+"</td>");
				}
				out.println("<td nowrap class='"+classValue+"'>"+checkForNull(rset.getString("practitioner_name"))+"</td>");

				if (call_function.equals("IPList"))
				{
					if(baby_bed_no.equals("")||baby_bed_no==null)
					{
						baby_bed_no = "&nbsp;";
					}
					out.println("<td nowrap class='"+classValue+"'> "+baby_bed_no+"</td></tr>");
				}
				else
				if (call_function.equals("BabyLinktoMother"))
				{
					if(baby_bed_no.equals("")||baby_bed_no==null)
					{
						if(outcome.equals("S"))
						{
                    out.println("<td nowrap class='"+classValue+"'><input type='text' name='to_bed_no"+babycount+"' id='to_bed_no"+babycount+"' value='' size=8 maxlength=8 readonly> <input type='button' class='button' value='?' id='bedlookkup' onclick='callBedAvailChart(document.forms[0].to_bed_no"+babycount+");' disabled></td></tr><input type='HIDDEN' name='baby_patient_id"+babycount+"' id='baby_patient_id"+babycount+"' value='"+rset.getString("patient_id")+"'><input type='HIDDEN' name='outcome"+babycount+"' id='outcome"+babycount+"' value='"+outcome+"'>");			

						}else{
						out.println("<td nowrap class='"+classValue+"'><input type='text' name='to_bed_no"+babycount+"' id='to_bed_no"+babycount+"' value='' size=8 maxlength=8 readonly> <input type='button' class='button' value='?' id='bedlookkup' onclick='callBedAvailChart(document.forms[0].to_bed_no"+babycount+");' >&nbsp;&nbsp;<img align='center' id='bedoimg'src='../../eCommon/images/mandatory.gif'></td></tr><input type='HIDDEN' name='baby_patient_id"+babycount+"' id='baby_patient_id"+babycount+"' value='"+rset.getString("patient_id")+"'><input type='HIDDEN' name='outcome"+babycount+"' id='outcome"+babycount+"' value='"+outcome+"'>");					
						}
					}
					else
					{
						out.println("<td nowrap class='"+classValue+"'><input type='text' name='to_bed_no"+babycount+"' id='to_bed_no"+babycount+"' value='"+baby_bed_no+"' size=8 maxlength=8 readonly> <input type='button' class='button' value='?' id='bedlookkup' onclick='callBedAvailChart(document.forms[0].to_bed_no"+babycount+");' disabled>&nbsp;&nbsp;<img align='center' id='bedoimg'src='../../eCommon/images/mandatory.gif'></td></tr><input type='HIDDEN' name='baby_patient_id"+babycount+"' id='baby_patient_id"+babycount+"' value='"+rset.getString("patient_id")+"'><input type='HIDDEN' name='outcome"+babycount+"' id='outcome"+babycount+"' value='"+outcome+"'>");
					}
					babycount++;
				}
			}while(rset.next());
			out.println("</table>");
			out.println(" <input type='HIDDEN' name='babyCount' id='babyCount' value='"+babycount+"'>");
			out.println(" <input type='HIDDEN' name='practitioner_id' id='practitioner_id' value='"+practitioner_id+"'>");
			
			
			out.println(" <input type='HIDDEN' name='gender' id='gender' value='"+gender+"'>");
			out.println(" <input type='HIDDEN' name='nurs_unit_code' id='nurs_unit_code' value='"+nurs_unit_code+"'>");
			out.println(" <input type='HIDDEN' name='main_bed_no' id='main_bed_no' value='"+main_bed_no+"'>");
			out.println(" <input type='HIDDEN' name='patient_class' id='patient_class' value='"+patient_class+"'>");
			out.println(" <input type='HIDDEN' name='mother_encounterid' id='mother_encounterid' value='"+mother_encounterid+"'>");
			out.println(" <input type='HIDDEN' name='facilityid ' id='facilityid ' value='"+facilityid +"'>");
			out.println(" <input type='HIDDEN' name='call_function' id='call_function' value='"+call_function+"'>");
			out.println(" <input type='HIDDEN' name='mother_patient_id' id='mother_patient_id' value='"+mother_patient_id+"'>");

			out.println("<table  width='100%' cellspacing=0 cellpadding=0><tr><td class='label'>&nbsp;</tr><tr><td class='label'>&nbsp;</tr><tr><td class='label'>&nbsp;</tr><tr><td align='right' class='label'><br><br><br>");

			if (call_function.equals("BabyLinktoMother"))
			{
				out.println("<input type='button' name='record_button' id='record_button' class='button' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")+"' onclick='submit_page()'>");
			}

			out.println("<input type='button' name='close' id='close' class='button' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")+"' onclick='closeWindow()'></td></tr></table></td></tr></table>");
		}
		else
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.window.close();</script>");
		}
	}catch(Exception e) { out.println(e.toString()); e.printStackTrace();}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BabyToMotherDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
