/**
 *
 */
class AjaxUtils {

	constructor ( ) {

	}

	static getHtml ( type, url, config={} ) {
		return AjaxUtils.getAjax( type, url, 'html', config);
	}

	static getAjax ( type, url, dataType, config={} ) {
		config.type = type;
		config.url = url;
		config.dataType = dataType;
		return AjaxUtils._getAjax(config);
	}

	static _getAjax ( config ) {
		config.isBlock = ( typeof config.isBlock == 'boolean' ) ? config.isBlock : true;
		config.isErrorAlert = ( typeof config.isErrorAlert == 'boolean' ) ? config.isErrorAlert : true;
		config.async = ( typeof config.async == 'boolean' ) ? config.async : false;
		config.processData = ( typeof config.processData == 'boolean' ) ? config.processData : true;
		config.contentType = ( typeof config.contentType == 'undefined' ) ? 'application/x-www-form-urlencoded; charset=UTF-8' : config.contentType;
		config.enctype = ( typeof config.enctype == 'undefined' ) ? 'application/x-www-form-urlencoded' : config.enctype;
		return new Promise( ( resolve, reject ) => {
			$.ajax({
				type: config.type,
				url: config.url,
				data: config.data,
				cache: false,
				async: config.async,
				processData: config.processData,
				contentType: config.contentType,
				enctype: config.enctype,
				dataType: config.dataType,
				headers : config.headers,
				beforeSend: ( jqXHR, settings ) => {

				},
				success: ( data, textStatus, jqXHR ) => {
					resolve( data );
				},
				complete: ( jqXHR, textStatus ) => {

				},
				error: ( jqXHR, textStatus, errorThrown  ) => {
					if ( config.isErrorAlert ) {
						alert( '잠시 후 다시 시도해 주세요.' );
					}
					reject( jqXHR );
				}
			});
		});
	}

}