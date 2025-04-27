package jsp_servlet._exh._jsp;

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
import eXH.XHDBAdapter;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispitemsformachinecodesqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DispItemsForMachineCodesQueryResult.jsp", 1709122324117L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HEAD>  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\t\t\t\t\t  \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\n<Script Language=\"JavaScript\" src=\"../../eXH/js/DispenseItemMachineCodes.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<Script>\nfunction chkSelectFlag(obj){\n\n\tselect_val = document.forms[0].select_flag.value;\n\n    if(obj.value==\'Y\'){\n\t\tdocument.forms[0].select_flag.value = \'Y\';\n\t}\n\telse if(select_val!=\'Y\'){\n\t\tdocument.forms[0].select_flag.value = \'N\';\n\t}\n}\nfunction funModify(facility, disp_locn, machine, item, high_alert_drug, pack_only_exp, rowCount, facilityName, dispLocnName, machineName, itemName)\n{\n\t\n\tvar mode = \"Modify\";\n\t//alert(\"funModify..\"+parent.f_query_add_mod.location.href);\n\t\n\tparent.f_query_add_mod.location.href = \"../../eXH/jsp/ItemForAutoDispenserMain.jsp?mode=\" + mode+\"&facility_id=\"+facility+\"&disp_locn=\"+disp_locn+\"&machine_code=\"+machine+\"&item_desc=\"+item+\"&high_alert_yn=\"+high_alert_drug+\"&pack_only_yn=\"+pack_only_exp+\"&facilityName=\"+facilityName+\"&dispLocnName=\"+dispLocnName+\"&machineName=\"+machineName+\"&itemName=\"+itemName;\n\t\n\t\n}\n</Script>\n<BODY  leftmargin=0 topmargin=0  bgcolor=\'#F0F0F2\' onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' >\n<body onLoad=\"\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"AuthorisedUsers_Result\" id=\"AuthorisedUsers_Result\" target=\'\' method=\'post\' action=\'\'>\n<!-- <input type=\"hidden\" name=\"mode\" id=\"mode\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'/>-->\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\'\'/>\n<input type=\"hidden\" name=\"Machine_code\" id=\"Machine_code\" />\n<input type=\"hidden\" name=\"Patient_class\" id=\"Patient_class\" />\n<input type=\"hidden\" name=\"Long_desc\" id=\"Long_desc\" />\n<input type=\"hidden\" name=\"Short_desc\" id=\"Short_desc\" />\n<input type=\"hidden\" name=\"eff_status\" id=\"eff_status\" />\n <br>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\tthis.document.forms[0].mode.value=\'E\';\n\t\talert(getMessage(\"XH1021\",\"XH\"));history.go(-1);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\n<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n<!--<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>-->\n\n\n\n   \t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
 String locale = ((String)session.getAttribute("LOCALE")); 
 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con=null;
Statement stmt=null;
ResultSet rs=null;
int rowCount=0;

String   classValue="";
String facilityId = "";
String DispLocnCode = "";
String MachineCode = "";
String ItemCode = "";
String HighAlertDrugYN = "";
String PackOnlyExpensiveDrugYN = "";
String EFFStatus = "";
String class_val = "";
String select = "";


String mode=request.getParameter("mode");
String user_id=XHDBAdapter.checkNull(request.getParameter("user_id"));

String disp_locn_code = XHDBAdapter.checkNull(request.getParameter("disp_locn_code"));
String machine_code =  XHDBAdapter.checkNull(request.getParameter("machine_code"));	
String item_code = XHDBAdapter.checkNull(request.getParameter("item_code"));
System.out.println("disp_locn_code.."+disp_locn_code+"..machine_code.."+machine_code+"...item_code.."+item_code);

String disp_locn_desc = XHDBAdapter.checkNull(request.getParameter("disp_locn_desc"));
String machine_desc = XHDBAdapter.checkNull(request.getParameter("machine_desc"));
String item_desc = XHDBAdapter.checkNull(request.getParameter("item_desc"));

//appending order by clause
	//String ord[] = request.getParameterValues("orderbycolumns");
	//System.out.println("Orderby...."+ord[0]);
	//System.out.println("orderbycolumns...."+request.getParameterValues("orderbycolumns"));


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);


