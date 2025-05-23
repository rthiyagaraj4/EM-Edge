(function () {

    /**
    * Config is a utility used within an Object to allow the implementer to
    * maintain a list of local configuration properties and listen for changes 
    * to those properties dynamically using CustomEvent. The initial values are 
    * also maintained so that the configuration can be reset at any given point 
    * to its initial state.
    * @namespace ISOFT.util
    * @class Config
    * @constructor
    * @param {Object} owner The owner Object to which this Config Object belongs
    */
    ISOFT.util.Config = function (owner) {

        if (owner) {
            this.init(owner);
        }


    };


    var Lang = ISOFT.lang,
        CustomEvent = ISOFT.util.CustomEvent,
        Config = ISOFT.util.Config;


    /**
     * Constant representing the CustomEvent type for the config changed event.
     * @property ISOFT.util.Config.CONFIG_CHANGED_EVENT
     * @private
     * @static
     * @final
     */
    Config.CONFIG_CHANGED_EVENT = "configChanged";
    
    /**
     * Constant representing the boolean type string
     * @property ISOFT.util.Config.BOOLEAN_TYPE
     * @private
     * @static
     * @final
     */
    Config.BOOLEAN_TYPE = "boolean";
    
    Config.prototype = {
     
        /**
        * Object reference to the owner of this Config Object
        * @property owner
        * @type Object
        */
        owner: null,
        
        /**
        * Boolean flag that specifies whether a queue is currently 
        * being executed
        * @property queueInProgress
        * @type Boolean
        */
        queueInProgress: false,
        
        /**
        * Maintains the local collection of configuration property objects and 
        * their specified values
        * @property config
        * @private
        * @type Object
        */ 
        config: null,
        
        /**
        * Maintains the local collection of configuration property objects as 
        * they were initially applied.
        * This object is used when resetting a property.
        * @property initialConfig
        * @private
        * @type Object
        */ 
        initialConfig: null,
        
        /**
        * Maintains the local, normalized CustomEvent queue
        * @property eventQueue
        * @private
        * @type Object
        */ 
        eventQueue: null,
        
        /**
        * Custom Event, notifying subscribers when Config properties are set 
        * (setProperty is called without the silent flag
        * @event configChangedEvent
        */
        configChangedEvent: null,
    
        /**
        * Initializes the configuration Object and all of its local members.
        * @method init
        * @param {Object} owner The owner Object to which this Config 
        * Object belongs
        */
        init: function (owner) {
    
            this.owner = owner;
    
            this.configChangedEvent = 
                this.createEvent(Config.CONFIG_CHANGED_EVENT);
    
            this.configChangedEvent.signature = CustomEvent.LIST;
            this.queueInProgress = false;
            this.config = {};
            this.initialConfig = {};
            this.eventQueue = [];
        
        },
        
        /**
        * Validates that the value passed in is a Boolean.
        * @method checkBoolean
        * @param {Object} val The value to validate
        * @return {Boolean} true, if the value is valid
        */ 
        checkBoolean: function (val) {
            return (typeof val == Config.BOOLEAN_TYPE);
        },
        
        /**
        * Validates that the value passed in is a number.
        * @method checkNumber
        * @param {Object} val The value to validate
        * @return {Boolean} true, if the value is valid
        */
        checkNumber: function (val) {
            return (!isNaN(val));
        },
        
        /**
        * Fires a configuration property event using the specified value. 
        * @method fireEvent
        * @private
        * @param {String} key The configuration property's name
        * @param {value} Object The value of the correct type for the property
        */ 
        fireEvent: function ( key, value ) {
            var property = this.config[key];
        
            if (property && property.event) {
                property.event.fire(value);
            } 
        },
        
        /**
        * Adds a property to the Config Object's private config hash.
        * @method addProperty
        * @param {String} key The configuration property's name
        * @param {Object} propertyObject The Object containing all of this 
        * property's arguments
        */
        addProperty: function ( key, propertyObject ) {
            key = key.toLowerCase();
        
            this.config[key] = propertyObject;
        
            propertyObject.event = this.createEvent(key, { scope: this.owner });
            propertyObject.event.signature = CustomEvent.LIST;
            
            
            propertyObject.key = key;
        
            if (propertyObject.handler) {
                propertyObject.event.subscribe(propertyObject.handler, 
                    this.owner);
            }
        
            this.setProperty(key, propertyObject.value, true);
            
            if (! propertyObject.suppressEvent) {
                this.queueProperty(key, propertyObject.value);
            }
            
        },
        
        /**
        * Returns a key-value configuration map of the values currently set in  
        * the Config Object.
        * @method getConfig
        * @return {Object} The current config, represented in a key-value map
        */
        getConfig: function () {
        
            var cfg = {},
                prop,
                property;
                
            for (prop in this.config) {
                property = this.config[prop];
                if (property && property.event) {
                    cfg[prop] = property.value;
                }
            }
            
            return cfg;
        },
        
        /**
        * Returns the value of specified property.
        * @method getProperty
        * @param {String} key The name of the property
        * @return {Object}  The value of the specified property
        */
        getProperty: function (key) {
            var property = this.config[key.toLowerCase()];
            if (property && property.event) {
                return property.value;
            } else {
                return undefined;
            }
        },
        
        /**
        * Resets the specified property's value to its initial value.
        * @method resetProperty
        * @param {String} key The name of the property
        * @return {Boolean} True is the property was reset, false if not
        */
        resetProperty: function (key) {
    
            key = key.toLowerCase();
        
            var property = this.config[key];
    
            if (property && property.event) {
    
                if (this.initialConfig[key] && 
                    !Lang.isUndefined(this.initialConfig[key])) {
    
                    this.setProperty(key, this.initialConfig[key]);

                    return true;
    
                }
    
            } else {
    
                return false;
            }
    
        },
        
        /**
        * Sets the value of a property. If the silent property is passed as 
        * true, the property's event will not be fired.
        * @method setProperty
        * @param {String} key The name of the property
        * @param {String} value The value to set the property to
        * @param {Boolean} silent Whether the value should be set silently, 
        * without firing the property event.
        * @return {Boolean} True, if the set was successful, false if it failed.
        */
        setProperty: function (key, value, silent) {
        
            var property;
        
            key = key.toLowerCase();
        
            if (this.queueInProgress && ! silent) {
                // Currently running through a queue... 
                this.queueProperty(key,value);
                return true;
    
            } else {
                property = this.config[key];
                if (property && property.event) {
                    if (property.validator && !property.validator(value)) {
                        return false;
                    } else {
                        property.value = value;
                        if (! silent) {
                            this.fireEvent(key, value);
                            this.configChangedEvent.fire([key, value]);
                        }
                        return true;
                    }
                } else {
                    return false;
                }
            }
        },
        
        /**
        * Sets the value of a property and queues its event to execute. If the 
        * event is already scheduled to execute, it is
        * moved from its current position to the end of the queue.
        * @method queueProperty
        * @param {String} key The name of the property
        * @param {String} value The value to set the property to
        * @return {Boolean}  true, if the set was successful, false if 
        * it failed.
        */ 
        queueProperty: function (key, value) {
        
            key = key.toLowerCase();
        
            var property = this.config[key],
                foundDuplicate = false,
                iLen,
                queueItem,
                queueItemKey,
                queueItemValue,
                sLen,
                supercedesCheck,
                qLen,
                queueItemCheck,
                queueItemCheckKey,
                queueItemCheckValue,
                i,
                s,
                q;
                                
            if (property && property.event) {
    
                if (!Lang.isUndefined(value) && property.validator && 
                    !property.validator(value)) { // validator
                    return false;
                } else {
        
                    if (!Lang.isUndefined(value)) {
                        property.value = value;
                    } else {
                        value = property.value;
                    }
        
                    foundDuplicate = false;
                    iLen = this.eventQueue.length;
        
                    for (i = 0; i < iLen; i++) {
                        queueItem = this.eventQueue[i];
        
                        if (queueItem) {
                            queueItemKey = queueItem[0];
                            queueItemValue = queueItem[1];

                            if (queueItemKey == key) {
    
                                /*
                                    found a dupe... push to end of queue, null 
                                    current item, and break
                                */
    
                                this.eventQueue[i] = null;
    
                                this.eventQueue.push(
                                    [key, (!Lang.isUndefined(value) ? 
                                    value : queueItemValue)]);
    
                                foundDuplicate = true;
                                break;
                            }
                        }
                    }
                    
                    // this is a refire, or a new property in the queue
    
                    if (! foundDuplicate && !Lang.isUndefined(value)) { 
                        this.eventQueue.push([key, value]);
                    }
                }
        
                if (property.supercedes) {

                    sLen = property.supercedes.length;

                    for (s = 0; s < sLen; s++) {

                        supercedesCheck = property.supercedes[s];
                        qLen = this.eventQueue.length;

                        for (q = 0; q < qLen; q++) {
                            queueItemCheck = this.eventQueue[q];

                            if (queueItemCheck) {
                                queueItemCheckKey = queueItemCheck[0];
                                queueItemCheckValue = queueItemCheck[1];

                                if (queueItemCheckKey == 
                                    supercedesCheck.toLowerCase() ) {

                                    this.eventQueue.push([queueItemCheckKey, 
                                        queueItemCheckValue]);

                                    this.eventQueue[q] = null;
                                    break;

                                }
                            }
                        }
                    }
                }


                return true;
            } else {
                return false;
            }
        },
        
        /**
        * Fires the event for a property using the property's current value.
        * @method refireEvent
        * @param {String} key The name of the property
        */
        refireEvent: function (key) {
    
            key = key.toLowerCase();
        
            var property = this.config[key];
    
            if (property && property.event && 
    
                !Lang.isUndefined(property.value)) {
    
                if (this.queueInProgress) {
    
                    this.queueProperty(key);
    
                } else {
    
                    this.fireEvent(key, property.value);
    
                }
    
            }
        },
        
        /**
        * Applies a key-value Object literal to the configuration, replacing  
        * any existing values, and queueing the property events.
        * Although the values will be set, fireQueue() must be called for their 
        * associated events to execute.
        * @method applyConfig
        * @param {Object} userConfig The configuration Object literal
        * @param {Boolean} init  When set to true, the initialConfig will 
        * be set to the userConfig passed in, so that calling a reset will 
        * reset the properties to the passed values.
        */
        applyConfig: function (userConfig, init) {
        
            var sKey,
                oConfig;

            if (init) {
                oConfig = {};
                for (sKey in userConfig) {
                    if (Lang.hasOwnProperty(userConfig, sKey)) {
                        oConfig[sKey.toLowerCase()] = userConfig[sKey];
                    }
                }
                this.initialConfig = oConfig;
            }

            for (sKey in userConfig) {
                if (Lang.hasOwnProperty(userConfig, sKey)) {
                    this.queueProperty(sKey, userConfig[sKey]);
                }
            }
        },
        
        /**
        * Refires the events for all configuration properties using their 
        * current values.
        * @method refresh
        */
        refresh: function () {
        
            var prop;
        
            for (prop in this.config) {
                this.refireEvent(prop);
            }
        },
        
        /**
        * Fires the normalized list of queued property change events
        * @method fireQueue
        */
        fireQueue: function () {
        
            var i, 
                queueItem,
                key,
                value,
                property;
        
            this.queueInProgress = true;
            for (i = 0;i < this.eventQueue.length; i++) {
                queueItem = this.eventQueue[i];
                if (queueItem) {
        
                    key = queueItem[0];
                    value = queueItem[1];
                    property = this.config[key];
        
                    property.value = value;
        
                    this.fireEvent(key,value);
                }
            }
            
            this.queueInProgress = false;
            this.eventQueue = [];
        },
        
        /**
        * Subscribes an external handler to the change event for any 
        * given property. 
        * @method subscribeToConfigEvent
        * @param {String} key The property name
        * @param {Function} handler The handler function to use subscribe to 
        * the property's event
        * @param {Object} obj The Object to use for scoping the event handler 
        * (see CustomEvent documentation)
        * @param {Boolean} override Optional. If true, will override "this"  
        * within the handler to map to the scope Object passed into the method.
        * @return {Boolean} True, if the subscription was successful, 
        * otherwise false.
        */ 
        subscribeToConfigEvent: function (key, handler, obj, override) {
    
            var property = this.config[key.toLowerCase()];
    
            if (property && property.event) {
                if (!Config.alreadySubscribed(property.event, handler, obj)) {
                    property.event.subscribe(handler, obj, override);
                }
                return true;
            } else {
                return false;
            }
    
        },
        
        /**
        * Unsubscribes an external handler from the change event for any 
        * given property. 
        * @method unsubscribeFromConfigEvent
        * @param {String} key The property name
        * @param {Function} handler The handler function to use subscribe to 
        * the property's event
        * @param {Object} obj The Object to use for scoping the event 
        * handler (see CustomEvent documentation)
        * @return {Boolean} True, if the unsubscription was successful, 
        * otherwise false.
        */
        unsubscribeFromConfigEvent: function (key, handler, obj) {
            var property = this.config[key.toLowerCase()];
            if (property && property.event) {
                return property.event.unsubscribe(handler, obj);
            } else {
                return false;
            }
        },
        
        /**
        * Returns a string representation of the Config object
        * @method toString
        * @return {String} The Config object in string format.
        */
        toString: function () {
            var output = "Config";
            if (this.owner) {
                output += " [" + this.owner.toString() + "]";
            }
            return output;
        },
        
        /**
        * Returns a string representation of the Config object's current 
        * CustomEvent queue
        * @method outputEventQueue
        * @return {String} The string list of CustomEvents currently queued 
        * for execution
        */
        outputEventQueue: function () {

            var output = "",
                queueItem,
                q,
                nQueue = this.eventQueue.length;
              
            for (q = 0; q < nQueue; q++) {
                queueItem = this.eventQueue[q];
                if (queueItem) {
                    output += queueItem[0] + "=" + queueItem[1] + ", ";
                }
            }
            return output;
        },

        /**
        * Sets all properties to null, unsubscribes all listeners from each 
        * property's change event and all listeners from the configChangedEvent.
        * @method destroy
        */
        destroy: function () {

            var oConfig = this.config,
                sProperty,
                oProperty;


            for (sProperty in oConfig) {
            
                if (Lang.hasOwnProperty(oConfig, sProperty)) {

                    oProperty = oConfig[sProperty];

                    oProperty.event.unsubscribeAll();
                    oProperty.event = null;

                }
            
            }
            
            this.configChangedEvent.unsubscribeAll();
            
            this.configChangedEvent = null;
            this.owner = null;
            this.config = null;
            this.initialConfig = null;
            this.eventQueue = null;
        
        }

    };
    
    
    
    /**
    * Checks to determine if a particular function/Object pair are already 
    * subscribed to the specified CustomEvent
    * @method ISOFT.util.Config.alreadySubscribed
    * @static
    * @param {ISOFT.util.CustomEvent} evt The CustomEvent for which to check 
    * the subscriptions
    * @param {Function} fn The function to look for in the subscribers list
    * @param {Object} obj The execution scope Object for the subscription
    * @return {Boolean} true, if the function/Object pair is already subscribed 
    * to the CustomEvent passed in
    */
    Config.alreadySubscribed = function (evt, fn, obj) {
    
        var nSubscribers = evt.subscribers.length,
            subsc,
            i;

        if (nSubscribers > 0) {
            i = nSubscribers - 1;
            do {
                subsc = evt.subscribers[i];
                if (subsc && subsc.obj == obj && subsc.fn == fn) {
                    return true;
                }
            }
            while (i--);
        }

        return false;

    };

    ISOFT.lang.augmentProto(Config, ISOFT.util.EventProvider);

}());

