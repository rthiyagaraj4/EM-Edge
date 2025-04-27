package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import javax.naming.*;
import javax.ejb.*;
import java.rmi.*;
import javax.rmi.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __viewbirthregisterresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ViewBirthRegisterResult.jsp", 1742452424004L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time :9/23/2005 11:34 AM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script>\n\tfunction callDummy(){}\n\tfunction openReg(obj)\n\t{\n\t\tparent.window.returnValue =obj;\n\t\tretval=parent.window.close();\n\t\treturn obj;\n\t}\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onKeyDown = \'lockKey()\'>\n\t<form name=\'birth_register_result\' id=\'birth_register_result\' >\n\t<P>\n\t<table align=\'right\' >\n\t<tr >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n</tr>\n</table>\n</P>\n\t<br><br>\n\n<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n\t\t\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t <tr>\n\t\t\t<th nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<th nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th><th nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </th><th nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </th>\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<script>self.location.href=\"javaScript:openReg(\\\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\\\")\"\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\n<a href=\"callDummy()\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a>\n</td>\n\n<td ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td>\n<td ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" nowrap>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t   ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" nowrap style=\'text-align=right\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;</td>\n</tr>\n\n\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<script >\n\tif (document.getElementById(\"next\"))\n\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<script >\n\tif (document.getElementById(\"next\"))\n\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t</script>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\"JavaScript\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\n\t</table>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\n\t\t\t<table border=\'1\' cellpadding=0 cellspacing=0 width=\'100%\'>\n\t\t\t\t<tr><td class=\"label\" colspan=\'6\'>&nbsp;</td></tr>\n\t\t\t\t<tr><td width = \'5%\' bordercolor=\'black\' style=\'background-color:#FECBFA\' >&nbsp;</td><td width = \'25%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</td><td width = \'5%\' bordercolor=\'black\' style=\'background-color:#00FFFF\'>&nbsp;</td><td width = \'25%\'> &nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td><td width=\'40%\'>&nbsp;</td></tr>\n\t\t\t</table>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t</form>\n\t</body>\n\t</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
 
	request.setCharacterEncoding("UTF-8");
	
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String locale =((String)session.getAttribute("LOCALE"));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	Connection conn = null; 
	ResultSet rs = null;
//	ResultSet rs1 = null;
	java.sql.Statement stmt=null;
	java.sql.Statement stmt1=null;
	// added by N Munisekhar on 13-Mar-2013 against ML-BRU-SCF-0749 [IN:038571] 
	PreparedStatement pstmt = null;
	String valid_patient_id="";
	StringBuffer whereClause= new StringBuffer("where");
	String whereClauseOld="";
	
	int TotalRecord = 0;
	String PID="";
	int start;
	int end;
	int tableSize=20;
	StringBuffer sql=new StringBuffer();;
