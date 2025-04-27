package jsp_servlet._eds._jsp;

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
import java.util.ArrayList;
import java.net.URLEncoder;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __dspatienthistory extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DsPatientHistory.jsp", 1742465590000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\t<TITLE>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TITLE>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n\n\n\t</head>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<div id=\"mealPlan\">\n\t\n\t\t<table width=\'100%\' id=\"mealContentHeader\" >\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'5\' class=\"CAGROUP\" align=\"center\">Meal Contents - Food Items</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t\t\n\t\t<table  border=4 width=\'100%\' style=\'BORDER-STYLE:solid;\' id=\"mealContentTable\" >\n\t\t\t<tr>\n\t\t\t\t<th width=\'20%\' nowrap=\"nowrap\">Date and Time</th>\n\t\t\t\t<th width=\'20%\' nowrap=\"nowrap\">Diet Type</th>\n\t\t\t\t<th width=\'20%\' nowrap=\"nowrap\">Meal Type</th>\n\t\t\t\t<th width=\'20%\' nowrap=\"nowrap\">Meal Class</th>\n\t\t\t\t<th width=\'20%\' nowrap=\"nowrap\">Patient Served?</th>\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<!-- \t\t    \t\t<td colspan=\'5\' align=\'center\'>NO RECORDS FOUND</td> -->\n\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' width=\'10%\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\'8%\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'8%\' nowrap>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" />\n\t\t\t\t\t</td>\n\n\t\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</table>\n\t\t<br/><br/>\n\n\t</div>\n\t<div id=\"nonFreqSplFoodItem\">\n\n\t\t<table width=\'100%\' id=\"splFoodItemNonFreqHeader\" >\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'5\' class=\"CAGROUP\" align=\"center\">Special Food Items - Non Frequency Based</td>\n\t\t\t</tr>\n\t\t</table>\n\n\t\t<table  border=4 width=\'100%\' style=\'BORDER-STYLE:solid;\' id=\"nonFreqSplFoodItemContentTable\" >\n<!-- \t\t<table  border=\'2\' width=\'600\' align=\"center\" id=\"nonFreqSplFoodItemContentTable\" > -->\n\t\t\t<tr>\n\t\t\t\t<th width=\'20%\'  nowrap=\"nowrap\">Date and Time</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\"nowrap\">Meal Type</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\"nowrap\">Items</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\"nowrap\">Item Qty</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\"nowrap\">Patient Served?</th>\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<!-- \t\t    \t\t<td colspan=\'5\' align=\'center\'>NO RECORDS FOUND</td> -->\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'8%\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</table>\n\t\t<br/><br/>\n\n\t</div>\n\t<div id=\"freqSplFoodItem\">\n\n\t\t<table width=\'100%\' id=\"splFoodItemFreqHeader\" >\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'5\' class=\"CAGROUP\" align=\"center\">Special Food Items - Frequency Based</td>\n\t\t\t</tr>\n\t\t</table>\n\n\t\t\t<table  border=4 width=\'100%\' style=\'BORDER-STYLE:solid;\' id=\"freqSplFoodItemContentTable\" >\n<!-- \t\t<table  border=\'2\' width=\'600\' align=\"center\" id=\"freqSplFoodItemContentTable\"> -->\n\n\t\t\t<tr>\n\t\t\t\t<th width=\'20%\'  nowrap=\\\"nowrap\\\">Date and Time</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\\\"nowrap\\\">Scheduled Time</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\\\"nowrap\\\">Items</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\\\"nowrap\\\">Item Qty</th>\n\t\t\t\t<th width=\'20%\'  nowrap=\\\"nowrap\\\">Patient Served?</th>\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" />\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</table>\n\n\t</div>\n\t<input type=\'hidden\' name=\"encounter_Id\" id=\"encounter_Id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\'hidden\' name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\'hidden\' name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );
 
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
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);

		String encounter_Id=request.getParameter("episode_id");
		String facilityId = (String)session.getValue( "facility_id" );
		String locale = (String)session.getAttribute("LOCALE");

		Connection conn   = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs     = null ;
		String dateTime="",dietType="",mealClass="",mealType="",status="",classValue="",item="", itemQty="",scheduledTime="",src="";
		int maxRecord=0;

		String title = request.getParameter("title")==null?"":request.getParameter("title");

	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

			String sql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, dsdiettype3_.SHORT_DESC as col_2_0_, dsmealclas2_.SHORT_DESC as col_3_0_, dsmealtype1_.SHORT_DESC as col_4_0_, dsepsdmeal0_.STATUS as col_5_0_ from DS_EPSD_MEAL_PLAN_HDR_AUDIT dsepsdmeal0_, DS_MEAL_TYPE_LANG_VW dsmealtype1_, DS_MEAL_CLASS_LANG_VW dsmealclas2_, DS_DIET_TYPE_LANG_VW dsdiettype3_ where (dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(dsepsdmeal0_.MEAL_TYPE=dsmealtype1_.MEAL_TYPE )and(dsepsdmeal0_.MEAL_CLASS=dsmealclas2_.MEAL_CLASS )and(dsepsdmeal0_.DIET_TYPE=dsdiettype3_.DIET_TYPE )and(dsdiettype3_.LANGUAGE_ID='"+locale+"' )and(dsmealclas2_.LANGUAGE_ID='"+locale+"' )and(dsmealtype1_.LANGUAGE_ID='"+locale+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";


			try{
				conn			= ConnectionManager.getConnection(request);
				System.out.println("sql"+sql);
				pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				rs = pstmt.executeQuery();

				//getting maximum record
		    	rs.last();	maxRecord = rs.getRow();
		    	if(maxRecord == 0){ 
            _bw.write(_wl_block11Bytes, _wl_block11);
}
				//again move the resultset pointer to initial position
				rs.beforeFirst();
		    	int i=1;
				while(rs != null && rs.next()){
				dateTime=(rs.getString("col_1_0_"));
				dietType=(rs.getString("col_2_0_"));
				mealClass=(rs.getString("col_3_0_"));
				mealType=(rs.getString("col_4_0_"));
				status=(rs.getString("col_5_0_"));

				System.out.println("dateTime"+dateTime);
				System.out.println("dietType"+dietType);
				System.out.println("mealClass"+mealClass);
				System.out.println("mealType"+mealType);
				System.out.println("status"+status);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dietType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mealType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mealClass));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

					if(status.equals("MS"))
					{
							src="../../eCommon/images/enabled.gif";
					}
					else if(status.equals("MP"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					else if(status.equals("MR"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(src));
            _bw.write(_wl_block18Bytes, _wl_block18);

				classValue =(i%2==0)?"qryEven":"qryOdd";
				i++;
				}
			}
			catch(Exception e) {
			    e.printStackTrace();
	            System.err.println("Exception=="+e);
			}
			finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
	   		}
			
            _bw.write(_wl_block19Bytes, _wl_block19);

			String nonfreqSql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, dsepsdmeal0_.MEAL_TYPE as col_2_0_, dsmealtype2_.SHORT_DESC as col_3_0_, dsepsdmeal0_.ITEM_CODE as col_4_0_, dsitems1_.SHORT_DESC as col_5_0_, dsepsdmeal0_.ITEM_QTY as col_6_0_, dsepsdmeal0_.STATUS as col_7_0_ from DS_EPSD_MEAL_PLAN_SPL_AUDIT dsepsdmeal0_, DS_ITEMS dsitems1_, DS_MEAL_TYPE dsmealtype2_ where (dsepsdmeal0_.ITEM_CODE=dsitems1_.FOOD_ITEM_CODE )and(dsepsdmeal0_.MEAL_TYPE=dsmealtype2_.MEAL_TYPE )and (dsitems1_.language_id='"+locale+"') and (dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(dsepsdmeal0_.FREQ_YN='N' )and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";


			try{
				conn			= ConnectionManager.getConnection(request);
				System.out.println("nonfreqSql"+nonfreqSql);
				pstmt = conn.prepareStatement(nonfreqSql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				rs = pstmt.executeQuery();

				//getting maximum record
		    	rs.last();	maxRecord = rs.getRow();
		    	if(maxRecord == 0){
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
				//again move the resultset pointer to initial position
				rs.beforeFirst();
		    	int i=1;
				while(rs != null && rs.next()){
				dateTime=(rs.getString("col_1_0_"));
				mealType=(rs.getString("col_3_0_"));
				item=(rs.getString("col_5_0_"));
				itemQty=(rs.getString("col_6_0_"));
				status=(rs.getString("col_7_0_"));

				System.out.println("dateTime"+dateTime);
				System.out.println("mealType"+mealType);
				System.out.println("item"+item);
				System.out.println("itemQty"+itemQty);
				System.out.println("status"+status);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mealType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(itemQty));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);

					if(status.equals("MS"))
					{
							src="../../eCommon/images/enabled.gif";
					}
					else if(status.equals("MP"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					else if(status.equals("MR"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(src));
            _bw.write(_wl_block22Bytes, _wl_block22);

				classValue =(i%2==0)?"qryEven":"qryOdd";
				i++;
				}
			}
			catch(Exception e) {
			    e.printStackTrace();
	            System.err.println("Exception=="+e);
			}
			finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
	   		}
			
            _bw.write(_wl_block23Bytes, _wl_block23);

// 			String freqSql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, dsepsdmeal0_.MEAL_TYPE as col_2_0_, dsmealtype2_.SHORT_DESC as col_3_0_, dsepsdmeal0_.ITEM_CODE as col_4_0_, dsitems1_.SHORT_DESC as col_5_0_, dsepsdmeal0_.ITEM_QTY as col_6_0_, dsepsdmeal0_.STATUS as col_7_0_ from DS_EPSD_MEAL_PLAN_SPL_AUDIT dsepsdmeal0_, DS_ITEMS dsitems1_, DS_MEAL_TYPE dsmealtype2_ where (dsepsdmeal0_.ITEM_CODE=dsitems1_.FOOD_ITEM_CODE )and(dsepsdmeal0_.MEAL_TYPE=dsmealtype2_.MEAL_TYPE )and(dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(dsepsdmeal0_.FREQ_YN='N' )and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";
			String freqSql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, to_char(dsepsdmeal0_.SERVING_DATE, 'hh24:mi') as col_2_0_, dsepsdmeal0_.ITEM_CODE as col_3_0_, dsitems1_.SHORT_DESC as col_4_0_, dsepsdmeal0_.ITEM_QTY as col_5_0_, dsepsdmeal0_.STATUS as col_6_0_ from DS_EPSD_MEAL_PLAN_SPL_AUDIT dsepsdmeal0_, DS_ITEMS dsitems1_ where (dsepsdmeal0_.ITEM_CODE=dsitems1_.FOOD_ITEM_CODE )and(dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(dsepsdmeal0_.FREQ_YN='Y' )and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";


			try{
				conn			= ConnectionManager.getConnection(request);
				System.out.println("freqSql"+freqSql);
				pstmt = conn.prepareStatement(freqSql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				rs = pstmt.executeQuery();

				//getting maximum record
		    	rs.last();	maxRecord = rs.getRow();
		    	if(maxRecord == 0){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				//again move the resultset pointer to initial position
				rs.beforeFirst();
		    	int i=1;
				while(rs != null && rs.next()){
				dateTime=(rs.getString("col_1_0_"));
				scheduledTime=(rs.getString("col_2_0_"));
				item=(rs.getString("col_4_0_"));
				itemQty=(rs.getString("col_5_0_"));
				status=(rs.getString("col_6_0_"));

				System.out.println("dateTime"+dateTime);
				System.out.println("mealType"+scheduledTime);
				System.out.println("item"+item);
				System.out.println("itemQty"+itemQty);
				System.out.println("status"+status);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(scheduledTime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(itemQty));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);

					if(status.equals("MS"))
					{
							src="../../eCommon/images/enabled.gif";
					}
					else if(status.equals("MP"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					else if(status.equals("MR"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(src));
            _bw.write(_wl_block24Bytes, _wl_block24);

				classValue =(i%2==0)?"qryEven":"qryOdd";
				i++;
				}
			}
			catch(Exception e) {
			    e.printStackTrace();
	            System.err.println("Exception=="+e);
			}
			finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
	   		}
			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locale));
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
