package demo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DemoController)
class DemoControllerSpec extends Specification {

    void "test enum binding APPROVED"() {
        when:
        params.reviewStatus = 'APPROVED'
        controller.index()

        then:
        model.timesheet.reviewedByCustomer == true
        model.timesheet.approvedByCustomer == true
        model.timesheet.reviewStatus == ReviewStatus.APPROVED
    }

    void "test enum binding TO_BE_REVIEWED"() {
        when:
        params.reviewStatus = 'TO_BE_REVIEWED'
        controller.index()

        then:
        model.timesheet.reviewedByCustomer == false
        model.timesheet.approvedByCustomer == null
        model.timesheet.reviewStatus == ReviewStatus.TO_BE_REVIEWED
    }

    void "test enum binding DENIED"() {
        when:
        params.reviewStatus = 'DENIED'
        controller.index()

        then:
        model.timesheet.reviewedByCustomer == true
        model.timesheet.approvedByCustomer == false
        model.timesheet.reviewStatus == ReviewStatus.DENIED
    }
}
