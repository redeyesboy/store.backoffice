/**
 *
 */
class UiUtils {

	constructor ( ) {

	}

	static alert ( param ) {
		if ( typeof param == 'string' ) {
			UiUtils._alert({ message: param });
		} else if ( typeof param == 'object' ) {
			UiUtils._alert(param);
		}
	}

	static _alert ( { message, fnClose } ) {
		const _id = kendo.guid();
		$('body').append(`<div id="${_id}"></div>`);
		$(`#${_id}`).kendoDialog({
			title: 'My Store',
			themeColor: 'primary',
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

	static confirm ( { message, fnAgree, fnDisAgree } ) {
		const _id = kendo.guid();
		$('body').append(`<div id="${_id}"></div>`);
		$(`#${_id}`).kendoDialog({
			title: 'My Store',
			themeColor: 'primary',
			minHeight: 180,
			minWidth: 300,
			maxWidth: 600,
			closable: false,
			modal: true,
			content: `<div style="height:100%; display:flex; align-items: center; justify-content: center;"><b>${message}</b></div>`,
			actions: [
				{
					text: '확인',
					primary: true,
					action: ( ) => {
						$(`#${_id}`).attr('data-closeType', 'agree');
						$(`#${_id}`).data("kendoDialog").close();
					}
				},
				{
					text: '취소',
					action: ( ) => {
						$(`#${_id}`).attr('data-closeType', 'disAgree');
						$(`#${_id}`).data("kendoDialog").close();
					}
				}
			],
			close: ( e ) => {
				const closeType = $(`#${_id}`).attr('data-closeType');
				$(`#${_id}`).data("kendoDialog").destroy();
				if ( closeType == 'agree' ) {
					if ( typeof fnAgree == 'function' ) {
						fnAgree.call(e);
					}
				} else if ( closeType == 'disAgree' ) {
					if ( typeof fnDisAgree == 'function' ) {
						fnDisAgree.call(e);
					}
				}
			}
		}).data("kendoDialog").open();
	}

}