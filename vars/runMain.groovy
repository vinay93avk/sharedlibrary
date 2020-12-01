import com.test.pipeline.ConstantsGeneric

def call(String buildStyle) {
    pipeline {
        // agent any

            stage('Main') {
                step {
                    script {
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