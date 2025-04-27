	async function getBlngGrpSearch(obj)
	{		

		var billing_group=obj.value;		
		
		if((billing_group!=""))
		{
			var retVal;
			var dialogHeight= "15" ;
			var dialogWidth	= "43" ;
			var dialogTop = "205" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var url = "../../eBL/jsp/BLBillingGrpDet.jsp?billing_group=	"+billing_group;
			retVal =await window.showModalDialog(url,arguments,features);
		}
	}
	async function getCustDet(obj)
	{			
			var cust_1=obj.value;										
		
			if((cust_1!=""))
			{
					var retVal;
					var dialogHeight= "14" ;
					var dialogWidth	= "24" ;
					var dialogTop = "290" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;
					var url = "../../eBL/jsp/BLCustomerDet.jsp?cust_code="+cust_1;
					retVal =await window.showModalDialog(url,arguments,features);
			}
				
	}

