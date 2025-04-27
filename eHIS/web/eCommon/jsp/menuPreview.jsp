<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/js;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>

<%!
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>

<%
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

%>

/*
arMenu1 = new Array(
150,
"","",
"","",
"","",
"","",
"","",0,
"","",0,
"","",0,
"","",0,
"","",0
)

arMenu2 = new Array(
150,
"","",
"","",
"","",
"","",
"","",0,
"","",0,
"","",0,
"","",0,
"","",0
)

arMenu3 = new Array(
"175",
"0","0",
"","white",
"","orange",
"ivory","red",
"System Admin","#samepage",1,
"Master Codes ","#samepage",1,
"MP Admin Setup","#samepage",1,
"Registration","#samepage",1,
"Print Rounting","#samepage",1,
"OP Masters","#samepage",1,
"Master Lists Report","../../Ush/new2.jsp",0,
"Change Responsibility","../../sm/jsp/change_responsibility.jsp",0,
"Change Password","../../sm/jsp/change_password.jsp",0
)

arMenu3_1 = new Array(
"Site Parameter","../../servlet/SiteParameterServlet",1,
"Facilities Parameter","../../sm/jsp/facility_param.jsp?function_name=Facility&module_id=SM",0,
"Master Codes","../../servlet/MasterCodeServlet",0,
"Master Unit for Grouped Codes","../html/Home.html",0,
"Responsibility Group","../../servlet/ResponsibilityGroupServlet",0,
"Responsibility","../../servlet/ResponsibilityServlet",0,
"User","../../sm/jsp/setup_user.jsp",0
)

arMenu3_1_1 = new Array(
"Site Parameter","../../servlet/SiteParameterServlet",1,
"Facilities Parameter","../../sm/jsp/facility_param.jsp?function_name=Facility&module_id=SM",0,
"Master Codes","../../servlet/MasterCodeServlet",0,
"Master Unit for Grouped Codes","../html/Home.html",0,
"Responsibility Group","../../servlet/ResponsibilityGroupServlet",0,
"Responsibility","../../servlet/ResponsibilityServlet",0,
"User","../../sm/jsp/setup_user.jsp",0
)

arMenu3_1_1_1 = new Array(
"Site Parameter","../../servlet/SiteParameterServlet",0,
"Facilities Parameter","../../sm/jsp/facility_param.jsp?function_name=Facility&module_id=SM",0,
"Master Codes","../../servlet/MasterCodeServlet",0,
"Master Unit for Grouped Codes","../html/Home.html",0,
"Responsibility Group","../../servlet/ResponsibilityGroupServlet",0,
"Responsibility","../../servlet/ResponsibilityServlet",0,
"User","../../sm/jsp/setup_user.jsp",0
)


arMenu3_2 = new Array(
"Marital Status","../../servlet/MaritalStatusServlet",0,
"Religion","../../servlet/ReligionServlet",0,
"Occupation Class","../../servlet/OccupationClassServlet",0,
"Occupation","../../servlet/OccupationServlet",0,
"Country","../../servlet/CountryServlet",0,
"Regions","../../servlet/RegionServlet",0,
"Areas","../../eMP/html/addResidenceArea.html",0,
"Towns","../../eMP/html/addResidenceTown.html",0,
"Postal Codes","../../servlet/PostalServlet",0,
"Name Prefix","../../servlet/NamePrefixServlet",0,
"Name Suffix","../../servlet/NameSuffixServlet",0,
"Alternate ID Type","../../servlet/AlternateIDServlet",0,
"Patient Category","../../servlet/PatientCatServlet",0,
"Relationships","../../servlet/RelationshipServlet",0,
"Reason for Patient Suspension","../../servlet/PatientSuspensionServlet",0,
"Refferal","../../servlet/ReferralServlet",0,
"Age Range","../../servlet/AgeRangeServlet",0,
"Summarization Ranges","../html/Home.html",0,
"Contact Modes","../../servlet/ContactServlet",0,
"Race","../../servlet/RaceServlet",0,
"Ethinic Group","../../eMP/html/EthinicGroup.html",0
)

arMenu3_3 = new Array(
"MP Parameter","../../eMP/jsp/mp_param.jsp",0,
"MP Parameter for Faciltiy","../../eMP/jsp/FacilityLevelPass.jsp",0,
"Enterprise wide Patient Series Group","../../servlet/PatientNumberingServlet",0,
"Patient Numbering","../../servlet/PatientNumberingDetailServlet",0,
"Medical Records Sections","../../servlet/MRecordsSectionServlet",0,
"Online Report Parameters","../html/Home.html",0
)

arMenu3_4 = new Array(
"Patient Registration","../../servlet/PatientRegistrationServlet",0,
"Change Patient Details","../html/Home.html",0,
"Suspend / Reinstate Patient","../../eMP/jsp/SuspendReinstatePatientPass.jsp",0,
"Record / Revoke Death","../../eMP/jsp/RecordRevokeDeathPass.jsp",0,
"View Patient Details","../html/Home.html",0,
"Patient Search","../../eMP/html/PatientSearch.html",0
)

arMenu3_5 = new Array(
"Printer","../../servlet/PrinterServlet",0,
"Reports Service","../../servlet/ReportServiceServlet",0,
"Report Group","../../servlet/ReportGroupServlet",0,
"Report","../../eMP/html/Report.html",0
)

// OP sub menus for masters

arMenu3_6 = new Array(
"Visit Type","../../eOP/Html/AddVisittype.html",0,
"Speciality","../../eOP/Html/AddSpeciality.html",0,
"Age Group","../../eOP/Html/GenderGroup.html",0,
"Practitioner Type","../../eOP/Html/AddPractitioner.html",0,
"Visit Type for Clinic","../../eOP/Html/AddVisitTypeForClinic.html",0,
"Clinic","../../eOP/html/addClinic.html",0,
"Practitioner for Clinic","../../eOP/Html/Clinic.html",0,
"Encounter Series","../../eOP/Html/OPEncounter.html",0,
"Practioner For Facility","../../eOP/Html/OPPForFacility.html",0
)
*/

<%
	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception ce ) {}
%>
