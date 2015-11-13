package demo

class DemoController {

    def index() {
        render view: 'timesheet', model: [timesheet: new Timesheet(params)]
    }
}
