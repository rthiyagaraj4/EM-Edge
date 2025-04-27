package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eOT.*;
import eOT.Common.*;
import eOT.OTStaffAssignBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class __otstaffassignment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTStaffAssignment.jsp", 1709293432000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="  \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<head>\n\t<meta charset=\"utf-8\" />\n\t\t<title> Operation Theatre - 3 slot display </title>\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t\t<meta name=\"keywords\" content=\"\" />\n\t\t<meta name=\"description\" content=\"\" />\n\t\t<link rel=\"stylesheet\" href=\"../../eOT/html/style.css\" type=\"text/css\" media=\"screen, projection\" /> </link>\n\t\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eOT/html/style.css\"></link>\n\t\t<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction closeHelp()\n\t\t{ \n\t\t    var key = event.keyCode; \n\t\t\tif (key == 27)\n\t\t\t{\n\t\t\t\tif(parent.parent.opener != null)\n\t\t\t\t {\n\t\t\t\t\tparent.parent.opener.closeDashboard();\n\t\t\t\t }\n\t\t\t\telse\n\t\t\t\t  {\n\t\t\t\t\t window.close();\t\n\t\t\t\t  }\n\t\t\t}\n\t\t} \t\n\t\t\tfunction displayRoomCode(roomCode)\n\t\t\t{\n\t\t\t\tvar labelRoomCode = getLabel(\"eOT.OperationRoom.Label\",\"OT\") + \" : \" + roomCode;\n\t\t\t\tdocument.getElementById(\"roomCodeId\").innerHTML = labelRoomCode;\n\t\t\t}\n\t\t</script>\n</head> \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body  OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\' onkeypress=\"closeHelp()\">\n<div class=\"detailslot\" >\n\t\t\t<div class=\"columnone_slotone\">\n\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" style=\"overflow:hidden;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<div class=\"rdheadercontainer\">\n\t\t\t\t\t\t\t<div class=\"rdcheaderleft\"></div>\n\t\t\t\t\t\t\t<div class=\"rdcheader\">\n\t\t\t\t\t\t\t\t<div class=\"stftext\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"rdcheaderright\"></div>\n\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" style=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t\t\t<div class=\"staffinfodetail\">\n\t\t\t\t\t\t\t\t<div class=\"sinfoheader\">\n\t\t\t\t\t\t\t\t\t<div class=\"sinfoheaderleft\"></div>\n\t\t\t\t\t\t\t\t\t<div class=\"staffroominfo\" id=\'roomCodeId\'></div>\n\t\t\t\t\t\t\t\t\t<div class=\"sinfoheaderright\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"ribbonbg\"></div>\n\t\t\t\t\t\t\t\t<div class=\"detailscontainer\">\n\t\t\t\t\t\t\t\t\t<div class=\"detailholder\"> \n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t<div class=\"detailstrip\" style=\"height:8vhpx;overflow:hidden;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"floatleft\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"dstrip\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"fontblue\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span> <br/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"fontitalic\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"floatright\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"dstrip\" style=\"width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"fontnormal\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t- ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<br />\n\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"staffpagination\"  >\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t<span class=\"staffcountdisplay\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" - ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" Of ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span>\n\t\t\t\t\t\t\t\t<span style=\"float:left; \">\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</span>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\n\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</span>\n\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n</body>\n</html>\n\t\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

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

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);

	int from = 0; 
	int to = 0;	
	int z=0;
	int x=0;
	int autoRefreshTime = 0;
	int screenHeight = 0;
	int screenWidth = 0;
	String refreshIntervalId = request.getParameter("refreshIntervalId") == null ? "" : request.getParameter("refreshIntervalId");
	String intervalId = request.getParameter("intervalId") == null ? "" : request.getParameter("intervalId");
	if(intervalId != null && intervalId.indexOf("~") != -1)
		intervalId = intervalId.substring(0, intervalId.indexOf("~"));
	String staffAssignmentId = request.getParameter("staffAssignmentId") == null ? "" : request.getParameter("staffAssignmentId");
	String frameName = request.getParameter("frameName") == null ? "" : request.getParameter("frameName");
	String chkedValues = request.getParameter("chkedValues") == null ? "" : request.getParameter("chkedValues");
	String allCount = request.getParameter("allCount") == null ? "" : request.getParameter("allCount");
	String roomCount = request.getParameter("roomCount") == null ? "" : request.getParameter("roomCount");
	String staffAssignment = request.getParameter("staffAssignment") == null ? "" : request.getParameter("staffAssignment");
	String bean_id	 = "OTStaffAssignBean_" + frameName;
	String bean_name = "eOT.OTStaffAssignBean";
	OTStaffAssignBean bean	 = (OTStaffAssignBean)mh.getBeanObject( bean_id, request, bean_name );
	String statusBeanId = "StaffAssignmentBean_" + frameName;
	String statusBeanName = "eOT.StaffAssignmentBean";
	String fromMenu = request.getParameter("fromMenu");
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)mh.getBeanObject( statusBeanId, request, statusBeanName );
	if((allCount != null && allCount.trim().length() > 0 && Integer.parseInt(allCount) == 0) || (roomCount != null && roomCount.trim().length() > 0 && Integer.parseInt(roomCount) == 0))
		staffAssignmentBean.NO_OF_PATIENTS = 10;
	else
		staffAssignmentBean.NO_OF_PATIENTS = 5;
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	screenHeight = screenSize.height;
//	screenWidth = screenSize.width;
// 	Map<String, List<OTStaffAssignBean>> staffMap = bean.getAssignedStaffDtls(frameName, chkedValues, String.valueOf(from), String.valueOf(to));
	if(intervalId != null && intervalId.equalsIgnoreCase("SS"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId);
	else if(intervalId != null && intervalId.equalsIgnoreCase("MM"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId) * 60;
	response.setIntHeader("Refresh", autoRefreshTime);
	String locale = (String)session.getAttribute("LOCALE");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	Date todaysDate = new Date();
	String formatedDate = dateFormat.format(todaysDate);
	String formatedTime = timeFormat.format(todaysDate);
    String minuteFormat = formatedTime.substring(0, formatedTime.lastIndexOf(':'));
    String secondFormat = formatedTime.substring(formatedTime.lastIndexOf(':')+1, formatedTime.length());
	String roomCode = null;
	String roomCodeKey = null;
	List staffdetailsList = new ArrayList();
	List roomCodesList = new ArrayList();
	OTStaffAssignBean otStaffBean = new OTStaffAssignBean();
	int staffAssignedCount = 0;
	String tempRoomCode = "";
	String dyc = request.getParameter("dyc");
	String dyc_class1 = "";
	String dyc_class2 = "";
	String dyc_height = ""; 	
	String dyc_height1 = ""; 	
	if(dyc.equals("y"))
	{
		dyc_class1	= "detailpaneldh";
		dyc_class2	= "staffinfopaneldh";
	}
	else
	{
		dyc_class1	= "detailpanel";
		dyc_height	= "height:99%;";
		if(staffAssignment.equalsIgnoreCase("Y"))
			dyc_height1	= "height:73%";
		else
			dyc_height1	= "height:88%";
		dyc_class2	= "staffinfopanel";
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dyc_class1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dyc_height));
            _bw.write(_wl_block11Bytes, _wl_block11);

				if(staffAssignment != null && staffAssignment.equalsIgnoreCase("Y"))
				{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
						Map<String, List<OTStaffAssignBean>> staffMap = bean.getAssignedStaffDtls(frameName, chkedValues, "", "");

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dyc_class2));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dyc_height1));
            _bw.write(_wl_block16Bytes, _wl_block16);

							if(staffMap != null && staffMap.size() > 0)
							{
								staffdetailsList = staffMap.get("STAFFDETAILS");
											if(staffAssignmentBean.totalPatients != staffdetailsList.size())
											{
												staffAssignmentBean.setCurrentPageNo(0);
												staffAssignmentBean.lisIterCount = 0;
												staffAssignmentBean.roomCountPagination = 0;
											}
								staffAssignmentBean.totalPatients = staffdetailsList.size();
								if(staffAssignmentBean.lisIterCount >= staffAssignmentBean.totalPatients)
								{
									staffAssignmentBean.lisIterCount = 0;
									staffAssignmentBean.roomCountPagination = 0;
								}
								roomCodesList = staffMap.get("ROOMCODES");
								System.out.println("=====staffAssignmentBean.getCurrentPageNo()====="+staffAssignmentBean.getCurrentPageNo());
								if(staffAssignmentBean.getCurrentPageNo() == 0 )
								{
									staffAssignmentBean.clear();
									roomCode = "'"+(String)roomCodesList.get(staffAssignmentBean.roomCountPagination)+"'";
									staffAssignedCount = bean.getAssignedStaffDtlsAllCount("Room", roomCode);
									System.out.println("====staffAssignedCount===="+staffAssignedCount);
									staffAssignmentBean.populateInformation(staffAssignedCount);
								}
								Map<String,Integer> pageInfoMap = staffAssignmentBean.getCurrentPageInformation();
								from = pageInfoMap.get("FROM");
								to = pageInfoMap.get("TO");
								System.out.println("======from======"+from);
								System.out.println("======to======"+to);
								System.out.println("====roomCodesList===="+roomCodesList);
								System.out.println("===staffdetailsList==before===="+staffdetailsList);
								System.out.println("===staffAssignmentBean.lisIterCount==before===="+staffAssignmentBean.lisIterCount);
								for(int y=0; y<staffAssignmentBean.lisIterCount; y++)
								{
									System.out.println("===y==before===="+y);
									staffdetailsList.remove(0);
									System.out.println("===staffdetailsList==forrrr===="+staffdetailsList);
								}
											for(z=0,x=0; z<staffdetailsList.size()&&x<staffAssignmentBean.NO_OF_PATIENTS; z++,x++)
								{
									otStaffBean = (OTStaffAssignBean)staffdetailsList.get(z);
									System.out.println("=====otStaffBean===="+otStaffBean);
									if(tempRoomCode.equals(otStaffBean.getStrRoomCode()) || tempRoomCode.trim().length() == 0)
									{
													out.println("<script>displayRoomCode('"+otStaffBean.getStrRoomDesc()+"')</script>");
										staffAssignmentBean.lisIterCount++;
										tempRoomCode = otStaffBean.getStrRoomCode();

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(CommonBean.checkForNull((String)otStaffBean.getStrStaffShortName())));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CommonBean.checkForNull((String)otStaffBean.getStrRoleDesc())));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(CommonBean.checkForNull((String)otStaffBean.getStrFromTime())));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(CommonBean.checkForNull((String)otStaffBean.getStrToTime())));
            _bw.write(_wl_block21Bytes, _wl_block21);

													if(z == staffdetailsList.size()-1)
													{
														staffAssignmentBean.setCurrentPageNo(0);
														staffAssignmentBean.roomCountPagination++;
													}
													if(x == staffAssignmentBean.NO_OF_PATIENTS-1 && staffdetailsList.size() > staffAssignmentBean.NO_OF_PATIENTS)
													{
														otStaffBean = (OTStaffAssignBean)staffdetailsList.get(z+1);
														if(!tempRoomCode.equals(otStaffBean.getStrRoomCode()))
														{
															staffAssignmentBean.setCurrentPageNo(0);
															staffAssignmentBean.roomCountPagination++;
														}
													}
									}
									else
									{
										staffAssignmentBean.setCurrentPageNo(0);
										staffAssignmentBean.roomCountPagination++;
										break;
									}
								}

            _bw.write(_wl_block22Bytes, _wl_block22);

										if(x < staffAssignmentBean.NO_OF_PATIENTS)
											to = staffAssignmentBean.staffCountRoom;

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(from));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(to));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(staffAssignmentBean.staffCountRoom));
            _bw.write(_wl_block26Bytes, _wl_block26);

							System.out.println("===pageInfoMap===OTStaffAssignment==="+pageInfoMap);
							String span1Class = "";
							String span2Class = "";
							String span3Class = "";
							if(pageInfoMap.get("PAGE_NO_1") == pageInfoMap.get("CURRENT_PAGE"))
							{
								span1Class = "selectedpagePagination";
								span2Class = "unselectedpagePagination";
								span3Class = "unselectedpagePagination";
							}
							else if(pageInfoMap.get("PAGE_NO_2") == pageInfoMap.get("CURRENT_PAGE"))
							{
								span2Class = "selectedpagePagination";
								span1Class = "unselectedpagePagination";
								span3Class = "unselectedpagePagination";
							}
							else if(pageInfoMap.get("PAGE_NO_3") == pageInfoMap.get("CURRENT_PAGE"))
							{
								span3Class = "selectedpagePagination";
								span1Class = "unselectedpagePagination";
								span2Class = "unselectedpagePagination";
							}
							int pageNo2 = pageInfoMap.get("PAGE_NO_2");
							int pageNo3 =  pageInfoMap.get("PAGE_NO_3");

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(span1Class));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_1") ));
            _bw.write(_wl_block29Bytes, _wl_block29);

							if(staffAssignmentBean.getNoOfPages() >= pageNo2)
							{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(span2Class));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_2") ));
            _bw.write(_wl_block29Bytes, _wl_block29);

							}
							if(staffAssignmentBean.getNoOfPages() >= pageNo3)
							{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(span3Class));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_3") ));
            _bw.write(_wl_block29Bytes, _wl_block29);

							}

            _bw.write(_wl_block32Bytes, _wl_block32);

										}

            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.StaffAssignment.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
