<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eXH.InterfaceUtil,eXH.XHDBAdapter,java.text.*,java.io.*,java.net.*,javax.servlet.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>	
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

		<%
			StringBuffer htmlData = new StringBuffer();
			String printFlag="";
			String facilityId ="";
			
			String barcode_id = "", itemname = "", batchid = "", expdate = "", itemCode="",printQty="1";
			int printNo = 0;
			int itemLength = 30;
			String barcode_qty = "";

			String printData = "";
			String appId = "BARCOD";
			
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement stmt = null;

			String notesHtmlData = "";
			String strHtmlData = "";	
			
			request.setCharacterEncoding("UTF-8");
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			facilityId	= (String)session.getValue("facility_id");
			
			//&barcode=12345&itemname=barcodeitem2&batchid=123456&expdate=12/01/2017";
			barcode_id = XHDBAdapter.checkNull(request.getParameter("barcode_id"));
			itemname = XHDBAdapter.checkNull(request.getParameter("itemname"));
			System.out.println(" itemname Data before replace ::: "+itemname.length());
			System.out.println(" itemname ::: "+itemname);
			con = ConnectionManager.getConnection();
			HashMap hs = eCommon.Common.CommonBean.getSiteSpecificDetails(con, "XH","BARCODE_ITEMNAME_LENGTH");
			String lengthStr = (String)hs.get("value1");
			String dividingValue = (String)hs.get("value2");
			System.out.println(" itemname HashMap values::: "+hs);
			System.out.println(" itemname lengthStr::: "+lengthStr);
			System.out.println(" print qty dividingValue::: "+dividingValue);
			if(lengthStr!=null && lengthStr!="")
			{
			   itemLength = Integer.parseInt(lengthStr);
			}
			if(itemname!=null && itemname.length() > itemLength)
			{
				itemname = itemname.substring(0,itemLength);
			}
			System.out.println(" itemname after::: "+itemname);
            System.out.println(" itemname Data after replace ::: "+itemname.length());
			batchid = XHDBAdapter.checkNull(request.getParameter("batchid"));
			expdate = XHDBAdapter.checkNull(request.getParameter("expdate")); 
			itemCode = XHDBAdapter.checkNull(request.getParameter("item_code")); 
			printQty = XHDBAdapter.checkNull(request.getParameter("printQty"));
			System.out.println("printQty::: "+printQty);

			if(printQty=="" || printQty==null)
			{
               printQty="1";
			}
			else
			{
				if(dividingValue=="" || dividingValue == null )
				{
                     dividingValue = "4";
				}
				else if("0".equals(dividingValue))
				{
                     dividingValue = "1";
				}
				int printQtyIntMod = 0;
				int printQtyInt = Integer.parseInt(printQty);
				int dividingValueInt = Integer.parseInt(dividingValue);
				printQtyIntMod = (printQtyInt %  dividingValueInt );
				printQtyInt = (printQtyInt/dividingValueInt);
				System.out.println("printQtyInt after dividing::: "+printQtyInt);
				if(printQtyInt!=0)
				{
					if(printQtyIntMod!=0)
				   {
					   printQtyInt  = printQtyInt + 1;  // it will increase one row. If they give 10 nos, 3 rows will be printed. 12 labels.
				   }
                   printQty = String.valueOf(printQtyInt);
				}
				else
				{
					printQty = "1";
				}
				System.out.println("else-- printQty after::: "+printQty);
			}
            System.out.println(":::::Final printQty::: "+printQty);
			/*
				Read from table, CLOB Data.
				printData
			*/
			printData = InterfaceUtil.getBarcodeData(appId);
            System.out.println(" barcode_id ::: "+barcode_id);
			//System.out.println(" Print Data from Table ::: "+printData);  it will be printed in interfaceutil.java class
		
		if (printData.length() > 0){
		
			printData =  printData.replace("$barcode$", barcode_id); 
			printData =  printData.replace("$itemname$", itemname); 
			printData =  printData.replace("$batchid$", batchid); 
			printData =  printData.replace("$expdate$", expdate);
			printData =  printData.replace("$itemcode$", itemCode);
			printData =  printData.replace("$printqty$", printQty);
		}	

		System.out.println(" Print Data after replace ::: "+printData);
		%>
	</head>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>

	<script type="text/javascript">
		var docReadyCount = 0;
		var divCount = 0;	
		
		var dialogTop		=	"100" ;
		var dialogLeft		=	"100" ;
		var dialogHeight	=	"300" ;
		var dialogWidth		=	"300" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"Height=" + dialogHeight + "; Width=" + dialogWidth + "; Top=" + dialogTop + "; Left=" + dialogLeft + ";scroll=no; status:" + status;
		var PrintCommand = '<object id="PrintCommandObject" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" width="0" height="0"></object>';	

		$(document).ready(function() {
			
			if (navigator.appName == "Microsoft Internet Explorer"){			
			 	// attach and initialize print command ActiveX object
				try{	 		
			 		document.body.insertAdjacentHTML('afterbegin', PrintCommand);
				}
			 	catch(e){}
			}	
				
		});

		$(window).load(function() 
		{		
				if(PrintCommandObject)
				{
					try{
						PrintCommandObject.ExecWB(6,2);
					 	PrintCommandObject.outerHTML = "";
						alert("Printing Completed");
						window.close();
					}
					catch(e){
						alert(e.message);
						window.print();
						window.close();
					}
				}
				else{
					window.print();
					window.close();
				}				
		});
		
		function pagePrint(){
			window.print();
			window.close();
		}
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<body>	
		<form name="XHBarcodePrintForm" id="XHBarcodePrintForm">

		<pre>
		<%=printData %>
		</pre>

		</form>
	</body>
</html>

