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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __orderentryorderformatcontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryOrderFormatControl.jsp", 1734427158000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n    <head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/></link>\n        <script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n        <script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n        <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOR/js/OrderEntry1.js\' ></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n    </head>\n    <body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n    <br><br>\n    <form name=\"OrderEntryFormatControl\" id=\"OrderEntryFormatControl\" method=\"post\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</form>\n\t</body>\n    </head>\n   \t<script language=\"javascript\">\n     window.returnValue = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"\n \t parent.window.close();\n   \t//parent.parent.document.querySelectorAll(\"#dialog-body\")[parent.parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n   \t//parent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t</script>\n\n\n\n\n  </html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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

/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
?             100            ?           	?				?				created
29/07/2011    IN027169      Chowminya G 	?				?				Incident No: IN027169 - <OrderFormat Dependency fields alignment issue> 
01/10/2012    IN035189      Dinesh T		?				?				Thai Date conversions problem in normal and amend mode
27/09/2013	  IN043095		Nijitha S		?				?				CRF-OT-Bru-HIMS-CRF-004.2/02- Booking Priority field in not displayed for "System defined" order entry format item
11/12/2013    IN045512		Nijithas	    ?				?				The dependent field option is not displayed in View Order Format
15/01/2014	  IN045798		Chowminya		?				?				The Original alignment of the Order format Items are getting changed in the Order format screen
17/02/2014	  IN024984		Karthi		21/02/2014		  Ramesh G			Conditional reordering by clinician
01/08/2014	  IN049133	    Chowminya										CRF:Disallow user to enter the future date in the LMP date field
28/10/2014	  IN045340		Karthi											Order format details are not displayed while releasing order by preview.	
------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String 	bean_id		= request.getParameter("bean_id");
    String 	bean_name	= request.getParameter("bean_name");
	/* Initialize Function specific start */
	OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	/* Initialize Function specific end */

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String 			catalog_code		= bean.checkForNull(request.getParameter("catalog_code"),"");
    String			order_category		= bean.checkForNull(request.getParameter("order_category"),"");
   	String 			row_value			= bean.checkForNull(request.getParameter("row_value"),"");
    String 			mode				= bean.checkForNull(request.getParameter("mode"),"");
    String 			mandatory_check 	= bean.checkForNull(request.getParameter("mandatory_check"),"");
    String 			called_from		 	= bean.checkForNull(request.getParameter("called_from"),"");
    //String 			order_format_header_onload		 	= bean.checkForNull(request.getParameter("order_format_onload"),"");//IN045512
    //String 			order_format_line_onload		 	= bean.checkForNull(request.getParameter("order_format_line_onload"),"");//IN045512
    //String order_format_onload = "";//IN045512
	//String 			catalog_code1		= bean.checkForNull(request.getParameter("catalog_code1"),"");
	int 			total_rows        	= Integer.parseInt(bean.checkForNull(request.getParameter("total_rows"),"0"));
    int 		    new_seq_num	= 0;
    int 			count				= 0;
    ArrayList arrSeqNo					= new ArrayList();
	int EnableEmail=0;
	Hashtable		template			= new Hashtable();
	String 			field_mnemonic		= "",  label_text 			= "",discr_msr_uom="";
	String 			accept_option		= "",  dflt_value 			= "";
	String 			field_type			= ""; 	
	String			name_key			= "";
	String 			order_type_code		= "";
	String 			parent_field_mnemonic= "";
	String 			field_values		= "",field_values_oth_desc="";
	String field_mnemonic_action		= "", field_action_msg		= "";	
	String			notify_yn			= "N";String field_value_type	="";
	String			single_or_multi		= "";

	String 			ind_catalog_code 	= "",ind_row_value	= "";
	ArrayList		OrderFormatTypes	= new ArrayList();
	String 			catalog_code_arr[] 	= new String[total_rows];
	String mnemonicCode="";
	String mnemonicDesc="";
	String default_value = "";//IN045798
	String oth_dependency_yn = "N";//IN049133
	// added for  IN024984 - START
	HashMap duplicate_catalog_reason	= null;
	
	duplicate_catalog_reason = bean.getDupeReasonHashMap();
	
	if(duplicate_catalog_reason != null)
	{
		duplicate_catalog_reason.clear();
	}
	// added for  IN024984 - END
	//if((!called_from.equals("")) && (called_from.equals("HEADER") || called_from.equals("ORDER_SET_HEADER")) )   // Only for the Order Entry Header Level -- //  Commented for  - IN045340
	if((!called_from.equals("")) && (called_from.equals("HEADER") || called_from.equals("ORDER_SET_HEADER") || called_from.equals("PREVIEW_HEADER")) )   // Only for the Order Entry Header Level -- //  Modified for  - IN045340
	{
		if(!called_from.equals("ORDER_SET_HEADER"))
		{
			OrderFormatTypes				= (ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE"+order_category, "0");
		}
		else //For Order Set Header
		{
			OrderFormatTypes				= (ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE_CARE_SET"+order_category, "0");
		}
	}
	else OrderFormatTypes.add("0"); // To execute the loop only once for the Line Level
		
		
        if(mode.equalsIgnoreCase("REMOVE"))
        {
			if(!called_from.equals("LINE_LEVEL") && OrderFormatTypes!=null && OrderFormatTypes.size() > 0) //Other than header there will be only one loop
			{
				for(count=0;count<OrderFormatTypes.size();count++)	// Only one loop for line level
				{
					//if((!called_from.equals("")) && (called_from.equals("HEADER") || called_from.equals("ORDER_SET_HEADER")))   // Only for the Order Entry Header Level  //  Commented for  - IN045340
					if((!called_from.equals("")) && (called_from.equals("HEADER") || called_from.equals("ORDER_SET_HEADER") || called_from.equals("PREVIEW_HEADER")))   // Only for the Order Entry Header Level  //  Modified for  - IN045340
					{
						String[] order_type_records = (String[])OrderFormatTypes.get(count);
						order_type_code			= order_type_records[1];
						if(order_type_code!=null && order_type_code.equals("ALL"))
							order_type_code		= "";
						if(!called_from.equals("ORDER_SET_HEADER"))
							ind_catalog_code	= order_type_code+catalog_code; // For other Header Orders
						else
							ind_catalog_code	= "ORDER_SET"+order_type_code+catalog_code;
					}
					else
					{
						order_type_code			= "";
						ind_catalog_code		= catalog_code;
					}

	  				row_value					= (ind_catalog_code+"_"+row_value);
					
					
					arrSeqNo					= (ArrayList)orderEntryRecordBean.getOrderFormats(ind_catalog_code, row_value);
				
					if(arrSeqNo != null && arrSeqNo.size() >0)
					{
						for(int i=0;i<arrSeqNo.size();i++)
						{
							new_seq_num	=	Integer.parseInt((String)arrSeqNo.get(i));//((Integer)arrSeqNo.get(i)).intValue();
							orderEntryRecordBean.removeOrderFormats(ind_catalog_code, row_value);
							orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_catalog_code+new_seq_num);
						}
					}
				}// End of count
				orderEntryRecordBean.removeOrderFormats(ind_catalog_code, row_value);
			} // End of OrderFormatTypes
			else  // For Line Level to remove
			{
				for(int k=0;k<total_rows;k++)
				{
                 	catalog_code			=  bean.checkForNull(request.getParameter("catalog_code"+k),"");
			   		catalog_code_arr[k]		= catalog_code;
			   		ind_row_value			= (catalog_code_arr[k]+"_0");
					ind_catalog_code		= catalog_code_arr[k];
					
					arrSeqNo				= (ArrayList)orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);
					
					if(arrSeqNo != null && arrSeqNo.size() >0)
					{
						for(int i=0;i<arrSeqNo.size();i++)
						{
							new_seq_num	=	Integer.parseInt((String)arrSeqNo.get(i));//((Integer)arrSeqNo.get(i)).intValue();
							orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_row_value);
							orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_catalog_code+new_seq_num);
						}
					}
 					orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_row_value);
					// Remove the Comments
					
					arrSeqNo				= (ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+catalog_code, catalog_code);
			  		if(arrSeqNo!=null && arrSeqNo.size()>0)
			  		{
				  	 	orderEntryRecordBean.removeOrderFormats("Comments"+catalog_code, catalog_code);
					}
				}
			}
			// Removing the arrSeqNo from the Bean
		} // End of mode
		else   //set it in the bean
		{
			try
		    {
				if(!called_from.equals("LINE_LEVEL") && OrderFormatTypes!=null && OrderFormatTypes.size() > 0) //Other than header there will be only one loop
				{
					for(count=0;count<OrderFormatTypes.size();count++)	// Only one loop for line level
					{
						//if((!called_from.equals("")) && (called_from.equals("HEADER") || called_from.equals("ORDER_SET_HEADER")))   // Only for the Order Entry Header Level  //  Commented for  - IN045340
						if((!called_from.equals("")) && (called_from.equals("HEADER") || called_from.equals("ORDER_SET_HEADER") || called_from.equals("PREVIEW_HEADER")))   // Only for the Order Entry Header Level  //  Modified for  - IN045340
						{
							
							String[] order_type_records = (String[])OrderFormatTypes.get(count);//Pbm is here
							order_type_code			= order_type_records[1];

							if(order_type_code!=null && order_type_code.equals("ALL"))
								order_type_code		= "";
							if(!called_from.equals("ORDER_SET_HEADER"))
								ind_catalog_code		= order_type_code+catalog_code; // For other Header Orders
							else
								ind_catalog_code		= "ORDER_SET"+order_type_code+catalog_code;
						}
						else
						{
							
							order_type_code			= "";
							ind_catalog_code		= catalog_code;
							ind_row_value			= "";
						}

					try
					{
						ind_row_value			=	(ind_catalog_code+"_"+row_value);
					
						arrSeqNo				=	(ArrayList) orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);
					}
					catch(Exception e)
					{
						//out.println("Exception Prop : "+e);//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
					}

					if(arrSeqNo!=null && arrSeqNo.size() > 0)
					{
						for(int i=0;i<arrSeqNo.size();i++)
			 			{
			 			   new_seq_num			=  Integer.parseInt((String)arrSeqNo.get(i));//((Integer)arrSeqNo.get(i)).intValue();
 			 			   try
			 			   {
								template	=	(Hashtable)	orderEntryRecordBean.getOrderFormats (ind_catalog_code,(ind_catalog_code+new_seq_num));
 			    		   }
			    		   catch(Exception e)
			    		   {
			  			   	//	out.println("Exception when getting seq_no : "+e);//COMMON-ICN-0181
                                                                   e.printStackTrace();//COMMON-ICN-0181
			    		   }
			    		   try
			    		   {
								field_mnemonic	= (String) template.get("field_mnemonic");
 								label_text		= (String) template.get("label_text");
 								accept_option	= (String) template.get("accept_option");
								dflt_value		= (String) template.get("dflt_value");
								field_type		= (String) template.get("field_type");
								discr_msr_uom		= (String) template.get("discr_msr_uom");
 								single_or_multi			= bean.checkForNull((String) template.get("single_or_multi"),"S");
								parent_field_mnemonic	= bean.checkForNull((String) template.get("parent_field_mnemonic"),"");
								name_key				= parent_field_mnemonic+"ORDERFORMAT"+order_type_code+new_seq_num;
 								field_mnemonic_action = bean.checkForNull(request.getParameter("field_mnemonic_action"+name_key),"");
   								field_action_msg		= bean.checkForNull(request.getParameter("field_action_msg"+name_key),"");
   								
								field_value_type		= bean.checkForNull(request.getParameter("field_value_type"+name_key),"");
								default_value			= bean.checkForNull(request.getParameter("default_value"+name_key),""); //IN045798
								if(single_or_multi.equals("M") && field_type.equals("C"))
									dflt_value			= bean.checkForNull(request.getParameter("dflt_value"+name_key),"");
									
								notify_yn		= bean.checkForNull(request.getParameter("notify_yn"+name_key),"N");
  								if(!field_mnemonic.equals(parent_field_mnemonic)) { // only if dynamic it will enter here(that means for dependency)
 									field_mnemonic		= bean.checkForNull(request.getParameter("field_mnemonic"+name_key),"");
   									label_text			= bean.checkForNull(request.getParameter("label_text"+name_key),"");
									accept_option		= bean.checkForNull(request.getParameter("accept_option"+name_key),"");
 									dflt_value			= bean.checkForNull(request.getParameter("dflt_value"+name_key),"");
									field_type			= bean.checkForNull(request.getParameter("field_type"+name_key),"");
									oth_dependency_yn   = bean.checkForNull(request.getParameter("oth_dependency_yn"+name_key),"");//IN049133
							if(accept_option.equals("")) //Make the field_mnemonic as null, so it should not insert
								field_mnemonic = "";
									// Set it for the same field_mnemonic
									template.put("field_mnemonic"	,field_mnemonic);
									template.put("label_text"	,label_text);
									template.put("accept_option"	,accept_option);
									template.put("field_type"	,field_type);
									template.put("discr_msr_uom"	,discr_msr_uom);
								} // End of field_mnemonic
						   }
			    		   catch(Exception e)
			    		   {
			    	  			out.println("Exception when getting other values : "+e);
			    		   }
			     		 	// Get the Fields Values
			    			field_values		= bean.checkForNull(request.getParameter(name_key),"");
			    			field_values_oth_desc		= bean.checkForNull(request.getParameter(name_key+"_request_comment_oth_desc"),"");
							if(field_values_oth_desc.equals("null"))
							{
								field_values_oth_desc="";
							}
							
			    			if(field_type.equals("C"))
			    			{
			    			  if((field_values.equals("") || field_values.equals("N")) &&  single_or_multi.equals("S"))
			    			 	 field_values = "N";
			    			}


							//IN035189, starts
							if(field_type.equals("D"))
							{
								if(!localeName.equals("en"))
									field_values=com.ehis.util.DateUtils.convertDate(field_values,"DMY",localeName,"en");
							}

							if(field_type.equals("E"))
							{
								if(!localeName.equals("en"))
									field_values=com.ehis.util.DateUtils.convertDate(field_values,"DMYHM",localeName,"en");
							}
							//IN035189, ends
							//IN043095 Starts
							if(order_category.equals("OT") && field_type.equals("L") && field_mnemonic.equals("SURGERY_TYPE"))
							{
								StringTokenizer stoken_code1 = new StringTokenizer(field_values,"||");	
							
								mnemonicCode				=	stoken_code1.nextToken();
								mnemonicDesc				=	stoken_code1.nextToken();
								field_values = mnemonicCode;
							}
							//IN043095 Ends
							//order_format_onload = order_format_header_onload;//IN045512
 			    			template.put("field_values"	,field_values);
							template.put("dflt_value"	,field_values);
  			    			template.put("field_mnemonic_action"	,field_mnemonic_action);
  			    			template.put("field_action_msg"	,field_action_msg);
							template.put("notify_yn"	,notify_yn);
							template.put("field_value_type"	,field_value_type);
							template.put("field_values_oth_desc"	,field_values_oth_desc);
							template.put("single_or_multi"	,single_or_multi); //--[IN027169]-- 
							template.put("default_value", default_value); //IN045798
							template.put("oth_dependency_yn", oth_dependency_yn); //IN049133
						} // end of arrSeqNo for
 					} // end of arrSeqNo
 				} // End of count
		      } // End of OrderFormatTypes
		      else // For Line Level Setting into the bean
		      {
		    	  //order_format_onload = order_format_line_onload;//IN045512  
		        for(int k=0;k<total_rows;k++)
            	{
	            	catalog_code			= bean.checkForNull(request.getParameter("catalog_code"+k),"");
			   		catalog_code_arr[k]		= catalog_code;
			   		ind_row_value			= (catalog_code_arr[k]+"_0");
					ind_catalog_code		= catalog_code_arr[k];
                    try
					{
						
							arrSeqNo			=	(ArrayList) orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);
						
 					}
					catch(Exception e)
					{
						//out.println("Exception Prop : "+e);//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
					}
					if(arrSeqNo!=null && arrSeqNo.size() > 0)
					{
 					    for(int i=0;i<arrSeqNo.size();i++)
			 			{
			 			   new_seq_num			=  Integer.parseInt((String)arrSeqNo.get(i));//((Integer)arrSeqNo.get(i)).intValue();
   			 			   try
			 			   {
							  
									template	=	(Hashtable)	orderEntryRecordBean.getOrderFormats ( ind_catalog_code, (ind_catalog_code+new_seq_num) );
								  
								
  			    		   }
			    		   catch(Exception e)
			    		   {
			  			   		//out.println("Exception when getting template : "+e);//COMMON-ICN-0181
			  			   		e.printStackTrace();//COMMON-ICN-0181
			    		   }
 			    		   try
			    		   {
								field_mnemonic			= bean.checkForNull((String) template.get("field_mnemonic"),"");
								label_text				= bean.checkForNull((String) template.get("label_text"),"");
								accept_option			= bean.checkForNull((String) template.get("accept_option"),"");
								dflt_value				= bean.checkForNull((String) template.get("dflt_value"),"");
								field_type				= bean.checkForNull((String) template.get("field_type"),"");
								discr_msr_uom				= bean.checkForNull((String) template.get("discr_msr_uom"),"");
								parent_field_mnemonic	= bean.checkForNull((String) template.get("parent_field_mnemonic"),"");
								single_or_multi			= bean.checkForNull((String) template.get("single_or_multi"),"S");
								name_key				= parent_field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num;
 								field_mnemonic_action = bean.checkForNull(request.getParameter("field_mnemonic_action"+name_key),"");
								field_action_msg		= bean.checkForNull(request.getParameter("field_action_msg"+name_key),"");
								notify_yn		= bean.checkForNull(request.getParameter("notify_yn"+name_key),"N");
								field_value_type		= bean.checkForNull(request.getParameter("field_value_type"+name_key),"");
								default_value			= bean.checkForNull(request.getParameter("default_value"+name_key),""); //IN045798
																							
					 			if(!field_mnemonic.equals(parent_field_mnemonic)) { // only if dynamic it will enter here(that means for dependency)
									field_mnemonic		= bean.checkForNull(request.getParameter("field_mnemonic"+name_key),"");
									label_text			= bean.checkForNull(request.getParameter("label_text"+name_key),"");
									accept_option		= bean.checkForNull(request.getParameter("accept_option"+name_key),"");
									dflt_value			= bean.checkForNull(request.getParameter("dflt_value"+name_key),"");
									field_type			= bean.checkForNull(request.getParameter("field_type"+name_key),"");
									oth_dependency_yn   = bean.checkForNull(request.getParameter("oth_dependency_yn"+name_key),"");//IN049133
							if(accept_option.equals("")) //Make the field_mnemonic as null, so it should not insert
								field_mnemonic = "";
									// Set it for the same field_mnemonic
									template.put("field_mnemonic"	,field_mnemonic);
									template.put("label_text"	,label_text);
									template.put("accept_option"	,accept_option);
									//template.put("dflt_value"	,dflt_value);
									template.put("field_type"	,field_type);
									template.put("discr_msr_uom"	,discr_msr_uom);
								} // End of field_mnemonic
						   }
			    		   catch(Exception e)
			    		   {
			    	  			out.println("Exception when getting other values : "+e);
			    		   }
			    			// Get the Fields Values
			    			field_values		= bean.checkForNull(request.getParameter(name_key),"");
							field_values_oth_desc		= bean.checkForNull(request.getParameter(name_key+"_request_comment_oth_desc"),"");
							if(field_values_oth_desc.equals("null"))
							{
								field_values_oth_desc="";
							}
			    			if(field_type.equals("C"))
			    			{
			    			  if((field_values.equals("") || field_values.equals("N")) && single_or_multi.equals("S"))
			    			 	 field_values = "N";
			    			}
							
  			    			//IN035189, starts
							if(field_type.equals("D"))
							{
								if(!localeName.equals("en"))
								field_values=com.ehis.util.DateUtils.convertDate(field_values,"DMY",localeName,"en");
							}

							if(field_type.equals("E"))
							{
								if(!localeName.equals("en"))
								field_values=com.ehis.util.DateUtils.convertDate(field_values,"DMYHM",localeName,"en");
							}//IN035189, ends//IN043095 Starts
							if(field_type.equals("L") && field_mnemonic.equals("SURGERY_TYPE"))
							{
								StringTokenizer stoken_code1 = new StringTokenizer(field_values,"||");	
								mnemonicCode				=	stoken_code1.nextToken();
								mnemonicDesc				=	stoken_code1.nextToken();
								field_values = mnemonicCode;
							}//IN043095 Ends
							template.put("field_values"	,field_values);
							//Commented By Jyothi to fix IN024865 & IN024657 on 08/11/2010
							//template.put("dflt_value"	,field_values);
  			    			template.put("dflt_value"	,dflt_value);							
  			    			template.put("field_mnemonic_action"	,field_mnemonic_action);
  			    			template.put("field_action_msg"	,field_action_msg);
 							template.put("notify_yn"	,notify_yn);
 							template.put("field_value_type"	,field_value_type);
							template.put("field_values_oth_desc"	,field_values_oth_desc);
							template.put("single_or_multi"	,single_or_multi); //--[IN027169]-- 
							template.put("default_value", default_value); //IN045798
							template.put("oth_dependency_yn", oth_dependency_yn); //IN049133

						} // end of arrSeqNo for
					}  // End of if arrSeqNo
						// For Comments
		    			arrSeqNo		= new ArrayList();
				    	String cmts		= bean.checkForNull(request.getParameter("CMTS"+catalog_code),"");
				    	String preps	= bean.checkForNull(request.getParameter("PREPS"+catalog_code),"");
				    	String dept		= bean.checkForNull(request.getParameter("DEPT"+catalog_code),"");
				    	String pat_instn= bean.checkForNull(request.getParameter("PATIENT"+catalog_code),"");
						if(!cmts.equals("")||(!pat_instn.equals("")))
						{
							EnableEmail++;
						}
						arrSeqNo.add(0, cmts);	//Comments
						arrSeqNo.add(1, preps);	//Preps
						arrSeqNo.add(2, dept);	//Dept
						arrSeqNo.add(3, pat_instn); //Patient
						orderEntryRecordBean.setOrderFormats("Comments"+catalog_code, catalog_code, arrSeqNo);
				} // End of for K
		      }  // End of else "LINE_LEVEL"
		 	}
  	     	catch(Exception e)
	     	{
	 			//out.println("Exception when building Ok template: "+e);//common-icn-0181
	    	                e.printStackTrace();//COMMON-ICN-0181
		}
		}
		if(EnableEmail>0)
		{
			mandatory_check=mandatory_check+"$$"+EnableEmail;
		}
		//mandatory_check=mandatory_check+"~"+order_format_onload;//IN045512
  
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mandatory_check));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mandatory_check));
            _bw.write(_wl_block10Bytes, _wl_block10);

	// set it back persistence
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
}