(function () {

    /**
    * The Container family of components is designed to enable developers to 
    * create different kinds of content-containing modules on the web. Module 
    * and Overlay are the most basic containers, and they can be used directly 
    * or extended to build custom containers. Also part of the Container family 
    * are four UI controls that extend Module and Overlay: Tooltip, Panel, 
    * Dialog, and SimpleDialog.
    * @module container
    * @title Container
    * @requires ISOFT, dom, event 
    * @optional dragdrop, animation, button
    */
    
    /**
    * Module is a JavaScript representation of the Standard Module Format. 
    * Standard Module Format is a simple standard for markup containers where 
    * child nodes representing the header, body, and footer of the content are 
    * denoted using the CSS classes "hd", "bd", and "ft" respectively. 
    * Module is the base class for all other classes in the iba 
    * Container package.
    * @namespace ISOFT.widget
    * @class Module
    * @constructor
    * @param {String} el The element ID representing the Module <em>OR</em>
    * @param {HTMLElement} el The element representing the Module
    * @param {Object} userConfig The configuration Object literal containing 
    * the configuration that should be set for this module. See configuration 
    * documentation for more details.
    */
    ISOFT.widget.Module = function (el, userConfig) {
        if (el) {
            this.init(el, userConfig);
        } else {
        }
    };

    var Dom = ISOFT.util.Dom,
        Config = ISOFT.util.Config,
        Event = ISOFT.util.Event,
        CustomEvent = ISOFT.util.CustomEvent,
        Module = ISOFT.widget.Module,

        m_oModuleTemplate,
        m_oHeaderTemplate,
        m_oBodyTemplate,
        m_oFooterTemplate,

        /**
        * Constant representing the name of the Module's events
        * @property EVENT_TYPES
        * @private
        * @final
        * @type Object
        */
        EVENT_TYPES = {
            "BEFORE_INIT": "beforeInit",
            "INIT": "init",
            "APPEND": "append",
            "BEFORE_RENDER": "beforeRender",
            "RENDER": "render",
            "CHANGE_HEADER": "changeHeader",
            "CHANGE_BODY": "changeBody",
            "CHANGE_FOOTER": "changeFooter",
            "CHANGE_CONTENT": "changeContent",
            "DESTORY": "destroy",
            "BEFORE_SHOW": "beforeShow",
            "SHOW": "show",
            "BEFORE_HIDE": "beforeHide",
            "HIDE": "hide"
        },
            
        /**
        * Constant representing the Module's configuration properties
        * @property DEFAULT_CONFIG
        * @private
        * @final
        * @type Object
        */
        DEFAULT_CONFIG = {
        
            "VISIBLE": { 
                key: "visible", 
                value: true, 
                validator: ISOFT.lang.isBoolean 
            },
        
            "EFFECT": { 
                key: "effect", 
                suppressEvent: true, 
                supercedes: ["visible"] 
            },

            "MONITOR_RESIZE": { 
                key: "monitorresize", 
                value: true  
            },

            "APPEND_TO_DOCUMENT_BODY": { 
                key: "appendtodocumentbody", 
                value: false
            }
        };
    
    /**
    * Constant representing the prefix path to use for non-secure images
    * @property ISOFT.widget.Module.IMG_ROOT
    * @static
    * @final
    * @type String
    */
    Module.IMG_ROOT = null;
    
    /**
    * Constant representing the prefix path to use for securely served images
    * @property ISOFT.widget.Module.IMG_ROOT_SSL
    * @static
    * @final
    * @type String
    */
    Module.IMG_ROOT_SSL = null;
    
    /**
    * Constant for the default CSS class name that represents a Module
    * @property ISOFT.widget.Module.CSS_MODULE
    * @static
    * @final
    * @type String
    */
    Module.CSS_MODULE = "iba-module";
    
    /**
    * Constant representing the module header
    * @property ISOFT.widget.Module.CSS_HEADER
    * @static
    * @final
    * @type String
    */
    Module.CSS_HEADER = "hd";

    /**
    * Constant representing the module body
    * @property ISOFT.widget.Module.CSS_BODY
    * @static
    * @final
    * @type String
    */
    Module.CSS_BODY = "bd";
    
    /**
    * Constant representing the module footer
    * @property ISOFT.widget.Module.CSS_FOOTER
    * @static
    * @final
    * @type String
    */
    Module.CSS_FOOTER = "ft";
    
    /**
    * Constant representing the url for the "src" attribute of the iframe 
    * used to monitor changes to the browser's base font size
    * @property ISOFT.widget.Module.RESIZE_MONITOR_SECURE_URL
    * @static
    * @final
    * @type String
    */
    Module.RESIZE_MONITOR_SECURE_URL = "javascript:false;";
    
    /**
    * Singleton CustomEvent fired when the font size is changed in the browser.
    * Opera's "zoom" functionality currently does not support text 
    * size detection.
    * @event ISOFT.widget.Module.textResizeEvent
    */
    Module.textResizeEvent = new CustomEvent("textResize");

    function createModuleTemplate() {

        if (!m_oModuleTemplate) {
            m_oModuleTemplate = document.createElement("div");
            
            m_oModuleTemplate.innerHTML = ("<div class=\"" + 
                Module.CSS_HEADER + "\"></div>" + "<div class=\"" + 
                Module.CSS_BODY + "\"></div><div class=\"" + 
                Module.CSS_FOOTER + "\"></div>");

            m_oHeaderTemplate = m_oModuleTemplate.firstElementChild;
            m_oBodyTemplate = m_oHeaderTemplate.nextSibling;
            m_oFooterTemplate = m_oBodyTemplate.nextSibling;
        }

        return m_oModuleTemplate;
    }

    function createHeader() {
        if (!m_oHeaderTemplate) {
            createModuleTemplate();
        }
        return (m_oHeaderTemplate.cloneNode(false));
    }

    function createBody() {
        if (!m_oBodyTemplate) {
            createModuleTemplate();
        }
        return (m_oBodyTemplate.cloneNode(false));
    }

    function createFooter() {
        if (!m_oFooterTemplate) {
            createModuleTemplate();
        }
        return (m_oFooterTemplate.cloneNode(false));
    }

    Module.prototype = {

        /**
        * The class's constructor function
        * @property contructor
        * @type Function
        */
        constructor: Module,
        
        /**
        * The main module element that contains the header, body, and footer
        * @property element
        * @type HTMLElement
        */
        element: null,

        /**
        * The header element, denoted with CSS class "hd"
        * @property header
        * @type HTMLElement
        */
        header: null,

        /**
        * The body element, denoted with CSS class "bd"
        * @property body
        * @type HTMLElement
        */
        body: null,

        /**
        * The footer element, denoted with CSS class "ft"
        * @property footer
        * @type HTMLElement
        */
        footer: null,

        /**
        * The id of the element
        * @property id
        * @type String
        */
        id: null,

        /**
        * A string representing the root path for all images created by
        * a Module instance.
        * @deprecated It is recommend that any images for a Module be applied
        * via CSS using the "background-image" property.
        * @property imageRoot
        * @type String
        */
        imageRoot: Module.IMG_ROOT,

        /**
        * Initializes the custom events for Module which are fired 
        * automatically at appropriate times by the Module class.
        * @method initEvents
        */
        initEvents: function () {

            var SIGNATURE = CustomEvent.LIST;

            /**
            * CustomEvent fired prior to class initalization.
            * @event beforeInitEvent
            * @param {class} classRef class reference of the initializing 
            * class, such as this.beforeInitEvent.fire(Module)
            */
            this.beforeInitEvent = this.createEvent(EVENT_TYPES.BEFORE_INIT);
            this.beforeInitEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired after class initalization.
            * @event initEvent
            * @param {class} classRef class reference of the initializing 
            * class, such as this.beforeInitEvent.fire(Module)
            */  
            this.initEvent = this.createEvent(EVENT_TYPES.INIT);
            this.initEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired when the Module is appended to the DOM
            * @event appendEvent
            */
            this.appendEvent = this.createEvent(EVENT_TYPES.APPEND);
            this.appendEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired before the Module is rendered
            * @event beforeRenderEvent
            */
            this.beforeRenderEvent = this.createEvent(EVENT_TYPES.BEFORE_RENDER);
            this.beforeRenderEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired after the Module is rendered
            * @event renderEvent
            */
            this.renderEvent = this.createEvent(EVENT_TYPES.RENDER);
            this.renderEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired when the header content of the Module 
            * is modified
            * @event changeHeaderEvent
            * @param {String/HTMLElement} content String/element representing 
            * the new header content
            */
            this.changeHeaderEvent = this.createEvent(EVENT_TYPES.CHANGE_HEADER);
            this.changeHeaderEvent.signature = SIGNATURE;
            
            /**
            * CustomEvent fired when the body content of the Module is modified
            * @event changeBodyEvent
            * @param {String/HTMLElement} content String/element representing 
            * the new body content
            */  
            this.changeBodyEvent = this.createEvent(EVENT_TYPES.CHANGE_BODY);
            this.changeBodyEvent.signature = SIGNATURE;
            
            /**
            * CustomEvent fired when the footer content of the Module 
            * is modified
            * @event changeFooterEvent
            * @param {String/HTMLElement} content String/element representing 
            * the new footer content
            */
            this.changeFooterEvent = this.createEvent(EVENT_TYPES.CHANGE_FOOTER);
            this.changeFooterEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired when the content of the Module is modified
            * @event changeContentEvent
            */
            this.changeContentEvent = this.createEvent(EVENT_TYPES.CHANGE_CONTENT);
            this.changeContentEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired when the Module is destroyed
            * @event destroyEvent
            */
            this.destroyEvent = this.createEvent(EVENT_TYPES.DESTORY);
            this.destroyEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired before the Module is shown
            * @event beforeShowEvent
            */
            this.beforeShowEvent = this.createEvent(EVENT_TYPES.BEFORE_SHOW);
            this.beforeShowEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired after the Module is shown
            * @event showEvent
            */
            this.showEvent = this.createEvent(EVENT_TYPES.SHOW);
            this.showEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired before the Module is hidden
            * @event beforeHideEvent
            */
            this.beforeHideEvent = this.createEvent(EVENT_TYPES.BEFORE_HIDE);
            this.beforeHideEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired after the Module is hidden
            * @event hideEvent
            */
            this.hideEvent = this.createEvent(EVENT_TYPES.HIDE);
            this.hideEvent.signature = SIGNATURE;
        }, 

        /**
        * String representing the current user-agent platform
        * @property platform
        * @type String
        */
        platform: function () {
            var ua = navigator.userAgent.toLowerCase();

            if (ua.indexOf("windows") != -1 || ua.indexOf("win32") != -1) {
                return "windows";
            } else if (ua.indexOf("macintosh") != -1) {
                return "mac";
            } else {
                return false;
            }
        }(),
        
        /**
        * String representing the user-agent of the browser
        * @deprecated Use ISOFT.env.ua
        * @property browser
        * @type String
        */
        browser: function () {
            var ua = navigator.userAgent.toLowerCase();
            /*
                 Check Opera first in case of spoof and check Safari before
                 Gecko since Safari's user agent string includes "like Gecko"
            */
            if (ua.indexOf('opera') != -1) { 
                return 'opera';
            } else if (ua.indexOf('msie 7') != -1) {
                return 'ie7';
            } else if (ua.indexOf('msie') != -1) {
                return 'ie';
            } else if (ua.indexOf('safari') != -1) { 
                return 'safari';
            } else if (ua.indexOf('gecko') != -1) {
                return 'gecko';
            } else {
                return false;
            }
        }(),
        
        /**
        * Boolean representing whether or not the current browsing context is 
        * secure (https)
        * @property isSecure
        * @type Boolean
        */
        isSecure: function () {
            if (window.location.href.toLowerCase().indexOf("https") === 0) {
                return true;
            } else {
                return false;
            }
        }(),
        
        /**
        * Initializes the custom events for Module which are fired 
        * automatically at appropriate times by the Module class.
        */
        initDefaultConfig: function () {
            // Add properties //
            /**
            * Specifies whether the Module is visible on the page.
            * @config visible
            * @type Boolean
            * @default true
            */
            this.cfg.addProperty(DEFAULT_CONFIG.VISIBLE.key, {
                handler: this.configVisible, 
                value: DEFAULT_CONFIG.VISIBLE.value, 
                validator: DEFAULT_CONFIG.VISIBLE.validator
            });

            /**
            * Object or array of objects representing the ContainerEffect 
            * classes that are active for animating the container.
            * @config effect
            * @type Object
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.EFFECT.key, {
                suppressEvent: DEFAULT_CONFIG.EFFECT.suppressEvent, 
                supercedes: DEFAULT_CONFIG.EFFECT.supercedes
            });

            /**
            * Specifies whether to create a special proxy iframe to monitor 
            * for user font resizing in the document
            * @config monitorresize
            * @type Boolean
            * @default true
            */
            this.cfg.addProperty(DEFAULT_CONFIG.MONITOR_RESIZE.key, {
                handler: this.configMonitorResize,
                value: DEFAULT_CONFIG.MONITOR_RESIZE.value
            });

            /**
            * Specifies if the module should be rendered as the first child 
            * of document.body or appended as the last child when render is called
            * with document.body as the "appendToNode".
            * <p>
            * Appending to the body while the DOM is still being constructed can 
            * lead to Operation Aborted errors in IE hence this flag is set to 
            * false by default.
            * </p>
            * 
            * @config appendtodocumentbody
            * @type Boolean
            * @default false
            */
            this.cfg.addProperty(DEFAULT_CONFIG.APPEND_TO_DOCUMENT_BODY.key, {
                value: DEFAULT_CONFIG.APPEND_TO_DOCUMENT_BODY.value
            });
        },

        /**
        * The Module class's initialization method, which is executed for
        * Module and all of its subclasses. This method is automatically 
        * called by the constructor, and  sets up all DOM references for 
        * pre-existing markup, and creates required markup if it is not 
        * already present.
        * @method init
        * @param {String} el The element ID representing the Module <em>OR</em>
        * @param {HTMLElement} el The element representing the Module
        * @param {Object} userConfig The configuration Object literal 
        * containing the configuration that should be set for this module. 
        * See configuration documentation for more details.
        */
        init: function (el, userConfig) {

            var elId, child;

            this.initEvents();
            this.beforeInitEvent.fire(Module);

            /**
            * The Module's Config object used for monitoring 
            * configuration properties.
            * @property cfg
            * @type ISOFT.util.Config
            */
            this.cfg = new Config(this);

            if (this.isSecure) {
                this.imageRoot = Module.IMG_ROOT_SSL;
            }

            if (typeof el == "string") {
                elId = el;
                el = document.getElementById(el);
                if (! el) {
                    el = (createModuleTemplate()).cloneNode(false);
                    el.id = elId;
                }
            }

            this.element = el;

            if (el.id) {
                this.id = el.id;
            }

            child = this.element.firstElementChild;

            if (child) {
                var fndHd = false, fndBd = false, fndFt = false;
                do {
                    // We're looking for elements
                    if (1 == child.nodeType) {
                        if (!fndHd && Dom.hasClass(child, Module.CSS_HEADER)) {
                            this.header = child;
                            fndHd = true;
                        } else if (!fndBd && Dom.hasClass(child, Module.CSS_BODY)) {
                            this.body = child;
                            fndBd = true;
                        } else if (!fndFt && Dom.hasClass(child, Module.CSS_FOOTER)){
                            this.footer = child;
                            fndFt = true;
                        }
                    }
                } while ((child = child.nextSibling));
            }

            this.initDefaultConfig();

            Dom.addClass(this.element, Module.CSS_MODULE);

            if (userConfig) {
                this.cfg.applyConfig(userConfig, true);
            }

            /*
                Subscribe to the fireQueue() method of Config so that any 
                queued configuration changes are excecuted upon render of 
                the Module
            */ 

            if (!Config.alreadySubscribed(this.renderEvent, this.cfg.fireQueue, this.cfg)) {
                this.renderEvent.subscribe(this.cfg.fireQueue, this.cfg, true);
            }

            this.initEvent.fire(Module);
        },

        /**
        * Initialize an empty IFRAME that is placed out of the visible area 
        * that can be used to detect text resize.
        * @method initResizeMonitor
        */
        initResizeMonitor: function () {

            var isGeckoWin = (ISOFT.env.ua.gecko && this.platform == "windows");
            if (isGeckoWin) {
                // Help prevent spinning loading icon which 
                // started with FireFox 2.0.0.8/Win
                var self = this;
                setTimeout(function(){self._initResizeMonitor();}, 0);
            } else {
                this._initResizeMonitor();
            }
        },

        /**
         * Create and initialize the text resize monitoring iframe.
         * 
         * @protected
         * @method _initResizeMonitor
         */
        _initResizeMonitor : function() {

            var oDoc, 
                oIFrame, 
                sHTML;

            function fireTextResize() {
                Module.textResizeEvent.fire();
            }

            if (!ISOFT.env.ua.opera) {
                oIFrame = Dom.get("_ibaResizeMonitor");

                var supportsCWResize = this._supportsCWResize();

                if (!oIFrame) {
                    oIFrame = document.createElement("iframe");

                    if (this.isSecure && Module.RESIZE_MONITOR_SECURE_URL && ISOFT.env.ua.ie) {
                        oIFrame.src = Module.RESIZE_MONITOR_SECURE_URL;
                    }

                    if (!supportsCWResize) {
                        // Can't monitor on contentWindow, so fire from inside iframe
                        sHTML = [""].join('');

                        oIFrame.src = "data:text/html;charset=utf-8," + encodeURIComponent(sHTML);
                    }

                    oIFrame.id = "_ibaResizeMonitor";
                    /*
                        Need to set "position" property before inserting the 
                        iframe into the document or Safari's status bar will 
                        forever indicate the iframe is loading 
                        (See SourceForge bug #1723064)
                    */
                    oIFrame.style.position = "absolute";
                    oIFrame.style.visibility = "hidden";

                    var db = document.body,
                        fc = db.firstElementChild;
                    if (fc) {
                        db.insertBefore(oIFrame, fc);
                    } else {
                        db.appendChild(oIFrame);
                    }

                    oIFrame.style.width = "10em";
                    oIFrame.style.height = "10em";
                    oIFrame.style.top = (-1 * oIFrame.offsetHeight) + "px";
                    oIFrame.style.left = (-1 * oIFrame.offsetWidth) + "px";
                    oIFrame.style.borderWidth = "0";
                    oIFrame.style.visibility = "visible";

                    /*
                       Don't open/close the document for Gecko like we used to, since it
                       leads to duplicate cookies. (See SourceForge bug #1721755)
                    */
                    if (ISOFT.env.ua.webkit) {
                        oDoc = oIFrame.contentWindow.document;
                        oDoc.open();
                        oDoc.close();
                    }
                }

                if (oIFrame && oIFrame.contentWindow) {
                    Module.textResizeEvent.subscribe(this.onDomResize, this, true);

                    if (!Module.textResizeInitialized) {
                        if (supportsCWResize) {
                            if (!Event.on(oIFrame.contentWindow, "resize", fireTextResize)) {
                                /*
                                     This will fail in IE if document.domain has 
                                     changed, so we must change the listener to 
                                     use the oIFrame element instead
                                */
                                Event.on(oIFrame, "resize", fireTextResize);
                            }
                        }
                        Module.textResizeInitialized = true;
                    }
                    this.resizeMonitor = oIFrame;
                }
            }
        },

        /**
         * Text resize monitor helper method.
         * Determines if the browser supports resize events on iframe content windows.
         * 
         * @private
         * @method _supportsCWResize
         */
        _supportsCWResize : function() {
            /*
                Gecko 1.8.0 (FF1.5), 1.8.1.0-5 (FF2) won't fire resize on contentWindow.
                Gecko 1.8.1.6+ (FF2.0.0.6+) and all other browsers will fire resize on contentWindow.

                We don't want to start sniffing for patch versions, so fire textResize the same
                way on all FF, until 1.9 (3.x) is out
             */
            var bSupported = true;
            if (ISOFT.env.ua.gecko && ISOFT.env.ua.gecko <= 1.8) {
                bSupported = false;
                /*
                var v = navigator.userAgent.match(/rv:([^\s\)]*)/); // From ISOFT.env.ua
                if (v && v[0]) {
                    var sv = v[0].match(/\d\.\d\.(\d)/);
                    if (sv && sv[1]) {
                        if (parseInt(sv[1], 10) > 0) {
                            bSupported = true;
                        }
                    }
                }
                */
            }
            return bSupported;
        },

        /**
        * Event handler fired when the resize monitor element is resized.
        * @method onDomResize
        * @param {DOMEvent} e The DOM resize event
        * @param {Object} obj The scope object passed to the handler
        */
        onDomResize: function (e, obj) {

            var nLeft = -1 * this.resizeMonitor.offsetWidth,
                nTop = -1 * this.resizeMonitor.offsetHeight;
        
            this.resizeMonitor.style.top = nTop + "px";
            this.resizeMonitor.style.left =  nLeft + "px";

        },

        /**
        * Sets the Module's header content to the string specified, or appends 
        * the passed element to the header. If no header is present, one will 
        * be automatically created. An empty string can be passed to the method
        * to clear the contents of the header.
        * 
        * @method setHeader
        * @param {String} headerContent The string used to set the header.
        * As a convenience, non HTMLElement objects can also be passed into 
        * the method, and will be treated as strings, with the header innerHTML
        * set to their default toString implementations.
        * <em>OR</em>
        * @param {HTMLElement} headerContent The HTMLElement to append to 
        * <em>OR</em>
        * @param {DocumentFragment} headerContent The document fragment 
        * containing elements which are to be added to the header
        */
        setHeader: function (headerContent) {
            var oHeader = this.header || (this.header = createHeader());

            if (headerContent.nodeName) {
                oHeader.innerHTML = "";
                oHeader.appendChild(headerContent);
            } else {
                oHeader.innerHTML = headerContent;
            }

            this.changeHeaderEvent.fire(headerContent);
            this.changeContentEvent.fire();

        },

        /**
        * Appends the passed element to the header. If no header is present, 
        * one will be automatically created.
        * @method appendToHeader
        * @param {HTMLElement | DocumentFragment} element The element to 
        * append to the header. In the case of a document fragment, the
        * children of the fragment will be appended to the header.
        */
        appendToHeader: function (element) {
            var oHeader = this.header || (this.header = createHeader());

            oHeader.appendChild(element);

            this.changeHeaderEvent.fire(element);
            this.changeContentEvent.fire();

        },

        /**
        * Sets the Module's body content to the HTML specified, or appends the
        * passed element to the body. If no body is present, one will be 
        * automatically created. An empty string can be passed to the method
        * to clear the contents of the body.
        * @method setBody
        * @param {String} bodyContent The HTML used to set the body. 
        * As a convenience, non HTMLElement objects can also be passed into 
        * the method, and will be treated as strings, with the body innerHTML
        * set to their default toString implementations.
        * <em>OR</em>
        * @param {HTMLElement} bodyContent The HTMLElement to append to the body
        * <em>OR</em>
        * @param {DocumentFragment} bodyContent The document fragment 
        * containing elements which are to be added to the body
        */
        setBody: function (bodyContent) {
            var oBody = this.body || (this.body = createBody());

            if (bodyContent.nodeName) {
                oBody.innerHTML = "";
                oBody.appendChild(bodyContent);
            } else {
                oBody.innerHTML = bodyContent;
            }

            this.changeBodyEvent.fire(bodyContent);
            this.changeContentEvent.fire();
        },

        /**
        * Appends the passed element to the body. If no body is present, one 
        * will be automatically created.
        * @method appendToBody
        * @param {HTMLElement | DocumentFragment} element The element to 
        * append to the body. In the case of a document fragment, the
        * children of the fragment will be appended to the body.
        * 
        */
        appendToBody: function (element) {
            var oBody = this.body || (this.body = createBody());
        
            oBody.appendChild(element);

            this.changeBodyEvent.fire(element);
            this.changeContentEvent.fire();

        },
        
        /**
        * Sets the Module's footer content to the HTML specified, or appends 
        * the passed element to the footer. If no footer is present, one will 
        * be automatically created. An empty string can be passed to the method
        * to clear the contents of the footer.
        * @method setFooter
        * @param {String} footerContent The HTML used to set the footer 
        * As a convenience, non HTMLElement objects can also be passed into 
        * the method, and will be treated as strings, with the footer innerHTML
        * set to their default toString implementations.
        * <em>OR</em>
        * @param {HTMLElement} footerContent The HTMLElement to append to 
        * the footer
        * <em>OR</em>
        * @param {DocumentFragment} footerContent The document fragment containing 
        * elements which are to be added to the footer
        */
        setFooter: function (footerContent) {

            var oFooter = this.footer || (this.footer = createFooter());

            if (footerContent.nodeName) {
                oFooter.innerHTML = "";
                oFooter.appendChild(footerContent);
            } else {
                oFooter.innerHTML = footerContent;
            }

            this.changeFooterEvent.fire(footerContent);
            this.changeContentEvent.fire();
        },

        /**
        * Appends the passed element to the footer. If no footer is present, 
        * one will be automatically created.
        * @method appendToFooter
        * @param {HTMLElement | DocumentFragment} element The element to 
        * append to the footer. In the case of a document fragment, the
        * children of the fragment will be appended to the footer
        */
        appendToFooter: function (element) {

            var oFooter = this.footer || (this.footer = createFooter());

            oFooter.appendChild(element);

            this.changeFooterEvent.fire(element);
            this.changeContentEvent.fire();

        },

        /**
        * Renders the Module by inserting the elements that are not already 
        * in the main Module into their correct places. Optionally appends 
        * the Module to the specified node prior to the render's execution. 
        * <p>
        * For Modules without existing markup, the appendToNode argument 
        * is REQUIRED. If this argument is ommitted and the current element is 
        * not present in the document, the function will return false, 
        * indicating that the render was a failure.
        * </p>
        * <p>
        * NOTE: As of 2.3.1, if the appendToNode is the document's body element
        * then the module is rendered as the first child of the body element, 
        * and not appended to it, to avoid Operation Aborted errors in IE when 
        * rendering the module before window's load event is fired. You can 
        * use the appendtodocumentbody configuration property to change this 
        * to append to document.body if required.
        * </p>
        * @method render
        * @param {String} appendToNode The element id to which the Module 
        * should be appended to prior to rendering <em>OR</em>
        * @param {HTMLElement} appendToNode The element to which the Module 
        * should be appended to prior to rendering
        * @param {HTMLElement} moduleElement OPTIONAL. The element that 
        * represents the actual Standard Module container.
        * @return {Boolean} Success or failure of the render
        */
        render: function (appendToNode, moduleElement) {

            var me = this,
                firstElementChild;

            function appendTo(parentNode) {
                if (typeof parentNode == "string") {
                    parentNode = document.getElementById(parentNode);
                }

                if (parentNode) {
                    me._addToParent(parentNode, me.element);
                    me.appendEvent.fire();
                }
            }

            this.beforeRenderEvent.fire();

            if (! moduleElement) {
                moduleElement = this.element;
            }

            if (appendToNode) {
                appendTo(appendToNode);
            } else { 
                // No node was passed in. If the element is not already in the Dom, this fails
                if (! Dom.inDocument(this.element)) {
                    return false;
                }
            }

            // Need to get everything into the DOM if it isn't already
            if (this.header && ! Dom.inDocument(this.header)) {
                // There is a header, but it's not in the DOM yet. Need to add it.
                firstElementChild = moduleElement.firstElementChild;
                if (firstElementChild) {
                    moduleElement.insertBefore(this.header, firstElementChild);
                } else {
                    moduleElement.appendChild(this.header);
                }
            }

            if (this.body && ! Dom.inDocument(this.body)) {
                // There is a body, but it's not in the DOM yet. Need to add it.		
                if (this.footer && Dom.isAncestor(this.moduleElement, this.footer)) {
                    moduleElement.insertBefore(this.body, this.footer);
                } else {
                    moduleElement.appendChild(this.body);
                }
            }

            if (this.footer && ! Dom.inDocument(this.footer)) {
                // There is a footer, but it's not in the DOM yet. Need to add it.
                moduleElement.appendChild(this.footer);
            }

            this.renderEvent.fire();
            return true;
        },

        /**
        * Removes the Module element from the DOM and sets all child elements 
        * to null.
        * @method destroy
        */
        destroy: function () {

            var parent,
                e;

            if (this.element) {
                Event.purgeElement(this.element, true);
                parent = this.element.parentNode;
            }

            if (parent) {
                parent.removeChild(this.element);
            }
        
            this.element = null;
            this.header = null;
            this.body = null;
            this.footer = null;

            Module.textResizeEvent.unsubscribe(this.onDomResize, this);

            this.cfg.destroy();
            this.cfg = null;

            this.destroyEvent.fire();
        
            for (e in this) {
                if (e instanceof CustomEvent) {
                    e.unsubscribeAll();
                }
            }

        },

        /**
        * Shows the Module element by setting the visible configuration 
        * property to true. Also fires two events: beforeShowEvent prior to 
        * the visibility change, and showEvent after.
        * @method show
        */
        show: function () {
            this.cfg.setProperty("visible", true);
        },

        /**
        * Hides the Module element by setting the visible configuration 
        * property to false. Also fires two events: beforeHideEvent prior to 
        * the visibility change, and hideEvent after.
        * @method hide
        */
        hide: function () {
            this.cfg.setProperty("visible", false);
        },
        
        // BUILT-IN EVENT HANDLERS FOR MODULE //
        /**
        * Default event handler for changing the visibility property of a 
        * Module. By default, this is achieved by switching the "display" style 
        * between "block" and "none".
        * This method is responsible for firing showEvent and hideEvent.
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        * @method configVisible
        */
        configVisible: function (type, args, obj) {
            var visible = args[0];
            if (visible) {
                this.beforeShowEvent.fire();
                Dom.setStyle(this.element, "display", "block");
                this.showEvent.fire();
            } else {
                this.beforeHideEvent.fire();
                Dom.setStyle(this.element, "display", "none");
                this.hideEvent.fire();
            }
        },
        
        /**
        * Default event handler for the "monitorresize" configuration property
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        * @method configMonitorResize
        */
        configMonitorResize: function (type, args, obj) {
            var monitor = args[0];
            if (monitor) {
                this.initResizeMonitor();
            } else {
                Module.textResizeEvent.unsubscribe(this.onDomResize, this, true);
                this.resizeMonitor = null;
            }
        },

        /**
         * This method is a protected helper, used when constructing the DOM structure for the module 
         * to account for situations which may cause Operation Aborted errors in IE. It should not 
         * be used for general DOM construction.
         * <p>
         * If the parentNode is not document.body, the element is appended as the last element.
         * </p>
         * <p>
         * If the parentNode is document.body the element is added as the first child to help
         * prevent Operation Aborted errors in IE.
         * </p>
         *
         * @param {parentNode} The HTML element to which the element will be added
         * @param {element} The HTML element to be added to parentNode's children
         * @method _addToParent
         * @protected
         */
        _addToParent: function(parentNode, element) {
            if (!this.cfg.getProperty("appendtodocumentbody") && parentNode === document.body && parentNode.firstElementChild) {
                parentNode.insertBefore(element, parentNode.firstElementChild);
            } else {
                parentNode.appendChild(element);
            }
        },

        /**
        * Returns a String representation of the Object.
        * @method toString
        * @return {String} The string representation of the Module
        */
        toString: function () {
            return "Module " + this.id;
        }
    };

    ISOFT.lang.augmentProto(Module, ISOFT.util.EventProvider);

}());

