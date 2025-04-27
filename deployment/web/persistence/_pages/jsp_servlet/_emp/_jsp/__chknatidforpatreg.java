package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __chknatidforpatreg extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/chkNatIDForPatReg.jsp", 1731834005839L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientSearch.js\'></Script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="  \n\t\t\t\t<html>\n\t\t\t\t\t<head>\n\t\t\t\t\t</head>\n\t\t\t\t\t<body onKeyDown=\'lockKey();\'>\n\t\t\t\t\t<form name =\"RapidPass\" id =\"RapidPass\">\n\t\t\t\t\t<input type = \"hidden\" id = \"Second_Name\" name = \"Second_Name\" value = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\t\t\t\t\t\n\t\t\t\t\t<input type = \"hidden\" id = \"First_Name\" name = \"First_Name\" value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"Third_Name\" name = \"Third_Name\" value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"Family_Name\" name = \"Family_Name\" value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"first_name_loc_lang\" name = \"first_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"second_name_loc_lang\" name = \"second_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"third_name_loc_lang\" name = \"third_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"family_name_loc_lang\" name = \"family_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\n\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\tparent.frames[0].location = \"InsertRapidRegnHead.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\t\tdocument.location=\"../../eMP/jsp/InsertRapidRegn.jsp?group=G&First_Name=\"+encodeURIComponent(document.RapidPass.First_Name.value)+\"&Second_Name=\"+encodeURIComponent(document.RapidPass.Second_Name.value)+\"&Third_Name=\"+encodeURIComponent(document.RapidPass.Third_Name.value)+\"&Family_Name=\"+encodeURIComponent(document.RapidPass.Family_Name.value)+\"&Alt_Id_No=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Alt_Id2_No=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Alt_Id3_No=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&Alt_Id4_No=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&National_Id_No=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&MRN=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&Dob=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&Sex=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&Area=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&Family_No=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&OldFileNo=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&apply_oth_name=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&first_name_loc_lang=\"+encodeURIComponent(document.RapidPass.first_name_loc_lang.value)+\"&second_name_loc_lang=\"+encodeURIComponent(document.RapidPass.second_name_loc_lang.value)+\"&third_name_loc_lang=\"+encodeURIComponent(document.RapidPass.third_name_loc_lang.value)+\"&family_name_loc_lang=\"+encodeURIComponent(document.RapidPass.family_name_loc_lang.value)+\"&";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\n\n\t\t\t\t\t\t</form>\n\t\t\t\t\t</body>\n\t\t\t\t</html>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<html>\n\t\t\t\t\t<head>\n\t\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></link>\n\t\t\t\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t\t\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\tasync function showModal()    {  \n\t\t\t\t\t\tvar retVal =    new String();\n\t\t\t\t\t\t//var dialogHeight    = \"11\" ;\n\t\t\t\t\t\t//var dialogWidth = \"20\" ;\n\t\t\t\t\t\t/* var dialogHeight= \"200px\" ;\n\t\t\t\t\t\tvar dialogTop = \"10px\" ;\n\t\t\t\t\t\tvar dialogWidth\t= \"350px\" ; */\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar dialogHeight= \"30vh\" ;\n\t\t\t\t\t\tvar dialogTop = \"0vh\" ;\n\t\t\t\t\t\tvar dialogWidth\t= \"25vw\" ;\n\t\t\t\t\t\t  \n\t\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no ;\";\n\t\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\t\tretVal = await window.showModalDialog(\"../../eMP/jsp/loadModal.jsp?series=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&alt_id=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&prompt=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\",arguments,features);\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar pat_grp =\"G\"\t\t\t\t\t\t\n\t\t\t\t\t\tif(retVal != null)\n\t\t\t\t\t\tpat_grp= retVal.charAt(0);\n\t\t\t\t\t\tvar loc = \"\" ;\n\t\t\t\t\t\tparent.frames[0].location = \"InsertRapidRegnHead.jsp?";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\t\tif ( pat_grp == \'N\' )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar pat_id = escape(retVal.substr(1));\n\t\t\t\t\t\t\tloc=\"../../eMP/jsp/InsertRapidRegn.jsp?group=\"+pat_grp+\"&nat_id=\"+pat_id ; \n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if ( pat_grp == \'A\' )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar alt_id = escape(retVal.substr(1));\n\t\t\t\t\t\t\tloc=\"../../eMP/jsp/InsertRapidRegn.jsp?group=\"+pat_grp+\"&alt_id=\"+alt_id ;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if ( pat_grp == \'G\' )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tloc=\"../../eMP/jsp/InsertRapidRegn.jsp?from_modal=Y&group=G\"; \n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\twindow.location = loc+ \"&First_Name=\"+encodeURIComponent(document.RapidPass.First_Name.value)+\"&Second_Name=\"+encodeURIComponent(document.RapidPass.Second_Name.value)+\"&Third_Name=\"+encodeURIComponent(document.RapidPass.Third_Name.value)+\"&Family_Name=\"+encodeURIComponent(document.RapidPass.Family_Name.value)+\"&Alt_Id_No=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t</head>\n\t\t\t\t\t<body onKeyDown=\'lockKey();\'>\n\t\t\t\t\t<form name =\"RapidPass\">\n\t\t\t\t\t<input type = \"hidden\" id = \"Second_Name\" name = \"Second_Name\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\t\t\t\n\t\t\t\t\t<script language=\'javascript\'>\n\n\t\t\t\t\tsetTimeout(\"showModal()\",500);\n\n\t\t\t</script>\n\n\t\t\t\t\t<form>\n\t\t\t\t\t</body>\n\t\t\t\t\t</html>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
String First_Name=request.getParameter("First_Name");if(First_Name==null)First_Name="";
String Second_Name=request.getParameter("Second_Name");if(Second_Name==null)Second_Name="";
String Third_Name=request.getParameter("Third_Name");if(Third_Name==null)Third_Name="";
String Family_Name=request.getParameter("Family_Name");if(Family_Name==null)Family_Name="";
String Alt_Id_No=request.getParameter("Alt_Id_No");if(Alt_Id_No==null)Alt_Id_No="";
String Alt_Id2_No=request.getParameter("Alt_Id2_No");if(Alt_Id2_No==null)Alt_Id2_No="";
String Alt_Id3_No=request.getParameter("Alt_Id3_No");if(Alt_Id3_No==null)Alt_Id3_No="";
String Alt_Id4_No=request.getParameter("Alt_Id4_No");if(Alt_Id4_No==null)Alt_Id4_No="";
String National_Id_No=request.getParameter("National_Id_No");if(National_Id_No==null)National_Id_No="";
String MRN=request.getParameter("MRN");if(MRN==null)MRN="";
String Dob=request.getParameter("Dob");if(Dob==null)Dob="";
String Sex=request.getParameter("Sex");if(Sex==null)Sex="";
String Area=request.getParameter("Area");if(Area==null)Area="";
String Family_No=request.getParameter("Family_No");if(Family_No==null)Family_No="";
String OldFileNo=request.getParameter("OldFileNo");if(OldFileNo==null)OldFileNo="";
String apply_oth_name=request.getParameter("apply_oth_name");if(apply_oth_name==null)apply_oth_name="";
String first_name_loc_lang=request.getParameter("first_name_loc_lang");if(first_name_loc_lang==null)first_name_loc_lang="";
String second_name_loc_lang=request.getParameter("second_name_loc_lang");if(second_name_loc_lang==null)second_name_loc_lang="";
String third_name_loc_lang=request.getParameter("third_name_loc_lang");if(third_name_loc_lang==null)third_name_loc_lang="";
String family_name_loc_lang=request.getParameter("family_name_loc_lang");if(family_name_loc_lang==null)family_name_loc_lang="";
String dflt_pat_ser_grp_type = "" ;
String alt_id1_type = "" ;
String nat_id_prompt = "" ;
String countSeries = "" ;
String countPatSeries = "" ;
int cntSeries = 0, cntPatSeries = 0;
dflt_pat_ser_grp_type = request.getParameter("dflt_pat_ser_grp_type");
alt_id1_type = request.getParameter("alt_id1_type");
nat_id_prompt = request.getParameter("nat_id_prompt");
countSeries = request.getParameter("cntSeries");
countPatSeries= request.getParameter("cntPatSeries");
try
{		
	cntSeries = Integer.parseInt(countSeries);
	cntPatSeries = Integer.parseInt(countPatSeries);
	   if (cntSeries > 0)
		{			
			if (cntPatSeries > 0)
			{
				if  (dflt_pat_ser_grp_type.equals("G") ) 
				{
				
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Second_Name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(First_Name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Third_Name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Family_Name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Alt_Id_No));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Alt_Id2_No));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Alt_Id3_No));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Alt_Id4_No));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(National_Id_No));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(MRN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Area));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Family_No));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(OldFileNo));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(apply_oth_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block29Bytes, _wl_block29);

				}
				else 
				{
					String prompts=alt_id1_type+"~"+nat_id_prompt ;					
					
            _bw.write(_wl_block30Bytes, _wl_block30);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dflt_pat_ser_grp_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request.getParameter("Alt_Id_No")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getParameter("National_Id_No")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prompts));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Alt_Id_No));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Alt_Id2_No));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Alt_Id3_No));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Alt_Id4_No));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(National_Id_No));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(MRN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Area));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Family_No));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(OldFileNo));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(apply_oth_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Second_Name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(First_Name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Third_Name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Family_Name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block38Bytes, _wl_block38);
 
				} 
			}
			else
				out.println("<script>alert(getMessage('PAT_NUM_NOT_CREATED','MP'));</script>") ;
		}
		else
			out.println("<script>alert(getMessage('PAT_SER_NOT_CREATED','MP'));</script>") ;
}
catch(Exception e)
{
    out.println("Exception in main try"+e.getMessage());
	e.printStackTrace();
}
finally
{
//	if(conn!=null) ConnectionManager.returnConnection(conn,request);    
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
