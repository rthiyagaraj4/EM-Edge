package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public final class __oppatientlistforaltid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OPPatientListforAltId.jsp", 1743070193568L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</title>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tasync function viewPatientDetails(p_patient_id)\n\t{\n\t\tvar title = getLabel(\"eMP.ViewPatientDetails.label\",\"MP\");\n\t\tvar dialogHeight= \"41vh\" ;\n\t\tvar dialogWidth\t= \"70vw\" ;\n\t\tvar dialogTop=\"\";\n\t\tvar dialogLeft=\"1\";\t\n\t\tvar prev=\"prev\";\n\t\tvar display=\"display\";\n\t\tvar features= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\t\n\t\tretVal\t=  await window.showModalDialog(\'../../eMP/jsp/ViewPatDetailsMain.jsp?display=\'+display+\'&Patient_ID=\'+p_patient_id,arguments,features);\n\t} \n\tfunction selectPatientId(patient_id) {\n\t\t\n\t\twindow.returnValue = patient_id; \n\t\twindow.close();\n\t}\n</script>\n</head>\n\n<body onKeyDown =\'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table border = \'1\' cellpadding = \'4\' cellspacing = \'0\' width = \'100%\' align =\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class = \'columnheader\' width = \'5%\'>&nbsp;+</td>\n\t\t\t\t\t<td class = \'columnheader\' width = \'20%\'>&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t<td class = \'columnheader\' width = \'20%\'>&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<td class = \'columnheader\' width = \'20%\'>&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<td class = \'columnheader\' width = \'15%\'>&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class = \'columnheader\' width = \'10%\'>&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class = \'label\' onclick = \"javascript:viewPatientDetails(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\" style=\'width:102;cursor:pointer;color:blue\'>+</td>\n\t\t\t\t\t\t<td class = \'label\' onClick = \'javascript:selectPatientId(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\")\' style=\'width:102;cursor:pointer;color:blue\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class = \'querydata\'>&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<td class = \'querydata\'>&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<td class = \'querydata\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t<td class = \'querydata\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

//String facility_id = (String) session.getValue("facility_id");

String altIdNo1 = request.getParameter("altIdNo1") == null?"":request.getParameter("altIdNo1");
/*Below line Added for this SCF  MMS-SCF-0071 [IN:042582]*/	
String altIdNo2 = request.getParameter("altIdNo2") == null?"":request.getParameter("altIdNo2");
String altIdNo3 = request.getParameter("altIdNo3") == null?"":request.getParameter("altIdNo3");
String altIdNo4 = request.getParameter("altIdNo4") == null?"":request.getParameter("altIdNo4");
String otheraltIdType = request.getParameter("otherAlternateIDType") == null?"":request.getParameter("otherAlternateIDType");
String otheraltIdNo = request.getParameter("otherAlternateIDNo") == null?"":request.getParameter("otherAlternateIDNo");

String titledesc="";
if(altIdNo1!=null && !altIdNo1.equals(""))titledesc=altIdNo1;
if(altIdNo2!=null && !altIdNo2.equals(""))titledesc=altIdNo2;
if(altIdNo3!=null && !altIdNo3.equals(""))titledesc=altIdNo3;
if(altIdNo4!=null && !altIdNo4.equals(""))titledesc=altIdNo4;
if(otheraltIdNo!=null && !otheraltIdNo.equals(""))titledesc=otheraltIdNo;

StringBuffer whereclause=new StringBuffer();

if(altIdNo1!=null && !altIdNo1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID1_NO) = UPPER('"+altIdNo1+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID1_NO) =UPPER('"+altIdNo1+"')");   // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(altIdNo2!=null && !altIdNo2.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID2_NO) =UPPER('"+altIdNo2+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID2_NO) =UPPER('"+altIdNo2+"')");  // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(altIdNo3!=null && !altIdNo3.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID3_NO)  =UPPER('"+altIdNo3+"')");  // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID3_NO)  =UPPER('"+altIdNo3+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(altIdNo4!=null && !altIdNo4.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID4_NO) =UPPER('"+altIdNo4+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID4_NO) =UPPER('"+altIdNo4+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(otheraltIdNo!=null && !otheraltIdNo.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and oth_alt_id_type = '"+otheraltIdType+"' and UPPER(oth_alt_id_no) = UPPER('"+otheraltIdNo+"') ");
		// this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" oth_alt_id_type = '"+otheraltIdType+"' and UPPER(oth_alt_id_no) = UPPER('"+otheraltIdNo+"') ");
		// this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}

//End MMS-SCF-0071 [IN:042582]
String altId1Desc = request.getParameter("altId1Desc") == null?"":request.getParameter("altId1Desc");
String names_in_oth_lang_yn = request.getParameter("names_in_oth_lang_yn") == null?"N":request.getParameter("names_in_oth_lang_yn");
String locale	= (String)session.getAttribute("LOCALE");
int patientPos = 0;

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;


