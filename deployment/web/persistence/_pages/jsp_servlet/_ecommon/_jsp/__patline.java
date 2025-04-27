package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __patline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/patLine.jsp", 1719571245938L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<SCRIPT LANGUAGE=\"JavaScript\">\n\tfunction ViewPatDtl(Pat_id)\n\t{\n\t\tPat_id=unescape(Pat_id)\n\n\t\tvar url         = \"../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID=\"+escape(Pat_id);\n\t\tvar dialogTop = \"70\" ;\n\t\tvar dialogHeight= \"40\" ;\n\t\tvar dialogWidth\t= \"65\" ;\n\t\tvar arguments   = \"\" ;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n\t\tvar returnval = window.showModalDialog( url, arguments, features ) ;\n\t}\n\n\tfunction blank() {}\n\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\' type=\'text/css\' />\n</head>\n<body OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n /*var pat_details1=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\nvar counter=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\nvar name_val;\nvar gen_val;\nvar date_of_val;\nvar pat_id;\nvar gen_val1;\nvar pref_val;\nvar final_value;\nif(counter==\"4\")\n{\npat_details1=pat_details1.split(\",\");\nname_val=pat_details1[0];\n//name1_val=pat_details1[1];\ngen_val=pat_details1[1];\ndate_of_val=pat_details1[2];\npat_id=pat_details1[3];\n/*alert(\'name_val:\'+name_val);\nalert(\'gen_val:\'+gen_val);\nalert(\'date_of_val:\'+date_of_val);\nalert(\'pat_id:\'+pat_id);\n\nif(gen_val == \" M\")\n{\ngen_val1=getLabel(\"Common.male.label\",\"common\");\n}else if(gen_val ==\" F\")\n{\ngen_val1=getLabel(\"Common.female.label\",\"common\");\n}else if(gen_val ==\" U\")\n{\ngen_val1=getLabel(\"Common.unknown.label\",\"common\");\n}\n final_value=name_val+\",\"+date_of_val+\",\"+gen_val1+\",\"+pat_id;\n}else if(counter ==\"5\")\n{\npat_details1=pat_details1.split(\",\");\nname_val=pat_details1[0];\npref_val=pat_details1[1];\ngen_val=pat_details1[2];\ndate_of_val=pat_details1[3];\npat_id=pat_details1[4];\nif(gen_val == \" M\")\n{\ngen_val1=getLabel(\"Common.male.label\",\"common\");\n}else if(gen_val ==\" F\")\n{\ngen_val1=getLabel(\"Common.female.label\",\"common\");\n}else if(gen_val ==\" U\")\n{\ngen_val1=getLabel(\"Common.unknown.label\",\"common\");\n}\n final_value=name_val+\",\"+pref_val+\",\"+date_of_val+\",\"+gen_val1+\",\"+pat_id;\n}else if(counter ==\"6\")\n{\npat_details1=pat_details1.split(\",\");\nsuf_val=pat_details1[0];\nname_val=pat_details1[1];\npref_val=pat_details1[2];\ngen_val=pat_details1[3];\ndate_of_val=pat_details1[4];\npat_id=pat_details1[5];\nif(gen_val == \" M\")\n{\ngen_val1=getLabel(\"Common.male.label\",\"common\");\n}else if(gen_val ==\" F\")\n{\ngen_val1=getLabel(\"Common.female.label\",\"common\");\n}else if(gen_val ==\" U\")\n{\ngen_val1=getLabel(\"Common.unknown.label\",\"common\");\n}\n final_value=suf_val+\",\"+name_val+\",\"+pref_val+\",\"+date_of_val+\",\"+gen_val1+\",\"+pat_id;\n}*/\n</script>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n<tr>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<td width=\"5%\" class=\'PATIENTLINECOLOR\' ><img onClick=\'showPatientImage(\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\");\' align=\'left\' src=\'../../eMP/images/PatientPhoto.gif\' onMouseOver=\'style.cursor=\"hand\";title=\"Click to View Patient Photo\"\'></img></td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" <!-- <td width=\"5%\" class=\'PATIENTLINECOLOR\'>&nbsp;</td> --> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<td  class=\'PATIENTLINECOLOR\'  style=\'position:relative;\' nowrap style=\"cursor:pointer;\" onClick=\"ViewPatDtl(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\"><font  size=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<td  class=\'PATIENTLINECOLOR\' id=\'outstdAmt\' >&nbsp;</td><td  class=\'PATIENTLINECOLOR\'  style=\'position:relative;\' nowrap style=\"cursor:pointer;\" onClick=\"ViewBLDtl(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\"><font  size=\'2\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<td></td>\n</tr>\n</body>\n</html>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection con = null;
	try
	{
		con=ConnectionManager.getConnection(request);
		Statement stmt	= null;
		ResultSet rs	= null;
		String Patient_Id = request.getParameter("Patient_Id");
		String facilityid=(String)session.getValue("facility_id");
		
		String episodeID="";
		String visitNum="";
		String Pat_Details="";
		String PatDetails="";
		String bl_details="";
		
		String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
		String resp_id = (String) session.getValue("responsibility_id");
		String selectSql = "";
		String view_pat_photo_yn = "N";
		 String locale=(String)session.getAttribute("LOCALE");
int counter1=0;
		
		
	


            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);


