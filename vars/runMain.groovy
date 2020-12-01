import com.test.pipeline.ConstantsGeneric

def call(String buildStyle) {
    pipeline {
        // agent any

        stages {
            stage('Main') {
                steps {
                    script {
                        def project = buildStyle.split("-")
                        config['buildStyle'] = buildStyle
                        stage('Checkout') {
                            checkout scm
                        }
                        config['gitBranchRaw'] = GIT_BRANCH
                        config['gitBranch'] = GIT_BRANCH.replaceAll('\\/','-').trim()
                        config['gitCommitId'] = GIT_COMMIT
                        println("${config.gitBranch}-${config.gitCommitId}")
                        
                        if(config.buildStyle == 'pipeline') {
                            pipeline(config)
                        } else if(config.buildStyle == 'pipeline2') {
                            pipeline2(config)
                        }
                    }
                }
            }
        }

        // post {
        //     always {
        //         sendNotifications currentBuild.result
        //     }
        // }
    }
}