(function () {

    /**
    * Overlay is a Module that is absolutely positioned above the page flow. It 
    * has convenience methods for positioning and sizing, as well as options for 
    * controlling zIndex and constraining the Overlay's position to the current 
    * visible viewport. Overlay also contains a dynamicly generated IFRAME which 
    * is placed beneath it for Internet Explorer 6 and 5.x so that it will be 
    * properly rendered above SELECT elements.
    * @namespace ISOFT.widget
    * @class Overlay
    * @extends ISOFT.widget.Module
    * @param {String} el The element ID representing the Overlay <em>OR</em>
    * @param {HTMLElement} el The element representing the Overlay
    * @param {Object} userConfig The configuration object literal containing 
    * the configuration that should be set for this Overlay. See configuration 
    * documentation for more details.
    * @constructor
    */
    ISOFT.widget.Overlay = function (el, userConfig) {
        ISOFT.widget.Overlay.superclass.constructor.call(this, el, userConfig);
    };

    var Lang = ISOFT.lang,
        CustomEvent = ISOFT.util.CustomEvent,
        Module = ISOFT.widget.Module,
        Event = ISOFT.util.Event,
        Dom = ISOFT.util.Dom,
        Config = ISOFT.util.Config,
        Overlay = ISOFT.widget.Overlay,

        m_oIFrameTemplate,

        /**
        * Constant representing the name of the Overlay's events
        * @property EVENT_TYPES
        * @private
        * @final
        * @type Object
        */
        EVENT_TYPES = {
            "BEFORE_MOVE": "beforeMove",
            "MOVE": "move"
        },

        /**
        * Constant representing the Overlay's configuration properties
        * @property DEFAULT_CONFIG
        * @private
        * @final
        * @type Object
        */
        DEFAULT_CONFIG = {

            "X": { 
                key: "x", 
                validator: Lang.isNumber, 
                suppressEvent: true, 
                supercedes: ["iframe"]
            },

            "Y": { 
                key: "y", 
                validator: Lang.isNumber, 
                suppressEvent: true, 
                supercedes: ["iframe"]
            },

            "XY": { 
                key: "xy", 
                suppressEvent: true, 
                supercedes: ["iframe"] 
            },

            "CONTEXT": { 
                key: "context", 
                suppressEvent: true, 
                supercedes: ["iframe"] 
            },

            "FIXED_CENTER": { 
                key: "fixedcenter", 
                value: false, 
                validator: Lang.isBoolean, 
                supercedes: ["iframe", "visible"] 
            },

            "WIDTH": { 
                key: "width", 
                suppressEvent: true, 
                supercedes: ["context", "fixedcenter", "iframe"] 
            }, 

            "HEIGHT": { 
                key: "height", 
                suppressEvent: true, 
                supercedes: ["context", "fixedcenter", "iframe"] 
            },

            "ZINDEX": { 
                key: "zindex", 
                value: null 
            },

            "CONSTRAIN_TO_VIEWPORT": { 
                key: "constraintoviewport", 
                value: false, 
                validator: Lang.isBoolean, 
                supercedes: ["iframe", "x", "y", "xy"]
            }, 

            "IFRAME": { 
                key: "iframe", 
                value: (ISOFT.env.ua.ie == 6 ? true : false), 
                validator: Lang.isBoolean, 
                supercedes: ["zindex"] 
            }
        };

    /**
    * The URL that will be placed in the iframe
    * @property ISOFT.widget.Overlay.IFRAME_SRC
    * @static
    * @final
    * @type String
    */
    Overlay.IFRAME_SRC = "javascript:false;";

    /**
    * Number representing how much the iframe shim should be offset from each 
    * side of an Overlay instance, in pixels.
    * @property ISOFT.widget.Overlay.IFRAME_SRC
    * @default 3
    * @static
    * @final
    * @type Number
    */
    Overlay.IFRAME_OFFSET = 3;

    /**
    * Number representing the minimum distance an Overlay instance should be 
    * positioned relative to the boundaries of the browser's viewport, in pixels.
    * @property ISOFT.widget.Overlay.VIEWPORT_OFFSET
    * @default 10
    * @static
    * @final
    * @type Number
    */
    Overlay.VIEWPORT_OFFSET = 10;

    /**
    * Constant representing the top left corner of an element, used for 
    * configuring the context element alignment
    * @property ISOFT.widget.Overlay.TOP_LEFT
    * @static
    * @final
    * @type String
    */
    Overlay.TOP_LEFT = "tl";

    /**
    * Constant representing the top right corner of an element, used for 
    * configuring the context element alignment
    * @property ISOFT.widget.Overlay.TOP_RIGHT
    * @static
    * @final
    * @type String
    */
    Overlay.TOP_RIGHT = "tr";

    /**
    * Constant representing the top bottom left corner of an element, used for 
    * configuring the context element alignment
    * @property ISOFT.widget.Overlay.BOTTOM_LEFT
    * @static
    * @final
    * @type String
    */
    Overlay.BOTTOM_LEFT = "bl";

    /**
    * Constant representing the bottom right corner of an element, used for 
    * configuring the context element alignment
    * @property ISOFT.widget.Overlay.BOTTOM_RIGHT
    * @static
    * @final
    * @type String
    */
    Overlay.BOTTOM_RIGHT = "br";

    /**
    * Constant representing the default CSS class used for an Overlay
    * @property ISOFT.widget.Overlay.CSS_OVERLAY
    * @static
    * @final
    * @type String
    */
    Overlay.CSS_OVERLAY = "iba-overlay";

    /**
    * A singleton CustomEvent used for reacting to the DOM event for 
    * window scroll
    * @event ISOFT.widget.Overlay.windowScrollEvent
    */
    Overlay.windowScrollEvent = new CustomEvent("windowScroll");

    /**
    * A singleton CustomEvent used for reacting to the DOM event for
    * window resize
    * @event ISOFT.widget.Overlay.windowResizeEvent
    */
    Overlay.windowResizeEvent = new CustomEvent("windowResize");

    /**
    * The DOM event handler used to fire the CustomEvent for window scroll
    * @method ISOFT.widget.Overlay.windowScrollHandler
    * @static
    * @param {DOMEvent} e The DOM scroll event
    */
    Overlay.windowScrollHandler = function (e) {

        if (ISOFT.env.ua.ie) {

            if (! window.scrollEnd) {
                window.scrollEnd = -1;
            }

            clearTimeout(window.scrollEnd);
    
            window.scrollEnd = setTimeout(function () { 
                Overlay.windowScrollEvent.fire(); 
            }, 1);
    
        } else {
            Overlay.windowScrollEvent.fire();
        }
    };

    /**
    * The DOM event handler used to fire the CustomEvent for window resize
    * @method ISOFT.widget.Overlay.windowResizeHandler
    * @static
    * @param {DOMEvent} e The DOM resize event
    */
    Overlay.windowResizeHandler = function (e) {

        if (ISOFT.env.ua.ie) {
            if (! window.resizeEnd) {
                window.resizeEnd = -1;
            }

            clearTimeout(window.resizeEnd);

            window.resizeEnd = setTimeout(function () {
                Overlay.windowResizeEvent.fire(); 
            }, 100);
        } else {
            Overlay.windowResizeEvent.fire();
        }
    };

    /**
    * A boolean that indicated whether the window resize and scroll events have 
    * already been subscribed to.
    * @property ISOFT.widget.Overlay._initialized
    * @private
    * @type Boolean
    */
    Overlay._initialized = null;

    if (Overlay._initialized === null) {
        Event.on(window, "scroll", Overlay.windowScrollHandler);
        Event.on(window, "resize", Overlay.windowResizeHandler);
    
        Overlay._initialized = true;
    }

    ISOFT.extend(Overlay, Module, {

        /**
        * The Overlay initialization method, which is executed for Overlay and  
        * all of its subclasses. This method is automatically called by the 
        * constructor, and  sets up all DOM references for pre-existing markup, 
        * and creates required markup if it is not already present.
        * @method init
        * @param {String} el The element ID representing the Overlay <em>OR</em>
        * @param {HTMLElement} el The element representing the Overlay
        * @param {Object} userConfig The configuration object literal 
        * containing the configuration that should be set for this Overlay. 
        * See configuration documentation for more details.
        */
        init: function (el, userConfig) {
    
            /*
                 Note that we don't pass the user config in here yet because we
                 only want it executed once, at the lowest subclass level
            */
    
            Overlay.superclass.init.call(this, el/*, userConfig*/);  

            this.beforeInitEvent.fire(Overlay);
            
            Dom.addClass(this.element, Overlay.CSS_OVERLAY);
            
            if (userConfig) {
                this.cfg.applyConfig(userConfig, true);
            }

            if (this.platform == "mac" && ISOFT.env.ua.gecko) {

                if (! Config.alreadySubscribed(this.showEvent,
                    this.showMacGeckoScrollbars, this)) {

                    this.showEvent.subscribe(this.showMacGeckoScrollbars, 
                        this, true);

                }

                if (! Config.alreadySubscribed(this.hideEvent, 
                    this.hideMacGeckoScrollbars, this)) {

                    this.hideEvent.subscribe(this.hideMacGeckoScrollbars, 
                        this, true);

                }
            }

            this.initEvent.fire(Overlay);
        },
        
        /**
        * Initializes the custom events for Overlay which are fired  
        * automatically at appropriate times by the Overlay class.
        * @method initEvents
        */
        initEvents: function () {
    
            Overlay.superclass.initEvents.call(this);
            
            var SIGNATURE = CustomEvent.LIST;
            
            /**
            * CustomEvent fired before the Overlay is moved.
            * @event beforeMoveEvent
            * @param {Number} x x coordinate
            * @param {Number} y y coordinate
            */
            this.beforeMoveEvent = this.createEvent(EVENT_TYPES.BEFORE_MOVE);
            this.beforeMoveEvent.signature = SIGNATURE;
            
            /**
            * CustomEvent fired after the Overlay is moved.
            * @event moveEvent
            * @param {Number} x x coordinate
            * @param {Number} y y coordinate
            */
            this.moveEvent = this.createEvent(EVENT_TYPES.MOVE);
            this.moveEvent.signature = SIGNATURE;
        
        },
        
        /**
        * Initializes the class's configurable properties which can be changed 
        * using the Overlay's Config object (cfg).
        * @method initDefaultConfig
        */
        initDefaultConfig: function () {
    
            Overlay.superclass.initDefaultConfig.call(this);
            
            
            // Add overlay config properties //
            
            /**
            * The absolute x-coordinate position of the Overlay
            * @config x
            * @type Number
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.X.key, { 
    
                handler: this.configX, 
                validator: DEFAULT_CONFIG.X.validator, 
                suppressEvent: DEFAULT_CONFIG.X.suppressEvent, 
                supercedes: DEFAULT_CONFIG.X.supercedes
    
            });

            /**
            * The absolute y-coordinate position of the Overlay
            * @config y
            * @type Number
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.Y.key, {

                handler: this.configY, 
                validator: DEFAULT_CONFIG.Y.validator, 
                suppressEvent: DEFAULT_CONFIG.Y.suppressEvent, 
                supercedes: DEFAULT_CONFIG.Y.supercedes

            });
    
            /**
            * An array with the absolute x and y positions of the Overlay
            * @config xy
            * @type Number[]
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.XY.key, {
            
                handler: this.configXY, 
                suppressEvent: DEFAULT_CONFIG.XY.suppressEvent, 
                supercedes: DEFAULT_CONFIG.XY.supercedes
            
            });
    
            /**
            * The array of context arguments for context-sensitive positioning.  
            * The format is: [id or element, element corner, context corner]. 
            * For example, setting this property to ["img1", "tl", "bl"] would 
            * align the Overlay's top left corner to the context element's 
            * bottom left corner.
            * @config context
            * @type Array
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.CONTEXT.key, {
            
                handler: this.configContext, 
                suppressEvent: DEFAULT_CONFIG.CONTEXT.suppressEvent, 
                supercedes: DEFAULT_CONFIG.CONTEXT.supercedes
            
            });

            /**
            * True if the Overlay should be anchored to the center of 
            * the viewport.
            * @config fixedcenter
            * @type Boolean
            * @default false
            */
            this.cfg.addProperty(DEFAULT_CONFIG.FIXED_CENTER.key, {
            
                handler: this.configFixedCenter,
                value: DEFAULT_CONFIG.FIXED_CENTER.value, 
                validator: DEFAULT_CONFIG.FIXED_CENTER.validator, 
                supercedes: DEFAULT_CONFIG.FIXED_CENTER.supercedes
            
            });
    
            /**
            * CSS width of the Overlay.
            * @config width
            * @type String
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.WIDTH.key, {

                handler: this.configWidth, 
                suppressEvent: DEFAULT_CONFIG.WIDTH.suppressEvent, 
                supercedes: DEFAULT_CONFIG.WIDTH.supercedes

            });

            /**
            * CSS height of the Overlay.
            * @config height
            * @type String
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.HEIGHT.key, {

                handler: this.configHeight, 
                suppressEvent: DEFAULT_CONFIG.HEIGHT.suppressEvent, 
                supercedes: DEFAULT_CONFIG.HEIGHT.supercedes
            
            });
            
            /**
            * CSS z-index of the Overlay.
            * @config zIndex
            * @type Number
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.ZINDEX.key, {

                handler: this.configzIndex,
                value: DEFAULT_CONFIG.ZINDEX.value

            });

            /**
            * True if the Overlay should be prevented from being positioned 
            * out of the viewport.
            * @config constraintoviewport
            * @type Boolean
            * @default false
            */
            this.cfg.addProperty(DEFAULT_CONFIG.CONSTRAIN_TO_VIEWPORT.key, {

                handler: this.configConstrainToViewport, 
                value: DEFAULT_CONFIG.CONSTRAIN_TO_VIEWPORT.value, 
                validator: DEFAULT_CONFIG.CONSTRAIN_TO_VIEWPORT.validator, 
                supercedes: DEFAULT_CONFIG.CONSTRAIN_TO_VIEWPORT.supercedes

            });

            /**
            * @config iframe
            * @description Boolean indicating whether or not the Overlay should 
            * have an IFRAME shim; used to prevent SELECT elements from 
            * poking through an Overlay instance in IE6.  When set to "true", 
            * the iframe shim is created when the Overlay instance is intially
            * made visible.
            * @type Boolean
            * @default true for IE6 and below, false for all other browsers.
            */
            this.cfg.addProperty(DEFAULT_CONFIG.IFRAME.key, {

                handler: this.configIframe, 
                value: DEFAULT_CONFIG.IFRAME.value, 
                validator: DEFAULT_CONFIG.IFRAME.validator, 
                supercedes: DEFAULT_CONFIG.IFRAME.supercedes

            });
        },

        /**
        * Moves the Overlay to the specified position. This function is  
        * identical to calling this.cfg.setProperty("xy", [x,y]);
        * @method moveTo
        * @param {Number} x The Overlay's new x position
        * @param {Number} y The Overlay's new y position
        */
        moveTo: function (x, y) {
            this.cfg.setProperty("xy", [x, y]);
        },

        /**
        * Adds a CSS class ("hide-scrollbars") and removes a CSS class 
        * ("show-scrollbars") to the Overlay to fix a bug in Gecko on Mac OS X 
        * (https://bugzilla.mozilla.org/show_bug.cgi?id=187435)
        * @method hideMacGeckoScrollbars
        */
        hideMacGeckoScrollbars: function () {
    
            Dom.removeClass(this.element, "show-scrollbars");
            Dom.addClass(this.element, "hide-scrollbars");
    
        },

        /**
        * Adds a CSS class ("show-scrollbars") and removes a CSS class 
        * ("hide-scrollbars") to the Overlay to fix a bug in Gecko on Mac OS X 
        * (https://bugzilla.mozilla.org/show_bug.cgi?id=187435)
        * @method showMacGeckoScrollbars
        */
        showMacGeckoScrollbars: function () {
    
            Dom.removeClass(this.element, "hide-scrollbars");
            Dom.addClass(this.element, "show-scrollbars");
    
        },

        // BEGIN BUILT-IN PROPERTY EVENT HANDLERS //
        /**
        * The default event handler fired when the "visible" property is 
        * changed.  This method is responsible for firing showEvent
        * and hideEvent.
        * @method configVisible
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configVisible: function (type, args, obj) {

            var visible = args[0],
                currentVis = Dom.getStyle(this.element, "visibility"),
                effect = this.cfg.getProperty("effect"),
                effectInstances = [],
                isMacGecko = (this.platform == "mac" && ISOFT.env.ua.gecko),
                alreadySubscribed = Config.alreadySubscribed,
                eff, ei, e, i, j, k, h,
                nEffects,
                nEffectInstances;

            if (currentVis == "inherit") {
                e = this.element.parentNode;

                while (e.nodeType != 9 && e.nodeType != 11) {
                    currentVis = Dom.getStyle(e, "visibility");

                    if (currentVis != "inherit") { 
                        break; 
                    }

                    e = e.parentNode;
                }

                if (currentVis == "inherit") {
                    currentVis = "visible";
                }
            }

            if (effect) {
                if (effect instanceof Array) {
                    nEffects = effect.length;

                    for (i = 0; i < nEffects; i++) {
                        eff = effect[i];
                        effectInstances[effectInstances.length] = 
                            eff.effect(this, eff.duration);

                    }
                } else {
                    effectInstances[effectInstances.length] = 
                        effect.effect(this, effect.duration);
                }
            }


            if (visible) { // Show
                if (isMacGecko) {
                    this.showMacGeckoScrollbars();
                }

                if (effect) { // Animate in
                    if (visible) { // Animate in if not showing
                        if (currentVis != "visible" || currentVis === "") {
                            this.beforeShowEvent.fire();
                            nEffectInstances = effectInstances.length;

                            for (j = 0; j < nEffectInstances; j++) {
                                ei = effectInstances[j];
                                if (j === 0 && !alreadySubscribed(
                                        ei.animateInCompleteEvent, 
                                        this.showEvent.fire, this.showEvent)) {

                                    /*
                                         Delegate showEvent until end 
                                         of animateInComplete
                                    */

                                    ei.animateInCompleteEvent.subscribe(
                                     this.showEvent.fire, this.showEvent, true);
                                }
                                ei.animateIn();
                            }
                        }
                    }
                } else { // Show
                    if (currentVis != "visible" || currentVis === "") {
                        this.beforeShowEvent.fire();

                        Dom.setStyle(this.element, "visibility", "visible");

                        this.cfg.refireEvent("iframe");
                        this.showEvent.fire();
                    }
                }
            } else { // Hide

                if (isMacGecko) {
                    this.hideMacGeckoScrollbars();
                }
                    
                if (effect) { // Animate out if showing
                    if (currentVis == "visible") {
                        this.beforeHideEvent.fire();

                        nEffectInstances = effectInstances.length;
                        for (k = 0; k < nEffectInstances; k++) {
                            h = effectInstances[k];
    
                            if (k === 0 && !alreadySubscribed(
                                h.animateOutCompleteEvent, this.hideEvent.fire, 
                                this.hideEvent)) {
    
                                /*
                                     Delegate hideEvent until end 
                                     of animateOutComplete
                                */
    
                                h.animateOutCompleteEvent.subscribe(
                                    this.hideEvent.fire, this.hideEvent, true);
    
                            }
                            h.animateOut();
                        }

                    } else if (currentVis === "") {
                        Dom.setStyle(this.element, "visibility", "hidden");
                    }

                } else { // Simple hide

                    if (currentVis == "visible" || currentVis === "") {
                        this.beforeHideEvent.fire();
                        Dom.setStyle(this.element, "visibility", "hidden");
                        this.hideEvent.fire();
                    }
                }
            }
        },

        /**
        * Center event handler used for centering on scroll/resize, but only if 
        * the Overlay is visible
        * @method doCenterOnDOMEvent
        */
        doCenterOnDOMEvent: function () {
            if (this.cfg.getProperty("visible")) {
                this.center();
            }
        },

        /**
        * The default event handler fired when the "fixedcenter" property 
        * is changed.
        * @method configFixedCenter
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configFixedCenter: function (type, args, obj) {

            var val = args[0],
                alreadySubscribed = Config.alreadySubscribed,
                windowResizeEvent = Overlay.windowResizeEvent,
                windowScrollEvent = Overlay.windowScrollEvent;

            if (val) {
                this.center();

                if (!alreadySubscribed(this.beforeShowEvent, this.center, this)) {
                    this.beforeShowEvent.subscribe(this.center);
                }

                if (!alreadySubscribed(windowResizeEvent, this.doCenterOnDOMEvent, this)) {
                    windowResizeEvent.subscribe(this.doCenterOnDOMEvent, this, true);
                }

                if (!alreadySubscribed(windowScrollEvent, this.doCenterOnDOMEvent, this)) {
                    windowScrollEvent.subscribe(this.doCenterOnDOMEvent, this, true);
                }

            } else {
                this.beforeShowEvent.unsubscribe(this.center);

                windowResizeEvent.unsubscribe(this.doCenterOnDOMEvent, this);
                windowScrollEvent.unsubscribe(this.doCenterOnDOMEvent, this);
            }
        },
        
        /**
        * The default event handler fired when the "height" property is changed.
        * @method configHeight
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configHeight: function (type, args, obj) {

            var height = args[0],
                el = this.element;

            Dom.setStyle(el, "height", height);
            this.cfg.refireEvent("iframe");
        },

        /**
        * The default event handler fired when the "width" property is changed.
        * @method configWidth
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configWidth: function (type, args, obj) {

            var width = args[0],
                el = this.element;
    
            Dom.setStyle(el, "width", width);
            this.cfg.refireEvent("iframe");
        },
        
        /**
        * The default event handler fired when the "zIndex" property is changed.
        * @method configzIndex
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configzIndex: function (type, args, obj) {

            var zIndex = args[0],
                el = this.element;

            if (! zIndex) {
                zIndex = Dom.getStyle(el, "zIndex");
                if (! zIndex || isNaN(zIndex)) {
                    zIndex = 0;
                }
            }

            if (this.iframe || this.cfg.getProperty("iframe") === true) {
                if (zIndex <= 0) {
                    zIndex = 1;
                }
            }

            Dom.setStyle(el, "zIndex", zIndex);
            this.cfg.setProperty("zIndex", zIndex, true);

            if (this.iframe) {
                this.stackIframe();
            }
        },

        /**
        * The default event handler fired when the "xy" property is changed.
        * @method configXY
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configXY: function (type, args, obj) {

            var pos = args[0],
                x = pos[0],
                y = pos[1];

            this.cfg.setProperty("x", x);
            this.cfg.setProperty("y", y);

            this.beforeMoveEvent.fire([x, y]);

            x = this.cfg.getProperty("x");
            y = this.cfg.getProperty("y");


            this.cfg.refireEvent("iframe");
            this.moveEvent.fire([x, y]);
        },

        /**
        * The default event handler fired when the "x" property is changed.
        * @method configX
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configX: function (type, args, obj) {

            var x = args[0],
                y = this.cfg.getProperty("y");

            this.cfg.setProperty("x", x, true);
            this.cfg.setProperty("y", y, true);

            this.beforeMoveEvent.fire([x, y]);

            x = this.cfg.getProperty("x");
            y = this.cfg.getProperty("y");
            
            Dom.setX(this.element, x, true);

            this.cfg.setProperty("xy", [x, y], true);

            this.cfg.refireEvent("iframe");
            this.moveEvent.fire([x, y]);
        },

        /**
        * The default event handler fired when the "y" property is changed.
        * @method configY
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configY: function (type, args, obj) {

            var x = this.cfg.getProperty("x"),
                y = args[0];

            this.cfg.setProperty("x", x, true);
            this.cfg.setProperty("y", y, true);

            this.beforeMoveEvent.fire([x, y]);

            x = this.cfg.getProperty("x");
            y = this.cfg.getProperty("y");

            Dom.setY(this.element, y, true);

            this.cfg.setProperty("xy", [x, y], true);

            this.cfg.refireEvent("iframe");
            this.moveEvent.fire([x, y]);
        },
        
        /**
        * Shows the iframe shim, if it has been enabled.
        * @method showIframe
        */
        showIframe: function () {

            var oIFrame = this.iframe,
                oParentNode;

            if (oIFrame) {
                oParentNode = this.element.parentNode;

                if (oParentNode != oIFrame.parentNode) {
                    this._addToParent(oParentNode, oIFrame);
                }
                oIFrame.style.display = "block";
            }
        },

        /**
        * Hides the iframe shim, if it has been enabled.
        * @method hideIframe
        */
        hideIframe: function () {
            if (this.iframe) {
                this.iframe.style.display = "none";
            }
        },

        /**
        * Syncronizes the size and position of iframe shim to that of its 
        * corresponding Overlay instance.
        * @method syncIframe
        */
        syncIframe: function () {

            var oIFrame = this.iframe,
                oElement = this.element,
                nOffset = Overlay.IFRAME_OFFSET,
                nDimensionOffset = (nOffset * 2),
                aXY;

            if (oIFrame) {
                // Size <iframe>
                oIFrame.style.width = (oElement.offsetWidth + nDimensionOffset + "px");
                oIFrame.style.height = (oElement.offsetHeight + nDimensionOffset + "px");

                // Position <iframe>
                aXY = this.cfg.getProperty("xy");

                if (!Lang.isArray(aXY) || (isNaN(aXY[0]) || isNaN(aXY[1]))) {
                    this.syncPosition();
                    aXY = this.cfg.getProperty("xy");
                }
                Dom.setXY(oIFrame, [(aXY[0] - nOffset), (aXY[1] - nOffset)]);
            }
        },

        /**
         * Sets the zindex of the iframe shim, if it exists, based on the zindex of
         * the Overlay element. The zindex of the iframe is set to be one less 
         * than the Overlay element's zindex.
         * 
         * <p>NOTE: This method will not bump up the zindex of the Overlay element
         * to ensure that the iframe shim has a non-negative zindex.
         * If you require the iframe zindex to be 0 or higher, the zindex of 
         * the Overlay element should be set to a value greater than 0, before 
         * this method is called.
         * </p>
         * @method stackIframe
         */
        stackIframe: function () {
            if (this.iframe) {
                var overlayZ = Dom.getStyle(this.element, "zIndex");
                if (!ISOFT.lang.isUndefined(overlayZ) && !isNaN(overlayZ)) {
                    Dom.setStyle(this.iframe, "zIndex", (overlayZ - 1));
                }
            }
        },

        /**
        * The default event handler fired when the "iframe" property is changed.
        * @method configIframe
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configIframe: function (type, args, obj) {

            var bIFrame = args[0];

            function createIFrame() {

                var oIFrame = this.iframe,
                    oElement = this.element,
                    oParent;

                if (!oIFrame) {
                    if (!m_oIFrameTemplate) {
                        m_oIFrameTemplate = document.createElement("iframe");

                        if (this.isSecure) {
                            m_oIFrameTemplate.src = Overlay.IFRAME_SRC;
                        }

                        /*
                            Set the opacity of the <iframe> to 0 so that it 
                            doesn't modify the opacity of any transparent 
                            elements that may be on top of it (like a shadow).
                        */

                        if (ISOFT.env.ua.ie) {
                            m_oIFrameTemplate.style.filter = "alpha(opacity=0)";
                            /*
                                 Need to set the "frameBorder" property to 0 
                                 supress the default <iframe> border in IE.  
                                 Setting the CSS "border" property alone 
                                 doesn't supress it.
                            */
                            m_oIFrameTemplate.frameBorder = 0;
                        }
                        else {
                            m_oIFrameTemplate.style.opacity = "0";
                        }

                        m_oIFrameTemplate.style.position = "absolute";
                        m_oIFrameTemplate.style.border = "none";
                        m_oIFrameTemplate.style.margin = "0";
                        m_oIFrameTemplate.style.padding = "0";
                        m_oIFrameTemplate.style.display = "none";
                    }

                    oIFrame = m_oIFrameTemplate.cloneNode(false);
                    oParent = oElement.parentNode;

                    var parentNode = oParent || document.body;

                    this._addToParent(parentNode, oIFrame);
                    this.iframe = oIFrame;
                }

                /*
                     Show the <iframe> before positioning it since the "setXY" 
                     method of DOM requires the element be in the document 
                     and visible.
                */
                this.showIframe();

                /*
                     Syncronize the size and position of the <iframe> to that 
                     of the Overlay.
                */
                this.syncIframe();
                this.stackIframe();

                // Add event listeners to update the <iframe> when necessary
                if (!this._hasIframeEventListeners) {
                    this.showEvent.subscribe(this.showIframe);
                    this.hideEvent.subscribe(this.hideIframe);
                    this.changeContentEvent.subscribe(this.syncIframe);

                    this._hasIframeEventListeners = true;
                }
            }

            function onBeforeShow() {
                createIFrame.call(this);
                this.beforeShowEvent.unsubscribe(onBeforeShow);
                this._iframeDeferred = false;
            }

            if (bIFrame) { // <iframe> shim is enabled

                if (this.cfg.getProperty("visible")) {
                    createIFrame.call(this);
                } else {
                    if (!this._iframeDeferred) {
                        this.beforeShowEvent.subscribe(onBeforeShow);
                        this._iframeDeferred = true;
                    }
                }

            } else {    // <iframe> shim is disabled
                this.hideIframe();

                if (this._hasIframeEventListeners) {
                    this.showEvent.unsubscribe(this.showIframe);
                    this.hideEvent.unsubscribe(this.hideIframe);
                    this.changeContentEvent.unsubscribe(this.syncIframe);

                    this._hasIframeEventListeners = false;
                }
            }
        },

        /**
         * Set's the container's XY value from DOM if not already set.
         * 
         * Differs from syncPosition, in that the XY value is only sync'd with DOM if 
         * not already set. The method also refire's the XY config property event, so any
         * beforeMove, Move event listeners are invoked.
         * 
         * @method _primeXYFromDOM
         * @protected
         */
        _primeXYFromDOM : function() {
            if (ISOFT.lang.isUndefined(this.cfg.getProperty("xy"))) {
                // Set CFG XY based on DOM XY
                this.syncPosition();
                // Account for XY being set silently in syncPosition (no moveTo fired/called)
                this.cfg.refireEvent("xy");
                this.beforeShowEvent.unsubscribe(this._primeXYFromDOM);
            }
        },

        /**
        * The default event handler fired when the "constraintoviewport" 
        * property is changed.
        * @method configConstrainToViewport
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for 
        * the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configConstrainToViewport: function (type, args, obj) {
            var val = args[0];

            if (val) {
                if (! Config.alreadySubscribed(this.beforeMoveEvent, this.enforceConstraints, this)) {
                    this.beforeMoveEvent.subscribe(this.enforceConstraints, this, true);
                }
                if (! Config.alreadySubscribed(this.beforeShowEvent, this._primeXYFromDOM)) {
                    this.beforeShowEvent.subscribe(this._primeXYFromDOM);
                }
            } else {
                this.beforeShowEvent.unsubscribe(this._primeXYFromDOM);
                this.beforeMoveEvent.unsubscribe(this.enforceConstraints, this);
            }
        },

         /**
        * The default event handler fired when the "context" property 
        * is changed.
        * @method configContext
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configContext: function (type, args, obj) {
    
            var contextArgs = args[0],
                contextEl,
                elementMagnetCorner,
                contextMagnetCorner;

            if (contextArgs) {
                contextEl = contextArgs[0];
                elementMagnetCorner = contextArgs[1];
                contextMagnetCorner = contextArgs[2];
                
                if (contextEl) {
                    if (typeof contextEl == "string") {
                        this.cfg.setProperty("context", 
                            [document.getElementById(contextEl), 
                                elementMagnetCorner, contextMagnetCorner], 
                                true);
                    }
                    
                    if (elementMagnetCorner && contextMagnetCorner) {
                        this.align(elementMagnetCorner, contextMagnetCorner);
                    }
                }
            }
        },

        // END BUILT-IN PROPERTY EVENT HANDLERS //
        /**
        * Aligns the Overlay to its context element using the specified corner 
        * points (represented by the constants TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, 
        * and BOTTOM_RIGHT.
        * @method align
        * @param {String} elementAlign  The String representing the corner of 
        * the Overlay that should be aligned to the context element
        * @param {String} contextAlign  The corner of the context element 
        * that the elementAlign corner should stick to.
        */
        align: function (elementAlign, contextAlign) {

            var contextArgs = this.cfg.getProperty("context"),
                me = this,
                context,
                element,
                contextRegion;

            function doAlign(v, h) {
    
                switch (elementAlign) {
    
                case Overlay.TOP_LEFT:
                    me.moveTo(h, v);
                    break;
    
                case Overlay.TOP_RIGHT:
                    me.moveTo((h - element.offsetWidth), v);
                    break;
    
                case Overlay.BOTTOM_LEFT:
                    me.moveTo(h, (v - element.offsetHeight));
                    break;
    
                case Overlay.BOTTOM_RIGHT:
                    me.moveTo((h - element.offsetWidth), 
                        (v - element.offsetHeight));
                    break;
                }
            }
    
    
            if (contextArgs) {
            
                context = contextArgs[0];
                element = this.element;
                me = this;
                
                if (! elementAlign) {
                    elementAlign = contextArgs[1];
                }
                
                if (! contextAlign) {
                    contextAlign = contextArgs[2];
                }
                
                if (element && context) {
                    contextRegion = Dom.getRegion(context);

                    switch (contextAlign) {
    
                    case Overlay.TOP_LEFT:
                        doAlign(contextRegion.top, contextRegion.left);
                        break;
    
                    case Overlay.TOP_RIGHT:
                        doAlign(contextRegion.top, contextRegion.right);
                        break;
    
                    case Overlay.BOTTOM_LEFT:
                        doAlign(contextRegion.bottom, contextRegion.left);
                        break;
    
                    case Overlay.BOTTOM_RIGHT:
                        doAlign(contextRegion.bottom, contextRegion.right);
                        break;
                    }
    
                }
    
            }
            
        },

        /**
        * The default event handler executed when the moveEvent is fired, if the 
        * "constraintoviewport" is set to true.
        * @method enforceConstraints
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        enforceConstraints: function (type, args, obj) {
            var pos = args[0];
            var cXY = this.getConstrainedXY(pos[0], pos[1]);
            this.cfg.setProperty("x", cXY[0], true);
            this.cfg.setProperty("y", cXY[1], true);
            this.cfg.setProperty("xy", cXY, true);
        },

        /**
         * Given x, y coordinate values, returns the calculated coordinates required to 
         * position the Overlay if it is to be constrained to the viewport, based on the 
         * current element size, viewport dimensions and scroll values.
         *
         * @param {Number} x The X coordinate value to be constrained
         * @param {Number} y The Y coordinate value to be constrained
         * @return {Array} The constrained x and y coordinates at index 0 and 1 respectively;
         */
        getConstrainedXY: function(x, y) {

            var nViewportOffset = Overlay.VIEWPORT_OFFSET,
                viewPortWidth = Dom.getViewportWidth(),
                viewPortHeight = Dom.getViewportHeight(),
                offsetHeight = this.element.offsetHeight,
                offsetWidth = this.element.offsetWidth,
                scrollX = Dom.getDocumentScrollLeft(),
                scrollY = Dom.getDocumentScrollTop();

            var xNew = x;
            var yNew = y;

            if (offsetWidth + nViewportOffset < viewPortWidth) {

                var leftConstraint = scrollX + nViewportOffset;
                var rightConstraint = scrollX + viewPortWidth - offsetWidth - nViewportOffset;

                if (x < leftConstraint) {
                    xNew = leftConstraint;
                } else if (x > rightConstraint) {
                    xNew = rightConstraint;
                }
            } else {
                xNew = nViewportOffset + scrollX;
            }

            if (offsetHeight + nViewportOffset < viewPortHeight) {

                var topConstraint = scrollY + nViewportOffset;
                var bottomConstraint = scrollY + viewPortHeight - offsetHeight - nViewportOffset;

                if (y < topConstraint) {
                    yNew  = topConstraint;
                } else if (y  > bottomConstraint) {
                    yNew  = bottomConstraint;
                }
            } else {
                yNew = nViewportOffset + scrollY;
            }

            return [xNew, yNew];
        },

        /**
        * Centers the container in the viewport.
        * @method center
        */
        center: function () {

            var nViewportOffset = Overlay.VIEWPORT_OFFSET,
                elementWidth = this.element.offsetWidth,
                elementHeight = this.element.offsetHeight,
                viewPortWidth = Dom.getViewportWidth(),
                viewPortHeight = Dom.getViewportHeight(),
                x,
                y;

            if (elementWidth < viewPortWidth) {
                x = (viewPortWidth / 2) - (elementWidth / 2) + Dom.getDocumentScrollLeft();
            } else {
                x = nViewportOffset + Dom.getDocumentScrollLeft();
            }

            if (elementHeight < viewPortHeight) {
                y = (viewPortHeight / 2) - (elementHeight / 2) + Dom.getDocumentScrollTop();
            } else {
                y = nViewportOffset + Dom.getDocumentScrollTop();
            }

            this.cfg.setProperty("xy", [parseInt(x, 10), parseInt(y, 10)]);
            this.cfg.refireEvent("iframe");
        },

        /**
        * Synchronizes the Panel's "xy", "x", and "y" properties with the 
        * Panel's position in the DOM. This is primarily used to update  
        * position information during drag & drop.
        * @method syncPosition
        */
        syncPosition: function () {

            var pos = Dom.getXY(this.element);

            this.cfg.setProperty("x", pos[0], true);
            this.cfg.setProperty("y", pos[1], true);
            this.cfg.setProperty("xy", pos, true);

        },

        /**
        * Event handler fired when the resize monitor element is resized.
        * @method onDomResize
        * @param {DOMEvent} e The resize DOM event
        * @param {Object} obj The scope object
        */
        onDomResize: function (e, obj) {

            var me = this;

            Overlay.superclass.onDomResize.call(this, e, obj);

            setTimeout(function () {
                me.syncPosition();
                me.cfg.refireEvent("iframe");
                me.cfg.refireEvent("context");
            }, 0);
    
        },

        /**
        * Places the Overlay on top of all other instances of 
        * ISOFT.widget.Overlay.
        * @method bringToTop
        */
        bringToTop: function () {

            var aOverlays = [],
                oElement = this.element;

            function compareZIndexDesc(p_oOverlay1, p_oOverlay2) {

                var sZIndex1 = Dom.getStyle(p_oOverlay1, "zIndex"),
                    sZIndex2 = Dom.getStyle(p_oOverlay2, "zIndex"),

                    nZIndex1 = (!sZIndex1 || isNaN(sZIndex1)) ? 0 : parseInt(sZIndex1, 10),
                    nZIndex2 = (!sZIndex2 || isNaN(sZIndex2)) ? 0 : parseInt(sZIndex2, 10);

                if (nZIndex1 > nZIndex2) {
                    return -1;
                } else if (nZIndex1 < nZIndex2) {
                    return 1;
                } else {
                    return 0;
                }
            }

            function isOverlayElement(p_oElement) {

                var oOverlay = Dom.hasClass(p_oElement, Overlay.CSS_OVERLAY),
                    Panel = ISOFT.widget.Panel;

                if (oOverlay && !Dom.isAncestor(oElement, oOverlay)) {
                    if (Panel && Dom.hasClass(p_oElement, Panel.CSS_PANEL)) {
                        aOverlays[aOverlays.length] = p_oElement.parentNode;
                    } else {
                        aOverlays[aOverlays.length] = p_oElement;
                    }
                }
            }

            Dom.getElementsBy(isOverlayElement, "DIV", document.body);

            aOverlays.sort(compareZIndexDesc);

            var oTopOverlay = aOverlays[0],
                nTopZIndex;

            if (oTopOverlay) {
                nTopZIndex = Dom.getStyle(oTopOverlay, "zIndex");

                if (!isNaN(nTopZIndex)) {
                    var bRequiresBump = false;

                    if (oTopOverlay != oElement) {
                        bRequiresBump = true;
                    } else if (aOverlays.length > 1) {
                        var nNextZIndex = Dom.getStyle(aOverlays[1], "zIndex");
                        // Don't rely on DOM order to stack if 2 overlays are at the same zindex.
                        if (!isNaN(nNextZIndex) && (nTopZIndex == nNextZIndex)) {
                            bRequiresBump = true;
                        }
                    }
                    if (bRequiresBump) {
                        this.cfg.setProperty("zindex", (parseInt(nTopZIndex, 10) + 2));
                    }
                }
            }
        },

        /**
        * Removes the Overlay element from the DOM and sets all child 
        * elements to null.
        * @method destroy
        */
        destroy: function () {

            if (this.iframe) {
                this.iframe.parentNode.removeChild(this.iframe);
            }

            this.iframe = null;
        
            Overlay.windowResizeEvent.unsubscribe(
                this.doCenterOnDOMEvent, this);
    
            Overlay.windowScrollEvent.unsubscribe(
                this.doCenterOnDOMEvent, this);
        
            Overlay.superclass.destroy.call(this);
        },
        
        /**
        * Returns a String representation of the object.
        * @method toString
        * @return {String} The string representation of the Overlay.
        */
        toString: function () {
            return "Overlay " + this.id;
        }

    });
}());

