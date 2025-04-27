package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eIPAD.HealthObjects.*;
import eIPAD.sfs.*;

public final class __specialitylist_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/SpecialityList-newUI.jsp", 1709118032208L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>IP View</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> -->\n\n\n<link rel=\"stylesheet\" href=\"../css/iPadNew_IP.css\" />\n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />  \n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<script src=\"../jquery-1.5.2.min.js\"></script>\n\n<!-- <Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>  -->\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nvar scrollContent1,\nscrollNav;\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nfunction loaded1() {\n//scrollContent1 = new iScroll(\'contentWrapper1\');\nscrollNav = new iScroll(\'contentWrapper\');\n}\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\ndocument.addEventListener(\'DOMContentLoaded\', loaded1, false);\n\nfunction selectSpeciality(code,description){\n\t\n\tvar sfsContext = document.getElementById(\"hdnSfsContext\").value\n\t\n\tif(sfsContext == \'SP\'){\t\t\n\t\tdocument.getElementById(\"hdnSpecialityId\").value = code;\n\t\tdocument.getElementById(\"hdnSpecialityName\").value = description;\n\t}\n\telse if(sfsContext == \'NU\'){\n\t\tdocument.getElementById(\"hdnNursingUnitId\").value = code;\n\t\tdocument.getElementById(\"hdnNursingUnitName\").value = description;\t\t\n\t}\n\telse if(sfsContext == \'PR\'){\n\t\tdocument.getElementById(\"hdnPractitionerId\").value = code;\n\t\tdocument.getElementById(\"hdnPractitionerName\").value = description;\t\t\n\t}\n\tdocument.getElementById(\"IpSpecialityListForm\").submit();\n}\n\nfunction ipSearch(){\n\tparent.document.getElementById(\'hdnSpeciality\').value = document.getElementById(\'hdnSpecialityId\').value;\n\tparent.document.getElementById(\'hdnNursingUnit\').value = document.getElementById(\'hdnNursingUnitId\').value;\n\tparent.document.getElementById(\'hdnClinicianId\').value = document.getElementById(\'hdnPractitionerId\').value;\n\tparent.document.getElementById(\'hdnPatientId\').value = \'\';\n\tparent.document.getElementById(\'IpForm\').submit();\n}\nfunction back(){\n\tvar searchForm = document.getElementById(\"IpSpecialityListForm\");\n\tsearchForm.action = \'SpecialitySFS-newUI.jsp\';\n\tsearchForm.submit();\n}\n</script>\n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />\n</head>\n<body style=\"width: 100%; height: 100%;\">\n\t<form name=\'IpSpecialityListForm\' id=\'IpSpecialityListForm\' method=\'post\' id=\"IpSpecialityListForm\" style= \"width:100%; height:100%;\" action=\"IPSearch-newUI.jsp\">\n\t\t<div class=\"ipSearchHeader ipSearchHeaderTheme\">\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td style=\"width:100px;\"><div class=\"ipSearchHeaderButtonTheme\" onclick=\"back()\">Back</div></td>\n\t\t\t\t\t<td style=\"width:200px;\"><div class=\"ipSearchHeaderText ipSearchHeaderTextTheme\">";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</div></td>\n\t\t\t\t\t<td style=\"width:100px;\"><div class=\"ipSearchHeaderButtonTheme\" onclick=\"ipSearch()\">Search</div></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div class=\"ipSearchContainer ipSearchContainerTheme\" style=\"width: 392px; height: 254px;\">\n\t\t\t<div>\n\t\t\t\t<table  cellpadding = \"0\" cellspacing = \"0\" border = \"0\" style=\"width:100%;height:100%;\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td style=\"width:50%;\"><div class=\"ipSearchTabSelected ipSearchTabSelectedTheme\"><div class=\"ipSearchTabText\">Search</div></div></td>\n\t\t\t\t\t\t<td style=\"width:50%;\"><div class=\"ipSearchTabNotSelected ipSearchTabNotSelectedTheme\"><div class=\"ipSearchTabText\">Recent Search</div></div></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t<div  data-role = \"none\" id = \"contentWrapper\" class=\"ipSearchResWrapperTheme ipSearchResWrapper\">\n       <div data-role = \"none\" style = \"width:100%;height:auto;overflow:auto\">\n\t\t<div>\n\t\t\t<table cellpadding=\"0\" cellspacing = \"0\" style=\"width: 100%; height: 100%;\" class=\"ipSearchResultsTableTheme\">\n\t\t\t\t<tr class=\"ipSearchResultsHeading ipSearchResultsHeadingTheme\">\n\t\t\t\t\t<th style=\"width:20%\"><span class=\"ipSearchResultsHeadingText\">Code</span></th>\n\t\t\t\t\t<th style=\"width:80%\"><span class=\"ipSearchResultsHeadingText\">Description</span></th>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\n\t\t\t\t   ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t <tr class=\"ipSearchResultsBody ipSearchResultsBodyTheme\" onclick=\"selectSpeciality(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\',\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\')\">\n\t\t\t\t\t<td><span class=\"ipSearchResultsBodyText\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span></td>\n\t\t\t\t\t<td><span class=\"ipSearchResultsBodyText\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span></td>\n\t\t\t\t</tr> \n\t\t\t  \n\t\t\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</table>\n\t\t\t\t      <div class=\"sfsSearchResultsEmptyTheme\">No Records Found</div>\n\t\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t</div>\n\t\t</div></div>\n \t\t\n\t\t<input type = \"hidden\" name =\"hdnSpecialityId\" id =\"hdnSpecialityId\" value =\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnSpecialityName\" id =\"hdnSpecialityName\" value =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnNursingUnitId\" id =\"hdnNursingUnitId\" value =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnNursingUnitName\" id =\"hdnNursingUnitName\" value =\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnPractitionerId\" id =\"hdnPractitionerId\" value =\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnPractitionerName\" id =\"hdnPractitionerName\" value =\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnSfsContext\" id =\"hdnSfsContext\" value =\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n\t\t</div>\n\t</form>\n\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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

