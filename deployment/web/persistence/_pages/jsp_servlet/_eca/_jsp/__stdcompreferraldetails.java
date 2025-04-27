package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __stdcompreferraldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/STDCompReferralDetails.jsp", 1736157593370L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCA/js/STDCompReferralDetails.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onKeyDown=\'lockKey()\'>\n\t\t<form name=\'refDetailsForm\' id=\'refDetailsForm\'>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t</form>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

				String encounterID = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
				//out.println("<script>alert('"+encounterID+"')</script>");
				String facilityID = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");

				String radBtnVal = request.getParameter("radBtnVal") == null ? "C" : request.getParameter("radBtnVal");

				String hCareDesc = "";
				String referralDesc = "";
				String specilatyDesc = "";
				String referralType = "";
				String locationDesc = "";
				//String locationCode = "";
				String classValue = "";
				int i = 0;

				PreparedStatement pstmt = null;
				ResultSet res = null;
				Connection con = null;				
				
	try
		{
			con = ConnectionManager.getConnection(request);

				if(radBtnVal.equals("C"))
				{
			
            _bw.write(_wl_block9Bytes, _wl_block9);

					String sql = "select      decode(a.TO_REF_TYPE,'L','Login Facility','E','Enterprise','X','External') ref_type   , d.SHORT_DESC to_hcare_setting_type_desc  , c.SHORT_DESC specialty_desc  , case when a.TO_REF_TYPE='X' then 	(select b.short_desc from am_referral b where b.REFERRAL_CODE=a.to_ref_code)	 when a.TO_REF_TYPE in ('E','L') then	(select facility_name from sm_facility_param where facility_id = a.TO_FACILITY_ID)    end  ref_desc  , case when a.TO_REF_TYPE='X' then a.TO_LOCN_DESC         when a.TO_LOCN_TYPE in ('C','Y','E') then	   (select LONG_DESC from op_clinic where Facility_id=a.TO_FACILITY_ID and clinic_code=a.TO_LOCN_CODE)	when a.TO_LOCN_TYPE in ('N') then	   (select LONG_DESC from ip_nursing_unit where Facility_id=a.TO_FACILITY_ID and Nursing_unit_code=a.TO_LOCN_CODE)    end locn_desc   , a.TO_REF_CODE  , a.TO_HCARE_SETTING_TYPE  , a.TO_LOCN_TYPE  , a.TO_LOCN_CODE  , a.TO_SPECIALITY_CODE from   pr_referral_register a, am_speciality c, am_hcare_setting_type d where     a.FROM_FACILITY_ID=? AND a.FROM_ENCOUNTER_ID = ? and a.TO_HCARE_SETTING_TYPE = d.HCARE_SETTING_TYPE_CODE  and a.TO_SPECIALITY_CODE = c.SPECIALITY_CODE  ";
					
					
					try
					{
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1,facilityID);
						pstmt.setString(2,encounterID);
						res = pstmt.executeQuery();
						out.println("<tr>");
						out.println("<td class='columnheadercenter'></td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraltype.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HealthcareSettingType.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralsource.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td>");
						out.println("</tr>");
						while(res.next())
						{
							hCareDesc = res.getString("to_hcare_setting_type_desc") == null ? "" : res.getString("to_hcare_setting_type_desc");
							referralDesc = res.getString("ref_desc") == null ? "&nbsp;" : res.getString("ref_desc");
							referralType = res.getString("ref_type") == null ? "&nbsp;" : res.getString("ref_type");
							locationDesc = res.getString("locn_desc") == null ? "&nbsp;" : res.getString("locn_desc");
							specilatyDesc = res.getString("specialty_desc") == null ? "&nbsp;" : res.getString("specialty_desc");

							if(i % 2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";				
						
							out.println("<tr>");
							out.println("<td class=\""+classValue+"\"><input type=checkbox name='chk"+i+"' id='chk"+i+"'></td>");
							out.println("<td class=\""+classValue+"\" id='tdID1"+i+"' >"+referralType.trim()+"");
							out.println("<td class=\""+classValue+"\" id='tdID2"+i+"'  >"+hCareDesc+"</td>");
							out.println("<td class=\""+classValue+"\" id='tdID3"+i+"' >"+referralDesc+"</td>");
							out.println("<td class=\""+classValue+"\" id='tdID4"+i+"'  >"+specilatyDesc+"</td>");
							out.println("<td class=\""+classValue+"\" id='tdID5"+i+"' >"+locationDesc+"</td>");
							out.println("</tr>");
							i++;
						}
						if(res!=null) res.close();
						if(pstmt!=null) pstmt.close();

					}
					catch(Exception e)
					{
						//out.println("Exception in referralDetails ---"+e.toString());//common-icn-0181
						e.printStackTrace();
					}
									
				
            _bw.write(_wl_block10Bytes, _wl_block10);

				}//if of else - radBtnVal
				else
				{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

					//String specialty = "";
					//String hcareSettingType = "";
					//String referralSource = "";

					String sql = "";
					sql = "SELECT hcare_setting_type_code,short_desc FROM am_hcare_setting_type WHERE eff_status='E' ORDER BY 2";
					
					
					out.println("<tr>");
					out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraltype.label","common_labels")+"&nbsp;</td>");
					out.println("<td class='fields' width='25%'><select name='referralType' id='referralType' onChange='changeRefSource(this)'>");
					out.println("<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
					out.println("<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels")+"</option>");
					out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels")+"</option>");
					out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels")+"</option>");
					out.println("</select></td></tr>");

					try
					{
					
						pstmt = con.prepareStatement(sql);
						res = pstmt.executeQuery();
						out.println("<tr>");
						out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HealthcareSettingType.label","common_labels")+" &nbsp;</td>");
						out.println("<td class='fields' width='25%'><select name='healthCareSettingType' id='healthCareSettingType'>");
						out.println("<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
						try
						{
							pstmt = con.prepareStatement(sql);
							res = pstmt.executeQuery();
						
							while(res.next())
							{
								out.println("<option value="+res.getString(1)+"> "+res.getString(2)+" </option>");
							}
							if(res != null) res.close();
							if(pstmt != null) pstmt.close();
							
							out.println("</select></td></tr>");
							sql = "";
						}
						catch(Exception e)
						{
							//out.println("Exception in HCareSettingType Of STDCompReferralDetails.jsp --"+e.toString());//COMMON-ICN-0181
							e.printStackTrace();
						}
						
						out.println("<tr>");
						out.println("<td class = 'label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralsource.label","common_labels")+"</td>");
						out.println("<td class = 'fields' width='25%' ><select name='referralSource' id='referralSource' id='refSource'>");
						out.println("<option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
						
						out.println("</select></td></tr>");
						out.println("<tr>");

						out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</td>");
						out.println("<td class='fields' width='25%'><select name='specialty' id='specialty'	onChange='clear_Locn(this)'>");
						out.println("<option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
						
						sql = "Select Short_Desc,Speciality_Code from Am_Speciality where Eff_Status = 'E' order by 1";

						try
						{	
							pstmt = con.prepareStatement(sql);
							res = pstmt.executeQuery();

							while(res.next())
							{
								out.println("<option value="+res.getString(2)+"> "+res.getString(1)+" </option>");
							}
							if(res != null) res.close();
							if(pstmt != null) pstmt.close();

							sql = "";
							out.println("</select></td></tr>");
						}
						catch(Exception e)
						{
							//out.println("Exception in Specialty of STDCompReferralDetails.jsp --"+e.toString());//common-icn-0181
							e.printStackTrace();
						}
						
						out.println("<tr>");
						out.println("<td class ='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td>");
						out.println("<td class ='fields' width='25%'><select name='locationVal' id='locationVal' style='display' onchange='clear_Locn(this);populateLocnVals(this);' > ");
						out.println("<option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
						out.println("</select><select name='locationValues2' id='locationValues2' style='display'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option></select><input type='text' name='locnText' id='locnText' style='display:none' size=30 maxlength=30 onBlur = 'makeValidString(this)'></td>");
						out.println("</tr>");
						
					}
					catch(Exception e)
					{
						//out.println("Exception in STDCompReferralDetails.jsp -- else --"+e.toString());//common-icn-0181
						e.printStackTrace();
					}

				}//end of else - radBtnVal
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
	catch(Exception e)
	{
		//out.println("Exception @ final block STDCompReferralDetails.jsp "+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
