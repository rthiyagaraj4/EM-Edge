

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();	
try {
	
	String bean_id		= "PkgRefundBean" ;
	String bean_name	= "eBL.PkgRefundBean";
	PkgRefundBean bean			= (PkgRefundBean)getBeanObject( bean_id, bean_name, request ) ;
	String locale			= (String)session.getAttribute("LOCALE");

	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
		if(func_mode!= null && func_mode.equals("getPatDtls")){
			String patient_id =hash.get( "patient_id" ) == null ? "":(String)hash.get( "patient_id" ) ;
			String pat_dtls=bean.getPatientDtls(patient_id,locale);
			if ( pat_dtls == null ) pat_dtls = "";
			if(!pat_dtls.equals("")){
				int ind=pat_dtls.indexOf("#");
				pat_dtls=pat_dtls.substring(0,ind);
				if ( pat_dtls == null ) pat_dtls = "";
				if(!pat_dtls.equals(""))
				out.println("document.PkgRefundHdrForm.pat_dtls.innerHTML='"+pat_dtls+"'");
			}
			if(pat_dtls.equals("")){
				out.println("alert(getMessage(\"BL0440\",\"BL\"))");
				out.println("document.PkgRefundHdrForm.patient_id.value=''");
				out.println("document.PkgRefundHdrForm.pat_dtls.innerHTML=''");
			}
						
		}else if(func_mode!= null && func_mode.equals("getPkgDtls")){
			String patient_id =hash.get( "patient_id" ) == null ? "":(String)hash.get( "patient_id" ) ;
			String facility_id =hash.get( "facility_id" ) == null ? "":(String)hash.get( "facility_id" ) ;
			String pkg_code =hash.get( "pkg_code" ) == null ? "":(String)hash.get( "pkg_code" ) ;
			String[] pkg_dtls=bean.getPkgDtls(facility_id,patient_id,locale,pkg_code);
			out.println("document.PkgRefundHdrForm.pkg_seq_no.value='"+pkg_dtls[1]+"'");
			
		}else if(func_mode!= null && func_mode.equals("saveExclToBean")){
			HashMap excl_srv_dtls=new HashMap();
			String	total_records		=	(String) hash.get( "total_records" );
			String[] record;
			int totalRec				=	Integer.parseInt(total_records);
			String pkg_serv_code = "";
			ArrayList excl_srv_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   pkg_serv_code = (String) hash.get( "pkg_serv_code" );
			   if(pkg_serv_code!=null && !pkg_serv_code.equals(""))
			   {
					record=new String[13];
					record[0]=(String)hash.get( "excl_serv_ind"+i );
					record[1]=(String)hash.get( "excl_serv_code"+i );
					record[2]=(String)hash.get( "excl_serv_desc"+i );
					record[3]=(String)hash.get( "exclude_yn"+i );
					record[4]=(String)hash.get( "refund_yn"+i );
					record[5]=(String)hash.get( "refund_rate"+i );
					record[6]=(String)hash.get( "utilized_serv_qty"+i );
					record[7]=(String)hash.get( "utilized_serv_amt"+i );
					record[8]=hash.get( "available_amt"+i )==null?"0":((String)hash.get( "available_amt"+i ));
					record[9]=hash.get( "refund_amt"+i )==null?"0":((String)hash.get( "refund_amt"+i ));
					record[10]=(String)hash.get( "refunded"+i );
					record[11]=hash.get( "refunded_amount"+i )==null?"0":((String)hash.get( "refunded_amount"+i ));
					record[12]=(String)hash.get( "refund_serv"+i );					
					excl_srv_list.add(record)	;									
			   }
			}	
			if(excl_srv_dtls!=null && excl_srv_dtls.size()>0 && excl_srv_dtls.containsKey(pkg_serv_code))
				excl_srv_dtls.remove(pkg_serv_code);
				 if(excl_srv_list.size()>0)
			   {
					excl_srv_dtls.put(pkg_serv_code,excl_srv_list);					
					bean.setExclSrvDtls(excl_srv_dtls);	
				}
		
		}else if(func_mode!= null && func_mode.equals("saveSrvToBean")){
			ArrayList srv_dtls=new ArrayList();
			String	total_records		=	(String) hash.get( "total_records" );
			String[] record;
			int totalRec				=	Integer.parseInt(total_records);
			String pkg_serv_code="";
			for(int i=0;i<totalRec; i++)
			{
			   pkg_serv_code = (String) hash.get( "pkg_serv_code"+i );
			   if(pkg_serv_code!=null && !pkg_serv_code.equals(""))
			   {
					record=new String[13];
					record[0]=(String)hash.get( "pkg_serv_ind"+i );
					record[1]=(String)hash.get( "pkg_serv_code"+i );
					record[2]=(String)hash.get( "pkg_serv_desc"+i );
					record[3]=(String)hash.get( "order_catalog_code"+i );
					record[4]=(String)hash.get( "refund_yn"+i );
					record[5]=(String)hash.get( "refund_rate"+i );
					record[6]=(String)hash.get( "utilized_serv_qty"+i );
					record[7]=(String)hash.get( "utilized_serv_amt"+i );					
					record[8]=(String)hash.get( "available_amt"+i );					
					record[9]=(String)hash.get( "refund_amt"+i );					
					record[10]=(String)hash.get( "refunded"+i );					
					record[11]=hash.get( "refunded_amount"+i )==null?"0":((String)hash.get( "refunded_amount"+i ));				
					record[12]=(String)hash.get( "refund_serv"+i );					
					srv_dtls.add(record)	;									
			   }
			}	
			if(srv_dtls!=null && srv_dtls.size()>0)
				bean.setPkgSrvDtls(srv_dtls);		
		}
		putObjectInBean(bean_id,bean,request);
}catch (Exception e) {
	e.printStackTrace() ;
	System.out.println("Exception from PkgRefundValidation :"+e);
}finally
	{
		//if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}


%>