(function () {
    
    /**
    * OverlayManager is used for maintaining the focus status of 
    * multiple Overlays.
    * @namespace ISOFT.widget
    * @namespace ISOFT.widget
    * @class OverlayManager
    * @constructor
    * @param {Array} overlays Optional. A collection of Overlays to register 
    * with the manager.
    * @param {Object} userConfig  The object literal representing the user 
    * configuration of the OverlayManager
    */
    ISOFT.widget.OverlayManager = function (userConfig) {
        this.init(userConfig);
    };

    var Overlay = ISOFT.widget.Overlay,
        Event = ISOFT.util.Event,
        Dom = ISOFT.util.Dom,
        Config = ISOFT.util.Config,
        CustomEvent = ISOFT.util.CustomEvent,
        OverlayManager = ISOFT.widget.OverlayManager;
    
    /**
    * The CSS class representing a focused Overlay
    * @property OverlayManager.CSS_FOCUSED
    * @static
    * @final
    * @type String
    */
    OverlayManager.CSS_FOCUSED = "focused";
    
    OverlayManager.prototype = {
    
        /**
        * The class's constructor function
        * @property contructor
        * @type Function
        */
        constructor: OverlayManager,
        
        /**
        * The array of Overlays that are currently registered
        * @property overlays
        * @type ISOFT.widget.Overlay[]
        */
        overlays: null,
        
        /**
        * Initializes the default configuration of the OverlayManager
        * @method initDefaultConfig
        */
        initDefaultConfig: function () {
        
            /**
            * The collection of registered Overlays in use by 
            * the OverlayManager
            * @config overlays
            * @type ISOFT.widget.Overlay[]
            * @default null
            */
            this.cfg.addProperty("overlays", { suppressEvent: true } );
        
            /**
            * The default DOM event that should be used to focus an Overlay
            * @config focusevent
            * @type String
            * @default "mousedown"
            */
            this.cfg.addProperty("focusevent", { value: "mousedown" } );

        },

        /**
        * Initializes the OverlayManager
        * @method init
        * @param {Overlay[]} overlays Optional. A collection of Overlays to 
        * register with the manager.
        * @param {Object} userConfig  The object literal representing the user 
        * configuration of the OverlayManager
        */
        init: function (userConfig) {

            /**
            * The OverlayManager's Config object used for monitoring 
            * configuration properties.
            * @property cfg
            * @type Config
            */
            this.cfg = new Config(this);

            this.initDefaultConfig();

            if (userConfig) {
                this.cfg.applyConfig(userConfig, true);
            }
            this.cfg.fireQueue();

            /**
            * The currently activated Overlay
            * @property activeOverlay
            * @private
            * @type ISOFT.widget.Overlay
            */
            var activeOverlay = null;

            /**
            * Returns the currently focused Overlay
            * @method getActive
            * @return {Overlay} The currently focused Overlay
            */
            this.getActive = function () {
                return activeOverlay;
            };

            /**
            * Focuses the specified Overlay
            * @method focus
            * @param {Overlay} overlay The Overlay to focus
            * @param {String} overlay The id of the Overlay to focus
            */
            this.focus = function (overlay) {
                var o = this.find(overlay);
                if (o) {
                    if (activeOverlay != o) {
                        if (activeOverlay) {
                            activeOverlay.blur();
                        }
                        this.bringToTop(o);

                        activeOverlay = o;

                        Dom.addClass(activeOverlay.element, 
                            OverlayManager.CSS_FOCUSED);

                        o.focusEvent.fire();
                    }
                }
            };
        
            /**
            * Removes the specified Overlay from the manager
            * @method remove
            * @param {Overlay} overlay The Overlay to remove
            * @param {String} overlay The id of the Overlay to remove
            */
            this.remove = function (overlay) {
                var o = this.find(overlay), 
                        originalZ;
                if (o) {
                    if (activeOverlay == o) {
                        activeOverlay = null;
                    }

                    var bDestroyed = (o.element === null && o.cfg === null) ? true : false;

                    if (!bDestroyed) {
                        // Set it's zindex so that it's sorted to the end.
                        originalZ = Dom.getStyle(o.element, "zIndex");
                        o.cfg.setProperty("zIndex", -1000, true);
                    }

                    this.overlays.sort(this.compareZIndexDesc);
                    this.overlays = this.overlays.slice(0, (this.overlays.length - 1));

                    o.hideEvent.unsubscribe(o.blur);
                    o.destroyEvent.unsubscribe(this._onOverlayDestroy, o);

                    if (!bDestroyed) {
                        Event.removeListener(o.element, 
                                    this.cfg.getProperty("focusevent"), 
                                    this._onOverlayElementFocus);

                        o.cfg.setProperty("zIndex", originalZ, true);
                        o.cfg.setProperty("manager", null);
                    }

                    o.focusEvent.unsubscribeAll();
                    o.blurEvent.unsubscribeAll();

                    o.focusEvent = null;
                    o.blurEvent = null;

                    o.focus = null;
                    o.blur = null;
                }
            };

            /**
            * Removes focus from all registered Overlays in the manager
            * @method blurAll
            */
            this.blurAll = function () {
    
                var nOverlays = this.overlays.length,
                    i;

                if (nOverlays > 0) {
                    i = nOverlays - 1;

                    do {
                        this.overlays[i].blur();
                    }
                    while(i--);
                }
            };
        
            this._onOverlayBlur = function (p_sType, p_aArgs) {
                activeOverlay = null;
            };
        
            var overlays = this.cfg.getProperty("overlays");
        
            if (! this.overlays) {
                this.overlays = [];
            }
        
            if (overlays) {
                this.register(overlays);
                this.overlays.sort(this.compareZIndexDesc);
            }
        },
        
        
        /**
        * @method _onOverlayElementFocus
        * @description Event handler for the DOM event that is used to focus 
        * the Overlay instance as specified by the "focusevent" 
        * configuration property.
        * @private
        * @param {Event} p_oEvent Object representing the DOM event 
        * object passed back by the event utility (Event).
        */
        _onOverlayElementFocus: function (p_oEvent) {
        
            var oTarget = Event.getTarget(p_oEvent),
                oClose = this.close;
            
            if (oClose && (oTarget == oClose || Dom.isAncestor(oClose, oTarget))) {
                this.blur();
            } else {
                this.focus();
            }
        },
        
        
        /**
        * @method _onOverlayDestroy
        * @description "destroy" event handler for the Overlay.
        * @private
        * @param {String} p_sType String representing the name of the event  
        * that was fired.
        * @param {Array} p_aArgs Array of arguments sent when the event 
        * was fired.
        * @param {Overlay} p_oOverlay Object representing the menu that 
        * fired the event.
        */
        _onOverlayDestroy: function (p_sType, p_aArgs, p_oOverlay) {
            this.remove(p_oOverlay);
        },
        
        /**
        * Registers an Overlay or an array of Overlays with the manager. Upon 
        * registration, the Overlay receives functions for focus and blur, 
        * along with CustomEvents for each.
        * @method register
        * @param {Overlay} overlay  An Overlay to register with the manager.
        * @param {Overlay[]} overlay  An array of Overlays to register with 
        * the manager.
        * @return {Boolean} True if any Overlays are registered.
        */
        register: function (overlay) {
        
            var mgr = this,
                zIndex,
                regcount,
                i,
                nOverlays;
        
            if (overlay instanceof Overlay) {

                overlay.cfg.addProperty("manager", { value: this } );

                overlay.focusEvent = overlay.createEvent("focus");
                overlay.focusEvent.signature = CustomEvent.LIST;

                overlay.blurEvent = overlay.createEvent("blur");
                overlay.blurEvent.signature = CustomEvent.LIST;
        
                overlay.focus = function () {
                    mgr.focus(this);
                };
        
                overlay.blur = function () {
                    if (mgr.getActive() == this) {
                        Dom.removeClass(this.element, OverlayManager.CSS_FOCUSED);
                        this.blurEvent.fire();
                    }
                };
        
                overlay.blurEvent.subscribe(mgr._onOverlayBlur);
                overlay.hideEvent.subscribe(overlay.blur);
                
                overlay.destroyEvent.subscribe(this._onOverlayDestroy, overlay, this);
        
                Event.on(overlay.element, this.cfg.getProperty("focusevent"), 
                            this._onOverlayElementFocus, null, overlay);
        
                zIndex = Dom.getStyle(overlay.element, "zIndex");

                if (!isNaN(zIndex)) {
                    overlay.cfg.setProperty("zIndex", parseInt(zIndex, 10));
                } else {
                    overlay.cfg.setProperty("zIndex", 0);
                }

                this.overlays.push(overlay);
                this.bringToTop(overlay);

                return true;

            } else if (overlay instanceof Array) {

                regcount = 0;
                nOverlays = overlay.length;

                for (i = 0; i < nOverlays; i++) {
                    if (this.register(overlay[i])) {
                        regcount++;
                    }
                }

                if (regcount > 0) {
                    return true;
                }
            } else {
                return false;
            }
        },

        /**
        * Places the specified Overlay instance on top of all other 
        * Overlay instances.
        * @method bringToTop
        * @param {ISOFT.widget.Overlay} p_oOverlay Object representing an 
        * Overlay instance.
        * @param {String} p_oOverlay String representing the id of an 
        * Overlay instance.
        */        
        bringToTop: function (p_oOverlay) {

            var oOverlay = this.find(p_oOverlay),
                nTopZIndex,
                oTopOverlay,
                aOverlays;

            if (oOverlay) {

                aOverlays = this.overlays;
                aOverlays.sort(this.compareZIndexDesc);

                oTopOverlay = aOverlays[0];

                if (oTopOverlay) {
                    nTopZIndex = Dom.getStyle(oTopOverlay.element, "zIndex");

                    if (!isNaN(nTopZIndex)) {

                        var bRequiresBump = false;

                        if (oTopOverlay !== oOverlay) {
                            bRequiresBump = true;
                        } else if (aOverlays.length > 1) {
                            var nNextZIndex = Dom.getStyle(aOverlays[1].element, "zIndex");
                            // Don't rely on DOM order to stack if 2 overlays are at the same zindex.
                            if (!isNaN(nNextZIndex) && (nTopZIndex == nNextZIndex)) {
                                bRequiresBump = true;
                            }
                        }

                        if (bRequiresBump) {
                            oOverlay.cfg.setProperty("zindex", (parseInt(nTopZIndex, 10) + 2));
                        }
                    }
                    aOverlays.sort(this.compareZIndexDesc);
                }
            }
        },

        /**
        * Attempts to locate an Overlay by instance or ID.
        * @method find
        * @param {Overlay} overlay  An Overlay to locate within the manager
        * @param {String} overlay  An Overlay id to locate within the manager
        * @return {Overlay} The requested Overlay, if found, or null if it 
        * cannot be located.
        */
        find: function (overlay) {

            var aOverlays = this.overlays,
                nOverlays = aOverlays.length,
                i;

            if (nOverlays > 0) {
                i = nOverlays - 1;

                if (overlay instanceof Overlay) {
                    do {
                        if (aOverlays[i] == overlay) {
                            return aOverlays[i];
                        }
                    }
                    while(i--);

                } else if (typeof overlay == "string") {
                    do {
                        if (aOverlays[i].id == overlay) {
                            return aOverlays[i];
                        }
                    }
                    while(i--);
                }
                return null;
            }
        },
        
        /**
        * Used for sorting the manager's Overlays by z-index.
        * @method compareZIndexDesc
        * @private
        * @return {Number} 0, 1, or -1, depending on where the Overlay should 
        * fall in the stacking order.
        */
        compareZIndexDesc: function (o1, o2) {

            var zIndex1 = (o1.cfg) ? o1.cfg.getProperty("zIndex") : null, // Sort invalid (destroyed)
                zIndex2 = (o2.cfg) ? o2.cfg.getProperty("zIndex") : null; // objects at bottom.

            if (zIndex1 === null && zIndex2 === null) {
                return 0;
            } else if (zIndex1 === null){
                return 1;
            } else if (zIndex2 === null) {
                return -1;
            } else if (zIndex1 > zIndex2) {
                return -1;
            } else if (zIndex1 < zIndex2) {
                return 1;
            } else {
                return 0;
            }
        },
        
        /**
        * Shows all Overlays in the manager.
        * @method showAll
        */
        showAll: function () {
        
            var aOverlays = this.overlays,
                nOverlays = aOverlays.length,
                i;

            if (nOverlays > 0) {
                i = nOverlays - 1;
                do {
                    aOverlays[i].show();
                }
                while(i--);
            }
        },

        /**
        * Hides all Overlays in the manager.
        * @method hideAll
        */
        hideAll: function () {
        
            var aOverlays = this.overlays,
                nOverlays = aOverlays.length,
                i;

            if (nOverlays > 0) {
                i = nOverlays - 1;
                do {
                    aOverlays[i].hide();
                }
                while(i--);
            }
        },

        /**
        * Returns a string representation of the object.
        * @method toString
        * @return {String} The string representation of the OverlayManager
        */
        toString: function () {
            return "OverlayManager";
        }
    };

}());

