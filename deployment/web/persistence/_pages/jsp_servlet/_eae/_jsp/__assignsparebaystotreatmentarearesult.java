package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __assignsparebaystotreatmentarearesult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AssignSpareBaysToTreatmentAreaResult.jsp", 1709113871959L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AssignSpareBaysToTreatmentArea.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\'result_form\' id=\'result_form\' action=\"AssignSpareBaysToTreatmentAreaResult.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\')); </script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<P>\n<table  width=\'90%\' align=\'center\' >\t\n\t<tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t   <td class=\'white\' width=\'95%\'>&nbsp;</td>\n    \t\t<td  align=\'right\' nowrap>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td class=\'white\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<a HREF=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =", ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =");\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =");\'  text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t</tr>\n</table>\n\n<table cellpadding=0 cellspacing=0 border=1 width=\'90%\' align=\'center\'>\n\t<th nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t<th nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t\t    <tr>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" nowrap align=center>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" nowrap align=center>\n\t\t\t\t\t\t<input type=checkbox  onclick=\"chkValue(this,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\"  name=flag";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="></td>\n\t\t\t\t\t\t<input type=hidden name=h";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">\n\t\t\t    </tr>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</table>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</div>\n<input type=hidden name=\'count\' id=\'count\' value=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n<!-- <input type=\'hidden\' name=bay_no value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="> -->\n<input type=\'hidden\' name=treatment_area_code value=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">\n<input type=\'hidden\' name=clinic_code value=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n<input type=\'hidden\' name=\'status\' id=\'status\' value=\'null\'>\n<input type=\'hidden\' name=\'n\' id=\'n\' value=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n<input type=\'hidden\' name=\'fnname\' id=\'fnname\' value=\"Insert\">\n<input type=\'hidden\' name=\'insert_table\' id=\'insert_table\' value=\'Y\'>\n<input type=\'hidden\' name=\'valid_values\' id=\'valid_values\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'temp\' id=\'temp\'>\n<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\'hidden\' name=\'bay_mode\' id=\'bay_mode\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

	
	public static String checkForNull(String inputString) 	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue) 	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con					=	null;
	PreparedStatement pstmt			=	null;
	PreparedStatement pstmt1		=	null;
	ResultSet rset					=	null ;
	ResultSet rset1					=	null ;
	String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	String valid_values="";
	int n=0;
	String from = request.getParameter( "from" ) ;
	valid_values		=	request.getParameter("valid_values")==null?"":request.getParameter("valid_values");
	String to = request.getParameter( "to" ) ;
	StringTokenizer strToken		= null;
	int strCount					= 0;
	String check_attribute				=	"";
	String check_value	= "";
	String class_value				= "QRYEVEN";
	String bay_no					=	"";
	String bay_type="";
	String bay_type_desc="";
	String spare_bays_yn = "";
	int maxRecord=0;
	String clinic_code	= "";
	String treatment_area_code = "";
	String bay_mode="";
	String countBuffer = "";
	String sql="";
	String bayvalue="";
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;


            _bw.write(_wl_block2Bytes, _wl_block2);
 try {
	con						=	ConnectionManager.getConnection(request);
	clinic_code				=	checkForNull(request.getParameter("clinic_code"));
	
	treatment_area_code		=	checkForNull(request.getParameter("treatment_area_code"));
	
    bay_mode =  checkForNull(request.getParameter("bay_mode"));
	
	if(bay_mode == null) bay_mode = "A";

	if(bay_mode.equals("P")) {
		//countBuffer	= "Select count(*) as count_value from AE_SPARE_BAYS where facility_id = ? and clinic_code = ? and current_status = 'A' and eff_Status ='E'";  
		countBuffer	= "Select count(*) as count_value from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and  a.spare_bay_yn = 'N' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
	} else if(bay_mode.equals("S")) {
		countBuffer	= "Select count(*) as count_value  from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and a.spare_bay_yn = 'Y' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
	} 	else 	{
		countBuffer	= "Select count(*) as count_value from ae_spare_bays a,ae_bay_type b where  a.facility_id=? and a.clinic_code=? and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where  clinic_code=? and bed_no = a.bay_no and facility_id=?)";
	}
	int count_value=0;
	pstmt	=	con.prepareStatement(countBuffer);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,clinic_code);
	pstmt.setString(3,clinic_code);
