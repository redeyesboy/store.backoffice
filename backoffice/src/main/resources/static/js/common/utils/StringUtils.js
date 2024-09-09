/**
 *
 */
class StringUtils {

	constructor ( ) {

	}

	static isEmpty ( value ) {
		let _result = true;
		if ( value != null && typeof value != 'undefined' ) {
			const str = (value).toString().trim();
			if ( str.length > 0 ) {
				_result = false;
			}
		}
		return _result;
	}

	static isNotEmpty ( value ) {
		return !this.isEmpty(value);
	}

	static nvl ( value, replaceValue ) {
		return this.isEmpty(value) ? replaceValue : value;
	}

}