/**
 *
 */
$.fn.isExists = function ( ) {
	return $(this).length > 0
}

$.fn.isNotExists = function () {
	return !$(this).isExists();
}