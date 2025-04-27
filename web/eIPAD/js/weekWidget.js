//***************************************************************//

//Licence   - Computer Science Corp
//Developer - Goutham Deepak
//Email     - garunachalam@csc.com

//***************************************************************//



(function ($) {

    //***************************************************************//
    // CONSTANTS
    //***************************************************************//
    //added by me to get system date for rite side bt no use
    var date;
    //var o;
    //var todayDate = date.getDate();
    dayName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    //var dayNo = date.getDay();
    //var day = dayName[dayNo];
    //var todayMonth = date.getMonth();
    monthName = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
/*    var month = monthName[todayMonth];
    var year = date.getUTCFullYear();*/
    
    var swipeRightBindCount = 0;
   ////Initializing DateTimePicker Objects
    //calDatePicker = $("#OnsetDate").data("kendoDateTimePicker");
    var today, widget = '',
     currentWeek,
     dayConverter =
        {
            0: 'Sun',
            1: 'Mon',
            2: 'Tue',
            3: 'Wed',
            4: 'Thu',
            5: 'Fri',
            6: 'Sat'
        };

    //Fix : Touch doesnt work in the Ipad,So this touchstart event is added along with the click event
    //TODO :  Check if this is necessary, otherwise remove it
    var clickHandler = 'ontouchstart' in document.documentElement ? 'click' : 'click';

    var width = $(window).width();

    var uuid = 0,
     slice = Array.prototype.slice,
     _cleanData = $.cleanData;

    $.cleanData = function (elems) {
        for (var i = 0, elem;
        (elem = elems[i]) != null; i++) {
            try {
                $(elem).triggerHandler("remove");
            }
            catch (e) {
            }
        }
        _cleanData(elems);
    };

    $.widget = function (name, base, prototype) {
        var fullName, existingConstructor, constructor, basePrototype,
        // proxiedPrototype allows the provided prototype to remain unmodified
        // so that it can be used as a mixin for multiple widgets (#8876)
        proxiedPrototype =
        {
        },
         namespace = name.split(".")[0];

        name = name.split(".")[1];
        fullName = namespace + "-" + name;

        if (!prototype) {
            prototype = base;
            base = $.Widget;
        }

        // create selector for plugin
        $.expr[":"][fullName.toLowerCase()] = function (elem) {
            return !!$.data(elem, fullName);
        };

        $[namespace] = $[namespace] || {
        };
        existingConstructor = $[namespace][name];
        constructor = $[namespace][name] = function (options, element) {
            // allow instantiation without "new" keyword
            if (!this._createWidget) {
                return new constructor(options, element);
            }

            // allow instantiation without initializing for simple inheritance
            // must use "new" keyword (the code above always passes args)
            if (arguments.length) {
                this._createWidget(options, element);
            }
        };
        // extend with the existing constructor to carry over any static properties
        $.extend(constructor, existingConstructor, {
            version: prototype.version,
            // copy the object used to create the prototype in case we need to
            // redefine the widget later
            _proto: $.extend(
            {
            }, prototype),
            // track widgets that inherit from this widget in case this widget is
            // redefined after a widget inherits from it
            _childConstructors: []
        });

        basePrototype = new base();
        // we need to make the options hash a property directly on the new instance
        // otherwise we'll modify the options hash on the prototype that we're
        // inheriting from
        basePrototype.options = $.widget.extend(
        {
        }, basePrototype.options);
        $.each(prototype, function (prop, value) {
            if (!$.isFunction(value)) {
                proxiedPrototype[prop] = value;
                return;
            }
            proxiedPrototype[prop] = (function () {
                var _super = function () {
                    return base.prototype[prop].apply(this, arguments);
                },
                 _superApply = function (args) {
                     return base.prototype[prop].apply(this, args);
                 };
                return function () {
                    var __super = this._super,
                     __superApply = this._superApply,
                     returnValue;

                    this._super = _super;
                    this._superApply = _superApply;

                    returnValue = value.apply(this, arguments);

                    this._super = __super;
                    this._superApply = __superApply;

                    return returnValue;
                };
            })();
        });
        constructor.prototype = $.widget.extend(basePrototype, {
            // TODO: remove support for widgetEventPrefix
            // always use the name + a colon as the prefix, e.g., draggable:start
            // don't prefix for widgets that aren't DOM-based
            widgetEventPrefix: existingConstructor ? basePrototype.widgetEventPrefix : name
        }, proxiedPrototype, {
            constructor: constructor,
            namespace: namespace,
            widgetName: name,
            widgetFullName: fullName
        });

        // If this widget is being redefined then we need to find all widgets that
        // are inheriting from it and redefine all of them so that they inherit from
        // the new version of this widget. We're essentially trying to replace one
        // level in the prototype chain.
        if (existingConstructor) {
            $.each(existingConstructor._childConstructors, function (i, child) {
                var childPrototype = child.prototype;

                // redefine the child widget using the same prototype that was
                // originally used, but inherit from the new version of the base
                $.widget(childPrototype.namespace + "." + childPrototype.widgetName, constructor, child._proto);
            });
            // remove the list of existing child constructors from the old constructor
            // so the old child constructors can be garbage collected
            delete existingConstructor._childConstructors;
        }
        else {
            base._childConstructors.push(constructor);
        }

        $.widget.bridge(name, constructor);
    };

    $.widget.extend = function (target) {
        var input = slice.call(arguments, 1),
         inputIndex = 0,
         inputLength = input.length,
         key, value;
        for (; inputIndex < inputLength; inputIndex++) {
            for (key in input[inputIndex]) {
                value = input[inputIndex][key];
                if (input[inputIndex].hasOwnProperty(key) && value !== undefined) {
                    // Clone objects
                    if ($.isPlainObject(value)) {
                        target[key] = $.isPlainObject(target[key]) ? $.widget.extend(
                        {
                        }, target[key], value) :
                        // Don't extend strings, arrays, etc. with objects
                        $.widget.extend(
                        {
                        }, value);
                        // Copy everything else by reference
                    }
                    else {
                        target[key] = value;
                    }
                }
            }
        }
        return target;
    };

    $.widget.bridge = function (name, object) {
        var fullName = object.prototype.widgetFullName || name;
        $.fn[name] = function (options) {
            var isMethodCall = typeof options === "string",
             args = slice.call(arguments, 1),
             returnValue = this;

            // allow multiple hashes to be passed on init
            options = !isMethodCall && args.length ? $.widget.extend.apply(null, [options].concat(args)) : options;

            if (isMethodCall) {
                this.each(function () {
                    var methodValue, instance = $.data(this, fullName);
                    if (!instance) {
                        return $.error("cannot call methods on " + name + " prior to initialization; " + "attempted to call method '" + options + "'");
                    }
                    if (!$.isFunction(instance[options]) || options.charAt(0) === "_") {
                        return $.error("no such method '" + options + "' for " + name + " widget instance");
                    }
                    methodValue = instance[options].apply(instance, args);
                    if (methodValue !== instance && methodValue !== undefined) {
                        returnValue = methodValue && methodValue.jquery ? returnValue.pushStack(methodValue.get()) : methodValue;
                        return false;
                    }
                });
            }
            else {
                this.each(function () {
                    var instance = $.data(this, fullName);
                    if (instance) {
                        instance.option(options || {
                        })._init();
                    }
                    else {
                        $.data(this, fullName, new object(options, this));
                    }
                });
            }

            return returnValue;
        };
    };

    $.Widget = function ( /* options, element */) {
    };
    $.Widget._childConstructors = [];

    $.Widget.prototype =
    {
        widgetName: "widget",
        widgetEventPrefix: "",
        defaultElement: "<div>",
        options: {
            disabled: false,

            // callbacks
            create: null
        },
        _createWidget: function (options, element) {
            element = $(element || this.defaultElement || this)[0];
            this.element = $(element);
            this.uuid = uuid++;
            this.eventNamespace = "." + this.widgetName + this.uuid;
            this.options = $.widget.extend(
            {
            }, this.options, this._getCreateOptions(), options);

            this.bindings = $();
            this.hoverable = $();
            this.focusable = $();

            if (element !== this) {
                $.data(element, this.widgetFullName, this);
                this._on(true, this.element, {
                    remove: function (event) {
                        if (event.target === element) {
                            this.destroy();
                        }
                    }
                });
                this.document = $(element.style ?
                // element within the document
                element.ownerDocument :
                // element is window or document
                element.document || element);
                this.window = $(this.document[0].defaultView || this.document[0].parentWindow);
            }

            this._create();
            this._trigger("create", null, this._getCreateEventData());
            this._init();
        },
        _getCreateOptions: $.noop,
        _getCreateEventData: $.noop,
        _create: $.noop,
        _init: $.noop,

        destroy: function () {
            this._destroy();
            // we can probably remove the unbind calls in 2.0
            // all event bindings should go through this._on()
            this.element.unbind(this.eventNamespace)
            // 1.9 BC for #7810
            // TODO remove dual storage
            .removeData(this.widgetName).removeData(this.widgetFullName)
            // support: jquery <1.6.3
            // http://bugs.jquery.com/ticket/9413
            .removeData($.camelCase(this.widgetFullName));
            this.widget().unbind(this.eventNamespace).removeAttr("aria-disabled").removeClass(
            this.widgetFullName + "-disabled " + "ui-state-disabled");

            // clean up events and states
            this.bindings.unbind(this.eventNamespace);
            this.hoverable.removeClass("ui-state-hover");
            this.focusable.removeClass("ui-state-focus");
        },
        _destroy: $.noop,

        widget: function () {
            return this.element;
        },

        option: function (key, value) {
            var options = key,
             parts, curOption, i;

            if (arguments.length === 0) {
                // don't return a reference to the internal hash
                return $.widget.extend(
                {
                }, this.options);
            }

            if (typeof key === "string") {
                // handle nested keys, e.g., "foo.bar" => { foo: { bar: ___ } }
                options =
                {
                };
                parts = key.split(".");
                key = parts.shift();
                if (parts.length) {
                    curOption = options[key] = $.widget.extend(
                    {
                    }, this.options[key]);
                    for (i = 0; i < parts.length - 1; i++) {
                        curOption[parts[i]] = curOption[parts[i]] || {
                        };
                        curOption = curOption[parts[i]];
                    }
                    key = parts.pop();
                    if (value === undefined) {
                        return curOption[key] === undefined ? null : curOption[key];
                    }
                    curOption[key] = value;
                }
                else {
                    if (value === undefined) {
                        return this.options[key] === undefined ? null : this.options[key];
                    }
                    options[key] = value;
                }
            }

            this._setOptions(options);

            return this;
        },
        _setOptions: function (options) {
            var key;

            for (key in options) {
                this._setOption(key, options[key]);
            }

            return this;
        },
        _setOption: function (key, value) {
            this.options[key] = value;

            if (key === "disabled") {
                this.widget().toggleClass(this.widgetFullName + "-disabled ui-state-disabled", !!value).attr("aria-disabled", value);
                this.hoverable.removeClass("ui-state-hover");
                this.focusable.removeClass("ui-state-focus");
            }

            return this;
        },

        enable: function () {
            return this._setOption("disabled", false);
        },
        disable: function () {
            return this._setOption("disabled", true);
        },

        _on: function (suppressDisabledCheck, element, handlers) {
            var delegateElement, instance = this;

            // no suppressDisabledCheck flag, shuffle arguments
            if (typeof suppressDisabledCheck !== "boolean") {
                handlers = element;
                element = suppressDisabledCheck;
                suppressDisabledCheck = false;
            }

            // no element argument, shuffle and use this.element
            if (!handlers) {
                handlers = element;
                element = this.element;
                delegateElement = this.widget();
            }
            else {
                // accept selectors, DOM elements
                element = delegateElement = $(element);
                this.bindings = this.bindings.add(element);
            }

            $.each(handlers, function (event, handler) {
                function handlerProxy() {
                    // allow widgets to customize the disabled handling
                    // - disabled as an array instead of boolean
                    // - disabled class as method for disabling individual parts
                    if (!suppressDisabledCheck && (instance.options.disabled === true || $(this).hasClass("ui-state-disabled"))) {
                        return;
                    }
                    return (typeof handler === "string" ? instance[handler] : handler).apply(instance, arguments);
                }

                // copy the guid so direct unbinding works
                if (typeof handler !== "string") {
                    handlerProxy.guid = handler.guid =
                    handler.guid || handlerProxy.guid || $.guid++;
                }

                var match = event.match(/^(\w+)\s*(.*)$/),
                 eventName = match[1] + instance.eventNamespace,
                 selector = match[2];
                if (selector) {
                    delegateElement.delegate(selector, eventName, handlerProxy);
                }
                else {
                    element.bind(eventName, handlerProxy);
                }
            });
        },

        _off: function (element, eventName) {
            eventName = (eventName || "").split(" ").join(this.eventNamespace + " ") + this.eventNamespace;
            element.unbind(eventName).undelegate(eventName);
        },

        _delay: function (handler, delay) {
            function handlerProxy() {
                return (typeof handler === "string" ? instance[handler] : handler).apply(instance, arguments);
            }
            var instance = this;
            return setTimeout(handlerProxy, delay || 0);
        },

        _hoverable: function (element) {
            this.hoverable = this.hoverable.add(element);
            this._on(element, {
                mouseenter: function (event) {
                    $(event.currentTarget).addClass("ui-state-hover");
                },
                mouseleave: function (event) {
                    $(event.currentTarget).removeClass("ui-state-hover");
                }
            });
        },

        _focusable: function (element) {
            this.focusable = this.focusable.add(element);
            this._on(element, {
                focusin: function (event) {
                    $(event.currentTarget).addClass("ui-state-focus");
                },
                focusout: function (event) {
                    $(event.currentTarget).removeClass("ui-state-focus");
                }
            });
        },

        _trigger: function (type, event, data) {
            var prop, orig, callback = this.options[type];

            data = data || {
            };
            event = $.Event(event);
            event.type = (type === this.widgetEventPrefix ? type : this.widgetEventPrefix + type).toLowerCase();
            // the original event may come from any element
            // so we need to reset the target on the new event
            event.target = this.element[0];

            // copy original event properties over to the new event
            orig = event.originalEvent;
            if (orig) {
                for (prop in orig) {
                    if (!(prop in event)) {
                        event[prop] = orig[prop];
                    }
                }
            }

            this.element.trigger(event, data);
            return !($.isFunction(callback) && callback.apply(this.element[0], [event].concat(data)) === false || event.isDefaultPrevented());
        }
    };

   

    settings = {
        tap_pixel_range: 5,
        swipe_h_threshold: 50,
        swipe_v_threshold: 50,
        taphold_threshold: 750,
        doubletap_int: 500,

        touch_capable: ('ontouchstart' in document.documentElement),
        orientation_support: ('orientation' in window && 'onorientationchange' in window),

        startevent: ('ontouchstart' in document.documentElement)  ? 'touchstart' : 'mousedown',
        endevent: ('ontouchstart' in document.documentElement ) ? 'touchend' : 'mouseup',
        moveevent: ('ontouchstart' in document.documentElement) ? 'touchmove' : 'mousemove',
        tapevent: ('ontouchstart' in document.documentElement ) ? 'tap' : 'click',
        scrollevent: ('ontouchstart' in document.documentElement) ? 'touchmove' : 'scroll',

        hold_timer: null,
        tap_timer: null
    };

    $.event.special.swipe = {
        setup: function () {
            var thisObject = this,
                $this = $(thisObject),
                started = false,
                hasSwiped = false,
                originalCoord = {
                    x: 0,
                    y: 0
                },
                finalCoord = {
                    x: 0,
                    y: 0
                },
                startEvnt;

            // Screen touched, store the original coordinate

            function touchStart(e) {
                $this = $(e.target);
                $this.data('callee1', arguments.callee);
                originalCoord.x = (e.originalEvent.targetTouches) ? e.originalEvent.targetTouches[0].pageX : e.pageX;
                originalCoord.y = (e.originalEvent.targetTouches) ? e.originalEvent.targetTouches[0].pageY : e.pageY;
                finalCoord.x = originalCoord.x;
                finalCoord.y = originalCoord.y;
                started = true;
                var origEvent = e.originalEvent;
                // Read event data into our startEvt:
                startEvnt = {
                    'position': {
                        'x': (settings.touch_capable) ? origEvent.touches[0].screenX : e.screenX,
                        'y': (settings.touch_capable) ? origEvent.touches[0].screenY : e.screenY,
                    },
                    'offset': {
                        'x': (settings.touch_capable) ? origEvent.touches[0].pageX - origEvent.touches[0].target.offsetLeft : e.offsetX,
                        'y': (settings.touch_capable) ? origEvent.touches[0].pageY - origEvent.touches[0].target.offsetTop : e.offsetY,
                    },
                    'time': new Date().getTime(),
                    'target': e.target
                };

                // For some reason, we need to add a 100ms pause in order to trigger swiping
                // on Playbooks:
                var dt = new Date();
                while ((new Date()) - dt < 100) { }
            }

            // Store coordinates as finger is swiping

            function touchMove(e) {
                $this = $(e.target);
                $this.data('callee2', arguments.callee);
                finalCoord.x = (e.originalEvent.targetTouches) ? e.originalEvent.targetTouches[0].pageX : e.pageX;
                finalCoord.y = (e.originalEvent.targetTouches) ? e.originalEvent.targetTouches[0].pageY : e.pageY;
                window.clearTimeout(settings.hold_timer);

                var swipedir;

                // We need to check if the element to which the event was bound contains a data-xthreshold | data-vthreshold:
                var ele_x_threshold = $this.data('xthreshold'),
                    ele_y_threshold = $this.data('ythreshold'),
                    h_threshold = (typeof ele_x_threshold !== 'undefined' && ele_x_threshold !== false && parseInt(ele_x_threshold)) ? parseInt(ele_x_threshold) : settings.swipe_h_threshold,
                    v_threshold = (typeof ele_y_threshold !== 'undefined' && ele_y_threshold !== false && parseInt(ele_y_threshold)) ? parseInt(ele_y_threshold) : settings.swipe_v_threshold;

                if (originalCoord.y > finalCoord.y && (originalCoord.y - finalCoord.y > v_threshold)) {
                    swipedir = 'swipeup';
                }
                if (originalCoord.x < finalCoord.x && (finalCoord.x - originalCoord.x > h_threshold)) {
                    swipedir = 'swiperight';
                }
                if (originalCoord.y < finalCoord.y && (finalCoord.y - originalCoord.y > v_threshold)) {
                    swipedir = 'swipedown';
                }
                if (originalCoord.x > finalCoord.x && (originalCoord.x - finalCoord.x > h_threshold)) {
                    swipedir = 'swipeleft';
                }
                if (swipedir != undefined && started) {
                    originalCoord.x = 0;
                    originalCoord.y = 0;
                    finalCoord.x = 0;
                    finalCoord.y = 0;
                    started = false;

                    // Read event data into our endEvnt:
                    var origEvent = e.originalEvent;
                    endEvnt = {
                        'position': {
                            'x': (settings.touch_capable) ? origEvent.touches[0].screenX : e.screenX,
                            'y': (settings.touch_capable) ? origEvent.touches[0].screenY : e.screenY,
                        },
                        'offset': {
                            'x': (settings.touch_capable) ? origEvent.touches[0].pageX - origEvent.touches[0].target.offsetLeft : e.offsetX,
                            'y': (settings.touch_capable) ? origEvent.touches[0].pageY - origEvent.touches[0].target.offsetTop : e.offsetY,
                        },
                        'time': new Date().getTime(),
                        'target': e.target
                    };

                    // Calculate the swipe amount (normalized):
                    var xAmount = Math.abs(startEvnt.position.x - endEvnt.position.x),
                        yAmount = Math.abs(startEvnt.position.y - endEvnt.position.y);

                    var touchData = {
                        'startEvnt': startEvnt,
                        'endEvnt': endEvnt,
                        'direction': swipedir.replace('swipe', ''),
                        'xAmount': xAmount,
                        'yAmount': yAmount,
                        'duration': endEvnt.time - startEvnt.time
                    }
                    hasSwiped = true;
                    $this.trigger('swipe', touchData).trigger(swipedir, touchData);
                }
            }

            function touchEnd(e) {
                $this = $(e.target);
                var swipedir = "";
                $this.data('callee3', arguments.callee);
                if (hasSwiped) {
                    // We need to check if the element to which the event was bound contains a data-xthreshold | data-vthreshold:
                    var ele_x_threshold = $this.data('xthreshold'),
                        ele_y_threshold = $this.data('ythreshold'),
                        h_threshold = (typeof ele_x_threshold !== 'undefined' && ele_x_threshold !== false && parseInt(ele_x_threshold)) ? parseInt(ele_x_threshold) : settings.swipe_h_threshold,
                        v_threshold = (typeof ele_y_threshold !== 'undefined' && ele_y_threshold !== false && parseInt(ele_y_threshold)) ? parseInt(ele_y_threshold) : settings.swipe_v_threshold;

                    var origEvent = e.originalEvent;
                    endEvnt = {
                        'position': {
                            'x': (settings.touch_capable) ? origEvent.changedTouches[0].screenX : e.screenX,
                            'y': (settings.touch_capable) ? origEvent.changedTouches[0].screenY : e.screenY,
                        },
                        'offset': {
                            'x': (settings.touch_capable) ? origEvent.changedTouches[0].pageX - origEvent.changedTouches[0].target.offsetLeft : e.offsetX,
                            'y': (settings.touch_capable) ? origEvent.changedTouches[0].pageY - origEvent.changedTouches[0].target.offsetTop : e.offsetY,
                        },
                        'time': new Date().getTime(),
                        'target': e.target
                    };

                    // Read event data into our endEvnt:
                    if (startEvnt.position.y > endEvnt.position.y && (startEvnt.position.y - endEvnt.position.y > v_threshold)) {
                        swipedir = 'swipeup';
                    }
                    if (startEvnt.position.x < endEvnt.position.x && (endEvnt.position.x - startEvnt.position.x > h_threshold)) {
                        swipedir = 'swiperight';
                    }
                    if (startEvnt.position.y < endEvnt.position.y && (endEvnt.position.y - startEvnt.position.y > v_threshold)) {
                        swipedir = 'swipedown';
                    }
                    if (startEvnt.position.x > endEvnt.position.x && (startEvnt.position.x - endEvnt.position.x > h_threshold)) {
                        swipedir = 'swipeleft';
                    }

                    // Calculate the swipe amount (normalized):
                    var xAmount = Math.abs(startEvnt.position.x - endEvnt.position.x),
                        yAmount = Math.abs(startEvnt.position.y - endEvnt.position.y);

                    var touchData = {
                        'startEvnt': startEvnt,
                        'endEvnt': endEvnt,
                        'direction': swipedir.replace('swipe', ''),
                        'xAmount': xAmount,
                        'yAmount': yAmount,
                        'duration': endEvnt.time - startEvnt.time
                    }
                    $this.trigger('swipeend', touchData);
                }

                started = false;
                hasSwiped = false;
            }

            $this.on(settings.startevent, touchStart);
            $this.on(settings.moveevent, touchMove);
            $this.on(settings.endevent, touchEnd);
        },

        remove: function () {
            $(this).off(settings.startevent, $(this).data.callee1).off(settings.moveevent, $(this).data.callee2).off(settings.endevent, $(this).data.callee3);
        }
    };

    // Correctly on anything we've overloaded:
    $.each({
        scrollend: 'scrollstart',
        swipeup: 'swipe',
        swiperight: 'swipe',
        swipedown: 'swipe',
        swipeleft: 'swipe',
        swipeend: 'swipe',
    }, function (e, srcE, touchData) {
        $.event.special[e] = {
            setup: function () {
                $(this).on(srcE, $.noop);
            }
        };
    });


    $.widget("ui.weekWidget", {

        options: {
        	enableFutureDatesOnly:false,
            callBackForToday: function () { },
            callBackForNext: function () { },
            callBackForPrev: function () { },
            callBackForSelect: function () { },
            serverDate: new Date()
        }

        ,
        _init: function () {

            widget = this;            
           
            var elem = widget.element;
            o = widget.options;
            today = o.serverDate;
            //elem.addClass('rootNode');

            widget._datePrototype();

            var date = widget.currentWeek();

            //Store the current currentWeek in the data object
            widget.element.data('currentWeek', date);

            //backup, Since we are manupulating the above object
            widget.element.data('today', date);
            
            
            widget.element.data('setDate', widget.setDate);
            widget.element.data('getDate', widget.getDate);

            elem.html(widget._template());

            $('.calenderTable').fadeOut(500, function () {
                var temp = widget._innerTemplate(date);
                $(this).html(temp).fadeIn(700);
                $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');
            });

            widget.handleEvent();
            widget.setDayMonthYear(o.serverDate);
            
            // create DateTimePicker from input HTML element
            
            $("#date_picker").kendoDatePicker({
    			value: today,
    			format: "dd/MM/yyyy",
    			
    			min:today,
    			change: function(){
    				var datepickerDate = this.value();
    				var selectedDayNo = datepickerDate.getDay();
    				var selectedDate = datepickerDate.getDate();
    				if(selectedDate < 10 )
    					{
    					selectedDate = '0' + selectedDate;
    					}
    				var startDate = new Date(datepickerDate.setDate(datepickerDate.getDate() - datepickerDate.getDay()));
    				var currentWeek = widget.getCurrentWeek(startDate);
    	            var elem = widget.element;
    	            var o = widget.options;
    	            widget.element.data('currentWeek', currentWeek);
    				$(elem).find('.calenderTable').css('margin-left', (width)).html(widget._innerTemplate(currentWeek)).animate({ 'margin-left': 0 });
    				var selectedWeek = widget.element.data('currentWeek');
    				var dateMonthYear = widget.getDayMonthYear(selectedWeek, selectedDate);
                    widget.setDayMonthYear(dateMonthYear);
                    
                   /* if (widget.checkToday()) $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');*/
                    /*else*/ $('.wc-day-' + selectedDayNo ).addClass('Wcal_Day_select');
                    o.callBackForNext();
                    /*o.callBackForSelect();*/
    			} 	
            });
            
            

        }

        //***************************************************************//
        // PUBLIC FUNCTION
        //***************************************************************//
        ,
        currentWeek: function () {

            var today = o.serverDate;
            var curr = new Date(o.serverDate);

            var startDate = new Date(curr.setDate(curr.getDate() - curr.getDay()));
            

            return {
                today: today.getDate(),
                firstDay: startDate.addDays(0),
                secondDay: startDate.addDays(1),
                thirdDay: startDate.addDays(2),
                fourthDay: startDate.addDays(3),
                fifthDay: startDate.addDays(4),
                sixthDay: startDate.addDays(5),
                seventhDay: startDate.addDays(6),
                currentMonth: startDate.getMonth(),
                currentYear: startDate.getFullYear(),
                todayDay: dayConverter[today.getDay()]
                
                
            }

        }

        ,
        nextWeek: function (startDate) {

            var startDate = startDate.firstDay.addDays(7);

            return {
                firstDay: startDate.addDays(0),
                secondDay: startDate.addDays(1),
                thirdDay: startDate.addDays(2),
                fourthDay: startDate.addDays(3),
                fifthDay: startDate.addDays(4),
                sixthDay: startDate.addDays(5),
                seventhDay: startDate.addDays(6),
                currentMonth: startDate.getMonth(),
                currentYear: startDate.getFullYear()
            };
        }

        
        ,
        getCurrentWeek: function (startDate) {

            return {
                firstDay: startDate.addDays(0),
                secondDay: startDate.addDays(1),
                thirdDay: startDate.addDays(2),
                fourthDay: startDate.addDays(3),
                fifthDay: startDate.addDays(4),
                sixthDay: startDate.addDays(5),
                seventhDay: startDate.addDays(6),
                currentMonth: startDate.getMonth(),
                currentYear: startDate.getFullYear()
            };
        }
        ,
        prevWeek: function (startDate) {

            var startDate = startDate.firstDay.addDays(-7);

            return {
                firstDay: startDate.addDays(0),
                secondDay: startDate.addDays(1),
                thirdDay: startDate.addDays(2),
                fourthDay: startDate.addDays(3),
                fifthDay: startDate.addDays(4),
                sixthDay: startDate.addDays(5),
                seventhDay: startDate.addDays(6),
                currentMonth: startDate.getMonth(),
                currentYear: startDate.getFullYear()
            };

        },
        
        setDate: function(startDate){
           // var date = this.getCurrentWeek(startDate);
            var date = widget.getCurrentWeek(startDate), selectedWeek = widget.element.data('currentWeek');        
            
            var dateMonthYear = widget.getDayMonthYear(selectedWeek, startDate);
            widget.setDayMonthYear(dateMonthYear);

           
            widget.setDayMonthYear(date.firstDay);
            var highlighted = $('.Wcal_Day_select');
            $.each(highlighted, function () {
                highlighted.removeClass('Wcal_Day_select');
            });
            $('.wc-day-' + startDate.getDay()).addClass('Wcal_Day_select');
            
            //o.callBackForPrev();
        }
        ,
        getDate: function(){
        	 //var date = widget.getCurrentWeek(startDate); 
        	 selectedWeek = widget.element.data('currentWeek');  
        	 selectedDate = $(".Wcal_Day_select").html();
             var dateMonthYear = widget.getDayMonthYear(selectedWeek, selectedDate);
             var currentDateObj = o.serverDate;
             currentDateObj.setDate(dateMonthYear.selectedDate);
             currentDateObj.setMonth(dateMonthYear.month);
             currentDateObj.setMonth(dateMonthYear.year);
             return currentDateObj;
        },
        removeSelection: function () {

            var highlighted = $('.Wcal_Day_select');
            // alert(highlighted);

            $.each(highlighted, function () {

                highlighted.removeClass('Wcal_Day_select');
            });

        }

        ,
        checkToday: function () {
            var currentSelection = this.element.data('currentWeek'),
             today = o.serverDate;

            today.today = today.getDate();

            if (currentSelection.currentYear == today.getFullYear() && currentSelection.currentMonth == today.getMonth()) {
                if (currentSelection.firstDay.getDate() == today.today || currentSelection.secondDay.getDate() == today.today || currentSelection.thirdDay.getDate() == today.today || currentSelection.fourthDay.getDate() == today.today || currentSelection.fifthDay.getDate() == today.today || currentSelection.sixthDay.getDate() == today.today || currentSelection.seventhDay.getDate() == today.today){
                	return true;
                } 
                else{
                	return false;
                }
                	
            }
            else 
            	return false
        },

        getDayMonthYear: function (selectedWeek, selectedDate) {
            var _day, _month, _year;
            var firstDay = selectedWeek['firstDay']; if (firstDay.getDate() == selectedDate) { _day = dayName[firstDay.getDay()]; _month = monthName[firstDay.getMonth()]; _year = firstDay.getFullYear(); widget.element.data('selectedDate', firstDay); };
            var secondDay = selectedWeek['secondDay']; if (secondDay.getDate() == selectedDate) { _day = dayName[secondDay.getDay()]; _month = monthName[secondDay.getMonth()]; _year = secondDay.getFullYear(); widget.element.data('selectedDate', secondDay); };
            var thirdDay = selectedWeek['thirdDay']; if (thirdDay.getDate() == selectedDate) { _day = dayName[thirdDay.getDay()]; _month = monthName[thirdDay.getMonth()]; _year = thirdDay.getFullYear(); widget.element.data('selectedDate', thirdDay); };
            var fourthDay = selectedWeek['fourthDay']; if (fourthDay.getDate() == selectedDate) { _day = dayName[fourthDay.getDay()]; _month = monthName[fourthDay.getMonth()]; _year = fourthDay.getFullYear(); widget.element.data('selectedDate', fourthDay); };
            var fifthDay = selectedWeek['fifthDay']; if (fifthDay.getDate() == selectedDate) { _day = dayName[fifthDay.getDay()]; _month = monthName[fifthDay.getMonth()]; _year = fifthDay.getFullYear(); widget.element.data('selectedDate', fifthDay); };
            var sixthDay = selectedWeek['sixthDay']; if (sixthDay.getDate() == selectedDate) { _day = dayName[sixthDay.getDay()]; _month = monthName[sixthDay.getMonth()]; _year = sixthDay.getFullYear(); widget.element.data('selectedDate', sixthDay); };
            var seventhDay = selectedWeek['seventhDay']; if (seventhDay.getDate() == selectedDate) { _day = dayName[seventhDay.getDay()]; _month = monthName[seventhDay.getMonth()]; _year = seventhDay.getFullYear(); widget.element.data('selectedDate', seventhDay); };
            return { day: _day, month: _month, year: _year, selectedDate: selectedDate };
        },

        setDayMonthYear: function (dateMonthYear) {
            var day, month, year, dayNum;
            if (dateMonthYear instanceof Date) {
                day = dayName[dateMonthYear.getDay()];
                month = monthName[dateMonthYear.getMonth()];
                year = dateMonthYear.getFullYear();
                dayNum = (dateMonthYear.getDate() < 10 ? '0' : '') + dateMonthYear.getDate();
            }
            else {
                day = dateMonthYear.day;
                month = dateMonthYear.month;
                year = dateMonthYear.year;
                dayNum = dateMonthYear.selectedDate;

            }
            $('.dayfont').html(day);
            $('.Monthfont').html(month + ',' + year);
            $('.DayNumfont').html(dayNum);
        }

        //***************************************************************//
        // EVENT HANDLERS
        //***************************************************************//
        ,
        handleEvent: function () {
            var widget = this,
             o = widget.options,
             elem = widget.element;
            todayDate = o.serverDate;
            

            //Changed the  event handler from 'live' to 'on' since 'live' is deprecated from jquery v1.9
            $('.Wcal_Day').on(clickHandler, '.Wcal_Day_Title', function (e) { 
                widget.removeSelection();
                $(this).addClass('Wcal_Day_select');
                var name = $(this).html();
                widget.element.data('currentWeek', date);

            });
            	//Date Selection
            $('.content').on('click', '.Wcal_Day_Title', function (e) { 
                widget.removeSelection();
                $(this).addClass('Wcal_Day_select');
                var selectedDate = $(this).html();
                var selectedWeek = widget.element.data('currentWeek');
                var dateMonthYear = widget.getDayMonthYear(selectedWeek, selectedDate);
                widget.setDayMonthYear(dateMonthYear);
                o.callBackForSelect();
                e.stopPropagation();
            });
            // right arrow
            $('.right_arrow').click(function (e) {
                var date = widget.nextWeek(widget.element.data('currentWeek'));
                $(elem).find('.calenderTable').css('margin-left', (width)).html(widget._innerTemplate(date)).animate({ 'margin-left': 0 });
                widget.element.data('currentWeek', date);
                if (widget.checkToday()) $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');
                else $('.wc-day-0').addClass('Wcal_Day_select');
                if(widget.checkToday()) widget.setDayMonthYear(todayDate);
                else widget.setDayMonthYear(date.firstDay);
                o.callBackForNext();
            });
            	// swipe left
            $('#calcontainer').bind("swipeleft", function (e) {
            	
                var date = widget.nextWeek(widget.element.data('currentWeek'));
                $(elem).find('.calenderTable').css('margin-left', (width)).html(widget._innerTemplate(date)).animate({ 'margin-left': 0 });
                widget.element.data('currentWeek', date);
                if (widget.checkToday()) $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');
                else $('.wc-day-0').addClass('Wcal_Day_select');
                 if(widget.checkToday()) widget.setDayMonthYear(todayDate);
                 else widget.setDayMonthYear(date.firstDay);
                o.callBackForNext();
            });
            	// swipe right
            $('#calcontainer').bind("swiperight", function (e) {
                var date = widget.prevWeek(widget.element.data('currentWeek'));
                $(elem).find('.calenderTable').css('margin-left', -(width)).html(widget._innerTemplate(date)).animate({ 'margin-left': 0 });
                widget.element.data('currentWeek', date);
                if (widget.checkToday()) $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');
                else $('.wc-day-0').addClass('Wcal_Day_select');
                if(widget.checkToday()) widget.setDayMonthYear(todayDate);
                else widget.setDayMonthYear(date.firstDay);
                o.callBackForPrev();
            });
            	// left arrow
            $('.left_arrow').click(function (e) {
                var date = widget.prevWeek(widget.element.data('currentWeek'));
                $(elem).find('.calenderTable').css('margin-left', -(width)).html(widget._innerTemplate(date)).animate({ 'margin-left': 0 });
                widget.element.data('currentWeek', date);
                if (widget.checkToday()) $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');
                else $('.wc-day-0').addClass('Wcal_Day_select');
                if(widget.checkToday()) widget.setDayMonthYear(todayDate);
                else widget.setDayMonthYear(date.firstDay);
                o.callBackForPrev();
            });
            	//Today button event handler
            $('.content').on('click','.Today_btn', function (e) { // .on to .live
                var date = widget.currentWeek();
                $(elem).find('.calenderTable').css('margin-left', -(width)).html(widget._innerTemplate(date)).animate({ 'margin-left': 0 });
                widget.element.data('currentWeek', date);
                $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');
                widget.setDayMonthYear(o.serverDate);
                o.callBackForToday();
                e.stopPropagation();
                
            });

            
        }


        //***************************************************************//
        // PRIVATE FUNCTION
        //***************************************************************//
        ,
        _datePrototype: function () {

            Date.prototype.addDays = function (days) {
                var dat = new Date(this.valueOf());
                dat.setDate(dat.getDate() + days);
                return dat;
            };

        }

        //Template functions
        ,

        _template: function () {
            return '<div class="content">' +
    '<div class="top_block Cal_Top">' +
    '<div class="content">' +
      '<div class="background Cal_Right">' +
        '<div class="right_block Cal_Right">' +
          '<div class="content">' +
            '<div class="top_block Cal_Right_Top">' +	
              '<div class="content">' +
                '<div class="background Date_Num">' +
                  '<div class="right_block Date_Num">' +
                    '<div class="content DayNumfont"></div>' +
                 ' </div>' +
                '</div>' +
                '<div class="background Date_Month">' +
                  '<div class="center_block Date_Month">' +
                    '<div class="content">' +
                      '<div class="top_block Date_Month_Display">' +
                        '<div class="content Monthfont"> </div>' +
                    '  </div>' +
                      '<div class="center_block Date_day">' +
                        '<div class="content dayfont"> </div>' +
                    '  </div>' +
                    '</div>' +
                 ' </div>' +
               ' </div>' +
             ' </div>' +
          '  </div>' +

          '<div class="background Cal_Right_Bottom">' +
            '<div class="center_block Cal_Right_Bottom">' +
              '<div class="content"> ' +
                 '&nbsp;' +
                '<div class="background Week_Cal">' +
                  '<div class="right_block Week_Cal">' +
                    '<div class="content" onclick="openCal()" style="text-align: center;"  >' +
                     /* '<input id="date_picker" data-type="Date" data-role="none" style="width:15px;height:15px" > ' +*/
                    '<input id="date_picker" name="date_picker" id="date_picker" value="" style="visibility: hidden;height: 15px;overflow: hidden;position: absolute;top: 0;right: 0;width: 200px;">'+
                   ' <?xml version="1.0" encoding="utf-8"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="13" height="14" viewBox="0 0 13 14"><g id="icomoon-ignore"><line stroke-width="1" x1="" y1="" x2="" y2="" stroke="#449FDB" opacity=""></line></g><path d="M0 13v-10q0-0.406 0.297-0.703t0.703-0.297h1v-0.75q0-0.516 0.367-0.883t0.883-0.367h0.5q0.516 0 0.883 0.367t0.367 0.883v0.75h3v-0.75q0-0.516 0.367-0.883t0.883-0.367h0.5q0.516 0 0.883 0.367t0.367 0.883v0.75h1q0.406 0 0.703 0.297t0.297 0.703v10q0 0.406-0.297 0.703t-0.703 0.297h-11q-0.406 0-0.703-0.297t-0.297-0.703zM1 13h11v-8h-11v8zM3 3.5q0 0.109 0.070 0.18t0.18 0.070h0.5q0.109 0 0.18-0.070t0.070-0.18v-2.25q0-0.109-0.070-0.18t-0.18-0.070h-0.5q-0.109 0-0.18 0.070t-0.070 0.18v2.25zM9 3.5q0 0.109 0.070 0.18t0.18 0.070h0.5q0.109 0 0.18-0.070t0.070-0.18v-2.25q0-0.109-0.070-0.18t-0.18-0.070h-0.5q-0.109 0-0.18 0.070t-0.070 0.18v2.25z"fill="#1385be"></path></svg> ' + 
                   ' </div>' +
                  '</div>' +
               ' </div>' +
                '<div class="background Today_Pick">' +
                  '<div class="center_block Today_Pick">' +
                    '<div class="content">' +
                      '<div class="Today_btn"> Today </div>' +
                   ' </div>' +
                  '</div>' +
                '</div>' +
              '</div>' +
            '</div>' +
         ' </div>' +
         '</div>' +
       ' </div>' +
      '</div>' +
      '<div class="background Cal_Left">' +
        '<div class="background Cal_Left_LeftArrow">' +
          '<div class="left_block Cal_Left_LeftArrow">' +
            '<div class="content">' +
              '<div class="ArrowCon">' +
                '<div class="left_arrow"> ' +
                  '<?xml version="1.0"?><svg width="10" height="19" xmlns="http://www.w3.org/2000/svg"><g><title>Layer 1</title><path stroke="#c6c6c6" id="svg_25" d="m3.836303,9.497642l3.147626,-7.90425l-2.072957,0l-3.147642,7.90425l3.147642,7.904222l2.072957,0l-3.147626,-7.904222z" stroke-width="3" fill="#000"/></g></svg>' +
                '</div>' +
              '</div>' +
           ' </div>' +
         ' </div>' +
        '</div>' +
        '<div class="background Cal-Left_RightArrow">' +
          '<div class="right_block Cal-Left_RightArrow">' +
            '<div class="content">' +
              '<div class="ArrowCon">' +
                '<div class="right_arrow" > <?xml version="1.0"?><svg width="10" height="19" xmlns="http://www.w3.org/2000/svg"><g><title>Layer 1</title><path stroke="#c6c6c6" id="svg_25" d="m5.909583,9.417938l-3.628176,-7.90425l2.389436,0l3.628195,7.90425l-3.628195,7.904221l-2.389436,0l3.628176,-7.904221z" stroke-width="3" fill="#000"/></g></svg>' +
             ' </div>' +
            '</div>' +
         ' </div>' +
        '</div>' +
     '</div>' +
            '<div class="background Cal_Left_WeekCal">' +
              '<div class="center_block Cal_Left_WeekCal">' +
                '<div class="content"> ' +
                 '<div style="width:99%;" class="rootNode">' +
                    '<div class="wc-container" id="calcontainer">' +
                    '  <table border="0" cellspacing="0" cellpadding="0" class="calenderTable" style="float:left;width:100%;" >' +

                     ' </table>' +
                '  </div>' +
                '  </div>' +
               ' </div>' +
             ' </div>' +
            '</div>' +
         ' </div>' +
        '</div>' +
      '</div>' +
    '</div>'
        }

        , _innerTemplate: function (currentWeek) {
        	var o = widget.options;
        	var date_today = o.serverDate;
        	if(date_today <= currentWeek.seventhDay && date_today >= currentWeek.firstDay)  {
        		$('#calcontainer').unbind("swiperight");
        		swipeRightBindCount =0;
        		$(".left_arrow").hide();
        		return '<tr class="Wcal_Title">' +
			                '<td class="' + (currentWeek.firstDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-0' : '') + '" align="center" valign="middle">S</td>' +
			                '<td class="' + (currentWeek.secondDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-1' : '') + '" align="center" valign="middle">M</td>' +
			                '<td class="' + (currentWeek.thirdDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-2' : '') + '" align="center" valign="middle">T</td>' +
			                '<td class="' + (currentWeek.fourthDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-3' : '') + '" align="center" valign="middle">W</td>' +
			                '<td class="' + (currentWeek.fifthDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-4' : '') + '" align="center" valign="middle">T</td>' +
			                '<td class="' + (currentWeek.sixthDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-5' : '') + '" align="center" valign="middle">F</td>' +
			                '<td class="' + (currentWeek.seventhDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-6' : '') + '" align="center" valign="middle">S</td>' +
			           '</tr>' +
			           '<tr class="Wcal_Day">' +
			                '<td class="' + (currentWeek.firstDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-0' : 'Wcal_Day_Title wc-day-0') + '" align="center" valign="middle" >' + (currentWeek.firstDay.getDate() < 10 ? '0' : '') + currentWeek.firstDay.getDate() + '</td>' +
			                '<td class="' + (currentWeek.secondDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-1' : 'Wcal_Day_Title wc-day-1') + '" align="center" valign="middle" >' + (currentWeek.secondDay.getDate() < 10 ? '0' : '') + currentWeek.secondDay.getDate() + '</td>' +
			                '<td class="' + (currentWeek.thirdDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-2' : 'Wcal_Day_Title wc-day-2') + '" align="center" valign="middle" >' + (currentWeek.thirdDay.getDate() < 10 ? '0' : '') + currentWeek.thirdDay.getDate() + '</td>' +
			                '<td class="' + (currentWeek.fourthDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-3' : 'Wcal_Day_Title wc-day-3') + '" align="center" valign="middle" >' + (currentWeek.fourthDay.getDate() < 10 ? '0' : '') + currentWeek.fourthDay.getDate() + '</td>' +
			                '<td class="' + (currentWeek.fifthDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-4' : 'Wcal_Day_Title wc-day-4') + '" align="center" valign="middle" >' + (currentWeek.fifthDay.getDate() < 10 ? '0' : '') + currentWeek.fifthDay.getDate() + '</td>' +
			                '<td class="' + (currentWeek.sixthDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-5' : 'Wcal_Day_Title wc-day-5') + '" align="center" valign="middle" >' + (currentWeek.sixthDay.getDate() < 10 ? '0' : '') + currentWeek.sixthDay.getDate() + '</td>' +
			                '<td class="' + (currentWeek.seventhDay < date_today ? 'Wcal_Past_Day_Title wc-pastday-6' : 'Wcal_Day_Title wc-day-6') + '" align="center" valign="middle" >' + (currentWeek.seventhDay.getDate() < 10 ? '0' : '') + currentWeek.seventhDay.getDate() + '</td>' +
			            '</tr>'
        		
        	}else{
        		$(".left_arrow").show();
        		if(swipeRightBindCount == 0){
        		$('#calcontainer').bind("swiperight", function (e) {
        			//var widget = this,
                    var o = widget.options,
                    elem = widget.element;
        		    var todayDate = o.serverDate;
                    var date = widget.prevWeek(widget.element.data('currentWeek'));
                    $(elem).find('.calenderTable').css('margin-left', -(width)).html(widget._innerTemplate(date)).animate({ 'margin-left': 0 });
                    widget.element.data('currentWeek', date);
                    if (widget.checkToday()) $('.wc-day-' + today.getDay()).addClass('Wcal_Day_select');
                    else $('.wc-day-0').addClass('Wcal_Day_select');
                    if(widget.checkToday()) widget.setDayMonthYear(todayDate);
                    else widget.setDayMonthYear(date.firstDay);
                    o.callBackForPrev();
                });
        		swipeRightBindCount++;
        		}
        		 return '<tr class="Wcal_Title">' +
			                 '<td align="center" valign="middle">S</td>' +
			                 '<td align="center" valign="middle">M</td>' +
			                 '<td align="center" valign="middle">T</td>' +
			                 '<td align="center" valign="middle">W</td>' +
			                 '<td align="center" valign="middle">T</td>' +
			                 '<td align="center" valign="middle">F</td>' +
			                 '<td align="center" valign="middle">S</td>' +
			            '</tr>' +
			            '<tr class="Wcal_Day">' +
			                 '<td class="Wcal_Day_Title wc-day-0" align="center" valign="middle" >' + (currentWeek.firstDay.getDate() < 10 ? '0' : '') + currentWeek.firstDay.getDate() + '</td>' +
			                 '<td class="Wcal_Day_Title wc-day-1" align="center" valign="middle" >' + (currentWeek.secondDay.getDate() < 10 ? '0' : '') + currentWeek.secondDay.getDate() + '</td>' +
			                 '<td class="Wcal_Day_Title wc-day-2" align="center" valign="middle" >' + (currentWeek.thirdDay.getDate() < 10 ? '0' : '') + currentWeek.thirdDay.getDate() + '</td>' +
			                 '<td class="Wcal_Day_Title wc-day-3" align="center" valign="middle" >' + (currentWeek.fourthDay.getDate() < 10 ? '0' : '') + currentWeek.fourthDay.getDate() + '</td>' +
			                 '<td class="Wcal_Day_Title wc-day-4" align="center" valign="middle" >' + (currentWeek.fifthDay.getDate() < 10 ? '0' : '') + currentWeek.fifthDay.getDate() + '</td>' +
			                 '<td class="Wcal_Day_Title wc-day-5" align="center" valign="middle" >' + (currentWeek.sixthDay.getDate() < 10 ? '0' : '') + currentWeek.sixthDay.getDate() + '</td>' +
			                 '<td class="Wcal_Day_Title wc-day-6" align="center" valign="middle" >' + (currentWeek.seventhDay.getDate() < 10 ? '0' : '') + currentWeek.seventhDay.getDate() + '</td>' +
			             '</tr>'
        	}
            
        }

    })
})(jQuery);