stmt = con.createStatement();
if(bl_install_yn.equals("Y"))
				{     
	 
		rs = stmt.executeQuery("select BL_PROC_ITEM_VALIDATIONS_MP.GET_PATIENT_BANNER('"+facilityid+"','"+Patient_Id+"','','','"+locale+"')bl_dtls from dual");
		if(rs != null && rs.next()) 
		{
			bl_details = rs.getString("bl_dtls")==null?"":rs.getString("bl_dtls");
		}
				}
		//stmt = con.createStatement();
		
		rs = stmt.executeQuery("select get_patient_line('"+Patient_Id+"','"+locale+"') from dual");
		
		if(rs != null && rs.next()) 
		{
			Pat_Details = rs.getString(1);
		}
		PatDetails = Pat_Details.substring(0,(Pat_Details.indexOf("#")));
		
		 StringTokenizer token=new StringTokenizer(PatDetails,",");
		 counter1=token.countTokens();
		

		 if(rs != null) rs.close();

		selectSql = "select view_pat_photo_yn from mp_access_rights where resp_id = '"+resp_id+"' ";
	//	stmt = con.createStatement();

		rs = stmt.executeQuery(selectSql);
		if (rs != null && rs.next())
		{
			view_pat_photo_yn = rs.getString(1);
			if(view_pat_photo_yn == null || view_pat_photo_yn.equals("null")) view_pat_photo_yn = "N";
		}
		if(rs != null) rs.close();

		//String pat_details1=PatDetails;
		int counter=counter1;
		String name_val = "";
		String name_val1 = "";
		String gen_val  = "";
		String date_of_val = "";
		String pat_id = "";
		String gen_val1 = "";
		String pref_val = "";
		String[] arg_vals = new String[10];
		String final_value = "";
		String suf_val = "";

		int i=0;
		while (token.hasMoreTokens()) {
			arg_vals[i]=token.nextToken();
			arg_vals[i]=arg_vals[i].trim();
			i++;
		}
		if(counter==4)
		{
		name_val=arg_vals[0];
		//name1_val=pat_details1[1];
		gen_val=arg_vals[1];
		date_of_val=arg_vals[2];
		pat_id=arg_vals[3];

		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=name_val+","+date_of_val+","+gen_val1+","+pat_id;
		}
		else if(counter ==5)
		{
		name_val=arg_vals[0];
		pref_val=arg_vals[1];
		gen_val=arg_vals[2];
		date_of_val=arg_vals[3];
		pat_id=arg_vals[4];
		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=name_val+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
		}
		else if(counter ==6)
		{
		suf_val=arg_vals[0];
		name_val=arg_vals[1];
		pref_val=arg_vals[2];
		gen_val=arg_vals[3];
		date_of_val=arg_vals[4];
		pat_id=arg_vals[5];
		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=suf_val+","+name_val+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
		}else if(counter==7)
		{


		suf_val=arg_vals[0];
		name_val=arg_vals[1];
		name_val1=arg_vals[2];
		pref_val=arg_vals[3];
		gen_val=arg_vals[4];
		date_of_val=arg_vals[5];
		pat_id=arg_vals[6];
		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=suf_val+","+name_val+","+name_val1+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
		}


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(PatDetails));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(counter1));
            _bw.write(_wl_block5Bytes, _wl_block5);
if(view_pat_photo_yn.equals("Y")) { 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block7Bytes, _wl_block7);
}
	//else { 
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		//}
	
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((PatDetails.length()>50?"-5":"2")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(final_value));
            _bw.write(_wl_block12Bytes, _wl_block12);

		if(!bl_details.trim().equals("")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(episodeID));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(visitNum));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_details));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else
            _bw.write(_wl_block17Bytes, _wl_block17);
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();
	}catch(Exception e){
		out.println(e);
		e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