(function () {

    /**
    * Tooltip is an implementation of Overlay that behaves like an OS tooltip, 
    * displaying when the user mouses over a particular element, and 
    * disappearing on mouse out.
    * @namespace ISOFT.widget
    * @class Tooltip
    * @extends ISOFT.widget.Overlay
    * @constructor
    * @param {String} el The element ID representing the Tooltip <em>OR</em>
    * @param {HTMLElement} el The element representing the Tooltip
    * @param {Object} userConfig The configuration object literal containing 
    * the configuration that should be set for this Overlay. See configuration 
    * documentation for more details.
    */
    ISOFT.widget.Tooltip = function (el, userConfig) {
        ISOFT.widget.Tooltip.superclass.constructor.call(this, el, userConfig);
    };

    var Lang = ISOFT.lang,
        Event = ISOFT.util.Event,
        CustomEvent = ISOFT.util.CustomEvent,
        Dom = ISOFT.util.Dom,
        Tooltip = ISOFT.widget.Tooltip,

        m_oShadowTemplate,

        /**
        * Constant representing the Tooltip's configuration properties
        * @property DEFAULT_CONFIG
        * @private
        * @final
        * @type Object
        */
        DEFAULT_CONFIG = {

            "PREVENT_OVERLAP": { 
                key: "preventoverlap", 
                value: true, 
                validator: Lang.isBoolean, 
                supercedes: ["x", "y", "xy"] 
            },

            "SHOW_DELAY": { 
                key: "showdelay", 
                value: 200, 
                validator: Lang.isNumber 
            }, 

            "AUTO_DISMISS_DELAY": { 
                key: "autodismissdelay", 
                value: 5000, 
                validator: Lang.isNumber 
            }, 

            "HIDE_DELAY": { 
                key: "hidedelay", 
                value: 250, 
                validator: Lang.isNumber 
            }, 

            "TEXT": { 
                key: "text", 
                suppressEvent: true 
            }, 

            "CONTAINER": { 
                key: "container"
            },

            "DISABLED": {
                key: "disabled",
                value: false,
                suppressEvent: true
            }
        },

        /**
        * Constant representing the name of the Tooltip's events
        * @property EVENT_TYPES
        * @private
        * @final
        * @type Object
        */
        EVENT_TYPES = {
            "CONTEXT_MOUSE_OVER": "contextMouseOver",
            "CONTEXT_MOUSE_OUT": "contextMouseOut",
            "CONTEXT_TRIGGER": "contextTrigger"
        };

    /**
    * Constant representing the Tooltip CSS class
    * @property ISOFT.widget.Tooltip.CSS_TOOLTIP
    * @static
    * @final
    * @type String
    */
    Tooltip.CSS_TOOLTIP = "iba-tt";

    /* 
        "hide" event handler that sets a Tooltip instance's "width"
        configuration property back to its original value before 
        "setWidthToOffsetWidth" was called.
    */
    function restoreOriginalWidth(p_sType, p_aArgs, p_oObject) {

        var sOriginalWidth = p_oObject[0],
            sNewWidth = p_oObject[1],
            oConfig = this.cfg,
            sCurrentWidth = oConfig.getProperty("width");

        if (sCurrentWidth == sNewWidth) {
            oConfig.setProperty("width", sOriginalWidth);
        }

        this.unsubscribe("hide", this._onHide, p_oObject);
    }

    /* 
        "beforeShow" event handler that sets a Tooltip instance's "width"
        configuration property to the value of its root HTML 
        elements's offsetWidth
    */

    function setWidthToOffsetWidth(p_sType, p_aArgs) {

        var oBody = document.body,
            oConfig = this.cfg,
            sOriginalWidth = oConfig.getProperty("width"),
            sNewWidth,
            oClone;

        if ((!sOriginalWidth || sOriginalWidth == "auto") && 
            (oConfig.getProperty("container") != oBody || 
            oConfig.getProperty("x") >= Dom.getViewportWidth() || 
            oConfig.getProperty("y") >= Dom.getViewportHeight())) {

            oClone = this.element.cloneNode(true);
            oClone.style.visibility = "hidden";
            oClone.style.top = "0px";
            oClone.style.left = "0px";

            oBody.appendChild(oClone);

            sNewWidth = (oClone.offsetWidth + "px");

            oBody.removeChild(oClone);
            oClone = null;

            oConfig.setProperty("width", sNewWidth);
            oConfig.refireEvent("xy");

            this.subscribe("hide", restoreOriginalWidth, [(sOriginalWidth || ""), sNewWidth]);
        }
    }

    // "onDOMReady" that renders the ToolTip

    function onDOMReady(p_sType, p_aArgs, p_oObject) {
        this.render(p_oObject);
    }

    //  "init" event handler that automatically renders the Tooltip

    function onInit() {
        Event.onDOMReady(onDOMReady, this.cfg.getProperty("container"), this);
    }

    ISOFT.extend(Tooltip, ISOFT.widget.Overlay, { 

        /**
        * The Tooltip initialization method. This method is automatically 
        * called by the constructor. A Tooltip is automatically rendered by 
        * the init method, and it also is set to be invisible by default, 
        * and constrained to viewport by default as well.
        * @method init
        * @param {String} el The element ID representing the Tooltip <em>OR</em>
        * @param {HTMLElement} el The element representing the Tooltip
        * @param {Object} userConfig The configuration object literal 
        * containing the configuration that should be set for this Tooltip. 
        * See configuration documentation for more details.
        */
        init: function (el, userConfig) {


            Tooltip.superclass.init.call(this, el);

            this.beforeInitEvent.fire(Tooltip);

            Dom.addClass(this.element, Tooltip.CSS_TOOLTIP);

            if (userConfig) {
                this.cfg.applyConfig(userConfig, true);
            }

            this.cfg.queueProperty("visible", false);
            this.cfg.queueProperty("constraintoviewport", true);

            this.setBody("");

            this.subscribe("beforeShow", setWidthToOffsetWidth);
            this.subscribe("init", onInit);
            this.subscribe("render", this.onRender);

            this.initEvent.fire(Tooltip);
        },

        /**
        * Initializes the custom events for Tooltip
        * @method initEvents
        */
        initEvents: function () {

            Tooltip.superclass.initEvents.call(this);
            var SIGNATURE = CustomEvent.LIST;

            /**
            * CustomEvent fired when user mouses over a context element. Returning false from
            * a subscriber to this event will prevent the tooltip from being displayed for
            * the current context element.
            * 
            * @event contextMouseOverEvent
            * @param {HTMLElement} context The context element which the user just moused over
            * @param {DOMEvent} e The DOM event object, associated with the mouse over
            */
            this.contextMouseOverEvent = this.createEvent(EVENT_TYPES.CONTEXT_MOUSE_OVER);
            this.contextMouseOverEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired when the user mouses out of a context element.
            * 
            * @event contextMouseOutEvent
            * @param {HTMLElement} context The context element which the user just moused out of
            * @param {DOMEvent} e The DOM event object, associated with the mouse out
            */
            this.contextMouseOutEvent = this.createEvent(EVENT_TYPES.CONTEXT_MOUSE_OUT);
            this.contextMouseOutEvent.signature = SIGNATURE;

            /**
            * CustomEvent fired just before the tooltip is displayed for the current context.
            * <p>
            *  You can subscribe to this event if you need to set up the text for the 
            *  tooltip based on the context element for which it is about to be displayed.
            * </p>
            * <p>This event differs from the beforeShow event in following respects:</p>
            * <ol>
            *   <li>
            *    When moving from one context element to another, if the tooltip is not
            *    hidden (the <code>hidedelay</code> is not reached), the beforeShow and Show events will not
            *    be fired when the tooltip is displayed for the new context since it is already visible.
            *    However the contextTrigger event is always fired before displaying the tooltip for
            *    a new context.
            *   </li>
            *   <li>
            *    The trigger event provides access to the context element, allowing you to 
            *    set the text of the tooltip based on context element for which the tooltip is
            *    triggered.
            *   </li>
            * </ol>
            * <p>
            *  It is not possible to prevent the tooltip from being displayed
            *  using this event. You can use the contextMouseOverEvent if you need to prevent
            *  the tooltip from being displayed.
            * </p>
            * @event contextTriggerEvent
            * @param {HTMLElement} context The context element for which the tooltip is triggered
            */
            this.contextTriggerEvent = this.createEvent(EVENT_TYPES.CONTEXT_TRIGGER);
            this.contextTriggerEvent.signature = SIGNATURE;
        },

        /**
        * Initializes the class's configurable properties which can be 
        * changed using the Overlay's Config object (cfg).
        * @method initDefaultConfig
        */
        initDefaultConfig: function () {

            Tooltip.superclass.initDefaultConfig.call(this);

            /**
            * Specifies whether the Tooltip should be kept from overlapping 
            * its context element.
            * @config preventoverlap
            * @type Boolean
            * @default true
            */
            this.cfg.addProperty(DEFAULT_CONFIG.PREVENT_OVERLAP.key, {
                value: DEFAULT_CONFIG.PREVENT_OVERLAP.value, 
                validator: DEFAULT_CONFIG.PREVENT_OVERLAP.validator, 
                supercedes: DEFAULT_CONFIG.PREVENT_OVERLAP.supercedes
            });

            /**
            * The number of milliseconds to wait before showing a Tooltip 
            * on mouseover.
            * @config showdelay
            * @type Number
            * @default 200
            */
            this.cfg.addProperty(DEFAULT_CONFIG.SHOW_DELAY.key, {
                handler: this.configShowDelay,
                value: 200, 
                validator: DEFAULT_CONFIG.SHOW_DELAY.validator
            });

            /**
            * The number of milliseconds to wait before automatically 
            * dismissing a Tooltip after the mouse has been resting on the 
            * context element.
            * @config autodismissdelay
            * @type Number
            * @default 5000
            */
            this.cfg.addProperty(DEFAULT_CONFIG.AUTO_DISMISS_DELAY.key, {
                handler: this.configAutoDismissDelay,
                value: DEFAULT_CONFIG.AUTO_DISMISS_DELAY.value,
                validator: DEFAULT_CONFIG.AUTO_DISMISS_DELAY.validator
            });

            /**
            * The number of milliseconds to wait before hiding a Tooltip 
            * on mouseover.
            * @config hidedelay
            * @type Number
            * @default 250
            */
            this.cfg.addProperty(DEFAULT_CONFIG.HIDE_DELAY.key, {
                handler: this.configHideDelay,
                value: DEFAULT_CONFIG.HIDE_DELAY.value, 
                validator: DEFAULT_CONFIG.HIDE_DELAY.validator
            });

            /**
            * Specifies the Tooltip's text. 
            * @config text
            * @type String
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.TEXT.key, {
                handler: this.configText,
                suppressEvent: DEFAULT_CONFIG.TEXT.suppressEvent
            });

            /**
            * Specifies the container element that the Tooltip's markup 
            * should be rendered into.
            * @config container
            * @type HTMLElement/String
            * @default document.body
            */
            this.cfg.addProperty(DEFAULT_CONFIG.CONTAINER.key, {
                handler: this.configContainer,
                value: document.body
            });

            /**
            * Specifies whether or not the tooltip is disabled. Disabled tooltips
            * will not be displayed. If the tooltip is driven by the title attribute
            * of the context element, the title attribute will still be removed for 
            * disabled tooltips, to prevent default tooltip behavior.
            * 
            * @config disabled
            * @type Boolean
            * @default false
            */
            this.cfg.addProperty(DEFAULT_CONFIG.DISABLED.key, {
                handler: this.configContainer,
                value: DEFAULT_CONFIG.DISABLED.value,
                supressEvent: DEFAULT_CONFIG.DISABLED.suppressEvent
            });

            /**
            * Specifies the element or elements that the Tooltip should be 
            * anchored to on mouseover.
            * @config context
            * @type HTMLElement[]/String[]
            * @default null
            */ 

            /**
            * String representing the width of the Tooltip.  <em>Please note:
            * </em> As of version 2.3 if either no value or a value of "auto" 
            * is specified, and the Toolip's "container" configuration property
            * is set to something other than <code>document.body</code> or 
            * its "context" element resides outside the immediately visible 
            * portion of the document, the width of the Tooltip will be 
            * calculated based on the offsetWidth of its root HTML and set just 
            * before it is made visible.  The original value will be 
            * restored when the Tooltip is hidden. This ensures the Tooltip is 
            * rendered at a usable width.  For more information see 
            * SourceForge bug #1685496 and SourceForge 
            * bug #1735423.
            * @config width
            * @type String
            * @default null
            */
        
        },
        
        // BEGIN BUILT-IN PROPERTY EVENT HANDLERS //
        
        /**
        * The default event handler fired when the "text" property is changed.
        * @method configText
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configText: function (type, args, obj) {
            var text = args[0];
            if (text) {
                this.setBody(text);
            }
        },
        
        /**
        * The default event handler fired when the "container" property 
        * is changed.
        * @method configContainer
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For 
        * configuration handlers, args[0] will equal the newly applied value 
        * for the property.
        * @param {Object} obj The scope object. For configuration handlers,
        * this will usually equal the owner.
        */
        configContainer: function (type, args, obj) {
            var container = args[0];

            if (typeof container == 'string') {
                this.cfg.setProperty("container", document.getElementById(container), true);
            }
        },
        
        /**
        * @method _removeEventListeners
        * @description Removes all of the DOM event handlers from the HTML
        *  element(s) that trigger the display of the tooltip.
        * @protected
        */
        _removeEventListeners: function () {
        
            var aElements = this._context,
                nElements,
                oElement,
                i;

            if (aElements) {
                nElements = aElements.length;
                if (nElements > 0) {
                    i = nElements - 1;
                    do {
                        oElement = aElements[i];
                        Event.removeListener(oElement, "mouseover", this.onContextMouseOver);
                        Event.removeListener(oElement, "mousemove", this.onContextMouseMove);
                        Event.removeListener(oElement, "mouseout", this.onContextMouseOut);
                    }
                    while (i--);
                }
            }
        },
        
        /**
        * The default event handler fired when the "context" property 
        * is changed.
        * @method configContext
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers,
        * this will usually equal the owner.
        */
        configContext: function (type, args, obj) {
        
            var context = args[0],
                aElements,
                nElements,
                oElement,
                i;

            if (context) {

                // Normalize parameter into an array
                if (! (context instanceof Array)) {
                    if (typeof context == "string") {
                        this.cfg.setProperty("context", [document.getElementById(context)], true);
                    } else { // Assuming this is an element
                        this.cfg.setProperty("context", [context], true);
                    }
                    context = this.cfg.getProperty("context");
                }

                // Remove any existing mouseover/mouseout listeners
                this._removeEventListeners();

                // Add mouseover/mouseout listeners to context elements
                this._context = context;

                aElements = this._context;

                if (aElements) {
                    nElements = aElements.length;
                    if (nElements > 0) {
                        i = nElements - 1;
                        do {
                            oElement = aElements[i];
                            Event.on(oElement, "mouseover", this.onContextMouseOver, this);
                            Event.on(oElement, "mousemove", this.onContextMouseMove, this);
                            Event.on(oElement, "mouseout", this.onContextMouseOut, this);
                        }
                        while (i--);
                    }
                }
            }
        },

        // END BUILT-IN PROPERTY EVENT HANDLERS //

        // BEGIN BUILT-IN DOM EVENT HANDLERS //

        /**
        * The default event handler fired when the user moves the mouse while 
        * over the context element.
        * @method onContextMouseMove
        * @param {DOMEvent} e The current DOM event
        * @param {Object} obj The object argument
        */
        onContextMouseMove: function (e, obj) {
            obj.pageX = Event.getPageX(e);
            obj.pageY = Event.getPageY(e);
        },

        /**
        * The default event handler fired when the user mouses over the 
        * context element.
        * @method onContextMouseOver
        * @param {DOMEvent} e The current DOM event
        * @param {Object} obj The object argument
        */
        onContextMouseOver: function (e, obj) {
            var context = this;

            if (context.title) {
                obj._tempTitle = context.title;
                context.title = "";
            }

            // Fire first, to honor disabled set in the listner
            if (obj.fireEvent("contextMouseOver", context, e) !== false 
                    && !obj.cfg.getProperty("disabled")) {

                // Stop the tooltip from being hidden (set on last mouseout)
                if (obj.hideProcId) {
                    clearTimeout(obj.hideProcId);
                    obj.hideProcId = null;
                }

                Event.on(context, "mousemove", obj.onContextMouseMove, obj);

                /**
                * The unique process ID associated with the thread responsible 
                * for showing the Tooltip.
                * @type int
                */
                obj.showProcId = obj.doShow(e, context);
            }
        },

        /**
        * The default event handler fired when the user mouses out of 
        * the context element.
        * @method onContextMouseOut
        * @param {DOMEvent} e The current DOM event
        * @param {Object} obj The object argument
        */
        onContextMouseOut: function (e, obj) {
            var el = this;

            if (obj._tempTitle) {
                el.title = obj._tempTitle;
                obj._tempTitle = null;
            }

            if (obj.showProcId) {
                clearTimeout(obj.showProcId);
                obj.showProcId = null;
            }

            if (obj.hideProcId) {
                clearTimeout(obj.hideProcId);
                obj.hideProcId = null;
            }

            obj.fireEvent("contextMouseOut", el, e);

            obj.hideProcId = setTimeout(function () {
                obj.hide();
            }, obj.cfg.getProperty("hidedelay"));
        },

        // END BUILT-IN DOM EVENT HANDLERS //

        /**
        * Processes the showing of the Tooltip by setting the timeout delay 
        * and offset of the Tooltip.
        * @method doShow
        * @param {DOMEvent} e The current DOM event
        * @return {Number} The process ID of the timeout function associated 
        * with doShow
        */
        doShow: function (e, context) {

            var yOffset = 25,
                me = this;

            if (ISOFT.env.ua.opera && context.tagName && 
                context.tagName.toUpperCase() == "A") {
                yOffset += 12;
            }

            return setTimeout(function () {

                var txt = me.cfg.getProperty("text");

                // title does not over-ride text
                if (me._tempTitle && (txt === "" || ISOFT.lang.isUndefined(txt) || ISOFT.lang.isNull(txt))) {
                    me.setBody(me._tempTitle);
                } else {
                    me.cfg.refireEvent("text");
                }

                me.moveTo(me.pageX, me.pageY + yOffset);

                if (me.cfg.getProperty("preventoverlap")) {
                    me.preventOverlap(me.pageX, me.pageY);
                }

                Event.removeListener(context, "mousemove", me.onContextMouseMove);

                me.contextTriggerEvent.fire(context);

                me.show();

                me.hideProcId = me.doHide();

            }, this.cfg.getProperty("showdelay"));
        },

        /**
        * Sets the timeout for the auto-dismiss delay, which by default is 5 
        * seconds, meaning that a tooltip will automatically dismiss itself 
        * after 5 seconds of being displayed.
        * @method doHide
        */
        doHide: function () {

            var me = this;


            return setTimeout(function () {

                me.hide();

            }, this.cfg.getProperty("autodismissdelay"));

        },
        
        /**
        * Fired when the Tooltip is moved, this event handler is used to 
        * prevent the Tooltip from overlapping with its context element.
        * @method preventOverlay
        * @param {Number} pageX The x coordinate position of the mouse pointer
        * @param {Number} pageY The y coordinate position of the mouse pointer
        */
        preventOverlap: function (pageX, pageY) {
        
            var height = this.element.offsetHeight,
                mousePoint = new ISOFT.util.Point(pageX, pageY),
                elementRegion = Dom.getRegion(this.element);
        
            elementRegion.top -= 5;
            elementRegion.left -= 5;
            elementRegion.right += 5;
            elementRegion.bottom += 5;
        
        
            if (elementRegion.contains(mousePoint)) {
                this.cfg.setProperty("y", (pageY - height - 5));
            }
        },


        /**
        * @method onRender
        * @description "render" event handler for the Tooltip.
        * @param {String} p_sType String representing the name of the event  
        * that was fired.
        * @param {Array} p_aArgs Array of arguments sent when the event 
        * was fired.
        */
        onRender: function (p_sType, p_aArgs) {
    
            function sizeShadow() {
    
                var oElement = this.element,
                    oShadow = this._shadow;
            
                if (oShadow) {
                    oShadow.style.width = (oElement.offsetWidth + 6) + "px";
                    oShadow.style.height = (oElement.offsetHeight + 1) + "px"; 
                }
            
            }

            function addShadowVisibleClass() {
                Dom.addClass(this._shadow, "iba-tt-shadow-visible");
            }
            

            function removeShadowVisibleClass() {
                Dom.removeClass(this._shadow, "iba-tt-shadow-visible");
            }

            function createShadow() {
    
                var oShadow = this._shadow,
                    oElement,
                    Module,
                    nIE,
                    me;
    
                if (!oShadow) {
    
                    oElement = this.element;
                    Module = ISOFT.widget.Module;
                    nIE = ISOFT.env.ua.ie;
                    me = this;

                    if (!m_oShadowTemplate) {
                        m_oShadowTemplate = document.createElement("div");
                        m_oShadowTemplate.className = "iba-tt-shadow";
                    }

                    oShadow = m_oShadowTemplate.cloneNode(false);

                    oElement.appendChild(oShadow);

                    this._shadow = oShadow;

                    addShadowVisibleClass.call(this);

                    this.subscribe("beforeShow", addShadowVisibleClass);
                    this.subscribe("beforeHide", removeShadowVisibleClass);

                    if (nIE == 6 || (nIE == 7 && document.compatMode == "BackCompat")) {
                        window.setTimeout(function () { 
                            sizeShadow.call(me); 
                        }, 0);
    
                        this.cfg.subscribeToConfigEvent("width", sizeShadow);
                        this.cfg.subscribeToConfigEvent("height", sizeShadow);
                        this.subscribe("changeContent", sizeShadow);

                        Module.textResizeEvent.subscribe(sizeShadow, this, true);
                        this.subscribe("destroy", function () {
                            Module.textResizeEvent.unsubscribe(sizeShadow, this);
                        });
                    }
                }
            }

            function onBeforeShow() {
                createShadow.call(this);
                this.unsubscribe("beforeShow", onBeforeShow);
            }

            if (this.cfg.getProperty("visible")) {
                createShadow.call(this);
            } else {
                this.subscribe("beforeShow", onBeforeShow);
            }
        
        },
        
        /**
        * Removes the Tooltip element from the DOM and sets all child 
        * elements to null.
        * @method destroy
        */
        destroy: function () {
        
            // Remove any existing mouseover/mouseout listeners
            this._removeEventListeners();

            Tooltip.superclass.destroy.call(this);  
        
        },
        
        /**
        * Returns a string representation of the object.
        * @method toString
        * @return {String} The string representation of the Tooltip
        */
        toString: function () {
            return "Tooltip " + this.id;
        }
    
    });

}());

