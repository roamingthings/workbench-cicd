node("linux && jdk8") {
    stage "Checkout"
    git url: "https://github.com/instil/jenkins-pipeline-dsl-plugin"

    stage "Build/Analyse/Test"
    sh "./gradlew clean build"
    archiveUnitTestResults()
    archiveCheckstyleResults()

    stage "Generate AMI"
    sh "./gradlew boxfuseFuse"

    stage name: "Deploy to AWS", concurrency: 1
    sh "./gradlew boxfuseRun"
}

def archiveUnitTestResults() {
    step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}

def archiveCheckstyleResults() {
    step([$class: "CheckStylePublisher",
          canComputeNew: false,
          defaultEncoding: "",
          healthy: "",
          pattern: "build/reports/checkstyle/main.xml",
          unHealthy: ""])
}
