/**
 *
 */
class UiUtils {

	constructor ( ) {

	}

	static alert ( { message, fnClose } ) {
		const _id = kendo.guid();
		$('body').append(`<div id="${_id}"></div>`);
		$(`#${_id}`).kendoDialog({
			title: 'My Store',
			minHeight: 180,
			minWidth: 300,
			maxWidth: 600,
			closable: false,
			modal: true,
			content: `<div style="height:100%; display:flex; align-items: center; justify-content: center;"><b>${message}</b></div>`,
			actions: [
				{
					text: '확인',
					action: ( ) => {
						$(`#${_id}`).data("kendoDialog").close();
					}
				}
			],
			close: ( e ) => {
				$(`#${_id}`).data("kendoDialog").destroy();
				if ( typeof fnClose == 'function' ) {
					fnClose.call(e);
				}
			}
		}).data("kendoDialog").open();
	}

}