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

    @Unroll('When reviewedByCustomer is #reviewedByCustomer and approvedByCustomer is #approvedByCustomer then reviewStatus should be #reviewStatus')
    void "test retrieving the value of the enum property"() {
        given:
        def timesheet = new Timesheet(reviewedByCustomer: reviewedByCustomer,
                                      approvedByCustomer: approvedByCustomer)

        expect:
        timesheet.reviewStatus == reviewStatus

        where:
        reviewStatus                | reviewedByCustomer | approvedByCustomer
        ReviewStatus.APPROVED       | true               | true
        ReviewStatus.DENIED         | true               | false
        ReviewStatus.TO_BE_REVIEWED | false              | null
    }
}
