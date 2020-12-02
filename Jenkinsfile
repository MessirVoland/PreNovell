pipeline {
  agent any
  stages {
    stage('Stage 1') {
      steps {
        withGradle() {
          build 'Job'
        }

      }
    }

    stage('Stage 2') {
      steps {
        echo 'Complete?'
      }
    }

  }
}