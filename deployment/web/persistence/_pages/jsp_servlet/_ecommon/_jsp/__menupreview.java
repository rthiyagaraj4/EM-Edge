package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __menupreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/menuPreview.jsp", 1709116474244L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n/*\narMenu1 = new Array(\n150,\n\"\",\"\",\n\"\",\"\",\n\"\",\"\",\n\"\",\"\",\n\"\",\"\",0,\n\"\",\"\",0,\n\"\",\"\",0,\n\"\",\"\",0,\n\"\",\"\",0\n)\n\narMenu2 = new Array(\n150,\n\"\",\"\",\n\"\",\"\",\n\"\",\"\",\n\"\",\"\",\n\"\",\"\",0,\n\"\",\"\",0,\n\"\",\"\",0,\n\"\",\"\",0,\n\"\",\"\",0\n)\n\narMenu3 = new Array(\n\"175\",\n\"0\",\"0\",\n\"\",\"white\",\n\"\",\"orange\",\n\"ivory\",\"red\",\n\"System Admin\",\"#samepage\",1,\n\"Master Codes \",\"#samepage\",1,\n\"MP Admin Setup\",\"#samepage\",1,\n\"Registration\",\"#samepage\",1,\n\"Print Rounting\",\"#samepage\",1,\n\"OP Masters\",\"#samepage\",1,\n\"Master Lists Report\",\"../../Ush/new2.jsp\",0,\n\"Change Responsibility\",\"../../sm/jsp/change_responsibility.jsp\",0,\n\"Change Password\",\"../../sm/jsp/change_password.jsp\",0\n)\n\narMenu3_1 = new Array(\n\"Site Parameter\",\"../../servlet/SiteParameterServlet\",1,\n\"Facilities Parameter\",\"../../sm/jsp/facility_param.jsp?function_name=Facility&module_id=SM\",0,\n\"Master Codes\",\"../../servlet/MasterCodeServlet\",0,\n\"Master Unit for Grouped Codes\",\"../html/Home.html\",0,\n\"Responsibility Group\",\"../../servlet/ResponsibilityGroupServlet\",0,\n\"Responsibility\",\"../../servlet/ResponsibilityServlet\",0,\n\"User\",\"../../sm/jsp/setup_user.jsp\",0\n)\n\narMenu3_1_1 = new Array(\n\"Site Parameter\",\"../../servlet/SiteParameterServlet\",1,\n\"Facilities Parameter\",\"../../sm/jsp/facility_param.jsp?function_name=Facility&module_id=SM\",0,\n\"Master Codes\",\"../../servlet/MasterCodeServlet\",0,\n\"Master Unit for Grouped Codes\",\"../html/Home.html\",0,\n\"Responsibility Group\",\"../../servlet/ResponsibilityGroupServlet\",0,\n\"Responsibility\",\"../../servlet/ResponsibilityServlet\",0,\n\"User\",\"../../sm/jsp/setup_user.jsp\",0\n)\n\narMenu3_1_1_1 = new Array(\n\"Site Parameter\",\"../../servlet/SiteParameterServlet\",0,\n\"Facilities Parameter\",\"../../sm/jsp/facility_param.jsp?function_name=Facility&module_id=SM\",0,\n\"Master Codes\",\"../../servlet/MasterCodeServlet\",0,\n\"Master Unit for Grouped Codes\",\"../html/Home.html\",0,\n\"Responsibility Group\",\"../../servlet/ResponsibilityGroupServlet\",0,\n\"Responsibility\",\"../../servlet/ResponsibilityServlet\",0,\n\"User\",\"../../sm/jsp/setup_user.jsp\",0\n)\n\n\narMenu3_2 = new Array(\n\"Marital Status\",\"../../servlet/MaritalStatusServlet\",0,\n\"Religion\",\"../../servlet/ReligionServlet\",0,\n\"Occupation Class\",\"../../servlet/OccupationClassServlet\",0,\n\"Occupation\",\"../../servlet/OccupationServlet\",0,\n\"Country\",\"../../servlet/CountryServlet\",0,\n\"Regions\",\"../../servlet/RegionServlet\",0,\n\"Areas\",\"../../eMP/html/addResidenceArea.html\",0,\n\"Towns\",\"../../eMP/html/addResidenceTown.html\",0,\n\"Postal Codes\",\"../../servlet/PostalServlet\",0,\n\"Name Prefix\",\"../../servlet/NamePrefixServlet\",0,\n\"Name Suffix\",\"../../servlet/NameSuffixServlet\",0,\n\"Alternate ID Type\",\"../../servlet/AlternateIDServlet\",0,\n\"Patient Category\",\"../../servlet/PatientCatServlet\",0,\n\"Relationships\",\"../../servlet/RelationshipServlet\",0,\n\"Reason for Patient Suspension\",\"../../servlet/PatientSuspensionServlet\",0,\n\"Refferal\",\"../../servlet/ReferralServlet\",0,\n\"Age Range\",\"../../servlet/AgeRangeServlet\",0,\n\"Summarization Ranges\",\"../html/Home.html\",0,\n\"Contact Modes\",\"../../servlet/ContactServlet\",0,\n\"Race\",\"../../servlet/RaceServlet\",0,\n\"Ethinic Group\",\"../../eMP/html/EthinicGroup.html\",0\n)\n\narMenu3_3 = new Array(\n\"MP Parameter\",\"../../eMP/jsp/mp_param.jsp\",0,\n\"MP Parameter for Faciltiy\",\"../../eMP/jsp/FacilityLevelPass.jsp\",0,\n\"Enterprise wide Patient Series Group\",\"../../servlet/PatientNumberingServlet\",0,\n\"Patient Numbering\",\"../../servlet/PatientNumberingDetailServlet\",0,\n\"Medical Records Sections\",\"../../servlet/MRecordsSectionServlet\",0,\n\"Online Report Parameters\",\"../html/Home.html\",0\n)\n\narMenu3_4 = new Array(\n\"Patient Registration\",\"../../servlet/PatientRegistrationServlet\",0,\n\"Change Patient Details\",\"../html/Home.html\",0,\n\"Suspend / Reinstate Patient\",\"../../eMP/jsp/SuspendReinstatePatientPass.jsp\",0,\n\"Record / Revoke Death\",\"../../eMP/jsp/RecordRevokeDeathPass.jsp\",0,\n\"View Patient Details\",\"../html/Home.html\",0,\n\"Patient Search\",\"../../eMP/html/PatientSearch.html\",0\n)\n\narMenu3_5 = new Array(\n\"Printer\",\"../../servlet/PrinterServlet\",0,\n\"Reports Service\",\"../../servlet/ReportServiceServlet\",0,\n\"Report Group\",\"../../servlet/ReportGroupServlet\",0,\n\"Report\",\"../../eMP/html/Report.html\",0\n)\n\n// OP sub menus for masters\n\narMenu3_6 = new Array(\n\"Visit Type\",\"../../eOP/Html/AddVisittype.html\",0,\n\"Speciality\",\"../../eOP/Html/AddSpeciality.html\",0,\n\"Age Group\",\"../../eOP/Html/GenderGroup.html\",0,\n\"Practitioner Type\",\"../../eOP/Html/AddPractitioner.html\",0,\n\"Visit Type for Clinic\",\"../../eOP/Html/AddVisitTypeForClinic.html\",0,\n\"Clinic\",\"../../eOP/html/addClinic.html\",0,\n\"Practitioner for Clinic\",\"../../eOP/Html/Clinic.html\",0,\n\"Encounter Series\",\"../../eOP/Html/OPEncounter.html\",0,\n\"Practioner For Facility\",\"../../eOP/Html/OPPForFacility.html\",0\n)\n*/\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/js;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/js;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

