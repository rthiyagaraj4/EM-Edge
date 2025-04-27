package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eSS.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.Common.*;

public final class __groupquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/GroupQueryCriteria.jsp", 1709117474399L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n<html>\n     <head>\n\t \t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t </head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

 String locale			= (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn = false ; 
	try {
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); //END 
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );
		String grp_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupCode.label","ss_labels");
		String grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupDescription.label","ss_labels");
		String grp_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupType.label","ss_labels");
		String surg_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.SurgeryType.label","ss_labels");
		String usg_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UsageType.label","ss_labels");
		String non_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Non-returnable.label","ss_labels");
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	    String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	    String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
       
		String All_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String Set_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Set.label","ss_labels");
		String Tray_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Tray.label","ss_labels");
		String SPack_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.SoftPack.label","ss_labels");
		String Single_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels");
		String Linen_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Linen.label","ss_labels"); //mmoh-crf-1661  
		String Yes_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String No_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		String grp_type_list = "";//MMOH-CRF-1661 
		if(linen_applicable_yn){  
			 grp_type_list="%,"+All_legend+",E,"+Set_legend+",T,"+Tray_legend+",P,"+SPack_legend+",S,"+Single_legend+",L,"+Linen_legend; 
		}else{
			 grp_type_list="%,"+All_legend+",E,"+Set_legend+",T,"+Tray_legend+",P,"+SPack_legend+",S,"+Single_legend;	
		}//end 
		 
		String Non_return_list="%,"+Both_legend+",Y,"+Yes_legend+",N,"+No_legend;
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();

		items.add("Text");
		items.add(grp_code);
		items.add("group_code");
		items.add("10");
		items.add("10");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(grp_desc);
		items.add("long_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		items.add("List");
		items.add(grp_type);
		items.add("group_type");
		items.add(grp_type_list);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("List");		 //Type of item
		items.add(surg_type);	// label
		items.add("surgery_type");   //name of field
		items.add(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_SELECT_LIST"));
		ArrayList alParameter	=	new ArrayList(1);
		alParameter.add(locale);
		items.add(alParameter);
		components .add(items);

		items=new ArrayList();
		items.add("List");		 //Type of item
		items.add(usg_type);	// label
		items.add("usage_type");   //name of field
		items.add(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_USAGE_TYPE_SELECT_LIST"));
		ArrayList alParameter1=	new ArrayList(1);
		alParameter1.add(locale);
		items.add(alParameter1);
		components .add(items);
		
		items=new ArrayList();
		items.add("List");
		items.add(non_return);
		items.add("non_returnable_yn");
		items.add(Non_return_list);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("List");
		items.add(Nature);
		items.add("eff_status");
		items.add(Nature_List);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[2];
		headers[0] = grp_code;
		headers[1] = grp_desc;

		String[] values = new String[2];
		values[0]="group_code";
		values[1]="long_desc";

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String grop=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Group.label","common_labels");

		htmlTag = queryPage.getQueryPage((( java.util.Properties ) session.getValue("jdbc")),components,grop ,"../../eSS/jsp/GroupQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery,true);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);//END
	}
	

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