/*Below line Added for this incident [IN:001921]*/
StringBuffer assign=new StringBuffer();
String titlevaluassign="";
if(altIdNo1!=null && !altIdNo1.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID1_NO) =UPPER('"+altIdNo1+"')");
titlevaluassign="ALT_ID1_NO";
}if(altIdNo2!=null && !altIdNo2.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID2_NO) =UPPER('"+altIdNo2+"')");
titlevaluassign="ALT_ID2_NO";
}if(altIdNo3!=null && !altIdNo3.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID3_NO)  =UPPER('"+altIdNo3+"')");
titlevaluassign="ALT_ID3_NO";
}if(altIdNo4!=null && !altIdNo4.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID4_NO) =UPPER('"+altIdNo4+"')");
titlevaluassign="ALT_ID4_NO";
}
//End [IN:001921]

	try {

		con = ConnectionManager.getConnection(request);
	    String titledisply="SELECT mp_get_desc.mp_alternate_id_type (alt_id1_type, 'en', 2) alt_id1_type,  mp_get_desc.mp_alternate_id_type (alt_id2_type, 'en', 2) alt_id2_type, mp_get_desc.mp_alternate_id_type (alt_id3_type, 'en', 2) alt_id3_type, mp_get_desc.mp_alternate_id_type (alt_id4_type, 'en', 2) alt_id4_type   FROM mp_param";
		
		pstmt = con.prepareStatement(titledisply);	
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){			
		if(titlevaluassign.equals("ALT_ID1_NO")) titlevaluassign=rs.getString(1);
		if(titlevaluassign.equals("ALT_ID2_NO")) titlevaluassign=rs.getString(2);		
		if(titlevaluassign.equals("ALT_ID3_NO")) titlevaluassign=rs.getString(3);	
		if(titlevaluassign.equals("ALT_ID4_NO")) titlevaluassign=rs.getString(4);			 
		}		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
	} catch (Exception e1) {
		e1.printStackTrace();
	}

//String temp_title = altId1Desc+" - "+altIdNo1;
//String temp_title = altId1Desc+" - "+titledesc;

String temp_title = titlevaluassign+" - "+titledesc;
String title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientListforAltIdNo1.label","mp_labels");
title = title.replace("$",temp_title);	


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(title));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	try {

		//con = ConnectionManager.getConnection(request);

		//String patientListSql = "SELECT a.PATIENT_ID, a.PATIENT_NAME, a.PATIENT_NAME_LOC_LANG, a.SEX, to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy') date_of_birth, (select max(FILE_NO) from mr_pat_file_index b where b.patient_id = a.patient_id group by b.patient_id) FILE_NO FROM mp_patient a WHERE a.ALT_ID1_NO = ? ";
		
		/*Above line commented and below line added for this CRF  MMS-SCF-0071 [IN:042582]*/
			
		String patientListSql = "SELECT a.PATIENT_ID, a.PATIENT_NAME, a.PATIENT_NAME_LOC_LANG, a.SEX, to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy') date_of_birth, (select max(FILE_NO) from mr_pat_file_index b where b.patient_id = a.patient_id group by b.patient_id) FILE_NO FROM mp_patient a where" + whereclause.toString();

		pstmt = con.prepareStatement(patientListSql);		

		rs = pstmt.executeQuery();

		if(rs!=null) {

			
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

						if(names_in_oth_lang_yn.equals("Y")) {
					
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

						}
					
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);


			while (rs.next()) {

				patientPos++;

				String patient_id =  rs.getString("PATIENT_ID") == null?"":rs.getString("PATIENT_ID");
				String patient_name =  rs.getString("PATIENT_NAME") == null?"&nbsp;":rs.getString("PATIENT_NAME");
				String patient_loc_name =  rs.getString("PATIENT_NAME_LOC_LANG") == null?"&nbsp;":rs.getString("PATIENT_NAME_LOC_LANG");
				String gender =  rs.getString("SEX") == null?"&nbsp;":rs.getString("SEX");
				String date_of_birth =  rs.getString("DATE_OF_BIRTH") == null?"":rs.getString("DATE_OF_BIRTH");
				String file_no =  rs.getString("FILE_NO") == null?"&nbsp;":rs.getString("FILE_NO"); 

			if(gender.equals("M"))
				gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(gender.equals("F"))
				gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(gender.equals("U"))
				gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",locale);

				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block19Bytes, _wl_block19);

							if(names_in_oth_lang_yn.equals("Y")) {
						
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_loc_name));
            _bw.write(_wl_block19Bytes, _wl_block19);

							}
						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block23Bytes, _wl_block23);


			}

		}

		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientNameInLocalLang.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MRNo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DOB.label", java.lang.String .class,"key"));
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
}