request.setCharacterEncoding("UTF-8");

String locale = "en";

String fSpecialityId = "";
String fSpecialityName = "";
String fNursingUnitId = "";
String fNursingUnitName = "";
String fPractitionerId = "";
String fPractitionerName = "";
String fSfsContext = "";
String searchHeading = "";


if(request.getParameter("hdnSpecialityId") != null && request.getParameter("hdnSpecialityId").trim() != "")
{
 
	fSpecialityId = ((String)request.getParameter("hdnSpecialityId"));
}
if(request.getParameter("hdnSpecialityName") != null && request.getParameter("hdnSpecialityName").trim() != "")
{
 
	fSpecialityName = ((String)request.getParameter("hdnSpecialityName"));
}
if(request.getParameter("hdnNursingUnitId") != null && request.getParameter("hdnNursingUnitId").trim() != "")
{
 
	fNursingUnitId = ((String)request.getParameter("hdnNursingUnitId"));
}
if(request.getParameter("hdnNursingUnitName") != null && request.getParameter("hdnNursingUnitName").trim() != "")
{
 
	fNursingUnitName = ((String)request.getParameter("hdnNursingUnitName"));
}
if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId").trim() != "")
{
 
	fPractitionerId = ((String)request.getParameter("hdnPractitionerId"));
}
if(request.getParameter("hdnPractitionerName") != null && request.getParameter("hdnPractitionerName").trim() != "")
{
 
	fPractitionerName = ((String)request.getParameter("hdnPractitionerName"));
}
if(request.getParameter("hdnSfsContext") != null && request.getParameter("hdnSfsContext").trim() != "")
{
 
	fSfsContext = ((String)request.getParameter("hdnSfsContext"));
}

if(fSfsContext.equals("SP"))
	searchHeading = "Speciality";
else if(fSfsContext.equals("NU"))
	searchHeading = "Nursing Unit";
else if(fSfsContext.equals("PR"))
	searchHeading = "Practitioner";

