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
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __mealstatisticsqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealStatisticsQueryResult.jsp", 1709116742000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\'javascript\' src=\'../../eDS/js/MealStatistics.js\'></script>\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</th>\n\t\t\t\t<!-- ML-MMOH-CRF-0902 -->\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</th>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<!-- ML-MMOH-CRF-0902 -->\n\t\t\t\t\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</th>\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</th>\n\t\t\t\t<th>\n\t\t\t\t\t<!--";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<!--ML-MMOH-CRF-406-->\n\t\t\t\t</th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</td></tr>\n</table>\n</center>\n\n<br><center>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</center>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try{
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String kitchenCode = request.getParameter("kitchen_code");
	String mealType =request.getParameter("meal_Type");
	String servDate =request.getParameter("serv_Date");

	String nursingUnit = "";
	String dietType = "";
	String noOfMeals= "";
	String attendants = "";
	//ML-MMOH-CRF-0902
	String menuType ="";
	//String menuTypeCount ="";
	String menuTypeTemp="";
	//ML-MMOH-CRF-0902
	int start = 0 ;
	int end = 0 ;
	int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);
	//ML-MMOH-CRF-0902
	boolean isMenuType = false;
	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	//ML-MMOH-CRF-0902
	//ML-MMOH-SCF-2071
	boolean isMealStat = false;
	isMealStat = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_STAT_QUERY");
	//ML-MMOH-SCF-2071
	PreparedStatement stmt = null;
	int maxRecord = 0;
	ResultSet rset=null;
	//ML-MMOH-CRF-406
	PreparedStatement stmt1 = null,pstmt1=null;
	ResultSet rs = null,rs1=null;
	String DS_Param_Sql="select Attendent_Label_Name from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
	String Attendent_Label_Name="";
	//ML-MMOH-CRF-0406
	try{
		String strsql = "select count(*) total "+
						"from Ds_Daily_Meal_Statistics mealstat "+
						"where mealstat.kitchen_Code = '"+kitchenCode+"' and mealstat.meal_Type = '"+mealType+"' "+
						"and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id like '"+locale+"' ";

				
		String strsql1="";		
		if(!isMenuType){
			strsql1 = "select mealstat.cur_Ward_Code,mealstat.diet_Type,mealstat.patient_Meals,"+
						"mealstat.att_Meals, null menu_type_desc "+
						"from Ds_Daily_Meal_Statistics mealstat "+
						"where mealstat.kitchen_Code = '"+kitchenCode+"' and mealstat.meal_Type = '"+mealType+"' "+
						"and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id like '"+locale+"' order by mealstat.cur_Ward_Code, mealstat.diet_Type ";			
		}
		else if(!isMealStat) // Added Against ML-MMOH-SCF-2071
			{
			strsql1 = "SELECT   cur_ward_code, diet_type, patient_meals, att_meals, wm_concat (menu_type_desc || ' - ' || menu_type_cnt) menu_type_desc "+
			  "FROM (SELECT   mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type UNION "+
			  "SELECT mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr_attnd a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type) WHERE menu_type_desc IS NOT NULL GROUP BY cur_ward_code, diet_type,"+
			  "patient_meals, att_meals order by cur_ward_code, diet_type";			
			}
			else
			{
			strsql1 = "SELECT   cur_ward_code, diet_type, patient_meals, att_meals, LISTAGG (menu_type_desc || ' - ' || menu_type_cnt) menu_type_desc "+
			  "FROM (SELECT   mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type UNION "+
			  "SELECT mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr_attnd a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type) WHERE menu_type_desc IS NOT NULL GROUP BY cur_ward_code, diet_type,"+
			  "patient_meals, att_meals order by cur_ward_code, diet_type";	
			}
			
		System.err.println("strsql1====>"+strsql1);
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");//GDOH-SCF-0160
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	
		//ML-ML-MMOH-CRF-0406 STARTS
		pstmt1 = conn.prepareStatement(DS_Param_Sql);
		rs1=pstmt1.executeQuery();
		if(rs1.next()){
			Attendent_Label_Name=rs1.getString("Attendent_Label_Name");
		}
		//ML-MMOH-CRF-0406 ENDS		
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("92->MealStatisticsQueryResult.jsp"+e.getMessage());
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/MealStatisticsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&kitchen_code="+kitchenCode+"&meal_Type="+mealType+"&serv_Date="+servDate+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MealStatisticsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&kitchen_code="+kitchenCode+"&meal_Type="+mealType+"&serv_Date="+servDate+ "'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
				
				if(isMenuType){
				
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				}
				
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block17Bytes, _wl_block17);

	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rset.next() ;
	String classValue= " ";
	while ( rset.next() && i<=end  )
	{
		menuTypeTemp = "";//ML-MMOH-CRF-0902
    if ( i % 2 == 0 )
		classValue = "QRYEVEN";
	else
		classValue = "QRYODD";
		out.println("<tr>");

    nursingUnit = rset.getString("cur_Ward_Code");
    dietType =rset.getString("diet_Type");
    noOfMeals= rset.getString("patient_Meals");
    attendants = rset.getString("att_Meals");

	//ML-MMOH-CRF-0902
	if(isMenuType){
	menuType =checkForNull(rset.getString("menu_type_desc"));
	}
	//ML-MMOH-CRF-0902

	int rowId=1;
	out.println("<td class='" + classValue+"' nowrap>"+nursingUnit+"</td>");
	//ML-MMOH-CRF-0902
	if(isMenuType){
	out.println("<td class='" + classValue+"' nowrap>"+menuType+"&nbsp;</td>");
	}
	//ML-MMOH-CRF-0902
	    out.println("<td class='" + classValue+"' nowrap>"+dietType+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+noOfMeals+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+attendants+"</td>");
	out.println("</tr>");
	rowId++;
	i++;
} 
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	e.printStackTrace();
	System.err.println("179->MealStatisticsQueryResult.jsp===>"+e.getMessage());
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NursingUnit.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoOfMeals.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Attendents.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