(function () {

    /**
    * Panel is an implementation of Overlay that behaves like an OS window, 
    * with a draggable header and an optional close icon at the top right.
    * @namespace ISOFT.widget
    * @class Panel
    * @extends ISOFT.widget.Overlay
    * @constructor
    * @param {String} el The element ID representing the Panel <em>OR</em>
    * @param {HTMLElement} el The element representing the Panel
    * @param {Object} userConfig The configuration object literal containing 
    * the configuration that should be set for this Panel. See configuration 
    * documentation for more details.
    */
    ISOFT.widget.Panel = function (el, userConfig) {
        ISOFT.widget.Panel.superclass.constructor.call(this, el, userConfig);
    };

    var Lang = ISOFT.lang,
        DD = ISOFT.util.DD,
        Dom = ISOFT.util.Dom,
        Event = ISOFT.util.Event,
        Overlay = ISOFT.widget.Overlay,
        CustomEvent = ISOFT.util.CustomEvent,
        Config = ISOFT.util.Config,
        Panel = ISOFT.widget.Panel,

        m_oMaskTemplate,
        m_oUnderlayTemplate,
        m_oCloseIconTemplate,

        /**
        * Constant representing the name of the Panel's events
        * @property EVENT_TYPES
        * @private
        * @final
        * @type Object
        */
        EVENT_TYPES = {
            "SHOW_MASK": "showMask",
            "HIDE_MASK": "hideMask",
            "DRAG": "drag"
        },

        /**
        * Constant representing the Panel's configuration properties
        * @property DEFAULT_CONFIG
        * @private
        * @final
        * @type Object
        */
        DEFAULT_CONFIG = {

            "CLOSE": { 
                key: "close", 
                value: true, 
                validator: Lang.isBoolean, 
                supercedes: ["visible"] 
            },

            "DRAGGABLE": { 
                key: "draggable", 
                value: (DD ? true : false), 
                validator: Lang.isBoolean, 
                supercedes: ["visible"]  
            },

            "DRAG_ONLY" : {
                key: "dragonly",
                value: false,
                validator: Lang.isBoolean,
                supercedes: ["draggable"]
            },

            "UNDERLAY": { 
                key: "underlay", 
                value: "shadow", 
                supercedes: ["visible"] 
            },

            "MODAL": { 
                key: "modal", 
                value: false, 
                validator: Lang.isBoolean, 
                supercedes: ["visible", "zindex"]
            },

            "KEY_LISTENERS": {
                key: "keylisteners",
                suppressEvent: true,
                supercedes: ["visible"]
            }
        };

    /**
    * Constant representing the default CSS class used for a Panel
    * @property ISOFT.widget.Panel.CSS_PANEL
    * @static
    * @final
    * @type String
    */
    Panel.CSS_PANEL = "iba-panel";
    
    /**
    * Constant representing the default CSS class used for a Panel's 
    * wrapping container
    * @property ISOFT.widget.Panel.CSS_PANEL_CONTAINER
    * @static
    * @final
    * @type String
    */
    Panel.CSS_PANEL_CONTAINER = "iba-panel-container";

    /**
     * Constant representing the default set of focusable elements 
     * on the pagewhich Modal Panels will prevent access to, when
     * the modal mask is displayed
     * 
     * @property ISOFT.widget.Panel.FOCUSABLE
     * @static
     * @type Array
     */
    Panel.FOCUSABLE = [
        "a",
        "button",
        "select",
        "textarea",
        "input"
    ];

    // Private CustomEvent listeners

    /* 
        "beforeRender" event handler that creates an empty header for a Panel 
        instance if its "draggable" configuration property is set to "true" 
        and no header has been created.
    */

    function createHeader(p_sType, p_aArgs) {
        if (!this.header && this.cfg.getProperty("draggable")) {
            this.setHeader("&#160;");
        }
    }

    /* 
        "hide" event handler that sets a Panel instance's "width"
        configuration property back to its original value before 
        "setWidthToOffsetWidth" was called.
    */
    
    function restoreOriginalWidth(p_sType, p_aArgs, p_oObject) {

        var sOriginalWidth = p_oObject[0],
            sNewWidth = p_oObject[1],
            oConfig = this.cfg,
            sCurrentWidth = oConfig.getProperty("width");

        if (sCurrentWidth == sNewWidth) {
            oConfig.setProperty("width", sOriginalWidth);
        }

        this.unsubscribe("hide", restoreOriginalWidth, p_oObject);
    }

    /* 
        "beforeShow" event handler that sets a Panel instance's "width"
        configuration property to the value of its root HTML 
        elements's offsetWidth
    */

    function setWidthToOffsetWidth(p_sType, p_aArgs) {

        var nIE = ISOFT.env.ua.ie,
            oConfig,
            sOriginalWidth,
            sNewWidth;

        if (nIE == 6 || (nIE == 7 && document.compatMode == "BackCompat")) {

            oConfig = this.cfg;
            sOriginalWidth = oConfig.getProperty("width");
            
            if (!sOriginalWidth || sOriginalWidth == "auto") {
    
                sNewWidth = (this.element.offsetWidth + "px");
    
                oConfig.setProperty("width", sNewWidth);
                
                this.subscribe("hide", restoreOriginalWidth, 
                    [(sOriginalWidth || ""), sNewWidth]);
            
            }
        }
    }

    ISOFT.extend(Panel, Overlay, {

        /**
        * The Overlay initialization method, which is executed for Overlay and 
        * all of its subclasses. This method is automatically called by the 
        * constructor, and  sets up all DOM references for pre-existing markup, 
        * and creates required markup if it is not already present.
        * @method init
        * @param {String} el The element ID representing the Overlay <em>OR</em>
        * @param {HTMLElement} el The element representing the Overlay
        * @param {Object} userConfig The configuration object literal 
        * containing the configuration that should be set for this Overlay. 
        * See configuration documentation for more details.
        */
        init: function (el, userConfig) {
    
            /*
                 Note that we don't pass the user config in here yet because 
                 we only want it executed once, at the lowest subclass level
            */

            Panel.superclass.init.call(this, el/*, userConfig*/);  

            this.beforeInitEvent.fire(Panel);

            Dom.addClass(this.element, Panel.CSS_PANEL);

            this.buildWrapper();

            if (userConfig) {
                this.cfg.applyConfig(userConfig, true);
            }

            this.subscribe("showMask", this._addFocusHandlers);
            this.subscribe("hideMask", this._removeFocusHandlers);
            this.subscribe("beforeRender", createHeader);

            this.initEvent.fire(Panel);
        },

        /**
         * @method _onElementFocus 
         * @private
         * 
         * "focus" event handler for a focuable element. Used to automatically 
         * blur the element when it receives focus to ensure that a Panel 
         * instance's modality is not compromised.
         * 
         * @param {Event} e The DOM event object
         */
        _onElementFocus : function(e){
            this.blur();
        },

        /** 
         *  @method _addFocusHandlers
         *  @protected
         *  
         *  "showMask" event handler that adds a "focus" event handler to all
         *  focusable elements in the document to enforce a Panel instance's 
         *  modality from being compromised.
         *  
         *  @param p_sType {String} Custom event type
         *  @param p_aArgs {Array} Custom event arguments
         */
        _addFocusHandlers: function(p_sType, p_aArgs) {
            var me = this,
                focus = "focus",
                hidden = "hidden";

            function isFocusable(el) {
                // NOTE: if e.type is undefined that's fine, want to avoid perf 
                // impact of tagName check to filter for inputs
                if (el.type !== hidden && !Dom.isAncestor(me.element, el)) {
                    Event.on(el, focus, me._onElementFocus);
                    return true;
                }
                return false;
            }

            var focusable = Panel.FOCUSABLE,
                l = focusable.length,
                arr = [];

            for (var i = 0; i < l; i++) {
                arr = arr.concat(Dom.getElementsBy(isFocusable, focusable[i]));
            }

            this.focusableElements = arr;
        },

        /** 
         *  @method _removeFocusHandlers
         *  @protected
         *  
         *  "hideMask" event handler that removes all "focus" event handlers added 
         *  by the "addFocusEventHandlers" method.
         *  
         *  @param p_sType {String} Event type
         *  @param p_aArgs {Array} Event Arguments
         */
        _removeFocusHandlers: function(p_sType, p_aArgs) {
            var aElements = this.focusableElements,
                nElements = aElements.length,
                focus = "focus";

            if (aElements) {
                for (var i = 0; i < nElements; i++) {
                    Event.removeListener(aElements[i], focus, this._onElementFocus);
                }
            }
        },

        /**
        * Initializes the custom events for Module which are fired 
        * automatically at appropriate times by the Module class.
        */
        initEvents: function () {
            Panel.superclass.initEvents.call(this);
        
            var SIGNATURE = CustomEvent.LIST;
        
            /**
            * CustomEvent fired after the modality mask is shown
            * @event showMaskEvent
            */
            this.showMaskEvent = this.createEvent(EVENT_TYPES.SHOW_MASK);
            this.showMaskEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired after the modality mask is hidden
            * @event hideMaskEvent
            */
            this.hideMaskEvent = this.createEvent(EVENT_TYPES.HIDE_MASK);
            this.hideMaskEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent when the Panel is dragged
            * @event dragEvent
            */
            this.dragEvent = this.createEvent(EVENT_TYPES.DRAG);
            this.dragEvent.signature = SIGNATURE;
        
        },
        
        /**
        * Initializes the class's configurable properties which can be changed 
        * using the Panel's Config object (cfg).
        * @method initDefaultConfig
        */
        initDefaultConfig: function () {
            Panel.superclass.initDefaultConfig.call(this);
        
            // Add panel config properties //
        
            /**
            * True if the Panel should display a "close" button
            * @config close
            * @type Boolean
            * @default true
            */
            this.cfg.addProperty(DEFAULT_CONFIG.CLOSE.key, { 
                handler: this.configClose, 
                value: DEFAULT_CONFIG.CLOSE.value, 
                validator: DEFAULT_CONFIG.CLOSE.validator, 
                supercedes: DEFAULT_CONFIG.CLOSE.supercedes 
            });
        
            /**
            * Boolean specifying if the Panel should be draggable.  The default 
            * value is "true" if the Drag and Drop utility is included, 
            * otherwise it is "false." <strong>PLEASE NOTE:</strong> There is a 
            * known issue in IE 6 (Strict Mode and Quirks Mode) and IE 7 
            * (Quirks Mode) where Panels that either don't have a value set for 
            * their "width" configuration property, or their "width" 
            * configuration property is set to "auto" will only be draggable by
            * placing the mouse on the text of the Panel's header element.
            * To fix this bug, draggable Panels missing a value for their 
            * "width" configuration property, or whose "width" configuration 
            * property is set to "auto" will have it set to the value of 
            * their root HTML element's offsetWidth before they are made 
            * visible.  The calculated width is then removed when the Panel is   
            * hidden. <em>This fix is only applied to draggable Panels in IE 6 
            * (Strict Mode and Quirks Mode) and IE 7 (Quirks Mode)</em>. For 
            * more information on this issue see:
            * SourceForge bugs #1726972 and #1589210.
            * @config draggable
            * @type Boolean
            * @default true
            */
            this.cfg.addProperty(DEFAULT_CONFIG.DRAGGABLE.key, { 
                handler: this.configDraggable, 
                value: DEFAULT_CONFIG.DRAGGABLE.value, 
                validator: DEFAULT_CONFIG.DRAGGABLE.validator, 
                supercedes: DEFAULT_CONFIG.DRAGGABLE.supercedes 
            });

            /**
            * Boolean specifying if the draggable Panel should be drag only, not interacting with drop 
            * targets on the page.
            * <p>
            * When set to true, draggable Panels will not check to see if they are over drop targets,
            * or fire the DragDrop events required to support drop target interaction (onDragEnter, 
            * onDragOver, onDragOut, onDragDrop etc.).
            * If the Panel is not designed to be dropped on any target elements on the page, then this 
            * flag can be set to true to improve performance.
            * </p>
            * <p>
            * When set to false, all drop target related events will be fired.
            * </p>
            * <p>
            * The property is set to false by default to maintain backwards compatibility but should be 
            * set to true if drop target interaction is not required for the Panel, to improve performance.</p>
            * 
            * @config dragOnly
            * @type Boolean
            * @default false
            */
            this.cfg.addProperty(DEFAULT_CONFIG.DRAG_ONLY.key, { 
                value: DEFAULT_CONFIG.DRAG_ONLY.value, 
                validator: DEFAULT_CONFIG.DRAG_ONLY.validator, 
                supercedes: DEFAULT_CONFIG.DRAG_ONLY.supercedes 
            });

            /**
            * Sets the type of underlay to display for the Panel. Valid values 
            * are "shadow," "matte," and "none".  <strong>PLEASE NOTE:</strong> 
            * The creation of the underlay element is deferred until the Panel 
            * is initially made visible.  For Gecko-based browsers on Mac
            * OS X the underlay elment is always created as it is used as a 
            * shim to prevent Aqua scrollbars below a Panel instance from poking 
            * through it (See SourceForge bug #836476).
            * @config underlay
            * @type String
            * @default shadow
            */
            this.cfg.addProperty(DEFAULT_CONFIG.UNDERLAY.key, { 
                handler: this.configUnderlay, 
                value: DEFAULT_CONFIG.UNDERLAY.value, 
                supercedes: DEFAULT_CONFIG.UNDERLAY.supercedes 
            });
        
            /**
            * True if the Panel should be displayed in a modal fashion, 
            * automatically creating a transparent mask over the document that
            * will not be removed until the Panel is dismissed.
            * @config modal
            * @type Boolean
            * @default false
            */
            this.cfg.addProperty(DEFAULT_CONFIG.MODAL.key, { 
                handler: this.configModal, 
                value: DEFAULT_CONFIG.MODAL.value,
                validator: DEFAULT_CONFIG.MODAL.validator, 
                supercedes: DEFAULT_CONFIG.MODAL.supercedes 
            });
        
            /**
            * A KeyListener (or array of KeyListeners) that will be enabled 
            * when the Panel is shown, and disabled when the Panel is hidden.
            * @config keylisteners
            * @type ISOFT.util.KeyListener[]
            * @default null
            */
            this.cfg.addProperty(DEFAULT_CONFIG.KEY_LISTENERS.key, { 
                handler: this.configKeyListeners, 
                suppressEvent: DEFAULT_CONFIG.KEY_LISTENERS.suppressEvent, 
                supercedes: DEFAULT_CONFIG.KEY_LISTENERS.supercedes 
            });
        
        },
        
        // BEGIN BUILT-IN PROPERTY EVENT HANDLERS //
        
        /**
        * The default event handler fired when the "close" property is changed.
        * The method controls the appending or hiding of the close icon at the 
        * top right of the Panel.
        * @method configClose
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configClose: function (type, args, obj) {

            var val = args[0],
                oClose = this.close;
        
            function doHide(e, obj) {
                obj.hide();
            }
        
            if (val) {
                if (!oClose) {
                    if (!m_oCloseIconTemplate) {
                        m_oCloseIconTemplate = document.createElement("span");
                        m_oCloseIconTemplate.innerHTML = "&#160;";
                        m_oCloseIconTemplate.className = "container-close";
                    }

                    oClose = m_oCloseIconTemplate.cloneNode(true);
                    this.innerElement.appendChild(oClose);
                    Event.on(oClose, "click", doHide, this);
                    
                    this.close = oClose;

                } else {
                    oClose.style.display = "block";
                }

            } else {
                if (oClose) {
                    oClose.style.display = "none";
                }
            }

        },

        /**
        * The default event handler fired when the "draggable" property 
        * is changed.
        * @method configDraggable
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configDraggable: function (type, args, obj) {
            var val = args[0];

            if (val) {
                if (!DD) {
                    this.cfg.setProperty("draggable", false);
                    return;
                }

                if (this.header) {
                    Dom.setStyle(this.header, "cursor", "move");
                    this.registerDragDrop();
                }

                this.subscribe("beforeShow", setWidthToOffsetWidth);

            } else {

                if (this.dd) {
                    this.dd.unreg();
                }

                if (this.header) {
                    Dom.setStyle(this.header,"cursor","auto");
                }

                this.unsubscribe("beforeShow", setWidthToOffsetWidth);
            }
        },
      
        /**
        * The default event handler fired when the "underlay" property 
        * is changed.
        * @method configUnderlay
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configUnderlay: function (type, args, obj) {

            var UA = ISOFT.env.ua,
                bMacGecko = (this.platform == "mac" && UA.gecko),
                bIEQuirks = (UA.ie == 6 || (UA.ie == 7 && document.compatMode == "BackCompat")),
                sUnderlay = args[0].toLowerCase(),
                oUnderlay = this.underlay,
                oElement = this.element;
                
            function fixWebkitUnderlay() {
                // Webkit 419.3 (Safari 2.x) does not update
                // it's Render Tree for the Container when content changes. 
                // We need to force it to update using this contentChange 
                // listener

                // Webkit 523.6 doesn't have this problem and doesn't 
                // need the fix
                var u = this.underlay;
                Dom.addClass(u, "iba-force-redraw");
                window.setTimeout(function(){Dom.removeClass(u, "iba-force-redraw");}, 0);
            }

            function createUnderlay() {
                var bNew = false;
                if (!oUnderlay) { // create if not already in DOM

                    if (!m_oUnderlayTemplate) {
                        m_oUnderlayTemplate = document.createElement("div");
                        m_oUnderlayTemplate.className = "underlay";
                    }

                    oUnderlay = m_oUnderlayTemplate.cloneNode(false);
                    this.element.appendChild(oUnderlay);

                    this.underlay = oUnderlay;

                    if (bIEQuirks) {
                        this.sizeUnderlay();
                        this.cfg.subscribeToConfigEvent("width", this.sizeUnderlay);
                        this.cfg.subscribeToConfigEvent("height",this.sizeUnderlay);
                        this.changeContentEvent.subscribe(this.sizeUnderlay);
                        ISOFT.widget.Module.textResizeEvent.subscribe(this.sizeUnderlay, this, true);
                    }

                    if (UA.webkit && UA.webkit < 420) {
                        this.changeContentEvent.subscribe(fixWebkitUnderlay);
                    }
                    bNew = true;
                }
            }

            function onBeforeShow() {
                var bNew = createUnderlay.call(this);
                if (!bNew && bIEQuirks) {
                    this.sizeUnderlay();
                }
                this._underlayDeferred = false;
                this.beforeShowEvent.unsubscribe(onBeforeShow);
            }

            function destroyUnderlay() {
                if (this._underlayDeferred) {
                    this.beforeShowEvent.unsubscribe(onBeforeShow);
                    this._underlayDeferred = false;
                }

                if (oUnderlay) {
                    this.cfg.unsubscribeFromConfigEvent("width", this.sizeUnderlay);
                    this.cfg.unsubscribeFromConfigEvent("height",this.sizeUnderlay);
                    this.changeContentEvent.unsubscribe(this.sizeUnderlay);
                    this.changeContentEvent.unsubscribe(fixWebkitUnderlay);
                    ISOFT.widget.Module.textResizeEvent.unsubscribe(this.sizeUnderlay, this, true);

                    this.element.removeChild(oUnderlay);

                    this.underlay = null;
                }
            }

            switch (sUnderlay) {
                case "shadow":
                    Dom.removeClass(oElement, "matte");
                    Dom.addClass(oElement, "shadow");
                    break;
                case "matte":
                    if (!bMacGecko) {
                        destroyUnderlay.call(this);
                    }
                    Dom.removeClass(oElement, "shadow");
                    Dom.addClass(oElement, "matte");
                    break;
                default:
                    if (!bMacGecko) {
                        destroyUnderlay.call(this);
                    }
                    Dom.removeClass(oElement, "shadow");
                    Dom.removeClass(oElement, "matte");
                    break;
            }

            if ((sUnderlay == "shadow") || (bMacGecko && !oUnderlay)) {
                if (this.cfg.getProperty("visible")) {
                    var bNew = createUnderlay.call(this);
                    if (!bNew && bIEQuirks) {
                        this.sizeUnderlay();
                    }
                } else {
                    if (!this._underlayDeferred) {
                        this.beforeShowEvent.subscribe(onBeforeShow);
                        this._underlayDeferred = true;
                    }
                }
            }
        },
        
        /**
        * The default event handler fired when the "modal" property is 
        * changed. This handler subscribes or unsubscribes to the show and hide
        * events to handle the display or hide of the modality mask.
        * @method configModal
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configModal: function (type, args, obj) {

            var modal = args[0];
            if (modal) {
                if (!this._hasModalityEventListeners) {

                    this.subscribe("beforeShow", this.buildMask);
                    this.subscribe("beforeShow", this.bringToTop);
                    this.subscribe("beforeShow", this.showMask);
                    this.subscribe("hide", this.hideMask);

                    Overlay.windowResizeEvent.subscribe(this.sizeMask, 
                        this, true);

                    this._hasModalityEventListeners = true;
                }
            } else {
                if (this._hasModalityEventListeners) {

                    if (this.cfg.getProperty("visible")) {
                        this.hideMask();
                        this.removeMask();
                    }

                    this.unsubscribe("beforeShow", this.buildMask);
                    this.unsubscribe("beforeShow", this.bringToTop);
                    this.unsubscribe("beforeShow", this.showMask);
                    this.unsubscribe("hide", this.hideMask);

                    Overlay.windowResizeEvent.unsubscribe(this.sizeMask, this);
                    
                    this._hasModalityEventListeners = false;
                }
            }
        },
        
        /**
        * Removes the modality mask.
        * @method removeMask
        */
        removeMask: function () {
        
            var oMask = this.mask,
                oParentNode;
        
            if (oMask) {
                /*
                    Hide the mask before destroying it to ensure that DOM
                    event handlers on focusable elements get removed.
                */
                this.hideMask();
                
                oParentNode = oMask.parentNode;
                if (oParentNode) {
                    oParentNode.removeChild(oMask);
                }

                this.mask = null;
            }
        },
        
        /**
        * The default event handler fired when the "keylisteners" property 
        * is changed.
        * @method configKeyListeners
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configKeyListeners: function (type, args, obj) {

            var listeners = args[0],
                listener,
                nListeners,
                i;
        
            if (listeners) {

                if (listeners instanceof Array) {

                    nListeners = listeners.length;

                    for (i = 0; i < nListeners; i++) {

                        listener = listeners[i];
        
                        if (!Config.alreadySubscribed(this.showEvent, 
                            listener.enable, listener)) {

                            this.showEvent.subscribe(listener.enable, 
                                listener, true);

                        }

                        if (!Config.alreadySubscribed(this.hideEvent, 
                            listener.disable, listener)) {

                            this.hideEvent.subscribe(listener.disable, 
                                listener, true);

                            this.destroyEvent.subscribe(listener.disable, 
                                listener, true);
                        }

                    }

                } else {

                    if (!Config.alreadySubscribed(this.showEvent, 
                        listeners.enable, listeners)) {

                        this.showEvent.subscribe(listeners.enable, 
                            listeners, true);
                    }

                    if (!Config.alreadySubscribed(this.hideEvent, 
                        listeners.disable, listeners)) {

                        this.hideEvent.subscribe(listeners.disable, 
                            listeners, true);

                        this.destroyEvent.subscribe(listeners.disable, 
                            listeners, true);

                    }

                }

            }

        },
        
        /**
        * The default event handler fired when the "height" property is changed.
        * @method configHeight
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configHeight: function (type, args, obj) {
    
            var height = args[0],
                el = this.innerElement;
    
            Dom.setStyle(el, "height", height);
            this.cfg.refireEvent("iframe");
    
        },
        
        /**
        * The default event handler fired when the "width" property is changed.
        * @method configWidth
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configWidth: function (type, args, obj) {
    
            var width = args[0],
                el = this.innerElement;
    
            Dom.setStyle(el, "width", width);
            this.cfg.refireEvent("iframe");
    
        },
        
        /**
        * The default event handler fired when the "zIndex" property is changed.
        * @method configzIndex
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configzIndex: function (type, args, obj) {
            Panel.superclass.configzIndex.call(this, type, args, obj);

            if (this.mask || this.cfg.getProperty("modal") === true) {
                var panelZ = Dom.getStyle(this.element, "zIndex");
                if (!panelZ || isNaN(panelZ)) {
                    panelZ = 0;
                }

                if (panelZ === 0) {
                    // Recursive call to configzindex (which should be stopped
                    // from going further because panelZ should no longer === 0)
                    this.cfg.setProperty("zIndex", 1);
                } else {
                    this.stackMask();
                }
            }
        },

        // END BUILT-IN PROPERTY EVENT HANDLERS //
        /**
        * Builds the wrapping container around the Panel that is used for 
        * positioning the shadow and matte underlays. The container element is 
        * assigned to a  local instance variable called container, and the 
        * element is reinserted inside of it.
        * @method buildWrapper
        */
        buildWrapper: function () {

            var elementParent = this.element.parentNode,
                originalElement = this.element,
                wrapper = document.createElement("div");

            wrapper.className = Panel.CSS_PANEL_CONTAINER;
            wrapper.id = originalElement.id + "_c";

            if (elementParent) {
                elementParent.insertBefore(wrapper, originalElement);
            }

            wrapper.appendChild(originalElement);

            this.element = wrapper;
            this.innerElement = originalElement;

            Dom.setStyle(this.innerElement, "visibility", "inherit");
        },

        /**
        * Adjusts the size of the shadow based on the size of the element.
        * @method sizeUnderlay
        */
        sizeUnderlay: function () {
            var oUnderlay = this.underlay,
                oElement;

            if (oUnderlay) {
                oElement = this.element;
                oUnderlay.style.width = oElement.offsetWidth + "px";
                oUnderlay.style.height = oElement.offsetHeight + "px";
            }
        },

        
        /**
        * Registers the Panel's header for drag & drop capability.
        * @method registerDragDrop
        */
        registerDragDrop: function () {

            var me = this;

            if (this.header) {

                if (!DD) {
                    return;
                }

                var bDragOnly = (this.cfg.getProperty("dragonly") === true);
                this.dd = new DD(this.element.id, this.id, {dragOnly: bDragOnly});

                if (!this.header.id) {
                    this.header.id = this.id + "_h";
                }

                this.dd.startDrag = function () {

                    var offsetHeight,
                        offsetWidth,
                        viewPortWidth,
                        viewPortHeight,
                        scrollX,
                        scrollY;

                    if (ISOFT.env.ua.ie == 6) {
                        Dom.addClass(me.element,"drag");
                    }

                    if (me.cfg.getProperty("constraintoviewport")) {

                        var nViewportOffset = Overlay.VIEWPORT_OFFSET;

                        offsetHeight = me.element.offsetHeight;
                        offsetWidth = me.element.offsetWidth;

                        viewPortWidth = Dom.getViewportWidth();
                        viewPortHeight = Dom.getViewportHeight();

                        scrollX = Dom.getDocumentScrollLeft();
                        scrollY = Dom.getDocumentScrollTop();

                        if (offsetHeight + nViewportOffset < viewPortHeight) {
                            this.minY = scrollY + nViewportOffset;
                            this.maxY = scrollY + viewPortHeight - offsetHeight - nViewportOffset;
                        } else {
                            this.minY = scrollY + nViewportOffset;
                            this.maxY = scrollY + nViewportOffset;
                        }

                        if (offsetWidth + nViewportOffset < viewPortWidth) {
                            this.minX = scrollX + nViewportOffset;
                            this.maxX = scrollX + viewPortWidth - offsetWidth - nViewportOffset;
                        } else {
                            this.minX = scrollX + nViewportOffset;
                            this.maxX = scrollX + nViewportOffset;
                        }

                        this.constrainX = true;
                        this.constrainY = true;
                    } else {
                        this.constrainX = false;
                        this.constrainY = false;
                    }

                    me.dragEvent.fire("startDrag", arguments);
                };

                this.dd.onDrag = function () {
                    me.syncPosition();
                    me.cfg.refireEvent("iframe");
                    if (this.platform == "mac" && ISOFT.env.ua.gecko) {
                        this.showMacGeckoScrollbars();
                    }

                    me.dragEvent.fire("onDrag", arguments);
                };

                this.dd.endDrag = function () {

                    if (ISOFT.env.ua.ie == 6) {
                        Dom.removeClass(me.element,"drag");
                    }

                    me.dragEvent.fire("endDrag", arguments);
                    me.moveEvent.fire(me.cfg.getProperty("xy"));

                };

                this.dd.setHandleElId(this.header.id);
                this.dd.addInvalidHandleType("INPUT");
                this.dd.addInvalidHandleType("SELECT");
                this.dd.addInvalidHandleType("TEXTAREA");
            }
        },
        
        /**
        * Builds the mask that is laid over the document when the Panel is 
        * configured to be modal.
        * @method buildMask
        */
        buildMask: function () {
            var oMask = this.mask;
            if (!oMask) {
                if (!m_oMaskTemplate) {
                    m_oMaskTemplate = document.createElement("div");
                    m_oMaskTemplate.className = "mask";
                    m_oMaskTemplate.innerHTML = "&#160;";
                }
                oMask = m_oMaskTemplate.cloneNode(true);
                oMask.id = this.id + "_mask";

                document.body.insertBefore(oMask, document.body.firstElementChild);

                this.mask = oMask;

                if (ISOFT.env.ua.gecko && this.platform == "mac") {
                    Dom.addClass(this.mask, "block-scrollbars");
                }

                // Stack mask based on the element zindex
                this.stackMask();
            }
        },

        /**
        * Hides the modality mask.
        * @method hideMask
        */
        hideMask: function () {
            if (this.cfg.getProperty("modal") && this.mask) {
                this.mask.style.display = "none";
                this.hideMaskEvent.fire();
                Dom.removeClass(document.body, "masked");
            }
        },

        /**
        * Shows the modality mask.
        * @method showMask
        */
        showMask: function () {
            if (this.cfg.getProperty("modal") && this.mask) {
                Dom.addClass(document.body, "masked");
                this.sizeMask();
                this.mask.style.display = "block";
                this.showMaskEvent.fire();
            }
        },

        /**
        * Sets the size of the modality mask to cover the entire scrollable 
        * area of the document
        * @method sizeMask
        */
        sizeMask: function () {
            if (this.mask) {
                this.mask.style.height = Dom.getDocumentHeight() + "px";
                this.mask.style.width = Dom.getDocumentWidth() + "px";
            }
        },

        /**
         * Sets the zindex of the mask, if it exists, based on the zindex of 
         * the Panel element. The zindex of the mask is set to be one less 
         * than the Panel element's zindex.
         * 
         * <p>NOTE: This method will not bump up the zindex of the Panel
         * to ensure that the mask has a non-negative zindex. If you require the
         * mask zindex to be 0 or higher, the zindex of the Panel 
         * should be set to a value higher than 0, before this method is called.
         * </p>
         * @method stackMask
         */
        stackMask: function() {
            if (this.mask) {
                var panelZ = Dom.getStyle(this.element, "zIndex");
                if (!ISOFT.lang.isUndefined(panelZ) && !isNaN(panelZ)) {
                    Dom.setStyle(this.mask, "zIndex", panelZ - 1);
                }
            }
        },

        /**
        * Renders the Panel by inserting the elements that are not already in 
        * the main Panel into their correct places. Optionally appends the 
        * Panel to the specified node prior to the render's execution. NOTE: 
        * For Panels without existing markup, the appendToNode argument is 
        * REQUIRED. If this argument is ommitted and the current element is 
        * not present in the document, the function will return false, 
        * indicating that the render was a failure.
        * @method render
        * @param {String} appendToNode The element id to which the Module 
        * should be appended to prior to rendering <em>OR</em>
        * @param {HTMLElement} appendToNode The element to which the Module 
        * should be appended to prior to rendering
        * @return {boolean} Success or failure of the render
        */
        render: function (appendToNode) {

            return Panel.superclass.render.call(this, 
                appendToNode, this.innerElement);

        },
        
        /**
        * Removes the Panel element from the DOM and sets all child elements
        * to null.
        * @method destroy
        */
        destroy: function () {
        
            Overlay.windowResizeEvent.unsubscribe(this.sizeMask, this);
            
            this.removeMask();
        
            if (this.close) {
            
                Event.purgeElement(this.close);
        
            }
        
            Panel.superclass.destroy.call(this);  
        
        },
        
        /**
        * Returns a String representation of the object.
        * @method toString
        * @return {String} The string representation of the Panel.
        */
        toString: function () {
            return "Panel " + this.id;
        }
    
    });

}());

