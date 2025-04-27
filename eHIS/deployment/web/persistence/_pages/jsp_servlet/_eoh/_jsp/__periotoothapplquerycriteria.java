package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class __periotoothapplquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioToothApplQueryCriteria.jsp", 1709119364317L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n\t<script language=\'JavaScript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> \n</head>\n<body onLoad=\"parent.commontoolbarFrame.document.forms[0].reset.disabled=true;\" OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	 request.setCharacterEncoding("UTF-8");
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
      String facility_id = (String)session.getValue( "facility_id" ) ;
        String  tooth_numbering_system="";
        String params = request.getParameter( "params" ) ;  
		String sortOrder =
		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"); 
		String select =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DefaultSelect.Label","oh_labels");
		String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");

		String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		//String chartid=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChartID.label","common_labels");
		String component_desc_user_def=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Component.label","oh_labels");
		String ns_tooth_no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothApplicable.Label","oh_labels");
		String chart_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChartID.label","common_labels");
		//String Required=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Required?.Label","oh_labels");
		//String chart_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		String status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");
		String PeriodontalChartSetup_function_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChartSetup.Label","oh_labels");


		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
		StringBuffer strbuff;

		String oh_chart_level = "";
		int i = 0;
		Connection con=null ;
		PreparedStatement pstmt=null;
        ResultSet rs=null;

		try {

				con  =  ConnectionManager.getConnection(request);
				//PreparedStatement pstmt=null;
	            //ResultSet rs=null;
				//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				//Based on the Chart Level the paramters need to be taken.
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			
				pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
				rs = pstmt.executeQuery();
				while (rs != null && rs.next()){
					oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
				}
				if(oh_chart_level.equals("E")){
					String sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM";
	 
					// int total=0;
					//int i=1;
					i=1;
					pstmt = con.prepareStatement(sql);
				}else{//End
					String sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
	 
					// int total=0;
					//int i=1;
					i=1;
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
				}
				rs = pstmt.executeQuery();
				while(rs.next()){
					tooth_numbering_system=rs.getString("TOOTH_NUMBERING_SYSTEM");
				}
				ArrayList finAr = new ArrayList();
				
				ArrayList firItem = new ArrayList();

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				firItem.add("List");           //Type of item
				firItem.add(chart_code);     // label
				firItem.add("chart_code");   //name of field
				firItem.add("SELECT CHART_CODE, CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR WHERE EFF_STATUS = 'E' ORDER BY CHART_DESC");   //name of field
				finAr.add(firItem);//add to ArrayList obj finAr
                
				ArrayList firstItem = new ArrayList();
				
				firstItem.add("List");           //Type of item
				firstItem.add(component_desc_user_def);     // label
				firstItem.add("component_desc_user_def");   //name of field
				firstItem.add("SELECT COMPONENT_CODE, COMPONENT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_COMP ORDER BY COMPONENT_DESC_USER_DEF");   //name of field
				/*firstItem.add("SELECT B.COMPONENT_CODE, A.COMPONENT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_COMP A, OH_PERIODONTAL_CHART_DEF_DTL B WHERE B.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE AND A.FORMULA_YN = 'N' ORDER BY COMPONENT_DESC_USER_DEF");   //name of field*/
				
				finAr.add(firstItem);//add to ArrayList obj finAr

				ArrayList secondItem = new ArrayList();

				secondItem.add("List");          //Type of item
				secondItem.add(ns_tooth_no);    // label
				secondItem.add("ns_tooth_no");  //name of field
				//secondItem.add("SELECT LPAD(TO_CHAR(NS_TOOTH_NO),2,'0') NS_TOOTH_NO, TO_CHAR(TOOTH_NO) TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = '"+tooth_numbering_system+"' AND TOOTH_NO IN (SELECT TOOTH_NO FROM OH_TOOTH WHERE PERMANENT_DECIDUOUS = 'P') UNION SELECT '*A' NS_TOOTH_NO, '*A' TOOTH_NO FROM DUAL ORDER BY NS_TOOTH_NO");  //name of field
				secondItem.add("SELECT TO_CHAR(TOOTH_NO) TOOTH_NO,LPAD(TO_CHAR(NS_TOOTH_NO),2,'0') NS_TOOTH_NO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = '"+tooth_numbering_system+"' AND  TOOTH_NO IN (SELECT TOOTH_NO FROM OH_TOOTH WHERE PERMANENT_DECIDUOUS = 'P') UNION SELECT '*A' NS_TOOTH_NO, '*A' TOOTH_NO FROM DUAL ORDER BY NS_TOOTH_NO");  //name of field

				
				//secondItem.add("30");   // SIZE
				//secondItem.add("30");   //LENGTH
				finAr.add(secondItem);    //add to ArrayList obj finAr

				ArrayList thirdItem = new ArrayList();

				thirdItem.add("List");   //Type of item
				thirdItem.add(status);  // label
				thirdItem.add("status");//name
				thirdItem.add("B,"+both+",Y,"+enabled+",N,"+disabled);//static values that need to be displayed as 
				finAr.add(thirdItem);

				String[] orderByCols=null;
				String[] orderByColVals=null;

				orderByCols = new String[3];
				orderByColVals = new String[3];

				orderByCols[0] = chart_code;
				orderByCols[1] = component_desc_user_def;
				orderByCols[2] = ns_tooth_no;

				orderByColVals[0] = "chart_code";
				orderByColVals[1] = "component_desc_user_def";
				orderByColVals[2] = "ns_tooth_no";

				strbuff = qrypg.getQueryPage( con,finAr,PeriodontalChartSetup_function_name ,"../../eOH/jsp/../../eOH/jsp/PerioToothApplQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

				out.println(strbuff.toString());
				} catch (Exception e) {}

		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(params));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
