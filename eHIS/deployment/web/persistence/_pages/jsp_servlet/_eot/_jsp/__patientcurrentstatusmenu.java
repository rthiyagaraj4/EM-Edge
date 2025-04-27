package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import eCommon.Common.CommonBean;
import eOT.PatientStatusBean;
import java.util.*;
import com.ehis.util.*;

public final class __patientcurrentstatusmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PatientCurrentStatusMenu.jsp", 1738042906000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<meta charset=\"utf-8\" /> \n\t<meta name=\"keywords\" content=\"\" />\n\t<meta name=\"description\" content=\"\" />\n\t<head>\n\n\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eOT/js/jquery-latest.js\" language=\"JavaScript\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<link rel=\"stylesheet\" href=\"../../eOT/html/disstyle.css\" type=\"text/css\" media=\"screen, projection\" />\n\t<style type=\"text/css\">\n\t\t#divWidth\n\t\t{\n\t\t\twidth: 400px;\n\t\t\tmargin-left: auto;\n\t\t\tmargin-right: auto;\n\t\t}\n\t</style>\n\t<script>\n\t\t$(document).ready(function(){\n\t\t\t$(window).load(function(){\n\t\t\t\tvar detheight = parseInt($(window).height())- (parseInt($(\".header\").height())+ parseInt($(\".footer\").height())); \n\t\t\t\t$(\".detailslot\").css(\"height\", detheight);\n\t\t\t});\n\t\t\t$(window).resize(function(){\n\t\t\t\tvar detheight = parseInt($(window).height())- (parseInt($(\".header\").height())+ parseInt($(\".footer\").height())); \n\t\t\t\t$(\".detailslot\").css(\"height\", detheight);\n\t\t\t});\n\t\t});\n\t\t\n\tfunction submitPrevNext(from, to)\n\t{\n\t\tvar param = \"from=\"+parseInt(from)+\n\t\t\"&to=\"+parseInt(to);\n\t\twindow.location.href = \'../../eOT/jsp/PatientCurrentStatusMenu.jsp?\'+param;\n\t}\t\t\n\t\n\tfunction start()\n\t{\n\t\tvar dateTime = getCurrentDate(\"DMYHMS\",\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\");\n\t\tvar dateTimeArray = dateTime.split(\" \");\n\t\tdocument.getElementById(\"dateDiv\").innerHTML = dateTimeArray[0];\n\t\tvar timeSecArray = dateTimeArray[1].split(\":\");\n\t\tdocument.getElementById(\"timeDiv\").innerHTML = timeSecArray[0] + \":\" + timeSecArray[1];\n\t\tdocument.getElementById(\"secDiv\").innerHTML = \":\" + timeSecArray[2];\n\t\ttimer=setTimeout(\"start()\",1000);\n\t}\n\tfunction CodeArrest() \n\t{\n\t    if((window.event.button == 1) || (window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) \n\t\t{\n\t        alert(\"Welcome to eHIS\");\n\t    }\n\t}\n\tfunction closeHelp()\n\t{ \n\t\t\n\t\tvar key = event.keyCode; \n\t\tif (key == 27)\n\t\t{\n\t\t\tif(parent.parent.opener != null)\n\t\t\t{\n\t\t\t\tparent.parent.opener.closeDashboard();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\twindow.close();\t\n\t\t\t}\n\t\t}\n\t} \n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body OnMouseDown=\'CodeArrest()\' onkeypress=\"closeHelp()\">\n\n\t\t\n\t\t<div class=\"detailslot\">\n\t\t\t<div class=\"columnone_slotone\" >\n\t\t\t\t<div class=\"nobgdetailpanel\">\n\t\t\t\t\t<div class=\"rdcheader\">\n\t\t\t\t\t\t<div class=\"stftext\">Patient Current Status</div>\n\t\t\t\t\t</div>\n<table>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<td width=\"32%\">\n\t\t\t\t\t\t<div class=\"pstatuspanelbg\">\n\t\t\t\t\t\t\t<div class=\"pstatusinfopanel\">\n\t\t\t\t\t\t\t\t<div class=\"patientifostrip\" id=\"divWidth\">\n\t\t\t\t\t\t\t\t\t<div class=\"pstripleft\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"pinfoheaderstrip\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pstripinfoid\"  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"pstripgender\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"pstripgender\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"pstripright\" >\n\t\t\t\t\t\t\t\t\t\t<div id=\"inbutton\" style=\'background-color:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'> </div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"tablestrip\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pstripstatus\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t<!-- Added for IN:44800-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pstripinfoid\" style=\'color:#FF0000\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">Unscheduled</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t<!-- End  for IN:44800--->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pstripstatus\">Previous Day Booking</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</table>\n\t\t\t\t\t<div class=\"pagination\" >\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\n\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t\t\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\t\t\t</div>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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

	String facilityId = (String) session.getValue( "facility_id" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	int refreshCount = PatientStatusBean.getAutoRefreshTime(facilityId);

            _bw.write(_wl_block1Bytes, _wl_block1);
 response.addHeader("Refresh",refreshCount + ""); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	HashMap scheduled_case_details = new HashMap();
	LinkedHashMap detailMap = new LinkedHashMap();
	String colourAndDesc = "";
	String params = request.getQueryString();
	ArrayList displayResultList = new ArrayList(Arrays.asList(params.split(",")));
	if(params != null && params.trim().length() > 0)
	{
		for(int i=0; i<displayResultList.size(); i++)
		{
			colourAndDesc = (String)displayResultList.get(i);
			//System.out.println("==colourAndDesc=="+colourAndDesc);
			String[] colourAndDescArr = colourAndDesc.split("~~");
			//System.out.println("===colourAndDescArr==0=="+colourAndDescArr[0]);
			//System.out.println("===colourAndDescArr==1=="+colourAndDescArr[1]);
			detailMap.put(colourAndDescArr[0], colourAndDescArr[1].replaceAll("%20", " ").replaceAll("%26", "&"));
		}
	}
	String bean_id = "SlateBean";
	String bean_name	= "eOT.SlateBean";
	SlateBean bean = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	String statusBeanId = "PatientStatusBean";
	String statusBeanName = "eOT.PatientStatusBean";
	String fromMenu = request.getParameter("fromMenu");
	PatientStatusBean statusBean = (PatientStatusBean)mh.getBeanObject( statusBeanId, request, statusBeanName );
	int patientCount = 0;
	//get the Page No from the Session
	
	/*
		First time the page is loaded 
	*/
	
	if(statusBean.getCurrentPageNo() == 0 )
	{
		statusBean.clear();
		patientCount = bean.getPatientCount(facilityId);
		statusBean.populateInformation(patientCount);
	}
	
	Map<String,Integer> pageInfoMap = statusBean.getCurrentPageInformation();
	
	int from = pageInfoMap.get("FROM");
	int to = pageInfoMap.get("TO");
	HashMap patientCurrentStatusMap = bean.patientCurrentStatus(from + "", to + "", facilityId, detailMap);
	String sysDateTime = bean.getSysDateTime();
	

            _bw.write(_wl_block8Bytes, _wl_block8);

	int z = 0;
		for(int j=0; j<5 && z < patientCurrentStatusMap.size(); j++)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

			for(int k=0; k<3 && z < patientCurrentStatusMap.size() ; k++)
			{
				scheduled_case_details = (HashMap)patientCurrentStatusMap.get(z);
				String image = CommonBean.checkForNull((String)scheduled_case_details.get("imageicon"));
				String unSchedColorCode = "";
				String prevDay = (String)scheduled_case_details.get("PREV_DAY");
				if("0".equals((String)scheduled_case_details.get("IS_SCHD")))
				{
					//unSchedColorCode = "style='background-color:#FF0000'";
					unSchedColorCode = "";
				}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( unSchedColorCode ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CommonBean.checkForNull((String)scheduled_case_details.get("PATIENT_ID"))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(CommonBean.checkForNull((String)scheduled_case_details.get("SEX"))));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CommonBean.checkForNull((String)scheduled_case_details.get("CURRENT_LOCN"))));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( (String)scheduled_case_details.get("COLOR_CODE")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(CommonBean.checkForNull((String)scheduled_case_details.get("STATUS"))));
            _bw.write(_wl_block16Bytes, _wl_block16);

											if("0".equals((String)scheduled_case_details.get("IS_SCHD")))
												{
													unSchedColorCode = "";
											
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( unSchedColorCode ));
            _bw.write(_wl_block18Bytes, _wl_block18);

											}
											
            _bw.write(_wl_block19Bytes, _wl_block19);

										if("1".equals(prevDay))
										{
									
            _bw.write(_wl_block20Bytes, _wl_block20);

										}
									
            _bw.write(_wl_block21Bytes, _wl_block21);

			z++;
			}

            _bw.write(_wl_block22Bytes, _wl_block22);

		}