(function () {

    /**
    * <p>
    * Dialog is an implementation of Panel that can be used to submit form 
    * data.
    * </p>
    * <p>
    * Built-in functionality for buttons with event handlers is included. 
    * If the optional iba Button dependancy is included on the page, the buttons
    * created will be instances of ISOFT.widget.Button, otherwise regular HTML buttons
    * will be created.
    * </p>
    * <p>
    * Forms can be processed in 3 ways -- via an asynchronous Connection utility call, 
    * a simple form POST or GET, or manually. The iba Connection utility should be
    * included if you're using the default "async" postmethod, but is not required if
    * you're using any of the other postmethod values.
    * </p>
    * @namespace ISOFT.widget
    * @class Dialog
    * @extends ISOFT.widget.Panel
    * @constructor
    * @param {String} el The element ID representing the Dialog <em>OR</em>
    * @param {HTMLElement} el The element representing the Dialog
    * @param {Object} userConfig The configuration object literal containing 
    * the configuration that should be set for this Dialog. See configuration 
    * documentation for more details.
    */
    ISOFT.widget.Dialog = function (el, userConfig) {
        ISOFT.widget.Dialog.superclass.constructor.call(this, el, userConfig);
    };

    var Event = ISOFT.util.Event,
        CustomEvent = ISOFT.util.CustomEvent,
        Dom = ISOFT.util.Dom,
        KeyListener = ISOFT.util.KeyListener,
        Connect = ISOFT.util.Connect,
        Dialog = ISOFT.widget.Dialog,
        Lang = ISOFT.lang,

        /**
        * Constant representing the name of the Dialog's events
        * @property EVENT_TYPES
        * @private
        * @final
        * @type Object
        */
        EVENT_TYPES = {
        
            "BEFORE_SUBMIT": "beforeSubmit",
            "SUBMIT": "submit",
            "MANUAL_SUBMIT": "manualSubmit",
            "ASYNC_SUBMIT": "asyncSubmit",
            "FORM_SUBMIT": "formSubmit",
            "CANCEL": "cancel"
        
        },

        /**
        * Constant representing the Dialog's configuration properties
        * @property DEFAULT_CONFIG
        * @private
        * @final
        * @type Object
        */
        DEFAULT_CONFIG = {

            "POST_METHOD": { 
                key: "postmethod", 
                value: "async" 
            },

            "BUTTONS": { 
                key: "buttons", 
                value: "none" 
            },

            "HIDEAFTERSUBMIT" : {
                key: "hideaftersubmit",
                value: true
            }
        };

    /**
    * Constant representing the default CSS class used for a Dialog
    * @property ISOFT.widget.Dialog.CSS_DIALOG
    * @static
    * @final
    * @type String
    */
    Dialog.CSS_DIALOG = "iba-dialog";

    function removeButtonEventHandlers() {

        var aButtons = this._aButtons,
            nButtons,
            oButton,
            i;

        if (Lang.isArray(aButtons)) {
            nButtons = aButtons.length;

            if (nButtons > 0) {
                i = nButtons - 1;
                do {
                    oButton = aButtons[i];

                    if (ISOFT.widget.Button && oButton instanceof ISOFT.widget.Button) {
                        oButton.destroy();
                    }
                    else if (oButton.tagName.toUpperCase() == "BUTTON") {
                        Event.purgeElement(oButton);
                        Event.purgeElement(oButton, false);
                    }
                }
                while (i--);
            }
        }
    }
    
    ISOFT.extend(Dialog, ISOFT.widget.Panel, { 

        /**
        * @property form
        * @description Object reference to the Dialog's 
        * <code>&#60;form&#62;</code> element.
        * @default null 
        * @type <a href="http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/
        * level-one-html.html#ID-40002357">HTMLFormElement</a>
        */
        form: null,
    
        /**
        * Initializes the class's configurable properties which can be changed 
        * using the Dialog's Config object (cfg).
        * @method initDefaultConfig
        */
        initDefaultConfig: function () {
            Dialog.superclass.initDefaultConfig.call(this);

            /**
            * The internally maintained callback object for use with the 
            * Connection utility. The format of the callback object is 
            * similar to Connection Manager's callback object and is 
            * simply passed through to Connection Manager when the async 
            * request is made.
            * @property callback
            * @type Object
            */
            this.callback = {

                /**
                * The function to execute upon success of the 
                * Connection submission (when the form does not
                * contain a file input element).
                * 
                * @property callback.success
                * @type Function
                */
                success: null,

                /**
                * The function to execute upon failure of the 
                * Connection submission
                * @property callback.failure
                * @type Function
                */
                failure: null,

                /**
                 *<p>
                * The function to execute upon success of the 
                * Connection submission, when the form contains
                * a file input element.
                * </p>
                * <p>
                * <em>NOTE:</em> Connection manager will not
                * invoke the success or failure handlers for the file
                * upload use case. This will be the only callback
                * handler invoked.
                * </p>
                * <p>
                * For more information, see the <a href="http://developer.ISOFT.com/iba/connection/#file">
                * Connection Manager documenation on file uploads</a>.
                * </p>
                * @property callback.upload
                * @type Function
                */

                /**
                * The arbitraty argument or arguments to pass to the Connection 
                * callback functions
                * @property callback.argument
                * @type Object
                */
                argument: null

            };

            // Add form dialog config properties //
            /**
            * The method to use for posting the Dialog's form. Possible values 
            * are "async", "form", and "manual".
            * @config postmethod
            * @type String
            * @default async
            */
            this.cfg.addProperty(DEFAULT_CONFIG.POST_METHOD.key, {
                handler: this.configPostMethod, 
                value: DEFAULT_CONFIG.POST_METHOD.value, 
                validator: function (val) {
                    if (val != "form" && val != "async" && val != "none" && 
                        val != "manual") {
                        return false;
                    } else {
                        return true;
                    }
                }
            });

            /**
            * This property is used to configure whether or not the 
            * dialog should be automatically hidden after submit.
            * 
            * @config hideaftersubmit
            * @type Boolean
            * @default true
            */
            this.cfg.addProperty(DEFAULT_CONFIG.HIDEAFTERSUBMIT.key, {
                value: DEFAULT_CONFIG.HIDEAFTERSUBMIT.value
            }); 

            /**
            * Array of object literals, each containing a set of properties 
            * defining a button to be appended into the Dialog's footer.
            * 
            * Each button object in the buttons array can have three properties:
            * <dt>text:</dt>
            * <dd>The text that will display on the face of the button. The text can 
            * include HTML, as long as it is compliant with HTML Button specifications.
            * </dd>
            * <dt>handler:</dt>
            * <dd>Can be either:
            *     <ol>
            *         <li>A reference to a function that should fire when the 
            * button is clicked.  (In this case scope of this function is 
            * always its Dialog instance.)</li>
            *         <li>An object literal representing the code to be 
            * executed when the button is clicked.  Format:<br> <code> {<br>
            * <strong>fn:</strong> Function,   &#47;&#47; The handler to call 
            * when  the event fires.<br> <strong>obj:</strong> Object,
            * &#47;&#47; An  object to pass back to the handler.<br> <strong>
            * scope:</strong>  Object &#47;&#47; The object to use for the 
            * scope of the handler. <br> } </code> <br></li>
            *     </ol>
            * </dd>
            * <dt>isDefault:</dt>
            * <dd>An optional boolean value that specifies that a button 
            * should be highlighted and focused by default.</dd>
            * 
            * <em>NOTE:</em>If the iba Button Widget is included on the page, 
            * the buttons created will be instances of ISOFT.widget.Button. 
            * Otherwise, HTML Buttons (<code>&#60;BUTTON&#62;</code>) will be 
            * created.
            * 
            * @config buttons
            * @type {Array|String}
            * @default "none"
            */
            this.cfg.addProperty(DEFAULT_CONFIG.BUTTONS.key, {
                handler: this.configButtons,
                value: DEFAULT_CONFIG.BUTTONS.value
            }); 

        },

        /**
        * Initializes the custom events for Dialog which are fired 
        * automatically at appropriate times by the Dialog class.
        * @method initEvents
        */
        initEvents: function () {
            Dialog.superclass.initEvents.call(this);

            var SIGNATURE = CustomEvent.LIST;

            /**
            * CustomEvent fired prior to submission
            * @event beforeSubmitEvent
            */ 
            this.beforeSubmitEvent = 
                this.createEvent(EVENT_TYPES.BEFORE_SUBMIT);
            this.beforeSubmitEvent.signature = SIGNATURE;
            
            /**
            * CustomEvent fired after submission
            * @event submitEvent
            */
            this.submitEvent = this.createEvent(EVENT_TYPES.SUBMIT);
            this.submitEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired prior to manual submission
            * @event manualSubmitEvent
            */
            this.manualSubmitEvent = 
                this.createEvent(EVENT_TYPES.MANUAL_SUBMIT);
            this.manualSubmitEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired prior to asynchronous submission
            * @event asyncSubmitEvent
            */ 
            this.asyncSubmitEvent = this.createEvent(EVENT_TYPES.ASYNC_SUBMIT);
            this.asyncSubmitEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired prior to form-based submission
            * @event formSubmitEvent
            */
            this.formSubmitEvent = this.createEvent(EVENT_TYPES.FORM_SUBMIT);
            this.formSubmitEvent.signature = SIGNATURE;
        
            /**
            * CustomEvent fired after cancel
            * @event cancelEvent
            */
            this.cancelEvent = this.createEvent(EVENT_TYPES.CANCEL);
            this.cancelEvent.signature = SIGNATURE;
        
        },
        
        /**
        * The Dialog initialization method, which is executed for Dialog and 
        * all of its subclasses. This method is automatically called by the 
        * constructor, and  sets up all DOM references for pre-existing markup, 
        * and creates required markup if it is not already present.
        * @method init
        * @param {String} el The element ID representing the Dialog <em>OR</em>
        * @param {HTMLElement} el The element representing the Dialog
        * @param {Object} userConfig The configuration object literal 
        * containing the configuration that should be set for this Dialog. 
        * See configuration documentation for more details.
        */
        init: function (el, userConfig) {

            /*
                 Note that we don't pass the user config in here yet because 
                 we only want it executed once, at the lowest subclass level
            */

            Dialog.superclass.init.call(this, el/*, userConfig*/); 
        
            this.beforeInitEvent.fire(Dialog);
        
            Dom.addClass(this.element, Dialog.CSS_DIALOG);
        
            this.cfg.setProperty("visible", false);
        
            if (userConfig) {
                this.cfg.applyConfig(userConfig, true);
            }
        
            this.showEvent.subscribe(this.focusFirst, this, true);
            this.beforeHideEvent.subscribe(this.blurButtons, this, true);

            this.subscribe("changeBody", this.registerForm);
        
            this.initEvent.fire(Dialog);
        },
        
        /**
        * Submits the Dialog's form depending on the value of the 
        * "postmethod" configuration property.  <strong>Please note:
        * </strong> As of version 2.3 this method will automatically handle 
        * asyncronous file uploads should the Dialog instance's form contain 
        * <code>&#60;input type="file"&#62;</code> elements.  If a Dialog 
        * instance will be handling asyncronous file uploads, its 
        * <code>callback</code> property will need to be setup with a 
        * <code>upload</code> handler rather than the standard 
        * <code>success</code> and, or <code>failure</code> handlers.  For more 
        * information, see the <a href="http://developer.ISOFT.com/iba/
        * connection/#file">Connection Manager documenation on file uploads</a>.
        * @method doSubmit
        */
        doSubmit: function () {
    
            var oForm = this.form,
                bUseFileUpload = false,
                bUseSecureFileUpload = false,
                aElements,
                nElements,
                i,
                sMethod;

            switch (this.cfg.getProperty("postmethod")) {
    
            case "async":

                aElements = oForm.elements;
                nElements = aElements.length;

                if (nElements > 0) {
                    i = nElements - 1;
                    do {
                        if (aElements[i].type == "file") {
                            bUseFileUpload = true;
                            break;
                        }
                    }
                    while(i--);
                }

                if (bUseFileUpload && ISOFT.env.ua.ie && this.isSecure) {
                    bUseSecureFileUpload = true;
                }

                sMethod = (oForm.getAttribute("method") || "POST").toUpperCase();

                Connect.setForm(oForm, bUseFileUpload, bUseSecureFileUpload);
                Connect.asyncRequest(sMethod, oForm.getAttribute("action"), this.callback);

                this.asyncSubmitEvent.fire();

                break;

            case "form":

                oForm.submit();
                this.formSubmitEvent.fire();

                break;

            case "none":
            case "manual":

                this.manualSubmitEvent.fire();

                break;
    
            }
    
        },
        
        
        /**
        * Prepares the Dialog's internal FORM object, creating one if one is
        * not currently present.
        * @method registerForm
        */
        registerForm: function () {
    
            var form = this.element.getElementsByTagName("form")[0],
                me = this,
                firstElement,
                lastElement;


            if (this.form) {
                if (this.form == form && 
                    Dom.isAncestor(this.element, this.form)) {
    
                    return;
                } else {
                    Event.purgeElement(this.form);
                    this.form = null;                
                }
            }

            if (!form) {
                form = document.createElement("form");
                form.name = "frm_" + this.id;

                this.body.appendChild(form);
            }

            if (form) {
                this.form = form;

                Event.on(form, "submit", function (e) {
                    Event.stopEvent(e);
                    this.submit();
                    this.form.blur();
                }, this, true);

                this.firstFormElement = function () {
                    var f, el, nElements = form.elements.length;

                    for (f = 0; f < nElements; f++) {
                        el = form.elements[f];
                        if (el.focus && !el.disabled && el.type != "hidden") {
                            return el;
                        }
                    }
                    return null;
                }();
            
                this.lastFormElement = function () {
                    var f, el, nElements = form.elements.length;
                    
                    for (f = nElements - 1; f >= 0; f--) {
                        el = form.elements[f];
                        if (el.focus && !el.disabled && el.type != "hidden") {
                            return el;
                        }
                    }
                    return null;
                }();
            
                if (this.cfg.getProperty("modal")) {
                    firstElement = this.firstFormElement || this.firstButton;
                    if (firstElement) {
                        this.preventBackTab = new KeyListener(firstElement, 
                            { shift: true, keys: 9 }, 
                            { fn: me.focusLast, scope: me, 
                            correctScope: true });
    
                        this.showEvent.subscribe(this.preventBackTab.enable, 
                            this.preventBackTab, true);
    
                        this.hideEvent.subscribe(this.preventBackTab.disable, 
                            this.preventBackTab, true);
                    }
            
                    lastElement = this.lastButton || this.lastFormElement;
    
                    if (lastElement) {
                        this.preventTabOut = new KeyListener(lastElement, 
                            { shift: false, keys: 9 }, 
                            { fn: me.focusFirst, scope: me, 
                            correctScope: true });
    
                        this.showEvent.subscribe(this.preventTabOut.enable, 
                            this.preventTabOut, true);
    
                        this.hideEvent.subscribe(this.preventTabOut.disable, 
                            this.preventTabOut, true);
                    }
                }
            }
        },
        
        // BEGIN BUILT-IN PROPERTY EVENT HANDLERS //
        
        /**
        * The default event handler fired when the "close" property is 
        * changed. The method controls the appending or hiding of the close
        * icon at the top right of the Dialog.
        * @method configClose
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For 
        * configuration handlers, args[0] will equal the newly applied value 
        * for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configClose: function (type, args, obj) {
            var val = args[0];
        
            function doCancel(e, obj) {
                obj.cancel();
            }
        
            if (val) {
                if (! this.close) {
                    this.close = document.createElement("div");
                    Dom.addClass(this.close, "container-close");
        
                    this.close.innerHTML = "&#160;";
                    this.innerElement.appendChild(this.close);
                    Event.on(this.close, "click", doCancel, this);
                } else {
                    this.close.style.display = "block";
                }
            } else {
                if (this.close) {
                    this.close.style.display = "none";
                }
            }
        },
        
        /**
        * The default event handler for the "buttons" configuration property
        * @method configButtons
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configButtons: function (type, args, obj) {
    
            var Button = ISOFT.widget.Button,
                aButtons = args[0],
                oInnerElement = this.innerElement,
                oButton,
                oButtonEl,
                oibaButton,
                nButtons,
                oSpan,
                oFooter,
                i;

            removeButtonEventHandlers.call(this);
            
            this._aButtons = null;

            if (Lang.isArray(aButtons)) {

                oSpan = document.createElement("span");
                oSpan.className = "button-group";

                nButtons = aButtons.length;

                this._aButtons = [];
        
                for (i = 0; i < nButtons; i++) {

                    oButton = aButtons[i];

                    if (Button) {

                        oibaButton = new Button({ label: oButton.text, 
                                            container: oSpan });

                        oButtonEl = oibaButton.get("element");

                        if (oButton.isDefault) {

                            oibaButton.addClass("default");

                            this.defaultHtmlButton = oButtonEl;

                        }
    
                        if (Lang.isFunction(oButton.handler)) {
    
                            oibaButton.set("onclick", { fn: oButton.handler, 
                                obj: this, scope: this });
            
                        }
                        else if (Lang.isObject(oButton.handler) && 
                            Lang.isFunction(oButton.handler.fn)) {

                            oibaButton.set("onclick", { fn: oButton.handler.fn, 
                                obj: ((!Lang.isUndefined(oButton.handler.obj)) ? 
                                oButton.handler.obj : this), 
                                scope: (oButton.handler.scope || this) });
    
                        }

                        this._aButtons[this._aButtons.length] = oibaButton;

                    }
                    else {
        
                        oButtonEl = document.createElement("button");
                        oButtonEl.setAttribute("type", "button");
            
                        if (oButton.isDefault) {
                            oButtonEl.className = "default";
                            this.defaultHtmlButton = oButtonEl;
                        }
    
                        oButtonEl.innerHTML = oButton.text;
    
                        if (Lang.isFunction(oButton.handler)) {
    
                            Event.on(oButtonEl, "click", oButton.handler, 
                                this, true);
            
                        }
                        else if (Lang.isObject(oButton.handler) && 
                            Lang.isFunction(oButton.handler.fn)) {
    
                            Event.on(oButtonEl, "click", oButton.handler.fn, 
                                ((!Lang.isUndefined(oButton.handler.obj)) ? 
                                oButton.handler.obj : this), 
                                (oButton.handler.scope || this));
    
                        }
            
                        oSpan.appendChild(oButtonEl);
                        
                        this._aButtons[this._aButtons.length] = oButtonEl;
                        
                    }

                    oButton.htmlButton = oButtonEl;
        
                    if (i === 0) {
                        this.firstButton = oButtonEl;
                    }
        
                    if (i == (nButtons - 1)) {
                        this.lastButton = oButtonEl;
                    }
        
                }
        
                this.setFooter(oSpan);

                oFooter = this.footer;
                
                if (Dom.inDocument(this.element) && 
                    !Dom.isAncestor(oInnerElement, oFooter)) {
    
                    oInnerElement.appendChild(oFooter);
                
                }

                this.buttonSpan = oSpan;

            } else { // Do cleanup

                oSpan = this.buttonSpan;
                oFooter = this.footer;

                if (oSpan && oFooter) {

                    oFooter.removeChild(oSpan);

                    this.buttonSpan = null;
                    this.firstButton = null;
                    this.lastButton = null;
                    this.defaultHtmlButton = null;

                }

            }

            this.cfg.refireEvent("iframe");
            this.cfg.refireEvent("underlay");
        },

        /**
        * @method getButtons
        * @description Returns an array containing each of the Dialog's 
        * buttons, by default an array of HTML <code>&#60;BUTTON&#62;</code> 
        * elements.  If the Dialog's buttons were created using the 
        * ISOFT.widget.Button class (via the inclusion of the optional Button 
        * dependancy on the page), an array of ISOFT.widget.Button instances 
        * is returned.
        * @return {Array}
        */
        getButtons: function () {
            var aButtons = this._aButtons;
            if (aButtons) {
                return aButtons;
            }
        },
        
        /**
        * Sets focus to the first element in the Dialog's form or the first 
        * button defined via the "buttons" configuration property. Called 
        * when the Dialog is made visible.
        * @method focusFirst
        */
        focusFirst: function (type, args, obj) {
    
            var oElement = this.firstFormElement,
                oEvent;

            if (args) {
                oEvent = args[1];
                if (oEvent) {
                    Event.stopEvent(oEvent);
                }
            }

            if (oElement) {
                /*
                    Place the call to the "focus" method inside a try/catch
                    block to prevent IE from throwing JavaScript errors if
                    the element is disabled or hidden.
                */
                try {
                    oElement.focus();
                }
                catch(oException) {
                }

            } else {
                this.focusDefaultButton();
            }
        },
        
        /**
        * Sets focus to the last element in the Dialog's form or the last 
        * button defined via the "buttons" configuration property.
        * @method focusLast
        */
        focusLast: function (type, args, obj) {
    
            var aButtons = this.cfg.getProperty("buttons"),
                oElement = this.lastFormElement,
                oEvent;
    
            if (args) {
                oEvent = args[1];
                if (oEvent) {
                    Event.stopEvent(oEvent);
                }
            }
            
            if (aButtons && Lang.isArray(aButtons)) {
                this.focusLastButton();
            } else {
                if (oElement) {
                    /*
                        Place the call to the "focus" method inside a try/catch
                        block to prevent IE from throwing JavaScript errors if
                        the element is disabled or hidden.
                    */
    
                    try {
                        oElement.focus();
                    } catch(oException) {
                    }
                }
            }
        },
        
        /**
        * Sets the focus to the button that is designated as the default via 
        * the "buttons" configuration property. By default, this method is 
        * called when the Dialog is made visible.
        * @method focusDefaultButton
        */
        focusDefaultButton: function () {
        
            var oElement = this.defaultHtmlButton;
        
            if (oElement) {

                /*
                    Place the call to the "focus" method inside a try/catch
                    block to prevent IE from throwing JavaScript errors if
                    the element is disabled or hidden.
                */
                try {
                    oElement.focus();
                } catch(oException) {
                }

            }
        },
        
        /**
        * Blurs all the buttons defined via the "buttons" 
        * configuration property.
        * @method blurButtons
        */
        blurButtons: function () {
            
            var aButtons = this.cfg.getProperty("buttons"),
                nButtons,
                oButton,
                oElement,
                i;

            if (aButtons && Lang.isArray(aButtons)) {
            
                nButtons = aButtons.length;
                
                if (nButtons > 0) {
                
                    i = (nButtons - 1);
                    
                    do {
                        oButton = aButtons[i];
                        
                        if (oButton) {

                            oElement = oButton.htmlButton;

                            if (oElement) {
                                /*
                                    Place the call to the "blur" method inside  
                                    a try/catch block to prevent IE from  
                                    throwing JavaScript errors if the element 
                                    is disabled or hidden.
                                */
                                try {
                                    oElement.blur();
                                } catch(oException) {
                                }
                            }
                        }
                    
                    } while(i--);
                }
            }
        },
        
        /**
        * Sets the focus to the first button created via the "buttons"
        * configuration property.
        * @method focusFirstButton
        */
        focusFirstButton: function () {
    
            var aButtons = this.cfg.getProperty("buttons"),
                oButton,
                oElement;

            if (aButtons && Lang.isArray(aButtons)) {

                oButton = aButtons[0];

                if (oButton) {

                    oElement = oButton.htmlButton;
                    
                    if (oElement) {

                        /*
                            Place the call to the "focus" method inside a 
                            try/catch block to prevent IE from throwing 
                            JavaScript errors if the element is disabled 
                            or hidden.
                        */
    
                        try {
                            oElement.focus();
                        }
                        catch(oException) {
                        }
                    }
                }
            }
        },
        
        /**
        * Sets the focus to the last button created via the "buttons" 
        * configuration property.
        * @method focusLastButton
        */
        focusLastButton: function () {
    
            var aButtons = this.cfg.getProperty("buttons"),
                nButtons,
                oButton,
                oElement;

            if (aButtons && Lang.isArray(aButtons)) {

                nButtons = aButtons.length;
                
                if (nButtons > 0) {
                    oButton = aButtons[(nButtons - 1)];
                    
                    if (oButton) {
                        oElement = oButton.htmlButton;
                        if (oElement) {
                            /*
                                Place the call to the "focus" method inside a 
                                try/catch block to prevent IE from throwing 
                                JavaScript errors if the element is disabled
                                or hidden.
                            */
        
                            try {
                                oElement.focus();
                            } catch(oException) {
                            }
                        }
                    }
                }
            }
        },
        
        /**
        * The default event handler for the "postmethod" configuration property
        * @method configPostMethod
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For 
        * configuration handlers, args[0] will equal the newly applied value 
        * for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configPostMethod: function (type, args, obj) {
            this.registerForm();
        },
        
        // END BUILT-IN PROPERTY EVENT HANDLERS //
        
        /**
        * Built-in function hook for writing a validation function that will 
        * be checked for a "true" value prior to a submit. This function, as 
        * implemented by default, always returns true, so it should be 
        * overridden if validation is necessary.
        * @method validate
        */
        validate: function () {
            return true;
        },
        
        /**
        * Executes a submit of the Dialog if validation 
        * is successful. By default the Dialog is hidden
        * after submission, but you can set the "hideaftersubmit"
        * configuration property to false, to prevent the Dialog
        * from being hidden.
        * 
        * @method submit
        */
        submit: function () {
            if (this.validate()) {
                this.beforeSubmitEvent.fire();
                this.doSubmit();
                this.submitEvent.fire();

                if (this.cfg.getProperty("hideaftersubmit")) {
                    this.hide();
                }

                return true;
            } else {
                return false;
            }
        },

        /**
        * Executes the cancel of the Dialog followed by a hide.
        * @method cancel
        */
        cancel: function () {
            this.cancelEvent.fire();
            this.hide();
        },
        
        /**
        * Returns a JSON-compatible data structure representing the data 
        * currently contained in the form.
        * @method getData
        * @return {Object} A JSON object reprsenting the data of the 
        * current form.
        */
        getData: function () {
        
            var oForm = this.form,
                aElements,
                nTotalElements,
                oData,
                sName,
                oElement,
                nElements,
                sType,
                sTagName,
                aOptions,
                nOptions,
                aValues,
                oOption,
                sValue,
                oRadio,
                oCheckbox,
                i,
                n;    
    
            function isFormElement(p_oElement) {
            
                var sTag = p_oElement.tagName.toUpperCase();
                
                return ((sTag == "INPUT" || sTag == "TEXTAREA" || 
                        sTag == "SELECT") && p_oElement.name == sName);
    
            }
    
    
            if (oForm) {
        
                aElements = oForm.elements;
                nTotalElements = aElements.length;
                oData = {};
    
        
                for (i = 0; i < nTotalElements; i++) {
        
                    sName = aElements[i].name;
        
                    /*
                        Using "Dom.getElementsBy" to safeguard user from JS 
                        errors that result from giving a form field (or set of 
                        fields) the same name as a native method of a form 
                        (like "submit") or a DOM collection (such as the "item"
                        method). Originally tried accessing fields via the 
                        "namedItem" method of the "element" collection, but 
                        discovered that it won't return a collection of fields 
                        in Gecko.
                    */
        
                    oElement = Dom.getElementsBy(isFormElement, "*", oForm);
                    nElements = oElement.length;
        
                    if (nElements > 0) {
        
                        if (nElements == 1) {
        
                            oElement = oElement[0];
        
                            sType = oElement.type;
                            sTagName = oElement.tagName.toUpperCase();
        
                            switch (sTagName) {
        
                            case "INPUT":
    
                                if (sType == "checkbox") {
    
                                    oData[sName] = oElement.checked;
    
                                }
                                else if (sType != "radio") {
    
                                    oData[sName] = oElement.value;
    
                                }
    
                                break;
    
                            case "TEXTAREA":
    
                                oData[sName] = oElement.value;
    
                                break;
    
                            case "SELECT":
    
                                aOptions = oElement.options;
                                nOptions = aOptions.length;
                                aValues = [];
    
                                for (n = 0; n < nOptions; n++) {
    
                                    oOption = aOptions[n];
    
                                    if (oOption.selected) {
    
                                        sValue = oOption.value;
    
                                        if (!sValue || sValue === "") {
    
                                            sValue = oOption.text;
    
                                        }
    
                                        aValues[aValues.length] = sValue;
    
                                    }
    
                                }
    
                                oData[sName] = aValues;
    
                                break;
        
                            }
        
        
                        }
                        else {
        
                            sType = oElement[0].type;
        
                            switch (sType) {
        
                            case "radio":
    
                                for (n = 0; n < nElements; n++) {
    
                                    oRadio = oElement[n];
    
                                    if (oRadio.checked) {
    
                                        oData[sName] = oRadio.value;
                                        break;
    
                                    }
    
                                }
    
                                break;
    
                            case "checkbox":
    
                                aValues = [];
    
                                for (n = 0; n < nElements; n++) {
    
                                    oCheckbox = oElement[n];
    
                                    if (oCheckbox.checked) {
    
                                        aValues[aValues.length] = 
                                            oCheckbox.value;
    
                                    }
    
                                }
    
                                oData[sName] = aValues;
    
                                break;
        
                            }
        
                        }
        
                    }
        
                }
        
            }
        
        
            return oData;
        
        },
        
        /**
        * Removes the Panel element from the DOM and sets all child elements 
        * to null.
        * @method destroy
        */
        destroy: function () {
        
            removeButtonEventHandlers.call(this);
            
            this._aButtons = null;

            var aForms = this.element.getElementsByTagName("form"),
                oForm;
            
            if (aForms.length > 0) {

                oForm = aForms[0];

                if (oForm) {
                    Event.purgeElement(oForm);
                    if (oForm.parentNode) {
                        oForm.parentNode.removeChild(oForm);
                    }
                    this.form = null;
                }
            }
        
            Dialog.superclass.destroy.call(this);  
        
        },
        
        /**
        * Returns a string representation of the object.
        * @method toString
        * @return {String} The string representation of the Dialog
        */
        toString: function () {
            return "Dialog " + this.id;
        }
    
    });

}());

