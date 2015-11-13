package demo

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Timesheet)
class TimesheetSpec extends Specification {

    @Unroll('When reviewStatus is #reviewStatus reviewedByCustomer should be #reviewedByCustomer and approvedByCustomer should be #approvedByCustomer')
    void "test enum property binding"() {
        given:
        def timesheet = new Timesheet(reviewStatus: reviewStatus)

        expect:
        timesheet.reviewedByCustomer == reviewedByCustomer
        timesheet.approvedByCustomer == approvedByCustomer

        where:
        reviewStatus     | reviewedByCustomer | approvedByCustomer
        'APPROVED'       | true               | true
        'DENIED'         | true               | false
        'TO_BE_REVIEWED' | false              | null
    }
}