Boolean bRadioCode = true;
Boolean bRadioDesc = false;
String sfacility_id = "";
String sclinicianId = "";
String sPracId = "";
String sPractionerId = "";
String sSearchBy = "" ;
String sSearchCriteria = "" ;
String sSearchText = "";
String SearchBy = "" ;
String SearchCriteria = "" ;
String SearchText = "";

SFSContext oSFSContext = new SFSContext();
oSFSContext.setRequest(request);

if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
{
	sfacility_id = (String)session.getValue("facility_id");
	oSFSContext.setSfacility_id(sfacility_id);
}

if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
{
	sclinicianId = (String)session.getValue("ca_practitioner_id");
	oSFSContext.setSclinicianId(sclinicianId);
}
if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId") != "")
{
	sPractionerId = (String)request.getParameter("hdnPractitionerId");
	oSFSContext.setsPractionerId(sPractionerId);
}

if(fSfsContext.equals("NU"))
{
	//sclinicianId = sPractionerId;
	oSFSContext.setsPractionerId(sclinicianId); //for Nursing Unit search alone always the practitioner ID is the login practitioner
}
//oSFSContext.setSclinicianId(sclinicianId);

if(request.getParameter("specialitySearch") != null && request.getParameter("specialitySearch") != "" )
{
	
	sSearchBy = (String)request.getParameter("specialitySearch");
	oSFSContext.setsSearchBy(sSearchBy);
	
	if(sSearchBy != null && sSearchBy.equals("desc")){
		bRadioDesc = true;
		bRadioCode = false;
	}
	
	
}
if(request.getParameter("specialitySearchCriteria") != null && request.getParameter("specialitySearchCriteria") != "" )
{
	sSearchCriteria = (String)request.getParameter("specialitySearchCriteria");
	oSFSContext.setsSearchCriteria(sSearchCriteria);
}	
if(request.getParameter("specialitySearchText") != null && request.getParameter("specialitySearchText") != "" )
{
	sSearchText = (String)request.getParameter("specialitySearchText");
	oSFSContext.setsSearchText(sSearchText);
}




            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(searchHeading ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

					   int nRowCount = 1;		       			    
					   int nLoopCount = 0;
					   int nListSize = 0;
					   SFSDetails bean = new SFSDetails();
					   List<SFSUnit> objSfsDetails = new ArrayList<SFSUnit>(); 
					  
					   try {
						  if(fSfsContext.equals("SP"))
							   oSFSContext.setType(SFSContext.SPECIALITY);
						  else if(fSfsContext.equals("NU"))
							  oSFSContext.setType(SFSContext.NURSINGUNIT);
						  else if(fSfsContext.equals("PR"))
							  oSFSContext.setType(SFSContext.PRACTITIONER);
						  
							  
							  
						  objSfsDetails = bean.getSFSUnit(oSFSContext); 
						   
					  
					   nListSize =  objSfsDetails.size();
					   //out.println(nListSize);
					   SFSUnit sfsUnit = null;
					   if(nListSize > 0)
					   {
					 	  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount++)
					 	  {
					 		 sfsUnit = objSfsDetails.get(nLoopCount);
					 		  if(sfsUnit != null )
							  {
		  
	 
	 				 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sfsUnit.getsCode()));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sfsUnit.getsDescription()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sfsUnit.getsCode()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sfsUnit.getsDescription()));
            _bw.write(_wl_block8Bytes, _wl_block8);

			 		 
					  }
					  nRowCount = nRowCount + 1;
					} 
            _bw.write(_wl_block9Bytes, _wl_block9);

			   }
			   else
			   {
				   
				  
            _bw.write(_wl_block10Bytes, _wl_block10);

				   
			   }
	  		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(fSpecialityId ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fSpecialityName ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fNursingUnitId ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fNursingUnitName ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fPractitionerId ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(fPractitionerName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fSfsContext ));
            _bw.write(_wl_block18Bytes, _wl_block18);

				 }catch ( Exception e ){
						//out.println(sqlStr.toString() + e);
						e.printStackTrace();
					}
					finally{

					}
					   

		

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
