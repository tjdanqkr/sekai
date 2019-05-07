/**
 * Ajax util
 */


/**
 * common create namespace
 */
$.namespace = function() {
	var a = arguments, o = null, i, j, d;
	for (i = 0; i < a.length; i = i + 1) {
		d = a[i].split(".");
		o = window;
		for (j = 0; j < d.length; j = j + 1) {
			o[d[j]] = o[d[j]] || {};
			o = o[d[j]];
		}
	}

	return o;
};

/**
 * common create namespace
 */
$.createNamespace = function ( ns, ns_string ) {
    var parts = ns_string.split("."),
        parent = ns,
        i;
    if (parts[0] === "b2" ) {
        parts = parts.slice(1);
    }

    for (i = 0; i < parts.length; i++) {
        //create a property if it doesnt exist
        if (typeof parent[parts[i]] === "undefined") {
            parent[parts[i]] = {};
        }
        parent = parent[parts[i]];
    }
    return parent;
};




var AjaxTimeout = 30000; //20180112 const에서 var로 변경  (사유:IE10에서 지원 안함)
$.namespace("b2.common");
(function(w, d, $, pns, ns) {
"use strict";

	var ajaxUtil = {
		init: function() {
			var that = this;
			window.unload = function() {
				that.allAbortAjax();
			};
		},
		ajaxArray: [],
		allAbortAjax: function() {
			var that = this;
			$.each(that.ajaxArray, function() {
				var ajaxObj = this;
				ajaxObj.abort();
			});
		},
		getAjaxObj : function(_method, _url, _data , _cache) {
			var that = this,
				_token =  $("meta[name='_csrf']").attr("content"),
		    	_header =  $("meta[name='_csrf_header']").attr("content"),
		    	ajaxObj;
			
			_cache = typeof _cache === "undefined" ? true : _cache;

			window.console.log(_token);
			window.console.log(_header);
			ajaxObj = $.ajax({
				type : _method,
				url : _url,
				xhrFields : {
					withCredentials : true
				},
				cache: _cache,
				timeout : AjaxTimeout,
				data : _data				
			});

			that.ajaxArray.push(ajaxObj);
			return ajaxObj;
		},

		sendRequest : function(_method, _url, _data, _callback , _cache) {
			var that = this,
				_token =  $("meta[name='_csrf']").attr("content"),
		    	_header =  $("meta[name='_csrf_header']").attr("content"),
		    	ajaxObj;
			
			_cache = typeof _cache === "undefined" ? true : _cache;

			ajaxObj = $.ajax({
				type : _method,
				url : _url,
				xhrFields : {
					withCredentials : true
				},
				data : _data,
				cache: _cache,
				timeout : AjaxTimeout,
				success : function(response) {
					that.proceed(response, _callback);
				},
				error : function(jqXHR, error, errorThrown) {
					that.error(jqXHR, error, errorThrown);
					that.after();
				},
				beforeSend : function(request) {
					if (_header !== null && _header !== "" ) {
						request.setRequestHeader(_header, _token);
					}
					that.before();
				},
				complete : function() {
					that.after();
				}
			});

			that.ajaxArray.push(ajaxObj);
			return ajaxObj;
		},

		sendJSONRequest : function(_method, _url, _data, _callback, _async, _cache, _referer) {
			var that = this,
				_token =  $("meta[name='_csrf']").attr("content"),
		    	_header =  $("meta[name='_csrf_header']").attr("content"),
		    	ajaxObj;

			_async = typeof _async === "undefined" ? true : _async;
			_cache = typeof _cache === "undefined" ? true : _cache;
			_referer = typeof _referer === "undefined" ? "" : _referer;

		    if(/post/i.test(_method)) {
		    	_data = typeof _data === "string" ? _data : JSON.stringify(_data);
		    }

			ajaxObj = $.ajax({
				type : _method,
				url : _url,
				xhrFields : {
					withCredentials : true
				},
				data : _data,
				async : _async,
				cache: _cache,
				timeout : AjaxTimeout,
				contentType : 'application/json;charset=UTF-8',
				dataType : "json",
				success : function(response) {
					that.proceed(response, _callback);
				},
				error : function(jqXHR, error, errorThrown) {
					that.error(jqXHR, error, errorThrown, _callback);
				},
				beforeSend : function(request) {
					if (_header !== null && _header !== "" ) {
						request.setRequestHeader(_header, _token);
					}
					if (_referer !== null && _referer !== "" ) {
						request.setRequestHeader('X-Alt-Referer', _referer);
					}
					that.before();
				}
				, complete : function() {
					that.after();
				}
			});

			that.ajaxArray.push(ajaxObj);
			return ajaxObj;
		},
		
		sendMultiPartJSONRequest : function(_method, _url, _data, _callback, _async ,_cache) {
			var that = this,
				_token =  $("meta[name='_csrf']").attr("content"),
		    	_header =  $("meta[name='_csrf_header']").attr("content"),
		    	ajaxObj;
			_async = typeof _async === "undefined" ? true : _async;
			_cache = typeof _cache === "undefined" ? true : _cache;
			
			
			ajaxObj = $.ajax({
				type : _method,
				url : _url,
				xhrFields : {
					withCredentials : true
				},
				data : _data,
				async : _async,
				dataType : "json",
				cache: _cache,
				timeout : AjaxTimeout,
				processData: false,
				contentType: false,
				success : function(response) {
					that.proceed(response, _callback);
				},
				error : function(jqXHR, error, errorThrown) {
					that.error(jqXHR, error, errorThrown);
				},
				beforeSend : function(request) {
					if (_header !== null && _header !== "" ) {
						request.setRequestHeader(_header, _token);
					}
					that.before();
				},
				complete : function() {
					that.after();
				}
			});

			that.ajaxArray.push(ajaxObj);
			return ajaxObj;
		},

		/**
		 * 순차적으로 여러 개의 ajax 요청을 전송할 때 사용한다. ajax 객체를 생성하기 위해
		 * commerce.admin.common.Ajax.getAjaxObj 메소드를 사용할 수도 있다. 사용 방법은 다음과 같다.
		 *
		 * //1. 순차적으로 동작할 ajax 호출을 작성하고 배열에 입력한다. var ajax1 = $.ajax(CONSTANTS.baseUrl +
		 * "/board/listJSON.do"); var ajax2 = $.ajax(CONSTANTS.baseUrl +
		 * "/board/listJSON.do"); var requests = [ajax1, ajax2];
		 *
		 * //2. 구현된 callback 메소드를 각각 순서대로 배열에 입력한다. var callbacks =
		 * [commerce.front.BoardList._callback_getBoardList,
		 * commerce.front.BoardList._callback_getBoardList];
		 *
		 * //3. commerce.admin.common.Ajax.sendMultipleRequest를 호출한다.
		 * commerce.admin.common.Ajax.sendMultipleRequest(requests, callbacks);
		 *
		 * @param _requests
		 * @param _callbacks
		 */
		sendMultipleRequest : function(_requests, _callbacks) {
			var that = this;
			return $.when.apply(undefined, _requests).done(function() {
				for (var i = 0; i < arguments.length; i++) {
					that.proceed(arguments[i][0], _callbacks[i]);
				}
			});
		},

		/**
		 * JSONP 요청을 전송하는 메소드
		 *
		 * @param _method
		 * @param _url
		 * @param _data
		 * @param _callback
		 */
		sendJsonpRequest : function(_method, _url, _data, _callback , _cache) {
			var that = this,
				_token =  $("meta[name='_csrf']").attr("content"),
		    	_header =  $("meta[name='_csrf_header']").attr("content"),
		    	ajaxObj;
			
			_cache = typeof _cache === "undefined" ? true : _cache;

			window.console.log(_token);
			window.console.log(_header);
			ajaxObj = $.ajax({
				type : _method,
				url : _url,
				xhrFields : {
					withCredentials : true
				},
				data : _data,
				cache: _cache,
				dataType : "jsonp",
				timeout : AjaxTimeout,
				success : function(response) {
					that.proceed(response, _callback, true);
				},
				error : function(jqXHR, error, errorThrown) {
					that.error(jqXHR, error, errorThrown);
				}
			});

			that.ajaxArray.push(ajaxObj);
			return ajaxObj;
		},

		proceed : function(response, _callback, isJSONP) {
			var that = this;
			window.console.log(that);
			window.console.log(isJSONP);
			if(typeof _callback === "function"){
				_callback(response);
			}
		},

		error : function(xhr, status, error, _callback) {
			if (xhr) {
				if (xhr.status === "403") {
					window.console.warn("ACCESS Denied.");
				} else if (xhr.status === "404") {
					window.console.warn("Page Not Found.");
				} else if (xhr.status === "500") {
					var resObj500 = xhr.responseText ? $.parseJSON(xhr.responseText) : {message: error, code: xhr.status,succeed: false};
					if(typeof _callback === "function"){
						_callback(resObj500);
					}
					window.console.warn("Error : " + $.parseJSON(xhr.responseText).message);
				} else if (xhr.status === "900") {
					window.console.warn("needs login.");
				} else if (xhr.status === "400") {
					var resObj400 = xhr.responseText ? $.parseJSON(xhr.responseText) : {message: error, code: xhr.status,succeed: false};
					if(typeof _callback === "function"){
						_callback(resObj400);
					}
				} else {
					window.console.warn("Unknown Error Occurred.");
				}
			} else {
				window.console.warn("Unknown Error Occurred.");
			}
		},

		before : function() {
			var self = this;
			window.console.log(self);
		},

		after : function() {
			var self = this;
			window.console.log(self);
		},

		getJSON : function(text) {
			try {
				if (!text) {
					return false;
				}
				var obj = eval(text);

				// 에러가 발생했다면 "error"라는 key 이름으로 object에 value가 입력되어 있다고 가정한다.
				if (obj.error) {
					window.alert("비동기 통신에 문제가 생겼습니다. [" + obj.error + "]");

					return;
				}

				if (typeof obj === "object")
					return obj;
			} catch (e) {
				return false;
			}
		}
	};

	$.createNamespace(pns, ns);
	pns[ns] = ajaxUtil;
	pns[ns].init();
})(window, document, jQuery, b2.common, "Ajax");


