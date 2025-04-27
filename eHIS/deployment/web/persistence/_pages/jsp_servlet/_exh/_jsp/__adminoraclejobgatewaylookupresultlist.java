package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.lang.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public final class __adminoraclejobgatewaylookupresultlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/AdminoraclejobGatewayLookupResultList.jsp", 1709122297586L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  <html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eXH/js/FilterLayerReference.js\' language=\'javascript\'></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\" >\n<form > \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n <input type=hidden name=\"action_type\" id=\"action_type\" value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[0].document.getElementById(\"search_optiontext\").value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\n\t\t\t\n\t\t\t</script>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\n\n\t  </form>\n\t  </body>\n\t  </html>\n \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String action_type="R";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	Connection con = null;  
	 String argumentset="";
	

	String strBeanName = XHGatewayListControllerBean.strBeanName; 
	//	MessageManager mm=new MessageManager();
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	//ArrayList ar=new ArrayList();

    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
  
   
    try																				 
    {
       if(con==null) con = ConnectionManager.getConnection(request);
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of MsgForApplEventTypeJsp:"+exp.toString());
	     exp.printStackTrace(System.err);
      //   exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
   	 
try
    {
		request.setAttribute("action_attr","R");
        XHGatewayListControllerBean xhBean=XHGatewayListControllerBean.getBean(strBeanName,request,session);
        xhBean.action(request,con);
		String strData[][]= xhBean.getDatabaseData();
		//LinkedList list=XHGatewayListControllerBean.list;
		//ArrayList arli=XHGatewayListControllerBean.arr;	

    	// int j=0;
	  	 for(int i=0;i<strData.length;i++) 
		 {			

			 if(strData[i][3].equals("Y"))
			 {																	   
				argumentset=argumentset+strData[i][1]+",";	      
				/* if(XHGatewayListControllerBean.list.size()>0)
				 {
					 if(XHGatewayListControllerBean.list.contains(strData[i][1]))
					{
						 System.out.println(" coming "+strData[i][1]);
						
						XHGatewayListControllerBean.list.remove(strData[i][1]);
						 argumentset=argumentset+strData[i][1]+",";
					}
							  
				    //if(list.contains(strData[i][1]))
					// {

							///System.out.println(" coming "+strData[i][1]);	  
						//	argumentset=argumentset+strData[i][1]+",";
						    //list.remove(strData[i][1]+"");
				//	 }

				 
				 }
				 else
				 {
				   argumentset=argumentset+strData[i][1]+",";
				 }		*/
				
				// strTotalList[j]=argumentset;
     					 //  j++;
						// ar.add(argumentset);
			
			 }
			 	// if(strData[i][3].equals("Y"))
				// {
					/*( if(arli.size()>0)								   
					 {
						System.out.println(" strData[i][1] :"+strData[i][1]);
						  System.out.println(" checking :"+arli.contains(strData[i][1]));
						  if(arli.contains(strData[i][1]))
						 {
							  System.out.println(strData[i][1]);	  	    

							 arli.remove(strData[i][1]);
							 System.out.println(arli);
																     
						 }																	  
																		  
						//  arli.remove(strData[i][1]);
					 }*/

						/// if(arli.contains(strData[i][1]))
						// {
							  // arli.remove(strData[i][1]);
						
						// }
						
			//		 }
					// else
					// {															  
					//   argumentset=argumentset+strData[i][1]+",";
					// }

					 
		
				// }

				/*	 if(XHGatewayListControllerBean.list.size()>0)
					 {
						  

						 for(int k=0;k<XHGatewayListControllerBean.listlist.size();k++)
						 {
							 argumentset=argumentset+(String)XHGatewayListControllerBean.list.get(k)+",";
								   XHGatewayListControllerBean.list.remove(k);
						 }
					 }*/	
			 	
		  						 										   
		 }
	 
       argumentset=argumentset.substring(0,(argumentset.length()-1));
		
		}catch(Exception exception)
		{
			 System.out.println("Error in calling db realted statements in dopost method of dataelementcrossrefapplicationusageservlet :"+exception.toString());
		    exception.printStackTrace(System.err); 
		
		}finally{
			try
			{
		     
			   ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			   System.out.println("Eroor in closing dbconnection dopost method of dataelementcrossrefapplicationusageservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
			//if(con!=null) 
													 	  
		}          
     
      
	  
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(argumentset));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
