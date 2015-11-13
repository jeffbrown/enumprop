package demo

class Timesheet {
    Boolean reviewedByCustomer
    Boolean approvedByCustomer

    static transients = ['reviewStatus']

    ReviewStatus getReviewStatus(){
        if(reviewedByCustomer == false && approvedByCustomer == null){
            ReviewStatus.TO_BE_REVIEWED
        } else if(reviewedByCustomer == true && approvedByCustomer == true){
            ReviewStatus.APPROVED
        } else if(reviewedByCustomer == true && approvedByCustomer == false){
            ReviewStatus.DENIED
        }
    }

    void setReviewStatus(ReviewStatus reviewStatus){
        if(reviewStatus == ReviewStatus.TO_BE_REVIEWED){
            reviewedByCustomer = false
            approvedByCustomer = null
        } else if(reviewStatus == ReviewStatus.APPROVED){
            reviewedByCustomer = true
            approvedByCustomer = true
        } else if(reviewStatus == ReviewStatus.DENIED){
            reviewedByCustomer = true
            approvedByCustomer = false
        }
    }
}
