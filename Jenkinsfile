node('java8') {

    stage('Configure') {
        env.PATH = "${tool 'gradle-3.5'}/bin:${env.PATH}"
    }

    stage('Checkout') {
        git 'https://github.com/roamingthings/workbench-cicd.git'
    }

    stage('Build') {
        sh 'gradle clean build'
    }

    stage('Archive') {
        junit allowEmptyResults: true, testResults: '**/target/**/TEST*.xml'
    }

}