//	}

            _bw.write(_wl_block23Bytes, _wl_block23);

						String span1Class = "";
						String span2Class = "";
						String span3Class = "";
						if(pageInfoMap.get("PAGE_NO_1") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span1Class = "selectedpage";
							span2Class = "unselectedpage";
							span3Class = "unselectedpage";
						}
						else if(pageInfoMap.get("PAGE_NO_2") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span2Class = "selectedpage";
							span1Class = "unselectedpage";
							span3Class = "unselectedpage";
						}
						else if(pageInfoMap.get("PAGE_NO_3") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span3Class = "selectedpage";
							span1Class = "unselectedpage";
							span2Class = "unselectedpage";
						}
						int pageNo2 = pageInfoMap.get("PAGE_NO_2");
						int pageNo3 =  pageInfoMap.get("PAGE_NO_3");
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(span1Class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_1") ));
            _bw.write(_wl_block26Bytes, _wl_block26);

						if(statusBean.getNoOfPages() >= pageNo2)
						{
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(span2Class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_2") ));
            _bw.write(_wl_block26Bytes, _wl_block26);

						}
						if(statusBean.getNoOfPages() >= pageNo3)
						{
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(span3Class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_3") ));
            _bw.write(_wl_block26Bytes, _wl_block26);

						}
					
            _bw.write(_wl_block28Bytes, _wl_block28);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
