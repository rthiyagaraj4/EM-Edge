package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.Types;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;
import java.util.Properties;
import eOT.Common.OTRepository;
import eOT.OperationDtlBean;
import eOR.OrderEntryBillingQueryBean;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __operationregisterframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationRegisterFrame.jsp", 1739960082000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n\t<head>\n\t\t<script type=\"text/javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t\t<script type=\'text/javascript\' src=\'../../eOT/js/Booking.js\'></script>\n\t\t<script language=\'javascript\'  src=\'../../eCommon/js/common.js\' ></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<TITLE>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TITLE>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!--<frameset rows=\'5%,12%,35%,*,10%\'>-->\n\t\t<iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\" scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=\'0\' style=\'height:4vh;width:98vw\' ></iframe>\n\t\t<iframe name=\"OtPatientLineFrame\" id=\"OtPatientLineFrame\" src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=\'0\'  scrolling=\"no\" style=\'height:12vh;width:98vw\'> </iframe>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<!--<frameset rows=\'4%,50%,*,4%\'>-->\n\t\t<iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\" frameborder=\'0\' scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\'height:4vh;width:98vw\'></iframe>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<iframe name=\'header_frame\' id=\'header_frame\' src=\"../../eOT/jsp/OperationProcedureHdr.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=\'0\'  scrolling=\"no\" noresize style=\'height:45vh;width:98vw\'></iframe>\n\t\t<iframe name=\'message_search_frame\' id=\'message_search_frame\'\t src=\"../../eOT/jsp/OperationCommonFrame.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" scrolling=\"no\" frameborder=\'0\' style=\'height:40vh;width:98vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' frameborder=\'0\' style=\'height:6vh;width:98vw\'></iframe>\n\t<!--</frameset>-->\n<form name=\"OperationRegisterFrameForm\"  id=\"OperationRegisterFrameForm\">\n\t<input type=\'hidden\' name=\'locale\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\'hidden\' name=\'params\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n</form>\n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
 
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends  

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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    String or_bean_id 						= "Or_billingQueryBean";
	String or_bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)mh.getBeanObject( or_bean_id,request, or_bean_name ) ;
	or_bean.clearBean();

            _bw.write(_wl_block6Bytes, _wl_block6);

	String bean_id = "OperationDtlBean";
	String bean_name = "eOT.OperationDtlBean";
	OperationDtlBean chk_bean = (OperationDtlBean)mh.getBeanObject( bean_id, request, bean_name);
	chk_bean.clear();
	int dayVal=0;
	String weekDay[]=new String[8];
	String facility_id  = (String) session.getValue("facility_id");
	//Added by lakshmi against change in performing_facility starts here
	String performing_facility_id = (String)session.getValue("performing_facility");
	if(performing_facility_id!=null && performing_facility_id.length()>0)
		{
			facility_id = (String)session.getValue("performing_facility");
		}
	//Added by lakshmi against change in performing_facility ends here
	Properties p=(Properties)session.getValue("jdbc");
	String login_user= p.getProperty("login_user");
	String sunday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels")+",";
	String monday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels")+",";
	String tuesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels")+",";
	String wednesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels")+",";
	String  thursday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels")+",";
	String  friday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels")+",";
	String  saturday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels")+",";
	weekDay[1]=sunday;
	weekDay[2]=monday;
	weekDay[3]=tuesday;
	weekDay[4]=wednesday;
	weekDay[5]= thursday;
	weekDay[6]=friday;
	weekDay[7]=saturday;
	//DhanasekarV Modified against the issue IN023690  on 15/11/2010
//String strBookingDate=com.ehis.util.DateUtils.convertDate(request.getParameter("booking_date"),"DMY",locale,"en");
String strBookingDate1 =com.ehis.util.DateUtils.convertDate(request.getParameter("booking_date"),"DMY",locale,"en");
String strBookingDate=request.getParameter("booking_date");
String ammendFlag = request.getParameter("ammendFlag");
System.out.println("=========ammendFlag======OperationRegisterFrame========="+ammendFlag);
	//end IN023690
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String param=request.getQueryString();
	String sql=""+OTRepository.getOTKeyValue("SQL_OT_COMMON_DATE_SELECT1");
	String strSpecialityYN="";
	conn = ConnectionManager.getConnection(request);
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,strBookingDate1);
		rs=pstmt.executeQuery();
		if(rs.next()==true)	 dayVal=Integer.parseInt(rs.getString(1));
		rs.close();
		pstmt.close();
		//sql=""+OTRepository.getOTKeyValue("SQL_OT_BOOKING_AUTHORIZATION1");
		sql="SELECT OVERIDE_SPLTY_RESTRICTION_YN OVERIDE_SPLTY_RESTRICTION_YN1  FROM OT_BOOKING_ACCESS_RIGHTS WHERE OPERATING_FACILITY_ID =?  AND APPL_USER_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,login_user);
		rs=pstmt.executeQuery();
		if(rs.next()==true)
			strSpecialityYN=CommonBean.checkForNull(rs.getString("OVERIDE_SPLTY_RESTRICTION_YN1"));
		rs.close();
		pstmt.close();
		if(strSpecialityYN.length()==0)	 strSpecialityYN="N";
		////eOT.LogFile.log("OTDebugger"," Authorization  "+strSpecialityYN,this);
		 param=param+"&speciality_access="+strSpecialityYN;
	}catch(Exception ee){
		ee.printStackTrace();
		////eOT.LogFile.log("OTDebugger"," Authorization  "+ee,this);
	}finally{
		ConnectionManager.returnConnection(conn, request);
	}
	//note: To be Replaced by ResourceBundle Message.
	//String title= "Schedule Appointment for "+strBookingDate+" "+weekDay[dayVal];


	StringBuffer sbr = new StringBuffer();
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")).append(" ").append(strBookingDate).append(" ").append(weekDay[dayVal]);
	
	String title= sbr.toString();
	sbr.setLength(0);
	String source="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	String strOrderId = checkForNull(request.getParameter("orderid"));


    /* below procedure added by sathish on 08/01/2008  for disabling billing part when unchecked bl_interface_flag */
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean bill_flag = false;
	try{
		conn	= ConnectionManager.getConnection(request);
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=conn.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();

   }finally{
		try{
			//if(rst!=null)rst.close(); 
			if(cstmt!=null)cstmt.close();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}

	}
   param=param+"&bill_flag="+bill_flag;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);
if(strOrderId.length()>0){
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(param));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(param));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(param));
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