(function () {

    /**
    * SimpleDialog is a simple implementation of Dialog that can be used to 
    * submit a single value. Forms can be processed in 3 ways -- via an 
    * asynchronous Connection utility call, a simple form POST or GET, 
    * or manually.
    * @namespace ISOFT.widget
    * @class SimpleDialog
    * @extends ISOFT.widget.Dialog
    * @constructor
    * @param {String} el The element ID representing the SimpleDialog 
    * <em>OR</em>
    * @param {HTMLElement} el The element representing the SimpleDialog
    * @param {Object} userConfig The configuration object literal containing 
    * the configuration that should be set for this SimpleDialog. See 
    * configuration documentation for more details.
    */
    ISOFT.widget.SimpleDialog = function (el, userConfig) {
    
        ISOFT.widget.SimpleDialog.superclass.constructor.call(this, 
            el, userConfig);
    
    };

    var Dom = ISOFT.util.Dom,
        SimpleDialog = ISOFT.widget.SimpleDialog,
    
        /**
        * Constant representing the SimpleDialog's configuration properties
        * @property DEFAULT_CONFIG
        * @private
        * @final
        * @type Object
        */
        DEFAULT_CONFIG = {
        
            "ICON": { 
                key: "icon", 
                value: "none", 
                suppressEvent: true  
            },
        
            "TEXT": { 
                key: "text", 
                value: "", 
                suppressEvent: true, 
                supercedes: ["icon"] 
            }
        
        };

    /**
    * Constant for the standard network icon for a blocking action
    * @property ISOFT.widget.SimpleDialog.ICON_BLOCK
    * @static
    * @final
    * @type String
    */
    SimpleDialog.ICON_BLOCK = "blckicon";
    
    /**
    * Constant for the standard network icon for alarm
    * @property ISOFT.widget.SimpleDialog.ICON_ALARM
    * @static
    * @final
    * @type String
    */
    SimpleDialog.ICON_ALARM = "alrticon";
    
    /**
    * Constant for the standard network icon for help
    * @property ISOFT.widget.SimpleDialog.ICON_HELP
    * @static
    * @final
    * @type String
    */
    SimpleDialog.ICON_HELP  = "hlpicon";
    
    /**
    * Constant for the standard network icon for info
    * @property ISOFT.widget.SimpleDialog.ICON_INFO
    * @static
    * @final
    * @type String
    */
    SimpleDialog.ICON_INFO  = "infoicon";
    
    /**
    * Constant for the standard network icon for warn
    * @property ISOFT.widget.SimpleDialog.ICON_WARN
    * @static
    * @final
    * @type String
    */
    SimpleDialog.ICON_WARN  = "warnicon";
    
    /**
    * Constant for the standard network icon for a tip
    * @property ISOFT.widget.SimpleDialog.ICON_TIP
    * @static
    * @final
    * @type String
    */
    SimpleDialog.ICON_TIP   = "tipicon";

    /**
    * Constant representing the name of the CSS class applied to the element 
    * created by the "icon" configuration property.
    * @property ISOFT.widget.SimpleDialog.ICON_CSS_CLASSNAME
    * @static
    * @final
    * @type String
    */
    SimpleDialog.ICON_CSS_CLASSNAME = "iba-icon";
    
    /**
    * Constant representing the default CSS class used for a SimpleDialog
    * @property ISOFT.widget.SimpleDialog.CSS_SIMPLEDIALOG
    * @static
    * @final
    * @type String
    */
    SimpleDialog.CSS_SIMPLEDIALOG = "iba-simple-dialog";

    
    ISOFT.extend(SimpleDialog, ISOFT.widget.Dialog, {
    
        /**
        * Initializes the class's configurable properties which can be changed 
        * using the SimpleDialog's Config object (cfg).
        * @method initDefaultConfig
        */
        initDefaultConfig: function () {
        
            SimpleDialog.superclass.initDefaultConfig.call(this);
        
            // Add dialog config properties //
        
            /**
            * Sets the informational icon for the SimpleDialog
            * @config icon
            * @type String
            * @default "none"
            */
            this.cfg.addProperty(DEFAULT_CONFIG.ICON.key, {
                handler: this.configIcon,
                value: DEFAULT_CONFIG.ICON.value,
                suppressEvent: DEFAULT_CONFIG.ICON.suppressEvent
            });
        
            /**
            * Sets the text for the SimpleDialog
            * @config text
            * @type String
            * @default ""
            */
            this.cfg.addProperty(DEFAULT_CONFIG.TEXT.key, { 
                handler: this.configText, 
                value: DEFAULT_CONFIG.TEXT.value, 
                suppressEvent: DEFAULT_CONFIG.TEXT.suppressEvent, 
                supercedes: DEFAULT_CONFIG.TEXT.supercedes 
            });
        
        },
        
        
        /**
        * The SimpleDialog initialization method, which is executed for 
        * SimpleDialog and all of its subclasses. This method is automatically 
        * called by the constructor, and  sets up all DOM references for 
        * pre-existing markup, and creates required markup if it is not 
        * already present.
        * @method init
        * @param {String} el The element ID representing the SimpleDialog 
        * <em>OR</em>
        * @param {HTMLElement} el The element representing the SimpleDialog
        * @param {Object} userConfig The configuration object literal 
        * containing the configuration that should be set for this 
        * SimpleDialog. See configuration documentation for more details.
        */
        init: function (el, userConfig) {

            /*
                Note that we don't pass the user config in here yet because we 
                only want it executed once, at the lowest subclass level
            */

            SimpleDialog.superclass.init.call(this, el/*, userConfig*/);
        
            this.beforeInitEvent.fire(SimpleDialog);
        
            Dom.addClass(this.element, SimpleDialog.CSS_SIMPLEDIALOG);
        
            this.cfg.queueProperty("postmethod", "manual");
        
            if (userConfig) {
                this.cfg.applyConfig(userConfig, true);
            }
        
            this.beforeRenderEvent.subscribe(function () {
                if (! this.body) {
                    this.setBody("");
                }
            }, this, true);
        
            this.initEvent.fire(SimpleDialog);
        
        },
        
        /**
        * Prepares the SimpleDialog's internal FORM object, creating one if one 
        * is not currently present, and adding the value hidden field.
        * @method registerForm
        */
        registerForm: function () {

            SimpleDialog.superclass.registerForm.call(this);

            this.form.innerHTML += "<input type=\"hidden\" name=\"" + 
                this.id + "\" value=\"\"/>";

        },
        
        // BEGIN BUILT-IN PROPERTY EVENT HANDLERS //
        
        /**
        * Fired when the "icon" property is set.
        * @method configIcon
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configIcon: function (type,args,obj) {
        
            var sIcon = args[0],
                oBody = this.body,
                sCSSClass = SimpleDialog.ICON_CSS_CLASSNAME,
                oIcon,
                oIconParent;
        
            if (sIcon && sIcon != "none") {

                oIcon = Dom.getElementsByClassName(sCSSClass, "*" , oBody);

                if (oIcon) {

                    oIconParent = oIcon.parentNode;
                    
                    if (oIconParent) {
                    
                        oIconParent.removeChild(oIcon);
                        
                        oIcon = null;
                    
                    }

                }


                if (sIcon.indexOf(".") == -1) {

                    oIcon = document.createElement("span");
                    oIcon.className = (sCSSClass + " " + sIcon);
                    oIcon.innerHTML = "&#160;";

                } else {

                    oIcon = document.createElement("img");
                    oIcon.src = (this.imageRoot + sIcon);
                    oIcon.className = sCSSClass;

                }
                

                if (oIcon) {
                
                    oBody.insertBefore(oIcon, oBody.firstElementChild);
                
                }

            }

        },
        
        /**
        * Fired when the "text" property is set.
        * @method configText
        * @param {String} type The CustomEvent type (usually the property name)
        * @param {Object[]} args The CustomEvent arguments. For configuration 
        * handlers, args[0] will equal the newly applied value for the property.
        * @param {Object} obj The scope object. For configuration handlers, 
        * this will usually equal the owner.
        */
        configText: function (type,args,obj) {
            var text = args[0];
            if (text) {
                this.setBody(text);
                this.cfg.refireEvent("icon");
            }
        },
        
        // END BUILT-IN PROPERTY EVENT HANDLERS //
        
        /**
        * Returns a string representation of the object.
        * @method toString
        * @return {String} The string representation of the SimpleDialog
        */
        toString: function () {
            return "SimpleDialog " + this.id;
        }
    
    });

}());

(function () {

    /**
    * ContainerEffect encapsulates animation transitions that are executed when 
    * an Overlay is shown or hidden.
    * @namespace ISOFT.widget
    * @class ContainerEffect
    * @constructor
    * @param {ISOFT.widget.Overlay} overlay The Overlay that the animation 
    * should be associated with
    * @param {Object} attrIn The object literal representing the animation 
    * arguments to be used for the animate-in transition. The arguments for 
    * this literal are: attributes(object, see ISOFT.util.Anim for description), 
    * duration(Number), and method(i.e. Easing.easeIn).
    * @param {Object} attrOut The object literal representing the animation 
    * arguments to be used for the animate-out transition. The arguments for  
    * this literal are: attributes(object, see ISOFT.util.Anim for description), 
    * duration(Number), and method(i.e. Easing.easeIn).
    * @param {HTMLElement} targetElement Optional. The target element that  
    * should be animated during the transition. Defaults to overlay.element.
    * @param {class} Optional. The animation class to instantiate. Defaults to 
    * ISOFT.util.Anim. Other options include ISOFT.util.Motion.
    */
    ISOFT.widget.ContainerEffect = 
    
        function (overlay, attrIn, attrOut, targetElement, animClass) {
    
        if (!animClass) {
            animClass = ISOFT.util.Anim;
        }
        
        /**
        * The overlay to animate
        * @property overlay
        * @type ISOFT.widget.Overlay
        */
        this.overlay = overlay;
    
        /**
        * The animation attributes to use when transitioning into view
        * @property attrIn
        * @type Object
        */
        this.attrIn = attrIn;
    
        /**
        * The animation attributes to use when transitioning out of view
        * @property attrOut
        * @type Object
        */
        this.attrOut = attrOut;
    
        /**
        * The target element to be animated
        * @property targetElement
        * @type HTMLElement
        */
        this.targetElement = targetElement || overlay.element;
    
        /**
        * The animation class to use for animating the overlay
        * @property animClass
        * @type class
        */
        this.animClass = animClass;
    
    };


    var Dom = ISOFT.util.Dom,
        CustomEvent = ISOFT.util.CustomEvent,
        Easing = ISOFT.util.Easing,
        ContainerEffect = ISOFT.widget.ContainerEffect;


    /**
    * A pre-configured ContainerEffect instance that can be used for fading 
    * an overlay in and out.
    * @method FADE
    * @static
    * @param {ISOFT.widget.Overlay} overlay The Overlay object to animate
    * @param {Number} dur The duration of the animation
    * @return {ISOFT.widget.ContainerEffect} The configured ContainerEffect object
    */
    ContainerEffect.FADE = function (overlay, dur) {

        var fin = {
            attributes: {opacity:{from:0, to:1}},
            duration: dur,
            method: Easing.easeIn
        };

        var fout = {
            attributes: {opacity:{to:0}},
            duration: dur,
            method: Easing.easeOut
        };

        var fade = new ContainerEffect(overlay, fin, fout, overlay.element);

        fade.handleUnderlayStart = function() {
            var underlay = this.overlay.underlay;
            if (underlay && ISOFT.env.ua.ie) {
                var hasFilters = (underlay.filters && underlay.filters.length > 0);
                if(hasFilters) {
                    Dom.addClass(overlay.element, "iba-effect-fade");
                }
            }
        };

        fade.handleUnderlayComplete = function() {
            var underlay = this.overlay.underlay;
            if (underlay && ISOFT.env.ua.ie) {
                Dom.removeClass(overlay.element, "iba-effect-fade");
            }
        };

        fade.handleStartAnimateIn = function (type,args,obj) {
            Dom.addClass(obj.overlay.element, "hide-select");

            if (!obj.overlay.underlay) {
                obj.overlay.cfg.refireEvent("underlay");
            }

            obj.handleUnderlayStart();

            Dom.setStyle(obj.overlay.element, "visibility", "visible");
            Dom.setStyle(obj.overlay.element, "opacity", 0);
        };

        fade.handleCompleteAnimateIn = function (type,args,obj) {
            Dom.removeClass(obj.overlay.element, "hide-select");

            if (obj.overlay.element.style.filter) {
                obj.overlay.element.style.filter = null;
            }

            obj.handleUnderlayComplete();

            obj.overlay.cfg.refireEvent("iframe");
            obj.animateInCompleteEvent.fire();
        };

        fade.handleStartAnimateOut = function (type, args, obj) {
            Dom.addClass(obj.overlay.element, "hide-select");
            obj.handleUnderlayStart();
        };

        fade.handleCompleteAnimateOut =  function (type, args, obj) {
            Dom.removeClass(obj.overlay.element, "hide-select");
            if (obj.overlay.element.style.filter) {
                obj.overlay.element.style.filter = null;
            }
            Dom.setStyle(obj.overlay.element, "visibility", "hidden");
            Dom.setStyle(obj.overlay.element, "opacity", 1);

            obj.handleUnderlayComplete();

            obj.overlay.cfg.refireEvent("iframe");
            obj.animateOutCompleteEvent.fire();
        };

        fade.init();
        return fade;
    };
    
    
    /**
    * A pre-configured ContainerEffect instance that can be used for sliding an 
    * overlay in and out.
    * @method SLIDE
    * @static
    * @param {ISOFT.widget.Overlay} overlay The Overlay object to animate
    * @param {Number} dur The duration of the animation
    * @return {ISOFT.widget.ContainerEffect} The configured ContainerEffect object
    */
    ContainerEffect.SLIDE = function (overlay, dur) {
    
        var x = overlay.cfg.getProperty("x") || Dom.getX(overlay.element),
    
            y = overlay.cfg.getProperty("y") || Dom.getY(overlay.element),
    
            clientWidth = Dom.getClientWidth(),
    
            offsetWidth = overlay.element.offsetWidth,
    
            slide = new ContainerEffect(overlay, 
            
            { attributes: { points: { to: [x, y] } },
                duration: dur,
                method: Easing.easeIn },
    
            { attributes: { points: { to: [(clientWidth + 25), y] } },
                duration: dur,
                method: Easing.easeOut },
    
            overlay.element, ISOFT.util.Motion);
        
        
        slide.handleStartAnimateIn = function (type,args,obj) {
            obj.overlay.element.style.left = ((-25) - offsetWidth) + "px";
            obj.overlay.element.style.top  = y + "px";
        };
        
        slide.handleTweenAnimateIn = function (type, args, obj) {
        
            var pos = Dom.getXY(obj.overlay.element),
                currentX = pos[0],
                currentY = pos[1];
        
            if (Dom.getStyle(obj.overlay.element, "visibility") == 
                "hidden" && currentX < x) {

                Dom.setStyle(obj.overlay.element, "visibility", "visible");

            }
        
            obj.overlay.cfg.setProperty("xy", [currentX, currentY], true);
            obj.overlay.cfg.refireEvent("iframe");
        };
        
        slide.handleCompleteAnimateIn = function (type, args, obj) {
            obj.overlay.cfg.setProperty("xy", [x, y], true);
            obj.startX = x;
            obj.startY = y;
            obj.overlay.cfg.refireEvent("iframe");
            obj.animateInCompleteEvent.fire();
        };
        
        slide.handleStartAnimateOut = function (type, args, obj) {
    
            var vw = Dom.getViewportWidth(),
                pos = Dom.getXY(obj.overlay.element),
                yso = pos[1];
    
            obj.animOut.attributes.points.to = [(vw + 25), yso];
        };
        
        slide.handleTweenAnimateOut = function (type, args, obj) {
    
            var pos = Dom.getXY(obj.overlay.element),
                xto = pos[0],
                yto = pos[1];
        
            obj.overlay.cfg.setProperty("xy", [xto, yto], true);
            obj.overlay.cfg.refireEvent("iframe");
        };
        
        slide.handleCompleteAnimateOut = function (type, args, obj) {
            Dom.setStyle(obj.overlay.element, "visibility", "hidden");
        
            obj.overlay.cfg.setProperty("xy", [x, y]);
            obj.animateOutCompleteEvent.fire();
        };
        
        slide.init();
        return slide;
    };
    
    ContainerEffect.prototype = {
    
        /**
        * Initializes the animation classes and events.
        * @method init
        */
        init: function () {

            this.beforeAnimateInEvent = this.createEvent("beforeAnimateIn");
            this.beforeAnimateInEvent.signature = CustomEvent.LIST;
            
            this.beforeAnimateOutEvent = this.createEvent("beforeAnimateOut");
            this.beforeAnimateOutEvent.signature = CustomEvent.LIST;
        
            this.animateInCompleteEvent = this.createEvent("animateInComplete");
            this.animateInCompleteEvent.signature = CustomEvent.LIST;
        
            this.animateOutCompleteEvent = 
                this.createEvent("animateOutComplete");
            this.animateOutCompleteEvent.signature = CustomEvent.LIST;
        
            this.animIn = new this.animClass(this.targetElement, 
                this.attrIn.attributes, this.attrIn.duration, 
                this.attrIn.method);

            this.animIn.onStart.subscribe(this.handleStartAnimateIn, this);
            this.animIn.onTween.subscribe(this.handleTweenAnimateIn, this);

            this.animIn.onComplete.subscribe(this.handleCompleteAnimateIn, 
                this);
        
            this.animOut = new this.animClass(this.targetElement, 
                this.attrOut.attributes, this.attrOut.duration, 
                this.attrOut.method);

            this.animOut.onStart.subscribe(this.handleStartAnimateOut, this);
            this.animOut.onTween.subscribe(this.handleTweenAnimateOut, this);
            this.animOut.onComplete.subscribe(this.handleCompleteAnimateOut, 
                this);

        },
        
        /**
        * Triggers the in-animation.
        * @method animateIn
        */
        animateIn: function () {
            this.beforeAnimateInEvent.fire();
            this.animIn.animate();
        },
        
        /**
        * Triggers the out-animation.
        * @method animateOut
        */
        animateOut: function () {
            this.beforeAnimateOutEvent.fire();
            this.animOut.animate();
        },
        
        /**
        * The default onStart handler for the in-animation.
        * @method handleStartAnimateIn
        * @param {String} type The CustomEvent type
        * @param {Object[]} args The CustomEvent arguments
        * @param {Object} obj The scope object
        */
        handleStartAnimateIn: function (type, args, obj) { },
    
        /**
        * The default onTween handler for the in-animation.
        * @method handleTweenAnimateIn
        * @param {String} type The CustomEvent type
        * @param {Object[]} args The CustomEvent arguments
        * @param {Object} obj The scope object
        */
        handleTweenAnimateIn: function (type, args, obj) { },
    
        /**
        * The default onComplete handler for the in-animation.
        * @method handleCompleteAnimateIn
        * @param {String} type The CustomEvent type
        * @param {Object[]} args The CustomEvent arguments
        * @param {Object} obj The scope object
        */
        handleCompleteAnimateIn: function (type, args, obj) { },
        
        /**
        * The default onStart handler for the out-animation.
        * @method handleStartAnimateOut
        * @param {String} type The CustomEvent type
        * @param {Object[]} args The CustomEvent arguments
        * @param {Object} obj The scope object
        */
        handleStartAnimateOut: function (type, args, obj) { },
    
        /**
        * The default onTween handler for the out-animation.
        * @method handleTweenAnimateOut
        * @param {String} type The CustomEvent type
        * @param {Object[]} args The CustomEvent arguments
        * @param {Object} obj The scope object
        */
        handleTweenAnimateOut: function (type, args, obj) { },
    
        /**
        * The default onComplete handler for the out-animation.
        * @method handleCompleteAnimateOut
        * @param {String} type The CustomEvent type
        * @param {Object[]} args The CustomEvent arguments
        * @param {Object} obj The scope object
        */
        handleCompleteAnimateOut: function (type, args, obj) { },
        
        /**
        * Returns a string representation of the object.
        * @method toString
        * @return {String} The string representation of the ContainerEffect
        */
        toString: function () {
            var output = "ContainerEffect";
            if (this.overlay) {
                output += " [" + this.overlay.toString() + "]";
            }
            return output;
        }
    
    };

    ISOFT.lang.augmentProto(ContainerEffect, ISOFT.util.EventProvider);

})();

ISOFT.register("container", ISOFT.widget.Module, {version: "2.5.2", build: "1076"});

