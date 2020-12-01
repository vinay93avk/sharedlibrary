import com.test.pipeline.ConstantsGeneric

def call(String buildStyle) {
    pipeline {
        // agent any
        agent { docker 'maven:3-alpine' }

            stage('Main') {
                step {
                    script {
                        config['buildStyle'] = buildStyle
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

        // post {
        //     always {
        //         sendNotifications currentBuild.result
        //     }
        // }
    }
}