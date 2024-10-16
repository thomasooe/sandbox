import { Directive } from "@angular/core";

@Directive({
    selector: 'a[appSafeLink]',
    standalone: true,
    host: {
        '(click)': 'onConfirmLeavePage($event)'
    }
})
export class SafeLinkDirective{
    constructor() {
        console.log("SafeLinkDirective is active");
        
    }

    onConfirmLeavePage(event: MouseEvent) {
        const wantsToLEave = window.confirm('Do you want to leave the app');

        if (wantsToLEave) {
            return;
        }

        event.preventDefault();
    }
}