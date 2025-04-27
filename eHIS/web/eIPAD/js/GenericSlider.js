	//---------Generic slider functionality starts---------------
	/* Configuration for slider 
	** this -- the slider pointer to which the sliderGenericControl function is binded to
	** data attributes of the slider pointer(this)
	** data-valuefield -- the hidden field where the slider values are outputed as 1,2,3,4
	** data-parent -- id of the parent div(the slider scale)
	** data-numpoints -- no of points in the slider
	** data-drag -- Y or N. if Y the slider will extend the drag div as the slider pointer is moved
	** data-dragdiv -- id of the drag div, the div that contains the drag effect style- It should be initially of width 0
	** data-defaultvalue -- the default value to be selected 
	** data-value -- the value to be sent to the hidden field eg: data-value1="A" data-value2="D" data-value3="I"
	** data-selstylelabel -- the style class to be applied for the selected value label
	** data-labelfor -- should be in the format <sliderPointerId>-<sliderPointerValue> -- this attribute should be present in the label element
	** data-readonly - Y or N Slide pointers will not move if readonly
	*** Eg if the id of slider(this) object is 'RoundI' then the data-labelfor value can be data-labelfor="RoundI-1", data-labelfor="RoundI-2", data-labelfor="RoundI-3"
	*/
	jQuery.fn.sliderGenericControl = function() { 
		var sliderPointer = this;
		var sliderPointerId = $(this).attr("id");
		var parentId = $(this).data("parent");
		var readOnly = false;
		if($(this).data("readonly") == "Y"){
			readOnly = true;
		}
		var parentWidth = $("#"+parentId).innerWidth();
		var parentHeight = $("#"+parentId).height();
		var pointerWidth = $(this).width();
		var drag = false;
		if($(this).data("drag") == "Y"){
			drag = true;
		}
			
		var dragDivId = $(this).data("dragdiv");
		var valueFieldId = $(this).data("valuefield"); 
		var valueField = $("#"+valueFieldId);
		
		//alert(parentWidth);
		var slidePoints = 2;
		if(!isNaN(parseInt($(this).data("numpoints")))){
			slidePoints = parseInt($(this).data("numpoints"));
		}
		var defaultValue = $(this).data("defaultvalue");
		var defaultSelected = 1;
		//if(defaultSelected<=0 || defaultSelected>slidePoints){
		//	defaultSelected = 1;
		//}
		var selectedLabelClass = $(this).data("selstylelabel");
		
		var scaleUnit = 100/(slidePoints-1);
		var scaleUnitpx = parentWidth * scaleUnit/100;
		//last slide point at 100% minus slide pointer width
		var maxSlidePoint = parentWidth-pointerWidth/2;
		var maxSlidePercent = maxSlidePoint/parentWidth*100;
		
		var pointsArr = new Array();
		var pointsPxArr = new Array();
		var valueArr = new Array();
		//populating the slider values to be stored in the hidden field
		for(i=1;i<=slidePoints;i++){
			var curVal = "";
			curVal = $(this).data("value"+i);
			valueArr.push(curVal);
			//if default value is equal to the curVal then change the defaultSelected Index value 
			if(curVal == defaultValue){
				defaultSelected = i;
			}
		}
		
		if(slidePoints<=2){
			pointsArr.push(0,maxSlidePercent);
			pointsPxArr.push(0,maxSlidePoint);
		}
		else{
			pointsArr.push(0);
			pointsPxArr.push(0);
			for(i=1;i<slidePoints-1;i++){
				var curPointPx = scaleUnit*i/100 * parentWidth;
				var curPoint = scaleUnit*i;
				pointsArr.push(curPoint);
				pointsPxArr.push(curPointPx);
			}
			pointsArr.push(maxSlidePercent);
			pointsPxArr.push(maxSlidePoint);
		}
		
		var offset = null;
		var touchleft = 0;
		
		//select the default value
		$(sliderPointer).css("left" , pointsArr[defaultSelected-1]+"%");
		//apply style for selected value label
		$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
		$("[data-labelfor='"+sliderPointerId+"-"+defaultSelected+"']").addClass(selectedLabelClass);
       	 valueField.val(valueArr[defaultSelected-1]).trigger('change');
       	 if(drag){
       		$('#'+dragDivId).css("width",pointsArr[defaultSelected-1]+"%");
		    $('#'+dragDivId).css("height",parentHeight);
       	 }
		if(!readOnly){
		$(this).bind('touchstart', function(event) { 
	        var e = event.originalEvent; 
	        var orig = event.originalEvent;
		    var pos = $(this).position();
		    offset = {
		      x: orig.changedTouches[0].pageX - pos.left,
		      y: orig.changedTouches[0].pageY - pos.top
		     
		    };
	    });
	    
		//handling click on label here
		for(var h=1;h<=slidePoints;h++){
		
			$("[data-labelfor='"+sliderPointerId+"-"+h+"']").bind('click', function(event) {
				var selected = 1;
				if(!isNaN(parseInt($(this).data("labelval")))){
					selected = $(this).data("labelval");						
					$(sliderPointer).css("left" , pointsArr[selected-1]+"%");
					valueField.val(valueArr[selected-1]).trigger('change');
					if(drag){
						$('#'+dragDivId).css("width",pointsArr[selected-1]+"%");
						$('#'+dragDivId).css("height",parentHeight);
					}
					//apply style for selected value label
					$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
					$("[data-labelfor='"+sliderPointerId+"-"+selected+"']").addClass(selectedLabelClass);
				}
			});
		}
		
	    //handling click here
	    $("#"+parentId).bind('click', function(event) { 
	        var e = event.originalEvent; 
	        var parentOffset = $(this).parent().offset(); 
		    //or $(this).offset(); if you really just want the current element's offset
		    var relX = e.pageX - parentOffset.left;
		    var relY = e.pageY - parentOffset.top;
		    //alert(relX+","+relY);
		    touchleft = relX;
		    
		    if(touchleft <= pointsPxArr[0])
	        {
	        	 $(sliderPointer).css("left" , pointsArr[0]+"%");
	        	 valueField.val(valueArr[0]).trigger('change');
	        	 if(drag){
	        		 $('#'+dragDivId).css("width",pointsArr[0]+"%");
			    	 $('#'+dragDivId).css("height",0);
	        	 }
	        	//apply style for selected value label
	     		$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	     		$("[data-labelfor='"+sliderPointerId+"-"+1+"']").addClass(selectedLabelClass);
	  		 	
	        }
	        else if(touchleft >= pointsPxArr[slidePoints-1]){
	        	$(sliderPointer).css("left" , pointsArr[slidePoints-1]+"%");
	        	valueField.val(valueArr[slidePoints-1]).trigger('change');
	        	if(drag){
	        		$('#'+dragDivId).css("width",pointsArr[slidePoints-1]+"%" );
			    	$('#'+dragDivId).css("height",parentHeight);
	        	}
	        	//apply style for selected value label
	    		$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	    		$("[data-labelfor='"+sliderPointerId+"-"+slidePoints+"']").addClass(selectedLabelClass);
	        	
	        }
	        else{
	        	for(j=1;j<slidePoints;j++){
	        		if(touchleft <= pointsPxArr[j] && touchleft > pointsPxArr[j-1]){
	        			var sectMid=pointsPxArr[j-1]+scaleUnitpx/2;
	        			if(touchleft < sectMid){
	        				$(sliderPointer).css("left" , pointsArr[j-1]+"%");
	        				valueField.val(valueArr[j-1]).trigger('change');
	        				//console.log("this " + touchleft +"mid" +sectMid +" parentwidth" +parentWidth + " -- " + valueField.val());
	        				if(drag){
	        					$('#'+dragDivId).css("width",pointsArr[j-1]+"%" );
	        		    		$('#'+dragDivId).css("height",parentHeight);
	        				}
	        				//apply style for selected value label
	        				$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	        				$("[data-labelfor='"+sliderPointerId+"-"+(j)+"']").addClass(selectedLabelClass);
	        			}
	        			else{
	        				$(sliderPointer).css("left" , pointsArr[j]+"%");
	        				valueField.val(valueArr[j]).trigger('change');
	        				//console.log("this1 " + touchleft +"mid" +sectMid +" parentwidth" +parentWidth +" -- " +valueField.val());
	        				if(drag){
	        					$('#'+dragDivId).css("width",pointsArr[j]+"%" );
	        		    		$('#'+dragDivId).css("height",parentHeight);
	        				}
	        				//apply style for selected value label
	        				$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	        				$("[data-labelfor='"+sliderPointerId+"-"+(j+1)+"']").addClass(selectedLabelClass);
	        				
	        			}
	        		}
	        	}
	        	
	        }
		    
	    });
	    
	    $(this).bind('touchmove', function(event) { 
	    	event.preventDefault();
	    	event.stopPropagation();
	    	var e = event.originalEvent; 
	    	touchleft = e.touches[0].pageX - offset.x;
	    	if(touchleft < pointsPxArr[slidePoints-1] && touchleft > pointsPxArr[0])
	    	{
		    	 $(this).css("left" , touchleft);
		    	 if(drag){
		    		 $('#'+dragDivId).css("width",touchleft );
			    	 $('#'+dragDivId).css("height",parentHeight);
		    	 }
		    	 
		    	
	    	}
	    
	    }); 
	    
	    $(this).bind('touchend', function(event) { 
	        if(touchleft <= pointsPxArr[0])
	        {
	        	 $(this).css("left" , pointsArr[0]+"%");
	        	 valueField.val(valueArr[0]).trigger('change');
	        	 if(drag){
	        		 $('#'+dragDivId).css("width",pointsArr[0]+"%");
			    	 $('#'+dragDivId).css("height",0);
	        	 }
	        	//apply style for selected value label
	     		$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	     		$("[data-labelfor='"+sliderPointerId+"-"+1+"']").addClass(selectedLabelClass);
	  		 	
	        }
	        else if(touchleft >= pointsPxArr[slidePoints-1]){
	        	$(this).css("left" , pointsArr[slidePoints-1]+"%");
	        	valueField.val(valueArr[slidePoints-1]).trigger('change');
	        	if(drag){
	        		$('#'+dragDivId).css("width",pointsArr[slidePoints-1]+"%" );
			    	$('#'+dragDivId).css("height",parentHeight);
	        	}
	        	//apply style for selected value label
	    		$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	    		$("[data-labelfor='"+sliderPointerId+"-"+slidePoints+"']").addClass(selectedLabelClass);
	        	
	        }
	        else{
	        	for(j=1;j<slidePoints;j++){
	        		if(touchleft <= pointsPxArr[j] && touchleft > pointsPxArr[j-1]){
	        			var sectMid=pointsPxArr[j-1]+scaleUnitpx/2;
	        			if(touchleft < sectMid){
	        				$(this).css("left" , pointsArr[j-1]+"%");
	        				valueField.val(valueArr[j-1]).trigger('change');
	        				//console.log("this " + touchleft +"mid" +sectMid +" parentwidth" +parentWidth + " -- " + valueField.val());
	        				if(drag){
	        					$('#'+dragDivId).css("width",pointsArr[j-1]+"%" );
	        		    		$('#'+dragDivId).css("height",parentHeight);
	        				}
	        				//apply style for selected value label
	        				$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	        				$("[data-labelfor='"+sliderPointerId+"-"+j+"']").addClass(selectedLabelClass);
	        			}
	        			else{
	        				$(this).css("left" , pointsArr[j]+"%");
	        				valueField.val(valueArr[j]).trigger('change');
	        				//console.log("this1 " + touchleft +"mid" +sectMid +" parentwidth" +parentWidth +" -- " +valueField.val());
	        				if(drag){
	        					$('#'+dragDivId).css("width",pointsArr[j]+"%" );
	        		    		$('#'+dragDivId).css("height",parentHeight);
	        				}
	        				//apply style for selected value label
	        				$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
	        				$("[data-labelfor='"+sliderPointerId+"-"+(j+1)+"']").addClass(selectedLabelClass);
	        				
	        			}
	        		}
	        	}
	        	
	        }
	        
	    	
	    });
		}
	    //if the hidden value field is changed externally, triggering the change event then the slider position is automatically
	    //Change should be done as: txtbox.val("some").trigger('change')
	    valueField.change( function() { 
			var val = valueField.val();
			for(k=0;k<valueArr.length;k++){
				if(val==valueArr[k]){
					//alert(pointsArr[k]);
					$(sliderPointer).css("left" , pointsArr[k]+"%");
						//valueField.val(valueArr[i]).trigger('change');
						if(drag){
							$('#'+dragDivId).css("width",pointsArr[k]+"%" );
				    		$('#'+dragDivId).css("height",parentHeight);
						}
						//apply style for selected value label
						$("[data-labelfor^='"+sliderPointerId+"-']").removeClass(selectedLabelClass);
						$("[data-labelfor='"+sliderPointerId+"-"+(k+1)+"']").addClass(selectedLabelClass);
				}
			}
			
		});
	    return this; 
	};


	//---------slider functionality ends---------------