try{
//	con = (Connection) session.getValue( "connection" ) ;

	con=ConnectionManager.getConnection(request);

	String menuIdSql		= "select menu_id from sm_resp where resp_id = ? " ;
	String rootMenuSql	= "select menu_id, srl_no, menu_name, option_type, submenu_id, option_descriptor, module_id, function_id, function_type, executable_name, insert_access_yn, update_access_yn, delete_access_yn, print_access_yn, query_only_access_yn from sm_menu_dtl_vw where menu_id = ? order by menu_id, srl_no " ;
//	String rootMenu		= "'175', '0', '100', 'black', 'yellow', 'wheat', 'green', 'black','black'" ;
	String rootMenu		= "'175', '0', '100', 'black', 'black', '#B2B6D7', '#F0F0F2', 'black','black'" ;
	String rootMenuItem	= "" ;
	String rootMenuItems	= "" ;

	int sub_menu_count = 1 ;
	java.util.Vector vector = new java.util.Vector() ;

	String responsibility_id	= (String) session.getValue( "responsibility_id" ) ;

//	out.println( "alert('" + responsibility_id + "') ;" ) ;

	pstmt = con.prepareStatement( menuIdSql ) ;
	pstmt.setString( 1, responsibility_id ) ;
	rs = pstmt.executeQuery() ;

	if ( rs != null ) {
		rs.next() ;
		String root_menu_id = rs.getString( "menu_id" ) ;

//	out.println( "alert('" + root_menu_id + "') ;" ) ;

		out.println( " arMenu1 = new Array( 150, '', '', '', '', '', '', '', '', '', '', 0, '', '', 0, '', '', 0, '', '', 0, '', '', 0 );" ) ;
		out.println( " arMenu2 = new Array( 150, '', '', '', '', '', '', '', '', '', '', 0, '', '', 0, '', '', 0, '', '', 0, '', '', 0 );" ) ;

		pstmt = con.prepareStatement( rootMenuSql ) ;
		pstmt.setString( 1, root_menu_id ) ;
		rs = pstmt.executeQuery() ;

		if ( rs != null ) {
			while( rs.next() ) {

				//int	 srl_no			= rs.getInt( "srl_no" ) ;
				String menu_id			= rs.getString( "menu_id" ) ;
				String menu_name			= rs.getString( "menu_name" ) ;
				String option_type		= rs.getString( "option_type" ) ;
				String submenu_id			= rs.getString( "submenu_id" ) ;
				String option_descriptor	= rs.getString( "option_descriptor" ) ;
				String module_id			= rs.getString( "module_id" ) ;
				String function_id 		= rs.getString( "function_id" ) ;
				String function_type		= rs.getString( "function_type" ) ;
				String executable_name		= rs.getString( "executable_name" ) ;
				String insert_access_yn		= rs.getString( "insert_access_yn" ) ;
				String update_access_yn		= rs.getString( "update_access_yn" ) ;
				String delete_access_yn		= rs.getString( "delete_access_yn" ) ;
				String print_access_yn		= rs.getString( "print_access_yn" ) ;
				String query_only_access_yn	= rs.getString( "query_only_access_yn" ) ;

				if ( menu_id 			== null ) menu_id 			= "" ;
				if ( menu_name			== null ) menu_name 			= "" ;
				if ( option_type			== null ) option_type			= "" ;
				if ( submenu_id			== null ) submenu_id			= "" ;
				if ( option_descriptor		== null ) option_descriptor		= "" ;
				if ( module_id			== null ) module_id			= "" ;
				if ( function_id			== null ) function_id			= "" ;
				if ( function_type		== null ) function_type			= "" ;
				if ( executable_name		== null ) executable_name		= "" ;
				if ( insert_access_yn		== null ) insert_access_yn		= "" ;
				if ( update_access_yn		== null ) update_access_yn		= "" ;
				if ( delete_access_yn		== null ) delete_access_yn		= "" ;
				if ( print_access_yn		== null ) print_access_yn		= "" ;
				if ( query_only_access_yn	== null ) query_only_access_yn	= "" ;


				vector.add( submenu_id ) ;

				if ( option_type.equalsIgnoreCase( "M" ) ) {
					rootMenuItem  = 	"'" + option_descriptor + "'" + "," +
								"'" + "#samepage" 	+ "'" + "," +
								"1" ;
				} else {
					rootMenuItem  = 	"'" +	option_descriptor		+ "'" + ", "	+
								"'" +	executable_name		+
									"?module_id="	+ module_id		+
									"&function_id="	+ function_id 	+
									"&function_name=" + option_descriptor 	+
									"&function_type="	+ function_type	+
									"&access=" + 	insert_access_yn	+
												update_access_yn 	+
												query_only_access_yn +
												delete_access_yn 	+
												print_access_yn 	+
												"'" + ", " +
								"0" ;
				}

//				out.println( "alert(\"" + rootMenuItem + "\");" ) ;

				if ( !rootMenuItems.equals( "" ) )
					rootMenuItems = rootMenuItems + "," + rootMenuItem ;
				else
					rootMenuItems = rootMenuItems + rootMenuItem ;
			}

//			out.println( "alert(\"" + rootMenuItems + "\");" ) ;
			out.println( "arMenu3 = new Array( " + rootMenu + "," + rootMenuItems + ") ;" ) ;

			try {
				if ( rs != null ) rs.close() ;
				if ( pstmt != null ) pstmt.close() ;
			} catch( Exception ce ) {}

			for ( java.util.Enumeration e = vector.elements() ; e.hasMoreElements() ; sub_menu_count++ ) {
				String sub_menu_id = (String) e.nextElement() ;
				rootMenuItem = "" ;
				rootMenuItems = "" ;

				if ( !( sub_menu_id == null ) || ( sub_menu_id.equalsIgnoreCase( "" ) ) ) {
//					out.println( "alert(" + sub_menu_id + "s" + ");" ) ;

					pstmt = con.prepareStatement( rootMenuSql ) ;
					pstmt.setString( 1, sub_menu_id ) ;
					rs = pstmt.executeQuery() ;
// *************************************************************

					if ( rs != null ) {
						while( rs.next() ) {

						//	int	 srl_no			= rs.getInt( "srl_no" ) ;
							String menu_id			= rs.getString( "menu_id" ) ;
							String menu_name			= rs.getString( "menu_name" ) ;
							String option_type		= rs.getString( "option_type" ) ;
							String submenu_id			= rs.getString( "submenu_id" ) ;
							String option_descriptor	= rs.getString( "option_descriptor" ) ;
							String module_id			= rs.getString( "module_id" ) ;
							String function_id 		= rs.getString( "function_id" ) ;
							String function_type		= rs.getString( "function_type" ) ;
							String executable_name		= rs.getString( "executable_name" ) ;
							String insert_access_yn		= rs.getString( "insert_access_yn" ) ;
							String update_access_yn		= rs.getString( "update_access_yn" ) ;
							String delete_access_yn		= rs.getString( "delete_access_yn" ) ;
							String print_access_yn		= rs.getString( "print_access_yn" ) ;
							String query_only_access_yn	= rs.getString( "query_only_access_yn" ) ;

							if ( menu_id 			== null ) menu_id 			= "" ;
							if ( menu_name			== null ) menu_name 			= "" ;
							if ( option_type			== null ) option_type			= "" ;
							if ( submenu_id			== null ) submenu_id			= "" ;
							if ( option_descriptor		== null ) option_descriptor		= "" ;
							if ( module_id			== null ) module_id			= "" ;
							if ( function_id			== null ) function_id			= "" ;
							if ( function_type		== null ) function_type			= "" ;
							if ( executable_name		== null ) executable_name		= "" ;
							if ( insert_access_yn		== null ) insert_access_yn		= "" ;
							if ( update_access_yn		== null ) update_access_yn		= "" ;
							if ( delete_access_yn		== null ) delete_access_yn		= "" ;
							if ( print_access_yn		== null ) print_access_yn		= "" ;
							if ( query_only_access_yn	== null ) query_only_access_yn	= "" ;

							if ( option_type.equalsIgnoreCase( "M" ) ) {
								rootMenuItem  = 	"'" + option_descriptor + "'" + "," +
											"'" + "#samepage" 	+ "'" + "," +
											"1" ;
							} else {
								executable_name = "" ;

								rootMenuItem  = 	"'" +	option_descriptor		+ "'" + ", "	+
											"'" +	executable_name		+
												"?module_id="	+ module_id		+
												"&function_id="	+ function_id 	+
												"&function_name=" + option_descriptor 	+
												"&function_type="	+ function_type	+
												"&access=" + 	insert_access_yn	+
													update_access_yn 	+
													query_only_access_yn +
													delete_access_yn 	+
													print_access_yn 	+
													"'" + ", " +
											"0" ;
							}

//							out.println( "alert(\"" + rootMenuItem + "\");" ) ;

							if ( !rootMenuItems.equals( "" ) )
								rootMenuItems = rootMenuItems + "," + rootMenuItem ;
							else
								rootMenuItems = rootMenuItems + rootMenuItem ;
						}

//						out.println( "alert(\"" + rootMenuItems + "\");" ) ;
						out.println( "arMenu3_" + sub_menu_count + " = new Array( " + rootMenuItems + ") ;" ) ;

						try {
							if ( rs != null ) rs.close() ;
							if ( pstmt != null ) pstmt.close() ;
						} catch ( Exception ce ) {}
					}
				}
			}
// *************************************************************/
		}
	}
}catch(Exception e){out.println(e);}
			finally { 
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}	
// Working code start
//	out.println( " arMenu1 = new Array( 150, '', '', '', '', '', '', '', '', '', '', 0, '', '', 0, '', '', 0, '', '', 0, '', '', 0 );" ) ;
//	out.println( " arMenu2 = new Array( 150, '', '', '', '', '', '', '', '', '', '', 0, '', '', 0, '', '', 0, '', '', 0, '', '', 0 );" ) ;
//	out.println( " arMenu3 = new Array(	'175', '0', '0', '', 'white', '', 'orange', 'ivory','red', 'System Admin','#samepage',0, 'Master Codes','#samepage',0 );" ) ;
// Working code end


            _bw.write(_wl_block3Bytes, _wl_block3);

	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception ce ) {}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
