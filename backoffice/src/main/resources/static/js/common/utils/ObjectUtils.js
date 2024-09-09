/**
 *
 */
class ObjectUtils {

	constructor ( ) {

	}

	static isEmpty ( value ) {
		if(typeof value == 'undefined' || value == null) {
			return true
		} else if(Array.isArray(value) && value.length == 0) {
			return true
		} else if(typeof value == 'object' && Object.keys(value).length == 0) {
			return true
		} else if(typeof value == 'string' && (value).toString().trim().length == 0) {
			return true
		}
		return false
	}

	static isNotEmpty ( value ) {
		return !this.isEmpty(value);;
	}

}