//	String sql1 ="";
    String finalized_yn = "";
	String regnStatusStyle = "";
	String addlTableClause = "";
	String addlWhereClause = "";
	String addlTableClauseFath = "";
	String addlWhereClauseFath = "";
	int WhereClauseflag = 0;

	String from = request.getParameter("from");
	String view= request.getParameter("view");
	if(view == null) view ="";

	String to = request.getParameter("to");
    String PatientID= request.getParameter("Patient_Id");

    String MotherPatientID= request.getParameter("Mother_Patient_Id");
   // added code for PMG2014-HSA-CRF-0001 [IN:050020]	
	String AltId1No=request.getParameter("Alt_Id1_No");
	String AltId2No=request.getParameter("Alt_Id2_No");
	String AltId3No=request.getParameter("Alt_Id3_No");
	String AltId4No=request.getParameter("Alt_Id4_No");
	String other_alt_id=request.getParameter("other_alt_id");
	String other_alt_Id_no=request.getParameter("other_alt_Id_no");
	String nat_id_prompt=request.getParameter("nat_id_prompt");
	

	String Dob= request.getParameter("Dob");
	if(Dob != null)
	{
		if(locale.equals("th"))
		Dob=DateUtils.convertDate(Dob,"DMY","th","en");
	}
	else
	Dob="";
	String AltID1Order= request.getParameter("Alt_Id1_Order");
	String Sex= request.getParameter("Sex");
	//String altIDType= request.getParameter("altIDType");
	//added code for PMG2014-HSA-CRF-0001 [IN:050020]
	String alt_id1_type_deschd= request.getParameter("alt_id1_type_deschd");
	String alt_id2_type_deschd= request.getParameter("alt_id2_type_deschd");
	String alt_id3_type_deschd= request.getParameter("alt_id3_type_deschd");
	String alt_id4_type_deschd= request.getParameter("alt_id4_type_deschd");
	String nat_id_prompt_des= request.getParameter("nat_id_prompt_des");
	
	String DobTo= request.getParameter("DobTo");
	if(DobTo != null)
	{
		if(locale.equals("th"))
		DobTo=DateUtils.convertDate(DobTo,"DMY","th","en");
	}
	else
	DobTo="";
	//Added for Maintain birth Register and verification on 27/8/2002 by kumar
	String function_id = request.getParameter("function_id");
	if (function_id==null) function_id = "";
	// End of addition
	//Added for Names Search on 22/11/2002 by kumar
	String first_name = request.getParameter("first_name");	
	String second_name = request.getParameter("second_name");
	String third_name = request.getParameter("third_name");
	String family_name = request.getParameter("family_name");
	String fourth_name = request.getParameter("fourth_name");
	String fifth_name = request.getParameter("fifth_name");
	if (first_name==null) first_name="";
	if (second_name==null) second_name="";
	if (third_name==null) third_name="";
	if (family_name==null) family_name="";
	if (fourth_name==null) fourth_name="";
	if (fifth_name==null) fifth_name="";

	//Added by kumar on 17/03/2003 for Malaysia Enhancements
	String pat_name_as_multipart_yn = request.getParameter("pat_name_as_multipart_yn");
	if (pat_name_as_multipart_yn==null) pat_name_as_multipart_yn = "";
	String searchby = request.getParameter("searchby");		
	if (searchby==null) searchby = "";
	//End of Addition
	

	String soundex = request.getParameter("soundex");
	if (soundex==null) soundex="";

	String apply_oth_name = request.getParameter("apply_oth_name");
	if (apply_oth_name==null) apply_oth_name="N";
	String names_search_by = request.getParameter("names_search_by");
	if (names_search_by==null) names_search_by = "";


	////////////////////////////
	boolean fath_flag=false;
	if(names_search_by.equals("F"))
	{
		fath_flag=true;
		soundex="";
	}
	////////////////////////////


	InputStreamReader reader;
	String regn_type1 = request.getParameter("regn_type1");
	if (regn_type1==null) regn_type1="";
	String regn_type2 = request.getParameter("regn_type2");
	if (regn_type2==null) regn_type2="";
	
	reader = new InputStreamReader( new ByteArrayInputStream( regn_type1.getBytes()), "UTF-8" ) ;
	regn_type1 = (new BufferedReader(reader)).readLine() ;
	if (regn_type1==null) regn_type1 = "";
	reader = new InputStreamReader( new ByteArrayInputStream( regn_type2.getBytes()), "UTF-8" ) ;
	regn_type2 = (new BufferedReader(reader)).readLine() ;
	if (regn_type2==null) regn_type2 = "";

	/*if (apply_oth_name.equals("Y"))
	{
		reader = new InputStreamReader( new ByteArrayInputStream( first_name.getBytes()), "UTF-8" ) ;
		first_name = (new BufferedReader(reader)).readLine() ;
		if (first_name==null) first_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( second_name.getBytes()), "UTF-8" ) ;
		second_name = (new BufferedReader(reader)).readLine() ;
		if (second_name==null) second_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( third_name.getBytes()), "UTF-8" ) ;
		third_name = (new BufferedReader(reader)).readLine() ;
		if (third_name==null) third_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( family_name.getBytes()), "UTF-8" ) ;
		family_name = (new BufferedReader(reader)).readLine() ;
		if (family_name==null) family_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( fourth_name.getBytes()), "UTF-8" ) ;
		fourth_name = (new BufferedReader(reader)).readLine() ;
		if (fourth_name==null) fourth_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( fifth_name.getBytes()), "UTF-8" ) ;
		fifth_name = (new BufferedReader(reader)).readLine() ;
		if (fifth_name==null) fifth_name = "";
	}*/
	// End of addition
	//out.println("<script>alert('"+request.getParameter("first_name")+"');</script>");
	//out.println("<script>alert('apply_oth_name:"+apply_oth_name+"');</script>");
                
	whereClauseOld = request.getParameter("whereClauseOld");
	
    int strand =0; 


	if((PatientID != null) && !(PatientID.equals("")))
	{
		whereClause.append(" a.Patient_id like trim('");
		whereClause.append(PatientID);
		whereClause.append("%')");
		strand++;
	}

	if((MotherPatientID != null)  && !(MotherPatientID.equals("")))
	{
		if(strand > 0){
			whereClause.append(" And ");
		
		}
		strand++;
		whereClause.append(" A.Mother_Patient_id like trim('");
		whereClause.append(MotherPatientID);
		whereClause.append("%')");

	}

	if((AltId1No != null) && (!(AltId1No.equals("undefined"))) && (!(AltId1No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id1_no like trim('" );
		whereClause.append(AltId1No);
		whereClause.append("%') ");
	}
	//added code for PMG2014-HSA-CRF-0001 [IN:050020]
	if((AltId2No != null) && (!(AltId2No.equals("undefined"))) && (!(AltId2No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id2_no like trim('" );
		whereClause.append(AltId2No);
		whereClause.append("%') ");
	}
	if((AltId3No != null) && (!(AltId3No.equals("undefined"))) && (!(AltId3No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id3_no like trim('" );
		whereClause.append(AltId3No);
		whereClause.append("%') ");
	}
	if((AltId4No != null) && (!(AltId4No.equals("undefined"))) && (!(AltId4No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id4_no like trim('" );
		whereClause.append(AltId4No);
		whereClause.append("%') ");
	}
	if((other_alt_id != null) && (!(other_alt_id.equals("undefined"))) && (!(other_alt_id.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.oth_alt_id_type like trim('" );
		whereClause.append(other_alt_id);
		whereClause.append("%') ");
	}
	
	if((other_alt_Id_no != null) && (!(other_alt_Id_no.equals("undefined"))) && (!(other_alt_Id_no.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append("  b.oth_alt_Id_no like trim('" );
		whereClause.append(other_alt_Id_no);
		whereClause.append("%') ");
	}
	
	
	if((nat_id_prompt != null) && (!(nat_id_prompt.equals("undefined")))  && (!(nat_id_prompt.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.NATIONAL_ID_NO like trim('" );
		whereClause.append(nat_id_prompt);
		whereClause.append("%') ");
	}

	if ((AltID1Order != null)  && (!(AltID1Order.equals(""))))
	{
		if(strand > 0){
			whereClause.append(" And ");
	
		}
		strand++;
		whereClause.append(" birth_order = '");
		whereClause.append(AltID1Order);
		whereClause.append("'");
	}

	if ((Dob != null) && (!(Dob.equals(""))) && ((DobTo == null) || (DobTo.equals(""))))
	{
		if(strand > 0){
			whereClause.append(" And ");

		}
		strand++;
		whereClause.append(" to_date(to_char(time_of_birth,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('");
		whereClause.append(Dob);
		whereClause.append("','dd/mm/yyyy')");
	}

	if ((Dob != null) && (!(Dob.equals(""))) && (DobTo != null) && !(DobTo.equals("")))
	{
		if(strand > 0){
			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" to_date(to_char(time_of_birth,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('");
		whereClause.append(Dob);
		whereClause.append("','dd/mm/yyyy') and ");
		whereClause.append(" to_date('");
		whereClause.append(DobTo);
		whereClause.append("','dd/mm/yyyy')");

	}

	if ((Sex != null)  && (!(Sex.equals(""))))
	{
		if(strand > 0){
			whereClause.append(" And ");

		}
		strand++;
		whereClause.append(" a.NB_Sex like trim('");
		whereClause.append(Sex);
		whereClause.append("')");
	}
	
	
	StringBuffer namesWhereClause = new StringBuffer();
	
	String aliasName ="";
	
	if (names_search_by.equals("B")) aliasName = "b.";
	else if (names_search_by.equals("M")) aliasName = "moth.";
	else if (names_search_by.equals("F")) aliasName = "fath.";
	String andClause = " And ";
	if (function_id.equals("")|| function_id.equals("MP_VIEW_BIRTH_REG"))
	{
		if (apply_oth_name.equals("N"))
		{
			if (soundex.equals("E"))
			{
				if (!first_name.equals("") && !family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("ethnic_sndx_first_family=ethnic_soundex('");
					namesWhereClause.append(first_name);
					namesWhereClause.append(family_name);
					namesWhereClause.append("')");
				}
				if (!first_name.equals("") && !second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("ethnic_sndx_first_second=ethnic_soundex('");
					namesWhereClause.append(first_name);
					namesWhereClause.append(second_name);
					namesWhereClause.append("')");

				}
				if (!first_name.equals(""))
				{
					if (family_name.equals("") && second_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("ethnic_sndx_first =ethnic_soundex('");
						namesWhereClause.append(first_name);
						namesWhereClause.append("')");

					}
				}
				if (!second_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("ethnic_sndx_second =ethnic_soundex('");
						namesWhereClause.append(second_name);
						namesWhereClause.append("')");

					}
				}
				if (!third_name.equals(""))
				{
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("ethnic_sndx_third =ethnic_soundex('");
					namesWhereClause.append(third_name );
					namesWhereClause.append("')");

				}
				if (!family_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);		
						namesWhereClause.append("ethnic_sndx_second =ethnic_soundex('");
						namesWhereClause.append(family_name);
						namesWhereClause.append("')");

					}
				}
			}
			else if (soundex.equals("G"))
			{
				if (!first_name.equals("") && !family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("generic_sndx_first_family=soundex('");
					namesWhereClause.append(first_name );
					namesWhereClause.append(family_name);
					namesWhereClause.append("')");

				}
				if (!first_name.equals("") && !second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("generic_sndx_first_second=soundex('");
					namesWhereClause.append(first_name);
					namesWhereClause.append(second_name);
					namesWhereClause.append("')");

				}
				if (!first_name.equals(""))
				{
					if (family_name.equals("") && second_name.equals("")){			
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("generic_sndx_first =soundex('");
						namesWhereClause.append(first_name );
						namesWhereClause.append("')");

					}
				}
				if (!second_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("generic_sndx_second =soundex('");
						namesWhereClause.append(second_name);
						namesWhereClause.append("')");

					}
				}
				if (!third_name.equals(""))
				{
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("generic_sndx_third =soundex('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("')");

				}
				if (!family_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("generic_sndx_second =soundex('");
						namesWhereClause.append(family_name);
						namesWhereClause.append("')");

					}
				}
			}
			else
			{
				if (pat_name_as_multipart_yn.equals("N"))
				{
					if (!family_name.equals(""))
					{						
						if(!fath_flag)
						{
							if (searchby.equals("C")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("family_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");

							}
							else if (searchby.equals("E")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("family_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("') ");

							}else{
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("family_name) like upper('");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");
				
							}
							
						}
						else
						{
							String tempaliasName=aliasName;
							aliasName="a.";
							if (searchby.equals("C")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("father_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");

							}else if (searchby.equals("E")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("father_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("') ");

							}else{
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("father_name) like upper('");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");
							
							}
							aliasName=tempaliasName;
						}
					}				
				}
				else
				{
					if (!first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("first_name) like upper('");
						namesWhereClause.append(first_name);
						namesWhereClause.append("%') ");

					}
					if (!second_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("second_name) like upper('");
						namesWhereClause.append(second_name);
						namesWhereClause.append("%') ");

					}
					if (!third_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("third_name) like upper('");
						namesWhereClause.append(third_name);
						namesWhereClause.append("%') ");

					}
					if (!family_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("family_name) like upper('");
						namesWhereClause.append(family_name);
						namesWhereClause.append("%') ");

					}
				}
			}
		}
		else
		{
			if (!first_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("first_name_loc_lang like '");
				namesWhereClause.append(first_name);
				namesWhereClause.append("%' ");
			}
			if (!second_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("second_name_loc_lang like '");
				namesWhereClause.append(second_name);
				namesWhereClause.append("%' ");

			}
			if (!third_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("third_name_loc_lang like '");
				namesWhereClause.append(third_name);
				namesWhereClause.append("%' ");

			}
			if (!family_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("family_name_loc_lang like '");
				namesWhereClause.append(family_name);
				namesWhereClause.append("%' ");

			}
		}
	}
	else
	{
		if (apply_oth_name.equals("N"))
		{
			if (names_search_by.equals("B"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("first_name) like upper('");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%') ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("second_name) like upper('");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%') ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("third_name) like upper('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%') ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("family_name) like upper('");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%') ");

				}
				if (!fourth_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("fourth_name) like upper('");
					namesWhereClause.append(fourth_name);
					namesWhereClause.append("%') ");

				}
				if (!fifth_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("fifth_name) like upper('");
					namesWhereClause.append(fifth_name);
					namesWhereClause.append("%') ");

				}
			}
			else if (names_search_by.equals("M"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_first_name) like upper('");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%') ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_second_name) like upper('");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%') ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_third_name) like upper('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%') ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_family_name) like upper('");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%') ");
				}
			
			}
			else if (names_search_by.equals("F"))
			{	
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_first_name) like upper('");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%') ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_second_name) like upper('");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%') ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_third_name) like upper('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%') ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_family_name) like upper('");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%') ");

				}
			
			}
		}
		else
		{
			if (names_search_by.equals("B"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("first_name_loc_lang like '");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%' ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("second_name_loc_lang like '");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%' ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("third_name_loc_lang like '");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%' ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("family_name_loc_lang like '");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%' ");

				}
				
			}
			else if (names_search_by.equals("M"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_first_name_loc_lang like '");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%' ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_second_name_loc_lang like '");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%' ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_third_name_loc_lang like '");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%' ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_family_name_loc_lang like '");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%' ");

				}
			
			}
			else if (names_search_by.equals("F"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_first_name_loc_lang like '");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%' ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_second_name_loc_lang like '");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%' ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_third_name_loc_lang like '");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%' ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_family_name_loc_lang like '");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%' ");

				}
			
			}
		}
	}


	try
	{
		
		if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from ) ;

		if ( to == null )
	  	end = tableSize ;
		else
		end = Integer.parseInt( to ) ;

		if (whereClause.toString().equals("where") && !namesWhereClause.toString().equals("") && whereClauseOld==null){
		//if (!namesWhereClause.toString().equals("") && whereClauseOld==null){
			whereClause.setLength(0);
			whereClause.append("where ");
			whereClause.append(namesWhereClause.substring(4));
			WhereClauseflag=1;

		}
		if (whereClauseOld != null){
			whereClause.setLength(0);
			whereClause.append(whereClauseOld);

		}

		if (!whereClause.toString().equals("where"))
		{			
			if (function_id.equals("")|| function_id.equals("MP_VIEW_BIRTH_REG"))
			{
				addlTableClause = request.getParameter("addlTableClause");
				if (addlTableClause==null) addlTableClause ="";
				addlWhereClause = request.getParameter("addlWhereClause");
				if (addlWhereClause==null) addlWhereClause ="";
				addlTableClauseFath = request.getParameter("addlTableClauseFath");
				if (addlTableClauseFath==null) addlTableClauseFath ="";
				addlWhereClauseFath = request.getParameter("addlWhereClauseFath");
				if (addlWhereClauseFath==null) addlWhereClauseFath ="";

				if (!first_name.equals("") || !second_name.equals("") || !third_name.equals("") || !family_name.equals(""))
				{
					if (names_search_by.equals("M"))
					{
						addlTableClause = ", mp_patient moth";
						addlWhereClause = " and moth.patient_id = a.mother_patient_id ";
				
					}
					else if (names_search_by.equals("F"))
					{
						
							addlTableClause = ", mp_patient fath ";	
							addlWhereClause = " and fath.patient_id = a.patient_id ";
							addlTableClauseFath = ", mp_patient fath ";	
							addlWhereClauseFath = " and fath.patient_id = a.father_patient_id ";
						
					}
				}
				// newly added still need to be checked..
				if(WhereClauseflag != 1)
			whereClause.append(namesWhereClause.toString());


			//sql1="select count(1) from mp_patient b"+addlTableClause+", mp_birth_register a "+whereClause+" and b.patient_id = a.patient_id "+addlWhereClause+" and b.patient_id like '%%'";
			} 			
		}
	/*	else
		{
			//if (function_id.equals(""))
			//	sql1="select count(1) from mp_birth_register a where a.patient_id like '%%'";
		}*/
		
		conn	= ConnectionManager.getConnection(request);
		stmt1	= conn.createStatement();	
		//rs1		= stmt1.executeQuery(sql1);

		/*if(rs1.next())
		{
			TotalRecord = rs1.getInt(1);
			
		}*/
		//if (TotalRecord > 0)
	//	{
	
			stmt = conn.createStatement();
			
			if(!(whereClause.toString().equals("where")))
			{
				if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG"))
				{
					sql.append(" select a.patient_id, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) nb_patient_name, nb_sex, to_char(time_of_birth, 'dd/mm/yyyy hh24:mi') nb_birth_date,a.mother_patient_id, decode('"+localeName+"', 'en', moth.patient_name, nvl(moth.patient_name_loc_lang, moth.patient_name))  mother_patient_name, b.alt_id1_no alt_id1_no, birth_order newborn_id_no_suffix,a.finalized_yn from mp_patient b, mp_patient moth");
					sql.append(addlTableClauseFath);
					sql.append(", mp_birth_register a " );
					sql.append(whereClause.toString());
					sql.append(" and b.patient_id = a.patient_id and moth.patient_id = a.mother_patient_id ");
					sql.append(addlWhereClauseFath);
					sql.append("and b.patient_id like '%%' and moth.patient_id like '%%' order by a.patient_id");
				}
			}
			else
			{
				if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG"))
				{
					sql.setLength(0);
					sql.append(" select a.patient_id, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) nb_patient_name, nb_sex, to_char(time_of_birth, 'dd/mm/yyyy hh24:mi') nb_birth_date, a.mother_patient_id,decode('"+localeName+"', 'en', moth.patient_name, nvl(moth.patient_name_loc_lang, moth.patient_name)) mother_patient_name, b.alt_id1_no alt_id1_no, birth_order newborn_id_no_suffix,a.finalized_yn from mp_patient b, mp_patient moth, mp_birth_register a where b.patient_id = a.patient_id and moth.patient_id = a.mother_patient_id and b.patient_id like '%%' and moth.patient_id like '%%' order by a.patient_id");
				}
			}	
			//out.println("<script>alert(\""+sql.toString()+"\");</script>");
			
			rs=stmt.executeQuery(sql.toString());
	/*	}
		else
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		}*/
		out.println("<script>");
		out.println("for (var i=0;i<parent.frames[1].document.forms[0].elements.length;i++) {				parent.frames[1].document.forms[0].elements[i].disabled=false;}");
		out.println("parent.frames[2].document.forms[0].Search.disabled = false;");
		out.println("if (parent.frames[1].document.forms[0].searchby) {");
		out.println("if (parent.frames[1].document.forms[0].soundex_val.value != '')");
		out.println("	parent.frames[1].document.forms[0].searchby.disabled=true; }");
		out.println("if (parent.frames[1].document.forms[0].accept_oth_alt_id_yn.value == 'Y'){");
		out.println("if (parent.frames[1].document.forms[0].other_alt_id.value == '')");
		out.println("parent.frames[1].document.forms[0].other_alt_Id_no.disabled=true; }");
		out.println("parent.frames[1].setFields();");
		out.println("</script>");
		if (!function_id.equals("") && !function_id.equals("MP_VIEW_BIRTH_REG")) 
			out.println("<script>parent.frames[1].document.forms[0].soundex_val.disabled=true;</script>");
		out.println("<script>parent.frames[0].location.href='../../eMP/jsp/BirthRegisterToolBar.jsp'</script>");
		int i=0;

            _bw.write(_wl_block8Bytes, _wl_block8);

//if (TotalRecord > 0)
//{		
		if (start > 1)
		{
			out.println("<td colspan='6'align='right' id='prev'> <A HREF='../../eMP/jsp/ViewBirthRegisterResult.jsp?from="+(start-tableSize)+"&to="+(end-tableSize)+"&whereClauseOld="+URLEncoder.encode(whereClause.toString())+ "&addlTableClause="+URLEncoder.encode(addlTableClause)+"&addlWhereClause="+URLEncoder.encode(addlWhereClause)+"&addlTableClauseFath="+URLEncoder.encode(addlTableClauseFath)+"&addlWhereClauseFath="+URLEncoder.encode(addlWhereClauseFath)+"&alt_id1_type_deschd="+URLEncoder.encode(alt_id1_type_deschd)+"&function_id="+function_id+"'"
			+ " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			
		}
				
		//if ( !( (start+tableSize) > TotalRecord ) )
		{

			out.println("<td colspan='6'align='right' id='next' style='visibility:hidden'><A HREF='../../eMP/jsp/ViewBirthRegisterResult.jsp?from="+(start+tableSize)+"&to="+(end+tableSize)+"&whereClauseOld="+URLEncoder.encode(whereClause.toString())+ "&addlTableClause="+URLEncoder.encode(addlTableClause)+"&addlWhereClause="+URLEncoder.encode(addlWhereClause)+"&addlTableClauseFath="+URLEncoder.encode(addlTableClauseFath)+"&addlWhereClauseFath="+URLEncoder.encode(addlWhereClauseFath)+"&alt_id1_type_deschd="+URLEncoder.encode(alt_id1_type_deschd)+"&function_id="+function_id+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		}
	

            _bw.write(_wl_block9Bytes, _wl_block9);
	
	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	int cnt = 0;
	 while(rs.next() && i < end) 
     {
		 if(cnt==0)
		 {
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 //naren 
			if (!function_id.equals("") && !function_id.equals("BIRTH_NOTIFICATION") && !function_id.equals("BIRTH_REGISTRATION") && !function_id.equals("MP_VIEW_BIRTH_REG")) {
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(alt_id1_type_deschd));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 }
			cnt++;
			i++;
            finalized_yn = rs.getString("finalized_yn");
            if(finalized_yn.equals("Y")) {
					regnStatusStyle = "style='background-color:#00FFFF'";
			} else if(finalized_yn.equals("N")) {					
					regnStatusStyle = "style='background-color:#FECBFA'";
			} 		
           
			PID= rs.getString(1);
						
			String Regnno = "";
			String RegnType = "";
			//naren
			// function_id.equals("MP_VIEW_BIRTH_REG") condition added by Muthu against incident 17285 on 15/12/2009
			if (!function_id.equals("") && !function_id.equals("BIRTH_NOTIFICATION") && !function_id.equals("BIRTH_REGISTRATION") && !function_id.equals("MP_VIEW_BIRTH_REG")) 
			{
				Regnno = rs.getString("nb_medical_regn_no");
				RegnType = rs.getString("nb_medical_regn_type");				
				if(RegnType == null) RegnType="";
				if (RegnType.equals("01")) RegnType = regn_type1;
				if (RegnType.equals("02")) RegnType = regn_type2;
			}
			String PName = rs.getString("nb_patient_name");
			String SexDb=rs.getString(3);
			String dobDb=rs.getString(4);
			String MID=rs.getString(5);
			String MName=rs.getString(6);
			String qid=rs.getString(7);
			String suffix=rs.getString(8);
			
			if(Regnno == null)
				Regnno="";			
			if(PID == null)
				PID="";
			if(PName == null)
			    PName ="";
			if(SexDb == null)
				SexDb="";
			if(dobDb != null)
			{
				dobDb=DateUtils.convertDate(dobDb,"DMYHM","en",locale);
			}
			else
				dobDb="";
			if(MID == null)
				MID="";
			if(MName == null)
				MName="";
			if(qid == null)
				qid="";
			if(suffix == null)
				suffix="";
		
				
			
			if(TotalRecord == 1)
			{
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(URLEncoder.encode(PID)));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
		

 out.println("<td "+regnStatusStyle+" onClick=openReg(\""+URLEncoder.encode(PID)+"\") nowrap>");
 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(PID ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(PName));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(SexDb.equals("M"))
			{
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
}else if(SexDb.equals("F")){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
}else if(SexDb.equals("U")){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dobDb));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(MID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(MName));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(qid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(suffix));
            _bw.write(_wl_block29Bytes, _wl_block29);

       
     }
//} 

if (cnt==0)
{
// added by N Munisekhar on 13-Mar-2013 against ML-BRU-SCF-0749 [IN:038571] 	
	pstmt = conn.prepareStatement("select valid_patient_id from dr_mp_patient where duplicate_patient_id = ?");
	pstmt.setString(1,PatientID);
	rs=pstmt.executeQuery();
	if (rs!=null && rs.next())
		valid_patient_id = rs.getString("valid_patient_id");
		if (valid_patient_id==null) valid_patient_id = "";
	if (!valid_patient_id.equals("")){
	out.println("<script> var msg = parent.criteria.getMessage('PAT_MERGED_VALID','MP');msg= msg.replace('#','"+valid_patient_id+"');alert(msg);</script>");out.println("<script>parent.criteria.document.forms[0].Patient_Id.value='"+valid_patient_id+"';parent.frames[2].document.forms[0].Search.disabled =false ;parent.frames[2].document.forms[0].Search.focus(); </script>");
	}
	if (valid_patient_id.equals("")){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}
}
//End of ML-BRU-SCF-0749 [IN:038571] 
boolean flag = false;
if ( cnt < 14 || (!rs.next()) ) {

            _bw.write(_wl_block30Bytes, _wl_block30);
 flag = true;
		} else {
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if (cnt!=0)
	{
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);

	if(function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG")){
		if(cnt==1){
			out.println("<script>openReg('"+PID+"')</script>");
		}
	} 


 
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(pstmt != null) pstmt.close();
	if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
			out.println(e.toString());
	}
	finally
	{
		
		sql.setLength(0);
		whereClause.setLength(0);
		namesWhereClause.setLength(0);
		if(conn!=null) ConnectionManager.returnConnection(conn,request);                
	}            

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegnType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.registrationno.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.motherpatientid.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MotherPatientName.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthOrder.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FirstStageRegistrationRecords.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FinalizedRecords.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }
}
