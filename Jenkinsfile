node("linux && jdk8") {
    stage "Checkout"
    git url: "https://github.com/roamingthings/workbench-cicd.git"

    dir('workbench-cicd-server') {
        stage "Build/Analyse/Test"
        sh "./gradlew clean build"
        archiveUnitTestResults()

        stage "Integration Test"
        sh "./gradlew integrationtest"
    }

/*
    dir('workbench-cicd-st') {
        stage "System Tests"
        sh "./gradlew clean build"
        archiveUnitTestResults()

        sh "./gradlew integrationtest"
    }
*/

}

def archiveUnitTestResults() {
    step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}
