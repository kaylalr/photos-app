export const SNACKBARS = {
    ERROR: {
        y: 'top',
        x: null,
        mode: '',
        timeout: 5000,
        text: '',
        color: 'red',
        fontClass: 'secondary--text'
    },
    SUCCESS: {
        y: 'top',
        x: null,
        mode: '',
        timeout: 5000,
        text: '',
        color: 'green',
        fontClass: 'secondary--text'
    },
    WARNING: {
        y: 'top',
        x: null,
        mode: '',
        timeout: 5000,
        text: '',
        color: 'yellow',
        fontClass: 'secondary--text'
    }
}
export function getSnackbar(type, text) {
    //if you need a custom snackbar build it in your component
    let snackbar = SNACKBARS[type]
    snackbar.text = text
    snackbar.enabled = true
    return snackbar
}