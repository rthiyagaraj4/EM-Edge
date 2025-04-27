package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryresultmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryResultMain.jsp", 1740050326000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head><title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<!-- <script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));parent.criteriaMainFrame.document.addlSearchCriteriaForm.search.disabled = false;</script> -->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<!--  <frameset rows=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' framespacing=3 name=\"sectionFrame\" id=\"sectionFrame\">-->\n\t\t\t<iframe name=\"resultHdrFrame\" id=\"resultHdrFrame\" src= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\"  style=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'></iframe>\n\t\t\t<iframe name=\"resultListFrame\" id=\"resultListFrame\" src= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></iframe>\n\t\t\t<iframe name=\"resultDtlFrame\" id=\"resultDtlFrame\" src= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'></iframe>\n\t\t<!-- </frameset>-->\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<!-- <frameset rows=\"0%,0%,100%\" framespacing=3 > -->\n\t\t\t<iframe name=\"resultHdrFrame\" id=\"resultHdrFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:30vh;width:95vw\'></iframe>\n\t\t\t<iframe name=\"resultListFrame\" id=\"resultListFrame\" src=\"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:0vh;width:95vw\'></iframe>\n\t\t\t<iframe name=\"resultDtlFrame\" id=\"resultDtlFrame\" src=\"../../eOR/jsp/OrderEntryOrderSetResult.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&order_nature=A&display_records=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&order_catalog_nature=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:30vh;width:95vw\'></iframe>\n\t\t\t<!--<frame name=\"resultDtlFrame\" id=\"resultDtlFrame\" src=\'../../eOR/jsp/OrderEntryResultDtl.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&order_nature=A\' framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\"></frame>-->\n\t\t<!-- </frameset> -->\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<!-- <frameset rows=\"0%,100%,0%\" framespacing=3> -->\n\t\t\t\t<iframe name=\"resultHdrFrame\" id=\"resultHdrFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:30vh;width:95vw\'></iframe>\n\t\t\t\t<iframe name=\"resultListFrame\" id=\"resultListFrame\" src=\"../../eOR/jsp/OrderEntryOrderSetResult.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&order_nature=P&display_records=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:0vh;width:95vw\'></iframe>\n\t\t\t\t<iframe name=\"resultDtlFrame\" id=\"resultDtlFrame\" src=\"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:60vh;width:95vw\'></iframe>\n\t\t<!-- </frameset> -->\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<!-- <frameset rows=\"100%,0%,0%\" framespacing=3> -->\n\t\t\t\t<iframe name=\"resultHdrFrame\" id=\"resultHdrFrame\" src=\"../../eOR/jsp/OrderEntryOrderSetResult.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&order_nature=S&display_records=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:30vh;width:95vw\'></iframe>\n\t\t\t\t<iframe name=\"resultListFrame\" id=\"resultListFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:0vh;width:95vw\'></iframe>\n\t\t\t\t<iframe name=\"resultDtlFrame\" id=\"resultDtlFrame\" src=\"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:60vh;width:95vw\'></iframe>\n\t<!-- \t</frameset> -->\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\n\t <!--  <frameset rows=\"0%,0%,0%\" framespacing=3 > -->\n\t\t\t<iframe name=\"resultHdrFrame\" id=\"resultHdrFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:39vh;width:95vw\'></iframe>\n\t\t\t<iframe name=\"resultListFrame\" id=\"resultListFrame\" src=\"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:0vh;width:95vw\'></iframe>\n\t\t\t<iframe name=\"resultDtlFrame\" id=\"resultDtlFrame\" src=\"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:60vh;width:95vw\'></iframe>\n\t<!--  </frameset> -->  \n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script>parent.search_frames=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"; </script>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
	//out.println("qry-->"+request.getQueryString());
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
   bean.setLanguageId(localeName);
	/* Initialize Function specific end */

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
		/* Added By Arvind */
		session.removeAttribute("orderSetVal");
		session.removeAttribute("panelVal");
		session.removeAttribute("individualVal");
		session.removeAttribute("pageVist");
    	/* End Here */

    String order_category		= bean.checkForNull(request.getParameter("order_category"));
	String order_type			= bean.checkForNull(request.getParameter("order_type"));
	if(!order_type.equals("")) order_type = order_type.trim();
	String activity_type		= bean.checkForNull(request.getParameter("activity_type"));
	String order_catalog_nature	= bean.checkForNull(request.getParameter("order_catalog_nature"));
	String orderable_text		= bean.checkForNull(request.getParameter("orderable_text"));
	String criteria				= bean.checkForNull(request.getParameter("criteria"));
	String restrict_by			= bean.checkForNull(request.getParameter("restrict_by"));
	String priv_applicability_yn			= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	//String function_from		= bean.checkForNull(request.getParameter("function_from"));
	// Set to the bean to maintain the category and the order_type
	bean.setOrderCategoryValue(order_category);
	bean.setOrderTypeValue(order_type);
	bean.setRestrictYn(restrict_by);   // Used for Pharmacy Orders
	//int atomic_frame_count		= 0;
	//int profile_frame_count		= 0;
	//int group_frame_count		= 0;
	String atomic_file_name		= "../../eCommon/html/blank.html";
	String group_file_name		= "../../eCommon/html/blank.html";
	String profile_file_name	= "../../eCommon/html/blank.html";
	String frame_size			= "0%,0%,0%";
	//String group_frame			= "", profile_frame		= "", 
	//String atomic_frame			= ""; 
	//String group_display_size 	= "0";
	//String profile_display_size 	= "0";
	//String atomic_display_size 	= "0";
	String frame_names			= "";
	int display_records			= OrRepository.DISPLAY_MAX_RECORDS;// 44 records as set in repository