try{
		con=ConnectionManager.getConnection();
		StringBuffer whereClause = new StringBuffer();
		StringBuffer whereCond = new StringBuffer();
		String sql = "";
		boolean flag = false;
		
		//sql = "SELECT FACILITY_ID, DISP_LOCN_CODE, MACHINE_CODE, ITEM_CODE, HIGH_ALERT_DRUG_YN, PACK_ONLY_EXPENSIVE_DRUG_YN FROM XH_DISP_LOCN_MACHINES";
		sql = "SELECT FACILITY_ID, DISP_LOCN_CODE, MACHINE_CODE, ITEM_CODE, HIGH_ALERT_DRUG_YN, PACK_ONLY_EXPENSIVE_DRUG_YN, facility_name, disp_locn_name, item_name, machine_name FROM xh_disp_mach_vw";

		if(disp_locn_code.length() != 0 || item_code.length() != 0 || machine_code.length() != 0 || disp_locn_desc.length() != 0 || machine_desc.length() != 0 || item_desc.length() != 0){
			
			whereClause.append(" where ");
			if(disp_locn_code.length() != 0){
				
				flag = true;
				whereCond.append("UPPER(DISP_LOCN_CODE) = UPPER('"+disp_locn_code+"')");
				/*if(item_code.length() !=0){
					whereCond.append(" AND UPPER(ITEM_CODE) = UPPER('"+item_code+"')");
				}*/
			} if(item_code.length() != 0 && flag){
				whereCond.append(" AND UPPER(ITEM_CODE) = UPPER('"+item_code+"')");
			}else if(item_code.length() != 0){
				System.out.println("machine_code not equal to zero..");
				flag = true;
				whereCond.append(" UPPER(ITEM_CODE) = UPPER('"+item_code+"')");
			}
			if(machine_code.length() != 0 && flag){
				whereCond.append(" AND UPPER(MACHINE_CODE) = UPPER('"+machine_code+"')");
			}else if(machine_code.length() != 0){
				System.out.println("machine_code not equal to zero..");
				flag = true;
				whereCond.append(" UPPER(MACHINE_CODE) = UPPER('"+machine_code+"')");
			}

			//Desc code start
			if(disp_locn_desc.length() != 0 && flag){
				whereCond.append(" AND UPPER(DISP_LOCN_NAME) = UPPER('"+disp_locn_desc+"')");
			}else if(disp_locn_desc.length() != 0){
				
				flag = true;
				whereCond.append(" UPPER(DISP_LOCN_NAME) = UPPER('"+disp_locn_desc+"')");
			}
			if(machine_desc.length() != 0 && flag){
				whereCond.append(" AND UPPER(MACHINE_NAME) = UPPER('"+machine_desc+"')");
			}else if(machine_desc.length() != 0){
				
				flag = true;
				whereCond.append(" UPPER(MACHINE_NAME) = UPPER('"+machine_desc+"')");
			}

			if(item_desc.length() != 0 && flag){
				whereCond.append(" AND UPPER(ITEM_NAME) = UPPER('"+item_desc+"')");
			}else if(item_desc.length() != 0){
				
				//flag = true;
				whereCond.append(" UPPER(ITEM_NAME) = UPPER('"+item_desc+"')");
			}
			// end

			whereClause.append(whereCond);

			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) )
			{
				whereClause.append(" order by ");

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					whereClause.append(ord[i]);
				else
					whereClause.append(ord[i]+",");
				}
			}
				
			sql = sql + whereClause.toString();	

			//order by 

		}else {
			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) )
			{
				//whereClause.append(" order by ");
				sql = sql + " order by ";

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					//whereClause.append(ord[i]);
					sql = sql + ord[i];
				else
					//whereClause.append(ord[i]+",");
					sql = sql + ord[i]+",";
				}
			}


			sql = sql.toString();
		}



		System.out.println("MachineForAutoDispenserQueryResult..."+sql);
		System.out.println("MachineForAutoDispenserQueryResult...whereCond..."+whereCond);
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.last(); 
		if(rs.getRow()==0)
	    { 
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		else{
		
		rs.beforeFirst();
	   
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

  
		while(rs.next()) 
		{
			if ( rowCount % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			
			
			facilityId = rs.getString(1);
			DispLocnCode = rs.getString(2);
			MachineCode = rs.getString(3);
			ItemCode = rs.getString(4);
			HighAlertDrugYN = rs.getString(5);
			PackOnlyExpensiveDrugYN = rs.getString(6);

			String facility_name = "";
			String disp_locn_name = "";
			String item_name = "";
			String machine_name = "";
			facility_name = rs.getString(7);
			disp_locn_name = rs.getString(8);
			item_name = rs.getString(9);
			machine_name = rs.getString(10);

			System.out.println("DispItemsForMachineCodesQueryResults facility_name :: "+facility_name+" :: disp_locn_name :: "+disp_locn_name+" :: item_name :: "+item_name+" :: machine_name :: "+machine_name);
			
            _bw.write(_wl_block16Bytes, _wl_block16);

				rowCount++;
			//out.println("<script>fetchStatusValue('"+status.toUpperCase()+"');</script>");

	out.println("<tr>");
	out.println("<td id='"+"facilityId"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:funModify('"+facilityId+"','"+DispLocnCode+"','"+MachineCode+"','"+ItemCode+"','"+HighAlertDrugYN+"','"+PackOnlyExpensiveDrugYN+"','"+rowCount+"','"+facility_name+"','"+disp_locn_name+"','"+machine_name+"','"+item_name+"');\">"+facility_name+"</a></td><input type='hidden' name='"+"hid_item_slr"+rowCount+"' id='"+"hid_item_slr"+rowCount+"' value='"+facilityId+"'/>");

	out.println("<td id='"+"DispLocnCode"+rowCount+"' class='"+class_val+"'>"+disp_locn_name+"</td><input type='hidden' name='"+"hid_item_Type"+rowCount+"' id='"+"hid_item_Type"+rowCount+"' value='"+DispLocnCode+"'/>");

	out.println("<td id='"+"MachineCode"+rowCount+"' class='"+class_val+"'>"+machine_name+"</td><input type='hidden' name='"+"hid_item_Code"+rowCount+"' id='"+"hid_item_Code"+rowCount+"' value='"+MachineCode+"'/>");

	out.println("<td id='"+"ItemCode"+rowCount+"' class='"+class_val+"'>"+item_name+"</td><input type='hidden' name='"+"hid_item_Qty"+rowCount+"' id='"+"hid_item_Qty"+rowCount+"' value='"+ItemCode+"'/>");

	out.println("<td id='"+"HighAlertDrugYN"+rowCount+"' class='"+class_val+"'>"+HighAlertDrugYN+"</td><input type='hidden' name='"+"hid_spl_Food_Item_Yn"+rowCount+"' id='"+"hid_spl_Food_Item_Yn"+rowCount+"' value='"+HighAlertDrugYN+"'/>");

	out.println("<td id='"+"PackOnlyExpensiveDrugYN"+rowCount+"' class='"+class_val+"'>"+PackOnlyExpensiveDrugYN+"</td><input type='hidden' name='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' value='update'/><input type='hidden' name='"+"hid_freq_Yn"+rowCount+"' id='"+"hid_freq_Yn"+rowCount+"' value='"+PackOnlyExpensiveDrugYN+"'/>");

	//out.println("<td id='"+"select"+rowCount+"' class='"+class_val+"'>"+select+"<input type='checkbox' name='"+"selectBox"+rowCount+"' id='"+"selectBox"+rowCount+"' value='"+select+"' /><input type='hidden' name='"+"hid_selectBox"+rowCount+"' id='"+"hid_selectBox"+rowCount+"' /></td>");

	out.println("</tr>");

		}
		}
}catch(Exception e1)
{
		System.out.println("(MachineForAutoDispenserQueryResult.jsp:Error) :  "+e1.toString());
		e1.printStackTrace();
}
finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("(MachineForAutoDispenserQueryResult.jsp:Error) : "+e);
				}
			}
		

            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.FacilityID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.DispLocnCode.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Machine.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.item.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.HighAlertDrugYN.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.PackOnlyExpensiveDrugYN.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