//	pstmt1.setString(4,treatment_area_code);
	pstmt.setString(4,facilityId);



	rset = pstmt.executeQuery();

  	if ((rset != null) && (rset.next())) 	{
		count_value= rset.getInt("count_value");
		maxRecord=count_value;
	}
 	if (count_value==0) {

            _bw.write(_wl_block8Bytes, _wl_block8);

		return;
	} else {
		if(bay_mode.equals("P")) {
			//countBuffer	= "Select count(*) as count_value from AE_SPARE_BAYS where facility_id = ? and clinic_code = ? and current_status = 'A' and eff_Status ='E'";  
			sql	= "Select a.bay_no bay_no,a.bay_type_code bay_type,b.short_desc bay_type_desc,a.spare_bay_yn spare_bay_yn from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and  a.spare_bay_yn ='N' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
		} else if(bay_mode.equals("S")) 	{
			sql	= "Select a.bay_no bay_no,a.bay_type_code bay_type,b.short_desc bay_type_desc,a.spare_bay_yn spare_bay_yn from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and a.spare_bay_yn = 'Y' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
		} 	else 	{
			sql	= "Select a.bay_no bay_no,a.bay_type_code bay_type,b.short_desc bay_type_desc,a.spare_bay_yn spare_bay_yn from ae_spare_bays a,ae_bay_type b where  a.facility_id=? and a.clinic_code=? and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
		}
		
		//String sql		=	" Select bay_no from AE_SPARE_BAYS where facility_id = ? and clinic_code = ? and current_status = 'A' and eff_Status ='E' ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,clinic_code);
		pstmt.setString(3,clinic_code);
	//	pstmt.setString(4,treatment_area_code);
		pstmt.setString(4,facilityId);
	
		rset = pstmt.executeQuery();

            _bw.write(_wl_block9Bytes, _wl_block9);

		if (!(start <= 1) || !( (start+10) > maxRecord ))
		{

            _bw.write(_wl_block10Bytes, _wl_block10);
	}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block2Bytes, _wl_block2);

		if ( !(start <= 1) ) {

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start-10));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end-10));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		if ( !( (start+10) > maxRecord ) ) 	{

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start+10));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end+10));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		}

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	if (rset != null) 	{
		if( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				rset.next() ;
			}
			while(rset.next() && i<=end) {
				bay_no	= checkForNull(rset.getString("bay_no"));
				bay_type=checkForNull(rset.getString("bay_type"));
				bay_type_desc= checkForNull(rset.getString("bay_type_desc"));
				spare_bays_yn= checkForNull(rset.getString("spare_bay_yn"));
				bayvalue=bay_no+"$"+bay_type+"$"+spare_bays_yn;
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
			 		class_value = "QRYEVEN";
			    if ((!valid_values.equals("")) && (!valid_values.equals(",")))   {	
					check_attribute = "";
			        strToken	=  new StringTokenizer(valid_values, ",");
                    strCount = strToken.countTokens();
					for (int s=0; s< strCount; s++) {
						check_value		=	checkForNull(strToken.nextToken());
					    if (check_value.equals(bayvalue))
							check_attribute = "Checked";
					}
				}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bay_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bay_type_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(spare_bays_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bayvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(n));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bay_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(check_attribute));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(n));
            _bw.write(_wl_block28Bytes, _wl_block28);

				i++;
				n++;
			}
	}

            _bw.write(_wl_block29Bytes, _wl_block29);

	}
   } catch (Exception e){
		e.printStackTrace();
   } finally {
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		if(pstmt1!=null) pstmt1.close();
		if(rset1!=null) rset1.close();
		ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bay_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(n));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(valid_values));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(from));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(to));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bay_mode));
            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayType.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PseudoBedBays.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