if(order_catalog_nature.equals("")) // For All
{

			HashMap map = new HashMap();
	        map.put("order_category",order_category);
	        map.put("order_type",order_type);
	        map.put("activity_type",activity_type);
			map.put("order_catalog_nature",order_catalog_nature);
	        map.put("orderable_text",orderable_text);
	        map.put("criteria",criteria);
	        map.put("restrict_by",restrict_by);
	        map.put("priv_applicability_yn",priv_applicability_yn);
			
			
		/*ArrayList orderCatalog = bean.getOrderCatalog(map); // to get the count

		if(orderCatalog!=null)
		{
			for(int i=0; i<orderCatalog.size(); i++)
			{
				String[] record = (String[])orderCatalog.get(i);
				if(record[1].equals("S")) // FOR ALL
				group_frame_count = Integer.parseInt(record[0]);
								
				else if(record[1].equals("A")) // For Atomic
				
					atomic_frame_count = Integer.parseInt(record[0]);
					
				
				else if(record[1].equals("P")) // For Profile
					profile_frame_count = Integer.parseInt(record[0]);
			}
		}*/
	// For External Order, Order Set tab not to be shown.
	// Make the group_frame_count = 0, so that the frame will not be displayed
	//if(function_from.equals("EXTERNAL_ORDER"))
	//	group_frame_count = 0;
//out.println("group_frame_count="+group_frame_count+" ,atomic_frame_count="+atomic_frame_count+", profile_frame_count="+profile_frame_count);
//order_category=LB,order_type=,activity_type=, order_catalog_nature=,orderable_text=,criteria=C,restrict_by=N group_frame_count=0 ,atomic_frame_count=2, profile_frame_count=0 



		//if(!(group_frame_count == 0 && profile_frame_count == 0  && atomic_frame_count ==0 ))
		//{
			/*
			 *  Calling the Method from the Bean to get the Frame Names and the Size of the Frames
			 */
			/*ArrayList FrameCount = bean.getFrameCount(group_frame_count,profile_frame_count,atomic_frame_count);
			for(int i=0; i<FrameCount.size(); i++)
			{
 				String[] record 	= (String[])FrameCount.get(i);
 				frame_names 		= record[0]; // Name of the Frames to be used for global variable in JS
				frame_size 			= record[1]; // Size of the Frame;
				//group_frame 		= record[2]; // Size of the Group Frame
				//profile_frame		= record[3]; // Size of the Profile Frame
				//atomic_frame		= record[4]; // Size of the Atomic Frame
				group_display_size	= record[5]; // Records to be displayed in group frame
				profile_display_size= record[6]; // Records to be displayed in profile frame
				atomic_display_size	= record[7]; // Records to be displayed in atomic frame
			}*/
			 group_file_name		= "../../eOR/jsp/OrderEntryOrderSetResult.jsp?"+request.getQueryString()+"&group_frame_count=&display_records=&order_nature=S&order_catalog_nature="+order_catalog_nature;
			//if(atomic_frame_count > 0)
			   atomic_file_name		= "../../eOR/jsp/OrderEntryOrderSetResult.jsp?"+request.getQueryString()+"&atomic_frame_count=&display_records=&order_nature=A&order_catalog_nature="+order_catalog_nature;
			//if(profile_frame_count > 0)
			   profile_file_name	= "../../eOR/jsp/OrderEntryOrderSetResult.jsp?"+request.getQueryString()+"&profile_frame_count=&display_records=&order_nature=P&order_catalog_nature"+order_catalog_nature;
			 
			
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		//}
}	 	// 	End of for all
else if(order_catalog_nature.equals("A"))
	frame_names				= "Atomic";
else if(order_catalog_nature.equals("P"))
	frame_names				= "Profile";
else if(order_catalog_nature.equals("S"))
	frame_names				= "Group"; //OrderSets and also
//out.println("frame_names"+frame_names+"group_frame"+group_frame+"atomic_frame"+atomic_frame+"profile_frame"+profile_frame);
// if(!((group_frame_count == 0) && (profile_frame_count == 0)  && (atomic_frame_count ==0 ) )){
  if(order_catalog_nature.equals("")) // For All
   {
	// Below code change done for Edge Conversion 
	//start
	String style1 ="height:30vh;width:100vw";
    String style2 ="height:30vh;width:100vw";
    String style3 ="height:30vh;width:100vw";
   
    if (order_category.equals("RX")||order_category.equals("CN")||order_category.equals("OT"))
    {
    	style1 ="height:30vh;width:100vw;display: none;"; 
        style2 ="height:30vh;width:100vw;display: none;";  
    	style3 ="height:80vh;width:100vw";  
    }
    else if(order_category.equals("DS") || order_category.equals("PC") || order_category.equals("PH"))
    {
    	style1 ="height:49vh;width:100vw;"; 
        style2 ="height:0vh;width:100vw;display: none;";  
    	style3 ="height:49vh;width:100vw";  
    }
    //end	
    

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(frame_size));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(group_file_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(style1 ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(profile_file_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(style2 ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(atomic_file_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(style3 ));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } else if(order_catalog_nature.equals("A")) // For Atomic
   {

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(display_records));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_catalog_nature));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block22Bytes, _wl_block22);
 }else if(order_catalog_nature.equals("P")) // For Profile
   {

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(display_records));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_catalog_nature));
            _bw.write(_wl_block25Bytes, _wl_block25);
 }else if(order_catalog_nature.equals("S")) // For OrderSets and function not called from EXTERNAL_ORDER
   {

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(display_records));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_catalog_nature));
            _bw.write(_wl_block28Bytes, _wl_block28);
 }
else{
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(frame_names));
            _bw.write(_wl_block31Bytes, _wl_block31);

	// set it back persistence (since few set methods have been used to set values in bean)
	putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntryResultMain.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
